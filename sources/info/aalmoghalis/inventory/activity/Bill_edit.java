package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.timepicker.TimeModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC4371yX;
import defpackage.C0634Jt;
import defpackage.C0809Ov;
import defpackage.C0974Ur;
import defpackage.C1044Xj;
import defpackage.C1098Yv;
import defpackage.C1839c10;
import defpackage.C2018dE;
import defpackage.C2056di;
import defpackage.C2160f10;
import defpackage.C3874sM;
import defpackage.C3966tX;
import defpackage.C4062ug;
import defpackage.C4064uh;
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.E00;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.MO;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.W7;
import defpackage.Z00;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.helper.Calculator;
import info.aalmoghalis.inventory.printBT.MainActivity;
import info.aalmoghalis.inventory.printBT.MainActivity2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Bill_edit extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int O2 = 0;
    public static boolean P2 = false;
    public static boolean Q2 = false;
    public static String R2 = "";
    public C0809Ov B0;
    public C1098Yv C0;
    public EditText E2;
    public SparseBooleanArray F0;
    public List F2;
    public ArrayAdapter G0;
    public C4062ug G2;
    public ArrayAdapter H0;
    public ArrayAdapter I0;
    public ArrayAdapter J0;
    public int N;
    public int O;
    public TextView O1;
    public int P;
    public TextView P1;
    public AlertDialog Q1;
    public boolean b2;
    public TextView c2;
    public TextView d2;
    public TextView e0;
    public TextView e2;
    public TextView f0;
    public SwitchCompat f2;
    public TextView g0;
    public SQLiteDatabase h;
    public TextView h0;
    public boolean h2;
    public Z00 i;
    public TextView i0;
    public boolean i2;
    public E00 j;
    public ArrayAdapter j0;
    public String k;
    public String l;
    public SearchView m2;
    public String n;
    public String u2;
    public LinearLayout v0;
    public LinearLayout w0;
    public LinearLayout x0;
    public Uri z2;
    public long p = 0;
    public String q = "";
    public int t = 0;
    public int u = 2;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    public String y = null;
    public String z = "0";
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public String E = null;
    public String F = null;
    public String G = "1";
    public String H = null;
    public String I = null;
    public String J = "0";
    public int K = 0;
    public int L = 0;
    public boolean M = false;
    public ListView Q = null;
    public Toolbar R = null;
    public SwitchCompat S = null;
    public CheckBox T = null;
    public TextView U = null;
    public ImageView V = null;
    public TextView W = null;
    public TextView X = null;
    public AutoCompleteTextView Y = null;
    public TextView Z = null;
    public TextView a0 = null;
    public TextView b0 = null;
    public TextView c0 = null;
    public TextView d0 = null;
    public LinearLayout k0 = null;
    public TextView l0 = null;
    public ImageView m0 = null;
    public ImageView n0 = null;
    public ImageView o0 = null;
    public ImageView p0 = null;
    public TextView q0 = null;
    public TextView r0 = null;
    public ArrayList s0 = new ArrayList();
    public ArrayList t0 = new ArrayList();
    public ImageView u0 = null;
    public TextView y0 = null;
    public EditText z0 = null;
    public EditText A0 = null;
    public List D0 = new ArrayList();
    public List E0 = new ArrayList();
    public ImageButton K0 = null;
    public int L0 = 0;
    public String[] M0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] N0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String O0 = "";
    public LinearLayout P0 = null;
    public LinearLayout Q0 = null;
    public LinearLayout R0 = null;
    public ImageView S0 = null;
    public LinearLayout T0 = null;
    public TextView U0 = null;
    public TextView V0 = null;
    public TextView W0 = null;
    public View.OnClickListener X0 = new Y();
    public ArrayList Y0 = new ArrayList();
    public boolean Z0 = false;
    public TextWatcher a1 = new C2602l0();
    public boolean b1 = false;
    public TextWatcher c1 = new C2605m0();
    public TextWatcher d1 = new C2608n0();
    public int e1 = 0;
    public long f1 = 0;
    public long g1 = 0;
    public Integer h1 = null;
    public Integer i1 = null;
    public String j1 = null;
    public String k1 = null;
    public String l1 = "";
    public int m1 = 0;
    public String n1 = "";
    public String o1 = "";
    public final Context p1 = this;
    public int q1 = 0;
    public int r1 = 0;
    public String s1 = "";
    public String t1 = "";
    public EditText u1 = null;
    public EditText v1 = null;
    public TextView w1 = null;
    public AutoCompleteTextView x1 = null;
    public EditText y1 = null;
    public EditText z1 = null;
    public AutoCompleteTextView A1 = null;
    public EditText B1 = null;
    public TextView C1 = null;
    public AutoCompleteTextView D1 = null;
    public EditText E1 = null;
    public EditText F1 = null;
    public EditText G1 = null;
    public TextView H1 = null;
    public AutoCompleteTextView I1 = null;
    public int J1 = 0;
    public TextView K1 = null;
    public TextView L1 = null;
    public ImageView M1 = null;
    public boolean N1 = false;
    public double R1 = 0.0d;
    public double S1 = 0.0d;
    public int T1 = 0;
    public double U1 = 0.0d;
    public double V1 = 0.0d;
    public double W1 = 0.0d;
    public double X1 = 0.0d;
    public double Y1 = 0.0d;
    public double Z1 = 0.0d;
    public int a2 = 0;
    public int g2 = 1;
    public String j2 = "";
    public String k2 = "0";
    public MenuItem l2 = null;
    public DatePickerDialog.OnDateSetListener n2 = new D();
    public DatePickerDialog.OnDateSetListener o2 = new E();
    public DatePickerDialog.OnDateSetListener p2 = new F();
    public View.OnClickListener q2 = new I();
    public boolean r2 = false;
    public boolean s2 = false;
    public boolean t2 = false;
    public int v2 = 3;
    public int w2 = 4;
    public ActivityResultLauncher x2 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: F7
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.v1((Uri) obj);
        }
    });
    public ActivityResultLauncher y2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new Q());
    public String A2 = null;
    public String B2 = null;
    public String C2 = null;
    public String D2 = null;
    public int H2 = 0;
    public boolean I2 = false;
    public int[] J2 = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public int K2 = 0;
    public int L2 = 0;
    public int M2 = 0;
    public int N2 = 0;

    public class A implements View.OnClickListener {
        public A() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = Bill_edit.this.k1;
            if (str != null) {
                String strC = info.aalmoghalis.inventory.zatca.d.C(str);
                if (strC.length() > 0) {
                    new C3966tX().E(Bill_edit.this, "Zatca", "" + strC);
                }
            }
        }
    }

    public class A0 implements CompoundButton.OnCheckedChangeListener {
        public A0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (Bill_edit.this.f2.isChecked()) {
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.e2.setText(bill_edit.getString(info.aalmoghalis.inventory.R.string.bill_cash));
            } else {
                Bill_edit bill_edit2 = Bill_edit.this;
                bill_edit2.e2.setText(bill_edit2.getString(info.aalmoghalis.inventory.R.string.bill_post));
            }
            Log.d("item_status_p=", Bill_edit.this.e2.getText().toString() + "#" + Bill_edit.this.f2.isChecked());
        }
    }

    public class A1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public A1(Handler handler, String str, int i) {
            this.a = handler;
            this.b = str;
            this.c = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.n0(this.a, this.b, this.c);
        }
    }

    public class B implements Filter.FilterListener {
        public B() {
        }

        @Override // android.widget.Filter.FilterListener
        public void onFilterComplete(int i) {
            if (i == 0) {
                Bill_edit.this.m2.setQuery("", false);
            }
        }
    }

    public class B0 implements View.OnClickListener {
        public B0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_edit.this.E1.getText().toString().length() != 0) {
                Bill_edit.this.E1.setText("");
            } else {
                EditText editText = Bill_edit.this.E1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class B1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public B1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.b2 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class C implements SearchView.OnQueryTextListener {
        public C() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Bill_edit.this.C1(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class C0 implements View.OnClickListener {
        public C0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_edit.this.F1.getText().toString().length() != 0) {
                Bill_edit.this.F1.setText("");
            } else {
                EditText editText = Bill_edit.this.F1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class C1 extends Handler {
        public C1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class D implements DatePickerDialog.OnDateSetListener {
        public D() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_edit.this.N = i;
            Bill_edit.this.O = i2;
            Bill_edit.this.P = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_edit.this.N)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_edit.this.O + 1)) + "-" + Bill_edit.this.P;
                Locale locale = Locale.ENGLISH;
                Bill_edit.this.U.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.q2(bill_edit.p, "0");
            } catch (Exception unused) {
            }
        }
    }

    public class D0 implements View.OnClickListener {
        public D0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.showDialog(4);
        }
    }

    public class D1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public D1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.o0(this.a);
        }
    }

    public class E implements DatePickerDialog.OnDateSetListener {
        public E() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_edit.this.N = i;
            Bill_edit.this.O = i2;
            Bill_edit.this.P = i3;
            try {
                String str = Bill_edit.this.N + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_edit.this.O + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_edit.this.P));
                Locale locale = Locale.ENGLISH;
                Bill_edit.this.X.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class E0 implements View.OnTouchListener {
        public E0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.G1.getCompoundDrawables()[0] != null ? Bill_edit.this.G1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.G1.getPaddingLeft() + Bill_edit.this.G1.getLeft()) {
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.i.B(bill_edit.G1, bill_edit.N1);
                }
            }
            return false;
        }
    }

    public class E1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public E1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.b2 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class F implements DatePickerDialog.OnDateSetListener {
        public F() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            try {
                String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", locale);
                Date date = simpleDateFormat.parse(str);
                TextView textView = Bill_edit.this.C1;
                if (textView != null) {
                    textView.setText(simpleDateFormat2.format(Long.valueOf(date.getTime())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class F0 implements View.OnClickListener {
        public F0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.F0(bill_edit.I0, Bill_edit.this.W);
        }
    }

    public class F1 extends Handler {
        public F1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class G implements View.OnClickListener {
        public G() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.Z0 = true;
        }
    }

    public class G0 implements View.OnTouchListener {
        public G0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.E1.getCompoundDrawables()[0] != null ? Bill_edit.this.E1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.E1.getPaddingLeft() + Bill_edit.this.E1.getLeft()) {
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.i.B(bill_edit.E1, bill_edit.N1);
                }
            }
            return false;
        }
    }

    public class G1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Handler d;

        public G1(String str, String str2, String str3, Handler handler) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.p0(this.a, this.b, this.c, this.d);
        }
    }

    public class H implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public H(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.N2 = 1;
            bill_edit.t0(view, this.a);
        }
    }

    public class H0 implements View.OnTouchListener {
        public H0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.F1.getCompoundDrawables()[0] != null ? Bill_edit.this.F1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.F1.getPaddingLeft() + Bill_edit.this.F1.getLeft()) {
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.i.B(bill_edit.F1, bill_edit.N1);
                }
            }
            return false;
        }
    }

    public class H1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public H1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (!Bill_edit.this.i.ja("prefOthers_sales_out_qty", false)) {
                Bill_edit bill_edit = Bill_edit.this;
                Toast.makeText(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.out_stock_balance), 0).show();
            }
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class I implements View.OnClickListener {
        public I() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == Bill_edit.this.B1.getId() || view.getId() == Bill_edit.this.y1.getId()) {
                return;
            }
            view.getId();
            Bill_edit.this.z1.getId();
        }
    }

    public class I0 implements View.OnClickListener {
        public I0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d("click=", "item_date:" + Bill_edit.O2);
            try {
                C2056di c2056di = new C2056di();
                Bundle bundle = new Bundle();
                String string = Bill_edit.this.C1.getText().toString();
                if (string.length() == 0) {
                    Bill_edit bill_edit = Bill_edit.this;
                    string = bill_edit.i.D5(bill_edit.D1.getText().toString());
                }
                ArrayList arrayListT = new C1839c10().t(string);
                if (arrayListT.size() > 2) {
                    bundle.putInt("year", ((Integer) arrayListT.get(0)).intValue());
                    bundle.putInt("month", ((Integer) arrayListT.get(1)).intValue());
                    bundle.putInt("day", ((Integer) arrayListT.get(2)).intValue());
                } else {
                    bundle.putInt("year", Bill_edit.this.N);
                    bundle.putInt("month", Bill_edit.this.O);
                    bundle.putInt("day", Bill_edit.this.P);
                }
                c2056di.setArguments(bundle);
                Bill_edit.this.C1.setText("");
                c2056di.f(Bill_edit.this.p2);
                c2056di.show(Bill_edit.this.getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    public class I1 implements View.OnClickListener {
        public I1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.showDialog(0);
            Bill_edit.this.N2 = 1;
        }
    }

    public class J implements DialogInterface.OnClickListener {
        public J() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_edit.this.z1();
            } catch (Exception unused) {
                Toast.makeText(Bill_edit.this.getApplicationContext(), Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class J0 implements View.OnClickListener {
        public J0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int[] iArr = {android.R.id.text1};
            Bill_edit bill_edit = Bill_edit.this;
            Bill_edit.this.G0(new SimpleAdapter(bill_edit, bill_edit.B0(bill_edit.D1.getText().toString(), Bill_edit.this.n), android.R.layout.simple_list_item_2, new String[]{"item_date_qty"}, iArr));
        }
    }

    public class J1 implements AdapterView.OnItemClickListener {
        public J1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_edit.this.I1.setText(adapterView.getItemAtPosition(i).toString());
            Bill_edit.this.E1.requestFocus();
        }
    }

    public class K implements DialogInterface.OnClickListener {
        public K() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.M = false;
            bill_edit.T.setChecked(true);
            Bill_edit.this.r2();
            Bill_edit bill_edit2 = Bill_edit.this;
            bill_edit2.q2(bill_edit2.p, "0");
            Bill_edit.this.N2 = 1;
            dialogInterface.dismiss();
        }
    }

    public class K0 implements View.OnClickListener {
        public K0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr = {HTML.Attribute.ID, "name"};
            int[] iArr = {android.R.id.text1, android.R.id.text2};
            Bill_edit bill_edit = Bill_edit.this;
            Bill_edit.this.H0(new SimpleAdapter(bill_edit, bill_edit.i.b9(bill_edit.D1.getText().toString()), android.R.layout.simple_list_item_2, strArr, iArr));
        }
    }

    public class K1 implements View.OnTouchListener {
        public K1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_edit.this.I1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.I1.getCompoundDrawables()[0] != null ? Bill_edit.this.I1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.I1.getPaddingLeft() + Bill_edit.this.I1.getLeft()) {
                    Bill_edit.this.I1.setText("");
                    Bill_edit.this.I1.requestFocus();
                }
            }
            return false;
        }
    }

    public class L implements DialogInterface.OnClickListener {
        public L() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_edit.this.G1();
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.w0(2, bill_edit.t);
            } catch (Exception unused) {
                Toast.makeText(Bill_edit.this.getApplicationContext(), Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class L0 implements AdapterView.OnItemClickListener {
        public L0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_edit.this.u1(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    public class L1 implements TextWatcher {
        public L1() {
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
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.I1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_edit, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_edit.this.I1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_edit.this.I1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class M implements DialogInterface.OnClickListener {
        public M() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit bill_edit = Bill_edit.this;
            if (bill_edit.M2 == 1) {
                bill_edit.finish();
            } else {
                bill_edit.N2 = 0;
                bill_edit.Z0();
            }
        }
    }

    public class M0 implements View.OnTouchListener {
        public M0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_edit.this.D1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.D1.getCompoundDrawables()[0] != null ? Bill_edit.this.D1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.D1.getPaddingLeft() + Bill_edit.this.D1.getLeft()) {
                    Bill_edit.this.D1.setText("");
                    Bill_edit.this.L1.setVisibility(8);
                    Bill_edit.this.L1.setText("");
                    Bill_edit.this.B1.setText("");
                    Bill_edit.this.y1.setText("");
                    Bill_edit.this.C1.setText("");
                    Bill_edit.this.D1.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_edit.this.D1.getRight();
                Bill_edit.this.D1.getPaddingRight();
                if (Bill_edit.this.D1.getCompoundDrawables()[2] != null) {
                    Bill_edit.this.D1.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class M1 implements DialogInterface.OnClickListener {
        public M1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class N implements View.OnClickListener {
        public N() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.Z0 = true;
        }
    }

    public class N0 implements TextWatcher {
        public N0() {
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
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.D1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_edit, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_edit.this.x1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_edit.this.D1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class N1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public N1(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
        }
    }

    public class O implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public O(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Bill_edit.this);
                if (this.a[i].equals(Bill_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.u2 = bill_edit.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Bill_edit.this.y0();
                    }
                } else if (this.a[i].equals(Bill_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Bill_edit bill_edit2 = Bill_edit.this;
                    bill_edit2.u2 = bill_edit2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Bill_edit.this.R0();
                    }
                } else if (this.a[i].equals(Bill_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Bill_edit.this.i.qa(Z00.M + Bill_edit.this.S0.getTag().toString());
                } else if (this.a[i].equals(Bill_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Bill_edit.this.S0.setTag(null);
                    Bill_edit.this.S0.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class O0 implements DialogInterface.OnClickListener {
        public O0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class O1 implements View.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ AlertDialog b;

        public O1(Handler handler, AlertDialog alertDialog) {
            this.a = handler;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (Bill_edit.this.I1()) {
                    Bill_edit.this.b2 = true;
                    Handler handler = this.a;
                    handler.sendMessage(handler.obtainMessage());
                    this.b.dismiss();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_edit.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class P implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public P(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Bill_edit.this);
                if (this.a[i].equals(Bill_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.u2 = bill_edit.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Bill_edit.this.y0();
                    }
                } else if (this.a[i].equals(Bill_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Bill_edit bill_edit2 = Bill_edit.this;
                    bill_edit2.u2 = bill_edit2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Bill_edit.this.R0();
                    }
                } else if (this.a[i].equals(Bill_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Bill_edit.this.i.qa(Z00.M + Bill_edit.this.S0.getTag().toString());
                } else if (this.a[i].equals(Bill_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Bill_edit.this.S0.setTag(null);
                    Bill_edit.this.S0.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Bill_edit.this.S0.getLayoutParams().width = (int) Bill_edit.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Bill_edit.this.S0.getLayoutParams().height = (int) Bill_edit.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class P0 implements DialogInterface.OnClickListener {
        public P0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class P1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public P1(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    public class Q implements ActivityResultCallback {
        public Q() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Bill_edit.this.f2();
            }
        }
    }

    public class Q0 implements View.OnClickListener {
        public Q0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.N2 = 1;
            Bill_edit bill_edit2 = Bill_edit.this;
            bill_edit.J0 = new ArrayAdapter(bill_edit2, android.R.layout.simple_spinner_dropdown_item, bill_edit2.i.D3());
            Bill_edit bill_edit3 = Bill_edit.this;
            bill_edit3.i.Md(bill_edit3);
            Bill_edit bill_edit4 = Bill_edit.this;
            bill_edit4.F0(bill_edit4.J0, Bill_edit.this.r0);
        }
    }

    public class Q1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ArrayAdapter b;
        public final /* synthetic */ Dialog c;

        public Q1(TextView textView, ArrayAdapter arrayAdapter, Dialog dialog) {
            this.a = textView;
            this.b = arrayAdapter;
            this.c = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getId() == Bill_edit.this.W.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.q1 = 1;
                bill_edit.N2 = 1;
                bill_edit.K1();
                Bill_edit.this.M0();
                Bill_edit bill_edit2 = Bill_edit.this;
                bill_edit2.q2(bill_edit2.p, "0");
            } else if (this.a.getId() == Bill_edit.this.r0.getId()) {
                if (i == this.b.getCount() - 1) {
                    Bill_edit bill_edit3 = Bill_edit.this;
                    bill_edit3.j2("0", "", "", bill_edit3.i.T5("0"), "", Bill_edit.this.i.v1("121"));
                } else {
                    this.a.setText(adapterView.getItemAtPosition(i).toString());
                }
            } else if (this.a.getId() == Bill_edit.this.q0.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Bill_edit.this.Z0();
            } else if (this.a.getId() == Bill_edit.this.e0.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Bill_edit.this.V1();
                String strY0 = Bill_edit.this.i.y0("update bills set t_val='" + Bill_edit.this.e0.getText().toString().replaceAll(",", "") + "',tax_amount='" + Bill_edit.this.f0.getText().toString().replaceAll(",", "") + "',amount='" + Bill_edit.this.h0.getText().toString().replaceAll(",", "") + "' where id='" + Bill_edit.this.p + "' and date_='" + Bill_edit.this.q + "'");
                if (strY0 == null || !strY0.equals("1")) {
                    Bill_edit bill_edit4 = Bill_edit.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error:");
                    if (strY0 != null && strY0.length() > 20) {
                        strY0 = strY0.substring(0, 20);
                    }
                    sb.append(strY0);
                    Toast.makeText(bill_edit4, sb.toString(), 0).show();
                    Bill_edit.this.Q1();
                    Bill_edit.this.Z0();
                }
            }
            this.c.dismiss();
        }
    }

    public class R extends Handler {
        public R() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class R0 implements DialogInterface.OnClickListener {
        public R0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class R1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public R1(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String str = (String) ((HashMap) adapterView.getItemAtPosition(i)).get(HTML.Attribute.ID);
            if (!Bill_edit.this.L1.getText().toString().equals(str)) {
                Bill_edit.this.L1.setText(str);
                Bill_edit bill_edit = Bill_edit.this;
                double dZ6 = bill_edit.i.Z6(bill_edit.D1.getText().toString(), Bill_edit.this.L1.getText().toString());
                Bill_edit.this.G = String.valueOf(dZ6);
                Bill_edit bill_edit2 = Bill_edit.this;
                bill_edit2.y1.setTag(bill_edit2.G);
                Bill_edit bill_edit3 = Bill_edit.this;
                double dJ6 = bill_edit3.i.J6(bill_edit3.D1.getText().toString(), Bill_edit.this.q0.getText().toString(), Bill_edit.this.t, Bill_edit.this.T.isChecked(), Bill_edit.this.f1 + "", Bill_edit.this.t, Bill_edit.this.L1.getText().toString());
                if (Bill_edit.this.t != 1 || Bill_edit.this.T.isChecked()) {
                    Bill_edit bill_edit4 = Bill_edit.this;
                    bill_edit4.y1.setHint(dJ6 <= 0.0d ? "" : bill_edit4.i.S7(String.valueOf(dJ6 * dZ6)));
                } else {
                    Bill_edit bill_edit5 = Bill_edit.this;
                    bill_edit5.y1.setHint(dJ6 <= 0.0d ? "" : bill_edit5.i.S7(String.valueOf(dJ6)));
                }
                if (Bill_edit.this.y1.getText().toString().length() > 0) {
                    EditText editText = Bill_edit.this.y1;
                    editText.setText(editText.getHint());
                    Bill_edit.this.y1.selectAll();
                }
                if (Bill_edit.this.i.ja("prefOthers_item_price", false)) {
                    EditText editText2 = Bill_edit.this.y1;
                    editText2.setText(editText2.getHint());
                }
                Bill_edit bill_edit6 = Bill_edit.this;
                double dF1 = bill_edit6.f1(bill_edit6.p, Bill_edit.this.J);
                if (Bill_edit.this.i.ja("prefOthers_qty_pr", false)) {
                    Bill_edit bill_edit7 = Bill_edit.this;
                    bill_edit7.B1.setHint(String.valueOf(bill_edit7.i.c0("" + (dF1 / dZ6), dZ6)));
                } else {
                    Bill_edit.this.B1.setHint(String.valueOf(C1839c10.C(dF1 / dZ6, C1839c10.d)));
                }
            }
            this.a.dismiss();
            Bill_edit bill_edit8 = Bill_edit.this;
            bill_edit8.i.Md(bill_edit8);
        }
    }

    public class S implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public S(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.i.v0("insert into groups  (name )  values( '" + Bill_edit.this.j2 + "'  )");
            Bill_edit.this.h2 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class S0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public S0(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
            Bill_edit.this.d2();
        }
    }

    public class S1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public S1(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            HashMap map = (HashMap) adapterView.getItemAtPosition(i);
            String str = (String) map.get("item_date");
            if (Bill_edit.this.C1 != null) {
                double d = Double.parseDouble((String) map.get("item_qty"));
                if (d >= 0.0d) {
                    Bill_edit.this.C1.setText(str);
                    Bill_edit.this.B1.setHint(String.valueOf(d));
                    if (Bill_edit.this.B1.getText().toString().length() > 0 && Double.parseDouble(Bill_edit.this.B1.getText().toString().replaceAll(",", "")) > d) {
                        Bill_edit bill_edit = Bill_edit.this;
                        bill_edit.B1.setText(bill_edit.i.S7(String.valueOf(d)));
                    }
                }
            }
            this.a.dismiss();
            Bill_edit bill_edit2 = Bill_edit.this;
            bill_edit2.i.Md(bill_edit2);
        }
    }

    public class T implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public T(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.h2 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class T0 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public T0(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Button button = (Button) view;
                if (button.getText() == null || !button.getText().toString().equals(Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.add_transaction))) {
                    Log.d("edit_item_S=", FragmentStatePagerSupport_Main.X());
                    if (Bill_edit.this.P0()) {
                        Log.d("edit_item_E=", FragmentStatePagerSupport_Main.X());
                        this.a.dismiss();
                        Bill_edit.this.d2();
                    }
                } else if (Bill_edit.this.P0()) {
                    Bill_edit.this.R1();
                } else if (Bill_edit.this.D1.getText().toString().length() == 0 && Bill_edit.this.B1.getText().toString().length() == 0 && Bill_edit.this.y1.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_edit.this.d2();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_edit.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class T1 implements AdapterView.OnItemClickListener {
        public T1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_edit.this.Y.setText(adapterView.getItemAtPosition(i).toString());
            if (Bill_edit.this.p == 0) {
                Bill_edit.this.x1.requestFocus();
            } else {
                Bill_edit.this.z0.requestFocus();
            }
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.N2 = 1;
            bill_edit.c2(0);
        }
    }

    public class U implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public U(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class U0 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public U0(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (Bill_edit.this.P0()) {
                    this.a.dismiss();
                    Bill_edit.this.d2();
                } else if (Bill_edit.this.D1.getText().toString().length() == 0 && Bill_edit.this.B1.getText().toString().length() == 0 && Bill_edit.this.y1.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_edit.this.d2();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_edit.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class U1 implements CompoundButton.OnCheckedChangeListener {
        public U1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton == Bill_edit.this.T) {
                Bill_edit.this.J1();
                if (z) {
                    Bill_edit bill_edit = Bill_edit.this;
                    if (bill_edit.g1 != -1 && bill_edit.M) {
                        bill_edit.J0();
                        return;
                    }
                }
                Bill_edit bill_edit2 = Bill_edit.this;
                bill_edit2.N2 = 1;
                bill_edit2.r2();
                Bill_edit.this.L1();
            }
        }
    }

    public class V implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public V(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class V0 implements DialogInterface.OnClickListener {
        public V0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class W implements View.OnClickListener {
        public W() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.phone_pick_btn(view);
        }
    }

    public class W0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public W0(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_edit.this.add_item(this.a);
            } catch (Exception unused) {
            }
        }
    }

    public class X implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public X(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.E0(this.a, this.b);
        }
    }

    public class X0 implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ AlertDialog c;

        public X0(AutoCompleteTextView autoCompleteTextView, View view, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = view;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bill_edit.this.i.v0("insert into items  (name  ,o_qty  ,item_type_id,o_date_)  values( '" + ((Object) this.a.getText()) + "' ,'0','" + Bill_edit.this.r1 + "', strftime('%Y-%m-%d','now') )");
                Bill_edit.this.add_item(this.b);
            } catch (Exception unused) {
            }
            this.c.dismiss();
        }
    }

    public class Y implements View.OnClickListener {
        public Y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_u_currency) {
                Bill_edit.this.u_currency_btn(view);
            }
        }
    }

    public class Y0 implements DialogInterface.OnClickListener {
        public Y0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Z implements DialogInterface.OnClickListener {
        public Z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Z0 implements DialogInterface.OnClickListener {
        public Z0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$a, reason: case insensitive filesystem */
    public class C2568a implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2568a(AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            if (adapterView.getItemAtPosition(i).toString().length() > 0) {
                this.b.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$a0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2569a0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2569a0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$a1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2570a1 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ RadioButton b;
        public final /* synthetic */ AlertDialog c;
        public final /* synthetic */ View d;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$a1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_edit.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2570a1(EditText editText, RadioButton radioButton, AlertDialog alertDialog, View view) {
            this.a = editText;
            this.b = radioButton;
            this.c = alertDialog;
            this.d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (this.b.isChecked() && this.a.getText().toString().length() > 0) {
                double d = Double.parseDouble(this.a.getText().toString().replaceAll(",", ""));
                if (d > 100.0d || d < 0.0d) {
                    this.a.setError("% value");
                    zA = false;
                }
            }
            if (zA) {
                double d2 = Double.parseDouble(this.a.getText().toString().replaceAll(",", ""));
                if (this.b.isChecked()) {
                    Bill_edit.this.T1 = 1;
                } else {
                    Bill_edit.this.T1 = 0;
                }
                double d3 = Double.parseDouble(Bill_edit.this.Z.getText().toString().replace(",", "")) + Double.parseDouble(Bill_edit.this.b0.getText().toString().replace(",", ""));
                Bill_edit bill_edit = Bill_edit.this;
                double d4 = bill_edit.T1 == 1 ? (d2 / 100.0d) * d3 : d2;
                double d5 = d3 - d4;
                double d6 = Double.parseDouble(bill_edit.d0.getText().toString().replace(",", ""));
                double d7 = (Double.parseDouble(Bill_edit.this.e0.getText().toString().replaceAll(",", "")) * d5) / 100.0d;
                double d8 = d5 + d7 + d6;
                Bill_edit.this.i.v0("update bills set amount='" + d8 + "',d_amount= '" + d4 + "',tax_amount= '" + d7 + "',t_val='" + Bill_edit.this.e0.getText().toString().replaceAll(",", "") + "',d_val= '" + d2 + "',discount_id= '" + Bill_edit.this.T1 + "' where id='" + Bill_edit.this.p + "' and date_='" + Bill_edit.this.q + "'");
                TextView textView = Bill_edit.this.Z;
                StringBuilder sb = new StringBuilder();
                sb.append(d8 - d6);
                sb.append("");
                textView.setText(sb.toString());
                TextView textView2 = Bill_edit.this.b0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d4);
                sb2.append("");
                textView2.setText(sb2.toString());
                Bill_edit.this.V1();
                Bill_edit bill_edit2 = Bill_edit.this;
                bill_edit2.R1 = d8;
                bill_edit2.Z0();
                this.c.dismiss();
                View currentFocus = Bill_edit.this.getCurrentFocus();
                if (this.d != null) {
                    new Handler().postDelayed(new a(currentFocus), 100L);
                }
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$b, reason: case insensitive filesystem */
    public class C2571b implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2571b(AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
            this.b.requestFocus();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$b0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2572b0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog d;

        public ViewOnClickListenerC2572b0(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = editText2;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (zA && Bill_edit.this.i.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Bill_edit.this.j2 = this.b.getText().toString();
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.Y0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Bill_edit.this.j2, Bill_edit.this);
                if (!Bill_edit.this.h2) {
                    return;
                }
            }
            if (zA) {
                Bill_edit bill_edit2 = Bill_edit.this;
                if (bill_edit2.A2 != null) {
                    bill_edit2.i.v0("update customers set name='" + this.c.getText().toString().trim() + "',gsm='" + this.a.getText().toString() + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id=(select b.id from customers b where b.name='" + this.c.getText().toString() + "')");
                    Bill_edit.this.D2 = this.a.getText().toString();
                    Bill_edit bill_edit3 = Bill_edit.this;
                    if (bill_edit3.L2 != 2 || bill_edit3.S.isChecked()) {
                        Bill_edit bill_edit4 = Bill_edit.this;
                        if (bill_edit4.K2 == 4) {
                            bill_edit4.F1();
                            Bill_edit bill_edit5 = Bill_edit.this;
                            Z00 z00 = bill_edit5.i;
                            String str = bill_edit5.D2;
                            StringBuilder sb = new StringBuilder();
                            Bill_edit bill_edit6 = Bill_edit.this;
                            sb.append(bill_edit6.i.ic(bill_edit6.d1()));
                            sb.append(".pdf");
                            z00.Hd(str, sb.toString());
                        } else {
                            Z00 z01 = bill_edit4.i;
                            String str2 = bill_edit4.D2;
                            ListView listView = bill_edit4.Q;
                            String str3 = Bill_edit.this.A2 + "#" + Bill_edit.this.q0.getText().toString();
                            double d = Double.parseDouble(Bill_edit.this.h0.getText().toString().replaceAll(",", ""));
                            double d2 = Double.parseDouble(Bill_edit.this.b0.getText().toString().replaceAll(",", ""));
                            double d3 = Double.parseDouble(Bill_edit.this.d0.getText().toString().replaceAll(",", ""));
                            double d4 = Double.parseDouble(Bill_edit.this.f0.getText().toString().replaceAll(",", ""));
                            double d5 = Double.parseDouble(Bill_edit.this.U0.getText().toString().replaceAll(",", ""));
                            double d6 = Double.parseDouble(Bill_edit.this.V0.getText().toString().replaceAll(",", ""));
                            int i = Bill_edit.this.t;
                            String string = Bill_edit.this.U.getText().toString();
                            String string2 = Bill_edit.this.q0.getText().toString();
                            Bill_edit bill_edit7 = Bill_edit.this;
                            z01.Rc(str2, z01.wd(listView, str3, d, d2, d3, d4, d5, d6, i, string, string2, bill_edit7.A2, bill_edit7.T.isChecked(), Bill_edit.this.z0.getText().toString()));
                        }
                        Bill_edit.this.K2 = 0;
                    } else {
                        Bill_edit bill_edit8 = Bill_edit.this;
                        C4064uh c4064uhQ0 = bill_edit8.i.Q0(bill_edit8.A2, bill_edit8.q0.getText().toString(), Bill_edit.this.p);
                        Bill_edit bill_edit9 = Bill_edit.this;
                        if (bill_edit9.K2 == 4) {
                            Z00 z02 = bill_edit9.i;
                            z02.Ed(bill_edit9.D2, z02.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_edit.this.p, Bill_edit.this.U.getText().toString(), ""));
                        } else {
                            Z00 z03 = bill_edit9.i;
                            z03.Rc(bill_edit9.D2, z03.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_edit.this.p, Bill_edit.this.U.getText().toString(), ""));
                        }
                        Bill_edit.this.K2 = 0;
                    }
                }
                this.d.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$b1, reason: case insensitive filesystem */
    public class C2573b1 implements AdapterView.OnItemClickListener {
        public C2573b1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C0634Jt c0634Jt = (C0634Jt) adapterView.getItemAtPosition(i);
                TextView textView = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.no_);
                Bill_edit.this.J = textView.getText().toString();
                Bill_edit.this.B = c0634Jt.e();
                TextView textView2 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
                Bill_edit.this.C = textView2.getText().toString();
                TextView textView3 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_price);
                Bill_edit.this.D = textView3.getText().toString();
                TextView textView4 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_weight);
                Bill_edit.this.H = textView4.getText().toString();
                Bill_edit.this.I = c0634Jt.b();
                Bill_edit.this.E = c0634Jt.l();
                Bill_edit.this.G = c0634Jt.m();
                Bill_edit.this.F = c0634Jt.c();
                Bill_edit.O2 = 2;
                Bill_edit.this.u2();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2574c implements View.OnClickListener {
        public ViewOnClickListenerC2574c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$c0, reason: case insensitive filesystem */
    public class C2575c0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2575c0(Dialog dialog) {
            this.a = dialog;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x01c0 A[Catch: Exception -> 0x0054, TryCatch #0 {Exception -> 0x0054, blocks: (B:3:0x0008, B:6:0x001e, B:24:0x01c0, B:26:0x01c9, B:29:0x01d0, B:30:0x01fc, B:31:0x020d, B:13:0x005a, B:16:0x0091, B:18:0x00a8, B:21:0x00b2, B:22:0x01ab), top: B:35:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x01fc A[Catch: Exception -> 0x0054, TryCatch #0 {Exception -> 0x0054, blocks: (B:3:0x0008, B:6:0x001e, B:24:0x01c0, B:26:0x01c9, B:29:0x01d0, B:30:0x01fc, B:31:0x020d, B:13:0x005a, B:16:0x0091, B:18:0x00a8, B:21:0x00b2, B:22:0x01ab), top: B:35:0x0008 }] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) throws Throwable {
            String str;
            try {
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.e1(bill_edit.Y.getText().toString());
                if (i == 0) {
                    Bill_edit.this.r0();
                    Bill_edit.this.F1();
                    Z00 z00 = Bill_edit.this.i;
                    StringBuilder sb = new StringBuilder();
                    Bill_edit bill_edit2 = Bill_edit.this;
                    sb.append(bill_edit2.i.ic(bill_edit2.d1()));
                    sb.append(".pdf");
                    z00.sd(sb.toString());
                    this.a.dismiss();
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            Bill_edit bill_edit3 = Bill_edit.this;
                            bill_edit3.e1(bill_edit3.Y.getText().toString());
                            String str2 = Bill_edit.this.D2;
                            if (str2 == null || str2.length() < 3) {
                                Bill_edit bill_edit4 = Bill_edit.this;
                                String str3 = bill_edit4.k;
                                Bill_edit bill_edit5 = Bill_edit.this;
                                bill_edit4.h2(str3, bill_edit5.A2, bill_edit5.D2, bill_edit5.B2);
                            } else {
                                Bill_edit bill_edit6 = Bill_edit.this;
                                Z00 z01 = bill_edit6.i;
                                String str4 = bill_edit6.D2;
                                ListView listView = bill_edit6.Q;
                                String str5 = Bill_edit.this.A2 + "#" + Bill_edit.this.q0.getText().toString();
                                double d = Double.parseDouble(Bill_edit.this.h0.getText().toString().replaceAll(",", ""));
                                double d2 = Double.parseDouble(Bill_edit.this.b0.getText().toString().replaceAll(",", ""));
                                double d3 = Double.parseDouble(Bill_edit.this.d0.getText().toString().replaceAll(",", ""));
                                double d4 = Double.parseDouble(Bill_edit.this.f0.getText().toString().replaceAll(",", ""));
                                double d5 = Double.parseDouble(Bill_edit.this.U0.getText().toString().replaceAll(",", ""));
                                double d6 = Double.parseDouble(Bill_edit.this.V0.getText().toString().replaceAll(",", ""));
                                int i2 = Bill_edit.this.t;
                                String string = Bill_edit.this.U.getText().toString();
                                String string2 = Bill_edit.this.q0.getText().toString();
                                Bill_edit bill_edit7 = Bill_edit.this;
                                z01.Rc(str4, z01.wd(listView, str5, d, d2, d3, d4, d5, d6, i2, string, string2, bill_edit7.A2, bill_edit7.T.isChecked(), Bill_edit.this.z0.getText().toString()));
                            }
                        }
                        if (i == 3) {
                            Bill_edit bill_edit8 = Bill_edit.this;
                            bill_edit8.K2 = 4;
                            str = bill_edit8.D2;
                            if (str != null || str.length() < 3) {
                                Bill_edit bill_edit9 = Bill_edit.this;
                                String str6 = bill_edit9.k;
                                Bill_edit bill_edit10 = Bill_edit.this;
                                bill_edit9.h2(str6, bill_edit10.A2, bill_edit10.D2, bill_edit10.B2);
                            } else {
                                Bill_edit.this.F1();
                                Bill_edit bill_edit11 = Bill_edit.this;
                                Z00 z02 = bill_edit11.i;
                                String str7 = bill_edit11.D2;
                                StringBuilder sb2 = new StringBuilder();
                                Bill_edit bill_edit12 = Bill_edit.this;
                                sb2.append(bill_edit12.i.ic(bill_edit12.d1()));
                                sb2.append(".pdf");
                                z02.Hd(str7, sb2.toString());
                            }
                        }
                        this.a.dismiss();
                    }
                    Bill_edit.this.r0();
                    Bill_edit.this.E1();
                    Z00 z03 = Bill_edit.this.i;
                    StringBuilder sb3 = new StringBuilder();
                    Bill_edit bill_edit13 = Bill_edit.this;
                    sb3.append(bill_edit13.i.ic(bill_edit13.d1()));
                    sb3.append(".xls");
                    z03.pa(sb3.toString());
                    this.a.dismiss();
                }
                if (i == 3) {
                    Bill_edit bill_edit14 = Bill_edit.this;
                    bill_edit14.K2 = 4;
                    str = bill_edit14.D2;
                    if (str != null) {
                        Bill_edit bill_edit15 = Bill_edit.this;
                        String str8 = bill_edit15.k;
                        Bill_edit bill_edit16 = Bill_edit.this;
                        bill_edit15.h2(str8, bill_edit16.A2, bill_edit16.D2, bill_edit16.B2);
                    } else {
                        Bill_edit bill_edit17 = Bill_edit.this;
                        String str9 = bill_edit17.k;
                        Bill_edit bill_edit18 = Bill_edit.this;
                        bill_edit17.h2(str9, bill_edit18.A2, bill_edit18.D2, bill_edit18.B2);
                    }
                }
                this.a.dismiss();
            } catch (Exception e) {
                Log.d("share_err", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$c1, reason: case insensitive filesystem */
    public class C2576c1 implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$c1$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Bill_edit.this.N0();
                } catch (Exception unused) {
                    Toast.makeText(Bill_edit.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$c1$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2576c1() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId != info.aalmoghalis.inventory.R.id.menu_delete) {
                if (itemId != info.aalmoghalis.inventory.R.id.menu_info) {
                    return false;
                }
                SparseBooleanArray sparseBooleanArrayB = Bill_edit.this.B0.b();
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.F0 = sparseBooleanArrayB;
                try {
                    bill_edit.t2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                actionMode.finish();
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB2 = Bill_edit.this.B0.b();
            Bill_edit bill_edit2 = Bill_edit.this;
            bill_edit2.F0 = sparseBooleanArrayB2;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(bill_edit2);
            builder.setMessage(Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
            builder.setPositiveButton(Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
            builder.setNegativeButton(Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
            builder.create().show();
            actionMode.finish();
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.contextual_action_bar_5, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Bill_edit.this.Q.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Bill_edit.this.B0.j.clear();
            Bill_edit.this.B0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Bill_edit.this.Q.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Bill_edit.this.B0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2577d implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2577d(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.i.T(bill_edit, this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$d0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2578d0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2578d0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_edit.this.i.H("delete from bill_transactions where bill_id='" + Bill_edit.this.p + "' and exists(select * from bills a where a.id=bill_transactions.bill_id and a.date_='" + Bill_edit.this.q + "' and tr_type=" + Bill_edit.this.t + ")", "delete from bills where id ='" + Bill_edit.this.p + "' and date_='" + Bill_edit.this.q + "'");
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.r2 = true;
                Bills2.w0 = Bills2.w0 - 1;
                bill_edit.i1();
            } catch (Exception unused) {
                Toast.makeText(Bill_edit.this.getApplicationContext(), "SQL Error.", 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$d1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2579d1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ View b;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$d1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_edit.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2579d1(AlertDialog alertDialog, View view) {
            this.a = alertDialog;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            View currentFocus = Bill_edit.this.getCurrentFocus();
            if (this.b != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2580e implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2580e(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.i.T(bill_edit, this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$e0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2581e0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2581e0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$e1, reason: case insensitive filesystem */
    public class C2582e1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2582e1(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            if (adapterView.getItemAtPosition(i).toString().length() > 0) {
                this.a.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$f, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2583f implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2583f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$f0, reason: case insensitive filesystem */
    public class C2584f0 implements info.aalmoghalis.inventory.zatca.d.InterfaceC0322d {
        public final /* synthetic */ info.aalmoghalis.inventory.zatca.d a;
        public final /* synthetic */ W7 b;
        public final /* synthetic */ info.aalmoghalis.inventory.zatca.d.g c;

        public C2584f0(info.aalmoghalis.inventory.zatca.d dVar, W7 w7, info.aalmoghalis.inventory.zatca.d.g gVar) {
            this.a = dVar;
            this.b = w7;
            this.c = gVar;
        }

        @Override // info.aalmoghalis.inventory.zatca.d.InterfaceC0322d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(info.aalmoghalis.inventory.zatca.d.e eVar) {
            if (!eVar.g.isEmpty()) {
                String strB = ((String) eVar.g.get(0)) + ":" + eVar.e;
                try {
                    C1839c10.z(Bill_edit.this.i, "Zatca=", "" + eVar.e);
                    JSONObject jSONObject = new JSONObject(eVar.e);
                    if (jSONObject.has(HTML.Tag.DETAILS)) {
                        strB = info.aalmoghalis.inventory.zatca.d.B(jSONObject.getString(HTML.Tag.DETAILS));
                        Toast.makeText(Bill_edit.this.p1, strB, 1).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (strB.length() > 0) {
                        Toast.makeText(Bill_edit.this.p1, strB, 1).show();
                    }
                }
            }
            info.aalmoghalis.inventory.zatca.d dVar = this.a;
            Z00 z00 = Bill_edit.this.i;
            W7 w7 = this.b;
            dVar.f0(z00, w7, eVar, this.c, w7.a0.doubleValue(), Integer.valueOf(C2160f10.h));
            Bill_edit.this.invalidateOptionsMenu();
            Bill_edit.this.O1();
            Intent intent = new Intent("ACTION_INVOICE_UPDATED");
            intent.setPackage(Bill_edit.this.getPackageName());
            Bill_edit.this.sendBroadcast(intent);
            Bill_edit bill_edit = Bill_edit.this;
            if (bill_edit.s2) {
                bill_edit.Z0();
            }
            Bill_edit.this.s2 = false;
        }

        @Override // info.aalmoghalis.inventory.zatca.d.InterfaceC0322d
        public void onError(String str) {
            Toast.makeText(Bill_edit.this.p1, info.aalmoghalis.inventory.zatca.d.B(str), 0).show();
            Bill_edit.this.s2 = false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$f1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2585f1 implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ RadioButton b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ TextView d;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$f1$a */
        public class a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ Dialog a;

            public a(Dialog dialog) {
                this.a = dialog;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ViewOnClickListenerC2585f1.this.a.setText(adapterView.getItemAtPosition(i).toString());
                if (ViewOnClickListenerC2585f1.this.b.isChecked() && ViewOnClickListenerC2585f1.this.c.getText().toString().length() > 0) {
                    double d = Double.parseDouble(ViewOnClickListenerC2585f1.this.c.getText().toString().replaceAll(",", ""));
                    if (d > 100.0d || d < 0.0d) {
                        ViewOnClickListenerC2585f1.this.c.setError("% value");
                        return;
                    }
                }
                double d2 = Double.parseDouble(ViewOnClickListenerC2585f1.this.c.getText().toString().replaceAll(",", ""));
                boolean zIsChecked = ViewOnClickListenerC2585f1.this.b.isChecked();
                double d3 = Double.parseDouble(Bill_edit.this.Z.getText().toString().replace(",", "")) + Double.parseDouble(Bill_edit.this.b0.getText().toString().replace(",", ""));
                if (zIsChecked) {
                    d2 = (d2 / 100.0d) * d3;
                }
                double d4 = (Double.parseDouble(ViewOnClickListenerC2585f1.this.a.getText().toString().replaceAll(",", "")) * (d3 - d2)) / 100.0d;
                ViewOnClickListenerC2585f1 viewOnClickListenerC2585f1 = ViewOnClickListenerC2585f1.this;
                viewOnClickListenerC2585f1.d.setText(Bill_edit.this.i.P7(d4 + ""));
                if (d4 > 0.0d) {
                    ViewOnClickListenerC2585f1.this.d.setVisibility(0);
                }
                this.a.dismiss();
            }
        }

        public ViewOnClickListenerC2585f1(TextView textView, RadioButton radioButton, EditText editText, TextView textView2) {
            this.a = textView;
            this.b = radioButton;
            this.c = editText;
            this.d = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_edit.this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            Dialog dialog = new Dialog(Bill_edit.this);
            LinearLayout linearLayout = new LinearLayout(Bill_edit.this);
            ListView listView = new ListView(Bill_edit.this);
            listView.setAdapter((ListAdapter) Bill_edit.this.j0);
            listView.setOnItemClickListener(new a(dialog));
            linearLayout.setFocusable(true);
            listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            linearLayout.addView(listView, -1, -1);
            dialog.setContentView(linearLayout);
            dialog.show();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$g, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2586g implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2586g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$g0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2587g0 implements View.OnClickListener {
        public final /* synthetic */ Snackbar a;

        public ViewOnClickListenerC2587g0(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Bill_edit.this.i1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$g1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2588g1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2588g1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$h, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2589h implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog g;

        public ViewOnClickListenerC2589h(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, EditText editText2, EditText editText3, androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = autoCompleteTextView2;
            this.d = str;
            this.e = editText2;
            this.f = editText3;
            this.g = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            boolean z = AbstractC4371yX.a(this.c) ? zA : false;
            if (Bill_edit.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Bill_edit.this.j2 = this.b.getText().toString();
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.V0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Bill_edit.this.j2, Bill_edit.this);
                if (!Bill_edit.this.b2) {
                    return;
                }
            }
            if (z) {
                int iR1 = Bill_edit.this.i.r1(this.c.getText().toString());
                if (!this.d.equals("0")) {
                    if (this.d != null) {
                        Bill_edit.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.e.getText().toString() + "',address='" + this.f.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Bill_edit.this.k + "' and id>0 ");
                        this.g.dismiss();
                        return;
                    }
                    return;
                }
                if (Bill_edit.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                    FragmentStatePagerSupport_Main.Z(Bill_edit.this);
                    this.a.setError(Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.exist));
                    return;
                }
                Bill_edit.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.e.getText().toString() + "','" + this.f.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                if (iR1 == 121 || iR1 == 122) {
                    Bill_edit.this.r0.setText(this.a.getText().toString());
                }
                this.g.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$h0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2590h0 implements View.OnClickListener {
        public ViewOnClickListenerC2590h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.Z1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$h1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2591h1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2591h1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$i, reason: case insensitive filesystem */
    public class C2592i implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2592i(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$i0, reason: case insensitive filesystem */
    public class RunnableC2593i0 implements Runnable {
        public final /* synthetic */ Snackbar a;

        public RunnableC2593i0(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$i1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2594i1 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ RadioButton c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ TextView f;
        public final /* synthetic */ AlertDialog g;
        public final /* synthetic */ View h;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$i1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_edit.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2594i1(EditText editText, AutoCompleteTextView autoCompleteTextView, RadioButton radioButton, EditText editText2, EditText editText3, TextView textView, AlertDialog alertDialog, View view) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = radioButton;
            this.d = editText2;
            this.e = editText3;
            this.f = textView;
            this.g = alertDialog;
            this.h = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            int i;
            if (Bill_edit.this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            if (this.a.getText().toString().length() == 0) {
                this.a.setText("0");
                Bill_edit bill_edit = Bill_edit.this;
                if (bill_edit.a2 == 0) {
                    bill_edit.a2 = -24;
                }
                this.b.setText(bill_edit.i.A4(Bill_edit.this.a2 + ""));
            } else {
                if (!AbstractC4371yX.a(this.a) || !AbstractC4371yX.a(this.b)) {
                    return;
                }
                if (Bill_edit.this.i.v8(this.b.getText().toString(), Bill_edit.this.t).getCount() == 0) {
                    this.b.setError("*");
                    return;
                }
            }
            if (this.c.isChecked() && this.d.getText().toString().length() > 0) {
                double d = Double.parseDouble(this.d.getText().toString().replaceAll(",", ""));
                if (d > 100.0d || d < 0.0d) {
                    this.d.setError("% value");
                    return;
                }
            }
            if (this.d.getText().toString().length() == 0) {
                this.d.setText("0");
                Bill_edit.this.T1 = 0;
            }
            if (this.e.getText().toString().length() == 0) {
                this.e.setText("0");
            }
            double d2 = Double.parseDouble(this.d.getText().toString().replaceAll(",", ""));
            if (this.c.isChecked()) {
                Bill_edit.this.T1 = 1;
            } else {
                Bill_edit.this.T1 = 0;
            }
            double d3 = Double.parseDouble(Bill_edit.this.Z.getText().toString().replace(",", "")) + Double.parseDouble(Bill_edit.this.b0.getText().toString().replace(",", ""));
            double d4 = Bill_edit.this.T1 == 1 ? (d2 / 100.0d) * d3 : d2;
            double d5 = d3 - d4;
            double d6 = Double.parseDouble(this.a.getText().toString().replace(",", ""));
            double d7 = (Double.parseDouble(this.f.getText().toString().replaceAll(",", "")) * d5) / 100.0d;
            double d8 = d5 + d7 + d6;
            Z00 z00 = Bill_edit.this.i;
            StringBuilder sb = new StringBuilder();
            sb.append("update bills set amount='");
            sb.append(d8);
            sb.append("',d_amount= '");
            sb.append(d4);
            sb.append("',tax_amount= '");
            sb.append(d7);
            sb.append("',t_val='");
            sb.append(this.f.getText().toString().replaceAll(",", ""));
            sb.append("',d_val= '");
            sb.append(d2);
            sb.append("',discount_id= '");
            sb.append(Bill_edit.this.T1);
            sb.append("',cost2= '");
            sb.append(d6);
            sb.append("',cost_id= (select id from customers where name='");
            sb.append(this.b.getText().toString());
            sb.append("'),paid_amount=");
            if (Bill_edit.this.S.isChecked()) {
                str = "0";
            } else {
                str = "'" + this.e.getText().toString().replaceAll(",", "") + "'";
            }
            sb.append(str);
            sb.append(",bill_type=");
            sb.append(Bill_edit.this.S.isChecked() ? 1 : 2);
            sb.append(" where id='");
            sb.append(Bill_edit.this.p);
            sb.append("' and date_='");
            sb.append(Bill_edit.this.q);
            sb.append("'");
            String strY0 = z00.y0(sb.toString());
            if (strY0 == null || !strY0.equals("1")) {
                Bill_edit bill_edit2 = Bill_edit.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strY0 == null || strY0.length() <= 20) {
                    i = 0;
                } else {
                    i = 0;
                    strY0 = strY0.substring(0, 20);
                }
                sb2.append(strY0);
                Toast.makeText(bill_edit2, sb2.toString(), i).show();
                Bill_edit.this.Q1();
                Bill_edit.this.Z0();
                return;
            }
            Bill_edit.this.Z.setText((d8 - d6) + "");
            Bill_edit.this.b0.setText(d4 + "");
            Bill_edit.this.V1();
            Bill_edit bill_edit3 = Bill_edit.this;
            bill_edit3.R1 = d8;
            bill_edit3.Z0();
            this.g.dismiss();
            View currentFocus = Bill_edit.this.getCurrentFocus();
            if (this.h != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$j, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2595j implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnTouchListenerC2595j(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$j0, reason: case insensitive filesystem */
    public class HandlerC2596j0 extends Handler {
        public HandlerC2596j0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$j1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2597j1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ View b;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$j1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_edit.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2597j1(AlertDialog alertDialog, View view) {
            this.a = alertDialog;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            View currentFocus = Bill_edit.this.getCurrentFocus();
            if (this.b != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$k, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2598k implements View.OnTouchListener {
        public ViewOnTouchListenerC2598k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_edit.this.Y.showDropDown();
            if (motionEvent.getAction() == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("x=");
                sb.append(motionEvent.getX());
                sb.append(":bound=");
                sb.append(Bill_edit.this.Y.getCompoundDrawables()[0] != null ? Bill_edit.this.Y.getCompoundDrawables()[0].getBounds().width() : 0);
                sb.append(":paddingLeft=");
                sb.append(Bill_edit.this.Y.getPaddingLeft());
                sb.append(":Left=");
                sb.append(Bill_edit.this.Y.getLeft());
                sb.append(":getRawX=");
                sb.append(motionEvent.getRawX());
                sb.append(":getTotalPaddingLeft=");
                sb.append(Bill_edit.this.Y.getTotalPaddingLeft());
                Log.d("clear_action_up:=", sb.toString());
                if (motionEvent.getX() <= Bill_edit.this.Y.getTotalPaddingLeft()) {
                    Bill_edit.this.Y.setText("");
                    Bill_edit.this.Y.requestFocus();
                    Bill_edit.this.N2 = 1;
                    return false;
                }
                motionEvent.getX();
                Bill_edit.this.Y.getRight();
                Bill_edit.this.Y.getPaddingRight();
                if (Bill_edit.this.Y.getCompoundDrawables()[2] != null) {
                    Bill_edit.this.Y.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$k0, reason: case insensitive filesystem */
    public class C2599k0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2599k0(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_edit bill_edit = Bill_edit.this;
            C4064uh c4064uhQ0 = bill_edit.i.Q0(bill_edit.A2, bill_edit.q0.getText().toString(), Bill_edit.this.p);
            if (i == 0) {
                Bill_edit bill_edit2 = Bill_edit.this;
                bill_edit2.K2 = 4;
                String str = bill_edit2.D2;
                if (str == null || str.length() < 3) {
                    Bill_edit bill_edit3 = Bill_edit.this;
                    String str2 = bill_edit3.k;
                    Bill_edit bill_edit4 = Bill_edit.this;
                    bill_edit3.h2(str2, bill_edit4.A2, bill_edit4.D2, bill_edit4.B2);
                } else {
                    Bill_edit bill_edit5 = Bill_edit.this;
                    Z00 z00 = bill_edit5.i;
                    z00.Ed(bill_edit5.D2, z00.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_edit.this.p, Bill_edit.this.U.getText().toString(), ""));
                }
            } else if (i == 1) {
                Bill_edit bill_edit6 = Bill_edit.this;
                bill_edit6.K2 = 3;
                String str3 = bill_edit6.D2;
                if (str3 == null || str3.length() < 3) {
                    Bill_edit bill_edit7 = Bill_edit.this;
                    String str4 = bill_edit7.k;
                    Bill_edit bill_edit8 = Bill_edit.this;
                    bill_edit7.h2(str4, bill_edit8.A2, bill_edit8.D2, bill_edit8.B2);
                } else {
                    Bill_edit bill_edit9 = Bill_edit.this;
                    Z00 z01 = bill_edit9.i;
                    z01.Rc(bill_edit9.D2, z01.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_edit.this.p, Bill_edit.this.U.getText().toString(), ""));
                }
            } else if (i == 2) {
                Z00 z02 = Bill_edit.this.i;
                z02.td(z02.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_edit.this.p, Bill_edit.this.U.getText().toString(), ""));
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$k1, reason: case insensitive filesystem */
    public class RunnableC2600k1 implements Runnable {
        public final /* synthetic */ View a;

        public RunnableC2600k1(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bill_edit.this.i.x9(this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$l, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2601l implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2601l(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.E0(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$l0, reason: case insensitive filesystem */
    public class C2602l0 implements TextWatcher {
        public C2602l0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Bill_edit bill_edit = Bill_edit.this;
            if (bill_edit.Z0) {
                bill_edit.Z0 = false;
            } else {
                bill_edit.N2 = 1;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$l1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2603l1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2603l1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$m, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2604m implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2604m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$m0, reason: case insensitive filesystem */
    public class C2605m0 implements TextWatcher {
        public C2605m0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Bill_edit bill_edit = Bill_edit.this;
            if (bill_edit.b1) {
                bill_edit.b1 = false;
                return;
            }
            if (bill_edit.B1.hasFocus()) {
                Bill_edit.this.n2(1);
            } else if (Bill_edit.this.y1.hasFocus()) {
                Bill_edit.this.n2(2);
            } else if (Bill_edit.this.z1.hasFocus()) {
                Bill_edit.this.n2(3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$m1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2606m1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2606m1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$n, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2607n implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2607n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$n0, reason: case insensitive filesystem */
    public class C2608n0 implements TextWatcher {
        public C2608n0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Log.d("item_focus=", Bill_edit.this.B1.hasFocus() + ":" + Bill_edit.this.y1.hasFocus() + ":" + Bill_edit.this.z1.hasFocus() + "#" + Bill_edit.this.b1);
            Bill_edit bill_edit = Bill_edit.this;
            if (bill_edit.b1) {
                bill_edit.b1 = false;
                return;
            }
            if (bill_edit.G1.hasFocus()) {
                Bill_edit.this.o2(1);
            } else if (Bill_edit.this.E1.hasFocus()) {
                Bill_edit.this.o2(2);
            } else if (Bill_edit.this.F1.hasFocus()) {
                Bill_edit.this.o2(3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$n1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2609n1 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ View c;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$n1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_edit.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2609n1(EditText editText, AlertDialog alertDialog, View view) {
            this.a = editText;
            this.b = alertDialog;
            this.c = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a)) {
                double d = Double.parseDouble(this.a.getText().toString().replaceAll(",", ""));
                Bill_edit.this.U0.setText(d + "");
                String str = "0";
                if (Bill_edit.this.D0()) {
                    Bill_edit.this.U0.setText("0");
                } else {
                    Z00 z00 = Bill_edit.this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update bills set paid_amount=");
                    if (!Bill_edit.this.S.isChecked()) {
                        str = "'" + Bill_edit.this.U0.getText().toString().replaceAll(",", "") + "'";
                    }
                    sb.append(str);
                    sb.append(" where id='");
                    sb.append(Bill_edit.this.p);
                    sb.append("' and date_='");
                    sb.append(Bill_edit.this.q);
                    sb.append("'");
                    z00.v0(sb.toString());
                }
                Bill_edit.this.Z0();
                this.b.dismiss();
                View currentFocus = Bill_edit.this.getCurrentFocus();
                if (this.c != null) {
                    new Handler().postDelayed(new a(currentFocus), 100L);
                }
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$o, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2610o implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ Handler e;

        public ViewOnClickListenerC2610o(AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog, String str, EditText editText, Handler handler) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
            this.c = str;
            this.d = editText;
            this.e = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (zA && Bill_edit.this.i.P5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Bill_edit.this.j2 = this.a.getText().toString();
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.W0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type), Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type) + "#" + Bill_edit.this.j2, this.b.getContext());
                if (!Bill_edit.this.h2) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Bill_edit.this.i.H("insert into items (name,item_type_id,o_date) values('" + this.d.getText().toString() + "',(select b.id from item_type b where b.name='" + this.a.getText().toString() + "'),'" + Bill_edit.this.U.getText().toString() + "' )", "insert into item_price (item_id,curr_id,sls_u_price,unit_id) values((select id from items a where a.name='" + this.d.getText().toString() + "'),(select b.id from currency b where b.name='" + Bill_edit.this.q0.getText().toString() + "'),'0' ,0)");
                    Bill_edit bill_edit2 = Bill_edit.this;
                    bill_edit2.g2 = 0;
                    bill_edit2.b2 = true;
                    Bill_edit.this.x1.setText(this.d.getText().toString());
                    Handler handler = this.e;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$o0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2611o0 implements View.OnClickListener {
        public ViewOnClickListenerC2611o0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.c2(1);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$o1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2612o1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ View b;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$o1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_edit.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2612o1(AlertDialog alertDialog, View view) {
            this.a = alertDialog;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            View currentFocus = Bill_edit.this.getCurrentFocus();
            if (this.b != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$p, reason: case insensitive filesystem */
    public class HandlerC2613p extends Handler {
        public HandlerC2613p() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$p0, reason: case insensitive filesystem */
    public class C2614p0 implements AdapterView.OnItemClickListener {
        public C2614p0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_edit.this.t1(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$p1, reason: case insensitive filesystem */
    public class C2615p1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2615p1(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            if (adapterView.getItemAtPosition(i).toString().length() > 0) {
                this.a.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$q, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2616q implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2616q(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.i.v0("insert into item_type  (name )  values( '" + Bill_edit.this.j2 + "'  )");
            Bill_edit.this.i2 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$q0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2617q0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2617q0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_edit.this.x1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.x1.getCompoundDrawables()[0] != null ? Bill_edit.this.x1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.x1.getPaddingLeft() + Bill_edit.this.x1.getLeft()) {
                    Bill_edit.this.x1.setText("");
                    Bill_edit.this.x1.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_edit.this.x1.getRight();
                Bill_edit.this.x1.getPaddingRight();
                if (Bill_edit.this.x1.getCompoundDrawables()[2] != null) {
                    Bill_edit.this.x1.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$q1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2618q1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2618q1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$r, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2619r implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2619r(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_edit.this.i2 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$r0, reason: case insensitive filesystem */
    public class C2620r0 implements TextWatcher {
        public C2620r0() {
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
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.x1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_edit, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_edit.this.x1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_edit.this.x1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$r1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2621r1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2621r1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$s, reason: case insensitive filesystem */
    public class C2622s implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2622s(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$s0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2623s0 implements View.OnClickListener {
        public ViewOnClickListenerC2623s0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.more_item(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$s1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2624s1 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AlertDialog c;
        public final /* synthetic */ View d;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$s1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_edit.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2624s1(EditText editText, AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog, View view) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = alertDialog;
            this.d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            boolean z = false;
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (Bill_edit.this.i.v8(this.b.getText().toString(), Bill_edit.this.t).getCount() == 0) {
                this.b.setError("*");
            } else {
                z = zA;
            }
            if (z) {
                double d = Double.parseDouble(this.a.getText().toString().replaceAll(",", ""));
                double d2 = Double.parseDouble(Bill_edit.this.Z.getText().toString().replace(",", ""));
                double d3 = (Double.parseDouble(Bill_edit.this.e0.getText().toString().replaceAll(",", "")) * d2) / 100.0d;
                double d4 = d2 + d3 + d;
                Log.d("bill_cost=", d4 + ":" + d + ":" + d3);
                Bill_edit.this.i.v0("update bills set amount='" + d4 + "',cost2= '" + d + "',cost_id= (select id from customers where name='" + this.b.getText().toString() + "') where id='" + Bill_edit.this.p + "' and date_='" + Bill_edit.this.q + "'");
                TextView textView = Bill_edit.this.Z;
                StringBuilder sb = new StringBuilder();
                sb.append(d4 - d);
                sb.append("");
                textView.setText(sb.toString());
                TextView textView2 = Bill_edit.this.d0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d);
                sb2.append("");
                textView2.setText(sb2.toString());
                Bill_edit.this.V1();
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.R1 = d4;
                bill_edit.Z0();
                this.c.dismiss();
                View currentFocus = Bill_edit.this.getCurrentFocus();
                if (this.d != null) {
                    new Handler().postDelayed(new a(currentFocus), 100L);
                }
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$t, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2625t implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnTouchListenerC2625t(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$t0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2626t0 implements View.OnClickListener {
        public ViewOnClickListenerC2626t0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_edit.this.y1.getText().toString().length() != 0) {
                Bill_edit.this.y1.setText("");
            } else {
                EditText editText = Bill_edit.this.y1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$t1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2627t1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ View b;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$t1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_edit.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2627t1(AlertDialog alertDialog, View view) {
            this.a = alertDialog;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            View currentFocus = Bill_edit.this.getCurrentFocus();
            if (this.b != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$u, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2628u implements View.OnClickListener {
        public ViewOnClickListenerC2628u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$u0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2629u0 implements View.OnClickListener {
        public ViewOnClickListenerC2629u0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = Bill_edit.this.q0.getText().toString();
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.i.T(bill_edit, bill_edit.H0, Bill_edit.this.q0);
            Log.d("curr=", string + ":" + Bill_edit.this.q0.getText().toString() + ":" + Bill_edit.this.p);
            Bill_edit.this.N2 = 1;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$u1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2630u1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public DialogInterfaceOnClickListenerC2630u1(TextView textView, ImageView imageView) {
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
                Bill_edit.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Bill_edit.this.p = 0L;
                Bill_edit.this.Z0();
            } catch (Exception unused) {
                Toast.makeText(Bill_edit.this.getApplicationContext(), Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$v, reason: case insensitive filesystem */
    public class C2631v implements TextWatcher {
        public C2631v() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= 0 || !Bill_edit.this.Y.isEnabled()) {
                Bill_edit.this.Y.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, Bill_edit.this.Y.getCompoundDrawables()[2], (Drawable) null);
            } else {
                Bill_edit.this.Y.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(Bill_edit.this, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_edit.this.Y.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$v0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2632v0 implements View.OnClickListener {
        public ViewOnClickListenerC2632v0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_edit.this.z1.getText().toString().length() != 0) {
                Bill_edit.this.z1.setText("");
            } else {
                EditText editText = Bill_edit.this.z1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class v1 implements DialogInterface.OnClickListener {
        public v1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$w, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2633w implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2633w(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit.this.E0(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$w0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2634w0 implements View.OnClickListener {
        public ViewOnClickListenerC2634w0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_edit bill_edit = Bill_edit.this;
            double dDoubleValue = bill_edit.A0(bill_edit.D1.getText().toString(), Bill_edit.this.n).doubleValue();
            Bill_edit bill_edit2 = Bill_edit.this;
            Z00 z00 = bill_edit2.i;
            String string = bill_edit2.D1.getText().toString();
            String string2 = Bill_edit.this.Y.getText().toString();
            String string3 = Bill_edit.this.q0.getText().toString();
            boolean zIsChecked = Bill_edit.this.T.isChecked();
            Bill_edit bill_edit3 = Bill_edit.this;
            z00.te(bill_edit2, string, string2, string3, dDoubleValue, zIsChecked, bill_edit3.f1, bill_edit3.t, Bill_edit.this.L1.getText().toString());
        }
    }

    public class w1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public w1(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Bill_edit.this.i.v0("delete from items_temp  where no_=  '" + ((Object) this.a.getText()) + "'");
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.q1 = 1;
                    bill_edit.Z0();
                    Bill_edit.this.y1();
                    Bill_edit.this.b2(false);
                    Bill_edit bill_edit2 = Bill_edit.this;
                    bill_edit2.q1 = 1;
                    bill_edit2.M0();
                    Bill_edit.this.Z0();
                    Bill_edit bill_edit3 = Bill_edit.this;
                    bill_edit3.q2(bill_edit3.p, "0");
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_edit.this.getApplicationContext(), Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$x, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2635x implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2635x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$x0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2636x0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2636x0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.B1.getCompoundDrawables()[0] != null ? Bill_edit.this.B1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.B1.getPaddingLeft() + Bill_edit.this.B1.getLeft()) {
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.i.B(bill_edit.B1, bill_edit.N1);
                }
            }
            return false;
        }
    }

    public class x1 implements CompoundButton.OnCheckedChangeListener {
        public x1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Bill_edit bill_edit = Bill_edit.this;
            bill_edit.N2 = 1;
            bill_edit.r2();
            if (Bill_edit.this.t == 2) {
                Bill_edit.this.Y.setHint(Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.supp));
                Bill_edit.this.a1();
            } else if (Bill_edit.this.t == 1) {
                Bill_edit.this.Y.setHint(Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.cus));
                Bill_edit.this.a1();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$y, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2637y implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2637y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$y0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2638y0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2638y0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.y1.getCompoundDrawables()[0] != null ? Bill_edit.this.y1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.y1.getPaddingLeft() + Bill_edit.this.y1.getLeft()) {
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.i.B(bill_edit.y1, bill_edit.N1);
                }
            }
            return false;
        }
    }

    public class y1 implements DialogInterface.OnClickListener {
        public y1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$z, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2639z implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Handler g;

        public ViewOnClickListenerC2639z(AutoCompleteTextView autoCompleteTextView, androidx.appcompat.app.AlertDialog alertDialog, String str, EditText editText, EditText editText2, int i, Handler handler) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
            this.c = str;
            this.d = editText;
            this.e = editText2;
            this.f = i;
            this.g = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (zA && Bill_edit.this.i.Q5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Bill_edit.this.j2 = this.a.getText().toString();
                Bill_edit bill_edit = Bill_edit.this;
                bill_edit.Y0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Bill_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Bill_edit.this.j2, this.b.getContext());
                if (!Bill_edit.this.h2) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Z00 z00 = Bill_edit.this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into customers (name,gsm,g_id,acc_p_id) values('");
                    sb.append(this.d.getText().toString().trim());
                    sb.append("','");
                    sb.append(this.e.getText().toString());
                    sb.append("',(select b.id from groups b where b.name='");
                    sb.append(this.a.getText().toString());
                    sb.append("'),'");
                    sb.append(this.f == 2 ? "221" : "123");
                    sb.append("' )");
                    z00.v0(sb.toString());
                    Bill_edit bill_edit2 = Bill_edit.this;
                    bill_edit2.g2 = 0;
                    bill_edit2.b2 = true;
                    Bill_edit.this.A2 = this.d.getText().toString();
                    Bill_edit.this.D2 = this.e.getText().toString();
                    Bill_edit.this.B2 = this.a.getText().toString();
                    Handler handler = this.g;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_edit$z0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2640z0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2640z0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_edit.this.z1.getCompoundDrawables()[0] != null ? Bill_edit.this.z1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_edit.this.z1.getPaddingLeft() + Bill_edit.this.z1.getLeft()) {
                    Bill_edit bill_edit = Bill_edit.this;
                    bill_edit.x0(bill_edit.z1);
                }
            }
            return false;
        }
    }

    public class z1 extends Handler {
        public z1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    private void B1(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                L0(new File(Z00.A0), file2);
            } else {
                L0(new File(T0(this, this.z2)), file2);
            }
            X1(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void D1(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.i, this);
            if (strX != null) {
                X1(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void L0(File file, File file2) throws IOException {
        if (file.exists()) {
            FileChannel channel = new FileInputStream(file).getChannel();
            FileChannel channel2 = new FileOutputStream(file2).getChannel();
            if (channel2 != null && channel != null) {
                channel2.transferFrom(channel, 0L, channel.size());
            }
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        }
    }

    private void O0() {
        String[] stringArray = this.S0.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setItems(stringArray, new P(stringArray));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.x2.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.w2);
    }

    private void S1(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
    }

    private void T1() {
        String[] stringArray = this.S0.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setItems(stringArray, new O(stringArray));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d1() {
        String str;
        boolean zIsChecked = this.S.isChecked();
        String str2 = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.t - 1];
        String string = getString(zIsChecked ? info.aalmoghalis.inventory.R.string.cash : info.aalmoghalis.inventory.R.string.post);
        if (this.T.isChecked()) {
            str = getString(info.aalmoghalis.inventory.R.string.qr_back) + " - " + this.T.getText().toString() + " ";
        } else {
            str = "";
        }
        boolean z = this.i.P4(this.Y.getText().toString()).length() > 0;
        if (this.t != 1) {
            return str + str2 + " " + string;
        }
        if (!this.i.ja("pref_show_qr_code", false)) {
            return str + str2 + " " + string;
        }
        if (this.i.ja("pref_show_qr_code", false) && !this.T.isChecked() && !z) {
            return getString(info.aalmoghalis.inventory.R.string.qr_bill_simple) + " - " + str2 + " " + string;
        }
        if (this.i.ja("pref_show_qr_code", false) && this.T.isChecked() && !z) {
            return getString(info.aalmoghalis.inventory.R.string.qr_bill_simple) + " - " + str + " " + str2 + " " + string;
        }
        if (this.i.ja("pref_show_qr_code", false) && !this.T.isChecked() && z) {
            return getString(info.aalmoghalis.inventory.R.string.qr_bill_normal) + " - " + str2 + " " + string;
        }
        if (!this.i.ja("pref_show_qr_code", false) || !this.T.isChecked() || !z) {
            return "";
        }
        return getString(info.aalmoghalis.inventory.R.string.qr_bill_normal) + " - " + str + " " + str2 + " " + string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    private boolean k1(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean l1() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && k1(21, 22);
    }

    public static boolean m1(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean n1(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean o1(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private void p2() {
        int i = this.t;
        if (i == 2) {
            this.Y.setHint(getString(info.aalmoghalis.inventory.R.string.supp));
            a1();
        } else if (i == 1) {
            this.Y.setHint(getString(info.aalmoghalis.inventory.R.string.cus));
            a1();
        }
        if (this.t == 2) {
            this.S.isChecked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2() {
        try {
            boolean zIsChecked = this.S.isChecked();
            setTitle(this.O0);
            String str = "";
            if (zIsChecked) {
                StringBuilder sb = new StringBuilder();
                if (this.T.isChecked()) {
                    str = this.T.getText().toString() + " ";
                }
                sb.append(str);
                sb.append(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.t - 1]);
                sb.append(" ");
                sb.append(getString(info.aalmoghalis.inventory.R.string.cash));
                String string = sb.toString();
                this.O0 = string;
                setTitle(string);
                this.r0.setVisibility(0);
                this.T0.setVisibility(8);
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (this.T.isChecked()) {
                    str = this.T.getText().toString() + " ";
                }
                sb2.append(str);
                sb2.append(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.t - 1]);
                sb2.append(" ");
                sb2.append(getString(info.aalmoghalis.inventory.R.string.post));
                String string2 = sb2.toString();
                this.O0 = string2;
                setTitle(string2);
                this.r0.setVisibility(4);
                this.T0.setVisibility(0);
            }
            if (this.t == 1 && this.T.isChecked() && !this.M) {
                this.t0 = this.i.o7(String.valueOf(this.p), "0", this.W.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
            }
            K1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        D1(uri, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer w1(long j, String str) {
        this.t0 = new C2160f10(this.i).d0(j, this.p, this.f1, str, this.T.isChecked(), this.M, this.n, this.l, this.t, "0", this.U.getText().toString());
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x1(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            f2();
            return;
        }
        int i = Integer.parseInt(this.i.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.i.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.y2.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean z0() {
        C1839c10.z(this.i, "checkValidation_save", "START");
        boolean zA = AbstractC4371yX.a(this.Y);
        if (this.p != 0 && !AbstractC4371yX.a(this.z0)) {
            zA = false;
        }
        if (this.Y.getText().length() == 0) {
            zA = false;
        }
        if (!this.i.Q()) {
            return zA;
        }
        I0();
        return false;
    }

    public Double A0(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.t0, str, str2);
        Log.d("check_item_qtyT=", str + ":" + str2 + "#" + arrayListH.size() + ":" + this.t0.size());
        double d = 0.0d;
        for (int i = 0; i < arrayListH.size(); i++) {
            d += Double.parseDouble((String) ((HashMap) arrayListH.get(i)).get("item_qty"));
        }
        Log.d("check_item_qty_current=", "" + str + ":" + d + ":r=" + C1839c10.C(d, C1839c10.d));
        return Double.valueOf(d);
    }

    public boolean A1() {
        W7 w7B;
        if (this.p == 0 || this.t != 1) {
            return true;
        }
        if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit") || (w7B = W7.b(this.i.a, this.p)) == null) {
            return true;
        }
        info.aalmoghalis.inventory.zatca.c cVar = new info.aalmoghalis.inventory.zatca.c(this);
        String strR = new info.aalmoghalis.inventory.zatca.d(this.p1).r();
        if (cVar.h(w7B.i, strR + "") == -1 && TextUtils.isEmpty(w7B.O)) {
            return true;
        }
        return info.aalmoghalis.inventory.zatca.d.h(this, this.i, w7B);
    }

    public ArrayList B0(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.t0, str, str2);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListH.iterator();
        while (it.hasNext()) {
            arrayList.add((HashMap) ((HashMap) it.next()).clone());
        }
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayList.size());
        double dZ6 = this.i.Z6(str, this.L1.getText().toString());
        for (int i = 0; i < arrayList.size(); i++) {
            double d = Double.parseDouble((String) ((HashMap) arrayList.get(i)).get("item_qty")) / dZ6;
            ((HashMap) arrayList.get(i)).put("item_qty", this.i.S7(String.valueOf(d)).replaceAll(",", ""));
            ((HashMap) arrayList.get(i)).put("item_date_qty", "(" + ((String) ((HashMap) arrayList.get(i)).get("item_date")) + ")" + this.i.S7(String.valueOf(d)).replaceAll(",", ""));
        }
        return arrayList;
    }

    public Double C0(String str, String str2, String str3) {
        ArrayList arrayListG = new C1839c10().g(this.t0, str, str2, str3);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListG.size());
        return Double.valueOf(arrayListG.size() > 0 ? Double.parseDouble((String) ((HashMap) arrayListG.get(0)).get("item_qty")) : 0.0d);
    }

    public void C1(String str) {
        try {
            C0809Ov c0809Ov = this.B0;
            if (c0809Ov != null) {
                c0809Ov.getFilter().filter(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean D0() {
        if (this.U0.getText().toString().length() == 0) {
            this.U0.setText("0");
        }
        if (this.S.isChecked()) {
            this.U0.setText("0");
        }
        if (this.U0.getText().length() <= 0 || this.U0.getText().toString().equals("0") || Double.parseDouble(this.U0.getText().toString().replaceAll(",", "")) <= Double.parseDouble(this.h0.getText().toString().replaceAll(",", ""))) {
            return false;
        }
        Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.paid_amount_err), 0).show();
        return true;
    }

    public void E0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new P1(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(info.aalmoghalis.inventory.R.string.pref_item_type));
        dialog.show();
    }

    public void E1() throws Throwable {
        String string;
        Z00 z00 = this.i;
        ListView listView = this.Q;
        String strD1 = d1();
        if (this.z0.getText().length() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.i.X4("select bill_no2 as _id from bills where id=" + this.p));
            sb.append("");
            string = sb.toString();
        } else {
            string = this.z0.getText().toString();
        }
        z00.Na(listView, strD1, string, this.U.getText().toString(), this.Y.getHint().toString(), this.Y.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total), this.h0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_disc), this.b0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_tax) + " - " + this.e0.getText().toString() + CSS.Value.PERCENTAGE, this.f0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_other_cost), this.d0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.paid_amount), this.U0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.remain_amount), this.V0.getText().toString(), this.S.isChecked(), 5, this.A0.getText().toString(), this.q0.getText().toString(), this.a0.getText().toString(), this.i.ja("prefOthers_print_end_date", false), this.W.getText().toString(), this.t);
    }

    public void F0(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new Q1(textView, arrayAdapter, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void F1() {
        String string;
        Z00 z00 = this.i;
        ListView listView = this.Q;
        String strD1 = d1();
        if (this.z0.getText().length() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.i.X4("select bill_no2 as _id from bills where id=" + this.p));
            sb.append("");
            string = sb.toString();
        } else {
            string = this.z0.getText().toString();
        }
        z00.Ya(listView, strD1, string, this.U.getText().toString(), this.Y.getHint().toString(), this.Y.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total), this.h0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_disc), this.b0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_tax) + " - " + this.e0.getText().toString() + CSS.Value.PERCENTAGE, this.f0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_other_cost), this.d0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.paid_amount), this.U0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.remain_amount), this.V0.getText().toString(), this.S.isChecked(), 5, this.A0.getText().toString(), this.q0.getText().toString(), this.p + "", this.t, this.i.ja("prefOthers_print_end_date", false), this.W.getText().toString());
    }

    public void G0(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new S1(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void G1() {
        int i = this.L2;
        if (i == 1) {
            this.L2 = 2;
        } else if (i == 2) {
            this.L2 = 0;
        }
        this.I2 = false;
        this.r2 = true;
    }

    public void H0(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new R1(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void H1(int i) {
        String str;
        if (i == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle().toString());
        if (this.Y.getText().toString() == null) {
            str = "";
        } else {
            str = "#" + this.Y.getText().toString();
        }
        sb.append(str);
        this.O0 = sb.toString();
        if (this.H2 != 1) {
            this.H2 = 0;
            a2();
            return;
        }
        r0();
        F1();
        this.i.ra(this.i.ic(d1()) + ".pdf");
    }

    public void I0() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.F0(this);
            }
            s0();
            this.i.qe(this, this);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("adv_search_error=", e.getMessage() + "");
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0165 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0167 A[Catch: Exception -> 0x0055, TryCatch #1 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x005a, B:16:0x0074, B:18:0x0088, B:20:0x009c, B:22:0x00b0, B:26:0x00cc, B:28:0x0129, B:35:0x014c, B:36:0x0159, B:40:0x0167, B:42:0x0181), top: B:91:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0181 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #1 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x005a, B:16:0x0074, B:18:0x0088, B:20:0x009c, B:22:0x00b0, B:26:0x00cc, B:28:0x0129, B:35:0x014c, B:36:0x0159, B:40:0x0167, B:42:0x0181), top: B:91:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:49:0x01db  */
    /* JADX WARN: Code duplicated, block: B:51:0x01e0 A[Catch: Exception -> 0x01d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d8, blocks: (B:44:0x01ce, B:51:0x01e0, B:56:0x024b, B:62:0x02ad, B:67:0x02c2, B:71:0x02d2, B:74:0x02ef, B:76:0x03ab, B:79:0x03bc, B:81:0x03dd, B:83:0x03fa, B:66:0x02be, B:61:0x02a7), top: B:89:0x01ce }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0247  */
    /* JADX WARN: Code duplicated, block: B:55:0x024a  */
    /* JADX WARN: Code duplicated, block: B:59:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:65:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x02be A[Catch: Exception -> 0x01d8, TRY_ENTER, TryCatch #0 {Exception -> 0x01d8, blocks: (B:44:0x01ce, B:51:0x01e0, B:56:0x024b, B:62:0x02ad, B:67:0x02c2, B:71:0x02d2, B:74:0x02ef, B:76:0x03ab, B:79:0x03bc, B:81:0x03dd, B:83:0x03fa, B:66:0x02be, B:61:0x02a7), top: B:89:0x01ce }] */
    /* JADX WARN: Code duplicated, block: B:69:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:73:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:80:0x03db  */
    /* JADX WARN: Code duplicated, block: B:83:0x03fa A[Catch: Exception -> 0x01d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d8, blocks: (B:44:0x01ce, B:51:0x01e0, B:56:0x024b, B:62:0x02ad, B:67:0x02c2, B:71:0x02d2, B:74:0x02ef, B:76:0x03ab, B:79:0x03bc, B:81:0x03dd, B:83:0x03fa, B:66:0x02be, B:61:0x02a7), top: B:89:0x01ce }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0404  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x0181, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
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
    public boolean I1() {
        String str;
        double dIc;
        String str2;
        double d;
        String str3;
        long jL2;
        String str4;
        String str5;
        Object objValueOf;
        int i;
        Object objValueOf2;
        long j;
        String string;
        String string2;
        String string3;
        try {
            C2160f10.h = MO.b(this);
            boolean zA = AbstractC4371yX.a(this.G1);
            if (!AbstractC4371yX.a(this.I1)) {
                zA = false;
            }
            if (this.E1.getText().toString().trim().length() == 0 && this.F1.getText().toString().trim().length() == 0) {
                AbstractC4371yX.a(this.E1);
                AbstractC4371yX.a(this.F1);
                zA = false;
            }
            double d2 = this.E1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.E1.getText().toString().replaceAll(",", "")) : 0.0d;
            double d3 = this.F1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.F1.getText().toString().replaceAll(",", "")) : 0.0d;
            double d4 = Double.parseDouble(this.G1.getText().toString().replaceAll(",", ""));
            if (d2 > 0.0d && d3 > 0.0d) {
                str2 = "";
                String strS7 = this.i.S7(this.E1.getText().toString().replaceAll(",", str2));
                Z00 z00 = this.i;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                dIc = d2;
                str = "'";
                sb.append(Double.parseDouble(this.F1.getText().toString().replaceAll(",", str2)) / Double.parseDouble(this.G1.getText().toString().replaceAll(",", str2)));
                if (!strS7.equals(z00.S7(sb.toString()))) {
                    this.F1.setError(getString(info.aalmoghalis.inventory.R.string.total_not_correct));
                    d = 0.0d;
                    zA = false;
                }
                if (d3 >= d && d4 > d) {
                    dIc = this.i.Ic(String.valueOf(d3 / d4));
                }
                if (this.I1.getText().length() == 0) {
                    return false;
                }
                this.b2 = true;
                if (this.i.v8(this.I1.getText().toString(), 2).getCount() == 0) {
                    AutoCompleteTextView autoCompleteTextView = this.I1;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                    this.b2 = false;
                    str3 = str2;
                    try {
                        U0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.I1.getText().toString(), this, this.I1.getText().toString(), 2);
                        if (!this.b2) {
                            zA = false;
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.d("purchase_item_error=", e.getMessage());
                    }
                } else {
                    str3 = str2;
                }
                if (zA) {
                    return zA;
                }
                jL2 = this.i.l2();
                long jM2 = this.i.m2(2, this.T.isChecked() ? 1 : 0, this.l);
                C2160f10.F(this.i);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("insert into bills (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,time_,user_id,id2) values(");
                sb2.append(jL2);
                sb2.append(",");
                sb2.append(2);
                sb2.append(",'");
                sb2.append(this.X.getText().toString());
                sb2.append("','");
                sb2.append(String.valueOf(dIc * d4));
                sb2.append("','0',(select id from customers where name='");
                sb2.append((Object) this.I1.getText());
                sb2.append("'  ),2,");
                if (this.f2.isChecked()) {
                    str4 = "1";
                } else {
                    str4 = "2";
                }
                sb2.append(str4);
                sb2.append(",'");
                sb2.append(jM2);
                sb2.append("','',(select id from currency where name='");
                sb2.append(this.q0.getText().toString());
                sb2.append("') ,(select id from branches where name='");
                sb2.append(this.W.getText().toString());
                sb2.append("'),(select id from customers where name='");
                sb2.append(this.r0.getText().toString());
                sb2.append("'),");
                sb2.append(this.T.isChecked() ? 1 : 0);
                sb2.append(",");
                if (this.T.isChecked()) {
                    str5 = "0";
                    objValueOf = Long.valueOf(this.f1);
                } else {
                    objValueOf = "0";
                    str5 = objValueOf;
                }
                sb2.append(objValueOf);
                sb2.append(",strftime('%H:%M:%S','now','localtime'),");
                i = C2160f10.h;
                if (i == -1) {
                    objValueOf2 = "null";
                } else {
                    objValueOf2 = Integer.valueOf(i);
                }
                sb2.append(objValueOf2);
                sb2.append(",");
                j = this.p;
                if (j != 0) {
                    j = jL2;
                }
                sb2.append(j);
                sb2.append(")");
                string = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f2.isChecked() ? "1" : "2");
                sb3.append("#");
                sb3.append(this.f2.isChecked());
                Log.d("item_status=", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,unit_id,u_val,base_unit,qty_pr,e_date) values ( ");
                sb4.append(jL2);
                sb4.append(",(select id from items a where a.name='");
                sb4.append((Object) this.H1.getText());
                sb4.append("'),(select item_type_id from items a where a.name='");
                sb4.append((Object) this.H1.getText());
                sb4.append("'),'");
                sb4.append(this.G1.getText().toString().replaceAll(",", str3));
                sb4.append("','");
                sb4.append(this.G1.getText().toString().replaceAll(",", str3));
                sb4.append("','");
                sb4.append(String.valueOf(dIc));
                sb4.append("',(select id from currency where name='");
                sb4.append(this.q0.getText().toString());
                sb4.append("') ,0,(select unit_id from items where name='");
                sb4.append(this.H1.getText().toString());
                sb4.append("'),1,(select unit_id from items where name='");
                sb4.append(this.H1.getText().toString());
                sb4.append("'),");
                sb4.append(d4);
                sb4.append(",");
                if (this.G1.getTag() != null || this.G1.getTag().toString().length() == 0) {
                    string2 = "null";
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    String str6 = str;
                    sb5.append(str6);
                    sb5.append(this.G1.getTag().toString());
                    sb5.append(str6);
                    string2 = sb5.toString();
                }
                sb4.append(string2);
                sb4.append(")");
                string3 = sb4.toString();
                Log.d("sql1=", string);
                Log.d("sql2=", string3);
                if (this.i.H(string, string3) == 1) {
                    q2(this.p, str5);
                    K1();
                    return true;
                }
                return false;
                Log.d("purchase_item_error=", e.getMessage());
                return false;
            }
            str = "'";
            dIc = d2;
            str2 = "";
            d = 0.0d;
            if (d3 >= d) {
                dIc = this.i.Ic(String.valueOf(d3 / d4));
            }
            if (this.I1.getText().length() == 0) {
                return false;
            }
            this.b2 = true;
            if (this.i.v8(this.I1.getText().toString(), 2).getCount() == 0) {
                AutoCompleteTextView autoCompleteTextView2 = this.I1;
                autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                this.b2 = false;
                str3 = str2;
                U0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.I1.getText().toString(), this, this.I1.getText().toString(), 2);
                if (!this.b2) {
                    zA = false;
                }
            } else {
                str3 = str2;
            }
            if (zA) {
                return zA;
            }
            jL2 = this.i.l2();
            long jM3 = this.i.m2(2, this.T.isChecked() ? 1 : 0, this.l);
            C2160f10.F(this.i);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("insert into bills (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,time_,user_id,id2) values(");
            sb6.append(jL2);
            sb6.append(",");
            sb6.append(2);
            sb6.append(",'");
            sb6.append(this.X.getText().toString());
            sb6.append("','");
            sb6.append(String.valueOf(dIc * d4));
            sb6.append("','0',(select id from customers where name='");
            sb6.append((Object) this.I1.getText());
            sb6.append("'  ),2,");
            if (this.f2.isChecked()) {
                str4 = "1";
            } else {
                str4 = "2";
            }
            sb6.append(str4);
            sb6.append(",'");
            sb6.append(jM3);
            sb6.append("','',(select id from currency where name='");
            sb6.append(this.q0.getText().toString());
            sb6.append("') ,(select id from branches where name='");
            sb6.append(this.W.getText().toString());
            sb6.append("'),(select id from customers where name='");
            sb6.append(this.r0.getText().toString());
            sb6.append("'),");
            sb6.append(this.T.isChecked() ? 1 : 0);
            sb6.append(",");
            if (this.T.isChecked()) {
                objValueOf = "0";
                str5 = objValueOf;
            } else {
                str5 = "0";
                objValueOf = Long.valueOf(this.f1);
            }
            sb6.append(objValueOf);
            sb6.append(",strftime('%H:%M:%S','now','localtime'),");
            i = C2160f10.h;
            if (i == -1) {
                objValueOf2 = "null";
            } else {
                objValueOf2 = Integer.valueOf(i);
            }
            sb6.append(objValueOf2);
            sb6.append(",");
            j = this.p;
            if (j != 0) {
                j = jL2;
            }
            sb6.append(j);
            sb6.append(")");
            string = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.f2.isChecked() ? "1" : "2");
            sb7.append("#");
            sb7.append(this.f2.isChecked());
            Log.d("item_status=", sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,unit_id,u_val,base_unit,qty_pr,e_date) values ( ");
            sb8.append(jL2);
            sb8.append(",(select id from items a where a.name='");
            sb8.append((Object) this.H1.getText());
            sb8.append("'),(select item_type_id from items a where a.name='");
            sb8.append((Object) this.H1.getText());
            sb8.append("'),'");
            sb8.append(this.G1.getText().toString().replaceAll(",", str3));
            sb8.append("','");
            sb8.append(this.G1.getText().toString().replaceAll(",", str3));
            sb8.append("','");
            sb8.append(String.valueOf(dIc));
            sb8.append("',(select id from currency where name='");
            sb8.append(this.q0.getText().toString());
            sb8.append("') ,0,(select unit_id from items where name='");
            sb8.append(this.H1.getText().toString());
            sb8.append("'),1,(select unit_id from items where name='");
            sb8.append(this.H1.getText().toString());
            sb8.append("'),");
            sb8.append(d4);
            sb8.append(",");
            if (this.G1.getTag() != null) {
                string2 = "null";
            } else {
                string2 = "null";
            }
            sb8.append(string2);
            sb8.append(")");
            string3 = sb8.toString();
            Log.d("sql1=", string);
            Log.d("sql2=", string3);
            if (this.i.H(string, string3) == 1) {
                q2(this.p, str5);
                K1();
                return true;
            }
            return false;
        } catch (Exception e2) {
            e = e2;
        }
        Log.d("purchase_item_error=", e.getMessage());
        return false;
    }

    public void J0() {
        if (this.N2 != 0) {
            K0();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_back_back));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new J());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new K());
        builder.create().show();
    }

    public void J1() {
        if (getIntent().getStringExtra("TR_ID") == null) {
            this.M = false;
            return;
        }
        Log.d("read_bill=", getIntent().getStringExtra("TR_ID") + ":" + getIntent().getStringExtra("is_back") + ":" + getIntent().getStringExtra("b_bill_id"));
        if (!getIntent().getStringExtra("is_back").equals("0") && getIntent().getStringExtra("b_bill_id").equals("0")) {
            this.M = false;
        } else {
            this.M = true;
        }
        if (getIntent().getStringExtra("TR_DATE") != null) {
            this.q = getIntent().getStringExtra("TR_DATE");
        }
    }

    public void K0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_save));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new L());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new M());
        builder.create().show();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void K1() {
        if (this.p == 0) {
            EditText editText = this.z0;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(info.aalmoghalis.inventory.R.string.bill_no2));
            Z00 z00 = this.i;
            int i = this.t;
            boolean zIsChecked = this.T.isChecked();
            sb.append(z00.m2(i, zIsChecked ? 1 : 0, this.i.D2(this.W.getText().toString())));
            editText.setHint(sb.toString());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void L1() {
        EditText editText = this.z0;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(info.aalmoghalis.inventory.R.string.bill_no2));
        Z00 z00 = this.i;
        int i = this.t;
        boolean zIsChecked = this.T.isChecked();
        sb.append(z00.m2(i, zIsChecked ? 1 : 0, this.i.D2(this.W.getText().toString())));
        editText.setHint(sb.toString());
    }

    public void M0() {
        ArrayList arrayListG6 = this.i.G6();
        C2160f10.c0(this, this.x1, arrayListG6, 1);
        C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
        this.C0 = c1098Yv;
        c1098Yv.l.clear();
        this.C0.notifyDataSetChanged();
        this.x1.setThreshold(1);
        this.x1.setAdapter(this.C0);
        this.x1.setOnItemClickListener(new C2614p0());
        this.x1.setOnTouchListener(new ViewOnTouchListenerC2617q0());
        this.x1.addTextChangedListener(new C2620r0());
    }

    public void M1() {
        TextView textView;
        TextView textView2;
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.t = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.l = getIntent().getStringExtra("g_id");
                this.n = getIntent().getStringExtra("g_name");
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.t - 1]);
                sb.append(" ");
                sb.append(this.S.isChecked() ? getString(info.aalmoghalis.inventory.R.string.cash) : getString(info.aalmoghalis.inventory.R.string.post));
                setTitle(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.t - 1]);
                sb2.append(" ");
                sb2.append(this.S.isChecked() ? getString(info.aalmoghalis.inventory.R.string.cash) : getString(info.aalmoghalis.inventory.R.string.post));
                this.O0 = sb2.toString();
                if (getIntent().getStringExtra("bill_offer_id") == null) {
                    this.i.z0("delete from items_temp");
                }
                TextView textView3 = this.W;
                Z00 z00 = this.i;
                String str = this.l;
                if (str == null) {
                    str = "0";
                }
                textView3.setText(z00.C2(str));
                if (C2160f10.h != -1) {
                    this.W.setText(this.i.C2(C2160f10.i + ""));
                }
                int i = this.t;
                if (i == 2 && (textView2 = this.c0) != null) {
                    textView2.setText(getString(info.aalmoghalis.inventory.R.string.supp));
                } else if (i == 1 && (textView = this.c0) != null) {
                    textView.setText(getString(info.aalmoghalis.inventory.R.string.cus));
                }
                if (this.t == 2) {
                    this.S0.setVisibility(0);
                } else {
                    this.S0.setVisibility(8);
                }
                if (this.t == 1 && this.i.ja("prefOthers_sales_tax", false)) {
                    this.k0.setVisibility(8);
                    if (this.p == 0) {
                        this.e0.setText("0");
                    }
                }
                if (this.t == 2 && this.i.ja("prefOthers_purchases_tax", false)) {
                    this.k0.setVisibility(8);
                    if (this.p == 0) {
                        this.e0.setText("0");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void N0() {
        if (!q0()) {
            Context context = this.p1;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.qr), 0).show();
            return;
        }
        if (!q1() || p1()) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                    Context context2 = this.p1;
                    Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                Context context3 = this.p1;
                Toast.makeText(context3, context3.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        for (int size = this.F0.size() - 1; size >= 0; size--) {
            if (this.F0.valueAt(size)) {
                C0634Jt item = this.B0.getItem(this.F0.keyAt(size));
                this.B0.remove(item);
                this.i.v0("delete from items_temp where no_='" + item.f() + "'");
                q2(this.p, "0");
            }
        }
        this.q1 = 1;
        Z0();
        y1();
        this.q1 = 1;
        Z0();
        b2(false);
    }

    public void N1(String str) {
        AutoCompleteTextView autoCompleteTextView;
        if (!str.equals("") && this.i.da(str)) {
            String strI6 = this.i.I6(str);
            Z00.P0 = false;
            if (strI6.equals("")) {
                try {
                    this.i.j1(str, this, this.C0);
                } catch (Exception unused) {
                }
            }
            if (!strI6.equals("") || Z00.P0) {
                if (Z00.P0) {
                    strI6 = this.i.I6(str);
                }
                if (this.J1 == 2 || ((autoCompleteTextView = this.D1) != null && autoCompleteTextView.hasWindowFocus())) {
                    u1(strI6);
                } else {
                    t1(strI6);
                }
                if (this.y1 != null) {
                    Log.d("focus=", this.y1.hasWindowFocus() + ":" + this.B1.hasWindowFocus());
                }
                this.J1 = 0;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0057  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    public void O1() {
        Log.d("trace_priv", "" + this.p + ":" + p1() + ":" + this.H2);
        if (this.p == 0 || p1()) {
            return;
        }
        if (C2160f10.h > 0) {
            if (new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                if (A1()) {
                    return;
                }
            }
        } else if (A1()) {
            return;
        }
        this.Y.setEnabled(false);
        this.W.setEnabled(false);
        this.U.setEnabled(false);
        this.r0.setEnabled(false);
        this.q0.setEnabled(false);
        this.T.setEnabled(false);
        this.S.setEnabled(false);
        this.A0.setEnabled(false);
        this.z0.setEnabled(false);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02ab A[Catch: Exception -> 0x034a, TRY_LEAVE, TryCatch #3 {Exception -> 0x034a, blocks: (B:102:0x0291, B:104:0x02ab), top: B:284:0x0291 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x034e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0355 A[Catch: Exception -> 0x0343, TRY_LEAVE, TryCatch #12 {Exception -> 0x0343, blocks: (B:106:0x0335, B:114:0x0355, B:120:0x0379, B:122:0x0393, B:126:0x03b3, B:128:0x03c9, B:130:0x03e5, B:137:0x0416, B:139:0x041e, B:141:0x047d, B:143:0x048c, B:149:0x0533, B:157:0x055f, B:165:0x05b4), top: B:302:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0379 A[Catch: Exception -> 0x0343, TRY_ENTER, TryCatch #12 {Exception -> 0x0343, blocks: (B:106:0x0335, B:114:0x0355, B:120:0x0379, B:122:0x0393, B:126:0x03b3, B:128:0x03c9, B:130:0x03e5, B:137:0x0416, B:139:0x041e, B:141:0x047d, B:143:0x048c, B:149:0x0533, B:157:0x055f, B:165:0x05b4), top: B:302:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x03b3 A[Catch: Exception -> 0x0343, TRY_ENTER, TryCatch #12 {Exception -> 0x0343, blocks: (B:106:0x0335, B:114:0x0355, B:120:0x0379, B:122:0x0393, B:126:0x03b3, B:128:0x03c9, B:130:0x03e5, B:137:0x0416, B:139:0x041e, B:141:0x047d, B:143:0x048c, B:149:0x0533, B:157:0x055f, B:165:0x05b4), top: B:302:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x040b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:137:0x0416 A[Catch: Exception -> 0x0343, TRY_ENTER, TryCatch #12 {Exception -> 0x0343, blocks: (B:106:0x0335, B:114:0x0355, B:120:0x0379, B:122:0x0393, B:126:0x03b3, B:128:0x03c9, B:130:0x03e5, B:137:0x0416, B:139:0x041e, B:141:0x047d, B:143:0x048c, B:149:0x0533, B:157:0x055f, B:165:0x05b4), top: B:302:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x052a  */
    /* JADX WARN: Code duplicated, block: B:149:0x0533 A[Catch: Exception -> 0x0343, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x0343, blocks: (B:106:0x0335, B:114:0x0355, B:120:0x0379, B:122:0x0393, B:126:0x03b3, B:128:0x03c9, B:130:0x03e5, B:137:0x0416, B:139:0x041e, B:141:0x047d, B:143:0x048c, B:149:0x0533, B:157:0x055f, B:165:0x05b4), top: B:302:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0548 A[Catch: Exception -> 0x06ff, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x06ff, blocks: (B:118:0x035b, B:123:0x03a4, B:134:0x040d, B:146:0x052c, B:153:0x0548, B:168:0x05c9, B:171:0x061a, B:174:0x0621, B:176:0x0629, B:178:0x0634), top: B:290:0x035b }] */
    /* JADX WARN: Code duplicated, block: B:156:0x055d  */
    /* JADX WARN: Code duplicated, block: B:159:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:162:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:164:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:167:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:171:0x061a A[Catch: Exception -> 0x06ff, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x06ff, blocks: (B:118:0x035b, B:123:0x03a4, B:134:0x040d, B:146:0x052c, B:153:0x0548, B:168:0x05c9, B:171:0x061a, B:174:0x0621, B:176:0x0629, B:178:0x0634), top: B:290:0x035b }] */
    /* JADX WARN: Code duplicated, block: B:174:0x0621 A[Catch: Exception -> 0x06ff, TRY_ENTER, TryCatch #6 {Exception -> 0x06ff, blocks: (B:118:0x035b, B:123:0x03a4, B:134:0x040d, B:146:0x052c, B:153:0x0548, B:168:0x05c9, B:171:0x061a, B:174:0x0621, B:176:0x0629, B:178:0x0634), top: B:290:0x035b }] */
    /* JADX WARN: Code duplicated, block: B:195:0x0702  */
    /* JADX WARN: Code duplicated, block: B:198:0x0718 A[Catch: Exception -> 0x06eb, TryCatch #2 {Exception -> 0x06eb, blocks: (B:180:0x0690, B:182:0x0697, B:184:0x069f, B:186:0x06cc, B:190:0x06f0, B:196:0x0710, B:198:0x0718, B:200:0x071c, B:204:0x0725, B:206:0x0750, B:208:0x0770, B:211:0x078a, B:213:0x0819, B:215:0x081d, B:217:0x0825), top: B:283:0x0690 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x077c  */
    /* JADX WARN: Code duplicated, block: B:213:0x0819 A[Catch: Exception -> 0x06eb, TryCatch #2 {Exception -> 0x06eb, blocks: (B:180:0x0690, B:182:0x0697, B:184:0x069f, B:186:0x06cc, B:190:0x06f0, B:196:0x0710, B:198:0x0718, B:200:0x071c, B:204:0x0725, B:206:0x0750, B:208:0x0770, B:211:0x078a, B:213:0x0819, B:215:0x081d, B:217:0x0825), top: B:283:0x0690 }] */
    /* JADX WARN: Code duplicated, block: B:223:0x0888  */
    /* JADX WARN: Code duplicated, block: B:226:0x088f A[Catch: Exception -> 0x08ac, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:236:0x08b5 A[Catch: Exception -> 0x08ac, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:240:0x08d7 A[Catch: Exception -> 0x08ac, TRY_LEAVE, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:243:0x0901 A[Catch: Exception -> 0x08ac, TRY_ENTER, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:245:0x0907 A[Catch: Exception -> 0x08ac, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:248:0x09ba A[Catch: Exception -> 0x08ac, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:252:0x09e6  */
    /* JADX WARN: Code duplicated, block: B:254:0x0a04 A[Catch: Exception -> 0x08ac, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:256:0x0a0c A[Catch: Exception -> 0x08ac, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:259:0x0acd A[Catch: Exception -> 0x08ac, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:263:0x0af9  */
    /* JADX WARN: Code duplicated, block: B:266:0x0b13 A[Catch: Exception -> 0x08ac, TryCatch #1 {Exception -> 0x08ac, blocks: (B:240:0x08d7, B:243:0x0901, B:245:0x0907, B:246:0x090a, B:248:0x09ba, B:251:0x09c9, B:253:0x09e8, B:267:0x0b19, B:254:0x0a04, B:256:0x0a0c, B:257:0x0a0f, B:259:0x0acd, B:262:0x0adc, B:264:0x0afb, B:266:0x0b13, B:224:0x088a, B:226:0x088f, B:231:0x089d, B:234:0x08b0, B:236:0x08b5, B:238:0x08c7), top: B:281:0x088a }] */
    /* JADX WARN: Code duplicated, block: B:284:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00dd A[Catch: Exception -> 0x00c1, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x00c1, blocks: (B:34:0x00a1, B:36:0x00b5, B:43:0x00dd, B:48:0x0106, B:53:0x012f, B:55:0x0155, B:57:0x016c, B:59:0x0176), top: B:306:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:48:0x0106 A[Catch: Exception -> 0x00c1, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x00c1, blocks: (B:34:0x00a1, B:36:0x00b5, B:43:0x00dd, B:48:0x0106, B:53:0x012f, B:55:0x0155, B:57:0x016c, B:59:0x0176), top: B:306:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0119  */
    /* JADX WARN: Code duplicated, block: B:53:0x012f A[Catch: Exception -> 0x00c1, TRY_ENTER, TryCatch #14 {Exception -> 0x00c1, blocks: (B:34:0x00a1, B:36:0x00b5, B:43:0x00dd, B:48:0x0106, B:53:0x012f, B:55:0x0155, B:57:0x016c, B:59:0x0176), top: B:306:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0155 A[Catch: Exception -> 0x00c1, TryCatch #14 {Exception -> 0x00c1, blocks: (B:34:0x00a1, B:36:0x00b5, B:43:0x00dd, B:48:0x0106, B:53:0x012f, B:55:0x0155, B:57:0x016c, B:59:0x0176), top: B:306:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x016a  */
    /* JADX WARN: Code duplicated, block: B:59:0x0176 A[Catch: Exception -> 0x00c1, TRY_LEAVE, TryCatch #14 {Exception -> 0x00c1, blocks: (B:34:0x00a1, B:36:0x00b5, B:43:0x00dd, B:48:0x0106, B:53:0x012f, B:55:0x0155, B:57:0x016c, B:59:0x0176), top: B:306:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x018f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0239  */
    /* JADX WARN: Code duplicated, block: B:87:0x0244  */
    /* JADX WARN: Code duplicated, block: B:94:0x0267  */
    /* JADX WARN: Code duplicated, block: B:97:0x0278 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:99:0x027a A[Catch: Exception -> 0x0b37, TRY_LEAVE, TryCatch #4 {Exception -> 0x0b37, blocks: (B:95:0x026c, B:99:0x027a), top: B:286:0x026c }] */
    /* JADX WARN: Instruction removed from duplicated block: B:104:0x02ab, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:240:0x08d7, please report this as an issue */
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
    public boolean P0() {
        String str;
        Exception exc;
        boolean z;
        boolean z2;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        String str2;
        double d6;
        Exception e;
        Bill_edit bill_edit;
        double d7;
        double dIc;
        String str3;
        boolean z3;
        double d8;
        String str4;
        String str5;
        String str6;
        double d9;
        String str7;
        double dF1;
        double d10;
        double d11;
        String str8;
        String str9;
        String str10;
        String str11;
        double dG1;
        TextView textView;
        String str12;
        TextView textView2;
        String str13;
        double dB0;
        if (!q0()) {
            Context context = this.p1;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.qr), 0).show();
            return false;
        }
        if (!q1() || p1()) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                    Context context2 = this.p1;
                    Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return false;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                Context context3 = this.p1;
                Toast.makeText(context3, context3.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        }
        try {
            boolean zA = AbstractC4371yX.a(this.B1);
            try {
                if (!AbstractC4371yX.a(this.D1)) {
                    zA = false;
                }
                if (this.y1.getText().toString().trim().length() == 0) {
                    try {
                        if (this.z1.getText().toString().trim().length() == 0) {
                            AbstractC4371yX.a(this.y1);
                            AbstractC4371yX.a(this.z1);
                            zA = false;
                        }
                        try {
                            if (this.y1.getText().toString().trim().length() > 0) {
                                d = Double.parseDouble(this.y1.getText().toString().replaceAll(",", ""));
                            } else {
                                d = 0.0d;
                            }
                            if (this.z1.getText().toString().trim().length() > 0) {
                                d2 = Double.parseDouble(this.z1.getText().toString().replaceAll(",", ""));
                            } else {
                                d2 = 0.0d;
                            }
                            if (this.B1.getText().toString().trim().length() > 0) {
                                dB0 = Double.parseDouble(this.B1.getText().toString().replaceAll(",", ""));
                                if (this.y1.getTag().toString().trim().length() > 0) {
                                    d3 = Double.parseDouble(this.y1.getTag().toString().replaceAll(",", ""));
                                } else {
                                    d3 = 1.0d;
                                }
                                if (this.i.ja("prefOthers_qty_pr", false)) {
                                    dB0 = this.i.b0(this.B1.getText().toString().replaceAll(",", ""), d3);
                                }
                                d4 = dB0;
                            } else {
                                d3 = 1.0d;
                                d4 = 0.0d;
                            }
                            try {
                                if (d > 0.0d || d2 <= 0.0d) {
                                    z2 = zA;
                                    d5 = d3;
                                } else {
                                    try {
                                        String strS7 = this.i.S7(this.y1.getText().toString().replaceAll(",", ""));
                                        Z00 z00 = this.i;
                                        z2 = zA;
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("");
                                            d5 = d3;
                                            sb.append(Double.parseDouble(this.z1.getText().toString().replaceAll(",", "")) / d4);
                                            if (!strS7.equals(z00.S7(sb.toString()))) {
                                                EditText editText = this.z1;
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(getString(info.aalmoghalis.inventory.R.string.total_not_correct));
                                                sb2.append("#");
                                                Z00 z01 = this.i;
                                                StringBuilder sb3 = new StringBuilder();
                                                sb3.append("");
                                                str2 = "";
                                                try {
                                                    sb3.append(d * d4);
                                                    sb2.append(z01.S7(sb3.toString()));
                                                    sb2.append("#");
                                                    sb2.append(d2);
                                                    editText.setError(sb2.toString());
                                                    d6 = 0.0d;
                                                    z2 = false;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    exc = e;
                                                    z = z2;
                                                    str = str2;
                                                    Log.d("edit_item_error=", exc.getMessage() + str);
                                                    exc.printStackTrace();
                                                    return z;
                                                }
                                            }
                                            if (d2 >= d6 || d4 <= d6) {
                                                bill_edit = this;
                                                d7 = d;
                                                dIc = 0.0d;
                                            } else {
                                                double d12 = d2 / d4;
                                                Bill_edit bill_edit2 = this;
                                                try {
                                                    double dIc2 = bill_edit2.i.Ic(String.valueOf(d12));
                                                    dIc = bill_edit2.i.Ic(String.valueOf(d12 / d5));
                                                    d7 = dIc2;
                                                    bill_edit = bill_edit2;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    exc = e;
                                                    z = z2;
                                                    str = str2;
                                                }
                                            }
                                            if (bill_edit.D1.getText().length() == 0) {
                                                return false;
                                            }
                                            if (bill_edit.i.F6().contains(bill_edit.D1.getText().toString())) {
                                                str3 = str2;
                                                d8 = d5;
                                                z3 = true;
                                                if (z3) {
                                                }
                                                if (!bill_edit.D1.getText().toString().equals(bill_edit.D1.getText().toString().trim())) {
                                                    AutoCompleteTextView autoCompleteTextView = bill_edit.D1;
                                                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                                                }
                                                bill_edit.i.D = false;
                                                str4 = "0";
                                                if (bill_edit.q0.getText() != null) {
                                                    bill_edit.i.u(bill_edit, bill_edit.q0.getText().toString(), bill_edit.U.getText().toString(), bill_edit.getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                                                    if (!bill_edit.i.D) {
                                                        return false;
                                                    }
                                                }
                                                str5 = "'),0),'";
                                                str6 = "prefOthers_update_item_price";
                                                if (bill_edit.t == 1) {
                                                    d9 = d4;
                                                } else {
                                                    d9 = d4;
                                                }
                                                str7 = ":";
                                                if (bill_edit.t != 1) {
                                                    dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                                    if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                                        dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                                        Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                                        if (dG1 < 0.0d) {
                                                            if (dG1 < 0.0d) {
                                                                dF1 = 0.0d;
                                                            }
                                                        } else if (dG1 < 0.0d) {
                                                            dF1 = 0.0d;
                                                        }
                                                        bill_edit.t1 = bill_edit.C1.getText().toString();
                                                    }
                                                    d10 = dF1;
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append(bill_edit.p);
                                                    sb4.append(":");
                                                    sb4.append(bill_edit.J);
                                                    sb4.append(":q1=");
                                                    sb4.append(d10);
                                                    sb4.append(":q2=");
                                                    d11 = d9 * d8;
                                                    sb4.append(C1839c10.C(d11, C1839c10.d));
                                                    sb4.append(":q3=");
                                                    sb4.append(d11);
                                                    sb4.append(":");
                                                    sb4.append(bill_edit.M);
                                                    Log.d("item_qty=", sb4.toString());
                                                    if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                                        if (bill_edit.t == 1) {
                                                            str9 = "(";
                                                            str = str3;
                                                        } else {
                                                            str9 = "(";
                                                            str = str3;
                                                        }
                                                        if (!bill_edit.T.isChecked()) {
                                                        }
                                                    } else {
                                                        str4 = "0";
                                                        str8 = str8;
                                                        str5 = str5;
                                                        str6 = str6;
                                                        str7 = ":";
                                                        d7 = d7;
                                                        str = str3;
                                                    }
                                                    double dJ6 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                                    double dK6 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                                    if (bill_edit.i.ja(str6, true)) {
                                                        z = z2;
                                                    } else {
                                                        z = z2;
                                                    }
                                                    if (bill_edit.t == 1) {
                                                        bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                                    }
                                                    if (O2 != 2) {
                                                        bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                                    }
                                                    if (z) {
                                                        Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                                        if (O2 == 2) {
                                                            if (bill_edit.p != 0) {
                                                                g2();
                                                            }
                                                            Z00 z02 = bill_edit.i;
                                                            StringBuilder sb5 = new StringBuilder();
                                                            sb5.append("update items_temp set item_id=(select id from items a where a.name='");
                                                            sb5.append((Object) bill_edit.D1.getText());
                                                            sb5.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                                            sb5.append((Object) bill_edit.D1.getText());
                                                            sb5.append("'),qty='");
                                                            sb5.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                            sb5.append("',qty_t='");
                                                            sb5.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                            sb5.append("',price='");
                                                            sb5.append(String.valueOf(dIc));
                                                            sb5.append("',unit_id=ifnull((select id from units where code='");
                                                            sb5.append(bill_edit.L1.getText().toString());
                                                            sb5.append("'),0),u_val='");
                                                            sb5.append(String.valueOf(d8));
                                                            sb5.append("',qty_pr=");
                                                            sb5.append(d9);
                                                            sb5.append(",curr_id=(select id from currency where name='");
                                                            sb5.append(bill_edit.q0.getText().toString());
                                                            sb5.append("') ,remark='");
                                                            sb5.append(bill_edit.A1.getText().toString());
                                                            sb5.append("',e_date=");
                                                            textView2 = bill_edit.C1;
                                                            if (textView2 != null) {
                                                                str13 = "''";
                                                            } else {
                                                                str13 = "''";
                                                            }
                                                            sb5.append(str13);
                                                            sb5.append(" where no_='");
                                                            sb5.append(bill_edit.J);
                                                            sb5.append("'");
                                                            z02.v0(sb5.toString());
                                                            k2();
                                                        } else {
                                                            double d13 = d9;
                                                            if (bill_edit.p != 0) {
                                                                g2();
                                                            }
                                                            Z00 z03 = bill_edit.i;
                                                            StringBuilder sb6 = new StringBuilder();
                                                            sb6.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                                            sb6.append((Object) bill_edit.D1.getText());
                                                            sb6.append("'),(select item_type_id from items a where a.name='");
                                                            sb6.append((Object) bill_edit.D1.getText());
                                                            sb6.append("'),'");
                                                            sb6.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                            sb6.append("','");
                                                            sb6.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                            sb6.append("','");
                                                            sb6.append(String.valueOf(dIc));
                                                            sb6.append("',(select id from currency where name='");
                                                            sb6.append(bill_edit.q0.getText().toString());
                                                            sb6.append("'),'");
                                                            sb6.append(bill_edit.A1.getText().toString());
                                                            sb6.append("',ifnull((select id from units where code='");
                                                            sb6.append(bill_edit.L1.getText().toString());
                                                            sb6.append(str5);
                                                            sb6.append(String.valueOf(d8));
                                                            sb6.append("',(select unit_id from items where name='");
                                                            sb6.append(bill_edit.D1.getText().toString());
                                                            sb6.append("'),");
                                                            sb6.append(d13);
                                                            sb6.append(str8);
                                                            textView = bill_edit.C1;
                                                            if (textView != null) {
                                                                str12 = "''";
                                                            } else {
                                                                str12 = "''";
                                                            }
                                                            sb6.append(str12);
                                                            sb6.append(" )");
                                                            z03.v0(sb6.toString());
                                                            k2();
                                                            if (bill_edit.p == 0) {
                                                                Z0();
                                                                y1();
                                                            }
                                                        }
                                                        bill_edit.x1.setText(str);
                                                        M0();
                                                        bill_edit.q1 = 1;
                                                        Z0();
                                                        y1();
                                                        bill_edit.q1 = 1;
                                                        Z0();
                                                        bill_edit.q2(bill_edit.p, str4);
                                                    }
                                                } else {
                                                    dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                                    if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                                        dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                                        Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                                        if (dG1 < 0.0d) {
                                                            if (dG1 < 0.0d) {
                                                                dF1 = 0.0d;
                                                            }
                                                        } else if (dG1 < 0.0d) {
                                                            dF1 = 0.0d;
                                                        }
                                                        bill_edit.t1 = bill_edit.C1.getText().toString();
                                                    }
                                                    d10 = dF1;
                                                    StringBuilder sb7 = new StringBuilder();
                                                    sb7.append(bill_edit.p);
                                                    sb7.append(":");
                                                    sb7.append(bill_edit.J);
                                                    sb7.append(":q1=");
                                                    sb7.append(d10);
                                                    sb7.append(":q2=");
                                                    d11 = d9 * d8;
                                                    sb7.append(C1839c10.C(d11, C1839c10.d));
                                                    sb7.append(":q3=");
                                                    sb7.append(d11);
                                                    sb7.append(":");
                                                    sb7.append(bill_edit.M);
                                                    Log.d("item_qty=", sb7.toString());
                                                    if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                                        if (bill_edit.t == 1) {
                                                            str9 = "(";
                                                            str = str3;
                                                        } else {
                                                            str9 = "(";
                                                            str = str3;
                                                        }
                                                        if (!bill_edit.T.isChecked()) {
                                                        }
                                                    } else {
                                                        str4 = "0";
                                                        str8 = str8;
                                                        str5 = str5;
                                                        str6 = str6;
                                                        str7 = ":";
                                                        d7 = d7;
                                                        str = str3;
                                                    }
                                                    double dJ7 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                                    double dK7 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                                    if (bill_edit.i.ja(str6, true)) {
                                                        z = z2;
                                                    } else {
                                                        z = z2;
                                                    }
                                                    if (bill_edit.t == 1) {
                                                        bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                                    }
                                                    if (O2 != 2) {
                                                        bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                                    }
                                                    if (z) {
                                                        Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                                        if (O2 == 2) {
                                                            if (bill_edit.p != 0) {
                                                                g2();
                                                            }
                                                            Z00 z04 = bill_edit.i;
                                                            StringBuilder sb8 = new StringBuilder();
                                                            sb8.append("update items_temp set item_id=(select id from items a where a.name='");
                                                            sb8.append((Object) bill_edit.D1.getText());
                                                            sb8.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                                            sb8.append((Object) bill_edit.D1.getText());
                                                            sb8.append("'),qty='");
                                                            sb8.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                            sb8.append("',qty_t='");
                                                            sb8.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                            sb8.append("',price='");
                                                            sb8.append(String.valueOf(dIc));
                                                            sb8.append("',unit_id=ifnull((select id from units where code='");
                                                            sb8.append(bill_edit.L1.getText().toString());
                                                            sb8.append("'),0),u_val='");
                                                            sb8.append(String.valueOf(d8));
                                                            sb8.append("',qty_pr=");
                                                            sb8.append(d9);
                                                            sb8.append(",curr_id=(select id from currency where name='");
                                                            sb8.append(bill_edit.q0.getText().toString());
                                                            sb8.append("') ,remark='");
                                                            sb8.append(bill_edit.A1.getText().toString());
                                                            sb8.append("',e_date=");
                                                            textView2 = bill_edit.C1;
                                                            if (textView2 != null) {
                                                                str13 = "''";
                                                            } else {
                                                                str13 = "''";
                                                            }
                                                            sb8.append(str13);
                                                            sb8.append(" where no_='");
                                                            sb8.append(bill_edit.J);
                                                            sb8.append("'");
                                                            z04.v0(sb8.toString());
                                                            k2();
                                                        } else {
                                                            double d14 = d9;
                                                            if (bill_edit.p != 0) {
                                                                g2();
                                                            }
                                                            Z00 z05 = bill_edit.i;
                                                            StringBuilder sb9 = new StringBuilder();
                                                            sb9.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                                            sb9.append((Object) bill_edit.D1.getText());
                                                            sb9.append("'),(select item_type_id from items a where a.name='");
                                                            sb9.append((Object) bill_edit.D1.getText());
                                                            sb9.append("'),'");
                                                            sb9.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                            sb9.append("','");
                                                            sb9.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                            sb9.append("','");
                                                            sb9.append(String.valueOf(dIc));
                                                            sb9.append("',(select id from currency where name='");
                                                            sb9.append(bill_edit.q0.getText().toString());
                                                            sb9.append("'),'");
                                                            sb9.append(bill_edit.A1.getText().toString());
                                                            sb9.append("',ifnull((select id from units where code='");
                                                            sb9.append(bill_edit.L1.getText().toString());
                                                            sb9.append(str5);
                                                            sb9.append(String.valueOf(d8));
                                                            sb9.append("',(select unit_id from items where name='");
                                                            sb9.append(bill_edit.D1.getText().toString());
                                                            sb9.append("'),");
                                                            sb9.append(d14);
                                                            sb9.append(str8);
                                                            textView = bill_edit.C1;
                                                            if (textView != null) {
                                                                str12 = "''";
                                                            } else {
                                                                str12 = "''";
                                                            }
                                                            sb9.append(str12);
                                                            sb9.append(" )");
                                                            z05.v0(sb9.toString());
                                                            k2();
                                                            if (bill_edit.p == 0) {
                                                                Z0();
                                                                y1();
                                                            }
                                                        }
                                                        bill_edit.x1.setText(str);
                                                        M0();
                                                        bill_edit.q1 = 1;
                                                        Z0();
                                                        y1();
                                                        bill_edit.q1 = 1;
                                                        Z0();
                                                        bill_edit.q2(bill_edit.p, str4);
                                                    }
                                                }
                                                Log.d("edit_item_error=", exc.getMessage() + str);
                                                exc.printStackTrace();
                                            } else {
                                                try {
                                                    if (bill_edit.i.F6().contains(bill_edit.D1.getText().toString().trim())) {
                                                        str3 = str2;
                                                        d8 = d5;
                                                        z3 = true;
                                                    } else {
                                                        AutoCompleteTextView autoCompleteTextView2 = bill_edit.D1;
                                                        autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                                                        bill_edit.s1 = bill_edit.D1.getText().toString();
                                                        bill_edit.V0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item), bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item) + bill_edit.s1, bill_edit);
                                                        ArrayList arrayListG6 = bill_edit.i.G6();
                                                        C2160f10.c0(bill_edit, bill_edit.D1, arrayListG6, 2);
                                                        C1098Yv c1098Yv = new C1098Yv(bill_edit, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
                                                        bill_edit.C0 = c1098Yv;
                                                        c1098Yv.l.clear();
                                                        bill_edit.C0.notifyDataSetChanged();
                                                        bill_edit.D1.setAdapter(bill_edit.C0);
                                                        bill_edit.y1.setTag("1");
                                                        bill_edit.L1.setVisibility(8);
                                                        bill_edit.L1.setText(bill_edit.i.X6(bill_edit.D1.getText().toString()));
                                                        str3 = str2;
                                                        try {
                                                            bill_edit.C1.setText(str3);
                                                            bill_edit.q2(bill_edit.p, "-1");
                                                            z3 = false;
                                                            d8 = 1.0d;
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            exc = e;
                                                            str = str3;
                                                            z = z2;
                                                        }
                                                    }
                                                    if (z3 && !bill_edit.b2) {
                                                        return false;
                                                    }
                                                    try {
                                                        if (!bill_edit.D1.getText().toString().equals(bill_edit.D1.getText().toString().trim()) && bill_edit.i.F6().contains(bill_edit.D1.getText().toString().trim())) {
                                                            AutoCompleteTextView autoCompleteTextView3 = bill_edit.D1;
                                                            autoCompleteTextView3.setText(autoCompleteTextView3.getText().toString().trim());
                                                        }
                                                        bill_edit.i.D = false;
                                                        str4 = "0";
                                                        if (bill_edit.q0.getText() != null && !bill_edit.q0.getText().toString().equals(bill_edit.i.l3("0")) && bill_edit.i.Z2(bill_edit.q0.getText().toString(), bill_edit.U.getText().toString()) == 0) {
                                                            bill_edit.i.u(bill_edit, bill_edit.q0.getText().toString(), bill_edit.U.getText().toString(), bill_edit.getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                                                            if (!bill_edit.i.D) {
                                                                return false;
                                                            }
                                                        }
                                                        str5 = "'),0),'";
                                                        str6 = "prefOthers_update_item_price";
                                                        if (bill_edit.t == 1 || bill_edit.T.isChecked()) {
                                                            d9 = d4;
                                                        } else {
                                                            Z00 z06 = bill_edit.i;
                                                            String string = bill_edit.D1.getText().toString();
                                                            String string2 = bill_edit.q0.getText().toString();
                                                            boolean zIsChecked = bill_edit.T.isChecked();
                                                            StringBuilder sb10 = new StringBuilder();
                                                            d9 = d4;
                                                            sb10.append(bill_edit.f1);
                                                            sb10.append(str3);
                                                            if (!bill_edit.i.S7(String.valueOf(z06.J6(string, string2, 1, zIsChecked, sb10.toString(), bill_edit.t, bill_edit.L1.getText().toString()))).equals(bill_edit.i.S7(String.valueOf(d7)))) {
                                                                bill_edit.k2 = String.valueOf(d7);
                                                                if (bill_edit.i.ja("prefOthers_update_item_price", true)) {
                                                                    bill_edit.i.H("delete from item_price where item_id=(select a.id from items a where a.name='" + bill_edit.D1.getText().toString() + "') and curr_id=(select a.id from currency a where a.name='" + bill_edit.q0.getText().toString() + "') and unit_id=ifnull((select id from units where code='" + bill_edit.L1.getText().toString() + "'),0)", "insert into item_price(item_id,curr_id,unit_id,SLS_U_PRICE) values ((select a.id from items a where a.name='" + bill_edit.D1.getText().toString() + "'),(select a.id from currency a where a.name='" + bill_edit.q0.getText().toString() + "'),ifnull((select id from units where code='" + bill_edit.L1.getText().toString() + "'),0),'" + bill_edit.k2 + "')");
                                                                    bill_edit.i.ja("online_server", false);
                                                                }
                                                            }
                                                        }
                                                        str7 = ":";
                                                        if (bill_edit.t != 1 || bill_edit.T.isChecked()) {
                                                            dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                                            if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                                                dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                                                Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                                                if (dG1 < 0.0d && dG1 <= dF1) {
                                                                    dF1 = dG1;
                                                                } else if (dG1 < 0.0d) {
                                                                    dF1 = 0.0d;
                                                                }
                                                                bill_edit.t1 = bill_edit.C1.getText().toString();
                                                            }
                                                            d10 = dF1;
                                                            StringBuilder sb11 = new StringBuilder();
                                                            sb11.append(bill_edit.p);
                                                            sb11.append(":");
                                                            sb11.append(bill_edit.J);
                                                            sb11.append(":q1=");
                                                            sb11.append(d10);
                                                            sb11.append(":q2=");
                                                            d11 = d9 * d8;
                                                            sb11.append(C1839c10.C(d11, C1839c10.d));
                                                            sb11.append(":q3=");
                                                            sb11.append(d11);
                                                            sb11.append(":");
                                                            sb11.append(bill_edit.M);
                                                            Log.d("item_qty=", sb11.toString());
                                                            if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                                                if (bill_edit.t == 1 || bill_edit.T.isChecked() || bill_edit.i.ja("prefOthers_sales_out_qty", false)) {
                                                                    str9 = "(";
                                                                    str = str3;
                                                                } else {
                                                                    bill_edit.b2 = false;
                                                                    bill_edit.s1 = C1839c10.v(String.valueOf(C1839c10.C(d11, C1839c10.d) - d10), C1839c10.d);
                                                                    str9 = "(";
                                                                    str = str3;
                                                                    try {
                                                                        X0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_purchase), bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_purchase) + " " + bill_edit.s1, this, bill_edit.D1.getText().toString(), bill_edit.s1, bill_edit.t1);
                                                                        if (!bill_edit.b2 && !bill_edit.T.isChecked()) {
                                                                            EditText editText2 = bill_edit.B1;
                                                                            StringBuilder sb12 = new StringBuilder();
                                                                            sb12.append(bill_edit.getString(info.aalmoghalis.inventory.R.string.bal_net));
                                                                            sb12.append(" ");
                                                                            sb12.append(bill_edit.i.S7(String.valueOf(d10 / d8)).replaceAll(",", str));
                                                                            if (bill_edit.C1 != null) {
                                                                                str11 = str9 + bill_edit.C1.getText().toString() + ")";
                                                                            } else {
                                                                                str11 = str;
                                                                            }
                                                                            sb12.append(str11);
                                                                            editText2.setError(sb12.toString());
                                                                            return false;
                                                                        }
                                                                    } catch (Exception e5) {
                                                                        e = e5;
                                                                        exc = e;
                                                                        z = z2;
                                                                    }
                                                                }
                                                                if (!bill_edit.T.isChecked() && (bill_edit.M || bill_edit.t == 2)) {
                                                                    EditText editText3 = bill_edit.B1;
                                                                    StringBuilder sb13 = new StringBuilder();
                                                                    sb13.append(bill_edit.getString(info.aalmoghalis.inventory.R.string.bal_back));
                                                                    sb13.append(" ");
                                                                    sb13.append(bill_edit.i.S7(String.valueOf(d10 / d8)).replaceAll(",", str));
                                                                    if (bill_edit.C1 != null) {
                                                                        str10 = str9 + bill_edit.C1.getText().toString() + ")";
                                                                    } else {
                                                                        str10 = str;
                                                                    }
                                                                    sb13.append(str10);
                                                                    editText3.setError(sb13.toString());
                                                                    return false;
                                                                }
                                                            } else {
                                                                str4 = "0";
                                                                str8 = str8;
                                                                str5 = str5;
                                                                str6 = str6;
                                                                str7 = ":";
                                                                d7 = d7;
                                                                str = str3;
                                                            }
                                                            double dJ8 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                                            double dK8 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                                            if (bill_edit.i.ja(str6, true) || bill_edit.t != 1 || bill_edit.T.isChecked() || bill_edit.i.S7(String.valueOf(dJ8)).equals(bill_edit.i.S7(String.valueOf(d7)))) {
                                                                z = z2;
                                                            } else {
                                                                try {
                                                                    bill_edit.y1.setError(bill_edit.getString(info.aalmoghalis.inventory.R.string.sales_price) + " " + dJ8 + "#\n" + bill_edit.i.S7(String.valueOf(d7)) + StringUtilities.LF + bill_edit.i.S7(String.valueOf(dJ8)));
                                                                    z = false;
                                                                } catch (Exception e6) {
                                                                    exc = e6;
                                                                    z = false;
                                                                    Log.d("edit_item_error=", exc.getMessage() + str);
                                                                    exc.printStackTrace();
                                                                }
                                                            }
                                                            try {
                                                                if (bill_edit.t == 1 && !bill_edit.T.isChecked() && z && d7 < dK8) {
                                                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                                                }
                                                                if (O2 != 2 && bill_edit.i.q7(bill_edit.D1.getText().toString()) > 0) {
                                                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                                                }
                                                            } catch (Exception e7) {
                                                                exc = e7;
                                                                Log.d("edit_item_error=", exc.getMessage() + str);
                                                                exc.printStackTrace();
                                                            }
                                                        } else {
                                                            str5 = "'),0),'";
                                                            str4 = "0";
                                                            str = str3;
                                                            str7 = ":";
                                                            str8 = ",";
                                                            z = z2;
                                                        }
                                                        if (z) {
                                                            Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                                            if (O2 == 2) {
                                                                if (bill_edit.p != 0) {
                                                                    g2();
                                                                }
                                                                Z00 z07 = bill_edit.i;
                                                                StringBuilder sb14 = new StringBuilder();
                                                                sb14.append("update items_temp set item_id=(select id from items a where a.name='");
                                                                sb14.append((Object) bill_edit.D1.getText());
                                                                sb14.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                                                sb14.append((Object) bill_edit.D1.getText());
                                                                sb14.append("'),qty='");
                                                                sb14.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                                sb14.append("',qty_t='");
                                                                sb14.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                                sb14.append("',price='");
                                                                sb14.append(String.valueOf(dIc));
                                                                sb14.append("',unit_id=ifnull((select id from units where code='");
                                                                sb14.append(bill_edit.L1.getText().toString());
                                                                sb14.append("'),0),u_val='");
                                                                sb14.append(String.valueOf(d8));
                                                                sb14.append("',qty_pr=");
                                                                sb14.append(d9);
                                                                sb14.append(",curr_id=(select id from currency where name='");
                                                                sb14.append(bill_edit.q0.getText().toString());
                                                                sb14.append("') ,remark='");
                                                                sb14.append(bill_edit.A1.getText().toString());
                                                                sb14.append("',e_date=");
                                                                textView2 = bill_edit.C1;
                                                                if (textView2 != null || textView2.getText().toString().length() == 0) {
                                                                    str13 = "''";
                                                                } else {
                                                                    str13 = "'" + bill_edit.C1.getText().toString() + "'";
                                                                }
                                                                sb14.append(str13);
                                                                sb14.append(" where no_='");
                                                                sb14.append(bill_edit.J);
                                                                sb14.append("'");
                                                                z07.v0(sb14.toString());
                                                                k2();
                                                            } else {
                                                                double d15 = d9;
                                                                if (bill_edit.p != 0) {
                                                                    g2();
                                                                }
                                                                Z00 z08 = bill_edit.i;
                                                                StringBuilder sb15 = new StringBuilder();
                                                                sb15.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                                                sb15.append((Object) bill_edit.D1.getText());
                                                                sb15.append("'),(select item_type_id from items a where a.name='");
                                                                sb15.append((Object) bill_edit.D1.getText());
                                                                sb15.append("'),'");
                                                                sb15.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                                sb15.append("','");
                                                                sb15.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                                sb15.append("','");
                                                                sb15.append(String.valueOf(dIc));
                                                                sb15.append("',(select id from currency where name='");
                                                                sb15.append(bill_edit.q0.getText().toString());
                                                                sb15.append("'),'");
                                                                sb15.append(bill_edit.A1.getText().toString());
                                                                sb15.append("',ifnull((select id from units where code='");
                                                                sb15.append(bill_edit.L1.getText().toString());
                                                                sb15.append(str5);
                                                                sb15.append(String.valueOf(d8));
                                                                sb15.append("',(select unit_id from items where name='");
                                                                sb15.append(bill_edit.D1.getText().toString());
                                                                sb15.append("'),");
                                                                sb15.append(d15);
                                                                sb15.append(str8);
                                                                textView = bill_edit.C1;
                                                                if (textView != null || textView.getText().toString().length() == 0) {
                                                                    str12 = "''";
                                                                } else {
                                                                    str12 = "'" + bill_edit.C1.getText().toString() + "'";
                                                                }
                                                                sb15.append(str12);
                                                                sb15.append(" )");
                                                                z08.v0(sb15.toString());
                                                                k2();
                                                                if (bill_edit.p == 0) {
                                                                    Z0();
                                                                    y1();
                                                                }
                                                            }
                                                            bill_edit.x1.setText(str);
                                                            M0();
                                                            bill_edit.q1 = 1;
                                                            Z0();
                                                            y1();
                                                            bill_edit.q1 = 1;
                                                            Z0();
                                                            bill_edit.q2(bill_edit.p, str4);
                                                        }
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        str = str3;
                                                    }
                                                } catch (Exception e9) {
                                                    e = e9;
                                                    str3 = str2;
                                                    exc = e;
                                                    str = str3;
                                                    z = z2;
                                                }
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            str2 = "";
                                            exc = e;
                                            z = z2;
                                            str = str2;
                                            Log.d("edit_item_error=", exc.getMessage() + str);
                                            exc.printStackTrace();
                                            return z;
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        z2 = zA;
                                    }
                                    exc = e;
                                    z = z2;
                                    Log.d("edit_item_error=", exc.getMessage() + str);
                                    exc.printStackTrace();
                                }
                                if (bill_edit.D1.getText().length() == 0) {
                                    return false;
                                }
                                if (bill_edit.i.F6().contains(bill_edit.D1.getText().toString())) {
                                    if (bill_edit.i.F6().contains(bill_edit.D1.getText().toString().trim())) {
                                        AutoCompleteTextView autoCompleteTextView4 = bill_edit.D1;
                                        autoCompleteTextView4.setText(autoCompleteTextView4.getText().toString().trim());
                                        bill_edit.s1 = bill_edit.D1.getText().toString();
                                        bill_edit.V0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item), bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item) + bill_edit.s1, bill_edit);
                                        ArrayList arrayListG7 = bill_edit.i.G6();
                                        C2160f10.c0(bill_edit, bill_edit.D1, arrayListG7, 2);
                                        C1098Yv c1098Yv2 = new C1098Yv(bill_edit, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG7, 4);
                                        bill_edit.C0 = c1098Yv2;
                                        c1098Yv2.l.clear();
                                        bill_edit.C0.notifyDataSetChanged();
                                        bill_edit.D1.setAdapter(bill_edit.C0);
                                        bill_edit.y1.setTag("1");
                                        bill_edit.L1.setVisibility(8);
                                        bill_edit.L1.setText(bill_edit.i.X6(bill_edit.D1.getText().toString()));
                                        str3 = str2;
                                        bill_edit.C1.setText(str3);
                                        bill_edit.q2(bill_edit.p, "-1");
                                        z3 = false;
                                        d8 = 1.0d;
                                    } else {
                                        str3 = str2;
                                        d8 = d5;
                                        z3 = true;
                                    }
                                    if (z3) {
                                    }
                                    if (!bill_edit.D1.getText().toString().equals(bill_edit.D1.getText().toString().trim())) {
                                        AutoCompleteTextView autoCompleteTextView5 = bill_edit.D1;
                                        autoCompleteTextView5.setText(autoCompleteTextView5.getText().toString().trim());
                                    }
                                    bill_edit.i.D = false;
                                    str4 = "0";
                                    if (bill_edit.q0.getText() != null) {
                                        bill_edit.i.u(bill_edit, bill_edit.q0.getText().toString(), bill_edit.U.getText().toString(), bill_edit.getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                                        if (!bill_edit.i.D) {
                                            return false;
                                        }
                                    }
                                    str5 = "'),0),'";
                                    str6 = "prefOthers_update_item_price";
                                    if (bill_edit.t == 1) {
                                        d9 = d4;
                                    } else {
                                        d9 = d4;
                                    }
                                    str7 = ":";
                                    if (bill_edit.t != 1) {
                                        dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                        if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                            dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                            Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                            if (dG1 < 0.0d) {
                                                if (dG1 < 0.0d) {
                                                    dF1 = 0.0d;
                                                }
                                            } else if (dG1 < 0.0d) {
                                                dF1 = 0.0d;
                                            }
                                            bill_edit.t1 = bill_edit.C1.getText().toString();
                                        }
                                        d10 = dF1;
                                        StringBuilder sb16 = new StringBuilder();
                                        sb16.append(bill_edit.p);
                                        sb16.append(":");
                                        sb16.append(bill_edit.J);
                                        sb16.append(":q1=");
                                        sb16.append(d10);
                                        sb16.append(":q2=");
                                        d11 = d9 * d8;
                                        sb16.append(C1839c10.C(d11, C1839c10.d));
                                        sb16.append(":q3=");
                                        sb16.append(d11);
                                        sb16.append(":");
                                        sb16.append(bill_edit.M);
                                        Log.d("item_qty=", sb16.toString());
                                        if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                            if (bill_edit.t == 1) {
                                                str9 = "(";
                                                str = str3;
                                            } else {
                                                str9 = "(";
                                                str = str3;
                                            }
                                            if (!bill_edit.T.isChecked()) {
                                            }
                                        } else {
                                            str4 = "0";
                                            str8 = str8;
                                            str5 = str5;
                                            str6 = str6;
                                            str7 = ":";
                                            d7 = d7;
                                            str = str3;
                                        }
                                        double dJ9 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                        double dK9 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                        if (bill_edit.i.ja(str6, true)) {
                                            z = z2;
                                        } else {
                                            z = z2;
                                        }
                                        if (bill_edit.t == 1) {
                                            bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        if (O2 != 2) {
                                            bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        if (z) {
                                            Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                            if (O2 == 2) {
                                                if (bill_edit.p != 0) {
                                                    g2();
                                                }
                                                Z00 z09 = bill_edit.i;
                                                StringBuilder sb17 = new StringBuilder();
                                                sb17.append("update items_temp set item_id=(select id from items a where a.name='");
                                                sb17.append((Object) bill_edit.D1.getText());
                                                sb17.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                                sb17.append((Object) bill_edit.D1.getText());
                                                sb17.append("'),qty='");
                                                sb17.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb17.append("',qty_t='");
                                                sb17.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb17.append("',price='");
                                                sb17.append(String.valueOf(dIc));
                                                sb17.append("',unit_id=ifnull((select id from units where code='");
                                                sb17.append(bill_edit.L1.getText().toString());
                                                sb17.append("'),0),u_val='");
                                                sb17.append(String.valueOf(d8));
                                                sb17.append("',qty_pr=");
                                                sb17.append(d9);
                                                sb17.append(",curr_id=(select id from currency where name='");
                                                sb17.append(bill_edit.q0.getText().toString());
                                                sb17.append("') ,remark='");
                                                sb17.append(bill_edit.A1.getText().toString());
                                                sb17.append("',e_date=");
                                                textView2 = bill_edit.C1;
                                                if (textView2 != null) {
                                                    str13 = "''";
                                                } else {
                                                    str13 = "''";
                                                }
                                                sb17.append(str13);
                                                sb17.append(" where no_='");
                                                sb17.append(bill_edit.J);
                                                sb17.append("'");
                                                z09.v0(sb17.toString());
                                                k2();
                                            } else {
                                                double d16 = d9;
                                                if (bill_edit.p != 0) {
                                                    g2();
                                                }
                                                Z00 z010 = bill_edit.i;
                                                StringBuilder sb18 = new StringBuilder();
                                                sb18.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                                sb18.append((Object) bill_edit.D1.getText());
                                                sb18.append("'),(select item_type_id from items a where a.name='");
                                                sb18.append((Object) bill_edit.D1.getText());
                                                sb18.append("'),'");
                                                sb18.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb18.append("','");
                                                sb18.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb18.append("','");
                                                sb18.append(String.valueOf(dIc));
                                                sb18.append("',(select id from currency where name='");
                                                sb18.append(bill_edit.q0.getText().toString());
                                                sb18.append("'),'");
                                                sb18.append(bill_edit.A1.getText().toString());
                                                sb18.append("',ifnull((select id from units where code='");
                                                sb18.append(bill_edit.L1.getText().toString());
                                                sb18.append(str5);
                                                sb18.append(String.valueOf(d8));
                                                sb18.append("',(select unit_id from items where name='");
                                                sb18.append(bill_edit.D1.getText().toString());
                                                sb18.append("'),");
                                                sb18.append(d16);
                                                sb18.append(str8);
                                                textView = bill_edit.C1;
                                                if (textView != null) {
                                                    str12 = "''";
                                                } else {
                                                    str12 = "''";
                                                }
                                                sb18.append(str12);
                                                sb18.append(" )");
                                                z010.v0(sb18.toString());
                                                k2();
                                                if (bill_edit.p == 0) {
                                                    Z0();
                                                    y1();
                                                }
                                            }
                                            bill_edit.x1.setText(str);
                                            M0();
                                            bill_edit.q1 = 1;
                                            Z0();
                                            y1();
                                            bill_edit.q1 = 1;
                                            Z0();
                                            bill_edit.q2(bill_edit.p, str4);
                                        }
                                    } else {
                                        dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                        if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                            dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                            Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                            if (dG1 < 0.0d) {
                                                if (dG1 < 0.0d) {
                                                    dF1 = 0.0d;
                                                }
                                            } else if (dG1 < 0.0d) {
                                                dF1 = 0.0d;
                                            }
                                            bill_edit.t1 = bill_edit.C1.getText().toString();
                                        }
                                        d10 = dF1;
                                        StringBuilder sb19 = new StringBuilder();
                                        sb19.append(bill_edit.p);
                                        sb19.append(":");
                                        sb19.append(bill_edit.J);
                                        sb19.append(":q1=");
                                        sb19.append(d10);
                                        sb19.append(":q2=");
                                        d11 = d9 * d8;
                                        sb19.append(C1839c10.C(d11, C1839c10.d));
                                        sb19.append(":q3=");
                                        sb19.append(d11);
                                        sb19.append(":");
                                        sb19.append(bill_edit.M);
                                        Log.d("item_qty=", sb19.toString());
                                        if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                            if (bill_edit.t == 1) {
                                                str9 = "(";
                                                str = str3;
                                            } else {
                                                str9 = "(";
                                                str = str3;
                                            }
                                            if (!bill_edit.T.isChecked()) {
                                            }
                                        } else {
                                            str4 = "0";
                                            str8 = str8;
                                            str5 = str5;
                                            str6 = str6;
                                            str7 = ":";
                                            d7 = d7;
                                            str = str3;
                                        }
                                        double dJ10 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                        double dK10 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                        if (bill_edit.i.ja(str6, true)) {
                                            z = z2;
                                        } else {
                                            z = z2;
                                        }
                                        if (bill_edit.t == 1) {
                                            bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        if (O2 != 2) {
                                            bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        if (z) {
                                            Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                            if (O2 == 2) {
                                                if (bill_edit.p != 0) {
                                                    g2();
                                                }
                                                Z00 z011 = bill_edit.i;
                                                StringBuilder sb110 = new StringBuilder();
                                                sb110.append("update items_temp set item_id=(select id from items a where a.name='");
                                                sb110.append((Object) bill_edit.D1.getText());
                                                sb110.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                                sb110.append((Object) bill_edit.D1.getText());
                                                sb110.append("'),qty='");
                                                sb110.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb110.append("',qty_t='");
                                                sb110.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb110.append("',price='");
                                                sb110.append(String.valueOf(dIc));
                                                sb110.append("',unit_id=ifnull((select id from units where code='");
                                                sb110.append(bill_edit.L1.getText().toString());
                                                sb110.append("'),0),u_val='");
                                                sb110.append(String.valueOf(d8));
                                                sb110.append("',qty_pr=");
                                                sb110.append(d9);
                                                sb110.append(",curr_id=(select id from currency where name='");
                                                sb110.append(bill_edit.q0.getText().toString());
                                                sb110.append("') ,remark='");
                                                sb110.append(bill_edit.A1.getText().toString());
                                                sb110.append("',e_date=");
                                                textView2 = bill_edit.C1;
                                                if (textView2 != null) {
                                                    str13 = "''";
                                                } else {
                                                    str13 = "''";
                                                }
                                                sb110.append(str13);
                                                sb110.append(" where no_='");
                                                sb110.append(bill_edit.J);
                                                sb110.append("'");
                                                z011.v0(sb110.toString());
                                                k2();
                                            } else {
                                                double d17 = d9;
                                                if (bill_edit.p != 0) {
                                                    g2();
                                                }
                                                Z00 z012 = bill_edit.i;
                                                StringBuilder sb111 = new StringBuilder();
                                                sb111.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                                sb111.append((Object) bill_edit.D1.getText());
                                                sb111.append("'),(select item_type_id from items a where a.name='");
                                                sb111.append((Object) bill_edit.D1.getText());
                                                sb111.append("'),'");
                                                sb111.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb111.append("','");
                                                sb111.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb111.append("','");
                                                sb111.append(String.valueOf(dIc));
                                                sb111.append("',(select id from currency where name='");
                                                sb111.append(bill_edit.q0.getText().toString());
                                                sb111.append("'),'");
                                                sb111.append(bill_edit.A1.getText().toString());
                                                sb111.append("',ifnull((select id from units where code='");
                                                sb111.append(bill_edit.L1.getText().toString());
                                                sb111.append(str5);
                                                sb111.append(String.valueOf(d8));
                                                sb111.append("',(select unit_id from items where name='");
                                                sb111.append(bill_edit.D1.getText().toString());
                                                sb111.append("'),");
                                                sb111.append(d17);
                                                sb111.append(str8);
                                                textView = bill_edit.C1;
                                                if (textView != null) {
                                                    str12 = "''";
                                                } else {
                                                    str12 = "''";
                                                }
                                                sb111.append(str12);
                                                sb111.append(" )");
                                                z012.v0(sb111.toString());
                                                k2();
                                                if (bill_edit.p == 0) {
                                                    Z0();
                                                    y1();
                                                }
                                            }
                                            bill_edit.x1.setText(str);
                                            M0();
                                            bill_edit.q1 = 1;
                                            Z0();
                                            y1();
                                            bill_edit.q1 = 1;
                                            Z0();
                                            bill_edit.q2(bill_edit.p, str4);
                                        }
                                    }
                                    Log.d("edit_item_error=", exc.getMessage() + str);
                                    exc.printStackTrace();
                                } else {
                                    str3 = str2;
                                    d8 = d5;
                                    z3 = true;
                                    if (z3) {
                                    }
                                    if (!bill_edit.D1.getText().toString().equals(bill_edit.D1.getText().toString().trim())) {
                                        AutoCompleteTextView autoCompleteTextView6 = bill_edit.D1;
                                        autoCompleteTextView6.setText(autoCompleteTextView6.getText().toString().trim());
                                    }
                                    bill_edit.i.D = false;
                                    str4 = "0";
                                    if (bill_edit.q0.getText() != null) {
                                        bill_edit.i.u(bill_edit, bill_edit.q0.getText().toString(), bill_edit.U.getText().toString(), bill_edit.getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                                        if (!bill_edit.i.D) {
                                            return false;
                                        }
                                    }
                                    str5 = "'),0),'";
                                    str6 = "prefOthers_update_item_price";
                                    if (bill_edit.t == 1) {
                                        d9 = d4;
                                    } else {
                                        d9 = d4;
                                    }
                                    str7 = ":";
                                    if (bill_edit.t != 1) {
                                        dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                        if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                            dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                            Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                            if (dG1 < 0.0d) {
                                                if (dG1 < 0.0d) {
                                                    dF1 = 0.0d;
                                                }
                                            } else if (dG1 < 0.0d) {
                                                dF1 = 0.0d;
                                            }
                                            bill_edit.t1 = bill_edit.C1.getText().toString();
                                        }
                                        d10 = dF1;
                                        StringBuilder sb112 = new StringBuilder();
                                        sb112.append(bill_edit.p);
                                        sb112.append(":");
                                        sb112.append(bill_edit.J);
                                        sb112.append(":q1=");
                                        sb112.append(d10);
                                        sb112.append(":q2=");
                                        d11 = d9 * d8;
                                        sb112.append(C1839c10.C(d11, C1839c10.d));
                                        sb112.append(":q3=");
                                        sb112.append(d11);
                                        sb112.append(":");
                                        sb112.append(bill_edit.M);
                                        Log.d("item_qty=", sb112.toString());
                                        if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                            if (bill_edit.t == 1) {
                                                str9 = "(";
                                                str = str3;
                                            } else {
                                                str9 = "(";
                                                str = str3;
                                            }
                                            if (!bill_edit.T.isChecked()) {
                                            }
                                        } else {
                                            str4 = "0";
                                            str8 = str8;
                                            str5 = str5;
                                            str6 = str6;
                                            str7 = ":";
                                            d7 = d7;
                                            str = str3;
                                        }
                                        double dJ11 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                        double dK11 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                        if (bill_edit.i.ja(str6, true)) {
                                            z = z2;
                                        } else {
                                            z = z2;
                                        }
                                        if (bill_edit.t == 1) {
                                            bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        if (O2 != 2) {
                                            bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        if (z) {
                                            Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                            if (O2 == 2) {
                                                if (bill_edit.p != 0) {
                                                    g2();
                                                }
                                                Z00 z013 = bill_edit.i;
                                                StringBuilder sb113 = new StringBuilder();
                                                sb113.append("update items_temp set item_id=(select id from items a where a.name='");
                                                sb113.append((Object) bill_edit.D1.getText());
                                                sb113.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                                sb113.append((Object) bill_edit.D1.getText());
                                                sb113.append("'),qty='");
                                                sb113.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb113.append("',qty_t='");
                                                sb113.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb113.append("',price='");
                                                sb113.append(String.valueOf(dIc));
                                                sb113.append("',unit_id=ifnull((select id from units where code='");
                                                sb113.append(bill_edit.L1.getText().toString());
                                                sb113.append("'),0),u_val='");
                                                sb113.append(String.valueOf(d8));
                                                sb113.append("',qty_pr=");
                                                sb113.append(d9);
                                                sb113.append(",curr_id=(select id from currency where name='");
                                                sb113.append(bill_edit.q0.getText().toString());
                                                sb113.append("') ,remark='");
                                                sb113.append(bill_edit.A1.getText().toString());
                                                sb113.append("',e_date=");
                                                textView2 = bill_edit.C1;
                                                if (textView2 != null) {
                                                    str13 = "''";
                                                } else {
                                                    str13 = "''";
                                                }
                                                sb113.append(str13);
                                                sb113.append(" where no_='");
                                                sb113.append(bill_edit.J);
                                                sb113.append("'");
                                                z013.v0(sb113.toString());
                                                k2();
                                            } else {
                                                double d18 = d9;
                                                if (bill_edit.p != 0) {
                                                    g2();
                                                }
                                                Z00 z014 = bill_edit.i;
                                                StringBuilder sb114 = new StringBuilder();
                                                sb114.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                                sb114.append((Object) bill_edit.D1.getText());
                                                sb114.append("'),(select item_type_id from items a where a.name='");
                                                sb114.append((Object) bill_edit.D1.getText());
                                                sb114.append("'),'");
                                                sb114.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb114.append("','");
                                                sb114.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb114.append("','");
                                                sb114.append(String.valueOf(dIc));
                                                sb114.append("',(select id from currency where name='");
                                                sb114.append(bill_edit.q0.getText().toString());
                                                sb114.append("'),'");
                                                sb114.append(bill_edit.A1.getText().toString());
                                                sb114.append("',ifnull((select id from units where code='");
                                                sb114.append(bill_edit.L1.getText().toString());
                                                sb114.append(str5);
                                                sb114.append(String.valueOf(d8));
                                                sb114.append("',(select unit_id from items where name='");
                                                sb114.append(bill_edit.D1.getText().toString());
                                                sb114.append("'),");
                                                sb114.append(d18);
                                                sb114.append(str8);
                                                textView = bill_edit.C1;
                                                if (textView != null) {
                                                    str12 = "''";
                                                } else {
                                                    str12 = "''";
                                                }
                                                sb114.append(str12);
                                                sb114.append(" )");
                                                z014.v0(sb114.toString());
                                                k2();
                                                if (bill_edit.p == 0) {
                                                    Z0();
                                                    y1();
                                                }
                                            }
                                            bill_edit.x1.setText(str);
                                            M0();
                                            bill_edit.q1 = 1;
                                            Z0();
                                            y1();
                                            bill_edit.q1 = 1;
                                            Z0();
                                            bill_edit.q2(bill_edit.p, str4);
                                        }
                                    } else {
                                        dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                        if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                            dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                            Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                            if (dG1 < 0.0d) {
                                                if (dG1 < 0.0d) {
                                                    dF1 = 0.0d;
                                                }
                                            } else if (dG1 < 0.0d) {
                                                dF1 = 0.0d;
                                            }
                                            bill_edit.t1 = bill_edit.C1.getText().toString();
                                        }
                                        d10 = dF1;
                                        StringBuilder sb115 = new StringBuilder();
                                        sb115.append(bill_edit.p);
                                        sb115.append(":");
                                        sb115.append(bill_edit.J);
                                        sb115.append(":q1=");
                                        sb115.append(d10);
                                        sb115.append(":q2=");
                                        d11 = d9 * d8;
                                        sb115.append(C1839c10.C(d11, C1839c10.d));
                                        sb115.append(":q3=");
                                        sb115.append(d11);
                                        sb115.append(":");
                                        sb115.append(bill_edit.M);
                                        Log.d("item_qty=", sb115.toString());
                                        if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                            if (bill_edit.t == 1) {
                                                str9 = "(";
                                                str = str3;
                                            } else {
                                                str9 = "(";
                                                str = str3;
                                            }
                                            if (!bill_edit.T.isChecked()) {
                                            }
                                        } else {
                                            str4 = "0";
                                            str8 = str8;
                                            str5 = str5;
                                            str6 = str6;
                                            str7 = ":";
                                            d7 = d7;
                                            str = str3;
                                        }
                                        double dJ12 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                        double dK12 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                        if (bill_edit.i.ja(str6, true)) {
                                            z = z2;
                                        } else {
                                            z = z2;
                                        }
                                        if (bill_edit.t == 1) {
                                            bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        if (O2 != 2) {
                                            bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        if (z) {
                                            Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                            if (O2 == 2) {
                                                if (bill_edit.p != 0) {
                                                    g2();
                                                }
                                                Z00 z015 = bill_edit.i;
                                                StringBuilder sb116 = new StringBuilder();
                                                sb116.append("update items_temp set item_id=(select id from items a where a.name='");
                                                sb116.append((Object) bill_edit.D1.getText());
                                                sb116.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                                sb116.append((Object) bill_edit.D1.getText());
                                                sb116.append("'),qty='");
                                                sb116.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb116.append("',qty_t='");
                                                sb116.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb116.append("',price='");
                                                sb116.append(String.valueOf(dIc));
                                                sb116.append("',unit_id=ifnull((select id from units where code='");
                                                sb116.append(bill_edit.L1.getText().toString());
                                                sb116.append("'),0),u_val='");
                                                sb116.append(String.valueOf(d8));
                                                sb116.append("',qty_pr=");
                                                sb116.append(d9);
                                                sb116.append(",curr_id=(select id from currency where name='");
                                                sb116.append(bill_edit.q0.getText().toString());
                                                sb116.append("') ,remark='");
                                                sb116.append(bill_edit.A1.getText().toString());
                                                sb116.append("',e_date=");
                                                textView2 = bill_edit.C1;
                                                if (textView2 != null) {
                                                    str13 = "''";
                                                } else {
                                                    str13 = "''";
                                                }
                                                sb116.append(str13);
                                                sb116.append(" where no_='");
                                                sb116.append(bill_edit.J);
                                                sb116.append("'");
                                                z015.v0(sb116.toString());
                                                k2();
                                            } else {
                                                double d19 = d9;
                                                if (bill_edit.p != 0) {
                                                    g2();
                                                }
                                                Z00 z016 = bill_edit.i;
                                                StringBuilder sb117 = new StringBuilder();
                                                sb117.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                                sb117.append((Object) bill_edit.D1.getText());
                                                sb117.append("'),(select item_type_id from items a where a.name='");
                                                sb117.append((Object) bill_edit.D1.getText());
                                                sb117.append("'),'");
                                                sb117.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb117.append("','");
                                                sb117.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                                sb117.append("','");
                                                sb117.append(String.valueOf(dIc));
                                                sb117.append("',(select id from currency where name='");
                                                sb117.append(bill_edit.q0.getText().toString());
                                                sb117.append("'),'");
                                                sb117.append(bill_edit.A1.getText().toString());
                                                sb117.append("',ifnull((select id from units where code='");
                                                sb117.append(bill_edit.L1.getText().toString());
                                                sb117.append(str5);
                                                sb117.append(String.valueOf(d8));
                                                sb117.append("',(select unit_id from items where name='");
                                                sb117.append(bill_edit.D1.getText().toString());
                                                sb117.append("'),");
                                                sb117.append(d19);
                                                sb117.append(str8);
                                                textView = bill_edit.C1;
                                                if (textView != null) {
                                                    str12 = "''";
                                                } else {
                                                    str12 = "''";
                                                }
                                                sb117.append(str12);
                                                sb117.append(" )");
                                                z016.v0(sb117.toString());
                                                k2();
                                                if (bill_edit.p == 0) {
                                                    Z0();
                                                    y1();
                                                }
                                            }
                                            bill_edit.x1.setText(str);
                                            M0();
                                            bill_edit.q1 = 1;
                                            Z0();
                                            y1();
                                            bill_edit.q1 = 1;
                                            Z0();
                                            bill_edit.q2(bill_edit.p, str4);
                                        }
                                    }
                                    Log.d("edit_item_error=", exc.getMessage() + str);
                                    exc.printStackTrace();
                                }
                            } catch (Exception e12) {
                                e = e12;
                                str = str2;
                            }
                            str2 = "";
                            d6 = 0.0d;
                            if (d2 >= d6) {
                                bill_edit = this;
                                d7 = d;
                                dIc = 0.0d;
                            } else {
                                bill_edit = this;
                                d7 = d;
                                dIc = 0.0d;
                            }
                        } catch (Exception e13) {
                            e = e13;
                            z2 = zA;
                            str = "";
                        }
                        exc = e;
                        z = z2;
                    } catch (Exception e14) {
                        exc = e14;
                        z = zA;
                        str = "";
                    }
                    Log.d("edit_item_error=", exc.getMessage() + str);
                    exc.printStackTrace();
                } else {
                    if (this.y1.getText().toString().trim().length() > 0) {
                        d = Double.parseDouble(this.y1.getText().toString().replaceAll(",", ""));
                    } else {
                        d = 0.0d;
                    }
                    if (this.z1.getText().toString().trim().length() > 0) {
                        d2 = Double.parseDouble(this.z1.getText().toString().replaceAll(",", ""));
                    } else {
                        d2 = 0.0d;
                    }
                    if (this.B1.getText().toString().trim().length() > 0) {
                        dB0 = Double.parseDouble(this.B1.getText().toString().replaceAll(",", ""));
                        if (this.y1.getTag().toString().trim().length() > 0) {
                            d3 = Double.parseDouble(this.y1.getTag().toString().replaceAll(",", ""));
                        } else {
                            d3 = 1.0d;
                        }
                        if (this.i.ja("prefOthers_qty_pr", false)) {
                            dB0 = this.i.b0(this.B1.getText().toString().replaceAll(",", ""), d3);
                        }
                        d4 = dB0;
                    } else {
                        d3 = 1.0d;
                        d4 = 0.0d;
                    }
                    if (d > 0.0d) {
                        z2 = zA;
                        d5 = d3;
                        str2 = "";
                        d6 = 0.0d;
                        if (d2 >= d6) {
                            bill_edit = this;
                            d7 = d;
                            dIc = 0.0d;
                        } else {
                            bill_edit = this;
                            d7 = d;
                            dIc = 0.0d;
                        }
                        if (bill_edit.D1.getText().length() == 0) {
                            return false;
                        }
                        if (bill_edit.i.F6().contains(bill_edit.D1.getText().toString())) {
                            if (bill_edit.i.F6().contains(bill_edit.D1.getText().toString().trim())) {
                                AutoCompleteTextView autoCompleteTextView7 = bill_edit.D1;
                                autoCompleteTextView7.setText(autoCompleteTextView7.getText().toString().trim());
                                bill_edit.s1 = bill_edit.D1.getText().toString();
                                bill_edit.V0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item), bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item) + bill_edit.s1, bill_edit);
                                ArrayList arrayListG8 = bill_edit.i.G6();
                                C2160f10.c0(bill_edit, bill_edit.D1, arrayListG8, 2);
                                C1098Yv c1098Yv3 = new C1098Yv(bill_edit, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG8, 4);
                                bill_edit.C0 = c1098Yv3;
                                c1098Yv3.l.clear();
                                bill_edit.C0.notifyDataSetChanged();
                                bill_edit.D1.setAdapter(bill_edit.C0);
                                bill_edit.y1.setTag("1");
                                bill_edit.L1.setVisibility(8);
                                bill_edit.L1.setText(bill_edit.i.X6(bill_edit.D1.getText().toString()));
                                str3 = str2;
                                bill_edit.C1.setText(str3);
                                bill_edit.q2(bill_edit.p, "-1");
                                z3 = false;
                                d8 = 1.0d;
                            } else {
                                str3 = str2;
                                d8 = d5;
                                z3 = true;
                            }
                            if (z3) {
                            }
                            if (!bill_edit.D1.getText().toString().equals(bill_edit.D1.getText().toString().trim())) {
                                AutoCompleteTextView autoCompleteTextView8 = bill_edit.D1;
                                autoCompleteTextView8.setText(autoCompleteTextView8.getText().toString().trim());
                            }
                            bill_edit.i.D = false;
                            str4 = "0";
                            if (bill_edit.q0.getText() != null) {
                                bill_edit.i.u(bill_edit, bill_edit.q0.getText().toString(), bill_edit.U.getText().toString(), bill_edit.getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                                if (!bill_edit.i.D) {
                                    return false;
                                }
                            }
                            str5 = "'),0),'";
                            str6 = "prefOthers_update_item_price";
                            if (bill_edit.t == 1) {
                                d9 = d4;
                            } else {
                                d9 = d4;
                            }
                            str7 = ":";
                            if (bill_edit.t != 1) {
                                dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                    dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                    Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                    if (dG1 < 0.0d) {
                                        if (dG1 < 0.0d) {
                                            dF1 = 0.0d;
                                        }
                                    } else if (dG1 < 0.0d) {
                                        dF1 = 0.0d;
                                    }
                                    bill_edit.t1 = bill_edit.C1.getText().toString();
                                }
                                d10 = dF1;
                                StringBuilder sb118 = new StringBuilder();
                                sb118.append(bill_edit.p);
                                sb118.append(":");
                                sb118.append(bill_edit.J);
                                sb118.append(":q1=");
                                sb118.append(d10);
                                sb118.append(":q2=");
                                d11 = d9 * d8;
                                sb118.append(C1839c10.C(d11, C1839c10.d));
                                sb118.append(":q3=");
                                sb118.append(d11);
                                sb118.append(":");
                                sb118.append(bill_edit.M);
                                Log.d("item_qty=", sb118.toString());
                                if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                    if (bill_edit.t == 1) {
                                        str9 = "(";
                                        str = str3;
                                    } else {
                                        str9 = "(";
                                        str = str3;
                                    }
                                    if (!bill_edit.T.isChecked()) {
                                    }
                                } else {
                                    str4 = "0";
                                    str8 = str8;
                                    str5 = str5;
                                    str6 = str6;
                                    str7 = ":";
                                    d7 = d7;
                                    str = str3;
                                }
                                double dJ13 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                double dK13 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                if (bill_edit.i.ja(str6, true)) {
                                    z = z2;
                                } else {
                                    z = z2;
                                }
                                if (bill_edit.t == 1) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (O2 != 2) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                    if (O2 == 2) {
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z017 = bill_edit.i;
                                        StringBuilder sb119 = new StringBuilder();
                                        sb119.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb119.append((Object) bill_edit.D1.getText());
                                        sb119.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb119.append((Object) bill_edit.D1.getText());
                                        sb119.append("'),qty='");
                                        sb119.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb119.append("',qty_t='");
                                        sb119.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb119.append("',price='");
                                        sb119.append(String.valueOf(dIc));
                                        sb119.append("',unit_id=ifnull((select id from units where code='");
                                        sb119.append(bill_edit.L1.getText().toString());
                                        sb119.append("'),0),u_val='");
                                        sb119.append(String.valueOf(d8));
                                        sb119.append("',qty_pr=");
                                        sb119.append(d9);
                                        sb119.append(",curr_id=(select id from currency where name='");
                                        sb119.append(bill_edit.q0.getText().toString());
                                        sb119.append("') ,remark='");
                                        sb119.append(bill_edit.A1.getText().toString());
                                        sb119.append("',e_date=");
                                        textView2 = bill_edit.C1;
                                        if (textView2 != null) {
                                            str13 = "''";
                                        } else {
                                            str13 = "''";
                                        }
                                        sb119.append(str13);
                                        sb119.append(" where no_='");
                                        sb119.append(bill_edit.J);
                                        sb119.append("'");
                                        z017.v0(sb119.toString());
                                        k2();
                                    } else {
                                        double d110 = d9;
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z018 = bill_edit.i;
                                        StringBuilder sb1110 = new StringBuilder();
                                        sb1110.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb1110.append((Object) bill_edit.D1.getText());
                                        sb1110.append("'),(select item_type_id from items a where a.name='");
                                        sb1110.append((Object) bill_edit.D1.getText());
                                        sb1110.append("'),'");
                                        sb1110.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1110.append("','");
                                        sb1110.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1110.append("','");
                                        sb1110.append(String.valueOf(dIc));
                                        sb1110.append("',(select id from currency where name='");
                                        sb1110.append(bill_edit.q0.getText().toString());
                                        sb1110.append("'),'");
                                        sb1110.append(bill_edit.A1.getText().toString());
                                        sb1110.append("',ifnull((select id from units where code='");
                                        sb1110.append(bill_edit.L1.getText().toString());
                                        sb1110.append(str5);
                                        sb1110.append(String.valueOf(d8));
                                        sb1110.append("',(select unit_id from items where name='");
                                        sb1110.append(bill_edit.D1.getText().toString());
                                        sb1110.append("'),");
                                        sb1110.append(d110);
                                        sb1110.append(str8);
                                        textView = bill_edit.C1;
                                        if (textView != null) {
                                            str12 = "''";
                                        } else {
                                            str12 = "''";
                                        }
                                        sb1110.append(str12);
                                        sb1110.append(" )");
                                        z018.v0(sb1110.toString());
                                        k2();
                                        if (bill_edit.p == 0) {
                                            Z0();
                                            y1();
                                        }
                                    }
                                    bill_edit.x1.setText(str);
                                    M0();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    y1();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    bill_edit.q2(bill_edit.p, str4);
                                }
                            } else {
                                dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                    dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                    Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                    if (dG1 < 0.0d) {
                                        if (dG1 < 0.0d) {
                                            dF1 = 0.0d;
                                        }
                                    } else if (dG1 < 0.0d) {
                                        dF1 = 0.0d;
                                    }
                                    bill_edit.t1 = bill_edit.C1.getText().toString();
                                }
                                d10 = dF1;
                                StringBuilder sb1111 = new StringBuilder();
                                sb1111.append(bill_edit.p);
                                sb1111.append(":");
                                sb1111.append(bill_edit.J);
                                sb1111.append(":q1=");
                                sb1111.append(d10);
                                sb1111.append(":q2=");
                                d11 = d9 * d8;
                                sb1111.append(C1839c10.C(d11, C1839c10.d));
                                sb1111.append(":q3=");
                                sb1111.append(d11);
                                sb1111.append(":");
                                sb1111.append(bill_edit.M);
                                Log.d("item_qty=", sb1111.toString());
                                if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                    if (bill_edit.t == 1) {
                                        str9 = "(";
                                        str = str3;
                                    } else {
                                        str9 = "(";
                                        str = str3;
                                    }
                                    if (!bill_edit.T.isChecked()) {
                                    }
                                } else {
                                    str4 = "0";
                                    str8 = str8;
                                    str5 = str5;
                                    str6 = str6;
                                    str7 = ":";
                                    d7 = d7;
                                    str = str3;
                                }
                                double dJ14 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                double dK14 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                if (bill_edit.i.ja(str6, true)) {
                                    z = z2;
                                } else {
                                    z = z2;
                                }
                                if (bill_edit.t == 1) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (O2 != 2) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                    if (O2 == 2) {
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z019 = bill_edit.i;
                                        StringBuilder sb1112 = new StringBuilder();
                                        sb1112.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb1112.append((Object) bill_edit.D1.getText());
                                        sb1112.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb1112.append((Object) bill_edit.D1.getText());
                                        sb1112.append("'),qty='");
                                        sb1112.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1112.append("',qty_t='");
                                        sb1112.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1112.append("',price='");
                                        sb1112.append(String.valueOf(dIc));
                                        sb1112.append("',unit_id=ifnull((select id from units where code='");
                                        sb1112.append(bill_edit.L1.getText().toString());
                                        sb1112.append("'),0),u_val='");
                                        sb1112.append(String.valueOf(d8));
                                        sb1112.append("',qty_pr=");
                                        sb1112.append(d9);
                                        sb1112.append(",curr_id=(select id from currency where name='");
                                        sb1112.append(bill_edit.q0.getText().toString());
                                        sb1112.append("') ,remark='");
                                        sb1112.append(bill_edit.A1.getText().toString());
                                        sb1112.append("',e_date=");
                                        textView2 = bill_edit.C1;
                                        if (textView2 != null) {
                                            str13 = "''";
                                        } else {
                                            str13 = "''";
                                        }
                                        sb1112.append(str13);
                                        sb1112.append(" where no_='");
                                        sb1112.append(bill_edit.J);
                                        sb1112.append("'");
                                        z019.v0(sb1112.toString());
                                        k2();
                                    } else {
                                        double d111 = d9;
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0110 = bill_edit.i;
                                        StringBuilder sb1113 = new StringBuilder();
                                        sb1113.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb1113.append((Object) bill_edit.D1.getText());
                                        sb1113.append("'),(select item_type_id from items a where a.name='");
                                        sb1113.append((Object) bill_edit.D1.getText());
                                        sb1113.append("'),'");
                                        sb1113.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1113.append("','");
                                        sb1113.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1113.append("','");
                                        sb1113.append(String.valueOf(dIc));
                                        sb1113.append("',(select id from currency where name='");
                                        sb1113.append(bill_edit.q0.getText().toString());
                                        sb1113.append("'),'");
                                        sb1113.append(bill_edit.A1.getText().toString());
                                        sb1113.append("',ifnull((select id from units where code='");
                                        sb1113.append(bill_edit.L1.getText().toString());
                                        sb1113.append(str5);
                                        sb1113.append(String.valueOf(d8));
                                        sb1113.append("',(select unit_id from items where name='");
                                        sb1113.append(bill_edit.D1.getText().toString());
                                        sb1113.append("'),");
                                        sb1113.append(d111);
                                        sb1113.append(str8);
                                        textView = bill_edit.C1;
                                        if (textView != null) {
                                            str12 = "''";
                                        } else {
                                            str12 = "''";
                                        }
                                        sb1113.append(str12);
                                        sb1113.append(" )");
                                        z0110.v0(sb1113.toString());
                                        k2();
                                        if (bill_edit.p == 0) {
                                            Z0();
                                            y1();
                                        }
                                    }
                                    bill_edit.x1.setText(str);
                                    M0();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    y1();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    bill_edit.q2(bill_edit.p, str4);
                                }
                            }
                            Log.d("edit_item_error=", exc.getMessage() + str);
                            exc.printStackTrace();
                        } else {
                            str3 = str2;
                            d8 = d5;
                            z3 = true;
                            if (z3) {
                            }
                            if (!bill_edit.D1.getText().toString().equals(bill_edit.D1.getText().toString().trim())) {
                                AutoCompleteTextView autoCompleteTextView9 = bill_edit.D1;
                                autoCompleteTextView9.setText(autoCompleteTextView9.getText().toString().trim());
                            }
                            bill_edit.i.D = false;
                            str4 = "0";
                            if (bill_edit.q0.getText() != null) {
                                bill_edit.i.u(bill_edit, bill_edit.q0.getText().toString(), bill_edit.U.getText().toString(), bill_edit.getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                                if (!bill_edit.i.D) {
                                    return false;
                                }
                            }
                            str5 = "'),0),'";
                            str6 = "prefOthers_update_item_price";
                            if (bill_edit.t == 1) {
                                d9 = d4;
                            } else {
                                d9 = d4;
                            }
                            str7 = ":";
                            if (bill_edit.t != 1) {
                                dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                    dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                    Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                    if (dG1 < 0.0d) {
                                        if (dG1 < 0.0d) {
                                            dF1 = 0.0d;
                                        }
                                    } else if (dG1 < 0.0d) {
                                        dF1 = 0.0d;
                                    }
                                    bill_edit.t1 = bill_edit.C1.getText().toString();
                                }
                                d10 = dF1;
                                StringBuilder sb1114 = new StringBuilder();
                                sb1114.append(bill_edit.p);
                                sb1114.append(":");
                                sb1114.append(bill_edit.J);
                                sb1114.append(":q1=");
                                sb1114.append(d10);
                                sb1114.append(":q2=");
                                d11 = d9 * d8;
                                sb1114.append(C1839c10.C(d11, C1839c10.d));
                                sb1114.append(":q3=");
                                sb1114.append(d11);
                                sb1114.append(":");
                                sb1114.append(bill_edit.M);
                                Log.d("item_qty=", sb1114.toString());
                                if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                    if (bill_edit.t == 1) {
                                        str9 = "(";
                                        str = str3;
                                    } else {
                                        str9 = "(";
                                        str = str3;
                                    }
                                    if (!bill_edit.T.isChecked()) {
                                    }
                                } else {
                                    str4 = "0";
                                    str8 = str8;
                                    str5 = str5;
                                    str6 = str6;
                                    str7 = ":";
                                    d7 = d7;
                                    str = str3;
                                }
                                double dJ15 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                double dK15 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                if (bill_edit.i.ja(str6, true)) {
                                    z = z2;
                                } else {
                                    z = z2;
                                }
                                if (bill_edit.t == 1) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (O2 != 2) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                    if (O2 == 2) {
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0111 = bill_edit.i;
                                        StringBuilder sb1115 = new StringBuilder();
                                        sb1115.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb1115.append((Object) bill_edit.D1.getText());
                                        sb1115.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb1115.append((Object) bill_edit.D1.getText());
                                        sb1115.append("'),qty='");
                                        sb1115.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1115.append("',qty_t='");
                                        sb1115.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1115.append("',price='");
                                        sb1115.append(String.valueOf(dIc));
                                        sb1115.append("',unit_id=ifnull((select id from units where code='");
                                        sb1115.append(bill_edit.L1.getText().toString());
                                        sb1115.append("'),0),u_val='");
                                        sb1115.append(String.valueOf(d8));
                                        sb1115.append("',qty_pr=");
                                        sb1115.append(d9);
                                        sb1115.append(",curr_id=(select id from currency where name='");
                                        sb1115.append(bill_edit.q0.getText().toString());
                                        sb1115.append("') ,remark='");
                                        sb1115.append(bill_edit.A1.getText().toString());
                                        sb1115.append("',e_date=");
                                        textView2 = bill_edit.C1;
                                        if (textView2 != null) {
                                            str13 = "''";
                                        } else {
                                            str13 = "''";
                                        }
                                        sb1115.append(str13);
                                        sb1115.append(" where no_='");
                                        sb1115.append(bill_edit.J);
                                        sb1115.append("'");
                                        z0111.v0(sb1115.toString());
                                        k2();
                                    } else {
                                        double d112 = d9;
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0112 = bill_edit.i;
                                        StringBuilder sb1116 = new StringBuilder();
                                        sb1116.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb1116.append((Object) bill_edit.D1.getText());
                                        sb1116.append("'),(select item_type_id from items a where a.name='");
                                        sb1116.append((Object) bill_edit.D1.getText());
                                        sb1116.append("'),'");
                                        sb1116.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1116.append("','");
                                        sb1116.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1116.append("','");
                                        sb1116.append(String.valueOf(dIc));
                                        sb1116.append("',(select id from currency where name='");
                                        sb1116.append(bill_edit.q0.getText().toString());
                                        sb1116.append("'),'");
                                        sb1116.append(bill_edit.A1.getText().toString());
                                        sb1116.append("',ifnull((select id from units where code='");
                                        sb1116.append(bill_edit.L1.getText().toString());
                                        sb1116.append(str5);
                                        sb1116.append(String.valueOf(d8));
                                        sb1116.append("',(select unit_id from items where name='");
                                        sb1116.append(bill_edit.D1.getText().toString());
                                        sb1116.append("'),");
                                        sb1116.append(d112);
                                        sb1116.append(str8);
                                        textView = bill_edit.C1;
                                        if (textView != null) {
                                            str12 = "''";
                                        } else {
                                            str12 = "''";
                                        }
                                        sb1116.append(str12);
                                        sb1116.append(" )");
                                        z0112.v0(sb1116.toString());
                                        k2();
                                        if (bill_edit.p == 0) {
                                            Z0();
                                            y1();
                                        }
                                    }
                                    bill_edit.x1.setText(str);
                                    M0();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    y1();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    bill_edit.q2(bill_edit.p, str4);
                                }
                            } else {
                                dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                    dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                    Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                    if (dG1 < 0.0d) {
                                        if (dG1 < 0.0d) {
                                            dF1 = 0.0d;
                                        }
                                    } else if (dG1 < 0.0d) {
                                        dF1 = 0.0d;
                                    }
                                    bill_edit.t1 = bill_edit.C1.getText().toString();
                                }
                                d10 = dF1;
                                StringBuilder sb1117 = new StringBuilder();
                                sb1117.append(bill_edit.p);
                                sb1117.append(":");
                                sb1117.append(bill_edit.J);
                                sb1117.append(":q1=");
                                sb1117.append(d10);
                                sb1117.append(":q2=");
                                d11 = d9 * d8;
                                sb1117.append(C1839c10.C(d11, C1839c10.d));
                                sb1117.append(":q3=");
                                sb1117.append(d11);
                                sb1117.append(":");
                                sb1117.append(bill_edit.M);
                                Log.d("item_qty=", sb1117.toString());
                                if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                    if (bill_edit.t == 1) {
                                        str9 = "(";
                                        str = str3;
                                    } else {
                                        str9 = "(";
                                        str = str3;
                                    }
                                    if (!bill_edit.T.isChecked()) {
                                    }
                                } else {
                                    str4 = "0";
                                    str8 = str8;
                                    str5 = str5;
                                    str6 = str6;
                                    str7 = ":";
                                    d7 = d7;
                                    str = str3;
                                }
                                double dJ16 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                double dK16 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                if (bill_edit.i.ja(str6, true)) {
                                    z = z2;
                                } else {
                                    z = z2;
                                }
                                if (bill_edit.t == 1) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (O2 != 2) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                    if (O2 == 2) {
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0113 = bill_edit.i;
                                        StringBuilder sb1118 = new StringBuilder();
                                        sb1118.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb1118.append((Object) bill_edit.D1.getText());
                                        sb1118.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb1118.append((Object) bill_edit.D1.getText());
                                        sb1118.append("'),qty='");
                                        sb1118.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1118.append("',qty_t='");
                                        sb1118.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1118.append("',price='");
                                        sb1118.append(String.valueOf(dIc));
                                        sb1118.append("',unit_id=ifnull((select id from units where code='");
                                        sb1118.append(bill_edit.L1.getText().toString());
                                        sb1118.append("'),0),u_val='");
                                        sb1118.append(String.valueOf(d8));
                                        sb1118.append("',qty_pr=");
                                        sb1118.append(d9);
                                        sb1118.append(",curr_id=(select id from currency where name='");
                                        sb1118.append(bill_edit.q0.getText().toString());
                                        sb1118.append("') ,remark='");
                                        sb1118.append(bill_edit.A1.getText().toString());
                                        sb1118.append("',e_date=");
                                        textView2 = bill_edit.C1;
                                        if (textView2 != null) {
                                            str13 = "''";
                                        } else {
                                            str13 = "''";
                                        }
                                        sb1118.append(str13);
                                        sb1118.append(" where no_='");
                                        sb1118.append(bill_edit.J);
                                        sb1118.append("'");
                                        z0113.v0(sb1118.toString());
                                        k2();
                                    } else {
                                        double d113 = d9;
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0114 = bill_edit.i;
                                        StringBuilder sb1119 = new StringBuilder();
                                        sb1119.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb1119.append((Object) bill_edit.D1.getText());
                                        sb1119.append("'),(select item_type_id from items a where a.name='");
                                        sb1119.append((Object) bill_edit.D1.getText());
                                        sb1119.append("'),'");
                                        sb1119.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1119.append("','");
                                        sb1119.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb1119.append("','");
                                        sb1119.append(String.valueOf(dIc));
                                        sb1119.append("',(select id from currency where name='");
                                        sb1119.append(bill_edit.q0.getText().toString());
                                        sb1119.append("'),'");
                                        sb1119.append(bill_edit.A1.getText().toString());
                                        sb1119.append("',ifnull((select id from units where code='");
                                        sb1119.append(bill_edit.L1.getText().toString());
                                        sb1119.append(str5);
                                        sb1119.append(String.valueOf(d8));
                                        sb1119.append("',(select unit_id from items where name='");
                                        sb1119.append(bill_edit.D1.getText().toString());
                                        sb1119.append("'),");
                                        sb1119.append(d113);
                                        sb1119.append(str8);
                                        textView = bill_edit.C1;
                                        if (textView != null) {
                                            str12 = "''";
                                        } else {
                                            str12 = "''";
                                        }
                                        sb1119.append(str12);
                                        sb1119.append(" )");
                                        z0114.v0(sb1119.toString());
                                        k2();
                                        if (bill_edit.p == 0) {
                                            Z0();
                                            y1();
                                        }
                                    }
                                    bill_edit.x1.setText(str);
                                    M0();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    y1();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    bill_edit.q2(bill_edit.p, str4);
                                }
                            }
                            Log.d("edit_item_error=", exc.getMessage() + str);
                            exc.printStackTrace();
                        }
                        exc = e;
                        z = z2;
                        Log.d("edit_item_error=", exc.getMessage() + str);
                        exc.printStackTrace();
                    } else {
                        z2 = zA;
                        d5 = d3;
                        str2 = "";
                        d6 = 0.0d;
                        if (d2 >= d6) {
                            bill_edit = this;
                            d7 = d;
                            dIc = 0.0d;
                        } else {
                            bill_edit = this;
                            d7 = d;
                            dIc = 0.0d;
                        }
                        if (bill_edit.D1.getText().length() == 0) {
                            return false;
                        }
                        if (bill_edit.i.F6().contains(bill_edit.D1.getText().toString())) {
                            if (bill_edit.i.F6().contains(bill_edit.D1.getText().toString().trim())) {
                                AutoCompleteTextView autoCompleteTextView10 = bill_edit.D1;
                                autoCompleteTextView10.setText(autoCompleteTextView10.getText().toString().trim());
                                bill_edit.s1 = bill_edit.D1.getText().toString();
                                bill_edit.V0(bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item), bill_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item) + bill_edit.s1, bill_edit);
                                ArrayList arrayListG9 = bill_edit.i.G6();
                                C2160f10.c0(bill_edit, bill_edit.D1, arrayListG9, 2);
                                C1098Yv c1098Yv4 = new C1098Yv(bill_edit, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG9, 4);
                                bill_edit.C0 = c1098Yv4;
                                c1098Yv4.l.clear();
                                bill_edit.C0.notifyDataSetChanged();
                                bill_edit.D1.setAdapter(bill_edit.C0);
                                bill_edit.y1.setTag("1");
                                bill_edit.L1.setVisibility(8);
                                bill_edit.L1.setText(bill_edit.i.X6(bill_edit.D1.getText().toString()));
                                str3 = str2;
                                bill_edit.C1.setText(str3);
                                bill_edit.q2(bill_edit.p, "-1");
                                z3 = false;
                                d8 = 1.0d;
                            } else {
                                str3 = str2;
                                d8 = d5;
                                z3 = true;
                            }
                            if (z3) {
                            }
                            if (!bill_edit.D1.getText().toString().equals(bill_edit.D1.getText().toString().trim())) {
                                AutoCompleteTextView autoCompleteTextView11 = bill_edit.D1;
                                autoCompleteTextView11.setText(autoCompleteTextView11.getText().toString().trim());
                            }
                            bill_edit.i.D = false;
                            str4 = "0";
                            if (bill_edit.q0.getText() != null) {
                                bill_edit.i.u(bill_edit, bill_edit.q0.getText().toString(), bill_edit.U.getText().toString(), bill_edit.getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                                if (!bill_edit.i.D) {
                                    return false;
                                }
                            }
                            str5 = "'),0),'";
                            str6 = "prefOthers_update_item_price";
                            if (bill_edit.t == 1) {
                                d9 = d4;
                            } else {
                                d9 = d4;
                            }
                            str7 = ":";
                            if (bill_edit.t != 1) {
                                dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                    dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                    Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                    if (dG1 < 0.0d) {
                                        if (dG1 < 0.0d) {
                                            dF1 = 0.0d;
                                        }
                                    } else if (dG1 < 0.0d) {
                                        dF1 = 0.0d;
                                    }
                                    bill_edit.t1 = bill_edit.C1.getText().toString();
                                }
                                d10 = dF1;
                                StringBuilder sb11110 = new StringBuilder();
                                sb11110.append(bill_edit.p);
                                sb11110.append(":");
                                sb11110.append(bill_edit.J);
                                sb11110.append(":q1=");
                                sb11110.append(d10);
                                sb11110.append(":q2=");
                                d11 = d9 * d8;
                                sb11110.append(C1839c10.C(d11, C1839c10.d));
                                sb11110.append(":q3=");
                                sb11110.append(d11);
                                sb11110.append(":");
                                sb11110.append(bill_edit.M);
                                Log.d("item_qty=", sb11110.toString());
                                if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                    if (bill_edit.t == 1) {
                                        str9 = "(";
                                        str = str3;
                                    } else {
                                        str9 = "(";
                                        str = str3;
                                    }
                                    if (!bill_edit.T.isChecked()) {
                                    }
                                } else {
                                    str4 = "0";
                                    str8 = str8;
                                    str5 = str5;
                                    str6 = str6;
                                    str7 = ":";
                                    d7 = d7;
                                    str = str3;
                                }
                                double dJ17 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                double dK17 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                if (bill_edit.i.ja(str6, true)) {
                                    z = z2;
                                } else {
                                    z = z2;
                                }
                                if (bill_edit.t == 1) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (O2 != 2) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                    if (O2 == 2) {
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0115 = bill_edit.i;
                                        StringBuilder sb11111 = new StringBuilder();
                                        sb11111.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb11111.append((Object) bill_edit.D1.getText());
                                        sb11111.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb11111.append((Object) bill_edit.D1.getText());
                                        sb11111.append("'),qty='");
                                        sb11111.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11111.append("',qty_t='");
                                        sb11111.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11111.append("',price='");
                                        sb11111.append(String.valueOf(dIc));
                                        sb11111.append("',unit_id=ifnull((select id from units where code='");
                                        sb11111.append(bill_edit.L1.getText().toString());
                                        sb11111.append("'),0),u_val='");
                                        sb11111.append(String.valueOf(d8));
                                        sb11111.append("',qty_pr=");
                                        sb11111.append(d9);
                                        sb11111.append(",curr_id=(select id from currency where name='");
                                        sb11111.append(bill_edit.q0.getText().toString());
                                        sb11111.append("') ,remark='");
                                        sb11111.append(bill_edit.A1.getText().toString());
                                        sb11111.append("',e_date=");
                                        textView2 = bill_edit.C1;
                                        if (textView2 != null) {
                                            str13 = "''";
                                        } else {
                                            str13 = "''";
                                        }
                                        sb11111.append(str13);
                                        sb11111.append(" where no_='");
                                        sb11111.append(bill_edit.J);
                                        sb11111.append("'");
                                        z0115.v0(sb11111.toString());
                                        k2();
                                    } else {
                                        double d114 = d9;
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0116 = bill_edit.i;
                                        StringBuilder sb11112 = new StringBuilder();
                                        sb11112.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb11112.append((Object) bill_edit.D1.getText());
                                        sb11112.append("'),(select item_type_id from items a where a.name='");
                                        sb11112.append((Object) bill_edit.D1.getText());
                                        sb11112.append("'),'");
                                        sb11112.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11112.append("','");
                                        sb11112.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11112.append("','");
                                        sb11112.append(String.valueOf(dIc));
                                        sb11112.append("',(select id from currency where name='");
                                        sb11112.append(bill_edit.q0.getText().toString());
                                        sb11112.append("'),'");
                                        sb11112.append(bill_edit.A1.getText().toString());
                                        sb11112.append("',ifnull((select id from units where code='");
                                        sb11112.append(bill_edit.L1.getText().toString());
                                        sb11112.append(str5);
                                        sb11112.append(String.valueOf(d8));
                                        sb11112.append("',(select unit_id from items where name='");
                                        sb11112.append(bill_edit.D1.getText().toString());
                                        sb11112.append("'),");
                                        sb11112.append(d114);
                                        sb11112.append(str8);
                                        textView = bill_edit.C1;
                                        if (textView != null) {
                                            str12 = "''";
                                        } else {
                                            str12 = "''";
                                        }
                                        sb11112.append(str12);
                                        sb11112.append(" )");
                                        z0116.v0(sb11112.toString());
                                        k2();
                                        if (bill_edit.p == 0) {
                                            Z0();
                                            y1();
                                        }
                                    }
                                    bill_edit.x1.setText(str);
                                    M0();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    y1();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    bill_edit.q2(bill_edit.p, str4);
                                }
                            } else {
                                dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                    dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                    Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                    if (dG1 < 0.0d) {
                                        if (dG1 < 0.0d) {
                                            dF1 = 0.0d;
                                        }
                                    } else if (dG1 < 0.0d) {
                                        dF1 = 0.0d;
                                    }
                                    bill_edit.t1 = bill_edit.C1.getText().toString();
                                }
                                d10 = dF1;
                                StringBuilder sb11113 = new StringBuilder();
                                sb11113.append(bill_edit.p);
                                sb11113.append(":");
                                sb11113.append(bill_edit.J);
                                sb11113.append(":q1=");
                                sb11113.append(d10);
                                sb11113.append(":q2=");
                                d11 = d9 * d8;
                                sb11113.append(C1839c10.C(d11, C1839c10.d));
                                sb11113.append(":q3=");
                                sb11113.append(d11);
                                sb11113.append(":");
                                sb11113.append(bill_edit.M);
                                Log.d("item_qty=", sb11113.toString());
                                if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                    if (bill_edit.t == 1) {
                                        str9 = "(";
                                        str = str3;
                                    } else {
                                        str9 = "(";
                                        str = str3;
                                    }
                                    if (!bill_edit.T.isChecked()) {
                                    }
                                } else {
                                    str4 = "0";
                                    str8 = str8;
                                    str5 = str5;
                                    str6 = str6;
                                    str7 = ":";
                                    d7 = d7;
                                    str = str3;
                                }
                                double dJ18 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                double dK18 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                if (bill_edit.i.ja(str6, true)) {
                                    z = z2;
                                } else {
                                    z = z2;
                                }
                                if (bill_edit.t == 1) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (O2 != 2) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                    if (O2 == 2) {
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0117 = bill_edit.i;
                                        StringBuilder sb11114 = new StringBuilder();
                                        sb11114.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb11114.append((Object) bill_edit.D1.getText());
                                        sb11114.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb11114.append((Object) bill_edit.D1.getText());
                                        sb11114.append("'),qty='");
                                        sb11114.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11114.append("',qty_t='");
                                        sb11114.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11114.append("',price='");
                                        sb11114.append(String.valueOf(dIc));
                                        sb11114.append("',unit_id=ifnull((select id from units where code='");
                                        sb11114.append(bill_edit.L1.getText().toString());
                                        sb11114.append("'),0),u_val='");
                                        sb11114.append(String.valueOf(d8));
                                        sb11114.append("',qty_pr=");
                                        sb11114.append(d9);
                                        sb11114.append(",curr_id=(select id from currency where name='");
                                        sb11114.append(bill_edit.q0.getText().toString());
                                        sb11114.append("') ,remark='");
                                        sb11114.append(bill_edit.A1.getText().toString());
                                        sb11114.append("',e_date=");
                                        textView2 = bill_edit.C1;
                                        if (textView2 != null) {
                                            str13 = "''";
                                        } else {
                                            str13 = "''";
                                        }
                                        sb11114.append(str13);
                                        sb11114.append(" where no_='");
                                        sb11114.append(bill_edit.J);
                                        sb11114.append("'");
                                        z0117.v0(sb11114.toString());
                                        k2();
                                    } else {
                                        double d115 = d9;
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0118 = bill_edit.i;
                                        StringBuilder sb11115 = new StringBuilder();
                                        sb11115.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb11115.append((Object) bill_edit.D1.getText());
                                        sb11115.append("'),(select item_type_id from items a where a.name='");
                                        sb11115.append((Object) bill_edit.D1.getText());
                                        sb11115.append("'),'");
                                        sb11115.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11115.append("','");
                                        sb11115.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11115.append("','");
                                        sb11115.append(String.valueOf(dIc));
                                        sb11115.append("',(select id from currency where name='");
                                        sb11115.append(bill_edit.q0.getText().toString());
                                        sb11115.append("'),'");
                                        sb11115.append(bill_edit.A1.getText().toString());
                                        sb11115.append("',ifnull((select id from units where code='");
                                        sb11115.append(bill_edit.L1.getText().toString());
                                        sb11115.append(str5);
                                        sb11115.append(String.valueOf(d8));
                                        sb11115.append("',(select unit_id from items where name='");
                                        sb11115.append(bill_edit.D1.getText().toString());
                                        sb11115.append("'),");
                                        sb11115.append(d115);
                                        sb11115.append(str8);
                                        textView = bill_edit.C1;
                                        if (textView != null) {
                                            str12 = "''";
                                        } else {
                                            str12 = "''";
                                        }
                                        sb11115.append(str12);
                                        sb11115.append(" )");
                                        z0118.v0(sb11115.toString());
                                        k2();
                                        if (bill_edit.p == 0) {
                                            Z0();
                                            y1();
                                        }
                                    }
                                    bill_edit.x1.setText(str);
                                    M0();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    y1();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    bill_edit.q2(bill_edit.p, str4);
                                }
                            }
                            Log.d("edit_item_error=", exc.getMessage() + str);
                            exc.printStackTrace();
                        } else {
                            str3 = str2;
                            d8 = d5;
                            z3 = true;
                            if (z3) {
                            }
                            if (!bill_edit.D1.getText().toString().equals(bill_edit.D1.getText().toString().trim())) {
                                AutoCompleteTextView autoCompleteTextView12 = bill_edit.D1;
                                autoCompleteTextView12.setText(autoCompleteTextView12.getText().toString().trim());
                            }
                            bill_edit.i.D = false;
                            str4 = "0";
                            if (bill_edit.q0.getText() != null) {
                                bill_edit.i.u(bill_edit, bill_edit.q0.getText().toString(), bill_edit.U.getText().toString(), bill_edit.getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                                if (!bill_edit.i.D) {
                                    return false;
                                }
                            }
                            str5 = "'),0),'";
                            str6 = "prefOthers_update_item_price";
                            if (bill_edit.t == 1) {
                                d9 = d4;
                            } else {
                                d9 = d4;
                            }
                            str7 = ":";
                            if (bill_edit.t != 1) {
                                dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                    dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                    Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                    if (dG1 < 0.0d) {
                                        if (dG1 < 0.0d) {
                                            dF1 = 0.0d;
                                        }
                                    } else if (dG1 < 0.0d) {
                                        dF1 = 0.0d;
                                    }
                                    bill_edit.t1 = bill_edit.C1.getText().toString();
                                }
                                d10 = dF1;
                                StringBuilder sb11116 = new StringBuilder();
                                sb11116.append(bill_edit.p);
                                sb11116.append(":");
                                sb11116.append(bill_edit.J);
                                sb11116.append(":q1=");
                                sb11116.append(d10);
                                sb11116.append(":q2=");
                                d11 = d9 * d8;
                                sb11116.append(C1839c10.C(d11, C1839c10.d));
                                sb11116.append(":q3=");
                                sb11116.append(d11);
                                sb11116.append(":");
                                sb11116.append(bill_edit.M);
                                Log.d("item_qty=", sb11116.toString());
                                if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                    if (bill_edit.t == 1) {
                                        str9 = "(";
                                        str = str3;
                                    } else {
                                        str9 = "(";
                                        str = str3;
                                    }
                                    if (!bill_edit.T.isChecked()) {
                                    }
                                } else {
                                    str4 = "0";
                                    str8 = str8;
                                    str5 = str5;
                                    str6 = str6;
                                    str7 = ":";
                                    d7 = d7;
                                    str = str3;
                                }
                                double dJ19 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                double dK19 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                if (bill_edit.i.ja(str6, true)) {
                                    z = z2;
                                } else {
                                    z = z2;
                                }
                                if (bill_edit.t == 1) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (O2 != 2) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                    if (O2 == 2) {
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z0119 = bill_edit.i;
                                        StringBuilder sb11117 = new StringBuilder();
                                        sb11117.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb11117.append((Object) bill_edit.D1.getText());
                                        sb11117.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb11117.append((Object) bill_edit.D1.getText());
                                        sb11117.append("'),qty='");
                                        sb11117.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11117.append("',qty_t='");
                                        sb11117.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11117.append("',price='");
                                        sb11117.append(String.valueOf(dIc));
                                        sb11117.append("',unit_id=ifnull((select id from units where code='");
                                        sb11117.append(bill_edit.L1.getText().toString());
                                        sb11117.append("'),0),u_val='");
                                        sb11117.append(String.valueOf(d8));
                                        sb11117.append("',qty_pr=");
                                        sb11117.append(d9);
                                        sb11117.append(",curr_id=(select id from currency where name='");
                                        sb11117.append(bill_edit.q0.getText().toString());
                                        sb11117.append("') ,remark='");
                                        sb11117.append(bill_edit.A1.getText().toString());
                                        sb11117.append("',e_date=");
                                        textView2 = bill_edit.C1;
                                        if (textView2 != null) {
                                            str13 = "''";
                                        } else {
                                            str13 = "''";
                                        }
                                        sb11117.append(str13);
                                        sb11117.append(" where no_='");
                                        sb11117.append(bill_edit.J);
                                        sb11117.append("'");
                                        z0119.v0(sb11117.toString());
                                        k2();
                                    } else {
                                        double d116 = d9;
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z01110 = bill_edit.i;
                                        StringBuilder sb11118 = new StringBuilder();
                                        sb11118.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb11118.append((Object) bill_edit.D1.getText());
                                        sb11118.append("'),(select item_type_id from items a where a.name='");
                                        sb11118.append((Object) bill_edit.D1.getText());
                                        sb11118.append("'),'");
                                        sb11118.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11118.append("','");
                                        sb11118.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb11118.append("','");
                                        sb11118.append(String.valueOf(dIc));
                                        sb11118.append("',(select id from currency where name='");
                                        sb11118.append(bill_edit.q0.getText().toString());
                                        sb11118.append("'),'");
                                        sb11118.append(bill_edit.A1.getText().toString());
                                        sb11118.append("',ifnull((select id from units where code='");
                                        sb11118.append(bill_edit.L1.getText().toString());
                                        sb11118.append(str5);
                                        sb11118.append(String.valueOf(d8));
                                        sb11118.append("',(select unit_id from items where name='");
                                        sb11118.append(bill_edit.D1.getText().toString());
                                        sb11118.append("'),");
                                        sb11118.append(d116);
                                        sb11118.append(str8);
                                        textView = bill_edit.C1;
                                        if (textView != null) {
                                            str12 = "''";
                                        } else {
                                            str12 = "''";
                                        }
                                        sb11118.append(str12);
                                        sb11118.append(" )");
                                        z01110.v0(sb11118.toString());
                                        k2();
                                        if (bill_edit.p == 0) {
                                            Z0();
                                            y1();
                                        }
                                    }
                                    bill_edit.x1.setText(str);
                                    M0();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    y1();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    bill_edit.q2(bill_edit.p, str4);
                                }
                            } else {
                                dF1 = bill_edit.f1(bill_edit.p, bill_edit.J);
                                if (bill_edit.i.ja("prefOthers_item_end_date", false)) {
                                    dG1 = bill_edit.g1(bill_edit.p, bill_edit.J, bill_edit.C1.getText().toString());
                                    Log.d("item_qty=", bill_edit.p + ":" + bill_edit.J + ":" + dF1 + ":" + dG1 + ":" + (d9 * d8));
                                    if (dG1 < 0.0d) {
                                        if (dG1 < 0.0d) {
                                            dF1 = 0.0d;
                                        }
                                    } else if (dG1 < 0.0d) {
                                        dF1 = 0.0d;
                                    }
                                    bill_edit.t1 = bill_edit.C1.getText().toString();
                                }
                                d10 = dF1;
                                StringBuilder sb11119 = new StringBuilder();
                                sb11119.append(bill_edit.p);
                                sb11119.append(":");
                                sb11119.append(bill_edit.J);
                                sb11119.append(":q1=");
                                sb11119.append(d10);
                                sb11119.append(":q2=");
                                d11 = d9 * d8;
                                sb11119.append(C1839c10.C(d11, C1839c10.d));
                                sb11119.append(":q3=");
                                sb11119.append(d11);
                                sb11119.append(":");
                                sb11119.append(bill_edit.M);
                                Log.d("item_qty=", sb11119.toString());
                                if (d10 - C1839c10.C(d11, C1839c10.d) < 0.0d) {
                                    if (bill_edit.t == 1) {
                                        str9 = "(";
                                        str = str3;
                                    } else {
                                        str9 = "(";
                                        str = str3;
                                    }
                                    if (!bill_edit.T.isChecked()) {
                                    }
                                } else {
                                    str4 = "0";
                                    str8 = str8;
                                    str5 = str5;
                                    str6 = str6;
                                    str7 = ":";
                                    d7 = d7;
                                    str = str3;
                                }
                                double dJ110 = bill_edit.i.J6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 1, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                double dK110 = bill_edit.i.K6(bill_edit.D1.getText().toString(), bill_edit.q0.getText().toString(), 2, bill_edit.T.isChecked(), bill_edit.f1 + str, bill_edit.t, bill_edit.L1.getText().toString());
                                if (bill_edit.i.ja(str6, true)) {
                                    z = z2;
                                } else {
                                    z = z2;
                                }
                                if (bill_edit.t == 1) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (O2 != 2) {
                                    bill_edit.i.Kd(bill_edit, bill_edit.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) bill_edit.A0.getText()) + str7 + O2);
                                    if (O2 == 2) {
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z01111 = bill_edit.i;
                                        StringBuilder sb111110 = new StringBuilder();
                                        sb111110.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb111110.append((Object) bill_edit.D1.getText());
                                        sb111110.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb111110.append((Object) bill_edit.D1.getText());
                                        sb111110.append("'),qty='");
                                        sb111110.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb111110.append("',qty_t='");
                                        sb111110.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb111110.append("',price='");
                                        sb111110.append(String.valueOf(dIc));
                                        sb111110.append("',unit_id=ifnull((select id from units where code='");
                                        sb111110.append(bill_edit.L1.getText().toString());
                                        sb111110.append("'),0),u_val='");
                                        sb111110.append(String.valueOf(d8));
                                        sb111110.append("',qty_pr=");
                                        sb111110.append(d9);
                                        sb111110.append(",curr_id=(select id from currency where name='");
                                        sb111110.append(bill_edit.q0.getText().toString());
                                        sb111110.append("') ,remark='");
                                        sb111110.append(bill_edit.A1.getText().toString());
                                        sb111110.append("',e_date=");
                                        textView2 = bill_edit.C1;
                                        if (textView2 != null) {
                                            str13 = "''";
                                        } else {
                                            str13 = "''";
                                        }
                                        sb111110.append(str13);
                                        sb111110.append(" where no_='");
                                        sb111110.append(bill_edit.J);
                                        sb111110.append("'");
                                        z01111.v0(sb111110.toString());
                                        k2();
                                    } else {
                                        double d117 = d9;
                                        if (bill_edit.p != 0) {
                                            g2();
                                        }
                                        Z00 z01112 = bill_edit.i;
                                        StringBuilder sb111111 = new StringBuilder();
                                        sb111111.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb111111.append((Object) bill_edit.D1.getText());
                                        sb111111.append("'),(select item_type_id from items a where a.name='");
                                        sb111111.append((Object) bill_edit.D1.getText());
                                        sb111111.append("'),'");
                                        sb111111.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb111111.append("','");
                                        sb111111.append(bill_edit.B1.getText().toString().replaceAll(str8, str));
                                        sb111111.append("','");
                                        sb111111.append(String.valueOf(dIc));
                                        sb111111.append("',(select id from currency where name='");
                                        sb111111.append(bill_edit.q0.getText().toString());
                                        sb111111.append("'),'");
                                        sb111111.append(bill_edit.A1.getText().toString());
                                        sb111111.append("',ifnull((select id from units where code='");
                                        sb111111.append(bill_edit.L1.getText().toString());
                                        sb111111.append(str5);
                                        sb111111.append(String.valueOf(d8));
                                        sb111111.append("',(select unit_id from items where name='");
                                        sb111111.append(bill_edit.D1.getText().toString());
                                        sb111111.append("'),");
                                        sb111111.append(d117);
                                        sb111111.append(str8);
                                        textView = bill_edit.C1;
                                        if (textView != null) {
                                            str12 = "''";
                                        } else {
                                            str12 = "''";
                                        }
                                        sb111111.append(str12);
                                        sb111111.append(" )");
                                        z01112.v0(sb111111.toString());
                                        k2();
                                        if (bill_edit.p == 0) {
                                            Z0();
                                            y1();
                                        }
                                    }
                                    bill_edit.x1.setText(str);
                                    M0();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    y1();
                                    bill_edit.q1 = 1;
                                    Z0();
                                    bill_edit.q2(bill_edit.p, str4);
                                }
                            }
                            Log.d("edit_item_error=", exc.getMessage() + str);
                            exc.printStackTrace();
                        }
                        exc = e;
                        z = z2;
                        Log.d("edit_item_error=", exc.getMessage() + str);
                        exc.printStackTrace();
                    }
                }
            } catch (Exception e15) {
                str = "";
                exc = e15;
                z = zA;
            }
        } catch (Exception e16) {
            str = "";
            exc = e16;
            z = true;
        }
        return z;
    }

    public void P1() {
        Log.d("back_edit=", this.K + ":" + this.L);
        if (this.K == 1) {
            P2 = true;
            Q2 = true;
            R2 = this.Y.getText().toString();
            finish();
            return;
        }
        int i = this.t;
        if (i == 1) {
            P2 = false;
            Intent intent = new Intent(this, (Class<?>) Bills2.class);
            intent.addFlags(67141632);
            intent.addFlags(1073741824);
            intent.putExtra("TR_TYPE", "1");
            intent.putExtra("g_id", this.l);
            intent.putExtra("g_name", this.n);
            startActivity(intent);
            finish();
            return;
        }
        if (i == 2) {
            P2 = false;
            Intent intent2 = new Intent(this, (Class<?>) Bills2.class);
            intent2.addFlags(67141632);
            intent2.addFlags(1073741824);
            intent2.putExtra("TR_TYPE", "2");
            intent2.putExtra("g_id", this.l);
            intent2.putExtra("g_name", this.n);
            startActivity(intent2);
            finish();
        }
    }

    public void Q0(Cursor cursor) {
        Integer num;
        int count = cursor.getCount();
        C1839c10.z(this.i, "fill_listview=", String.valueOf(count) + ":" + this.p + ":submit=" + this.r2 + ":zatca=" + this.s2);
        b2(false);
        this.T1 = 0;
        this.U1 = 0.0d;
        this.D0.clear();
        cursor.moveToFirst();
        double d = 0.0d;
        int i = 0;
        while (!cursor.isAfterLast()) {
            i++;
            this.D0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("item_name")), cursor.getString(cursor.getColumnIndex("item_type")), this.i.S7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("item_total")))), this.i.T7("" + cursor.getDouble(cursor.getColumnIndex("qty_t"))), this.i.S7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("item_price")))), cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tran_status")), cursor.getString(cursor.getColumnIndex("item_remarks")), cursor.getString(cursor.getColumnIndex("unit_name")), cursor.getString(cursor.getColumnIndex("unit_val")), cursor.getString(cursor.getColumnIndex("qty_pr")), cursor.getString(cursor.getColumnIndex("barcode")), cursor.getString(cursor.getColumnIndex("e_date"))));
            d += cursor.getDouble(cursor.getColumnIndex("item_price")) * cursor.getDouble(cursor.getColumnIndex("qty_pr"));
            long j = this.p;
            if (j != 0 && i == count) {
                this.y0.setText(cursor.getString(cursor.getColumnIndex("bill_type")));
                this.t = cursor.getInt(cursor.getColumnIndex("tr_type_id"));
                String string = cursor.getString(cursor.getColumnIndex("curr_name"));
                this.y = string;
                this.q0.setText(string);
                this.W.setText(cursor.getString(cursor.getColumnIndex("br_name")));
                int i2 = cursor.getInt(cursor.getColumnIndex("is_back"));
                if (i2 == 1) {
                    this.g1 = -1L;
                    this.f1 = cursor.getInt(cursor.getColumnIndex("bill_no"));
                    this.T.setChecked(i2 != 0);
                    if (this.f1 != 0) {
                        this.T.setEnabled(false);
                        this.q0.setEnabled(false);
                    }
                } else {
                    this.T.setChecked(i2 != 0);
                }
                if (cursor.getString(cursor.getColumnIndex("bill_type_id")).equals("1")) {
                    this.S.setChecked(true);
                    this.N2 = 0;
                    p2();
                    a1();
                } else {
                    this.S.setChecked(false);
                    this.N2 = 0;
                    p2();
                    a1();
                }
                this.Y.setText(cursor.getString(cursor.getColumnIndex("tr_name")));
                this.Y.dismissDropDown();
                this.U.setText(cursor.getString(cursor.getColumnIndex("date_")));
                this.i.nd(this.z0, cursor.getString(cursor.getColumnIndex("bill_no2")));
                this.U0.setText(cursor.getString(cursor.getColumnIndex("paid_amount")));
                double d2 = cursor.getDouble(cursor.getColumnIndex("paid_amount"));
                this.V1 = d2;
                if (d2 != 0.0d) {
                    this.r0.setVisibility(0);
                }
                this.r0.setText(cursor.getString(cursor.getColumnIndex("cash_name")));
                this.i.nd(this.A0, cursor.getString(cursor.getColumnIndex("remarks")));
                this.W1 = cursor.getDouble(cursor.getColumnIndex("t_val"));
                this.X1 = cursor.getDouble(cursor.getColumnIndex("tax_amount"));
                this.Z1 = cursor.getDouble(cursor.getColumnIndex("cost2"));
                this.a2 = cursor.getInt(cursor.getColumnIndex("cost_id"));
                this.R1 = (cursor.getDouble(cursor.getColumnIndex("amount")) - this.X1) - this.Z1;
                this.S1 = cursor.getDouble(cursor.getColumnIndex("d_amount"));
                this.T1 = cursor.getInt(cursor.getColumnIndex("discount_id"));
                this.U1 = cursor.getDouble(cursor.getColumnIndex("d_val"));
                Log.d("bill_total_disc=", this.S1 + ":" + this.T1 + ":" + this.U1);
                if (this.T1 == 0 && this.U1 == 0.0d) {
                    double d3 = this.S1;
                    if (d3 != 0.0d) {
                        this.U1 = d3;
                    }
                }
                if (cursor.getString(cursor.getColumnIndex("tran_status")).equals("3")) {
                    this.u0.setVisibility(4);
                }
                ImageView imageView = this.S0;
                if (imageView != null) {
                    imageView.setTag(cursor.getString(cursor.getColumnIndex("param1")) != null ? cursor.getString(cursor.getColumnIndex("param1")) : "");
                    if (this.S0.getTag().toString().equals("")) {
                        S1(this.S0);
                    } else {
                        X1(this.S0.getTag().toString());
                    }
                }
                this.j1 = cursor.getString(cursor.getColumnIndex("qr"));
                this.h1 = C1839c10.p(cursor, "z_unit_id");
                this.i1 = C1839c10.p(cursor, "z_status");
                this.W0.setVisibility(8);
                if (!C1839c10.w(cursor, "bill_z_status")) {
                    this.W0.setText(cursor.getString(cursor.getColumnIndex("bill_z_status")));
                    if (this.W0.getText().toString().length() > 0) {
                        if (this.r2 && (num = this.i1) != null && num.intValue() == 0) {
                            this.W0.setVisibility(8);
                        } else {
                            this.W0.setVisibility(0);
                        }
                        Integer num2 = this.i1;
                        if (num2 != null && num2.intValue() >= 0 && this.i1.intValue() <= 2) {
                            TextView textView = this.W0;
                            textView.setPaintFlags(textView.getPaintFlags() & (-9));
                        }
                        this.W0.setOnClickListener(new A());
                    }
                }
                if (!C1839c10.w(cursor, "z_reply")) {
                    this.k1 = cursor.getString(cursor.getColumnIndex("z_reply"));
                }
            } else if (j == 0 && getIntent().getStringExtra("bill_offer_id") != null) {
                String stringExtra = getIntent().getStringExtra("curr_name");
                this.y = stringExtra;
                this.q0.setText(stringExtra);
                this.W.setText(getIntent().getStringExtra("tr_branch"));
                this.Y.setText(getIntent().getStringExtra("tr_name"));
                this.Y.dismissDropDown();
                this.T1 = getIntent().getIntExtra("bill_disc_id", 0);
                this.U1 = getIntent().getDoubleExtra("bill_disc_val", 0.0d);
                this.R1 = Double.parseDouble(getIntent().getStringExtra("bill_total_"));
                this.S1 = Double.parseDouble(getIntent().getStringExtra("bill_total_disc"));
                this.W1 = Double.parseDouble(getIntent().getStringExtra("tax_val"));
                this.X1 = Double.parseDouble(getIntent().getStringExtra("tax_amount"));
                if (this.W1 > 0.0d) {
                    this.f0.setVisibility(0);
                    this.g0.setVisibility(0);
                    this.i0.setVisibility(0);
                    this.h0.setVisibility(0);
                }
            }
            cursor.moveToNext();
        }
        cursor.close();
        double d4 = this.R1;
        if ((d4 == 0.0d && this.S1 == 0.0d) || this.q1 == 1) {
            this.Z.setText(this.i.P7(String.valueOf(d)));
            this.b0.setText("0");
            this.d0.setText("0");
            this.U0.setText("0");
            this.V0.setText("0");
            this.q1 = 0;
            V1();
        } else {
            this.Z.setText(this.i.P7(String.valueOf(d4)));
            this.b0.setText(this.i.P7(String.valueOf(this.S1)));
            this.e0.setText(this.i.P7(String.valueOf(this.W1)));
            this.f0.setText(this.i.P7(String.valueOf(this.X1)));
            this.h0.setText(this.i.P7(String.valueOf(this.R1 + this.X1 + this.Z1)));
            this.d0.setText(this.i.P7(String.valueOf(this.Z1)));
            V1();
            this.U0.setText(this.i.P7(String.valueOf(this.V1)));
            this.V0.setText(this.i.P7(String.valueOf(((this.R1 + this.X1) + this.Z1) - this.V1)));
        }
        this.a0.setText(this.D0.size() + "");
        if (this.a0.getText().toString().equals("0")) {
            this.a0.setText("");
        }
        NumberFormat.getInstance(Locale.ENGLISH).format(0.0d);
        C0809Ov c0809Ov = new C0809Ov(this, info.aalmoghalis.inventory.R.layout.bill_item_det_row3, this.D0);
        this.B0 = c0809Ov;
        c0809Ov.j.clear();
        this.B0.notifyDataSetChanged();
        this.Q.setAdapter((ListAdapter) this.B0);
        if (this.p == 0) {
            this.N2 = 1;
        } else {
            this.N2 = 0;
        }
        invalidateOptionsMenu();
        SearchView searchView = this.m2;
        String string2 = (searchView == null || searchView.getQuery() == null) ? "" : this.m2.getQuery().toString();
        if (string2.length() > 0) {
            this.B0.getFilter().filter(string2, new B());
        }
        if (this.i.ja("prefOthers_closed_year", false)) {
            return;
        }
        if ((C1839c10.o(this.i) || getIntent().getStringExtra("fix_total") != null) && C1839c10.C((d - Double.valueOf(this.b0.getText().toString().replace(",", "")).doubleValue()) + Double.valueOf(this.f0.getText().toString().replace(",", "")).doubleValue() + Double.valueOf(this.d0.getText().toString().replace(",", "")).doubleValue(), 2) != C1839c10.C(Double.parseDouble(this.h0.getText().toString().replace(",", "")), 2)) {
            Log.d("bill_check=", "" + C1839c10.C((d - Double.valueOf(this.b0.getText().toString().replace(",", "")).doubleValue()) + Double.valueOf(this.f0.getText().toString().replace(",", "")).doubleValue() + Double.valueOf(this.d0.getText().toString().replace(",", "")).doubleValue(), 2) + ":" + C1839c10.C(Double.parseDouble(this.h0.getText().toString().replace(",", "")), 2) + ":" + this.N2);
            try {
                C1839c10.n(this.t, d, this.i, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Q1() {
        try {
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,ifnull(e_date,'')   from bill_transactions_v  where bill_id=" + this.p + " and bill_date='" + this.q + "' ");
        } catch (Exception unused) {
        }
    }

    public void R1() {
        this.D1.setText((CharSequence) null);
        this.B1.setText((CharSequence) null);
        this.y1.setText((CharSequence) null);
        this.z1.setText((CharSequence) null);
        this.A1.setText((CharSequence) null);
        this.D1.requestFocus();
        this.J = "0";
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String S0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        Toast.makeText(this, e.getMessage(), 1).show();
                        if (cursorQuery != null) {
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    public String T0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (n1(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (m1(uri)) {
                        return S0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (o1(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return S0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return S0(context, uri, null, null);
                }
                if (Annotation.FILE.equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
            Toast.makeText(this, "File Not Identified", 1).show();
            return null;
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
            return null;
        }
    }

    public boolean U0(String str, String str2, Context context, String str3, int i) {
        z1 z1Var = new z1();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new A1(z1Var, str3, i));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new B1(z1Var));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.b2;
    }

    public void U1() {
        e1(this.Y.getText().toString());
        E00 e00 = this.j;
        e00.m = this.p;
        e00.k = this.k;
        e00.n = this.U.getText().toString();
        this.j.o = this.q0.getText().toString();
    }

    public boolean V0(String str, String str2, Context context) {
        C1 c1 = new C1();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new D1(c1));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new E1(c1));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.b2;
    }

    public void V1() {
        double d = Double.parseDouble(this.e0.getText().toString());
        double d2 = Double.parseDouble(this.d0.getText().toString().replaceAll(",", ""));
        double d3 = Double.parseDouble(this.Z.getText().toString().replaceAll(",", ""));
        double d4 = Double.parseDouble(this.U0.getText().toString().replaceAll(",", ""));
        double d5 = (d * d3) / 100.0d;
        double d6 = d3 + d5 + d2;
        this.f0.setText(this.i.P7(d5 + ""));
        this.h0.setText(this.i.P7(d6 + ""));
        this.d0.setText(this.i.P7(d2 + ""));
        this.V0.setText(this.i.P7((d6 - d4) + ""));
        this.i0.setVisibility(0);
        this.h0.setVisibility(0);
        if (!this.e0.getText().toString().equals("0") && !this.d0.getText().toString().replaceAll(",", "").equals("0") && this.p != 0) {
            this.f0.setVisibility(0);
            this.g0.setVisibility(0);
            this.i0.setVisibility(0);
            this.h0.setVisibility(0);
            this.k0.setVisibility(0);
        } else if (this.p == 0 || (this.e0.getText().toString().equals("0") && this.d0.getText().toString().replaceAll(",", "").equals("0"))) {
            this.f0.setVisibility(4);
            this.g0.setVisibility(4);
            this.i0.setVisibility(4);
            this.h0.setVisibility(4);
            if (this.p == 0 && this.W1 > 0.0d) {
                this.h0.setVisibility(0);
            }
        } else if (this.e0.getText().toString().equals("0")) {
            this.f0.setVisibility(4);
            this.g0.setVisibility(4);
        }
        if (this.e0.getText().toString().equals("0")) {
            return;
        }
        this.f0.setVisibility(0);
        this.g0.setVisibility(0);
        this.k0.setVisibility(0);
    }

    public boolean W0(String str, String str2, Context context) {
        HandlerC2613p handlerC2613p = new HandlerC2613p();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2616q(handlerC2613p));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2619r(handlerC2613p));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.i2;
    }

    public void W1() {
        this.M1.setOnClickListener(new ViewOnClickListenerC2623s0());
        this.O1.setOnClickListener(new ViewOnClickListenerC2626t0());
        this.P1.setOnClickListener(new ViewOnClickListenerC2632v0());
        this.K1.setOnClickListener(new ViewOnClickListenerC2634w0());
        this.B1.addTextChangedListener(this.c1);
        this.y1.addTextChangedListener(this.c1);
        this.z1.addTextChangedListener(this.c1);
        this.B1.setOnTouchListener(new ViewOnTouchListenerC2636x0());
        this.y1.setOnTouchListener(new ViewOnTouchListenerC2638y0());
        this.z1.setOnTouchListener(new ViewOnTouchListenerC2640z0());
    }

    public boolean X0(String str, String str2, Context context, String str3, String str4, String str5) {
        F1 f1 = new F1();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new G1(str3, str4, str5, f1));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new H1(f1));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.b2;
    }

    public void X1(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            this.S0.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
            this.S0.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
            this.S0.setImageBitmap(bitmapP0);
            this.S0.setTag(str);
        } catch (Exception unused) {
        }
    }

    public boolean Y0(String str, String str2, Context context) {
        R r = new R();
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new S(r));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new T(r));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.h2;
    }

    public void Y1() {
        this.f2.setOnCheckedChangeListener(new A0());
        this.c2.setOnClickListener(new B0());
        this.d2.setOnClickListener(new C0());
        Calendar calendar = Calendar.getInstance();
        this.X.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.N = calendar.get(1);
        this.O = calendar.get(2);
        this.P = calendar.get(5);
        this.X.setOnClickListener(new D0());
        this.G1.addTextChangedListener(this.d1);
        this.E1.addTextChangedListener(this.d1);
        this.F1.addTextChangedListener(this.d1);
        this.G1.setOnTouchListener(new E0());
        this.E1.setOnTouchListener(new G0());
        this.F1.setOnTouchListener(new H0());
    }

    public void Z0() {
        try {
            Log.d("get_all_name=", "Yes:" + this.p);
            long j = this.p;
            if (j != 0) {
                Q0(this.i.Z1(String.valueOf(j), this.q));
                ArrayList arrayListY1 = this.i.Y1(this.p + "");
                this.Y0 = arrayListY1;
                if (arrayListY1 == null || arrayListY1.size() <= 0) {
                    this.V.setVisibility(8);
                } else {
                    this.V.setVisibility(0);
                }
            } else {
                Q0(this.i.f2());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Fetch_error=", e.getMessage() + "");
            String strSubstring = e.getMessage() + "";
            StringBuilder sb = new StringBuilder();
            sb.append("Fetch_Error:");
            if (strSubstring != null && strSubstring.length() > 20) {
                strSubstring = strSubstring.substring(0, 20);
            }
            sb.append(strSubstring);
            Toast.makeText(this, sb.toString(), 0).show();
        }
    }

    public void Z1() {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        String[] stringArray = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_share_tr);
        TypedArray typedArrayObtainTypedArray = getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons_share_tr);
        ListView listView = new ListView(this);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stringArray.length; i++) {
            arrayList.add(new C3874sM(stringArray[i], typedArrayObtainTypedArray.getResourceId(i, -1)));
        }
        typedArrayObtainTypedArray.recycle();
        listView.setAdapter((ListAdapter) new C4062ug(this, arrayList));
        listView.setOnItemClickListener(new C2599k0(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        listView.setDividerHeight(0);
        linearLayout.addView(listView, -1, -1);
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void a1() {
        if (this.S.isChecked()) {
            this.y0.setText(getString(info.aalmoghalis.inventory.R.string.bill_cash));
        } else {
            this.y0.setText(getString(info.aalmoghalis.inventory.R.string.bill_post));
        }
        Cursor cursorW8 = this.i.w8(this.t);
        this.M0 = new String[cursorW8.getCount()];
        if (cursorW8.moveToFirst()) {
            int i = 0;
            do {
                this.M0[i] = cursorW8.getString(cursorW8.getColumnIndex("_id"));
                i++;
            } while (cursorW8.moveToNext());
        }
        cursorW8.close();
        this.G0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.M0);
        this.Y.setThreshold(1);
        this.Y.setAdapter(this.G0);
    }

    public void a2() {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        this.c = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_share_bill2);
        this.d = getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons_share_bill2);
        ListView listView = new ListView(this);
        this.F2 = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = this.c;
            if (i >= strArr.length) {
                this.d.recycle();
                C4062ug c4062ug = new C4062ug(this, this.F2);
                this.G2 = c4062ug;
                listView.setAdapter((ListAdapter) c4062ug);
                listView.setOnItemClickListener(new C2575c0(dialog));
                linearLayout.setFocusable(true);
                listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                listView.setDividerHeight(0);
                linearLayout.addView(listView, -1, -1);
                dialog.requestWindowFeature(1);
                dialog.setContentView(linearLayout);
                dialog.show();
                return;
            }
            this.F2.add(new C3874sM(strArr[i], this.d.getResourceId(i, -1)));
            i++;
        }
    }

    public void add_item(View view) {
        this.B = "";
        this.D = "";
        this.H = "";
        this.C = "";
        this.I = "";
        if (this.x1.getText() == null || this.x1.getText().toString().equals("")) {
            this.B = "";
            this.D = "";
            this.H = "";
            this.C = "";
            this.I = "";
        } else if (this.i.F6().contains(this.x1.getText().toString())) {
            double dJ6 = this.i.J6(this.x1.getText().toString(), this.q0.getText().toString(), this.t, this.T.isChecked(), this.f1 + "", this.t, this.i.X6(this.x1.getText().toString()));
            this.B = this.x1.getText().toString();
            this.D = dJ6 > 0.0d ? this.i.S7(String.valueOf(dJ6)) : "";
        } else {
            this.B = this.x1.getText().toString();
        }
        O2 = 1;
        u2();
    }

    public void add_item2(View view) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_item_edit2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new V0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new W0(viewInflate));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new X0(autoCompleteTextView, viewInflate, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item2_error=", e.getMessage());
        }
    }

    public HashMap b1() {
        HashMap map = new HashMap();
        map.put("tr_total_disc", this.b0.getText().toString().replace(",", ""));
        map.put("tr_total", this.h0.getText().toString().replace(",", ""));
        map.put("tr_tax", this.f0.getText().toString().replace(",", ""));
        map.put("tr_total_cost", this.d0.getText().toString().replace(",", ""));
        map.put("tr_paid", this.U0.getText().toString().replace(",", ""));
        map.put("tr_remin", this.V0.getText().toString().replace(",", ""));
        map.put("tr_cus_name", this.Y.getText().toString());
        map.put("tr_curr_name", this.q0.getText().toString());
        return map;
    }

    public void b2(boolean z) {
        this.S0.setOnClickListener(new H(z));
    }

    public void barcode_click(View view) {
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.J1 = 1;
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.J1 = 2;
        }
        if (this.i.ia("pref_barcode_type", "1").equals("1")) {
            this.i.Td(this);
            return;
        }
        Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.usb_barcode), 0).show();
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.x1.requestFocus();
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.D1.requestFocus();
        }
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.o1 = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_hide(View view) {
        this.w0.setVisibility(8);
        this.x0.setVisibility(0);
        this.u0.setVisibility(0);
        d2();
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.no_);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new w1(textView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new y1());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.w0.setVisibility(0);
        this.u0.setVisibility(4);
        this.x1.requestFocus();
        d2();
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(info.aalmoghalis.inventory.R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(info.aalmoghalis.inventory.R.id.page_name);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(info.aalmoghalis.inventory.R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(info.aalmoghalis.inventory.R.string.disable) + "#" + ((Object) textView.getText()) + "?");
        }
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2630u1(textView, imageView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new v1());
        builder.create().show();
    }

    public void c1() {
        Log.d("item_remarks=", "..start...");
        C1044Xj.a().c(new RunnableC1171Zj(16, this.i, this.D1, this.A1, this, new RunnableC1086Yj()));
    }

    public void c2(int i) {
        String str;
        int i2 = 0;
        if (i == 0) {
            try {
                if (!this.i.ja("pref_print_balance", false)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        AutoCompleteTextView autoCompleteTextView = this.Y;
        if (autoCompleteTextView == null || autoCompleteTextView.getText().length() <= 0) {
            return;
        }
        double d = Double.parseDouble((String) this.i.X3(this.Y.getText().toString(), this.q0.getText().toString()).get(0));
        String strQ2 = d < 0.0d ? this.i.Q2() : this.i.c5();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(info.aalmoghalis.inventory.R.string.total_header));
        if (d != 0.0d) {
            str = " " + strQ2;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(" ");
        sb.append(this.i.P7(Math.abs(d) + ""));
        sb.append(" ");
        sb.append(this.i.g3(this.q0.getText().toString()));
        String string = sb.toString();
        if (i != 0) {
            i2 = 1;
        }
        Toast.makeText(this, string, i2).show();
    }

    public void e1(String str) {
        C4143vg c4143vgQ4 = this.i.q4(str);
        if (c4143vgQ4.i().equals("")) {
            return;
        }
        this.k = c4143vgQ4.i();
        this.A2 = c4143vgQ4.j();
        this.D2 = c4143vgQ4.h();
        this.C2 = "0";
        this.B2 = c4143vgQ4.f();
    }

    public void e2(String str) {
        Log.d("trace_snack=", "start=");
        if (C1839c10.k(this.i, this.k)) {
            try {
                u0();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.i.ja("prefAutoNotify", false) || this.S.isChecked()) {
            i1();
            return;
        }
        Snackbar snackbarMake = Snackbar.make(this.Q, "", -2);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
        TextView textView = (TextView) snackbarLayout.findViewById(info.aalmoghalis.inventory.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, info.aalmoghalis.inventory.R.color.white));
        C4064uh c4064uhQ0 = this.i.Q0(str, this.q0.getText().toString(), this.p);
        if (c4064uhQ0 == null) {
            i1();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c4064uhQ0.t() == this.J2[0] ? this.i.Q2() : this.i.c5());
        sb.append(" ");
        sb.append(c4064uhQ0.n());
        sb.append(" ");
        sb.append(c4064uhQ0.r());
        snackbarMake.setText(sb.toString());
        snackbarMake.setAction(getString(info.aalmoghalis.inventory.R.string.hide_tr), new ViewOnClickListenerC2587g0(snackbarMake));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_share), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setOnClickListener(new ViewOnClickListenerC2590h0());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();
        layoutParams.gravity = 16;
        snackbarLayout.setLayoutParams(layoutParams);
        ViewCompat.setLayoutDirection(snackbarMake.getView(), 1);
        snackbarMake.show();
        new Handler().postDelayed(new RunnableC2593i0(snackbarMake), 5000);
    }

    public double f1(long j, String str) {
        Z00 z00 = this.i;
        StringBuilder sb = new StringBuilder();
        sb.append(":p1=");
        sb.append(A0(this.D1.getText().toString(), this.n));
        sb.append(":p2=");
        sb.append(new C1839c10(this.i).u(j + "", str, this.W.getText().toString(), "", this.t, this.T.isChecked(), this.D1.getText().toString()));
        C1839c10.z(z00, "trace_qty=", sb.toString());
        return A0(this.D1.getText().toString(), this.n).doubleValue() - new C1839c10(this.i).u(j + "", str, this.W.getText().toString(), "", this.t, this.T.isChecked(), this.D1.getText().toString());
    }

    public void f2() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.i.J2(this, intent);
            this.z2 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.z2.getPath() + "");
            startActivityForResult(intent, this.v2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double g1(long j, String str, String str2) {
        return C0(this.D1.getText().toString(), this.n, str2).doubleValue() - new C1839c10(this.i).u(j + "", str, this.W.getText().toString(), str2, this.t, this.T.isChecked(), this.D1.getText().toString());
    }

    public void g2() {
        String str;
        String string;
        String string2;
        String str2;
        String str3;
        String str4;
        String string3;
        try {
            K1();
            int i = this.S.isChecked() ? 1 : 2;
            if (z0()) {
                if (this.i.v8(this.Y.getText().toString(), this.t).getCount() == 0 && this.i.v8(this.Y.getText().toString().trim(), this.t).getCount() == 0) {
                    AutoCompleteTextView autoCompleteTextView = this.Y;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                    U0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.Y.getText().toString(), this, this.Y.getText().toString(), this.t);
                    if (!this.b2) {
                        return;
                    }
                }
                if (!this.Y.getText().toString().equals(this.Y.getText().toString().trim()) && this.i.v8(this.Y.getText().toString().trim(), this.t).getCount() > 0) {
                    AutoCompleteTextView autoCompleteTextView2 = this.Y;
                    autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                }
                if (this.i.v8(this.Y.getText().toString(), this.t).getCount() == 0) {
                    this.Y.setError("Not Inserted!");
                    return;
                }
                this.i.D = false;
                if (this.q0.getText() != null && !this.q0.getText().toString().equals(this.i.l3("0")) && this.i.Z2(this.q0.getText().toString(), this.U.getText().toString()) == 0) {
                    this.i.u(this, this.q0.getText().toString(), this.U.getText().toString(), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                    if (!this.i.D) {
                        return;
                    }
                }
                if (this.i.g2().getCount() == 0 || this.i.ja("prefOthers_closed_year", false)) {
                    return;
                }
                boolean zD0 = D0();
                if (this.t != 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("update bills set date_='");
                    sb.append((Object) this.U.getText());
                    sb.append("',amount='");
                    sb.append(this.h0.getText().toString().replaceAll(",", ""));
                    sb.append("',d_amount='");
                    sb.append(this.b0.getText().toString().replaceAll(",", ""));
                    sb.append("',t_val='");
                    sb.append(this.e0.getText().toString().replaceAll(",", ""));
                    sb.append("',tax_amount='");
                    sb.append(this.f0.getText().toString().replaceAll(",", ""));
                    sb.append("',cost2='");
                    sb.append(this.d0.getText().toString().replaceAll(",", ""));
                    sb.append("',cus_id=(select id from customers where name='");
                    sb.append((Object) this.Y.getText());
                    sb.append("' ),br_id=(select id from branches where name='");
                    sb.append((Object) this.W.getText());
                    sb.append("' ),cash_id=(select id from customers where name='");
                    sb.append((Object) this.r0.getText());
                    sb.append("' ),bill_type=");
                    sb.append(i);
                    sb.append(",bill_no2='");
                    sb.append((Object) this.z0.getText());
                    sb.append("',is_back='");
                    sb.append(this.T.isChecked() ? 1 : 0);
                    sb.append("',remarks='");
                    sb.append((Object) this.A0.getText());
                    sb.append("',curr_id=(select id from currency where name='");
                    sb.append(this.q0.getText().toString());
                    sb.append("') ,time_=strftime('%H:%M:%S','now','localtime') ,paid_amount=");
                    if (this.S.isChecked() || zD0) {
                        str = "'";
                        string = "0";
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        str = "'";
                        sb2.append(str);
                        sb2.append(this.U0.getText().toString().replaceAll(",", ""));
                        sb2.append(str);
                        string = sb2.toString();
                    }
                    sb.append(string);
                    sb.append(" where id='");
                    sb.append(this.p);
                    sb.append("' and date_='");
                    sb.append(this.q);
                    sb.append(str);
                    string2 = sb.toString();
                    str2 = "delete from bill_transactions  where bill_id='" + this.p + str;
                    str3 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id, ifnull(" + this.b0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Z.getText().toString().replaceAll(",", "") + "+" + this.b0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0) ,b.remark,b.unit_id,b.u_val,base_unit,qty_pr,e_date  from items_temp b ";
                    String strM = this.i.M(string2, str2, str3);
                    if (strM != null) {
                        if (!strM.equals("1")) {
                        }
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Error:");
                    if (strM != null && strM.length() > 20) {
                        strM = strM.substring(0, 20);
                    }
                    sb3.append(strM);
                    Toast.makeText(this, sb3.toString(), 0).show();
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("update bills set date_='");
                sb4.append((Object) this.U.getText());
                sb4.append("',amount='");
                sb4.append(this.h0.getText().toString().replaceAll(",", ""));
                sb4.append("',d_amount='");
                sb4.append(this.b0.getText().toString().replaceAll(",", ""));
                sb4.append("',t_val='");
                sb4.append(this.e0.getText().toString().replaceAll(",", ""));
                sb4.append("',tax_amount='");
                sb4.append(this.f0.getText().toString().replaceAll(",", ""));
                sb4.append("',cost2='");
                sb4.append(this.d0.getText().toString().replaceAll(",", ""));
                sb4.append("',cus_id=(select id from customers where name='");
                sb4.append((Object) this.Y.getText());
                sb4.append("' ),br_id=(select id from branches where name='");
                sb4.append((Object) this.W.getText());
                sb4.append("' ),cash_id=(select id from customers where name='");
                sb4.append((Object) this.r0.getText());
                sb4.append("' ),bill_type=");
                sb4.append(i);
                sb4.append(",bill_no2='");
                sb4.append((Object) this.z0.getText());
                sb4.append("',is_back='");
                sb4.append(this.T.isChecked() ? 1 : 0);
                sb4.append("',remarks='");
                sb4.append((Object) this.A0.getText());
                sb4.append("',param1='");
                sb4.append(this.S0.getTag() != null ? this.S0.getTag().toString() : "");
                sb4.append("',curr_id=(select id from currency where name='");
                sb4.append(this.q0.getText().toString());
                sb4.append("') ,time_=strftime('%H:%M:%S','now','localtime') ,paid_amount=");
                if (this.S.isChecked() || zD0) {
                    str4 = "'";
                    string3 = "0";
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    str4 = "'";
                    sb5.append(str4);
                    sb5.append(this.U0.getText().toString().replaceAll(",", ""));
                    sb5.append(str4);
                    string3 = sb5.toString();
                }
                sb4.append(string3);
                sb4.append(" where id='");
                sb4.append(this.p);
                sb4.append("' and date_='");
                sb4.append(this.q);
                sb4.append(str4);
                string2 = sb4.toString();
                str2 = "delete from bill_transactions  where bill_id='" + this.p + str4;
                str3 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.b0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Z.getText().toString().replaceAll(",", "") + "+" + this.b0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark ,b.unit_id,b.u_val,base_unit,qty_pr,e_date  from items_temp b ";
                String strM2 = this.i.M(string2, str2, str3);
                if (strM2 == null || !strM2.equals("1")) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Error:");
                    if (strM2 != null && strM2.length() > 20) {
                        strM2 = strM2.substring(0, 20);
                    }
                    sb6.append(strM2);
                    Toast.makeText(this, sb6.toString(), 0).show();
                    return;
                }
                Log.d("sql1=h_", string2);
                Log.d("sql2=h_", str2);
                Log.d("sql3=h_", str3);
                this.q = this.U.getText().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        if (getWindow() != null) {
            return getWindow().getCurrentFocus();
        }
        return null;
    }

    public void h1() {
        try {
            if (getIntent().getStringExtra("TR_ID") != null) {
                this.p = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
                if (getIntent().getStringExtra("TR_DATE") != null) {
                    this.q = getIntent().getStringExtra("TR_DATE");
                }
                this.i.z0("delete from items_temp");
                this.i.z0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,ifnull(e_date,'')   from bill_transactions_v  where bill_id=" + this.p + " and bill_date='" + this.q + "'");
                this.w = Integer.parseInt(getIntent().getStringExtra("tran_status"));
                this.K = getIntent().getIntExtra("back_edit", 0);
                this.M = true;
            } else {
                this.M = false;
            }
            getIntent().getIntExtra("back_recyclerview", 0);
            this.L = 0;
            this.K = getIntent().getIntExtra("back_edit", 0);
        } catch (Exception unused) {
        }
    }

    public void h2(String str, String str2, String str3, String str4) {
        try {
            FragmentStatePagerSupport_Main.a0 = true;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_customer2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_call);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_group);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new U(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new V(autoCompleteTextView));
            this.E2 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new W());
            imageView2.setOnClickListener(new X(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new Z());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2569a0());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2572b0(editText2, autoCompleteTextView, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void i1() {
        Log.d("back_edit=", this.K + ":new_bill=" + this.I2 + ":isNew_bill=" + this.L2 + ":back_recyclerview=" + this.L + ":bill_submit_action=" + this.r2);
        if (this.K == 1 && this.r2) {
            P2 = true;
            Q2 = true;
            R2 = this.Y.getText().toString();
            Z00.o0 = false;
            finish();
            return;
        }
        if (this.I2 && this.L2 != 2) {
            this.I2 = false;
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,ifnull(e_date,'')  from bill_transactions  where bill_id=" + this.p + "");
            return;
        }
        int i = this.t;
        if (i == 1) {
            P2 = false;
            Intent intent = new Intent(this, (Class<?>) Bills2.class);
            intent.addFlags(67141632);
            intent.addFlags(1073741824);
            intent.putExtra("TR_TYPE", "1");
            intent.putExtra("g_id", this.l);
            intent.putExtra("g_name", this.n);
            if (this.i.S()) {
                intent.putExtra("sync", "1");
            }
            startActivity(intent);
            finish();
            return;
        }
        if (i == 2) {
            P2 = false;
            Intent intent2 = new Intent(this, (Class<?>) Bills2.class);
            intent2.addFlags(67141632);
            intent2.addFlags(1073741824);
            intent2.putExtra("TR_TYPE", "2");
            intent2.putExtra("g_id", this.l);
            intent2.putExtra("g_name", this.n);
            if (this.i.S()) {
                intent2.putExtra("sync", "1");
            }
            startActivity(intent2);
            finish();
        }
    }

    public void i2(String str, String str2, String str3, String str4, Handler handler, int i) {
        try {
            FragmentStatePagerSupport_Main.a0 = true;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_customer2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_call);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_group);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4.equals("") ? this.i.T5("0") : str4);
            editText.setEnabled(false);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2622s(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC2625t(autoCompleteTextView));
            this.E2 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new ViewOnClickListenerC2628u());
            imageView2.setOnClickListener(new ViewOnClickListenerC2633w(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2635x());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2637y());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2639z(autoCompleteTextView, alertDialogCreate, str, editText, editText2, i, handler));
        } catch (Exception unused) {
        }
    }

    public void j1() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            new Handler().postDelayed(new RunnableC2600k1(currentFocus), 100L);
        }
    }

    public void j2(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_customer4, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_phone);
            EditText editText3 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_addess);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_call);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class);
            ImageView imageView3 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_cus_type);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_group);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.account_type);
            this.i.cd(this, autoCompleteTextView2);
            this.i.cd(this, autoCompleteTextView);
            this.i.dd(this, editText2);
            this.i.ad(this, editText);
            this.i.ad(this, editText3);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4);
            autoCompleteTextView2.setText(str6);
            editText3.setText(str5);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2568a(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C2571b(autoCompleteTextView2, editText));
            this.E2 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC2574c());
            imageView2.setOnClickListener(new ViewOnClickListenerC2577d(arrayAdapter, autoCompleteTextView));
            imageView3.setOnClickListener(new ViewOnClickListenerC2580e(arrayAdapter2, autoCompleteTextView2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2583f());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2586g());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2589h(editText, autoCompleteTextView, autoCompleteTextView2, str, editText2, editText3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void k2() {
        TextView textView;
        if (this.t != 2 || (textView = this.C1) == null || textView.getText().toString().length() == 0 || this.T.isChecked()) {
            return;
        }
        this.i.v0("update items set e_date2='" + this.C1.getText().toString() + "' where name='" + this.D1.getText().toString() + "'");
    }

    public void l2() {
        this.t2 = false;
        this.N2 = 0;
        P2 = true;
        Q2 = true;
        R2 = this.Y.getText().toString();
        Z00.o0 = false;
    }

    public void m2(String str, String str2, String str3, Handler handler) {
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
            autoCompleteTextView.setOnItemClickListener(new C2592i(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC2595j(autoCompleteTextView));
            imageView.setOnClickListener(new ViewOnClickListenerC2601l(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2604m());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2607n());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2610o(autoCompleteTextView, alertDialogCreate, str, editText, handler));
        } catch (Exception unused) {
        }
    }

    public void more_item(View view) {
        this.i.te(this, this.D1.getText().toString(), this.Y.getText().toString(), this.q0.getText().toString(), A0(this.D1.getText().toString(), this.n).doubleValue(), this.T.isChecked(), this.f1, this.t, this.L1.getText().toString());
    }

    public void n0(Handler handler, String str, int i) {
        i2("", str.trim(), "", "", handler, i);
    }

    public void n2(int i) {
        double dB0;
        try {
            if (this.b1) {
                return;
            }
            if (this.B1.getText().toString().trim().length() > 0) {
                dB0 = this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(this.B1.getText().toString().replaceAll(",", ""), this.y1.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.y1.getTag().toString().replaceAll(",", "")) : 1.0d) : Double.parseDouble(this.B1.getText().toString().replaceAll(",", ""));
            } else {
                dB0 = 0.0d;
            }
            this.b1 = true;
            if (i == 1) {
                if (this.B1.getText().toString().trim().length() == 0) {
                    this.z1.setText("");
                } else if (this.y1.getText().toString().trim().length() > 0 && this.B1.getText().toString().trim().length() > 0) {
                    this.z1.setText(this.i.S7("" + (Double.parseDouble(this.y1.getText().toString().replaceAll(",", "")) * dB0)));
                    this.z1.selectAll();
                    this.i.gc(this.B1);
                }
            } else if (i == 2) {
                if (this.y1.getText().toString().trim().length() == 0) {
                    this.z1.setText("");
                } else if (this.y1.getText().toString().trim().length() > 0 && this.B1.getText().toString().trim().length() > 0) {
                    this.z1.setText(this.i.S7("" + (Double.parseDouble(this.y1.getText().toString().replaceAll(",", "")) * dB0)));
                    this.z1.selectAll();
                    this.i.gc(this.y1);
                }
            } else if (i == 3) {
                if (this.z1.getText().toString().trim().length() == 0) {
                    this.y1.setText("");
                } else if (this.z1.getText().toString().trim().length() > 0 && this.B1.getText().toString().trim().length() > 0) {
                    this.y1.setText(this.i.S7("" + (Double.parseDouble(this.z1.getText().toString().replaceAll(",", "")) / dB0)));
                    this.i.gc(this.z1);
                }
            }
            this.b1 = false;
        } catch (Exception e) {
            this.b1 = false;
            e.printStackTrace();
        }
    }

    public void o0(Handler handler) {
        m2("", this.D1.getText().toString(), "", handler);
    }

    public void o2(int i) {
        try {
            if (this.b1) {
                return;
            }
            this.b1 = true;
            if (i == 1) {
                if (this.G1.getText().toString().trim().length() == 0) {
                    this.F1.setText("");
                } else if (this.E1.getText().toString().trim().length() > 0 && this.G1.getText().toString().trim().length() > 0) {
                    this.F1.setText(this.i.S7("" + (Double.parseDouble(this.E1.getText().toString().replaceAll(",", "")) * Double.parseDouble(this.G1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.G1);
                }
            } else if (i == 2) {
                if (this.E1.getText().toString().trim().length() == 0) {
                    this.F1.setText("");
                } else if (this.E1.getText().toString().trim().length() > 0 && this.G1.getText().toString().trim().length() > 0) {
                    this.F1.setText(this.i.S7("" + (Double.parseDouble(this.E1.getText().toString().replaceAll(",", "")) * Double.parseDouble(this.G1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.E1);
                }
            } else if (i == 3) {
                if (this.F1.getText().toString().trim().length() == 0) {
                    this.E1.setText("");
                } else if (this.F1.getText().toString().trim().length() > 0 && this.G1.getText().toString().trim().length() > 0) {
                    this.E1.setText(this.i.S7("" + (Double.parseDouble(this.F1.getText().toString().replaceAll(",", "")) / Double.parseDouble(this.G1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.F1);
                }
            }
            this.b1 = false;
        } catch (Exception e) {
            this.b1 = false;
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        EditText editText;
        try {
            if (i2 != 0) {
                if (i == 2) {
                    if (intent != null && (editText = this.z1) != null) {
                        editText.setText(this.i.S7(intent.getStringExtra("calc_result")));
                        this.A1.requestFocus();
                    }
                } else if (i == 1) {
                    if (i2 == -1) {
                        Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                        this.E2.setText(string);
                        cursorQuery.close();
                        Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                    }
                } else if (i == this.w2 && intent != null) {
                    D1(intent.getData(), false);
                } else if (i == this.v2) {
                    B1(intent);
                }
            }
            try {
                IntentResult activityResult = IntentIntegrator.parseActivityResult(i, i2, intent);
                if (activityResult != null) {
                    if (activityResult.getContents() == null) {
                        Toast.makeText(this, "Cancelled", 0).show();
                    } else {
                        String strI6 = this.i.I6(activityResult.getContents());
                        Z00.P0 = false;
                        if (strI6.equals("")) {
                            this.i.j1(activityResult.getContents(), this, this.C0);
                        }
                        if (strI6.equals("") && !Z00.P0) {
                            return;
                        }
                        if (Z00.P0) {
                            strI6 = this.i.I6(activityResult.getContents());
                        }
                        int i3 = this.J1;
                        if (i3 == 1) {
                            t1(strI6);
                        } else if (i3 == 2) {
                            u1(strI6);
                        }
                        this.J1 = 0;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("barcode_log_error=", "results=" + e.getMessage());
            }
            C0974Ur c0974Ur = this.i.x;
            if (c0974Ur != null && !c0974Ur.l(i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            super.onActivityResult(i, i2, intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (!q0()) {
                this.N2 = 0;
            }
            if (!q1() || p1()) {
                if (C2160f10.h > 0) {
                    if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                        this.N2 = 0;
                    }
                }
            } else if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                    this.N2 = 0;
                }
            }
            Log.d("onback=", this.p + ":" + this.N2 + ":" + this.K);
            int i = this.N2;
            if (i == 1) {
                this.M2 = 1;
                K0();
                return;
            }
            if (i == 2) {
                P1();
                return;
            }
            if (this.p == 0) {
                finish();
                return;
            }
            P1();
            if (getIntent().getStringExtra("TR_ID") == null && this.j.i == 0 && this.p != 0) {
                e1(this.Y.getText().toString());
                if (C1839c10.k(this.i, this.k)) {
                    try {
                        u0();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            s2(true, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:41:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:43:0x042a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0435  */
    /* JADX WARN: Code duplicated, block: B:48:0x043e  */
    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_bill_edit);
        this.i = new Z00(this.h, this);
        this.j = new E00(this);
        if (getIntent().getStringExtra("bill_offer_id") == null) {
            this.i.z0("delete from items_temp");
        }
        h1();
        if (this.p != 0) {
            setContentView(info.aalmoghalis.inventory.R.layout.content_bill_det);
            TextView textView = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name_hdr);
            this.c0 = textView;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.L2 = 0;
            this.c0.setOnClickListener(new ViewOnClickListenerC2611o0());
        } else {
            this.L2 = 1;
        }
        this.T = (CheckBox) findViewById(info.aalmoghalis.inventory.R.id.chk_back);
        this.P0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_header);
        this.Q0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_footer);
        this.R0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_item_header);
        this.Q = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        this.S = (SwitchCompat) findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
        this.T.setOnCheckedChangeListener(new U1());
        ImageView imageView = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img_u_currency);
        this.V = imageView;
        imageView.setVisibility(8);
        this.V.setOnClickListener(this.X0);
        this.W = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_branch);
        TextView textView2 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_z_status);
        this.W0 = textView2;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        this.U = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_date);
        this.Y = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name);
        this.y0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
        this.Z = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot);
        this.a0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.count);
        this.b0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot_disc);
        this.d0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot_cost);
        this.l0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr);
        this.n0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_add);
        this.o0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode);
        if (this.i.ja("prefOthers_barcode", false)) {
            this.o0.setVisibility(0);
        }
        this.z0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_no);
        this.A0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
        this.v0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.root_layout);
        this.w0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.item_add_hdr);
        this.x0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_items_list_hdr);
        this.u0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.page_add);
        this.S0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        if (this.p != 0) {
            this.x0.setVisibility(0);
        }
        this.e0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tax_val);
        this.f0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tax_amount);
        this.g0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr_tax2);
        this.h0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_tot);
        this.i0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_bill_hdr);
        this.j0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
        this.k0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.LL_tax);
        this.e0.setText((CharSequence) this.j0.getItem(0));
        if (this.e0.getText().toString().equals("0") || this.p == 0) {
            this.f0.setVisibility(4);
            this.g0.setVisibility(4);
            this.i0.setVisibility(4);
            this.h0.setVisibility(4);
        }
        this.T0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.paid_amount_input_layout);
        this.U0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.paid_amount);
        this.V0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.remain_amount);
        this.q0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_curr);
        this.r0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_cash);
        this.x1 = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        this.H0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.s3());
        this.q0.setText(this.i.l3("0"));
        TextView textView3 = this.q0;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        this.q0.setOnClickListener(new ViewOnClickListenerC2629u0());
        this.I0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.A2());
        TextView textView4 = this.W;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        this.W.setOnClickListener(new F0());
        this.J0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.D3());
        TextView textView5 = this.r0;
        textView5.setPaintFlags(8 | textView5.getPaintFlags());
        this.r0.setText(this.i.B3().j());
        if (C2160f10.h != -1) {
            this.r0.setText(this.i.A4(C2160f10.j + ""));
        }
        this.r0.setOnClickListener(new Q0());
        this.Q.setOnItemClickListener(new C2573b1());
        this.Q.setChoiceMode(3);
        this.Q.setMultiChoiceModeListener(new C2576c1());
        this.S.setOnCheckedChangeListener(new x1());
        Calendar calendar = Calendar.getInstance();
        this.U.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.N = calendar.get(1);
        this.O = calendar.get(2);
        this.P = calendar.get(5);
        this.U.setOnClickListener(new I1());
        this.Y.setOnItemClickListener(new T1());
        this.Y.setOnTouchListener(new ViewOnTouchListenerC2598k());
        this.Y.addTextChangedListener(new C2631v());
        b2(true);
        M1();
        K1();
        p2();
        this.Y.requestFocus();
        if (this.p == 0 && getIntent().getStringExtra("bill_offer_id") == null) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                    this.Y.setEnabled(false);
                    this.W.setEnabled(false);
                    this.U.setEnabled(false);
                    this.r0.setEnabled(false);
                    this.q0.setEnabled(false);
                    this.T.setEnabled(false);
                    this.S.setEnabled(false);
                    if (!this.T.isChecked()) {
                        if (new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                            this.T.setEnabled(true);
                        }
                    }
                    this.A0.setEnabled(false);
                    this.z0.setEnabled(false);
                } else if (!A1()) {
                    this.Y.setEnabled(false);
                    this.W.setEnabled(false);
                    this.U.setEnabled(false);
                    this.r0.setEnabled(false);
                    this.q0.setEnabled(false);
                    this.T.setEnabled(false);
                    this.S.setEnabled(false);
                    if (!this.T.isChecked()) {
                        if (new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                            this.T.setEnabled(true);
                        }
                    }
                    this.A0.setEnabled(false);
                    this.z0.setEnabled(false);
                }
            } else if (!A1()) {
                this.Y.setEnabled(false);
                this.W.setEnabled(false);
                this.U.setEnabled(false);
                this.r0.setEnabled(false);
                this.q0.setEnabled(false);
                this.T.setEnabled(false);
                this.S.setEnabled(false);
                if (!this.T.isChecked()) {
                    if (new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                        this.T.setEnabled(true);
                    }
                }
                this.A0.setEnabled(false);
                this.z0.setEnabled(false);
            }
        }
        if (C2160f10.h > 0) {
            this.W.setEnabled(false);
            this.r0.setEnabled(false);
        }
        h1();
        Z0();
        q2(this.p, "0");
        r2();
        M0();
        this.A0.addTextChangedListener(this.a1);
        this.A0.setOnClickListener(new G());
        this.z0.addTextChangedListener(this.a1);
        this.z0.setOnClickListener(new N());
        r1();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(l1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.n2, this.N, this.O, this.P);
        }
        if (i == 4) {
            return new DatePickerDialog(l1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.o2, this.N, this.O, this.P);
        }
        if (i != 5) {
            return null;
        }
        return new DatePickerDialog(l1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.p2, this.N, this.O, this.P);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_bill3_print_5, menu);
        boolean z = false;
        menu.findItem(info.aalmoghalis.inventory.R.id.bill_prin).setVisible(this.p != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.share).setVisible(this.p != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.search).setVisible(this.p != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(this.p != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.printing2).setVisible(this.p != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.printing).setVisible(this.p != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.menu_sms).setVisible(this.p != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.menu_whats).setVisible(this.p != 0);
        int i = C2160f10.h;
        if (i > 0 && this.p != 0) {
            this.l2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
            MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
            boolean zL = new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit");
            boolean zL2 = new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", HTML.Tag.DEL);
            W7 w7B = W7.b(this.i.a, this.p);
            boolean zG = info.aalmoghalis.inventory.zatca.d.g(this, this.i, w7B);
            this.l2.setVisible(zL && zG);
            menuItemFindItem.setVisible(zL2 && zG);
            boolean zH = info.aalmoghalis.inventory.zatca.d.h(this, this.i, w7B);
            MenuItem menuItemFindItem2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_zatca);
            if (zL && zH) {
                z = true;
            }
            menuItemFindItem2.setVisible(z);
        } else if (i == 0 && this.p != 0) {
            this.l2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
            MenuItem menuItemFindItem3 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
            W7 w7B2 = W7.b(this.i.a, this.p);
            boolean zG2 = info.aalmoghalis.inventory.zatca.d.g(this, this.i, w7B2);
            this.l2.setVisible(zG2);
            menuItemFindItem3.setVisible(zG2);
            boolean zH2 = info.aalmoghalis.inventory.zatca.d.h(this, this.i, w7B2);
            menu.findItem(info.aalmoghalis.inventory.R.id.bill_zatca).setVisible(zH2);
            C1839c10.z(this.i, "Zatca=", "" + zH2);
        } else if (i > 0 && this.p == 0) {
            this.l2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
            this.l2.setVisible(new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new"));
            menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", HTML.Tag.DEL));
        }
        this.m2 = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        this.m2.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.m2.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.m2.setOnQueryTextListener(new C());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Q0(this.i.L2());
        b2(true);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        adapterView.getItemAtPosition(i).toString();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Log.d("keycode=", i + ":4:66");
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
            w0(1, this.t);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_submit) {
            G1();
            this.s2 = true;
            w0(2, this.t);
            j1();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_zatca) {
            if (this.p == 0) {
                K0();
                return true;
            }
            if (this.N2 == 1) {
                this.M2 = 0;
                this.t2 = true;
                G1();
                this.s2 = true;
                w0(2, this.t);
            } else {
                G1();
                this.s2 = true;
                s2(true, true);
            }
            j1();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_remove) {
            v0();
            this.H2 = 0;
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.share) {
            if (this.i.ja("pref_show_qr_code", false)) {
                this.i.ia("prefTax_no", "").equals("");
            }
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin) {
                this.H2 = 1;
            } else {
                this.H2 = 2;
            }
            if (this.p == 0) {
                K0();
                return true;
            }
            if (this.N2 == 1) {
                this.M2 = 0;
                this.t2 = true;
                w0(2, this.t);
            }
            H1(this.H2);
            O1();
        } else {
            if (menuItem.getItemId() == 16908332) {
                onBackPressed();
                return true;
            }
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.printing || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.printing2) {
                if (this.i.ja("pref_show_qr_code", false)) {
                    this.i.ia("prefTax_no", "").equals("");
                }
                Log.d("thermal=", this.p + ":" + this.N2 + ":" + this.K);
                if (this.N2 == 1) {
                    this.M2 = 0;
                    this.t2 = true;
                    w0(2, this.t);
                }
                this.H2 = 3;
                O1();
                Intent intent = new Intent(this, (Class<?>) (this.i.ja("prefThermalBluetooth", true) ? MainActivity.class : MainActivity2.class));
                intent.putExtra("TR_ID", this.p + "");
                Z00.j0.clear();
                Z00.j0.add(new String[]{this.p + "", this.q});
                startActivity(intent);
                return true;
            }
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.menu_sms || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.menu_whats) {
                if (this.p == 0) {
                    return true;
                }
                if (this.N2 == 1) {
                    this.M2 = 0;
                    this.t2 = true;
                    w0(2, this.t);
                }
                this.O0 = getTitle().toString();
                U1();
                new C3966tX().H(this, this.i, this.j, this.A2, menuItem.getItemId());
                return true;
            }
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
            if (this.p == 0 || this.q0.getText().toString().equals(radioButton.getText().toString())) {
                this.q0.setTag(radioButton.getText().toString());
                Z0();
            } else {
                this.i.v0("delete from items_temp");
                this.q1 = 1;
                this.N2 = 1;
                this.q0.setTag(radioButton.getText().toString());
                Z0();
                M0();
                q2(this.p, "0");
            }
            Log.d("radio_checked:=", radioButton.getText().toString() + ":" + this.y);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.L2 == 2 && this.p != 0) {
            i1();
        }
        if (this.j.i > 0) {
            onBackPressed();
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

    public void p0(String str, String str2, String str3, Handler handler) {
        String strS7 = "";
        try {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("-7", "new")) {
                Context context = this.p1;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_purchase_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.I1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.p_tr_name);
            this.H1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            this.G1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
            this.E1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            this.F1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
            this.X = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_date_p);
            this.c2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price_hdr);
            this.d2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total_hdr);
            this.e2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
            this.f2 = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
            Y1();
            this.I1.setThreshold(1);
            this.I1.setAdapter(this.G0);
            this.I1.requestFocus();
            this.H1.setText(str);
            this.G1.setText(str2);
            this.G1.setTag(str3);
            double dJ6 = this.i.J6(str, this.q0.getText().toString(), 2, this.T.isChecked(), this.f1 + "", this.t, "");
            EditText editText = this.E1;
            if (dJ6 > 0.0d) {
                strS7 = this.i.S7(String.valueOf(dJ6));
            }
            editText.setHint(strS7);
            this.G1.selectAll();
            this.E1.selectAll();
            this.I1.setOnItemClickListener(new J1());
            this.I1.setOnTouchListener(new K1());
            this.I1.addTextChangedListener(new L1());
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.add_transaction), new M1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new N1(builder));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new O1(handler, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_purchase_error=", ":" + e.getMessage());
        }
    }

    public boolean p1() {
        MenuItem menuItem = this.l2;
        return menuItem != null && menuItem.isVisible();
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public boolean q0() {
        return info.aalmoghalis.inventory.zatca.d.g(this, this.i, W7.b(this.i.a, this.p));
    }

    public boolean q1() {
        return (getIntent().getStringExtra("TR_ID") == null && this.H2 == 0) ? false : true;
    }

    public void q2(final long j, final String str) {
        Log.d("update_qty=_current=", j + ":" + this.t + ":" + this.T.isChecked() + ":" + this.M + ":" + this.t0.size() + ":" + str);
        this.n = this.W.getText().toString() == null ? this.i.C2(this.l) : this.W.getText().toString();
        this.l = this.W.getText().toString() == null ? this.l : this.i.D2(this.W.getText().toString());
        AbstractC3132jE.d(new Callable() { // from class: G7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.w1(j, str);
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: H7
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                Bill_edit.x1((Integer) obj);
            }
        });
    }

    public void r0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void r1() {
        try {
            if (getIntent().getStringExtra("item_name") != null) {
                String stringExtra = getIntent().getStringExtra("item_name");
                String stringExtra2 = getIntent().getStringExtra("item_qty");
                R2 = stringExtra;
                int i = 0;
                while (true) {
                    if (i >= this.Q.getAdapter().getCount()) {
                        i = -1;
                        break;
                    }
                    C0634Jt c0634Jt = (C0634Jt) this.Q.getAdapter().getItem(i);
                    double dB0 = (this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(c0634Jt.h().replaceAll(",", ""), Double.parseDouble(c0634Jt.m())) : Double.parseDouble(c0634Jt.h().replaceAll(",", ""))) * Double.parseDouble(c0634Jt.m());
                    if (c0634Jt.e().equals(stringExtra) && dB0 == Double.parseDouble(stringExtra2.replaceAll(",", ""))) {
                        Log.d("clicked_item=", c0634Jt.e() + ":" + stringExtra);
                        break;
                    }
                    i++;
                }
                if (i >= 0) {
                    ListView listView = this.Q;
                    listView.performItemClick(listView.getAdapter().getView(i, null, null), i, this.Q.getAdapter().getItemId(i));
                    this.B1.requestFocus();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void s0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void s1(String str) {
        if (str != null) {
            try {
                R2 = str;
                int i = 0;
                while (true) {
                    if (i >= this.Q.getAdapter().getCount()) {
                        i = -1;
                        break;
                    }
                    C0634Jt c0634Jt = (C0634Jt) this.Q.getAdapter().getItem(i);
                    if (this.i.ja("prefOthers_qty_pr", false)) {
                        this.i.b0(c0634Jt.h().replaceAll(",", ""), Double.parseDouble(c0634Jt.m()));
                    } else {
                        Double.parseDouble(c0634Jt.h().replaceAll(",", ""));
                    }
                    Double.parseDouble(c0634Jt.m());
                    if (c0634Jt.e().equals(str)) {
                        Log.d("clicked_item=", c0634Jt.e() + ":" + str);
                        break;
                    }
                    i++;
                }
                if (i >= 0) {
                    ListView listView = this.Q;
                    listView.performItemClick(listView.getAdapter().getView(i, null, null), i, this.Q.getAdapter().getItemId(i));
                    this.B1.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void s2(boolean z, boolean z2) {
        int iB = MO.b(this);
        C2160f10.h = iB;
        if (this.p == 0 || this.t != 1) {
            return;
        }
        try {
            if (iB == -1) {
                this.s2 = false;
                return;
            }
            info.aalmoghalis.inventory.zatca.c cVar = new info.aalmoghalis.inventory.zatca.c(this);
            info.aalmoghalis.inventory.zatca.d dVar = new info.aalmoghalis.inventory.zatca.d(this.p1);
            W7 w7B = W7.b(this.i.a, this.p);
            String strR = dVar.r();
            int iH = cVar.h(w7B.i, strR + "");
            if (iH == -1) {
                this.s2 = false;
                return;
            }
            if (iH != -1) {
                w7B.Q = Integer.valueOf(iH);
                info.aalmoghalis.inventory.zatca.e.g gVarE = cVar.e(w7B.i + "", strR + "");
                if (this.i1 == null && z && (gVarE.k || z2)) {
                    w7B.P = 0;
                }
                w7B.l(this.i.a);
                Integer num = w7B.P;
                if ((num == null || num.intValue() <= 0) && w7B.Q != null && iH != -1) {
                    if (!z) {
                        this.s2 = false;
                        return;
                    }
                    if (!gVarE.k && !z2) {
                        this.s2 = false;
                        return;
                    }
                    info.aalmoghalis.inventory.zatca.a aVar = new info.aalmoghalis.inventory.zatca.a(this.i);
                    info.aalmoghalis.inventory.zatca.d.g gVarD = aVar.d(this.p, this.t);
                    if (gVarD == null) {
                        this.s2 = false;
                        return;
                    }
                    List listC = aVar.c(this.p, this.t);
                    if (this.D0.size() != listC.size()) {
                        Toast.makeText(this.p1, getString(info.aalmoghalis.inventory.R.string.no_tax_alarm), 0).show();
                        this.s2 = false;
                        return;
                    }
                    info.aalmoghalis.inventory.zatca.d.n nVarI = dVar.i(gVarD, listC);
                    if (nVarI == null) {
                        this.s2 = false;
                        return;
                    }
                    info.aalmoghalis.inventory.zatca.d.i iVar = new info.aalmoghalis.inventory.zatca.d.i();
                    iVar.a = nVarI;
                    iVar.b = gVarE.n;
                    iVar.c = gVarE.o;
                    iVar.d = gVarE.g;
                    nVarI.K = Double.valueOf(cVar.g(nVarI.g, nVarI.f));
                    Z00.T = this.i.ia("PREF_ACCOUNT_NAME", "");
                    dVar.d0(iVar, new C2584f0(dVar, w7B, gVarD));
                    return;
                }
                this.s2 = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.s2 = false;
        }
    }

    public void t0(View view, boolean z) {
        if (z) {
            T1();
        } else {
            O0();
        }
    }

    public void t1(String str) {
        this.x1.setText(str);
        this.B = this.x1.getText().toString();
        this.J = "0";
        this.D = "";
        this.H = "";
        this.C = "";
        this.I = "";
        this.E = "";
        this.F = "";
        this.G = "1";
        String strX6 = this.i.X6(this.x1.getText().toString());
        double dJ6 = this.i.J6(str, this.q0.getText().toString(), this.t, this.T.isChecked(), this.f1 + "", this.t, strX6);
        this.D = dJ6 > 0.0d ? this.i.S7(String.valueOf(dJ6)) : "";
        this.E = this.i.X6(this.x1.getText().toString());
        this.G = String.valueOf(this.i.Z6(this.x1.getText().toString(), this.E));
        O2 = 1;
        u2();
    }

    public void t2() {
        int size = this.F0.size() - 1;
        if (this.F0.valueAt(size)) {
            this.i.se(this, this.B0.getItem(this.F0.keyAt(size)), this.U.getText().toString(), this.n, this.l, this.q0.getText().toString(), this);
        }
    }

    public void u0() {
        U1();
        new C3966tX().H(this, this.i, this.j, this.A2, 0);
    }

    public void u1(String str) {
        AlertDialog alertDialog;
        this.D1.setText(str);
        this.B1.requestFocus();
        double dJ6 = this.i.J6(str, this.q0.getText().toString(), this.t, this.T.isChecked(), this.f1 + "", this.t, this.i.X6(this.D1.getText().toString()));
        this.y1.setHint(dJ6 <= 0.0d ? "" : this.i.S7(String.valueOf(dJ6)));
        if (this.i.ja("prefOthers_item_price", false)) {
            this.y1.setText(dJ6 <= 0.0d ? "" : this.i.S7(String.valueOf(dJ6)));
        }
        double dF1 = f1(this.p, this.J);
        if (this.i.ja("prefOthers_qty_pr", false)) {
            dF1 = this.i.c0(dF1 + "", 1.0d);
        }
        this.B1.setHint(String.valueOf(dF1));
        this.L1.setText(this.i.X6(this.D1.getText().toString()));
        if (this.i.W6(this.D1.getText().toString()) > 1) {
            this.L1.setVisibility(0);
        } else {
            this.L1.setVisibility(8);
        }
        if ((this.t == 1 || this.T.isChecked()) && this.i.ja("prefOthers_item_end_date", false)) {
            this.C1.setVisibility(0);
            ArrayList arrayListB0 = B0(this.D1.getText().toString(), this.n);
            if (arrayListB0.size() == 0) {
                this.C1.setVisibility(8);
            } else {
                for (int i = 0; i < arrayListB0.size(); i++) {
                    if (Double.parseDouble((String) ((HashMap) arrayListB0.get(i)).get("item_qty")) > 0.0d) {
                        this.C1.setText((CharSequence) ((HashMap) arrayListB0.get(i)).get("item_date"));
                        this.B1.setHint((CharSequence) ((HashMap) arrayListB0.get(i)).get("item_qty"));
                        break;
                    }
                }
            }
        }
        this.y1.setTag("1");
        if (this.i.ja("prefOthers_item_qty", false) && dF1 >= 1.0d && this.t == 1 && this.B1.getText().toString().length() == 0) {
            this.B1.requestFocus();
            this.B1.setText("1");
        }
        if (O2 == 1 && this.i.ja("prefOthers_item_qty", false) && this.i.ja("prefOthers_item_price", false) && this.t == 1 && this.B1.getText().length() > 0 && this.y1.getText().length() > 0 && this.D1.getText().length() > 0 && (alertDialog = this.Q1) != null) {
            alertDialog.getButton(-3).performClick();
        }
        this.B1.selectAll();
        this.y1.selectAll();
        this.z1.selectAll();
        c1();
    }

    public void u2() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_add_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.D1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            this.B1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
            this.y1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            this.z1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_remarks);
            this.A1 = autoCompleteTextView;
            this.i.cd(this, autoCompleteTextView);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price_hdr);
            this.O1 = textView;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.P1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total_hdr);
            this.K1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name_hdr);
            this.M1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_add_amount);
            TextView textView2 = this.K1;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_unit);
            this.L1 = textView3;
            textView3.setPaintFlags(textView3.getPaintFlags() | 8);
            this.p0 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode2);
            if (this.i.ja("prefOthers_barcode", false)) {
                this.p0.setVisibility(0);
            }
            TextView textView4 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_date);
            this.C1 = textView4;
            textView4.setPaintFlags(textView4.getPaintFlags() | 8);
            if (this.i.ja("prefOthers_item_end_date", false)) {
                this.C1.setVisibility(0);
                if (this.t == 2 && !this.T.isChecked()) {
                    this.C1.setOnClickListener(new I0());
                } else if (this.t == 1 || this.T.isChecked()) {
                    this.C1.setOnClickListener(new J0());
                }
            } else {
                this.C1.setVisibility(8);
            }
            this.L1.setOnClickListener(new K0());
            W1();
            ArrayList arrayListG6 = this.i.G6();
            C2160f10.c0(this, this.D1, arrayListG6, 2);
            C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
            this.C0 = c1098Yv;
            c1098Yv.l.clear();
            this.C0.notifyDataSetChanged();
            this.D1.setThreshold(1);
            this.D1.setAdapter(this.C0);
            this.B1.selectAll();
            this.y1.selectAll();
            this.z1.selectAll();
            this.D1.setOnItemClickListener(new L0());
            this.D1.setOnTouchListener(new M0());
            this.D1.addTextChangedListener(new N0());
            this.D1.setText(this.B);
            this.B1.setText(this.C);
            if (this.i.W6(this.D1.getText().toString()) > 1) {
                this.L1.setVisibility(0);
            } else {
                this.L1.setVisibility(8);
            }
            this.L1.setText(this.E);
            this.C1.setText(this.F);
            this.y1.setTag(this.G);
            if (O2 == 1) {
                this.y1.setHint(this.D);
                this.y1.setText("");
                if (this.i.ja("prefOthers_item_price", false)) {
                    this.y1.setText(this.D);
                }
                double dF1 = f1(this.p, this.J);
                double d = this.y1.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.y1.getTag().toString().replaceAll(",", "")) : 1.0d;
                if (this.i.ja("prefOthers_qty_pr", false)) {
                    dF1 = this.i.b0(dF1 + "", d);
                }
                this.B1.setHint(String.valueOf(dF1));
                if (this.i.ja("prefOthers_item_qty", false) && dF1 >= 1.0d && this.t == 1) {
                    this.B1.requestFocus();
                    this.B1.setText("1");
                }
                if (this.i.ja("prefOthers_item_end_date", false)) {
                    this.C1.setVisibility(0);
                    if (this.t == 1 || this.T.isChecked()) {
                        ArrayList arrayListB0 = B0(this.D1.getText().toString(), this.n);
                        if (arrayListB0.size() == 0) {
                            this.C1.setVisibility(8);
                        } else {
                            for (int i = 0; i < arrayListB0.size(); i++) {
                                if (Double.parseDouble((String) ((HashMap) arrayListB0.get(i)).get("item_qty")) > 0.0d) {
                                    this.C1.setText((CharSequence) ((HashMap) arrayListB0.get(i)).get("item_date"));
                                    this.B1.setHint((CharSequence) ((HashMap) arrayListB0.get(i)).get("item_qty"));
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                this.y1.setText(this.D);
                this.y1.setHint(this.D);
                if (this.y1.getTag().toString().trim().length() > 0) {
                    Double.parseDouble(this.y1.getTag().toString().replaceAll(",", ""));
                }
                double dF2 = f1(this.p, this.J);
                if (this.i.ja("prefOthers_qty_pr", false)) {
                    this.B1.setHint(this.i.c0(String.valueOf(dF2 / Double.valueOf(this.G).doubleValue()), Double.parseDouble(this.G)) + "");
                } else {
                    this.B1.setHint(String.valueOf(C1839c10.C(dF2 / Double.valueOf(this.G).doubleValue(), C1839c10.d)));
                }
            }
            this.z1.setText(this.H);
            this.z1.setHint(this.H);
            this.A1.setText(this.I);
            if (O2 == 2) {
                this.y1.requestFocus();
            } else if (this.B.equals("")) {
                this.D1.requestFocus();
            } else {
                this.B1.requestFocus();
            }
            this.y1.selectAll();
            this.z1.selectAll();
            this.B1.selectAll();
            if (this.D1.getText().toString().length() > 0) {
                c1();
            }
            if (O2 == 2) {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new O0());
            } else {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.add_transaction), new P0());
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.btn_add_close), new R0());
            }
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new S0(builder));
            AlertDialog alertDialogCreate = builder.create();
            this.Q1 = alertDialogCreate;
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new T0(alertDialogCreate));
            alertDialogCreate.getButton(-3).setOnClickListener(new U0(alertDialogCreate));
            if (O2 == 1 && this.i.ja("prefOthers_item_qty", false) && this.i.ja("prefOthers_item_price", false) && this.t == 1 && this.B1.getText().length() > 0 && this.y1.getText().length() > 0 && this.D1.getText().length() > 0) {
                alertDialogCreate.getButton(-3).performClick();
            }
        } catch (Exception e) {
            Log.d("view_item_error=", ":" + e.getMessage());
        }
    }

    public void u_currency_btn(View view) {
        if (!q0()) {
            Context context = this.p1;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.qr), 0).show();
            return;
        }
        if (!q1() || p1()) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                    Context context2 = this.p1;
                    Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                Context context3 = this.p1;
                Toast.makeText(context3, context3.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        this.i.ee(this.p, this, this.Y0, new HandlerC2596j0(), "0");
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        Z0();
    }

    public void update_bill_total(View view) {
        if (!q0()) {
            Context context = this.p1;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.qr), 0).show();
            return;
        }
        if (!q1() || p1()) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                    Context context2 = this.p1;
                    Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                Context context3 = this.p1;
                Toast.makeText(context3, context3.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        try {
            if (this.p == 0) {
                y1();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            editText.setText(this.U1 + "");
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
            RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
            if (this.T1 == 0) {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton1);
            } else {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton2);
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new Y0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new Z0());
            AlertDialog alertDialogCreate = builder.create();
            this.S.isChecked();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.total_disc2));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2570a1(editText, radioButton, alertDialogCreate, view));
            alertDialogCreate.getButton(-2).setOnClickListener(new ViewOnClickListenerC2579d1(alertDialogCreate, view));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public void update_bill_total_all(View view) {
        if (!q0()) {
            Context context = this.p1;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.qr), 0).show();
            return;
        }
        if (!q1() || p1()) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                    Context context2 = this.p1;
                    Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                Context context3 = this.p1;
                Toast.makeText(context3, context3.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        try {
            if (this.p == 0) {
                y1();
            }
            if (this.p == 0) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total_all, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_disc_amt);
            if (this.T1 != 1 || this.S1 <= 0.0d) {
                editText.setText(this.S1 + "");
            } else {
                editText.setText(this.U1 + "");
            }
            editText.addTextChangedListener(new C2018dE(editText));
            editText.selectAll();
            RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
            RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
            if (this.T1 == 0) {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton1);
            } else {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton2);
            }
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_other_cost);
            editText2.setText(this.Z1 + "");
            editText2.selectAll();
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cost_name);
            if (this.a2 == 0) {
                this.a2 = -24;
            }
            this.i.cd(this, autoCompleteTextView);
            autoCompleteTextView.setText(this.i.A4(this.a2 + ""));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.m1());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2582e1(autoCompleteTextView));
            this.j0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_tax_val);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_tax_amount);
            TableRow tableRow = (TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_tax);
            textView.setText(this.e0.getText().toString());
            textView2.setText(this.f0.getText().toString());
            tableRow.setVisibility(this.k0.getVisibility());
            textView2.setVisibility(this.f0.getVisibility());
            tableRow.setOnClickListener(new ViewOnClickListenerC2585f1(textView, radioButton, editText, textView2));
            EditText editText3 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.paid_amount);
            TableRow tableRow2 = (TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_paid_amount);
            editText3.setText(this.V1 + "");
            tableRow2.setVisibility(this.T0.getVisibility());
            if (tableRow2.getVisibility() == 0) {
                editText3.requestFocus();
            } else {
                editText.requestFocus();
            }
            editText3.selectAll();
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2588g1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2591h1());
            AlertDialog alertDialogCreate = builder.create();
            this.S.isChecked();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2594i1(editText2, autoCompleteTextView, radioButton, editText, editText3, textView, alertDialogCreate, view));
            alertDialogCreate.getButton(-2).setOnClickListener(new ViewOnClickListenerC2597j1(alertDialogCreate, view));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage() + "");
        }
    }

    public void update_cost_total(View view) {
        if (!q0()) {
            Context context = this.p1;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.qr), 0).show();
            return;
        }
        if (q1() && C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                Context context2 = this.p1;
                Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        try {
            if (this.p == 0) {
                y1();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total3, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            editText.setText(this.Z1 + "");
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cost_name);
            if (this.a2 == 0) {
                this.a2 = -24;
            }
            this.i.cd(this, autoCompleteTextView);
            autoCompleteTextView.setText(this.i.A4(this.a2 + ""));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.m1());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2615p1(autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2618q1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2621r1());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.total_other_cost));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2624s1(editText, autoCompleteTextView, alertDialogCreate, view));
            alertDialogCreate.getButton(-2).setOnClickListener(new ViewOnClickListenerC2627t1(alertDialogCreate, view));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public void update_paid_total(View view) {
        try {
            if (this.p == 0) {
                y1();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total2_, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            editText.setText(this.V1 + "");
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2603l1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2606m1());
            AlertDialog alertDialogCreate = builder.create();
            this.S.isChecked();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.paid_amount));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2609n1(editText, alertDialogCreate, view));
            alertDialogCreate.getButton(-2).setOnClickListener(new ViewOnClickListenerC2612o1(alertDialogCreate, view));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public void update_tax_total(View view) {
        if (!q0()) {
            Context context = this.p1;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.qr), 0).show();
            return;
        }
        if (!q1() || p1()) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "new")) {
                    Context context2 = this.p1;
                    Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 1 ? "-6" : "-7", "edit")) {
                Context context3 = this.p1;
                Toast.makeText(context3, context3.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        if (view.getId() == info.aalmoghalis.inventory.R.id.bill_tot_hdr_tax || view.getId() == this.e0.getId() || view.getId() == this.f0.getId()) {
            this.j0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
            if (this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            F0(this.j0, this.e0);
        }
    }

    public void v0() {
        if (this.i.ja("prefOthers_closed_year", false)) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2578d0());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2581e0());
        builder.create().show();
    }

    public void view_item_info2(View view) {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void w0(int i, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String string;
        String str6;
        String str7;
        String str8;
        String string2;
        String str9;
        String string3;
        String string4;
        String string5;
        try {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            C2160f10.h = MO.b(this);
            C1839c10.z(this.i, "bill_save=", "tr_id=" + this.p + ":c=" + this.i.g2().getCount() + ":" + this.q + ":" + ((Object) this.U.getText()));
            if (!z0()) {
                return;
            }
            if (this.i.v8(this.Y.getText().toString(), this.t).getCount() == 0 && this.i.v8(this.Y.getText().toString().trim(), this.t).getCount() == 0) {
                AutoCompleteTextView autoCompleteTextView = this.Y;
                autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                U0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.Y.getText().toString(), this, this.Y.getText().toString(), this.t);
                if (!this.b2) {
                    return;
                }
            }
            if (!this.Y.getText().toString().equals(this.Y.getText().toString().trim()) && this.i.v8(this.Y.getText().toString().trim(), this.t).getCount() > 0) {
                AutoCompleteTextView autoCompleteTextView2 = this.Y;
                autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
            }
            if (this.i.v8(this.Y.getText().toString(), this.t).getCount() == 0) {
                this.Y.setError("Not Inserted!");
                return;
            }
            this.i.D = false;
            if (this.q0.getText() != null && !this.q0.getText().toString().equals(this.i.l3("0")) && this.i.Z2(this.q0.getText().toString(), this.U.getText().toString()) == 0) {
                this.i.u(this, this.q0.getText().toString(), this.U.getText().toString(), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                if (!this.i.D) {
                    return;
                }
            }
            if (this.i.g2().getCount() == 0) {
                this.n0.performClick();
                return;
            }
            if (D0()) {
                return;
            }
            if (this.p != 0) {
                str = "'";
                str2 = ":";
                K1();
                int i3 = this.S.isChecked() ? 1 : 2;
                if (this.z0.getText().toString().length() > 0) {
                    if (this.i.j2(this.p, this.t, this.T.isChecked() ? 1 : 0, this.W.getText().toString(), this.z0.getText().toString(), "") > 0) {
                        this.z0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                        return;
                    }
                }
                if (this.t == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("update bills set date_='");
                    sb.append((Object) this.U.getText());
                    sb.append("',amount='");
                    sb.append(this.h0.getText().toString().replaceAll(",", ""));
                    sb.append("',d_amount='");
                    sb.append(this.b0.getText().toString().replaceAll(",", ""));
                    sb.append("',t_val='");
                    sb.append(this.e0.getText().toString().replaceAll(",", ""));
                    sb.append("',tax_amount='");
                    sb.append(this.f0.getText().toString().replaceAll(",", ""));
                    sb.append("',cost2='");
                    sb.append(this.d0.getText().toString().replaceAll(",", ""));
                    sb.append("',cus_id=(select id from customers where name='");
                    sb.append((Object) this.Y.getText());
                    sb.append("' ),br_id=(select id from branches where name='");
                    sb.append((Object) this.W.getText());
                    sb.append("' ),cash_id=(select id from customers where name='");
                    sb.append((Object) this.r0.getText());
                    sb.append("' ),bill_type=");
                    sb.append(i3);
                    sb.append(",bill_no2='");
                    sb.append((Object) this.z0.getText());
                    sb.append("',is_back='");
                    sb.append(this.T.isChecked() ? 1 : 0);
                    sb.append("',remarks='");
                    sb.append(this.A0.getText().toString());
                    sb.append("',param1='");
                    sb.append(this.S0.getTag() != null ? this.S0.getTag().toString() : "");
                    sb.append("',curr_id=(select id from currency where name='");
                    sb.append(this.q0.getText().toString());
                    sb.append("') ,tran_status=");
                    sb.append(i);
                    sb.append(" ,online=");
                    sb.append("0");
                    sb.append(",time_=strftime('%H:%M:%S','now','localtime') ,paid_amount=");
                    if (this.S.isChecked()) {
                        str7 = "0";
                    } else {
                        str7 = str + this.U0.getText().toString().replaceAll(",", "") + str;
                    }
                    sb.append(str7);
                    sb.append(",last_user=");
                    int i4 = C2160f10.h;
                    sb.append(i4 != -1 ? Integer.valueOf(i4) : "null");
                    sb.append(" where id='");
                    sb.append(this.p);
                    str3 = "' and date_='";
                    sb.append(str3);
                    sb.append(this.q);
                    sb.append(str);
                    string = sb.toString();
                    str5 = "delete from bill_transactions  where bill_id='" + this.p + str;
                    str6 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.b0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Z.getText().toString().replaceAll(",", "") + "+" + this.b0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark ,b.unit_id,b.u_val,base_unit,qty_pr,e_date  from items_temp b ";
                    String strM = this.i.M(string, str5, str6);
                    if (strM != null && strM.equals("1")) {
                        if (!this.r2) {
                            this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error:");
                    if (strM != null && strM.length() > 20) {
                        strM = strM.substring(0, 20);
                    }
                    sb2.append(strM);
                    Toast.makeText(this, sb2.toString(), 0).show();
                    Q1();
                    Z0();
                    return;
                }
                str3 = "' and date_='";
                StringBuilder sb3 = new StringBuilder();
                sb3.append("update bills set date_='");
                sb3.append((Object) this.U.getText());
                sb3.append("',amount='");
                sb3.append(this.h0.getText().toString().replaceAll(",", ""));
                sb3.append("',d_amount='");
                sb3.append(this.b0.getText().toString().replaceAll(",", ""));
                sb3.append("',t_val='");
                sb3.append(this.e0.getText().toString().replaceAll(",", ""));
                sb3.append("',tax_amount='");
                sb3.append(this.f0.getText().toString().replaceAll(",", ""));
                sb3.append("',cost2='");
                sb3.append(this.d0.getText().toString().replaceAll(",", ""));
                sb3.append("',cus_id=(select id from customers where name='");
                sb3.append((Object) this.Y.getText());
                sb3.append("' ),br_id=(select id from branches where name='");
                sb3.append((Object) this.W.getText());
                sb3.append("' ),cash_id=(select id from customers where name='");
                sb3.append((Object) this.r0.getText());
                sb3.append("' ),bill_type=");
                sb3.append(i3);
                sb3.append(",bill_no2='");
                sb3.append((Object) this.z0.getText());
                sb3.append("',is_back='");
                sb3.append(this.T.isChecked() ? 1 : 0);
                sb3.append("',remarks='");
                sb3.append(this.A0.getText().toString());
                sb3.append("',curr_id=(select id from currency where name='");
                sb3.append(this.q0.getText().toString());
                sb3.append("') ,tran_status=");
                sb3.append(i);
                sb3.append(",online=");
                sb3.append("0");
                sb3.append(",time_=strftime('%H:%M:%S','now','localtime') ,paid_amount=");
                if (this.S.isChecked()) {
                    str4 = "0";
                } else {
                    str4 = str + this.U0.getText().toString().replaceAll(",", "") + str;
                }
                sb3.append(str4);
                sb3.append(",last_user=");
                int i5 = C2160f10.h;
                sb3.append(i5 != -1 ? Integer.valueOf(i5) : "null");
                sb3.append(" where id='");
                sb3.append(this.p);
                sb3.append(str3);
                sb3.append(this.q);
                sb3.append(str);
                String string6 = sb3.toString();
                str5 = "delete from bill_transactions  where bill_id='" + this.p + str;
                String str10 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id, ifnull(" + this.b0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Z.getText().toString().replaceAll(",", "") + "+" + this.b0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0) ,b.remark,b.unit_id,b.u_val,base_unit,qty_pr,e_date  from items_temp b ";
                C1839c10.z(this.i, "bill_save=", "tr_id=" + this.p + ":c=" + this.i.g2().getCount());
                String strM2 = this.i.M(string6, str5, str10);
                if (strM2 != null && strM2.equals(r14)) {
                    if (!this.r2) {
                        this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                    }
                    string = string6;
                    str6 = str10;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(r3);
                if (strM2 != null && strM2.length() > 20) {
                    strM2 = strM2.substring(0, 20);
                }
                sb4.append(strM2);
                Toast.makeText(this, sb4.toString(), 0).show();
                Q1();
                Z0();
                return;
            }
            long jL2 = this.i.l2();
            long jM2 = this.i.m2(this.t, this.T.isChecked() ? 1 : 0, this.l);
            this.z0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + jM2);
            int i6 = this.S.isChecked() ? 1 : 2;
            C2160f10.F(this.i);
            if (this.z0.getText().toString().length() > 0) {
                if (this.i.j2(jL2, this.t, this.T.isChecked() ? 1 : 0, this.W.getText().toString(), this.z0.getText().toString(), "") > 0) {
                    this.z0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                    return;
                }
            } else {
                Z00 z00 = this.i;
                int i7 = this.t;
                boolean zIsChecked = this.T.isChecked();
                if (z00.j2(jL2, i7, zIsChecked ? 1 : 0, this.W.getText().toString(), jM2 + "", "") > 0) {
                    this.z0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                    return;
                }
            }
            if (this.t == 2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("insert into bills (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,param1,online,t_val,tax_amount,time_,paid_amount,user_id) values(");
                sb5.append(jL2);
                sb5.append(",");
                sb5.append(i2);
                sb5.append(",'");
                sb5.append((Object) this.U.getText());
                sb5.append("','");
                sb5.append(this.h0.getText().toString().replaceAll(",", ""));
                sb5.append("','");
                sb5.append(this.b0.getText().toString().replaceAll(",", ""));
                sb5.append("',(select id from customers where name='");
                sb5.append((Object) this.Y.getText());
                sb5.append("'  ),");
                sb5.append(i);
                sb5.append(",");
                sb5.append(i6);
                sb5.append(",'");
                if (this.z0.getText().toString().length() == 0) {
                    string4 = jM2 + "";
                } else {
                    string4 = this.z0.getText().toString();
                }
                sb5.append(string4);
                sb5.append("','");
                sb5.append((Object) this.A0.getText());
                sb5.append("',(select id from currency where name='");
                sb5.append(this.q0.getText().toString());
                sb5.append("') ,(select id from branches where name='");
                sb5.append(this.W.getText().toString());
                sb5.append("'),(select id from customers where name='");
                sb5.append(this.r0.getText().toString());
                sb5.append("'),");
                sb5.append(this.T.isChecked() ? 1 : 0);
                sb5.append(",");
                sb5.append(!this.T.isChecked() ? "0" : Long.valueOf(this.f1));
                sb5.append(",'");
                sb5.append(this.S0.getTag() != null ? this.S0.getTag().toString() : "");
                sb5.append("',");
                sb5.append("0");
                sb5.append(",'");
                sb5.append(this.e0.getText().toString().replaceAll(",", ""));
                sb5.append("','");
                sb5.append(this.f0.getText().toString().replaceAll(",", ""));
                sb5.append("',strftime('%H:%M:%S','now','localtime'),");
                if (this.S.isChecked()) {
                    string5 = "0";
                    str = "'";
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    str = "'";
                    sb6.append(str);
                    sb6.append(this.U0.getText().toString().replaceAll(",", ""));
                    sb6.append(str);
                    string5 = sb6.toString();
                }
                sb5.append(string5);
                sb5.append(",");
                int i8 = C2160f10.h;
                sb5.append(i8 != -1 ? Integer.valueOf(i8) : "null");
                sb5.append(")");
                string3 = sb5.toString();
                str5 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.b0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Z.getText().toString().replaceAll(",", "") + "+" + this.b0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark,b.unit_id,b.u_val,b.base_unit,qty_pr,e_date  from items_temp b ";
            } else {
                str = "'";
                if (this.p != 0 || getIntent().getStringExtra("bill_offer_id") == null) {
                    str8 = ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(";
                } else {
                    str8 = ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(";
                    if (!this.i.ja("prefOthers_sales_out_qty", false)) {
                        this.i.Vb();
                        String strJ7 = this.i.J7(this.W.getText().toString());
                        if (!strJ7.equals("")) {
                            Toast.makeText(this.p1, getString(info.aalmoghalis.inventory.R.string.alarm_item_negative2) + ":" + strJ7, 1).show();
                            if (strJ7.split(",").length > 0) {
                                s1(strJ7.split(",")[0]);
                                return;
                            }
                            return;
                        }
                    }
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("insert into bills(id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,online,t_val,tax_amount,time_,paid_amount,user_id) values(");
                sb7.append(jL2);
                sb7.append(",");
                sb7.append(i2);
                sb7.append(",'");
                sb7.append((Object) this.U.getText());
                sb7.append("','");
                sb7.append(this.h0.getText().toString().replaceAll(",", ""));
                sb7.append("','");
                sb7.append(this.b0.getText().toString().replaceAll(",", ""));
                sb7.append("',(select id from customers where name='");
                sb7.append((Object) this.Y.getText());
                sb7.append("'  ),");
                sb7.append(i);
                sb7.append(",");
                sb7.append(i6);
                sb7.append(",'");
                if (this.z0.getText().toString().length() == 0) {
                    string2 = jM2 + "";
                } else {
                    string2 = this.z0.getText().toString();
                }
                sb7.append(string2);
                sb7.append("','");
                sb7.append((Object) this.A0.getText());
                sb7.append("',(select id from currency where name='");
                sb7.append(this.q0.getText().toString());
                sb7.append("'),(select id from branches where name='");
                sb7.append(this.W.getText().toString());
                sb7.append("'),(select id from customers where name='");
                sb7.append(this.r0.getText().toString());
                sb7.append("'),");
                sb7.append(this.T.isChecked() ? 1 : 0);
                sb7.append(",");
                sb7.append(!this.T.isChecked() ? "0" : Long.valueOf(this.f1));
                sb7.append(",");
                sb7.append("0");
                sb7.append(",'");
                sb7.append(this.e0.getText().toString().replaceAll(",", ""));
                sb7.append("','");
                sb7.append(this.f0.getText().toString().replaceAll(",", ""));
                sb7.append("',strftime('%H:%M:%S','now','localtime'),");
                if (this.S.isChecked()) {
                    str9 = "0";
                } else {
                    str9 = str + this.U0.getText().toString().replaceAll(",", "") + str;
                }
                sb7.append(str9);
                sb7.append(",");
                int i9 = C2160f10.h;
                sb7.append(i9 != -1 ? Integer.valueOf(i9) : "null");
                sb7.append(")");
                string3 = sb7.toString();
                str5 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + str8 + this.b0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Z.getText().toString().replaceAll(",", "") + "+" + this.b0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark,b.unit_id,b.u_val,base_unit,qty_pr,e_date  from items_temp b ";
            }
            String strL = this.i.L(string3, str5);
            if (strL != null && strL.equals("1")) {
                this.i.v0("delete from items_temp");
                this.p = jL2;
                this.q = this.U.getText().toString();
                string = string3;
                str2 = ":";
                str6 = "";
                str3 = "' and date_='";
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Error:");
            if (strL != null && strL.length() > 20) {
                strL = strL.substring(0, 20);
            }
            sb8.append(strL);
            Toast.makeText(this, sb8.toString(), 0).show();
            return;
            try {
                new C1839c10(this, this.i).A();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("sql1=", string);
            Log.d("sql2=", str5);
            Log.d("sql3=", str6);
            this.q = this.U.getText().toString();
            if (!this.d0.getText().toString().replaceAll(",", "").equals("0")) {
                this.i.v0("update bills set cost2=cost2 where id='" + this.p + str3 + this.q + str);
            }
            M0();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(this.L2);
            String str11 = str2;
            sb9.append(str11);
            sb9.append(this.p);
            sb9.append(str11);
            sb9.append(this.I2);
            Log.d("isnew=", sb9.toString());
            if (this.p != 0 && this.L2 == 2) {
                this.N2 = 0;
                P2 = true;
                e1(this.Y.getText().toString());
                s2(this.r2, this.s2);
                String str12 = this.A2;
                if (str12 != null) {
                    e2(str12);
                    Q1();
                    Z0();
                    return;
                }
                i1();
            } else if (this.t2) {
                l2();
            } else {
                this.i.v0("delete from items_temp");
                i1();
            }
        } catch (Exception e2) {
            Log.d("bill_save_error", e2.getMessage() + "");
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Error2:");
            sb10.append((e2.getMessage() == null || e2.getMessage().length() <= 20) ? e2.getMessage() : e2.getMessage().substring(0, 20));
            Toast.makeText(this, sb10.toString(), 1).show();
            e2.getMessage();
            e2.printStackTrace();
        }
        s2(this.r2, this.s2);
    }

    public void x0(EditText editText) {
        Intent intent = new Intent(this, (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", editText.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void y1() {
        this.I2 = true;
        w0(2, this.t);
        this.N2 = 2;
    }

    public void z1() {
        long j = this.p;
        this.f1 = j;
        this.g1 = j;
        this.T.setEnabled(false);
        this.q0.setEnabled(false);
        r2();
        this.p = 0L;
        this.A0.setText(getString(info.aalmoghalis.inventory.R.string.bill_back_remarks) + this.z0.getText().toString());
        this.z0.setText("");
        K1();
        Calendar calendar = Calendar.getInstance();
        this.U.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.N = calendar.get(1);
        this.O = calendar.get(2);
        this.P = calendar.get(5);
        this.q1 = 1;
        Z0();
        this.i.v0("delete from items_temp");
        y1();
        this.q1 = 1;
        Z0();
        q2(this.p, "0");
        invalidateOptionsMenu();
        if (p1()) {
            this.Y.setEnabled(true);
            this.U.setEnabled(true);
            this.q0.setEnabled(true);
            this.A0.setEnabled(true);
            this.z0.setEnabled(true);
        }
    }
}
