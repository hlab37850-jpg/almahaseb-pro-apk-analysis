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
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.C0566Hd;
import defpackage.C3467nL;
import defpackage.C3549oL;
import defpackage.C3631pL;
import defpackage.OC;
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
public class Frag_Report2_amount_exp extends BaseActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<ArrayList<C3549oL>> {
    public int H;
    public int I;
    public int J;
    public SQLiteDatabase c;
    public Z00 d;
    public ExpandableListView l;
    public OC n;
    public double e = 0.0d;
    public int f = 0;
    public int g = 1;
    public AutoCompleteTextView h = null;
    public EditText i = null;
    public EditText j = null;
    public Button k = null;
    public ArrayList p = new ArrayList();
    public LinkedHashMap q = new LinkedHashMap();
    public ImageView t = null;
    public TextView u = null;
    public ImageButton v = null;
    public String[] w = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] x = {R.drawable.up, 1, R.drawable.down};
    public TextView y = null;
    public TextView z = null;
    public TextView A = null;
    public TextView B = null;
    public TextView C = null;
    public ExpandableListView.OnChildClickListener D = new k();
    public ExpandableListView.OnGroupClickListener E = new l();
    public DatePickerDialog.OnDateSetListener F = new o();
    public DatePickerDialog.OnDateSetListener G = new p();
    public int K = 0;
    public String L = CSS.Value.PERCENTAGE;
    public String M = CSS.Value.PERCENTAGE;
    public TextView N = null;
    public TextView O = null;
    public int P = 0;
    public ArrayList Q = new ArrayList();

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
                Frag_Report2_amount_exp frag_Report2_amount_exp = Frag_Report2_amount_exp.this;
                frag_Report2_amount_exp.K = 0;
                frag_Report2_amount_exp.M();
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
                Frag_Report2_amount_exp frag_Report2_amount_exp = Frag_Report2_amount_exp.this;
                frag_Report2_amount_exp.K = 1;
                if (frag_Report2_amount_exp.N.getText() == null) {
                    Frag_Report2_amount_exp.this.L = "";
                } else {
                    Frag_Report2_amount_exp frag_Report2_amount_exp2 = Frag_Report2_amount_exp.this;
                    frag_Report2_amount_exp2.L = frag_Report2_amount_exp2.N.getText().toString();
                }
                if (Frag_Report2_amount_exp.this.O.getText() == null) {
                    Frag_Report2_amount_exp.this.M = "";
                } else {
                    Frag_Report2_amount_exp frag_Report2_amount_exp3 = Frag_Report2_amount_exp.this;
                    frag_Report2_amount_exp3.M = frag_Report2_amount_exp3.O.getText().toString();
                }
                Frag_Report2_amount_exp.this.M();
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
                Frag_Report2_amount_exp.this.l.collapseGroup(this.a);
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
            C3549oL c3549oL = (C3549oL) Frag_Report2_amount_exp.this.n.b.get(i);
            C3549oL c3549oL2 = (C3549oL) Frag_Report2_amount_exp.this.n.b.get(i);
            Frag_Report2_amount_exp frag_Report2_amount_exp = Frag_Report2_amount_exp.this;
            c3549oL2.n(frag_Report2_amount_exp.N(String.valueOf(frag_Report2_amount_exp.g), c3549oL.k(), c3549oL.h(), c3549oL.m()));
            Frag_Report2_amount_exp.this.n.notifyDataSetChanged();
            return false;
        }
    }

    public class m implements SearchView.OnQueryTextListener {
        public m() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            TextUtils.isEmpty(str);
            Frag_Report2_amount_exp.this.setSupportProgressBarIndeterminateVisibility(true);
            Frag_Report2_amount_exp.this.S(str);
            Frag_Report2_amount_exp.this.setSupportProgressBarIndeterminateVisibility(false);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Frag_Report2_amount_exp.this.J();
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
            Frag_Report2_amount_exp.this.H = i;
            Frag_Report2_amount_exp.this.I = i2;
            Frag_Report2_amount_exp.this.J = i3;
            try {
                String str = Frag_Report2_amount_exp.this.H + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report2_amount_exp.this.I + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report2_amount_exp.this.J));
                Locale locale = Locale.ENGLISH;
                Frag_Report2_amount_exp.this.N.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Frag_Report2_amount_exp frag_Report2_amount_exp = Frag_Report2_amount_exp.this;
                frag_Report2_amount_exp.L = frag_Report2_amount_exp.N.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    public class p implements DatePickerDialog.OnDateSetListener {
        public p() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Frag_Report2_amount_exp.this.H = i;
            Frag_Report2_amount_exp.this.I = i2;
            Frag_Report2_amount_exp.this.J = i3;
            try {
                String str = Frag_Report2_amount_exp.this.H + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report2_amount_exp.this.I + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report2_amount_exp.this.J));
                Locale locale = Locale.ENGLISH;
                Frag_Report2_amount_exp.this.O.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Frag_Report2_amount_exp frag_Report2_amount_exp = Frag_Report2_amount_exp.this;
                frag_Report2_amount_exp.M = frag_Report2_amount_exp.O.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Frag_Report2_amount_exp.this.showDialog(0);
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Frag_Report2_amount_exp.this.showDialog(4);
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

    private void X() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void G() {
        try {
            this.K = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.N = (TextView) viewInflate.findViewById(R.id.f_date);
            this.O = (TextView) viewInflate.findViewById(R.id.t_date);
            this.N.setOnClickListener(new q());
            this.O.setOnClickListener(new r());
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

    public final void J() {
        int groupCount = this.n.getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            this.l.collapseGroup(i2);
        }
    }

    public void L(Cursor cursor) {
        cursor.getCount();
        this.e = 0.0d;
        this.p.clear();
        C0566Hd c0566Hd = new C0566Hd();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.e += Double.parseDouble(cursor.getString(cursor.getColumnIndex("tot_amount")));
            C3549oL c3549oL = new C3549oL(cursor.getString(c0566Hd.b(cursor, "_id")), cursor.getString(c0566Hd.b(cursor, "br_name")), "", cursor.getString(c0566Hd.b(cursor, "tot_amount")), cursor.getString(c0566Hd.b(cursor, "curr_name")), cursor.getString(c0566Hd.b(cursor, "type_name")), "0");
            c3549oL.n(N(String.valueOf(this.g), cursor.getString(c0566Hd.b(cursor, "br_name")), cursor.getString(c0566Hd.b(cursor, "curr_name")), cursor.getString(c0566Hd.b(cursor, "type_name"))));
            this.p.add(c3549oL);
            cursor.moveToNext();
        }
        cursor.close();
        OC oc = new OC(this, this.p);
        this.n = oc;
        this.l.setAdapter(oc);
        this.u.setText(this.d.P7(String.valueOf(this.e)));
    }

    public void M() {
        if (this.K == 0) {
            L(this.d.oc(String.valueOf(this.g)));
            return;
        }
        boolean zIsEmpty = this.L.isEmpty();
        String str = CSS.Value.PERCENTAGE;
        this.L = zIsEmpty ? CSS.Value.PERCENTAGE : this.L;
        if (!this.M.isEmpty()) {
            str = this.M;
        }
        this.M = str;
        L(this.d.pc(String.valueOf(this.g), this.L, this.M));
    }

    public ArrayList N(String str, String str2, String str3, String str4) {
        Cursor cursorQc;
        ArrayList arrayList = new ArrayList();
        if (this.K == 0) {
            cursorQc = this.d.qc(str, str2, str4, str3, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            boolean zIsEmpty = this.L.isEmpty();
            String str5 = CSS.Value.PERCENTAGE;
            this.L = zIsEmpty ? CSS.Value.PERCENTAGE : this.L;
            if (!this.M.isEmpty()) {
                str5 = this.M;
            }
            String str6 = str5;
            this.M = str6;
            cursorQc = this.d.qc(str, str2, str4, str3, this.L, str6);
        }
        C0566Hd c0566Hd = new C0566Hd();
        cursorQc.moveToFirst();
        while (!cursorQc.isAfterLast()) {
            arrayList.add(new C3467nL(cursorQc.getString(c0566Hd.b(cursorQc, "_id")), cursorQc.getString(c0566Hd.b(cursorQc, "item_name")), "", this.d.P7(cursorQc.getString(c0566Hd.b(cursorQc, "tot_qty"))), this.d.P7(cursorQc.getString(c0566Hd.b(cursorQc, "item_price"))), "0"));
            cursorQc.moveToNext();
        }
        c0566Hd.a();
        cursorQc.close();
        return arrayList;
    }

    public double O(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C3549oL) list.get(i2)).b().replaceAll(",", ""));
            Log.d("net_bal=", String.valueOf(d2));
        }
        return d2;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, ArrayList arrayList) {
        try {
            Log.d("trace_E_Loader1_mon=", FragmentStatePagerSupport_Main.X());
            this.p = arrayList;
            this.l.setEmptyView(this.C);
            OC oc = new OC(this, this.p);
            this.n = oc;
            this.l.setAdapter(oc);
            Log.d("trace_E_Loader1_mon=", FragmentStatePagerSupport_Main.X());
            this.u.setText(this.d.P7(String.valueOf(O(this.p))));
        } catch (Exception e2) {
            Log.d("load_finish_err", e2.getMessage());
        }
    }

    public void S(String str) {
        this.n.getFilter().filter(str);
    }

    public final void T(List list) {
        Collections.sort(this.p, new u(null));
    }

    public final void U(List list) {
        Collections.sort(this.p, new s(null));
    }

    public final void V(List list) {
        Collections.sort(list, Collections.reverseOrder(new e()));
    }

    public final void W(List list) {
        Collections.sort(list, Collections.reverseOrder(new g()));
    }

    public final void Y(List list) {
        Collections.sort(this.p, new v(null));
    }

    public final void Z(List list) {
        Collections.sort(this.p, new t(null));
    }

    public final void a0(List list) {
        Collections.sort(list, Collections.reverseOrder(new d()));
    }

    public void amount_add_btn(View view) {
    }

    public final void b0(List list) {
        Collections.sort(list, Collections.reverseOrder(new f()));
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
        setContentView(R.layout.report_listview_layout_exp2);
        X();
        this.d = new Z00(this.c, this);
        this.u = (TextView) findViewById(R.id.balance);
        this.y = (TextView) findViewById(R.id.branch_name);
        this.z = (TextView) findViewById(R.id.total_amount);
        this.A = (TextView) findViewById(R.id.item_curr);
        this.B = (TextView) findViewById(R.id.action_type);
        this.l = (ExpandableListView) findViewById(R.id.list_report);
        this.C = (TextView) findViewById(R.id.emptyResults);
        this.l.setOnChildClickListener(this.D);
        this.l.setOnGroupClickListener(this.E);
        this.l.setOnGroupExpandListener(new j());
        try {
            if (getIntent().getIntExtra("TR_TYPE", -1) != -1) {
                this.g = getIntent().getIntExtra("TR_TYPE", 0);
                setTitle(getResources().getStringArray(R.array.action_3)[this.g]);
            }
            K();
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.H = calendar.get(1);
        this.I = calendar.get(2);
        this.J = calendar.get(5);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(Q() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.F, this.H, this.I, this.J);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(Q() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.G, this.H, this.I, this.J);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<ArrayList<C3549oL>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_Loader1_g=", FragmentStatePagerSupport_Main.X());
        return new C3631pL(this, "", "", this.d, this.g + 1);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
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
        String str = getResources().getStringArray(R.array.action_3)[this.g];
        J();
        Z00 z00 = this.d;
        z00.eb(this.l, z00.ic(str));
        this.d.ra(this.d.ic(str) + ".pdf");
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
        if (this.P == 0) {
            T(this.p);
            this.n.notifyDataSetChanged();
            this.P = 1;
        } else {
            Y(this.p);
            this.n.notifyDataSetChanged();
            this.P = 0;
        }
    }

    public void sort_name_click(View view) {
        if (this.P == 0) {
            a0(this.p);
            this.n.notifyDataSetChanged();
            this.P = 1;
        } else {
            V(this.p);
            this.n.notifyDataSetChanged();
            this.P = 0;
        }
    }

    public void sort_tr_days_click(View view) {
        if (this.P == 0) {
            Z(this.p);
            this.n.notifyDataSetChanged();
            this.P = 1;
        } else {
            U(this.p);
            this.n.notifyDataSetChanged();
            this.P = 0;
        }
    }

    public void sort_tr_type_click(View view) {
        if (this.P == 0) {
            b0(this.p);
            this.n.notifyDataSetChanged();
            this.P = 1;
        } else {
            W(this.p);
            this.n.notifyDataSetChanged();
            this.P = 0;
        }
    }
}
