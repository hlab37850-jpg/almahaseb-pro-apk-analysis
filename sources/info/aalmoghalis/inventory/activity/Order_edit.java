package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
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
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.timepicker.TimeModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
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
import defpackage.MO;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
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

/* JADX INFO: loaded from: classes3.dex */
public class Order_edit extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static int s2 = 0;
    public static boolean t2 = false;
    public static boolean u2 = false;
    public static String v2 = "";
    public TextView A1;
    public SparseBooleanArray B0;
    public TextView B1;
    public ArrayAdapter C0;
    public ArrayAdapter D0;
    public ArrayAdapter E0;
    public ArrayAdapter F0;
    public boolean I1;
    public TextView J1;
    public int K;
    public TextView K1;
    public int L;
    public TextView L1;
    public int M;
    public SwitchCompat M1;
    public boolean O1;
    public boolean P1;
    public SearchView S1;
    public String Y1;
    public TextView a0;
    public TextView b0;
    public TextView c0;
    public TextView d0;
    public Uri d2;
    public TextView e0;
    public ArrayAdapter f0;
    public SQLiteDatabase h;
    public Z00 i;
    public EditText i2;
    public String j;
    public List j2;
    public String k;
    public C4062ug k2;
    public String l;
    public LinearLayout r0;
    public LinearLayout s0;
    public LinearLayout t0;
    public C0809Ov x0;
    public C1098Yv y0;
    public int n = 0;
    public int p = 0;
    public int q = 2;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public String w = null;
    public String x = null;
    public String y = null;
    public String z = null;
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = "1";
    public String E = null;
    public String F = null;
    public String G = "0";
    public int H = 0;
    public int I = 0;
    public boolean J = false;
    public ListView N = null;
    public Toolbar O = null;
    public SwitchCompat P = null;
    public CheckBox Q = null;
    public TextView R = null;
    public TextView S = null;
    public TextView T = null;
    public TextView U = null;
    public AutoCompleteTextView V = null;
    public TextView W = null;
    public TextView X = null;
    public TextView Y = null;
    public TextView Z = null;
    public LinearLayout g0 = null;
    public TextView h0 = null;
    public ImageView i0 = null;
    public ImageView j0 = null;
    public ImageView k0 = null;
    public ImageView l0 = null;
    public TextView m0 = null;
    public TextView n0 = null;
    public ArrayList o0 = new ArrayList();
    public ArrayList p0 = new ArrayList();
    public ImageView q0 = null;
    public TextView u0 = null;
    public EditText v0 = null;
    public EditText w0 = null;
    public List z0 = new ArrayList();
    public List A0 = new ArrayList();
    public ImageButton G0 = null;
    public int H0 = 0;
    public String[] I0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] J0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String K0 = "";
    public LinearLayout L0 = null;
    public LinearLayout M0 = null;
    public LinearLayout N0 = null;
    public ImageView O0 = null;
    public boolean P0 = false;
    public TextWatcher Q0 = new Q();
    public boolean R0 = false;
    public TextWatcher S0 = new R();
    public TextWatcher T0 = new S();
    public int U0 = 0;
    public int V0 = 0;
    public int W0 = 0;
    public String X0 = "";
    public int Y0 = 0;
    public String Z0 = "";
    public String a1 = "";
    public final Context b1 = this;
    public int c1 = 0;
    public int d1 = 0;
    public String e1 = "";
    public String f1 = "";
    public EditText g1 = null;
    public EditText h1 = null;
    public TextView i1 = null;
    public AutoCompleteTextView j1 = null;
    public EditText k1 = null;
    public EditText l1 = null;
    public AutoCompleteTextView m1 = null;
    public EditText n1 = null;
    public AutoCompleteTextView o1 = null;
    public TextView p1 = null;
    public EditText q1 = null;
    public EditText r1 = null;
    public EditText s1 = null;
    public TextView t1 = null;
    public AutoCompleteTextView u1 = null;
    public int v1 = 0;
    public TextView w1 = null;
    public TextView x1 = null;
    public ImageView y1 = null;
    public boolean z1 = false;
    public double C1 = 0.0d;
    public double D1 = 0.0d;
    public int E1 = 0;
    public double F1 = 0.0d;
    public double G1 = 0.0d;
    public double H1 = 0.0d;
    public int N1 = 1;
    public String Q1 = "";
    public String R1 = "0";
    public DatePickerDialog.OnDateSetListener T1 = new C2996i();
    public DatePickerDialog.OnDateSetListener U1 = new C2998j();
    public DatePickerDialog.OnDateSetListener V1 = new C3002l();
    public View.OnClickListener W1 = new ViewOnClickListenerC3012q();
    public boolean X1 = false;
    public int Z1 = 3;
    public int a2 = 4;
    public ActivityResultLauncher b2 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: YE
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.j1((Uri) obj);
        }
    });
    public ActivityResultLauncher c2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new B());
    public String e2 = null;
    public String f2 = null;
    public String g2 = null;
    public String h2 = null;
    public int l2 = 0;
    public boolean m2 = false;
    public int[] n2 = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public int o2 = 0;
    public int p2 = 0;
    public int q2 = 0;
    public int r2 = 0;

    public class A implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public A(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Order_edit.this);
                if (this.a[i].equals(Order_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Order_edit order_edit = Order_edit.this;
                    order_edit.Y1 = order_edit.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Order_edit.this.u0();
                    }
                } else if (this.a[i].equals(Order_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Order_edit order_edit2 = Order_edit.this;
                    order_edit2.Y1 = order_edit2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Order_edit.this.M0();
                    }
                } else if (this.a[i].equals(Order_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Order_edit.this.i.qa(Z00.M + Order_edit.this.O0.getTag().toString());
                } else if (this.a[i].equals(Order_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Order_edit.this.O0.setTag(null);
                    Order_edit.this.O0.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Order_edit.this.O0.getLayoutParams().width = (int) Order_edit.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Order_edit.this.O0.getLayoutParams().height = (int) Order_edit.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class A0 implements DialogInterface.OnClickListener {
        public A0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class A1 implements DialogInterface.OnClickListener {
        public A1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class B implements ActivityResultCallback {
        public B() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Order_edit.this.K1();
            }
        }
    }

    public class B0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public B0(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Order_edit.this.add_item(this.a);
            } catch (Exception unused) {
            }
        }
    }

    public class B1 implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ Handler e;

        public B1(AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog, String str, EditText editText, Handler handler) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
            this.c = str;
            this.d = editText;
            this.e = handler;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (zA && Order_edit.this.i.P5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Order_edit.this.Q1 = this.a.getText().toString();
                Order_edit order_edit = Order_edit.this;
                order_edit.R0(order_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item), Order_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item) + "#" + Order_edit.this.Q1, this.b.getContext());
                if (!Order_edit.this.O1) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Order_edit.this.i.H("insert into items (name,item_type_id,o_date) values('" + this.d.getText().toString() + "',(select b.id from item_type b where b.name='" + this.a.getText().toString() + "'),'" + Order_edit.this.R.getText().toString() + "' )", "insert into item_price (item_id,curr_id,sls_u_price,unit_id) values((select id from items a where a.name='" + this.d.getText().toString() + "'),(select b.id from currency b where b.name='" + Order_edit.this.m0.getText().toString() + "'),'0' ,0)");
                    Order_edit order_edit2 = Order_edit.this;
                    order_edit2.N1 = 0;
                    order_edit2.I1 = true;
                    Order_edit.this.j1.setText(this.d.getText().toString());
                    Handler handler = this.e;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    public class C extends Handler {
        public C() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class C0 implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ AlertDialog c;

        public C0(AutoCompleteTextView autoCompleteTextView, View view, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = view;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Order_edit.this.i.v0("insert into items  (name  ,o_qty  ,item_type_id,o_date_)  values( '" + ((Object) this.a.getText()) + "' ,'0','" + Order_edit.this.d1 + "', strftime('%Y-%m-%d','now') )");
                Order_edit.this.add_item(this.b);
            } catch (Exception unused) {
            }
            this.c.dismiss();
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

    public class D implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public D(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit.this.i.v0("insert into groups  (name )  values( '" + Order_edit.this.Q1 + "'  )");
            Order_edit.this.O1 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class D0 implements AdapterView.OnItemClickListener {
        public D0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                C0634Jt c0634Jt = (C0634Jt) adapterView.getItemAtPosition(i);
                TextView textView = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.no_);
                Order_edit.this.G = textView.getText().toString();
                Order_edit.this.y = c0634Jt.e();
                TextView textView2 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
                Order_edit.this.z = textView2.getText().toString();
                TextView textView3 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_price);
                Order_edit.this.A = textView3.getText().toString();
                TextView textView4 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.item_weight);
                Order_edit.this.E = textView4.getText().toString();
                Order_edit.this.F = c0634Jt.b();
                Order_edit.this.B = c0634Jt.l();
                Order_edit.this.D = c0634Jt.m();
                Order_edit.this.C = c0634Jt.c();
                Order_edit.s2 = 2;
                Order_edit.this.Y1();
            } catch (Exception unused) {
            }
        }
    }

    public class D1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public D1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit.this.i.v0("insert into item_type  (name )  values( '" + Order_edit.this.Q1 + "'  )");
            Order_edit.this.P1 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class E implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public E(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit.this.O1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class E0 implements AbsListView.MultiChoiceModeListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Order_edit.this.I0();
                } catch (Exception unused) {
                    Toast.makeText(Order_edit.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public E0() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId != info.aalmoghalis.inventory.R.id.menu_delete) {
                if (itemId != info.aalmoghalis.inventory.R.id.menu_info) {
                    return false;
                }
                SparseBooleanArray sparseBooleanArrayB = Order_edit.this.x0.b();
                Order_edit order_edit = Order_edit.this;
                order_edit.B0 = sparseBooleanArrayB;
                try {
                    order_edit.X1();
                } catch (Exception unused) {
                    Toast.makeText(Order_edit.this.getApplicationContext(), "SQL Error.", 1);
                }
                actionMode.finish();
                return false;
            }
            SparseBooleanArray sparseBooleanArrayB2 = Order_edit.this.x0.b();
            Order_edit order_edit2 = Order_edit.this;
            order_edit2.B0 = sparseBooleanArrayB2;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(order_edit2);
            builder.setMessage(Order_edit.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
            builder.setPositiveButton(Order_edit.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
            builder.setNegativeButton(Order_edit.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
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
            Order_edit.this.N.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Order_edit.this.x0.j.clear();
            Order_edit.this.x0.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Order_edit.this.N.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Order_edit.this.x0.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
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
            Order_edit.this.P1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class F implements View.OnClickListener {
        public F() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.P0 = true;
        }
    }

    public class F0 implements DialogInterface.OnClickListener {
        public F0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class F1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public F1(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class G implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public G(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class G0 implements DialogInterface.OnClickListener {
        public G0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class G1 implements View.OnTouchListener {
        public G1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Order_edit.this.V.showDropDown();
            if (motionEvent.getAction() == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("x=");
                sb.append(motionEvent.getX());
                sb.append(":bound=");
                sb.append(Order_edit.this.V.getCompoundDrawables()[0] != null ? Order_edit.this.V.getCompoundDrawables()[0].getBounds().width() : 0);
                sb.append(":paddingLeft=");
                sb.append(Order_edit.this.V.getPaddingLeft());
                sb.append(":Left=");
                sb.append(Order_edit.this.V.getLeft());
                sb.append(":getRawX=");
                sb.append(motionEvent.getRawX());
                sb.append(":getTotalPaddingLeft=");
                sb.append(Order_edit.this.V.getTotalPaddingLeft());
                Log.d("clear_action_up:=", sb.toString());
                if (motionEvent.getX() <= Order_edit.this.V.getTotalPaddingLeft()) {
                    Order_edit.this.V.setText("");
                    Order_edit.this.V.requestFocus();
                    Order_edit.this.r2 = 1;
                    return false;
                }
                motionEvent.getX();
                Order_edit.this.V.getRight();
                Order_edit.this.V.getPaddingRight();
                if (Order_edit.this.V.getCompoundDrawables()[2] != null) {
                    Order_edit.this.V.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class H implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public H(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class H0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ RadioButton b;
        public final /* synthetic */ AlertDialog c;

        public H0(EditText editText, RadioButton radioButton, AlertDialog alertDialog) {
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
                    Order_edit.this.E1 = 1;
                } else {
                    Order_edit.this.E1 = 0;
                }
                double d3 = Double.parseDouble(Order_edit.this.W.getText().toString().replace(",", "")) + Double.parseDouble(Order_edit.this.Y.getText().toString().replace(",", ""));
                Order_edit order_edit = Order_edit.this;
                double d4 = order_edit.E1 == 1 ? (d2 / 100.0d) * d3 : d2;
                double d5 = d3 - d4;
                double d6 = (Double.parseDouble(order_edit.a0.getText().toString().replaceAll(",", "")) * d5) / 100.0d;
                double d7 = d5 + d6;
                Order_edit.this.i.v0("update bills2 set amount='" + d7 + "',d_amount= '" + d4 + "',tax_amount= '" + d6 + "',d_val= '" + d2 + "',discount_id= '" + Order_edit.this.E1 + "' where id='" + Order_edit.this.n + "'");
                TextView textView = Order_edit.this.W;
                StringBuilder sb = new StringBuilder();
                sb.append(d7);
                sb.append("");
                textView.setText(sb.toString());
                TextView textView2 = Order_edit.this.Y;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d4);
                sb2.append("");
                textView2.setText(sb2.toString());
                Order_edit.this.D1();
                Order_edit order_edit2 = Order_edit.this;
                order_edit2.C1 = d7;
                order_edit2.U0();
                this.c.dismiss();
                Order_edit order_edit3 = Order_edit.this;
                order_edit3.i.Md(order_edit3);
            }
        }
    }

    public class H1 implements CompoundButton.OnCheckedChangeListener {
        public H1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton == Order_edit.this.Q) {
                Order_edit.this.t1();
                if (z) {
                    Order_edit order_edit = Order_edit.this;
                    if (order_edit.W0 != -1 && order_edit.J) {
                        order_edit.E0();
                        return;
                    }
                }
                Order_edit order_edit2 = Order_edit.this;
                order_edit2.r2 = 1;
                order_edit2.W1();
                Order_edit.this.v1();
            }
        }
    }

    public class I implements View.OnClickListener {
        public I() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.phone_pick_btn(view);
        }
    }

    public class I0 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public I0(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Order_edit order_edit = Order_edit.this;
            order_edit.i.Md(order_edit);
        }
    }

    public class J implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public J(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.z0(this.a, this.b);
        }
    }

    public class J0 implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ RadioButton b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ TextView d;

        public class a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ Dialog a;

            public a(Dialog dialog) {
                this.a = dialog;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                J0.this.a.setText(adapterView.getItemAtPosition(i).toString());
                if (J0.this.b.isChecked() && J0.this.c.getText().toString().length() > 0) {
                    double d = Double.parseDouble(J0.this.c.getText().toString().replaceAll(",", ""));
                    if (d > 100.0d || d < 0.0d) {
                        J0.this.c.setError("% value");
                        return;
                    }
                }
                double d2 = Double.parseDouble(J0.this.c.getText().toString().replaceAll(",", ""));
                boolean zIsChecked = J0.this.b.isChecked();
                double d3 = Double.parseDouble(Order_edit.this.W.getText().toString().replace(",", "")) + Double.parseDouble(Order_edit.this.Y.getText().toString().replace(",", ""));
                if (zIsChecked) {
                    d2 = (d2 / 100.0d) * d3;
                }
                double d4 = (Double.parseDouble(J0.this.a.getText().toString().replaceAll(",", "")) * (d3 - d2)) / 100.0d;
                J0 j0 = J0.this;
                j0.d.setText(Order_edit.this.i.P7(d4 + ""));
                if (d4 > 0.0d) {
                    J0.this.d.setVisibility(0);
                }
                this.a.dismiss();
            }
        }

        public J0(TextView textView, RadioButton radioButton, EditText editText, TextView textView2) {
            this.a = textView;
            this.b = radioButton;
            this.c = editText;
            this.d = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Dialog dialog = new Dialog(Order_edit.this);
            LinearLayout linearLayout = new LinearLayout(Order_edit.this);
            ListView listView = new ListView(Order_edit.this);
            listView.setAdapter((ListAdapter) Order_edit.this.f0);
            listView.setOnItemClickListener(new a(dialog));
            linearLayout.setFocusable(true);
            listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            linearLayout.addView(listView, -1, -1);
            dialog.setContentView(linearLayout);
            dialog.show();
        }
    }

    public class K implements DialogInterface.OnClickListener {
        public K() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class K0 implements DialogInterface.OnClickListener {
        public K0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class L implements DialogInterface.OnClickListener {
        public L() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class L0 implements DialogInterface.OnClickListener {
        public L0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class M implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog d;

        public M(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, androidx.appcompat.app.AlertDialog alertDialog) {
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
            if (zA && Order_edit.this.i.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Order_edit.this.Q1 = this.b.getText().toString();
                Order_edit order_edit = Order_edit.this;
                order_edit.T0(order_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Order_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Order_edit.this.Q1, Order_edit.this);
                if (!Order_edit.this.O1) {
                    return;
                }
            }
            if (zA) {
                Order_edit order_edit2 = Order_edit.this;
                if (order_edit2.e2 != null) {
                    order_edit2.i.v0("update customers set name='" + this.c.getText().toString().trim() + "',gsm='" + this.a.getText().toString() + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id=(select b.id from customers b where b.name='" + this.c.getText().toString() + "')");
                    Order_edit.this.h2 = this.a.getText().toString();
                    Order_edit order_edit3 = Order_edit.this;
                    if (order_edit3.p2 != 2 || order_edit3.P.isChecked()) {
                        Order_edit order_edit4 = Order_edit.this;
                        Z00 z00 = order_edit4.i;
                        z00.Rc(order_edit4.h2, z00.xd(order_edit4.N, Order_edit.this.e2 + "#" + Order_edit.this.m0.getText().toString(), Double.parseDouble(Order_edit.this.W.getText().toString().replaceAll(",", "")), Double.parseDouble(Order_edit.this.Y.getText().toString().replaceAll(",", "")), Order_edit.this.p, Order_edit.this.R.getText().toString()));
                    } else {
                        Order_edit order_edit5 = Order_edit.this;
                        C4064uh c4064uhO0 = order_edit5.i.O0(order_edit5.e2, order_edit5.m0.getText().toString());
                        Order_edit order_edit6 = Order_edit.this;
                        Z00 z01 = order_edit6.i;
                        z01.Rc(order_edit6.h2, z01.zd(c4064uhO0, order_edit6.e2, Double.parseDouble(c4064uhO0.c().replaceAll(",", ""))));
                    }
                }
                this.d.dismiss();
            }
        }
    }

    public class M0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ RadioButton c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ TextView e;
        public final /* synthetic */ AlertDialog f;
        public final /* synthetic */ View g;

        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Order_edit.this.i.x9(this.a);
            }
        }

        public M0(EditText editText, EditText editText2, RadioButton radioButton, EditText editText3, TextView textView, AlertDialog alertDialog, View view) {
            this.a = editText;
            this.b = editText2;
            this.c = radioButton;
            this.d = editText3;
            this.e = textView;
            this.f = alertDialog;
            this.g = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.setText("0");
            this.b.setText("0");
            if (this.c.isChecked() && this.d.getText().toString().length() > 0) {
                double d = Double.parseDouble(this.d.getText().toString().replaceAll(",", ""));
                if (d > 100.0d || d < 0.0d) {
                    this.d.setError("% value");
                    return;
                }
            }
            if (this.d.getText().toString().length() == 0) {
                this.d.setText("0");
                Order_edit.this.E1 = 0;
            }
            if (this.b.getText().toString().length() == 0) {
                this.b.setText("0");
            }
            double d2 = Double.parseDouble(this.d.getText().toString().replaceAll(",", ""));
            if (this.c.isChecked()) {
                Order_edit.this.E1 = 1;
            } else {
                Order_edit.this.E1 = 0;
            }
            double d3 = Double.parseDouble(Order_edit.this.W.getText().toString().replace(",", "")) + Double.parseDouble(Order_edit.this.Y.getText().toString().replace(",", ""));
            double d4 = Order_edit.this.E1 == 1 ? (d2 / 100.0d) * d3 : d2;
            double d5 = d3 - d4;
            double d6 = Double.parseDouble(this.a.getText().toString().replace(",", ""));
            double d7 = (Double.parseDouble(this.e.getText().toString().replaceAll(",", "")) * d5) / 100.0d;
            double d8 = d5 + d7 + d6;
            Order_edit.this.i.v0("update bills2 set amount='" + d8 + "',d_amount= '" + d4 + "',tax_amount= '" + d7 + "',t_val='" + this.e.getText().toString().replaceAll(",", "") + "',d_val= '" + d2 + "',discount_id= '" + Order_edit.this.E1 + "' where id='" + Order_edit.this.n + "'");
            TextView textView = Order_edit.this.W;
            StringBuilder sb = new StringBuilder();
            sb.append(d8 - d6);
            sb.append("");
            textView.setText(sb.toString());
            TextView textView2 = Order_edit.this.Y;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d4);
            sb2.append("");
            textView2.setText(sb2.toString());
            Order_edit.this.D1();
            Order_edit order_edit = Order_edit.this;
            order_edit.C1 = d8;
            order_edit.U0();
            this.f.dismiss();
            View currentFocus = Order_edit.this.getCurrentFocus();
            if (this.g != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    public class N implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public N(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) throws Throwable {
            try {
                Order_edit order_edit = Order_edit.this;
                order_edit.X0(order_edit.V.getText().toString());
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 31) {
                        Order_edit.this.o0();
                    }
                    Order_edit.this.q1();
                    Z00 z00 = Order_edit.this.i;
                    StringBuilder sb = new StringBuilder();
                    Order_edit order_edit2 = Order_edit.this;
                    sb.append(order_edit2.i.ic(order_edit2.K0));
                    sb.append(".pdf");
                    z00.sd(sb.toString());
                    this.a.dismiss();
                } else if (i == 1) {
                    if (Build.VERSION.SDK_INT < 31) {
                        Order_edit.this.o0();
                    }
                    Order_edit.this.p1();
                    Z00 z01 = Order_edit.this.i;
                    StringBuilder sb2 = new StringBuilder();
                    Order_edit order_edit3 = Order_edit.this;
                    sb2.append(order_edit3.i.ic(order_edit3.K0));
                    sb2.append(".xls");
                    z01.pa(sb2.toString());
                    this.a.dismiss();
                } else if (i == 2) {
                    Order_edit order_edit4 = Order_edit.this;
                    order_edit4.X0(order_edit4.V.getText().toString());
                    String str = Order_edit.this.h2;
                    if (str == null || str.length() < 3) {
                        Order_edit order_edit5 = Order_edit.this;
                        String str2 = order_edit5.j;
                        Order_edit order_edit6 = Order_edit.this;
                        order_edit5.M1(str2, order_edit6.e2, order_edit6.h2, order_edit6.f2);
                    } else {
                        Order_edit order_edit7 = Order_edit.this;
                        Z00 z02 = order_edit7.i;
                        z02.Rc(order_edit7.h2, z02.xd(order_edit7.N, Order_edit.this.e2 + "#" + Order_edit.this.m0.getText().toString(), Double.parseDouble(Order_edit.this.W.getText().toString().replaceAll(",", "")), Double.parseDouble(Order_edit.this.Y.getText().toString().replaceAll(",", "")), Order_edit.this.p, Order_edit.this.R.getText().toString()));
                    }
                }
                if (i == 3) {
                    Order_edit order_edit8 = Order_edit.this;
                    order_edit8.o2 = 4;
                    String str3 = order_edit8.h2;
                    if (str3 == null || str3.length() < 3) {
                        Order_edit order_edit9 = Order_edit.this;
                        String str4 = order_edit9.j;
                        Order_edit order_edit10 = Order_edit.this;
                        order_edit9.M1(str4, order_edit10.e2, order_edit10.h2, order_edit10.f2);
                    } else {
                        Order_edit.this.q1();
                        Order_edit order_edit11 = Order_edit.this;
                        Z00 z03 = order_edit11.i;
                        String str5 = order_edit11.h2;
                        StringBuilder sb3 = new StringBuilder();
                        Order_edit order_edit12 = Order_edit.this;
                        sb3.append(order_edit12.i.ic(order_edit12.K0));
                        sb3.append(".pdf");
                        z03.Hd(str5, sb3.toString());
                    }
                }
                this.a.dismiss();
            } catch (Exception e) {
                Log.d("share_err", e.getMessage());
            }
        }
    }

    public class N0 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ View b;

        public class a implements Runnable {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Order_edit.this.i.x9(this.a);
            }
        }

        public N0(AlertDialog alertDialog, View view) {
            this.a = alertDialog;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            View currentFocus = Order_edit.this.getCurrentFocus();
            if (this.b != null) {
                new Handler().postDelayed(new a(currentFocus), 100L);
            }
        }
    }

    public class O implements DialogInterface.OnClickListener {
        public O() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Order_edit.this.i.H("delete from bill_transactions2 where bill_id='" + Order_edit.this.n + "'", "delete from bills2 where id ='" + Order_edit.this.n + "'");
                Order_edit order_edit = Order_edit.this;
                order_edit.X1 = true;
                Bills2.w0 = Bills2.w0 - 1;
                order_edit.b1();
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getApplicationContext(), "SQL Error.", 1).show();
            }
        }
    }

    public class O0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public O0(TextView textView, ImageView imageView) {
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
                Order_edit.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Order_edit.this.n = 0;
                Order_edit.this.U0();
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getApplicationContext(), Order_edit.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class P implements DialogInterface.OnClickListener {
        public P() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class P0 implements DialogInterface.OnClickListener {
        public P0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class Q implements TextWatcher {
        public Q() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Order_edit order_edit = Order_edit.this;
            if (order_edit.P0) {
                order_edit.P0 = false;
            } else {
                order_edit.r2 = 1;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class Q0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public Q0(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Order_edit.this.i.v0("delete from items_temp  where no_=  '" + ((Object) this.a.getText()) + "'");
                    Order_edit order_edit = Order_edit.this;
                    order_edit.c1 = 1;
                    order_edit.U0();
                    Order_edit.this.k1();
                    Order_edit.this.I1(false);
                    Order_edit order_edit2 = Order_edit.this;
                    order_edit2.c1 = 1;
                    order_edit2.H0();
                    Order_edit.this.U0();
                    Order_edit order_edit3 = Order_edit.this;
                    order_edit3.V1(order_edit3.n, "0");
                }
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getApplicationContext(), Order_edit.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    public class R implements TextWatcher {
        public R() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Order_edit order_edit = Order_edit.this;
            if (order_edit.R0) {
                order_edit.R0 = false;
                return;
            }
            if (order_edit.n1.hasFocus()) {
                Order_edit.this.S1(1);
            } else if (Order_edit.this.k1.hasFocus()) {
                Order_edit.this.S1(2);
            } else if (Order_edit.this.l1.hasFocus()) {
                Order_edit.this.S1(3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class R0 implements DialogInterface.OnClickListener {
        public R0() {
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
            Log.d("item_focus=", Order_edit.this.n1.hasFocus() + ":" + Order_edit.this.k1.hasFocus() + ":" + Order_edit.this.l1.hasFocus() + "#" + Order_edit.this.R0);
            Order_edit order_edit = Order_edit.this;
            if (order_edit.R0) {
                order_edit.R0 = false;
                return;
            }
            if (order_edit.s1.hasFocus()) {
                Order_edit.this.T1(1);
            } else if (Order_edit.this.q1.hasFocus()) {
                Order_edit.this.T1(2);
            } else if (Order_edit.this.r1.hasFocus()) {
                Order_edit.this.T1(3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class S0 extends Handler {
        public S0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class T implements Runnable {
        public final /* synthetic */ String a;

        public T(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String string;
            String strD2;
            String string2;
            String string3;
            Order_edit order_edit = Order_edit.this;
            if (order_edit.T.getText().toString() == null) {
                Order_edit order_edit2 = Order_edit.this;
                string = order_edit2.i.C2(order_edit2.k);
            } else {
                string = Order_edit.this.T.getText().toString();
            }
            order_edit.l = string;
            Order_edit order_edit3 = Order_edit.this;
            if (order_edit3.T.getText().toString() == null) {
                strD2 = Order_edit.this.k;
            } else {
                Order_edit order_edit4 = Order_edit.this;
                strD2 = order_edit4.i.D2(order_edit4.T.getText().toString());
            }
            order_edit3.k = strD2;
            if (Order_edit.this.Q.isChecked()) {
                Order_edit order_edit5 = Order_edit.this;
                if (order_edit5.J) {
                    Z00 z00 = order_edit5.i;
                    String strValueOf = String.valueOf(order_edit5.V0);
                    String str = this.a;
                    if (Order_edit.this.T.getText().toString() == null) {
                        Order_edit order_edit6 = Order_edit.this;
                        string3 = order_edit6.i.C2(order_edit6.k);
                    } else {
                        string3 = Order_edit.this.T.getText().toString();
                    }
                    order_edit5.p0 = z00.p7(strValueOf, str, string3, false);
                    return;
                }
            }
            if (Order_edit.this.p == 1 && Order_edit.this.Q.isChecked()) {
                Order_edit order_edit7 = Order_edit.this;
                if (!order_edit7.J) {
                    order_edit7.p0 = order_edit7.i.o7(String.valueOf(order_edit7.n), "0", Order_edit.this.T.getText().toString(), false);
                    return;
                }
            }
            if (Order_edit.this.p == 8 || (Order_edit.this.p == 2 && !Order_edit.this.J)) {
                Order_edit order_edit8 = Order_edit.this;
                Z00 z01 = order_edit8.i;
                String str2 = this.a;
                if (order_edit8.T.getText().toString() == null) {
                    Order_edit order_edit9 = Order_edit.this;
                    string2 = order_edit9.i.C2(order_edit9.k);
                } else {
                    string2 = Order_edit.this.T.getText().toString();
                }
                order_edit8.p0 = z01.m7("0", str2, string2, Order_edit.this.i.ja("prefOthers_item_end_date", false));
            }
        }
    }

    public class T0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public T0(Handler handler, String str, int i) {
            this.a = handler;
            this.b = str;
            this.c = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit.this.l0(this.a, this.b, this.c);
        }
    }

    public class U implements AdapterView.OnItemClickListener {
        public U() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Order_edit.this.h1(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    public class U0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public U0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit.this.I1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class V implements View.OnTouchListener {
        public V() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Order_edit.this.j1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.j1.getCompoundDrawables()[0] != null ? Order_edit.this.j1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.j1.getPaddingLeft() + Order_edit.this.j1.getLeft()) {
                    Order_edit.this.j1.setText("");
                    Order_edit.this.j1.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Order_edit.this.j1.getRight();
                Order_edit.this.j1.getPaddingRight();
                if (Order_edit.this.j1.getCompoundDrawables()[2] != null) {
                    Order_edit.this.j1.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class V0 extends Handler {
        public V0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class W implements View.OnClickListener {
        public W() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = Order_edit.this.m0.getText().toString();
            Order_edit order_edit = Order_edit.this;
            order_edit.i.T(order_edit, order_edit.D0, Order_edit.this.m0);
            Log.d("curr=", string + ":" + Order_edit.this.m0.getText().toString() + ":" + Order_edit.this.n);
            Order_edit.this.r2 = 1;
        }
    }

    public class W0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public W0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit.this.m0(this.a);
        }
    }

    public class X implements TextWatcher {
        public X() {
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
                Order_edit order_edit = Order_edit.this;
                order_edit.j1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(order_edit, android.R.drawable.ic_notification_clear_all), (Drawable) null, Order_edit.this.j1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Order_edit.this.j1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class X0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public X0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit.this.I1 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class Y implements View.OnClickListener {
        public Y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.more_item(view);
        }
    }

    public class Y0 extends Handler {
        public Y0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class Z implements View.OnClickListener {
        public Z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Order_edit.this.k1.getText().toString().length() != 0) {
                Order_edit.this.k1.setText("");
            } else {
                EditText editText = Order_edit.this.k1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class Z0 implements CompoundButton.OnCheckedChangeListener {
        public Z0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Order_edit order_edit = Order_edit.this;
            order_edit.r2 = 1;
            order_edit.W1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$a, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2972a implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public ViewOnTouchListenerC2972a(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$a0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2973a0 implements View.OnClickListener {
        public ViewOnClickListenerC2973a0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Order_edit.this.l1.getText().toString().length() != 0) {
                Order_edit.this.l1.setText("");
            } else {
                EditText editText = Order_edit.this.l1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$a1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2974a1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Handler c;

        public DialogInterfaceOnClickListenerC2974a1(String str, String str2, Handler handler) {
            this.a = str;
            this.b = str2;
            this.c = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit.this.n0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2975b implements View.OnClickListener {
        public ViewOnClickListenerC2975b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$b0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2976b0 implements View.OnClickListener {
        public ViewOnClickListenerC2976b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit order_edit = Order_edit.this;
            double dDoubleValue = order_edit.w0(order_edit.o1.getText().toString(), Order_edit.this.l).doubleValue();
            Order_edit order_edit2 = Order_edit.this;
            Z00 z00 = order_edit2.i;
            String string = order_edit2.o1.getText().toString();
            Order_edit order_edit3 = Order_edit.this;
            String str = order_edit3.l;
            String string2 = order_edit3.m0.getText().toString();
            boolean zIsChecked = Order_edit.this.Q.isChecked();
            Order_edit order_edit4 = Order_edit.this;
            z00.te(order_edit2, string, str, string2, dDoubleValue, zIsChecked, order_edit4.V0, order_edit4.p, Order_edit.this.x1.getText().toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$b1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2977b1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2977b1(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit order_edit = Order_edit.this;
            Toast.makeText(order_edit, order_edit.getString(info.aalmoghalis.inventory.R.string.out_stock_balance), 0).show();
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2978c implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2978c(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.z0(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$c0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2979c0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2979c0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.n1.getCompoundDrawables()[0] != null ? Order_edit.this.n1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.n1.getPaddingLeft() + Order_edit.this.n1.getLeft()) {
                    Order_edit order_edit = Order_edit.this;
                    order_edit.i.B(order_edit.n1, order_edit.z1);
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$c1, reason: case insensitive filesystem */
    public class C2980c1 implements AdapterView.OnItemClickListener {
        public C2980c1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Order_edit.this.u1.setText(adapterView.getItemAtPosition(i).toString());
            Order_edit.this.q1.requestFocus();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$d, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2981d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2981d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$d0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2982d0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2982d0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.k1.getCompoundDrawables()[0] != null ? Order_edit.this.k1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.k1.getPaddingLeft() + Order_edit.this.k1.getLeft()) {
                    Order_edit order_edit = Order_edit.this;
                    order_edit.i.B(order_edit.k1, order_edit.z1);
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$d1, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2983d1 implements View.OnTouchListener {
        public ViewOnTouchListenerC2983d1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Order_edit.this.u1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.u1.getCompoundDrawables()[0] != null ? Order_edit.this.u1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.u1.getPaddingLeft() + Order_edit.this.u1.getLeft()) {
                    Order_edit.this.u1.setText("");
                    Order_edit.this.u1.requestFocus();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$e, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2984e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2984e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$e0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC2985e0 implements View.OnTouchListener {
        public ViewOnTouchListenerC2985e0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.l1.getCompoundDrawables()[0] != null ? Order_edit.this.l1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.l1.getPaddingLeft() + Order_edit.this.l1.getLeft()) {
                    Order_edit order_edit = Order_edit.this;
                    order_edit.t0(order_edit.l1);
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$e1, reason: case insensitive filesystem */
    public class C2986e1 implements TextWatcher {
        public C2986e1() {
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
                Order_edit order_edit = Order_edit.this;
                order_edit.u1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(order_edit, android.R.drawable.ic_notification_clear_all), (Drawable) null, Order_edit.this.u1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Order_edit.this.u1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$f, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2987f implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Handler g;

        public ViewOnClickListenerC2987f(AutoCompleteTextView autoCompleteTextView, androidx.appcompat.app.AlertDialog alertDialog, String str, EditText editText, EditText editText2, int i, Handler handler) {
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
            if (zA && Order_edit.this.i.Q5(this.a.getText().toString()).getCount() == 0 && this.a.getText().toString().trim().length() > 0) {
                Order_edit.this.Q1 = this.a.getText().toString();
                Order_edit order_edit = Order_edit.this;
                order_edit.T0(order_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Order_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Order_edit.this.Q1, this.b.getContext());
                if (!Order_edit.this.O1) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    Z00 z00 = Order_edit.this.i;
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
                    Order_edit order_edit2 = Order_edit.this;
                    order_edit2.N1 = 0;
                    order_edit2.I1 = true;
                    Order_edit.this.e2 = this.d.getText().toString();
                    Order_edit.this.h2 = this.e.getText().toString();
                    Order_edit.this.f2 = this.a.getText().toString();
                    Handler handler = this.g;
                    handler.sendMessage(handler.obtainMessage());
                }
                this.b.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$f0, reason: case insensitive filesystem */
    public class C2988f0 implements CompoundButton.OnCheckedChangeListener {
        public C2988f0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (Order_edit.this.M1.isChecked()) {
                Order_edit order_edit = Order_edit.this;
                order_edit.L1.setText(order_edit.getString(info.aalmoghalis.inventory.R.string.bill_cash));
            } else {
                Order_edit order_edit2 = Order_edit.this;
                order_edit2.L1.setText(order_edit2.getString(info.aalmoghalis.inventory.R.string.bill_post));
            }
            Log.d("item_status_p=", Order_edit.this.L1.getText().toString() + "#" + Order_edit.this.M1.isChecked());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$f1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2989f1 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2989f1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$g, reason: case insensitive filesystem */
    public class C2990g implements Filter.FilterListener {
        public C2990g() {
        }

        @Override // android.widget.Filter.FilterListener
        public void onFilterComplete(int i) {
            if (i == 0) {
                Order_edit.this.S1.setQuery("", false);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$g0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2991g0 implements View.OnClickListener {
        public ViewOnClickListenerC2991g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Order_edit.this.q1.getText().toString().length() != 0) {
                Order_edit.this.q1.setText("");
            } else {
                EditText editText = Order_edit.this.q1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$g1, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2992g1 implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public DialogInterfaceOnClickListenerC2992g1(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$h, reason: case insensitive filesystem */
    public class C2993h implements SearchView.OnQueryTextListener {
        public C2993h() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Order_edit.this.n1(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$h0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2994h0 implements View.OnClickListener {
        public ViewOnClickListenerC2994h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = Order_edit.this.T.getText().toString();
            Order_edit order_edit = Order_edit.this;
            order_edit.A0(order_edit.E0, Order_edit.this.T);
            Log.d("curr=", string + ":" + Order_edit.this.T.getText().toString() + ":" + Order_edit.this.n);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$h1, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2995h1 implements View.OnClickListener {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ AlertDialog b;

        public ViewOnClickListenerC2995h1(Handler handler, AlertDialog alertDialog) {
            this.a = handler;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (Order_edit.this.s1()) {
                    Order_edit.this.I1 = true;
                    Handler handler = this.a;
                    handler.sendMessage(handler.obtainMessage());
                    this.b.dismiss();
                }
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$i, reason: case insensitive filesystem */
    public class C2996i implements DatePickerDialog.OnDateSetListener {
        public C2996i() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Order_edit.this.K = i;
            Order_edit.this.L = i2;
            Order_edit.this.M = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Order_edit.this.K)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Order_edit.this.L + 1)) + "-" + Order_edit.this.M;
                Locale locale = Locale.ENGLISH;
                Order_edit.this.R.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$i0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2997i0 implements View.OnClickListener {
        public ViewOnClickListenerC2997i0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Order_edit.this.r1.getText().toString().length() != 0) {
                Order_edit.this.r1.setText("");
            } else {
                EditText editText = Order_edit.this.r1;
                editText.setText(editText.getHint().toString());
            }
        }
    }

    public class i1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public i1(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$j, reason: case insensitive filesystem */
    public class C2998j implements DatePickerDialog.OnDateSetListener {
        public C2998j() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Order_edit.this.K = i;
            Order_edit.this.L = i2;
            Order_edit.this.M = i3;
            try {
                String str = Order_edit.this.K + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Order_edit.this.L + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Order_edit.this.M));
                Locale locale = Locale.ENGLISH;
                Order_edit.this.U.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$j0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2999j0 implements View.OnClickListener {
        public ViewOnClickListenerC2999j0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.showDialog(4);
        }
    }

    public class j1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ArrayAdapter b;
        public final /* synthetic */ Dialog c;

        public j1(TextView textView, ArrayAdapter arrayAdapter, Dialog dialog) {
            this.a = textView;
            this.b = arrayAdapter;
            this.c = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getId() == Order_edit.this.T.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Order_edit order_edit = Order_edit.this;
                order_edit.c1 = 1;
                order_edit.r2 = 1;
                order_edit.u1();
                Order_edit.this.U0();
                Order_edit.this.H0();
                Order_edit order_edit2 = Order_edit.this;
                order_edit2.V1(order_edit2.n, "0");
                Order_edit.this.T.setText(adapterView.getItemAtPosition(i).toString());
            } else if (this.a.getId() == Order_edit.this.n0.getId()) {
                if (i == this.b.getCount() - 1) {
                    Order_edit order_edit3 = Order_edit.this;
                    order_edit3.O1("0", "", "", order_edit3.i.T5("0"), "", Order_edit.this.i.v1("121"));
                } else {
                    this.a.setText(adapterView.getItemAtPosition(i).toString());
                }
            } else if (this.a.getId() == Order_edit.this.a0.getId()) {
                this.a.setText(adapterView.getItemAtPosition(i).toString());
                Order_edit.this.D1();
                Order_edit.this.i.v0("update bills2 set t_val='" + Order_edit.this.a0.getText().toString().replaceAll(",", "") + "',tax_amount='" + Order_edit.this.b0.getText().toString().replaceAll(",", "") + "',amount='" + Order_edit.this.d0.getText().toString().replaceAll(",", "") + "' where id='" + Order_edit.this.n + "'");
            }
            this.c.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$k, reason: case insensitive filesystem */
    public class C3000k implements TextWatcher {
        public C3000k() {
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
                Order_edit.this.V.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(Order_edit.this, android.R.drawable.ic_notification_clear_all), (Drawable) null, Order_edit.this.V.getCompoundDrawables()[2], (Drawable) null);
            } else {
                Order_edit.this.V.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, Order_edit.this.V.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$k0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC3001k0 implements View.OnTouchListener {
        public ViewOnTouchListenerC3001k0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.s1.getCompoundDrawables()[0] != null ? Order_edit.this.s1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.s1.getPaddingLeft() + Order_edit.this.s1.getLeft()) {
                    Order_edit order_edit = Order_edit.this;
                    order_edit.i.B(order_edit.s1, order_edit.z1);
                }
            }
            return false;
        }
    }

    public class k1 implements View.OnClickListener {
        public k1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.showDialog(0);
            Order_edit.this.r2 = 1;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$l, reason: case insensitive filesystem */
    public class C3002l implements DatePickerDialog.OnDateSetListener {
        public C3002l() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            try {
                String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", locale);
                Date date = simpleDateFormat.parse(str);
                TextView textView = Order_edit.this.p1;
                if (textView != null) {
                    textView.setText(simpleDateFormat2.format(Long.valueOf(date.getTime())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$l0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC3003l0 implements View.OnTouchListener {
        public ViewOnTouchListenerC3003l0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.q1.getCompoundDrawables()[0] != null ? Order_edit.this.q1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.q1.getPaddingLeft() + Order_edit.this.q1.getLeft()) {
                    Order_edit order_edit = Order_edit.this;
                    order_edit.i.B(order_edit.q1, order_edit.z1);
                }
            }
            return false;
        }
    }

    public class l1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public l1(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String str = (String) ((HashMap) adapterView.getItemAtPosition(i)).get(HTML.Attribute.ID);
            if (!Order_edit.this.x1.getText().toString().equals(str)) {
                Order_edit.this.x1.setText(str);
                Order_edit order_edit = Order_edit.this;
                double dZ6 = order_edit.i.Z6(order_edit.o1.getText().toString(), Order_edit.this.x1.getText().toString());
                Order_edit.this.D = String.valueOf(dZ6);
                Order_edit order_edit2 = Order_edit.this;
                order_edit2.k1.setTag(order_edit2.D);
                Order_edit order_edit3 = Order_edit.this;
                double dJ6 = order_edit3.i.J6(order_edit3.o1.getText().toString(), Order_edit.this.m0.getText().toString(), Order_edit.this.p, Order_edit.this.Q.isChecked(), Order_edit.this.V0 + "", Order_edit.this.p, Order_edit.this.x1.getText().toString());
                if (Order_edit.this.p == 9) {
                    Order_edit order_edit4 = Order_edit.this;
                    order_edit4.k1.setHint(dJ6 <= 0.0d ? "" : order_edit4.i.S7(String.valueOf(dJ6 * dZ6)));
                }
                if (Order_edit.this.k1.getText().toString().length() > 0) {
                    EditText editText = Order_edit.this.k1;
                    editText.setText(editText.getHint());
                    Order_edit.this.k1.selectAll();
                }
                Order_edit order_edit5 = Order_edit.this;
                double dY0 = order_edit5.Y0(order_edit5.n, Order_edit.this.G);
                if (Order_edit.this.i.ja("prefOthers_qty_pr", false)) {
                    Order_edit order_edit6 = Order_edit.this;
                    order_edit6.n1.setHint(String.valueOf(order_edit6.i.c0("" + (dY0 / dZ6), dZ6)));
                } else {
                    Order_edit.this.n1.setHint(String.valueOf(C1839c10.C(dY0 / dZ6, C1839c10.d)));
                }
            }
            this.a.dismiss();
            Order_edit order_edit7 = Order_edit.this;
            order_edit7.i.Md(order_edit7);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$m, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3004m implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public ViewOnClickListenerC3004m(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit order_edit = Order_edit.this;
            order_edit.r2 = 1;
            order_edit.q0(view, this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$m0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC3005m0 implements View.OnTouchListener {
        public ViewOnTouchListenerC3005m0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.r1.getCompoundDrawables()[0] != null ? Order_edit.this.r1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.r1.getPaddingLeft() + Order_edit.this.r1.getLeft()) {
                    Order_edit order_edit = Order_edit.this;
                    order_edit.i.B(order_edit.r1, order_edit.z1);
                }
            }
            return false;
        }
    }

    public class m1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public m1(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            HashMap map = (HashMap) adapterView.getItemAtPosition(i);
            String str = (String) map.get("item_date");
            if (Order_edit.this.p1 != null) {
                double d = Double.parseDouble((String) map.get("item_qty"));
                if (d >= 0.0d) {
                    Order_edit.this.p1.setText(str);
                    Order_edit.this.n1.setHint(String.valueOf(d));
                    if (Order_edit.this.n1.getText().toString().length() > 0 && Double.parseDouble(Order_edit.this.n1.getText().toString().replaceAll(",", "")) > d) {
                        Order_edit order_edit = Order_edit.this;
                        order_edit.n1.setText(order_edit.i.S7(String.valueOf(d)));
                    }
                }
            }
            this.a.dismiss();
            Order_edit order_edit2 = Order_edit.this;
            order_edit2.i.Md(order_edit2);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$n, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3006n implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3006n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$n0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3007n0 implements View.OnClickListener {
        public ViewOnClickListenerC3007n0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d("click=", "item_date:" + Order_edit.s2);
            try {
                C2056di c2056di = new C2056di();
                Bundle bundle = new Bundle();
                String string = Order_edit.this.p1.getText().toString();
                if (string.length() == 0) {
                    Order_edit order_edit = Order_edit.this;
                    string = order_edit.i.D5(order_edit.o1.getText().toString());
                }
                ArrayList arrayListT = new C1839c10().t(string);
                if (arrayListT.size() > 2) {
                    bundle.putInt("year", ((Integer) arrayListT.get(0)).intValue());
                    bundle.putInt("month", ((Integer) arrayListT.get(1)).intValue());
                    bundle.putInt("day", ((Integer) arrayListT.get(2)).intValue());
                } else {
                    bundle.putInt("year", Order_edit.this.K);
                    bundle.putInt("month", Order_edit.this.L);
                    bundle.putInt("day", Order_edit.this.M);
                }
                c2056di.setArguments(bundle);
                Order_edit.this.p1.setText("");
                c2056di.f(Order_edit.this.V1);
                c2056di.show(Order_edit.this.getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    public class n1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public n1(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$o, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3008o implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3008o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$o0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3009o0 implements View.OnClickListener {
        public ViewOnClickListenerC3009o0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int[] iArr = {android.R.id.text1};
            Order_edit order_edit = Order_edit.this;
            Order_edit.this.B0(new SimpleAdapter(order_edit, order_edit.x0(order_edit.o1.getText().toString(), Order_edit.this.l), android.R.layout.simple_list_item_2, new String[]{"item_date_qty"}, iArr));
        }
    }

    public class o1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public o1(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$p, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3010p implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlertDialog d;

        public ViewOnClickListenerC3010p(EditText editText, String str, String str2, AlertDialog alertDialog) {
            this.a = editText;
            this.b = str;
            this.c = str2;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a)) {
                if (Order_edit.this.i.H("delete from item_price where item_id=(select a.id from items a where a.name='" + this.b + "') and curr_id=(select a.id from currency a where a.name='" + Order_edit.this.m0.getText().toString() + "') and unit_id=ifnull((select id from units where code='" + this.c + "'),0)", "insert into item_price(item_id,curr_id,unit_id,SLS_U_PRICE) values ((select a.id from items a where a.name='" + this.b + "'),(select a.id from currency a where a.name='" + Order_edit.this.m0.getText().toString() + "'),ifnull((select id from units where code='" + this.c + "'),0),'" + this.a.getText().toString().replaceAll(",", "") + "')") == 1) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$p0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3011p0 implements View.OnClickListener {
        public ViewOnClickListenerC3011p0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr = {HTML.Attribute.ID, "name"};
            int[] iArr = {android.R.id.text1, android.R.id.text2};
            Order_edit order_edit = Order_edit.this;
            Order_edit.this.C0(new SimpleAdapter(order_edit, order_edit.i.b9(order_edit.o1.getText().toString()), android.R.layout.simple_list_item_2, strArr, iArr));
        }
    }

    public class p1 implements View.OnClickListener {
        public p1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$q, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3012q implements View.OnClickListener {
        public ViewOnClickListenerC3012q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == Order_edit.this.n1.getId() || view.getId() == Order_edit.this.k1.getId()) {
                return;
            }
            view.getId();
            Order_edit.this.l1.getId();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$q0, reason: case insensitive filesystem */
    public class C3013q0 implements AdapterView.OnItemClickListener {
        public C3013q0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Order_edit.this.i1(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    public class q1 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public q1(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit order_edit = Order_edit.this;
            order_edit.i.T(order_edit, this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$r, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3014r implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public DialogInterfaceOnClickListenerC3014r(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$r0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC3015r0 implements View.OnTouchListener {
        public ViewOnTouchListenerC3015r0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Order_edit.this.o1.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Order_edit.this.o1.getCompoundDrawables()[0] != null ? Order_edit.this.o1.getCompoundDrawables()[0].getBounds().width() : 0) + Order_edit.this.o1.getPaddingLeft() + Order_edit.this.o1.getLeft()) {
                    Order_edit.this.o1.setText("");
                    Order_edit.this.x1.setVisibility(8);
                    Order_edit.this.x1.setText("");
                    Order_edit.this.n1.setText("");
                    Order_edit.this.k1.setText("");
                    Order_edit.this.p1.setText("");
                    Order_edit.this.o1.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Order_edit.this.o1.getRight();
                Order_edit.this.o1.getPaddingRight();
                if (Order_edit.this.o1.getCompoundDrawables()[2] != null) {
                    Order_edit.this.o1.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class r1 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public r1(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit order_edit = Order_edit.this;
            order_edit.i.T(order_edit, this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$s, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3016s implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3016s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$s0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3017s0 implements View.OnClickListener {
        public ViewOnClickListenerC3017s0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit order_edit = Order_edit.this;
            order_edit.r2 = 1;
            Order_edit order_edit2 = Order_edit.this;
            order_edit.F0 = new ArrayAdapter(order_edit2, android.R.layout.simple_spinner_dropdown_item, order_edit2.i.D3());
            Order_edit order_edit3 = Order_edit.this;
            order_edit3.i.Md(order_edit3);
            Order_edit order_edit4 = Order_edit.this;
            order_edit4.A0(order_edit4.F0, Order_edit.this.n0);
        }
    }

    public class s1 implements DialogInterface.OnClickListener {
        public s1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$t, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3018t implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlertDialog d;

        public ViewOnClickListenerC3018t(String str, TextView textView, String str2, AlertDialog alertDialog) {
            this.a = str;
            this.b = textView;
            this.c = str2;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Order_edit.this.R1(this.a, this.b.getText().toString(), this.c);
                this.d.dismiss();
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$t0, reason: case insensitive filesystem */
    public class C3019t0 implements TextWatcher {
        public C3019t0() {
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
                Order_edit order_edit = Order_edit.this;
                order_edit.o1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(order_edit, android.R.drawable.ic_notification_clear_all), (Drawable) null, Order_edit.this.j1.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Order_edit.this.o1;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class t1 implements DialogInterface.OnClickListener {
        public t1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$u, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3020u implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3020u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Order_edit.this.l1();
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getApplicationContext(), Order_edit.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$u0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3021u0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3021u0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class u1 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog g;

        public u1(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, EditText editText2, EditText editText3, androidx.appcompat.app.AlertDialog alertDialog) {
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
            if (Order_edit.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Order_edit.this.Q1 = this.b.getText().toString();
                Order_edit order_edit = Order_edit.this;
                order_edit.Q0(order_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Order_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Order_edit.this.Q1, Order_edit.this);
                if (!Order_edit.this.I1) {
                    return;
                }
            }
            if (z) {
                int iR1 = Order_edit.this.i.r1(this.c.getText().toString());
                if (!this.d.equals("0")) {
                    if (this.d != null) {
                        Order_edit.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.e.getText().toString() + "',address='" + this.f.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Order_edit.this.j + "' and id>0 ");
                        this.g.dismiss();
                        return;
                    }
                    return;
                }
                if (Order_edit.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                    FragmentStatePagerSupport_Main.Z(Order_edit.this);
                    this.a.setError(Order_edit.this.getString(info.aalmoghalis.inventory.R.string.exist));
                    return;
                }
                Order_edit.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.e.getText().toString() + "','" + this.f.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                if (iR1 == 121 || iR1 == 122) {
                    Order_edit.this.n0.setText(this.a.getText().toString());
                }
                this.g.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$v, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3022v implements View.OnClickListener {
        public ViewOnClickListenerC3022v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.P0 = true;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$v0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3023v0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3023v0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class v1 implements AdapterView.OnItemClickListener {
        public v1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Order_edit.this.V.setText(adapterView.getItemAtPosition(i).toString());
            Log.d("tr_name_clicked", "Yes");
            if (Order_edit.this.n == 0) {
                Order_edit.this.j1.requestFocus();
            } else {
                Order_edit.this.v0.requestFocus();
            }
            Order_edit.this.r2 = 1;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$w, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3024w implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3024w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit order_edit = Order_edit.this;
            order_edit.J = false;
            order_edit.Q.setChecked(true);
            Order_edit.this.W1();
            Order_edit order_edit2 = Order_edit.this;
            order_edit2.V1(order_edit2.n, "0");
            Order_edit.this.r2 = 1;
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$w0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3025w0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3025w0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class w1 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public w1(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$x, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3026x implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3026x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Order_edit order_edit = Order_edit.this;
                order_edit.s0(2, order_edit.p);
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getApplicationContext(), Order_edit.this.getString(info.aalmoghalis.inventory.R.string.sql_error), 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$x0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3027x0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog.Builder a;

        public DialogInterfaceOnClickListenerC3027x0(AlertDialog.Builder builder) {
            this.a = builder;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setCancelable(true);
            Order_edit.this.J1();
        }
    }

    public class x1 implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public x1(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$y, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3028y implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3028y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Order_edit order_edit = Order_edit.this;
            if (order_edit.q2 == 1) {
                order_edit.finish();
            } else {
                order_edit.r2 = 0;
                order_edit.U0();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$y0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3029y0 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC3029y0(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Button button = (Button) view;
                if (button.getText() == null || !button.getText().toString().equals(Order_edit.this.getString(info.aalmoghalis.inventory.R.string.add_transaction))) {
                    if (Order_edit.this.K0()) {
                        Log.d("edit_item_E=", FragmentStatePagerSupport_Main.X());
                        this.a.dismiss();
                        Order_edit.this.J1();
                    }
                } else if (Order_edit.this.K0()) {
                    Order_edit.this.A1();
                } else if (Order_edit.this.o1.getText().toString().length() == 0 && Order_edit.this.n1.getText().toString().length() == 0 && Order_edit.this.k1.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Order_edit.this.J1();
                }
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class y1 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public y1(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Order_edit.this.z0(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$z, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3030z implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC3030z(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Order_edit.this);
                if (this.a[i].equals(Order_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Order_edit order_edit = Order_edit.this;
                    order_edit.Y1 = order_edit.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Order_edit.this.u0();
                    }
                } else if (this.a[i].equals(Order_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Order_edit order_edit2 = Order_edit.this;
                    order_edit2.Y1 = order_edit2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Order_edit.this.M0();
                    }
                } else if (this.a[i].equals(Order_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Order_edit.this.i.qa(Z00.M + Order_edit.this.O0.getTag().toString());
                } else if (this.a[i].equals(Order_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Order_edit.this.O0.setTag(null);
                    Order_edit.this.O0.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Order_edit$z0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC3031z0 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC3031z0(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (Order_edit.this.K0()) {
                    this.a.dismiss();
                    Order_edit.this.J1();
                } else if (Order_edit.this.o1.getText().toString().length() == 0 && Order_edit.this.n1.getText().toString().length() == 0 && Order_edit.this.k1.getText().toString().length() == 0) {
                    this.a.dismiss();
                    Order_edit.this.J1();
                }
            } catch (Exception unused) {
                Toast.makeText(Order_edit.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class z1 implements DialogInterface.OnClickListener {
        public z1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void B1(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
    }

    private void C1() {
        String[] stringArray = this.O0.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC3030z(stringArray));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    private void G0(File file, File file2) throws IOException {
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

    private void J0() {
        String[] stringArray = this.O0.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setItems(stringArray, new A(stringArray));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.b2.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.a2);
    }

    private void U1() {
        int i = this.p;
        if (i == 2 || i == 9) {
            this.V.setHint(getString(info.aalmoghalis.inventory.R.string.supp));
            V0();
        }
        if (this.p == 2) {
            this.P.isChecked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1() {
    }

    private boolean c1(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean d1() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && c1(21, 22);
    }

    public static boolean e1(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean f1(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean g1(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        o1(uri, true);
    }

    private void m1(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                G0(new File(Z00.A0), file2);
            } else {
                G0(new File(O0(this, this.d2)), file2);
            }
            F1(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void o1(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.i, this);
            if (strX != null) {
                F1(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            K1();
            return;
        }
        int i = Integer.parseInt(this.i.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.i.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.c2.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean v0() {
        boolean zA = AbstractC4371yX.a(this.V);
        if (this.n != 0 && !AbstractC4371yX.a(this.v0)) {
            zA = false;
        }
        if (this.V.getText().length() == 0) {
            zA = false;
        }
        if (!this.i.Q()) {
            return zA;
        }
        D0();
        return false;
    }

    public void A0(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new j1(textView, arrayAdapter, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void A1() {
        this.o1.setText((CharSequence) null);
        this.n1.setText((CharSequence) null);
        this.k1.setText((CharSequence) null);
        this.l1.setText((CharSequence) null);
        this.m1.setText((CharSequence) null);
        this.o1.requestFocus();
    }

    public void B0(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new m1(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void C0(SimpleAdapter simpleAdapter) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) simpleAdapter);
        listView.setOnItemClickListener(new l1(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void D0() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Lc("black_date_done", "");
                this.i.F0(this);
            }
            p0();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void D1() {
        double d = Double.parseDouble(this.a0.getText().toString());
        double d2 = Double.parseDouble(this.W.getText().toString().replaceAll(",", ""));
        double d3 = (d * d2) / 100.0d;
        double d4 = d2 + d3;
        this.b0.setText(this.i.P7(d3 + ""));
        this.d0.setText(this.i.P7(d4 + ""));
        if (this.a0.getText().toString().equals("0") || this.n == 0) {
            this.b0.setVisibility(4);
            this.c0.setVisibility(4);
            this.e0.setVisibility(4);
            this.d0.setVisibility(4);
            return;
        }
        this.b0.setVisibility(0);
        this.c0.setVisibility(0);
        this.e0.setVisibility(0);
        this.d0.setVisibility(0);
        this.g0.setVisibility(0);
    }

    public void E0() {
        if (this.r2 != 0) {
            F0();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_back_back));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC3020u());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC3024w());
        builder.create().show();
    }

    public void E1() {
        this.y1.setOnClickListener(new Y());
        this.A1.setOnClickListener(new Z());
        this.B1.setOnClickListener(new ViewOnClickListenerC2973a0());
        this.w1.setOnClickListener(new ViewOnClickListenerC2976b0());
        this.n1.addTextChangedListener(this.S0);
        this.k1.addTextChangedListener(this.S0);
        this.l1.addTextChangedListener(this.S0);
        this.n1.setOnTouchListener(new ViewOnTouchListenerC2979c0());
        this.k1.setOnTouchListener(new ViewOnTouchListenerC2982d0());
        this.l1.setOnTouchListener(new ViewOnTouchListenerC2985e0());
    }

    public void F0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.confirm_save));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC3026x());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC3028y());
        builder.create().show();
    }

    public void F1(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            this.O0.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
            this.O0.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
            this.O0.setImageBitmap(bitmapP0);
            this.O0.setTag(str);
        } catch (Exception unused) {
        }
    }

    public void G1() {
        this.M1.setOnCheckedChangeListener(new C2988f0());
        this.J1.setOnClickListener(new ViewOnClickListenerC2991g0());
        this.K1.setOnClickListener(new ViewOnClickListenerC2997i0());
        Calendar calendar = Calendar.getInstance();
        this.U.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.K = calendar.get(1);
        this.L = calendar.get(2);
        this.M = calendar.get(5);
        this.U.setOnClickListener(new ViewOnClickListenerC2999j0());
        this.s1.addTextChangedListener(this.T0);
        this.q1.addTextChangedListener(this.T0);
        this.r1.addTextChangedListener(this.T0);
        this.s1.setOnTouchListener(new ViewOnTouchListenerC3001k0());
        this.q1.setOnTouchListener(new ViewOnTouchListenerC3003l0());
        this.r1.setOnTouchListener(new ViewOnTouchListenerC3005m0());
    }

    public void H0() {
        ArrayList arrayListG6 = this.i.G6();
        C2160f10.c0(this, this.j1, arrayListG6, 1);
        C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
        this.y0 = c1098Yv;
        c1098Yv.l.clear();
        this.y0.notifyDataSetChanged();
        this.j1.setThreshold(1);
        this.j1.setAdapter(this.y0);
        this.j1.setOnItemClickListener(new U());
        this.j1.setOnTouchListener(new V());
        this.j1.addTextChangedListener(new X());
    }

    public void H1() {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        this.c = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_share_bill3);
        this.d = getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons_share_bill3);
        ListView listView = new ListView(this);
        this.j2 = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = this.c;
            if (i >= strArr.length) {
                this.d.recycle();
                C4062ug c4062ug = new C4062ug(this, this.j2);
                this.k2 = c4062ug;
                listView.setAdapter((ListAdapter) c4062ug);
                listView.setOnItemClickListener(new N(dialog));
                linearLayout.setFocusable(true);
                listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                listView.setDividerHeight(0);
                linearLayout.addView(listView, -1, -1);
                dialog.requestWindowFeature(1);
                dialog.setContentView(linearLayout);
                dialog.show();
                return;
            }
            this.j2.add(new C3874sM(strArr[i], this.d.getResourceId(i, -1)));
            i++;
        }
    }

    public void I0() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "edit")) {
                Context context = this.b1;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "new")) {
            Context context2 = this.b1;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.B0.size() - 1; size >= 0; size--) {
            if (this.B0.valueAt(size)) {
                C0634Jt item = this.x0.getItem(this.B0.keyAt(size));
                this.x0.remove(item);
                this.i.v0("delete from items_temp where no_='" + item.f() + "'");
            }
        }
        this.c1 = 1;
        U0();
        k1();
        this.c1 = 1;
        U0();
        I1(false);
    }

    public void I1(boolean z) {
        this.O0.setOnClickListener(new ViewOnClickListenerC3004m(z));
    }

    /* JADX WARN: Code duplicated, block: B:106:0x03f7 A[Catch: Exception -> 0x0178, TryCatch #3 {Exception -> 0x0178, blocks: (B:48:0x0157, B:50:0x015f, B:78:0x0247, B:80:0x0265, B:84:0x0273, B:86:0x028a, B:88:0x02a4, B:91:0x033e, B:95:0x0344, B:97:0x0362, B:99:0x037c, B:100:0x038d, B:102:0x0392, B:104:0x039a, B:106:0x03f7, B:107:0x03fd, B:109:0x0402, B:113:0x0414, B:142:0x0526, B:144:0x052d, B:146:0x0535, B:151:0x0561, B:153:0x0569, B:155:0x056d, B:159:0x0574, B:162:0x059d, B:164:0x0624, B:166:0x062c), top: B:226:0x0157 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0414 A[Catch: Exception -> 0x0178, TRY_LEAVE, TryCatch #3 {Exception -> 0x0178, blocks: (B:48:0x0157, B:50:0x015f, B:78:0x0247, B:80:0x0265, B:84:0x0273, B:86:0x028a, B:88:0x02a4, B:91:0x033e, B:95:0x0344, B:97:0x0362, B:99:0x037c, B:100:0x038d, B:102:0x0392, B:104:0x039a, B:106:0x03f7, B:107:0x03fd, B:109:0x0402, B:113:0x0414, B:142:0x0526, B:144:0x052d, B:146:0x0535, B:151:0x0561, B:153:0x0569, B:155:0x056d, B:159:0x0574, B:162:0x059d, B:164:0x0624, B:166:0x062c), top: B:226:0x0157 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x049c  */
    /* JADX WARN: Code duplicated, block: B:124:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:126:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:134:0x04cb A[Catch: Exception -> 0x055b, TRY_ENTER, TryCatch #1 {Exception -> 0x055b, blocks: (B:117:0x044b, B:131:0x04bb, B:134:0x04cb, B:136:0x04d0, B:138:0x04d8, B:140:0x04e3), top: B:222:0x044b }] */
    /* JADX WARN: Code duplicated, block: B:136:0x04d0 A[Catch: Exception -> 0x055b, TryCatch #1 {Exception -> 0x055b, blocks: (B:117:0x044b, B:131:0x04bb, B:134:0x04cb, B:136:0x04d0, B:138:0x04d8, B:140:0x04e3), top: B:222:0x044b }] */
    /* JADX WARN: Code duplicated, block: B:150:0x055f  */
    /* JADX WARN: Code duplicated, block: B:153:0x0569 A[Catch: Exception -> 0x0178, TryCatch #3 {Exception -> 0x0178, blocks: (B:48:0x0157, B:50:0x015f, B:78:0x0247, B:80:0x0265, B:84:0x0273, B:86:0x028a, B:88:0x02a4, B:91:0x033e, B:95:0x0344, B:97:0x0362, B:99:0x037c, B:100:0x038d, B:102:0x0392, B:104:0x039a, B:106:0x03f7, B:107:0x03fd, B:109:0x0402, B:113:0x0414, B:142:0x0526, B:144:0x052d, B:146:0x0535, B:151:0x0561, B:153:0x0569, B:155:0x056d, B:159:0x0574, B:162:0x059d, B:164:0x0624, B:166:0x062c), top: B:226:0x0157 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x059a  */
    /* JADX WARN: Code duplicated, block: B:164:0x0624 A[Catch: Exception -> 0x0178, TryCatch #3 {Exception -> 0x0178, blocks: (B:48:0x0157, B:50:0x015f, B:78:0x0247, B:80:0x0265, B:84:0x0273, B:86:0x028a, B:88:0x02a4, B:91:0x033e, B:95:0x0344, B:97:0x0362, B:99:0x037c, B:100:0x038d, B:102:0x0392, B:104:0x039a, B:106:0x03f7, B:107:0x03fd, B:109:0x0402, B:113:0x0414, B:142:0x0526, B:144:0x052d, B:146:0x0535, B:151:0x0561, B:153:0x0569, B:155:0x056d, B:159:0x0574, B:162:0x059d, B:164:0x0624, B:166:0x062c), top: B:226:0x0157 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x068f  */
    /* JADX WARN: Code duplicated, block: B:175:0x0696 A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x06a4 A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x06bb A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x06dd A[Catch: Exception -> 0x06b3, TRY_LEAVE, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x06ff A[Catch: Exception -> 0x06b3, TRY_ENTER, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x0703 A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:197:0x07b6 A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x07fd A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:204:0x0803 A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x08c0 A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:213:0x0901 A[Catch: Exception -> 0x06b3, TryCatch #6 {Exception -> 0x06b3, blocks: (B:183:0x06b7, B:185:0x06bb, B:187:0x06cd, B:189:0x06dd, B:192:0x06ff, B:194:0x0703, B:195:0x0706, B:197:0x07b6, B:200:0x07c5, B:201:0x07e1, B:214:0x0904, B:202:0x07fd, B:204:0x0803, B:205:0x0806, B:207:0x08c0, B:210:0x08cf, B:211:0x08eb, B:213:0x0901, B:173:0x0691, B:175:0x0696, B:180:0x06a4), top: B:231:0x0691 }] */
    /* JADX WARN: Code duplicated, block: B:227:0x0458 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0260  */
    /* JADX WARN: Code duplicated, block: B:82:0x0271 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x0273 A[Catch: Exception -> 0x0178, TryCatch #3 {Exception -> 0x0178, blocks: (B:48:0x0157, B:50:0x015f, B:78:0x0247, B:80:0x0265, B:84:0x0273, B:86:0x028a, B:88:0x02a4, B:91:0x033e, B:95:0x0344, B:97:0x0362, B:99:0x037c, B:100:0x038d, B:102:0x0392, B:104:0x039a, B:106:0x03f7, B:107:0x03fd, B:109:0x0402, B:113:0x0414, B:142:0x0526, B:144:0x052d, B:146:0x0535, B:151:0x0561, B:153:0x0569, B:155:0x056d, B:159:0x0574, B:162:0x059d, B:164:0x0624, B:166:0x062c), top: B:226:0x0157 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0339  */
    /* JADX WARN: Instruction removed from duplicated block: B:189:0x06dd, please report this as an issue */
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
    public boolean K0() {
        Exception exc;
        boolean z;
        boolean z2;
        double d;
        double d2;
        double d3;
        double d4;
        String str;
        String str2;
        double d5;
        Order_edit order_edit;
        double d6;
        double dIc;
        boolean z3;
        double dY0;
        String str3;
        double d7;
        String str4;
        double d8;
        double d9;
        double dZ0;
        double d10;
        Order_edit order_edit2;
        int i;
        double dJ6;
        double dK6;
        int i2;
        Order_edit order_edit3;
        Order_edit order_edit4;
        Order_edit order_edit5;
        String str5;
        TextView textView;
        TextView textView2;
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "edit")) {
                Context context = this.b1;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return false;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "new")) {
            Context context2 = this.b1;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        try {
            boolean zA = AbstractC4371yX.a(this.n1);
            try {
                if (!AbstractC4371yX.a(this.o1)) {
                    zA = false;
                }
                if (this.k1.getText().toString().trim().length() == 0 && this.l1.getText().toString().trim().length() == 0) {
                    AbstractC4371yX.a(this.k1);
                    AbstractC4371yX.a(this.l1);
                    zA = false;
                }
                try {
                    double d11 = this.k1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.k1.getText().toString().replaceAll(",", "")) : 0.0d;
                    double d12 = this.l1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.l1.getText().toString().replaceAll(",", "")) : 0.0d;
                    double d13 = 1.0d;
                    if (this.n1.getText().toString().trim().length() > 0) {
                        double dB0 = Double.parseDouble(this.n1.getText().toString().replaceAll(",", ""));
                        d = this.k1.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.k1.getTag().toString().replaceAll(",", "")) : 1.0d;
                        z2 = zA;
                        try {
                            if (this.i.ja("prefOthers_qty_pr", false)) {
                                dB0 = this.i.b0(this.n1.getText().toString().replaceAll(",", ""), d);
                            }
                            d2 = dB0;
                        } catch (Exception e) {
                            e = e;
                            exc = e;
                            z = z2;
                            Log.d("edit_item_error=", exc.getMessage() + "");
                            exc.printStackTrace();
                            return z;
                        }
                    } else {
                        z2 = zA;
                        d = 1.0d;
                        d2 = 0.0d;
                    }
                    if (d11 > 0.0d) {
                        double d14 = d12;
                        if (d14 > 0.0d) {
                            try {
                                str = "item_qty=";
                                String strS7 = this.i.S7(this.k1.getText().toString().replaceAll(",", ""));
                                Z00 z00 = this.i;
                                str2 = ":";
                                StringBuilder sb = new StringBuilder();
                                sb.append("");
                                d3 = d;
                                sb.append(Double.parseDouble(this.l1.getText().toString().replaceAll(",", "")) / d2);
                                if (!strS7.equals(z00.S7(sb.toString()))) {
                                    EditText editText = this.l1;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(getString(info.aalmoghalis.inventory.R.string.total_not_correct));
                                    sb2.append("#");
                                    sb2.append(this.i.S7("" + (d11 * d2)));
                                    sb2.append("#");
                                    d4 = d14;
                                    sb2.append(d4);
                                    editText.setError(sb2.toString());
                                    d5 = 0.0d;
                                    z2 = false;
                                }
                                if (d4 >= d5 || d2 <= d5) {
                                    order_edit = this;
                                    d6 = d11;
                                    dIc = 0.0d;
                                } else {
                                    double d15 = d4 / d2;
                                    Order_edit order_edit6 = this;
                                    double dIc2 = order_edit6.i.Ic(String.valueOf(d15));
                                    dIc = order_edit6.i.Ic(String.valueOf(d15 / d3));
                                    d6 = dIc2;
                                    order_edit = order_edit6;
                                }
                                if (order_edit.o1.getText().length() == 0) {
                                    return false;
                                }
                                if (!order_edit.i.F6().contains(order_edit.o1.getText().toString()) || order_edit.i.F6().contains(order_edit.o1.getText().toString().trim())) {
                                    d13 = d3;
                                    z3 = true;
                                } else {
                                    AutoCompleteTextView autoCompleteTextView = order_edit.o1;
                                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                                    order_edit.e1 = order_edit.o1.getText().toString();
                                    order_edit.Q0(order_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item), order_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_item) + order_edit.e1, order_edit);
                                    ArrayList arrayListG6 = order_edit.i.G6();
                                    C2160f10.c0(order_edit, order_edit.o1, arrayListG6, 2);
                                    C1098Yv c1098Yv = new C1098Yv(order_edit, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
                                    order_edit.y0 = c1098Yv;
                                    c1098Yv.l.clear();
                                    order_edit.y0.notifyDataSetChanged();
                                    order_edit.o1.setAdapter(order_edit.y0);
                                    order_edit.k1.setTag("1");
                                    order_edit.x1.setVisibility(8);
                                    order_edit.x1.setText(order_edit.i.X6(order_edit.o1.getText().toString()));
                                    order_edit.p1.setText("");
                                    order_edit.V1(order_edit.n, "-1");
                                    z3 = false;
                                }
                                if (z3 && !order_edit.I1) {
                                    return false;
                                }
                                if (!order_edit.o1.getText().toString().equals(order_edit.o1.getText().toString().trim()) && order_edit.i.F6().contains(order_edit.o1.getText().toString().trim())) {
                                    AutoCompleteTextView autoCompleteTextView2 = order_edit.o1;
                                    autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                                }
                                if (order_edit.p == 1 && !order_edit.Q.isChecked()) {
                                    if (!order_edit.i.S7(String.valueOf(order_edit.i.J6(order_edit.o1.getText().toString(), order_edit.m0.getText().toString(), 1, order_edit.Q.isChecked(), order_edit.V0 + "", order_edit.p, order_edit.x1.getText().toString()))).equals(order_edit.i.S7(String.valueOf(d6)))) {
                                        order_edit.R1 = String.valueOf(d6);
                                    }
                                }
                                if (order_edit.p != 1 || order_edit.Q.isChecked()) {
                                    dY0 = order_edit.Y0(order_edit.n, order_edit.G);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(order_edit.n);
                                    str3 = str2;
                                    sb3.append(str3);
                                    sb3.append(order_edit.G);
                                    sb3.append(str3);
                                    sb3.append(dY0);
                                    sb3.append(str3);
                                    d7 = d2 * d13;
                                    sb3.append(d7);
                                    str4 = str;
                                    Log.d(str4, sb3.toString());
                                    d8 = d2;
                                    try {
                                        d9 = dIc;
                                        if (this.i.ja("prefOthers_item_end_date", false)) {
                                            try {
                                                dZ0 = Z0(this.n, this.G, this.p1.getText().toString());
                                                Log.d(str4, this.n + str3 + this.G + str3 + dY0 + str3 + dZ0 + str3 + d7);
                                                if (dZ0 < 0.0d && dZ0 <= dY0) {
                                                    dY0 = dZ0;
                                                } else if (dZ0 < 0.0d) {
                                                    dY0 = 0.0d;
                                                }
                                                this.f1 = this.p1.getText().toString();
                                            } catch (Exception e2) {
                                                exc = e2;
                                                z = z2;
                                                Log.d("edit_item_error=", exc.getMessage() + "");
                                                exc.printStackTrace();
                                                return z;
                                            }
                                        }
                                        d10 = dY0;
                                        if (d10 - C1839c10.C(d7, C1839c10.d) < 0.0d) {
                                            if (this.p == 1 || this.Q.isChecked() || this.i.ja("prefOthers_sales_out_qty", false)) {
                                                order_edit3 = this;
                                                i = 2;
                                            } else {
                                                this.I1 = false;
                                                this.e1 = this.i.P7(String.valueOf(d7 - d10));
                                                order_edit4 = this;
                                                i = 2;
                                                S0(getString(info.aalmoghalis.inventory.R.string.validation_add_purchase), getString(info.aalmoghalis.inventory.R.string.validation_add_purchase) + " " + this.e1, this, this.o1.getText().toString(), this.e1);
                                                boolean z4 = order_edit4.I1;
                                                order_edit3 = order_edit4;
                                                if (!z4 && !order_edit4.Q.isChecked()) {
                                                    order_edit3 = order_edit4;
                                                    order_edit4.n1.setError(order_edit4.getString(info.aalmoghalis.inventory.R.string.bal_net) + " " + String.valueOf(d10 / d13));
                                                    return false;
                                                }
                                            }
                                            order_edit3 = order_edit4;
                                            if (order_edit3.Q.isChecked() || (!order_edit3.J && order_edit3.p != i)) {
                                                order_edit2 = order_edit3;
                                            }
                                            order_edit3.n1.setError(order_edit3.getString(info.aalmoghalis.inventory.R.string.bal_back) + " " + String.valueOf(d10 / d13));
                                            return false;
                                        }
                                        order_edit2 = this;
                                        i = 2;
                                        dJ6 = order_edit2.i.J6(order_edit2.o1.getText().toString(), order_edit2.m0.getText().toString(), 1, order_edit2.Q.isChecked(), order_edit2.V0 + "", 1, order_edit2.x1.getText().toString());
                                        dK6 = order_edit2.i.K6(order_edit2.o1.getText().toString(), order_edit2.m0.getText().toString(), 2, order_edit2.Q.isChecked(), order_edit2.V0 + "", 1, order_edit2.x1.getText().toString());
                                        if (order_edit2.p == 1 || order_edit2.Q.isChecked() || order_edit2.i.S7(String.valueOf(dJ6)).equals(order_edit2.i.S7(String.valueOf(d6)))) {
                                            z = z2;
                                        } else {
                                            try {
                                                order_edit2.k1.setError(order_edit2.getString(info.aalmoghalis.inventory.R.string.sales_price) + " " + dJ6 + "#\n" + order_edit2.i.S7(String.valueOf(d6)) + StringUtilities.LF + order_edit2.i.S7(String.valueOf(dJ6)));
                                                z = false;
                                            } catch (Exception e3) {
                                                exc = e3;
                                                z = false;
                                                Log.d("edit_item_error=", exc.getMessage() + "");
                                                exc.printStackTrace();
                                            }
                                        }
                                        try {
                                            i2 = order_edit2.p;
                                            order_edit5 = order_edit2;
                                            if (i2 == 1 && !order_edit2.Q.isChecked() && z) {
                                                order_edit5 = order_edit2;
                                                if (dJ6 < dK6) {
                                                    order_edit2.i.Kd(order_edit2, order_edit2.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                                    order_edit5 = order_edit2;
                                                }
                                            }
                                        } catch (Exception e4) {
                                            exc = e4;
                                            Log.d("edit_item_error=", exc.getMessage() + "");
                                            exc.printStackTrace();
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        exc = e;
                                        z = z2;
                                        Log.d("edit_item_error=", exc.getMessage() + "");
                                        exc.printStackTrace();
                                        return z;
                                    }
                                } else {
                                    d8 = d2;
                                    d9 = dIc;
                                    z = z2;
                                    i = 2;
                                    order_edit5 = order_edit;
                                }
                                order_edit5 = order_edit2;
                                order_edit5 = order_edit2;
                                if (s2 != i && order_edit5.i.q7(order_edit5.o1.getText().toString()) > 0) {
                                    order_edit5.i.Kd(order_edit5, order_edit5.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                }
                                if (z) {
                                    Log.d("edit_item=", ((Object) order_edit5.w0.getText()) + "");
                                    str5 = "null";
                                    if (s2 == i) {
                                        if (order_edit5.n != 0) {
                                            L1();
                                        }
                                        Z00 z01 = order_edit5.i;
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("update items_temp set item_id=(select id from items a where a.name='");
                                        sb4.append((Object) order_edit5.o1.getText());
                                        sb4.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                        sb4.append((Object) order_edit5.o1.getText());
                                        sb4.append("'),qty='");
                                        sb4.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                        sb4.append("',qty_t='");
                                        sb4.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                        sb4.append("',price='");
                                        sb4.append(String.valueOf(d9));
                                        sb4.append("',unit_id=ifnull((select id from units where code='");
                                        sb4.append(order_edit5.x1.getText().toString());
                                        sb4.append("'),0),u_val='");
                                        sb4.append(String.valueOf(d13));
                                        sb4.append("',qty_pr=");
                                        sb4.append(d8);
                                        sb4.append(",curr_id=(select id from currency where name='");
                                        sb4.append(order_edit5.m0.getText().toString());
                                        sb4.append("') ,remark='");
                                        sb4.append(order_edit5.m1.getText().toString());
                                        sb4.append("',e_date=");
                                        textView2 = order_edit5.p1;
                                        if (textView2 != null && textView2.getText().toString().length() != 0) {
                                            str5 = "'" + order_edit5.p1.getText().toString() + "'";
                                        }
                                        sb4.append(str5);
                                        sb4.append(" where no_='");
                                        sb4.append(order_edit5.G);
                                        sb4.append("'");
                                        z01.v0(sb4.toString());
                                        P1();
                                    } else {
                                        double d16 = d8;
                                        if (order_edit5.n != 0) {
                                            L1();
                                        }
                                        Z00 z02 = order_edit5.i;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                        sb5.append((Object) order_edit5.o1.getText());
                                        sb5.append("'),(select item_type_id from items a where a.name='");
                                        sb5.append((Object) order_edit5.o1.getText());
                                        sb5.append("'),'");
                                        sb5.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                        sb5.append("','");
                                        sb5.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                        sb5.append("','");
                                        sb5.append(String.valueOf(d9));
                                        sb5.append("',(select id from currency where name='");
                                        sb5.append(order_edit5.m0.getText().toString());
                                        sb5.append("'),'");
                                        sb5.append(order_edit5.m1.getText().toString());
                                        sb5.append("',ifnull((select id from units where code='");
                                        sb5.append(order_edit5.x1.getText().toString());
                                        sb5.append("'),0),'");
                                        sb5.append(String.valueOf(d13));
                                        sb5.append("',(select unit_id from items where name='");
                                        sb5.append(order_edit5.o1.getText().toString());
                                        sb5.append("'),");
                                        sb5.append(d16);
                                        sb5.append(",");
                                        textView = order_edit5.p1;
                                        if (textView != null && textView.getText().toString().length() != 0) {
                                            str5 = "'" + order_edit5.p1.getText().toString() + "'";
                                        }
                                        sb5.append(str5);
                                        sb5.append(" )");
                                        z02.v0(sb5.toString());
                                        P1();
                                        if (order_edit5.n == 0) {
                                            k1();
                                        }
                                    }
                                    order_edit5.j1.setText("");
                                    H0();
                                    order_edit5.c1 = 1;
                                    U0();
                                    k1();
                                    order_edit5.c1 = 1;
                                    U0();
                                    order_edit5.V1(order_edit5.n, "0");
                                }
                                return z;
                            } catch (Exception e6) {
                                e = e6;
                                exc = e;
                                z = z2;
                                Log.d("edit_item_error=", exc.getMessage() + "");
                                exc.printStackTrace();
                                return z;
                            }
                        }
                        str = "item_qty=";
                        str2 = ":";
                        d3 = d;
                        d4 = d14;
                    } else {
                        d3 = d;
                        d4 = d12;
                        str = "item_qty=";
                        str2 = ":";
                    }
                    d5 = 0.0d;
                    if (d4 >= d5) {
                        order_edit = this;
                        d6 = d11;
                        dIc = 0.0d;
                    } else {
                        order_edit = this;
                        d6 = d11;
                        dIc = 0.0d;
                    }
                    if (order_edit.o1.getText().length() == 0) {
                        return false;
                    }
                    if (order_edit.i.F6().contains(order_edit.o1.getText().toString())) {
                        d13 = d3;
                        z3 = true;
                    } else {
                        d13 = d3;
                        z3 = true;
                    }
                    if (z3) {
                    }
                    if (!order_edit.o1.getText().toString().equals(order_edit.o1.getText().toString().trim())) {
                        AutoCompleteTextView autoCompleteTextView3 = order_edit.o1;
                        autoCompleteTextView3.setText(autoCompleteTextView3.getText().toString().trim());
                    }
                    if (order_edit.p == 1) {
                        if (!order_edit.i.S7(String.valueOf(order_edit.i.J6(order_edit.o1.getText().toString(), order_edit.m0.getText().toString(), 1, order_edit.Q.isChecked(), order_edit.V0 + "", order_edit.p, order_edit.x1.getText().toString()))).equals(order_edit.i.S7(String.valueOf(d6)))) {
                            order_edit.R1 = String.valueOf(d6);
                        }
                    }
                    if (order_edit.p != 1) {
                        dY0 = order_edit.Y0(order_edit.n, order_edit.G);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(order_edit.n);
                        str3 = str2;
                        sb6.append(str3);
                        sb6.append(order_edit.G);
                        sb6.append(str3);
                        sb6.append(dY0);
                        sb6.append(str3);
                        d7 = d2 * d13;
                        sb6.append(d7);
                        str4 = str;
                        Log.d(str4, sb6.toString());
                        d8 = d2;
                        d9 = dIc;
                        if (this.i.ja("prefOthers_item_end_date", false)) {
                            dZ0 = Z0(this.n, this.G, this.p1.getText().toString());
                            Log.d(str4, this.n + str3 + this.G + str3 + dY0 + str3 + dZ0 + str3 + d7);
                            if (dZ0 < 0.0d) {
                                if (dZ0 < 0.0d) {
                                    dY0 = 0.0d;
                                }
                            } else if (dZ0 < 0.0d) {
                                dY0 = 0.0d;
                            }
                            this.f1 = this.p1.getText().toString();
                        }
                        d10 = dY0;
                        if (d10 - C1839c10.C(d7, C1839c10.d) < 0.0d) {
                            if (this.p == 1) {
                                order_edit3 = this;
                                i = 2;
                            } else {
                                order_edit3 = this;
                                i = 2;
                            }
                            order_edit3 = order_edit4;
                            if (order_edit3.Q.isChecked()) {
                            }
                            order_edit2 = order_edit3;
                        } else {
                            order_edit2 = this;
                            i = 2;
                        }
                        dJ6 = order_edit2.i.J6(order_edit2.o1.getText().toString(), order_edit2.m0.getText().toString(), 1, order_edit2.Q.isChecked(), order_edit2.V0 + "", 1, order_edit2.x1.getText().toString());
                        dK6 = order_edit2.i.K6(order_edit2.o1.getText().toString(), order_edit2.m0.getText().toString(), 2, order_edit2.Q.isChecked(), order_edit2.V0 + "", 1, order_edit2.x1.getText().toString());
                        if (order_edit2.p == 1) {
                            z = z2;
                        } else {
                            z = z2;
                        }
                        i2 = order_edit2.p;
                        order_edit5 = order_edit2;
                        if (i2 == 1) {
                            order_edit5 = order_edit2;
                            if (dJ6 < dK6) {
                                order_edit2.i.Kd(order_edit2, order_edit2.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                order_edit5 = order_edit2;
                            }
                        }
                        order_edit5 = order_edit2;
                        order_edit5 = order_edit2;
                        if (s2 != i) {
                            order_edit5.i.Kd(order_edit5, order_edit5.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                        if (z) {
                            Log.d("edit_item=", ((Object) order_edit5.w0.getText()) + "");
                            str5 = "null";
                            if (s2 == i) {
                                if (order_edit5.n != 0) {
                                    L1();
                                }
                                Z00 z03 = order_edit5.i;
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("update items_temp set item_id=(select id from items a where a.name='");
                                sb7.append((Object) order_edit5.o1.getText());
                                sb7.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                sb7.append((Object) order_edit5.o1.getText());
                                sb7.append("'),qty='");
                                sb7.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                sb7.append("',qty_t='");
                                sb7.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                sb7.append("',price='");
                                sb7.append(String.valueOf(d9));
                                sb7.append("',unit_id=ifnull((select id from units where code='");
                                sb7.append(order_edit5.x1.getText().toString());
                                sb7.append("'),0),u_val='");
                                sb7.append(String.valueOf(d13));
                                sb7.append("',qty_pr=");
                                sb7.append(d8);
                                sb7.append(",curr_id=(select id from currency where name='");
                                sb7.append(order_edit5.m0.getText().toString());
                                sb7.append("') ,remark='");
                                sb7.append(order_edit5.m1.getText().toString());
                                sb7.append("',e_date=");
                                textView2 = order_edit5.p1;
                                if (textView2 != null) {
                                    str5 = "'" + order_edit5.p1.getText().toString() + "'";
                                }
                                sb7.append(str5);
                                sb7.append(" where no_='");
                                sb7.append(order_edit5.G);
                                sb7.append("'");
                                z03.v0(sb7.toString());
                                P1();
                            } else {
                                double d17 = d8;
                                if (order_edit5.n != 0) {
                                    L1();
                                }
                                Z00 z04 = order_edit5.i;
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                sb8.append((Object) order_edit5.o1.getText());
                                sb8.append("'),(select item_type_id from items a where a.name='");
                                sb8.append((Object) order_edit5.o1.getText());
                                sb8.append("'),'");
                                sb8.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                sb8.append("','");
                                sb8.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                sb8.append("','");
                                sb8.append(String.valueOf(d9));
                                sb8.append("',(select id from currency where name='");
                                sb8.append(order_edit5.m0.getText().toString());
                                sb8.append("'),'");
                                sb8.append(order_edit5.m1.getText().toString());
                                sb8.append("',ifnull((select id from units where code='");
                                sb8.append(order_edit5.x1.getText().toString());
                                sb8.append("'),0),'");
                                sb8.append(String.valueOf(d13));
                                sb8.append("',(select unit_id from items where name='");
                                sb8.append(order_edit5.o1.getText().toString());
                                sb8.append("'),");
                                sb8.append(d17);
                                sb8.append(",");
                                textView = order_edit5.p1;
                                if (textView != null) {
                                    str5 = "'" + order_edit5.p1.getText().toString() + "'";
                                }
                                sb8.append(str5);
                                sb8.append(" )");
                                z04.v0(sb8.toString());
                                P1();
                                if (order_edit5.n == 0) {
                                    k1();
                                }
                            }
                            order_edit5.j1.setText("");
                            H0();
                            order_edit5.c1 = 1;
                            U0();
                            k1();
                            order_edit5.c1 = 1;
                            U0();
                            order_edit5.V1(order_edit5.n, "0");
                        }
                    } else {
                        dY0 = order_edit.Y0(order_edit.n, order_edit.G);
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(order_edit.n);
                        str3 = str2;
                        sb9.append(str3);
                        sb9.append(order_edit.G);
                        sb9.append(str3);
                        sb9.append(dY0);
                        sb9.append(str3);
                        d7 = d2 * d13;
                        sb9.append(d7);
                        str4 = str;
                        Log.d(str4, sb9.toString());
                        d8 = d2;
                        d9 = dIc;
                        if (this.i.ja("prefOthers_item_end_date", false)) {
                            dZ0 = Z0(this.n, this.G, this.p1.getText().toString());
                            Log.d(str4, this.n + str3 + this.G + str3 + dY0 + str3 + dZ0 + str3 + d7);
                            if (dZ0 < 0.0d) {
                                if (dZ0 < 0.0d) {
                                    dY0 = 0.0d;
                                }
                            } else if (dZ0 < 0.0d) {
                                dY0 = 0.0d;
                            }
                            this.f1 = this.p1.getText().toString();
                        }
                        d10 = dY0;
                        if (d10 - C1839c10.C(d7, C1839c10.d) < 0.0d) {
                            if (this.p == 1) {
                                order_edit3 = this;
                                i = 2;
                            } else {
                                order_edit3 = this;
                                i = 2;
                            }
                            order_edit3 = order_edit4;
                            if (order_edit3.Q.isChecked()) {
                            }
                            order_edit2 = order_edit3;
                        } else {
                            order_edit2 = this;
                            i = 2;
                        }
                        dJ6 = order_edit2.i.J6(order_edit2.o1.getText().toString(), order_edit2.m0.getText().toString(), 1, order_edit2.Q.isChecked(), order_edit2.V0 + "", 1, order_edit2.x1.getText().toString());
                        dK6 = order_edit2.i.K6(order_edit2.o1.getText().toString(), order_edit2.m0.getText().toString(), 2, order_edit2.Q.isChecked(), order_edit2.V0 + "", 1, order_edit2.x1.getText().toString());
                        if (order_edit2.p == 1) {
                            z = z2;
                        } else {
                            z = z2;
                        }
                        i2 = order_edit2.p;
                        order_edit5 = order_edit2;
                        if (i2 == 1) {
                            order_edit5 = order_edit2;
                            if (dJ6 < dK6) {
                                order_edit2.i.Kd(order_edit2, order_edit2.getString(info.aalmoghalis.inventory.R.string.alarm_price), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                                order_edit5 = order_edit2;
                            }
                        }
                        order_edit5 = order_edit2;
                        order_edit5 = order_edit2;
                        if (s2 != i) {
                            order_edit5.i.Kd(order_edit5, order_edit5.getString(info.aalmoghalis.inventory.R.string.item_exists), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                        if (z) {
                            Log.d("edit_item=", ((Object) order_edit5.w0.getText()) + "");
                            str5 = "null";
                            if (s2 == i) {
                                if (order_edit5.n != 0) {
                                    L1();
                                }
                                Z00 z05 = order_edit5.i;
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append("update items_temp set item_id=(select id from items a where a.name='");
                                sb10.append((Object) order_edit5.o1.getText());
                                sb10.append("'),item_type_id=(select item_type_id from items a where a.name='");
                                sb10.append((Object) order_edit5.o1.getText());
                                sb10.append("'),qty='");
                                sb10.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                sb10.append("',qty_t='");
                                sb10.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                sb10.append("',price='");
                                sb10.append(String.valueOf(d9));
                                sb10.append("',unit_id=ifnull((select id from units where code='");
                                sb10.append(order_edit5.x1.getText().toString());
                                sb10.append("'),0),u_val='");
                                sb10.append(String.valueOf(d13));
                                sb10.append("',qty_pr=");
                                sb10.append(d8);
                                sb10.append(",curr_id=(select id from currency where name='");
                                sb10.append(order_edit5.m0.getText().toString());
                                sb10.append("') ,remark='");
                                sb10.append(order_edit5.m1.getText().toString());
                                sb10.append("',e_date=");
                                textView2 = order_edit5.p1;
                                if (textView2 != null) {
                                    str5 = "'" + order_edit5.p1.getText().toString() + "'";
                                }
                                sb10.append(str5);
                                sb10.append(" where no_='");
                                sb10.append(order_edit5.G);
                                sb10.append("'");
                                z05.v0(sb10.toString());
                                P1();
                            } else {
                                double d18 = d8;
                                if (order_edit5.n != 0) {
                                    L1();
                                }
                                Z00 z06 = order_edit5.i;
                                StringBuilder sb11 = new StringBuilder();
                                sb11.append("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val ,base_unit,qty_pr,e_date)  values( (select id from items a where a.name='");
                                sb11.append((Object) order_edit5.o1.getText());
                                sb11.append("'),(select item_type_id from items a where a.name='");
                                sb11.append((Object) order_edit5.o1.getText());
                                sb11.append("'),'");
                                sb11.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                sb11.append("','");
                                sb11.append(order_edit5.n1.getText().toString().replaceAll(",", ""));
                                sb11.append("','");
                                sb11.append(String.valueOf(d9));
                                sb11.append("',(select id from currency where name='");
                                sb11.append(order_edit5.m0.getText().toString());
                                sb11.append("'),'");
                                sb11.append(order_edit5.m1.getText().toString());
                                sb11.append("',ifnull((select id from units where code='");
                                sb11.append(order_edit5.x1.getText().toString());
                                sb11.append("'),0),'");
                                sb11.append(String.valueOf(d13));
                                sb11.append("',(select unit_id from items where name='");
                                sb11.append(order_edit5.o1.getText().toString());
                                sb11.append("'),");
                                sb11.append(d18);
                                sb11.append(",");
                                textView = order_edit5.p1;
                                if (textView != null) {
                                    str5 = "'" + order_edit5.p1.getText().toString() + "'";
                                }
                                sb11.append(str5);
                                sb11.append(" )");
                                z06.v0(sb11.toString());
                                P1();
                                if (order_edit5.n == 0) {
                                    k1();
                                }
                            }
                            order_edit5.j1.setText("");
                            H0();
                            order_edit5.c1 = 1;
                            U0();
                            k1();
                            order_edit5.c1 = 1;
                            U0();
                            order_edit5.V1(order_edit5.n, "0");
                        }
                    }
                    return z;
                } catch (Exception e7) {
                    e = e7;
                    z2 = zA;
                }
            } catch (Exception e8) {
                exc = e8;
                z = zA;
            }
        } catch (Exception e9) {
            exc = e9;
            z = true;
        }
    }

    public void K1() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.i.J2(this, intent);
            this.d2 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.d2.getPath() + "");
            startActivityForResult(intent, this.Z1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void L0(Cursor cursor) {
        int count = cursor.getCount();
        Log.d("Cursor_cnt=", String.valueOf(count) + ":" + this.n);
        I1(false);
        this.z0.clear();
        cursor.moveToFirst();
        int i = 0;
        double d = 0.0d;
        while (!cursor.isAfterLast()) {
            i++;
            this.z0.add(new C0634Jt(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("item_name")), cursor.getString(cursor.getColumnIndex("item_type")), this.i.S7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("item_total")))), this.i.T7("" + cursor.getDouble(cursor.getColumnIndex("qty_t"))), this.i.S7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("item_price")))), cursor.getString(cursor.getColumnIndex("no_")), cursor.getString(cursor.getColumnIndex("tran_status")), cursor.getString(cursor.getColumnIndex("item_remarks")), cursor.getString(cursor.getColumnIndex("unit_name")), cursor.getString(cursor.getColumnIndex("unit_val")), cursor.getString(cursor.getColumnIndex("qty_pr")), cursor.getString(cursor.getColumnIndex("barcode")), cursor.getString(cursor.getColumnIndex("e_date"))));
            d += cursor.getDouble(cursor.getColumnIndex("item_price")) * cursor.getDouble(cursor.getColumnIndex("qty_pr"));
            if (this.n != 0 && i == count) {
                this.u0.setText(cursor.getString(cursor.getColumnIndex("bill_type")));
                this.p = cursor.getInt(cursor.getColumnIndex("tr_type_id"));
                String string = cursor.getString(cursor.getColumnIndex("curr_name"));
                this.w = string;
                this.m0.setText(string);
                this.T.setText(cursor.getString(cursor.getColumnIndex("br_name")));
                int i2 = cursor.getInt(cursor.getColumnIndex("is_back"));
                if (i2 == 1) {
                    this.W0 = -1;
                    this.V0 = cursor.getInt(cursor.getColumnIndex("bill_no"));
                    this.Q.setChecked(i2 != 0);
                    if (this.V0 != 0) {
                        this.Q.setEnabled(false);
                    }
                } else {
                    this.Q.setChecked(i2 != 0);
                }
                if (cursor.getString(cursor.getColumnIndex("bill_type_id")).equals("1")) {
                    this.P.setChecked(true);
                    this.r2 = 0;
                    U1();
                    V0();
                } else {
                    this.P.setChecked(false);
                    this.r2 = 0;
                    U1();
                    V0();
                }
                this.V.setText(cursor.getString(cursor.getColumnIndex("param2")));
                this.V.dismissDropDown();
                this.R.setText(cursor.getString(cursor.getColumnIndex("date_")));
                this.i.nd(this.v0, cursor.getString(cursor.getColumnIndex("bill_no2")));
                this.n0.setText(cursor.getString(cursor.getColumnIndex("cash_name")));
                this.i.nd(this.w0, cursor.getString(cursor.getColumnIndex("remarks")));
                this.G1 = cursor.getDouble(cursor.getColumnIndex("t_val"));
                this.H1 = cursor.getDouble(cursor.getColumnIndex("tax_amount"));
                this.C1 = cursor.getDouble(cursor.getColumnIndex("amount")) - this.H1;
                this.D1 = cursor.getDouble(cursor.getColumnIndex("d_amount"));
                this.E1 = cursor.getInt(cursor.getColumnIndex("discount_id"));
                double d2 = cursor.getDouble(cursor.getColumnIndex("d_val"));
                this.F1 = d2;
                if (this.E1 == 0 && d2 == 0.0d) {
                    double d3 = this.D1;
                    if (d3 != 0.0d) {
                        this.F1 = d3;
                    }
                }
                if (cursor.getString(cursor.getColumnIndex("tran_status")).equals("3")) {
                    this.q0.setVisibility(4);
                }
                ImageView imageView = this.O0;
                if (imageView != null) {
                    imageView.setTag(cursor.getString(cursor.getColumnIndex("param1")) != null ? cursor.getString(cursor.getColumnIndex("param1")) : "");
                    if (this.O0.getTag().toString().equals("")) {
                        B1(this.O0);
                    } else {
                        F1(this.O0.getTag().toString());
                    }
                }
            }
            cursor.moveToNext();
        }
        cursor.close();
        double d4 = this.C1;
        if ((d4 == 0.0d && this.D1 == 0.0d) || this.c1 == 1) {
            this.W.setText(this.i.P7(String.valueOf(d)));
            this.Y.setText("0");
            this.c1 = 0;
            D1();
        } else {
            this.W.setText(this.i.P7(String.valueOf(d4)));
            this.Y.setText(this.i.P7(String.valueOf(this.D1)));
            this.a0.setText(this.i.P7(String.valueOf(this.G1)));
            this.b0.setText(this.i.P7(String.valueOf(this.H1)));
            this.d0.setText(this.i.P7(String.valueOf(this.C1 + this.H1)));
            D1();
        }
        this.X.setText(this.z0.size() + "");
        NumberFormat.getInstance(Locale.ENGLISH).format(0.0d);
        C0809Ov c0809Ov = new C0809Ov(this, info.aalmoghalis.inventory.R.layout.bill_item_det_row3, this.z0);
        this.x0 = c0809Ov;
        c0809Ov.j.clear();
        this.x0.notifyDataSetChanged();
        this.N.setAdapter((ListAdapter) this.x0);
        if (this.n == 0) {
            this.r2 = 1;
        } else {
            this.r2 = 0;
        }
        SearchView searchView = this.S1;
        String string2 = (searchView == null || searchView.getQuery() == null) ? "" : this.S1.getQuery().toString();
        if (string2.length() > 0) {
            this.x0.getFilter().filter(string2, new C2990g());
        }
    }

    public void L1() {
        String string;
        String str;
        String str2;
        try {
            u1();
            int i = this.P.isChecked() ? 1 : 2;
            if (v0()) {
                if (!this.V.getText().toString().equals(this.V.getText().toString().trim()) && this.i.v8(this.V.getText().toString().trim(), this.p).getCount() > 0) {
                    AutoCompleteTextView autoCompleteTextView = this.V;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                }
                this.i.D = false;
                if (this.m0.getText() != null && !this.m0.getText().toString().equals(this.i.l3("0")) && this.i.Z2(this.m0.getText().toString(), this.R.getText().toString()) == 0) {
                    this.i.u(this, this.m0.getText().toString(), this.R.getText().toString(), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                    if (!this.i.D) {
                        return;
                    }
                }
                if (this.i.g2().getCount() == 0) {
                    return;
                }
                if (this.p == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("update bills2 set date_='");
                    sb.append((Object) this.R.getText());
                    sb.append("',amount='");
                    sb.append(this.d0.getText().toString().replaceAll(",", ""));
                    sb.append("',d_amount='");
                    sb.append(this.Y.getText().toString().replaceAll(",", ""));
                    sb.append("',t_val='");
                    sb.append(this.a0.getText().toString().replaceAll(",", ""));
                    sb.append("',tax_amount='");
                    sb.append(this.b0.getText().toString().replaceAll(",", ""));
                    sb.append("',cus_id=(select id from customers where name='");
                    sb.append((Object) this.V.getText());
                    sb.append("' ),br_id=(select id from branches where name='");
                    sb.append((Object) this.T.getText());
                    sb.append("' ),cash_id=(select id from customers where name='");
                    sb.append((Object) this.n0.getText());
                    sb.append("' ),bill_type=");
                    sb.append(i);
                    sb.append(",bill_no2='");
                    sb.append((Object) this.v0.getText());
                    sb.append("',is_back='");
                    sb.append(this.Q.isChecked() ? 1 : 0);
                    sb.append("',remarks='");
                    sb.append((Object) this.w0.getText());
                    sb.append("',param1='");
                    sb.append(this.O0.getTag() != null ? this.O0.getTag().toString() : "");
                    sb.append("',curr_id=(select id from currency where name='");
                    sb.append(this.m0.getText().toString());
                    sb.append("') ,param2='");
                    sb.append(this.V.getText().toString());
                    sb.append("' where id='");
                    sb.append(this.n);
                    sb.append("'");
                    string = sb.toString();
                    str = "delete from bill_transactions2  where bill_id='" + this.n + "'";
                    str2 = "insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.n + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.Y.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.W.getText().toString().replaceAll(",", "") + "+" + this.Y.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark ,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    if (this.i.I(string, str, str2) == 0) {
                        Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_bill_no), 1).show();
                        return;
                    }
                } else {
                    string = "update bills2 set date_='" + ((Object) this.R.getText()) + "',amount='" + this.d0.getText().toString().replaceAll(",", "") + "',d_amount='" + this.Y.getText().toString().replaceAll(",", "") + "',t_val='" + this.a0.getText().toString().replaceAll(",", "") + "',tax_amount='" + this.b0.getText().toString().replaceAll(",", "") + "',cus_id=(select id from customers where name='" + ((Object) this.V.getText()) + "' ),br_id=(select id from branches where name='" + ((Object) this.T.getText()) + "' ),cash_id=(select id from customers where name='" + ((Object) this.n0.getText()) + "' ),bill_type=" + i + ",bill_no2='" + ((Object) this.v0.getText()) + "',is_back='" + (this.Q.isChecked() ? 1 : 0) + "',remarks='" + ((Object) this.w0.getText()) + "',curr_id=(select id from currency where name='" + this.m0.getText().toString() + "') ,param2='" + this.V.getText().toString() + "' where id='" + this.n + "'";
                    str = "delete from bill_transactions2  where bill_id='" + this.n + "'";
                    str2 = "insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.n + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id, ifnull(" + this.Y.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.W.getText().toString().replaceAll(",", "") + "+" + this.Y.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0) ,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    if (this.i.I(string, str, str2) == 0) {
                        Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_bill_no), 1).show();
                        return;
                    }
                }
                Log.d("sql1=h_", string);
                Log.d("sql2=h_", str);
                Log.d("sql3=h_", str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void M1(String str, String str2, String str3, String str4) {
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
            autoCompleteTextView.setOnItemClickListener(new G(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new H(autoCompleteTextView));
            this.i2 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new I());
            imageView2.setOnClickListener(new J(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new K());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new L());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new M(editText2, autoCompleteTextView, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String N0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public void N1(String str, String str2, String str3, String str4, Handler handler, int i) {
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
            autoCompleteTextView.setOnItemClickListener(new F1(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC2972a(autoCompleteTextView));
            this.i2 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new ViewOnClickListenerC2975b());
            imageView2.setOnClickListener(new ViewOnClickListenerC2978c(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2981d());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2984e());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2987f(autoCompleteTextView, alertDialogCreate, str, editText, editText2, i, handler));
        } catch (Exception unused) {
        }
    }

    public String O0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (f1(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (e1(uri)) {
                        return N0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (g1(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return N0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return N0(context, uri, null, null);
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

    public void O1(String str, String str2, String str3, String str4, String str5, String str6) {
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
            autoCompleteTextView.setOnItemClickListener(new n1(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new o1(autoCompleteTextView2, editText));
            this.i2 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new p1());
            imageView2.setOnClickListener(new q1(arrayAdapter, autoCompleteTextView));
            imageView3.setOnClickListener(new r1(arrayAdapter2, autoCompleteTextView2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new s1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new t1());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new u1(editText, autoCompleteTextView, autoCompleteTextView2, str, editText2, editText3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean P0(String str, String str2, Context context, String str3, int i) {
        S0 s0 = new S0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new T0(s0, str3, i));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new U0(s0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.I1;
    }

    public void P1() {
        TextView textView;
        if (this.p != 9 || (textView = this.p1) == null || textView.getText().toString().length() == 0 || C3966tX.j(this, this.i, true)) {
            return;
        }
        this.i.v0("update items set e_date2='" + this.p1.getText().toString() + "' where name='" + this.o1.getText().toString() + "'");
    }

    public boolean Q0(String str, String str2, Context context) {
        V0 v0 = new V0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new W0(v0));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new X0(v0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.I1;
    }

    public void Q1(String str, String str2, String str3, Handler handler) {
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
            autoCompleteTextView.setOnItemClickListener(new w1(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new x1(autoCompleteTextView));
            imageView.setOnClickListener(new y1(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new z1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new A1());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new B1(autoCompleteTextView, alertDialogCreate, str, editText, handler));
        } catch (Exception unused) {
        }
    }

    public boolean R0(String str, String str2, Context context) {
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
        return this.P1;
    }

    public void R1(String str, String str2, String str3) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_item_sales_price, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            editText.setText(str2.replace(",", ""));
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            builder.setPositiveButton("OK", new DialogInterfaceOnClickListenerC3006n());
            builder.setNegativeButton("Cancel", new DialogInterfaceOnClickListenerC3008o());
            AlertDialog alertDialogCreate = builder.create();
            this.P.isChecked();
            alertDialogCreate.setTitle(str);
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC3010p(editText, str, str3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public boolean S0(String str, String str2, Context context, String str3, String str4) {
        Y0 y0 = new Y0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2974a1(str3, str4, y0));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2977b1(y0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.I1;
    }

    public void S1(int i) {
        double dB0;
        try {
            if (this.R0) {
                return;
            }
            if (this.n1.getText().toString().trim().length() > 0) {
                dB0 = this.i.ja("prefOthers_qty_pr", false) ? this.i.b0(this.n1.getText().toString().replaceAll(",", ""), this.k1.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.k1.getTag().toString().replaceAll(",", "")) : 1.0d) : Double.parseDouble(this.n1.getText().toString().replaceAll(",", ""));
            } else {
                dB0 = 0.0d;
            }
            this.R0 = true;
            if (i == 1) {
                if (this.n1.getText().toString().trim().length() == 0) {
                    this.l1.setText("");
                } else if (this.k1.getText().toString().trim().length() > 0 && this.n1.getText().toString().trim().length() > 0) {
                    this.l1.setText(this.i.S7("" + (Double.parseDouble(this.k1.getText().toString().replaceAll(",", "")) * dB0)));
                    this.i.gc(this.n1);
                }
            } else if (i == 2) {
                if (this.k1.getText().toString().trim().length() == 0) {
                    this.l1.setText("");
                } else if (this.k1.getText().toString().trim().length() > 0 && this.n1.getText().toString().trim().length() > 0) {
                    this.l1.setText(this.i.S7("" + (Double.parseDouble(this.k1.getText().toString().replaceAll(",", "")) * dB0)));
                    this.i.gc(this.k1);
                }
            } else if (i == 3) {
                if (this.l1.getText().toString().trim().length() == 0) {
                    this.k1.setText("");
                } else if (this.l1.getText().toString().trim().length() > 0 && this.n1.getText().toString().trim().length() > 0) {
                    this.k1.setText(this.i.S7("" + (Double.parseDouble(this.l1.getText().toString().replaceAll(",", "")) / dB0)));
                    this.i.gc(this.l1);
                }
            }
            this.R0 = false;
        } catch (Exception e) {
            this.R0 = false;
            e.printStackTrace();
        }
    }

    public boolean T0(String str, String str2, Context context) {
        C c = new C();
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new D(c));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new E(c));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.O1;
    }

    public void T1(int i) {
        try {
            if (this.R0) {
                return;
            }
            this.R0 = true;
            if (i == 1) {
                if (this.s1.getText().toString().trim().length() == 0) {
                    this.r1.setText("");
                } else if (this.q1.getText().toString().trim().length() > 0 && this.s1.getText().toString().trim().length() > 0) {
                    this.r1.setText(this.i.S7("" + (Double.parseDouble(this.q1.getText().toString().replaceAll(",", "")) * Double.parseDouble(this.s1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.s1);
                }
            } else if (i == 2) {
                if (this.q1.getText().toString().trim().length() == 0) {
                    this.r1.setText("");
                } else if (this.q1.getText().toString().trim().length() > 0 && this.s1.getText().toString().trim().length() > 0) {
                    this.r1.setText(this.i.S7("" + (Double.parseDouble(this.q1.getText().toString().replaceAll(",", "")) * Double.parseDouble(this.s1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.q1);
                }
            } else if (i == 3) {
                if (this.r1.getText().toString().trim().length() == 0) {
                    this.q1.setText("");
                } else if (this.r1.getText().toString().trim().length() > 0 && this.s1.getText().toString().trim().length() > 0) {
                    this.q1.setText(this.i.S7("" + (Double.parseDouble(this.r1.getText().toString().replaceAll(",", "")) / Double.parseDouble(this.s1.getText().toString().replaceAll(",", "")))));
                    this.i.gc(this.r1);
                }
            }
            this.R0 = false;
        } catch (Exception e) {
            this.R0 = false;
            e.printStackTrace();
        }
    }

    public void U0() {
        try {
            Log.d("get_all_name=", "Yes:" + this.n);
            int i = this.n;
            if (i != 0) {
                L0(this.i.U7(String.valueOf(i), this.p + ""));
            } else {
                L0(this.i.f2());
            }
        } catch (Exception e) {
            Log.d("Fetch_error=", e.getMessage());
        }
    }

    public void V0() {
        Cursor cursorW8 = this.i.w8(this.p);
        this.I0 = new String[cursorW8.getCount()];
        if (cursorW8.moveToFirst()) {
            int i = 0;
            do {
                this.I0[i] = cursorW8.getString(cursorW8.getColumnIndex("_id"));
                i++;
            } while (cursorW8.moveToNext());
        }
        cursorW8.close();
        this.C0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.I0);
        this.V.setThreshold(1);
        this.V.setAdapter(this.C0);
    }

    public void V1(long j, String str) {
        Log.d("update_qty=", j + ":" + this.p + ":" + this.Q.isChecked() + ":" + this.J);
        new Handler().postDelayed(new T(str), 50L);
    }

    public void W0() {
        Log.d("item_remarks=", "..start...");
        C1044Xj.a().c(new RunnableC1171Zj(16, this.i, this.o1, this.m1, this, new RunnableC1086Yj()));
    }

    public void X0(String str) {
        C4143vg c4143vgQ4 = this.i.q4(str);
        if (c4143vgQ4.i().equals("")) {
            return;
        }
        this.j = c4143vgQ4.i();
        this.e2 = c4143vgQ4.j();
        this.h2 = c4143vgQ4.h();
        this.g2 = "0";
        this.f2 = c4143vgQ4.f();
    }

    public void X1() {
        int size = this.B0.size() - 1;
        if (this.B0.valueAt(size)) {
            this.i.se(this, this.x0.getItem(this.B0.keyAt(size)), this.R.getText().toString(), this.l, this.k, this.m0.getText().toString(), this);
        }
    }

    public double Y0(int i, String str) {
        if (i != 0) {
            V1(i, str);
        }
        return w0(this.o1.getText().toString(), this.l).doubleValue();
    }

    public void Y1() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_add_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.o1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            this.n1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
            this.k1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            this.l1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_remarks);
            this.m1 = autoCompleteTextView;
            this.i.cd(this, autoCompleteTextView);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price_hdr);
            this.A1 = textView;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.B1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total_hdr);
            this.w1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name_hdr);
            this.y1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_add_amount);
            TextView textView2 = this.w1;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_unit);
            this.x1 = textView3;
            textView3.setPaintFlags(textView3.getPaintFlags() | 8);
            this.l0 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode2);
            if (this.i.ja("prefOthers_barcode", false)) {
                this.l0.setVisibility(0);
            }
            TextView textView4 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_date);
            this.p1 = textView4;
            textView4.setPaintFlags(textView4.getPaintFlags() | 8);
            if (this.i.ja("prefOthers_item_end_date", false)) {
                this.p1.setVisibility(0);
                int i = this.p;
                if (i == 9) {
                    this.p1.setOnClickListener(new ViewOnClickListenerC3007n0());
                } else if (i == 8) {
                    this.p1.setOnClickListener(new ViewOnClickListenerC3009o0());
                }
            } else {
                this.p1.setVisibility(8);
            }
            this.x1.setOnClickListener(new ViewOnClickListenerC3011p0());
            E1();
            ArrayList arrayListG6 = this.i.G6();
            C2160f10.c0(this, this.o1, arrayListG6, 2);
            C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, arrayListG6, 4);
            this.y0 = c1098Yv;
            c1098Yv.l.clear();
            this.y0.notifyDataSetChanged();
            this.o1.setThreshold(1);
            this.o1.setAdapter(this.y0);
            this.n1.selectAll();
            this.k1.selectAll();
            this.o1.setOnItemClickListener(new C3013q0());
            this.o1.setOnTouchListener(new ViewOnTouchListenerC3015r0());
            this.o1.addTextChangedListener(new C3019t0());
            this.o1.setText(this.y);
            this.n1.setText(this.z);
            if (this.i.W6(this.o1.getText().toString()) > 1) {
                this.x1.setVisibility(0);
            } else {
                this.x1.setVisibility(8);
            }
            this.x1.setText(this.B);
            this.p1.setText(this.C);
            this.k1.setTag(this.D);
            if (s2 == 1) {
                this.k1.setHint(this.A);
                this.k1.setText("");
                double dY0 = Y0(this.n, this.G);
                double d = this.k1.getTag().toString().trim().length() > 0 ? Double.parseDouble(this.k1.getTag().toString().replaceAll(",", "")) : 1.0d;
                if (this.i.ja("prefOthers_qty_pr", false)) {
                    dY0 = this.i.b0(dY0 + "", d);
                }
                this.n1.setHint(String.valueOf(dY0));
                if (this.p == 9 && s2 == 1) {
                    this.p1.setText(this.i.D5(this.o1.getText().toString()));
                }
            } else {
                this.k1.setText(this.A);
                this.k1.setHint(this.A);
                double dY1 = Y0(this.n, this.G);
                if (this.k1.getTag().toString().trim().length() > 0) {
                    Double.parseDouble(this.k1.getTag().toString().replaceAll(",", ""));
                }
                if (this.i.ja("prefOthers_qty_pr", false)) {
                    this.n1.setHint(this.i.c0(String.valueOf(dY1 / Double.valueOf(this.D).doubleValue()), Double.parseDouble(this.D)) + "");
                } else {
                    this.n1.setHint(String.valueOf(C1839c10.C(dY1 / Double.valueOf(this.D).doubleValue(), C1839c10.d)));
                }
            }
            this.l1.setText(this.E);
            this.l1.setHint(this.E);
            this.m1.setText(this.F);
            if (s2 == 2) {
                this.k1.requestFocus();
            } else if (this.y.equals("")) {
                this.o1.requestFocus();
            } else {
                this.n1.requestFocus();
            }
            this.k1.selectAll();
            this.l1.selectAll();
            this.n1.selectAll();
            if (this.o1.getText().toString().length() > 0) {
                W0();
            }
            if (s2 == 2) {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new DialogInterfaceOnClickListenerC3021u0());
            } else {
                builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.add_transaction), new DialogInterfaceOnClickListenerC3023v0());
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.btn_add_close), new DialogInterfaceOnClickListenerC3025w0());
            }
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC3027x0(builder));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC3029y0(alertDialogCreate));
            alertDialogCreate.getButton(-3).setOnClickListener(new ViewOnClickListenerC3031z0(alertDialogCreate));
        } catch (Exception e) {
            Log.d("view_item_error=", ":" + e.getMessage());
        }
    }

    public double Z0(long j, String str, String str2) {
        if (j != 0) {
            V1(j, str);
        }
        return y0(this.o1.getText().toString(), this.l, str2).doubleValue();
    }

    public void a1() {
        try {
            if (getIntent().getStringExtra("TR_ID") != null) {
                this.n = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
                this.i.v0("delete from items_temp");
                this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t, price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,ifnull(e_date,'')   from bill_transactions2_v  where bill_id=" + this.n + "");
                this.u = Integer.parseInt(getIntent().getStringExtra("tran_status"));
                this.H = getIntent().getIntExtra("back_edit", 0);
                this.J = true;
            } else {
                this.J = false;
            }
            this.I = getIntent().getIntExtra("back_recyclerview", 0);
            this.H = getIntent().getIntExtra("back_edit", 0);
        } catch (Exception unused) {
        }
    }

    public void add_item(View view) {
        this.y = "";
        this.A = "";
        this.E = "";
        this.z = "";
        this.F = "";
        if (this.j1.getText() == null || this.j1.getText().toString().equals("")) {
            this.y = "";
            this.A = "";
            this.E = "";
            this.z = "";
            this.F = "";
        } else if (this.i.F6().contains(this.j1.getText().toString())) {
            double dJ6 = this.i.J6(this.j1.getText().toString(), this.m0.getText().toString(), this.p, this.Q.isChecked(), this.V0 + "", this.p, this.i.X6(this.j1.getText().toString()));
            this.y = this.j1.getText().toString();
            this.A = dJ6 > 0.0d ? this.i.S7(String.valueOf(dJ6)) : "";
            V1(this.n, this.G);
        } else {
            this.y = this.j1.getText().toString();
        }
        s2 = 1;
        Y1();
    }

    public void add_item2(View view) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_item_edit2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new A0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new B0(viewInflate));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new C0(autoCompleteTextView, viewInflate, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item2_error=", e.getMessage());
        }
    }

    public void b1() {
        Log.d("back_edit=", this.H + ":" + this.m2 + ":" + this.p2 + ":" + this.I);
        if (this.H == 1 && this.X1) {
            t2 = true;
            u2 = true;
            v2 = this.V.getText().toString();
            Z00.o0 = false;
            finish();
            return;
        }
        if (this.m2 && this.p2 != 2) {
            this.m2 = false;
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr ,ifnull(e_date,'')  from bill_transactions2  where bill_id=" + this.n + "");
            return;
        }
        int i = this.p;
        if (i == 9) {
            t2 = false;
            Intent intent = new Intent(this, (Class<?>) Orders.class);
            intent.addFlags(67141632);
            intent.addFlags(1073741824);
            intent.putExtra("TR_TYPE", "9");
            intent.putExtra("g_id", this.k);
            intent.putExtra("g_name", this.l);
            startActivity(intent);
            finish();
            return;
        }
        if (i == 2) {
            t2 = false;
            Intent intent2 = new Intent(this, (Class<?>) Bills2.class);
            intent2.addFlags(67141632);
            intent2.addFlags(1073741824);
            intent2.putExtra("TR_TYPE", "2");
            intent2.putExtra("g_id", this.k);
            intent2.putExtra("g_name", this.l);
            startActivity(intent2);
            finish();
        }
    }

    public void barcode_click(View view) {
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.v1 = 1;
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.v1 = 2;
        }
        if (this.i.ia("pref_barcode_type", "1").equals("1")) {
            this.i.Td(this);
            return;
        }
        Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.usb_barcode), 0).show();
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode) {
            this.j1.requestFocus();
        } else if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.o1.requestFocus();
        }
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.page_name);
        a aVarA = a.a(textView.getText().toString());
        this.a1 = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_hide(View view) {
        this.s0.setVisibility(8);
        this.t0.setVisibility(0);
        this.q0.setVisibility(0);
        J1();
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.no_);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new Q0(textView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new R0());
        builder.create().show();
    }

    public void btn_item_show(View view) {
        this.s0.setVisibility(0);
        this.q0.setVisibility(4);
        this.j1.requestFocus();
        J1();
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
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new O0(textView, imageView));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new P0());
        builder.create().show();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        if (getWindow() != null) {
            return getWindow().getCurrentFocus();
        }
        return null;
    }

    public void h1(String str) {
        this.j1.setText(str);
        this.y = this.j1.getText().toString();
        this.A = "";
        this.E = "";
        this.z = "";
        this.F = "";
        this.B = "";
        this.C = "";
        this.D = "1";
        String strX6 = this.i.X6(this.j1.getText().toString());
        double dJ6 = this.i.J6(str, this.m0.getText().toString(), this.p, this.Q.isChecked(), this.V0 + "", this.p, strX6);
        this.A = dJ6 > 0.0d ? this.i.S7(String.valueOf(dJ6)) : "";
        this.B = this.i.X6(this.j1.getText().toString());
        this.D = String.valueOf(this.i.Z6(this.j1.getText().toString(), this.B));
        V1(this.n, this.G);
        s2 = 1;
        Y1();
    }

    public void i1(String str) {
        this.o1.setText(str);
        this.n1.requestFocus();
        double dJ6 = this.i.J6(str, this.m0.getText().toString(), this.p, this.Q.isChecked(), this.V0 + "", this.p, this.i.X6(this.o1.getText().toString()));
        this.k1.setHint(dJ6 > 0.0d ? this.i.S7(String.valueOf(dJ6)) : "");
        this.x1.setText(this.i.X6(this.o1.getText().toString()));
        if (this.i.W6(this.o1.getText().toString()) > 1) {
            this.x1.setVisibility(0);
        } else {
            this.x1.setVisibility(8);
        }
        if (this.p == 8 && this.i.ja("prefOthers_item_end_date", false)) {
            this.p1.setVisibility(0);
        }
        this.k1.setTag("1");
        this.n1.selectAll();
        this.k1.selectAll();
        W0();
    }

    public void k1() {
        this.m2 = true;
        s0(2, this.p);
        this.r2 = 2;
    }

    public void l0(Handler handler, String str, int i) {
        N1("", str.trim(), "", "", handler, i);
    }

    public void l1() {
        int i = this.n;
        this.V0 = i;
        this.W0 = i;
        this.Q.setEnabled(false);
        W1();
        this.n = 0;
        this.w0.setText(getString(info.aalmoghalis.inventory.R.string.bill_back_remarks) + this.v0.getText().toString());
        this.v0.setText("");
        u1();
        Calendar calendar = Calendar.getInstance();
        this.R.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.K = calendar.get(1);
        this.L = calendar.get(2);
        this.M = calendar.get(5);
        this.c1 = 1;
        U0();
        this.i.v0("delete from items_temp");
        k1();
        this.c1 = 1;
        U0();
        V1(this.n, "0");
    }

    public void m0(Handler handler) {
        Q1("", this.o1.getText().toString(), "", handler);
    }

    public void more_item(View view) {
        this.i.te(this, this.o1.getText().toString(), this.l, this.m0.getText().toString(), w0(this.o1.getText().toString(), this.l).doubleValue(), this.Q.isChecked(), this.V0, this.p, this.x1.getText().toString());
    }

    public void n0(String str, String str2, Handler handler) {
        String strS7 = "";
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_purchase_view, (ViewGroup) null);
            builder.setView(viewInflate);
            this.u1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.p_tr_name);
            this.t1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_name);
            this.s1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
            this.q1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            this.r1 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
            this.U = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_date_p);
            this.J1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price_hdr);
            this.K1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total_hdr);
            this.L1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
            this.M1 = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
            G1();
            this.u1.setThreshold(1);
            this.u1.setAdapter(this.C0);
            this.u1.requestFocus();
            this.t1.setText(str);
            this.s1.setText(str2);
            double dJ6 = this.i.J6(str, this.m0.getText().toString(), 2, this.Q.isChecked(), this.V0 + "", this.p, "");
            EditText editText = this.q1;
            if (dJ6 > 0.0d) {
                strS7 = this.i.S7(String.valueOf(dJ6));
            }
            editText.setHint(strS7);
            this.s1.selectAll();
            this.q1.selectAll();
            this.u1.setOnItemClickListener(new C2980c1());
            this.u1.setOnTouchListener(new ViewOnTouchListenerC2983d1());
            this.u1.addTextChangedListener(new C2986e1());
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.add_transaction), new DialogInterfaceOnClickListenerC2989f1());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2992g1(builder));
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2995h1(handler, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_purchase_error=", ":" + e.getMessage());
        }
    }

    public void n1(String str) {
        try {
            C0809Ov c0809Ov = this.x0;
            if (c0809Ov != null) {
                c0809Ov.getFilter().filter(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void o0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        EditText editText;
        try {
            if (i2 != 0) {
                if (i == 2) {
                    if (intent != null && (editText = this.l1) != null) {
                        editText.setText(this.i.S7(intent.getStringExtra("calc_result")));
                        this.m1.requestFocus();
                    }
                } else if (i == 1) {
                    if (i2 == -1) {
                        Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                        this.i2.setText(string);
                        cursorQuery.close();
                        Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                    }
                } else if (i == this.a2 && intent != null) {
                    o1(intent.getData(), false);
                } else if (i == this.Z1) {
                    m1(intent);
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
                            this.i.j1(activityResult.getContents(), this, this.y0);
                        }
                        if (strI6.equals("") && !Z00.P0) {
                            return;
                        }
                        if (Z00.P0) {
                            strI6 = this.i.I6(activityResult.getContents());
                        }
                        int i3 = this.v1;
                        if (i3 == 1) {
                            h1(strI6);
                        } else if (i3 == 2) {
                            i1(strI6);
                        }
                        this.v1 = 0;
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
        Log.d("onback=", this.n + ":" + this.r2 + ":" + this.H);
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "edit")) {
                Context context = this.b1;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                this.r2 = 0;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "new")) {
            Context context2 = this.b1;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            this.r2 = 0;
        }
        int i = this.r2;
        if (i == 1) {
            this.q2 = 1;
            F0();
        } else if (i == 2) {
            y1();
        } else if (this.n != 0) {
            y1();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_order_edit);
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        z00.v0("delete from items_temp");
        a1();
        if (this.n != 0) {
            setContentView(info.aalmoghalis.inventory.R.layout.content_order_det);
            this.Z = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name_hdr);
            this.p2 = 0;
        } else {
            this.p2 = 1;
        }
        this.Q = (CheckBox) findViewById(info.aalmoghalis.inventory.R.id.chk_back);
        this.L0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_header);
        this.M0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_footer);
        this.N0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_item_header);
        this.N = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_items);
        this.P = (SwitchCompat) findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
        this.Q.setOnCheckedChangeListener(new H1());
        TextView textView = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_curr_price);
        this.S = textView;
        textView.setHint("");
        this.T = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_branch);
        this.R = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_date);
        this.V = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.tr_name);
        this.u0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.item_status_hdr);
        this.W = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot);
        this.X = (TextView) findViewById(info.aalmoghalis.inventory.R.id.count);
        this.Y = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tot_disc);
        this.h0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr);
        this.j0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_add);
        this.k0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode);
        if (this.i.ja("prefOthers_barcode", false)) {
            this.k0.setVisibility(0);
        }
        this.v0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_no);
        this.w0 = (EditText) findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
        this.r0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.root_layout);
        this.s0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.item_add_hdr);
        this.t0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.bill_items_list_hdr);
        this.q0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.page_add);
        this.O0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        if (this.n != 0) {
            this.t0.setVisibility(0);
        }
        this.a0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_tax_val);
        this.b0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tax_amount);
        this.c0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_hdr_tax2);
        this.d0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tr_bill_tot);
        this.e0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.bill_tot_bill_hdr);
        this.f0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
        this.g0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.LL_tax);
        this.a0.setText((CharSequence) this.f0.getItem(0));
        if (this.a0.getText().toString().equals("0") || this.n == 0) {
            this.b0.setVisibility(4);
            this.c0.setVisibility(4);
            this.e0.setVisibility(4);
            this.d0.setVisibility(4);
        }
        this.m0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_curr);
        this.n0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_cash);
        this.j1 = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        this.D0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.s3());
        this.m0.setText(this.i.l3("0"));
        TextView textView2 = this.m0;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        this.m0.setOnClickListener(new W());
        this.E0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.A2());
        TextView textView3 = this.T;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        this.T.setOnClickListener(new ViewOnClickListenerC2994h0());
        this.F0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.D3());
        TextView textView4 = this.n0;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        this.n0.setText(this.i.B3().j());
        this.n0.setOnClickListener(new ViewOnClickListenerC3017s0());
        this.N.setOnItemClickListener(new D0());
        this.N.setChoiceMode(3);
        this.N.setMultiChoiceModeListener(new E0());
        this.P.setOnCheckedChangeListener(new Z0());
        Calendar calendar = Calendar.getInstance();
        this.R.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
        this.K = calendar.get(1);
        this.L = calendar.get(2);
        this.M = calendar.get(5);
        this.R.setOnClickListener(new k1());
        this.V.setOnItemClickListener(new v1());
        this.V.setOnTouchListener(new G1());
        this.V.addTextChangedListener(new C3000k());
        I1(true);
        w1();
        u1();
        U1();
        this.V.requestFocus();
        if (getIntent().getStringExtra("TR_ID") != null && C2160f10.h > 0 && !new C2160f10(this.i).l("30", "edit")) {
            this.V.setEnabled(false);
            this.T.setEnabled(false);
            this.R.setEnabled(false);
            this.n0.setEnabled(false);
            this.m0.setEnabled(false);
            this.Q.setEnabled(false);
            this.w0.setEnabled(false);
            this.v0.setEnabled(false);
        }
        if (this.n == 0) {
            getWindow().setSoftInputMode(4);
        } else {
            getWindow().setSoftInputMode(2);
        }
        a1();
        U0();
        V1(this.n, "0");
        W1();
        H0();
        this.w0.addTextChangedListener(this.Q0);
        this.w0.setOnClickListener(new ViewOnClickListenerC3022v());
        this.v0.addTextChangedListener(this.Q0);
        this.v0.setOnClickListener(new F());
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(d1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.T1, this.K, this.L, this.M);
        }
        if (i == 4) {
            return new DatePickerDialog(d1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.U1, this.K, this.L, this.M);
        }
        if (i != 5) {
            return null;
        }
        return new DatePickerDialog(d1() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.V1, this.K, this.L, this.M);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_bill3_print3, menu);
        menu.findItem(info.aalmoghalis.inventory.R.id.bill_prin).setVisible(this.n != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.share).setVisible(this.n != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.search).setVisible(this.n != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(this.n != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.printing).setVisible(this.n != 0);
        menu.findItem(info.aalmoghalis.inventory.R.id.offer_bill).setVisible(this.n != 0);
        int i = C2160f10.h;
        if (i > 0 && this.n != 0) {
            MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.bill_submit);
            MenuItem menuItemFindItem2 = menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove);
            MenuItem menuItemFindItem3 = menu.findItem(info.aalmoghalis.inventory.R.id.offer_bill);
            boolean zL = new C2160f10(this.i).l("30", "edit");
            boolean zL2 = new C2160f10(this.i).l("30", HTML.Tag.DEL);
            boolean zL3 = new C2160f10(this.i).l("-7", "new");
            menuItemFindItem.setVisible(zL);
            menuItemFindItem2.setVisible(zL2);
            menuItemFindItem3.setVisible(zL3);
        } else if (i > 0 && this.n == 0) {
            menu.findItem(info.aalmoghalis.inventory.R.id.bill_remove).setVisible(new C2160f10(this.i).l("30", HTML.Tag.DEL));
        }
        this.S1 = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        this.S1.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.S1.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.S1.setOnQueryTextListener(new C2993h());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        L0(this.i.L2());
        I1(true);
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
            s0(1, this.p);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_submit) {
            if (this.p2 == 2) {
                this.p2 = 0;
            }
            this.m2 = false;
            this.X1 = true;
            s0(2, this.p);
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_remove) {
            r0();
        } else if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin || menuItem.getItemId() == info.aalmoghalis.inventory.R.id.share) {
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.bill_prin) {
                this.l2 = 1;
            } else {
                this.l2 = 2;
            }
            if (this.n == 0) {
                F0();
                return true;
            }
            r1(this.l2);
        } else {
            if (menuItem.getItemId() == 16908332) {
                onBackPressed();
                return true;
            }
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.printing) {
                Log.d("thermal=", this.n + ":" + this.r2 + ":" + this.H);
                if (this.r2 == 1) {
                    this.q2 = 0;
                    s0(2, this.p);
                }
                Intent intent = new Intent(this, (Class<?>) (this.i.ja("prefThermalBluetooth", true) ? MainActivity.class : MainActivity2.class));
                intent.putExtra("TR_ID", this.n + "");
                intent.putExtra("TR_TYPE", this.p + "");
                Z00.j0.clear();
                Z00.j0.add(new String[]{this.n + "", this.R.getText().toString()});
                startActivity(intent);
                return true;
            }
            if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.offer_bill) {
                Log.d("offer_bill=", this.n + ":" + this.r2 + ":" + this.H);
                if (this.r2 == 1) {
                    this.q2 = 0;
                    s0(2, this.p);
                }
                if (this.n != 0) {
                    Intent intent2 = new Intent(this, (Class<?>) Bill_edit.class);
                    intent2.putExtra("TR_TYPE", String.valueOf(2));
                    intent2.putExtra("g_id", this.k);
                    intent2.putExtra("g_name", this.l);
                    intent2.putExtra("bill_offer_id", this.n + "");
                    intent2.putExtra("tr_name", this.V.getText().toString());
                    intent2.putExtra("tr_name", this.V.getText().toString());
                    intent2.putExtra("tr_branch", this.T.getText().toString());
                    intent2.putExtra("bill_disc_id", this.E1);
                    intent2.putExtra("bill_disc_val", this.F1);
                    intent2.putExtra("bill_total_", this.W.getText().toString().replaceAll(",", ""));
                    intent2.putExtra("bill_total_disc", this.Y.getText().toString().replaceAll(",", ""));
                    intent2.putExtra("curr_name", this.m0.getText().toString());
                    intent2.putExtra("tax_val", this.a0.getText().toString().replaceAll(",", ""));
                    intent2.putExtra("tax_amount", this.b0.getText().toString().replaceAll(",", ""));
                    startActivity(intent2);
                }
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
            if (this.n == 0 || this.m0.getText().toString().equals(radioButton.getText().toString())) {
                this.m0.setTag(radioButton.getText().toString());
                U0();
            } else {
                this.i.v0("delete from items_temp");
                this.c1 = 1;
                this.r2 = 1;
                this.m0.setTag(radioButton.getText().toString());
                U0();
                H0();
                V1(this.n, "0");
            }
            Log.d("radio_checked:=", radioButton.getText().toString() + ":" + this.w);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.p2 != 2 || this.n == 0) {
            return;
        }
        b1();
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
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void p1() throws Throwable {
        String string;
        Z00 z00 = this.i;
        ListView listView = this.N;
        String strIc = z00.ic(this.K0);
        if (this.v0.getText().length() == 0) {
            string = this.n + "";
        } else {
            string = this.v0.getText().toString();
        }
        z00.Na(listView, strIc, string, this.R.getText().toString(), this.V.getHint().toString(), this.V.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total), this.W.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_disc), this.Y.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_tax) + " - " + this.a0.getText().toString() + CSS.Value.PERCENTAGE, this.b0.getText().toString(), "", "0", getString(info.aalmoghalis.inventory.R.string.paid_amount), "0", getString(info.aalmoghalis.inventory.R.string.remain_amount), "0", true, 5, this.w0.getText().toString(), this.m0.getText().toString(), this.X.getText().toString(), this.i.ja("prefOthers_print_end_date", false), this.T.getText().toString(), this.p);
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void q0(View view, boolean z) {
        if (z) {
            C1();
        } else {
            J0();
        }
    }

    public void q1() {
        String string;
        Z00 z00 = this.i;
        ListView listView = this.N;
        String strIc = z00.ic(this.K0);
        if (this.v0.getText().length() == 0) {
            string = this.n + "";
        } else {
            string = this.v0.getText().toString();
        }
        z00.Ya(listView, strIc, string, this.R.getText().toString(), this.V.getHint().toString(), this.V.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total), this.d0.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_disc), this.Y.getText().toString(), getString(info.aalmoghalis.inventory.R.string.total_tax) + " - " + this.a0.getText().toString() + CSS.Value.PERCENTAGE, this.b0.getText().toString(), "", "0", "", "0", "", "0", true, 5, this.w0.getText().toString(), this.m0.getText().toString(), this.X.getText().toString(), this.p, this.i.ja("prefOthers_print_end_date", false), this.T.getText().toString());
    }

    public void r0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new O());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new P());
        builder.create().show();
    }

    public void r1(int i) {
        String str;
        if (i == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle().toString());
        if (this.V.getText().toString() == null) {
            str = "";
        } else {
            str = "#" + this.V.getText().toString();
        }
        sb.append(str);
        this.K0 = sb.toString();
        if (this.l2 != 1) {
            this.l2 = 0;
            H1();
            return;
        }
        o0();
        q1();
        this.i.ra(this.i.ic(this.K0) + ".pdf");
    }

    public void s0(int i, int i2) {
        String str;
        String string;
        String str2;
        String str3;
        String string2;
        String string3;
        try {
            C2160f10.h = MO.b(this);
            Log.d("bill_save=", this.n + ":" + this.V.getText().toString());
            if (v0()) {
                if (!this.V.getText().toString().equals(this.V.getText().toString().trim()) && this.i.v8(this.V.getText().toString().trim(), this.p).getCount() > 0) {
                    AutoCompleteTextView autoCompleteTextView = this.V;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                }
                this.i.D = false;
                if (this.m0.getText() != null && !this.m0.getText().toString().equals(this.i.l3("0")) && this.i.Z2(this.m0.getText().toString(), this.R.getText().toString()) == 0) {
                    this.i.u(this, this.m0.getText().toString(), this.R.getText().toString(), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
                    if (!this.i.D) {
                        return;
                    }
                }
                if (this.i.g2().getCount() == 0) {
                    this.j0.performClick();
                    return;
                }
                if (this.n == 0) {
                    int iV1 = this.i.V1();
                    int iW1 = this.i.W1(this.p, this.k);
                    this.v0.setHint(getString(info.aalmoghalis.inventory.R.string.bill_no2) + iW1);
                    int i3 = this.P.isChecked() ? 1 : 2;
                    int i4 = this.p;
                    str = ":";
                    if (i4 == 2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into bills2 (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,param1,t_val,tax_amount,user_id) values(");
                        sb.append(iV1);
                        sb.append(",");
                        sb.append(i2);
                        sb.append(",'");
                        sb.append((Object) this.R.getText());
                        sb.append("','");
                        sb.append(this.W.getText().toString().replaceAll(",", ""));
                        sb.append("','");
                        sb.append(this.Y.getText().toString().replaceAll(",", ""));
                        sb.append("',(select id from customers where name='");
                        sb.append((Object) this.V.getText());
                        sb.append("'  ),");
                        sb.append(i);
                        sb.append(",");
                        sb.append(i3);
                        sb.append(",'");
                        if (this.v0.getText().toString().length() == 0) {
                            string3 = iW1 + "";
                        } else {
                            string3 = this.v0.getText().toString();
                        }
                        sb.append(string3);
                        sb.append("','");
                        sb.append((Object) this.w0.getText());
                        sb.append("',(select id from currency where name='");
                        sb.append(this.m0.getText().toString());
                        sb.append("') ,(select id from branches where name='");
                        sb.append(this.T.getText().toString());
                        sb.append("'),(select id from customers where name='");
                        sb.append(this.n0.getText().toString());
                        sb.append("'),");
                        sb.append(this.Q.isChecked() ? 1 : 0);
                        sb.append(",");
                        sb.append(!this.Q.isChecked() ? "0" : Integer.valueOf(this.V0));
                        sb.append(",'");
                        sb.append(this.O0.getTag() != null ? this.O0.getTag().toString() : "");
                        sb.append("','");
                        sb.append(this.a0.getText().toString().replaceAll(",", ""));
                        sb.append("','");
                        sb.append(this.b0.getText().toString().replaceAll(",", ""));
                        sb.append("',");
                        int i5 = C2160f10.h;
                        sb.append(i5 == -1 ? "null" : Integer.valueOf(i5));
                        sb.append(")");
                        string = sb.toString();
                        str2 = "insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + iV1 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.Y.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.W.getText().toString().replaceAll(",", "") + "+" + this.Y.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark,b.unit_id,b.u_val,b.base_unit,qty_pr ,e_date  from items_temp b ";
                    } else if (i4 == 9) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("insert into bills2(id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,param2,t_val,tax_amount,user_id) values(");
                        sb2.append(iV1);
                        sb2.append(",");
                        sb2.append(i2);
                        sb2.append(",'");
                        sb2.append((Object) this.R.getText());
                        sb2.append("','");
                        sb2.append(this.W.getText().toString().replaceAll(",", ""));
                        sb2.append("','");
                        sb2.append(this.Y.getText().toString().replaceAll(",", ""));
                        sb2.append("',(select id from customers where name='");
                        sb2.append((Object) this.V.getText());
                        sb2.append("'  ),");
                        sb2.append(i);
                        sb2.append(",");
                        sb2.append(i3);
                        sb2.append(",'");
                        if (this.v0.getText().toString().length() == 0) {
                            string2 = iW1 + "";
                        } else {
                            string2 = this.v0.getText().toString();
                        }
                        sb2.append(string2);
                        sb2.append("','");
                        sb2.append((Object) this.w0.getText());
                        sb2.append("',(select id from currency where name='");
                        sb2.append(this.m0.getText().toString());
                        sb2.append("'),(select id from branches where name='");
                        sb2.append(this.T.getText().toString());
                        sb2.append("'),(select id from customers where name='");
                        sb2.append(this.n0.getText().toString());
                        sb2.append("'),");
                        sb2.append(this.Q.isChecked() ? 1 : 0);
                        sb2.append(",");
                        sb2.append(!this.Q.isChecked() ? "0" : Integer.valueOf(this.V0));
                        sb2.append(",'");
                        sb2.append(this.V.getText().toString());
                        sb2.append("','");
                        sb2.append(this.a0.getText().toString().replaceAll(",", ""));
                        sb2.append("','");
                        sb2.append(this.b0.getText().toString().replaceAll(",", ""));
                        sb2.append("',");
                        int i6 = C2160f10.h;
                        sb2.append(i6 == -1 ? "null" : Integer.valueOf(i6));
                        sb2.append(" )");
                        string = sb2.toString();
                        str2 = "insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + iV1 + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.Y.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.W.getText().toString().replaceAll(",", "") + "+" + this.Y.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                    } else {
                        string = "";
                        str2 = string;
                    }
                    if (this.i.H(string, str2) == 0) {
                        Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_bill_no), 1).show();
                        return;
                    }
                    this.i.v0("delete from items_temp");
                    this.n = iV1;
                    str3 = "";
                } else {
                    str = ":";
                    u1();
                    int i7 = this.P.isChecked() ? 1 : 2;
                    int i8 = this.p;
                    if (i8 == 2) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("update bills2 set date_='");
                        sb3.append((Object) this.R.getText());
                        sb3.append("',amount='");
                        sb3.append(this.d0.getText().toString().replaceAll(",", ""));
                        sb3.append("',d_amount='");
                        sb3.append(this.Y.getText().toString().replaceAll(",", ""));
                        sb3.append("',t_val='");
                        sb3.append(this.a0.getText().toString().replaceAll(",", ""));
                        sb3.append("',tax_amount='");
                        sb3.append(this.b0.getText().toString().replaceAll(",", ""));
                        sb3.append("',cus_id=(select id from customers where name='");
                        sb3.append((Object) this.V.getText());
                        sb3.append("' ),br_id=(select id from branches where name='");
                        sb3.append((Object) this.T.getText());
                        sb3.append("' ),cash_id=(select id from customers where name='");
                        sb3.append((Object) this.n0.getText());
                        sb3.append("' ),bill_type=");
                        sb3.append(i7);
                        sb3.append(",bill_no2='");
                        sb3.append((Object) this.v0.getText());
                        sb3.append("',is_back='");
                        sb3.append(this.Q.isChecked() ? 1 : 0);
                        sb3.append("',remarks='");
                        sb3.append(this.w0.getText().toString());
                        sb3.append("',param1='");
                        sb3.append(this.O0.getTag() != null ? this.O0.getTag().toString() : "");
                        sb3.append("',curr_id=(select id from currency where name='");
                        sb3.append(this.m0.getText().toString());
                        sb3.append("') ,tran_status=");
                        sb3.append(i);
                        sb3.append(" where id='");
                        sb3.append(this.n);
                        sb3.append("'");
                        string = sb3.toString();
                        str2 = "delete from bill_transactions2  where bill_id='" + this.n + "'";
                        str3 = "insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.n + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id ,ifnull(" + this.Y.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.W.getText().toString().replaceAll(",", "") + "+" + this.Y.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0),b.remark ,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                        if (this.i.I(string, str2, str3) == 0) {
                            Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_bill_no), 1).show();
                            return;
                        }
                        if (!this.X1) {
                            this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                    } else if (i8 == 9) {
                        string = "update bills2 set date_='" + ((Object) this.R.getText()) + "',amount='" + this.d0.getText().toString().replaceAll(",", "") + "',d_amount='" + this.Y.getText().toString().replaceAll(",", "") + "',t_val='" + this.a0.getText().toString().replaceAll(",", "") + "',tax_amount='" + this.b0.getText().toString().replaceAll(",", "") + "',cus_id=(select id from customers where name='" + ((Object) this.V.getText()) + "' ),br_id=(select id from branches where name='" + ((Object) this.T.getText()) + "' ),cash_id=(select id from customers where name='" + ((Object) this.n0.getText()) + "' ),bill_type=" + i7 + ",bill_no2='" + ((Object) this.v0.getText()) + "',is_back='" + (this.Q.isChecked() ? 1 : 0) + "',remarks='" + this.w0.getText().toString() + "',param2='" + this.V.getText().toString() + "',curr_id=(select id from currency where name='" + this.m0.getText().toString() + "') ,tran_status=" + i + " where id='" + this.n + "'";
                        str2 = "delete from bill_transactions2  where bill_id='" + this.n + "'";
                        str3 = "insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,d_amount,remark,unit_id,u_val,base_unit,qty_pr,e_date)  select " + this.n + ",b.item_id ,b.item_type_id ,b.qty,qty_t ,b.price ,b.curr_id, ifnull(" + this.Y.getText().toString().replaceAll(",", "") + "*(qty_pr*price*u_val/(" + this.W.getText().toString().replaceAll(",", "") + "+" + this.Y.getText().toString().replaceAll(",", "") + "))/(b.qty_t),0) ,b.remark,b.unit_id,b.u_val,base_unit,qty_pr ,e_date  from items_temp b ";
                        if (this.i.I(string, str2, str3) == 0) {
                            Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_bill_no), 1).show();
                            return;
                        }
                        if (!this.X1) {
                            this.i.Kd(this, getString(info.aalmoghalis.inventory.R.string.doc_saved), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                        }
                    } else {
                        string = "";
                        str2 = string;
                        str3 = str2;
                    }
                }
                Log.d("sql1=", string);
                Log.d("sql2=", str2);
                Log.d("sql3=", str3);
                H0();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.p2);
                String str4 = str;
                sb4.append(str4);
                sb4.append(this.n);
                sb4.append(str4);
                sb4.append(this.m2);
                Log.d("isnew=", sb4.toString());
                if (this.n == 0 || this.p2 != 2 || this.P.isChecked()) {
                    this.i.v0("delete from items_temp");
                    b1();
                    return;
                }
                this.r2 = 0;
                t2 = true;
                X0(this.V.getText().toString());
                if (this.e2 == null || !this.i.ja("prefAutoNotify", false)) {
                    b1();
                } else {
                    z1();
                    U0();
                }
            }
        } catch (Exception e) {
            Log.d("bill_save_error", e.getMessage() + "");
            Toast.makeText(this, "" + getString(info.aalmoghalis.inventory.R.string.alarm_bill_no), 1).show();
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0165 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0167 A[Catch: Exception -> 0x0055, TryCatch #1 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x005a, B:16:0x0074, B:18:0x0088, B:20:0x009c, B:22:0x00b0, B:26:0x00cc, B:28:0x0129, B:35:0x014c, B:36:0x0159, B:40:0x0167, B:42:0x0181), top: B:84:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0181 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #1 {Exception -> 0x0055, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x0035, B:10:0x0049, B:13:0x005a, B:16:0x0074, B:18:0x0088, B:20:0x009c, B:22:0x00b0, B:26:0x00cc, B:28:0x0129, B:35:0x014c, B:36:0x0159, B:40:0x0167, B:42:0x0181), top: B:84:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:49:0x01db  */
    /* JADX WARN: Code duplicated, block: B:51:0x01e0 A[Catch: Exception -> 0x01d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d8, blocks: (B:44:0x01ce, B:51:0x01e0, B:56:0x0241, B:60:0x02a0, B:65:0x02b3, B:68:0x02cd, B:70:0x0389, B:73:0x039a, B:74:0x03b8, B:76:0x03d5, B:64:0x02af, B:59:0x029a), top: B:82:0x01ce }] */
    /* JADX WARN: Code duplicated, block: B:54:0x023e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0240  */
    /* JADX WARN: Code duplicated, block: B:58:0x0297  */
    /* JADX WARN: Code duplicated, block: B:59:0x029a A[Catch: Exception -> 0x01d8, TryCatch #0 {Exception -> 0x01d8, blocks: (B:44:0x01ce, B:51:0x01e0, B:56:0x0241, B:60:0x02a0, B:65:0x02b3, B:68:0x02cd, B:70:0x0389, B:73:0x039a, B:74:0x03b8, B:76:0x03d5, B:64:0x02af, B:59:0x029a), top: B:82:0x01ce }] */
    /* JADX WARN: Code duplicated, block: B:63:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x02af A[Catch: Exception -> 0x01d8, TRY_ENTER, TryCatch #0 {Exception -> 0x01d8, blocks: (B:44:0x01ce, B:51:0x01e0, B:56:0x0241, B:60:0x02a0, B:65:0x02b3, B:68:0x02cd, B:70:0x0389, B:73:0x039a, B:74:0x03b8, B:76:0x03d5, B:64:0x02af, B:59:0x029a), top: B:82:0x01ce }] */
    /* JADX WARN: Code duplicated, block: B:67:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x03d5 A[Catch: Exception -> 0x01d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d8, blocks: (B:44:0x01ce, B:51:0x01e0, B:56:0x0241, B:60:0x02a0, B:65:0x02b3, B:68:0x02cd, B:70:0x0389, B:73:0x039a, B:74:0x03b8, B:76:0x03d5, B:64:0x02af, B:59:0x029a), top: B:82:0x01ce }] */
    /* JADX WARN: Code duplicated, block: B:78:0x03da  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x0181, please report this as an issue */
    public boolean s1() {
        String str;
        double dIc;
        String str2;
        double d;
        String str3;
        String str4;
        Object objValueOf;
        int i;
        String string;
        Object objValueOf2;
        String string2;
        String string3;
        try {
            C2160f10.h = MO.b(this);
            boolean zA = AbstractC4371yX.a(this.s1);
            if (!AbstractC4371yX.a(this.u1)) {
                zA = false;
            }
            if (this.q1.getText().toString().trim().length() == 0 && this.r1.getText().toString().trim().length() == 0) {
                AbstractC4371yX.a(this.q1);
                AbstractC4371yX.a(this.r1);
                zA = false;
            }
            double d2 = this.q1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.q1.getText().toString().replaceAll(",", "")) : 0.0d;
            double d3 = this.r1.getText().toString().trim().length() > 0 ? Double.parseDouble(this.r1.getText().toString().replaceAll(",", "")) : 0.0d;
            double d4 = Double.parseDouble(this.s1.getText().toString().replaceAll(",", ""));
            if (d2 > 0.0d && d3 > 0.0d) {
                str2 = "";
                String strS7 = this.i.S7(this.q1.getText().toString().replaceAll(",", str2));
                Z00 z00 = this.i;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                dIc = d2;
                str = "'";
                sb.append(Double.parseDouble(this.r1.getText().toString().replaceAll(",", str2)) / Double.parseDouble(this.s1.getText().toString().replaceAll(",", str2)));
                if (!strS7.equals(z00.S7(sb.toString()))) {
                    this.r1.setError(getString(info.aalmoghalis.inventory.R.string.total_not_correct));
                    d = 0.0d;
                    zA = false;
                }
                if (d3 >= d && d4 > d) {
                    dIc = this.i.Ic(String.valueOf(d3 / d4));
                }
                if (this.u1.getText().length() == 0) {
                    return false;
                }
                this.I1 = true;
                if (this.i.v8(this.u1.getText().toString(), 2).getCount() == 0) {
                    AutoCompleteTextView autoCompleteTextView = this.u1;
                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
                    this.I1 = false;
                    str3 = str2;
                    try {
                        P0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.u1.getText().toString(), this, this.u1.getText().toString(), 2);
                        if (!this.I1) {
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
                int iV1 = this.i.V1();
                int iW1 = this.i.W1(9, this.k);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("insert into bills2 (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,user_id) values(");
                sb2.append(iV1);
                sb2.append(",");
                sb2.append(2);
                sb2.append(",'");
                sb2.append(this.U.getText().toString());
                sb2.append("','");
                sb2.append(String.valueOf(dIc * d4));
                sb2.append("','0',(select id from customers where name='");
                sb2.append((Object) this.u1.getText());
                sb2.append("'  ),2,");
                if (this.M1.isChecked()) {
                    str4 = "1";
                } else {
                    str4 = "2";
                }
                sb2.append(str4);
                sb2.append(",'");
                sb2.append(iW1);
                sb2.append("','',(select id from currency where name='");
                sb2.append(this.m0.getText().toString());
                sb2.append("') ,(select id from branches where name='");
                sb2.append(this.T.getText().toString());
                sb2.append("'),(select id from customers where name='");
                sb2.append(this.n0.getText().toString());
                sb2.append("'),");
                sb2.append(this.Q.isChecked() ? 1 : 0);
                sb2.append(",");
                if (this.Q.isChecked()) {
                    objValueOf = Integer.valueOf(this.V0);
                } else {
                    objValueOf = "0";
                }
                sb2.append(objValueOf);
                sb2.append(",");
                i = C2160f10.h;
                string = "null";
                if (i == -1) {
                    objValueOf2 = "null";
                } else {
                    objValueOf2 = Integer.valueOf(i);
                }
                sb2.append(objValueOf2);
                sb2.append(")");
                string2 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.M1.isChecked() ? "1" : "2");
                sb3.append("#");
                sb3.append(this.M1.isChecked());
                Log.d("item_status=", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,unit_id,u_val,base_unit,qty_pr,e_date)  values ( ");
                sb4.append(iV1);
                sb4.append(",(select id from items a where a.name='");
                sb4.append((Object) this.t1.getText());
                sb4.append("'),(select item_type_id from items a where a.name='");
                sb4.append((Object) this.t1.getText());
                sb4.append("'),'");
                sb4.append(this.s1.getText().toString().replaceAll(",", str3));
                sb4.append("','");
                sb4.append(this.s1.getText().toString().replaceAll(",", str3));
                sb4.append("','");
                sb4.append(String.valueOf(dIc));
                sb4.append("',(select id from currency where name='");
                sb4.append(this.m0.getText().toString());
                sb4.append("') ,0,(select b.unit_id from items a,unit_item b  where a.id=b.item_id and a.name='");
                sb4.append(this.t1.getText().toString());
                sb4.append("'),1,(select unit_id from items where name='");
                sb4.append(this.t1.getText().toString());
                sb4.append("'),");
                sb4.append(d4);
                sb4.append(",");
                if (this.s1.getTag() != null && this.s1.getTag().toString().length() != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    String str5 = str;
                    sb5.append(str5);
                    sb5.append(this.s1.getTag().toString());
                    sb5.append(str5);
                    string = sb5.toString();
                }
                sb4.append(string);
                sb4.append(")");
                string3 = sb4.toString();
                Log.d("sql1=", string2);
                Log.d("sql2=", string3);
                if (this.i.H(string2, string3) == 1) {
                    u1();
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
            if (this.u1.getText().length() == 0) {
                return false;
            }
            this.I1 = true;
            if (this.i.v8(this.u1.getText().toString(), 2).getCount() == 0) {
                AutoCompleteTextView autoCompleteTextView2 = this.u1;
                autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
                this.I1 = false;
                str3 = str2;
                P0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.u1.getText().toString(), this, this.u1.getText().toString(), 2);
                if (!this.I1) {
                    zA = false;
                }
            } else {
                str3 = str2;
            }
            if (zA) {
                return zA;
            }
            int iV2 = this.i.V1();
            int iW2 = this.i.W1(9, this.k);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("insert into bills2 (id,tr_type,date_,amount,d_amount,cus_id,tran_status,bill_type,bill_no2,remarks,curr_id,br_id,cash_id,is_back,bill_no,user_id) values(");
            sb6.append(iV2);
            sb6.append(",");
            sb6.append(2);
            sb6.append(",'");
            sb6.append(this.U.getText().toString());
            sb6.append("','");
            sb6.append(String.valueOf(dIc * d4));
            sb6.append("','0',(select id from customers where name='");
            sb6.append((Object) this.u1.getText());
            sb6.append("'  ),2,");
            if (this.M1.isChecked()) {
                str4 = "1";
            } else {
                str4 = "2";
            }
            sb6.append(str4);
            sb6.append(",'");
            sb6.append(iW2);
            sb6.append("','',(select id from currency where name='");
            sb6.append(this.m0.getText().toString());
            sb6.append("') ,(select id from branches where name='");
            sb6.append(this.T.getText().toString());
            sb6.append("'),(select id from customers where name='");
            sb6.append(this.n0.getText().toString());
            sb6.append("'),");
            sb6.append(this.Q.isChecked() ? 1 : 0);
            sb6.append(",");
            if (this.Q.isChecked()) {
                objValueOf = "0";
            } else {
                objValueOf = Integer.valueOf(this.V0);
            }
            sb6.append(objValueOf);
            sb6.append(",");
            i = C2160f10.h;
            string = "null";
            if (i == -1) {
                objValueOf2 = "null";
            } else {
                objValueOf2 = Integer.valueOf(i);
            }
            sb6.append(objValueOf2);
            sb6.append(")");
            string2 = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.M1.isChecked() ? "1" : "2");
            sb7.append("#");
            sb7.append(this.M1.isChecked());
            Log.d("item_status=", sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("insert into bill_transactions2(bill_id,item_id,item_type_id,qty,qty_t,cost_price,curr_id,d_amount,unit_id,u_val,base_unit,qty_pr,e_date)  values ( ");
            sb8.append(iV2);
            sb8.append(",(select id from items a where a.name='");
            sb8.append((Object) this.t1.getText());
            sb8.append("'),(select item_type_id from items a where a.name='");
            sb8.append((Object) this.t1.getText());
            sb8.append("'),'");
            sb8.append(this.s1.getText().toString().replaceAll(",", str3));
            sb8.append("','");
            sb8.append(this.s1.getText().toString().replaceAll(",", str3));
            sb8.append("','");
            sb8.append(String.valueOf(dIc));
            sb8.append("',(select id from currency where name='");
            sb8.append(this.m0.getText().toString());
            sb8.append("') ,0,(select b.unit_id from items a,unit_item b  where a.id=b.item_id and a.name='");
            sb8.append(this.t1.getText().toString());
            sb8.append("'),1,(select unit_id from items where name='");
            sb8.append(this.t1.getText().toString());
            sb8.append("'),");
            sb8.append(d4);
            sb8.append(",");
            if (this.s1.getTag() != null) {
                StringBuilder sb9 = new StringBuilder();
                String str6 = str;
                sb9.append(str6);
                sb9.append(this.s1.getTag().toString());
                sb9.append(str6);
                string = sb9.toString();
            }
            sb8.append(string);
            sb8.append(")");
            string3 = sb8.toString();
            Log.d("sql1=", string2);
            Log.d("sql2=", string3);
            if (this.i.H(string2, string3) == 1) {
                u1();
                return true;
            }
            return false;
        } catch (Exception e2) {
            e = e2;
        }
        Log.d("purchase_item_error=", e.getMessage());
        return false;
    }

    public void t0(EditText editText) {
        Intent intent = new Intent(this, (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", editText.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void t1() {
        if (getIntent().getStringExtra("TR_ID") == null) {
            this.J = false;
            return;
        }
        Log.d("read_bill=", getIntent().getStringExtra("TR_ID") + ":" + getIntent().getStringExtra("is_back") + ":" + getIntent().getStringExtra("b_bill_id"));
        if (getIntent().getStringExtra("is_back").equals("0")) {
            this.J = true;
        } else if (getIntent().getStringExtra("b_bill_id").equals("0")) {
            this.J = false;
        } else {
            this.J = true;
        }
    }

    public void u1() {
        if (this.n == 0) {
            EditText editText = this.v0;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(info.aalmoghalis.inventory.R.string.bill_no2));
            Z00 z00 = this.i;
            sb.append(z00.W1(this.p, z00.D2(this.T.getText().toString())));
            editText.setHint(sb.toString());
        }
    }

    public void update_bill_total(View view) {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "edit")) {
                Context context = this.b1;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "new")) {
            Context context2 = this.b1;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        try {
            if (this.n == 0) {
                k1();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            editText.setText(this.F1 + "");
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
            RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
            if (this.E1 == 0) {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton1);
            } else {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton2);
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new F0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new G0());
            AlertDialog alertDialogCreate = builder.create();
            this.P.isChecked();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.total_disc2));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new H0(editText, radioButton, alertDialogCreate));
            alertDialogCreate.getButton(-2).setOnClickListener(new I0(alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public void update_bill_total_all(View view) {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "edit")) {
                Context context = this.b1;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "new")) {
            Context context2 = this.b1;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        try {
            if (this.n == 0) {
                k1();
            }
            if (this.n == 0) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_total_all, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_disc_amt);
            editText.setText(this.F1 + "");
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
            RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
            if (this.E1 == 0) {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton1);
            } else {
                radioGroup.check(info.aalmoghalis.inventory.R.id.radiobutton2);
            }
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_other_cost);
            ((TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_cost)).setVisibility(8);
            this.f0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_tax_val);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.bill_tax_amount);
            TableRow tableRow = (TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_tax);
            textView.setText(this.a0.getText().toString());
            textView2.setText(this.b0.getText().toString());
            tableRow.setVisibility(this.g0.getVisibility());
            textView2.setVisibility(this.b0.getVisibility());
            tableRow.setOnClickListener(new J0(textView, radioButton, editText, textView2));
            EditText editText3 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.paid_amount);
            ((TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_paid_amount)).setVisibility(8);
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new K0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new L0());
            AlertDialog alertDialogCreate = builder.create();
            this.P.isChecked();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new M0(editText2, editText3, radioButton, editText, textView, alertDialogCreate, view));
            alertDialogCreate.getButton(-2).setOnClickListener(new N0(alertDialogCreate, view));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    public void update_tax_total(View view) {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "edit")) {
                Context context = this.b1;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.i).l("30", "new")) {
            Context context2 = this.b1;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        if (view.getId() == info.aalmoghalis.inventory.R.id.bill_tot_hdr_tax || view.getId() == this.a0.getId() || view.getId() == this.b0.getId()) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.z8());
            this.f0 = arrayAdapter;
            A0(arrayAdapter, this.a0);
        }
    }

    public void v1() {
        EditText editText = this.v0;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(info.aalmoghalis.inventory.R.string.bill_no2));
        Z00 z00 = this.i;
        sb.append(z00.W1(this.p, z00.D2(this.T.getText().toString())));
        editText.setHint(sb.toString());
    }

    public void view_item_info2(View view) {
        try {
            String string = this.o1.getText().toString();
            if (string != null && this.i.F6().contains(string)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_bill_item_view_info2, (ViewGroup) null);
                builder.setView(viewInflate);
                TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_qty);
                TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
                TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_total);
                String strX6 = this.i.X6(this.o1.getText().toString());
                StringBuilder sb = new StringBuilder();
                sb.append(this.o1.getText().toString());
                sb.append(":");
                sb.append(w0(string, this.l));
                sb.append(":");
                sb.append(this.i.J6(string, this.m0.getText().toString(), 1, this.Q.isChecked(), this.V0 + "", this.p, strX6));
                sb.append(":");
                sb.append(this.i.K6(string, this.m0.getText().toString(), 2, this.Q.isChecked(), this.V0 + "", this.p, strX6));
                Log.d("view_item_info=", sb.toString());
                double dDoubleValue = w0(string, this.l).doubleValue();
                double dJ6 = this.i.J6(string, this.m0.getText().toString(), 1, this.Q.isChecked(), this.V0 + "", this.p, strX6);
                double dK6 = this.i.K6(string, this.m0.getText().toString(), 2, this.Q.isChecked(), this.V0 + "", this.p, strX6);
                if (dJ6 == -1.0d) {
                    dJ6 = 0.0d;
                }
                if (dK6 == -1.0d) {
                    dK6 = 0.0d;
                }
                textView.setText(this.i.P7(String.valueOf(dDoubleValue)));
                textView2.setText(this.i.P7(String.valueOf(dJ6)));
                textView3.setText(this.i.P7(String.valueOf(dK6)));
                builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_hide), new DialogInterfaceOnClickListenerC3014r(builder));
                if (this.p == 2 && this.i.F6().contains(string)) {
                    builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_sales_price), new DialogInterfaceOnClickListenerC3016s());
                }
                AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setTitle(this.o1.getText().toString());
                alertDialogCreate.getWindow().setSoftInputMode(16);
                alertDialogCreate.show();
                alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC3018t(string, textView2, strX6, alertDialogCreate));
            }
        } catch (Exception e) {
            Log.d("view_item_info2_error=", ":" + e.getMessage());
        }
    }

    public Double w0(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.p0, str, str2);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListH.size());
        double d = 0.0d;
        for (int i = 0; i < arrayListH.size(); i++) {
            d += Double.parseDouble((String) ((HashMap) arrayListH.get(i)).get("item_qty"));
        }
        return Double.valueOf(d);
    }

    public void w1() {
        TextView textView;
        TextView textView2;
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.p = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.k = getIntent().getStringExtra("g_id");
                this.l = getIntent().getStringExtra("g_name");
                setTitle(getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.p - 3]);
                this.K0 = getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_bills)[this.p - 3];
                this.i.v0("delete from items_temp");
                TextView textView3 = this.T;
                Z00 z00 = this.i;
                String str = this.k;
                if (str == null) {
                    str = "0";
                }
                textView3.setText(z00.C2(str));
                int i = this.p;
                if (i == 2 && (textView2 = this.Z) != null) {
                    textView2.setText(getString(info.aalmoghalis.inventory.R.string.supp));
                } else if (i == 1 && (textView = this.Z) != null) {
                    textView.setText(getString(info.aalmoghalis.inventory.R.string.cus));
                }
                if (this.p == 2) {
                    this.O0.setVisibility(0);
                } else {
                    this.O0.setVisibility(8);
                }
                if (this.i.ja("prefOthers_purchases_tax", false)) {
                    this.g0.setVisibility(8);
                    if (this.n == 0) {
                        this.a0.setText("0");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList x0(String str, String str2) {
        ArrayList arrayListH = new C1839c10().h(this.p0, str, str2);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListH.iterator();
        while (it.hasNext()) {
            arrayList.add((HashMap) ((HashMap) it.next()).clone());
        }
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayList.size());
        double dZ6 = this.i.Z6(str, this.x1.getText().toString());
        for (int i = 0; i < arrayList.size(); i++) {
            double d = Double.parseDouble((String) ((HashMap) arrayList.get(i)).get("item_qty")) / dZ6;
            ((HashMap) arrayList.get(i)).put("item_qty", this.i.S7(String.valueOf(d)).replaceAll(",", ""));
            ((HashMap) arrayList.get(i)).put("item_date_qty", "(" + ((String) ((HashMap) arrayList.get(i)).get("item_date")) + ")" + this.i.S7(String.valueOf(d)).replaceAll(",", ""));
        }
        return arrayList;
    }

    public void x1(String str) {
        AutoCompleteTextView autoCompleteTextView;
        if (!str.equals("") && this.i.da(str)) {
            String strI6 = this.i.I6(str);
            Z00.P0 = false;
            if (strI6.equals("")) {
                try {
                    this.i.j1(str, this, this.y0);
                } catch (Exception unused) {
                }
            }
            if (!strI6.equals("") || Z00.P0) {
                if (Z00.P0) {
                    strI6 = this.i.I6(str);
                }
                if (this.v1 == 2 || ((autoCompleteTextView = this.o1) != null && autoCompleteTextView.hasWindowFocus())) {
                    i1(strI6);
                } else {
                    h1(strI6);
                }
                if (this.k1 != null) {
                    Log.d("focus=", this.k1.hasWindowFocus() + ":" + this.n1.hasWindowFocus());
                }
                this.v1 = 0;
            }
        }
    }

    public Double y0(String str, String str2, String str3) {
        double d;
        ArrayList arrayListG = new C1839c10().g(this.p0, str, str2, str3);
        Log.d("check_item_qty=", str + ":" + str2 + "#" + arrayListG.size());
        if (arrayListG.size() > 0) {
            Log.d("check_item_qty=", str + ":" + str2 + "#" + ((String) ((HashMap) arrayListG.get(0)).get("item_qty")));
            d = Double.parseDouble((String) ((HashMap) arrayListG.get(0)).get("item_qty"));
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    public void y1() {
        Log.d("back_edit=", this.H + ":" + this.I);
        if (this.H == 1) {
            t2 = true;
            u2 = true;
            v2 = this.V.getText().toString();
            finish();
            return;
        }
        int i = this.p;
        if (i == 9) {
            t2 = false;
            Intent intent = new Intent(this, (Class<?>) Orders.class);
            intent.addFlags(67141632);
            intent.addFlags(1073741824);
            intent.putExtra("TR_TYPE", "9");
            intent.putExtra("g_id", this.k);
            intent.putExtra("g_name", this.l);
            startActivity(intent);
            finish();
            return;
        }
        if (i == 2) {
            t2 = false;
            Intent intent2 = new Intent(this, (Class<?>) Bills2.class);
            intent2.addFlags(67141632);
            intent2.addFlags(1073741824);
            intent2.putExtra("TR_TYPE", "2");
            intent2.putExtra("g_id", this.k);
            intent2.putExtra("g_name", this.l);
            startActivity(intent2);
            finish();
        }
    }

    public void z0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new i1(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(info.aalmoghalis.inventory.R.string.pref_item_type));
        dialog.show();
    }

    public void z1() {
        try {
            this.i.v0("delete from items_temp");
            this.i.v0("insert into items_temp  (item_id,item_type_id  ,qty,qty_t ,price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,e_date )  select item_id,item_type_id,qty,qty_t,sls_u_price,curr_id,remark,unit_id,u_val,base_unit,qty_pr,ifnull(e_date,'')   from bill_transactions2_v  where bill_id=" + this.n + "");
        } catch (Exception unused) {
        }
    }
}
