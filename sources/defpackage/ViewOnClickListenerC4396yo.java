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
import android.os.Looper;
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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.CombinedLoadStates;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit3;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: yo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class ViewOnClickListenerC4396yo extends Fragment implements View.OnClickListener, C4330y1.c, DE {
    public L1 J;
    public SparseBooleanArray L;
    public int Q;
    public int R;
    public int S;
    public H T;
    public ActionMode U;
    public C V;
    public C0596Ih X;
    public ImageView e0;
    public ImageView f0;
    public SQLiteDatabase g;
    public Z00 h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String n;
    public ProgressDialog o0;
    public SearchView v0;
    public Activity y0;
    public double p = 0.0d;
    public int q = 0;
    public int t = 0;
    public AutoCompleteTextView u = null;
    public EditText v = null;
    public EditText w = null;
    public TextView x = null;
    public ImageView y = null;
    public ImageView z = null;
    public ImageView A = null;
    public TextView B = null;
    public TextView C = null;
    public TextView D = null;
    public TextView E = null;
    public TextView F = null;
    public Button G = null;
    public RecyclerView H = null;
    public TextView I = null;
    public List K = new ArrayList();
    public ImageButton M = null;
    public String[] N = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] O = {R.drawable.up, 1, R.drawable.down};
    public Toolbar P = null;
    public int W = 0;
    public int Y = 0;
    public int Z = 0;
    public String a0 = "";
    public String b0 = "";
    public String c0 = "";
    public String d0 = "";
    public String g0 = null;
    public DatePickerDialog.OnDateSetListener h0 = new z();
    public DatePickerDialog.OnDateSetListener i0 = new A();
    public int j0 = 0;
    public String k0 = CSS.Value.PERCENTAGE;
    public String l0 = CSS.Value.PERCENTAGE;
    public TextView m0 = null;
    public TextView n0 = null;
    public Handler p0 = new HandlerC4401e();
    public Cursor q0 = null;
    public ProgressDialog r0 = null;
    public int s0 = 0;
    public View.OnClickListener t0 = new ViewOnClickListenerC4406j();
    public ArrayList u0 = new ArrayList();
    public final Handler w0 = new Handler(Looper.getMainLooper());
    public String x0 = "";

    /* JADX INFO: renamed from: yo$A */
    public class A implements DatePickerDialog.OnDateSetListener {
        public A() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                ViewOnClickListenerC4396yo.this.n0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                viewOnClickListenerC4396yo.l0 = viewOnClickListenerC4396yo.n0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: yo$B */
    public class B implements View.OnClickListener {
        public B() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d("Date Picker=", view.getId() + ":" + R.id.f_date);
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", ViewOnClickListenerC4396yo.this.Q);
                bundle.putInt("month", ViewOnClickListenerC4396yo.this.R);
                bundle.putInt("day", ViewOnClickListenerC4396yo.this.S);
                c2137ei.setArguments(bundle);
                c2137ei.f(ViewOnClickListenerC4396yo.this.h0);
                c2137ei.show(ViewOnClickListenerC4396yo.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Log.d("Date error=", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: yo$C */
    public class C implements ActionMode.Callback {

        /* JADX INFO: renamed from: yo$C$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    ViewOnClickListenerC4396yo.this.B();
                } catch (Exception unused) {
                    Toast.makeText(ViewOnClickListenerC4396yo.this.getActivity(), "SQL Error.", 1);
                }
            }
        }

        public C() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    ViewOnClickListenerC4396yo.this.L = ViewOnClickListenerC4396yo.this.J.d();
                    AlertDialog.Builder builder = new AlertDialog.Builder(ViewOnClickListenerC4396yo.this.getActivity());
                    builder.setMessage(ViewOnClickListenerC4396yo.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(ViewOnClickListenerC4396yo.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(ViewOnClickListenerC4396yo.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayD = ViewOnClickListenerC4396yo.this.J.d();
                    ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                    viewOnClickListenerC4396yo.L = sparseBooleanArrayD;
                    viewOnClickListenerC4396yo.C();
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
            ViewOnClickListenerC4396yo.this.J.f.clear();
            ViewOnClickListenerC4396yo.this.J.h();
            ViewOnClickListenerC4396yo.this.U = null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (ViewOnClickListenerC4396yo.this.J.c() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        public /* synthetic */ C(ViewOnClickListenerC4396yo viewOnClickListenerC4396yo, k kVar) {
            this();
        }

        /* JADX INFO: renamed from: yo$C$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }
    }

    /* JADX INFO: renamed from: yo$D */
    public static class D implements Comparator {
        public D() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            int iCompareTo;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                iCompareTo = simpleDateFormat.parse(c0795Oh.n()).compareTo(simpleDateFormat.parse(c0795Oh2.n()));
            } catch (ParseException unused) {
                iCompareTo = c0795Oh2.n().compareTo(c0795Oh.n());
            }
            return iCompareTo == 0 ? Integer.parseInt(c0795Oh.o()) - Integer.parseInt(c0795Oh2.o()) : iCompareTo;
        }

        public /* synthetic */ D(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: yo$E */
    public static class E implements Comparator {
        public E() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            int iCompareTo;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                iCompareTo = simpleDateFormat.parse(c0795Oh2.n()).compareTo(simpleDateFormat.parse(c0795Oh.n()));
            } catch (ParseException unused) {
                iCompareTo = c0795Oh2.n().compareTo(c0795Oh.n());
            }
            return iCompareTo == 0 ? Integer.parseInt(c0795Oh2.o()) - Integer.parseInt(c0795Oh.o()) : iCompareTo;
        }

        public /* synthetic */ E(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: yo$F */
    public static class F implements Comparator {
        public F() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return c0795Oh.p().replaceAll(",", "").compareTo(c0795Oh2.p().replaceAll(",", ""));
        }

        public /* synthetic */ F(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: yo$G */
    public static class G implements Comparator {
        public G() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return c0795Oh2.p().compareTo(c0795Oh.p());
        }

        public /* synthetic */ G(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: yo$H */
    public interface H {
        void onButtonClicked(View view);
    }

    /* JADX INFO: renamed from: yo$I */
    public static class I implements Comparator {
        public I() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return Double.valueOf(c0795Oh.l().replaceAll(",", "")).compareTo(Double.valueOf(c0795Oh2.l().replaceAll(",", "")));
        }

        public /* synthetic */ I(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: yo$J */
    public static class J implements Comparator {
        public J() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return Double.valueOf(c0795Oh2.l().replaceAll(",", "")).compareTo(Double.valueOf(c0795Oh.l().replaceAll(",", "")));
        }

        public /* synthetic */ J(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: yo$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC4397a implements View.OnClickListener {
        public ViewOnClickListenerC4397a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", ViewOnClickListenerC4396yo.this.Q);
                bundle.putInt("month", ViewOnClickListenerC4396yo.this.R);
                bundle.putInt("day", ViewOnClickListenerC4396yo.this.S);
                c2137ei.setArguments(bundle);
                c2137ei.f(ViewOnClickListenerC4396yo.this.i0);
                c2137ei.show(ViewOnClickListenerC4396yo.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: yo$c, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC4399c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4399c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                viewOnClickListenerC4396yo.j0 = 0;
                viewOnClickListenerC4396yo.G();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: yo$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC4400d implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC4400d(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                viewOnClickListenerC4396yo.j0 = 1;
                if (viewOnClickListenerC4396yo.m0.getText() == null) {
                    ViewOnClickListenerC4396yo.this.k0 = "";
                } else {
                    ViewOnClickListenerC4396yo viewOnClickListenerC4396yo2 = ViewOnClickListenerC4396yo.this;
                    viewOnClickListenerC4396yo2.k0 = viewOnClickListenerC4396yo2.m0.getText().toString();
                }
                if (ViewOnClickListenerC4396yo.this.n0.getText() == null) {
                    ViewOnClickListenerC4396yo.this.l0 = "";
                } else {
                    ViewOnClickListenerC4396yo viewOnClickListenerC4396yo3 = ViewOnClickListenerC4396yo.this;
                    viewOnClickListenerC4396yo3.l0 = viewOnClickListenerC4396yo3.n0.getText().toString();
                }
                ViewOnClickListenerC4396yo.this.G();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: yo$e, reason: case insensitive filesystem */
    public class HandlerC4401e extends Handler {
        public HandlerC4401e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            ViewOnClickListenerC4396yo.this.i0(false);
            if (message.obj.toString().equals("0")) {
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                viewOnClickListenerC4396yo.D(viewOnClickListenerC4396yo.q0);
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = ViewOnClickListenerC4396yo.this.h;
                StringBuilder sb = new StringBuilder();
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo2 = ViewOnClickListenerC4396yo.this;
                sb.append(viewOnClickListenerC4396yo2.h.ic(viewOnClickListenerC4396yo2.x0));
                sb.append(".pdf");
                z00.ra(sb.toString());
                return;
            }
            if (message.obj.toString().equals("2")) {
                ViewOnClickListenerC4396yo.this.J.notifyDataSetChanged();
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo3 = ViewOnClickListenerC4396yo.this;
                Z00 z01 = viewOnClickListenerC4396yo3.h;
                FragmentActivity activity = viewOnClickListenerC4396yo3.getActivity();
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo4 = ViewOnClickListenerC4396yo.this;
                z01.lc(activity, viewOnClickListenerC4396yo4.B, viewOnClickListenerC4396yo4.F, viewOnClickListenerC4396yo4.C, viewOnClickListenerC4396yo4.D);
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo5 = ViewOnClickListenerC4396yo.this;
                int i = viewOnClickListenerC4396yo5.s0;
                if (i == 1) {
                    Z00 z02 = viewOnClickListenerC4396yo5.h;
                    FragmentActivity activity2 = viewOnClickListenerC4396yo5.getActivity();
                    ViewOnClickListenerC4396yo viewOnClickListenerC4396yo6 = ViewOnClickListenerC4396yo.this;
                    z02.ld(activity2, viewOnClickListenerC4396yo6.B, viewOnClickListenerC4396yo6.t);
                    return;
                }
                if (i == 2) {
                    Z00 z03 = viewOnClickListenerC4396yo5.h;
                    FragmentActivity activity3 = viewOnClickListenerC4396yo5.getActivity();
                    ViewOnClickListenerC4396yo viewOnClickListenerC4396yo7 = ViewOnClickListenerC4396yo.this;
                    z03.ld(activity3, viewOnClickListenerC4396yo7.F, viewOnClickListenerC4396yo7.t);
                    return;
                }
                if (i == 3) {
                    Z00 z04 = viewOnClickListenerC4396yo5.h;
                    FragmentActivity activity4 = viewOnClickListenerC4396yo5.getActivity();
                    ViewOnClickListenerC4396yo viewOnClickListenerC4396yo8 = ViewOnClickListenerC4396yo.this;
                    z04.ld(activity4, viewOnClickListenerC4396yo8.C, viewOnClickListenerC4396yo8.t);
                    return;
                }
                if (i == 4) {
                    Z00 z05 = viewOnClickListenerC4396yo5.h;
                    FragmentActivity activity5 = viewOnClickListenerC4396yo5.getActivity();
                    ViewOnClickListenerC4396yo viewOnClickListenerC4396yo9 = ViewOnClickListenerC4396yo.this;
                    z05.ld(activity5, viewOnClickListenerC4396yo9.D, viewOnClickListenerC4396yo9.t);
                }
            }
        }
    }

    /* JADX INFO: renamed from: yo$f, reason: case insensitive filesystem */
    public class RunnableC4402f implements Runnable {
        public RunnableC4402f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3357m10 c3357m10 = new C3357m10(ViewOnClickListenerC4396yo.this.getActivity(), ViewOnClickListenerC4396yo.this.h);
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
            RecyclerView recyclerView = viewOnClickListenerC4396yo.H;
            String strIc = viewOnClickListenerC4396yo.h.ic(viewOnClickListenerC4396yo.x0);
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo2 = ViewOnClickListenerC4396yo.this;
            double dH = viewOnClickListenerC4396yo2.H(viewOnClickListenerC4396yo2.J.b());
            String str = ViewOnClickListenerC4396yo.this.l;
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo3 = ViewOnClickListenerC4396yo.this;
            c3357m10.h(recyclerView, strIc, dH, str, viewOnClickListenerC4396yo3.k0, viewOnClickListenerC4396yo3.l0);
            Message message = new Message();
            message.obj = "1";
            ViewOnClickListenerC4396yo.this.p0.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: yo$g, reason: case insensitive filesystem */
    public class RunnableC4403g implements Runnable {
        public final /* synthetic */ View a;

        public RunnableC4403g(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
            viewOnClickListenerC4396yo.K = viewOnClickListenerC4396yo.J.b();
            switch (this.a.getId()) {
                case R.id.img /* 2131296820 */:
                    ViewOnClickListenerC4396yo.this.t0(this.a);
                    break;
                case R.id.tr_amount /* 2131297456 */:
                    ViewOnClickListenerC4396yo.this.o0(this.a);
                    ViewOnClickListenerC4396yo.this.s0 = 3;
                    break;
                case R.id.tr_date /* 2131297468 */:
                    ViewOnClickListenerC4396yo.this.p0(this.a);
                    ViewOnClickListenerC4396yo.this.s0 = 1;
                    break;
                case R.id.tr_name /* 2131297479 */:
                    ViewOnClickListenerC4396yo.this.q0(this.a);
                    ViewOnClickListenerC4396yo.this.s0 = 2;
                    break;
                case R.id.tr_remarks /* 2131297488 */:
                    ViewOnClickListenerC4396yo.this.r0(this.a);
                    ViewOnClickListenerC4396yo.this.s0 = 4;
                    break;
            }
            Message message = new Message();
            message.obj = "2";
            ViewOnClickListenerC4396yo.this.p0.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: yo$h, reason: case insensitive filesystem */
    public class C4404h extends WebViewClient {
        public C4404h() {
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

    /* JADX INFO: renamed from: yo$i, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC4405i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4405i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: yo$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC4406j implements View.OnClickListener {
        public ViewOnClickListenerC4406j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                ViewOnClickListenerC4396yo.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                ViewOnClickListenerC4396yo.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                ViewOnClickListenerC4396yo.this.W(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                ViewOnClickListenerC4396yo.this.T.onButtonClicked(view);
            }
        }
    }

    /* JADX INFO: renamed from: yo$k */
    public class k implements Observer {
        public k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            ViewOnClickListenerC4396yo.this.J.getFilter().filter(ViewOnClickListenerC4396yo.this.v0.getQuery());
        }

        public final /* synthetic */ void e() {
            ViewOnClickListenerC4396yo.this.J.notifyDataSetChanged();
        }

        public final /* synthetic */ void f(List list) {
            ViewOnClickListenerC4396yo.this.J.l(list);
            SearchView searchView = ViewOnClickListenerC4396yo.this.v0;
            if (searchView == null || searchView.getQuery().length() <= 0) {
                ViewOnClickListenerC4396yo.this.getActivity().runOnUiThread(new Runnable() { // from class: xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e();
                    }
                });
            } else {
                ViewOnClickListenerC4396yo.this.getActivity().runOnUiThread(new Runnable() { // from class: wo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d();
                    }
                });
            }
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onChanged(final List list) {
            C3966tX c3966tX = new C3966tX();
            FragmentActivity activity = ViewOnClickListenerC4396yo.this.getActivity();
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
            c3966tX.z(activity, viewOnClickListenerC4396yo.H, viewOnClickListenerC4396yo.I, list == null ? 0 : list.size());
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo2 = ViewOnClickListenerC4396yo.this;
            if (viewOnClickListenerC4396yo2.J == null) {
                viewOnClickListenerC4396yo2.Y(list);
                return;
            }
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: vo
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(list);
                }
            });
            executorServiceNewSingleThreadExecutor.shutdown();
        }
    }

    /* JADX INFO: renamed from: yo$l */
    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                if (viewOnClickListenerC4396yo.q != 0) {
                    viewOnClickListenerC4396yo.h.v0("delete from transactions  where id='" + ViewOnClickListenerC4396yo.this.q + "'");
                    ViewOnClickListenerC4396yo.this.F();
                }
            } catch (Exception unused) {
                Toast.makeText(ViewOnClickListenerC4396yo.this.getActivity(), ViewOnClickListenerC4396yo.this.getString(R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: yo$n */
    public class n implements Comparator {
        public n() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh2.r()).compareTo(String.valueOf(c0795Oh.r()));
        }
    }

    /* JADX INFO: renamed from: yo$o */
    public class o implements Comparator {
        public o() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh.r()).compareTo(String.valueOf(c0795Oh2.r()));
        }
    }

    /* JADX INFO: renamed from: yo$p */
    public class p implements Comparator {
        public p() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh2.q()).compareTo(String.valueOf(c0795Oh.q()));
        }
    }

    /* JADX INFO: renamed from: yo$q */
    public class q implements Comparator {
        public q() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh.q()).compareTo(String.valueOf(c0795Oh2.q()));
        }
    }

    /* JADX INFO: renamed from: yo$r */
    public class r implements SearchView.OnQueryTextListener {

        /* JADX INFO: renamed from: yo$r$a */
        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewOnClickListenerC4396yo.this.X(this.a);
            }
        }

        public r() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            ViewOnClickListenerC4396yo.this.E(2);
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                try {
                    ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                    if (viewOnClickListenerC4396yo.Z == 1) {
                        viewOnClickListenerC4396yo.Z = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ViewOnClickListenerC4396yo.this.Z = 1;
            }
            ViewOnClickListenerC4396yo.this.w0.removeCallbacksAndMessages(null);
            ViewOnClickListenerC4396yo.this.w0.postDelayed(new a(str), new C2160f10().V(str));
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            try {
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: zo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
                executorServiceNewSingleThreadExecutor.shutdown();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: yo$s */
    public class s implements MenuItemCompat.OnActionExpandListener {
        public s() {
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            ViewOnClickListenerC4396yo.this.Z = 0;
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return true;
        }
    }

    /* JADX INFO: renamed from: yo$u */
    public class u implements Observer {
        public u() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                C3966tX c3966tX = new C3966tX();
                FragmentActivity activity = ViewOnClickListenerC4396yo.this.getActivity();
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                c3966tX.z(activity, viewOnClickListenerC4396yo.H, viewOnClickListenerC4396yo.I, -1);
                return;
            }
            C3966tX c3966tX2 = new C3966tX();
            FragmentActivity activity2 = ViewOnClickListenerC4396yo.this.getActivity();
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo2 = ViewOnClickListenerC4396yo.this;
            c3966tX2.z(activity2, viewOnClickListenerC4396yo2.H, viewOnClickListenerC4396yo2.I, 1);
        }
    }

    /* JADX INFO: renamed from: yo$v */
    public class v implements Observer {
        public v() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            ViewOnClickListenerC4396yo.this.J.k(str);
        }
    }

    /* JADX INFO: renamed from: yo$w */
    public class w implements Observer {
        public w() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(final List list) {
            ViewOnClickListenerC4396yo.this.getActivity().runOnUiThread(new Runnable() { // from class: Bo
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(list);
                }
            });
        }

        public final /* synthetic */ void c(List list) {
            ViewOnClickListenerC4396yo.this.J.j(list);
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onChanged(final List list) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: Ao
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d(list);
                }
            });
            executorServiceNewSingleThreadExecutor.shutdown();
        }
    }

    /* JADX INFO: renamed from: yo$x */
    public class x implements Observer {
        public x() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                C3966tX c3966tX = new C3966tX();
                FragmentActivity activity = ViewOnClickListenerC4396yo.this.getActivity();
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                c3966tX.z(activity, viewOnClickListenerC4396yo.H, viewOnClickListenerC4396yo.I, -2);
                return;
            }
            C3966tX c3966tX2 = new C3966tX();
            FragmentActivity activity2 = ViewOnClickListenerC4396yo.this.getActivity();
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo2 = ViewOnClickListenerC4396yo.this;
            c3966tX2.z(activity2, viewOnClickListenerC4396yo2.H, viewOnClickListenerC4396yo2.I, 1);
        }
    }

    /* JADX INFO: renamed from: yo$y */
    public class y implements Observer {
        public y() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List list) {
            Log.d("trace_2onFooter=", "" + list.size());
            if (list.size() == 0) {
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                viewOnClickListenerC4396yo.x.setText(viewOnClickListenerC4396yo.l);
            } else {
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo2 = ViewOnClickListenerC4396yo.this;
                viewOnClickListenerC4396yo2.u0 = (ArrayList) list;
                viewOnClickListenerC4396yo2.E(1);
            }
        }
    }

    /* JADX INFO: renamed from: yo$z */
    public class z implements DatePickerDialog.OnDateSetListener {
        public z() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                ViewOnClickListenerC4396yo.this.m0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = ViewOnClickListenerC4396yo.this;
                viewOnClickListenerC4396yo.k0 = viewOnClickListenerC4396yo.m0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public ViewOnClickListenerC4396yo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        this.J.retry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.J.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.H.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        this.H.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FW O(CombinedLoadStates combinedLoadStates) {
        int i;
        Log.d("trace_2loadStates:=", this.Y + ":" + this.j0 + ":" + this.Z + ":" + combinedLoadStates.getPrepend().toString() + ":" + combinedLoadStates.toString());
        if (combinedLoadStates.getPrepend().getEndOfPaginationReached()) {
            int size = this.J.b().size();
            Log.d("trace_2loadStates:=", "END:" + size);
            new C3966tX().z(getActivity(), this.H, this.I, size);
            Y(null);
            if (I() || (i = this.Y) == -1 || i == -2) {
                if (I() && this.Y != -2) {
                    E(2);
                }
                if (this.Y == -1) {
                    new Handler().postDelayed(new Runnable() { // from class: so
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.L();
                        }
                    }, 0L);
                } else {
                    new Handler().postDelayed(new Runnable() { // from class: to
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.M();
                        }
                    }, 0L);
                }
                if (I() && this.Y < 0) {
                    this.h.Kd(getActivity(), new C2160f10(getActivity(), this.h).P(this.k0, this.l0), 500);
                }
            }
            int i2 = this.Y;
            if (i2 == 1) {
                b0();
            } else if (i2 == 2) {
                Z();
            }
            if (this.Y == 0 && this.H.computeVerticalScrollOffset() == 0) {
                new Handler().postDelayed(new Runnable() { // from class: uo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.N();
                    }
                }, 0L);
            }
            this.Y = 0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(PagingData pagingData) {
        Log.d("trace_2Observer=", "onChanged");
        this.J.submitData(getLifecycle(), pagingData);
    }

    private void d0(List list) {
        Collections.sort(this.K, new E(null));
    }

    private void e0(List list) {
        Collections.sort(this.K, new G(null));
    }

    private void f0(List list) {
        Collections.sort(list, Collections.reverseOrder(new q()));
    }

    private void g0(List list) {
        Collections.sort(list, Collections.reverseOrder(new o()));
    }

    private void h0(List list) {
        Collections.sort(this.K, new J(null));
    }

    private void j0(List list) {
        Collections.sort(this.K, new I(null));
    }

    private void k0(List list) {
        Collections.sort(this.K, new D(null));
    }

    private void l0(List list) {
        Collections.sort(this.K, new F(null));
    }

    private void m0(List list) {
        Collections.sort(list, Collections.reverseOrder(new p()));
    }

    private void n0(List list) {
        Collections.sort(list, Collections.reverseOrder(new n()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(View view) {
        if (this.t == 0) {
            k0(this.K);
            this.t = 1;
        } else {
            d0(this.K);
            this.t = 0;
        }
    }

    private void x(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new t()).show();
    }

    private void z(int i) {
        String str;
        this.Y = i;
        boolean zIsEmpty = this.k0.isEmpty();
        String str2 = CSS.Value.PERCENTAGE;
        this.k0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.k0;
        if (!this.l0.isEmpty()) {
            str2 = this.l0;
        }
        this.l0 = str2;
        Log.d("trace_data_loader=", this.i + ":" + this.l + ":" + this.n);
        Calendar.getInstance().get(14);
        if (this.j == null) {
            return;
        }
        SearchView searchView = this.v0;
        this.a0 = (searchView == null || searchView.getQuery() == null) ? "" : this.v0.getQuery().toString();
        if (!I() || (!I() && i == -1)) {
            this.X.d(getActivity(), this.l, this.h, this.Z, this.a0);
        }
        Log.d("trace_S_Loader_cus=", this.j + ":" + this.l + ":" + this.n + ":" + this.k0 + ":" + this.l0 + ":" + this.j0);
        this.p = 0.0d;
        if ((J() && this.Z == 1) || this.j0 == 1 || this.Y > 0 || i == -2) {
            new C3966tX().z(getActivity(), this.H, this.I, -1);
        }
        L1 l1 = this.J;
        if (l1 == null || this.j0 == 1 || i == -1) {
            C2160f10.l = 100;
        }
        if (l1 == null || this.j0 == 1 || i == -2) {
            L1 l2 = new L1(getActivity(), this.K, this, this);
            this.J = l2;
            this.H.setAdapter(l2.withLoadStateFooter(new C4249x1(new View.OnClickListener() { // from class: jo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.K(view);
                }
            })));
            this.J.addLoadStateListener(new InterfaceC3750qp() { // from class: mo
                @Override // defpackage.InterfaceC3750qp
                public final Object invoke(Object obj) {
                    return this.a.O((CombinedLoadStates) obj);
                }
            });
        }
        if (i == -1 || ((str = this.a0) != null && str.length() > 0)) {
            this.J.d = this.a0;
        }
        this.X.c(getActivity(), this.j, this.l, this.h, this.k0, this.l0, (i > 0 || i == -2 || I()) ? 1 : this.j0, i, this.Z, this.a0, this.s0, this.t);
        this.X.g.k(new InterfaceC2295gf() { // from class: no
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.P((PagingData) obj);
            }
        });
    }

    public void B() {
        if (C2160f10.h > 0 && !new C2160f10(this.h).l("-9", HTML.Tag.DEL)) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.L.size() - 1; size >= 0; size--) {
            if (this.L.valueAt(size)) {
                C0795Oh c0795Oh = (C0795Oh) this.J.b().get(this.L.keyAt(size));
                String strA = c0795Oh.a() != null ? c0795Oh.a() : "";
                this.g0 = strA;
                int i = strA.equals("") ? 0 : Integer.parseInt(this.g0);
                if (i > 0) {
                    Toast.makeText(getActivity(), getActivity().getString(R.string.no_edit), 1).show();
                    this.q = 0;
                    return;
                }
                if (i == -2 || i == -3 || i == -4 || i == -6) {
                    Toast.makeText(getActivity(), getActivity().getString(R.string.no_edit_doc), 1).show();
                    this.q = 0;
                    return;
                }
                this.J.g(c0795Oh);
                this.h.v0("delete from transactions where id=" + c0795Oh.o());
            }
        }
        F();
    }

    public void C() {
        if (C2160f10.h > 0 && !new C2160f10(this.h).l("-9", HTML.Tag.DEL)) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.L.size() - 1;
        if (this.L.valueAt(size)) {
            C0795Oh c0795Oh = (C0795Oh) this.J.b().get(this.L.keyAt(size));
            this.q = Integer.parseInt(c0795Oh.o());
            String strA = c0795Oh.a() != null ? c0795Oh.a() : "";
            this.g0 = strA;
            int i = strA.equals("") ? 0 : Integer.parseInt(this.g0);
            if (i > 0) {
                this.h.n9(this.g0, getActivity(), 1);
                return;
            }
            if (i == -2) {
                String strI = new C2160f10(this.h).I(this.q + "");
                Z00 z00 = this.h;
                z00.r9(z00.Q8(this.q), this.h.P8(this.q), strI, getActivity());
                return;
            }
            if (i == -3) {
                String strI2 = new C2160f10(this.h).I(this.q + "");
                Z00 z01 = this.h;
                z01.s9(z01.Q8(this.q), this.h.H8(this.q), this.h.P8(this.q), strI2, getActivity());
                return;
            }
            if (i == -6) {
                String strI3 = new C2160f10(this.h).I(this.q + "");
                Z00 z02 = this.h;
                z02.p9(z02.Q8(this.q), this.h.H8(this.q), this.h.P8(this.q), strI3, getActivity());
                return;
            }
            if (i == -4) {
                this.h.t9(this.q + "", getActivity());
                return;
            }
            Intent intent = i == -1 ? new Intent(getActivity(), (Class<?>) Customer_Det_List_edit3.class) : new Intent(getActivity(), (Class<?>) Customer_Det_List_edit.class);
            intent.putExtra("CUS_NAME", c0795Oh.p());
            intent.putExtra("CURR_NAME", this.l);
            intent.putExtra("TR_ID", c0795Oh.o());
            intent.putExtra("TR_DATE", c0795Oh.n());
            intent.putExtra("TR_AMOUNT", c0795Oh.l());
            intent.putExtra("TR_REMARKS", c0795Oh.q());
            intent.putExtra("TR_TYPE", c0795Oh.r());
            intent.putExtra("back_edit", 1);
            startActivity(intent);
        }
    }

    public void D(Cursor cursor) {
        this.p = 0.0d;
        this.K.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.K.add(new C0795Oh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("date_")), "" + cursor.getDouble(cursor.getColumnIndex("amount")), cursor.getString(cursor.getColumnIndex("remarks")), this.O[cursor.getInt(cursor.getColumnIndex("_in"))], cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("bill_id")), cursor.getString(cursor.getColumnIndex("org_remarks")), cursor.getString(cursor.getColumnIndex("p_id")), cursor.getString(cursor.getColumnIndex("doc_type")), cursor.getString(cursor.getColumnIndex("p_acc_id"))));
            cursor.moveToNext();
        }
        cursor.close();
        this.p = 0.0d;
        if (this.j0 == 1) {
            k0(this.K);
            this.J.notifyDataSetChanged();
            this.t = 1;
        }
        if (this.j0 == 0) {
            A();
        }
        E(1);
        this.j0 = 0;
    }

    public void E(int i) {
        Log.d("trace_footer_update:=", i + ":" + this.j0 + ":" + I());
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        String str = "";
        if (this.j0 == 1 && I()) {
            if (H(this.J.b()) >= 0.0d) {
                this.y.setImageResource(this.O[2]);
                TextView textView = this.x;
                if (Z00.Z) {
                    str = "\t" + this.l;
                }
                textView.setText(str);
                return;
            }
            this.y.setImageResource(this.O[0]);
            TextView textView2 = this.x;
            if (Z00.Z) {
                str = "\t" + this.l;
            }
            textView2.setText(str);
            return;
        }
        if (i != 1) {
            if (i == 2) {
                double dH = H(this.J.b());
                TextView textView3 = this.x;
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.footer_filter));
                sb.append(numberFormat.format(dH));
                if (Z00.Z) {
                    str = "\t" + this.l;
                }
                sb.append(str);
                textView3.setText(sb.toString());
                if (dH >= 0.0d) {
                    this.y.setImageResource(this.O[2]);
                    return;
                } else {
                    this.y.setImageResource(this.O[0]);
                    return;
                }
            }
            return;
        }
        this.x.setText(this.b0);
        try {
            if (this.u0.size() > 0) {
                if (Double.parseDouble((String) this.u0.get(0)) >= 0.0d) {
                    this.y.setImageResource(this.O[2]);
                    TextView textView4 = this.x;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.d0);
                    sb2.append(numberFormat.format(Double.parseDouble((String) this.u0.get(0))));
                    if (Z00.Z) {
                        str = "\t" + this.l;
                    }
                    sb2.append(str);
                    textView4.setText(sb2.toString());
                    return;
                }
                this.y.setImageResource(this.O[0]);
                TextView textView5 = this.x;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.c0);
                sb3.append(numberFormat.format(Double.parseDouble((String) this.u0.get(0))));
                if (Z00.Z) {
                    str = "\t" + this.l;
                }
                sb3.append(str);
                textView5.setText(sb3.toString());
            }
        } catch (Exception unused) {
        }
    }

    public void F() {
        Log.d("get_all_names", "get_all_names:" + this.j);
        z(0);
    }

    public void G() {
        F();
    }

    public double H(List list) {
        double d = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            int i = 0;
            if (((C0795Oh) list.get(size)).r() == this.O[0]) {
                i = -1;
            } else if (((C0795Oh) list.get(size)).r() == this.O[2]) {
                i = 1;
            }
            d += Double.parseDouble(((C0795Oh) list.get(size)).l().replaceAll(",", "")) * ((double) i);
        }
        return d;
    }

    public boolean I() {
        this.k0 = this.k0.isEmpty() ? CSS.Value.PERCENTAGE : this.k0;
        this.l0 = this.l0.isEmpty() ? CSS.Value.PERCENTAGE : this.l0;
        return (this.k0.equals(CSS.Value.PERCENTAGE) && this.l0.equals(CSS.Value.PERCENTAGE)) ? false : true;
    }

    public boolean J() {
        SearchView searchView = this.v0;
        return searchView == null || searchView.getQuery() == null || this.v0.getQuery().length() != 0;
    }

    public final /* synthetic */ Integer Q() {
        k0(this.J.b());
        this.t = 1;
        return 1;
    }

    public final /* synthetic */ void R(Integer num) {
        i0(false);
        this.J.notifyDataSetChanged();
        a0();
    }

    public final /* synthetic */ Integer S(String str) throws Throwable {
        new C3357m10(getActivity(), this.h).e(this.H, this.h.ic(str), H(this.J.b()), this.l);
        return 1;
    }

    public final /* synthetic */ void T(String str, Integer num) {
        i0(false);
        this.h.pa(this.h.ic(str) + ".xls");
    }

    public final /* synthetic */ Integer U() {
        k0(this.J.b());
        this.t = 1;
        return 1;
    }

    public final /* synthetic */ void V(Integer num) {
        i0(false);
        this.J.notifyDataSetChanged();
        c0();
    }

    public void W(View view) {
        this.j0 = 0;
        F();
    }

    public void X(String str) {
        Log.d("trace_2QueryText2=", "start:" + str);
        try {
            if (this.J != null) {
                z(-1);
            }
        } catch (Exception unused) {
        }
    }

    public void Y(List list) {
        Log.d("trace_on_load_finish=", "onLoadFinished:" + this.j + ":" + this.l);
        Log.d("trace_lv_refresh:", HTML.Attribute.START);
        try {
            this.V = new C(this, null);
            Log.d("trace_lv_refresh:", "end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Z() {
        if (!this.h.ja("prefPrintSort", true)) {
            a0();
        } else {
            i0(true);
            AbstractC3132jE.d(new Callable() { // from class: qo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.Q();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: ro
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.R((Integer) obj);
                }
            });
        }
    }

    @Override // defpackage.C4330y1.c
    public void a(int i) {
        if (this.U == null) {
            this.U = getActivity().startActionMode(this.V);
        }
        this.J.m(i);
        this.U.invalidate();
        int iC = this.J.c();
        if (iC <= 0) {
            this.U.finish();
            return;
        }
        this.U.setTitle(iC + " Selected");
    }

    public void a0() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) getActivity().getTitle());
            sb.append("#");
            sb.append(this.k);
            if (Z00.Z) {
                str = "-" + this.l;
            } else {
                str = "";
            }
            sb.append(str);
            final String string = sb.toString();
            i0(true);
            AbstractC3132jE.d(new Callable() { // from class: ko
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.S(string);
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: lo
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.T(string, (Integer) obj);
                }
            });
        } catch (Exception unused) {
        }
    }

    public void amount_add_btn(View view) {
        startActivity(new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit.class));
    }

    public void b0() {
        if (!this.h.ja("prefPrintSort", true)) {
            c0();
        } else {
            i0(true);
            AbstractC3132jE.d(new Callable() { // from class: oo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.U();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: po
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.V((Integer) obj);
                }
            });
        }
    }

    public void btn_cus_remove(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getString(R.string.delete_msg));
        TextView textView = (TextView) ((RelativeLayout) ((View) view.getParent()).getParent()).findViewById(R.id.tr_id);
        Log.d("tr_id:=", textView.getText().toString());
        this.q = Integer.parseInt(textView.getText().toString());
        builder.setPositiveButton("Yes", new l());
        builder.setNegativeButton("No", new m());
        builder.create().show();
    }

    public void c0() {
        i0(true);
        new Thread(new RunnableC4402f()).start();
    }

    public void help_btn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new C4404h());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new DialogInterfaceOnClickListenerC4405i());
        builder.show();
    }

    public void i0(boolean z2) {
        try {
            if (z2) {
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                this.o0 = progressDialog;
                progressDialog.setMessage(getString(R.string.google_drive_list));
                this.o0.show();
            } else {
                this.o0.hide();
            }
        } catch (Exception unused) {
        }
    }

    public void o0(View view) {
        if (this.t == 0) {
            j0(this.K);
            this.t = 1;
        } else {
            h0(this.K);
            this.t = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.y0 = activity;
        try {
            this.T = (H) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s0(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.j = getArguments() != null ? getArguments().getString("cus_id") : "";
            this.k = getArguments() != null ? getArguments().getString("cus_name") : "";
            this.l = getArguments() != null ? getArguments().getString("curr_name") : "";
            this.W = getArguments() != null ? getArguments().getInt("size") : 0;
            this.h = new Z00(this.g, getActivity());
            C0596Ih c0596Ih = (C0596Ih) ViewModelProviders.of(this).get(C0596Ih.class);
            this.X = c0596Ih;
            c0596Ih.a.observe(this, new k());
            this.X.b.observe(this, new u());
            this.X.d.observe(this, new v());
            this.X.c.observe(this, new w());
            this.X.e.observe(this, new x());
            this.X.h.observe(this, new y());
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main_all2, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_customer_det_all_rv, viewGroup, false);
        this.h = new Z00(this.g, getActivity());
        setHasOptionsMenu(true);
        Log.d("OnCreate:=", "onCreateView_all:" + this.j);
        if (this.H == null) {
            this.H = (RecyclerView) viewInflate.findViewById(R.id.list_cus_det);
            this.H.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
            TextView textView = (TextView) viewInflate.findViewById(R.id.emptyResults);
            this.I = textView;
            textView.setText(getString(R.string.wait));
        }
        this.x = (TextView) viewInflate.findViewById(R.id.footer_sum);
        this.y = (ImageView) viewInflate.findViewById(R.id.img);
        this.z = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
        this.A = (ImageView) viewInflate.findViewById(R.id.img_help);
        this.z.setOnClickListener(this.t0);
        this.A.setOnClickListener(this.t0);
        this.e0 = (ImageView) viewInflate.findViewById(R.id.move_right);
        this.f0 = (ImageView) viewInflate.findViewById(R.id.move_left);
        this.e0.setOnClickListener(this.t0);
        this.f0.setOnClickListener(this.t0);
        if (this.W <= 1) {
            this.e0.setVisibility(8);
            this.f0.setVisibility(8);
        }
        this.B = (TextView) viewInflate.findViewById(R.id.tr_date);
        this.C = (TextView) viewInflate.findViewById(R.id.tr_amount);
        this.D = (TextView) viewInflate.findViewById(R.id.tr_remarks);
        this.F = (TextView) viewInflate.findViewById(R.id.tr_name);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B.setTextColor(-1);
        this.C.setTextColor(-1);
        this.D.setTextColor(-1);
        this.F.setTextColor(-1);
        this.h.ld(getActivity(), this.B, this.t);
        TextView textView2 = this.B;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.F;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.C;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.D;
        textView5.setPaintFlags(8 | textView5.getPaintFlags());
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(getActivity(), this.B);
        c0372Bn.a(getActivity(), this.F);
        c0372Bn.a(getActivity(), this.C);
        c0372Bn.a(getActivity(), this.D);
        this.b0 = getActivity().getString(R.string.footer_cus_null);
        this.c0 = this.h.Q2() + ":-";
        this.d0 = this.h.c5() + ":-";
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.Q = calendar.get(1);
        this.R = calendar.get(2);
        this.S = calendar.get(5);
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getActivity());
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        z(0);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.y0 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        String str = "";
        if (itemId == R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                y();
            }
            StringBuilder sb = new StringBuilder();
            sb.append((Object) getActivity().getTitle());
            sb.append("#");
            sb.append(this.k);
            if (Z00.Z) {
                str = "-" + this.l;
            }
            sb.append(str);
            this.x0 = sb.toString();
            try {
                if (I()) {
                    b0();
                } else {
                    z(1);
                }
            } catch (Exception unused) {
            }
            return true;
        }
        if (itemId == R.id.adv_search) {
            w();
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
            y();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) getActivity().getTitle());
        sb2.append("#");
        sb2.append(this.k);
        if (Z00.Z) {
            str = "-" + this.l;
        }
        sb2.append(str);
        this.x0 = sb2.toString();
        try {
            if (I()) {
                Z();
            } else {
                z(2);
            }
        } catch (Exception unused2) {
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        this.v0 = (SearchView) MenuItemCompat.getActionView(menuItemFindItem);
        this.v0.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        this.v0.setQueryHint(getActivity().getString(R.string.search_hint));
        this.v0.setOnQueryTextListener(new r());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new s());
        super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            x(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        StringBuilder sb = new StringBuilder();
        sb.append(Bill_edit.P2);
        sb.append(":");
        String str = this.l;
        if (str == null) {
            str = "Null";
        }
        sb.append(str);
        sb.append(":Frag_Customer_Det_All::");
        sb.append(isResumed());
        sb.append(":");
        sb.append(getUserVisibleHint());
        Log.d("onresume=", sb.toString());
        try {
            if (Bill_edit.P2 && getUserVisibleHint()) {
                z(0);
                Bill_edit.P2 = false;
                Bill_edit.Q2 = false;
                Bill_edit.R2 = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void q0(View view) {
        if (this.t == 0) {
            l0(this.K);
            this.t = 1;
        } else {
            e0(this.K);
            this.t = 0;
        }
    }

    public void r0(View view) {
        if (this.t == 0) {
            m0(this.K);
            this.t = 1;
        } else {
            f0(this.K);
            this.t = 0;
        }
    }

    public void s0(View view) {
        i0(true);
        new Thread(new RunnableC4403g(view)).start();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
    }

    public void t0(View view) {
        if (this.t == 0) {
            n0(this.K);
            this.t = 1;
        } else {
            g0(this.K);
            this.t = 0;
        }
    }

    public void w() {
        try {
            this.j0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.m0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.n0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.m0.setOnClickListener(new B());
            this.n0.setOnClickListener(new ViewOnClickListenerC4397a());
            builder.setPositiveButton(getString(R.string.btn_search), new DialogInterfaceOnClickListenerC4398b());
            builder.setNegativeButton(getString(R.string.btn_cancel), new DialogInterfaceOnClickListenerC4399c());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC4400d(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void y() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    private void A() {
    }

    /* JADX INFO: renamed from: yo$b, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC4398b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4398b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: yo$m */
    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: yo$t */
    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    @Override // defpackage.DE
    public void c(int i, C4064uh c4064uh) {
    }

    @Override // defpackage.DE
    public void e(int i, C4145vh c4145vh) {
    }

    public ViewOnClickListenerC4396yo(C0917Sq c0917Sq, int i, int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", c0917Sq.c());
        bundle.putString("cus_name", c0917Sq.e());
        bundle.putString("curr_name", c0917Sq.a());
        bundle.putInt(CSS.Property.POSITION, i);
        bundle.putInt("size", i2);
        bundle.putString("searchString", str);
        setArguments(bundle);
    }
}
