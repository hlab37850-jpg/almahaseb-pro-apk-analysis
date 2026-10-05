package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
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
import defpackage.C0566Hd;
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
public class Daily_Doc_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, a.b, C4279xM.c, DE {
    public static int u0;
    public TextView B;
    public C4360yM C;
    public SparseBooleanArray E;
    public ArrayAdapter F;
    public TextView R;
    public ActionMode U;
    public B V;
    public C0990Vh b0;
    public SQLiteDatabase h;
    public Z00 i;
    public int i0;
    public String j;
    public int j0;
    public String k;
    public int k0;
    public int l;
    public SearchView q0;
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
    public TextView M = null;
    public ImageView N = null;
    public TextView O = null;
    public TextView P = null;
    public TextView Q = null;
    public TextView S = null;
    public int T = 0;
    public String W = "";
    public Dialog X = null;
    public Handler Y = new i();
    public int Z = 0;
    public MutableLiveData a0 = new MutableLiveData();
    public int c0 = 0;
    public int d0 = 0;
    public String e0 = "";
    public String f0 = "";
    public Cursor g0 = null;
    public boolean h0 = false;
    public int l0 = 0;
    public String m0 = CSS.Value.PERCENTAGE;
    public String n0 = CSS.Value.PERCENTAGE;
    public TextView o0 = null;
    public TextView p0 = null;
    public final Handler r0 = new Handler(Looper.getMainLooper());
    public DatePickerDialog.OnDateSetListener s0 = new z();
    public DatePickerDialog.OnDateSetListener t0 = new A();

