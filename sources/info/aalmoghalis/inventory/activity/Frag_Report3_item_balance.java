package info.aalmoghalis.inventory.activity;

import android.R;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Z00;
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
public class Frag_Report3_item_balance extends Menu_AppCompatActivity {
    public static int e0;
    public String C;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public int R;
    public int S;
    public int T;
    public SQLiteDatabase h;
    public Z00 i;
    public String k;
    public String l;
    public C0922Sv q;
    public double j = 0.0d;
    public ListView n = null;
    public Toolbar p = null;
    public List t = new ArrayList();
    public ImageButton u = null;
    public TextView v = null;
    public TextView w = null;
    public int x = 0;
    public String[] y = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] z = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public boolean A = false;
    public TextView B = null;
    public boolean D = false;
    public int E = 0;
    public int F = 0;
    public String O = "";
    public DatePickerDialog.OnDateSetListener P = new a();
    public DatePickerDialog.OnDateSetListener Q = new b();
    public int U = 0;
    public String V = CSS.Value.PERCENTAGE;
    public String W = CSS.Value.PERCENTAGE;
    public String X = CSS.Value.PERCENTAGE;
    public TextView Y = null;
    public TextView Z = null;
    public TextView a0 = null;
    public Dialog b0 = null;
    public Handler c0 = new i();
    public Cursor d0 = null;

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Frag_Report3_item_balance.this.R = i;
            Frag_Report3_item_balance.this.S = i2;
            Frag_Report3_item_balance.this.T = i3;
            try {
                String str = Frag_Report3_item_balance.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report3_item_balance.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report3_item_balance.this.T));
                Locale locale = Locale.ENGLISH;
                Frag_Report3_item_balance.this.Y.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
                frag_Report3_item_balance.V = frag_Report3_item_balance.Y.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Frag_Report3_item_balance.this.R = i;
            Frag_Report3_item_balance.this.S = i2;
            Frag_Report3_item_balance.this.T = i3;
            try {
                String str = Frag_Report3_item_balance.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report3_item_balance.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Frag_Report3_item_balance.this.T));
                Locale locale = Locale.ENGLISH;
                Frag_Report3_item_balance.this.Z.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
                frag_Report3_item_balance.W = frag_Report3_item_balance.Z.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
            ArrayAdapter arrayAdapter = new ArrayAdapter(frag_Report3_item_balance, R.layout.simple_spinner_dropdown_item, frag_Report3_item_balance.i.T6());
            Frag_Report3_item_balance frag_Report3_item_balance2 = Frag_Report3_item_balance.this;
            frag_Report3_item_balance2.i.T(frag_Report3_item_balance2, arrayAdapter, frag_Report3_item_balance2.a0);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Frag_Report3_item_balance.this.showDialog(0);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Frag_Report3_item_balance.this.showDialog(4);
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
                frag_Report3_item_balance.U = 0;
                frag_Report3_item_balance.P();
            } catch (Exception unused) {
            }
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public h(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
                frag_Report3_item_balance.U = 1;
                if (frag_Report3_item_balance.Y.getText() == null) {
                    Frag_Report3_item_balance.this.V = "";
                } else {
                    Frag_Report3_item_balance frag_Report3_item_balance2 = Frag_Report3_item_balance.this;
                    frag_Report3_item_balance2.V = frag_Report3_item_balance2.Y.getText().toString();
                }
                if (Frag_Report3_item_balance.this.Z.getText() == null) {
                    Frag_Report3_item_balance.this.W = "";
                } else {
                    Frag_Report3_item_balance frag_Report3_item_balance3 = Frag_Report3_item_balance.this;
                    frag_Report3_item_balance3.W = frag_Report3_item_balance3.Z.getText().toString();
                }
                if (Frag_Report3_item_balance.this.a0.getText() == null) {
                    Frag_Report3_item_balance.this.X = "";
                } else {
                    Frag_Report3_item_balance frag_Report3_item_balance4 = Frag_Report3_item_balance.this;
                    frag_Report3_item_balance4.X = frag_Report3_item_balance4.a0.getText().toString();
                }
                Frag_Report3_item_balance.this.P();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class i extends Handler {
        public i() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
                frag_Report3_item_balance.M(frag_Report3_item_balance.d0);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Frag_Report3_item_balance.this.i;
                StringBuilder sb = new StringBuilder();
                Frag_Report3_item_balance frag_Report3_item_balance2 = Frag_Report3_item_balance.this;
                sb.append(frag_Report3_item_balance2.i.ic(frag_Report3_item_balance2.C));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Z00 z01 = Frag_Report3_item_balance.this.i;
                StringBuilder sb2 = new StringBuilder();
                Frag_Report3_item_balance frag_Report3_item_balance3 = Frag_Report3_item_balance.this;
                sb2.append(frag_Report3_item_balance3.i.ic(frag_Report3_item_balance3.C));
                sb2.append(".xls");
                z01.pa(sb2.toString());
            } else if (message.obj.toString().equals("3")) {
                Frag_Report3_item_balance.this.q.notifyDataSetChanged();
                Frag_Report3_item_balance frag_Report3_item_balance4 = Frag_Report3_item_balance.this;
                Z00 z02 = frag_Report3_item_balance4.i;
                Context baseContext = frag_Report3_item_balance4.getBaseContext();
                Frag_Report3_item_balance frag_Report3_item_balance5 = Frag_Report3_item_balance.this;
                z02.lc(baseContext, frag_Report3_item_balance5.G, frag_Report3_item_balance5.H, frag_Report3_item_balance5.I, frag_Report3_item_balance5.J, frag_Report3_item_balance5.K);
                Frag_Report3_item_balance frag_Report3_item_balance6 = Frag_Report3_item_balance.this;
                int i = frag_Report3_item_balance6.E;
                if (i == 1) {
                    Z00 z03 = frag_Report3_item_balance6.i;
                    Context baseContext2 = frag_Report3_item_balance6.getBaseContext();
                    Frag_Report3_item_balance frag_Report3_item_balance7 = Frag_Report3_item_balance.this;
                    z03.ld(baseContext2, frag_Report3_item_balance7.G, frag_Report3_item_balance7.F);
                } else if (i == 2) {
                    Z00 z04 = frag_Report3_item_balance6.i;
                    Context baseContext3 = frag_Report3_item_balance6.getBaseContext();
                    Frag_Report3_item_balance frag_Report3_item_balance8 = Frag_Report3_item_balance.this;
                    z04.ld(baseContext3, frag_Report3_item_balance8.H, frag_Report3_item_balance8.F);
                } else if (i == 3) {
                    Z00 z05 = frag_Report3_item_balance6.i;
                    Context baseContext4 = frag_Report3_item_balance6.getBaseContext();
                    Frag_Report3_item_balance frag_Report3_item_balance9 = Frag_Report3_item_balance.this;
                    z05.ld(baseContext4, frag_Report3_item_balance9.I, frag_Report3_item_balance9.F);
                } else if (i == 4) {
                    Z00 z06 = frag_Report3_item_balance6.i;
                    Context baseContext5 = frag_Report3_item_balance6.getBaseContext();
                    Frag_Report3_item_balance frag_Report3_item_balance10 = Frag_Report3_item_balance.this;
                    z06.ld(baseContext5, frag_Report3_item_balance10.J, frag_Report3_item_balance10.F);
                } else if (i == 5) {
                    Z00 z07 = frag_Report3_item_balance6.i;
                    Context baseContext6 = frag_Report3_item_balance6.getBaseContext();
                    Frag_Report3_item_balance frag_Report3_item_balance11 = Frag_Report3_item_balance.this;
                    z07.ld(baseContext6, frag_Report3_item_balance11.K, frag_Report3_item_balance11.F);
                }
            }
            Frag_Report3_item_balance.this.e0(false);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Frag_Report3_item_balance.this.O();
            Message message = new Message();
            message.obj = "0";
            Frag_Report3_item_balance.this.c0.sendMessage(message);
        }
    }

    public class k implements AdapterView.OnItemClickListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
                Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
                boolean zIsEmpty = frag_Report3_item_balance.V.isEmpty();
                String str = CSS.Value.PERCENTAGE;
                frag_Report3_item_balance.V = zIsEmpty ? CSS.Value.PERCENTAGE : Frag_Report3_item_balance.this.V;
                Frag_Report3_item_balance frag_Report3_item_balance2 = Frag_Report3_item_balance.this;
                if (!frag_Report3_item_balance2.W.isEmpty()) {
                    str = Frag_Report3_item_balance.this.W;
                }
                frag_Report3_item_balance2.W = str;
                Intent intent = new Intent(view.getContext(), (Class<?>) FragmentStatePagerSupport.class);
                intent.putExtra("screen_no", "7");
                intent.putExtra("report_type", 1);
                intent.putExtra("item_name", c4145vh.n());
                intent.putExtra("br_name", c4145vh.a());
                intent.putExtra("unit_name", c4145vh.b());
                intent.putExtra("f_date", Frag_Report3_item_balance.this.V);
                intent.putExtra("t_date", Frag_Report3_item_balance.this.W);
                intent.putExtra("g_id", Frag_Report3_item_balance.this.k);
                intent.putExtra("g_name", Frag_Report3_item_balance.this.l);
                Log.d("lv_click", c4145vh.a() + ":" + c4145vh.n() + ":" + Frag_Report3_item_balance.this.V + ":" + Frag_Report3_item_balance.this.W);
                int unused = Frag_Report3_item_balance.e0 = Frag_Report3_item_balance.this.n.getFirstVisiblePosition();
                Frag_Report3_item_balance.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
            Z00 z00 = frag_Report3_item_balance.i;
            ListView listView = frag_Report3_item_balance.n;
            String strIc = z00.ic(frag_Report3_item_balance.C);
            Frag_Report3_item_balance frag_Report3_item_balance2 = Frag_Report3_item_balance.this;
            double dR = frag_Report3_item_balance2.R(frag_Report3_item_balance2.q.e);
            Frag_Report3_item_balance frag_Report3_item_balance3 = Frag_Report3_item_balance.this;
            z00.gb(listView, strIc, dR, frag_Report3_item_balance3.V, frag_Report3_item_balance3.W, frag_Report3_item_balance3.D);
            Message message = new Message();
            message.obj = "1";
            Frag_Report3_item_balance.this.c0.sendMessage(message);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Frag_Report3_item_balance frag_Report3_item_balance = Frag_Report3_item_balance.this;
            Z00 z00 = frag_Report3_item_balance.i;
            ListView listView = frag_Report3_item_balance.n;
            String strIc = z00.ic(frag_Report3_item_balance.C);
            Frag_Report3_item_balance frag_Report3_item_balance2 = Frag_Report3_item_balance.this;
            double dR = frag_Report3_item_balance2.R(frag_Report3_item_balance2.q.e);
            Frag_Report3_item_balance frag_Report3_item_balance3 = Frag_Report3_item_balance.this;
            z00.Pa(listView, strIc, dR, frag_Report3_item_balance3.V, frag_Report3_item_balance3.W, frag_Report3_item_balance3.D);
            Message message = new Message();
            message.obj = "2";
            Frag_Report3_item_balance.this.c0.sendMessage(message);
        }
    }

    public class n implements SearchView.OnQueryTextListener {
        public n() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Frag_Report3_item_balance.this.N(1);
            }
            Frag_Report3_item_balance.this.Y(str);
            if (!TextUtils.isEmpty(str)) {
                Frag_Report3_item_balance.this.N(0);
            }
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Frag_Report3_item_balance.this.N(0);
            return false;
        }
    }

    public class o implements Runnable {
        public final /* synthetic */ View a;

        public o(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case info.aalmoghalis.inventory.R.id.f1 /* 2131296723 */:
                    Frag_Report3_item_balance.this.i0(this.a, 1);
                    Frag_Report3_item_balance.this.E = 1;
                    break;
                case info.aalmoghalis.inventory.R.id.f2 /* 2131296725 */:
                    Frag_Report3_item_balance.this.i0(this.a, 2);
                    Frag_Report3_item_balance.this.E = 2;
                    break;
                case info.aalmoghalis.inventory.R.id.f3 /* 2131296726 */:
                    Frag_Report3_item_balance.this.h0(this.a, 3);
                    Frag_Report3_item_balance.this.E = 3;
                    break;
                case info.aalmoghalis.inventory.R.id.f4 /* 2131296727 */:
                    Frag_Report3_item_balance.this.h0(this.a, 4);
                    Frag_Report3_item_balance.this.E = 4;
                    break;
                case info.aalmoghalis.inventory.R.id.f5 /* 2131296728 */:
                    Frag_Report3_item_balance.this.h0(this.a, 5);
                    Frag_Report3_item_balance.this.E = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            Frag_Report3_item_balance.this.c0.sendMessage(message);
        }
    }

    public class p implements Comparator {
        public final /* synthetic */ int a;

        public p(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a())) : String.valueOf(c4145vh2.n()).compareTo(String.valueOf(c4145vh.n()));
        }
    }

    public class q implements Comparator {
        public final /* synthetic */ int a;

        public q(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a())) : String.valueOf(c4145vh.n()).compareTo(String.valueOf(c4145vh2.n()));
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Frag_Report3_item_balance.this.j0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Frag_Report3_item_balance.this.j0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Frag_Report3_item_balance.this.j0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Frag_Report3_item_balance.this.j0(view);
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
                Frag_Report3_item_balance.this.j0(view);
            } catch (Exception unused) {
            }
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
            if (i == 5) {
                return Double.valueOf(c4145vh.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.q().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.o().replaceAll(",", ""))) : Double.valueOf(c4145vh.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.p().replaceAll(",", "")));
        }
    }

    public class x implements Comparator {
        public int a;

        public x(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 5) {
                return Double.valueOf(c4145vh2.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.q().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", ""))) : Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
        }
    }

    private boolean U(int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= i2 && i4 <= i3;
    }

    private boolean V() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && U(21, 22);
    }

    private void b0(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new q(i2)));
    }

    private void c0(List list, int i2) {
        Collections.sort(list, new x(i2));
    }

    private void f0(List list, int i2) {
        Collections.sort(list, new w(i2));
    }

    private void g0(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new p(i2)));
    }

    public void K() {
        try {
            this.U = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_report_input_item_type, (ViewGroup) null);
            builder.setView(viewInflate);
            this.Y = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.f_date);
            this.Z = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.t_date);
            this.Y.setVisibility(8);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_type);
            this.a0 = textView;
            textView.setOnClickListener(new c());
            this.Y.setOnClickListener(new d());
            this.Z.setOnClickListener(new e());
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.btn_search), new f());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.btn_cancel), new g());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new h(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void L() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void M(Cursor cursor) {
        try {
            C0922Sv c0922Sv = new C0922Sv(this, info.aalmoghalis.inventory.R.layout.data_det_row_rep3_, this.t, 17, this.i.f9("select * from items_cost_calc a where round(a.n_q,7)<0") > 0);
            this.q = c0922Sv;
            c0922Sv.l.clear();
            this.q.notifyDataSetChanged();
            this.n.setAdapter((ListAdapter) this.q);
            this.v.setText(this.i.P7(String.valueOf(this.j)));
            this.w.setText(this.i.P7(String.valueOf(R(this.t))));
            ((App) getApplication()).c(this.t);
            if (new C1839c10().i(this.X, this.U)) {
                this.B.setText(this.X);
            } else {
                this.B.setText(getString(info.aalmoghalis.inventory.R.string.cost_total));
            }
        } catch (Exception unused) {
        }
    }

    public void N(int i2) {
        try {
            if (i2 == 1) {
                this.v.setText(this.i.P7(String.valueOf(this.j)));
                this.w.setText(this.i.P7(String.valueOf(R(this.q.e))));
            } else {
                this.v.setText(this.i.P7(String.valueOf(Q(this.q.e))));
                this.w.setText(this.i.P7(String.valueOf(R(this.q.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void O() {
        Cursor cursorC7;
        this.d0 = null;
        if (!this.A) {
            this.A = true;
            this.i.Vb();
        }
        int i2 = this.U;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorC7 = this.i.c7(this.k.equals("0") ? CSS.Value.PERCENTAGE : this.l, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            this.V = this.V.isEmpty() ? CSS.Value.PERCENTAGE : this.V;
            this.W = this.W.isEmpty() ? CSS.Value.PERCENTAGE : this.W;
            this.X = this.X.isEmpty() ? CSS.Value.PERCENTAGE : this.X;
            new C2160f10(this.i).W(this.W);
            Z00 z00 = this.i;
            if (!this.k.equals("0")) {
                str = this.l;
            }
            cursorC7 = z00.c7(str, this.V, this.W, this.X);
        }
        Log.d("recCount=", cursorC7.getCount() + "");
        this.j = 0.0d;
        this.t.clear();
        cursorC7.moveToFirst();
        while (!cursorC7.isAfterLast()) {
            this.j += cursorC7.getDouble(cursorC7.getColumnIndex("f8"));
            this.t.add(new C4145vh(cursorC7.getString(cursorC7.getColumnIndex("_id")), cursorC7.getString(cursorC7.getColumnIndex("_id")), cursorC7.getString(cursorC7.getColumnIndex("f1")), this.i.P7(String.valueOf(cursorC7.getDouble(cursorC7.getColumnIndex("f5")))), this.i.P7(String.valueOf(cursorC7.getDouble(cursorC7.getColumnIndex("f7")))), this.i.P7(String.valueOf(cursorC7.getDouble(cursorC7.getColumnIndex("f8")))), cursorC7.getString(cursorC7.getColumnIndex("f6")), cursorC7.getString(cursorC7.getColumnIndex("f1")), this.i.P7(String.valueOf(cursorC7.getDouble(cursorC7.getColumnIndex("f9")))), cursorC7.getString(cursorC7.getColumnIndex("f11")), cursorC7.getString(cursorC7.getColumnIndex("f10"))));
            Log.d("unit_code=", cursorC7.getString(cursorC7.getColumnIndex("f10")) + "");
            cursorC7.moveToNext();
        }
        cursorC7.close();
    }

    public void P() {
        e0(true);
        new Thread(new j()).start();
    }

    public double Q(List list) {
        double d2 = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            d2 += Double.parseDouble(((C4145vh) list.get(size)).q().replaceAll(",", ""));
        }
        return d2;
    }

    public double R(List list) {
        double d2 = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            d2 += Double.parseDouble(((C4145vh) list.get(size)).o().replaceAll(",", ""));
        }
        return d2;
    }

    public void S(String str, String str2) {
    }

    public void T() {
        this.G = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f1);
        this.H = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f2);
        this.I = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f3);
        this.J = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f4);
        this.K = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f5);
        this.L = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f6);
        this.M = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f7);
        this.N = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f8);
        this.G.setText(getString(info.aalmoghalis.inventory.R.string.branch_name));
        this.H.setText(getString(info.aalmoghalis.inventory.R.string.item));
        this.I.setText(getString(info.aalmoghalis.inventory.R.string.qty));
        this.J.setText(getString(info.aalmoghalis.inventory.R.string.item_cost_avg_));
        this.K.setText(getString(info.aalmoghalis.inventory.R.string.total_sum));
        TextView textView = this.G;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.H;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.I;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.J;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.K;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.i.ld(this, this.G, this.F);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.G);
        c0372Bn.a(this, this.H);
        c0372Bn.a(this, this.I);
        c0372Bn.a(this, this.J);
        c0372Bn.a(this, this.K);
        this.H.setOnClickListener(new r());
        this.G.setOnClickListener(new s());
        this.I.setOnClickListener(new t());
        this.J.setOnClickListener(new u());
        this.K.setOnClickListener(new v());
    }

    public final /* synthetic */ Integer W() {
        this.i.Vb();
        return 1;
    }

    public final /* synthetic */ void X(Integer num) {
        recreate();
    }

    public void Y(String str) {
        C0922Sv c0922Sv = this.q;
        if (c0922Sv != null) {
            c0922Sv.getFilter().filter(str);
        }
    }

    public void Z() {
        e0(true);
        new Thread(new m()).start();
    }

    public void a0() {
        e0(true);
        new Thread(new l()).start();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        S(((TextView) linearLayout.findViewById(info.aalmoghalis.inventory.R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(info.aalmoghalis.inventory.R.id.f5)).getText().toString());
    }

    public void d0(boolean z) {
    }

    public void e0(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.progress, (ViewGroup) null));
            if (z) {
                AlertDialog alertDialogCreate = builder.create();
                this.b0 = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.b0;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void h0(View view, int i2) {
        if (this.F == 0) {
            f0(this.t, i2);
            this.F = 1;
        } else {
            c0(this.t, i2);
            this.F = 0;
        }
    }

    public void i0(View view, int i2) {
        if (this.F == 0) {
            g0(this.t, i2);
            this.F = 1;
        } else {
            b0(this.t, i2);
            this.F = 0;
        }
    }

    public void j0(View view) {
        e0(true);
        new Thread(new o(view)).start();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.data_listview_rep3_);
        setTitle(getIntent().getStringExtra("title_"));
        this.n = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        TextView textView = (TextView) findViewById(info.aalmoghalis.inventory.R.id.emptyResults);
        this.v = (TextView) findViewById(info.aalmoghalis.inventory.R.id.balance);
        this.w = (TextView) findViewById(info.aalmoghalis.inventory.R.id.balance2);
        this.n.setEmptyView(textView);
        this.i = new Z00(this.h, this);
        T();
        this.B = (TextView) findViewById(info.aalmoghalis.inventory.R.id.balance_hdr);
        this.n.setOnItemClickListener(new k());
        try {
            if (getIntent().getStringExtra("g_id") != null) {
                this.k = getIntent().getStringExtra("g_id");
                this.l = getIntent().getStringExtra("g_name");
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.R = calendar.get(1);
        this.S = calendar.get(2);
        this.T = calendar.get(5);
        d0(true);
        P();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(V() ? new ContextThemeWrapper(this, R.style.Theme.Holo.Light.Dialog) : this, this.P, this.R, this.S, this.T);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(V() ? new ContextThemeWrapper(this, R.style.Theme.Holo.Light.Dialog) : this, this.Q, this.R, this.S, this.T);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu != null) {
            menu.clear();
        }
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_main3_group_general3, menu);
        new C1839c10(this.i);
        if (C1839c10.J(this.i)) {
            menu.findItem(info.aalmoghalis.inventory.R.id.excel).setVisible(true);
        }
        SearchView searchView = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        searchView.setOnQueryTextListener(new n());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str;
        int itemId = menuItem.getItemId();
        if (itemId == info.aalmoghalis.inventory.R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                L();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getTitle().toString());
            if (this.X.equals(CSS.Value.PERCENTAGE)) {
                str = "";
            } else {
                str = "-" + this.X;
            }
            sb.append(str);
            this.C = sb.toString();
            this.D = false;
            a0();
            return true;
        }
        if (itemId == info.aalmoghalis.inventory.R.id.print_qty) {
            if (Build.VERSION.SDK_INT < 31) {
                L();
            }
            this.C = getTitle().toString();
            this.D = true;
            a0();
            return true;
        }
        if (itemId == info.aalmoghalis.inventory.R.id.adv_search) {
            K();
            return true;
        }
        if (menuItem.getItemId() != info.aalmoghalis.inventory.R.id.excel) {
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            finish();
            return true;
        }
        if (Build.VERSION.SDK_INT < 31) {
            L();
        }
        this.C = getTitle().toString();
        Z();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Bill_edit.Q2) {
            Bill_edit.Q2 = false;
            AbstractC3132jE.d(new Callable() { // from class: Vo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.W();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Wo
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.X((Integer) obj);
                }
            });
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
