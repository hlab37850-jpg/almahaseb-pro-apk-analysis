package info.aalmoghalis.inventory.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C0948Tv;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Account_Tree_Main extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0948Tv B;
    public ArrayAdapter Q;
    public ArrayAdapter R;
    public int T;
    public int U;
    public int V;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public int n = 0;
    public double p = 0.0d;
    public double q = 0.0d;
    public TextView t = null;
    public AutoCompleteTextView u = null;
    public TextView v = null;
    public SwitchCompat w = null;
    public int x = 0;
    public ImageView y = null;
    public ListView z = null;
    public Toolbar A = null;
    public List C = new ArrayList();
    public ImageButton D = null;
    public AppCompatCheckBox E = null;
    public int F = 0;
    public String[] G = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView I = null;
    public ImageView J = null;
    public String K = "";
    public Dialog L = null;
    public Handler M = new b();
    public String N = "";
    public Cursor O = null;
    public boolean P = false;
    public SwitchCompat S = null;
    public int W = 0;
    public String X = CSS.Value.PERCENTAGE;
    public String Y = CSS.Value.PERCENTAGE;
    public TextView Z = null;
    public TextView a0 = null;
    public DatePickerDialog.OnDateSetListener b0 = new u();
    public DatePickerDialog.OnDateSetListener c0 = new v();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Account_Tree_Main.this.J();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Account_Tree_Main.this.i;
                StringBuilder sb = new StringBuilder();
                Account_Tree_Main account_Tree_Main = Account_Tree_Main.this;
                sb.append(account_Tree_Main.i.ic(account_Tree_Main.N));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Z00 z01 = Account_Tree_Main.this.i;
                StringBuilder sb2 = new StringBuilder();
                Account_Tree_Main account_Tree_Main2 = Account_Tree_Main.this;
                sb2.append(account_Tree_Main2.i.ic(account_Tree_Main2.N));
                sb2.append(".xls");
                z01.pa(sb2.toString());
            }
            Account_Tree_Main.this.W(false);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Account_Tree_Main.this.M();
            Message message = new Message();
            message.obj = "0";
            Account_Tree_Main.this.M.sendMessage(message);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Account_Tree_Main account_Tree_Main = Account_Tree_Main.this;
            Z00 z00 = account_Tree_Main.i;
            z00.mb(account_Tree_Main.z, z00.ic(account_Tree_Main.N));
            Message message = new Message();
            message.obj = "1";
            Account_Tree_Main.this.M.sendMessage(message);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Account_Tree_Main account_Tree_Main = Account_Tree_Main.this;
            Z00 z00 = account_Tree_Main.i;
            z00.Ra(account_Tree_Main.z, z00.ic(account_Tree_Main.N));
            Message message = new Message();
            message.obj = "2";
            Account_Tree_Main.this.M.sendMessage(message);
        }
    }

    public class f extends WebViewClient {
        public f() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('2','8','7')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(view.getContext(), (Class<?>) Account_Tree_Det.class);
            if (c4145vh.r().equals("1")) {
                intent.putExtra("parent_id", c4145vh.v() + "");
                intent.putExtra("p_name", c4145vh.a() + "");
            } else {
                intent.putExtra("parent_id", c4145vh.p() + "");
                intent.putExtra("p_name", c4145vh.q() + "");
            }
            Log.d("lv_click=", c4145vh.v() + ":" + c4145vh.q() + ":" + c4145vh.a());
            Account_Tree_Main.this.startActivity(intent);
        }
    }

    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                Account_Tree_Main account_Tree_Main = Account_Tree_Main.this;
                account_Tree_Main.S.setText(account_Tree_Main.i.y1("0"));
            } else {
                Account_Tree_Main account_Tree_Main2 = Account_Tree_Main.this;
                account_Tree_Main2.S.setText(account_Tree_Main2.i.y1("1"));
            }
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public j(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Tree_Main account_Tree_Main = Account_Tree_Main.this;
            account_Tree_Main.i.Md(account_Tree_Main);
            Account_Tree_Main account_Tree_Main2 = Account_Tree_Main.this;
            account_Tree_Main2.i.T(account_Tree_Main2, account_Tree_Main2.Q, this.a);
        }
    }

    public class k implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public k(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlertDialog d;

        public n(EditText editText, AutoCompleteTextView autoCompleteTextView, String str, AlertDialog alertDialog) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = str;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (Account_Tree_Main.this.i.p1(this.b.getText().toString()).getCount() == 0) {
                this.b.setError(Account_Tree_Main.this.getString(R.string.not_exists));
                zA = false;
            }
            if (zA) {
                Account_Tree_Main account_Tree_Main = Account_Tree_Main.this;
                int iW1 = account_Tree_Main.i.w1(account_Tree_Main.S.getText().toString());
                if (this.c.equals("0")) {
                    if (iW1 == 0 && Account_Tree_Main.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        Account_Tree_Main account_Tree_Main2 = Account_Tree_Main.this;
                        account_Tree_Main2.i.Pd(account_Tree_Main2, account_Tree_Main2.z, this.a.getText().toString().trim() + " : " + Account_Tree_Main.this.getString(R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Account_Tree_Main.this);
                        this.d.dismiss();
                        return;
                    }
                    if (iW1 == 1 && Account_Tree_Main.this.i.p1(this.a.getText().toString().trim()).getCount() > 0) {
                        Account_Tree_Main account_Tree_Main3 = Account_Tree_Main.this;
                        account_Tree_Main3.i.Pd(account_Tree_Main3, account_Tree_Main3.z, this.a.getText().toString().trim() + " : " + Account_Tree_Main.this.getString(R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Account_Tree_Main.this);
                        this.d.dismiss();
                        return;
                    }
                    if (iW1 == 0) {
                        Account_Tree_Main.this.i.v0("insert into customers (name,gsm,address,g_id,cus_type_id,acc_p_id) values('" + this.a.getText().toString().trim() + "','','','0','6',(select b.id from account_tree b where b.name='" + this.b.getText().toString() + "') ) ");
                        Account_Tree_Main.this.N();
                        Account_Tree_Main.this.L();
                    } else {
                        int iR1 = Account_Tree_Main.this.i.r1(this.b.getText().toString());
                        Z00 z00 = Account_Tree_Main.this.i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into account_tree (id,name,parent_id,p) values('");
                        sb.append(iR1);
                        sb.append(Account_Tree_Main.this.i.n1(iR1 + "") + 1);
                        sb.append("','");
                        sb.append(this.a.getText().toString().trim());
                        sb.append("','");
                        sb.append(iR1);
                        sb.append("',1)");
                        z00.v0(sb.toString());
                        Account_Tree_Main.this.N();
                        Account_Tree_Main.this.L();
                    }
                    FragmentStatePagerSupport_Main.a0 = true;
                } else if (this.c != null) {
                    if (iW1 == 0) {
                        Account_Tree_Main.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',online=0,acc_p_id=(select id from account_tree where name='" + this.b.getText().toString() + "') where id='" + this.c + "' and id>0 ");
                        Account_Tree_Main.this.N();
                        Account_Tree_Main.this.L();
                    } else {
                        Account_Tree_Main.this.i.v0("update account_tree set name='" + this.a.getText().toString().trim() + "' where id='" + this.c + "' and admin<>1 ");
                        Account_Tree_Main.this.N();
                        Account_Tree_Main.this.L();
                    }
                    FragmentStatePagerSupport_Main.a0 = true;
                }
                this.d.dismiss();
                Account_Tree_Main account_Tree_Main4 = Account_Tree_Main.this;
                account_Tree_Main4.i.Md(account_Tree_Main4);
            }
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Tree_Main.this.showDialog(0);
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Tree_Main.this.showDialog(4);
        }
    }

    public class q implements DialogInterface.OnClickListener {
        public q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Account_Tree_Main.this.W = 0;
                dialogInterface.dismiss();
                Account_Tree_Main.this.N();
            } catch (Exception unused) {
            }
        }
    }

    public class s implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public s(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Account_Tree_Main account_Tree_Main = Account_Tree_Main.this;
                account_Tree_Main.W = 1;
                if (account_Tree_Main.Z.getText() == null) {
                    Account_Tree_Main.this.X = "";
                } else {
                    Account_Tree_Main account_Tree_Main2 = Account_Tree_Main.this;
                    account_Tree_Main2.X = account_Tree_Main2.Z.getText().toString();
                }
                if (Account_Tree_Main.this.a0.getText() == null) {
                    Account_Tree_Main.this.Y = "";
                } else {
                    Account_Tree_Main account_Tree_Main3 = Account_Tree_Main.this;
                    account_Tree_Main3.Y = account_Tree_Main3.a0.getText().toString();
                }
                this.a.dismiss();
                Account_Tree_Main.this.N();
            } catch (Exception unused) {
            }
        }
    }

    public class t implements SearchView.OnQueryTextListener {
        public t() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Account_Tree_Main.this.K(1);
            }
            Account_Tree_Main.this.R(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Account_Tree_Main.this.K(0);
            return false;
        }
    }

    public class u implements DatePickerDialog.OnDateSetListener {
        public u() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Account_Tree_Main.this.T = i;
            Account_Tree_Main.this.U = i2;
            Account_Tree_Main.this.V = i3;
            try {
                String str = Account_Tree_Main.this.T + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Tree_Main.this.U + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Tree_Main.this.V));
                Locale locale = Locale.ENGLISH;
                Account_Tree_Main.this.Z.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class v implements DatePickerDialog.OnDateSetListener {
        public v() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Account_Tree_Main.this.T = i;
            Account_Tree_Main.this.U = i2;
            Account_Tree_Main.this.V = i3;
            try {
                String str = Account_Tree_Main.this.T + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Tree_Main.this.U + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Tree_Main.this.V));
                Locale locale = Locale.ENGLISH;
                Account_Tree_Main.this.a0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public w(TextView textView, ImageView imageView) {
            this.a = textView;
            this.b = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ImageView imageView;
            try {
                if (this.a == null || (imageView = this.b) == null) {
                    return;
                }
                String str = Integer.parseInt(imageView.getTag().toString()) == 17301515 ? "1" : "0";
                Account_Tree_Main.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Account_Tree_Main.this.l = 0;
                Account_Tree_Main.this.N();
            } catch (Exception unused) {
                Toast.makeText(Account_Tree_Main.this.getApplicationContext(), Account_Tree_Main.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public void H() {
        try {
            this.W = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.Z = (TextView) viewInflate.findViewById(R.id.f_date);
            this.a0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.Z.setOnClickListener(new o());
            this.a0.setOnClickListener(new p());
            builder.setPositiveButton(getString(R.string.btn_search), new q());
            builder.setNegativeButton(getString(R.string.btn_cancel), new r());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new s(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void I() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void J() {
        Q();
        C0948Tv c0948Tv = new C0948Tv(this, R.layout.data_det_row_rep6_, this.C, 4, P(), 1);
        this.B = c0948Tv;
        c0948Tv.l.clear();
        this.B.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.B);
    }

    public void K(int i2) {
    }

    public void L() {
        Log.d("trace_S_Cus_List_Acct=", FragmentStatePagerSupport_Main.X());
        Cursor cursorQ1 = this.i.q1();
        Z00.h0.clear();
        new C0566Hd();
        cursorQ1.moveToFirst();
        while (!cursorQ1.isAfterLast()) {
            Z00.h0.add(new C4145vh(cursorQ1.getString(cursorQ1.getColumnIndex("_id")), cursorQ1.getString(cursorQ1.getColumnIndex("name")), cursorQ1.getString(cursorQ1.getColumnIndex("t_name")), cursorQ1.getString(cursorQ1.getColumnIndex("cnt")), cursorQ1.getString(cursorQ1.getColumnIndex("parent_id")), cursorQ1.getString(cursorQ1.getColumnIndex("p_name")), cursorQ1.getString(cursorQ1.getColumnIndex("p")), cursorQ1.getString(cursorQ1.getColumnIndex("cus_id")), ""));
            cursorQ1.moveToNext();
        }
        cursorQ1.close();
        Log.d("trace_E_Cus_List_Acct=", FragmentStatePagerSupport_Main.X());
    }

    public void M() {
        Cursor cursorO1 = this.i.o1("0");
        Log.d("Cursor_cnt=", String.valueOf(cursorO1.getCount()));
        this.p = 0.0d;
        this.q = 0.0d;
        this.C.clear();
        cursorO1.moveToFirst();
        while (!cursorO1.isAfterLast()) {
            this.C.add(new C4145vh(cursorO1.getString(cursorO1.getColumnIndex("_id")), cursorO1.getString(cursorO1.getColumnIndex("name")), cursorO1.getString(cursorO1.getColumnIndex("t_name")), cursorO1.getString(cursorO1.getColumnIndex("cnt")), cursorO1.getString(cursorO1.getColumnIndex("parent_id")), cursorO1.getString(cursorO1.getColumnIndex("p_name")), cursorO1.getString(cursorO1.getColumnIndex("p")), cursorO1.getString(cursorO1.getColumnIndex("cus_id")), ""));
            cursorO1.moveToNext();
        }
        cursorO1.close();
    }

    public void N() {
        W(true);
        new Thread(new c()).start();
    }

    public void O(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.x));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
        finish();
    }

    public boolean P() {
        return false;
    }

    public void Q() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        textView.setText(getString(R.string.account_name));
        textView2.setText(getString(R.string.account_type));
        textView3.setText(getString(R.string.cus_cnt));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
    }

    public void R(String str) {
        this.B.getFilter().filter(str);
    }

    public void S() {
        W(true);
        new Thread(new e()).start();
    }

    public void T() {
        W(true);
        new Thread(new d()).start();
    }

    public void U(boolean z) {
    }

    public void V() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new f());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new g());
        builder.show();
    }

    public void W(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z) {
            android.app.AlertDialog alertDialogCreate = builder.create();
            this.L = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.L;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void X(String str, String str2, String str3, String str4) {
        try {
            Bill_edit.P2 = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer5, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.account_name);
            this.S = (SwitchCompat) viewInflate.findViewById(R.id.account_type);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.account_parent);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_cus_type);
            this.i.ad(this, editText);
            this.i.cd(this, autoCompleteTextView);
            editText.setText(str2);
            this.S.setText(str4);
            autoCompleteTextView.setText(str3);
            if (this.i.w1(str4) == 1) {
                this.S.setChecked(false);
            } else {
                this.S.setChecked(true);
            }
            this.S.setOnCheckedChangeListener(new i());
            this.R = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x1());
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.s1());
            this.Q = arrayAdapter;
            autoCompleteTextView.setAdapter(arrayAdapter);
            imageView.setOnClickListener(new j(autoCompleteTextView));
            autoCompleteTextView.setOnItemClickListener(new k(autoCompleteTextView));
            if (!str.equals("0")) {
                this.S.setEnabled(false);
                if (this.i.w1(str4) == 1) {
                    autoCompleteTextView.setVisibility(4);
                }
            }
            editText.requestFocus();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new l());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new m());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new n(editText, autoCompleteTextView, str, alertDialogCreate));
        } catch (Exception e2) {
            Log.d("edit_cus_error=", e2.getMessage());
            e2.printStackTrace();
        }
    }

    public void add_btn(View view) {
        if (C2160f10.h <= 0 || new C2160f10(this.i).l("13", "new")) {
            X("0", "", "", this.i.y1("0"));
        } else {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
        }
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.K = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        O(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(R.id.page_name);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(R.string.disable) + "#" + ((Object) textView.getText()) + "?");
        }
        builder.setPositiveButton(getString(R.string.confirm_yes), new w(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new a());
        builder.create().show();
    }

    public void help_btn(View view) {
        V();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.K.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.K + "'");
            }
            this.K = "";
            N();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.W = 0;
        N();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill6_);
        setTitle(getString(R.string.account_tree));
        this.z = (ListView) findViewById(R.id.list_items);
        this.z.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        this.z.setOnItemClickListener(new h());
        this.J = (ImageView) findViewById(R.id.img_add_amount);
        try {
            Q();
            if (getIntent().getStringExtra("g_id") != null) {
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.T = calendar.get(1);
        this.U = calendar.get(2);
        this.V = calendar.get(5);
        U(true);
        N();
        L();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.b0, this.T, this.U, this.V);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.c0, this.T, this.U, this.V);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general2, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        new C1839c10(this.i);
        if (C1839c10.J(this.i)) {
            menu.findItem(R.id.excel).setVisible(true);
        }
        SearchView searchView = (SearchView) menuItemFindItem.getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new t());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        U(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.adv_search) {
            H();
            return true;
        }
        if (menuItem.getItemId() == R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                I();
            }
            this.N = getTitle().toString();
            T();
            return true;
        }
        if (menuItem.getItemId() != R.id.excel) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            I();
        }
        this.N = getTitle().toString();
        S();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            recreate();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