    public class A implements DatePickerDialog.OnDateSetListener {
        public A() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Daily_Doc_Report.this.i0 = i;
            Daily_Doc_Report.this.j0 = i2;
            Daily_Doc_Report.this.k0 = i3;
            try {
                String str = Daily_Doc_Report.this.i0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Doc_Report.this.j0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Doc_Report.this.k0));
                Locale locale = Locale.ENGLISH;
                Daily_Doc_Report.this.p0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class B implements ActionMode.Callback {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Daily_Doc_Report.this.S();
                } catch (Exception unused) {
                    Toast.makeText(Daily_Doc_Report.this.getApplicationContext(), "SQL Error.", 1);
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

        public B() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Daily_Doc_Report.this.E = Daily_Doc_Report.this.C.e();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Daily_Doc_Report.this);
                    builder.setMessage(Daily_Doc_Report.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Daily_Doc_Report.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Daily_Doc_Report.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayE = Daily_Doc_Report.this.C.e();
                    Daily_Doc_Report daily_Doc_Report = Daily_Doc_Report.this;
                    daily_Doc_Report.E = sparseBooleanArrayE;
                    daily_Doc_Report.T();
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
            Daily_Doc_Report.this.z.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Daily_Doc_Report.this.C.k.clear();
            Daily_Doc_Report.this.C.i();
            Daily_Doc_Report.this.U = null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Daily_Doc_Report.this.C.d() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        public /* synthetic */ B(Daily_Doc_Report daily_Doc_Report, h hVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Doc_Report$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2885a implements View.OnClickListener {
        public ViewOnClickListenerC2885a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Doc_Report.this.p0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Doc_Report$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2886b implements View.OnClickListener {
        public ViewOnClickListenerC2886b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Doc_Report.this.p0(view);
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
                Daily_Doc_Report.this.p0(view);
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
                Daily_Doc_Report.this.p0(view);
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
                Daily_Doc_Report.this.p0(view);
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
                Daily_Doc_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Daily_Doc_Report.this.l = 0;
                Daily_Doc_Report.this.X();
            } catch (Exception unused) {
                Toast.makeText(Daily_Doc_Report.this.getApplicationContext(), Daily_Doc_Report.this.getString(R.string.sql_error), 1);
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

    public class h implements Observer {
        public h() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List list) {
            Daily_Doc_Report.this.j0(list);
        }
    }

    public class i extends Handler {
        public i() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + ":" + Daily_Doc_Report.this.T);
            if (message.obj.toString().equals("0")) {
                Daily_Doc_Report.this.U();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Daily_Doc_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Daily_Doc_Report daily_Doc_Report = Daily_Doc_Report.this;
                sb.append(daily_Doc_Report.i.ic(daily_Doc_Report.f0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Daily_Doc_Report.this.C.notifyDataSetChanged();
                Daily_Doc_Report daily_Doc_Report2 = Daily_Doc_Report.this;
                daily_Doc_Report2.i.lc(daily_Doc_Report2, daily_Doc_Report2.O, daily_Doc_Report2.P, daily_Doc_Report2.R, daily_Doc_Report2.S, daily_Doc_Report2.Q);
                Daily_Doc_Report daily_Doc_Report3 = Daily_Doc_Report.this;
                int i = daily_Doc_Report3.Z;
                if (i == 1) {
                    daily_Doc_Report3.i.ld(daily_Doc_Report3, daily_Doc_Report3.O, daily_Doc_Report3.T);
                } else if (i == 2) {
                    daily_Doc_Report3.i.ld(daily_Doc_Report3, daily_Doc_Report3.P, daily_Doc_Report3.T);
                } else if (i == 3) {
                    daily_Doc_Report3.i.ld(daily_Doc_Report3, daily_Doc_Report3.R, daily_Doc_Report3.T);
                } else if (i == 4) {
                    daily_Doc_Report3.i.ld(daily_Doc_Report3, daily_Doc_Report3.S, daily_Doc_Report3.T);
                } else if (i == 5) {
                    daily_Doc_Report3.i.ld(daily_Doc_Report3, daily_Doc_Report3.Q, daily_Doc_Report3.T);
                }
                Daily_Doc_Report.this.R(-2);
            }
            Daily_Doc_Report.this.o0(false);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Doc_Report.this.V();
            Message message = new Message();
            message.obj = "0";
            Daily_Doc_Report.this.Y.sendMessage(message);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Doc_Report daily_Doc_Report = Daily_Doc_Report.this;
            daily_Doc_Report.f0 = daily_Doc_Report.i.ic(daily_Doc_Report.f0);
            Daily_Doc_Report daily_Doc_Report2 = Daily_Doc_Report.this;
            C3357m10 c3357m10 = new C3357m10(daily_Doc_Report2, daily_Doc_Report2.i);
            Daily_Doc_Report daily_Doc_Report3 = Daily_Doc_Report.this;
            c3357m10.n(daily_Doc_Report3.z, daily_Doc_Report3.f0, daily_Doc_Report3.m0, daily_Doc_Report3.n0);
            Message message = new Message();
            message.obj = "1";
            Daily_Doc_Report.this.Y.sendMessage(message);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Doc_Report daily_Doc_Report = Daily_Doc_Report.this;
            C3357m10 c3357m10 = new C3357m10(daily_Doc_Report, daily_Doc_Report.i);
            Daily_Doc_Report daily_Doc_Report2 = Daily_Doc_Report.this;
            RecyclerView recyclerView = daily_Doc_Report2.z;
            String strIc = daily_Doc_Report2.i.ic(daily_Doc_Report2.f0);
            Daily_Doc_Report daily_Doc_Report3 = Daily_Doc_Report.this;
            c3357m10.l(recyclerView, strIc, daily_Doc_Report3.m0, daily_Doc_Report3.n0);
            Message message = new Message();
            message.obj = "1";
            Daily_Doc_Report.this.Y.sendMessage(message);
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ View a;

        public m(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Doc_Report daily_Doc_Report = Daily_Doc_Report.this;
            daily_Doc_Report.D = daily_Doc_Report.C.c();
            Daily_Doc_Report daily_Doc_Report2 = Daily_Doc_Report.this;
            if (daily_Doc_Report2.T == 0) {
                daily_Doc_Report2.T = 1;
            } else {
                daily_Doc_Report2.T = 0;
            }
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    Daily_Doc_Report.this.Z = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Daily_Doc_Report.this.Z = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    Daily_Doc_Report.this.Z = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Daily_Doc_Report.this.Z = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Daily_Doc_Report.this.Z = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "2";
            Daily_Doc_Report.this.Y.sendMessage(message);
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

    public class p implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public p(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(this.a.getContext(), (Class<?>) Customer_Det_List_edit5.class);
            intent.putExtra("back_edit", 1);
            intent.putExtra("doc_tr_type", 5);
            Z00.E0 = true;
            Daily_Doc_Report.this.startActivity(intent);
        }
    }

    public class q implements Observer {
        public q() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List list) {
            if (list.size() != 2) {
                Daily_Doc_Report.this.L.setVisibility(4);
                Daily_Doc_Report.this.M.setVisibility(4);
                return;
            }
            Daily_Doc_Report.this.L.setVisibility(0);
            Daily_Doc_Report.this.M.setVisibility(0);
            if (((Double) list.get(0)).doubleValue() > 0.0d) {
                Daily_Doc_Report daily_Doc_Report = Daily_Doc_Report.this;
                daily_Doc_Report.L.setText(daily_Doc_Report.i.Q7(String.valueOf(list.get(0)), 0));
            } else {
                Daily_Doc_Report.this.L.setText("");
            }
            if (((Double) list.get(1)).doubleValue() <= 0.0d) {
                Daily_Doc_Report.this.M.setText("");
            } else {
                Daily_Doc_Report daily_Doc_Report2 = Daily_Doc_Report.this;
                daily_Doc_Report2.M.setText(daily_Doc_Report2.i.Q7(String.valueOf(list.get(1)), 0));
            }
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public r(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(this.a.getContext(), (Class<?>) Customer_Det_List_edit5.class);
            intent.putExtra("back_edit", 1);
            intent.putExtra("doc_tr_type", 6);
            Z00.E0 = true;
            Daily_Doc_Report.this.startActivity(intent);
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Daily_Doc_Report.this.showDialog(0);
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Daily_Doc_Report.this.showDialog(4);
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
                Daily_Doc_Report.this.l0 = 0;
                dialogInterface.dismiss();
                Daily_Doc_Report.this.R(0);
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
                Daily_Doc_Report daily_Doc_Report = Daily_Doc_Report.this;
                daily_Doc_Report.l0 = 1;
                if (daily_Doc_Report.o0.getText() == null) {
                    Daily_Doc_Report.this.m0 = "";
                } else {
                    Daily_Doc_Report daily_Doc_Report2 = Daily_Doc_Report.this;
                    daily_Doc_Report2.m0 = daily_Doc_Report2.o0.getText().toString();
                }
                if (Daily_Doc_Report.this.p0.getText() == null) {
                    Daily_Doc_Report.this.n0 = "";
                } else {
                    Daily_Doc_Report daily_Doc_Report3 = Daily_Doc_Report.this;
                    daily_Doc_Report3.n0 = daily_Doc_Report3.p0.getText().toString();
                }
                this.a.dismiss();
                Daily_Doc_Report.this.R(0);
            } catch (Exception unused) {
            }
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
                Daily_Doc_Report.this.i0(this.a);
            }
        }

        public x() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                try {
                    Daily_Doc_Report daily_Doc_Report = Daily_Doc_Report.this;
                    if (daily_Doc_Report.d0 == 1) {
                        daily_Doc_Report.d0 = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Daily_Doc_Report.this.d0 = 1;
            }
            Daily_Doc_Report.this.r0.removeCallbacksAndMessages(null);
            Daily_Doc_Report.this.r0.postDelayed(new a(str), new C2160f10().V(str));
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
            Daily_Doc_Report.this.d0 = 0;
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
            Daily_Doc_Report.this.i0 = i;
            Daily_Doc_Report.this.j0 = i2;
            Daily_Doc_Report.this.k0 = i3;
            try {
                String str = Daily_Doc_Report.this.i0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Doc_Report.this.j0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Doc_Report.this.k0));
                Locale locale = Locale.ENGLISH;
                Daily_Doc_Report.this.o0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i2) {
        String str;
        this.c0 = i2;
        boolean zIsEmpty = this.m0.isEmpty();
        String str2 = CSS.Value.PERCENTAGE;
        this.m0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.m0;
        if (!this.n0.isEmpty()) {
            str2 = this.n0;
        }
        this.n0 = str2;
        SearchView searchView = this.q0;
        this.e0 = (searchView == null || searchView.getQuery() == null) ? "" : this.q0.getQuery().toString();
        if (b0() && this.l0 == 0) {
            new C3966tX().z(this, this.z, this.B, -2);
        } else if (b0() || this.l0 == 1 || this.c0 > 0) {
            new C3966tX().z(this, this.z, this.B, -1);
        }
        C4360yM c4360yM = this.C;
        if (c4360yM == null || this.l0 == 1) {
            C2160f10.l = 100;
        }
        if (c4360yM == null || this.l0 == 1 || i2 == -2) {
            C4360yM c4360yM2 = new C4360yM(this, R.layout.data_det_row_bill4_, this.D, 20, false, 1, this, this);
            this.C = c4360yM2;
            this.z.setAdapter(c4360yM2.withLoadStateFooter(new C4249x1(new View.OnClickListener() { // from class: ih
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.c0(view);
                }
            })));
            this.C.addLoadStateListener(new InterfaceC3750qp() { // from class: jh
                @Override // defpackage.InterfaceC3750qp
                public final Object invoke(Object obj) {
                    return this.a.g0((CombinedLoadStates) obj);
                }
            });
        }
        if (i2 == -1 || ((str = this.e0) != null && str.length() > 0)) {
            this.C.g = this.e0;
        }
        this.b0.e(this, this.j, this.x, this.i, this.m0, this.n0, 11, (i2 > 0 || i2 == -2 || a0()) ? 1 : this.l0, i2, this.d0, this.e0, this.Z, this.T);
        this.b0.d.k(new InterfaceC2295gf() { // from class: kh
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.h0((PagingData) obj);
            }
        });
        if (i2 > 0 || i2 == -2) {
            return;
        }
        this.b0.g(this, this.j, this.x, this.i, this.m0, this.n0, 11, i2 > 0 ? 1 : this.l0, this.d0, this.e0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0() {
        this.z.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FW g0(CombinedLoadStates combinedLoadStates) {
        Log.d("trace_2loadStates:=", this.c0 + ":" + this.l0 + ":" + this.d0 + ":" + combinedLoadStates.getPrepend().toString() + ":" + combinedLoadStates.toString());
        if (combinedLoadStates.getPrepend().getEndOfPaginationReached()) {
            Log.d("trace_2loadStates:=", "END");
            new C3966tX().z(this, this.z, this.B, this.C.c().size());
            j0(null);
            if (a0() || this.c0 == -1) {
                if (this.l0 == 1 || this.c0 <= -1) {
                    if (this.c0 == -1) {
                        new Handler().postDelayed(new Runnable() { // from class: lh
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.d0();
                            }
                        }, 0L);
                    } else {
                        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.z.getLayoutManager();
                        new Handler().postDelayed(new Runnable() { // from class: mh
                            @Override // java.lang.Runnable
                            public final void run() {
                                linearLayoutManager.scrollToPositionWithOffset(0, 0);
                            }
                        }, 0L);
                    }
                }
                if (a0() && this.c0 < 0) {
                    this.i.Kd(this, new C2160f10(this, this.i).P(this.m0, this.n0), 500);
                }
            }
            int i2 = this.c0;
            if (i2 == 1) {
                l0();
            } else if (i2 == 2) {
                k0();
            }
            if (this.c0 == 0 && this.z.computeVerticalScrollOffset() == 0) {
                new Handler().postDelayed(new Runnable() { // from class: nh
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f0();
                    }
                }, 0L);
            }
            this.c0 = 0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(PagingData pagingData) {
        Log.d("trace_2Observer=", "onChanged");
        this.C.submitData(getLifecycle(), pagingData);
    }

    private void q0() {
        X();
        int i2 = this.x;
        if (i2 == 2) {
            this.t.setText(getString(R.string.supp));
            W();
        } else if (i2 == 1) {
            this.t.setText(getString(R.string.cus));
            W();
        }
    }

    public void O(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "new")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.doc_type_title));
        builder.setPositiveButton(getString(R.string.doc_type_title_1), new p(view));
        builder.setNeutralButton(getString(R.string.doc_type_title_2), new r(view));
        builder.create().show();
    }

    public void P() {
        try {
            this.l0 = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.o0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.p0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.o0.setOnClickListener(new s());
            this.p0.setOnClickListener(new t());
            builder.setPositiveButton(getString(R.string.btn_search), new u());
            builder.setNegativeButton(getString(R.string.btn_cancel), new v());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
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

    public void S() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        if (this.i.ja("prefOthers_closed_year", false)) {
            return;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (this.E.valueAt(size)) {
                C4145vh c4145vh = (C4145vh) this.C.c().get(this.E.keyAt(size));
                this.i.v0("delete from transactions where p_id='" + c4145vh.v() + "' and bill_id=-3 and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0') ='" + c4145vh.e() + "'");
            }
        }
        R(0);
        q0();
        m0(true);
    }

    public void T() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.E.size() - 1;
        if (this.E.valueAt(size)) {
            C4145vh c4145vh = (C4145vh) this.C.c().get(this.E.keyAt(size));
            this.i.s9(c4145vh.v(), c4145vh.u(), c4145vh.n(), c4145vh.e(), this);
        }
    }

    public void U() {
        Z();
    }

    public void V() {
        Cursor cursorV4;
        Daily_Doc_Report daily_Doc_Report = this;
        if (daily_Doc_Report.l0 == 0) {
            cursorV4 = daily_Doc_Report.i.V4(daily_Doc_Report.j, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, -1, -1, 0, "");
        } else {
            boolean zIsEmpty = daily_Doc_Report.m0.isEmpty();
            String str = CSS.Value.PERCENTAGE;
            daily_Doc_Report.m0 = zIsEmpty ? CSS.Value.PERCENTAGE : daily_Doc_Report.m0;
            if (!daily_Doc_Report.n0.isEmpty()) {
                str = daily_Doc_Report.n0;
            }
            String str2 = str;
            daily_Doc_Report.n0 = str2;
            cursorV4 = daily_Doc_Report.i.V4(daily_Doc_Report.j, daily_Doc_Report.m0, str2, -1, -1, 0, "");
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorV4.getCount()));
        daily_Doc_Report.p = 0.0d;
        daily_Doc_Report.q = 0.0d;
        daily_Doc_Report.D.clear();
        C0566Hd c0566Hd = new C0566Hd();
        while (cursorV4.moveToNext()) {
            daily_Doc_Report.D.add(new C4145vh(cursorV4.getString(c0566Hd.b(cursorV4, "_id")), cursorV4.getString(c0566Hd.b(cursorV4, "p_ref_no")), cursorV4.getString(c0566Hd.b(cursorV4, "p_date")), "" + cursorV4.getDouble(c0566Hd.b(cursorV4, "p_amount")), cursorV4.getString(c0566Hd.b(cursorV4, "p_remarks")), cursorV4.getString(c0566Hd.b(cursorV4, "doc_type")) + "-" + cursorV4.getString(c0566Hd.b(cursorV4, "cash_name")), cursorV4.getString(c0566Hd.b(cursorV4, "curr_name")), cursorV4.getString(c0566Hd.b(cursorV4, "doc_type")), "" + cursorV4.getDouble(c0566Hd.b(cursorV4, "p_amount")), cursorV4.getString(c0566Hd.b(cursorV4, "cash_name")), cursorV4.getString(c0566Hd.b(cursorV4, "curr_name")), "", cursorV4.getString(cursorV4.getColumnIndex("dev_id")), cursorV4.getString(cursorV4.getColumnIndex("tr_type"))));
            daily_Doc_Report = this;
        }
        cursorV4.close();
    }

