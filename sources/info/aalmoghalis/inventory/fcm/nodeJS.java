package info.aalmoghalis.inventory.fcm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0892Rr;
import defpackage.AbstractC0963Uk;
import defpackage.AbstractC4158vt;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0870Qv;
import defpackage.C4143vg;
import defpackage.VQ;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import info.aalmoghalis.inventory.threads.SocketService;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.hpsf.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.nikartm.support.ImageBadgeView;

/* JADX INFO: loaded from: classes3.dex */
public class nodeJS extends BaseActivity {
    public static int T;
    public C0870Qv B;
    public SparseBooleanArray D;
    public VQ E;
    public AbstractC0963Uk.a F;
    public AbstractC0963Uk.a G;
    public AbstractC0963Uk.a H;
    public AbstractC0963Uk.a I;
    public AbstractC0963Uk.a J;
    public AbstractC0963Uk.a K;
    public AbstractC0963Uk.a L;
    public AbstractC0963Uk.a M;
    public boolean N;
    public String O;
    public Dialog P;
    public Handler Q;
    public ArrayAdapter R;
    public ArrayAdapter S;
    public SQLiteDatabase d;
    public Z00 e;
    public String c = nodeJS.class.getSimpleName();
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
    public ImageBadgeView y = null;
    public ListView z = null;
    public LinearLayout A = null;
    public ArrayList C = new ArrayList();

