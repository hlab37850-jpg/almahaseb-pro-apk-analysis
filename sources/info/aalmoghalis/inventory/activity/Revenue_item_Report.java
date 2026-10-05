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
import defpackage.C2160f10;
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
public class Revenue_item_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, a.b {
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
    public Handler U = new l();
    public Cursor V = null;
    public boolean W = false;
    public int a0 = 0;
    public String b0 = CSS.Value.PERCENTAGE;
    public String c0 = CSS.Value.PERCENTAGE;
    public String d0 = CSS.Value.PERCENTAGE;
    public TextView e0 = null;
    public TextView f0 = null;
    public TextView g0 = null;
    public DatePickerDialog.OnDateSetListener i0 = new x();
    public DatePickerDialog.OnDateSetListener j0 = new y();

    public class A implements Comparator {
        public int a;

        public A(int i) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Revenue_item_Report$a, reason: case insensitive filesystem */
    public class RunnableC3035a implements Runnable {
        public final /* synthetic */ View a;

        public RunnableC3035a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    Revenue_item_Report.this.c0(this.a, 1);
                    Revenue_item_Report.this.I = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Revenue_item_Report.this.c0(this.a, 2);
                    Revenue_item_Report.this.I = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    Revenue_item_Report.this.b0(this.a, 3);
                    Revenue_item_Report.this.I = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Revenue_item_Report.this.b0(this.a, 4);
                    Revenue_item_Report.this.I = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Revenue_item_Report.this.b0(this.a, 5);
                    Revenue_item_Report.this.I = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            Revenue_item_Report.this.U.sendMessage(message);
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

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Revenue_item_Report.this.d0(view);
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
                Revenue_item_Report.this.d0(view);
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
                Revenue_item_Report.this.d0(view);
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
                Revenue_item_Report.this.d0(view);
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
                Revenue_item_Report.this.d0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public i(TextView textView, ImageView imageView) {
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
                Revenue_item_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Revenue_item_Report.this.l = 0;
                Revenue_item_Report.this.O();
            } catch (Exception unused) {
                Toast.makeText(Revenue_item_Report.this.getApplicationContext(), Revenue_item_Report.this.getString(R.string.sql_error), 1);
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

    public class k implements AdapterView.OnItemClickListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                String strN = ((C4145vh) adapterView.getItemAtPosition(i)).n();
                String string = ((TextView) view.findViewById(R.id.f1)).getText().toString();
                Revenue_item_Report revenue_item_Report = Revenue_item_Report.this;
                boolean zIsEmpty = revenue_item_Report.b0.isEmpty();
                String str = CSS.Value.PERCENTAGE;
                revenue_item_Report.b0 = zIsEmpty ? CSS.Value.PERCENTAGE : Revenue_item_Report.this.b0;
                Revenue_item_Report revenue_item_Report2 = Revenue_item_Report.this;
                if (!revenue_item_Report2.c0.isEmpty()) {
                    str = Revenue_item_Report.this.c0;
                }
                revenue_item_Report2.c0 = str;
                Intent intent = new Intent(view.getContext(), (Class<?>) FragmentStatePagerSupport.class);
                intent.putExtra("screen_no", "17");
                intent.putExtra("item_name", strN);
                intent.putExtra("title_", strN + "#" + string);
                intent.putExtra("br_name", string);
                intent.putExtra("f_date", Revenue_item_Report.this.b0);
                intent.putExtra("t_date", Revenue_item_Report.this.c0);
                intent.putExtra("g_id", Revenue_item_Report.this.j);
                intent.putExtra("g_name", Revenue_item_Report.this.k);
                Log.d("lv_click", strN + ":" + string + ":" + Revenue_item_Report.this.b0 + ":" + Revenue_item_Report.this.c0);
                int unused = Revenue_item_Report.k0 = Revenue_item_Report.this.y.getFirstVisiblePosition();
                Revenue_item_Report.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class l extends Handler {
        public l() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Revenue_item_Report revenue_item_Report = Revenue_item_Report.this;
                revenue_item_Report.L(revenue_item_Report.V);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Revenue_item_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Revenue_item_Report revenue_item_Report2 = Revenue_item_Report.this;
                sb.append(revenue_item_Report2.i.ic(revenue_item_Report2.h0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("3")) {
                Revenue_item_Report.this.A.notifyDataSetChanged();
                Revenue_item_Report revenue_item_Report3 = Revenue_item_Report.this;
                Z00 z01 = revenue_item_Report3.i;
                Context baseContext = revenue_item_Report3.getBaseContext();
                Revenue_item_Report revenue_item_Report4 = Revenue_item_Report.this;
                z01.lc(baseContext, revenue_item_Report4.K, revenue_item_Report4.L, revenue_item_Report4.M, revenue_item_Report4.N, revenue_item_Report4.O);
                Revenue_item_Report revenue_item_Report5 = Revenue_item_Report.this;
                int i = revenue_item_Report5.I;
                if (i == 1) {
                    Z00 z02 = revenue_item_Report5.i;
                    Context baseContext2 = revenue_item_Report5.getBaseContext();
                    Revenue_item_Report revenue_item_Report6 = Revenue_item_Report.this;
                    z02.ld(baseContext2, revenue_item_Report6.K, revenue_item_Report6.J);
                } else if (i == 2) {
                    Z00 z03 = revenue_item_Report5.i;
                    Context baseContext3 = revenue_item_Report5.getBaseContext();
                    Revenue_item_Report revenue_item_Report7 = Revenue_item_Report.this;
                    z03.ld(baseContext3, revenue_item_Report7.L, revenue_item_Report7.J);
                } else if (i == 3) {
                    Z00 z04 = revenue_item_Report5.i;
                    Context baseContext4 = revenue_item_Report5.getBaseContext();
                    Revenue_item_Report revenue_item_Report8 = Revenue_item_Report.this;
                    z04.ld(baseContext4, revenue_item_Report8.M, revenue_item_Report8.J);
                } else if (i == 4) {
                    Z00 z05 = revenue_item_Report5.i;
                    Context baseContext5 = revenue_item_Report5.getBaseContext();
                    Revenue_item_Report revenue_item_Report9 = Revenue_item_Report.this;
                    z05.ld(baseContext5, revenue_item_Report9.N, revenue_item_Report9.J);
                } else if (i == 5) {
                    Z00 z06 = revenue_item_Report5.i;
                    Context baseContext6 = revenue_item_Report5.getBaseContext();
                    Revenue_item_Report revenue_item_Report10 = Revenue_item_Report.this;
                    z06.ld(baseContext6, revenue_item_Report10.O, revenue_item_Report10.J);
                }
            }
            Revenue_item_Report.this.Y(false);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Revenue_item_Report.this.N();
            Message message = new Message();
            message.obj = "0";
            Revenue_item_Report.this.U.sendMessage(message);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Revenue_item_Report revenue_item_Report = Revenue_item_Report.this;
            Z00 z00 = revenue_item_Report.i;
            ListView listView = revenue_item_Report.y;
            String strIc = z00.ic(revenue_item_Report.h0);
            Revenue_item_Report revenue_item_Report2 = Revenue_item_Report.this;
            z00.Jb(listView, strIc, false, revenue_item_Report2.b0, revenue_item_Report2.c0, revenue_item_Report2.getString(R.string.item));
            Message message = new Message();
            message.obj = "1";
            Revenue_item_Report.this.U.sendMessage(message);
        }
    }

    public class o extends WebViewClient {
        public o() {
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

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revenue_item_Report revenue_item_Report = Revenue_item_Report.this;
            ArrayAdapter arrayAdapter = new ArrayAdapter(revenue_item_Report, android.R.layout.simple_spinner_dropdown_item, revenue_item_Report.i.T6());
            Revenue_item_Report revenue_item_Report2 = Revenue_item_Report.this;
            revenue_item_Report2.i.T(revenue_item_Report2, arrayAdapter, revenue_item_Report2.g0);
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revenue_item_Report.this.showDialog(0);
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revenue_item_Report.this.showDialog(4);
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Revenue_item_Report revenue_item_Report = Revenue_item_Report.this;
                revenue_item_Report.a0 = 0;
                revenue_item_Report.O();
            } catch (Exception unused) {
            }
        }
    }

