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
import defpackage.C3966tX;
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
public class Revenue_customer_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, a.b {
    public static int l0;
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
    public String i0;
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
    public TextView A = null;
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
    public Handler V = new l();
    public Cursor W = null;
    public boolean X = false;
    public int b0 = 0;
    public String c0 = CSS.Value.PERCENTAGE;
    public String d0 = CSS.Value.PERCENTAGE;
    public String e0 = CSS.Value.PERCENTAGE;
    public TextView f0 = null;
    public TextView g0 = null;
    public TextView h0 = null;
    public DatePickerDialog.OnDateSetListener j0 = new x();
    public DatePickerDialog.OnDateSetListener k0 = new y();

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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Revenue_customer_Report$a, reason: case insensitive filesystem */
    public class RunnableC3034a implements Runnable {
        public final /* synthetic */ View a;

        public RunnableC3034a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    Revenue_customer_Report.this.c0(this.a, 1);
                    Revenue_customer_Report.this.K = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    Revenue_customer_Report.this.c0(this.a, 2);
                    Revenue_customer_Report.this.K = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    Revenue_customer_Report.this.b0(this.a, 3);
                    Revenue_customer_Report.this.K = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    Revenue_customer_Report.this.b0(this.a, 4);
                    Revenue_customer_Report.this.K = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    Revenue_customer_Report.this.b0(this.a, 5);
                    Revenue_customer_Report.this.K = 5;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            Revenue_customer_Report.this.V.sendMessage(message);
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
                Revenue_customer_Report.this.d0(view);
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
                Revenue_customer_Report.this.d0(view);
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
                Revenue_customer_Report.this.d0(view);
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
                Revenue_customer_Report.this.d0(view);
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
                Revenue_customer_Report.this.d0(view);
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
                Revenue_customer_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Revenue_customer_Report.this.l = 0;
                Revenue_customer_Report.this.O();
            } catch (Exception unused) {
                Toast.makeText(Revenue_customer_Report.this.getApplicationContext(), Revenue_customer_Report.this.getString(R.string.sql_error), 1);
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
                Revenue_customer_Report revenue_customer_Report = Revenue_customer_Report.this;
                boolean zIsEmpty = revenue_customer_Report.c0.isEmpty();
                String str = CSS.Value.PERCENTAGE;
                revenue_customer_Report.c0 = zIsEmpty ? CSS.Value.PERCENTAGE : Revenue_customer_Report.this.c0;
                Revenue_customer_Report revenue_customer_Report2 = Revenue_customer_Report.this;
                revenue_customer_Report2.d0 = revenue_customer_Report2.d0.isEmpty() ? CSS.Value.PERCENTAGE : Revenue_customer_Report.this.d0;
                Revenue_customer_Report revenue_customer_Report3 = Revenue_customer_Report.this;
                if (!revenue_customer_Report3.e0.isEmpty()) {
                    str = Revenue_customer_Report.this.e0;
                }
                revenue_customer_Report3.e0 = str;
                Intent intent = new Intent(view.getContext(), (Class<?>) FragmentStatePagerSupport.class);
                intent.putExtra("screen_no", "18");
                FragmentStatePagerSupport.T = 2;
                intent.putExtra("report_type2", 2);
                intent.putExtra("item_name", strN);
                intent.putExtra("title_", strN + "#" + string);
                intent.putExtra("br_name", string);
                intent.putExtra("f_date", Revenue_customer_Report.this.c0);
                intent.putExtra("t_date", Revenue_customer_Report.this.d0);
                intent.putExtra("item_type", Revenue_customer_Report.this.e0);
                intent.putExtra("g_id", Revenue_customer_Report.this.j);
                intent.putExtra("g_name", Revenue_customer_Report.this.k);
                Log.d("lv_click", strN + ":" + string + ":" + Revenue_customer_Report.this.c0 + ":" + Revenue_customer_Report.this.d0 + ":" + Revenue_customer_Report.this.e0);
                int unused = Revenue_customer_Report.l0 = Revenue_customer_Report.this.y.getFirstVisiblePosition();
                Revenue_customer_Report.this.startActivity(intent);
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
                Revenue_customer_Report revenue_customer_Report = Revenue_customer_Report.this;
                revenue_customer_Report.L(revenue_customer_Report.W);
                C3966tX c3966tX = new C3966tX();
                Revenue_customer_Report revenue_customer_Report2 = Revenue_customer_Report.this;
                c3966tX.A(revenue_customer_Report2, revenue_customer_Report2.y, revenue_customer_Report2.A, 1);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Revenue_customer_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Revenue_customer_Report revenue_customer_Report3 = Revenue_customer_Report.this;
                sb.append(revenue_customer_Report3.i.ic(revenue_customer_Report3.i0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("3")) {
                Revenue_customer_Report.this.B.notifyDataSetChanged();
                Revenue_customer_Report revenue_customer_Report4 = Revenue_customer_Report.this;
                Z00 z01 = revenue_customer_Report4.i;
                Context baseContext = revenue_customer_Report4.getBaseContext();
                Revenue_customer_Report revenue_customer_Report5 = Revenue_customer_Report.this;
                z01.lc(baseContext, revenue_customer_Report5.L, revenue_customer_Report5.M, revenue_customer_Report5.N, revenue_customer_Report5.O, revenue_customer_Report5.P);
                Revenue_customer_Report revenue_customer_Report6 = Revenue_customer_Report.this;
                int i = revenue_customer_Report6.K;
                if (i == 1) {
                    Z00 z02 = revenue_customer_Report6.i;
                    Context baseContext2 = revenue_customer_Report6.getBaseContext();
                    Revenue_customer_Report revenue_customer_Report7 = Revenue_customer_Report.this;
                    z02.ld(baseContext2, revenue_customer_Report7.L, revenue_customer_Report7.J);
                } else if (i == 2) {
                    Z00 z03 = revenue_customer_Report6.i;
                    Context baseContext3 = revenue_customer_Report6.getBaseContext();
                    Revenue_customer_Report revenue_customer_Report8 = Revenue_customer_Report.this;
                    z03.ld(baseContext3, revenue_customer_Report8.M, revenue_customer_Report8.J);
                } else if (i == 3) {
                    Z00 z04 = revenue_customer_Report6.i;
                    Context baseContext4 = revenue_customer_Report6.getBaseContext();
                    Revenue_customer_Report revenue_customer_Report9 = Revenue_customer_Report.this;
                    z04.ld(baseContext4, revenue_customer_Report9.N, revenue_customer_Report9.J);
                } else if (i == 4) {
                    Z00 z05 = revenue_customer_Report6.i;
                    Context baseContext5 = revenue_customer_Report6.getBaseContext();
                    Revenue_customer_Report revenue_customer_Report10 = Revenue_customer_Report.this;
                    z05.ld(baseContext5, revenue_customer_Report10.O, revenue_customer_Report10.J);
                } else if (i == 5) {
                    Z00 z06 = revenue_customer_Report6.i;
                    Context baseContext6 = revenue_customer_Report6.getBaseContext();
                    Revenue_customer_Report revenue_customer_Report11 = Revenue_customer_Report.this;
                    z06.ld(baseContext6, revenue_customer_Report11.P, revenue_customer_Report11.J);
                }
            }
            Revenue_customer_Report.this.Y(false);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Revenue_customer_Report.this.N();
            Message message = new Message();
            message.obj = "0";
            Revenue_customer_Report.this.V.sendMessage(message);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Revenue_customer_Report revenue_customer_Report = Revenue_customer_Report.this;
            Z00 z00 = revenue_customer_Report.i;
            ListView listView = revenue_customer_Report.y;
            String strIc = z00.ic(revenue_customer_Report.i0);
            Revenue_customer_Report revenue_customer_Report2 = Revenue_customer_Report.this;
            z00.Jb(listView, strIc, false, revenue_customer_Report2.c0, revenue_customer_Report2.d0, revenue_customer_Report2.getString(R.string.cus));
            Message message = new Message();
            message.obj = "1";
            Revenue_customer_Report.this.V.sendMessage(message);
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
            Revenue_customer_Report revenue_customer_Report = Revenue_customer_Report.this;
            ArrayAdapter arrayAdapter = new ArrayAdapter(revenue_customer_Report, android.R.layout.simple_spinner_dropdown_item, revenue_customer_Report.i.T6());
            Revenue_customer_Report revenue_customer_Report2 = Revenue_customer_Report.this;
            revenue_customer_Report2.i.T(revenue_customer_Report2, arrayAdapter, revenue_customer_Report2.h0);
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revenue_customer_Report.this.showDialog(0);
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revenue_customer_Report.this.showDialog(4);
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
                Revenue_customer_Report revenue_customer_Report = Revenue_customer_Report.this;
                revenue_customer_Report.b0 = 0;
                revenue_customer_Report.O();
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
                Revenue_customer_Report revenue_customer_Report = Revenue_customer_Report.this;
                revenue_customer_Report.b0 = 1;
                if (revenue_customer_Report.f0.getText() == null) {
                    Revenue_customer_Report.this.c0 = "";
                } else {
                    Revenue_customer_Report revenue_customer_Report2 = Revenue_customer_Report.this;
                    revenue_customer_Report2.c0 = revenue_customer_Report2.f0.getText().toString();
                }
                if (Revenue_customer_Report.this.g0.getText() == null) {
                    Revenue_customer_Report.this.d0 = "";
                } else {
                    Revenue_customer_Report revenue_customer_Report3 = Revenue_customer_Report.this;
                    revenue_customer_Report3.d0 = revenue_customer_Report3.g0.getText().toString();
                }
                if (Revenue_customer_Report.this.h0.getText() == null) {
                    Revenue_customer_Report.this.e0 = "";
                } else {
                    Revenue_customer_Report revenue_customer_Report4 = Revenue_customer_Report.this;
                    revenue_customer_Report4.e0 = revenue_customer_Report4.h0.getText().toString();
                }
                Revenue_customer_Report.this.O();
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
                Revenue_customer_Report.this.M(1);
            }
            Revenue_customer_Report.this.S(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Revenue_customer_Report.this.M(0);
            return false;
        }
    }

