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
import defpackage.C0922Sv;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Revenue_item_Report_Det extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0922Sv E;
    public int S;
    public int T;
    public int U;
    public String a0;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public String l;
    public String n;
    public String q;
    public int t;
    public int p = 0;
    public int u = 0;
    public double v = 0.0d;
    public TextView w = null;
    public AutoCompleteTextView x = null;
    public TextView y = null;
    public SwitchCompat z = null;
    public int A = 0;
    public ImageView B = null;
    public ListView C = null;
    public Toolbar D = null;
    public List F = new ArrayList();
    public ImageButton G = null;
    public AppCompatCheckBox H = null;
    public int I = 0;
    public String[] J = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] K = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView L = null;
    public int M = 0;
    public String N = "";
    public Dialog O = null;
    public Handler P = new f();
    public Cursor Q = null;
    public boolean R = false;
    public int V = 0;
    public String W = CSS.Value.PERCENTAGE;
    public String X = CSS.Value.PERCENTAGE;
    public TextView Y = null;
    public TextView Z = null;
    public DatePickerDialog.OnDateSetListener b0 = new r();
    public DatePickerDialog.OnDateSetListener c0 = new s();

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.n()).compareTo(String.valueOf(c4145vh.n()));
        }
    }

    public class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.n()).compareTo(String.valueOf(c4145vh2.n()));
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Revenue_item_Report_Det.this.sort_name_click(view);
            } catch (Exception unused) {
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public d(TextView textView, ImageView imageView) {
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
                Revenue_item_Report_Det.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Revenue_item_Report_Det.this.t = 0;
                Revenue_item_Report_Det.this.M();
            } catch (Exception unused) {
                Toast.makeText(Revenue_item_Report_Det.this.getApplicationContext(), Revenue_item_Report_Det.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Revenue_item_Report_Det revenue_item_Report_Det = Revenue_item_Report_Det.this;
                revenue_item_Report_Det.J(revenue_item_Report_Det.Q);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Revenue_item_Report_Det.this.i;
                StringBuilder sb = new StringBuilder();
                Revenue_item_Report_Det revenue_item_Report_Det2 = Revenue_item_Report_Det.this;
                sb.append(revenue_item_Report_Det2.i.ic(revenue_item_Report_Det2.a0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            Revenue_item_Report_Det.this.V(false);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Revenue_item_Report_Det.this.L();
            Message message = new Message();
            message.obj = "0";
            Revenue_item_Report_Det.this.P.sendMessage(message);
        }
    }

    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            C4145vh c4145vh = (C4145vh) Revenue_item_Report_Det.this.C.getAdapter().getItem(i);
            if (c4145vh.v().equals("0")) {
                return;
            }
            Revenue_item_Report_Det revenue_item_Report_Det = Revenue_item_Report_Det.this;
            revenue_item_Report_Det.i.l9(revenue_item_Report_Det, c4145vh.v(), c4145vh.t().replaceAll("-", ""), Revenue_item_Report_Det.this.n);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Revenue_item_Report_Det revenue_item_Report_Det = Revenue_item_Report_Det.this;
            Z00 z00 = revenue_item_Report_Det.i;
            ListView listView = revenue_item_Report_Det.C;
            String strIc = z00.ic(revenue_item_Report_Det.a0);
            Revenue_item_Report_Det revenue_item_Report_Det2 = Revenue_item_Report_Det.this;
            z00.Jb(listView, strIc, true, revenue_item_Report_Det2.W, revenue_item_Report_Det2.X, revenue_item_Report_Det2.getString(R.string.item));
            Message message = new Message();
            message.obj = "1";
            Revenue_item_Report_Det.this.P.sendMessage(message);
        }
    }

    public class j extends WebViewClient {
        public j() {
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

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revenue_item_Report_Det.this.showDialog(0);
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revenue_item_Report_Det.this.showDialog(4);
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Revenue_item_Report_Det revenue_item_Report_Det = Revenue_item_Report_Det.this;
                revenue_item_Report_Det.V = 0;
                revenue_item_Report_Det.M();
            } catch (Exception unused) {
            }
        }
    }

    public class p implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public p(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Revenue_item_Report_Det revenue_item_Report_Det = Revenue_item_Report_Det.this;
                revenue_item_Report_Det.V = 1;
                if (revenue_item_Report_Det.Y.getText() == null) {
                    Revenue_item_Report_Det.this.W = "";
                } else {
                    Revenue_item_Report_Det revenue_item_Report_Det2 = Revenue_item_Report_Det.this;
                    revenue_item_Report_Det2.W = revenue_item_Report_Det2.Y.getText().toString();
                }
                if (Revenue_item_Report_Det.this.Z.getText() == null) {
                    Revenue_item_Report_Det.this.X = "";
                } else {
                    Revenue_item_Report_Det revenue_item_Report_Det3 = Revenue_item_Report_Det.this;
                    revenue_item_Report_Det3.X = revenue_item_Report_Det3.Z.getText().toString();
                }
                Revenue_item_Report_Det.this.M();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class q implements SearchView.OnQueryTextListener {
        public q() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Revenue_item_Report_Det.this.K(1);
            }
            Revenue_item_Report_Det.this.Q(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Revenue_item_Report_Det.this.K(0);
            return false;
        }
    }

    public class r implements DatePickerDialog.OnDateSetListener {
        public r() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Revenue_item_Report_Det.this.S = i;
            Revenue_item_Report_Det.this.T = i2;
            Revenue_item_Report_Det.this.U = i3;
            try {
                String str = Revenue_item_Report_Det.this.S + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_item_Report_Det.this.T + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_item_Report_Det.this.U));
                Locale locale = Locale.ENGLISH;
                Revenue_item_Report_Det.this.Y.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class s implements DatePickerDialog.OnDateSetListener {
        public s() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Revenue_item_Report_Det.this.S = i;
            Revenue_item_Report_Det.this.T = i2;
            Revenue_item_Report_Det.this.U = i3;
            try {
                String str = Revenue_item_Report_Det.this.S + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_item_Report_Det.this.T + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_item_Report_Det.this.U));
                Locale locale = Locale.ENGLISH;
                Revenue_item_Report_Det.this.Z.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    private void S(List list) {
        Collections.sort(list, Collections.reverseOrder(new b()));
    }

    private void W(List list) {
        Collections.sort(list, Collections.reverseOrder(new a()));
    }

    public void H() {
        try {
            this.V = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.Y = (TextView) viewInflate.findViewById(R.id.f_date);
            this.Z = (TextView) viewInflate.findViewById(R.id.t_date);
            this.Y.setOnClickListener(new l());
            this.Z.setOnClickListener(new m());
            builder.setPositiveButton(getString(R.string.btn_search), new n());
            builder.setNegativeButton(getString(R.string.btn_cancel), new o());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new p(alertDialogCreate));
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

    public void J(Cursor cursor) {
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rev1, this.F, 4);
        this.E = c0922Sv;
        c0922Sv.l.clear();
        this.E.notifyDataSetChanged();
        this.C.setAdapter((ListAdapter) this.E);
        this.L.setText(this.i.P7(String.valueOf(this.v)) + this.q);
    }

    public void K(int i2) {
        try {
            if (i2 == 1) {
                this.L.setText(this.i.P7(String.valueOf(this.v)) + this.q);
            } else {
                this.L.setText(this.i.P7(String.valueOf(N(this.E.e))) + this.q);
            }
        } catch (Exception unused) {
        }
    }

    public void L() {
        Cursor cursorO6;
        this.Q = null;
        if (this.V == 0) {
            cursorO6 = this.i.O6(this.n, this.l, this.W, this.X);
        } else {
            boolean zIsEmpty = this.W.isEmpty();
            String str = CSS.Value.PERCENTAGE;
            this.W = zIsEmpty ? CSS.Value.PERCENTAGE : this.W;
            if (!this.X.isEmpty()) {
                str = this.X;
            }
            this.X = str;
            cursorO6 = this.i.O6(this.n, this.l, this.W, str);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorO6.getCount()));
        this.v = 0.0d;
        this.F.clear();
        cursorO6.moveToFirst();
        while (!cursorO6.isAfterLast()) {
            this.v += Double.parseDouble(cursorO6.getString(cursorO6.getColumnIndex("f5")));
            this.F.add(new C4145vh(cursorO6.getString(cursorO6.getColumnIndex("_id")), cursorO6.getString(cursorO6.getColumnIndex("f1")), this.i.P7(cursorO6.getString(cursorO6.getColumnIndex("f2"))), this.i.P7(cursorO6.getString(cursorO6.getColumnIndex("f3"))), this.i.P7(cursorO6.getString(cursorO6.getColumnIndex("f4"))), this.i.P7(cursorO6.getString(cursorO6.getColumnIndex("f5"))), this.i.P7(cursorO6.getString(cursorO6.getColumnIndex("f6"))), cursorO6.getString(cursorO6.getColumnIndex("f7")), cursorO6.getString(cursorO6.getColumnIndex("f8"))));
            cursorO6.moveToNext();
        }
        cursorO6.close();
    }

    public void M() {
        V(true);
        new Thread(new g()).start();
    }

    public double N(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).q().replaceAll(",", ""));
        }
        return d2;
    }

    public void O(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.A));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
        finish();
    }

    public void P() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        TextView textView5 = (TextView) findViewById(R.id.f5);
        textView.setText(getString(R.string.date));
        textView2.setText(getString(R.string.qty));
        textView3.setText(getString(R.string.sales_price));
        textView4.setText(getString(R.string.purchase_price2));
        textView5.setText(getString(R.string.revenue));
        textView2.setOnClickListener(new c());
    }

    public void Q(String str) {
        this.E.getFilter().filter(str);
    }

    public void R() {
        V(true);
        new Thread(new i()).start();
    }

    public void T(boolean z) {
    }

    public void U() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new j());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new k());
        builder.show();
    }

    public void V(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z) {
            android.app.AlertDialog alertDialogCreate = builder.create();
            this.O = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.O;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void add_btn(View view) {
        Bill_edit.P2 = true;
        this.i.z(this, this.j, this.k);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public void btn_add(View view) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.N = textView.getText().toString();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new d(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new e());
        builder.create().show();
    }

    public void help_btn(View view) {
        U();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.N.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.N + "'");
            }
            this.N = "";
            M();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.V = 0;
        M();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_rev1);
        setTitle(getIntent().getStringExtra("title_"));
        this.C = (ListView) findViewById(R.id.list_items);
        this.C.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        this.C.setOnItemClickListener(new h());
        this.L = (TextView) findViewById(R.id.footer_sum);
        P();
        try {
            this.l = getIntent().getStringExtra("item_name");
            this.n = getIntent().getStringExtra("br_name");
            this.W = getIntent().getStringExtra("f_date");
            this.X = getIntent().getStringExtra("t_date");
            this.p = getIntent().getIntExtra("size", 0);
            this.j = getIntent().getStringExtra("g_id");
            this.k = getIntent().getStringExtra("g_name");
            setTitle(getIntent().getStringExtra("title_"));
            this.q = getIntent().getStringExtra("unit_name");
            Log.d("unit_name=", this.q + "");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.S = calendar.get(1);
        this.T = calendar.get(2);
        this.U = calendar.get(5);
        T(true);
        M();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.b0, this.S, this.T, this.U);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.c0, this.S, this.T, this.U);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new q());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        J(this.i.L2());
        T(true);
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
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            I();
        }
        this.a0 = getTitle().toString();
        R();
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

    public void sort_name_click(View view) {
        if (this.M == 0) {
            W(this.F);
            this.E.notifyDataSetChanged();
            this.M = 1;
        } else {
            S(this.F);
            this.E.notifyDataSetChanged();
            this.M = 0;
        }
    }
}
