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
import android.text.InputFilter;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
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
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.CombinedLoadStates;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC4371yX;
import defpackage.C0974Ur;
import defpackage.C0990Vh;
import defpackage.C1044Xj;
import defpackage.C1839c10;
import defpackage.C2018dE;
import defpackage.C2160f10;
import defpackage.C3357m10;
import defpackage.C3580oi;
import defpackage.C3874sM;
import defpackage.C3966tX;
import defpackage.C4062ug;
import defpackage.C4064uh;
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.C4249x1;
import defpackage.C4330y1;
import defpackage.DE;
import defpackage.E00;
import defpackage.FW;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.InterfaceC3750qp;
import defpackage.MO;
import defpackage.RunnableC1086Yj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.helper.Calculator;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class Customer_Det_List_edit extends BaseActivity implements AdapterView.OnItemClickListener, C4330y1.c, DE {
    public Uri B0;
    public boolean C0;
    public boolean D0;
    public C0990Vh I0;
    public ActionMode L0;
    public a0 M0;
    public SearchView N0;
    public C4330y1 X;
    public SparseBooleanArray Z;
    public ArrayAdapter a0;
    public ArrayAdapter b0;
    public SQLiteDatabase c;
    public ArrayAdapter c0;
    public Z00 d;
    public E00 e;
    public String f;
    public int n;
    public int p;
    public int t;
    public EditText t0;
    public int u;
    public int v;
    public String y0;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public double q = 0.0d;
    public AutoCompleteTextView w = null;
    public EditText x = null;
    public TextView y = null;
    public TextView z = null;
    public TextView A = null;
    public TextView B = null;
    public AutoCompleteTextView C = null;
    public AutoCompleteTextView D = null;
    public Button E = null;
    public Button F = null;
    public Button G = null;
    public ImageView H = null;
    public ImageView I = null;
    public ImageView J = null;
    public RadioGroup K = null;
    public RadioButton L = null;
    public RadioButton M = null;
    public RecyclerView N = null;
    public LinearLayout O = null;
    public LinearLayout P = null;
    public LinearLayout Q = null;
    public LinearLayout R = null;
    public LinearLayout S = null;
    public LinearLayout T = null;
    public LinearLayout U = null;
    public RadioGroup V = null;
    public ArrayList W = new ArrayList();
    public List Y = new ArrayList();
    public ImageButton d0 = null;
    public ImageView e0 = null;
    public String f0 = "";
    public String g0 = "";
    public int h0 = 0;
    public String[] i0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] j0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] k0 = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public String l0 = null;
    public String m0 = null;
    public String n0 = null;
    public String o0 = null;
    public String p0 = null;
    public String q0 = null;
    public int r0 = 0;
    public int s0 = 0;
    public int u0 = 3;
    public int v0 = 4;
    public int w0 = 0;
    public int x0 = 1;
    public ActivityResultLauncher z0 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Bg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.Q0((Uri) obj);
        }
    });
    public ActivityResultLauncher A0 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new A());
    public String E0 = "";
    public boolean F0 = false;
    public double G0 = 0.0d;
    public String H0 = "";
    public int J0 = 0;
    public int K0 = 0;
    public final Handler O0 = new Handler(Looper.getMainLooper());
    public DatePickerDialog.OnDateSetListener P0 = new R();
    public DatePickerDialog.OnDateSetListener Q0 = new S();
    public final Context R0 = this;
    public int S0 = 0;
    public String T0 = "";

    public class A implements ActivityResultCallback {
        public A() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Customer_Det_List_edit.this.n1();
            }
        }
    }

    public class B extends Handler {
        public B() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class C implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public C(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit.this.d.v0("insert into groups  (name )  values( '" + Customer_Det_List_edit.this.E0 + "'  )");
            Customer_Det_List_edit.this.D0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class D implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public D(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit.this.D0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class E extends Handler {
        public E() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class F implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public F(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit.this.Y(this.a);
        }
    }

    public class G implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public G(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit.this.C0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class H implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public H(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.c0(view, this.a);
        }
    }

    public class I implements View.OnClickListener {
        public I() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.showDialog(4);
        }
    }

    public class J implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public J(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.c0(view, this.a);
        }
    }

    public class K implements DialogInterface.OnClickListener {
        public final /* synthetic */ ImageView a;

        public K(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit.this.d.qa(Z00.M + this.a.getTag().toString());
            } catch (Exception unused) {
            }
        }
    }

    public class L implements View.OnClickListener {
        public L() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.showDialog(0);
        }
    }

    public class M implements DialogInterface.OnClickListener {
        public M() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class N implements DialogInterface.OnClickListener {
        public N() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit.this.b1();
        }
    }

    public class O implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ AlertDialog c;

        public O(EditText editText, EditText editText2, AlertDialog alertDialog) {
            this.a = editText;
            this.b = editText2;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.b1();
            boolean zA = AbstractC4371yX.a(this.a);
            boolean z = false;
            if (!AbstractC4371yX.a(Customer_Det_List_edit.this.x)) {
                Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                Toast.makeText(customer_Det_List_edit, customer_Det_List_edit.getString(info.aalmoghalis.inventory.R.string.tr_amount_required), 0).show();
                zA = false;
            }
            String str = "";
            if (Customer_Det_List_edit.this.x.getText().toString().equals("") || Double.parseDouble(Customer_Det_List_edit.this.x.getText().toString().replaceAll(",", "")) >= Double.parseDouble(this.a.getText().toString().replaceAll(",", ""))) {
                z = zA;
            } else {
                Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
                Toast.makeText(customer_Det_List_edit2, customer_Det_List_edit2.getString(info.aalmoghalis.inventory.R.string.tr_amount_less_discount), 0).show();
            }
            if (z) {
                Customer_Det_List_edit.this.G0 = Double.parseDouble(this.a.getText().toString().replaceAll(",", ""));
                Customer_Det_List_edit.this.H0 = this.b.getText() == null ? "" : this.b.getText().toString();
                TextView textView = Customer_Det_List_edit.this.A;
                StringBuilder sb = new StringBuilder();
                sb.append("-");
                Customer_Det_List_edit customer_Det_List_edit3 = Customer_Det_List_edit.this;
                sb.append(customer_Det_List_edit3.d.P7(String.valueOf(customer_Det_List_edit3.G0)));
                if (!Customer_Det_List_edit.this.H0.equals("")) {
                    str = ":" + Customer_Det_List_edit.this.H0;
                }
                sb.append(str);
                textView.setText(sb.toString());
                Customer_Det_List_edit.this.D.requestFocus();
                this.c.dismiss();
            }
        }
    }

    public class P implements View.OnClickListener {
        public P() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.onRadioButtonClicked(view);
        }
    }

    public class Q implements SearchView.OnQueryTextListener {

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Customer_Det_List_edit.this.V0(this.a);
            }
        }

        public Q() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Customer_Det_List_edit.this.O0.removeCallbacksAndMessages(null);
            Customer_Det_List_edit.this.O0.postDelayed(new a(str), new C2160f10().V(str));
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class R implements DatePickerDialog.OnDateSetListener {
        public R() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit.this.t = i;
            Customer_Det_List_edit.this.u = i2;
            Customer_Det_List_edit.this.v = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit.this.v)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit.this.u + 1)) + "-" + Customer_Det_List_edit.this.t;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit.this.y.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class S implements DatePickerDialog.OnDateSetListener {
        public S() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit.this.t = i;
            Customer_Det_List_edit.this.u = i2;
            Customer_Det_List_edit.this.v = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit.this.v)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit.this.u + 1)) + "-" + Customer_Det_List_edit.this.t;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit.this.z.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class T implements DialogInterface.OnClickListener {
        public T() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class U implements DialogInterface.OnClickListener {
        public U() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit.this.s0();
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class V implements Runnable {
        public final /* synthetic */ int a;

        public V(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i == 0) {
                Customer_Det_List_edit.this.f0();
                return;
            }
            if (i == 1) {
                Customer_Det_List_edit.this.e0();
                Customer_Det_List_edit.this.q1();
            } else if (i == 2) {
                Customer_Det_List_edit.this.T0();
            } else if (i == 4) {
                Customer_Det_List_edit.this.x.selectAll();
            }
        }
    }

    public class W implements DialogInterface.OnClickListener {
        public W() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class X implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ EditText c;

        public X(AutoCompleteTextView autoCompleteTextView, Dialog dialog, EditText editText) {
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
                    Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                    customer_Det_List_edit.d.Md(customer_Det_List_edit);
                }
            }
        }
    }

    public class Y implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ArrayAdapter b;
        public final /* synthetic */ Dialog c;

        public Y(TextView textView, ArrayAdapter arrayAdapter, Dialog dialog) {
            this.a = textView;
            this.b = arrayAdapter;
            this.c = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getId() == Customer_Det_List_edit.this.B.getId()) {
                if (i == this.b.getCount() - 1) {
                    Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                    customer_Det_List_edit.o1("0", "", "", customer_Det_List_edit.d.T5("0"), "", Customer_Det_List_edit.this.d.v1("121"));
                } else {
                    this.a.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            this.c.dismiss();
        }
    }

    public class Z implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public Z(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$a, reason: case insensitive filesystem */
    public class C2689a implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2689a(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    public class a0 implements ActionMode.Callback {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Customer_Det_List_edit.this.p0();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit.this.getApplicationContext(), "SQL Error.", 1);
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

        public a0() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case info.aalmoghalis.inventory.R.id.menu_delete /* 2131297039 */:
                    SparseBooleanArray sparseBooleanArrayE = Customer_Det_List_edit.this.X.e();
                    Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                    customer_Det_List_edit.Z = sparseBooleanArrayE;
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(customer_Det_List_edit);
                    builder.setMessage(Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
                    builder.setPositiveButton(Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
                    builder.setNegativeButton(Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayE2 = Customer_Det_List_edit.this.X.e();
                    Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
                    customer_Det_List_edit2.Z = sparseBooleanArrayE2;
                    customer_Det_List_edit2.r0();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_share /* 2131297045 */:
                    SparseBooleanArray sparseBooleanArrayE3 = Customer_Det_List_edit.this.X.e();
                    Customer_Det_List_edit customer_Det_List_edit3 = Customer_Det_List_edit.this;
                    customer_Det_List_edit3.Z = sparseBooleanArrayE3;
                    customer_Det_List_edit3.h1();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.contextual_action_bar_2, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Customer_Det_List_edit.this.N.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Customer_Det_List_edit.this.X.g.clear();
            Customer_Det_List_edit.this.X.j();
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Customer_Det_List_edit.this.X.d() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        public /* synthetic */ a0(Customer_Det_List_edit customer_Det_List_edit, C2696h c2696h) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2690b implements View.OnClickListener {
        public ViewOnClickListenerC2690b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.phone_pick_btn(view);
        }
    }

    public class b0 implements Comparator {
        public b0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                int iCompareTo = simpleDateFormat.parse(c4064uh.p()).compareTo(simpleDateFormat.parse(c4064uh2.p()));
                return iCompareTo == 0 ? Integer.valueOf(c4064uh.q()).compareTo(Integer.valueOf(c4064uh2.q())) : iCompareTo;
            } catch (ParseException unused) {
                return 0;
            }
        }

        public /* synthetic */ b0(Customer_Det_List_edit customer_Det_List_edit, C2696h c2696h) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2691c implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2691c(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
            customer_Det_List_edit.d.Md(customer_Det_List_edit);
            Customer_Det_List_edit.this.k0(this.a, this.b, this.c);
        }
    }

    public static class c0 implements Comparator {
        public c0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                return simpleDateFormat.parse(c4064uh2.p()).compareTo(simpleDateFormat.parse(c4064uh.p()));
            } catch (ParseException unused) {
                return c4064uh2.p().compareTo(c4064uh.p());
            }
        }

        public /* synthetic */ c0(C2696h c2696h) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2692d implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2692d(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
            customer_Det_List_edit.d.Md(customer_Det_List_edit);
            Customer_Det_List_edit.this.k0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$e, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2693e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2693e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$f, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2694f implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2694f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$g, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2695g implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog g;

        public ViewOnClickListenerC2695g(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, EditText editText2, EditText editText3, androidx.appcompat.app.AlertDialog alertDialog) {
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
            if (Customer_Det_List_edit.this.d.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit.this.d.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit.this.E0 = this.b.getText().toString();
                Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                customer_Det_List_edit.z0(customer_Det_List_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit.this.E0, Customer_Det_List_edit.this);
                if (!Customer_Det_List_edit.this.C0) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit.this.d.r1(this.c.getText().toString());
                if (!this.d.equals("0")) {
                    if (this.d != null) {
                        Customer_Det_List_edit.this.d.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.e.getText().toString() + "',address='" + this.f.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit.this.f + "' and id>0 ");
                        this.g.dismiss();
                        return;
                    }
                    return;
                }
                if (Customer_Det_List_edit.this.d.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                    FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit.this);
                    this.a.setError(Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.exist));
                    return;
                }
                Customer_Det_List_edit.this.d.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.e.getText().toString() + "','" + this.f.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                if (iR1 == 121 || iR1 == 122) {
                    Customer_Det_List_edit.this.B.setText(this.a.getText().toString());
                }
                this.g.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$h, reason: case insensitive filesystem */
    public class C2696h implements Observer {
        public final /* synthetic */ TextView a;

        public C2696h(TextView textView) {
            this.a = textView;
        }

        public final /* synthetic */ void f() {
            Customer_Det_List_edit.this.X.notifyDataSetChanged();
        }

        public final /* synthetic */ void g(List list) {
            new C2160f10(list).e(2);
            Customer_Det_List_edit.this.X.l(list);
            Customer_Det_List_edit.this.runOnUiThread(new Runnable() { // from class: Ig
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        }

        public final /* synthetic */ void h() {
            Customer_Det_List_edit.this.X.getFilter().filter(Customer_Det_List_edit.this.N0.getQuery());
        }

        public final /* synthetic */ void i() {
            Customer_Det_List_edit.this.X.notifyDataSetChanged();
        }

        public final /* synthetic */ void j(List list) {
            if (Build.VERSION.SDK_INT <= 29) {
                new C2160f10(list).e(2);
            }
            Customer_Det_List_edit.this.X.l(list);
            SearchView searchView = Customer_Det_List_edit.this.N0;
            if (searchView == null || searchView.getQuery().length() <= 0) {
                Customer_Det_List_edit.this.runOnUiThread(new Runnable() { // from class: Hg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.i();
                    }
                });
            } else {
                Customer_Det_List_edit.this.runOnUiThread(new Runnable() { // from class: Gg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.h();
                    }
                });
            }
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void onChanged(final List list) {
            C3966tX c3966tX = new C3966tX();
            Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
            c3966tX.z(customer_Det_List_edit, customer_Det_List_edit.N, this.a, list == null ? 0 : list.size());
            Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
            if (customer_Det_List_edit2.X != null) {
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: Fg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j(list);
                    }
                });
                executorServiceNewSingleThreadExecutor.shutdown();
            } else {
                customer_Det_List_edit2.X0(list);
                if (Build.VERSION.SDK_INT <= 29) {
                    ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
                    executorServiceNewSingleThreadExecutor2.submit(new Runnable() { // from class: Eg
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.g(list);
                        }
                    });
                    executorServiceNewSingleThreadExecutor2.shutdown();
                }
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$i, reason: case insensitive filesystem */
    public class C2697i implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2697i(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$j, reason: case insensitive filesystem */
    public class C2698j implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2698j(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$k, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2699k implements View.OnClickListener {
        public ViewOnClickListenerC2699k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$l, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2700l implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2700l(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
            customer_Det_List_edit.d.Md(customer_Det_List_edit);
            Customer_Det_List_edit.this.k0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$m, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2701m implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2701m(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
            customer_Det_List_edit.d.Md(customer_Det_List_edit);
            Customer_Det_List_edit.this.k0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$n, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2702n implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2702n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$o, reason: case insensitive filesystem */
    public class C2703o implements Observer {
        public final /* synthetic */ TextView a;

        public C2703o(TextView textView) {
            this.a = textView;
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                C3966tX c3966tX = new C3966tX();
                Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                c3966tX.z(customer_Det_List_edit, customer_Det_List_edit.N, this.a, -1);
            } else {
                C3966tX c3966tX2 = new C3966tX();
                Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
                c3966tX2.z(customer_Det_List_edit2, customer_Det_List_edit2.N, this.a, 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$p, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2704p implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2704p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$q, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2705q implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ Handler h;

        public ViewOnClickListenerC2705q(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, androidx.appcompat.app.AlertDialog alertDialog, EditText editText2, EditText editText3, Handler handler) {
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
            if (Customer_Det_List_edit.this.d.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit.this.d.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit.this.E0 = this.b.getText().toString();
                Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                customer_Det_List_edit.z0(customer_Det_List_edit.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit.this.E0, Customer_Det_List_edit.this);
                if (!Customer_Det_List_edit.this.C0) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit.this.d.r1(this.c.getText().toString());
                if (this.d.equals("0")) {
                    if (Customer_Det_List_edit.this.d.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
                        customer_Det_List_edit2.d.Qd(customer_Det_List_edit2, customer_Det_List_edit2.N, this.a.getText().toString().trim() + " : " + Customer_Det_List_edit.this.getString(info.aalmoghalis.inventory.R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit.this);
                        this.e.dismiss();
                        return;
                    }
                    Customer_Det_List_edit.this.d.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.f.getText().toString() + "','" + this.g.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                    Handler handler = this.h;
                    handler.sendMessage(handler.obtainMessage());
                } else if (this.d != null) {
                    Customer_Det_List_edit.this.d.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.f.getText().toString() + "',address='" + this.g.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit.this.f + "' and id>0 ");
                    Handler handler2 = this.h;
                    handler2.sendMessage(handler2.obtainMessage());
                }
                this.e.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$r, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2706r implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2706r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (Customer_Det_List_edit.this.n != 0) {
                    Customer_Det_List_edit.this.d.v0("delete from transactions  where id='" + Customer_Det_List_edit.this.n + "'");
                    Customer_Det_List_edit.this.x.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    Customer_Det_List_edit.this.z.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                    Customer_Det_List_edit.this.t = calendar.get(1);
                    Customer_Det_List_edit.this.u = calendar.get(2);
                    Customer_Det_List_edit.this.v = calendar.get(5);
                    Customer_Det_List_edit.this.D.setText((CharSequence) null);
                    Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                    customer_Det_List_edit.E.setText(customer_Det_List_edit.getString(info.aalmoghalis.inventory.R.string.btn_add));
                    Customer_Det_List_edit.this.n = 0;
                    Customer_Det_List_edit.this.A0();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$s, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2707s implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2707s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$t, reason: case insensitive filesystem */
    public class C2708t implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2708t(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (i <= 1) {
                C3966tX c3966tX = new C3966tX();
                Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                c3966tX.f(customer_Det_List_edit, customer_Det_List_edit.d, customer_Det_List_edit.e, customer_Det_List_edit.g, i);
            } else if (i == 2) {
                Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
                C4064uh c4064uhP0 = customer_Det_List_edit2.d.P0(customer_Det_List_edit2.g);
                Customer_Det_List_edit customer_Det_List_edit3 = Customer_Det_List_edit.this;
                Z00 z00 = customer_Det_List_edit3.d;
                z00.td(z00.zd(customer_Det_List_edit3.u0(), Customer_Det_List_edit.this.g, Double.parseDouble(c4064uhP0.v)));
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$u, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2709u implements View.OnClickListener {
        public final /* synthetic */ Snackbar a;

        public ViewOnClickListenerC2709u(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$v, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2710v implements View.OnClickListener {
        public ViewOnClickListenerC2710v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit.this.i1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$w, reason: case insensitive filesystem */
    public class RunnableC2711w implements Runnable {
        public final /* synthetic */ Snackbar a;

        public RunnableC2711w(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$x, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2712x implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC2712x(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit.this);
                if (this.a[i].equals(Customer_Det_List_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                    customer_Det_List_edit.y0 = customer_Det_List_edit.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit.this.g0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
                    customer_Det_List_edit2.y0 = customer_Det_List_edit2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit.this.v0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit.this.d.qa(Z00.M + Customer_Det_List_edit.this.J.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit.this.J.setTag(null);
                    Customer_Det_List_edit.this.J.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$y, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2713y implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC2713y(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit.this);
                if (this.a[i].equals(Customer_Det_List_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
                    customer_Det_List_edit.y0 = customer_Det_List_edit.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit.this.g0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
                    customer_Det_List_edit2.y0 = customer_Det_List_edit2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit.this.v0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit.this.d.qa(Z00.M + Customer_Det_List_edit.this.I.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit.this.I.setTag(null);
                    Customer_Det_List_edit.this.I.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Customer_Det_List_edit.this.I.getLayoutParams().width = (int) Customer_Det_List_edit.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Customer_Det_List_edit.this.I.getLayoutParams().height = (int) Customer_Det_List_edit.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit$z, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2714z implements View.OnClickListener {
        public ViewOnClickListenerC2714z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit customer_Det_List_edit = Customer_Det_List_edit.this;
            Customer_Det_List_edit customer_Det_List_edit2 = Customer_Det_List_edit.this;
            customer_Det_List_edit.c0 = new ArrayAdapter(customer_Det_List_edit2, android.R.layout.simple_spinner_dropdown_item, customer_Det_List_edit2.d.D3());
            Customer_Det_List_edit customer_Det_List_edit3 = Customer_Det_List_edit.this;
            customer_Det_List_edit3.l0(customer_Det_List_edit3.c0, Customer_Det_List_edit.this.B);
        }
    }

    private boolean G0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean H0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && G0(21, 22);
    }

    public static boolean I0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean J0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean K0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        W0(uri, true);
    }

    private void U0(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                n0(new File(Z00.A0), file2);
            } else {
                n0(new File(x0(this, this.B0)), file2);
            }
            f1(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void W0(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.d, this);
            if (strX != null) {
                f1(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Z(String str) {
        new androidx.appcompat.app.AlertDialog.Builder(this).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new T()).show();
    }

    private void a1() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_PHONE_STATE")) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        }
    }

    private void c1(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
    }

    private void e1() {
        String[] stringArray = this.J.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC2712x(stringArray));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            n1();
            return;
        }
        int i = Integer.parseInt(this.d.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.d.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.A0.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private void g1() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private boolean h0() {
        Log.d("IMEI=", "AFTER VALIDATION");
        boolean zA = AbstractC4371yX.a(this.x);
        if (!AbstractC4371yX.a(this.D)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.w)) {
            zA = false;
        }
        if (this.w.getText().toString().equals(this.B.getText().toString())) {
            this.w.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.not_valid), 0).show();
            zA = false;
        }
        if (this.d.u3(this.w.getText().toString()) == 0 && this.d.u3(this.w.getText().toString().trim()) == 0) {
            this.w.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        this.d.D = false;
        if (this.V.getTag() != null && !this.V.getTag().toString().equals(this.d.l3("0")) && this.d.Z2(this.V.getTag().toString(), this.d.cc(this.z.getText().toString())) == 0) {
            this.d.u(this, this.V.getTag().toString(), this.d.cc(this.z.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
            if (!this.d.D) {
                zA = false;
            }
        }
        if (!this.d.Q()) {
            this.E.setError(null);
            return zA;
        }
        m0();
        this.E.setError(getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    private void i0() {
        if (this.d.u3(this.w.getText().toString()) == 0 && this.d.u3(this.w.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.w;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.w.getText().toString().length() >= 1 && this.E.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_add))) {
                y0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.w.getText()), this);
            }
        }
        if (this.w.getText().toString().equals(this.w.getText().toString().trim()) || this.d.u3(this.w.getText().toString().trim()) <= 0) {
            return;
        }
        AutoCompleteTextView autoCompleteTextView2 = this.w;
        autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
    }

    private boolean j0() {
        boolean zA = AbstractC4371yX.a(this.x);
        if (!AbstractC4371yX.a(this.C)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.w)) {
            zA = false;
        }
        if (this.d.u3(this.w.getText().toString()) == 0 && this.d.u3(this.w.getText().toString().trim()) == 0) {
            this.w.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        this.d.D = false;
        if (this.V.getTag() != null && !this.V.getTag().toString().equals(this.d.l3("0")) && this.d.Z2(this.V.getTag().toString(), this.d.cc(this.y.getText().toString())) == 0) {
            this.d.u(this, this.V.getTag().toString(), this.d.cc(this.y.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
            if (!this.d.D) {
                zA = false;
            }
        }
        if (!this.d.Q()) {
            this.E.setError(null);
            return zA;
        }
        m0();
        this.E.setError(getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    private void k1() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    private void n0(File file, File file2) throws IOException {
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

    private void q0() {
        String[] stringArray = this.I.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC2713y(stringArray));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        C4330y1 c4330y1 = new C4330y1(this, this.Y, this, this);
        this.X = c4330y1;
        c4330y1.g.clear();
        d1(this.Y);
        this.X.notifyDataSetChanged();
        this.N.setAdapter(this.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.z0.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.v0);
    }

    public void A0() {
        this.G0 = 0.0d;
        o0(0);
        C0();
    }

    public void B0() {
        Cursor cursorI4 = this.d.I4();
        this.i0 = new String[cursorI4.getCount()];
        if (cursorI4.moveToFirst()) {
            int i = 0;
            do {
                this.i0[i] = cursorI4.getString(cursorI4.getColumnIndex("_id"));
                i++;
            } while (cursorI4.moveToNext());
        }
        cursorI4.close();
        this.a0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i0);
        this.w.setThreshold(1);
        this.w.setAdapter(this.a0);
    }

    public void C0() {
        Log.d("get_remarks=", this.F0 + "");
        C1044Xj.a().c(new RunnableC1171Zj(4, this.d, this.w, this.C, this.D, this, this.Q, this.F0 ? 1 : 2, this.E, new RunnableC1086Yj()));
    }

    public void D0(String str) {
        C4143vg c4143vgQ4 = this.d.q4(str);
        if (c4143vgQ4.i().equals("")) {
            return;
        }
        this.f = c4143vgQ4.i();
        this.g = c4143vgQ4.j();
        this.l = c4143vgQ4.h();
        this.k = "0";
        this.h = c4143vgQ4.f();
    }

    public double E0(List list) {
        double d = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            int i = 0;
            if (((C4064uh) list.get(size)).t() == this.k0[0]) {
                i = -1;
            } else if (((C4064uh) list.get(size)).t() == this.k0[2]) {
                i = 1;
            }
            d += Double.parseDouble(((C4064uh) list.get(size)).n().replaceAll(",", "")) * ((double) i);
        }
        return d;
    }

    public void F0(int i, int i2) {
        try {
            new Handler().postDelayed(new V(i), i2);
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ void L0(View view) {
        this.X.retry();
    }

    public final /* synthetic */ void M0() {
        this.X.notifyDataSetChanged();
    }

    public final /* synthetic */ void N0() {
        this.N.scrollToPosition(0);
    }

    public final /* synthetic */ FW O0(CombinedLoadStates combinedLoadStates) {
        Log.d("trace_2loadStates:=", this.J0 + ":" + combinedLoadStates.toString());
        if (combinedLoadStates.getPrepend().getEndOfPaginationReached()) {
            X0(null);
            if (this.J0 == -1) {
                new Handler().postDelayed(new Runnable() { // from class: Cg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.M0();
                    }
                }, 0L);
            }
            if (this.J0 == 1) {
                Y0();
            }
            if (this.J0 == 0 && this.N.computeVerticalScrollOffset() == 0) {
                new Handler().postDelayed(new Runnable() { // from class: Dg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.N0();
                    }
                }, 0L);
            }
            this.J0 = 0;
        }
        return null;
    }

    public final /* synthetic */ void P0(PagingData pagingData) {
        this.X.submitData(getLifecycle(), pagingData);
    }

    public final /* synthetic */ Integer R0() {
        m1(this.X.c());
        return 1;
    }

    public final /* synthetic */ void S0(Integer num) {
        this.X.notifyDataSetChanged();
        Z0();
    }

    public void T0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") == 0) {
            this.d.Tb();
        } else if (Build.VERSION.SDK_INT < 29) {
            a1();
        } else {
            this.d.Tb();
        }
    }

    public void V0(String str) {
        if (this.X != null) {
            this.K0 = 1;
            o0(-1);
        }
    }

    public void X0(List list) {
        Log.d("trace_E_Loader_cus=", this.f + ":" + this.j + ":" + this.g);
        this.M0 = new a0(this, null);
    }

    public void Y(Handler handler) {
        String string = this.w.getText().toString();
        String strT5 = this.h;
        if (strT5 == null) {
            strT5 = this.d.T5("0");
        }
        p1("0", string, "", strT5, "", this.i, handler);
    }

    public void Y0() {
        Log.d("trace_2_onChanged=", "start3:print_pdf_action");
        if (this.d.ja("prefPrintSort", true)) {
            AbstractC3132jE.d(new Callable() { // from class: zg
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.R0();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Ag
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.S0((Integer) obj);
                }
            });
        } else {
            Z0();
        }
    }

    public void Z0() {
        if (this.V.getTag() == null) {
            if (this.d.ja("pref_print_all_curr", false)) {
                Z00 z00 = this.d;
                z00.nb(z00.ic(this.g), this.f, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.d.ic(this.g));
                this.d.sd(this.d.ic(this.g) + ".pdf");
                return;
            }
            new C3357m10(this, this.d).g(this.N, this.d.ic(this.g + "-" + this.j), E0(this.X.c()), this.j, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.d.ic(this.g));
            Z00 z01 = this.d;
            StringBuilder sb = new StringBuilder();
            sb.append(this.d.ic(this.g + "-" + this.j));
            sb.append(".pdf");
            z01.ra(sb.toString());
            return;
        }
        if (this.d.ja("pref_print_all_curr", false)) {
            Z00 z02 = this.d;
            z02.nb(z02.ic(this.g), this.f, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.d.ic(this.g));
            this.d.sd(this.d.ic(this.g) + ".pdf");
            return;
        }
        new C3357m10(this, this.d).g(this.N, this.d.ic(this.g + "-" + this.j), E0(this.X.c()), this.j, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.d.ic(this.g));
        Z00 z03 = this.d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.d.ic(this.g + "-" + this.j));
        sb2.append(".pdf");
        z03.ra(sb2.toString());
    }

    @Override // defpackage.C4330y1.c
    public void a(int i) {
        if (this.L0 == null) {
            this.L0 = startActionMode(this.M0);
        }
        this.X.m(i);
        this.L0.invalidate();
        int iD = this.X.d();
        if (iD <= 0) {
            this.L0.finish();
            return;
        }
        this.L0.setTitle(iD + " Selected");
    }

    public void a0() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.READ_MEDIA_IMAGES") == 0) {
                return;
            }
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_MEDIA_IMAGES"}, 112);
        } else if (i >= 33) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.READ_MEDIA_IMAGES") == 0) {
                return;
            }
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_MEDIA_IMAGES"}, 112);
        } else {
            if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                return;
            }
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
        }
    }

    public void b0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void b1() {
        this.G0 = 0.0d;
        this.H0 = "";
        this.A.setText(getString(info.aalmoghalis.inventory.R.string.disc_title));
    }

    public void btn_cus_add(View view) {
        int i;
        String str;
        String str2;
        C2160f10.h = MO.b(this);
        FragmentStatePagerSupport_Main.a0 = true;
        if (view.getId() == info.aalmoghalis.inventory.R.id.btn_cus_det_add1) {
            i = -1;
        } else {
            i = view.getId() == info.aalmoghalis.inventory.R.id.btn_cus_det_add2 ? 1 : 0;
        }
        i0();
        if (h0()) {
            try {
                if (Double.parseDouble(this.x.getText().toString().replaceAll(",", "").replaceAll("-", "")) - this.G0 < 0.0d) {
                    this.d.Qd(this, this.N, getString(info.aalmoghalis.inventory.R.string.tr_amount_less_discount), 1000, 2);
                    return;
                }
                if (i != 0) {
                    if (this.J.getTag() == null) {
                        Z00 z00 = this.d;
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param2,curr_id,cash_id,d_amount,d_remarks,user_id) values((select b.id from customers as b where b.name='");
                        sb.append(this.w.getText().toString());
                        sb.append("'),");
                        sb.append(Double.parseDouble(this.x.getText().toString().replaceAll(",", "").replaceAll("-", "")) - this.G0);
                        sb.append(",");
                        sb.append(i);
                        sb.append(",'");
                        sb.append(this.z.getText().toString());
                        sb.append("','");
                        sb.append(this.D.getText().toString());
                        sb.append("',strftime('%Y-%m-%d','now'),'");
                        sb.append(this.d.B8());
                        sb.append("',");
                        if (this.V.getTag() == null) {
                            str2 = "0";
                        } else {
                            str2 = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                        }
                        sb.append(str2);
                        sb.append(",(select id from customers where name='");
                        sb.append(this.B.getText().toString());
                        sb.append("'),");
                        sb.append(this.G0);
                        sb.append(",'");
                        sb.append(this.H0);
                        sb.append("',");
                        int i2 = C2160f10.h;
                        sb.append(i2 == -1 ? "null" : Integer.valueOf(i2));
                        sb.append(")");
                        z00.x0(sb.toString());
                    } else {
                        Z00 z01 = this.d;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param1,param2,curr_id,cash_id,d_amount,d_remarks,user_id) values((select b.id from customers as b where b.name='");
                        sb2.append(this.w.getText().toString());
                        sb2.append("'),");
                        sb2.append(Double.parseDouble(this.x.getText().toString().replaceAll(",", "").replaceAll("-", "")) - this.G0);
                        sb2.append(",");
                        sb2.append(i);
                        sb2.append(",'");
                        sb2.append(this.z.getText().toString());
                        sb2.append("','");
                        sb2.append(this.D.getText().toString());
                        sb2.append("',strftime('%Y-%m-%d','now'),'");
                        sb2.append(this.J.getTag().toString());
                        sb2.append("','");
                        sb2.append(this.d.B8());
                        sb2.append("',");
                        if (this.V.getTag() == null) {
                            str = "0";
                        } else {
                            str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                        }
                        sb2.append(str);
                        sb2.append(",(select id from customers where name='");
                        sb2.append(this.B.getText().toString());
                        sb2.append("'),");
                        sb2.append(this.G0);
                        sb2.append(",'");
                        sb2.append(this.H0);
                        sb2.append("',");
                        int i3 = C2160f10.h;
                        sb2.append(i3 == -1 ? "null" : Integer.valueOf(i3));
                        sb2.append(")");
                        z01.x0(sb2.toString());
                    }
                    D0(this.w.getText().toString());
                    this.x.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    this.z.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                    this.t = calendar.get(1);
                    this.u = calendar.get(2);
                    this.v = calendar.get(5);
                    this.D.setText((CharSequence) null);
                    c1(this.J);
                    if (this.h0 == 1) {
                        this.x.requestFocus();
                    } else {
                        this.w.selectAll();
                        this.w.requestFocus();
                    }
                }
                A0();
                j1(true);
                l1();
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Error:");
                sb3.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
                Toast.makeText(this, sb3.toString(), 1).show();
            }
        }
    }

    public void btn_cus_remove(View view) {
        FragmentStatePagerSupport_Main.a0 = true;
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        this.n = Integer.parseInt(((TextView) ((RelativeLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.tr_id)).getText().toString());
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2706r());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2707s());
        builder.create().show();
    }

    public void btn_cus_save(View view) {
        int i;
        String str;
        String str2;
        String str3;
        FragmentStatePagerSupport_Main.a0 = true;
        if (this.L.isChecked()) {
            i = -1;
        } else {
            i = this.M.isChecked() ? 1 : 0;
        }
        i0();
        if (j0()) {
            try {
                if (this.E.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save)) && this.n != 0) {
                    String str4 = "0";
                    if (this.I.getTag() == null) {
                        if (this.d.O8(this.n).equals("0")) {
                            Z00 z00 = this.d;
                            StringBuilder sb = new StringBuilder();
                            sb.append("update transactions set out='");
                            sb.append(this.x.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                            sb.append("',[in]='");
                            sb.append(i);
                            sb.append("',date_='");
                            sb.append(this.y.getText().toString());
                            sb.append("',remarks='");
                            sb.append(this.C.getText().toString());
                            sb.append("',param1='',curr_id=");
                            if (this.V.getTag() == null) {
                                str3 = "0";
                            } else {
                                str3 = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                            }
                            sb.append(str3);
                            sb.append(" where id='");
                            sb.append(this.n);
                            sb.append("'");
                            z00.x0(sb.toString());
                        } else {
                            Z00 z01 = this.d;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("update transactions set out='");
                            sb2.append(this.x.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                            sb2.append("',date_='");
                            sb2.append(this.y.getText().toString());
                            sb2.append("',remarks='");
                            sb2.append(this.C.getText().toString());
                            sb2.append("',param1='',curr_id=");
                            if (this.V.getTag() != null) {
                                str4 = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                            }
                            sb2.append(str4);
                            sb2.append(" where id='");
                            sb2.append(this.n);
                            sb2.append("'");
                            z01.x0(sb2.toString());
                        }
                    } else if (this.d.O8(this.n).equals("0")) {
                        Z00 z02 = this.d;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("update transactions set out='");
                        sb3.append(this.x.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb3.append("',[in]='");
                        sb3.append(i);
                        sb3.append("',date_='");
                        sb3.append(this.y.getText().toString());
                        sb3.append("',remarks='");
                        sb3.append(this.C.getText().toString());
                        sb3.append("',param1='");
                        sb3.append(this.I.getTag().toString());
                        sb3.append("',curr_id=");
                        if (this.V.getTag() == null) {
                            str = "0";
                        } else {
                            str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                        }
                        sb3.append(str);
                        sb3.append(" where id='");
                        sb3.append(this.n);
                        sb3.append("'");
                        z02.x0(sb3.toString());
                    } else {
                        Z00 z03 = this.d;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("update transactions set out='");
                        sb4.append(this.x.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb4.append("',date_='");
                        sb4.append(this.y.getText().toString());
                        sb4.append("',remarks='");
                        sb4.append(this.C.getText().toString());
                        sb4.append("',param1='");
                        sb4.append(this.I.getTag().toString());
                        sb4.append("',curr_id=");
                        if (this.V.getTag() == null) {
                            str2 = "0";
                        } else {
                            str2 = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                        }
                        sb4.append(str2);
                        sb4.append(" where id='");
                        sb4.append(this.n);
                        sb4.append("'");
                        z03.x0(sb4.toString());
                    }
                    this.x.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    this.y.setText(simpleDateFormat.format(calendar.getTime()));
                    this.z.setText(simpleDateFormat.format(calendar.getTime()));
                    this.t = calendar.get(1);
                    this.u = calendar.get(2);
                    this.v = calendar.get(5);
                    this.C.setText((CharSequence) null);
                    c1(this.I);
                    this.D.setText((CharSequence) null);
                    this.E.setText(getString(info.aalmoghalis.inventory.R.string.btn_add));
                    this.n = 0;
                    if (this.s0 == 1) {
                        Bill_edit.P2 = true;
                    }
                }
                A0();
                j1(true);
            } catch (Exception e) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Error:");
                sb5.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
                Toast.makeText(this, sb5.toString(), 1).show();
            }
        }
    }

    @Override // defpackage.DE
    public void c(int i, C4064uh c4064uh) {
        try {
            this.p = Integer.parseInt(c4064uh.q());
            this.l0 = c4064uh.p();
            this.q0 = c4064uh.a();
            this.m0 = this.d.P7(c4064uh.c.replace(",", ""));
            this.p0 = c4064uh.b() != null ? c4064uh.b() : "";
            this.n0 = c4064uh.r();
            this.o0 = c4064uh.o() != null ? c4064uh.o() : "";
            this.r0 = c4064uh.t();
            new C3966tX().u(this);
            r1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c0(View view, boolean z) {
        if (z) {
            e1();
        } else {
            q0();
        }
    }

    public void calc_pick_btn(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", this.x.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void d0() {
        new C3966tX().f(this, this.d, this.e, this.g, -1);
    }

    public final void d1(List list) {
        Collections.sort(this.Y, new c0(null));
    }

    public final Double e0() {
        this.q = 0.0d;
        for (int size = this.Y.size() - 1; size >= 0; size--) {
            this.q += Double.parseDouble(((C4064uh) this.Y.get(size)).n().replaceAll(",", "")) * (Double.parseDouble(((C4064uh) this.Y.get(size)).f().replaceAll(",", "")) - 1.0d) * (-1.0d);
            C4064uh c4064uh = (C4064uh) this.Y.get(size);
            c4064uh.w(String.valueOf(this.q));
            this.Y.set(size, c4064uh);
        }
        return Double.valueOf(this.q);
    }

    public void f0() {
    }

    public void f1(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            if (this.F0) {
                this.J.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.J.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.J.setImageBitmap(bitmapP0);
                this.J.setTag(str);
            } else {
                this.I.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.I.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.I.setImageBitmap(bitmapP0);
                this.I.setTag(str);
            }
        } catch (Exception unused) {
        }
    }

    public void h1() {
        StringBuilder sb = new StringBuilder();
        for (int size = this.Z.size() - 1; size >= 0; size--) {
            if (this.Z.valueAt(size)) {
                C4064uh c4064uh = (C4064uh) this.X.c().get(this.Z.keyAt(size));
                sb.append(getString(c4064uh.t() == this.k0[0] ? info.aalmoghalis.inventory.R.string.credit : info.aalmoghalis.inventory.R.string.debit));
                sb.append(" ");
                sb.append(c4064uh.n());
                sb.append(" ");
                sb.append(c4064uh.r());
                sb.append(" ");
                sb.append(getString(info.aalmoghalis.inventory.R.string.day));
                sb.append(" ");
                sb.append(c4064uh.p().substring(0, 5));
                sb.append(StringUtilities.LF);
            }
        }
        this.d.td(sb.toString());
    }

    public void i1() {
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
        listView.setOnItemClickListener(new C2708t(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        listView.setDividerHeight(0);
        linearLayout.addView(listView, -1, -1);
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void j1(boolean z) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.F0 = z;
        if (!z) {
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            this.S.setVisibility(8);
            this.T.setVisibility(8);
            this.O.setVisibility(0);
            this.P.setVisibility(0);
            this.y = (TextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.C.setThreshold(1);
            this.C.setAdapter(this.b0);
            this.d.jd(this.x, this.C);
            this.I.setOnClickListener(new J(z));
            this.y.setOnClickListener(new L());
            return;
        }
        this.O.setVisibility(8);
        this.P.setVisibility(8);
        this.Q.setVisibility(0);
        this.R.setVisibility(0);
        this.S.setVisibility(0);
        this.T.setVisibility(0);
        b1();
        this.z = (TextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date4);
        this.D.setThreshold(1);
        this.D.setAdapter(this.b0);
        this.d.jd(this.x, this.D);
        this.z.setText(simpleDateFormat.format(calendar.getTime()));
        this.t = calendar.get(1);
        this.u = calendar.get(2);
        this.v = calendar.get(5);
        this.J.setOnClickListener(new H(z));
        this.z.setOnClickListener(new I());
    }

    public void k0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        autoCompleteTextView.setText("");
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new X(autoCompleteTextView, dialog, editText));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    public void l0(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new Y(textView, arrayAdapter, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void l1() {
        C4064uh c4064uhP0 = this.d.P0(this.g);
        if (C1839c10.k(this.d, this.f) || C1839c10.k(this.d, c4064uhP0.m())) {
            try {
                d0();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.d.ja("prefAutoNotify", true)) {
            Snackbar snackbarMake = Snackbar.make(this.N, "", -2);
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
            TextView textView = (TextView) snackbarLayout.findViewById(info.aalmoghalis.inventory.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(this, info.aalmoghalis.inventory.R.color.white));
            C4064uh c4064uhU0 = u0();
            StringBuilder sb = new StringBuilder();
            sb.append(c4064uhU0.t() == this.k0[0] ? this.d.Q2() : this.d.c5());
            sb.append(" ");
            sb.append(c4064uhU0.n());
            sb.append(" ");
            sb.append(c4064uhU0.r());
            snackbarMake.setText(sb.toString());
            snackbarMake.setAction(getString(info.aalmoghalis.inventory.R.string.hide_tr), new ViewOnClickListenerC2709u(snackbarMake));
            textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_share), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setOnClickListener(new ViewOnClickListenerC2710v());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();
            layoutParams.gravity = 16;
            snackbarLayout.setLayoutParams(layoutParams);
            ViewCompat.setLayoutDirection(snackbarMake.getView(), 1);
            snackbarMake.show();
            new Handler().postDelayed(new RunnableC2711w(snackbarMake), 5000);
        }
    }

    public void m0() {
        try {
            if (this.d.ja("black_list", false)) {
                this.d.Lc("black_date", "");
                this.d.Lc("black_date_done", "");
                this.d.L0();
            }
            b0();
            this.d.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public final void m1(List list) {
        Collections.sort(this.Y, new b0(this, null));
    }

    public void n1() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.d.J2(this, intent);
            this.B0 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.B0.getPath() + "");
            startActivityForResult(intent, this.u0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void o0(int i) {
        this.J0 = i;
        Log.d("trace_S_Loader_cus=", this.f + ":" + this.j + ":" + this.g + ":" + i);
        if (this.f == null) {
            return;
        }
        this.q = 0.0d;
        C4330y1 c4330y1 = this.X;
        if (c4330y1 == null) {
            C2160f10.l = 100;
        }
        if (c4330y1 == null) {
            C4330y1 c4330y2 = new C4330y1(this, this.Y, this, this);
            this.X = c4330y2;
            c4330y2.g.clear();
            this.N.setAdapter(this.X.withLoadStateFooter(new C4249x1(new View.OnClickListener() { // from class: wg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.L0(view);
                }
            })));
            this.M0 = new a0(this, null);
            this.X.addLoadStateListener(new InterfaceC3750qp() { // from class: xg
                @Override // defpackage.InterfaceC3750qp
                public final Object invoke(Object obj) {
                    return this.a.O0((CombinedLoadStates) obj);
                }
            });
        }
        SearchView searchView = this.N0;
        String string = (searchView == null || searchView.getQuery() == null) ? "" : this.N0.getQuery().toString();
        if (i == -1 || (string != null && string.length() > 0)) {
            this.X.d = string;
        }
        this.I0.f(this, this.f, this.j, this.d, CSS.Value.PERCENTAGE, i > 0 ? 1 : 0, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, i, this.K0, string, 0, 0);
        this.I0.i.k(new InterfaceC2295gf() { // from class: yg
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.P0((PagingData) obj);
            }
        });
    }

    public void o1(String str, String str2, String str3, String str4, String str5, String str6) {
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
            this.d.bd(this, autoCompleteTextView2);
            this.d.bd(this, autoCompleteTextView);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4);
            autoCompleteTextView2.setText(str6);
            editText3.setText(str5);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.d.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new Z(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.d.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C2689a(autoCompleteTextView2, editText));
            this.t0 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC2690b());
            imageView2.setOnClickListener(new ViewOnClickListenerC2691c(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new ViewOnClickListenerC2692d(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2693e());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2694f());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2695g(editText, autoCompleteTextView, autoCompleteTextView2, str, editText2, editText3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (i2 != 0) {
                if (i == 2) {
                    if (intent != null) {
                        this.x.setText(this.d.P7(intent.getStringExtra("calc_result")));
                    }
                } else if (i == 1) {
                    if (i2 == -1) {
                        Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                        this.t0.setText(string);
                        cursorQuery.close();
                        Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                    }
                } else if (i == this.v0 && intent != null) {
                    W0(intent.getData(), false);
                } else if (i == this.u0) {
                    U0(intent);
                }
            }
            C0974Ur c0974Ur = this.d.x;
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

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_customer_det_edit_rv);
        g1();
        setTitle(getString(info.aalmoghalis.inventory.R.string.action_settings5));
        this.N = (RecyclerView) findViewById(info.aalmoghalis.inventory.R.id.list_cus_det_edit);
        this.N.setLayoutManager(new LinearLayoutManager(this, 1, false));
        TextView textView = (TextView) findViewById(info.aalmoghalis.inventory.R.id.emptyResults);
        textView.setText(getString(info.aalmoghalis.inventory.R.string.wait));
        this.d = new Z00(this.c, this);
        this.e = new E00(this);
        C0990Vh c0990Vh = (C0990Vh) ViewModelProviders.of(this).get(C0990Vh.class);
        this.I0 = c0990Vh;
        c0990Vh.b.observe(this, new C2696h(textView));
        this.I0.c.observe(this, new C2703o(textView));
        Z00.Z = this.d.ja("prefOthers_currency", true);
        this.w = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.cus_name_det);
        this.x = (EditText) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        TextView textView2 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.disc_amount);
        this.A = textView2;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        this.B = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_cash);
        this.c0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.d.D3());
        TextView textView3 = this.B;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        this.B.setText(this.d.B3().j());
        String stringExtra = "";
        if (C2160f10.h != -1) {
            this.B.setText(this.d.A4(C2160f10.j + ""));
            this.B.setEnabled(false);
        }
        this.B.setOnClickListener(new ViewOnClickListenerC2714z());
        this.x.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
        EditText editText = this.x;
        editText.addTextChangedListener(new C2018dE(editText));
        this.E = (Button) findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
        this.F = (Button) findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add1);
        Button button = (Button) findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add2);
        this.G = button;
        this.d.fd(this.F, button);
        this.H = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
        this.K = (RadioGroup) findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
        this.L = (RadioButton) findViewById(info.aalmoghalis.inventory.R.id.radiobutton1);
        RadioButton radioButton = (RadioButton) findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
        this.M = radioButton;
        this.d.gd(this.L, radioButton);
        this.K.check(info.aalmoghalis.inventory.R.id.radiobutton2);
        this.e0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img);
        this.C = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
        this.D = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks4);
        this.I = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        this.J = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_attach4);
        this.O = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
        this.P = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
        this.Q = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
        this.R = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface5);
        this.S = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.LL_discount);
        this.T = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cash_interface);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.t = calendar.get(1);
        this.u = calendar.get(2);
        this.v = calendar.get(5);
        B0();
        this.a0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i0);
        this.w.setThreshold(1);
        this.w.setAdapter(this.a0);
        this.w.setOnItemClickListener(this);
        this.d.cd(this, this.w);
        j1(true);
        C0();
        try {
            if (getIntent().getStringExtra("read_imei") != null && getIntent().getStringExtra("read_imei").equals("1")) {
                F0(2, 10);
                this.d.L0();
            }
        } catch (Exception unused) {
        }
        try {
            if (getIntent().getStringExtra("CUS_NAME") == null || getIntent().getStringExtra("TR_ID") != null) {
                this.w.requestFocus();
            } else {
                this.w.setText(getIntent().getStringExtra("CUS_NAME"));
                this.g = getIntent().getStringExtra("CUS_NAME");
                this.l = getIntent().getStringExtra("CUS_GSM");
                this.f = getIntent().getStringExtra("CUS_ID");
                this.h = getIntent().getStringExtra("G_NAME");
                this.j = getIntent().getStringExtra("CURR_NAME") == null ? "" : getIntent().getStringExtra("CURR_NAME");
                this.h0 = 1;
                this.x.requestFocus();
                C0();
                j1(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (getIntent().getStringExtra("TR_ID") != null) {
                this.w.setText(getIntent().getStringExtra("CUS_NAME"));
                j1(false);
                C0();
                this.n = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
                this.x.setText(getIntent().getStringExtra("TR_AMOUNT").toString().replaceAll(",", ""));
                this.y.setText(getIntent().getStringExtra("TR_DATE").toString());
                this.s0 = getIntent().getIntExtra("back_edit", 0);
                this.j = getIntent().getStringExtra("CURR_NAME") == null ? "" : getIntent().getStringExtra("CURR_NAME");
                if (this.d.O8(this.n).equals("0")) {
                    this.K.setVisibility(0);
                    this.d.nd(this.C, getIntent().getStringExtra("TR_REMARKS").toString());
                } else {
                    this.n0 = this.d.R8(this.n);
                    this.K.setVisibility(4);
                    this.d.nd(this.C, this.n0);
                }
                int intExtra = getIntent().getIntExtra("TR_TYPE", -10);
                this.E.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
                int[] iArr = this.k0;
                if (intExtra == iArr[0]) {
                    this.L.setChecked(true);
                } else if (intExtra == iArr[2]) {
                    this.M.setChecked(true);
                }
                this.x.requestFocus();
                this.x.selectAll();
                k1();
                F0(4, 500);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (getIntent().getStringExtra("G_NAME") != null) {
                this.h = getIntent().getStringExtra("G_NAME");
                this.j = getIntent().getStringExtra("CURR_NAME") == null ? "" : getIntent().getStringExtra("CURR_NAME");
                if (getIntent().getStringExtra("CUS_TYPE") != null) {
                    stringExtra = getIntent().getStringExtra("CUS_TYPE");
                }
                this.i = stringExtra;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            t0();
            o0(0);
            this.d.L0();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(H0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.P0, this.t, this.u, this.v);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(H0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.Q0, this.t, this.u, this.v);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_main3, menu);
        this.N0 = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        this.N0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.N0.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.N0.setOnQueryTextListener(new Q());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.w.setText(adapterView.getItemAtPosition(i).toString());
        D0(this.w.getText().toString());
        o0(0);
        j1(true);
        C0();
        this.x.requestFocus();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != info.aalmoghalis.inventory.R.id.print) {
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            k1();
            finish();
            return true;
        }
        if (Build.VERSION.SDK_INT < 31) {
            a0();
        }
        try {
            SearchView searchView = this.N0;
            if (searchView == null || searchView.getQuery() == null || this.N0.getQuery().length() != 0) {
                Y0();
            } else {
                o0(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.V.setTag(radioButton.getText().toString());
            this.j = this.V.getTag() == null ? this.j : this.V.getTag().toString();
            A0();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            if (iArr.length == 1 && iArr[0] == 0) {
                this.d.Tb();
                return;
            }
            return;
        }
        if (i == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            Z(getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_storage));
            return;
        }
        if (i == 113) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            Z(getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_contacts));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (Bill_edit.P2) {
                String str = this.g;
                if (str == null || str.equals(Bill_edit.R2)) {
                    o0(0);
                    Bill_edit.P2 = false;
                    Bill_edit.R2 = "";
                } else {
                    o0(0);
                    Bill_edit.P2 = false;
                    Bill_edit.R2 = "";
                }
            } else if (this.X != null && this.e.i > 0) {
                new C3966tX().y(this, this.d, this.e, this.g);
            }
        } catch (Exception unused) {
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

    public void p0() {
        if (C2160f10.h > 0 && !new C2160f10(this.d).l("-9", HTML.Tag.DEL)) {
            Context context = this.R0;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.Z.size() - 1; size >= 0; size--) {
            if (this.Z.valueAt(size)) {
                C4064uh c4064uh = (C4064uh) this.X.c().get(this.Z.keyAt(size));
                String strA = c4064uh.a() != null ? c4064uh.a() : "";
                this.q0 = strA;
                int i = strA.equals("") ? 0 : Integer.parseInt(this.q0);
                if (i > 0) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_edit), 1).show();
                    this.n = 0;
                    return;
                }
                if (i == -2 || i == -3 || i == -4 || i == -6) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_edit_doc), 1).show();
                    this.n = 0;
                    return;
                }
                this.X.i(c4064uh);
                this.d.v0("delete from transactions where id=" + c4064uh.q());
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        A0();
        j1(true);
    }

    public void p1(String str, String str2, String str3, String str4, String str5, String str6, Handler handler) {
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
            this.d.cd(this, autoCompleteTextView2);
            this.d.cd(this, autoCompleteTextView);
            this.d.dd(this, editText2);
            this.d.ad(this, editText);
            this.d.ad(this, editText3);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4);
            autoCompleteTextView2.setText(str6);
            editText3.setText(str5);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.d.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2697i(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.d.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C2698j(autoCompleteTextView2, editText2));
            this.t0 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC2699k());
            imageView2.setOnClickListener(new ViewOnClickListenerC2700l(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new ViewOnClickListenerC2701m(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2702n());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2704p());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2705q(editText, autoCompleteTextView, autoCompleteTextView2, str, alertDialogCreate, editText2, editText3, handler));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void r0() {
        if (C2160f10.h > 0 && !new C2160f10(this.d).l("-9", "edit")) {
            Context context = this.R0;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        int size = this.Z.size() - 1;
        if (this.Z.valueAt(size)) {
            C4064uh c4064uh = (C4064uh) this.X.c().get(this.Z.keyAt(size));
            this.q0 = c4064uh.a() != null ? c4064uh.a() : "";
            this.n = Integer.parseInt(c4064uh.q());
            int i = this.q0.equals("") ? 0 : Integer.parseInt(this.q0);
            if (i > 0) {
                this.d.n9(this.q0, this, 1);
                return;
            }
            if (i == -2) {
                String strI = new C2160f10(this.d).I(this.n + "");
                Z00 z00 = this.d;
                z00.r9(z00.Q8(this.n), this.d.P8(this.n), strI, this);
                return;
            }
            if (i == -3) {
                String strI2 = new C2160f10(this.d).I(this.n + "");
                Z00 z01 = this.d;
                z01.s9(z01.Q8(this.n), this.d.H8(this.n), this.d.P8(this.n), strI2, this);
                return;
            }
            if (i == -6) {
                String strI3 = new C2160f10(this.d).I(this.n + "");
                Z00 z02 = this.d;
                z02.p9(z02.Q8(this.n), this.d.H8(this.n), this.d.P8(this.n), strI3, this);
                return;
            }
            if (i == -4) {
                this.d.t9(this.n + "", this);
                return;
            }
            j1(false);
            this.n = Integer.parseInt(c4064uh.q().toString());
            this.x.setText(c4064uh.n().toString().replaceAll(",", ""));
            this.y.setText(c4064uh.p());
            this.I.setTag(c4064uh.o() != null ? c4064uh.o() : "");
            int iT = c4064uh.t();
            this.p0 = c4064uh.b();
            this.E.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
            int[] iArr = this.k0;
            if (iT == iArr[0]) {
                this.L.setChecked(true);
            } else if (iT == iArr[2]) {
                this.M.setChecked(true);
            }
            this.n0 = c4064uh.h();
            if (this.d.O8(this.n).equals("0")) {
                this.K.setVisibility(0);
                this.d.nd(this.C, c4064uh.r());
            } else {
                this.K.setVisibility(4);
                this.d.nd(this.C, this.n0);
            }
            if (this.I.getTag().toString().equals("")) {
                c1(this.I);
            } else {
                f1(this.I.getTag().toString());
            }
            t0();
            this.x.selectAll();
            this.x.requestFocus();
            k1();
            F0(4, 500);
        }
    }

    public void r1() {
        try {
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.customer_det_view, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_time);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_type);
            TextView textView4 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            if (!this.d.O8(this.p).equals("0")) {
                this.n0 = this.d.R8(this.p);
            }
            textView4.setText(this.n0);
            textView2.setText(this.l0);
            textView.setText(this.m0);
            textView3.setText(this.d.S8(this.p));
            if (Z00.Z) {
                ((TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_curr_view)).setVisibility(0);
                ((TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_curr_name)).setText(this.p0);
            }
            imageView2.setImageResource(this.r0);
            if (this.o0.equals("")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(Z00.p0(Z00.M + this.o0, 300, 300));
                imageView.setTag(this.o0);
                imageView.getLayoutParams().width = 200;
                imageView.getLayoutParams().height = 200;
            }
            builder.setCancelable(true);
            if (imageView.getTag() != null) {
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.view_image), new K(imageView));
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new U());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new W());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.w.getText().toString());
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("view_item_error=", ":" + e.getMessage());
        }
    }

    public void s0() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.d).l("-9", "edit")) {
                Context context = this.R0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.d).l("-9", "new")) {
            Context context2 = this.R0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        Log.d("edit_item:", this.q0 + "");
        int i = this.q0.equals("") ? 0 : Integer.parseInt(this.q0);
        if (i > 0) {
            this.d.n9(this.q0, this, 1);
            return;
        }
        if (i == -2) {
            String strI = new C2160f10(this.d).I(this.n + "");
            Z00 z00 = this.d;
            z00.r9(z00.Q8(this.n), this.d.P8(this.n), strI, this);
            return;
        }
        if (i == -3) {
            String strI2 = new C2160f10(this.d).I(this.n + "");
            Z00 z01 = this.d;
            z01.s9(z01.Q8(this.n), this.d.H8(this.n), this.d.P8(this.n), strI2, this);
            return;
        }
        if (i == -6) {
            String strI3 = new C2160f10(this.d).I(this.n + "");
            Z00 z02 = this.d;
            z02.p9(z02.Q8(this.n), this.d.H8(this.n), this.d.P8(this.n), strI3, this);
            return;
        }
        if (i == -4) {
            this.d.t9(this.n + "", this);
            return;
        }
        j1(false);
        t0();
        this.n = this.p;
        this.x.setText(this.m0);
        this.y.setText(this.l0);
        this.I.setTag(this.o0);
        int i2 = this.r0;
        this.E.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
        int[] iArr = this.k0;
        if (i2 == iArr[0]) {
            this.L.setChecked(true);
        } else if (i2 == iArr[2]) {
            this.M.setChecked(true);
        }
        if (this.d.O8(this.n).equals("0")) {
            this.K.setVisibility(0);
        } else {
            this.n0 = this.d.R8(this.n);
            this.K.setVisibility(4);
        }
        this.d.nd(this.C, this.n0);
        Log.d("tr_attach_l=", this.o0);
        if (this.o0.equals("")) {
            c1(this.I);
        } else {
            Log.d("tr_attach_l=", this.o0);
            f1(this.o0);
        }
        this.x.selectAll();
        this.x.requestFocus();
        k1();
        F0(4, 500);
        C0();
    }

    public void t0() {
        this.U = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
        this.V = (RadioGroup) findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        if (Z00.Z) {
            ArrayList arrayListJ3 = this.d.j3();
            this.W = arrayListJ3;
            String str = this.j;
            if (str == null) {
                str = "";
            }
            this.j = str;
            int size = arrayListJ3.size();
            RadioButton[] radioButtonArr = new RadioButton[size];
            this.V.setTag(null);
            this.V.removeAllViews();
            this.V.clearCheck();
            for (int i = 0; i < this.W.size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButtonArr[i] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.W.get(i)).get("name"));
                radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.W.get(i)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i].setOnClickListener(new P());
                this.V.addView(radioButtonArr[i]);
                String str2 = this.p0;
                if (str2 != null && str2.equals(((HashMap) this.W.get(i)).get("name"))) {
                    this.V.check(radioButtonArr[i].getId());
                    this.V.setTag(((HashMap) this.W.get(i)).get("name"));
                }
            }
            if (!this.j.equals("")) {
                this.V.setTag(this.j);
                for (int i2 = 0; i2 < size; i2++) {
                    if (radioButtonArr[i2].getText().toString().equals(this.j)) {
                        this.V.check(radioButtonArr[i2].getId());
                    }
                }
                return;
            }
            String str3 = this.p0;
            if (str3 == null || str3.equals("")) {
                this.V.check(radioButtonArr[this.W.size() - 1].getId());
                this.V.setTag(radioButtonArr[this.W.size() - 1].getText().toString());
                this.j = radioButtonArr[this.W.size() - 1].getText().toString();
            }
        }
    }

    public final C4064uh u0() {
        Cursor cursorS7 = this.d.s7(this.w.getText().toString());
        cursorS7.moveToFirst();
        C4064uh c4064uh = null;
        while (!cursorS7.isAfterLast()) {
            c4064uh = new C4064uh(cursorS7.getString(cursorS7.getColumnIndex("_id")), cursorS7.getString(cursorS7.getColumnIndex("date_")), "" + cursorS7.getDouble(cursorS7.getColumnIndex("amount")), cursorS7.getString(cursorS7.getColumnIndex("remarks")), this.k0[cursorS7.getInt(cursorS7.getColumnIndex("_in"))], String.valueOf(cursorS7.getInt(cursorS7.getColumnIndex("_in"))), cursorS7.getString(cursorS7.getColumnIndex("param1")), cursorS7.getString(cursorS7.getColumnIndex("curr_name")));
            cursorS7.moveToNext();
        }
        cursorS7.close();
        return c4064uh;
    }

    public void update_disc_amount(View view) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_discount_amount, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_price);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.disc_remarks);
            editText.setText(this.d.P7(String.valueOf(this.G0)));
            editText.addTextChangedListener(new C2018dE(editText));
            editText.requestFocus();
            editText.selectAll();
            builder.setPositiveButton("OK", new M());
            builder.setNegativeButton("Cancel", new N());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.discount_hdr));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new O(editText, editText2, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item_error=", e.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String w0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public String x0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (J0(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (I0(uri)) {
                        return w0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (K0(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return w0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return w0(context, uri, null, null);
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

    public boolean y0(String str, String str2, Context context) {
        E e = new E();
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new F(e));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new G(e));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        B0();
        return this.C0;
    }

    public boolean z0(String str, String str2, Context context) {
        B b = new B();
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new C(b));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new D(b));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.D0;
    }

    @Override // defpackage.DE
    public void e(int i, C4145vh c4145vh) {
    }
}
