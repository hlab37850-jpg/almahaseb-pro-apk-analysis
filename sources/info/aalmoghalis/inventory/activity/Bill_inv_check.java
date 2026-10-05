package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import defpackage.C0634Jt;
import defpackage.C1030Wv;
import defpackage.C2160f10;
import defpackage.MO;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Bill_inv_check extends Menu_AppCompatActivity {
    public int B;
    public Cursor B0;
    public int C;
    public int D;
    public LinearLayout V;
    public LinearLayout W;
    public C1030Wv b0;
    public ArrayAdapter d0;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public ArrayAdapter j0;
    public String k;
    public int l = 0;
    public int n = 0;
    public int p = 2;
    public int q = 0;
    public int t = 0;
    public int u = 0;
    public String v = "0";
    public String w = null;
    public String x = null;
    public String y = null;
    public String z = null;
    public String A = "1";
    public ListView E = null;
    public Toolbar F = null;
    public TextView G = null;
    public AutoCompleteTextView H = null;
    public Button I = null;
    public Button J = null;
    public ImageView K = null;
    public ImageView L = null;
    public ImageView M = null;
    public ImageView N = null;
    public EditText O = null;
    public AutoCompleteTextView P = null;
    public AutoCompleteTextView Q = null;
    public TextView R = null;
    public ImageView S = null;
    public ArrayList T = new ArrayList();
    public ImageView U = null;
    public TextView X = null;
    public TextView Y = null;
    public TextView Z = null;
    public TextView a0 = null;
    public List c0 = new ArrayList();
    public ImageButton e0 = null;
    public int f0 = 0;
    public String[] g0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] h0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String i0 = "";
    public final Context k0 = this;
    public int l0 = 0;
    public int m0 = 0;
    public String n0 = "";
    public int o0 = 0;
    public double p0 = 0.0d;
    public String q0 = "";
    public String r0 = "";
    public String s0 = "";
    public String t0 = "";
    public String u0 = "";
    public int v0 = 1;
    public String w0 = "";
    public String x0 = "0";
    public Dialog y0 = null;
    public String z0 = "";
    public Handler A0 = new c();
    public DatePickerDialog.OnDateSetListener C0 = new f();
    public DatePickerDialog.OnDateSetListener D0 = new g();
    public TextWatcher E0 = new h();
    public boolean F0 = false;
    public int G0 = 0;
    public boolean H0 = false;
    public int I0 = 0;
    public int J0 = 0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bill_inv_check bill_inv_check = Bill_inv_check.this;
            Z00 z00 = bill_inv_check.i;
            if (z00.j0(bill_inv_check.q0, bill_inv_check.s0, bill_inv_check.t0, bill_inv_check.r0, z00.ja("prefOthers_item_end_date", false)) == 0) {
                Bill_inv_check.this.u0 = "" + Bill_inv_check.this.getString(R.string.error);
                return;
            }
            if (Bill_inv_check.this.O(" <0 ", 1) != 0) {
                Bill_inv_check.this.u0 = "" + Bill_inv_check.this.getString(R.string.done_inv);
            }
            if (Bill_inv_check.this.O(" >0 ", 2) != 0) {
                Bill_inv_check.this.u0 = "" + Bill_inv_check.this.getString(R.string.done_inv);
            }
            Bill_inv_check.this.M();
            Message message = new Message();
            message.obj = "2";
            Bill_inv_check.this.A0.sendMessage(message);
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ Dialog b;

        public b(TextView textView, Dialog dialog) {
            this.a = textView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
            Bill_inv_check.this.I.performClick();
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Bill_inv_check.this.L();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Bill_inv_check.this.i;
                StringBuilder sb = new StringBuilder();
                Bill_inv_check bill_inv_check = Bill_inv_check.this;
                sb.append(bill_inv_check.i.ic(bill_inv_check.z0));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                if (Bill_inv_check.this.u0.length() > 0) {
                    Bill_inv_check bill_inv_check2 = Bill_inv_check.this;
                    Toast.makeText(bill_inv_check2, bill_inv_check2.u0, 1).show();
                }
                Bill_inv_check.this.L();
            }
            Bill_inv_check.this.W(false);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bill_inv_check.this.M();
            Message message = new Message();
            message.obj = "0";
            Bill_inv_check.this.A0.sendMessage(message);
        }
    }

    public class e implements SearchView.OnQueryTextListener {
        public e() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Bill_inv_check.this.R(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class f implements DatePickerDialog.OnDateSetListener {
        public f() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_inv_check.this.B = i;
            Bill_inv_check.this.C = i2;
            Bill_inv_check.this.D = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_inv_check.this.B)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_inv_check.this.C + 1)) + "-" + Bill_inv_check.this.D;
                Locale locale = Locale.ENGLISH;
                Bill_inv_check.this.G.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Bill_inv_check.this.I.performClick();
            } catch (Exception unused) {
            }
        }
    }

    public class g implements DatePickerDialog.OnDateSetListener {
        public g() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_inv_check.this.B = i;
            Bill_inv_check.this.C = i2;
            Bill_inv_check.this.D = i3;
            try {
                String str = Bill_inv_check.this.B + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_inv_check.this.C + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_inv_check.this.D));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                new SimpleDateFormat("yyyy-MM-dd", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public class h implements TextWatcher {
        public h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Bill_inv_check.this.J0 = 1;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_inv_check bill_inv_check = Bill_inv_check.this;
            bill_inv_check.K(bill_inv_check.j0, Bill_inv_check.this.X);
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_inv_check bill_inv_check = Bill_inv_check.this;
            bill_inv_check.K(bill_inv_check.j0, Bill_inv_check.this.Y);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_inv_check bill_inv_check = Bill_inv_check.this;
            bill_inv_check.K(bill_inv_check.j0, Bill_inv_check.this.X);
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_inv_check bill_inv_check = Bill_inv_check.this;
            bill_inv_check.K(bill_inv_check.j0, Bill_inv_check.this.Y);
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_inv_check.this.showDialog(0);
            Bill_inv_check.this.J0 = 1;
        }
    }

    public class n implements AdapterView.OnItemClickListener {
        public n() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_inv_check.this.H.setText(adapterView.getItemAtPosition(i).toString());
            Bill_inv_check bill_inv_check = Bill_inv_check.this;
            Bill_inv_check bill_inv_check2 = Bill_inv_check.this;
            bill_inv_check.j0 = new ArrayAdapter(bill_inv_check2, android.R.layout.simple_spinner_dropdown_item, bill_inv_check2.i.p6(bill_inv_check2.H.getText().toString()));
            Bill_inv_check.this.X.setText("0");
            Bill_inv_check.this.Y.setText("0");
            if (Bill_inv_check.this.j0.getCount() > 0) {
                Bill_inv_check bill_inv_check3 = Bill_inv_check.this;
                bill_inv_check3.X.setText((CharSequence) bill_inv_check3.j0.getItem(0));
                Bill_inv_check bill_inv_check4 = Bill_inv_check.this;
                bill_inv_check4.Y.setText((CharSequence) bill_inv_check4.j0.getItem(0));
            }
            Bill_inv_check.this.I.performClick();
        }
    }

    public class o implements View.OnTouchListener {
        public o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_inv_check.this.H.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= Bill_inv_check.this.H.getTotalPaddingLeft()) {
                    Bill_inv_check.this.H.setText("");
                    Bill_inv_check.this.H.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_inv_check.this.H.getTotalPaddingLeft();
            }
            return false;
        }
    }

    public class p implements TextWatcher {
        public p() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() > 0) {
                Bill_inv_check.this.H.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(Bill_inv_check.this, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_inv_check.this.H.getCompoundDrawables()[2], (Drawable) null);
            } else {
                Bill_inv_check.this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, Bill_inv_check.this.H.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    private boolean P(int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= i2 && i4 <= i3;
    }

    private boolean Q() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && P(21, 22);
    }

    private void V() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void K(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new b(textView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void L() {
        Bill_inv_check bill_inv_check = this;
        Log.d("Cursor_cnt=", String.valueOf(bill_inv_check.B0.getCount()));
        bill_inv_check.U(false);
        bill_inv_check.c0.clear();
        bill_inv_check.B0.moveToFirst();
        while (!bill_inv_check.B0.isAfterLast()) {
            List list = bill_inv_check.c0;
            Cursor cursor = bill_inv_check.B0;
            String string = cursor.getString(cursor.getColumnIndex("_id"));
            Cursor cursor2 = bill_inv_check.B0;
            String string2 = cursor2.getString(cursor2.getColumnIndex("item_name"));
            Cursor cursor3 = bill_inv_check.B0;
            String string3 = cursor3.getString(cursor3.getColumnIndex("unit_item"));
            Z00 z00 = bill_inv_check.i;
            Cursor cursor4 = bill_inv_check.B0;
            String strP7 = z00.P7(cursor4.getString(cursor4.getColumnIndex("inv_qty")));
            Z00 z01 = bill_inv_check.i;
            Cursor cursor5 = bill_inv_check.B0;
            String strP8 = z01.P7(cursor5.getString(cursor5.getColumnIndex("br_qty")));
            Z00 z02 = bill_inv_check.i;
            Cursor cursor6 = bill_inv_check.B0;
            String strP9 = z02.P7(cursor6.getString(cursor6.getColumnIndex("diff_qty")));
            Cursor cursor7 = bill_inv_check.B0;
            String string4 = cursor7.getString(cursor7.getColumnIndex("br_name"));
            Cursor cursor8 = bill_inv_check.B0;
            String string5 = cursor8.getString(cursor8.getColumnIndex("br_id"));
            Cursor cursor9 = bill_inv_check.B0;
            String string6 = cursor9.getString(cursor9.getColumnIndex("unit_item"));
            Cursor cursor10 = bill_inv_check.B0;
            list.add(new C0634Jt(string, string2, string3, strP7, strP8, strP9, string4, string5, "", string6, "", "", "", cursor10.getString(cursor10.getColumnIndex("e_date"))));
            bill_inv_check = this;
            bill_inv_check.B0.moveToNext();
        }
        bill_inv_check.B0.close();
        C1030Wv c1030Wv = new C1030Wv(bill_inv_check, R.layout.inv_chk_item_det_row, bill_inv_check.c0);
        bill_inv_check.b0 = c1030Wv;
        c1030Wv.i.clear();
        bill_inv_check.b0.notifyDataSetChanged();
        bill_inv_check.E.setAdapter((ListAdapter) bill_inv_check.b0);
    }

    public void M() {
        try {
            Log.d("get_all_name=", "Yes" + this.l);
            this.i.Vb();
            Z00 z00 = this.i;
            this.B0 = z00.i6(this.q0, this.s0, this.t0, this.r0, z00.ja("prefOthers_item_end_date", false));
        } catch (Exception e2) {
            Log.d("Fetch_error=", e2.getMessage() + "");
            e2.printStackTrace();
        }
    }

    public void N() {
        W(true);
        new Thread(new d()).start();
    }

    public int O(String str, int i2) {
        C2160f10.h = MO.b(this);
        if (this.i.h6(str) == 0) {
            return 0;
        }
        long jL2 = this.i.l2();
        Z00 z00 = this.i;
        long jM2 = z00.m2(4, 0, z00.D2(this.q0));
        StringBuilder sb = new StringBuilder();
        sb.append("insert into bills (id,tr_type,date_,amount,br_id,adj_id,tran_status,bill_type,bill_no2,remarks,curr_id,bill_no,user_id) values(");
        sb.append(jL2);
        sb.append(",");
        sb.append(4);
        sb.append(",'");
        sb.append((Object) this.G.getText());
        sb.append("',(select abs(sum(diff_qty*item_cost)) from inv_check_v where round(diff_qty,7) ");
        sb.append(str);
        sb.append(" and br_name='");
        sb.append(this.q0);
        sb.append("' ),(select id from branches where name='");
        sb.append(this.q0);
        sb.append("' ),");
        sb.append(i2);
        sb.append(" ,");
        sb.append(2);
        sb.append(",0,'");
        sb.append(jM2);
        sb.append("','ترحيل فوارق الجرد',0,0 ,");
        int i3 = C2160f10.h;
        sb.append(i3 == -1 ? "null" : Integer.valueOf(i3));
        sb.append(")");
        String strL = this.i.L(sb.toString(), "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + ",b.item_id ,(select c.item_type_id from items c where c.id=b.item_id) ,round(abs(b.diff_qty),7) ,round(abs(b.diff_qty),7)  ,b.item_cost ,0,'',(select c.unit_id from items c where c.id=b.item_id),(select c.u_val from items c where c.id=b.item_id),(select id from units where name=b.unit_item),round(abs(b.diff_qty),7) ,(case when e_date isnull then null else e_date end) e_date  from inv_check_v b  where round(b.diff_qty,7) " + str + " and br_name='" + this.q0 + "'");
        if (strL != null && strL.equals("1")) {
            return 1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error:");
        if (strL != null && strL.length() > 20) {
            strL = strL.substring(0, 20);
        }
        sb2.append(strL);
        Toast.makeText(this, sb2.toString(), 0).show();
        return 0;
    }

    public void R(String str) {
        try {
            C1030Wv c1030Wv = this.b0;
            if (c1030Wv != null) {
                c1030Wv.getFilter().filter(str);
            }
        } catch (Exception unused) {
        }
    }

    public void S(int i2) {
        if (i2 == 0) {
            return;
        }
        this.i.Ab(this.E, this.i0, this.r0, this.H.getText().toString(), this.s0, this.t0, this.i.ja("prefOthers_print_end_date", false));
        if (i2 == 1) {
            this.i.ra(this.i0 + ".pdf");
            return;
        }
        if (i2 == 2) {
            this.i.qd(this.i0 + ".pdf");
        }
    }

    public void T() {
        this.H.setThreshold(1);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.A2());
        this.d0 = arrayAdapter;
        this.H.setAdapter(arrayAdapter);
    }

    public void U(boolean z) {
    }

    public void W(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z) {
                AlertDialog alertDialogCreate = builder.create();
                this.y0 = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.y0;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void btn_item_hide(View view) {
        this.V.setVisibility(8);
        this.W.setVisibility(0);
        this.U.setVisibility(0);
        V();
    }

    public void inv_post(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "new")) {
            Context context = this.k0;
            Toast.makeText(context, context.getString(R.string.no_priv), 0).show();
        } else {
            this.u0 = "";
            W(true);
            new Thread(new a()).start();
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.content_bill_inv_check);
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        z00.v0("delete from items_temp");
        if (this.l != 0) {
            setContentView(R.layout.content_inv_det);
        }
        this.E = (ListView) findViewById(R.id.list_items);
        TextView textView = (TextView) findViewById(R.id.tr_date);
        this.G = textView;
        textView.setEnabled(false);
        this.H = (AutoCompleteTextView) findViewById(R.id.tr_name);
        this.X = (TextView) findViewById(R.id.f_bill_no);
        this.Y = (TextView) findViewById(R.id.t_bill_no);
        TextView textView2 = this.X;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.Y;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        this.Z = (TextView) findViewById(R.id.f_bill_no_hdr);
        this.a0 = (TextView) findViewById(R.id.t_bill_no_hdr);
        TextView textView4 = this.Z;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.a0;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.I = (Button) findViewById(R.id.search_inv_btn);
        this.J = (Button) findViewById(R.id.bill_btn_post);
        this.j0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.p6(this.H.getText().toString()));
        this.X.setOnClickListener(new i());
        this.Y.setOnClickListener(new j());
        this.Z.setOnClickListener(new k());
        this.a0.setOnClickListener(new l());
        Calendar calendar = Calendar.getInstance();
        this.G.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.B = calendar.get(1);
        this.C = calendar.get(2);
        this.D = calendar.get(5);
        this.G.setOnClickListener(new m());
        T();
        this.H.setOnItemClickListener(new n());
        this.H.setOnTouchListener(new o());
        this.H.addTextChangedListener(new p());
        try {
            if (getIntent().getStringExtra("TR_ID") != null) {
                this.l = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
                this.X.setText(this.l + "");
                this.Y.setText(this.l + "");
                this.j = getIntent().getStringExtra("g_id");
                String stringExtra = getIntent().getStringExtra("g_name");
                this.k = stringExtra;
                this.H.setText(stringExtra);
                T();
                this.H.dismissDropDown();
                setTitle(getString(R.string.inv_check));
                this.i0 = getString(R.string.inv_check);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.l == 0) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        this.I.performClick();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(Q() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.C0, this.B, this.C, this.D);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(Q() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.D0, this.B, this.C, this.D);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_all, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new e());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
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
        if (menuItem.getItemId() != R.id.bill_save) {
            if (menuItem.getItemId() == R.id.bill_submit) {
                this.F0 = true;
            } else if (menuItem.getItemId() != R.id.bill_remove) {
                if (menuItem.getItemId() == R.id.print || menuItem.getItemId() == R.id.share) {
                    if (menuItem.getItemId() == R.id.print) {
                        this.G0 = 1;
                    } else {
                        this.G0 = 2;
                    }
                    S(this.G0);
                } else if (menuItem.getItemId() == 16908332) {
                    onBackPressed();
                    return true;
                }
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        FragmentStatePagerSupport_Main.Z(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void search_inv(View view) {
        this.j0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.p6(this.H.getText().toString()));
        this.q0 = this.H.getText().toString();
        this.s0 = this.X.getText().toString();
        String string = this.Y.getText().toString();
        this.t0 = string;
        String strJ6 = this.i.j6(this.s0, string, this.q0);
        this.r0 = strJ6;
        this.G.setText(strJ6);
        if (!this.X.getText().toString().equals("0") || !this.Y.getText().toString().equals("0")) {
            N();
            return;
        }
        this.c0.clear();
        C1030Wv c1030Wv = new C1030Wv(this, R.layout.inv_chk_item_det_row, this.c0);
        this.b0 = c1030Wv;
        c1030Wv.i.clear();
        this.b0.notifyDataSetChanged();
        this.E.setAdapter((ListAdapter) this.b0);
    }

    public void update_bill_total(View view) {
    }
}
