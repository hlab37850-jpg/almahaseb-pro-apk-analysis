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
import defpackage.Z00;
import info.aalmoghalis.inventory.activity.Bill_adj2;
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

/* JADX INFO: loaded from: classes3.dex */
public class Bill_adj2 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int C2 = 0;
    public static boolean D2 = false;
    public static boolean E2 = false;
    public static String F2 = "";
    public C0809Ov A0;
    public C1098Yv B0;
    public SparseBooleanArray E0;
    public ArrayAdapter F0;
    public ArrayAdapter G0;
    public TextView G1;
    public ArrayAdapter H0;
    public TextView H1;
    public ArrayAdapter I0;
    public int M;
    public int N;
    public int O;
    public boolean R1;
    public TextView S1;
    public TextView T1;
    public TextView U1;
    public SwitchCompat V1;
    public boolean X1;
    public boolean Y1;
    public SearchView b2;
    public TextView d0;
    public TextView e0;
    public TextView f0;
    public TextView g0;
    public SQLiteDatabase h;
    public TextView h0;
    public Z00 i;
    public ArrayAdapter i0;
    public String i2;
    public E00 j;
    public String k;
    public String l;
    public String n;
    public Uri n2;
    public EditText s2;
    public List t2;
    public LinearLayout u0;
    public C4062ug u2;
    public LinearLayout v0;
    public LinearLayout w0;
    public long p = 0;
    public String q = "";
    public int t = 0;
    public int u = 2;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    public String y = null;
    public String z = null;
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public String E = null;
    public String F = "1";
    public String G = null;
    public String H = null;
    public String I = "0";
    public int J = 0;
    public int K = 0;
    public boolean L = false;
    public ListView P = null;
    public Toolbar Q = null;
    public SwitchCompat R = null;
    public CheckBox S = null;
    public TextView T = null;
    public ImageView U = null;
    public TextView V = null;
    public TextView W = null;
    public AutoCompleteTextView X = null;
    public TextView Y = null;
    public TextView Z = null;
    public TextView a0 = null;
    public TextView b0 = null;
    public TextView c0 = null;
    public LinearLayout j0 = null;
    public TextView k0 = null;
    public ImageView l0 = null;
    public ImageView m0 = null;
    public ImageView n0 = null;
    public ImageView o0 = null;
    public TextView p0 = null;
    public TextView q0 = null;
    public ArrayList r0 = new ArrayList();
    public ArrayList s0 = new ArrayList();
    public ImageView t0 = null;
    public TextView x0 = null;
    public EditText y0 = null;
    public EditText z0 = null;
    public List C0 = new ArrayList();
    public List D0 = new ArrayList();
    public ImageButton J0 = null;
    public int K0 = 0;
    public String[] L0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] M0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String N0 = "";
    public LinearLayout O0 = null;
    public LinearLayout P0 = null;
    public LinearLayout Q0 = null;
    public ImageView R0 = null;
    public LinearLayout S0 = null;
    public View.OnClickListener T0 = new ViewOnClickListenerC2501b0();
    public ArrayList U0 = new ArrayList();
    public boolean V0 = false;
    public TextWatcher W0 = new C2531l0();
    public boolean X0 = false;
    public TextWatcher Y0 = new C2534m0();
    public TextWatcher Z0 = new C2537n0();
    public int a1 = 0;
    public long b1 = 0;
    public long c1 = 0;
    public String d1 = "";
    public int e1 = 0;
    public String f1 = "";
    public String g1 = "";
    public final Context h1 = this;
    public int i1 = 0;
    public int j1 = 0;
    public String k1 = "";
    public String l1 = "";
    public EditText m1 = null;
    public EditText n1 = null;
    public TextView o1 = null;
    public AutoCompleteTextView p1 = null;
    public EditText q1 = null;
    public EditText r1 = null;
    public AutoCompleteTextView s1 = null;
    public EditText t1 = null;
    public TextView u1 = null;
    public AutoCompleteTextView v1 = null;
    public EditText w1 = null;
    public EditText x1 = null;
    public EditText y1 = null;
    public TextView z1 = null;
    public AutoCompleteTextView A1 = null;
    public int B1 = 0;
    public TextView C1 = null;
    public TextView D1 = null;
    public ImageView E1 = null;
    public boolean F1 = false;
    public double I1 = 0.0d;
    public double J1 = 0.0d;
    public int K1 = 0;
    public double L1 = 0.0d;
    public double M1 = 0.0d;
    public double N1 = 0.0d;
    public double O1 = 0.0d;
    public double P1 = 0.0d;
    public int Q1 = 0;
    public int W1 = 1;
    public String Z1 = "";
    public String a2 = "0";
    public DatePickerDialog.OnDateSetListener c2 = new C2566z();
    public DatePickerDialog.OnDateSetListener d2 = new A();
    public DatePickerDialog.OnDateSetListener e2 = new B();
    public View.OnClickListener f2 = new H();
    public boolean g2 = false;
    public boolean h2 = false;
    public int j2 = 3;
    public int k2 = 4;
    public ActivityResultLauncher l2 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: C7
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.s1((Uri) obj);
        }
    });
    public ActivityResultLauncher m2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new R());
    public String o2 = null;
    public String p2 = null;
    public String q2 = null;
    public String r2 = null;
    public int v2 = 0;
    public boolean w2 = false;
    public int[] x2 = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public int y2 = 0;
    public int z2 = 0;
    public int A2 = 0;
    public int B2 = 0;

    public class A implements DatePickerDialog.OnDateSetListener {
        public A() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_adj2.this.M = i;
            Bill_adj2.this.N = i2;
            Bill_adj2.this.O = i3;
            try {
                String str = Bill_adj2.this.M + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_adj2.this.N + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_adj2.this.O));
                Locale locale = Locale.ENGLISH;
                Bill_adj2.this.W.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class A0 implements CompoundButton.OnCheckedChangeListener {
        public A0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (Bill_adj2.this.V1.isChecked()) {
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.U1.setText(bill_adj2.getString(info.aalmoghalis.inventory.R.string.bill_cash));
            } else {
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                bill_adj3.U1.setText(bill_adj3.getString(info.aalmoghalis.inventory.R.string.bill_post));
            }
            Log.d("item_status_p=", Bill_adj2.this.U1.getText().toString() + "#" + Bill_adj2.this.V1.isChecked());
        }
    }

    public class A1 extends Handler {
        public A1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class B implements DatePickerDialog.OnDateSetListener {
        public B() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            try {
                String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", locale);
                Date date = simpleDateFormat.parse(str);
                TextView textView = Bill_adj2.this.u1;
                if (textView != null) {
                    textView.setText(simpleDateFormat2.format(Long.valueOf(date.getTime())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class B0 implements View.OnClickListener {
        public B0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_adj2.this.w1.getText().toString().length() != 0) {
                Bill_adj2.this.w1.setText("");
            } else {
                EditText editText = Bill_adj2.this.w1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class B1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Handler d;

        public B1(String str, String str2, String str3, Handler handler) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.s0(this.a, this.b, this.c, this.d);
        }
    }

    public class C implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public C(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.B2 = 1;
            bill_adj2.v0(view, this.a);
        }
    }

    public class C0 implements View.OnClickListener {
        public C0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_adj2.this.x1.getText().toString().length() != 0) {
                Bill_adj2.this.x1.setText("");
            } else {
                EditText editText = Bill_adj2.this.x1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class C1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public C1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            Toast.makeText(bill_adj2, bill_adj2.getString(info.aalmoghalis.inventory.R.string.out_stock_balance), 0).show();
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class D implements DialogInterface.OnClickListener {
        public D() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class D0 implements View.OnClickListener {
        public D0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = Bill_adj2.this.V.getText().toString();
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.G0(bill_adj2.H0, Bill_adj2.this.V);
            Log.d("curr=", string + ":" + Bill_adj2.this.V.getText().toString() + ":" + Bill_adj2.this.p);
        }
    }

    public class D1 implements AdapterView.OnItemClickListener {
        public D1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_adj2.this.A1.setText(adapterView.getItemAtPosition(i).toString());
            Bill_adj2.this.w1.requestFocus();
        }
    }

    public class E implements DialogInterface.OnClickListener {
        public E() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class E0 implements View.OnClickListener {
        public E0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.showDialog(4);
        }
    }

    public class E1 implements View.OnTouchListener {
        public E1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_adj2.this.A1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.A1.getCompoundDrawables()[0] != null ? Bill_adj2.this.A1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.A1.getPaddingLeft() + Bill_adj2.this.A1.getLeft()) {
                    Bill_adj2.this.A1.setText("");
                    Bill_adj2.this.A1.requestFocus();
                }
            }
            return false;
        }
    }

    public class F implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlertDialog d;

        public F(EditText editText, String str, String str2, AlertDialog alertDialog) {
            this.a = editText;
            this.b = str;
            this.c = str2;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a) && Bill_adj2.this.i.ja("prefOthers_update_item_price", true)) {
                if (Bill_adj2.this.i.H("delete from item_price where item_id=(select a.id from items a where a.name='" + this.b + "') and curr_id=(select a.id from currency a where a.name='" + Bill_adj2.this.p0.getText().toString() + "') and unit_id=ifnull((select id from units where code='" + this.c + "'),0)", "insert into item_price(item_id,curr_id,unit_id,SLS_U_PRICE) values ((select a.id from items a where a.name='" + this.b + "'),(select a.id from currency a where a.name='" + Bill_adj2.this.p0.getText().toString() + "'),ifnull((select id from units where code='" + this.c + "'),0),'" + this.a.getText().toString().replaceAll(",", "") + "')") == 1) {
                    this.d.dismiss();
                }
            }
        }
    }

    public class F0 implements View.OnTouchListener {
        public F0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.y1.getCompoundDrawables()[0] != null ? Bill_adj2.this.y1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.y1.getPaddingLeft() + Bill_adj2.this.y1.getLeft()) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.i.B(bill_adj2.y1, bill_adj2.F1);
                }
            }
            return false;
        }
    }

    public class F1 implements TextWatcher {
        public F1() {
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
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.A1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_adj2, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_adj2.this.A1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_adj2.this.A1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class G implements View.OnClickListener {
        public G() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.V0 = true;
        }
    }

    public class G0 implements View.OnTouchListener {
        public G0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.w1.getCompoundDrawables()[0] != null ? Bill_adj2.this.w1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.w1.getPaddingLeft() + Bill_adj2.this.w1.getLeft()) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.i.B(bill_adj2.w1, bill_adj2.F1);
                }
            }
            return false;
        }
    }

    public class G1 implements View.OnClickListener {
        public G1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.showDialog(0);
            Bill_adj2.this.B2 = 1;
        }
    }

    public class H implements View.OnClickListener {
        public H() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == Bill_adj2.this.t1.getId() || view.getId() == Bill_adj2.this.q1.getId()) {
                return;
            }
            view.getId();
            Bill_adj2.this.r1.getId();
        }
    }

    public class H0 implements View.OnTouchListener {
        public H0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.x1.getCompoundDrawables()[0] != null ? Bill_adj2.this.x1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.x1.getPaddingLeft() + Bill_adj2.this.x1.getLeft()) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.i.B(bill_adj2.x1, bill_adj2.F1);
                }
            }
            return false;
        }
    }

    public class H1 implements DialogInterface.OnClickListener {
        public H1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class I implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public I(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
        }
    }

    public class I0 implements View.OnClickListener {
        public I0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d("click=", "item_date:" + Bill_adj2.C2);
            try {
                C2056di c2056di = new C2056di();
                Bundle bundle = new Bundle();
                String string = Bill_adj2.this.u1.getText().toString();
                if (string.length() == 0) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    string = bill_adj2.i.D5(bill_adj2.v1.getText().toString());
                }
                ArrayList arrayListT = new C1839c10().t(string);
                if (arrayListT.size() > 2) {
                    bundle.putInt("year", ((Integer) arrayListT.get(0)).intValue());
                    bundle.putInt("month", ((Integer) arrayListT.get(1)).intValue());
                    bundle.putInt("day", ((Integer) arrayListT.get(2)).intValue());
                } else {
                    bundle.putInt("year", Bill_adj2.this.M);
                    bundle.putInt("month", Bill_adj2.this.N);
                    bundle.putInt("day", Bill_adj2.this.O);
                }
                c2056di.setArguments(bundle);
                Bill_adj2.this.u1.setText("");
                c2056di.f(Bill_adj2.this.e2);
                c2056di.show(Bill_adj2.this.getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    public class I1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public I1(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
        }
    }

    public class J implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlertDialog d;

        public J(String str, TextView textView, String str2, AlertDialog alertDialog) {
            this.a = str;
            this.b = textView;
            this.c = str2;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bill_adj2.this.j2(this.a, this.b.getText().toString(), this.c);
                this.d.dismiss();
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class J0 implements View.OnClickListener {
        public J0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int[] iArr = {android.R.id.text1};
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            Bill_adj2.this.H0(new SimpleAdapter(bill_adj2, bill_adj2.D0(bill_adj2.v1.getText().toString(), Bill_adj2.this.n), android.R.layout.simple_list_item_2, new String[]{"item_date_qty"}, iArr));
        }
    }

    public class J1 implements View.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ AlertDialog b;

        public J1(Handler handler, AlertDialog alertDialog) {
            this.a = handler;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (Bill_adj2.this.E1()) {
                    Bill_adj2.this.R1 = true;
                    Handler handler = this.a;
                    handler.sendMessage(handler.obtainMessage());
                    this.b.dismiss();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class K implements DialogInterface.OnClickListener {
        public K() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_adj2.this.w1();
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getApplicationContext(), Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class K0 implements View.OnClickListener {
        public K0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr = {HTML.Attribute.ID, "name"};
            int[] iArr = {android.R.id.text1, android.R.id.text2};
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            Bill_adj2.this.I0(new SimpleAdapter(bill_adj2, bill_adj2.i.b9(bill_adj2.v1.getText().toString()), android.R.layout.simple_list_item_2, strArr, iArr));
        }
    }

    public class K1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public K1(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    public class L implements DialogInterface.OnClickListener {
        public L() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.L = false;
            bill_adj2.S.setChecked(true);
            Bill_adj2.this.o2();
            Bill_adj2 bill_adj3 = Bill_adj2.this;
            bill_adj3.n2(bill_adj3.p, "0");
            Bill_adj2.this.B2 = 1;
            dialogInterface.dismiss();
        }
    }

    public class L0 implements AdapterView.OnItemClickListener {
        public L0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_adj2.this.r1(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    public class L1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ArrayAdapter b;
        public final /* synthetic */ Dialog c;

        public L1(TextView textView, ArrayAdapter arrayAdapter, Dialog dialog) {
            this.a = textView;
            this.b = arrayAdapter;
            this.c = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getId() == Bill_adj2.this.V.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.i1 = 1;
                bill_adj2.B2 = 1;
                bill_adj2.G1();
                Bill_adj2.this.N0();
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                bill_adj3.n2(bill_adj3.p, "0");
            } else if (this.a.getId() == Bill_adj2.this.q0.getId()) {
                if (i == this.b.getCount() - 1) {
                    Bill_adj2 bill_adj4 = Bill_adj2.this;
                    bill_adj4.e2("0", "", "", bill_adj4.i.T5("0"), "", Bill_adj2.this.i.v1("121"));
                } else {
                    this.a.setText(adapterView.getItemAtPosition(i).toString());
                }
            } else if (this.a.getId() == Bill_adj2.this.p0.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Bill_adj2.this.a1();
            } else if (this.a.getId() == Bill_adj2.this.d0.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Bill_adj2.this.Q1();
                String strY0 = Bill_adj2.this.i.y0("update bills set t_val='" + Bill_adj2.this.d0.getText().toString().replaceAll(",", "") + "',tax_amount='" + Bill_adj2.this.e0.getText().toString().replaceAll(",", "") + "',amount='" + Bill_adj2.this.g0.getText().toString().replaceAll(",", "") + "' where id='" + Bill_adj2.this.p + "' and date_='" + Bill_adj2.this.q + "'");
                if (strY0 == null || !strY0.equals("1")) {
                    Bill_adj2 bill_adj5 = Bill_adj2.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error:");
                    if (strY0 != null && strY0.length() > 20) {
                        strY0 = strY0.substring(0, 20);
                    }
                    sb.append(strY0);
                    Toast.makeText(bill_adj5, sb.toString(), 0).show();
                    Bill_adj2.this.L1();
                    Bill_adj2.this.a1();
                }
            }
            this.c.dismiss();
        }
    }

    public class M implements DialogInterface.OnClickListener {
        public M() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_adj2.this.C1();
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.y0(2, bill_adj2.t);
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getApplicationContext(), Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class M0 implements View.OnTouchListener {
        public M0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_adj2.this.v1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.v1.getCompoundDrawables()[0] != null ? Bill_adj2.this.v1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.v1.getPaddingLeft() + Bill_adj2.this.v1.getLeft()) {
                    Bill_adj2.this.v1.setText("");
                    Bill_adj2.this.D1.setVisibility(8);
                    Bill_adj2.this.D1.setText("");
                    Bill_adj2.this.t1.setText("");
                    Bill_adj2.this.q1.setText("");
                    Bill_adj2.this.u1.setText("");
                    Bill_adj2.this.v1.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_adj2.this.v1.getRight();
                Bill_adj2.this.v1.getPaddingRight();
                if (Bill_adj2.this.v1.getCompoundDrawables()[2] != null) {
                    Bill_adj2.this.v1.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class M1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public M1(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String str = (String) ((HashMap) adapterView.getItemAtPosition(i)).get(HTML.Attribute.ID);
            if (!Bill_adj2.this.D1.getText().toString().equals(str)) {
                Bill_adj2.this.D1.setText(str);
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                double dZ6 = bill_adj2.i.Z6(bill_adj2.v1.getText().toString(), Bill_adj2.this.D1.getText().toString());
                Bill_adj2.this.F = String.valueOf(dZ6);
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                bill_adj3.q1.setTag(bill_adj3.F);
                Bill_adj2 bill_adj4 = Bill_adj2.this;
                double dC6 = bill_adj4.i.C6(bill_adj4.v1.getText().toString(), Bill_adj2.this.p0.getText().toString(), Bill_adj2.this.T.getText().toString());
                Bill_adj2 bill_adj5 = Bill_adj2.this;
                bill_adj5.q1.setHint(dC6 <= 0.0d ? "" : bill_adj5.i.S7(String.valueOf(dC6 * dZ6)));
                if (Bill_adj2.this.q1.getText().toString().length() > 0) {
                    EditText editText = Bill_adj2.this.q1;
                    editText.setText(editText.getHint());
                    Bill_adj2.this.q1.selectAll();
                }
                if (Bill_adj2.this.i.ja("prefOthers_item_price", false)) {
                    EditText editText2 = Bill_adj2.this.q1;
                    editText2.setText(editText2.getHint());
                }
                Bill_adj2 bill_adj6 = Bill_adj2.this;
                double dG1 = bill_adj6.g1(bill_adj6.p, Bill_adj2.this.I);
                if (Bill_adj2.this.i.ja("prefOthers_qty_pr", false)) {
                    Bill_adj2 bill_adj7 = Bill_adj2.this;
                    bill_adj7.t1.setHint(String.valueOf(bill_adj7.i.c0("" + (dG1 / dZ6), dZ6)));
                } else {
                    Bill_adj2.this.t1.setHint(String.valueOf(C1839c10.C(dG1 / dZ6, C1839c10.d)));
                }
            }
            this.a.dismiss();
            Bill_adj2 bill_adj8 = Bill_adj2.this;
            bill_adj8.i.Md(bill_adj8);
        }
    }

    public class N implements DialogInterface.OnClickListener {
        public N() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            if (bill_adj2.A2 == 1) {
                bill_adj2.finish();
            } else {
                bill_adj2.B2 = 0;
                bill_adj2.a1();
            }
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
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.v1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_adj2, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_adj2.this.p1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_adj2.this.v1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class N1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public N1(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            HashMap map = (HashMap) adapterView.getItemAtPosition(i);
            String str = (String) map.get("item_date");
            if (Bill_adj2.this.u1 != null) {
                double d = Double.parseDouble((String) map.get("item_qty"));
                if (d >= 0.0d) {
                    Bill_adj2.this.u1.setText(str);
                    Bill_adj2.this.t1.setHint(String.valueOf(d));
                    if (Bill_adj2.this.t1.getText().toString().length() > 0 && Double.parseDouble(Bill_adj2.this.t1.getText().toString().replaceAll(",", "")) > d) {
                        Bill_adj2 bill_adj2 = Bill_adj2.this;
                        bill_adj2.t1.setText(bill_adj2.i.S7(String.valueOf(d)));
                    }
                }
            }
            this.a.dismiss();
            Bill_adj2 bill_adj3 = Bill_adj2.this;
            bill_adj3.i.Md(bill_adj3);
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
                boolean zH = C3966tX.h(Bill_adj2.this);
                if (this.a[i].equals(Bill_adj2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.i2 = bill_adj2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Bill_adj2.this.A0();
                    }
                } else if (this.a[i].equals(Bill_adj2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Bill_adj2 bill_adj3 = Bill_adj2.this;
                    bill_adj3.i2 = bill_adj3.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Bill_adj2.this.S0();
                    }
                } else if (this.a[i].equals(Bill_adj2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Bill_adj2.this.i.qa(Z00.M + Bill_adj2.this.R0.getTag().toString());
                } else if (this.a[i].equals(Bill_adj2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Bill_adj2.this.R0.setTag(null);
                    Bill_adj2.this.R0.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class O0 implements View.OnClickListener {
        public O0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.B2 = 1;
            Bill_adj2 bill_adj3 = Bill_adj2.this;
            bill_adj2.I0 = new ArrayAdapter(bill_adj3, android.R.layout.simple_spinner_dropdown_item, bill_adj3.i.D3());
            Bill_adj2 bill_adj4 = Bill_adj2.this;
            bill_adj4.i.Md(bill_adj4);
            Bill_adj2 bill_adj5 = Bill_adj2.this;
            bill_adj5.G0(bill_adj5.I0, Bill_adj2.this.q0);
        }
    }

    public class O1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public O1(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    public class P implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public P(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Bill_adj2.this);
                if (this.a[i].equals(Bill_adj2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.i2 = bill_adj2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Bill_adj2.this.A0();
                    }
                } else if (this.a[i].equals(Bill_adj2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Bill_adj2 bill_adj3 = Bill_adj2.this;
                    bill_adj3.i2 = bill_adj3.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Bill_adj2.this.S0();
                    }
                } else if (this.a[i].equals(Bill_adj2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Bill_adj2.this.i.qa(Z00.M + Bill_adj2.this.R0.getTag().toString());
                } else if (this.a[i].equals(Bill_adj2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Bill_adj2.this.R0.setTag(null);
                    Bill_adj2.this.R0.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Bill_adj2.this.R0.getLayoutParams().width = (int) Bill_adj2.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Bill_adj2.this.R0.getLayoutParams().height = (int) Bill_adj2.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
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
        public final /* synthetic */ EditText b;

        public P1(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    public class Q implements View.OnClickListener {
        public Q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.V0 = true;
        }
    }

    public class Q0 implements DialogInterface.OnClickListener {
        public Q0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Q1 implements View.OnClickListener {
        public Q1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.phone_pick_btn(view);
        }
    }

    public class R implements ActivityResultCallback {
        public R() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Bill_adj2.this.a2();
            }
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
        public R1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_adj2.this.X.setText(adapterView.getItemAtPosition(i).toString());
            if (Bill_adj2.this.p == 0) {
                Bill_adj2.this.p1.requestFocus();
            } else {
                Bill_adj2.this.y0.requestFocus();
            }
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.B2 = 1;
            bill_adj2.X1(0);
        }
    }

    public class S extends Handler {
        public S() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
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
            Bill_adj2.this.Y1();
        }
    }

    public class S1 implements CompoundButton.OnCheckedChangeListener {
        public S1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton == Bill_adj2.this.S) {
                Bill_adj2.this.F1();
                if (z) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    if (bill_adj2.c1 != -1 && bill_adj2.L) {
                        bill_adj2.K0();
                        return;
                    }
                }
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                bill_adj3.B2 = 1;
                bill_adj3.o2();
                Bill_adj2.this.H1();
            }
        }
    }

    public class T implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public T(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.i.v0("insert into groups  (name )  values( '" + Bill_adj2.this.Z1 + "'  )");
            Bill_adj2.this.X1 = true;
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
                if (button.getText() == null || !button.getText().toString().equals(Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.add_transaction))) {
                    Log.d("edit_item_S=", FragmentStatePagerSupport_Main.X());
                    if (Bill_adj2.this.Q0()) {
                        Log.d("edit_item_E=", FragmentStatePagerSupport_Main.X());
                        this.a.dismiss();
                        Bill_adj2.this.Y1();
                    }
                } else if (Bill_adj2.this.Q0()) {
                    Bill_adj2.this.M1();
                } else if (Bill_adj2.this.v1.getText().toString().length() == 0 && Bill_adj2.this.t1.getText().toString().length() == 0 && Bill_adj2.this.q1.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_adj2.this.Y1();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class U implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public U(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.X1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
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
                if (Bill_adj2.this.Q0()) {
                    this.a.dismiss();
                    Bill_adj2.this.Y1();
                } else if (Bill_adj2.this.v1.getText().toString().length() == 0 && Bill_adj2.this.t1.getText().toString().length() == 0 && Bill_adj2.this.q1.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Bill_adj2.this.Y1();
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class V implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public V(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class V0 implements DialogInterface.OnClickListener {
        public V0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class W implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public W(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
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
                Bill_adj2.this.add_item(this.a);
            } catch (Exception unused) {
            }
        }
    }

    public class X implements View.OnClickListener {
        public X() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.phone_pick_btn(view);
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
                Bill_adj2.this.i.v0("insert into items  (name  ,o_qty  ,item_type_id,o_date_)  values( '" + ((Object) this.a.getText()) + "' ,'0','" + Bill_adj2.this.j1 + "', strftime('%Y-%m-%d','now') )");
                Bill_adj2.this.add_item(this.b);
            } catch (Exception unused) {
            }
            this.c.dismiss();
        }
    }

    public class Y implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public Y(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.F0(this.a, this.b);
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

    public class Z0 implements AdapterView.OnItemClickListener {
        public Z0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C0634Jt c0634Jt = (C0634Jt) adapterView.getItemAtPosition(i);
                TextView textView = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.no_);
                Bill_adj2.this.I = textView.getText().toString();
                Bill_adj2.this.A = c0634Jt.e();
                TextView textView2 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
                Bill_adj2.this.B = textView2.getText().toString();
                TextView textView3 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_price);
                Bill_adj2.this.C = textView3.getText().toString();
                TextView textView4 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_weight);
                Bill_adj2.this.G = textView4.getText().toString();
                Bill_adj2.this.H = c0634Jt.b();
                Bill_adj2.this.D = c0634Jt.l();
                Bill_adj2.this.F = c0634Jt.m();
                Bill_adj2.this.E = c0634Jt.c();
                Bill_adj2.C2 = 2;
                Bill_adj2.this.q2();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2497a implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2497a(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.i.T(bill_adj2, this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$a0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2498a0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2498a0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$a1, reason: case insensitive filesystem */
    public class C2499a1 implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$a1$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Bill_adj2.this.O0();
                } catch (Exception unused) {
                    Toast.makeText(Bill_adj2.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$a1$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2499a1() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId != info.aalmoghalis.inventory.R.id.menu_delete) {
                if (itemId != info.aalmoghalis.inventory.R.id.menu_info) {
                    return false;
                }
                SparseBooleanArray sparseBooleanArrayB = Bill_adj2.this.A0.b();
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.E0 = sparseBooleanArrayB;
                try {
                    bill_adj2.p2();
                } catch (Exception unused) {
                    Toast.makeText(Bill_adj2.this.getApplicationContext(), "SQL Error.", 1);
                }
                actionMode.finish();
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB2 = Bill_adj2.this.A0.b();
            Bill_adj2 bill_adj3 = Bill_adj2.this;
            bill_adj3.E0 = sparseBooleanArrayB2;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(bill_adj3);
            builder.setMessage(Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
            builder.setPositiveButton(Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
            builder.setNegativeButton(Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
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
            Bill_adj2.this.P.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Bill_adj2.this.A0.j.clear();
            Bill_adj2.this.A0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Bill_adj2.this.P.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Bill_adj2.this.A0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2500b implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2500b(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.i.T(bill_adj2, this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$b0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2501b0 implements View.OnClickListener {
        public ViewOnClickListenerC2501b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_u_currency) {
                Bill_adj2.this.u_currency_btn(view);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$b1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2502b1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2502b1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$c, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2503c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2503c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$c0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2504c0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog d;

        public ViewOnClickListenerC2504c0(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, androidx.appcompat.app.AlertDialog alertDialog) {
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
            if (zA && Bill_adj2.this.i.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Bill_adj2.this.Z1 = this.b.getText().toString();
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.Z0(bill_adj2.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Bill_adj2.this.Z1, Bill_adj2.this);
                if (!Bill_adj2.this.X1) {
                    return;
                }
            }
            if (zA) {
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                if (bill_adj3.o2 != null) {
                    bill_adj3.i.v0("update customers set name='" + this.c.getText().toString().trim() + "',gsm='" + this.a.getText().toString() + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id=(select b.id from customers b where b.name='" + this.c.getText().toString() + "')");
                    Bill_adj2.this.r2 = this.a.getText().toString();
                    Bill_adj2 bill_adj4 = Bill_adj2.this;
                    if (bill_adj4.z2 != 2 || bill_adj4.R.isChecked()) {
                        Bill_adj2 bill_adj5 = Bill_adj2.this;
                        if (bill_adj5.y2 == 4) {
                            bill_adj5.B1();
                            Bill_adj2 bill_adj6 = Bill_adj2.this;
                            Z00 z00 = bill_adj6.i;
                            String str = bill_adj6.r2;
                            StringBuilder sb = new StringBuilder();
                            Bill_adj2 bill_adj7 = Bill_adj2.this;
                            sb.append(bill_adj7.i.ic(bill_adj7.e1()));
                            sb.append(".pdf");
                            z00.Hd(str, sb.toString());
                        } else {
                            Z00 z01 = bill_adj5.i;
                            String str2 = bill_adj5.r2;
                            ListView listView = bill_adj5.P;
                            String str3 = Bill_adj2.this.o2 + "#" + Bill_adj2.this.p0.getText().toString();
                            double d = Double.parseDouble(Bill_adj2.this.g0.getText().toString().replaceAll(",", ""));
                            double d2 = Double.parseDouble(Bill_adj2.this.a0.getText().toString().replaceAll(",", ""));
                            double d3 = Double.parseDouble(Bill_adj2.this.c0.getText().toString().replaceAll(",", ""));
                            double d4 = Double.parseDouble(Bill_adj2.this.e0.getText().toString().replaceAll(",", ""));
                            int i = Bill_adj2.this.t;
                            String string = Bill_adj2.this.T.getText().toString();
                            String string2 = Bill_adj2.this.p0.getText().toString();
                            Bill_adj2 bill_adj8 = Bill_adj2.this;
                            z01.Rc(str2, z01.wd(listView, str3, d, d2, d3, d4, 0.0d, 0.0d, i, string, string2, bill_adj8.o2, bill_adj8.S.isChecked(), Bill_adj2.this.y0.getText().toString()));
                        }
                        Bill_adj2.this.y2 = 0;
                    } else {
                        Bill_adj2 bill_adj9 = Bill_adj2.this;
                        C4064uh c4064uhQ0 = bill_adj9.i.Q0(bill_adj9.o2, bill_adj9.p0.getText().toString(), Bill_adj2.this.p);
                        Bill_adj2 bill_adj10 = Bill_adj2.this;
                        if (bill_adj10.y2 == 4) {
                            Z00 z02 = bill_adj10.i;
                            z02.Ed(bill_adj10.r2, z02.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_adj2.this.p, Bill_adj2.this.T.getText().toString(), ""));
                        } else {
                            Z00 z03 = bill_adj10.i;
                            z03.Rc(bill_adj10.r2, z03.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_adj2.this.p, Bill_adj2.this.T.getText().toString(), ""));
                        }
                        Bill_adj2.this.y2 = 0;
                    }
                }
                this.d.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$c1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2505c1 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ RadioButton b;
        public final /* synthetic */ AlertDialog c;

        public ViewOnClickListenerC2505c1(EditText editText, RadioButton radioButton, AlertDialog alertDialog) {
            this.a = editText;
            this.b = radioButton;
            this.c = alertDialog;
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
                    Bill_adj2.this.K1 = 1;
                } else {
                    Bill_adj2.this.K1 = 0;
                }
                double d3 = Double.parseDouble(Bill_adj2.this.Y.getText().toString().replace(",", "")) + Double.parseDouble(Bill_adj2.this.a0.getText().toString().replace(",", ""));
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                double d4 = bill_adj2.K1 == 1 ? (d2 / 100.0d) * d3 : d2;
                double d5 = d3 - d4;
                double d6 = Double.parseDouble(bill_adj2.c0.getText().toString().replace(",", ""));
                double d7 = (Double.parseDouble(Bill_adj2.this.d0.getText().toString().replaceAll(",", "")) * d5) / 100.0d;
                double d8 = d5 + d7 + d6;
                Bill_adj2.this.i.v0("update bills set amount='" + d8 + "',d_amount= '" + d4 + "',tax_amount= '" + d7 + "',d_val= '" + d2 + "',discount_id= '" + Bill_adj2.this.K1 + "' where id='" + Bill_adj2.this.p + "' and date_='" + Bill_adj2.this.q + "'");
                TextView textView = Bill_adj2.this.Y;
                StringBuilder sb = new StringBuilder();
                sb.append(d8 - d6);
                sb.append("");
                textView.setText(sb.toString());
                TextView textView2 = Bill_adj2.this.a0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d4);
                sb2.append("");
                textView2.setText(sb2.toString());
                Bill_adj2.this.Q1();
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                bill_adj3.I1 = d8;
                bill_adj3.a1();
                this.c.dismiss();
                Bill_adj2 bill_adj4 = Bill_adj2.this;
                bill_adj4.i.Md(bill_adj4);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$d, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2506d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2506d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$d0, reason: case insensitive filesystem */
    public class C2507d0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2507d0(Dialog dialog) {
            this.a = dialog;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0194 A[Catch: Exception -> 0x0054, TryCatch #0 {Exception -> 0x0054, blocks: (B:3:0x0008, B:6:0x001e, B:24:0x0194, B:26:0x019d, B:29:0x01a4, B:30:0x01d0, B:31:0x01e1, B:13:0x005a, B:16:0x0091, B:18:0x00a8, B:21:0x00b2, B:22:0x017f), top: B:35:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x01d0 A[Catch: Exception -> 0x0054, TryCatch #0 {Exception -> 0x0054, blocks: (B:3:0x0008, B:6:0x001e, B:24:0x0194, B:26:0x019d, B:29:0x01a4, B:30:0x01d0, B:31:0x01e1, B:13:0x005a, B:16:0x0091, B:18:0x00a8, B:21:0x00b2, B:22:0x017f), top: B:35:0x0008 }] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) throws Throwable {
            String str;
            try {
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.f1(bill_adj2.X.getText().toString());
                if (i == 0) {
                    Bill_adj2.this.t0();
                    Bill_adj2.this.B1();
                    Z00 z00 = Bill_adj2.this.i;
                    StringBuilder sb = new StringBuilder();
                    Bill_adj2 bill_adj3 = Bill_adj2.this;
                    sb.append(bill_adj3.i.ic(bill_adj3.e1()));
                    sb.append(".pdf");
                    z00.sd(sb.toString());
                    this.a.dismiss();
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            Bill_adj2 bill_adj4 = Bill_adj2.this;
                            bill_adj4.f1(bill_adj4.X.getText().toString());
                            String str2 = Bill_adj2.this.r2;
                            if (str2 == null || str2.length() < 3) {
                                Bill_adj2 bill_adj5 = Bill_adj2.this;
                                String str3 = bill_adj5.k;
                                Bill_adj2 bill_adj6 = Bill_adj2.this;
                                bill_adj5.c2(str3, bill_adj6.o2, bill_adj6.r2, bill_adj6.p2);
                            } else {
                                Bill_adj2 bill_adj7 = Bill_adj2.this;
                                Z00 z01 = bill_adj7.i;
                                String str4 = bill_adj7.r2;
                                ListView listView = bill_adj7.P;
                                String str5 = Bill_adj2.this.o2 + "#" + Bill_adj2.this.p0.getText().toString();
                                double d = Double.parseDouble(Bill_adj2.this.g0.getText().toString().replaceAll(",", ""));
                                double d2 = Double.parseDouble(Bill_adj2.this.a0.getText().toString().replaceAll(",", ""));
                                double d3 = Double.parseDouble(Bill_adj2.this.c0.getText().toString().replaceAll(",", ""));
                                double d4 = Double.parseDouble(Bill_adj2.this.e0.getText().toString().replaceAll(",", ""));
                                int i2 = Bill_adj2.this.t;
                                String string = Bill_adj2.this.T.getText().toString();
                                String string2 = Bill_adj2.this.p0.getText().toString();
                                Bill_adj2 bill_adj8 = Bill_adj2.this;
                                z01.Rc(str4, z01.wd(listView, str5, d, d2, d3, d4, 0.0d, 0.0d, i2, string, string2, bill_adj8.o2, false, bill_adj8.y0.getText().toString()));
                            }
                        }
                        if (i == 3) {
                            Bill_adj2 bill_adj9 = Bill_adj2.this;
                            bill_adj9.y2 = 4;
                            str = bill_adj9.r2;
                            if (str != null || str.length() < 3) {
                                Bill_adj2 bill_adj10 = Bill_adj2.this;
                                String str6 = bill_adj10.k;
                                Bill_adj2 bill_adj11 = Bill_adj2.this;
                                bill_adj10.c2(str6, bill_adj11.o2, bill_adj11.r2, bill_adj11.p2);
                            } else {
                                Bill_adj2.this.B1();
                                Bill_adj2 bill_adj12 = Bill_adj2.this;
                                Z00 z02 = bill_adj12.i;
                                String str7 = bill_adj12.r2;
                                StringBuilder sb2 = new StringBuilder();
                                Bill_adj2 bill_adj13 = Bill_adj2.this;
                                sb2.append(bill_adj13.i.ic(bill_adj13.e1()));
                                sb2.append(".pdf");
                                z02.Hd(str7, sb2.toString());
                            }
                        }
                        this.a.dismiss();
                    }
                    Bill_adj2.this.t0();
                    Bill_adj2.this.A1();
                    Z00 z03 = Bill_adj2.this.i;
                    StringBuilder sb3 = new StringBuilder();
                    Bill_adj2 bill_adj14 = Bill_adj2.this;
                    sb3.append(bill_adj14.i.ic(bill_adj14.e1()));
                    sb3.append(".xls");
                    z03.pa(sb3.toString());
                    this.a.dismiss();
                }
                if (i == 3) {
                    Bill_adj2 bill_adj15 = Bill_adj2.this;
                    bill_adj15.y2 = 4;
                    str = bill_adj15.r2;
                    if (str != null) {
                        Bill_adj2 bill_adj16 = Bill_adj2.this;
                        String str8 = bill_adj16.k;
                        Bill_adj2 bill_adj17 = Bill_adj2.this;
                        bill_adj16.c2(str8, bill_adj17.o2, bill_adj17.r2, bill_adj17.p2);
                    } else {
                        Bill_adj2 bill_adj18 = Bill_adj2.this;
                        String str9 = bill_adj18.k;
                        Bill_adj2 bill_adj19 = Bill_adj2.this;
                        bill_adj18.c2(str9, bill_adj19.o2, bill_adj19.r2, bill_adj19.p2);
                    }
                }
                this.a.dismiss();
            } catch (Exception e) {
                Log.d("share_err", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$d1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2508d1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2508d1(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.i.Md(bill_adj2);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2509e implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog g;

        public ViewOnClickListenerC2509e(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, EditText editText2, EditText editText3, androidx.appcompat.app.AlertDialog alertDialog) {
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
            if (Bill_adj2.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Bill_adj2.this.Z1 = this.b.getText().toString();
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.W0(bill_adj2.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Bill_adj2.this.Z1, Bill_adj2.this);
                if (!Bill_adj2.this.R1) {
                    return;
                }
            }
            if (z) {
                int iR1 = Bill_adj2.this.i.r1(this.c.getText().toString());
                if (!this.d.equals("0")) {
                    if (this.d != null) {
                        Bill_adj2.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.e.getText().toString() + "',address='" + this.f.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Bill_adj2.this.k + "' and id>0 ");
                        this.g.dismiss();
                        return;
                    }
                    return;
                }
                if (Bill_adj2.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                    FragmentStatePagerSupport_Main.Z(Bill_adj2.this);
                    this.a.setError(Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.exist));
                    return;
                }
                Bill_adj2.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.e.getText().toString() + "','" + this.f.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                if (iR1 == 121 || iR1 == 122) {
                    Bill_adj2.this.q0.setText(this.a.getText().toString());
                }
                this.g.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$e0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2510e0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2510e0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bill_adj2.this.i.H("delete from bill_transactions where bill_id='" + Bill_adj2.this.p + "' and exists(select * from bills a where a.id=bill_transactions.bill_id and a.date_='" + Bill_adj2.this.q + "' and tr_type=" + Bill_adj2.this.t + " and tr_type in(21,11) )", "delete from bills where id ='" + Bill_adj2.this.p + "' and date_='" + Bill_adj2.this.q + "' and tr_type in(21,11)");
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.g2 = true;
                Adj2.W = Adj2.W - 1;
                bill_adj2.j1();
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getApplicationContext(), "SQL Error.", 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$e1, reason: case insensitive filesystem */
    public class C2511e1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2511e1(AutoCompleteTextView autoCompleteTextView) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$f, reason: case insensitive filesystem */
    public class C2512f implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2512f(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$f0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2513f0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2513f0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$f1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2514f1 implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ RadioButton b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ TextView d;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$f1$a */
        public class a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ Dialog a;

            public a(Dialog dialog) {
                this.a = dialog;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ViewOnClickListenerC2514f1.this.a.setText(adapterView.getItemAtPosition(i).toString());
                if (ViewOnClickListenerC2514f1.this.b.isChecked() && ViewOnClickListenerC2514f1.this.c.getText().toString().length() > 0) {
                    double d = Double.parseDouble(ViewOnClickListenerC2514f1.this.c.getText().toString().replaceAll(",", ""));
                    if (d > 100.0d || d < 0.0d) {
                        ViewOnClickListenerC2514f1.this.c.setError("% value");
                        return;
                    }
                }
                double d2 = Double.parseDouble(ViewOnClickListenerC2514f1.this.c.getText().toString().replaceAll(",", ""));
                boolean zIsChecked = ViewOnClickListenerC2514f1.this.b.isChecked();
                double d3 = Double.parseDouble(Bill_adj2.this.Y.getText().toString().replace(",", "")) + Double.parseDouble(Bill_adj2.this.a0.getText().toString().replace(",", ""));
                if (zIsChecked) {
                    d2 = (d2 / 100.0d) * d3;
                }
                double d4 = (Double.parseDouble(ViewOnClickListenerC2514f1.this.a.getText().toString().replaceAll(",", "")) * (d3 - d2)) / 100.0d;
                ViewOnClickListenerC2514f1 viewOnClickListenerC2514f1 = ViewOnClickListenerC2514f1.this;
                viewOnClickListenerC2514f1.d.setText(Bill_adj2.this.i.P7(d4 + ""));
                if (d4 > 0.0d) {
                    ViewOnClickListenerC2514f1.this.d.setVisibility(0);
                }
                this.a.dismiss();
            }
        }

        public ViewOnClickListenerC2514f1(TextView textView, RadioButton radioButton, EditText editText, TextView textView2) {
            this.a = textView;
            this.b = radioButton;
            this.c = editText;
            this.d = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_adj2.this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            Dialog dialog = new Dialog(Bill_adj2.this);
            LinearLayout linearLayout = new LinearLayout(Bill_adj2.this);
            ListView listView = new ListView(Bill_adj2.this);
            listView.setAdapter((ListAdapter) Bill_adj2.this.i0);
            listView.setOnItemClickListener(new a(dialog));
            linearLayout.setFocusable(true);
            listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            linearLayout.addView(listView, -1, -1);
            dialog.setContentView(linearLayout);
            dialog.show();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$g, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2515g implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnTouchListenerC2515g(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$g0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2516g0 implements View.OnClickListener {
        public final /* synthetic */ Snackbar a;

        public ViewOnClickListenerC2516g0(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Bill_adj2.this.j1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$g1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2517g1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2517g1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$h, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2518h implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2518h(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.F0(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$h0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2519h0 implements View.OnClickListener {
        public ViewOnClickListenerC2519h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.U1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$h1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2520h1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2520h1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$i, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2521i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2521i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$i0, reason: case insensitive filesystem */
    public class RunnableC2522i0 implements Runnable {
        public final /* synthetic */ Snackbar a;

        public RunnableC2522i0(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$i1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2523i1 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ RadioButton c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ TextView f;
        public final /* synthetic */ AlertDialog g;
        public final /* synthetic */ View h;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$i1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_adj2.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2523i1(EditText editText, AutoCompleteTextView autoCompleteTextView, RadioButton radioButton, EditText editText2, EditText editText3, TextView textView, AlertDialog alertDialog, View view) {
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
            if (Bill_adj2.this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            if (this.a.getText().toString().length() == 0) {
                this.a.setText("0");
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                if (bill_adj2.Q1 == 0) {
                    bill_adj2.Q1 = -24;
                }
                this.b.setText(bill_adj2.i.A4(Bill_adj2.this.Q1 + ""));
            } else {
                if (!AbstractC4371yX.a(this.a) || !AbstractC4371yX.a(this.b)) {
                    return;
                }
                if (Bill_adj2.this.i.v8(this.b.getText().toString(), Bill_adj2.this.t).getCount() == 0) {
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
                Bill_adj2.this.K1 = 0;
            }
            if (this.e.getText().toString().length() == 0) {
                this.e.setText("0");
            }
            double d2 = Double.parseDouble(this.d.getText().toString().replaceAll(",", ""));
            if (this.c.isChecked()) {
                Bill_adj2.this.K1 = 1;
            } else {
                Bill_adj2.this.K1 = 0;
            }
            double d3 = Double.parseDouble(Bill_adj2.this.Y.getText().toString().replace(",", "")) + Double.parseDouble(Bill_adj2.this.a0.getText().toString().replace(",", ""));
            double d4 = Bill_adj2.this.K1 == 1 ? (d2 / 100.0d) * d3 : d2;
            double d5 = d3 - d4;
            double d6 = Double.parseDouble(this.a.getText().toString().replace(",", ""));
            double d7 = (Double.parseDouble(this.f.getText().toString().replaceAll(",", "")) * d5) / 100.0d;
            double d8 = d5 + d7 + d6;
            Z00 z00 = Bill_adj2.this.i;
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
            sb.append(Bill_adj2.this.K1);
            sb.append("',cost2= '");
            sb.append(d6);
            sb.append("',cost_id= (select id from customers where name='");
            sb.append(this.b.getText().toString());
            sb.append("'),paid_amount=");
            if (Bill_adj2.this.R.isChecked()) {
                str = "0";
            } else {
                str = "'" + this.e.getText().toString().replaceAll(",", "") + "'";
            }
            sb.append(str);
            sb.append(",bill_type=");
            sb.append(Bill_adj2.this.R.isChecked() ? 1 : 2);
            sb.append(" where id='");
            sb.append(Bill_adj2.this.p);
            sb.append("' and date_='");
            sb.append(Bill_adj2.this.q);
            sb.append("'");
            String strY0 = z00.y0(sb.toString());
            if (strY0 == null || !strY0.equals("1")) {
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strY0 == null || strY0.length() <= 20) {
                    i = 0;
                } else {
                    i = 0;
                    strY0 = strY0.substring(0, 20);
                }
                sb2.append(strY0);
                Toast.makeText(bill_adj3, sb2.toString(), i).show();
                Bill_adj2.this.L1();
                Bill_adj2.this.a1();
                return;
            }
            Bill_adj2.this.Y.setText((d8 - d6) + "");
            Bill_adj2.this.a0.setText(d4 + "");
            Bill_adj2.this.Q1();
            Bill_adj2 bill_adj4 = Bill_adj2.this;
            bill_adj4.I1 = d8;
            bill_adj4.a1();
            this.g.dismiss();
            View currentFocus = Bill_adj2.this.getCurrentFocus();
            if (this.h != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$j, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2524j implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2524j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$j0, reason: case insensitive filesystem */
    public class C2525j0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2525j0(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            C4064uh c4064uhQ0 = bill_adj2.i.Q0(bill_adj2.o2, bill_adj2.p0.getText().toString(), Bill_adj2.this.p);
            if (i == 0) {
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                bill_adj3.y2 = 4;
                String str = bill_adj3.r2;
                if (str == null || str.length() < 3) {
                    Bill_adj2 bill_adj4 = Bill_adj2.this;
                    String str2 = bill_adj4.k;
                    Bill_adj2 bill_adj5 = Bill_adj2.this;
                    bill_adj4.c2(str2, bill_adj5.o2, bill_adj5.r2, bill_adj5.p2);
                } else {
                    Bill_adj2 bill_adj6 = Bill_adj2.this;
                    Z00 z00 = bill_adj6.i;
                    z00.Ed(bill_adj6.r2, z00.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_adj2.this.p, Bill_adj2.this.T.getText().toString(), ""));
                }
            } else if (i == 1) {
                Bill_adj2 bill_adj7 = Bill_adj2.this;
                bill_adj7.y2 = 3;
                String str3 = bill_adj7.r2;
                if (str3 == null || str3.length() < 3) {
                    Bill_adj2 bill_adj8 = Bill_adj2.this;
                    String str4 = bill_adj8.k;
                    Bill_adj2 bill_adj9 = Bill_adj2.this;
                    bill_adj8.c2(str4, bill_adj9.o2, bill_adj9.r2, bill_adj9.p2);
                } else {
                    Bill_adj2 bill_adj10 = Bill_adj2.this;
                    Z00 z01 = bill_adj10.i;
                    z01.Rc(bill_adj10.r2, z01.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_adj2.this.p, Bill_adj2.this.T.getText().toString(), ""));
                }
            } else if (i == 2) {
                Z00 z02 = Bill_adj2.this.i;
                z02.td(z02.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.c().replaceAll(",", "")), Bill_adj2.this.p, Bill_adj2.this.T.getText().toString(), ""));
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$j1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2526j1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ View b;

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$j1$a */
        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bill_adj2.this.i.x9(this.a);
            }
        }

        public ViewOnClickListenerC2526j1(AlertDialog alertDialog, View view) {
            this.a = alertDialog;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            View currentFocus = Bill_adj2.this.getCurrentFocus();
            if (this.b != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$k, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2527k implements View.OnTouchListener {
        public ViewOnTouchListenerC2527k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_adj2.this.X.showDropDown();
            if (motionEvent.getAction() == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("x=");
                sb.append(motionEvent.getX());
                sb.append(":bound=");
                sb.append(Bill_adj2.this.X.getCompoundDrawables()[0] != null ? Bill_adj2.this.X.getCompoundDrawables()[0].getBounds().width() : 0);
                sb.append(":paddingLeft=");
                sb.append(Bill_adj2.this.X.getPaddingLeft());
                sb.append(":Left=");
                sb.append(Bill_adj2.this.X.getLeft());
                sb.append(":getRawX=");
                sb.append(motionEvent.getRawX());
                sb.append(":getTotalPaddingLeft=");
                sb.append(Bill_adj2.this.X.getTotalPaddingLeft());
                Log.d("clear_action_up:=", sb.toString());
                if (motionEvent.getX() <= Bill_adj2.this.X.getTotalPaddingLeft()) {
                    Bill_adj2.this.X.setText("");
                    Bill_adj2.this.X.requestFocus();
                    Bill_adj2.this.B2 = 1;
                    return false;
                }
                motionEvent.getX();
                Bill_adj2.this.X.getRight();
                Bill_adj2.this.X.getPaddingRight();
                if (Bill_adj2.this.X.getCompoundDrawables()[2] != null) {
                    Bill_adj2.this.X.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$k0, reason: case insensitive filesystem */
    public class HandlerC2528k0 extends Handler {
        public HandlerC2528k0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$k1, reason: case insensitive filesystem */
    public class C2529k1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2529k1(AutoCompleteTextView autoCompleteTextView) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$l, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2530l implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ Handler e;

        public ViewOnClickListenerC2530l(AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog, String str, EditText editText, Handler handler) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
            this.c = str;
            this.d = editText;
            this.e = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (zA && Bill_adj2.this.i.P5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Bill_adj2.this.Z1 = this.a.getText().toString();
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.X0(bill_adj2.getString(info.aalmoghalis.inventory.R.string.validation_add_item), Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item) + "#" + Bill_adj2.this.Z1, this.b.getContext());
                if (!Bill_adj2.this.X1) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Bill_adj2.this.i.H("insert into items (name,item_type_id,o_date) values('" + this.d.getText().toString() + "',(select b.id from item_type b where b.name='" + this.a.getText().toString() + "'),'" + Bill_adj2.this.T.getText().toString() + "' )", "insert into item_price (item_id,curr_id,sls_u_price,unit_id) values((select id from items a where a.name='" + this.d.getText().toString() + "'),(select b.id from currency b where b.name='" + Bill_adj2.this.p0.getText().toString() + "'),'0' ,0)");
                    Bill_adj2 bill_adj3 = Bill_adj2.this;
                    bill_adj3.W1 = 0;
                    bill_adj3.R1 = true;
                    Bill_adj2.this.p1.setText(this.d.getText().toString());
                    Handler handler = this.e;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$l0, reason: case insensitive filesystem */
    public class C2531l0 implements TextWatcher {
        public C2531l0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            if (bill_adj2.V0) {
                bill_adj2.V0 = false;
            } else {
                bill_adj2.B2 = 1;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$l1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2532l1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2532l1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$m, reason: case insensitive filesystem */
    public class HandlerC2533m extends Handler {
        public HandlerC2533m() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$m0, reason: case insensitive filesystem */
    public class C2534m0 implements TextWatcher {
        public C2534m0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            if (bill_adj2.X0) {
                bill_adj2.X0 = false;
                return;
            }
            if (bill_adj2.t1.hasFocus()) {
                Bill_adj2.this.k2(1);
            } else if (Bill_adj2.this.q1.hasFocus()) {
                Bill_adj2.this.k2(2);
            } else if (Bill_adj2.this.r1.hasFocus()) {
                Bill_adj2.this.k2(3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$m1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2535m1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2535m1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$n, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2536n implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2536n(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.i.v0("insert into item_type  (name )  values( '" + Bill_adj2.this.Z1 + "'  )");
            Bill_adj2.this.Y1 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$n0, reason: case insensitive filesystem */
    public class C2537n0 implements TextWatcher {
        public C2537n0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Log.d("item_focus=", Bill_adj2.this.t1.hasFocus() + ":" + Bill_adj2.this.q1.hasFocus() + ":" + Bill_adj2.this.r1.hasFocus() + "#" + Bill_adj2.this.X0);
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            if (bill_adj2.X0) {
                bill_adj2.X0 = false;
                return;
            }
            if (bill_adj2.y1.hasFocus()) {
                Bill_adj2.this.l2(1);
            } else if (Bill_adj2.this.w1.hasFocus()) {
                Bill_adj2.this.l2(2);
            } else if (Bill_adj2.this.x1.hasFocus()) {
                Bill_adj2.this.l2(3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$n1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2538n1 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AlertDialog c;

        public ViewOnClickListenerC2538n1(EditText editText, AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            boolean z = false;
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (Bill_adj2.this.i.v8(this.b.getText().toString(), Bill_adj2.this.t).getCount() == 0) {
                this.b.setError("*");
            } else {
                z = zA;
            }
            if (z) {
                double d = Double.parseDouble(this.a.getText().toString().replaceAll(",", ""));
                double d2 = Double.parseDouble(Bill_adj2.this.Y.getText().toString().replace(",", ""));
                double d3 = d2 + ((Double.parseDouble(Bill_adj2.this.d0.getText().toString().replaceAll(",", "")) * d2) / 100.0d) + d;
                Log.d("bill_cost=", d3 + ":" + d);
                Bill_adj2.this.i.v0("update bills set amount='" + d3 + "',cost2= '" + d + "',cost_id= (select id from customers where name='" + this.b.getText().toString() + "') where id='" + Bill_adj2.this.p + "' and date_='" + Bill_adj2.this.q + "'");
                TextView textView = Bill_adj2.this.Y;
                StringBuilder sb = new StringBuilder();
                sb.append(d3 - d);
                sb.append("");
                textView.setText(sb.toString());
                TextView textView2 = Bill_adj2.this.c0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d);
                sb2.append("");
                textView2.setText(sb2.toString());
                Bill_adj2.this.Q1();
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.I1 = d3;
                bill_adj2.a1();
                this.c.dismiss();
                Bill_adj2 bill_adj3 = Bill_adj2.this;
                bill_adj3.i.Md(bill_adj3);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$o, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2539o implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2539o(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.Y1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$o0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2540o0 implements View.OnClickListener {
        public ViewOnClickListenerC2540o0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.X1(1);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$o1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2541o1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2541o1(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.i.Md(bill_adj2);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$p, reason: case insensitive filesystem */
    public class C2542p implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2542p(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$p0, reason: case insensitive filesystem */
    public class C2543p0 implements AdapterView.OnItemClickListener {
        public C2543p0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Bill_adj2.this.q1(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$p1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2544p1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public DialogInterfaceOnClickListenerC2544p1(TextView textView, ImageView imageView) {
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
                Bill_adj2.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Bill_adj2.this.p = 0L;
                Bill_adj2.this.a1();
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getApplicationContext(), Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$q, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2545q implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnTouchListenerC2545q(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$q0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2546q0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2546q0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Bill_adj2.this.p1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.p1.getCompoundDrawables()[0] != null ? Bill_adj2.this.p1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.p1.getPaddingLeft() + Bill_adj2.this.p1.getLeft()) {
                    Bill_adj2.this.p1.setText("");
                    Bill_adj2.this.p1.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Bill_adj2.this.p1.getRight();
                Bill_adj2.this.p1.getPaddingRight();
                if (Bill_adj2.this.p1.getCompoundDrawables()[2] != null) {
                    Bill_adj2.this.p1.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$q1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2547q1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2547q1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$r, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2548r implements View.OnClickListener {
        public ViewOnClickListenerC2548r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$r0, reason: case insensitive filesystem */
    public class C2549r0 implements TextWatcher {
        public C2549r0() {
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
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.p1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(bill_adj2, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_adj2.this.p1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Bill_adj2.this.p1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$r1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2550r1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public DialogInterfaceOnClickListenerC2550r1(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Bill_adj2.this.i.v0("delete from items_temp  where no_=  '" + ((Object) this.a.getText()) + "'");
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.i1 = 1;
                    bill_adj2.a1();
                    Bill_adj2.this.v1();
                    Bill_adj2.this.W1(false);
                    Bill_adj2 bill_adj3 = Bill_adj2.this;
                    bill_adj3.i1 = 1;
                    bill_adj3.N0();
                    Bill_adj2.this.a1();
                    Bill_adj2 bill_adj4 = Bill_adj2.this;
                    bill_adj4.n2(bill_adj4.p, "0");
                }
            } catch (Exception unused) {
                Toast.makeText(Bill_adj2.this.getApplicationContext(), Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$s, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2551s implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2551s(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.F0(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$s0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2552s0 implements View.OnClickListener {
        public ViewOnClickListenerC2552s0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = Bill_adj2.this.p0.getText().toString();
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.i.T(bill_adj2, bill_adj2.G0, Bill_adj2.this.p0);
            Log.d("curr=", string + ":" + Bill_adj2.this.p0.getText().toString() + ":" + Bill_adj2.this.p);
            Bill_adj2.this.B2 = 1;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$s1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2553s1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2553s1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$t, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2554t implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2554t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$t0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2555t0 implements View.OnClickListener {
        public ViewOnClickListenerC2555t0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2.this.more_item(view);
        }
    }

    public class t1 extends Handler {
        public t1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$u, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2556u implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2556u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$u0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2557u0 implements View.OnClickListener {
        public ViewOnClickListenerC2557u0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_adj2.this.q1.getText().toString().length() != 0) {
                Bill_adj2.this.q1.setText("");
            } else {
                EditText editText = Bill_adj2.this.q1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class u1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public u1(Handler handler, String str, int i) {
            this.a = handler;
            this.b = str;
            this.c = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.q0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$v, reason: case insensitive filesystem */
    public class C2558v implements TextWatcher {
        public C2558v() {
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
                Bill_adj2.this.X.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(Bill_adj2.this, android.R.drawable.ic_notification_clear_all), (Drawable) null, Bill_adj2.this.X.getCompoundDrawables()[2], (Drawable) null);
            } else {
                Bill_adj2.this.X.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, Bill_adj2.this.X.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$v0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2559v0 implements View.OnClickListener {
        public ViewOnClickListenerC2559v0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Bill_adj2.this.r1.getText().toString().length() != 0) {
                Bill_adj2.this.r1.setText("");
            } else {
                EditText editText = Bill_adj2.this.r1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class v1 implements CompoundButton.OnCheckedChangeListener {
        public v1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            bill_adj2.B2 = 1;
            bill_adj2.o2();
            if (Bill_adj2.this.t == 21) {
                Bill_adj2.this.b1();
            } else if (Bill_adj2.this.t == 11) {
                Bill_adj2.this.b1();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$w, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2560w implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Handler g;

        public ViewOnClickListenerC2560w(AutoCompleteTextView autoCompleteTextView, androidx.appcompat.app.AlertDialog alertDialog, String str, EditText editText, EditText editText2, int i, Handler handler) {
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
            if (zA && Bill_adj2.this.i.Q5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Bill_adj2.this.Z1 = this.a.getText().toString();
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.Z0(bill_adj2.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Bill_adj2.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Bill_adj2.this.Z1, this.b.getContext());
                if (!Bill_adj2.this.X1) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Z00 z00 = Bill_adj2.this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into customers (name,gsm,g_id,acc_p_id) values('");
                    sb.append(this.d.getText().toString().trim());
                    sb.append("','");
                    sb.append(this.e.getText().toString());
                    sb.append("',(select b.id from groups b where b.name='");
                    sb.append(this.a.getText().toString());
                    sb.append("'),'");
                    sb.append(this.f == 21 ? "221" : "123");
                    sb.append("' )");
                    z00.v0(sb.toString());
                    Bill_adj2 bill_adj3 = Bill_adj2.this;
                    bill_adj3.W1 = 0;
                    bill_adj3.R1 = true;
                    Bill_adj2.this.o2 = this.d.getText().toString();
                    Bill_adj2.this.r2 = this.e.getText().toString();
                    Bill_adj2.this.p2 = this.a.getText().toString();
                    Handler handler = this.g;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$w0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2561w0 implements View.OnClickListener {
        public ViewOnClickListenerC2561w0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bill_adj2 bill_adj2 = Bill_adj2.this;
            double dDoubleValue = bill_adj2.C0(bill_adj2.v1.getText().toString(), Bill_adj2.this.n).doubleValue();
            Bill_adj2 bill_adj3 = Bill_adj2.this;
            Z00 z00 = bill_adj3.i;
            String string = bill_adj3.v1.getText().toString();
            String string2 = Bill_adj2.this.X.getText().toString();
            String string3 = Bill_adj2.this.p0.getText().toString();
            boolean zIsChecked = Bill_adj2.this.S.isChecked();
            Bill_adj2 bill_adj4 = Bill_adj2.this;
            z00.te(bill_adj3, string, string2, string3, dDoubleValue, zIsChecked, bill_adj4.b1, bill_adj4.t, Bill_adj2.this.D1.getText().toString());
        }
    }

    public class w1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public w1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.R1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$x, reason: case insensitive filesystem */
    public class C2562x implements Filter.FilterListener {
        public C2562x() {
        }

        @Override // android.widget.Filter.FilterListener
        public void onFilterComplete(int i) {
            if (i == 0) {
                Bill_adj2.this.b2.setQuery("", false);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$x0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2563x0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2563x0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.t1.getCompoundDrawables()[0] != null ? Bill_adj2.this.t1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.t1.getPaddingLeft() + Bill_adj2.this.t1.getLeft()) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.i.B(bill_adj2.t1, bill_adj2.F1);
                }
            }
            return false;
        }
    }

    public class x1 extends Handler {
        public x1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$y, reason: case insensitive filesystem */
    public class C2564y implements SearchView.OnQueryTextListener {
        public C2564y() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Bill_adj2.this.y1(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$y0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2565y0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2565y0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.q1.getCompoundDrawables()[0] != null ? Bill_adj2.this.q1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.q1.getPaddingLeft() + Bill_adj2.this.q1.getLeft()) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.i.B(bill_adj2.q1, bill_adj2.F1);
                }
            }
            return false;
        }
    }

    public class y1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public y1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.r0(this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$z, reason: case insensitive filesystem */
    public class C2566z implements DatePickerDialog.OnDateSetListener {
        public C2566z() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bill_adj2.this.M = i;
            Bill_adj2.this.N = i2;
            Bill_adj2.this.O = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_adj2.this.M)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bill_adj2.this.N + 1)) + "-" + Bill_adj2.this.O;
                Locale locale = Locale.ENGLISH;
                Bill_adj2.this.T.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                new C2160f10(Bill_adj2.this.i).W(Bill_adj2.this.T.getText().toString());
                Bill_adj2 bill_adj2 = Bill_adj2.this;
                bill_adj2.n2(bill_adj2.p, "0");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bill_adj2$z0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2567z0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2567z0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Bill_adj2.this.r1.getCompoundDrawables()[0] != null ? Bill_adj2.this.r1.getCompoundDrawables()[0].getBounds().width() : 0) + Bill_adj2.this.r1.getPaddingLeft() + Bill_adj2.this.r1.getLeft()) {
                    Bill_adj2 bill_adj2 = Bill_adj2.this;
                    bill_adj2.z0(bill_adj2.r1);
                }
            }
            return false;
        }
    }

    public class z1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public z1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Bill_adj2.this.R1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            a2();
            return;
        }
        int i = Integer.parseInt(this.i.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.i.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.m2.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean B0() {
        boolean zA = AbstractC4371yX.a(this.X);
        if (this.p != 0 && !AbstractC4371yX.a(this.y0)) {
            zA = false;
        }
        if (this.X.getText().length() == 0) {
            zA = false;
        }
        if (!this.i.Q()) {
            return zA;
        }
        J0();
        return false;
    }

    private void M0(File file, File file2) throws IOException {
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

    private void N1(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
    }

    private void O1() {
        String[] stringArray = this.R0.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setItems(stringArray, new O(stringArray));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    private void P0() {
        String[] stringArray = this.R0.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setItems(stringArray, new P(stringArray));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.l2.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.k2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1() {
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

    private void m2() {
        int i = this.t;
        if (i == 21 || i == 11) {
            b1();
        }
        if (this.t == 21) {
            this.R.isChecked();
        }
    }

    public static boolean n1(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean o1(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static /* synthetic */ void u1(Integer num) {
    }

    private void x1(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                M0(new File(Z00.A0), file2);
            } else {
                M0(new File(U0(this, this.n2)), file2);
            }
            S1(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void z1(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.i, this);
            if (strX != null) {
                S1(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void A1() throws Throwable {
        String string;
        Z00 z00 = this.i;
        ListView listView = this.P;
        String strE1 = e1();
        if (this.y0.getText().length() == 0) {
            string = this.p + "";
        } else {
            string = this.y0.getText().toString();
        }
        z00.Na(listView, strE1, string, this.T.getText().toString(), this.X.getHint().toString(), this.X.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total), this.g0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_disc), this.a0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_tax) + " - " + this.d0.getText().toString() + CSS.Value.PERCENTAGE, this.e0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_other_cost), this.c0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.paid_amount), "0", getString(info.aalmoghalis.inventory.R.string.remain_amount), "0", this.R.isChecked(), 5, this.z0.getText().toString(), this.p0.getText().toString(), this.Z.getText().toString(), this.i.ja("prefOthers_print_end_date", false), this.V.getText().toString(), this.t);
    }

    public void B1() {
        String string;
        Z00 z00 = this.i;
        ListView listView = this.P;
        String strE1 = e1();
        if (this.y0.getText().length() == 0) {
            string = this.p + "";
        } else {
            string = this.y0.getText().toString();
        }
        z00.Ya(listView, strE1, string, this.T.getText().toString(), this.X.getHint().toString(), this.X.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total), this.g0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_disc), this.a0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_other_cost), this.c0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_tax) + " - " + this.d0.getText().toString() + CSS.Value.PERCENTAGE, this.e0.getText().toString(), "", "0", "", "0", this.R.isChecked(), 5, this.z0.getText().toString(), this.p0.getText().toString(), this.p + "", this.t, this.i.ja("prefOthers_print_end_date", false), this.V.getText().toString());
    }

    public Double C0(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.s0, str, str2);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListH.size());
        double d = 0.0d;
        for (int i = 0; i < arrayListH.size(); i++) {
            d += Double.parseDouble((String) ((HashMap) arrayListH.get(i)).get("item_qty"));
        }
        Log.d("check_item_qty_current=", "" + str + ":" + d);
        return Double.valueOf(d);
    }

    public void C1() {
        int i = this.z2;
        if (i == 1) {
            this.z2 = 2;
        } else if (i == 2) {
            this.z2 = 0;
        }
        this.w2 = false;
        this.g2 = true;
    }

    public ArrayList D0(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.s0, str, str2);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListH.iterator();
        while (it.hasNext()) {
            arrayList.add((HashMap) ((HashMap) it.next()).clone());
        }
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayList.size());
        double dZ6 = this.i.Z6(str, this.D1.getText().toString());
        for (int i = 0; i < arrayList.size(); i++) {
            double d = Double.parseDouble((String) ((HashMap) arrayList.get(i)).get("item_qty")) / dZ6;
            ((HashMap) arrayList.get(i)).put("item_qty", this.i.S7(String.valueOf(d)).replaceAll(",", ""));
            ((HashMap) arrayList.get(i)).put("item_date_qty", "(" + ((String) ((HashMap) arrayList.get(i)).get("item_date")) + ")" + this.i.S7(String.valueOf(d)).replaceAll(",", ""));
        }
        return arrayList;
    }

    public void D1(int i) {
        String str;
        if (i == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle().toString());
        if (this.X.getText().toString() == null) {
            str = "";
        } else {
            str = "#" + this.X.getText().toString();
        }
        sb.append(str);
        this.N0 = sb.toString();
        if (this.v2 != 1) {
            this.v2 = 0;
            V1();
            return;
        }
        t0();
        B1();
        this.i.ra(this.i.ic(e1()) + ".pdf");
    }

    public Double E0(String str, String str2, String str3) {
        double d;
        ArrayList arrayListG = new C1839c10().g(this.s0, str, str2, str3);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListG.size());
        if (arrayListG.size() > 0) {
            Log.d("check_item_qty=", str + ":" + str2 + "#" + ((String) ((HashMap) arrayListG.get(0)).get("item_qty")));
            d = Double.parseDouble((String) ((HashMap) arrayListG.get(0)).get("item_qty"));
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0163 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0165 A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x0058, B:16:0x0072, B:18:0x0086, B:20:0x009a, B:22:0x00ae, B:26:0x00ca, B:28:0x0127, B:35:0x014a, B:36:0x0157, B:40:0x0165, B:42:0x017f, B:47:0x01d4, B:52:0x023c, B:56:0x029b, B:61:0x02ae, B:65:0x02bf, B:68:0x02da, B:70:0x0396, B:73:0x03a7, B:74:0x03c5, B:76:0x03e2, B:60:0x02aa, B:55:0x0295), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x017f A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x0058, B:16:0x0072, B:18:0x0086, B:20:0x009a, B:22:0x00ae, B:26:0x00ca, B:28:0x0127, B:35:0x014a, B:36:0x0157, B:40:0x0165, B:42:0x017f, B:47:0x01d4, B:52:0x023c, B:56:0x029b, B:61:0x02ae, B:65:0x02bf, B:68:0x02da, B:70:0x0396, B:73:0x03a7, B:74:0x03c5, B:76:0x03e2, B:60:0x02aa, B:55:0x0295), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:44:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:45:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:47:0x01d4 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #0 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x0058, B:16:0x0072, B:18:0x0086, B:20:0x009a, B:22:0x00ae, B:26:0x00ca, B:28:0x0127, B:35:0x014a, B:36:0x0157, B:40:0x0165, B:42:0x017f, B:47:0x01d4, B:52:0x023c, B:56:0x029b, B:61:0x02ae, B:65:0x02bf, B:68:0x02da, B:70:0x0396, B:73:0x03a7, B:74:0x03c5, B:76:0x03e2, B:60:0x02aa, B:55:0x0295), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0238  */
    /* JADX WARN: Code duplicated, block: B:51:0x023b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0292  */
    /* JADX WARN: Code duplicated, block: B:55:0x0295 A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x0058, B:16:0x0072, B:18:0x0086, B:20:0x009a, B:22:0x00ae, B:26:0x00ca, B:28:0x0127, B:35:0x014a, B:36:0x0157, B:40:0x0165, B:42:0x017f, B:47:0x01d4, B:52:0x023c, B:56:0x029b, B:61:0x02ae, B:65:0x02bf, B:68:0x02da, B:70:0x0396, B:73:0x03a7, B:74:0x03c5, B:76:0x03e2, B:60:0x02aa, B:55:0x0295), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:59:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:60:0x02aa A[Catch: Exception -> 0x0055, TRY_ENTER, TryCatch #0 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x0058, B:16:0x0072, B:18:0x0086, B:20:0x009a, B:22:0x00ae, B:26:0x00ca, B:28:0x0127, B:35:0x014a, B:36:0x0157, B:40:0x0165, B:42:0x017f, B:47:0x01d4, B:52:0x023c, B:56:0x029b, B:61:0x02ae, B:65:0x02bf, B:68:0x02da, B:70:0x0396, B:73:0x03a7, B:74:0x03c5, B:76:0x03e2, B:60:0x02aa, B:55:0x0295), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:63:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:64:0x02be  */
    /* JADX WARN: Code duplicated, block: B:67:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:76:0x03e2 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #0 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x0058, B:16:0x0072, B:18:0x0086, B:20:0x009a, B:22:0x00ae, B:26:0x00ca, B:28:0x0127, B:35:0x014a, B:36:0x0157, B:40:0x0165, B:42:0x017f, B:47:0x01d4, B:52:0x023c, B:56:0x029b, B:61:0x02ae, B:65:0x02bf, B:68:0x02da, B:70:0x0396, B:73:0x03a7, B:74:0x03c5, B:76:0x03e2, B:60:0x02aa, B:55:0x0295), top: B:82:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:78:0x03e7  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x017f, please report this as an issue */
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
    public boolean E1() {
        String str;
        double dIc;
        String str2;
        double d;
        String str3;
        long jL2;
        String str4;
        Object objValueOf;
        int i;
        Object objValueOf2;
        String string;
        long j;
        String string2;
        String string3;
        try {
            C2160f10.h = MO.b(this);
            boolean zA = AbstractC4371yX.a(this.y1);
            if (!AbstractC4371yX.a(this.A1)) {
                zA = false;
            }
            if (this.w1.getText().toString().trim().length() == 0 && this.x1.getText().toString().trim().length() == 0) {
                AbstractC4371yX.a(this.w1);
                AbstractC4371yX.a(this.x1);
                zA = false;
            }
            double d2 = this.w1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.w1.getText().toString().replaceAll(",", "")) : 0.0d;
            double d3 = this.x1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.x1.getText().toString().replaceAll(",", "")) : 0.0d;
            double d4 = Double.parseDouble(this.y1.getText().toString().replaceAll(",", ""));
            if (d2 > 0.0d && d3 > 0.0d) {
                str2 = "";
                String strS7 = this.i.S7(this.w1.getText().toString().replaceAll(",", str2));
                Z00 z00 = this.i;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                dIc = d2;
                str = "'";
                sb.append(Double.parseDouble(this.x1.getText().toString().replaceAll(",", str2)) / Double.parseDouble(this.y1.getText().toString().replaceAll(",", str2)));
                if (!strS7.equals(z00.S7(sb.toString()))) {
                    this.x1.setError(getString(info.aalmoghalis.inventory.R.string.total_not_correct));
                    d = 0.0d;
                    zA = false;
                }
                if (d3 >= d && d4 > d) {
                    dIc = this.i.Ic(String.valueOf(d3 / d4));
                }
                if (this.A1.getText().length() == 0) {
                    return false;
                }
                this.R1 = true;
                if (this.i.v8(this.A1.getText().toString(), 2).getCount() == 0) {
                    AutoCompleteTextView autoCompleteTextView = this.A1;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                    this.R1 = false;
                    str3 = str2;
                    V0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.A1.getText().toString(), this, this.A1.getText().toString(), 2);
                    if (!this.R1) {
                        zA = false;
                    }
                } else {
                    str3 = str2;
                }
                if (zA) {
                    return zA;
                }
                jL2 = this.i.l2();
                long jM2 = this.i.m2(21, this.S.isChecked() ? 1 : 0, this.l);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("insert into bills (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,user_id,id2) values(");
                sb2.append(jL2);
                sb2.append(",");
                sb2.append(21);
                sb2.append(",'");
                sb2.append(this.W.getText().toString());
                sb2.append("','");
                sb2.append(String.valueOf(dIc * d4));
                sb2.append("','0',(select id from customers where name='");
                sb2.append((Object) this.A1.getText());
                sb2.append("'  ),2,");
                if (this.V1.isChecked()) {
                    str4 = "1";
                } else {
                    str4 = "2";
                }
                sb2.append(str4);
                sb2.append(",'");
                sb2.append(jM2);
                sb2.append("','',(select id from currency where name='");
                sb2.append(this.p0.getText().toString());
                sb2.append("') ,(select id from branches where name='");
                sb2.append(this.V.getText().toString());
                sb2.append("'),(select id from customers where name='");
                sb2.append(this.q0.getText().toString());
                sb2.append("'),");
                sb2.append(this.S.isChecked() ? 1 : 0);
                sb2.append(",");
                if (this.S.isChecked()) {
                    objValueOf = Long.valueOf(this.b1);
                } else {
                    objValueOf = "0";
                }
                sb2.append(objValueOf);
                sb2.append(",");
                i = C2160f10.h;
                if (i == -1) {
                    objValueOf2 = "null";
                } else {
                    objValueOf2 = Integer.valueOf(i);
                }
                sb2.append(objValueOf2);
                sb2.append(",");
                string = "null";
                j = this.p;
                if (j != 0) {
                    j = jL2;
                }
                sb2.append(j);
                sb2.append(")");
                string2 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.V1.isChecked() ? "1" : "2");
                sb3.append("#");
                sb3.append(this.V1.isChecked());
                Log.d("item_status=", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,unit_id,u_val,base_unit,qty_pr,e_date) values ( ");
                sb4.append(jL2);
                sb4.append(",(select id from items a where a.name='");
                sb4.append((Object) this.z1.getText());
                sb4.append("'),(select item_type_id from items a where a.name='");
                sb4.append((Object) this.z1.getText());
                sb4.append("'),'");
                sb4.append(this.y1.getText().toString().replaceAll(",", str3));
                sb4.append("','");
                sb4.append(this.y1.getText().toString().replaceAll(",", str3));
                sb4.append("','");
                sb4.append(String.valueOf(dIc));
                sb4.append("',(select id from currency where name='");
                sb4.append(this.p0.getText().toString());
                sb4.append("') ,0,(select b.unit_id from items a,unit_item b  where a.id=b.item_id and a.name='");
                sb4.append(this.z1.getText().toString());
                sb4.append("'),1,(select unit_id from items where name='");
                sb4.append(this.z1.getText().toString());
                sb4.append("'),");
                sb4.append(d4);
                sb4.append(",");
                if (this.y1.getTag() != null && this.y1.getTag().toString().length() != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    String str5 = str;
                    sb5.append(str5);
                    sb5.append(this.y1.getTag().toString());
                    sb5.append(str5);
                    string = sb5.toString();
                }
                sb4.append(string);
                sb4.append(")");
                string3 = sb4.toString();
                Log.d("sql1=", string2);
                Log.d("sql2=", string3);
                if (this.i.H(string2, string3) == 1) {
                    G1();
                    return true;
                }
                return false;
            }
            str = "'";
            dIc = d2;
            str2 = "";
            d = 0.0d;
            if (d3 >= d) {
                dIc = this.i.Ic(String.valueOf(d3 / d4));
            }
            if (this.A1.getText().length() == 0) {
                return false;
            }
            this.R1 = true;
            if (this.i.v8(this.A1.getText().toString(), 2).getCount() == 0) {
                AutoCompleteTextView autoCompleteTextView2 = this.A1;
                autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                this.R1 = false;
                str3 = str2;
                V0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.A1.getText().toString(), this, this.A1.getText().toString(), 2);
                if (!this.R1) {
                    zA = false;
                }
            } else {
                str3 = str2;
            }
            if (zA) {
                return zA;
            }
            jL2 = this.i.l2();
            long jM3 = this.i.m2(21, this.S.isChecked() ? 1 : 0, this.l);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("insert into bills (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,user_id,id2) values(");
            sb6.append(jL2);
            sb6.append(",");
            sb6.append(21);
            sb6.append(",'");
            sb6.append(this.W.getText().toString());
            sb6.append("','");
            sb6.append(String.valueOf(dIc * d4));
            sb6.append("','0',(select id from customers where name='");
            sb6.append((Object) this.A1.getText());
            sb6.append("'  ),2,");
            if (this.V1.isChecked()) {
                str4 = "1";
            } else {
                str4 = "2";
            }
            sb6.append(str4);
            sb6.append(",'");
            sb6.append(jM3);
            sb6.append("','',(select id from currency where name='");
            sb6.append(this.p0.getText().toString());
            sb6.append("') ,(select id from branches where name='");
            sb6.append(this.V.getText().toString());
            sb6.append("'),(select id from customers where name='");
            sb6.append(this.q0.getText().toString());
            sb6.append("'),");
            sb6.append(this.S.isChecked() ? 1 : 0);
            sb6.append(",");
            if (this.S.isChecked()) {
                objValueOf = "0";
            } else {
                objValueOf = Long.valueOf(this.b1);
            }
            sb6.append(objValueOf);
            sb6.append(",");
            i = C2160f10.h;
            if (i == -1) {
                objValueOf2 = "null";
            } else {
                objValueOf2 = Integer.valueOf(i);
            }
            sb6.append(objValueOf2);
            sb6.append(",");
            string = "null";
            j = this.p;
            if (j != 0) {
                j = jL2;
            }
            sb6.append(j);
            sb6.append(")");
            string2 = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.V1.isChecked() ? "1" : "2");
            sb7.append("#");
            sb7.append(this.V1.isChecked());
            Log.d("item_status=", sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,unit_id,u_val,base_unit,qty_pr,e_date) values ( ");
            sb8.append(jL2);
            sb8.append(",(select id from items a where a.name='");
            sb8.append((Object) this.z1.getText());
            sb8.append("'),(select item_type_id from items a where a.name='");
            sb8.append((Object) this.z1.getText());
            sb8.append("'),'");
            sb8.append(this.y1.getText().toString().replaceAll(",", str3));
            sb8.append("','");
            sb8.append(this.y1.getText().toString().replaceAll(",", str3));
            sb8.append("','");
            sb8.append(String.valueOf(dIc));
            sb8.append("',(select id from currency where name='");
            sb8.append(this.p0.getText().toString());
            sb8.append("') ,0,(select b.unit_id from items a,unit_item b  where a.id=b.item_id and a.name='");
            sb8.append(this.z1.getText().toString());
            sb8.append("'),1,(select unit_id from items where name='");
            sb8.append(this.z1.getText().toString());
            sb8.append("'),");
            sb8.append(d4);
            sb8.append(",");
            if (this.y1.getTag() != null) {
                StringBuilder sb9 = new StringBuilder();
                String str6 = str;
                sb9.append(str6);
                sb9.append(this.y1.getTag().toString());
                sb9.append(str6);
                string = sb9.toString();
            }
            sb8.append(string);
            sb8.append(")");
            string3 = sb8.toString();
            Log.d("sql1=", string2);
            Log.d("sql2=", string3);
            if (this.i.H(string2, string3) == 1) {
                G1();
                return true;
            }
        } catch (Exception e) {
            Log.d("purchase_item_error=", e.getMessage());
        }
        return false;
    }

    public void F0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new K1(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(info.aalmoghalis.inventory.R.string.pref_item_type));
        dialog.show();
    }

    public void F1() {
        if (getIntent().getStringExtra("TR_ID") == null) {
            this.L = false;
            return;
        }
        Log.d("read_bill=", getIntent().getStringExtra("TR_ID") + ":" + getIntent().getStringExtra("is_back") + ":" + getIntent().getStringExtra("b_bill_id"));
        if (!getIntent().getStringExtra("is_back").equals("0") && getIntent().getStringExtra("b_bill_id").equals("0")) {
            this.L = false;
        } else {
            this.L = true;
        }
        if (getIntent().getStringExtra("TR_DATE") != null) {
            this.q = getIntent().getStringExtra("TR_DATE");
        }
    }

    public void G0(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new L1(textView, arrayAdapter, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
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
    public void G1() {
        if (this.p == 0) {
            EditText editText = this.y0;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(info.aalmoghalis.inventory.R.string.bill_no2));
            Z00 z00 = this.i;
            int i = this.t;
            boolean zIsChecked = this.S.isChecked();
            sb.append(z00.m2(i, zIsChecked ? 1 : 0, this.i.D2(this.V.getText().toString())));
            editText.setHint(sb.toString());
        }
    }

    public void H0(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new N1(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
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
    public void H1() {
        EditText editText = this.y0;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(info.aalmoghalis.inventory.R.string.bill_no2));
        Z00 z00 = this.i;
        int i = this.t;
        boolean zIsChecked = this.S.isChecked();
        sb.append(z00.m2(i, zIsChecked ? 1 : 0, this.i.D2(this.V.getText().toString())));
        editText.setHint(sb.toString());
    }

    public void I0(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new M1(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void I1() {
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.t = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.l = getIntent().getStringExtra("g_id");
                this.n = getIntent().getStringExtra("g_name");
                String[] stringArray = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills);
                int i = this.t;
                char c = 7;
                setTitle(stringArray[(i == 21 || i == 211) ? (char) 7 : '\b']);
                String[] stringArray2 = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills);
                int i2 = this.t;
                if (i2 != 21 && i2 != 211) {
                    c = '\b';
                }
                this.N0 = stringArray2[c];
                if (getIntent().getStringExtra("bill_offer_id") == null) {
                    this.i.z0("delete from items_temp");
                }
                TextView textView = this.V;
                Z00 z00 = this.i;
                String str = this.l;
                if (str == null) {
                    str = "0";
                }
                textView.setText(z00.C2(str));
                int i3 = this.t;
                if (i3 == 21) {
                    TextView textView2 = this.b0;
                }
                if (i3 == 21) {
                    this.R0.setVisibility(0);
                } else {
                    this.R0.setVisibility(8);
                }
                if (this.t == 11 && this.i.ja("prefOthers_sales_tax", false)) {
                    this.j0.setVisibility(8);
                    if (this.p == 0) {
                        this.d0.setText("0");
                    }
                }
                if (this.t == 21 && this.i.ja("prefOthers_purchases_tax", false)) {
                    this.j0.setVisibility(8);
                    if (this.p == 0) {
                        this.d0.setText("0");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void J0() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.F0(this);
            }
            u0();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void J1(String str) {
        AutoCompleteTextView autoCompleteTextView;
        if (!str.equals("") && this.i.da(str)) {
            String strI6 = this.i.I6(str);
            Z00.P0 = false;
            if (strI6.equals("")) {
                try {
                    this.i.j1(str, this, this.B0);
                } catch (Exception unused) {
                }
            }
            if (!strI6.equals("") || Z00.P0) {
                if (Z00.P0) {
                    strI6 = this.i.I6(str);
                }
                if (this.B1 == 2 || ((autoCompleteTextView = this.v1) != null && autoCompleteTextView.hasWindowFocus())) {
                    r1(strI6);
                } else {
                    q1(strI6);
                }
                if (this.q1 != null) {
                    Log.d("focus=", this.q1.hasWindowFocus() + ":" + this.t1.hasWindowFocus());
                }
                this.B1 = 0;
            }
        }
    }

    public void K0() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        if (this.B2 != 0) {
            L0();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_back_back));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new K());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new L());
        builder.create().show();
    }

    public void K1() {
        Log.d("back_edit=", this.J + ":" + this.K);
        if (this.J == 1) {
            D2 = true;
            E2 = true;
            F2 = this.X.getText().toString();
            finish();
            return;
        }
        int i = this.t;
        if (i == 11) {
            D2 = false;
            Intent intent = new Intent(this, (Class<?>) Adj2.class);
            intent.addFlags(67141632);
            intent.addFlags(1073741824);
            intent.putExtra("TR_TYPE", "11");
            intent.putExtra("g_id", this.l);
            intent.putExtra("g_name", this.n);
            startActivity(intent);
            finish();
            return;
        }
        if (i == 21) {
            D2 = false;
            Intent intent2 = new Intent(this, (Class<?>) Adj2.class);
            intent2.addFlags(67141632);
            intent2.addFlags(1073741824);
            intent2.putExtra("TR_TYPE", "21");
            intent2.putExtra("g_id", this.l);
            intent2.putExtra("g_name", this.n);
            startActivity(intent2);
            finish();
        }
    }

    public void L0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_save));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new M());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new N());
        builder.create().show();
    }

    public void L1() {
        try {
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,ifnull(e_date,'')   from bill_transactions_v  where bill_id=" + this.p + " and bill_date='" + this.q + "' ");
        } catch (Exception unused) {
        }
    }

    public void M1() {
        this.v1.setText((CharSequence) null);
        this.t1.setText((CharSequence) null);
        this.q1.setText((CharSequence) null);
        this.r1.setText((CharSequence) null);
        this.s1.setText((CharSequence) null);
        this.v1.requestFocus();
        this.I = "0";
    }

    public void N0() {
        ((TextView) findViewById(info.aalmoghalis.inventory.R.id.item_price)).setText(getString(info.aalmoghalis.inventory.R.string.o_cost));
        ArrayList arrayListG6 = this.i.G6();
        C2160f10.c0(this, this.p1, arrayListG6, 1);
        C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
        this.B0 = c1098Yv;
        c1098Yv.l.clear();
        this.B0.notifyDataSetChanged();
        this.p1.setThreshold(1);
        this.p1.setAdapter(this.B0);
        this.p1.setOnItemClickListener(new C2543p0());
        this.p1.setOnTouchListener(new ViewOnTouchListenerC2546q0());
        this.p1.addTextChangedListener(new C2549r0());
    }

    public void O0() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        for (int size = this.E0.size() - 1; size >= 0; size--) {
            if (this.E0.valueAt(size)) {
                C0634Jt item = this.A0.getItem(this.E0.keyAt(size));
                this.A0.remove(item);
                this.i.v0("delete from items_temp where no_='" + item.f() + "'");
                n2(this.p, "0");
            }
        }
        this.i1 = 1;
        a1();
        v1();
        this.i1 = 1;
        a1();
        W1(false);
    }

    public void P1() {
        f1(this.X.getText().toString());
        E00 e00 = this.j;
        e00.m = this.p;
        e00.k = this.k;
        e00.n = this.T.getText().toString();
        this.j.o = this.p0.getText().toString();
    }

    public boolean Q0() {
        String str;
        boolean z;
        double d;
        double d2;
        double d3;
        double dIc;
        boolean z2;
        double d4;
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return false;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        }
        try {
            boolean zA = AbstractC4371yX.a(this.t1);
            try {
                if (!AbstractC4371yX.a(this.v1)) {
                    zA = false;
                }
                if (this.q1.getText().toString().trim().length() == 0) {
                    try {
                        if (this.r1.getText().toString().trim().length() == 0) {
                            AbstractC4371yX.a(this.q1);
                            AbstractC4371yX.a(this.r1);
                            zA = false;
                        }
                    } catch (Exception e) {
                        e = e;
                        z = zA;
                        str = "";
                        Log.d("edit_item_error=", e.getMessage() + str);
                        e.printStackTrace();
                        return z;
                    }
                }
                try {
                    double d5 = this.q1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.q1.getText().toString().replaceAll(",", "")) : 0.0d;
                    double d6 = this.r1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.r1.getText().toString().replaceAll(",", "")) : 0.0d;
                    if (this.t1.getText().toString().trim().length() > 0) {
                        double dB0 = Double.parseDouble(this.t1.getText().toString().replaceAll(",", ""));
                        double d7 = this.q1.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.q1.getTag().toString().replaceAll(",", "")) : 1.0d;
                        try {
                            if (this.i.ja("prefOthers_qty_pr", false)) {
                                dB0 = this.i.b0(this.t1.getText().toString().replaceAll(",", ""), d7);
                            }
                            d2 = d7;
                            d = dB0;
                        } catch (Exception e2) {
                            e = e2;
                            str = "";
                            z = zA;
                            Log.d("edit_item_error=", e.getMessage() + str);
                            e.printStackTrace();
                            return z;
                        }
                    } else {
                        zA = zA;
                        d = 0.0d;
                        d2 = 1.0d;
                    }
                    if (d5 <= 0.0d || d6 <= 0.0d) {
                        d3 = 0.0d;
                    } else {
                        String strS7 = this.i.S7(this.q1.getText().toString().replaceAll(",", ""));
                        Z00 z00 = this.i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        double d8 = d6;
                        sb.append(Double.parseDouble(this.r1.getText().toString().replaceAll(",", "")) / d);
                        if (strS7.equals(z00.S7(sb.toString()))) {
                            d6 = d8;
                            d3 = 0.0d;
                        } else {
                            EditText editText = this.r1;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(getString(info.aalmoghalis.inventory.R.string.total_not_correct));
                            sb2.append("#");
                            sb2.append(this.i.S7("" + (d5 * d)));
                            sb2.append("#");
                            d6 = d8;
                            sb2.append(d6);
                            editText.setError(sb2.toString());
                            d3 = 0.0d;
                            zA = false;
                        }
                    }
                    if (d6 < d3 || d <= d3) {
                        dIc = 0.0d;
                    } else {
                        double d9 = d6 / d;
                        this.i.Ic(String.valueOf(d9));
                        dIc = this.i.Ic(String.valueOf(d9 / d2));
                    }
                    if (this.v1.getText().length() == 0) {
                        return false;
                    }
                    if (this.i.F6().contains(this.v1.getText().toString()) || this.i.F6().contains(this.v1.getText().toString().trim())) {
                        z2 = true;
                    } else {
                        AutoCompleteTextView autoCompleteTextView = this.v1;
                        autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                        this.k1 = this.v1.getText().toString();
                        W0(getString(info.aalmoghalis.inventory.R.string.validation_add_item), getString(info.aalmoghalis.inventory.R.string.validation_add_item) + this.k1, this);
                        ArrayList arrayListG6 = this.i.G6();
                        C2160f10.c0(this, this.v1, arrayListG6, 2);
                        C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
                        this.B0 = c1098Yv;
                        c1098Yv.l.clear();
                        this.B0.notifyDataSetChanged();
                        this.v1.setAdapter(this.B0);
                        this.q1.setTag("1");
                        this.D1.setVisibility(8);
                        this.D1.setText(this.i.X6(this.v1.getText().toString()));
                        this.u1.setText("");
                        n2(this.p, "-1");
                        z2 = false;
                        d2 = 1.0d;
                    }
                    if (!z2 && !this.R1) {
                        return false;
                    }
                    if (!this.v1.getText().toString().equals(this.v1.getText().toString().trim()) && this.i.F6().contains(this.v1.getText().toString().trim())) {
                        AutoCompleteTextView autoCompleteTextView2 = this.v1;
                        autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                    }
                    this.i.D = false;
                    String str2 = "0";
                    if (this.p0.getText() != null && !this.p0.getText().toString().equals(this.i.l3("0")) && this.i.Z2(this.p0.getText().toString(), this.T.getText().toString()) == 0) {
                        this.i.u(this, this.p0.getText().toString(), this.T.getText().toString(), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                        if (!this.i.D) {
                            return false;
                        }
                    }
                    if (this.t == 11) {
                        double dG1 = g1(this.p, this.I);
                        if (this.i.ja("prefOthers_item_end_date", false)) {
                            double dH1 = h1(this.p, this.I, this.u1.getText().toString());
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.p);
                            sb3.append(":");
                            sb3.append(this.I);
                            sb3.append(":");
                            d4 = dG1;
                            sb3.append(d4);
                            sb3.append(":");
                            sb3.append(dH1);
                            sb3.append(":");
                            str = "";
                            try {
                                sb3.append(d * d2);
                                Log.d("item_qty=", sb3.toString());
                                if (dH1 >= 0.0d && dH1 <= d4) {
                                    d4 = dH1;
                                } else if (dH1 < 0.0d) {
                                    d4 = 0.0d;
                                }
                                this.l1 = this.u1.getText().toString();
                            } catch (Exception e3) {
                                e = e3;
                                z = zA;
                                Log.d("edit_item_error=", e.getMessage() + str);
                                e.printStackTrace();
                                return z;
                            }
                        } else {
                            d4 = dG1;
                            str = "";
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(this.p);
                        sb4.append(":");
                        sb4.append(this.I);
                        sb4.append(":");
                        sb4.append(d4);
                        sb4.append(":");
                        double d10 = d * d2;
                        sb4.append(d10);
                        Log.d("item_qty=", sb4.toString());
                        if (d4 - C1839c10.C(d10, C1839c10.d) < 0.0d && this.t == 11 && !this.S.isChecked() && !this.i.ja("prefOthers_sales_out_qty", false)) {
                            this.R1 = false;
                            this.k1 = C1839c10.v(String.valueOf(C1839c10.C(d10, C1839c10.d) - d4), C1839c10.d);
                            Y0(getString(info.aalmoghalis.inventory.R.string.validation_add_purchase), getString(info.aalmoghalis.inventory.R.string.validation_add_purchase) + " " + this.k1, this, this.v1.getText().toString(), this.k1, this.l1);
                            i2();
                            return false;
                        }
                        if (C2 != 2 && this.i.q7(this.v1.getText().toString()) > 0) {
                            this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                    } else {
                        dIc = dIc;
                        str = "";
                        str2 = "0";
                    }
                    if (!zA) {
                        return zA;
                    }
                    Log.d("edit_item=", ((Object) this.z0.getText()) + str);
                    String str3 = "''";
                    if (C2 == 2) {
                        if (this.p != 0) {
                            b2();
                        }
                        Z00 z01 = this.i;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("update items_temp set item_id=(select id from items a where a.name='");
                        sb5.append((Object) this.v1.getText());
                        sb5.append("'),item_type_id=(select item_type_id from items a where a.name='");
                        sb5.append((Object) this.v1.getText());
                        sb5.append("'),qty='");
                        sb5.append(this.t1.getText().toString().replaceAll(",", str));
                        sb5.append("',qty_t='");
                        sb5.append(this.t1.getText().toString().replaceAll(",", str));
                        sb5.append("',price='");
                        sb5.append(String.valueOf(dIc));
                        sb5.append("',unit_id=ifnull((select id from units where code='");
                        sb5.append(this.D1.getText().toString());
                        sb5.append("'),0),u_val='");
                        sb5.append(String.valueOf(d2));
                        sb5.append("',qty_pr=");
                        sb5.append(d);
                        sb5.append(",curr_id=(select id from currency where name='");
                        sb5.append(this.p0.getText().toString());
                        sb5.append("') ,remark='");
                        sb5.append(this.s1.getText().toString());
                        sb5.append("',e_date=");
                        TextView textView = this.u1;
                        if (textView != null && textView.getText().toString().length() != 0) {
                            str3 = "'" + this.u1.getText().toString() + "'";
                        }
                        sb5.append(str3);
                        sb5.append(" where no_='");
                        sb5.append(this.I);
                        sb5.append("'");
                        z01.v0(sb5.toString());
                        f2();
                    } else {
                        if (this.p != 0) {
                            b2();
                        }
                        Z00 z02 = this.i;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                        sb6.append((Object) this.v1.getText());
                        sb6.append("'),(select item_type_id from items a where a.name='");
                        sb6.append((Object) this.v1.getText());
                        sb6.append("'),'");
                        sb6.append(this.t1.getText().toString().replaceAll(",", str));
                        sb6.append("','");
                        sb6.append(this.t1.getText().toString().replaceAll(",", str));
                        sb6.append("','");
                        sb6.append(String.valueOf(dIc));
                        sb6.append("',(select id from currency where name='");
                        sb6.append(this.p0.getText().toString());
                        sb6.append("'),'");
                        sb6.append(this.s1.getText().toString());
                        sb6.append("',ifnull((select id from units where code='");
                        sb6.append(this.D1.getText().toString());
                        sb6.append("'),0),'");
                        sb6.append(String.valueOf(d2));
                        sb6.append("',(select unit_id from items where name='");
                        sb6.append(this.v1.getText().toString());
                        sb6.append("'),");
                        sb6.append(d);
                        sb6.append(",");
                        TextView textView2 = this.u1;
                        if (textView2 != null && textView2.getText().toString().length() != 0) {
                            str3 = "'" + this.u1.getText().toString() + "'";
                        }
                        sb6.append(str3);
                        sb6.append(" )");
                        z02.v0(sb6.toString());
                        f2();
                        if (this.p == 0) {
                            a1();
                            v1();
                        }
                    }
                    this.p1.setText(str);
                    N0();
                    this.i1 = 1;
                    a1();
                    v1();
                    this.i1 = 1;
                    a1();
                    n2(this.p, str2);
                    return zA;
                } catch (Exception e4) {
                    e = e4;
                    zA = zA;
                }
            } catch (Exception e5) {
                e = e5;
                str = "";
                z = zA;
            }
        } catch (Exception e6) {
            e = e6;
            str = "";
            z = true;
        }
    }

    public void Q1() {
        Log.d("bill_tax=", "set_bill_total:" + this.d0.getText().toString() + ":" + this.Y.getText().toString());
        double d = Double.parseDouble(this.d0.getText().toString());
        double d2 = Double.parseDouble(this.c0.getText().toString().replaceAll(",", ""));
        double d3 = Double.parseDouble(this.Y.getText().toString().replaceAll(",", ""));
        double d4 = (d * d3) / 100.0d;
        double d5 = d3 + d4 + d2;
        this.e0.setText(this.i.P7(d4 + ""));
        this.g0.setText(this.i.P7(d5 + ""));
        this.c0.setText(this.i.P7(d2 + ""));
        this.h0.setVisibility(0);
        this.g0.setVisibility(0);
        if (!this.d0.getText().toString().equals("0") && !this.c0.getText().toString().replaceAll(",", "").equals("0") && this.p != 0) {
            this.e0.setVisibility(0);
            this.f0.setVisibility(0);
            this.h0.setVisibility(0);
            this.g0.setVisibility(0);
            this.j0.setVisibility(0);
        } else if (this.p == 0 || (this.d0.getText().toString().equals("0") && this.c0.getText().toString().replaceAll(",", "").equals("0"))) {
            this.e0.setVisibility(4);
            this.h0.setVisibility(4);
            this.f0.setVisibility(4);
            this.g0.setVisibility(4);
        } else if (this.d0.getText().toString().equals("0")) {
            this.e0.setVisibility(4);
            this.f0.setVisibility(4);
        }
        if (this.d0.getText().toString().equals("0")) {
            return;
        }
        this.e0.setVisibility(0);
        this.f0.setVisibility(0);
        this.j0.setVisibility(0);
    }

    public void R0(Cursor cursor) {
        String string;
        int count = cursor.getCount();
        Log.d("Cursor_cnt=", String.valueOf(count) + ":" + this.p);
        W1(false);
        this.K1 = 0;
        this.L1 = 0.0d;
        this.M1 = 0.0d;
        this.N1 = 0.0d;
        this.C0.clear();
        cursor.moveToFirst();
        double d = 0.0d;
        int i = 0;
        while (true) {
            string = "";
            if (cursor.isAfterLast()) {
                break;
            }
            i++;
            this.C0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("item_name")), cursor.getString(cursor.getColumnIndex("item_type")), this.i.S7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("item_total")))), this.i.T7("" + cursor.getDouble(cursor.getColumnIndex("qty_t"))), this.i.S7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("item_price")))), cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tran_status")), cursor.getString(cursor.getColumnIndex("item_remarks")), cursor.getString(cursor.getColumnIndex("unit_name")), cursor.getString(cursor.getColumnIndex("unit_val")), cursor.getString(cursor.getColumnIndex("qty_pr")), cursor.getString(cursor.getColumnIndex("barcode")), cursor.getString(cursor.getColumnIndex("e_date"))));
            d += cursor.getDouble(cursor.getColumnIndex("item_price")) * cursor.getDouble(cursor.getColumnIndex("qty_pr"));
            long j = this.p;
            if (j != 0 && i == count) {
                this.x0.setText(cursor.getString(cursor.getColumnIndex("bill_type")));
                this.t = cursor.getInt(cursor.getColumnIndex("tr_type_id"));
                String string2 = cursor.getString(cursor.getColumnIndex("curr_name"));
                this.y = string2;
                this.p0.setText(string2);
                this.V.setText(cursor.getString(cursor.getColumnIndex("br_name")));
                int i2 = cursor.getInt(cursor.getColumnIndex("is_back"));
                if (i2 == 1) {
                    this.c1 = -1L;
                    this.b1 = cursor.getInt(cursor.getColumnIndex("bill_no"));
                    this.S.setChecked(i2 != 0);
                    if (this.b1 != 0) {
                        this.S.setEnabled(false);
                    }
                } else {
                    this.S.setChecked(i2 != 0);
                }
                if (cursor.getString(cursor.getColumnIndex("bill_type_id")).equals("1")) {
                    this.R.setChecked(true);
                    this.B2 = 0;
                    m2();
                    b1();
                } else {
                    this.R.setChecked(false);
                    this.B2 = 0;
                    m2();
                    b1();
                }
                this.X.setText(cursor.getString(cursor.getColumnIndex("tr_name")));
                this.X.dismissDropDown();
                this.T.setText(cursor.getString(cursor.getColumnIndex("date_")));
                this.i.nd(this.y0, cursor.getString(cursor.getColumnIndex("bill_no2")));
                this.q0.setText(cursor.getString(cursor.getColumnIndex("cash_name")));
                this.i.nd(this.z0, cursor.getString(cursor.getColumnIndex("remarks")));
                this.M1 = cursor.getDouble(cursor.getColumnIndex("t_val"));
                this.N1 = cursor.getDouble(cursor.getColumnIndex("tax_amount"));
                this.P1 = cursor.getDouble(cursor.getColumnIndex("cost2"));
                this.Q1 = cursor.getInt(cursor.getColumnIndex("cost_id"));
                this.I1 = (cursor.getDouble(cursor.getColumnIndex("amount")) - this.N1) - this.P1;
                this.J1 = cursor.getDouble(cursor.getColumnIndex("d_amount"));
                this.K1 = cursor.getInt(cursor.getColumnIndex("discount_id"));
                double d2 = cursor.getDouble(cursor.getColumnIndex("d_val"));
                this.L1 = d2;
                if (this.K1 == 0 && d2 == 0.0d) {
                    double d3 = this.J1;
                    if (d3 != 0.0d) {
                        this.L1 = d3;
                    }
                }
                if (cursor.getString(cursor.getColumnIndex("tran_status")).equals("3")) {
                    this.t0.setVisibility(4);
                }
                ImageView imageView = this.R0;
                if (imageView != null) {
                    imageView.setTag(cursor.getString(cursor.getColumnIndex("param1")) != null ? cursor.getString(cursor.getColumnIndex("param1")) : "");
                    if (this.R0.getTag().toString().equals("")) {
                        N1(this.R0);
                    } else {
                        S1(this.R0.getTag().toString());
                    }
                }
            } else if (j == 0 && getIntent().getStringExtra("bill_offer_id") != null) {
                String stringExtra = getIntent().getStringExtra("curr_name");
                this.y = stringExtra;
                this.p0.setText(stringExtra);
                this.V.setText(getIntent().getStringExtra("tr_branch"));
                this.X.setText(getIntent().getStringExtra("tr_name"));
                this.X.dismissDropDown();
                this.K1 = getIntent().getIntExtra("bill_disc_id", 0);
                this.L1 = getIntent().getDoubleExtra("bill_disc_val", 0.0d);
                this.I1 = Double.parseDouble(getIntent().getStringExtra("bill_total_"));
                this.J1 = Double.parseDouble(getIntent().getStringExtra("bill_total_disc"));
            }
            cursor.moveToNext();
        }
        cursor.close();
        double d4 = this.I1;
        if ((d4 == 0.0d && this.J1 == 0.0d) || this.i1 == 1) {
            this.Y.setText(this.i.P7(String.valueOf(d)));
            this.a0.setText("0");
            this.c0.setText("0");
            this.i1 = 0;
            Q1();
        } else {
            this.Y.setText(this.i.P7(String.valueOf(d4)));
            this.a0.setText(this.i.P7(String.valueOf(this.J1)));
            this.d0.setText(this.i.P7(String.valueOf(this.M1)));
            this.e0.setText(this.i.P7(String.valueOf(this.N1)));
            this.g0.setText(this.i.P7(String.valueOf(this.I1 + this.N1 + this.P1)));
            this.c0.setText(this.i.P7(String.valueOf(this.P1)));
            Q1();
        }
        this.Z.setText(this.C0.size() + "");
        if (this.Z.getText().toString().equals("0")) {
            this.Z.setText("");
        }
        NumberFormat.getInstance(Locale.ENGLISH).format(0.0d);
        C0809Ov c0809Ov = new C0809Ov(this, info.aalmoghalis.inventory.R.layout.bill_item_det_row3, this.C0);
        this.A0 = c0809Ov;
        c0809Ov.j.clear();
        this.A0.notifyDataSetChanged();
        this.P.setAdapter((ListAdapter) this.A0);
        if (this.p == 0) {
            this.B2 = 1;
        } else {
            this.B2 = 0;
        }
        invalidateOptionsMenu();
        SearchView searchView = this.b2;
        if (searchView != null && searchView.getQuery() != null) {
            string = this.b2.getQuery().toString();
        }
        if (string.length() > 0) {
            this.A0.getFilter().filter(string, new C2562x());
        }
    }

    public void R1() {
        this.E1.setOnClickListener(new ViewOnClickListenerC2555t0());
        this.G1.setOnClickListener(new ViewOnClickListenerC2557u0());
        this.H1.setOnClickListener(new ViewOnClickListenerC2559v0());
        this.C1.setOnClickListener(new ViewOnClickListenerC2561w0());
        this.t1.addTextChangedListener(this.Y0);
        this.q1.addTextChangedListener(this.Y0);
        this.r1.addTextChangedListener(this.Y0);
        this.t1.setOnTouchListener(new ViewOnTouchListenerC2563x0());
        this.q1.setOnTouchListener(new ViewOnTouchListenerC2565y0());
        this.r1.setOnTouchListener(new ViewOnTouchListenerC2567z0());
    }

    public void S1(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            this.R0.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
            this.R0.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
            this.R0.setImageBitmap(bitmapP0);
            this.R0.setTag(str);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String T0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public void T1() {
        this.V1.setOnCheckedChangeListener(new A0());
        this.S1.setOnClickListener(new B0());
        this.T1.setOnClickListener(new C0());
        Calendar calendar = Calendar.getInstance();
        this.W.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.M = calendar.get(1);
        this.N = calendar.get(2);
        this.O = calendar.get(5);
        this.W.setOnClickListener(new E0());
        this.y1.addTextChangedListener(this.Z0);
        this.w1.addTextChangedListener(this.Z0);
        this.x1.addTextChangedListener(this.Z0);
        this.y1.setOnTouchListener(new F0());
        this.w1.setOnTouchListener(new G0());
        this.x1.setOnTouchListener(new H0());
    }

    public String U0(Context context, Uri uri) {
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
                        return T0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
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
                        return T0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return T0(context, uri, null, null);
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

    public void U1() {
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
        listView.setOnItemClickListener(new C2525j0(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        listView.setDividerHeight(0);
        linearLayout.addView(listView, -1, -1);
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public boolean V0(String str, String str2, Context context, String str3, int i) {
        t1 t1Var = new t1();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new u1(t1Var, str3, i));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new w1(t1Var));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.R1;
    }

    public void V1() {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        this.c = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_share_bill2);
        this.d = getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons_share_bill2);
        ListView listView = new ListView(this);
        this.t2 = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = this.c;
            if (i >= strArr.length) {
                this.d.recycle();
                C4062ug c4062ug = new C4062ug(this, this.t2);
                this.u2 = c4062ug;
                listView.setAdapter((ListAdapter) c4062ug);
                listView.setOnItemClickListener(new C2507d0(dialog));
                linearLayout.setFocusable(true);
                listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                listView.setDividerHeight(0);
                linearLayout.addView(listView, -1, -1);
                dialog.requestWindowFeature(1);
                dialog.setContentView(linearLayout);
                dialog.show();
                return;
            }
            this.t2.add(new C3874sM(strArr[i], this.d.getResourceId(i, -1)));
            i++;
        }
    }

    public boolean W0(String str, String str2, Context context) {
        x1 x1Var = new x1();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new y1(x1Var));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new z1(x1Var));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.R1;
    }

    public void W1(boolean z) {
        this.R0.setOnClickListener(new C(z));
    }

    public boolean X0(String str, String str2, Context context) {
        HandlerC2533m handlerC2533m = new HandlerC2533m();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2536n(handlerC2533m));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2539o(handlerC2533m));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.Y1;
    }

    public void X1(int i) {
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
        AutoCompleteTextView autoCompleteTextView = this.X;
        if (autoCompleteTextView == null || autoCompleteTextView.getText().length() <= 0) {
            return;
        }
        double d = Double.parseDouble((String) this.i.X3(this.X.getText().toString(), this.p0.getText().toString()).get(0));
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
        sb.append(this.i.g3(this.p0.getText().toString()));
        String string = sb.toString();
        if (i != 0) {
            i2 = 1;
        }
        Toast.makeText(this, string, i2).show();
    }

    public boolean Y0(String str, String str2, Context context, String str3, String str4, String str5) {
        A1 a1 = new A1();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new B1(str3, str4, str5, a1));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new C1(a1));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.R1;
    }

    public boolean Z0(String str, String str2, Context context) {
        S s = new S();
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new T(s));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new U(s));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.X1;
    }

    public void Z1(String str) {
        if (C1839c10.k(this.i, this.k)) {
            try {
                w0();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.i.ja("prefAutoNotify", false)) {
            j1();
            return;
        }
        Snackbar snackbarMake = Snackbar.make(this.P, "", -2);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
        TextView textView = (TextView) snackbarLayout.findViewById(info.aalmoghalis.inventory.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, info.aalmoghalis.inventory.R.color.white));
        C4064uh c4064uhQ0 = this.i.Q0(str, this.p0.getText().toString(), this.p);
        StringBuilder sb = new StringBuilder();
        sb.append(c4064uhQ0.t() + (-20) == this.x2[0] ? this.i.Q2() : this.i.c5());
        sb.append(" ");
        sb.append(c4064uhQ0.n());
        sb.append(" ");
        sb.append(c4064uhQ0.r());
        snackbarMake.setText(sb.toString());
        snackbarMake.setAction(getString(info.aalmoghalis.inventory.R.string.hide_tr), new ViewOnClickListenerC2516g0(snackbarMake));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_share), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setOnClickListener(new ViewOnClickListenerC2519h0());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();
        layoutParams.gravity = 16;
        snackbarLayout.setLayoutParams(layoutParams);
        ViewCompat.setLayoutDirection(snackbarMake.getView(), 1);
        snackbarMake.show();
        new Handler().postDelayed(new RunnableC2522i0(snackbarMake), 5000);
    }

    public void a1() {
        try {
            Log.d("get_all_name=", "Yes:" + this.p + ":" + this.q);
            long j = this.p;
            if (j != 0) {
                R0(this.i.Z1(String.valueOf(j), this.q));
                ArrayList arrayListY1 = this.i.Y1(this.p + "");
                this.U0 = arrayListY1;
                if (arrayListY1 == null || arrayListY1.size() <= 0) {
                    this.U.setVisibility(8);
                } else {
                    this.U.setVisibility(0);
                }
            } else {
                R0(this.i.f2());
            }
        } catch (Exception e) {
            Log.d("Fetch_error=", e.getMessage());
        }
    }

    public void a2() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.i.J2(this, intent);
            this.n2 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.n2.getPath() + "");
            startActivityForResult(intent, this.j2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add_item(View view) {
        this.A = "";
        this.C = "";
        this.G = "";
        this.B = "";
        this.H = "";
        if (this.p1.getText() == null || this.p1.getText().toString().equals("")) {
            this.A = "";
            this.C = "";
            this.G = "";
            this.B = "";
            this.H = "";
        } else if (this.i.F6().contains(this.p1.getText().toString())) {
            double dC6 = this.i.C6(this.p1.getText().toString(), this.p0.getText().toString(), this.T.getText().toString());
            this.A = this.p1.getText().toString();
            this.C = dC6 > 0.0d ? this.i.S7(String.valueOf(dC6)) : "";
        } else {
            this.A = this.p1.getText().toString();
        }
        C2 = 1;
        q2();
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

    public void b1() {
        if (this.R.isChecked()) {
            this.x0.setText(getString(info.aalmoghalis.inventory.R.string.bill_cash));
        } else {
            this.x0.setText(getString(info.aalmoghalis.inventory.R.string.bill_post));
        }
        Cursor cursorI4 = this.i.I4();
        this.L0 = new String[cursorI4.getCount()];
        if (cursorI4.moveToFirst()) {
            int i = 0;
            do {
                this.L0[i] = cursorI4.getString(cursorI4.getColumnIndex("_id"));
                i++;
            } while (cursorI4.moveToNext());
        }
        cursorI4.close();
        this.F0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.L0);
        this.X.setThreshold(1);
        this.X.setAdapter(this.F0);
    }

    public void b2() {
        String string;
        String str;
        String str2;
        try {
            G1();
            int i = this.R.isChecked() ? 1 : 2;
            if (B0()) {
                if (this.i.v8(this.X.getText().toString(), this.t).getCount() == 0 && this.i.v8(this.X.getText().toString().trim(), this.t).getCount() == 0) {
                    AutoCompleteTextView autoCompleteTextView = this.X;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                    V0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.X.getText().toString(), this, this.X.getText().toString(), this.t);
                    if (!this.R1) {
                        return;
                    }
                }
                if (!this.X.getText().toString().equals(this.X.getText().toString().trim()) && this.i.v8(this.X.getText().toString().trim(), this.t).getCount() > 0) {
                    AutoCompleteTextView autoCompleteTextView2 = this.X;
                    autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                }
                if (this.i.v8(this.X.getText().toString(), this.t).getCount() == 0) {
                    this.X.setError("Not Inserted!");
                    return;
                }
                this.i.D = false;
                if (this.p0.getText() != null && !this.p0.getText().toString().equals(this.i.l3("0")) && this.i.Z2(this.p0.getText().toString(), this.T.getText().toString()) == 0) {
                    this.i.u(this, this.p0.getText().toString(), this.T.getText().toString(), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                    if (!this.i.D) {
                        return;
                    }
                }
                if (this.i.g2().getCount() == 0 || this.i.ja("prefOthers_closed_year", false)) {
                    return;
                }
                if (this.t != 21) {
                    string = "update bills set date_='" + ((Object) this.T.getText()) + "',amount='" + this.g0.getText().toString().replaceAll(",", "") + "',d_amount='" + this.a0.getText().toString().replaceAll(",", "") + "',t_val='" + this.d0.getText().toString().replaceAll(",", "") + "',tax_amount='" + this.e0.getText().toString().replaceAll(",", "") + "',cost2='" + this.c0.getText().toString().replaceAll(",", "") + "',cus_id=(select id from customers where name='" + ((Object) this.X.getText()) + "' ),br_id=(select id from branches where name='" + ((Object) this.V.getText()) + "' ),cash_id=(select id from customers where name='" + ((Object) this.q0.getText()) + "' ),bill_type=" + i + ",bill_no2='" + ((Object) this.y0.getText()) + "',is_back='" + (this.S.isChecked() ? 1 : 0) + "',remarks='" + ((Object) this.z0.getText()) + "',curr_id=(select id from currency where name='" + this.p0.getText().toString() + "')  where id='" + this.p + "' and date_='" + this.q + "'";
                    str = "delete from bill_transactions  where bill_id='" + this.p + "'";
                    str2 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id, ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0) ,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    String strM = this.i.M(string, str, str2);
                    if (strM != null) {
                        if (!strM.equals("1")) {
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error:");
                    if (strM != null && strM.length() > 20) {
                        strM = strM.substring(0, 20);
                    }
                    sb.append(strM);
                    Toast.makeText(this, sb.toString(), 0).show();
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("update bills set date_='");
                sb2.append((Object) this.T.getText());
                sb2.append("',amount='");
                sb2.append(this.g0.getText().toString().replaceAll(",", ""));
                sb2.append("',d_amount='");
                sb2.append(this.a0.getText().toString().replaceAll(",", ""));
                sb2.append("',t_val='");
                sb2.append(this.d0.getText().toString().replaceAll(",", ""));
                sb2.append("',tax_amount='");
                sb2.append(this.e0.getText().toString().replaceAll(",", ""));
                sb2.append("',cost2='");
                sb2.append(this.c0.getText().toString().replaceAll(",", ""));
                sb2.append("',cus_id=(select id from customers where name='");
                sb2.append((Object) this.X.getText());
                sb2.append("' ),br_id=(select id from branches where name='");
                sb2.append((Object) this.V.getText());
                sb2.append("' ),cash_id=(select id from customers where name='");
                sb2.append((Object) this.q0.getText());
                sb2.append("' ),bill_type=");
                sb2.append(i);
                sb2.append(",bill_no2='");
                sb2.append((Object) this.y0.getText());
                sb2.append("',is_back='");
                sb2.append(this.S.isChecked() ? 1 : 0);
                sb2.append("',remarks='");
                sb2.append((Object) this.z0.getText());
                sb2.append("',param1='");
                sb2.append(this.R0.getTag() != null ? this.R0.getTag().toString() : "");
                sb2.append("',curr_id=(select id from currency where name='");
                sb2.append(this.p0.getText().toString());
                sb2.append("')  where id='");
                sb2.append(this.p);
                sb2.append("' and date_='");
                sb2.append(this.q);
                sb2.append("'");
                string = sb2.toString();
                str = "delete from bill_transactions  where bill_id='" + this.p + "'";
                str2 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark ,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                String strM2 = this.i.M(string, str, str2);
                if (strM2 == null || !strM2.equals("1")) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Error:");
                    if (strM2 != null && strM2.length() > 20) {
                        strM2 = strM2.substring(0, 20);
                    }
                    sb3.append(strM2);
                    Toast.makeText(this, sb3.toString(), 0).show();
                    return;
                }
                Log.d("sql1=h_", string);
                Log.d("sql2=h_", str);
                Log.d("sql3=h_", str2);
                this.q = this.T.getText().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void barcode_click(View view) {
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.B1 = 1;
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.B1 = 2;
        }
        if (this.i.ia("pref_barcode_type", "1").equals("1")) {
            this.i.Td(this);
            return;
        }
        Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.usb_barcode), 0).show();
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.p1.requestFocus();
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.v1.requestFocus();
        }
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.g1 = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_hide(View view) {
        this.v0.setVisibility(8);
        this.w0.setVisibility(0);
        this.t0.setVisibility(0);
        Y1();
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.no_);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2550r1(textView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2553s1());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.v0.setVisibility(0);
        this.t0.setVisibility(4);
        this.p1.requestFocus();
        Y1();
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
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2544p1(textView, imageView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2547q1());
        builder.create().show();
    }

    public HashMap c1() {
        HashMap map = new HashMap();
        map.put("tr_total_disc", this.a0.getText().toString().replace(",", ""));
        map.put("tr_total", this.g0.getText().toString().replace(",", ""));
        map.put("tr_tax", this.e0.getText().toString().replace(",", ""));
        map.put("tr_total_cost", this.c0.getText().toString().replace(",", ""));
        map.put("tr_paid", "0");
        map.put("tr_remin", "0");
        map.put("tr_cus_name", this.X.getText().toString());
        map.put("tr_curr_name", this.p0.getText().toString());
        return map;
    }

    public void c2(String str, String str2, String str3, String str4) {
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
            autoCompleteTextView.setOnItemClickListener(new V(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new W(autoCompleteTextView));
            this.s2 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new X());
            imageView2.setOnClickListener(new Y(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new Z());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2498a0());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2504c0(editText2, autoCompleteTextView, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void d1() {
        Log.d("item_remarks=", "..start...");
        C1044Xj.a().c(new RunnableC1171Zj(16, this.i, this.v1, this.s1, this, new RunnableC1086Yj()));
    }

    public void d2(String str, String str2, String str3, String str4, Handler handler, int i) {
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
            autoCompleteTextView.setOnItemClickListener(new C2542p(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC2545q(autoCompleteTextView));
            this.s2 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new ViewOnClickListenerC2548r());
            imageView2.setOnClickListener(new ViewOnClickListenerC2551s(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2554t());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2556u());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2560w(autoCompleteTextView, alertDialogCreate, str, editText, editText2, i, handler));
        } catch (Exception unused) {
        }
    }

    public final String e1() {
        String[] stringArray = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills);
        int i = this.t;
        String str = stringArray[(i == 21 || i == 211) ? (char) 7 : '\b'];
        this.i.P4(this.X.getText().toString()).length();
        return "" + str + " ";
    }

    public void e2(String str, String str2, String str3, String str4, String str5, String str6) {
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
            autoCompleteTextView.setOnItemClickListener(new O1(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new P1(autoCompleteTextView2, editText));
            this.s2 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new Q1());
            imageView2.setOnClickListener(new ViewOnClickListenerC2497a(arrayAdapter, autoCompleteTextView));
            imageView3.setOnClickListener(new ViewOnClickListenerC2500b(arrayAdapter2, autoCompleteTextView2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2503c());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2506d());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2509e(editText, autoCompleteTextView, autoCompleteTextView2, str, editText2, editText3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void f1(String str) {
        C4143vg c4143vgQ4 = this.i.q4(str);
        if (c4143vgQ4.i().equals("")) {
            return;
        }
        this.k = c4143vgQ4.i();
        this.o2 = c4143vgQ4.j();
        this.r2 = c4143vgQ4.h();
        this.q2 = "0";
        this.p2 = c4143vgQ4.f();
    }

    public void f2() {
        TextView textView;
        if (this.t != 21 || (textView = this.u1) == null || textView.getText().toString().length() == 0 || this.S.isChecked()) {
            return;
        }
        this.i.v0("update items set e_date2='" + this.u1.getText().toString() + "' where name='" + this.v1.getText().toString() + "'");
    }

    public double g1(long j, String str) {
        return C0(this.v1.getText().toString(), this.n).doubleValue() - new C1839c10(this.i).u(j + "", str, this.V.getText().toString(), "", this.t, this.S.isChecked(), this.v1.getText().toString());
    }

    public void g2() {
        this.h2 = false;
        this.B2 = 0;
        Bill_edit.P2 = true;
        Bill_edit.Q2 = true;
        Bill_edit.R2 = this.X.getText().toString();
        Z00.o0 = false;
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        if (getWindow() != null) {
            return getWindow().getCurrentFocus();
        }
        return null;
    }

    public double h1(long j, String str, String str2) {
        return E0(this.v1.getText().toString(), this.n, str2).doubleValue() - new C1839c10(this.i).u(j + "", str, this.V.getText().toString(), str2, this.t, this.S.isChecked(), this.v1.getText().toString());
    }

    public void h2(String str, String str2, String str3, Handler handler) {
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
            autoCompleteTextView.setOnItemClickListener(new C2512f(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC2515g(autoCompleteTextView));
            imageView.setOnClickListener(new ViewOnClickListenerC2518h(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2521i());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2524j());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2530l(autoCompleteTextView, alertDialogCreate, str, editText, handler));
        } catch (Exception unused) {
        }
    }

    public void i1() {
        try {
            if (getIntent().getStringExtra("TR_ID") != null) {
                this.p = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
                if (getIntent().getStringExtra("TR_DATE") != null) {
                    this.q = getIntent().getStringExtra("TR_DATE");
                    new C2160f10(this.i).W(this.T.getText().toString());
                }
                this.i.z0("delete from items_temp");
                this.i.z0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,ifnull(e_date,'')   from bill_transactions_v  where bill_id=" + this.p + " and bill_date='" + this.q + "'");
                this.w = Integer.parseInt(getIntent().getStringExtra("tran_status"));
                this.J = getIntent().getIntExtra("back_edit", 0);
                this.L = true;
            } else {
                this.L = false;
            }
            this.K = getIntent().getIntExtra("back_recyclerview", 0);
            this.J = getIntent().getIntExtra("back_edit", 0);
        } catch (Exception unused) {
        }
    }

    public void i2() {
        this.i.Vb();
        this.s0 = this.i.m7(String.valueOf(this.p), this.I, this.V.getText().toString() == null ? this.i.C2(this.l) : this.V.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
        double dC6 = this.i.C6(this.v1.getText().toString(), this.p0.getText().toString(), this.T.getText().toString());
        Log.d("edit_item=", this.v1.getText().toString() + ":" + this.i.S7(String.valueOf(dC6)) + ":" + ((Object) this.q1.getText()));
        this.q1.setHint(dC6 <= 0.0d ? "" : this.i.S7(String.valueOf(dC6)));
        if (this.i.ja("prefOthers_item_price", false) || this.t == 11) {
            this.q1.setText(dC6 > 0.0d ? this.i.S7(String.valueOf(dC6)) : "");
        }
    }

    public void j1() {
        Log.d("back_edit=", this.J + ":" + this.w2 + ":" + this.z2 + ":" + this.K);
        if (this.J == 1 && this.g2) {
            D2 = true;
            E2 = true;
            F2 = this.X.getText().toString();
            Z00.o0 = false;
            finish();
            return;
        }
        if (this.w2 && this.z2 != 2) {
            this.w2 = false;
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,cost_price+sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,ifnull(e_date,'')  from bill_transactions  where bill_id=" + this.p + "");
            return;
        }
        int i = this.t;
        if (i == 11) {
            D2 = false;
            Intent intent = new Intent(this, (Class<?>) Adj2.class);
            intent.addFlags(67141632);
            intent.addFlags(1073741824);
            intent.putExtra("TR_TYPE", "11");
            intent.putExtra("g_id", this.l);
            intent.putExtra("g_name", this.n);
            startActivity(intent);
            finish();
            return;
        }
        if (i == 21) {
            D2 = false;
            Intent intent2 = new Intent(this, (Class<?>) Adj2.class);
            intent2.addFlags(67141632);
            intent2.addFlags(1073741824);
            intent2.putExtra("TR_TYPE", "21");
            intent2.putExtra("g_id", this.l);
            intent2.putExtra("g_name", this.n);
            startActivity(intent2);
            finish();
        }
    }

    public void j2(String str, String str2, String str3) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_item_sales_price, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            editText.setText(str2.replace(",", ""));
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            builder.setPositiveButton("OK", new D());
            builder.setNegativeButton("Cancel", new E());
            AlertDialog alertDialogCreate = builder.create();
            this.R.isChecked();
            alertDialogCreate.setTitle(str);
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new F(editText, str, str3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public void k2(int i) {
        double dB0;
        try {
            if (this.X0) {
                return;
            }
            if (this.t1.getText().toString().trim().length() > 0) {
                dB0 = this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(this.t1.getText().toString().replaceAll(",", ""), this.q1.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.q1.getTag().toString().replaceAll(",", "")) : 1.0d) : Double.parseDouble(this.t1.getText().toString().replaceAll(",", ""));
            } else {
                dB0 = 0.0d;
            }
            this.X0 = true;
            if (i == 1) {
                if (this.t1.getText().toString().trim().length() == 0) {
                    this.r1.setText("");
                } else if (this.q1.getText().toString().trim().length() > 0 && this.t1.getText().toString().trim().length() > 0) {
                    this.r1.setText(this.i.S7("" + (Double.parseDouble(this.q1.getText().toString().replaceAll(",", "")) * dB0)));
                    this.r1.selectAll();
                    this.i.gc(this.t1);
                }
            } else if (i == 2) {
                if (this.q1.getText().toString().trim().length() == 0) {
                    this.r1.setText("");
                } else if (this.q1.getText().toString().trim().length() > 0 && this.t1.getText().toString().trim().length() > 0) {
                    this.r1.setText(this.i.S7("" + (Double.parseDouble(this.q1.getText().toString().replaceAll(",", "")) * dB0)));
                    this.r1.selectAll();
                    this.i.gc(this.q1);
                }
            } else if (i == 3) {
                if (this.r1.getText().toString().trim().length() == 0) {
                    this.q1.setText("");
                } else if (this.r1.getText().toString().trim().length() > 0 && this.t1.getText().toString().trim().length() > 0) {
                    this.q1.setText(this.i.S7("" + (Double.parseDouble(this.r1.getText().toString().replaceAll(",", "")) / dB0)));
                    this.i.gc(this.r1);
                }
            }
            this.X0 = false;
        } catch (Exception e) {
            this.X0 = false;
            e.printStackTrace();
        }
    }

    public void l2(int i) {
        try {
            if (this.X0) {
                return;
            }
            this.X0 = true;
            if (i == 1) {
                if (this.y1.getText().toString().trim().length() == 0) {
                    this.x1.setText("");
                } else if (this.w1.getText().toString().trim().length() > 0 && this.y1.getText().toString().trim().length() > 0) {
                    this.x1.setText(this.i.S7("" + (Double.parseDouble(this.w1.getText().toString().replaceAll(",", "")) * Double.parseDouble(this.y1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.y1);
                }
            } else if (i == 2) {
                if (this.w1.getText().toString().trim().length() == 0) {
                    this.x1.setText("");
                } else if (this.w1.getText().toString().trim().length() > 0 && this.y1.getText().toString().trim().length() > 0) {
                    this.x1.setText(this.i.S7("" + (Double.parseDouble(this.w1.getText().toString().replaceAll(",", "")) * Double.parseDouble(this.y1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.w1);
                }
            } else if (i == 3) {
                if (this.x1.getText().toString().trim().length() == 0) {
                    this.w1.setText("");
                } else if (this.x1.getText().toString().trim().length() > 0 && this.y1.getText().toString().trim().length() > 0) {
                    this.w1.setText(this.i.S7("" + (Double.parseDouble(this.x1.getText().toString().replaceAll(",", "")) / Double.parseDouble(this.y1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.x1);
                }
            }
            this.X0 = false;
        } catch (Exception e) {
            this.X0 = false;
            e.printStackTrace();
        }
    }

    public void more_item(View view) {
        this.i.te(this, this.v1.getText().toString(), this.X.getText().toString(), this.p0.getText().toString(), C0(this.v1.getText().toString(), this.n).doubleValue(), this.S.isChecked(), this.b1, this.t, this.D1.getText().toString());
    }

    public void n2(final long j, final String str) {
        Log.d("update_qty=", j + ":" + this.t + ":" + this.S.isChecked() + ":" + this.L);
        this.n = this.V.getText().toString() == null ? this.i.C2(this.l) : this.V.getText().toString();
        this.l = this.V.getText().toString() == null ? this.l : this.i.D2(this.V.getText().toString());
        AbstractC3132jE.d(new Callable() { // from class: D7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.t1(j, str);
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: E7
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                Bill_adj2.u1((Integer) obj);
            }
        });
    }

    public final void o2() {
        try {
            char c = 7;
            String str = "";
            if (this.R.isChecked()) {
                StringBuilder sb = new StringBuilder();
                if (this.S.isChecked()) {
                    str = this.S.getText().toString() + " ";
                }
                sb.append(str);
                String[] stringArray = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills);
                int i = this.t;
                if (i != 21 && i != 211) {
                    c = '\b';
                }
                sb.append(stringArray[c]);
                String string = sb.toString();
                this.N0 = string;
                setTitle(string);
                this.q0.setVisibility(0);
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (this.S.isChecked()) {
                    str = this.S.getText().toString() + " ";
                }
                sb2.append(str);
                String[] stringArray2 = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills);
                int i2 = this.t;
                if (i2 != 21 && i2 != 211) {
                    c = '\b';
                }
                sb2.append(stringArray2[c]);
                String string2 = sb2.toString();
                this.N0 = string2;
                setTitle(string2);
                this.q0.setVisibility(4);
            }
            if (this.t == 11 && this.S.isChecked() && !this.L) {
                this.s0 = this.i.o7(String.valueOf(this.p), "0", this.V.getText().toString(), this.i.ja("prefOthers_item_end_date", false));
            }
            G1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        EditText editText;
        try {
            if (i2 != 0) {
                if (i == 2) {
                    if (intent != null && (editText = this.r1) != null) {
                        editText.setText(this.i.S7(intent.getStringExtra("calc_result")));
                        this.s1.requestFocus();
                    }
                } else if (i == 1) {
                    if (i2 == -1) {
                        Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                        this.s2.setText(string);
                        cursorQuery.close();
                        Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                    }
                } else if (i == this.k2 && intent != null) {
                    z1(intent.getData(), false);
                } else if (i == this.j2) {
                    x1(intent);
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
                            this.i.j1(activityResult.getContents(), this, this.B0);
                        }
                        if (strI6.equals("") && !Z00.P0) {
                            return;
                        }
                        if (Z00.P0) {
                            strI6 = this.i.I6(activityResult.getContents());
                        }
                        int i3 = this.B1;
                        if (i3 == 1) {
                            q1(strI6);
                        } else if (i3 == 2) {
                            r1(strI6);
                        }
                        this.B1 = 0;
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
        } catch (Exception unused) {
        }
        try {
            super.onActivityResult(i, i2, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                    this.B2 = 0;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                this.B2 = 0;
            }
        }
        if (this.t == 211) {
            finish();
        }
        Log.d("onback=", this.p + ":" + this.B2 + ":" + this.J);
        int i = this.B2;
        if (i == 1) {
            this.A2 = 1;
            L0();
            return;
        }
        if (i == 2) {
            K1();
            return;
        }
        if (this.p == 0) {
            finish();
            return;
        }
        K1();
        if (getIntent().getStringExtra("TR_ID") == null && this.j.i == 0 && this.p != 0) {
            f1(this.X.getText().toString());
            if (C1839c10.k(this.i, this.k)) {
                try {
                    w0();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_bill_edit2);
        this.i = new Z00(this.h, this);
        this.j = new E00(this);
        if (getIntent().getStringExtra("bill_offer_id") == null) {
            this.i.z0("delete from items_temp");
        }
        i1();
        if (this.p != 0) {
            setContentView(info.aalmoghalis.inventory.R.layout.content_bill_det2);
            TextView textView = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name_hdr);
            this.b0 = textView;
            this.z2 = 0;
            textView.setOnClickListener(new ViewOnClickListenerC2540o0());
        } else {
            this.z2 = 1;
        }
        this.S = (CheckBox) findViewById(info.aalmoghalis.inventory.R.id.chk_back);
        this.O0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_header);
        this.P0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_footer);
        this.Q0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_item_header);
        this.P = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        this.R = (SwitchCompat) findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
        this.S.setOnCheckedChangeListener(new S1());
        ImageView imageView = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img_u_currency);
        this.U = imageView;
        imageView.setVisibility(8);
        this.U.setOnClickListener(this.T0);
        this.V = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_branch);
        this.T = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_date);
        this.X = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name);
        this.x0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
        this.Y = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot);
        this.Z = (TextView) findViewById(info.aalmoghalis.inventory.R.id.count);
        this.a0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot_disc);
        this.c0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot_cost);
        this.k0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr);
        this.m0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_add);
        this.n0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode);
        if (this.i.ja("prefOthers_barcode", false)) {
            this.n0.setVisibility(0);
        }
        this.y0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_no);
        this.z0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
        this.u0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.root_layout);
        this.v0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.item_add_hdr);
        this.w0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_items_list_hdr);
        this.t0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.page_add);
        this.R0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        if (this.p != 0) {
            this.w0.setVisibility(0);
        }
        this.d0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tax_val);
        this.e0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tax_amount);
        this.f0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr_tax2);
        LinearLayout linearLayout = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.paid_amount_input_layout);
        this.S0 = linearLayout;
        linearLayout.setVisibility(8);
        this.g0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_tot);
        this.h0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_bill_hdr);
        this.i0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
        this.j0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.LL_tax);
        this.d0.setText((CharSequence) this.i0.getItem(0));
        if (this.d0.getText().toString().equals("0") || this.p == 0) {
            this.e0.setVisibility(4);
            this.h0.setVisibility(4);
            this.g0.setVisibility(4);
        }
        this.p0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_curr);
        this.q0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_cash);
        this.p1 = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        this.G0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.s3());
        this.p0.setText(this.i.l3("0"));
        TextView textView2 = this.p0;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        this.p0.setOnClickListener(new ViewOnClickListenerC2552s0());
        this.H0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.A2());
        TextView textView3 = this.V;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        this.V.setOnClickListener(new D0());
        this.I0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.D3());
        TextView textView4 = this.q0;
        textView4.setPaintFlags(8 | textView4.getPaintFlags());
        this.q0.setText(this.i.B3().j());
        this.q0.setOnClickListener(new O0());
        this.P.setOnItemClickListener(new Z0());
        this.P.setChoiceMode(3);
        this.P.setMultiChoiceModeListener(new C2499a1());
        this.R.setOnCheckedChangeListener(new v1());
        Calendar calendar = Calendar.getInstance();
        this.T.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.M = calendar.get(1);
        this.N = calendar.get(2);
        this.O = calendar.get(5);
        this.T.setOnClickListener(new G1());
        this.X.setOnItemClickListener(new R1());
        this.X.setOnTouchListener(new ViewOnTouchListenerC2527k());
        this.X.addTextChangedListener(new C2558v());
        W1(true);
        I1();
        G1();
        m2();
        this.X.requestFocus();
        if (getIntent().getStringExtra("TR_ID") != null && C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                this.X.setEnabled(false);
                this.V.setEnabled(false);
                this.T.setEnabled(false);
                this.q0.setEnabled(false);
                this.p0.setEnabled(false);
                this.z0.setEnabled(false);
                this.y0.setEnabled(false);
            }
        }
        if (C2160f10.h > 0) {
            this.V.setEnabled(false);
        }
        if (this.p == 0 && getIntent().getStringExtra("bill_offer_id") == null) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        i1();
        a1();
        n2(this.p, "0");
        o2();
        N0();
        this.z0.addTextChangedListener(this.W0);
        this.z0.setOnClickListener(new G());
        this.y0.addTextChangedListener(this.W0);
        this.y0.setOnClickListener(new Q());
        p1();
        this.i.Zb();
        new C2160f10(this.i).W(this.T.getText().toString());
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(l1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.c2, this.M, this.N, this.O);
        }
        if (i == 4) {
            return new DatePickerDialog(l1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.d2, this.M, this.N, this.O);
        }
        if (i != 5) {
            return null;
        }
        return new DatePickerDialog(l1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.e2, this.M, this.N, this.O);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_bill3_print_5, menu);
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
            MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
            MenuItem menuItemFindItem2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
            boolean zL = new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit");
            boolean zL2 = new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", HTML.Tag.DEL);
            menuItemFindItem.setVisible(zL);
            menuItemFindItem2.setVisible(zL2);
        } else if (i > 0 && this.p == 0) {
            menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", HTML.Tag.DEL));
        }
        this.b2 = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        this.b2.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.b2.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.b2.setOnQueryTextListener(new C2564y());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        R0(this.i.L2());
        W1(true);
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
            y0(1, this.t);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_submit) {
            C1();
            y0(2, this.t);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_remove) {
            x0();
        } else {
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.share) {
                if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin) {
                    this.v2 = 1;
                } else {
                    this.v2 = 2;
                }
                if (this.p == 0) {
                    L0();
                    return true;
                }
                if (this.B2 == 1) {
                    this.A2 = 0;
                    this.h2 = true;
                    y0(2, this.t);
                }
                D1(this.v2);
                return true;
            }
            if (menuItem.getItemId() == 16908332) {
                onBackPressed();
                return true;
            }
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.printing || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.printing2) {
                Log.d("thermal=", this.p + ":" + this.B2 + ":" + this.J);
                if (this.B2 == 1) {
                    this.A2 = 0;
                    this.h2 = true;
                    y0(2, this.t);
                }
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
                if (this.B2 == 1) {
                    this.A2 = 0;
                    this.h2 = true;
                    y0(2, this.t);
                }
                this.N0 = getTitle().toString();
                P1();
                new C3966tX().H(this, this.i, this.j, this.o2, menuItem.getItemId());
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
            if (this.p == 0 || this.p0.getText().toString().equals(radioButton.getText().toString())) {
                this.p0.setTag(radioButton.getText().toString());
                a1();
            } else {
                this.i.v0("delete from items_temp");
                this.i1 = 1;
                this.B2 = 1;
                this.p0.setTag(radioButton.getText().toString());
                a1();
                N0();
                n2(this.p, "0");
            }
            Log.d("radio_checked:=", radioButton.getText().toString() + ":" + this.y);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.z2 == 2 && this.p != 0) {
            j1();
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

    public void p1() {
        try {
            if (getIntent().getStringExtra("item_name") != null) {
                String stringExtra = getIntent().getStringExtra("item_name");
                String stringExtra2 = getIntent().getStringExtra("item_qty");
                F2 = stringExtra;
                int i = 0;
                while (true) {
                    if (i >= this.P.getAdapter().getCount()) {
                        i = -1;
                        break;
                    }
                    C0634Jt c0634Jt = (C0634Jt) this.P.getAdapter().getItem(i);
                    double dB0 = (this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(c0634Jt.h().replaceAll(",", ""), Double.parseDouble(c0634Jt.m())) : Double.parseDouble(c0634Jt.h().replaceAll(",", ""))) * Double.parseDouble(c0634Jt.m());
                    if (c0634Jt.e().equals(stringExtra) && dB0 == Double.parseDouble(stringExtra2.replaceAll(",", ""))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    ListView listView = this.P;
                    listView.performItemClick(listView.getAdapter().getView(i, null, null), i, this.P.getAdapter().getItemId(i));
                    this.t1.requestFocus();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void p2() {
        int size = this.E0.size() - 1;
        if (this.E0.valueAt(size)) {
            this.i.se(this, this.A0.getItem(this.E0.keyAt(size)), this.T.getText().toString(), this.n, this.l, this.p0.getText().toString(), this);
        }
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void q0(Handler handler, String str, int i) {
        d2("", str.trim(), "", "", handler, i);
    }

    public void q1(String str) {
        this.p1.setText(str);
        this.A = this.p1.getText().toString();
        this.I = "0";
        this.C = "";
        this.G = "";
        this.B = "";
        this.H = "";
        this.D = "";
        this.E = "";
        this.F = "1";
        this.i.X6(this.p1.getText().toString());
        double dC6 = this.i.C6(str, this.p0.getText().toString(), this.T.getText().toString());
        this.C = dC6 > 0.0d ? this.i.S7(String.valueOf(dC6)) : "";
        this.D = this.i.X6(this.p1.getText().toString());
        this.F = String.valueOf(this.i.Z6(this.p1.getText().toString(), this.D));
        C2 = 1;
        q2();
    }

    public void q2() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_add_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.v1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            this.t1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
            this.q1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            this.r1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_remarks);
            this.s1 = autoCompleteTextView;
            this.i.cd(this, autoCompleteTextView);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price_hdr);
            this.G1 = textView;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.H1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total_hdr);
            this.C1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name_hdr);
            this.E1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_add_amount);
            TextView textView2 = this.C1;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_unit);
            this.D1 = textView3;
            textView3.setPaintFlags(textView3.getPaintFlags() | 8);
            this.o0 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode2);
            if (this.i.ja("prefOthers_barcode", false)) {
                this.o0.setVisibility(0);
            }
            TextView textView4 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_date);
            this.u1 = textView4;
            textView4.setPaintFlags(textView4.getPaintFlags() | 8);
            if (this.i.ja("prefOthers_item_end_date", false)) {
                this.u1.setVisibility(0);
                if (this.t == 21 && !this.S.isChecked()) {
                    this.u1.setOnClickListener(new I0());
                } else if (this.t == 11 || this.S.isChecked()) {
                    this.u1.setOnClickListener(new J0());
                }
            } else {
                this.u1.setVisibility(8);
            }
            this.D1.setOnClickListener(new K0());
            R1();
            ArrayList arrayListG6 = this.i.G6();
            C2160f10.c0(this, this.v1, arrayListG6, 2);
            C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
            this.B0 = c1098Yv;
            c1098Yv.l.clear();
            this.B0.notifyDataSetChanged();
            this.v1.setThreshold(1);
            this.v1.setAdapter(this.B0);
            this.t1.selectAll();
            this.q1.selectAll();
            this.r1.selectAll();
            this.v1.setOnItemClickListener(new L0());
            this.v1.setOnTouchListener(new M0());
            this.v1.addTextChangedListener(new N0());
            this.v1.setText(this.A);
            this.t1.setText(this.B);
            if (this.i.W6(this.v1.getText().toString()) > 1) {
                this.D1.setVisibility(0);
            } else {
                this.D1.setVisibility(8);
            }
            this.D1.setText(this.D);
            this.q1.setTag(this.F);
            this.u1.setText(this.E);
            if (C2 == 1) {
                this.q1.setHint(this.C);
                this.q1.setText("");
                if (this.i.ja("prefOthers_item_price", false)) {
                    this.q1.setText(this.C);
                }
                double dG1 = g1(this.p, this.I);
                double d = this.q1.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.q1.getTag().toString().replaceAll(",", "")) : 1.0d;
                if (this.i.ja("prefOthers_qty_pr", false)) {
                    dG1 = this.i.b0(dG1 + "", d);
                }
                this.t1.setHint(String.valueOf(dG1));
                if (this.i.ja("prefOthers_item_end_date", false)) {
                    this.u1.setVisibility(0);
                    if (this.t == 11 || this.S.isChecked()) {
                        ArrayList arrayListD0 = D0(this.v1.getText().toString(), this.n);
                        if (arrayListD0.size() == 0) {
                            this.u1.setVisibility(8);
                        } else {
                            for (int i = 0; i < arrayListD0.size(); i++) {
                                if (Double.parseDouble((String) ((HashMap) arrayListD0.get(i)).get("item_qty")) > 0.0d) {
                                    this.u1.setText((CharSequence) ((HashMap) arrayListD0.get(i)).get("item_date"));
                                    this.t1.setHint((CharSequence) ((HashMap) arrayListD0.get(i)).get("item_qty"));
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                this.q1.setText(this.C);
                this.q1.setHint(this.C);
                if (this.q1.getTag().toString().trim().length() > 0) {
                    Double.parseDouble(this.q1.getTag().toString().replaceAll(",", ""));
                }
                double dG2 = g1(this.p, this.I);
                if (this.i.ja("prefOthers_qty_pr", false)) {
                    this.t1.setHint(this.i.c0(String.valueOf(dG2 / Double.valueOf(this.F).doubleValue()), Double.parseDouble(this.F)) + "");
                } else {
                    this.t1.setHint(String.valueOf(C1839c10.C(dG2 / Double.valueOf(this.F).doubleValue(), C1839c10.d)));
                }
            }
            this.r1.setText(this.G);
            this.r1.setHint(this.G);
            this.s1.setText(this.H);
            if (C2 == 2) {
                this.q1.requestFocus();
            } else if (this.A.equals("")) {
                this.v1.requestFocus();
            } else {
                this.t1.requestFocus();
            }
            this.q1.selectAll();
            this.r1.selectAll();
            this.t1.selectAll();
            if (this.v1.getText().toString().length() > 0) {
                d1();
            }
            if (C2 == 2) {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new P0());
            } else {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.add_transaction), new Q0());
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.btn_add_close), new R0());
            }
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new S0(builder));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new T0(alertDialogCreate));
            alertDialogCreate.getButton(-3).setOnClickListener(new U0(alertDialogCreate));
        } catch (Exception e) {
            Log.d("view_item_error=", ":" + e.getMessage());
        }
    }

    public void r0(Handler handler) {
        h2("", this.v1.getText().toString(), "", handler);
    }

    public void r1(String str) {
        this.v1.setText(str);
        this.t1.requestFocus();
        double dC6 = this.i.C6(str, this.p0.getText().toString(), this.T.getText().toString());
        this.q1.setHint(dC6 <= 0.0d ? "" : this.i.S7(String.valueOf(dC6)));
        if (this.i.ja("prefOthers_item_price", false)) {
            this.q1.setText(dC6 <= 0.0d ? "" : this.i.S7(String.valueOf(dC6)));
        }
        double dG1 = g1(this.p, this.I);
        if (this.i.ja("prefOthers_qty_pr", false)) {
            dG1 = this.i.c0(dG1 + "", 1.0d);
        }
        this.t1.setHint(String.valueOf(dG1));
        this.D1.setText(this.i.X6(this.v1.getText().toString()));
        if (this.i.W6(this.v1.getText().toString()) > 1) {
            this.D1.setVisibility(0);
        } else {
            this.D1.setVisibility(8);
        }
        if ((this.t == 11 || this.S.isChecked()) && this.i.ja("prefOthers_item_end_date", false)) {
            this.u1.setVisibility(0);
            ArrayList arrayListD0 = D0(this.v1.getText().toString(), this.n);
            if (arrayListD0.size() == 0) {
                this.u1.setVisibility(8);
            } else {
                for (int i = 0; i < arrayListD0.size(); i++) {
                    if (Double.parseDouble((String) ((HashMap) arrayListD0.get(i)).get("item_qty")) > 0.0d) {
                        this.u1.setText((CharSequence) ((HashMap) arrayListD0.get(i)).get("item_date"));
                        this.t1.setHint((CharSequence) ((HashMap) arrayListD0.get(i)).get("item_qty"));
                        break;
                    }
                }
            }
        }
        this.q1.setTag("1");
        this.t1.selectAll();
        this.q1.selectAll();
        this.r1.selectAll();
        d1();
    }

    public void s0(String str, String str2, String str3, Handler handler) {
        String strS7 = "";
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_purchase_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.A1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.p_tr_name);
            this.z1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            this.y1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
            this.w1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            this.x1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
            this.W = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_date_p);
            this.S1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price_hdr);
            this.T1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total_hdr);
            this.U1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
            this.V1 = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
            T1();
            this.A1.setThreshold(1);
            this.A1.setAdapter(this.F0);
            this.A1.requestFocus();
            this.z1.setText(str);
            this.y1.setText(str2);
            this.y1.setTag(str3);
            double dJ6 = this.i.J6(str, this.p0.getText().toString(), 2, this.S.isChecked(), this.b1 + "", this.t, "");
            EditText editText = this.w1;
            if (dJ6 > 0.0d) {
                strS7 = this.i.S7(String.valueOf(dJ6));
            }
            editText.setHint(strS7);
            this.y1.selectAll();
            this.w1.selectAll();
            this.A1.setOnItemClickListener(new D1());
            this.A1.setOnTouchListener(new E1());
            this.A1.addTextChangedListener(new F1());
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.add_transaction), new H1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new I1(builder));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new J1(handler, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_purchase_error=", ":" + e.getMessage());
        }
    }

    public final /* synthetic */ void s1(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        z1(uri, true);
    }

    public void t0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public final /* synthetic */ Integer t1(long j, String str) {
        this.s0 = new C2160f10(this.i).d0(j, this.p, this.b1, str, this.S.isChecked(), this.L, this.n, this.l, this.t, "0", this.T.getText().toString());
        return 1;
    }

    public void u0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void u_currency_btn(View view) {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        this.i.ee(this.p, this, this.U0, new HandlerC2528k0(), "0");
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        a1();
    }

    public void update_bill_total(View view) {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        try {
            if (this.p == 0) {
                v1();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            editText.setText(this.L1 + "");
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
            RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
            if (this.K1 == 0) {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton1);
            } else {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton2);
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new Y0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2502b1());
            AlertDialog alertDialogCreate = builder.create();
            this.R.isChecked();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.total_disc2));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2505c1(editText, radioButton, alertDialogCreate));
            alertDialogCreate.getButton(-2).setOnClickListener(new ViewOnClickListenerC2508d1(alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public void update_bill_total_all(View view) {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        try {
            if (this.p == 0) {
                v1();
            }
            if (this.p == 0) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total_all, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_disc_amt);
            if (this.K1 != 1 || this.J1 <= 0.0d) {
                editText.setText(this.J1 + "");
            } else {
                editText.setText(this.L1 + "");
            }
            editText.addTextChangedListener(new C2018dE(editText));
            editText.selectAll();
            RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
            RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
            if (this.K1 == 0) {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton1);
            } else {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton2);
            }
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_other_cost);
            editText2.setText(this.P1 + "");
            editText2.selectAll();
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cost_name);
            if (this.Q1 == 0) {
                this.Q1 = -24;
            }
            this.i.cd(this, autoCompleteTextView);
            autoCompleteTextView.setText(this.i.A4(this.Q1 + ""));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.m1());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2511e1(autoCompleteTextView));
            this.i0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_tax_val);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_tax_amount);
            TableRow tableRow = (TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_tax);
            textView.setText(this.d0.getText().toString());
            textView2.setText(this.e0.getText().toString());
            tableRow.setVisibility(this.j0.getVisibility());
            textView2.setVisibility(this.e0.getVisibility());
            tableRow.setOnClickListener(new ViewOnClickListenerC2514f1(textView, radioButton, editText, textView2));
            EditText editText3 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.paid_amount);
            TableRow tableRow2 = (TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_paid_amount);
            tableRow2.setVisibility(8);
            if (tableRow2.getVisibility() == 0) {
                editText3.requestFocus();
            } else {
                editText.requestFocus();
            }
            editText3.selectAll();
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2517g1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2520h1());
            AlertDialog alertDialogCreate = builder.create();
            this.R.isChecked();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2523i1(editText2, autoCompleteTextView, radioButton, editText, editText3, textView, alertDialogCreate, view));
            alertDialogCreate.getButton(-2).setOnClickListener(new ViewOnClickListenerC2526j1(alertDialogCreate, view));
        } catch (Exception e) {
            Log.d("update_total_error=", e.getMessage() + "");
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("Error:");
            sb.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
            Toast.makeText(this, sb.toString(), 1).show();
        }
    }

    public void update_cost_total(View view) {
        try {
            if (this.p == 0) {
                v1();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total3, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            editText.setText(this.P1 + "");
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cost_name);
            if (this.Q1 == 0) {
                this.Q1 = -24;
            }
            this.i.cd(this, autoCompleteTextView);
            autoCompleteTextView.setText(this.i.A4(this.Q1 + ""));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.m1());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2529k1(autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2532l1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2535m1());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.total_other_cost));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2538n1(editText, autoCompleteTextView, alertDialogCreate));
            alertDialogCreate.getButton(-2).setOnClickListener(new ViewOnClickListenerC2541o1(alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public void update_tax_total(View view) {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0) {
                if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return;
                }
            }
        } else if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        if (view.getId() == info.aalmoghalis.inventory.R.id.bill_tot_hdr_tax || view.getId() == this.d0.getId() || view.getId() == this.e0.getId()) {
            this.i0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
            if (this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            G0(this.i0, this.d0);
        }
    }

    public void v0(View view, boolean z) {
        if (z) {
            O1();
        } else {
            P0();
        }
    }

    public void v1() {
        this.w2 = true;
        y0(2, this.t);
        this.B2 = 2;
    }

    public void view_item_info2(View view) {
        try {
            String string = this.v1.getText().toString();
            if (string != null && this.i.F6().contains(string)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_view_info2, (ViewGroup) null);
                builder.setView(viewInflate);
                TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
                TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
                TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
                String strX6 = this.i.X6(this.v1.getText().toString());
                StringBuilder sb = new StringBuilder();
                sb.append(this.v1.getText().toString());
                sb.append(":");
                sb.append(C0(string, this.n));
                sb.append(":");
                sb.append(this.i.J6(string, this.p0.getText().toString(), 1, this.S.isChecked(), this.b1 + "", this.t, strX6));
                sb.append(":");
                sb.append(this.i.J6(string, this.p0.getText().toString(), 2, this.S.isChecked(), this.b1 + "", this.t, strX6));
                Log.d("view_item_info=", sb.toString());
                double dDoubleValue = C0(string, this.n).doubleValue();
                double dJ6 = this.i.J6(string, this.p0.getText().toString(), 1, this.S.isChecked(), this.b1 + "", this.t, strX6);
                double dJ7 = this.i.J6(string, this.p0.getText().toString(), 2, this.S.isChecked(), this.b1 + "", this.t, strX6);
                if (dJ6 == -1.0d) {
                    dJ6 = 0.0d;
                }
                if (dJ7 == -1.0d) {
                    dJ7 = 0.0d;
                }
                textView.setText(this.i.P7(String.valueOf(dDoubleValue)));
                textView2.setText(this.i.P7(String.valueOf(dJ6)));
                textView3.setText(this.i.P7(String.valueOf(dJ7)));
                builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_hide), new I(builder));
                if (this.t == 22) {
                    this.i.F6().contains(string);
                }
                AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setTitle(this.v1.getText().toString());
                alertDialogCreate.getWindow().setSoftInputMode(16);
                alertDialogCreate.show();
                alertDialogCreate.getButton(-1).setOnClickListener(new J(string, textView2, strX6, alertDialogCreate));
            }
        } catch (Exception e) {
            Log.d("view_item_info2_error=", ":" + e.getMessage());
        }
    }

    public void w0() {
        P1();
        new C3966tX().H(this, this.i, this.j, this.o2, 0);
    }

    public void w1() {
        long j = this.p;
        this.b1 = j;
        this.c1 = j;
        this.S.setEnabled(false);
        o2();
        this.p = 0L;
        this.z0.setText(getString(info.aalmoghalis.inventory.R.string.bill_back_remarks) + this.y0.getText().toString());
        this.y0.setText("");
        G1();
        Calendar calendar = Calendar.getInstance();
        this.T.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.M = calendar.get(1);
        this.N = calendar.get(2);
        this.O = calendar.get(5);
        this.i1 = 1;
        a1();
        this.i.v0("delete from items_temp");
        v1();
        this.i1 = 1;
        a1();
        n2(this.p, "0");
    }

    public void x0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2510e0());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2513f0());
        builder.create().show();
    }

    /* JADX WARN: Code duplicated, block: B:122:0x068f A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:130:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:131:0x06ec  */
    /* JADX WARN: Code duplicated, block: B:134:0x06f3 A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:136:0x07e1 A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:137:0x07ec  */
    /* JADX WARN: Code duplicated, block: B:140:0x0814  */
    /* JADX WARN: Code duplicated, block: B:141:0x0817 A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:151:0x08be A[Catch: Exception -> 0x025c, TRY_LEAVE, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0906 A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:164:0x0a19  */
    /* JADX WARN: Code duplicated, block: B:165:0x0a1c A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0abe A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0aef A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:190:0x0b7e A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:191:0x0b83 A[Catch: Exception -> 0x0674, TryCatch #4 {Exception -> 0x0674, blocks: (B:174:0x0acc, B:176:0x0aef, B:177:0x0b12, B:179:0x0b47, B:181:0x0b4c, B:183:0x0b54, B:185:0x0b6b, B:187:0x0b75, B:188:0x0b7a, B:190:0x0b7e, B:191:0x0b83, B:109:0x0661, B:111:0x0666, B:113:0x066e, B:116:0x0678, B:122:0x068f, B:124:0x06ab, B:126:0x06d5, B:128:0x06e2, B:132:0x06ed, B:134:0x06f3, B:136:0x07e1, B:138:0x07ed, B:142:0x081b, B:155:0x08de, B:157:0x08e3, B:159:0x08eb, B:160:0x08f0, B:141:0x0817, B:162:0x0906, B:166:0x0a20, B:168:0x0ab2, B:171:0x0aba, B:173:0x0abe, B:192:0x0b8f, B:194:0x0b99, B:196:0x0ba1, B:197:0x0ba6, B:165:0x0a1c), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:204:0x0bfb  */
    /* JADX WARN: Code duplicated, block: B:25:0x0132 A[Catch: Exception -> 0x00ca, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ca, blocks: (B:11:0x0061, B:13:0x007d, B:20:0x00ed, B:22:0x0109, B:25:0x0132, B:30:0x0148, B:32:0x015e, B:34:0x017a, B:39:0x01ad), top: B:210:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x013a A[Catch: Exception -> 0x068c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x068c, blocks: (B:3:0x000e, B:6:0x003c, B:9:0x0049, B:18:0x00cf, B:23:0x011a, B:27:0x013a, B:37:0x01a1, B:41:0x01b3, B:44:0x01cf), top: B:208:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:36:0x01a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x01ad A[Catch: Exception -> 0x00ca, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ca, blocks: (B:11:0x0061, B:13:0x007d, B:20:0x00ed, B:22:0x0109, B:25:0x0132, B:30:0x0148, B:32:0x015e, B:34:0x017a, B:39:0x01ad), top: B:210:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x01b3 A[Catch: Exception -> 0x068c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x068c, blocks: (B:3:0x000e, B:6:0x003c, B:9:0x0049, B:18:0x00cf, B:23:0x011a, B:27:0x013a, B:37:0x01a1, B:41:0x01b3, B:44:0x01cf), top: B:208:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:44:0x01cf A[Catch: Exception -> 0x068c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x068c, blocks: (B:3:0x000e, B:6:0x003c, B:9:0x0049, B:18:0x00cf, B:23:0x011a, B:27:0x013a, B:37:0x01a1, B:41:0x01b3, B:44:0x01cf), top: B:208:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0212  */
    /* JADX WARN: Code duplicated, block: B:49:0x0214  */
    /* JADX WARN: Code duplicated, block: B:52:0x0225 A[Catch: Exception -> 0x025c, TRY_ENTER, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:54:0x024f A[Catch: Exception -> 0x025c, TRY_LEAVE, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0262  */
    /* JADX WARN: Code duplicated, block: B:61:0x0291 A[Catch: Exception -> 0x025c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:66:0x02aa A[Catch: Exception -> 0x025c, TRY_ENTER, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0320 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0330 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0398  */
    /* JADX WARN: Code duplicated, block: B:73:0x039b A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:76:0x03af A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:77:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:80:0x0404  */
    /* JADX WARN: Code duplicated, block: B:81:0x0407 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0473  */
    /* JADX WARN: Code duplicated, block: B:87:0x04ed A[Catch: Exception -> 0x025c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x025c, blocks: (B:52:0x0225, B:54:0x024f, B:66:0x02aa, B:68:0x0320, B:70:0x033a, B:74:0x03a1, B:76:0x03af, B:78:0x03bb, B:82:0x040b, B:102:0x0632, B:105:0x0639, B:81:0x0407, B:73:0x039b, B:69:0x0330, B:87:0x04ed, B:61:0x0291, B:146:0x08b3, B:149:0x08ba, B:151:0x08be), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:89:0x04fd A[Catch: Exception -> 0x0688, TRY_ENTER, TryCatch #3 {Exception -> 0x0688, blocks: (B:46:0x01df, B:50:0x0215, B:63:0x029e, B:99:0x0628, B:107:0x065a, B:85:0x0475, B:90:0x0507, B:94:0x056e, B:98:0x05c6, B:97:0x05c2, B:93:0x0568, B:89:0x04fd, B:59:0x0264, B:144:0x0849, B:153:0x08d7), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0565  */
    /* JADX WARN: Code duplicated, block: B:93:0x0568 A[Catch: Exception -> 0x0688, TryCatch #3 {Exception -> 0x0688, blocks: (B:46:0x01df, B:50:0x0215, B:63:0x029e, B:99:0x0628, B:107:0x065a, B:85:0x0475, B:90:0x0507, B:94:0x056e, B:98:0x05c6, B:97:0x05c2, B:93:0x0568, B:89:0x04fd, B:59:0x0264, B:144:0x0849, B:153:0x08d7), top: B:207:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:96:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:97:0x05c2 A[Catch: Exception -> 0x0688, TryCatch #3 {Exception -> 0x0688, blocks: (B:46:0x01df, B:50:0x0215, B:63:0x029e, B:99:0x0628, B:107:0x065a, B:85:0x0475, B:90:0x0507, B:94:0x056e, B:98:0x05c6, B:97:0x05c2, B:93:0x0568, B:89:0x04fd, B:59:0x0264, B:144:0x0849, B:153:0x08d7), top: B:207:0x01cd }] */
    /* JADX WARN: Instruction removed from duplicated block: B:176:0x0aef, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x0320, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:87:0x04ed, please report this as an issue */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x025e: MOVE (r2 I:??[OBJECT, ARRAY]) = (r30 I:??[OBJECT, ARRAY]) (LINE:607), block:B:57:0x025d */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x0689: MOVE (r2 I:??[OBJECT, ARRAY]) = (r30 I:??[OBJECT, ARRAY]) (LINE:1674), block:B:119:0x0689 */
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
    public void y0(int i, int i2) {
        String str;
        Exception exc;
        String message;
        String str2;
        String str3;
        int i3;
        String str4;
        String str5;
        int i4;
        Object objValueOf;
        String str6;
        String string;
        String str7;
        String str8;
        String strM;
        String string2;
        int i5;
        Object objValueOf2;
        String string3;
        String string4;
        String str9;
        String strM2;
        long jL2;
        long jM2;
        int i6;
        String string5;
        Object objValueOf3;
        String str10;
        int i7;
        Object objValueOf4;
        String string6;
        String str11;
        String strL;
        String string7;
        Object objValueOf5;
        String string8;
        int i8;
        Object objValueOf6;
        try {
            Log.d("bill_save=", this.p + ":" + this.X.getText().toString());
            if (this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            C2160f10.h = MO.b(this);
            if (B0()) {
                if (this.i.v8(this.X.getText().toString(), this.t).getCount() != 0) {
                    if (!this.X.getText().toString().equals(this.X.getText().toString().trim())) {
                        AutoCompleteTextView autoCompleteTextView = this.X;
                        autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                    }
                    if (this.i.v8(this.X.getText().toString(), this.t).getCount() == 0) {
                        this.X.setError("Not Inserted!");
                        return;
                    }
                    this.i.D = false;
                    str = "0";
                    if (this.p0.getText() != null) {
                        this.i.u(this, this.p0.getText().toString(), this.T.getText().toString(), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                        if (!this.i.D) {
                            return;
                        }
                    }
                    if (this.i.g2().getCount() == 0) {
                        this.m0.performClick();
                        return;
                    }
                    if (this.p == 0) {
                        G1();
                        if (this.y0.getText().toString().length() <= 0) {
                        }
                        if (this.R.isChecked()) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        if (this.t == 21) {
                            str4 = "' and date_='";
                            StringBuilder sb = new StringBuilder();
                            sb.append("update bills set date_='");
                            sb.append((Object) this.T.getText());
                            sb.append("',amount='");
                            sb.append(this.g0.getText().toString().replaceAll(",", ""));
                            sb.append("',d_amount='");
                            sb.append(this.a0.getText().toString().replaceAll(",", ""));
                            sb.append("',t_val='");
                            sb.append(this.d0.getText().toString().replaceAll(",", ""));
                            sb.append("',tax_amount='");
                            sb.append(this.e0.getText().toString().replaceAll(",", ""));
                            sb.append("',cost2='");
                            sb.append(this.c0.getText().toString().replaceAll(",", ""));
                            sb.append("',cus_id=(select id from customers where name='");
                            sb.append((Object) this.X.getText());
                            sb.append("' ),br_id=(select id from branches where name='");
                            sb.append((Object) this.V.getText());
                            sb.append("' ),cash_id=(select id from customers where name='");
                            sb.append((Object) this.q0.getText());
                            sb.append("' ),bill_type=");
                            sb.append(i3);
                            sb.append(",bill_no2='");
                            sb.append((Object) this.y0.getText());
                            sb.append("',is_back='");
                            sb.append(this.S.isChecked() ? 1 : 0);
                            sb.append("',remarks='");
                            sb.append(this.z0.getText().toString());
                            sb.append("',curr_id=(select id from currency where name='");
                            sb.append(this.p0.getText().toString());
                            sb.append("') ,tran_status=");
                            sb.append(i);
                            sb.append(",online=");
                            str5 = "0";
                            sb.append(str5);
                            sb.append(",last_user=");
                            i4 = C2160f10.h;
                            if (i4 == -1) {
                                objValueOf = "null";
                            } else {
                                objValueOf = Integer.valueOf(i4);
                            }
                            sb.append(objValueOf);
                            sb.append(" where id='");
                            sb.append(this.p);
                            sb.append(str4);
                            sb.append(this.q);
                            str6 = "'";
                            sb.append(str6);
                            string = sb.toString();
                            str7 = "delete from bill_transactions  where bill_id='" + this.p + str6;
                            str8 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id, ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0) ,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                            strM = this.i.M(string, str7, str8);
                            if (strM != null) {
                                if (!this.g2) {
                                    this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Error:");
                            if (strM != null) {
                                strM = strM.substring(0, 20);
                            }
                            sb2.append(strM);
                            Toast.makeText(this, sb2.toString(), 0).show();
                            L1();
                            a1();
                            return;
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("update bills set date_='");
                        sb3.append((Object) this.T.getText());
                        sb3.append("',amount='");
                        sb3.append(this.g0.getText().toString().replaceAll(",", ""));
                        sb3.append("',d_amount='");
                        sb3.append(this.a0.getText().toString().replaceAll(",", ""));
                        sb3.append("',t_val='");
                        sb3.append(this.d0.getText().toString().replaceAll(",", ""));
                        sb3.append("',tax_amount='");
                        sb3.append(this.e0.getText().toString().replaceAll(",", ""));
                        sb3.append("',cost2='");
                        sb3.append(this.c0.getText().toString().replaceAll(",", ""));
                        sb3.append("',cus_id=(select id from customers where name='");
                        sb3.append((Object) this.X.getText());
                        sb3.append("' ),br_id=(select id from branches where name='");
                        sb3.append((Object) this.V.getText());
                        sb3.append("' ),cash_id=(select id from customers where name='");
                        sb3.append((Object) this.q0.getText());
                        sb3.append("' ),bill_type=");
                        sb3.append(i3);
                        sb3.append(",bill_no2='");
                        sb3.append((Object) this.y0.getText());
                        sb3.append("',is_back='");
                        sb3.append(this.S.isChecked() ? 1 : 0);
                        sb3.append("',remarks='");
                        sb3.append(this.z0.getText().toString());
                        sb3.append("',param1='");
                        if (this.R0.getTag() != null) {
                            string2 = this.R0.getTag().toString();
                        } else {
                            string2 = "";
                        }
                        sb3.append(string2);
                        sb3.append("',curr_id=(select id from currency where name='");
                        sb3.append(this.p0.getText().toString());
                        sb3.append("') ,tran_status=");
                        sb3.append(i);
                        sb3.append(" ,last_user=");
                        i5 = C2160f10.h;
                        if (i5 == -1) {
                            objValueOf2 = "null";
                        } else {
                            objValueOf2 = Integer.valueOf(i5);
                        }
                        sb3.append(objValueOf2);
                        sb3.append(" where id='");
                        sb3.append(this.p);
                        str4 = "' and date_='";
                        sb3.append(str4);
                        sb3.append(this.q);
                        sb3.append("'");
                        string3 = sb3.toString();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("delete from bill_transactions  where bill_id='");
                        sb4.append(this.p);
                        sb4.append("'");
                        string4 = sb4.toString();
                        str9 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark ,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                        strM2 = this.i.M(string3, string4, str9);
                        if (strM2 != null) {
                            if (!this.g2) {
                                this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                            }
                            str7 = string4;
                            str8 = str9;
                            string = string3;
                            str6 = "'";
                            str5 = "0";
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Error:");
                        if (strM2 != null) {
                            strM2 = strM2.substring(0, 20);
                        }
                        sb5.append(strM2);
                        Toast.makeText(this, sb5.toString(), 0).show();
                        L1();
                        a1();
                        return;
                    }
                    jL2 = this.i.l2();
                    Z00 z00 = this.i;
                    int i9 = this.t;
                    jM2 = z00.m2(i9, this.S.isChecked() ? 1 : 0, this.l);
                    this.y0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + jM2);
                    if (this.R.isChecked()) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                    if (this.y0.getText().toString().length() > 0) {
                        if (this.i.j2(jL2, this.t, 0, this.V.getText().toString(), jM2 + "", "") > 0) {
                            this.y0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                            return;
                        }
                    } else if (this.i.j2(jL2, this.t, 0, this.V.getText().toString(), this.y0.getText().toString(), "") > 0) {
                        this.y0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                        return;
                    }
                    if (this.t == 21) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("insert into bills (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,param1,t_val,tax_amount,cost2,user_id) values(");
                        sb6.append(jL2);
                        sb6.append(",");
                        sb6.append(i2);
                        sb6.append(",'");
                        sb6.append((Object) this.T.getText());
                        sb6.append("','");
                        sb6.append(this.g0.getText().toString().replaceAll(",", ""));
                        sb6.append("','");
                        sb6.append(this.a0.getText().toString().replaceAll(",", ""));
                        sb6.append("',(select id from customers where name='");
                        sb6.append((Object) this.X.getText());
                        sb6.append("'  ),");
                        sb6.append(i);
                        sb6.append(",");
                        sb6.append(i6);
                        sb6.append(",'");
                        if (this.y0.getText().toString().length() == 0) {
                            string7 = jM2 + "";
                        } else {
                            string7 = this.y0.getText().toString();
                        }
                        sb6.append(string7);
                        sb6.append("','");
                        sb6.append((Object) this.z0.getText());
                        sb6.append("',(select id from currency where name='");
                        sb6.append(this.p0.getText().toString());
                        sb6.append("') ,(select id from branches where name='");
                        sb6.append(this.V.getText().toString());
                        sb6.append("'),(select id from customers where name='");
                        sb6.append(this.q0.getText().toString());
                        sb6.append("'),");
                        sb6.append(this.S.isChecked() ? 1 : 0);
                        sb6.append(",");
                        if (this.S.isChecked()) {
                            objValueOf5 = Long.valueOf(this.b1);
                        } else {
                            objValueOf5 = "0";
                        }
                        sb6.append(objValueOf5);
                        sb6.append(",'");
                        if (this.R0.getTag() != null) {
                            string8 = this.R0.getTag().toString();
                        } else {
                            string8 = "";
                        }
                        sb6.append(string8);
                        sb6.append("','");
                        sb6.append(this.d0.getText().toString().replaceAll(",", ""));
                        sb6.append("','");
                        sb6.append(this.e0.getText().toString().replaceAll(",", ""));
                        sb6.append("','");
                        sb6.append(this.c0.getText().toString().replaceAll(",", ""));
                        sb6.append("',");
                        i8 = C2160f10.h;
                        if (i8 == -1) {
                            objValueOf6 = "null";
                        } else {
                            objValueOf6 = Integer.valueOf(i8);
                        }
                        sb6.append(objValueOf6);
                        sb6.append(")");
                        String string9 = sb6.toString();
                        str11 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark,b.unit_id,b.u_val,b.base_unit,qty_pr,e_date  from items_temp b ";
                        string6 = string9;
                        str10 = "0";
                    } else {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("insert into bills(id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,online,t_val,tax_amount,cost2,user_id) values(");
                        sb7.append(jL2);
                        sb7.append(",");
                        sb7.append(i2);
                        sb7.append(",'");
                        sb7.append((Object) this.T.getText());
                        sb7.append("','");
                        sb7.append(this.g0.getText().toString().replaceAll(",", ""));
                        sb7.append("','");
                        sb7.append(this.a0.getText().toString().replaceAll(",", ""));
                        sb7.append("',(select id from customers where name='");
                        sb7.append((Object) this.X.getText());
                        sb7.append("'  ),");
                        sb7.append(i);
                        sb7.append(",");
                        sb7.append(i6);
                        sb7.append(",'");
                        if (this.y0.getText().toString().length() == 0) {
                            string5 = jM2 + "";
                        } else {
                            string5 = this.y0.getText().toString();
                        }
                        sb7.append(string5);
                        sb7.append("','");
                        sb7.append((Object) this.z0.getText());
                        sb7.append("',(select id from currency where name='");
                        sb7.append(this.p0.getText().toString());
                        sb7.append("'),(select id from branches where name='");
                        sb7.append(this.V.getText().toString());
                        sb7.append("'),(select id from customers where name='");
                        sb7.append(this.q0.getText().toString());
                        sb7.append("'),");
                        sb7.append(this.S.isChecked() ? 1 : 0);
                        sb7.append(",");
                        if (this.S.isChecked()) {
                            objValueOf3 = Long.valueOf(this.b1);
                        } else {
                            objValueOf3 = "0";
                        }
                        sb7.append(objValueOf3);
                        sb7.append(",");
                        str10 = "0";
                        sb7.append(str10);
                        sb7.append(",'");
                        sb7.append(this.d0.getText().toString().replaceAll(",", ""));
                        sb7.append("','");
                        sb7.append(this.e0.getText().toString().replaceAll(",", ""));
                        sb7.append("','");
                        sb7.append(this.c0.getText().toString().replaceAll(",", ""));
                        sb7.append("',");
                        i7 = C2160f10.h;
                        if (i7 == -1) {
                            objValueOf4 = "null";
                        } else {
                            objValueOf4 = Integer.valueOf(i7);
                        }
                        sb7.append(objValueOf4);
                        sb7.append(")");
                        string6 = sb7.toString();
                        str11 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    }
                    strL = this.i.L(string6, str11);
                    if (strL != null) {
                        this.i.v0("delete from items_temp");
                        this.p = jL2;
                        this.q = this.T.getText().toString();
                        str5 = str10;
                        string = string6;
                        str7 = str11;
                        str8 = "";
                        str6 = "'";
                        str4 = "' and date_='";
                    }
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("Error:");
                    if (strL != null) {
                        strL = strL.substring(0, 20);
                    }
                    sb8.append(strL);
                    Toast.makeText(this, sb8.toString(), 0).show();
                    return;
                    Log.d("sql1=", string);
                    Log.d("sql2=", str7);
                    Log.d("sql3=", str8);
                    if (!this.c0.getText().toString().replaceAll(",", "").equals(str5)) {
                        this.i.v0("update bills set cost2=cost2  where id='" + this.p + str4 + this.q + str6);
                    }
                    this.i.Zb();
                    N0();
                    Log.d("isnew=", this.z2 + ":" + this.p + ":" + this.w2);
                    if (this.p != 0) {
                    }
                    if (this.h2) {
                        g2();
                        return;
                    } else {
                        this.i.v0("delete from items_temp");
                        j1();
                        return;
                    }
                }
                try {
                    if (this.i.v8(this.X.getText().toString().trim(), this.t).getCount() == 0) {
                        AutoCompleteTextView autoCompleteTextView2 = this.X;
                        autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                        V0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.X.getText().toString(), this, this.X.getText().toString(), this.t);
                        if (!this.R1) {
                            return;
                        }
                    }
                    if (!this.X.getText().toString().equals(this.X.getText().toString().trim()) && this.i.v8(this.X.getText().toString().trim(), this.t).getCount() > 0) {
                        AutoCompleteTextView autoCompleteTextView3 = this.X;
                        autoCompleteTextView3.setText(autoCompleteTextView3.getText().toString().trim());
                    }
                    if (this.i.v8(this.X.getText().toString(), this.t).getCount() == 0) {
                        this.X.setError("Not Inserted!");
                        return;
                    }
                    this.i.D = false;
                    str = "0";
                    if (this.p0.getText() != null && !this.p0.getText().toString().equals(this.i.l3("0")) && this.i.Z2(this.p0.getText().toString(), this.T.getText().toString()) == 0) {
                        this.i.u(this, this.p0.getText().toString(), this.T.getText().toString(), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                        if (!this.i.D) {
                            return;
                        }
                    }
                    if (this.i.g2().getCount() == 0) {
                        this.m0.performClick();
                        return;
                    }
                    try {
                        try {
                            try {
                                if (this.p == 0) {
                                    G1();
                                    if (this.y0.getText().toString().length() <= 0 && this.i.j2(this.p, this.t, 0, this.V.getText().toString(), this.y0.getText().toString(), "") > 0) {
                                        this.y0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                                        return;
                                    }
                                    if (this.R.isChecked()) {
                                        i3 = 1;
                                    } else {
                                        i3 = 2;
                                    }
                                    if (this.t == 21) {
                                        str4 = "' and date_='";
                                        StringBuilder sb9 = new StringBuilder();
                                        sb9.append("update bills set date_='");
                                        sb9.append((Object) this.T.getText());
                                        sb9.append("',amount='");
                                        sb9.append(this.g0.getText().toString().replaceAll(",", ""));
                                        sb9.append("',d_amount='");
                                        sb9.append(this.a0.getText().toString().replaceAll(",", ""));
                                        sb9.append("',t_val='");
                                        sb9.append(this.d0.getText().toString().replaceAll(",", ""));
                                        sb9.append("',tax_amount='");
                                        sb9.append(this.e0.getText().toString().replaceAll(",", ""));
                                        sb9.append("',cost2='");
                                        sb9.append(this.c0.getText().toString().replaceAll(",", ""));
                                        sb9.append("',cus_id=(select id from customers where name='");
                                        sb9.append((Object) this.X.getText());
                                        sb9.append("' ),br_id=(select id from branches where name='");
                                        sb9.append((Object) this.V.getText());
                                        sb9.append("' ),cash_id=(select id from customers where name='");
                                        sb9.append((Object) this.q0.getText());
                                        sb9.append("' ),bill_type=");
                                        sb9.append(i3);
                                        sb9.append(",bill_no2='");
                                        sb9.append((Object) this.y0.getText());
                                        sb9.append("',is_back='");
                                        sb9.append(this.S.isChecked() ? 1 : 0);
                                        sb9.append("',remarks='");
                                        sb9.append(this.z0.getText().toString());
                                        sb9.append("',curr_id=(select id from currency where name='");
                                        sb9.append(this.p0.getText().toString());
                                        sb9.append("') ,tran_status=");
                                        sb9.append(i);
                                        sb9.append(",online=");
                                        str5 = "0";
                                        sb9.append(str5);
                                        sb9.append(",last_user=");
                                        i4 = C2160f10.h;
                                        if (i4 == -1) {
                                            objValueOf = "null";
                                        } else {
                                            objValueOf = Integer.valueOf(i4);
                                        }
                                        sb9.append(objValueOf);
                                        sb9.append(" where id='");
                                        sb9.append(this.p);
                                        sb9.append(str4);
                                        sb9.append(this.q);
                                        str6 = "'";
                                        sb9.append(str6);
                                        string = sb9.toString();
                                        str7 = "delete from bill_transactions  where bill_id='" + this.p + str6;
                                        str8 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id, ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0) ,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                                        strM = this.i.M(string, str7, str8);
                                        if (strM != null && strM.equals("1")) {
                                            if (!this.g2) {
                                                this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                            }
                                        }
                                        StringBuilder sb10 = new StringBuilder();
                                        sb10.append("Error:");
                                        if (strM != null && strM.length() > 20) {
                                            strM = strM.substring(0, 20);
                                        }
                                        sb10.append(strM);
                                        Toast.makeText(this, sb10.toString(), 0).show();
                                        L1();
                                        a1();
                                        return;
                                    }
                                    StringBuilder sb11 = new StringBuilder();
                                    sb11.append("update bills set date_='");
                                    sb11.append((Object) this.T.getText());
                                    sb11.append("',amount='");
                                    sb11.append(this.g0.getText().toString().replaceAll(",", ""));
                                    sb11.append("',d_amount='");
                                    sb11.append(this.a0.getText().toString().replaceAll(",", ""));
                                    sb11.append("',t_val='");
                                    sb11.append(this.d0.getText().toString().replaceAll(",", ""));
                                    sb11.append("',tax_amount='");
                                    sb11.append(this.e0.getText().toString().replaceAll(",", ""));
                                    sb11.append("',cost2='");
                                    sb11.append(this.c0.getText().toString().replaceAll(",", ""));
                                    sb11.append("',cus_id=(select id from customers where name='");
                                    sb11.append((Object) this.X.getText());
                                    sb11.append("' ),br_id=(select id from branches where name='");
                                    sb11.append((Object) this.V.getText());
                                    sb11.append("' ),cash_id=(select id from customers where name='");
                                    sb11.append((Object) this.q0.getText());
                                    sb11.append("' ),bill_type=");
                                    sb11.append(i3);
                                    sb11.append(",bill_no2='");
                                    sb11.append((Object) this.y0.getText());
                                    sb11.append("',is_back='");
                                    sb11.append(this.S.isChecked() ? 1 : 0);
                                    sb11.append("',remarks='");
                                    sb11.append(this.z0.getText().toString());
                                    sb11.append("',param1='");
                                    if (this.R0.getTag() != null) {
                                        string2 = this.R0.getTag().toString();
                                    } else {
                                        string2 = "";
                                    }
                                    sb11.append(string2);
                                    sb11.append("',curr_id=(select id from currency where name='");
                                    sb11.append(this.p0.getText().toString());
                                    sb11.append("') ,tran_status=");
                                    sb11.append(i);
                                    sb11.append(" ,last_user=");
                                    i5 = C2160f10.h;
                                    if (i5 == -1) {
                                        objValueOf2 = "null";
                                    } else {
                                        objValueOf2 = Integer.valueOf(i5);
                                    }
                                    sb11.append(objValueOf2);
                                    sb11.append(" where id='");
                                    sb11.append(this.p);
                                    str4 = "' and date_='";
                                    sb11.append(str4);
                                    sb11.append(this.q);
                                    sb11.append("'");
                                    string3 = sb11.toString();
                                    StringBuilder sb12 = new StringBuilder();
                                    sb12.append("delete from bill_transactions  where bill_id='");
                                    sb12.append(this.p);
                                    sb12.append("'");
                                    string4 = sb12.toString();
                                    str9 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.p + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark ,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                                    strM2 = this.i.M(string3, string4, str9);
                                    if (strM2 != null && strM2.equals("1")) {
                                        if (!this.g2) {
                                            this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                        }
                                        str7 = string4;
                                        str8 = str9;
                                        string = string3;
                                        str6 = "'";
                                        str5 = "0";
                                    }
                                    StringBuilder sb13 = new StringBuilder();
                                    sb13.append("Error:");
                                    if (strM2 != null && strM2.length() > 20) {
                                        strM2 = strM2.substring(0, 20);
                                    }
                                    sb13.append(strM2);
                                    Toast.makeText(this, sb13.toString(), 0).show();
                                    L1();
                                    a1();
                                    return;
                                }
                                jL2 = this.i.l2();
                                Z00 z01 = this.i;
                                int i10 = this.t;
                                jM2 = z01.m2(i10, this.S.isChecked() ? 1 : 0, this.l);
                                this.y0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + jM2);
                                if (this.R.isChecked()) {
                                    i6 = 1;
                                } else {
                                    i6 = 2;
                                }
                                if (this.y0.getText().toString().length() > 0) {
                                    if (this.i.j2(jL2, this.t, 0, this.V.getText().toString(), jM2 + "", "") > 0) {
                                        this.y0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                                        return;
                                    }
                                } else if (this.i.j2(jL2, this.t, 0, this.V.getText().toString(), this.y0.getText().toString(), "") > 0) {
                                    this.y0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                                    return;
                                }
                                if (this.t == 21) {
                                    StringBuilder sb14 = new StringBuilder();
                                    sb14.append("insert into bills (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,param1,t_val,tax_amount,cost2,user_id) values(");
                                    sb14.append(jL2);
                                    sb14.append(",");
                                    sb14.append(i2);
                                    sb14.append(",'");
                                    sb14.append((Object) this.T.getText());
                                    sb14.append("','");
                                    sb14.append(this.g0.getText().toString().replaceAll(",", ""));
                                    sb14.append("','");
                                    sb14.append(this.a0.getText().toString().replaceAll(",", ""));
                                    sb14.append("',(select id from customers where name='");
                                    sb14.append((Object) this.X.getText());
                                    sb14.append("'  ),");
                                    sb14.append(i);
                                    sb14.append(",");
                                    sb14.append(i6);
                                    sb14.append(",'");
                                    if (this.y0.getText().toString().length() == 0) {
                                        string7 = jM2 + "";
                                    } else {
                                        string7 = this.y0.getText().toString();
                                    }
                                    sb14.append(string7);
                                    sb14.append("','");
                                    sb14.append((Object) this.z0.getText());
                                    sb14.append("',(select id from currency where name='");
                                    sb14.append(this.p0.getText().toString());
                                    sb14.append("') ,(select id from branches where name='");
                                    sb14.append(this.V.getText().toString());
                                    sb14.append("'),(select id from customers where name='");
                                    sb14.append(this.q0.getText().toString());
                                    sb14.append("'),");
                                    sb14.append(this.S.isChecked() ? 1 : 0);
                                    sb14.append(",");
                                    if (this.S.isChecked()) {
                                        objValueOf5 = "0";
                                    } else {
                                        objValueOf5 = Long.valueOf(this.b1);
                                    }
                                    sb14.append(objValueOf5);
                                    sb14.append(",'");
                                    if (this.R0.getTag() != null) {
                                        string8 = this.R0.getTag().toString();
                                    } else {
                                        string8 = "";
                                    }
                                    sb14.append(string8);
                                    sb14.append("','");
                                    sb14.append(this.d0.getText().toString().replaceAll(",", ""));
                                    sb14.append("','");
                                    sb14.append(this.e0.getText().toString().replaceAll(",", ""));
                                    sb14.append("','");
                                    sb14.append(this.c0.getText().toString().replaceAll(",", ""));
                                    sb14.append("',");
                                    i8 = C2160f10.h;
                                    if (i8 == -1) {
                                        objValueOf6 = "null";
                                    } else {
                                        objValueOf6 = Integer.valueOf(i8);
                                    }
                                    sb14.append(objValueOf6);
                                    sb14.append(")");
                                    String string10 = sb14.toString();
                                    str11 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark,b.unit_id,b.u_val,b.base_unit,qty_pr,e_date  from items_temp b ";
                                    string6 = string10;
                                    str10 = "0";
                                } else {
                                    StringBuilder sb15 = new StringBuilder();
                                    sb15.append("insert into bills(id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,online,t_val,tax_amount,cost2,user_id) values(");
                                    sb15.append(jL2);
                                    sb15.append(",");
                                    sb15.append(i2);
                                    sb15.append(",'");
                                    sb15.append((Object) this.T.getText());
                                    sb15.append("','");
                                    sb15.append(this.g0.getText().toString().replaceAll(",", ""));
                                    sb15.append("','");
                                    sb15.append(this.a0.getText().toString().replaceAll(",", ""));
                                    sb15.append("',(select id from customers where name='");
                                    sb15.append((Object) this.X.getText());
                                    sb15.append("'  ),");
                                    sb15.append(i);
                                    sb15.append(",");
                                    sb15.append(i6);
                                    sb15.append(",'");
                                    if (this.y0.getText().toString().length() == 0) {
                                        string5 = jM2 + "";
                                    } else {
                                        string5 = this.y0.getText().toString();
                                    }
                                    sb15.append(string5);
                                    sb15.append("','");
                                    sb15.append((Object) this.z0.getText());
                                    sb15.append("',(select id from currency where name='");
                                    sb15.append(this.p0.getText().toString());
                                    sb15.append("'),(select id from branches where name='");
                                    sb15.append(this.V.getText().toString());
                                    sb15.append("'),(select id from customers where name='");
                                    sb15.append(this.q0.getText().toString());
                                    sb15.append("'),");
                                    sb15.append(this.S.isChecked() ? 1 : 0);
                                    sb15.append(",");
                                    if (this.S.isChecked()) {
                                        objValueOf3 = "0";
                                    } else {
                                        objValueOf3 = Long.valueOf(this.b1);
                                    }
                                    sb15.append(objValueOf3);
                                    sb15.append(",");
                                    str10 = "0";
                                    sb15.append(str10);
                                    sb15.append(",'");
                                    sb15.append(this.d0.getText().toString().replaceAll(",", ""));
                                    sb15.append("','");
                                    sb15.append(this.e0.getText().toString().replaceAll(",", ""));
                                    sb15.append("','");
                                    sb15.append(this.c0.getText().toString().replaceAll(",", ""));
                                    sb15.append("',");
                                    i7 = C2160f10.h;
                                    if (i7 == -1) {
                                        objValueOf4 = "null";
                                    } else {
                                        objValueOf4 = Integer.valueOf(i7);
                                    }
                                    sb15.append(objValueOf4);
                                    sb15.append(")");
                                    string6 = sb15.toString();
                                    str11 = "insert into bill_transactions(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + jL2 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.a0.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.Y.getText().toString().replaceAll(",", "") + "+" + this.a0.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                                }
                                strL = this.i.L(string6, str11);
                                if (strL != null && strL.equals("1")) {
                                    this.i.v0("delete from items_temp");
                                    this.p = jL2;
                                    this.q = this.T.getText().toString();
                                    str5 = str10;
                                    string = string6;
                                    str7 = str11;
                                    str8 = "";
                                    str6 = "'";
                                    str4 = "' and date_='";
                                }
                                StringBuilder sb16 = new StringBuilder();
                                sb16.append("Error:");
                                if (strL != null && strL.length() > 20) {
                                    strL = strL.substring(0, 20);
                                }
                                sb16.append(strL);
                                Toast.makeText(this, sb16.toString(), 0).show();
                                return;
                                Log.d("sql1=", string);
                                Log.d("sql2=", str7);
                                Log.d("sql3=", str8);
                                if (!this.c0.getText().toString().replaceAll(",", "").equals(str5)) {
                                    this.i.v0("update bills set cost2=cost2  where id='" + this.p + str4 + this.q + str6);
                                }
                                this.i.Zb();
                                N0();
                                Log.d("isnew=", this.z2 + ":" + this.p + ":" + this.w2);
                                if (this.p != 0 || this.z2 != 2 || this.R.isChecked()) {
                                    if (this.h2) {
                                        g2();
                                        return;
                                    } else {
                                        this.i.v0("delete from items_temp");
                                        j1();
                                        return;
                                    }
                                }
                                this.B2 = 0;
                                D2 = true;
                                f1(this.X.getText().toString());
                                String str12 = this.o2;
                                if (str12 == null) {
                                    j1();
                                    return;
                                }
                                Z1(str12);
                                L1();
                                a1();
                                return;
                            } catch (Exception e) {
                                exc = e;
                                str = str3;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = str2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    exc = e4;
                    str = "Error:";
                }
                Log.d("bill_save_error", exc.getMessage() + "");
                exc.printStackTrace();
                StringBuilder sb17 = new StringBuilder();
                sb17.append(str);
                if (exc.getMessage() != null || exc.getMessage().length() <= 20) {
                    message = exc.getMessage();
                } else {
                    message = exc.getMessage().substring(0, 20);
                }
                sb17.append(message);
                Toast.makeText(this, sb17.toString(), 1).show();
            }
            return;
        } catch (Exception e5) {
            e = e5;
            str = "Error:";
        }
        exc = e;
        Log.d("bill_save_error", exc.getMessage() + "");
        exc.printStackTrace();
        StringBuilder sb18 = new StringBuilder();
        sb18.append(str);
        if (exc.getMessage() != null) {
            message = exc.getMessage();
        } else {
            message = exc.getMessage();
        }
        sb18.append(message);
        Toast.makeText(this, sb18.toString(), 1).show();
    }

    public void y1(String str) {
        try {
            C0809Ov c0809Ov = this.A0;
            if (c0809Ov != null) {
                c0809Ov.getFilter().filter(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void z0(EditText editText) {
        Intent intent = new Intent(this, (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", editText.getText().toString());
        startActivityForResult(intent, 2);
    }
}
