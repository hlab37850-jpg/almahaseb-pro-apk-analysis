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
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C0908Sh;
import defpackage.C0922Sv;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Daily_Curr_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, a.b, LoaderManager.LoaderCallbacks<List<C4145vh>> {
    public static int l0;
    public TextView B;
    public C0922Sv C;
    public SparseBooleanArray E;
    public ArrayAdapter F;
    public TextView Q;
    public int a0;
    public int b0;
    public int c0;
    public SQLiteDatabase h;
    public Z00 i;
    public SearchView i0;
    public String j;
    public String k;
    public int l;
    public int n = 0;
    public double p = 0.0d;
    public double q = 0.0d;
    public TextView t = null;
    public AutoCompleteTextView u = null;
    public TextView v = null;
    public SwitchCompat w = null;
    public int x = 0;
    public ImageView y = null;
    public ListView z = null;
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
    public TextView P = null;
    public TextView R = null;
    public int S = 0;
    public String T = "";
    public Dialog U = null;
    public Handler V = new n();
    public int W = 0;
    public String X = "";
    public Cursor Y = null;
    public boolean Z = false;
    public int d0 = 0;
    public String e0 = CSS.Value.PERCENTAGE;
    public String f0 = CSS.Value.PERCENTAGE;
    public TextView g0 = null;
    public TextView h0 = null;
    public DatePickerDialog.OnDateSetListener j0 = new C();
    public DatePickerDialog.OnDateSetListener k0 = new D();

    public class A implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public A(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Curr_Report daily_Curr_Report = Daily_Curr_Report.this;
                daily_Curr_Report.d0 = 1;
                if (daily_Curr_Report.g0.getText() == null) {
                    Daily_Curr_Report.this.e0 = "";
                } else {
                    Daily_Curr_Report daily_Curr_Report2 = Daily_Curr_Report.this;
                    daily_Curr_Report2.e0 = daily_Curr_Report2.g0.getText().toString();
                }
                if (Daily_Curr_Report.this.h0.getText() == null) {
                    Daily_Curr_Report.this.f0 = "";
                } else {
                    Daily_Curr_Report daily_Curr_Report3 = Daily_Curr_Report.this;
                    daily_Curr_Report3.f0 = daily_Curr_Report3.h0.getText().toString();
                }
                this.a.dismiss();
                Daily_Curr_Report.this.S();
            } catch (Exception unused) {
            }
        }
    }

    public class B implements SearchView.OnQueryTextListener {
        public B() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Daily_Curr_Report.this.P(1);
            }
            Daily_Curr_Report.this.Y(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Daily_Curr_Report.this.P(0);
            return false;
        }
    }

    public class C implements DatePickerDialog.OnDateSetListener {
        public C() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Daily_Curr_Report.this.a0 = i;
            Daily_Curr_Report.this.b0 = i2;
            Daily_Curr_Report.this.c0 = i3;
            try {
                String str = Daily_Curr_Report.this.a0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Curr_Report.this.b0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Curr_Report.this.c0));
                Locale locale = Locale.ENGLISH;
                Daily_Curr_Report.this.g0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class D implements DatePickerDialog.OnDateSetListener {
        public D() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Daily_Curr_Report.this.a0 = i;
            Daily_Curr_Report.this.b0 = i2;
            Daily_Curr_Report.this.c0 = i3;
            try {
                String str = Daily_Curr_Report.this.a0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Curr_Report.this.b0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Daily_Curr_Report.this.c0));
                Locale locale = Locale.ENGLISH;
                Daily_Curr_Report.this.h0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class E implements Comparator {
        public E() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                int iCompareTo = simpleDateFormat.parse(c4145vh.n()).compareTo(simpleDateFormat.parse(c4145vh2.n()));
                return iCompareTo == 0 ? Integer.valueOf(c4145vh.a()).compareTo(Integer.valueOf(c4145vh2.a())) : iCompareTo;
            } catch (ParseException unused) {
                return 0;
            }
        }

        public /* synthetic */ E(Daily_Curr_Report daily_Curr_Report, k kVar) {
            this();
        }
    }

    public class F implements Comparator {
        public F() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                int iCompareTo = simpleDateFormat.parse(c4145vh2.n()).compareTo(simpleDateFormat.parse(c4145vh.n()));
                return iCompareTo == 0 ? Integer.valueOf(c4145vh2.a()).compareTo(Integer.valueOf(c4145vh.a())) : iCompareTo;
            } catch (ParseException unused) {
                return 0;
            }
        }

        public /* synthetic */ F(Daily_Curr_Report daily_Curr_Report, k kVar) {
            this();
        }
    }

    public class G implements Comparator {
        public int a;

        public G(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? Double.valueOf(c4145vh.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.a().replaceAll(",", ""))) : Double.valueOf(c4145vh.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.o().replaceAll(",", "")));
        }
    }

    public class H implements Comparator {
        public int a;

        public H(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? Double.valueOf(c4145vh2.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.a().replaceAll(",", ""))) : Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Curr_Report$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2877a implements View.OnClickListener {
        public ViewOnClickListenerC2877a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Curr_Report.this.n0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Curr_Report$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2878b implements View.OnClickListener {
        public ViewOnClickListenerC2878b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Curr_Report.this.n0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Curr_Report$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2879c implements View.OnClickListener {
        public ViewOnClickListenerC2879c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Curr_Report.this.n0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Curr_Report$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2880d implements View.OnClickListener {
        public ViewOnClickListenerC2880d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Curr_Report.this.n0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Curr_Report$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2881e implements View.OnClickListener {
        public ViewOnClickListenerC2881e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Daily_Curr_Report.this.n0(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Curr_Report$f, reason: case insensitive filesystem */
    public class C2882f implements Comparator {
        public final /* synthetic */ int a;

        public C2882f(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 5 ? String.valueOf(c4145vh2.q()).compareTo(String.valueOf(c4145vh.q())) : String.valueOf(c4145vh2.p()).compareTo(String.valueOf(c4145vh.p()));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Curr_Report$g, reason: case insensitive filesystem */
    public class C2883g implements Comparator {
        public final /* synthetic */ int a;

        public C2883g(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 5 ? String.valueOf(c4145vh.q()).compareTo(String.valueOf(c4145vh2.q())) : String.valueOf(c4145vh.p()).compareTo(String.valueOf(c4145vh2.p()));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Daily_Curr_Report$h, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2884h implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public DialogInterfaceOnClickListenerC2884h(TextView textView, ImageView imageView) {
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
                Daily_Curr_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Daily_Curr_Report.this.l = 0;
                Daily_Curr_Report.this.S();
            } catch (Exception unused) {
                Toast.makeText(Daily_Curr_Report.this.getApplicationContext(), Daily_Curr_Report.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public j(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Daily_Curr_Report.this.l = 0;
                    Daily_Curr_Report.this.o0();
                }
            } catch (Exception e) {
                Log.d("delete_err=", e.getMessage());
            }
        }
    }

    public class k implements AdapterView.OnItemClickListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
            Daily_Curr_Report.l0 = Daily_Curr_Report.this.z.getFirstVisiblePosition();
            Z00.F0 = Daily_Curr_Report.this.i0.getQuery() != null ? Daily_Curr_Report.this.i0.getQuery().toString() : "";
            Daily_Curr_Report.this.i.p9(c4145vh.v(), c4145vh.u(), c4145vh.n(), c4145vh.e(), Daily_Curr_Report.this);
        }
    }

    public class l implements AbsListView.MultiChoiceModeListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Daily_Curr_Report.this.M();
                } catch (Exception unused) {
                    Toast.makeText(Daily_Curr_Report.this.getApplicationContext(), "SQL Error.", 1);
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

        public l() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Daily_Curr_Report.this.E = Daily_Curr_Report.this.C.c();
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Daily_Curr_Report.this);
                    builder.setMessage(Daily_Curr_Report.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Daily_Curr_Report.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Daily_Curr_Report.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC = Daily_Curr_Report.this.C.c();
                    Daily_Curr_Report daily_Curr_Report = Daily_Curr_Report.this;
                    daily_Curr_Report.E = sparseBooleanArrayC;
                    daily_Curr_Report.N();
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
            Daily_Curr_Report.this.z.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Daily_Curr_Report.this.C.l.clear();
            Daily_Curr_Report.this.C.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Daily_Curr_Report.this.z.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Daily_Curr_Report.this.C.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Daily_Curr_Report.this.z.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class n extends Handler {
        public n() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Daily_Curr_Report.this.O();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Daily_Curr_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Daily_Curr_Report daily_Curr_Report = Daily_Curr_Report.this;
                sb.append(daily_Curr_Report.i.ic(daily_Curr_Report.X));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Daily_Curr_Report.this.C.notifyDataSetChanged();
                Daily_Curr_Report daily_Curr_Report2 = Daily_Curr_Report.this;
                daily_Curr_Report2.i.lc(daily_Curr_Report2, daily_Curr_Report2.N, daily_Curr_Report2.O, daily_Curr_Report2.Q, daily_Curr_Report2.R, daily_Curr_Report2.P);
                Daily_Curr_Report daily_Curr_Report3 = Daily_Curr_Report.this;
                int i = daily_Curr_Report3.W;
                if (i == 1) {
                    daily_Curr_Report3.i.ld(daily_Curr_Report3, daily_Curr_Report3.N, daily_Curr_Report3.S);
                } else if (i == 2) {
                    daily_Curr_Report3.i.ld(daily_Curr_Report3, daily_Curr_Report3.O, daily_Curr_Report3.S);
                } else if (i == 3) {
                    daily_Curr_Report3.i.ld(daily_Curr_Report3, daily_Curr_Report3.Q, daily_Curr_Report3.S);
                } else if (i == 4) {
                    daily_Curr_Report3.i.ld(daily_Curr_Report3, daily_Curr_Report3.R, daily_Curr_Report3.S);
                } else if (i == 5) {
                    daily_Curr_Report3.i.ld(daily_Curr_Report3, daily_Curr_Report3.P, daily_Curr_Report3.S);
                }
            }
            Daily_Curr_Report.this.g0(false);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Curr_Report.this.Q();
            Message message = new Message();
            message.obj = "0";
            Daily_Curr_Report.this.V.sendMessage(message);
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Curr_Report daily_Curr_Report = Daily_Curr_Report.this;
            daily_Curr_Report.X = daily_Curr_Report.i.ic(daily_Curr_Report.X);
            Daily_Curr_Report daily_Curr_Report2 = Daily_Curr_Report.this;
            daily_Curr_Report2.i.yb(daily_Curr_Report2.z, daily_Curr_Report2.X, daily_Curr_Report2.e0, daily_Curr_Report2.f0);
            Message message = new Message();
            message.obj = "1";
            Daily_Curr_Report.this.V.sendMessage(message);
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Curr_Report daily_Curr_Report = Daily_Curr_Report.this;
            Z00 z00 = daily_Curr_Report.i;
            ListView listView = daily_Curr_Report.z;
            String strIc = z00.ic(daily_Curr_Report.X);
            Daily_Curr_Report daily_Curr_Report2 = Daily_Curr_Report.this;
            z00.wb(listView, strIc, daily_Curr_Report2.e0, daily_Curr_Report2.f0);
            Message message = new Message();
            message.obj = "1";
            Daily_Curr_Report.this.V.sendMessage(message);
        }
    }

    public class r implements Runnable {
        public final /* synthetic */ View a;

        public r(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Daily_Curr_Report daily_Curr_Report = Daily_Curr_Report.this;
            daily_Curr_Report.D = daily_Curr_Report.C.e;
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    Daily_Curr_Report.this.k0(this.a, 1);
                    Daily_Curr_Report.this.W = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Daily_Curr_Report.this.l0(this.a);
                    Daily_Curr_Report.this.W = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    Daily_Curr_Report.this.k0(this.a, 3);
                    Daily_Curr_Report.this.W = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Daily_Curr_Report.this.m0(this.a, 4);
                    Daily_Curr_Report.this.W = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Daily_Curr_Report.this.m0(this.a, 5);
                    Daily_Curr_Report.this.W = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "2";
            Daily_Curr_Report.this.V.sendMessage(message);
        }
    }

    public class s extends WebViewClient {
        public s() {
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

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public u(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(this.a.getContext(), (Class<?>) Customer_Det_List_edit6.class);
            intent.putExtra("back_edit", 1);
            intent.putExtra("doc_tr_type", 10);
            Z00.E0 = true;
            Daily_Curr_Report.this.startActivity(intent);
            Daily_Curr_Report.this.finish();
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public v(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(this.a.getContext(), (Class<?>) Customer_Det_List_edit6.class);
            intent.putExtra("back_edit", 1);
            intent.putExtra("doc_tr_type", 13);
            Z00.E0 = true;
            Daily_Curr_Report.this.startActivity(intent);
            Daily_Curr_Report.this.finish();
        }
    }

    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Daily_Curr_Report.this.showDialog(0);
        }
    }

    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Daily_Curr_Report.this.showDialog(4);
        }
    }

    public class y implements DialogInterface.OnClickListener {
        public y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class z implements DialogInterface.OnClickListener {
        public z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Daily_Curr_Report.this.d0 = 0;
                dialogInterface.dismiss();
                Daily_Curr_Report.this.S();
            } catch (Exception unused) {
            }
        }
    }

    private void L() {
        getSupportLoaderManager().initLoader(Calendar.getInstance().get(14), null, this).forceLoad();
    }

    private void b0(List list) {
        Collections.sort(this.D, new F(this, null));
    }

    private void c0(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new C2883g(i2)));
    }

    private void d0(List list, int i2) {
        Collections.sort(this.D, new H(i2));
    }

    private void h0(List list, int i2) {
        Collections.sort(this.D, new G(i2));
    }

    private void i0(List list) {
        Collections.sort(this.D, new E(this, null));
    }

    private void j0(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new C2882f(i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(View view) {
        if (this.S == 0) {
            i0(this.D);
            this.S = 1;
        } else {
            b0(this.D);
            this.S = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        S();
        int i2 = this.x;
        if (i2 == 2) {
            this.t.setText(getString(R.string.supp));
            R();
        } else if (i2 == 1) {
            this.t.setText(getString(R.string.cus));
            R();
        }
    }

    public void I(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.currency));
        builder.setPositiveButton(getString(R.string.curr_type_title_1), new u(view));
        builder.setNeutralButton(getString(R.string.curr_type_title_2), new v(view));
        builder.create().show();
    }

    public void J() {
        try {
            this.d0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.g0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.h0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.g0.setOnClickListener(new w());
            this.h0.setOnClickListener(new x());
            builder.setPositiveButton(getString(R.string.btn_search), new y());
            builder.setNegativeButton(getString(R.string.btn_cancel), new z());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new A(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void K() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void M() {
        if (this.i.ja("prefOthers_closed_year", false)) {
            return;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (this.E.valueAt(size)) {
                C4145vh item = this.C.getItem(this.E.keyAt(size));
                this.C.remove(item);
                this.i.v0("delete from transactions where p_id='" + item.v() + "' and bill_id=-6 and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0') ='" + item.e() + "'");
            }
        }
        o0();
        e0(true);
    }

    public void N() {
        int size = this.E.size() - 1;
        if (this.E.valueAt(size)) {
            C4145vh item = this.C.getItem(this.E.keyAt(size));
            this.i.s9(item.v(), item.u(), item.n(), item.e(), this);
        }
    }

    public void O() {
        W();
        C0922Sv c0922Sv = this.C;
        if (c0922Sv != null) {
            c0922Sv.f(this.D);
            return;
        }
        C0922Sv c0922Sv2 = new C0922Sv(this, R.layout.data_det_row_bill4_, this.D, 20, V(), 1);
        this.C = c0922Sv2;
        c0922Sv2.l.clear();
        this.C.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.C);
    }

    public void P(int i2) {
        try {
            if (i2 == 1) {
                TextView textView = this.L;
                StringBuilder sb = new StringBuilder();
                sb.append(this.p >= 0.0d ? getString(R.string.tot_radio2) : getString(R.string.tot_radio1));
                sb.append(" ");
                sb.append(this.i.P7(String.valueOf(this.p)));
                textView.setText(sb.toString());
                return;
            }
            double dT = T(this.C.e);
            TextView textView2 = this.L;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dT >= 0.0d ? getString(R.string.tot_radio2) : getString(R.string.tot_radio1));
            sb2.append(" ");
            sb2.append(this.i.P7(String.valueOf(dT)));
            textView2.setText(sb2.toString());
        } catch (Exception unused) {
        }
    }

    public void Q() {
        Cursor cursorU4;
        Daily_Curr_Report daily_Curr_Report = this;
        if (daily_Curr_Report.d0 == 0) {
            cursorU4 = daily_Curr_Report.i.U4(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, -1, -1, "");
        } else {
            boolean zIsEmpty = daily_Curr_Report.e0.isEmpty();
            String str = CSS.Value.PERCENTAGE;
            daily_Curr_Report.e0 = zIsEmpty ? CSS.Value.PERCENTAGE : daily_Curr_Report.e0;
            if (!daily_Curr_Report.f0.isEmpty()) {
                str = daily_Curr_Report.f0;
            }
            String str2 = str;
            daily_Curr_Report.f0 = str2;
            cursorU4 = daily_Curr_Report.i.U4(daily_Curr_Report.e0, str2, -1, -1, "");
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorU4.getCount()));
        daily_Curr_Report.p = 0.0d;
        daily_Curr_Report.q = 0.0d;
        daily_Curr_Report.D.clear();
        C0566Hd c0566Hd = new C0566Hd();
        while (cursorU4.moveToNext()) {
            daily_Curr_Report.D.add(new C4145vh(cursorU4.getString(c0566Hd.b(cursorU4, "_id")), cursorU4.getString(c0566Hd.b(cursorU4, "p_ref_no")), cursorU4.getString(c0566Hd.b(cursorU4, "p_date")), "" + cursorU4.getDouble(c0566Hd.b(cursorU4, "p_amount")), cursorU4.getString(c0566Hd.b(cursorU4, "p_remarks")), cursorU4.getString(c0566Hd.b(cursorU4, "doc_type")), cursorU4.getString(c0566Hd.b(cursorU4, "curr_name")), cursorU4.getString(c0566Hd.b(cursorU4, "doc_type")), "" + cursorU4.getDouble(c0566Hd.b(cursorU4, "p_amount")), cursorU4.getString(c0566Hd.b(cursorU4, "cash_name")), cursorU4.getString(c0566Hd.b(cursorU4, "curr_name")), "", cursorU4.getString(cursorU4.getColumnIndex("dev_id"))));
            daily_Curr_Report = this;
        }
        cursorU4.close();
    }

    public void R() {
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

    public void S() {
        g0(true);
        new Thread(new o()).start();
    }

    public double T(List list) {
        Log.d("net_bal:", list.size() + "");
        double d = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d += Double.parseDouble(((C4145vh) list.get(i2)).p().replaceAll(",", ""));
        }
        return d;
    }

    public void U(String str, String str2) {
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

    public boolean V() {
        return false;
    }

    public void W() {
        this.N = (TextView) findViewById(R.id.f1);
        this.O = (TextView) findViewById(R.id.f2);
        this.Q = (TextView) findViewById(R.id.f3);
        this.R = (TextView) findViewById(R.id.f4);
        this.P = (TextView) findViewById(R.id.f5);
        this.N.setText(getString(R.string.doc_no));
        this.O.setText(getString(R.string.date2));
        this.Q.setText(getString(R.string.total_sum));
        this.R.setText(getString(R.string.doc_remarks));
        this.P.setText(getString(R.string.doc_type));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.N);
        c0372Bn.a(this, this.O);
        c0372Bn.a(this, this.Q);
        c0372Bn.a(this, this.R);
        c0372Bn.a(this, this.P);
        TextView textView = this.N;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.O;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.Q;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.R;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.P;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.i.ld(this, this.O, this.S);
        this.N.setOnClickListener(new ViewOnClickListenerC2877a());
        this.O.setOnClickListener(new ViewOnClickListenerC2878b());
        this.P.setOnClickListener(new ViewOnClickListenerC2879c());
        this.Q.setOnClickListener(new ViewOnClickListenerC2880d());
        this.R.setOnClickListener(new ViewOnClickListenerC2881e());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        TextView textView;
        Log.d("trace_E_doc_rep=", FragmentStatePagerSupport_Main.X() + "#" + this.j);
        ListView listView = this.z;
        if (listView != null && (textView = this.B) != null) {
            listView.setEmptyView(textView);
            this.B.setText(getString(R.string.empty_results));
        }
        W();
        this.D = list;
        C0922Sv c0922Sv = this.C;
        if (c0922Sv != null) {
            c0922Sv.f(list);
            this.i.le(this, this.i0, this.C, this.L, 0.0d, 2);
            return;
        }
        C0922Sv c0922Sv2 = new C0922Sv(this, R.layout.data_det_row_bill4_, this.D, 20, V(), 1);
        this.C = c0922Sv2;
        c0922Sv2.l.clear();
        this.C.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.C);
    }

    public void Y(String str) {
        try {
            C0922Sv c0922Sv = this.C;
            if (c0922Sv != null) {
                c0922Sv.getFilter().filter(str);
            }
        } catch (Exception unused) {
        }
    }

    public void Z() {
        g0(true);
        new Thread(new p()).start();
    }

    public void a0() {
        g0(true);
        new Thread(new q()).start();
    }

    public void add_btn(View view) {
        I(view);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public void btn_add(View view) {
        add_btn(view);
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.T = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_item_remove(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        TextView textView = (TextView) linearLayout.findViewById(R.id.id);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new j(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new m());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        U(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC2884h(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new i());
        builder.create().show();
    }

    public void e0(boolean z2) {
    }

    public void f0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new s());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new t());
        builder.show();
    }

    public void g0(boolean z2) {
        Log.d("mProgress=", "....start..." + z2);
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z2) {
                android.app.AlertDialog alertDialogCreate = builder.create();
                this.U = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.U;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void help_btn(View view) {
        f0();
    }

    public void k0(View view, int i2) {
        if (this.S == 0) {
            h0(this.D, i2);
            this.S = 1;
        } else {
            d0(this.D, i2);
            this.S = 0;
        }
    }

    public void m0(View view, int i2) {
        if (this.S == 0) {
            j0(this.D, i2);
            this.S = 1;
        } else {
            c0(this.D, i2);
            this.S = 0;
        }
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.T.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.T + "'");
            }
            this.T = "";
            S();
        } catch (Exception e) {
            Log.d("cat_update_error=", e.getMessage());
        }
    }

    public void n0(View view) {
        g0(true);
        new Thread(new r(view)).start();
    }

    public void no_result_btn(View view) {
        this.d0 = 0;
        S();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill4_);
        Z00.E0 = false;
        Z00.F0 = "";
        setTitle(getString(R.string.add_curr_sales));
        this.z = (ListView) findViewById(R.id.list_items);
        TextView textView = (TextView) findViewById(R.id.emptyResults);
        this.B = textView;
        this.z.setEmptyView(textView);
        this.B.setText(getString(R.string.wait));
        this.i = new Z00(this.h, this);
        this.z.setOnItemClickListener(new k());
        TextView textView2 = (TextView) findViewById(R.id.footer_sum);
        this.L = textView2;
        textView2.setVisibility(4);
        this.M = (ImageView) findViewById(R.id.img_add_amount);
        try {
            W();
            if (getIntent().getStringExtra("g_id") != null) {
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.a0 = calendar.get(1);
        this.b0 = calendar.get(2);
        this.c0 = calendar.get(5);
        e0(true);
        L();
        this.z.setChoiceMode(3);
        this.z.setMultiChoiceModeListener(new l());
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.j0, this.a0, this.b0, this.c0);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.k0, this.a0, this.b0, this.c0);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4145vh>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_doc_rep=", FragmentStatePagerSupport_Main.X() + "#" + this.j);
        return new C0908Sh(this, this.j, this.x, this.i, this.e0, this.f0, 14);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_doc, menu);
        this.i0 = (SearchView) menu.findItem(R.id.search).getActionView();
        this.i0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.i0.setQueryHint(getString(R.string.search_hint));
        this.i0.setOnQueryTextListener(new B());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        e0(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C4145vh>> loader) {
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.adv_search) {
            J();
            return true;
        }
        if (menuItem.getItemId() == R.id.print) {
            K();
            this.X = getTitle().toString();
            a0();
            return true;
        }
        if (menuItem.getItemId() != R.id.action_print_bills) {
            return super.onOptionsItemSelected(menuItem);
        }
        K();
        this.X = getTitle().toString();
        Z();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            L();
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
}
