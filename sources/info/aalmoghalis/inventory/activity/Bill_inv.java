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
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC4371yX;
import defpackage.C0634Jt;
import defpackage.C0974Ur;
import defpackage.C1044Xj;
import defpackage.C1072Xv;
import defpackage.C1098Yv;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.MO;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.activity.Bill_inv;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class Bill_inv extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int Q0;
    public int C;
    public boolean C0;
    public int D;
    public int E;
    public SearchView G0;
    public C1098Yv U;
    public LinearLayout X;
    public LinearLayout Y;
    public LinearLayout Z;
    public C1072Xv c0;
    public SparseBooleanArray e0;
    public ArrayAdapter f0;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
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
    public String A = null;
    public String B = "1";
    public ListView F = null;
    public Toolbar G = null;
    public TextView H = null;
    public AutoCompleteTextView I = null;
    public TextView J = null;
    public TextView K = null;
    public ImageView L = null;
    public ImageView M = null;
    public ImageView N = null;
    public ImageView O = null;
    public EditText P = null;
    public AutoCompleteTextView Q = null;
    public AutoCompleteTextView R = null;
    public TextView S = null;
    public ImageView T = null;
    public ArrayList V = new ArrayList();
    public ImageView W = null;
    public EditText a0 = null;
    public EditText b0 = null;
    public List d0 = new ArrayList();
    public ImageButton g0 = null;
    public int h0 = 0;
    public String[] i0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] j0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String k0 = "";
    public TextView l0 = null;
    public int m0 = 0;
    public int n0 = 0;
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
    public TextView y0 = null;
    public AutoCompleteTextView z0 = null;
    public int A0 = 0;
    public double B0 = 0.0d;
    public int D0 = 1;
    public String E0 = "";
    public String F0 = "0";
    public DatePickerDialog.OnDateSetListener H0 = new F();
    public DatePickerDialog.OnDateSetListener I0 = new G();
    public DatePickerDialog.OnDateSetListener J0 = new H();
    public TextWatcher K0 = new I();
    public boolean L0 = false;
    public int M0 = 0;
    public boolean N0 = false;
    public int O0 = 0;
    public int P0 = 0;

    public class A implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ Handler b;

        public A(String str, Handler handler) {
            this.a = str;
            this.b = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_inv.this.L(this.a);
            Bill_inv.this.C0 = true;
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
            Bill_inv.this.C0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class C implements AdapterView.OnItemClickListener {
        public C() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_inv.this.I.setText(adapterView.getItemAtPosition(i).toString());
            Bill_inv.this.v0();
            Bill_inv.this.s0();
            Bill_inv.this.f0();
            Bill_inv.this.P0 = 1;
        }
    }

    public class D implements Filter.FilterListener {
        public D() {
        }

        @Override // android.widget.Filter.FilterListener
        public void onFilterComplete(int i) {
            if (i == 0) {
                Bill_inv.this.G0.setQuery("", false);
            }
        }
    }

    public class E implements SearchView.OnQueryTextListener {
        public E() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Bill_inv.this.p0(str);
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

        public static /* synthetic */ void d(Integer num) {
        }

        public final /* synthetic */ Integer c() {
            new C2160f10(Bill_inv.this.i).W(Bill_inv.this.H.getText().toString());
            return 1;
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_inv.this.C = i;
            Bill_inv.this.D = i2;
            Bill_inv.this.E = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_inv.this.C)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_inv.this.D + 1)) + "-" + Bill_inv.this.E;
                Locale locale = Locale.ENGLISH;
                Bill_inv.this.H.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                AbstractC3132jE.d(new Callable() { // from class: I7
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.a.c();
                    }
                }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: J7
                    @Override // defpackage.InterfaceC2295gf
                    public final void accept(Object obj) {
                        Bill_inv.F.d((Integer) obj);
                    }
                });
                Bill_inv.this.f0();
                Bill_inv bill_inv = Bill_inv.this;
                bill_inv.V = bill_inv.i.n7("0", "0", bill_inv.I.getText().toString(), Bill_inv.this.i.ja("prefOthers_item_end_date", false), Bill_inv.this.H.getText().toString());
            } catch (Exception unused) {
            }
        }
    }

    public class G implements DatePickerDialog.OnDateSetListener {
        public G() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_inv.this.C = i;
            Bill_inv.this.D = i2;
            Bill_inv.this.E = i3;
            try {
                String str = Bill_inv.this.C + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_inv.this.D + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_inv.this.E));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                new SimpleDateFormat("yyyy-MM-dd", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public class H implements DatePickerDialog.OnDateSetListener {
        public H() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            try {
                String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", locale);
                Date date = simpleDateFormat.parse(str);
                TextView textView = Bill_inv.this.y0;
                if (textView != null) {
                    textView.setText(simpleDateFormat2.format(Long.valueOf(date.getTime())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class I implements TextWatcher {
        public I() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Bill_inv.this.P0 = 1;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class J implements View.OnTouchListener {
        public J() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_inv.this.I.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= Bill_inv.this.I.getTotalPaddingLeft()) {
                    Bill_inv.this.I.setText("");
                    Bill_inv.this.I.requestFocus();
                    Bill_inv.this.v0();
                    return false;
                }
                motionEvent.getX();
                Bill_inv.this.I.getTotalPaddingLeft();
            }
            return false;
        }
    }

    public class K implements DialogInterface.OnClickListener {
        public K() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_inv bill_inv = Bill_inv.this;
                bill_inv.O(2, bill_inv.n);
            } catch (Exception unused) {
                Toast.makeText(Bill_inv.this.getApplicationContext(), Bill_inv.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class L implements DialogInterface.OnClickListener {
        public L() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_inv bill_inv = Bill_inv.this;
            if (bill_inv.O0 == 1) {
                bill_inv.finish();
            }
        }
    }

    public class M implements DialogInterface.OnClickListener {
        public M() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_inv.this.e0(true);
            Bill_inv.this.c0(false);
        }
    }

    public class N implements DialogInterface.OnClickListener {
        public N() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class O implements DialogInterface.OnClickListener {
        public O() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_inv.this.i.v0("delete from items_temp");
            Bill_inv.this.c0(false);
        }
    }

    public class P implements DialogInterface.OnClickListener {
        public P() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Q implements DialogInterface.OnClickListener {
        public Q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_inv.this.i.H("delete from bill_transactions2 where bill_id='" + Bill_inv.this.l + "'", "delete from bills2 where id ='" + Bill_inv.this.l + "'");
                Bill_inv bill_inv = Bill_inv.this;
                bill_inv.L0 = true;
                Moves2.V = Moves2.V - 1;
                bill_inv.i0();
            } catch (Exception unused) {
                Toast.makeText(Bill_inv.this.getApplicationContext(), "SQL Error.", 1);
            }
        }
    }

    public class R implements DialogInterface.OnClickListener {
        public R() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class S implements TextWatcher {
        public S() {
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
                Bill_inv.this.I.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(Bill_inv.this, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_inv.this.I.getCompoundDrawables()[2], (Drawable) null);
            } else {
                Bill_inv.this.I.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, Bill_inv.this.I.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class T implements Comparator {
        public T() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0634Jt c0634Jt, C0634Jt c0634Jt2) {
            return String.valueOf(c0634Jt2.e()).compareTo(String.valueOf(c0634Jt.e()));
        }
    }

    public class U implements Comparator {
        public U() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0634Jt c0634Jt, C0634Jt c0634Jt2) {
            return String.valueOf(c0634Jt.e()).compareTo(String.valueOf(c0634Jt2.e()));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$a, reason: case insensitive filesystem */
    public class C2641a implements AdapterView.OnItemClickListener {
        public C2641a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_inv.this.m0(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$b, reason: case insensitive filesystem */
    public class C2642b implements AdapterView.OnItemClickListener {
        public C2642b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C0634Jt c0634Jt = (C0634Jt) adapterView.getItemAtPosition(i);
                TextView textView = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.no_);
                Bill_inv.this.v = textView.getText().toString();
                Bill_inv.this.w = c0634Jt.e();
                TextView textView2 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
                Bill_inv.this.x = textView2.getText().toString();
                Bill_inv.this.y = c0634Jt.b();
                Bill_inv.this.z = c0634Jt.l();
                Bill_inv.this.B = c0634Jt.m();
                Bill_inv.this.A = c0634Jt.c();
                Bill_inv.Q0 = 2;
                Bill_inv.this.B0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$c, reason: case insensitive filesystem */
    public class C2643c implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$c$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Bill_inv.this.X();
                } catch (Exception unused) {
                    Toast.makeText(Bill_inv.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$c$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2643c() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() != info.aalmoghalis.inventory.R.id.menu_delete) {
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB = Bill_inv.this.c0.b();
            Bill_inv bill_inv = Bill_inv.this;
            bill_inv.e0 = sparseBooleanArrayB;
            AlertDialog.Builder builder = new AlertDialog.Builder(bill_inv);
            builder.setMessage(Bill_inv.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
            builder.setPositiveButton(Bill_inv.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
            builder.setNegativeButton(Bill_inv.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
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
            Bill_inv.this.F.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Bill_inv.this.c0.i.clear();
            Bill_inv.this.c0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Bill_inv.this.F.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Bill_inv.this.c0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$d, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2644d implements View.OnTouchListener {
        public ViewOnTouchListenerC2644d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_inv.this.z0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_inv.this.z0.getCompoundDrawables()[0] != null ? Bill_inv.this.z0.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_inv.this.z0.getPaddingLeft() + Bill_inv.this.z0.getLeft()) {
                    Bill_inv.this.z0.setText("");
                    Bill_inv.this.z0.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_inv.this.z0.getRight();
                Bill_inv.this.z0.getPaddingRight();
                if (Bill_inv.this.z0.getCompoundDrawables()[2] != null) {
                    Bill_inv.this.z0.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$e, reason: case insensitive filesystem */
    public class C2645e implements TextWatcher {
        public C2645e() {
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
                Bill_inv bill_inv = Bill_inv.this;
                bill_inv.z0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_inv, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_inv.this.z0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_inv.this.z0;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$f, reason: case insensitive filesystem */
    public class C2646f implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2646f(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (!Bill_inv.this.S.getText().toString().equals(adapterView.getItemAtPosition(i).toString())) {
                Bill_inv.this.S.setText(adapterView.getItemAtPosition(i).toString());
                Bill_inv bill_inv = Bill_inv.this;
                double dZ6 = bill_inv.i.Z6(bill_inv.Q.getText().toString(), Bill_inv.this.S.getText().toString());
                Bill_inv.this.B = String.valueOf(dZ6);
                Bill_inv bill_inv2 = Bill_inv.this;
                bill_inv2.P.setTag(bill_inv2.B);
                Bill_inv bill_inv3 = Bill_inv.this;
                double dG0 = bill_inv3.g0(bill_inv3.l, Bill_inv.this.v);
                if (Bill_inv.this.i.ja("prefOthers_qty_pr", false)) {
                    Bill_inv.this.P.setHint(Bill_inv.this.i.c0(String.valueOf(dG0 / dZ6), dZ6) + "");
                } else {
                    Bill_inv.this.P.setHint(String.valueOf(C1839c10.C(dG0 / dZ6, C1839c10.d)));
                }
            }
            this.a.dismiss();
            Bill_inv bill_inv4 = Bill_inv.this;
            bill_inv4.i.Md(bill_inv4);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$g, reason: case insensitive filesystem */
    public class C2647g implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2647g(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            HashMap map = (HashMap) adapterView.getItemAtPosition(i);
            String str = (String) map.get("item_date");
            if (Bill_inv.this.y0 != null) {
                double d = Double.parseDouble((String) map.get("item_qty"));
                if (d >= 0.0d) {
                    Bill_inv.this.y0.setText(str);
                    Bill_inv.this.P.setHint(String.valueOf(d));
                    if (Bill_inv.this.P.getText().toString().length() > 0 && Double.parseDouble(Bill_inv.this.P.getText().toString().replaceAll(",", "")) > d) {
                        Bill_inv bill_inv = Bill_inv.this;
                        bill_inv.P.setText(bill_inv.i.S7(String.valueOf(d)));
                    }
                }
            }
            this.a.dismiss();
            Bill_inv bill_inv2 = Bill_inv.this;
            bill_inv2.i.Md(bill_inv2);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$h, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2648h implements View.OnClickListener {
        public ViewOnClickListenerC2648h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int[] iArr = {android.R.id.text1};
            Bill_inv bill_inv = Bill_inv.this;
            SimpleAdapter simpleAdapter = new SimpleAdapter(bill_inv, bill_inv.R(bill_inv.Q.getText().toString(), Bill_inv.this.I.getText().toString()), android.R.layout.simple_list_item_2, new String[]{"item_date_qty"}, iArr);
            if (simpleAdapter.getCount() > 0) {
                Bill_inv.this.S(simpleAdapter);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$i, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2649i implements View.OnClickListener {
        public ViewOnClickListenerC2649i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_inv bill_inv = Bill_inv.this;
            Bill_inv.this.T(new ArrayAdapter(bill_inv, android.R.layout.simple_spinner_dropdown_item, bill_inv.i.a9(bill_inv.Q.getText().toString())));
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2650j implements View.OnClickListener {
        public ViewOnClickListenerC2650j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_inv.this.more_item(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$k, reason: case insensitive filesystem */
    public class C2651k implements AdapterView.OnItemClickListener {
        public C2651k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_inv.this.n0(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$l, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2652l implements View.OnTouchListener {
        public ViewOnTouchListenerC2652l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_inv.this.Q.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_inv.this.Q.getCompoundDrawables()[0] != null ? Bill_inv.this.Q.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_inv.this.Q.getPaddingLeft() + Bill_inv.this.Q.getLeft()) {
                    Bill_inv.this.Q.setText("");
                    Bill_inv.this.S.setVisibility(8);
                    Bill_inv.this.S.setText("");
                    Bill_inv.this.P.setText("");
                    Bill_inv.this.y0.setText("");
                    Bill_inv.this.Q.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_inv.this.Q.getRight();
                Bill_inv.this.Q.getPaddingRight();
                if (Bill_inv.this.Q.getCompoundDrawables()[2] != null) {
                    Bill_inv.this.Q.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$m, reason: case insensitive filesystem */
    public class C2653m implements TextWatcher {
        public C2653m() {
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
                Bill_inv bill_inv = Bill_inv.this;
                bill_inv.Q.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_inv, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_inv.this.z0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_inv.this.Q;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$n, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2654n implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2654n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$o, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2655o implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2655o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$p, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2656p implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2656p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$q, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2657q implements DialogInterface.OnClickListener {
        public final /* synthetic */ android.app.AlertDialog.Builder a;

        public DialogInterfaceOnClickListenerC2657q(android.app.AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
            Bill_inv.this.z0();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$r, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2658r implements View.OnClickListener {
        public final /* synthetic */ android.app.AlertDialog a;

        public ViewOnClickListenerC2658r(android.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Button button = (Button) view;
                if (button.getText() == null || !button.getText().toString().equals(Bill_inv.this.getString(info.aalmoghalis.inventory.R.string.add_transaction))) {
                    if (Bill_inv.this.Z()) {
                        this.a.dismiss();
                        Bill_inv.this.z0();
                    }
                } else if (Bill_inv.this.Z()) {
                    Bill_inv.this.w0();
                } else if (Bill_inv.this.Q.getText() == null || Bill_inv.this.Q.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_inv.this.z0();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_inv.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$s, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2659s implements View.OnClickListener {
        public final /* synthetic */ android.app.AlertDialog a;

        public ViewOnClickListenerC2659s(android.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (Bill_inv.this.Z() || Bill_inv.this.Q.getText() == null || Bill_inv.this.Q.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_inv.this.z0();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(Bill_inv.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$t, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2660t implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2660t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_inv$u, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2661u implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public DialogInterfaceOnClickListenerC2661u(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_inv.this.add_item(this.a);
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
                Bill_inv.this.i.v0("insert into items  (name  ,o_qty  ,item_type_id,o_date_)  values( '" + ((Object) this.a.getText()) + "' ,'0','" + Bill_inv.this.u0 + "', strftime('%Y-%m-%d','now') )");
                Bill_inv.this.add_item(this.b);
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
                    Bill_inv.this.i.v0("delete from items_temp  where no_=  '" + ((Object) this.a.getText()) + "'");
                    Bill_inv bill_inv = Bill_inv.this;
                    bill_inv.t0 = 1;
                    bill_inv.c0(false);
                    Bill_inv.this.o0();
                    Bill_inv.this.c0(false);
                    Bill_inv.this.W();
                    Bill_inv.this.y0(false);
                    Bill_inv bill_inv2 = Bill_inv.this;
                    bill_inv2.V = bill_inv2.i.n7("0", "0", bill_inv2.I.getText().toString(), Bill_inv.this.i.ja("prefOthers_item_end_date", false), Bill_inv.this.H.getText().toString());
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_inv.this.getApplicationContext(), Bill_inv.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_inv.this.showDialog(0);
            Bill_inv.this.P0 = 1;
        }
    }

    public class y implements DialogInterface.OnClickListener {
        public y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class z extends Handler {
        public z() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    private void A0(List list) {
        Collections.sort(list, Collections.reverseOrder(new T()));
    }

    private boolean P() {
        boolean zA = AbstractC4371yX.a(this.I);
        if (this.l != 0 && !AbstractC4371yX.a(this.a0)) {
            zA = false;
        }
        if (!this.i.Q()) {
            return zA;
        }
        U();
        return false;
    }

    private boolean j0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean k0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && j0(21, 22);
    }

    private void x0(List list) {
        Collections.sort(list, Collections.reverseOrder(new U()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void B0() {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_move_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.Q = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            this.P = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_remarks);
            this.R = autoCompleteTextView;
            this.i.cd(this, autoCompleteTextView);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_unit);
            this.S = textView;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.O = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode2);
            if (this.i.ja("prefOthers_barcode", false)) {
                this.O.setVisibility(0);
            }
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_date);
            this.y0 = textView2;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            if (this.i.ja("prefOthers_item_end_date", false)) {
                this.y0.setVisibility(0);
                this.y0.setOnClickListener(new ViewOnClickListenerC2648h());
            } else {
                this.y0.setVisibility(8);
            }
            this.S.setOnClickListener(new ViewOnClickListenerC2649i());
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_add_amount);
            this.T = imageView;
            imageView.setOnClickListener(new ViewOnClickListenerC2650j());
            ArrayList arrayListG6 = this.i.G6();
            C2160f10.c0(this, this.Q, arrayListG6, 2);
            C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
            this.U = c1098Yv;
            c1098Yv.l.clear();
            this.U.notifyDataSetChanged();
            this.Q.setThreshold(1);
            this.Q.setAdapter(this.U);
            this.Q.setOnItemClickListener(new C2651k());
            this.Q.setOnTouchListener(new ViewOnTouchListenerC2652l());
            this.Q.addTextChangedListener(new C2653m());
            this.Q.setText(this.w);
            this.P.setText(this.x);
            this.R.setText(this.y);
            if (this.i.W6(this.Q.getText().toString()) > 1) {
                this.S.setVisibility(0);
            } else {
                this.S.setVisibility(8);
            }
            this.S.setText(this.z);
            this.P.setTag(this.B);
            this.y0.setText(this.A);
            double dG0 = g0(this.l, this.v);
            if (this.i.ja("prefOthers_qty_pr", false)) {
                this.P.setHint(this.i.c0(String.valueOf(dG0 / Double.valueOf(this.B).doubleValue()), Double.parseDouble(this.B)) + "");
            } else {
                this.P.setHint(String.valueOf(C1839c10.C(dG0 / Double.valueOf(this.B).doubleValue(), C1839c10.d)));
            }
            if (Q0 == 1 && this.i.ja("prefOthers_item_end_date", false)) {
                ArrayList arrayListR = R(this.Q.getText().toString(), this.I.getText().toString());
                if (arrayListR.size() > 0) {
                    for (int i = 0; i < arrayListR.size(); i++) {
                        if (Double.parseDouble((String) ((HashMap) arrayListR.get(i)).get("item_qty")) > 0.0d) {
                            this.y0.setText((CharSequence) ((HashMap) arrayListR.get(i)).get("item_date"));
                            this.P.setHint((CharSequence) ((HashMap) arrayListR.get(i)).get("item_qty"));
                            String str = "" + ((String) ((HashMap) arrayListR.get(i)).get("item_qty"));
                            this.x = str;
                            this.P.setText(str);
                            break;
                        }
                    }
                }
            }
            if (Q0 != 2 && this.w.equals("")) {
                this.Q.requestFocus();
            } else {
                this.P.requestFocus();
            }
            this.P.selectAll();
            if (this.Q.getText().toString().length() > 0) {
                d0();
            }
            if (Q0 == 2) {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new DialogInterfaceOnClickListenerC2654n());
            } else {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.add_transaction), new DialogInterfaceOnClickListenerC2655o());
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.btn_add_close), new DialogInterfaceOnClickListenerC2656p());
            }
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2657q(builder));
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2658r(alertDialogCreate));
            alertDialogCreate.getButton(-3).setOnClickListener(new ViewOnClickListenerC2659s(alertDialogCreate));
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("view_item_error=", ":" + e.getMessage());
        }
    }

    public void L(String str) {
        this.i.A(str, this.n);
    }

    public void M() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void N() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new Q());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new R());
        builder.create().show();
    }

    public void O(int i, int i2) {
        String str;
        String str2;
        String string;
        String str3;
        String string2;
        try {
            C2160f10.h = MO.b(this);
            if (P()) {
                if (this.n == 7 && this.i.v8(this.I.getText().toString(), this.n).getCount() == 0) {
                    AutoCompleteTextView autoCompleteTextView = this.I;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                    b0(getString(info.aalmoghalis.inventory.R.string.validation_add_branch), getString(info.aalmoghalis.inventory.R.string.validation_add_branch) + "#" + ((Object) this.I.getText()), this, this.I.getText().toString());
                    if (!this.C0) {
                        return;
                    }
                }
                if (this.i.g2().getCount() == 0) {
                    this.M.performClick();
                    return;
                }
                Object objValueOf = "null";
                String string3 = "";
                if (this.l == 0) {
                    int iV1 = this.i.V1();
                    int iW1 = this.i.W1(this.n, this.I.getText().toString());
                    this.a0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + iW1);
                    if (this.n == 7) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into bills2 (id,tr_type,date_,amount,br_id,tran_status,bill_type,bill_no2,remarks,curr_id,bill_no,online,user_id) values(");
                        sb.append(iV1);
                        sb.append(",");
                        sb.append(i2);
                        sb.append(",'");
                        sb.append((Object) this.H.getText());
                        sb.append("','");
                        sb.append(this.J.getText().toString().replaceAll(",", ""));
                        sb.append("',(select id from branches where name='");
                        sb.append((Object) this.I.getText());
                        sb.append("' ),");
                        sb.append(i);
                        sb.append(",0,'");
                        if (this.a0.getText().toString().length() == 0) {
                            string2 = iW1 + "";
                        } else {
                            string2 = this.a0.getText().toString();
                        }
                        sb.append(string2);
                        sb.append("','");
                        sb.append((Object) this.b0.getText());
                        sb.append("',0,0,");
                        sb.append("0");
                        sb.append(",");
                        int i3 = C2160f10.h;
                        if (i3 != -1) {
                            objValueOf = Integer.valueOf(i3);
                        }
                        sb.append(objValueOf);
                        sb.append(" )");
                        string = sb.toString();
                        str3 = "insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + iV1 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id,b.remark ,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    } else {
                        string = "";
                        str3 = string;
                    }
                    String strL = this.i.L(string, str3);
                    if (strL != null && strL.equals("1")) {
                        this.i.v0("delete from items_temp");
                        this.l = iV1;
                        str2 = "";
                        string3 = string;
                        str = str3;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error:");
                    if (strL != null && strL.length() > 20) {
                        strL = strL.substring(0, 20);
                    }
                    sb2.append(strL);
                    Toast.makeText(this, sb2.toString(), 0).show();
                    return;
                }
                r0();
                if (this.n == 7) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("update bills2 set date_='");
                    sb3.append((Object) this.H.getText());
                    sb3.append("',amount='");
                    sb3.append(this.J.getText().toString().replaceAll(",", ""));
                    sb3.append("',br_id=(select id from branches where name='");
                    sb3.append((Object) this.I.getText());
                    sb3.append("'),cus_id=0,bill_no2='");
                    sb3.append((Object) this.a0.getText());
                    sb3.append("',remarks='");
                    sb3.append((Object) this.b0.getText());
                    sb3.append("',online='");
                    sb3.append("0");
                    sb3.append("',tran_status=");
                    sb3.append(i);
                    sb3.append(",last_user=");
                    int i4 = C2160f10.h;
                    if (i4 != -1) {
                        objValueOf = Integer.valueOf(i4);
                    }
                    sb3.append(objValueOf);
                    sb3.append(" where id='");
                    sb3.append(this.l);
                    sb3.append("'");
                    string3 = sb3.toString();
                    str = "delete from bill_transactions2  where bill_id='" + this.l + "'";
                    str2 = "insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.l + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    String strM = this.i.M(string3, str, str2);
                    if (strM != null && strM.equals("1")) {
                        if (!this.L0) {
                            this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Error:");
                    if (strM != null && strM.length() > 20) {
                        strM = strM.substring(0, 20);
                    }
                    sb4.append(strM);
                    Toast.makeText(this, sb4.toString(), 0).show();
                    return;
                }
                str = "";
                str2 = str;
                Log.d("sql1=", string3);
                Log.d("sql2=", str);
                Log.d("sql3=", str2);
                W();
                this.P0 = 0;
                this.i.v0("delete from items_temp");
                i0();
            }
        } catch (Exception e) {
            Log.d("bill_save_error", e.getMessage());
        }
    }

    public Double Q(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.V, str, str2);
        Log.d("check_item_qty_current=", str + ":" + str2 + "#" + arrayListH.size() + ":" + this.V.size());
        double d = 0.0d;
        for (int i = 0; i < arrayListH.size(); i++) {
            d += Double.parseDouble((String) ((HashMap) arrayListH.get(i)).get("item_qty"));
        }
        return Double.valueOf(d);
    }

    public ArrayList R(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.V, str, str2);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListH.iterator();
        while (it.hasNext()) {
            arrayList.add((HashMap) ((HashMap) it.next()).clone());
        }
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayList.size() + ":" + this.V.size());
        double dZ6 = this.i.Z6(str, this.S.getText().toString());
        for (int i = 0; i < arrayList.size(); i++) {
            double d = Double.parseDouble((String) ((HashMap) arrayList.get(i)).get("item_qty")) / dZ6;
            ((HashMap) arrayList.get(i)).put("item_qty", this.i.S7(String.valueOf(d)).replaceAll(",", ""));
            ((HashMap) arrayList.get(i)).put("item_date_qty", "(" + ((String) ((HashMap) arrayList.get(i)).get("item_date")) + ")" + this.i.S7(String.valueOf(d)).replaceAll(",", ""));
        }
        return arrayList;
    }

    public void S(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new C2647g(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void T(ArrayAdapter arrayAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new C2646f(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void U() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.F0(this);
            }
            M();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void V() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_save));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new K());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new L());
        builder.create().show();
    }

    public void W() {
        this.z0 = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        ArrayList arrayListG6 = this.i.G6();
        C2160f10.c0(this, this.z0, arrayListG6, 1);
        C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
        this.U = c1098Yv;
        c1098Yv.l.clear();
        this.U.notifyDataSetChanged();
        this.z0.setThreshold(1);
        this.z0.setAdapter(this.U);
        this.z0.setOnItemClickListener(new C2641a());
        this.z0.setOnTouchListener(new ViewOnTouchListenerC2644d());
        this.z0.addTextChangedListener(new C2645e());
    }

    public void X() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "edit")) {
                Context context = this.s0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "new")) {
            Context context2 = this.s0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.e0.size() - 1; size >= 0; size--) {
            if (this.e0.valueAt(size)) {
                C0634Jt item = this.c0.getItem(this.e0.keyAt(size));
                this.c0.remove(item);
                this.i.v0("delete from items_temp where no_='" + item.f() + "'");
                this.V = this.i.n7("0", "0", this.I.getText().toString(), this.i.ja("prefOthers_item_end_date", false), this.H.getText().toString());
            }
        }
        this.t0 = 1;
        c0(false);
        o0();
        c0(false);
        y0(false);
    }

    public void Y() {
        String strX4 = this.i.X4("select count(*) as _id from items_temp");
        if (strX4.equals("0")) {
            e0(true);
            c0(false);
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.del_inv_items_confirm).replace("{0}", strX4));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new O());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new P());
        builder.create().show();
    }

    public boolean Z() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "edit")) {
                Context context = this.s0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "new")) {
            Context context2 = this.s0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        boolean z2 = true;
        try {
            boolean zA = AbstractC4371yX.a(this.P);
            try {
                if (!AbstractC4371yX.a(this.Q)) {
                    zA = false;
                }
                if (this.Q.getText().length() == 0) {
                    return false;
                }
                double dB0 = this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(this.P.getText().toString().replaceAll(",", ""), 1.0d) : Double.parseDouble(this.P.getText().toString().replaceAll(",", ""));
                if (!this.i.F6().contains(this.Q.getText().toString()) && !this.i.F6().contains(this.Q.getText().toString().trim())) {
                    this.v0 = this.Q.getText().toString();
                    this.Q.setError("Not Found");
                    this.P.setTag("1");
                    this.S.setVisibility(8);
                    this.S.setText(this.i.X6(this.Q.getText().toString()));
                    this.y0.setText("");
                    return false;
                }
                if (!this.Q.getText().toString().equals(this.Q.getText().toString().trim()) && this.i.F6().contains(this.Q.getText().toString().trim())) {
                    AutoCompleteTextView autoCompleteTextView = this.Q;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                }
                if (Q0 != 2 && this.i.q7(this.Q.getText().toString()) > 0) {
                    this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                }
                double d = this.P.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.P.getTag().toString().replaceAll(",", "")) : 1.0d;
                if (!zA) {
                    return zA;
                }
                String str = "''";
                if (Q0 == 2) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update items_temp set item_id=(select id from items a where a.name='");
                    sb.append((Object) this.Q.getText());
                    sb.append("'),item_type_id=(select item_type_id from items a where a.name='");
                    sb.append((Object) this.Q.getText());
                    sb.append("'),qty='");
                    sb.append(this.P.getText().toString().replaceAll(",", ""));
                    sb.append("',qty_t='");
                    sb.append(this.P.getText().toString().replaceAll(",", ""));
                    sb.append("',qty_pr=");
                    sb.append(dB0);
                    sb.append(",remark='");
                    sb.append(this.R.getText().toString());
                    sb.append("',curr_id=0 ,unit_id=ifnull((select id from units where code='");
                    sb.append(this.S.getText().toString());
                    sb.append("'),0),u_val='");
                    sb.append(String.valueOf(d));
                    sb.append("',e_date=");
                    TextView textView = this.y0;
                    if (textView != null && textView.getText().toString().length() != 0) {
                        str = "'" + this.y0.getText().toString() + "'";
                    }
                    sb.append(str);
                    sb.append(" where no_='");
                    sb.append(this.v);
                    sb.append("'");
                    z00.v0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,e_date)  values( (select id from items a where a.name='");
                    sb2.append((Object) this.Q.getText());
                    sb2.append("'),(select item_type_id from items a where a.name='");
                    sb2.append((Object) this.Q.getText());
                    sb2.append("'),'");
                    sb2.append(this.P.getText().toString().replaceAll(",", ""));
                    sb2.append("','");
                    sb2.append(this.P.getText().toString().replaceAll(",", ""));
                    sb2.append("','0',0,'");
                    sb2.append(this.R.getText().toString());
                    sb2.append("',ifnull((select id from units where code='");
                    sb2.append(this.S.getText().toString());
                    sb2.append("'),0),'");
                    sb2.append(String.valueOf(d));
                    sb2.append("',(select unit_id from items where name='");
                    sb2.append(this.Q.getText().toString());
                    sb2.append("'),");
                    sb2.append(dB0);
                    sb2.append(",");
                    TextView textView2 = this.y0;
                    if (textView2 != null && textView2.getText().toString().length() != 0) {
                        str = "'" + this.y0.getText().toString() + "'";
                    }
                    sb2.append(str);
                    sb2.append(" )");
                    z01.v0(sb2.toString());
                    if (this.l == 0) {
                        o0();
                    }
                }
                this.t0 = 1;
                W();
                this.z0.setText("");
                y0(false);
                this.t0 = 1;
                c0(false);
                o0();
                this.t0 = 1;
                c0(false);
                this.V = this.i.n7("0", "0", this.I.getText().toString(), this.i.ja("prefOthers_item_end_date", false), this.H.getText().toString());
                return zA;
            } catch (Exception unused) {
                z2 = zA;
                return z2;
            }
        } catch (Exception unused2) {
        }
    }

    public void a0(Cursor cursor, boolean z2) {
        String string;
        Log.d("Cursor_cnt=", String.valueOf(cursor.getCount()));
        y0(false);
        this.d0.clear();
        cursor.moveToFirst();
        double d = 0.0d;
        while (true) {
            string = "";
            if (cursor.isAfterLast()) {
                break;
            }
            this.d0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("item_name")), cursor.getString(cursor.getColumnIndex("item_type")), this.i.S7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("item_total")))), this.i.T7("" + cursor.getDouble(cursor.getColumnIndex("qty_t"))), this.i.P7(cursor.getString(cursor.getColumnIndex("item_price"))), cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tran_status")), cursor.getString(cursor.getColumnIndex("item_remarks")), cursor.getString(cursor.getColumnIndex("unit_name")), cursor.getString(cursor.getColumnIndex("unit_val")), cursor.getString(cursor.getColumnIndex("qty_pr")), cursor.getString(cursor.getColumnIndex("barcode")), cursor.getString(cursor.getColumnIndex("e_date"))));
            d += cursor.getDouble(cursor.getColumnIndex("qty_pr"));
            if (this.l != 0) {
                this.n = cursor.getInt(cursor.getColumnIndex("tr_type_id"));
                if (z2) {
                    this.I.setText(cursor.getString(cursor.getColumnIndex("tr_name")));
                    this.I.dismissDropDown();
                    this.H.setText(cursor.getString(cursor.getColumnIndex("date_")));
                }
                this.i.nd(this.a0, cursor.getString(cursor.getColumnIndex("bill_no2")));
                this.i.nd(this.b0, cursor.getString(cursor.getColumnIndex("remarks")));
                this.J.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("amount"))));
                v0();
                if (cursor.getString(cursor.getColumnIndex("tran_status")).equals("3")) {
                    this.W.setVisibility(8);
                }
            }
            cursor.moveToNext();
        }
        cursor.close();
        if (this.B0 == 0.0d || this.t0 == 1) {
            this.J.setText(NumberFormat.getInstance(Locale.ENGLISH).format(d));
            this.t0 = 0;
        }
        NumberFormat.getInstance(Locale.ENGLISH).format(0.0d);
        C1072Xv c1072Xv = new C1072Xv(this, info.aalmoghalis.inventory.R.layout.move_item_det_row3, this.d0);
        this.c0 = c1072Xv;
        c1072Xv.i.clear();
        this.c0.notifyDataSetChanged();
        this.F.setAdapter((ListAdapter) this.c0);
        invalidateOptionsMenu();
        SearchView searchView = this.G0;
        if (searchView != null && searchView.getQuery() != null) {
            string = this.G0.getQuery().toString();
        }
        if (string.length() > 0) {
            this.c0.getFilter().filter(string, new D());
        }
    }

    public void add_item(View view) {
        this.w = "";
        this.x = "";
        this.y = "";
        if (this.z0.getText() == null || this.z0.getText().toString().equals("")) {
            this.w = "";
            this.x = "";
            this.y = "";
        } else if (this.i.F6().contains(this.z0.getText().toString())) {
            this.w = this.z0.getText().toString();
            this.V = this.i.n7("0", this.v, this.I.getText().toString(), this.i.ja("prefOthers_item_end_date", false), this.H.getText().toString());
            double dDoubleValue = Q(this.Q.getText().toString(), this.I.getText().toString()).doubleValue();
            if (dDoubleValue >= 0.0d) {
                this.x = "" + dDoubleValue;
            }
        } else {
            this.w = this.z0.getText().toString();
        }
        Q0 = 1;
        B0();
    }

    public void add_item2(View view) {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_item_edit2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2660t());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2661u(viewInflate));
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new v(autoCompleteTextView, viewInflate, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item2_error=", e.getMessage());
        }
    }

    public boolean b0(String str, String str2, Context context, String str3) {
        z zVar = new z();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new A(str3, zVar));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new B(zVar));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.C0;
    }

    public void barcode_click(View view) {
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.A0 = 1;
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.A0 = 2;
        }
        if (this.i.ia("pref_barcode_type", "1").equals("1")) {
            this.i.Td(this);
            return;
        }
        Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.usb_barcode), 0).show();
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.z0.requestFocus();
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.Q.requestFocus();
        }
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_hide(View view) {
        this.Y.setVisibility(8);
        this.Z.setVisibility(0);
        this.W.setVisibility(0);
        z0();
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.no_);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new w(textView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new y());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.Y.setVisibility(0);
        this.W.setVisibility(8);
        this.z0.requestFocus();
        z0();
    }

    public void c0(boolean z2) {
        try {
            Log.d("get_all_name=", "Yes" + this.l);
            int i = this.l;
            if (i != 0) {
                a0(this.i.l6(String.valueOf(i)), z2);
            } else {
                a0(this.i.f2(), z2);
            }
        } catch (Exception e) {
            Log.d("Fetch_error=", e.getMessage() + "");
            e.printStackTrace();
        }
    }

    public void d0() {
        Log.d("item_remarks=", "..start...");
        C1044Xj.a().c(new RunnableC1171Zj(16, this.i, this.Q, this.R, this, new RunnableC1086Yj()));
    }

    public void e0(boolean z2) {
        try {
            if (this.l == 0 || z2) {
                this.i.v0("delete from items_temp");
                if (this.i.ja("prefOthers_item_end_date", false)) {
                    this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,(case when qty>=0 then round(qty,7) else 0 end),(case when qty>=0 then round(qty,7) else 0 end),0,0,null,unit_id,1 ,unit_id,(case when qty>=0 then round(qty,7) else 0 end) ,ifnull(e_date,'')  from (select b.id item_id,b.item_type_id,b.unit_id,ifnull(a.e_date,'') e_date,\nsum( case when ( ( substr(a.tr_type,1,1)*1=2 and a.is_back=0)  or (a.tr_type=1 and a.is_back=1) \n   or (a.tr_type=3 and a.i_q<>0) or a.tr_type=0 or (a.tr_type=4 and a.adj_id in(2,4))) \n   then a.i_q else 0 end) - \n     sum( case when ( (substr(a.tr_type,1,1)*1=1 and a.is_back=0)  or (a.tr_type=2 and a.is_back=1) \n   or (a.tr_type=3 and a.o_q<>0) or (a.tr_type=4 and a.adj_id not in(2,4))) then a.o_q else 0 end) qty\nfrom items_cost_calc a,items b\nwhere a.date_<='" + this.H.getText().toString() + "'and a.br_id=(select id from branches c where c.name='" + this.I.getText().toString() + "')and a.item_id=b.id \ngroup by b.id,b.name,b.item_type_id,b.unit_id,ifnull(a.e_date,'') order by b.name ) a");
                } else {
                    this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,(case when qty>=0 then round(qty,7) else 0 end),(case when qty>=0 then round(qty,7) else 0 end),0,0,null,unit_id,1 ,unit_id,(case when qty>=0 then round(qty,7) else 0 end) ,''  from (select b.id item_id,b.item_type_id,b.unit_id,ifnull(a.e_date,'') e_date,\nsum( case when ( ( substr(a.tr_type,1,1)*1=2 and a.is_back=0)  or (a.tr_type=1 and a.is_back=1) \n   or (a.tr_type=3 and a.i_q<>0) or a.tr_type=0 or (a.tr_type=4 and a.adj_id in(2,4))) \n   then a.i_q else 0 end) - \n     sum( case when ( (substr(a.tr_type,1,1)*1=1 and a.is_back=0)  or (a.tr_type=2 and a.is_back=1) \n   or (a.tr_type=3 and a.o_q<>0) or (a.tr_type=4 and a.adj_id not in(2,4))) then a.o_q else 0 end) qty\nfrom items_cost_calc a,items b\nwhere a.date_<='" + this.H.getText().toString() + "'and a.br_id=(select id from branches c where c.name='" + this.I.getText().toString() + "')and a.item_id=b.id \ngroup by b.id,b.name,b.item_type_id,b.unit_id order by b.name ) a");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void f0() {
        String strX4 = this.i.X4("select count(*) as _id from items_temp");
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.inv_items_confirm).replace("{0}", this.I.getText().toString()).replace("{1}", this.H.getText().toString()).replace("{2}", strX4));
        if (strX4.equals("0")) {
            builder.setMessage(getString(info.aalmoghalis.inventory.R.string.inv_items_confirm_1).replace("{0}", this.I.getText().toString()).replace("{1}", this.H.getText().toString()));
        }
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new M());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new N());
        builder.create().show();
    }

    public double g0(int i, String str) {
        this.V = this.i.n7("0", str, this.I.getText().toString(), this.i.ja("prefOthers_item_end_date", false), this.H.getText().toString());
        return Q(this.Q.getText().toString(), this.I.getText().toString()).doubleValue();
    }

    public void h0() {
        try {
            if (getIntent().getStringExtra("TR_ID") != null) {
                this.l = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
                this.i.v0("delete from items_temp");
                this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr ,ifnull(e_date,'')  from bill_transactions2  where bill_id=" + this.l + "");
                this.o0 = getIntent().getIntExtra("back_edit", 0);
            } else {
                this.a0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.i.W1(this.n, this.I.getText().toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void i0() {
        Log.d("back_edit=", this.o0 + "");
        if (this.o0 == 1 && this.L0) {
            Bill_edit.P2 = true;
            Z00.o0 = false;
            finish();
            return;
        }
        if (this.N0) {
            this.N0 = false;
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,ifnull(e_date,'')   from bill_transactions2  where bill_id=" + this.l + "");
            return;
        }
        if (this.n == 7) {
            Intent intent = new Intent(this, (Class<?>) Invs3.class);
            intent.addFlags(67108864);
            intent.putExtra("TR_TYPE", "7");
            intent.putExtra("g_id", this.j);
            intent.putExtra("g_name", this.k);
            startActivity(intent);
            finish();
        }
    }

    public void l0() {
        try {
            if (getIntent().getStringExtra("item_name") != null) {
                String stringExtra = getIntent().getStringExtra("item_name");
                String stringExtra2 = getIntent().getStringExtra("item_qty");
                Bill_edit.R2 = stringExtra;
                int i = 0;
                while (true) {
                    if (i >= this.F.getAdapter().getCount()) {
                        i = -1;
                        break;
                    }
                    C0634Jt c0634Jt = (C0634Jt) this.F.getAdapter().getItem(i);
                    double dB0 = (this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(c0634Jt.h().replaceAll(",", ""), Double.parseDouble(c0634Jt.m())) : Double.parseDouble(c0634Jt.h().replaceAll(",", ""))) * Double.parseDouble(c0634Jt.m());
                    if (c0634Jt.e().equals(stringExtra) && dB0 == Double.parseDouble(stringExtra2.replaceAll(",", ""))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    ListView listView = this.F;
                    listView.performItemClick(listView.getAdapter().getView(i, null, null), i, this.F.getAdapter().getItemId(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m0(String str) {
        this.z0.setText(str);
        this.w = this.z0.getText().toString();
        this.v = "0";
        this.z = "";
        this.B = "1";
        this.A = "";
        this.V = this.i.n7("0", "0", this.I.getText().toString(), this.i.ja("prefOthers_item_end_date", false), this.H.getText().toString());
        double dDoubleValue = Q(this.z0.getText().toString(), this.I.getText().toString()).doubleValue();
        if (dDoubleValue >= 0.0d) {
            this.x = "" + dDoubleValue;
        }
        this.z = this.i.X6(this.z0.getText().toString());
        this.B = String.valueOf(this.i.Z6(this.z0.getText().toString(), this.z));
        Q0 = 1;
        B0();
    }

    public void more_item(View view) {
        this.i.te(this, this.Q.getText().toString(), this.k, this.i.l3("0"), Q(this.Q.getText().toString(), this.k).doubleValue(), false, 0L, this.n, this.S.getText().toString());
    }

    public void n0(String str) {
        this.Q.setText(str);
        this.P.requestFocus();
        double dG0 = g0(this.l, this.v);
        if (this.i.ja("prefOthers_qty_pr", false)) {
            dG0 = this.i.b0(dG0 + "", 1.0d);
        }
        this.P.setHint(String.valueOf(dG0));
        this.S.setText(this.i.X6(this.Q.getText().toString()));
        if (this.i.W6(this.Q.getText().toString()) > 1) {
            this.S.setVisibility(0);
        } else {
            this.S.setVisibility(8);
        }
        if (this.i.ja("prefOthers_item_end_date", false)) {
            this.y0.setVisibility(0);
            ArrayList arrayListR = R(this.Q.getText().toString(), this.I.getText().toString());
            if (arrayListR.size() == 0) {
                this.y0.setVisibility(8);
            } else {
                for (int i = 0; i < arrayListR.size(); i++) {
                    if (Double.parseDouble((String) ((HashMap) arrayListR.get(i)).get("item_qty")) > 0.0d) {
                        this.y0.setText((CharSequence) ((HashMap) arrayListR.get(i)).get("item_date"));
                        this.P.setHint((CharSequence) ((HashMap) arrayListR.get(i)).get("item_qty"));
                        break;
                    }
                }
            }
        }
        this.P.setTag("1");
        this.P.selectAll();
        d0();
    }

    public void o0() {
        this.N0 = true;
        O(2, this.n);
        this.P0 = 2;
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
                        this.i.j1(activityResult.getContents(), this, this.U);
                    }
                    if (!strI6.equals("") || Z00.P0) {
                        if (Z00.P0) {
                            strI6 = this.i.I6(activityResult.getContents());
                        }
                        int i3 = this.A0;
                        if (i3 == 1) {
                            m0(strI6);
                        } else if (i3 == 2) {
                            n0(strI6);
                        }
                        this.A0 = 0;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.d("barcode_log_error=", "results=" + e2.getMessage());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "edit")) {
                this.P0 = 0;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "new")) {
            this.P0 = 0;
        }
        int i = this.P0;
        if (i == 1) {
            this.O0 = 1;
            V();
        } else if (i == 2) {
            u0();
        } else if (this.l != 0) {
            u0();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_bill_inv);
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        z00.v0("delete from items_temp");
        if (this.l != 0) {
            setContentView(info.aalmoghalis.inventory.R.layout.content_inv_det);
        }
        this.F = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        this.H = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_date);
        this.I = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name);
        this.J = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot);
        this.K = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr);
        this.M = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_add);
        this.N = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode);
        if (this.i.ja("prefOthers_barcode", false)) {
            this.N.setVisibility(0);
        }
        this.a0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_no);
        this.b0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
        h0();
        this.X = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.root_layout);
        this.Y = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.item_add_hdr);
        this.Z = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_items_list_hdr);
        this.W = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.page_add);
        if (this.l != 0) {
            this.Z.setVisibility(0);
        }
        this.F.setOnItemClickListener(new C2642b());
        this.F.setChoiceMode(3);
        this.F.setMultiChoiceModeListener(new C2643c());
        Calendar calendar = Calendar.getInstance();
        this.H.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.C = calendar.get(1);
        this.D = calendar.get(2);
        this.E = calendar.get(5);
        this.H.setOnClickListener(new x());
        v0();
        this.I.setOnItemClickListener(new C());
        this.I.setOnTouchListener(new J());
        this.I.addTextChangedListener(new S());
        y0(true);
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.n = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                if (this.l == 0) {
                    if (C2160f10.h != -1) {
                        this.k = this.i.C2(C2160f10.i + "");
                    }
                    this.I.setText(this.k);
                    v0();
                    this.I.dismissDropDown();
                }
                setTitle(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.n - 3]);
                this.k0 = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.n - 3];
                this.i.v0("delete from items_temp");
            }
        } catch (Exception unused) {
        }
        if (getIntent().getStringExtra("TR_ID") != null && C2160f10.h > 0 && !new C2160f10(this.i).l("28", "edit")) {
            this.I.setEnabled(false);
            this.H.setEnabled(false);
            this.b0.setEnabled(false);
            this.a0.setEnabled(false);
        }
        if (C2160f10.h > 0) {
            this.I.setEnabled(false);
        }
        if (this.l != 0) {
            this.I.requestFocus();
        }
        if (this.l == 0) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        h0();
        if (this.l == 0) {
            f0();
        }
        c0(true);
        W();
        this.V = this.i.n7("0", "0", this.I.getText().toString(), this.i.ja("prefOthers_item_end_date", false), this.H.getText().toString());
        l0();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(k0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.H0, this.C, this.D, this.E);
        }
        if (i == 4) {
            return new DatePickerDialog(k0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.I0, this.C, this.D, this.E);
        }
        if (i != 5) {
            return null;
        }
        return new DatePickerDialog(k0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.J0, this.C, this.D, this.E);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_bill3_inv, menu);
        menu.findItem(info.aalmoghalis.inventory.R.id.bill_prin).setVisible(this.l != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.share).setVisible(this.l != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.search).setVisible(this.l != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(this.l != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.items_del).setVisible(!this.i.X4("select count(*) as _id from items_temp").equals("0"));
        int i = C2160f10.h;
        if (i > 0 && this.l != 0) {
            MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
            MenuItem menuItemFindItem2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
            boolean zL = new C2160f10(this.i).l("28", "edit");
            boolean zL2 = new C2160f10(this.i).l("28", HTML.Tag.DEL);
            menuItemFindItem.setVisible(zL);
            menuItemFindItem2.setVisible(zL2);
        } else if (i > 0 && this.l == 0) {
            MenuItem menuItemFindItem3 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
            boolean zL3 = new C2160f10(this.i).l("28", HTML.Tag.DEL);
            menuItemFindItem3.setVisible(zL3);
            menu.findItem(info.aalmoghalis.inventory.R.id.items_del).setVisible(zL3);
        }
        if (this.l != 0) {
            menu.findItem(info.aalmoghalis.inventory.R.id.items_inv).setVisible(true);
            menu.findItem(info.aalmoghalis.inventory.R.id.items_inv).setTitle(getString(info.aalmoghalis.inventory.R.string.inv_items) + "(" + this.H.getText().toString() + ")");
        } else {
            menu.findItem(info.aalmoghalis.inventory.R.id.items_inv).setVisible(false);
        }
        this.G0 = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        this.G0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.G0.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.G0.setOnQueryTextListener(new E());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a0(this.i.L2(), false);
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
        if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_save) {
            O(1, this.n);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_submit) {
            this.L0 = true;
            O(2, this.n);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_remove) {
            N();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.items_inv) {
            f0();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.items_del) {
            Y();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.share) {
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin) {
                this.M0 = 1;
            } else {
                this.M0 = 2;
            }
            if (this.l == 0) {
                V();
                return true;
            }
            q0(this.M0);
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

    public void p0(String str) {
        try {
            C1072Xv c1072Xv = this.c0;
            if (c1072Xv != null) {
                c1072Xv.getFilter().filter(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void q0(int i) {
        if (i == 0) {
            return;
        }
        this.i.zb(this.F, this.k0, this.l + "", this.H.getText().toString(), this.I.getHint().toString(), this.I.getText().toString(), this.a0.getText().toString(), this.i.ja("prefOthers_print_end_date", false));
        if (i == 1) {
            this.i.ra(this.k0 + ".pdf");
            return;
        }
        if (i == 2) {
            this.i.qd(this.k0 + ".pdf");
        }
    }

    public void r0() {
        if (this.l == 0) {
            this.a0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.i.W1(this.n, this.I.getText().toString()));
        }
    }

    public void s0() {
        this.a0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.i.W1(this.n, this.I.getText().toString()));
    }

    public void sort_name_click(View view) {
        if (this.m0 == 0) {
            A0(this.d0);
            this.c0.notifyDataSetChanged();
            this.m0 = 1;
        } else {
            x0(this.d0);
            this.c0.notifyDataSetChanged();
            this.m0 = 0;
        }
    }

    public void t0(String str) {
        AutoCompleteTextView autoCompleteTextView;
        if (!str.equals("") && this.i.da(str)) {
            String strI6 = this.i.I6(str);
            Z00.P0 = false;
            if (strI6.equals("")) {
                this.i.j1(str, this, this.U);
            }
            if (!strI6.equals("") || Z00.P0) {
                if (Z00.P0) {
                    strI6 = this.i.I6(str);
                }
                if (this.A0 == 2 || ((autoCompleteTextView = this.Q) != null && autoCompleteTextView.hasWindowFocus())) {
                    n0(strI6);
                } else {
                    m0(strI6);
                }
                this.A0 = 0;
            }
        }
    }

    public void u0() {
        Log.d("back_edit=", this.o0 + "");
        if (this.o0 == 1) {
            Bill_edit.P2 = true;
            Bill_edit.R2 = this.I.getText().toString();
            finish();
        } else if (this.n == 7) {
            Intent intent = new Intent(this, (Class<?>) Invs3.class);
            intent.addFlags(67108864);
            intent.putExtra("TR_TYPE", "7");
            intent.putExtra("g_id", this.j);
            intent.putExtra("g_name", this.k);
            startActivity(intent);
            finish();
        }
    }

    public void update_bill_total(View view) {
    }

    public void v0() {
        this.I.setThreshold(1);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.z2(this.I.getText().toString(), ""));
        this.f0 = arrayAdapter;
        this.I.setAdapter(arrayAdapter);
    }

    public void w0() {
        this.Q.setText((CharSequence) null);
        this.P.setText((CharSequence) null);
        this.R.setText((CharSequence) null);
        this.Q.requestFocus();
        this.v = "0";
    }

    public void y0(boolean z2) {
    }
}
