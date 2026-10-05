package info.aalmoghalis.inventory.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC4032uI;
import defpackage.AbstractC4371yX;
import defpackage.C0450En;
import defpackage.C0870Qv;
import defpackage.C0917Sq;
import defpackage.C1044Xj;
import defpackage.C1249ah;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C4143vg;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Q00;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.e;
import info.aalmoghalis.inventory.lang.App;
import info.aalmoghalis.inventory.old.CusLimit_edit;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class e extends Fragment implements LoaderManager.LoaderCallbacks<List<C4143vg>> {
    public static int A0;
    public SparseBooleanArray A;
    public ImageView D;
    public ImageView E;
    public ImageView F;
    public Boolean J;
    public Boolean K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public Context T;
    public View U;
    public Activity V;
    public SwipeRefreshLayout W;
    public int X;
    public ArrayList Y;
    public View.OnClickListener Z;
    public int a0;
    public String b0;
    public String c0;
    public int d0;
    public int e0;
    public EditText f0;
    public SQLiteDatabase g;
    public boolean g0;
    public Z00 h;
    public String h0;
    public ArrayList i0;
    public int j0;
    public int k0;
    public int l0;
    public int m0;
    public String n0;
    public String o0;
    public String p;
    public TextView p0;
    public String q;
    public TextView q0;
    public ProgressDialog r0;
    public Handler s0;
    public String t;
    public ArrayList t0;
    public String u;
    public Bundle u0;
    public SearchView v0;
    public J w0;
    public C0870Qv x;
    public String x0;
    public boolean y0;
    public LoaderManager.LoaderCallbacks z0;
    public EditText i = null;
    public EditText j = null;
    public Button k = null;
    public int l = 0;
    public int n = -1;
    public ListView v = null;
    public TextView w = null;
    public List y = new ArrayList();
    public ArrayList z = new ArrayList();
    public ActionBar B = null;
    public TextView C = null;
    public int[] G = {R.drawable.up, 1, R.drawable.down};
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public boolean I = false;

    public class A implements SearchView.OnQueryTextListener {
        public A() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    try {
                        e.this.u(1);
                    } catch (Exception unused) {
                    }
                }
                e.this.D(str);
                return false;
            } catch (Exception unused2) {
                return false;
            }
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            try {
                e.this.u(2);
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public class B implements MenuItemCompat.OnActionExpandListener {
        public B() {
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            try {
                e.this.u(1);
            } catch (Exception unused) {
            }
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            try {
                e.this.u(1);
            } catch (Exception unused) {
            }
            return true;
        }
    }

    public class C implements LoaderManager.LoaderCallbacks {
        public C() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader loader, List list) {
            String str;
            e.this.i0 = (ArrayList) list;
            Log.d("trace_E_Loader2=", FragmentStatePagerSupport_Main.X() + ":curr=" + e.this.t + ":g_id=" + e.this.p + ":type=" + e.this.u);
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
            e eVar = e.this;
            eVar.C.setText(eVar.M);
            try {
                TextView textView = e.this.C;
                StringBuilder sb = new StringBuilder();
                sb.append(e.this.N);
                sb.append(numberFormat.format(Double.parseDouble((String) e.this.i0.get(0))));
                sb.append(" ");
                sb.append(e.this.O);
                sb.append(numberFormat.format(Double.parseDouble((String) e.this.i0.get(1))));
                if (Z00.Z) {
                    str = StringUtilities.LF + e.this.t;
                } else {
                    str = "";
                }
                sb.append(str);
                textView.setText(sb.toString());
                e.this.t();
            } catch (Exception unused) {
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            Log.d("Loader=", "onCreateLoader_Footer:" + e.this.p + ":" + e.this.t + ":" + e.this.u);
            Log.d("trace_S_Loader2=", FragmentStatePagerSupport_Main.X() + ":" + e.this.t + ":" + e.this.p + ":" + e.this.u + ":id=" + i);
            FragmentActivity activity = e.this.getActivity();
            e eVar = e.this;
            return new C0450En(activity, eVar.p, eVar.t, eVar.u, eVar.h);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
        }
    }

    public class D implements Callable {
        public D() {
        }

        public static /* synthetic */ void e(Integer num) {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void call() {
            e.this.h.Lc("bill_total_check_date", Z00.n3());
            try {
                AbstractC3132jE.d(new Callable() { // from class: go
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.a.d();
                    }
                }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: ho
                    @Override // defpackage.InterfaceC2295gf
                    public final void accept(Object obj) {
                        e.D.e((Integer) obj);
                    }
                });
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public final /* synthetic */ Integer d() {
            e eVar = e.this;
            eVar.h.H0(eVar.getActivity());
            return 1;
        }
    }

    public class E implements View.OnClickListener {
        public E() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_help) {
                e.this.help_btn(view);
                return;
            }
            if (view.getId() == R.id.img_add_amount) {
                e.this.amount_add_btn(view);
            } else if (view.getId() == R.id.img_add) {
                e.this.add_btn(view);
            } else if (view.getId() == R.id.img_move_tr) {
                e.this.move_tr_btn(view);
            }
        }
    }

    public class F extends Handler {
        public F() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class G implements Runnable {
        public G() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            int i = eVar.a0;
            if (i == 7) {
                eVar.I(1);
            } else if (i == 6) {
                eVar.I(3);
            }
        }
    }

    public class H implements Runnable {
        public final /* synthetic */ C4143vg a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public H(C4143vg c4143vg, String str, String str2, String str3, String str4) {
            this.a = c4143vg;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            Z00 z00 = e.this.h;
            String strH = this.a.h();
            StringBuilder sb = new StringBuilder();
            if (this.b.length() == 0) {
                str = this.c;
            } else {
                str = this.b + ":\n" + this.d;
            }
            sb.append(str);
            sb.append(":");
            sb.append(this.a.a());
            String str3 = "";
            if (Z00.Z) {
                str2 = "\t" + this.a.b();
            } else {
                str2 = "";
            }
            sb.append(str2);
            if (this.e.length() != 0) {
                str3 = StringUtilities.LF + this.e;
            }
            sb.append(str3);
            z00.Ed(strH, sb.toString());
        }
    }

    public class I implements Runnable {
        public final /* synthetic */ C4143vg a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public I(C4143vg c4143vg, String str, String str2, String str3, String str4) {
            this.a = c4143vg;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            Z00 z00 = e.this.h;
            String strH = this.a.h();
            StringBuilder sb = new StringBuilder();
            if (this.b.length() == 0) {
                str = this.c;
            } else {
                str = this.b + ":\n" + this.d;
            }
            sb.append(str);
            sb.append(":");
            sb.append(this.a.a());
            String str3 = "";
            if (Z00.Z) {
                str2 = "\t" + this.a.b();
            } else {
                str2 = "";
            }
            sb.append(str2);
            if (this.e.length() != 0) {
                str3 = StringUtilities.LF + this.e;
            }
            sb.append(str3);
            z00.Ed(strH, sb.toString());
        }
    }

    public interface J {
        void onButtonClicked(MenuItem menuItem);
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3036a implements View.OnClickListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$a$a, reason: collision with other inner class name */
        public class RunnableC0302a implements Runnable {
            public RunnableC0302a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.W.setRefreshing(true);
                e.this.F();
                e.this.W.setRefreshing(false);
            }
        }

        public ViewOnClickListenerC3036a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new Handler().post(new RunnableC0302a());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$b, reason: case insensitive filesystem */
    public class HandlerC3037b extends Handler {
        public HandlerC3037b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$c, reason: case insensitive filesystem */
    public class C3038c implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public C3038c(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
            this.b.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$d, reason: case insensitive filesystem */
    public class C3039d implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C3039d(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$e, reason: collision with other inner class name */
    public class ViewOnTouchListenerC0303e implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnTouchListenerC0303e(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$f, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3040f implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC3040f(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.n(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$g, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3041g implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC3041g(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.n(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$h, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3042h implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3042h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$i, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3043i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3043i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.e$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3044j implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AlertDialog d;

        public ViewOnClickListenerC3044j(AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, int i, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = autoCompleteTextView2;
            this.c = i;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (e.this.h.S2(this.a.getText().toString()).getCount() == 0 || e.this.h.u3(this.b.getText().toString()) == 0) {
                zA = false;
            }
            if (zA) {
                e eVar = e.this;
                C4143vg c4143vgA = eVar.x.getItem(eVar.A.keyAt(this.c));
                e.this.x.remove(c4143vgA);
                String strM = e.this.h.M("update transactions  set curr_id=(select b.id from currency b where b.name='" + this.a.getText().toString() + "') , cus_id=(select b.id from customers b where b.name='" + this.b.getText().toString() + "') where cus_id='" + c4143vgA.i() + "' and t_cus_id is null  and curr_id=(select b.id from currency b where b.name='" + e.this.t + "')", "update transactions  set curr_id=(select b.id from currency b where b.name='" + this.a.getText().toString() + "') , t_cus_id=(select b.id from customers b where b.name='" + this.b.getText().toString() + "') where t_cus_id is not null and  t_cus_id='" + c4143vgA.i() + "' and cus_id<> '" + c4143vgA.i() + "' and curr_id=(select b.id from currency b where b.name='" + e.this.t + "')", "update transactions  set curr_id=(select b.id from currency b where b.name='" + this.a.getText().toString() + "') , cus_id=(select b.id from customers b where b.name='" + this.b.getText().toString() + "') where t_cus_id is not null  and cus_id='" + c4143vgA.i() + "' and t_cus_id<> '" + c4143vgA.i() + "' and curr_id=(select b.id from currency b where b.name='" + e.this.t + "')");
                if (strM != null && strM.equals("1")) {
                    e.this.t = this.a.getText().toString();
                    FragmentStatePagerSupport_Main.a0 = true;
                    e.this.z(this.a.getText().toString(), e.this.t);
                    this.d.dismiss();
                    return;
                }
                FragmentActivity activity = e.this.getActivity();
                StringBuilder sb = new StringBuilder();
                sb.append("Error:");
                if (strM != null && strM.length() > 20) {
                    strM = strM.substring(0, 20);
                }
                sb.append(strM);
                Toast.makeText(activity, sb.toString(), 0).show();
            }
        }
    }

    public class k implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public k(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class l implements AdapterView.OnItemClickListener {
        public l() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                String string = ((TextView) view.findViewById(R.id.cus_id)).getText().toString();
                String string2 = ((TextView) view.findViewById(R.id.balance)).getText().toString();
                String string3 = ((TextView) view.findViewById(R.id.cus_phone)).getText().toString();
                TextView textView = (TextView) view.findViewById(R.id.customer_name);
                String string4 = textView.getTag() != null ? textView.getTag().toString() : "";
                String string5 = textView.getText().toString();
                Log.d("trace_cus_click=", string5 + ":" + string4);
                Intent intent = new Intent(view.getContext(), (Class<?>) FragmentStatePagerSupport.class);
                intent.putExtra("CUS_ID", string);
                intent.putExtra("CUS_BAL", string2);
                intent.putExtra("CUS_GSM", string3);
                intent.putExtra("CUS_NAME", string5);
                e eVar = e.this;
                eVar.p = eVar.h.j4(string);
                intent.putExtra("g_id", e.this.p);
                intent.putExtra("G_NAME", e.this.q);
                intent.putExtra("CURR_NAME", string4);
                e eVar2 = e.this;
                eVar2.l(string5, eVar2.p, string4, eVar2.h.v3(string));
                int unused = e.A0 = e.this.v.getFirstVisiblePosition();
                Bill_edit.P2 = false;
                e.this.startActivity(intent);
            } catch (Exception unused2) {
            }
        }
    }

    public class m implements SwipeRefreshLayout.OnRefreshListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.F();
                e.this.W.setRefreshing(false);
            }
        }

        public m() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            new Handler().post(new a());
        }
    }

    public class n implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public n(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class o implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public o(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.n(this.a, this.b);
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class q implements DialogInterface.OnClickListener {
        public q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AlertDialog b;

        public r(AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (e.this.h.Q5(this.a.getText().toString()).getCount() == 0) {
                e.this.h0 = this.a.getText().toString();
                e eVar = e.this;
                eVar.v(eVar.getActivity().getString(R.string.validation_add_group), e.this.getActivity().getString(R.string.validation_add_group) + "#" + e.this.h0, e.this.getActivity());
                if (!e.this.g0) {
                    return;
                }
            }
            if (zA) {
                for (int size = e.this.A.size() - 1; size >= 0; size--) {
                    if (e.this.A.valueAt(size)) {
                        e eVar2 = e.this;
                        C4143vg c4143vgA = eVar2.x.getItem(eVar2.A.keyAt(size));
                        e.this.x.remove(c4143vgA);
                        e.this.h.v0("update customers  set g_id=(select b.id from groups b where b.name='" + this.a.getText().toString() + "'),online=0 where id='" + c4143vgA.i() + "'");
                    }
                }
                e.this.w(1);
                e.this.y(this.a.getText().toString());
                this.b.dismiss();
            }
        }
    }

    public class s extends Handler {
        public s() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public t(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            e.this.h.v0("insert into groups  (name )  values( '" + e.this.h0 + "'  )");
            e.this.g0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public u(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            e.this.g0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class v implements AbsListView.MultiChoiceModeListener {

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
            }
        }

        public v() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    SparseBooleanArray sparseBooleanArrayC = e.this.x.c();
                    e eVar = e.this;
                    eVar.A = sparseBooleanArrayC;
                    AlertDialog.Builder builder = new AlertDialog.Builder(eVar.getActivity());
                    builder.setMessage(e.this.getActivity().getString(R.string.delete_msg_cus));
                    builder.setPositiveButton(e.this.getActivity().getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(e.this.getActivity().getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC2 = e.this.x.c();
                    e eVar2 = e.this;
                    eVar2.A = sparseBooleanArrayC2;
                    eVar2.q();
                    actionMode.finish();
                    break;
                case R.id.menu_move /* 2131297042 */:
                    SparseBooleanArray sparseBooleanArrayC3 = e.this.x.c();
                    e eVar3 = e.this;
                    eVar3.A = sparseBooleanArrayC3;
                    eVar3.B();
                    actionMode.finish();
                    break;
                case R.id.menu_move_curr /* 2131297043 */:
                    SparseBooleanArray sparseBooleanArrayC4 = e.this.x.c();
                    e eVar4 = e.this;
                    eVar4.A = sparseBooleanArrayC4;
                    eVar4.A();
                    actionMode.finish();
                    break;
                case R.id.menu_sms /* 2131297046 */:
                    SparseBooleanArray sparseBooleanArrayC5 = e.this.x.c();
                    e.this.A = sparseBooleanArrayC5;
                    if (sparseBooleanArrayC5.size() > 0) {
                        if (menuItem.getTitle() == e.this.getString(R.string.sms)) {
                            e.this.I(1);
                        } else {
                            e.this.I(3);
                        }
                    }
                    actionMode.finish();
                    break;
                case R.id.menu_whats /* 2131297047 */:
                    SparseBooleanArray sparseBooleanArrayC6 = e.this.x.c();
                    e.this.A = sparseBooleanArrayC6;
                    if (sparseBooleanArrayC6.size() > 0) {
                        if (menuItem.getTitle() == e.this.getString(R.string.whatsapp)) {
                            e.this.I(3);
                        } else {
                            e.this.I(1);
                        }
                    }
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (Z00.Z) {
                actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar_main2, menu);
                return true;
            }
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar_main, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            e.this.v.setBackgroundColor(Color.parseColor("#FFFFFF"));
            e.this.x.i.clear();
            e.this.x.e();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = e.this.v.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            e.this.x.g(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (e.this.v.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
                if (Z00.Z) {
                    menu.findItem(R.id.menu_move_curr).setVisible(false);
                }
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
                if (Z00.Z) {
                    menu.findItem(R.id.menu_move_curr).setVisible(true);
                }
                menu.findItem(R.id.menu_sms).setIcon(R.drawable.whatsapp);
                menu.findItem(R.id.menu_whats).setIcon(R.drawable.sms);
                menu.findItem(R.id.menu_sms).setTitle(e.this.getString(R.string.whatsapp));
                menu.findItem(R.id.menu_whats).setTitle(e.this.getString(R.string.sms));
                menu.findItem(R.id.menu_sms).setVisible(true);
                menu.findItem(R.id.menu_whats).setVisible(true);
            }
            return false;
        }
    }

    public class w extends Handler {
        public w() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (!message.obj.toString().equals("0") && message.obj.toString().equals("1")) {
                Z00 z00 = e.this.h;
                StringBuilder sb = new StringBuilder();
                e eVar = e.this;
                sb.append(eVar.h.ic(eVar.x0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            e.this.H(false);
        }
    }

    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            Z00 z00 = eVar.h;
            ListView listView = eVar.v;
            String strIc = z00.ic(eVar.x0);
            e eVar2 = e.this;
            z00.Fb(listView, strIc, eVar2.x(eVar2.x.d), e.this.t);
            Message message = new Message();
            message.obj = "1";
            e.this.s0.sendMessage(message);
        }
    }

    public class y extends WebViewClient {
        public y() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('2','8','7')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public class z implements DialogInterface.OnClickListener {
        public z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public e() {
        Boolean bool = Boolean.FALSE;
        this.J = bool;
        this.K = bool;
        this.U = null;
        this.X = -1;
        this.Y = new ArrayList();
        this.Z = new E();
        this.a0 = 0;
        this.b0 = "";
        this.c0 = "";
        this.d0 = 0;
        this.e0 = 0;
        this.h0 = "";
        this.i0 = new ArrayList();
        this.m0 = 0;
        this.n0 = CSS.Value.PERCENTAGE;
        this.o0 = CSS.Value.PERCENTAGE;
        this.p0 = null;
        this.q0 = null;
        this.s0 = new w();
        this.t0 = new ArrayList();
        this.y0 = true;
        this.z0 = new C();
    }

    private void o() {
        Log.d("data_loader=", "g_id=" + this.p + ":curr=" + this.t + ":type=" + this.u);
        int i = Integer.parseInt(this.p) * 100;
        LoaderManager loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(i + 2, null, this.z0).forceLoad();
        loaderManager.initLoader(i + 1, null, this).forceLoad();
    }

    public void A() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_customer3, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.to_cus_name);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_curr);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_contacts);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_curr);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.h.s3());
            int size = this.A.size() - 1;
            String str = "";
            if (this.A.valueAt(size)) {
                C4143vg c4143vgA = this.x.getItem(this.A.keyAt(size));
                String strJ = c4143vgA.j();
                c4143vgA.i();
                str = strJ;
            }
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, this.h.K4(str, autoCompleteTextView.getText().toString()));
            autoCompleteTextView2.setText(this.t);
            autoCompleteTextView2.setOnItemClickListener(new C3039d(autoCompleteTextView2));
            autoCompleteTextView2.setOnTouchListener(new ViewOnTouchListenerC0303e(autoCompleteTextView2));
            autoCompleteTextView2.setAdapter(arrayAdapter);
            autoCompleteTextView.setAdapter(arrayAdapter2);
            autoCompleteTextView2.requestFocus();
            autoCompleteTextView2.selectAll();
            imageView.setOnClickListener(new ViewOnClickListenerC3040f(arrayAdapter, autoCompleteTextView2));
            imageView2.setOnClickListener(new ViewOnClickListenerC3041g(arrayAdapter2, autoCompleteTextView));
            builder.setPositiveButton(getActivity().getString(R.string.resourceID_OK), new DialogInterfaceOnClickListenerC3042h());
            builder.setNegativeButton(getActivity().getString(R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC3043i());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getActivity().getString(R.string.menu_move_curr));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC3044j(autoCompleteTextView2, autoCompleteTextView, size, alertDialogCreate));
        } catch (Exception e) {
            FragmentActivity activity = getActivity();
            StringBuilder sb = new StringBuilder();
            sb.append("Error:");
            sb.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
            Toast.makeText(activity, sb.toString(), 1).show();
        }
    }

    public void B() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_customer2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_call);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_class);
            editText.setVisibility(8);
            editText2.setVisibility(8);
            imageView.setVisibility(8);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.h.U5());
            autoCompleteTextView.setText(this.h.T5(this.p));
            autoCompleteTextView.setOnItemClickListener(new k(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new n(autoCompleteTextView));
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.selectAll();
            imageView2.setOnClickListener(new o(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getActivity().getString(R.string.resourceID_OK), new p());
            builder.setNegativeButton(getActivity().getString(R.string.resourceID_Cancel), new q());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getActivity().getString(R.string.change_class));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new r(autoCompleteTextView, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(FragmentStatePagerSupport_Main.X());
            sb.append(":curr=");
            sb.append(this.t);
            sb.append(":g_id=");
            sb.append(this.p);
            sb.append(":type=");
            sb.append(this.u);
            sb.append(":");
            sb.append(list.size());
            sb.append(":");
            sb.append(getUserVisibleHint());
            sb.append(":");
            sb.append(isAdded());
            sb.append(":Notnull=");
            sb.append(getActivity() != null);
            Log.d("trace_E_Loader1=", sb.toString());
            this.y = list;
            this.w.setText(R.string.no_results);
            this.v.setEmptyView(this.w);
            if (getActivity() != null) {
                C0870Qv c0870Qv = new C0870Qv(getActivity(), R.layout.customer_row, this.y);
                this.x = c0870Qv;
                this.v.setAdapter((ListAdapter) c0870Qv);
            }
            if (getUserVisibleHint()) {
                ((App) requireActivity().getApplication()).d(this.y);
                if (this.n == 0) {
                    k();
                    m();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Fetch_err", e.getMessage() + "");
        }
    }

    public void D(String str) {
        try {
            C0870Qv c0870Qv = this.x;
            if (c0870Qv != null) {
                c0870Qv.getFilter().filter(str);
            }
        } catch (Exception unused) {
        }
    }

    public void E() {
        H(true);
        new Thread(new x()).start();
    }

    public final void F() {
        try {
            if (Z00.Z) {
                if (this.Y.size() == 0) {
                    this.Y = this.h.j3();
                }
                for (int i = 0; i < this.Y.size(); i++) {
                    if (this.X >= this.Y.size() - 1) {
                        this.X = -1;
                    }
                    int i2 = this.X + 1;
                    this.X = i2;
                    String str = (String) ((HashMap) this.Y.get(i2)).get("name");
                    if (!str.equals("") && this.h.R5(this.p, this.u, str).getCount() > 0 && !str.equals(this.t)) {
                        this.t = str;
                        w(1);
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void G() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new y());
        builder.setView(webView);
        builder.setNegativeButton(getActivity().getString(R.string.confirm_close), new z());
        builder.show();
    }

    public void H(boolean z2) {
        try {
            if (z2) {
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                this.r0 = progressDialog;
                progressDialog.setMessage(getString(R.string.google_drive_list));
                this.r0.show();
            } else {
                this.r0.hide();
            }
        } catch (Exception unused) {
        }
    }

    public void I(int i) {
        String str;
        String str2;
        this.e0 = i;
        int i2 = 0;
        this.a0 = 0;
        if (getActivity() != null) {
            this.c0 = getActivity().getString(R.string.credit);
            this.b0 = getActivity().getString(R.string.debit);
        }
        String string = getActivity().getString(R.string.pref_default_display_name);
        String strIa = this.h.ia("prefSMS_header", string);
        String strIa2 = this.h.ia("prefSMS_footer", string);
        String strIa3 = this.h.ia("prefSMS_credit", string);
        String strIa4 = this.h.ia("prefSMS_debit", string);
        if (strIa3.equals(string)) {
            strIa3 = getActivity().getString(R.string.credit);
        }
        if (strIa4.equals(string)) {
            strIa4 = getActivity().getString(R.string.debit);
        }
        int i3 = this.d0;
        if (i3 == 0) {
            this.d0 = 1;
            i3 = 0;
        }
        if (i3 < 0 || this.A.size() <= this.d0) {
            this.d0 = 0;
        } else {
            i2 = i3;
        }
        if (this.A.valueAt(i2)) {
            C4143vg c4143vgA = this.x.getItem(this.A.keyAt(i2));
            this.l = Integer.parseInt(c4143vgA.i());
            if (c4143vgA.h() == null || c4143vgA.h().length() < 3) {
                if (i == 1) {
                    this.a0 = 7;
                } else if (i == 3) {
                    this.a0 = 6;
                }
                this.h.fe(getActivity(), c4143vgA.i(), c4143vgA.j(), c4143vgA.h(), c4143vgA.f(), this.h.y3(c4143vgA.i()), this.h.P4(c4143vgA.i()), this.h.v3(c4143vgA.i()), new F(), this.v);
                try {
                    Looper.loop();
                } catch (RuntimeException unused) {
                }
                if (this.a0 != 0) {
                    new Handler().postDelayed(new G(), 1000L);
                }
                w(1);
                return;
            }
            String str3 = "";
            if (c4143vgA.k() == R.drawable.up) {
                if (i != 1) {
                    if (i == 3) {
                        new Handler().postDelayed(new H(c4143vgA, strIa, strIa3, strIa3, strIa2), this.d0 == 1 ? 0L : Z00.k0 / 20);
                        return;
                    }
                    return;
                }
                Z00 z00 = this.h;
                String strH = c4143vgA.h();
                StringBuilder sb = new StringBuilder();
                if (strIa.length() != 0) {
                    strIa3 = strIa + ":\n" + strIa3;
                }
                sb.append(strIa3);
                sb.append(":");
                sb.append(c4143vgA.a());
                if (Z00.Z) {
                    str2 = "\t" + c4143vgA.b();
                } else {
                    str2 = "";
                }
                sb.append(str2);
                if (strIa2.length() != 0) {
                    str3 = StringUtilities.LF + strIa2;
                }
                sb.append(str3);
                z00.Rc(strH, sb.toString());
                return;
            }
            if (c4143vgA.k() == R.drawable.down) {
                if (i != 1) {
                    if (i == 3) {
                        new Handler().postDelayed(new I(c4143vgA, strIa, strIa4, strIa4, strIa2), this.d0 == 1 ? 0L : Z00.k0 / 20);
                        return;
                    }
                    return;
                }
                Z00 z01 = this.h;
                String strH2 = c4143vgA.h();
                StringBuilder sb2 = new StringBuilder();
                if (strIa.length() != 0) {
                    strIa4 = strIa + ":\n" + strIa4;
                }
                sb2.append(strIa4);
                sb2.append(":");
                sb2.append(c4143vgA.a());
                if (Z00.Z) {
                    str = "\t" + c4143vgA.b();
                } else {
                    str = "";
                }
                sb2.append(str);
                if (strIa2.length() != 0) {
                    str3 = StringUtilities.LF + strIa2;
                }
                sb2.append(str3);
                z01.Rc(strH2, sb2.toString());
            }
        }
    }

    public void add_btn(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.h).l("-9", "new")) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return;
        }
        Log.d("ADD_BTN:", "START");
        if (this.x.b() <= 0) {
            TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.customer_name);
            Intent intent = new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit.class);
            intent.putExtra("CUS_NAME", textView.getText().toString());
            startActivity(intent);
            A0 = this.v.getFirstVisiblePosition();
        }
    }

    public void amount_add_btn(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.h).l("-9", "new")) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return;
        }
        Intent intent = new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit.class);
        intent.putExtra("G_NAME", this.q);
        intent.putExtra("CURR_NAME", this.t);
        intent.putExtra("CUS_TYPE", this.u);
        startActivity(intent);
    }

    public void help_btn(View view) {
        G();
    }

    public void j() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void k() {
        try {
            int iD = C1839c10.d(this.h, false, "bill_total_check_date");
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.bills_tot_support));
            sb.append("(");
            sb.append(this.h.P7(iD + ""));
            sb.append(")");
            String string = sb.toString();
            if (iD > 0) {
                if (C1839c10.J(this.h)) {
                    string = this.h.X4("select group_concat(type_||'{'||bill_no2||'} ',' , ') as _id from bills_tot_issue");
                }
                C1839c10.D(this.h, getActivity(), string, "bill_total_check_date", false, new D());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void l(String str, String str2, String str3, String str4) {
        new ArrayList();
        List listB = ((App) getActivity().getApplication()).b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        Log.d("check_clicked_customer=", str + ":" + str4 + ":" + arrayList.size());
        boolean z2 = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (str.equals(((C4143vg) arrayList.get(i)).j()) && this.t.equals(((C4143vg) arrayList.get(i)).b())) {
                z2 = true;
                break;
            }
        }
        Log.d("clicked_name1=", str + ":" + z2 + ":" + str2 + ":" + str3 + ":" + str4);
        if (z2) {
            return;
        }
        Cursor cursorH4 = this.h.H4(str2, str3, str4);
        arrayList.clear();
        cursorH4.moveToFirst();
        while (!cursorH4.isAfterLast()) {
            arrayList.add(new C4143vg(cursorH4.getString(cursorH4.getColumnIndex(HTML.Attribute.ID)), cursorH4.getString(cursorH4.getColumnIndex("_id")), cursorH4.getString(cursorH4.getColumnIndex(HintConstants.AUTOFILL_HINT_PHONE)), cursorH4.getDouble(cursorH4.getColumnIndex("amount")), this.G[cursorH4.getInt(cursorH4.getColumnIndex("_in"))], 0, cursorH4.getString(cursorH4.getColumnIndex("g_name")), cursorH4.getString(cursorH4.getColumnIndex("curr_name")), cursorH4.getString(cursorH4.getColumnIndex("cnt")), cursorH4.getString(cursorH4.getColumnIndex("cus_type"))));
            cursorH4.moveToNext();
        }
        cursorH4.close();
        ((App) getActivity().getApplication()).d(arrayList);
    }

    public void m() {
        if (!this.h.S() || !this.h.ja("prefOthers_closed_year", false)) {
            C1839c10.z(this.h, Q00.H, "check_items_h_diff:Exit:1");
            return;
        }
        if (!C1839c10.I(this.h) && !C1839c10.J(this.h)) {
            C1839c10.z(this.h, Q00.H, "check_items_h_diff:Exit:2");
            return;
        }
        this.h.v0("create index if not EXISTS bill_tran_h_item_id on bill_transactions_h(item_id);");
        String strX4 = this.h.X4("select ifnull(group_concat(name,' , '),'') as _id\nfrom(\nselect name as name from items a where not EXISTS(select 1 from items_h b where b.id=a.id)\nand EXISTS(select 1 from bill_transactions_h c where c.item_id=a.id)\n)");
        this.h.v0("drop index if  EXISTS bill_tran_h_item_id ;");
        if (strX4.length() > 0) {
            C1839c10.D(this.h, getActivity(), strX4, "", true, null);
        } else {
            C1839c10.z(this.h, Q00.H, "No_Diff_items_h");
        }
    }

    public void move_tr_btn(View view) {
        try {
            if (C2160f10.h > 0 && !new C2160f10(this.h).l("-9", "new")) {
                Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
                return;
            }
            Intent intent = new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit2.class);
            intent.putExtra("G_NAME", this.q);
            intent.putExtra("CURR_NAME", this.t);
            intent.putExtra("screen_main", true);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void n(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        autoCompleteTextView.setText("");
        ListView listView = new ListView(getActivity());
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new C3038c(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            try {
                getActivity();
                if (i2 == -1) {
                    Cursor cursorQuery = getActivity().getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                    this.f0.setText(string);
                    cursorQuery.close();
                    Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.V = activity;
        try {
            this.w0 = (J) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = getArguments() != null ? getArguments().getString("cus_id") : "";
        this.q = getArguments() != null ? getArguments().getString("g_name") : "";
        this.t = getArguments() != null ? getArguments().getString("curr_name") : "";
        this.u = getArguments() != null ? getArguments().getString("cus_type") : "";
        this.n = getArguments() != null ? getArguments().getInt(CSS.Property.POSITION) : -1;
        this.h = new Z00(this.g, getActivity());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4143vg>> onCreateLoader(int i, Bundle bundle) {
        Log.d("trace_S_Loader1=", FragmentStatePagerSupport_Main.X() + ":" + this.t + ":" + this.u + "#" + this.h.ia("db_cus_changed", "0") + ":id=" + i);
        return new C1249ah(getActivity(), this.p, this.t, this.u, this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Log.d("Oncreate:", "Menu_Create");
        menu.clear();
        menuInflater.inflate(R.menu.menu_main3_, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        this.v0 = (SearchView) menuItemFindItem.getActionView();
        this.v0.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        this.v0.setQueryHint(getActivity().getString(R.string.search_hint));
        this.v0.setOnQueryTextListener(new A());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new B());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.U = layoutInflater.inflate(R.layout.content_customer_main_2, viewGroup, false);
            this.h = new Z00(this.g, getActivity());
            this.V = getActivity();
            setHasOptionsMenu(true);
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.j0 = calendar.get(1);
            this.k0 = calendar.get(2);
            this.l0 = calendar.get(5);
            TextView textView = (TextView) this.U.findViewById(R.id.footer_sum);
            this.C = textView;
            textView.setOnClickListener(new ViewOnClickListenerC3036a());
            this.L = getActivity().getString(R.string.footer_null);
            this.M = getActivity().getString(R.string.footer_cus_null);
            this.N = getActivity().getString(R.string.footer_out);
            this.O = getActivity().getString(R.string.footer_in);
            this.Q = getActivity().getString(R.string.footer_filter);
            this.P = getActivity().getString(R.string.tr_bal);
            this.R = getActivity().getString(R.string.tot_radio1);
            this.S = getActivity().getString(R.string.tot_radio2);
            this.v = (ListView) this.U.findViewById(R.id.list_data);
            TextView textView2 = (TextView) this.U.findViewById(R.id.emptyResults);
            this.w = textView2;
            textView2.setText(R.string.wait);
            this.v.setEmptyView(this.w);
            C0870Qv c0870Qv = new C0870Qv(getActivity(), R.layout.customer_row, this.y);
            this.x = c0870Qv;
            this.v.setAdapter((ListAdapter) c0870Qv);
            this.D = (ImageView) this.U.findViewById(R.id.img_help);
            this.E = (ImageView) this.U.findViewById(R.id.img_move_tr);
            this.D.setOnClickListener(this.Z);
            this.E.setOnClickListener(this.Z);
            this.D.setVisibility(8);
            this.E.setVisibility(0);
            ImageView imageView = (ImageView) this.U.findViewById(R.id.img_add_amount);
            this.F = imageView;
            imageView.setOnClickListener(this.Z);
            this.v.setOnItemClickListener(new l());
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.U.findViewById(R.id.activity_main_swipe_refresh_layout);
            this.W = swipeRefreshLayout;
            swipeRefreshLayout.setOnRefreshListener(new m());
            this.v.setChoiceMode(3);
            this.v.setMultiChoiceModeListener(new v());
            try {
                o();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.U;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("OnCreate:", "DestroyView:" + this.p);
        LoaderManager loaderManager = LoaderManager.getInstance(this);
        int i = Integer.parseInt(this.p) * 100;
        loaderManager.destroyLoader(i + 1);
        loaderManager.destroyLoader(i + 2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Log.d("Oncreate:", "onDetach");
        this.V = null;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C4143vg>> loader) {
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.print) {
            j();
            this.x0 = getActivity().getTitle().toString();
            E();
            return true;
        }
        if (itemId == R.id.cus_limit) {
            if (C2160f10.h <= 0 || new C2160f10(this.h).l("31", "view")) {
                startActivity(new Intent(getActivity(), (Class<?>) CusLimit_edit.class));
                return true;
            }
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return true;
        }
        if (itemId == R.id.list) {
            this.w0.onButtonClicked(menuItem);
            return true;
        }
        if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            if (iArr.length == 1 && iArr[0] == 0) {
                p();
                return;
            }
            return;
        }
        if (i == 112 && iArr.length == 1) {
            int i2 = iArr[0];
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        SparseBooleanArray sparseBooleanArray;
        int i;
        super.onResume();
        try {
            if (!FragmentStatePagerSupport_Main.a0 && !Bill_edit.Q2) {
                if (this.x == null || (sparseBooleanArray = this.A) == null || sparseBooleanArray.size() == 0 || this.d0 <= 0 || this.e0 <= 0 || !getUserVisibleHint()) {
                    return;
                }
                SparseBooleanArray sparseBooleanArray2 = this.A;
                if (sparseBooleanArray2 != null && sparseBooleanArray2.size() > this.d0 && this.A.size() != 0 && ((i = this.e0) != 3 || this.d0 <= C2160f10.n)) {
                    I(i);
                    this.d0++;
                    return;
                }
                this.d0 = 0;
                this.e0 = 0;
                return;
            }
            Log.d("Oncreate:", "onResume_refresh");
            FragmentStatePagerSupport_Main.a0 = false;
            Bill_edit.Q2 = false;
            if (getActivity() != null) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                for (int i2 = 0; i2 < childFragmentManager.getFragments().size(); i2++) {
                    FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
                    fragmentTransactionBeginTransaction.remove(childFragmentManager.getFragments().get(i2));
                    fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                }
                getActivity().recreate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.J = Boolean.TRUE;
        Log.d("OnCreate:", "Start:" + this.p + ":" + this.K + ":" + this.J);
        if (this.K.booleanValue() && this.J.booleanValue()) {
            this.T = getActivity();
        }
    }

    public void p() {
        TelephonyManager telephonyManager = (TelephonyManager) getActivity().getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        try {
            String strSubstring = telephonyManager.getDeviceId().substring(0, 14);
            Z00.R = strSubstring;
            Z00.S = AbstractC4032uI.b(strSubstring);
            if (this.h.p3().equals("")) {
                return;
            }
            if (!this.h.p3().equals(Z00.R) && Build.VERSION.SDK_INT >= 23) {
                if (telephonyManager.getPhoneCount() != 2) {
                    return;
                }
                if (telephonyManager.getDeviceId(0).substring(0, 14).equals(this.h.p3())) {
                    String strSubstring2 = telephonyManager.getDeviceId(0).substring(0, 14);
                    Z00.R = strSubstring2;
                    Z00.S = AbstractC4032uI.b(strSubstring2);
                } else if (telephonyManager.getDeviceId(1).substring(0, 14).equals(this.h.p3())) {
                    String strSubstring3 = telephonyManager.getDeviceId(1).substring(0, 14);
                    Z00.R = strSubstring3;
                    Z00.S = AbstractC4032uI.b(strSubstring3);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void q() {
        if (C2160f10.h > 0 && !new C2160f10(this.h).l("-9", "edit")) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.A.size() - 1;
        if (this.A.valueAt(size)) {
            C4143vg c4143vgA = this.x.getItem(this.A.keyAt(size));
            this.l = Integer.parseInt(c4143vgA.i());
            this.h.fe(getActivity(), c4143vgA.i(), c4143vgA.j(), c4143vgA.h(), c4143vgA.f(), this.h.y3(c4143vgA.i()), this.h.P4(c4143vgA.i()), this.h.v3(c4143vgA.i()), new HandlerC3037b(), this.v);
            try {
                Looper.loop();
            } catch (RuntimeException unused) {
            }
            getActivity().recreate();
        }
    }

    public void r(Cursor cursor) {
        cursor.getCount();
        Log.d("cursor_cnt_1=", cursor.getCount() + "");
        this.y.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.y.add(new C4143vg(cursor.getString(cursor.getColumnIndex(HTML.Attribute.ID)), cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex(HintConstants.AUTOFILL_HINT_PHONE)), cursor.getDouble(cursor.getColumnIndex("amount")), this.G[cursor.getInt(cursor.getColumnIndex("_in"))], 0, cursor.getString(cursor.getColumnIndex("g_name")), cursor.getString(cursor.getColumnIndex("curr_name")), cursor.getString(cursor.getColumnIndex("cnt")), cursor.getString(cursor.getColumnIndex("cus_type"))));
            cursor.moveToNext();
        }
        cursor.close();
        if (getActivity() != null) {
            C0870Qv c0870Qv = new C0870Qv(getActivity(), R.layout.customer_row, this.y);
            this.x = c0870Qv;
            this.v.setAdapter((ListAdapter) c0870Qv);
        }
        ((App) getActivity().getApplication()).d(this.y);
        s(this.h.m4(true));
    }

    public void s(Cursor cursor) {
        cursor.getCount();
        this.z.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.z.add(new C0917Sq(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("g_name")), cursor.getString(cursor.getColumnIndex("curr_name")), cursor.getString(cursor.getColumnIndex("cus_type"))));
            cursor.moveToNext();
        }
        cursor.close();
        Bundle bundle = new Bundle();
        this.u0 = bundle;
        bundle.putSerializable("dataGroups", this.z);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && this.p != null && isResumed()) {
            o();
        }
    }

    public void t() {
        try {
            C1044Xj.a().c(new RunnableC1171Zj(13, this.h, this.C, this.p, this.u, this.t, 0, new RunnableC1086Yj()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u(int i) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append("");
        sb.append(i);
        Log.d("Footer_Update=", sb.toString());
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        try {
            if (i == 1) {
                this.C.setText(this.M);
                this.i0 = !Z00.Z ? this.h.f4(this.p, this.u) : this.h.e4(this.p, this.t, this.u);
                TextView textView = this.C;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.N);
                sb2.append(numberFormat.format(Double.parseDouble((String) this.i0.get(0))));
                sb2.append(" ");
                sb2.append(this.O);
                sb2.append(numberFormat.format(Double.parseDouble((String) this.i0.get(1))));
                if (Z00.Z) {
                    str = StringUtilities.LF + this.t;
                }
                sb2.append(str);
                textView.setText(sb2.toString());
                if (this.i0.size() > 1 && Double.parseDouble((String) this.i0.get(0)) == 0.0d) {
                    Double.parseDouble((String) this.i0.get(1));
                }
            } else if (i == 2) {
                double dX = x(this.x.d);
                if (Z00.Z) {
                    this.C.setText(this.Q + numberFormat.format(dX) + " " + this.t);
                } else {
                    this.C.setText(this.Q + numberFormat.format(dX));
                }
            } else if (i == 3) {
                this.C.setText(this.L);
                ArrayList arrayListE4 = this.h.e4(this.p, this.t, this.u);
                if (arrayListE4.size() > 1) {
                    TextView textView2 = this.C;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.N);
                    sb3.append(numberFormat.format(Double.parseDouble((String) arrayListE4.get(0))));
                    sb3.append(" ");
                    sb3.append(this.O);
                    sb3.append(numberFormat.format(Double.parseDouble((String) arrayListE4.get(1))));
                    if (Z00.Z) {
                        str = StringUtilities.LF + this.t;
                    }
                    sb3.append(str);
                    textView2.setText(sb3.toString());
                }
            }
        } catch (Exception unused) {
        }
        t();
    }

    public boolean v(String str, String str2, Context context) {
        s sVar = new s();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getActivity().getString(R.string.confirm_yes), new t(sVar));
        builder.setNegativeButton(getActivity().getString(R.string.confirm_no), new u(sVar));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.g0;
    }

    public void w(int i) {
        Log.d("get_all_names=", ":Called:" + this.p + ":" + this.u + ":" + this.t);
        if (i == 0) {
            r(!Z00.Z ? this.h.D4(this.p, this.u) : this.h.G4(this.p, this.t, this.u));
            this.C.setText(getString(R.string.footer_null));
            u(1);
            return;
        }
        if (i == 1) {
            r(this.h.G4(this.p, this.t, this.u));
            u(3);
            return;
        }
        if (i == 3) {
            boolean zIsEmpty = this.n0.isEmpty();
            String str = CSS.Value.PERCENTAGE;
            this.n0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.n0;
            if (!this.o0.isEmpty()) {
                str = this.o0;
            }
            String str2 = str;
            this.o0 = str2;
            r(!Z00.Z ? this.h.E4(this.p, this.u, this.n0, str2) : this.h.F4(this.p, this.t, this.u, this.n0, str2));
            u(2);
        }
    }

    public double x(List list) {
        double dAbs = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            int i = 0;
            if (((C4143vg) list.get(size)).k() == this.G[0]) {
                i = -1;
            } else if (((C4143vg) list.get(size)).k() == this.G[2]) {
                i = 1;
            }
            if (((C4143vg) list.get(size)).b().equals(this.t)) {
                dAbs += Math.abs(Double.parseDouble(((C4143vg) list.get(size)).a().replaceAll(",", ""))) * ((double) i);
            }
        }
        return dAbs;
    }

    public final void y(String str) {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), (Class<?>) FragmentStatePagerSupport_Main.class);
            intent.putExtra("g_name", str);
            getActivity().finish();
            startActivity(intent);
            return;
        }
        if (this.T != null) {
            Intent intent2 = new Intent(this.T, (Class<?>) FragmentStatePagerSupport_Main.class);
            intent2.putExtra("g_name", str);
            ((FragmentActivity) this.T).finish();
            this.T.startActivity(intent2);
        }
    }

    public final void z(String str, String str2) {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), (Class<?>) FragmentStatePagerSupport.class);
            intent.putExtra("screen_no", "2");
            intent.putExtra("g_name", str);
            intent.putExtra("curr_name", str2);
            intent.putExtra("title_", getActivity().getTitle().toString());
            s(this.h.m4(false));
            intent.putExtras(this.u0);
            getActivity().finish();
            startActivity(intent);
            return;
        }
        if (this.T != null) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) FragmentStatePagerSupport.class);
            intent2.putExtra("screen_no", "2");
            intent2.putExtra("g_name", str);
            intent2.putExtra("curr_name", str2);
            intent2.putExtra("title_", getActivity().getTitle().toString());
            ((FragmentActivity) this.T).finish();
            this.T.startActivity(intent2);
        }
    }

    public e(C0917Sq c0917Sq, int i, int i2, String str, String str2, String str3) {
        Boolean bool = Boolean.FALSE;
        this.J = bool;
        this.K = bool;
        this.U = null;
        this.X = -1;
        this.Y = new ArrayList();
        this.Z = new E();
        this.a0 = 0;
        this.b0 = "";
        this.c0 = "";
        this.d0 = 0;
        this.e0 = 0;
        this.h0 = "";
        this.i0 = new ArrayList();
        this.m0 = 0;
        this.n0 = CSS.Value.PERCENTAGE;
        this.o0 = CSS.Value.PERCENTAGE;
        this.p0 = null;
        this.q0 = null;
        this.s0 = new w();
        this.t0 = new ArrayList();
        this.y0 = true;
        this.z0 = new C();
        Log.d("Frag_CustomerList_2=", "g=" + str + ":curr=" + str2 + ":type=" + str3);
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", c0917Sq.c());
        bundle.putString("cus_name", c0917Sq.e());
        bundle.putInt(CSS.Property.POSITION, i);
        bundle.putInt("size", i2);
        bundle.putString("g_name", str);
        bundle.putString("curr_name", str2);
        bundle.putString("cus_type", str3);
        setArguments(bundle);
    }
}