    public void W() {
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

    public void X() {
        o0(true);
        new Thread(new j()).start();
    }

    public void Y(String str, String str2) {
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

    public void Z() {
        this.O = (TextView) findViewById(R.id.f1);
        this.P = (TextView) findViewById(R.id.f2);
        this.R = (TextView) findViewById(R.id.f3);
        this.S = (TextView) findViewById(R.id.f4);
        this.Q = (TextView) findViewById(R.id.f5);
        this.O.setText(getString(R.string.doc_no));
        this.P.setText(getString(R.string.date2));
        this.R.setText(getString(R.string.total_sum));
        this.S.setText(getString(R.string.doc_remarks));
        this.Q.setText(getString(R.string.doc_type));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.O);
        c0372Bn.a(this, this.P);
        c0372Bn.a(this, this.R);
        c0372Bn.a(this, this.S);
        c0372Bn.a(this, this.Q);
        TextView textView = this.O;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.P;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.R;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.S;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.Q;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.i.ld(this, this.P, this.T);
        this.O.setOnClickListener(new ViewOnClickListenerC2885a());
        this.P.setOnClickListener(new ViewOnClickListenerC2886b());
        this.Q.setOnClickListener(new c());
        this.R.setOnClickListener(new d());
        this.S.setOnClickListener(new e());
    }

    @Override // defpackage.C4279xM.c
    public void a(int i2) {
        if (this.U == null) {
            this.U = startActionMode(this.V);
        }
        this.C.k(i2);
        this.U.invalidate();
        int iD = this.C.d();
        if (iD <= 0) {
            this.U.finish();
            return;
        }
        this.U.setTitle(iD + " Selected");
    }

    public boolean a0() {
        this.m0 = this.m0.isEmpty() ? CSS.Value.PERCENTAGE : this.m0;
        this.n0 = this.n0.isEmpty() ? CSS.Value.PERCENTAGE : this.n0;
        return (this.m0.equals(CSS.Value.PERCENTAGE) && this.n0.equals(CSS.Value.PERCENTAGE)) ? false : true;
    }

    public void add_btn(View view) {
        O(view);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public boolean b0() {
        SearchView searchView = this.q0;
        return searchView == null || searchView.getQuery() == null || this.q0.getQuery().length() != 0;
    }

    public void btn_add(View view) {
        add_btn(view);
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.W = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new f(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new g());
        builder.create().show();
    }

    public final /* synthetic */ void c0(View view) {
        this.C.retry();
    }

    public final /* synthetic */ void d0() {
        this.C.notifyDataSetChanged();
    }

    @Override // defpackage.DE
    public void e(int i2, C4145vh c4145vh) {
        this.i.s9(c4145vh.v(), c4145vh.u(), c4145vh.n(), c4145vh.e(), this);
    }

    public void help_btn(View view) {
        n0();
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
        Log.d("trace_E_doc_rep=", "#" + this.j);
        this.V = new B(this, null);
    }

    public void k0() {
        o0(true);
        new Thread(new k()).start();
    }

    public void l0() {
        o0(true);
        new Thread(new l()).start();
    }

    public void m0(boolean z2) {
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.W.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.W + "'");
            }
            this.W = "";
            X();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void n0() {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new n());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new o());
        builder.show();
    }

    public void no_result_btn(View view) {
        this.l0 = 0;
        X();
    }

    public void o0(boolean z2) {
        Log.d("mProgress=", "....start..." + z2);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z2) {
                AlertDialog alertDialogCreate = builder.create();
                this.X = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.X;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_rv_bill4_doc);
        Z00.E0 = false;
        Z00.F0 = "";
        setTitle(getString(R.string.doc_title2));
        this.z = (RecyclerView) findViewById(R.id.list_items);
        this.B = (TextView) findViewById(R.id.emptyResults);
        this.z.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.B.setText(getString(R.string.wait));
        this.i = new Z00(this.h, this);
        this.L = (TextView) findViewById(R.id.footer_sum);
        this.M = (TextView) findViewById(R.id.footer_sum2);
        this.L.setVisibility(4);
        this.M.setVisibility(4);
        this.N = (ImageView) findViewById(R.id.img_add_amount);
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
        this.i0 = calendar.get(1);
        this.j0 = calendar.get(2);
        this.k0 = calendar.get(5);
        m0(true);
        try {
            C0990Vh c0990Vh = (C0990Vh) ViewModelProviders.of(this).get(C0990Vh.class);
            this.b0 = c0990Vh;
            c0990Vh.a.observe(this, new h());
            this.b0.h.observe(this, new q());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        R(0);
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.s0, this.i0, this.j0, this.k0);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.t0, this.i0, this.j0, this.k0);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_doc, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        this.q0 = (SearchView) menuItemFindItem.getActionView();
        this.q0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.q0.setQueryHint(getString(R.string.search_hint));
        this.q0.setOnQueryTextListener(new x());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new y());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        m0(true);
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
            this.f0 = getTitle().toString();
            if (Build.VERSION.SDK_INT < 31) {
                Q();
            }
            if (a0()) {
                l0();
            } else {
                R(1);
            }
            return true;
        }
        if (menuItem.getItemId() != R.id.action_print_bills) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f0 = getTitle().toString();
        if (Build.VERSION.SDK_INT < 31) {
            Q();
        }
        if (a0()) {
            k0();
        } else {
            R(2);
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

    public void p0(View view) {
        o0(true);
        new Thread(new m(view)).start();
    }

    @Override // defpackage.DE
    public void c(int i2, C4064uh c4064uh) {
    }
}
