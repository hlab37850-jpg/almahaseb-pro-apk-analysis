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
public class i extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<C4145vh>> {
    public static int v0;
    public C0922Sv G;
    public D N;
    public ImageView R;
    public ImageView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;
    public TextView a0;
    public int d0;
    public int e0;
    public int f0;
    public SQLiteDatabase g;
    public Z00 h;
    public String k;
    public String l;
    public AlertDialog.Builder p0;
    public View q0;
    public Activity u0;
    public double i = 0.0d;
    public int j = 0;
    public int n = 0;
    public AutoCompleteTextView p = null;
    public EditText q = null;
    public EditText t = null;
    public TextView u = null;
    public ImageView v = null;
    public ImageView w = null;
    public ImageView x = null;
    public TextView y = null;
    public TextView z = null;
    public TextView A = null;
    public TextView B = null;
    public TextView C = null;
    public Button D = null;
    public ListView E = null;
    public TextView F = null;
    public List H = new ArrayList();
    public ImageButton I = null;
    public String[] J = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] K = {R.drawable.up, 1, R.drawable.down};
    public Toolbar L = null;
    public int M = 0;
    public String O = "";
    public String P = "";
    public String Q = "";
    public DatePickerDialog.OnDateSetListener b0 = new B();
    public DatePickerDialog.OnDateSetListener c0 = new C();
    public int g0 = 0;
    public String h0 = CSS.Value.PERCENTAGE;
    public String i0 = CSS.Value.PERCENTAGE;
    public TextView j0 = null;
    public TextView k0 = null;
    public ProgressDialog l0 = null;
    public int m0 = 0;
    public View.OnClickListener n0 = new o();
    public Dialog o0 = null;
    public Handler r0 = new r();
    public String s0 = "";
    public ArrayList t0 = new ArrayList();

    public class A implements View.OnClickListener {
        public A() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                i.this.S(view);
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
                i.this.j0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                i iVar = i.this;
                iVar.h0 = iVar.j0.getText().toString();
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
                i.this.k0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                i iVar = i.this;
                iVar.i0 = iVar.k0.getText().toString();
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.i$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3060a implements View.OnClickListener {
        public ViewOnClickListenerC3060a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", i.this.d0);
                bundle.putInt("month", i.this.e0);
                bundle.putInt("day", i.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(i.this.b0);
                c2137ei.show(i.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.i$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3061b implements View.OnClickListener {
        public ViewOnClickListenerC3061b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", i.this.d0);
                bundle.putInt("month", i.this.e0);
                bundle.putInt("day", i.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(i.this.c0);
                c2137ei.show(i.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(i.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.i$c, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3062c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3062c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.i$d, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3063d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3063d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                i iVar = i.this;
                iVar.g0 = 0;
                iVar.u();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.i$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3064e implements View.OnClickListener {
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public ViewOnClickListenerC3064e(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                i iVar = i.this;
                iVar.g0 = 1;
                if (iVar.j0.getText() == null) {
                    i.this.h0 = "";
                } else {
                    i iVar2 = i.this;
                    iVar2.h0 = iVar2.j0.getText().toString();
                }
                if (i.this.k0.getText() == null) {
                    i.this.i0 = "";
                } else {
                    i iVar3 = i.this;
                    iVar3.i0 = iVar3.k0.getText().toString();
                }
                i.this.u();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.i$f, reason: case insensitive filesystem */
    public class C3065f implements Comparator {
        public C3065f() {
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

    public class h implements Comparator {
        public h() {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.i$i, reason: collision with other inner class name */
    public class C0307i implements Comparator {
        public C0307i() {
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
            C4145vh c4145vh = (C4145vh) i.this.E.getAdapter().getItem(i);
            i.v0 = i.this.E.getFirstVisiblePosition();
            Log.d("lv_click=", c4145vh.v() + ":" + c4145vh.f() + ":" + c4145vh.o());
            if (c4145vh.v().equals("-1")) {
                i iVar = i.this;
                iVar.h.u9(iVar.k, i.this.getActivity());
            } else {
                double d = Double.parseDouble(c4145vh.p().replaceAll(",", "")) + Double.parseDouble(c4145vh.q().replaceAll(",", ""));
                i iVar2 = i.this;
                iVar2.h.m9(iVar2.getActivity(), c4145vh.v(), c4145vh.f().replaceAll("-", ""), c4145vh.s(), c4145vh.o(), i.this.h.P7(String.valueOf(d)), c4145vh.n());
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.l0.dismiss();
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
                    i.this.R(this.a);
                    i.this.m0 = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    i.this.P(this.a);
                    i.this.m0 = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    i.this.Q(this.a);
                    i.this.m0 = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    i.this.O(this.a, 4);
                    i.this.m0 = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    i.this.O(this.a, 5);
                    i.this.m0 = 5;
                    break;
                case R.id.f6 /* 2131296729 */:
                    i.this.O(this.a, 6);
                    i.this.m0 = 6;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            i.this.r0.sendMessage(message);
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
                i.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                i.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                i.this.B(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                i.this.N.onButtonClicked(view);
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
            i.this.J(false);
            if (message.obj.toString().equals("0")) {
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = i.this.h;
                StringBuilder sb = new StringBuilder();
                i iVar = i.this;
                sb.append(iVar.h.ic(iVar.s0));
                sb.append(".pdf");
                z00.ra(sb.toString());
                return;
            }
            if (message.obj.toString().equals("3")) {
                i.this.G.notifyDataSetChanged();
                i iVar2 = i.this;
                Z00 z01 = iVar2.h;
                FragmentActivity activity = iVar2.getActivity();
                i iVar3 = i.this;
                z01.lc(activity, iVar3.T, iVar3.U, iVar3.V, iVar3.W, iVar3.X, iVar3.Y);
                i iVar4 = i.this;
                int i = iVar4.m0;
                if (i == 1) {
                    Z00 z02 = iVar4.h;
                    FragmentActivity activity2 = iVar4.getActivity();
                    i iVar5 = i.this;
                    z02.ld(activity2, iVar5.T, iVar5.n);
                    return;
                }
                if (i == 2) {
                    Z00 z03 = iVar4.h;
                    FragmentActivity activity3 = iVar4.getActivity();
                    i iVar6 = i.this;
                    z03.ld(activity3, iVar6.U, iVar6.n);
                    return;
                }
                if (i == 3) {
                    Z00 z04 = iVar4.h;
                    FragmentActivity activity4 = iVar4.getActivity();
                    i iVar7 = i.this;
                    z04.ld(activity4, iVar7.V, iVar7.n);
                    return;
                }
                if (i == 4) {
                    Z00 z05 = iVar4.h;
                    FragmentActivity activity5 = iVar4.getActivity();
                    i iVar8 = i.this;
                    z05.ld(activity5, iVar8.W, iVar8.n);
                    return;
                }
                if (i == 5) {
                    Z00 z06 = iVar4.h;
                    FragmentActivity activity6 = iVar4.getActivity();
                    i iVar9 = i.this;
                    z06.ld(activity6, iVar9.X, iVar9.n);
                    return;
                }
                if (i == 6) {
                    Z00 z07 = iVar4.h;
                    FragmentActivity activity7 = iVar4.getActivity();
                    i iVar10 = i.this;
                    z07.ld(activity7, iVar10.Y, iVar10.n);
                }
            }
        }
    }

    public class s implements Runnable {
        public final /* synthetic */ boolean a;

        public s(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            Z00 z00 = iVar.h;
            ListView listView = iVar.E;
            String strIc = z00.ic(iVar.s0);
            i iVar2 = i.this;
            z00.cb(listView, strIc, iVar2.h0, iVar2.i0, !this.a, true);
            Message message = new Message();
            message.obj = "1";
            i.this.r0.sendMessage(message);
        }
    }

    public class t implements SearchView.OnQueryTextListener {
        public t() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            i.this.D(str);
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
                i.this.S(view);
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
                i.this.S(view);
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
                i.this.S(view);
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
                i.this.S(view);
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
                i.this.S(view);
            } catch (Exception unused) {
            }
        }
    }

    public i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Integer num) {
        u();
    }

    private void F(List list) {
        Collections.sort(list, Collections.reverseOrder(new C0307i()));
    }

    private void G(List list) {
        Collections.sort(list, Collections.reverseOrder(new g()));
    }

    private void H(List list) {
        Collections.sort(list, Collections.reverseOrder(new q()));
    }

    private void I(List list, int i) {
        Collections.sort(list, new F(i));
    }

    private void K(List list, int i) {
        Collections.sort(list, new E(i));
    }

    private void L(List list) {
        Collections.sort(list, Collections.reverseOrder(new h()));
    }

    private void M(List list) {
        Collections.sort(list, Collections.reverseOrder(new C3065f()));
    }

    private void N(List list) {
        Collections.sort(list, Collections.reverseOrder(new p()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(View view) {
        if (this.n == 0) {
            L(this.H);
            this.n = 1;
        } else {
            F(this.H);
            this.n = 0;
        }
    }

    private void o(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new v()).show();
    }

    private void r() {
        try {
            int i = Calendar.getInstance().get(14);
            Log.d("data_loader=", i + "");
            getActivity().getSupportLoaderManager().initLoader(i * 1000000, null, this).forceLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        this.g0 = 0;
        u();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        TextView textView;
        try {
            ListView listView = this.E;
            if (listView != null && (textView = this.F) != null) {
                listView.setEmptyView(textView);
            }
            this.H = list;
            Log.d("onloadfinish=", isAdded() + ":" + v0 + ":" + this.k);
            Log.d("trace_E_Loader=", FragmentStatePagerSupport_Main.X() + "#" + this.k + ":" + this.h0 + ":" + this.i0);
            if (getActivity() != null) {
                if (this.G == null) {
                    Log.d("listviewadapter=", "null:" + this.l);
                    C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep3, this.H, 18, this.h.f9("select * from items_cost_calc a where round(a.n_q,7)<0") > 0);
                    this.G = c0922Sv;
                    this.E.setAdapter((ListAdapter) c0922Sv);
                } else {
                    Log.d("listviewadapter=", "not_null");
                    if (this.h.f9("select * from items_cost_calc a where round(a.n_q,7)<0") > 0) {
                        this.Y.performClick();
                    }
                    this.G.notifyDataSetChanged();
                }
                q();
                this.F.setText(getString(R.string.no_results));
            }
        } catch (Exception e) {
            Log.d("fetch_err=", e.getMessage() + "");
        }
    }

    public void D(String str) {
        try {
            this.G.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    public void E(boolean z2) {
        J(true);
        new Thread(new s(z2)).start();
    }

    public void J(boolean z2) {
        try {
            Dialog dialog = this.o0;
            if (dialog == null) {
                return;
            }
            if (z2) {
                dialog.cancel();
                this.o0.hide();
                this.o0.dismiss();
                this.o0.show();
            } else {
                dialog.cancel();
                this.o0.hide();
                this.o0.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O(View view, int i) {
        if (this.n == 0) {
            K(this.H, i);
            this.n = 1;
        } else {
            I(this.H, i);
            this.n = 0;
        }
    }

    public void Q(View view) {
        if (this.n == 0) {
            M(this.H);
            this.n = 1;
        } else {
            G(this.H);
            this.n = 0;
        }
    }

    public void R(View view) {
        if (this.n == 0) {
            N(this.H);
            this.n = 1;
        } else {
            H(this.H);
            this.n = 0;
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
            this.g0 = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.j0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.k0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.j0.setOnClickListener(new ViewOnClickListenerC3060a());
            this.k0.setOnClickListener(new ViewOnClickListenerC3061b());
            builder.setPositiveButton(getActivity().getString(R.string.btn_search), new DialogInterfaceOnClickListenerC3062c());
            builder.setNegativeButton(getActivity().getString(R.string.btn_cancel), new DialogInterfaceOnClickListenerC3063d());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC3064e(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.u0 = activity;
        try {
            this.N = (D) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressDialog progressDialog = new ProgressDialog(view.getContext());
        this.l0 = progressDialog;
        progressDialog.setCancelable(true);
        this.l0.setMessage("Processing...");
        this.l0.setProgressStyle(0);
        this.l0.setMax(10);
        this.l0.show();
        this.H = this.G.e;
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
            this.l = getArguments() != null ? getArguments().getString("br_name") : "";
            this.M = getArguments() != null ? getArguments().getInt("size") : 0;
            getActivity().setTitle(getResources().getStringArray(R.array.action_3)[13]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4145vh>> onCreateLoader(int i, Bundle bundle) {
        Log.d("trace_S_Loader=", FragmentStatePagerSupport_Main.X() + "#" + this.l);
        isAdded();
        return new C0908Sh(getActivity(), this.k, this.l, this.h, 41, this.h0, this.i0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main3_items_report2, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new t());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View viewInflate = layoutInflater.inflate(R.layout.data_listview_rep1_2, viewGroup, false);
            this.h = new Z00(this.g, getActivity());
            setHasOptionsMenu(true);
            w(viewInflate);
            if (this.E == null) {
                this.E = (ListView) viewInflate.findViewById(R.id.list_items);
                TextView textView = (TextView) viewInflate.findViewById(android.R.id.empty);
                this.F = textView;
                textView.setText(getString(R.string.wait));
                this.E.setEmptyView(this.F);
            }
            this.E.setOnItemClickListener(new j());
            v();
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.footer_sum);
            this.u = textView2;
            textView2.setText(this.l);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
            this.w = imageView;
            imageView.setOnClickListener(this.n0);
            this.R = (ImageView) viewInflate.findViewById(R.id.move_right);
            this.S = (ImageView) viewInflate.findViewById(R.id.move_left);
            this.R.setOnClickListener(this.n0);
            this.S.setOnClickListener(this.n0);
            if (this.M <= 1) {
                this.R.setVisibility(8);
                this.S.setVisibility(8);
            }
            this.O = getActivity().getString(R.string.footer_cus_null);
            this.P = getActivity().getString(R.string.tot_radio1);
            this.Q = getActivity().getString(R.string.tot_radio2);
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.d0 = calendar.get(1);
            this.e0 = calendar.get(2);
            this.f0 = calendar.get(5);
            try {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(getActivity());
                Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(viewConfiguration, false);
                }
            } catch (Exception unused) {
            }
            try {
                if (getUserVisibleHint()) {
                    r();
                }
            } catch (Exception e) {
                Log.d("details_oncreate", e.getMessage());
            }
            return viewInflate;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("oncreateview_err=", e2.getMessage());
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
                this.s0 = getActivity().getTitle().toString() + "-" + this.l;
                E(false);
            } catch (Exception e) {
                e.printStackTrace();
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
        p();
        try {
            this.s0 = getActivity().getTitle().toString() + "#" + this.l;
            E(true);
        } catch (Exception unused) {
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 112) {
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
            new C3966tX().A(getActivity(), this.E, this.F, -1);
            AbstractC3132jE.d(new Callable() { // from class: Qo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.z();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Ro
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
            Log.d("lv_pos=", v0 + ":" + getUserVisibleHint() + ":" + this.k);
            if (getUserVisibleHint()) {
                if (v0 <= 0) {
                    v0 = 0;
                    return;
                }
                if (this.E.getFirstVisiblePosition() > v0 || this.E.getLastVisiblePosition() < v0) {
                    this.E.setSelection(v0);
                }
                v0 = 0;
            }
        } catch (Exception e) {
            v0 = 0;
            e.printStackTrace();
        }
    }

    public void s() {
        Cursor cursorE7;
        i iVar = this;
        Log.d("get_all_names", "get_all_names:" + iVar.l + ":" + iVar.g0);
        iVar.h.Vb();
        int i = iVar.g0;
        String str = CSS.Value.PERCENTAGE;
        if (i == 0) {
            cursorE7 = iVar.h.e7(iVar.l, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            iVar.h0 = iVar.h0.isEmpty() ? CSS.Value.PERCENTAGE : iVar.h0;
            if (!iVar.i0.isEmpty()) {
                str = iVar.i0;
            }
            iVar.i0 = str;
            new C2160f10(iVar.h).W(iVar.i0);
            cursorE7 = iVar.h.e7(iVar.l, iVar.h0, iVar.i0);
        }
        iVar.i = 0.0d;
        iVar.H.clear();
        cursorE7.moveToFirst();
        C0566Hd c0566Hd = new C0566Hd();
        while (!cursorE7.isAfterLast()) {
            iVar.H.add(new C4145vh(cursorE7.getString(c0566Hd.b(cursorE7, "_id")), cursorE7.getString(c0566Hd.b(cursorE7, "f1")), cursorE7.getString(c0566Hd.b(cursorE7, "f2")), cursorE7.getString(c0566Hd.b(cursorE7, "f3")), "" + cursorE7.getDouble(c0566Hd.b(cursorE7, "f4")), "" + cursorE7.getDouble(c0566Hd.b(cursorE7, "f5")), "" + cursorE7.getDouble(c0566Hd.b(cursorE7, "f6")), cursorE7.getString(c0566Hd.b(cursorE7, "f7")), "" + cursorE7.getDouble(c0566Hd.b(cursorE7, "f8")), "" + cursorE7.getDouble(c0566Hd.b(cursorE7, "f9")), "" + cursorE7.getDouble(c0566Hd.b(cursorE7, "f10")), "" + cursorE7.getDouble(c0566Hd.b(cursorE7, "f11")), cursorE7.getString(c0566Hd.b(cursorE7, "f12")), cursorE7.getString(c0566Hd.b(cursorE7, "f13"))));
            cursorE7.moveToNext();
            iVar = this;
        }
        cursorE7.close();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && this.l != null && isResumed()) {
            r();
        }
    }

    public void t() {
        if (getActivity() != null) {
            C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep3, this.H, 18, this.h.f9("select * from items_cost_calc a where round(a.n_q,7)<0") > 0);
            this.G = c0922Sv;
            this.E.setAdapter((ListAdapter) c0922Sv);
            this.F.setText(getString(R.string.no_results));
        }
        new C3966tX().A(getActivity(), this.E, this.F, 1);
    }

    public void u() {
        J(true);
        AbstractC3132jE.d(new Callable() { // from class: Oo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.x();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Po
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.y((Integer) obj);
            }
        });
    }

    public void v() {
        if (this.o0 != null) {
            return;
        }
        try {
            this.p0 = new AlertDialog.Builder(getActivity());
            View viewInflate = getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null);
            this.q0 = viewInflate;
            this.p0.setView(viewInflate);
            this.o0 = this.p0.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void w(View view) {
        if (view != null) {
            this.T = (TextView) view.findViewById(R.id.f1);
            this.U = (TextView) view.findViewById(R.id.f2);
            this.V = (TextView) view.findViewById(R.id.f3);
            this.W = (TextView) view.findViewById(R.id.f4);
            this.X = (TextView) view.findViewById(R.id.f5);
            this.Y = (TextView) view.findViewById(R.id.f6);
            this.Z = (TextView) view.findViewById(R.id.f7);
            this.a0 = (TextView) view.findViewById(R.id.f8);
        } else {
            this.T = (TextView) view.findViewById(R.id.f1);
            this.U = (TextView) view.findViewById(R.id.f2);
            this.V = (TextView) view.findViewById(R.id.f3);
            this.W = (TextView) view.findViewById(R.id.f4);
            this.X = (TextView) view.findViewById(R.id.f5);
            this.Y = (TextView) view.findViewById(R.id.f6);
            this.Z = (TextView) view.findViewById(R.id.f7);
            this.a0 = (TextView) view.findViewById(R.id.f8);
        }
        this.Z.setVisibility(8);
        this.a0.setVisibility(8);
        this.T.setText(getString(R.string.inv_type));
        this.U.setText(getString(R.string.date));
        this.V.setText(getString(R.string.item));
        this.W.setText(getString(R.string.bal_in));
        this.X.setText(getString(R.string.bal_move));
        this.Y.setText(getString(R.string.balance2));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(getActivity(), this.T);
        c0372Bn.a(getActivity(), this.U);
        c0372Bn.a(getActivity(), this.V);
        TextView textView = this.T;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.U;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.V;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.W;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.X;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.Y.setPaintFlags(8 | this.X.getPaintFlags());
        this.h.ld(getActivity(), this.U, this.n);
        this.T.setOnClickListener(new u());
        this.U.setOnClickListener(new w());
        this.V.setOnClickListener(new x());
        this.W.setOnClickListener(new y());
        this.X.setOnClickListener(new z());
        this.Y.setOnClickListener(new A());
    }

    public i(C4145vh c4145vh, int i, int i2, String str) {
        try {
            Log.d("item_det=", "Frag_Report1_Items_Balance_Det_All:");
            Bundle bundle = new Bundle();
            Log.d("frag_click=", FragmentStatePagerSupport.S + ":" + c4145vh.a() + ":" + c4145vh.n() + ":" + c4145vh.b());
            if (FragmentStatePagerSupport.S == 1) {
                bundle.putString("item_name", c4145vh.n());
                bundle.putString("br_name", c4145vh.a());
            } else {
                bundle.putString("item_name", c4145vh.a());
                bundle.putString("br_name", FragmentStatePagerSupport.M);
            }
            bundle.putInt(CSS.Property.POSITION, i);
            bundle.putInt("size", i2);
            bundle.putString("searchString", str);
            setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
