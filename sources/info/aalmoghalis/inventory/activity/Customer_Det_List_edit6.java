package info.aalmoghalis.inventory.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0634Jt;
import defpackage.C0809Ov;
import defpackage.C0974Ur;
import defpackage.C1044Xj;
import defpackage.C2160f10;
import defpackage.C3874sM;
import defpackage.C3966tX;
import defpackage.C4062ug;
import defpackage.C4064uh;
import defpackage.C4143vg;
import defpackage.MO;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.helper.Calculator;
import info.aalmoghalis.inventory.printBT.MainActivity;
import info.aalmoghalis.inventory.printBT.MainActivity2;
import info.aalmoghalis.inventory.threads.HelloService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

/* JADX INFO: loaded from: classes3.dex */
public class Customer_Det_List_edit6 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int v2;
    public ArrayAdapter A0;
    public int M;
    public int N;
    public int O;
    public boolean U1;
    public ArrayAdapter V;
    public ArrayAdapter W;
    public boolean W1;
    public ArrayAdapter X;
    public boolean X1;
    public String f2;
    public ArrayAdapter g1;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public Uri k2;
    public String l;
    public LinearLayout r0;
    public EditText r1;
    public LinearLayout s0;
    public EditText s1;
    public LinearLayout t0;
    public EditText t1;
    public EditText u1;
    public EditText v1;
    public C0809Ov x0;
    public SparseBooleanArray z0;
    public int n = 0;
    public String p = "";
    public String q = "";
    public int t = 10;
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
    public String F = null;
    public String G = null;
    public String H = null;
    public String I = null;
    public String J = "0";
    public String K = null;
    public int L = 0;
    public ListView P = null;
    public Toolbar Q = null;
    public SwitchCompat R = null;
    public TextView S = null;
    public TextView T = null;
    public TextView U = null;
    public AutoCompleteTextView Y = null;
    public TextView Z = null;
    public TextView a0 = null;
    public TextView b0 = null;
    public TextView c0 = null;
    public TextView d0 = null;
    public TextView e0 = null;
    public TextView f0 = null;
    public ImageView g0 = null;
    public ImageView h0 = null;
    public ImageView i0 = null;
    public ImageView j0 = null;
    public TextView k0 = null;
    public TextView l0 = null;
    public ArrayList m0 = new ArrayList();
    public ArrayList n0 = new ArrayList();
    public ArrayList o0 = new ArrayList();
    public ArrayList p0 = new ArrayList();
    public ImageView q0 = null;
    public TextView u0 = null;
    public EditText v0 = null;
    public EditText w0 = null;
    public List y0 = new ArrayList();
    public ImageButton B0 = null;
    public int C0 = 0;
    public String[] D0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] E0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String F0 = "";
    public LinearLayout G0 = null;
    public LinearLayout H0 = null;
    public LinearLayout I0 = null;
    public int J0 = 0;
    public boolean K0 = false;
    public TextWatcher L0 = new B0();
    public int M0 = 0;
    public String N0 = "";
    public String O0 = "";
    public final Context P0 = this;
    public int Q0 = 0;
    public int R0 = 0;
    public String S0 = "";
    public EditText T0 = null;
    public EditText U0 = null;
    public TextView V0 = null;
    public AutoCompleteTextView W0 = null;
    public EditText X0 = null;
    public EditText Y0 = null;
    public EditText Z0 = null;
    public AutoCompleteTextView a1 = null;
    public EditText b1 = null;
    public EditText c1 = null;
    public EditText d1 = null;
    public TextView e1 = null;
    public AutoCompleteTextView f1 = null;
    public Timer h1 = new Timer();
    public final long i1 = 1000;
    public View.OnClickListener j1 = new ViewOnClickListenerC2871u();
    public String k1 = null;
    public String l1 = null;
    public AutoCompleteTextView m1 = null;
    public ArrayList n1 = new ArrayList();
    public TextView o1 = null;
    public AutoCompleteTextView p1 = null;
    public String q1 = "";
    public Button w1 = null;
    public Button x1 = null;
    public Button y1 = null;
    public Button z1 = null;
    public ImageView A1 = null;
    public ImageView B1 = null;
    public ImageView C1 = null;
    public ImageView D1 = null;
    public AutoCompleteTextView E1 = null;
    public AutoCompleteTextView F1 = null;
    public LinearLayout G1 = null;
    public LinearLayout H1 = null;
    public LinearLayout I1 = null;
    public LinearLayout J1 = null;
    public LinearLayout K1 = null;
    public LinearLayout L1 = null;
    public LinearLayout M1 = null;
    public LinearLayout N1 = null;
    public boolean O1 = false;
    public boolean P1 = false;
    public TextWatcher Q1 = new F();
    public double R1 = 0.0d;
    public double S1 = 0.0d;
    public int T1 = 0;
    public int V1 = 1;
    public String Y1 = "";
    public String Z1 = "0";
    public DatePickerDialog.OnDateSetListener a2 = new w0();
    public DatePickerDialog.OnDateSetListener b2 = new x0();
    public DatePickerDialog.OnDateSetListener c2 = new y0();
    public boolean d2 = false;
    public int e2 = 0;
    public int g2 = 3;
    public int h2 = 4;
    public ActivityResultLauncher i2 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Zg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.U0((Uri) obj);
        }
    });
    public ActivityResultLauncher j2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new I0());
    public String l2 = null;
    public String m2 = null;
    public String n2 = null;
    public String o2 = null;
    public int p2 = 0;
    public boolean q2 = false;
    public int[] r2 = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public int s2 = 0;
    public int t2 = 0;
    public int u2 = 0;

    public class A implements View.OnClickListener {
        public A() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            if (customer_Det_List_edit6.j0(customer_Det_List_edit6.y1.getId())) {
                Customer_Det_List_edit6.this.J0(4);
                Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
                customer_Det_List_edit7.i.Kd(customer_Det_List_edit7, customer_Det_List_edit7.getString(info.aalmoghalis.inventory.R.string.move_inserted), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                Customer_Det_List_edit6.v2 = 3;
                Customer_Det_List_edit6.this.i1(true);
                Customer_Det_List_edit6.this.r1.setText("");
                Customer_Det_List_edit6.this.u2 = 1;
            }
        }
    }

    public class A0 implements Runnable {
        public final /* synthetic */ int a;

        public A0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == 4) {
                Customer_Det_List_edit6.this.r1.selectAll();
            }
        }
    }

    public class B implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public B(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit6.this.k0()) {
                this.a.dismiss();
                FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit6.this);
                Customer_Det_List_edit6.this.J0(2);
                Customer_Det_List_edit6.this.u2 = 1;
            }
        }
    }

    public class B0 implements TextWatcher {
        public B0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            if (customer_Det_List_edit6.K0) {
                customer_Det_List_edit6.K0 = false;
            } else {
                customer_Det_List_edit6.u2 = 1;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class C implements View.OnClickListener {
        public C() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.calc_pick_btn(view);
        }
    }

    public class C0 implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public C0(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.g0(view, this.a);
        }
    }

    public class D implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public D(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.g0(view, this.a);
        }
    }

    public class D0 implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public D0(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.g0(view, this.a);
        }
    }

    public class E implements View.OnTouchListener {
        public E() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit6.this.r1.getCompoundDrawables()[0] != null ? Customer_Det_List_edit6.this.r1.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit6.this.r1.getPaddingLeft() + Customer_Det_List_edit6.this.r1.getLeft()) {
                    Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit6.i.B(customer_Det_List_edit6.r1, customer_Det_List_edit6.O1);
                }
            }
            return false;
        }
    }

    public class E0 implements DialogInterface.OnClickListener {
        public E0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                customer_Det_List_edit6.i0(2, customer_Det_List_edit6.t);
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit6.this.getApplicationContext(), Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class F implements TextWatcher {
        public F() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            if (customer_Det_List_edit6.P1) {
                customer_Det_List_edit6.P1 = false;
                return;
            }
            if (customer_Det_List_edit6.r1.hasFocus()) {
                Customer_Det_List_edit6.this.t1(1);
            } else if (Customer_Det_List_edit6.this.s1.hasFocus()) {
                Customer_Det_List_edit6.this.t1(2);
            } else if (Customer_Det_List_edit6.this.t1.hasFocus()) {
                Customer_Det_List_edit6.this.t1(3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class F0 implements DialogInterface.OnClickListener {
        public F0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            if (customer_Det_List_edit6.t2 == 1) {
                customer_Det_List_edit6.finish();
            } else {
                customer_Det_List_edit6.u2 = 0;
            }
        }
    }

    public class G implements AdapterView.OnItemClickListener {
        public G() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit6.this.p1.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit6.this.r1.requestFocus();
            Customer_Det_List_edit6.this.K0();
            Customer_Det_List_edit6.this.r1.selectAll();
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            customer_Det_List_edit6.j1(0, customer_Det_List_edit6.p1.getText().toString(), Customer_Det_List_edit6.this.k0.getText().toString());
        }
    }

    public class G0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public G0(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit6.this);
                if (this.a[i].equals(Customer_Det_List_edit6.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit6.f2 = customer_Det_List_edit6.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit6.this.l0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit6.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit7.f2 = customer_Det_List_edit7.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit6.this.C0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit6.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit6.this.i.qa(Z00.M + Customer_Det_List_edit6.this.D1.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit6.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit6.this.D1.setTag(null);
                    Customer_Det_List_edit6.this.D1.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class H implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public H(TextView textView, ImageView imageView) {
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
                Customer_Det_List_edit6.this.i.v0("update categ set fav=" + str + " where name = '" + this.a.getText().toString() + "'");
                Customer_Det_List_edit6.this.n = 0;
                Customer_Det_List_edit6.this.J0(1);
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit6.this.getApplicationContext(), Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class H0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public H0(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit6.this);
                if (this.a[i].equals(Customer_Det_List_edit6.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit6.f2 = customer_Det_List_edit6.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit6.this.l0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit6.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit7.f2 = customer_Det_List_edit7.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit6.this.C0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit6.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit6.this.i.qa(Z00.M + Customer_Det_List_edit6.this.C1.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit6.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit6.this.C1.setTag(null);
                    Customer_Det_List_edit6.this.C1.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Customer_Det_List_edit6.this.C1.getLayoutParams().width = (int) Customer_Det_List_edit6.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Customer_Det_List_edit6.this.C1.getLayoutParams().height = (int) Customer_Det_List_edit6.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class I implements DialogInterface.OnClickListener {
        public I() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class I0 implements ActivityResultCallback {
        public I0() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Customer_Det_List_edit6.this.m1();
            }
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
                    Customer_Det_List_edit6.this.i.v0("delete from tr_p_temps  where no_=  '" + this.a.getText().toString() + "'");
                    Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit6.Q0 = 1;
                    customer_Det_List_edit6.J0(2);
                    Customer_Det_List_edit6.this.w0();
                }
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit6.this.getApplicationContext(), Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
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

    public class L extends Handler {
        public L() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class M implements CompoundButton.OnCheckedChangeListener {
        public M() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            int i = 1;
            customer_Det_List_edit6.u2 = 1;
            customer_Det_List_edit6.u1();
            if (Customer_Det_List_edit6.this.t != 13) {
                i = Customer_Det_List_edit6.this.t == 10 ? -1 : 0;
            }
            if (Customer_Det_List_edit6.this.n != 0) {
                Customer_Det_List_edit6.this.i.v0("update tr_p_temps set tr_type=" + Customer_Det_List_edit6.this.t + ",in_=" + i + " where bill_id=-6 and p_id=" + Customer_Det_List_edit6.this.n);
            } else {
                Customer_Det_List_edit6.this.i.v0("update tr_p_temps set tr_type=" + Customer_Det_List_edit6.this.t + ",in_=" + i + " where bill_id=-6");
            }
            Customer_Det_List_edit6.this.J0(4);
            Customer_Det_List_edit6.this.Z0();
        }
    }

    public class N implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public N(Handler handler, String str, int i) {
            this.a = handler;
            this.b = str;
            this.c = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit6.this.c0(this.a, this.b, this.c);
        }
    }

    public class O implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public O(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit6.this.U1 = false;
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
            Customer_Det_List_edit6.this.d0(this.a);
        }
    }

    public class R implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public R(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit6.this.U1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class S implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public S(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class T implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public T(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class U implements View.OnClickListener {
        public U() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.showDialog(0);
            Customer_Det_List_edit6.this.u2 = 1;
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
            Customer_Det_List_edit6.this.r0(this.a, this.b, null);
        }
    }

    public class W implements DialogInterface.OnClickListener {
        public W() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class X implements DialogInterface.OnClickListener {
        public X() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Y implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ android.app.AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ Handler e;

        public Y(AutoCompleteTextView autoCompleteTextView, android.app.AlertDialog alertDialog, String str, EditText editText, Handler handler) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
            this.c = str;
            this.d = editText;
            this.e = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (zA && Customer_Det_List_edit6.this.i.P5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Customer_Det_List_edit6.this.Y1 = this.a.getText().toString();
                Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                customer_Det_List_edit6.H0(customer_Det_List_edit6.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type), Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type) + "#" + Customer_Det_List_edit6.this.Y1, this.b.getContext());
                if (!Customer_Det_List_edit6.this.W1) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Customer_Det_List_edit6.this.i.H("insert into items (name,item_type_id) values('" + this.d.getText().toString() + "',(select b.id from item_type b where b.name='" + this.a.getText().toString() + "') )", "insert into item_price (item_id,curr_id,sls_u_price) values((select id from items a where a.name='" + this.d.getText().toString() + "'),(select b.id from currency b where b.name='" + Customer_Det_List_edit6.this.k0.getText().toString() + "'),'0' )");
                    Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit7.V1 = 0;
                    customer_Det_List_edit7.U1 = true;
                    Customer_Det_List_edit6.this.W0.setText(this.d.getText().toString());
                    Handler handler = this.e;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    public class Z extends Handler {
        public Z() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$a, reason: case insensitive filesystem */
    public class HandlerC2842a extends Handler {
        public HandlerC2842a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$a0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2843a0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2843a0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit6.this.i.v0("insert into item_type  (name )  values( '" + Customer_Det_List_edit6.this.Y1 + "'  )");
            Customer_Det_List_edit6.this.X1 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$b, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2844b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2844b(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit6.this.i.v0("insert into groups  (name )  values( '" + Customer_Det_List_edit6.this.Y1 + "'  )");
            Customer_Det_List_edit6.this.W1 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$b0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2845b0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2845b0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit6.this.X1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$c, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2846c implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2846c(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit6.this.W1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$c0, reason: case insensitive filesystem */
    public class C2847c0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2847c0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$d, reason: case insensitive filesystem */
    public class C2848d implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2848d(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$d0, reason: case insensitive filesystem */
    public class C2849d0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2849d0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
            if (adapterView.getItemAtPosition(i).toString().length() > 0) {
                this.b.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$e, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2850e implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnTouchListenerC2850e(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$e0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2851e0 implements View.OnClickListener {
        public ViewOnClickListenerC2851e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$f, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2852f implements View.OnClickListener {
        public ViewOnClickListenerC2852f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$f0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2853f0 implements View.OnClickListener {
        public ViewOnClickListenerC2853f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.K0 = true;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$g, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2854g implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2854g(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.r0(this.a, this.b, null);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$g0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2855g0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2855g0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.k1();
            Customer_Det_List_edit6.this.r0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$h, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2856h implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2856h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$h0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2857h0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2857h0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.k1();
            Customer_Det_List_edit6.this.r0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$i, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2858i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2858i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$i0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2859i0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2859i0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2860j implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ AlertDialog d;

        public ViewOnClickListenerC2860j(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, AlertDialog alertDialog) {
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
            if (zA && Customer_Det_List_edit6.this.i.Q5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Customer_Det_List_edit6.this.Y1 = this.b.getText().toString();
                Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                customer_Det_List_edit6.I0(customer_Det_List_edit6.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit6.this.Y1, Customer_Det_List_edit6.this);
                if (!Customer_Det_List_edit6.this.W1) {
                    return;
                }
            }
            if (zA) {
                Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
                if (customer_Det_List_edit7.l2 != null) {
                    customer_Det_List_edit7.i.v0("update customers set name='" + this.c.getText().toString().trim() + "',gsm='" + this.a.getText().toString() + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id=(select b.id from customers b where b.name='" + this.c.getText().toString() + "')");
                    Customer_Det_List_edit6.this.o2 = this.a.getText().toString();
                    Customer_Det_List_edit6 customer_Det_List_edit8 = Customer_Det_List_edit6.this;
                    C4064uh c4064uhO0 = customer_Det_List_edit8.i.O0(customer_Det_List_edit8.l2, customer_Det_List_edit8.k0.getText().toString());
                    Customer_Det_List_edit6 customer_Det_List_edit9 = Customer_Det_List_edit6.this;
                    Z00 z00 = customer_Det_List_edit9.i;
                    z00.Rc(customer_Det_List_edit9.o2, z00.zd(c4064uhO0, customer_Det_List_edit9.l2, Double.parseDouble(c4064uhO0.c().replaceAll(",", ""))));
                }
                this.d.dismiss();
            }
        }
    }

    public class j0 implements DialogInterface.OnClickListener {
        public j0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$k, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2861k implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2861k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit6.this.i.v0("delete from transactions where p_id='" + Customer_Det_List_edit6.this.n + "' and p_id<>0  and bill_id=-6  and p_date='" + Customer_Det_List_edit6.this.p + "' and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + Customer_Det_List_edit6.this.q + "' ");
                FragmentStatePagerSupport_Main.a0 = true;
                Bill_edit.P2 = true;
                Customer_Det_List_edit6.this.b1();
                Daily_Curr_Report.l0 = Daily_Curr_Report.l0 - 1;
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit6.this.getApplicationContext(), "SQL Error.", 1);
            }
        }
    }

    public class k0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ Handler h;

        public k0(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, AlertDialog alertDialog, EditText editText2, EditText editText3, Handler handler) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = autoCompleteTextView2;
            this.d = str;
            this.e = alertDialog;
            this.f = editText2;
            this.g = editText3;
            this.h = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            boolean z = false;
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            if (Customer_Det_List_edit6.this.i.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit6.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit6.this.Y1 = this.b.getText().toString();
                Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                customer_Det_List_edit6.G0(customer_Det_List_edit6.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit6.this.Y1, Customer_Det_List_edit6.this);
                if (!Customer_Det_List_edit6.this.U1) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit6.this.i.r1(this.c.getText().toString());
                if (this.d.equals("0")) {
                    if (Customer_Det_List_edit6.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
                        customer_Det_List_edit7.i.Pd(customer_Det_List_edit7, customer_Det_List_edit7.P, this.a.getText().toString().trim() + " : " + Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit6.this);
                        this.e.dismiss();
                        return;
                    }
                    Customer_Det_List_edit6.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.f.getText().toString() + "','" + this.g.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                    Handler handler = this.h;
                    handler.sendMessage(handler.obtainMessage());
                } else if (this.d != null) {
                    Customer_Det_List_edit6.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.f.getText().toString() + "',address='" + this.g.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit6.this.j + "' and id>0 ");
                    Handler handler2 = this.h;
                    handler2.sendMessage(handler2.obtainMessage());
                }
                this.e.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$l, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2862l implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2862l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class l0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ EditText c;

        public l0(AutoCompleteTextView autoCompleteTextView, Dialog dialog, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = dialog;
            this.c = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
            this.b.dismiss();
            if (this.c != null) {
                if (this.a.getId() == info.aalmoghalis.inventory.R.id.account_type || this.a.getId() == info.aalmoghalis.inventory.R.id.cus_group) {
                    this.c.requestFocus();
                    Customer_Det_List_edit6.this.k1();
                }
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$m, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2863m implements View.OnClickListener {
        public final /* synthetic */ Snackbar a;

        public ViewOnClickListenerC2863m(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Customer_Det_List_edit6.this.N0();
        }
    }

    public class m0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ArrayAdapter b;
        public final /* synthetic */ Dialog c;

        public m0(TextView textView, ArrayAdapter arrayAdapter, Dialog dialog) {
            this.a = textView;
            this.b = arrayAdapter;
            this.c = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getId() == Customer_Det_List_edit6.this.U.getId()) {
                if (i == this.b.getCount() - 1) {
                    Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit6.p1("0", "", "", customer_Det_List_edit6.i.T5("0"), "", Customer_Det_List_edit6.this.i.v1("121"));
                } else {
                    this.a.setText(adapterView.getItemAtPosition(i).toString());
                    if (Customer_Det_List_edit6.this.n == 0) {
                        Customer_Det_List_edit6.this.i.v0("update tr_p_temps set cash_id=" + Customer_Det_List_edit6.this.i.p4(this.a.getText().toString()) + " where p_id=" + Customer_Det_List_edit6.this.n);
                    } else {
                        Customer_Det_List_edit6.this.i.v0("update tr_p_temps set cash_id=" + Customer_Det_List_edit6.this.i.p4(this.a.getText().toString()));
                    }
                    Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
                    int iC3 = customer_Det_List_edit7.i.c3(customer_Det_List_edit7.t, -6, Customer_Det_List_edit6.this.U.getText().toString());
                    Customer_Det_List_edit6.this.v0.setHint(Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.bill_no2) + iC3);
                }
            } else if (this.a.getId() == Customer_Det_List_edit6.this.k0.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Customer_Det_List_edit6.this.k0.setTag(this.a.getText());
                Customer_Det_List_edit6.this.r1();
                Customer_Det_List_edit6 customer_Det_List_edit8 = Customer_Det_List_edit6.this;
                customer_Det_List_edit8.Q0 = 1;
                customer_Det_List_edit8.u2 = 1;
            } else if (this.a.getId() == Customer_Det_List_edit6.this.l0.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Customer_Det_List_edit6.this.l0.setTag(this.a.getText());
                Customer_Det_List_edit6.this.r1();
                Customer_Det_List_edit6 customer_Det_List_edit9 = Customer_Det_List_edit6.this;
                customer_Det_List_edit9.Q0 = 1;
                customer_Det_List_edit9.u2 = 1;
            }
            this.c.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$n, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2864n implements View.OnClickListener {
        public ViewOnClickListenerC2864n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.h1();
        }
    }

    public class n0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public n0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$o, reason: case insensitive filesystem */
    public class RunnableC2865o implements Runnable {
        public final /* synthetic */ Snackbar a;

        public RunnableC2865o(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.dismiss();
        }
    }

    public class o0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public o0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.dismissDropDown();
            if (adapterView.getItemAtPosition(i).toString().length() > 0) {
                this.b.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$p, reason: case insensitive filesystem */
    public class C2866p implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2866p(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            C4064uh c4064uhO0 = customer_Det_List_edit6.i.O0(customer_Det_List_edit6.l2, customer_Det_List_edit6.k0.getText().toString());
            if (i == 0) {
                Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
                customer_Det_List_edit7.s2 = 4;
                String str = customer_Det_List_edit7.o2;
                if (str == null || str.length() < 3) {
                    Customer_Det_List_edit6 customer_Det_List_edit8 = Customer_Det_List_edit6.this;
                    String str2 = customer_Det_List_edit8.j;
                    Customer_Det_List_edit6 customer_Det_List_edit9 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit8.o1(str2, customer_Det_List_edit9.l2, customer_Det_List_edit9.o2, customer_Det_List_edit9.m2);
                } else {
                    Customer_Det_List_edit6 customer_Det_List_edit10 = Customer_Det_List_edit6.this;
                    Z00 z00 = customer_Det_List_edit10.i;
                    z00.Ed(customer_Det_List_edit10.o2, z00.zd(c4064uhO0, customer_Det_List_edit10.l2, Double.parseDouble(c4064uhO0.c().replaceAll(",", ""))));
                }
            } else if (i == 1) {
                Customer_Det_List_edit6 customer_Det_List_edit11 = Customer_Det_List_edit6.this;
                customer_Det_List_edit11.s2 = 3;
                String str3 = customer_Det_List_edit11.o2;
                if (str3 == null || str3.length() < 3) {
                    Customer_Det_List_edit6 customer_Det_List_edit12 = Customer_Det_List_edit6.this;
                    String str4 = customer_Det_List_edit12.j;
                    Customer_Det_List_edit6 customer_Det_List_edit13 = Customer_Det_List_edit6.this;
                    customer_Det_List_edit12.o1(str4, customer_Det_List_edit13.l2, customer_Det_List_edit13.o2, customer_Det_List_edit13.m2);
                } else {
                    Customer_Det_List_edit6 customer_Det_List_edit14 = Customer_Det_List_edit6.this;
                    Z00 z01 = customer_Det_List_edit14.i;
                    z01.Rc(customer_Det_List_edit14.o2, z01.zd(c4064uhO0, customer_Det_List_edit14.l2, Double.parseDouble(c4064uhO0.c().replaceAll(",", ""))));
                }
            } else if (i == 2) {
                Customer_Det_List_edit6.this.X0(2);
            }
            this.a.dismiss();
        }
    }

    public class p0 implements View.OnClickListener {
        public p0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$q, reason: case insensitive filesystem */
    public class C2867q implements AdapterView.OnItemClickListener {
        public C2867q() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit6.this.W0.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            customer_Det_List_edit6.A = customer_Det_List_edit6.W0.getText().toString();
            Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
            customer_Det_List_edit7.E = "";
            customer_Det_List_edit7.F = "";
            customer_Det_List_edit7.G = "";
            customer_Det_List_edit7.H = "";
            customer_Det_List_edit7.D = "";
            customer_Det_List_edit7.I = "";
            Customer_Det_List_edit6.v2 = 1;
            customer_Det_List_edit7.A0(true);
            Customer_Det_List_edit6 customer_Det_List_edit8 = Customer_Det_List_edit6.this;
            customer_Det_List_edit8.j1(0, customer_Det_List_edit8.W0.getText().toString(), Customer_Det_List_edit6.this.k0.getText().toString());
        }
    }

    public class q0 implements View.OnClickListener {
        public q0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6.this.K0 = true;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$r, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2868r implements View.OnTouchListener {
        public ViewOnTouchListenerC2868r() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Customer_Det_List_edit6.this.W0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit6.this.W0.getCompoundDrawables()[0] != null ? Customer_Det_List_edit6.this.W0.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit6.this.W0.getPaddingLeft() + Customer_Det_List_edit6.this.W0.getLeft()) {
                    Customer_Det_List_edit6.this.W0.setText("");
                    Customer_Det_List_edit6.this.W0.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Customer_Det_List_edit6.this.W0.getRight();
                Customer_Det_List_edit6.this.W0.getPaddingRight();
                if (Customer_Det_List_edit6.this.W0.getCompoundDrawables()[2] != null) {
                    Customer_Det_List_edit6.this.W0.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class r0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public r0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            customer_Det_List_edit6.i.Md(customer_Det_List_edit6);
            Customer_Det_List_edit6.this.r0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$s, reason: case insensitive filesystem */
    public class C2869s implements TextWatcher {
        public C2869s() {
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
                Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                customer_Det_List_edit6.W0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit6, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit6.this.W0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit6.this.W0;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class s0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public s0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            customer_Det_List_edit6.i.Md(customer_Det_List_edit6);
            Customer_Det_List_edit6.this.r0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$t, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2870t implements View.OnClickListener {
        public ViewOnClickListenerC2870t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
            Z00 z00 = customer_Det_List_edit7.i;
            customer_Det_List_edit6.W = new ArrayAdapter(customer_Det_List_edit7, android.R.layout.simple_spinner_dropdown_item, z00.t3(z00.l3("0")));
            Customer_Det_List_edit6 customer_Det_List_edit8 = Customer_Det_List_edit6.this;
            customer_Det_List_edit8.s0(customer_Det_List_edit8.W, Customer_Det_List_edit6.this.k0);
        }
    }

    public class t0 implements DialogInterface.OnClickListener {
        public t0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$u, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2871u implements View.OnClickListener {
        public ViewOnClickListenerC2871u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_fwd_amount) {
                Customer_Det_List_edit6.this.amount_fwd_btn(view);
            } else if (view.getId() == info.aalmoghalis.inventory.R.id.img_u_currency) {
                Customer_Det_List_edit6.this.u_currency_btn(view);
            }
        }
    }

    public class u0 implements DialogInterface.OnClickListener {
        public u0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$v, reason: case insensitive filesystem */
    public class HandlerC2872v extends Handler {
        public HandlerC2872v() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class v0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ AlertDialog g;

        public v0(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, EditText editText2, EditText editText3, AlertDialog alertDialog) {
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
            boolean z = false;
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            if (Customer_Det_List_edit6.this.i.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit6.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit6.this.Y1 = this.b.getText().toString();
                Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                customer_Det_List_edit6.G0(customer_Det_List_edit6.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit6.this.Y1, Customer_Det_List_edit6.this);
                if (!Customer_Det_List_edit6.this.U1) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit6.this.i.r1(this.c.getText().toString());
                if (!this.d.equals("0")) {
                    if (this.d != null) {
                        Customer_Det_List_edit6.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.e.getText().toString() + "',address='" + this.f.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit6.this.j + "' and id>0 ");
                        this.g.dismiss();
                        return;
                    }
                    return;
                }
                if (Customer_Det_List_edit6.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                    FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit6.this);
                    this.a.setError(Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.exist));
                    return;
                }
                Customer_Det_List_edit6.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.e.getText().toString() + "','" + this.f.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                if (iR1 == 121 || iR1 == 122) {
                    Customer_Det_List_edit6.this.U.setText(this.a.getText().toString());
                }
                this.g.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$w, reason: case insensitive filesystem */
    public class C2873w implements AdapterView.OnItemClickListener {
        public C2873w() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                Customer_Det_List_edit6.this.J = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.no_)).getText().toString();
                Customer_Det_List_edit6.this.A = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_name)).getText().toString();
                Customer_Det_List_edit6.this.D = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_qty)).getText().toString();
                Customer_Det_List_edit6.this.E = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_price)).getText().toString();
                Customer_Det_List_edit6.this.G = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_weight)).getText().toString();
                C0634Jt c0634Jt = (C0634Jt) Customer_Det_List_edit6.this.P.getAdapter().getItem(i);
                if (c0634Jt != null) {
                    Customer_Det_List_edit6.this.K = c0634Jt.k();
                    Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                    String str = customer_Det_List_edit6.K;
                    if (str == null) {
                        str = "";
                    }
                    customer_Det_List_edit6.K = str;
                }
                Customer_Det_List_edit6.v2 = 2;
                Integer.parseInt(Customer_Det_List_edit6.this.J);
                C0634Jt c0634Jt2 = (C0634Jt) adapterView.getItemAtPosition(i);
                Customer_Det_List_edit6.this.B = c0634Jt2.j();
                Customer_Det_List_edit6.this.C = c0634Jt2.b();
                Customer_Det_List_edit6.this.I = c0634Jt2.j();
                Customer_Det_List_edit6.this.F = c0634Jt2.g();
                Customer_Det_List_edit6.this.H = c0634Jt2.m();
                Log.d("tr_curr_name=", Customer_Det_List_edit6.this.B + ":" + Customer_Det_List_edit6.this.F);
                Customer_Det_List_edit6.this.A0(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class w0 implements DatePickerDialog.OnDateSetListener {
        public w0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit6.this.M = i;
            Customer_Det_List_edit6.this.N = i2;
            Customer_Det_List_edit6.this.O = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit6.this.O)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit6.this.N + 1)) + "-" + Customer_Det_List_edit6.this.M;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit6.this.T.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
                Customer_Det_List_edit6.this.r1();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$x, reason: case insensitive filesystem */
    public class C2874x implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$x$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Customer_Det_List_edit6.this.x0();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit6.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$x$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2874x() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == info.aalmoghalis.inventory.R.id.menu_curr) {
                SparseBooleanArray sparseBooleanArrayB = Customer_Det_List_edit6.this.x0.b();
                Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
                customer_Det_List_edit6.z0 = sparseBooleanArrayB;
                try {
                    customer_Det_List_edit6.n1();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit6.this.getApplicationContext(), "SQL Error.", 1);
                }
                actionMode.finish();
                return false;
            }
            if (itemId != info.aalmoghalis.inventory.R.id.menu_delete) {
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB2 = Customer_Det_List_edit6.this.x0.b();
            Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
            customer_Det_List_edit7.z0 = sparseBooleanArrayB2;
            AlertDialog.Builder builder = new AlertDialog.Builder(customer_Det_List_edit7);
            builder.setMessage(Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
            builder.setPositiveButton(Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
            builder.setNegativeButton(Customer_Det_List_edit6.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
            builder.create().show();
            actionMode.finish();
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.contextual_action_bar_tr, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Customer_Det_List_edit6.this.P.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Customer_Det_List_edit6.this.x0.j.clear();
            Customer_Det_List_edit6.this.x0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Customer_Det_List_edit6.this.P.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Customer_Det_List_edit6.this.x0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Customer_Det_List_edit6.this.P.getCheckedItemCount() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_curr).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_curr).setVisible(true);
            }
            return false;
        }
    }

    public class x0 implements DatePickerDialog.OnDateSetListener {
        public x0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit6.this.M = i;
            Customer_Det_List_edit6.this.N = i2;
            Customer_Det_List_edit6.this.O = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit6.this.O)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit6.this.N + 1)) + "-" + Customer_Det_List_edit6.this.M;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit6.this.S.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$y, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2875y implements View.OnClickListener {
        public ViewOnClickListenerC2875y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
            customer_Det_List_edit6.X = new ArrayAdapter(customer_Det_List_edit7, android.R.layout.simple_spinner_dropdown_item, customer_Det_List_edit7.i.t3(customer_Det_List_edit7.k0.getText().toString()));
            Customer_Det_List_edit6 customer_Det_List_edit8 = Customer_Det_List_edit6.this;
            customer_Det_List_edit8.s0(customer_Det_List_edit8.X, Customer_Det_List_edit6.this.l0);
        }
    }

    public class y0 implements DatePickerDialog.OnDateSetListener {
        public y0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit6.this.M = i;
            Customer_Det_List_edit6.this.N = i2;
            Customer_Det_List_edit6.this.O = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit6.this.O)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit6.this.N + 1)) + "-" + Customer_Det_List_edit6.this.M;
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
                new SimpleDateFormat("dd-MM-yyyy", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit6$z, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2876z implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2876z(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit6 customer_Det_List_edit6 = Customer_Det_List_edit6.this;
            if (!customer_Det_List_edit6.j0(customer_Det_List_edit6.x1.getId())) {
                Customer_Det_List_edit6.this.J0(2);
                this.a.dismiss();
                return;
            }
            Customer_Det_List_edit6 customer_Det_List_edit7 = Customer_Det_List_edit6.this;
            customer_Det_List_edit7.i.Kd(customer_Det_List_edit7, customer_Det_List_edit7.getString(info.aalmoghalis.inventory.R.string.move_inserted), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            Customer_Det_List_edit6.this.J0(2);
            Customer_Det_List_edit6.v2 = 3;
            Customer_Det_List_edit6.this.i1(true);
            Customer_Det_List_edit6.this.r1.setText("");
            Customer_Det_List_edit6.this.u2 = 1;
            this.a.dismiss();
        }
    }

    public class z0 extends Handler {
        public z0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.i2.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.h2);
    }

    private boolean P0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean Q0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && P0(21, 22);
    }

    public static boolean R0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean S0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean T0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        W0(uri, true);
    }

    private void V0(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                v0(new File(Z00.A0), file2);
            } else {
                v0(new File(E0(this, this.k2)), file2);
            }
            f1(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void W0(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.i, this);
            if (strX != null) {
                f1(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c1(ImageView imageView) {
        this.T1 = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
        imageView.getLayoutParams().width = this.T1;
        imageView.getLayoutParams().height = this.T1;
    }

    private void d1() {
        String[] stringArray = this.D1.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new G0(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            m1();
            return;
        }
        int i = Integer.parseInt(this.i.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.i.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.j2.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean m0() {
        Log.d("IMEI=", "AFTER VALIDATION");
        boolean zA = AbstractC4371yX.a(this.r1);
        if (!AbstractC4371yX.a(this.s1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.t1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.p1)) {
            zA = false;
        }
        if (this.i.u3(this.p1.getText().toString()) != 0 || this.i.u3(this.p1.getText().toString().trim()) != 0) {
            return zA;
        }
        this.p1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
        return false;
    }

    private void n0() {
        if (this.i.u3(this.p1.getText().toString()) == 0 && this.i.u3(this.p1.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.p1;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.p1.getText().toString().length() >= 1 && this.w1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_add))) {
                F0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.p1.getText()), this, this.p1.getText().toString(), 0);
                this.A0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
                this.p1.setThreshold(1);
                this.p1.setAdapter(this.A0);
            }
        }
        if (!this.p1.getText().toString().equals(this.p1.getText().toString().trim()) && this.i.u3(this.p1.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView2 = this.p1;
            autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
        }
        this.i.D = false;
        if (this.k0.getText() != null && !this.k0.getText().toString().equals(this.i.l3("0")) && this.i.Z2(this.k0.getText().toString(), this.i.cc(this.T.getText().toString())) == 0) {
            this.i.u(this, this.k0.getText().toString(), this.i.cc(this.T.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
        }
        this.i.D = false;
        if (this.l0.getText() == null || this.l0.getText().toString().equals(this.i.l3("0")) || this.i.Z2(this.l0.getText().toString(), this.i.cc(this.T.getText().toString())) != 0) {
            return;
        }
        this.i.u(this, this.l0.getText().toString(), this.i.cc(this.T.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    private boolean o0() {
        boolean zA = AbstractC4371yX.a(this.r1);
        if (!AbstractC4371yX.a(this.s1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.t1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.p1)) {
            zA = false;
        }
        if (this.n != 0 && !AbstractC4371yX.a(this.v0)) {
            zA = false;
        }
        if (this.p1.getText().length() == 0) {
            zA = false;
        }
        if (this.i.u3(this.p1.getText().toString()) != 0 || this.i.u3(this.p1.getText().toString().trim()) != 0) {
            return zA;
        }
        this.p1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
        return false;
    }

    private boolean p0() {
        Log.d("save_trace=", "checkValidation_save_doc");
        boolean z = false;
        boolean z2 = this.n == 0 || AbstractC4371yX.a(this.v0);
        ArrayList arrayListI8 = this.i.I8("-6");
        this.n0 = arrayListI8;
        if (arrayListI8 != null && arrayListI8.size() > 0) {
            for (int i = 0; i < this.n0.size(); i++) {
                Log.d("curr_price=", "" + ((String) ((HashMap) this.n0.get(i)).get("price")) + ":" + ((String) ((HashMap) this.n0.get(i)).get("name")));
                if (Double.parseDouble((String) ((HashMap) this.n0.get(i)).get("price")) == 0.0d) {
                    this.j0.performClick();
                    z2 = false;
                    break;
                }
            }
        }
        if (this.i.Q()) {
            t0();
        } else {
            z = z2;
        }
        Log.d("save_trace=", "checkValidation_save_doc:" + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        if (this.R.isChecked()) {
            setTitle(getString(info.aalmoghalis.inventory.R.string.curr_in) + " " + getString(info.aalmoghalis.inventory.R.string.curr_title));
            this.t = 13;
            this.u0.setText(this.i.V8(13));
        } else {
            setTitle(getString(info.aalmoghalis.inventory.R.string.curr_out) + " " + getString(info.aalmoghalis.inventory.R.string.curr_title));
            this.t = 10;
            this.u0.setText(this.i.V8(10));
        }
        Z0();
    }

    private void v0(File file, File file2) throws IOException {
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

    private void z0() {
        String[] stringArray = this.C1.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new H0(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    public void A0(boolean z) {
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "edit")) {
                Context context = this.P0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "new")) {
            Context context2 = this.P0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_doc_item_add_view6, (ViewGroup) null);
            builder.setView(viewInflate);
            this.p1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name_det);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.r1 = editText;
            this.v1 = editText;
            this.s1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_price);
            this.t1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_total);
            e1();
            this.w1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
            this.x1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add1);
            this.y1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add2);
            this.A1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
            this.C1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            this.D1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach4);
            this.F1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.E1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks4);
            this.G1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
            this.H1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.I1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
            this.K1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface5);
            this.N1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface7);
            this.l0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.c_curr);
            this.X = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.t3(this.k0.getText().toString()));
            this.l0.setText(this.i.l3("0"));
            TextView textView = this.l0;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.l0.setOnClickListener(new ViewOnClickListenerC2875y());
            Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            i1(z);
            if (!z) {
                this.i.Zc(this, this.p1);
                this.i.cd(this, this.F1);
                this.p1.setText(this.A);
                this.r1.setText(this.i.P7(String.valueOf(Double.parseDouble(this.D.replaceAll(",", "")))));
                Log.d("tr_price=", this.F + ":" + this.G + ":" + this.H);
                this.s1.setText(this.i.P7(String.valueOf(Double.parseDouble(this.F.replaceAll(",", "")))));
                this.t1.setText(this.i.P7(String.valueOf(Double.parseDouble(this.G.replaceAll(",", "")))));
                this.i.nd(this.F1, this.H);
                this.l0.setText(this.I);
                this.w1.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
                if (this.K.equals("")) {
                    c1(this.C1);
                } else {
                    Log.d("tr_attach_l=", this.K);
                    f1(this.K);
                }
            }
            builder.setCancelable(true);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            this.A0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
            this.p1.setThreshold(1);
            this.p1.setAdapter(this.A0);
            this.p1.setText(this.A);
            K0();
            if (!z) {
                this.r1.requestFocus();
                this.r1.selectAll();
                O0(4, 500);
            } else if (this.A.length() > 0) {
                this.r1.requestFocus();
            } else {
                this.p1.requestFocus();
            }
            this.i.Zc(this, this.p1);
            g1();
            this.x1.setOnClickListener(new ViewOnClickListenerC2876z(alertDialogCreate));
            this.y1.setOnClickListener(new A());
            this.w1.setOnClickListener(new B(alertDialogCreate));
            this.A1.setOnClickListener(new C());
            this.C1.setOnClickListener(new D(z));
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("edit_item_error=", ":" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void B0(Cursor cursor) {
        int i;
        int count = cursor.getCount();
        Log.d("Cursor_cnt=", String.valueOf(count));
        this.y0.clear();
        cursor.moveToFirst();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        while (!cursor.isAfterLast()) {
            int i3 = i2 + 1;
            int i4 = count;
            this.y0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("cus_name")), cursor.getString(cursor.getColumnIndex("param1")), this.i.P7(String.valueOf(Math.abs(cursor.getDouble(cursor.getColumnIndex("credit")) + cursor.getDouble(cursor.getColumnIndex("debit"))) * Math.abs(cursor.getDouble(cursor.getColumnIndex("c_price"))))), this.i.P7(String.valueOf(Math.abs(cursor.getDouble(cursor.getColumnIndex("credit")) + cursor.getDouble(cursor.getColumnIndex("debit"))))), this.i.P7(String.valueOf(Math.abs(cursor.getDouble(cursor.getColumnIndex("c_price"))))), cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tr_curr_name")), cursor.getString(cursor.getColumnIndex("date_")), cursor.getString(cursor.getColumnIndex("doc_curr_name")), cursor.getString(cursor.getColumnIndex("tr_remarks"))));
            d += cursor.getDouble(cursor.getColumnIndex("credit"));
            d2 += cursor.getDouble(cursor.getColumnIndex("debit"));
            d3 = d2 - d;
            this.y = cursor.getString(cursor.getColumnIndex("doc_curr_name"));
            if (this.n != 0) {
                i = i4;
                if (i2 == i) {
                    Log.d("doc_det=", this.n + ":" + i2 + ":" + i + ":" + cursor.getString(cursor.getColumnIndex("cash_name")));
                    String string = cursor.getString(cursor.getColumnIndex("doc_curr_name"));
                    this.y = string;
                    this.k0.setText(string);
                    this.k0.setTag(this.y);
                    this.T.setText(cursor.getString(cursor.getColumnIndex("p_date")));
                    this.i.nd(this.v0, cursor.getString(cursor.getColumnIndex("bill_no")));
                    this.v0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + cursor.getString(cursor.getColumnIndex("bill_no")));
                    this.i.nd(this.w0, cursor.getString(cursor.getColumnIndex("p_remarks")));
                    this.U.setText(cursor.getString(cursor.getColumnIndex("cash_name")));
                    int i5 = cursor.getInt(cursor.getColumnIndex("tr_type"));
                    this.t = i5;
                    if (i5 == 10) {
                        i2 = i3;
                        this.R.setChecked(false);
                        this.u2 = 0;
                    } else {
                        i2 = i3;
                        this.R.setChecked(true);
                        this.u2 = 0;
                    }
                }
                cursor.moveToNext();
                count = i;
            } else {
                i = i4;
                i2 = i3;
            }
            i2 = i3;
            cursor.moveToNext();
            count = i;
        }
        cursor.close();
        this.Z.setText(this.i.P7(d + ""));
        this.a0.setText(this.i.P7(d2 + ""));
        this.b0.setText(this.i.P7(Math.abs(d3) + ""));
        C0809Ov c0809Ov = new C0809Ov(this, info.aalmoghalis.inventory.R.layout.doc_item_det_row6, this.y0, this.y);
        this.x0 = c0809Ov;
        c0809Ov.j.clear();
        this.x0.notifyDataSetChanged();
        this.P.setAdapter((ListAdapter) this.x0);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String D0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public String E0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (S0(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (R0(uri)) {
                        return D0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (T0(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return D0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return D0(context, uri, null, null);
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

    public boolean F0(String str, String str2, Context context, String str3, int i) {
        L l = new L();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new N(l, str3, i));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new O(l));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.U1;
    }

    public boolean G0(String str, String str2, Context context) {
        P p = new P();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new Q(p));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new R(p));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.U1;
    }

    public boolean H0(String str, String str2, Context context) {
        Z z = new Z();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2843a0(z));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2845b0(z));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.X1;
    }

    public boolean I0(String str, String str2, Context context) {
        HandlerC2842a handlerC2842a = new HandlerC2842a();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2844b(handlerC2842a));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2846c(handlerC2842a));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.W1;
    }

    public void J0(int i) {
        try {
            y0();
            StringBuilder sb = new StringBuilder();
            sb.append("Yes:");
            sb.append(this.n);
            sb.append(":");
            sb.append(i);
            sb.append("::");
            sb.append(this.k0.getText() == null ? "" : this.k0.getText().toString());
            sb.append("#");
            sb.append(this.u2);
            Log.d("get_all_name=", sb.toString());
            if (i == 1 && this.n != 0) {
                if (this.p.equals("")) {
                    B0(this.i.T2(String.valueOf(this.n), "-6", this.i.p4(this.U.getText().toString()), this.q));
                } else {
                    B0(this.i.T2(String.valueOf(this.n), "-6", this.i.p4(this.U.getText().toString()), this.p));
                }
                this.u2 = 0;
            } else if (i == 2) {
                B0(this.i.V2("-6"));
                k1();
                this.W0.setText("");
            } else if (i == 3) {
                B0(this.i.T2(String.valueOf(this.n), "-6", this.i.p4(this.U.getText().toString()), this.q));
                this.u2 = 0;
            } else if (i == 4) {
                B0(this.i.V2("-6"));
                this.W0.setText("");
            }
            ArrayList arrayListI8 = this.i.I8("-6");
            this.n0 = arrayListI8;
            if (arrayListI8 == null || arrayListI8.size() <= 0) {
                this.j0.setVisibility(8);
            } else {
                this.j0.setVisibility(0);
            }
        } catch (Exception e) {
            Log.d("Fetch_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void K0() {
        C1044Xj.a().c(new RunnableC1171Zj(4, this.i, this.p1, this.F1, this.E1, this, this.I1, v2, this.w1, new RunnableC1086Yj()));
    }

    public void L0(String str) {
        C4143vg c4143vgQ4 = this.i.q4(str);
        if (c4143vgQ4.i().equals("")) {
            return;
        }
        this.j = c4143vgQ4.i();
        this.l2 = c4143vgQ4.j();
        this.o2 = c4143vgQ4.h();
        this.n2 = "0";
        this.m2 = c4143vgQ4.f();
    }

    public void M0() {
        try {
            if (getIntent().getStringExtra("P_ID") != null) {
                this.n = Integer.parseInt(getIntent().getStringExtra("P_ID"));
                this.U.setText(getIntent().getStringExtra("cash_name"));
                if (getIntent().getStringExtra(DublinCoreProperties.DATE) != null) {
                    this.p = getIntent().getStringExtra(DublinCoreProperties.DATE);
                    this.q = getIntent().getStringExtra("dev_id") == null ? "0" : getIntent().getStringExtra("dev_id");
                    this.i.v0("delete from tr_p_temps");
                    this.i.v0("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,tr_type,cash_id,curr_price,p_curr_price,curr_mod ,param1,param2,c_price) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,c_curr_id,bill_id,remarks,id,tr_type,c_diff_id,curr_price,c_curr_price,curr_mod ,param1,param2,c_price from transactions_v where p_id='" + this.n + "' and bill_id=-6 and c_p_id=0 and p_date='" + this.p + "'  and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + this.q + "' ");
                } else {
                    this.i.v0("delete from tr_p_temps");
                    this.i.v0("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,tr_type,cash_id,curr_price,p_curr_price,curr_mod ,param1,param2,c_price) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,c_curr_id,bill_id,remarks,id,tr_type,c_diff_id,curr_price,c_curr_price,curr_mod ,param1,param2,c_price from transactions_v where p_id='" + this.n + "' and bill_id=-6 and c_p_id=0 ");
                }
                y0();
                this.L = getIntent().getIntExtra("back_edit", 0);
            }
            this.L = getIntent().getIntExtra("back_edit", 0);
        } catch (Exception unused) {
        }
    }

    public void N0() {
        Bill_edit.P2 = false;
        Intent intent = new Intent(this, (Class<?>) Daily_Curr_Report.class);
        intent.addFlags(67108864);
        intent.putExtra("g_id", this.k);
        intent.putExtra("g_name", this.l);
        intent.putExtra("title_", getString(info.aalmoghalis.inventory.R.string.doc_title));
        startActivity(intent);
        finish();
    }

    public void O0(int i, int i2) {
        try {
            new Handler().postDelayed(new A0(i), i2);
        } catch (Exception unused) {
        }
    }

    public void X0(int i) {
        String string;
        Z00 z00 = this.i;
        ListView listView = this.P;
        String strIc = z00.ic(this.F0);
        if (this.v0.getText().length() == 0) {
            string = this.n + "";
        } else {
            string = this.v0.getText().toString();
        }
        z00.Ka(listView, strIc, string, this.T.getText().toString(), "", this.t, this.b0.getText().toString(), this.k0.getText().toString(), this.n + "");
        if (i == 2) {
            this.i.qd(this.i.ic(this.F0) + ".pdf");
            return;
        }
        if (i == 1) {
            this.i.ra(this.i.ic(this.F0) + ".pdf");
            return;
        }
        if (i == 3) {
            this.i.Hd(this.o2, this.i.ic(this.F0) + ".pdf");
        }
    }

    public void Y0(int i) {
        if (i == 0) {
            return;
        }
        this.F0 = getTitle().toString();
        if (this.p2 != 1) {
            this.p2 = 0;
            X0(2);
        } else {
            e0();
            this.p2 = 0;
            X0(1);
        }
    }

    public void Z0() {
        this.v0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.i.r5(this.t, -6));
    }

    public void a1() {
        this.i.v0("delete from tr_p_temps");
        if (this.n != 0) {
            this.i.v0("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,tr_type,cash_id,curr_price,p_curr_price,curr_mod ,param1,param2,c_price) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,c_curr_id,bill_id,remarks,id,tr_type,c_diff_id,curr_price,c_curr_price,curr_mod  ,param1,param2,c_price from transactions_v where p_id='" + this.n + "' and bill_id=-6 and c_p_id=0  and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + this.q + "' ");
        }
    }

    public void add_item(View view) {
        this.A = "";
        this.E = "";
        this.F = "";
        this.I = "";
        this.G = "";
        this.H = "";
        this.D = "";
        this.B = "";
        if (this.W0.getText() == null || this.W0.getText().toString().equals("")) {
            this.A = "";
            this.E = "";
            this.F = "";
            this.I = "";
            this.G = "";
            this.H = "";
            this.D = "";
            this.B = "";
        } else if (this.i.m1().contains(this.W0.getText().toString())) {
            this.A = this.W0.getText().toString();
        } else {
            this.A = this.W0.getText().toString();
        }
        v2 = 1;
        A0(true);
    }

    public void amount_fwd_btn(View view) {
        v2 = 1;
    }

    public void b1() {
        this.n = 0;
        a1();
        if (this.L == 1) {
            Bill_edit.P2 = true;
        }
        this.v0.setText("");
        this.w0.setText("");
        J0(3);
        Z0();
        this.W0.requestFocus();
        this.Z.setText("0");
        this.a0.setText("0");
        this.b0.setText("0");
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.O0 = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_item_hide(View view) {
        this.s0.setVisibility(8);
        this.t0.setVisibility(0);
        this.q0.setVisibility(0);
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.no_);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new J(textView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new K());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.s0.setVisibility(0);
        this.q0.setVisibility(4);
        this.W0.requestFocus();
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(info.aalmoghalis.inventory.R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(info.aalmoghalis.inventory.R.id.page_name);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(info.aalmoghalis.inventory.R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(info.aalmoghalis.inventory.R.string.disable) + "#" + textView.getText().toString() + "?");
        }
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new H(textView, imageView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new I());
        builder.create().show();
    }

    public void c0(Handler handler, String str, int i) {
        q1("0", str.trim(), "", this.i.T5("0"), "", "", handler);
    }

    public void calc_pick_btn(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", this.r1.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void d0(Handler handler) {
        s1("", this.a1.getText().toString(), "", handler);
    }

    public void e0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void e1() {
        this.r1.addTextChangedListener(this.Q1);
        this.s1.addTextChangedListener(this.Q1);
        this.t1.addTextChangedListener(this.Q1);
        this.r1.setOnTouchListener(new E());
    }

    public void f0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void f1(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            if (this.d2) {
                this.D1.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.D1.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.D1.setImageBitmap(bitmapP0);
                this.D1.setTag(str);
            } else {
                this.C1.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.C1.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.C1.setImageBitmap(bitmapP0);
                this.C1.setTag(str);
            }
        } catch (Exception unused) {
        }
    }

    public void g0(View view, boolean z) {
        if (z) {
            d1();
        } else {
            z0();
        }
    }

    public void g1() {
        this.p1.setOnItemClickListener(new G());
    }

    public void h0() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2861k());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2862l());
        builder.create().show();
    }

    public void h1() {
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
        listView.setOnItemClickListener(new C2866p(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        listView.setDividerHeight(0);
        linearLayout.addView(listView, -1, -1);
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    /* JADX WARN: Not initialized variable reg: 18, insn: 0x00de: MOVE (r2 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]) (LINE:223), block:B:34:0x00de */
    public void i0(int i, int i2) {
        String str;
        String string;
        String string2;
        String str2;
        String string3;
        String str3 = "Error:";
        try {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            C2160f10.h = MO.b(this);
            if (p0()) {
                boolean z = this.i.q5().getCount() == 0;
                int i3 = this.n;
                if (z && (i3 == 0)) {
                    this.h0.performClick();
                    return;
                }
                try {
                    if (i3 == 0) {
                        int iT5 = this.i.t5();
                        int iC3 = this.i.c3(this.t, -6, this.U.getText().toString());
                        this.v0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + iC3);
                        if (this.v0.getText().toString().length() > 0 && this.i.d3(this.v0.getText().toString(), this.t, this.n, this.U.getText().toString()) > 0) {
                            this.v0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                            return;
                        }
                        y0();
                        StringBuilder sb = new StringBuilder();
                        sb.append("update tr_p_temps set p_id='");
                        sb.append(iT5);
                        sb.append("',p_amount='");
                        sb.append(this.Z.getText().toString().replaceAll(",", ""));
                        sb.append("',p_remarks='");
                        sb.append(this.w0.getText().toString());
                        sb.append("',p_ref_no='");
                        sb.append((this.v0.getText() == null || this.v0.getText().toString().length() != 0) ? this.v0.getText().toString() : Integer.valueOf(iC3));
                        sb.append("',p_date='");
                        sb.append(this.T.getText().toString());
                        sb.append("',date_='");
                        sb.append(this.T.getText().toString());
                        sb.append("',bill_id=-6,tr_type=");
                        sb.append(this.t);
                        sb.append(",cash_id=(select id from customers where name='");
                        sb.append(this.U.getText().toString());
                        sb.append("') where p_id=");
                        sb.append(iT5);
                        string = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("insert into transactions(p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,[in],curr_id,c_curr_id,bill_id,remarks,date_,p_date,curr_price,c_curr_price,tr_type,c_diff_id,curr_mod ,param1,param2,online,c_price,user_id)select p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,tr_type,cash_id,curr_mod ,param1,param2 ,");
                        sb2.append("0");
                        sb2.append(",c_price ,");
                        int i4 = C2160f10.h;
                        sb2.append(i4 == -1 ? "null" : Integer.valueOf(i4));
                        sb2.append(" from tr_p_temps ");
                        string2 = sb2.toString();
                        String strL = this.i.L(string, string2);
                        if (strL != null && strL.equals("1")) {
                            this.q2 = true;
                            this.n = iT5;
                            this.p = this.T.getText().toString();
                            this.q = "0";
                            a1();
                            string3 = "";
                            str2 = "0";
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Error:");
                        if (strL != null && strL.length() > 20) {
                            strL = strL.substring(0, 20);
                        }
                        sb3.append(strL);
                        Toast.makeText(this, sb3.toString(), 0).show();
                        return;
                    }
                    this.i.t5();
                    int iC4 = this.i.c3(this.t, -6, this.U.getText().toString());
                    this.v0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + iC4);
                    if (this.v0.getText().toString().length() > 0 && (this.i.d3(this.v0.getText().toString(), this.t, this.n, this.U.getText().toString()) > 0 || this.i.e3(this.v0.getText().toString(), this.t, this.n, this.U.getText().toString()) > 1)) {
                        this.v0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                        return;
                    }
                    y0();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("update tr_p_temps set p_amount='");
                    sb4.append(this.Z.getText().toString().replaceAll(",", ""));
                    sb4.append("',p_remarks='");
                    sb4.append(this.w0.getText().toString());
                    sb4.append("',p_ref_no='");
                    sb4.append((this.v0.getText() == null || this.v0.getText().toString().length() != 0) ? this.v0.getText().toString() : Integer.valueOf(iC4));
                    sb4.append("',p_date='");
                    sb4.append(this.T.getText().toString());
                    sb4.append("',date_='");
                    sb4.append(this.T.getText().toString());
                    sb4.append("',bill_id=-6,tr_type=");
                    sb4.append(this.t);
                    sb4.append(",cash_id=(select id from customers where name='");
                    sb4.append(this.U.getText().toString());
                    sb4.append("') where p_id=");
                    sb4.append(this.n);
                    string = sb4.toString();
                    string2 = "delete from transactions where p_id=" + this.n + " and p_id<>0 and bill_id=-6  and p_date='" + this.p + "' and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + this.q + "' ";
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("insert into transactions(p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,[in],curr_id,c_curr_id,bill_id,remarks,date_,p_date,curr_price,c_curr_price,tr_type,c_diff_id,curr_mod ,param1,param2,online,c_price,user_id)select p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,tr_type,cash_id,curr_mod ,param1,param2 ,");
                    str2 = "0";
                    sb5.append(str2);
                    sb5.append(",c_price ,");
                    int i5 = C2160f10.h;
                    sb5.append(i5 == -1 ? "null" : Integer.valueOf(i5));
                    sb5.append(" from tr_p_temps where p_id= ");
                    sb5.append(this.n);
                    string3 = sb5.toString();
                    String strM = this.i.M(string, string2, string3);
                    if (strM != null && strM.equals("1")) {
                        this.q2 = false;
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Error:");
                    if (strM != null && strM.length() > 20) {
                        strM = strM.substring(0, 20);
                    }
                    sb6.append(strM);
                    Toast.makeText(this, sb6.toString(), 0).show();
                    return;
                    Log.d("sql1=", string);
                    Log.d("sql2=", string2);
                    Log.d("sql3=", string3);
                    Log.d("sql4=", "");
                    w0();
                    this.u2 = 0;
                    a1();
                    Log.d("new_bill=", this.q2 + ":" + this.L + ":" + this.b0.getText().toString() + ":" + this.P.getAdapter().getCount() + ":" + this.e2);
                    J0(1);
                    if (!this.b0.getText().toString().equals(str2)) {
                        this.u2 = 1;
                        if (!p0()) {
                            return;
                        }
                    }
                    int i6 = this.p2;
                    if (i6 == 1 || i6 == 2) {
                        this.u2 = 0;
                        Bill_edit.P2 = true;
                        Y0(i6);
                        return;
                    }
                    if (this.e2 == 1) {
                        this.e2 = 0;
                        b1();
                        return;
                    }
                    if (!this.q2) {
                        if (this.L != 1) {
                            N0();
                            return;
                        } else {
                            Bill_edit.P2 = true;
                            finish();
                            return;
                        }
                    }
                    if (this.P.getAdapter().getCount() != 1) {
                        N0();
                        return;
                    }
                    this.u2 = 0;
                    Bill_edit.P2 = true;
                    L0(((C0634Jt) this.P.getAdapter().getItem(0)).e());
                    String str4 = this.l2;
                    if (str4 != null) {
                        l1(str4);
                    }
                } catch (Exception e) {
                    e = e;
                    str3 = str;
                    Log.d("bill_save_error", e.getMessage() + "");
                    e.printStackTrace();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str3);
                    sb7.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
                    Toast.makeText(this, sb7.toString(), 1).show();
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void i1(boolean z) {
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.d2 = z;
        if (!z) {
            this.K1.setVisibility(8);
            this.N1.setVisibility(0);
            this.F1.setThreshold(1);
            this.C1.setOnClickListener(new D0(z));
            return;
        }
        this.N1.setVisibility(8);
        this.K1.setVisibility(0);
        this.E1.setThreshold(1);
        this.M = calendar.get(1);
        this.N = calendar.get(2);
        this.O = calendar.get(5);
        this.D1.setOnClickListener(new C0(z));
        int i = v2;
        if ((i == 3 || i == 1) && i == 3) {
            this.p1.setText("");
            c1(this.C1);
            this.E1.setText((CharSequence) null);
            this.p1.requestFocus();
        }
    }

    public boolean j0(int i) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z = false;
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "edit")) {
                Context context = this.P0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "new")) {
            Context context2 = this.P0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        int i3 = this.t;
        if (i3 == 13) {
            i2 = 1;
        } else {
            i2 = i3 == 10 ? -1 : 0;
        }
        n0();
        if (m0()) {
            try {
                Log.d("btn_cus_add:", "START");
                if (i2 != 0) {
                    int iT5 = this.n;
                    if (iT5 == 0) {
                        try {
                            iT5 = this.i.t5();
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            return z;
                        }
                    }
                    int iR5 = this.i.r5(this.t, -6);
                    this.i.ja("prefOthers_trans_diff_dates", false);
                    if (this.C1.getTag() == null) {
                        Z00 z00 = this.i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into tr_p_temps (cus_id,out,in_,date_,p_date,remarks,now_,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no,tr_type,cash_id,bill_id,c_price) values((select b.id from customers as b where b.name='");
                        sb.append(this.p1.getText().toString());
                        sb.append("'),");
                        sb.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb.append(",");
                        sb.append(i2);
                        sb.append(",'");
                        sb.append(this.T.getText().toString());
                        sb.append("','");
                        sb.append(this.T.getText().toString());
                        sb.append("','");
                        sb.append(this.F1.getText().toString());
                        sb.append("',strftime('%Y-%m-%d','now'),'");
                        sb.append(this.i.B8());
                        sb.append("',");
                        if (this.k0.getText() == null) {
                            str3 = "0";
                        } else {
                            str3 = "(select id from currency where name='" + this.k0.getText().toString() + "'),";
                        }
                        sb.append(str3);
                        if (this.l0.getText() == null) {
                            str4 = "0";
                        } else {
                            str4 = "(select id from currency where name='" + this.l0.getText().toString() + "')";
                        }
                        sb.append(str4);
                        sb.append(",");
                        sb.append(iT5);
                        sb.append(",'");
                        sb.append(this.w0.getText().toString());
                        sb.append("','");
                        sb.append((this.v0.getText() == null || this.v0.getText().toString().length() != 0) ? this.v0.getText().toString() : Integer.valueOf(iR5));
                        sb.append("',");
                        sb.append(this.t);
                        sb.append(",(select b.id from customers as b where b.name='");
                        sb.append(this.U.getText().toString());
                        sb.append("') ,-6,");
                        sb.append(this.s1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb.append(")");
                        z00.v0(sb.toString());
                    } else {
                        Z00 z01 = this.i;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("insert into tr_p_temps (cus_id,out,in_,date_,p_date,remarks,now_,param1,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no,tr_type,cash_id,bill_id,c_price) values((select b.id from customers as b where b.name='");
                        sb2.append(this.p1.getText().toString());
                        sb2.append("'),");
                        sb2.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb2.append(",");
                        sb2.append(i2);
                        sb2.append(",'");
                        sb2.append(this.T.getText().toString());
                        sb2.append("','");
                        sb2.append(this.T.getText().toString());
                        sb2.append("','");
                        sb2.append(this.F1.getText().toString());
                        sb2.append("',strftime('%Y-%m-%d','now'),'");
                        sb2.append(this.C1.getTag().toString());
                        sb2.append("','");
                        sb2.append(this.i.B8());
                        sb2.append("',");
                        if (this.k0.getText() == null) {
                            str = "0";
                        } else {
                            str = "(select id from currency where name='" + this.k0.getText().toString() + "'),";
                        }
                        sb2.append(str);
                        if (this.l0.getText() == null) {
                            str2 = "0";
                        } else {
                            str2 = "(select id from currency where name='" + this.k0.getText().toString() + "')";
                        }
                        sb2.append(str2);
                        sb2.append(",");
                        sb2.append(iT5);
                        sb2.append(",'");
                        sb2.append(this.w0.getText().toString());
                        sb2.append("','");
                        sb2.append((this.v0.getText() == null || this.v0.getText().toString().length() != 0) ? this.v0.getText().toString() : Integer.valueOf(iR5));
                        sb2.append("',");
                        sb2.append(this.t);
                        sb2.append(",(select b.id from customers as b where b.name='");
                        sb2.append(this.U.getText().toString());
                        sb2.append("') ,-6,");
                        sb2.append(this.s1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb2.append(")");
                        z01.v0(sb2.toString());
                    }
                    this.i.v0("update tr_p_temps set remarks=ifnull(p_remarks,'') where ( remarks is NULL or remarks='')");
                    this.W0.setText((CharSequence) null);
                    this.r1.setText((CharSequence) null);
                    c1(this.C1);
                    this.F1.setText((CharSequence) null);
                    this.r1.requestFocus();
                    try {
                        FragmentStatePagerSupport_Main.a0 = true;
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        e.printStackTrace();
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
        }
        return false;
    }

    public void j1(int i, String str, String str2) {
        String str3;
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
        if (str == null || str.length() <= 0) {
            return;
        }
        double d = Double.parseDouble((String) this.i.X3(str, str2).get(0));
        String strQ2 = d < 0.0d ? this.i.Q2() : this.i.c5();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(info.aalmoghalis.inventory.R.string.total_header));
        if (d != 0.0d) {
            str3 = " " + strQ2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(" ");
        sb.append(this.i.P7(Math.abs(d) + ""));
        sb.append(" ");
        sb.append(this.i.g3(str2));
        String string = sb.toString();
        if (i != 0) {
            i2 = 1;
        }
        Toast.makeText(this, string, i2).show();
    }

    public boolean k0() {
        int i;
        boolean z;
        boolean z2;
        String str;
        String str2;
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "edit")) {
                Context context = this.P0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "new")) {
            Context context2 = this.P0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        int i2 = this.t;
        if (i2 == 13) {
            i = 1;
        } else {
            i = i2 == 10 ? -1 : 0;
        }
        n0();
        if (!o0()) {
            return false;
        }
        try {
            this.i.ja("prefOthers_trans_diff_dates", false);
            if (this.w1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                String str3 = "0";
                if (this.C1.getTag() == null) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update tr_p_temps set out='");
                    sb.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',in_='");
                    sb.append(i);
                    sb.append("',c_price='");
                    sb.append(this.s1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',date_='");
                    sb.append(this.T.getText().toString());
                    sb.append("',p_date='");
                    sb.append(this.T.getText().toString());
                    sb.append("',cus_id=(select b.id from customers as b where b.name='");
                    sb.append(this.p1.getText().toString());
                    sb.append("'),remarks='");
                    sb.append(this.F1.getText().toString());
                    sb.append("',param1='',curr_id=");
                    if (this.k0.getText() == null) {
                        str2 = "0";
                    } else {
                        str2 = "(select id from currency where name='" + this.k0.getText().toString() + "')";
                    }
                    sb.append(str2);
                    sb.append(",p_curr_id=");
                    if (this.l0.getText() != null) {
                        str3 = "(select id from currency where name='" + this.l0.getText().toString() + "')";
                    }
                    sb.append(str3);
                    sb.append(",tr_type=");
                    sb.append(this.t);
                    sb.append(",cash_id=(select b.id from customers as b where b.name='");
                    sb.append(this.U.getText().toString());
                    sb.append("') where no_='");
                    sb.append(this.J);
                    sb.append("'");
                    z00.v0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("update tr_p_temps set out='");
                    sb2.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',in_='");
                    sb2.append(i);
                    sb2.append("',c_price='");
                    sb2.append(this.s1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',date_='");
                    sb2.append(this.T.getText().toString());
                    sb2.append("',p_date='");
                    sb2.append(this.T.getText().toString());
                    sb2.append("',remarks='");
                    sb2.append(this.F1.getText().toString());
                    sb2.append("',param1='");
                    sb2.append(this.C1.getTag().toString());
                    sb2.append("',cus_id=(select b.id from customers as b where b.name='");
                    sb2.append(this.p1.getText().toString());
                    sb2.append("'),curr_id=");
                    if (this.k0.getText() == null) {
                        str = "0";
                    } else {
                        str = "(select id from currency where name='" + this.k0.getText().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(",p_curr_id=");
                    if (this.l0.getText() != null) {
                        str3 = "(select id from currency where name='" + this.l0.getText().toString() + "')";
                    }
                    sb2.append(str3);
                    sb2.append(",tr_type=");
                    sb2.append(this.t);
                    sb2.append(",cash_id=(select b.id from customers as b where b.name='");
                    sb2.append(this.U.getText().toString());
                    sb2.append("') where no_='");
                    sb2.append(this.J);
                    sb2.append("'");
                    z01.v0(sb2.toString());
                }
                this.i.v0("update tr_p_temps set remarks=ifnull(p_remarks,'') where ( remarks is NULL or remarks='')");
                c1(this.C1);
                this.w1.setText(getString(info.aalmoghalis.inventory.R.string.btn_add));
                z2 = true;
                z = true;
            } else {
                z2 = true;
                z = false;
            }
            try {
                FragmentStatePagerSupport_Main.a0 = z2;
                return z;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public void l1(String str) {
        if (!this.i.ja("prefAutoNotify", false)) {
            N0();
            return;
        }
        Snackbar snackbarMake = Snackbar.make(this.P, "", -2);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
        TextView textView = (TextView) snackbarLayout.findViewById(info.aalmoghalis.inventory.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, info.aalmoghalis.inventory.R.color.white));
        C4064uh c4064uhO0 = this.i.O0(str, this.k0.getText().toString());
        StringBuilder sb = new StringBuilder();
        sb.append(c4064uhO0.t() == this.r2[0] ? this.i.Q2() : this.i.c5());
        sb.append(" ");
        sb.append(c4064uhO0.n());
        sb.append(" ");
        sb.append(c4064uhO0.r());
        snackbarMake.setText(sb.toString());
        snackbarMake.setAction(getString(info.aalmoghalis.inventory.R.string.hide_tr), new ViewOnClickListenerC2863m(snackbarMake));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_share), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setOnClickListener(new ViewOnClickListenerC2864n());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();
        layoutParams.gravity = 16;
        snackbarLayout.setLayoutParams(layoutParams);
        ViewCompat.setLayoutDirection(snackbarMake.getView(), 1);
        snackbarMake.show();
        new Handler().postDelayed(new RunnableC2865o(snackbarMake), 5000);
    }

    public void m1() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.i.J2(this, intent);
            this.k2 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.k2.getPath() + "");
            startActivityForResult(intent, this.g2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void n1() {
        if (this.z0.valueAt(0)) {
            C0634Jt item = this.x0.getItem(this.z0.keyAt(0));
            ArrayList arrayListJ8 = this.i.J8("-6", item.f());
            this.o0 = arrayListJ8;
            if (arrayListJ8 == null || arrayListJ8.size() == 0) {
                this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.local_curr), 1000);
                return;
            }
            this.i.me("-6", this, this.o0, new z0(), item.f());
            try {
                Looper.loop();
            } catch (RuntimeException unused) {
            }
            J0(2);
            this.u2 = 1;
        }
    }

    public void o1(String str, String str2, String str3, String str4) {
        try {
            FragmentStatePagerSupport_Main.a0 = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
            autoCompleteTextView.setOnItemClickListener(new C2848d(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC2850e(autoCompleteTextView));
            this.u1 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new ViewOnClickListenerC2852f());
            imageView2.setOnClickListener(new ViewOnClickListenerC2854g(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2856h());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2858i());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2860j(editText2, autoCompleteTextView, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (i2 != 0) {
                if (i == 2) {
                    if (intent != null) {
                        this.r1.setText(this.i.P7(intent.getStringExtra("calc_result")));
                    }
                } else if (i == 1) {
                    if (i2 == -1) {
                        Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                        this.u1.setText(string);
                        cursorQuery.close();
                        Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                    }
                } else if (i == this.h2 && intent != null) {
                    W0(intent.getData(), false);
                } else if (i == this.g2) {
                    V0(intent);
                }
            }
            C0974Ur c0974Ur = this.i.x;
            if (c0974Ur != null && !c0974Ur.l(i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            super.onActivityResult(i, i2, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "edit")) {
                this.u2 = 0;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "new")) {
            this.u2 = 0;
        }
        Log.d("onback=", this.u2 + ":" + this.L + ":" + Bill_edit.P2);
        if (this.u2 == 1) {
            this.t2 = 1;
            u0();
        } else if (this.L != 1 || this.n == 0) {
            N0();
        } else {
            finish();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0276 -> B:51:0x0279). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0279 -> B:51:0x0279). Please report as a decompilation issue!!! */
    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_doc_edit6);
        setTitle(getString(info.aalmoghalis.inventory.R.string.add_curr_sales));
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        z00.v0("delete from tr_p_temps");
        M0();
        if (this.n != 0) {
            setContentView(info.aalmoghalis.inventory.R.layout.content_doc_det6);
        }
        this.G0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_header);
        this.H0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_footer);
        this.I0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_item_header);
        this.P = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        this.R = (SwitchCompat) findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
        this.T = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_date);
        this.Y = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name);
        TextView textView = (TextView) findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
        this.u0 = textView;
        textView.setText(this.i.V8(this.t));
        this.Z = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot);
        this.a0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot2);
        this.b0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot3);
        this.c0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.count);
        this.f0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr);
        this.h0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_add);
        ImageView imageView = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img_fwd_amount);
        this.i0 = imageView;
        imageView.setOnClickListener(this.j1);
        ImageView imageView2 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img_u_currency);
        this.j0 = imageView2;
        imageView2.setVisibility(8);
        this.j0.setOnClickListener(this.j1);
        this.v0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_no);
        this.w0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
        this.i.dd(this, this.v0);
        this.i.ad(this, this.w0);
        this.r0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.root_layout);
        this.s0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.item_add_hdr);
        this.t0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_items_list_hdr);
        this.q0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.page_add);
        if (this.n == 0) {
            Z0();
        } else {
            this.t0.setVisibility(0);
        }
        this.k0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_curr);
        this.W0 = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        Z00 z01 = this.i;
        this.W = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, z01.t3(z01.l3("0")));
        this.k0.setText(this.i.O5());
        TextView textView2 = this.k0;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        this.k0.setOnClickListener(new ViewOnClickListenerC2870t());
        this.U = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_cash);
        this.V = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.D3());
        TextView textView3 = this.U;
        textView3.setPaintFlags(8 | textView3.getPaintFlags());
        this.U.setText(this.i.F3().j());
        this.P.setOnItemClickListener(new C2873w());
        this.P.setChoiceMode(3);
        this.P.setMultiChoiceModeListener(new C2874x());
        this.R.setOnCheckedChangeListener(new M());
        Calendar calendar = Calendar.getInstance();
        this.T.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
        this.M = calendar.get(1);
        this.N = calendar.get(2);
        this.O = calendar.get(5);
        this.T.setOnClickListener(new U());
        try {
            if (getIntent().getStringExtra("read_imei") != null && getIntent().getStringExtra("read_imei").equals("1")) {
                this.i.Tb();
                try {
                    this.i.Mc("hello_serv", false);
                    if (Build.VERSION.SDK_INT >= 23) {
                        this.i.Ud();
                    } else {
                        startService(new Intent(this, (Class<?>) HelloService.class));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.t = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.k = getIntent().getStringExtra("g_id");
                this.l = getIntent().getStringExtra("g_name");
                this.u0.setText(this.i.V8(this.t));
                setTitle(this.u0.getText().toString());
                this.i.v0("delete from items_temp");
            }
        } catch (Exception unused2) {
        }
        try {
            if (getIntent().getIntExtra("doc_tr_type", 0) != 0) {
                int intExtra = getIntent().getIntExtra("doc_tr_type", 10);
                this.t = intExtra;
                this.u0.setText(this.i.V8(intExtra));
                if (this.t == 10) {
                    this.R.setChecked(false);
                } else {
                    this.R.setChecked(true);
                }
            }
        } catch (Exception unused3) {
        }
        if (getIntent().getStringExtra("P_ID") != null && C2160f10.h > 0 && !new C2160f10(this.i).l("32", "edit")) {
            this.S.setEnabled(false);
            this.v0.setEnabled(false);
            this.k0.setEnabled(false);
            this.U.setEnabled(false);
            this.F1.setEnabled(false);
        }
        if (C2160f10.h > 0) {
            this.U.setEnabled(false);
        }
        if (this.n == 0) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        M0();
        J0(1);
        u1();
        w0();
        this.w0.addTextChangedListener(this.L0);
        this.w0.setOnClickListener(new ViewOnClickListenerC2853f0());
        this.v0.addTextChangedListener(this.L0);
        this.v0.setOnClickListener(new q0());
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(Q0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.a2, this.M, this.N, this.O);
        }
        if (i == 4) {
            return new DatePickerDialog(Q0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.b2, this.M, this.N, this.O);
        }
        if (i != 5) {
            return null;
        }
        return new DatePickerDialog(Q0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.c2, this.M, this.N, this.O);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_doc_5, menu);
        int i = C2160f10.h;
        if (i <= 0 || this.n == 0) {
            if (i <= 0 || this.n != 0) {
                return true;
            }
            menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(new C2160f10(this.i).l("32", HTML.Tag.DEL));
            return true;
        }
        MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
        MenuItem menuItemFindItem2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
        MenuItem menuItemFindItem3 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_new);
        boolean zL = new C2160f10(this.i).l("32", "edit");
        boolean zL2 = new C2160f10(this.i).l("32", "new");
        boolean zL3 = new C2160f10(this.i).l("32", HTML.Tag.DEL);
        menuItemFindItem.setVisible(zL);
        menuItemFindItem2.setVisible(zL3);
        menuItemFindItem3.setVisible(zL2);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        B0(this.i.L2());
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
            if (this.i.ja("prefOthers_closed_year", false)) {
                return true;
            }
            i0(1, this.t);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_submit) {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return true;
            }
            i0(2, this.t);
            this.q2 = false;
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_remove) {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return true;
            }
            h0();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_new) {
            if (this.u2 == 1) {
                this.t2 = 0;
                this.e2 = 1;
                i0(2, this.t);
            } else {
                b1();
            }
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.share) {
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin) {
                this.p2 = 1;
            } else {
                this.p2 = 2;
            }
            if (this.u2 == 1) {
                u0();
                return true;
            }
            Y0(this.p2);
        } else {
            if (menuItem.getItemId() == 16908332) {
                onBackPressed();
                return true;
            }
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.printing) {
                Log.d("thermal=", this.n + ":" + this.u2 + ":" + this.L);
                if (this.u2 == 1) {
                    this.t2 = 0;
                    i0(2, this.t);
                }
                Intent intent = new Intent(this, (Class<?>) (this.i.ja("prefThermalBluetooth", true) ? MainActivity.class : MainActivity2.class));
                intent.putExtra("TR_ID", this.n + "");
                intent.putExtra("cash_id", this.i.p4(this.U.getText().toString()));
                Z00.j0.clear();
                Z00.j0.add(new String[]{this.n + "", this.p, this.q});
                startActivity(intent);
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
            if (this.k0.getText().toString().equals(radioButton.getText().toString())) {
                this.k0.setTag(radioButton.getText().toString());
                J0(2);
            } else {
                this.k0.setTag(radioButton.getText().toString());
                r1();
                this.Q0 = 1;
                this.u2 = 1;
            }
            Log.d("radio_checked:=", radioButton.getText().toString() + ":" + this.y);
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

    public void p1(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
            this.i.bd(this, autoCompleteTextView2);
            this.i.bd(this, autoCompleteTextView);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4);
            autoCompleteTextView2.setText(str6);
            editText3.setText(str5);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new n0(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new o0(autoCompleteTextView2, editText));
            this.u1 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new p0());
            imageView2.setOnClickListener(new r0(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new s0(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new t0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new u0());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new v0(editText, autoCompleteTextView, autoCompleteTextView2, str, editText2, editText3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void q0() {
        this.i.D = false;
        if (this.k0.getText() == null || this.k0.getText().toString().equals(this.i.l3("0")) || this.i.Z2(this.k0.getText().toString(), this.i.cc(this.T.getText().toString())) != 0) {
            return;
        }
        this.i.u(this, this.k0.getText().toString(), this.i.cc(this.T.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    public void q1(String str, String str2, String str3, String str4, String str5, String str6, Handler handler) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
            this.i.bd(this, autoCompleteTextView2);
            this.i.bd(this, autoCompleteTextView);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4);
            autoCompleteTextView2.setText(str6);
            editText3.setText(str5);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2847c0(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C2849d0(autoCompleteTextView2, editText2));
            this.u1 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC2851e0());
            imageView2.setOnClickListener(new ViewOnClickListenerC2855g0(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new ViewOnClickListenerC2857h0(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2859i0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new j0());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new k0(editText, autoCompleteTextView, autoCompleteTextView2, str, alertDialogCreate, editText2, editText3, handler));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void r0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        autoCompleteTextView.setText("");
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new l0(autoCompleteTextView, dialog, editText));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    public void r1() {
        q0();
        String str = "0";
        if (this.n != 0) {
            Z00 z00 = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append("update tr_p_temps set curr_price=0,p_date='");
            sb.append(this.T.getText().toString());
            sb.append("',date_='");
            sb.append(this.T.getText().toString());
            sb.append("',curr_id=");
            if (this.k0.getText() != null) {
                str = "(select id from currency where name='" + this.k0.getText().toString() + "'),p_curr_price=0";
            }
            sb.append(str);
            sb.append(",curr_mod=0   where p_id=");
            sb.append(this.n);
            z00.v0(sb.toString());
            J0(4);
        } else {
            Z00 z01 = this.i;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("update tr_p_temps set curr_price=0,p_date='");
            sb2.append(this.T.getText().toString());
            sb2.append("',date_='");
            sb2.append(this.T.getText().toString());
            sb2.append("',curr_id=");
            if (this.k0.getText() != null) {
                str = "(select id from currency where name='" + this.k0.getText().toString() + "'),p_curr_price=0";
            }
            sb2.append(str);
            z01.v0(sb2.toString());
            J0(4);
        }
        FragmentStatePagerSupport_Main.a0 = true;
    }

    public void s0(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new m0(textView, arrayAdapter, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void s1(String str, String str2, String str3, Handler handler) {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
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
            autoCompleteTextView.setOnItemClickListener(new S(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new T(autoCompleteTextView));
            imageView.setOnClickListener(new V(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new W());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new X());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new Y(autoCompleteTextView, alertDialogCreate, str, editText, handler));
        } catch (Exception unused) {
        }
    }

    public void t0() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.L0();
            }
            f0();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void t1(int i) {
        try {
            if (this.P1) {
                return;
            }
            double d = this.r1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.r1.getText().toString().replaceAll(",", "")) : 0.0d;
            this.P1 = true;
            if (i == 1) {
                if (this.r1.getText().toString().trim().length() == 0) {
                    this.t1.setText("");
                } else if (this.s1.getText().toString().trim().length() > 0 && this.r1.getText().toString().trim().length() > 0) {
                    this.t1.setText(this.i.S7("" + (Double.parseDouble(this.s1.getText().toString().replaceAll(",", "")) * d)));
                    this.i.gc(this.r1);
                }
            } else if (i == 2) {
                if (this.s1.getText().toString().trim().length() == 0) {
                    this.t1.setText("");
                } else if (this.s1.getText().toString().trim().length() > 0 && this.r1.getText().toString().trim().length() > 0) {
                    this.t1.setText(this.i.S7("" + (Double.parseDouble(this.s1.getText().toString().replaceAll(",", "")) * d)));
                    this.i.gc(this.s1);
                }
            } else if (i == 3) {
                if (this.t1.getText().toString().trim().length() == 0) {
                    this.s1.setText("");
                } else if (this.t1.getText().toString().trim().length() > 0 && this.r1.getText().toString().trim().length() > 0) {
                    this.s1.setText(this.i.S7("" + (Double.parseDouble(this.t1.getText().toString().replaceAll(",", "")) / d)));
                    this.i.gc(this.t1);
                }
            }
            this.P1 = false;
        } catch (Exception e) {
            this.P1 = false;
            e.printStackTrace();
        }
    }

    public void u0() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_save));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new E0());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new F0());
        builder.create().show();
    }

    public void u_currency_btn(View view) {
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "edit")) {
                Context context = this.P0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "new")) {
            Context context2 = this.P0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        this.i.me("-6", this, this.n0, new HandlerC2872v(), "0");
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        J0(2);
        this.u2 = 1;
    }

    public void w0() {
        this.g1 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
        this.W0.setThreshold(1);
        this.W0.setAdapter(this.g1);
        this.W0.setOnItemClickListener(new C2867q());
        this.W0.setOnTouchListener(new ViewOnTouchListenerC2868r());
        this.W0.addTextChangedListener(new C2869s());
    }

    public void x0() {
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "edit")) {
                Context context = this.P0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("32", "new")) {
            Context context2 = this.P0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.z0.size() - 1; size >= 0; size--) {
            if (this.z0.valueAt(size)) {
                C0634Jt item = this.x0.getItem(this.z0.keyAt(size));
                this.x0.remove(item);
                this.i.v0("delete from tr_p_temps where no_='" + item.f() + "'");
            }
        }
        this.Q0 = 1;
        J0(2);
        this.Q0 = 1;
    }

    public void y0() {
        this.i.v0("update tr_p_temps set curr_price=0 where curr_id=0");
        this.i.v0("update tr_p_temps set p_curr_price=0 where p_curr_id=0");
    }
}
