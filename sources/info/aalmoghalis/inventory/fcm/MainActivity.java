package info.aalmoghalis.inventory.fcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.autofill.HintConstants;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.iid.FirebaseInstanceId;
import com.itextpdf.text.pdf.PdfBoolean;
import defpackage.AbstractC2038dY;
import defpackage.C1798bX;
import defpackage.C2119eY;
import defpackage.C2441iS;
import defpackage.C3865sD;
import defpackage.C3890sb;
import defpackage.C4145vh;
import defpackage.C4278xL;
import defpackage.DL;
import defpackage.MC;
import defpackage.PB;
import defpackage.TD;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends BaseActivity {
    public BroadcastReceiver d;
    public SQLiteDatabase e;
    public Z00 f;
    public String c = MainActivity.class.getSimpleName();
    public WebView g = null;
    public String h = "";
    public SwipeRefreshLayout i = null;

    public class a implements DL.b {
        public a() {
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getBoolean("error")) {
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("messages");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    String string = jSONObject2.getString("message_id");
                    String string2 = jSONObject2.getString("message");
                    String string3 = jSONObject2.getString("created_at");
                    String string4 = jSONObject2.getString("reply_id");
                    String string5 = jSONObject2.getString("reply_msg");
                    String string6 = jSONObject2.getString("reply_to");
                    String string7 = jSONObject2.getString("chat_room_id");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("user");
                    C1798bX c1798bX = new C1798bX(jSONObject3.getString("user_id"), jSONObject3.getString(HintConstants.AUTOFILL_HINT_USERNAME), null, null);
                    PB pb = new PB();
                    pb.k(string);
                    pb.l(string2);
                    pb.j(string3);
                    pb.m(string4);
                    pb.n(string5);
                    pb.o(string6);
                    pb.p(c1798bX);
                    MainActivity.this.f.v0("delete from messages where server_id='" + pb.b() + "'");
                    MainActivity.this.f.v0("insert into messages (chat_room_id,user_name,user_id,message,created_at,server_id,reply_id,reply_msg,reply_to) values ( '" + string7 + "','" + pb.i().e() + "','" + pb.i().b() + "','" + pb.c() + "','" + pb.a() + "','" + pb.b() + "','" + pb.e() + "','" + pb.f() + "','" + pb.h() + "');");
                }
            } catch (JSONException e) {
                Log.e(MainActivity.this.c, "json parsing error: " + e.getMessage());
                Toast.makeText(MainActivity.this.getApplicationContext(), "json parse error: " + e.getMessage(), 0).show();
            }
        }
    }

    public class b implements DL.a {
        public b() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            C3865sD c3865sD = c2119eY.a;
            Log.e(MainActivity.this.c, "Volley error: " + c2119eY.getMessage() + ", code: " + c3865sD);
        }
    }

    public class c extends C2441iS {
        public c(int i, String str, DL.b bVar, DL.a aVar) {
            super(i, str, bVar, aVar);
        }

        @Override // defpackage.AbstractC3712qL
        public Map n() {
            HashMap map = new HashMap();
            map.put("email_id", Z00.T);
            return map;
        }
    }

    public class d implements DL.b {
        public d() {
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            Log.e(MainActivity.this.c, "response: " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getBoolean("error")) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "" + jSONObject.getJSONObject("error").getString("message"), 1).show();
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("chat_rooms");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    C3890sb c3890sb = new C3890sb();
                    c3890sb.b(jSONObject2.getString("chat_room_id"));
                    c3890sb.c(jSONObject2.getString("name"));
                    c3890sb.e(jSONObject2.getString("created_at"));
                    MainActivity.this.M(c3890sb);
                }
            } catch (JSONException e) {
                Log.e(MainActivity.this.c, "json parsing error: " + e.getMessage());
            }
        }
    }

    public class e implements DL.a {
        public e() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            C3865sD c3865sD = c2119eY.a;
            Log.e(MainActivity.this.c, "Volley error: " + c2119eY.getMessage() + ", code: " + c3865sD);
        }
    }

    public class f implements SwipeRefreshLayout.OnRefreshListener {
        public f() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            MainActivity.this.i.setRefreshing(true);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.w(mainActivity.h);
        }
    }

    public class g extends BroadcastReceiver {
        public g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.e(MainActivity.this.c, "Start Receiving...." + intent.getAction());
            if (intent.getAction().equals("registrationComplete")) {
                MainActivity.this.N();
            } else if (intent.getAction().equals("sentTokenToServer")) {
                Log.e(MainActivity.this.c, "GCM registration id is sent to our server");
            } else {
                intent.getAction().equals("pushNotification");
            }
        }
    }

    public class h extends WebViewClient {
        public h() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            MainActivity.this.i.setRefreshing(false);
            webView.loadUrl("javascript:document.getElementById(\"send_to_topic_message\").focus()");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            webView.loadUrl("about:blank");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            MainActivity.this.h = str;
            return true;
        }
    }

    public class i implements DL.b {
        public i() {
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("error").equals(PdfBoolean.FALSE)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                    new MC(MainActivity.this).f(new C1798bX(jSONObject2.getString("user_id"), jSONObject2.getString("name"), jSONObject2.getString("email"), jSONObject2.getString("imei"), jSONObject2.getString("support_id")));
                } else {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "" + jSONObject.getJSONObject("error").getString("message"), 1).show();
                }
            } catch (JSONException e) {
                Log.e(MainActivity.this.c, "json parsing error: " + e.getMessage());
            }
        }
    }

    public class j implements DL.a {
        public j() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            C3865sD c3865sD = c2119eY.a;
            Log.e(MainActivity.this.c, "Volley error: " + c2119eY.getMessage() + ", code: " + c3865sD);
            Toast.makeText(MainActivity.this.getApplicationContext(), "Check Your Internet or LOGIN...", 0).show();
        }
    }

    public class k extends C2441iS {
        public final /* synthetic */ String t;
        public final /* synthetic */ String u;
        public final /* synthetic */ String v;
        public final /* synthetic */ String w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i, String str, DL.b bVar, DL.a aVar, String str2, String str3, String str4, String str5) {
            super(i, str, bVar, aVar);
            this.t = str2;
            this.u = str3;
            this.v = str4;
            this.w = str5;
        }

        @Override // defpackage.AbstractC3712qL
        public Map n() {
            HashMap map = new HashMap();
            map.put("name", this.t);
            map.put("email", this.u);
            map.put("imei", this.v);
            map.put("token", this.w);
            return map;
        }
    }

    public class l implements DL.b {
        public l() {
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getBoolean("error")) {
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("chat_rooms");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    C4145vh c4145vh = new C4145vh();
                    c4145vh.C(jSONObject2.getString("chat_room_id"));
                    c4145vh.w(jSONObject2.getString("name"));
                    c4145vh.y(jSONObject2.getString("created_at"));
                    c4145vh.z(jSONObject2.getString("level_"));
                    try {
                        MainActivity.this.f.v0("delete from chat_rooms  where chat_room_id=" + c4145vh.v());
                        MainActivity.this.f.v0("insert into chat_rooms(chat_room_id,name,created_at,level_) values (" + c4145vh.v() + ",'" + c4145vh.a() + "','" + c4145vh.n() + "','" + c4145vh.o() + "');");
                    } catch (Exception unused) {
                    }
                }
            } catch (JSONException e) {
                Log.e(MainActivity.this.c, "json parsing error: " + e.getMessage());
            }
        }
    }

    public class m implements DL.a {
        public m() {
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            C3865sD c3865sD = c2119eY.a;
            Log.e(MainActivity.this.c, "Volley error: " + c2119eY.getMessage() + ", code: " + c3865sD);
            Toast.makeText(MainActivity.this.getApplicationContext(), "Check Your Internet Connection...", 0).show();
        }
    }

    public class n extends C2441iS {
        public n(int i, String str, DL.b bVar, DL.a aVar) {
            super(i, str, bVar, aVar);
        }

        @Override // defpackage.AbstractC3712qL
        public Map n() {
            HashMap map = new HashMap();
            map.put("email", Z00.T);
            return map;
        }
    }

    private void J() {
        try {
            String strIa = this.f.ia("PREF_ACCOUNT_NAME", "0");
            Z00.T = strIa;
            String str = Z00.R;
            String token = FirebaseInstanceId.getInstance().getToken();
            C4278xL c4278xLA = AbstractC2038dY.a(this);
            k kVar = new k(1, "https://easycard.work/inv/v1/user/login", new i(), new j(), strIa, strIa, str, token);
            kVar.H(false);
            c4278xLA.a(kVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean E() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(this);
        if (iIsGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable)) {
            googleApiAvailability.getErrorDialog(this, iIsGooglePlayServicesAvailable, 9000).show();
            return false;
        }
        Log.i(this.c, "This device is not supported. Google Play Services not installed!");
        Toast.makeText(getApplicationContext(), "This device is not supported. Google Play Services not installed!", 1).show();
        finish();
        return false;
    }

    public final void F() {
        C4278xL c4278xLA = AbstractC2038dY.a(this);
        n nVar = new n(1, "https://easycard.work/inv/v1/chat_rooms", new l(), new m());
        nVar.H(false);
        c4278xLA.a(nVar);
    }

    public final void G() {
        C4278xL c4278xLA = AbstractC2038dY.a(this);
        C2441iS c2441iS = new C2441iS(0, "https://easycard.work/inv/v1/chat_rooms", new d(), new e());
        c2441iS.H(false);
        c4278xLA.a(c2441iS);
    }

    public void H(int i2) {
        C4278xL c4278xLA = AbstractC2038dY.a(this);
        c cVar = new c(1, "https://easycard.work/inv/v1/chat_rooms_all/_ID_".replace("_ID_", i2 + ""), new a(), new b());
        cVar.H(false);
        c4278xLA.a(cVar);
    }

    public final void I() {
        Intent intent = new Intent(this, (Class<?>) LoginActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    public final void K() {
        Intent intent = new Intent(this, (Class<?>) GcmIntentService.class);
        intent.putExtra("key", "register");
        startService(intent);
    }

    public final void L() {
        if (Z00.T.equals("0")) {
            return;
        }
        this.h = "https://easycard.work/inv/__index2.php?email=" + Z00.T;
        this.g.getSettings();
        this.g.setInitialScale(1);
        this.g.getSettings().setJavaScriptEnabled(true);
        this.g.getSettings().setLoadWithOverviewMode(true);
        this.g.getSettings().setUseWideViewPort(true);
        this.g.setScrollBarStyle(33554432);
        this.g.setScrollbarFadingEnabled(false);
        this.g.loadUrl(this.h);
        this.g.setWebViewClient(new h());
    }

    public final void M(C3890sb c3890sb) {
        Intent intent = new Intent(this, (Class<?>) GcmIntentService.class);
        intent.putExtra("key", "subscribe");
        intent.putExtra("topic", "topic_" + c3890sb.a());
        startService(intent);
    }

    public final void N() {
        Intent intent = new Intent(this, (Class<?>) GcmIntentService.class);
        intent.putExtra("key", "subscribe");
        intent.putExtra("topic", "inv_app");
        startService(intent);
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (new MC(this).d() == null) {
                I();
            }
            setContentView(R.layout.fcm_activity_main);
            Z00 z00 = new Z00(this.e, this);
            this.f = z00;
            Z00.T = z00.ia("PREF_ACCOUNT_NAME", "0");
            this.g = (WebView) findViewById(R.id.webView);
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
            this.i = swipeRefreshLayout;
            swipeRefreshLayout.setOnRefreshListener(new f());
            if (new MC(this).d() != null && !Z00.T.equals("0") && !new MC(this).d().c.equals(Z00.T)) {
                J();
            }
            L();
            this.d = new g();
            E();
            K();
            G();
            F();
            H(this.f.B7());
        } catch (Exception e2) {
            Log.d("oncreate_exception:", e2.getMessage() + "");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            return false;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            LocalBroadcastManager.getInstance(this).registerReceiver(this.d, new IntentFilter("registrationComplete"));
            LocalBroadcastManager.getInstance(this).registerReceiver(this.d, new IntentFilter("pushNotification"));
            TD.b = getApplicationContext();
            TD.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void w(String str) {
        this.g.loadUrl(str);
    }
}
