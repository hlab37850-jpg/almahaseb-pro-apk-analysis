package info.aalmoghalis.inventory.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.Context;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C1839c10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.App;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Bills_customer_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, a.b {
    public static int u0;
    public C0922Sv B;
    public TextView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public int Y;
    public int Z;
    public int a0;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public String r0;
    public int n = 0;
    public double p = 0.0d;
    public TextView q = null;
    public AutoCompleteTextView t = null;
    public TextView u = null;
    public SwitchCompat v = null;
    public int w = 0;
    public int x = 0;
    public ImageView y = null;
    public ListView z = null;
    public Toolbar A = null;
    public List C = new ArrayList();
    public ImageButton D = null;
    public AppCompatCheckBox E = null;
    public int F = 0;
    public String[] G = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView I = null;
    public int J = 0;
    public int K = 0;
    public String T = "";
    public Dialog U = null;
    public Handler V = new j();
    public Cursor W = null;
    public boolean X = false;
    public int b0 = 0;
    public String c0 = CSS.Value.PERCENTAGE;
    public String d0 = CSS.Value.PERCENTAGE;
    public String e0 = CSS.Value.PERCENTAGE;
    public String f0 = CSS.Value.PERCENTAGE;
    public String g0 = CSS.Value.PERCENTAGE;
    public TextView h0 = null;
    public TextView i0 = null;
    public TextView j0 = null;
    public AutoCompleteTextView k0 = null;
    public AutoCompleteTextView l0 = null;
    public AutoCompleteTextView m0 = null;
    public String n0 = CSS.Value.PERCENTAGE;
    public String o0 = CSS.Value.PERCENTAGE;
    public CheckBox p0 = null;
    public CheckBox q0 = null;
    public DatePickerDialog.OnDateSetListener s0 = new A();
    public DatePickerDialog.OnDateSetListener t0 = new B();

    public class A implements DatePickerDialog.OnDateSetListener {
        public A() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bills_customer_Report.this.Y = i;
            Bills_customer_Report.this.Z = i2;
            Bills_customer_Report.this.a0 = i3;
            try {
                String str = Bills_customer_Report.this.Y + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills_customer_Report.this.Z + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills_customer_Report.this.a0));
                Locale locale = Locale.ENGLISH;
                Bills_customer_Report.this.h0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class B implements DatePickerDialog.OnDateSetListener {
        public B() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bills_customer_Report.this.Y = i;
            Bills_customer_Report.this.Z = i2;
            Bills_customer_Report.this.a0 = i3;
            try {
                String str = Bills_customer_Report.this.Y + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills_customer_Report.this.Z + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills_customer_Report.this.a0));
                Locale locale = Locale.ENGLISH;
                Bills_customer_Report.this.i0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
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
            if (i == 5) {
                return Double.valueOf(c4145vh.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.q().replaceAll(",", "")));
            }
            if (i == 1) {
                return Double.valueOf(c4145vh.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.a().replaceAll(",", "")));
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
            if (i == 3) {
                return Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", "")));
            }
            return i == 1 ? Double.valueOf(c4145vh2.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.a().replaceAll(",", ""))) : Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills_customer_Report$a, reason: case insensitive filesystem */
    public class RunnableC2682a implements Runnable {
        public final /* synthetic */ View a;

        public RunnableC2682a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    if (Bills_customer_Report.this.U()) {
                        Bills_customer_Report.this.h0(this.a, 1);
                    } else {
                        Bills_customer_Report.this.j0(this.a, 1);
                    }
                    Bills_customer_Report.this.K = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Bills_customer_Report.this.j0(this.a, 2);
                    Bills_customer_Report.this.K = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    if (Bills_customer_Report.this.U()) {
                        Bills_customer_Report.this.i0(this.a);
                    } else {
                        Bills_customer_Report.this.j0(this.a, 3);
                    }
                    Bills_customer_Report.this.K = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Bills_customer_Report.this.h0(this.a, 4);
                    Bills_customer_Report.this.K = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Bills_customer_Report.this.h0(this.a, 5);
                    Bills_customer_Report.this.K = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            Bills_customer_Report.this.V.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills_customer_Report$b, reason: case insensitive filesystem */
    public class C2683b implements Comparator {
        public final /* synthetic */ int a;

        public C2683b(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a())) : String.valueOf(c4145vh2.n()).compareTo(String.valueOf(c4145vh.n()));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills_customer_Report$c, reason: case insensitive filesystem */
    public class C2684c implements Comparator {
        public final /* synthetic */ int a;

        public C2684c(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a())) : String.valueOf(c4145vh.n()).compareTo(String.valueOf(c4145vh2.n()));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills_customer_Report$d, reason: case insensitive filesystem */
    public class C2685d implements Comparator {
        public C2685d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh2.o().compareTo(String.valueOf(c4145vh.o()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v()) : iCompareTo;
        }
    }

    public class e implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh.o().compareTo(String.valueOf(c4145vh2.o()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh.v()) - Integer.parseInt(c4145vh2.v()) : iCompareTo;
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills_customer_Report.this.k0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public g(TextView textView, ImageView imageView) {
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
                Bills_customer_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Bills_customer_Report.this.l = 0;
                Bills_customer_Report.this.Q();
            } catch (Exception unused) {
                Toast.makeText(Bills_customer_Report.this.getApplicationContext(), Bills_customer_Report.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
                String strC = c4145vh.c();
                Log.d("lv_click", strC + ":" + c4145vh.v() + ":" + Bills_customer_Report.this.c0 + ":" + Bills_customer_Report.this.d0);
                if (!Bills_customer_Report.this.U()) {
                    Intent intent = new Intent(Bills_customer_Report.this, (Class<?>) Bills_customer_Report.class);
                    intent.putExtra("TR_TYPE", String.valueOf(Bills_customer_Report.this.w));
                    intent.putExtra("report_id", "1");
                    intent.putExtra("item_name", c4145vh.a());
                    intent.putExtra("cus_name", c4145vh.n());
                    intent.putExtra("f_date", Bills_customer_Report.this.c0);
                    intent.putExtra("t_date", Bills_customer_Report.this.d0);
                    intent.putExtra("g_id", Bills_customer_Report.this.j);
                    intent.putExtra("g_name", Bills_customer_Report.this.k);
                    intent.putExtra("title_", c4145vh.n() + "-" + c4145vh.a());
                    intent.putExtra("adv_search_flag", String.valueOf(Bills_customer_Report.this.b0));
                    Bills_customer_Report.this.startActivity(intent);
                } else if (!c4145vh.v().equals("0")) {
                    Bills_customer_Report bills_customer_Report = Bills_customer_Report.this;
                    bills_customer_Report.i.m9(bills_customer_Report, c4145vh.v(), Bills_customer_Report.this.w + "", c4145vh.s(), strC, c4145vh.e(), c4145vh.o());
                }
                int unused = Bills_customer_Report.u0 = Bills_customer_Report.this.z.getFirstVisiblePosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class j extends Handler {
        public j() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Bills_customer_Report.this.T();
                Bills_customer_Report bills_customer_Report = Bills_customer_Report.this;
                bills_customer_Report.N(bills_customer_Report.W);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Bills_customer_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Bills_customer_Report bills_customer_Report2 = Bills_customer_Report.this;
                sb.append(bills_customer_Report2.i.ic(bills_customer_Report2.r0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("3")) {
                Bills_customer_Report.this.B.notifyDataSetChanged();
                Bills_customer_Report bills_customer_Report3 = Bills_customer_Report.this;
                Z00 z01 = bills_customer_Report3.i;
                Context baseContext = bills_customer_Report3.getBaseContext();
                Bills_customer_Report bills_customer_Report4 = Bills_customer_Report.this;
                z01.lc(baseContext, bills_customer_Report4.L, bills_customer_Report4.M, bills_customer_Report4.N, bills_customer_Report4.O, bills_customer_Report4.P);
                Bills_customer_Report bills_customer_Report5 = Bills_customer_Report.this;
                int i = bills_customer_Report5.K;
                if (i == 1) {
                    Z00 z02 = bills_customer_Report5.i;
                    Context baseContext2 = bills_customer_Report5.getBaseContext();
                    Bills_customer_Report bills_customer_Report6 = Bills_customer_Report.this;
                    z02.ld(baseContext2, bills_customer_Report6.L, bills_customer_Report6.J);
                } else if (i == 2) {
                    Z00 z03 = bills_customer_Report5.i;
                    Context baseContext3 = bills_customer_Report5.getBaseContext();
                    Bills_customer_Report bills_customer_Report7 = Bills_customer_Report.this;
                    z03.ld(baseContext3, bills_customer_Report7.M, bills_customer_Report7.J);
                } else if (i == 3) {
                    Z00 z04 = bills_customer_Report5.i;
                    Context baseContext4 = bills_customer_Report5.getBaseContext();
                    Bills_customer_Report bills_customer_Report8 = Bills_customer_Report.this;
                    z04.ld(baseContext4, bills_customer_Report8.N, bills_customer_Report8.J);
                } else if (i == 4) {
                    Z00 z05 = bills_customer_Report5.i;
                    Context baseContext5 = bills_customer_Report5.getBaseContext();
                    Bills_customer_Report bills_customer_Report9 = Bills_customer_Report.this;
                    z05.ld(baseContext5, bills_customer_Report9.O, bills_customer_Report9.J);
                } else if (i == 5) {
                    Z00 z06 = bills_customer_Report5.i;
                    Context baseContext6 = bills_customer_Report5.getBaseContext();
                    Bills_customer_Report bills_customer_Report10 = Bills_customer_Report.this;
                    z06.ld(baseContext6, bills_customer_Report10.P, bills_customer_Report10.J);
                }
            }
            Bills_customer_Report.this.d0(false);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bills_customer_Report.this.P();
            Message message = new Message();
            message.obj = "0";
            Bills_customer_Report.this.V.sendMessage(message);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bills_customer_Report bills_customer_Report;
            int i;
            if (Bills_customer_Report.this.w == 1) {
                bills_customer_Report = Bills_customer_Report.this;
                i = R.string.cus;
            } else {
                bills_customer_Report = Bills_customer_Report.this;
                i = R.string.supp;
            }
            String string = bills_customer_Report.getString(i);
            if (Bills_customer_Report.this.i.ja("pref_bills_customer_parent_report_total", false)) {
                Bills_customer_Report bills_customer_Report2 = Bills_customer_Report.this;
                string = bills_customer_Report2.i.w3(bills_customer_Report2.w == 1 ? "123" : "221").size() <= 1 ? Bills_customer_Report.this.getString(R.string.account_group) : Bills_customer_Report.this.getString(R.string.account_parent);
            }
            String str = string;
            Bills_customer_Report bills_customer_Report3 = Bills_customer_Report.this;
            Z00 z00 = bills_customer_Report3.i;
            ListView listView = bills_customer_Report3.z;
            String strIc = z00.ic(bills_customer_Report3.r0);
            Bills_customer_Report bills_customer_Report4 = Bills_customer_Report.this;
            z00.ub(listView, strIc, false, bills_customer_Report4.c0, bills_customer_Report4.d0, str, bills_customer_Report4.U());
            Message message = new Message();
            message.obj = "1";
            Bills_customer_Report.this.V.sendMessage(message);
        }
    }

    public class m extends WebViewClient {
        public m() {
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
            Bills_customer_Report bills_customer_Report = Bills_customer_Report.this;
            ArrayAdapter arrayAdapter = new ArrayAdapter(bills_customer_Report, android.R.layout.simple_spinner_dropdown_item, bills_customer_Report.i.T6());
            Bills_customer_Report bills_customer_Report2 = Bills_customer_Report.this;
            bills_customer_Report2.i.T(bills_customer_Report2, arrayAdapter, bills_customer_Report2.j0);
        }
    }

    public class p implements AdapterView.OnItemClickListener {
        public p() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bills_customer_Report.this.k0.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class q implements AdapterView.OnItemClickListener {
        public q() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bills_customer_Report.this.l0.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class r implements AdapterView.OnItemClickListener {
        public r() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bills_customer_Report.this.m0.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class s implements CompoundButton.OnCheckedChangeListener {
        public s() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                Bills_customer_Report.this.i.Mc("pref_bills_customer_parent_report_total", z);
            } else {
                Bills_customer_Report.this.i.Mc("pref_bills_customer_parent_report_total", z);
                Bills_customer_Report.this.p0.setChecked(!z);
            }
        }
    }

    public class t implements CompoundButton.OnCheckedChangeListener {
        public t() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                Bills_customer_Report.this.i.Mc("pref_bills_customer_report_total", z);
            } else {
                Bills_customer_Report.this.i.Mc("pref_bills_customer_report_total", z);
                Bills_customer_Report.this.q0.setChecked(!z);
            }
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bills_customer_Report.this.showDialog(0);
        }
    }

    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bills_customer_Report.this.showDialog(4);
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class x implements DialogInterface.OnClickListener {
        public x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bills_customer_Report bills_customer_Report = Bills_customer_Report.this;
                bills_customer_Report.b0 = 0;
                bills_customer_Report.Q();
            } catch (Exception unused) {
            }
        }
    }

    public class y implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public y(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills_customer_Report bills_customer_Report = Bills_customer_Report.this;
                bills_customer_Report.b0 = 1;
                if (bills_customer_Report.h0.getText() == null) {
                    Bills_customer_Report.this.c0 = "";
                } else {
                    Bills_customer_Report bills_customer_Report2 = Bills_customer_Report.this;
                    bills_customer_Report2.c0 = bills_customer_Report2.h0.getText().toString();
                }
                if (Bills_customer_Report.this.i0.getText() == null) {
                    Bills_customer_Report.this.d0 = "";
                } else {
                    Bills_customer_Report bills_customer_Report3 = Bills_customer_Report.this;
                    bills_customer_Report3.d0 = bills_customer_Report3.i0.getText().toString();
                }
                if (Bills_customer_Report.this.j0.getText() == null) {
                    Bills_customer_Report.this.e0 = "";
                } else {
                    Bills_customer_Report bills_customer_Report4 = Bills_customer_Report.this;
                    bills_customer_Report4.e0 = bills_customer_Report4.j0.getText().toString();
                }
                if (Bills_customer_Report.this.k0.getVisibility() != 8) {
                    if (Bills_customer_Report.this.k0.getText() == null) {
                        Bills_customer_Report.this.f0 = "";
                    } else {
                        Bills_customer_Report bills_customer_Report5 = Bills_customer_Report.this;
                        bills_customer_Report5.f0 = bills_customer_Report5.k0.getText().toString();
                    }
                }
                if (Bills_customer_Report.this.l0.getVisibility() != 8) {
                    if (Bills_customer_Report.this.l0.getText() == null) {
                        Bills_customer_Report.this.n0 = "";
                    } else {
                        Bills_customer_Report bills_customer_Report6 = Bills_customer_Report.this;
                        bills_customer_Report6.n0 = bills_customer_Report6.l0.getText().toString();
                    }
                }
                if (Bills_customer_Report.this.m0.getVisibility() != 8) {
                    if (Bills_customer_Report.this.m0.getText() == null) {
                        Bills_customer_Report.this.o0 = "";
                    } else {
                        Bills_customer_Report bills_customer_Report7 = Bills_customer_Report.this;
                        bills_customer_Report7.o0 = bills_customer_Report7.m0.getText().toString();
                    }
                }
                Bills_customer_Report.this.Q();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class z implements SearchView.OnQueryTextListener {
        public z() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Bills_customer_Report.this.O(1);
            }
            Bills_customer_Report.this.V(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Bills_customer_Report.this.O(0);
            return false;
        }
    }

    private void X(List list) {
        Collections.sort(list, Collections.reverseOrder(new e()));
    }

    private void Z(List list, int i2) {
        Collections.sort(list, new D(i2));
    }

    private void e0(List list, int i2) {
        Collections.sort(list, new C(i2));
    }

    private void f0(List list) {
        Collections.sort(list, Collections.reverseOrder(new C2685d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(View view) {
        if (this.J == 0) {
            f0(this.C);
            this.J = 1;
        } else {
            X(this.C);
            this.J = 0;
        }
    }

    public void L() {
        try {
            this.b0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input_item_type_cus, (ViewGroup) null);
            builder.setView(viewInflate);
            this.h0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.i0 = (TextView) viewInflate.findViewById(R.id.t_date);
            TextView textView = (TextView) viewInflate.findViewById(R.id.item_type);
            this.j0 = textView;
            textView.setOnClickListener(new o());
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_name);
            this.k0 = autoCompleteTextView;
            autoCompleteTextView.setHint(this.w == 1 ? getString(R.string.cus) : getString(R.string.supp));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.J4(this.w));
            this.k0.setThreshold(1);
            this.k0.setAdapter(arrayAdapter);
            this.k0.setOnItemClickListener(new p());
            this.i.Zc(this, this.k0);
            this.l0 = (AutoCompleteTextView) viewInflate.findViewById(R.id.account_group);
            this.m0 = (AutoCompleteTextView) viewInflate.findViewById(R.id.account_parent);
            ArrayList arrayListW3 = this.i.w3(this.w == 1 ? "123" : "221");
            if (arrayListW3.size() <= 1) {
                this.m0.setVisibility(8);
                this.l0.setVisibility(0);
            } else {
                this.m0.setVisibility(0);
                this.l0.setVisibility(8);
            }
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.U5());
            this.l0.setThreshold(1);
            this.l0.setAdapter(arrayAdapter2);
            this.l0.setOnItemClickListener(new q());
            this.i.Zc(this, this.l0);
            ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListW3);
            this.m0.setThreshold(1);
            this.m0.setAdapter(arrayAdapter3);
            this.m0.setOnItemClickListener(new r());
            this.i.Zc(this, this.m0);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.chk_hide);
            this.p0 = checkBox;
            checkBox.setChecked(this.i.ja("pref_bills_customer_report_total", false));
            CheckBox checkBox2 = this.p0;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.total_per_account));
            sb.append(" ");
            sb.append(this.w == 1 ? getString(R.string.cus) : getString(R.string.supp));
            checkBox2.setText(sb.toString());
            CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R.id.chk_hide_parent);
            this.q0 = checkBox3;
            checkBox3.setChecked(this.i.ja("pref_bills_customer_parent_report_total", false));
            CheckBox checkBox4 = this.q0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getString(R.string.total_per_account));
            sb2.append(" ");
            sb2.append(this.m0.getVisibility() == 0 ? getString(R.string.account_parent) : getString(R.string.account_group));
            checkBox4.setText(sb2.toString());
            this.q0.setOnCheckedChangeListener(new s());
            this.p0.setOnCheckedChangeListener(new t());
            if (this.x != 0) {
                this.j0.setVisibility(8);
                this.k0.setVisibility(8);
                this.p0.setVisibility(8);
            }
            this.h0.setOnClickListener(new u());
            this.i0.setOnClickListener(new v());
            builder.setPositiveButton(getString(R.string.btn_search), new w());
            builder.setNegativeButton(getString(R.string.btn_cancel), new x());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new y(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void M() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void N(Cursor cursor) {
        String str;
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rev1, this.C, U() ? 17 : 27);
        this.B = c0922Sv;
        c0922Sv.l.clear();
        this.B.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.B);
        TextView textView = this.I;
        StringBuilder sb = new StringBuilder();
        if (new C1839c10().i(this.e0, this.b0)) {
            str = this.e0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(this.i.P7(String.valueOf(this.p)));
        textView.setText(sb.toString());
        ((App) getApplication()).c(this.C);
    }

    public void O(int i2) {
        try {
            if (i2 == 1) {
                this.I.setText(this.i.P7(String.valueOf(this.p)));
            } else {
                this.I.setText(this.i.P7(String.valueOf(R(this.B.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void P() {
        Cursor cursorZ6;
        Log.d("get_all_names", this.b0 + ":" + this.f0 + ":" + this.g0);
        this.W = null;
        int i2 = this.b0;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            Z00 z00 = this.i;
            if (!this.j.equals("0")) {
                str = this.j;
            }
            cursorZ6 = z00.z6(str, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.w + "", CSS.Value.PERCENTAGE, this.f0, this.g0, this.o0, this.n0, U());
        } else {
            this.c0 = this.c0.isEmpty() ? CSS.Value.PERCENTAGE : this.c0;
            this.d0 = this.d0.isEmpty() ? CSS.Value.PERCENTAGE : this.d0;
            this.e0 = this.e0.isEmpty() ? CSS.Value.PERCENTAGE : this.e0;
            this.f0 = this.f0.isEmpty() ? CSS.Value.PERCENTAGE : this.f0;
            this.g0 = this.g0.isEmpty() ? CSS.Value.PERCENTAGE : this.g0;
            this.n0 = this.n0.isEmpty() ? CSS.Value.PERCENTAGE : this.n0;
            this.o0 = this.o0.isEmpty() ? CSS.Value.PERCENTAGE : this.o0;
            Z00 z01 = this.i;
            if (!this.j.equals("0")) {
                str = this.j;
            }
            String str2 = str;
            cursorZ6 = z01.z6(str2, this.c0, this.d0, this.w + "", this.e0, this.f0, this.g0, this.o0, this.n0, U());
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorZ6.getCount()));
        this.p = 0.0d;
        this.C.clear();
        cursorZ6.moveToFirst();
        while (!cursorZ6.isAfterLast()) {
            this.p += cursorZ6.getDouble(cursorZ6.getColumnIndex("f5"));
            this.C.add(new C4145vh(cursorZ6.getString(cursorZ6.getColumnIndex("_id")), cursorZ6.getString(cursorZ6.getColumnIndex("f1")), cursorZ6.getString(cursorZ6.getColumnIndex("f2")), cursorZ6.getString(cursorZ6.getColumnIndex("f3")), this.i.P7(cursorZ6.getString(cursorZ6.getColumnIndex("f4"))), this.i.O7(cursorZ6.getDouble(cursorZ6.getColumnIndex("f5"))), cursorZ6.getString(cursorZ6.getColumnIndex("f6")), cursorZ6.getString(cursorZ6.getColumnIndex("f7")), cursorZ6.getString(cursorZ6.getColumnIndex("f8")), cursorZ6.getString(cursorZ6.getColumnIndex("f9")), cursorZ6.getString(cursorZ6.getColumnIndex("f10")), cursorZ6.getString(cursorZ6.getColumnIndex("f11")), cursorZ6.getString(cursorZ6.getColumnIndex("f12"))));
            cursorZ6.moveToNext();
        }
        cursorZ6.close();
    }

    public void Q() {
        d0(true);
        new Thread(new k()).start();
    }

    public double R(List list) {
        Log.d("net_bal:", list.size() + "");
        double d = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d += Double.parseDouble(((C4145vh) list.get(i2)).q().replaceAll(",", ""));
        }
        return d;
    }

    public void S(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.w));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
        finish();
    }

    public void T() {
        this.L = (TextView) findViewById(R.id.f1);
        this.M = (TextView) findViewById(R.id.f2);
        this.N = (TextView) findViewById(R.id.f3);
        this.O = (TextView) findViewById(R.id.f4);
        this.P = (TextView) findViewById(R.id.f5);
        this.Q = (TextView) findViewById(R.id.f6);
        this.R = (TextView) findViewById(R.id.f7);
        this.S = (TextView) findViewById(R.id.f8);
        if (U()) {
            this.L.setText(getString(R.string.bill_no2));
            this.M.setText(getString(R.string.item));
            this.N.setText(getString(R.string.date));
            this.O.setText(getString(R.string.qty));
            this.P.setText(getString(R.string.total_sum));
        } else {
            this.L.setText(getString(R.string.item));
            String string = getString(this.w == 1 ? R.string.cus : R.string.supp);
            if (this.i.ja("pref_bills_customer_parent_report_total", false)) {
                string = this.i.w3(this.w == 1 ? "123" : "221").size() <= 1 ? getString(R.string.account_group) : getString(R.string.account_parent);
            }
            this.M.setText(string);
            this.N.setText(getString(R.string.currency));
            this.O.setText(getString(R.string.qty));
            this.P.setText(getString(R.string.total_sum));
        }
        TextView textView = this.L;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.M;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.N;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.O;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.P;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.i.ld(this, this.L, this.J);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.L);
        c0372Bn.a(this, this.M);
        c0372Bn.a(this, this.N);
        c0372Bn.a(this, this.O);
        c0372Bn.a(this, this.P);
        a0(new TextView[]{this.L, this.M, this.N, this.O, this.P});
    }

    public boolean U() {
        return !(this.i.ja("pref_bills_customer_report_total", false) || this.i.ja("pref_bills_customer_parent_report_total", false)) || this.x == 1;
    }

    public void V(String str) {
        this.B.getFilter().filter(str);
    }

    public void W() {
        d0(true);
        new Thread(new l()).start();
    }

    public final void Y(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new C2684c(i2)));
    }

    public void a0(TextView[] textViewArr) {
        for (TextView textView : textViewArr) {
            textView.setOnClickListener(new f());
        }
    }

    public void add_btn(View view) {
        Bill_edit.P2 = true;
        this.i.z(this, this.j, this.k);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public void b0(boolean z2) {
    }

    public void btn_add(View view) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.T = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        S(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new g(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new h());
        builder.create().show();
    }

    public void c0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new m());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new n());
        builder.show();
    }

    public void d0(boolean z2) {
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void g0(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new C2683b(i2)));
    }

    public void h0(View view, int i2) {
        if (this.J == 0) {
            e0(this.C, i2);
            this.J = 1;
        } else {
            Z(this.C, i2);
            this.J = 0;
        }
    }

    public void help_btn(View view) {
        c0();
    }

    public void j0(View view, int i2) {
        if (this.J == 0) {
            g0(this.C, i2);
            this.J = 1;
        } else {
            Y(this.C, i2);
            this.J = 0;
        }
    }

    public void k0(View view) {
        d0(true);
        new Thread(new RunnableC2682a(view)).start();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.T.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.T + "'");
            }
            this.T = "";
            Q();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.b0 = 0;
        Q();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_rev1);
        setTitle(getIntent().getStringExtra("title_"));
        this.z = (ListView) findViewById(R.id.list_items);
        this.z.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        this.z.setOnItemClickListener(new i());
        this.I = (TextView) findViewById(R.id.footer_sum);
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.w = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getIntent().getStringExtra("title_"));
            }
            if (getIntent().getStringExtra("report_id") != null) {
                this.x = Integer.parseInt(getIntent().getStringExtra("report_id"));
            }
            if (getIntent().getStringExtra("adv_search_flag") != null) {
                this.b0 = Integer.parseInt(getIntent().getStringExtra("adv_search_flag"));
            }
            String stringExtra = getIntent().getStringExtra("item_name");
            String stringExtra2 = CSS.Value.PERCENTAGE;
            this.g0 = stringExtra == null ? CSS.Value.PERCENTAGE : getIntent().getStringExtra("item_name");
            this.f0 = getIntent().getStringExtra("cus_name") == null ? CSS.Value.PERCENTAGE : getIntent().getStringExtra("cus_name");
            this.c0 = getIntent().getStringExtra("f_date") == null ? CSS.Value.PERCENTAGE : getIntent().getStringExtra("f_date");
            if (getIntent().getStringExtra("t_date") != null) {
                stringExtra2 = getIntent().getStringExtra("t_date");
            }
            this.d0 = stringExtra2;
            T();
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.Y = calendar.get(1);
        this.Z = calendar.get(2);
        this.a0 = calendar.get(5);
        b0(true);
        Q();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.s0, this.Y, this.Z, this.a0);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.t0, this.Y, this.Z, this.a0);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new z());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        N(this.i.L2());
        b0(true);
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
        String str;
        String str2;
        String str3;
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.adv_search) {
            L();
            return true;
        }
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            M();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle().toString());
        String str4 = "";
        if (this.e0.equals(CSS.Value.PERCENTAGE) || U()) {
            str = "";
        } else {
            str = "-" + this.e0;
        }
        sb.append(str);
        if (this.f0.equals(CSS.Value.PERCENTAGE) || U()) {
            str2 = "";
        } else {
            str2 = "-" + this.f0;
        }
        sb.append(str2);
        if (this.o0.equals(CSS.Value.PERCENTAGE) || U()) {
            str3 = "";
        } else {
            str3 = "-" + this.o0;
        }
        sb.append(str3);
        if (!this.n0.equals(CSS.Value.PERCENTAGE) && !U()) {
            str4 = "-" + this.n0;
        }
        sb.append(str4);
        this.r0 = sb.toString();
        W();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.i.ja("prefOthers_closed_year", false) && Bill_edit.Q2) {
            Bill_edit.Q2 = false;
            recreate();
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