    public class A implements AbstractC0963Uk.a {
        public A() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Log.d("socket:error:", "EVENT_CONNECT_ERROR:" + objArr);
            nodeJS.this.E();
        }
    }

    public class B implements AbstractC0963Uk.a {

        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                String string;
                try {
                    jSONObject = new JSONObject(this.a[0].toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                try {
                    string = jSONObject.getString("p_un");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    string = "";
                }
                String str = string;
                nodeJS.this.e.ia("PREF_ACCOUNT_NAME", "0");
                nodeJS.this.e.Mc("online_client", true);
                nodeJS.this.e.v0("update sys_conf set value_=1 where id=8");
                nodeJS.this.e.Mc("prefOthers_sales_out_qty", true);
                nodeJS.this.x.setVisibility(0);
                nodeJS.this.V("branches", "", "0", str, this.a[0].toString(), "confirm_client");
                String token = FirebaseInstanceId.getInstance().getToken();
                HashMap map = new HashMap();
                map.put("fcm", token);
                map.put(NotificationCompat.CATEGORY_STATUS, 1);
            }
        }

        public B() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            nodeJS.this.runOnUiThread(new a(objArr));
        }
    }

    public class C implements AbstractC0963Uk.a {

        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                String string;
                String string2 = "";
                try {
                    jSONObject = new JSONObject(this.a[0].toString());
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
                String str = string;
                nodeJS.this.e.Mc("online_server", true);
                nodeJS.this.e.v0("update sys_conf set value_=2 where id=8");
                nodeJS.this.e.v0("update customers set online=0 where online!=0");
                nodeJS.this.e.v0("update items set online=0 where online!=0  and not (date(items.o_date)<=   (select ifnull(max(date_),date(items.o_date,'-1 day')) from closing_year)  and items.o_qty>0 )");
                nodeJS.this.e.v0("update currency set online=0 where online!=0");
                nodeJS.this.w.setVisibility(0);
                nodeJS.this.x.setVisibility(0);
                if (string2.equals("1")) {
                    nodeJS.this.e.Mc("send_type1", true);
                } else {
                    nodeJS.this.e.Mc("send_type1", false);
                }
                nodeJS.this.V("", "", "0", str, this.a[0].toString(), "confirm_server");
                String token = FirebaseInstanceId.getInstance().getToken();
                HashMap map = new HashMap();
                map.put("fcm", token);
                map.put(NotificationCompat.CATEGORY_STATUS, 1);
                map.put("fcm", token);
                map.put(NotificationCompat.CATEGORY_STATUS, 1);
            }
        }

        public C() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            nodeJS.this.runOnUiThread(new a(objArr));
        }
    }

    public class D implements AbstractC0963Uk.a {

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
                    String string = jSONObject.getString("un");
                    String string2 = jSONObject.getString("br_id");
                    String string3 = jSONObject.getString("cash_id");
                    Toast.makeText(nodeJS.this, jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE), 1).show();
                    String token = FirebaseInstanceId.getInstance().getToken();
                    nodeJS.this.e.v0("update branches set param1='" + string + "',param2='" + token + "' where id='" + string2 + "'");
                    nodeJS.this.e.Mc("online_type1", true);
                    nodeJS.this.e.v0("update customers set param1='" + string + "',param2='" + token + "' where id='" + string3 + "'");
                    nodeJS.this.e.Mc("online_type2", true);
                    nodeJS.this.J();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public D() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            nodeJS.this.runOnUiThread(new a(objArr));
        }
    }

    public class E implements AbstractC0963Uk.a {

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
                    Toast.makeText(nodeJS.this, jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE), 1).show();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public E() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            nodeJS.this.runOnUiThread(new a(objArr));
        }
    }

    public class F implements AbstractC0963Uk.a {

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
                    String string = jSONObject.getString("un");
                    String string2 = jSONObject.getString("p_un");
                    String string3 = jSONObject.getString("ref_no");
                    int i = jSONObject.getInt("acc_type");
                    int i2 = jSONObject.getInt("tr_type");
                    jSONObject.getString("c_br_id");
                    Toast.makeText(nodeJS.this, jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE), 1).show();
                    nodeJS.this.e.v0("update requests_out set status=-1 where ref_no='" + string3 + "' and _un='" + string + "' and _p_un='" + string2 + "' and acc_type='" + i + "' and tr_type='" + i2 + "'");
                    nodeJS.this.E.a("confirm_client_add_req", jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public F() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            nodeJS.this.runOnUiThread(new a(objArr));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$a, reason: case insensitive filesystem */
    public class C3085a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0311a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0311a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    nodeJS.this.e.v0("update items set online=0 where online!=0  and not (date(items.o_date)<=   (select ifnull(max(date_),date(items.o_date,'-1 day')) from closing_year)  and items.o_qty>0 )");
                    nodeJS nodejs = nodeJS.this;
                    Toast.makeText(nodejs, nodejs.getString(R.string.wait), 0).show();
                    nodeJS.this.Q();
                } catch (Exception e) {
                    e.printStackTrace();
                    nodeJS nodejs2 = nodeJS.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error1:");
                    sb.append((e.getMessage() == null || e.getMessage().length() <= 200) ? e.getMessage() : e.getMessage().substring(0, 200));
                    Toast.makeText(nodejs2, sb.toString(), 1).show();
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$a$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                nodeJS.this.e.v0("update customers set online=0 where online!=0");
                nodeJS nodejs = nodeJS.this;
                Toast.makeText(nodejs, nodejs.getString(R.string.wait), 0).show();
                nodeJS.this.R();
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$a$c */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                nodeJS.this.e.v0("update currency set online=0 where online!=0");
                nodeJS nodejs = nodeJS.this;
                Toast.makeText(nodejs, nodejs.getString(R.string.wait), 0).show();
                nodeJS.this.P();
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$a$d */
        public class d implements DialogInterface.OnClickListener {
            public d() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    nodeJS.this.S();
                } catch (Exception e) {
                    e.printStackTrace();
                    nodeJS nodejs = nodeJS.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error3:");
                    sb.append((e.getMessage() == null || e.getMessage().length() <= 200) ? e.getMessage() : e.getMessage().substring(0, 200));
                    Toast.makeText(nodejs, sb.toString(), 1).show();
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$a$e */
        public class e implements DialogInterface.OnClickListener {
            public e() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C3085a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.menu_customers) {
                SparseBooleanArray sparseBooleanArrayC = nodeJS.this.B.c();
                nodeJS nodejs = nodeJS.this;
                nodejs.D = sparseBooleanArrayC;
                AlertDialog.Builder builder = new AlertDialog.Builder(nodejs);
                builder.setMessage(nodeJS.this.getString(R.string.send_names));
                builder.setPositiveButton(nodeJS.this.getString(R.string.confirm_yes), new d());
                builder.setNegativeButton(nodeJS.this.getString(R.string.confirm_no), new e());
                builder.create().show();
                actionMode.finish();
                return false;
            }
            if (itemId != R.id.menu_send) {
                return false;
            }
            SparseBooleanArray sparseBooleanArrayC2 = nodeJS.this.B.c();
            nodeJS nodejs2 = nodeJS.this;
            nodejs2.D = sparseBooleanArrayC2;
            AlertDialog.Builder builder2 = new AlertDialog.Builder(nodejs2);
            builder2.setMessage(nodeJS.this.getString(R.string.send_items_name));
            builder2.setPositiveButton(nodeJS.this.getString(R.string.items), new DialogInterfaceOnClickListenerC0311a());
            builder2.setNegativeButton(nodeJS.this.getString(R.string.names), new b());
            builder2.setNeutralButton(nodeJS.this.getString(R.string.send_currency), new c());
            builder2.create().show();
            actionMode.finish();
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (nodeJS.this.e.ja("online_server", false)) {
                actionMode.getMenuInflater().inflate(R.menu.contextual_action_send, menu);
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            nodeJS.this.z.setBackgroundColor(Color.parseColor("#FFFFFF"));
            nodeJS.this.B.i.clear();
            nodeJS.this.B.e();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = nodeJS.this.z.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            nodeJS.this.B.g(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$b, reason: case insensitive filesystem */
    public class C3086b implements AbstractC0963Uk.a {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$b$a */
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
                    String string = jSONObject.getString("un");
                    String string2 = jSONObject.getString("p_un");
                    String string3 = jSONObject.getString("ref_no");
                    int i = jSONObject.getInt("acc_type");
                    int i2 = jSONObject.getInt("tr_type");
                    jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE);
                    nodeJS.this.e.v0("update requests_out set status=1 where status in(0,-1) and ref_no='" + string3 + "' and _un='" + string + "' and _p_un='" + string2 + "' and acc_type='" + i + "' and tr_type='" + i2 + "'");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public C3086b() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            nodeJS.this.runOnUiThread(new a(objArr));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$c, reason: case insensitive filesystem */
    public class C3087c implements AbstractC0963Uk.a {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$c$a */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            /* JADX WARN: Code duplicated, block: B:43:0x015a A[Catch: JSONException -> 0x019b, TRY_LEAVE, TryCatch #8 {JSONException -> 0x019b, blocks: (B:3:0x0012, B:4:0x0028, B:6:0x002e, B:41:0x00b0, B:43:0x015a, B:48:0x0186, B:53:0x019f, B:47:0x0183, B:40:0x00a5, B:54:0x01a8, B:44:0x0177), top: B:74:0x0012, inners: #2 }] */
            /* JADX WARN: Code duplicated, block: B:52:0x019d  */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
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
                Log.d("socket_data=", HTML.Attribute.START);
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
                                                            nodeJS.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i11 + "," + i12 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                            StringBuilder sb = new StringBuilder();
                                                            Z00 z00 = nodeJS.this.e;
                                                            StringBuilder sb2 = new StringBuilder();
                                                            sb2.append(i);
                                                            str2 = str2;
                                                            sb2.append(str2);
                                                            sb.append(z00.m8(sb2.toString()));
                                                            sb.append(":");
                                                            sb.append(string3);
                                                            Log.d("requests_cnt=", sb.toString());
                                                            if (nodeJS.this.e.m8(i + str2) > 0) {
                                                                jSONObjectOptJSONObject.remove("json");
                                                                String strIa = nodeJS.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                                String token = FirebaseInstanceId.getInstance().getToken();
                                                                try {
                                                                    jSONObjectOptJSONObject.put("un", strIa);
                                                                    jSONObjectOptJSONObject.put("fcm_token", token);
                                                                } catch (JSONException e3) {
                                                                    e3.printStackTrace();
                                                                }
                                                                nodeJS.this.E.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
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
                                                        nodeJS.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i13 + "," + i14 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                        StringBuilder sb3 = new StringBuilder();
                                                        Z00 z01 = nodeJS.this.e;
                                                        StringBuilder sb4 = new StringBuilder();
                                                        sb4.append(i);
                                                        str2 = str2;
                                                        sb4.append(str2);
                                                        sb3.append(z01.m8(sb4.toString()));
                                                        sb3.append(":");
                                                        sb3.append(string3);
                                                        Log.d("requests_cnt=", sb3.toString());
                                                        if (nodeJS.this.e.m8(i + str2) > 0) {
                                                            jSONObjectOptJSONObject.remove("json");
                                                            String strIa2 = nodeJS.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                            String token2 = FirebaseInstanceId.getInstance().getToken();
                                                            jSONObjectOptJSONObject.put("un", strIa2);
                                                            jSONObjectOptJSONObject.put("fcm_token", token2);
                                                            nodeJS.this.E.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
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
                                                    nodeJS.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i15 + "," + i16 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                    StringBuilder sb5 = new StringBuilder();
                                                    Z00 z02 = nodeJS.this.e;
                                                    StringBuilder sb6 = new StringBuilder();
                                                    sb6.append(i);
                                                    str2 = str2;
                                                    sb6.append(str2);
                                                    sb5.append(z02.m8(sb6.toString()));
                                                    sb5.append(":");
                                                    sb5.append(string3);
                                                    Log.d("requests_cnt=", sb5.toString());
                                                    if (nodeJS.this.e.m8(i + str2) > 0) {
                                                        jSONObjectOptJSONObject.remove("json");
                                                        String strIa3 = nodeJS.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                        String token3 = FirebaseInstanceId.getInstance().getToken();
                                                        jSONObjectOptJSONObject.put("un", strIa3);
                                                        jSONObjectOptJSONObject.put("fcm_token", token3);
                                                        nodeJS.this.E.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
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
                                                nodeJS.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i17 + "," + i18 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                                StringBuilder sb7 = new StringBuilder();
                                                Z00 z03 = nodeJS.this.e;
                                                StringBuilder sb8 = new StringBuilder();
                                                sb8.append(i);
                                                str2 = str2;
                                                sb8.append(str2);
                                                sb7.append(z03.m8(sb8.toString()));
                                                sb7.append(":");
                                                sb7.append(string3);
                                                Log.d("requests_cnt=", sb7.toString());
                                                if (nodeJS.this.e.m8(i + str2) > 0) {
                                                    jSONObjectOptJSONObject.remove("json");
                                                    String strIa4 = nodeJS.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                    String token4 = FirebaseInstanceId.getInstance().getToken();
                                                    jSONObjectOptJSONObject.put("un", strIa4);
                                                    jSONObjectOptJSONObject.put("fcm_token", token4);
                                                    nodeJS.this.E.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
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
                                            nodeJS.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i19 + "," + i110 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                            StringBuilder sb9 = new StringBuilder();
                                            Z00 z04 = nodeJS.this.e;
                                            StringBuilder sb10 = new StringBuilder();
                                            sb10.append(i);
                                            str2 = str2;
                                            sb10.append(str2);
                                            sb9.append(z04.m8(sb10.toString()));
                                            sb9.append(":");
                                            sb9.append(string3);
                                            Log.d("requests_cnt=", sb9.toString());
                                            if (nodeJS.this.e.m8(i + str2) > 0) {
                                                jSONObjectOptJSONObject.remove("json");
                                                String strIa5 = nodeJS.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                                String token5 = FirebaseInstanceId.getInstance().getToken();
                                                jSONObjectOptJSONObject.put("un", strIa5);
                                                jSONObjectOptJSONObject.put("fcm_token", token5);
                                                nodeJS.this.E.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
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
                                    nodeJS.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i111 + "," + i112 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                                    StringBuilder sb11 = new StringBuilder();
                                    Z00 z05 = nodeJS.this.e;
                                    StringBuilder sb12 = new StringBuilder();
                                    sb12.append(i);
                                    str2 = str2;
                                    sb12.append(str2);
                                    sb11.append(z05.m8(sb12.toString()));
                                    sb11.append(":");
                                    sb11.append(string3);
                                    Log.d("requests_cnt=", sb11.toString());
                                    if (nodeJS.this.e.m8(i + str2) > 0) {
                                        jSONObjectOptJSONObject.remove("json");
                                        String strIa6 = nodeJS.this.e.ia("PREF_ACCOUNT_NAME", "0");
                                        String token6 = FirebaseInstanceId.getInstance().getToken();
                                        jSONObjectOptJSONObject.put("un", strIa6);
                                        jSONObjectOptJSONObject.put("fcm_token", token6);
                                        nodeJS.this.E.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
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
                        nodeJS.this.e.v0("insert into requests(id,f_user_id,t_user_id,f_br_id,t_br_id,status,tr_type,date_,ref_no,json_) values(" + i + "," + i2 + "," + i7 + "," + i8 + "," + i113 + "," + i114 + "," + i9 + ",'" + string + "','" + string3 + "','" + string2 + "')");
                        StringBuilder sb13 = new StringBuilder();
                        Z00 z06 = nodeJS.this.e;
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append(i);
                        str2 = str2;
                        sb14.append(str2);
                        sb13.append(z06.m8(sb14.toString()));
                        sb13.append(":");
                        sb13.append(string3);
                        Log.d("requests_cnt=", sb13.toString());
                        if (nodeJS.this.e.m8(i + str2) > 0) {
                            jSONObjectOptJSONObject.remove("json");
                            String strIa7 = nodeJS.this.e.ia("PREF_ACCOUNT_NAME", "0");
                            String token7 = FirebaseInstanceId.getInstance().getToken();
                            jSONObjectOptJSONObject.put("un", strIa7);
                            jSONObjectOptJSONObject.put("fcm_token", token7);
                            nodeJS.this.E.a("confirm_fetch_client_req", jSONObjectOptJSONObject);
                        }
                        i10++;
                        str = str9;
                        jSONArray = jSONArray8;
                    }
                    jSONArray.length();
                    nodeJS.this.L();
                } catch (JSONException e12) {
                    e12.printStackTrace();
                }
            }
        }

        public C3087c() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            nodeJS.this.runOnUiThread(new a(objArr));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$d, reason: case insensitive filesystem */
    public class C3088d implements AbstractC0963Uk.a {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$d$a */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$d$a$a, reason: collision with other inner class name */
            public class DialogInterfaceOnClickListenerC0312a implements DialogInterface.OnClickListener {
                public DialogInterfaceOnClickListenerC0312a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }

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
                    String string = jSONObject.getString("un");
                    jSONObject.getInt("acc_type");
                    String string2 = jSONObject.getString("p_un");
                    String string3 = jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE);
                    AlertDialog.Builder builder = new AlertDialog.Builder(nodeJS.this);
                    builder.setMessage(string3);
                    builder.setTitle(string + ":" + string2);
                    builder.setPositiveButton(nodeJS.this.getString(R.string.btn_close), new DialogInterfaceOnClickListenerC0312a());
                    builder.create().show();
                } catch (JSONException unused) {
                }
            }
        }

        public C3088d() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            nodeJS.this.runOnUiThread(new a(objArr));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3089e implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnClickListenerC3089e(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nodeJS nodejs = nodeJS.this;
            nodejs.e.Md(nodejs);
            nodeJS nodejs2 = nodeJS.this;
            nodejs2.e.T(nodejs2, nodejs2.R, this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.fcm.nodeJS$f, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3090f implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnClickListenerC3090f(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nodeJS nodejs = nodeJS.this;
            nodejs.e.Md(nodejs);
            nodeJS nodejs2 = nodeJS.this;
            nodejs2.e.T(nodejs2, nodejs2.S, this.a);
        }
    }

    public class g implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public g(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
        }
    }

    public class h implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public h(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class k implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ AlertDialog d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public k(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, AlertDialog alertDialog, String str, String str2, String str3) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = autoCompleteTextView2;
            this.d = alertDialog;
            this.e = str;
            this.f = str2;
            this.g = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            if (!this.a.getText().toString().toLowerCase().trim().endsWith("@gmail.com")) {
                zA = false;
            }
            if (zA && nodeJS.this.e.d6("branches", this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                nodeJS.this.O = this.b.getText().toString();
                nodeJS nodejs = nodeJS.this;
                nodejs.I(nodejs.getString(R.string.validation_add_branch), nodeJS.this.getString(R.string.validation_add_branch) + "#" + nodeJS.this.O, "branches", nodeJS.this.O, this.d.getContext());
                z = false;
            } else {
                z = true;
            }
            if (z || nodeJS.this.N) {
                if (zA && nodeJS.this.e.d6("customers", this.c.getText().toString()).getCount() == 0 && this.c.getText().toString().trim().length() > 0) {
                    nodeJS.this.O = this.c.getText().toString();
                    nodeJS nodejs2 = nodeJS.this;
                    nodejs2.I(nodejs2.getString(R.string.validation_add_cus), nodeJS.this.getString(R.string.validation_add_cus) + "#" + nodeJS.this.O, "customers", nodeJS.this.O, this.d.getContext());
                    z = false;
                }
                if ((z || nodeJS.this.N) && zA) {
                    nodeJS nodejs3 = nodeJS.this;
                    Toast.makeText(nodejs3, nodejs3.getString(R.string.wait), 0).show();
                    String token = FirebaseInstanceId.getInstance().getToken();
                    nodeJS.this.e.v0("update branches set param1='" + this.e + "',param2='" + token + "' where name='" + this.b.getText().toString() + "' ");
                    nodeJS.this.e.Mc("online_type1", true);
                    nodeJS.this.e.v0("update customers set param1='" + this.e + "',param2='" + token + "' where name='" + this.c.getText().toString() + "' ");
                    nodeJS.this.e.Mc("online_type2", true);
                    if (this.f != "") {
                        try {
                            JSONObject jSONObject = new JSONObject(this.f);
                            String strD2 = nodeJS.this.e.D2(this.b.getText().toString());
                            String strP4 = nodeJS.this.e.p4(this.c.getText().toString());
                            jSONObject.put("fcm_token", FirebaseInstanceId.getInstance().getToken());
                            jSONObject.put("c_br_id", strD2);
                            jSONObject.put("c_cash_id", strP4);
                            if (this.g == "confirm_server") {
                                nodeJS.this.E.a("update_server", jSONObject);
                            } else {
                                jSONObject.put("p_un", this.e);
                                nodeJS.this.E.a("update_client", jSONObject);
                            }
                            nodeJS.this.J();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    this.d.dismiss();
                }
            }
        }
    }

    public class l extends Handler {
        public l() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Handler c;

        public m(String str, String str2, Handler handler) {
            this.a = str;
            this.b = str2;
            this.c = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String str = this.a;
            if (str == "item_type" || str == "branches") {
                nodeJS.this.e.v0("insert into " + this.a + "  (name )  values( '" + this.b + "'  )");
            } else if (str == "customers") {
                nodeJS.this.e.v0("insert into " + this.a + "  (name,acc_p_id )  values( '" + this.b + "' ,121 )");
            }
            nodeJS.this.N = true;
            Handler handler = this.c;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public n(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            nodeJS.this.N = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class o implements Runnable {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }

        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strX4 = nodeJS.this.e.X4("select group_concat(id||':'||ifnull(err,''))  as _id from requests where status=-2 order by id desc ");
            if (strX4 == null || strX4.equals("")) {
                if (nodeJS.T == 0) {
                    nodeJS nodejs = nodeJS.this;
                    Toast.makeText(nodejs, nodejs.getString(R.string.no_data_found), 0).show();
                    return;
                }
                return;
            }
            nodeJS.this.e.v0("update requests set status=0 where status=-2 ");
            AlertDialog.Builder builder = new AlertDialog.Builder(nodeJS.this);
            builder.setMessage(strX4);
            builder.setPositiveButton(nodeJS.this.getString(R.string.btn_close), new a());
            builder.create().show();
        }
    }

    public class p extends Handler {
        public p() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("mProgress=f=", message.obj + "");
            message.obj.toString().equals("1");
            nodeJS.this.U(false);
        }
    }

    public class q implements DialogInterface.OnClickListener {
        public q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ AutoCompleteTextView c;

        public r(String str, EditText editText, AutoCompleteTextView autoCompleteTextView) {
            this.a = str;
            this.b = editText;
            this.c = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nodeJS nodejs = nodeJS.this;
            nodeJS nodejs2 = nodeJS.this;
            nodejs.R = new ArrayAdapter(nodejs2, android.R.layout.simple_spinner_dropdown_item, nodejs2.e.w2("1", this.a, this.b.getText().toString()));
            nodeJS nodejs3 = nodeJS.this;
            nodejs3.e.Md(nodejs3);
            nodeJS nodejs4 = nodeJS.this;
            nodejs4.e.T(nodejs4, nodejs4.R, this.c);
        }
    }

    public class s implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ AutoCompleteTextView c;

        public s(String str, EditText editText, AutoCompleteTextView autoCompleteTextView) {
            this.a = str;
            this.b = editText;
            this.c = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nodeJS nodejs = nodeJS.this;
            nodejs.e.Md(nodejs);
            nodeJS nodejs2 = nodeJS.this;
            nodeJS nodejs3 = nodeJS.this;
            nodejs2.S = new ArrayAdapter(nodejs3, android.R.layout.simple_spinner_dropdown_item, nodejs3.e.w2("2", this.a, this.b.getText().toString()));
            nodeJS nodejs4 = nodeJS.this;
            nodejs4.e.T(nodejs4, nodejs4.S, this.c);
        }
    }

    public class t implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public t(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
        }
    }

    public class u implements AbstractC0963Uk.a {
        public u() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Log.d("socket:", "connected");
            nodeJS.this.w();
        }
    }

    public class v implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public v(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class x implements DialogInterface.OnClickListener {
        public x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class y implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;

        public y(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, AlertDialog alertDialog) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = autoCompleteTextView2;
            this.d = str;
            this.e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            if (this.a.getText().toString() == this.d) {
                zA = false;
            }
            if (!this.a.getText().toString().trim().toLowerCase().endsWith("@gmail.com")) {
                zA = false;
            }
            if (zA && nodeJS.this.e.d6("branches", this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                nodeJS.this.O = this.b.getText().toString();
                nodeJS nodejs = nodeJS.this;
                nodejs.I(nodejs.getString(R.string.validation_add_branch), nodeJS.this.getString(R.string.validation_add_branch) + "#" + nodeJS.this.O, "branches", nodeJS.this.O, this.e.getContext());
                z = false;
            } else {
                z = true;
            }
            if (z || nodeJS.this.N) {
                if (zA && nodeJS.this.e.d6("customers", this.c.getText().toString()).getCount() == 0 && this.c.getText().toString().trim().length() > 0) {
                    nodeJS.this.O = this.c.getText().toString();
                    nodeJS nodejs2 = nodeJS.this;
                    nodejs2.I(nodejs2.getString(R.string.validation_add_cus), nodeJS.this.getString(R.string.validation_add_cus) + "#" + nodeJS.this.O, "customers", nodeJS.this.O, this.e.getContext());
                    z = false;
                }
                if ((z || nodeJS.this.N) && zA) {
                    nodeJS nodejs3 = nodeJS.this;
                    Toast.makeText(nodejs3, nodejs3.getString(R.string.wait), 0).show();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("p_un", this.d);
                        jSONObject.put("un", this.a.getText().toString().trim());
                        String strD2 = nodeJS.this.e.D2(this.b.getText().toString());
                        String strP4 = nodeJS.this.e.p4(this.c.getText().toString());
                        jSONObject.put("c_br_id", strD2);
                        jSONObject.put("c_cash_id", strP4);
                        jSONObject.put("fcm_token", FirebaseInstanceId.getInstance().getToken());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    new JSONObject();
                    nodeJS.this.E.a("add_client_user", jSONObject);
                    this.e.dismiss();
                }
            }
        }
    }

    public class z implements AbstractC0963Uk.a {
        public z() {
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            Log.d("socket:disconnected:", " Log.d(\"socket:disconnected:\",mSocket.id());");
            nodeJS.this.E();
        }
    }

    public nodeJS() {
        try {
            this.E = AbstractC0892Rr.a("https://bkp2.dyndns.org:7000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.F = new B();
        this.G = new C();
        this.H = new D();
        this.I = new E();
        this.J = new F();
        this.K = new C3086b();
        this.L = new C3087c();
        this.M = new C3088d();
        this.O = "";
        this.P = null;
        this.Q = new p();
    }

    private void T() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void E() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect_:");
        if (this.E == null) {
            str = "T";
        } else {
            str = this.E.z() + ":" + this.E.F();
        }
        sb.append(str);
        Log.d("socket:", sb.toString());
        VQ vq = this.E;
        if (vq != null) {
            vq.b();
            this.E.B();
            this.E = null;
        }
    }

    public void F() {
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.E.a("fetch_server_req", jSONObject);
            }
            try {
                this.e.Aa("-100", "0");
                this.y.b(this.e.N7());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void G() {
        String str;
        String str2;
        String str3;
        nodeJS nodejs = this;
        String strIa = nodejs.e.ia("PREF_ACCOUNT_NAME", "0");
        String token = FirebaseInstanceId.getInstance().getToken();
        new ArrayList();
        String str4 = "1";
        ArrayList arrayListU2 = nodejs.e.u2("1", strIa);
        int i2 = 0;
        while (true) {
            str = "un";
            str2 = "fetch_server_req";
            if (i2 >= arrayListU2.size()) {
                break;
            }
            String str5 = str4;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p_un", strIa);
                jSONObject.put("un", ((HashMap) arrayListU2.get(i2)).get("email"));
                jSONObject.put("fcm_token", token);
                jSONObject.put("acc_type", 1);
                jSONObject.put("br_id", ((HashMap) arrayListU2.get(i2)).get(HTML.Attribute.ID));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            nodejs.E.a("fetch_client_req", jSONObject);
            if (nodejs.e.e5("8").equals(str5)) {
                nodejs.E.a(str2, jSONObject);
            }
            i2++;
            str4 = str5;
        }
        String str6 = str4;
        ArrayList arrayListU3 = nodejs.e.u2("2", strIa);
        int i3 = 0;
        while (i3 < arrayListU3.size()) {
            String str7 = str6;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("p_un", strIa);
                jSONObject2.put(str, ((HashMap) arrayListU3.get(i3)).get("email"));
                jSONObject2.put("fcm_token", token);
                jSONObject2.put("acc_type", 2);
                jSONObject2.put("br_id", ((HashMap) arrayListU3.get(i3)).get(HTML.Attribute.ID));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String str8 = str;
            String str9 = strIa;
            nodejs.E.a("fetch_client_req", jSONObject2);
            if (nodejs.e.e5("8").equals(str7)) {
                VQ vq = nodejs.E;
                Object[] objArr = {jSONObject2};
                str3 = str2;
                vq.a(str3, objArr);
            } else {
                str3 = str2;
            }
            i3++;
            nodejs = this;
            str2 = str3;
            str = str8;
            str6 = str7;
            strIa = str9;
        }
    }

    public void H() {
        C0870Qv c0870Qv = new C0870Qv(this, R.layout.group_item, this.C);
        this.B = c0870Qv;
        c0870Qv.i.clear();
        this.B.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.B);
    }

    public boolean I(String str, String str2, String str3, String str4, Context context) {
        l lVar = new l();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(R.string.confirm_yes), new m(str3, str4, lVar));
        builder.setNegativeButton(getString(R.string.confirm_no), new n(lVar));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.N;
    }

    public void J() {
        Cursor cursorS2 = this.e.s2();
        cursorS2.getCount();
        this.f = 0.0d;
        this.C.clear();
        cursorS2.moveToFirst();
        while (!cursorS2.isAfterLast()) {
            this.C.add(new C4143vg(cursorS2.getString(cursorS2.getColumnIndex("_id")), cursorS2.getString(cursorS2.getColumnIndex("name")), cursorS2.getString(cursorS2.getColumnIndex("param1")), 0.0d, 0, 0));
            cursorS2.moveToNext();
        }
        cursorS2.close();
        H();
    }

    public void K() {
        if (!AbstractC4158vt.a(this)) {
            Toast.makeText(this, getString(R.string.no_internet), 1).show();
            return;
        }
        VQ vq = this.E;
        if (vq == null) {
            try {
                Log.d("socket:", "init_connect");
                AbstractC0892Rr.a aVar = new AbstractC0892Rr.a();
                aVar.B = true;
                aVar.s = false;
                aVar.m = new String[]{"websocket", "polling"};
                aVar.A = 60000L;
                this.E = AbstractC0892Rr.a("https://bkp2.dyndns.org:7000");
                if (!this.e.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
                    this.E.y();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else if (!vq.z()) {
            this.E.y();
            Log.d("socket:", "status:" + this.E.F() + ":" + this.E.z());
        }
        this.E.e("connect", new u());
        this.E.e("disconnect", new z());
        this.E.e("connect_error", new A());
        this.E.e("confirm_client", this.F);
        this.E.e("confirm_server", this.G);
        this.E.e("update_br_cash", this.H);
        this.E.e("confirm_fetch_client_req", this.L);
        this.E.e("notification", this.M);
        this.E.e("confirm_client_add_req", this.J);
        this.E.e("confirm_server_push", this.I);
        this.E.e("confirm_client_update_req", this.K);
    }

    public void L() throws Throwable {
        int iVa;
        int iVa2;
        int iYa;
        int iZa;
        int iWa;
        int iVa3;
        int iVa4;
        int iXa;
        int i2 = 0;
        try {
            iVa = this.e.va("1", "0");
            try {
                iVa += this.e.va("2", "0");
                if (iVa > 0) {
                    Toast.makeText(this, getString(R.string.confirm_client_req) + ":" + iVa, 0).show();
                }
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e = e2;
            iVa = 0;
        }
        T += iVa;
        try {
            iVa2 = this.e.va("3", "0");
            if (iVa2 > 0) {
                try {
                    Toast.makeText(this, getString(R.string.confirm_server_req) + ":" + iVa2, 0).show();
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                }
            }
        } catch (IOException e4) {
            e = e4;
            iVa2 = 0;
        }
        T += iVa2;
        try {
            iYa = this.e.ya("-200", "0");
            if (iYa > 0) {
                try {
                    Toast.makeText(this, getString(R.string.confirm_server_items) + ":" + iYa, 0).show();
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                }
            }
        } catch (IOException e6) {
            e = e6;
            iYa = 0;
        }
        T += iYa;
        try {
            iZa = this.e.za("-201", "0");
            if (iZa > 0) {
                try {
                    Toast.makeText(this, getString(R.string.confirm_server_names) + ":" + iZa, 0).show();
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                } catch (Exception e8) {
                    e = e8;
                    e.printStackTrace();
                }
            }
        } catch (IOException e9) {
            e = e9;
            iZa = 0;
        } catch (Exception e10) {
            e = e10;
            iZa = 0;
        }
        T += iZa;
        try {
            iWa = this.e.wa("-202", "0");
            if (iWa > 0) {
                try {
                    Toast.makeText(this, getString(R.string.confirm_server_curr) + ":" + iWa, 0).show();
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                } catch (Exception e12) {
                    e = e12;
                    e.printStackTrace();
                }
            }
        } catch (IOException e13) {
            e = e13;
            iWa = 0;
        } catch (Exception e14) {
            e = e14;
            iWa = 0;
        }
        T += iWa;
        try {
            iVa3 = this.e.va("4", "0");
            if (iVa3 > 0) {
                try {
                    Toast.makeText(this, getString(R.string.confirm_server_req) + ":" + iVa3, 0).show();
                } catch (IOException e15) {
                    e = e15;
                    e.printStackTrace();
                }
            }
        } catch (IOException e16) {
            e = e16;
            iVa3 = 0;
        }
        T += iVa3;
        try {
            iVa4 = this.e.va("7", "0");
            if (iVa4 > 0) {
                try {
                    Toast.makeText(this, getString(R.string.confirm_server_req) + ":" + iVa4, 0).show();
                } catch (IOException e17) {
                    e = e17;
                    e.printStackTrace();
                }
            }
        } catch (IOException e18) {
            e = e18;
            iVa4 = 0;
        }
        T += iVa4;
        try {
            iXa = this.e.xa("5", "0");
            try {
                iXa += this.e.xa("6", "0");
                if (iXa > 0) {
                    Toast.makeText(this, getString(R.string.confirm_client_req) + ":" + iXa, 0).show();
                }
            } catch (IOException e19) {
                e = e19;
                i2 = iXa;
                e.printStackTrace();
                iXa = i2;
            }
        } catch (IOException e20) {
            e = e20;
        }
        T += iXa;
    }

    public void M() {
        try {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            if (strIa == "0") {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer6, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.account_name);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.account_parent);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_cus_type);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.cash_name);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_cash_type);
            this.e.ad(this, editText);
            this.e.cd(this, autoCompleteTextView);
            this.e.cd(this, autoCompleteTextView2);
            String token = FirebaseInstanceId.getInstance().getToken();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.v2("1", token));
            this.R = arrayAdapter;
            autoCompleteTextView.setAdapter(arrayAdapter);
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.v2("2", token));
            this.S = arrayAdapter2;
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            imageView.setOnClickListener(new r(token, editText, autoCompleteTextView));
            imageView2.setOnClickListener(new s(token, editText, autoCompleteTextView2));
            autoCompleteTextView.setOnItemClickListener(new t(autoCompleteTextView));
            autoCompleteTextView2.setOnItemClickListener(new v(autoCompleteTextView2));
            editText.requestFocus();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new w());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new x());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.br_main_email) + strIa);
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new y(editText, autoCompleteTextView, autoCompleteTextView2, strIa, alertDialogCreate));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void N() throws Throwable {
        IOException iOException;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i2;
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
        int i3;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        ArrayList arrayList;
        String str34;
        String str35;
        String str36;
        ArrayList arrayList2;
        int i4;
        ArrayList arrayList3;
        String str37;
        String str38;
        String str39;
        nodeJS nodejs;
        String str40;
        nodeJS nodejs2 = this;
        String str41 = "7";
        String str42 = "4";
        String str43 = "add_server_req";
        String str44 = "req_m=";
        String str45 = "3";
        String str46 = "2";
        String str47 = "";
        String str48 = "1";
        try {
            R();
            Q();
            P();
            O();
            String strIa = nodejs2.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            nodejs2.e.ua("1", strIa);
            new ArrayList();
            ArrayList arrayListI8 = nodejs2.e.i8("1", strIa, "1");
            Log.d("req_sls_out=", arrayListI8.size() + "");
            int size = arrayListI8.size();
            int i5 = 0;
            while (true) {
                str = str41;
                str2 = str42;
                str3 = str43;
                str4 = str44;
                str5 = "json_";
                str6 = str45;
                i2 = size;
                str7 = "ref";
                str8 = str47;
                str9 = "ref_no";
                str10 = str48;
                str11 = strIa;
                str12 = "c_br_id";
                str13 = str46;
                str14 = "add_client_req";
                str15 = "p_un";
                str16 = "_un";
                str17 = "action_type";
                str18 = "un";
                str19 = "fcm_token";
                str20 = "acc_type";
                str21 = token;
                str22 = "tr_type";
                if (i5 >= arrayListI8.size()) {
                    break;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("un", ((HashMap) arrayListI8.get(i5)).get("_un"));
                        jSONObject.put("p_un", ((HashMap) arrayListI8.get(i5)).get("_p_un"));
                        jSONObject.put("c_br_id", ((HashMap) arrayListI8.get(i5)).get("f_br_id"));
                        jSONObject.put("tr_type", ((HashMap) arrayListI8.get(i5)).get("tr_type"));
                        jSONObject.put("acc_type", ((HashMap) arrayListI8.get(i5)).get("acc_type"));
                        jSONObject.put("ref_no", ((HashMap) arrayListI8.get(i5)).get("ref"));
                        jSONObject.put("json", ((HashMap) arrayListI8.get(i5)).get("json_"));
                        str40 = str21;
                        try {
                            jSONObject.put(str19, str40);
                            jSONObject.put(str17, 1);
                            nodejs = this;
                            try {
                                try {
                                    try {
                                        nodejs.E.a(str14, jSONObject);
                                    } catch (IOException e) {
                                        e = e;
                                        iOException = e;
                                        iOException.printStackTrace();
                                        return;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                }
                            } catch (JSONException e3) {
                                e = e3;
                                e.printStackTrace();
                            }
                        } catch (JSONException e4) {
                            e = e4;
                            nodejs = this;
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        nodejs = this;
                        str40 = str21;
                    }
                    i5++;
                    token = str40;
                    nodejs2 = nodejs;
                    str41 = str;
                    str42 = str2;
                    str43 = str3;
                    str44 = str4;
                    str45 = str6;
                    size = i2;
                    str47 = str8;
                    str48 = str10;
                    strIa = str11;
                    str46 = str13;
                } catch (IOException e6) {
                    e = e6;
                    nodejs = this;
                }
            }
            try {
                String str49 = "json";
                this.e.ua(str13, str11);
                try {
                    ArrayList arrayListI9 = this.e.i8(str13, str11, str10);
                    Log.d("req_pur_out=", arrayListI9.size() + str8);
                    int size2 = i2 + arrayListI9.size();
                    int i6 = 0;
                    while (i6 < arrayListI9.size()) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            i4 = size2;
                            try {
                                jSONObject2.put("un", ((HashMap) arrayListI9.get(i6)).get("_un"));
                                jSONObject2.put("p_un", ((HashMap) arrayListI9.get(i6)).get("_p_un"));
                                jSONObject2.put("c_br_id", ((HashMap) arrayListI9.get(i6)).get("f_br_id"));
                                jSONObject2.put("tr_type", ((HashMap) arrayListI9.get(i6)).get("tr_type"));
                                jSONObject2.put("acc_type", ((HashMap) arrayListI9.get(i6)).get("acc_type"));
                                jSONObject2.put(str9, ((HashMap) arrayListI9.get(i6)).get("ref"));
                                Object obj = ((HashMap) arrayListI9.get(i6)).get(str5);
                                arrayList3 = arrayListI9;
                                String str50 = str49;
                                try {
                                    jSONObject2.put(str50, obj);
                                    str49 = str50;
                                    String str51 = str19;
                                    String str52 = str21;
                                    try {
                                        jSONObject2.put(str51, str52);
                                        str21 = str52;
                                        str19 = str51;
                                        String str53 = str17;
                                        try {
                                            jSONObject2.put(str53, 1);
                                            str17 = str53;
                                            try {
                                                try {
                                                    VQ vq = this.E;
                                                    str37 = str5;
                                                    str38 = str9;
                                                    try {
                                                        Object[] objArr = new Object[1];
                                                        try {
                                                            objArr[0] = jSONObject2;
                                                            str39 = str14;
                                                            try {
                                                                vq.a(str39, objArr);
                                                            } catch (JSONException e7) {
                                                                e = e7;
                                                                e.printStackTrace();
                                                            }
                                                        } catch (JSONException e8) {
                                                            e = e8;
                                                            str39 = str14;
                                                            e.printStackTrace();
                                                            i6++;
                                                            str14 = str39;
                                                            arrayListI9 = arrayList3;
                                                            size2 = i4;
                                                            str5 = str37;
                                                            str9 = str38;
                                                        }
                                                    } catch (JSONException e9) {
                                                        e = e9;
                                                    }
                                                } catch (JSONException e10) {
                                                    e = e10;
                                                    str37 = str5;
                                                    str38 = str9;
                                                    str39 = str14;
                                                    e.printStackTrace();
                                                    i6++;
                                                    str14 = str39;
                                                    arrayListI9 = arrayList3;
                                                    size2 = i4;
                                                    str5 = str37;
                                                    str9 = str38;
                                                }
                                                i6++;
                                                str14 = str39;
                                                arrayListI9 = arrayList3;
                                                size2 = i4;
                                                str5 = str37;
                                                str9 = str38;
                                            } catch (IOException e11) {
                                                e = e11;
                                                iOException = e;
                                                iOException.printStackTrace();
                                                return;
                                            }
                                        } catch (JSONException e12) {
                                            e = e12;
                                            str17 = str53;
                                        }
                                    } catch (JSONException e13) {
                                        e = e13;
                                        str21 = str52;
                                        str19 = str51;
                                        str37 = str5;
                                        str38 = str9;
                                        str39 = str14;
                                        e.printStackTrace();
                                        i6++;
                                        str14 = str39;
                                        arrayListI9 = arrayList3;
                                        size2 = i4;
                                        str5 = str37;
                                        str9 = str38;
                                    }
                                } catch (JSONException e14) {
                                    e = e14;
                                    str49 = str50;
                                }
                            } catch (JSONException e15) {
                                e = e15;
                                arrayList3 = arrayListI9;
                                str37 = str5;
                                str38 = str9;
                                str39 = str14;
                                e.printStackTrace();
                                i6++;
                                str14 = str39;
                                arrayListI9 = arrayList3;
                                size2 = i4;
                                str5 = str37;
                                str9 = str38;
                            }
                        } catch (JSONException e16) {
                            e = e16;
                            i4 = size2;
                        }
                    }
                    int i7 = size2;
                    String str54 = str5;
                    String str55 = str9;
                    String str56 = str14;
                    if (i7 > 0) {
                        Toast.makeText(this, getString(R.string.confirm_bills_out), 0).show();
                    }
                    this.e.sa("-3", str11);
                    new ArrayList();
                    String str57 = str10;
                    ArrayList arrayListI10 = this.e.i8("5", str11, str57);
                    int size3 = arrayListI10.size();
                    int i8 = 0;
                    while (i8 < arrayListI10.size()) {
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            str35 = str57;
                            try {
                                jSONObject3.put("un", ((HashMap) arrayListI10.get(i8)).get("_un"));
                                jSONObject3.put("p_un", ((HashMap) arrayListI10.get(i8)).get("_p_un"));
                                jSONObject3.put("c_br_id", ((HashMap) arrayListI10.get(i8)).get("f_br_id"));
                                jSONObject3.put("tr_type", ((HashMap) arrayListI10.get(i8)).get("tr_type"));
                                jSONObject3.put("acc_type", ((HashMap) arrayListI10.get(i8)).get("acc_type"));
                                Object obj2 = ((HashMap) arrayListI10.get(i8)).get(str7);
                                str7 = str7;
                                String str58 = str55;
                                try {
                                    jSONObject3.put(str58, obj2);
                                    HashMap map = (HashMap) arrayListI10.get(i8);
                                    arrayList2 = arrayListI10;
                                    String str59 = str54;
                                    try {
                                        Object obj3 = map.get(str59);
                                        str54 = str59;
                                        String str60 = str49;
                                        try {
                                            jSONObject3.put(str60, obj3);
                                            str49 = str60;
                                            String str61 = str19;
                                            String str62 = str21;
                                            try {
                                                jSONObject3.put(str61, str62);
                                                str19 = str61;
                                                str21 = str62;
                                                String str63 = str17;
                                                try {
                                                    jSONObject3.put(str63, 1);
                                                    str17 = str63;
                                                    try {
                                                        str36 = str58;
                                                        try {
                                                            this.E.a(str56, jSONObject3);
                                                        } catch (JSONException e17) {
                                                            e = e17;
                                                            e.printStackTrace();
                                                        }
                                                    } catch (JSONException e18) {
                                                        e = e18;
                                                        str36 = str58;
                                                    }
                                                } catch (JSONException e19) {
                                                    e = e19;
                                                    str36 = str58;
                                                    str17 = str63;
                                                }
                                            } catch (JSONException e20) {
                                                e = e20;
                                                str36 = str58;
                                                str19 = str61;
                                                str21 = str62;
                                            }
                                        } catch (JSONException e21) {
                                            e = e21;
                                            str36 = str58;
                                            str49 = str60;
                                        }
                                    } catch (JSONException e22) {
                                        e = e22;
                                        str36 = str58;
                                        str54 = str59;
                                    }
                                } catch (JSONException e23) {
                                    e = e23;
                                    str36 = str58;
                                    arrayList2 = arrayListI10;
                                    e.printStackTrace();
                                    i8++;
                                    str7 = str7;
                                    str57 = str35;
                                    arrayListI10 = arrayList2;
                                    str55 = str36;
                                }
                            } catch (JSONException e24) {
                                e = e24;
                                str36 = str55;
                                arrayList2 = arrayListI10;
                                e.printStackTrace();
                                i8++;
                                str7 = str7;
                                str57 = str35;
                                arrayListI10 = arrayList2;
                                str55 = str36;
                            }
                        } catch (JSONException e25) {
                            e = e25;
                            str35 = str57;
                        }
                        i8++;
                        str7 = str7;
                        str57 = str35;
                        arrayListI10 = arrayList2;
                        str55 = str36;
                    }
                    String str64 = str7;
                    String str65 = str57;
                    String str66 = str55;
                    String str67 = str11;
                    ArrayList arrayListI11 = this.e.i8("6", str67, str65);
                    int size4 = size3 + arrayListI11.size();
                    int i9 = 0;
                    while (i9 < arrayListI11.size()) {
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            str34 = str67;
                            try {
                                jSONObject4.put("un", ((HashMap) arrayListI11.get(i9)).get("_un"));
                                jSONObject4.put("p_un", ((HashMap) arrayListI11.get(i9)).get("_p_un"));
                                jSONObject4.put("c_br_id", ((HashMap) arrayListI11.get(i9)).get("f_br_id"));
                                jSONObject4.put("tr_type", ((HashMap) arrayListI11.get(i9)).get("tr_type"));
                                jSONObject4.put(str20, ((HashMap) arrayListI11.get(i9)).get(str20));
                                str33 = str20;
                                String str68 = str64;
                                try {
                                    Object obj4 = ((HashMap) arrayListI11.get(i9)).get(str68);
                                    str64 = str68;
                                    String str69 = str66;
                                    try {
                                        jSONObject4.put(str69, obj4);
                                        HashMap map2 = (HashMap) arrayListI11.get(i9);
                                        arrayList = arrayListI11;
                                        String str70 = str54;
                                        try {
                                            Object obj5 = map2.get(str70);
                                            str54 = str70;
                                            String str71 = str49;
                                            try {
                                                jSONObject4.put(str71, obj5);
                                                str49 = str71;
                                                String str72 = str19;
                                                String str73 = str21;
                                                try {
                                                    jSONObject4.put(str72, str73);
                                                    str19 = str72;
                                                    str21 = str73;
                                                    String str74 = str17;
                                                    try {
                                                        jSONObject4.put(str74, 1);
                                                        str17 = str74;
                                                        try {
                                                            str66 = str69;
                                                            try {
                                                                this.E.a(str56, jSONObject4);
                                                            } catch (JSONException e26) {
                                                                e = e26;
                                                                e.printStackTrace();
                                                            }
                                                        } catch (JSONException e27) {
                                                            e = e27;
                                                            str66 = str69;
                                                        }
                                                    } catch (JSONException e28) {
                                                        e = e28;
                                                        str66 = str69;
                                                        str17 = str74;
                                                    }
                                                } catch (JSONException e29) {
                                                    e = e29;
                                                    str66 = str69;
                                                    str19 = str72;
                                                    str21 = str73;
                                                }
                                            } catch (JSONException e30) {
                                                e = e30;
                                                str66 = str69;
                                                str49 = str71;
                                            }
                                        } catch (JSONException e31) {
                                            e = e31;
                                            str66 = str69;
                                            str54 = str70;
                                        }
                                    } catch (JSONException e32) {
                                        e = e32;
                                        str66 = str69;
                                        arrayList = arrayListI11;
                                        e.printStackTrace();
                                        i9++;
                                        str20 = str33;
                                        str67 = str34;
                                        arrayListI11 = arrayList;
                                    }
                                } catch (JSONException e33) {
                                    e = e33;
                                    str64 = str68;
                                }
                            } catch (JSONException e34) {
                                e = e34;
                                str33 = str20;
                            }
                        } catch (JSONException e35) {
                            e = e35;
                            str33 = str20;
                            arrayList = arrayListI11;
                            str34 = str67;
                        }
                        i9++;
                        str20 = str33;
                        str67 = str34;
                        arrayListI11 = arrayList;
                    }
                    String str75 = str20;
                    String str76 = str67;
                    if (size4 != 0) {
                        Toast.makeText(this, getString(R.string.confirm_doc_out), 0).show();
                    }
                    this.e.Ea(str6, str76);
                    new ArrayList();
                    ArrayList arrayListI12 = this.e.i8(str6, str76, str13);
                    int size5 = arrayListI12.size();
                    String str77 = str4;
                    Log.d(str77, arrayListI12.size() + str8);
                    String str78 = str56;
                    int i10 = 0;
                    while (i10 < arrayListI12.size()) {
                        JSONObject jSONObject5 = new JSONObject();
                        try {
                            str28 = str77;
                            try {
                                jSONObject5.put("un", ((HashMap) arrayListI12.get(i10)).get("_un"));
                                jSONObject5.put("p_un", ((HashMap) arrayListI12.get(i10)).get("_p_un"));
                                jSONObject5.put(str12, ((HashMap) arrayListI12.get(i10)).get("f_br_id"));
                                jSONObject5.put(str22, ((HashMap) arrayListI12.get(i10)).get(str22));
                                str29 = str22;
                                String str79 = str75;
                                try {
                                    jSONObject5.put(str79, ((HashMap) arrayListI12.get(i10)).get(str79));
                                    str75 = str79;
                                    String str80 = str64;
                                    try {
                                        Object obj6 = ((HashMap) arrayListI12.get(i10)).get(str80);
                                        str64 = str80;
                                        String str81 = str66;
                                        try {
                                            jSONObject5.put(str81, obj6);
                                            str31 = str81;
                                            String str82 = str54;
                                            try {
                                                Object obj7 = ((HashMap) arrayListI12.get(i10)).get(str82);
                                                str54 = str82;
                                                String str83 = str49;
                                                try {
                                                    jSONObject5.put(str83, obj7);
                                                    str49 = str83;
                                                    String str84 = str19;
                                                    String str85 = str21;
                                                    try {
                                                        jSONObject5.put(str84, str85);
                                                        str21 = str85;
                                                        str19 = str84;
                                                        String str86 = str17;
                                                        try {
                                                            jSONObject5.put(str86, 2);
                                                            VQ vq2 = this.E;
                                                            str32 = str12;
                                                            str17 = str86;
                                                            try {
                                                                Object[] objArr2 = new Object[1];
                                                                try {
                                                                    objArr2[0] = jSONObject5;
                                                                    str30 = str3;
                                                                    try {
                                                                        vq2.a(str30, objArr2);
                                                                    } catch (JSONException e36) {
                                                                        e = e36;
                                                                        e.printStackTrace();
                                                                    }
                                                                } catch (JSONException e37) {
                                                                    e = e37;
                                                                    str30 = str3;
                                                                    e.printStackTrace();
                                                                    i10++;
                                                                    str3 = str30;
                                                                    str22 = str29;
                                                                    str77 = str28;
                                                                    str12 = str32;
                                                                    str66 = str31;
                                                                }
                                                            } catch (JSONException e38) {
                                                                e = e38;
                                                            }
                                                        } catch (JSONException e39) {
                                                            e = e39;
                                                            str32 = str12;
                                                            str17 = str86;
                                                        }
                                                    } catch (JSONException e40) {
                                                        e = e40;
                                                        str32 = str12;
                                                        str21 = str85;
                                                        str19 = str84;
                                                    }
                                                } catch (JSONException e41) {
                                                    e = e41;
                                                    str32 = str12;
                                                    str49 = str83;
                                                }
                                            } catch (JSONException e42) {
                                                e = e42;
                                                str32 = str12;
                                                str54 = str82;
                                            }
                                        } catch (JSONException e43) {
                                            e = e43;
                                            str32 = str12;
                                            str31 = str81;
                                        }
                                    } catch (JSONException e44) {
                                        e = e44;
                                        str64 = str80;
                                        str30 = str3;
                                        str31 = str66;
                                        str32 = str12;
                                        e.printStackTrace();
                                        i10++;
                                        str3 = str30;
                                        str22 = str29;
                                        str77 = str28;
                                        str12 = str32;
                                        str66 = str31;
                                    }
                                } catch (JSONException e45) {
                                    e = e45;
                                    str75 = str79;
                                }
                            } catch (JSONException e46) {
                                e = e46;
                                str29 = str22;
                                str30 = str3;
                                str31 = str66;
                                str32 = str12;
                                e.printStackTrace();
                                i10++;
                                str3 = str30;
                                str22 = str29;
                                str77 = str28;
                                str12 = str32;
                                str66 = str31;
                            }
                        } catch (JSONException e47) {
                            e = e47;
                            str28 = str77;
                        }
                        i10++;
                        str3 = str30;
                        str22 = str29;
                        str77 = str28;
                        str12 = str32;
                        str66 = str31;
                    }
                    String str87 = str77;
                    String str88 = str22;
                    String str89 = str3;
                    String str90 = str66;
                    String str91 = str12;
                    if (arrayListI12.size() > 0) {
                        Toast.makeText(this, getString(R.string.confirm_move_out), 0).show();
                    }
                    this.e.Ea(str2, str76);
                    new ArrayList();
                    ArrayList arrayListI13 = this.e.i8(str2, str76, str13);
                    int size6 = arrayListI13.size();
                    Log.d(str87, arrayListI13.size() + str8);
                    int i11 = 0;
                    while (i11 < arrayListI13.size()) {
                        JSONObject jSONObject6 = new JSONObject();
                        try {
                            jSONObject6.put("un", ((HashMap) arrayListI13.get(i11)).get("_un"));
                            jSONObject6.put("p_un", ((HashMap) arrayListI13.get(i11)).get("_p_un"));
                            str27 = str91;
                            try {
                                jSONObject6.put(str27, ((HashMap) arrayListI13.get(i11)).get("f_br_id"));
                                String str92 = str88;
                                try {
                                    jSONObject6.put(str92, ((HashMap) arrayListI13.get(i11)).get(str92));
                                    i3 = size6;
                                    String str93 = str75;
                                    try {
                                        jSONObject6.put(str93, ((HashMap) arrayListI13.get(i11)).get(str93));
                                        str75 = str93;
                                        String str94 = str64;
                                        try {
                                            Object obj8 = ((HashMap) arrayListI13.get(i11)).get(str94);
                                            str64 = str94;
                                            String str95 = str90;
                                            try {
                                                jSONObject6.put(str95, obj8);
                                                str90 = str95;
                                                String str96 = str54;
                                                try {
                                                    Object obj9 = ((HashMap) arrayListI13.get(i11)).get(str96);
                                                    str54 = str96;
                                                    String str97 = str49;
                                                    try {
                                                        jSONObject6.put(str97, obj9);
                                                        str49 = str97;
                                                        String str98 = str19;
                                                        String str99 = str21;
                                                        try {
                                                            jSONObject6.put(str98, str99);
                                                            str19 = str98;
                                                            str21 = str99;
                                                            String str100 = str17;
                                                            try {
                                                                jSONObject6.put(str100, 2);
                                                                str17 = str100;
                                                                str88 = str92;
                                                                try {
                                                                    this.E.a(str89, jSONObject6);
                                                                } catch (JSONException e48) {
                                                                    e = e48;
                                                                    e.printStackTrace();
                                                                }
                                                            } catch (JSONException e49) {
                                                                e = e49;
                                                                str17 = str100;
                                                                str88 = str92;
                                                                e.printStackTrace();
                                                                i11++;
                                                                str91 = str27;
                                                                size6 = i3;
                                                            }
                                                        } catch (JSONException e50) {
                                                            e = e50;
                                                            str19 = str98;
                                                            str21 = str99;
                                                        }
                                                    } catch (JSONException e51) {
                                                        e = e51;
                                                        str49 = str97;
                                                    }
                                                } catch (JSONException e52) {
                                                    e = e52;
                                                    str54 = str96;
                                                }
                                            } catch (JSONException e53) {
                                                e = e53;
                                                str90 = str95;
                                            }
                                        } catch (JSONException e54) {
                                            e = e54;
                                            str64 = str94;
                                        }
                                    } catch (JSONException e55) {
                                        e = e55;
                                        str75 = str93;
                                    }
                                } catch (JSONException e56) {
                                    e = e56;
                                    i3 = size6;
                                }
                            } catch (JSONException e57) {
                                e = e57;
                                i3 = size6;
                            }
                        } catch (JSONException e58) {
                            e = e58;
                            i3 = size6;
                            str27 = str91;
                        }
                        i11++;
                        str91 = str27;
                        size6 = i3;
                    }
                    int i12 = size6;
                    String str101 = str91;
                    if (arrayListI13.size() > 0) {
                        Toast.makeText(this, getString(R.string.confirm_move_out), 0).show();
                    }
                    this.e.ta(str, str76);
                    new ArrayList();
                    ArrayList arrayListJ8 = this.e.j8(str, str76, str65);
                    int size7 = arrayListJ8.size();
                    int i13 = 0;
                    while (i13 < arrayListJ8.size()) {
                        JSONObject jSONObject7 = new JSONObject();
                        try {
                            jSONObject7.put(str18, ((HashMap) arrayListJ8.get(i13)).get(str16));
                            jSONObject7.put(str15, ((HashMap) arrayListJ8.get(i13)).get("_p_un"));
                            jSONObject7.put(str101, ((HashMap) arrayListJ8.get(i13)).get("f_br_id"));
                            str25 = str88;
                            try {
                                jSONObject7.put(str25, ((HashMap) arrayListJ8.get(i13)).get(str25));
                                str23 = str75;
                                try {
                                    jSONObject7.put(str23, ((HashMap) arrayListJ8.get(i13)).get(str23));
                                    str24 = str64;
                                    try {
                                        str16 = str16;
                                        String str102 = str90;
                                        try {
                                            jSONObject7.put(str102, ((HashMap) arrayListJ8.get(i13)).get(str24));
                                            str90 = str102;
                                            String str103 = str54;
                                            try {
                                                Object obj10 = ((HashMap) arrayListJ8.get(i13)).get(str103);
                                                str54 = str103;
                                                String str104 = str49;
                                                try {
                                                    jSONObject7.put(str104, obj10);
                                                    str49 = str104;
                                                    String str105 = str19;
                                                    str26 = str21;
                                                    try {
                                                        jSONObject7.put(str105, str26);
                                                        str19 = str105;
                                                        str15 = str15;
                                                        String str106 = str17;
                                                        try {
                                                            jSONObject7.put(str106, 1);
                                                            str17 = str106;
                                                            try {
                                                                VQ vq3 = this.E;
                                                                str18 = str18;
                                                                try {
                                                                    Object[] objArr3 = new Object[1];
                                                                    try {
                                                                        objArr3[0] = jSONObject7;
                                                                        str78 = str78;
                                                                        try {
                                                                            vq3.a(str78, objArr3);
                                                                        } catch (JSONException e59) {
                                                                            e = e59;
                                                                            e.printStackTrace();
                                                                        }
                                                                    } catch (JSONException e60) {
                                                                        e = e60;
                                                                        str78 = str78;
                                                                        e.printStackTrace();
                                                                        i13++;
                                                                        str78 = str78;
                                                                        str21 = str26;
                                                                        str88 = str25;
                                                                        str75 = str23;
                                                                        str64 = str24;
                                                                        str16 = str16;
                                                                        str15 = str15;
                                                                        str18 = str18;
                                                                    }
                                                                } catch (JSONException e61) {
                                                                    e = e61;
                                                                }
                                                            } catch (JSONException e62) {
                                                                e = e62;
                                                                str18 = str18;
                                                                str78 = str78;
                                                                e.printStackTrace();
                                                                i13++;
                                                                str78 = str78;
                                                                str21 = str26;
                                                                str88 = str25;
                                                                str75 = str23;
                                                                str64 = str24;
                                                                str16 = str16;
                                                                str15 = str15;
                                                                str18 = str18;
                                                            }
                                                        } catch (JSONException e63) {
                                                            e = e63;
                                                            str17 = str106;
                                                        }
                                                    } catch (JSONException e64) {
                                                        e = e64;
                                                        str19 = str105;
                                                        str15 = str15;
                                                    }
                                                } catch (JSONException e65) {
                                                    e = e65;
                                                    str49 = str104;
                                                    str15 = str15;
                                                    str18 = str18;
                                                    str78 = str78;
                                                    str26 = str21;
                                                    e.printStackTrace();
                                                    i13++;
                                                    str78 = str78;
                                                    str21 = str26;
                                                    str88 = str25;
                                                    str75 = str23;
                                                    str64 = str24;
                                                    str16 = str16;
                                                    str15 = str15;
                                                    str18 = str18;
                                                }
                                            } catch (JSONException e66) {
                                                e = e66;
                                                str54 = str103;
                                            }
                                        } catch (JSONException e67) {
                                            e = e67;
                                            str90 = str102;
                                        }
                                    } catch (JSONException e68) {
                                        e = e68;
                                        str16 = str16;
                                    }
                                } catch (JSONException e69) {
                                    e = e69;
                                    str24 = str64;
                                    str26 = str21;
                                    e.printStackTrace();
                                    i13++;
                                    str78 = str78;
                                    str21 = str26;
                                    str88 = str25;
                                    str75 = str23;
                                    str64 = str24;
                                    str16 = str16;
                                    str15 = str15;
                                    str18 = str18;
                                }
                            } catch (JSONException e70) {
                                e = e70;
                                str23 = str75;
                            }
                        } catch (JSONException e71) {
                            e = e71;
                            str16 = str16;
                            str15 = str15;
                            str18 = str18;
                            str78 = str78;
                            str23 = str75;
                            str24 = str64;
                            str25 = str88;
                        }
                        i13++;
                        str78 = str78;
                        str21 = str26;
                        str88 = str25;
                        str75 = str23;
                        str64 = str24;
                        str16 = str16;
                        str15 = str15;
                        str18 = str18;
                    }
                    if (arrayListJ8.size() > 0) {
                        Toast.makeText(this, getString(R.string.confirm_inv_out), 0).show();
                    }
                    T = T + i7 + size4 + size5 + i12 + size7;
                } catch (IOException e72) {
                    e = e72;
                }
            } catch (IOException e73) {
                e = e73;
            }
        } catch (IOException e74) {
            e = e74;
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x02be  */
    /* JADX WARN: Code duplicated, block: B:82:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:83:0x02d8  */
    public void O() throws Throwable {
        ArrayList arrayListI8;
        String str;
        int i2;
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
        ArrayList arrayList;
        String str20;
        String str21;
        String str22;
        String str23;
        ArrayList arrayList2;
        String str24;
        nodeJS nodejs;
        String str25;
        String message;
        int i3;
        nodeJS nodejs2;
        String str26;
        String str27;
        int i4;
        String str28 = "Error2:";
        String str29 = "2";
        if (this.e.ja("online_server", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            try {
                this.e.ua("1", strIa);
                this.e.ua("2", strIa);
                while (true) {
                    str2 = "json_";
                    str3 = "json";
                    str4 = "ref";
                    str5 = "ref_no";
                    str6 = str;
                    str7 = str29;
                    str8 = strIa;
                    str9 = str28;
                    str10 = "p_un";
                    str11 = "add_server_req";
                    str12 = "un";
                    str13 = "action_type";
                    str14 = token;
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
                        str26 = str14;
                        try {
                            jSONObject.put("fcm_token", str26);
                            jSONObject.put(str13, 2);
                            nodejs2 = this;
                            try {
                                nodejs2.E.a(str11, jSONObject);
                                str27 = str9;
                                i4 = 1;
                            } catch (JSONException e) {
                                e = e;
                                e.printStackTrace();
                                StringBuilder sb = new StringBuilder();
                                str27 = str9;
                                sb.append(str27);
                                sb.append((e.getMessage() == null || e.getMessage().length() <= 200) ? e.getMessage() : e.getMessage().substring(0, 200));
                                String string = sb.toString();
                                i4 = 1;
                                Toast.makeText(nodejs2, string, 1).show();
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            nodejs2 = this;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        nodejs2 = this;
                        str26 = str14;
                    }
                    i2 += i4;
                    str28 = str27;
                    token = str26;
                    str = str6;
                    str29 = str7;
                    strIa = str8;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error0:");
                sb2.append((e5.getMessage() == null || e5.getMessage().length() <= 200) ? e5.getMessage() : e5.getMessage().substring(0, 200));
                Toast.makeText(this, sb2.toString(), 1).show();
            }
            new ArrayList();
            arrayListI8 = this.e.i8("1", strIa, "2");
            arrayListI8.size();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(arrayListI8.size());
            str = "";
            sb3.append("");
            Log.d("req_sls_out2=", sb3.toString());
            i2 = 0;
            String str30 = str9;
            String str31 = "fcm_token";
            String str32 = str8;
            ArrayList arrayListI9 = this.e.i8(str7, str32, str7);
            arrayListI9.size();
            Log.d("req_pur_out2=", arrayListI9.size() + str6);
            int i5 = 0;
            while (i5 < arrayListI9.size()) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    str23 = str32;
                    try {
                        jSONObject2.put("un", ((HashMap) arrayListI9.get(i5)).get("_un"));
                        jSONObject2.put("p_un", ((HashMap) arrayListI9.get(i5)).get("_p_un"));
                        jSONObject2.put("c_br_id", ((HashMap) arrayListI9.get(i5)).get("f_br_id"));
                        jSONObject2.put("tr_type", ((HashMap) arrayListI9.get(i5)).get("tr_type"));
                        jSONObject2.put("acc_type", ((HashMap) arrayListI9.get(i5)).get("acc_type"));
                        jSONObject2.put("ref_no", ((HashMap) arrayListI9.get(i5)).get("ref"));
                        jSONObject2.put(str3, ((HashMap) arrayListI9.get(i5)).get(str2));
                        arrayList2 = arrayListI9;
                        String str33 = str14;
                        String str34 = str31;
                        try {
                            jSONObject2.put(str34, str33);
                            str14 = str33;
                            str31 = str34;
                            String str35 = str13;
                            try {
                                jSONObject2.put(str35, 2);
                                nodejs = this;
                                str13 = str35;
                                try {
                                    str3 = str3;
                                    str2 = str2;
                                    try {
                                        str24 = str11;
                                        try {
                                            nodejs.E.a(str24, jSONObject2);
                                            str11 = str24;
                                            i3 = 1;
                                        } catch (JSONException e6) {
                                            e = e6;
                                            e.printStackTrace();
                                            StringBuilder sb4 = new StringBuilder();
                                            str25 = str30;
                                            sb4.append(str25);
                                            if (e.getMessage() != null) {
                                                str30 = str25;
                                                str11 = str24;
                                                if (e.getMessage().length() > 200) {
                                                    message = e.getMessage().substring(0, 200);
                                                }
                                                sb4.append(message);
                                                String string2 = sb4.toString();
                                                i3 = 1;
                                                Toast.makeText(nodejs, string2, 1).show();
                                            } else {
                                                str11 = str24;
                                                str30 = str25;
                                            }
                                            message = e.getMessage();
                                            sb4.append(message);
                                            String string3 = sb4.toString();
                                            i3 = 1;
                                            Toast.makeText(nodejs, string3, 1).show();
                                        }
                                    } catch (JSONException e7) {
                                        e = e7;
                                        str24 = str11;
                                        e.printStackTrace();
                                        StringBuilder sb5 = new StringBuilder();
                                        str25 = str30;
                                        sb5.append(str25);
                                        if (e.getMessage() != null) {
                                            str30 = str25;
                                            str11 = str24;
                                            if (e.getMessage().length() > 200) {
                                                message = e.getMessage().substring(0, 200);
                                            }
                                            sb5.append(message);
                                            String string4 = sb5.toString();
                                            i3 = 1;
                                            Toast.makeText(nodejs, string4, 1).show();
                                            i5 += i3;
                                            arrayListI9 = arrayList2;
                                            str32 = str23;
                                            str3 = str3;
                                            str2 = str2;
                                        } else {
                                            str11 = str24;
                                            str30 = str25;
                                        }
                                        message = e.getMessage();
                                        sb5.append(message);
                                        String string5 = sb5.toString();
                                        i3 = 1;
                                        Toast.makeText(nodejs, string5, 1).show();
                                        i5 += i3;
                                        arrayListI9 = arrayList2;
                                        str32 = str23;
                                        str3 = str3;
                                        str2 = str2;
                                    }
                                } catch (JSONException e8) {
                                    e = e8;
                                    str3 = str3;
                                    str2 = str2;
                                }
                            } catch (JSONException e9) {
                                e = e9;
                                nodejs = this;
                                str3 = str3;
                                str2 = str2;
                                str13 = str35;
                            }
                        } catch (JSONException e10) {
                            e = e10;
                            str14 = str33;
                            str31 = str34;
                            str24 = str11;
                            nodejs = this;
                            e.printStackTrace();
                            StringBuilder sb6 = new StringBuilder();
                            str25 = str30;
                            sb6.append(str25);
                            if (e.getMessage() != null) {
                                str30 = str25;
                                str11 = str24;
                                if (e.getMessage().length() > 200) {
                                    message = e.getMessage().substring(0, 200);
                                }
                                sb6.append(message);
                                String string6 = sb6.toString();
                                i3 = 1;
                                Toast.makeText(nodejs, string6, 1).show();
                                i5 += i3;
                                arrayListI9 = arrayList2;
                                str32 = str23;
                                str3 = str3;
                                str2 = str2;
                            } else {
                                str11 = str24;
                                str30 = str25;
                            }
                            message = e.getMessage();
                            sb6.append(message);
                            String string7 = sb6.toString();
                            i3 = 1;
                            Toast.makeText(nodejs, string7, 1).show();
                            i5 += i3;
                            arrayListI9 = arrayList2;
                            str32 = str23;
                            str3 = str3;
                            str2 = str2;
                        }
                    } catch (JSONException e11) {
                        e = e11;
                        nodejs = this;
                        str3 = str3;
                        str2 = str2;
                        arrayList2 = arrayListI9;
                    }
                } catch (JSONException e12) {
                    e = e12;
                    str23 = str32;
                    arrayList2 = arrayListI9;
                }
                i5 += i3;
                arrayListI9 = arrayList2;
                str32 = str23;
                str3 = str3;
                str2 = str2;
            }
            String str36 = str32;
            String str37 = str3;
            String str38 = str2;
            try {
                str15 = str36;
                try {
                    this.e.sa("-3", str15);
                } catch (IOException e13) {
                    e = e13;
                    e.printStackTrace();
                }
            } catch (IOException e14) {
                e = e14;
                str15 = str36;
            }
            ArrayList arrayListI10 = this.e.i8("5", str15, str7);
            int size = arrayListI10.size();
            int i6 = 0;
            while (i6 < arrayListI10.size()) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    str20 = str15;
                    try {
                        jSONObject3.put("un", ((HashMap) arrayListI10.get(i6)).get("_un"));
                        jSONObject3.put("p_un", ((HashMap) arrayListI10.get(i6)).get("_p_un"));
                        jSONObject3.put("c_br_id", ((HashMap) arrayListI10.get(i6)).get("f_br_id"));
                        jSONObject3.put("tr_type", ((HashMap) arrayListI10.get(i6)).get("tr_type"));
                        jSONObject3.put("acc_type", ((HashMap) arrayListI10.get(i6)).get("acc_type"));
                        jSONObject3.put(str5, ((HashMap) arrayListI10.get(i6)).get("ref"));
                        HashMap map = (HashMap) arrayListI10.get(i6);
                        arrayList = arrayListI10;
                        String str39 = str38;
                        try {
                            Object obj = map.get(str39);
                            str38 = str39;
                            String str40 = str37;
                            try {
                                jSONObject3.put(str40, obj);
                                str37 = str40;
                                String str41 = str14;
                                String str42 = str31;
                                try {
                                    jSONObject3.put(str42, str41);
                                    str31 = str42;
                                    str14 = str41;
                                    String str43 = str13;
                                    try {
                                        jSONObject3.put(str43, 2);
                                        str13 = str43;
                                        str21 = str5;
                                        try {
                                            str22 = str11;
                                            try {
                                                this.E.a(str22, jSONObject3);
                                            } catch (JSONException e15) {
                                                e = e15;
                                                e.printStackTrace();
                                            }
                                        } catch (JSONException e16) {
                                            e = e16;
                                            str22 = str11;
                                            e.printStackTrace();
                                            i6++;
                                            str11 = str22;
                                            arrayListI10 = arrayList;
                                            str5 = str21;
                                            str15 = str20;
                                        }
                                    } catch (JSONException e17) {
                                        e = e17;
                                        str13 = str43;
                                        str21 = str5;
                                        str22 = str11;
                                        e.printStackTrace();
                                        i6++;
                                        str11 = str22;
                                        arrayListI10 = arrayList;
                                        str5 = str21;
                                        str15 = str20;
                                    }
                                } catch (JSONException e18) {
                                    e = e18;
                                    str31 = str42;
                                    str14 = str41;
                                }
                            } catch (JSONException e19) {
                                e = e19;
                                str37 = str40;
                            }
                        } catch (JSONException e20) {
                            e = e20;
                            str38 = str39;
                        }
                    } catch (JSONException e21) {
                        e = e21;
                        arrayList = arrayListI10;
                    }
                } catch (JSONException e22) {
                    e = e22;
                    arrayList = arrayListI10;
                    str20 = str15;
                }
                i6++;
                str11 = str22;
                arrayListI10 = arrayList;
                str5 = str21;
                str15 = str20;
            }
            String str44 = str15;
            String str45 = str5;
            String str46 = str11;
            ArrayList arrayListI11 = this.e.i8("6", str44, str7);
            int size2 = size + arrayListI11.size();
            int i7 = 0;
            while (i7 < arrayListI11.size()) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put(str12, ((HashMap) arrayListI11.get(i7)).get("_un"));
                    jSONObject4.put(str10, ((HashMap) arrayListI11.get(i7)).get("_p_un"));
                    jSONObject4.put("c_br_id", ((HashMap) arrayListI11.get(i7)).get("f_br_id"));
                    jSONObject4.put("tr_type", ((HashMap) arrayListI11.get(i7)).get("tr_type"));
                    jSONObject4.put("acc_type", ((HashMap) arrayListI11.get(i7)).get("acc_type"));
                    str16 = str12;
                    String str47 = str45;
                    try {
                        jSONObject4.put(str47, ((HashMap) arrayListI11.get(i7)).get(str4));
                        str45 = str47;
                        String str48 = str38;
                        try {
                            Object obj2 = ((HashMap) arrayListI11.get(i7)).get(str48);
                            str38 = str48;
                            String str49 = str37;
                            try {
                                jSONObject4.put(str49, obj2);
                                str37 = str49;
                                str19 = str14;
                                String str50 = str31;
                                try {
                                    jSONObject4.put(str50, str19);
                                    str31 = str50;
                                    str17 = str10;
                                    String str51 = str13;
                                    try {
                                        jSONObject4.put(str51, 2);
                                        str13 = str51;
                                        str18 = str4;
                                        try {
                                            this.E.a(str46, jSONObject4);
                                        } catch (JSONException e23) {
                                            e = e23;
                                            e.printStackTrace();
                                        }
                                    } catch (JSONException e24) {
                                        e = e24;
                                        str13 = str51;
                                        str18 = str4;
                                        e.printStackTrace();
                                        i7++;
                                        str14 = str19;
                                        str12 = str16;
                                        str10 = str17;
                                        str4 = str18;
                                    }
                                } catch (JSONException e25) {
                                    e = e25;
                                    str31 = str50;
                                    str17 = str10;
                                }
                            } catch (JSONException e26) {
                                e = e26;
                                str37 = str49;
                                str17 = str10;
                                str18 = str4;
                                str19 = str14;
                                e.printStackTrace();
                                i7++;
                                str14 = str19;
                                str12 = str16;
                                str10 = str17;
                                str4 = str18;
                            }
                        } catch (JSONException e27) {
                            e = e27;
                            str38 = str48;
                        }
                    } catch (JSONException e28) {
                        e = e28;
                        str45 = str47;
                    }
                } catch (JSONException e29) {
                    e = e29;
                    str16 = str12;
                }
                i7++;
                str14 = str19;
                str12 = str16;
                str10 = str17;
                str4 = str18;
            }
            if (size2 != 0) {
                Toast.makeText(this, getString(R.string.confirm_br_doc_out), 0).show();
            }
        }
    }

    public void P() {
        if (this.e.ja("online_server", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            ArrayList arrayListT2 = this.e.t2(strIa);
            for (int i2 = 0; i2 < arrayListT2.size(); i2++) {
                try {
                    this.e.Ba("-200", strIa, (String) arrayListT2.get(i2));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error0:");
                    sb.append((e2.getMessage() == null || e2.getMessage().length() <= 200) ? e2.getMessage() : e2.getMessage().substring(0, 200));
                    Toast.makeText(this, sb.toString(), 1).show();
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
                    this.E.a("add_server_req", jSONObject);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error2:");
                    sb2.append((e3.getMessage() == null || e3.getMessage().length() <= 200) ? e3.getMessage() : e3.getMessage().substring(0, 200));
                    Toast.makeText(this, sb2.toString(), 1).show();
                }
            }
            if (arrayListI8.size() > 0) {
                Toast.makeText(this, getString(R.string.confirm_currency_out), 0).show();
            }
        }
    }

    public void Q() {
        if (this.e.ja("online_server", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            ArrayList arrayListT2 = this.e.t2(strIa);
            for (int i2 = 0; i2 < arrayListT2.size(); i2++) {
                try {
                    this.e.Da("-200", strIa, (String) arrayListT2.get(i2));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error0:");
                    sb.append((e2.getMessage() == null || e2.getMessage().length() <= 200) ? e2.getMessage() : e2.getMessage().substring(0, 200));
                    Toast.makeText(this, sb.toString(), 1).show();
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
                    this.E.a("add_server_req", jSONObject);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error2:");
                    sb2.append((e3.getMessage() == null || e3.getMessage().length() <= 200) ? e3.getMessage() : e3.getMessage().substring(0, 200));
                    Toast.makeText(this, sb2.toString(), 1).show();
                }
            }
            if (arrayListI8.size() > 0) {
                Toast.makeText(this, arrayListI8.size() + ":" + getString(R.string.confirm_items_out), 0).show();
            }
        }
    }

    public void R() {
        if (this.e.ja("online_server", false)) {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            ArrayList arrayListT2 = this.e.t2(strIa);
            for (int i2 = 0; i2 < arrayListT2.size(); i2++) {
                try {
                    this.e.Ca("-201", strIa, (String) arrayListT2.get(i2));
                } catch (IOException e) {
                    e.printStackTrace();
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
                    this.E.a("add_server_req", jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (arrayListI8.size() > 0) {
                Toast.makeText(this, getString(R.string.confirm_names_out), 0).show();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0153 A[PHI: r11
      0x0153: PHI (r11v2 java.lang.String) = (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v5 java.lang.String) binds: [B:5:0x002e, B:7:0x0044, B:10:0x0050, B:26:0x0141] A[DONT_GENERATE, DONT_INLINE]] */
    public void S() {
        String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
        String token = FirebaseInstanceId.getInstance().getToken();
        String str = "";
        for (int size = this.D.size() - 1; size >= 0; size--) {
            if (this.D.valueAt(size)) {
                C4143vg item = this.B.getItem(this.D.keyAt(size));
                if (!strIa.equals(item.h()) && !str.contains(item.h())) {
                    try {
                        this.e.Ca("-201", strIa, item.h());
                        str = str + "#" + item.h();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new ArrayList();
                    ArrayList arrayListI8 = this.e.i8("-201", strIa, "2");
                    arrayListI8.size();
                    Log.d("req_m=", arrayListI8.size() + "");
                    for (int i2 = 0; i2 < arrayListI8.size(); i2++) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("un", ((HashMap) arrayListI8.get(i2)).get("_un"));
                            jSONObject.put("p_un", ((HashMap) arrayListI8.get(i2)).get("_p_un"));
                            jSONObject.put("c_br_id", ((HashMap) arrayListI8.get(i2)).get("f_br_id"));
                            jSONObject.put("tr_type", ((HashMap) arrayListI8.get(i2)).get("tr_type"));
                            jSONObject.put("acc_type", ((HashMap) arrayListI8.get(i2)).get("acc_type"));
                            jSONObject.put("ref_no", ((HashMap) arrayListI8.get(i2)).get("ref"));
                            jSONObject.put("json", ((HashMap) arrayListI8.get(i2)).get("json_"));
                            jSONObject.put("fcm_token", token);
                            jSONObject.put("action_type", 2);
                            this.E.a("add_server_req", jSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (arrayListI8.size() > 0) {
                        Toast.makeText(this, getString(R.string.confirm_names_out), 0).show();
                    }
                }
            }
        }
    }

    public void U(boolean z2) {
        Log.d("mProgress=", "....start..." + z2);
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z2) {
                android.app.AlertDialog alertDialogCreate = builder.create();
                this.P = alertDialogCreate;
                alertDialogCreate.setCancelable(false);
                this.P.show();
            } else {
                Dialog dialog = this.P;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void V(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str4 == "0") {
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer6, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.account_name);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.account_parent);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_cus_type);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.cash_name);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_cash_type);
            this.e.ad(this, editText);
            this.e.cd(this, autoCompleteTextView);
            this.e.cd(this, autoCompleteTextView2);
            String token = FirebaseInstanceId.getInstance().getToken();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.w2("1", token, str4));
            this.R = arrayAdapter;
            autoCompleteTextView.setAdapter(arrayAdapter);
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.w2("2", token, str4));
            this.S = arrayAdapter2;
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            imageView.setOnClickListener(new ViewOnClickListenerC3089e(autoCompleteTextView));
            imageView2.setOnClickListener(new ViewOnClickListenerC3090f(autoCompleteTextView2));
            autoCompleteTextView.setOnItemClickListener(new g(autoCompleteTextView));
            autoCompleteTextView2.setOnItemClickListener(new h(autoCompleteTextView2));
            editText.setText(str4);
            editText.setEnabled(false);
            editText.setVisibility(8);
            builder.setPositiveButton(getString(R.string.resourceID_OK), new i());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new j());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(str4);
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new k(editText, autoCompleteTextView, autoCompleteTextView2, alertDialogCreate, str4, str5, str6));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void W() {
        try {
            String strIa = this.e.ia("PREF_ACCOUNT_NAME", "0");
            String token = FirebaseInstanceId.getInstance().getToken();
            new ArrayList();
            ArrayList arrayListK8 = this.e.k8(strIa);
            Log.d("req_pending=", arrayListK8.size() + "");
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
                    this.E.a("confirm_client_add_req", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void amount_add_btn(View view) {
        M();
    }

    public void no_result_btn(View view) {
        J();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nodejs_list);
        T();
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        TextView textView = (TextView) findViewById(R.id.g_name);
        TextView textView2 = (TextView) findViewById(R.id.g_cnt);
        this.w = (ImageView) findViewById(R.id.img_add_amount);
        this.x = (ImageView) findViewById(R.id.refresh);
        this.y = (ImageBadgeView) findViewById(R.id.send_msg);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        this.z = (ListView) findViewById(R.id.list_data);
        this.z.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.z.setChoiceMode(2);
        this.e = new Z00(this.d, this);
        J();
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        if (this.e.ja("online_server", false)) {
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.y.setVisibility(0);
        }
        if (this.e.ja("online_client", false)) {
            this.x.setVisibility(0);
            this.y.setVisibility(0);
        }
        this.z.setChoiceMode(3);
        this.z.setMultiChoiceModeListener(new C3085a());
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        SocketService.d();
        K();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        E();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        J();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void requests_add(View view) throws Throwable {
        try {
            SocketService.d();
            if (this.E == null) {
                K();
            }
            VQ vq = this.E;
            if (vq != null && vq.z()) {
                T = 0;
                Toast.makeText(this, getString(R.string.wait), 0).show();
                W();
                L();
                G();
                N();
                F();
                try {
                    this.e.r0();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Handler().postDelayed(new o(), Constants.CP_MAC_ROMAN);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void send_msg(View view) {
        startActivity(new Intent(this, (Class<?>) feed_notification.class));
    }

    public void show_help(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.online_service));
        builder.setPositiveButton(getString(R.string.btn_close), new q());
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
            jSONObject.put("android_ver", Z00.m0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.E.a("auth", jSONObject);
    }
}
