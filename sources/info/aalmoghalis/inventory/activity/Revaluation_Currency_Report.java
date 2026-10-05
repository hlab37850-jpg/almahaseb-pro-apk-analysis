package info.aalmoghalis.inventory.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
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
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.App;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Revaluation_Currency_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0922Sv B;
    public int R;
    public int S;
    public int T;
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
    public ImageView K = null;
    public String L = "";
    public Dialog M = null;
    public Handler N = new b();
    public String O = "";
    public Cursor P = null;
    public boolean Q = false;
    public int U = 0;
    public String V = CSS.Value.PERCENTAGE;
    public String W = CSS.Value.PERCENTAGE;
    public TextView X = null;
    public TextView Y = null;
    public DatePickerDialog.OnDateSetListener Z = new n();
    public DatePickerDialog.OnDateSetListener a0 = new o();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Revaluation_Currency_Report.this.I();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Revaluation_Currency_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Revaluation_Currency_Report revaluation_Currency_Report = Revaluation_Currency_Report.this;
                sb.append(revaluation_Currency_Report.i.ic(revaluation_Currency_Report.O));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            Revaluation_Currency_Report.this.U(false);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Revaluation_Currency_Report.this.K();
            Message message = new Message();
            message.obj = "0";
            Revaluation_Currency_Report.this.N.sendMessage(message);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Revaluation_Currency_Report revaluation_Currency_Report = Revaluation_Currency_Report.this;
            Z00 z00 = revaluation_Currency_Report.i;
            ListView listView = revaluation_Currency_Report.z;
            String strIc = z00.ic(revaluation_Currency_Report.O);
            Revaluation_Currency_Report revaluation_Currency_Report2 = Revaluation_Currency_Report.this;
            z00.Ib(listView, strIc, revaluation_Currency_Report2.V, revaluation_Currency_Report2.W);
            Message message = new Message();
            message.obj = "1";
            Revaluation_Currency_Report.this.N.sendMessage(message);
        }
    }

    public class e extends WebViewClient {
        public e() {
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

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revaluation_Currency_Report.this.showDialog(0);
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
                    Revaluation_Currency_Report revaluation_Currency_Report = Revaluation_Currency_Report.this;
                    Toast.makeText(revaluation_Currency_Report, revaluation_Currency_Report.getString(R.string.parent_account_alarm), 0).show();
                    return;
                }
                C4143vg c4143vgQ4 = Revaluation_Currency_Report.this.i.q4(c4145vh.a());
                Log.d("trace_cus_click=", c4143vgQ4.j() + ":" + c4145vh.n());
                c4143vgQ4.m(c4145vh.n());
                Bundle bundle = new Bundle();
                ArrayList arrayList = new ArrayList();
                arrayList.add(c4143vgQ4);
                ((App) Revaluation_Currency_Report.this.getApplication()).d(arrayList);
                Revaluation_Currency_Report revaluation_Currency_Report2 = Revaluation_Currency_Report.this;
                Z00 z00 = revaluation_Currency_Report2.i;
                String strI = c4143vgQ4.i();
                String strA = c4143vgQ4.a();
                String strH = c4143vgQ4.h();
                String strJ = c4143vgQ4.j();
                String strJ4 = Revaluation_Currency_Report.this.i.j4(c4143vgQ4.f());
                String strB = c4143vgQ4.b();
                Revaluation_Currency_Report revaluation_Currency_Report3 = Revaluation_Currency_Report.this;
                z00.q9(revaluation_Currency_Report2, strI, strA, strH, strJ, strJ4, strB, 1, revaluation_Currency_Report3.V, revaluation_Currency_Report3.W, bundle);
            } catch (Exception unused) {
            }
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Revaluation_Currency_Report.this.showDialog(4);
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
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Revaluation_Currency_Report.this.U = 0;
                dialogInterface.dismiss();
                Revaluation_Currency_Report.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class l implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public l(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Revaluation_Currency_Report revaluation_Currency_Report = Revaluation_Currency_Report.this;
                revaluation_Currency_Report.U = 1;
                if (revaluation_Currency_Report.X.getText() == null) {
                    Revaluation_Currency_Report.this.V = "";
                } else {
                    Revaluation_Currency_Report revaluation_Currency_Report2 = Revaluation_Currency_Report.this;
                    revaluation_Currency_Report2.V = revaluation_Currency_Report2.X.getText().toString();
                }
                if (Revaluation_Currency_Report.this.Y.getText() == null) {
                    Revaluation_Currency_Report.this.W = "";
                } else {
                    Revaluation_Currency_Report revaluation_Currency_Report3 = Revaluation_Currency_Report.this;
                    revaluation_Currency_Report3.W = revaluation_Currency_Report3.Y.getText().toString();
                }
                this.a.dismiss();
                Revaluation_Currency_Report.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class m implements SearchView.OnQueryTextListener {
        public m() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Revaluation_Currency_Report.this.J(1);
            }
            Revaluation_Currency_Report.this.Q(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Revaluation_Currency_Report.this.J(0);
            return false;
        }
    }

    public class n implements DatePickerDialog.OnDateSetListener {
        public n() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Revaluation_Currency_Report.this.R = i;
            Revaluation_Currency_Report.this.S = i2;
            Revaluation_Currency_Report.this.T = i3;
            try {
                String str = Revaluation_Currency_Report.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revaluation_Currency_Report.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revaluation_Currency_Report.this.T));
                Locale locale = Locale.ENGLISH;
                Revaluation_Currency_Report.this.X.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class o implements DatePickerDialog.OnDateSetListener {
        public o() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Revaluation_Currency_Report.this.R = i;
            Revaluation_Currency_Report.this.S = i2;
            Revaluation_Currency_Report.this.T = i3;
            try {
                String str = Revaluation_Currency_Report.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revaluation_Currency_Report.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Revaluation_Currency_Report.this.T));
                Locale locale = Locale.ENGLISH;
                Revaluation_Currency_Report.this.Y.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public p(TextView textView, ImageView imageView) {
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
                Revaluation_Currency_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Revaluation_Currency_Report.this.l = 0;
                Revaluation_Currency_Report.this.L();
            } catch (Exception unused) {
                Toast.makeText(Revaluation_Currency_Report.this.getApplicationContext(), Revaluation_Currency_Report.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public void G() {
        try {
            this.U = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.X = (TextView) viewInflate.findViewById(R.id.f_date);
            this.Y = (TextView) viewInflate.findViewById(R.id.t_date);
            this.X.setOnClickListener(new g());
            this.Y.setOnClickListener(new i());
            builder.setPositiveButton(getString(R.string.btn_search), new j());
            builder.setNegativeButton(getString(R.string.btn_cancel), new k());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new l(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void H() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void I() {
        P();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rev1, this.C, 15, O(), 1);
        this.B = c0922Sv;
        c0922Sv.l.clear();
        this.B.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.B);
        this.J.setText(getString(R.string.currency_diff) + " : " + this.i.P7(String.valueOf(this.p)));
    }

    public void J(int i2) {
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
            double dM = M(this.B.e);
            TextView textView2 = this.J;
            StringBuilder sb2 = new StringBuilder();
            if (dM >= 0.0d) {
                str = this.i.c5() + ":-";
            } else {
                str = this.i.Q2() + ":-";
            }
            sb2.append(str);
            sb2.append(" ");
            sb2.append(this.i.P7(String.valueOf(dM)));
            textView2.setText(sb2.toString());
        } catch (Exception unused) {
        }
    }

    public void K() {
        Cursor cursorO8;
        int i2 = this.U;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorO8 = this.i.o8(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            this.V = this.V.isEmpty() ? CSS.Value.PERCENTAGE : this.V;
            if (!this.W.isEmpty()) {
                str = this.W;
            }
            this.W = str;
            cursorO8 = this.i.o8(this.V, str);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorO8.getCount()));
        this.p = 0.0d;
        this.q = 0.0d;
        this.C.clear();
        cursorO8.moveToFirst();
        while (!cursorO8.isAfterLast()) {
            if (cursorO8.getString(cursorO8.getColumnIndex("f5")).equals("1")) {
                this.p += cursorO8.getDouble(cursorO8.getColumnIndex("f4"));
            }
            this.C.add(new C4145vh(cursorO8.getString(cursorO8.getColumnIndex("_id")), cursorO8.getString(cursorO8.getColumnIndex("f1")), cursorO8.getString(cursorO8.getColumnIndex("f7")), this.i.P7(String.valueOf(cursorO8.getDouble(cursorO8.getColumnIndex("f2")))), this.i.P7(String.valueOf(cursorO8.getDouble(cursorO8.getColumnIndex("f3")))), this.i.P7(String.valueOf(cursorO8.getDouble(cursorO8.getColumnIndex("f4")))), cursorO8.getString(cursorO8.getColumnIndex("f5")), cursorO8.getString(cursorO8.getColumnIndex("f6")), cursorO8.getString(cursorO8.getColumnIndex("f7"))));
            cursorO8.moveToNext();
        }
        cursorO8.close();
    }

    public void L() {
        U(true);
        new Thread(new c()).start();
    }

    public double M(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).o().replaceAll(",", ""));
        }
        return d2;
    }

    public void N(String str, String str2) {
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

    public boolean O() {
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void P() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        TextView textView5 = (TextView) findViewById(R.id.f5);
        textView.setText(getString(R.string.account));
        textView2.setText(getString(R.string.currency));
        textView3.setText(getString(R.string.balance2) + "_" + this.i.l3("0"));
        textView4.setText(getString(R.string.balance2) + "_" + getString(R.string.foriegn_curr));
        textView5.setText(getString(R.string.trail_diff));
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
        c0372Bn.a(this, textView4);
        c0372Bn.a(this, textView5);
        if (O()) {
            textView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams.weight = 60.0f;
            textView2.setLayoutParams(layoutParams);
        }
    }

    public void Q(String str) {
        this.B.getFilter().filter(str);
    }

    public void R() {
        U(true);
        new Thread(new d()).start();
    }

    public void S(boolean z) {
    }

    public void T() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new e());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new f());
        builder.show();
    }

    public void U(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z) {
            android.app.AlertDialog alertDialogCreate = builder.create();
            this.M = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.M;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void add_btn(View view) {
        this.i.z(this, this.j, this.k);
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
        this.L = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        N(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new p(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new a());
        builder.create().show();
    }

    public void help_btn(View view) {
        T();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.L.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.L + "'");
            }
            this.L = "";
            L();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.U = 0;
        L();
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
        this.J = (TextView) findViewById(R.id.footer_sum);
        ImageView imageView = (ImageView) findViewById(R.id.img_add_amount);
        this.K = imageView;
        imageView.setVisibility(8);
        try {
            P();
            if (getIntent().getStringExtra("g_id") != null) {
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getIntent().getStringExtra("title_"));
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.R = calendar.get(1);
        this.S = calendar.get(2);
        this.T = calendar.get(5);
        S(true);
        L();
        if (!this.Q) {
            this.Q = true;
            if (this.i.U2() > 0) {
                Toast.makeText(this, getString(R.string.alarm_curr_price), 0).show();
            }
        }
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.Z, this.R, this.S, this.T);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.a0, this.R, this.S, this.T);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new m());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        S(true);
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
            G();
            return true;
        }
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        H();
        this.O = getTitle().toString();
        R();
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
