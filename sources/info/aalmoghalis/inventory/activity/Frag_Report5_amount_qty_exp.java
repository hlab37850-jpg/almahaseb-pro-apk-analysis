package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.C0566Hd;
import defpackage.C3467nL;
import defpackage.C3549oL;
import defpackage.C3631pL;
import defpackage.QC;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Frag_Report5_amount_qty_exp extends BaseActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<ArrayList<C3549oL>> {
    public int I;
    public int J;
    public int K;
    public SQLiteDatabase c;
    public Z00 d;
    public ExpandableListView n;
    public QC p;
    public double e = 0.0d;
    public double f = 0.0d;
    public int g = 0;
    public int h = 1;
    public AutoCompleteTextView i = null;
    public EditText j = null;
    public EditText k = null;
    public Button l = null;
    public ArrayList q = new ArrayList();
    public LinkedHashMap t = new LinkedHashMap();
    public ImageView u = null;
    public TextView v = null;
    public ImageButton w = null;
    public String[] x = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] y = {R.drawable.up, 1, R.drawable.down};
    public TextView z = null;
    public TextView A = null;
    public TextView B = null;
    public TextView C = null;
    public TextView D = null;
    public ExpandableListView.OnChildClickListener E = new k();
    public ExpandableListView.OnGroupClickListener F = new l();
    public DatePickerDialog.OnDateSetListener G = new o();
    public DatePickerDialog.OnDateSetListener H = new p();
    public int L = 0;
    public String M = CSS.Value.PERCENTAGE;
    public String N = CSS.Value.PERCENTAGE;
    public TextView O = null;
    public TextView P = null;
    public int Q = 0;
    public ArrayList R = new ArrayList();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Frag_Report5_amount_qty_exp frag_Report5_amount_qty_exp = Frag_Report5_amount_qty_exp.this;
                frag_Report5_amount_qty_exp.L = 0;
                frag_Report5_amount_qty_exp.M();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public c(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Frag_Report5_amount_qty_exp frag_Report5_amount_qty_exp = Frag_Report5_amount_qty_exp.this;
                frag_Report5_amount_qty_exp.L = 1;
                if (frag_Report5_amount_qty_exp.O.getText() == null) {
                    Frag_Report5_amount_qty_exp.this.M = "";
                } else {
                    Frag_Report5_amount_qty_exp frag_Report5_amount_qty_exp2 = Frag_Report5_amount_qty_exp.this;
                    frag_Report5_amount_qty_exp2.M = frag_Report5_amount_qty_exp2.O.getText().toString();
                }
                if (Frag_Report5_amount_qty_exp.this.P.getText() == null) {
                    Frag_Report5_amount_qty_exp.this.N = "";
                } else {
                    Frag_Report5_amount_qty_exp frag_Report5_amount_qty_exp3 = Frag_Report5_amount_qty_exp.this;
                    frag_Report5_amount_qty_exp3.N = frag_Report5_amount_qty_exp3.P.getText().toString();
                }
                Frag_Report5_amount_qty_exp.this.M();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class d implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL2.k()).compareTo(String.valueOf(c3549oL.k()));
        }
    }

    public class e implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL.k()).compareTo(String.valueOf(c3549oL2.k()));
        }
    }

    public class f implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL2.f()).compareTo(String.valueOf(c3549oL.f()));
        }
    }

    public class g implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL.f()).compareTo(String.valueOf(c3549oL2.f()));
        }
    }

    public class h extends WebViewClient {
        public h() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('5','6','0')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class j implements ExpandableListView.OnGroupExpandListener {
        public int a = -1;

        public j() {
        }

        @Override // android.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i) {
            if (i != this.a) {
                Frag_Report5_amount_qty_exp.this.n.collapseGroup(this.a);
            }
            this.a = i;
        }
    }

    public class k implements ExpandableListView.OnChildClickListener {
        public k() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            return false;
        }
    }

    public class l implements ExpandableListView.OnGroupClickListener {
        public l() {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            C3549oL c3549oL = (C3549oL) Frag_Report5_amount_qty_exp.this.p.b.get(i);
            ((C3549oL) Frag_Report5_amount_qty_exp.this.p.b.get(i)).n(Frag_Report5_amount_qty_exp.this.N(c3549oL.k(), c3549oL.i()));
            Frag_Report5_amount_qty_exp.this.p.notifyDataSetChanged();
            return false;
        }
    }

    public class m implements SearchView.OnQueryTextListener {
        public m() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            TextUtils.isEmpty(str);
            Frag_Report5_amount_qty_exp.this.setSupportProgressBarIndeterminateVisibility(true);
            Frag_Report5_amount_qty_exp.this.S(str);
            Frag_Report5_amount_qty_exp.this.setSupportProgressBarIndeterminateVisibility(false);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Frag_Report5_amount_qty_exp.this.J();
            return false;
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class o implements DatePickerDialog.OnDateSetListener {
        public o() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Frag_Report5_amount_qty_exp.this.I = i;
            Frag_Report5_amount_qty_exp.this.J = i2;
            Frag_Report5_amount_qty_exp.this.K = i3;
            try {
                String str = Frag_Report5_amount_qty_exp.this.I + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report5_amount_qty_exp.this.J + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report5_amount_qty_exp.this.K));
                Locale locale = Locale.ENGLISH;
                Frag_Report5_amount_qty_exp.this.O.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Frag_Report5_amount_qty_exp frag_Report5_amount_qty_exp = Frag_Report5_amount_qty_exp.this;
                frag_Report5_amount_qty_exp.M = frag_Report5_amount_qty_exp.O.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    public class p implements DatePickerDialog.OnDateSetListener {
        public p() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Frag_Report5_amount_qty_exp.this.I = i;
            Frag_Report5_amount_qty_exp.this.J = i2;
            Frag_Report5_amount_qty_exp.this.K = i3;
            try {
                String str = Frag_Report5_amount_qty_exp.this.I + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report5_amount_qty_exp.this.J + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report5_amount_qty_exp.this.K));
                Locale locale = Locale.ENGLISH;
                Frag_Report5_amount_qty_exp.this.P.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Frag_Report5_amount_qty_exp frag_Report5_amount_qty_exp = Frag_Report5_amount_qty_exp.this;
                frag_Report5_amount_qty_exp.N = frag_Report5_amount_qty_exp.P.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Frag_Report5_amount_qty_exp.this.showDialog(0);
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Frag_Report5_amount_qty_exp.this.showDialog(4);
        }
    }

    public static class s implements Comparator {
        public s() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL.l()).compareTo(Double.valueOf(c3549oL2.l()));
        }

        public /* synthetic */ s(j jVar) {
            this();
        }
    }

    public static class t implements Comparator {
        public t() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL2.l()).compareTo(Double.valueOf(c3549oL.l()));
        }

        public /* synthetic */ t(j jVar) {
            this();
        }
    }

    public static class u implements Comparator {
        public u() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL.a().replaceAll(",", "")).compareTo(Double.valueOf(c3549oL2.a().replaceAll(",", "")));
        }

        public /* synthetic */ u(j jVar) {
            this();
        }
    }

    public static class v implements Comparator {
        public v() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL2.a().replaceAll(",", "")).compareTo(Double.valueOf(c3549oL.a().replaceAll(",", "")));
        }

        public /* synthetic */ v(j jVar) {
            this();
        }
    }

    private void H(String str) {
        new AlertDialog.Builder(this).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new n()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        int groupCount = this.p.getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            this.n.collapseGroup(i2);
        }
    }

    private void K() {
        getSupportLoaderManager().initLoader(Calendar.getInstance().get(14), null, this).forceLoad();
    }

    private boolean P(int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= i2 && i4 <= i3;
    }

    private boolean Q() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && P(21, 22);
    }

    private void T(List list) {
        Collections.sort(this.q, new u(null));
    }

    private void U(List list) {
        Collections.sort(this.q, new s(null));
    }

    private void V(List list) {
        Collections.sort(list, Collections.reverseOrder(new e()));
    }

    private void W(List list) {
        Collections.sort(list, Collections.reverseOrder(new g()));
    }

    private void X() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void Y(List list) {
        Collections.sort(this.q, new v(null));
    }

    private void Z(List list) {
        Collections.sort(this.q, new t(null));
    }

    private void a0(List list) {
        Collections.sort(list, Collections.reverseOrder(new d()));
    }

    private void b0(List list) {
        Collections.sort(list, Collections.reverseOrder(new f()));
    }

    public void G() {
        try {
            this.L = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.O = (TextView) viewInflate.findViewById(R.id.f_date);
            this.P = (TextView) viewInflate.findViewById(R.id.t_date);
            this.O.setOnClickListener(new q());
            this.P.setOnClickListener(new r());
            builder.setPositiveButton(getString(R.string.btn_search), new a());
            builder.setNegativeButton(getString(R.string.btn_cancel), new b());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new c(alertDialogCreate));
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

    public void L(Cursor cursor) {
        cursor.getCount();
        this.e = 0.0d;
        this.q.clear();
        C0566Hd c0566Hd = new C0566Hd();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.e += Double.parseDouble(cursor.getString(cursor.getColumnIndex("net_qty")));
            this.f = 0.0d;
            double d2 = Double.parseDouble(cursor.getString(cursor.getColumnIndex("s_amount"))) - Double.parseDouble(cursor.getString(cursor.getColumnIndex("s_qty_cost")));
            this.f = d2;
            this.q.add(new C3549oL(this.d.P7(String.valueOf(d2)), cursor.getString(c0566Hd.b(cursor, "br_name")), cursor.getString(c0566Hd.b(cursor, "curr_name")), this.d.P7(cursor.getString(c0566Hd.b(cursor, "p_amount"))), this.d.P7(cursor.getString(c0566Hd.b(cursor, "s_amount"))), this.d.P7(cursor.getString(c0566Hd.b(cursor, "s_qty_cost"))), this.d.P7(cursor.getString(c0566Hd.b(cursor, "net_qty")))));
            cursor.moveToNext();
        }
        cursor.close();
        QC qc = new QC(this, this.q);
        this.p = qc;
        this.n.setAdapter(qc);
        this.v.setText(this.d.P7(String.valueOf(this.e)));
    }

    public void M() {
        if (this.L == 0) {
            L(this.d.Ac());
            return;
        }
        boolean zIsEmpty = this.M.isEmpty();
        String str = CSS.Value.PERCENTAGE;
        this.M = zIsEmpty ? CSS.Value.PERCENTAGE : this.M;
        if (!this.N.isEmpty()) {
            str = this.N;
        }
        this.N = str;
        L(this.d.Bc(this.M, str));
    }

    public ArrayList N(String str, String str2) {
        Cursor cursorCc;
        ArrayList arrayList = new ArrayList();
        int i2 = this.L;
        String str3 = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorCc = this.d.Cc(str, str2, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            this.M = this.M.isEmpty() ? CSS.Value.PERCENTAGE : this.M;
            if (!this.N.isEmpty()) {
                str3 = this.N;
            }
            this.N = str3;
            cursorCc = this.d.Cc(str, str2, this.M, str3);
        }
        C0566Hd c0566Hd = new C0566Hd();
        cursorCc.moveToFirst();
        while (!cursorCc.isAfterLast()) {
            arrayList.add(new C3467nL(cursorCc.getString(c0566Hd.b(cursorCc, "_id")), cursorCc.getString(c0566Hd.b(cursorCc, "item_name")), this.d.P7(cursorCc.getString(c0566Hd.b(cursorCc, "net_qty_cost"))), this.d.P7(cursorCc.getString(c0566Hd.b(cursorCc, "cost_avg"))), this.d.P7(cursorCc.getString(c0566Hd.b(cursorCc, "s_qty"))), this.d.P7(cursorCc.getString(c0566Hd.b(cursorCc, "net_qty")))));
            cursorCc.moveToNext();
        }
        c0566Hd.a();
        cursorCc.close();
        return arrayList;
    }

    public double O(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C3549oL) list.get(i2)).c().replaceAll(",", ""));
        }
        return d2;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, ArrayList arrayList) {
        try {
            Log.d("trace_E_Loader1_mon=", FragmentStatePagerSupport_Main.X());
            this.q = arrayList;
            this.n.setEmptyView(this.D);
            QC qc = new QC(this, this.q);
            this.p = qc;
            this.n.setAdapter(qc);
            Log.d("trace_E_Loader1_mon=", FragmentStatePagerSupport_Main.X());
            this.v.setText(this.d.P7(String.valueOf(O(this.q))));
        } catch (Exception e2) {
            Log.d("load_finish_err", e2.getMessage());
        }
    }

    public void S(String str) {
        this.p.getFilter().filter(str);
    }

    public void amount_add_btn(View view) {
    }

    public void help_btn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new h());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new i());
        builder.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        J();
        switch (view.getId()) {
            case R.id.action_type /* 2131296354 */:
                sort_tr_type_click(view);
                break;
            case R.id.customer_name /* 2131296605 */:
                sort_name_click(view);
                break;
            case R.id.item_curr /* 2131296912 */:
                sort_tr_days_click(view);
                break;
            case R.id.total_amount /* 2131297454 */:
                sort_amount_click(view);
                break;
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.report_listview_layout_exp5);
        X();
        this.d = new Z00(this.c, this);
        this.v = (TextView) findViewById(R.id.balance);
        this.z = (TextView) findViewById(R.id.branch_name);
        this.A = (TextView) findViewById(R.id.total_amount);
        this.B = (TextView) findViewById(R.id.item_curr);
        this.C = (TextView) findViewById(R.id.action_type);
        this.n = (ExpandableListView) findViewById(R.id.list_report);
        this.D = (TextView) findViewById(R.id.emptyResults);
        this.n.setOnChildClickListener(this.E);
        this.n.setOnGroupClickListener(this.F);
        this.n.setOnGroupExpandListener(new j());
        try {
            if (getIntent().getIntExtra("TR_TYPE", -1) != -1) {
                this.h = getIntent().getIntExtra("TR_TYPE", 0);
                setTitle(getResources().getStringArray(R.array.action_3)[this.h]);
            }
            K();
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.I = calendar.get(1);
        this.J = calendar.get(2);
        this.K = calendar.get(5);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(Q() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.G, this.I, this.J, this.K);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(Q() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.H, this.I, this.J, this.K);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<ArrayList<C3549oL>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_Loader1_g=", FragmentStatePagerSupport_Main.X());
        return new C3631pL(this, "", "", this.d, 5);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new m());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<ArrayList<C3549oL>> loader) {
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.print) {
            if (itemId == R.id.adv_search) {
                G();
                return true;
            }
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            finish();
            return true;
        }
        if (Build.VERSION.SDK_INT < 31) {
            I();
        }
        String string = getTitle().toString();
        J();
        Z00 z00 = this.d;
        z00.hb(this.n, z00.ic(string));
        this.d.ra(this.d.ic(string) + ".pdf");
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            H(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void sort_amount_click(View view) {
        if (this.Q == 0) {
            T(this.q);
            this.p.notifyDataSetChanged();
            this.Q = 1;
        } else {
            Y(this.q);
            this.p.notifyDataSetChanged();
            this.Q = 0;
        }
    }

    public void sort_name_click(View view) {
        if (this.Q == 0) {
            a0(this.q);
            this.p.notifyDataSetChanged();
            this.Q = 1;
        } else {
            V(this.q);
            this.p.notifyDataSetChanged();
            this.Q = 0;
        }
    }

    public void sort_tr_days_click(View view) {
        if (this.Q == 0) {
            Z(this.q);
            this.p.notifyDataSetChanged();
            this.Q = 1;
        } else {
            U(this.q);
            this.p.notifyDataSetChanged();
            this.Q = 0;
        }
    }

    public void sort_tr_type_click(View view) {
        if (this.Q == 0) {
            b0(this.q);
            this.p.notifyDataSetChanged();
            this.Q = 1;
        } else {
            W(this.q);
            this.p.notifyDataSetChanged();
            this.Q = 0;
        }
    }
}