    public class x implements DatePickerDialog.OnDateSetListener {
        public x() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Revenue_customer_Report.this.Y = i;
            Revenue_customer_Report.this.Z = i2;
            Revenue_customer_Report.this.a0 = i3;
            try {
                String str = Revenue_customer_Report.this.Y + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_customer_Report.this.Z + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_customer_Report.this.a0));
                Locale locale = Locale.ENGLISH;
                Revenue_customer_Report.this.f0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class y implements DatePickerDialog.OnDateSetListener {
        public y() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Revenue_customer_Report.this.Y = i;
            Revenue_customer_Report.this.Z = i2;
            Revenue_customer_Report.this.a0 = i3;
            try {
                String str = Revenue_customer_Report.this.Y + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_customer_Report.this.Z + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revenue_customer_Report.this.a0));
                Locale locale = Locale.ENGLISH;
                Revenue_customer_Report.this.g0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
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
            this.b0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input_item_type, (ViewGroup) null);
            builder.setView(viewInflate);
            this.f0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.g0 = (TextView) viewInflate.findViewById(R.id.t_date);
            TextView textView = (TextView) viewInflate.findViewById(R.id.item_type);
            this.h0 = textView;
            textView.setOnClickListener(new q());
            this.f0.setOnClickListener(new r());
            this.g0.setOnClickListener(new s());
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
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rev1, this.C, 17);
        this.B = c0922Sv;
        c0922Sv.l.clear();
        this.B.notifyDataSetChanged();
        this.y.setAdapter((ListAdapter) this.B);
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

    public void M(int i2) {
        try {
            if (i2 == 1) {
                this.I.setText(this.i.P7(String.valueOf(this.p)));
            } else {
                this.I.setText(this.i.P7(String.valueOf(P(this.B.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void N() {
        Cursor cursorN6;
        this.i.Vb();
        this.W = null;
        int i2 = this.b0;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorN6 = this.i.N6(this.j.equals("0") ? CSS.Value.PERCENTAGE : this.j, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            this.c0 = this.c0.isEmpty() ? CSS.Value.PERCENTAGE : this.c0;
            this.d0 = this.d0.isEmpty() ? CSS.Value.PERCENTAGE : this.d0;
            this.e0 = this.e0.isEmpty() ? CSS.Value.PERCENTAGE : this.e0;
            new C2160f10(this.i).W(this.d0);
            Z00 z00 = this.i;
            if (!this.j.equals("0")) {
                str = this.j;
            }
            cursorN6 = z00.N6(str, this.c0, this.d0, this.e0);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorN6.getCount()));
        this.p = 0.0d;
        this.C.clear();
        cursorN6.moveToFirst();
        while (!cursorN6.isAfterLast()) {
            this.p += Double.parseDouble(cursorN6.getString(cursorN6.getColumnIndex("f5")));
            this.C.add(new C4145vh(cursorN6.getString(cursorN6.getColumnIndex("_id")), cursorN6.getString(cursorN6.getColumnIndex("f1")), cursorN6.getString(cursorN6.getColumnIndex("f2")), this.i.P7(cursorN6.getString(cursorN6.getColumnIndex("f3"))), this.i.P7(cursorN6.getString(cursorN6.getColumnIndex("f4"))), this.i.P7(cursorN6.getString(cursorN6.getColumnIndex("f5"))), this.i.P7(cursorN6.getString(cursorN6.getColumnIndex("f6"))), this.i.P7(cursorN6.getString(cursorN6.getColumnIndex("f7"))), cursorN6.getString(cursorN6.getColumnIndex("f8")), "", null));
            cursorN6.moveToNext();
        }
        cursorN6.close();
    }

    public void O() {
        new C3966tX().A(this, this.y, this.A, -1);
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
        this.L = (TextView) findViewById(R.id.f1);
        this.M = (TextView) findViewById(R.id.f2);
        this.N = (TextView) findViewById(R.id.f3);
        this.O = (TextView) findViewById(R.id.f4);
        this.P = (TextView) findViewById(R.id.f5);
        this.Q = (TextView) findViewById(R.id.f6);
        this.R = (TextView) findViewById(R.id.f7);
        this.S = (TextView) findViewById(R.id.f8);
        this.L.setText(getString(R.string.branch));
        this.M.setText(getString(R.string.cus));
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
        this.N.setText(getString(R.string.qty));
        this.O.setText(getString(R.string.total_sum));
        this.P.setText(getString(R.string.revenue));
        this.M.setOnClickListener(new d());
        this.L.setOnClickListener(new e());
        this.N.setOnClickListener(new f());
        this.O.setOnClickListener(new g());
        this.P.setOnClickListener(new h());
    }

    public void S(String str) {
        this.B.getFilter().filter(str);
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
            this.U = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.U;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void add_btn(View view) {
        Bill_edit.P2 = true;
        this.i.z(this, this.j, this.k);
    }

    public void b0(View view, int i2) {
        if (this.J == 0) {
            Z(this.C, i2);
            this.J = 1;
        } else {
            V(this.C, i2);
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
        this.T = textView.getText().toString();
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
            a0(this.C, i2);
            this.J = 1;
        } else {
            U(this.C, i2);
            this.J = 0;
        }
    }

    public void d0(View view) {
        Y(true);
        new Thread(new RunnableC3034a(view)).start();
    }

    public void help_btn(View view) {
        X();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.T.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.T + "'");
            }
            this.T = "";
            O();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.b0 = 0;
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
        TextView textView = (TextView) findViewById(R.id.emptyResults);
        this.A = textView;
        this.y.setEmptyView(textView);
        this.i = new Z00(this.h, this);
        this.y.setOnItemClickListener(new k());
        this.I = (TextView) findViewById(R.id.footer_sum);
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
        this.Y = calendar.get(1);
        this.Z = calendar.get(2);
        this.a0 = calendar.get(5);
        W(true);
        O();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.j0, this.Y, this.Z, this.a0);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.k0, this.Y, this.Z, this.a0);
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
        if (this.e0.equals(CSS.Value.PERCENTAGE)) {
            str = "";
        } else {
            str = "-" + this.e0;
        }
        sb.append(str);
        this.i0 = sb.toString();
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
