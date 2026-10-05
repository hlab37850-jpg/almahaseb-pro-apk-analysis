package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
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
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit4;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: io, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class ViewOnClickListenerC3091io extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<C0795Oh>> {
    public C1004Vv I;
    public SparseBooleanArray K;
    public int P;
    public int Q;
    public int R;
    public C S;
    public ImageView X;
    public ImageView Y;
    public SQLiteDatabase g;
    public Z00 h;
    public ProgressDialog h0;
    public String i;
    public String j;
    public String k;
    public Activity p0;
    public double l = 0.0d;
    public int n = 0;
    public int p = 0;
    public AutoCompleteTextView q = null;
    public EditText t = null;
    public EditText u = null;
    public TextView v = null;
    public ImageView w = null;
    public ImageView x = null;
    public ImageView y = null;
    public TextView z = null;
    public TextView A = null;
    public TextView B = null;
    public TextView C = null;
    public TextView D = null;
    public TextView E = null;
    public Button F = null;
    public ListView G = null;
    public TextView H = null;
    public List J = new ArrayList();
    public ImageButton L = null;
    public String[] M = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] N = {R.drawable.up, 1, R.drawable.down};
    public Toolbar O = null;
    public int T = 0;
    public String U = "";
    public String V = "";
    public String W = "";
    public String Z = null;
    public DatePickerDialog.OnDateSetListener a0 = new q();
    public DatePickerDialog.OnDateSetListener b0 = new r();
    public int c0 = 0;
    public String d0 = CSS.Value.PERCENTAGE;
    public String e0 = CSS.Value.PERCENTAGE;
    public TextView f0 = null;
    public TextView g0 = null;
    public Handler i0 = new x();
    public Cursor j0 = null;
    public ProgressDialog k0 = null;
    public View.OnClickListener l0 = new g();
    public ArrayList m0 = new ArrayList();
    public LoaderManager.LoaderCallbacks n0 = new n();
    public String o0 = "";

    /* JADX INFO: renamed from: io$A */
    public static class A implements Comparator {
        public A() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return c0795Oh.p().replaceAll(",", "").compareTo(c0795Oh2.p().replaceAll(",", ""));
        }

        public /* synthetic */ A(C3092a c3092a) {
            this();
        }
    }

    /* JADX INFO: renamed from: io$B */
    public static class B implements Comparator {
        public B() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return c0795Oh2.p().compareTo(c0795Oh.p());
        }

        public /* synthetic */ B(C3092a c3092a) {
            this();
        }
    }

    /* JADX INFO: renamed from: io$C */
    public interface C {
        void onButtonClicked(View view);
    }

    /* JADX INFO: renamed from: io$D */
    public static class D implements Comparator {
        public D() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return Double.valueOf(c0795Oh.l().replaceAll(",", "")).compareTo(Double.valueOf(c0795Oh2.l().replaceAll(",", "")));
        }

        public /* synthetic */ D(C3092a c3092a) {
            this();
        }
    }

    /* JADX INFO: renamed from: io$E */
    public static class E implements Comparator {
        public E() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return Double.valueOf(c0795Oh2.l().replaceAll(",", "")).compareTo(Double.valueOf(c0795Oh.l().replaceAll(",", "")));
        }

        public /* synthetic */ E(C3092a c3092a) {
            this();
        }
    }

    /* JADX INFO: renamed from: io$b, reason: case insensitive filesystem */
    public class RunnableC3093b implements Runnable {
        public RunnableC3093b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewOnClickListenerC3091io.this.u();
            Message message = new Message();
            message.obj = "0";
            ViewOnClickListenerC3091io.this.i0.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: io$c, reason: case insensitive filesystem */
    public class RunnableC3094c implements Runnable {
        public RunnableC3094c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ViewOnClickListenerC3091io.this.h.ja("prefPrintSort", true)) {
                ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                viewOnClickListenerC3091io.I(viewOnClickListenerC3091io.J);
                ViewOnClickListenerC3091io.this.p = 1;
            }
            ViewOnClickListenerC3091io viewOnClickListenerC3091io2 = ViewOnClickListenerC3091io.this;
            Z00 z00 = viewOnClickListenerC3091io2.h;
            ListView listView = viewOnClickListenerC3091io2.G;
            String strIc = z00.ic(viewOnClickListenerC3091io2.o0);
            ViewOnClickListenerC3091io viewOnClickListenerC3091io3 = ViewOnClickListenerC3091io.this;
            z00.xb(listView, strIc, viewOnClickListenerC3091io3.w(viewOnClickListenerC3091io3.I.d), ViewOnClickListenerC3091io.this.k);
            Message message = new Message();
            message.obj = "1";
            ViewOnClickListenerC3091io.this.i0.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: io$d, reason: case insensitive filesystem */
    public class RunnableC3095d implements Runnable {
        public RunnableC3095d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewOnClickListenerC3091io.this.k0.dismiss();
        }
    }

    /* JADX INFO: renamed from: io$e, reason: case insensitive filesystem */
    public class C3096e extends WebViewClient {
        public C3096e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('5','6','8')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX INFO: renamed from: io$f */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: io$g */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                ViewOnClickListenerC3091io.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                ViewOnClickListenerC3091io.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                ViewOnClickListenerC3091io.this.x(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                ViewOnClickListenerC3091io.this.S.onButtonClicked(view);
            }
        }
    }

    /* JADX INFO: renamed from: io$h */
    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                if (viewOnClickListenerC3091io.n != 0) {
                    viewOnClickListenerC3091io.h.v0("delete from transactions  where id='" + ViewOnClickListenerC3091io.this.n + "'");
                    ViewOnClickListenerC3091io.this.u();
                }
            } catch (Exception unused) {
                Toast.makeText(ViewOnClickListenerC3091io.this.getActivity(), ViewOnClickListenerC3091io.this.getString(R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: io$j */
    public class j implements Comparator {
        public j() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh2.r()).compareTo(String.valueOf(c0795Oh.r()));
        }
    }

    /* JADX INFO: renamed from: io$k */
    public class k implements Comparator {
        public k() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh.r()).compareTo(String.valueOf(c0795Oh2.r()));
        }
    }

    /* JADX INFO: renamed from: io$l */
    public class l implements Comparator {
        public l() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh2.q()).compareTo(String.valueOf(c0795Oh.q()));
        }
    }

    /* JADX INFO: renamed from: io$m */
    public class m implements Comparator {
        public m() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh.q()).compareTo(String.valueOf(c0795Oh2.q()));
        }
    }

    /* JADX INFO: renamed from: io$o */
    public class o implements SearchView.OnQueryTextListener {
        public o() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            ViewOnClickListenerC3091io.this.z(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            ViewOnClickListenerC3091io.this.t(2);
            return false;
        }
    }

    /* JADX INFO: renamed from: io$q */
    public class q implements DatePickerDialog.OnDateSetListener {
        public q() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                ViewOnClickListenerC3091io.this.f0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                viewOnClickListenerC3091io.d0 = viewOnClickListenerC3091io.f0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: io$r */
    public class r implements DatePickerDialog.OnDateSetListener {
        public r() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                ViewOnClickListenerC3091io.this.g0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                viewOnClickListenerC3091io.e0 = viewOnClickListenerC3091io.g0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: io$s */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d("Date Picker=", view.getId() + ":" + R.id.f_date);
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", ViewOnClickListenerC3091io.this.P);
                bundle.putInt("month", ViewOnClickListenerC3091io.this.Q);
                bundle.putInt("day", ViewOnClickListenerC3091io.this.R);
                c2137ei.setArguments(bundle);
                c2137ei.f(ViewOnClickListenerC3091io.this.a0);
                c2137ei.show(ViewOnClickListenerC3091io.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Log.d("Date error=", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: io$t */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", ViewOnClickListenerC3091io.this.P);
                bundle.putInt("month", ViewOnClickListenerC3091io.this.Q);
                bundle.putInt("day", ViewOnClickListenerC3091io.this.R);
                c2137ei.setArguments(bundle);
                c2137ei.f(ViewOnClickListenerC3091io.this.b0);
                c2137ei.show(ViewOnClickListenerC3091io.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: io$v */
    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                viewOnClickListenerC3091io.c0 = 0;
                viewOnClickListenerC3091io.v();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: io$w */
    public class w implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public w(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                viewOnClickListenerC3091io.c0 = 1;
                if (viewOnClickListenerC3091io.f0.getText() == null) {
                    ViewOnClickListenerC3091io.this.d0 = "";
                } else {
                    ViewOnClickListenerC3091io viewOnClickListenerC3091io2 = ViewOnClickListenerC3091io.this;
                    viewOnClickListenerC3091io2.d0 = viewOnClickListenerC3091io2.f0.getText().toString();
                }
                if (ViewOnClickListenerC3091io.this.g0.getText() == null) {
                    ViewOnClickListenerC3091io.this.e0 = "";
                } else {
                    ViewOnClickListenerC3091io viewOnClickListenerC3091io3 = ViewOnClickListenerC3091io.this;
                    viewOnClickListenerC3091io3.e0 = viewOnClickListenerC3091io3.g0.getText().toString();
                }
                ViewOnClickListenerC3091io.this.v();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: io$x */
    public class x extends Handler {
        public x() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                viewOnClickListenerC3091io.s(viewOnClickListenerC3091io.j0);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = ViewOnClickListenerC3091io.this.h;
                StringBuilder sb = new StringBuilder();
                ViewOnClickListenerC3091io viewOnClickListenerC3091io2 = ViewOnClickListenerC3091io.this;
                sb.append(viewOnClickListenerC3091io2.h.ic(viewOnClickListenerC3091io2.o0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            ViewOnClickListenerC3091io.this.G(false);
        }
    }

    /* JADX INFO: renamed from: io$y */
    public static class y implements Comparator {
        public y() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                return simpleDateFormat.parse(c0795Oh.n()).compareTo(simpleDateFormat.parse(c0795Oh2.n()));
            } catch (ParseException unused) {
                return c0795Oh2.n().compareTo(c0795Oh.n());
            }
        }

        public /* synthetic */ y(C3092a c3092a) {
            this();
        }
    }

    /* JADX INFO: renamed from: io$z */
    public static class z implements Comparator {
        public z() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                return simpleDateFormat.parse(c0795Oh2.n()).compareTo(simpleDateFormat.parse(c0795Oh.n()));
            } catch (ParseException unused) {
                return c0795Oh2.n().compareTo(c0795Oh.n());
            }
        }

        public /* synthetic */ z(C3092a c3092a) {
            this();
        }
    }

    public ViewOnClickListenerC3091io() {
    }

    private void B(List list) {
        Collections.sort(this.J, new z(null));
    }

    private void C(List list) {
        Collections.sort(this.J, new B(null));
    }

    private void D(List list) {
        Collections.sort(list, Collections.reverseOrder(new m()));
    }

    private void E(List list) {
        Collections.sort(list, Collections.reverseOrder(new k()));
    }

    private void F(List list) {
        Collections.sort(this.J, new E(null));
    }

    private void H(List list) {
        Collections.sort(this.J, new D(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List list) {
        Collections.sort(this.J, new y(null));
    }

    private void J(List list) {
        Collections.sort(this.J, new A(null));
    }

    private void K(List list) {
        Collections.sort(list, Collections.reverseOrder(new l()));
    }

    private void L(List list) {
        Collections.sort(list, Collections.reverseOrder(new j()));
    }

    private void N(View view) {
        if (this.p == 0) {
            I(this.J);
            this.I.notifyDataSetChanged();
            this.p = 1;
        } else {
            B(this.J);
            this.I.notifyDataSetChanged();
            this.p = 0;
        }
    }

    private void l(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new p()).show();
    }

    private void n() {
        int i2 = Calendar.getInstance().get(14);
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.i + 1) * i2 * 1000000, null, this.n0).forceLoad();
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.i + 1) * i2, null, this).forceLoad();
    }

    private void o() {
        int i2 = Calendar.getInstance().get(14);
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.i + 1) * i2 * 1000000, null, this.n0).forceLoad();
    }

    public void A() {
        G(true);
        new Thread(new RunnableC3094c()).start();
    }

    public void G(boolean z2) {
        try {
            if (z2) {
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                this.h0 = progressDialog;
                progressDialog.setMessage(getString(R.string.google_drive_list));
                this.h0.show();
            } else {
                this.h0.hide();
            }
        } catch (Exception unused) {
        }
    }

    public void M(View view) {
        if (this.p == 0) {
            H(this.J);
            this.I.notifyDataSetChanged();
            this.p = 1;
        } else {
            F(this.J);
            this.I.notifyDataSetChanged();
            this.p = 0;
        }
    }

    public void O(View view) {
        if (this.p == 0) {
            J(this.J);
            this.I.notifyDataSetChanged();
            this.p = 1;
        } else {
            C(this.J);
            this.I.notifyDataSetChanged();
            this.p = 0;
        }
    }

    public void P(View view) {
        if (this.p == 0) {
            K(this.J);
            this.I.notifyDataSetChanged();
            this.p = 1;
        } else {
            D(this.J);
            this.I.notifyDataSetChanged();
            this.p = 0;
        }
    }

    public void Q(View view) {
        if (this.p == 0) {
            L(this.J);
            this.I.notifyDataSetChanged();
            this.p = 1;
        } else {
            E(this.J);
            this.I.notifyDataSetChanged();
            this.p = 0;
        }
    }

    public void amount_add_btn(View view) {
        startActivity(new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit4.class));
    }

    public void btn_cus_remove(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getString(R.string.delete_msg));
        TextView textView = (TextView) ((RelativeLayout) ((View) view.getParent()).getParent()).findViewById(R.id.tr_id);
        Log.d("tr_id:=", textView.getText().toString());
        this.n = Integer.parseInt(textView.getText().toString());
        builder.setPositiveButton("Yes", new h());
        builder.setNegativeButton("No", new i());
        builder.create().show();
    }

    public void help_btn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new C3096e());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new f());
        builder.show();
    }

    public void k() {
        Log.d("click_item:=", "advance_search");
        try {
            this.c0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.f0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.g0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.f0.setOnClickListener(new s());
            this.g0.setOnClickListener(new t());
            builder.setPositiveButton(getString(R.string.btn_search), new u());
            builder.setNegativeButton(getString(R.string.btn_cancel), new v());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new w(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage() + "");
        }
    }

    public void m() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.p0 = activity;
        try {
            this.S = (C) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressDialog progressDialog = new ProgressDialog(view.getContext());
        this.k0 = progressDialog;
        progressDialog.setCancelable(true);
        this.k0.setMessage("Processing...");
        this.k0.setProgressStyle(0);
        this.k0.setMax(10);
        this.k0.show();
        this.J = this.I.d;
        switch (view.getId()) {
            case R.id.img /* 2131296820 */:
                Q(view);
                break;
            case R.id.tr_amount /* 2131297456 */:
                M(view);
                break;
            case R.id.tr_date /* 2131297468 */:
                N(view);
                break;
            case R.id.tr_name /* 2131297479 */:
                O(view);
                break;
            case R.id.tr_remarks /* 2131297488 */:
                P(view);
                break;
        }
        new Handler().postDelayed(new RunnableC3095d(), 400L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new Z00(this.g, getActivity());
            this.i = getArguments() != null ? getArguments().getString("cus_id") : "";
            this.j = getArguments() != null ? getArguments().getString("cus_name") : "";
            this.k = getArguments() != null ? getArguments().getString("curr_name") : "";
            this.T = getArguments() != null ? getArguments().getInt("size") : 0;
        } catch (Exception unused) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C0795Oh>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_doc_all=", FragmentStatePagerSupport_Main.X() + "#" + this.i);
        return new C0856Qh(getActivity(), this.h, this.k, 2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main_all2, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new o());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_customer_det_doc_all, viewGroup, false);
        this.h = new Z00(this.g, getActivity());
        setHasOptionsMenu(true);
        Log.d("OnCreate:=", "onCreateView_all:" + this.i);
        if (this.G == null) {
            this.G = (ListView) viewInflate.findViewById(R.id.list_cus_det);
            this.H = (TextView) viewInflate.findViewById(R.id.emptyResults);
        }
        this.G.setChoiceMode(2);
        this.v = (TextView) viewInflate.findViewById(R.id.footer_sum);
        this.x = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
        this.y = (ImageView) viewInflate.findViewById(R.id.img_help);
        this.x.setOnClickListener(this.l0);
        this.y.setOnClickListener(this.l0);
        this.X = (ImageView) viewInflate.findViewById(R.id.move_right);
        this.Y = (ImageView) viewInflate.findViewById(R.id.move_left);
        this.X.setOnClickListener(this.l0);
        this.Y.setOnClickListener(this.l0);
        if (this.T <= 1) {
            this.X.setVisibility(8);
            this.Y.setVisibility(8);
        }
        this.z = (TextView) viewInflate.findViewById(R.id.tr_date);
        this.A = (TextView) viewInflate.findViewById(R.id.tr_amount);
        this.B = (TextView) viewInflate.findViewById(R.id.tr_amount2);
        this.C = (TextView) viewInflate.findViewById(R.id.tr_remarks);
        this.E = (TextView) viewInflate.findViewById(R.id.tr_name);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.z.setTextColor(-1);
        this.A.setTextColor(-1);
        this.B.setTextColor(-1);
        this.C.setTextColor(-1);
        this.E.setTextColor(-1);
        this.U = getActivity().getString(R.string.footer_cus_null);
        this.V = getActivity().getString(R.string.tot_radio1);
        this.W = getActivity().getString(R.string.tot_radio2);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.P = calendar.get(1);
        this.Q = calendar.get(2);
        this.R = calendar.get(5);
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getActivity());
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        n();
        this.G.setChoiceMode(3);
        this.G.setMultiChoiceModeListener(new C3092a());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.p0 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        int itemId = menuItem.getItemId();
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append("");
        sb.append((Object) menuItem.getTitle());
        sb.append(":");
        sb.append(itemId == R.id.adv_search);
        Log.d("click_menu=", sb.toString());
        if (itemId == R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                m();
            }
            if (this.h.ja("prefPrintSort", true)) {
                this.I.notifyDataSetChanged();
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) getActivity().getTitle());
                sb2.append("#");
                sb2.append(this.j);
                if (Z00.Z) {
                    str = "-" + this.k;
                }
                sb2.append(str);
                this.o0 = sb2.toString();
                A();
            } catch (Exception unused) {
            }
            return true;
        }
        if (itemId == R.id.adv_search) {
            k();
            return true;
        }
        if (itemId != R.id.excel) {
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            getActivity().finish();
            return true;
        }
        if (Build.VERSION.SDK_INT < 31) {
            m();
        }
        if (this.h.ja("prefPrintSort", true)) {
            I(this.J);
            this.I.notifyDataSetChanged();
            this.p = 1;
        }
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append((Object) getActivity().getTitle());
            sb3.append("#");
            sb3.append(this.j);
            if (Z00.Z) {
                str = "-" + this.k;
            }
            sb3.append(str);
            String string = sb3.toString();
            Z00 z00 = this.h;
            z00.Sa(this.G, z00.ic(string), w(this.I.d), this.k);
            this.h.pa(this.h.ic(string) + ".xls");
        } catch (Exception unused2) {
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            l(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            if (Bill_edit.P2) {
                n();
                Bill_edit.P2 = false;
                Bill_edit.Q2 = false;
                Bill_edit.R2 = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void p() {
        for (int size = this.K.size() - 1; size >= 0; size--) {
            if (this.K.valueAt(size)) {
                C0795Oh item = this.I.getItem(this.K.keyAt(size));
                String strA = item.a() != null ? item.a() : "";
                this.Z = strA;
                int i2 = strA.equals("") ? 0 : Integer.parseInt(this.Z);
                if (i2 > 0) {
                    Toast.makeText(getActivity(), getActivity().getString(R.string.no_edit), 1).show();
                    this.n = 0;
                    return;
                } else {
                    if (i2 == -2) {
                        Toast.makeText(getActivity(), getActivity().getString(R.string.no_edit_doc), 1).show();
                        this.n = 0;
                        return;
                    }
                    this.I.remove(item);
                    this.h.v0("delete from transactions where id=" + item.o());
                }
            }
        }
        u();
    }

    public void q() {
        int size = this.K.size() - 1;
        if (this.K.valueAt(size)) {
            C0795Oh item = this.I.getItem(this.K.keyAt(size));
            this.n = Integer.parseInt(item.o());
            String strA = item.a() != null ? item.a() : "";
            this.Z = strA;
            int i2 = strA.equals("") ? 0 : Integer.parseInt(this.Z);
            if (i2 > 0) {
                this.h.n9(this.Z, getActivity(), 1);
                return;
            }
            if (i2 == -2) {
                this.h.r9(item.o(), item.n(), new C2160f10(this.h).I(this.n + ""), getActivity());
                return;
            }
            Intent intent = new Intent(getActivity(), (Class<?>) Customer_Det_List_edit.class);
            intent.putExtra("CUS_NAME", item.p());
            intent.putExtra("CURR_NAME", this.k);
            intent.putExtra("TR_ID", item.o());
            intent.putExtra("TR_DATE", item.n());
            intent.putExtra("TR_AMOUNT", item.l());
            intent.putExtra("TR_REMARKS", item.q());
            intent.putExtra("TR_TYPE", item.r());
            intent.putExtra("back_edit", 1);
            startActivity(intent);
        }
    }

    public void r() {
        this.I.i.clear();
        this.l = 0.0d;
    }

    public void s(Cursor cursor) {
        cursor.getCount();
        this.l = 0.0d;
        this.J.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.J.add(new C0795Oh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("date_")), String.valueOf(cursor.getDouble(cursor.getColumnIndex("credit"))), cursor.getString(cursor.getColumnIndex("tr_remarks")), 0, cursor.getString(cursor.getColumnIndex("cus_name")), cursor.getString(cursor.getColumnIndex("bill_id")), cursor.getString(cursor.getColumnIndex("curr_name")), cursor.getString(cursor.getColumnIndex("param1")), cursor.getString(cursor.getColumnIndex("bill_no")), cursor.getString(cursor.getColumnIndex("p_remarks")), cursor.getString(cursor.getColumnIndex("debit"))));
            cursor.moveToNext();
        }
        cursor.close();
        this.l = 0.0d;
        r();
        if (this.c0 == 1) {
            I(this.J);
            this.I.notifyDataSetChanged();
            this.p = 1;
        }
        if (this.c0 == 0) {
            o();
        }
        t(1);
        this.c0 = 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
    }

    public void t(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        String str = "";
        sb.append("");
        Log.d("footer_update:=", sb.toString());
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        if (this.c0 == 1) {
            if (w(this.I.d) >= 0.0d) {
                TextView textView = this.v;
                if (Z00.Z) {
                    str = "\t" + this.k;
                }
                textView.setText(str);
                return;
            }
            TextView textView2 = this.v;
            if (Z00.Z) {
                str = "\t" + this.k;
            }
            textView2.setText(str);
            return;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                double dW = w(this.I.d);
                TextView textView3 = this.v;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getString(R.string.footer_filter));
                sb2.append(numberFormat.format(dW));
                if (Z00.Z) {
                    str = "\t" + this.k;
                }
                sb2.append(str);
                textView3.setText(sb2.toString());
                return;
            }
            return;
        }
        this.v.setText(this.U);
        try {
            if (this.m0.size() > 0) {
                if (Double.parseDouble((String) this.m0.get(0)) >= 0.0d) {
                    TextView textView4 = this.v;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.W);
                    sb3.append(numberFormat.format(Double.parseDouble((String) this.m0.get(0))));
                    if (Z00.Z) {
                        str = "\t" + this.k;
                    }
                    sb3.append(str);
                    textView4.setText(sb3.toString());
                    return;
                }
                TextView textView5 = this.v;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.V);
                sb4.append(numberFormat.format(Double.parseDouble((String) this.m0.get(0))));
                if (Z00.Z) {
                    str = "\t" + this.k;
                }
                sb4.append(str);
                textView5.setText(sb4.toString());
            }
        } catch (Exception unused) {
        }
    }

    public void u() {
        Log.d("get_all_names", "get_all_names:" + this.i);
        int i2 = this.c0;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            this.j0 = this.h.m5(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.k);
            return;
        }
        this.d0 = this.d0.isEmpty() ? CSS.Value.PERCENTAGE : this.d0;
        if (!this.e0.isEmpty()) {
            str = this.e0;
        }
        this.e0 = str;
        this.j0 = this.h.m5(this.d0, str, this.k);
    }

    public void v() {
        G(true);
        new Thread(new RunnableC3093b()).start();
    }

    public double w(List list) {
        double d = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            int i2 = 0;
            if (((C0795Oh) list.get(size)).r() == this.N[0]) {
                i2 = -1;
            } else if (((C0795Oh) list.get(size)).r() == this.N[2]) {
                i2 = 1;
            }
            d += Double.parseDouble(((C0795Oh) list.get(size)).l().replaceAll(",", "")) * ((double) i2);
        }
        return d;
    }

    public void x(View view) {
        this.c0 = 0;
        u();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        TextView textView;
        Log.d("trace_E_doc_all=", FragmentStatePagerSupport_Main.X() + "#" + this.i);
        ListView listView = this.G;
        if (listView != null && (textView = this.H) != null) {
            listView.setEmptyView(textView);
        }
        this.J = list;
        C1004Vv c1004Vv = new C1004Vv(getActivity(), R.layout.customer_det_row_doc_all, this.J);
        this.I = c1004Vv;
        this.G.setAdapter((ListAdapter) c1004Vv);
    }

    public void z(String str) {
        try {
            this.I.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: io$n */
    public class n implements LoaderManager.LoaderCallbacks {
        public n() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader loader, List list) {
            ViewOnClickListenerC3091io.this.m0 = (ArrayList) list;
            Log.d("trace_E_Loader2_hdr=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC3091io.this.k + ":" + ViewOnClickListenerC3091io.this.i);
            NumberFormat.getInstance(Locale.ENGLISH);
            try {
                if (ViewOnClickListenerC3091io.this.m0.size() > 0) {
                    String str = "";
                    if (Double.parseDouble((String) ViewOnClickListenerC3091io.this.m0.get(0)) >= 0.0d) {
                        TextView textView = ViewOnClickListenerC3091io.this.v;
                        if (Z00.Z) {
                            str = "\t" + ViewOnClickListenerC3091io.this.k;
                        }
                        textView.setText(str);
                    } else {
                        TextView textView2 = ViewOnClickListenerC3091io.this.v;
                        if (Z00.Z) {
                            str = "\t" + ViewOnClickListenerC3091io.this.k;
                        }
                        textView2.setText(str);
                    }
                } else {
                    ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                    viewOnClickListenerC3091io.v.setText(viewOnClickListenerC3091io.getActivity().getString(R.string.footer_cus_null));
                }
            } catch (Exception unused) {
            }
            Log.d("trace_E_Loader2_hdr=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC3091io.this.k + ":" + ViewOnClickListenerC3091io.this.i);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            Log.d("Loader=", "onCreateLoader_Footer:" + ViewOnClickListenerC3091io.this.i + ":" + ViewOnClickListenerC3091io.this.k);
            Log.d("trace_S_Loader2_hdr=", FragmentStatePagerSupport_Main.X() + ":" + ViewOnClickListenerC3091io.this.k + ":" + ViewOnClickListenerC3091io.this.i);
            return new C0524Fn(ViewOnClickListenerC3091io.this.getActivity(), ViewOnClickListenerC3091io.this.i, ViewOnClickListenerC3091io.this.k, ViewOnClickListenerC3091io.this.h, 1);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C0795Oh>> loader) {
    }

    /* JADX INFO: renamed from: io$a, reason: case insensitive filesystem */
    public class C3092a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: io$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0324a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0324a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    ViewOnClickListenerC3091io.this.p();
                } catch (Exception unused) {
                    Toast.makeText(ViewOnClickListenerC3091io.this.getActivity(), "SQL Error.", 1);
                }
            }
        }

        public C3092a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    ViewOnClickListenerC3091io.this.K = ViewOnClickListenerC3091io.this.I.b();
                    AlertDialog.Builder builder = new AlertDialog.Builder(ViewOnClickListenerC3091io.this.getActivity());
                    builder.setMessage(ViewOnClickListenerC3091io.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(ViewOnClickListenerC3091io.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0324a());
                    builder.setNegativeButton(ViewOnClickListenerC3091io.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB = ViewOnClickListenerC3091io.this.I.b();
                    ViewOnClickListenerC3091io viewOnClickListenerC3091io = ViewOnClickListenerC3091io.this;
                    viewOnClickListenerC3091io.K = sparseBooleanArrayB;
                    viewOnClickListenerC3091io.q();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar3, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            ViewOnClickListenerC3091io.this.I.i.clear();
            ViewOnClickListenerC3091io.this.I.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = ViewOnClickListenerC3091io.this.G.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            ViewOnClickListenerC3091io.this.I.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (ViewOnClickListenerC3091io.this.G.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        /* JADX INFO: renamed from: io$a$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }
    }

    /* JADX INFO: renamed from: io$i */
    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: io$p */
    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: io$u */
    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public ViewOnClickListenerC3091io(C0917Sq c0917Sq, int i2, int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", c0917Sq.c());
        bundle.putString("cus_name", c0917Sq.e());
        bundle.putString("curr_name", c0917Sq.a());
        bundle.putInt(CSS.Property.POSITION, i2);
        bundle.putInt("size", i3);
        bundle.putString("searchString", str);
        setArguments(bundle);
    }
}
