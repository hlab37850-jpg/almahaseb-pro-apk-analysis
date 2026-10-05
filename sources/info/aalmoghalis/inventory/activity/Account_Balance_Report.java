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
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.C0372Bn;
import defpackage.C0620Jf;
import defpackage.C0922Sv;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
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
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class Account_Balance_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0922Sv B;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public C0620Jf b0;
    public int c0;
    public int d0;
    public int e0;
    public SQLiteDatabase h;
    public Z00 i;
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
    public List C = new ArrayList();
    public ImageButton D = null;
    public AppCompatCheckBox E = null;
    public int F = 0;
    public String[] G = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int I = 0;
    public TextView J = null;
    public LinearLayout K = null;
    public ImageView L = null;
    public int R = 0;
    public List S = new ArrayList();
    public int T = 0;
    public View.OnClickListener U = new u();
    public String V = "";
    public Dialog W = null;
    public Handler X = new f();
    public String Y = "";
    public Cursor Z = null;
    public boolean a0 = false;
    public int f0 = 0;
    public String g0 = CSS.Value.PERCENTAGE;
    public String h0 = CSS.Value.PERCENTAGE;
    public String i0 = CSS.Value.PERCENTAGE;
    public TextView j0 = null;
    public TextView k0 = null;
    public boolean l0 = false;
    public DatePickerDialog.OnDateSetListener m0 = new s();
    public DatePickerDialog.OnDateSetListener n0 = new t();

    public class a implements Runnable {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Account_Balance_Report account_Balance_Report = Account_Balance_Report.this;
            account_Balance_Report.S = account_Balance_Report.B.e;
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    Account_Balance_Report.this.g0(this.a, 1);
                    Account_Balance_Report.this.T = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Account_Balance_Report.this.g0(this.a, 2);
                    Account_Balance_Report.this.T = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    Account_Balance_Report.this.f0(this.a, 3);
                    Account_Balance_Report.this.T = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Account_Balance_Report.this.f0(this.a, 4);
                    Account_Balance_Report.this.T = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Account_Balance_Report.this.f0(this.a, 5);
                    Account_Balance_Report.this.T = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            Account_Balance_Report.this.X.sendMessage(message);
        }
    }

    public class b implements Comparator {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a())) : String.valueOf(c4145vh2.n()).compareTo(String.valueOf(c4145vh.n()));
        }
    }

    public class c implements Comparator {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a())) : String.valueOf(c4145vh.n()).compareTo(String.valueOf(c4145vh2.n()));
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public d(TextView textView, ImageView imageView) {
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
                Account_Balance_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Account_Balance_Report.this.l = 0;
                Account_Balance_Report.this.O();
            } catch (Exception unused) {
                Toast.makeText(Account_Balance_Report.this.getApplicationContext(), Account_Balance_Report.this.getString(R.string.sql_error), 1);
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

    public class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Account_Balance_Report.this.L();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Account_Balance_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Account_Balance_Report account_Balance_Report = Account_Balance_Report.this;
                sb.append(account_Balance_Report.i.ic(account_Balance_Report.Y));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Z00 z01 = Account_Balance_Report.this.i;
                StringBuilder sb2 = new StringBuilder();
                Account_Balance_Report account_Balance_Report2 = Account_Balance_Report.this;
                sb2.append(account_Balance_Report2.i.ic(account_Balance_Report2.Y));
                sb2.append(".xls");
                z01.pa(sb2.toString());
            } else if (message.obj.toString().equals("3")) {
                Account_Balance_Report.this.B.notifyDataSetChanged();
                Account_Balance_Report account_Balance_Report3 = Account_Balance_Report.this;
                Z00 z02 = account_Balance_Report3.i;
                Context baseContext = account_Balance_Report3.getBaseContext();
                Account_Balance_Report account_Balance_Report4 = Account_Balance_Report.this;
                z02.lc(baseContext, account_Balance_Report4.M, account_Balance_Report4.N, account_Balance_Report4.O, account_Balance_Report4.P, account_Balance_Report4.Q);
                Account_Balance_Report account_Balance_Report5 = Account_Balance_Report.this;
                int i = account_Balance_Report5.T;
                if (i == 1) {
                    account_Balance_Report5.i.ld(account_Balance_Report5, account_Balance_Report5.M, account_Balance_Report5.R);
                } else if (i == 2) {
                    account_Balance_Report5.i.ld(account_Balance_Report5, account_Balance_Report5.N, account_Balance_Report5.R);
                } else if (i == 3) {
                    account_Balance_Report5.i.ld(account_Balance_Report5, account_Balance_Report5.O, account_Balance_Report5.R);
                } else if (i == 4) {
                    account_Balance_Report5.i.ld(account_Balance_Report5, account_Balance_Report5.P, account_Balance_Report5.R);
                } else if (i == 5) {
                    account_Balance_Report5.i.ld(account_Balance_Report5, account_Balance_Report5.Q, account_Balance_Report5.R);
                }
            }
            Account_Balance_Report.this.c0(false);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Account_Balance_Report account_Balance_Report = Account_Balance_Report.this;
            Z00 z00 = account_Balance_Report.i;
            ListView listView = account_Balance_Report.z;
            String strIc = z00.ic(account_Balance_Report.Y);
            Account_Balance_Report account_Balance_Report2 = Account_Balance_Report.this;
            z00.kb(listView, strIc, account_Balance_Report2.g0, account_Balance_Report2.h0, account_Balance_Report2.l0);
            Message message = new Message();
            message.obj = "1";
            Account_Balance_Report.this.X.sendMessage(message);
        }
    }

    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
                if (c4145vh.q().equals("1")) {
                    Account_Balance_Report account_Balance_Report = Account_Balance_Report.this;
                    Toast.makeText(account_Balance_Report, account_Balance_Report.getString(R.string.parent_account_alarm), 0).show();
                    return;
                }
                C4143vg c4143vgQ4 = Account_Balance_Report.this.i.q4(c4145vh.a());
                Log.d("trace_cus_click=", c4143vgQ4.j() + ":" + c4145vh.n());
                c4143vgQ4.m(c4145vh.n());
                Bundle bundle = new Bundle();
                ArrayList arrayList = new ArrayList();
                arrayList.add(c4143vgQ4);
                ((App) Account_Balance_Report.this.getApplication()).d(arrayList);
                Account_Balance_Report account_Balance_Report2 = Account_Balance_Report.this;
                Z00 z00 = account_Balance_Report2.i;
                String strI = c4143vgQ4.i();
                String strA = c4143vgQ4.a();
                String strH = c4143vgQ4.h();
                String strJ = c4143vgQ4.j();
                String strJ4 = Account_Balance_Report.this.i.j4(c4143vgQ4.f());
                String strB = c4143vgQ4.b();
                Account_Balance_Report account_Balance_Report3 = Account_Balance_Report.this;
                z00.q9(account_Balance_Report2, strI, strA, strH, strJ, strJ4, strB, 1, account_Balance_Report3.g0, account_Balance_Report3.h0, bundle);
            } catch (Exception unused) {
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Account_Balance_Report account_Balance_Report = Account_Balance_Report.this;
            Z00 z00 = account_Balance_Report.i;
            ListView listView = account_Balance_Report.z;
            String strIc = z00.ic(account_Balance_Report.Y);
            Account_Balance_Report account_Balance_Report2 = Account_Balance_Report.this;
            z00.Qa(listView, strIc, account_Balance_Report2.g0, account_Balance_Report2.h0, account_Balance_Report2.l0);
            Message message = new Message();
            message.obj = "2";
            Account_Balance_Report.this.X.sendMessage(message);
        }
    }

    public class j extends WebViewClient {
        public j() {
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

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(Account_Balance_Report.this, android.R.layout.simple_spinner_dropdown_item, new C2160f10(Account_Balance_Report.this.i).E("select DISTINCT  f_name from cus_search_tmp order by f_id"));
            Account_Balance_Report account_Balance_Report = Account_Balance_Report.this;
            account_Balance_Report.i.T(account_Balance_Report, arrayAdapter, account_Balance_Report.b0.e);
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Balance_Report.this.showDialog(0);
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Balance_Report.this.showDialog(4);
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Account_Balance_Report.this.f0 = 0;
                dialogInterface.dismiss();
                Account_Balance_Report.this.O();
            } catch (Exception unused) {
            }
        }
    }

    public class q implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public q(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Account_Balance_Report account_Balance_Report = Account_Balance_Report.this;
                account_Balance_Report.f0 = 1;
                if (account_Balance_Report.j0.getText() == null) {
                    Account_Balance_Report.this.g0 = "";
                } else {
                    Account_Balance_Report account_Balance_Report2 = Account_Balance_Report.this;
                    account_Balance_Report2.g0 = account_Balance_Report2.j0.getText().toString();
                }
                if (Account_Balance_Report.this.k0.getText() == null) {
                    Account_Balance_Report.this.h0 = "";
                } else {
                    Account_Balance_Report account_Balance_Report3 = Account_Balance_Report.this;
                    account_Balance_Report3.h0 = account_Balance_Report3.k0.getText().toString();
                }
                if (Account_Balance_Report.this.g0.length() > 0 && Account_Balance_Report.this.h0.length() > 0) {
                    Account_Balance_Report account_Balance_Report4 = Account_Balance_Report.this;
                    if (account_Balance_Report4.g0.compareTo(account_Balance_Report4.h0) > 0) {
                        Account_Balance_Report account_Balance_Report5 = Account_Balance_Report.this;
                        account_Balance_Report5.f0 = 0;
                        account_Balance_Report5.j0.setError("*");
                        Account_Balance_Report.this.k0.setError("*");
                        return;
                    }
                }
                if (Account_Balance_Report.this.b0.e.getText() == null || Account_Balance_Report.this.b0.e.getText().toString().length() == 0) {
                    Account_Balance_Report.this.i0 = CSS.Value.PERCENTAGE;
                } else {
                    Account_Balance_Report account_Balance_Report6 = Account_Balance_Report.this;
                    account_Balance_Report6.i0 = account_Balance_Report6.b0.e.getText().toString();
                }
                this.a.dismiss();
                Account_Balance_Report.this.O();
            } catch (Exception unused) {
            }
        }
    }

    public class r implements SearchView.OnQueryTextListener {
        public r() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Account_Balance_Report.this.M(1);
            }
            Account_Balance_Report.this.V(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Account_Balance_Report.this.M(0);
            return false;
        }
    }

    public class s implements DatePickerDialog.OnDateSetListener {
        public s() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Account_Balance_Report.this.c0 = i;
            Account_Balance_Report.this.d0 = i2;
            Account_Balance_Report.this.e0 = i3;
            try {
                String str = Account_Balance_Report.this.c0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Balance_Report.this.d0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Balance_Report.this.e0));
                Locale locale = Locale.ENGLISH;
                Account_Balance_Report.this.j0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class t implements DatePickerDialog.OnDateSetListener {
        public t() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Account_Balance_Report.this.c0 = i;
            Account_Balance_Report.this.d0 = i2;
            Account_Balance_Report.this.e0 = i3;
            try {
                String str = Account_Balance_Report.this.c0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Balance_Report.this.d0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Account_Balance_Report.this.e0));
                Locale locale = Locale.ENGLISH;
                Account_Balance_Report.this.k0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Account_Balance_Report.this.h0(view);
        }
    }

    public class v implements Comparator {
        public int a;

        public v(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 3) {
                return Double.valueOf(c4145vh.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.o().replaceAll(",", "")));
            }
            if (i == 4) {
                return Double.valueOf(c4145vh.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.p().replaceAll(",", "")));
            }
            return i == 5 ? Double.valueOf(c4145vh.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.q().replaceAll(",", ""))) : Double.valueOf(c4145vh.v().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.v().replaceAll(",", "")));
        }
    }

    public class w implements Comparator {
        public int a;

        public w(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 3) {
                return Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", "")));
            }
            if (i == 4) {
                return Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
            }
            return i == 5 ? Double.valueOf(c4145vh2.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.q().replaceAll(",", ""))) : Double.valueOf(c4145vh2.v().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.v().replaceAll(",", "")));
        }
    }

    public void J() {
        try {
            this.f0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            getLayoutInflater();
            C0620Jf c0620JfC = C0620Jf.c(getLayoutInflater());
            this.b0 = c0620JfC;
            builder.setView(c0620JfC.getRoot());
            C0620Jf c0620Jf = this.b0;
            this.j0 = c0620Jf.d;
            this.k0 = c0620Jf.f;
            c0620Jf.e.setHint(getString(R.string.parent_account));
            this.b0.e.setOnClickListener(new l());
            this.j0.setOnClickListener(new m());
            this.k0.setOnClickListener(new n());
            builder.setPositiveButton(getString(R.string.btn_search), new o());
            builder.setNegativeButton(getString(R.string.btn_cancel), new p());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new q(alertDialogCreate));
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

    public void L() {
        S();
        if (this.B == null) {
            this.B = new C0922Sv(this, R.layout.data_det_row_rev1, this.C, 21, R(), 1);
        }
        this.B.l.clear();
        this.B.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.B);
    }

    public void M(int i2) {
        String str;
        String str2;
        try {
            if (i2 == 1) {
                TextView textView = this.J;
                StringBuilder sb = new StringBuilder();
                if (this.p >= 0.0d) {
                    str2 = this.i.c5() + ":-";
                } else {
                    str2 = this.i.Q2() + ":-";
                }
                sb.append(str2);
                sb.append(" ");
                sb.append(this.i.P7(String.valueOf(this.p)));
                textView.setText(sb.toString());
                return;
            }
            double dP = P(this.B.e);
            TextView textView2 = this.J;
            StringBuilder sb2 = new StringBuilder();
            if (dP >= 0.0d) {
                str = this.i.c5() + ":-";
            } else {
                str = this.i.Q2() + ":-";
            }
            sb2.append(str);
            sb2.append(" ");
            sb2.append(this.i.P7(String.valueOf(dP)));
            textView2.setText(sb2.toString());
        } catch (Exception unused) {
        }
    }

    public void N() {
        Cursor cursorL1;
        int i2 = this.f0;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorL1 = this.i.l1(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            this.g0 = this.g0.isEmpty() ? CSS.Value.PERCENTAGE : this.g0;
            if (!this.h0.isEmpty()) {
                str = this.h0;
            }
            this.h0 = str;
            C0620Jf c0620Jf = this.b0;
            if (c0620Jf != null && c0620Jf.e.getText().toString().length() > 0) {
                this.i0 = this.b0.e.getText().toString();
            }
            cursorL1 = this.i.l1(this.g0, this.h0, this.i0);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorL1.getCount()));
        this.p = 0.0d;
        this.q = 0.0d;
        this.C.clear();
        cursorL1.moveToFirst();
        while (!cursorL1.isAfterLast()) {
            if (cursorL1.getDouble(cursorL1.getColumnIndex("f3")) != 0.0d || cursorL1.getDouble(cursorL1.getColumnIndex("f4")) != 0.0d) {
                this.C.add(new C4145vh(cursorL1.getString(cursorL1.getColumnIndex("_id")), cursorL1.getString(cursorL1.getColumnIndex("f1")), cursorL1.getString(cursorL1.getColumnIndex("f2")), this.i.P7(String.valueOf(cursorL1.getDouble(cursorL1.getColumnIndex("f4")))), this.i.P7(String.valueOf(cursorL1.getDouble(cursorL1.getColumnIndex("f3")))), this.i.P7(String.valueOf(cursorL1.getDouble(cursorL1.getColumnIndex("f4")) + cursorL1.getDouble(cursorL1.getColumnIndex("f3")))), this.i.P7(String.valueOf(cursorL1.getDouble(cursorL1.getColumnIndex("f5")))), this.i.P7(String.valueOf(cursorL1.getDouble(cursorL1.getColumnIndex("f6")))), cursorL1.getString(cursorL1.getColumnIndex("f7")), cursorL1.getString(cursorL1.getColumnIndex("f8")), cursorL1.getString(cursorL1.getColumnIndex("f9"))));
            }
            cursorL1.moveToNext();
        }
        cursorL1.close();
    }

    public void O() {
        c0(true);
        AbstractC3132jE.d(new Callable() { // from class: S1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.T();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: T1
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.U((Integer) obj);
            }
        });
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
        intent.putExtra("TR_TYPE", String.valueOf(this.x));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
        finish();
    }

    public boolean R() {
        return false;
    }

    public void S() {
        this.M = (TextView) findViewById(R.id.f1);
        this.N = (TextView) findViewById(R.id.f2);
        this.O = (TextView) findViewById(R.id.f3);
        this.P = (TextView) findViewById(R.id.f4);
        this.Q = (TextView) findViewById(R.id.f5);
        this.M.setText(getString(R.string.account));
        this.N.setText(getString(R.string.currency));
        this.O.setText(getString(R.string.old_balance));
        this.P.setText(getString(R.string.period_amount));
        this.Q.setText(getString(R.string.balance));
        this.i.ld(this, this.M, this.R);
        TextView textView = this.M;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.N;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.O;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.P;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.Q;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.M.setOnClickListener(this.U);
        this.N.setOnClickListener(this.U);
        this.O.setOnClickListener(this.U);
        this.P.setOnClickListener(this.U);
        this.Q.setOnClickListener(this.U);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.M);
        c0372Bn.a(this, this.N);
        c0372Bn.a(this, this.O);
        c0372Bn.a(this, this.P);
        c0372Bn.a(this, this.Q);
        if (R()) {
            this.M.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.N.getLayoutParams();
            layoutParams.weight = 60.0f;
            this.N.setLayoutParams(layoutParams);
        }
    }

    public final /* synthetic */ Integer T() {
        N();
        return 1;
    }

    public final /* synthetic */ void U(Integer num) {
        c0(false);
        L();
    }

    public void V(String str) {
        this.B.getFilter().filter(str);
    }

    public void W() {
        c0(true);
        new Thread(new i()).start();
    }

    public void X() {
        c0(true);
        new Thread(new g()).start();
    }

    public final void Y(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new c(i2)));
    }

    public final void Z(List list, int i2) {
        Collections.sort(this.S, new w(i2));
    }

    public void a0(boolean z) {
    }

    public void add_btn(View view) {
        this.i.z(this, this.j, this.k);
    }

    public void b0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new j());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new k());
        builder.show();
    }

    public void btn_add(View view) {
        Bill_edit.P2 = true;
        this.i.z(this, this.j, this.k);
        finish();
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.V = textView.getText().toString();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new d(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new e());
        builder.create().show();
    }

    public void c0(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z) {
            android.app.AlertDialog alertDialogCreate = builder.create();
            this.W = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.W;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public final void d0(List list, int i2) {
        Collections.sort(this.S, new v(i2));
    }

    public final void e0(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new b(i2)));
    }

    public void f0(View view, int i2) {
        if (this.R == 0) {
            d0(this.S, i2);
            this.R = 1;
        } else {
            Z(this.S, i2);
            this.R = 0;
        }
    }

    public void g0(View view, int i2) {
        if (this.R == 0) {
            e0(this.S, i2);
            this.R = 1;
        } else {
            Y(this.S, i2);
            this.R = 0;
        }
    }

    public void h0(View view) {
        c0(true);
        new Thread(new a(view)).start();
    }

    public void help_btn(View view) {
        b0();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.V.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.V + "'");
            }
            this.V = "";
            O();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.f0 = 0;
        O();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill5_3);
        setTitle(getIntent().getStringExtra("title_"));
        this.z = (ListView) findViewById(R.id.list_items);
        TextView textView = (TextView) findViewById(R.id.emptyResults);
        textView.setText(getString(R.string.no_results));
        this.z.setEmptyView(textView);
        this.i = new Z00(this.h, this);
        this.z.setOnItemClickListener(new h());
        TextView textView2 = (TextView) findViewById(R.id.footer_sum);
        this.J = textView2;
        textView2.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.edit_cus_interface3);
        this.K = linearLayout;
        linearLayout.setVisibility(4);
        ImageView imageView = (ImageView) findViewById(R.id.img_add_amount);
        this.L = imageView;
        imageView.setVisibility(8);
        try {
            S();
            if (getIntent().getStringExtra("g_id") != null) {
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getIntent().getStringExtra("title_"));
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.c0 = calendar.get(1);
        this.d0 = calendar.get(2);
        this.e0 = calendar.get(5);
        a0(true);
        if (!this.a0) {
            this.a0 = true;
            if (this.i.U2() > 0) {
                Toast.makeText(this, getString(R.string.alarm_curr_price), 0).show();
            }
        }
        S();
        if (this.B == null) {
            this.B = new C0922Sv(this, R.layout.data_det_row_rev1, this.C, 21, R(), 1);
        }
        this.z.setAdapter((ListAdapter) this.B);
        getWindow().setSoftInputMode(2);
        O();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.m0, this.c0, this.d0, this.e0);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.n0, this.c0, this.d0, this.e0);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general4, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        new C1839c10(this.i);
        if (C1839c10.J(this.i)) {
            menu.findItem(R.id.excel).setVisible(true);
        }
        SearchView searchView = (SearchView) menuItemFindItem.getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new r());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a0(true);
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
            J();
            return true;
        }
        if (menuItem.getItemId() == R.id.print) {
            K();
            this.Y = getTitle().toString();
            if (!this.i0.equals(CSS.Value.PERCENTAGE)) {
                this.Y = getTitle().toString() + " #" + this.i0;
            }
            this.l0 = false;
            X();
            return true;
        }
        if (menuItem.getItemId() != R.id.print_period) {
            if (menuItem.getItemId() != R.id.excel) {
                return super.onOptionsItemSelected(menuItem);
            }
            if (Build.VERSION.SDK_INT < 31) {
                K();
            }
            this.Y = getTitle().toString();
            W();
            return true;
        }
        K();
        this.Y = getTitle().toString();
        if (!this.i0.equals(CSS.Value.PERCENTAGE)) {
            this.Y = getTitle().toString() + " #" + this.i0;
        }
        this.l0 = true;
        X();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (FragmentStatePagerSupport_Main.a0) {
            Log.d("Oncreate:", "onResume_refresh");
            FragmentStatePagerSupport_Main.a0 = false;
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
