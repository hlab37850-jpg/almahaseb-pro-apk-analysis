package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.google.android.gms.actions.SearchIntents;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.xmp.XMPConst;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.fcm.online_status;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Q00 {
    public static String B = "1";
    public static VQ C = null;
    public static int D = 0;
    public static boolean E = false;
    public static boolean F = false;
    public static SyncResult G = null;
    public static String H = "SocketService";
    public static long I = 0;
    public static int J = 5;
    public Handler A;
    public Context a;
    public Z00 b;
    public M00 d;
    public String c = "";
    public AbstractC0963Uk.a e = new E();
    public AbstractC0963Uk.a f = new F();
    public AbstractC0963Uk.a g = new H();
    public AbstractC0963Uk.a h = new p();
    public AbstractC0963Uk.a i = new q();
    public String j = "\\^";
    public String k = "^";
    public int l = 0;
    public int m = 0;
    public List n = new ArrayList();
    public U1 o = new s();
    public U1 p = new t();
    public U1 q = new u();
    public U1 r = new w();
    public U1 s = new x();
    public int t = 0;
    public int u = 0;
    public List v = new ArrayList();
    public AbstractC0963Uk.a w = new y();
    public U1 x = new z();
    public String y = "(online_ref2 is null  )";
    public String z = "(a.online_ref2 is null  )";

    public class A implements Callable {
        public A() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00.this.d.q.K();
            return null;
        }
    }

    public class B implements Callable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1839c10.z(Q00.this.b, "Socket", "Timeout occurred");
                Q00.E = true;
                Q00.this.d.O(false);
                Q00 q00 = Q00.this;
                if (q00.d.i) {
                    return;
                }
                q00.R();
            }
        }

        public B() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00.this.A = new Handler();
            Q00.this.A.postDelayed(new a(), WorkRequest.MIN_BACKOFF_MILLIS);
            return null;
        }
    }

    public class C implements AbstractC0963Uk.a {
        public C() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("connect_error:");
            sb.append(objArr.length > 0 ? objArr[0] : objArr);
            Log.d("socket_error", sb.toString());
            Exception exc = (Exception) objArr[0];
            Log.e("socket_error", "CONNECT_ERROR", exc);
            if (exc.getCause() != null) {
                Log.e("socket_error", "CAUSE", exc.getCause());
            }
            Z00 z00 = Q00.this.b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("EVENT_CONNECT_ERROR:");
            sb2.append(objArr.length > 0 ? objArr[0] : objArr);
            C1839c10.z(z00, "socket:error:", sb2.toString());
            new C1839c10(Q00.this.b);
            if (C1839c10.o(Q00.this.b)) {
                M00 m00 = Q00.this.d;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("EVENT_CONNECT_ERROR:");
                if (objArr.length > 0) {
                    obj = objArr;
                    obj = objArr[0];
                }
                obj = objArr;
                sb3.append(obj);
                m00.L(sb3.toString());
            }
            Q00.D = 0;
            if (Q00.this.F()) {
                Q00.this.q("0", ":trace:socket:error:");
            }
            Q00.this.v();
        }
    }

    public class D implements AbstractC0963Uk.a {
        public D() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C1839c10.z(Q00.this.b, "socket:", "reconnect");
            Q00.D = 0;
            if (Q00.this.F()) {
                Q00.this.q("0", ":trace:socket:reconnect:");
            }
        }
    }

    public class E implements AbstractC0963Uk.a {
        public E() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            String string;
            try {
                jSONObject = new JSONObject(objArr[0].toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                string = jSONObject.getString("server_retry");
            } catch (JSONException e2) {
                e2.printStackTrace();
                string = "";
            }
            C1839c10.z(Q00.this.b, "socket:retry=", string + "");
            Q00.J = Integer.parseInt(string);
            Q00.this.b.Lc("server_retry", Q00.J + "");
        }
    }

    public class F implements AbstractC0963Uk.a {
        public F() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            if (Q00.this.b.S()) {
                if (Q00.this.F()) {
                    Q00.this.q("0", "trace:start_share_refresh:start1");
                }
                C1839c10.z(Q00.this.b, Q00.H, "start_share_refresh");
                try {
                    Q00.this.X();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (Q00.this.F()) {
                        Q00.this.q("0", "trace:start_share_refresh:Exception:" + e.getMessage());
                    }
                }
            }
        }
    }

    public class G implements Callable {
        public final /* synthetic */ List a;

        public G(List list) {
            this.a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00 q00 = Q00.this;
            q00.b.Kd(q00.d.f, "" + ((String) ((HashMap) this.a.get(0)).get("_id")) + ":" + ((String) ((HashMap) this.a.get(0)).get("table_name")), 5000);
            return null;
        }
    }

    public class H implements AbstractC0963Uk.a {
        public H() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            Q00.E = false;
            if (Q00.this.F()) {
                Q00.this.q("0", "trace:check_user_status:" + objArr[0]);
            }
            try {
                jSONObject = new JSONArray(objArr[0].toString()).getJSONObject(0);
            } catch (JSONException e) {
                e.printStackTrace();
                if (Q00.this.F()) {
                    Q00.this.q("0", "trace:check_user_status:JSONException:" + e.getMessage());
                }
                jSONObject = null;
            }
            Q00.this.n(jSONObject);
        }
    }

    public class I implements Runnable {
        public final /* synthetic */ Callable a;

        public I(Callable callable) {
            this.a = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: Q00$a, reason: case insensitive filesystem */
    public class RunnableC0840a implements Runnable {
        public final /* synthetic */ Callable a;

        public RunnableC0840a(Callable callable) {
            this.a = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: Q00$b, reason: case insensitive filesystem */
    public class CallableC0841b implements Callable {
        public CallableC0841b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00 q00 = Q00.this;
            q00.b.Kd(q00.d.f, "Error1:" + Q00.this.d.f.getString(R.string.online_old_db), 5000);
            return null;
        }
    }

    /* JADX INFO: renamed from: Q00$c, reason: case insensitive filesystem */
    public class CallableC0842c implements Callable {
        public final /* synthetic */ JSONObject a;

        public CallableC0842c(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                Q00 q00 = Q00.this;
                q00.b.Kd(q00.d.f, "S:" + this.a.get("email") + ":" + Q00.this.d.f.getString(R.string.online_info), 5000);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: Q00$d, reason: case insensitive filesystem */
    public class CallableC0843d implements Callable {
        public CallableC0843d() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00 q00 = Q00.this;
            q00.b.Kd(q00.d.f, "Error2:" + Q00.this.d.f.getString(R.string.online_old_db), 5000);
            return null;
        }
    }

    /* JADX INFO: renamed from: Q00$e, reason: case insensitive filesystem */
    public class CallableC0844e implements Callable {
        public final /* synthetic */ JSONObject a;

        public CallableC0844e(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                Q00.this.W(this.a.get("email") + "");
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: Q00$f, reason: case insensitive filesystem */
    public class CallableC0845f implements Callable {
        public CallableC0845f() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00 q00 = Q00.this;
            q00.b.Kd(q00.d.f, "Error3:" + Q00.this.d.f.getString(R.string.online_old_db), 5000);
            return null;
        }
    }

    /* JADX INFO: renamed from: Q00$g, reason: case insensitive filesystem */
    public class CallableC0846g implements Callable {
        public final /* synthetic */ JSONObject a;

        public CallableC0846g(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                Q00 q00 = Q00.this;
                q00.b.Kd(q00.d.f, "C:" + this.a.get("email") + ":" + Q00.this.d.f.getString(R.string.online_info), 5000);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: Q00$h, reason: case insensitive filesystem */
    public class CallableC0847h implements Callable {
        public final /* synthetic */ String a;

        public CallableC0847h(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00 q00 = Q00.this;
            q00.b.Kd(q00.d.f, "Error4::old_DB:" + Q00.this.p(this.a), 5000);
            return null;
        }
    }

    /* JADX INFO: renamed from: Q00$i, reason: case insensitive filesystem */
    public class CallableC0848i implements Callable {
        public CallableC0848i() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00 q00 = Q00.this;
            q00.b.Kd(q00.d.f, "Error5:" + Q00.this.d.f.getString(R.string.online_old_db), 5000);
            return null;
        }
    }

    public class j implements Callable {
        public final /* synthetic */ JSONObject a;

        public j(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                Q00 q00 = Q00.this;
                q00.b.Kd(q00.d.f, "R_S:" + this.a.get("email") + ":" + Q00.this.d.f.getString(R.string.online_info), 5000);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public class k implements AbstractC0963Uk.a {
        public final /* synthetic */ InterfaceC3296lE a;

        public k(InterfaceC3296lE interfaceC3296lE) {
            this.a = interfaceC3296lE;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            C1839c10.z(Q00.this.b, "socket:connected:", Q00.C.E() + "");
            if (Q00.this.F()) {
                Q00.this.q("0", ":trace:socket:connected:" + Q00.C.E());
            }
            Q00.this.d();
            Q00.this.b.Lc("nodejs_date", Q00.this.b.r3() + "");
            Q00.this.b.Lc("nodejs_hr", Q00.this.b.o3() + "");
            Q00.D = 1;
            Q00.E = false;
            Q00.this.P();
            Q00.T(Q00.this.b);
            this.a.b(0);
            this.a.onComplete();
        }
    }

    public class l implements Callable {
        public final /* synthetic */ JSONObject a;

        public l(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                Q00 q00 = Q00.this;
                q00.b.Kd(q00.d.f, "R_N:" + this.a.get("email") + ":" + Q00.this.d.f.getString(R.string.online_info), 5000);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public class m implements Callable {
        public final /* synthetic */ JSONObject a;

        public m(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                Q00 q00 = Q00.this;
                q00.b.Kd(q00.d.f, "B:" + this.a.get("email") + ":" + Q00.this.d.f.getString(R.string.online_info), 5000);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public class n implements Callable {
        public n() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00 q00 = Q00.this;
            q00.b.Kd(q00.d.f, "Error:" + Q00.this.d.f.getString(R.string.online_old_db), 5000);
            return null;
        }
    }

    public class o implements Callable {
        public o() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00.this.d.q.K();
            return null;
        }
    }

    public class p implements AbstractC0963Uk.a {
        public p() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            C1839c10.z(Q00.this.b, Q00.H, "onConfirm_update_last_action_id:" + objArr[0]);
            try {
                jSONObject = new JSONObject(objArr[0].toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                Q00.this.Y(jSONObject.get("last_action_id") + "", jSONObject.get("fcm_token") + "", jSONObject.get("app_id") + "");
                if (Integer.parseInt(Q00.this.b.X4("select count(*) as _id from table_action")) > 0) {
                    Q00.this.O();
                } else {
                    Q00.this.z(false);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public class q implements AbstractC0963Uk.a {
        public q() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Z00 z00 = Q00.this.b;
            StringBuilder sb = new StringBuilder();
            sb.append("start:");
            sb.append(objArr[0]);
            C1839c10.z(z00, "socket_data=", sb.toString());
            try {
                JSONArray jSONArray = new JSONArray(objArr[0].toString());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    Q00.this.b.Lc("online_param_" + jSONObjectOptJSONObject.get("name") + "", jSONObjectOptJSONObject.get("value_") + "");
                }
                Q00.this.b.Lc("online_last_read_conf", System.currentTimeMillis() + "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class r implements Callable {
        public r() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Q00 q00 = Q00.this;
            q00.b.Kd(q00.d.f, "Done....", 5000);
            return null;
        }
    }

    public class s implements U1 {
        public s() {
        }

        @Override // defpackage.U1
        public void call(Object... objArr) {
            JSONObject jSONObject;
            if (objArr.length > 0) {
                C1839c10.z(Q00.this.b, Q00.H, "ack_add_data:" + objArr[0]);
                try {
                    jSONObject = new JSONObject(objArr[0].toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                Q00.this.r(jSONObject);
            }
        }
    }

    public class t implements U1 {
        public t() {
        }

        @Override // defpackage.U1
        public void call(Object... objArr) {
            JSONObject jSONObject;
            if (objArr.length > 0) {
                C1839c10.z(Q00.this.b, Q00.H, "ack_add_data_chunk:" + objArr[0]);
                try {
                    jSONObject = new JSONObject(objArr[0].toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                try {
                    if (jSONObject.getString("is_last").equals("1")) {
                        Q00.this.r(jSONObject);
                        Q00 q00 = Q00.this;
                        q00.l = 0;
                        q00.m = 0;
                    } else {
                        Q00.this.l = Integer.parseInt(jSONObject.getString("chunk_no"));
                        Q00.this.m = Integer.parseInt(jSONObject.getString("is_last"));
                        Q00.this.j();
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public class u implements U1 {

        public class a implements Callable {
            public a() {
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                Q00.this.d.q.O();
                return null;
            }
        }

        public u() {
        }

        @Override // defpackage.U1
        public void call(Object... objArr) {
            if (objArr.length > 0) {
                C1839c10.z(Q00.this.b, "socket_data=", "start::" + objArr[0]);
                try {
                    JSONArray jSONArray = new JSONArray(objArr[0].toString());
                    if (jSONArray.length() > 0) {
                        online_status.g.clear();
                        online_status.g = online_status.H(online_status.C(jSONArray, "user_info"));
                        Q00 q00 = Q00.this;
                        if (q00.d.q != null) {
                            q00.y(new a());
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class v implements AbstractC0963Uk.a {
        public v() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Log.d("socket_error", "disconnect");
            C1839c10.z(Q00.this.b, "socket:disconnected:", "socket:disconnected:");
            Q00.D = 0;
            if (Q00.this.F()) {
                Q00.this.q("0", ":trace:socket:disconnected:");
            }
            Q00.this.v();
        }
    }

    public class w implements U1 {

        public class a implements Callable {
            public final /* synthetic */ JSONObject a;

            public a(JSONObject jSONObject) {
                this.a = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                try {
                    Q00 q00 = Q00.this;
                    q00.b.Kd(q00.a, this.a.getString(NotificationCompat.CATEGORY_MESSAGE), 5000);
                    return null;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        public w() {
        }

        @Override // defpackage.U1
        public void call(Object... objArr) {
            JSONObject jSONObject;
            if (objArr.length > 0) {
                C1839c10.z(Q00.this.b, Q00.H, "ack_add_user:" + objArr[0]);
                try {
                    jSONObject = new JSONObject(objArr[0].toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                if (jSONObject.has("last_user_id")) {
                    Q00.this.A();
                } else if (jSONObject.has(NotificationCompat.CATEGORY_MESSAGE)) {
                    Q00 q00 = Q00.this;
                    if (q00.d.q != null) {
                        q00.y(new a(jSONObject));
                    }
                }
            }
        }
    }

    public class x implements U1 {
        public x() {
        }

        @Override // defpackage.U1
        public void call(Object... objArr) {
            if (objArr.length <= 0) {
                Q00.this.d.O(false);
                return;
            }
            if (Q00.this.A != null) {
                Q00.this.A.removeCallbacksAndMessages(null);
            }
            C1839c10.z(Q00.this.b, "socket_data=", "start:" + M00.w + ":" + objArr[0]);
            if (M00.w) {
                Q00.this.d.I("2:already running...");
                return;
            }
            M00.w = true;
            try {
                Q00.this.l(new JSONArray(objArr[0].toString()));
            } catch (JSONException e) {
                e.printStackTrace();
                M00.w = false;
            }
        }
    }

    public class y implements AbstractC0963Uk.a {
        public y() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            if (objArr.length > 0) {
                C1839c10.z(Q00.this.b, "socket_data=", "start:" + objArr[0]);
                try {
                    JSONObject jSONObject = new JSONObject(objArr[0].toString());
                    if (!jSONObject.getString("last_request_id").equals(Q00.this.B())) {
                        Q00 q00 = Q00.this;
                        q00.t = 0;
                        q00.u = 0;
                        q00.v = new ArrayList();
                        return;
                    }
                    Q00 q01 = Q00.this;
                    if (q01.t == 0) {
                        q01.v = new ArrayList();
                        Q00.this.u = 0;
                    }
                    if (Q00.this.t == Integer.parseInt(jSONObject.getString("chunk_no")) && objArr.length > 1) {
                        Object obj = objArr[1];
                        if (obj instanceof byte[]) {
                            Q00.this.v.add((byte[]) obj);
                            Q00.this.t = Integer.parseInt(jSONObject.getString("chunk_no"));
                            Q00.this.u = Integer.parseInt(jSONObject.getString("is_last"));
                            Q00 q02 = Q00.this;
                            if (q02.u == 1) {
                                q02.l(Q00.m(q02.v));
                                Q00 q03 = Q00.this;
                                q03.t = 0;
                                q03.u = 0;
                                q03.v = new ArrayList();
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public class z implements U1 {
        public z() {
        }

        @Override // defpackage.U1
        public void call(Object... objArr) {
            if (objArr.length > 0) {
                Z00 z00 = Q00.this.b;
                StringBuilder sb = new StringBuilder();
                sb.append("start:");
                sb.append(objArr[0]);
                C1839c10.z(z00, "socket_data=", sb.toString());
                try {
                    JSONArray jSONArray = new JSONArray(objArr[0].toString());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        Q00.this.b.Lc("online_param_" + jSONObjectOptJSONObject.get("name") + "", jSONObjectOptJSONObject.get("value_") + "");
                    }
                    Q00.this.b.Lc("online_last_read_conf", System.currentTimeMillis() + "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Q00(Z00 z00, Context context, online_status online_statusVar) {
        Z00.Z = true;
        this.a = context;
        this.b = z00;
        z00.w0("PRAGMA foreign_keys = ON");
        C1839c10.z(z00, "trace_fire=", z00.ia("online_share_type", "0") + ":start");
        if (z00.ia("online_share_type", "0").equals("0")) {
            return;
        }
        a0();
        if (!z00.ia("online_share_type", "0").equals("2")) {
            FragmentStatePagerSupport_Main.T = new M00(z00, context, false, online_statusVar);
            FragmentStatePagerSupport_Main.S = this;
            this.d = FragmentStatePagerSupport_Main.T;
            u();
            return;
        }
        if (FragmentStatePagerSupport_Main.T == null) {
            M00 m00 = new M00(z00, context, true, null);
            FragmentStatePagerSupport_Main.T = m00;
            m00.f(true);
        }
        FragmentStatePagerSupport_Main.S = this;
        this.d = FragmentStatePagerSupport_Main.T;
        X();
    }

    public static boolean E(Z00 z00) {
        return (z00.ia("online_users_un", "").equals("") || z00.ia("online_users_p_un", "").equals("") || !z00.ia("online_users_un", "").equals(z00.ia("online_users_p_un", ""))) ? false : true;
    }

    public static void T(Z00 z00) {
        z00.Lc("online_date_done", C2160f10.z("dd-MM-yyyy"));
    }

    public static JSONArray m(List list) {
        if (list == null || list.isEmpty()) {
            return new JSONArray();
        }
        Iterator it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) it.next()).length;
        }
        byte[] bArr = new byte[length];
        Iterator it2 = list.iterator();
        int length2 = 0;
        while (it2.hasNext()) {
            byte[] bArr2 = (byte[]) it2.next();
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        try {
            return new JSONArray(new String(bArr, StandardCharsets.UTF_8));
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static double x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0.0d;
        }
        return ((double) jSONObject.toString().getBytes(StandardCharsets.UTF_8).length) / 1024.0d;
    }

    public void A() {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p_un", this.d.b);
                jSONObject.put("un", this.d.c);
                jSONObject.put("fcm_token", this.d.d);
                jSONObject.put("app_id", B);
                jSONObject.put("dev_id", this.d.e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            VQ vq = C;
            if (vq != null) {
                vq.a("fetch_users", jSONObject, this.q);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.d.J(e2, 18);
        }
    }

    public String B() {
        return this.b.ia("online_last_request_id", "-10000");
    }

    public void C() {
        M00 m00 = this.d;
        if (m00.d == null || m00.c == "0" || C == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("un", this.d.c);
            jSONObject.put("fcm_token", this.d.d);
            jSONObject.put("app_id", B);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            C.a("get_user_status", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String D() {
        return "select ifnull(sum(cnt),0) as _id,ifnull(group_concat(table_name),'') table_name from(\nselect count(*) cnt,'transactions' table_name from transactions  where online_ref2 is null and bill_id in(0,-1,-2,-3,-6)\nand (date(strftime('%Y-%m-%d',substr( date_,7,4)||'-' ||substr( date_,4,2)||'-'||substr( date_,1,2) )))\n>(select ifnull(max(date_),date(date(strftime('%Y-%m-%d',substr( transactions.date_,7,4)||'-' ||substr( transactions.date_,4,2)||'-'||substr( transactions.date_,1,2) )),'-1 day')) from closing_year)\nunion all\nselect count(*) cnt,'bills' table_name from bills where online_ref2 is null and  date_>(select ifnull(max(date_),date(bills.date_,'-1 day')) from closing_year)\nunion all\nselect count(*) cnt,'bills2' table_name from bills2 where online_ref2 is null and  date_>(select ifnull(max(date_),date(bills2.date_,'-1 day')) from closing_year)\nunion ALL\nselect count(*) cnt,'items' table_name from items where online_ref2 is null  and not (o_cost!=0 and o_date<=(select ifnull(max(date_),date(items.o_date,'-1 day')) from closing_year )  )\nunion ALL\nselect count(*) cnt,'user_priv' table_name from user_priv where online_ref2 is null  and user_id<>0 \nunion all\nselect count(*) cnt,'unit_item' table_name from unit_item where online_ref2 is null and unit_id is not null and item_id not null and (item_id,unit_id) not in(select b.id ,b.unit_id FROM items b) \nunion all\nselect count(*) cnt,'currency' table_name from currency where online_ref2 is null and id not in(0,1)\nunion all\nselect count(*) cnt,'item_type' table_name from item_type where online_ref2 is null and id!=0\nunion all\nselect count(*) cnt,'groups' table_name from groups where online_ref2 is null and id!=0\nunion all\nselect count(*) cnt,'cus_type' table_name from cus_type where online_ref2 is null and id not in(0,1,2,3,4,5,6,7)\nunion all\nselect count(*) cnt,'branches' table_name from branches where online_ref2 is null and id!=0\nunion all\nselect count(*) cnt,'users' table_name from users where online_ref2 is null and id>0 and is_active=1\nunion all\nselect count(*) cnt,'tax' table_name from tax where online_ref2 is null and id not in (-1,0)\nunion all\nselect count(*) cnt,'units' table_name from units where online_ref2 is null and id not in (0,1,2,3,4)\nunion all\nselect count(*) cnt,'account_tree' table_name from account_tree where online_ref2 is null and not ( admin in (1) or id in (124))\nunion all\nselect count(*) cnt,'customers' table_name from customers where online_ref2 is null and id>0\n) a where a.cnt!=0 \n";
    }

    public final boolean F() {
        M00 m00 = this.d;
        if (m00 == null) {
            return false;
        }
        String str = m00.c;
        return (str != null && (str.toLowerCase().equals("salehalialazzani") || this.d.c.toLowerCase().equals("salehalisalemalazzani") || this.d.c.toLowerCase().equals("aalmoghalis"))) || this.d.c.toLowerCase().equals("hamzaalmughalles2019");
    }

    public final /* synthetic */ void G(InterfaceC3296lE interfaceC3296lE) {
        if (C == null || D == 0) {
            try {
                AbstractC0892Rr.a aVar = new AbstractC0892Rr.a();
                aVar.m = new String[]{"websocket"};
                aVar.d = true;
                C = AbstractC0892Rr.b("https://bkp2.dyndns.org:7000", aVar);
                if (!this.b.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
                    C.y();
                }
            } catch (URISyntaxException e) {
                if (F()) {
                    q("0", ":trace:URISyntaxException:" + e.getMessage());
                }
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                if (F()) {
                    q("0", ":trace:Exception:" + e2.getMessage());
                }
            }
        }
        C.b();
        C.e("connect", new k(interfaceC3296lE));
        C.e("disconnect", new v());
        C.e("connect_error", new C());
        C.e("reconnect", new D());
        C.e("check_user_status", this.g);
        C.e("fetch_data_chunk", this.w);
        C.e("confirm_server_retry", this.e);
        C.e("start_share_refresh", this.f);
    }

    public final /* synthetic */ void H(Integer num) {
        C1839c10.z(this.b, H, "Connected");
        if (F()) {
            q("0", ":trace:Connected");
        }
    }

    public final /* synthetic */ void I(Throwable th) {
        Log.e(H, "Connection error: " + th.getMessage());
        if (F()) {
            q("0", ":trace:Connection error:" + th.getMessage());
        }
    }

    public String J(String str) {
        String str2 = "";
        try {
            if (new JSONArray(str).getJSONObject(0).has("name")) {
                str2 = ":name=" + new JSONArray(str).getJSONObject(0).getString("name");
            } else if (new JSONArray(str).getJSONObject(0).has("bill_no2")) {
                str2 = ":bill_no=" + new JSONArray(str).getJSONObject(0).getString("bill_no2");
            } else if (new JSONArray(str).getJSONObject(0).has("p_ref_no")) {
                String str3 = ":tran_no=" + new JSONArray(str).getJSONObject(0).getString("p_ref_no");
                if (new JSONArray(str).getJSONObject(0).has("bill_id")) {
                    str2 = str3 + ":tran_bill=" + new JSONArray(str).getJSONObject(0).getString("bill_id");
                } else {
                    str2 = str3;
                }
            }
        } catch (JSONException unused) {
        }
        return str2;
    }

    public boolean K(String str) {
        try {
            ArrayList<String> arrayListE = new C2160f10(this.b).E("select max(date_) as _id from closing_year where  " + this.y);
            if (arrayListE.size() == 0) {
                return true;
            }
            for (String str2 : arrayListE) {
                int i = Integer.parseInt(this.b.X4("select count(*) as _id from table_action  where action_='insert' and table_name='" + str + "'  and ref_no='patch#first_year' and init=1 "));
                if (str.equals("bills")) {
                    if (i == 0) {
                        M00.w(this.b, "insert", str, " where  date_='" + str2 + "'", "patch#first_year", "1", "1");
                    }
                } else if (str.equals("bills2")) {
                    if (i == 0) {
                        M00.w(this.b, "insert", str, " where  date_<='" + str2 + "'", "patch#first_year", "1", "1");
                    }
                } else if (str.equals("items")) {
                    if (i == 0) {
                        M00.w(this.b, "insert", str, " where o_cost!=0 and  o_date<='" + str2 + "'", "patch#first_year", "1", "1");
                    }
                } else if (str.equals("transactions") && i == 0) {
                    M00.w(this.b, "insert", str, " where  bill_id in (0,-1,-2,-3,-6)  and (date(strftime('%Y-%m-%d'',substr( date_,7,4)||'-' ||substr( date_,4,2)||'-'||substr( date_,1,2) ))) ='" + str2 + "'", "patch#first_year", "1", "1");
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.d.J(e, 6);
            q("6", e.getMessage() + "");
            return false;
        }
    }

    public void L() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "h_table#query:";
        String str7 = " where 1=2 ";
        CharSequence charSequence = "_h";
        String str8 = " as select * from ";
        String str9 = "create table if not exists ";
        String str10 = " where  online_ref2 is null ";
        String str11 = "select count(*) as _id from ";
        String str12 = "";
        try {
            if (this.d.d()) {
                return;
            }
            String str13 = "0";
            if (!E(this.b)) {
                C1839c10.z(this.b, H, "push_h_data=Exit1:init=" + this.b.ia("online_push_init_data", "0"));
                return;
            }
            if (this.b.ia("online_push_closed_data", "0").equals("0")) {
                C1839c10.z(this.b, H, "push_h_data=Exit2");
                return;
            }
            if (this.d.q == null) {
                return;
            }
            C1839c10.z(this.b, H, "push_h_data=push_h_flag=" + M00.z);
            if (M00.z) {
                this.d.I("0:already running...#");
                return;
            }
            String str14 = " ";
            M00.z = true;
            this.b.R0();
            String[] strArr = this.d.r;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    String str15 = strArr[i];
                    try {
                        Z00 z00 = this.b;
                        String[] strArr2 = strArr;
                        StringBuilder sb = new StringBuilder();
                        int i2 = length;
                        sb.append("select count(*) as _id from sqlite_master where type='table' and name='");
                        sb.append(str15);
                        sb.append("'");
                        if (!z00.X4(sb.toString()).equals(str13)) {
                            U(str15);
                            String strX4 = this.b.X4("select count(*) as _id from pragma_table_info('" + str15 + "') where name='id'");
                            int i3 = Integer.parseInt(this.b.X4(str11 + str15 + str10 + str14));
                            if (i3 != 0) {
                                Z00 z01 = this.b;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str9);
                                sb2.append(str15);
                                sb2.append(str8);
                                String str16 = str10;
                                sb2.append(str15.replace("_h2", str12).replace(charSequence, str12));
                                sb2.append(str7);
                                M00.w(z01, SearchIntents.EXTRA_QUERY, str15, sb2.toString(), str6 + str15, "2", "1");
                                if (this.d.D(str15)) {
                                    String strO = this.d.o(str15);
                                    M00.w(this.b, SearchIntents.EXTRA_QUERY, strO, str9 + strO + str8 + strO.replace(charSequence, str12) + str7, str6 + strO, "2", "1");
                                }
                                int i4 = i3 > 0 ? (i3 / this.d.o) + 1 : 0;
                                String str17 = ":has_id=";
                                String str18 = ":server=";
                                String str19 = ":no=";
                                String str20 = "push:h_table=";
                                if (i3 > 0) {
                                    try {
                                        str2 = str12;
                                        try {
                                            C1839c10.z(this.b, H, "push:h_table=" + str15 + ":cnt=" + i3 + ":no=" + i4 + ":server=" + this.b.ja("online_server", false) + ":has_id=" + strX4);
                                        } catch (Exception e) {
                                            e = e;
                                            str = str2;
                                            e.printStackTrace();
                                            C1839c10.z(this.b, H, "push_sql_err:" + str15);
                                            this.d.K("Error8:push_sql_err:" + str15);
                                            q("8", "push_sql_err:" + e.getMessage() + str);
                                            return;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        str2 = str12;
                                    }
                                } else {
                                    str2 = str12;
                                }
                                int i5 = Integer.parseInt(this.b.X4("select ifnull(max(online),0) as _id from " + str15));
                                int i6 = 0;
                                while (i6 < i4) {
                                    int i7 = i6 + i5;
                                    if (i6 == 0) {
                                        t(str15);
                                    }
                                    Z00 z02 = this.b;
                                    String str21 = H;
                                    int i8 = i5;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str20);
                                    sb3.append(str15);
                                    String str22 = str20;
                                    sb3.append(":p2=");
                                    sb3.append(i7);
                                    sb3.append(":p=");
                                    sb3.append(i6);
                                    sb3.append(":cnt=");
                                    sb3.append(i3);
                                    sb3.append(str19);
                                    sb3.append(i4);
                                    sb3.append(str18);
                                    String str23 = str19;
                                    sb3.append(this.b.ja("online_server", false));
                                    sb3.append(str17);
                                    sb3.append(strX4);
                                    C1839c10.z(z02, str21, sb3.toString());
                                    this.d.L(i8 + ":" + i6 + "/" + i4);
                                    String str24 = "#" + i7 + "-" + i4 + ":patch_h";
                                    String str25 = str13;
                                    str13 = str25;
                                    int i9 = i4;
                                    if (strX4.equals(str25)) {
                                        str17 = str17;
                                        str5 = str14;
                                        Z00 z03 = this.b;
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("update ");
                                        sb4.append(str15);
                                        sb4.append(" set online='");
                                        sb4.append(i7);
                                        sb4.append("',online_ref2=(case when online_ref2 is null then rowid||':'||'");
                                        sb4.append(C2160f10.F(this.b));
                                        str = str2;
                                        sb4.append(str);
                                        sb4.append(str24);
                                        sb4.append("' else online_ref2 end) where  online_ref2 is null ");
                                        sb4.append(str5);
                                        sb4.append(" and rowid in(select a.rowid from ");
                                        sb4.append(str15);
                                        sb4.append(" a where a.online_ref2 is null ");
                                        sb4.append(str5);
                                        sb4.append(" order by a.rowid  limit ");
                                        sb4.append(this.d.o);
                                        sb4.append(")");
                                        z03.x0(sb4.toString());
                                        M00.w(this.b, "insert", str15, " where online='" + i7 + "'  " + str5, str24, "1", "1");
                                    } else {
                                        Z00 z04 = this.b;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("select ifnull(max(id),0) as _id from(select id from ");
                                        sb5.append(str15);
                                        sb5.append(" where online_ref2 is null ");
                                        str5 = str14;
                                        sb5.append(str5);
                                        sb5.append(" order by id limit ");
                                        sb5.append(this.d.o);
                                        sb5.append(") as _id ");
                                        int i10 = Integer.parseInt(z04.X4(sb5.toString()));
                                        if (str15.equals("items_h")) {
                                            this.b.x0("update " + str15 + " set online='" + i7 + "',online_ref2=(case when online_ref2 is null then name||':'||'" + C2160f10.F(this.b) + "'||'' else online_ref2 end) where id<=" + i10 + " and online_ref2 is null " + str5 + " and rowid in(select a.rowid from " + str15 + " a where a.id<=" + i10 + " and a.online_ref2 is null " + str5 + " order by a.id  limit " + this.d.o + ")");
                                        } else {
                                            this.b.x0("update " + str15 + " set online='" + i7 + "',online_ref2=(case when online_ref2 is null then id||':'||'" + C2160f10.F(this.b) + "'||':'||date_||'" + str24 + "' else online_ref2 end) where id<=" + i10 + " and online_ref2 is null " + str5 + " and rowid in(select a.rowid from " + str15 + " a where a.id<=" + i10 + " and a.online_ref2 is null " + str5 + " order by a.id  limit " + this.d.o + ")");
                                        }
                                        M00.w(this.b, "insert", str15, " where online='" + i7 + "'  " + str5, str24, "1", "1");
                                        str = str2;
                                    }
                                    try {
                                        i6++;
                                        str2 = str;
                                        i3 = i3;
                                        i4 = i9;
                                        str20 = str22;
                                        str19 = str23;
                                        i5 = i8;
                                        str18 = str18;
                                        str17 = str17;
                                        str14 = str5;
                                        strX4 = strX4;
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        C1839c10.z(this.b, H, "push_sql_err:" + str15);
                                        this.d.K("Error8:push_sql_err:" + str15);
                                        q("8", "push_sql_err:" + e.getMessage() + str);
                                        return;
                                    }
                                }
                                str = str2;
                                str3 = str14;
                                Z00 z05 = this.b;
                                StringBuilder sb6 = new StringBuilder();
                                str4 = str11;
                                sb6.append(str4);
                                sb6.append(str15);
                                str10 = str16;
                                sb6.append(str10);
                                sb6.append(str3);
                                int i11 = Integer.parseInt(z05.X4(sb6.toString()));
                                if (i11 > 0) {
                                    C1839c10.z(this.b, H, "ERROR:push:h_table=" + str15 + ":cnt=" + i11);
                                    M00.z = false;
                                    this.d.L("ERROR......");
                                    return;
                                }
                            }
                            i++;
                            str12 = str;
                            str11 = str4;
                            str14 = str3;
                            strArr = strArr2;
                            length = i2;
                            str8 = str8;
                            str6 = str6;
                            str7 = str7;
                            charSequence = charSequence;
                            str9 = str9;
                            str13 = str13;
                        }
                        str8 = str8;
                        str9 = str9;
                        str4 = str11;
                        str = str12;
                        str3 = str14;
                        str13 = str13;
                        i++;
                        str12 = str;
                        str11 = str4;
                        str14 = str3;
                        strArr = strArr2;
                        length = i2;
                        str8 = str8;
                        str6 = str6;
                        str7 = str7;
                        charSequence = charSequence;
                        str9 = str9;
                        str13 = str13;
                    } catch (Exception e4) {
                        e = e4;
                        str = str12;
                    }
                } catch (Exception e5) {
                    e = e5;
                    this.d.J(e, 21);
                    q("21", e.getMessage() + str8);
                    e.printStackTrace();
                    return;
                }
            }
            M00.z = false;
        } catch (Exception e6) {
            e = e6;
            str8 = "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:107:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:109:0x0300 A[Catch: Exception -> 0x02b3, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x02b3, blocks: (B:97:0x029c, B:109:0x0300), top: B:206:0x029c }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0402 A[Catch: Exception -> 0x0497, TRY_LEAVE, TryCatch #4 {Exception -> 0x0497, blocks: (B:117:0x03f5, B:119:0x0402), top: B:197:0x03f5 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x049b A[Catch: Exception -> 0x048f, TRY_LEAVE, TryCatch #0 {Exception -> 0x048f, blocks: (B:121:0x040d, B:131:0x052f, B:126:0x049b, B:130:0x04ce), top: B:189:0x040d }] */
    /* JADX WARN: Code duplicated, block: B:137:0x057e  */
    /* JADX WARN: Code duplicated, block: B:151:0x06c5 A[Catch: Exception -> 0x06e9, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x06e9, blocks: (B:147:0x0668, B:151:0x06c5), top: B:195:0x0668 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x077c A[Catch: Exception -> 0x0760, TryCatch #11 {Exception -> 0x0760, blocks: (B:165:0x0702, B:173:0x077c, B:176:0x0791, B:178:0x07a8, B:180:0x07b0, B:181:0x07f0, B:182:0x07f5, B:184:0x07fd, B:185:0x0807), top: B:210:0x0702 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x078d  */
    /* JADX WARN: Code duplicated, block: B:176:0x0791 A[Catch: Exception -> 0x0760, TryCatch #11 {Exception -> 0x0760, blocks: (B:165:0x0702, B:173:0x077c, B:176:0x0791, B:178:0x07a8, B:180:0x07b0, B:181:0x07f0, B:182:0x07f5, B:184:0x07fd, B:185:0x0807), top: B:210:0x0702 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x07a8 A[Catch: Exception -> 0x0760, TryCatch #11 {Exception -> 0x0760, blocks: (B:165:0x0702, B:173:0x077c, B:176:0x0791, B:178:0x07a8, B:180:0x07b0, B:181:0x07f0, B:182:0x07f5, B:184:0x07fd, B:185:0x0807), top: B:210:0x0702 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x07b0 A[Catch: Exception -> 0x0760, LOOP:3: B:179:0x07ae->B:180:0x07b0, LOOP_END, TryCatch #11 {Exception -> 0x0760, blocks: (B:165:0x0702, B:173:0x077c, B:176:0x0791, B:178:0x07a8, B:180:0x07b0, B:181:0x07f0, B:182:0x07f5, B:184:0x07fd, B:185:0x0807), top: B:210:0x0702 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x07fd A[Catch: Exception -> 0x0760, TryCatch #11 {Exception -> 0x0760, blocks: (B:165:0x0702, B:173:0x077c, B:176:0x0791, B:178:0x07a8, B:180:0x07b0, B:181:0x07f0, B:182:0x07f5, B:184:0x07fd, B:185:0x0807), top: B:210:0x0702 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0807 A[Catch: Exception -> 0x0760, TRY_LEAVE, TryCatch #11 {Exception -> 0x0760, blocks: (B:165:0x0702, B:173:0x077c, B:176:0x0791, B:178:0x07a8, B:180:0x07b0, B:181:0x07f0, B:182:0x07f5, B:184:0x07fd, B:185:0x0807), top: B:210:0x0702 }] */
    /* JADX WARN: Code duplicated, block: B:199:0x024e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x039f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x0695 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0260  */
    /* JADX WARN: Code duplicated, block: B:94:0x0271  */
    /* JADX WARN: Instruction removed from duplicated block: B:178:0x07a8, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:180:0x07b0, please report this as an issue */
    public void M(boolean z2) {
        String str;
        Exception exc;
        String str2;
        String str3;
        String str4;
        boolean z3;
        boolean zK;
        String str5;
        String str6;
        int i;
        String[] strArr;
        String str7;
        Exception exc2;
        String str8;
        String strX4;
        String str9;
        int i2;
        int i3;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        int i4;
        int i5;
        String str19;
        String str20;
        String str21;
        int i6;
        Exception e;
        int i7;
        String str22;
        String str23;
        String str24;
        String str25;
        int i8;
        int iR;
        String str26;
        String str27;
        String str28 = " where  ";
        String str29 = "select count(*) as _id from ";
        String str30 = "";
        String str31 = "update trigger_flags set is_active=1";
        String str32 = "1";
        String str33 = "online_server";
        String str34 = "0";
        try {
            if (this.d.d() || !this.b.ja("online_server", false) || this.d.q == null) {
                return;
            }
            boolean zJa = this.b.ja("online_server", false);
            boolean zJa2 = this.b.ja("online_server", false);
            C1839c10.z(this.b, H, "push_init_data=init=" + this.b.ia("online_push_init_data", "0") + ":push_init_flag=" + M00.y);
            try {
                if (this.b.ia("online_push_init_data", "0").equals("1")) {
                    this.b.v0("update trigger_flags set is_active=1");
                    return;
                }
                boolean z4 = this.b.ia("online_push_init_data", "0").equals("1") ? false : zJa;
                if (this.b.ia("online_push_closed_data", "0").equals("1")) {
                    zJa2 = false;
                }
                C1839c10.z(this.b, H, "push_init_data=server=" + this.b.ja("online_server", false) + ":init=" + z4 + ":closed=" + zJa2);
                String str35 = " ";
                if (z4) {
                    if (M00.y) {
                        this.d.I("0:already running...");
                        return;
                    }
                    M00.y = true;
                    this.d.O(true);
                    String[] strArr2 = this.d.p;
                    int length = strArr2.length;
                    int i9 = 0;
                    while (i9 < length) {
                        String str36 = strArr2[i9];
                        String[] strArr3 = strArr2;
                        StringBuilder sb = new StringBuilder();
                        int i10 = length;
                        sb.append("where ");
                        boolean z5 = zJa2;
                        sb.append(this.d.l(str36, " in "));
                        sb.append(" ");
                        if (!N(str36, sb.toString())) {
                            return;
                        }
                        i9++;
                        strArr2 = strArr3;
                        length = i10;
                        zJa2 = z5;
                    }
                }
                boolean z6 = zJa2;
                String[] strArr4 = {"groups", "account_tree", "branches", "cus_type", "customers", "currency", "currency_price", "item_type", "units", "items", "unit_item", "tax", "item_price", "users", "user_priv", "bills", "bills2", "transactions", "cus_limit", "reminders", "closing_year"};
                String str37 = "update ";
                if (z4) {
                    M00.r(this.b);
                    this.d.L("Wait..");
                    zK = z6;
                    int i11 = 0;
                    int i12 = 21;
                    while (i11 < i12) {
                        String str38 = strArr4[i11];
                        if (zK) {
                            strArr = strArr4;
                            if (this.d.A(str38)) {
                                zK = K(str38);
                            }
                        } else {
                            strArr = strArr4;
                        }
                        boolean z7 = z4;
                        String str39 = "items";
                        boolean z8 = zK;
                        try {
                            try {
                                try {
                                    try {
                                        if (str38.equals("transactions")) {
                                            str7 = " and bill_id in(0,-1,-2,-3,-6)  and (date(strftime('%Y-%m-%d',substr( date_,7,4)||'-' ||substr( date_,4,2)||'-'||substr( date_,1,2) ))) >(select ifnull(max(date_),date(date(strftime('%Y-%m-%d',substr( transactions.date_,7,4)||'-' ||substr( transactions.date_,4,2)||'-'||substr( transactions.date_,1,2) )),'-1 day')) from closing_year) ";
                                        } else if (str38.equals("bills")) {
                                            str7 = " and date_>(select ifnull(max(date_),date(bills.date_,'-1 day')) from closing_year) ";
                                        } else if (str38.equals("bills2")) {
                                            str7 = " and date_>(select ifnull(max(date_),date(bills2.date_,'-1 day')) from closing_year) ";
                                        } else if (str38.equals("items")) {
                                            str7 = " and not (o_cost!=0 and o_date<=(select ifnull(max(date_),date(items.o_date,'-1 day')) from closing_year )  ) ";
                                        } else if (str38.equals("user_priv")) {
                                            str7 = " and user_id<>0 ";
                                        } else {
                                            if (str38.equals("unit_item")) {
                                                str7 = " and (item_id,unit_id) not in(select b.id ,b.unit_id FROM items b) ";
                                            } else {
                                                str2 = str32;
                                                str7 = new C2160f10().t(this.d.p, str38) ? " and " + this.d.l(str38, " not in ") : str35;
                                            }
                                            M00.G(M00.r(this.b), this.b);
                                            Z00 z00 = this.b;
                                            StringBuilder sb2 = new StringBuilder();
                                            str8 = str31;
                                            sb2.append("select count(*) as _id from pragma_table_info('");
                                            sb2.append(str38);
                                            sb2.append("') where name='id'");
                                            strX4 = z00.X4(sb2.toString());
                                            Z00 z01 = this.b;
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append(str29);
                                            sb3.append(str38);
                                            sb3.append(str28);
                                            str9 = str28;
                                            sb3.append(this.y);
                                            sb3.append(str35);
                                            sb3.append(str7);
                                            i2 = Integer.parseInt(z01.X4(sb3.toString()));
                                            U(str38);
                                            if (i2 > 0) {
                                                try {
                                                    i3 = (i2 / this.d.o) + 1;
                                                } catch (Exception e2) {
                                                    exc2 = e2;
                                                    str3 = str34;
                                                    str4 = str37;
                                                    str = str8;
                                                    exc2.printStackTrace();
                                                    C1839c10.z(this.b, H, "push_sql_err:" + str38);
                                                    this.b.v0(str);
                                                    this.d.O(false);
                                                    this.d.K("Error8:push_sql_err:" + str38);
                                                    q("8", "push_sql_err:" + exc2.getMessage() + str30);
                                                    zK = z8;
                                                    z3 = false;
                                                    if (z3) {
                                                        this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_init_data','1','pref#push_init',0)");
                                                        str5 = str2;
                                                        this.b.Lc("online_push_init_data", str5);
                                                    } else {
                                                        str5 = str2;
                                                    }
                                                    if (zK) {
                                                        this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_closed_data','1','pref#push_closed',0)");
                                                        str6 = str3;
                                                        if (this.b.ia("online_push_closed_data", str6).equals(str6)) {
                                                            for (String str40 : this.d.r) {
                                                                C1839c10.z(this.b, H, "push_init=update_h_table:" + str40);
                                                                this.b.v0(str4 + str40 + " set online_ref2=null where  online_ref2 is not null and " + this.y + "  ");
                                                            }
                                                        }
                                                        this.b.Lc("online_push_closed_data", str5);
                                                    }
                                                    this.d.O(false);
                                                    if (z3) {
                                                        this.d.L("ERROR...#");
                                                        return;
                                                    } else {
                                                        this.d.L("Wait...#");
                                                        M00.y = false;
                                                        return;
                                                    }
                                                }
                                            } else {
                                                i3 = 0;
                                            }
                                            str10 = ":server=";
                                            str11 = str29;
                                            str12 = ":no=";
                                            str13 = str30;
                                            str14 = "push:table=";
                                            str15 = " and ";
                                            str16 = ":cnt=";
                                            if (i2 > 0) {
                                                str18 = str37;
                                                try {
                                                    Z00 z02 = this.b;
                                                    String str41 = H;
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append("push:table=");
                                                    sb4.append(str38);
                                                    sb4.append(":cnt=");
                                                    sb4.append(i2);
                                                    sb4.append(":no=");
                                                    sb4.append(i3);
                                                    sb4.append(":server=");
                                                    str17 = str34;
                                                    try {
                                                        sb4.append(this.b.ja(str33, false));
                                                        sb4.append(":has_id=");
                                                        sb4.append(strX4);
                                                        C1839c10.z(z02, str41, sb4.toString());
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        exc2 = e;
                                                        str = str8;
                                                        str30 = str13;
                                                        str4 = str18;
                                                        str3 = str17;
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    str17 = str34;
                                                }
                                            } else {
                                                str17 = str34;
                                                str18 = str37;
                                            }
                                            this.b.v0("update trigger_flags set is_active=0");
                                            i4 = Integer.parseInt(this.b.X4("select ifnull(max(online),0) as _id from " + str38));
                                            new ArrayList();
                                            new ArrayList();
                                            i5 = 0;
                                            while (i5 < i3) {
                                                i7 = i5 + i4;
                                                if (i5 == 0) {
                                                    t(str38);
                                                }
                                                try {
                                                    Z00 z03 = this.b;
                                                    String str42 = H;
                                                    int i13 = i4;
                                                    StringBuilder sb5 = new StringBuilder();
                                                    sb5.append(str14);
                                                    sb5.append(str38);
                                                    String str43 = str14;
                                                    sb5.append(":p2=");
                                                    sb5.append(i7);
                                                    sb5.append(":p=");
                                                    sb5.append(i5);
                                                    sb5.append(str16);
                                                    sb5.append(i2);
                                                    sb5.append(str12);
                                                    sb5.append(i3);
                                                    sb5.append(str10);
                                                    int i14 = i2;
                                                    sb5.append(this.b.ja(str33, false));
                                                    sb5.append(":has_id=");
                                                    sb5.append(strX4);
                                                    C1839c10.z(z03, str42, sb5.toString());
                                                    this.d.L(i13 + ":" + i5 + "/" + i3);
                                                    str22 = "#" + i7 + "-" + i3 + ":patch";
                                                    str23 = str17;
                                                    try {
                                                        String str44 = str12;
                                                        if (!strX4.equals(str23)) {
                                                            try {
                                                                Z00 z04 = this.b;
                                                                StringBuilder sb6 = new StringBuilder();
                                                                sb6.append("select ifnull(max(id),0) as _id from(select id from ");
                                                                sb6.append(str38);
                                                                sb6.append(" where ");
                                                                sb6.append(this.y);
                                                                str24 = str35;
                                                                sb6.append(str24);
                                                                str25 = str7;
                                                                sb6.append(str25);
                                                                sb6.append(" order by id limit ");
                                                                sb6.append(this.d.o);
                                                                sb6.append(") as _id ");
                                                                i8 = Integer.parseInt(z04.X4(sb6.toString()));
                                                                iR = M00.r(this.b);
                                                                str3 = str23;
                                                                try {
                                                                    C1839c10.z(this.b, H, "T3");
                                                                    str39 = str39;
                                                                    if (str38.equals(str39)) {
                                                                        Z00 z05 = this.b;
                                                                        StringBuilder sb7 = new StringBuilder();
                                                                        str4 = str18;
                                                                        try {
                                                                            sb7.append(str4);
                                                                            sb7.append(str38);
                                                                            sb7.append(" set online='");
                                                                            sb7.append(i7);
                                                                            sb7.append("',online_ref2= name||':'||'");
                                                                            sb7.append(C2160f10.F(this.b));
                                                                            sb7.append("'  where id<=");
                                                                            sb7.append(i8);
                                                                            sb7.append(str24);
                                                                            sb7.append(str25);
                                                                            String str45 = str15;
                                                                            sb7.append(str45);
                                                                            sb7.append(this.y);
                                                                            sb7.append(" and rowid in(select a.rowid from ");
                                                                            sb7.append(str38);
                                                                            sb7.append(" a where a.id<=");
                                                                            sb7.append(i8);
                                                                            sb7.append(str45);
                                                                            sb7.append(this.z);
                                                                            sb7.append(str24);
                                                                            sb7.append(str25.replace(str38 + ".", "a."));
                                                                            sb7.append(" order by a.id  limit ");
                                                                            sb7.append(this.d.o);
                                                                            sb7.append(")");
                                                                            z05.x0(sb7.toString());
                                                                            str26 = str45;
                                                                            C1839c10.z(this.b, H, "T4");
                                                                            M00.G(iR, this.b);
                                                                            Z00 z06 = this.b;
                                                                            z06.x0(M00.x(z06, "insert", str38, " where online='" + i7 + "'  " + str25 + " order by id ", str22, "1", "1"));
                                                                            str30 = str13;
                                                                        } catch (Exception e5) {
                                                                            e = e5;
                                                                            exc2 = e;
                                                                            str = str8;
                                                                            str30 = str13;
                                                                            exc2.printStackTrace();
                                                                            C1839c10.z(this.b, H, "push_sql_err:" + str38);
                                                                            this.b.v0(str);
                                                                            this.d.O(false);
                                                                            this.d.K("Error8:push_sql_err:" + str38);
                                                                            q("8", "push_sql_err:" + exc2.getMessage() + str30);
                                                                            zK = z8;
                                                                            z3 = false;
                                                                            if (z3) {
                                                                                this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_init_data','1','pref#push_init',0)");
                                                                                str5 = str2;
                                                                                this.b.Lc("online_push_init_data", str5);
                                                                            } else {
                                                                                str5 = str2;
                                                                            }
                                                                            if (zK) {
                                                                                this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_closed_data','1','pref#push_closed',0)");
                                                                                str6 = str3;
                                                                                if (this.b.ia("online_push_closed_data", str6).equals(str6)) {
                                                                                    while (i < r8) {
                                                                                        C1839c10.z(this.b, H, "push_init=update_h_table:" + str40);
                                                                                        this.b.v0(str4 + str40 + " set online_ref2=null where  online_ref2 is not null and " + this.y + "  ");
                                                                                    }
                                                                                }
                                                                                this.b.Lc("online_push_closed_data", str5);
                                                                            }
                                                                            this.d.O(false);
                                                                            if (z3) {
                                                                                this.d.L("ERROR...#");
                                                                                return;
                                                                            } else {
                                                                                this.d.L("Wait...#");
                                                                                M00.y = false;
                                                                                return;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str26 = str15;
                                                                        str4 = str18;
                                                                        Z00 z07 = this.b;
                                                                        StringBuilder sb8 = new StringBuilder();
                                                                        sb8.append(str4);
                                                                        sb8.append(str38);
                                                                        sb8.append(" set online='");
                                                                        sb8.append(i7);
                                                                        sb8.append("',online_ref2= id||':'||'");
                                                                        sb8.append(C2160f10.F(this.b));
                                                                        str27 = str13;
                                                                        try {
                                                                            sb8.append(str27);
                                                                            sb8.append(str22);
                                                                            str13 = str27;
                                                                            sb8.append("'  where id<=");
                                                                            sb8.append(i8);
                                                                            sb8.append(str24);
                                                                            sb8.append(str25);
                                                                            sb8.append(str26);
                                                                            sb8.append(this.y);
                                                                            sb8.append(" and rowid in(select a.rowid from ");
                                                                            sb8.append(str38);
                                                                            sb8.append(" a where a.id<=");
                                                                            sb8.append(i8);
                                                                            sb8.append(str26);
                                                                            sb8.append(this.z);
                                                                            sb8.append(str24);
                                                                            sb8.append(str25.replace(str38 + ".", "a."));
                                                                            sb8.append(" order by a.id  limit ");
                                                                            sb8.append(this.d.o);
                                                                            sb8.append(")");
                                                                            z07.x0(sb8.toString());
                                                                            C1839c10.z(this.b, H, "T4");
                                                                            M00.G(iR, this.b);
                                                                            Z00 z08 = this.b;
                                                                            z08.x0(M00.x(z08, "insert", str38, " where online='" + i7 + "'  " + str25 + " order by id ", str22, "1", "1"));
                                                                            str30 = str13;
                                                                        } catch (Exception e6) {
                                                                            e = e6;
                                                                            str13 = str27;
                                                                            exc2 = e;
                                                                            str = str8;
                                                                            str30 = str13;
                                                                            exc2.printStackTrace();
                                                                            C1839c10.z(this.b, H, "push_sql_err:" + str38);
                                                                            this.b.v0(str);
                                                                            this.d.O(false);
                                                                            this.d.K("Error8:push_sql_err:" + str38);
                                                                            q("8", "push_sql_err:" + exc2.getMessage() + str30);
                                                                            zK = z8;
                                                                            z3 = false;
                                                                            if (z3) {
                                                                                this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_init_data','1','pref#push_init',0)");
                                                                                str5 = str2;
                                                                                this.b.Lc("online_push_init_data", str5);
                                                                            } else {
                                                                                str5 = str2;
                                                                            }
                                                                            if (zK) {
                                                                                this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_closed_data','1','pref#push_closed',0)");
                                                                                str6 = str3;
                                                                                if (this.b.ia("online_push_closed_data", str6).equals(str6)) {
                                                                                    while (i < r8) {
                                                                                        C1839c10.z(this.b, H, "push_init=update_h_table:" + str40);
                                                                                        this.b.v0(str4 + str40 + " set online_ref2=null where  online_ref2 is not null and " + this.y + "  ");
                                                                                    }
                                                                                }
                                                                                this.b.Lc("online_push_closed_data", str5);
                                                                            }
                                                                            this.d.O(false);
                                                                            if (z3) {
                                                                                this.d.L("ERROR...#");
                                                                                return;
                                                                            } else {
                                                                                this.d.L("Wait...#");
                                                                                M00.y = false;
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (Exception e7) {
                                                                    e = e7;
                                                                    str4 = str18;
                                                                    exc2 = e;
                                                                    str = str8;
                                                                    str30 = str13;
                                                                    exc2.printStackTrace();
                                                                    C1839c10.z(this.b, H, "push_sql_err:" + str38);
                                                                    this.b.v0(str);
                                                                    this.d.O(false);
                                                                    this.d.K("Error8:push_sql_err:" + str38);
                                                                    q("8", "push_sql_err:" + exc2.getMessage() + str30);
                                                                    zK = z8;
                                                                    z3 = false;
                                                                    if (z3) {
                                                                        this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_init_data','1','pref#push_init',0)");
                                                                        str5 = str2;
                                                                        this.b.Lc("online_push_init_data", str5);
                                                                    } else {
                                                                        str5 = str2;
                                                                    }
                                                                    if (zK) {
                                                                        this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_closed_data','1','pref#push_closed',0)");
                                                                        str6 = str3;
                                                                        if (this.b.ia("online_push_closed_data", str6).equals(str6)) {
                                                                            while (i < r8) {
                                                                                C1839c10.z(this.b, H, "push_init=update_h_table:" + str40);
                                                                                this.b.v0(str4 + str40 + " set online_ref2=null where  online_ref2 is not null and " + this.y + "  ");
                                                                            }
                                                                        }
                                                                        this.b.Lc("online_push_closed_data", str5);
                                                                    }
                                                                    this.d.O(false);
                                                                    if (z3) {
                                                                        this.d.L("ERROR...#");
                                                                        return;
                                                                    } else {
                                                                        this.d.L("Wait...#");
                                                                        M00.y = false;
                                                                        return;
                                                                    }
                                                                }
                                                            } catch (Exception e8) {
                                                                e = e8;
                                                                str3 = str23;
                                                            }
                                                            this.b.v0(str);
                                                            this.d.O(false);
                                                            this.d.J(exc, 21);
                                                            q("21", exc.getMessage() + str30);
                                                            exc.printStackTrace();
                                                        }
                                                        str3 = str23;
                                                        str30 = str13;
                                                        str26 = str15;
                                                        str4 = str18;
                                                        str24 = str35;
                                                        str16 = str16;
                                                        str25 = str7;
                                                        try {
                                                            int iR2 = M00.r(this.b);
                                                            this.b.x0(str4 + str38 + " set online='" + i7 + "',online_ref2= rowid||':'||'" + C2160f10.F(this.b) + str30 + str22 + "'  where rowid in(select a.rowid from " + str38 + " a where " + this.z + str24 + str25 + " order by a.rowid  limit " + this.d.o + ")");
                                                            M00.G(iR2, this.b);
                                                            Z00 z09 = this.b;
                                                            StringBuilder sb9 = new StringBuilder();
                                                            sb9.append(" where online='");
                                                            sb9.append(i7);
                                                            sb9.append("'  ");
                                                            sb9.append(str25);
                                                            z09.x0(M00.x(z09, "insert", str38, sb9.toString(), str22, "1", "1"));
                                                        } catch (Exception e9) {
                                                            e = e9;
                                                            exc2 = e;
                                                            str = str8;
                                                            exc2.printStackTrace();
                                                            C1839c10.z(this.b, H, "push_sql_err:" + str38);
                                                            this.b.v0(str);
                                                            this.d.O(false);
                                                            this.d.K("Error8:push_sql_err:" + str38);
                                                            q("8", "push_sql_err:" + exc2.getMessage() + str30);
                                                            zK = z8;
                                                            z3 = false;
                                                            if (z3) {
                                                                this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_init_data','1','pref#push_init',0)");
                                                                str5 = str2;
                                                                this.b.Lc("online_push_init_data", str5);
                                                            } else {
                                                                str5 = str2;
                                                            }
                                                            if (zK) {
                                                                this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_closed_data','1','pref#push_closed',0)");
                                                                str6 = str3;
                                                                if (this.b.ia("online_push_closed_data", str6).equals(str6)) {
                                                                    while (i < r8) {
                                                                        C1839c10.z(this.b, H, "push_init=update_h_table:" + str40);
                                                                        this.b.v0(str4 + str40 + " set online_ref2=null where  online_ref2 is not null and " + this.y + "  ");
                                                                    }
                                                                }
                                                                this.b.Lc("online_push_closed_data", str5);
                                                            }
                                                            this.d.O(false);
                                                            if (z3) {
                                                                this.d.L("ERROR...#");
                                                                return;
                                                            } else {
                                                                this.d.L("Wait...#");
                                                                M00.y = false;
                                                                return;
                                                            }
                                                        }
                                                        i5++;
                                                        str18 = str4;
                                                        str13 = str30;
                                                        str16 = str16;
                                                        str33 = str33;
                                                        str12 = str44;
                                                        i4 = i13;
                                                        str14 = str43;
                                                        i2 = i14;
                                                        str10 = str10;
                                                        str17 = str3;
                                                        str7 = str25;
                                                        str15 = str26;
                                                        i3 = i3;
                                                        str35 = str24;
                                                        strX4 = strX4;
                                                    } catch (Exception e10) {
                                                        e = e10;
                                                        str3 = str23;
                                                        str30 = str13;
                                                        str4 = str18;
                                                        exc2 = e;
                                                        str = str8;
                                                    }
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    str30 = str13;
                                                    str4 = str18;
                                                    str3 = str17;
                                                }
                                            }
                                            str19 = str16;
                                            str30 = str13;
                                            str4 = str18;
                                            String str46 = str7;
                                            str20 = str35;
                                            str3 = str17;
                                            str21 = str33;
                                            i6 = Integer.parseInt(this.b.X4(str11 + str38 + str9 + this.y + str20 + str46));
                                            if (i6 > 0) {
                                                C1839c10.z(this.b, H, "ERROR:push:table=" + str38 + str19 + i6);
                                                M00.y = false;
                                                this.d.O(false);
                                                this.d.L("ERROR......");
                                                return;
                                            }
                                            str = str8;
                                            try {
                                                this.b.v0(str);
                                                i11++;
                                                str37 = str4;
                                                str28 = str9;
                                                strArr4 = strArr;
                                                z4 = z7;
                                                zK = z8;
                                                str32 = str2;
                                                str33 = str21;
                                                str34 = str3;
                                                i12 = 21;
                                                str31 = str;
                                                str29 = str11;
                                                str35 = str20;
                                            } catch (Exception e12) {
                                                e = e12;
                                            }
                                        }
                                        i6 = Integer.parseInt(this.b.X4(str11 + str38 + str9 + this.y + str20 + str46));
                                        if (i6 > 0) {
                                            C1839c10.z(this.b, H, "ERROR:push:table=" + str38 + str19 + i6);
                                            M00.y = false;
                                            this.d.O(false);
                                            this.d.L("ERROR......");
                                            return;
                                        }
                                        str = str8;
                                        this.b.v0(str);
                                        i11++;
                                        str37 = str4;
                                        str28 = str9;
                                        strArr4 = strArr;
                                        z4 = z7;
                                        zK = z8;
                                        str32 = str2;
                                        str33 = str21;
                                        str34 = str3;
                                        i12 = 21;
                                        str31 = str;
                                        str29 = str11;
                                        str35 = str20;
                                    } catch (Exception e13) {
                                        e = e13;
                                        str = str8;
                                    }
                                    this.b.v0("update trigger_flags set is_active=0");
                                    i4 = Integer.parseInt(this.b.X4("select ifnull(max(online),0) as _id from " + str38));
                                    new ArrayList();
                                    new ArrayList();
                                    i5 = 0;
                                    while (i5 < i3) {
                                        i7 = i5 + i4;
                                        if (i5 == 0) {
                                            t(str38);
                                        }
                                        Z00 z010 = this.b;
                                        String str47 = H;
                                        int i15 = i4;
                                        StringBuilder sb10 = new StringBuilder();
                                        sb10.append(str14);
                                        sb10.append(str38);
                                        String str48 = str14;
                                        sb10.append(":p2=");
                                        sb10.append(i7);
                                        sb10.append(":p=");
                                        sb10.append(i5);
                                        sb10.append(str16);
                                        sb10.append(i2);
                                        sb10.append(str12);
                                        sb10.append(i3);
                                        sb10.append(str10);
                                        int i16 = i2;
                                        sb10.append(this.b.ja(str33, false));
                                        sb10.append(":has_id=");
                                        sb10.append(strX4);
                                        C1839c10.z(z010, str47, sb10.toString());
                                        this.d.L(i15 + ":" + i5 + "/" + i3);
                                        str22 = "#" + i7 + "-" + i3 + ":patch";
                                        str23 = str17;
                                        String str49 = str12;
                                        if (!strX4.equals(str23)) {
                                            Z00 z011 = this.b;
                                            StringBuilder sb11 = new StringBuilder();
                                            sb11.append("select ifnull(max(id),0) as _id from(select id from ");
                                            sb11.append(str38);
                                            sb11.append(" where ");
                                            sb11.append(this.y);
                                            str24 = str35;
                                            sb11.append(str24);
                                            str25 = str7;
                                            sb11.append(str25);
                                            sb11.append(" order by id limit ");
                                            sb11.append(this.d.o);
                                            sb11.append(") as _id ");
                                            i8 = Integer.parseInt(z011.X4(sb11.toString()));
                                            iR = M00.r(this.b);
                                            str3 = str23;
                                            C1839c10.z(this.b, H, "T3");
                                            str39 = str39;
                                            if (str38.equals(str39)) {
                                                Z00 z012 = this.b;
                                                StringBuilder sb12 = new StringBuilder();
                                                str4 = str18;
                                                sb12.append(str4);
                                                sb12.append(str38);
                                                sb12.append(" set online='");
                                                sb12.append(i7);
                                                sb12.append("',online_ref2= name||':'||'");
                                                sb12.append(C2160f10.F(this.b));
                                                sb12.append("'  where id<=");
                                                sb12.append(i8);
                                                sb12.append(str24);
                                                sb12.append(str25);
                                                String str410 = str15;
                                                sb12.append(str410);
                                                sb12.append(this.y);
                                                sb12.append(" and rowid in(select a.rowid from ");
                                                sb12.append(str38);
                                                sb12.append(" a where a.id<=");
                                                sb12.append(i8);
                                                sb12.append(str410);
                                                sb12.append(this.z);
                                                sb12.append(str24);
                                                sb12.append(str25.replace(str38 + ".", "a."));
                                                sb12.append(" order by a.id  limit ");
                                                sb12.append(this.d.o);
                                                sb12.append(")");
                                                z012.x0(sb12.toString());
                                                str26 = str410;
                                                C1839c10.z(this.b, H, "T4");
                                                M00.G(iR, this.b);
                                                Z00 z013 = this.b;
                                                z013.x0(M00.x(z013, "insert", str38, " where online='" + i7 + "'  " + str25 + " order by id ", str22, "1", "1"));
                                                str30 = str13;
                                            } else {
                                                str26 = str15;
                                                str4 = str18;
                                                Z00 z014 = this.b;
                                                StringBuilder sb13 = new StringBuilder();
                                                sb13.append(str4);
                                                sb13.append(str38);
                                                sb13.append(" set online='");
                                                sb13.append(i7);
                                                sb13.append("',online_ref2= id||':'||'");
                                                sb13.append(C2160f10.F(this.b));
                                                str27 = str13;
                                                sb13.append(str27);
                                                sb13.append(str22);
                                                str13 = str27;
                                                sb13.append("'  where id<=");
                                                sb13.append(i8);
                                                sb13.append(str24);
                                                sb13.append(str25);
                                                sb13.append(str26);
                                                sb13.append(this.y);
                                                sb13.append(" and rowid in(select a.rowid from ");
                                                sb13.append(str38);
                                                sb13.append(" a where a.id<=");
                                                sb13.append(i8);
                                                sb13.append(str26);
                                                sb13.append(this.z);
                                                sb13.append(str24);
                                                sb13.append(str25.replace(str38 + ".", "a."));
                                                sb13.append(" order by a.id  limit ");
                                                sb13.append(this.d.o);
                                                sb13.append(")");
                                                z014.x0(sb13.toString());
                                                C1839c10.z(this.b, H, "T4");
                                                M00.G(iR, this.b);
                                                Z00 z015 = this.b;
                                                z015.x0(M00.x(z015, "insert", str38, " where online='" + i7 + "'  " + str25 + " order by id ", str22, "1", "1"));
                                                str30 = str13;
                                            }
                                            this.b.v0(str);
                                            this.d.O(false);
                                            this.d.J(exc, 21);
                                            q("21", exc.getMessage() + str30);
                                            exc.printStackTrace();
                                        }
                                        str3 = str23;
                                        str30 = str13;
                                        str26 = str15;
                                        str4 = str18;
                                        str24 = str35;
                                        str16 = str16;
                                        str25 = str7;
                                        int iR3 = M00.r(this.b);
                                        this.b.x0(str4 + str38 + " set online='" + i7 + "',online_ref2= rowid||':'||'" + C2160f10.F(this.b) + str30 + str22 + "'  where rowid in(select a.rowid from " + str38 + " a where " + this.z + str24 + str25 + " order by a.rowid  limit " + this.d.o + ")");
                                        M00.G(iR3, this.b);
                                        Z00 z016 = this.b;
                                        StringBuilder sb14 = new StringBuilder();
                                        sb14.append(" where online='");
                                        sb14.append(i7);
                                        sb14.append("'  ");
                                        sb14.append(str25);
                                        z016.x0(M00.x(z016, "insert", str38, sb14.toString(), str22, "1", "1"));
                                        i5++;
                                        str18 = str4;
                                        str13 = str30;
                                        str16 = str16;
                                        str33 = str33;
                                        str12 = str49;
                                        i4 = i15;
                                        str14 = str48;
                                        i2 = i16;
                                        str10 = str10;
                                        str17 = str3;
                                        str7 = str25;
                                        str15 = str26;
                                        i3 = i3;
                                        str35 = str24;
                                        strX4 = strX4;
                                    }
                                    str19 = str16;
                                    str30 = str13;
                                    str4 = str18;
                                    String str411 = str7;
                                    str20 = str35;
                                    str3 = str17;
                                    str21 = str33;
                                } catch (Exception e14) {
                                    e = e14;
                                    str = str8;
                                    str30 = str13;
                                    str4 = str18;
                                    str3 = str17;
                                }
                                sb2.append("select count(*) as _id from pragma_table_info('");
                                sb2.append(str38);
                                sb2.append("') where name='id'");
                                strX4 = z00.X4(sb2.toString());
                                Z00 z017 = this.b;
                                StringBuilder sb15 = new StringBuilder();
                                sb15.append(str29);
                                sb15.append(str38);
                                sb15.append(str28);
                                str9 = str28;
                                sb15.append(this.y);
                                sb15.append(str35);
                                sb15.append(str7);
                                i2 = Integer.parseInt(z017.X4(sb15.toString()));
                                U(str38);
                                if (i2 > 0) {
                                    i3 = (i2 / this.d.o) + 1;
                                } else {
                                    i3 = 0;
                                }
                                str10 = ":server=";
                                str11 = str29;
                                str12 = ":no=";
                                str13 = str30;
                                str14 = "push:table=";
                                str15 = " and ";
                                str16 = ":cnt=";
                                if (i2 > 0) {
                                    str18 = str37;
                                    Z00 z018 = this.b;
                                    String str412 = H;
                                    StringBuilder sb16 = new StringBuilder();
                                    sb16.append("push:table=");
                                    sb16.append(str38);
                                    sb16.append(":cnt=");
                                    sb16.append(i2);
                                    sb16.append(":no=");
                                    sb16.append(i3);
                                    sb16.append(":server=");
                                    str17 = str34;
                                    sb16.append(this.b.ja(str33, false));
                                    sb16.append(":has_id=");
                                    sb16.append(strX4);
                                    C1839c10.z(z018, str412, sb16.toString());
                                } else {
                                    str17 = str34;
                                    str18 = str37;
                                }
                            } catch (Exception e15) {
                                e = e15;
                                str3 = str34;
                                str4 = str37;
                            }
                            M00.G(M00.r(this.b), this.b);
                            Z00 z019 = this.b;
                            StringBuilder sb17 = new StringBuilder();
                            str8 = str31;
                        } catch (Exception e16) {
                            e = e16;
                            str = str31;
                            str3 = str34;
                            str4 = str37;
                        }
                        str2 = str32;
                        exc2 = e;
                        try {
                            exc2.printStackTrace();
                            C1839c10.z(this.b, H, "push_sql_err:" + str38);
                            this.b.v0(str);
                            this.d.O(false);
                            this.d.K("Error8:push_sql_err:" + str38);
                            q("8", "push_sql_err:" + exc2.getMessage() + str30);
                            zK = z8;
                            z3 = false;
                        } catch (Exception e17) {
                            e = e17;
                        }
                    }
                    str2 = str32;
                    str3 = str34;
                    str4 = str37;
                    z3 = z4;
                } else {
                    str2 = "1";
                    str3 = "0";
                    str4 = "update ";
                    z3 = z4;
                    zK = z6;
                }
                if (z3) {
                    this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_init_data','1','pref#push_init',0)");
                    str5 = str2;
                    this.b.Lc("online_push_init_data", str5);
                } else {
                    str5 = str2;
                }
                if (zK) {
                    this.b.v0("insert into table_action(action_,table_name,table_cond,ref_no,batch_) values('pref','online_push_closed_data','1','pref#push_closed',0)");
                    str6 = str3;
                    if (this.b.ia("online_push_closed_data", str6).equals(str6)) {
                        while (i < r8) {
                            C1839c10.z(this.b, H, "push_init=update_h_table:" + str40);
                            this.b.v0(str4 + str40 + " set online_ref2=null where  online_ref2 is not null and " + this.y + "  ");
                        }
                    }
                    this.b.Lc("online_push_closed_data", str5);
                }
                this.d.O(false);
                if (z3) {
                    this.d.L("ERROR...#");
                    return;
                } else {
                    this.d.L("Wait...#");
                    M00.y = false;
                    return;
                }
            } catch (Exception e18) {
                exc = e18;
                str = "update trigger_flags set is_active=1";
            }
        } catch (Exception e19) {
            e = e19;
            str = str31;
        }
        exc = e;
        this.b.v0(str);
        this.d.O(false);
        this.d.J(exc, 21);
        q("21", exc.getMessage() + str30);
        exc.printStackTrace();
    }

    public boolean N(String str, String str2) {
        try {
            int iR = M00.r(this.b);
            this.b.x0("update " + str + " set online=-1, online_ref2=id||':'||'" + C2160f10.F(this.b) + "' " + str2 + " and online_ref2 is null ");
            M00.G(iR, this.b);
            Z00 z00 = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(" and online=-1 ");
            M00.w(z00, "update", str, sb.toString(), "base#" + str, "1", "1");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.d.J(e, 7);
            q("7", e.getMessage() + "");
            C1839c10.z(this.b, H, "ERROR:push:table_base=" + str);
            M00.y = false;
            this.d.O(false);
            this.d.L("ERROR...");
            return false;
        }
    }

    public void O() {
        try {
            if (this.d.d() || this.b.ia("online_push_init_data", "0").equals("0")) {
                return;
            }
            String strIa = this.b.ia("online_push_user_limit", "20");
            int i = Integer.parseInt(this.b.X4("select count(*) as _id from table_action"));
            if (i == 0) {
                this.d.O(false);
                return;
            }
            this.d.O(true);
            if (Integer.parseInt(this.b.X4("select ifnull((select init from table_action order by id limit 1),0) as _id")) == 1) {
                strIa = "1";
                this.b.v0("CREATE INDEX if not exists bill_trans_id_date_h on bill_transactions_h(bill_id,date_);");
                this.b.v0("CREATE INDEX if not exists bills_h_id on bills_h(id);");
                this.b.v0("CREATE INDEX if not exists bills_h_ref2 on bills_h(online_ref2);");
                this.b.v0("drop INDEX if EXISTS bills_h_online;");
                this.b.v0("drop INDEX if EXISTS tran_h_online;");
                this.b.v0("drop INDEX if EXISTS bills_online;");
            } else {
                this.b.v0("drop INDEX if EXISTS bill_trans_id_date_h;");
                this.b.v0("drop INDEX if EXISTS bills_h_id;");
                this.b.v0("drop INDEX if EXISTS bills_h_ref2;");
                this.b.v0("drop INDEX if EXISTS bills_h_online;");
                this.b.v0("drop INDEX if EXISTS tran_h_online;");
                this.b.v0("drop INDEX if EXISTS bills_online;");
            }
            String str = strIa;
            int i2 = (i / Integer.parseInt(str)) + 1;
            this.b.v0("update table_action set param1=1 where rowid in(select a.rowid from table_action a  order by a.id limit " + str + "  )");
            JSONArray jSONArrayD = new C2160f10(this.b).D("select distinct max(last_action_id)  last_action_id,  GROUP_CONCAT(table_name,'" + this.k + "')  table_name,GROUP_CONCAT(table_cond,'" + this.k + "')  table_cond,GROUP_CONCAT(ref_no,'" + this.k + "')  ref_no,GROUP_CONCAT(action_,'" + this.k + "')  action_,GROUP_CONCAT(batch_,'" + this.k + "')  batch_  from(select distinct max(id) last_action_id, table_name,table_cond,ref_no,action_,batch_  from table_action  where param1 =1  group by table_name,table_cond,ref_no,action_,batch_  order by id limit " + str + ")  ");
            if (jSONArrayD != null && !jSONArrayD.equals(XMPConst.ARRAY_ITEM_NAME)) {
                C1839c10.z(this.b, H, "push_user_data:no_pr=0/" + i2 + ":push_user_flag=" + M00.x + ":" + jSONArrayD.length());
                M00 m00 = this.d;
                StringBuilder sb = new StringBuilder();
                sb.append("#");
                sb.append(i2);
                sb.append("#");
                m00.L(sb.toString());
                M00 m01 = this.d;
                if (M00.x) {
                    m01.I("5:already running...");
                    return;
                }
                M00.x = true;
                for (int i3 = 0; i3 < jSONArrayD.length(); i3++) {
                    try {
                        if (!i(jSONArrayD.getJSONObject(i3).getString("table_name"), jSONArrayD.getJSONObject(i3).getString("table_cond"), jSONArrayD.getJSONObject(i3).getString("ref_no"), jSONArrayD.getJSONObject(i3).getString("action_"), jSONArrayD.getJSONObject(i3).getString("batch_"), jSONArrayD.getJSONObject(i3).getInt("last_action_id"))) {
                            break;
                        }
                        this.b.v0("update table_action set param1=2  where rowid in(select a.rowid from table_action a  where a.param1=1 order by a.id limit " + str + "  )");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        this.d.J(e, 5);
                        q("5", e.getMessage() + "");
                    }
                }
                M00.x = false;
                jSONArrayD.length();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.d.O(false);
            this.d.J(e2, 22);
            q("22", e2.getMessage() + "");
        }
    }

    public void P() {
        if (this.d.e("read_conf")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p_un", this.d.b);
                jSONObject.put("un", this.d.c);
                jSONObject.put("fcm_token", this.d.d);
                jSONObject.put("app_id", B);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            C.a("read_conf_params", jSONObject, this.x);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.d.J(e2, 18);
        }
    }

    public void Q() {
        try {
            if (AbstractC4158vt.a(this.a)) {
                String strX4 = this.b.X4("select count(*) as _id from table_action where init=1");
                if ((strX4.length() > 0 ? Integer.parseInt(strX4) : 0) == 0) {
                    return;
                }
                u();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void R() {
        if (this.d.q != null) {
            C();
        }
    }

    public void S() {
        this.b.Lc("online_last_request_id", "-10000");
    }

    public void U(String str) {
        if (this.d.D(str)) {
            this.d.o = 30;
        } else {
            this.d.o = 50;
        }
    }

    public void V() {
        if (this.d.q != null) {
            y(new A());
        }
    }

    public void W(String str) {
        try {
            Log.d(H, "show_alert_confirm");
            Intent intent = new Intent();
            intent.setAction("info.aalmoghalis.inventory.ALERT_FROM_SERVICE");
            intent.putExtra("email_", str);
            intent.putExtra("un_", this.d.c);
            this.a.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void X() {
        String str;
        Object obj;
        try {
            C1839c10.z(this.b, H, "start:start_share_refresh:" + this.d.b);
            if (!M00.u.equals("")) {
                C1839c10.z(this.b, H, M00.u);
                this.d.L(M00.u);
                M00.u = "";
                C1839c10.z(this.b, H, "exit1:start_share_refresh");
                return;
            }
            if (this.d.d()) {
                this.d.L("Blocked!....Renew");
                return;
            }
            if (this.b.S() && !M00.w && !M00.v && !M00.y && !M00.x) {
                VQ vq = C;
                if (((vq != null && vq.F() && D != 0) || !this.b.ia("online_share_type", "0").equals("1")) && (!this.b.ia("online_share_type", "0").equals("2") || AbstractC4158vt.a(this.a))) {
                    I = Long.parseLong(this.b.ia("share_TimeMillis", "0"));
                    J = Integer.parseInt(this.b.ia("server_retry", "30"));
                    Z00 z00 = this.b;
                    String str2 = H;
                    StringBuilder sb = new StringBuilder();
                    sb.append("start_share_refresh=share_TimeMillis=");
                    sb.append(I);
                    sb.append(":server_retry=");
                    sb.append(J);
                    sb.append(":diff=");
                    sb.append((System.currentTimeMillis() - I) / 1000);
                    if (C != null) {
                        str = ":" + C.F() + ":" + C.z();
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    sb.append(":online_server=");
                    sb.append(this.b.ja("online_server", false));
                    sb.append(":online_client=");
                    sb.append(this.b.ja("online_client", false));
                    sb.append(":push_init=");
                    sb.append(this.b.ia("online_push_init_data", "0"));
                    sb.append(":conn=");
                    sb.append(D);
                    C1839c10.z(z00, str2, sb.toString());
                    if (D != 1) {
                        obj = "2";
                        if (!this.b.ia("online_share_type", "0").equals(obj)) {
                            return;
                        }
                    } else {
                        obj = "2";
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j2 = I;
                    if ((jCurrentTimeMillis - j2) / 1000 >= J || j2 == 0 || this.b.ia("online_share_type", "0").equals("1") || C1839c10.J(this.b)) {
                        try {
                            this.d.O(true);
                            M00.u = "";
                            if (this.b.ia("online_share_type", "0").equals(obj)) {
                                C1839c10.z(this.b, H, "fire1:start_share_refresh");
                                this.d.P(false);
                                M(true);
                                L();
                                this.d.k(false);
                                O();
                            } else {
                                M(true);
                                L();
                                z(false);
                                O();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            C1839c10.z(this.b, H, "Error1:start_share_refresh");
                            this.d.O(false);
                        }
                        I = System.currentTimeMillis();
                        this.b.Lc("share_TimeMillis", I + "");
                        return;
                    }
                    return;
                }
                if (C == null) {
                    C1839c10.z(this.b, H, "start_share_refresh:End:conn=" + D);
                    return;
                }
                C1839c10.z(this.b, H, "start_share_refresh:End:active=" + C.F() + ":conn=" + C.z() + ":conn=" + D);
                return;
            }
            C1839c10.z(this.b, H, "start_share_refresh=Exit:online_server=" + this.b.ja("online_server", false) + ":online_client=" + this.b.ja("online_client", false) + ":push_init=" + this.b.ia("online_push_init_data", "0") + ":conn=" + D + ":download_docs_flag=" + M00.w + ":fetch_data_flag=" + M00.v + ":push_init_flag=" + M00.y + ":push_user_flag=" + M00.x);
            if (C1839c10.o(this.b)) {
                this.d.L("Error#Retry or Exit");
                q("-1", "start_share_refresh=Exit:online_server=" + this.b.ja("online_server", false) + ":online_client=" + this.b.ja("online_client", false) + ":push_init=" + this.b.ia("online_push_init_data", "0") + ":conn=" + D + ":download_docs_flag=" + M00.w + ":fetch_data_flag=" + M00.v + ":push_init_flag=" + M00.y + ":push_user_flag=" + M00.x);
            }
        } catch (Exception e2) {
            C1839c10.z(this.b, H, "Error2:start_share_refresh");
            e2.printStackTrace();
        }
    }

    public void Y(String str, String str2, String str3) {
        if (str2.equals(this.d.d) && str3.equals(B)) {
            this.d.F(Integer.parseInt(str));
            this.b.Lc("online_last_action_id", str + "");
        }
    }

    public void Z(String str, String str2) {
        C1839c10.z(this.b, H, "last_request_id=" + str + ":failuer_db=" + this.d.i);
        Z00 z00 = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("");
        z00.Lc("online_last_request_id", sb.toString());
        this.b.Lc("online_last_time", str2 + "");
        V();
    }

    public void a0() {
        this.y = "(online_ref2 is null or online_ref2 not like '%" + C2160f10.F(this.b) + "%' )";
        this.z = "(a.online_ref2 is null or a.online_ref2 not like '%" + C2160f10.F(this.b) + "%' )";
    }

    public void b0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, "1");
            jSONObject.put("un", this.d.c);
            jSONObject.put("p_un", this.d.b);
            jSONObject.put("fcm_token", this.d.d);
            jSONObject.put("dev_id", this.d.e);
            jSONObject.put("app_id", B);
            if (this.b.ia("online_push_init_data", "0").equals("1")) {
                jSONObject.put("push_init_data", this.b.ia("online_push_init_data", "0"));
            }
            if (this.b.ia("online_push_closed_data", "0").equals("0") && this.b.ia("online_push_init_data", "0").equals("0") && this.d.c.equals("salehalialazzani")) {
                this.b.ja("online_server", false);
            }
            if (this.b.ia("online_share_type", "0").equals("1")) {
                C.a("update_user_status", jSONObject);
            } else {
                this.d.N(C2160f10.R(jSONObject));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        M00 m00 = this.d;
        if (m00.d == null || m00.c == "0") {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("un", this.d.c);
            jSONObject.put("fcm_token", this.d.d);
            jSONObject.put("app_id", B);
            jSONObject.put("android_ver", Z00.m0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            C.a("auth", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:151:0x058e A[Catch: Exception -> 0x0128, TryCatch #1 {Exception -> 0x0128, blocks: (B:3:0x0087, B:6:0x008c, B:10:0x00aa, B:13:0x00bc, B:15:0x00c8, B:17:0x00d2, B:19:0x00dc, B:21:0x00e6, B:24:0x0102, B:31:0x0132, B:34:0x0148, B:36:0x0150, B:40:0x015c, B:42:0x0164, B:48:0x01d4, B:51:0x020a, B:53:0x0247, B:56:0x0268, B:61:0x0276, B:63:0x0281, B:68:0x028f, B:70:0x029f, B:75:0x02cd, B:77:0x02da, B:79:0x02e2, B:83:0x02ee, B:85:0x02f8, B:87:0x0317, B:91:0x0329, B:149:0x0586, B:151:0x058e, B:165:0x05cd, B:166:0x0603, B:168:0x0607, B:180:0x0677, B:173:0x0614, B:175:0x064a, B:178:0x0653, B:155:0x059d, B:157:0x05a7, B:160:0x05b4, B:162:0x05be, B:163:0x05c3, B:74:0x02ab, B:52:0x0229, B:43:0x0185, B:45:0x01a1, B:47:0x01c8, B:93:0x0351, B:95:0x0362, B:96:0x038c, B:98:0x0398, B:101:0x03a6, B:103:0x03b0, B:104:0x03c6, B:106:0x03d0, B:108:0x03e9, B:110:0x03f3, B:111:0x0409, B:113:0x0413, B:114:0x0430, B:116:0x043a, B:120:0x0451, B:121:0x046a, B:123:0x0474, B:126:0x0482, B:128:0x048c, B:129:0x04a5, B:131:0x04af, B:132:0x04c8, B:134:0x04d2, B:136:0x04ed, B:138:0x04f9, B:139:0x0510, B:143:0x052e, B:144:0x0558, B:181:0x068a, B:183:0x0692, B:185:0x0698, B:187:0x069e), top: B:213:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0598  */
    /* JADX WARN: Code duplicated, block: B:155:0x059d A[Catch: Exception -> 0x0128, TryCatch #1 {Exception -> 0x0128, blocks: (B:3:0x0087, B:6:0x008c, B:10:0x00aa, B:13:0x00bc, B:15:0x00c8, B:17:0x00d2, B:19:0x00dc, B:21:0x00e6, B:24:0x0102, B:31:0x0132, B:34:0x0148, B:36:0x0150, B:40:0x015c, B:42:0x0164, B:48:0x01d4, B:51:0x020a, B:53:0x0247, B:56:0x0268, B:61:0x0276, B:63:0x0281, B:68:0x028f, B:70:0x029f, B:75:0x02cd, B:77:0x02da, B:79:0x02e2, B:83:0x02ee, B:85:0x02f8, B:87:0x0317, B:91:0x0329, B:149:0x0586, B:151:0x058e, B:165:0x05cd, B:166:0x0603, B:168:0x0607, B:180:0x0677, B:173:0x0614, B:175:0x064a, B:178:0x0653, B:155:0x059d, B:157:0x05a7, B:160:0x05b4, B:162:0x05be, B:163:0x05c3, B:74:0x02ab, B:52:0x0229, B:43:0x0185, B:45:0x01a1, B:47:0x01c8, B:93:0x0351, B:95:0x0362, B:96:0x038c, B:98:0x0398, B:101:0x03a6, B:103:0x03b0, B:104:0x03c6, B:106:0x03d0, B:108:0x03e9, B:110:0x03f3, B:111:0x0409, B:113:0x0413, B:114:0x0430, B:116:0x043a, B:120:0x0451, B:121:0x046a, B:123:0x0474, B:126:0x0482, B:128:0x048c, B:129:0x04a5, B:131:0x04af, B:132:0x04c8, B:134:0x04d2, B:136:0x04ed, B:138:0x04f9, B:139:0x0510, B:143:0x052e, B:144:0x0558, B:181:0x068a, B:183:0x0692, B:185:0x0698, B:187:0x069e), top: B:213:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:164:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:168:0x0607 A[Catch: Exception -> 0x0128, TryCatch #1 {Exception -> 0x0128, blocks: (B:3:0x0087, B:6:0x008c, B:10:0x00aa, B:13:0x00bc, B:15:0x00c8, B:17:0x00d2, B:19:0x00dc, B:21:0x00e6, B:24:0x0102, B:31:0x0132, B:34:0x0148, B:36:0x0150, B:40:0x015c, B:42:0x0164, B:48:0x01d4, B:51:0x020a, B:53:0x0247, B:56:0x0268, B:61:0x0276, B:63:0x0281, B:68:0x028f, B:70:0x029f, B:75:0x02cd, B:77:0x02da, B:79:0x02e2, B:83:0x02ee, B:85:0x02f8, B:87:0x0317, B:91:0x0329, B:149:0x0586, B:151:0x058e, B:165:0x05cd, B:166:0x0603, B:168:0x0607, B:180:0x0677, B:173:0x0614, B:175:0x064a, B:178:0x0653, B:155:0x059d, B:157:0x05a7, B:160:0x05b4, B:162:0x05be, B:163:0x05c3, B:74:0x02ab, B:52:0x0229, B:43:0x0185, B:45:0x01a1, B:47:0x01c8, B:93:0x0351, B:95:0x0362, B:96:0x038c, B:98:0x0398, B:101:0x03a6, B:103:0x03b0, B:104:0x03c6, B:106:0x03d0, B:108:0x03e9, B:110:0x03f3, B:111:0x0409, B:113:0x0413, B:114:0x0430, B:116:0x043a, B:120:0x0451, B:121:0x046a, B:123:0x0474, B:126:0x0482, B:128:0x048c, B:129:0x04a5, B:131:0x04af, B:132:0x04c8, B:134:0x04d2, B:136:0x04ed, B:138:0x04f9, B:139:0x0510, B:143:0x052e, B:144:0x0558, B:181:0x068a, B:183:0x0692, B:185:0x0698, B:187:0x069e), top: B:213:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0614 A[Catch: Exception -> 0x0128, TryCatch #1 {Exception -> 0x0128, blocks: (B:3:0x0087, B:6:0x008c, B:10:0x00aa, B:13:0x00bc, B:15:0x00c8, B:17:0x00d2, B:19:0x00dc, B:21:0x00e6, B:24:0x0102, B:31:0x0132, B:34:0x0148, B:36:0x0150, B:40:0x015c, B:42:0x0164, B:48:0x01d4, B:51:0x020a, B:53:0x0247, B:56:0x0268, B:61:0x0276, B:63:0x0281, B:68:0x028f, B:70:0x029f, B:75:0x02cd, B:77:0x02da, B:79:0x02e2, B:83:0x02ee, B:85:0x02f8, B:87:0x0317, B:91:0x0329, B:149:0x0586, B:151:0x058e, B:165:0x05cd, B:166:0x0603, B:168:0x0607, B:180:0x0677, B:173:0x0614, B:175:0x064a, B:178:0x0653, B:155:0x059d, B:157:0x05a7, B:160:0x05b4, B:162:0x05be, B:163:0x05c3, B:74:0x02ab, B:52:0x0229, B:43:0x0185, B:45:0x01a1, B:47:0x01c8, B:93:0x0351, B:95:0x0362, B:96:0x038c, B:98:0x0398, B:101:0x03a6, B:103:0x03b0, B:104:0x03c6, B:106:0x03d0, B:108:0x03e9, B:110:0x03f3, B:111:0x0409, B:113:0x0413, B:114:0x0430, B:116:0x043a, B:120:0x0451, B:121:0x046a, B:123:0x0474, B:126:0x0482, B:128:0x048c, B:129:0x04a5, B:131:0x04af, B:132:0x04c8, B:134:0x04d2, B:136:0x04ed, B:138:0x04f9, B:139:0x0510, B:143:0x052e, B:144:0x0558, B:181:0x068a, B:183:0x0692, B:185:0x0698, B:187:0x069e), top: B:213:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x064a A[Catch: Exception -> 0x0128, TryCatch #1 {Exception -> 0x0128, blocks: (B:3:0x0087, B:6:0x008c, B:10:0x00aa, B:13:0x00bc, B:15:0x00c8, B:17:0x00d2, B:19:0x00dc, B:21:0x00e6, B:24:0x0102, B:31:0x0132, B:34:0x0148, B:36:0x0150, B:40:0x015c, B:42:0x0164, B:48:0x01d4, B:51:0x020a, B:53:0x0247, B:56:0x0268, B:61:0x0276, B:63:0x0281, B:68:0x028f, B:70:0x029f, B:75:0x02cd, B:77:0x02da, B:79:0x02e2, B:83:0x02ee, B:85:0x02f8, B:87:0x0317, B:91:0x0329, B:149:0x0586, B:151:0x058e, B:165:0x05cd, B:166:0x0603, B:168:0x0607, B:180:0x0677, B:173:0x0614, B:175:0x064a, B:178:0x0653, B:155:0x059d, B:157:0x05a7, B:160:0x05b4, B:162:0x05be, B:163:0x05c3, B:74:0x02ab, B:52:0x0229, B:43:0x0185, B:45:0x01a1, B:47:0x01c8, B:93:0x0351, B:95:0x0362, B:96:0x038c, B:98:0x0398, B:101:0x03a6, B:103:0x03b0, B:104:0x03c6, B:106:0x03d0, B:108:0x03e9, B:110:0x03f3, B:111:0x0409, B:113:0x0413, B:114:0x0430, B:116:0x043a, B:120:0x0451, B:121:0x046a, B:123:0x0474, B:126:0x0482, B:128:0x048c, B:129:0x04a5, B:131:0x04af, B:132:0x04c8, B:134:0x04d2, B:136:0x04ed, B:138:0x04f9, B:139:0x0510, B:143:0x052e, B:144:0x0558, B:181:0x068a, B:183:0x0692, B:185:0x0698, B:187:0x069e), top: B:213:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0159  */
    /* JADX WARN: Code duplicated, block: B:45:0x01a1 A[Catch: Exception -> 0x0128, TryCatch #1 {Exception -> 0x0128, blocks: (B:3:0x0087, B:6:0x008c, B:10:0x00aa, B:13:0x00bc, B:15:0x00c8, B:17:0x00d2, B:19:0x00dc, B:21:0x00e6, B:24:0x0102, B:31:0x0132, B:34:0x0148, B:36:0x0150, B:40:0x015c, B:42:0x0164, B:48:0x01d4, B:51:0x020a, B:53:0x0247, B:56:0x0268, B:61:0x0276, B:63:0x0281, B:68:0x028f, B:70:0x029f, B:75:0x02cd, B:77:0x02da, B:79:0x02e2, B:83:0x02ee, B:85:0x02f8, B:87:0x0317, B:91:0x0329, B:149:0x0586, B:151:0x058e, B:165:0x05cd, B:166:0x0603, B:168:0x0607, B:180:0x0677, B:173:0x0614, B:175:0x064a, B:178:0x0653, B:155:0x059d, B:157:0x05a7, B:160:0x05b4, B:162:0x05be, B:163:0x05c3, B:74:0x02ab, B:52:0x0229, B:43:0x0185, B:45:0x01a1, B:47:0x01c8, B:93:0x0351, B:95:0x0362, B:96:0x038c, B:98:0x0398, B:101:0x03a6, B:103:0x03b0, B:104:0x03c6, B:106:0x03d0, B:108:0x03e9, B:110:0x03f3, B:111:0x0409, B:113:0x0413, B:114:0x0430, B:116:0x043a, B:120:0x0451, B:121:0x046a, B:123:0x0474, B:126:0x0482, B:128:0x048c, B:129:0x04a5, B:131:0x04af, B:132:0x04c8, B:134:0x04d2, B:136:0x04ed, B:138:0x04f9, B:139:0x0510, B:143:0x052e, B:144:0x0558, B:181:0x068a, B:183:0x0692, B:185:0x0698, B:187:0x069e), top: B:213:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:89:0x0324  */
    /* JADX WARN: Code duplicated, block: B:90:0x0327  */
    /* JADX WARN: Instruction removed from duplicated block: B:45:0x01a1, please report this as an issue */
    public boolean i(String str, String str2, String str3, String str4, String str5, long j2) {
        String str6;
        String str7;
        String str8;
        String[] strArr;
        String[] strArr2;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        Object obj;
        String str14;
        String[] strArr3;
        String string;
        String str15;
        String[] strArr4;
        String str16;
        String str17;
        String str18;
        String[] strArr5;
        String str19;
        String[] strArr6;
        String str20;
        String string2;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25 = "update";
        String str26 = "cus_id";
        String str27 = "patch#first_year";
        String str28 = SearchIntents.EXTRA_QUERY;
        Z00 z00 = this.b;
        String str29 = H;
        StringBuilder sb = new StringBuilder();
        sb.append("add_data_0:action=");
        sb.append(str4);
        sb.append(":table=");
        sb.append(str);
        String str30 = ":table=";
        sb.append(":cond=");
        sb.append(str2);
        sb.append(":ref_no=");
        sb.append(str3);
        sb.append(":last_action_id=");
        sb.append(j2);
        C1839c10.z(z00, str29, sb.toString());
        String[] strArrSplit = str.split(this.j);
        String[] strArrSplit2 = str2.split(this.j);
        String[] strArrSplit3 = str3.split(this.j);
        String[] strArrSplit4 = str4.split(this.j);
        String[] strArrSplit5 = str5.split(this.j);
        String[] strArr7 = new String[strArrSplit.length];
        String[] strArr8 = new String[strArrSplit.length];
        int i = 0;
        while (i < strArrSplit.length) {
            try {
                strArr8[i] = strArrSplit[i];
                strArr7[i] = strArrSplit[i];
                new C1839c10(this.b);
                C1839c10.o(this.b);
                if (strArrSplit3[i].equals("0")) {
                    return false;
                }
                if (strArrSplit4.equals(str28)) {
                    strArr = strArr7;
                } else {
                    strArr = strArr7;
                    if (!strArrSplit3[i].startsWith("h_table#query:") && !strArrSplit3[i].startsWith("bills#query:closing_action:") && !strArrSplit3[i].startsWith("items#query:closing_action:") && !strArrSplit3[i].startsWith("transactions#query:closing_action:")) {
                        str13 = str28;
                        str10 = str25;
                        String str31 = str26;
                        if (this.d.D(strArrSplit[i])) {
                            t(strArrSplit[i]);
                            strArr2 = strArr8;
                            String strO = this.d.o(strArrSplit[i]);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("(select name from items where id=item_id) item_name_,(select name from item_type where id=item_type_id) item_type_name_,(select name from currency where id=curr_id) curr_name_");
                            sb2.append(this.d.u(strO, "cash_id") ? ",(select name from customers where id=cash_id) cash_name_" : "");
                            sb2.append(",(select name from units where id=unit_id) unit_name_,(select name from units where id=base_unit) base_unit_name_");
                            String str32 = str27;
                            if (!strArrSplit3[i].equals(str27) || (!strArrSplit[i].equals("bills") && !strArrSplit[i].equals("bills2"))) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(",(select online_ref2 from ");
                                sb3.append(strArrSplit[i]);
                                sb3.append(" where id=bill_id");
                                if (this.d.z(strO)) {
                                    str20 = " and " + strArrSplit[i] + ".date_=" + strO + ".date_ ";
                                } else {
                                    str20 = " ";
                                }
                                sb3.append(str20);
                                sb3.append(") online_ref2");
                                string2 = sb3.toString();
                            } else if (strArrSplit4[i].equals("insert")) {
                                string2 = ",(bill_id||':'||" + C2160f10.F(this.b) + ") as online_ref2 ";
                                strArrSplit4 = strArrSplit4;
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(",(select online_ref2 from ");
                                sb4.append(strArrSplit[i]);
                                sb4.append(" where id=bill_id");
                                if (this.d.z(strO)) {
                                    str20 = " and " + strArrSplit[i] + ".date_=" + strO + ".date_ ";
                                } else {
                                    str20 = " ";
                                }
                                sb4.append(str20);
                                sb4.append(") online_ref2");
                                string2 = sb4.toString();
                            }
                            sb2.append(string2);
                            sb2.append(",* ");
                            String string3 = sb2.toString();
                            String[] strArr9 = {"item_id", "item_type_id", "curr_id", "unit_id", "base_unit"};
                            C2160f10 c2160f10 = new C2160f10(this.b);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("select ");
                            sb5.append(string3);
                            str12 = " from ";
                            sb5.append(str12);
                            sb5.append(strO);
                            if (this.d.z(strO)) {
                                str21 = " where (bill_id,date_) in ( select id,date_ from " + strArrSplit[i] + "  " + strArrSplit2[i] + " )";
                            } else {
                                str21 = " where bill_id in( select id from " + strArrSplit[i] + "  " + strArrSplit2[i] + " )";
                            }
                            sb5.append(str21);
                            strArr2[i] = c2160f10.C(sb5.toString(), strArr9);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("(select name from customers where id=cus_id) cus_name_,(select name from branches where id=br_id) br_name_,(select name from branches where id=to_br_id) to_br_name_,(select name from currency where id=curr_id) curr_name_,(select name from customers where id=cash_id) cash_name_");
                            sb6.append((strArrSplit[i].equals("bills") || strArrSplit[i].equals("bills_h")) ? ",(select name from tax where id=tax_id) tax_name_" : "");
                            sb6.append((strArrSplit[i].equals("bills") || strArrSplit[i].equals("bills_h")) ? ",(select name from customers where id=cost_id) cost_name_" : "");
                            sb6.append(",(select name from users where id=user_id) user_name_,(select name from users where id=last_user) last_user_name_");
                            if (strArrSplit[i].equals("bills") || strArrSplit[i].equals("bills_h")) {
                                str22 = ",(select b.online_ref2 from " + strArrSplit[i] + " b where b.id=" + strArrSplit[i] + ".id2) id2_ref_";
                            } else {
                                str22 = "";
                            }
                            sb6.append(str22);
                            str14 = str32;
                            if (strArrSplit3[i].equals(str14) && (strArrSplit[i].equals("bills") || strArrSplit[i].equals("bills2"))) {
                                obj = "insert";
                                if (strArrSplit4[i].equals(obj)) {
                                    str23 = ",(id||':'||" + C2160f10.F(this.b) + ") as online_ref3 ";
                                }
                                sb6.append(str23);
                                if (this.d.B(strArrSplit[i])) {
                                    str24 = ",id id_id";
                                } else {
                                    str24 = "";
                                }
                                sb6.append(str24);
                                sb6.append(",* ");
                                string = sb6.toString();
                                strArr3 = new String[]{"cus_id", "br_id", "to_br_id", "curr_id", "cash_id", "tax_id", "cost_id", "user_id", "last_user", "id2", HTML.Attribute.ID};
                            } else {
                                obj = r6;
                            }
                            str23 = "";
                            sb6.append(str23);
                            if (this.d.B(strArrSplit[i])) {
                                str24 = ",id id_id";
                            } else {
                                str24 = "";
                            }
                            sb6.append(str24);
                            sb6.append(",* ");
                            string = sb6.toString();
                            strArr3 = new String[]{"cus_id", "br_id", "to_br_id", "curr_id", "cash_id", "tax_id", "cost_id", "user_id", "last_user", "id2", HTML.Attribute.ID};
                        } else {
                            strArrSplit4 = strArrSplit4;
                            strArr2 = strArr8;
                            str12 = " from ";
                            obj = "insert";
                            str14 = str27;
                            if (this.d.g(strArrSplit[i])) {
                                string = "(select online_ref2 from " + this.d.s(strArrSplit[i]) + " where id=bill_id) online_ref2,*";
                                strArr3 = new String[]{"bill_id"};
                            } else {
                                str9 = "*";
                                if (strArrSplit[i].equals("items") || strArrSplit[i].equals("items_h")) {
                                    str11 = str31;
                                    str18 = "(select name from item_type where id=item_type_id) item_type_name_,(select name from currency where id=curr_id) curr_name_,(select name from branches where id=o_br_id) o_br_name_,(select name from units where id=unit_id) unit_name_,id id_id," + str9;
                                    strArr5 = new String[]{"item_type_id", "curr_id", "unit_id", "o_br_id"};
                                } else if (strArrSplit[i].equals("unit_item")) {
                                    string = "(select name from items where id=item_id) item_name_,(select name from units where id=unit_id) unit_name_,id id_id," + str9;
                                    strArr3 = new String[]{"item_id", "unit_id"};
                                } else {
                                    if (strArrSplit[i].equals("item_price")) {
                                        str19 = "(select name from items where id=item_id) item_name_,(select name from units where id=ifnull(unit_id,0)) unit_name_,(select name from currency where id=curr_id) curr_name_," + str9;
                                        strArr6 = new String[]{"item_id", "unit_id", "curr_id"};
                                    } else if (strArrSplit[i].equals("currency_price")) {
                                        str19 = "(select name from currency where id=curr_id) curr_name_,id id_id," + str9;
                                        strArr6 = new String[]{"curr_id"};
                                    } else if (strArrSplit[i].equals("customers")) {
                                        string = "(select name from groups where id=g_id) g_name_,(select name from cus_type where id=cus_type_id) cus_type_name_,(select name from account_tree where id=acc_p_id) acc_p_name_,id id_id," + str9;
                                        strArr3 = new String[]{"g_id", "cus_type_id", "acc_p_id"};
                                    } else if (strArrSplit[i].equals("account_tree")) {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("(select name from account_tree b where b.id=account_tree.parent_id) parent_name_");
                                        sb7.append(strArrSplit4[i].equals(obj) ? ",(select name from account_tree b where b.id=account_tree.parent_id) as p_id_ref_" : "");
                                        sb7.append(",(select name from account_tree_type b where b.id=account_tree.p ) p_id_ref2_,");
                                        sb7.append(str9);
                                        string = sb7.toString();
                                        strArr3 = new String[]{"parent_id", "p"};
                                    } else if (strArrSplit[i].equals("transactions") || strArrSplit[i].equals("transactions_h")) {
                                        str11 = str31;
                                        t(strArrSplit[i]);
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append("(select name from customers where id=cus_id) cus_name_,(select name from customers where id=t_cus_id) t_cus_name_,(select name from currency where id=curr_id) curr_name_,(select name from currency where id=p_curr_id) p_curr_name_,(select name from currency where id=c_curr_id) c_curr_name_,(select name from items where id=item_id) item_name_,(select name from customers where id=cash_id) cash_name_,(select name from customers where id=fund_id) fund_name_,(select name from users where id=user_id) user_name_,(select name from users where id=last_user) last_user_name_");
                                        sb8.append(this.d.B(strArrSplit[i]) ? ",id id_id" : "");
                                        sb8.append(",");
                                        sb8.append(str9);
                                        string = sb8.toString();
                                        strArr3 = new String[]{"cus_id", "t_cus_id", "curr_id", "p_curr_id", "c_curr_id", "cash_id", "fund_id", "user_id", "last_user", HTML.Attribute.ID, "item_id"};
                                    } else if (strArrSplit[i].equals("user_priv")) {
                                        string = "(select name from users where id=user_id) user_name_,id id_id," + str9;
                                        strArr3 = new String[]{"user_id"};
                                    } else if (strArrSplit[i].equals("users")) {
                                        string = "(select name from branches where id=br_id) br_name_,(select name from customers where id=cash_id) cash_name_,id id_id," + str9;
                                        strArr3 = new String[]{"br_id", "cash_id"};
                                    } else if (strArrSplit[i].equals("cus_limit")) {
                                        str18 = "(select name from customers where id=cus_id) cus_name_,(select name from currency where id=curr_id) curr_name_,id id_id," + str9;
                                        str11 = str31;
                                        strArr5 = new String[]{str11, "curr_id"};
                                    } else {
                                        str11 = str31;
                                        if (strArrSplit[i].equals("reminders")) {
                                            string = "(select name from customers where id=cus_id) cus_name_,id id_id," + str9;
                                            strArr3 = new String[]{str11};
                                        } else {
                                            strArr3 = null;
                                            string = str9;
                                        }
                                    }
                                    string = str19;
                                    strArr3 = strArr6;
                                }
                                string = str18;
                                strArr3 = strArr5;
                            }
                        }
                        str11 = str31;
                    }
                    if (strArrSplit4[i].equals(obj)) {
                        str15 = str10;
                    } else {
                        str15 = str10;
                        if (strArrSplit4[i].equals(str15)) {
                            str13 = str13;
                            if (!strArrSplit4[i].equals(str13) || strArrSplit4[i].equals("delete")) {
                                strArr4 = strArrSplit4;
                                strArr[i] = strArrSplit[i];
                            } else {
                                strArr4 = strArrSplit4;
                                if (strArr4.equals("pref")) {
                                    strArr[i] = strArrSplit[i];
                                }
                            }
                        }
                        str16 = strArr[i];
                        if (str16 != null || str16.equals(XMPConst.ARRAY_ITEM_NAME)) {
                            Z00 z01 = this.b;
                            String str33 = H;
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append("Exit:add_data:action=");
                            sb9.append(strArr4[i]);
                            str17 = str30;
                            sb9.append(str17);
                            sb9.append(strArrSplit[i]);
                            sb9.append(":data=");
                            sb9.append(strArr[i]);
                            C1839c10.z(z01, str33, sb9.toString());
                            if (!strArr4[i].equals(obj) && !strArr4[i].equals(str15)) {
                                this.d.K("Error: Exit:add_data:action=" + strArr4[i] + ":" + strArrSplit3[i]);
                                return false;
                            }
                        } else {
                            str17 = str30;
                        }
                        i++;
                        str27 = str14;
                        str30 = str17;
                        strArrSplit4 = strArr4;
                        strArr7 = strArr;
                        str28 = str13;
                        strArr8 = strArr2;
                        String str34 = str15;
                        str26 = str11;
                        str25 = str34;
                    }
                    strArr4 = strArrSplit4;
                    strArr[i] = new C2160f10(this.b).C("select " + string + str12 + strArrSplit[i] + " " + strArrSplit2[i].replace("''", "'"), strArr3);
                    str16 = strArr[i];
                    if (str16 != null) {
                        Z00 z02 = this.b;
                        String str35 = H;
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("Exit:add_data:action=");
                        sb10.append(strArr4[i]);
                        str17 = str30;
                        sb10.append(str17);
                        sb10.append(strArrSplit[i]);
                        sb10.append(":data=");
                        sb10.append(strArr[i]);
                        C1839c10.z(z02, str35, sb10.toString());
                        if (!strArr4[i].equals(obj)) {
                            this.d.K("Error: Exit:add_data:action=" + strArr4[i] + ":" + strArrSplit3[i]);
                            return false;
                        }
                    } else {
                        Z00 z03 = this.b;
                        String str36 = H;
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("Exit:add_data:action=");
                        sb11.append(strArr4[i]);
                        str17 = str30;
                        sb11.append(str17);
                        sb11.append(strArrSplit[i]);
                        sb11.append(":data=");
                        sb11.append(strArr[i]);
                        C1839c10.z(z03, str36, sb11.toString());
                        if (!strArr4[i].equals(obj)) {
                            this.d.K("Error: Exit:add_data:action=" + strArr4[i] + ":" + strArrSplit3[i]);
                            return false;
                        }
                    }
                    i++;
                    str27 = str14;
                    str30 = str17;
                    strArrSplit4 = strArr4;
                    strArr7 = strArr;
                    str28 = str13;
                    strArr8 = strArr2;
                    String str37 = str15;
                    str26 = str11;
                    str25 = str37;
                }
                strArr2 = strArr8;
                str9 = "*";
                str10 = str25;
                str11 = str26;
                str12 = " from ";
                str13 = str28;
                obj = "insert";
                str14 = str27;
                strArr3 = null;
                string = str9;
                if (strArrSplit4[i].equals(obj)) {
                    str15 = str10;
                    if (strArrSplit4[i].equals(str15)) {
                        str13 = str13;
                        if (strArrSplit4[i].equals(str13)) {
                            strArr4 = strArrSplit4;
                            strArr[i] = strArrSplit[i];
                        } else {
                            strArr4 = strArrSplit4;
                            strArr[i] = strArrSplit[i];
                        }
                    }
                    str16 = strArr[i];
                    if (str16 != null) {
                        Z00 z04 = this.b;
                        String str38 = H;
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append("Exit:add_data:action=");
                        sb12.append(strArr4[i]);
                        str17 = str30;
                        sb12.append(str17);
                        sb12.append(strArrSplit[i]);
                        sb12.append(":data=");
                        sb12.append(strArr[i]);
                        C1839c10.z(z04, str38, sb12.toString());
                        if (!strArr4[i].equals(obj)) {
                            this.d.K("Error: Exit:add_data:action=" + strArr4[i] + ":" + strArrSplit3[i]);
                            return false;
                        }
                    } else {
                        Z00 z05 = this.b;
                        String str39 = H;
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("Exit:add_data:action=");
                        sb13.append(strArr4[i]);
                        str17 = str30;
                        sb13.append(str17);
                        sb13.append(strArrSplit[i]);
                        sb13.append(":data=");
                        sb13.append(strArr[i]);
                        C1839c10.z(z05, str39, sb13.toString());
                        if (!strArr4[i].equals(obj)) {
                            this.d.K("Error: Exit:add_data:action=" + strArr4[i] + ":" + strArrSplit3[i]);
                            return false;
                        }
                    }
                    i++;
                    str27 = str14;
                    str30 = str17;
                    strArrSplit4 = strArr4;
                    strArr7 = strArr;
                    str28 = str13;
                    strArr8 = strArr2;
                    String str310 = str15;
                    str26 = str11;
                    str25 = str310;
                } else {
                    str15 = str10;
                }
                strArr4 = strArrSplit4;
                strArr[i] = new C2160f10(this.b).C("select " + string + str12 + strArrSplit[i] + " " + strArrSplit2[i].replace("''", "'"), strArr3);
                str16 = strArr[i];
                if (str16 != null) {
                    Z00 z06 = this.b;
                    String str311 = H;
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append("Exit:add_data:action=");
                    sb14.append(strArr4[i]);
                    str17 = str30;
                    sb14.append(str17);
                    sb14.append(strArrSplit[i]);
                    sb14.append(":data=");
                    sb14.append(strArr[i]);
                    C1839c10.z(z06, str311, sb14.toString());
                    if (!strArr4[i].equals(obj)) {
                        this.d.K("Error: Exit:add_data:action=" + strArr4[i] + ":" + strArrSplit3[i]);
                        return false;
                    }
                } else {
                    Z00 z07 = this.b;
                    String str312 = H;
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append("Exit:add_data:action=");
                    sb15.append(strArr4[i]);
                    str17 = str30;
                    sb15.append(str17);
                    sb15.append(strArrSplit[i]);
                    sb15.append(":data=");
                    sb15.append(strArr[i]);
                    C1839c10.z(z07, str312, sb15.toString());
                    if (!strArr4[i].equals(obj)) {
                        this.d.K("Error: Exit:add_data:action=" + strArr4[i] + ":" + strArrSplit3[i]);
                        return false;
                    }
                }
                i++;
                str27 = str14;
                str30 = str17;
                strArrSplit4 = strArr4;
                strArr7 = strArr;
                str28 = str13;
                strArr8 = strArr2;
                String str313 = str15;
                str26 = str11;
                str25 = str313;
            } catch (Exception e) {
                e = e;
                str6 = "1";
                str7 = "";
            }
        }
        String[] strArr10 = strArrSplit4;
        String[] strArr11 = strArr7;
        String[] strArr12 = strArr8;
        if (strArrSplit.length > 0 && (str8 = this.d.b) != null && str8.length() > 0) {
            HashMap mapC = this.d.c(strArrSplit, strArr10, strArr11, strArr12, strArrSplit2, strArrSplit3, strArrSplit5);
            StringBuilder sb16 = new StringBuilder();
            sb16.append(j2);
            str7 = "";
            try {
                sb16.append(str7);
                mapC.put("last_action_id", sb16.toString());
                C1839c10.z(this.b, H, "add_data:" + mapC);
                if (C1839c10.o(this.b)) {
                    C1839c10.z(this.b, H, "add_data_size:" + x(C2160f10.O(mapC)) + " kb");
                }
                str6 = "1";
                try {
                    try {
                        if (this.b.ia("online_share_type", "0").equals(str6)) {
                            JSONObject jSONObjectO = C2160f10.O(mapC);
                            VQ vq = C;
                            U1 u1 = this.o;
                            Object[] objArr = new Object[2];
                            objArr[0] = jSONObjectO;
                            objArr[1] = u1;
                            vq.a("add_data", objArr);
                        } else if (this.b.ia("online_share_type", "0").equals("2")) {
                            this.d.b(mapC, j2);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        this.d.J(e, 1);
                        q(str6, e.getMessage() + str7);
                        return false;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    this.d.J(e, 1);
                    q(str6, e.getMessage() + str7);
                    return false;
                }
            } catch (Exception e4) {
                e = e4;
                str6 = "1";
            }
        }
        return true;
    }

    public void j() {
        List list = this.n;
        if (list == null || list.size() == 0 || this.n.size() < this.l) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("p_un", this.d.b);
            jSONObject.put("un", this.d.c);
            jSONObject.put("fcm_token", this.d.d);
            jSONObject.put("dev_id", this.d.e);
            jSONObject.put("app_id", B);
            jSONObject.put("last_request_id", B());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (i < this.n.size()) {
            try {
                jSONObject.put("chunk_no", i);
                jSONObject.put("is_last", i == this.n.size() - 1 ? 1 : 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            VQ vq = C;
            if (vq != null) {
                vq.a("add_data_chunk", jSONObject, this.p);
            }
            i++;
        }
    }

    public void k(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p_un", this.d.b);
                jSONObject.put("un", this.d.c);
                jSONObject.put("fcm_token", this.d.d);
                jSONObject.put("app_id", B);
                jSONObject.put("dev_id", this.d.e);
                jSONObject.put("new_un", str.replace("@gmail.com", "").toLowerCase());
                jSONObject.put("new_push", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            VQ vq = C;
            if (vq != null) {
                vq.a("add_user", jSONObject, this.r);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.d.J(e2, 18);
        }
    }

    public void l(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (!w(jSONObjectOptJSONObject)) {
                    this.d.K("Error0:" + i + ":" + jSONObjectOptJSONObject.getString(HTML.Attribute.ID));
                    M00 m00 = this.d;
                    m00.i = true;
                    m00.O(false);
                    break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                M00.w = false;
                return;
            }
        }
        boolean z2 = this.d.i;
        if (!z2) {
            M00.w = false;
            M00.v = false;
        }
        if (!z2 && jSONArray.length() > 0) {
            z(false);
        }
        if (this.d.i || jSONArray.length() != 0) {
            return;
        }
        R();
        this.d.O(false);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x036b A[Catch: JSONException -> 0x03e3, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x03e3, blocks: (B:103:0x0349, B:107:0x036b, B:99:0x032b, B:101:0x0339), top: B:219:0x0349 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x03ca A[Catch: JSONException -> 0x03d6, TryCatch #10 {JSONException -> 0x03d6, blocks: (B:117:0x03c4, B:119:0x03ca, B:129:0x03ea, B:131:0x03f7, B:133:0x0400, B:136:0x040d), top: B:237:0x03c4 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:208:0x073d A[Catch: JSONException -> 0x071d, TryCatch #3 {JSONException -> 0x071d, blocks: (B:196:0x070a, B:198:0x0710, B:200:0x0718, B:204:0x0725, B:206:0x072b, B:209:0x0740, B:211:0x0746, B:203:0x071f, B:208:0x073d), top: B:224:0x070a }] */
    /* JADX WARN: Code duplicated, block: B:219:0x0349 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:0x03a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:0x0256 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:0x0362 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x04cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0175  */
    /* JADX WARN: Code duplicated, block: B:51:0x0180 A[Catch: JSONException -> 0x01ef, TryCatch #13 {JSONException -> 0x01ef, blocks: (B:49:0x017a, B:51:0x0180, B:53:0x019d, B:55:0x01a8, B:57:0x01ba, B:59:0x01c5, B:61:0x01cd, B:63:0x01e6, B:67:0x01f7, B:70:0x0202, B:72:0x020b, B:74:0x0213, B:76:0x022c, B:78:0x0235, B:79:0x023d, B:81:0x0256, B:83:0x029f, B:89:0x02db), top: B:243:0x017a }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0200  */
    /* JADX WARN: Code duplicated, block: B:78:0x0235 A[Catch: JSONException -> 0x01ef, TryCatch #13 {JSONException -> 0x01ef, blocks: (B:49:0x017a, B:51:0x0180, B:53:0x019d, B:55:0x01a8, B:57:0x01ba, B:59:0x01c5, B:61:0x01cd, B:63:0x01e6, B:67:0x01f7, B:70:0x0202, B:72:0x020b, B:74:0x0213, B:76:0x022c, B:78:0x0235, B:79:0x023d, B:81:0x0256, B:83:0x029f, B:89:0x02db), top: B:243:0x017a }] */
    /* JADX WARN: Code duplicated, block: B:83:0x029f A[Catch: JSONException -> 0x01ef, TryCatch #13 {JSONException -> 0x01ef, blocks: (B:49:0x017a, B:51:0x0180, B:53:0x019d, B:55:0x01a8, B:57:0x01ba, B:59:0x01c5, B:61:0x01cd, B:63:0x01e6, B:67:0x01f7, B:70:0x0202, B:72:0x020b, B:74:0x0213, B:76:0x022c, B:78:0x0235, B:79:0x023d, B:81:0x0256, B:83:0x029f, B:89:0x02db), top: B:243:0x017a }] */
    /* JADX WARN: Instruction removed from duplicated block: B:157:0x04b7, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:51:0x0180, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:83:0x029f, please report this as an issue */
    public void n(JSONObject jSONObject) {
        String str;
        StringBuilder sb;
        String str2;
        String str3;
        Iterator<String> it;
        String str4;
        String str5;
        String str6 = "-1";
        String str7 = "dev_id";
        String str8 = NotificationCompat.CATEGORY_STATUS;
        String str9 = "stop";
        String str10 = "1";
        String[] strArr = {""};
        Iterator<String> itKeys = jSONObject.keys();
        try {
            if ((this.b.ia("online_share_type", "0").equals("1") && !jSONObject.get("app_id").toString().equals(B)) || jSONObject.get("stop").toString().equals("1") || jSONObject.get(NotificationCompat.CATEGORY_STATUS).toString().equals("-1")) {
                return;
            }
            while (true) {
                String str11 = str7;
                String str12 = str6;
                String str13 = str9;
                if (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        String string = jSONObject.get(next).toString();
                        strArr[0] = string;
                        if (string.length() > 0) {
                            it = itKeys;
                            if (next.equals(str8)) {
                                String str14 = str8;
                                try {
                                    String str15 = this.d.c;
                                    StringBuilder sb2 = new StringBuilder();
                                    String str16 = str10;
                                    try {
                                        sb2.append(jSONObject.get("email"));
                                        sb2.append("");
                                        if (str15.equals(sb2.toString())) {
                                            try {
                                                if (strArr[0].equals("0")) {
                                                    if (!o(jSONObject.get("push_init_data") + "")) {
                                                        y(new CallableC0841b());
                                                        return;
                                                    }
                                                    this.b.Mc("online_server", true);
                                                    this.b.Lc("online_user", (jSONObject.get("email") + "").replace("@gmail.com", ""));
                                                    T(this.b);
                                                    this.b.m0();
                                                    y(new CallableC0842c(jSONObject));
                                                    if (this.b.ia("online_share_type", "0").equals("2")) {
                                                        this.d.M(new String[]{next}, new String[]{str16});
                                                    }
                                                    str2 = str14;
                                                    str3 = str16;
                                                } else {
                                                    str4 = str16;
                                                    try {
                                                        if (strArr[0].equals(str4)) {
                                                            if (!this.d.c.equals(jSONObject.get("email") + "") || this.b.ja("online_client_confirm", false) || this.d.c.equals(this.b.ia("online_client_confirm_un", ""))) {
                                                                str5 = "online_client";
                                                            } else {
                                                                str5 = "online_client";
                                                                if (!this.b.ja(str5, false) && !this.b.ja("online_server", false)) {
                                                                    if (o(jSONObject.get("push_init_data") + "")) {
                                                                        y(new CallableC0844e(jSONObject));
                                                                        return;
                                                                    } else {
                                                                        y(new CallableC0843d());
                                                                        return;
                                                                    }
                                                                }
                                                            }
                                                            if (!this.b.ja(str5, false) && !this.b.ja("online_server", false)) {
                                                                if (!o(jSONObject.get("push_init_data") + "")) {
                                                                    y(new CallableC0845f());
                                                                    return;
                                                                }
                                                                y(new CallableC0846g(jSONObject));
                                                            }
                                                            if (!o(jSONObject.get("push_init_data") + "")) {
                                                                y(new CallableC0847h(jSONObject.get("push_init_data") + ""));
                                                                StringBuilder sb3 = new StringBuilder();
                                                                sb3.append("Error4:old_db:");
                                                                sb3.append(p(jSONObject.get("push_init_data") + ""));
                                                                q("40", sb3.toString());
                                                                return;
                                                            }
                                                            this.b.Mc(str5, true);
                                                            this.b.Lc("online_user", (jSONObject.get("email") + "").replace("@gmail.com", ""));
                                                            T(this.b);
                                                            this.b.m0();
                                                        }
                                                        str3 = str4;
                                                        str2 = str14;
                                                    } catch (JSONException e) {
                                                        e = e;
                                                        str3 = str4;
                                                        str2 = str14;
                                                        e.printStackTrace();
                                                        if (F()) {
                                                            q("0", "trace:check_user_status:JSONException3:" + e.getMessage());
                                                        }
                                                    }
                                                }
                                            } catch (JSONException e2) {
                                                e = e2;
                                                str2 = str14;
                                                str3 = str16;
                                                e.printStackTrace();
                                                if (F()) {
                                                    q("0", "trace:check_user_status:JSONException3:" + e.getMessage());
                                                }
                                            }
                                        } else {
                                            str4 = str16;
                                            if (strArr[0].equals(str4)) {
                                                if (this.d.c.equals(jSONObject.get("email") + "")) {
                                                    str5 = "online_client";
                                                } else {
                                                    str5 = "online_client";
                                                }
                                                if (!this.b.ja(str5, false)) {
                                                    if (!o(jSONObject.get("push_init_data") + "")) {
                                                        y(new CallableC0845f());
                                                        return;
                                                    }
                                                    y(new CallableC0846g(jSONObject));
                                                }
                                                if (!o(jSONObject.get("push_init_data") + "")) {
                                                    y(new CallableC0847h(jSONObject.get("push_init_data") + ""));
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append("Error4:old_db:");
                                                    sb4.append(p(jSONObject.get("push_init_data") + ""));
                                                    q("40", sb4.toString());
                                                    return;
                                                }
                                                this.b.Mc(str5, true);
                                                this.b.Lc("online_user", (jSONObject.get("email") + "").replace("@gmail.com", ""));
                                                T(this.b);
                                                this.b.m0();
                                            }
                                            str3 = str4;
                                            str2 = str14;
                                        }
                                    } catch (JSONException e3) {
                                        e = e3;
                                        str4 = str16;
                                    }
                                } catch (JSONException e4) {
                                    e = e4;
                                    str4 = str10;
                                }
                            } else {
                                String str17 = str8;
                                String str18 = str10;
                                String str19 = this.d.c;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(jSONObject.get("email"));
                                sb5.append("");
                                if (str19.equals(sb5.toString()) && next.equals("fcm_token") && strArr[0].equals("0")) {
                                    if (!o(jSONObject.get("push_init_data") + "")) {
                                        y(new CallableC0848i());
                                        return;
                                    }
                                    this.b.Mc("online_server", true);
                                    this.b.Lc("online_user", (jSONObject.get("email") + "").replace("@gmail.com", ""));
                                    T(this.b);
                                    this.b.m0();
                                    if (this.b.ia("online_share_type", "0").equals("2")) {
                                        M00 m00 = this.d;
                                        m00.M(new String[]{"fcm"}, new String[]{m00.d});
                                    }
                                    str2 = str17;
                                    str3 = str18;
                                    if (jSONObject.get(str2).equals(str3)) {
                                        y(new j(jSONObject));
                                    }
                                    str13 = str13;
                                } else {
                                    if (this.d.c.equals(jSONObject.get("email") + "") && jSONObject.get("push_init_data").toString().equals("0") && jSONObject.get("push_closed_data").toString().equals("0")) {
                                        try {
                                            if (!o(jSONObject.get("push_init_data") + "")) {
                                                y(new CallableC0848i());
                                                return;
                                            }
                                            try {
                                                this.b.Mc("online_server", true);
                                                this.b.Lc("online_user", (jSONObject.get("email") + "").replace("@gmail.com", ""));
                                                T(this.b);
                                                this.b.m0();
                                                if (this.b.ia("online_share_type", "0").equals("2")) {
                                                    try {
                                                        M00 m01 = this.d;
                                                        m01.M(new String[]{"fcm"}, new String[]{m01.d});
                                                    } catch (JSONException e5) {
                                                        e = e5;
                                                        str13 = str13;
                                                        str2 = str17;
                                                        str3 = str18;
                                                        e.printStackTrace();
                                                        if (F()) {
                                                            q("0", "trace:check_user_status:JSONException3:" + e.getMessage());
                                                        }
                                                    }
                                                }
                                                str2 = str17;
                                                try {
                                                    str3 = str18;
                                                    try {
                                                        if (jSONObject.get(str2).equals(str3)) {
                                                            y(new j(jSONObject));
                                                        }
                                                        str13 = str13;
                                                    } catch (JSONException e6) {
                                                        e = e6;
                                                        str13 = str13;
                                                        e.printStackTrace();
                                                        if (F()) {
                                                            q("0", "trace:check_user_status:JSONException3:" + e.getMessage());
                                                        }
                                                    }
                                                } catch (JSONException e7) {
                                                    e = e7;
                                                    str3 = str18;
                                                    str13 = str13;
                                                    e.printStackTrace();
                                                    if (F()) {
                                                        q("0", "trace:check_user_status:JSONException3:" + e.getMessage());
                                                    }
                                                    str10 = str3;
                                                    str9 = str13;
                                                    str6 = str12;
                                                    itKeys = it;
                                                    str8 = str2;
                                                    str7 = str11;
                                                }
                                            } catch (JSONException e8) {
                                                e = e8;
                                                str2 = str17;
                                            }
                                        } catch (JSONException e9) {
                                            e = e9;
                                            str2 = str17;
                                            str3 = str18;
                                        }
                                    } else {
                                        str2 = str17;
                                        str3 = str18;
                                        if (!next.equals("ts") || strArr[0].length() <= 0) {
                                            str13 = str13;
                                            if (next.equals(CSS.Value.BLOCK)) {
                                                if (strArr[0].equals(str3)) {
                                                    y(new m(jSONObject));
                                                }
                                                this.b.Lc("online_stop", strArr[0]);
                                                T(this.b);
                                            }
                                        } else if (this.b.ia("online_share_type", "0").equals("2")) {
                                            str13 = str13;
                                        } else {
                                            new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                                            this.b.Lc("online_users_ts", jSONObject.get("ts") + "");
                                            Z00 z00 = this.b;
                                            StringBuilder sb6 = new StringBuilder();
                                            str13 = str13;
                                            try {
                                                sb6.append(jSONObject.get(str13));
                                                sb6.append("");
                                                z00.Lc("online_stop", sb6.toString());
                                                if (jSONObject.has(str13) && jSONObject.get(str13).toString().equals(str3)) {
                                                    this.b.Lc("online_stop", str3);
                                                    y(new l(jSONObject));
                                                }
                                            } catch (JSONException e10) {
                                                e = e10;
                                                e.printStackTrace();
                                                if (F()) {
                                                    q("0", "trace:check_user_status:JSONException3:" + e.getMessage());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            str10 = str3;
                            str9 = str13;
                            str6 = str12;
                            itKeys = it;
                            str8 = str2;
                            str7 = str11;
                        } else {
                            str2 = str8;
                            str3 = str10;
                            it = itKeys;
                        }
                    } catch (JSONException e11) {
                        e = e11;
                        str2 = str8;
                        str3 = str10;
                        it = itKeys;
                    }
                    str10 = str3;
                    str9 = str13;
                    str6 = str12;
                    itKeys = it;
                    str8 = str2;
                    str7 = str11;
                } else {
                    String str20 = str8;
                    String str21 = str10;
                    try {
                        StringBuilder sb7 = new StringBuilder();
                        try {
                            sb7.append(jSONObject.get("push_init_data"));
                            sb7.append("");
                            if (!o(sb7.toString())) {
                                y(new n());
                                return;
                            }
                            this.b.Lc("online_stop", jSONObject.get(str13) + "");
                            this.b.Lc("online_users_status", jSONObject.get(str20) + "");
                            this.b.Lc("online_push_init_data", jSONObject.get("push_init_data") + "");
                            this.b.Lc("online_push_closed_data", jSONObject.get("push_closed_data") + "");
                            if (jSONObject.get(str20).toString().equals(str12) && jSONObject.get(str13).equals(str21) && jSONObject.get(CSS.Value.BLOCK).equals(str21)) {
                                this.b.Lc("online_user", "");
                                this.b.Mc("online_server", false);
                                this.b.Mc("online_client", false);
                                return;
                            }
                            this.b.Lc("online_users_last_time", jSONObject.get("last_time") + "");
                            if (jSONObject.has("max_last_time")) {
                                this.b.Lc("online_data_last_time", jSONObject.get("max_last_time") + "");
                            } else {
                                this.b.Lc("online_data_last_time", "");
                            }
                            this.b.Lc("online_users_r_cnt", jSONObject.get("r_cnt") + "");
                            this.b.Lc("online_users_cnt", jSONObject.get("cnt") + "");
                            this.b.Lc("online_users_max_dev", jSONObject.get("max_dev") + "");
                            Z00 z01 = this.b;
                            if (jSONObject.has("uns")) {
                                sb = new StringBuilder();
                                sb.append(jSONObject.get("uns"));
                                sb.append("");
                            } else {
                                sb = new StringBuilder();
                                sb.append(jSONObject.get("un"));
                                sb.append("");
                            }
                            z01.Lc("online_data_un", sb.toString());
                            if (jSONObject.get("un") != null) {
                                this.d.b = jSONObject.get("email") + "";
                                this.b.Lc("online_users_un", (jSONObject.get("un") + "").replace("@gmail.com", ""));
                                this.b.Lc("online_users_p_un", (jSONObject.get("p_un") + "").replace("@gmail.com", ""));
                            }
                            if (jSONObject.has(str11) && jSONObject.get(str11) != null) {
                                this.b.Lc("online_users_dev_id", jSONObject.get(str11) + "");
                            }
                            str = "0";
                            try {
                                if (jSONObject.get(str20).equals(str)) {
                                    b0();
                                } else {
                                    if ((jSONObject.has("fcm_token") ? jSONObject.get("fcm_token") : jSONObject.get("fcm")).equals(str) || !jSONObject.get(str11).toString().equals(this.d.e)) {
                                        b0();
                                    }
                                }
                                if (this.d.q != null) {
                                    y(new o());
                                    return;
                                }
                                return;
                            } catch (JSONException e12) {
                                e = e12;
                                e.printStackTrace();
                                if (F()) {
                                    q(str, "trace:check_user_status:JSONException4:" + e.getMessage());
                                    return;
                                }
                                return;
                            }
                        } catch (JSONException e13) {
                            e = e13;
                            str = "0";
                        }
                    } catch (JSONException e14) {
                        e = e14;
                        str = "0";
                    }
                }
            }
        } catch (JSONException e15) {
            e15.printStackTrace();
            if (F()) {
                q("0", "trace:check_user_status:JSONException2:" + e15.getMessage());
            }
        }
    }

    public boolean o(String str) {
        ArrayList arrayListH;
        if (str.equals("0") || (arrayListH = C2160f10.H(this.b, D())) == null || arrayListH.size() <= 0 || Integer.parseInt((String) ((HashMap) arrayListH.get(0)).get("_id")) == 0) {
            return true;
        }
        y(new G(arrayListH));
        return false;
    }

    public String p(String str) {
        ArrayList arrayListH;
        if (str.equals("0") || (arrayListH = C2160f10.H(this.b, D())) == null || arrayListH.size() <= 0 || Integer.parseInt((String) ((HashMap) arrayListH.get(0)).get("_id")) == 0) {
            return "";
        }
        return ((String) ((HashMap) arrayListH.get(0)).get("_id")) + ":" + ((String) ((HashMap) arrayListH.get(0)).get("table_name"));
    }

    public void q(String str, String str2) {
        if (this.b.ia("online_share_type", "0").equals("2")) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("un", this.d.c);
            jSONObject.put("p_un", this.d.b);
            jSONObject.put("fcm_token", this.d.d);
            jSONObject.put("dev_id", this.d.e);
            jSONObject.put("app_id", B);
            jSONObject.put("err_no", str);
            jSONObject.put("err_desc", str2);
            VQ vq = C;
            if (vq != null) {
                vq.a("client_error", jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void r(JSONObject jSONObject) {
        try {
            if (this.b.ia("online_share_type", "0").equals("1")) {
                Y(jSONObject.get("last_action_id").toString(), jSONObject.get("fcm_token") + "", jSONObject.get("app_id").toString());
                if (jSONObject.has("last_request_id") && !jSONObject.get("last_request_id").toString().equals("0") && this.b.ja("online_server", false)) {
                    this.b.Lc("online_last_request_id", jSONObject.get("last_request_id").toString());
                }
            } else {
                Y(jSONObject.get("last_action_id").toString(), this.d.d, B);
            }
            if (Integer.parseInt(this.b.X4("select count(*) as _id from table_action")) > 0) {
                O();
            } else {
                z(false);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final AbstractC3132jE s() {
        return AbstractC3132jE.c(new InterfaceC3624pE() { // from class: P00
            @Override // defpackage.InterfaceC3624pE
            public final void subscribe(InterfaceC3296lE interfaceC3296lE) {
                this.a.G(interfaceC3296lE);
            }
        });
    }

    public void t(String str) {
        if (this.d.D(str)) {
            this.b.v0("CREATE INDEX if not exists bills_id_date_ref2 on bills(date_,online_ref2);");
            this.b.v0("CREATE INDEX if not exists bills_h_id_date_ref2 on bills_h(id,date_,online_ref2);");
            return;
        }
        this.b.v0("drop INDEX if exists bills_id_date_ref2;");
        this.b.v0("drop INDEX if exists bills_h_id_date_ref2;");
        if (str.equals("transactions") || str.equals("transactions_h")) {
            this.b.v0("CREATE INDEX if not exists trans_id_date_ref2 on transactions(date_,online_ref2);");
            this.b.v0("CREATE INDEX if not exists trans_h_id_date_ref2 on transactions_h(id,date_,online_ref2);");
        } else {
            this.b.v0("drop INDEX if exists trans_id_date_ref2 ");
            this.b.v0("drop INDEX if exists trans_h_id_date_ref2 ");
        }
    }

    public void u() {
        s().m(IN.c()).e(AbstractC1197a4.e()).j(new InterfaceC2295gf() { // from class: N00
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.H((Integer) obj);
            }
        }, new InterfaceC2295gf() { // from class: O00
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.I((Throwable) obj);
            }
        });
    }

    public void v() {
        C1839c10.z(this.b, "socket:", "disconnect_");
        if (!F) {
            this.d.L("Error:Disconnected");
        }
        this.d.O(false);
        F = false;
        VQ vq = C;
        if (vq != null) {
            vq.b();
            C.B();
            C.x();
            C = null;
        }
        D = 0;
        Q();
    }

    public boolean w(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        String str2;
        String str3;
        String str4;
        String[] strArr;
        String str5;
        JSONObject jSONObject3 = jSONObject;
        String str6 = "Error2:";
        try {
            if (!jSONObject3.get("app_id").toString().equals(B)) {
                return true;
            }
            String str7 = "pref=table:";
            String str8 = ":cond=";
            String str9 = "pref";
            if (jSONObject3.get("fcm_token").equals(this.d.d)) {
                Z(jSONObject3.getString(HTML.Attribute.ID), jSONObject3.getString("created_at"));
                if (jSONObject3.get("action_").equals("pref")) {
                    C1839c10.z(this.b, H, "pref=table:" + jSONObject3.get("table_") + ":cond=" + jSONObject3.get("cond"));
                    Z00 z00 = this.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append(jSONObject3.get("table_"));
                    sb.append("");
                    z00.Lc(sb.toString(), jSONObject3.get("cond") + "");
                }
                return true;
            }
            str = "";
            try {
                if ((!this.d.c.equals(jSONObject3.get("un")) && !this.d.c.equals(jSONObject3.get("p_un")) && !this.d.b.equals(jSONObject3.get("p_un"))) || Long.parseLong(jSONObject3.getString(HTML.Attribute.ID)) <= Long.parseLong(B())) {
                    return true;
                }
                String[] strArrSplit = jSONObject3.get("action_").toString().split(this.j);
                String[] strArrSplit2 = jSONObject3.get("table_").toString().split(this.j);
                String[] strArrSplit3 = jSONObject3.get("cond").toString().split(this.j);
                String[] strArrSplit4 = AbstractC4032uI.a(jSONObject3.get("json_").toString(), jSONObject3.get("fcm_token").toString()).split(this.j);
                String[] strArrSplit5 = AbstractC4032uI.a(jSONObject3.get("json_c").toString(), jSONObject3.get("fcm_token").toString()).split(this.j);
                String[] strArrSplit6 = jSONObject3.get("ref_no").toString().split(this.j);
                int i = 0;
                boolean z2 = false;
                while (true) {
                    String str10 = str6;
                    if (i >= strArrSplit2.length) {
                        jSONObject2 = jSONObject3;
                        str2 = str9;
                        str3 = "0";
                        break;
                    }
                    if (!strArrSplit[i].equals(str9)) {
                        str2 = str9;
                        str4 = str7;
                        M00 m00 = this.d;
                        String str11 = strArrSplit2[i];
                        String str12 = strArrSplit[i];
                        String str13 = strArrSplit3[i];
                        String str14 = strArrSplit4[i];
                        String str15 = (str14 == null || str14.equals(str11)) ? str : strArrSplit4[i];
                        String str16 = strArrSplit5[i];
                        List listE = m00.E(str11, str12, str13, str15, (str16 == null || str16.equals(strArrSplit2[i])) ? str : strArrSplit5[i], strArrSplit6[i]);
                        Z00 z01 = this.b;
                        String str17 = H;
                        StringBuilder sb2 = new StringBuilder();
                        strArr = strArrSplit5;
                        sb2.append("Query=");
                        sb2.append(listE.size());
                        sb2.append(":");
                        sb2.append(listE);
                        sb2.append(":table=");
                        sb2.append(strArrSplit2[i]);
                        sb2.append(str8);
                        sb2.append(strArrSplit3[i]);
                        sb2.append(":action=");
                        sb2.append(strArrSplit[i]);
                        sb2.append(":json_=");
                        sb2.append(strArrSplit4[i]);
                        sb2.append(":i=:");
                        sb2.append(i);
                        sb2.append(":id=");
                        jSONObject2 = jSONObject;
                        str5 = str8;
                        sb2.append(jSONObject2.get(HTML.Attribute.ID));
                        sb2.append(":json=");
                        sb2.append(strArrSplit4[i]);
                        sb2.append(":query_list_size=");
                        sb2.append(listE.size());
                        sb2.append(":fcm=");
                        sb2.append(this.d.d);
                        C1839c10.z(z01, str17, sb2.toString());
                        if (listE.size() != 0) {
                            if (this.d.B(strArrSplit2[i]) && strArrSplit[i].equals(SearchIntents.EXTRA_QUERY)) {
                                this.b.m0();
                            }
                            str10 = str10;
                            String strB0 = this.b.B0(M00.r(this.b), (String[]) listE.toArray(new String[0]));
                            if (!strB0.equals("1") && !this.d.j(strB0)) {
                                M00 m01 = this.d;
                                m01.i = true;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Error:");
                                sb3.append(strB0.length() > 20 ? strB0.substring(0, 20) : strB0);
                                sb3.append(":");
                                sb3.append(strArrSplit6[i]);
                                sb3.append(":");
                                sb3.append(i);
                                sb3.append(":");
                                sb3.append(jSONObject2.get(HTML.Attribute.ID));
                                sb3.append(":");
                                sb3.append(strArrSplit2[i]);
                                sb3.append(":");
                                sb3.append(J(strArrSplit4[i]));
                                m01.K(sb3.toString());
                                str3 = "0";
                                q(str3, strB0 + ":" + strArrSplit6[i] + ":" + i + ":" + jSONObject2.get(HTML.Attribute.ID) + ":" + listE);
                                z2 = false;
                                break;
                            }
                        } else if (!strArrSplit4[i].equals(XMPConst.ARRAY_ITEM_NAME)) {
                            this.d.K(str10 + i + ":" + strArrSplit6[i] + ":" + jSONObject2.getString(HTML.Attribute.ID));
                            q("2", str10 + i + ":" + strArrSplit6[i] + ":" + jSONObject2.getString(HTML.Attribute.ID));
                            this.d.i = true;
                            return false;
                        }
                    } else {
                        Z00 z02 = this.b;
                        str2 = str9;
                        String str18 = H;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str7);
                        str4 = str7;
                        sb4.append(strArrSplit2[i]);
                        sb4.append(str8);
                        sb4.append(strArrSplit3[i]);
                        C1839c10.z(z02, str18, sb4.toString());
                        this.b.Lc(strArrSplit2[i], strArrSplit3[i]);
                        if (strArrSplit2[i].equals("online_push_init_data") && strArrSplit3[i].equals("1")) {
                            y(new r());
                            R();
                        } else if (strArrSplit2[i].equals("online_relogin")) {
                            strArrSplit3[i].equals("1");
                        }
                        strArr = strArrSplit5;
                        str5 = str8;
                        jSONObject2 = jSONObject;
                    }
                    i++;
                    jSONObject3 = jSONObject2;
                    str6 = str10;
                    str9 = str2;
                    str7 = str4;
                    strArrSplit5 = strArr;
                    str8 = str5;
                    z2 = true;
                }
                if (z2 && !this.d.i) {
                    Z(jSONObject2.getString(HTML.Attribute.ID), jSONObject2.getString("created_at"));
                    if (strArrSplit2.length == 1 && strArrSplit[0].equals(str2) && strArrSplit2[0].equals("online_last_update") && jSONObject2.get("dev_id").equals(this.d.e) && this.b.ia("reset_online_last_update", str3).equals(str3)) {
                        this.b.Lc("online_last_update", strArrSplit3[0]);
                        this.b.Lc("reset_online_last_update", "1");
                    }
                }
                return z2;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                this.d.J(e, 4);
                q("4", e.getMessage() + str);
                return false;
            }
        } catch (Exception e2) {
            e = e2;
            str = "";
        }
    }

    public void y(Callable callable) {
        try {
            Context context = this.a;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new I(callable));
            } else {
                try {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0840a(callable));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void z(boolean z2) {
        int i;
        if (this.d.d()) {
            return;
        }
        try {
            if (this.b.ia("online_share_type", "0").equals("2")) {
                this.d.k(z2);
                return;
            }
            this.d.i = false;
            C1839c10.z(this.b, H, "fetch_data:fetch_data_flag=" + M00.v + ":listen_data_flag=" + this.d.j + ":download_docs_flag=" + M00.w + ":last_request_id=" + B() + ":un=" + this.d.c + ":p_un=" + this.d.b);
            if (z2) {
                S();
            }
            M00 m00 = this.d;
            if (!M00.v && !M00.w) {
                if (this.b.ia("online_push_init_data", "0").equals("0") && this.d.q == null) {
                    C1839c10.z(this.b, H, "fetch_data:Exit:first fetch should be from status activity");
                    return;
                }
                try {
                    i = Integer.parseInt(this.b.X4("select count(*) as _id from table_action where init=1"));
                } catch (Exception e) {
                    q("2", e.getMessage() + ":NumberFormatException");
                    M00.v = false;
                    e.printStackTrace();
                    i = 0;
                }
                if (i > 0) {
                    C1839c10.z(this.b, H, "fetch_data:Exit:first push all init data");
                    return;
                }
                M00.v = true;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("p_un", this.d.b);
                    jSONObject.put("un", this.d.c);
                    jSONObject.put("fcm_token", this.d.d);
                    jSONObject.put("dev_id", this.d.e);
                    jSONObject.put("app_id", B);
                    jSONObject.put("last_request_id", B());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.d.O(true);
                if (this.d.q != null) {
                    y(new B());
                }
                VQ vq = C;
                if (vq != null) {
                    vq.a("fetch_data", jSONObject, this.s);
                }
                M00.v = false;
                return;
            }
            m00.I("1:already running..." + M00.v + ":" + M00.w);
            if (M00.w) {
                return;
            }
            M00.v = false;
        } catch (Exception e3) {
            M00.v = false;
            e3.printStackTrace();
            this.d.J(e3, 2);
            q("2", e3.getMessage() + "");
        }
    }
}
