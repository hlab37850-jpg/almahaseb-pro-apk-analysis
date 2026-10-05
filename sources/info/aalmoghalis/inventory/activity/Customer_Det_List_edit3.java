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
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC4371yX;
import defpackage.C0795Oh;
import defpackage.C0835Pv;
import defpackage.C0856Qh;
import defpackage.C0974Ur;
import defpackage.C1044Xj;
import defpackage.C2018dE;
import defpackage.C2160f10;
import defpackage.C3580oi;
import defpackage.C3966tX;
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.E00;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Customer_Det_List_edit3 extends BaseActivity implements AdapterView.OnItemClickListener, LoaderManager.LoaderCallbacks<List<C0795Oh>> {
    public C0835Pv S;
    public SparseBooleanArray U;
    public ArrayAdapter V;
    public ArrayAdapter W;
    public SQLiteDatabase c;
    public Z00 d;
    public E00 e;
    public String f;
    public int n;
    public ArrayAdapter n0;
    public EditText p0;
    public int q;
    public int t;
    public int u;
    public String u0;
    public Uri x0;
    public boolean y0;
    public boolean z0;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public double p = 0.0d;
    public AutoCompleteTextView v = null;
    public EditText w = null;
    public TextView x = null;
    public TextView y = null;
    public AutoCompleteTextView z = null;
    public AutoCompleteTextView A = null;
    public Button B = null;
    public Button C = null;
    public Button D = null;
    public ImageView E = null;
    public ImageView F = null;
    public ImageView G = null;
    public RadioGroup H = null;
    public RadioButton I = null;
    public RadioButton J = null;
    public ListView K = null;
    public LinearLayout L = null;
    public LinearLayout M = null;
    public LinearLayout N = null;
    public LinearLayout O = null;
    public LinearLayout P = null;
    public RadioGroup Q = null;
    public ArrayList R = new ArrayList();
    public List T = new ArrayList();
    public ImageButton X = null;
    public ImageView Y = null;
    public String Z = "";
    public String a0 = "";
    public int b0 = 0;
    public String[] c0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] d0 = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] e0 = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public String f0 = null;
    public String g0 = null;
    public String h0 = null;
    public String i0 = null;
    public String j0 = null;
    public String k0 = null;
    public int l0 = 0;
    public TextView m0 = null;
    public LinearLayout o0 = null;
    public int q0 = 3;
    public int r0 = 4;
    public int s0 = 0;
    public int t0 = 1;
    public ActivityResultLauncher v0 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Wg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.x0((Uri) obj);
        }
    });
    public ActivityResultLauncher w0 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new x());
    public String A0 = "";
    public boolean B0 = false;
    public DatePickerDialog.OnDateSetListener C0 = new K();
    public DatePickerDialog.OnDateSetListener D0 = new L();
    public final Context E0 = this;
    public int F0 = 0;
    public String G0 = "";

    public class A implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public A(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit3.this.z0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
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
            Customer_Det_List_edit3.this.O(this.a);
        }
    }

    public class D implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public D(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit3.this.y0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class E implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public E(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3.this.R(view, this.a);
        }
    }

    public class F implements View.OnClickListener {
        public F() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3.this.showDialog(4);
        }
    }

    public class G implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public G(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3.this.R(view, this.a);
        }
    }

    public class H implements View.OnClickListener {
        public H() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3.this.showDialog(0);
        }
    }

    public class I implements DialogInterface.OnClickListener {
        public final /* synthetic */ ImageView a;

        public I(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit3.this.d.qa(Z00.M + this.a.getTag().toString());
            } catch (Exception unused) {
            }
        }
    }

    public class J implements View.OnClickListener {
        public J() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3.this.onRadioButtonClicked(view);
        }
    }

    public class K implements DatePickerDialog.OnDateSetListener {
        public K() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit3.this.q = i;
            Customer_Det_List_edit3.this.t = i2;
            Customer_Det_List_edit3.this.u = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit3.this.u)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit3.this.t + 1)) + "-" + Customer_Det_List_edit3.this.q;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit3.this.x.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class L implements DatePickerDialog.OnDateSetListener {
        public L() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Customer_Det_List_edit3.this.q = i;
            Customer_Det_List_edit3.this.t = i2;
            Customer_Det_List_edit3.this.u = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit3.this.u)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Customer_Det_List_edit3.this.t + 1)) + "-" + Customer_Det_List_edit3.this.q;
                Locale locale = Locale.ENGLISH;
                Customer_Det_List_edit3.this.y.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class M implements DialogInterface.OnClickListener {
        public M() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class N implements Runnable {
        public final /* synthetic */ int a;

        public N(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i == 0) {
                Customer_Det_List_edit3.this.S.notifyDataSetChanged();
                return;
            }
            if (i == 1) {
                return;
            }
            if (i == 2) {
                Customer_Det_List_edit3.this.y0();
            } else if (i == 4) {
                Customer_Det_List_edit3.this.w.selectAll();
            }
        }
    }

    public class O implements DialogInterface.OnClickListener {
        public O() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Customer_Det_List_edit3.this.e0();
            } catch (Exception unused) {
                Toast.makeText(Customer_Det_List_edit3.this.getBaseContext(), "SQL Error.", 1);
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

    public class Q implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ArrayAdapter b;
        public final /* synthetic */ Dialog c;

        public Q(TextView textView, ArrayAdapter arrayAdapter, Dialog dialog) {
            this.a = textView;
            this.b = arrayAdapter;
            this.c = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getId() == Customer_Det_List_edit3.this.m0.getId()) {
                if (i == this.b.getCount() - 1) {
                    Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit3.L0("0", "", "", customer_Det_List_edit3.d.T5("0"), "", Customer_Det_List_edit3.this.d.v1("211"));
                } else {
                    this.a.setText(adapterView.getItemAtPosition(i).toString());
                }
            }
            this.c.dismiss();
        }
    }

    public class R implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ EditText c;

        public R(AutoCompleteTextView autoCompleteTextView, Dialog dialog, EditText editText) {
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
                    Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit3.d.Md(customer_Det_List_edit3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$a, reason: case insensitive filesystem */
    public class C2741a implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2741a(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$b, reason: case insensitive filesystem */
    public class C2742b implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2742b(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2743c implements View.OnClickListener {
        public ViewOnClickListenerC2743c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2744d implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2744d(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
            customer_Det_List_edit3.d.Md(customer_Det_List_edit3);
            Customer_Det_List_edit3.this.W(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2745e implements View.OnClickListener {
        public ViewOnClickListenerC2745e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
            Customer_Det_List_edit3 customer_Det_List_edit4 = Customer_Det_List_edit3.this;
            customer_Det_List_edit3.n0 = new ArrayAdapter(customer_Det_List_edit4, android.R.layout.simple_spinner_dropdown_item, customer_Det_List_edit4.d.i4());
            Customer_Det_List_edit3 customer_Det_List_edit5 = Customer_Det_List_edit3.this;
            customer_Det_List_edit5.X(customer_Det_List_edit5.n0, Customer_Det_List_edit3.this.m0);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$f, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2746f implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2746f(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
            customer_Det_List_edit3.d.Md(customer_Det_List_edit3);
            Customer_Det_List_edit3.this.W(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$g, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2747g implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2747g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$h, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2748h implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2748h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$i, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2749i implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ Handler h;

        public ViewOnClickListenerC2749i(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, AlertDialog alertDialog, EditText editText2, EditText editText3, Handler handler) {
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
            if (Customer_Det_List_edit3.this.d.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit3.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit3.this.d.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit3.this.A0 = this.b.getText().toString();
                Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
                customer_Det_List_edit3.l0(customer_Det_List_edit3.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit3.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit3.this.A0, Customer_Det_List_edit3.this);
                if (!Customer_Det_List_edit3.this.y0) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit3.this.d.r1(this.c.getText().toString());
                if (this.d.equals("0")) {
                    if (Customer_Det_List_edit3.this.d.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit3.this);
                        this.e.dismiss();
                        return;
                    }
                    Customer_Det_List_edit3.this.d.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.f.getText().toString() + "','" + this.g.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                    Handler handler = this.h;
                    handler.sendMessage(handler.obtainMessage());
                } else if (this.d != null) {
                    Customer_Det_List_edit3.this.d.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.f.getText().toString() + "',address='" + this.g.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit3.this.f + "' and id>0 ");
                    Handler handler2 = this.h;
                    handler2.sendMessage(handler2.obtainMessage());
                }
                this.e.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$j, reason: case insensitive filesystem */
    public class C2750j implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2750j(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$k, reason: case insensitive filesystem */
    public class C2751k implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2751k(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$l, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2752l implements View.OnClickListener {
        public ViewOnClickListenerC2752l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3.this.phone_pick_btn(view);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$m, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2753m implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2753m(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
            customer_Det_List_edit3.d.Md(customer_Det_List_edit3);
            Customer_Det_List_edit3.this.W(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$n, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2754n implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC2754n(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
            customer_Det_List_edit3.d.Md(customer_Det_List_edit3);
            Customer_Det_List_edit3.this.W(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$o, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2755o implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2755o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$p, reason: case insensitive filesystem */
    public class C2756p implements AdapterView.OnItemClickListener {
        public C2756p() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                TextView textView = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.tr_id);
                Customer_Det_List_edit3.this.n = Integer.parseInt(textView.getText().toString());
                Customer_Det_List_edit3.this.h0 = textView.getTag() != null ? textView.getTag().toString() : "";
                TextView textView2 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.tr_date);
                Customer_Det_List_edit3.this.f0 = textView2.getText().toString();
                Customer_Det_List_edit3.this.k0 = textView2.getTag() != null ? textView2.getTag().toString() : "";
                TextView textView3 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.tr_amount);
                Customer_Det_List_edit3.this.g0 = textView3.getText().toString();
                Customer_Det_List_edit3.this.j0 = textView3.getTag() != null ? textView3.getTag().toString() : "";
                TextView textView4 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.tr_remarks);
                Customer_Det_List_edit3.this.i0 = textView4.getTag() != null ? textView4.getTag().toString() : "";
                Customer_Det_List_edit3.this.l0 = Integer.parseInt(((ImageView) view.findViewById(info.aalmoghalis.inventory.R.id.img)).getTag().toString());
                C0795Oh c0795Oh = (C0795Oh) adapterView.getItemAtPosition(i);
                if (c0795Oh.p().equals(c0795Oh.f())) {
                    Customer_Det_List_edit3.this.v.setText(c0795Oh.h());
                } else {
                    Customer_Det_List_edit3.this.v.setText(c0795Oh.p());
                }
                Customer_Det_List_edit3.this.m0.setText(c0795Oh.f());
                Customer_Det_List_edit3.this.N0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$q, reason: case insensitive filesystem */
    public class C2757q implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$q$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Customer_Det_List_edit3.this.b0();
                } catch (Exception unused) {
                    Toast.makeText(Customer_Det_List_edit3.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$q$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2757q() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case info.aalmoghalis.inventory.R.id.menu_delete /* 2131297039 */:
                    SparseBooleanArray sparseBooleanArrayB = Customer_Det_List_edit3.this.S.b();
                    Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit3.U = sparseBooleanArrayB;
                    AlertDialog.Builder builder = new AlertDialog.Builder(customer_Det_List_edit3);
                    builder.setMessage(Customer_Det_List_edit3.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
                    builder.setPositiveButton(Customer_Det_List_edit3.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
                    builder.setNegativeButton(Customer_Det_List_edit3.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB2 = Customer_Det_List_edit3.this.S.b();
                    Customer_Det_List_edit3 customer_Det_List_edit4 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit4.U = sparseBooleanArrayB2;
                    customer_Det_List_edit4.d0();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_share /* 2131297045 */:
                    SparseBooleanArray sparseBooleanArrayB3 = Customer_Det_List_edit3.this.S.b();
                    Customer_Det_List_edit3 customer_Det_List_edit5 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit5.U = sparseBooleanArrayB3;
                    customer_Det_List_edit5.H0();
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
            Customer_Det_List_edit3.this.K.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Customer_Det_List_edit3.this.S.i.clear();
            Customer_Det_List_edit3.this.S.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Customer_Det_List_edit3.this.K.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Customer_Det_List_edit3.this.S.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Customer_Det_List_edit3.this.K.getCheckedItemCount() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Customer_Det_List_edit3$r, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2758r implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2758r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class s implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ AlertDialog g;

        public s(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, EditText editText2, EditText editText3, AlertDialog alertDialog) {
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
            if (Customer_Det_List_edit3.this.d.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(Customer_Det_List_edit3.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (Customer_Det_List_edit3.this.d.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                Customer_Det_List_edit3.this.A0 = this.b.getText().toString();
                Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
                customer_Det_List_edit3.l0(customer_Det_List_edit3.getString(info.aalmoghalis.inventory.R.string.validation_add_group), Customer_Det_List_edit3.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + Customer_Det_List_edit3.this.A0, Customer_Det_List_edit3.this);
                if (!Customer_Det_List_edit3.this.y0) {
                    return;
                }
            }
            if (z) {
                int iR1 = Customer_Det_List_edit3.this.d.r1(this.c.getText().toString());
                if (!this.d.equals("0")) {
                    if (this.d != null) {
                        Customer_Det_List_edit3.this.d.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.e.getText().toString() + "',address='" + this.f.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + Customer_Det_List_edit3.this.f + "' and id>0 ");
                        this.g.dismiss();
                        return;
                    }
                    return;
                }
                if (Customer_Det_List_edit3.this.d.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                    FragmentStatePagerSupport_Main.Z(Customer_Det_List_edit3.this);
                    this.a.setError(Customer_Det_List_edit3.this.getString(info.aalmoghalis.inventory.R.string.exist));
                    return;
                }
                Customer_Det_List_edit3.this.d.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.e.getText().toString() + "','" + this.f.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                if (iR1 == 211) {
                    Customer_Det_List_edit3.this.m0.setText(this.a.getText().toString());
                }
                this.g.dismiss();
            }
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (Customer_Det_List_edit3.this.n != 0) {
                    Customer_Det_List_edit3.this.d.v0("delete from transactions  where id='" + Customer_Det_List_edit3.this.n + "'");
                    Customer_Det_List_edit3.this.w.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    Customer_Det_List_edit3.this.y.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                    Customer_Det_List_edit3.this.q = calendar.get(1);
                    Customer_Det_List_edit3.this.t = calendar.get(2);
                    Customer_Det_List_edit3.this.u = calendar.get(5);
                    Customer_Det_List_edit3.this.A.setText((CharSequence) null);
                    Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit3.B.setText(customer_Det_List_edit3.getString(info.aalmoghalis.inventory.R.string.btn_add));
                    Customer_Det_List_edit3.this.n = 0;
                    Customer_Det_List_edit3.this.m0();
                }
            } catch (Exception unused) {
            }
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public v(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit3.this);
                if (this.a[i].equals(Customer_Det_List_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit3.u0 = customer_Det_List_edit3.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit3.this.S();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit3 customer_Det_List_edit4 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit4.u0 = customer_Det_List_edit4.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit3.this.h0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit3.this.d.qa(Z00.M + Customer_Det_List_edit3.this.G.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit3.this.G.setTag(null);
                    Customer_Det_List_edit3.this.G.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public w(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Customer_Det_List_edit3.this);
                if (this.a[i].equals(Customer_Det_List_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Customer_Det_List_edit3 customer_Det_List_edit3 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit3.u0 = customer_Det_List_edit3.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Customer_Det_List_edit3.this.S();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Customer_Det_List_edit3 customer_Det_List_edit4 = Customer_Det_List_edit3.this;
                    customer_Det_List_edit4.u0 = customer_Det_List_edit4.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Customer_Det_List_edit3.this.h0();
                    }
                } else if (this.a[i].equals(Customer_Det_List_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Customer_Det_List_edit3.this.d.qa(Z00.M + Customer_Det_List_edit3.this.F.getTag().toString());
                } else if (this.a[i].equals(Customer_Det_List_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Customer_Det_List_edit3.this.F.setTag(null);
                    Customer_Det_List_edit3.this.F.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Customer_Det_List_edit3.this.F.getLayoutParams().width = (int) Customer_Det_List_edit3.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Customer_Det_List_edit3.this.F.getLayoutParams().height = (int) Customer_Det_List_edit3.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class x implements ActivityResultCallback {
        public x() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Customer_Det_List_edit3.this.K0();
            }
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

    public class z implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public z(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Customer_Det_List_edit3.this.d.v0("insert into groups  (name )  values( '" + Customer_Det_List_edit3.this.A0 + "'  )");
            Customer_Det_List_edit3.this.z0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    private void Z(File file, File file2) throws IOException {
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

    public static boolean u0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean v0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean w0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        this.T = list;
        C0835Pv c0835Pv = new C0835Pv(this, info.aalmoghalis.inventory.R.layout.customer_det_row_all, this.T);
        this.S = c0835Pv;
        this.K.setAdapter((ListAdapter) c0835Pv);
    }

    public final void B0(Uri uri, boolean z2) {
        try {
            String strX = new C3966tX().x(uri, z2, this.d, this);
            if (strX != null) {
                F0(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void C0() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_PHONE_STATE")) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        }
    }

    public final void D0(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
    }

    public final void E0() {
        String[] stringArray = this.G.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new v(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    public void F0(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            if (this.B0) {
                this.G.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.G.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.G.setImageBitmap(bitmapP0);
                this.G.setTag(str);
            } else {
                this.F.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
                this.F.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
                this.F.setImageBitmap(bitmapP0);
                this.F.setTag(str);
            }
        } catch (Exception unused) {
        }
    }

    public final void G0() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void H0() {
        StringBuilder sb = new StringBuilder();
        for (int size = this.U.size() - 1; size >= 0; size--) {
            if (this.U.valueAt(size)) {
                C0795Oh item = this.S.getItem(this.U.keyAt(size));
                sb.append(getString(item.r() == this.e0[0] ? info.aalmoghalis.inventory.R.string.credit : info.aalmoghalis.inventory.R.string.debit));
                sb.append(" ");
                sb.append(item.l());
                sb.append(" ");
                sb.append(item.q());
                sb.append(" ");
                sb.append(getString(info.aalmoghalis.inventory.R.string.day));
                sb.append(" ");
                sb.append(item.n().substring(0, 5));
                sb.append(StringUtilities.LF);
            }
        }
        this.d.td(sb.toString());
    }

    public void I0(boolean z2) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.B0 = z2;
        if (!z2) {
            this.N.setVisibility(8);
            this.O.setVisibility(8);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            this.x = (TextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.z.setThreshold(1);
            this.z.setAdapter(this.W);
            this.d.od(this, this.w, this.z);
            this.F.setOnClickListener(new G(z2));
            this.x.setOnClickListener(new H());
            return;
        }
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(0);
        this.O.setVisibility(0);
        this.o0.setVisibility(0);
        this.y = (TextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date4);
        this.A.setThreshold(1);
        this.A.setAdapter(this.W);
        this.d.od(this, this.w, this.A);
        this.y.setText(simpleDateFormat.format(calendar.getTime()));
        this.q = calendar.get(1);
        this.t = calendar.get(2);
        this.u = calendar.get(5);
        this.G.setOnClickListener(new E(z2));
        this.y.setOnClickListener(new F());
    }

    public final void J0() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void K0() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.d.J2(this, intent);
            this.x0 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.x0.getPath() + "");
            startActivityForResult(intent, this.q0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void L0(String str, String str2, String str3, String str4, String str5, String str6) {
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
            autoCompleteTextView.setOnItemClickListener(new C2750j(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.d.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C2751k(autoCompleteTextView2, editText));
            this.p0 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC2752l());
            imageView2.setOnClickListener(new ViewOnClickListenerC2753m(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new ViewOnClickListenerC2754n(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2755o());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2758r());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new s(editText, autoCompleteTextView, autoCompleteTextView2, str, editText2, editText3, alertDialogCreate));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void M0(String str, String str2, String str3, String str4, String str5, String str6, Handler handler) {
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
            autoCompleteTextView.setOnItemClickListener(new C2741a(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.d.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C2742b(autoCompleteTextView2, editText2));
            this.p0 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC2743c());
            imageView2.setOnClickListener(new ViewOnClickListenerC2744d(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new ViewOnClickListenerC2746f(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2747g());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2748h());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2749i(editText, autoCompleteTextView, autoCompleteTextView2, str, alertDialogCreate, editText2, editText3, handler));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void N0() {
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
            if (!this.d.O8(this.n).equals("0")) {
                this.h0 = this.d.R8(this.n);
            }
            textView4.setText(this.h0);
            textView2.setText(this.f0);
            textView.setText(this.g0);
            textView3.setText(this.d.S8(this.n));
            if (Z00.Z) {
                ((TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_curr_view)).setVisibility(0);
                ((TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_curr_name)).setText(this.j0);
            }
            imageView2.setImageResource(this.l0);
            if (this.i0.equals("")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(Z00.p0(Z00.M + this.i0, 300, 300));
                imageView.setTag(this.i0);
                imageView.getLayoutParams().width = 200;
                imageView.getLayoutParams().height = 200;
            }
            builder.setCancelable(true);
            if (imageView.getTag() != null) {
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.view_image), new I(imageView));
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new O());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new P());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.v.getText().toString());
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("adv_search_error=", ":" + e.getMessage());
        }
    }

    public void O(Handler handler) {
        String string = this.v.getText().toString();
        String strT5 = this.h;
        if (strT5 == null) {
            strT5 = this.d.T5("0");
        }
        M0("0", string, "", strT5, "", "", handler);
    }

    public final void P(String str) {
        new AlertDialog.Builder(this).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new M()).show();
    }

    public void Q() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public void R(View view, boolean z2) {
        if (z2) {
            E0();
        } else {
            c0();
        }
    }

    public final void S() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            K0();
            return;
        }
        int i = Integer.parseInt(this.d.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.d.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.w0.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    public final boolean T() {
        Log.d("IMEI=", "AFTER VALIDATION");
        boolean zA = AbstractC4371yX.a(this.w);
        if (!AbstractC4371yX.a(this.A)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.v)) {
            zA = false;
        }
        if (this.v.getText().toString().equals(this.m0.getText().toString())) {
            this.v.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.not_valid), 0).show();
            zA = false;
        }
        if (this.d.u3(this.v.getText().toString()) == 0 && this.d.u3(this.v.getText().toString().trim()) == 0) {
            this.v.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        this.d.D = false;
        if (this.Q.getTag() != null && !this.Q.getTag().toString().equals(this.d.l3("0")) && this.d.Z2(this.Q.getTag().toString(), this.d.cc(this.y.getText().toString())) == 0) {
            this.d.u(this, this.Q.getTag().toString(), this.d.cc(this.y.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
            if (!this.d.D) {
                zA = false;
            }
        }
        if (!this.d.Q()) {
            this.B.setError(null);
            return zA;
        }
        Y();
        this.B.setError(getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    public final void U() {
        if (this.d.u3(this.v.getText().toString()) == 0 && this.d.u3(this.v.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.v;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.v.getText().toString().length() >= 1 && this.B.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_add))) {
                k0(getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.v.getText().toString(), this);
            }
        }
        if (this.v.getText().toString().equals(this.v.getText().toString().trim()) || this.d.u3(this.v.getText().toString().trim()) <= 0) {
            return;
        }
        AutoCompleteTextView autoCompleteTextView2 = this.v;
        autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
    }

    public final boolean V() {
        boolean zA = AbstractC4371yX.a(this.w);
        if (!AbstractC4371yX.a(this.z)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.v)) {
            zA = false;
        }
        if (this.d.u3(this.v.getText().toString()) == 0 && this.d.u3(this.v.getText().toString().trim()) == 0) {
            this.v.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        this.d.D = false;
        if (this.Q.getTag() != null && !this.Q.getTag().toString().equals(this.d.l3("0")) && this.d.Z2(this.Q.getTag().toString(), this.d.cc(this.x.getText().toString())) == 0) {
            this.d.u(this, this.Q.getTag().toString(), this.d.cc(this.x.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
            if (!this.d.D) {
                zA = false;
            }
        }
        if (!this.d.Q()) {
            this.B.setError(null);
            return zA;
        }
        Y();
        this.B.setError(getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    public void W(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        autoCompleteTextView.setText("");
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new R(autoCompleteTextView, dialog, editText));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    public void X(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new Q(textView, arrayAdapter, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void Y() {
        try {
            if (this.d.ja("black_list", false)) {
                this.d.Lc("black_date", "");
                this.d.Lc("black_date_done", "");
                this.d.L0();
            }
            Q();
            this.d.qe(this, this);
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public final void a0() {
        getSupportLoaderManager().initLoader(Calendar.getInstance().get(14), null, this).forceLoad();
    }

    public void b0() {
        if (C2160f10.h > 0 && !new C2160f10(this.d).l("10", HTML.Tag.DEL)) {
            Context context = this.E0;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.U.size() - 1; size >= 0; size--) {
            if (this.U.valueAt(size)) {
                C0795Oh item = this.S.getItem(this.U.keyAt(size));
                String strA = item.a() != null ? item.a() : "";
                this.k0 = strA;
                int i = strA.equals("") ? 0 : Integer.parseInt(this.k0);
                if (i > 0) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_edit), 1).show();
                    this.n = 0;
                    return;
                } else if (i == -1) {
                    this.S.remove(item);
                    this.d.v0("delete from transactions where id=" + item.o());
                }
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        m0();
        I0(true);
    }

    public void btn_cus_add(View view) {
        int i;
        String str;
        String str2;
        int i2;
        String message;
        C2160f10.h = MO.b(this);
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.d).l("10", "edit")) {
                Context context = this.E0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.d).l("10", "new")) {
            Context context2 = this.E0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        FragmentStatePagerSupport_Main.a0 = true;
        if (view.getId() == info.aalmoghalis.inventory.R.id.btn_cus_det_add1) {
            i = -1;
        } else {
            i = view.getId() == info.aalmoghalis.inventory.R.id.btn_cus_det_add2 ? 1 : 0;
        }
        U();
        if (T()) {
            if (i != 0) {
                try {
                    if (this.G.getTag() == null) {
                        Z00 z00 = this.d;
                        StringBuilder sb = new StringBuilder();
                        sb.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param2,fund_id,curr_id,bill_id,user_id) values((select b.id from customers as b where b.name='");
                        sb.append(this.v.getText().toString());
                        sb.append("'),");
                        sb.append(this.w.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb.append(",");
                        sb.append(i);
                        sb.append(",'");
                        sb.append(this.y.getText().toString());
                        sb.append("','");
                        sb.append(this.A.getText().toString());
                        sb.append("',strftime('%Y-%m-%d','now'),'");
                        sb.append(this.d.B8());
                        sb.append("',(select id from customers where name='");
                        sb.append(this.m0.getText().toString());
                        sb.append("'),");
                        if (this.Q.getTag() == null) {
                            str2 = "0";
                        } else {
                            str2 = "(select id from currency where name='" + this.Q.getTag().toString() + "')";
                        }
                        sb.append(str2);
                        sb.append(",-1 ,");
                        int i3 = C2160f10.h;
                        sb.append(i3 == -1 ? "null" : Integer.valueOf(i3));
                        sb.append(")");
                        z00.x0(sb.toString());
                    } else {
                        Z00 z01 = this.d;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param1,param2,fund_id,curr_id,bill_id,user_id) values((select b.id from customers as b where b.name='");
                        sb2.append(this.v.getText().toString());
                        sb2.append("'),");
                        sb2.append(this.w.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb2.append(",");
                        sb2.append(i);
                        sb2.append(",'");
                        sb2.append(this.y.getText().toString());
                        sb2.append("','");
                        sb2.append(this.A.getText().toString());
                        sb2.append("',strftime('%Y-%m-%d','now'),'");
                        sb2.append(this.G.getTag().toString());
                        sb2.append("','");
                        sb2.append(this.d.B8());
                        sb2.append("',(select id from customers where name='");
                        sb2.append(this.m0.getText().toString());
                        sb2.append("'),");
                        if (this.Q.getTag() == null) {
                            str = "0";
                        } else {
                            str = "(select id from currency where name='" + this.Q.getTag().toString() + "')";
                        }
                        sb2.append(str);
                        sb2.append(",-1 ,");
                        int i4 = C2160f10.h;
                        sb2.append(i4 == -1 ? "null" : Integer.valueOf(i4));
                        sb2.append(")");
                        z01.x0(sb2.toString());
                    }
                    p0(this.v.getText().toString());
                    this.w.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    this.y.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                    this.q = calendar.get(1);
                    this.t = calendar.get(2);
                    this.u = calendar.get(5);
                    this.A.setText((CharSequence) null);
                    D0(this.G);
                    if (this.b0 == 1) {
                        this.w.requestFocus();
                    } else {
                        this.v.selectAll();
                        this.v.requestFocus();
                    }
                } catch (Exception e) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Error:");
                    if (e.getMessage() == null || e.getMessage().length() <= 20) {
                        i2 = 0;
                        message = e.getMessage();
                    } else {
                        i2 = 0;
                        message = e.getMessage().substring(0, 20);
                    }
                    sb3.append(message);
                    Toast.makeText(this, sb3.toString(), i2).show();
                    return;
                }
            }
            m0();
            I0(true);
        }
    }

    public void btn_cus_remove(View view) {
        FragmentStatePagerSupport_Main.a0 = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(info.aalmoghalis.inventory.R.string.delete_msg));
        this.n = Integer.parseInt(((TextView) ((RelativeLayout) ((View) view.getParent()).getParent()).findViewById(info.aalmoghalis.inventory.R.id.tr_id)).getText().toString());
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new t());
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new u());
        builder.create().show();
    }

    public void btn_cus_save(View view) {
        int i;
        int i2;
        String message;
        String str;
        String str2;
        String str3;
        String str4;
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.d).l("10", "edit")) {
                Context context = this.E0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.d).l("10", "new")) {
            Context context2 = this.E0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        FragmentStatePagerSupport_Main.a0 = true;
        if (this.I.isChecked()) {
            i = -1;
        } else {
            i = this.J.isChecked() ? 1 : 0;
        }
        U();
        if (V()) {
            try {
                if (this.B.getText().toString().equals(getString(info.aalmoghalis.inventory.R.string.btn_save)) && this.n != 0) {
                    int i3 = i;
                    if (this.F.getTag() == null) {
                        if (this.d.O8(this.n).equals("0")) {
                            Z00 z00 = this.d;
                            StringBuilder sb = new StringBuilder();
                            sb.append("update transactions set out='");
                            sb.append(this.w.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                            sb.append("',[in]='");
                            sb.append(i3);
                            sb.append("',date_='");
                            sb.append(this.x.getText().toString());
                            sb.append("',remarks='");
                            sb.append(this.z.getText().toString());
                            sb.append("',param1='',curr_id=");
                            if (this.Q.getTag() == null) {
                                str3 = "0";
                            } else {
                                str3 = "(select id from currency where name='" + this.Q.getTag().toString() + "')";
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
                            sb2.append(this.w.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                            sb2.append("',date_='");
                            sb2.append(this.x.getText().toString());
                            sb2.append("',remarks='");
                            sb2.append(this.z.getText().toString());
                            sb2.append("',param1='',curr_id=");
                            if (this.Q.getTag() == null) {
                                str4 = "0";
                            } else {
                                str4 = "(select id from currency where name='" + this.Q.getTag().toString() + "')";
                            }
                            sb2.append(str4);
                            sb2.append(",cus_id=(select id from customers where name=(case when cus_id=fund_id then '");
                            sb2.append(this.m0.getText().toString());
                            sb2.append("'  else '");
                            sb2.append(this.v.getText().toString());
                            sb2.append("' end)),t_cus_id=(select id from customers where name=(case when cus_id=fund_id then '");
                            sb2.append(this.v.getText().toString());
                            sb2.append("'  else '");
                            sb2.append(this.m0.getText().toString());
                            sb2.append("' end)),fund_id=(select id from customers where name='");
                            sb2.append(this.m0.getText().toString());
                            sb2.append("') where id='");
                            sb2.append(this.n);
                            sb2.append("'");
                            z01.x0(sb2.toString());
                        }
                    } else if (this.d.O8(this.n).equals("0")) {
                        Z00 z02 = this.d;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("update transactions set out='");
                        sb3.append(this.w.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb3.append("',[in]='");
                        sb3.append(i3);
                        sb3.append("',date_='");
                        sb3.append(this.x.getText().toString());
                        sb3.append("',remarks='");
                        sb3.append(this.z.getText().toString());
                        sb3.append("',param1='");
                        sb3.append(this.F.getTag().toString());
                        sb3.append("',curr_id=");
                        if (this.Q.getTag() == null) {
                            str = "0";
                        } else {
                            str = "(select id from currency where name='" + this.Q.getTag().toString() + "')";
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
                        sb4.append(this.w.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                        sb4.append("',date_='");
                        sb4.append(this.x.getText().toString());
                        sb4.append("',remarks='");
                        sb4.append(this.z.getText().toString());
                        sb4.append("',param1='");
                        sb4.append(this.F.getTag().toString());
                        sb4.append("',curr_id=");
                        if (this.Q.getTag() == null) {
                            str2 = "0";
                        } else {
                            str2 = "(select id from currency where name='" + this.Q.getTag().toString() + "')";
                        }
                        sb4.append(str2);
                        sb4.append(",cus_id=(select id from customers where name=(case when cus_id=fund_id then '");
                        sb4.append(this.m0.getText().toString());
                        sb4.append("'  else '");
                        sb4.append(this.v.getText().toString());
                        sb4.append("' end)),t_cus_id=(select id from customers where name=(case when cus_id=fund_id then '");
                        sb4.append(this.v.getText().toString());
                        sb4.append("'  else '");
                        sb4.append(this.m0.getText().toString());
                        sb4.append("' end)),fund_id=(select id from customers where name='");
                        sb4.append(this.m0.getText().toString());
                        sb4.append("') where id='");
                        sb4.append(this.n);
                        sb4.append("'");
                        z03.x0(sb4.toString());
                    }
                    this.w.setText((CharSequence) null);
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    this.x.setText(simpleDateFormat.format(calendar.getTime()));
                    this.y.setText(simpleDateFormat.format(calendar.getTime()));
                    this.q = calendar.get(1);
                    this.t = calendar.get(2);
                    this.u = calendar.get(5);
                    this.z.setText((CharSequence) null);
                    D0(this.F);
                    this.A.setText((CharSequence) null);
                    this.B.setText(getString(info.aalmoghalis.inventory.R.string.btn_add));
                    this.n = 0;
                }
                m0();
                I0(true);
            } catch (Exception e) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Error:");
                if (e.getMessage() == null || e.getMessage().length() <= 20) {
                    i2 = 0;
                    message = e.getMessage();
                } else {
                    i2 = 0;
                    message = e.getMessage().substring(0, 20);
                }
                sb5.append(message);
                Toast.makeText(this, sb5.toString(), i2).show();
                e.printStackTrace();
            }
        }
    }

    public final void c0() {
        String[] stringArray = this.F.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new w(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    public void calc_pick_btn(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", this.w.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void d0() {
        if (C2160f10.h > 0 && !new C2160f10(this.d).l("10", "edit")) {
            Context context = this.E0;
            Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        int size = this.U.size() - 1;
        if (this.U.valueAt(size)) {
            C0795Oh item = this.S.getItem(this.U.keyAt(size));
            String strA = item.a() != null ? item.a() : "";
            this.k0 = strA;
            int i = strA.equals("") ? 0 : Integer.parseInt(this.k0);
            if (i > 0) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_edit), 1).show();
                this.n = 0;
                return;
            }
            if (i != -1) {
                return;
            }
            I0(false);
            if (item.p().equals(item.f())) {
                this.v.setText(item.h());
            } else {
                this.v.setText(item.p());
            }
            this.m0.setText(item.f());
            this.n = Integer.parseInt(item.o().toString());
            this.w.setText(item.l().toString().replaceAll(",", ""));
            this.x.setText(item.n());
            this.F.setTag(item.m() != null ? item.m() : "");
            int iR = item.r();
            this.j0 = item.b();
            this.B.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
            int[] iArr = this.e0;
            if (iR == iArr[0]) {
                this.I.setChecked(true);
            } else if (iR == iArr[2]) {
                this.J.setChecked(true);
            }
            this.h0 = item.q();
            if (this.d.O8(this.n).equals("0")) {
                this.H.setVisibility(0);
                this.d.nd(this.z, item.q());
            } else {
                this.h0 = this.d.R8(this.n);
                this.H.setVisibility(4);
                this.d.nd(this.z, this.h0);
            }
            if (this.F.getTag().toString().equals("")) {
                D0(this.F);
            } else {
                F0(this.F.getTag().toString());
            }
            f0();
            this.w.selectAll();
            this.w.requestFocus();
            r0(4, 500);
        }
    }

    public void e0() {
        if (getIntent().getStringExtra("TR_ID") != null) {
            if (C2160f10.h > 0 && !new C2160f10(this.d).l("10", "edit")) {
                Context context = this.E0;
                Toast.makeText(context, context.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        } else if (C2160f10.h > 0 && !new C2160f10(this.d).l("10", "new")) {
            Context context2 = this.E0;
            Toast.makeText(context2, context2.getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        if (!this.k0.equals("0") && !this.k0.equals("") && !this.k0.equals("-1")) {
            q0(this.k0);
            return;
        }
        I0(false);
        f0();
        this.w.setText(this.g0.replaceAll(",", ""));
        this.x.setText(this.f0);
        this.F.setTag(this.i0);
        int i = this.l0;
        this.B.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
        int[] iArr = this.e0;
        if (i == iArr[0]) {
            this.I.setChecked(true);
        } else if (i == iArr[2]) {
            this.J.setChecked(true);
        }
        if (this.d.O8(this.n).equals("0")) {
            this.H.setVisibility(0);
        } else {
            this.h0 = this.d.R8(this.n);
            this.H.setVisibility(4);
        }
        this.d.nd(this.z, this.h0);
        Log.d("tr_attach_l=", this.i0);
        if (this.i0.equals("")) {
            D0(this.F);
        } else {
            Log.d("tr_attach_l=", this.i0);
            F0(this.i0);
        }
        this.w.selectAll();
        this.w.requestFocus();
        J0();
        r0(4, 500);
        o0();
    }

    public void f0() {
        this.P = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
        this.Q = (RadioGroup) findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        if (Z00.Z) {
            ArrayList arrayListJ3 = this.d.j3();
            this.R = arrayListJ3;
            String str = this.j;
            if (str == null) {
                str = "";
            }
            this.j = str;
            int size = arrayListJ3.size();
            RadioButton[] radioButtonArr = new RadioButton[size];
            this.Q.setTag(null);
            this.Q.removeAllViews();
            this.Q.clearCheck();
            for (int i = 0; i < this.R.size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButtonArr[i] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.R.get(i)).get("name"));
                radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.R.get(i)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i].setOnClickListener(new J());
                this.Q.addView(radioButtonArr[i]);
                String str2 = this.j0;
                if (str2 != null && str2.equals(((HashMap) this.R.get(i)).get("name"))) {
                    this.Q.check(radioButtonArr[i].getId());
                    this.Q.setTag(((HashMap) this.R.get(i)).get("name"));
                }
            }
            if (!this.j.equals("")) {
                this.Q.setTag(this.j);
                for (int i2 = 0; i2 < size; i2++) {
                    if (radioButtonArr[i2].getText().toString().equals(this.j)) {
                        this.Q.check(radioButtonArr[i2].getId());
                    }
                }
                return;
            }
            String str3 = this.j0;
            if (str3 == null || str3.equals("")) {
                this.Q.check(radioButtonArr[this.R.size() - 1].getId());
                this.Q.setTag(radioButtonArr[this.R.size() - 1].getText().toString());
                this.j = radioButtonArr[this.R.size() - 1].getText().toString();
            }
        }
    }

    public void g0(Cursor cursor) {
        Customer_Det_List_edit3 customer_Det_List_edit3 = this;
        cursor.getCount();
        customer_Det_List_edit3.p = 0.0d;
        customer_Det_List_edit3.T.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            customer_Det_List_edit3.T.add(new C0795Oh(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("date_")), "" + cursor.getDouble(cursor.getColumnIndex("amount")), cursor.getString(cursor.getColumnIndex("remarks")), customer_Det_List_edit3.e0[cursor.getInt(cursor.getColumnIndex("_in"))], cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("bill_id")), cursor.getString(cursor.getColumnIndex("curr_name")), cursor.getString(cursor.getColumnIndex("param1")), cursor.getString(cursor.getColumnIndex("fund_name")), cursor.getString(cursor.getColumnIndex("other_account"))));
            cursor.moveToNext();
            customer_Det_List_edit3 = this;
        }
        cursor.close();
    }

    public final void h0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.v0.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.r0);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String i0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public String j0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (v0(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (u0(uri)) {
                        return i0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (w0(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return i0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return i0(context, uri, null, null);
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

    public boolean k0(String str, String str2, Context context) {
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
        n0();
        return this.y0;
    }

    public boolean l0(String str, String str2, Context context) {
        y yVar = new y();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new z(yVar));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new A(yVar));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.z0;
    }

    public void m0() {
        Cursor cursorN3;
        if (this.Q.getTag() == null) {
            if (Z00.Z) {
                Z00 z00 = this.d;
                String string = this.v.getText().toString();
                String str = this.j;
                if (str == null) {
                    str = "";
                }
                cursorN3 = z00.N3(string, str, "-1");
            } else {
                cursorN3 = this.d.L3(this.v.getText().toString());
            }
            g0(cursorN3);
        } else if (this.v.getText().toString().length() == 0) {
            g0(this.d.P3(this.Q.getTag().toString(), "-1"));
        } else {
            g0(this.d.N3(this.v.getText().toString(), this.Q.getTag().toString(), "-1"));
        }
        o0();
        C0835Pv c0835Pv = new C0835Pv(this, info.aalmoghalis.inventory.R.layout.customer_det_row_all, this.T);
        this.S = c0835Pv;
        this.K.setAdapter((ListAdapter) c0835Pv);
        this.S.notifyDataSetChanged();
    }

    public void n0() {
        Cursor cursorI4 = this.d.I4();
        this.c0 = new String[cursorI4.getCount()];
        if (cursorI4.moveToFirst()) {
            int i = 0;
            do {
                this.c0[i] = cursorI4.getString(cursorI4.getColumnIndex("_id"));
                i++;
            } while (cursorI4.moveToNext());
        }
        cursorI4.close();
        this.V = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.c0);
        this.v.setThreshold(1);
        this.v.setAdapter(this.V);
    }

    public void o0() {
        Log.d("get_remarks=", this.B0 + "");
        C1044Xj.a().c(new RunnableC1171Zj(4, this.d, this.v, this.z, this.A, this, this.N, this.B0 ? 1 : 2, this.B, new RunnableC1086Yj()));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (i2 != 0) {
                if (i == 2) {
                    if (intent != null) {
                        this.w.setText(this.d.P7(intent.getStringExtra("calc_result")));
                    }
                } else if (i == 1) {
                    if (i2 == -1) {
                        Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                        this.p0.setText(string);
                        cursorQuery.close();
                        Log.d("Phone=", "ZZZ number : " + string + " , name : " + string2);
                    }
                } else if (i == this.r0 && intent != null) {
                    B0(intent.getData(), false);
                } else if (i == this.q0) {
                    z0(intent);
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
        String stringExtra = "";
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.content_customer_det_edit2);
        G0();
        setTitle(getString(info.aalmoghalis.inventory.R.string.opening_balance));
        this.K = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_cus_det_edit);
        this.K.setChoiceMode(2);
        this.d = new Z00(this.c, this);
        this.e = new E00(this);
        Z00.Z = this.d.ja("prefOthers_currency", true);
        this.v = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.cus_name_det);
        EditText editText = (EditText) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        this.w = editText;
        editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
        EditText editText2 = this.w;
        editText2.addTextChangedListener(new C2018dE(editText2));
        this.B = (Button) findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
        this.C = (Button) findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add1);
        Button button = (Button) findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add2);
        this.D = button;
        this.d.fd(this.C, button);
        this.E = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
        this.H = (RadioGroup) findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
        this.I = (RadioButton) findViewById(info.aalmoghalis.inventory.R.id.radiobutton1);
        RadioButton radioButton = (RadioButton) findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
        this.J = radioButton;
        this.d.gd(this.I, radioButton);
        this.H.check(info.aalmoghalis.inventory.R.id.radiobutton2);
        this.Y = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.img);
        this.z = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
        this.A = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks4);
        this.F = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        this.G = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.btn_attach4);
        this.L = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
        this.M = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
        this.N = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
        this.O = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface5);
        this.o0 = (LinearLayout) findViewById(info.aalmoghalis.inventory.R.id.edit_cash_interface);
        this.m0 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.tv_cash);
        this.n0 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.d.i4());
        TextView textView = this.m0;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        this.m0.setText(this.d.h4().j());
        this.m0.setOnClickListener(new ViewOnClickListenerC2745e());
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.q = calendar.get(1);
        this.t = calendar.get(2);
        this.u = calendar.get(5);
        n0();
        this.v.setThreshold(1);
        this.v.setAdapter(this.V);
        this.v.setOnItemClickListener(this);
        this.d.cd(this, this.v);
        I0(true);
        o0();
        try {
            if (getIntent().getStringExtra("read_imei") != null && getIntent().getStringExtra("read_imei").equals("1")) {
                r0(2, 10);
                this.d.L0();
            }
        } catch (Exception unused) {
        }
        try {
            if (getIntent().getStringExtra("CUS_NAME") != null) {
                this.v.setText(getIntent().getStringExtra("CUS_NAME"));
                this.g = getIntent().getStringExtra("CUS_NAME");
                this.l = getIntent().getStringExtra("CUS_GSM");
                this.f = getIntent().getStringExtra("CUS_ID");
                this.h = getIntent().getStringExtra("G_NAME");
                this.j = getIntent().getStringExtra("CURR_NAME") == null ? "" : getIntent().getStringExtra("CURR_NAME");
                this.b0 = 1;
                this.w.requestFocus();
                I0(true);
                o0();
            } else {
                this.v.requestFocus();
            }
        } catch (Exception unused2) {
        }
        try {
            if (getIntent().getStringExtra("TR_ID") != null) {
                I0(false);
                o0();
                this.n = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
                this.m0.setText(this.d.X4("select b.name as _id from transactions a,customers b where a.fund_id=b.id and a.id=" + this.n));
                this.v.setText(this.d.X4("select (select name from customers where id=(case when a.cus_id=a.fund_id then a.t_cus_id else a.cus_id end ) ) as _id from transactions a where a.id=" + this.n));
                this.w.setText(getIntent().getStringExtra("TR_AMOUNT").toString().replaceAll(",", ""));
                this.x.setText(getIntent().getStringExtra("TR_DATE").toString());
                if (this.d.O8(this.n).equals("0")) {
                    this.H.setVisibility(0);
                    this.d.nd(this.z, getIntent().getStringExtra("TR_REMARKS").toString());
                } else {
                    this.h0 = this.d.R8(this.n);
                    this.H.setVisibility(4);
                    this.d.nd(this.z, this.h0);
                }
                int intExtra = getIntent().getIntExtra("TR_TYPE", -10);
                this.B.setText(getString(info.aalmoghalis.inventory.R.string.btn_save));
                int[] iArr = this.e0;
                if (intExtra == iArr[0]) {
                    this.I.setChecked(true);
                } else if (intExtra == iArr[2]) {
                    this.J.setChecked(true);
                }
                this.w.requestFocus();
                this.w.selectAll();
                J0();
                r0(4, 500);
            }
        } catch (Exception unused3) {
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
        } catch (Exception unused4) {
        }
        this.K.setOnItemClickListener(new C2756p());
        this.K.setChoiceMode(3);
        this.K.setMultiChoiceModeListener(new C2757q());
        if (getIntent().getStringExtra("TR_ID") != null && C2160f10.h > 0 && !new C2160f10(this.d).l("10", "edit")) {
            this.x.setEnabled(false);
            this.Q.setEnabled(false);
            this.z.setEnabled(false);
        }
        try {
            f0();
            if (this.v.getText() == null || this.v.getText().toString().length() == 0) {
                a0();
            } else {
                m0();
            }
            this.d.L0();
        } catch (Exception unused5) {
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(t0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.C0, this.q, this.t, this.u);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(t0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.D0, this.q, this.t, this.u);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C0795Oh>> onCreateLoader(int i, Bundle bundle) {
        return new C0856Qh(this, this.d, this.j, 1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.v.setText(adapterView.getItemAtPosition(i).toString());
        p0(this.v.getText().toString());
        m0();
        I0(true);
        this.w.requestFocus();
        o0();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C0795Oh>> loader) {
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.Q.setTag(radioButton.getText().toString());
            this.j = this.Q.getTag() == null ? this.j : this.Q.getTag().toString();
            m0();
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
            P(getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_storage));
            return;
        }
        if (i == 113) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            P(getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_contacts));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (Bill_edit.P2) {
                String str = this.g;
                if (str != null && str.equals(Bill_edit.R2)) {
                    a0();
                    Bill_edit.P2 = false;
                    Bill_edit.R2 = "";
                }
            } else if (this.S != null && this.e.i > 0) {
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

    public void p0(String str) {
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

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void q0(String str) {
        C4145vh c4145vhB2 = this.d.b2(str);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", c4145vhB2.o());
        intent.putExtra("tran_status", c4145vhB2.p());
        intent.putExtra("g_id", c4145vhB2.n());
        intent.putExtra("g_name", c4145vhB2.a());
        intent.putExtra("back_edit", 1);
        startActivity(intent);
    }

    public void r0(int i, int i2) {
        try {
            new Handler().postDelayed(new N(i), i2);
        } catch (Exception unused) {
        }
    }

    public final boolean s0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    public final boolean t0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && s0(21, 22);
    }

    public final /* synthetic */ void x0(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        B0(uri, true);
    }

    public void y0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") == 0) {
            this.d.Tb();
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.d.Tb();
        } else {
            Z00.R = "PERMISSION_DEN";
            C0();
        }
    }

    public final void z0(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                Z(new File(Z00.A0), file2);
            } else {
                Z(new File(j0(this, this.x0)), file2);
            }
            F0(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }
}
