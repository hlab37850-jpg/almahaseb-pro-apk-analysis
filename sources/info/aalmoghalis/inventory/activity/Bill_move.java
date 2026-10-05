package info.aalmoghalis.inventory.activity;

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
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.timepicker.TimeModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0634Jt;
import defpackage.C0974Ur;
import defpackage.C1044Xj;
import defpackage.C1072Xv;
import defpackage.C1098Yv;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.MO;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Bill_move extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int O0;
    public boolean B0;
    public int D;
    public int E;
    public int F;
    public SearchView F0;
    public C1098Yv X;
    public LinearLayout a0;
    public LinearLayout b0;
    public LinearLayout c0;
    public C1072Xv f0;
    public SQLiteDatabase h;
    public SparseBooleanArray h0;
    public Z00 i;
    public ArrayAdapter i0;
    public String j;
    public String k;
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
    public String C = "1";
    public ListView G = null;
    public Toolbar H = null;
    public TextView I = null;
    public AutoCompleteTextView J = null;
    public AutoCompleteTextView K = null;
    public TextView L = null;
    public TextView M = null;
    public ImageView N = null;
    public ImageView O = null;
    public ImageView P = null;
    public ImageView Q = null;
    public EditText R = null;
    public TextView S = null;
    public AutoCompleteTextView T = null;
    public AutoCompleteTextView U = null;
    public TextView V = null;
    public ImageView W = null;
    public ArrayList Y = new ArrayList();
    public ImageView Z = null;
    public EditText d0 = null;
    public EditText e0 = null;
    public List g0 = new ArrayList();
    public ImageButton j0 = null;
    public int k0 = 0;
    public String[] l0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] m0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String n0 = "";
    public int o0 = 0;
    public int p0 = 0;
    public String q0 = "";
    public String r0 = "";
    public final Context s0 = this;
    public int t0 = 0;
    public int u0 = 0;
    public String v0 = "";
    public String w0 = "";
    public EditText x0 = null;
    public AutoCompleteTextView y0 = null;
    public int z0 = 0;
    public double A0 = 0.0d;
    public int C0 = 1;
    public String D0 = "";
    public String E0 = "0";
    public DatePickerDialog.OnDateSetListener G0 = new F();
    public DatePickerDialog.OnDateSetListener H0 = new G();
    public TextWatcher I0 = new H();
    public boolean J0 = false;
    public int K0 = 0;
    public boolean L0 = false;
    public int M0 = 0;
    public int N0 = 0;

    public class A implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ Handler b;

        public A(String str, Handler handler) {
            this.a = str;
            this.b = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_move.this.N(this.a);
            Bill_move.this.B0 = true;
            Handler handler = this.b;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class B implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public B(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_move.this.B0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class C implements AdapterView.OnItemClickListener {
        public C() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_move.this.J.setText(adapterView.getItemAtPosition(i).toString());
            Bill_move.this.K.requestFocus();
            Bill_move.this.w0();
            Bill_move.this.t0();
            Bill_move.this.N0 = 1;
        }
    }

    public class D implements Filter.FilterListener {
        public D() {
        }

        @Override // android.widget.Filter.FilterListener
        public void onFilterComplete(int i) {
            if (i == 0) {
                Bill_move.this.F0.setQuery("", false);
            }
        }
    }

    public class E implements SearchView.OnQueryTextListener {
        public E() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Bill_move.this.q0(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class F implements DatePickerDialog.OnDateSetListener {
        public F() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_move.this.D = i;
            Bill_move.this.E = i2;
            Bill_move.this.F = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_move.this.D)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_move.this.E + 1)) + "-" + Bill_move.this.F;
                Locale locale = Locale.ENGLISH;
                Bill_move.this.I.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class G implements DatePickerDialog.OnDateSetListener {
        public G() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_move.this.D = i;
            Bill_move.this.E = i2;
            Bill_move.this.F = i3;
            try {
                String str = Bill_move.this.D + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_move.this.E + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_move.this.F));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                new SimpleDateFormat("yyyy-MM-dd", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public class H implements TextWatcher {
        public H() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Bill_move.this.N0 = 1;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class I implements DialogInterface.OnClickListener {
        public I() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_move bill_move = Bill_move.this;
                bill_move.Q(2, bill_move.p);
            } catch (Exception unused) {
                Toast.makeText(Bill_move.this.getApplicationContext(), Bill_move.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class J implements DialogInterface.OnClickListener {
        public J() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_move bill_move = Bill_move.this;
            if (bill_move.M0 == 1) {
                bill_move.finish();
            }
        }
    }

    public class K implements DialogInterface.OnClickListener {
        public K() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_move.this.i.H("delete from bill_transactions where bill_id='" + Bill_move.this.l + "' and exists(select * from bills a where a.id=bill_transactions.bill_id and a.date_='" + Bill_move.this.n + "' and tr_type=" + Bill_move.this.p + ")", "delete from bills where id ='" + Bill_move.this.l + "' and date_='" + Bill_move.this.n + "'");
                Bill_move bill_move = Bill_move.this;
                bill_move.J0 = true;
                Moves2.V = Moves2.V - 1;
                bill_move.j0();
            } catch (Exception unused) {
                Toast.makeText(Bill_move.this.getApplicationContext(), "SQL Error.", 1);
            }
        }
    }

    public class L implements View.OnTouchListener {
        public L() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (Bill_move.this.J.getText().toString().length() == 0) {
                Bill_move.this.J.showDropDown();
            }
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= Bill_move.this.J.getTotalPaddingLeft()) {
                    Bill_move.this.J.setText("");
                    Bill_move.this.J.requestFocus();
                    Bill_move.this.w0();
                    return false;
                }
                motionEvent.getX();
                Bill_move.this.J.getTotalPaddingLeft();
            }
            return false;
        }
    }

    public class M implements DialogInterface.OnClickListener {
        public M() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class N implements TextWatcher {
        public N() {
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
                Bill_move.this.J.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(Bill_move.this, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_move.this.J.getCompoundDrawables()[2], (Drawable) null);
            } else {
                Bill_move.this.J.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, Bill_move.this.J.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class O implements AdapterView.OnItemClickListener {
        public O() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_move.this.K.setText(adapterView.getItemAtPosition(i).toString());
            Bill_move.this.d0.requestFocus();
            Bill_move.this.w0();
            Bill_move bill_move = Bill_move.this;
            bill_move.N0 = 1;
            bill_move.t0();
        }
    }

    public class P implements View.OnTouchListener {
        public P() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (Bill_move.this.K.getText().toString().length() == 0) {
                Bill_move.this.K.showDropDown();
            }
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_move.this.K.getCompoundDrawables()[0] != null ? Bill_move.this.K.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_move.this.K.getPaddingLeft() + Bill_move.this.K.getLeft()) {
                    Bill_move.this.K.setText("");
                    Bill_move.this.K.requestFocus();
                    Bill_move.this.w0();
                    return false;
                }
                motionEvent.getX();
                Bill_move.this.K.getRight();
                Bill_move.this.K.getPaddingRight();
                if (Bill_move.this.K.getCompoundDrawables()[2] != null) {
                    Bill_move.this.K.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class Q implements TextWatcher {
        public Q() {
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
                Bill_move.this.K.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(Bill_move.this, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_move.this.K.getCompoundDrawables()[2], (Drawable) null);
            } else {
                Bill_move.this.K.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, Bill_move.this.K.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$a, reason: case insensitive filesystem */
    public class C2662a implements AdapterView.OnItemClickListener {
        public C2662a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_move.this.n0(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$b, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2663b implements View.OnTouchListener {
        public ViewOnTouchListenerC2663b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_move.this.y0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_move.this.y0.getCompoundDrawables()[0] != null ? Bill_move.this.y0.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_move.this.y0.getPaddingLeft() + Bill_move.this.y0.getLeft()) {
                    Bill_move.this.y0.setText("");
                    Bill_move.this.y0.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_move.this.y0.getRight();
                Bill_move.this.y0.getPaddingRight();
                if (Bill_move.this.y0.getCompoundDrawables()[2] != null) {
                    Bill_move.this.y0.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$c, reason: case insensitive filesystem */
    public class C2664c implements TextWatcher {
        public C2664c() {
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
                Bill_move bill_move = Bill_move.this;
                bill_move.y0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_move, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_move.this.y0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_move.this.y0;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$d, reason: case insensitive filesystem */
    public class C2665d implements AdapterView.OnItemClickListener {
        public C2665d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C0634Jt c0634Jt = (C0634Jt) adapterView.getItemAtPosition(i);
                TextView textView = (TextView) view.findViewById(R.id.no_);
                Bill_move.this.w = textView.getText().toString();
                Bill_move.this.x = c0634Jt.e();
                TextView textView2 = (TextView) view.findViewById(R.id.item_qty);
                Bill_move.this.y = textView2.getText().toString();
                Bill_move.this.z = c0634Jt.b();
                Bill_move.this.A = c0634Jt.l();
                Bill_move.this.C = c0634Jt.m();
                Bill_move.this.B = c0634Jt.c();
                Bill_move.O0 = 2;
                Bill_move.this.A0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$e, reason: case insensitive filesystem */
    public class C2666e implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$e$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Bill_move.this.a0();
                } catch (Exception unused) {
                    Toast.makeText(Bill_move.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$e$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2666e() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() != R.id.menu_delete) {
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB = Bill_move.this.f0.b();
            Bill_move bill_move = Bill_move.this;
            bill_move.h0 = sparseBooleanArrayB;
            AlertDialog.Builder builder = new AlertDialog.Builder(bill_move);
            builder.setMessage(Bill_move.this.getString(R.string.delete_msg));
            builder.setPositiveButton(Bill_move.this.getString(R.string.confirm_yes), new a());
            builder.setNegativeButton(Bill_move.this.getString(R.string.confirm_no), new b());
            builder.create().show();
            actionMode.finish();
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar_4, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Bill_move.this.G.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Bill_move.this.f0.i.clear();
            Bill_move.this.f0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Bill_move.this.G.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Bill_move.this.f0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$f, reason: case insensitive filesystem */
    public class C2667f implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2667f(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (!Bill_move.this.V.getText().toString().equals(adapterView.getItemAtPosition(i).toString())) {
                Bill_move.this.V.setText(adapterView.getItemAtPosition(i).toString());
                Bill_move bill_move = Bill_move.this;
                double dZ6 = bill_move.i.Z6(bill_move.T.getText().toString(), Bill_move.this.V.getText().toString());
                Bill_move.this.C = String.valueOf(dZ6);
                Bill_move bill_move2 = Bill_move.this;
                bill_move2.R.setTag(bill_move2.C);
                Bill_move bill_move3 = Bill_move.this;
                double dG0 = bill_move3.g0(bill_move3.l, Bill_move.this.w);
                if (Bill_move.this.i.ja("prefOthers_qty_pr", false)) {
                    Bill_move.this.R.setHint(Bill_move.this.i.c0(String.valueOf(dG0 / dZ6), dZ6) + "");
                } else {
                    Bill_move.this.R.setHint(String.valueOf(C1839c10.C(dG0 / dZ6, C1839c10.d)));
                }
            }
            this.a.dismiss();
            Bill_move bill_move4 = Bill_move.this;
            bill_move4.i.Md(bill_move4);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$g, reason: case insensitive filesystem */
    public class C2668g implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2668g(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            HashMap map = (HashMap) adapterView.getItemAtPosition(i);
            String str = (String) map.get("item_date");
            if (Bill_move.this.S != null) {
                double d = Double.parseDouble((String) map.get("item_qty"));
                if (d >= 0.0d) {
                    Bill_move.this.S.setText(str);
                    Bill_move.this.R.setHint(String.valueOf(d));
                    if (Bill_move.this.R.getText().toString().length() > 0 && Double.parseDouble(Bill_move.this.R.getText().toString().replaceAll(",", "")) > d) {
                        Bill_move bill_move = Bill_move.this;
                        bill_move.R.setText(bill_move.i.S7(String.valueOf(d)));
                    }
                }
            }
            this.a.dismiss();
            Bill_move bill_move2 = Bill_move.this;
            bill_move2.i.Md(bill_move2);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$h, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2669h implements View.OnClickListener {
        public ViewOnClickListenerC2669h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int[] iArr = {android.R.id.text1};
            Bill_move bill_move = Bill_move.this;
            Bill_move.this.V(new SimpleAdapter(bill_move, bill_move.T(bill_move.T.getText().toString(), Bill_move.this.J.getText().toString()), android.R.layout.simple_list_item_2, new String[]{"item_date_qty"}, iArr));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$i, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2670i implements View.OnClickListener {
        public ViewOnClickListenerC2670i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_move bill_move = Bill_move.this;
            Bill_move.this.W(new ArrayAdapter(bill_move, android.R.layout.simple_spinner_dropdown_item, bill_move.i.a9(bill_move.T.getText().toString())));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2671j implements View.OnClickListener {
        public ViewOnClickListenerC2671j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_move.this.more_item(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$k, reason: case insensitive filesystem */
    public class C2672k implements AdapterView.OnItemClickListener {
        public C2672k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_move.this.o0(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$l, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2673l implements View.OnTouchListener {
        public ViewOnTouchListenerC2673l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_move.this.T.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_move.this.T.getCompoundDrawables()[0] != null ? Bill_move.this.T.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_move.this.T.getPaddingLeft() + Bill_move.this.T.getLeft()) {
                    Bill_move.this.T.setText("");
                    Bill_move.this.V.setVisibility(8);
                    Bill_move.this.V.setText("");
                    Bill_move.this.R.setText("");
                    Bill_move.this.S.setText("");
                    Bill_move.this.T.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_move.this.T.getRight();
                Bill_move.this.T.getPaddingRight();
                if (Bill_move.this.T.getCompoundDrawables()[2] != null) {
                    Bill_move.this.T.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$m, reason: case insensitive filesystem */
    public class C2674m implements TextWatcher {
        public C2674m() {
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
                Bill_move bill_move = Bill_move.this;
                bill_move.T.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_move, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_move.this.y0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_move.this.T;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$n, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2675n implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2675n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$o, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2676o implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2676o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$p, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2677p implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2677p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_move$q, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2678q implements DialogInterface.OnClickListener {
        public final /* synthetic */ android.app.AlertDialog.Builder a;

        public DialogInterfaceOnClickListenerC2678q(android.app.AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
            Bill_move.this.z0();
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ android.app.AlertDialog a;

        public r(android.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Button button = (Button) view;
                if (button.getText() == null || !button.getText().toString().equals(Bill_move.this.getString(R.string.add_transaction))) {
                    if (Bill_move.this.b0()) {
                        this.a.dismiss();
                        Bill_move.this.z0();
                    }
                } else if (Bill_move.this.b0()) {
                    Bill_move.this.x0();
                } else if (Bill_move.this.T.getText() == null || Bill_move.this.T.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_move.this.z0();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_move.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class s implements View.OnClickListener {
        public final /* synthetic */ android.app.AlertDialog a;

        public s(android.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (Bill_move.this.b0() || Bill_move.this.T.getText() == null || Bill_move.this.T.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_move.this.z0();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(Bill_move.this.getBaseContext(), "SQL Error.", 1);
            }
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
        public final /* synthetic */ View a;

        public u(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_move.this.add_item(this.a);
            } catch (Exception unused) {
            }
        }
    }

    public class v implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ android.app.AlertDialog c;

        public v(AutoCompleteTextView autoCompleteTextView, View view, android.app.AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = view;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bill_move.this.i.v0("insert into items  (name  ,o_qty  ,item_type_id,o_date_)  values( '" + ((Object) this.a.getText()) + "' ,'0','" + Bill_move.this.u0 + "', strftime('%Y-%m-%d','now') )");
                Bill_move.this.add_item(this.b);
            } catch (Exception unused) {
            }
            this.c.dismiss();
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public w(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Bill_move.this.i.v0("delete from items_temp  where no_=  '" + ((Object) this.a.getText()) + "'");
                    Bill_move bill_move = Bill_move.this;
                    bill_move.t0 = 1;
                    bill_move.e0();
                    Bill_move.this.p0();
                    Bill_move.this.e0();
                    Bill_move.this.Z();
                    Bill_move.this.y0(false);
                    Bill_move bill_move2 = Bill_move.this;
                    bill_move2.Y = bill_move2.i.m7(String.valueOf(bill_move2.l), "0", Bill_move.this.J.getText().toString(), Bill_move.this.i.ja("prefOthers_item_end_date", false));
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_move.this.getApplicationContext(), Bill_move.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class x implements DialogInterface.OnClickListener {
        public x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class y extends Handler {
        public y() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class z implements View.OnClickListener {
        public z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_move.this.showDialog(0);
            Bill_move.this.N0 = 1;
        }
    }

    private boolean R() {
        boolean zA = AbstractC4371yX.a(this.J);
        if (!AbstractC4371yX.a(this.K)) {
            zA = false;
        }
        if (this.l != 0 && !AbstractC4371yX.a(this.d0)) {
            zA = false;
        }
        if (this.J.getText().toString().equals(this.K.getText().toString())) {
            this.K.setError(getString(R.string.not_valid));
            zA = false;
        }
        if (!this.i.Q()) {
            return zA;
        }
        X();
        return false;
    }

    private boolean k0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean l0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && k0(21, 22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void A0() {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_bill_item_move_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.T = (AutoCompleteTextView) viewInflate.findViewById(R.id.item_name);
            this.R = (EditText) viewInflate.findViewById(R.id.item_qty);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.item_remarks);
            this.U = autoCompleteTextView;
            this.i.cd(this, autoCompleteTextView);
            TextView textView = (TextView) viewInflate.findViewById(R.id.item_unit);
            this.V = textView;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.Q = (ImageView) viewInflate.findViewById(R.id.tr_item_barcode2);
            if (this.i.ja("prefOthers_barcode", false)) {
                this.Q.setVisibility(0);
            }
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.item_date);
            this.S = textView2;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            if (this.i.ja("prefOthers_item_end_date", false)) {
                this.S.setVisibility(0);
                if (this.p == 3) {
                    this.S.setOnClickListener(new ViewOnClickListenerC2669h());
                }
            } else {
                this.S.setVisibility(8);
            }
            this.V.setOnClickListener(new ViewOnClickListenerC2670i());
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
            this.W = imageView;
            imageView.setOnClickListener(new ViewOnClickListenerC2671j());
            ArrayList arrayListG6 = this.i.G6();
            C2160f10.c0(this, this.T, arrayListG6, 2);
            C1098Yv c1098Yv = new C1098Yv(this, R.layout.data_det_row_search, arrayListG6, 4);
            this.X = c1098Yv;
            c1098Yv.l.clear();
            this.X.notifyDataSetChanged();
            this.T.setThreshold(1);
            this.T.setAdapter(this.X);
            this.T.setOnItemClickListener(new C2672k());
            this.T.setOnTouchListener(new ViewOnTouchListenerC2673l());
            this.T.addTextChangedListener(new C2674m());
            this.T.setText(this.x);
            this.R.setText(this.y);
            this.U.setText(this.z);
            if (this.i.W6(this.T.getText().toString()) > 1) {
                this.V.setVisibility(0);
            } else {
                this.V.setVisibility(8);
            }
            this.V.setText(this.A);
            this.R.setTag(this.C);
            this.S.setText(this.B);
            double dG0 = g0(this.l, this.w);
            if (this.i.ja("prefOthers_qty_pr", false)) {
                this.R.setHint(this.i.c0(String.valueOf(dG0 / Double.valueOf(this.C).doubleValue()), Double.parseDouble(this.C)) + "");
            } else {
                this.R.setHint(String.valueOf(C1839c10.C(dG0 / Double.valueOf(this.C).doubleValue(), C1839c10.d)));
            }
            if (O0 == 1 && this.i.ja("prefOthers_item_end_date", false) && this.p == 3) {
                ArrayList arrayListT = T(this.T.getText().toString(), this.J.getText().toString());
                if (arrayListT.size() == 0) {
                    this.S.setVisibility(8);
                } else {
                    for (int i = 0; i < arrayListT.size(); i++) {
                        if (Double.parseDouble((String) ((HashMap) arrayListT.get(i)).get("item_qty")) > 0.0d) {
                            this.S.setText((CharSequence) ((HashMap) arrayListT.get(i)).get("item_date"));
                            this.R.setHint((CharSequence) ((HashMap) arrayListT.get(i)).get("item_qty"));
                            String str = "" + ((String) ((HashMap) arrayListT.get(i)).get("item_qty"));
                            this.y = str;
                            this.R.setText(str);
                            break;
                        }
                    }
                }
            }
            if (O0 != 2 && this.x.equals("")) {
                this.T.requestFocus();
            } else {
                this.R.requestFocus();
            }
            this.R.selectAll();
            if (this.T.getText().toString().length() > 0) {
                f0();
            }
            if (O0 == 2) {
                builder.setPositiveButton(getString(R.string.edit_transaction), new DialogInterfaceOnClickListenerC2675n());
            } else {
                builder.setPositiveButton(getString(R.string.add_transaction), new DialogInterfaceOnClickListenerC2676o());
                builder.setNeutralButton(getString(R.string.btn_add_close), new DialogInterfaceOnClickListenerC2677p());
            }
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2678q(builder));
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new r(alertDialogCreate));
            alertDialogCreate.getButton(-3).setOnClickListener(new s(alertDialogCreate));
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("view_item_error=", ":" + e.getMessage());
        }
    }

    public void N(String str) {
        this.i.A(str, this.p);
    }

    public void O() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void P() {
        if (this.i.ja("prefOthers_closed_year", false)) {
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg));
        builder.setPositiveButton(getString(R.string.confirm_yes), new K());
        builder.setNegativeButton(getString(R.string.confirm_no), new M());
        builder.create().show();
    }

    public void Q(int i, int i2) {
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
            if (R()) {
                if (this.p == 3) {
                    if (this.i.v8(this.J.getText().toString(), this.p).getCount() == 0) {
                        AutoCompleteTextView autoCompleteTextView = this.J;
                        autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                        d0(getString(R.string.validation_add_branch), getString(R.string.validation_add_branch) + "#" + ((Object) this.J.getText()), this, this.J.getText().toString());
                        if (!this.B0) {
                            return;
                        }
                    }
                    if (this.i.v8(this.K.getText().toString(), this.p).getCount() == 0) {
                        AutoCompleteTextView autoCompleteTextView2 = this.K;
                        autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                        d0(getString(R.string.validation_add_branch), getString(R.string.validation_add_branch) + "#" + ((Object) this.K.getText()), this, this.K.getText().toString());
                        if (!this.B0) {
                            return;
                        }
                    }
                }
                if (this.i.g2().getCount() == 0) {
                    this.O.performClick();
                    return;
                }
                Object objValueOf = "null";
                String string3 = "";
                if (this.l == 0) {
                    long jL2 = this.i.l2();
                    Z00 z00 = this.i;
                    long jM2 = z00.m2(this.p, 0, z00.D2(this.J.getText().toString()));
                    this.d0.setHint(getString(R.string.bill_no2) + jM2);
                    if (this.d0.getText().toString().length() <= 0) {
                        if (this.i.j2(jL2, this.p, 0, this.J.getText().toString(), jM2 + "", "") > 0) {
                            this.d0.setError(getString(R.string.doc_no_error));
                            return;
                        }
                    } else if (this.i.j2(jL2, this.p, 0, this.J.getText().toString(), this.d0.getText().toString(), "") > 0) {
                        this.d0.setError(getString(R.string.doc_no_error));
                        return;
                    }
                    if (this.p == 3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into bills (id,tr_type,date_,amount,br_id,to_br_id,tran_status,bill_type,bill_no2,remarks,curr_id,bill_no,online,user_id) values(");
                        sb.append(jL2);
                        sb.append(",");
                        sb.append(i2);
                        sb.append(",'");
                        sb.append((Object) this.I.getText());
                        sb.append("','");
                        sb.append(this.L.getText().toString().replaceAll(",", ""));
                        sb.append("',(select id from branches where name='");
                        sb.append((Object) this.J.getText());
                        sb.append("' ),(select id from branches where name='");
                        sb.append((Object) this.K.getText());
                        sb.append("' ),");
                        sb.append(i);
                        sb.append(",0,'");
                        if (this.d0.getText().toString().length() == 0) {
                            string2 = jM2 + "";
                        } else {
                            string2 = this.d0.getText().toString();
                        }
                        sb.append(string2);
                        sb.append("','");
                        sb.append((Object) this.e0.getText());
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
                        str3 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id,b.remark ,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    } else {
                        string = "";
                        str3 = string;
                    }
                    if (this.i.H(string, str3) == 0) {
                        Toast.makeText(this, "" + getString(R.string.alarm_bill_no), 1).show();
                        return;
                    }
                    this.i.v0("delete from items_temp");
                    this.l = jL2;
                    this.n = this.I.getText().toString();
                    string3 = string;
                    str = str3;
                    str2 = "";
                } else {
                    s0();
                    if (this.d0.getText().toString().length() > 0 && this.i.j2(this.l, this.p, 0, this.J.getText().toString(), this.d0.getText().toString(), "") > 0) {
                        this.d0.setError(getString(R.string.doc_no_error));
                        return;
                    }
                    if (this.p == 3) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("update bills set date_='");
                        sb2.append((Object) this.I.getText());
                        sb2.append("',amount='");
                        sb2.append(this.L.getText().toString().replaceAll(",", ""));
                        sb2.append("',br_id=(select id from branches where name='");
                        sb2.append((Object) this.J.getText());
                        sb2.append("'),to_br_id=(select id from branches where name='");
                        sb2.append((Object) this.K.getText());
                        sb2.append("'),cus_id=0,bill_no2='");
                        sb2.append((Object) this.d0.getText());
                        sb2.append("',remarks='");
                        sb2.append((Object) this.e0.getText());
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
                        str2 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.l + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                        if (this.i.I(string3, str, str2) == 0) {
                            return;
                        }
                        if (!this.J0) {
                            this.i.Kd(this, getString(R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                    } else {
                        str = "";
                        str2 = str;
                    }
                }
                Log.d("sql1=", string3);
                Log.d("sql2=", str);
                Log.d("sql3=", str2);
                Z();
                this.N0 = 0;
                this.i.v0("delete from items_temp");
                j0();
            }
        } catch (Exception e) {
            Log.d("bill_save_error", e.getMessage());
        }
    }

    public Double S(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.Y, str, str2);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListH.size());
        double d = 0.0d;
        for (int i = 0; i < arrayListH.size(); i++) {
            d += Double.parseDouble((String) ((HashMap) arrayListH.get(i)).get("item_qty"));
        }
        return Double.valueOf(d);
    }

    public ArrayList T(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.Y, str, str2);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListH.iterator();
        while (it.hasNext()) {
            arrayList.add((HashMap) ((HashMap) it.next()).clone());
        }
        double dZ6 = this.i.Z6(str, this.V.getText().toString());
        for (int i = 0; i < arrayList.size(); i++) {
            double d = Double.parseDouble((String) ((HashMap) arrayList.get(i)).get("item_qty")) / dZ6;
            ((HashMap) arrayList.get(i)).put("item_qty", this.i.S7(String.valueOf(d)).replaceAll(",", ""));
            ((HashMap) arrayList.get(i)).put("item_date_qty", "(" + ((String) ((HashMap) arrayList.get(i)).get("item_date")) + ")" + this.i.S7(String.valueOf(d)).replaceAll(",", ""));
        }
        return arrayList;
    }

    public Double U(String str, String str2, String str3) {
        double d;
        ArrayList arrayListG = new C1839c10().g(this.Y, str, str2, str3);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListG.size());
        if (arrayListG.size() > 0) {
            Log.d("check_item_qty=", str + ":" + str2 + "#" + ((String) ((HashMap) arrayListG.get(0)).get("item_qty")));
            d = Double.parseDouble((String) ((HashMap) arrayListG.get(0)).get("item_qty"));
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    public void V(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new C2668g(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void W(ArrayAdapter arrayAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new C2667f(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void X() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.F0(this);
            }
            O();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void Y() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.confirm_save));
        builder.setPositiveButton(getString(R.string.confirm_yes), new I());
        builder.setNegativeButton(getString(R.string.confirm_no), new J());
        builder.create().show();
    }

    public void Z() {
        this.y0 = (AutoCompleteTextView) findViewById(R.id.item_name);
        ArrayList arrayListG6 = this.i.G6();
        C2160f10.c0(this, this.y0, arrayListG6, 1);
        C1098Yv c1098Yv = new C1098Yv(this, R.layout.data_det_row_search, arrayListG6, 4);
        this.X = c1098Yv;
        c1098Yv.l.clear();
        this.X.notifyDataSetChanged();
        this.y0.setThreshold(1);
        this.y0.setAdapter(this.X);
        this.y0.setOnItemClickListener(new C2662a());
        this.y0.setOnTouchListener(new ViewOnTouchListenerC2663b());
        this.y0.addTextChangedListener(new C2664c());
    }

    public void a0() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "edit")) {
                    Context context = this.s0;
                    Toast.makeText(context, context.getString(R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "new")) {
                Context context2 = this.s0;
                Toast.makeText(context2, context2.getString(R.string.no_priv), 0).show();
                return;
            }
        }
        for (int size = this.h0.size() - 1; size >= 0; size--) {
            if (this.h0.valueAt(size)) {
                C0634Jt item = this.f0.getItem(this.h0.keyAt(size));
                this.f0.remove(item);
                this.i.v0("delete from items_temp where no_='" + item.f() + "'");
                this.Y = this.i.m7(String.valueOf(this.l), "0", this.J.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
            }
        }
        this.t0 = 1;
        e0();
        p0();
        e0();
        y0(false);
    }

    public void add_item(View view) {
        this.x = "";
        this.y = "";
        this.z = "";
        if (this.y0.getText() == null || this.y0.getText().toString().equals("")) {
            this.x = "";
            this.y = "";
            this.z = "";
        } else if (this.i.F6().contains(this.y0.getText().toString())) {
            this.x = this.y0.getText().toString();
            this.Y = this.i.m7(String.valueOf(this.l), this.w, this.J.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
            this.y = "" + S(this.T.getText().toString(), this.J.getText().toString()).doubleValue();
        } else {
            this.x = this.y0.getText().toString();
        }
        O0 = 1;
        A0();
    }

    public void add_item2(View view) {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_item_edit2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.item_name);
            builder.setPositiveButton(getString(R.string.resourceID_OK), new t());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new u(viewInflate));
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new v(autoCompleteTextView, viewInflate, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item2_error=", e.getMessage());
        }
    }

    public boolean b0() {
        boolean z2;
        boolean z3;
        String str;
        String str2;
        String str3;
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "edit")) {
                    Context context = this.s0;
                    Toast.makeText(context, context.getString(R.string.no_priv), 0).show();
                    return false;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "new")) {
                Context context2 = this.s0;
                Toast.makeText(context2, context2.getString(R.string.no_priv), 0).show();
                return false;
            }
        }
        try {
            boolean zA = AbstractC4371yX.a(this.R);
            try {
                if (!AbstractC4371yX.a(this.T)) {
                    zA = false;
                }
                try {
                    if (this.T.getText().length() == 0) {
                        return false;
                    }
                    double d = 1.0d;
                    double dB0 = this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(this.R.getText().toString().replaceAll(",", ""), 1.0d) : Double.parseDouble(this.R.getText().toString().replaceAll(",", ""));
                    if (!this.i.F6().contains(this.T.getText().toString()) && !this.i.F6().contains(this.T.getText().toString().trim())) {
                        this.v0 = this.T.getText().toString();
                        this.T.setError("Not Found");
                        this.R.setTag("1");
                        this.V.setVisibility(8);
                        this.V.setText(this.i.X6(this.T.getText().toString()));
                        this.S.setText("");
                        return false;
                    }
                    if (!this.T.getText().toString().equals(this.T.getText().toString().trim()) && this.i.F6().contains(this.T.getText().toString().trim())) {
                        AutoCompleteTextView autoCompleteTextView = this.T;
                        autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                    }
                    if (this.p == 3) {
                        this.Y = this.i.m7(String.valueOf(this.l), this.w, this.J.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
                        double dDoubleValue = S(this.T.getText().toString(), this.J.getText().toString()).doubleValue();
                        if (this.i.ja("prefOthers_item_end_date", false)) {
                            double dH0 = h0(this.l, this.w, this.S.getText().toString());
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.l);
                            sb.append(":");
                            sb.append(this.w);
                            sb.append(":");
                            sb.append(dDoubleValue);
                            sb.append(":");
                            sb.append(dH0);
                            sb.append(":");
                            z3 = zA;
                            str2 = "";
                            d = 1.0d;
                            try {
                                sb.append(dB0 * 1.0d);
                                Log.d("item_qty=", sb.toString());
                                if (dH0 >= 0.0d && dH0 <= dDoubleValue) {
                                    dDoubleValue = dH0;
                                } else if (dH0 < 0.0d) {
                                    dDoubleValue = 0.0d;
                                }
                                this.w0 = this.S.getText().toString();
                            } catch (Exception unused) {
                                z2 = z3;
                            }
                        } else {
                            z3 = zA;
                            str2 = "";
                        }
                        if (this.R.getTag().toString().trim().length() > 0) {
                            str = str2;
                            d = Double.parseDouble(this.R.getTag().toString().replaceAll(",", str));
                        } else {
                            str = str2;
                        }
                        if (dDoubleValue - (dB0 * d) < 0.0d) {
                            try {
                                EditText editText = this.R;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(getString(R.string.bal_net));
                                sb2.append(" ");
                                sb2.append(this.i.S7(String.valueOf(dDoubleValue / d)).replaceAll(",", str));
                                if (this.S != null) {
                                    str3 = "(" + this.S.getText().toString() + ")";
                                } else {
                                    str3 = str;
                                }
                                sb2.append(str3);
                                editText.setError(sb2.toString());
                                z3 = false;
                            } catch (Exception unused2) {
                                z2 = false;
                            }
                        }
                    } else {
                        z3 = zA;
                        str = "";
                    }
                    if (O0 != 2 && this.i.q7(this.T.getText().toString()) > 0) {
                        this.i.Kd(this, getString(R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                    }
                    if (!z3) {
                        return z3;
                    }
                    String str4 = "''";
                    if (O0 == 2) {
                        Z00 z00 = this.i;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("update items_temp set item_id=(select id from items a where a.name='");
                        sb3.append((Object) this.T.getText());
                        sb3.append("'),item_type_id=(select item_type_id from items a where a.name='");
                        sb3.append((Object) this.T.getText());
                        sb3.append("'),qty='");
                        sb3.append(this.R.getText().toString().replaceAll(",", str));
                        sb3.append("',qty_t='");
                        sb3.append(this.R.getText().toString().replaceAll(",", str));
                        sb3.append("',qty_pr=");
                        sb3.append(dB0);
                        sb3.append(",remark='");
                        sb3.append(this.U.getText().toString());
                        sb3.append("',curr_id=0 ,unit_id=ifnull((select id from units where code='");
                        sb3.append(this.V.getText().toString());
                        sb3.append("'),0),u_val='");
                        sb3.append(String.valueOf(d));
                        sb3.append("',e_date=");
                        TextView textView = this.S;
                        if (textView != null && textView.getText().toString().length() != 0) {
                            str4 = "'" + this.S.getText().toString() + "'";
                        }
                        sb3.append(str4);
                        sb3.append(" where no_='");
                        sb3.append(this.w);
                        sb3.append("'");
                        z00.v0(sb3.toString());
                    } else {
                        Z00 z01 = this.i;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,e_date)  values( (select id from items a where a.name='");
                        sb4.append((Object) this.T.getText());
                        sb4.append("'),(select item_type_id from items a where a.name='");
                        sb4.append((Object) this.T.getText());
                        sb4.append("'),'");
                        sb4.append(this.R.getText().toString().replaceAll(",", str));
                        sb4.append("','");
                        sb4.append(this.R.getText().toString().replaceAll(",", str));
                        sb4.append("','0',0,'");
                        sb4.append(this.U.getText().toString());
                        sb4.append("',ifnull((select id from units where code='");
                        sb4.append(this.V.getText().toString());
                        sb4.append("'),0),'");
                        sb4.append(String.valueOf(d));
                        sb4.append("',(select unit_id from items where name='");
                        sb4.append(this.T.getText().toString());
                        sb4.append("'),");
                        sb4.append(dB0);
                        sb4.append(",");
                        TextView textView2 = this.S;
                        if (textView2 != null && textView2.getText().toString().length() != 0) {
                            str4 = "'" + this.S.getText().toString() + "'";
                        }
                        sb4.append(str4);
                        sb4.append(" )");
                        z01.v0(sb4.toString());
                        if (this.l == 0) {
                            p0();
                        }
                    }
                    this.t0 = 1;
                    Z();
                    this.y0.setText(str);
                    y0(false);
                    this.t0 = 1;
                    e0();
                    p0();
                    this.t0 = 1;
                    e0();
                    this.Y = this.i.m7(String.valueOf(this.l), "0", this.J.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
                    return z3;
                } catch (Exception unused3) {
                    z3 = zA;
                }
                z2 = z3;
            } catch (Exception unused4) {
                z2 = zA;
            }
        } catch (Exception unused5) {
            z2 = true;
        }
        return z2;
    }

    public void barcode_click(View view) {
        if (view.getId() == R.id.tr_item_barcode) {
            this.z0 = 1;
        } else if (view.getId() == R.id.tr_item_barcode2) {
            this.z0 = 2;
        }
        if (this.i.ia("pref_barcode_type", "1").equals("1")) {
            this.i.Td(this);
            return;
        }
        Toast.makeText(this, getString(R.string.usb_barcode), 0).show();
        if (view.getId() == R.id.tr_item_barcode) {
            this.y0.requestFocus();
        } else if (view.getId() == R.id.tr_item_barcode2) {
            this.T.requestFocus();
        }
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_hide(View view) {
        this.b0.setVisibility(8);
        this.c0.setVisibility(0);
        this.Z.setVisibility(0);
        z0();
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.no_);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new w(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new x());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.b0.setVisibility(0);
        this.Z.setVisibility(8);
        this.y0.requestFocus();
        z0();
    }

    public void c0(Cursor cursor) {
        String string;
        Log.d("Cursor_cnt=", String.valueOf(cursor.getCount()));
        y0(false);
        this.g0.clear();
        cursor.moveToFirst();
        double d = 0.0d;
        while (true) {
            string = "";
            if (cursor.isAfterLast()) {
                break;
            }
            this.g0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("item_name")), cursor.getString(cursor.getColumnIndex("item_type")), this.i.P7("" + cursor.getDouble(cursor.getColumnIndex("item_total"))), this.i.T7("" + cursor.getDouble(cursor.getColumnIndex("qty_t"))), this.i.P7(cursor.getString(cursor.getColumnIndex("item_price"))), cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tran_status")), cursor.getString(cursor.getColumnIndex("item_remarks")), cursor.getString(cursor.getColumnIndex("unit_name")), cursor.getString(cursor.getColumnIndex("unit_val")), cursor.getString(cursor.getColumnIndex("qty_pr")), cursor.getString(cursor.getColumnIndex("barcode")), cursor.getString(cursor.getColumnIndex("e_date"))));
            d += cursor.getDouble(cursor.getColumnIndex("qty_pr"));
            if (this.l != 0) {
                this.p = cursor.getInt(cursor.getColumnIndex("tr_type_id"));
                this.J.setText(cursor.getString(cursor.getColumnIndex("tr_name")));
                this.J.dismissDropDown();
                this.K.setText(cursor.getString(cursor.getColumnIndex("to_tr_name")));
                this.K.dismissDropDown();
                this.I.setText(cursor.getString(cursor.getColumnIndex("date_")));
                this.i.nd(this.d0, cursor.getString(cursor.getColumnIndex("bill_no2")));
                this.i.nd(this.e0, cursor.getString(cursor.getColumnIndex("remarks")));
                this.L.setText(this.i.P7("" + cursor.getDouble(cursor.getColumnIndex("amount"))));
                w0();
                Log.d("tran_status=", cursor.getString(cursor.getColumnIndex("tran_status")));
                if (cursor.getString(cursor.getColumnIndex("tran_status")).equals("3")) {
                    this.Z.setVisibility(8);
                }
            }
            cursor.moveToNext();
        }
        cursor.close();
        if (this.A0 == 0.0d || this.t0 == 1) {
            this.L.setText(NumberFormat.getInstance(Locale.ENGLISH).format(d));
            this.t0 = 0;
        }
        NumberFormat.getInstance(Locale.ENGLISH).format(0.0d);
        C1072Xv c1072Xv = new C1072Xv(this, R.layout.move_item_det_row3, this.g0);
        this.f0 = c1072Xv;
        c1072Xv.i.clear();
        this.f0.notifyDataSetChanged();
        this.G.setAdapter((ListAdapter) this.f0);
        invalidateOptionsMenu();
        SearchView searchView = this.F0;
        if (searchView != null && searchView.getQuery() != null) {
            string = this.F0.getQuery().toString();
        }
        if (string.length() > 0) {
            this.f0.getFilter().filter(string, new D());
        }
    }

    public boolean d0(String str, String str2, Context context, String str3) {
        y yVar = new y();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(R.string.confirm_yes), new A(str3, yVar));
        builder.setNegativeButton(getString(R.string.confirm_no), new B(yVar));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.B0;
    }

    public void e0() {
        try {
            Log.d("get_all_name=", "Yes" + this.l);
            long j = this.l;
            if (j != 0) {
                c0(this.i.E7(String.valueOf(j), this.n));
            } else {
                c0(this.i.f2());
            }
        } catch (Exception e) {
            Log.d("Fetch_error=", e.getMessage());
        }
    }

    public void f0() {
        Log.d("item_remarks=", "..start...");
        C1044Xj.a().c(new RunnableC1171Zj(16, this.i, this.T, this.U, this, new RunnableC1086Yj()));
    }

    public double g0(long j, String str) {
        this.Y = this.i.m7(String.valueOf(this.l), this.w, this.J.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
        return S(this.T.getText().toString(), this.J.getText().toString()).doubleValue();
    }

    public double h0(long j, String str, String str2) {
        this.Y = this.i.m7(String.valueOf(this.l), this.w, this.J.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
        return U(this.T.getText().toString(), this.J.getText().toString(), str2).doubleValue();
    }

    public void i0() {
        try {
            if (getIntent().getStringExtra("TR_ID") == null) {
                this.d0.setHint(getString(R.string.bill_no2) + this.i.m2(this.p, 0, this.j));
                return;
            }
            this.l = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
            if (getIntent().getStringExtra("TR_DATE") != null) {
                this.n = getIntent().getStringExtra("TR_DATE");
                this.i.z0("delete from items_temp");
                this.i.z0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr ,ifnull(e_date,'')  from bill_transactions_v a  where bill_id=" + this.l + " and a.bill_date='" + this.n + "' ");
            } else {
                this.i.z0("delete from items_temp");
                this.i.z0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr  from bill_transactions  where bill_id=" + this.l + "");
            }
            this.u = Integer.parseInt(getIntent().getStringExtra("tran_status"));
            this.o0 = getIntent().getIntExtra("back_edit", 0);
        } catch (Exception unused) {
        }
    }

    public void j0() {
        Log.d("back_edit=", this.o0 + "");
        if (this.o0 == 1 && this.J0) {
            Bill_edit.P2 = true;
            Z00.o0 = false;
            finish();
            return;
        }
        if (this.L0) {
            this.L0 = false;
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,ifnull(e_date,'')   from bill_transactions  where bill_id=" + this.l + "");
            return;
        }
        if (this.p == 3) {
            Intent intent = new Intent(this, (Class<?>) Moves2.class);
            intent.addFlags(67108864);
            intent.putExtra("TR_TYPE", "3");
            intent.putExtra("g_id", this.j);
            intent.putExtra("g_name", this.k);
            startActivity(intent);
            finish();
        }
    }

    public void m0() {
        try {
            if (getIntent().getStringExtra("item_name") != null) {
                String stringExtra = getIntent().getStringExtra("item_name");
                String stringExtra2 = getIntent().getStringExtra("item_qty");
                Bill_edit.R2 = stringExtra;
                int i = 0;
                while (true) {
                    if (i >= this.G.getAdapter().getCount()) {
                        i = -1;
                        break;
                    }
                    C0634Jt c0634Jt = (C0634Jt) this.G.getAdapter().getItem(i);
                    double dB0 = (this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(c0634Jt.h().replaceAll(",", ""), Double.parseDouble(c0634Jt.m())) : Double.parseDouble(c0634Jt.h().replaceAll(",", ""))) * Double.parseDouble(c0634Jt.m());
                    if (c0634Jt.e().equals(stringExtra) && dB0 == Double.parseDouble(stringExtra2.replaceAll(",", ""))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    ListView listView = this.G;
                    listView.performItemClick(listView.getAdapter().getView(i, null, null), i, this.G.getAdapter().getItemId(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void more_item(View view) {
        this.i.te(this, this.T.getText().toString(), this.k, this.i.l3("0"), S(this.T.getText().toString(), this.k).doubleValue(), false, 0L, this.p, this.V.getText().toString());
    }

    public void n0(String str) {
        this.y0.setText(str);
        this.x = this.y0.getText().toString();
        this.A = "";
        this.C = "1";
        this.B = "";
        this.Y = this.i.m7(String.valueOf(this.l), this.w, this.J.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
        this.y = "" + S(this.y0.getText().toString(), this.J.getText().toString()).doubleValue();
        this.A = this.i.X6(this.y0.getText().toString());
        this.C = String.valueOf(this.i.Z6(this.y0.getText().toString(), this.A));
        O0 = 1;
        A0();
    }

    public void o0(String str) {
        this.T.setText(str);
        this.R.requestFocus();
        double dG0 = g0(this.l, this.w);
        if (this.i.ja("prefOthers_qty_pr", false)) {
            dG0 = this.i.b0(dG0 + "", 1.0d);
        }
        this.R.setHint(String.valueOf(dG0));
        this.V.setText(this.i.X6(this.T.getText().toString()));
        if (this.i.W6(this.T.getText().toString()) > 1) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
        if (this.p == 3 && this.i.ja("prefOthers_item_end_date", false)) {
            this.S.setVisibility(0);
            ArrayList arrayListT = T(this.T.getText().toString(), this.J.getText().toString());
            if (arrayListT.size() == 0) {
                this.S.setVisibility(8);
            } else {
                for (int i = 0; i < arrayListT.size(); i++) {
                    if (Double.parseDouble((String) ((HashMap) arrayListT.get(i)).get("item_qty")) > 0.0d) {
                        this.S.setText((CharSequence) ((HashMap) arrayListT.get(i)).get("item_date"));
                        this.R.setHint((CharSequence) ((HashMap) arrayListT.get(i)).get("item_qty"));
                        break;
                    }
                }
            }
        }
        this.R.setTag("1");
        this.R.selectAll();
        f0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            try {
                C0974Ur c0974Ur = this.i.x;
                if (c0974Ur != null && !c0974Ur.l(i, i2, intent)) {
                    super.onActivityResult(i, i2, intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
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
                        this.i.j1(activityResult.getContents(), this, this.X);
                    }
                    if (!strI6.equals("") || Z00.P0) {
                        if (Z00.P0) {
                            strI6 = this.i.I6(activityResult.getContents());
                        }
                        int i3 = this.z0;
                        if (i3 == 1) {
                            n0(strI6);
                        } else if (i3 == 2) {
                            o0(strI6);
                        }
                        this.z0 = 0;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.d("barcode_log_error=", "results=" + e2.getMessage());
            }
        } catch (Exception unused) {
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "edit")) {
                    this.N0 = 0;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "new")) {
                this.N0 = 0;
            }
        }
        int i = this.N0;
        if (i == 1) {
            this.M0 = 1;
            Y();
        } else if (i == 2) {
            v0();
        } else if (this.l != 0) {
            v0();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.content_bill_move);
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        z00.z0("delete from items_temp");
        i0();
        if (this.l != 0) {
            setContentView(R.layout.content_move_det);
        }
        this.G = (ListView) findViewById(R.id.list_items);
        this.I = (TextView) findViewById(R.id.tr_date);
        this.J = (AutoCompleteTextView) findViewById(R.id.tr_name);
        this.K = (AutoCompleteTextView) findViewById(R.id.to_tr_name);
        this.L = (TextView) findViewById(R.id.tr_tot);
        this.M = (TextView) findViewById(R.id.bill_tot_hdr);
        this.O = (ImageView) findViewById(R.id.tr_item_add);
        this.P = (ImageView) findViewById(R.id.tr_item_barcode);
        if (this.i.ja("prefOthers_barcode", false)) {
            this.P.setVisibility(0);
        }
        this.d0 = (EditText) findViewById(R.id.tr_bill_no);
        this.e0 = (EditText) findViewById(R.id.tr_remaks);
        this.a0 = (LinearLayout) findViewById(R.id.root_layout);
        this.b0 = (LinearLayout) findViewById(R.id.item_add_hdr);
        this.c0 = (LinearLayout) findViewById(R.id.bill_items_list_hdr);
        this.Z = (ImageView) findViewById(R.id.page_add);
        this.Y = this.i.m7(String.valueOf(this.l), "0", this.J.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
        if (this.l != 0) {
            this.c0.setVisibility(0);
        }
        this.G.setOnItemClickListener(new C2665d());
        this.G.setChoiceMode(3);
        this.G.setMultiChoiceModeListener(new C2666e());
        Calendar calendar = Calendar.getInstance();
        this.I.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.D = calendar.get(1);
        this.E = calendar.get(2);
        this.F = calendar.get(5);
        this.I.setOnClickListener(new z());
        w0();
        this.J.setOnItemClickListener(new C());
        this.J.setOnTouchListener(new L());
        this.J.addTextChangedListener(new N());
        this.K.setOnItemClickListener(new O());
        this.K.setOnTouchListener(new P());
        this.K.addTextChangedListener(new Q());
        y0(true);
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.p = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                String stringExtra = getIntent().getStringExtra("g_name");
                this.k = stringExtra;
                if (this.l == 0) {
                    this.J.setText(stringExtra);
                    w0();
                    this.J.dismissDropDown();
                    this.K.requestFocus();
                }
                setTitle(getResources().getStringArray(R.array.titles_bills)[this.p - 1]);
                this.n0 = getResources().getStringArray(R.array.titles_bills)[this.p - 1];
                this.i.z0("delete from items_temp");
            }
        } catch (Exception unused) {
        }
        if (this.l != 0) {
            this.J.requestFocus();
        }
        if (getIntent().getStringExtra("TR_ID") != null && C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.p == 3 ? "6" : "7", "edit")) {
                this.J.setEnabled(false);
                this.I.setEnabled(false);
                this.e0.setEnabled(false);
                this.d0.setEnabled(false);
            }
        }
        if (C2160f10.h != -1) {
            this.J.setEnabled(false);
        }
        if (this.l == 0) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        i0();
        e0();
        Z();
        m0();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(l0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.G0, this.D, this.E, this.F);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(l0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.H0, this.D, this.E, this.F);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bill3, menu);
        menu.findItem(R.id.bill_prin).setVisible(this.l != 0);
        menu.findItem(R.id.share).setVisible(this.l != 0);
        menu.findItem(R.id.search).setVisible(this.l != 0);
        menu.findItem(R.id.bill_remove).setVisible(this.l != 0);
        int i = C2160f10.h;
        if (i > 0 && this.l != 0) {
            MenuItem menuItemFindItem = menu.findItem(R.id.bill_submit);
            MenuItem menuItemFindItem2 = menu.findItem(R.id.bill_remove);
            boolean zL = new C2160f10(this.i).l("6", "edit");
            boolean zL2 = new C2160f10(this.i).l("6", HTML.Tag.DEL);
            menuItemFindItem.setVisible(zL);
            menuItemFindItem2.setVisible(zL2);
        } else if (i > 0 && this.l == 0) {
            menu.findItem(R.id.bill_remove).setVisible(new C2160f10(this.i).l("6", HTML.Tag.DEL));
        }
        this.F0 = (SearchView) menu.findItem(R.id.search).getActionView();
        this.F0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.F0.setQueryHint(getString(R.string.search_hint));
        this.F0.setOnQueryTextListener(new E());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        c0(this.i.L2());
        y0(true);
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
        if (menuItem.getItemId() == R.id.bill_save) {
            Q(1, this.p);
        } else if (menuItem.getItemId() == R.id.bill_submit) {
            this.J0 = true;
            Q(2, this.p);
        } else if (menuItem.getItemId() == R.id.bill_remove) {
            P();
        } else if (menuItem.getItemId() == R.id.bill_prin || menuItem.getItemId() == R.id.share) {
            if (menuItem.getItemId() == R.id.bill_prin) {
                this.K0 = 1;
            } else {
                this.K0 = 2;
            }
            if (this.l == 0) {
                Y();
                return true;
            }
            r0(this.K0);
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

    public void p0() {
        this.L0 = true;
        Q(2, this.p);
        this.N0 = 2;
    }

    public void q0(String str) {
        try {
            C1072Xv c1072Xv = this.f0;
            if (c1072Xv != null) {
                c1072Xv.getFilter().filter(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void r0(int i) {
        if (i == 0) {
            return;
        }
        this.i.fb(this.G, this.n0, this.l + "", this.I.getText().toString(), this.J.getHint().toString(), this.J.getText().toString(), this.d0.getText().toString(), this.K.getText().toString(), getString(R.string.total_qty), this.L.getText().toString(), 5, this.p, this.i.ja("prefOthers_print_end_date", false));
        if (i == 1) {
            this.i.ra(this.n0 + ".pdf");
            return;
        }
        if (i == 2) {
            this.i.qd(this.n0 + ".pdf");
        }
    }

    public void s0() {
        if (this.l == 0) {
            EditText editText = this.d0;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.bill_no2));
            Z00 z00 = this.i;
            sb.append(z00.m2(this.p, 0, z00.D2(this.K.getText().toString())));
            editText.setHint(sb.toString());
        }
    }

    public void t0() {
        this.d0.setHint(getString(R.string.bill_no2) + this.i.m2(this.p, 0, this.j));
    }

    public void u0(String str) {
        AutoCompleteTextView autoCompleteTextView;
        if (!str.equals("") && this.i.da(str)) {
            String strI6 = this.i.I6(str);
            Z00.P0 = false;
            if (strI6.equals("")) {
                this.i.j1(str, this, this.X);
            }
            if (!strI6.equals("") || Z00.P0) {
                if (Z00.P0) {
                    strI6 = this.i.I6(str);
                }
                if (this.z0 == 2 || ((autoCompleteTextView = this.T) != null && autoCompleteTextView.hasWindowFocus())) {
                    o0(strI6);
                } else {
                    n0(strI6);
                }
                this.z0 = 0;
            }
        }
    }

    public void update_bill_total(View view) {
    }

    public void v0() {
        Log.d("back_edit=", this.o0 + "");
        if (this.o0 == 1) {
            Bill_edit.P2 = true;
            Bill_edit.R2 = this.J.getText().toString();
            finish();
        } else if (this.p == 3) {
            Intent intent = new Intent(this, (Class<?>) Moves2.class);
            intent.addFlags(67108864);
            intent.putExtra("TR_TYPE", "3");
            intent.putExtra("g_id", this.j);
            intent.putExtra("g_name", this.k);
            startActivity(intent);
            finish();
        }
    }

    public void w0() {
        this.J.setThreshold(1);
        this.K.setThreshold(1);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.z2(this.J.getText().toString(), this.K.getText().toString()));
        this.i0 = arrayAdapter;
        this.J.setAdapter(arrayAdapter);
        this.K.setAdapter(this.i0);
    }

    public void x0() {
        this.T.setText((CharSequence) null);
        this.R.setText((CharSequence) null);
        this.U.setText((CharSequence) null);
        this.T.requestFocus();
        this.w = "0";
    }

    public void y0(boolean z2) {
    }
}
