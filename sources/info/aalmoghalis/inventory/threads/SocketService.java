package info.aalmoghalis.inventory.threads;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0892Rr;
import defpackage.AbstractC0963Uk;
import defpackage.VQ;
import defpackage.Z00;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SocketService extends Service {
    public static VQ t = null;
    public static int u = 0;
    public static long v = 0;
    public static int w = 5;
    public Looper a;
    public n b;
    public Context c;
    public SQLiteDatabase d;
    public Z00 e;
    public String f = "";
    public AbstractC0963Uk.a g = new i();
    public AbstractC0963Uk.a h = new j();
    public AbstractC0963Uk.a i = new k();
    public AbstractC0963Uk.a j = new l();
    public AbstractC0963Uk.a k = new m();
    public AbstractC0963Uk.a l = new a();
    public AbstractC0963Uk.a n = new b();
    public AbstractC0963Uk.a p = new c();
    public AbstractC0963Uk.a q = new d();

    public class a implements AbstractC0963Uk.a {
        public a() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(objArr[0].toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                String string = jSONObject.getString("un");
                String string2 = jSONObject.getString("br_id");
                String string3 = jSONObject.getString("cash_id");
                jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE);
                String token = FirebaseInstanceId.getInstance().getToken();
                SocketService.this.e.v0("update branches set param1='" + string + "',param2='" + token + "' where id='" + string2 + "'");
                SocketService.this.e.Mc("online_type1", true);
                SocketService.this.e.v0("update customers set param1='" + string + "',param2='" + token + "' where id='" + string3 + "'");
                SocketService.this.e.Mc("online_type2", true);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public class b implements AbstractC0963Uk.a {
        public b() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(objArr[0].toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                String string = jSONObject.getString("un");
                String string2 = jSONObject.getString("p_un");
                String string3 = jSONObject.getString("ref_no");
                int i = jSONObject.getInt("acc_type");
                int i2 = jSONObject.getInt("tr_type");
                jSONObject.getString("c_br_id");
                jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE);
                SocketService.this.e.v0("update requests_out set status=-1 where ref_no='" + string3 + "' and _un='" + string + "' and _p_un='" + string2 + "' and acc_type='" + i + "' and tr_type='" + i2 + "'");
                SocketService.t.a("confirm_client_add_req", jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    public class c implements AbstractC0963Uk.a {
        public c() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(objArr[0].toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                String string = jSONObject.getString("un");
                String string2 = jSONObject.getString("p_un");
                String string3 = jSONObject.getString("ref_no");
                int i = jSONObject.getInt("acc_type");
                int i2 = jSONObject.getInt("tr_type");
                jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE);
                SocketService.this.e.v0("update requests_out set status=1 where status=-1 and ref_no='" + string3 + "' and _un='" + string + "' and _p_un='" + string2 + "' and acc_type='" + i + "' and tr_type='" + i2 + "'");
            } catch (JSONException unused) {
            }
        }
    }

    public class d implements AbstractC0963Uk.a {
        public d() {
        }

        /* JADX WARN: Code duplicated, block: B:43:0x014d A[Catch: JSONException -> 0x0188, TRY_LEAVE, TryCatch #5 {JSONException -> 0x0188, blocks: (B:3:0x0012, B:4:0x0026, B:6:0x002c, B:41:0x00ae, B:43:0x014d, B:48:0x0177, B:53:0x018c, B:47:0x0174, B:40:0x00a1, B:54:0x0195, B:44:0x0168), top: B:68:0x0012, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x018a  */
        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) throws Throwable {
            String string;
            String string2;
            String string3;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            String str = "json_";
            String str2 = "";
            Log.d("socket_data=", HTML.Attribute.START);
            try {
                JSONArray jSONArray = new JSONArray(objArr[0].toString()).optJSONObject(0).getJSONArray("json_");
                int i11 = 0;
                while (i11 < jSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                    try {
                        i = jSONObjectOptJSONObject.getInt(HTML.Attribute.ID);
                        try {
                            string = jSONObjectOptJSONObject.getString("date_");
                            try {
                                string2 = jSONObjectOptJSONObject.getString(str);
                                try {
                                    string3 = jSONObjectOptJSONObject.getString("ref_no");
                                    try {
                                        i2 = jSONObjectOptJSONObject.getInt("f_user_id");
                                        try {
                                            i3 = jSONObjectOptJSONObject.getInt("t_user_id");
                                            try {
                                                i4 = jSONObjectOptJSONObject.getInt("f_br_id");
                                                try {
                                                    i5 = jSONObjectOptJSONObject.getInt("t_br_id");
                                                    try {
                                                        i6 = jSONObjectOptJSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                                                        try {
                                                            i10 = jSONObjectOptJSONObject.getInt("tr_type");
                                                            i7 = i3;
                                                            i8 = i4;
                                                            i9 = i6;
                                                        } catch (JSONException e) {
                                                            e = e;
                                                            e.printStackTrace();
                                                            i7 = i3;
                                                            i8 = i4;
                                                            i9 = i6;
                                                            i10 = 0;
                                                        }
                                                    } catch (JSONException e2) {
                                                        e = e2;
                                                        i6 = 0;
                                                        e.printStackTrace();
                                                        i7 = i3;
                                                        i8 = i4;
                                                        i9 = i6;
                                                        i10 = 0;
                                                        int i12 = i11;
                                                        int i13 = i5;
                                                        String str3 = str;
                                                        SocketService.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i13 + "," + i9 + "," + i10 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                        StringBuilder sb = new StringBuilder();
                                                        Z00 z00 = SocketService.this.e;
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append(i);
                                                        str2 = str2;
                                                        sb2.append(str2);
                                                        sb.append(z00.m8(sb2.toString()));
                                                        sb.append(str2);
                                                        Log.d("requests_cnt=", sb.toString());
                                                        if (SocketService.this.e.m8(i + str2) > 0) {
                                                            jSONObjectOptJSONObject.remove("json");
                                                            String strIa = SocketService.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                            String token = FirebaseInstanceId.getInstance().getToken();
                                                            try {
                                                                jSONObjectOptJSONObject.put("un", strIa);
                                                                jSONObjectOptJSONObject.put("fcm_token", token);
                                                            } catch (JSONException e3) {
                                                                e3.printStackTrace();
                                                            }
                                                            SocketService.t.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                                        }
                                                        i11 = i12 + 1;
                                                        jSONArray = jSONArray;
                                                        str = str3;
                                                    }
                                                } catch (JSONException e4) {
                                                    e = e4;
                                                    i5 = 0;
                                                    i6 = 0;
                                                    e.printStackTrace();
                                                    i7 = i3;
                                                    i8 = i4;
                                                    i9 = i6;
                                                    i10 = 0;
                                                    int i14 = i11;
                                                    int i15 = i5;
                                                    String str4 = str;
                                                    SocketService.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i15 + "," + i9 + "," + i10 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                    StringBuilder sb3 = new StringBuilder();
                                                    Z00 z01 = SocketService.this.e;
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append(i);
                                                    str2 = str2;
                                                    sb4.append(str2);
                                                    sb3.append(z01.m8(sb4.toString()));
                                                    sb3.append(str2);
                                                    Log.d("requests_cnt=", sb3.toString());
                                                    if (SocketService.this.e.m8(i + str2) > 0) {
                                                        jSONObjectOptJSONObject.remove("json");
                                                        String strIa2 = SocketService.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                        String token2 = FirebaseInstanceId.getInstance().getToken();
                                                        jSONObjectOptJSONObject.put("un", strIa2);
                                                        jSONObjectOptJSONObject.put("fcm_token", token2);
                                                        SocketService.t.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                                    }
                                                    i11 = i14 + 1;
                                                    jSONArray = jSONArray;
                                                    str = str4;
                                                }
                                            } catch (JSONException e5) {
                                                e = e5;
                                                i4 = 0;
                                                i5 = 0;
                                                i6 = 0;
                                                e.printStackTrace();
                                                i7 = i3;
                                                i8 = i4;
                                                i9 = i6;
                                                i10 = 0;
                                                int i16 = i11;
                                                int i17 = i5;
                                                String str5 = str;
                                                SocketService.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i17 + "," + i9 + "," + i10 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                StringBuilder sb5 = new StringBuilder();
                                                Z00 z02 = SocketService.this.e;
                                                StringBuilder sb6 = new StringBuilder();
                                                sb6.append(i);
                                                str2 = str2;
                                                sb6.append(str2);
                                                sb5.append(z02.m8(sb6.toString()));
                                                sb5.append(str2);
                                                Log.d("requests_cnt=", sb5.toString());
                                                if (SocketService.this.e.m8(i + str2) > 0) {
                                                    jSONObjectOptJSONObject.remove("json");
                                                    String strIa3 = SocketService.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                    String token3 = FirebaseInstanceId.getInstance().getToken();
                                                    jSONObjectOptJSONObject.put("un", strIa3);
                                                    jSONObjectOptJSONObject.put("fcm_token", token3);
                                                    SocketService.t.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                                }
                                                i11 = i16 + 1;
                                                jSONArray = jSONArray;
                                                str = str5;
                                            }
                                        } catch (JSONException e6) {
                                            e = e6;
                                            i3 = 0;
                                            i4 = 0;
                                            i5 = 0;
                                            i6 = 0;
                                            e.printStackTrace();
                                            i7 = i3;
                                            i8 = i4;
                                            i9 = i6;
                                            i10 = 0;
                                            int i18 = i11;
                                            int i19 = i5;
                                            String str6 = str;
                                            SocketService.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i19 + "," + i9 + "," + i10 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                            StringBuilder sb7 = new StringBuilder();
                                            Z00 z03 = SocketService.this.e;
                                            StringBuilder sb8 = new StringBuilder();
                                            sb8.append(i);
                                            str2 = str2;
                                            sb8.append(str2);
                                            sb7.append(z03.m8(sb8.toString()));
                                            sb7.append(str2);
                                            Log.d("requests_cnt=", sb7.toString());
                                            if (SocketService.this.e.m8(i + str2) > 0) {
                                                jSONObjectOptJSONObject.remove("json");
                                                String strIa4 = SocketService.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                String token4 = FirebaseInstanceId.getInstance().getToken();
                                                jSONObjectOptJSONObject.put("un", strIa4);
                                                jSONObjectOptJSONObject.put("fcm_token", token4);
                                                SocketService.t.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                            }
                                            i11 = i18 + 1;
                                            jSONArray = jSONArray;
                                            str = str6;
                                        }
                                    } catch (JSONException e7) {
                                        e = e7;
                                        i2 = 0;
                                        i3 = 0;
                                        i4 = 0;
                                        i5 = 0;
                                        i6 = 0;
                                        e.printStackTrace();
                                        i7 = i3;
                                        i8 = i4;
                                        i9 = i6;
                                        i10 = 0;
                                        int i110 = i11;
                                        int i111 = i5;
                                        String str7 = str;
                                        SocketService.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i111 + "," + i9 + "," + i10 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                        StringBuilder sb9 = new StringBuilder();
                                        Z00 z04 = SocketService.this.e;
                                        StringBuilder sb10 = new StringBuilder();
                                        sb10.append(i);
                                        str2 = str2;
                                        sb10.append(str2);
                                        sb9.append(z04.m8(sb10.toString()));
                                        sb9.append(str2);
                                        Log.d("requests_cnt=", sb9.toString());
                                        if (SocketService.this.e.m8(i + str2) > 0) {
                                            jSONObjectOptJSONObject.remove("json");
                                            String strIa5 = SocketService.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                            String token5 = FirebaseInstanceId.getInstance().getToken();
                                            jSONObjectOptJSONObject.put("un", strIa5);
                                            jSONObjectOptJSONObject.put("fcm_token", token5);
                                            SocketService.t.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                        }
                                        i11 = i110 + 1;
                                        jSONArray = jSONArray;
                                        str = str7;
                                    }
                                } catch (JSONException e8) {
                                    e = e8;
                                    string3 = str2;
                                }
                            } catch (JSONException e9) {
                                e = e9;
                                string2 = str2;
                                string3 = string2;
                                i2 = 0;
                                i3 = 0;
                                i4 = 0;
                                i5 = 0;
                                i6 = 0;
                                e.printStackTrace();
                                i7 = i3;
                                i8 = i4;
                                i9 = i6;
                                i10 = 0;
                                int i112 = i11;
                                int i113 = i5;
                                String str8 = str;
                                SocketService.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i113 + "," + i9 + "," + i10 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                StringBuilder sb11 = new StringBuilder();
                                Z00 z05 = SocketService.this.e;
                                StringBuilder sb12 = new StringBuilder();
                                sb12.append(i);
                                str2 = str2;
                                sb12.append(str2);
                                sb11.append(z05.m8(sb12.toString()));
                                sb11.append(str2);
                                Log.d("requests_cnt=", sb11.toString());
                                if (SocketService.this.e.m8(i + str2) > 0) {
                                    jSONObjectOptJSONObject.remove("json");
                                    String strIa6 = SocketService.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                    String token6 = FirebaseInstanceId.getInstance().getToken();
                                    jSONObjectOptJSONObject.put("un", strIa6);
                                    jSONObjectOptJSONObject.put("fcm_token", token6);
                                    SocketService.t.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                }
                                i11 = i112 + 1;
                                jSONArray = jSONArray;
                                str = str8;
                            }
                        } catch (JSONException e10) {
                            e = e10;
                            string = str2;
                            string2 = string;
                        }
                    } catch (JSONException e11) {
                        e = e11;
                        string = str2;
                        string2 = string;
                        string3 = string2;
                        i = 0;
                    }
                    int i114 = i11;
                    int i115 = i5;
                    String str9 = str;
                    SocketService.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i115 + "," + i9 + "," + i10 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                    StringBuilder sb13 = new StringBuilder();
                    Z00 z06 = SocketService.this.e;
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(i);
                    str2 = str2;
                    sb14.append(str2);
                    sb13.append(z06.m8(sb14.toString()));
                    sb13.append(str2);
                    Log.d("requests_cnt=", sb13.toString());
                    if (SocketService.this.e.m8(i + str2) > 0) {
                        jSONObjectOptJSONObject.remove("json");
                        String strIa7 = SocketService.this.e.ia("PREF_ACCOUNT_NAME", "0");
                        String token7 = FirebaseInstanceId.getInstance().getToken();
                        jSONObjectOptJSONObject.put("un", strIa7);
                        jSONObjectOptJSONObject.put("fcm_token", token7);
                        SocketService.t.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                    }
                    i11 = i114 + 1;
                    jSONArray = jSONArray;
                    str = str9;
                }
                jSONArray.length();
                SocketService.this.h();
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
    }

    public class e implements AbstractC0963Uk.a {
        public e() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Log.d("socket:connected:", SocketService.t.E());
            SocketService.this.a();
            SocketService.this.e.Lc("nodejs_date", SocketService.this.e.r3() + "");
            SocketService.this.e.Lc("nodejs_hr", SocketService.this.e.o3() + "");
            int unused = SocketService.u = 1;
            SocketService.this.e.Lc("online_date_done", new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
        }
    }

    public class f implements AbstractC0963Uk.a {
        public f() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Log.d("socket:disconnected:", " Log.d(\"socket:disconnected:\",mSocket.id());");
            int unused = SocketService.u = 0;
            SocketService.d();
        }
    }

    public class g implements AbstractC0963Uk.a {
        public g() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Log.d("socket:error:", "EVENT_CONNECT_ERROR:" + objArr);
            int unused = SocketService.u = 0;
            SocketService.d();
        }
    }

    public class h implements AbstractC0963Uk.a {
        public h() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Log.d("socket:", "reconnect");
            int unused = SocketService.u = 0;
        }
    }

    public class i implements AbstractC0963Uk.a {
        public i() {
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
            Log.d("socket:retry=", string + "");
            SocketService.w = Integer.parseInt(string);
            SocketService.this.e.Lc("server_retry", SocketService.w + "");
        }
    }

    public class j implements AbstractC0963Uk.a {
        public j() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) throws Throwable {
            Log.d("socket:", "share_data");
            SocketService.this.n();
        }
    }

    public class k implements AbstractC0963Uk.a {
        public k() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(objArr[0].toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                jSONObject.getString("un");
                int i = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                jSONObject.getString("br_id");
                jSONObject.getString("cash_id");
                jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE);
                if (i == -1) {
                    SocketService.this.e.Mc("online_client", false);
                    SocketService.this.e.Mc("online_server", false);
                    SocketService.this.e.v0("update sys_conf set value_=0 where id=8");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public class l implements AbstractC0963Uk.a {
        public l() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(objArr[0].toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                jSONObject.getString("p_un");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            SocketService.this.e.Mc("online_client", true);
            SocketService.this.e.v0("update sys_conf set value_=1 where id=8");
        }
    }

    public class m implements AbstractC0963Uk.a {
        public m() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            JSONObject jSONObject;
            String string;
            String string2 = "";
            try {
                jSONObject = new JSONObject(objArr[0].toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                string = jSONObject.getString("un");
                try {
                    string2 = jSONObject.getString("send_type");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
                string = "";
            }
            Log.d("confirm_server=", string);
            SocketService.this.e.Mc("online_server", true);
            SocketService.this.e.v0("update sys_conf set value_=2 where id=8");
            if (string2.equals("1")) {
                SocketService.this.e.Mc("send_type1", true);
            } else {
                SocketService.this.e.Mc("send_type1", false);
            }
        }
    }

    public final class n extends Handler {
        public n(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Z00.Z = true;
            } catch (Exception e) {
                Log.d("service_err", e.getMessage() + "");
                Thread.currentThread().interrupt();
            }
            SocketService.this.stopSelf(message.arg1);
        }
    }

    public static void d() {
        Log.d("socket:", "disconnect_");
        VQ vq = t;
        if (vq != null) {
            vq.b();
            t.B();
            t = null;
        }
        u = 0;
    }

    public void a() {
        String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || strIa == "0") {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("un", strIa);
            jSONObject.put("fcm_token", token);
            jSONObject.put("android_ver", Z00.m0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        t.a("auth", jSONObject);
    }

    public void e() {
        if (this.e.ja("online_client", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            new ArrayList();
            ArrayList arrayListX2 = this.e.x2("1", strIa);
            for (int i2 = 0; i2 < arrayListX2.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("p_un", strIa);
                    jSONObject.put("un", ((HashMap) arrayListX2.get(i2)).get("email"));
                    jSONObject.put("fcm_token", token);
                    jSONObject.put("acc_type", -100);
                    jSONObject.put("br_id", ((HashMap) arrayListX2.get(i2)).get(HTML.Attribute.ID));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                t.a("fetch_server_req", jSONObject);
            }
            try {
                this.e.Aa("-100", "0");
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void f() {
        String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
        String token = FirebaseInstanceId.getInstance().getToken();
        new ArrayList();
        ArrayList arrayListU2 = this.e.u2("1", strIa);
        for (int i2 = 0; i2 < arrayListU2.size(); i2++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p_un", strIa);
                jSONObject.put("un", ((HashMap) arrayListU2.get(i2)).get("email"));
                jSONObject.put("fcm_token", token);
                jSONObject.put("acc_type", 1);
                jSONObject.put("br_id", ((HashMap) arrayListU2.get(i2)).get(HTML.Attribute.ID));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            t.a("fetch_client_req", jSONObject);
            t.a("fetch_server_req", jSONObject);
        }
        ArrayList arrayListU3 = this.e.u2("2", strIa);
        for (int i3 = 0; i3 < arrayListU3.size(); i3++) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("p_un", strIa);
                jSONObject2.put("un", ((HashMap) arrayListU3.get(i3)).get("email"));
                jSONObject2.put("fcm_token", token);
                jSONObject2.put("acc_type", 2);
                jSONObject2.put("br_id", ((HashMap) arrayListU3.get(i3)).get(HTML.Attribute.ID));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            t.a("fetch_client_req", jSONObject2);
        }
    }

    public void g() throws Throwable {
        VQ vq = t;
        if (vq == null) {
            try {
                Log.d("socket:", "init_connect");
                AbstractC0892Rr.a aVar = new AbstractC0892Rr.a();
                aVar.B = true;
                aVar.s = false;
                aVar.m = new String[]{"websocket", "polling"};
                aVar.A = 60000L;
                t = AbstractC0892Rr.a("https://bkp2.dyndns.org:7000");
                if (!this.e.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
                    t.y();
                }
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        } else if (vq.z()) {
            n();
        } else {
            t.y();
        }
        t.e("connect", new e());
        t.e("disconnect", new f());
        t.e("connect_error", new g());
        t.e("reconnect", new h());
        t.e("confirm_client2", this.j);
        t.e("confirm_server2", this.k);
        t.e("confirm_server_retry", this.g);
        t.e("share_data", this.h);
        t.e("stop_client", this.i);
        t.e("update_br_cash", this.l);
        t.e("confirm_fetch_client_req", this.q);
        t.e("confirm_client_add_req", this.n);
        t.e("confirm_client_update_req", this.p);
    }

    public void h() throws Throwable {
        try {
            this.e.va("1", "0");
            this.e.va("2", "0");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            this.e.va("3", "0");
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            this.e.va("4", "0");
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        try {
            this.e.va("7", "0");
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        try {
            this.e.xa("5", "0");
            this.e.xa("6", "0");
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        try {
            this.e.ya("-200", "0");
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        try {
            this.e.za("-201", "0");
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            this.e.wa("-202", "0");
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void i() throws Throwable {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        ArrayList arrayList;
        String str33;
        String str34;
        String str35;
        ArrayList arrayList2;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41 = "7";
        String str42 = "4";
        String str43 = "add_server_req";
        String str44 = "req_m=";
        String str45 = "3";
        String str46 = "";
        String str47 = "2";
        String str48 = "1";
        try {
            m();
            l();
            k();
            j();
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            this.e.ua("1", strIa);
            new ArrayList();
            ArrayList arrayListI8 = this.e.i8("1", strIa, "1");
            arrayListI8.size();
            int i2 = 0;
            while (true) {
                str = str41;
                str2 = str42;
                str3 = str43;
                str4 = "json_";
                str5 = str44;
                str6 = str45;
                str7 = "ref";
                str8 = str46;
                str9 = "ref_no";
                str10 = str48;
                str11 = str47;
                str12 = "c_br_id";
                str13 = strIa;
                str14 = "p_un";
                str15 = "add_client_req";
                str16 = "action_type";
                str17 = "un";
                str18 = "fcm_token";
                str19 = "acc_type";
                str20 = token;
                str21 = "tr_type";
                if (i2 >= arrayListI8.size()) {
                    break;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("un", ((HashMap) arrayListI8.get(i2)).get("_un"));
                    jSONObject.put("p_un", ((HashMap) arrayListI8.get(i2)).get("_p_un"));
                    jSONObject.put("c_br_id", ((HashMap) arrayListI8.get(i2)).get("f_br_id"));
                    jSONObject.put("tr_type", ((HashMap) arrayListI8.get(i2)).get("tr_type"));
                    jSONObject.put("acc_type", ((HashMap) arrayListI8.get(i2)).get("acc_type"));
                    jSONObject.put("ref_no", ((HashMap) arrayListI8.get(i2)).get("ref"));
                    jSONObject.put("json", ((HashMap) arrayListI8.get(i2)).get("json_"));
                    str40 = str20;
                    try {
                        jSONObject.put(str18, str40);
                        jSONObject.put(str16, 1);
                        t.a(str15, jSONObject);
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str40 = str20;
                }
                i2++;
                token = str40;
                str41 = str;
                str42 = str2;
                str43 = str3;
                str44 = str5;
                str45 = str6;
                str46 = str8;
                str48 = str10;
                str47 = str11;
                strIa = str13;
            }
            String str49 = "json";
            this.e.ua(str11, str13);
            ArrayList arrayListI9 = this.e.i8(str11, str13, str10);
            StringBuilder sb = new StringBuilder();
            sb.append(arrayListI9.size());
            String str50 = str8;
            sb.append(str50);
            Log.d("req_pur_out=", sb.toString());
            arrayListI9.size();
            int i3 = 0;
            while (i3 < arrayListI9.size()) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    str37 = str50;
                    try {
                        jSONObject2.put("un", ((HashMap) arrayListI9.get(i3)).get("_un"));
                        jSONObject2.put("p_un", ((HashMap) arrayListI9.get(i3)).get("_p_un"));
                        jSONObject2.put("c_br_id", ((HashMap) arrayListI9.get(i3)).get("f_br_id"));
                        jSONObject2.put("tr_type", ((HashMap) arrayListI9.get(i3)).get("tr_type"));
                        jSONObject2.put("acc_type", ((HashMap) arrayListI9.get(i3)).get("acc_type"));
                        jSONObject2.put(str9, ((HashMap) arrayListI9.get(i3)).get("ref"));
                        Object obj = ((HashMap) arrayListI9.get(i3)).get(str4);
                        str36 = str4;
                        String str51 = str49;
                        try {
                            jSONObject2.put(str51, obj);
                            str49 = str51;
                            String str52 = str18;
                            String str53 = str20;
                            try {
                                jSONObject2.put(str52, str53);
                                str18 = str52;
                                str20 = str53;
                                String str54 = str16;
                                try {
                                    jSONObject2.put(str54, 1);
                                    str16 = str54;
                                    try {
                                        VQ vq = t;
                                        str38 = str9;
                                        try {
                                            Object[] objArr = new Object[1];
                                            try {
                                                objArr[0] = jSONObject2;
                                                str39 = str15;
                                                try {
                                                    vq.a(str39, objArr);
                                                } catch (JSONException e4) {
                                                    e = e4;
                                                    e.printStackTrace();
                                                }
                                            } catch (JSONException e5) {
                                                e = e5;
                                                str39 = str15;
                                                e.printStackTrace();
                                                i3++;
                                                str15 = str39;
                                                str4 = str36;
                                                str50 = str37;
                                                str9 = str38;
                                            }
                                        } catch (JSONException e6) {
                                            e = e6;
                                        }
                                    } catch (JSONException e7) {
                                        e = e7;
                                        str38 = str9;
                                        str39 = str15;
                                        e.printStackTrace();
                                        i3++;
                                        str15 = str39;
                                        str4 = str36;
                                        str50 = str37;
                                        str9 = str38;
                                    }
                                } catch (JSONException e8) {
                                    e = e8;
                                    str16 = str54;
                                }
                            } catch (JSONException e9) {
                                e = e9;
                                str18 = str52;
                                str20 = str53;
                            }
                        } catch (JSONException e10) {
                            e = e10;
                            str49 = str51;
                        }
                    } catch (JSONException e11) {
                        e = e11;
                        str36 = str4;
                    }
                } catch (JSONException e12) {
                    e = e12;
                    str36 = str4;
                    str37 = str50;
                }
                i3++;
                str15 = str39;
                str4 = str36;
                str50 = str37;
                str9 = str38;
            }
            String str55 = str4;
            String str56 = str50;
            String str57 = str9;
            String str58 = str15;
            arrayListI9.size();
            this.e.sa("-3", str13);
            new ArrayList();
            String str59 = str10;
            ArrayList arrayListI10 = this.e.i8("5", str13, str59);
            arrayListI10.size();
            int i4 = 0;
            while (i4 < arrayListI10.size()) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    str34 = str59;
                    try {
                        jSONObject3.put("un", ((HashMap) arrayListI10.get(i4)).get("_un"));
                        jSONObject3.put("p_un", ((HashMap) arrayListI10.get(i4)).get("_p_un"));
                        jSONObject3.put("c_br_id", ((HashMap) arrayListI10.get(i4)).get("f_br_id"));
                        jSONObject3.put("tr_type", ((HashMap) arrayListI10.get(i4)).get("tr_type"));
                        jSONObject3.put("acc_type", ((HashMap) arrayListI10.get(i4)).get("acc_type"));
                        Object obj2 = ((HashMap) arrayListI10.get(i4)).get(str7);
                        str7 = str7;
                        String str60 = str57;
                        try {
                            jSONObject3.put(str60, obj2);
                            HashMap map = (HashMap) arrayListI10.get(i4);
                            arrayList2 = arrayListI10;
                            String str61 = str55;
                            try {
                                Object obj3 = map.get(str61);
                                str55 = str61;
                                String str62 = str49;
                                try {
                                    jSONObject3.put(str62, obj3);
                                    str49 = str62;
                                    String str63 = str18;
                                    String str64 = str20;
                                    try {
                                        jSONObject3.put(str63, str64);
                                        str18 = str63;
                                        str20 = str64;
                                        String str65 = str16;
                                        try {
                                            jSONObject3.put(str65, 1);
                                            str16 = str65;
                                            try {
                                                str35 = str60;
                                                try {
                                                    t.a(str58, jSONObject3);
                                                } catch (JSONException e13) {
                                                    e = e13;
                                                    e.printStackTrace();
                                                }
                                            } catch (JSONException e14) {
                                                e = e14;
                                                str35 = str60;
                                                e.printStackTrace();
                                                i4++;
                                                str7 = str7;
                                                str59 = str34;
                                                arrayListI10 = arrayList2;
                                                str57 = str35;
                                            }
                                        } catch (JSONException e15) {
                                            e = e15;
                                            str16 = str65;
                                        }
                                    } catch (JSONException e16) {
                                        e = e16;
                                        str18 = str63;
                                        str35 = str60;
                                        str20 = str64;
                                    }
                                } catch (JSONException e17) {
                                    e = e17;
                                    str49 = str62;
                                }
                            } catch (JSONException e18) {
                                e = e18;
                                str55 = str61;
                            }
                        } catch (JSONException e19) {
                            e = e19;
                            arrayList2 = arrayListI10;
                        }
                    } catch (JSONException e20) {
                        e = e20;
                        str35 = str57;
                        arrayList2 = arrayListI10;
                        e.printStackTrace();
                        i4++;
                        str7 = str7;
                        str59 = str34;
                        arrayListI10 = arrayList2;
                        str57 = str35;
                    }
                } catch (JSONException e21) {
                    e = e21;
                    str34 = str59;
                }
                i4++;
                str7 = str7;
                str59 = str34;
                arrayListI10 = arrayList2;
                str57 = str35;
            }
            String str66 = str7;
            String str67 = str57;
            String str68 = str59;
            ArrayList arrayListI11 = this.e.i8("6", str13, str68);
            arrayListI11.size();
            int i5 = 0;
            while (i5 < arrayListI11.size()) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    str33 = str68;
                    try {
                        jSONObject4.put("un", ((HashMap) arrayListI11.get(i5)).get("_un"));
                        jSONObject4.put("p_un", ((HashMap) arrayListI11.get(i5)).get("_p_un"));
                        jSONObject4.put("c_br_id", ((HashMap) arrayListI11.get(i5)).get("f_br_id"));
                        jSONObject4.put("tr_type", ((HashMap) arrayListI11.get(i5)).get("tr_type"));
                        jSONObject4.put(str19, ((HashMap) arrayListI11.get(i5)).get(str19));
                        str32 = str19;
                        String str69 = str66;
                        try {
                            Object obj4 = ((HashMap) arrayListI11.get(i5)).get(str69);
                            str66 = str69;
                            String str70 = str67;
                            try {
                                jSONObject4.put(str70, obj4);
                                HashMap map2 = (HashMap) arrayListI11.get(i5);
                                arrayList = arrayListI11;
                                String str71 = str55;
                                try {
                                    Object obj5 = map2.get(str71);
                                    str55 = str71;
                                    String str72 = str49;
                                    try {
                                        jSONObject4.put(str72, obj5);
                                        str49 = str72;
                                        String str73 = str18;
                                        String str74 = str20;
                                        try {
                                            jSONObject4.put(str73, str74);
                                            str18 = str73;
                                            str20 = str74;
                                            String str75 = str16;
                                            try {
                                                jSONObject4.put(str75, 1);
                                                str16 = str75;
                                                try {
                                                    str67 = str70;
                                                    try {
                                                        t.a(str58, jSONObject4);
                                                    } catch (JSONException e22) {
                                                        e = e22;
                                                        e.printStackTrace();
                                                    }
                                                } catch (JSONException e23) {
                                                    e = e23;
                                                    str67 = str70;
                                                }
                                            } catch (JSONException e24) {
                                                e = e24;
                                                str67 = str70;
                                                str16 = str75;
                                            }
                                        } catch (JSONException e25) {
                                            e = e25;
                                            str67 = str70;
                                            str18 = str73;
                                            str20 = str74;
                                        }
                                    } catch (JSONException e26) {
                                        e = e26;
                                        str67 = str70;
                                        str49 = str72;
                                    }
                                } catch (JSONException e27) {
                                    e = e27;
                                    str67 = str70;
                                    str55 = str71;
                                }
                            } catch (JSONException e28) {
                                e = e28;
                                str67 = str70;
                                arrayList = arrayListI11;
                                e.printStackTrace();
                                i5++;
                                str19 = str32;
                                str68 = str33;
                                arrayListI11 = arrayList;
                            }
                        } catch (JSONException e29) {
                            e = e29;
                            str66 = str69;
                        }
                    } catch (JSONException e30) {
                        e = e30;
                        str32 = str19;
                    }
                } catch (JSONException e31) {
                    e = e31;
                    str32 = str19;
                    arrayList = arrayListI11;
                    str33 = str68;
                }
                i5++;
                str19 = str32;
                str68 = str33;
                arrayListI11 = arrayList;
            }
            String str76 = str19;
            String str77 = str68;
            this.e.Ea(str6, str13);
            new ArrayList();
            ArrayList arrayListI12 = this.e.i8(str6, str13, str11);
            arrayListI12.size();
            String str78 = str5;
            Log.d(str78, arrayListI12.size() + str56);
            String str79 = str58;
            int i6 = 0;
            while (i6 < arrayListI12.size()) {
                JSONObject jSONObject5 = new JSONObject();
                try {
                    str29 = str78;
                    try {
                        jSONObject5.put("un", ((HashMap) arrayListI12.get(i6)).get("_un"));
                        jSONObject5.put("p_un", ((HashMap) arrayListI12.get(i6)).get("_p_un"));
                        jSONObject5.put(str12, ((HashMap) arrayListI12.get(i6)).get("f_br_id"));
                        jSONObject5.put(str21, ((HashMap) arrayListI12.get(i6)).get(str21));
                        str28 = str21;
                        String str80 = str76;
                        try {
                            jSONObject5.put(str80, ((HashMap) arrayListI12.get(i6)).get(str80));
                            str76 = str80;
                            String str81 = str66;
                            try {
                                Object obj6 = ((HashMap) arrayListI12.get(i6)).get(str81);
                                str66 = str81;
                                String str82 = str67;
                                try {
                                    jSONObject5.put(str82, obj6);
                                    str31 = str82;
                                    String str83 = str55;
                                    try {
                                        Object obj7 = ((HashMap) arrayListI12.get(i6)).get(str83);
                                        str55 = str83;
                                        String str84 = str49;
                                        try {
                                            jSONObject5.put(str84, obj7);
                                            str49 = str84;
                                            String str85 = str18;
                                            String str86 = str20;
                                            try {
                                                jSONObject5.put(str85, str86);
                                                str18 = str85;
                                                str20 = str86;
                                                String str87 = str16;
                                                try {
                                                    jSONObject5.put(str87, 2);
                                                    VQ vq2 = t;
                                                    str12 = str12;
                                                    str16 = str87;
                                                    try {
                                                        Object[] objArr2 = new Object[1];
                                                        try {
                                                            objArr2[0] = jSONObject5;
                                                            str30 = str3;
                                                            try {
                                                                vq2.a(str30, objArr2);
                                                            } catch (JSONException e32) {
                                                                e = e32;
                                                                e.printStackTrace();
                                                            }
                                                        } catch (JSONException e33) {
                                                            e = e33;
                                                            str30 = str3;
                                                            e.printStackTrace();
                                                            i6++;
                                                            str3 = str30;
                                                            str21 = str28;
                                                            str78 = str29;
                                                            str12 = str12;
                                                            str67 = str31;
                                                        }
                                                    } catch (JSONException e34) {
                                                        e = e34;
                                                    }
                                                } catch (JSONException e35) {
                                                    e = e35;
                                                    str12 = str12;
                                                    str16 = str87;
                                                }
                                            } catch (JSONException e36) {
                                                e = e36;
                                                str12 = str12;
                                                str18 = str85;
                                                str20 = str86;
                                            }
                                        } catch (JSONException e37) {
                                            e = e37;
                                            str12 = str12;
                                            str49 = str84;
                                        }
                                    } catch (JSONException e38) {
                                        e = e38;
                                        str12 = str12;
                                        str55 = str83;
                                    }
                                } catch (JSONException e39) {
                                    e = e39;
                                    str12 = str12;
                                    str31 = str82;
                                }
                            } catch (JSONException e40) {
                                e = e40;
                                str66 = str81;
                                str30 = str3;
                                str31 = str67;
                                e.printStackTrace();
                                i6++;
                                str3 = str30;
                                str21 = str28;
                                str78 = str29;
                                str12 = str12;
                                str67 = str31;
                            }
                        } catch (JSONException e41) {
                            e = e41;
                            str76 = str80;
                        }
                    } catch (JSONException e42) {
                        e = e42;
                        str28 = str21;
                    }
                } catch (JSONException e43) {
                    e = e43;
                    str28 = str21;
                    str29 = str78;
                }
                i6++;
                str3 = str30;
                str21 = str28;
                str78 = str29;
                str12 = str12;
                str67 = str31;
            }
            String str88 = str12;
            String str89 = str21;
            String str90 = str3;
            String str91 = str67;
            arrayListI12.size();
            this.e.Ea(str2, str13);
            new ArrayList();
            ArrayList arrayListI13 = this.e.i8(str2, str13, str11);
            arrayListI13.size();
            Log.d(str78, arrayListI13.size() + str56);
            int i7 = 0;
            while (i7 < arrayListI13.size()) {
                JSONObject jSONObject6 = new JSONObject();
                try {
                    jSONObject6.put("un", ((HashMap) arrayListI13.get(i7)).get("_un"));
                    jSONObject6.put("p_un", ((HashMap) arrayListI13.get(i7)).get("_p_un"));
                    str27 = str88;
                    try {
                        jSONObject6.put(str27, ((HashMap) arrayListI13.get(i7)).get("f_br_id"));
                        String str92 = str89;
                        try {
                            jSONObject6.put(str92, ((HashMap) arrayListI13.get(i7)).get(str92));
                            String str93 = str76;
                            try {
                                jSONObject6.put(str93, ((HashMap) arrayListI13.get(i7)).get(str93));
                                str76 = str93;
                                String str94 = str66;
                                try {
                                    Object obj8 = ((HashMap) arrayListI13.get(i7)).get(str94);
                                    str66 = str94;
                                    String str95 = str91;
                                    try {
                                        jSONObject6.put(str95, obj8);
                                        str91 = str95;
                                        String str96 = str55;
                                        try {
                                            Object obj9 = ((HashMap) arrayListI13.get(i7)).get(str96);
                                            str55 = str96;
                                            String str97 = str49;
                                            try {
                                                jSONObject6.put(str97, obj9);
                                                str49 = str97;
                                                String str98 = str18;
                                                String str99 = str20;
                                                try {
                                                    jSONObject6.put(str98, str99);
                                                    str20 = str99;
                                                    str18 = str98;
                                                    String str100 = str16;
                                                    try {
                                                        jSONObject6.put(str100, 2);
                                                        str16 = str100;
                                                        str89 = str92;
                                                        t.a(str90, jSONObject6);
                                                    } catch (JSONException e44) {
                                                        e = e44;
                                                        str16 = str100;
                                                        str89 = str92;
                                                        e.printStackTrace();
                                                    }
                                                } catch (JSONException e45) {
                                                    e = e45;
                                                    str20 = str99;
                                                    str89 = str92;
                                                    str18 = str98;
                                                    e.printStackTrace();
                                                }
                                            } catch (JSONException e46) {
                                                e = e46;
                                                str89 = str92;
                                                str49 = str97;
                                            }
                                        } catch (JSONException e47) {
                                            e = e47;
                                            str89 = str92;
                                            str55 = str96;
                                        }
                                    } catch (JSONException e48) {
                                        e = e48;
                                        str89 = str92;
                                        str91 = str95;
                                    }
                                } catch (JSONException e49) {
                                    e = e49;
                                    str89 = str92;
                                    str66 = str94;
                                }
                            } catch (JSONException e50) {
                                e = e50;
                                str89 = str92;
                                str76 = str93;
                            }
                        } catch (JSONException e51) {
                            e = e51;
                        }
                    } catch (JSONException e52) {
                        e = e52;
                    }
                } catch (JSONException e53) {
                    e = e53;
                    str27 = str88;
                }
                i7++;
                str88 = str27;
            }
            String str101 = str88;
            arrayListI13.size();
            this.e.ta(str, str13);
            new ArrayList();
            ArrayList arrayListJ8 = this.e.j8(str, str13, str77);
            arrayListJ8.size();
            int i8 = 0;
            while (i8 < arrayListJ8.size()) {
                JSONObject jSONObject7 = new JSONObject();
                try {
                    jSONObject7.put(str17, ((HashMap) arrayListJ8.get(i8)).get("_un"));
                    jSONObject7.put(str14, ((HashMap) arrayListJ8.get(i8)).get("_p_un"));
                    jSONObject7.put(str101, ((HashMap) arrayListJ8.get(i8)).get("f_br_id"));
                    str22 = str89;
                    try {
                        jSONObject7.put(str22, ((HashMap) arrayListJ8.get(i8)).get(str22));
                        str24 = str76;
                        try {
                            jSONObject7.put(str24, ((HashMap) arrayListJ8.get(i8)).get(str24));
                            str23 = str66;
                            try {
                                str26 = str91;
                                try {
                                    jSONObject7.put(str26, ((HashMap) arrayListJ8.get(i8)).get(str23));
                                    str14 = str14;
                                    String str102 = str55;
                                    try {
                                        Object obj10 = ((HashMap) arrayListJ8.get(i8)).get(str102);
                                        str55 = str102;
                                        String str103 = str49;
                                        try {
                                            jSONObject7.put(str103, obj10);
                                            str49 = str103;
                                            String str104 = str18;
                                            str25 = str20;
                                            try {
                                                jSONObject7.put(str104, str25);
                                                str18 = str104;
                                                str17 = str17;
                                                String str105 = str16;
                                                try {
                                                    jSONObject7.put(str105, 1);
                                                    str16 = str105;
                                                    try {
                                                        VQ vq3 = t;
                                                        Object[] objArr3 = new Object[1];
                                                        try {
                                                            objArr3[0] = jSONObject7;
                                                            str79 = str79;
                                                            try {
                                                                vq3.a(str79, objArr3);
                                                            } catch (JSONException e54) {
                                                                e = e54;
                                                                e.printStackTrace();
                                                            }
                                                        } catch (JSONException e55) {
                                                            e = e55;
                                                            str79 = str79;
                                                        }
                                                    } catch (JSONException e56) {
                                                        e = e56;
                                                        str79 = str79;
                                                        e.printStackTrace();
                                                        i8++;
                                                        str79 = str79;
                                                        str20 = str25;
                                                        str89 = str22;
                                                        str76 = str24;
                                                        str66 = str23;
                                                        str91 = str26;
                                                        str14 = str14;
                                                        str17 = str17;
                                                    }
                                                } catch (JSONException e57) {
                                                    e = e57;
                                                    str16 = str105;
                                                }
                                            } catch (JSONException e58) {
                                                e = e58;
                                                str18 = str104;
                                                str17 = str17;
                                            }
                                        } catch (JSONException e59) {
                                            e = e59;
                                            str49 = str103;
                                            str17 = str17;
                                            str79 = str79;
                                            str25 = str20;
                                            e.printStackTrace();
                                            i8++;
                                            str79 = str79;
                                            str20 = str25;
                                            str89 = str22;
                                            str76 = str24;
                                            str66 = str23;
                                            str91 = str26;
                                            str14 = str14;
                                            str17 = str17;
                                        }
                                    } catch (JSONException e60) {
                                        e = e60;
                                        str55 = str102;
                                    }
                                } catch (JSONException e61) {
                                    e = e61;
                                    str14 = str14;
                                }
                            } catch (JSONException e62) {
                                e = e62;
                                str14 = str14;
                                str17 = str17;
                                str79 = str79;
                                str25 = str20;
                                str26 = str91;
                                e.printStackTrace();
                                i8++;
                                str79 = str79;
                                str20 = str25;
                                str89 = str22;
                                str76 = str24;
                                str66 = str23;
                                str91 = str26;
                                str14 = str14;
                                str17 = str17;
                            }
                        } catch (JSONException e63) {
                            e = e63;
                            str14 = str14;
                            str17 = str17;
                            str79 = str79;
                            str23 = str66;
                        }
                    } catch (JSONException e64) {
                        e = e64;
                        str23 = str66;
                        str24 = str76;
                        str25 = str20;
                        str26 = str91;
                        e.printStackTrace();
                        i8++;
                        str79 = str79;
                        str20 = str25;
                        str89 = str22;
                        str76 = str24;
                        str66 = str23;
                        str91 = str26;
                        str14 = str14;
                        str17 = str17;
                    }
                } catch (JSONException e65) {
                    e = e65;
                    str22 = str89;
                }
                i8++;
                str79 = str79;
                str20 = str25;
                str89 = str22;
                str76 = str24;
                str66 = str23;
                str91 = str26;
                str14 = str14;
                str17 = str17;
            }
            arrayListJ8.size();
        } catch (IOException e66) {
            e66.printStackTrace();
        }
    }

    public void j() throws Throwable {
        ArrayList arrayListI8;
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        ArrayList arrayList;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        ArrayList arrayList2;
        String str22;
        String str23;
        String str24 = "2";
        if (this.e.ja("online_server", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            this.e.t2(strIa);
            try {
                this.e.ua("1", strIa);
                this.e.ua("2", strIa);
                while (true) {
                    str3 = "json_";
                    str4 = "json";
                    str5 = "ref";
                    str6 = str2;
                    str7 = str;
                    str8 = str24;
                    str9 = strIa;
                    str10 = "_un";
                    str11 = token;
                    if (i2 >= arrayListI8.size()) {
                        break;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("un", ((HashMap) arrayListI8.get(i2)).get("_un"));
                        jSONObject.put("p_un", ((HashMap) arrayListI8.get(i2)).get("_p_un"));
                        jSONObject.put("c_br_id", ((HashMap) arrayListI8.get(i2)).get("f_br_id"));
                        jSONObject.put("tr_type", ((HashMap) arrayListI8.get(i2)).get("tr_type"));
                        jSONObject.put("acc_type", ((HashMap) arrayListI8.get(i2)).get("acc_type"));
                        jSONObject.put("ref_no", ((HashMap) arrayListI8.get(i2)).get("ref"));
                        jSONObject.put("json", ((HashMap) arrayListI8.get(i2)).get("json_"));
                        str23 = str11;
                        try {
                            jSONObject.put("fcm_token", str23);
                            jSONObject.put("action_type", 2);
                            t.a("add_server_req", jSONObject);
                        } catch (JSONException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        str23 = str11;
                    }
                    i2++;
                    token = str23;
                    str2 = str6;
                    str = str7;
                    str24 = str8;
                    strIa = str9;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            new ArrayList();
            arrayListI8 = this.e.i8("1", strIa, "2");
            arrayListI8.size();
            StringBuilder sb = new StringBuilder();
            sb.append(arrayListI8.size());
            str = "";
            sb.append("");
            str2 = "req_sls_out2=";
            Log.d("req_sls_out2=", sb.toString());
            i2 = 0;
            String str25 = "action_type";
            String str26 = "add_server_req";
            String str27 = "fcm_token";
            String str28 = str9;
            String str29 = str11;
            ArrayList arrayListI9 = this.e.i8(str8, str28, str8);
            arrayListI9.size();
            Log.d(str6, arrayListI9.size() + str7);
            int i3 = 0;
            while (i3 < arrayListI9.size()) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    str20 = str28;
                    try {
                        jSONObject2.put("un", ((HashMap) arrayListI9.get(i3)).get("_un"));
                        jSONObject2.put("p_un", ((HashMap) arrayListI9.get(i3)).get("_p_un"));
                        jSONObject2.put("c_br_id", ((HashMap) arrayListI9.get(i3)).get("f_br_id"));
                        jSONObject2.put("tr_type", ((HashMap) arrayListI9.get(i3)).get("tr_type"));
                        jSONObject2.put("acc_type", ((HashMap) arrayListI9.get(i3)).get("acc_type"));
                        jSONObject2.put("ref_no", ((HashMap) arrayListI9.get(i3)).get("ref"));
                        jSONObject2.put(str4, ((HashMap) arrayListI9.get(i3)).get("json_"));
                        arrayList2 = arrayListI9;
                        String str30 = str29;
                        String str31 = str27;
                        try {
                            jSONObject2.put(str31, str30);
                            str29 = str30;
                            str27 = str31;
                            String str32 = str25;
                            try {
                                jSONObject2.put(str32, 2);
                                str21 = str4;
                                str25 = str32;
                                try {
                                    str22 = str26;
                                    try {
                                        t.a(str22, jSONObject2);
                                    } catch (JSONException e6) {
                                        e = e6;
                                        e.printStackTrace();
                                    }
                                } catch (JSONException e7) {
                                    e = e7;
                                    str22 = str26;
                                    e.printStackTrace();
                                    i3++;
                                    str26 = str22;
                                    arrayListI9 = arrayList2;
                                    str28 = str20;
                                    str4 = str21;
                                }
                            } catch (JSONException e8) {
                                e = e8;
                                str21 = str4;
                                str25 = str32;
                            }
                        } catch (JSONException e9) {
                            e = e9;
                            str29 = str30;
                            str21 = str4;
                            str27 = str31;
                        }
                    } catch (JSONException e10) {
                        e = e10;
                        str21 = str4;
                        arrayList2 = arrayListI9;
                        str22 = str26;
                        e.printStackTrace();
                        i3++;
                        str26 = str22;
                        arrayListI9 = arrayList2;
                        str28 = str20;
                        str4 = str21;
                    }
                } catch (JSONException e11) {
                    e = e11;
                    str20 = str28;
                }
                i3++;
                str26 = str22;
                arrayListI9 = arrayList2;
                str28 = str20;
                str4 = str21;
            }
            String str33 = str28;
            String str34 = str4;
            String str35 = str26;
            try {
                str12 = str33;
                try {
                    this.e.sa("-3", str12);
                } catch (IOException e12) {
                    e = e12;
                    e.printStackTrace();
                }
            } catch (IOException e13) {
                e = e13;
                str12 = str33;
            }
            ArrayList arrayListI10 = this.e.i8("5", str12, str8);
            arrayListI10.size();
            int i4 = 0;
            while (i4 < arrayListI10.size()) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    str16 = str12;
                    try {
                        jSONObject3.put("un", ((HashMap) arrayListI10.get(i4)).get("_un"));
                        jSONObject3.put("p_un", ((HashMap) arrayListI10.get(i4)).get("_p_un"));
                        jSONObject3.put("c_br_id", ((HashMap) arrayListI10.get(i4)).get("f_br_id"));
                        jSONObject3.put("tr_type", ((HashMap) arrayListI10.get(i4)).get("tr_type"));
                        jSONObject3.put("acc_type", ((HashMap) arrayListI10.get(i4)).get("acc_type"));
                        jSONObject3.put("ref_no", ((HashMap) arrayListI10.get(i4)).get("ref"));
                        Object obj = ((HashMap) arrayListI10.get(i4)).get(str3);
                        arrayList = arrayListI10;
                        String str36 = str34;
                        try {
                            jSONObject3.put(str36, obj);
                            str34 = str36;
                            String str37 = str29;
                            String str38 = str27;
                            try {
                                jSONObject3.put(str38, str37);
                                str27 = str38;
                                String str39 = str25;
                                str18 = str37;
                                try {
                                    jSONObject3.put(str39, 2);
                                    str17 = str39;
                                    str19 = str3;
                                    try {
                                        t.a(str35, jSONObject3);
                                    } catch (JSONException e14) {
                                        e = e14;
                                        e.printStackTrace();
                                    }
                                } catch (JSONException e15) {
                                    e = e15;
                                    str17 = str39;
                                    str19 = str3;
                                    e.printStackTrace();
                                    i4++;
                                    arrayListI10 = arrayList;
                                    str12 = str16;
                                    str3 = str19;
                                    str29 = str18;
                                    str25 = str17;
                                }
                            } catch (JSONException e16) {
                                e = e16;
                                str27 = str38;
                                str19 = str3;
                                str17 = str25;
                                str18 = str37;
                            }
                        } catch (JSONException e17) {
                            e = e17;
                            str34 = str36;
                            str17 = str25;
                            str18 = str29;
                            str19 = str3;
                            e.printStackTrace();
                            i4++;
                            arrayListI10 = arrayList;
                            str12 = str16;
                            str3 = str19;
                            str29 = str18;
                            str25 = str17;
                        }
                    } catch (JSONException e18) {
                        e = e18;
                        arrayList = arrayListI10;
                    }
                } catch (JSONException e19) {
                    e = e19;
                    arrayList = arrayListI10;
                    str16 = str12;
                }
                i4++;
                arrayListI10 = arrayList;
                str12 = str16;
                str3 = str19;
                str29 = str18;
                str25 = str17;
            }
            String str40 = str25;
            String str41 = str29;
            String str42 = str3;
            ArrayList arrayListI11 = this.e.i8("6", str12, str8);
            arrayListI11.size();
            int i5 = 0;
            while (i5 < arrayListI11.size()) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("un", ((HashMap) arrayListI11.get(i5)).get(str10));
                    jSONObject4.put("p_un", ((HashMap) arrayListI11.get(i5)).get("_p_un"));
                    jSONObject4.put("c_br_id", ((HashMap) arrayListI11.get(i5)).get("f_br_id"));
                    jSONObject4.put("tr_type", ((HashMap) arrayListI11.get(i5)).get("tr_type"));
                    jSONObject4.put("acc_type", ((HashMap) arrayListI11.get(i5)).get("acc_type"));
                    jSONObject4.put("ref_no", ((HashMap) arrayListI11.get(i5)).get(str5));
                    str13 = str10;
                    String str43 = str42;
                    try {
                        Object obj2 = ((HashMap) arrayListI11.get(i5)).get(str43);
                        str42 = str43;
                        String str44 = str34;
                        try {
                            jSONObject4.put(str44, obj2);
                            str34 = str44;
                            str15 = str41;
                            String str45 = str27;
                            try {
                                jSONObject4.put(str45, str15);
                                str27 = str45;
                                str14 = str5;
                                String str46 = str40;
                                try {
                                    jSONObject4.put(str46, 2);
                                    VQ vq = t;
                                    str40 = str46;
                                    try {
                                        Object[] objArr = new Object[1];
                                        try {
                                            objArr[0] = jSONObject4;
                                            vq.a(str35, objArr);
                                        } catch (JSONException e20) {
                                            e = e20;
                                            e.printStackTrace();
                                        }
                                    } catch (JSONException e21) {
                                        e = e21;
                                        e.printStackTrace();
                                        i5++;
                                        str41 = str15;
                                        str5 = str14;
                                        str10 = str13;
                                    }
                                } catch (JSONException e22) {
                                    e = e22;
                                    str40 = str46;
                                }
                            } catch (JSONException e23) {
                                e = e23;
                                str27 = str45;
                                str14 = str5;
                            }
                        } catch (JSONException e24) {
                            e = e24;
                            str34 = str44;
                            str14 = str5;
                            str15 = str41;
                            e.printStackTrace();
                            i5++;
                            str41 = str15;
                            str5 = str14;
                            str10 = str13;
                        }
                    } catch (JSONException e25) {
                        e = e25;
                        str42 = str43;
                    }
                } catch (JSONException e26) {
                    e = e26;
                    str13 = str10;
                }
                i5++;
                str41 = str15;
                str5 = str14;
                str10 = str13;
            }
        }
    }

    public void k() {
        if (this.e.ja("online_server", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            ArrayList arrayListT2 = this.e.t2(strIa);
            for (int i2 = 0; i2 < arrayListT2.size(); i2++) {
                try {
                    this.e.Ba("-200", strIa, (String) arrayListT2.get(i2));
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            new ArrayList();
            ArrayList arrayListI8 = this.e.i8("-202", strIa, "2");
            arrayListI8.size();
            Log.d("req_m=", arrayListI8.size() + "");
            for (int i3 = 0; i3 < arrayListI8.size(); i3++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("un", ((HashMap) arrayListI8.get(i3)).get("_un"));
                    jSONObject.put("p_un", ((HashMap) arrayListI8.get(i3)).get("_p_un"));
                    jSONObject.put("c_br_id", ((HashMap) arrayListI8.get(i3)).get("f_br_id"));
                    jSONObject.put("tr_type", ((HashMap) arrayListI8.get(i3)).get("tr_type"));
                    jSONObject.put("acc_type", ((HashMap) arrayListI8.get(i3)).get("acc_type"));
                    jSONObject.put("ref_no", ((HashMap) arrayListI8.get(i3)).get("ref"));
                    jSONObject.put("json", ((HashMap) arrayListI8.get(i3)).get("json_"));
                    jSONObject.put("fcm_token", token);
                    jSONObject.put("action_type", 2);
                    t.a("add_server_req", jSONObject);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void l() {
        if (this.e.ja("online_server", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            ArrayList arrayListT2 = this.e.t2(strIa);
            for (int i2 = 0; i2 < arrayListT2.size(); i2++) {
                try {
                    this.e.Da("-200", strIa, (String) arrayListT2.get(i2));
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            new ArrayList();
            ArrayList arrayListI8 = this.e.i8("-200", strIa, "2");
            arrayListI8.size();
            Log.d("req_m=", arrayListI8.size() + "");
            for (int i3 = 0; i3 < arrayListI8.size(); i3++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("un", ((HashMap) arrayListI8.get(i3)).get("_un"));
                    jSONObject.put("p_un", ((HashMap) arrayListI8.get(i3)).get("_p_un"));
                    jSONObject.put("c_br_id", ((HashMap) arrayListI8.get(i3)).get("f_br_id"));
                    jSONObject.put("tr_type", ((HashMap) arrayListI8.get(i3)).get("tr_type"));
                    jSONObject.put("acc_type", ((HashMap) arrayListI8.get(i3)).get("acc_type"));
                    jSONObject.put("ref_no", ((HashMap) arrayListI8.get(i3)).get("ref"));
                    jSONObject.put("json", ((HashMap) arrayListI8.get(i3)).get("json_"));
                    jSONObject.put("fcm_token", token);
                    jSONObject.put("action_type", 2);
                    t.a("add_server_req", jSONObject);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void m() {
        if (this.e.ja("online_server", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            ArrayList arrayListT2 = this.e.t2(strIa);
            for (int i2 = 0; i2 < arrayListT2.size(); i2++) {
                try {
                    this.e.Ca("-201", strIa, (String) arrayListT2.get(i2));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            new ArrayList();
            ArrayList arrayListI8 = this.e.i8("-201", strIa, "2");
            arrayListI8.size();
            Log.d("req_m=", arrayListI8.size() + "");
            for (int i3 = 0; i3 < arrayListI8.size(); i3++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("un", ((HashMap) arrayListI8.get(i3)).get("_un"));
                    jSONObject.put("p_un", ((HashMap) arrayListI8.get(i3)).get("_p_un"));
                    jSONObject.put("c_br_id", ((HashMap) arrayListI8.get(i3)).get("f_br_id"));
                    jSONObject.put("tr_type", ((HashMap) arrayListI8.get(i3)).get("tr_type"));
                    jSONObject.put("acc_type", ((HashMap) arrayListI8.get(i3)).get("acc_type"));
                    jSONObject.put("ref_no", ((HashMap) arrayListI8.get(i3)).get("ref"));
                    jSONObject.put("json", ((HashMap) arrayListI8.get(i3)).get("json_"));
                    jSONObject.put("fcm_token", token);
                    jSONObject.put("action_type", 2);
                    t.a("add_server_req", jSONObject);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void n() throws Throwable {
        if (t == null) {
            return;
        }
        v = Long.parseLong(this.e.ia("share_TimeMillis", "0"));
        w = Integer.parseInt(this.e.ia("server_retry", "5"));
        Log.d("socket:trace=", v + ":" + w + ":" + ((System.currentTimeMillis() - v) / 60000) + ":" + t.F() + ":" + t.z());
        if (u == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = v;
            if ((jCurrentTimeMillis - j2) / 60000 >= w || j2 == 0) {
                o();
                h();
                f();
                i();
                e();
                try {
                    this.e.r0();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                v = System.currentTimeMillis();
                this.e.Lc("share_TimeMillis", v + "");
            }
        }
    }

    public void o() {
        try {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            new ArrayList();
            ArrayList arrayListK8 = this.e.k8(strIa);
            for (int i2 = 0; i2 < arrayListK8.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("un", ((HashMap) arrayListK8.get(i2)).get("_un"));
                    jSONObject.put("p_un", ((HashMap) arrayListK8.get(i2)).get("_p_un"));
                    jSONObject.put("c_br_id", ((HashMap) arrayListK8.get(i2)).get("f_br_id"));
                    jSONObject.put("tr_type", ((HashMap) arrayListK8.get(i2)).get("tr_type"));
                    jSONObject.put("acc_type", ((HashMap) arrayListK8.get(i2)).get("acc_type"));
                    jSONObject.put("ref_no", ((HashMap) arrayListK8.get(i2)).get("ref"));
                    jSONObject.put("fcm_token", token);
                    jSONObject.put("action_type", ((HashMap) arrayListK8.get(i2)).get("action_type"));
                    t.a("confirm_client_add_req", jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() throws Throwable {
        this.c = getApplicationContext();
        this.e = new Z00(this.d, this.c);
        g();
        HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
        handlerThread.start();
        this.a = handlerThread.getLooper();
        this.b = new n(this.a);
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.c == null || this.e == null) {
            this.c = getApplicationContext();
            this.e = new Z00(this.d, this.c);
        }
        Message messageObtainMessage = this.b.obtainMessage();
        messageObtainMessage.arg1 = i3;
        this.b.sendMessage(messageObtainMessage);
        return 1;
    }
}
