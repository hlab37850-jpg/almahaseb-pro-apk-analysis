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
public class Bills_customer_Report_bk extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, a.b {
    public static int k0;
    public C0922Sv A;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public int X;
    public int Y;
    public int Z;
    public SQLiteDatabase h;
    public String h0;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public int n = 0;
    public double p = 0.0d;
    public TextView q = null;
    public AutoCompleteTextView t = null;
    public TextView u = null;
    public SwitchCompat v = null;
    public int w = 0;
    public ImageView x = null;
    public ListView y = null;
    public Toolbar z = null;
    public List B = new ArrayList();
    public ImageButton C = null;
    public AppCompatCheckBox D = null;
    public int E = 0;
    public String[] F = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] G = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView H = null;
    public int I = 0;
    public int J = 0;
    public String S = "";
    public Dialog T = null;
    public Handler U = new n();
    public Cursor V = null;
    public boolean W = false;
    public int a0 = 0;
    public String b0 = CSS.Value.PERCENTAGE;
    public String c0 = CSS.Value.PERCENTAGE;
    public String d0 = CSS.Value.PERCENTAGE;
    public TextView e0 = null;
    public TextView f0 = null;
    public TextView g0 = null;
    public DatePickerDialog.OnDateSetListener i0 = new z();
    public DatePickerDialog.OnDateSetListener j0 = new A();

    public class A implements DatePickerDialog.OnDateSetListener {
        public A() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bills_customer_Report_bk.this.X = i;
            Bills_customer_Report_bk.this.Y = i2;
            Bills_customer_Report_bk.this.Z = i3;
            try {
                String str = Bills_customer_Report_bk.this.X + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills_customer_Report_bk.this.Y + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills_customer_Report_bk.this.Z));
                Locale locale = Locale.ENGLISH;
                Bills_customer_Report_bk.this.f0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
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
            if (i == 5) {
                return Double.valueOf(c4145vh.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.q().replaceAll(",", "")));
            }
            if (i == 1) {
                return Double.valueOf(c4145vh.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.a().replaceAll(",", "")));
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
            if (i == 5) {
                return Double.valueOf(c4145vh2.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.q().replaceAll(",", "")));
            }
            if (i == 3) {
                return Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", "")));
            }
            return i == 1 ? Double.valueOf(c4145vh2.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.a().replaceAll(",", ""))) : Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills_customer_Report_bk$a, reason: case insensitive filesystem */
    public class RunnableC2686a implements Runnable {
        public final /* synthetic */ View a;

        public RunnableC2686a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    Bills_customer_Report_bk.this.d0(this.a, 1);
                    Bills_customer_Report_bk.this.J = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Bills_customer_Report_bk.this.f0(this.a, 2);
                    Bills_customer_Report_bk.this.J = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    Bills_customer_Report_bk.this.e0(this.a);
                    Bills_customer_Report_bk.this.J = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Bills_customer_Report_bk.this.d0(this.a, 4);
                    Bills_customer_Report_bk.this.J = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Bills_customer_Report_bk.this.d0(this.a, 5);
                    Bills_customer_Report_bk.this.J = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            Bills_customer_Report_bk.this.U.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills_customer_Report_bk$b, reason: case insensitive filesystem */
    public class C2687b implements Comparator {
        public final /* synthetic */ int a;

        public C2687b(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a())) : String.valueOf(c4145vh2.n()).compareTo(String.valueOf(c4145vh.n()));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills_customer_Report_bk$c, reason: case insensitive filesystem */
    public class C2688c implements Comparator {
        public final /* synthetic */ int a;

        public C2688c(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a())) : String.valueOf(c4145vh.n()).compareTo(String.valueOf(c4145vh2.n()));
        }
    }

    public class d implements Comparator {
        public d() {
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
                Bills_customer_Report_bk.this.g0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills_customer_Report_bk.this.g0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills_customer_Report_bk.this.g0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills_customer_Report_bk.this.g0(view);
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
                Bills_customer_Report_bk.this.g0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class k implements AdapterView.OnItemClickListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
                String strC = c4145vh.c();
                Log.d("lv_click", strC + ":" + c4145vh.v() + ":" + Bills_customer_Report_bk.this.b0 + ":" + Bills_customer_Report_bk.this.c0);
                if (!c4145vh.v().equals("0")) {
                    Bills_customer_Report_bk bills_customer_Report_bk = Bills_customer_Report_bk.this;
                    bills_customer_Report_bk.i.m9(bills_customer_Report_bk, c4145vh.v(), Bills_customer_Report_bk.this.w + "", c4145vh.s(), strC, c4145vh.e(), c4145vh.o());
                }
                int unused = Bills_customer_Report_bk.k0 = Bills_customer_Report_bk.this.y.getFirstVisiblePosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public l(TextView textView, ImageView imageView) {
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
                Bills_customer_Report_bk.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Bills_customer_Report_bk.this.l = 0;
                Bills_customer_Report_bk.this.O();
            } catch (Exception unused) {
                Toast.makeText(Bills_customer_Report_bk.this.getApplicationContext(), Bills_customer_Report_bk.this.getString(R.string.sql_error), 1);
            }
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
                Bills_customer_Report_bk bills_customer_Report_bk = Bills_customer_Report_bk.this;
                bills_customer_Report_bk.L(bills_customer_Report_bk.V);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Bills_customer_Report_bk.this.i;
                StringBuilder sb = new StringBuilder();
                Bills_customer_Report_bk bills_customer_Report_bk2 = Bills_customer_Report_bk.this;
                sb.append(bills_customer_Report_bk2.i.ic(bills_customer_Report_bk2.h0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("3")) {
                Bills_customer_Report_bk.this.A.notifyDataSetChanged();
                Bills_customer_Report_bk bills_customer_Report_bk3 = Bills_customer_Report_bk.this;
                Z00 z01 = bills_customer_Report_bk3.i;
                Context baseContext = bills_customer_Report_bk3.getBaseContext();
                Bills_customer_Report_bk bills_customer_Report_bk4 = Bills_customer_Report_bk.this;
                z01.lc(baseContext, bills_customer_Report_bk4.K, bills_customer_Report_bk4.L, bills_customer_Report_bk4.M, bills_customer_Report_bk4.N, bills_customer_Report_bk4.O);
                Bills_customer_Report_bk bills_customer_Report_bk5 = Bills_customer_Report_bk.this;
                int i = bills_customer_Report_bk5.J;
                if (i == 1) {
                    Z00 z02 = bills_customer_Report_bk5.i;
                    Context baseContext2 = bills_customer_Report_bk5.getBaseContext();
                    Bills_customer_Report_bk bills_customer_Report_bk6 = Bills_customer_Report_bk.this;
                    z02.ld(baseContext2, bills_customer_Report_bk6.K, bills_customer_Report_bk6.I);
                } else if (i == 2) {
                    Z00 z03 = bills_customer_Report_bk5.i;
                    Context baseContext3 = bills_customer_Report_bk5.getBaseContext();
                    Bills_customer_Report_bk bills_customer_Report_bk7 = Bills_customer_Report_bk.this;
                    z03.ld(baseContext3, bills_customer_Report_bk7.L, bills_customer_Report_bk7.I);
                } else if (i == 3) {
                    Z00 z04 = bills_customer_Report_bk5.i;
                    Context baseContext4 = bills_customer_Report_bk5.getBaseContext();
                    Bills_customer_Report_bk bills_customer_Report_bk8 = Bills_customer_Report_bk.this;
                    z04.ld(baseContext4, bills_customer_Report_bk8.M, bills_customer_Report_bk8.I);
                } else if (i == 4) {
                    Z00 z05 = bills_customer_Report_bk5.i;
                    Context baseContext5 = bills_customer_Report_bk5.getBaseContext();
                    Bills_customer_Report_bk bills_customer_Report_bk9 = Bills_customer_Report_bk.this;
                    z05.ld(baseContext5, bills_customer_Report_bk9.N, bills_customer_Report_bk9.I);
                } else if (i == 5) {
                    Z00 z06 = bills_customer_Report_bk5.i;
                    Context baseContext6 = bills_customer_Report_bk5.getBaseContext();
                    Bills_customer_Report_bk bills_customer_Report_bk10 = Bills_customer_Report_bk.this;
                    z06.ld(baseContext6, bills_customer_Report_bk10.O, bills_customer_Report_bk10.I);
                }
            }
            Bills_customer_Report_bk.this.Z(false);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bills_customer_Report_bk.this.N();
            Message message = new Message();
            message.obj = "0";
            Bills_customer_Report_bk.this.U.sendMessage(message);
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Bills_customer_Report_bk.this.w == 1) {
                Bills_customer_Report_bk bills_customer_Report_bk = Bills_customer_Report_bk.this;
                Z00 z00 = bills_customer_Report_bk.i;
                ListView listView = bills_customer_Report_bk.y;
                String strIc = z00.ic(bills_customer_Report_bk.h0);
                Bills_customer_Report_bk bills_customer_Report_bk2 = Bills_customer_Report_bk.this;
                z00.ub(listView, strIc, false, bills_customer_Report_bk2.b0, bills_customer_Report_bk2.c0, bills_customer_Report_bk2.getString(R.string.cus), true);
            } else if (Bills_customer_Report_bk.this.w == 2) {
                Bills_customer_Report_bk bills_customer_Report_bk3 = Bills_customer_Report_bk.this;
                Z00 z01 = bills_customer_Report_bk3.i;
                ListView listView2 = bills_customer_Report_bk3.y;
                String strIc2 = z01.ic(bills_customer_Report_bk3.h0);
                Bills_customer_Report_bk bills_customer_Report_bk4 = Bills_customer_Report_bk.this;
                z01.ub(listView2, strIc2, false, bills_customer_Report_bk4.b0, bills_customer_Report_bk4.c0, bills_customer_Report_bk4.getString(R.string.supp), true);
            }
            Message message = new Message();
            message.obj = "1";
            Bills_customer_Report_bk.this.U.sendMessage(message);
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
            Bills_customer_Report_bk bills_customer_Report_bk = Bills_customer_Report_bk.this;
            ArrayAdapter arrayAdapter = new ArrayAdapter(bills_customer_Report_bk, android.R.layout.simple_spinner_dropdown_item, bills_customer_Report_bk.i.T6());
            Bills_customer_Report_bk bills_customer_Report_bk2 = Bills_customer_Report_bk.this;
            bills_customer_Report_bk2.i.T(bills_customer_Report_bk2, arrayAdapter, bills_customer_Report_bk2.g0);
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bills_customer_Report_bk.this.showDialog(0);
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bills_customer_Report_bk.this.showDialog(4);
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bills_customer_Report_bk bills_customer_Report_bk = Bills_customer_Report_bk.this;
                bills_customer_Report_bk.a0 = 0;
                bills_customer_Report_bk.O();
            } catch (Exception unused) {
            }
        }
    }

    public class x implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public x(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills_customer_Report_bk bills_customer_Report_bk = Bills_customer_Report_bk.this;
                bills_customer_Report_bk.a0 = 1;
                if (bills_customer_Report_bk.e0.getText() == null) {
                    Bills_customer_Report_bk.this.b0 = "";
                } else {
                    Bills_customer_Report_bk bills_customer_Report_bk2 = Bills_customer_Report_bk.this;
                    bills_customer_Report_bk2.b0 = bills_customer_Report_bk2.e0.getText().toString();
                }
                if (Bills_customer_Report_bk.this.f0.getText() == null) {
                    Bills_customer_Report_bk.this.c0 = "";
                } else {
                    Bills_customer_Report_bk bills_customer_Report_bk3 = Bills_customer_Report_bk.this;
                    bills_customer_Report_bk3.c0 = bills_customer_Report_bk3.f0.getText().toString();
                }
                if (Bills_customer_Report_bk.this.g0.getText() == null) {
                    Bills_customer_Report_bk.this.d0 = "";
                } else {
                    Bills_customer_Report_bk bills_customer_Report_bk4 = Bills_customer_Report_bk.this;
                    bills_customer_Report_bk4.d0 = bills_customer_Report_bk4.g0.getText().toString();
                }
                Bills_customer_Report_bk.this.O();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class y implements SearchView.OnQueryTextListener {
        public y() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Bills_customer_Report_bk.this.M(1);
            }
            Bills_customer_Report_bk.this.S(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Bills_customer_Report_bk.this.M(0);
            return false;
        }
    }

    public class z implements DatePickerDialog.OnDateSetListener {
        public z() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bills_customer_Report_bk.this.X = i;
            Bills_customer_Report_bk.this.Y = i2;
            Bills_customer_Report_bk.this.Z = i3;
            try {
                String str = Bills_customer_Report_bk.this.X + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills_customer_Report_bk.this.Y + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills_customer_Report_bk.this.Z));
                Locale locale = Locale.ENGLISH;
                Bills_customer_Report_bk.this.e0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    private void U(List list) {
        Collections.sort(list, Collections.reverseOrder(new e()));
    }

    private void V(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new C2688c(i2)));
    }

    private void W(List list, int i2) {
        Collections.sort(list, new C(i2));
    }

    private void a0(List list, int i2) {
        Collections.sort(list, new B(i2));
    }

    private void b0(List list) {
        Collections.sort(list, Collections.reverseOrder(new d()));
    }

    private void c0(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new C2687b(i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(View view) {
        if (this.I == 0) {
            b0(this.B);
            this.I = 1;
        } else {
            U(this.B);
            this.I = 0;
        }
    }

    public void J() {
        try {
            this.a0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input_item_type, (ViewGroup) null);
            builder.setView(viewInflate);
            this.e0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.f0 = (TextView) viewInflate.findViewById(R.id.t_date);
            TextView textView = (TextView) viewInflate.findViewById(R.id.item_type);
            this.g0 = textView;
            textView.setOnClickListener(new s());
            this.e0.setOnClickListener(new t());
            this.f0.setOnClickListener(new u());
            builder.setPositiveButton(getString(R.string.btn_search), new v());
            builder.setNegativeButton(getString(R.string.btn_cancel), new w());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new x(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void K() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void L(Cursor cursor) {
        String str;
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rev1, this.B, 17);
        this.A = c0922Sv;
        c0922Sv.l.clear();
        this.A.notifyDataSetChanged();
        this.y.setAdapter((ListAdapter) this.A);
        TextView textView = this.H;
        StringBuilder sb = new StringBuilder();
        if (new C1839c10().i(this.d0, this.a0)) {
            str = this.d0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(this.i.P7(String.valueOf(this.p)));
        textView.setText(sb.toString());
        ((App) getApplication()).c(this.B);
    }

    public void M(int i2) {
        try {
            if (i2 == 1) {
                this.H.setText(this.i.P7(String.valueOf(this.p)));
            } else {
                this.H.setText(this.i.P7(String.valueOf(P(this.A.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void N() {
        Cursor cursorZ6;
        this.V = null;
        int i2 = this.a0;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            Z00 z00 = this.i;
            if (!this.j.equals("0")) {
                str = this.j;
            }
            cursorZ6 = z00.z6(str, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.w + "", CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, false);
        } else {
            this.b0 = this.b0.isEmpty() ? CSS.Value.PERCENTAGE : this.b0;
            this.c0 = this.c0.isEmpty() ? CSS.Value.PERCENTAGE : this.c0;
            this.d0 = this.d0.isEmpty() ? CSS.Value.PERCENTAGE : this.d0;
            Z00 z01 = this.i;
            if (!this.j.equals("0")) {
                str = this.j;
            }
            String str2 = str;
            cursorZ6 = z01.z6(str2, this.b0, this.c0, this.w + "", this.d0, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, false);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorZ6.getCount()));
        this.p = 0.0d;
        this.B.clear();
        cursorZ6.moveToFirst();
        while (!cursorZ6.isAfterLast()) {
            this.p += Double.parseDouble(cursorZ6.getString(cursorZ6.getColumnIndex("f5")));
            this.B.add(new C4145vh(cursorZ6.getString(cursorZ6.getColumnIndex("_id")), cursorZ6.getString(cursorZ6.getColumnIndex("f1")), cursorZ6.getString(cursorZ6.getColumnIndex("f2")), cursorZ6.getString(cursorZ6.getColumnIndex("f3")), this.i.P7(cursorZ6.getString(cursorZ6.getColumnIndex("f4"))), this.i.P7(cursorZ6.getString(cursorZ6.getColumnIndex("f5"))), cursorZ6.getString(cursorZ6.getColumnIndex("f6")), cursorZ6.getString(cursorZ6.getColumnIndex("f7")), cursorZ6.getString(cursorZ6.getColumnIndex("f8")), cursorZ6.getString(cursorZ6.getColumnIndex("f9")), cursorZ6.getString(cursorZ6.getColumnIndex("f10")), cursorZ6.getString(cursorZ6.getColumnIndex("f11")), cursorZ6.getString(cursorZ6.getColumnIndex("f12"))));
            cursorZ6.moveToNext();
        }
        cursorZ6.close();
    }

    public void O() {
        Z(true);
        new Thread(new o()).start();
    }

    public double P(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).q().replaceAll(",", ""));
        }
        return d2;
    }

    public void Q(String str, String str2) {
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

    public void R() {
        this.K = (TextView) findViewById(R.id.f1);
        this.L = (TextView) findViewById(R.id.f2);
        this.M = (TextView) findViewById(R.id.f3);
        this.N = (TextView) findViewById(R.id.f4);
        this.O = (TextView) findViewById(R.id.f5);
        this.P = (TextView) findViewById(R.id.f6);
        this.Q = (TextView) findViewById(R.id.f7);
        this.R = (TextView) findViewById(R.id.f8);
        this.K.setText(getString(R.string.bill_no2));
        this.L.setText(getString(R.string.item));
        TextView textView = this.K;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.L;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.M;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.N;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.O;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.i.ld(this, this.K, this.I);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.K);
        c0372Bn.a(this, this.L);
        c0372Bn.a(this, this.M);
        c0372Bn.a(this, this.N);
        c0372Bn.a(this, this.O);
        this.M.setText(getString(R.string.date));
        this.N.setText(getString(R.string.qty));
        this.O.setText(getString(R.string.total_sum));
        this.L.setOnClickListener(new f());
        this.K.setOnClickListener(new g());
        this.M.setOnClickListener(new h());
        this.N.setOnClickListener(new i());
        this.O.setOnClickListener(new j());
    }

    public void S(String str) {
        this.A.getFilter().filter(str);
    }

    public void T() {
        Z(true);
        new Thread(new p()).start();
    }

    public void X(boolean z2) {
    }

    public void Y() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new q());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new r());
        builder.show();
    }

    public void Z(boolean z2) {
        Log.d("mProgress=", "....start..." + z2);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z2) {
            android.app.AlertDialog alertDialogCreate = builder.create();
            this.T = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.T;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void add_btn(View view) {
        Bill_edit.P2 = true;
        this.i.z(this, this.j, this.k);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public void btn_add(View view) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.S = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        Q(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new l(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new m());
        builder.create().show();
    }

    public void d0(View view, int i2) {
        if (this.I == 0) {
            a0(this.B, i2);
            this.I = 1;
        } else {
            W(this.B, i2);
            this.I = 0;
        }
    }

    public void f0(View view, int i2) {
        if (this.I == 0) {
            c0(this.B, i2);
            this.I = 1;
        } else {
            V(this.B, i2);
            this.I = 0;
        }
    }

    public void g0(View view) {
        Z(true);
        new Thread(new RunnableC2686a(view)).start();
    }

    public void help_btn(View view) {
        Y();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.S.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.S + "'");
            }
            this.S = "";
            O();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.a0 = 0;
        O();
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
        this.y = (ListView) findViewById(R.id.list_items);
        this.y.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        this.y.setOnItemClickListener(new k());
        this.H = (TextView) findViewById(R.id.footer_sum);
        try {
            R();
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.w = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getIntent().getStringExtra("title_"));
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.X = calendar.get(1);
        this.Y = calendar.get(2);
        this.Z = calendar.get(5);
        X(true);
        O();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.i0, this.X, this.Y, this.Z);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.j0, this.X, this.Y, this.Z);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new y());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        L(this.i.L2());
        X(true);
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
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.adv_search) {
            J();
            return true;
        }
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            K();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle().toString());
        if (this.d0.equals(CSS.Value.PERCENTAGE)) {
            str = "";
        } else {
            str = "-" + this.d0;
        }
        sb.append(str);
        this.h0 = sb.toString();
        T();
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
