package info.aalmoghalis.inventory.activity;

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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
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
import androidx.appcompat.app.AlertDialog;
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
import defpackage.C3962tT;
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
public class Customer_Det_List_edit2 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, C4330y1.c, DE {
    public Uri B0;
    public boolean C0;
    public boolean D0;
    public C3962tT G0;
    public boolean I0;
    public C0990Vh K0;
    public ActionMode N0;
    public a0 O0;
    public TextView P;
    public SearchView P0;
    public C4330y1 X;
    public SparseBooleanArray Z;
    public ArrayAdapter a0;
    public ArrayAdapter b0;
    public SQLiteDatabase h;
    public Z00 i;
    public E00 j;
    public String k;
    public EditText t0;
    public int u;
    public int w;
    public int x;
    public int y;
    public String y0;
    public String l = null;
    public String n = null;
    public String p = null;
    public String q = null;
    public String t = null;
    public double v = 0.0d;
    public AutoCompleteTextView z = null;
    public AutoCompleteTextView A = null;
    public EditText B = null;
    public TextView C = null;
    public TextView D = null;
    public AutoCompleteTextView E = null;
    public AutoCompleteTextView F = null;
    public Button G = null;
    public Button H = null;
    public Button I = null;
    public ImageView J = null;
    public ImageView K = null;
    public RadioGroup L = null;
    public RadioButton M = null;
    public RadioButton N = null;
    public RecyclerView O = null;
    public LinearLayout Q = null;
    public LinearLayout R = null;
    public LinearLayout S = null;
    public LinearLayout T = null;
    public LinearLayout U = null;
    public RadioGroup V = null;
    public ArrayList W = new ArrayList();
    public List Y = new ArrayList();
    public ImageButton c0 = null;
    public ImageView d0 = null;
    public String e0 = "";
    public String f0 = "";
    public int g0 = 0;
    public String[] h0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] i0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] j0 = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public String k0 = null;
    public String l0 = null;
    public String m0 = null;
    public String n0 = null;
    public String o0 = null;
    public String p0 = null;
    public int q0 = 0;
    public String r0 = null;
    public String s0 = null;
    public int u0 = 3;
    public int v0 = 4;
    public int w0 = 0;
    public int x0 = 1;
    public ActivityResultLauncher z0 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Og
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.X0((Uri) obj);
        }
    });
    public ActivityResultLauncher A0 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new C2733s());
    public String E0 = "";
    public boolean F0 = false;
    public ArrayList H0 = new ArrayList();
    public boolean J0 = false;
    public int L0 = 0;
    public int M0 = 0;
    public final Handler Q0 = new Handler(Looper.getMainLooper());
    public DatePickerDialog.OnDateSetListener R0 = new U();
    public DatePickerDialog.OnDateSetListener S0 = new V();
    public int T0 = 0;
    public String U0 = "";

    public class A implements View.OnClickListener {
        public final /* synthetic */ String a;

        public A(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
            customer_Det_List_edit2.i.nd(customer_Det_List_edit2.E, this.a);
            Customer_Det_List_edit2.this.G.performClick();
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
            Customer_Det_List_edit2.this.b0(this.a);
            Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
            customer_Det_List_edit2.I0 = customer_Det_List_edit2.C0;
        }
    }

    public class D implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public D(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit2.this.I0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class E implements View.OnClickListener {
        public E() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit2.this.h0()) {
                Customer_Det_List_edit2.this.G0();
            }
        }
    }

    public class F implements Runnable {
        public final /* synthetic */ int a;

        public F(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == 4) {
                Customer_Det_List_edit2.this.B.selectAll();
            }
        }
    }

    public class G implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public G(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2.this.f0(view, this.a);
        }
    }

    public class H implements View.OnClickListener {
        public H() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2.this.showDialog(0);
        }
    }

    public class I implements AdapterView.OnItemClickListener {
        public I() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit2.this.z.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
            customer_Det_List_edit2.K0(customer_Det_List_edit2.z.getText().toString());
            if (!Customer_Det_List_edit2.this.i.ja("t_name_lock", false) || Customer_Det_List_edit2.this.A.getText() == null || Customer_Det_List_edit2.this.A.getText().toString().length() <= 0) {
                Customer_Det_List_edit2.this.A.requestFocus();
            } else {
                Customer_Det_List_edit2.this.B.requestFocus();
            }
            Customer_Det_List_edit2.this.s0(0);
            Customer_Det_List_edit2.this.j1();
        }
    }

    public class J implements AdapterView.OnItemClickListener {
        public J() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Customer_Det_List_edit2.this.A.setText(adapterView.getItemAtPosition(i).toString());
            Customer_Det_List_edit2.this.j1();
            Customer_Det_List_edit2.this.B.requestFocus();
        }
    }

    public class K implements View.OnTouchListener {
        public K() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit2.this.z.getCompoundDrawables()[0] != null ? Customer_Det_List_edit2.this.z.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit2.this.z.getPaddingLeft() + Customer_Det_List_edit2.this.z.getLeft()) {
                    Customer_Det_List_edit2.this.z.setText("");
                    Customer_Det_List_edit2.this.z.requestFocus();
                    Customer_Det_List_edit2.this.j1();
                    return false;
                }
                if (motionEvent.getX() >= (Customer_Det_List_edit2.this.z.getRight() - Customer_Det_List_edit2.this.z.getPaddingRight()) - (Customer_Det_List_edit2.this.z.getCompoundDrawables()[2] != null ? Customer_Det_List_edit2.this.z.getCompoundDrawables()[2].getBounds().width() : 0)) {
                    Z00 z00 = Customer_Det_List_edit2.this.i;
                    z00.Mc("f_name_lock", true ^ z00.ja("f_name_lock", true));
                    Customer_Det_List_edit2.this.h1();
                }
            }
            return false;
        }
    }

    public class L implements TextWatcher {
        public L() {
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
                Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                customer_Det_List_edit2.z.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit2, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit2.this.z.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit2.this.z;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class M implements View.OnTouchListener {
        public M() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Customer_Det_List_edit2.this.A.getCompoundDrawables()[0] != null ? Customer_Det_List_edit2.this.A.getCompoundDrawables()[0].getBounds().width() : 0) + Customer_Det_List_edit2.this.A.getPaddingLeft() + Customer_Det_List_edit2.this.A.getLeft()) {
                    Customer_Det_List_edit2.this.A.setText("");
                    Customer_Det_List_edit2.this.A.requestFocus();
                    Customer_Det_List_edit2.this.j1();
                    return false;
                }
                if (motionEvent.getX() >= (Customer_Det_List_edit2.this.A.getRight() - Customer_Det_List_edit2.this.A.getPaddingRight()) - (Customer_Det_List_edit2.this.A.getCompoundDrawables()[2] != null ? Customer_Det_List_edit2.this.A.getCompoundDrawables()[2].getBounds().width() : 0)) {
                    Z00 z00 = Customer_Det_List_edit2.this.i;
                    z00.Mc("t_name_lock", true ^ z00.ja("t_name_lock", false));
                    Customer_Det_List_edit2.this.h1();
                }
            }
            return false;
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
                Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                customer_Det_List_edit2.A.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(customer_Det_List_edit2, android.R.drawable.ic_notification_clear_all), (Drawable) null, Customer_Det_List_edit2.this.A.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Customer_Det_List_edit2.this.A;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class O implements TextWatcher {
        public O() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Customer_Det_List_edit2.this.j1();
        }
    }

    public class P implements View.OnClickListener {
        public P() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit2.this.h0()) {
                Customer_Det_List_edit2.this.G0();
                Customer_Det_List_edit2.this.u1();
            }
        }
    }

    public class Q implements View.OnClickListener {
        public Q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Customer_Det_List_edit2.this.i0()) {
                Customer_Det_List_edit2.this.G0();
            }
        }
    }

    public class R implements View.OnClickListener {
        public R() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2.this.onRadioButtonClicked(view);
        }
    }

    public class S implements DialogInterface.OnClickListener {
        public final /* synthetic */ ImageView a;

        public S(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit2.this.i.qa(Z00.M + this.a.getTag().toString());
            } catch (Exception unused) {
            }
        }
    }

    public class T implements SearchView.OnQueryTextListener {

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Customer_Det_List_edit2.this.c1(this.a);
            }
        }

        public T() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Customer_Det_List_edit2.this.Q0.removeCallbacksAndMessages(null);
            Customer_Det_List_edit2.this.Q0.postDelayed(new a(str), new C2160f10().V(str));
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class U implements DatePickerDialog.OnDateSetListener {
        public U() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit2.this.w = i;
            Customer_Det_List_edit2.this.x = i2;
            Customer_Det_List_edit2.this.y = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit2.this.y)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit2.this.x + 1)) + "-" + Customer_Det_List_edit2.this.w;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit2.this.C.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class V implements DatePickerDialog.OnDateSetListener {
        public V() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit2.this.w = i;
            Customer_Det_List_edit2.this.x = i2;
            Customer_Det_List_edit2.this.y = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit2.this.y)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit2.this.x + 1)) + "-" + Customer_Det_List_edit2.this.w;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit2.this.D.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
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

    public class X implements DialogInterface.OnClickListener {
        public X() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit2.this.w0();
            } catch (Exception e) {
                e.printStackTrace();
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

    public class Z implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public Z(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$a, reason: case insensitive filesystem */
    public class C2715a implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2715a(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    public class a0 implements ActionMode.Callback {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Customer_Det_List_edit2.this.t0();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit2.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayE = Customer_Det_List_edit2.this.X.e();
                    Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                    customer_Det_List_edit2.Z = sparseBooleanArrayE;
                    AlertDialog.Builder builder = new AlertDialog.Builder(customer_Det_List_edit2);
                    builder.setMessage(Customer_Det_List_edit2.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
                    builder.setPositiveButton(Customer_Det_List_edit2.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
                    builder.setNegativeButton(Customer_Det_List_edit2.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayE2 = Customer_Det_List_edit2.this.X.e();
                    Customer_Det_List_edit2 customer_Det_List_edit3 = Customer_Det_List_edit2.this;
                    customer_Det_List_edit3.Z = sparseBooleanArrayE2;
                    customer_Det_List_edit3.v0();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_share /* 2131297045 */:
                    SparseBooleanArray sparseBooleanArrayE3 = Customer_Det_List_edit2.this.X.e();
                    Customer_Det_List_edit2 customer_Det_List_edit4 = Customer_Det_List_edit2.this;
                    customer_Det_List_edit4.Z = sparseBooleanArrayE3;
                    customer_Det_List_edit4.q1();
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
            Customer_Det_List_edit2.this.O.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Customer_Det_List_edit2.this.X.g.clear();
            Customer_Det_List_edit2.this.X.j();
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Customer_Det_List_edit2.this.X.d() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        public /* synthetic */ a0(Customer_Det_List_edit2 customer_Det_List_edit2, C2719e c2719e) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$b, reason: case insensitive filesystem */
    public class C2716b implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2716b(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

        public /* synthetic */ b0(Customer_Det_List_edit2 customer_Det_List_edit2, C2719e c2719e) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2717c implements View.OnClickListener {
        public ViewOnClickListenerC2717c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2.this.phone_pick_btn(view);
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

        public /* synthetic */ c0(C2719e c2719e) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2718d implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2718d(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2.this.p0(this.a, this.b);
        }
    }

    public class d0 extends AsyncTask {
        public int a;

        public d0(int i) {
            this.a = i;
        }

        public final Double a() {
            Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
            customer_Det_List_edit2.v = 0.0d;
            for (int size = customer_Det_List_edit2.Y.size() - 1; size >= 0; size--) {
                Customer_Det_List_edit2 customer_Det_List_edit3 = Customer_Det_List_edit2.this;
                customer_Det_List_edit3.v += Double.parseDouble(((C4064uh) customer_Det_List_edit3.Y.get(size)).n().replaceAll(",", "")) * (Double.parseDouble(((C4064uh) Customer_Det_List_edit2.this.Y.get(size)).f()) - 1.0d) * (-1.0d);
                C4064uh c4064uh = (C4064uh) Customer_Det_List_edit2.this.Y.get(size);
                c4064uh.w(String.valueOf(Customer_Det_List_edit2.this.v));
                Customer_Det_List_edit2.this.Y.set(size, c4064uh);
            }
            return Double.valueOf(Customer_Det_List_edit2.this.v);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double doInBackground(Void... voidArr) {
            try {
                int i = this.a;
                if (i != 0 && i != 1) {
                    if (i == 2) {
                        Customer_Det_List_edit2.this.a1();
                        return Double.valueOf(0.0d);
                    }
                    if (i == 3) {
                        Customer_Det_List_edit2.this.I0();
                        return Double.valueOf(0.0d);
                    }
                    if (i != 4) {
                        return Double.valueOf(0.0d);
                    }
                    Customer_Det_List_edit2.this.i1();
                    return Double.valueOf(0.0d);
                }
                return a();
            } catch (Exception unused) {
                return Double.valueOf(0.0d);
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Double d) {
            int i = this.a;
            if (i == 0) {
                Customer_Det_List_edit2.this.X.notifyDataSetChanged();
                return;
            }
            if (i == 1) {
                Customer_Det_List_edit2.this.z1();
                return;
            }
            if (i == 2) {
                Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                customer_Det_List_edit2.i.F0(customer_Det_List_edit2);
            } else if (i == 3) {
                Customer_Det_List_edit2.this.J0();
            } else if (i == 4) {
                Customer_Det_List_edit2.this.k1();
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Customer_Det_List_edit2.this.v = 0.0d;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$e, reason: case insensitive filesystem */
    public class C2719e implements Observer {
        public C2719e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            Customer_Det_List_edit2.this.X.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(List list) {
            new C2160f10(list).e(1);
            Customer_Det_List_edit2.this.X.l(list);
            Customer_Det_List_edit2.this.runOnUiThread(new Runnable() { // from class: Tg
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            Customer_Det_List_edit2.this.X.getFilter().filter(Customer_Det_List_edit2.this.P0.getQuery());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            Customer_Det_List_edit2.this.X.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(List list) {
            if (Build.VERSION.SDK_INT <= 29) {
                new C2160f10(list).e(2);
            }
            Customer_Det_List_edit2.this.X.l(list);
            SearchView searchView = Customer_Det_List_edit2.this.P0;
            if (searchView == null || searchView.getQuery().length() <= 0) {
                Customer_Det_List_edit2.this.runOnUiThread(new Runnable() { // from class: Vg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.i();
                    }
                });
            } else {
                Customer_Det_List_edit2.this.runOnUiThread(new Runnable() { // from class: Ug
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
            Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
            c3966tX.z(customer_Det_List_edit2, customer_Det_List_edit2.O, customer_Det_List_edit2.P, list == null ? 0 : list.size());
            Customer_Det_List_edit2 customer_Det_List_edit3 = Customer_Det_List_edit2.this;
            if (customer_Det_List_edit3.X != null) {
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: Sg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j(list);
                    }
                });
                executorServiceNewSingleThreadExecutor.shutdown();
            } else {
                customer_Det_List_edit3.e1(list);
                if (Build.VERSION.SDK_INT <= 29) {
                    ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
                    executorServiceNewSingleThreadExecutor2.submit(new Runnable() { // from class: Rg
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$f, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2720f implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2720f(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2.this.p0(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$g, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2721g implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2721g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$h, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2722h implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2722h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$i, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2723i implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ Handler h;

        public ViewOnClickListenerC2723i(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, AlertDialog alertDialog, EditText editText2, EditText editText3, Handler handler) {
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
            if (Customer_Det_List_edit2.this.i.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit2.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit2.this.i.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit2.this.E0 = this.b.getText().toString();
                Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                customer_Det_List_edit2.E0(customer_Det_List_edit2.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit2.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit2.this.E0, Customer_Det_List_edit2.this);
                if (!Customer_Det_List_edit2.this.C0) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit2.this.i.r1(this.c.getText().toString());
                if (this.d.equals("0")) {
                    if (Customer_Det_List_edit2.this.i.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        Customer_Det_List_edit2 customer_Det_List_edit3 = Customer_Det_List_edit2.this;
                        customer_Det_List_edit3.i.Qd(customer_Det_List_edit3, customer_Det_List_edit3.O, this.a.getText().toString().trim() + " : " + Customer_Det_List_edit2.this.getString(info.aalmoghalis.inventory.R.string.exist), 5000, 2);
                        FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit2.this);
                        this.e.dismiss();
                        return;
                    }
                    Customer_Det_List_edit2.this.i.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.f.getText().toString() + "','" + this.g.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                    Handler handler = this.h;
                    handler.sendMessage(handler.obtainMessage());
                } else if (this.d != null) {
                    Customer_Det_List_edit2.this.i.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.f.getText().toString() + "',address='" + this.g.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit2.this.k + "' and id>0 ");
                    Handler handler2 = this.h;
                    handler2.sendMessage(handler2.obtainMessage());
                }
                this.e.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$j, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2724j implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2724j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (Customer_Det_List_edit2.this.u != 0) {
                    Customer_Det_List_edit2.this.i.v0("delete from transactions  where id='" + Customer_Det_List_edit2.this.u + "'");
                    Customer_Det_List_edit2.this.B.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    Customer_Det_List_edit2.this.D.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                    Customer_Det_List_edit2.this.w = calendar.get(1);
                    Customer_Det_List_edit2.this.x = calendar.get(2);
                    Customer_Det_List_edit2.this.y = calendar.get(5);
                    Customer_Det_List_edit2.this.F.setText((CharSequence) null);
                    Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                    customer_Det_List_edit2.G.setText(customer_Det_List_edit2.getString(info.aalmoghalis.inventory.R.string.btn_add));
                    Customer_Det_List_edit2.this.u = 0;
                    Customer_Det_List_edit2.this.G0();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$k, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2725k implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2725k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$l, reason: case insensitive filesystem */
    public class C2726l implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C2726l(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (i <= 1) {
                C3966tX c3966tX = new C3966tX();
                Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                c3966tX.f(customer_Det_List_edit2, customer_Det_List_edit2.i, customer_Det_List_edit2.j, customer_Det_List_edit2.l, i);
            } else if (i == 2) {
                Customer_Det_List_edit2 customer_Det_List_edit3 = Customer_Det_List_edit2.this;
                C4064uh c4064uhP0 = customer_Det_List_edit3.i.P0(customer_Det_List_edit3.l);
                Customer_Det_List_edit2 customer_Det_List_edit4 = Customer_Det_List_edit2.this;
                Z00 z00 = customer_Det_List_edit4.i;
                z00.td(z00.zd(customer_Det_List_edit4.z0(), Customer_Det_List_edit2.this.l, Double.parseDouble(c4064uhP0.v)));
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$m, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2727m implements View.OnClickListener {
        public final /* synthetic */ Snackbar a;

        public ViewOnClickListenerC2727m(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$n, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2728n implements View.OnClickListener {
        public ViewOnClickListenerC2728n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2.this.r1();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$o, reason: case insensitive filesystem */
    public class RunnableC2729o implements Runnable {
        public final /* synthetic */ Snackbar a;

        public RunnableC2729o(Snackbar snackbar) {
            this.a = snackbar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$p, reason: case insensitive filesystem */
    public class C2730p implements Observer {
        public C2730p() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                C3966tX c3966tX = new C3966tX();
                Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                c3966tX.z(customer_Det_List_edit2, customer_Det_List_edit2.O, customer_Det_List_edit2.P, -1);
            } else {
                C3966tX c3966tX2 = new C3966tX();
                Customer_Det_List_edit2 customer_Det_List_edit3 = Customer_Det_List_edit2.this;
                c3966tX2.z(customer_Det_List_edit3, customer_Det_List_edit3.O, customer_Det_List_edit3.P, 1);
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$q, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2731q implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC2731q(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit2.this);
                if (this.a[i].equals(Customer_Det_List_edit2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                    customer_Det_List_edit2.y0 = customer_Det_List_edit2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit2.this.j0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit2 customer_Det_List_edit3 = Customer_Det_List_edit2.this;
                    customer_Det_List_edit3.y0 = customer_Det_List_edit3.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit2.this.A0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit2.this.i.qa(Z00.M + Customer_Det_List_edit2.this.K.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit2.this.K.setTag(null);
                    Customer_Det_List_edit2.this.K.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$r, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2732r implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public DialogInterfaceOnClickListenerC2732r(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit2.this);
                if (this.a[i].equals(Customer_Det_List_edit2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit2 customer_Det_List_edit2 = Customer_Det_List_edit2.this;
                    customer_Det_List_edit2.y0 = customer_Det_List_edit2.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit2.this.j0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit2 customer_Det_List_edit3 = Customer_Det_List_edit2.this;
                    customer_Det_List_edit3.y0 = customer_Det_List_edit3.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit2.this.A0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit2.this.i.qa(Z00.M + Customer_Det_List_edit2.this.K.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit2.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit2.this.K.setTag(null);
                    Customer_Det_List_edit2.this.K.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Customer_Det_List_edit2.this.K.getLayoutParams().width = (int) Customer_Det_List_edit2.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Customer_Det_List_edit2.this.K.getLayoutParams().height = (int) Customer_Det_List_edit2.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$s, reason: case insensitive filesystem */
    public class C2733s implements ActivityResultCallback {
        public C2733s() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Customer_Det_List_edit2.this.w1();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$t, reason: case insensitive filesystem */
    public class HandlerC2734t extends Handler {
        public HandlerC2734t() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$u, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2735u implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2735u(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit2.this.i.v0("insert into groups  (name )  values( '" + Customer_Det_List_edit2.this.E0 + "'  )");
            Customer_Det_List_edit2.this.D0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$v, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2736v implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2736v(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit2.this.D0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$w, reason: case insensitive filesystem */
    public class HandlerC2737w extends Handler {
        public HandlerC2737w() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$x, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2738x implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2738x(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit2.this.a0(this.a);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$y, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2739y implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC2739y(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit2.this.C0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit2$z, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2740z implements View.OnClickListener {
        public ViewOnClickListenerC2740z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit2.this.calc_pick_btn(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
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

    private boolean N0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean O0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && N0(21, 22);
    }

    public static boolean P0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean Q0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean R0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(View view) {
        this.X.retry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0() {
        this.X.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0() {
        this.O.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FW V0(CombinedLoadStates combinedLoadStates) {
        Log.d("trace_2loadStates:=", this.L0 + ":" + combinedLoadStates.toString());
        if (combinedLoadStates.getPrepend().getEndOfPaginationReached()) {
            e1(null);
            if (this.L0 == -1) {
                new Handler().postDelayed(new Runnable() { // from class: Pg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.T0();
                    }
                }, 0L);
            }
            if (this.L0 == 1) {
                f1();
            }
            if (this.L0 == 0 && this.O.computeVerticalScrollOffset() == 0) {
                new Handler().postDelayed(new Runnable() { // from class: Qg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.U0();
                    }
                }, 0L);
            }
            this.L0 = 0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(PagingData pagingData) {
        this.X.submitData(getLifecycle(), pagingData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        d1(uri, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer Y0() {
        v1(this.X.c());
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0(Integer num) {
        this.X.notifyDataSetChanged();
        g1();
    }

    private void b1(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                r0(new File(Z00.A0), file2);
            } else {
                r0(new File(C0(this, this.B0)), file2);
            }
            p1(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void c0(String str) {
        new AlertDialog.Builder(this).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(info.aalmoghalis.inventory.R.string.yes, new W()).show();
    }

    private void d1(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.i, this);
            if (strX != null) {
                p1(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            w1();
            return;
        }
        int i = Integer.parseInt(this.i.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.i.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.A0.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean k0() {
        Log.d("IMEI=", "AFTER VALIDATION");
        boolean zA = AbstractC4371yX.a(this.B);
        if (!AbstractC4371yX.a(this.F)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.z)) {
            zA = false;
        }
        if (this.z.getText().toString().equals(this.A.getText().toString())) {
            this.A.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.i.u3(this.z.getText().toString()) == 0 && this.i.u3(this.z.getText().toString().trim()) == 0) {
            this.z.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (!this.i.Q()) {
            this.G.setError(null);
            return zA;
        }
        q0();
        this.G.setError(getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    private void l1() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_PHONE_STATE")) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        }
    }

    private void m0() {
        if (this.i.u3(this.z.getText().toString()) == 0 && this.i.u3(this.z.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.z;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.z.getText().toString().length() >= 1 && this.G.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_add))) {
                D0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + ((Object) this.z.getText()), this);
            }
        }
        if (this.z.getText().toString().equals(this.z.getText().toString().trim()) || this.i.u3(this.z.getText().toString().trim()) <= 0) {
            return;
        }
        AutoCompleteTextView autoCompleteTextView2 = this.z;
        autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
    }

    private void m1(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
    }

    private void n1(List list) {
        Collections.sort(this.Y, new c0(null));
    }

    private boolean o0() {
        boolean zA = AbstractC4371yX.a(this.B);
        if (!AbstractC4371yX.a(this.E)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.z)) {
            zA = false;
        }
        if (this.i.u3(this.z.getText().toString()) == 0 && this.i.u3(this.z.getText().toString().trim()) == 0) {
            this.z.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (!this.i.Q()) {
            this.G.setError(null);
            return zA;
        }
        q0();
        this.G.setError(getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    private void o1() {
        String[] stringArray = getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC2731q(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    private void r0(File file, File file2) throws IOException {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(int i) {
        this.L0 = i;
        Log.d("trace_S_Loader_cus=", this.k + ":" + this.p + ":" + this.l);
        if (this.k == null) {
            return;
        }
        C4330y1 c4330y1 = this.X;
        if (c4330y1 == null) {
            C2160f10.l = 100;
        }
        if (c4330y1 == null) {
            C4330y1 c4330y2 = new C4330y1(this, this.Y, this, this);
            this.X = c4330y2;
            c4330y2.g.clear();
            this.O.setAdapter(this.X.withLoadStateFooter(new C4249x1(new View.OnClickListener() { // from class: Lg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.S0(view);
                }
            })));
            this.O0 = new a0(this, null);
            this.X.addLoadStateListener(new InterfaceC3750qp() { // from class: Mg
                @Override // defpackage.InterfaceC3750qp
                public final Object invoke(Object obj) {
                    return this.a.V0((CombinedLoadStates) obj);
                }
            });
        }
        this.v = 0.0d;
        SearchView searchView = this.P0;
        String string = (searchView == null || searchView.getQuery() == null) ? "" : this.P0.getQuery().toString();
        if (i == -1 || (string != null && string.length() > 0)) {
            this.X.d = string;
        }
        this.K0.f(this, this.k, this.p, this.i, CSS.Value.PERCENTAGE, i > 0 ? 1 : 0, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, i, this.M0, string, 0, 0);
        this.K0.i.k(new InterfaceC2295gf() { // from class: Ng
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.W0((PagingData) obj);
            }
        });
    }

    private void s1() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    private void u0() {
        String[] stringArray = this.K.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new DialogInterfaceOnClickListenerC2732r(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    private void v1(List list) {
        Collections.sort(this.Y, new b0(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C4064uh z0() {
        Cursor cursorS7 = this.i.s7(this.z.getText().toString());
        cursorS7.moveToFirst();
        C4064uh c4064uh = null;
        while (!cursorS7.isAfterLast()) {
            c4064uh = new C4064uh(cursorS7.getString(cursorS7.getColumnIndex("_id")), cursorS7.getString(cursorS7.getColumnIndex("date_")), "" + cursorS7.getDouble(cursorS7.getColumnIndex("amount")), cursorS7.getString(cursorS7.getColumnIndex("remarks")), this.j0[cursorS7.getInt(cursorS7.getColumnIndex("_in"))], String.valueOf(cursorS7.getInt(cursorS7.getColumnIndex("_in"))), cursorS7.getString(cursorS7.getColumnIndex("param1")), cursorS7.getString(cursorS7.getColumnIndex("curr_name")));
            cursorS7.moveToNext();
        }
        cursorS7.close();
        return c4064uh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        C4330y1 c4330y1 = new C4330y1(this, this.Y, this, this);
        this.X = c4330y1;
        c4330y1.g.clear();
        n1(this.Y);
        this.X.notifyDataSetChanged();
        this.O.setAdapter(this.X);
    }

    public void A1() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.customer_det_view, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_time);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_type);
            TextView textView4 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.r0 = "";
            if (!this.i.O8(this.u).equals("0")) {
                this.m0 = this.i.R8(this.u);
                this.s0 = this.l;
                String strT8 = this.i.T8(this.u);
                this.r0 = strT8;
                if (strT8.equals(this.l)) {
                    this.s0 = this.i.N8(this.u);
                }
            }
            textView4.setText(this.m0);
            textView2.setText(this.k0);
            textView.setText(this.l0);
            textView3.setText(this.i.S8(this.u));
            if (Z00.Z) {
                ((TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_curr_view)).setVisibility(0);
                ((TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_curr_name)).setText(this.o0);
            }
            imageView2.setImageResource(this.q0);
            if (this.n0.equals("")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(Z00.p0(Z00.M + this.n0, 300, 300));
                imageView.setTag(this.n0);
                imageView.getLayoutParams().width = 200;
                imageView.getLayoutParams().height = 200;
            }
            builder.setCancelable(true);
            if (imageView.getTag() != null) {
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.view_image), new S(imageView));
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new X());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new Y());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.z.getText().toString());
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("adv_search_error=", ":" + e.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String B0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public String C0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (Q0(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (P0(uri)) {
                        return B0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (R0(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return B0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return B0(context, uri, null, null);
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

    public boolean D0(String str, String str2, Context context) {
        HandlerC2737w handlerC2737w = new HandlerC2737w();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2738x(handlerC2737w));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2739y(handlerC2737w));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.C0;
    }

    public boolean E0(String str, String str2, Context context) {
        HandlerC2734t handlerC2734t = new HandlerC2734t();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2735u(handlerC2734t));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2736v(handlerC2734t));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.D0;
    }

    public boolean F0(String str, String str2, Context context) {
        B b = new B();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new C(b));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new D(b));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.I0;
    }

    public void G0() {
        s0(0);
        j1();
    }

    public void H0() {
        Cursor cursorI4 = this.i.I4();
        this.h0 = new String[cursorI4.getCount()];
        if (cursorI4.moveToFirst()) {
            int i = 0;
            do {
                this.h0[i] = cursorI4.getString(cursorI4.getColumnIndex("_id"));
                i++;
            } while (cursorI4.moveToNext());
        }
        cursorI4.close();
    }

    public void I0() {
        Cursor cursorE8 = this.i.E8(this.z.getText().toString());
        this.i0 = new String[cursorE8.getCount()];
        if (cursorE8.moveToFirst()) {
            int i = 0;
            do {
                this.i0[i] = cursorE8.getString(cursorE8.getColumnIndex("remarks"));
                i++;
            } while (cursorE8.moveToNext());
        }
        cursorE8.close();
    }

    public void J0() {
        Log.d("item2=", this.i0.length + "");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i0);
        this.b0 = arrayAdapter;
        this.E.setAdapter(arrayAdapter);
    }

    public void K0(String str) {
        C4143vg c4143vgQ4 = this.i.q4(str);
        if (c4143vgQ4.i().equals("")) {
            return;
        }
        this.k = c4143vgQ4.i();
        this.l = c4143vgQ4.j();
        this.t = c4143vgQ4.h();
        this.q = "0";
        this.n = c4143vgQ4.f();
    }

    public double L0(List list) {
        double d = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            int i = 0;
            if (((C4064uh) list.get(size)).t() == this.j0[0]) {
                i = -1;
            } else if (((C4064uh) list.get(size)).t() == this.j0[2]) {
                i = 1;
            }
            d += Double.parseDouble(((C4064uh) list.get(size)).n().replaceAll(",", "")) * ((double) i);
        }
        return d;
    }

    public void M0(int i, int i2) {
        try {
            new Handler().postDelayed(new F(i), i2);
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.C4330y1.c
    public void a(int i) {
        if (this.N0 == null) {
            this.N0 = startActionMode(this.O0);
        }
        this.X.m(i);
        this.N0.invalidate();
        int iD = this.X.d();
        if (iD <= 0) {
            this.N0.finish();
            return;
        }
        this.N0.setTitle(iD + " Selected");
    }

    public void a0(Handler handler) {
        y1("0", this.z.getText().toString().trim(), "", this.i.T5("0"), "", "", handler);
    }

    public void a1() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") == 0) {
            this.i.Tb();
        } else if (Build.VERSION.SDK_INT < 29) {
            l1();
        } else {
            this.i.Tb();
        }
    }

    public void b0(Handler handler) {
        y1("0", this.A.getText().toString().trim(), "", this.i.T5("0"), "", "", handler);
    }

    public void btn_cus_add(View view) {
        int i;
        C2160f10.h = MO.b(this);
        FragmentStatePagerSupport_Main.a0 = true;
        if (view.getId() == info.aalmoghalis.inventory.R.id.btn_cus_det_add1) {
            i = -1;
        } else {
            i = view.getId() == info.aalmoghalis.inventory.R.id.btn_cus_det_add2 ? 1 : 0;
        }
        m0();
        if (k0()) {
            if (i != 0) {
                try {
                    String str = "0";
                    if (this.K.getTag() == null) {
                        Z00 z00 = this.i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param2,curr_id,user_id) values((select b.id from customers as b where b.name='");
                        sb.append(this.z.getText().toString());
                        sb.append("'),");
                        sb.append(this.B.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb.append(",");
                        sb.append(i);
                        sb.append(",'");
                        sb.append(this.D.getText().toString());
                        sb.append("','");
                        sb.append(this.F.getText().toString());
                        sb.append("',strftime('%Y-%m-%d','now'),'");
                        sb.append(this.i.B8());
                        sb.append("',");
                        if (this.V.getTag() != null) {
                            str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                        }
                        sb.append(str);
                        sb.append(",");
                        int i2 = C2160f10.h;
                        sb.append(i2 == -1 ? "null" : Integer.valueOf(i2));
                        sb.append(" )");
                        z00.x0(sb.toString());
                    } else {
                        Z00 z01 = this.i;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param1,param2,curr_id,user_id) values((select b.id from customers as b where b.name='");
                        sb2.append(this.z.getText().toString());
                        sb2.append("'),");
                        sb2.append(this.B.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb2.append(",");
                        sb2.append(i);
                        sb2.append(",'");
                        sb2.append(this.D.getText().toString());
                        sb2.append("','");
                        sb2.append(this.F.getText().toString());
                        sb2.append("',strftime('%Y-%m-%d','now'),'");
                        sb2.append(this.K.getTag().toString());
                        sb2.append("','");
                        sb2.append(this.i.B8());
                        sb2.append("',");
                        if (this.V.getTag() != null) {
                            str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                        }
                        sb2.append(str);
                        sb2.append(",");
                        int i3 = C2160f10.h;
                        sb2.append(i3 == -1 ? "null" : Integer.valueOf(i3));
                        sb2.append(")");
                        z01.x0(sb2.toString());
                    }
                    this.B.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    this.D.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                    this.w = calendar.get(1);
                    this.x = calendar.get(2);
                    this.y = calendar.get(5);
                    this.F.setText((CharSequence) null);
                    m1(this.K);
                    if (this.g0 == 1) {
                        this.B.requestFocus();
                    } else {
                        this.z.selectAll();
                        this.z.requestFocus();
                    }
                } catch (Exception e) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Error:");
                    sb3.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
                    Toast.makeText(this, sb3.toString(), 1).show();
                    return;
                }
            }
            G0();
            t1(true);
            if (this.Y.size() > 0) {
                u1();
            }
        }
    }

    public void btn_cus_remove(View view) {
        FragmentStatePagerSupport_Main.a0 = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        this.u = Integer.parseInt(((TextView) ((RelativeLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.tr_id)).getText().toString());
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC2724j());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC2725k());
        builder.create().show();
    }

    public void btn_cus_save(View view) {
        int i;
        FragmentStatePagerSupport_Main.a0 = true;
        if (this.M.isChecked()) {
            i = -1;
        } else {
            i = this.N.isChecked() ? 1 : 0;
        }
        m0();
        if (o0()) {
            try {
                if (this.G.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save)) && this.u != 0) {
                    String str = "0";
                    if (this.K.getTag() == null) {
                        Z00 z00 = this.i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("update transactions set out='");
                        sb.append(this.B.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb.append("',[in]='");
                        sb.append(i);
                        sb.append("',date_='");
                        sb.append(this.C.getText().toString());
                        sb.append("',remarks='");
                        sb.append(this.E.getText().toString());
                        sb.append("',param1='',curr_id=");
                        if (this.V.getTag() != null) {
                            str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                        }
                        sb.append(str);
                        sb.append(" where id='");
                        sb.append(this.u);
                        sb.append("'");
                        z00.x0(sb.toString());
                    } else {
                        Z00 z01 = this.i;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("update transactions set out='");
                        sb2.append(this.B.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb2.append("',[in]='");
                        sb2.append(i);
                        sb2.append("',date_='");
                        sb2.append(this.C.getText().toString());
                        sb2.append("',remarks='");
                        sb2.append(this.E.getText().toString());
                        sb2.append("',param1='");
                        sb2.append(this.K.getTag().toString());
                        sb2.append("',curr_id=");
                        if (this.V.getTag() != null) {
                            str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                        }
                        sb2.append(str);
                        sb2.append(" where id='");
                        sb2.append(this.u);
                        sb2.append("'");
                        z01.x0(sb2.toString());
                    }
                    this.B.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    this.C.setText(simpleDateFormat.format(calendar.getTime()));
                    this.D.setText(simpleDateFormat.format(calendar.getTime()));
                    this.w = calendar.get(1);
                    this.x = calendar.get(2);
                    this.y = calendar.get(5);
                    this.E.setText((CharSequence) null);
                    m1(this.K);
                    this.F.setText((CharSequence) null);
                    this.G.setText(getString(info.aalmoghalis.inventory.R.string.btn_add));
                    this.u = 0;
                }
                G0();
                t1(true);
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Error:");
                sb3.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
                Toast.makeText(this, sb3.toString(), 1).show();
            }
        }
    }

    @Override // defpackage.DE
    public void c(int i, C4064uh c4064uh) {
        try {
            this.u = Integer.parseInt(c4064uh.q());
            this.k0 = c4064uh.p();
            this.p0 = c4064uh.a();
            this.l0 = this.i.P7(c4064uh.c.replace(",", ""));
            this.o0 = c4064uh.b() != null ? c4064uh.b() : "";
            this.m0 = c4064uh.r();
            this.n0 = c4064uh.o() != null ? c4064uh.o() : "";
            this.q0 = c4064uh.t();
            new C3966tX().u(this);
            A1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c1(String str) {
        if (this.X != null) {
            this.M0 = 1;
            s0(-1);
        }
    }

    public void calc_pick_btn(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", this.B.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void d0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void e0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void e1(List list) {
        this.O0 = new a0(this, null);
    }

    public void f0(View view, boolean z) {
        if (z) {
            o1();
        } else {
            u0();
        }
    }

    public void f1() {
        Log.d("trace_2_onChanged=", "start3:print_pdf_action");
        if (this.i.ja("prefPrintSort", true)) {
            AbstractC3132jE.d(new Callable() { // from class: Jg
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.Y0();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Kg
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.Z0((Integer) obj);
                }
            });
        } else {
            g1();
        }
    }

    public void g0() {
        new C3966tX().f(this, this.i, this.j, this.l, -1);
    }

    public void g1() {
        if (this.V.getTag() == null) {
            if (this.i.ja("pref_print_all_curr", false)) {
                Z00 z00 = this.i;
                z00.nb(z00.ic(this.l), this.k, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.i.ic(this.l));
                this.i.sd(this.i.ic(this.l) + ".pdf");
                return;
            }
            new C3357m10(this, this.i).g(this.O, this.i.ic(this.l + "-" + this.p), L0(this.X.c()), this.p, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.i.ic(this.l));
            Z00 z01 = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append(this.i.ic(this.l + "-" + this.p));
            sb.append(".pdf");
            z01.ra(sb.toString());
            return;
        }
        if (this.i.ja("pref_print_all_curr", false)) {
            Z00 z02 = this.i;
            z02.nb(z02.ic(this.l), this.k, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.i.ic(this.l));
            this.i.sd(this.i.ic(this.l) + ".pdf");
            return;
        }
        new C3357m10(this, this.i).g(this.O, this.i.ic(this.l + "-" + this.p), L0(this.X.c()), this.p, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, this.i.ic(this.l));
        Z00 z03 = this.i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.i.ic(this.l + "-" + this.p));
        sb2.append(".pdf");
        z03.ra(sb2.toString());
    }

    public boolean h0() {
        boolean z;
        String str;
        String str2;
        C2160f10.h = MO.b(this);
        n0();
        if (!l0()) {
            return false;
        }
        try {
            if (this.K.getTag() == null) {
                Z00 z00 = this.i;
                StringBuilder sb = new StringBuilder();
                sb.append("insert into transactions (cus_id,t_cus_id,out,[in],date_,remarks,now_,param2,curr_id,user_id) values((select b.id from customers as b where b.name='");
                sb.append(this.z.getText().toString());
                sb.append("'),(select b.id from customers as b where b.name='");
                sb.append(this.A.getText().toString());
                sb.append("'),");
                sb.append(this.B.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb.append(",");
                sb.append(1);
                sb.append(",'");
                sb.append(this.C.getText().toString());
                sb.append("','");
                sb.append(this.E.getText().toString());
                sb.append("',strftime('%Y-%m-%d','now'),'");
                sb.append(this.i.B8());
                sb.append("',");
                if (this.V.getTag() == null) {
                    str2 = "0";
                } else {
                    str2 = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                }
                sb.append(str2);
                sb.append(",");
                int i = C2160f10.h;
                sb.append(i == -1 ? "null" : Integer.valueOf(i));
                sb.append(")");
                z00.x0(sb.toString());
            } else {
                Z00 z01 = this.i;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("insert into transactions (cus_id,t_cus_id,out,[in],date_,remarks,now_,param1,param2,curr_id,user_id) values((select b.id from customers as b where b.name='");
                sb2.append(this.z.getText().toString());
                sb2.append("'),(select b.id from customers as b where b.name='");
                sb2.append(this.A.getText().toString());
                sb2.append("'),");
                sb2.append(this.B.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb2.append(",");
                sb2.append(1);
                sb2.append(",'");
                sb2.append(this.C.getText().toString());
                sb2.append("','");
                sb2.append(this.E.getText().toString());
                sb2.append("',strftime('%Y-%m-%d','now'),'");
                sb2.append(this.K.getTag().toString());
                sb2.append("','");
                sb2.append(this.i.B8());
                sb2.append("',");
                if (this.V.getTag() == null) {
                    str = "0";
                } else {
                    str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                }
                sb2.append(str);
                sb2.append(",");
                int i2 = C2160f10.h;
                sb2.append(i2 == -1 ? "null" : Integer.valueOf(i2));
                sb2.append(")");
                z01.x0(sb2.toString());
            }
            K0(this.z.getText().toString());
            x1();
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.w = calendar.get(1);
            this.x = calendar.get(2);
            this.y = calendar.get(5);
            m1(this.K);
            this.E.setText((CharSequence) null);
            try {
                FragmentStatePagerSupport_Main.a0 = true;
                return true;
            } catch (Exception e) {
                e = e;
                z = true;
                e.printStackTrace();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Error:");
                sb3.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
                Toast.makeText(this, sb3.toString(), 1).show();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public void h1() {
        if (this.i.ja("f_name_lock", true)) {
            AutoCompleteTextView autoCompleteTextView = this.z;
            autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_lock), (Drawable) null);
        } else {
            AutoCompleteTextView autoCompleteTextView2 = this.z;
            autoCompleteTextView2.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView2.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_idle_lock), (Drawable) null);
        }
        if (this.i.ja("t_name_lock", false)) {
            AutoCompleteTextView autoCompleteTextView3 = this.A;
            autoCompleteTextView3.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView3.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_lock), (Drawable) null);
        } else {
            AutoCompleteTextView autoCompleteTextView4 = this.A;
            autoCompleteTextView4.setCompoundDrawablesWithIntrinsicBounds(autoCompleteTextView4.getCompoundDrawables()[0], (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.ic_lock_idle_lock), (Drawable) null);
        }
    }

    public boolean i0() {
        boolean z;
        int i = this.q0;
        int[] iArr = this.j0;
        if (i != iArr[0]) {
            int i2 = iArr[2];
        }
        n0();
        if (!l0()) {
            return false;
        }
        try {
            if (!this.G.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save)) || this.u == 0) {
                z = false;
            } else {
                String str = "0";
                if (this.K.getTag() == null) {
                    Z00 z00 = this.i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update transactions set out='");
                    sb.append(this.B.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',date_='");
                    sb.append(this.C.getText().toString());
                    sb.append("',remarks='");
                    sb.append(this.E.getText().toString());
                    sb.append("',param1='',t_cus_id=(select id from customers where name='");
                    sb.append(this.A.getText().toString());
                    sb.append("') ,cus_id=(select id from customers where name='");
                    sb.append(this.z.getText().toString());
                    sb.append("') ,curr_id=");
                    if (this.V.getTag() != null) {
                        str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                    }
                    sb.append(str);
                    sb.append(" where id='");
                    sb.append(this.u);
                    sb.append("'");
                    z00.x0(sb.toString());
                } else {
                    Z00 z01 = this.i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("update transactions set out='");
                    sb2.append(this.B.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',date_='");
                    sb2.append(this.C.getText().toString());
                    sb2.append("',remarks='");
                    sb2.append(this.E.getText().toString());
                    sb2.append("',param1='");
                    sb2.append(this.K.getTag().toString());
                    sb2.append("',t_cus_id=(select id from customers where name='");
                    sb2.append(this.A.getText().toString());
                    sb2.append("') ,cus_id=(select id from customers where name='");
                    sb2.append(this.z.getText().toString());
                    sb2.append("') ,curr_id=");
                    if (this.V.getTag() != null) {
                        str = "(select id from currency where name='" + this.V.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(" where id='");
                    sb2.append(this.u);
                    sb2.append("'");
                    z01.x0(sb2.toString());
                }
                K0(this.z.getText().toString());
                x1();
                Calendar calendar = Calendar.getInstance();
                new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                this.w = calendar.get(1);
                this.x = calendar.get(2);
                this.y = calendar.get(5);
                this.E.setText((CharSequence) null);
                m1(this.K);
                z = true;
            }
            try {
                G0();
                this.G.setOnClickListener(new E());
                FragmentStatePagerSupport_Main.a0 = true;
            } catch (Exception e) {
                e = e;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Error:");
                sb3.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
                Toast.makeText(this, sb3.toString(), 1).show();
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        return z;
    }

    public void i1() {
        this.a0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.i.K4(this.z.getText().toString(), this.A.getText().toString()));
        if (this.E.getText().toString().length() > 0) {
            this.H0 = this.i.G8(this.z.getText().toString(), this.A.getText().toString(), CSS.Value.PERCENTAGE + this.E.getText().toString() + CSS.Value.PERCENTAGE);
        } else {
            this.H0 = this.i.F8(this.z.getText().toString(), this.A.getText().toString());
        }
        this.G0 = new C3962tT(this, android.R.layout.simple_dropdown_item_1line, this.H0);
    }

    public void j1() {
        C1044Xj.a().c(new RunnableC1171Zj(2, this.i, this.z, this.A, this.E, this, this.S, this.G, new RunnableC1086Yj()));
    }

    public void k1() {
        this.z.setThreshold(1);
        this.A.setThreshold(1);
        this.E.setThreshold(1);
        this.z.setAdapter(this.a0);
        this.A.setAdapter(this.a0);
        y0(this.H0);
    }

    public final boolean l0() {
        boolean zA = AbstractC4371yX.a(this.z);
        if (!AbstractC4371yX.a(this.A)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.B)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.E)) {
            zA = false;
        }
        if (this.i.u3(this.A.getText().toString()) == 0 && this.i.u3(this.A.getText().toString().trim()) == 0) {
            this.A.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.i.u3(this.z.getText().toString()) == 0 && this.i.u3(this.z.getText().toString().trim()) == 0) {
            this.z.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (!this.i.Q()) {
            this.G.setError(null);
            return zA;
        }
        q0();
        this.G.setError(getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    public final void n0() {
        if (this.i.u3(this.A.getText().toString()) == 0 && this.i.u3(this.A.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.A;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.A.getText().toString().length() >= 1 && this.G.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                F0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.A.getText().toString(), this);
            }
        }
        if (!this.A.getText().toString().equals(this.A.getText().toString().trim()) && this.i.u3(this.A.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView2 = this.A;
            autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
        }
        if (this.i.u3(this.z.getText().toString()) == 0 && this.i.u3(this.z.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView3 = this.z;
            autoCompleteTextView3.setText(autoCompleteTextView3.getText().toString().trim());
            if (this.z.getText().toString().length() >= 1 && this.G.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                D0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.z.getText().toString(), this);
            }
        }
        if (!this.z.getText().toString().equals(this.z.getText().toString().trim()) && this.i.u3(this.z.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView4 = this.z;
            autoCompleteTextView4.setText(autoCompleteTextView4.getText().toString().trim());
        }
        this.i.D = false;
        if (this.V.getTag() == null || this.V.getTag().toString().equals(this.i.l3("0")) || this.i.Z2(this.V.getTag().toString(), this.i.cc(this.C.getText().toString())) != 0) {
            return;
        }
        this.i.u(this, this.V.getTag().toString(), this.i.cc(this.C.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (i2 != 0) {
                if (i == 2) {
                    if (intent != null) {
                        this.B.setText(this.i.P7(intent.getStringExtra("calc_result")));
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
                    d1(intent.getData(), false);
                } else if (i == this.u0) {
                    b1(intent);
                }
            }
            C0974Ur c0974Ur = this.i.x;
            if (c0974Ur != null && c0974Ur != null && !c0974Ur.l(i, i2, intent)) {
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
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra = "";
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_customer_det_move3_rv);
        setTitle(getString(info.aalmoghalis.inventory.R.string.action_move_tr));
        this.O = (RecyclerView) findViewById(info.aalmoghalis.inventory.R.id.list_cus_det_edit);
        this.P = (TextView) findViewById(info.aalmoghalis.inventory.R.id.emptyResults);
        this.O.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.i = new Z00(this.h, this);
        this.j = new E00(this);
        C0990Vh c0990Vh = (C0990Vh) ViewModelProviders.of(this).get(C0990Vh.class);
        this.K0 = c0990Vh;
        c0990Vh.b.observe(this, new C2719e());
        this.K0.c.observe(this, new C2730p());
        Z00.Z = this.i.ja("prefOthers_currency", true);
        this.z = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.from_cus_name);
        this.A = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.to_cus_name);
        EditText editText = (EditText) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        this.B = editText;
        editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
        EditText editText2 = this.B;
        editText2.addTextChangedListener(new C2018dE(editText2));
        this.C = (TextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
        this.G = (Button) findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
        ImageView imageView = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
        this.J = imageView;
        imageView.setOnClickListener(new ViewOnClickListenerC2740z());
        this.d0 = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img);
        this.E = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
        this.K = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        this.Q = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
        this.R = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
        this.S = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
        this.T = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface5);
        this.U = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
        this.V = (RadioGroup) findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        Calendar calendar = Calendar.getInstance();
        this.C.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
        this.w = calendar.get(1);
        this.x = calendar.get(2);
        this.y = calendar.get(5);
        this.C.setOnClickListener(new H());
        H0();
        this.a0 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.h0);
        this.z.setThreshold(1);
        this.z.setAdapter(this.a0);
        t1(true);
        new d0(3).execute(new Void[0]);
        try {
            if (getIntent().getStringExtra("read_imei") != null && getIntent().getStringExtra("read_imei").equals("1")) {
                this.i.Tb();
            }
        } catch (Exception unused) {
        }
        try {
            if (getIntent().getStringExtra("CUS_NAME") != null) {
                this.z.setText(getIntent().getStringExtra("CUS_NAME"));
                this.l = getIntent().getStringExtra("CUS_NAME");
                this.t = getIntent().getStringExtra("CUS_GSM");
                this.k = getIntent().getStringExtra("CUS_ID");
                this.n = getIntent().getStringExtra("G_NAME");
                this.p = getIntent().getStringExtra("CURR_NAME") == null ? "" : getIntent().getStringExtra("CURR_NAME");
                this.g0 = 1;
                this.B.requestFocus();
                new d0(3).execute(new Void[0]);
                t1(true);
            } else {
                this.z.requestFocus();
            }
        } catch (Exception unused2) {
        }
        try {
            if (getIntent().getStringExtra("TR_ID") != null) {
                new d0(3).execute(new Void[0]);
                t1(false);
                this.u = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
                this.B.setText(getIntent().getStringExtra("TR_AMOUNT").toString().replaceAll(",", ""));
                this.C.setText(getIntent().getStringExtra("TR_DATE").toString());
                if (this.i.O8(this.u).equals("0")) {
                    this.L.setVisibility(0);
                    this.i.nd(this.E, getIntent().getStringExtra("TR_REMARKS").toString());
                } else {
                    this.m0 = this.i.R8(this.u);
                    this.L.setVisibility(4);
                    this.i.nd(this.E, this.m0);
                }
                int intExtra = getIntent().getIntExtra("TR_TYPE", -10);
                this.G.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
                int[] iArr = this.j0;
                if (intExtra == iArr[0]) {
                    this.M.setChecked(true);
                } else if (intExtra == iArr[2]) {
                    this.N.setChecked(true);
                }
                this.B.requestFocus();
                this.B.selectAll();
                s1();
                M0(4, 500);
            }
        } catch (Exception unused3) {
        }
        try {
            if (getIntent().getStringExtra("G_NAME") != null) {
                this.n = getIntent().getStringExtra("G_NAME");
                if (getIntent().getStringExtra("CURR_NAME") != null) {
                    stringExtra = getIntent().getStringExtra("CURR_NAME");
                }
                this.p = stringExtra;
                this.J0 = getIntent().getBooleanExtra("screen_main", false);
            }
        } catch (Exception unused4) {
        }
        try {
            x0();
            s0(0);
            this.i.L0();
        } catch (Exception e) {
            Log.d("oncreate_error=", e.getStackTrace().toString());
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(O0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.R0, this.w, this.x, this.y);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(O0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.S0, this.w, this.x, this.y);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.menu_main_move_3, menu);
        this.P0 = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        this.P0.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.P0.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.P0.setOnQueryTextListener(new T());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.z.setText(adapterView.getItemAtPosition(i).toString());
        s0(0);
        new d0(3).execute(new Void[0]);
        t1(true);
        this.B.requestFocus();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == info.aalmoghalis.inventory.R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                d0();
            }
            try {
                SearchView searchView = this.P0;
                if (searchView == null || searchView.getQuery() == null || this.P0.getQuery().length() != 0) {
                    f1();
                } else {
                    s0(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        if (itemId == info.aalmoghalis.inventory.R.id.home) {
            onBackPressed();
            return true;
        }
        if (itemId != info.aalmoghalis.inventory.R.id.swap) {
            return super.onOptionsItemSelected(menuItem);
        }
        try {
            String string = this.z.getText().toString();
            boolean zJa = this.i.ja("f_name_lock", true);
            this.z.setText(this.A.getText());
            this.A.setText(string);
            K0(this.z.getText().toString());
            Z00 z00 = this.i;
            z00.Mc("f_name_lock", z00.ja("t_name_lock", false));
            this.i.Mc("t_name_lock", zJa);
            h1();
            x1();
            j1();
            G0();
        } catch (Exception unused) {
        }
        return true;
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.V.setTag(radioButton.getText().toString());
            this.p = radioButton.getText().toString();
            G0();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            if (iArr.length == 1 && iArr[0] == 0) {
                this.i.Tb();
                return;
            }
            return;
        }
        if (i == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            c0(getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_storage));
            return;
        }
        if (i == 113) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            c0(getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_contacts));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (Bill_edit.P2) {
                String str = this.l;
                if (str != null && str.equals(Bill_edit.R2)) {
                    s0(0);
                    Bill_edit.P2 = false;
                    Bill_edit.R2 = "";
                }
            } else if (this.X != null && this.j.i > 0) {
                new C3966tX().y(this, this.i, this.j, this.l);
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

    public void p0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new Z(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(info.aalmoghalis.inventory.R.string.pref_group_curr));
        dialog.show();
    }

    public void p1(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            if (this.F0) {
                this.K.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.K.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.K.setImageBitmap(bitmapP0);
                this.K.setTag(str);
            } else {
                this.K.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.K.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.K.setImageBitmap(bitmapP0);
                this.K.setTag(str);
            }
        } catch (Exception unused) {
        }
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void q0() {
        try {
            if (this.i.ja("black_list", false)) {
                this.i.Lc("black_date", "");
                this.i.Tb();
            }
            e0();
            this.i.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void q1() {
        StringBuilder sb = new StringBuilder();
        for (int size = this.Z.size() - 1; size >= 0; size--) {
            if (this.Z.valueAt(size)) {
                C4064uh c4064uh = (C4064uh) this.X.c().get(this.Z.keyAt(size));
                sb.append(getString(c4064uh.t() == this.j0[0] ? info.aalmoghalis.inventory.R.string.credit : info.aalmoghalis.inventory.R.string.debit));
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
        this.i.td(sb.toString());
    }

    public void r1() {
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
        listView.setOnItemClickListener(new C2726l(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        listView.setDividerHeight(0);
        linearLayout.addView(listView, -1, -1);
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void t0() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("-9", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.Z.size() - 1; size >= 0; size--) {
            if (this.Z.valueAt(size)) {
                C4064uh c4064uh = (C4064uh) this.X.c().get(this.Z.keyAt(size));
                String strA = c4064uh.a() != null ? c4064uh.a() : "";
                this.p0 = strA;
                int i = strA.equals("") ? 0 : Integer.parseInt(this.p0);
                if (i > 0) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_edit), 1).show();
                    this.u = 0;
                    return;
                }
                if (i == -2 || i == -3 || i == -4 || i == -6) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_edit_doc), 1).show();
                    this.u = 0;
                    return;
                }
                this.X.i(c4064uh);
                this.i.v0("delete from transactions where id=" + c4064uh.q());
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        G0();
        t1(true);
    }

    public void t1(boolean z) {
        Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.z.setThreshold(1);
        this.A.setThreshold(1);
        this.E.setThreshold(1);
        j1();
        if (z) {
            h1();
        }
        this.K.setOnClickListener(new G(z));
        this.z.setOnItemClickListener(new I());
        this.A.setOnItemClickListener(new J());
        this.z.setOnTouchListener(new K());
        this.z.addTextChangedListener(new L());
        this.A.setOnTouchListener(new M());
        this.A.addTextChangedListener(new N());
        this.E.addTextChangedListener(new O());
        this.U.setVisibility(0);
        x0();
        this.G.setOnClickListener(new P());
        if (z) {
            return;
        }
        this.G.setOnClickListener(new Q());
        this.z.setText(this.s0);
        this.A.setText(this.r0);
        this.i.nd(this.E, this.m0);
        this.C.setText(this.k0);
        this.B.setText(this.l0);
        if (!this.n0.equals("")) {
            this.K.setImageBitmap(Z00.p0(Z00.M + this.n0, 100, 100));
            this.K.setTag(this.n0);
            this.K.getLayoutParams().width = 100;
            this.K.getLayoutParams().height = 70;
        }
        this.B.requestFocus();
        this.B.selectAll();
        s1();
        M0(4, 500);
    }

    public void u1() {
        C4064uh c4064uhP0 = this.i.P0(this.l);
        if (C1839c10.k(this.i, this.k) || C1839c10.k(this.i, c4064uhP0.m())) {
            try {
                g0();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.i.ja("prefAutoNotify", true)) {
            Snackbar snackbarMake = Snackbar.make(this.O, "", -2);
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
            TextView textView = (TextView) snackbarLayout.findViewById(info.aalmoghalis.inventory.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(this, info.aalmoghalis.inventory.R.color.white));
            C4064uh c4064uhZ0 = z0();
            if (c4064uhZ0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(c4064uhZ0.t() == this.j0[0] ? getString(info.aalmoghalis.inventory.R.string.radio1) : getString(info.aalmoghalis.inventory.R.string.radio2));
            sb.append(" ");
            sb.append(c4064uhZ0.n());
            sb.append(" ");
            sb.append(c4064uhZ0.r());
            snackbarMake.setText(sb.toString());
            snackbarMake.setAction(getString(info.aalmoghalis.inventory.R.string.hide_tr), new ViewOnClickListenerC2727m(snackbarMake));
            textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_share), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setOnClickListener(new ViewOnClickListenerC2728n());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();
            layoutParams.gravity = 16;
            snackbarLayout.setLayoutParams(layoutParams);
            ViewCompat.setLayoutDirection(snackbarMake.getView(), 1);
            snackbarMake.show();
            new Handler().postDelayed(new RunnableC2729o(snackbarMake), 5000);
        }
    }

    public void v0() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("-9", "edit")) {
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        int size = this.Z.size() - 1;
        if (this.Z.valueAt(size)) {
            C4064uh c4064uh = (C4064uh) this.X.c().get(this.Z.keyAt(size));
            try {
                String strA = c4064uh.a() != null ? c4064uh.a() : "";
                this.p0 = strA;
                int i = strA.equals("") ? 0 : Integer.parseInt(this.p0);
                if (i > 0) {
                    this.i.n9(this.p0, this, 1);
                    return;
                }
                if (i == -2) {
                    String strI = new C2160f10(this.i).I(this.u + "");
                    Z00 z00 = this.i;
                    z00.r9(z00.Q8(this.u), this.i.P8(this.u), strI, this);
                    return;
                }
                if (i == -3) {
                    String strI2 = new C2160f10(this.i).I(this.u + "");
                    Z00 z01 = this.i;
                    z01.s9(z01.Q8(this.u), this.i.H8(this.u), this.i.P8(this.u), strI2, this);
                    return;
                }
                if (i == -6) {
                    String strI3 = new C2160f10(this.i).I(this.u + "");
                    Z00 z02 = this.i;
                    z02.p9(z02.Q8(this.u), this.i.H8(this.u), this.i.P8(this.u), strI3, this);
                    return;
                }
                if (i == -4) {
                    this.i.t9(this.u + "", this);
                    return;
                }
                this.u = Integer.parseInt(c4064uh.q().toString());
                this.B.setText(c4064uh.n().toString().replaceAll(",", ""));
                this.C.setText(c4064uh.p());
                this.l0 = c4064uh.n().toString().replaceAll(",", "");
                this.K.setTag(c4064uh.o() != null ? c4064uh.o() : "");
                this.n0 = this.K.getTag().toString();
                c4064uh.t();
                this.o0 = c4064uh.b();
                this.G.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
                this.r0 = "";
                this.m0 = c4064uh.h();
                if (!this.i.O8(this.u).equals("0")) {
                    this.m0 = this.i.R8(this.u);
                    this.s0 = this.l;
                    String strT8 = this.i.T8(this.u);
                    this.r0 = strT8;
                    if (strT8.equals(this.l)) {
                        this.s0 = this.i.N8(this.u);
                    }
                }
                this.z.setText(this.s0);
                this.A.setText(this.r0);
                if (this.K.getTag().toString().equals("")) {
                    m1(this.K);
                } else {
                    p1(this.K.getTag().toString());
                }
                t1(false);
                x0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void w0() {
        int i = this.p0.equals("") ? 0 : Integer.parseInt(this.p0);
        if (i > 0) {
            this.i.n9(this.p0, this, 1);
            return;
        }
        if (i == -2) {
            String strI = new C2160f10(this.i).I(this.u + "");
            Z00 z00 = this.i;
            z00.r9(z00.Q8(this.u), this.i.P8(this.u), strI, this);
            return;
        }
        if (i == -3) {
            String strI2 = new C2160f10(this.i).I(this.u + "");
            Z00 z01 = this.i;
            z01.s9(z01.Q8(this.u), this.i.H8(this.u), this.i.P8(this.u), strI2, this);
            return;
        }
        if (i == -6) {
            String strI3 = new C2160f10(this.i).I(this.u + "");
            Z00 z02 = this.i;
            z02.p9(z02.Q8(this.u), this.i.H8(this.u), this.i.P8(this.u), strI3, this);
            return;
        }
        if (i != -4) {
            if (this.i.O8(this.u).equals("0")) {
                return;
            }
            t1(false);
            x0();
            return;
        }
        this.i.t9(this.u + "", this);
    }

    public void w1() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.i.J2(this, intent);
            this.B0 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.B0.getPath() + "");
            startActivityForResult(intent, this.u0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void x0() {
        String str;
        try {
            if (Z00.Z) {
                ArrayList arrayListJ3 = this.i.j3();
                this.W = arrayListJ3;
                String str2 = this.p;
                if (str2 == null) {
                    str2 = "";
                }
                this.p = str2;
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
                    radioButtonArr[i].setOnClickListener(new R());
                    this.V.addView(radioButtonArr[i]);
                    String str3 = this.o0;
                    if (str3 != null && str3.equals(((HashMap) this.W.get(i)).get("name"))) {
                        Log.d("tr_curr_name_l=", this.o0 + ":" + ((String) ((HashMap) this.W.get(i)).get("name")) + ":" + this.l);
                        this.V.check(radioButtonArr[i].getId());
                        this.V.setTag(((HashMap) this.W.get(i)).get("name"));
                        this.p = (String) ((HashMap) this.W.get(i)).get("name");
                    }
                }
                if (!this.p.equals("") && (str = this.p) != null) {
                    this.V.setTag(str);
                    for (int i2 = 0; i2 < size; i2++) {
                        if (radioButtonArr[i2].getText().toString().equals(this.p)) {
                            this.V.check(radioButtonArr[i2].getId());
                        }
                    }
                    return;
                }
                String str4 = this.o0;
                if (str4 == null || str4.equals("")) {
                    this.V.check(radioButtonArr[this.W.size() - 1].getId());
                    this.V.setTag(radioButtonArr[this.W.size() - 1].getText().toString());
                    this.p = radioButtonArr[this.W.size() - 1].getText().toString();
                }
            }
        } catch (Exception e) {
            Log.d("fill_curr_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void x1() {
        if (!this.i.ja("f_name_lock", true)) {
            this.z.setText("");
            if (!this.z.hasFocus()) {
                this.z.requestFocus();
            }
        }
        if (!this.i.ja("t_name_lock", false)) {
            this.A.setText("");
            if (!this.A.hasFocus() && this.i.ja("f_name_lock", true)) {
                this.A.requestFocus();
            }
        }
        if (this.i.ja("f_name_lock", true) && this.i.ja("t_name_lock", true)) {
            this.B.setText("");
            if (!this.B.hasFocus()) {
                this.B.selectAll();
                this.B.requestFocus();
            }
        }
        if (this.i.ja("t_name_lock", false) && this.A.getText() != null && this.A.getText().toString().length() > 0) {
            this.z.setImeOptions(5);
            this.z.setNextFocusDownId(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.z.setNextFocusForwardId(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        }
        this.B.setText("");
    }

    public void y0(ArrayList arrayList) {
        LayoutInflater layoutInflater = getLayoutInflater();
        int size = arrayList.size();
        if (this.S.getChildCount() > 0) {
            this.S.removeAllViews();
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
                button.setOnClickListener(new A((String) arrayList.get(i2)));
                this.S.addView(relativeLayout);
            }
        }
    }

    public void y1(String str, String str2, String str3, String str4, String str5, String str6, Handler handler) {
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
            autoCompleteTextView.setOnItemClickListener(new C2715a(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C2716b(autoCompleteTextView2, editText2));
            this.t0 = editText2;
            this.i.Zc(this, autoCompleteTextView2);
            this.i.Zc(this, autoCompleteTextView);
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC2717c());
            imageView2.setOnClickListener(new ViewOnClickListenerC2718d(arrayAdapter, autoCompleteTextView));
            imageView3.setOnClickListener(new ViewOnClickListenerC2720f(arrayAdapter2, autoCompleteTextView2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2721g());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2722h());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2723i(editText, autoCompleteTextView, autoCompleteTextView2, str, alertDialogCreate, editText2, editText3, handler));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override // defpackage.DE
    public void e(int i, C4145vh c4145vh) {
    }
}
