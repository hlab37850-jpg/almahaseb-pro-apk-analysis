package defpackage;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import info.aalmoghalis.inventory.R;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TD {
    public static Context b;
    public Context a;

    public TD() {
    }

    public static void a() {
        ((NotificationManager) b.getSystemService("notification")).cancelAll();
        new MC(b).e(0);
    }

    public static long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static boolean d(Context context) {
        boolean z = true;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100) {
                for (String str : runningAppProcessInfo.pkgList) {
                    if (str.equals(context.getPackageName())) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public Bitmap b(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void e() {
        try {
            RingtoneManager.getRingtone(this.a.getApplicationContext(), Uri.parse("android.resource://" + this.a.getApplicationContext().getPackageName() + "/raw/notification")).play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f(Bitmap bitmap, NotificationCompat.Builder builder, int i, String str, String str2, String str3, PendingIntent pendingIntent, Uri uri) {
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.setBigContentTitle(str);
        bigPictureStyle.setSummaryText(Html.fromHtml(str2).toString());
        bigPictureStyle.bigPicture(bitmap);
        ((NotificationManager) this.a.getSystemService("notification")).notify(101, builder.setSmallIcon(i).setTicker(str).setWhen(0L).setAutoCancel(true).setContentTitle(str).setContentIntent(pendingIntent).setStyle(bigPictureStyle).setWhen(c(str3)).setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(BitmapFactory.decodeResource(this.a.getResources(), i)).setContentText(str2).build());
    }

    public void g(String str, String str2, String str3, Intent intent) {
        h(str, str2, str3, intent, null);
    }

    public void h(String str, String str2, String str3, Intent intent, String str4) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(this.a, 0, intent, 301989888);
        NotificationManager notificationManager = (NotificationManager) this.a.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelA = AbstractC0605Iq.a("my_channel_id_02", "My Notifications", 3);
            notificationChannelA.setDescription(str2);
            notificationChannelA.enableLights(true);
            notificationChannelA.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannelA.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannelA.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.a, "my_channel_id_02");
        Uri uri = Uri.parse("android.resource://" + this.a.getPackageName() + "/raw/notification");
        if (TextUtils.isEmpty(str4)) {
            i(builder, R.mipmap.ic_launcher, str, str2, str3, activity, uri);
            return;
        }
        if (str4 == null || str4.length() <= 4 || !Patterns.WEB_URL.matcher(str4).matches()) {
            return;
        }
        Bitmap bitmapB = b(str4);
        if (bitmapB != null) {
            f(bitmapB, builder, R.mipmap.ic_launcher, str, str2, str3, activity, uri);
        } else {
            i(builder, R.mipmap.ic_launcher, str, str2, str3, activity, uri);
        }
    }

    public final void i(NotificationCompat.Builder builder, int i, String str, String str2, String str3, PendingIntent pendingIntent, Uri uri) {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        if (AbstractC0818Pe.a) {
            new MC(this.a).a(str2);
            List listAsList = Arrays.asList(new MC(this.a).c().split("\\|"));
            for (int size = listAsList.size() - 1; size >= 0; size--) {
                inboxStyle.addLine((CharSequence) listAsList.get(size));
            }
        } else {
            inboxStyle.addLine(str2);
        }
        ((NotificationManager) this.a.getSystemService("notification")).notify(100, builder.setSmallIcon(i).setTicker(str).setWhen(0L).setAutoCancel(true).setContentTitle(str).setContentIntent(pendingIntent).setStyle(inboxStyle).setWhen(c(str3)).setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(BitmapFactory.decodeResource(this.a.getResources(), i)).setContentText(str2).build());
    }

    public TD(Context context) {
        this.a = context;
    }
}
