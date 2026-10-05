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
import android.os.AsyncTask;
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
import android.view.LayoutInflater;
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
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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
import com.itextpdf.tool.xml.css.CSS;
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
import defpackage.C3874sM;
import defpackage.C3962tT;
import defpackage.C3966tX;
import defpackage.C4062ug;
import defpackage.C4064uh;
import defpackage.C4143vg;
import defpackage.E00;
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
public class Customer_Det_List_edit5 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int v2;
    public int K;
    public int L;
    public int M;
    public boolean S1;
    public ArrayAdapter U;
    public boolean U1;
    public ArrayAdapter V;
    public boolean V1;
    public String e2;
    public ArrayAdapter f1;
    public SQLiteDatabase h;
    public Z00 i;
    public E00 j;
    public C3962tT j1;
    public Uri j2;
    public String k;
    public String l;
    public String n;
    public LinearLayout p0;
    public LinearLayout q0;
    public LinearLayout r0;
    public EditText r1;
    public EditText s1;
    public EditText t1;
    public C0809Ov v0;
    public SparseBooleanArray x0;
    public ArrayAdapter y0;
    public ArrayAdapter z0;
    public int p = 0;
    public String q = "";
    public String t = "";
    public int u = 5;
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
    public TextView T = null;
    public AutoCompleteTextView W = null;
    public TextView X = null;
    public TextView Y = null;
    public TextView Z = null;
    public TextView a0 = null;
    public TextView b0 = null;
    public TextView c0 = null;
    public TextView d0 = null;
    public ImageView e0 = null;
    public ImageView f0 = null;
    public ImageView g0 = null;
    public ImageView h0 = null;
    public TextView i0 = null;
    public RadioGroup j0 = null;
    public ArrayList k0 = new ArrayList();
    public ArrayList l0 = new ArrayList();
    public ArrayList m0 = new ArrayList();
    public ArrayList n0 = new ArrayList();
    public ImageView o0 = null;
    public TextView s0 = null;
    public EditText t0 = null;
    public EditText u0 = null;
    public List w0 = new ArrayList();
    public ImageButton A0 = null;
    public int B0 = 0;
    public String[] C0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] D0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String E0 = "";
    public LinearLayout F0 = null;
    public LinearLayout G0 = null;
    public LinearLayout H0 = null;
    public int I0 = 0;
    public boolean J0 = false;
    public TextWatcher K0 = new X0();
    public int L0 = 0;
    public String M0 = "";
    public String N0 = "";
    public final Context O0 = this;
    public int P0 = 0;
    public int Q0 = 0;
    public String R0 = "";
    public EditText S0 = null;
    public EditText T0 = null;
    public TextView U0 = null;
    public AutoCompleteTextView V0 = null;
    public EditText W0 = null;
    public EditText X0 = null;
    public EditText Y0 = null;
    public AutoCompleteTextView Z0 = null;
    public EditText a1 = null;
    public EditText b1 = null;
    public EditText c1 = null;
    public TextView d1 = null;
    public AutoCompleteTextView e1 = null;
    public Timer g1 = new Timer();
    public final long h1 = 1000;
    public View.OnClickListener i1 = new N();
    public String k1 = null;
    public String l1 = null;
    public AutoCompleteTextView m1 = null;
    public ArrayList n1 = new ArrayList();
    public TextView o1 = null;
    public AutoCompleteTextView p1 = null;
    public String q1 = "";
    public Button u1 = null;
    public Button v1 = null;
    public Button w1 = null;
    public Button x1 = null;
    public ImageView y1 = null;
    public ImageView z1 = null;
    public ImageView A1 = null;
    public ImageView B1 = null;
    public AutoCompleteTextView C1 = null;
    public AutoCompleteTextView D1 = null;
    public RadioGroup E1 = null;
    public RadioButton F1 = null;
    public RadioButton G1 = null;
    public LinearLayout H1 = null;
    public LinearLayout I1 = null;
    public LinearLayout J1 = null;
    public LinearLayout K1 = null;
    public LinearLayout L1 = null;
    public LinearLayout M1 = null;
    public LinearLayout N1 = null;
    public LinearLayout O1 = null;
    public double P1 = 0.0d;
    public double Q1 = 0.0d;
    public int R1 = 0;
    public int T1 = 1;
    public String W1 = "";
    public String X1 = "0";
    public DatePickerDialog.OnDateSetListener Y1 = new C2799e();
    public DatePickerDialog.OnDateSetListener Z1 = new C2801f();
    public DatePickerDialog.OnDateSetListener a2 = new C2803g();
    public boolean b2 = false;
    public int c2 = 0;
    public boolean d2 = false;
    public int f2 = 3;
    public int g2 = 4;
    public ActivityResultLauncher h2 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Yg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.e1((Uri) obj);
        }
    });
    public ActivityResultLauncher i2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new C2823q());
    public String k2 = null;
    public String l2 = null;
    public String m2 = null;
    public String n2 = null;
    public int o2 = 0;
    public boolean p2 = false;
    public int q2 = 0;
    public int[] r2 = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public int s2 = 0;
    public int t2 = 0;
    public int u2 = 0;

    public class A implements DialogInterface.OnClickListener {
        public A() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class A0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public A0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.w0(this.a, this.b, null);
        }
    }

    public class B implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ AlertDialog e;

        public B(EditText editText, AutoCompleteTextView autoCompleteTextView, String str, EditText editText2, AlertDialog alertDialog) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = str;
            this.d = editText2;
            this.e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (zA && Customer_Det_List_edit5.this.i.Q5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Customer_Det_List_edit5.this.W1 = this.b.getText().toString();
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.Q0(customer_Det_List_edit5.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit5.this.W1, Customer_Det_List_edit5.this);
                if (!Customer_Det_List_edit5.this.U1) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Customer_Det_List_edit5.this.i.v0("update customers set name='" + this.d.getText().toString().trim() + "',gsm='" + this.a.getText().toString() + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id=(select b.id from customers b where b.name='" + this.d.getText().toString() + "')");
                    Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                    int i = customer_Det_List_edit6.s2;
                    if (i != 7 && i != 8) {
                        customer_Det_List_edit6.n2 = this.a.getText().toString();
                        Customer_Det_List_edit5 customer_Det_List_edit7 = Customer_Det_List_edit5.this;
                        C4064uh c4064uhO0 = customer_Det_List_edit7.i.O0(customer_Det_List_edit7.k2, ((C0634Jt) customer_Det_List_edit7.N.getAdapter().getItem(0)).j());
                        Customer_Det_List_edit5 customer_Det_List_edit8 = Customer_Det_List_edit5.this;
                        Z00 z00 = customer_Det_List_edit8.i;
                        z00.Rc(customer_Det_List_edit8.n2, z00.Dd(c4064uhO0, customer_Det_List_edit8.k2, Double.parseDouble(c4064uhO0.c().replaceAll(",", "")), c4064uhO0.q()));
                    }
                }
                this.e.dismiss();
            }
        }
    }

    public class B0 implements View.OnClickListener {
        public B0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.J0 = true;
        }
    }

    public class C implements DialogInterface.OnClickListener {
        public C() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String str;
            try {
                Z00 z00 = Customer_Det_List_edit5.this.i;
                StringBuilder sb = new StringBuilder();
                sb.append("delete from transactions where p_id='");
                sb.append(Customer_Det_List_edit5.this.p);
                sb.append("' and p_id <>0 and bill_id=-3 and p_date='");
                sb.append(Customer_Det_List_edit5.this.q);
                sb.append("'");
                if (Customer_Det_List_edit5.this.t.equals("0")) {
                    str = " ";
                } else {
                    str = " and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + Customer_Det_List_edit5.this.t + "' ";
                }
                sb.append(str);
                z00.v0(sb.toString());
                FragmentStatePagerSupport_Main.a0 = true;
                Bill_edit.P2 = true;
                Customer_Det_List_edit5.this.r1();
                Daily_Doc_Report.u0--;
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit5.this.getApplicationContext(), "SQL Error.", 1);
            }
        }
    }

    public class C0 implements DialogInterface.OnClickListener {
        public C0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class D implements DialogInterface.OnClickListener {
        public D() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class D0 implements DialogInterface.OnClickListener {
        public D0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
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
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ android.app.AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ Handler e;

        public E0(AutoCompleteTextView autoCompleteTextView, android.app.AlertDialog alertDialog, String str, EditText editText, Handler handler) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
            this.c = str;
            this.d = editText;
            this.e = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (zA && Customer_Det_List_edit5.this.i.P5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Customer_Det_List_edit5.this.W1 = this.a.getText().toString();
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.P0(customer_Det_List_edit5.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type), Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type) + "#" + Customer_Det_List_edit5.this.W1, this.b.getContext());
                if (!Customer_Det_List_edit5.this.U1) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Customer_Det_List_edit5.this.i.H("insert into items (name,item_type_id) values('" + this.d.getText().toString() + "',(select b.id from item_type b where b.name='" + this.a.getText().toString() + "') )", "insert into item_price (item_id,curr_id,sls_u_price) values((select id from items a where a.name='" + this.d.getText().toString() + "'),(select b.id from currency b where b.name='" + Customer_Det_List_edit5.this.i0.getTag().toString() + "'),'0' )");
                    Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit6.T1 = 0;
                    customer_Det_List_edit6.S1 = true;
                    Customer_Det_List_edit5.this.V0.setText(this.d.getText().toString());
                    Handler handler = this.e;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    public class F implements View.OnClickListener {
        public final /* synthetic */ Snackbar a;

        public F(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Customer_Det_List_edit5.this.X0();
        }
    }

    public class F0 extends Handler {
        public F0() {
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
            Customer_Det_List_edit5.this.w1();
        }
    }

    public class G0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public G0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5.this.i.v0("insert into item_type  (name )  values( '" + Customer_Det_List_edit5.this.W1 + "'  )");
            Customer_Det_List_edit5.this.V1 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class H implements Runnable {
        public final /* synthetic */ Snackbar a;

        public H(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.dismiss();
        }
    }

    public class H0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public H0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5.this.V1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class I implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public I(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            C4064uh c4064uhO0 = customer_Det_List_edit5.i.O0(customer_Det_List_edit5.k2, ((C0634Jt) customer_Det_List_edit5.N.getAdapter().getItem(0)).j());
            if (i == 0) {
                Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                customer_Det_List_edit6.s2 = 4;
                String str = customer_Det_List_edit6.n2;
                if (str == null || str.length() < 3) {
                    Customer_Det_List_edit5 customer_Det_List_edit7 = Customer_Det_List_edit5.this;
                    String str2 = customer_Det_List_edit7.k;
                    Customer_Det_List_edit5 customer_Det_List_edit8 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit7.G1(str2, customer_Det_List_edit8.k2, customer_Det_List_edit8.n2, customer_Det_List_edit8.l2);
                } else {
                    Customer_Det_List_edit5 customer_Det_List_edit9 = Customer_Det_List_edit5.this;
                    Z00 z00 = customer_Det_List_edit9.i;
                    z00.Ed(customer_Det_List_edit9.n2, z00.Dd(c4064uhO0, customer_Det_List_edit9.k2, Double.parseDouble(c4064uhO0.c().replaceAll(",", "")), c4064uhO0.q()));
                }
            } else if (i == 1) {
                Customer_Det_List_edit5 customer_Det_List_edit10 = Customer_Det_List_edit5.this;
                customer_Det_List_edit10.s2 = 3;
                String str3 = customer_Det_List_edit10.n2;
                if (str3 == null || str3.length() < 3) {
                    Customer_Det_List_edit5 customer_Det_List_edit11 = Customer_Det_List_edit5.this;
                    String str4 = customer_Det_List_edit11.k;
                    Customer_Det_List_edit5 customer_Det_List_edit12 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit11.G1(str4, customer_Det_List_edit12.k2, customer_Det_List_edit12.n2, customer_Det_List_edit12.l2);
                } else {
                    Customer_Det_List_edit5 customer_Det_List_edit13 = Customer_Det_List_edit5.this;
                    Z00 z01 = customer_Det_List_edit13.i;
                    z01.Rc(customer_Det_List_edit13.n2, z01.Dd(c4064uhO0, customer_Det_List_edit13.k2, Double.parseDouble(c4064uhO0.c().replaceAll(",", "")), c4064uhO0.q()));
                }
            } else if (i == 2) {
                Customer_Det_List_edit5.this.k1(2);
            }
            this.a.dismiss();
        }
    }

    public class I0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public I0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    public class J implements View.OnClickListener {
        public J() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
            customer_Det_List_edit5.V = new ArrayAdapter(customer_Det_List_edit6, android.R.layout.simple_spinner_dropdown_item, customer_Det_List_edit6.i.s3());
            Customer_Det_List_edit5 customer_Det_List_edit7 = Customer_Det_List_edit5.this;
            customer_Det_List_edit7.x0(customer_Det_List_edit7.V, Customer_Det_List_edit5.this.i0);
        }
    }

    public class J0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public J0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    public class K implements AdapterView.OnItemClickListener {
        public K() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit5.this.V0.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            customer_Det_List_edit5.B = customer_Det_List_edit5.V0.getText().toString();
            Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
            customer_Det_List_edit6.F = "";
            customer_Det_List_edit6.G = "";
            customer_Det_List_edit6.E = "";
            Customer_Det_List_edit5.v2 = 1;
            customer_Det_List_edit6.G0(true);
            Customer_Det_List_edit5 customer_Det_List_edit7 = Customer_Det_List_edit5.this;
            customer_Det_List_edit7.y1(0, customer_Det_List_edit7.V0.getText().toString(), Customer_Det_List_edit5.this.i0.getText().toString());
        }
    }

    public class K0 implements View.OnClickListener {
        public K0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.phone_pick_btn(view);
        }
    }

    public class L implements View.OnTouchListener {
        public L() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Customer_Det_List_edit5.this.V0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit5.this.V0.getCompoundDrawables()[0] != null ? Customer_Det_List_edit5.this.V0.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit5.this.V0.getPaddingLeft() + Customer_Det_List_edit5.this.V0.getLeft()) {
                    Customer_Det_List_edit5.this.V0.setText("");
                    Customer_Det_List_edit5.this.V0.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Customer_Det_List_edit5.this.V0.getRight();
                Customer_Det_List_edit5.this.V0.getPaddingRight();
                if (Customer_Det_List_edit5.this.V0.getCompoundDrawables()[2] != null) {
                    Customer_Det_List_edit5.this.V0.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class L0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public L0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.z1();
            Customer_Det_List_edit5.this.w0(this.a, this.b, this.c);
        }
    }

    public class M implements TextWatcher {
        public M() {
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
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.V0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit5, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit5.this.V0.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit5.this.V0;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class M0 implements View.OnClickListener {
        public M0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.J0 = true;
        }
    }

    public class N implements View.OnClickListener {
        public N() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_fwd_amount) {
                Customer_Det_List_edit5.this.amount_fwd_btn(view);
            } else if (view.getId() == info.aalmoghalis.inventory.R.id.img_u_currency) {
                Customer_Det_List_edit5.this.u_currency_btn(view);
            }
        }
    }

    public class N0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public N0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.z1();
            Customer_Det_List_edit5.this.w0(this.a, this.b, this.c);
        }
    }

    public class O extends Handler {
        public O() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class O0 implements DialogInterface.OnClickListener {
        public O0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class P implements View.OnClickListener {
        public P() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
            customer_Det_List_edit5.U = new ArrayAdapter(customer_Det_List_edit6, android.R.layout.simple_spinner_dropdown_item, customer_Det_List_edit6.i.D3());
            Customer_Det_List_edit5 customer_Det_List_edit7 = Customer_Det_List_edit5.this;
            customer_Det_List_edit7.x0(customer_Det_List_edit7.U, Customer_Det_List_edit5.this.T);
        }
    }

    public class P0 implements DialogInterface.OnClickListener {
        public P0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Q implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public Q(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit5.this.m0()) {
                Customer_Det_List_edit5.this.f1();
                Log.d("lock=", Customer_Det_List_edit5.this.i.ja("f_name_lock", false) + ":" + Customer_Det_List_edit5.this.i.ja("t_name_lock", false));
                if (!Customer_Det_List_edit5.this.i.ja("f_name_lock", false) && !Customer_Det_List_edit5.this.i.ja("t_name_lock", false)) {
                    Customer_Det_List_edit5.this.R0(2);
                    this.a.dismiss();
                    return;
                }
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.i.Kd(customer_Det_List_edit5, customer_Det_List_edit5.getString(info.aalmoghalis.inventory.R.string.move_inserted), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                Customer_Det_List_edit5.this.R0(4);
                Customer_Det_List_edit5.v2 = 3;
                Customer_Det_List_edit5.this.E1();
                Customer_Det_List_edit5.this.A1(true);
            }
        }
    }

    public class Q0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ Handler h;

        public Q0(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, AlertDialog alertDialog, EditText editText2, EditText editText3, Handler handler) {
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
            if (Customer_Det_List_edit5.this.i.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit5.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit5.this.W1 = this.b.getText().toString();
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.O0(customer_Det_List_edit5.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit5.this.W1, Customer_Det_List_edit5.this);
                if (!Customer_Det_List_edit5.this.S1) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit5.this.i.r1(this.c.getText().toString());
                if (this.d.equals("0")) {
                    if (Customer_Det_List_edit5.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                        customer_Det_List_edit6.i.Pd(customer_Det_List_edit6, customer_Det_List_edit6.N, this.a.getText().toString().trim() + " : " + Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit5.this);
                        this.e.dismiss();
                        return;
                    }
                    Customer_Det_List_edit5.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.f.getText().toString() + "','" + this.g.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                    Handler handler = this.h;
                    handler.sendMessage(handler.obtainMessage());
                } else if (this.d != null) {
                    Customer_Det_List_edit5.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.f.getText().toString() + "',address='" + this.g.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit5.this.k + "' and id>0 ");
                    Handler handler2 = this.h;
                    handler2.sendMessage(handler2.obtainMessage());
                }
                this.e.dismiss();
            }
        }
    }

    public class R implements View.OnClickListener {
        public R() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.calc_pick_btn(view);
        }
    }

    public class R0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ EditText c;

        public R0(AutoCompleteTextView autoCompleteTextView, Dialog dialog, EditText editText) {
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
                    Customer_Det_List_edit5.this.z1();
                }
            }
        }
    }

    public class S implements View.OnClickListener {
        public S() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.D1();
        }
    }

    public class S0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ArrayAdapter b;
        public final /* synthetic */ Dialog c;

        public S0(TextView textView, ArrayAdapter arrayAdapter, Dialog dialog) {
            this.a = textView;
            this.b = arrayAdapter;
            this.c = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getId() == Customer_Det_List_edit5.this.T.getId()) {
                if (i == this.b.getCount() - 1) {
                    Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit5.H1("0", "", "", customer_Det_List_edit5.i.T5("0"), "", Customer_Det_List_edit5.this.i.v1("121"));
                } else {
                    this.a.setText(adapterView.getItemAtPosition(i).toString());
                    if (Customer_Det_List_edit5.this.p == 0) {
                        Customer_Det_List_edit5.this.i.v0("update tr_p_temps set cash_id=" + Customer_Det_List_edit5.this.i.p4(this.a.getText().toString()) + " where p_id=" + Customer_Det_List_edit5.this.p);
                    } else {
                        Customer_Det_List_edit5.this.i.v0("update tr_p_temps set cash_id=" + Customer_Det_List_edit5.this.i.p4(this.a.getText().toString()));
                    }
                    Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                    int iS5 = customer_Det_List_edit6.i.s5(customer_Det_List_edit6.u, -3, Customer_Det_List_edit5.this.T.getText().toString());
                    Customer_Det_List_edit5.this.t0.setHint(Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.bill_no2) + iS5);
                }
            } else if (this.a.getId() == Customer_Det_List_edit5.this.i0.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Customer_Det_List_edit5.this.i0.setTag(this.a.getText());
                Customer_Det_List_edit5.this.J1();
                Customer_Det_List_edit5 customer_Det_List_edit7 = Customer_Det_List_edit5.this;
                customer_Det_List_edit7.P0 = 1;
                customer_Det_List_edit7.u2 = 1;
            }
            this.c.dismiss();
        }
    }

    public class T implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public T(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.R0(2);
            this.a.dismiss();
        }
    }

    public class T0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public T0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    public class U implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public U(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.h0(view, this.a);
        }
    }

    public class U0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public U0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    public class V implements AdapterView.OnItemClickListener {
        public V() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit5.this.p1.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit5.this.new Y0(4).execute(new Void[0]);
            Customer_Det_List_edit5.this.m1.requestFocus();
            if (Customer_Det_List_edit5.v2 == 3) {
                if (!Customer_Det_List_edit5.this.i.ja("t_name_lock", false) || Customer_Det_List_edit5.this.m1.getText() == null || Customer_Det_List_edit5.this.m1.getText().toString().length() <= 0) {
                    Customer_Det_List_edit5.this.m1.requestFocus();
                } else {
                    Customer_Det_List_edit5.this.r1.requestFocus();
                }
            }
        }
    }

    public class V0 implements View.OnClickListener {
        public V0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.phone_pick_btn(view);
        }
    }

    public class W implements AdapterView.OnItemClickListener {
        public W() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit5.this.m1.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit5.this.new Y0(4).execute(new Void[0]);
            Customer_Det_List_edit5.this.r1.requestFocus();
        }
    }

    public class W0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public W0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            customer_Det_List_edit5.i.Md(customer_Det_List_edit5);
            Customer_Det_List_edit5.this.w0(this.a, this.b, this.c);
        }
    }

    public class X implements View.OnTouchListener {
        public X() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Customer_Det_List_edit5.this.p1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit5.this.p1.getCompoundDrawables()[0] != null ? Customer_Det_List_edit5.this.p1.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit5.this.p1.getPaddingLeft() + Customer_Det_List_edit5.this.p1.getLeft()) {
                    Customer_Det_List_edit5.this.p1.setText("");
                    Customer_Det_List_edit5.this.p1.requestFocus();
                    Customer_Det_List_edit5.this.new Y0(4).execute(new Void[0]);
                    return false;
                }
                if (motionEvent.getX() >= (Customer_Det_List_edit5.this.p1.getRight() - Customer_Det_List_edit5.this.p1.getPaddingRight()) - (Customer_Det_List_edit5.this.p1.getCompoundDrawables()[2] != null ? Customer_Det_List_edit5.this.p1.getCompoundDrawables()[2].getBounds().width() : 0)) {
                    Z00 z00 = Customer_Det_List_edit5.this.i;
                    z00.Mc("f_name_lock", true ^ z00.ja("f_name_lock", false));
                    Customer_Det_List_edit5.this.n1();
                }
            }
            return false;
        }
    }

    public class X0 implements TextWatcher {
        public X0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            if (customer_Det_List_edit5.J0) {
                customer_Det_List_edit5.J0 = false;
            } else {
                customer_Det_List_edit5.u2 = 1;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class Y implements TextWatcher {
        public Y() {
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
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.p1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit5, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit5.this.p1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit5.this.p1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class Y0 extends AsyncTask {
        public int a;

        public Y0(int i) {
            this.a = i;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double doInBackground(Void... voidArr) {
            try {
                int i = this.a;
                if (i == 3) {
                    Customer_Det_List_edit5.this.S0();
                    return Double.valueOf(0.0d);
                }
                if (i != 4) {
                    return Double.valueOf(0.0d);
                }
                Customer_Det_List_edit5.this.o1();
                return Double.valueOf(0.0d);
            } catch (Exception unused) {
                return Double.valueOf(0.0d);
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Double d) {
            int i = this.a;
            if (i == 3) {
                Customer_Det_List_edit5.this.U0();
            } else if (i == 4) {
                Customer_Det_List_edit5.this.p1();
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Customer_Det_List_edit5.this.y = 0;
        }
    }

    public class Z implements AdapterView.OnItemClickListener {
        public Z() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                Customer_Det_List_edit5.this.H = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.no_)).getText().toString();
                Customer_Det_List_edit5.this.B = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_name)).getText().toString();
                Customer_Det_List_edit5.this.E = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_qty)).getText().toString();
                Customer_Det_List_edit5.this.F = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_price)).getText().toString();
                Customer_Det_List_edit5.this.G = ((TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_weight)).getText().toString();
                C0634Jt c0634Jt = (C0634Jt) Customer_Det_List_edit5.this.N.getAdapter().getItem(i);
                if (c0634Jt != null) {
                    Customer_Det_List_edit5.this.I = c0634Jt.k();
                    Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                    String str = customer_Det_List_edit5.I;
                    if (str == null) {
                        str = "";
                    }
                    customer_Det_List_edit5.I = str;
                }
                Customer_Det_List_edit5.v2 = 2;
                Integer.parseInt(Customer_Det_List_edit5.this.H);
                C0634Jt c0634Jt2 = (C0634Jt) adapterView.getItemAtPosition(i);
                Customer_Det_List_edit5.this.C = c0634Jt2.j();
                Customer_Det_List_edit5.this.D = c0634Jt2.b();
                Log.d("tr_curr_name=", Customer_Det_List_edit5.this.C + "");
                Customer_Det_List_edit5.this.G0(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2791a implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2791a(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            customer_Det_List_edit5.i.Md(customer_Det_List_edit5);
            Customer_Det_List_edit5.this.w0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$a0, reason: case insensitive filesystem */
    public class C2792a0 implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$a0$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Customer_Det_List_edit5.this.D0();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit5.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$a0$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2792a0() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == info.aalmoghalis.inventory.R.id.menu_curr) {
                SparseBooleanArray sparseBooleanArrayB = Customer_Det_List_edit5.this.v0.b();
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.x0 = sparseBooleanArrayB;
                try {
                    customer_Det_List_edit5.F1();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit5.this.getApplicationContext(), "SQL Error.", 1);
                }
                actionMode.finish();
                return false;
            }
            if (itemId != info.aalmoghalis.inventory.R.id.menu_delete) {
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB2 = Customer_Det_List_edit5.this.v0.b();
            Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
            customer_Det_List_edit6.x0 = sparseBooleanArrayB2;
            AlertDialog.Builder builder = new AlertDialog.Builder(customer_Det_List_edit6);
            builder.setMessage(Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
            builder.setPositiveButton(Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
            builder.setNegativeButton(Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
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
            Customer_Det_List_edit5.this.N.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Customer_Det_List_edit5.this.v0.j.clear();
            Customer_Det_List_edit5.this.v0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Customer_Det_List_edit5.this.N.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Customer_Det_List_edit5.this.v0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Customer_Det_List_edit5.this.N.getCheckedItemCount() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_curr).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_curr).setVisible(true);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$b, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2793b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2793b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$b0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2794b0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2794b0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Customer_Det_List_edit5.this.m1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit5.this.m1.getCompoundDrawables()[0] != null ? Customer_Det_List_edit5.this.m1.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit5.this.m1.getPaddingLeft() + Customer_Det_List_edit5.this.m1.getLeft()) {
                    Customer_Det_List_edit5.this.m1.setText("");
                    Customer_Det_List_edit5.this.m1.requestFocus();
                    Customer_Det_List_edit5.this.new Y0(4).execute(new Void[0]);
                    return false;
                }
                if (motionEvent.getX() >= (Customer_Det_List_edit5.this.m1.getRight() - Customer_Det_List_edit5.this.m1.getPaddingRight()) - (Customer_Det_List_edit5.this.m1.getCompoundDrawables()[2] != null ? Customer_Det_List_edit5.this.m1.getCompoundDrawables()[2].getBounds().width() : 0)) {
                    Z00 z00 = Customer_Det_List_edit5.this.i;
                    z00.Mc("t_name_lock", true ^ z00.ja("t_name_lock", false));
                    Customer_Det_List_edit5.this.n1();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$c, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2795c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2795c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$c0, reason: case insensitive filesystem */
    public class C2796c0 implements TextWatcher {
        public C2796c0() {
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
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.m1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit5, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit5.this.m1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit5.this.m1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2797d implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ AlertDialog g;

        public ViewOnClickListenerC2797d(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, EditText editText2, EditText editText3, AlertDialog alertDialog) {
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
            if (Customer_Det_List_edit5.this.i.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit5.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit5.this.W1 = this.b.getText().toString();
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.O0(customer_Det_List_edit5.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit5.this.W1, Customer_Det_List_edit5.this);
                if (!Customer_Det_List_edit5.this.S1) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit5.this.i.r1(this.c.getText().toString());
                if (!this.d.equals("0")) {
                    if (this.d != null) {
                        Customer_Det_List_edit5.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.e.getText().toString() + "',address='" + this.f.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit5.this.k + "' and id>0 ");
                        this.g.dismiss();
                        return;
                    }
                    return;
                }
                if (Customer_Det_List_edit5.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                    FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit5.this);
                    this.a.setError(Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.exist));
                    return;
                }
                Customer_Det_List_edit5.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.e.getText().toString() + "','" + this.f.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                if (iR1 == 121 || iR1 == 122) {
                    Customer_Det_List_edit5.this.T.setText(this.a.getText().toString());
                }
                this.g.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$d0, reason: case insensitive filesystem */
    public class C2798d0 implements TextWatcher {
        public C2798d0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Customer_Det_List_edit5.this.new Y0(4).execute(new Void[0]);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$e, reason: case insensitive filesystem */
    public class C2799e implements DatePickerDialog.OnDateSetListener {
        public C2799e() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit5.this.K = i;
            Customer_Det_List_edit5.this.L = i2;
            Customer_Det_List_edit5.this.M = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit5.this.M)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit5.this.L + 1)) + "-" + Customer_Det_List_edit5.this.K;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit5.this.S.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
                Customer_Det_List_edit5.this.J1();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$e0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2800e0 implements View.OnClickListener {
        public final /* synthetic */ String a;

        public ViewOnClickListenerC2800e0(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            customer_Det_List_edit5.i.nd(customer_Det_List_edit5.D1, this.a);
            Customer_Det_List_edit5.this.u1.performClick();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$f, reason: case insensitive filesystem */
    public class C2801f implements DatePickerDialog.OnDateSetListener {
        public C2801f() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit5.this.K = i;
            Customer_Det_List_edit5.this.L = i2;
            Customer_Det_List_edit5.this.M = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit5.this.M)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit5.this.L + 1)) + "-" + Customer_Det_List_edit5.this.K;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit5.this.R.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$f0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2802f0 implements View.OnClickListener {
        public ViewOnClickListenerC2802f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.showDialog(5);
            Customer_Det_List_edit5.this.u2 = 1;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$g, reason: case insensitive filesystem */
    public class C2803g implements DatePickerDialog.OnDateSetListener {
        public C2803g() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit5.this.K = i;
            Customer_Det_List_edit5.this.L = i2;
            Customer_Det_List_edit5.this.M = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit5.this.M)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit5.this.L + 1)) + "-" + Customer_Det_List_edit5.this.K;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit5.this.Q.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$g0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2804g0 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2804g0(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            if (!customer_Det_List_edit5.l0(customer_Det_List_edit5.v1.getId())) {
                Customer_Det_List_edit5.this.R0(2);
                this.a.dismiss();
                return;
            }
            Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
            customer_Det_List_edit6.i.Kd(customer_Det_List_edit6, customer_Det_List_edit6.getString(info.aalmoghalis.inventory.R.string.move_inserted), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            Customer_Det_List_edit5.this.R0(2);
            Customer_Det_List_edit5.v2 = 3;
            Customer_Det_List_edit5.this.x1(true);
            Customer_Det_List_edit5.this.r1.setText("");
            Customer_Det_List_edit5.this.u2 = 1;
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$h, reason: case insensitive filesystem */
    public class HandlerC2805h extends Handler {
        public HandlerC2805h() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$h0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2806h0 implements View.OnClickListener {
        public ViewOnClickListenerC2806h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            if (customer_Det_List_edit5.l0(customer_Det_List_edit5.w1.getId())) {
                Customer_Det_List_edit5.this.R0(4);
                Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                customer_Det_List_edit6.i.Kd(customer_Det_List_edit6, customer_Det_List_edit6.getString(info.aalmoghalis.inventory.R.string.move_inserted), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                Customer_Det_List_edit5.v2 = 3;
                Customer_Det_List_edit5.this.x1(true);
                Customer_Det_List_edit5.this.r1.setText("");
                Customer_Det_List_edit5.this.u2 = 1;
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$i, reason: case insensitive filesystem */
    public class RunnableC2807i implements Runnable {
        public final /* synthetic */ int a;

        public RunnableC2807i(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == 4) {
                Customer_Det_List_edit5.this.r1.selectAll();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$i0, reason: case insensitive filesystem */
    public class C2808i0 implements CompoundButton.OnCheckedChangeListener {
        public C2808i0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            int i = 1;
            customer_Det_List_edit5.u2 = 1;
            customer_Det_List_edit5.L1();
            if (Customer_Det_List_edit5.this.u != 6) {
                i = Customer_Det_List_edit5.this.u == 5 ? -1 : 0;
            }
            if (Customer_Det_List_edit5.this.p != 0) {
                Customer_Det_List_edit5.this.i.v0("update tr_p_temps set tr_type=" + Customer_Det_List_edit5.this.u + ",in_=" + i + " where bill_id=-3 and p_id=" + Customer_Det_List_edit5.this.p);
            } else {
                Customer_Det_List_edit5.this.i.v0("update tr_p_temps set tr_type=" + Customer_Det_List_edit5.this.u + ",in_=" + i + " where bill_id=-3");
            }
            Customer_Det_List_edit5.this.R0(4);
            Customer_Det_List_edit5.this.m1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2809j implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public ViewOnClickListenerC2809j(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.h0(view, this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$j0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2810j0 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2810j0(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit5.this.n0()) {
                this.a.dismiss();
                FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit5.this);
                Customer_Det_List_edit5.this.R0(2);
                Customer_Det_List_edit5.this.u2 = 1;
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$k, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2811k implements View.OnClickListener {
        public ViewOnClickListenerC2811k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.j0.setTag(((RadioButton) view).getText().toString());
            Customer_Det_List_edit5.this.J1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$k0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2812k0 implements View.OnClickListener {
        public ViewOnClickListenerC2812k0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.calc_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$l, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2813l implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public ViewOnClickListenerC2813l(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.h0(view, this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$l0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2814l0 implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public ViewOnClickListenerC2814l0(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.h0(view, this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$m, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2815m implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2815m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Log.d("bill_save=", "confirm_save:" + Customer_Det_List_edit5.this.p);
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                customer_Det_List_edit5.k0(2, customer_Det_List_edit5.u);
            } catch (Exception e) {
                Toast.makeText(Customer_Det_List_edit5.this.getApplicationContext(), Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$m0, reason: case insensitive filesystem */
    public class C2816m0 implements AdapterView.OnItemClickListener {
        public C2816m0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit5.this.p1.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit5.this.r1.requestFocus();
            Customer_Det_List_edit5.this.T0();
            Customer_Det_List_edit5.this.r1.selectAll();
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            customer_Det_List_edit5.y1(0, customer_Det_List_edit5.p1.getText().toString(), Customer_Det_List_edit5.this.j0.getTag().toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$n, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2817n implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2817n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
            if (customer_Det_List_edit5.t2 == 1) {
                customer_Det_List_edit5.finish();
            } else {
                customer_Det_List_edit5.u2 = 0;
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$n0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2818n0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public DialogInterfaceOnClickListenerC2818n0(TextView textView, ImageView imageView) {
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
                Customer_Det_List_edit5.this.i.v0("update categ set fav=" + str + " where name = '" + this.a.getText().toString() + "'");
                Customer_Det_List_edit5.this.p = 0;
                Customer_Det_List_edit5.this.R0(1);
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit5.this.getApplicationContext(), Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$o, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2819o implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC2819o(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit5.this);
                if (this.a[i].equals(Customer_Det_List_edit5.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit5.e2 = customer_Det_List_edit5.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit5.this.o0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit5.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit6.e2 = customer_Det_List_edit6.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit5.this.K0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit5.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit5.this.i.qa(Z00.M + Customer_Det_List_edit5.this.B1.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit5.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit5.this.B1.setTag(null);
                    Customer_Det_List_edit5.this.B1.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$o0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2820o0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2820o0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$p, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2821p implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC2821p(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit5.this);
                if (this.a[i].equals(Customer_Det_List_edit5.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit5.e2 = customer_Det_List_edit5.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit5.this.o0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit5.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit6.e2 = customer_Det_List_edit6.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit5.this.K0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit5.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit5.this.i.qa(Z00.M + Customer_Det_List_edit5.this.A1.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit5.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit5.this.A1.setTag(null);
                    Customer_Det_List_edit5.this.A1.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Customer_Det_List_edit5.this.A1.getLayoutParams().width = (int) Customer_Det_List_edit5.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Customer_Det_List_edit5.this.A1.getLayoutParams().height = (int) Customer_Det_List_edit5.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$p0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2822p0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public DialogInterfaceOnClickListenerC2822p0(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Customer_Det_List_edit5.this.i.v0("delete from tr_p_temps  where no_=  '" + this.a.getText().toString() + "'");
                    Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                    customer_Det_List_edit5.P0 = 1;
                    customer_Det_List_edit5.R0(2);
                    Customer_Det_List_edit5.this.C0();
                }
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit5.this.getApplicationContext(), Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$q, reason: case insensitive filesystem */
    public class C2823q implements ActivityResultCallback {
        public C2823q() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Customer_Det_List_edit5.this.C1();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$q0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2824q0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2824q0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$r, reason: case insensitive filesystem */
    public class HandlerC2825r extends Handler {
        public HandlerC2825r() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$r0, reason: case insensitive filesystem */
    public class HandlerC2826r0 extends Handler {
        public HandlerC2826r0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$s, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2827s implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2827s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                EditText editText = Customer_Det_List_edit5.this.t0;
                StringBuilder sb = new StringBuilder();
                Customer_Det_List_edit5 customer_Det_List_edit5 = Customer_Det_List_edit5.this;
                sb.append(customer_Det_List_edit5.i.s5(customer_Det_List_edit5.u, -3, Customer_Det_List_edit5.this.T.getText().toString()));
                sb.append("");
                editText.setText(sb.toString());
                Customer_Det_List_edit5.this.d2 = true;
                Log.d("bill_save=", "confirm_update_bill_no:" + Customer_Det_List_edit5.this.p);
                Customer_Det_List_edit5 customer_Det_List_edit6 = Customer_Det_List_edit5.this;
                customer_Det_List_edit6.k0(2, customer_Det_List_edit6.u);
            } catch (Exception e) {
                Toast.makeText(Customer_Det_List_edit5.this.getApplicationContext(), Customer_Det_List_edit5.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$s0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2828s0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public DialogInterfaceOnClickListenerC2828s0(Handler handler, String str, int i) {
            this.a = handler;
            this.b = str;
            this.c = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5.this.d0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$t, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2829t implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2829t(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5.this.i.v0("insert into groups  (name )  values( '" + Customer_Det_List_edit5.this.W1 + "'  )");
            Customer_Det_List_edit5.this.U1 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$t0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2830t0 implements View.OnClickListener {
        public ViewOnClickListenerC2830t0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.showDialog(0);
            Customer_Det_List_edit5.this.u2 = 1;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$u, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2831u implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2831u(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5.this.U1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$u0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2832u0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2832u0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5.this.S1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$v, reason: case insensitive filesystem */
    public class C2833v implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2833v(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$v0, reason: case insensitive filesystem */
    public class HandlerC2834v0 extends Handler {
        public HandlerC2834v0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$w, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2835w implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnTouchListenerC2835w(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$w0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2836w0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2836w0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5.this.e0(this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$x, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2837x implements View.OnClickListener {
        public ViewOnClickListenerC2837x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$x0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2838x0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2838x0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit5.this.S1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$y, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2839y implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2839y(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit5.this.w0(this.a, this.b, null);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$y0, reason: case insensitive filesystem */
    public class C2840y0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2840y0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit5$z, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2841z implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2841z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class z0 implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public z0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    private void B0(File file, File file2) throws IOException {
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

    private void F0() {
        String[] stringArray = this.A1.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC2821p(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.h2.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.g2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1() {
        if (this.P.isChecked()) {
            setTitle(getString(info.aalmoghalis.inventory.R.string.doc_title) + " " + getString(info.aalmoghalis.inventory.R.string.doc_out));
            this.u = 6;
            this.s0.setText(this.i.V8(6));
        } else {
            setTitle(getString(info.aalmoghalis.inventory.R.string.doc_title) + " " + getString(info.aalmoghalis.inventory.R.string.doc_in));
            this.u = 5;
            this.s0.setText(this.i.V8(5));
        }
        m1();
        if (this.p != 0) {
            try {
                ArrayList arrayListH = C2160f10.H(this.i, "select distinct tr_type from transactions where p_id=" + this.p + " and  tr_type= " + this.u + " and p_ref_no='" + this.t0.getText().toString() + "' ");
                if (arrayListH != null && arrayListH.size() != 0) {
                    if (((String) ((HashMap) arrayListH.get(0)).get("tr_type")).equals(this.u + "")) {
                        return;
                    }
                }
                A0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean Z0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean a1() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && Z0(21, 22);
    }

    public static boolean b1(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean c1(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean d1(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        i1(uri, true);
    }

    private void h1(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                B0(new File(Z00.A0), file2);
            } else {
                B0(new File(M0(this, this.j2)), file2);
            }
            u1(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void i1(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.i, this);
            if (strX != null) {
                u1(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            C1();
            return;
        }
        int i = Integer.parseInt(this.i.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.i.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.i2.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean p0() {
        Log.d("IMEI=", "AFTER VALIDATION");
        boolean zA = AbstractC4371yX.a(this.r1);
        if (!AbstractC4371yX.a(this.p1)) {
            zA = false;
        }
        if (this.i.u3(this.p1.getText().toString()) != 0 || this.i.u3(this.p1.getText().toString().trim()) != 0) {
            return zA;
        }
        this.p1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
        return false;
    }

    private boolean q0() {
        boolean zA = AbstractC4371yX.a(this.p1);
        if (!AbstractC4371yX.a(this.m1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.r1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.D1)) {
            zA = false;
        }
        if (this.i.u3(this.m1.getText().toString()) == 0 && this.i.u3(this.m1.getText().toString().trim()) == 0) {
            this.m1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.i.u3(this.p1.getText().toString()) != 0 || this.i.u3(this.p1.getText().toString().trim()) != 0) {
            return zA;
        }
        this.p1.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
        return false;
    }

    private void r0() {
        if (this.i.u3(this.p1.getText().toString()) == 0 && this.i.u3(this.p1.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.p1;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.p1.getText().toString().length() >= 1 && this.u1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_add))) {
                N0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.p1.getText()), this, this.p1.getText().toString(), 0);
                this.y0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
                this.p1.setThreshold(1);
                this.p1.setAdapter(this.y0);
            }
        }
        if (!this.p1.getText().toString().equals(this.p1.getText().toString().trim()) && this.i.u3(this.p1.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView2 = this.p1;
            autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
        }
        this.i.D = false;
        if (this.i0.getTag() != null && !this.i0.getTag().toString().equals(this.i.l3("0")) && this.i.Z2(this.i0.getTag().toString(), this.i.cc(this.S.getText().toString())) == 0) {
            this.i.u(this, this.i0.getTag().toString(), this.i.cc(this.S.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
        }
        this.i.D = false;
        if (this.j0.getTag() == null || this.j0.getTag().toString().equals(this.i.l3("0")) || this.i.Z2(this.j0.getTag().toString(), this.i.cc(this.S.getText().toString())) != 0) {
            return;
        }
        this.i.u(this, this.j0.getTag().toString(), this.i.cc(this.S.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    private void s0() {
        if (this.i.u3(this.m1.getText().toString()) == 0 && this.m1.getText().toString().length() >= 1 && this.u1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
            N0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.m1.getText()), this, this.m1.getText().toString(), 0);
        }
        if (this.i.u3(this.p1.getText().toString()) == 0 && this.p1.getText().toString().length() >= 1 && this.u1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
            N0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.p1.getText()), this, this.p1.getText().toString(), 0);
        }
    }

    private void s1(ImageView imageView) {
        this.R1 = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
        imageView.getLayoutParams().width = this.R1;
        imageView.getLayoutParams().height = this.R1;
    }

    private boolean t0() {
        boolean zA = AbstractC4371yX.a(this.r1);
        if (!AbstractC4371yX.a(this.p1)) {
            zA = false;
        }
        if (this.p != 0 && !AbstractC4371yX.a(this.t0)) {
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

    private void t1() {
        String[] stringArray = this.B1.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC2819o(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    private boolean u0() {
        Log.d("save_trace=", "checkValidation_save_doc:" + this.p);
        boolean z = false;
        boolean z2 = this.p == 0 || AbstractC4371yX.a(this.t0);
        ArrayList arrayListI8 = this.i.I8("-3");
        this.l0 = arrayListI8;
        if (arrayListI8 != null && arrayListI8.size() > 0) {
            for (int i = 0; i < this.l0.size(); i++) {
                Log.d("curr_price=", "" + ((String) ((HashMap) this.l0.get(i)).get("price")) + ":" + ((String) ((HashMap) this.l0.get(i)).get("name")));
                if (Double.parseDouble((String) ((HashMap) this.l0.get(i)).get("price")) == 0.0d) {
                    this.h0.performClick();
                    z2 = false;
                    break;
                }
            }
        }
        if (this.i.Q()) {
            y0();
        } else {
            z = z2;
        }
        Log.d("save_trace=", "checkValidation_save_doc:" + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void A0() {
        if (this.i.ja("prefOthers_closed_year", false)) {
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_bill_no).replace("{0}", this.i.s5(this.u, -3, this.T.getText().toString()) + ""));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2827s());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new D());
        builder.create().show();
    }

    public void A1(boolean z) {
        String str;
        this.i.ad(this, this.r1);
        this.i.Zc(this, this.m1);
        this.i.Zc(this, this.p1);
        this.i.Zc(this, this.D1);
        if (z) {
            if (v2 != 1 || (str = this.B) == null || str.equals("")) {
                int i = v2;
                if (i == 2) {
                    this.r1.requestFocus();
                    this.r1.selectAll();
                } else if (i == 3) {
                    new Y0(4).execute(new Void[0]);
                    n1();
                    this.N1.setVisibility(0);
                } else {
                    this.p1.requestFocus();
                    n1();
                }
            } else {
                this.p1.setText(this.B);
                this.m1.requestFocus();
                n1();
            }
        }
        this.p1.setThreshold(1);
        this.m1.setThreshold(1);
        this.D1.setThreshold(1);
        new Y0(4).execute(new Void[0]);
        this.p1.setOnItemClickListener(new V());
        this.m1.setOnItemClickListener(new W());
        this.p1.setOnTouchListener(new X());
        this.p1.addTextChangedListener(new Y());
        this.m1.setOnTouchListener(new ViewOnTouchListenerC2794b0());
        this.m1.addTextChangedListener(new C2796c0());
        this.D1.addTextChangedListener(new C2798d0());
        this.M1.setVisibility(0);
        if (z) {
            return;
        }
        this.p1.setText(this.k1);
        this.m1.setText(this.l1);
        this.i.nd(this.D1, this.G);
        TextView textView = this.Q;
        if (textView != null) {
            textView.setText(this.D);
        }
        this.r1.setText(this.i.P7(String.valueOf(Double.parseDouble(this.E.replaceAll(",", "")) + Double.parseDouble(this.F.replaceAll(",", "")))));
        if (!this.I.equals("")) {
            this.A1.setImageBitmap(Z00.p0(Z00.M + this.I, 100, 100));
            this.A1.setTag(this.I);
            this.A1.getLayoutParams().width = 100;
            this.A1.getLayoutParams().height = 70;
        }
        this.r1.selectAll();
        this.r1.requestFocus();
    }

    public void B1(String str) {
        if (C1839c10.k(this.i, this.k)) {
            try {
                X0();
                i0();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.i.ja("prefAutoNotify", false)) {
            X0();
            return;
        }
        Snackbar snackbarMake = Snackbar.make(this.N, "", -2);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
        TextView textView = (TextView) snackbarLayout.findViewById(info.aalmoghalis.inventory.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, info.aalmoghalis.inventory.R.color.white));
        C4064uh c4064uhO0 = this.i.O0(str, ((C0634Jt) this.N.getAdapter().getItem(0)).j());
        StringBuilder sb = new StringBuilder();
        sb.append(c4064uhO0.t() == this.r2[0] ? this.i.Q2() : this.i.c5());
        sb.append(" ");
        sb.append(c4064uhO0.n());
        sb.append(" ");
        sb.append(c4064uhO0.r());
        snackbarMake.setText(sb.toString());
        snackbarMake.setAction(getString(info.aalmoghalis.inventory.R.string.hide_tr), new F(snackbarMake));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_share), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setOnClickListener(new G());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();
        layoutParams.gravity = 16;
        snackbarLayout.setLayoutParams(layoutParams);
        ViewCompat.setLayoutDirection(snackbarMake.getView(), 1);
        snackbarMake.show();
        new Handler().postDelayed(new H(snackbarMake), 5000);
    }

    public void C0() {
        this.f1 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
        this.V0.setThreshold(1);
        this.V0.setAdapter(this.f1);
        this.V0.setOnItemClickListener(new K());
        this.V0.setOnTouchListener(new L());
        this.V0.addTextChangedListener(new M());
    }

    public void C1() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.i.J2(this, intent);
            this.j2 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.j2.getPath() + "");
            startActivityForResult(intent, this.f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void D0() {
        if (getIntent().getStringExtra("P_ID") != null || (this.p != 0 && this.q2 == 1)) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "edit")) {
                Context context = this.O0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "new")) {
            Context context2 = this.O0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.x0.size() - 1; size >= 0; size--) {
            if (this.x0.valueAt(size)) {
                C0634Jt item = this.v0.getItem(this.x0.keyAt(size));
                this.v0.remove(item);
                this.i.v0("delete from tr_p_temps where no_='" + item.f() + "'");
            }
        }
        this.P0 = 1;
        R0(2);
        this.u2 = 1;
        this.P0 = 1;
    }

    public void D1() {
        try {
            int i = v2;
            if (i == 3 || i == 1) {
                String string = this.p1.getText().toString();
                boolean zJa = this.i.ja("f_name_lock", true);
                this.p1.setText(this.m1.getText());
                this.m1.setText(string);
                Z00 z00 = this.i;
                z00.Mc("f_name_lock", z00.ja("t_name_lock", false));
                this.i.Mc("t_name_lock", zJa);
                n1();
                E1();
            } else if (i == 2) {
                String string2 = this.p1.getText().toString();
                this.i.ja("f_name_lock", true);
                this.p1.setText(this.m1.getText());
                this.m1.setText(string2);
            }
            new Y0(4).execute(new Void[0]);
        } catch (Exception unused) {
        }
    }

    public void E0() {
        this.i.v0("delete from tr_p_temps where bill_id=-3 and cus_id=cash_id  and in_<>(case when tr_type=6 then 1 when tr_type=5 then -1 else 0 end) and cash_id=(select id from customers where name='" + this.T.getText().toString() + "')");
        this.i.v0("update tr_p_temps set curr_price=0 where curr_id=0");
        this.i.v0("update tr_p_temps set p_curr_price=0 where p_curr_id=0");
    }

    public void E1() {
        if (!this.i.ja("f_name_lock", true)) {
            this.p1.setText("");
            if (!this.p1.hasFocus()) {
                this.p1.requestFocus();
            }
        }
        if (!this.i.ja("t_name_lock", false)) {
            this.m1.setText("");
            if (!this.m1.hasFocus() && this.i.ja("f_name_lock", true)) {
                this.m1.requestFocus();
            }
        }
        if (this.i.ja("f_name_lock", true) && this.i.ja("t_name_lock", true)) {
            this.r1.setText("");
            if (!this.r1.hasFocus()) {
                this.r1.selectAll();
                this.r1.requestFocus();
            }
        }
        if (this.i.ja("t_name_lock", false) && this.m1.getText() != null && this.m1.getText().toString().length() > 0) {
            this.p1.setImeOptions(5);
            this.p1.setNextFocusDownId(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.p1.setNextFocusForwardId(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        }
        this.r1.setText("");
    }

    public void F1() {
        if (this.x0.valueAt(0)) {
            C0634Jt item = this.v0.getItem(this.x0.keyAt(0));
            ArrayList arrayListJ8 = this.i.J8("-3", item.f());
            this.m0 = arrayListJ8;
            if (arrayListJ8 == null || arrayListJ8.size() == 0) {
                this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.local_curr), 1000);
                return;
            }
            this.i.me("-3", this, this.m0, new HandlerC2805h(), item.f());
            try {
                Looper.loop();
            } catch (RuntimeException unused) {
            }
            R0(2);
            this.u2 = 1;
        }
    }

    public void G0(boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_doc_item_add_view5, (ViewGroup) null);
            builder.setView(viewInflate);
            this.p1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name_det);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.r1 = editText;
            this.t1 = editText;
            editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
            EditText editText2 = this.r1;
            editText2.addTextChangedListener(new C2018dE(editText2));
            this.Q = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.u1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
            this.v1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add1);
            this.w1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add2);
            this.y1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
            this.A1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            this.B1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach4);
            this.E1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
            this.F1 = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton1);
            RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
            this.G1 = radioButton;
            this.i.gd(this.F1, radioButton);
            this.E1.check(info.aalmoghalis.inventory.R.id.radiobutton2);
            this.D1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.C1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks4);
            this.H1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
            this.I1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.J1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
            this.L1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface5);
            this.O1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface7);
            this.M1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
            this.j0 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr_add);
            if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                this.Q.setVisibility(0);
            } else {
                this.Q.setVisibility(8);
            }
            this.Q.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
            x1(z);
            this.Q.setOnClickListener(new ViewOnClickListenerC2802f0());
            if (!z) {
                this.i.Zc(this, this.p1);
                this.i.ad(this, this.r1);
                this.i.cd(this, this.D1);
                this.p1.setText(this.B);
                this.r1.setText(this.i.P7(String.valueOf(Double.parseDouble(this.E.replaceAll(",", "")) + Double.parseDouble(this.F.replaceAll(",", "")))));
                this.i.nd(this.D1, this.G);
                TextView textView = this.Q;
                if (textView != null) {
                    textView.setText(this.D);
                }
                this.u1.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
                if (this.E.equals("0")) {
                    this.F1.setChecked(true);
                } else if (this.F.equals("0")) {
                    this.G1.setChecked(true);
                }
                if (this.I.equals("")) {
                    s1(this.A1);
                } else {
                    Log.d("tr_attach_l=", this.I);
                    u1(this.I);
                }
            }
            builder.setCancelable(true);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            this.y0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.m1());
            this.p1.setThreshold(1);
            this.p1.setAdapter(this.y0);
            this.p1.setText(this.B);
            T0();
            if (!z) {
                this.r1.requestFocus();
                this.r1.selectAll();
                Y0(4, 500);
            } else if (this.B.length() > 0) {
                this.r1.requestFocus();
            } else {
                this.p1.requestFocus();
            }
            this.i.Zc(this, this.p1);
            this.i.ad(this, this.r1);
            v1();
            this.v1.setOnClickListener(new ViewOnClickListenerC2804g0(alertDialogCreate));
            this.w1.setOnClickListener(new ViewOnClickListenerC2806h0());
            this.u1.setOnClickListener(new ViewOnClickListenerC2810j0(alertDialogCreate));
            this.y1.setOnClickListener(new ViewOnClickListenerC2812k0());
            this.A1.setOnClickListener(new ViewOnClickListenerC2814l0(z));
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("edit_item_error=", ":" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void G1(String str, String str2, String str3, String str4) {
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
            autoCompleteTextView.setOnItemClickListener(new C2833v(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC2835w(autoCompleteTextView));
            this.s1 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new ViewOnClickListenerC2837x());
            imageView2.setOnClickListener(new ViewOnClickListenerC2839y(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2841z());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new A());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new B(editText2, autoCompleteTextView, str2, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void H0(boolean z) {
        String str;
        try {
            this.k0 = this.i.j3();
            Log.d("radioGroup_curr2=", this.k0.size() + ":" + this.z);
            String str2 = this.z;
            if (str2 == null) {
                str2 = "";
            }
            this.z = str2;
            int size = this.k0.size();
            RadioButton[] radioButtonArr = new RadioButton[size];
            this.j0.setTag(null);
            this.j0.removeAllViews();
            this.j0.clearCheck();
            for (int i = 0; i < this.k0.size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButtonArr[i] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.k0.get(i)).get("name"));
                radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.k0.get(i)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i].setButtonDrawable(android.R.color.transparent);
                radioButtonArr[i].setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.btn_radio), (Drawable) null);
                radioButtonArr[i].setOnClickListener(new ViewOnClickListenerC2811k());
                this.j0.addView(radioButtonArr[i]);
                if (!z && (str = this.C) != null && str.equals(((HashMap) this.k0.get(i)).get("name"))) {
                    Log.d("tr_curr_name_l=", this.C + ":" + ((String) ((HashMap) this.k0.get(i)).get("name")) + ":" + this.k2);
                    this.j0.check(radioButtonArr[i].getId());
                    this.j0.setTag(((HashMap) this.k0.get(i)).get("name"));
                } else if (z && this.i0.getText().toString().equals(((HashMap) this.k0.get(i)).get("name"))) {
                    this.j0.check(radioButtonArr[i].getId());
                    this.j0.setTag(((HashMap) this.k0.get(i)).get("name"));
                }
            }
            if (this.z.equals("") && this.j0.getTag() == null) {
                this.j0.check(radioButtonArr[this.k0.size() - 1].getId());
                this.j0.setTag(radioButtonArr[this.k0.size() - 1].getText().toString());
            } else if (this.j0.getTag() == null) {
                this.j0.setTag(this.z);
                for (int i2 = 0; i2 < size; i2++) {
                    if (radioButtonArr[i2].getText().toString().equals(this.z)) {
                        this.j0.check(radioButtonArr[i2].getId());
                    }
                }
            }
        } catch (Exception e) {
            Log.d("fill_curr_error2=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void H1(String str, String str2, String str3, String str4, String str5, String str6) {
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
            autoCompleteTextView.setOnItemClickListener(new T0(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new U0(autoCompleteTextView2, editText));
            this.s1 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new V0());
            imageView2.setOnClickListener(new W0(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new ViewOnClickListenerC2791a(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2793b());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2795c());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2797d(editText, autoCompleteTextView, autoCompleteTextView2, str, editText2, editText3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void I0(Cursor cursor) {
        int i;
        int count = cursor.getCount();
        StringBuilder sb = new StringBuilder();
        sb.append(count);
        String str = ":";
        sb.append(":");
        sb.append(this.p);
        Log.d("Cursor_cnt=", sb.toString());
        this.w0.clear();
        cursor.moveToFirst();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        while (!cursor.isAfterLast()) {
            i2++;
            String str2 = str;
            int i3 = count;
            this.w0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("cus_name")), cursor.getString(cursor.getColumnIndex("param1")), cursor.getString(cursor.getColumnIndex("tr_remarks")), this.i.P7(String.valueOf(Math.abs(cursor.getDouble(cursor.getColumnIndex("credit")) + cursor.getDouble(cursor.getColumnIndex("debit"))))), "0", cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tr_curr_name")), cursor.getString(cursor.getColumnIndex("date_"))));
            d += (cursor.getDouble(cursor.getColumnIndex("credit")) * cursor.getDouble(cursor.getColumnIndex("curr_price"))) / cursor.getDouble(cursor.getColumnIndex("p_curr_price"));
            d2 += (cursor.getDouble(cursor.getColumnIndex("debit")) * cursor.getDouble(cursor.getColumnIndex("curr_price"))) / cursor.getDouble(cursor.getColumnIndex("p_curr_price"));
            d3 = d2 - d;
            this.z = cursor.getString(cursor.getColumnIndex("doc_curr_name"));
            if (this.p != 0) {
                i = i3;
                if (i2 == i) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.p);
                    str2 = str2;
                    sb2.append(str2);
                    sb2.append(i2);
                    sb2.append(str2);
                    sb2.append(i);
                    sb2.append(str2);
                    sb2.append(cursor.getString(cursor.getColumnIndex("cash_name")));
                    Log.d("doc_det=", sb2.toString());
                    String string = cursor.getString(cursor.getColumnIndex("doc_curr_name"));
                    this.z = string;
                    this.i0.setText(string);
                    this.i0.setTag(this.z);
                    this.S.setText(cursor.getString(cursor.getColumnIndex("p_date")));
                    this.i.nd(this.t0, cursor.getString(cursor.getColumnIndex("bill_no")));
                    this.t0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + cursor.getString(cursor.getColumnIndex("bill_no")));
                    this.i.nd(this.u0, cursor.getString(cursor.getColumnIndex("p_remarks")));
                    this.T.setText(cursor.getString(cursor.getColumnIndex("cash_name")));
                    int i4 = cursor.getInt(cursor.getColumnIndex("tr_type"));
                    this.u = i4;
                    if (i4 == 5) {
                        this.P.setChecked(false);
                        this.u2 = 0;
                    } else {
                        this.P.setChecked(true);
                        this.u2 = 0;
                    }
                }
                cursor.moveToNext();
                count = i;
                str = str2;
            } else {
                i = i3;
            }
            cursor.moveToNext();
            count = i;
            str = str2;
        }
        cursor.close();
        this.X.setText(this.i.P7(d + ""));
        this.Y.setText(this.i.P7(d2 + ""));
        this.Z.setText(this.i.P7(Math.abs(d3) + ""));
        C0809Ov c0809Ov = new C0809Ov(this, info.aalmoghalis.inventory.R.layout.doc_item_det_row5, this.w0, this.z);
        this.v0 = c0809Ov;
        c0809Ov.j.clear();
        this.v0.notifyDataSetChanged();
        this.N.setAdapter((ListAdapter) this.v0);
    }

    public void I1(String str, String str2, String str3, String str4, String str5, String str6, Handler handler) {
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
            autoCompleteTextView.setOnItemClickListener(new I0(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new J0(autoCompleteTextView2, editText2));
            this.s1 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new K0());
            imageView2.setOnClickListener(new L0(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new N0(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new O0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new P0());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new Q0(editText, autoCompleteTextView, autoCompleteTextView2, str, alertDialogCreate, editText2, editText3, handler));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void J0(ArrayList arrayList) {
        LayoutInflater layoutInflater = getLayoutInflater();
        int size = arrayList.size();
        if (this.J1.getChildCount() > 0) {
            this.J1.removeAllViews();
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2) != null) {
                i++;
                if (i >= 4) {
                    return;
                }
                RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(info.aalmoghalis.inventory.R.layout.clickable_remarks, (ViewGroup) null);
                new LinearLayout.LayoutParams(-2, -2);
                Button button = (Button) relativeLayout.findViewById(info.aalmoghalis.inventory.R.id.btn_remarks);
                button.setText((CharSequence) arrayList.get(i2));
                button.setOnClickListener(new ViewOnClickListenerC2800e0((String) arrayList.get(i2)));
                this.J1.addView(relativeLayout);
            }
        }
    }

    public void J1() {
        v0();
        String str = "0";
        String str2 = "";
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
            if (this.i0.getText() != null) {
                str = "(select id from currency where name='" + this.i0.getText().toString() + "'),p_curr_price=0";
            }
            sb.append(str);
            sb.append(",curr_mod=0   where p_id=");
            sb.append(this.p);
            z00.v0(sb.toString());
            R0(4);
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
            if (this.i0.getText() != null) {
                str = "(select id from currency where name='" + this.i0.getText().toString() + "'),p_curr_price=0";
            }
            sb2.append(str);
            z01.v0(sb2.toString());
            R0(4);
        }
        FragmentStatePagerSupport_Main.a0 = true;
    }

    public void K1(String str, String str2, String str3, Handler handler) {
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
            autoCompleteTextView.setOnItemClickListener(new C2840y0(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new z0(autoCompleteTextView));
            imageView.setOnClickListener(new A0(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new C0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new D0());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new E0(autoCompleteTextView, alertDialogCreate, str, editText, handler));
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String L0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public String M0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (c1(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (b1(uri)) {
                        return L0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (d1(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return L0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return L0(context, uri, null, null);
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

    public boolean N0(String str, String str2, Context context, String str3, int i) {
        HandlerC2826r0 handlerC2826r0 = new HandlerC2826r0();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2828s0(handlerC2826r0, str3, i));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2832u0(handlerC2826r0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.S1;
    }

    public boolean O0(String str, String str2, Context context) {
        HandlerC2834v0 handlerC2834v0 = new HandlerC2834v0();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2836w0(handlerC2834v0));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2838x0(handlerC2834v0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.S1;
    }

    public boolean P0(String str, String str2, Context context) {
        F0 f0 = new F0();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new G0(f0));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new H0(f0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.V1;
    }

    public boolean Q0(String str, String str2, Context context) {
        HandlerC2825r handlerC2825r = new HandlerC2825r();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2829t(handlerC2825r));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2831u(handlerC2825r));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.U1;
    }

    public void R0(int i) {
        try {
            E0();
            StringBuilder sb = new StringBuilder();
            sb.append("Yes:");
            sb.append(this.p);
            sb.append(":");
            sb.append(i);
            sb.append(":");
            sb.append(this.i0.getText() == null ? "" : this.i0.getText().toString());
            sb.append("#");
            sb.append(this.u2);
            Log.d("get_all_name=", sb.toString());
            if (i == 1 && this.p != 0) {
                if (this.q.equals("")) {
                    I0(this.i.k5(String.valueOf(this.p), "-3", this.i.p4(this.T.getText().toString())));
                } else {
                    I0(this.i.l5(String.valueOf(this.p), "-3", this.i.p4(this.T.getText().toString()), this.q, this.t));
                }
                this.u2 = 0;
            } else if (i == 2) {
                I0(this.i.p5("-3"));
                z1();
                this.V0.setText("");
            } else if (i == 3) {
                I0(this.i.k5(String.valueOf(this.p), "-3", this.i.p4(this.T.getText().toString())));
                this.u2 = 0;
            } else if (i == 4) {
                I0(this.i.p5("-3"));
                this.V0.setText("");
            }
            ArrayList arrayListI8 = this.i.I8("-3");
            this.l0 = arrayListI8;
            if (arrayListI8 == null || arrayListI8.size() <= 0) {
                this.h0.setVisibility(8);
            } else {
                this.h0.setVisibility(0);
            }
        } catch (Exception e) {
            Log.d("Fetch_error=", e.getMessage() + "");
            e.printStackTrace();
        }
    }

    public void S0() {
        Cursor cursorE8 = this.i.E8(this.p1.getText().toString());
        this.D0 = new String[cursorE8.getCount()];
        if (cursorE8.moveToFirst()) {
            int i = 0;
            do {
                this.D0[i] = cursorE8.getString(cursorE8.getColumnIndex("remarks"));
                i++;
            } while (cursorE8.moveToNext());
        }
        cursorE8.close();
    }

    public void T0() {
        C1044Xj.a().c(new RunnableC1171Zj(4, this.i, this.p1, this.D1, this.C1, this, this.J1, v2, this.u1, new RunnableC1086Yj()));
    }

    public void U0() {
        Log.d("item2=", this.D0.length + "");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.D0);
        this.z0 = arrayAdapter;
        this.D1.setAdapter(arrayAdapter);
    }

    public void V0(String str) {
        C4143vg c4143vgQ4 = this.i.q4(str);
        if (c4143vgQ4.i().equals("")) {
            return;
        }
        this.k = c4143vgQ4.i();
        this.k2 = c4143vgQ4.j();
        this.n2 = c4143vgQ4.h();
        this.m2 = "0";
        this.l2 = c4143vgQ4.f();
    }

    public void W0() {
        String str;
        try {
            if (getIntent().getStringExtra("P_ID") != null) {
                this.p = Integer.parseInt(getIntent().getStringExtra("P_ID"));
                this.T.setText(getIntent().getStringExtra("cash_name"));
                if (getIntent().getStringExtra(DublinCoreProperties.DATE) != null) {
                    this.q = getIntent().getStringExtra(DublinCoreProperties.DATE);
                    this.t = getIntent().getStringExtra("dev_id") == null ? "0" : getIntent().getStringExtra("dev_id");
                    Log.d("get_items_temp=", this.p + ":" + this.t);
                    this.i.v0("delete from tr_p_temps");
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,tr_type,cash_id,curr_price,p_curr_price,curr_mod ,param1,param2) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,id,tr_type,cash_id,curr_price,p_curr_price,curr_mod ,param1,param2 from transactions_v where p_id='");
                    sb.append(this.p);
                    sb.append("' and bill_id=-3 and p_date='");
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
                    Log.d("get_items_temp2=", this.p + ":" + this.t);
                    this.i.v0("delete from tr_p_temps");
                    this.i.v0("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,tr_type,cash_id,curr_price,p_curr_price,curr_mod ,param1,param2) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,id,tr_type,cash_id,curr_price,p_curr_price,curr_mod ,param1,param2 from transactions_v where p_id='" + this.p + "' and bill_id=-3 ");
                }
                E0();
                this.J = getIntent().getIntExtra("back_edit", 0);
            }
            this.J = getIntent().getIntExtra("back_edit", 0);
        } catch (Exception unused) {
        }
    }

    public void X0() {
        Log.d("go_doc_list=", HTML.Attribute.START);
        Bill_edit.P2 = false;
        Intent intent = new Intent(this, (Class<?>) Daily_Doc_Report.class);
        intent.addFlags(67108864);
        if (C2160f10.h != -1) {
            this.l = C2160f10.j + "";
            this.n = this.i.A4(C2160f10.j + "");
        }
        intent.putExtra("g_id", this.l);
        intent.putExtra("g_name", this.n);
        intent.putExtra("title_", getString(info.aalmoghalis.inventory.R.string.doc_title));
        if (this.i.S()) {
            intent.putExtra("sync", "1");
        }
        startActivity(intent);
        finish();
    }

    public void Y0(int i, int i2) {
        try {
            new Handler().postDelayed(new RunnableC2807i(i), i2);
        } catch (Exception unused) {
        }
    }

    public void add_item(View view) {
        this.B = "";
        this.F = "";
        this.G = "";
        this.E = "";
        this.C = "";
        if (this.V0.getText() == null || this.V0.getText().toString().equals("")) {
            this.B = "";
            this.F = "";
            this.G = "";
            this.E = "";
            this.C = "";
        } else if (this.i.m1().contains(this.V0.getText().toString())) {
            double dG5 = this.i.g5();
            this.B = this.V0.getText().toString();
            this.F = dG5 > 0.0d ? String.valueOf(dG5) : "";
        } else {
            this.B = this.V0.getText().toString();
        }
        v2 = 1;
        G0(true);
    }

    public void amount_fwd_btn(View view) {
        v2 = 1;
        g1(true);
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.N0 = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_item_hide(View view) {
        this.q0.setVisibility(8);
        this.r0.setVisibility(0);
        this.o0.setVisibility(0);
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.no_);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2822p0(textView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2824q0());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.q0.setVisibility(0);
        this.o0.setVisibility(4);
        this.V0.requestFocus();
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
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2818n0(textView, imageView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2820o0());
        builder.create().show();
    }

    public void calc_pick_btn(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", this.r1.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void d0(Handler handler, String str, int i) {
        I1("0", str.trim(), "", this.i.T5("0"), "", "", handler);
    }

    public void e0(Handler handler) {
        K1("", this.Z0.getText().toString(), "", handler);
    }

    public void f0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void f1() {
        try {
            this.p1.requestFocus();
            this.D1.setText((CharSequence) null);
            this.A1.setTag(null);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
            Log.d("move_transaction", e.getMessage());
        }
    }

    public void g0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void g1(boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_doc_item_move_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.p1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.from_cus_name);
            this.m1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.to_cus_name);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.r1 = editText;
            this.t1 = editText;
            editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
            EditText editText2 = this.r1;
            editText2.addTextChangedListener(new C2018dE(editText2));
            this.Q = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.u1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
            this.y1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
            this.A1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            this.N1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.z1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_swap);
            this.x1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_close);
            this.D1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.H1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
            this.I1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.J1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
            this.M1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
            if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                this.Q.setVisibility(0);
            } else {
                this.Q.setVisibility(8);
            }
            this.Q.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
            A1(z);
            builder.setCancelable(true);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            this.u1.setOnClickListener(new Q(alertDialogCreate));
            this.y1.setOnClickListener(new R());
            this.z1.setOnClickListener(new S());
            this.x1.setOnClickListener(new T(alertDialogCreate));
            this.A1.setOnClickListener(new U(z));
            alertDialogCreate.getWindow().getAttributes().gravity = 48;
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("move_transaction_error=", ":" + e.getMessage());
        }
    }

    public void h0(View view, boolean z) {
        if (z) {
            t1();
        } else {
            F0();
        }
    }

    public void i0() {
        this.s2 = 3;
        String str = this.n2;
        if (str == null || str.length() < 3) {
            G1(this.k, this.k2, this.n2, this.n);
            return;
        }
        C4064uh c4064uhO0 = this.i.O0(this.k2, this.i0.getText().toString());
        if (C1839c10.m(this.i, this.k)) {
            if (Build.VERSION.SDK_INT < 31) {
                f0();
            }
            j1();
        } else {
            new C3966tX().c(this);
        }
        Z00 z00 = this.i;
        z00.F(this.n2, z00.Dd(c4064uhO0, this.k2, Double.parseDouble(c4064uhO0.v), c4064uhO0.q()), this.k, this.E0 + ".jpg", 0);
    }

    public void j0() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new C());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new E());
        builder.create().show();
    }

    public void j1() {
        String string;
        String string2 = getTitle().toString();
        this.E0 = string2;
        Z00 z00 = this.i;
        ListView listView = this.N;
        String strIc = z00.ic(string2);
        if (this.t0.getText().length() == 0) {
            string = this.p + "";
        } else {
            string = this.t0.getText().toString();
        }
        z00.Ma(listView, strIc, string, this.S.getText().toString(), this.T.getText().toString(), this.u, this.Z.getText().toString(), this.i0.getText().toString());
    }

    /* JADX WARN: Code duplicated, block: B:188:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:191:0x0715  */
    public void k0(int i, int i2) {
        String str;
        String message;
        String str2;
        int i3;
        String str3;
        String str4;
        String string;
        String string2;
        String string3;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String string4;
        String str10;
        try {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return;
            }
            C2160f10.h = MO.b(this);
            if (!u0()) {
                return;
            }
            if ((this.i.q5().getCount() == 0) && (this.p == 0)) {
                this.f0.performClick();
                return;
            }
            Log.d("bill_save=", "tr=" + this.p + ":new_bill=" + this.p2 + ":back_edit=" + this.J);
            String str11 = ":";
            try {
                try {
                    if (this.p != 0) {
                        this.i.t5();
                        str2 = "Error:";
                        int iS5 = this.i.s5(this.u, -3, this.T.getText().toString());
                        this.t0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + iS5);
                        if (this.t0.getText().toString().length() > 0 && this.i.w5(this.t0.getText().toString(), this.u, this.p, this.t, this.T.getText().toString()) > 0) {
                            this.t0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                            return;
                        }
                        E0();
                        double dG5 = this.i.g5();
                        StringBuilder sb = new StringBuilder();
                        sb.append("update tr_p_temps set p_amount='");
                        sb.append(this.X.getText().toString().replaceAll(",", ""));
                        sb.append("',p_remarks='");
                        sb.append(this.u0.getText().toString());
                        sb.append("',p_ref_no='");
                        sb.append((this.t0.getText() == null || this.t0.getText().toString().length() != 0) ? this.t0.getText().toString() : Integer.valueOf(iS5));
                        sb.append("',p_date='");
                        sb.append(this.S.getText().toString());
                        sb.append("'");
                        if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                            str8 = "";
                        } else {
                            str8 = ",date_='" + this.S.getText().toString() + "'";
                        }
                        sb.append(str8);
                        sb.append(",bill_id=-3,tr_type=");
                        sb.append(this.u);
                        sb.append(",cash_id=(select id from customers where name='");
                        sb.append(this.T.getText().toString());
                        sb.append("') where p_id=");
                        sb.append(this.p);
                        string = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("delete from transactions where p_id=");
                        sb2.append(this.p);
                        sb2.append(" and p_id<>0 and bill_id=-3 and p_date='");
                        sb2.append(this.q);
                        sb2.append("'");
                        str5 = "0";
                        if (this.t.equals(str5)) {
                            str9 = " ";
                        } else {
                            str9 = " and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + this.t + "' ";
                        }
                        sb2.append(str9);
                        string2 = sb2.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("insert into transactions(p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,tr_type,cash_id,curr_mod ,param1,param2,online,user_id,online_ref)select p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,tr_type,cash_id,curr_mod ,param1,param2 ,");
                        sb3.append(str5);
                        sb3.append(",");
                        int i4 = C2160f10.h;
                        sb3.append(i4 == -1 ? "null" : Integer.valueOf(i4));
                        sb3.append(",");
                        if (this.t.equals(str5)) {
                            string4 = " 0 ";
                            str7 = ":";
                        } else {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("'");
                            str7 = ":";
                            sb4.append(this.t.replace(str7, ""));
                            sb4.append("'");
                            string4 = sb4.toString();
                        }
                        sb3.append(string4);
                        sb3.append(" from tr_p_temps where p_id= ");
                        sb3.append(this.p);
                        String string5 = sb3.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("insert into transactions(p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,tr_type,cash_id,curr_mod,param2,online,user_id,online_ref)select p_id,p_amount,p_remarks,p_ref_no,cash_id,t_cus_id,'");
                        sb5.append(dG5);
                        sb5.append("',in_*-1,p_curr_id,p_curr_id,bill_id,'");
                        sb5.append(this.i.V8(this.u));
                        sb5.append("'||(case when p_remarks=null or p_remarks='' then '' else '/'||p_remarks end)||'#'||p_ref_no,date_,p_date,p_curr_price,p_curr_price,tr_type,cash_id,curr_mod,param2  ,");
                        sb5.append(str5);
                        sb5.append(",");
                        int i5 = C2160f10.h;
                        sb5.append(i5 != -1 ? Integer.valueOf(i5) : "null");
                        sb5.append(",");
                        if (this.t.equals(str5)) {
                            str10 = " 0 ";
                        } else {
                            str10 = "'" + this.t.replace(str7, "") + "'";
                        }
                        sb5.append(str10);
                        sb5.append(" from tr_p_temps order by p_id desc limit 1");
                        String string6 = sb5.toString();
                        String strN = this.i.N(string, string2, string5, string6);
                        if (strN != null && strN.equals("1")) {
                            this.p2 = false;
                            str6 = string6;
                            string3 = string5;
                        }
                        StringBuilder sb6 = new StringBuilder();
                        str = str2;
                        try {
                            sb6.append(str);
                            if (strN != null && strN.length() > 20) {
                                strN = strN.substring(0, 20);
                            }
                            sb6.append(strN);
                            Toast.makeText(this, sb6.toString(), 0).show();
                            return;
                        } catch (Exception e) {
                            e = e;
                            Log.d("bill_save_error", e.getMessage() + "");
                            e.printStackTrace();
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(str);
                            if (e.getMessage() != null) {
                                message = e.getMessage();
                            } else {
                                message = e.getMessage();
                            }
                            sb7.append(message);
                            Toast.makeText(this, sb7.toString(), 1).show();
                        }
                    }
                    try {
                        int iT5 = this.i.t5();
                        str2 = "Error:";
                        try {
                            int iS6 = this.i.s5(this.u, -3, this.T.getText().toString());
                            this.t0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + iS6);
                            if (this.t0.getText().toString().length() > 0 && this.i.v5(this.t0.getText().toString(), this.u, this.p, this.T.getText().toString()) > 0) {
                                this.t0.setError(getString(info.aalmoghalis.inventory.R.string.doc_no_error));
                                return;
                            }
                            E0();
                            double dG6 = this.i.g5();
                            if (this.i.S()) {
                                i3 = Integer.parseInt(this.i.X4("select count(*) as _id from tr_p_temps where p_id=" + iT5));
                            } else {
                                i3 = 1;
                            }
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("update tr_p_temps set p_id='");
                            sb8.append(iT5);
                            sb8.append("',p_amount='");
                            sb8.append(this.X.getText().toString().replaceAll(",", ""));
                            sb8.append("',p_remarks='");
                            sb8.append(this.u0.getText().toString());
                            sb8.append("',p_ref_no='");
                            sb8.append((this.t0.getText() == null || this.t0.getText().toString().length() != 0) ? this.t0.getText().toString() : Integer.valueOf(iS6));
                            sb8.append("',p_date='");
                            sb8.append(this.S.getText().toString());
                            sb8.append("'");
                            if (this.i.ja("prefOthers_trans_diff_dates", false)) {
                                str3 = "";
                            } else {
                                str3 = ",date_='" + this.S.getText().toString() + "'";
                            }
                            sb8.append(str3);
                            sb8.append(",bill_id=-3,tr_type=");
                            sb8.append(this.u);
                            sb8.append(",cash_id=(select id from customers where name='");
                            sb8.append(this.T.getText().toString());
                            sb8.append("')");
                            if (i3 == 0) {
                                str4 = " ";
                            } else {
                                str4 = " where p_id=" + iT5;
                            }
                            sb8.append(str4);
                            string = sb8.toString();
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append("insert into transactions(p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,tr_type,cash_id,curr_mod ,param1,param2,online,user_id)select p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,tr_type,cash_id,curr_mod ,param1,param2 ,");
                            sb9.append("0");
                            sb9.append(",");
                            int i6 = C2160f10.h;
                            sb9.append(i6 == -1 ? "null" : Integer.valueOf(i6));
                            sb9.append(" from tr_p_temps ");
                            string2 = sb9.toString();
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append("insert into transactions(p_id,p_amount,p_remarks,p_ref_no,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,date_,p_date,curr_price,p_curr_price,tr_type,cash_id,curr_mod,param2,online,user_id )select p_id,p_amount,p_remarks,p_ref_no,cash_id,t_cus_id,'");
                            sb10.append(dG6);
                            sb10.append("',in_*-1,p_curr_id,p_curr_id,bill_id,'");
                            sb10.append(this.i.V8(this.u));
                            sb10.append("'||(case when p_remarks=null or p_remarks='' then '' else '/'||p_remarks end)||'#'||p_ref_no,date_,p_date,p_curr_price,p_curr_price,tr_type,cash_id,curr_mod,param2  ,");
                            sb10.append("0");
                            sb10.append(",");
                            int i7 = C2160f10.h;
                            sb10.append(i7 != -1 ? Integer.valueOf(i7) : "null");
                            sb10.append(" from tr_p_temps order by p_id desc limit 1 ");
                            string3 = sb10.toString();
                            String strM = this.i.M(string, string2, string3);
                            if (strM != null && strM.equals("1")) {
                                this.p2 = true;
                                this.p = iT5;
                                this.q = this.S.getText().toString();
                                this.t = "0";
                                this.i.S();
                                q1();
                                str5 = "0";
                                str6 = "";
                                str7 = ":";
                            }
                            StringBuilder sb11 = new StringBuilder();
                            sb11.append(str2);
                            if (strM != null && strM.length() > 20) {
                                strM = strM.substring(0, 20);
                            }
                            sb11.append(strM);
                            Toast.makeText(this, sb11.toString(), 0).show();
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            str11 = str2;
                            str = str11;
                            Log.d("bill_save_error", e.getMessage() + "");
                            e.printStackTrace();
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append(str);
                            if (e.getMessage() != null) {
                                message = e.getMessage();
                            } else {
                                message = e.getMessage();
                            }
                            sb12.append(message);
                            Toast.makeText(this, sb12.toString(), 1).show();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str11 = "Error:";
                    }
                    try {
                        new C1839c10(this, this.i).A();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    Log.d("sql1=", string);
                    Log.d("sql2=", string2);
                    Log.d("sql3=", string3);
                    Log.d("sql4=", str6);
                    C0();
                    this.u2 = 0;
                    q1();
                    Log.d("new_bill=", this.p2 + ":back_edit=" + this.J + str7 + this.Z.getText().toString() + str7 + this.N.getAdapter().getCount() + str7 + this.c2 + str7 + this.p);
                    R0(1);
                    if (!this.Z.getText().toString().equals(str5)) {
                        this.u2 = 1;
                        if (!u0()) {
                            return;
                        }
                    }
                    int i8 = this.o2;
                    if (i8 == 1 || i8 == 2) {
                        this.u2 = 0;
                        Bill_edit.P2 = true;
                        this.d2 = false;
                        l1(i8);
                        return;
                    }
                    if (this.d2) {
                        this.u2 = 0;
                        this.d2 = false;
                        Bill_edit.P2 = true;
                        return;
                    }
                    if (this.c2 == 1) {
                        this.c2 = 0;
                        r1();
                        return;
                    }
                    if (!this.p2) {
                        if (this.J != 1) {
                            X0();
                            return;
                        } else {
                            Bill_edit.P2 = true;
                            finish();
                            return;
                        }
                    }
                    if (this.N.getAdapter().getCount() == 1) {
                        this.u2 = 0;
                        Bill_edit.P2 = true;
                        V0(((C0634Jt) this.N.getAdapter().getItem(0)).e());
                        String str12 = this.k2;
                        if (str12 != null) {
                            B1(str12);
                            return;
                        }
                        return;
                    }
                    if (this.N.getAdapter().getCount() > 1) {
                        Log.d("bill_save:", "trace_share_start");
                        new C3966tX().I(this, this.i, this.j, this.p, this.u, 0);
                        Log.d("bill_save:", "trace_share_End");
                    } else if (this.J != 1) {
                        X0();
                    } else {
                        Bill_edit.P2 = true;
                        finish();
                    }
                } catch (Exception e5) {
                    e = e5;
                    str = str2;
                    Log.d("bill_save_error", e.getMessage() + "");
                    e.printStackTrace();
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(str);
                    if (e.getMessage() != null || e.getMessage().length() <= 20) {
                        message = e.getMessage();
                    } else {
                        message = e.getMessage().substring(0, 20);
                    }
                    sb13.append(message);
                    Toast.makeText(this, sb13.toString(), 1).show();
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Exception e7) {
            e = e7;
            str = "Error:";
        }
    }

    public void k1(int i) {
        j1();
        if (i == 2) {
            this.i.qd(this.i.ic(this.E0) + ".pdf");
            return;
        }
        if (i == 1) {
            this.i.ra(this.i.ic(this.E0) + ".pdf");
            return;
        }
        if (i == 3) {
            this.i.Hd(this.n2, this.i.ic(this.E0) + ".pdf");
        }
    }

    public boolean l0(int i) {
        int i2;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        if (getIntent().getStringExtra("P_ID") != null || (this.p != 0 && this.q2 == 1)) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "edit")) {
                Context context = this.O0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "new")) {
            Context context2 = this.O0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        int i3 = this.u;
        if (i3 == 6) {
            i2 = 1;
        } else {
            i2 = i3 == 5 ? -1 : 0;
        }
        r0();
        if (!p0()) {
            return false;
        }
        try {
            Log.d("btn_cus_add:", "START");
            if (i2 != 0) {
                int iT5 = this.p;
                if (iT5 == 0) {
                    iT5 = this.i.t5();
                }
                int iR5 = this.i.r5(this.u, -3);
                if (!this.i.ja("prefOthers_trans_diff_dates", false)) {
                    this.Q.setText(this.S.getText().toString());
                }
                if (this.B1.getTag() == null) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into tr_p_temps (cus_id,out,in_,date_,p_date,remarks,now_,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no,tr_type,cash_id,bill_id) values((select b.id from customers as b where b.name='");
                    sb.append(this.p1.getText().toString());
                    sb.append("'),");
                    sb.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append(",");
                    sb.append(i2);
                    sb.append(",'");
                    sb.append(this.Q.getText().toString());
                    sb.append("','");
                    sb.append(this.S.getText().toString());
                    sb.append("','");
                    sb.append(this.C1.getText().toString());
                    sb.append("',strftime('%Y-%m-%d','now'),'");
                    sb.append(this.i.B8());
                    sb.append("',");
                    if (this.j0.getTag() == null) {
                        str3 = "0";
                    } else {
                        str3 = "(select id from currency where name='" + this.j0.getTag().toString() + "'),";
                    }
                    sb.append(str3);
                    if (this.i0.getTag() == null) {
                        str4 = "0";
                    } else {
                        str4 = "(select id from currency where name='" + this.i0.getTag().toString() + "')";
                    }
                    sb.append(str4);
                    sb.append(",");
                    sb.append(iT5);
                    sb.append(",'");
                    sb.append(this.u0.getText().toString());
                    sb.append("','");
                    sb.append((this.t0.getText() == null || this.t0.getText().toString().length() != 0) ? this.t0.getText().toString() : Integer.valueOf(iR5));
                    sb.append("',");
                    sb.append(this.u);
                    sb.append(",(select b.id from customers as b where b.name='");
                    sb.append(this.T.getText().toString());
                    sb.append("') ,-3)");
                    z00.v0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("insert into tr_p_temps (cus_id,out,in_,date_,p_date,remarks,now_,param1,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no,tr_type,cash_id,bill_id) values((select b.id from customers as b where b.name='");
                    sb2.append(this.p1.getText().toString());
                    sb2.append("'),");
                    sb2.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append(",");
                    sb2.append(i2);
                    sb2.append(",'");
                    sb2.append(this.Q.getText().toString());
                    sb2.append("','");
                    sb2.append(this.S.getText().toString());
                    sb2.append("','");
                    sb2.append(this.C1.getText().toString());
                    sb2.append("',strftime('%Y-%m-%d','now'),'");
                    sb2.append(this.B1.getTag().toString());
                    sb2.append("','");
                    sb2.append(this.i.B8());
                    sb2.append("',");
                    if (this.j0.getTag() == null) {
                        str = "0";
                    } else {
                        str = "(select id from currency where name='" + this.j0.getTag().toString() + "'),";
                    }
                    sb2.append(str);
                    if (this.i0.getTag() == null) {
                        str2 = "0";
                    } else {
                        str2 = "(select id from currency where name='" + this.i0.getTag().toString() + "')";
                    }
                    sb2.append(str2);
                    sb2.append(",");
                    sb2.append(iT5);
                    sb2.append(",'");
                    sb2.append(this.u0.getText().toString());
                    sb2.append("','");
                    sb2.append((this.t0.getText() == null || this.t0.getText().toString().length() != 0) ? this.t0.getText().toString() : Integer.valueOf(iR5));
                    sb2.append("',");
                    sb2.append(this.u);
                    sb2.append(",(select b.id from customers as b where b.name='");
                    sb2.append(this.T.getText().toString());
                    sb2.append("') ,-3)");
                    z01.v0(sb2.toString());
                }
                this.i.v0("update tr_p_temps set remarks=ifnull(p_remarks,'') where ( remarks is NULL or remarks='')");
                this.V0.setText((CharSequence) null);
                this.r1.setText((CharSequence) null);
                s1(this.B1);
                this.D1.setText((CharSequence) null);
                this.r1.requestFocus();
                try {
                    FragmentStatePagerSupport_Main.a0 = true;
                    z = true;
                } catch (Exception e) {
                    e = e;
                    z = true;
                    e.printStackTrace();
                }
            } else {
                z = false;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        return z;
    }

    public void l1(int i) {
        if (i == 0) {
            return;
        }
        this.E0 = getTitle().toString();
        if (this.o2 != 1) {
            this.o2 = 0;
            k1(2);
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                f0();
            }
            this.o2 = 0;
            k1(1);
        }
    }

    public boolean m0() {
        String str;
        String str2;
        String str3;
        String str4;
        s0();
        if (q0()) {
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
                if (this.A1.getTag() == null) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into tr_p_temps (cus_id,t_cus_id,out,in_,date_,p_date,remarks,now_,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no) values((select b.id from customers as b where b.name='");
                    sb.append(this.p1.getText().toString());
                    sb.append("'),(select b.id from customers as b where b.name='");
                    sb.append(this.m1.getText().toString());
                    sb.append("'),");
                    sb.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append(",");
                    sb.append(1);
                    sb.append(",'");
                    sb.append(this.Q.getText().toString());
                    sb.append("','");
                    sb.append(this.S.getText().toString());
                    sb.append("','");
                    sb.append(this.D1.getText().toString());
                    sb.append("',strftime('%Y-%m-%d','now'),'");
                    sb.append(this.i.B8());
                    sb.append("',");
                    if (this.i0.getTag() == null) {
                        str3 = "0";
                    } else {
                        str3 = "(select id from currency where name='" + this.i0.getTag().toString() + "'),";
                    }
                    sb.append(str3);
                    if (this.i0.getTag() == null) {
                        str4 = "0";
                    } else {
                        str4 = "(select id from currency where name='" + this.i0.getTag().toString() + "')";
                    }
                    sb.append(str4);
                    sb.append(",");
                    sb.append(iT5);
                    sb.append(",'");
                    sb.append(this.u0.getText().toString());
                    sb.append("','");
                    sb.append((this.t0.getText() == null || this.t0.getText().toString().length() != 0) ? this.t0.getText().toString() : Integer.valueOf(iR5));
                    sb.append("' )");
                    z00.v0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("insert into tr_p_temps (cus_id,t_cus_id,out,[in],date_,p_date,remarks,now_,param1,param2,curr_id,p_curr_id,p_id,p_remarks,p_ref_no) values((select b.id from customers as b where b.name='");
                    sb2.append(this.p1.getText().toString());
                    sb2.append("'),(select b.id from customers as b where b.name='");
                    sb2.append(this.m1.getText().toString());
                    sb2.append("'),");
                    sb2.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append(",");
                    sb2.append(1);
                    sb2.append(",'");
                    sb2.append(this.Q.getText().toString());
                    sb2.append("','");
                    sb2.append(this.S.getText().toString());
                    sb2.append("','");
                    sb2.append(this.D1.getText().toString());
                    sb2.append("',strftime('%Y-%m-%d','now'),'");
                    sb2.append(this.A1.getTag().toString());
                    sb2.append("','");
                    sb2.append(this.i.B8());
                    sb2.append("',");
                    if (this.i0.getTag() == null) {
                        str = "0";
                    } else {
                        str = "(select id from currency where name='" + this.i0.getTag().toString() + "'),";
                    }
                    sb2.append(str);
                    if (this.i0.getTag() == null) {
                        str2 = "0";
                    } else {
                        str2 = "(select id from currency where name='" + this.i0.getTag().toString() + "')";
                    }
                    sb2.append(str2);
                    sb2.append(",");
                    sb2.append(iT5);
                    sb2.append(",'");
                    sb2.append(this.u0.getText().toString());
                    sb2.append("','");
                    sb2.append((this.t0.getText() == null || this.t0.getText().toString().length() != 0) ? this.t0.getText().toString() : Integer.valueOf(iT5));
                    sb2.append("' )");
                    z01.v0(sb2.toString());
                }
                this.r1.setText((CharSequence) null);
                s1(this.A1);
                this.D1.setText((CharSequence) null);
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

    public void m1() {
        this.t0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + this.i.s5(this.u, -3, this.T.getText().toString()));
    }

    public boolean n0() {
        int i;
        boolean z;
        String str;
        String str2;
        boolean z2 = false;
        if (getIntent().getStringExtra("P_ID") != null || (this.p != 0 && this.q2 == 1)) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "edit")) {
                Context context = this.O0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "new")) {
            Context context2 = this.O0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        int i2 = this.u;
        if (i2 == 6) {
            i = 1;
        } else {
            i = i2 == 5 ? -1 : 0;
        }
        r0();
        if (!t0()) {
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
            if (this.u1.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                String str3 = "0";
                if (this.A1.getTag() == null) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update tr_p_temps set out='");
                    sb.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',in_='");
                    sb.append(i);
                    sb.append("',date_='");
                    sb.append(this.Q.getText().toString());
                    sb.append("',p_date='");
                    sb.append(this.S.getText().toString());
                    sb.append("',cus_id=(select b.id from customers as b where b.name='");
                    sb.append(this.p1.getText().toString());
                    sb.append("'),remarks='");
                    sb.append(this.D1.getText().toString());
                    sb.append("',param1='',curr_id=");
                    if (this.j0.getTag() == null) {
                        str2 = "0";
                    } else {
                        str2 = "(select id from currency where name='" + this.j0.getTag().toString() + "')";
                    }
                    sb.append(str2);
                    sb.append(",p_curr_id=");
                    if (this.i0.getText() != null) {
                        str3 = "(select id from currency where name='" + this.i0.getText().toString() + "')";
                    }
                    sb.append(str3);
                    sb.append(",tr_type=");
                    sb.append(this.u);
                    sb.append(",cash_id=(select b.id from customers as b where b.name='");
                    sb.append(this.T.getText().toString());
                    sb.append("') where no_='");
                    sb.append(this.H);
                    sb.append("'");
                    z00.v0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("update tr_p_temps set out='");
                    sb2.append(this.r1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',in_='");
                    sb2.append(i);
                    sb2.append("',date_='");
                    sb2.append(this.Q.getText().toString());
                    sb2.append("',p_date='");
                    sb2.append(this.S.getText().toString());
                    sb2.append("',remarks='");
                    sb2.append(this.D1.getText().toString());
                    sb2.append("',param1='");
                    sb2.append(this.A1.getTag().toString());
                    sb2.append("',cus_id=(select b.id from customers as b where b.name='");
                    sb2.append(this.p1.getText().toString());
                    sb2.append("'),curr_id=");
                    if (this.j0.getTag() == null) {
                        str = "0";
                    } else {
                        str = "(select id from currency where name='" + this.j0.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(",p_curr_id=");
                    if (this.i0.getText() != null) {
                        str3 = "(select id from currency where name='" + this.i0.getText().toString() + "')";
                    }
                    sb2.append(str3);
                    sb2.append(",tr_type=");
                    sb2.append(this.u);
                    sb2.append(",cash_id=(select b.id from customers as b where b.name='");
                    sb2.append(this.T.getText().toString());
                    sb2.append("') where no_='");
                    sb2.append(this.H);
                    sb2.append("'");
                    z01.v0(sb2.toString());
                }
                this.i.v0("update tr_p_temps set remarks=ifnull(p_remarks,'') where ( remarks is NULL or remarks='')");
                s1(this.A1);
                this.u1.setText(getString(info.aalmoghalis.inventory.R.string.btn_add));
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

    public void n1() {
        if (this.i.ja("f_name_lock", false)) {
            AutoCompleteTextView autoCompleteTextView = this.p1;
            autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_lock), (Drawable) null);
            this.p1.dismissDropDown();
        } else {
            AutoCompleteTextView autoCompleteTextView2 = this.p1;
            autoCompleteTextView2.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView2.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_idle_lock), (Drawable) null);
            this.p1.dismissDropDown();
        }
        if (this.i.ja("t_name_lock", false)) {
            AutoCompleteTextView autoCompleteTextView3 = this.m1;
            autoCompleteTextView3.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView3.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_lock), (Drawable) null);
            this.m1.dismissDropDown();
        } else {
            AutoCompleteTextView autoCompleteTextView4 = this.m1;
            autoCompleteTextView4.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView4.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_idle_lock), (Drawable) null);
            this.m1.dismissDropDown();
        }
    }

    public void o1() {
        this.y0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.K4(this.p1.getText().toString(), this.m1.getText().toString()));
        if (this.D1.getText().toString().length() > 0) {
            this.n1 = this.i.G8(this.p1.getText().toString(), this.m1.getText().toString(), CSS.Value.PERCENTAGE + this.D1.getText().toString() + CSS.Value.PERCENTAGE);
        } else {
            this.n1 = this.i.F8(this.p1.getText().toString(), this.m1.getText().toString());
        }
        this.j1 = new C3962tT(this, android.R.layout.simple_dropdown_item_1line, this.n1);
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
                        this.s1.setText(string);
                        cursorQuery.close();
                        Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                    }
                } else if (i == this.g2 && intent != null) {
                    i1(intent.getData(), false);
                } else if (i == this.f2) {
                    h1(intent);
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
        Log.d("onback=", this.u2 + ":" + this.J + ":" + Bill_edit.P2);
        if (getIntent().getStringExtra("P_ID") != null || (this.p != 0 && this.q2 == 1)) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "edit")) {
                this.u2 = 0;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "new")) {
            Context context = this.O0;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            this.u2 = 0;
        }
        if (this.u2 == 1) {
            this.t2 = 1;
            z0();
        } else if (this.J != 1 || this.p == 0) {
            X0();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_doc_edit5);
        setTitle(getString(info.aalmoghalis.inventory.R.string.doc_title));
        this.i = new Z00(this.h, this);
        this.j = new E00(this);
        this.i.v0("delete from tr_p_temps");
        W0();
        if (this.p != 0) {
            setContentView(info.aalmoghalis.inventory.R.layout.content_doc_det5);
        }
        this.F0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_header);
        this.G0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_footer);
        this.H0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_item_header);
        this.N = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        this.P = (SwitchCompat) findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
        this.S = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_date);
        this.W = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name);
        TextView textView = (TextView) findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
        this.s0 = textView;
        textView.setText(this.i.V8(this.u));
        this.X = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot);
        this.Y = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot2);
        this.Z = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot3);
        this.a0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.count);
        this.d0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr);
        this.f0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_add);
        ImageView imageView = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img_fwd_amount);
        this.g0 = imageView;
        imageView.setOnClickListener(this.i1);
        ImageView imageView2 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img_u_currency);
        this.h0 = imageView2;
        imageView2.setVisibility(8);
        this.h0.setOnClickListener(this.i1);
        this.t0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_no);
        this.u0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
        this.i.dd(this, this.t0);
        this.i.dd(this, this.u0);
        this.p0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.root_layout);
        this.q0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.item_add_hdr);
        this.r0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_items_list_hdr);
        this.o0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.page_add);
        this.i0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_curr);
        this.V0 = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        this.V = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.s3());
        this.i0.setText(this.i.l3("0"));
        TextView textView2 = this.i0;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        this.i0.setOnClickListener(new J());
        this.T = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_cash);
        this.U = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.D3());
        TextView textView3 = this.T;
        textView3.setPaintFlags(8 | textView3.getPaintFlags());
        this.T.setText(this.i.B3().j());
        if (C2160f10.h != -1) {
            this.T.setText(this.i.A4(C2160f10.j + ""));
        }
        if (this.p == 0) {
            m1();
        } else {
            this.r0.setVisibility(0);
        }
        this.T.setOnClickListener(new P());
        this.N.setOnItemClickListener(new Z());
        this.N.setChoiceMode(3);
        this.N.setMultiChoiceModeListener(new C2792a0());
        this.P.setOnCheckedChangeListener(new C2808i0());
        Calendar calendar = Calendar.getInstance();
        this.S.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
        this.K = calendar.get(1);
        this.L = calendar.get(2);
        this.M = calendar.get(5);
        this.S.setOnClickListener(new ViewOnClickListenerC2830t0());
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
                this.s0.setText(this.i.V8(this.u));
                setTitle(getString(info.aalmoghalis.inventory.R.string.doc_title) + " " + this.s0.getText().toString());
                this.i.v0("delete from items_temp");
            }
        } catch (Exception unused2) {
        }
        try {
            if (getIntent().getIntExtra("doc_tr_type", 0) != 0) {
                int intExtra = getIntent().getIntExtra("doc_tr_type", 5);
                this.u = intExtra;
                this.s0.setText(this.i.V8(intExtra));
                if (this.u == 5) {
                    this.P.setChecked(false);
                } else {
                    this.P.setChecked(true);
                }
            }
        } catch (Exception unused3) {
        }
        if (this.p == 0) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        W0();
        R0(1);
        L1();
        C0();
        this.u0.addTextChangedListener(this.K0);
        this.u0.setOnClickListener(new B0());
        this.t0.addTextChangedListener(this.K0);
        this.t0.setOnClickListener(new M0());
        if (getIntent().getStringExtra("P_ID") != null && C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "edit")) {
            this.S.setEnabled(false);
            this.t0.setEnabled(false);
            this.i0.setEnabled(false);
            this.T.setEnabled(false);
            this.P.setEnabled(false);
            this.u0.setEnabled(false);
        }
        if (C2160f10.h > 0) {
            this.T.setEnabled(false);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(a1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.Y1, this.K, this.L, this.M);
        }
        if (i == 4) {
            return new DatePickerDialog(a1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.Z1, this.K, this.L, this.M);
        }
        if (i != 5) {
            return null;
        }
        return new DatePickerDialog(a1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.a2, this.K, this.L, this.M);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_doc_5, menu);
        int i = C2160f10.h;
        if (i <= 0 || this.p == 0) {
            if (i <= 0 || this.p != 0) {
                return true;
            }
            menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(new C2160f10(this.i).l("-8", HTML.Tag.DEL));
            return true;
        }
        MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
        MenuItem menuItemFindItem2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
        MenuItem menuItemFindItem3 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_new);
        boolean zL = new C2160f10(this.i).l("-8", "edit");
        boolean zL2 = new C2160f10(this.i).l("-8", "new");
        boolean zL3 = new C2160f10(this.i).l("-8", HTML.Tag.DEL);
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
        I0(this.i.L2());
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
        Log.d("bill_save=", "item selected:" + this.p);
        if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_save) {
            Log.d("bill_save=", "Please save:" + this.p);
            if (this.i.ja("prefOthers_closed_year", false)) {
                return true;
            }
            k0(2, this.u);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_submit) {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return true;
            }
            k0(2, this.u);
            this.p2 = false;
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_remove) {
            if (this.i.ja("prefOthers_closed_year", false)) {
                return true;
            }
            j0();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_new) {
            if (this.u2 == 1) {
                this.t2 = 0;
                this.c2 = 1;
                k0(2, this.u);
            } else {
                r1();
            }
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.share) {
            this.q2 = 1;
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin) {
                this.o2 = 1;
            } else {
                this.o2 = 2;
            }
            if (this.p == 0 && this.u2 == 1) {
                z0();
                return true;
            }
            if (this.u2 == 1) {
                this.t2 = 0;
                this.d2 = true;
                k0(2, this.u);
            }
            l1(this.o2);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.menu_sms || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.menu_whats) {
            this.q2 = 1;
            if (this.u2 == 1) {
                this.t2 = 0;
                this.d2 = true;
                k0(2, this.u);
            }
            if (this.p != 0) {
                new C3966tX().I(this, this.i, this.j, this.p, this.u, menuItem.getItemId());
            }
        } else {
            if (menuItem.getItemId() == 16908332) {
                onBackPressed();
                return true;
            }
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.printing) {
                this.q2 = 1;
                Log.d("thermal=", this.p + ":" + this.u2 + ":" + this.J);
                if (this.u2 == 1) {
                    this.t2 = 0;
                    this.d2 = true;
                    k0(2, this.u);
                }
                Intent intent = new Intent(this, (Class<?>) (this.i.ja("prefThermalBluetooth", true) ? MainActivity.class : MainActivity2.class));
                intent.putExtra("TR_ID", this.p + "");
                intent.putExtra("cash_id", this.i.p4(this.T.getText().toString()));
                Z00.j0.clear();
                Z00.j0.add(new String[]{this.p + "", this.q, this.t});
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
            if (this.i0.getTag().toString().equals(radioButton.getText().toString())) {
                this.i0.setTag(radioButton.getText().toString());
                R0(2);
            } else {
                this.i0.setTag(radioButton.getText().toString());
                J1();
                this.P0 = 1;
                this.u2 = 1;
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

    public void p1() {
        this.p1.setThreshold(1);
        this.m1.setThreshold(1);
        this.D1.setThreshold(1);
        this.p1.setAdapter(this.y0);
        this.m1.setAdapter(this.y0);
        J0(this.n1);
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void q1() {
        String str;
        this.i.v0("delete from tr_p_temps");
        if (this.p != 0) {
            Log.d("refresh_items_temp=", this.p + ":" + this.t);
            Z00 z00 = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append("insert into tr_p_temps(p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,in_,curr_id,p_curr_id,bill_id,remarks,no_,tr_type,cash_id,curr_price,p_curr_price,curr_mod ,param1,param2) select  p_id,p_amount,date_,p_date,p_remarks,p_ref_no ,cus_id,t_cus_id,out,[in],curr_id,p_curr_id,bill_id,remarks,id,tr_type,cash_id,curr_price,p_curr_price,curr_mod  ,param1,param2 from transactions_v where p_id='");
            sb.append(this.p);
            sb.append("' and bill_id=-3 ");
            if (this.t.equals("0")) {
                str = " ";
            } else {
                str = " and ifnull(substr( online_ref2, instr(online_ref2, ':')),'0')='" + this.t + "' ";
            }
            sb.append(str);
            z00.v0(sb.toString());
        }
    }

    public void r1() {
        this.p = 0;
        this.q2 = 0;
        q1();
        if (this.J == 1) {
            Bill_edit.P2 = true;
        }
        this.t0.setText("");
        this.u0.setText("");
        R0(3);
        m1();
        this.V0.requestFocus();
        this.X.setText("0");
        this.Y.setText("0");
        this.Z.setText("0");
    }

    public void u1(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            if (this.b2) {
                this.B1.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.B1.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.B1.setImageBitmap(bitmapP0);
                this.B1.setTag(str);
            } else {
                this.A1.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.A1.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.A1.setImageBitmap(bitmapP0);
                this.A1.setTag(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u_currency_btn(View view) {
        if (getIntent().getStringExtra("P_ID") != null || (this.p != 0 && this.q2 == 1)) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "edit")) {
                Context context = this.O0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("-8", "new")) {
            Context context2 = this.O0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        this.i.me("-3", this, this.l0, new O(), "0");
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        R0(2);
        this.u2 = 1;
    }

    public void v0() {
        this.i.D = false;
        if (this.i0.getTag() == null || this.i0.getTag().toString().equals(this.i.l3("0")) || this.i.Z2(this.i0.getTag().toString(), this.i.cc(this.S.getText().toString())) != 0) {
            return;
        }
        this.i.u(this, this.i0.getTag().toString(), this.i.cc(this.S.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    public void v1() {
        this.p1.setOnItemClickListener(new C2816m0());
    }

    public void w0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        autoCompleteTextView.setText("");
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new R0(autoCompleteTextView, dialog, editText));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    public void w1() {
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
        listView.setOnItemClickListener(new I(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        listView.setDividerHeight(0);
        linearLayout.addView(listView, -1, -1);
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void x0(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new S0(textView, arrayAdapter, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void x1(boolean z) {
        H0(z);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.b2 = z;
        if (!z) {
            this.J1.setVisibility(8);
            this.L1.setVisibility(8);
            this.H1.setVisibility(8);
            this.I1.setVisibility(0);
            this.O1.setVisibility(0);
            this.D1.setThreshold(1);
            this.A1.setOnClickListener(new ViewOnClickListenerC2813l(z));
            return;
        }
        this.H1.setVisibility(8);
        this.I1.setVisibility(8);
        this.O1.setVisibility(8);
        this.J1.setVisibility(0);
        this.L1.setVisibility(0);
        this.C1.setThreshold(1);
        this.K = calendar.get(1);
        this.L = calendar.get(2);
        this.M = calendar.get(5);
        this.B1.setOnClickListener(new ViewOnClickListenerC2809j(z));
        int i = v2;
        if ((i == 3 || i == 1) && i == 3) {
            this.p1.setText("");
            s1(this.A1);
            this.C1.setText((CharSequence) null);
            this.p1.requestFocus();
        }
    }

    public void y0() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.L0();
            }
            g0();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void y1(int i, String str, String str2) {
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

    public void z0() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_save));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2815m());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2817n());
        builder.create().show();
    }
}
