package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C0990Vh;
import defpackage.C2160f10;
import defpackage.C3357m10;
import defpackage.C3966tX;
import defpackage.C4064uh;
import defpackage.C4145vh;
import defpackage.C4249x1;
import defpackage.C4279xM;
import defpackage.DE;
import defpackage.FW;
import defpackage.InterfaceC2295gf;
import defpackage.InterfaceC3750qp;
import defpackage.W7;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.printBT.MainActivity;
import info.aalmoghalis.inventory.printBT.MainActivity2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Bills2 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, a.b, C4279xM.c, DE {
    public static int w0 = 0;
    public static String x0 = "%";
    public static String y0 = "%";
    public C4279xM B;
    public SparseBooleanArray D;
    public ArrayAdapter E;
    public InterfaceC3750qp N;
    public TextView Q;
    public TextView R;
    public TextView S;
    public ActionMode W;
    public C X;
    public ProgressDialog Z;
    public C0990Vh c0;
    public SQLiteDatabase h;
    public int h0;
    public Z00 i;
    public int i0;
    public String j;
    public int j0;
    public String k;
    public int l;
    public SearchView p0;
    public TextView z;
    public int n = 0;
    public double p = 0.0d;
    public TextView q = null;
    public AutoCompleteTextView t = null;
    public TextView u = null;
    public SwitchCompat v = null;
    public int w = 0;
    public ImageView x = null;
    public RecyclerView y = null;
    public Toolbar A = null;
    public List C = new ArrayList();
    public ImageButton F = null;
    public AppCompatCheckBox G = null;
    public int H = 0;
    public String[] I = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] J = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView K = null;
    public int L = 0;
    public int M = 0;
    public TextView O = null;
    public TextView P = null;
    public TextView T = null;
    public int U = 0;
    public int V = 0;
    public String Y = "";
    public Handler a0 = new m();
    public MutableLiveData b0 = new MutableLiveData();
    public int d0 = 0;
    public int e0 = 0;
    public String f0 = "";
    public Cursor g0 = null;
    public int k0 = 0;
    public String l0 = CSS.Value.PERCENTAGE;
    public String m0 = CSS.Value.PERCENTAGE;
    public TextView n0 = null;
    public TextView o0 = null;
    public String q0 = "";
    public final Handler r0 = new Handler(Looper.getMainLooper());
    public DatePickerDialog.OnDateSetListener s0 = new z();
    public DatePickerDialog.OnDateSetListener t0 = new A();
    public String u0 = "";
    public final BroadcastReceiver v0 = new B();

    public class A implements DatePickerDialog.OnDateSetListener {
        public A() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bills2.this.h0 = i;
            Bills2.this.i0 = i2;
            Bills2.this.j0 = i3;
            try {
                String str = Bills2.this.h0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills2.this.i0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills2.this.j0));
                Locale locale = Locale.ENGLISH;
                Bills2.this.o0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class B extends BroadcastReceiver {
        public B() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bills2.this.S(0);
        }
    }

    public class C implements ActionMode.Callback {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Bills2.this.T();
                } catch (Exception unused) {
                    Toast.makeText(Bills2.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Bills2.this.D = Bills2.this.B.e();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Bills2.this);
                    builder.setMessage(Bills2.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Bills2.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Bills2.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayE = Bills2.this.B.e();
                    Bills2 bills2 = Bills2.this;
                    bills2.D = sparseBooleanArrayE;
                    bills2.U();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Bills2.this.y.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Bills2.this.B.k.clear();
            Bills2.this.B.j();
            Bills2.this.W = null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Bills2.this.B.d() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        public /* synthetic */ C(Bills2 bills2, i iVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills2$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2679a implements View.OnClickListener {
        public ViewOnClickListenerC2679a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills2.this.r0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills2$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2680b implements View.OnClickListener {
        public ViewOnClickListenerC2680b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills2.this.r0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills2$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2681c implements View.OnClickListener {
        public ViewOnClickListenerC2681c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills2.this.r0(view);
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
                Bills2.this.r0(view);
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
                Bills2.this.r0(view);
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
                Bills2.this.r0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ View a;

        public g(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bills2 bills2 = Bills2.this;
            bills2.C = bills2.B.c();
            Bills2 bills3 = Bills2.this;
            if (bills3.V == 0) {
                bills3.V = 1;
            } else {
                bills3.V = 0;
            }
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    Bills2.this.U = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Bills2.this.U = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    Bills2.this.U = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Bills2.this.U = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Bills2.this.U = 5;
                    break;
                case R.id.f6 /* 2131296729 */:
                    Bills2.this.U = 4;
                    break;
            }
            Message message = new Message();
            message.obj = "2";
            Bills2.this.a0.sendMessage(message);
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public h(TextView textView, ImageView imageView) {
            this.a = textView;
            this.b = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ImageView imageView;
            try {
                if (this.a == null || (imageView = this.b) == null) {
                    return;
                }
                String str = Integer.parseInt(imageView.getTag().toString()) == 17301515 ? "1" : "0";
                Bills2.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Bills2.this.l = 0;
                Bills2.this.X();
            } catch (Exception unused) {
                Toast.makeText(Bills2.this.getApplicationContext(), Bills2.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class i implements Observer {
        public i() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Double d) {
            if (d.doubleValue() != 0.0d) {
                Bills2 bills2 = Bills2.this;
                bills2.K.setText(bills2.i.P7(String.valueOf(d)));
            }
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public k(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Bills2.this.l = 0;
                    Bills2.this.X();
                }
            } catch (Exception e) {
                Log.d("delete_err=", e.getMessage());
            }
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class m extends Handler {
        public m() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            Bills2.this.q0(false);
            if (message.obj.toString().equals("0")) {
                Bills2 bills2 = Bills2.this;
                bills2.V(bills2.g0);
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = Bills2.this.i;
                StringBuilder sb = new StringBuilder();
                Bills2 bills3 = Bills2.this;
                sb.append(bills3.i.ic(bills3.q0));
                sb.append(".pdf");
                z00.ra(sb.toString());
                return;
            }
            if (!message.obj.toString().equals("2")) {
                if (message.obj.toString().equals("3")) {
                    Z00 z01 = Bills2.this.i;
                    StringBuilder sb2 = new StringBuilder();
                    Bills2 bills4 = Bills2.this;
                    sb2.append(bills4.i.ic(bills4.q0));
                    sb2.append(".xls");
                    z01.pa(sb2.toString());
                    return;
                }
                return;
            }
            Bills2.this.B.notifyDataSetChanged();
            Bills2 bills5 = Bills2.this;
            bills5.i.lc(bills5, bills5.O, bills5.P, bills5.Q, bills5.R, bills5.S, bills5.T);
            Bills2 bills6 = Bills2.this;
            int i = bills6.U;
            if (i == 1) {
                bills6.i.ld(bills6, bills6.O, bills6.V);
            } else if (i == 2) {
                bills6.i.ld(bills6, bills6.P, bills6.V);
            } else if (i == 3) {
                bills6.i.ld(bills6, bills6.Q, bills6.V);
            } else if (i == 4) {
                bills6.i.ld(bills6, bills6.R, bills6.V);
            } else if (i == 5) {
                bills6.i.ld(bills6, bills6.S, bills6.V);
            } else if (i == 6) {
                bills6.i.ld(bills6, bills6.T, bills6.V);
            }
            Bills2.this.S(-2);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bills2.this.W();
            Message message = new Message();
            message.obj = "0";
            Bills2.this.a0.sendMessage(message);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Bills2 bills2 = Bills2.this;
            C3357m10 c3357m10 = new C3357m10(bills2, bills2.i);
            Bills2 bills3 = Bills2.this;
            RecyclerView recyclerView = bills3.y;
            String strIc = bills3.i.ic(bills3.q0);
            Bills2 bills4 = Bills2.this;
            c3357m10.i(recyclerView, strIc, bills4.l0, bills4.m0);
            Message message = new Message();
            message.obj = "1";
            Bills2.this.a0.sendMessage(message);
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.obj = "1";
            Bills2 bills2 = Bills2.this;
            bills2.q0 = bills2.i.ic(bills2.q0);
            if (Bills2.this.i.ia("PREF_ACCOUNT_NAME", "###").equals("m733439928@gmail.com")) {
                message.obj = "3";
            } else {
                Bills2 bills3 = Bills2.this;
                C3357m10 c3357m10 = new C3357m10(bills3, bills3.i);
                Bills2 bills4 = Bills2.this;
                c3357m10.j(bills4.y, bills4.q0, bills4.l0, bills4.m0, bills4.w);
            }
            Bills2.this.a0.sendMessage(message);
        }
    }

    public class q extends WebViewClient {
        public q() {
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

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bills2.this.showDialog(0);
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bills2.this.showDialog(4);
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
        public v() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bills2 bills2 = Bills2.this;
                bills2.k0 = 0;
                bills2.S(0);
            } catch (Exception unused) {
            }
        }
    }

    public class w implements View.OnClickListener {
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public w(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills2 bills2 = Bills2.this;
                bills2.k0 = 1;
                if (bills2.n0.getText() == null) {
                    Bills2.this.l0 = "";
                } else {
                    Bills2 bills3 = Bills2.this;
                    bills3.l0 = bills3.n0.getText().toString();
                }
                if (Bills2.this.o0.getText() == null) {
                    Bills2.this.m0 = "";
                } else {
                    Bills2 bills4 = Bills2.this;
                    bills4.m0 = bills4.o0.getText().toString();
                }
                Bills2.this.S(-3);
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class x implements SearchView.OnQueryTextListener {

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bills2.this.k0(this.a);
            }
        }

        public x() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                try {
                    Bills2 bills2 = Bills2.this;
                    if (bills2.e0 == 1) {
                        bills2.e0 = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Bills2.this.e0 = 1;
            }
            Bills2.this.r0.removeCallbacksAndMessages(null);
            Bills2.this.r0.postDelayed(new a(str), new C2160f10().V(str));
            TextUtils.isEmpty(str);
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class y implements MenuItemCompat.OnActionExpandListener {
        public y() {
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            Bills2.this.e0 = 0;
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return true;
        }
    }

    public class z implements DatePickerDialog.OnDateSetListener {
        public z() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bills2.this.h0 = i;
            Bills2.this.i0 = i2;
            Bills2.this.j0 = i3;
            try {
                String str = Bills2.this.h0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills2.this.i0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills2.this.j0));
                Locale locale = Locale.ENGLISH;
                Bills2.this.n0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i2) {
        int i3;
        String str;
        this.d0 = i2;
        boolean zIsEmpty = this.l0.isEmpty();
        String str2 = CSS.Value.PERCENTAGE;
        this.l0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.l0;
        if (!this.m0.isEmpty()) {
            str2 = this.m0;
        }
        this.m0 = str2;
        SearchView searchView = this.p0;
        this.f0 = (searchView == null || searchView.getQuery() == null) ? "" : this.p0.getQuery().toString();
        if (d0() && this.k0 == 0) {
            new C3966tX().z(this, this.y, this.z, -2);
        } else if (d0() || this.k0 == 1 || (i3 = this.d0) > 0 || i3 == -2) {
            new C3966tX().z(this, this.y, this.z, -1);
        }
        C4279xM c4279xM = this.B;
        if (c4279xM == null || this.k0 == 1 || i2 == -1) {
            C2160f10.l = 100;
        }
        if (c4279xM == null || this.k0 == 1 || i2 == -2) {
            if (c4279xM == null) {
                C4279xM c4279xM2 = new C4279xM(this, R.layout.data_det_row_rep6_2, this.C, 19, Z(), a0(), 4, this, this);
                this.B = c4279xM2;
                this.y.setAdapter(c4279xM2.withLoadStateFooter(new C4249x1(new View.OnClickListener() { // from class: Q7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.e0(view);
                    }
                })));
            }
            this.B.removeLoadStateListener(this.N);
            this.B.addLoadStateListener(this.N);
        }
        if (i2 == -1 || ((str = this.f0) != null && str.length() > 0)) {
            this.B.g = this.f0;
        }
        this.c0.e(this, this.j, this.w, this.i, this.l0, this.m0, 10, (i2 > 0 || i2 == -2 || c0()) ? 1 : this.k0, i2, this.e0, this.f0, this.U, this.V);
        this.c0.d.k(new InterfaceC2295gf() { // from class: R7
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.f0((PagingData) obj);
            }
        });
        if (i2 > 0 || i2 == -2) {
            return;
        }
        this.c0.g(this, this.j, this.w, this.i, this.l0, this.m0, 10, i2 > 0 ? 1 : this.k0, this.e0, this.f0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(PagingData pagingData) {
        Log.d("trace_2Observer=", "onChanged");
        this.B.submitData(getLifecycle(), pagingData);
    }

    public void P() {
        try {
            this.k0 = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.n0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.o0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.n0.setOnClickListener(new s());
            this.o0.setOnClickListener(new t());
            builder.setPositiveButton(getString(R.string.btn_search), new u());
            builder.setNegativeButton(getString(R.string.btn_cancel), new v());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new w(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void Q() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void R() {
        try {
            Log.d("lv_pos=", w0 + ":" + Z00.F0 + ":" + x0 + ":" + y0);
            if (w0 <= 0) {
                w0 = 0;
            } else {
                w0 = 0;
            }
        } catch (Exception e2) {
            w0 = 0;
            e2.printStackTrace();
        }
    }

    public void T() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.w == 1 ? "-6" : "-7", HTML.Tag.DEL)) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        for (int size = this.D.size() - 1; size >= 0; size--) {
            if (this.D.valueAt(size)) {
                C4145vh c4145vh = (C4145vh) this.B.c().get(this.D.keyAt(size));
                if (this.w == 1) {
                    if (!info.aalmoghalis.inventory.zatca.d.g(this, this.i, W7.b(this.i.a, Long.parseLong(c4145vh.v())))) {
                        Toast.makeText(this, "QR", 0).show();
                        return;
                    }
                }
                this.i.H("delete from bill_transactions where bill_id='" + c4145vh.v() + "' and exists(select * from bills a where a.id=bill_transactions.bill_id and a.date_='" + c4145vh.n() + "' and tr_type=" + this.w + ")", "delete from bills where id ='" + c4145vh.v() + "' and date_='" + c4145vh.n() + "'");
            }
        }
        S(0);
        o0(true);
    }

    public void U() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.w == 1 ? "-6" : "-7", "edit")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        int size = this.D.size() - 1;
        if (this.D.valueAt(size)) {
            C4145vh c4145vh = (C4145vh) this.B.c().get(this.D.keyAt(size));
            this.i.o9(c4145vh.v(), c4145vh.n(), this, 0, false);
        }
    }

    public void V(Cursor cursor) {
        b0();
        cursor.getCount();
        this.p = 0.0d;
        this.C.clear();
        cursor.moveToFirst();
        C0566Hd c0566Hd = new C0566Hd();
        while (!cursor.isAfterLast()) {
            this.p += cursor.getDouble(c0566Hd.b(cursor, "f13"));
            this.C.add(new C4145vh(cursor.getString(c0566Hd.b(cursor, "_id")), cursor.getString(c0566Hd.b(cursor, "f10")), cursor.getString(c0566Hd.b(cursor, "f1")), cursor.getString(c0566Hd.b(cursor, "f5")), cursor.getString(c0566Hd.b(cursor, "f7")), "" + cursor.getDouble(c0566Hd.b(cursor, "f3")), cursor.getString(c0566Hd.b(cursor, "f9")), cursor.getString(c0566Hd.b(cursor, "f2")), cursor.getString(c0566Hd.b(cursor, "f8")), cursor.getString(c0566Hd.b(cursor, "f4")), cursor.getString(c0566Hd.b(cursor, "f6")), cursor.getString(c0566Hd.b(cursor, "f11")), cursor.getString(c0566Hd.b(cursor, "f12")), cursor.getString(c0566Hd.b(cursor, "f13")), cursor.getString(c0566Hd.b(cursor, "f14")), cursor.getString(c0566Hd.b(cursor, "f15")), cursor.getString(c0566Hd.b(cursor, "f16")), cursor.getString(c0566Hd.b(cursor, "f17")), cursor.getString(c0566Hd.b(cursor, "f18")), cursor.getString(c0566Hd.b(cursor, "f19"))));
            cursor.moveToNext();
        }
        cursor.close();
        if (this.B == null) {
            Log.d("listviewadapter=", "null");
            C4279xM c4279xM = new C4279xM(this, R.layout.data_det_row_rep6_2, this.C, 19, Z(), a0(), 4, this, this);
            this.B = c4279xM;
            c4279xM.k.clear();
            this.B.notifyDataSetChanged();
            this.y.setAdapter(this.B);
        } else {
            Log.d("listviewadapter=", "not_null");
            this.B.notifyDataSetChanged();
        }
        this.K.setText(this.i.P7(String.valueOf(this.p)));
        R();
    }

    public void W() {
        int i2 = this.k0;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            Z00 z00 = this.i;
            if (!this.j.equals("0")) {
                str = this.j;
            }
            this.g0 = z00.h2(str, this.w, 2, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, -1, -1, 0, "");
            return;
        }
        this.l0 = this.l0.isEmpty() ? CSS.Value.PERCENTAGE : this.l0;
        this.m0 = this.m0.isEmpty() ? CSS.Value.PERCENTAGE : this.m0;
        Z00 z01 = this.i;
        if (!this.j.equals("0")) {
            str = this.j;
        }
        this.g0 = z01.h2(str, this.w, 2, this.l0, this.m0, CSS.Value.PERCENTAGE, -1, -1, 0, "");
    }

    public void X() {
        q0(true);
        new Thread(new n()).start();
    }

    public void Y(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.w));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("is_back", this.i.e2(str));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public boolean Z() {
        return this.L <= 1;
    }

    @Override // defpackage.C4279xM.c
    public void a(int i2) {
        if (this.W == null) {
            this.W = startActionMode(this.X);
        }
        this.B.m(i2);
        this.W.invalidate();
        int iD = this.B.d();
        if (iD <= 0) {
            this.W.finish();
            return;
        }
        this.W.setTitle(iD + " Selected");
    }

    public boolean a0() {
        return this.M <= 1;
    }

    public void add_btn(View view) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.w == 1 ? "-6" : "-7", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        int i2 = this.w;
        Intent intent = new Intent(this, (Class<?>) ((i2 == 1 || i2 == 2) ? Bill_edit.class : Bill_move.class));
        intent.putExtra("TR_TYPE", String.valueOf(this.w));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        intent.putExtra("back_edit", 1);
        Z00.E0 = true;
        startActivity(intent);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public void b0() {
        float f2;
        this.O = (TextView) findViewById(R.id.f1);
        this.P = (TextView) findViewById(R.id.f2);
        this.Q = (TextView) findViewById(R.id.f3);
        this.R = (TextView) findViewById(R.id.f4);
        this.S = (TextView) findViewById(R.id.f5);
        this.T = (TextView) findViewById(R.id.f6);
        this.O.setText(getString(R.string.doc_no_2));
        this.P.setText(getString(R.string.date));
        this.Q.setText(getString(R.string.name));
        TextView textView = this.O;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.P;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.Q;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.R;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.S;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        TextView textView6 = this.T;
        textView6.setPaintFlags(textView6.getPaintFlags() | 8);
        this.i.ld(this, this.P, this.V);
        this.R.setText(getString(R.string.branch));
        this.S.setText(getString(R.string.tr_amount));
        this.T.setText(getString(R.string.currency));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.O);
        c0372Bn.a(this, this.P);
        c0372Bn.a(this, this.Q);
        c0372Bn.a(this, this.R);
        c0372Bn.a(this, this.S);
        c0372Bn.a(this, this.T);
        this.O.setOnClickListener(new ViewOnClickListenerC2679a());
        this.P.setOnClickListener(new ViewOnClickListenerC2680b());
        this.Q.setOnClickListener(new ViewOnClickListenerC2681c());
        this.R.setOnClickListener(new d());
        this.S.setOnClickListener(new e());
        this.T.setOnClickListener(new f());
        if (Z()) {
            this.R.setVisibility(8);
            f2 = 43.0f;
        } else {
            f2 = 25.0f;
        }
        if (a0()) {
            this.T.setVisibility(8);
            f2 += 15.0f;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Q.getLayoutParams();
        layoutParams.weight = f2;
        this.Q.setLayoutParams(layoutParams);
    }

    public void btn_add(View view) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.Y = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_item_remove(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        TextView textView = (TextView) linearLayout.findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new k(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new l());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        Y(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(R.id.page_name);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(R.string.disable) + "#" + ((Object) textView.getText()) + "?");
        }
        builder.setPositiveButton(getString(R.string.confirm_yes), new h(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new j());
        builder.create().show();
    }

    public boolean c0() {
        this.l0 = this.l0.isEmpty() ? CSS.Value.PERCENTAGE : this.l0;
        this.m0 = this.m0.isEmpty() ? CSS.Value.PERCENTAGE : this.m0;
        return (this.l0.equals(CSS.Value.PERCENTAGE) && this.m0.equals(CSS.Value.PERCENTAGE)) ? false : true;
    }

    public boolean d0() {
        SearchView searchView = this.p0;
        return searchView == null || searchView.getQuery() == null || this.p0.getQuery().length() != 0;
    }

    @Override // defpackage.DE
    public void e(int i2, C4145vh c4145vh) {
        x0 = this.l0;
        y0 = this.m0;
        Z00.F0 = this.p0.getQuery() != null ? this.p0.getQuery().toString() : "";
        this.i.o9(c4145vh.v(), c4145vh.n(), this, 1, false);
    }

    public final /* synthetic */ void e0(View view) {
        this.B.retry();
    }

    public final /* synthetic */ void g0() {
        this.B.notifyDataSetChanged();
    }

    public final /* synthetic */ void h0() {
        this.y.scrollToPosition(0);
    }

    public void help_btn(View view) {
        p0();
    }

    public final /* synthetic */ void i0() {
        this.y.scrollToPosition(0);
    }

    public final /* synthetic */ FW j0(CombinedLoadStates combinedLoadStates) {
        int i2;
        Log.d("trace_2loadStates:=", "do_action=" + this.d0 + ":adv=" + this.k0 + ":query_flag=" + this.e0 + ":topOffset=" + this.y.computeVerticalScrollOffset() + ":" + this.y.computeVerticalScrollOffset() + ":is_adv=" + c0() + ":" + combinedLoadStates.getPrepend().toString() + ":" + combinedLoadStates.toString());
        if ((combinedLoadStates.getPrepend() instanceof LoadState.NotLoading) && combinedLoadStates.getPrepend().getEndOfPaginationReached()) {
            Log.d("trace_2loadStates:=", "END");
            int size = this.B.c().size();
            Log.d("trace_2loadStates:=", "END:" + size + ":" + C2160f10.l);
            new C3966tX().z(this, this.y, this.z, size);
            l0(null);
            if (c0() || (i2 = this.d0) == -1 || i2 == -2) {
                if (this.d0 == -1 || (c0() && this.d0 == 0)) {
                    new Handler().postDelayed(new Runnable() { // from class: T7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.g0();
                        }
                    }, 0L);
                } else {
                    new Handler().postDelayed(new Runnable() { // from class: U7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.h0();
                        }
                    }, 0L);
                }
                if (c0() && this.d0 < 0) {
                    this.i.Kd(this, new C2160f10(this, this.i).P(this.l0, this.m0), 500);
                }
            }
            int i3 = this.d0;
            if (i3 == 1) {
                n0();
            } else if (i3 == 2) {
                m0();
            }
            if (this.d0 == 0 && this.y.computeVerticalScrollOffset() == 0) {
                new Handler().postDelayed(new Runnable() { // from class: V7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.i0();
                    }
                }, 0L);
            }
            this.d0 = 0;
        }
        return FW.a;
    }

    public void k0(String str) {
        try {
            Log.d("trace_2QueryText2=", "start:" + str);
            if (this.B != null) {
                S(-1);
            }
        } catch (Exception unused) {
        }
    }

    public void l0(List list) {
        Log.d("Trace_E_Bill2_loader=", FragmentStatePagerSupport_Main.X() + "#" + this.j + ":" + this.l0 + ":" + this.m0);
        if (this.X == null) {
            b0();
            this.X = new C(this, null);
        }
    }

    public void m0() {
        q0(true);
        new Thread(new p()).start();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.Y.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.Y + "'");
            }
            this.Y = "";
            X();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void n0() {
        q0(true);
        new Thread(new o()).start();
    }

    public void no_result_btn(View view) {
        this.k0 = 0;
        X();
    }

    public void o0(boolean z2) {
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Log.d("onback=", isTaskRoot() + "");
        if (isTaskRoot()) {
            y();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_rv_bill3_);
        Z00.E0 = false;
        Z00.F0 = "";
        this.y = (RecyclerView) findViewById(R.id.list_items);
        TextView textView = (TextView) findViewById(R.id.emptyResults);
        this.z = textView;
        textView.setText(getString(R.string.wait));
        this.y.setLayoutManager(new LinearLayoutManager(this, 1, false));
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        this.L = z00.F2();
        this.K = (TextView) findViewById(R.id.footer_sum);
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.w = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getResources().getStringArray(R.array.titles_main)[this.w - 1]);
            }
        } catch (Exception unused) {
        }
        this.M = this.i.f3(this.w);
        b0();
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.h0 = calendar.get(1);
        this.i0 = calendar.get(2);
        this.j0 = calendar.get(5);
        this.E = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.I);
        o0(true);
        try {
            this.N = new InterfaceC3750qp() { // from class: S7
                @Override // defpackage.InterfaceC3750qp
                public final Object invoke(Object obj) {
                    return this.a.j0((CombinedLoadStates) obj);
                }
            };
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            C0990Vh c0990Vh = (C0990Vh) ViewModelProviders.of(this).get(C0990Vh.class);
            this.c0 = c0990Vh;
            c0990Vh.g.observe(this, new i());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        S(0);
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.s0, this.h0, this.i0, this.j0);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.t0, this.h0, this.i0, this.j0);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("oncreate:", "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.menu_main3_group, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        this.p0 = (SearchView) MenuItemCompat.getActionView(menuItemFindItem);
        this.p0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.p0.setQueryHint(getString(R.string.search_hint));
        this.p0.setOnQueryTextListener(null);
        this.p0.setOnQueryTextListener(new x());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new y());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Log.d("oncreate=", "onDestroy...");
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        V(this.i.L2());
        o0(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.adv_search) {
            P();
            return true;
        }
        if (menuItem.getItemId() == R.id.print) {
            this.q0 = getTitle().toString();
            if (Build.VERSION.SDK_INT < 31) {
                Q();
            }
            if (c0()) {
                n0();
            } else {
                S(1);
            }
            return true;
        }
        if (menuItem.getItemId() == R.id.action_print_bills) {
            this.q0 = getTitle().toString();
            if (Build.VERSION.SDK_INT < 31) {
                Q();
            }
            if (c0()) {
                m0();
            } else {
                S(2);
            }
            return true;
        }
        if (menuItem.getItemId() != R.id.action_print_bills_thermal) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(this, (Class<?>) (this.i.ja("prefThermalBluetooth", true) ? MainActivity.class : MainActivity2.class));
        Z00.j0.clear();
        List listC = ((C4279xM) ((ConcatAdapter) this.y.getAdapter()).getAdapters().get(0)).c();
        for (int i2 = 0; i2 < listC.size(); i2++) {
            Z00.j0.add(new String[]{((C4145vh) listC.get(i2)).v(), ((C4145vh) listC.get(i2)).n()});
        }
        startActivity(intent);
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        Log.d("oncreate=", "onRestart...");
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d("Oncreate:", "onResume:" + Bill_edit.P2 + ":do_action=" + this.d0);
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            Bill_edit.Q2 = false;
            S(0);
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Log.d("oncreate=", "onStart...");
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("ACTION_INVOICE_UPDATED");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.v0, intentFilter, 4);
        } else {
            registerReceiver(this.v0, intentFilter);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Log.d("oncreate=", "onStop...");
        super.onStop();
        unregisterReceiver(this.v0);
    }

    public void p0() {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new q());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new r());
        builder.show();
    }

    public void q0(boolean z2) {
        try {
            if (z2) {
                ProgressDialog progressDialog = new ProgressDialog(this);
                this.Z = progressDialog;
                progressDialog.setMessage(getString(R.string.google_drive_list));
                this.Z.show();
            } else {
                this.Z.hide();
            }
            this.Z.dismiss();
        } catch (Exception unused) {
        }
    }

    public void r0(View view) {
        q0(true);
        new Thread(new g(view)).start();
    }

    @Override // defpackage.DE
    public void c(int i2, C4064uh c4064uh) {
    }
}
