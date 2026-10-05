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
import android.widget.AutoCompleteTextView;
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
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class Balance_Sheet_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0922Sv D;
    public C0922Sv E;
    public int W;
    public int X;
    public int Y;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public int n = 0;
    public double p = 0.0d;
    public double q = 0.0d;
    public double t = 0.0d;
    public TextView u = null;
    public AutoCompleteTextView v = null;
    public TextView w = null;
    public SwitchCompat x = null;
    public int y = 0;
    public ImageView z = null;
    public ListView A = null;
    public ListView B = null;
    public Toolbar C = null;
    public List F = new ArrayList();
    public List G = new ArrayList();
    public ImageButton H = null;
    public AppCompatCheckBox I = null;
    public int J = 0;
    public String[] K = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] L = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int M = 0;
    public TextView N = null;
    public TextView O = null;
    public ImageView P = null;
    public String Q = "";
    public Dialog R = null;
    public Handler S = new a();
    public String T = "";
    public Cursor U = null;
    public boolean V = false;
    public int Z = 0;
    public String a0 = CSS.Value.PERCENTAGE;
    public String b0 = CSS.Value.PERCENTAGE;
    public TextView c0 = null;
    public TextView d0 = null;
    public DatePickerDialog.OnDateSetListener e0 = new k();
    public DatePickerDialog.OnDateSetListener f0 = new l();

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            Balance_Sheet_Report.this.Y(false);
            if (!message.obj.toString().equals("0") && message.obj.toString().equals("1")) {
                Z00 z00 = Balance_Sheet_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Balance_Sheet_Report balance_Sheet_Report = Balance_Sheet_Report.this;
                sb.append(balance_Sheet_Report.i.ic(balance_Sheet_Report.T));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Balance_Sheet_Report balance_Sheet_Report = Balance_Sheet_Report.this;
            Z00 z00 = balance_Sheet_Report.i;
            ListView listView = balance_Sheet_Report.A;
            ListView listView2 = balance_Sheet_Report.B;
            String strIc = z00.ic(balance_Sheet_Report.T);
            Balance_Sheet_Report balance_Sheet_Report2 = Balance_Sheet_Report.this;
            z00.pb(listView, listView2, strIc, balance_Sheet_Report2.a0, balance_Sheet_Report2.b0);
            Message message = new Message();
            message.obj = "1";
            Balance_Sheet_Report.this.S.sendMessage(message);
        }
    }

    public class c extends WebViewClient {
        public c() {
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

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Balance_Sheet_Report.this.showDialog(0);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Balance_Sheet_Report.this.showDialog(4);
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Balance_Sheet_Report.this.Z = 0;
                dialogInterface.dismiss();
                Balance_Sheet_Report.this.N();
            } catch (Exception unused) {
            }
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public i(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Balance_Sheet_Report balance_Sheet_Report = Balance_Sheet_Report.this;
                balance_Sheet_Report.Z = 1;
                if (balance_Sheet_Report.c0.getText() == null) {
                    Balance_Sheet_Report.this.a0 = "";
                } else {
                    Balance_Sheet_Report balance_Sheet_Report2 = Balance_Sheet_Report.this;
                    balance_Sheet_Report2.a0 = balance_Sheet_Report2.c0.getText().toString();
                }
                if (Balance_Sheet_Report.this.d0.getText() == null) {
                    Balance_Sheet_Report.this.b0 = "";
                } else {
                    Balance_Sheet_Report balance_Sheet_Report3 = Balance_Sheet_Report.this;
                    balance_Sheet_Report3.b0 = balance_Sheet_Report3.d0.getText().toString();
                }
                this.a.dismiss();
                Balance_Sheet_Report.this.N();
            } catch (Exception unused) {
            }
        }
    }

    public class j implements SearchView.OnQueryTextListener {
        public j() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Balance_Sheet_Report.this.L(1);
            }
            Balance_Sheet_Report.this.U(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Balance_Sheet_Report.this.L(0);
            return false;
        }
    }

    public class k implements DatePickerDialog.OnDateSetListener {
        public k() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Balance_Sheet_Report.this.W = i;
            Balance_Sheet_Report.this.X = i2;
            Balance_Sheet_Report.this.Y = i3;
            try {
                String str = Balance_Sheet_Report.this.W + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Balance_Sheet_Report.this.X + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Balance_Sheet_Report.this.Y));
                Locale locale = Locale.ENGLISH;
                Balance_Sheet_Report.this.c0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class l implements DatePickerDialog.OnDateSetListener {
        public l() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Balance_Sheet_Report.this.W = i;
            Balance_Sheet_Report.this.X = i2;
            Balance_Sheet_Report.this.Y = i3;
            try {
                String str = Balance_Sheet_Report.this.W + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Balance_Sheet_Report.this.X + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Balance_Sheet_Report.this.Y));
                Locale locale = Locale.ENGLISH;
                Balance_Sheet_Report.this.d0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public m(TextView textView, ImageView imageView) {
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
                Balance_Sheet_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Balance_Sheet_Report.this.l = 0;
                Balance_Sheet_Report.this.N();
            } catch (Exception unused) {
                Toast.makeText(Balance_Sheet_Report.this.getApplicationContext(), Balance_Sheet_Report.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer S() {
        M();
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(Integer num) {
        Y(false);
        K();
        if (new C1839c10(this).c(this.i)) {
            new C1839c10(this).E(this.i);
        }
        if (new C1839c10(this, this.i).j()) {
            new C1839c10(this, this.i).H();
        }
    }

    public void I() {
        try {
            this.Z = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.c0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.d0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.c0.setVisibility(8);
            this.c0.setOnClickListener(new e());
            this.d0.setOnClickListener(new f());
            builder.setPositiveButton(getString(R.string.btn_search), new g());
            builder.setNegativeButton(getString(R.string.btn_cancel), new h());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new i(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void J() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void K() {
        R();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep4_2, this.F, 5, Q(), 1);
        this.D = c0922Sv;
        c0922Sv.l.clear();
        this.D.notifyDataSetChanged();
        this.A.setAdapter((ListAdapter) this.D);
        this.N.setText(this.i.P7(String.valueOf(this.p)));
        C0922Sv c0922Sv2 = new C0922Sv(this, R.layout.data_det_row_rep4_2, this.G, 5, Q(), 1);
        this.E = c0922Sv2;
        c0922Sv2.l.clear();
        this.E.notifyDataSetChanged();
        this.B.setAdapter((ListAdapter) this.E);
        this.O.setText(this.i.P7(String.valueOf(this.q)));
    }

    public void L(int i2) {
        try {
            if (i2 == 1) {
                this.N.setText(this.i.P7(String.valueOf(this.p)));
                this.O.setText(this.i.P7(String.valueOf(this.q)));
            } else {
                double dO = O(this.D.e);
                double dO2 = O(this.E.e);
                this.N.setText(this.i.P7(String.valueOf(dO)));
                this.O.setText(this.i.P7(String.valueOf(dO2)));
            }
        } catch (Exception unused) {
        }
    }

    public void M() {
        Cursor cursorQ1;
        Cursor cursorQ2;
        Balance_Sheet_Report balance_Sheet_Report = this;
        if (!balance_Sheet_Report.V) {
            balance_Sheet_Report.V = true;
            balance_Sheet_Report.i.Vb();
        }
        int i2 = balance_Sheet_Report.Z;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorQ1 = balance_Sheet_Report.i.Q1("1", CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
            cursorQ2 = balance_Sheet_Report.i.Q1("2", CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            balance_Sheet_Report.a0 = balance_Sheet_Report.a0.isEmpty() ? CSS.Value.PERCENTAGE : balance_Sheet_Report.a0;
            if (!balance_Sheet_Report.b0.isEmpty()) {
                str = balance_Sheet_Report.b0;
            }
            balance_Sheet_Report.b0 = str;
            new C2160f10(balance_Sheet_Report.i).W(balance_Sheet_Report.b0);
            cursorQ1 = balance_Sheet_Report.i.Q1("1", balance_Sheet_Report.a0, balance_Sheet_Report.b0);
            cursorQ2 = balance_Sheet_Report.i.Q1("2", balance_Sheet_Report.a0, balance_Sheet_Report.b0);
        }
        Log.d("Cursor_cnt=", cursorQ2.getCount() + ":" + cursorQ1.getCount());
        balance_Sheet_Report.p = 0.0d;
        balance_Sheet_Report.q = 0.0d;
        balance_Sheet_Report.t = 0.0d;
        balance_Sheet_Report.F.clear();
        balance_Sheet_Report.G.clear();
        cursorQ2.moveToFirst();
        while (!cursorQ2.isAfterLast()) {
            if (cursorQ2.getString(cursorQ2.getColumnIndex("f3")).equals("1")) {
                balance_Sheet_Report.p += cursorQ2.getDouble(cursorQ2.getColumnIndex("f2"));
            }
            balance_Sheet_Report.F.add(new C4145vh(cursorQ2.getString(cursorQ2.getColumnIndex("_id")), balance_Sheet_Report.i.P7(String.valueOf(cursorQ2.getDouble(cursorQ2.getColumnIndex("f2")))), cursorQ2.getString(cursorQ2.getColumnIndex("f1")), cursorQ2.getString(cursorQ2.getColumnIndex("f3")), "", cursorQ2.getString(cursorQ2.getColumnIndex("f3")), "", "", ""));
            cursorQ2.moveToNext();
        }
        cursorQ2.close();
        cursorQ1.moveToFirst();
        while (!cursorQ1.isAfterLast()) {
            if (cursorQ1.getString(cursorQ1.getColumnIndex("f3")).equals("1")) {
                balance_Sheet_Report.q += cursorQ1.getDouble(cursorQ2.getColumnIndex("f2"));
                Log.d("tot_trace=", cursorQ1.getDouble(cursorQ2.getColumnIndex("f2")) + ":" + cursorQ1.getString(cursorQ1.getColumnIndex("f1")) + ":" + balance_Sheet_Report.i.ia("db_item_changed", "1"));
            }
            balance_Sheet_Report.G.add(new C4145vh(cursorQ1.getString(cursorQ1.getColumnIndex("_id")), balance_Sheet_Report.i.P7(String.valueOf(cursorQ1.getDouble(cursorQ1.getColumnIndex("f2")))), cursorQ1.getString(cursorQ1.getColumnIndex("f1")), cursorQ1.getString(cursorQ1.getColumnIndex("f3")), "", cursorQ1.getString(cursorQ1.getColumnIndex("f3")), "", "", ""));
            cursorQ1.moveToNext();
            balance_Sheet_Report = this;
        }
        cursorQ1.close();
    }

    public void N() {
        Y(true);
        AbstractC3132jE.d(new Callable() { // from class: T6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.S();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: U6
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.T((Integer) obj);
            }
        });
    }

    public double O(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).o().replaceAll(",", ""));
        }
        return d2;
    }

    public void P(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.y));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
        finish();
    }

    public boolean Q() {
        return false;
    }

    public void R() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f1_);
        TextView textView3 = (TextView) findViewById(R.id.f2);
        textView.setText(getString(R.string.assets));
        textView2.setText(getString(R.string.libalities_));
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        if (Q()) {
            textView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
            layoutParams.weight = 60.0f;
            textView3.setLayoutParams(layoutParams);
        }
    }

    public void U(String str) {
        this.D.getFilter().filter(str);
    }

    public void V() {
        Y(true);
        new Thread(new b()).start();
    }

    public void W(boolean z) {
    }

    public void X() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new c());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new d());
        builder.show();
    }

    public void Y(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z) {
            android.app.AlertDialog alertDialogCreate = builder.create();
            this.R = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.R;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void add_btn(View view) {
        this.i.z(this, this.j, this.k);
    }

    public void btn_add(View view) {
        Bill_edit.P2 = true;
        this.i.z(this, this.j, this.k);
        finish();
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.Q = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        P(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new m(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new n());
        builder.create().show();
    }

    public void help_btn(View view) {
        X();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.Q.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.Q + "'");
            }
            this.Q = "";
            N();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.Z = 0;
        N();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill5_1);
        setTitle(getIntent().getStringExtra("title_"));
        this.A = (ListView) findViewById(R.id.list_items_r);
        this.B = (ListView) findViewById(R.id.list_items_l);
        TextView textView = (TextView) findViewById(R.id.emptyResults_l);
        TextView textView2 = (TextView) findViewById(R.id.emptyResults_r);
        textView.setText(getString(R.string.no_results));
        textView2.setText(getString(R.string.no_results));
        this.A.setEmptyView(textView);
        this.B.setEmptyView(textView2);
        this.i = new Z00(this.h, this);
        this.N = (TextView) findViewById(R.id.footer_sum);
        this.O = (TextView) findViewById(R.id.footer_sum2);
        try {
            R();
            if (getIntent().getStringExtra("g_id") != null) {
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getIntent().getStringExtra("title_"));
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.W = calendar.get(1);
        this.X = calendar.get(2);
        this.Y = calendar.get(5);
        W(true);
        N();
        if (this.V && this.i.U2() > 0) {
            Toast.makeText(this, getString(R.string.alarm_curr_price), 0).show();
        }
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.e0, this.W, this.X, this.Y);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.f0, this.W, this.X, this.Y);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new j());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        W(true);
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
            I();
            return true;
        }
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            J();
        }
        this.T = getTitle().toString();
        V();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (FragmentStatePagerSupport_Main.a0) {
            Log.d("Oncreate:", "onResume_refresh");
            FragmentStatePagerSupport_Main.a0 = false;
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
