package info.aalmoghalis.inventory.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.stats.CodePackage;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.itextpdf.text.pdf.PdfBoolean;
import defpackage.AbstractC0605Iq;
import defpackage.C1798bX;
import defpackage.MC;
import defpackage.PB;
import defpackage.TD;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.activity.Google_drive_list;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MyGcmPushReceiver extends FirebaseMessagingService {
    public TD a;
    public SQLiteDatabase b;
    public Z00 c;

    public final void a(String str, boolean z, String str2) {
        if (z) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("chat_room_id");
            JSONObject jSONObject2 = jSONObject.getJSONObject("message");
            PB pb = new PB();
            pb.l(jSONObject2.getString("message"));
            pb.k(jSONObject2.getString("message_id"));
            pb.j(jSONObject2.getString("created_at"));
            pb.m(jSONObject2.getString("reply_id"));
            pb.n(jSONObject2.getString("reply_msg"));
            pb.o(jSONObject2.getString("reply_to"));
            JSONObject jSONObject3 = jSONObject.getJSONObject("user");
            C1798bX c1798bX = new C1798bX();
            c1798bX.i(jSONObject3.getString("user_id"));
            c1798bX.h(jSONObject3.getString("email"));
            c1798bX.j(jSONObject3.getString("name"));
            pb.p(c1798bX);
            Z00 z00 = new Z00(this.b, getApplicationContext());
            this.c = z00;
            z00.v0("insert into messages (chat_room_id,user_name,user_id,message,created_at,server_id,reply_id,reply_msg,reply_to) values ( '" + string + "','" + pb.i().e() + "','" + pb.i().b() + "','" + pb.c() + "','" + pb.a() + "','" + pb.b() + "','" + pb.e() + "','" + pb.f() + "','" + pb.h() + "');");
            if (TD.d(getApplicationContext())) {
                Intent intent = new Intent(getApplicationContext(), (Class<?>) MainActivity.class);
                int iB = new MC(getApplicationContext()).b() + 1;
                new MC(getApplicationContext()).e(iB);
                if (iB == 1) {
                    f(getApplicationContext(), str, c1798bX.e() + " : " + pb.c(), pb.a(), intent);
                } else {
                    f(getApplicationContext(), str, "(" + String.valueOf(iB) + ") : " + getString(R.string.support), pb.a(), intent);
                }
            } else {
                Intent intent2 = new Intent("pushNotification");
                intent2.putExtra("type", 1);
                intent2.putExtra("message", pb);
                intent2.putExtra("chat_room_id", string);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
                new TD();
            }
        } catch (JSONException e) {
            Log.e(CodePackage.GCM, "json parsing error: " + e.getMessage());
            Toast.makeText(getApplicationContext(), "Json parse error: " + e.getMessage(), 1).show();
        }
    }

    public final void b(String str, boolean z, String str2) {
        if (z) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("image");
            JSONObject jSONObject2 = jSONObject.getJSONObject("message");
            PB pb = new PB();
            pb.l(jSONObject2.getString("message"));
            pb.k(jSONObject2.getString("message_id"));
            pb.j(jSONObject2.getString("created_at"));
            JSONObject jSONObject3 = jSONObject.getJSONObject("user");
            C1798bX c1798bX = new C1798bX();
            c1798bX.i(jSONObject3.getString("user_id"));
            c1798bX.h(jSONObject3.getString("email"));
            c1798bX.j(jSONObject3.getString("name"));
            pb.p(c1798bX);
            String string2 = jSONObject3.getString("user_id");
            Z00 z00 = new Z00(this.b, getApplicationContext());
            this.c = z00;
            z00.v0("insert into user_messages (chat_room_id,user_name,user_id,message,created_at) values ( '" + string2 + "','" + pb.i().e() + "','" + pb.i().b() + "','" + pb.c() + "','" + pb.a() + "');");
            if (TD.d(getApplicationContext())) {
                Intent intent = new Intent(getApplicationContext(), (Class<?>) MainActivity.class);
                int iB = new MC(getApplicationContext()).b() + 1;
                new MC(getApplicationContext()).e(iB);
                if (!TextUtils.isEmpty(string)) {
                    g(getApplicationContext(), str, pb.c(), pb.a(), intent, string);
                } else if (iB == 0) {
                    f(getApplicationContext(), str, c1798bX.e() + " : " + pb.c(), pb.a(), intent);
                } else {
                    f(getApplicationContext(), str, "(" + String.valueOf(iB) + ") : " + getString(R.string.support), pb.a(), intent);
                }
            } else {
                Intent intent2 = new Intent("pushNotification");
                intent2.putExtra("type", 2);
                intent2.putExtra("message", pb);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
                new TD().e();
            }
        } catch (JSONException e) {
            Log.e(CodePackage.GCM, "json parsing error: " + e.getMessage());
            Toast.makeText(getApplicationContext(), "Json parse error: " + e.getMessage(), 1).show();
        }
    }

    public void c(String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public final void d(String str, int i, String str2, String str3, String str4) {
        if (str.equals("")) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) FragmentStatePagerSupport_Main.class);
        if (i == 2) {
            intent = new Intent(this, (Class<?>) Google_drive_list.class);
            intent.putExtra("bk_flag", "1");
            intent.putExtra("auto_filename", "");
        } else if (i == 3) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
        } else if (i == 10) {
            intent.putExtra("open_activation", true);
            intent.putExtra("email", str3);
            intent.putExtra("aid", str4);
        }
        intent.addFlags(67108864);
        int i2 = Build.VERSION.SDK_INT;
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, i2 >= 23 ? 201326592 : 134217728);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (i2 >= 26) {
            NotificationChannel notificationChannelA = AbstractC0605Iq.a("my_channel_id_02", "My Notifications", 3);
            notificationChannelA.setDescription(str);
            notificationChannelA.enableLights(true);
            notificationChannelA.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannelA.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannelA.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "my_channel_id_02");
        builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle(getString(R.string.app_name)).setContentText(str).setAutoCancel(true).setContentIntent(activity);
        notificationManager.notify(0, builder.build());
    }

    public final void e(String str, String str2, String str3) {
        Intent intent = new Intent(this, (Class<?>) FragmentStatePagerSupport_Main.class);
        intent.addFlags(67108864);
        f(getApplicationContext(), str, str2, str3, intent);
    }

    public final void f(Context context, String str, String str2, String str3, Intent intent) {
        this.a = new TD(context);
        intent.setFlags(268468224);
        this.a.g(str, str2, str3, intent);
    }

    public final void g(Context context, String str, String str2, String str3, Intent intent, String str4) {
        this.a = new TD(context);
        intent.setFlags(268468224);
        this.a.h(str, str2, str3, intent, str4);
    }

    public final void h() {
        FirebaseMessaging.getInstance().subscribeToTopic("inv_app");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("receive=", "onMessageReceived");
        try {
            if (remoteMessage.getNotification() == null || remoteMessage.getNotification().getBody().length() <= 1) {
                Map<String, String> data = remoteMessage.getData();
                String str = "0";
                int i = Integer.parseInt(data.get("action_type") == null ? "0" : data.get("action_type"));
                String str2 = data.get("url") == null ? "0" : data.get("url");
                String str3 = data.get("email") == null ? "0" : data.get("email");
                if (data.get("aid") != null) {
                    str = data.get("aid");
                }
                d(data.get("data") == null ? "" : data.get("data").toString(), i, str2, str3, str);
            } else {
                e(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody(), remoteMessage.getSentTime() + "");
            }
            String from = remoteMessage.getFrom();
            String string = getString(R.string.app_name);
            Map<String, String> data2 = remoteMessage.getData();
            String str4 = data2.get("flag");
            if (str4 == null) {
                Log.e(CodePackage.GCM, "Missing 'flag' in FCM data: " + data2);
                return;
            }
            boolean zEqualsIgnoreCase = PdfBoolean.TRUE.equalsIgnoreCase(data2.get("is_background"));
            String str5 = data2.get("data") != null ? data2.get("data") : "";
            Log.d(CodePackage.GCM, "From: " + from);
            Log.d(CodePackage.GCM, "title: " + string);
            Log.d(CodePackage.GCM, "isBackground: " + zEqualsIgnoreCase);
            Log.d(CodePackage.GCM, "flag: " + str4);
            Log.d(CodePackage.GCM, "data: " + str5);
            if (new MC(getApplicationContext()).d() == null) {
                Log.e(CodePackage.GCM, "user is not logged in, skipping push notification");
                return;
            }
            from.startsWith("/topics/");
            int i2 = Integer.parseInt(str4);
            if (i2 == 1) {
                a(string, zEqualsIgnoreCase, str5);
            } else {
                if (i2 != 2) {
                    return;
                }
                b(string, zEqualsIgnoreCase, str5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        Log.d("FCM_NEW_TOKEN", str);
        c("fcm_token", str);
        try {
            h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
