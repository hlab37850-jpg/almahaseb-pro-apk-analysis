package info.aalmoghalis.inventory.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.widget.ArrayAdapter;
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
import androidx.appcompat.app.AlertDialog;
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
import defpackage.C0908Sh;
import defpackage.C0917Sq;
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
public class f extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<C4145vh>> {
    public static int x0 = 0;
    public static String y0 = "";
    public C0922Sv J;
    public TextView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;
    public TextView a0;
    public int e0;
    public int f0;
    public SQLiteDatabase g;
    public int g0;
    public Z00 h;
    public String i;
    public String j;
    public String k;
    public A q0;
    public Activity w0;
    public ImageView y;
    public ImageView z;
    public double l = 0.0d;
    public int n = 0;
    public int p = 0;
    public AutoCompleteTextView q = null;
    public EditText t = null;
    public EditText u = null;
    public TextView v = null;
    public ImageView w = null;
    public ImageView x = null;
    public ImageView A = null;
    public TextView B = null;
    public TextView C = null;
    public TextView D = null;
    public TextView E = null;
    public TextView F = null;
    public Button G = null;
    public ListView H = null;
    public TextView I = null;
    public List K = new ArrayList();
    public ImageButton L = null;
    public String[] M = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] N = {R.drawable.up, 1, R.drawable.down};
    public Toolbar O = null;
    public int P = 0;
    public String Q = "";
    public String R = "";
    public String S = "";
    public int b0 = 0;
    public DatePickerDialog.OnDateSetListener c0 = new z();
    public DatePickerDialog.OnDateSetListener d0 = new C3045a();
    public int h0 = 0;
    public String i0 = CSS.Value.PERCENTAGE;
    public String j0 = CSS.Value.PERCENTAGE;
    public String k0 = CSS.Value.PERCENTAGE;
    public TextView l0 = null;
    public TextView m0 = null;
    public TextView n0 = null;
    public boolean o0 = false;
    public ProgressDialog p0 = null;
    public View.OnClickListener r0 = new l();
    public Dialog s0 = null;
    public Handler t0 = new o();
    public String u0 = "";
    public ArrayList v0 = new ArrayList();

    public interface A {
        void onButtonClicked(View view);
    }

    public class B implements Comparator {
        public int a;

        public B(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 2) {
                return Double.valueOf(c4145vh.n().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.n().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.o().replaceAll(",", ""))) : Double.valueOf(c4145vh.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.p().replaceAll(",", "")));
        }
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
            if (i == 2) {
                return Double.valueOf(c4145vh2.n().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.n().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", ""))) : Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.f$a, reason: case insensitive filesystem */
    public class C3045a implements DatePickerDialog.OnDateSetListener {
        public C3045a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                f.this.m0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                f fVar = f.this;
                fVar.j0 = fVar.m0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.f$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3046b implements View.OnClickListener {
        public ViewOnClickListenerC3046b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(f.this.getActivity(), android.R.layout.simple_spinner_dropdown_item, f.this.h.T6());
            f fVar = f.this;
            fVar.h.T(fVar.getActivity(), arrayAdapter, f.this.n0);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.f$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3047c implements View.OnClickListener {
        public ViewOnClickListenerC3047c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", f.this.e0);
                bundle.putInt("month", f.this.f0);
                bundle.putInt("day", f.this.g0);
                c2137ei.setArguments(bundle);
                c2137ei.f(f.this.c0);
                c2137ei.show(f.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", f.this.e0);
                bundle.putInt("month", f.this.f0);
                bundle.putInt("day", f.this.g0);
                c2137ei.setArguments(bundle);
                c2137ei.f(f.this.d0);
                c2137ei.show(f.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(f.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.f$f, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0304f implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0304f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                f fVar = f.this;
                fVar.h0 = 0;
                fVar.v();
            } catch (Exception unused) {
            }
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public g(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                f fVar = f.this;
                fVar.h0 = 1;
                if (fVar.l0.getText() == null) {
                    f.this.i0 = "";
                } else {
                    f fVar2 = f.this;
                    fVar2.i0 = fVar2.l0.getText().toString();
                }
                if (f.this.m0.getText() == null) {
                    f.this.j0 = "";
                } else {
                    f fVar3 = f.this;
                    fVar3.j0 = fVar3.m0.getText().toString();
                }
                if (f.this.n0.getText() == null) {
                    f.this.k0 = "";
                } else {
                    f fVar4 = f.this;
                    fVar4.k0 = fVar4.n0.getText().toString();
                }
                f.this.v();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.p0.dismiss();
        }
    }

    public class i extends WebViewClient {
        public i() {
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

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class k implements AdapterView.OnItemClickListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
                String strA = c4145vh.a();
                f.y0 = strA;
                String str = f.this.j;
                f fVar = f.this;
                boolean zIsEmpty = fVar.i0.isEmpty();
                String str2 = CSS.Value.PERCENTAGE;
                fVar.i0 = zIsEmpty ? CSS.Value.PERCENTAGE : f.this.i0;
                f fVar2 = f.this;
                if (!fVar2.j0.isEmpty()) {
                    str2 = f.this.j0;
                }
                fVar2.j0 = str2;
                Intent intent = new Intent(f.this.getActivity(), (Class<?>) FragmentStatePagerSupport.class);
                intent.putExtra("screen_no", "7");
                intent.putExtra("report_type", 2);
                intent.putExtra("item_name", strA);
                intent.putExtra("br_name", str);
                intent.putExtra("unit_name", c4145vh.b());
                intent.putExtra("f_date", f.this.i0);
                intent.putExtra("t_date", f.this.j0);
                intent.putExtra("g_id", f.this.i);
                intent.putExtra("g_name", f.this.j);
                Log.d("lv_click", strA + ":" + str + ":" + f.this.i0 + ":" + f.this.j0 + ":" + f.this.K.size());
                int unused = f.x0 = f.this.H.getFirstVisiblePosition();
                f.this.getActivity().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                f.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                f.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                f.this.B(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                f.this.q0.onButtonClicked(view);
            }
        }
    }

    public class m implements Comparator {
        public m() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a()));
        }
    }

    public class n implements Comparator {
        public n() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a()));
        }
    }

    public class o extends Handler {
        public o() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            f.this.I(false);
            if (message.obj.toString().equals("0")) {
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = f.this.h;
                StringBuilder sb = new StringBuilder();
                f fVar = f.this;
                sb.append(fVar.h.ic(fVar.u0));
                sb.append(".pdf");
                z00.ra(sb.toString());
                return;
            }
            if (message.obj.toString().equals("3")) {
                f.this.J.notifyDataSetChanged();
                f fVar2 = f.this;
                Z00 z01 = fVar2.h;
                FragmentActivity activity = fVar2.getActivity();
                f fVar3 = f.this;
                z01.lc(activity, fVar3.T, fVar3.U, fVar3.V, fVar3.W);
                f fVar4 = f.this;
                int i = fVar4.b0;
                if (i == 1) {
                    Z00 z02 = fVar4.h;
                    FragmentActivity activity2 = fVar4.getActivity();
                    f fVar5 = f.this;
                    z02.ld(activity2, fVar5.T, fVar5.p);
                    return;
                }
                if (i == 2) {
                    Z00 z03 = fVar4.h;
                    FragmentActivity activity3 = fVar4.getActivity();
                    f fVar6 = f.this;
                    z03.ld(activity3, fVar6.U, fVar6.p);
                    return;
                }
                if (i == 3) {
                    Z00 z04 = fVar4.h;
                    FragmentActivity activity4 = fVar4.getActivity();
                    f fVar7 = f.this;
                    z04.ld(activity4, fVar7.V, fVar7.p);
                    return;
                }
                if (i == 4) {
                    Z00 z05 = fVar4.h;
                    FragmentActivity activity5 = fVar4.getActivity();
                    f fVar8 = f.this;
                    z05.ld(activity5, fVar8.W, fVar8.p);
                }
            }
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            Z00 z00 = fVar.h;
            ListView listView = fVar.H;
            String strIc = z00.ic(fVar.u0);
            f fVar2 = f.this;
            z00.bb(listView, strIc, fVar2.i0, fVar2.j0);
            Message message = new Message();
            message.obj = "1";
            f.this.t0.sendMessage(message);
        }
    }

    public class q implements SearchView.OnQueryTextListener {
        public q() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            f.this.D(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class s implements Comparator {
        public s() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a()));
        }
    }

    public class t implements Comparator {
        public t() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a()));
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                f.this.P(view);
            } catch (Exception unused) {
            }
        }
    }

    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                f.this.P(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                f.this.P(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                f.this.P(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class y implements Runnable {
        public final /* synthetic */ View a;

        public y(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    f.this.N(this.a);
                    f.this.b0 = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    f.this.M(this.a, 2);
                    f.this.b0 = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    f.this.M(this.a, 3);
                    f.this.b0 = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    f.this.M(this.a, 4);
                    f.this.b0 = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    f.this.M(this.a, 5);
                    f.this.b0 = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            f.this.t0.sendMessage(message);
        }
    }

    public class z implements DatePickerDialog.OnDateSetListener {
        public z() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                f.this.l0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                f fVar = f.this;
                fVar.i0 = fVar.l0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public f() {
    }

    private void F(List list) {
        Collections.sort(list, Collections.reverseOrder(new t()));
    }

    private void G(List list) {
        Collections.sort(list, Collections.reverseOrder(new n()));
    }

    private void H(List list, int i2) {
        Collections.sort(list, new C(i2));
    }

    private void J(List list, int i2) {
        Collections.sort(list, new B(i2));
    }

    private void K(List list) {
        Collections.sort(list, Collections.reverseOrder(new s()));
    }

    private void L(List list) {
        Collections.sort(list, Collections.reverseOrder(new m()));
    }

    private void p(String str) {
        new android.app.AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new r()).show();
    }

    private void s() {
        int i2 = Calendar.getInstance().get(14);
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.i + 1) * i2, null, this).forceLoad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer x() {
        t();
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Integer num) {
        u();
        I(false);
    }

    public final /* synthetic */ void A(Integer num) {
        s();
    }

    public void B(View view) {
        this.h0 = 0;
        v();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        TextView textView;
        ListView listView = this.H;
        if (listView != null && (textView = this.I) != null) {
            listView.setEmptyView(textView);
            this.I.setText(getString(R.string.no_results));
        }
        this.K = list;
        if (getActivity() != null) {
            Log.d("listviewadapter=", "null");
            C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep1_, this.K, 16, this.h.f9("select * from items_cost_calc a where round(a.n_q,7)<0") > 0);
            this.J = c0922Sv;
            c0922Sv.notifyDataSetChanged();
            this.H.setAdapter((ListAdapter) this.J);
            r();
        }
        if (getUserVisibleHint()) {
            ((App) getActivity().getApplication()).c(this.K);
        }
    }

    public void D(String str) {
        try {
            this.J.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    public void E() {
        I(true);
        new Thread(new p()).start();
    }

    public void I(boolean z2) {
        Log.d("mProgress=", "....start..." + z2);
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z2) {
                android.app.AlertDialog alertDialogCreate = builder.create();
                this.s0 = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.s0;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void M(View view, int i2) {
        if (this.p == 0) {
            J(this.K, i2);
            this.p = 1;
        } else {
            H(this.K, i2);
            this.p = 0;
        }
    }

    public void N(View view) {
        if (this.p == 0) {
            K(this.K);
            this.p = 1;
        } else {
            F(this.K);
            this.p = 0;
        }
    }

    public void O(View view) {
        if (this.p == 0) {
            L(this.K);
            this.J.notifyDataSetChanged();
            this.p = 1;
        } else {
            G(this.K);
            this.J.notifyDataSetChanged();
            this.p = 0;
        }
    }

    public void P(View view) {
        I(true);
        new Thread(new y(view)).start();
    }

    public void amount_add_btn(View view) {
        Bill_edit.P2 = true;
        this.h.z(getActivity(), this.i, this.j);
    }

    public void help_btn(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new i());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new j());
        builder.show();
    }

    public void o() {
        try {
            this.h0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input_item_type, (ViewGroup) null);
            builder.setView(viewInflate);
            this.l0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.m0 = (TextView) viewInflate.findViewById(R.id.t_date);
            TextView textView = (TextView) viewInflate.findViewById(R.id.item_type);
            this.n0 = textView;
            textView.setOnClickListener(new ViewOnClickListenerC3046b());
            this.l0.setOnClickListener(new ViewOnClickListenerC3047c());
            this.m0.setOnClickListener(new d());
            builder.setPositiveButton(getActivity().getString(R.string.btn_search), new e());
            builder.setNegativeButton(getActivity().getString(R.string.btn_cancel), new DialogInterfaceOnClickListenerC0304f());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new g(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.w0 = activity;
        try {
            this.q0 = (A) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressDialog progressDialog = new ProgressDialog(view.getContext());
        this.p0 = progressDialog;
        progressDialog.setCancelable(true);
        this.p0.setMessage("Processing...");
        this.p0.setProgressStyle(0);
        this.p0.setMax(10);
        this.p0.show();
        this.K = this.J.e;
        if (view.getId() == R.id.f1) {
            O(view);
        }
        new Handler().postDelayed(new h(), 400L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new Z00(this.g, getActivity());
            this.i = getArguments() != null ? getArguments().getString("cus_id") : "";
            this.j = getArguments() != null ? getArguments().getString("cus_name") : "";
            this.k = getArguments() != null ? getArguments().getString("curr_name") : "";
            this.P = getArguments() != null ? getArguments().getInt("size") : 0;
            if (getActivity() == null || getActivity().getIntent().getStringExtra("f_date") == null || getActivity().getIntent().getStringExtra("t_date") == null) {
                return;
            }
            this.i0 = getActivity().getIntent().getStringExtra("f_date");
            this.j0 = getActivity().getIntent().getStringExtra("t_date");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4145vh>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("Loader=", "onCreateLoader:" + this.j + ":" + this.i0 + ":" + this.j0);
        return new C0908Sh(getActivity(), this.i, this.k, this.h, this.i0, this.j0, 1);
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
        searchView.setOnQueryTextListener(new q());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View viewInflate = layoutInflater.inflate(R.layout.data_listview_rep1_, viewGroup, false);
            this.h = new Z00(this.g, getActivity());
            setHasOptionsMenu(true);
            w(viewInflate);
            Log.d("OnCreate:=", "onCreateView_all:" + this.i);
            if (this.H == null) {
                this.H = (ListView) viewInflate.findViewById(R.id.list_items);
                TextView textView = (TextView) viewInflate.findViewById(android.R.id.empty);
                this.I = textView;
                textView.setText(getString(R.string.wait));
                this.H.setEmptyView(this.I);
            }
            this.H.setOnItemClickListener(new k());
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.footer_sum);
            this.v = textView2;
            textView2.setText(this.j);
            this.y = (ImageView) viewInflate.findViewById(R.id.move_right);
            this.z = (ImageView) viewInflate.findViewById(R.id.move_left);
            this.y.setOnClickListener(this.r0);
            this.z.setOnClickListener(this.r0);
            if (this.P <= 1) {
                this.y.setVisibility(8);
                this.z.setVisibility(8);
            }
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
            this.x = imageView;
            imageView.setOnClickListener(this.r0);
            this.Q = getActivity().getString(R.string.footer_cus_null);
            this.R = getActivity().getString(R.string.tot_radio1);
            this.S = getActivity().getString(R.string.tot_radio2);
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
            if (getUserVisibleHint()) {
                s();
            }
            return viewInflate;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("oncreateview_err=", e2.getMessage());
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.w0 = null;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C4145vh>> loader) {
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str;
        int itemId = menuItem.getItemId();
        if (itemId != R.id.print) {
            if (itemId == R.id.adv_search) {
                o();
                return true;
            }
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            getActivity().finish();
            return true;
        }
        if (Build.VERSION.SDK_INT < 31) {
            q();
        }
        if (this.h.ja("prefPrintSort", true)) {
            this.J.notifyDataSetChanged();
            this.p = 1;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.j);
            if (this.k0.equals(CSS.Value.PERCENTAGE)) {
                str = "";
            } else {
                str = "-" + this.k0;
            }
            sb.append(str);
            this.u0 = sb.toString();
            E();
        } catch (Exception unused) {
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (getActivity() != null) {
            getActivity().getIntent().putExtra("f_date", this.i0);
            getActivity().getIntent().putExtra("t_date", this.j0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            p(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Log.d("onresume=", Bill_edit.Q2 + ":" + this.i0);
        if (Bill_edit.Q2) {
            Bill_edit.Q2 = false;
            new C3966tX().A(getActivity(), this.H, this.I, -1);
            AbstractC3132jE.d(new Callable() { // from class: Co
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.z();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Do
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.A((Integer) obj);
                }
            });
        }
    }

    public void q() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void r() {
        try {
            Log.d("lv_pos=", x0 + "");
            if (x0 <= 0) {
                x0 = 0;
                return;
            }
            if (this.H.getFirstVisiblePosition() > x0 || this.H.getLastVisiblePosition() < x0) {
                this.H.setSelection(x0);
            }
            x0 = 0;
        } catch (Exception e2) {
            x0 = 0;
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && this.i != null && isResumed()) {
            s();
        }
    }

    public void t() {
        Cursor cursorB7;
        Log.d("get_all_names", "get_all_names:" + this.i + ":" + this.h0);
        if (!this.o0) {
            this.o0 = true;
            this.h.Vb();
        }
        if (this.h0 == 0) {
            cursorB7 = this.h.a7(this.i);
        } else {
            boolean zIsEmpty = this.i0.isEmpty();
            String str = CSS.Value.PERCENTAGE;
            this.i0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.i0;
            this.j0 = this.j0.isEmpty() ? CSS.Value.PERCENTAGE : this.j0;
            if (!this.k0.isEmpty()) {
                str = this.k0;
            }
            this.k0 = str;
            new C2160f10(this.h).W(this.j0);
            cursorB7 = this.h.b7(this.i, this.i0, this.j0, this.k0);
        }
        Log.d("recCount=", cursorB7.getCount() + "");
        this.l = 0.0d;
        this.K.clear();
        cursorB7.moveToFirst();
        while (!cursorB7.isAfterLast()) {
            this.K.add(new C4145vh(cursorB7.getString(cursorB7.getColumnIndex("_id")), cursorB7.getString(cursorB7.getColumnIndex("f1")), this.h.P7(String.valueOf(cursorB7.getDouble(cursorB7.getColumnIndex("f2")))), this.h.P7(String.valueOf(cursorB7.getDouble(cursorB7.getColumnIndex("f4")))), this.h.P7(String.valueOf(cursorB7.getDouble(cursorB7.getColumnIndex("f5")))), this.h.P7(String.valueOf(cursorB7.getDouble(cursorB7.getColumnIndex("f3")))), this.h.P7(String.valueOf(cursorB7.getDouble(cursorB7.getColumnIndex("f6")))), this.h.P7(String.valueOf(cursorB7.getDouble(cursorB7.getColumnIndex("f7")))), this.h.P7(String.valueOf(cursorB7.getDouble(cursorB7.getColumnIndex("f8")))), "", cursorB7.getString(cursorB7.getColumnIndex("f10"))));
            cursorB7.moveToNext();
        }
        cursorB7.close();
    }

    public void u() {
        C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep1_, this.K, 16, this.h.f9("select * from items_cost_calc a where round(a.n_q,7)<0") > 0);
        this.J = c0922Sv;
        this.H.setAdapter((ListAdapter) c0922Sv);
        this.J.notifyDataSetChanged();
        this.I.setText(getString(R.string.no_results));
        ((App) getActivity().getApplication()).c(this.K);
        if (!new C1839c10().i(this.k0, this.h0)) {
            this.v.setText(this.j);
            return;
        }
        this.v.setText(this.j + "-" + this.k0);
    }

    public void v() {
        I(true);
        AbstractC3132jE.d(new Callable() { // from class: Eo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.x();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Fo
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.y((Integer) obj);
            }
        });
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
        this.Y.setVisibility(8);
        this.Z.setVisibility(8);
        this.a0.setVisibility(8);
        this.T.setText(getString(R.string.item));
        TextView textView = this.T;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.U;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.V;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.W;
        textView4.setPaintFlags(8 | textView4.getPaintFlags());
        this.h.ld(getActivity(), this.T, this.p);
        this.U.setText(getString(R.string.bal_in));
        this.V.setText(getString(R.string.bal_move));
        this.W.setText(getString(R.string.bal_net));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(getActivity(), this.T);
        c0372Bn.a(getActivity(), this.U);
        c0372Bn.a(getActivity(), this.V);
        c0372Bn.a(getActivity(), this.W);
        this.T.setOnClickListener(new u());
        this.U.setOnClickListener(new v());
        this.V.setOnClickListener(new w());
        this.W.setOnClickListener(new x());
    }

    public final /* synthetic */ Integer z() {
        this.h.Vb();
        return 1;
    }

    public f(C0917Sq c0917Sq, int i2, int i3, String str) {
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
