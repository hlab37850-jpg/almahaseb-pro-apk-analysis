package info.aalmoghalis.inventory.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
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
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C1839c10;
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
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class Trail_Balance_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
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
    public CheckBox Z = null;
    public CheckBox a0 = null;
    public CheckBox b0 = null;
    public DatePickerDialog.OnDateSetListener c0 = new p();
    public DatePickerDialog.OnDateSetListener d0 = new q();

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
            Trail_Balance_Report.this.a0(false);
            if (message.obj.toString().equals("0")) {
                Trail_Balance_Report.this.L();
                if (new C1839c10(Trail_Balance_Report.this).c(Trail_Balance_Report.this.i)) {
                    new C1839c10(Trail_Balance_Report.this).E(Trail_Balance_Report.this.i);
                    return;
                }
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = Trail_Balance_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Trail_Balance_Report trail_Balance_Report = Trail_Balance_Report.this;
                sb.append(trail_Balance_Report.i.ic(trail_Balance_Report.O));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Trail_Balance_Report trail_Balance_Report = Trail_Balance_Report.this;
            Z00 z00 = trail_Balance_Report.i;
            ListView listView = trail_Balance_Report.z;
            String strIc = z00.ic(trail_Balance_Report.O);
            Trail_Balance_Report trail_Balance_Report2 = Trail_Balance_Report.this;
            z00.Lb(listView, strIc, trail_Balance_Report2.V, trail_Balance_Report2.W);
            Message message = new Message();
            message.obj = "1";
            Trail_Balance_Report.this.N.sendMessage(message);
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

    public class f implements CompoundButton.OnCheckedChangeListener {
        public f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                Trail_Balance_Report.this.i.Mc("pref_trail_balance_old_balance", z);
            } else {
                Trail_Balance_Report.this.i.Mc("pref_trail_balance_old_balance", z);
            }
        }
    }

    public class g implements CompoundButton.OnCheckedChangeListener {
        public g() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                Trail_Balance_Report.this.i.Mc("pref_trail_balance_cr_db_total", z);
            } else {
                Trail_Balance_Report.this.i.Mc("pref_trail_balance_cr_db_total", z);
            }
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
                    Trail_Balance_Report trail_Balance_Report = Trail_Balance_Report.this;
                    Toast.makeText(trail_Balance_Report, trail_Balance_Report.getString(R.string.parent_account_alarm), 0).show();
                    return;
                }
                C4143vg c4143vgQ4 = Trail_Balance_Report.this.i.q4(c4145vh.a());
                Log.d("trace_cus_click=", c4143vgQ4.j() + ":" + c4145vh.n());
                c4143vgQ4.m(c4145vh.n());
                Bundle bundle = new Bundle();
                ArrayList arrayList = new ArrayList();
                arrayList.add(c4143vgQ4);
                ((App) Trail_Balance_Report.this.getApplication()).d(arrayList);
                Trail_Balance_Report trail_Balance_Report2 = Trail_Balance_Report.this;
                Z00 z00 = trail_Balance_Report2.i;
                String strI = c4143vgQ4.i();
                String strA = c4143vgQ4.a();
                String strH = c4143vgQ4.h();
                String strJ = c4143vgQ4.j();
                String strJ4 = Trail_Balance_Report.this.i.j4(c4143vgQ4.f());
                String strB = c4143vgQ4.b();
                int i2 = (Trail_Balance_Report.this.V.equals(CSS.Value.PERCENTAGE) && Trail_Balance_Report.this.W.equals(CSS.Value.PERCENTAGE)) ? 0 : 1;
                Trail_Balance_Report trail_Balance_Report3 = Trail_Balance_Report.this;
                z00.q9(trail_Balance_Report2, strI, strA, strH, strJ, strJ4, strB, i2, trail_Balance_Report3.V, trail_Balance_Report3.W, bundle);
            } catch (Exception unused) {
            }
        }
    }

    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                Trail_Balance_Report.this.i.Mc("pref_trail_balance_parent_account", z);
            } else {
                Trail_Balance_Report.this.i.Mc("pref_trail_balance_parent_account", z);
            }
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Trail_Balance_Report.this.showDialog(0);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Trail_Balance_Report.this.showDialog(4);
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Trail_Balance_Report.this.U = 0;
                dialogInterface.dismiss();
                Trail_Balance_Report.this.O();
            } catch (Exception unused) {
            }
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public n(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Trail_Balance_Report trail_Balance_Report = Trail_Balance_Report.this;
                trail_Balance_Report.U = 1;
                if (trail_Balance_Report.X.getText() == null) {
                    Trail_Balance_Report.this.V = "";
                } else {
                    Trail_Balance_Report trail_Balance_Report2 = Trail_Balance_Report.this;
                    trail_Balance_Report2.V = trail_Balance_Report2.X.getText().toString();
                }
                if (Trail_Balance_Report.this.Y.getText() == null) {
                    Trail_Balance_Report.this.W = "";
                } else {
                    Trail_Balance_Report trail_Balance_Report3 = Trail_Balance_Report.this;
                    trail_Balance_Report3.W = trail_Balance_Report3.Y.getText().toString();
                }
                this.a.dismiss();
                Trail_Balance_Report.this.O();
            } catch (Exception unused) {
            }
        }
    }

    public class o implements SearchView.OnQueryTextListener {
        public o() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Trail_Balance_Report.this.M(1);
            }
            Trail_Balance_Report.this.W(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Trail_Balance_Report.this.M(0);
            return false;
        }
    }

    public class p implements DatePickerDialog.OnDateSetListener {
        public p() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Trail_Balance_Report.this.R = i;
            Trail_Balance_Report.this.S = i2;
            Trail_Balance_Report.this.T = i3;
            try {
                String str = Trail_Balance_Report.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Trail_Balance_Report.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Trail_Balance_Report.this.T));
                Locale locale = Locale.ENGLISH;
                Trail_Balance_Report.this.X.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class q implements DatePickerDialog.OnDateSetListener {
        public q() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Trail_Balance_Report.this.R = i;
            Trail_Balance_Report.this.S = i2;
            Trail_Balance_Report.this.T = i3;
            try {
                String str = Trail_Balance_Report.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Trail_Balance_Report.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Trail_Balance_Report.this.T));
                Locale locale = Locale.ENGLISH;
                Trail_Balance_Report.this.Y.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public r(TextView textView, ImageView imageView) {
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
                Trail_Balance_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Trail_Balance_Report.this.l = 0;
                Trail_Balance_Report.this.O();
            } catch (Exception unused) {
                Toast.makeText(Trail_Balance_Report.this.getApplicationContext(), Trail_Balance_Report.this.getString(R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer T() {
        N();
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(Integer num) {
        a0(false);
        L();
        if (new C1839c10(this).f(this.i)) {
            new C1839c10(this).G();
        } else if (new C1839c10(this).e(this.i)) {
            new C1839c10(this).F();
        } else if (new C1839c10(this).c(this.i)) {
            new C1839c10(this).E(this.i);
        }
    }

    public void J() {
        try {
            this.U = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3_trail, (ViewGroup) null);
            builder.setView(viewInflate);
            this.X = (TextView) viewInflate.findViewById(R.id.f_date);
            this.Y = (TextView) viewInflate.findViewById(R.id.t_date);
            this.Z = (CheckBox) viewInflate.findViewById(R.id.chk_hide);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.chk_trail_cr_db);
            this.a0 = checkBox;
            checkBox.setChecked(this.i.ja("pref_trail_balance_cr_db_total", false));
            this.Z.setChecked(this.i.ja("pref_trail_balance_old_balance", false));
            this.Z.setOnCheckedChangeListener(new f());
            this.a0.setOnCheckedChangeListener(new g());
            CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.chk_parent);
            this.b0 = checkBox2;
            checkBox2.setChecked(this.i.ja("pref_trail_balance_parent_account", true));
            this.b0.setOnCheckedChangeListener(new i());
            this.X.setOnClickListener(new j());
            this.Y.setOnClickListener(new k());
            builder.setPositiveButton(getString(R.string.btn_search), new l());
            builder.setNegativeButton(getString(R.string.btn_cancel), new m());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new n(alertDialogCreate));
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
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep4_1, this.C, 5, R(), 1, this.i.ja("pref_trail_balance_old_balance", false));
        this.B = c0922Sv;
        c0922Sv.l.clear();
        this.B.notifyDataSetChanged();
        this.z.setAdapter((ListAdapter) this.B);
        this.J.setText(getString(R.string.trail_diff) + " : " + this.i.P7(String.valueOf(this.p)));
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
        Cursor cursorW8;
        int i2 = this.U;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            cursorW8 = this.i.W8(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
        } else {
            this.V = this.V.isEmpty() ? CSS.Value.PERCENTAGE : this.V;
            if (!this.W.isEmpty()) {
                str = this.W;
            }
            this.W = str;
            cursorW8 = this.i.W8(this.V, str);
        }
        Log.d("Cursor_cnt=", String.valueOf(cursorW8.getCount()));
        this.p = 0.0d;
        this.q = 0.0d;
        this.C.clear();
        cursorW8.moveToFirst();
        while (!cursorW8.isAfterLast()) {
            if (cursorW8.getString(cursorW8.getColumnIndex("f5")).equals("2")) {
                if (this.i.ja("pref_trail_balance_old_balance", false)) {
                    this.p += cursorW8.getDouble(cursorW8.getColumnIndex("f16")) - cursorW8.getDouble(cursorW8.getColumnIndex("f17"));
                } else if (this.i.ja("pref_trail_balance_cr_db_total", false)) {
                    this.p += cursorW8.getDouble(cursorW8.getColumnIndex("f13")) - cursorW8.getDouble(cursorW8.getColumnIndex("f12"));
                } else {
                    this.p += cursorW8.getDouble(cursorW8.getColumnIndex("f2"));
                }
            }
            if (!cursorW8.getString(cursorW8.getColumnIndex("f5")).equals("1") || this.i.ja("pref_trail_balance_parent_account", true)) {
                this.C.add(new C4145vh(cursorW8.getString(cursorW8.getColumnIndex("_id")), cursorW8.getString(cursorW8.getColumnIndex("f1")), cursorW8.getString(cursorW8.getColumnIndex("f7")), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f2")))), cursorW8.getInt(cursorW8.getColumnIndex("f6")) != 0 ? this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f3")))) : "0", cursorW8.getString(cursorW8.getColumnIndex("f5")), cursorW8.getString(cursorW8.getColumnIndex("f6")), cursorW8.getString(cursorW8.getColumnIndex("f7")), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f8")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f3")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f8")) + cursorW8.getDouble(cursorW8.getColumnIndex("f3")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f9")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f10")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f11")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f12")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f13")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f14")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f15")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f16")))), this.i.P7(String.valueOf(cursorW8.getDouble(cursorW8.getColumnIndex("f17"))))));
            }
            cursorW8.moveToNext();
        }
        cursorW8.close();
    }

    public void O() {
        a0(true);
        AbstractC3132jE.d(new Callable() { // from class: ZU
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.T();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).j(new InterfaceC2295gf() { // from class: aV
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.U((Integer) obj);
            }
        }, new InterfaceC2295gf() { // from class: bV
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    public double P(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).o().replaceAll(",", ""));
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
    public void S() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        textView.setText(getString(R.string.account));
        textView2.setText(getString(R.string.currency));
        if (this.i.ja("pref_trail_balance_old_balance", false)) {
            textView3.setText(getString(R.string.old_balance));
            textView4.setText(getString(R.string.period_amount));
        } else {
            textView3.setText(getString(R.string.balance2) + "_" + this.i.l3("0"));
            textView4.setText(getString(R.string.balance2) + "_" + getString(R.string.foriegn_curr));
        }
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
        c0372Bn.a(this, textView4);
        if (R()) {
            textView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams.weight = 60.0f;
            textView2.setLayoutParams(layoutParams);
        }
    }

    public void W(String str) {
        this.B.getFilter().filter(str);
    }

    public void X() {
        a0(true);
        new Thread(new c()).start();
    }

    public void Y(boolean z) {
    }

    public void Z() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new d());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new e());
        builder.show();
    }

    public void a0(boolean z) {
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
                this.M.hide();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new r(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new a());
        builder.create().show();
    }

    public void help_btn(View view) {
        Z();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.L.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.L + "'");
            }
            this.L = "";
            O();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.U = 0;
        O();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill5_);
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
        this.R = calendar.get(1);
        this.S = calendar.get(2);
        this.T = calendar.get(5);
        Y(true);
        O();
        if (!this.Q) {
            this.Q = true;
        }
        if (this.i.U2() > 0) {
            Toast.makeText(this, getString(R.string.alarm_curr_price), 0).show();
        }
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.c0, this.R, this.S, this.T);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.d0, this.R, this.S, this.T);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new o());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        Y(true);
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
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            K();
        }
        this.O = getTitle().toString();
        if (this.i.ja("pref_trail_balance_cr_db_total", false)) {
            this.O = getTitle().toString() + " # " + getString(R.string.print_by_total);
        }
        X();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (FragmentStatePagerSupport_Main.a0 || Z00.y0 || Z00.w0) {
            Z00.y0 = false;
            Z00.w0 = false;
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
