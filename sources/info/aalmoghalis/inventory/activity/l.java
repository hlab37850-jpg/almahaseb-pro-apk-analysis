package info.aalmoghalis.inventory.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.C0372Bn;
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
public class l extends Fragment {
    public C0922Sv H;
    public B S;
    public ImageView W;
    public ImageView X;
    public TextView Y;
    public TextView Z;
    public TextView a0;
    public TextView b0;
    public TextView c0;
    public TextView d0;
    public TextView e0;
    public TextView f0;
    public SQLiteDatabase g;
    public Z00 h;
    public int i0;
    public int j0;
    public String k;
    public int k0;
    public String l;
    public String n;
    public AlertDialog.Builder r0;
    public View s0;
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
    public Dialog O = null;
    public Handler P = new k();
    public int Q = 0;
    public Cursor R = null;
    public String T = "";
    public String U = "";
    public String V = "";
    public DatePickerDialog.OnDateSetListener g0 = new g();
    public DatePickerDialog.OnDateSetListener h0 = new h();
    public int l0 = 0;
    public String m0 = CSS.Value.PERCENTAGE;
    public String n0 = CSS.Value.PERCENTAGE;
    public TextView o0 = null;
    public TextView p0 = null;
    public View.OnClickListener q0 = new q();
    public String t0 = "";
    public ArrayList u0 = new ArrayList();

