package info.aalmoghalis.inventory.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
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
import androidx.appcompat.app.AlertDialog;
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
import androidx.paging.PagingData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C0372Bn;
import defpackage.C0990Vh;
import defpackage.C2160f10;
import defpackage.C3357m10;
import defpackage.C3966tX;
import defpackage.C4064uh;
import defpackage.C4145vh;
import defpackage.C4249x1;
import defpackage.C4279xM;
import defpackage.C4360yM;
import defpackage.DE;
import defpackage.FW;
import defpackage.InterfaceC2295gf;
import defpackage.InterfaceC3750qp;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Daily_Trans_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b, C4279xM.c, DE {
    public static int t0;
    public TextView B;
    public C4360yM C;
    public SparseBooleanArray E;
    public ArrayAdapter F;
    public TextView P;
    public TextView Q;
    public ActionMode T;
    public z U;
    public C0990Vh a0;
    public SQLiteDatabase h;
    public int h0;
    public Z00 i;
    public int i0;
    public String j;
    public int j0;
    public String k;
    public int l;
    public SearchView p0;
    public int n = 0;
    public double p = 0.0d;
    public double q = 0.0d;
    public TextView t = null;
    public AutoCompleteTextView u = null;
    public TextView v = null;
    public SwitchCompat w = null;
    public int x = 0;
    public ImageView y = null;
    public RecyclerView z = null;
    public Toolbar A = null;
    public List D = new ArrayList();
    public ImageButton G = null;
    public AppCompatCheckBox H = null;
    public int I = 0;
    public String[] J = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] K = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView L = null;
    public ImageView M = null;
    public TextView N = null;
    public TextView O = null;
    public TextView R = null;
    public int S = 0;
    public String V = "";
    public Dialog W = null;
    public Handler X = new k();
    public int Y = 0;
    public MutableLiveData Z = new MutableLiveData();
    public int b0 = 0;
    public int c0 = 0;
    public String d0 = "";
    public String e0 = "";
    public Cursor f0 = null;
    public boolean g0 = false;
    public int k0 = 0;
    public String l0 = CSS.Value.PERCENTAGE;
    public String m0 = CSS.Value.PERCENTAGE;
    public TextView n0 = null;
    public TextView o0 = null;
    public final Handler q0 = new Handler(Looper.getMainLooper());
    public DatePickerDialog.OnDateSetListener r0 = new x();
    public DatePickerDialog.OnDateSetListener s0 = new y();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Trans_Report.this.o0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Trans_Report.this.o0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Trans_Report.this.o0(view);
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
                Daily_Trans_Report.this.o0(view);
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
                Daily_Trans_Report.this.o0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public f(TextView textView, ImageView imageView) {
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
                Daily_Trans_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Daily_Trans_Report.this.l = 0;
                Daily_Trans_Report.this.W();
            } catch (Exception unused) {
                Toast.makeText(Daily_Trans_Report.this.getApplicationContext(), Daily_Trans_Report.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public h(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Daily_Trans_Report.this.l = 0;
                    Daily_Trans_Report.this.p0();
                }
            } catch (Exception e) {
                Log.d("delete_err=", e.getMessage());
            }
        }
    }

    public class i implements Observer {
        public i() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List list) {
            Daily_Trans_Report.this.j0(list);
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class k extends Handler {
        public k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Daily_Trans_Report.this.U();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Daily_Trans_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Daily_Trans_Report daily_Trans_Report = Daily_Trans_Report.this;
                sb.append(daily_Trans_Report.i.ic(daily_Trans_Report.e0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Daily_Trans_Report.this.C.notifyDataSetChanged();
                Daily_Trans_Report daily_Trans_Report2 = Daily_Trans_Report.this;
                int i = daily_Trans_Report2.Y;
                if (i == 1) {
                    daily_Trans_Report2.i.ld(daily_Trans_Report2, daily_Trans_Report2.N, daily_Trans_Report2.S);
                } else if (i == 2) {
                    daily_Trans_Report2.i.ld(daily_Trans_Report2, daily_Trans_Report2.O, daily_Trans_Report2.S);
                } else if (i == 3) {
                    daily_Trans_Report2.i.ld(daily_Trans_Report2, daily_Trans_Report2.P, daily_Trans_Report2.S);
                } else if (i == 4) {
                    daily_Trans_Report2.i.ld(daily_Trans_Report2, daily_Trans_Report2.Q, daily_Trans_Report2.S);
                } else if (i == 5) {
                    daily_Trans_Report2.i.ld(daily_Trans_Report2, daily_Trans_Report2.R, daily_Trans_Report2.S);
                }
                Daily_Trans_Report.this.R(-2);
            }
            Daily_Trans_Report.this.n0(false);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Trans_Report daily_Trans_Report = Daily_Trans_Report.this;
            C3357m10 c3357m10 = new C3357m10(daily_Trans_Report, daily_Trans_Report.i);
            Daily_Trans_Report daily_Trans_Report2 = Daily_Trans_Report.this;
            RecyclerView recyclerView = daily_Trans_Report2.z;
            String strIc = daily_Trans_Report2.i.ic(daily_Trans_Report2.e0);
            Daily_Trans_Report daily_Trans_Report3 = Daily_Trans_Report.this;
            c3357m10.m(recyclerView, strIc, daily_Trans_Report3.l0, daily_Trans_Report3.m0);
            Message message = new Message();
            message.obj = "1";
            Daily_Trans_Report.this.X.sendMessage(message);
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ View a;

        public m(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Trans_Report daily_Trans_Report = Daily_Trans_Report.this;
            daily_Trans_Report.D = daily_Trans_Report.C.c();
            Daily_Trans_Report daily_Trans_Report2 = Daily_Trans_Report.this;
            if (daily_Trans_Report2.S == 0) {
                daily_Trans_Report2.S = 1;
            } else {
                daily_Trans_Report2.S = 0;
            }
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    Daily_Trans_Report.this.Y = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Daily_Trans_Report.this.Y = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    Daily_Trans_Report.this.Y = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Daily_Trans_Report.this.Y = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Daily_Trans_Report.this.Y = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "2";
            Daily_Trans_Report.this.X.sendMessage(message);
        }
    }

    public class n extends WebViewClient {
        public n() {
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

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Daily_Trans_Report.this.showDialog(0);
        }
    }

    public class q implements Observer {
        public q() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Double d) {
            if (d.doubleValue() == 0.0d) {
                Daily_Trans_Report.this.L.setVisibility(4);
                return;
            }
            Daily_Trans_Report.this.L.setVisibility(0);
            Daily_Trans_Report daily_Trans_Report = Daily_Trans_Report.this;
            daily_Trans_Report.L.setText(daily_Trans_Report.i.P7(String.valueOf(d)));
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Daily_Trans_Report.this.showDialog(4);
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Daily_Trans_Report.this.k0 = 0;
                dialogInterface.dismiss();
                Daily_Trans_Report.this.R(0);
            } catch (Exception unused) {
            }
        }
    }

    public class u implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public u(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Trans_Report daily_Trans_Report = Daily_Trans_Report.this;
                daily_Trans_Report.k0 = 1;
                if (daily_Trans_Report.n0.getText() == null) {
                    Daily_Trans_Report.this.l0 = "";
                } else {
                    Daily_Trans_Report daily_Trans_Report2 = Daily_Trans_Report.this;
                    daily_Trans_Report2.l0 = daily_Trans_Report2.n0.getText().toString();
                }
                if (Daily_Trans_Report.this.o0.getText() == null) {
                    Daily_Trans_Report.this.m0 = "";
                } else {
                    Daily_Trans_Report daily_Trans_Report3 = Daily_Trans_Report.this;
                    daily_Trans_Report3.m0 = daily_Trans_Report3.o0.getText().toString();
                }
                this.a.dismiss();
                Daily_Trans_Report.this.R(0);
            } catch (Exception unused) {
            }
        }
    }

    public class v implements SearchView.OnQueryTextListener {

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Daily_Trans_Report.this.i0(this.a);
            }
        }

        public v() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                try {
                    Daily_Trans_Report daily_Trans_Report = Daily_Trans_Report.this;
                    if (daily_Trans_Report.c0 == 1) {
                        daily_Trans_Report.c0 = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Daily_Trans_Report.this.c0 = 1;
            }
            Daily_Trans_Report.this.q0.removeCallbacksAndMessages(null);
            Daily_Trans_Report.this.q0.postDelayed(new a(str), new C2160f10().V(str));
            TextUtils.isEmpty(str);
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class w implements MenuItemCompat.OnActionExpandListener {
        public w() {
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            Daily_Trans_Report.this.c0 = 0;
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return true;
        }
    }

    public class x implements DatePickerDialog.OnDateSetListener {
        public x() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Daily_Trans_Report.this.h0 = i;
            Daily_Trans_Report.this.i0 = i2;
            Daily_Trans_Report.this.j0 = i3;
            try {
                String str = Daily_Trans_Report.this.h0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Trans_Report.this.i0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Trans_Report.this.j0));
                Locale locale = Locale.ENGLISH;
                Daily_Trans_Report.this.n0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class y implements DatePickerDialog.OnDateSetListener {
        public y() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Daily_Trans_Report.this.h0 = i;
            Daily_Trans_Report.this.i0 = i2;
            Daily_Trans_Report.this.j0 = i3;
            try {
                String str = Daily_Trans_Report.this.h0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Trans_Report.this.i0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Trans_Report.this.j0));
                Locale locale = Locale.ENGLISH;
                Daily_Trans_Report.this.o0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class z implements ActionMode.Callback {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Daily_Trans_Report.this.S();
                } catch (Exception unused) {
                    Toast.makeText(Daily_Trans_Report.this.getApplicationContext(), "SQL Error.", 1);
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

        public z() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Daily_Trans_Report.this.E = Daily_Trans_Report.this.C.e();
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Daily_Trans_Report.this);
                    builder.setMessage(Daily_Trans_Report.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Daily_Trans_Report.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Daily_Trans_Report.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayE = Daily_Trans_Report.this.C.e();
                    Daily_Trans_Report daily_Trans_Report = Daily_Trans_Report.this;
                    daily_Trans_Report.E = sparseBooleanArrayE;
                    daily_Trans_Report.T();
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
            Daily_Trans_Report.this.z.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Daily_Trans_Report.this.C.k.clear();
            Daily_Trans_Report.this.C.i();
            Daily_Trans_Report.this.T = null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Daily_Trans_Report.this.C.d() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        public /* synthetic */ z(Daily_Trans_Report daily_Trans_Report, i iVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i2) {
        String str;
        this.b0 = i2;
        boolean zIsEmpty = this.l0.isEmpty();
        String str2 = CSS.Value.PERCENTAGE;
        this.l0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.l0;
        if (!this.m0.isEmpty()) {
            str2 = this.m0;
        }
        this.m0 = str2;
        SearchView searchView = this.p0;
        this.d0 = (searchView == null || searchView.getQuery() == null) ? "" : this.p0.getQuery().toString();
        if (b0() && this.k0 == 0) {
            new C3966tX().z(this, this.z, this.B, -2);
        } else if (b0() || this.k0 == 1 || this.b0 > 0) {
            new C3966tX().z(this, this.z, this.B, -1);
        }
        C4360yM c4360yM = this.C;
        if (c4360yM == null || this.k0 == 1) {
            C2160f10.l = 100;
        }
        if (c4360yM == null || this.k0 == 1 || i2 == -2) {
            C4360yM c4360yM2 = new C4360yM(this, R.layout.data_det_row_rep6_2, this.D, 4, Y(), 1, this, this);
            this.C = c4360yM2;
            this.z.setAdapter(c4360yM2.withLoadStateFooter(new C4249x1(new View.OnClickListener() { // from class: oh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.c0(view);
                }
            })));
            this.C.addLoadStateListener(new InterfaceC3750qp() { // from class: ph
                @Override // defpackage.InterfaceC3750qp
                public final Object invoke(Object obj) {
                    return this.a.g0((CombinedLoadStates) obj);
                }
            });
        }
        if (i2 == -1 || ((str = this.d0) != null && str.length() > 0)) {
            this.C.g = this.d0;
        }
        this.a0.e(this, this.j, this.x, this.i, this.l0, this.m0, 12, (i2 > 0 || i2 == -2 || a0()) ? 1 : this.k0, i2, this.c0, this.d0, this.Y, this.S);
        this.a0.d.k(new InterfaceC2295gf() { // from class: qh
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.h0((PagingData) obj);
            }
        });
        if (i2 > 0 || i2 == -2) {
            return;
        }
        this.a0.g(this, this.j, this.x, this.i, this.l0, this.m0, 12, i2 > 0 ? 1 : this.k0, this.c0, this.d0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        this.C.retry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0() {
        this.C.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0() {
        this.z.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FW g0(CombinedLoadStates combinedLoadStates) {
        Log.d("trace_2loadStates:=", this.b0 + ":" + this.k0 + ":" + this.c0 + ":" + combinedLoadStates.getPrepend().toString() + ":" + combinedLoadStates.toString());
        if (combinedLoadStates.getPrepend().getEndOfPaginationReached()) {
            Log.d("trace_2loadStates:=", "END");
            new C3966tX().z(this, this.z, this.B, this.C.c().size());
            j0(null);
            if (a0() || this.b0 == -1) {
                if (this.k0 == 1 || this.b0 <= -1) {
                    if (this.b0 == -1) {
                        new Handler().postDelayed(new Runnable() { // from class: rh
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.d0();
                            }
                        }, 0L);
                    } else {
                        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.z.getLayoutManager();
                        new Handler().postDelayed(new Runnable() { // from class: sh
                            @Override // java.lang.Runnable
                            public final void run() {
                                linearLayoutManager.scrollToPositionWithOffset(0, 0);
                            }
                        }, 0L);
                    }
                }
                if (a0() && this.b0 < 0) {
                    this.i.Kd(this, new C2160f10(this, this.i).P(this.l0, this.m0), 500);
                }
            }
            if (this.b0 == 1) {
                k0();
            }
            if (this.b0 == 0 && this.z.computeVerticalScrollOffset() == 0) {
                new Handler().postDelayed(new Runnable() { // from class: th
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f0();
                    }
                }, 0L);
            }
            this.b0 = 0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(PagingData pagingData) {
        Log.d("trace_2Observer=", "onChanged");
        this.C.submitData(getLifecycle(), pagingData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        W();
        int i2 = this.x;
        if (i2 == 2) {
            this.t.setText(getString(R.string.supp));
            V();
        } else if (i2 == 1) {
            this.t.setText(getString(R.string.cus));
            V();
        }
    }

    public void P() {
        try {
            this.k0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.n0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.o0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.n0.setOnClickListener(new p());
            this.o0.setOnClickListener(new r());
            builder.setPositiveButton(getString(R.string.btn_search), new s());
            builder.setNegativeButton(getString(R.string.btn_cancel), new t());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new u(alertDialogCreate));
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

    public void S() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        if (this.i.ja("prefOthers_closed_year", false)) {
            return;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (this.E.valueAt(size)) {
                C4145vh c4145vh = (C4145vh) this.C.c().get(this.E.keyAt(size));
                this.i.v0("delete from transactions where p_id='" + c4145vh.v() + "' and bill_id=-2 and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0') ='" + c4145vh.e() + "'");
            }
        }
        R(0);
        p0();
        l0(true);
    }

    public void T() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.E.size() - 1;
        if (this.E.valueAt(size)) {
            C4145vh c4145vh = (C4145vh) this.C.c().get(this.E.keyAt(size));
            this.i.r9(c4145vh.v(), c4145vh.n(), c4145vh.e(), this);
        }
    }

    public void U() {
        Z();
    }

    public void V() {
        if (this.w.isChecked()) {
            this.v.setText(getString(R.string.bill_cash));
        } else {
            this.v.setText(getString(R.string.bill_post));
        }
        Cursor cursorX8 = this.i.x8(this.w.isChecked(), this.x);
        this.J = new String[cursorX8.getCount()];
        if (cursorX8.moveToFirst()) {
            int i2 = 0;
            do {
                this.J[i2] = cursorX8.getString(cursorX8.getColumnIndex("_id"));
                i2++;
            } while (cursorX8.moveToNext());
        }
        cursorX8.close();
        this.F = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.J);
        this.u.setThreshold(1);
        this.u.setAdapter(this.F);
    }

    public void W() {
        R(0);
    }

    public void X(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.x));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
        finish();
    }

    public boolean Y() {
        return false;
    }

    public void Z() {
        this.N = (TextView) findViewById(R.id.f1);
        this.O = (TextView) findViewById(R.id.f2);
        this.P = (TextView) findViewById(R.id.f3);
        this.Q = (TextView) findViewById(R.id.f4);
        this.R = (TextView) findViewById(R.id.f5);
        this.N.setText(getString(R.string.daily_tran_no));
        this.O.setText(getString(R.string.date2));
        this.P.setText(getString(R.string.total_sum));
        this.Q.setText(getString(R.string.doc_remarks));
        this.R.setText(getString(R.string.currency));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.N);
        c0372Bn.a(this, this.O);
        c0372Bn.a(this, this.P);
        c0372Bn.a(this, this.Q);
        c0372Bn.a(this, this.R);
        this.i.ld(this, this.O, this.S);
        TextView textView = this.N;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.O;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.P;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.Q;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.R;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.N.setOnClickListener(new a());
        this.O.setOnClickListener(new b());
        this.R.setOnClickListener(new c());
        this.P.setOnClickListener(new d());
        this.Q.setOnClickListener(new e());
    }

    @Override // defpackage.C4279xM.c
    public void a(int i2) {
        if (this.T == null) {
            this.T = startActionMode(this.U);
        }
        this.C.k(i2);
        this.T.invalidate();
        int iD = this.C.d();
        if (iD <= 0) {
            this.T.finish();
            return;
        }
        this.T.setTitle(iD + " Selected");
    }

    public boolean a0() {
        this.l0 = this.l0.isEmpty() ? CSS.Value.PERCENTAGE : this.l0;
        this.m0 = this.m0.isEmpty() ? CSS.Value.PERCENTAGE : this.m0;
        return (this.l0.equals(CSS.Value.PERCENTAGE) && this.m0.equals(CSS.Value.PERCENTAGE)) ? false : true;
    }

    public void add_btn(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "new")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        Intent intent = new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit4.class);
        intent.putExtra("back_edit", 1);
        Z00.E0 = true;
        startActivity(intent);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public boolean b0() {
        SearchView searchView = this.p0;
        return searchView == null || searchView.getQuery() == null || this.p0.getQuery().length() != 0;
    }

    public void btn_add(View view) {
        add_btn(view);
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.V = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_item_remove(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        TextView textView = (TextView) linearLayout.findViewById(R.id.id);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new h(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new j());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        X(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(R.id.page_name);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(R.string.disable) + "#" + ((Object) textView.getText()) + "?");
        }
        builder.setPositiveButton(getString(R.string.confirm_yes), new f(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new g());
        builder.create().show();
    }

    @Override // defpackage.DE
    public void e(int i2, C4145vh c4145vh) {
        this.i.r9(c4145vh.v(), c4145vh.n(), c4145vh.e(), this);
    }

    public void help_btn(View view) {
        m0();
    }

    public void i0(String str) {
        try {
            Log.d("trace_2QueryText2=", "start:" + str);
            if (this.C != null) {
                R(-1);
            }
        } catch (Exception unused) {
        }
    }

    public void j0(List list) {
        this.U = new z(this, null);
    }

    public void k0() {
        n0(true);
        new Thread(new l()).start();
    }

    public void l0(boolean z2) {
    }

    public void m0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new n());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new o());
        builder.show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.V.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.V + "'");
            }
            this.V = "";
            W();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void n0(boolean z2) {
        Log.d("mProgress=", "....start..." + z2);
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z2) {
                android.app.AlertDialog alertDialogCreate = builder.create();
                this.W = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.W;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void no_result_btn(View view) {
        this.k0 = 0;
        W();
    }

    public void o0(View view) {
        n0(true);
        new Thread(new m(view)).start();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_rv_bill4_);
        Z00.E0 = false;
        Z00.F0 = "";
        setTitle(getString(R.string.add_tr_account));
        this.z = (RecyclerView) findViewById(R.id.list_items);
        this.B = (TextView) findViewById(R.id.emptyResults);
        this.z.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.B.setText(getString(R.string.wait));
        this.i = new Z00(this.h, this);
        TextView textView = (TextView) findViewById(R.id.footer_sum);
        this.L = textView;
        textView.setVisibility(4);
        this.M = (ImageView) findViewById(R.id.img_add_amount);
        try {
            Z();
            if (getIntent().getStringExtra("g_id") != null) {
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.h0 = calendar.get(1);
        this.i0 = calendar.get(2);
        this.j0 = calendar.get(5);
        l0(true);
        try {
            C0990Vh c0990Vh = (C0990Vh) ViewModelProviders.of(this).get(C0990Vh.class);
            this.a0 = c0990Vh;
            c0990Vh.a.observe(this, new i());
            this.a0.g.observe(this, new q());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        R(0);
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.r0, this.h0, this.i0, this.j0);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.s0, this.h0, this.i0, this.j0);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        this.p0 = (SearchView) menuItemFindItem.getActionView();
        this.p0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.p0.setQueryHint(getString(R.string.search_hint));
        this.p0.setOnQueryTextListener(new v());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new w());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        l0(true);
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
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.e0 = getTitle().toString();
        if (Build.VERSION.SDK_INT < 31) {
            Q();
        }
        if (a0()) {
            k0();
        } else {
            R(1);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            R(0);
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // defpackage.DE
    public void c(int i2, C4064uh c4064uh) {
    }
}
