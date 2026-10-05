package info.aalmoghalis.inventory.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.text.InputFilter;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0634Jt;
import defpackage.C0809Ov;
import defpackage.C0974Ur;
import defpackage.C1044Xj;
import defpackage.C1839c10;
import defpackage.C2018dE;
import defpackage.C2160f10;
import defpackage.C3580oi;
import defpackage.C3966tX;
import defpackage.E00;
import defpackage.MO;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.helper.Calculator;
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

/* JADX INFO: loaded from: classes3.dex */
public class Customer_Det_List_edit4 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int k2;
    public int K;
    public boolean K1;
    public int L;
    public int M;
    public boolean M1;
    public boolean N1;
    public String W1;
    public ArrayAdapter b1;
    public Uri b2;
    public SQLiteDatabase h;
    public Z00 i;
    public E00 j;
    public String k;
    public EditText k1;
    public String l;
    public EditText l1;
    public LinearLayout m0;
    public EditText m1;
    public String n;
    public LinearLayout n0;
    public LinearLayout o0;
    public C0809Ov s0;
    public SparseBooleanArray u0;
    public ArrayAdapter v0;
    public int p = 0;
    public String q = "";
    public String t = "";
    public int u = 0;
    public int v = 2;
    public int w = 0;
    public int x = 0;
    public int y = 0;
    public String z = null;
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public String E = null;
    public String F = null;
    public String G = null;
    public String H = "0";
    public String I = null;
    public int J = 0;
    public ListView N = null;
    public Toolbar O = null;
    public SwitchCompat P = null;
    public TextView Q = null;
    public TextView R = null;
    public TextView S = null;
    public AutoCompleteTextView T = null;
    public TextView U = null;
    public TextView V = null;
    public TextView W = null;
    public TextView X = null;
    public TextView Y = null;
    public TextView Z = null;
    public TextView a0 = null;
    public ImageView b0 = null;
    public ImageView c0 = null;
    public ImageView d0 = null;
    public ImageView e0 = null;
    public RadioGroup f0 = null;
    public RadioGroup g0 = null;
    public ArrayList h0 = new ArrayList();
    public ArrayList i0 = new ArrayList();
    public ArrayList j0 = new ArrayList();
    public ArrayList k0 = new ArrayList();
    public ImageView l0 = null;
    public TextView p0 = null;
    public EditText q0 = null;
    public EditText r0 = null;
    public List t0 = new ArrayList();
    public ImageButton w0 = null;
    public int x0 = 0;
    public String[] y0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] z0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String A0 = "";
    public LinearLayout B0 = null;
    public LinearLayout C0 = null;
    public LinearLayout D0 = null;
    public int E0 = 0;
    public boolean F0 = false;
    public TextWatcher G0 = new j0();
    public int H0 = 0;
    public String I0 = "";
    public String J0 = "";
    public final Context K0 = this;
    public int L0 = 0;
    public int M0 = 0;
    public String N0 = "";
    public EditText O0 = null;
    public EditText P0 = null;
    public TextView Q0 = null;
    public AutoCompleteTextView R0 = null;
    public EditText S0 = null;
    public EditText T0 = null;
    public EditText U0 = null;
    public AutoCompleteTextView V0 = null;
    public EditText W0 = null;
    public EditText X0 = null;
    public EditText Y0 = null;
    public TextView Z0 = null;
    public AutoCompleteTextView a1 = null;
    public View.OnClickListener c1 = new ViewOnClickListenerC2780p();
    public String d1 = null;
    public String e1 = null;
    public AutoCompleteTextView f1 = null;
    public ArrayList g1 = new ArrayList();
    public TextView h1 = null;
    public AutoCompleteTextView i1 = null;
    public String j1 = "";
    public Button n1 = null;
    public Button o1 = null;
    public Button p1 = null;
    public Button q1 = null;
    public ImageView r1 = null;
    public ImageView s1 = null;
    public ImageView t1 = null;
    public ImageView u1 = null;
    public AutoCompleteTextView v1 = null;
    public AutoCompleteTextView w1 = null;
    public RadioGroup x1 = null;
    public RadioButton y1 = null;
    public RadioButton z1 = null;
    public LinearLayout A1 = null;
    public LinearLayout B1 = null;
    public LinearLayout C1 = null;
    public LinearLayout D1 = null;
    public LinearLayout E1 = null;
    public LinearLayout F1 = null;
    public LinearLayout G1 = null;
    public double H1 = 0.0d;
    public double I1 = 0.0d;
    public int J1 = 0;
    public int L1 = 1;
    public String O1 = "";
    public String P1 = "0";
    public DatePickerDialog.OnDateSetListener Q1 = new C0();
    public DatePickerDialog.OnDateSetListener R1 = new D0();
    public DatePickerDialog.OnDateSetListener S1 = new E0();
    public boolean T1 = false;
    public int U1 = 0;
    public boolean V1 = false;
    public int X1 = 3;
    public int Y1 = 4;
    public ActivityResultLauncher Z1 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Xg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.T0((Uri) obj);
        }
    });
    public ActivityResultLauncher a2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new C2772h());
    public String c2 = null;
    public String d2 = null;
    public String e2 = null;
    public String f2 = null;
    public int g2 = 0;
    public boolean h2 = false;
    public int i2 = 0;
    public int j2 = 0;

    public class A implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public A(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.J0(2);
            this.a.dismiss();
        }
    }

    public class A0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ Handler h;

        public A0(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, AlertDialog alertDialog, EditText editText2, EditText editText3, Handler handler) {
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
            if (Customer_Det_List_edit4.this.i.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit4.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit4.this.O1 = this.b.getText().toString();
                Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                customer_Det_List_edit4.H0(customer_Det_List_edit4.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit4.this.O1, Customer_Det_List_edit4.this);
                if (!Customer_Det_List_edit4.this.K1) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit4.this.i.r1(this.c.getText().toString());
                if (this.d.equals("0")) {
                    if (Customer_Det_List_edit4.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
                        customer_Det_List_edit5.i.Pd(customer_Det_List_edit5, customer_Det_List_edit5.N, this.a.getText().toString().trim() + " : " + Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit4.this);
                        this.e.dismiss();
                        return;
                    }
                    Customer_Det_List_edit4.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.f.getText().toString() + "','" + this.g.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                    Handler handler = this.h;
                    handler.sendMessage(handler.obtainMessage());
                } else if (this.d != null) {
                    Customer_Det_List_edit4.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.f.getText().toString() + "',address='" + this.g.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit4.this.k + "' and id>0 ");
                    Handler handler2 = this.h;
                    handler2.sendMessage(handler2.obtainMessage());
                }
                this.e.dismiss();
            }
        }
    }

    public class B implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public B(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.c0(view, this.a);
        }
    }

    public class B0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ EditText c;

        public B0(AutoCompleteTextView autoCompleteTextView, Dialog dialog, EditText editText) {
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
                    Customer_Det_List_edit4.this.k1();
                }
            }
        }
    }

    public class C implements Runnable {
        public final /* synthetic */ int a;

        public C(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == 4) {
                Customer_Det_List_edit4.this.k1.selectAll();
            }
        }
    }

    public class C0 implements DatePickerDialog.OnDateSetListener {
        public C0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit4.this.K = i;
            Customer_Det_List_edit4.this.L = i2;
            Customer_Det_List_edit4.this.M = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit4.this.M)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit4.this.L + 1)) + "-" + Customer_Det_List_edit4.this.K;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit4.this.S.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
                Customer_Det_List_edit4.this.r1();
            } catch (Exception unused) {
            }
        }
    }

    public class D implements AdapterView.OnItemClickListener {
        public D() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit4.this.i1.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit4.this.b1();
            Customer_Det_List_edit4.this.f1.requestFocus();
            if (Customer_Det_List_edit4.k2 == 3) {
                if (!Customer_Det_List_edit4.this.i.ja("t_name_lock", false) || Customer_Det_List_edit4.this.f1.getText() == null || Customer_Det_List_edit4.this.f1.getText().toString().length() <= 0) {
                    Customer_Det_List_edit4.this.f1.requestFocus();
                } else {
                    Customer_Det_List_edit4.this.k1.requestFocus();
                }
            }
            Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
            customer_Det_List_edit4.j1(0, customer_Det_List_edit4.i1.getText().toString(), Customer_Det_List_edit4.this.f0.getTag().toString());
        }
    }

    public class D0 implements DatePickerDialog.OnDateSetListener {
        public D0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit4.this.K = i;
            Customer_Det_List_edit4.this.L = i2;
            Customer_Det_List_edit4.this.M = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit4.this.M)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit4.this.L + 1)) + "-" + Customer_Det_List_edit4.this.K;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit4.this.R.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class E implements AdapterView.OnItemClickListener {
        public E() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit4.this.f1.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit4.this.b1();
            Customer_Det_List_edit4.this.k1.requestFocus();
            Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
            customer_Det_List_edit4.j1(0, customer_Det_List_edit4.f1.getText().toString(), Customer_Det_List_edit4.this.f0.getTag().toString());
        }
    }

    public class E0 implements DatePickerDialog.OnDateSetListener {
        public E0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit4.this.K = i;
            Customer_Det_List_edit4.this.L = i2;
            Customer_Det_List_edit4.this.M = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit4.this.M)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit4.this.L + 1)) + "-" + Customer_Det_List_edit4.this.K;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit4.this.Q.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class F implements View.OnTouchListener {
        public F() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Customer_Det_List_edit4.this.i1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit4.this.i1.getCompoundDrawables()[0] != null ? Customer_Det_List_edit4.this.i1.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit4.this.i1.getPaddingLeft() + Customer_Det_List_edit4.this.i1.getLeft()) {
                    Customer_Det_List_edit4.this.i1.setText("");
                    Customer_Det_List_edit4.this.i1.requestFocus();
                    Customer_Det_List_edit4.this.b1();
                    return false;
                }
                if (motionEvent.getX() >= (Customer_Det_List_edit4.this.i1.getRight() - Customer_Det_List_edit4.this.i1.getPaddingRight()) - (Customer_Det_List_edit4.this.i1.getCompoundDrawables()[2] != null ? Customer_Det_List_edit4.this.i1.getCompoundDrawables()[2].getBounds().width() : 0)) {
                    Z00 z00 = Customer_Det_List_edit4.this.i;
                    z00.Mc("f_name_lock", true ^ z00.ja("f_name_lock", false));
                    Customer_Det_List_edit4.this.a1();
                }
            }
            return false;
        }
    }

    public class F0 implements View.OnClickListener {
        public F0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.g0.setTag(((RadioButton) view).getText().toString());
            Customer_Det_List_edit4.this.r1();
            Customer_Det_List_edit4.this.t1();
        }
    }

    public class G implements TextWatcher {
        public G() {
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
                Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                customer_Det_List_edit4.i1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit4, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit4.this.i1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit4.this.i1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class H implements View.OnTouchListener {
        public H() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Customer_Det_List_edit4.this.f1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit4.this.f1.getCompoundDrawables()[0] != null ? Customer_Det_List_edit4.this.f1.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit4.this.f1.getPaddingLeft() + Customer_Det_List_edit4.this.f1.getLeft()) {
                    Customer_Det_List_edit4.this.f1.setText("");
                    Customer_Det_List_edit4.this.f1.requestFocus();
                    Customer_Det_List_edit4.this.b1();
                    return false;
                }
                if (motionEvent.getX() >= (Customer_Det_List_edit4.this.f1.getRight() - Customer_Det_List_edit4.this.f1.getPaddingRight()) - (Customer_Det_List_edit4.this.f1.getCompoundDrawables()[2] != null ? Customer_Det_List_edit4.this.f1.getCompoundDrawables()[2].getBounds().width() : 0)) {
                    Z00 z00 = Customer_Det_List_edit4.this.i;
                    z00.Mc("t_name_lock", true ^ z00.ja("t_name_lock", false));
                    Customer_Det_List_edit4.this.a1();
                }
            }
            return false;
        }
    }

    public class I implements CompoundButton.OnCheckedChangeListener {
        public I() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (Customer_Det_List_edit4.this.p != 0) {
                Customer_Det_List_edit4.this.J0(1);
            }
        }
    }

    public class J implements TextWatcher {
        public J() {
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
                Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                customer_Det_List_edit4.f1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit4, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit4.this.f1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit4.this.f1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class K implements TextWatcher {
        public K() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Customer_Det_List_edit4.this.b1();
        }
    }

    public class L implements View.OnClickListener {
        public L() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.showDialog(0);
            Customer_Det_List_edit4.this.j2 = 1;
        }
    }

    public class M implements View.OnClickListener {
        public M() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.showDialog(5);
            Customer_Det_List_edit4.this.j2 = 1;
        }
    }

    public class N implements View.OnClickListener {
        public N() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.showDialog(4);
            Customer_Det_List_edit4.this.j2 = 1;
        }
    }

    public class O implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public O(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
            if (customer_Det_List_edit4.f0(customer_Det_List_edit4.o1.getId())) {
                Customer_Det_List_edit4.this.J0(4);
                if (Customer_Det_List_edit4.this.W.getText().toString().equals("0")) {
                    this.a.dismiss();
                    FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit4.this);
                    Customer_Det_List_edit4.this.k1();
                } else {
                    Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit5.i.Kd(customer_Det_List_edit5, customer_Det_List_edit5.getString(info.aalmoghalis.inventory.R.string.move_inserted), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                    Customer_Det_List_edit4.k2 = 3;
                    Customer_Det_List_edit4.this.i1(true);
                    Customer_Det_List_edit4.this.j2 = 1;
                }
            }
        }
    }

    public class P implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public P(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
            if (customer_Det_List_edit4.f0(customer_Det_List_edit4.p1.getId())) {
                Customer_Det_List_edit4.this.J0(4);
                if (Customer_Det_List_edit4.this.W.getText().toString().equals("0")) {
                    this.a.dismiss();
                    FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit4.this);
                    Customer_Det_List_edit4.this.k1();
                } else {
                    Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit5.i.Kd(customer_Det_List_edit5, customer_Det_List_edit5.getString(info.aalmoghalis.inventory.R.string.move_inserted), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                    Customer_Det_List_edit4.k2 = 3;
                    Customer_Det_List_edit4.this.i1(true);
                    Customer_Det_List_edit4.this.j2 = 1;
                }
            }
        }
    }

    public class Q implements View.OnClickListener {
        public Q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.F0 = true;
        }
    }

    public class R implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public R(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit4.this.h0()) {
                this.a.dismiss();
                FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit4.this);
                Customer_Det_List_edit4.this.J0(2);
            }
        }
    }

    public class S implements View.OnClickListener {
        public S() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.calc_pick_btn(view);
        }
    }

    public class T implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public T(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.c0(view, this.a);
        }
    }

    public class U implements AdapterView.OnItemClickListener {
        public U() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit4.this.i1.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit4.this.k1.requestFocus();
            Customer_Det_List_edit4.this.K0();
            Customer_Det_List_edit4.this.k1.selectAll();
            Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
            customer_Det_List_edit4.j1(0, customer_Det_List_edit4.i1.getText().toString(), Customer_Det_List_edit4.this.f0.getTag().toString());
        }
    }

    public class V implements TextWatcher {
        public V() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Customer_Det_List_edit4.this.K0();
        }
    }

    public class W implements TextWatcher {
        public W() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Customer_Det_List_edit4.this.K0();
        }
    }

    public class X implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public X(TextView textView, ImageView imageView) {
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
                Customer_Det_List_edit4.this.i.v0("update categ set fav=" + str + " where name = '" + this.a.getText().toString() + "'");
                Customer_Det_List_edit4.this.p = 0;
                Customer_Det_List_edit4.this.J0(1);
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit4.this.getApplicationContext(), Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class Y implements DialogInterface.OnClickListener {
        public Y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Z implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public Z(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Customer_Det_List_edit4.this.i.v0("delete from tr_p_temps  where no_=  '" + this.a.getText().toString() + "'");
                    Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit4.L0 = 1;
                    customer_Det_List_edit4.J0(2);
                    Customer_Det_List_edit4.this.v0();
                }
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit4.this.getApplicationContext(), Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$a, reason: case insensitive filesystem */
    public class HandlerC2759a extends Handler {
        public HandlerC2759a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$a0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2760a0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2760a0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2761b implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public ViewOnClickListenerC2761b(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.c0(view, this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$b0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2762b0 implements View.OnClickListener {
        public ViewOnClickListenerC2762b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.F0 = true;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2763c implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public ViewOnClickListenerC2763c(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.c0(view, this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$c0, reason: case insensitive filesystem */
    public class HandlerC2764c0 extends Handler {
        public HandlerC2764c0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$d, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2765d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2765d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                customer_Det_List_edit4.e0(2, customer_Det_List_edit4.u);
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit4.this.getApplicationContext(), Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$d0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2766d0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public DialogInterfaceOnClickListenerC2766d0(Handler handler, String str, int i) {
            this.a = handler;
            this.b = str;
            this.c = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit4.this.Y(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$e, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2767e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2767e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
            if (customer_Det_List_edit4.i2 == 1) {
                customer_Det_List_edit4.finish();
            } else {
                customer_Det_List_edit4.j2 = 0;
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$e0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2768e0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2768e0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit4.this.K1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$f, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2769f implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC2769f(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit4.this);
                if (this.a[i].equals(Customer_Det_List_edit4.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit4.W1 = customer_Det_List_edit4.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit4.this.j0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit4.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit5.W1 = customer_Det_List_edit5.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit4.this.D0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit4.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit4.this.i.qa(Z00.M + Customer_Det_List_edit4.this.u1.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit4.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit4.this.u1.setTag(null);
                    Customer_Det_List_edit4.this.u1.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$f0, reason: case insensitive filesystem */
    public class HandlerC2770f0 extends Handler {
        public HandlerC2770f0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$g, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2771g implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC2771g(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit4.this);
                if (this.a[i].equals(Customer_Det_List_edit4.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit4.W1 = customer_Det_List_edit4.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit4.this.j0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit4.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit5.W1 = customer_Det_List_edit5.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit4.this.D0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit4.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit4.this.i.qa(Z00.M + Customer_Det_List_edit4.this.t1.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit4.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit4.this.t1.setTag(null);
                    Customer_Det_List_edit4.this.t1.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Customer_Det_List_edit4.this.t1.getLayoutParams().width = (int) Customer_Det_List_edit4.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Customer_Det_List_edit4.this.t1.getLayoutParams().height = (int) Customer_Det_List_edit4.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class g0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public g0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit4.this.Z(this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$h, reason: case insensitive filesystem */
    public class C2772h implements ActivityResultCallback {
        public C2772h() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Customer_Det_List_edit4.this.m1();
            }
        }
    }

    public class h0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public h0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit4.this.K1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$i, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2773i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2773i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String str;
            try {
                Z00 z00 = Customer_Det_List_edit4.this.i;
                StringBuilder sb = new StringBuilder();
                sb.append("delete from transactions where p_id='");
                sb.append(Customer_Det_List_edit4.this.p);
                sb.append("' and p_id <>0 and bill_id=-2  and p_date='");
                sb.append(Customer_Det_List_edit4.this.q);
                sb.append("' ");
                if (Customer_Det_List_edit4.this.t.equals("0")) {
                    str = " ";
                } else {
                    str = " and  ifnull(substr( online_ref2, instr(online_ref2, ':')),'0') ='" + Customer_Det_List_edit4.this.t + "'";
                }
                sb.append(str);
                z00.v0(sb.toString());
                FragmentStatePagerSupport_Main.a0 = true;
                Bill_edit.P2 = true;
                Customer_Det_List_edit4.this.d1();
                Daily_Trans_Report.t0--;
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit4.this.getApplicationContext(), "SQL Error.", 1);
            }
        }
    }

    public class i0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public i0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$j, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2774j implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2774j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class j0 implements TextWatcher {
        public j0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
            if (customer_Det_List_edit4.F0) {
                customer_Det_List_edit4.F0 = false;
            } else {
                customer_Det_List_edit4.j2 = 1;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$k, reason: case insensitive filesystem */
    public class C2775k implements AdapterView.OnItemClickListener {
        public C2775k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit4.this.R0.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
            customer_Det_List_edit4.B = customer_Det_List_edit4.R0.getText().toString();
            Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
            customer_Det_List_edit5.F = "";
            customer_Det_List_edit5.G = "";
            customer_Det_List_edit5.E = "";
            Customer_Det_List_edit4.k2 = 1;
            customer_Det_List_edit5.V0(true);
            Customer_Det_List_edit4 customer_Det_List_edit6 = Customer_Det_List_edit4.this;
            customer_Det_List_edit6.j1(0, customer_Det_List_edit6.R0.getText().toString(), Customer_Det_List_edit4.this.f0.getTag().toString());
        }
    }

    public class k0 implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public k0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$l, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2776l implements View.OnTouchListener {
        public ViewOnTouchListenerC2776l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Customer_Det_List_edit4.this.R0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit4.this.R0.getCompoundDrawables()[0] != null ? Customer_Det_List_edit4.this.R0.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit4.this.R0.getPaddingLeft() + Customer_Det_List_edit4.this.R0.getLeft()) {
                    Customer_Det_List_edit4.this.R0.setText("");
                    Customer_Det_List_edit4.this.R0.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Customer_Det_List_edit4.this.R0.getRight();
                Customer_Det_List_edit4.this.R0.getPaddingRight();
                if (Customer_Det_List_edit4.this.R0.getCompoundDrawables()[2] != null) {
                    Customer_Det_List_edit4.this.R0.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class l0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public l0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.r0(this.a, this.b, null);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$m, reason: case insensitive filesystem */
    public class C2777m implements AdapterView.OnItemClickListener {
        public C2777m() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                Customer_Det_List_edit4.this.H = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.no_)).getText().toString();
                Customer_Det_List_edit4.this.B = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_name)).getText().toString();
                Customer_Det_List_edit4.this.E = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_qty)).getText().toString();
                Customer_Det_List_edit4.this.F = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_price)).getText().toString();
                Customer_Det_List_edit4.this.G = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_weight)).getText().toString();
                C0634Jt c0634Jt = (C0634Jt) Customer_Det_List_edit4.this.N.getAdapter().getItem(i);
                if (c0634Jt != null) {
                    Customer_Det_List_edit4.this.I = c0634Jt.k();
                    Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                    String str = customer_Det_List_edit4.I;
                    if (str == null) {
                        str = "";
                    }
                    customer_Det_List_edit4.I = str;
                }
                Customer_Det_List_edit4.k2 = 2;
                int i2 = Integer.parseInt(Customer_Det_List_edit4.this.H);
                if (Customer_Det_List_edit4.this.i.L8(i2).equals("0")) {
                    C0634Jt c0634Jt2 = (C0634Jt) adapterView.getItemAtPosition(i);
                    Customer_Det_List_edit4.this.C = c0634Jt2.j();
                    Customer_Det_List_edit4.this.D = c0634Jt2.b();
                    Log.d("tr_curr_name=", Customer_Det_List_edit4.this.C + "");
                    Customer_Det_List_edit4.this.y0(false);
                    return;
                }
                Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
                String str2 = customer_Det_List_edit5.B;
                customer_Det_List_edit5.c2 = str2;
                customer_Det_List_edit5.d1 = str2;
                customer_Det_List_edit5.e1 = customer_Det_List_edit5.i.M8(i2);
                Log.d("click=", i2 + ":" + Customer_Det_List_edit4.this.d1 + ":" + Customer_Det_List_edit4.this.e1);
                Customer_Det_List_edit4 customer_Det_List_edit6 = Customer_Det_List_edit4.this;
                if (customer_Det_List_edit6.e1.equals(customer_Det_List_edit6.c2)) {
                    Customer_Det_List_edit4 customer_Det_List_edit7 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit7.d1 = customer_Det_List_edit7.i.K8(i2);
                }
                Customer_Det_List_edit4.this.D = ((C0634Jt) adapterView.getItemAtPosition(i)).b();
                Customer_Det_List_edit4.this.z0(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class m0 implements DialogInterface.OnClickListener {
        public m0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$n, reason: case insensitive filesystem */
    public class C2778n implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$n$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Customer_Det_List_edit4.this.w0();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit4.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$n$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2778n() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == info.aalmoghalis.inventory.R.id.menu_curr) {
                SparseBooleanArray sparseBooleanArrayB = Customer_Det_List_edit4.this.s0.b();
                Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                customer_Det_List_edit4.u0 = sparseBooleanArrayB;
                try {
                    customer_Det_List_edit4.p1();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit4.this.getApplicationContext(), "SQL Error.", 1);
                }
                actionMode.finish();
                return false;
            }
            if (itemId != info.aalmoghalis.inventory.R.id.menu_delete) {
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB2 = Customer_Det_List_edit4.this.s0.b();
            Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
            customer_Det_List_edit5.u0 = sparseBooleanArrayB2;
            AlertDialog.Builder builder = new AlertDialog.Builder(customer_Det_List_edit5);
            builder.setMessage(Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
            builder.setPositiveButton(Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
            builder.setNegativeButton(Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
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
            Log.d("Back_=", "BACK#2");
            Customer_Det_List_edit4.this.N.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Customer_Det_List_edit4.this.s0.j.clear();
            Customer_Det_List_edit4.this.s0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Customer_Det_List_edit4.this.N.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Customer_Det_List_edit4.this.s0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Customer_Det_List_edit4.this.N.getCheckedItemCount() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_curr).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_curr).setVisible(true);
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$o, reason: case insensitive filesystem */
    public class C2779o implements TextWatcher {
        public C2779o() {
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
                Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                customer_Det_List_edit4.R0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit4, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit4.this.R0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit4.this.R0;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class o0 implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ android.app.AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ Handler e;

        public o0(AutoCompleteTextView autoCompleteTextView, android.app.AlertDialog alertDialog, String str, EditText editText, Handler handler) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
            this.c = str;
            this.d = editText;
            this.e = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (zA && Customer_Det_List_edit4.this.i.P5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Customer_Det_List_edit4.this.O1 = this.a.getText().toString();
                Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                customer_Det_List_edit4.I0(customer_Det_List_edit4.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type), Customer_Det_List_edit4.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type) + "#" + Customer_Det_List_edit4.this.O1, this.b.getContext());
                if (!Customer_Det_List_edit4.this.M1) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Customer_Det_List_edit4.this.i.H("insert into items (name,item_type_id) values('" + this.d.getText().toString() + "',(select b.id from item_type b where b.name='" + this.a.getText().toString() + "') )", "insert into item_price (item_id,curr_id,sls_u_price) values((select id from items a where a.name='" + this.d.getText().toString() + "'),(select b.id from currency b where b.name='" + Customer_Det_List_edit4.this.f0.getTag().toString() + "'),'0' )");
                    Customer_Det_List_edit4 customer_Det_List_edit5 = Customer_Det_List_edit4.this;
                    customer_Det_List_edit5.L1 = 0;
                    customer_Det_List_edit5.K1 = true;
                    Customer_Det_List_edit4.this.R0.setText(this.d.getText().toString());
                    Handler handler = this.e;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$p, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2780p implements View.OnClickListener {
        public ViewOnClickListenerC2780p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_fwd_amount) {
                Customer_Det_List_edit4.this.amount_fwd_btn(view);
            } else if (view.getId() == info.aalmoghalis.inventory.R.id.img_u_currency) {
                Customer_Det_List_edit4.this.u_currency_btn(view);
            }
        }
    }

    public class p0 extends Handler {
        public p0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$q, reason: case insensitive filesystem */
    public class HandlerC2781q extends Handler {
        public HandlerC2781q() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class q0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public q0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit4.this.i.v0("insert into item_type  (name )  values( '" + Customer_Det_List_edit4.this.O1 + "'  )");
            Customer_Det_List_edit4.this.N1 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$r, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2782r implements View.OnClickListener {
        public ViewOnClickListenerC2782r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.showDialog(5);
            Customer_Det_List_edit4.this.j2 = 1;
        }
    }

    public class r0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public r0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit4.this.N1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$s, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2783s implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2783s(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit4.this.i0()) {
                Customer_Det_List_edit4.this.J0(2);
                this.a.dismiss();
            }
        }
    }

    public class s0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public s0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$t, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2784t implements View.OnClickListener {
        public ViewOnClickListenerC2784t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.calc_pick_btn(view);
        }
    }

    public class t0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public t0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$u, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2785u implements View.OnClickListener {
        public ViewOnClickListenerC2785u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.n1();
        }
    }

    public class u0 implements View.OnClickListener {
        public u0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.onRadioButtonClicked(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$v, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2786v implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public ViewOnClickListenerC2786v(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.c0(view, this.a);
        }
    }

    public class v0 implements View.OnClickListener {
        public v0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$w, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2787w implements View.OnClickListener {
        public ViewOnClickListenerC2787w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.showDialog(5);
            Customer_Det_List_edit4.this.j2 = 1;
        }
    }

    public class w0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public w0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.k1();
            Customer_Det_List_edit4.this.r0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$x, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2788x implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2788x(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit4.this.g0()) {
                Customer_Det_List_edit4.this.U0();
                Log.d("lock=", Customer_Det_List_edit4.this.i.ja("f_name_lock", false) + ":" + Customer_Det_List_edit4.this.i.ja("t_name_lock", false));
                if (!Customer_Det_List_edit4.this.i.ja("f_name_lock", false) && !Customer_Det_List_edit4.this.i.ja("t_name_lock", false)) {
                    Customer_Det_List_edit4.this.J0(2);
                    this.a.dismiss();
                    return;
                }
                Customer_Det_List_edit4 customer_Det_List_edit4 = Customer_Det_List_edit4.this;
                customer_Det_List_edit4.i.Kd(customer_Det_List_edit4, customer_Det_List_edit4.getString(info.aalmoghalis.inventory.R.string.move_inserted), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                Customer_Det_List_edit4.this.J0(4);
                Customer_Det_List_edit4.k2 = 3;
                Customer_Det_List_edit4.this.o1();
                Customer_Det_List_edit4.this.l1(true);
            }
        }
    }

    public class x0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public x0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.k1();
            Customer_Det_List_edit4.this.r0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$y, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2789y implements View.OnClickListener {
        public ViewOnClickListenerC2789y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.calc_pick_btn(view);
        }
    }

    public class y0 implements DialogInterface.OnClickListener {
        public y0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit4$z, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2790z implements View.OnClickListener {
        public ViewOnClickListenerC2790z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit4.this.n1();
        }
    }

    public class z0 implements DialogInterface.OnClickListener {
        public z0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.Z1.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.Y1);
    }

    private boolean O0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean P0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && O0(21, 22);
    }

    public static boolean Q0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean R0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean S0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        X0(uri, true);
    }

    private void W0(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                u0(new File(Z00.A0), file2);
            } else {
                u0(new File(F0(this, this.b2)), file2);
            }
            g1(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void X0(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.i, this);
            if (strX != null) {
                g1(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void e1(ImageView imageView) {
        this.J1 = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
        imageView.getLayoutParams().width = this.J1;
        imageView.getLayoutParams().height = this.J1;
    }

    private void f1() {
        String[] stringArray = this.t1.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC2769f(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
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
            this.a2.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean k0() {
        Log.d("IMEI=", "AFTER VALIDATION");
        boolean zA = AbstractC4371yX.a(this.k1);
        if (!AbstractC4371yX.a(this.v1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.i1)) {
            zA = false;
        }
        if (this.i.u3(this.i1.getText().toString()) != 0 || this.i.u3(this.i1.getText().toString().trim()) != 0) {
            return zA;
        }
        this.i1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    private boolean l0() {
        boolean zA = AbstractC4371yX.a(this.i1);
        boolean z = false;
        if (!AbstractC4371yX.a(this.f1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.k1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.w1)) {
            zA = false;
        }
        if (this.i1.getText().toString().equals(this.f1.getText().toString())) {
            this.f1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.i.u3(this.f1.getText().toString()) == 0 && this.i.u3(this.f1.getText().toString().trim()) == 0) {
            this.f1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.i.u3(this.i1.getText().toString()) == 0 && this.i.u3(this.i1.getText().toString().trim()) == 0) {
            this.i1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
        } else {
            z = zA;
        }
        if (z) {
            this.j2 = 1;
        }
        return z;
    }

    private void m0() {
        if (this.i.u3(this.i1.getText().toString()) == 0 && this.i.u3(this.i1.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.i1;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.i1.getText().toString().length() >= 1 && this.n1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_add))) {
                G0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.i1.getText()), this, this.i1.getText().toString(), 0);
                this.v0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
                this.i1.setThreshold(1);
                this.i1.setAdapter(this.v0);
            }
        }
        if (!this.i1.getText().toString().equals(this.i1.getText().toString().trim()) && this.i.u3(this.i1.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView2 = this.i1;
            autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
        }
        this.i.D = false;
        if (this.f0.getTag() != null && !this.f0.getTag().toString().equals(this.i.l3("0"))) {
            if (this.i.ja("prefOthers_trans_curr", false)) {
                this.i.v(this, this.f0.getTag().toString(), this.p, getString(info.aalmoghalis.inventory.R.string.change_curr_price), true);
            } else if (this.i.Z2(this.f0.getTag().toString(), this.i.cc(this.S.getText().toString())) == 0) {
                this.i.u(this, this.f0.getTag().toString(), this.i.cc(this.S.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
            }
        }
        this.i.D = false;
        if (this.g0.getTag() == null || this.g0.getTag().toString().equals(this.i.l3("0")) || this.i.Z2(this.g0.getTag().toString(), this.i.cc(this.S.getText().toString())) != 0) {
            return;
        }
        this.i.u(this, this.g0.getTag().toString(), this.i.cc(this.S.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    private void n0() {
        if (this.i.u3(this.f1.getText().toString()) == 0 && this.i.u3(this.f1.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.f1;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.f1.getText().toString().length() >= 1 && this.n1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                G0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.f1.getText()), this, this.f1.getText().toString(), 0);
            }
        }
        if (!this.f1.getText().toString().equals(this.f1.getText().toString().trim()) && this.i.u3(this.f1.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView2 = this.f1;
            autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
        }
        if (this.i.u3(this.i1.getText().toString()) == 0 && this.i.u3(this.i1.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView3 = this.i1;
            autoCompleteTextView3.setText(autoCompleteTextView3.getText().toString().trim());
            if (this.i1.getText().toString().length() >= 1 && this.n1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                G0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.i1.getText()), this, this.i1.getText().toString(), 0);
            }
        }
        if (!this.i1.getText().toString().equals(this.i1.getText().toString().trim()) && this.i.u3(this.i1.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView4 = this.i1;
            autoCompleteTextView4.setText(autoCompleteTextView4.getText().toString().trim());
        }
        this.i.D = false;
        if (this.f0.getTag() == null || this.f0.getTag().toString().equals(this.i.l3("0")) || this.i.Z2(this.f0.getTag().toString(), this.i.cc(this.S.getText().toString())) != 0) {
            return;
        }
        this.i.u(this, this.f0.getTag().toString(), this.i.cc(this.S.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    private boolean o0() {
        boolean zA = AbstractC4371yX.a(this.k1);
        boolean z = false;
        if (!AbstractC4371yX.a(this.w1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.i1)) {
            zA = false;
        }
        if (this.i1.getText().length() == 0) {
            zA = false;
        }
        if (this.i.u3(this.i1.getText().toString()) == 0 && this.i.u3(this.i1.getText().toString().trim()) == 0) {
            this.i1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
        } else {
            z = zA;
        }
        if (z) {
            this.j2 = 1;
        }
        return z;
    }

    private void u0(File file, File file2) throws IOException {
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

    private void u1() {
    }

    private void x0() {
        String[] stringArray = this.t1.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC2771g(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    public void A0() {
        try {
            this.h0 = this.i.j3();
            Log.d("radioGroup_curr=", this.h0.size() + ":" + this.z);
            String str = this.z;
            if (str == null) {
                str = "";
            }
            this.z = str;
            int size = this.h0.size();
            RadioButton[] radioButtonArr = new RadioButton[size];
            this.f0.setTag(null);
            this.f0.removeAllViews();
            this.f0.clearCheck();
            for (int i = 0; i < this.h0.size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButtonArr[i] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.h0.get(i)).get("name"));
                radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.h0.get(i)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i].setButtonDrawable(android.R.color.transparent);
                radioButtonArr[i].setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.btn_radio), (Drawable) null);
                radioButtonArr[i].setOnClickListener(new u0());
                this.f0.addView(radioButtonArr[i]);
                String str2 = this.A;
                if (str2 != null && str2.equals(((HashMap) this.h0.get(i)).get("name"))) {
                    this.f0.check(radioButtonArr[i].getId());
                    this.f0.setTag(((HashMap) this.h0.get(i)).get("name"));
                }
            }
            if (!this.z.equals("")) {
                this.f0.setTag(this.z);
                for (int i2 = 0; i2 < size; i2++) {
                    if (radioButtonArr[i2].getText().toString().equals(this.z)) {
                        this.f0.check(radioButtonArr[i2].getId());
                    }
                }
                return;
            }
            String str3 = this.A;
            if (str3 == null || str3.equals("")) {
                this.f0.check(radioButtonArr[this.h0.size() - 1].getId());
                this.f0.setTag(radioButtonArr[this.h0.size() - 1].getText().toString());
                this.z = radioButtonArr[this.h0.size() - 1].getText().toString();
            }
        } catch (Exception e) {
            Log.d("fill_curr_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void B0(boolean z) {
        String str;
        try {
            this.h0 = this.i.j3();
            Log.d("radioGroup_curr2=", this.h0.size() + ":" + this.z);
            String str2 = this.z;
            if (str2 == null) {
                str2 = "";
            }
            this.z = str2;
            int size = this.h0.size();
            RadioButton[] radioButtonArr = new RadioButton[size];
            this.g0.setTag(null);
            this.g0.removeAllViews();
            this.g0.clearCheck();
            for (int i = 0; i < this.h0.size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButtonArr[i] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.h0.get(i)).get("name"));
                radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.h0.get(i)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i].setButtonDrawable(android.R.color.transparent);
                radioButtonArr[i].setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.btn_radio), (Drawable) null);
                radioButtonArr[i].setOnClickListener(new F0());
                this.g0.addView(radioButtonArr[i]);
                if (!z && (str = this.C) != null && str.equals(((HashMap) this.h0.get(i)).get("name"))) {
                    Log.d("tr_curr_name_l=", this.C + ":" + ((String) ((HashMap) this.h0.get(i)).get("name")) + ":" + this.c2);
                    this.g0.check(radioButtonArr[i].getId());
                    this.g0.setTag(((HashMap) this.h0.get(i)).get("name"));
                } else if (z && this.f0.getTag().toString().equals(((HashMap) this.h0.get(i)).get("name"))) {
                    this.g0.check(radioButtonArr[i].getId());
                    this.g0.setTag(((HashMap) this.h0.get(i)).get("name"));
                }
            }
            if (this.z.equals("") && this.g0.getTag() == null) {
                this.g0.check(radioButtonArr[this.h0.size() - 1].getId());
                this.g0.setTag(radioButtonArr[this.h0.size() - 1].getText().toString());
            } else if (this.g0.getTag() == null) {
                this.g0.setTag(this.z);
                for (int i2 = 0; i2 < size; i2++) {
                    if (radioButtonArr[i2].getText().toString().equals(this.z)) {
                        this.g0.check(radioButtonArr[i2].getId());
                    }
                }
            }
        } catch (Exception e) {
            Log.d("fill_curr_error2=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void C0(Cursor cursor) {
        Customer_Det_List_edit4 customer_Det_List_edit4 = this;
        Log.d("Cursor_cnt=", String.valueOf(cursor.getCount()));
        customer_Det_List_edit4.t0.clear();
        cursor.moveToFirst();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (!cursor.isAfterLast()) {
            customer_Det_List_edit4.t0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("cus_name")), cursor.getString(cursor.getColumnIndex("param1")), cursor.getString(cursor.getColumnIndex("tr_remarks")), customer_Det_List_edit4.i.P7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("debit")))), customer_Det_List_edit4.i.P7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("credit")))), cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tr_curr_name")), cursor.getString(cursor.getColumnIndex("date_"))));
            d += (cursor.getDouble(cursor.getColumnIndex("credit")) * cursor.getDouble(cursor.getColumnIndex("curr_price"))) / cursor.getDouble(cursor.getColumnIndex("p_curr_price"));
            d2 += (cursor.getDouble(cursor.getColumnIndex("debit")) * cursor.getDouble(cursor.getColumnIndex("curr_price"))) / cursor.getDouble(cursor.getColumnIndex("p_curr_price"));
            d3 = d2 - d;
            this.z = cursor.getString(cursor.getColumnIndex("doc_curr_name"));
            if (this.p != 0) {
                this.z = cursor.getString(cursor.getColumnIndex("doc_curr_name"));
                this.S.setText(cursor.getString(cursor.getColumnIndex("p_date")));
                this.q0.setText(cursor.getString(cursor.getColumnIndex("bill_no")));
                this.q0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + cursor.getString(cursor.getColumnIndex("bill_no")));
                if (this.q0.getText() == null || this.q0.getText().length() == 0) {
                    this.q0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.i.r5(0, -2));
                }
                this.r0.setText(cursor.getString(cursor.getColumnIndex("p_remarks")));
            }
            cursor.moveToNext();
            customer_Det_List_edit4 = this;
        }
        Customer_Det_List_edit4 customer_Det_List_edit5 = customer_Det_List_edit4;
        cursor.close();
        customer_Det_List_edit5.U.setText(customer_Det_List_edit5.i.P7(d + ""));
        TextView textView = customer_Det_List_edit5.V;
        Z00 z00 = customer_Det_List_edit5.i;
        textView.setText(z00.P7(d2 + ""));
        customer_Det_List_edit5.W.setText(customer_Det_List_edit5.i.P7(d3 + ""));
        C0809Ov c0809Ov = new C0809Ov(customer_Det_List_edit5, info.aalmoghalis.inventory.R.layout.doc_item_det_row3, customer_Det_List_edit5.t0, customer_Det_List_edit5.z);
        customer_Det_List_edit5.s0 = c0809Ov;
        c0809Ov.j.clear();
        customer_Det_List_edit5.s0.notifyDataSetChanged();
        customer_Det_List_edit5.N.setAdapter((ListAdapter) customer_Det_List_edit5.s0);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String E0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public String F0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (R0(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (Q0(uri)) {
                        return E0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (S0(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return E0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return E0(context, uri, null, null);
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

    public boolean G0(String str, String str2, Context context, String str3, int i) {
        HandlerC2764c0 handlerC2764c0 = new HandlerC2764c0();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2766d0(handlerC2764c0, str3, i));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2768e0(handlerC2764c0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.K1;
    }

    public boolean H0(String str, String str2, Context context) {
        HandlerC2770f0 handlerC2770f0 = new HandlerC2770f0();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new g0(handlerC2770f0));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new h0(handlerC2770f0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.K1;
    }

    public boolean I0(String str, String str2, Context context) {
        p0 p0Var = new p0();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new q0(p0Var));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new r0(p0Var));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.N1;
    }

    public void J0(int i) {
        int i2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Yes:");
            sb.append(this.p);
            sb.append(":");
            sb.append(i);
            sb.append("::");
            sb.append(this.f0.getTag() == null ? "" : this.f0.getTag().toString());
            sb.append("#");
            sb.append(this.j2);
            sb.append(":date=");
            sb.append(this.q);
            sb.append(":dev_id=");
            sb.append(this.t);
            Log.d("get_all_name=", sb.toString());
            this.i.v0("update tr_p_temps set curr_price=0 where curr_id=0");
            this.i.v0("update tr_p_temps set p_curr_price=0 where p_curr_id=0");
            if (i == 1 && (i2 = this.p) != 0) {
                C0(this.i.j5(String.valueOf(i2), "-2", "0", this.q, this.t));
                this.j2 = 0;
            } else if (i == 2) {
                C0(this.i.p5("-2"));
                k1();
                this.R0.setText("");
            } else if (i == 3) {
                C0(this.i.j5(String.valueOf(this.p), "-2", "0", this.q, this.t));
                this.j2 = 0;
            } else if (i == 4) {
                C0(this.i.p5("-2"));
                this.R0.setText("");
            }
            ArrayList arrayListI8 = this.i.I8("-2");
            this.i0 = arrayListI8;
            if (arrayListI8 == null || arrayListI8.size() <= 0) {
                this.e0.setVisibility(8);
            } else {
                this.e0.setVisibility(0);
            }
        } catch (Exception e) {
            Log.d("Fetch_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void K0() {
        C1044Xj.a().c(new RunnableC1171Zj(4, this.i, this.i1, this.w1, this.v1, this, this.C1, k2, this.n1, new RunnableC1086Yj()));
    }

    public void L0() {
        String str;
        try {
            if (getIntent().getStringExtra("P_ID") != null) {
                this.p = Integer.parseInt(getIntent().getStringExtra("P_ID"));
                if (getIntent().getStringExtra(DublinCoreProperties.DATE) != null) {
                    this.q = getIntent().getStringExtra(DublinCoreProperties.DATE);
                    this.t = getIntent().getStringExtra("dev_id") == null ? "0" : getIntent().getStringExtra("dev_id");
                    Log.d("tr_date_=", this.q + ":dev_id=" + this.t);
                    this.i.v0("delete from tr_p_temps");
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,curr_price,p_curr_price,curr_mod,param1,param2) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,id,curr_price,p_curr_price,curr_mod,param1,param2 from transactions_v where p_id='");
                    sb.append(this.p);
                    sb.append("' and bill_id=-2 and ifnull(p_date,date_)='");
                    sb.append(this.q);
                    sb.append("' ");
                    if (this.t.equals("0")) {
                        str = " ";
                    } else {
                        str = " and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + this.t + "' ";
                    }
                    sb.append(str);
                    z00.v0(sb.toString());
                } else {
                    this.i.v0("delete from tr_p_temps");
                    this.i.v0("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,curr_price,p_curr_price,curr_mod,param1,param2) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,id,curr_price,p_curr_price,curr_mod,param1,param2 from transactions_v where p_id='" + this.p + "' and bill_id=-2 ");
                }
                this.J = getIntent().getIntExtra("back_edit", 0);
            }
            this.J = getIntent().getIntExtra("back_edit", 0);
        } catch (Exception unused) {
        }
    }

    public void M0() {
        Log.d("go_doc_list=", HTML.Attribute.START);
        Bill_edit.P2 = false;
        Intent intent = new Intent(this, (Class<?>) Daily_Trans_Report.class);
        intent.addFlags(67108864);
        intent.putExtra("g_id", this.l);
        intent.putExtra("g_name", this.n);
        intent.putExtra("title_", getResources().getStringArray(info.aalmoghalis.inventory.R.array.action_3)[5].toString().replaceAll("تقرير -", ""));
        if (this.i.S()) {
            intent.putExtra("sync", "1");
        }
        startActivity(intent);
        finish();
    }

    public void N0(int i, int i2) {
        try {
            new Handler().postDelayed(new C(i), i2);
        } catch (Exception unused) {
        }
    }

    public void U0() {
        try {
            this.i1.requestFocus();
            this.w1.setText((CharSequence) null);
            this.t1.setTag(null);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
            Log.d("move_transaction", e.getMessage());
        }
    }

    public void V0(boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_doc_item_move_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.i1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.from_cus_name);
            this.f1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.to_cus_name);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.k1 = editText;
            this.m1 = editText;
            editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
            EditText editText2 = this.k1;
            editText2.addTextChangedListener(new C2018dE(editText2));
            this.Q = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.n1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
            this.r1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
            this.t1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            this.G1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.s1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_swap);
            this.q1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_close);
            this.w1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.A1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
            this.B1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.C1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
            this.F1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
            this.Q.setOnClickListener(new ViewOnClickListenerC2787w());
            if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                this.Q.setVisibility(0);
            } else {
                this.Q.setVisibility(8);
            }
            this.Q.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
            l1(z);
            builder.setCancelable(true);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            this.n1.setOnClickListener(new ViewOnClickListenerC2788x(alertDialogCreate));
            this.r1.setOnClickListener(new ViewOnClickListenerC2789y());
            this.s1.setOnClickListener(new ViewOnClickListenerC2790z());
            this.q1.setOnClickListener(new A(alertDialogCreate));
            this.t1.setOnClickListener(new B(z));
            alertDialogCreate.getWindow().getAttributes().gravity = 48;
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("move_transaction_error=", ":" + e.getMessage());
        }
    }

    public void Y(Handler handler, String str, int i) {
        q1("0", str.trim(), "", this.i.T5("0"), "", "", handler);
    }

    public void Y0(int i) {
        String string;
        Z00 z00 = this.i;
        ListView listView = this.N;
        String strIc = z00.ic(this.A0);
        if (this.q0.getText().length() == 0) {
            string = this.p + "";
        } else {
            string = this.q0.getText().toString();
        }
        z00.La(listView, strIc, string, this.S.getText().toString(), this.r0.getText().toString(), this.U.getText().toString(), this.f0.getTag().toString());
        if (i == 2) {
            this.i.qd(this.i.ic(this.A0) + ".pdf");
            return;
        }
        if (i == 1) {
            this.i.ra(this.i.ic(this.A0) + ".pdf");
            return;
        }
        if (i == 3) {
            this.i.Hd(this.f2, this.i.ic(this.A0) + ".pdf");
        }
    }

    public void Z(Handler handler) {
        s1("", this.V0.getText().toString(), "", handler);
    }

    public void Z0(int i) {
        if (i == 0) {
            return;
        }
        this.A0 = getTitle().toString();
        if (this.g2 == 1) {
            a0();
            this.g2 = 0;
            Y0(1);
        } else {
            this.g2 = 0;
            if (this.N.getAdapter().getCount() != 1) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.not_valid_share), 1).show();
                Y0(2);
            }
        }
    }

    public void a0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void a1() {
        if (this.i.ja("f_name_lock", false)) {
            AutoCompleteTextView autoCompleteTextView = this.i1;
            autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_lock), (Drawable) null);
            this.i1.dismissDropDown();
        } else {
            AutoCompleteTextView autoCompleteTextView2 = this.i1;
            autoCompleteTextView2.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView2.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_idle_lock), (Drawable) null);
            this.i1.dismissDropDown();
        }
        if (this.i.ja("t_name_lock", false)) {
            AutoCompleteTextView autoCompleteTextView3 = this.f1;
            autoCompleteTextView3.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView3.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_lock), (Drawable) null);
            this.f1.dismissDropDown();
        } else {
            AutoCompleteTextView autoCompleteTextView4 = this.f1;
            autoCompleteTextView4.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView4.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_idle_lock), (Drawable) null);
            this.f1.dismissDropDown();
        }
    }

    public void add_item(View view) {
        this.B = "";
        this.F = "";
        this.G = "";
        this.E = "";
        this.C = "";
        if (this.R0.getText() == null || this.R0.getText().toString().equals("")) {
            this.B = "";
            this.F = "";
            this.G = "";
            this.E = "";
            this.C = "";
        } else if (this.i.m1().contains(this.R0.getText().toString())) {
            double dG5 = this.i.g5();
            this.B = this.R0.getText().toString();
            this.F = dG5 > 0.0d ? String.valueOf(dG5) : "";
        } else {
            this.B = this.R0.getText().toString();
        }
        k2 = 1;
        y0(true);
    }

    public void amount_fwd_btn(View view) {
        k2 = 1;
        V0(true);
    }

    public void b0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void b1() {
        C1044Xj.a().c(new RunnableC1171Zj(2, this.i, this.i1, this.f1, this.w1, this, this.C1, this.n1, new RunnableC1086Yj()));
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.J0 = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_item_hide(View view) {
        this.n0.setVisibility(8);
        this.o0.setVisibility(0);
        this.l0.setVisibility(0);
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.no_);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new Z(textView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2760a0());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.n0.setVisibility(0);
        this.l0.setVisibility(4);
        this.R0.requestFocus();
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
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new X(textView, imageView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new Y());
        builder.create().show();
    }

    public void c0(View view, boolean z) {
        if (z) {
            f1();
        } else {
            x0();
        }
    }

    public void c1() {
        String str;
        this.i.v0("delete from tr_p_temps");
        if (this.p != 0) {
            Z00 z00 = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,curr_price,p_curr_price,curr_mod,param1,param2) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,id,curr_price,p_curr_price,curr_mod,param1,param2 from transactions_v where p_id='");
            sb.append(this.p);
            sb.append("' and bill_id=-2 ");
            if (this.t.equals("0")) {
                str = " ";
            } else {
                str = " and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + this.t + "' ";
            }
            sb.append(str);
            z00.v0(sb.toString());
        }
    }

    public void calc_pick_btn(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", this.k1.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void d0() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2773i());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2774j());
        builder.create().show();
    }

    public void d1() {
        this.p = 0;
        c1();
        if (this.J == 1) {
            Bill_edit.P2 = true;
        }
        this.q0.setText("");
        this.r0.setText("");
        J0(3);
        this.E0 = this.i.r5(0, -2);
        this.q0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.E0);
        this.R0.requestFocus();
        this.U.setText("0");
        this.V.setText("0");
        this.W.setText("0");
    }

    public void e0(int i, int i2) {
        String str;
        String string;
        String str2;
        String str3;
        String string2;
        String str4;
        String string3;
        int i3;
        String str5;
        String str6;
        String str7 = "Error:";
        try {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            C2160f10.h = MO.b(this);
            if (p0()) {
                if ((this.i.q5().getCount() == 0) && (this.p == 0)) {
                    this.c0.performClick();
                    return;
                }
                Log.d("bill_save=", "tr=" + this.p + ":new_bill=" + this.h2 + ":back_edit=" + this.J);
                if (this.p != 0) {
                    this.q0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.p);
                    if (this.q0.getText().toString().length() > 0 && this.i.x5(this.q0.getText().toString(), this.p, this.t) > 0) {
                        this.q0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("update tr_p_temps set p_amount='");
                    sb.append(this.U.getText().toString().replaceAll(",", ""));
                    sb.append("',p_remarks='");
                    sb.append(this.r0.getText().toString());
                    sb.append("',p_ref_no='");
                    sb.append(this.q0.getText().toString());
                    sb.append("',p_date='");
                    sb.append(this.S.getText().toString());
                    sb.append("'");
                    if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                        str = "";
                    } else {
                        str = ",date_='" + this.S.getText().toString() + "'";
                    }
                    sb.append(str);
                    sb.append(",bill_id=-2 where p_id=");
                    sb.append(this.p);
                    string = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("delete from transactions where p_id=");
                    sb2.append(this.p);
                    sb2.append(" and p_id<>0 and bill_id=-2  and p_date='");
                    sb2.append(this.q);
                    sb2.append("'");
                    if (this.t.equals("0")) {
                        str2 = " ";
                    } else {
                        str2 = " and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + this.t + "' ";
                    }
                    sb2.append(str2);
                    String string4 = sb2.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("insert into transactions(p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,curr_mod,param1,param2,user_id,online_ref)select p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,curr_mod,param1,param2 ,");
                    int i4 = C2160f10.h;
                    sb3.append(i4 == -1 ? "null" : Integer.valueOf(i4));
                    sb3.append(",");
                    if (this.t.equals("0")) {
                        string2 = " 0 ";
                        str3 = ":";
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("'");
                        str3 = ":";
                        sb4.append(this.t.replace(str3, ""));
                        sb4.append("'");
                        string2 = sb4.toString();
                    }
                    sb3.append(string2);
                    sb3.append(" from tr_p_temps where p_id= ");
                    sb3.append(this.p);
                    String string5 = sb3.toString();
                    String strM = this.i.M(string, string4, string5);
                    if (strM != null && strM.equals("1")) {
                        this.h2 = false;
                        str4 = string5;
                        string3 = string4;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Error:");
                    if (strM != null && strM.length() > 20) {
                        strM = strM.substring(0, 20);
                    }
                    sb5.append(strM);
                    Toast.makeText(this, sb5.toString(), 0).show();
                    return;
                }
                int iT5 = this.i.t5();
                int iR5 = this.i.r5(0, -2);
                EditText editText = this.q0;
                StringBuilder sb6 = new StringBuilder();
                try {
                    sb6.append(getString(info.aalmoghalis.inventory.R.string.bill_no2));
                    sb6.append(iR5);
                    editText.setHint(sb6.toString());
                    if (this.q0.getText().toString().length() > 0 && this.i.u5(this.q0.getText().toString(), this.p) > 0) {
                        this.q0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                        return;
                    }
                    if (this.i.S()) {
                        i3 = Integer.parseInt(this.i.X4("select count(*) as _id from tr_p_temps where p_id=" + iT5));
                    } else {
                        i3 = 1;
                    }
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("update tr_p_temps set p_id='");
                    sb7.append(iT5);
                    sb7.append("',p_amount='");
                    sb7.append(this.U.getText().toString().replaceAll(",", ""));
                    sb7.append("',p_remarks='");
                    sb7.append(this.r0.getText().toString());
                    sb7.append("',p_ref_no='");
                    sb7.append((this.q0.getText() == null || this.q0.getText().toString().length() != 0) ? this.q0.getText().toString() : Integer.valueOf(iR5));
                    sb7.append("',p_date='");
                    sb7.append(this.S.getText().toString());
                    sb7.append("'");
                    if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                        str5 = "";
                    } else {
                        str5 = ",date_='" + this.S.getText().toString() + "'";
                    }
                    sb7.append(str5);
                    sb7.append(",bill_id=-2");
                    if (i3 == 0) {
                        str6 = " ";
                    } else {
                        str6 = " where p_id=" + iT5;
                    }
                    sb7.append(str6);
                    string = sb7.toString();
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("insert into transactions(p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,curr_mod,param1,param2,user_id)select p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,curr_mod,param1,param2 ,");
                    int i5 = C2160f10.h;
                    sb8.append(i5 == -1 ? "null" : Integer.valueOf(i5));
                    sb8.append(" from tr_p_temps ");
                    string3 = sb8.toString();
                    String strL = this.i.L(string, string3);
                    if (strL != null && strL.equals("1")) {
                        this.h2 = true;
                        this.p = iT5;
                        this.q = this.S.getText().toString();
                        this.t = "0";
                        this.i.S();
                        c1();
                        str4 = "";
                        str3 = ":";
                        str7 = "Error:";
                    }
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Error:");
                    if (strL != null && strL.length() > 20) {
                        strL = strL.substring(0, 20);
                    }
                    sb9.append(strL);
                    Toast.makeText(this, sb9.toString(), 0).show();
                    return;
                } catch (Exception e) {
                    e = e;
                    str7 = "Error:";
                }
                try {
                    new C1839c10(this, this.i).A();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Log.d("sql1=", string);
                Log.d("sql2=", string3);
                Log.d("sql3=", str4);
                v0();
                this.j2 = 0;
                c1();
                Log.d("new_bill=", this.h2 + str3 + this.J + str3 + this.W.getText().toString() + str3 + this.N.getAdapter().getCount());
                J0(1);
                if (!this.W.getText().toString().equals("0") && !this.W.getText().toString().equals("-0")) {
                    this.j2 = 1;
                    if (!p0()) {
                        return;
                    }
                }
                if (this.U1 == 1) {
                    this.U1 = 0;
                    d1();
                    return;
                }
                if (this.V1) {
                    this.V1 = false;
                    Bill_edit.P2 = true;
                    return;
                } else if (this.h2) {
                    new C3966tX().I(this, this.i, this.j, this.p, this.u, 0);
                    return;
                } else if (this.J != 1) {
                    M0();
                    return;
                } else {
                    Bill_edit.P2 = true;
                    finish();
                    return;
                }
            }
            return;
        } catch (Exception e3) {
            e = e3;
        }
        Log.d("bill_save_error", e.getMessage() + "");
        e.printStackTrace();
        StringBuilder sb10 = new StringBuilder();
        sb10.append(str7);
        sb10.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
        Toast.makeText(this, sb10.toString(), 1).show();
    }

    public boolean f0(int i) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z = false;
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "edit")) {
                Context context = this.K0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "new")) {
            Context context2 = this.K0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        if (i == info.aalmoghalis.inventory.R.id.btn_cus_det_add1) {
            i2 = -1;
        } else {
            i2 = i == info.aalmoghalis.inventory.R.id.btn_cus_det_add2 ? 1 : 0;
        }
        m0();
        if (k0()) {
            try {
                Log.d("btn_cus_add:", "START");
                if (i2 != 0) {
                    int iT5 = this.p;
                    if (iT5 == 0) {
                        try {
                            iT5 = this.i.t5();
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            return z;
                        }
                    }
                    int iR5 = this.i.r5(0, -2);
                    if (!this.i.ja("prefOthers_trans_diff_dates", false)) {
                        this.R.setText(this.S.getText().toString());
                    }
                    if (this.u1.getTag() == null) {
                        Z00 z00 = this.i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into tr_p_temps (cus_id,out,in_,date_,p_date,remarks,now_,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no,bill_id) values((select b.id from customers as b where b.name='");
                        sb.append(this.i1.getText().toString());
                        sb.append("'),");
                        sb.append(this.k1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb.append(",");
                        sb.append(i2);
                        sb.append(",'");
                        sb.append(this.R.getText().toString());
                        sb.append("','");
                        sb.append(this.S.getText().toString());
                        sb.append("','");
                        sb.append(this.v1.getText().toString());
                        sb.append("',strftime('%Y-%m-%d','now'),'");
                        sb.append(this.i.B8());
                        sb.append("',");
                        if (this.g0.getTag() == null) {
                            str3 = "0";
                        } else {
                            str3 = "(select id from currency where name='" + this.g0.getTag().toString() + "'),";
                        }
                        sb.append(str3);
                        if (this.f0.getTag() == null) {
                            str4 = "0";
                        } else {
                            str4 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                        }
                        sb.append(str4);
                        sb.append(",");
                        sb.append(iT5);
                        sb.append(",'");
                        sb.append(this.r0.getText().toString());
                        sb.append("','");
                        sb.append((this.q0.getText() == null || this.q0.getText().toString().length() != 0) ? this.q0.getText().toString() : Integer.valueOf(iR5));
                        sb.append("' ,-2)");
                        z00.v0(sb.toString());
                    } else {
                        Z00 z01 = this.i;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("insert into tr_p_temps (cus_id,out,in_,date_,p_date,remarks,now_,param1,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no,bill_id) values((select b.id from customers as b where b.name='");
                        sb2.append(this.i1.getText().toString());
                        sb2.append("'),");
                        sb2.append(this.k1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb2.append(",");
                        sb2.append(i2);
                        sb2.append(",'");
                        sb2.append(this.R.getText().toString());
                        sb2.append("','");
                        sb2.append(this.S.getText().toString());
                        sb2.append("','");
                        sb2.append(this.v1.getText().toString());
                        sb2.append("',strftime('%Y-%m-%d','now'),'");
                        sb2.append(this.u1.getTag().toString());
                        sb2.append("','");
                        sb2.append(this.i.B8());
                        sb2.append("',");
                        if (this.g0.getTag() == null) {
                            str = "0";
                        } else {
                            str = "(select id from currency where name='" + this.g0.getTag().toString() + "'),";
                        }
                        sb2.append(str);
                        if (this.f0.getTag() == null) {
                            str2 = "0";
                        } else {
                            str2 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                        }
                        sb2.append(str2);
                        sb2.append(",");
                        sb2.append(iT5);
                        sb2.append(",'");
                        sb2.append(this.r0.getText().toString());
                        sb2.append("','");
                        sb2.append((this.q0.getText() == null || this.q0.getText().toString().length() != 0) ? this.q0.getText().toString() : Integer.valueOf(iR5));
                        sb2.append("' ,-2)");
                        z01.v0(sb2.toString());
                    }
                    this.R0.setText((CharSequence) null);
                    this.k1.setText((CharSequence) null);
                    e1(this.u1);
                    this.w1.setText((CharSequence) null);
                    this.k1.requestFocus();
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

    public boolean g0() {
        String str;
        String str2;
        String str3;
        String str4;
        n0();
        if (l0()) {
            try {
                int iT5 = this.p;
                if (iT5 == 0) {
                    try {
                        iT5 = this.i.t5();
                    } catch (Exception unused) {
                        return false;
                    }
                }
                int iR5 = this.i.r5(0, -2);
                if (!this.i.ja("prefOthers_trans_diff_dates", false)) {
                    this.Q.setText(this.S.getText().toString());
                }
                if (this.t1.getTag() == null) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into tr_p_temps (cus_id,t_cus_id,out,in_,date_,p_date,remarks,now_,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no,bill_id) values((select b.id from customers as b where b.name='");
                    sb.append(this.i1.getText().toString());
                    sb.append("'),(select b.id from customers as b where b.name='");
                    sb.append(this.f1.getText().toString());
                    sb.append("'),");
                    sb.append(this.k1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append(",");
                    sb.append(1);
                    sb.append(",'");
                    sb.append(this.Q.getText().toString());
                    sb.append("','");
                    sb.append(this.S.getText().toString());
                    sb.append("','");
                    sb.append(this.w1.getText().toString());
                    sb.append("',strftime('%Y-%m-%d','now'),'");
                    sb.append(this.i.B8());
                    sb.append("',");
                    if (this.f0.getTag() == null) {
                        str3 = "0";
                    } else {
                        str3 = "(select id from currency where name='" + this.f0.getTag().toString() + "'),";
                    }
                    sb.append(str3);
                    if (this.f0.getTag() == null) {
                        str4 = "0";
                    } else {
                        str4 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                    }
                    sb.append(str4);
                    sb.append(",");
                    sb.append(iT5);
                    sb.append(",'");
                    sb.append(this.r0.getText().toString());
                    sb.append("','");
                    sb.append((this.q0.getText() == null || this.q0.getText().toString().length() != 0) ? this.q0.getText().toString() : Integer.valueOf(iR5));
                    sb.append("' ,-2)");
                    z00.v0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("insert into tr_p_temps (cus_id,t_cus_id,out,in_,date_,p_date,remarks,now_,param1,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no,bill_id) values((select b.id from customers as b where b.name='");
                    sb2.append(this.i1.getText().toString());
                    sb2.append("'),(select b.id from customers as b where b.name='");
                    sb2.append(this.f1.getText().toString());
                    sb2.append("'),");
                    sb2.append(this.k1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append(",");
                    sb2.append(1);
                    sb2.append(",'");
                    sb2.append(this.Q.getText().toString());
                    sb2.append("','");
                    sb2.append(this.S.getText().toString());
                    sb2.append("','");
                    sb2.append(this.w1.getText().toString());
                    sb2.append("',strftime('%Y-%m-%d','now'),'");
                    sb2.append(this.t1.getTag().toString());
                    sb2.append("','");
                    sb2.append(this.i.B8());
                    sb2.append("',");
                    if (this.f0.getTag() == null) {
                        str = "0";
                    } else {
                        str = "(select id from currency where name='" + this.f0.getTag().toString() + "'),";
                    }
                    sb2.append(str);
                    if (this.f0.getTag() == null) {
                        str2 = "0";
                    } else {
                        str2 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                    }
                    sb2.append(str2);
                    sb2.append(",");
                    sb2.append(iT5);
                    sb2.append(",'");
                    sb2.append(this.r0.getText().toString());
                    sb2.append("','");
                    sb2.append((this.q0.getText() == null || this.q0.getText().toString().length() != 0) ? this.q0.getText().toString() : Integer.valueOf(iR5));
                    sb2.append("' ,-2)");
                    z01.v0(sb2.toString());
                }
                this.k1.setText((CharSequence) null);
                e1(this.t1);
                this.w1.setText((CharSequence) null);
                try {
                    FragmentStatePagerSupport_Main.a0 = true;
                } catch (Exception unused2) {
                }
                return true;
            } catch (Exception unused3) {
            }
        }
        return false;
    }

    public void g1(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            if (this.T1) {
                this.u1.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.u1.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.u1.setImageBitmap(bitmapP0);
                this.u1.setTag(str);
            } else {
                this.t1.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.t1.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.t1.setImageBitmap(bitmapP0);
                this.t1.setTag(str);
            }
        } catch (Exception unused) {
        }
    }

    public boolean h0() {
        int i;
        boolean z;
        String str;
        String str2;
        boolean z2 = false;
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "edit")) {
                Context context = this.K0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "new")) {
            Context context2 = this.K0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        if (this.y1.isChecked()) {
            i = -1;
        } else {
            i = this.z1.isChecked() ? 1 : 0;
        }
        m0();
        if (!o0()) {
            return false;
        }
        try {
            if (!this.i.ja("prefOthers_trans_diff_dates", false)) {
                try {
                    this.Q.setText(this.S.getText().toString());
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
                    return z2;
                }
            }
            if (this.n1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                String str3 = "0";
                if (this.t1.getTag() == null) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update tr_p_temps set out='");
                    sb.append(this.k1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',in_='");
                    sb.append(i);
                    sb.append("',date_='");
                    sb.append(this.Q.getText().toString());
                    sb.append("',p_date='");
                    sb.append(this.S.getText().toString());
                    sb.append("',cus_id=(select b.id from customers as b where b.name='");
                    sb.append(this.i1.getText().toString());
                    sb.append("'),remarks='");
                    sb.append(this.w1.getText().toString());
                    sb.append("',param1='',curr_id=");
                    if (this.g0.getTag() == null) {
                        str2 = "0";
                    } else {
                        str2 = "(select id from currency where name='" + this.g0.getTag().toString() + "')";
                    }
                    sb.append(str2);
                    sb.append(",p_curr_id=");
                    if (this.f0.getTag() != null) {
                        str3 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                    }
                    sb.append(str3);
                    sb.append(" where no_='");
                    sb.append(this.H);
                    sb.append("'");
                    z00.v0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("update tr_p_temps set out='");
                    sb2.append(this.k1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',in_='");
                    sb2.append(i);
                    sb2.append("',date_='");
                    sb2.append(this.Q.getText().toString());
                    sb2.append("',p_date='");
                    sb2.append(this.S.getText().toString());
                    sb2.append("',remarks='");
                    sb2.append(this.w1.getText().toString());
                    sb2.append("',param1='");
                    sb2.append(this.t1.getTag().toString());
                    sb2.append("',cus_id=(select b.id from customers as b where b.name='");
                    sb2.append(this.i1.getText().toString());
                    sb2.append("'),curr_id=");
                    if (this.g0.getTag() == null) {
                        str = "0";
                    } else {
                        str = "(select id from currency where name='" + this.g0.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(",p_curr_id=");
                    if (this.f0.getTag() != null) {
                        str3 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                    }
                    sb2.append(str3);
                    sb2.append(" where no_='");
                    sb2.append(this.H);
                    sb2.append("'");
                    z01.v0(sb2.toString());
                }
                e1(this.t1);
                this.n1.setText(getString(info.aalmoghalis.inventory.R.string.btn_add));
                z = true;
                z2 = true;
            } else {
                z = true;
                z2 = false;
            }
            FragmentStatePagerSupport_Main.a0 = z;
            return z2;
        } catch (Exception e2) {
            e = e2;
            z2 = false;
        }
    }

    public void h1() {
        this.i1.setOnItemClickListener(new U());
        this.w1.addTextChangedListener(new V());
        this.v1.addTextChangedListener(new W());
    }

    public boolean i0() {
        boolean z;
        String str;
        String str2;
        boolean z2 = false;
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "edit")) {
                Context context = this.K0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "new")) {
            Context context2 = this.K0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        n0();
        if (!l0()) {
            return false;
        }
        try {
            if (this.n1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                if (!this.i.ja("prefOthers_trans_diff_dates", false)) {
                    try {
                        this.Q.setText(this.S.getText().toString());
                    } catch (Exception e) {
                        e = e;
                        Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
                        e.printStackTrace();
                        return z2;
                    }
                }
                String str3 = "0";
                if (this.t1.getTag() == null) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update tr_p_temps set out='");
                    sb.append(this.k1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',date_='");
                    sb.append(this.Q.getText().toString());
                    sb.append("',p_date='");
                    sb.append(this.S.getText().toString());
                    sb.append("',remarks='");
                    sb.append(this.w1.getText().toString());
                    sb.append("',param1='',t_cus_id=(select id from customers where name='");
                    sb.append(this.f1.getText().toString());
                    sb.append("') ,cus_id=(select id from customers where name='");
                    sb.append(this.i1.getText().toString());
                    sb.append("') ,curr_id=");
                    if (this.f0.getTag() == null) {
                        str2 = "0";
                    } else {
                        str2 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                    }
                    sb.append(str2);
                    sb.append(",p_curr_id=");
                    if (this.f0.getTag() != null) {
                        str3 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                    }
                    sb.append(str3);
                    sb.append(" where no_='");
                    sb.append(this.H);
                    sb.append("'");
                    z00.v0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("update tr_p_temps set out='");
                    sb2.append(this.k1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',date_='");
                    sb2.append(this.Q.getText().toString());
                    sb2.append("',p_date='");
                    sb2.append(this.S.getText().toString());
                    sb2.append("',remarks='");
                    sb2.append(this.w1.getText().toString());
                    sb2.append("',param1='");
                    sb2.append(this.t1.getTag().toString());
                    sb2.append("',t_cus_id=(select id from customers where name='");
                    sb2.append(this.f1.getText().toString());
                    sb2.append("') ,cus_id=(select id from customers where name='");
                    sb2.append(this.i1.getText().toString());
                    sb2.append("') ,curr_id=");
                    if (this.f0.getTag() == null) {
                        str = "0";
                    } else {
                        str = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(",p_curr_id=");
                    if (this.f0.getTag() != null) {
                        str3 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
                    }
                    sb2.append(str3);
                    sb2.append(" where no_='");
                    sb2.append(this.H);
                    sb2.append("'");
                    z01.v0(sb2.toString());
                }
                this.i1.setText((CharSequence) null);
                this.k1.setText((CharSequence) null);
                this.w1.setText((CharSequence) null);
                e1(this.t1);
                z = true;
                z2 = true;
            } else {
                z = true;
                z2 = false;
            }
            FragmentStatePagerSupport_Main.a0 = z;
            return z2;
        } catch (Exception e2) {
            e = e2;
            z2 = false;
        }
    }

    public void i1(boolean z) {
        B0(z);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.T1 = z;
        if (!z) {
            this.D1.setVisibility(8);
            this.E1.setVisibility(8);
            this.A1.setVisibility(0);
            this.B1.setVisibility(0);
            this.w1.setThreshold(1);
            this.k1.requestFocus();
            this.k1.selectAll();
            N0(4, 500);
            this.t1.setOnClickListener(new ViewOnClickListenerC2763c(z));
            return;
        }
        this.A1.setVisibility(8);
        this.B1.setVisibility(8);
        this.D1.setVisibility(0);
        this.E1.setVisibility(0);
        this.v1.setThreshold(1);
        this.K = calendar.get(1);
        this.L = calendar.get(2);
        this.M = calendar.get(5);
        this.u1.setOnClickListener(new ViewOnClickListenerC2761b(z));
        int i = k2;
        if (i == 3 || i == 1) {
            if (i == 3) {
                this.i1.setText("");
                e1(this.t1);
                this.v1.setText((CharSequence) null);
                this.i1.requestFocus();
            }
            t1();
        }
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

    public void l1(boolean z) {
        String str;
        this.i.dd(this, this.k1);
        this.i.Zc(this, this.f1);
        this.i.Zc(this, this.i1);
        this.i.cd(this, this.w1);
        if (z) {
            if (k2 != 1 || (str = this.B) == null || str.equals("")) {
                int i = k2;
                if (i == 2) {
                    this.k1.requestFocus();
                    this.k1.selectAll();
                    N0(4, 500);
                } else if (i == 3) {
                    b1();
                    a1();
                    this.G1.setVisibility(0);
                } else {
                    this.i1.requestFocus();
                    a1();
                }
            } else {
                this.i1.setText(this.B);
                this.f1.requestFocus();
                a1();
            }
        }
        this.i1.setThreshold(1);
        this.f1.setThreshold(1);
        this.w1.setThreshold(1);
        b1();
        this.i1.setOnItemClickListener(new D());
        this.f1.setOnItemClickListener(new E());
        this.i1.setOnTouchListener(new F());
        this.i1.addTextChangedListener(new G());
        this.f1.setOnTouchListener(new H());
        this.f1.addTextChangedListener(new J());
        this.w1.addTextChangedListener(new K());
        this.F1.setVisibility(0);
        if (z) {
            return;
        }
        this.i1.setText(this.d1);
        this.f1.setText(this.e1);
        this.i.nd(this.w1, this.G);
        TextView textView = this.Q;
        if (textView != null) {
            textView.setText(this.D);
        }
        this.k1.setText(this.i.P7(String.valueOf(Double.parseDouble(this.E.replaceAll(",", "")) + Double.parseDouble(this.F.replaceAll(",", "")))));
        if (this.I.equals("")) {
            return;
        }
        this.t1.setImageBitmap(Z00.p0(Z00.M + this.I, 100, 100));
        this.t1.setTag(this.I);
        this.t1.getLayoutParams().width = 100;
        this.t1.getLayoutParams().height = 70;
    }

    public void m1() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.i.J2(this, intent);
            this.b2 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.b2.getPath() + "");
            startActivityForResult(intent, this.X1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void n1() {
        try {
            int i = k2;
            if (i == 3 || i == 1) {
                String string = this.i1.getText().toString();
                boolean zJa = this.i.ja("f_name_lock", true);
                this.i1.setText(this.f1.getText());
                this.f1.setText(string);
                Z00 z00 = this.i;
                z00.Mc("f_name_lock", z00.ja("t_name_lock", false));
                this.i.Mc("t_name_lock", zJa);
                a1();
                o1();
            } else if (i == 2) {
                String string2 = this.i1.getText().toString();
                this.i.ja("f_name_lock", true);
                this.i1.setText(this.f1.getText());
                this.f1.setText(string2);
            }
            b1();
        } catch (Exception unused) {
        }
    }

    public void o1() {
        if (!this.i.ja("f_name_lock", true)) {
            this.i1.setText("");
            if (!this.i1.hasFocus()) {
                this.i1.requestFocus();
            }
        }
        if (!this.i.ja("t_name_lock", false)) {
            this.f1.setText("");
            if (!this.f1.hasFocus() && this.i.ja("f_name_lock", true)) {
                this.f1.requestFocus();
            }
        }
        if (this.i.ja("f_name_lock", true) && this.i.ja("t_name_lock", true)) {
            this.k1.setText("");
            if (!this.k1.hasFocus()) {
                this.k1.selectAll();
                this.k1.requestFocus();
            }
        }
        if (this.i.ja("t_name_lock", false) && this.f1.getText() != null && this.f1.getText().toString().length() > 0) {
            this.i1.setImeOptions(5);
            this.i1.setNextFocusDownId(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.i1.setNextFocusForwardId(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        }
        this.k1.setText("");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (i2 != 0) {
                if (i == 2) {
                    if (intent != null) {
                        this.k1.setText(this.i.P7(intent.getStringExtra("calc_result")));
                    }
                } else if (i == 1) {
                    if (i2 == -1) {
                        Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                        this.l1.setText(string);
                        cursorQuery.close();
                        Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                    }
                } else if (i == this.Y1 && intent != null) {
                    X0(intent.getData(), false);
                } else if (i == this.X1) {
                    W0(intent);
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
        Log.d("onback=", this.j2 + ":" + this.J + ":" + Bill_edit.P2);
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "edit")) {
                this.j2 = 0;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "new")) {
            this.j2 = 0;
        }
        if (this.j2 == 1) {
            this.i2 = 1;
            t0();
        } else if (this.J != 1 || this.p == 0) {
            M0();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_doc_edit);
        setTitle(getString(info.aalmoghalis.inventory.R.string.add_tr_account));
        this.i = new Z00(this.h, this);
        this.j = new E00(this);
        this.i.v0("delete from tr_p_temps");
        L0();
        if (this.p != 0) {
            setContentView(info.aalmoghalis.inventory.R.layout.content_doc_det);
        }
        this.B0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_header);
        this.C0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_footer);
        this.D0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_item_header);
        this.N = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        this.P = (SwitchCompat) findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
        this.S = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_date);
        this.T = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name);
        this.p0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
        this.U = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot);
        this.V = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot2);
        this.W = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot3);
        this.X = (TextView) findViewById(info.aalmoghalis.inventory.R.id.count);
        this.i.hd((TextView) findViewById(info.aalmoghalis.inventory.R.id.item_price), (TextView) findViewById(info.aalmoghalis.inventory.R.id.item_qty));
        this.a0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr);
        this.c0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_add);
        ImageView imageView = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img_fwd_amount);
        this.d0 = imageView;
        imageView.setOnClickListener(this.c1);
        ImageView imageView2 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img_u_currency);
        this.e0 = imageView2;
        imageView2.setVisibility(8);
        this.e0.setOnClickListener(this.c1);
        this.q0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_no);
        EditText editText = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
        this.r0 = editText;
        this.i.dd(this, editText);
        this.i.dd(this, this.q0);
        this.m0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.root_layout);
        this.n0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.item_add_hdr);
        this.o0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_items_list_hdr);
        this.l0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.page_add);
        if (this.p == 0) {
            this.E0 = this.i.r5(0, -2);
            this.q0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.E0);
        } else {
            this.o0.setVisibility(0);
        }
        this.f0 = (RadioGroup) findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        this.R0 = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        this.N.setOnItemClickListener(new C2777m());
        this.N.setChoiceMode(3);
        this.N.setMultiChoiceModeListener(new C2778n());
        this.P.setOnCheckedChangeListener(new I());
        Calendar calendar = Calendar.getInstance();
        this.S.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
        this.K = calendar.get(1);
        this.L = calendar.get(2);
        this.M = calendar.get(5);
        this.S.setOnClickListener(new L());
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
                this.u = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.l = getIntent().getStringExtra("g_id");
                this.n = getIntent().getStringExtra("g_name");
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.u - 1]);
                sb.append(" ");
                sb.append(this.P.isChecked() ? getString(info.aalmoghalis.inventory.R.string.cash) : getString(info.aalmoghalis.inventory.R.string.post));
                setTitle(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.u - 1]);
                sb2.append(" ");
                sb2.append(this.P.isChecked() ? getString(info.aalmoghalis.inventory.R.string.cash) : getString(info.aalmoghalis.inventory.R.string.post));
                this.A0 = sb2.toString();
                this.i.v0("delete from items_temp");
                int i = this.u;
                if (i == 2) {
                    this.Z.setText(getString(info.aalmoghalis.inventory.R.string.supp));
                } else if (i == 1) {
                    this.Z.setText(getString(info.aalmoghalis.inventory.R.string.cus));
                }
            }
        } catch (Exception unused2) {
        }
        if (getIntent().getStringExtra("P_ID") != null && C2160f10.h > 0 && !new C2160f10(this.i).l("9", "edit")) {
            this.S.setEnabled(false);
            this.q0.setEnabled(false);
            this.f0.setEnabled(false);
            this.r0.setEnabled(false);
        }
        if (this.p == 0) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        L0();
        J0(1);
        A0();
        u1();
        v0();
        this.r0.addTextChangedListener(this.G0);
        this.r0.setOnClickListener(new Q());
        this.q0.addTextChangedListener(this.G0);
        this.q0.setOnClickListener(new ViewOnClickListenerC2762b0());
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(P0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.Q1, this.K, this.L, this.M);
        }
        if (i == 4) {
            return new DatePickerDialog(P0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.R1, this.K, this.L, this.M);
        }
        if (i != 5) {
            return null;
        }
        return new DatePickerDialog(P0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.S1, this.K, this.L, this.M);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_doc4, menu);
        int i = C2160f10.h;
        if (i <= 0 || this.p == 0) {
            if (i <= 0 || this.p != 0) {
                return true;
            }
            menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(new C2160f10(this.i).l("9", HTML.Tag.DEL));
            return true;
        }
        MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
        MenuItem menuItemFindItem2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
        MenuItem menuItemFindItem3 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_new);
        boolean zL = new C2160f10(this.i).l("9", "edit");
        boolean zL2 = new C2160f10(this.i).l("9", "new");
        boolean zL3 = new C2160f10(this.i).l("9", HTML.Tag.DEL);
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
        C0(this.i.L2());
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
            e0(1, this.u);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_submit) {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return true;
            }
            e0(2, this.u);
            this.h2 = false;
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_remove) {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return true;
            }
            d0();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_new) {
            if (this.j2 == 1) {
                this.i2 = 0;
                this.U1 = 1;
                e0(2, this.u);
            } else {
                d1();
            }
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.share) {
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin) {
                this.g2 = 1;
            } else {
                this.g2 = 2;
            }
            if (this.p == 0) {
                t0();
                return true;
            }
            if (this.j2 == 1) {
                this.i2 = 0;
                this.V1 = true;
                e0(2, this.u);
            }
            Z0(this.g2);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.menu_sms || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.menu_whats) {
            if (this.j2 == 1) {
                this.i2 = 0;
                this.V1 = true;
                e0(2, this.u);
            }
            if (this.p != 0) {
                new C3966tX().I(this, this.i, this.j, this.p, this.u, menuItem.getItemId());
            }
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
            if (this.f0.getTag().toString().equals(radioButton.getText().toString())) {
                this.f0.setTag(radioButton.getText().toString());
                J0(2);
            } else {
                this.f0.setTag(radioButton.getText().toString());
                r1();
                this.L0 = 1;
                this.j2 = 1;
            }
            Log.d("radio_checked:=", radioButton.getText().toString() + ":" + this.z);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        new C3966tX().G(this, this.i, this.j, this.p, this.u, null);
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final boolean p0() {
        boolean z = this.p == 0 || AbstractC4371yX.a(this.q0);
        StringBuilder sb = new StringBuilder();
        sb.append(this.i.g5());
        sb.append(":");
        sb.append(this.i.i5());
        sb.append("#");
        Z00 z00 = this.i;
        sb.append(z00.P7(String.valueOf(z00.i5())));
        sb.append("#");
        sb.append(this.U.getText().toString());
        sb.append("#");
        Z00 z01 = this.i;
        sb.append(z01.P7(String.valueOf(z01.i5())).equals(this.U.getText().toString()));
        Log.d("total_ch=", sb.toString());
        if (this.i.g5() != 0.0d) {
            Z00 z02 = this.i;
            if (!z02.P7(String.valueOf(z02.i5())).equals(this.U.getText().toString())) {
                this.i.Pd(this, this.N, getString(info.aalmoghalis.inventory.R.string.doc_balance_check) + "#" + this.i.g5(), CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 2);
                z = false;
            }
        }
        ArrayList arrayListI8 = this.i.I8("-2");
        this.i0 = arrayListI8;
        if (arrayListI8 != null && arrayListI8.size() > 0) {
            for (int i = 0; i < this.i0.size(); i++) {
                Log.d("curr_price=", "" + ((String) ((HashMap) this.i0.get(i)).get("price")) + ":" + ((String) ((HashMap) this.i0.get(i)).get("name")));
                if (Double.parseDouble((String) ((HashMap) this.i0.get(i)).get("price")) == 0.0d) {
                    this.e0.performClick();
                    z = false;
                    break;
                }
            }
        }
        if (!this.i.Q()) {
            return z;
        }
        s0();
        return false;
    }

    public void p1() {
        if (this.u0.valueAt(0)) {
            C0634Jt item = this.s0.getItem(this.u0.keyAt(0));
            ArrayList arrayListJ8 = this.i.J8("-2", item.f());
            this.j0 = arrayListJ8;
            if (arrayListJ8 == null || arrayListJ8.size() == 0) {
                this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.local_curr), 1000);
                return;
            }
            this.i.me("-2", this, this.j0, new HandlerC2759a(), item.f());
            try {
                Looper.loop();
            } catch (RuntimeException unused) {
            }
            J0(2);
            this.j2 = 1;
        }
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void q0() {
        this.i.D = false;
        if (this.f0.getTag() == null || this.f0.getTag().toString().equals(this.i.l3("0")) || this.i.Z2(this.f0.getTag().toString(), this.i.cc(this.S.getText().toString())) != 0) {
            return;
        }
        this.i.u(this, this.f0.getTag().toString(), this.i.cc(this.S.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
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
            autoCompleteTextView.setOnItemClickListener(new s0(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new t0(autoCompleteTextView2, editText2));
            this.l1 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new v0());
            imageView2.setOnClickListener(new w0(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new x0(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new y0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new z0());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new A0(editText, autoCompleteTextView, autoCompleteTextView2, str, alertDialogCreate, editText2, editText3, handler));
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
        listView.setOnItemClickListener(new B0(autoCompleteTextView, dialog, editText));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    public void r1() {
        String str;
        q0();
        String str2 = "";
        String str3 = "0";
        if (this.p != 0) {
            Z00 z00 = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append("update tr_p_temps set curr_price=0,p_date='");
            sb.append(this.S.getText().toString());
            sb.append("'");
            if (!this.i.ja("prefOthers_trans_diff_dates", false)) {
                str2 = ",date_='" + this.S.getText().toString() + "'";
            }
            sb.append(str2);
            sb.append(",p_curr_id=");
            if (this.f0.getTag() == null) {
                str = "0";
            } else {
                str = "(select id from currency where name='" + this.f0.getTag().toString() + "'),p_curr_price=0";
            }
            sb.append(str);
            sb.append(",curr_id=(case when t_cus_id is  null then curr_id  else ");
            if (this.f0.getTag() != null) {
                str3 = "(select id from currency where name='" + this.f0.getTag().toString() + "')";
            }
            sb.append(str3);
            sb.append(" end ),curr_mod=0   where p_id=");
            sb.append(this.p);
            z00.v0(sb.toString());
            J0(4);
        } else {
            Z00 z01 = this.i;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("update tr_p_temps set curr_price=0,p_date='");
            sb2.append(this.S.getText().toString());
            sb2.append("'");
            if (!this.i.ja("prefOthers_trans_diff_dates", false)) {
                str2 = ",date_='" + this.S.getText().toString() + "'";
            }
            sb2.append(str2);
            sb2.append(",p_curr_id=");
            if (this.f0.getTag() != null) {
                str3 = "(select id from currency where name='" + this.f0.getTag().toString() + "'),p_curr_price=0";
            }
            sb2.append(str3);
            z01.v0(sb2.toString());
            J0(4);
        }
        FragmentStatePagerSupport_Main.a0 = true;
    }

    public void s0() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.L0();
            }
            b0();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
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
            autoCompleteTextView.setOnItemClickListener(new i0(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new k0(autoCompleteTextView));
            imageView.setOnClickListener(new l0(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new m0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new n0());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new o0(autoCompleteTextView, alertDialogCreate, str, editText, handler));
        } catch (Exception unused) {
        }
    }

    public void t0() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_save));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2765d());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2767e());
        builder.create().show();
    }

    public void t1() {
        try {
            if (this.W.getText().toString().equals("0") || this.W.getText().toString().equals("-0")) {
                return;
            }
            this.k1.setText(this.i.P7(String.valueOf((Double.parseDouble(this.W.getText().toString().replaceAll("-", "").replaceAll(",", "")) * this.i.E5(this.f0.getTag().toString(), this.R.getText().toString().substring(6, 10) + "-" + this.R.getText().toString().substring(3, 5) + "-" + this.R.getText().toString().substring(0, 2))) / this.i.E5(this.g0.getTag().toString(), this.R.getText().toString().substring(6, 10) + "-" + this.R.getText().toString().substring(3, 5) + "-" + this.R.getText().toString().substring(0, 2)))));
            if (this.W.getText().toString().contains("-")) {
                this.v1.setHint(this.i.c5());
            } else {
                this.v1.setHint(this.i.Q2());
            }
            this.j2 = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u_currency_btn(View view) {
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "edit")) {
                Context context = this.K0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "new")) {
            Context context2 = this.K0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        this.i.me("-2", this, this.i0, new HandlerC2781q(), "0");
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        J0(2);
        this.j2 = 1;
    }

    public void v0() {
        this.b1 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
        this.R0.setThreshold(1);
        this.R0.setAdapter(this.b1);
        this.b1.getCount();
        this.R0.setOnItemClickListener(new C2775k());
        this.R0.setOnTouchListener(new ViewOnTouchListenerC2776l());
        this.R0.addTextChangedListener(new C2779o());
    }

    public void w0() {
        if (getIntent().getStringExtra("P_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "edit")) {
                Context context = this.K0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("9", "new")) {
            Context context2 = this.K0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.u0.size() - 1; size >= 0; size--) {
            if (this.u0.valueAt(size)) {
                C0634Jt item = this.s0.getItem(this.u0.keyAt(size));
                this.s0.remove(item);
                this.i.v0("delete from tr_p_temps where no_='" + item.f() + "'");
            }
        }
        this.L0 = 1;
        J0(2);
        this.L0 = 1;
    }

    public void y0(boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_doc_item_add_view2, (ViewGroup) null);
            builder.setView(viewInflate);
            this.i1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name_det);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.k1 = editText;
            this.m1 = editText;
            editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
            EditText editText2 = this.k1;
            editText2.addTextChangedListener(new C2018dE(editText2));
            this.Q = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.R = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date4);
            this.n1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
            this.o1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add1);
            Button button = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add2);
            this.p1 = button;
            this.i.fd(this.o1, button);
            this.r1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
            this.t1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            this.u1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach4);
            this.x1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
            this.y1 = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton1);
            RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
            this.z1 = radioButton;
            this.i.gd(this.y1, radioButton);
            this.x1.check(info.aalmoghalis.inventory.R.id.radiobutton2);
            this.w1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.v1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks4);
            this.A1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
            this.B1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.D1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4_);
            this.C1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
            this.E1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface5);
            this.F1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
            this.g0 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr_add);
            if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                if (z) {
                    this.R.setVisibility(0);
                } else {
                    this.Q.setVisibility(0);
                }
            } else if (z) {
                this.R.setVisibility(8);
            } else {
                this.Q.setVisibility(8);
            }
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.Q.setText(simpleDateFormat.format(calendar.getTime()));
            this.R.setText(simpleDateFormat.format(calendar.getTime()));
            i1(z);
            this.Q.setOnClickListener(new M());
            this.R.setOnClickListener(new N());
            if (!z) {
                this.i1.setText(this.B);
                this.k1.setText(this.i.P7(String.valueOf(Double.parseDouble(this.E.replaceAll(",", "")) + Double.parseDouble(this.F.replaceAll(",", "")))));
                this.i.nd(this.w1, this.G);
                TextView textView = this.Q;
                if (textView != null) {
                    textView.setText(this.D);
                }
                this.n1.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
                this.i1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.ic_notification_clear_all), (Drawable) null, this.i1.getCompoundDrawables()[2], (Drawable) null);
                this.k1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.ic_notification_clear_all), (Drawable) null, this.k1.getCompoundDrawables()[2], (Drawable) null);
                if (this.E.equals("0")) {
                    this.y1.setChecked(true);
                } else if (this.F.equals("0")) {
                    this.z1.setChecked(true);
                }
                if (this.I.equals("")) {
                    e1(this.t1);
                } else {
                    Log.d("tr_attach_l=", this.I);
                    g1(this.I);
                }
            }
            builder.setCancelable(true);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            this.v0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
            this.i1.setThreshold(1);
            this.i1.setAdapter(this.v0);
            this.i1.setText(this.B);
            K0();
            if (z && this.B.length() <= 0) {
                this.i1.requestFocus();
            } else {
                this.k1.requestFocus();
            }
            this.i.Zc(this, this.i1);
            this.i.ad(this, this.k1);
            h1();
            this.o1.setOnClickListener(new O(alertDialogCreate));
            this.p1.setOnClickListener(new P(alertDialogCreate));
            this.n1.setOnClickListener(new R(alertDialogCreate));
            this.r1.setOnClickListener(new S());
            this.t1.setOnClickListener(new T(z));
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("edit_item_error=", ":" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void z0(boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_doc_item_move_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.i1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.from_cus_name);
            this.f1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.to_cus_name);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.k1 = editText;
            this.m1 = editText;
            editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
            EditText editText2 = this.k1;
            editText2.addTextChangedListener(new C2018dE(editText2));
            this.k1.requestFocus();
            this.Q = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.n1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
            this.r1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
            this.s1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_swap);
            this.t1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            this.G1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.q1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_close);
            this.w1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.A1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
            this.B1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.C1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
            this.F1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
            this.Q.setOnClickListener(new ViewOnClickListenerC2782r());
            if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                this.Q.setVisibility(0);
            } else {
                this.Q.setVisibility(8);
            }
            this.Q.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
            l1(z);
            builder.setCancelable(true);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            this.n1.setOnClickListener(new ViewOnClickListenerC2783s(alertDialogCreate));
            this.r1.setOnClickListener(new ViewOnClickListenerC2784t());
            this.s1.setOnClickListener(new ViewOnClickListenerC2785u());
            this.t1.setOnClickListener(new ViewOnClickListenerC2786v(z));
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("edit_move_error=", ":" + e.getMessage());
        }
    }
}
