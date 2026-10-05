package info.aalmoghalis.inventory.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C0908Sh;
import defpackage.C0922Sv;
import defpackage.C1839c10;
import defpackage.C2137ei;
import defpackage.C2160f10;
import defpackage.C3966tX;
import defpackage.C4145vh;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.App;
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
public class j extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<C4145vh>> {
    public static int x0;
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
    public AlertDialog.Builder r0;
    public View s0;
    public Activity w0;
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
    public Cursor l0 = null;
    public String m0 = "";
    public ProgressDialog n0 = null;
    public int o0 = 0;
    public View.OnClickListener p0 = new n();
    public Dialog q0 = null;
    public Handler t0 = new q();
    public String u0 = "";
    public ArrayList v0 = new ArrayList();

    public class A implements View.OnClickListener {
        public A() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                j.this.M(view);
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
                j.this.j0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                j jVar = j.this;
                jVar.h0 = jVar.j0.getText().toString();
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
                j.this.k0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                j jVar = j.this;
                jVar.i0 = jVar.k0.getText().toString();
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
            return i == 3 ? Double.valueOf(c4145vh.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.o().replaceAll(",", ""))) : Double.valueOf(c4145vh.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.p().replaceAll(",", "")));
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
            return i == 3 ? Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", ""))) : Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.j$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3072a implements View.OnClickListener {
        public ViewOnClickListenerC3072a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", j.this.d0);
                bundle.putInt("month", j.this.e0);
                bundle.putInt("day", j.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(j.this.b0);
                c2137ei.show(j.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.j$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3073b implements View.OnClickListener {
        public ViewOnClickListenerC3073b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", j.this.d0);
                bundle.putInt("month", j.this.e0);
                bundle.putInt("day", j.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(j.this.c0);
                c2137ei.show(j.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(j.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.j$c, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3074c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3074c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.j$d, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3075d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3075d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                j jVar = j.this;
                jVar.g0 = 0;
                jVar.s("");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.j$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3076e implements View.OnClickListener {
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public ViewOnClickListenerC3076e(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                j jVar = j.this;
                jVar.g0 = 1;
                if (jVar.j0.getText() == null) {
                    j.this.h0 = "";
                } else {
                    j jVar2 = j.this;
                    jVar2.h0 = jVar2.j0.getText().toString();
                }
                if (j.this.k0.getText() == null) {
                    j.this.i0 = "";
                } else {
                    j jVar3 = j.this;
                    jVar3.i0 = jVar3.k0.getText().toString();
                }
                j.this.s("");
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.j$f, reason: case insensitive filesystem */
    public class RunnableC3077f implements Runnable {
        public final /* synthetic */ String a;

        public RunnableC3077f(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.r(this.a);
            Message message = new Message();
            message.obj = "0";
            j.this.t0.sendMessage(message);
        }
    }

    public class g implements Comparator {
        public g() {
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

    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
                String strA = c4145vh.a();
                j jVar = j.this;
                boolean zIsEmpty = jVar.h0.isEmpty();
                String str = CSS.Value.PERCENTAGE;
                jVar.h0 = zIsEmpty ? CSS.Value.PERCENTAGE : j.this.h0;
                j jVar2 = j.this;
                if (!jVar2.i0.isEmpty()) {
                    str = j.this.i0;
                }
                jVar2.i0 = str;
                Intent intent = new Intent(j.this.getActivity(), (Class<?>) FragmentStatePagerSupport.class);
                intent.putExtra("screen_no", "73");
                intent.putExtra("report_type", 1);
                intent.putExtra("item_name", strA);
                intent.putExtra("br_name", j.this.l);
                intent.putExtra("unit_name", c4145vh.n());
                intent.putExtra("f_date", j.this.h0);
                intent.putExtra("t_date", j.this.i0);
                Log.d("lv_click", strA + ":" + j.this.l + ":" + c4145vh.n() + ":" + j.this.h0 + ":" + j.this.i0 + ":" + j.this.H.size());
                j.x0 = j.this.E.getFirstVisiblePosition();
                j.this.getActivity().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.j$j, reason: collision with other inner class name */
    public class RunnableC0308j implements Runnable {
        public RunnableC0308j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.n0.dismiss();
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ View a;

        public k(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    j.this.L(this.a);
                    j.this.o0 = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    j.this.K(this.a);
                    j.this.o0 = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    j.this.J(this.a, 3);
                    j.this.o0 = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    j.this.J(this.a, 4);
                    j.this.o0 = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    j.this.J(this.a, 5);
                    j.this.o0 = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            j.this.t0.sendMessage(message);
        }
    }

    public class l extends WebViewClient {
        public l() {
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

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                j.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                j.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                j.this.x(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                j.this.N.onButtonClicked(view);
            }
        }
    }

    public class o implements Comparator {
        public o() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a()));
        }
    }

    public class p implements Comparator {
        public p() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a()));
        }
    }

    public class q extends Handler {
        public q() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                j.this.F(false);
                j jVar = j.this;
                jVar.q(jVar.l0);
                return;
            }
            if (message.obj.toString().equals("1")) {
                j.this.F(false);
                Z00 z00 = j.this.h;
                StringBuilder sb = new StringBuilder();
                j jVar2 = j.this;
                sb.append(jVar2.h.ic(jVar2.u0));
                sb.append(".pdf");
                z00.ra(sb.toString());
                return;
            }
            if (message.obj.toString().equals("3")) {
                j.this.F(false);
                j.this.G.notifyDataSetChanged();
                j jVar3 = j.this;
                Z00 z01 = jVar3.h;
                FragmentActivity activity = jVar3.getActivity();
                j jVar4 = j.this;
                z01.lc(activity, jVar4.T, jVar4.U, jVar4.V, jVar4.W, jVar4.X, jVar4.Y);
                j jVar5 = j.this;
                int i = jVar5.o0;
                if (i == 1) {
                    Z00 z02 = jVar5.h;
                    FragmentActivity activity2 = jVar5.getActivity();
                    j jVar6 = j.this;
                    z02.ld(activity2, jVar6.T, jVar6.n);
                    return;
                }
                if (i == 2) {
                    Z00 z03 = jVar5.h;
                    FragmentActivity activity3 = jVar5.getActivity();
                    j jVar7 = j.this;
                    z03.ld(activity3, jVar7.U, jVar7.n);
                    return;
                }
                if (i == 3) {
                    Z00 z04 = jVar5.h;
                    FragmentActivity activity4 = jVar5.getActivity();
                    j jVar8 = j.this;
                    z04.ld(activity4, jVar8.V, jVar8.n);
                    return;
                }
                if (i == 4) {
                    Z00 z05 = jVar5.h;
                    FragmentActivity activity5 = jVar5.getActivity();
                    j jVar9 = j.this;
                    z05.ld(activity5, jVar9.W, jVar9.n);
                    return;
                }
                if (i == 5) {
                    Z00 z06 = jVar5.h;
                    FragmentActivity activity6 = jVar5.getActivity();
                    j jVar10 = j.this;
                    z06.ld(activity6, jVar10.X, jVar10.n);
                    return;
                }
                if (i == 6) {
                    Z00 z07 = jVar5.h;
                    FragmentActivity activity7 = jVar5.getActivity();
                    j jVar11 = j.this;
                    z07.ld(activity7, jVar11.Y, jVar11.n);
                }
            }
        }
    }

    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            Z00 z00 = jVar.h;
            ListView listView = jVar.E;
            String strIc = z00.ic(jVar.u0);
            j jVar2 = j.this;
            z00.db(listView, strIc, jVar2.h0, jVar2.i0);
            Message message = new Message();
            message.obj = "1";
            j.this.t0.sendMessage(message);
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                j.this.M(view);
            } catch (Exception unused) {
            }
        }
    }

    public class t implements SearchView.OnQueryTextListener {
        public t() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            j.this.z(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText a;

        public v(EditText editText) {
            this.a = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.a.getText().toString().length() > 0) {
                j.this.h.Lc("pref_end_date_days", this.a.getText().toString());
                j.this.s(this.a.getText().toString());
            }
        }
    }

    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                j.this.M(view);
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
                j.this.M(view);
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
                j.this.M(view);
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
                j.this.M(view);
            } catch (Exception unused) {
            }
        }
    }

    public j() {
    }

    private void C(List list) {
        Collections.sort(list, Collections.reverseOrder(new i()));
    }

    private void D(List list) {
        Collections.sort(list, Collections.reverseOrder(new p()));
    }

    private void E(List list, int i2) {
        Collections.sort(list, new F(i2));
    }

    private void G(List list, int i2) {
        Collections.sort(list, new E(i2));
    }

    private void H(List list) {
        Collections.sort(list, Collections.reverseOrder(new g()));
    }

    private void I(List list) {
        Collections.sort(list, Collections.reverseOrder(new o()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(View view) {
        if (this.n == 0) {
            H(this.H);
            this.n = 1;
        } else {
            C(this.H);
            this.n = 0;
        }
    }

    private void m(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new u()).show();
    }

    private void p() {
        try {
            int i2 = Calendar.getInstance().get(14);
            Log.d("data_loader=", i2 + "");
            getActivity().getSupportLoaderManager().initLoader(i2, null, this).forceLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer v() {
        this.h.Vb();
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(Integer num) {
        getActivity().recreate();
    }

    public void A() {
        EditText editText = new EditText(getActivity());
        editText.setInputType(8194);
        editText.setHint(getString(R.string.no_days));
        editText.setText(this.h.ia("pref_end_date_days", ""));
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getActivity()).setTitle(getString(R.string.exp_days)).setView(editText).setPositiveButton(getString(R.string.alert_ok), new v(editText)).setNegativeButton(getString(R.string.alert_cancel), (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.getWindow().setSoftInputMode(16);
        editText.requestFocus();
        alertDialogCreate.show();
    }

    public void B(boolean z2) {
        F(true);
        new Thread(new r()).start();
    }

    public void F(boolean z2) {
        try {
            Dialog dialog = this.q0;
            if (dialog == null) {
                return;
            }
            if (z2) {
                dialog.cancel();
                this.q0.hide();
                this.q0.dismiss();
                this.q0.show();
            } else {
                dialog.cancel();
                this.q0.hide();
                this.q0.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void J(View view, int i2) {
        if (this.n == 0) {
            G(this.H, i2);
            this.n = 1;
        } else {
            E(this.H, i2);
            this.n = 0;
        }
    }

    public void L(View view) {
        if (this.n == 0) {
            I(this.H);
            this.n = 1;
        } else {
            D(this.H);
            this.n = 0;
        }
    }

    public void M(View view) {
        F(true);
        new Thread(new k(view)).start();
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
        webView.setWebViewClient(new l());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new m());
        builder.show();
    }

    public void l() {
        try {
            this.g0 = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.j0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.k0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.j0.setOnClickListener(new ViewOnClickListenerC3072a());
            this.k0.setOnClickListener(new ViewOnClickListenerC3073b());
            builder.setPositiveButton(getActivity().getString(R.string.btn_search), new DialogInterfaceOnClickListenerC3074c());
            builder.setNegativeButton(getActivity().getString(R.string.btn_cancel), new DialogInterfaceOnClickListenerC3075d());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC3076e(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void n() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void o() {
        try {
            Log.d("lv_pos=", x0 + ":" + getUserVisibleHint() + ":" + this.k);
            if (getUserVisibleHint()) {
                if (x0 <= 0) {
                    x0 = 0;
                    return;
                }
                if (this.E.getFirstVisiblePosition() > x0 || this.E.getLastVisiblePosition() < x0) {
                    this.E.setSelection(x0);
                }
                x0 = 0;
            }
        } catch (Exception e) {
            x0 = 0;
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.w0 = activity;
        try {
            this.N = (D) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressDialog progressDialog = new ProgressDialog(view.getContext());
        this.n0 = progressDialog;
        progressDialog.setCancelable(true);
        this.n0.setMessage("Processing...");
        this.n0.setProgressStyle(0);
        this.n0.setMax(10);
        this.n0.show();
        this.H = this.G.e;
        if (view.getId() == R.id.f1) {
            L(view);
        }
        new Handler().postDelayed(new RunnableC0308j(), 400L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new Z00(this.g, getActivity());
            this.l = getArguments() != null ? getArguments().getString("br_name") : "";
            this.M = getArguments() != null ? getArguments().getInt("size") : 0;
            getActivity().setTitle(getResources().getStringArray(R.array.action_3_end_date)[14]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4145vh>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_Loader=", FragmentStatePagerSupport_Main.X() + "#" + this.l);
        isAdded();
        return new C0908Sh(getActivity(), this.k, this.l, this.h, 42, this.h0, this.i0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main3_group_general5, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new t());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View viewInflate = layoutInflater.inflate(R.layout.data_listview_rep3_1, viewGroup, false);
            this.h = new Z00(this.g, getActivity());
            setHasOptionsMenu(true);
            u(viewInflate);
            if (this.E == null) {
                this.E = (ListView) viewInflate.findViewById(R.id.list_items);
                TextView textView = (TextView) viewInflate.findViewById(R.id.emptyResults);
                this.F = textView;
                textView.setText(getString(R.string.wait));
                this.E.setEmptyView(this.F);
            }
            this.E.setOnItemClickListener(new h());
            t();
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.footer_sum);
            this.u = textView2;
            textView2.setText(this.l);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
            this.w = imageView;
            imageView.setOnClickListener(this.p0);
            this.R = (ImageView) viewInflate.findViewById(R.id.move_right);
            this.S = (ImageView) viewInflate.findViewById(R.id.move_left);
            this.R.setOnClickListener(this.p0);
            this.S.setOnClickListener(this.p0);
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
            if (getUserVisibleHint()) {
                p();
            }
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
                n();
            }
            try {
                this.u0 = getActivity().getTitle().toString() + "-" + this.l;
                B(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        if (itemId == R.id.print_period) {
            if (Build.VERSION.SDK_INT < 31) {
                n();
            }
            try {
                A();
            } catch (Exception unused) {
            }
            return true;
        }
        if (itemId == R.id.adv_search) {
            l();
            return true;
        }
        if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            m(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        super.onResume();
        Log.d("onresume=", Bill_edit.Q2 + ":" + this.h0);
        if (Bill_edit.Q2) {
            Bill_edit.Q2 = false;
            new C3966tX().A(getActivity(), this.E, this.F, -1);
            AbstractC3132jE.d(new Callable() { // from class: So
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.v();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: To
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.w((Integer) obj);
                }
            });
        }
    }

    public void q(Cursor cursor) {
        double d = 0.0d;
        this.i = 0.0d;
        this.H.clear();
        cursor.moveToFirst();
        C0566Hd c0566Hd = new C0566Hd();
        while (!cursor.isAfterLast()) {
            if (this.m0.length() == 0 || (this.m0.length() > 0 && cursor.getDouble(c0566Hd.b(cursor, "f5")) != d)) {
                this.H.add(new C4145vh(cursor.getString(c0566Hd.b(cursor, HTML.Attribute.ID)), cursor.getString(c0566Hd.b(cursor, "f1")), cursor.getString(c0566Hd.b(cursor, "f11")), this.h.P7(String.valueOf(cursor.getDouble(c0566Hd.b(cursor, "f2")))), this.h.P7(String.valueOf(cursor.getDouble(c0566Hd.b(cursor, "f4")))), this.h.P7(String.valueOf(cursor.getDouble(c0566Hd.b(cursor, "f5")))), this.h.P7(String.valueOf(cursor.getDouble(c0566Hd.b(cursor, "f3")))), this.h.P7(String.valueOf(cursor.getDouble(c0566Hd.b(cursor, "f6")))), this.h.P7(String.valueOf(cursor.getDouble(c0566Hd.b(cursor, "f7")))), this.h.P7(String.valueOf(cursor.getDouble(c0566Hd.b(cursor, "f8")))), cursor.getString(c0566Hd.b(cursor, "f10"))));
            }
            cursor.moveToNext();
            d = 0.0d;
        }
        cursor.close();
        if (getActivity() != null) {
            C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep3_2, this.H, 22, new C1839c10().s(this.h.ia("pref_end_date_days", "30")));
            this.G = c0922Sv;
            this.E.setAdapter((ListAdapter) c0922Sv);
            this.F.setText(getString(R.string.no_results));
        }
        ((App) getActivity().getApplication()).c(this.H);
    }

    public void r(String str) {
        Log.d("get_all_names", "get_all_names:" + this.l + ":" + this.g0 + ":" + str);
        this.m0 = str;
        this.h.Vb();
        int i2 = this.g0;
        String str2 = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            this.l0 = this.h.g7(this.l, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, str);
            return;
        }
        this.h0 = this.h0.isEmpty() ? CSS.Value.PERCENTAGE : this.h0;
        if (!this.i0.isEmpty()) {
            str2 = this.i0;
        }
        this.i0 = str2;
        new C2160f10(this.h).W(this.i0);
        this.l0 = this.h.g7(this.l, this.h0, this.i0, str);
    }

    public void s(String str) {
        F(true);
        new Thread(new RunnableC3077f(str)).start();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && this.k != null && isResumed()) {
            p();
        }
    }

    public void t() {
        if (this.q0 != null) {
            return;
        }
        try {
            this.r0 = new AlertDialog.Builder(getActivity());
            View viewInflate = getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null);
            this.s0 = viewInflate;
            this.r0.setView(viewInflate);
            this.q0 = this.r0.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u(View view) {
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
        this.Y.setVisibility(8);
        this.Z.setVisibility(8);
        this.a0.setVisibility(8);
        this.T.setText(getString(R.string.item));
        this.U.setText(getString(R.string.end_date));
        this.V.setText(getString(R.string.bal_in));
        this.W.setText(getString(R.string.bal_move));
        this.X.setText(getString(R.string.balance2));
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
        textView5.setPaintFlags(8 | textView5.getPaintFlags());
        this.h.ld(getActivity(), this.U, this.n);
        this.T.setOnClickListener(new s());
        this.U.setOnClickListener(new w());
        this.V.setOnClickListener(new x());
        this.W.setOnClickListener(new y());
        this.X.setOnClickListener(new z());
        this.Y.setOnClickListener(new A());
    }

    public void x(View view) {
        this.g0 = 0;
        s("");
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        TextView textView;
        try {
            ListView listView = this.E;
            if (listView != null && (textView = this.F) != null) {
                listView.setEmptyView(textView);
            }
            this.H = list;
            Log.d("onloadfinish=", isAdded() + ":" + x0 + ":" + this.k);
            Log.d("trace_E_Loader=", FragmentStatePagerSupport_Main.X() + "#" + this.k + ":" + this.h0 + ":" + this.i0);
            if (getActivity() != null) {
                C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep3_2, this.H, 22, new C1839c10().s(this.h.ia("pref_end_date_days", "30")));
                this.G = c0922Sv;
                c0922Sv.notifyDataSetChanged();
                this.E.setAdapter((ListAdapter) this.G);
                o();
                this.F.setText(getString(R.string.no_results));
            }
            if (getUserVisibleHint()) {
                ((App) getActivity().getApplication()).c(this.H);
            }
        } catch (Exception e) {
            Log.d("fetch_err=", e.getMessage() + "");
        }
    }

    public void z(String str) {
        try {
            this.G.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    public j(C4145vh c4145vh, int i2, int i3, String str) {
        try {
            Log.d("item_det=", "Frag_Report1_Items_Balance_end_date:");
            Bundle bundle = new Bundle();
            Log.d("frag_click=", FragmentStatePagerSupport.S + ":" + c4145vh.a() + ":" + c4145vh.n() + ":" + c4145vh.b());
            if (FragmentStatePagerSupport.S == 1) {
                bundle.putString("item_name", c4145vh.n());
                bundle.putString("br_name", c4145vh.a());
            } else {
                bundle.putString("item_name", c4145vh.a());
                bundle.putString("br_name", FragmentStatePagerSupport.M);
            }
            bundle.putInt(CSS.Property.POSITION, i2);
            bundle.putInt("size", i3);
            bundle.putString("searchString", str);
            setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
