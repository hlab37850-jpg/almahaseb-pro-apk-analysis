package info.aalmoghalis.inventory.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
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
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C0908Sh;
import defpackage.C0922Sv;
import defpackage.C2137ei;
import defpackage.C2160f10;
import defpackage.C3966tX;
import defpackage.C4145vh;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class h extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<C4145vh>> {
    public static int w0;
    public C0922Sv H;
    public D O;
    public ImageView S;
    public ImageView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;
    public TextView a0;
    public TextView b0;
    public int e0;
    public int f0;
    public SQLiteDatabase g;
    public int g0;
    public Z00 h;
    public String k;
    public String l;
    public String n;
    public AlertDialog.Builder q0;
    public View r0;
    public Activity v0;
    public double i = 0.0d;
    public int j = 0;
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
    public Button E = null;
    public ListView F = null;
    public TextView G = null;
    public List I = new ArrayList();
    public ImageButton J = null;
    public String[] K = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] L = {R.drawable.up, 1, R.drawable.down};
    public Toolbar M = null;
    public int N = 0;
    public String P = "";
    public String Q = "";
    public String R = "";
    public DatePickerDialog.OnDateSetListener c0 = new B();
    public DatePickerDialog.OnDateSetListener d0 = new C();
    public int h0 = 0;
    public String i0 = CSS.Value.PERCENTAGE;
    public String j0 = CSS.Value.PERCENTAGE;
    public TextView k0 = null;
    public TextView l0 = null;
    public ProgressDialog m0 = null;
    public int n0 = 0;
    public View.OnClickListener o0 = new o();
    public Dialog p0 = null;
    public Handler s0 = new r();
    public String t0 = "";
    public ArrayList u0 = new ArrayList();

    public class A implements View.OnClickListener {
        public A() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                h.this.S(view);
            } catch (Exception unused) {
            }
        }
    }

    public class B implements DatePickerDialog.OnDateSetListener {
        public B() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                h.this.k0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                h hVar = h.this;
                hVar.i0 = hVar.k0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public class C implements DatePickerDialog.OnDateSetListener {
        public C() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                h.this.l0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                h hVar = h.this;
                hVar.j0 = hVar.l0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public interface D {
        void onButtonClicked(View view);
    }

    public class E implements Comparator {
        public int a;

        public E(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 5) {
                return Double.valueOf(c4145vh.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.q().replaceAll(",", "")));
            }
            return i == 6 ? Double.valueOf(c4145vh.r().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.r().replaceAll(",", ""))) : Double.valueOf(c4145vh.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.p().replaceAll(",", "")));
        }
    }

    public class F implements Comparator {
        public int a;

        public F(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 5) {
                return Double.valueOf(c4145vh2.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.q().replaceAll(",", "")));
            }
            return i == 6 ? Double.valueOf(c4145vh2.r().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.r().replaceAll(",", ""))) : Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.h$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3054a implements View.OnClickListener {
        public ViewOnClickListenerC3054a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", h.this.e0);
                bundle.putInt("month", h.this.f0);
                bundle.putInt("day", h.this.g0);
                c2137ei.setArguments(bundle);
                c2137ei.f(h.this.c0);
                c2137ei.show(h.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.h$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3055b implements View.OnClickListener {
        public ViewOnClickListenerC3055b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", h.this.e0);
                bundle.putInt("month", h.this.f0);
                bundle.putInt("day", h.this.g0);
                c2137ei.setArguments(bundle);
                c2137ei.f(h.this.d0);
                c2137ei.show(h.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(h.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.h$c, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3056c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3056c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.h$d, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3057d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3057d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                h hVar = h.this;
                hVar.h0 = 0;
                hVar.u();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.h$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3058e implements View.OnClickListener {
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public ViewOnClickListenerC3058e(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                h hVar = h.this;
                hVar.h0 = 1;
                if (hVar.k0.getText() == null) {
                    h.this.i0 = "";
                } else {
                    h hVar2 = h.this;
                    hVar2.i0 = hVar2.k0.getText().toString();
                }
                if (h.this.l0.getText() == null) {
                    h.this.j0 = "";
                } else {
                    h hVar3 = h.this;
                    hVar3.j0 = hVar3.l0.getText().toString();
                }
                h.this.u();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.h$f, reason: case insensitive filesystem */
    public class C3059f implements Comparator {
        public C3059f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.o()).compareTo(String.valueOf(c4145vh.o()));
        }
    }

    public class g implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.o()).compareTo(String.valueOf(c4145vh2.o()));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.h$h, reason: collision with other inner class name */
    public class C0306h implements Comparator {
        public C0306h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh2.n().compareTo(String.valueOf(c4145vh.n()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            if (Integer.parseInt(c4145vh2.v()) != Integer.parseInt(c4145vh.v())) {
                return Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v());
            }
            return -1;
        }
    }

    public class i implements Comparator {
        public i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh.n().compareTo(String.valueOf(c4145vh2.n()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            if (Integer.parseInt(c4145vh.v()) != Integer.parseInt(c4145vh2.v())) {
                return Integer.parseInt(c4145vh.v()) - Integer.parseInt(c4145vh2.v());
            }
            return -1;
        }
    }

    public class j implements AdapterView.OnItemClickListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            C4145vh c4145vh = (C4145vh) h.this.F.getAdapter().getItem(i);
            h.w0 = h.this.F.getFirstVisiblePosition();
            Log.d("lv_click=", c4145vh.v() + ":" + c4145vh.f() + ":" + h.this.k);
            if (c4145vh.v().equals("-1")) {
                h hVar = h.this;
                hVar.h.u9(hVar.k, h.this.getActivity());
            } else {
                double d = Double.parseDouble(c4145vh.p().replaceAll(",", "")) + Double.parseDouble(c4145vh.q().replaceAll(",", ""));
                h hVar2 = h.this;
                hVar2.h.m9(hVar2.getActivity(), c4145vh.v(), c4145vh.f().replaceAll("-", ""), c4145vh.s(), h.this.k, h.this.h.P7(String.valueOf(d)), c4145vh.n());
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.m0.dismiss();
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ View a;

        public l(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    h.this.R(this.a);
                    h.this.n0 = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    h.this.P(this.a);
                    h.this.n0 = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    h.this.Q(this.a);
                    h.this.n0 = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    h.this.O(this.a, 4);
                    h.this.n0 = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    h.this.O(this.a, 5);
                    h.this.n0 = 5;
                    break;
                case R.id.f6 /* 2131296729 */:
                    h.this.O(this.a, 6);
                    h.this.n0 = 6;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            h.this.s0.sendMessage(message);
        }
    }

    public class m extends WebViewClient {
        public m() {
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

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                h.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                h.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                h.this.B(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                h.this.O.onButtonClicked(view);
            }
        }
    }

    public class p implements Comparator {
        public p() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a()));
        }
    }

    public class q implements Comparator {
        public q() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a()));
        }
    }

    public class r extends Handler {
        public r() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            h.this.J(false);
            if (message.obj.toString().equals("0")) {
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = h.this.h;
                StringBuilder sb = new StringBuilder();
                h hVar = h.this;
                sb.append(hVar.h.ic(hVar.t0));
                sb.append(".pdf");
                z00.ra(sb.toString());
                return;
            }
            if (message.obj.toString().equals("3")) {
                h.this.H.notifyDataSetChanged();
                h hVar2 = h.this;
                Z00 z01 = hVar2.h;
                FragmentActivity activity = hVar2.getActivity();
                h hVar3 = h.this;
                z01.lc(activity, hVar3.U, hVar3.V, hVar3.W, hVar3.X, hVar3.Y, hVar3.Z);
                h hVar4 = h.this;
                int i = hVar4.n0;
                if (i == 1) {
                    Z00 z02 = hVar4.h;
                    FragmentActivity activity2 = hVar4.getActivity();
                    h hVar5 = h.this;
                    z02.ld(activity2, hVar5.U, hVar5.p);
                    return;
                }
                if (i == 2) {
                    Z00 z03 = hVar4.h;
                    FragmentActivity activity3 = hVar4.getActivity();
                    h hVar6 = h.this;
                    z03.ld(activity3, hVar6.V, hVar6.p);
                    return;
                }
                if (i == 3) {
                    Z00 z04 = hVar4.h;
                    FragmentActivity activity4 = hVar4.getActivity();
                    h hVar7 = h.this;
                    z04.ld(activity4, hVar7.W, hVar7.p);
                    return;
                }
                if (i == 4) {
                    Z00 z05 = hVar4.h;
                    FragmentActivity activity5 = hVar4.getActivity();
                    h hVar8 = h.this;
                    z05.ld(activity5, hVar8.X, hVar8.p);
                    return;
                }
                if (i == 5) {
                    Z00 z06 = hVar4.h;
                    FragmentActivity activity6 = hVar4.getActivity();
                    h hVar9 = h.this;
                    z06.ld(activity6, hVar9.Y, hVar9.p);
                    return;
                }
                if (i == 6) {
                    Z00 z07 = hVar4.h;
                    FragmentActivity activity7 = hVar4.getActivity();
                    h hVar10 = h.this;
                    z07.ld(activity7, hVar10.Z, hVar10.p);
                }
            }
        }
    }

    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            Z00 z00 = hVar.h;
            ListView listView = hVar.F;
            String strIc = z00.ic(hVar.t0);
            h hVar2 = h.this;
            z00.cb(listView, strIc, hVar2.i0, hVar2.j0, true, false);
            Message message = new Message();
            message.obj = "1";
            h.this.s0.sendMessage(message);
        }
    }

    public class t implements SearchView.OnQueryTextListener {
        public t() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            h.this.D(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                h.this.S(view);
            } catch (Exception unused) {
            }
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                h.this.S(view);
            } catch (Exception unused) {
            }
        }
    }

    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                h.this.S(view);
            } catch (Exception unused) {
            }
        }
    }

    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                h.this.S(view);
            } catch (Exception unused) {
            }
        }
    }

    public class z implements View.OnClickListener {
        public z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                h.this.S(view);
            } catch (Exception unused) {
            }
        }
    }

    public h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Integer num) {
        if (getActivity() != null) {
            FragmentManager fragmentManager = getFragmentManager();
            for (int i2 = 0; i2 < fragmentManager.getFragments().size(); i2++) {
                FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                fragmentTransactionBeginTransaction.remove(fragmentManager.getFragments().get(i2));
                fragmentTransactionBeginTransaction.commit();
            }
            getActivity().recreate();
        }
    }

    private void F(List list) {
        Collections.sort(list, Collections.reverseOrder(new i()));
    }

    private void G(List list) {
        Collections.sort(list, Collections.reverseOrder(new g()));
    }

    private void H(List list) {
        Collections.sort(list, Collections.reverseOrder(new q()));
    }

    private void I(List list, int i2) {
        Collections.sort(list, new F(i2));
    }

    private void K(List list, int i2) {
        Collections.sort(list, new E(i2));
    }

    private void L(List list) {
        Collections.sort(list, Collections.reverseOrder(new C0306h()));
    }

    private void M(List list) {
        Collections.sort(list, Collections.reverseOrder(new C3059f()));
    }

    private void N(List list) {
        Collections.sort(list, Collections.reverseOrder(new p()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(View view) {
        if (this.p == 0) {
            L(this.I);
            this.p = 1;
        } else {
            F(this.I);
            this.p = 0;
        }
    }

    private void o(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new v()).show();
    }

    private void r() {
        int i2 = Calendar.getInstance().get(14);
        Log.d("data_loader=", i2 + "");
        getActivity().getSupportLoaderManager().initLoader(i2, null, this).forceLoad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer x() {
        s();
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Integer num) {
        t();
        J(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer z() {
        this.h.Vb();
        return 1;
    }

    public void B(View view) {
        this.h0 = 0;
        u();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        TextView textView;
        try {
            ListView listView = this.F;
            if (listView != null && (textView = this.G) != null) {
                listView.setEmptyView(textView);
            }
            this.I = list;
            Log.d("onloadfinish=", isAdded() + ":" + w0 + ":" + this.k);
            Log.d("trace_E_Loader=", FragmentStatePagerSupport_Main.X() + "#" + this.k + ":" + this.i0 + ":" + this.j0);
            if (getActivity() != null) {
                if (this.H == null) {
                    Log.d("listviewadapter=", "null:" + this.k);
                    Z00 z00 = this.h;
                    StringBuilder sb = new StringBuilder();
                    sb.append("select * from items_cost_calc a where round(a.n_q,7)<0 and a.item_id=(select id from items where name='");
                    sb.append(this.k);
                    sb.append("') ");
                    this.H = new C0922Sv(getActivity(), R.layout.data_det_row_rep3, this.I, 18, z00.f9(sb.toString()) > 0);
                    F(this.I);
                    this.H.notifyDataSetChanged();
                    this.p = 0;
                    this.F.setAdapter((ListAdapter) this.H);
                } else {
                    Log.d("listviewadapter=", "not_null");
                    this.H.notifyDataSetChanged();
                }
                q();
                this.G.setText(getString(R.string.no_results));
            }
        } catch (Exception e) {
            Log.d("fetch_err=", e.getMessage() + "");
        }
    }

    public void D(String str) {
        try {
            this.H.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    public void E(boolean z2) {
        J(true);
        new Thread(new s()).start();
    }

    public void J(boolean z2) {
        try {
            Dialog dialog = this.p0;
            if (dialog == null) {
                return;
            }
            if (z2) {
                dialog.cancel();
                this.p0.hide();
                this.p0.dismiss();
                this.p0.show();
            } else {
                dialog.cancel();
                this.p0.hide();
                this.p0.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O(View view, int i2) {
        if (this.p == 0) {
            K(this.I, i2);
            this.p = 1;
        } else {
            I(this.I, i2);
            this.p = 0;
        }
    }

    public void Q(View view) {
        if (this.p == 0) {
            M(this.I);
            this.p = 1;
        } else {
            G(this.I);
            this.p = 0;
        }
    }

    public void R(View view) {
        if (this.p == 0) {
            N(this.I);
            this.p = 1;
        } else {
            H(this.I);
            this.p = 0;
        }
    }

    public void S(View view) {
        J(true);
        new Thread(new l(view)).start();
    }

    public void amount_add_btn(View view) {
        Bill_edit.P2 = true;
        this.h.z(getActivity(), this.h.D2(this.l), this.l);
    }

    public void help_btn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new m());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new n());
        builder.show();
    }

    public void n() {
        try {
            this.h0 = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.k0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.l0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.k0.setOnClickListener(new ViewOnClickListenerC3054a());
            this.l0.setOnClickListener(new ViewOnClickListenerC3055b());
            builder.setPositiveButton(getActivity().getString(R.string.btn_search), new DialogInterfaceOnClickListenerC3056c());
            builder.setNegativeButton(getActivity().getString(R.string.btn_cancel), new DialogInterfaceOnClickListenerC3057d());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC3058e(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.v0 = activity;
        try {
            this.O = (D) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressDialog progressDialog = new ProgressDialog(view.getContext());
        this.m0 = progressDialog;
        progressDialog.setCancelable(true);
        this.m0.setMessage("Processing...");
        this.m0.setProgressStyle(0);
        this.m0.setMax(10);
        this.m0.show();
        this.I = this.H.e;
        if (view.getId() == R.id.f1) {
            R(view);
        }
        new Handler().postDelayed(new k(), 400L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new Z00(this.g, getActivity());
            this.k = getArguments() != null ? getArguments().getString("item_name") : "";
            this.l = getArguments() != null ? getArguments().getString("br_name") : "";
            this.i0 = getArguments() != null ? getArguments().getString("f_date") : "";
            this.j0 = getArguments() != null ? getArguments().getString("t_date") : "";
            this.N = getArguments() != null ? getArguments().getInt("size") : 0;
            this.n = getArguments() != null ? getArguments().getString("unit_name") : "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4145vh>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_Loader=", "br=" + this.l + ":item=" + this.k + ":" + this.n + ":" + this.i0 + ":" + this.j0);
        isAdded();
        return new C0908Sh(getActivity(), this.k, this.l, this.h, 43, this.i0, this.j0, this.n);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new t());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        try {
            View viewInflate = layoutInflater.inflate(R.layout.data_listview_rep1_2, viewGroup, false);
            this.h = new Z00(this.g, getActivity());
            setHasOptionsMenu(true);
            w(viewInflate);
            if (this.F == null) {
                this.F = (ListView) viewInflate.findViewById(R.id.list_items);
                TextView textView = (TextView) viewInflate.findViewById(android.R.id.empty);
                this.G = textView;
                textView.setText(getString(R.string.wait));
                this.F.setEmptyView(this.G);
            }
            this.F.setOnItemClickListener(new j());
            v();
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.footer_sum);
            this.v = textView2;
            StringBuilder sb = new StringBuilder();
            sb.append(this.l);
            if (this.n.length() > 0) {
                str = "(" + this.n + ")";
            } else {
                str = "";
            }
            sb.append(str);
            textView2.setText(sb.toString());
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
            this.x = imageView;
            imageView.setOnClickListener(this.o0);
            this.S = (ImageView) viewInflate.findViewById(R.id.move_right);
            this.T = (ImageView) viewInflate.findViewById(R.id.move_left);
            this.S.setOnClickListener(this.o0);
            this.T.setOnClickListener(this.o0);
            if (this.N <= 1) {
                this.S.setVisibility(8);
                this.T.setVisibility(8);
            }
            this.P = getActivity().getString(R.string.footer_cus_null);
            this.Q = getActivity().getString(R.string.tot_radio1);
            this.R = getActivity().getString(R.string.tot_radio2);
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.e0 = calendar.get(1);
            this.f0 = calendar.get(2);
            this.g0 = calendar.get(5);
            try {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(getActivity());
                Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(viewConfiguration, false);
                }
            } catch (Exception unused) {
            }
            r();
            return viewInflate;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("oncreateview_err=", e.getMessage());
            return null;
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C4145vh>> loader) {
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                p();
            }
            try {
                if (this.h.ja("prefPrintSort", true)) {
                    L(this.I);
                    this.H.notifyDataSetChanged();
                    this.p = 1;
                }
                if (this.n.equals("")) {
                    this.t0 = getActivity().getTitle().toString() + "-" + this.l;
                } else {
                    this.t0 = getActivity().getTitle().toString() + "(" + this.n + ")-" + this.l;
                }
                E(false);
            } catch (Exception unused) {
            }
            return true;
        }
        if (itemId != R.id.print2) {
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
        try {
            if (this.h.ja("prefPrintSort", true)) {
                L(this.I);
                this.H.notifyDataSetChanged();
                this.p = 1;
            }
            if (this.n.equals(".")) {
                this.t0 = getActivity().getTitle().toString() + "#" + this.l;
            } else {
                this.t0 = getActivity().getTitle().toString() + "(" + this.n + ")#" + this.l;
            }
            E(true);
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
            o(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            Bill_edit.Q2 = true;
            new C3966tX().A(getActivity(), this.F, this.G, -1);
            AbstractC3132jE.d(new Callable() { // from class: Ko
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.z();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Lo
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.A((Integer) obj);
                }
            });
        }
    }

    public void p() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void q() {
        try {
            Log.d("lv_pos=", w0 + ":" + getUserVisibleHint() + ":" + this.k);
            if (getUserVisibleHint()) {
                if (w0 <= 0) {
                    w0 = 0;
                    return;
                }
                if (this.F.getFirstVisiblePosition() > w0 || this.F.getLastVisiblePosition() < w0) {
                    this.F.setSelection(w0);
                }
                w0 = 0;
            }
        } catch (Exception e) {
            w0 = 0;
            e.printStackTrace();
        }
    }

    public void s() {
        Cursor cursorF7;
        h hVar = this;
        Log.d("get_all_names", "get_all_names:" + hVar.k + ":" + hVar.h0);
        if (hVar.h0 == 0) {
            cursorF7 = hVar.h.f7(hVar.k, hVar.l, hVar.n, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            boolean zIsEmpty = hVar.i0.isEmpty();
            String str = CSS.Value.PERCENTAGE;
            hVar.i0 = zIsEmpty ? CSS.Value.PERCENTAGE : hVar.i0;
            if (!hVar.j0.isEmpty()) {
                str = hVar.j0;
            }
            hVar.j0 = str;
            new C2160f10(hVar.h).W(hVar.j0);
            cursorF7 = hVar.h.f7(hVar.k, hVar.l, hVar.n, hVar.i0, hVar.j0);
        }
        hVar.i = 0.0d;
        hVar.I.clear();
        cursorF7.moveToFirst();
        C0566Hd c0566Hd = new C0566Hd();
        while (!cursorF7.isAfterLast()) {
            hVar.I.add(new C4145vh(cursorF7.getString(c0566Hd.b(cursorF7, "_id")), cursorF7.getString(c0566Hd.b(cursorF7, "f1")), cursorF7.getString(c0566Hd.b(cursorF7, "f2")), cursorF7.getString(c0566Hd.b(cursorF7, "f3")), "" + cursorF7.getDouble(c0566Hd.b(cursorF7, "f4")), "" + cursorF7.getDouble(c0566Hd.b(cursorF7, "f5")), "" + cursorF7.getDouble(c0566Hd.b(cursorF7, "f6")), cursorF7.getString(c0566Hd.b(cursorF7, "f7")), "" + cursorF7.getDouble(c0566Hd.b(cursorF7, "f8")), "" + cursorF7.getDouble(c0566Hd.b(cursorF7, "f9")), "" + cursorF7.getDouble(c0566Hd.b(cursorF7, "f10")), "" + cursorF7.getDouble(c0566Hd.b(cursorF7, "f11")), cursorF7.getString(c0566Hd.b(cursorF7, "f12")), cursorF7.getString(c0566Hd.b(cursorF7, "f13"))));
            cursorF7.moveToNext();
            hVar = this;
        }
        cursorF7.close();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && this.k != null && isResumed()) {
            r();
        }
    }

    public void t() {
        if (getActivity() != null) {
            Z00 z00 = this.h;
            StringBuilder sb = new StringBuilder();
            sb.append("select * from items_cost_calc a where round(a.n_q,7)<0 and a.item_id=(select id from items where name='");
            sb.append(this.k);
            sb.append("') ");
            C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep3, this.I, 18, z00.f9(sb.toString()) > 0);
            this.H = c0922Sv;
            this.F.setAdapter((ListAdapter) c0922Sv);
            this.G.setText(getString(R.string.no_results));
        }
    }

    public void u() {
        J(true);
        AbstractC3132jE.d(new Callable() { // from class: Mo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.x();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: No
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.y((Integer) obj);
            }
        });
    }

    public void v() {
        if (this.p0 != null) {
            return;
        }
        try {
            this.q0 = new AlertDialog.Builder(getActivity());
            View viewInflate = getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null);
            this.r0 = viewInflate;
            this.q0.setView(viewInflate);
            this.p0 = this.q0.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void w(View view) {
        if (view != null) {
            this.U = (TextView) view.findViewById(R.id.f1);
            this.V = (TextView) view.findViewById(R.id.f2);
            this.W = (TextView) view.findViewById(R.id.f3);
            this.X = (TextView) view.findViewById(R.id.f4);
            this.Y = (TextView) view.findViewById(R.id.f5);
            this.Z = (TextView) view.findViewById(R.id.f6);
            this.a0 = (TextView) view.findViewById(R.id.f7);
            this.b0 = (TextView) view.findViewById(R.id.f8);
        } else {
            this.U = (TextView) view.findViewById(R.id.f1);
            this.V = (TextView) view.findViewById(R.id.f2);
            this.W = (TextView) view.findViewById(R.id.f3);
            this.X = (TextView) view.findViewById(R.id.f4);
            this.Y = (TextView) view.findViewById(R.id.f5);
            this.Z = (TextView) view.findViewById(R.id.f6);
            this.a0 = (TextView) view.findViewById(R.id.f7);
            this.b0 = (TextView) view.findViewById(R.id.f8);
        }
        this.a0.setVisibility(8);
        this.b0.setVisibility(8);
        this.U.setText(getString(R.string.inv_type));
        this.V.setText(getString(R.string.date));
        this.W.setText(getString(R.string.name));
        this.X.setText(getString(R.string.bal_in));
        this.Y.setText(getString(R.string.bal_move));
        this.Z.setText(getString(R.string.balance2));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(getActivity(), this.U);
        c0372Bn.a(getActivity(), this.V);
        c0372Bn.a(getActivity(), this.W);
        TextView textView = this.U;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.V;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.W;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.X;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.Y;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.Z.setPaintFlags(8 | this.Y.getPaintFlags());
        this.h.ld(getActivity(), this.V, this.p);
        this.U.setOnClickListener(new u());
        this.V.setOnClickListener(new w());
        this.W.setOnClickListener(new x());
        this.X.setOnClickListener(new y());
        this.Y.setOnClickListener(new z());
        this.Z.setOnClickListener(new A());
    }

    public h(C4145vh c4145vh, int i2, int i3, String str) {
        try {
            Log.d("item_det=", "Frag_Report1_Items_Balance_Det2:");
            Bundle bundle = new Bundle();
            Log.d("frag_click=", FragmentStatePagerSupport.S + ":" + c4145vh.a() + ":" + c4145vh.n());
            bundle.putString("item_name", c4145vh.a());
            bundle.putString("br_name", FragmentStatePagerSupport.M);
            bundle.putString("unit_name", c4145vh.n());
            bundle.putString("f_date", FragmentStatePagerSupport.O);
            bundle.putString("t_date", FragmentStatePagerSupport.P);
            bundle.putInt(CSS.Property.POSITION, i2);
            bundle.putInt("size", i3);
            bundle.putString("searchString", str);
            setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
