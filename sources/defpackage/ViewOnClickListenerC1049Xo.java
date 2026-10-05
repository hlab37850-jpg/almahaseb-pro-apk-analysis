package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Xo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class ViewOnClickListenerC1049Xo extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<ArrayList<C3549oL>> {
    public x K;
    public ImageView N;
    public ImageView O;
    public int T;
    public int U;
    public int V;
    public Activity f0;
    public SQLiteDatabase g;
    public Z00 h;
    public String i;
    public String j;
    public String k;
    public ExpandableListView v;
    public PC w;
    public double l = 0.0d;
    public int n = 0;
    public AutoCompleteTextView p = null;
    public EditText q = null;
    public EditText t = null;
    public Button u = null;
    public ArrayList x = new ArrayList();
    public LinkedHashMap y = new LinkedHashMap();
    public ImageView z = null;
    public ImageView A = null;
    public ImageView B = null;
    public TextView C = null;
    public ImageButton D = null;
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] F = {R.drawable.up, 1, R.drawable.down};
    public TextView G = null;
    public TextView H = null;
    public TextView I = null;
    public TextView J = null;
    public int L = 0;
    public TextView M = null;
    public ExpandableListView.OnChildClickListener P = new n();
    public ExpandableListView.OnGroupClickListener Q = new o();
    public DatePickerDialog.OnDateSetListener R = new s();
    public DatePickerDialog.OnDateSetListener S = new t();
    public int W = 0;
    public String X = CSS.Value.PERCENTAGE;
    public String Y = CSS.Value.PERCENTAGE;
    public TextView Z = null;
    public TextView a0 = null;
    public int b0 = 0;
    public ArrayList c0 = new ArrayList();
    public LoaderManager.LoaderCallbacks d0 = new i();
    public View.OnClickListener e0 = new m();

    /* JADX INFO: renamed from: Xo$a */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", ViewOnClickListenerC1049Xo.this.T);
                bundle.putInt("month", ViewOnClickListenerC1049Xo.this.U);
                bundle.putInt("day", ViewOnClickListenerC1049Xo.this.V);
                c2137ei.setArguments(bundle);
                c2137ei.f(ViewOnClickListenerC1049Xo.this.S);
                c2137ei.show(ViewOnClickListenerC1049Xo.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(ViewOnClickListenerC1049Xo.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: Xo$c */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ViewOnClickListenerC1049Xo viewOnClickListenerC1049Xo = ViewOnClickListenerC1049Xo.this;
                viewOnClickListenerC1049Xo.W = 0;
                viewOnClickListenerC1049Xo.u();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: Xo$d */
    public class d implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public d(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewOnClickListenerC1049Xo viewOnClickListenerC1049Xo = ViewOnClickListenerC1049Xo.this;
                viewOnClickListenerC1049Xo.W = 1;
                if (viewOnClickListenerC1049Xo.Z.getText() == null) {
                    ViewOnClickListenerC1049Xo.this.X = "";
                } else {
                    ViewOnClickListenerC1049Xo viewOnClickListenerC1049Xo2 = ViewOnClickListenerC1049Xo.this;
                    viewOnClickListenerC1049Xo2.X = viewOnClickListenerC1049Xo2.Z.getText().toString();
                }
                if (ViewOnClickListenerC1049Xo.this.a0.getText() == null) {
                    ViewOnClickListenerC1049Xo.this.Y = "";
                } else {
                    ViewOnClickListenerC1049Xo viewOnClickListenerC1049Xo3 = ViewOnClickListenerC1049Xo.this;
                    viewOnClickListenerC1049Xo3.Y = viewOnClickListenerC1049Xo3.a0.getText().toString();
                }
                ViewOnClickListenerC1049Xo.this.u();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: Xo$e */
    public class e implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL2.k()).compareTo(String.valueOf(c3549oL.k()));
        }
    }

    /* JADX INFO: renamed from: Xo$f */
    public class f implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL.k()).compareTo(String.valueOf(c3549oL2.k()));
        }
    }

    /* JADX INFO: renamed from: Xo$g */
    public class g implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL2.f()).compareTo(String.valueOf(c3549oL.f()));
        }
    }

    /* JADX INFO: renamed from: Xo$h */
    public class h implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL.f()).compareTo(String.valueOf(c3549oL2.f()));
        }
    }

    /* JADX INFO: renamed from: Xo$j */
    public class j implements ExpandableListView.OnGroupExpandListener {
        public int a = -1;

        public j() {
        }

        @Override // android.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i) {
            if (i != this.a) {
                ViewOnClickListenerC1049Xo.this.v.collapseGroup(this.a);
            }
            this.a = i;
        }
    }

    /* JADX INFO: renamed from: Xo$k */
    public class k extends WebViewClient {
        public k() {
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

    /* JADX INFO: renamed from: Xo$l */
    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: Xo$m */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                ViewOnClickListenerC1049Xo.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                ViewOnClickListenerC1049Xo.this.help_btn(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                ViewOnClickListenerC1049Xo.this.K.onButtonClicked(view);
            }
        }
    }

    /* JADX INFO: renamed from: Xo$n */
    public class n implements ExpandableListView.OnChildClickListener {
        public n() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            return false;
        }
    }

    /* JADX INFO: renamed from: Xo$o */
    public class o implements ExpandableListView.OnGroupClickListener {
        public o() {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            ((C3549oL) ViewOnClickListenerC1049Xo.this.w.b.get(i)).n(ViewOnClickListenerC1049Xo.this.v(((C3549oL) ViewOnClickListenerC1049Xo.this.w.b.get(i)).j()));
            ViewOnClickListenerC1049Xo.this.w.notifyDataSetChanged();
            return false;
        }
    }

    /* JADX INFO: renamed from: Xo$p */
    public class p implements SearchView.OnQueryTextListener {
        public p() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                ViewOnClickListenerC1049Xo.this.t(1);
            }
            ViewOnClickListenerC1049Xo.this.y(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            ViewOnClickListenerC1049Xo.this.t(2);
            ViewOnClickListenerC1049Xo.this.q();
            return false;
        }
    }

    /* JADX INFO: renamed from: Xo$q */
    public class q implements MenuItemCompat.OnActionExpandListener {
        public q() {
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            ViewOnClickListenerC1049Xo.this.t(1);
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            ViewOnClickListenerC1049Xo.this.t(1);
            return true;
        }
    }

    /* JADX INFO: renamed from: Xo$s */
    public class s implements DatePickerDialog.OnDateSetListener {
        public s() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                ViewOnClickListenerC1049Xo.this.Z.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                ViewOnClickListenerC1049Xo viewOnClickListenerC1049Xo = ViewOnClickListenerC1049Xo.this;
                viewOnClickListenerC1049Xo.X = viewOnClickListenerC1049Xo.Z.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: Xo$t */
    public class t implements DatePickerDialog.OnDateSetListener {
        public t() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                ViewOnClickListenerC1049Xo.this.a0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                ViewOnClickListenerC1049Xo viewOnClickListenerC1049Xo = ViewOnClickListenerC1049Xo.this;
                viewOnClickListenerC1049Xo.Y = viewOnClickListenerC1049Xo.a0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: Xo$u */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", ViewOnClickListenerC1049Xo.this.T);
                bundle.putInt("month", ViewOnClickListenerC1049Xo.this.U);
                bundle.putInt("day", ViewOnClickListenerC1049Xo.this.V);
                c2137ei.setArguments(bundle);
                c2137ei.f(ViewOnClickListenerC1049Xo.this.R);
                c2137ei.show(ViewOnClickListenerC1049Xo.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: Xo$v */
    public static class v implements Comparator {
        public v() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL.l()).compareTo(Double.valueOf(c3549oL2.l()));
        }

        public /* synthetic */ v(j jVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Xo$w */
    public static class w implements Comparator {
        public w() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL2.l()).compareTo(Double.valueOf(c3549oL.l()));
        }

        public /* synthetic */ w(j jVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Xo$x */
    public interface x {
        void onButtonClicked(View view);
    }

    /* JADX INFO: renamed from: Xo$y */
    public static class y implements Comparator {
        public y() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL.a().replaceAll(",", "")).compareTo(Double.valueOf(c3549oL2.a().replaceAll(",", "")));
        }

        public /* synthetic */ y(j jVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Xo$z */
    public static class z implements Comparator {
        public z() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL2.a().replaceAll(",", "")).compareTo(Double.valueOf(c3549oL.a().replaceAll(",", "")));
        }

        public /* synthetic */ z(j jVar) {
            this();
        }
    }

    public ViewOnClickListenerC1049Xo() {
    }

    private void A(List list) {
        Collections.sort(this.x, new v(null));
    }

    private void B(List list) {
        Collections.sort(list, Collections.reverseOrder(new f()));
    }

    private void C(List list) {
        Collections.sort(list, Collections.reverseOrder(new h()));
    }

    private void D(List list) {
        Collections.sort(this.x, new z(null));
    }

    private void E(List list) {
        Collections.sort(this.x, new w(null));
    }

    private void F(List list) {
        Collections.sort(list, Collections.reverseOrder(new e()));
    }

    private void G(List list) {
        Collections.sort(list, Collections.reverseOrder(new g()));
    }

    private void o(String str) {
        new android.app.AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new r()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        int groupCount = this.w.getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            this.v.collapseGroup(i2);
        }
    }

    private void r() {
        int i2 = Calendar.getInstance().get(14);
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.i + 1) * i2 * 1000000, null, this.d0).forceLoad();
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.i + 1) * i2, null, this).forceLoad();
    }

    private void z(List list) {
        Collections.sort(this.x, new y(null));
    }

    public void H(View view) {
        if (this.b0 == 0) {
            z(this.x);
            this.w.notifyDataSetChanged();
            this.b0 = 1;
        } else {
            D(this.x);
            this.w.notifyDataSetChanged();
            this.b0 = 0;
        }
    }

    public void I(View view) {
        if (this.b0 == 0) {
            F(this.x);
            this.w.notifyDataSetChanged();
            this.b0 = 1;
        } else {
            B(this.x);
            this.w.notifyDataSetChanged();
            this.b0 = 0;
        }
    }

    public void J(View view) {
        if (this.b0 == 0) {
            E(this.x);
            this.w.notifyDataSetChanged();
            this.b0 = 1;
        } else {
            A(this.x);
            this.w.notifyDataSetChanged();
            this.b0 = 0;
        }
    }

    public void K(View view) {
        if (this.b0 == 0) {
            G(this.x);
            this.w.notifyDataSetChanged();
            this.b0 = 1;
        } else {
            C(this.x);
            this.w.notifyDataSetChanged();
            this.b0 = 0;
        }
    }

    public void amount_add_btn(View view) {
        startActivity(new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit.class));
    }

    public void help_btn(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new k());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new l());
        builder.show();
    }

    public void n() {
        try {
            this.W = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.Z = (TextView) viewInflate.findViewById(R.id.f_date);
            this.a0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.Z.setOnClickListener(new u());
            this.a0.setOnClickListener(new a());
            builder.setPositiveButton(getActivity().getString(R.string.btn_search), new b());
            builder.setNegativeButton(getActivity().getString(R.string.btn_cancel), new c());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new d(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f0 = activity;
        try {
            this.K = (x) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q();
        switch (view.getId()) {
            case R.id.balance /* 2131296401 */:
                H(view);
                break;
            case R.id.customer_name /* 2131296605 */:
                I(view);
                break;
            case R.id.days_late /* 2131296612 */:
                J(view);
                break;
            case R.id.img /* 2131296820 */:
                K(view);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new Z00(this.g, getActivity());
            this.i = getArguments() != null ? getArguments().getString("cus_id") : "";
            this.j = getArguments() != null ? getArguments().getString("cus_name") : "";
            this.k = getArguments() != null ? getArguments().getString("curr_name") : "";
            this.L = getArguments() != null ? getArguments().getInt("size") : 0;
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.T = calendar.get(1);
            this.U = calendar.get(2);
            this.V = calendar.get(5);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<ArrayList<C3549oL>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_Loader1_g=", FragmentStatePagerSupport_Main.X() + ":" + this.k + ":" + this.i);
        return new C3631pL(getActivity(), this.i, this.k, this.h, 7);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main3_group_general, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItemFindItem);
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new p());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new q());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.report_listview_layout_exp5_, viewGroup, false);
        this.h = new Z00(this.g, getActivity());
        setHasOptionsMenu(true);
        this.C = (TextView) viewInflate.findViewById(R.id.footer_sum);
        this.G = (TextView) viewInflate.findViewById(R.id.customer_name);
        this.H = (TextView) viewInflate.findViewById(R.id.cr_amount);
        this.I = (TextView) viewInflate.findViewById(R.id.db_amount);
        this.H.setText(this.h.c5());
        this.I.setText(this.h.Q2());
        this.J = (TextView) viewInflate.findViewById(R.id.net_balance);
        this.A = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
        this.B = (ImageView) viewInflate.findViewById(R.id.img_help);
        this.A.setOnClickListener(this.e0);
        this.B.setOnClickListener(this.e0);
        this.N = (ImageView) viewInflate.findViewById(R.id.move_right);
        this.O = (ImageView) viewInflate.findViewById(R.id.move_left);
        this.N.setOnClickListener(this.e0);
        this.O.setOnClickListener(this.e0);
        if (this.L <= 1) {
            this.N.setVisibility(8);
            this.O.setVisibility(8);
        }
        this.v = (ExpandableListView) viewInflate.findViewById(R.id.list_report);
        this.M = (TextView) viewInflate.findViewById(R.id.emptyResults);
        this.v.setGroupIndicator(null);
        this.v.setOnChildClickListener(this.P);
        this.v.setOnGroupClickListener(this.Q);
        this.v.setOnGroupExpandListener(new j());
        try {
            r();
        } catch (Exception unused) {
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str;
        int itemId = menuItem.getItemId();
        if (itemId != R.id.print) {
            if (itemId == R.id.adv_search) {
                n();
                return true;
            }
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            getActivity().finish();
            return true;
        }
        if (Build.VERSION.SDK_INT < 31) {
            p();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getActivity().getString(R.string.action_report_groups));
        if (Z00.Z) {
            str = "-" + this.k;
        } else {
            str = "";
        }
        sb.append(str);
        String string = sb.toString();
        q();
        Z00 z00 = this.h;
        z00.Gb(this.v, z00.ic(string), w(this.w.b), this.k);
        this.h.ra(this.h.ic(string) + ".pdf");
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            o(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    public void p() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void s(Cursor cursor) {
        cursor.getCount();
        this.x.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            C3549oL c3549oL = new C3549oL(cursor.getString(cursor.getColumnIndex(HTML.Attribute.ID)), cursor.getString(cursor.getColumnIndex("_id")), "", cursor.getString(cursor.getColumnIndex("cr_amount")), cursor.getString(cursor.getColumnIndex("db_amount")), cursor.getString(cursor.getColumnIndex("net_balance")), !Z00.Z ? "" : cursor.getString(cursor.getColumnIndex("curr_name")));
            c3549oL.n(v(cursor.getString(cursor.getColumnIndex(HTML.Attribute.ID))));
            this.x.add(c3549oL);
            cursor.moveToNext();
        }
        cursor.close();
        PC pc = new PC(getActivity(), this.x);
        this.w = pc;
        this.v.setAdapter(pc);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
    }

    public void t(int i2) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        if (this.W == 1) {
            double dW = w(this.w.b);
            this.C.setText(getString(R.string.footer_filter) + numberFormat.format(dW));
            return;
        }
        String str = "";
        if (i2 != 1) {
            if (i2 == 2) {
                double dW2 = w(this.w.b);
                if (dW2 >= 0.0d) {
                    TextView textView = this.C;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.h.c5());
                    sb.append(": ");
                    sb.append(numberFormat.format(dW2));
                    if (Z00.Z) {
                        str = "\t" + this.k;
                    }
                    sb.append(str);
                    textView.setText(sb.toString());
                    return;
                }
                TextView textView2 = this.C;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.h.Q2());
                sb2.append(": ");
                sb2.append(numberFormat.format(Math.abs(dW2)));
                if (Z00.Z) {
                    str = "\t" + this.k;
                }
                sb2.append(str);
                textView2.setText(sb2.toString());
                return;
            }
            return;
        }
        this.C.setText(getString(R.string.footer_cus_null));
        try {
            ArrayList arrayListD4 = this.h.d4(this.k);
            if (arrayListD4.size() > 0) {
                if (Double.parseDouble((String) arrayListD4.get(0)) >= 0.0d) {
                    TextView textView3 = this.C;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.h.c5());
                    sb3.append(": ");
                    sb3.append(numberFormat.format(Double.parseDouble((String) arrayListD4.get(0))));
                    if (Z00.Z) {
                        str = "\t" + this.k;
                    }
                    sb3.append(str);
                    textView3.setText(sb3.toString());
                    return;
                }
                TextView textView4 = this.C;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.h.Q2());
                sb4.append(": ");
                sb4.append(numberFormat.format(Math.abs(Double.parseDouble((String) arrayListD4.get(0)))));
                if (Z00.Z) {
                    str = "\t" + this.k;
                }
                sb4.append(str);
                textView4.setText(sb4.toString());
            }
        } catch (Exception unused) {
        }
    }

    public void u() {
        int i2 = this.W;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            s(this.h.uc(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.k));
        } else {
            this.X = this.X.isEmpty() ? CSS.Value.PERCENTAGE : this.X;
            if (!this.Y.isEmpty()) {
                str = this.Y;
            }
            this.Y = str;
            s(this.h.uc(this.X, str, this.k));
        }
        t(1);
    }

    public ArrayList v(String str) {
        Cursor cursorZc;
        ArrayList arrayList = new ArrayList();
        int i2 = this.W;
        String str2 = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorZc = this.h.zc(str, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.k);
        } else {
            this.X = this.X.isEmpty() ? CSS.Value.PERCENTAGE : this.X;
            if (!this.Y.isEmpty()) {
                str2 = this.Y;
            }
            this.Y = str2;
            cursorZc = this.h.zc(str, this.X, str2, this.k);
        }
        C0566Hd c0566Hd = new C0566Hd();
        cursorZc.moveToFirst();
        while (!cursorZc.isAfterLast()) {
            arrayList.add(new C3467nL(cursorZc.getString(c0566Hd.b(cursorZc, HTML.Attribute.ID)), cursorZc.getString(c0566Hd.b(cursorZc, "_id")), cursorZc.getString(c0566Hd.b(cursorZc, "gsm")), cursorZc.getString(c0566Hd.b(cursorZc, "cr_amount")), cursorZc.getString(c0566Hd.b(cursorZc, "db_amount")), cursorZc.getString(c0566Hd.b(cursorZc, "net_balance"))));
            cursorZc.moveToNext();
        }
        c0566Hd.a();
        cursorZc.close();
        return arrayList;
    }

    public double w(List list) {
        double d2 = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            d2 += Double.parseDouble(((C3549oL) list.get(size)).l().replaceAll(",", "")) * (-1.0d);
        }
        return d2;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, ArrayList arrayList) {
        try {
            Log.d("trace_E_Loader1_mon=", FragmentStatePagerSupport_Main.X() + ":" + this.k + ":" + this.i);
            this.x = arrayList;
            this.v.setEmptyView(this.M);
            PC pc = new PC(getActivity(), this.x);
            this.w = pc;
            this.v.setAdapter(pc);
            Log.d("trace_E_Loader1_mon=", FragmentStatePagerSupport_Main.X() + ":" + this.k + ":" + this.i);
        } catch (Exception unused) {
        }
    }

    public void y(String str) {
        try {
            this.w.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: Xo$i */
    public class i implements LoaderManager.LoaderCallbacks {
        public i() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader loader, List list) {
            ViewOnClickListenerC1049Xo.this.c0 = (ArrayList) list;
            Log.d("trace_E_Loader2_h=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC1049Xo.this.k + ":" + ViewOnClickListenerC1049Xo.this.i);
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
            try {
                if (ViewOnClickListenerC1049Xo.this.c0.size() > 0) {
                    String str = "";
                    if (Double.parseDouble((String) ViewOnClickListenerC1049Xo.this.c0.get(0)) >= 0.0d) {
                        TextView textView = ViewOnClickListenerC1049Xo.this.C;
                        StringBuilder sb = new StringBuilder();
                        sb.append(ViewOnClickListenerC1049Xo.this.h.c5());
                        sb.append(":");
                        sb.append(numberFormat.format(Math.abs(Double.parseDouble((String) ViewOnClickListenerC1049Xo.this.c0.get(0)))));
                        if (Z00.Z) {
                            str = "\t" + ViewOnClickListenerC1049Xo.this.k;
                        }
                        sb.append(str);
                        textView.setText(sb.toString());
                    } else {
                        TextView textView2 = ViewOnClickListenerC1049Xo.this.C;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(ViewOnClickListenerC1049Xo.this.h.Q2());
                        sb2.append(":");
                        sb2.append(numberFormat.format(Math.abs(Double.parseDouble((String) ViewOnClickListenerC1049Xo.this.c0.get(0)))));
                        if (Z00.Z) {
                            str = "\t" + ViewOnClickListenerC1049Xo.this.k;
                        }
                        sb2.append(str);
                        textView2.setText(sb2.toString());
                    }
                } else {
                    ViewOnClickListenerC1049Xo viewOnClickListenerC1049Xo = ViewOnClickListenerC1049Xo.this;
                    viewOnClickListenerC1049Xo.C.setText(viewOnClickListenerC1049Xo.getActivity().getString(R.string.footer_cus_null));
                }
            } catch (Exception unused) {
            }
            Log.d("trace_E_Loader2_g=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC1049Xo.this.k + ":" + ViewOnClickListenerC1049Xo.this.i);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            Log.d("Loader=", "onCreateLoader_Footer:" + ViewOnClickListenerC1049Xo.this.i + ":" + ViewOnClickListenerC1049Xo.this.k);
            Log.d("trace_S_Loader2_g=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC1049Xo.this.k + ":" + ViewOnClickListenerC1049Xo.this.i);
            return new C0524Fn(ViewOnClickListenerC1049Xo.this.getActivity(), ViewOnClickListenerC1049Xo.this.i, ViewOnClickListenerC1049Xo.this.k, ViewOnClickListenerC1049Xo.this.h, 2);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<ArrayList<C3549oL>> loader) {
    }

    public ViewOnClickListenerC1049Xo(C0917Sq c0917Sq, int i2, int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", c0917Sq.c());
        bundle.putString("cus_name", c0917Sq.e());
        bundle.putString("curr_name", c0917Sq.a());
        bundle.putInt(CSS.Property.POSITION, i2);
        bundle.putInt("size", i3);
        bundle.putString("searchString", str);
        setArguments(bundle);
    }

    /* JADX INFO: renamed from: Xo$b */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: Xo$r */
    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
