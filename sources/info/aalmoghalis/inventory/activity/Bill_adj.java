package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.timepicker.TimeModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC4371yX;
import defpackage.C0634Jt;
import defpackage.C0809Ov;
import defpackage.C1044Xj;
import defpackage.C1098Yv;
import defpackage.C1839c10;
import defpackage.C2056di;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.MO;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.activity.Bill_adj;
import info.aalmoghalis.inventory.helper.Calculator;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class Bill_adj extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int e1;
    public int F;
    public int G;
    public int H;
    public TextView K0;
    public TextView L0;
    public boolean O0;
    public boolean Q0;
    public boolean R0;
    public SearchView U0;
    public C1098Yv b0;
    public LinearLayout e0;
    public LinearLayout f0;
    public LinearLayout g0;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public C0809Ov j0;
    public String k;
    public SparseBooleanArray l0;
    public ArrayAdapter m0;
    public long l = 0;
    public String n = "";
    public int p = 0;
    public int q = 2;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public String w = "0";
    public String x = null;
    public String y = null;
    public String z = null;
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public String E = "1";
    public ListView I = null;
    public Toolbar J = null;
    public TextView K = null;
    public AutoCompleteTextView L = null;
    public RadioGroup M = null;
    public String N = null;
    public ArrayList O = new ArrayList();
    public TextView P = null;
    public TextView Q = null;
    public ImageView R = null;
    public ImageView S = null;
    public ImageView T = null;
    public ImageView U = null;
    public EditText V = null;
    public EditText W = null;
    public EditText X = null;
    public TextView Y = null;
    public AutoCompleteTextView Z = null;
    public AutoCompleteTextView a0 = null;
    public ArrayList c0 = new ArrayList();
    public ImageView d0 = null;
    public EditText h0 = null;
    public EditText i0 = null;
    public List k0 = new ArrayList();
    public ImageButton n0 = null;
    public int o0 = 0;
    public String[] p0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] q0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String r0 = "";
    public int s0 = 0;
    public int t0 = 0;
    public String u0 = "";
    public String v0 = "";
    public final Context w0 = this;
    public int x0 = 0;
    public int y0 = 0;
    public String z0 = "";
    public String A0 = "";
    public EditText B0 = null;
    public AutoCompleteTextView C0 = null;
    public int D0 = 0;
    public boolean E0 = false;
    public TextWatcher F0 = new C2479i();
    public TextView G0 = null;
    public TextView H0 = null;
    public ImageView I0 = null;
    public boolean J0 = false;
    public int M0 = 0;
    public double N0 = 0.0d;
    public int P0 = 1;
    public String S0 = "";
    public String T0 = "0";
    public DatePickerDialog.OnDateSetListener V0 = new g0();
    public DatePickerDialog.OnDateSetListener W0 = new h0();
    public DatePickerDialog.OnDateSetListener X0 = new i0();
    public TextWatcher Y0 = new j0();
    public boolean Z0 = false;
    public int a1 = 0;
    public boolean b1 = false;
    public int c1 = 0;
    public int d1 = 0;

    public class A implements View.OnClickListener {
        public A() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj.this.showDialog(0);
            Bill_adj.this.d1 = 1;
        }
    }

    public class B implements DialogInterface.OnClickListener {
        public B() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class C implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public C(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
            Bill_adj.this.J0();
        }
    }

    public class D implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public D(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Button button = (Button) view;
                if (button.getText() == null || !button.getText().toString().equals(Bill_adj.this.getString(info.aalmoghalis.inventory.R.string.add_transaction))) {
                    Log.d("edit_item_S=", FragmentStatePagerSupport_Main.X());
                    if (Bill_adj.this.g0()) {
                        Log.d("edit_item_E=", FragmentStatePagerSupport_Main.X());
                        this.a.dismiss();
                        Bill_adj.this.J0();
                    }
                } else if (Bill_adj.this.g0()) {
                    Bill_adj.this.G0();
                } else if (Bill_adj.this.Z.getText() == null || Bill_adj.this.Z.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_adj.this.J0();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_adj.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class E implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public E(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (Bill_adj.this.g0() || Bill_adj.this.Z.getText() == null || Bill_adj.this.Z.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_adj.this.J0();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_adj.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class F implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;

        public F(long j, String str) {
            this.a = j;
            this.b = str;
        }

        public static /* synthetic */ void d(Integer num) {
        }

        public final /* synthetic */ Integer c(long j, String str) {
            Bill_adj bill_adj = Bill_adj.this;
            C2160f10 c2160f10 = new C2160f10(Bill_adj.this.i);
            long j2 = Bill_adj.this.l;
            Bill_adj bill_adj2 = Bill_adj.this;
            long j3 = bill_adj2.D0;
            String str2 = bill_adj2.k;
            String str3 = bill_adj2.j;
            int i = bill_adj2.p;
            Bill_adj bill_adj3 = Bill_adj.this;
            bill_adj.c0 = c2160f10.d0(j, j2, j3, str, false, false, str2, str3, i, bill_adj3.i.J1(bill_adj3.r0()), Bill_adj.this.K.getText().toString());
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            String string;
            String strD2;
            Bill_adj bill_adj = Bill_adj.this;
            if (bill_adj.L.getText().toString() == null) {
                Bill_adj bill_adj2 = Bill_adj.this;
                string = bill_adj2.i.C2(bill_adj2.j);
            } else {
                string = Bill_adj.this.L.getText().toString();
            }
            bill_adj.k = string;
            Bill_adj bill_adj3 = Bill_adj.this;
            if (bill_adj3.L.getText().toString() == null) {
                strD2 = Bill_adj.this.j;
            } else {
                Bill_adj bill_adj4 = Bill_adj.this;
                strD2 = bill_adj4.i.D2(bill_adj4.L.getText().toString());
            }
            bill_adj3.j = strD2;
            final long j = this.a;
            final String str = this.b;
            AbstractC3132jE.d(new Callable() { // from class: A7
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.c(j, str);
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: B7
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    Bill_adj.F.d((Integer) obj);
                }
            });
        }
    }

    public class G implements DialogInterface.OnClickListener {
        public G() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class H implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public H(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_adj.this.add_item(this.a);
            } catch (Exception unused) {
            }
        }
    }

    public class I implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ AlertDialog c;

        public I(AutoCompleteTextView autoCompleteTextView, View view, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = view;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bill_adj.this.i.v0("insert into items  (name  ,o_qty  ,item_type_id,o_date_)  values( '" + ((Object) this.a.getText()) + "' ,'0','" + Bill_adj.this.y0 + "', strftime('%Y-%m-%d','now') )");
                Bill_adj.this.add_item(this.b);
            } catch (Exception unused) {
            }
            this.c.dismiss();
        }
    }

    public class J implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public J(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Bill_adj.this.i.v0("delete from items_temp  where no_=  '" + ((Object) this.a.getText()) + "'");
                    Bill_adj bill_adj = Bill_adj.this;
                    bill_adj.x0 = 1;
                    bill_adj.m0();
                    Bill_adj.this.y0();
                    Bill_adj.this.m0();
                    Bill_adj.this.e0();
                    Bill_adj.this.I0(false);
                    Bill_adj bill_adj2 = Bill_adj.this;
                    bill_adj2.c0 = bill_adj2.i.m7(String.valueOf(bill_adj2.l), "0", Bill_adj.this.L.getText().toString(), Bill_adj.this.i.ja("prefOthers_item_end_date", false));
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_adj.this.getApplicationContext(), Bill_adj.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class K implements DialogInterface.OnClickListener {
        public K() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class L implements AdapterView.OnItemClickListener {
        public L() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_adj.this.L.setText(adapterView.getItemAtPosition(i).toString());
            Bill_adj.this.h0.requestFocus();
            Bill_adj.this.F0();
            Bill_adj.this.C0();
            Bill_adj.this.d1 = 1;
        }
    }

    public class M extends Handler {
        public M() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class N implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ Handler b;

        public N(String str, Handler handler) {
            this.a = str;
            this.b = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj.this.P(this.a);
            Bill_adj.this.O0 = true;
            Handler handler = this.b;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class O implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public O(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj.this.O0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class P extends Handler {
        public P() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class Q implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public Q(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj.this.Q(this.a);
        }
    }

    public class R implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public R(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj.this.O0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class S implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public S(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    public class T implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public T(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class U implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public U(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class V implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public V(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj.this.Z(this.a, this.b);
        }
    }

    public class W implements View.OnTouchListener {
        public W() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (Bill_adj.this.L.getText().toString().length() == 0) {
                Bill_adj.this.L.showDropDown();
            }
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= Bill_adj.this.L.getTotalPaddingLeft()) {
                    Bill_adj.this.L.setText("");
                    Bill_adj.this.L.requestFocus();
                    Bill_adj.this.F0();
                    return false;
                }
                motionEvent.getX();
                Bill_adj.this.L.getTotalPaddingLeft();
            }
            return false;
        }
    }

    public class X implements DialogInterface.OnClickListener {
        public X() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Y implements DialogInterface.OnClickListener {
        public Y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Z implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ Handler e;

        public Z(AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog, String str, EditText editText, Handler handler) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
            this.c = str;
            this.d = editText;
            this.e = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (zA && Bill_adj.this.i.P5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Bill_adj.this.S0 = this.a.getText().toString();
                Bill_adj bill_adj = Bill_adj.this;
                bill_adj.l0(bill_adj.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type), Bill_adj.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type) + "#" + Bill_adj.this.S0, this.b.getContext());
                if (!Bill_adj.this.Q0) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Bill_adj.this.i.H("insert into items (name,item_type_id) values('" + this.d.getText().toString() + "',(select b.id from item_type b where b.name='" + this.a.getText().toString() + "') )", "insert into item_price (item_id,curr_id,sls_u_price) values((select id from items a where a.name='" + this.d.getText().toString() + "'),0,'0' )");
                    Bill_adj bill_adj2 = Bill_adj.this;
                    bill_adj2.P0 = 0;
                    bill_adj2.O0 = true;
                    Bill_adj.this.C0.setText(this.d.getText().toString());
                    Handler handler = this.e;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$a, reason: case insensitive filesystem */
    public class C2471a implements AdapterView.OnItemClickListener {
        public C2471a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_adj.this.w0(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    public class a0 extends Handler {
        public a0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$b, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2472b implements View.OnTouchListener {
        public ViewOnTouchListenerC2472b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_adj.this.C0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= Bill_adj.this.C0.getTotalPaddingLeft()) {
                    Bill_adj.this.C0.setText("");
                    Bill_adj.this.C0.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_adj.this.C0.getRight();
                Bill_adj.this.C0.getPaddingRight();
                if (Bill_adj.this.C0.getCompoundDrawables()[2] != null) {
                    Bill_adj.this.C0.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class b0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public b0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj.this.i.v0("insert into item_type  (name )  values( '" + Bill_adj.this.S0 + "'  )");
            Bill_adj.this.R0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$c, reason: case insensitive filesystem */
    public class C2473c implements TextWatcher {
        public C2473c() {
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
                Bill_adj bill_adj = Bill_adj.this;
                bill_adj.C0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_adj, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_adj.this.C0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_adj.this.C0;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class c0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public c0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj.this.R0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$d, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2474d implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public DialogInterfaceOnClickListenerC2474d(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
        }
    }

    public class d0 implements Filter.FilterListener {
        public d0() {
        }

        @Override // android.widget.Filter.FilterListener
        public void onFilterComplete(int i) {
            if (i == 0) {
                Bill_adj.this.U0.setQuery("", false);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$e, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2475e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2475e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class e0 implements TextWatcher {
        public e0() {
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
                Bill_adj.this.L.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(Bill_adj.this, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_adj.this.L.getCompoundDrawables()[2], (Drawable) null);
            } else {
                Bill_adj.this.L.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, Bill_adj.this.L.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$f, reason: case insensitive filesystem */
    public class C2476f implements AdapterView.OnItemClickListener {
        public C2476f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C0634Jt c0634Jt = (C0634Jt) adapterView.getItemAtPosition(i);
                TextView textView = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.no_);
                Bill_adj.this.w = textView.getText().toString();
                Bill_adj.this.x = c0634Jt.e();
                TextView textView2 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
                Bill_adj.this.y = textView2.getText().toString();
                TextView textView3 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_price);
                Bill_adj.this.z = textView3.getText().toString();
                TextView textView4 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_weight);
                Bill_adj.this.A = textView4.getText().toString();
                Bill_adj.this.B = c0634Jt.b();
                Bill_adj.this.C = c0634Jt.l();
                Bill_adj.this.E = c0634Jt.m();
                Bill_adj.this.D = c0634Jt.c();
                Bill_adj.e1 = 2;
                Bill_adj.this.O0();
            } catch (Exception unused) {
            }
        }
    }

    public class f0 implements SearchView.OnQueryTextListener {
        public f0() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Bill_adj.this.z0(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$g, reason: case insensitive filesystem */
    public class C2477g implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$g$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Bill_adj.this.f0();
                } catch (Exception unused) {
                    Toast.makeText(Bill_adj.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$g$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2477g() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() != info.aalmoghalis.inventory.R.id.menu_delete) {
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB = Bill_adj.this.j0.b();
            Bill_adj bill_adj = Bill_adj.this;
            bill_adj.l0 = sparseBooleanArrayB;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(bill_adj);
            builder.setMessage(Bill_adj.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
            builder.setPositiveButton(Bill_adj.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
            builder.setNegativeButton(Bill_adj.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
            builder.create().show();
            actionMode.finish();
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.contextual_action_bar_4, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Bill_adj.this.I.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Bill_adj.this.j0.j.clear();
            Bill_adj.this.j0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Bill_adj.this.I.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Bill_adj.this.j0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    public class g0 implements DatePickerDialog.OnDateSetListener {
        public g0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_adj.this.F = i;
            Bill_adj.this.G = i2;
            Bill_adj.this.H = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_adj.this.F)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_adj.this.G + 1)) + "-" + Bill_adj.this.H;
                Locale locale = Locale.ENGLISH;
                Bill_adj.this.K.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Bill_adj bill_adj = Bill_adj.this;
                bill_adj.N0(bill_adj.l, "0");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$h, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2478h implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2478h(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                this.a.dismiss();
            } catch (Exception unused) {
                Toast.makeText(Bill_adj.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class h0 implements DatePickerDialog.OnDateSetListener {
        public h0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_adj.this.F = i;
            Bill_adj.this.G = i2;
            Bill_adj.this.H = i3;
            try {
                String str = Bill_adj.this.F + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_adj.this.G + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_adj.this.H));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                new SimpleDateFormat("yyyy-MM-dd", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$i, reason: case insensitive filesystem */
    public class C2479i implements TextWatcher {
        public C2479i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Log.d("item_focus=", Bill_adj.this.X.hasFocus() + ":" + Bill_adj.this.V.hasFocus() + ":" + Bill_adj.this.W.hasFocus() + "#" + Bill_adj.this.E0);
            Bill_adj bill_adj = Bill_adj.this;
            if (bill_adj.E0) {
                bill_adj.E0 = false;
                return;
            }
            if (bill_adj.X.hasFocus()) {
                Bill_adj.this.M0(1);
            } else if (Bill_adj.this.V.hasFocus()) {
                Bill_adj.this.M0(2);
            } else if (Bill_adj.this.W.hasFocus()) {
                Bill_adj.this.M0(3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class i0 implements DatePickerDialog.OnDateSetListener {
        public i0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            try {
                String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", locale);
                Date date = simpleDateFormat.parse(str);
                TextView textView = Bill_adj.this.Y;
                if (textView != null) {
                    textView.setText(simpleDateFormat2.format(Long.valueOf(date.getTime())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2480j implements View.OnClickListener {
        public ViewOnClickListenerC2480j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj.this.more_item(view);
        }
    }

    public class j0 implements TextWatcher {
        public j0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Bill_adj.this.d1 = 1;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$k, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2481k implements View.OnClickListener {
        public ViewOnClickListenerC2481k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_adj.this.V.getText().toString().length() != 0) {
                Bill_adj.this.V.setText("");
            } else {
                EditText editText = Bill_adj.this.V;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class k0 implements DialogInterface.OnClickListener {
        public k0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_adj bill_adj = Bill_adj.this;
                bill_adj.T(2, bill_adj.p);
            } catch (Exception unused) {
                Toast.makeText(Bill_adj.this.getApplicationContext(), Bill_adj.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$l, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2482l implements View.OnClickListener {
        public ViewOnClickListenerC2482l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_adj.this.W.getText().toString().length() != 0) {
                Bill_adj.this.W.setText("");
            } else {
                EditText editText = Bill_adj.this.W;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class l0 implements DialogInterface.OnClickListener {
        public l0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj bill_adj = Bill_adj.this;
            if (bill_adj.c1 == 1) {
                bill_adj.finish();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$m, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2483m implements View.OnClickListener {
        public ViewOnClickListenerC2483m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj bill_adj = Bill_adj.this;
            double dDoubleValue = bill_adj.W(bill_adj.Z.getText().toString(), Bill_adj.this.k).doubleValue();
            Bill_adj bill_adj2 = Bill_adj.this;
            Z00 z00 = bill_adj2.i;
            String string = bill_adj2.Z.getText().toString();
            Bill_adj bill_adj3 = Bill_adj.this;
            String str = bill_adj3.k;
            String strL3 = bill_adj3.i.l3("0");
            Bill_adj bill_adj4 = Bill_adj.this;
            z00.te(bill_adj2, string, str, strL3, dDoubleValue, false, bill_adj4.D0, bill_adj4.p, Bill_adj.this.H0.getText().toString());
        }
    }

    public class m0 implements DialogInterface.OnClickListener {
        public m0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_adj.this.i.H("delete from bill_transactions where bill_id='" + Bill_adj.this.l + "' and exists(select * from bills a where a.id=bill_transactions.bill_id and a.date_='" + Bill_adj.this.n + "' and tr_type=" + Bill_adj.this.p + ")", "delete from bills where id ='" + Bill_adj.this.l + "' and date_='" + Bill_adj.this.n + "'");
                Bill_adj bill_adj = Bill_adj.this;
                bill_adj.Z0 = true;
                bill_adj.s0();
            } catch (Exception unused) {
                Toast.makeText(Bill_adj.this.getApplicationContext(), "SQL Error.", 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$n, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2484n implements View.OnTouchListener {
        public ViewOnTouchListenerC2484n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj.this.X.getCompoundDrawables()[0] != null ? Bill_adj.this.X.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj.this.X.getPaddingLeft() + Bill_adj.this.X.getLeft()) {
                    Bill_adj bill_adj = Bill_adj.this;
                    bill_adj.i.B(bill_adj.X, bill_adj.J0);
                }
            }
            return false;
        }
    }

    public class n0 implements DialogInterface.OnClickListener {
        public n0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$o, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2485o implements View.OnTouchListener {
        public ViewOnTouchListenerC2485o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj.this.V.getCompoundDrawables()[0] != null ? Bill_adj.this.V.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj.this.V.getPaddingLeft() + Bill_adj.this.V.getLeft()) {
                    Bill_adj bill_adj = Bill_adj.this;
                    bill_adj.i.B(bill_adj.V, bill_adj.J0);
                }
            }
            return false;
        }
    }

    public class o0 implements View.OnClickListener {
        public final /* synthetic */ RadioButton[] a;

        public o0(RadioButton[] radioButtonArr) {
            this.a = radioButtonArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < Bill_adj.this.O.size(); i++) {
                if (this.a[i].getId() != view.getId()) {
                    this.a[i].setChecked(false);
                }
            }
            Bill_adj.this.onRadioButtonClicked(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$p, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2486p implements View.OnTouchListener {
        public ViewOnTouchListenerC2486p() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj.this.W.getCompoundDrawables()[0] != null ? Bill_adj.this.W.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj.this.W.getPaddingLeft() + Bill_adj.this.W.getLeft()) {
                    Bill_adj bill_adj = Bill_adj.this;
                    bill_adj.U(bill_adj.W);
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$q, reason: case insensitive filesystem */
    public class C2487q implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2487q(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            HashMap map = (HashMap) adapterView.getItemAtPosition(i);
            String str = (String) map.get("item_date");
            if (Bill_adj.this.Y != null) {
                double d = Double.parseDouble((String) map.get("item_qty"));
                if (d >= 0.0d) {
                    Bill_adj.this.Y.setText(str);
                    Bill_adj.this.X.setHint(String.valueOf(d));
                    if (Bill_adj.this.X.getText().toString().length() > 0 && Double.parseDouble(Bill_adj.this.X.getText().toString().replaceAll(",", "")) > d) {
                        Bill_adj bill_adj = Bill_adj.this;
                        bill_adj.X.setText(bill_adj.i.S7(String.valueOf(d)));
                    }
                }
            }
            this.a.dismiss();
            Bill_adj bill_adj2 = Bill_adj.this;
            bill_adj2.i.Md(bill_adj2);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$r, reason: case insensitive filesystem */
    public class C2488r implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2488r(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (!Bill_adj.this.H0.getText().toString().equals(adapterView.getItemAtPosition(i).toString())) {
                Bill_adj.this.H0.setText(adapterView.getItemAtPosition(i).toString());
                Bill_adj bill_adj = Bill_adj.this;
                double dZ6 = bill_adj.i.Z6(bill_adj.Z.getText().toString(), Bill_adj.this.H0.getText().toString());
                Bill_adj.this.E = String.valueOf(dZ6);
                Bill_adj bill_adj2 = Bill_adj.this;
                bill_adj2.V.setTag(bill_adj2.E);
                Bill_adj bill_adj3 = Bill_adj.this;
                double dB6 = bill_adj3.i.B6(bill_adj3.Z.getText().toString(), Bill_adj.this.K.getText().toString());
                Bill_adj bill_adj4 = Bill_adj.this;
                bill_adj4.V.setHint(dB6 <= 0.0d ? "" : bill_adj4.i.S7(String.valueOf(dB6 * dZ6)));
                if (Bill_adj.this.V.getText().toString().length() > 0) {
                    EditText editText = Bill_adj.this.V;
                    editText.setText(editText.getHint());
                    Bill_adj.this.V.selectAll();
                }
                Bill_adj bill_adj5 = Bill_adj.this;
                double dO0 = bill_adj5.o0(bill_adj5.l, Bill_adj.this.w);
                if (Bill_adj.this.i.ja("prefOthers_qty_pr", false)) {
                    Bill_adj bill_adj6 = Bill_adj.this;
                    bill_adj6.X.setHint(String.valueOf(bill_adj6.i.c0("" + (dO0 / dZ6), dZ6)));
                } else {
                    Bill_adj.this.X.setHint(String.valueOf(C1839c10.C(dO0 / dZ6, C1839c10.d)));
                }
            }
            this.a.dismiss();
            Bill_adj bill_adj7 = Bill_adj.this;
            bill_adj7.i.Md(bill_adj7);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$s, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2489s implements View.OnClickListener {
        public ViewOnClickListenerC2489s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d("click=", "item_date:" + Bill_adj.e1);
            try {
                C2056di c2056di = new C2056di();
                Bundle bundle = new Bundle();
                String string = Bill_adj.this.Y.getText().toString();
                if (string.length() == 0) {
                    Bill_adj bill_adj = Bill_adj.this;
                    string = bill_adj.i.D5(bill_adj.Z.getText().toString());
                }
                ArrayList arrayListT = new C1839c10().t(string);
                if (arrayListT.size() > 2) {
                    bundle.putInt("year", ((Integer) arrayListT.get(0)).intValue());
                    bundle.putInt("month", ((Integer) arrayListT.get(1)).intValue());
                    bundle.putInt("day", ((Integer) arrayListT.get(2)).intValue());
                } else {
                    bundle.putInt("year", Bill_adj.this.F);
                    bundle.putInt("month", Bill_adj.this.G);
                    bundle.putInt("day", Bill_adj.this.H);
                }
                c2056di.setArguments(bundle);
                Bill_adj.this.Y.setText("");
                c2056di.f(Bill_adj.this.X0);
                c2056di.show(Bill_adj.this.getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$t, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2490t implements View.OnClickListener {
        public ViewOnClickListenerC2490t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int[] iArr = {android.R.id.text1};
            Bill_adj bill_adj = Bill_adj.this;
            Bill_adj.this.a0(new SimpleAdapter(bill_adj, bill_adj.X(bill_adj.Z.getText().toString(), Bill_adj.this.k), android.R.layout.simple_list_item_2, new String[]{"item_date_qty"}, iArr));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$u, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2491u implements View.OnClickListener {
        public ViewOnClickListenerC2491u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj bill_adj = Bill_adj.this;
            Bill_adj.this.b0(new ArrayAdapter(bill_adj, android.R.layout.simple_spinner_dropdown_item, bill_adj.i.a9(bill_adj.Z.getText().toString())));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$v, reason: case insensitive filesystem */
    public class C2492v implements AdapterView.OnItemClickListener {
        public C2492v() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_adj.this.x0(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$w, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2493w implements View.OnTouchListener {
        public ViewOnTouchListenerC2493w() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_adj.this.Z.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj.this.Z.getCompoundDrawables()[0] != null ? Bill_adj.this.Z.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj.this.Z.getPaddingLeft() + Bill_adj.this.Z.getLeft()) {
                    Bill_adj.this.Z.setText("");
                    Bill_adj.this.H0.setVisibility(8);
                    Bill_adj.this.H0.setText("");
                    Bill_adj.this.X.setText("");
                    Bill_adj.this.V.setText("");
                    Bill_adj.this.Y.setText("");
                    Bill_adj.this.Y.setHint("");
                    Bill_adj.this.Z.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_adj.this.Z.getRight();
                Bill_adj.this.Z.getPaddingRight();
                if (Bill_adj.this.Z.getCompoundDrawables()[2] != null) {
                    Bill_adj.this.Z.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$x, reason: case insensitive filesystem */
    public class C2494x implements TextWatcher {
        public C2494x() {
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
                Bill_adj bill_adj = Bill_adj.this;
                bill_adj.Z.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_adj, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_adj.this.C0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_adj.this.Z;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$y, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2495y implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2495y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj$z, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2496z implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2496z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    private boolean V() {
        boolean zA = AbstractC4371yX.a(this.L);
        if (!AbstractC4371yX.b(this.M)) {
            Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_adj_type), 1).show();
            zA = false;
        }
        if (this.l != 0 && !AbstractC4371yX.a(this.h0)) {
            zA = false;
        }
        if (!this.i.Q()) {
            return zA;
        }
        c0();
        return false;
    }

    private boolean t0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean u0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && t0(21, 22);
    }

    public void A0(int i) {
        if (i == 0) {
            return;
        }
        this.i.fb(this.I, this.r0, this.l + "", this.K.getText().toString(), this.L.getHint().toString(), this.L.getText().toString(), this.h0.getText().toString(), r0(), getString(info.aalmoghalis.inventory.R.string.total_cost), this.P.getText().toString(), 5, this.p, this.i.ja("prefOthers_print_end_date", false));
        if (i == 1) {
            this.i.ra(this.r0 + ".pdf");
            return;
        }
        if (i == 2) {
            this.i.qd(this.r0 + ".pdf");
        }
    }

    public void B0() {
        if (this.l == 0) {
            EditText editText = this.h0;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(info.aalmoghalis.inventory.R.string.bill_no2));
            Z00 z00 = this.i;
            sb.append(z00.m2(this.p, 0, z00.D2(r0())));
            editText.setHint(sb.toString());
        }
    }

    public void C0() {
        this.h0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.i.m2(this.p, 0, this.j));
    }

    public void D0(String str) {
        AutoCompleteTextView autoCompleteTextView;
        if (!str.equals("") && this.i.da(str)) {
            String strI6 = this.i.I6(str);
            Z00.P0 = false;
            if (strI6.equals("")) {
                this.i.j1(str, this, this.b0);
            }
            if (!strI6.equals("") || Z00.P0) {
                if (Z00.P0) {
                    strI6 = this.i.I6(str);
                }
                if (this.M0 == 2 || ((autoCompleteTextView = this.Z) != null && autoCompleteTextView.hasWindowFocus())) {
                    x0(strI6);
                } else {
                    w0(strI6);
                }
                this.M0 = 0;
            }
        }
    }

    public void E0() {
        Log.d("back_edit=", this.s0 + "");
        if (this.s0 == 1) {
            Bill_edit.P2 = true;
            Bill_edit.Q2 = true;
            Bill_edit.R2 = this.L.getText().toString();
            finish();
            return;
        }
        if (this.p == 4) {
            Intent intent = new Intent(this, (Class<?>) Moves2.class);
            intent.addFlags(67108864);
            intent.putExtra("TR_TYPE", "4");
            intent.putExtra("g_id", this.j);
            intent.putExtra("g_name", this.k);
            startActivity(intent);
            finish();
        }
    }

    public void F0() {
        this.L.setThreshold(1);
        this.m0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.y2(this.L.getText().toString()));
        h0();
        this.L.setAdapter(this.m0);
        this.L.setAdapter(this.m0);
    }

    public void G0() {
        this.Z.setText((CharSequence) null);
        this.X.setText((CharSequence) null);
        this.V.setText((CharSequence) null);
        this.W.setText((CharSequence) null);
        this.a0.setText((CharSequence) null);
        this.N = "";
        this.Z.requestFocus();
        this.w = "0";
    }

    public void H0() {
        this.I0.setOnClickListener(new ViewOnClickListenerC2480j());
        this.K0.setOnClickListener(new ViewOnClickListenerC2481k());
        this.L0.setOnClickListener(new ViewOnClickListenerC2482l());
        this.G0.setOnClickListener(new ViewOnClickListenerC2483m());
        this.X.addTextChangedListener(this.F0);
        this.V.addTextChangedListener(this.F0);
        this.W.addTextChangedListener(this.F0);
        this.X.setOnTouchListener(new ViewOnTouchListenerC2484n());
        this.V.setOnTouchListener(new ViewOnTouchListenerC2485o());
        this.W.setOnTouchListener(new ViewOnTouchListenerC2486p());
    }

    public void I0(boolean z) {
    }

    public void K0(int i) {
        TextView textView;
        if ((i != 2 && i != 4) || (textView = this.Y) == null || textView.getText().toString().length() == 0) {
            return;
        }
        this.i.v0("update items set e_date2='" + this.Y.getText().toString() + "' where name='" + this.Z.getText().toString() + "'");
    }

    public void L0(String str, String str2, String str3, Handler handler) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_item2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_group);
            editText.setText(str2);
            if (str3.equals("")) {
                str3 = this.i.S6("0");
            }
            autoCompleteTextView.setText(str3);
            editText.setEnabled(false);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.T6());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new T(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new U(autoCompleteTextView));
            imageView.setOnClickListener(new V(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new X());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new Y());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new Z(autoCompleteTextView, alertDialogCreate, str, editText, handler));
        } catch (Exception unused) {
        }
    }

    public void M0(int i) {
        try {
            if (this.E0) {
                return;
            }
            this.E0 = true;
            double dB0 = this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(this.X.getText().toString().replaceAll(",", ""), this.V.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.V.getTag().toString().replaceAll(",", "")) : 1.0d) : Double.parseDouble(this.X.getText().toString().replaceAll(",", ""));
            if (i == 1) {
                if (this.X.getText().toString().trim().length() == 0) {
                    this.W.setText("");
                } else if (this.V.getText().toString().trim().length() > 0 && this.X.getText().toString().trim().length() > 0) {
                    this.W.setText(this.i.S7("" + (Double.parseDouble(this.V.getText().toString().replaceAll(",", "")) * dB0)));
                    this.W.selectAll();
                    this.i.gc(this.X);
                } else if (this.W.getText().toString().trim().length() > 0 && this.X.getText().toString().trim().length() > 0 && this.V.getText().toString().trim().length() == 0) {
                    this.V.setText(this.i.S7("" + (Double.parseDouble(this.W.getText().toString().replaceAll(",", "")) / dB0)));
                    this.i.gc(this.X);
                }
            } else if (i == 2) {
                if (this.V.getText().toString().trim().length() == 0) {
                    this.W.setText("");
                } else if (this.V.getText().toString().trim().length() > 0 && this.X.getText().toString().trim().length() > 0) {
                    this.W.setText(this.i.S7("" + (Double.parseDouble(this.V.getText().toString().replaceAll(",", "")) * dB0)));
                    this.W.selectAll();
                    this.i.gc(this.V);
                }
            } else if (i == 3) {
                if (this.W.getText().toString().trim().length() == 0) {
                    this.V.setText("");
                } else if (this.W.getText().toString().trim().length() > 0 && this.X.getText().toString().trim().length() > 0) {
                    this.V.setText(this.i.S7("" + (Double.parseDouble(this.W.getText().toString().replaceAll(",", "")) / dB0)));
                    this.i.gc(this.W);
                }
            }
            this.E0 = false;
        } catch (Exception e) {
            this.E0 = false;
            e.printStackTrace();
        }
    }

    public void N0(long j, String str) {
        Log.d("update_qty=", j + ":" + this.p);
        new Handler().postDelayed(new F(j, str), 50L);
    }

    public void O0() {
        int i;
        try {
            if (!AbstractC4371yX.b(this.M)) {
                Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_adj_type), 1).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_add_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.Z = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            this.X = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
            this.V = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            this.W = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_remarks);
            this.a0 = autoCompleteTextView;
            this.i.cd(this, autoCompleteTextView);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price_hdr);
            this.K0 = textView;
            textView.setText(getString(info.aalmoghalis.inventory.R.string.o_cost));
            TextView textView2 = this.K0;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            this.L0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total_hdr);
            this.G0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name_hdr);
            this.I0 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_add_amount);
            TextView textView3 = this.G0;
            textView3.setPaintFlags(textView3.getPaintFlags() | 8);
            TextView textView4 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_unit);
            this.H0 = textView4;
            textView4.setPaintFlags(textView4.getPaintFlags() | 8);
            this.U = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode2);
            if (this.i.ja("prefOthers_barcode", false)) {
                this.U.setVisibility(0);
            }
            TextView textView5 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_date);
            this.Y = textView5;
            textView5.setPaintFlags(textView5.getPaintFlags() | 8);
            if (this.i.ja("prefOthers_item_end_date", false)) {
                i = Integer.parseInt(this.i.J1(r0()));
                Log.d("adj_id=", i + "");
                this.Y.setVisibility(0);
                if (i == 2 || i == 4) {
                    this.Y.setOnClickListener(new ViewOnClickListenerC2489s());
                } else if (i == 1 || i == 3) {
                    this.Y.setOnClickListener(new ViewOnClickListenerC2490t());
                }
            } else {
                this.Y.setVisibility(8);
                i = 0;
            }
            this.H0.setOnClickListener(new ViewOnClickListenerC2491u());
            H0();
            ArrayList arrayListG6 = this.i.G6();
            C2160f10.c0(this, this.Z, arrayListG6, 2);
            C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
            this.b0 = c1098Yv;
            c1098Yv.l.clear();
            this.b0.notifyDataSetChanged();
            this.Z.setThreshold(1);
            this.Z.setAdapter(this.b0);
            this.X.selectAll();
            this.V.selectAll();
            this.W.selectAll();
            this.Z.setOnItemClickListener(new C2492v());
            this.Z.setOnTouchListener(new ViewOnTouchListenerC2493w());
            this.Z.addTextChangedListener(new C2494x());
            this.Z.setText(this.x);
            this.X.setText(this.y);
            if (this.i.W6(this.Z.getText().toString()) > 1) {
                this.H0.setVisibility(0);
            } else {
                this.H0.setVisibility(8);
            }
            this.H0.setText(this.C);
            this.Y.setText(this.D);
            this.V.setTag(this.E);
            if (e1 == 1) {
                this.V.setHint(this.z);
                this.V.setText("");
                double dO0 = o0(this.l, this.w);
                if (this.i.ja("prefOthers_qty_pr", false)) {
                    dO0 = this.i.c0(dO0 + "", Double.parseDouble(this.E));
                }
                this.X.setHint(String.valueOf(dO0));
                if (this.i.ja("prefOthers_item_end_date", false)) {
                    this.Y.setVisibility(0);
                    if (i == 1 || i == 3) {
                        ArrayList arrayListX = X(this.Z.getText().toString(), this.k);
                        if (arrayListX.size() == 0) {
                            this.Y.setVisibility(8);
                        } else {
                            for (int i2 = 0; i2 < arrayListX.size(); i2++) {
                                if (Double.parseDouble((String) ((HashMap) arrayListX.get(i2)).get("item_qty")) > 0.0d) {
                                    this.Y.setText((CharSequence) ((HashMap) arrayListX.get(i2)).get("item_date"));
                                    this.X.setHint((CharSequence) ((HashMap) arrayListX.get(i2)).get("item_qty"));
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                this.V.setText(this.z);
                this.V.setHint(this.z);
                double dO1 = o0(this.l, this.w);
                if (this.i.ja("prefOthers_qty_pr", false)) {
                    dO1 = this.i.c0(dO1 + "", Double.parseDouble(this.E));
                }
                this.X.setHint(String.valueOf(dO1 / Double.valueOf(this.E).doubleValue()));
            }
            this.W.setText(this.A);
            this.W.setHint(this.A);
            this.a0.setText(this.B);
            if (e1 == 2) {
                this.V.requestFocus();
            } else if (this.x.equals("")) {
                this.Z.requestFocus();
            } else {
                this.X.requestFocus();
            }
            this.V.selectAll();
            this.W.selectAll();
            this.X.selectAll();
            if (this.Z.getText().toString().length() > 0) {
                n0();
            }
            if (e1 == 2) {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new DialogInterfaceOnClickListenerC2495y());
            } else {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.add_transaction), new DialogInterfaceOnClickListenerC2496z());
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.btn_add_close), new B());
            }
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new C(builder));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new D(alertDialogCreate));
            alertDialogCreate.getButton(-3).setOnClickListener(new E(alertDialogCreate));
        } catch (Exception e) {
            Log.d("view_item_error=", ":" + e.getMessage());
        }
    }

    public void P(String str) {
        this.i.A(str, this.p);
    }

    public void Q(Handler handler) {
        L0("", this.Z.getText().toString(), "", handler);
    }

    public void R() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void S() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new m0());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new n0());
        builder.create().show();
    }

    public void T(int i, int i2) {
        String str;
        String str2;
        String string;
        String str3;
        String string2;
        try {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            C2160f10.h = MO.b(this);
            if (V()) {
                String string3 = "";
                if (this.p == 4) {
                    if (this.i.v8(this.L.getText().toString(), 3).getCount() == 0) {
                        AutoCompleteTextView autoCompleteTextView = this.L;
                        autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                        j0(getString(info.aalmoghalis.inventory.R.string.validation_add_branch), getString(info.aalmoghalis.inventory.R.string.validation_add_branch) + "#" + ((Object) this.L.getText()), this, this.L.getText().toString());
                        if (!this.O0) {
                            return;
                        }
                    }
                    if (this.i.v8(r0(), this.p).getCount() == 0) {
                        Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_adj_type), 1).show();
                        return;
                    }
                }
                if (this.i.g2().getCount() == 0) {
                    this.S.performClick();
                    return;
                }
                Object objValueOf = "null";
                if (this.l == 0) {
                    long jL2 = this.i.l2();
                    Z00 z00 = this.i;
                    long jM2 = z00.m2(this.p, 0, z00.D2(this.L.getText().toString()));
                    this.h0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + jM2);
                    if (this.h0.getText().toString().length() <= 0) {
                        if (this.i.j2(jL2, this.p, 0, this.L.getText().toString(), jM2 + "", r0()) > 0) {
                            this.h0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                            return;
                        }
                    } else if (this.i.j2(jL2, this.p, 0, this.L.getText().toString(), this.h0.getText().toString(), r0()) > 0) {
                        this.h0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                        return;
                    }
                    if (this.p == 4) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into bills (id,tr_type,date_,amount,br_id,adj_id,tran_status,bill_type,bill_no2,remarks,curr_id,bill_no,online,user_id) values(");
                        sb.append(jL2);
                        sb.append(",");
                        sb.append(i2);
                        sb.append(",'");
                        sb.append((Object) this.K.getText());
                        sb.append("','");
                        sb.append(this.P.getText().toString().replaceAll(",", ""));
                        sb.append("',(select id from branches where name='");
                        sb.append((Object) this.L.getText());
                        sb.append("' ),(select id from adj_type where name='");
                        sb.append(r0());
                        sb.append("' ),");
                        sb.append(i);
                        sb.append(",0,'");
                        if (this.h0.getText().toString().length() == 0) {
                            string2 = jM2 + "";
                        } else {
                            string2 = this.h0.getText().toString();
                        }
                        sb.append(string2);
                        sb.append("','");
                        sb.append((Object) this.i0.getText());
                        sb.append("',0,0 ,");
                        sb.append("0");
                        sb.append(",");
                        int i3 = C2160f10.h;
                        if (i3 != -1) {
                            objValueOf = Integer.valueOf(i3);
                        }
                        sb.append(objValueOf);
                        sb.append(")");
                        string = sb.toString();
                        str3 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    } else {
                        string = "";
                        str3 = string;
                    }
                    if (this.i.H(string, str3) == 0) {
                        Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_bill_no), 1).show();
                        return;
                    }
                    this.i.v0("delete from items_temp");
                    this.l = jL2;
                    this.n = this.K.getText().toString();
                    string3 = string;
                    str = str3;
                    str2 = "";
                } else {
                    B0();
                    if (this.h0.getText().toString().length() > 0 && this.i.j2(this.l, this.p, 0, this.L.getText().toString(), this.h0.getText().toString(), r0()) > 0) {
                        this.h0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                        return;
                    }
                    if (this.p == 4) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("update bills set date_='");
                        sb2.append((Object) this.K.getText());
                        sb2.append("',amount='");
                        sb2.append(this.P.getText().toString().replaceAll(",", ""));
                        sb2.append("',br_id=(select id from branches where name='");
                        sb2.append((Object) this.L.getText());
                        sb2.append("'),adj_id=(select id from adj_type where name='");
                        sb2.append(r0());
                        sb2.append("'),cus_id=0,bill_no2='");
                        sb2.append((Object) this.h0.getText());
                        sb2.append("',remarks='");
                        sb2.append((Object) this.i0.getText());
                        sb2.append("',online='");
                        sb2.append("0");
                        sb2.append("',tran_status=");
                        sb2.append(i);
                        sb2.append(",last_user=");
                        int i4 = C2160f10.h;
                        if (i4 != -1) {
                            objValueOf = Integer.valueOf(i4);
                        }
                        sb2.append(objValueOf);
                        sb2.append(" where id='");
                        sb2.append(this.l);
                        sb2.append("' and date_='");
                        sb2.append(this.n);
                        sb2.append("'");
                        string3 = sb2.toString();
                        str = "delete from bill_transactions  where bill_id='" + this.l + "'";
                        str2 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.l + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id  ,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date from items_temp b ";
                        if (this.i.I(string3, str, str2) == 0) {
                            return;
                        }
                        if (!this.Z0) {
                            this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                    } else {
                        str = "";
                        str2 = str;
                    }
                }
                Log.d("sql1=", string3);
                Log.d("sql2=", str);
                Log.d("sql3=", str2);
                this.i.Zb();
                e0();
                this.d1 = 0;
                this.i.v0("delete from items_temp");
                s0();
            }
        } catch (Exception e) {
            Log.d("bill_save_error", e.getMessage());
        }
    }

    public void U(EditText editText) {
        Intent intent = new Intent(this, (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", editText.getText().toString());
        startActivityForResult(intent, 2);
    }

    public Double W(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.c0, str, str2);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListH.size());
        double d = 0.0d;
        for (int i = 0; i < arrayListH.size(); i++) {
            d += Double.parseDouble((String) ((HashMap) arrayListH.get(i)).get("item_qty"));
        }
        return Double.valueOf(d);
    }

    public ArrayList X(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.c0, str, str2);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListH.iterator();
        while (it.hasNext()) {
            arrayList.add((HashMap) ((HashMap) it.next()).clone());
        }
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayList.size());
        double dZ6 = this.i.Z6(str, this.H0.getText().toString());
        for (int i = 0; i < arrayList.size(); i++) {
            double d = Double.parseDouble((String) ((HashMap) arrayList.get(i)).get("item_qty")) / dZ6;
            ((HashMap) arrayList.get(i)).put("item_qty", this.i.S7(String.valueOf(d)).replaceAll(",", ""));
            ((HashMap) arrayList.get(i)).put("item_date_qty", "(" + ((String) ((HashMap) arrayList.get(i)).get("item_date")) + ")" + this.i.S7(String.valueOf(d)).replaceAll(",", ""));
        }
        return arrayList;
    }

    public Double Y(String str, String str2, String str3) {
        double d;
        ArrayList arrayListG = new C1839c10().g(this.c0, str, str2, str3);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListG.size());
        if (arrayListG.size() > 0) {
            Log.d("check_item_qty=", str + ":" + str2 + "#" + ((String) ((HashMap) arrayListG.get(0)).get("item_qty")));
            d = Double.parseDouble((String) ((HashMap) arrayListG.get(0)).get("item_qty"));
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    public void Z(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new S(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(info.aalmoghalis.inventory.R.string.pref_item_type));
        dialog.show();
    }

    public void a0(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new C2487q(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void add_item(View view) {
        this.x = "";
        this.z = "";
        this.A = "";
        this.y = "";
        this.B = "";
        if (this.C0.getText() == null || this.C0.getText().toString().equals("")) {
            this.x = "";
            this.z = "";
            this.A = "";
            this.B = "";
            this.y = "";
        } else if (this.i.F6().contains(this.C0.getText().toString())) {
            double dB6 = this.i.B6(this.C0.getText().toString(), this.K.getText().toString());
            this.x = this.C0.getText().toString();
            this.z = dB6 > 0.0d ? String.valueOf(dB6) : "";
            N0(this.l, this.w);
        } else {
            this.x = this.C0.getText().toString();
        }
        e1 = 1;
        O0();
    }

    public void add_item2(View view) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_item_edit2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new G());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new H(viewInflate));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new I(autoCompleteTextView, viewInflate, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item2_error=", e.getMessage());
        }
    }

    public void adj_list(View view) {
    }

    public void b0(ArrayAdapter arrayAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new C2488r(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void barcode_click(View view) {
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.M0 = 1;
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.M0 = 2;
        }
        if (this.i.ia("pref_barcode_type", "1").equals("1")) {
            this.i.Td(this);
            return;
        }
        Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.usb_barcode), 0).show();
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.C0.requestFocus();
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.Z.requestFocus();
        }
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_hide(View view) {
        this.f0.setVisibility(8);
        this.g0.setVisibility(0);
        this.d0.setVisibility(0);
        J0();
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.no_);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new J(textView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new K());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.f0.setVisibility(0);
        this.d0.setVisibility(8);
        this.C0.requestFocus();
        J0();
    }

    public void c0() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.F0(this);
            }
            R();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void d0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_save));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new k0());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new l0());
        builder.create().show();
    }

    public void e0() {
        this.C0 = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        ArrayList arrayListG6 = this.i.G6();
        C2160f10.c0(this, this.C0, arrayListG6, 1);
        C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
        this.b0 = c1098Yv;
        c1098Yv.l.clear();
        this.b0.notifyDataSetChanged();
        this.C0.setThreshold(1);
        this.C0.setAdapter(this.b0);
        this.C0.setOnItemClickListener(new C2471a());
        this.C0.setOnTouchListener(new ViewOnTouchListenerC2472b());
        this.C0.addTextChangedListener(new C2473c());
    }

    public void f0() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "edit")) {
                    Context context = this.w0;
                    Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "new")) {
                Context context2 = this.w0;
                Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        for (int size = this.l0.size() - 1; size >= 0; size--) {
            if (this.l0.valueAt(size)) {
                C0634Jt c0634JtA = this.j0.getItem(this.l0.keyAt(size));
                this.j0.remove(c0634JtA);
                this.i.v0("delete from items_temp where no_='" + c0634JtA.f() + "'");
                N0(this.l, "0");
            }
        }
        this.x0 = 1;
        m0();
        y0();
        m0();
        I0(false);
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0477  */
    /* JADX WARN: Code duplicated, block: B:129:0x04a4 A[Catch: Exception -> 0x0185, TRY_LEAVE, TryCatch #3 {Exception -> 0x0185, blocks: (B:52:0x0148, B:54:0x0170, B:58:0x018c, B:60:0x0198, B:65:0x01ba, B:67:0x0201, B:75:0x0252, B:77:0x026b, B:81:0x0279, B:83:0x028f, B:85:0x02a9, B:88:0x0314, B:92:0x031a, B:94:0x0338, B:96:0x0352, B:101:0x0369, B:103:0x03a7, B:112:0x03fc, B:114:0x040e, B:116:0x041c, B:118:0x0449, B:120:0x046b, B:123:0x047d, B:125:0x0482, B:127:0x0494, B:129:0x04a4, B:132:0x04ad, B:134:0x054b, B:137:0x055a, B:138:0x0576, B:148:0x068a, B:139:0x0594, B:141:0x0642, B:144:0x0651, B:145:0x066d, B:147:0x0687), top: B:162:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x04ad A[Catch: Exception -> 0x0185, TRY_ENTER, TryCatch #3 {Exception -> 0x0185, blocks: (B:52:0x0148, B:54:0x0170, B:58:0x018c, B:60:0x0198, B:65:0x01ba, B:67:0x0201, B:75:0x0252, B:77:0x026b, B:81:0x0279, B:83:0x028f, B:85:0x02a9, B:88:0x0314, B:92:0x031a, B:94:0x0338, B:96:0x0352, B:101:0x0369, B:103:0x03a7, B:112:0x03fc, B:114:0x040e, B:116:0x041c, B:118:0x0449, B:120:0x046b, B:123:0x047d, B:125:0x0482, B:127:0x0494, B:129:0x04a4, B:132:0x04ad, B:134:0x054b, B:137:0x055a, B:138:0x0576, B:148:0x068a, B:139:0x0594, B:141:0x0642, B:144:0x0651, B:145:0x066d, B:147:0x0687), top: B:162:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0594 A[Catch: Exception -> 0x0185, TryCatch #3 {Exception -> 0x0185, blocks: (B:52:0x0148, B:54:0x0170, B:58:0x018c, B:60:0x0198, B:65:0x01ba, B:67:0x0201, B:75:0x0252, B:77:0x026b, B:81:0x0279, B:83:0x028f, B:85:0x02a9, B:88:0x0314, B:92:0x031a, B:94:0x0338, B:96:0x0352, B:101:0x0369, B:103:0x03a7, B:112:0x03fc, B:114:0x040e, B:116:0x041c, B:118:0x0449, B:120:0x046b, B:123:0x047d, B:125:0x0482, B:127:0x0494, B:129:0x04a4, B:132:0x04ad, B:134:0x054b, B:137:0x055a, B:138:0x0576, B:148:0x068a, B:139:0x0594, B:141:0x0642, B:144:0x0651, B:145:0x066d, B:147:0x0687), top: B:162:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0687 A[Catch: Exception -> 0x0185, TryCatch #3 {Exception -> 0x0185, blocks: (B:52:0x0148, B:54:0x0170, B:58:0x018c, B:60:0x0198, B:65:0x01ba, B:67:0x0201, B:75:0x0252, B:77:0x026b, B:81:0x0279, B:83:0x028f, B:85:0x02a9, B:88:0x0314, B:92:0x031a, B:94:0x0338, B:96:0x0352, B:101:0x0369, B:103:0x03a7, B:112:0x03fc, B:114:0x040e, B:116:0x041c, B:118:0x0449, B:120:0x046b, B:123:0x047d, B:125:0x0482, B:127:0x0494, B:129:0x04a4, B:132:0x04ad, B:134:0x054b, B:137:0x055a, B:138:0x0576, B:148:0x068a, B:139:0x0594, B:141:0x0642, B:144:0x0651, B:145:0x066d, B:147:0x0687), top: B:162:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0269  */
    /* JADX WARN: Code duplicated, block: B:79:0x0277 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:81:0x0279 A[Catch: Exception -> 0x0185, TryCatch #3 {Exception -> 0x0185, blocks: (B:52:0x0148, B:54:0x0170, B:58:0x018c, B:60:0x0198, B:65:0x01ba, B:67:0x0201, B:75:0x0252, B:77:0x026b, B:81:0x0279, B:83:0x028f, B:85:0x02a9, B:88:0x0314, B:92:0x031a, B:94:0x0338, B:96:0x0352, B:101:0x0369, B:103:0x03a7, B:112:0x03fc, B:114:0x040e, B:116:0x041c, B:118:0x0449, B:120:0x046b, B:123:0x047d, B:125:0x0482, B:127:0x0494, B:129:0x04a4, B:132:0x04ad, B:134:0x054b, B:137:0x055a, B:138:0x0576, B:148:0x068a, B:139:0x0594, B:141:0x0642, B:144:0x0651, B:145:0x066d, B:147:0x0687), top: B:162:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x030f  */
    public boolean g0() {
        String str;
        double d;
        double dIc;
        boolean z;
        String str2;
        TextView textView;
        TextView textView2;
        String str3;
        boolean z2 = false;
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "edit")) {
                    Context context = this.w0;
                    Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return false;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "new")) {
                Context context2 = this.w0;
                Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        }
        try {
            boolean zA = AbstractC4371yX.a(this.X);
            try {
                if (!AbstractC4371yX.a(this.Z)) {
                    zA = false;
                }
                if (AbstractC4371yX.b(this.M)) {
                    int i = Integer.parseInt(this.i.J1(r0()));
                    if (this.V.getText().toString().trim().length() == 0 && this.W.getText().toString().trim().length() == 0) {
                        AbstractC4371yX.a(this.V);
                        AbstractC4371yX.a(this.W);
                        zA = false;
                    }
                    try {
                        double d2 = this.V.getText().toString().trim().length() > 0 ? Double.parseDouble(this.V.getText().toString().replaceAll(",", "")) : 0.0d;
                        double d3 = this.W.getText().toString().trim().length() > 0 ? Double.parseDouble(this.W.getText().toString().replaceAll(",", "")) : 0.0d;
                        try {
                            double dB0 = Double.parseDouble(this.X.getText().toString().replaceAll(",", ""));
                            double d4 = 1.0d;
                            double d5 = this.V.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.V.getTag().toString().replaceAll(",", "")) : 1.0d;
                            if (this.i.ja("prefOthers_qty_pr", false)) {
                                dB0 = this.i.b0(this.X.getText().toString().replaceAll(",", ""), d5);
                            }
                            double d6 = d5;
                            double d7 = dB0;
                            if (d2 > 0.0d && d3 > 0.0d) {
                                String strS7 = this.i.S7(this.V.getText().toString().replaceAll(",", ""));
                                Z00 z00 = this.i;
                                StringBuilder sb = new StringBuilder();
                                sb.append("");
                                str = "item_qty=";
                                double d8 = d3;
                                sb.append(Double.parseDouble(this.W.getText().toString().replaceAll(",", "")) / d7);
                                if (strS7.equals(z00.S7(sb.toString()))) {
                                    d3 = d8;
                                } else {
                                    EditText editText = this.W;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(getString(info.aalmoghalis.inventory.R.string.total_not_correct));
                                    sb2.append("#");
                                    sb2.append(this.i.S7("" + (d2 * d7)));
                                    sb2.append("#");
                                    d3 = d8;
                                    sb2.append(d3);
                                    editText.setError(sb2.toString());
                                    d = 0.0d;
                                    zA = false;
                                }
                                if (d3 >= d || d7 <= d) {
                                    dIc = 0.0d;
                                } else {
                                    double d9 = d3 / d7;
                                    this.i.Ic(String.valueOf(d9));
                                    dIc = this.i.Ic(String.valueOf(d9 / d6));
                                }
                                if (this.Z.getText().length() == 0) {
                                    return false;
                                }
                                if (!this.i.F6().contains(this.Z.getText().toString()) || this.i.F6().contains(this.Z.getText().toString().trim())) {
                                    d4 = d6;
                                    z = true;
                                } else {
                                    AutoCompleteTextView autoCompleteTextView = this.Z;
                                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                                    this.z0 = this.Z.getText().toString();
                                    k0(getString(info.aalmoghalis.inventory.R.string.validation_add_item), getString(info.aalmoghalis.inventory.R.string.validation_add_item) + this.z0, this);
                                    this.V.setTag("1");
                                    this.H0.setVisibility(8);
                                    this.H0.setText(this.i.X6(this.Z.getText().toString()));
                                    this.Y.setText("");
                                    z = false;
                                }
                                if (z && !this.O0) {
                                    return false;
                                }
                                if (!this.Z.getText().toString().equals(this.Z.getText().toString().trim()) && this.i.F6().contains(this.Z.getText().toString().trim())) {
                                    AutoCompleteTextView autoCompleteTextView2 = this.Z;
                                    autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                                }
                                if (i != 2 || i == 4) {
                                    dIc = dIc;
                                    d7 = d7;
                                } else {
                                    double dO0 = o0(this.l, this.w);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(this.l);
                                    sb3.append(":");
                                    sb3.append(this.w);
                                    sb3.append(":");
                                    sb3.append(dO0);
                                    sb3.append(":");
                                    double d10 = d7 * d4;
                                    sb3.append(d10);
                                    String str4 = str;
                                    Log.d(str4, sb3.toString());
                                    if (this.i.ja("prefOthers_item_end_date", false)) {
                                        double dP0 = p0(this.l, this.w, this.Y.getText().toString());
                                        Log.d(str4, this.l + ":" + this.w + ":" + dO0 + ":" + dP0 + ":" + d10);
                                        if (dP0 < 0.0d || dP0 > dO0) {
                                            dP0 = dP0 < 0.0d ? 0.0d : dO0;
                                        }
                                        this.A0 = this.Y.getText().toString();
                                        dO0 = dP0;
                                    }
                                    if (dO0 - C1839c10.C(d10, C1839c10.d) < 0.0d) {
                                        EditText editText2 = this.X;
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(getString(info.aalmoghalis.inventory.R.string.bal_net));
                                        sb4.append(" ");
                                        sb4.append(this.i.S7(String.valueOf(dO0 / d4)).replaceAll(",", ""));
                                        if (this.Y != null) {
                                            str3 = "(" + this.Y.getText().toString() + ")";
                                        } else {
                                            str3 = "";
                                        }
                                        sb4.append(str3);
                                        editText2.setError(sb4.toString());
                                        return false;
                                    }
                                }
                                if (e1 != 2 && this.i.q7(this.Z.getText().toString()) > 0) {
                                    this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (zA) {
                                    return zA;
                                }
                                str2 = "''";
                                if (e1 == 2) {
                                    Z00 z01 = this.i;
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("update items_temp set item_id=(select id from items a where a.name='");
                                    sb5.append((Object) this.Z.getText());
                                    sb5.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                    sb5.append((Object) this.Z.getText());
                                    sb5.append("'),qty='");
                                    sb5.append(this.X.getText().toString().replaceAll(",", ""));
                                    sb5.append("',qty_t='");
                                    sb5.append(this.X.getText().toString().replaceAll(",", ""));
                                    sb5.append("',qty_pr=");
                                    sb5.append(d7);
                                    sb5.append(",remark='");
                                    sb5.append(this.a0.getText().toString());
                                    sb5.append("',price='");
                                    sb5.append(String.valueOf(dIc));
                                    sb5.append("',curr_id=0,unit_id=ifnull((select id from units where code='");
                                    sb5.append(this.H0.getText().toString());
                                    sb5.append("'),0),u_val='");
                                    sb5.append(String.valueOf(d4));
                                    sb5.append("',e_date=");
                                    textView2 = this.Y;
                                    if (textView2 != null && textView2.getText().toString().length() != 0) {
                                        str2 = "'" + this.Y.getText().toString() + "'";
                                    }
                                    sb5.append(str2);
                                    sb5.append(" where no_='");
                                    sb5.append(this.w);
                                    sb5.append("'");
                                    z01.v0(sb5.toString());
                                    K0(i);
                                } else {
                                    Z00 z02 = this.i;
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,e_date)  values( (select id from items a where a.name='");
                                    sb6.append((Object) this.Z.getText());
                                    sb6.append("'),(select item_type_id from items a where a.name='");
                                    sb6.append((Object) this.Z.getText());
                                    sb6.append("'),'");
                                    sb6.append(this.X.getText().toString().replaceAll(",", ""));
                                    sb6.append("','");
                                    sb6.append(this.X.getText().toString().replaceAll(",", ""));
                                    sb6.append("','");
                                    sb6.append(String.valueOf(dIc));
                                    sb6.append("',0,'");
                                    sb6.append(this.a0.getText().toString());
                                    sb6.append("',ifnull((select id from units where code='");
                                    sb6.append(this.H0.getText().toString());
                                    sb6.append("'),0),'");
                                    sb6.append(String.valueOf(d4));
                                    sb6.append("',(select unit_id from items where name='");
                                    sb6.append(this.Z.getText().toString());
                                    sb6.append("'),");
                                    sb6.append(d7);
                                    sb6.append(",");
                                    textView = this.Y;
                                    if (textView != null && textView.getText().toString().length() != 0) {
                                        str2 = "'" + this.Y.getText().toString() + "'";
                                    }
                                    sb6.append(str2);
                                    sb6.append(" )");
                                    z02.v0(sb6.toString());
                                    K0(i);
                                    if (this.l == 0) {
                                        y0();
                                    }
                                }
                                this.C0.setText("");
                                e0();
                                this.x0 = 1;
                                m0();
                                y0();
                                this.x0 = 1;
                                m0();
                                N0(this.l, "0");
                                return zA;
                            }
                            str = "item_qty=";
                            d = 0.0d;
                            if (d3 >= d) {
                                dIc = 0.0d;
                            } else {
                                dIc = 0.0d;
                            }
                            if (this.Z.getText().length() == 0) {
                                return false;
                            }
                            if (this.i.F6().contains(this.Z.getText().toString())) {
                                d4 = d6;
                                z = true;
                            } else {
                                d4 = d6;
                                z = true;
                            }
                            if (z) {
                            }
                            if (!this.Z.getText().toString().equals(this.Z.getText().toString().trim())) {
                                AutoCompleteTextView autoCompleteTextView3 = this.Z;
                                autoCompleteTextView3.setText(autoCompleteTextView3.getText().toString().trim());
                            }
                            if (i != 2) {
                                dIc = dIc;
                                d7 = d7;
                            } else {
                                dIc = dIc;
                                d7 = d7;
                            }
                            if (e1 != 2) {
                                this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                            }
                            if (zA) {
                                return zA;
                            }
                            str2 = "''";
                            if (e1 == 2) {
                                Z00 z03 = this.i;
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("update items_temp set item_id=(select id from items a where a.name='");
                                sb7.append((Object) this.Z.getText());
                                sb7.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                sb7.append((Object) this.Z.getText());
                                sb7.append("'),qty='");
                                sb7.append(this.X.getText().toString().replaceAll(",", ""));
                                sb7.append("',qty_t='");
                                sb7.append(this.X.getText().toString().replaceAll(",", ""));
                                sb7.append("',qty_pr=");
                                sb7.append(d7);
                                sb7.append(",remark='");
                                sb7.append(this.a0.getText().toString());
                                sb7.append("',price='");
                                sb7.append(String.valueOf(dIc));
                                sb7.append("',curr_id=0,unit_id=ifnull((select id from units where code='");
                                sb7.append(this.H0.getText().toString());
                                sb7.append("'),0),u_val='");
                                sb7.append(String.valueOf(d4));
                                sb7.append("',e_date=");
                                textView2 = this.Y;
                                if (textView2 != null) {
                                    str2 = "'" + this.Y.getText().toString() + "'";
                                }
                                sb7.append(str2);
                                sb7.append(" where no_='");
                                sb7.append(this.w);
                                sb7.append("'");
                                z03.v0(sb7.toString());
                                K0(i);
                            } else {
                                Z00 z04 = this.i;
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,e_date)  values( (select id from items a where a.name='");
                                sb8.append((Object) this.Z.getText());
                                sb8.append("'),(select item_type_id from items a where a.name='");
                                sb8.append((Object) this.Z.getText());
                                sb8.append("'),'");
                                sb8.append(this.X.getText().toString().replaceAll(",", ""));
                                sb8.append("','");
                                sb8.append(this.X.getText().toString().replaceAll(",", ""));
                                sb8.append("','");
                                sb8.append(String.valueOf(dIc));
                                sb8.append("',0,'");
                                sb8.append(this.a0.getText().toString());
                                sb8.append("',ifnull((select id from units where code='");
                                sb8.append(this.H0.getText().toString());
                                sb8.append("'),0),'");
                                sb8.append(String.valueOf(d4));
                                sb8.append("',(select unit_id from items where name='");
                                sb8.append(this.Z.getText().toString());
                                sb8.append("'),");
                                sb8.append(d7);
                                sb8.append(",");
                                textView = this.Y;
                                if (textView != null) {
                                    str2 = "'" + this.Y.getText().toString() + "'";
                                }
                                sb8.append(str2);
                                sb8.append(" )");
                                z04.v0(sb8.toString());
                                K0(i);
                                if (this.l == 0) {
                                    y0();
                                }
                            }
                            this.C0.setText("");
                            e0();
                            this.x0 = 1;
                            m0();
                            y0();
                            this.x0 = 1;
                            m0();
                            N0(this.l, "0");
                            return zA;
                        } catch (Exception e) {
                            e = e;
                            z2 = zA;
                            Log.d("edit_item_error=", e.getMessage() + "");
                            e.printStackTrace();
                            return z2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        zA = zA;
                    }
                } else {
                    try {
                        Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_adj_type), 1).show();
                        return false;
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                z2 = zA;
            }
        } catch (Exception e5) {
            e = e5;
            z2 = true;
        }
        Log.d("edit_item_error=", e.getMessage() + "");
        e.printStackTrace();
        return z2;
    }

    public void h0() {
        ArrayList arrayListH1 = this.i.H1();
        this.O = arrayListH1;
        String str = this.N;
        if (str == null) {
            str = "";
        }
        this.N = str;
        RadioButton[] radioButtonArr = new RadioButton[arrayListH1.size()];
        ViewGroup[] viewGroupArr = new LinearLayout[this.O.size()];
        this.M.setTag(null);
        this.M.removeAllViews();
        this.M.clearCheck();
        for (int i = 0; i < this.O.size(); i++) {
            radioButtonArr[i] = new RadioButton(this);
            viewGroupArr[i] = new LinearLayout(this);
            radioButtonArr[i].setText((CharSequence) ((HashMap) this.O.get(i)).get("name"));
            radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.O.get(i)).get(HTML.Attribute.ID)) + 100);
            viewGroupArr[i].setId(Integer.parseInt((String) ((HashMap) this.O.get(i)).get(HTML.Attribute.ID)) + 1000);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            viewGroupArr[i].setLayoutParams(layoutParams);
            radioButtonArr[i].setOnClickListener(new o0(radioButtonArr));
            viewGroupArr[i].addView(radioButtonArr[i]);
            this.M.addView(viewGroupArr[i]);
            String str2 = this.N;
            if (str2 != null && str2.equals(((HashMap) this.O.get(i)).get("name"))) {
                this.M.check(radioButtonArr[i].getId());
                this.M.setTag(((HashMap) this.O.get(i)).get("name"));
            }
        }
    }

    public void i0(Cursor cursor) {
        Log.d("Cursor_cnt=", String.valueOf(cursor.getCount()));
        I0(false);
        this.k0.clear();
        cursor.moveToFirst();
        double d = 0.0d;
        while (!cursor.isAfterLast()) {
            this.k0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("item_name")), cursor.getString(cursor.getColumnIndex("item_type")), this.i.S7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("item_total")))), this.i.T7("" + cursor.getDouble(cursor.getColumnIndex("qty_t"))), this.i.S7(cursor.getString(cursor.getColumnIndex("item_price"))), cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tran_status")), cursor.getString(cursor.getColumnIndex("item_remarks")), cursor.getString(cursor.getColumnIndex("unit_name")), cursor.getString(cursor.getColumnIndex("unit_val")), cursor.getString(cursor.getColumnIndex("qty_pr")), cursor.getString(cursor.getColumnIndex("barcode")), cursor.getString(cursor.getColumnIndex("e_date"))));
            d += cursor.getDouble(cursor.getColumnIndex("item_price")) * cursor.getDouble(cursor.getColumnIndex("qty_pr"));
            if (this.l != 0) {
                this.p = cursor.getInt(cursor.getColumnIndex("tr_type_id"));
                this.L.setText(cursor.getString(cursor.getColumnIndex("tr_name")));
                this.L.dismissDropDown();
                this.N = cursor.getString(cursor.getColumnIndex("to_tr_name"));
                this.K.setText(cursor.getString(cursor.getColumnIndex("date_")));
                this.i.nd(this.h0, cursor.getString(cursor.getColumnIndex("bill_no2")));
                this.i.nd(this.i0, cursor.getString(cursor.getColumnIndex("remarks")));
                this.N0 = Double.parseDouble("" + cursor.getDouble(cursor.getColumnIndex("amount")));
                if (cursor.getString(cursor.getColumnIndex("tran_status")).equals("3")) {
                    this.d0.setVisibility(8);
                }
            }
            cursor.moveToNext();
        }
        cursor.close();
        if (this.N0 == 0.0d || this.x0 == 1) {
            this.P.setText(NumberFormat.getInstance(Locale.ENGLISH).format(d));
            this.x0 = 0;
        } else {
            this.P.setText(NumberFormat.getInstance(Locale.ENGLISH).format(this.N0));
        }
        NumberFormat.getInstance(Locale.ENGLISH).format(0.0d);
        C0809Ov c0809Ov = new C0809Ov(this, info.aalmoghalis.inventory.R.layout.bill_item_det_row3, this.k0);
        this.j0 = c0809Ov;
        c0809Ov.j.clear();
        this.j0.notifyDataSetChanged();
        this.I.setAdapter((ListAdapter) this.j0);
        invalidateOptionsMenu();
        SearchView searchView = this.U0;
        String string = (searchView == null || searchView.getQuery() == null) ? "" : this.U0.getQuery().toString();
        if (string.length() > 0) {
            this.j0.getFilter().filter(string, new d0());
        }
    }

    public boolean j0(String str, String str2, Context context, String str3) {
        M m = new M();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new N(str3, m));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new O(m));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.O0;
    }

    public boolean k0(String str, String str2, Context context) {
        P p = new P();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new Q(p));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new R(p));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.O0;
    }

    public boolean l0(String str, String str2, Context context) {
        a0 a0Var = new a0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new b0(a0Var));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new c0(a0Var));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.R0;
    }

    public void m0() {
        try {
            Log.d("get_all_name=", "Yes" + this.l + ":" + this.n);
            long j = this.l;
            if (j != 0) {
                i0(this.i.F1(String.valueOf(j), this.n));
            } else {
                i0(this.i.f2());
            }
        } catch (Exception e) {
            Log.d("Fetch_error=", e.getMessage());
        }
    }

    public void more_item(View view) {
        this.i.te(this, this.Z.getText().toString(), this.k, this.i.l3("0"), W(this.Z.getText().toString(), this.k).doubleValue(), false, this.D0, this.p, this.H0.getText().toString());
    }

    public void n0() {
        Log.d("item_remarks=", "..start...");
        C1044Xj.a().c(new RunnableC1171Zj(16, this.i, this.Z, this.a0, this, new RunnableC1086Yj()));
    }

    public double o0(long j, String str) {
        this.c0 = this.i.m7(String.valueOf(this.l), this.w, this.L.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
        return W(this.Z.getText().toString(), this.L.getText().toString()).doubleValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            try {
                if (!this.i.x.l(i, i2, intent)) {
                    super.onActivityResult(i, i2, intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i2 != 0 && i == 2 && intent != null) {
                try {
                    EditText editText = this.W;
                    if (editText != null) {
                        editText.setText(this.i.S7(intent.getStringExtra("calc_result")));
                        this.a0.requestFocus();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            try {
                IntentResult activityResult = IntentIntegrator.parseActivityResult(i, i2, intent);
                if (activityResult != null) {
                    if (activityResult.getContents() == null) {
                        Toast.makeText(this, "Cancelled", 0).show();
                        return;
                    }
                    String strI6 = this.i.I6(activityResult.getContents());
                    Z00.P0 = false;
                    if (strI6.equals("")) {
                        this.i.j1(activityResult.getContents(), this, this.b0);
                    }
                    if (!strI6.equals("") || Z00.P0) {
                        if (Z00.P0) {
                            strI6 = this.i.I6(activityResult.getContents());
                        }
                        int i3 = this.M0;
                        if (i3 == 1) {
                            w0(strI6);
                        } else if (i3 == 2) {
                            x0(strI6);
                        }
                        this.M0 = 0;
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                Log.d("barcode_log_error=", "results=" + e3.getMessage());
            }
        } catch (Exception unused) {
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "edit")) {
                    this.d1 = 0;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "new")) {
                this.d1 = 0;
            }
        }
        int i = this.d1;
        if (i == 1) {
            this.c1 = 1;
            d0();
        } else if (i == 2) {
            E0();
        } else if (this.l != 0) {
            E0();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_bill_adj);
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        z00.z0("delete from items_temp");
        q0();
        N0(this.l, "0");
        if (this.l != 0) {
            setContentView(info.aalmoghalis.inventory.R.layout.content_adj_det);
        }
        this.I = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        this.K = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_date);
        this.L = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name);
        this.M = (RadioGroup) findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        this.P = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot);
        this.Q = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr);
        this.S = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_add);
        this.T = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode);
        if (this.i.ja("prefOthers_barcode", false)) {
            this.T.setVisibility(0);
        }
        this.h0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_no);
        this.i0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
        this.e0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.root_layout);
        this.f0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.item_add_hdr);
        this.g0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_items_list_hdr);
        this.d0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.page_add);
        if (this.l != 0) {
            this.g0.setVisibility(0);
        }
        this.I.setOnItemClickListener(new C2476f());
        this.I.setChoiceMode(3);
        this.I.setMultiChoiceModeListener(new C2477g());
        Calendar calendar = Calendar.getInstance();
        this.K.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.F = calendar.get(1);
        this.G = calendar.get(2);
        this.H = calendar.get(5);
        this.K.setOnClickListener(new A());
        F0();
        this.L.setOnItemClickListener(new L());
        this.L.setOnTouchListener(new W());
        this.L.addTextChangedListener(new e0());
        I0(true);
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.p = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                String stringExtra = getIntent().getStringExtra("g_name");
                this.k = stringExtra;
                if (this.l == 0) {
                    this.L.setText(stringExtra);
                    F0();
                    this.L.dismissDropDown();
                }
                setTitle(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.p - 1]);
                this.r0 = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.p - 1];
                this.i.z0("delete from items_temp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.l != 0) {
            this.L.requestFocus();
        }
        if (getIntent().getStringExtra("TR_ID") != null && C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "edit")) {
                this.L.setEnabled(false);
                this.K.setEnabled(false);
                this.M.setEnabled(false);
                this.i0.setEnabled(false);
                this.h0.setEnabled(false);
            }
        }
        if (C2160f10.h > 0) {
            this.L.setEnabled(false);
        }
        if (this.l == 0) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        q0();
        m0();
        e0();
        v0();
        h0();
        this.c0 = this.i.m7(String.valueOf(this.l), "0", this.L.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
        this.i.Zb();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(u0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.V0, this.F, this.G, this.H);
        }
        if (i == 4) {
            return new DatePickerDialog(u0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.W0, this.F, this.G, this.H);
        }
        if (i != 5) {
            return null;
        }
        return new DatePickerDialog(u0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.X0, this.F, this.G, this.H);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_bill3, menu);
        menu.findItem(info.aalmoghalis.inventory.R.id.bill_prin).setVisible(this.l != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.share).setVisible(this.l != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.search).setVisible(this.l != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(this.l != 0);
        int i = C2160f10.h;
        if (i > 0 && this.l != 0) {
            MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
            MenuItem menuItemFindItem2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
            boolean zL = new C2160f10(this.i).l("7", "edit");
            boolean zL2 = new C2160f10(this.i).l("7", HTML.Tag.DEL);
            menuItemFindItem.setVisible(zL);
            menuItemFindItem2.setVisible(zL2);
        } else if (i > 0 && this.l == 0) {
            menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(new C2160f10(this.i).l("7", HTML.Tag.DEL));
        }
        this.U0 = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        this.U0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.U0.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.U0.setOnQueryTextListener(new f0());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        i0(this.i.L2());
        I0(true);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        adapterView.getItemAtPosition(i).toString();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_save) {
            T(1, this.p);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_submit) {
            this.Z0 = true;
            T(2, this.p);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_remove) {
            S();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.share) {
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin) {
                this.a1 = 1;
            } else {
                this.a1 = 2;
            }
            if (this.l == 0) {
                d0();
                return true;
            }
            A0(this.a1);
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        FragmentStatePagerSupport_Main.Z(this);
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.M.setTag(radioButton.getText().toString());
            this.N = this.M.getTag() == null ? this.N : this.M.getTag().toString();
            this.d1 = 1;
            C0();
        }
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

    public double p0(long j, String str, String str2) {
        if (j != 0) {
            N0(j, str);
        }
        return Y(this.Z.getText().toString(), this.k, str2).doubleValue();
    }

    public void q0() {
        try {
            if (getIntent().getStringExtra("TR_ID") == null) {
                this.h0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.i.m2(this.p, 0, this.j));
                return;
            }
            this.l = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
            if (getIntent().getStringExtra("TR_DATE") != null) {
                this.n = getIntent().getStringExtra("TR_DATE");
                this.i.z0("delete from items_temp");
                this.i.z0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr  ,ifnull(e_date,'')  from bill_transactions_v a  where bill_id=" + this.l + " and a.bill_date='" + this.n + "' ");
            } else {
                this.i.z0("delete from items_temp");
                this.i.z0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr )  select item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr  from bill_transactions a  where bill_id=" + this.l + "");
            }
            this.u = Integer.parseInt(getIntent().getStringExtra("tran_status"));
            this.s0 = getIntent().getIntExtra("back_edit", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String r0() {
        return this.M.getTag() == null ? "" : this.M.getTag().toString();
    }

    public void s0() {
        Log.d("back_edit=", this.s0 + "");
        if (this.s0 == 1 && this.Z0) {
            Bill_edit.P2 = true;
            Bill_edit.Q2 = true;
            Z00.o0 = false;
            finish();
            return;
        }
        if (this.b1) {
            this.b1 = false;
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr  ,ifnull(e_date,'')  from bill_transactions a  where bill_id=" + this.l + "");
            return;
        }
        if (this.p == 4) {
            Intent intent = new Intent(this, (Class<?>) Moves2.class);
            intent.addFlags(67108864);
            intent.putExtra("TR_TYPE", "4");
            intent.putExtra("g_id", this.j);
            intent.putExtra("g_name", this.k);
            startActivity(intent);
            finish();
        }
    }

    public void update_bill_total(View view) {
    }

    public void v0() {
        try {
            if (getIntent().getStringExtra("item_name") != null) {
                String stringExtra = getIntent().getStringExtra("item_name");
                String stringExtra2 = getIntent().getStringExtra("item_qty");
                Bill_edit.R2 = stringExtra;
                int i = 0;
                while (true) {
                    if (i >= this.I.getAdapter().getCount()) {
                        i = -1;
                        break;
                    }
                    C0634Jt c0634Jt = (C0634Jt) this.I.getAdapter().getItem(i);
                    double dB0 = (this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(c0634Jt.h().replaceAll(",", ""), Double.parseDouble(c0634Jt.m())) : Double.parseDouble(c0634Jt.h().replaceAll(",", ""))) * Double.parseDouble(c0634Jt.m());
                    if (c0634Jt.e().equals(stringExtra) && Math.round(dB0) == Math.round(Double.parseDouble(stringExtra2.replaceAll(",", "")))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    ListView listView = this.I;
                    listView.performItemClick(listView.getAdapter().getView(i, null, null), i, this.I.getAdapter().getItemId(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void view_item_info2(View view) {
        try {
            String string = this.Z.getText().toString();
            if (string != null && this.i.F6().contains(string)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_view_info2_, (ViewGroup) null);
                builder.setView(viewInflate);
                TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
                TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
                TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
                TextView textView4 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_cost);
                String strX6 = this.i.X6(string);
                StringBuilder sb = new StringBuilder();
                sb.append(this.Z.getText().toString());
                sb.append(":");
                sb.append(W(string, this.k));
                sb.append(":");
                Z00 z00 = this.i;
                sb.append(z00.J6(string, z00.l3("0"), 1, false, this.D0 + "", this.p, strX6));
                sb.append(":");
                Z00 z01 = this.i;
                try {
                    sb.append(z01.K6(string, z01.l3("0"), 2, false, this.D0 + "", this.p, strX6));
                    Log.d("view_item_info=", sb.toString());
                    double dDoubleValue = W(string, this.k).doubleValue();
                    Z00 z02 = this.i;
                    double dJ6 = z02.J6(string, z02.l3("0"), 1, false, this.D0 + "", this.p, strX6);
                    Z00 z03 = this.i;
                    double dK6 = z03.K6(string, z03.l3("0"), 2, false, this.D0 + "", this.p, strX6);
                    double dB6 = this.i.B6(string, this.K.getText().toString());
                    if (dJ6 == -1.0d) {
                        dJ6 = 0.0d;
                    }
                    if (dK6 == -1.0d) {
                        dK6 = 0.0d;
                    }
                    if (dB6 == -1.0d) {
                        dB6 = 0.0d;
                    }
                    textView.setText(this.i.P7(String.valueOf(dDoubleValue)));
                    textView2.setText(this.i.P7(String.valueOf(dJ6)));
                    textView3.setText(this.i.P7(String.valueOf(dK6)));
                    textView4.setText(this.i.P7(String.valueOf(dB6)));
                    builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_hide), new DialogInterfaceOnClickListenerC2474d(builder));
                    if (this.p == 2 && this.i.F6().contains(string)) {
                        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_sales_price), new DialogInterfaceOnClickListenerC2475e());
                    }
                    AlertDialog alertDialogCreate = builder.create();
                    alertDialogCreate.setTitle(this.Z.getText().toString());
                    alertDialogCreate.getWindow().setSoftInputMode(16);
                    alertDialogCreate.show();
                    alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2478h(alertDialogCreate));
                } catch (Exception e) {
                    e = e;
                    Log.d("view_item_info2_error=", ":" + e.getMessage());
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void w0(String str) {
        this.C0.setText(str);
        this.x = this.C0.getText().toString();
        this.z = "";
        this.A = "";
        this.y = "";
        this.B = "";
        this.D = "";
        double dB6 = this.i.B6(str, this.K.getText().toString());
        this.z = dB6 > 0.0d ? String.valueOf(dB6) : "";
        this.C = this.i.X6(this.C0.getText().toString());
        this.E = String.valueOf(this.i.Z6(this.C0.getText().toString(), this.C));
        N0(this.l, this.w);
        e1 = 1;
        O0();
    }

    public void x0(String str) {
        this.Z.setText(str);
        this.X.requestFocus();
        double dB6 = this.i.B6(str, this.K.getText().toString());
        this.V.setHint(dB6 <= 0.0d ? "" : this.i.S7(String.valueOf(dB6)));
        double dO0 = o0(this.l, this.w);
        if (this.i.ja("prefOthers_qty_pr", false)) {
            dO0 = this.i.c0(dO0 + "", 1.0d);
        }
        this.X.setHint(String.valueOf(dO0));
        this.H0.setText(this.i.X6(this.Z.getText().toString()));
        if (this.i.W6(this.Z.getText().toString()) > 1) {
            this.H0.setVisibility(0);
        } else {
            this.H0.setVisibility(8);
        }
        if (this.p == 4 && this.i.ja("prefOthers_item_end_date", false)) {
            this.Y.setVisibility(0);
            int i = Integer.parseInt(this.i.J1(r0()));
            if (i == 1 || i == 3) {
                ArrayList arrayListX = X(this.Z.getText().toString(), this.k);
                if (arrayListX.size() == 0) {
                    this.Y.setVisibility(8);
                } else {
                    for (int i2 = 0; i2 < arrayListX.size(); i2++) {
                        if (Double.parseDouble((String) ((HashMap) arrayListX.get(i2)).get("item_qty")) > 0.0d) {
                            this.Y.setText((CharSequence) ((HashMap) arrayListX.get(i2)).get("item_date"));
                            this.X.setHint((CharSequence) ((HashMap) arrayListX.get(i2)).get("item_qty"));
                            break;
                        }
                    }
                }
            }
        }
        this.V.setTag("1");
        this.X.selectAll();
        this.V.selectAll();
        this.W.selectAll();
        n0();
    }

    public void y0() {
        this.b1 = true;
        T(2, this.p);
        this.d1 = 2;
    }

    public void z0(String str) {
        try {
            C0809Ov c0809Ov = this.j0;
            if (c0809Ov != null) {
                c0809Ov.getFilter().filter(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