    public class v implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public v(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Revenue_item_Report revenue_item_Report = Revenue_item_Report.this;
                revenue_item_Report.a0 = 1;
                if (revenue_item_Report.e0.getText() == null) {
                    Revenue_item_Report.this.b0 = "";
                } else {
                    Revenue_item_Report revenue_item_Report2 = Revenue_item_Report.this;
                    revenue_item_Report2.b0 = revenue_item_Report2.e0.getText().toString();
                }
                if (Revenue_item_Report.this.f0.getText() == null) {
                    Revenue_item_Report.this.c0 = "";
                } else {
                    Revenue_item_Report revenue_item_Report3 = Revenue_item_Report.this;
                    revenue_item_Report3.c0 = revenue_item_Report3.f0.getText().toString();
                }
                if (Revenue_item_Report.this.g0.getText() == null) {
                    Revenue_item_Report.this.d0 = "";
                } else {
                    Revenue_item_Report revenue_item_Report4 = Revenue_item_Report.this;
                    revenue_item_Report4.d0 = revenue_item_Report4.g0.getText().toString();
                }
                Revenue_item_Report.this.O();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class w implements SearchView.OnQueryTextListener {
        public w() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Revenue_item_Report.this.M(1);
            }
            Revenue_item_Report.this.S(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Revenue_item_Report.this.M(0);
            return false;
        }
    }

