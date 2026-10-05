package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
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
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.lang.App;
import java.io.Serializable;
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

/* JADX INFO: renamed from: Uo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class ViewOnClickListenerC0967Uo extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<ArrayList<C1896ch>> {
    public B K;
    public ImageView N;
    public ImageView O;
    public String R;
    public ProgressDialog S;
    public int c0;
    public int d0;
    public int e0;
    public Bundle f0;
    public SQLiteDatabase g;
    public Z00 h;
    public String i;
    public String j;
    public String k;
    public Activity k0;
    public String l;
    public ExpandableListView w;
    public NC x;
    public double n = 0.0d;
    public int p = 0;
    public AutoCompleteTextView q = null;
    public EditText t = null;
    public EditText u = null;
    public Button v = null;
    public ArrayList y = new ArrayList();
    public LinkedHashMap z = new LinkedHashMap();
    public ImageView A = null;
    public ImageView B = null;
    public ImageView C = null;
    public TextView D = null;
    public ImageButton E = null;
    public String[] F = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] G = {R.drawable.up, 1, R.drawable.down};
    public TextView H = null;
    public TextView I = null;
    public TextView J = null;
    public int L = 0;
    public TextView M = null;
    public ExpandableListView.OnChildClickListener P = new r();
    public ExpandableListView.OnGroupClickListener Q = new s();
    public Handler T = new w();
    public Cursor U = null;
    public DatePickerDialog.OnDateSetListener V = new C0969b();
    public DatePickerDialog.OnDateSetListener W = new C0970c();
    public int X = 0;
    public String Y = CSS.Value.PERCENTAGE;
    public String Z = CSS.Value.PERCENTAGE;
    public TextView a0 = null;
    public TextView b0 = null;
    public int g0 = 0;
    public ArrayList h0 = new ArrayList();
    public LoaderManager.LoaderCallbacks i0 = new n();
    public View.OnClickListener j0 = new q();

    /* JADX INFO: renamed from: Uo$A */
    public static class A implements Comparator {
        public A() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1896ch c1896ch, C1896ch c1896ch2) {
            return Double.valueOf(c1896ch2.f()).compareTo(Double.valueOf(c1896ch.f()));
        }

        public /* synthetic */ A(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Uo$B */
    public interface B {
        void onButtonClicked(View view);
    }

    /* JADX INFO: renamed from: Uo$C */
    public static class C implements Comparator {
        public C() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1896ch c1896ch, C1896ch c1896ch2) {
            return Double.valueOf(c1896ch.a().replaceAll(",", "")).compareTo(Double.valueOf(c1896ch2.a().replaceAll(",", "")));
        }

        public /* synthetic */ C(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Uo$D */
    public static class D implements Comparator {
        public D() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1896ch c1896ch, C1896ch c1896ch2) {
            return Double.valueOf(c1896ch2.a().replaceAll(",", "")).compareTo(Double.valueOf(c1896ch.a().replaceAll(",", "")));
        }

        public /* synthetic */ D(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Uo$a, reason: case insensitive filesystem */
    public class RunnableC0968a implements Runnable {
        public RunnableC0968a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
            Z00 z00 = viewOnClickListenerC0967Uo.h;
            ExpandableListView expandableListView = viewOnClickListenerC0967Uo.w;
            String strIc = z00.ic(viewOnClickListenerC0967Uo.R);
            ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo2 = ViewOnClickListenerC0967Uo.this;
            double dX = viewOnClickListenerC0967Uo2.x(viewOnClickListenerC0967Uo2.x.b);
            String str = ViewOnClickListenerC0967Uo.this.k;
            ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo3 = ViewOnClickListenerC0967Uo.this;
            z00.Ua(expandableListView, strIc, dX, str, viewOnClickListenerC0967Uo3.Y, viewOnClickListenerC0967Uo3.Z);
            Message message = new Message();
            message.obj = "2";
            ViewOnClickListenerC0967Uo.this.T.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: Uo$b, reason: case insensitive filesystem */
    public class C0969b implements DatePickerDialog.OnDateSetListener {
        public C0969b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                ViewOnClickListenerC0967Uo.this.a0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
                viewOnClickListenerC0967Uo.Y = viewOnClickListenerC0967Uo.a0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: Uo$c, reason: case insensitive filesystem */
    public class C0970c implements DatePickerDialog.OnDateSetListener {
        public C0970c() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                ViewOnClickListenerC0967Uo.this.b0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
                viewOnClickListenerC0967Uo.Z = viewOnClickListenerC0967Uo.b0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: Uo$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0971d implements View.OnClickListener {
        public ViewOnClickListenerC0971d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", ViewOnClickListenerC0967Uo.this.c0);
                bundle.putInt("month", ViewOnClickListenerC0967Uo.this.d0);
                bundle.putInt("day", ViewOnClickListenerC0967Uo.this.e0);
                c2137ei.setArguments(bundle);
                c2137ei.f(ViewOnClickListenerC0967Uo.this.V);
                c2137ei.show(ViewOnClickListenerC0967Uo.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: Uo$e */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", ViewOnClickListenerC0967Uo.this.c0);
                bundle.putInt("month", ViewOnClickListenerC0967Uo.this.d0);
                bundle.putInt("day", ViewOnClickListenerC0967Uo.this.e0);
                c2137ei.setArguments(bundle);
                c2137ei.f(ViewOnClickListenerC0967Uo.this.W);
                c2137ei.show(ViewOnClickListenerC0967Uo.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(ViewOnClickListenerC0967Uo.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: Uo$g */
    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
                viewOnClickListenerC0967Uo.X = 0;
                viewOnClickListenerC0967Uo.u();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: Uo$h */
    public class h implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public h(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
                viewOnClickListenerC0967Uo.X = 1;
                if (viewOnClickListenerC0967Uo.a0.getText() == null) {
                    ViewOnClickListenerC0967Uo.this.Y = "";
                } else {
                    ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo2 = ViewOnClickListenerC0967Uo.this;
                    viewOnClickListenerC0967Uo2.Y = viewOnClickListenerC0967Uo2.a0.getText().toString();
                }
                if (ViewOnClickListenerC0967Uo.this.b0.getText() == null) {
                    ViewOnClickListenerC0967Uo.this.Z = "";
                } else {
                    ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo3 = ViewOnClickListenerC0967Uo.this;
                    viewOnClickListenerC0967Uo3.Z = viewOnClickListenerC0967Uo3.b0.getText().toString();
                }
                ViewOnClickListenerC0967Uo.this.u();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: Uo$i */
    public class i implements Comparator {
        public i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1896ch c1896ch, C1896ch c1896ch2) {
            return String.valueOf(c1896ch2.j()).compareTo(String.valueOf(c1896ch.j()));
        }
    }

    /* JADX INFO: renamed from: Uo$j */
    public class j implements Comparator {
        public j() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1896ch c1896ch, C1896ch c1896ch2) {
            return String.valueOf(c1896ch.j()).compareTo(String.valueOf(c1896ch2.j()));
        }
    }

    /* JADX INFO: renamed from: Uo$k */
    public class k implements ExpandableListView.OnGroupExpandListener {
        public int a = -1;

        public k() {
        }

        @Override // android.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i) {
            int i2 = this.a;
            if (i != i2) {
                ViewOnClickListenerC0967Uo.this.w.collapseGroup(i2);
            }
            this.a = i;
        }
    }

    /* JADX INFO: renamed from: Uo$l */
    public class l implements Comparator {
        public l() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1896ch c1896ch, C1896ch c1896ch2) {
            return String.valueOf(c1896ch2.k()).compareTo(String.valueOf(c1896ch.k()));
        }
    }

    /* JADX INFO: renamed from: Uo$m */
    public class m implements Comparator {
        public m() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1896ch c1896ch, C1896ch c1896ch2) {
            return String.valueOf(c1896ch.k()).compareTo(String.valueOf(c1896ch2.k()));
        }
    }

    /* JADX INFO: renamed from: Uo$o */
    public class o extends WebViewClient {
        public o() {
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

    /* JADX INFO: renamed from: Uo$p */
    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: Uo$q */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                ViewOnClickListenerC0967Uo.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                ViewOnClickListenerC0967Uo.this.help_btn(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                ViewOnClickListenerC0967Uo.this.K.onButtonClicked(view);
            }
        }
    }

    /* JADX INFO: renamed from: Uo$r */
    public class r implements ExpandableListView.OnChildClickListener {
        public r() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            C1896ch c1896ch = (C1896ch) ViewOnClickListenerC0967Uo.this.x.b.get(i);
            C1815bh c1815bh = (C1815bh) c1896ch.e().get(i2);
            ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
            viewOnClickListenerC0967Uo.h.q9(viewOnClickListenerC0967Uo.getActivity(), c1896ch.b, c1896ch.e, c1896ch.d, c1896ch.c, ViewOnClickListenerC0967Uo.this.i, c1896ch.c(), 1, c1815bh.e(), c1815bh.e(), ViewOnClickListenerC0967Uo.this.f0);
            return false;
        }
    }

    /* JADX INFO: renamed from: Uo$s */
    public class s implements ExpandableListView.OnGroupClickListener {
        public s() {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            C1896ch c1896ch = (C1896ch) ViewOnClickListenerC0967Uo.this.x.b.get(i);
            ((C1896ch) ViewOnClickListenerC0967Uo.this.x.b.get(i)).m(ViewOnClickListenerC0967Uo.this.w(c1896ch.j(), c1896ch.c()));
            ViewOnClickListenerC0967Uo.this.x.notifyDataSetChanged();
            return false;
        }
    }

    /* JADX INFO: renamed from: Uo$t */
    public class t implements SearchView.OnQueryTextListener {
        public t() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    ViewOnClickListenerC0967Uo.this.s(1);
                }
                ViewOnClickListenerC0967Uo.this.z(str);
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            ViewOnClickListenerC0967Uo.this.s(2);
            ViewOnClickListenerC0967Uo.this.p();
            return false;
        }
    }

    /* JADX INFO: renamed from: Uo$u */
    public class u implements MenuItem.OnActionExpandListener {
        public u() {
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            ViewOnClickListenerC0967Uo.this.s(1);
            return true;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            ViewOnClickListenerC0967Uo.this.s(1);
            return true;
        }
    }

    /* JADX INFO: renamed from: Uo$w */
    public class w extends Handler {
        public w() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
                viewOnClickListenerC0967Uo.r(viewOnClickListenerC0967Uo.U);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = ViewOnClickListenerC0967Uo.this.h;
                StringBuilder sb = new StringBuilder();
                ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo2 = ViewOnClickListenerC0967Uo.this;
                sb.append(viewOnClickListenerC0967Uo2.h.ic(viewOnClickListenerC0967Uo2.R));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Z00 z01 = ViewOnClickListenerC0967Uo.this.h;
                StringBuilder sb2 = new StringBuilder();
                ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo3 = ViewOnClickListenerC0967Uo.this;
                sb2.append(viewOnClickListenerC0967Uo3.h.ic(viewOnClickListenerC0967Uo3.R));
                sb2.append(".xls");
                z01.pa(sb2.toString());
            }
            ViewOnClickListenerC0967Uo.this.G(false);
        }
    }

    /* JADX INFO: renamed from: Uo$x */
    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewOnClickListenerC0967Uo.this.t();
            Message message = new Message();
            message.obj = "0";
            ViewOnClickListenerC0967Uo.this.T.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: Uo$y */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
            Z00 z00 = viewOnClickListenerC0967Uo.h;
            ExpandableListView expandableListView = viewOnClickListenerC0967Uo.w;
            String strIc = z00.ic(viewOnClickListenerC0967Uo.R);
            ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo2 = ViewOnClickListenerC0967Uo.this;
            double dX = viewOnClickListenerC0967Uo2.x(viewOnClickListenerC0967Uo2.x.b);
            String str = ViewOnClickListenerC0967Uo.this.k;
            ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo3 = ViewOnClickListenerC0967Uo.this;
            z00.Hb(expandableListView, strIc, dX, str, viewOnClickListenerC0967Uo3.Y, viewOnClickListenerC0967Uo3.Z);
            Message message = new Message();
            message.obj = "1";
            ViewOnClickListenerC0967Uo.this.T.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: Uo$z */
    public static class z implements Comparator {
        public z() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1896ch c1896ch, C1896ch c1896ch2) {
            return Double.valueOf(c1896ch.f()).compareTo(Double.valueOf(c1896ch2.f()));
        }

        public /* synthetic */ z(k kVar) {
            this();
        }
    }

    public ViewOnClickListenerC0967Uo() {
    }

    private void C(List list) {
        Collections.sort(this.y, new C(null));
    }

    private void D(List list) {
        Collections.sort(this.y, new z(null));
    }

    private void E(List list) {
        Collections.sort(list, Collections.reverseOrder(new j()));
    }

    private void F(List list) {
        Collections.sort(list, Collections.reverseOrder(new m()));
    }

    private void H(List list) {
        Collections.sort(this.y, new D(null));
    }

    private void I(List list) {
        Collections.sort(this.y, new A(null));
    }

    private void J(List list) {
        Collections.sort(list, Collections.reverseOrder(new i()));
    }

    private void K(List list) {
        Collections.sort(list, Collections.reverseOrder(new l()));
    }

    private void n(String str) {
        new android.app.AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new v()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        int groupCount = this.x.getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            this.w.collapseGroup(i2);
        }
    }

    private void q() {
        int i2 = Calendar.getInstance().get(14);
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.i + 1) * i2 * 1000000, null, this.i0).forceLoad();
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.i + 1) * i2, null, this).forceLoad();
    }

    public void A() {
        G(true);
        new Thread(new RunnableC0968a()).start();
    }

    public void B() {
        G(true);
        new Thread(new y()).start();
    }

    public void G(boolean z2) {
        try {
            if (z2) {
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                this.S = progressDialog;
                progressDialog.setMessage(getString(R.string.google_drive_list));
                this.S.show();
            } else {
                this.S.hide();
            }
        } catch (Exception unused) {
        }
    }

    public void L(View view) {
        if (this.g0 == 0) {
            C(this.y);
            this.x.notifyDataSetChanged();
            this.g0 = 1;
        } else {
            H(this.y);
            this.x.notifyDataSetChanged();
            this.g0 = 0;
        }
    }

    public void M(View view) {
        if (this.g0 == 0) {
            J(this.y);
            this.x.notifyDataSetChanged();
            this.g0 = 1;
        } else {
            E(this.y);
            this.x.notifyDataSetChanged();
            this.g0 = 0;
        }
    }

    public void N(View view) {
        if (this.g0 == 0) {
            I(this.y);
            this.x.notifyDataSetChanged();
            this.g0 = 1;
        } else {
            D(this.y);
            this.x.notifyDataSetChanged();
            this.g0 = 0;
        }
    }

    public void O(View view) {
        if (this.g0 == 0) {
            K(this.y);
            this.x.notifyDataSetChanged();
            this.g0 = 1;
        } else {
            F(this.y);
            this.x.notifyDataSetChanged();
            this.g0 = 0;
        }
    }

    public void amount_add_btn(View view) {
        Bill_edit.P2 = true;
        startActivity(new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit.class));
    }

    public void help_btn(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new o());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new p());
        builder.show();
    }

    public void m() {
        try {
            this.X = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.a0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.b0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.a0.setOnClickListener(new ViewOnClickListenerC0971d());
            this.b0.setOnClickListener(new e());
            builder.setPositiveButton(getActivity().getString(R.string.btn_search), new f());
            builder.setNegativeButton(getActivity().getString(R.string.btn_cancel), new g());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new h(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void o() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.k0 = activity;
        try {
            this.K = (B) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.h.lc(getActivity(), this.H, this.I, this.J);
        p();
        switch (view.getId()) {
            case R.id.balance /* 2131296401 */:
                L(view);
                this.h.ld(getActivity(), this.I, this.g0);
                break;
            case R.id.customer_name /* 2131296605 */:
                M(view);
                this.h.ld(getActivity(), this.H, this.g0);
                break;
            case R.id.days_late /* 2131296612 */:
                N(view);
                this.h.ld(getActivity(), this.J, this.g0);
                break;
            case R.id.img /* 2131296820 */:
                O(view);
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
            this.l = getArguments() != null ? getArguments().getString("cus_type") : "";
            this.L = getArguments() != null ? getArguments().getInt("size") : 0;
        } catch (Exception unused) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<ArrayList<C1896ch>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_Loader1_hdr=", FragmentStatePagerSupport_Main.X() + ":" + this.k + ":" + this.i + ":" + this.l);
        boolean zIsEmpty = this.Y.isEmpty();
        String str = CSS.Value.PERCENTAGE;
        this.Y = zIsEmpty ? CSS.Value.PERCENTAGE : this.Y;
        if (!this.Z.isEmpty()) {
            str = this.Z;
        }
        this.Z = str;
        return new C2135eh(getActivity(), this.i, this.k, this.l, this.h, 1, this.Y, this.Z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main3_group_general_ex, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItemFindItem.getActionView();
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new t());
        menuItemFindItem.setOnActionExpandListener(new u());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View viewInflate = layoutInflater.inflate(R.layout.report_listview_layout_exp, viewGroup, false);
            this.h = new Z00(this.g, getActivity());
            setHasOptionsMenu(true);
            this.D = (TextView) viewInflate.findViewById(R.id.footer_sum);
            this.A = (ImageView) viewInflate.findViewById(R.id.img);
            this.H = (TextView) viewInflate.findViewById(R.id.customer_name);
            this.I = (TextView) viewInflate.findViewById(R.id.balance);
            this.J = (TextView) viewInflate.findViewById(R.id.days_late);
            this.H.setOnClickListener(this);
            this.I.setOnClickListener(this);
            this.J.setOnClickListener(this);
            this.A.setOnClickListener(this);
            try {
                TextView textView = this.H;
                textView.setPaintFlags(textView.getPaintFlags() | 8);
                TextView textView2 = this.I;
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
                TextView textView3 = this.J;
                textView3.setPaintFlags(textView3.getPaintFlags() | 8);
                this.h.ld(getActivity(), this.H, this.g0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            C0372Bn c0372Bn = C0372Bn.f;
            c0372Bn.a(getActivity(), this.H);
            c0372Bn.a(getActivity(), this.I);
            c0372Bn.a(getActivity(), this.J);
            this.B = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
            this.C = (ImageView) viewInflate.findViewById(R.id.img_help);
            this.B.setOnClickListener(this.j0);
            this.C.setOnClickListener(this.j0);
            this.N = (ImageView) viewInflate.findViewById(R.id.move_right);
            this.O = (ImageView) viewInflate.findViewById(R.id.move_left);
            this.N.setOnClickListener(this.j0);
            this.O.setOnClickListener(this.j0);
            if (this.L <= 1) {
                this.N.setVisibility(8);
                this.O.setVisibility(8);
            }
            this.w = (ExpandableListView) viewInflate.findViewById(R.id.list_report);
            this.M = (TextView) viewInflate.findViewById(R.id.emptyResults);
            this.w.setGroupIndicator(null);
            this.w.setOnChildClickListener(this.P);
            this.w.setOnGroupClickListener(this.Q);
            this.w.setOnGroupExpandListener(new k());
            if (getUserVisibleHint()) {
                this.Y = CSS.Value.PERCENTAGE;
                this.Z = CSS.Value.PERCENTAGE;
            }
            try {
                q();
            } catch (Exception unused) {
            }
            return viewInflate;
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.k0 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                o();
            }
            StringBuilder sb = new StringBuilder();
            sb.append((Object) getActivity().getTitle());
            sb.append("#");
            sb.append(Z00.Z ? this.k : "");
            this.R = sb.toString();
            p();
            B();
            return true;
        }
        if (itemId != R.id.excel) {
            if (itemId == R.id.adv_search) {
                m();
                return true;
            }
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            getActivity().finish();
            return true;
        }
        if (Build.VERSION.SDK_INT < 31) {
            o();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) getActivity().getTitle());
        sb2.append("#");
        sb2.append(Z00.Z ? this.k : "");
        this.R = sb2.toString();
        p();
        A();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            n(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            getActivity().recreate();
        }
    }

    public void r(Cursor cursor) {
        Log.d("c.getCount()=", cursor.getCount() + "");
        this.y.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            C1896ch c1896ch = new C1896ch(cursor.getString(cursor.getColumnIndex(HTML.Attribute.ID)), cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex(HintConstants.AUTOFILL_HINT_PHONE)), cursor.getString(cursor.getColumnIndex("amount")), this.G[cursor.getInt(cursor.getColumnIndex("_in"))], cursor.getString(cursor.getColumnIndex("days_late")), cursor.getString(cursor.getColumnIndex("curr_name")));
            c1896ch.m(w(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("curr_name"))));
            this.y.add(c1896ch);
            cursor.moveToNext();
        }
        cursor.close();
        NC nc = new NC(getActivity(), this.y, 1, this);
        this.x = nc;
        this.w.setAdapter(nc);
        s(2);
        this.f0 = new Bundle();
        ((App) getActivity().getApplication()).d(v(this.y));
    }

    public void s(int i2) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        String str = "";
        if (i2 != 1) {
            if (i2 == 2) {
                double dX = x(this.x.b);
                if (dX >= 0.0d) {
                    this.A.setImageResource(this.G[2]);
                    TextView textView = this.D;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.h.c5());
                    sb.append(": ");
                    sb.append(numberFormat.format(Math.abs(dX)));
                    if (Z00.Z) {
                        str = "\t" + this.k;
                    }
                    sb.append(str);
                    textView.setText(sb.toString());
                    return;
                }
                this.A.setImageResource(this.G[0]);
                TextView textView2 = this.D;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.h.Q2());
                sb2.append(": ");
                sb2.append(numberFormat.format(Math.abs(dX)));
                if (Z00.Z) {
                    str = "\t" + this.k;
                }
                sb2.append(str);
                textView2.setText(sb2.toString());
                return;
            }
            return;
        }
        this.D.setText(getString(R.string.footer_cus_null));
        try {
            ArrayList arrayListZ3 = !Z00.Z ? this.h.Z3(this.i, this.l) : this.h.a4(this.i, this.k, this.l);
            if (arrayListZ3.size() > 0) {
                if (Double.parseDouble((String) arrayListZ3.get(0)) < 0.0d) {
                    this.A.setImageResource(this.G[0]);
                    TextView textView3 = this.D;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.h.Q2());
                    sb3.append(numberFormat.format(Double.parseDouble((String) arrayListZ3.get(0))));
                    if (Z00.Z) {
                        str = "\t" + this.k;
                    }
                    sb3.append(str);
                    textView3.setText(sb3.toString());
                    return;
                }
                this.A.setImageResource(this.G[2]);
                TextView textView4 = this.D;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.h.c5());
                sb4.append(":- ");
                sb4.append(numberFormat.format(Double.parseDouble((String) arrayListZ3.get(0))));
                if (Z00.Z) {
                    str = "\t" + this.k;
                }
                sb4.append(str);
                textView4.setText(sb4.toString());
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
    }

    public void t() {
        boolean zIsEmpty = this.Y.isEmpty();
        String str = CSS.Value.PERCENTAGE;
        this.Y = zIsEmpty ? CSS.Value.PERCENTAGE : this.Y;
        if (!this.Z.isEmpty()) {
            str = this.Z;
        }
        String str2 = str;
        this.Z = str2;
        if (Z00.Z) {
            this.U = this.h.sc(this.i, this.k, this.l, this.Y, str2);
        } else {
            this.U = this.h.rc(this.i, this.l, this.Y, str2);
        }
    }

    public void u() {
        G(true);
        new Thread(new x()).start();
    }

    public List v(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(new C4143vg(((C1896ch) arrayList.get(i2)).b, ((C1896ch) arrayList.get(i2)).c, ((C1896ch) arrayList.get(i2)).d, Double.parseDouble(((C1896ch) arrayList.get(i2)).e.replaceAll(",", "")), ((C1896ch) arrayList.get(i2)).k(), Integer.parseInt(((C1896ch) arrayList.get(i2)).g), this.j, this.k));
        }
        Log.d("cus_list_size=", arrayList2.size() + "");
        return arrayList2;
    }

    public ArrayList w(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        boolean zIsEmpty = this.Y.isEmpty();
        String str3 = CSS.Value.PERCENTAGE;
        this.Y = zIsEmpty ? CSS.Value.PERCENTAGE : this.Y;
        if (!this.Z.isEmpty()) {
            str3 = this.Z;
        }
        this.Z = str3;
        Cursor cursorVc = this.h.vc(str, str2, this.Y, str3);
        C0566Hd c0566Hd = new C0566Hd();
        cursorVc.moveToFirst();
        while (!cursorVc.isAfterLast()) {
            arrayList.add(new C1815bh(cursorVc.getString(c0566Hd.b(cursorVc, "_in")), cursorVc.getString(c0566Hd.b(cursorVc, "_id")), cursorVc.getString(c0566Hd.b(cursorVc, HintConstants.AUTOFILL_HINT_PHONE)), cursorVc.getDouble(c0566Hd.b(cursorVc, "amount")), this.G[cursorVc.getInt(c0566Hd.b(cursorVc, "_in"))], cursorVc.getInt(c0566Hd.b(cursorVc, "days_late")), cursorVc.getString(c0566Hd.b(cursorVc, "curr_name"))));
            cursorVc.moveToNext();
        }
        c0566Hd.a();
        cursorVc.close();
        this.n = 0.0d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            this.n += Double.parseDouble(((C1815bh) arrayList.get(size)).a().replaceAll(",", ""));
            C1815bh c1815bh = (C1815bh) arrayList.get(size);
            c1815bh.i(this.n);
            arrayList.set(size, c1815bh);
        }
        return arrayList;
    }

    public double x(ArrayList arrayList) {
        double dAbs = 0.0d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int i2 = 0;
            if (((C1896ch) arrayList.get(size)).k() == this.G[0]) {
                i2 = -1;
            } else if (((C1896ch) arrayList.get(size)).k() == this.G[2]) {
                i2 = 1;
            }
            if (((C1896ch) arrayList.get(size)).c().equals(this.k)) {
                dAbs += Math.abs(Double.parseDouble(((C1896ch) arrayList.get(size)).a().replaceAll(",", ""))) * ((double) i2);
            }
        }
        return dAbs;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, ArrayList arrayList) {
        try {
            Log.d("trace_E_Loader1_hdr=", FragmentStatePagerSupport_Main.X() + ":" + this.k + ":" + this.i);
            this.y = arrayList;
            this.w.setEmptyView(this.M);
            NC nc = new NC(getActivity(), this.y, 1, this);
            this.x = nc;
            this.w.setAdapter(nc);
            Bundle bundle = new Bundle();
            this.f0 = bundle;
            bundle.putSerializable("dataCus", (Serializable) v(this.y));
            Log.d("trace_E_Loader1_hdr=", FragmentStatePagerSupport_Main.X() + ":" + this.k + ":" + this.i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void z(String str) {
        try {
            this.x.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: Uo$n */
    public class n implements LoaderManager.LoaderCallbacks {
        public n() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader loader, List list) {
            ViewOnClickListenerC0967Uo.this.h0 = (ArrayList) list;
            Log.d("trace_E_Loader2_hdr=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC0967Uo.this.k + ":" + ViewOnClickListenerC0967Uo.this.i);
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
            try {
                if (ViewOnClickListenerC0967Uo.this.h0.size() > 0) {
                    String str = "";
                    if (Double.parseDouble((String) ViewOnClickListenerC0967Uo.this.h0.get(0)) >= 0.0d) {
                        ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = ViewOnClickListenerC0967Uo.this;
                        viewOnClickListenerC0967Uo.A.setImageResource(viewOnClickListenerC0967Uo.G[2]);
                        TextView textView = ViewOnClickListenerC0967Uo.this.D;
                        StringBuilder sb = new StringBuilder();
                        sb.append(ViewOnClickListenerC0967Uo.this.h.c5());
                        sb.append(numberFormat.format(Double.parseDouble((String) ViewOnClickListenerC0967Uo.this.h0.get(0))));
                        if (Z00.Z) {
                            str = "\t" + ViewOnClickListenerC0967Uo.this.k;
                        }
                        sb.append(str);
                        textView.setText(sb.toString());
                    } else {
                        ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo2 = ViewOnClickListenerC0967Uo.this;
                        viewOnClickListenerC0967Uo2.A.setImageResource(viewOnClickListenerC0967Uo2.G[0]);
                        TextView textView2 = ViewOnClickListenerC0967Uo.this.D;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(ViewOnClickListenerC0967Uo.this.h.Q2());
                        sb2.append(numberFormat.format(Double.parseDouble((String) ViewOnClickListenerC0967Uo.this.h0.get(0))));
                        if (Z00.Z) {
                            str = "\t" + ViewOnClickListenerC0967Uo.this.k;
                        }
                        sb2.append(str);
                        textView2.setText(sb2.toString());
                    }
                } else {
                    ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo3 = ViewOnClickListenerC0967Uo.this;
                    viewOnClickListenerC0967Uo3.D.setText(viewOnClickListenerC0967Uo3.getActivity().getString(R.string.footer_cus_null));
                }
            } catch (Exception unused) {
            }
            Log.d("trace_E_Loader2_hdr=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC0967Uo.this.k + ":" + ViewOnClickListenerC0967Uo.this.i);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            Log.d("Loader=", "onCreateLoader_Footer:" + ViewOnClickListenerC0967Uo.this.i + ":" + ViewOnClickListenerC0967Uo.this.k);
            Log.d("trace_S_Loader2_hdr=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC0967Uo.this.k + ":" + ViewOnClickListenerC0967Uo.this.i + ":" + ViewOnClickListenerC0967Uo.this.l);
            return new C0524Fn(ViewOnClickListenerC0967Uo.this.getActivity(), ViewOnClickListenerC0967Uo.this.i, ViewOnClickListenerC0967Uo.this.k, ViewOnClickListenerC0967Uo.this.l, ViewOnClickListenerC0967Uo.this.h, 0);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<ArrayList<C1896ch>> loader) {
    }

    public ViewOnClickListenerC0967Uo(C0917Sq c0917Sq, int i2, int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", c0917Sq.c());
        bundle.putString("cus_name", c0917Sq.e());
        bundle.putString("curr_name", c0917Sq.a());
        bundle.putString("cus_type", c0917Sq.b());
        bundle.putInt(CSS.Property.POSITION, i2);
        bundle.putInt("size", i3);
        bundle.putString("searchString", str);
        setArguments(bundle);
    }

    /* JADX INFO: renamed from: Uo$f */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: Uo$v */
    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
