package info.aalmoghalis.inventory.fcm;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0892Rr;
import defpackage.AbstractC0963Uk;
import defpackage.AbstractC4371yX;
import defpackage.C3257km;
import defpackage.C3339lm;
import defpackage.VQ;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class feed_notification extends BaseActivity {
    public C3339lm B;
    public LinearLayout C;
    public ArrayAdapter G;
    public VQ H;
    public SQLiteDatabase d;
    public Z00 e;
    public String c = feed_notification.class.getSimpleName();
    public double f = 0.0d;
    public int g = 0;
    public int h = 0;
    public AutoCompleteTextView i = null;
    public EditText j = null;
    public EditText k = null;
    public TextView l = null;
    public ImageView n = null;
    public TextView p = null;
    public TextView q = null;
    public TextView t = null;
    public TextView u = null;
    public Button v = null;
    public ImageView w = null;
    public ImageView x = null;
    public ImageView y = null;
    public RecyclerView z = null;
    public LinearLayout A = null;
    public ArrayList D = new ArrayList();
    public AbstractC0963Uk.a E = new b();
    public AbstractC0963Uk.a F = new c();

    public class a implements AbstractC0963Uk.a {
        public a() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            feed_notification.this.w();
        }
    }

    public class b implements AbstractC0963Uk.a {

        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            /* JADX WARN: Code duplicated, block: B:43:0x014e A[Catch: JSONException -> 0x0195, TRY_LEAVE, TryCatch #2 {JSONException -> 0x0195, blocks: (B:3:0x000b, B:4:0x0021, B:6:0x0027, B:41:0x00a9, B:43:0x014e, B:48:0x0180, B:53:0x0199, B:47:0x017d, B:40:0x009e, B:54:0x01a2, B:44:0x016b), top: B:62:0x000b, inners: #8 }] */
            /* JADX WARN: Code duplicated, block: B:52:0x0197  */
            @Override // java.lang.Runnable
            public void run() {
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
                String str = "json_";
                String str2 = "";
                try {
                    JSONArray jSONArray = new JSONArray(this.a[0].toString()).optJSONObject(0).getJSONArray("json_");
                    int i10 = 0;
                    while (i10 < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
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
                                                                i9 = jSONObjectOptJSONObject.getInt("tr_type");
                                                                i7 = i3;
                                                                i8 = i4;
                                                            } catch (JSONException e) {
                                                                e = e;
                                                                e.printStackTrace();
                                                                i7 = i3;
                                                                i8 = i4;
                                                                i9 = 0;
                                                            }
                                                        } catch (JSONException e2) {
                                                            e = e2;
                                                            i6 = 0;
                                                            e.printStackTrace();
                                                            i7 = i3;
                                                            i8 = i4;
                                                            i9 = 0;
                                                            int i11 = i5;
                                                            String str3 = str;
                                                            int i12 = i6;
                                                            JSONArray jSONArray2 = jSONArray;
                                                            feed_notification.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i11 + "," + i12 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                            StringBuilder sb = new StringBuilder();
                                                            Z00 z00 = feed_notification.this.e;
                                                            StringBuilder sb2 = new StringBuilder();
                                                            sb2.append(i);
                                                            str2 = str2;
                                                            sb2.append(str2);
                                                            sb.append(z00.m8(sb2.toString()));
                                                            sb.append(str2);
                                                            Log.d("requests_cnt=", sb.toString());
                                                            if (feed_notification.this.e.m8(i + str2) > 0) {
                                                                jSONObjectOptJSONObject.remove("json");
                                                                String strIa = feed_notification.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                                String token = FirebaseInstanceId.getInstance().getToken();
                                                                try {
                                                                    jSONObjectOptJSONObject.put("un", strIa);
                                                                    jSONObjectOptJSONObject.put("fcm_token", token);
                                                                    jSONObjectOptJSONObject.put("action_type", 2);
                                                                } catch (JSONException e3) {
                                                                    e3.printStackTrace();
                                                                }
                                                                feed_notification.this.H.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                                            }
                                                            i10++;
                                                            str = str3;
                                                            jSONArray = jSONArray2;
                                                        }
                                                    } catch (JSONException e4) {
                                                        e = e4;
                                                        i5 = 0;
                                                        i6 = 0;
                                                        e.printStackTrace();
                                                        i7 = i3;
                                                        i8 = i4;
                                                        i9 = 0;
                                                        int i13 = i5;
                                                        String str4 = str;
                                                        int i14 = i6;
                                                        JSONArray jSONArray3 = jSONArray;
                                                        feed_notification.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i13 + "," + i14 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                        StringBuilder sb3 = new StringBuilder();
                                                        Z00 z01 = feed_notification.this.e;
                                                        StringBuilder sb4 = new StringBuilder();
                                                        sb4.append(i);
                                                        str2 = str2;
                                                        sb4.append(str2);
                                                        sb3.append(z01.m8(sb4.toString()));
                                                        sb3.append(str2);
                                                        Log.d("requests_cnt=", sb3.toString());
                                                        if (feed_notification.this.e.m8(i + str2) > 0) {
                                                            jSONObjectOptJSONObject.remove("json");
                                                            String strIa2 = feed_notification.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                            String token2 = FirebaseInstanceId.getInstance().getToken();
                                                            jSONObjectOptJSONObject.put("un", strIa2);
                                                            jSONObjectOptJSONObject.put("fcm_token", token2);
                                                            jSONObjectOptJSONObject.put("action_type", 2);
                                                            feed_notification.this.H.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                                        }
                                                        i10++;
                                                        str = str4;
                                                        jSONArray = jSONArray3;
                                                    }
                                                } catch (JSONException e5) {
                                                    e = e5;
                                                    i4 = 0;
                                                    i5 = 0;
                                                    i6 = 0;
                                                    e.printStackTrace();
                                                    i7 = i3;
                                                    i8 = i4;
                                                    i9 = 0;
                                                    int i15 = i5;
                                                    String str5 = str;
                                                    int i16 = i6;
                                                    JSONArray jSONArray4 = jSONArray;
                                                    feed_notification.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i15 + "," + i16 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                    StringBuilder sb5 = new StringBuilder();
                                                    Z00 z02 = feed_notification.this.e;
                                                    StringBuilder sb6 = new StringBuilder();
                                                    sb6.append(i);
                                                    str2 = str2;
                                                    sb6.append(str2);
                                                    sb5.append(z02.m8(sb6.toString()));
                                                    sb5.append(str2);
                                                    Log.d("requests_cnt=", sb5.toString());
                                                    if (feed_notification.this.e.m8(i + str2) > 0) {
                                                        jSONObjectOptJSONObject.remove("json");
                                                        String strIa3 = feed_notification.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                        String token3 = FirebaseInstanceId.getInstance().getToken();
                                                        jSONObjectOptJSONObject.put("un", strIa3);
                                                        jSONObjectOptJSONObject.put("fcm_token", token3);
                                                        jSONObjectOptJSONObject.put("action_type", 2);
                                                        feed_notification.this.H.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                                    }
                                                    i10++;
                                                    str = str5;
                                                    jSONArray = jSONArray4;
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
                                                i9 = 0;
                                                int i17 = i5;
                                                String str6 = str;
                                                int i18 = i6;
                                                JSONArray jSONArray5 = jSONArray;
                                                feed_notification.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i17 + "," + i18 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                StringBuilder sb7 = new StringBuilder();
                                                Z00 z03 = feed_notification.this.e;
                                                StringBuilder sb8 = new StringBuilder();
                                                sb8.append(i);
                                                str2 = str2;
                                                sb8.append(str2);
                                                sb7.append(z03.m8(sb8.toString()));
                                                sb7.append(str2);
                                                Log.d("requests_cnt=", sb7.toString());
                                                if (feed_notification.this.e.m8(i + str2) > 0) {
                                                    jSONObjectOptJSONObject.remove("json");
                                                    String strIa4 = feed_notification.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                    String token4 = FirebaseInstanceId.getInstance().getToken();
                                                    jSONObjectOptJSONObject.put("un", strIa4);
                                                    jSONObjectOptJSONObject.put("fcm_token", token4);
                                                    jSONObjectOptJSONObject.put("action_type", 2);
                                                    feed_notification.this.H.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                                }
                                                i10++;
                                                str = str6;
                                                jSONArray = jSONArray5;
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
                                            i9 = 0;
                                            int i19 = i5;
                                            String str7 = str;
                                            int i110 = i6;
                                            JSONArray jSONArray6 = jSONArray;
                                            feed_notification.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i19 + "," + i110 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                            StringBuilder sb9 = new StringBuilder();
                                            Z00 z04 = feed_notification.this.e;
                                            StringBuilder sb10 = new StringBuilder();
                                            sb10.append(i);
                                            str2 = str2;
                                            sb10.append(str2);
                                            sb9.append(z04.m8(sb10.toString()));
                                            sb9.append(str2);
                                            Log.d("requests_cnt=", sb9.toString());
                                            if (feed_notification.this.e.m8(i + str2) > 0) {
                                                jSONObjectOptJSONObject.remove("json");
                                                String strIa5 = feed_notification.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                String token5 = FirebaseInstanceId.getInstance().getToken();
                                                jSONObjectOptJSONObject.put("un", strIa5);
                                                jSONObjectOptJSONObject.put("fcm_token", token5);
                                                jSONObjectOptJSONObject.put("action_type", 2);
                                                feed_notification.this.H.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                            }
                                            i10++;
                                            str = str7;
                                            jSONArray = jSONArray6;
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
                                    i9 = 0;
                                    int i111 = i5;
                                    String str8 = str;
                                    int i112 = i6;
                                    JSONArray jSONArray7 = jSONArray;
                                    feed_notification.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i111 + "," + i112 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                    StringBuilder sb11 = new StringBuilder();
                                    Z00 z05 = feed_notification.this.e;
                                    StringBuilder sb12 = new StringBuilder();
                                    sb12.append(i);
                                    str2 = str2;
                                    sb12.append(str2);
                                    sb11.append(z05.m8(sb12.toString()));
                                    sb11.append(str2);
                                    Log.d("requests_cnt=", sb11.toString());
                                    if (feed_notification.this.e.m8(i + str2) > 0) {
                                        jSONObjectOptJSONObject.remove("json");
                                        String strIa6 = feed_notification.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                        String token6 = FirebaseInstanceId.getInstance().getToken();
                                        jSONObjectOptJSONObject.put("un", strIa6);
                                        jSONObjectOptJSONObject.put("fcm_token", token6);
                                        jSONObjectOptJSONObject.put("action_type", 2);
                                        feed_notification.this.H.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                                    }
                                    i10++;
                                    str = str8;
                                    jSONArray = jSONArray7;
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
                        int i113 = i5;
                        String str9 = str;
                        int i114 = i6;
                        JSONArray jSONArray8 = jSONArray;
                        feed_notification.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i113 + "," + i114 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                        StringBuilder sb13 = new StringBuilder();
                        Z00 z06 = feed_notification.this.e;
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append(i);
                        str2 = str2;
                        sb14.append(str2);
                        sb13.append(z06.m8(sb14.toString()));
                        sb13.append(str2);
                        Log.d("requests_cnt=", sb13.toString());
                        if (feed_notification.this.e.m8(i + str2) > 0) {
                            jSONObjectOptJSONObject.remove("json");
                            String strIa7 = feed_notification.this.e.ia("PREF_ACCOUNT_NAME", "0");
                            String token7 = FirebaseInstanceId.getInstance().getToken();
                            jSONObjectOptJSONObject.put("un", strIa7);
                            jSONObjectOptJSONObject.put("fcm_token", token7);
                            jSONObjectOptJSONObject.put("action_type", 2);
                            feed_notification.this.H.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                        }
                        i10++;
                        str = str9;
                        jSONArray = jSONArray8;
                    }
                    jSONArray.length();
                } catch (JSONException e12) {
                    e12.printStackTrace();
                }
            }
        }

        public b() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            feed_notification.this.runOnUiThread(new a(objArr));
        }
    }

    public class c implements AbstractC0963Uk.a {

        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(this.a[0].toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                try {
                    jSONObject.getString("un");
                    jSONObject.getString("p_un");
                    jSONObject.getString("ref_no");
                    jSONObject.getString("text");
                    Toast.makeText(feed_notification.this, jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE), 1).show();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public c() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            feed_notification.this.runOnUiThread(new a(objArr));
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ TextView a;

        public d(TextView textView) {
            this.a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            feed_notification feed_notificationVar = feed_notification.this;
            feed_notificationVar.e.T(feed_notificationVar, feed_notificationVar.G, this.a);
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlertDialog d;

        public g(TextView textView, EditText editText, String str, AlertDialog alertDialog) {
            this.a = textView;
            this.b = editText;
            this.c = str;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = this.a.getText().toString().length() != 0;
            if (!this.a.getText().toString().toLowerCase().endsWith("@gmail.com")) {
                z = false;
            }
            if (!AbstractC4371yX.a(this.b)) {
                z = false;
            }
            if (z) {
                feed_notification feed_notificationVar = feed_notification.this;
                Toast.makeText(feed_notificationVar, feed_notificationVar.getString(R.string.wait), 0).show();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("p_un", this.c);
                    jSONObject.put("un", this.a.getText().toString());
                    new DateFormat();
                    String string = DateFormat.format("yyyyMMddkkmmss", new Date()).toString();
                    String string2 = DateFormat.format("yyyy-MM-dd", new Date()).toString();
                    jSONObject.put("fcm_token", FirebaseInstanceId.getInstance().getToken());
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.b.getText().toString());
                    jSONObject.put("ref_no", this.c + "-" + string + "-100");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("title", this.a.getText().toString());
                    jSONObject2.put("date_", string2);
                    jSONObject2.put("message", this.b.getText().toString());
                    new JSONArray().put(0, jSONObject2);
                    jSONObject.put("action_type", 2);
                    jSONObject.put("tr_type", -100);
                    jSONObject.put("json", jSONObject2);
                    jSONObject.put("c_br_id", feed_notification.this.e.E2(this.a.getText().toString()));
                    feed_notification.this.H.a("add_server_push", jSONObject);
                    feed_notification.this.e.v0("insert into requests_notify(title,message) values('" + this.c + "','" + this.b.getText().toString() + "')");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.d.dismiss();
                feed_notification.this.B();
            }
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public feed_notification() {
        try {
            this.H = AbstractC0892Rr.a("https://bkp2.dyndns.org:7000");
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
    }

    public void A() {
        C3339lm c3339lm = new C3339lm(this, this.D);
        this.B = c3339lm;
        this.z.setAdapter(c3339lm);
    }

    public void B() {
        this.e.v0("update requests_notify set param1=1 where param1 is null");
        Cursor cursorN8 = this.e.n8();
        Log.d("cnt=", cursorN8.getCount() + "");
        this.f = 0.0d;
        this.D.clear();
        cursorN8.moveToFirst();
        while (!cursorN8.isAfterLast()) {
            this.D.add(new C3257km(cursorN8.getString(cursorN8.getColumnIndex("_id")), "", cursorN8.getString(cursorN8.getColumnIndex("title")), cursorN8.getString(cursorN8.getColumnIndex("date_")), cursorN8.getString(cursorN8.getColumnIndex("message")), "", ""));
            cursorN8.moveToNext();
        }
        cursorN8.close();
        A();
    }

    public void C() {
        try {
            if (!this.H.z()) {
                Toast.makeText(this, getString(R.string.no_internet), 0).show();
                return;
            }
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            if (strIa == "0") {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer7, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(R.id.email);
            EditText editText = (EditText) viewInflate.findViewById(R.id.msg_text);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.t2(strIa));
            this.G = arrayAdapter;
            if (arrayAdapter.getCount() > 0) {
                textView.setText((CharSequence) this.G.getItem(0));
            }
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            textView.setOnClickListener(new d(textView));
            editText.requestFocus();
            builder.setPositiveButton(getString(R.string.btn_send), new e());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new f());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.send_notification));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new g(textView, editText, strIa, alertDialogCreate));
        } catch (Exception e2) {
            Log.d("push_server_error=", e2.getMessage());
            e2.printStackTrace();
        }
    }

    public void amount_add_btn(View view) {
    }

    public void no_result_btn(View view) {
        B();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.notification_list);
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        this.w = (ImageView) findViewById(R.id.img_add_amount);
        this.C = (LinearLayout) findViewById(R.id.edit_cus_interface3);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_data);
        this.z = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.e = new Z00(this.d, this);
        B();
        this.C.setVisibility(8);
        if (this.e.ja("online_server", false)) {
            this.C.setVisibility(0);
        }
        if (this.e.ja("online_server", false) || this.e.ja("online_client", false)) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            this.H.e("connect", new a());
            this.H.e("confirm_fetch_client_req", this.E);
            this.H.e("confirm_server_push", this.F);
            this.H.y();
            z();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.H.B();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        B();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void send_msg(View view) {
        C();
    }

    public void show_help(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.online_service));
        builder.setPositiveButton(getString(R.string.btn_close), new h());
        builder.create().show();
    }

    public void w() {
        String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || strIa == "0") {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("un", strIa);
            jSONObject.put("fcm_token", token);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.H.a("auth", jSONObject);
    }

    public void z() {
        if (this.e.ja("online_client", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            new ArrayList();
            ArrayList arrayListX2 = this.e.x2("1", strIa);
            for (int i = 0; i < arrayListX2.size(); i++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("p_un", strIa);
                    jSONObject.put("un", ((HashMap) arrayListX2.get(i)).get("email"));
                    jSONObject.put("fcm_token", token);
                    jSONObject.put("acc_type", -100);
                    jSONObject.put("br_id", ((HashMap) arrayListX2.get(i)).get(HTML.Attribute.ID));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.H.a("fetch_server_req", jSONObject);
            }
            try {
                if (this.e.Aa("-100", "0") > 0) {
                    B();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }
}
