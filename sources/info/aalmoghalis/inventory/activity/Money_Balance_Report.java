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
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Money_Balance_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0922Sv B;
    public int Q;
    public int R;
    public int S;
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
    public TextView I = null;
    public ImageView J = null;
    public String K = "";
    public Dialog L = null;
    public Handler M = new a();
    public String N = "";
    public Cursor O = null;
    public boolean P = false;
    public int T = 0;
    public String U = CSS.Value.PERCENTAGE;
    public String V = CSS.Value.PERCENTAGE;
    public TextView W = null;
    public TextView X = null;
    public DatePickerDialog.OnDateSetListener Y = new l();
    public DatePickerDialog.OnDateSetListener Z = new m();

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Money_Balance_Report.this.I();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Money_Balance_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Money_Balance_Report money_Balance_Report = Money_Balance_Report.this;
                sb.append(money_Balance_Report.i.ic(money_Balance_Report.N));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            Money_Balance_Report.this.U(false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Money_Balance_Report.this.K();
            Message message = new Message();
            message.obj = "0";
            Money_Balance_Report.this.M.sendMessage(message);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Money_Balance_Report money_Balance_Report = Money_Balance_Report.this;
            Z00 z00 = money_Balance_Report.i;
            ListView listView = money_Balance_Report.z;
            String strIc = z00.ic(money_Balance_Report.N);
            Money_Balance_Report money_Balance_Report2 = Money_Balance_Report.this;
            z00.Db(listView, strIc, money_Balance_Report2.U, money_Balance_Report2.V);
            Message message = new Message();
            message.obj = "1";
            Money_Balance_Report.this.M.sendMessage(message);
        }
    }

    public class d extends WebViewClient {
        public d() {
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

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Money_Balance_Report.this.showDialog(0);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Money_Balance_Report.this.showDialog(4);
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Money_Balance_Report.this.T = 0;
                dialogInterface.dismiss();
                Money_Balance_Report.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public j(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Money_Balance_Report money_Balance_Report = Money_Balance_Report.this;
                money_Balance_Report.T = 1;
                if (money_Balance_Report.W.getText() == null) {
                    Money_Balance_Report.this.U = "";
                } else {
                    Money_Balance_Report money_Balance_Report2 = Money_Balance_Report.this;
                    money_Balance_Report2.U = money_Balance_Report2.W.getText().toString();
                }
                if (Money_Balance_Report.this.X.getText() == null) {
                    Money_Balance_Report.this.V = "";
                } else {
                    Money_Balance_Report money_Balance_Report3 = Money_Balance_Report.this;
                    money_Balance_Report3.V = money_Balance_Report3.X.getText().toString();
                }
                this.a.dismiss();
                Money_Balance_Report.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class k implements SearchView.OnQueryTextListener {
        public k() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Money_Balance_Report.this.J(1);
            }
            Money_Balance_Report.this.Q(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Money_Balance_Report.this.J(0);
            return false;
        }
    }

    public class l implements DatePickerDialog.OnDateSetListener {
        public l() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Money_Balance_Report.this.Q = i;
            Money_Balance_Report.this.R = i2;
            Money_Balance_Report.this.S = i3;
            try {
                String str = Money_Balance_Report.this.Q + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Money_Balance_Report.this.R + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Money_Balance_Report.this.S));
                Locale locale = Locale.ENGLISH;
                Money_Balance_Report.this.W.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class m implements DatePickerDialog.OnDateSetListener {
        public m() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Money_Balance_Report.this.Q = i;
            Money_Balance_Report.this.R = i2;
            Money_Balance_Report.this.S = i3;
            try {
                String str = Money_Balance_Report.this.Q + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Money_Balance_Report.this.R + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Money_Balance_Report.this.S));
                Locale locale = Locale.ENGLISH;
                Money_Balance_Report.this.X.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public n(TextView textView, ImageView imageView) {
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
                Money_Balance_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Money_Balance_Report.this.l = 0;
                Money_Balance_Report.this.L();
            } catch (Exception unused) {
                Toast.makeText(Money_Balance_Report.this.getApplicationContext(), Money_Balance_Report.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void G() {
        try {
            this.T = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.W = (TextView) viewInflate.findViewById(R.id.f_date);
            this.X = (TextView) viewInflate.findViewById(R.id.t_date);
            this.W.setVisibility(8);
            this.W.setOnClickListener(new f());
            this.X.setOnClickListener(new g());
            builder.setPositiveButton(getString(R.string.btn_search), new h());
            builder.setNegativeButton(getString(R.string.btn_cancel), new i());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new j(alertDialogCreate));
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
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep6_, this.C, 4, O(), 1);
        this.B = c0922Sv;
        c0922Sv.l.clear();
        this.B.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.B);
        this.I.setText(getString(R.string.net_hdr) + " : " + this.i.P7(String.valueOf(this.p)));
    }

    public void J(int i2) {
        try {
            if (i2 == 1) {
                this.I.setText(getString(R.string.net_hdr) + " " + this.i.P7(String.valueOf(this.p)));
            } else {
                double dM = M(this.B.e);
                this.I.setText(getString(R.string.net_hdr) + " " + this.i.P7(String.valueOf(dM)));
            }
        } catch (Exception unused) {
        }
    }

    public void K() {
        Cursor cursorD7;
        if (!this.P) {
            this.P = true;
            this.i.Vb();
        }
        int i2 = this.T;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorD7 = this.i.D7(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            this.U = this.U.isEmpty() ? CSS.Value.PERCENTAGE : this.U;
            if (!this.V.isEmpty()) {
                str = this.V;
            }
            this.V = str;
            new C2160f10(this.i).W(this.V);
            cursorD7 = this.i.D7(this.U, this.V);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorD7.getCount()));
        this.p = 0.0d;
        this.q = 0.0d;
        this.C.clear();
        cursorD7.moveToFirst();
        while (!cursorD7.isAfterLast()) {
            this.p += cursorD7.getDouble(cursorD7.getColumnIndex("f2")) * (-1.0d);
            double d2 = cursorD7.getDouble(cursorD7.getColumnIndex("f2"));
            this.C.add(new C4145vh(cursorD7.getString(cursorD7.getColumnIndex("_id")), cursorD7.getString(cursorD7.getColumnIndex("f1")), d2 < 0.0d ? this.i.P7(String.valueOf(Math.abs(d2))) : "0", d2 >= 0.0d ? this.i.P7(String.valueOf(Math.abs(d2))) : "0", "", "", "", "", ""));
            cursorD7.moveToNext();
        }
        cursorD7.close();
    }

    public void L() {
        U(true);
        new Thread(new b()).start();
    }

    public double M(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).n().replaceAll(",", "")) - Double.parseDouble(((C4145vh) list.get(i2)).o().replaceAll(",", ""));
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

    public void P() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        textView.setText(getString(R.string.account));
        textView2.setText(this.i.c5());
        textView3.setText(this.i.Q2());
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
    }

    public void Q(String str) {
        this.B.getFilter().filter(str);
    }

    public void R() {
        U(true);
        new Thread(new c()).start();
    }

    public void S(boolean z) {
    }

    public void T() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new d());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new e());
        builder.show();
    }

    public void U(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z) {
            android.app.AlertDialog alertDialogCreate = builder.create();
            this.L = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.L;
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
        this.K = textView.getText().toString();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new n(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new o());
        builder.create().show();
    }

    public void help_btn(View view) {
        T();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.K.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.K + "'");
            }
            this.K = "";
            L();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.T = 0;
        L();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill6);
        setTitle(getIntent().getStringExtra("title_"));
        this.z = (ListView) findViewById(R.id.list_items);
        this.z.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        this.I = (TextView) findViewById(R.id.footer_sum);
        ImageView imageView = (ImageView) findViewById(R.id.img_add_amount);
        this.J = imageView;
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
        this.Q = calendar.get(1);
        this.R = calendar.get(2);
        this.S = calendar.get(5);
        S(true);
        L();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.Y, this.Q, this.R, this.S);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.Z, this.Q, this.R, this.S);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new k());
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
        this.N = getTitle().toString();
        R();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
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