    public class A implements AdapterView.OnItemClickListener {
        public A() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            C4145vh c4145vh = (C4145vh) l.this.F.getAdapter().getItem(i);
            if (c4145vh.v().equals("0")) {
                return;
            }
            l lVar = l.this;
            lVar.h.m9(lVar.getActivity(), c4145vh.v(), c4145vh.u().replaceAll("-", ""), c4145vh.s(), l.this.k, c4145vh.o(), c4145vh.n());
        }
    }

    public interface B {
        void onButtonClicked(View view);
    }

    public class C implements Comparator {
        public int a;

        public C(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 5) {
                return Double.valueOf(c4145vh.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.q().replaceAll(",", "")));
            }
            if (i == 6) {
                return Double.valueOf(c4145vh.r().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.r().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.o().replaceAll(",", ""))) : Double.valueOf(c4145vh.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.p().replaceAll(",", "")));
        }
    }

    public class D implements Comparator {
        public int a;

        public D(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 5) {
                return Double.valueOf(c4145vh2.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.q().replaceAll(",", "")));
            }
            if (i == 6) {
                return Double.valueOf(c4145vh2.r().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.r().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", ""))) : Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.l$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3081a implements View.OnClickListener {
        public ViewOnClickListenerC3081a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                l.this.K(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.l$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3082b implements View.OnClickListener {
        public ViewOnClickListenerC3082b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                l.this.K(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.l$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3083c implements View.OnClickListener {
        public ViewOnClickListenerC3083c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                l.this.K(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.l$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3084d implements View.OnClickListener {
        public ViewOnClickListenerC3084d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                l.this.K(view);
            } catch (Exception unused) {
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                l.this.K(view);
            } catch (Exception unused) {
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                l.this.K(view);
            } catch (Exception unused) {
            }
        }
    }

    public class g implements DatePickerDialog.OnDateSetListener {
        public g() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                l.this.o0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                l lVar = l.this;
                lVar.m0 = lVar.o0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public class h implements DatePickerDialog.OnDateSetListener {
        public h() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                l.this.p0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                l lVar = l.this;
                lVar.n0 = lVar.p0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", l.this.i0);
                bundle.putInt("month", l.this.j0);
                bundle.putInt("day", l.this.k0);
                c2137ei.setArguments(bundle);
                c2137ei.f(l.this.g0);
                c2137ei.show(l.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", l.this.i0);
                bundle.putInt("month", l.this.j0);
                bundle.putInt("day", l.this.k0);
                c2137ei.setArguments(bundle);
                c2137ei.f(l.this.h0);
                c2137ei.show(l.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(l.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    public class k extends Handler {
        public k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                l lVar = l.this;
                lVar.o(lVar.R);
                C3966tX c3966tX = new C3966tX();
                FragmentActivity activity = l.this.getActivity();
                l lVar2 = l.this;
                c3966tX.A(activity, lVar2.F, lVar2.G, 1);
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = l.this.h;
                StringBuilder sb = new StringBuilder();
                l lVar3 = l.this;
                sb.append(lVar3.h.ic(lVar3.t0));
                sb.append(".pdf");
                z00.ra(sb.toString());
                l.this.D(false);
                return;
            }
            if (message.obj.toString().equals("3")) {
                l.this.H.notifyDataSetChanged();
                l lVar4 = l.this;
                Z00 z01 = lVar4.h;
                FragmentActivity activity2 = lVar4.getActivity();
                l lVar5 = l.this;
                z01.lc(activity2, lVar5.Y, lVar5.Z, lVar5.a0, lVar5.b0, lVar5.c0, lVar5.d0);
                l lVar6 = l.this;
                int i = lVar6.Q;
                if (i == 1) {
                    Z00 z02 = lVar6.h;
                    FragmentActivity activity3 = lVar6.getActivity();
                    l lVar7 = l.this;
                    z02.ld(activity3, lVar7.Y, lVar7.p);
                } else if (i == 2) {
                    Z00 z03 = lVar6.h;
                    FragmentActivity activity4 = lVar6.getActivity();
                    l lVar8 = l.this;
                    z03.ld(activity4, lVar8.Z, lVar8.p);
                } else if (i == 3) {
                    Z00 z04 = lVar6.h;
                    FragmentActivity activity5 = lVar6.getActivity();
                    l lVar9 = l.this;
                    z04.ld(activity5, lVar9.a0, lVar9.p);
                } else if (i == 4) {
                    Z00 z05 = lVar6.h;
                    FragmentActivity activity6 = lVar6.getActivity();
                    l lVar10 = l.this;
                    z05.ld(activity6, lVar10.b0, lVar10.p);
                } else if (i == 5) {
                    Z00 z06 = lVar6.h;
                    FragmentActivity activity7 = lVar6.getActivity();
                    l lVar11 = l.this;
                    z06.ld(activity7, lVar11.c0, lVar11.p);
                } else if (i == 6) {
                    Z00 z07 = lVar6.h;
                    FragmentActivity activity8 = lVar6.getActivity();
                    l lVar12 = l.this;
                    z07.ld(activity8, lVar12.d0, lVar12.p);
                }
                l.this.D(false);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.l$l, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0310l implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0310l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                l lVar = l.this;
                lVar.l0 = 0;
                lVar.r();
            } catch (Exception unused) {
            }
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public n(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                l lVar = l.this;
                lVar.l0 = 1;
                if (lVar.o0.getText() == null) {
                    l.this.m0 = "";
                } else {
                    l lVar2 = l.this;
                    lVar2.m0 = lVar2.o0.getText().toString();
                }
                if (l.this.p0.getText() == null) {
                    l.this.n0 = "";
                } else {
                    l lVar3 = l.this;
                    lVar3.n0 = lVar3.p0.getText().toString();
                }
                l.this.r();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class o extends WebViewClient {
        public o() {
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

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                l.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                l.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                l.this.x(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                l.this.S.onButtonClicked(view);
            }
        }
    }

    public class r implements SearchView.OnQueryTextListener {
        public r() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                l.this.p(1);
            }
            l.this.y(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            l.this.p(0);
            return false;
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.q();
            Message message = new Message();
            message.obj = "0";
            l.this.P.sendMessage(message);
        }
    }

    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = l.this;
            Z00 z00 = lVar.h;
            ListView listView = lVar.F;
            String strIc = z00.ic(lVar.t0);
            l lVar2 = l.this;
            z00.Jb(listView, strIc, true, lVar2.m0, lVar2.n0, lVar2.getString(R.string.item));
            Message message = new Message();
            message.obj = "1";
            l.this.P.sendMessage(message);
        }
    }

    public class v implements Comparator {
        public v() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh2.n().compareTo(String.valueOf(c4145vh.n()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v()) : iCompareTo;
        }
    }

    public class w implements Comparator {
        public w() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh.n().compareTo(String.valueOf(c4145vh2.n()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh.v()) - Integer.parseInt(c4145vh2.v()) : iCompareTo;
        }
    }

    public class x implements Runnable {
        public final /* synthetic */ View a;

        public x(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    l.this.J(this.a, 1);
                    l.this.Q = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    l.this.I(this.a);
                    l.this.Q = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    l.this.H(this.a, 3);
                    l.this.Q = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    l.this.H(this.a, 4);
                    l.this.Q = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    l.this.H(this.a, 5);
                    l.this.Q = 5;
                    break;
                case R.id.f6 /* 2131296729 */:
                    l.this.H(this.a, 6);
                    l.this.Q = 6;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            l.this.P.sendMessage(message);
        }
    }

    public class y implements Comparator {
        public final /* synthetic */ int a;

        public y(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a())) : String.valueOf(c4145vh2.n()).compareTo(String.valueOf(c4145vh.n()));
        }
    }

    public class z implements Comparator {
        public final /* synthetic */ int a;

        public z(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a())) : String.valueOf(c4145vh.n()).compareTo(String.valueOf(c4145vh2.n()));
        }
    }

    public l() {
    }

    private void A(List list) {
        Collections.sort(list, Collections.reverseOrder(new w()));
    }

    private void B(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new z(i2)));
    }

    private void C(List list, int i2) {
        Collections.sort(list, new D(i2));
    }

    private void E(List list, int i2) {
        Collections.sort(list, new C(i2));
    }

    private void F(List list) {
        Collections.sort(list, Collections.reverseOrder(new v()));
    }

    private void G(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new y(i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(View view) {
        if (this.p == 0) {
            F(this.I);
            this.p = 1;
        } else {
            A(this.I);
            this.p = 0;
        }
    }

    private void m(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new s()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer v() {
        this.h.Vb();
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(Integer num) {
        r();
    }

    public void D(boolean z2) {
        try {
            Dialog dialog = this.O;
            if (dialog == null) {
                return;
            }
            if (z2) {
                dialog.cancel();
                this.O.hide();
                this.O.dismiss();
                this.O.show();
            } else {
                dialog.cancel();
                this.O.hide();
                this.O.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void H(View view, int i2) {
        if (this.p == 0) {
            E(this.I, i2);
            this.p = 1;
        } else {
            C(this.I, i2);
            this.p = 0;
        }
    }

    public void J(View view, int i2) {
        if (this.p == 0) {
            G(this.I, i2);
            this.p = 1;
        } else {
            B(this.I, i2);
            this.p = 0;
        }
    }

    public void K(View view) {
        D(true);
        new Thread(new x(view)).start();
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
        webView.setWebViewClient(new o());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new p());
        builder.show();
    }

    public void l() {
        try {
            this.l0 = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.o0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.p0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.o0.setOnClickListener(new i());
            this.p0.setOnClickListener(new j());
            builder.setPositiveButton(getActivity().getString(R.string.btn_search), new DialogInterfaceOnClickListenerC0310l());
            builder.setNegativeButton(getActivity().getString(R.string.btn_cancel), new m());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new n(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void n() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void o(Cursor cursor) {
        if (isAdded()) {
            C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep3_1, this.I, 4);
            this.H = c0922Sv;
            c0922Sv.l.clear();
            this.H.notifyDataSetChanged();
            this.F.setAdapter((ListAdapter) this.H);
            A(this.I);
            this.H.notifyDataSetChanged();
            this.p = 0;
        }
        if (getActivity() != null) {
            this.v.setText(this.h.P7(String.valueOf(this.i)) + this.n);
            this.G.setText(getString(R.string.no_results));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.v0 = activity;
        try {
            this.S = (B) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new Z00(this.g, getActivity());
            this.k = getArguments() != null ? getArguments().getString("item_name") : "";
            this.l = getArguments() != null ? getArguments().getString("br_name") : "";
            this.m0 = getArguments() != null ? getArguments().getString("f_date") : "";
            this.n0 = getArguments() != null ? getArguments().getString("t_date") : "";
            this.N = getArguments() != null ? getArguments().getInt("size") : 0;
            this.n = getArguments() != null ? getArguments().getString("unit_name") : "";
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
        searchView.setOnQueryTextListener(new r());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.data_listview_rep1_3, viewGroup, false);
        this.h = new Z00(this.g, getActivity());
        setHasOptionsMenu(true);
        u(viewInflate);
        if (this.F == null) {
            this.F = (ListView) viewInflate.findViewById(R.id.list_items);
            TextView textView = (TextView) viewInflate.findViewById(android.R.id.empty);
            this.G = textView;
            textView.setText(getString(R.string.wait));
            this.F.setEmptyView(this.G);
        }
        this.F.setOnItemClickListener(new A());
        t();
        this.v = (TextView) viewInflate.findViewById(R.id.footer_sum);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
        this.x = imageView;
        imageView.setOnClickListener(this.q0);
        this.W = (ImageView) viewInflate.findViewById(R.id.move_right);
        this.X = (ImageView) viewInflate.findViewById(R.id.move_left);
        this.W.setOnClickListener(this.q0);
        this.X.setOnClickListener(this.q0);
        if (this.N <= 1) {
            this.W.setVisibility(8);
            this.X.setVisibility(8);
        }
        this.T = getActivity().getString(R.string.footer_cus_null);
        this.U = getActivity().getString(R.string.tot_radio1);
        this.V = getActivity().getString(R.string.tot_radio2);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.i0 = calendar.get(1);
        this.j0 = calendar.get(2);
        this.k0 = calendar.get(5);
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
            r();
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.print) {
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
        if (Build.VERSION.SDK_INT < 31) {
            n();
        }
        try {
            if (this.h.ja("prefPrintSort", true)) {
                F(this.I);
                this.H.notifyDataSetChanged();
                this.p = 1;
            }
            this.t0 = getActivity().getTitle().toString();
            z();
        } catch (Exception unused) {
        }
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
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            Bill_edit.Q2 = true;
            new C3966tX().A(getActivity(), this.F, this.G, -1);
            AbstractC3132jE.d(new Callable() { // from class: bp
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.v();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: cp
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.w((Integer) obj);
                }
            });
        }
    }

    public void p(int i2) {
        try {
            if (i2 == 1) {
                this.v.setText(this.h.P7(String.valueOf(this.i)) + this.n);
            } else {
                this.v.setText(this.h.P7(String.valueOf(s(this.H.e))) + this.n);
            }
        } catch (Exception unused) {
        }
    }

    public void q() {
        Cursor cursorO6;
        this.R = null;
        if (this.l0 == 0) {
            cursorO6 = this.h.O6(this.l, this.k, this.m0, this.n0);
        } else {
            boolean zIsEmpty = this.m0.isEmpty();
            String str = CSS.Value.PERCENTAGE;
            this.m0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.m0;
            if (!this.n0.isEmpty()) {
                str = this.n0;
            }
            this.n0 = str;
            new C2160f10(this.h).W(this.n0);
            cursorO6 = this.h.O6(this.l, this.k, this.m0, this.n0);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorO6.getCount()));
        this.i = 0.0d;
        this.I.clear();
        cursorO6.moveToFirst();
        while (!cursorO6.isAfterLast()) {
            this.i += Double.parseDouble(cursorO6.getString(cursorO6.getColumnIndex("f5")));
            this.I.add(new C4145vh(cursorO6.getString(cursorO6.getColumnIndex("_id")), cursorO6.getString(cursorO6.getColumnIndex("f7")), cursorO6.getString(cursorO6.getColumnIndex("f1")), this.h.P7(cursorO6.getString(cursorO6.getColumnIndex("f2"))), this.h.P7(cursorO6.getString(cursorO6.getColumnIndex("f3"))), this.h.P7(cursorO6.getString(cursorO6.getColumnIndex("f4"))), this.h.P7(cursorO6.getString(cursorO6.getColumnIndex("f5"))), this.h.P7(cursorO6.getString(cursorO6.getColumnIndex("f6"))), cursorO6.getString(cursorO6.getColumnIndex("f7")), cursorO6.getString(cursorO6.getColumnIndex("f8")), null));
            cursorO6.moveToNext();
        }
        cursorO6.close();
    }

    public void r() {
        new Thread(new t()).start();
    }

    public double s(List list) {
        Log.d("net_bal:", list.size() + "");
        double d = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d += Double.parseDouble(((C4145vh) list.get(i2)).r().replaceAll(",", ""));
        }
        return d;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && this.k != null && isResumed()) {
            r();
        }
    }

    public void t() {
        if (this.O != null) {
            return;
        }
        try {
            this.r0 = new AlertDialog.Builder(getActivity());
            View viewInflate = getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null);
            this.s0 = viewInflate;
            this.r0.setView(viewInflate);
            this.O = this.r0.create();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void u(View view) {
        if (view != null) {
            this.Y = (TextView) view.findViewById(R.id.f1);
            this.Z = (TextView) view.findViewById(R.id.f2);
            this.a0 = (TextView) view.findViewById(R.id.f3);
            this.b0 = (TextView) view.findViewById(R.id.f4);
            this.c0 = (TextView) view.findViewById(R.id.f5);
            this.d0 = (TextView) view.findViewById(R.id.f6);
            this.e0 = (TextView) view.findViewById(R.id.f7);
            this.f0 = (TextView) view.findViewById(R.id.f8);
        } else {
            this.Y = (TextView) view.findViewById(R.id.f1);
            this.Z = (TextView) view.findViewById(R.id.f2);
            this.a0 = (TextView) view.findViewById(R.id.f3);
            this.b0 = (TextView) view.findViewById(R.id.f4);
            this.c0 = (TextView) view.findViewById(R.id.f5);
            this.d0 = (TextView) view.findViewById(R.id.f6);
            this.e0 = (TextView) view.findViewById(R.id.f7);
            this.f0 = (TextView) view.findViewById(R.id.f8);
        }
        this.e0.setVisibility(8);
        this.f0.setVisibility(8);
        this.Y.setText(getString(R.string.bill_no3));
        this.Z.setText(getString(R.string.date2));
        this.a0.setText(getString(R.string.qty));
        this.b0.setText(getString(R.string.sales_price));
        this.c0.setText(getString(R.string.purchase_price2));
        this.d0.setText(getString(R.string.revenue));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(getActivity(), this.Y);
        c0372Bn.a(getActivity(), this.Z);
        c0372Bn.a(getActivity(), this.a0);
        c0372Bn.a(getActivity(), this.b0);
        c0372Bn.a(getActivity(), this.c0);
        c0372Bn.a(getActivity(), this.d0);
        this.h.ld(getActivity(), this.Z, this.p);
        TextView textView = this.Y;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.Z;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.a0;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.b0;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.c0;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        TextView textView6 = this.d0;
        textView6.setPaintFlags(8 | textView6.getPaintFlags());
        this.Z.setOnClickListener(new ViewOnClickListenerC3081a());
        this.Y.setOnClickListener(new ViewOnClickListenerC3082b());
        this.a0.setOnClickListener(new ViewOnClickListenerC3083c());
        this.b0.setOnClickListener(new ViewOnClickListenerC3084d());
        this.c0.setOnClickListener(new e());
        this.d0.setOnClickListener(new f());
    }

    public void x(View view) {
        this.l0 = 0;
        q();
    }

    public void y(String str) {
        try {
            this.H.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    public void z() {
        D(true);
        new Thread(new u()).start();
    }

    public l(C4145vh c4145vh, int i2, int i3, String str) {
        String strB = "";
        Bundle bundle = new Bundle();
        Log.d("frag_click=", c4145vh.a() + ":" + c4145vh.n());
        bundle.putString("item_name", c4145vh.n());
        if (c4145vh.b() != null && !c4145vh.b().equals(".")) {
            strB = c4145vh.b();
        }
        bundle.putString("unit_name", strB);
        bundle.putString("br_name", c4145vh.a());
        bundle.putString("f_date", FragmentStatePagerSupport.O);
        bundle.putString("t_date", FragmentStatePagerSupport.P);
        bundle.putInt(CSS.Property.POSITION, i2);
        bundle.putInt("size", i3);
        bundle.putString("searchString", str);
        setArguments(bundle);
    }
}
