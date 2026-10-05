package info.aalmoghalis.inventory.fcm;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import defpackage.AbstractC2038dY;
import defpackage.C1798bX;
import defpackage.C2119eY;
import defpackage.C2441iS;
import defpackage.C3865sD;
import defpackage.C4278xL;
import defpackage.DL;
import defpackage.MC;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class GcmIntentService extends IntentService {
    public static final String a = "GcmIntentService";

    public class a implements DL.b {
        public a() {
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            Log.e(GcmIntentService.a, "response: " + str);
            try {
                if (new JSONObject(str).getBoolean("error")) {
                    return;
                }
                LocalBroadcastManager.getInstance(GcmIntentService.this.getApplicationContext()).sendBroadcast(new Intent("sentTokenToServer"));
            } catch (JSONException e) {
                Log.e(GcmIntentService.a, "json parsing error: " + e.getMessage());
            }
        }
    }

    public class b implements DL.a {
        public b() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            C3865sD c3865sD = c2119eY.a;
            Log.e(GcmIntentService.a, "Volley error: " + c2119eY.getMessage() + ", code: " + c3865sD);
            Toast.makeText(GcmIntentService.this.getApplicationContext(), "Check Your Internet Connection...", 0).show();
        }
    }

    public class c extends C2441iS {
        public final /* synthetic */ String t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, String str, DL.b bVar, DL.a aVar, String str2) {
            super(i, str, bVar, aVar);
            this.t = str2;
        }

        @Override // defpackage.AbstractC3712qL
        public Map n() {
            HashMap map = new HashMap();
            map.put("gcm_registration_id", this.t);
            Log.e(GcmIntentService.a, "params: " + map.toString());
            return map;
        }
    }

    public GcmIntentService() {
        super(a);
    }

    public static void d(String str) {
        FirebaseMessaging.getInstance();
        try {
            if (FirebaseInstanceId.getInstance().getToken() != null) {
                FirebaseMessaging.getInstance().subscribeToTopic(str);
                Log.e(a, "Subscribed to topic: " + str);
            } else {
                Log.e(a, "error: gcm registration id is null");
            }
        } catch (Exception e) {
            Log.e(a, "Topic subscribe error. Topic: " + str + ", error: " + e.getMessage());
        }
    }

    public final void b() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        try {
            String token = FirebaseInstanceId.getInstance().getToken();
            Log.e(a, "GCM Registration Token: " + token);
            c(token);
            defaultSharedPreferences.edit().putBoolean("sentTokenToServer", true).apply();
        } catch (Exception e) {
            Log.e(a, "Failed to complete token refresh", e);
            defaultSharedPreferences.edit().putBoolean("sentTokenToServer", false).apply();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("registrationComplete"));
    }

    public final void c(String str) {
        C1798bX c1798bXD = new MC(getApplicationContext()).d();
        if (c1798bXD == null) {
            return;
        }
        String strReplace = "https://easycard.work/inv/v1/user/_ID_".replace("_ID_", c1798bXD.b());
        C4278xL c4278xLA = AbstractC2038dY.a(this);
        c cVar = new c(2, strReplace, new a(), new b(), str);
        cVar.H(false);
        c4278xLA.a(cVar);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        byte b2;
        try {
            String stringExtra = intent.getStringExtra("key");
            Log.e(a, "key:=" + stringExtra);
            int iHashCode = stringExtra.hashCode();
            if (iHashCode != 514841930) {
                if (iHashCode == 583281361 && stringExtra.equals("unsubscribe")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (stringExtra.equals("subscribe")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                d(intent.getStringExtra("topic"));
            } else if (b2 != 1) {
                b();
            }
        } catch (Exception e) {
            Log.e(a, "Handle error:=" + e.getMessage());
        }
    }
}