    public class x implements DatePickerDialog.OnDateSetListener {
        public x() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Revenue_item_Report.this.X = i;
            Revenue_item_Report.this.Y = i2;
            Revenue_item_Report.this.Z = i3;
            try {
                String str = Revenue_item_Report.this.X + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_item_Report.this.Y + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_item_Report.this.Z));
                Locale locale = Locale.ENGLISH;
                Revenue_item_Report.this.e0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class y implements DatePickerDialog.OnDateSetListener {
        public y() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Revenue_item_Report.this.X = i;
            Revenue_item_Report.this.Y = i2;
            Revenue_item_Report.this.Z = i3;
            try {
                String str = Revenue_item_Report.this.X + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_item_Report.this.Y + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_item_Report.this.Z));
                Locale locale = Locale.ENGLISH;
                Revenue_item_Report.this.f0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class z implements Comparator {
        public int a;

        public z(int i) {
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

    private void U(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new c(i2)));
    }

    private void V(List list, int i2) {
        Collections.sort(list, new A(i2));
    }

    private void Z(List list, int i2) {
        Collections.sort(list, new z(i2));
    }

    private void a0(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new b(i2)));
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
            textView.setOnClickListener(new q());
            this.e0.setOnClickListener(new r());
            this.f0.setOnClickListener(new s());
            builder.setPositiveButton(getString(R.string.btn_search), new t());
            builder.setNegativeButton(getString(R.string.btn_cancel), new u());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new v(alertDialogCreate));
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
        Cursor cursorM6;
        this.i.Vb();
        this.V = null;
        int i2 = this.a0;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorM6 = this.i.M6(this.j.equals("0") ? CSS.Value.PERCENTAGE : this.j, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            this.b0 = this.b0.isEmpty() ? CSS.Value.PERCENTAGE : this.b0;
            this.c0 = this.c0.isEmpty() ? CSS.Value.PERCENTAGE : this.c0;
            this.d0 = this.d0.isEmpty() ? CSS.Value.PERCENTAGE : this.d0;
            new C2160f10(this.i).W(this.c0);
            Z00 z00 = this.i;
            if (!this.j.equals("0")) {
                str = this.j;
            }
            cursorM6 = z00.M6(str, this.b0, this.c0, this.d0);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorM6.getCount()));
        this.p = 0.0d;
        this.B.clear();
        cursorM6.moveToFirst();
        while (!cursorM6.isAfterLast()) {
            this.p += Double.parseDouble(cursorM6.getString(cursorM6.getColumnIndex("f5")));
            this.B.add(new C4145vh(cursorM6.getString(cursorM6.getColumnIndex("_id")), cursorM6.getString(cursorM6.getColumnIndex("f1")), cursorM6.getString(cursorM6.getColumnIndex("f2")), this.i.P7(cursorM6.getString(cursorM6.getColumnIndex("f3"))), this.i.P7(cursorM6.getString(cursorM6.getColumnIndex("f4"))), this.i.P7(cursorM6.getString(cursorM6.getColumnIndex("f5"))), this.i.P7(cursorM6.getString(cursorM6.getColumnIndex("f6"))), this.i.P7(cursorM6.getString(cursorM6.getColumnIndex("f7"))), cursorM6.getString(cursorM6.getColumnIndex("f8")), "", cursorM6.getString(cursorM6.getColumnIndex("f10"))));
            cursorM6.moveToNext();
        }
        cursorM6.close();
    }

    public void O() {
        Y(true);
        new Thread(new m()).start();
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
        this.K.setText(getString(R.string.branch));
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
        this.i.ld(this, this.K, this.J);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.K);
        c0372Bn.a(this, this.L);
        c0372Bn.a(this, this.M);
        c0372Bn.a(this, this.N);
        c0372Bn.a(this, this.O);
        this.M.setText(getString(R.string.qty));
        this.N.setText(getString(R.string.total_sum));
        this.O.setText(getString(R.string.revenue));
        this.L.setOnClickListener(new d());
        this.K.setOnClickListener(new e());
        this.M.setOnClickListener(new f());
        this.N.setOnClickListener(new g());
        this.O.setOnClickListener(new h());
    }

    public void S(String str) {
        this.A.getFilter().filter(str);
    }

    public void T() {
        Y(true);
        new Thread(new n()).start();
    }

    public void W(boolean z2) {
    }

    public void X() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new o());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new p());
        builder.show();
    }

    public void Y(boolean z2) {
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

    public void b0(View view, int i2) {
        if (this.J == 0) {
            Z(this.B, i2);
            this.J = 1;
        } else {
            V(this.B, i2);
            this.J = 0;
        }
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new i(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new j());
        builder.create().show();
    }

    public void c0(View view, int i2) {
        if (this.J == 0) {
            a0(this.B, i2);
            this.J = 1;
        } else {
            U(this.B, i2);
            this.J = 0;
        }
    }

    public void d0(View view) {
        Y(true);
        new Thread(new RunnableC3035a(view)).start();
    }

    public void help_btn(View view) {
        X();
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
        W(true);
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
        searchView.setOnQueryTextListener(new w());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        L(this.i.L2());
        W(true);
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
        K();
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
        if (Bill_edit.Q2) {
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
