package info.aalmoghalis.inventory.fcm;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
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
public class MyInstanceIDListenerService extends FirebaseMessagingService {
    public static final String a = "MyInstanceIDListenerService";

    public class a implements DL.b {
        public a() {
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            Log.e(MyInstanceIDListenerService.a, "response: " + str);
            try {
                if (new JSONObject(str).getBoolean("error")) {
                    return;
                }
                LocalBroadcastManager.getInstance(MyInstanceIDListenerService.this.getApplicationContext()).sendBroadcast(new Intent("sentTokenToServer"));
            } catch (JSONException e) {
                Log.e(MyInstanceIDListenerService.a, "json parsing error: " + e.getMessage());
            }
        }
    }

    public class b implements DL.a {
        public b() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            C3865sD c3865sD = c2119eY.a;
            Log.e(MyInstanceIDListenerService.a, "Volley error: " + c2119eY.getMessage() + ", code: " + c3865sD);
            Toast.makeText(MyInstanceIDListenerService.this.getApplicationContext(), "Check Your Internet Connection...", 0).show();
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
            Log.e(MyInstanceIDListenerService.a, "params: " + map.toString());
            return map;
        }
    }

    public final void b(String str) {
        C1798bX c1798bXD = new MC(getApplicationContext()).d();
        if (c1798bXD == null) {
            return;
        }
        String strReplace = "https://easycard.work/inv/v1/user/_ID_".replace("_ID_", c1798bXD.b());
        Log.e(a, "endpoint: " + strReplace);
        C4278xL c4278xLA = AbstractC2038dY.a(this);
        c cVar = new c(2, strReplace, new a(), new b(), str);
        cVar.H(false);
        c4278xLA.a(cVar);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        Log.d("NEW_TOKEN", str);
        b(str);
        Log.d("NEW_TOKEN2", str + ":" + FirebaseInstanceId.getInstance().getToken());
    }
}
