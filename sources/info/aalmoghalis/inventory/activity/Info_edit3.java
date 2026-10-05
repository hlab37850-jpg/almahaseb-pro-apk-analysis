package info.aalmoghalis.inventory.activity;

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
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
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
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.material.timepicker.TimeModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C0974Ur;
import defpackage.C1098Yv;
import defpackage.C2160f10;
import defpackage.C3966tX;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.helper.Barcode_add;
import info.aalmoghalis.inventory.helper.Excel_add;
import info.aalmoghalis.inventory.lang.BaseActivity;
import info.aalmoghalis.inventory.old.Unit_item_edit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Info_edit3 extends BaseActivity {
    public static boolean x0 = false;
    public C0922Sv A;
    public SparseBooleanArray C;
    public int H;
    public int I;
    public int J;
    public C1098Yv Q;
    public SearchView W;
    public Cursor a0;
    public SQLiteDatabase d;
    public Z00 e;
    public String m0;
    public Uri p0;
    public boolean q0;
    public boolean s0;
    public String v0;
    public String w0;
    public String c = Info_edit3.class.getSimpleName();
    public double f = 0.0d;
    public int g = 0;
    public int h = 0;
    public AutoCompleteTextView i = null;
    public EditText j = null;
    public EditText k = null;
    public TextView l = null;
    public ImageView n = null;
    public TextView p = null;
    public TextView q = null;
    public ImageView t = null;
    public TextView u = null;
    public TextView v = null;
    public TextView w = null;
    public Button x = null;
    public ListView y = null;
    public LinearLayout z = null;
    public List B = new ArrayList();
    public ImageButton D = null;
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] F = {info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
    public Toolbar G = null;
    public int K = -1;
    public String L = "";
    public String M = "";
    public String N = "";
    public String O = "";
    public TextView P = null;
    public int R = 0;
    public DatePickerDialog.OnDateSetListener S = new Q();
    public DatePickerDialog.OnDateSetListener T = new Z();
    public DatePickerDialog.OnDateSetListener U = new k0();
    public DatePickerDialog.OnDateSetListener V = new l0();
    public String X = "";
    public Handler Y = new n0();
    public int Z = 0;
    public int b0 = 0;
    public String c0 = CSS.Value.PERCENTAGE;
    public String d0 = CSS.Value.PERCENTAGE;
    public TextView e0 = null;
    public TextView f0 = null;
    public int g0 = 0;
    public ImageView h0 = null;
    public EditText i0 = null;
    public String j0 = "";
    public int k0 = 3;
    public int l0 = 4;
    public ActivityResultLauncher n0 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: Is
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.a.l0((Uri) obj);
        }
    });
    public ActivityResultLauncher o0 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new G());
    public String r0 = "";
    public RadioGroup t0 = null;
    public ArrayList u0 = new ArrayList();

    public class A implements Runnable {
        public final /* synthetic */ String a;

        public A(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Info_edit3.this.W.onActionViewExpanded();
            Info_edit3.this.W.setQuery(this.a, true);
        }
    }

    public class B implements View.OnKeyListener {
        public final /* synthetic */ EditText a;

        public B(EditText editText) {
            this.a = editText;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            return Info_edit3.this.T(keyEvent, this.a);
        }
    }

    public class C implements Runnable {
        public final /* synthetic */ String a;

        public C(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Info_edit3.this.u0(this.a);
        }
    }

    public class D implements Runnable {
        public final /* synthetic */ String a;

        public D(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Info_edit3.this.W.onActionViewExpanded();
            Info_edit3.this.W.setQuery(this.a, true);
        }
    }

    public class E implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public E(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Info_edit3.this);
                if (this.a[i].equals(Info_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Info_edit3 info_edit3 = Info_edit3.this;
                    info_edit3.m0 = info_edit3.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Info_edit3.this.P();
                    }
                } else if (this.a[i].equals(Info_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Info_edit3 info_edit4 = Info_edit3.this;
                    info_edit4.m0 = info_edit4.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Info_edit3.this.Y();
                    }
                } else if (this.a[i].equals(Info_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Info_edit3.this.e.qa(Z00.M + Info_edit3.this.t.getTag().toString());
                } else if (this.a[i].equals(Info_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Info_edit3.this.t.setTag(null);
                    Info_edit3.this.t.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class F implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public F(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(Info_edit3.this);
                if (this.a[i].equals(Info_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    Info_edit3 info_edit3 = Info_edit3.this;
                    info_edit3.m0 = info_edit3.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        Info_edit3.this.P();
                    }
                } else if (this.a[i].equals(Info_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    Info_edit3 info_edit4 = Info_edit3.this;
                    info_edit4.m0 = info_edit4.getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        Info_edit3.this.Y();
                    }
                } else if (this.a[i].equals(Info_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    Info_edit3.this.e.qa(Z00.M + Info_edit3.this.t.getTag().toString());
                } else if (this.a[i].equals(Info_edit3.this.getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    Info_edit3.this.t.setTag(null);
                    Info_edit3.this.t.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    Info_edit3.this.t.getLayoutParams().width = (int) Info_edit3.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    Info_edit3.this.t.getLayoutParams().height = (int) Info_edit3.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class G implements ActivityResultCallback {
        public G() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                Info_edit3.this.E0();
            }
        }
    }

    public class H extends Handler {
        public H() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class I implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public I(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Info_edit3.this.e.v0("insert into item_type  (name )  values( '" + Info_edit3.this.r0.trim() + "'  )");
            Info_edit3.this.q0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class J implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public J(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Info_edit3.this.q0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class K extends Handler {
        public K() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class L implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public L(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Info_edit3.this.e.v0("insert into units  (name,code )  values( '" + Info_edit3.this.r0.trim() + "' ,'" + Info_edit3.this.r0.trim() + "'  )");
            Info_edit3.this.s0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class M implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public M(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Info_edit3.this.s0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
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
        }
    }

    public class P implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ AlertDialog d;

        public P(AutoCompleteTextView autoCompleteTextView, EditText editText, EditText editText2, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = editText;
            this.c = editText2;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (AbstractC4371yX.a(this.c) ? zA : false) {
                if (Info_edit3.this.M.equals("suppliers")) {
                    Info_edit3.this.e.v0("insert into customers (name,gsm,address,cus_type_id )  values( '" + this.a.getText().toString().trim() + "','" + this.b.getText().toString() + "','" + this.c.getText().toString() + "',1  )");
                } else {
                    Info_edit3.this.e.v0("insert into " + Info_edit3.this.M + "  (name,gsm,address )  values( '" + this.a.getText().toString().trim() + "','" + this.b.getText().toString() + "','" + this.c.getText().toString() + "'  )");
                }
                Info_edit3.this.d0();
                this.d.dismiss();
            }
        }
    }

    public class Q implements DatePickerDialog.OnDateSetListener {
        public Q() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Info_edit3.this.H = i;
            Info_edit3.this.I = i2;
            Info_edit3.this.J = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Info_edit3.this.H)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Info_edit3.this.I + 1)) + "-" + Info_edit3.this.J;
                Locale locale = Locale.ENGLISH;
                Info_edit3.this.p.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class R implements View.OnClickListener {
        public R() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.onRadioButtonClicked(view);
        }
    }

    public class S implements View.OnClickListener {
        public final /* synthetic */ ImageView a;

        public S(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Info_edit3.this.e.qa(Z00.M + this.a.getTag().toString());
            } catch (Exception unused) {
            }
        }
    }

    public class T implements DialogInterface.OnClickListener {
        public final /* synthetic */ ImageView a;

        public T(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Info_edit3.this.e.qa(Z00.M + this.a.getTag().toString());
            } catch (Exception unused) {
            }
        }
    }

    public class U implements DialogInterface.OnClickListener {
        public final /* synthetic */ C4145vh a;

        public U(C4145vh c4145vh) {
            this.a = c4145vh;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Info_edit3.this.G0(this.a.a(), this.a.n(), this.a.o(), this.a.p(), this.a.q(), this.a.r(), this.a.s(), this.a.t(), this.a.u(), this.a.b(), this.a.c());
            } catch (Exception unused) {
                Toast.makeText(Info_edit3.this.getBaseContext(), "SQL Error.", 1);
            }
        }
    }

    public class V implements DialogInterface.OnClickListener {
        public V() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class W implements DialogInterface.OnClickListener {
        public final /* synthetic */ C4145vh a;

        public W(C4145vh c4145vh) {
            this.a = c4145vh;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Info_edit3.this.r0(this.a);
            } catch (Exception unused) {
            }
        }
    }

    public class X implements View.OnClickListener {
        public X() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.showDialog(0);
        }
    }

    public class Y implements View.OnClickListener {
        public Y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.showDialog(1);
        }
    }

    public class Z implements DatePickerDialog.OnDateSetListener {
        public Z() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Info_edit3.this.H = i;
            Info_edit3.this.I = i2;
            Info_edit3.this.J = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Info_edit3.this.H)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Info_edit3.this.I + 1)) + "-" + Info_edit3.this.J;
                Locale locale = Locale.ENGLISH;
                Info_edit3.this.q.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$a, reason: case insensitive filesystem */
    public class RunnableC2887a implements Runnable {
        public RunnableC2887a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Info_edit3 info_edit3 = Info_edit3.this;
            Z00 z00 = info_edit3.e;
            z00.Cb(info_edit3.y, z00.ic(info_edit3.X));
            Message message = new Message();
            message.obj = "1";
            Info_edit3.this.Y.sendMessage(message);
        }
    }

    public class a0 implements View.OnClickListener {
        public a0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.O(view, true);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$b, reason: case insensitive filesystem */
    public class RunnableC2888b implements Runnable {
        public final /* synthetic */ View a;

        public RunnableC2888b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Info_edit3 info_edit3 = Info_edit3.this;
            info_edit3.B = info_edit3.A.e;
            if (this.a.getId() == info.aalmoghalis.inventory.R.id.f1) {
                Info_edit3.this.sort_remarks_click(this.a);
                Info_edit3.this.Z = 1;
            }
            Message message = new Message();
            message.obj = "2";
            Info_edit3.this.Y.sendMessage(message);
        }
    }

    public class b0 implements View.OnClickListener {
        public final /* synthetic */ String a;

        public b0(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.s0(this.a, "0");
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$c, reason: case insensitive filesystem */
    public class C2889c implements Comparator {
        public C2889c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a()));
        }
    }

    public class c0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public c0(AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.requestFocus();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$d, reason: case insensitive filesystem */
    public class C2890d implements Comparator {
        public C2890d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a()));
        }
    }

    public class d0 implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public d0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$e, reason: case insensitive filesystem */
    public class RunnableC2891e implements Runnable {
        public RunnableC2891e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Info_edit3.this.d0();
            Message message = new Message();
            message.obj = "0";
            Info_edit3.this.Y.sendMessage(message);
        }
    }

    public class e0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public e0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$f, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2892f implements View.OnClickListener {
        public ViewOnClickListenerC2892f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.showDialog(3);
        }
    }

    public class f0 implements View.OnClickListener {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ AutoCompleteTextView b;

        public f0(ArrayList arrayList, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayList;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.Q(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$g, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2893g implements View.OnClickListener {
        public ViewOnClickListenerC2893g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.showDialog(4);
        }
    }

    public class g0 implements View.OnClickListener {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ AutoCompleteTextView b;

        public g0(ArrayList arrayList, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayList;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.Q(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$h, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2894h implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2894h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h0 implements DialogInterface.OnClickListener {
        public h0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$i, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2895i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2895i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Info_edit3 info_edit3 = Info_edit3.this;
                info_edit3.b0 = 0;
                info_edit3.e0();
            } catch (Exception unused) {
            }
        }
    }

    public class i0 implements DialogInterface.OnClickListener {
        public i0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2896j implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC2896j(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Info_edit3 info_edit3 = Info_edit3.this;
                info_edit3.b0 = 1;
                if (info_edit3.e0.getText() == null) {
                    Info_edit3.this.c0 = "";
                } else {
                    Info_edit3 info_edit4 = Info_edit3.this;
                    info_edit4.c0 = info_edit4.e0.getText().toString();
                }
                if (Info_edit3.this.f0.getText() == null) {
                    Info_edit3.this.d0 = "";
                } else {
                    Info_edit3 info_edit5 = Info_edit3.this;
                    info_edit5.d0 = info_edit5.f0.getText().toString();
                }
                Info_edit3.this.e0();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class j0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ android.app.AlertDialog e;
        public final /* synthetic */ AutoCompleteTextView f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ String h;

        public j0(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, EditText editText3, android.app.AlertDialog alertDialog, AutoCompleteTextView autoCompleteTextView2, EditText editText4, String str) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = editText2;
            this.d = editText3;
            this.e = alertDialog;
            this.f = autoCompleteTextView2;
            this.g = editText4;
            this.h = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.d)) {
                zA = false;
            }
            if (zA && Info_edit3.this.e.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Info_edit3.this.r0 = this.b.getText().toString();
                Info_edit3 info_edit3 = Info_edit3.this;
                info_edit3.b0(info_edit3.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type), Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type) + "#" + Info_edit3.this.r0, this.e.getContext());
                if (!Info_edit3.this.q0) {
                    return;
                }
            }
            if (Info_edit3.this.e.Z8(this.f.getText().toString()).getCount() == 0 && this.f.getText().toString().trim().length() > 0) {
                Info_edit3.this.r0 = this.f.getText().toString();
                Info_edit3 info_edit4 = Info_edit3.this;
                info_edit4.c0(info_edit4.getString(info.aalmoghalis.inventory.R.string.add_unit), Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.add_unit) + "#" + Info_edit3.this.r0, this.e.getContext());
                if (!Info_edit3.this.s0) {
                    return;
                }
            }
            if (zA) {
                Info_edit3 info_edit5 = Info_edit3.this;
                if (C3966tX.j(info_edit5, info_edit5.e, true)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("update items  set name='");
                sb.append(this.a.getText().toString().trim());
                sb.append("',item_type_id=(select b.id from item_type b where b.name='");
                sb.append(this.b.getText().toString());
                sb.append("'),o_qty='");
                sb.append(this.c.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb.append("',o_cost='");
                sb.append(this.d.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb.append("',o_date='");
                sb.append(Info_edit3.this.p.getText().toString());
                sb.append("',e_date=");
                String str3 = "null";
                if (Info_edit3.this.q.getText().toString().equals(Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.end_date))) {
                    str = "null";
                } else {
                    str = "'" + Info_edit3.this.q.getText().toString() + "'";
                }
                sb.append(str);
                sb.append(",pic=");
                if (Info_edit3.this.t.getTag() == null) {
                    str2 = "null";
                } else {
                    str2 = "'" + Info_edit3.this.t.getTag().toString() + "'";
                }
                sb.append(str2);
                sb.append(",remarks='");
                sb.append(this.g.getText().toString());
                sb.append("',online=0,unit_id=ifnull((select b.id from units b where b.name='");
                sb.append(this.f.getText().toString());
                sb.append("'),0),barcode=");
                if (Info_edit3.this.i0.getText().toString().trim().length() != 0) {
                    str3 = "'" + Info_edit3.this.i0.getText().toString() + "'";
                }
                sb.append(str3);
                sb.append(" where name='");
                sb.append(this.h);
                sb.append("'");
                try {
                    Info_edit3.this.e.x0(sb.toString());
                    Info_edit3.this.e0();
                    Info_edit3 info_edit6 = Info_edit3.this;
                    if (info_edit6.R != 0) {
                        Bill_edit.P2 = true;
                        info_edit6.finish();
                    }
                    this.e.dismiss();
                } catch (Exception e) {
                    Info_edit3 info_edit7 = Info_edit3.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error:");
                    sb2.append((e.getMessage() == null || e.getMessage().length() <= 20) ? e.getMessage() : e.getMessage().substring(0, 20));
                    Toast.makeText(info_edit7, sb2.toString(), 1).show();
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$k, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2897k implements View.OnClickListener {
        public ViewOnClickListenerC2897k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Info_edit3.this.D0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class k0 implements DatePickerDialog.OnDateSetListener {
        public k0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Info_edit3.this.H = i;
            Info_edit3.this.I = i2;
            Info_edit3.this.J = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Info_edit3.this.H)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Info_edit3.this.I + 1)) + "-" + Info_edit3.this.J;
                Locale locale = Locale.ENGLISH;
                Info_edit3.this.e0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$l, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2898l implements DialogInterface.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ String[] b;

        public DialogInterfaceOnClickListenerC2898l(AutoCompleteTextView autoCompleteTextView, String[] strArr) {
            this.a = autoCompleteTextView;
            this.b = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setText(this.b[i]);
            this.a.dismissDropDown();
        }
    }

    public class l0 implements DatePickerDialog.OnDateSetListener {
        public l0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Info_edit3.this.H = i;
            Info_edit3.this.I = i2;
            Info_edit3.this.J = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Info_edit3.this.H)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Info_edit3.this.I + 1)) + "-" + Info_edit3.this.J;
                Locale locale = Locale.ENGLISH;
                Info_edit3.this.f0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$m, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2899m implements View.OnClickListener {
        public ViewOnClickListenerC2899m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.showDialog(0);
        }
    }

    public class m0 implements SearchView.OnQueryTextListener {
        public m0() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            Info_edit3.this.p0(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$n, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2900n implements View.OnClickListener {
        public ViewOnClickListenerC2900n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.showDialog(1);
        }
    }

    public class n0 extends Handler {
        public n0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Info_edit3.this.X();
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Info_edit3.this.e;
                StringBuilder sb = new StringBuilder();
                Info_edit3 info_edit3 = Info_edit3.this;
                sb.append(info_edit3.e.ic(info_edit3.X));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Info_edit3.this.A.notifyDataSetChanged();
                Info_edit3 info_edit4 = Info_edit3.this;
                if (info_edit4.Z == 1) {
                    info_edit4.e.ld(info_edit4, info_edit4.P, info_edit4.h);
                }
            }
            Info_edit3.this.B0(false);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$o, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2901o implements View.OnClickListener {
        public ViewOnClickListenerC2901o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.O(view, true);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$p, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2902p implements View.OnClickListener {
        public final /* synthetic */ EditText a;

        public ViewOnClickListenerC2902p(EditText editText) {
            this.a = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(Info_edit3.this, (Class<?>) Unit_item_edit.class);
            intent.putExtra("item_name", this.a.getText().toString());
            intent.putExtra("title_", Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.unit_item));
            Info_edit3.this.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$q, reason: case insensitive filesystem */
    public class C2903q implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C2903q(AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.requestFocus();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$r, reason: case insensitive filesystem */
    public class C2904r implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C2904r(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$s, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2905s implements View.OnClickListener {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2905s(ArrayList arrayList, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayList;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.Q(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$t, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2906t implements View.OnClickListener {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ AutoCompleteTextView b;

        public ViewOnClickListenerC2906t(ArrayList arrayList, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayList;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit3.this.Q(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$u, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2907u implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2907u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$v, reason: case insensitive filesystem */
    public class C2908v implements AdapterView.OnItemClickListener {
        public C2908v() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                Info_edit3 info_edit3 = Info_edit3.this;
                info_edit3.g0 = 0;
                if (info_edit3.K == 1) {
                    Info_edit3.this.H0((C4145vh) info_edit3.y.getAdapter().getItem(i));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$w, reason: case insensitive filesystem */
    public class C2909w implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$w$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Info_edit3.this.S();
                } catch (Exception unused) {
                    Toast.makeText(Info_edit3.this.getApplicationContext(), "SQL Error.", 1);
                }
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$w$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C2909w() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case info.aalmoghalis.inventory.R.id.menu_delete /* 2131297039 */:
                    SparseBooleanArray sparseBooleanArrayC = Info_edit3.this.A.c();
                    Info_edit3 info_edit3 = Info_edit3.this;
                    info_edit3.C = sparseBooleanArrayC;
                    AlertDialog.Builder builder = new AlertDialog.Builder(info_edit3);
                    builder.setMessage(Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.delete_msg));
                    builder.setPositiveButton(Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
                    builder.setNegativeButton(Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC2 = Info_edit3.this.A.c();
                    Info_edit3 info_edit4 = Info_edit3.this;
                    info_edit4.C = sparseBooleanArrayC2;
                    info_edit4.V();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(info.aalmoghalis.inventory.R.menu.contextual_action_bar3, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Info_edit3.this.y.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Info_edit3.this.A.l.clear();
            Info_edit3.this.A.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Info_edit3.this.y.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Info_edit3.this.A.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Info_edit3.this.y.getCheckedItemCount() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_delete).setVisible(true);
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$x, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2910x implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2910x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$y, reason: case insensitive filesystem */
    public class ViewOnClickListenerC2911y implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ android.app.AlertDialog e;
        public final /* synthetic */ AutoCompleteTextView f;
        public final /* synthetic */ EditText g;

        public ViewOnClickListenerC2911y(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, EditText editText3, android.app.AlertDialog alertDialog, AutoCompleteTextView autoCompleteTextView2, EditText editText4) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = editText2;
            this.d = editText3;
            this.e = alertDialog;
            this.f = autoCompleteTextView2;
            this.g = editText4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            boolean zA = AbstractC4371yX.a(this.a);
            if (this.b.getText().toString().length() == 0) {
                this.b.setText(Info_edit3.this.e.S6("0"));
            }
            if (this.c.getText().toString().length() == 0) {
                this.c.setText("0");
            }
            if (this.d.getText().toString().length() == 0) {
                this.d.setText("0");
            }
            if (Info_edit3.this.e.ja("prefOthers_barcode", false)) {
                Info_edit3 info_edit3 = Info_edit3.this;
                String strI6 = info_edit3.e.I6(info_edit3.i0.getText().toString());
                if (!strI6.equals("")) {
                    Toast.makeText(Info_edit3.this, Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.barcode_used) + " " + strI6, 1).show();
                    zA = false;
                }
            }
            if (zA && Info_edit3.this.e.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Info_edit3.this.r0 = this.b.getText().toString();
                Info_edit3 info_edit4 = Info_edit3.this;
                info_edit4.b0(info_edit4.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type), Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.validation_add_item_type) + "#" + Info_edit3.this.r0, this.e.getContext());
                if (!Info_edit3.this.q0) {
                    return;
                }
            }
            if (Info_edit3.this.e.Z8(this.f.getText().toString()).getCount() == 0 && this.f.getText().toString().trim().length() > 0) {
                Info_edit3.this.r0 = this.f.getText().toString();
                Info_edit3 info_edit5 = Info_edit3.this;
                info_edit5.c0(info_edit5.getString(info.aalmoghalis.inventory.R.string.add_unit), Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.add_unit) + "#" + Info_edit3.this.r0, this.e.getContext());
                if (!Info_edit3.this.s0) {
                    return;
                }
            }
            if (zA) {
                if (Info_edit3.this.e.s6(this.a.getText().toString().trim()).getCount() > 0) {
                    Info_edit3 info_edit6 = Info_edit3.this;
                    info_edit6.e.Pd(info_edit6, info_edit6.y, this.a.getText().toString().trim() + " : " + Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.exist), 5000, 1);
                    FragmentStatePagerSupport_Main.Z(Info_edit3.this);
                    this.e.dismiss();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("insert into items (name,item_type_id,o_qty,o_cost,curr_id,o_date,e_date,pic,remarks,unit_id,barcode) values('");
                sb.append(this.a.getText().toString().trim());
                sb.append("',(select b.id from item_type b where b.name='");
                sb.append(this.b.getText().toString());
                sb.append("'),'");
                sb.append(this.c.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb.append("','");
                sb.append(this.d.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb.append("',0,'");
                sb.append(Info_edit3.this.p.getText().toString());
                sb.append("',");
                String str3 = "null";
                if (Info_edit3.this.q.getText().toString().equals(Info_edit3.this.getString(info.aalmoghalis.inventory.R.string.end_date))) {
                    str = "null";
                } else {
                    str = "'" + Info_edit3.this.q.getText().toString() + "'";
                }
                sb.append(str);
                sb.append(",");
                if (Info_edit3.this.t.getTag() == null) {
                    str2 = "null";
                } else {
                    str2 = "'" + Info_edit3.this.t.getTag().toString() + "'";
                }
                sb.append(str2);
                sb.append(",'");
                sb.append(this.g.getText().toString());
                sb.append("',ifnull((select b.id from units b where b.name='");
                sb.append(this.f.getText().toString());
                sb.append("'),0),");
                if (Info_edit3.this.i0.getText().toString().trim().length() != 0) {
                    str3 = "'" + Info_edit3.this.i0.getText().toString() + "'";
                }
                sb.append(str3);
                sb.append(" )");
                String strY0 = Info_edit3.this.e.y0(sb.toString());
                if (strY0 != null && strY0.equals("1")) {
                    Info_edit3.this.e0();
                    this.e.dismiss();
                    if (this.f.getText().toString().length() != 0) {
                        Info_edit3.this.s0(this.a.getText().toString().trim(), "1");
                        return;
                    }
                    return;
                }
                Info_edit3 info_edit7 = Info_edit3.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strY0 != null && strY0.length() > 20) {
                    strY0 = strY0.substring(0, 20);
                }
                sb2.append(strY0);
                Toast.makeText(info_edit7, sb2.toString(), 0).show();
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit3$z, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC2912z implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2912z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void A0() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    private void N(String str) {
        new AlertDialog.Builder(this).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterfaceOnClickListenerC2912z()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        new C3966tX().d(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            E0();
            return;
        }
        int i = Integer.parseInt(this.e.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.e.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.o0.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(this, getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private void R(File file, File file2) throws IOException {
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

    private void U() {
        String[] stringArray = this.t.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new F(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.n0.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(this);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.l0);
    }

    private boolean f0(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean g0() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && f0(21, 22);
    }

    public static boolean h0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean i0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean j0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        q0(uri, true);
    }

    private void o0(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                R(new File(Z00.A0), file2);
            } else {
                R(new File(a0(this, this.p0)), file2);
            }
            y0(file2.getName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    private void q0(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.e, this);
            if (strX != null) {
                y0(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void v0(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
    }

    private void x0() {
        String[] stringArray = this.t.getTag() != null ? getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(stringArray, new E(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    private void z0() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void B0(boolean z) {
    }

    public final void C0(List list) {
        Collections.sort(list, Collections.reverseOrder(new C2889c()));
    }

    public void D0(View view) {
        B0(true);
        new Thread(new RunnableC2888b(view)).start();
    }

    public void E0() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.e.J2(this, intent);
            this.p0 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.p0.getPath() + "");
            startActivityForResult(intent, this.k0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void F0() {
        if (this.e.ja("prefOthers_barcode", false)) {
            C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, this.e.G6(), -4);
            this.Q = c1098Yv;
            c1098Yv.l.clear();
            this.Q.notifyDataSetChanged();
        }
    }

    public void G0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        try {
            if (C2160f10.h > 0 && !new C2160f10(this.e).l("15", "edit")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_item3_, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_name);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_qty);
            this.t0 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
            EditText editText3 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_cost);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_group);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.unit_others);
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.h0 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode2);
            EditText editText4 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode_no);
            this.i0 = editText4;
            editText4.setText(str11);
            if (this.e.ja("prefOthers_barcode", false)) {
                this.h0.setVisibility(0);
                this.i0.setVisibility(0);
            }
            this.p = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_date);
            this.q = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.end_date);
            this.t = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach4);
            EditText editText5 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.unit_name);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class_unit);
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            this.H = calendar.get(1);
            this.I = calendar.get(2);
            this.J = calendar.get(5);
            this.p.setOnClickListener(new X());
            this.q.setOnClickListener(new Y());
            this.t.setOnClickListener(new a0());
            textView.setOnClickListener(new b0(str));
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            this.e.ad(this, editText3);
            this.e.dd(this, editText5);
            this.e.cd(this, autoCompleteTextView2);
            editText.setText(str);
            this.e.nd(editText2, str3);
            editText3.setText(str4);
            autoCompleteTextView.setText(str2);
            autoCompleteTextView2.setText(str10);
            this.p.setText(str6);
            editText5.setText(str9);
            if (str7 != null && str7.length() > 0) {
                this.q.setText(str7);
            }
            this.w0 = str5;
            if (str8 == null || str8.equals("")) {
                v0(this.t);
            } else {
                y0(str8);
            }
            W();
            this.t0.setVisibility(8);
            editText.requestFocus();
            editText.selectAll();
            int i = this.K;
            int i2 = 1;
            if (i == 1 && this.R == 1) {
                editText3.requestFocus();
                editText3.selectAll();
            } else if (i != 1) {
                if (i == i2 && this.R == 3) {
                    editText5.requestFocus();
                    editText5.selectAll();
                }
            } else if (this.R == 2) {
                editText2.requestFocus();
                editText2.selectAll();
            } else {
                i2 = 1;
                if (i == i2) {
                    editText5.requestFocus();
                    editText5.selectAll();
                }
            }
            A0();
            ArrayList arrayListT6 = this.e.T6();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListT6);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new c0(autoCompleteTextView, editText2));
            autoCompleteTextView.setOnTouchListener(new d0(autoCompleteTextView));
            ArrayList arrayListC9 = this.e.c9();
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListC9);
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new e0(autoCompleteTextView2));
            imageView.setOnClickListener(new f0(arrayListT6, autoCompleteTextView));
            imageView2.setOnClickListener(new g0(arrayListC9, autoCompleteTextView2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new h0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new i0());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            Rect rect = new Rect();
            getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            alertDialogCreate.getWindow().setLayout((int) (rect.width() * 1.0f), alertDialogCreate.getWindow().getAttributes().height);
            alertDialogCreate.getButton(-1).setOnClickListener(new j0(editText, autoCompleteTextView, editText2, editText3, alertDialogCreate, autoCompleteTextView2, editText5, str));
        } catch (Exception e) {
            Log.d("update_item2_error=", e.getMessage() + "");
        }
    }

    public void H0(C4145vh c4145vh) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.item_det_view, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.desc_hdr);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.desc_det);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            c4145vh.x(this.e.x6(c4145vh.v()));
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb.append(getString(info.aalmoghalis.inventory.R.string.item_type) + " : \n");
            sb.append(getString(info.aalmoghalis.inventory.R.string.o_qty).trim() + " : \n");
            sb.append(getString(info.aalmoghalis.inventory.R.string.o_cost).trim() + " : \n");
            sb.append(getString(info.aalmoghalis.inventory.R.string.o_date).trim() + " : \n");
            if (!c4145vh.s().equals("")) {
                sb.append(getString(info.aalmoghalis.inventory.R.string.end_date).trim() + " : \n");
            }
            if (!c4145vh.u().equals("")) {
                sb.append(getString(info.aalmoghalis.inventory.R.string.tr_remarks).trim() + " : \n");
            }
            if (!c4145vh.b().equals("")) {
                sb.append(getString(info.aalmoghalis.inventory.R.string.base_unit).trim() + " : \n");
            }
            if (this.e.ja("prefOthers_barcode", false) && !c4145vh.c().equals("")) {
                sb.append(getString(info.aalmoghalis.inventory.R.string.barcode_no) + " : \n");
            }
            sb2.append(c4145vh.n() + StringUtilities.LF);
            sb2.append(c4145vh.o() + StringUtilities.LF);
            sb2.append(c4145vh.p() + StringUtilities.LF);
            sb2.append(c4145vh.r() + StringUtilities.LF);
            if (!c4145vh.s().equals("")) {
                sb2.append(c4145vh.s() + StringUtilities.LF);
            }
            if (!c4145vh.u().equals("")) {
                sb2.append(c4145vh.u() + StringUtilities.LF);
            }
            if (!c4145vh.b().equals("")) {
                sb2.append(c4145vh.b() + StringUtilities.LF);
            }
            if (this.e.ja("prefOthers_barcode", false) && !c4145vh.c().equals("")) {
                sb2.append(c4145vh.c() + StringUtilities.LF);
            }
            textView.setText(sb.toString());
            textView2.setText(sb2.toString());
            if (c4145vh.t() == null || c4145vh.t().equals("")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(Z00.p0(Z00.M + c4145vh.t(), 300, 300));
                imageView.setTag(c4145vh.t());
                imageView.getLayoutParams().width = 200;
                imageView.getLayoutParams().height = 200;
            }
            builder.setCancelable(true);
            imageView.setOnClickListener(new S(imageView));
            if (imageView.getTag() != null) {
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.view_image), new T(imageView));
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new U(c4145vh));
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.btn_close), new V());
            if (this.e.ja("prefOthers_barcode", false)) {
                builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.barcode2), new W(c4145vh));
            }
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(c4145vh.a());
            alertDialogCreate.show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("view_item_error=", ":" + e.getMessage());
        }
    }

    public void L(EditText editText) {
        editText.setOnKeyListener(new B(editText));
    }

    public void M() {
        try {
            this.b0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.e0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.f_date);
            this.f0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.t_date);
            this.e0.setOnClickListener(new ViewOnClickListenerC2892f());
            this.f0.setOnClickListener(new ViewOnClickListenerC2893g());
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.btn_search), new DialogInterfaceOnClickListenerC2894h());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.btn_cancel), new DialogInterfaceOnClickListenerC2895i());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2896j(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void O(View view, boolean z) {
        if (z) {
            x0();
        } else {
            U();
        }
    }

    public void Q(ArrayList arrayList, AutoCompleteTextView autoCompleteTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        builder.setItems(strArr, new DialogInterfaceOnClickListenerC2898l(autoCompleteTextView, strArr));
        builder.show();
    }

    public void S() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("15", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.C.size() - 1; size >= 0; size--) {
            if (this.C.valueAt(size)) {
                C4145vh item = this.A.getItem(this.C.keyAt(size));
                this.A.remove(item);
                if (this.K != 1) {
                    continue;
                } else {
                    if (C3966tX.j(this, this.e, true)) {
                        return;
                    }
                    if (this.e.I("delete from item_price_history where item_id='" + item.v() + "'", "delete from item_price where item_id='" + item.v() + "'", "delete from items where id ='" + item.v() + "'") == 0) {
                        this.e.Kd(this, getString(info.aalmoghalis.inventory.R.string.no_delete), CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
                    }
                }
            }
        }
        e0();
    }

    public boolean T(KeyEvent keyEvent, EditText editText) {
        if (keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 66) {
            return false;
        }
        new Handler().postDelayed(new C(editText.getText().toString()), 200);
        return true;
    }

    public void V() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("15", "edit")) {
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        int size = this.C.size() - 1;
        if (this.C.valueAt(size)) {
            C4145vh item = this.A.getItem(this.C.keyAt(size));
            if (this.K == 1) {
                H0(item);
            }
        }
    }

    public void W() {
        try {
            ArrayList arrayListJ3 = this.e.j3();
            this.u0 = arrayListJ3;
            RadioButton[] radioButtonArr = new RadioButton[arrayListJ3.size()];
            this.t0.setTag(null);
            this.t0.removeAllViews();
            this.t0.clearCheck();
            for (int i = 0; i < this.u0.size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButtonArr[i] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.u0.get(i)).get("name"));
                radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.u0.get(i)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i].setButtonDrawable(android.R.color.transparent);
                radioButtonArr[i].setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, android.R.drawable.btn_radio), (Drawable) null, (Drawable) null, (Drawable) null);
                radioButtonArr[i].setOnClickListener(new R());
                this.t0.addView(radioButtonArr[i]);
                String str = this.w0;
                if (str != null && str.equals(((HashMap) this.u0.get(i)).get("name"))) {
                    this.t0.check(radioButtonArr[i].getId());
                    this.t0.setTag(((HashMap) this.u0.get(i)).get("name"));
                    this.v0 = (String) ((HashMap) this.u0.get(i)).get("name");
                }
            }
            String str2 = this.w0;
            if (str2 == null || str2.equals("")) {
                this.t0.check(radioButtonArr[this.u0.size() - 1].getId());
                this.t0.setTag(radioButtonArr[this.u0.size() - 1].getText().toString());
                this.v0 = radioButtonArr[this.u0.size() - 1].getText().toString();
            }
        } catch (Exception e) {
            Log.d("fill_curr_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void X() {
        String string;
        String string2;
        Info_edit3 info_edit3 = this;
        Log.d("recCount=", info_edit3.M + ":" + info_edit3.a0.getCount());
        info_edit3.f = 0.0d;
        info_edit3.B.clear();
        info_edit3.a0.moveToFirst();
        while (!info_edit3.a0.isAfterLast()) {
            List list = info_edit3.B;
            Cursor cursor = info_edit3.a0;
            String string3 = cursor.getString(cursor.getColumnIndex("_id"));
            Cursor cursor2 = info_edit3.a0;
            String string4 = cursor2.getString(cursor2.getColumnIndex("name"));
            Cursor cursor3 = info_edit3.a0;
            String string5 = cursor3.getString(cursor3.getColumnIndex("item_type"));
            if (info_edit3.K == 1) {
                Z00 z00 = info_edit3.e;
                Cursor cursor4 = info_edit3.a0;
                string = z00.P7(String.valueOf(cursor4.getDouble(cursor4.getColumnIndex("o_qty"))));
            } else {
                Cursor cursor5 = info_edit3.a0;
                string = cursor5.getString(cursor5.getColumnIndex("o_qty"));
            }
            String str = string;
            if (info_edit3.K == 1) {
                Z00 z01 = info_edit3.e;
                Cursor cursor6 = info_edit3.a0;
                string2 = z01.P7(String.valueOf(cursor6.getDouble(cursor6.getColumnIndex("o_cost"))));
            } else {
                Cursor cursor7 = info_edit3.a0;
                string2 = cursor7.getString(cursor7.getColumnIndex("o_cost"));
            }
            String str2 = string2;
            Cursor cursor8 = info_edit3.a0;
            String string6 = cursor8.getString(cursor8.getColumnIndex("curr_name"));
            Cursor cursor9 = info_edit3.a0;
            String string7 = cursor9.getString(cursor9.getColumnIndex("o_date"));
            Cursor cursor10 = info_edit3.a0;
            String string8 = cursor10.getString(cursor10.getColumnIndex("e_date"));
            Cursor cursor11 = info_edit3.a0;
            String string9 = cursor11.getString(cursor11.getColumnIndex("pic"));
            Cursor cursor12 = info_edit3.a0;
            String string10 = cursor12.getString(cursor12.getColumnIndex("remarks"));
            Cursor cursor13 = info_edit3.a0;
            String string11 = cursor13.getString(cursor13.getColumnIndex("unit_name"));
            Cursor cursor14 = info_edit3.a0;
            String string12 = cursor14.getString(cursor14.getColumnIndex("barcode"));
            Cursor cursor15 = info_edit3.a0;
            String string13 = cursor15.getString(cursor15.getColumnIndex("unit_code"));
            Cursor cursor16 = info_edit3.a0;
            list.add(new C4145vh(string3, string4, string5, str, str2, string6, string7, string8, string9, string10, string11, string12, string13, cursor16.getString(cursor16.getColumnIndex("e_date"))));
            info_edit3 = this;
            info_edit3.a0.moveToNext();
        }
        info_edit3.a0.close();
        C0922Sv c0922Sv = new C0922Sv(info_edit3, info.aalmoghalis.inventory.R.layout.data_det_row_rep1_, info_edit3.B, -4);
        info_edit3.A = c0922Sv;
        c0922Sv.l.clear();
        info_edit3.A.notifyDataSetChanged();
        info_edit3.y.setAdapter((ListAdapter) info_edit3.A);
        F0();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    public String Z(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public String a0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (i0(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (h0(uri)) {
                        return Z(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (j0(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return Z(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return Z(context, uri, null, null);
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

    public void amount_add_btn(View view) {
        this.g0 = 0;
        if (this.K == 1) {
            n0();
        } else {
            m0();
        }
    }

    public boolean b0(String str, String str2, Context context) {
        H h = new H();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new I(h));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new J(h));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.q0;
    }

    public void barcode_click(View view) {
        if (view.getId() == info.aalmoghalis.inventory.R.id.tr_item_barcode2) {
            this.g0 = 1;
        }
        if (this.e.ia("pref_barcode_type", "1").equals("1")) {
            this.e.Td(this);
        } else {
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.usb_barcode), 0).show();
            this.g0 = 3;
        }
    }

    public boolean c0(String str, String str2, Context context) {
        K k = new K();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.confirm_yes), new L(k));
        builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.confirm_no), new M(k));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.s0;
    }

    public void d0() {
        if (this.b0 == 0) {
            this.a0 = this.e.b6(this.M);
            return;
        }
        boolean zIsEmpty = this.c0.isEmpty();
        String str = CSS.Value.PERCENTAGE;
        this.c0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.c0;
        if (!this.d0.isEmpty()) {
            str = this.d0;
        }
        this.d0 = str;
        this.a0 = this.e.c6(this.M, this.c0, str);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.g0 == 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            this.j0 += ((char) keyEvent.getUnicodeChar());
        }
        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
            String str = this.j0;
            this.j0 = "";
            this.g0 = 0;
            u0(str);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void e0() {
        B0(true);
        new Thread(new RunnableC2891e()).start();
    }

    public void import_excel(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("15", "new")) {
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        this.g0 = 0;
        Intent intent = new Intent(this, (Class<?>) Excel_add.class);
        intent.putExtra("loader_id", "1");
        startActivity(intent);
    }

    public void k0() {
        try {
            if (getIntent().getStringExtra("item_name") != null) {
                String string = getIntent().getStringExtra("item_name").toString();
                int i = 0;
                while (true) {
                    if (i >= this.y.getAdapter().getCount()) {
                        i = -1;
                        break;
                    } else if (((C4145vh) this.y.getAdapter().getItem(i)).a().equals(string)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    this.R = getIntent().getIntExtra("back_edit", 0);
                    ListView listView = this.y;
                    listView.performItemClick(listView.getAdapter().getView(i, null, null), i, this.y.getAdapter().getItemId(i));
                }
            }
        } catch (Exception e) {
            Log.d("item_name_error=", "" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void m0() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_info2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_name);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_phone);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_address);
            autoCompleteTextView.setHint(this.L);
            autoCompleteTextView.requestFocus();
            A0();
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new N());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new O());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.N);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new P(autoCompleteTextView, editText, editText2, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void n0() {
        try {
            if (C2160f10.h > 0 && !new C2160f10(this.e).l("15", "new")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_item3_, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_name);
            L(editText);
            this.e.ad(this, editText);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_qty);
            EditText editText3 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.info_cost);
            this.t0 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class_unit);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.unit_others);
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            textView.setVisibility(8);
            this.p = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_date);
            this.q = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.end_date);
            this.t = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach4);
            this.h0 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode2);
            EditText editText4 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_item_barcode_no);
            this.i0 = editText4;
            editText4.setText("");
            if (this.e.ja("prefOthers_barcode", false)) {
                this.h0.setVisibility(0);
                this.i0.setVisibility(0);
                this.i0.setText(this.e.R1());
            }
            EditText editText5 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_remaks);
            Calendar calendar = Calendar.getInstance();
            this.p.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime()));
            this.H = calendar.get(1);
            this.I = calendar.get(2);
            this.J = calendar.get(5);
            this.p.setOnClickListener(new ViewOnClickListenerC2899m());
            this.q.setOnClickListener(new ViewOnClickListenerC2900n());
            this.t.setOnClickListener(new ViewOnClickListenerC2901o());
            textView.setOnClickListener(new ViewOnClickListenerC2902p(editText));
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_group);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.unit_name);
            this.e.ad(this, editText2);
            this.e.ad(this, editText3);
            this.e.dd(this, editText5);
            this.e.bd(this, autoCompleteTextView2);
            editText.requestFocus();
            W();
            this.t0.setVisibility(8);
            ArrayList arrayListT6 = this.e.T6();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListT6);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C2903q(autoCompleteTextView, editText2));
            ArrayList arrayListC9 = this.e.c9();
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayListC9);
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C2904r(autoCompleteTextView2));
            imageView.setOnClickListener(new ViewOnClickListenerC2905s(arrayListT6, autoCompleteTextView));
            imageView2.setOnClickListener(new ViewOnClickListenerC2906t(arrayListC9, autoCompleteTextView2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC2907u());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC2910x());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            Rect rect = new Rect();
            getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            alertDialogCreate.getWindow().setLayout((int) (rect.width() * 1.0f), alertDialogCreate.getWindow().getAttributes().height);
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC2911y(editText, autoCompleteTextView, editText2, editText3, alertDialogCreate, autoCompleteTextView2, editText5));
        } catch (Exception e) {
            Log.d("add_item2_error=", e.getMessage());
        }
    }

    public void no_result_btn(View view) {
        d0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != 0) {
            try {
                if (i == this.l0 && intent != null) {
                    q0(intent.getData(), false);
                } else if (i == this.k0) {
                    o0(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            IntentResult activityResult = IntentIntegrator.parseActivityResult(i, i2, intent);
            if (activityResult != null) {
                if (activityResult.getContents() == null) {
                    Toast.makeText(this, "Cancelled", 0).show();
                } else {
                    if (this.g0 == 2) {
                        String strI6 = this.e.I6(activityResult.getContents());
                        Z00.P0 = false;
                        if (strI6.equals("")) {
                            this.e.j1(activityResult.getContents(), this, this.Q);
                        }
                        if (strI6.equals("") && !Z00.P0) {
                            return;
                        }
                        if (Z00.P0) {
                            strI6 = this.e.I6(activityResult.getContents());
                        }
                        new Handler().postDelayed(new A(strI6), 200L);
                    } else {
                        EditText editText = this.i0;
                        if (editText != null) {
                            editText.setText(activityResult.getContents());
                            String strI7 = this.e.I6(activityResult.getContents());
                            if (!strI7.equals("")) {
                                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.barcode_used) + " " + strI7, 1).show();
                            }
                        }
                    }
                    this.g0 = 0;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("barcode_log_error=", "results=" + e2.getMessage());
        }
        C0974Ur c0974Ur = this.e.x;
        if (c0974Ur == null || c0974Ur.l(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.info_list3);
        z0();
        this.e = new Z00(this.d, this);
        try {
            this.P = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f1);
            TextView textView = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f2);
            TextView textView2 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f3);
            TextView textView3 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f4);
            TextView textView4 = (TextView) findViewById(info.aalmoghalis.inventory.R.id.f5);
            if (getIntent().getIntExtra("action_type", -1) != -1) {
                this.K = getIntent().getIntExtra("action_type", -1);
                setTitle(getIntent().getStringExtra("action_text"));
                if (this.K == 1) {
                    this.L = getString(info.aalmoghalis.inventory.R.string.item);
                    this.M = "items";
                    this.N = getString(info.aalmoghalis.inventory.R.string.add_item);
                    this.O = getString(info.aalmoghalis.inventory.R.string.change_item);
                    this.P.setText(getString(info.aalmoghalis.inventory.R.string.item_name));
                    textView.setText(getString(info.aalmoghalis.inventory.R.string.item_type));
                    textView2.setText(getString(info.aalmoghalis.inventory.R.string.o_qty_));
                    textView3.setText(getString(info.aalmoghalis.inventory.R.string.o_u_cost));
                    textView4.setVisibility(8);
                    C0372Bn c0372Bn = C0372Bn.f;
                    c0372Bn.a(this, this.P);
                    c0372Bn.a(this, textView);
                    c0372Bn.a(this, textView2);
                    c0372Bn.a(this, textView3);
                    c0372Bn.a(this, textView4);
                    this.e.ld(this, this.P, this.h);
                    this.P.setOnClickListener(new ViewOnClickListenerC2897k());
                }
            }
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception e) {
            Log.d("oncreate_error=", e.getMessage() + "");
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        this.H = calendar.get(1);
        this.I = calendar.get(2);
        this.J = calendar.get(5);
        this.y = (ListView) findViewById(info.aalmoghalis.inventory.R.id.list_data);
        this.y.setEmptyView((TextView) findViewById(info.aalmoghalis.inventory.R.id.emptyResults));
        this.y.setOnItemClickListener(new C2908v());
        this.y.setChoiceMode(2);
        this.e.w0("PRAGMA foreign_keys = ON");
        if (this.e.ja("prefOthers_barcode", false)) {
            C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, this.e.G6(), 4);
            this.Q = c1098Yv;
            c1098Yv.l.clear();
            this.Q.notifyDataSetChanged();
        }
        try {
            d0();
            X();
        } catch (Exception unused) {
        }
        this.y.setChoiceMode(3);
        this.y.setMultiChoiceModeListener(new C2909w());
        k0();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(g0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.S, this.H, this.I, this.J);
        }
        if (i == 1) {
            return new DatePickerDialog(g0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.T, this.H, this.I, this.J);
        }
        if (i == 3) {
            return new DatePickerDialog(g0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.U, this.H, this.I, this.J);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(g0() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.V, this.H, this.I, this.J);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu != null) {
            menu.clear();
        }
        MenuInflater menuInflater = getMenuInflater();
        if (this.K != 1) {
            menuInflater.inflate(info.aalmoghalis.inventory.R.menu.menu_search, menu);
        } else if (this.e.ja("prefOthers_barcode", false)) {
            menuInflater.inflate(info.aalmoghalis.inventory.R.menu.menu_main3_group_general_barcode, menu);
        } else {
            menuInflater.inflate(info.aalmoghalis.inventory.R.menu.menu_main3_group_general_, menu);
        }
        this.W = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        this.W.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.W.setQueryHint(getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.W.setOnQueryTextListener(new m0());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == info.aalmoghalis.inventory.R.id.print) {
            try {
                this.X = getTitle().toString();
                t0();
            } catch (Exception unused) {
            }
            return true;
        }
        if (menuItem.getItemId() == info.aalmoghalis.inventory.R.id.adv_search) {
            M();
            return true;
        }
        if (menuItem.getItemId() != info.aalmoghalis.inventory.R.id.barcode_img) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.e.ia("pref_barcode_type", "1").equals("1")) {
            this.g0 = 2;
            this.e.Td(this);
        } else {
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.usb_barcode), 0).show();
            this.g0 = 4;
        }
        return true;
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.t0.setTag(radioButton.getText().toString());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            N(getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        d0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FragmentStatePagerSupport_Main.Z(this);
        if (x0) {
            x0 = false;
            recreate();
        }
    }

    public void p0(String str) {
        C0922Sv c0922Sv = this.A;
        if (c0922Sv != null) {
            c0922Sv.getFilter().filter(str);
        }
    }

    public void r0(C4145vh c4145vh) {
        Intent intent = new Intent(this, (Class<?>) Barcode_add.class);
        intent.putExtra("item_id", c4145vh.v());
        intent.putExtra("item_name", c4145vh.a());
        intent.putExtra("item_barcode", c4145vh.c());
        startActivity(intent);
    }

    public void s0(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) Unit_item_edit.class);
        intent.putExtra("item_name", str);
        intent.putExtra("action_type", str2);
        intent.putExtra("title_", getString(info.aalmoghalis.inventory.R.string.unit_item));
        startActivity(intent);
    }

    public void sort_remarks_click(View view) {
        if (this.h == 0) {
            C0(this.B);
            this.h = 1;
        } else {
            w0(this.B);
            this.h = 0;
        }
    }

    public void t0() {
        B0(true);
        new Thread(new RunnableC2887a()).start();
    }

    public void u0(String str) {
        EditText editText;
        if (!str.equals("") && this.e.da(str)) {
            EditText editText2 = this.i0;
            if (editText2 != null && editText2.hasWindowFocus()) {
                this.i0.setText(str);
                String strI6 = this.e.I6(str);
                if (!strI6.equals("")) {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.barcode_used) + " " + strI6, 1).show();
                }
            } else if (this.g0 == 4 || (editText = this.i0) == null || !editText.hasWindowFocus()) {
                String strI7 = this.e.I6(str);
                Z00.P0 = false;
                if (strI7.equals("")) {
                    this.e.j1(str, this, this.Q);
                }
                if (strI7.equals("") && !Z00.P0) {
                    return;
                }
                if (Z00.P0) {
                    strI7 = this.e.I6(str);
                }
                new Handler().postDelayed(new D(strI7), 200L);
            }
            this.g0 = 0;
        }
    }

    public final void w0(List list) {
        Collections.sort(list, Collections.reverseOrder(new C2890d()));
    }

    public void y0(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            this.t.getLayoutParams().width = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width2);
            this.t.getLayoutParams().height = (int) getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height2);
            this.t.setImageBitmap(bitmapP0);
            this.t.setTag(str);
        } catch (Exception unused) {
        }
    }
}
