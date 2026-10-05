package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.helper.Calculator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class K5 extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<C4064uh>> {
    public static double I1;
    public ImageView A0;
    public int A1;
    public ImageView B0;
    public int B1;
    public int C;
    public View.OnClickListener C0;
    public String C1;
    public int D;
    public boolean D0;
    public ActivityResultLauncher D1;
    public SQLiteDatabase E;
    public boolean E0;
    public ActivityResultLauncher E1;
    public Z00 F;
    public int F0;
    public Uri F1;
    public String G0;
    public String G1;
    public P0 H;
    public Snackbar H0;
    public boolean H1;
    public int I0;
    public int J0;
    public String K0;
    public String L0;
    public Boolean M;
    public TextView M0;
    public Boolean N;
    public TextView N0;
    public TextView O;
    public TextView O0;
    public ImageView P;
    public TextView P0;
    public ImageView Q;
    public AutoCompleteTextView Q0;
    public ImageView R;
    public AutoCompleteTextView R0;
    public ImageView S;
    public EditText S0;
    public ImageView T;
    public TextView T0;
    public TextView U;
    public TextView U0;
    public TextView V;
    public AutoCompleteTextView V0;
    public TextView W;
    public AutoCompleteTextView W0;
    public TextView X;
    public Button X0;
    public TextView Y;
    public Button Y0;
    public C0783Nv Z;
    public Button Z0;
    public ListView a0;
    public ImageView a1;
    public SparseBooleanArray b0;
    public ImageView b1;
    public int c0;
    public RadioGroup c1;
    public int d0;
    public RadioButton d1;
    public int e0;
    public RadioButton e1;
    public int f0;
    public LinearLayout f1;
    public String[] g0;
    public LinearLayout g1;
    public TypedArray h0;
    public LinearLayout h1;
    public List i0;
    public LinearLayout i1;
    public C4062ug j0;
    public LinearLayout j1;
    public int[] k0;
    public LinearLayout k1;
    public LinearLayout l0;
    public RadioGroup l1;
    public LoaderManager.LoaderCallbacks m0;
    public ArrayList m1;
    public String n0;
    public ArrayAdapter n1;
    public String o0;
    public String[] o1;
    public String p0;
    public DatePickerDialog.OnDateSetListener p1;
    public String q0;
    public DatePickerDialog.OnDateSetListener q1;
    public String r0;
    public DatePickerDialog.OnDateSetListener r1;
    public int s0;
    public DatePickerDialog.OnDateSetListener s1;
    public String t0;
    public Dialog t1;
    public String u0;
    public Handler u1;
    public String[] v0;
    public String v1;
    public TypedArray w0;
    public Cursor w1;
    public SwipeRefreshLayout x0;
    public ArrayList x1;
    public Activity y0;
    public EditText y1;
    public int z0;
    public EditText z1;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public int n = 0;
    public String p = null;
    public String q = null;
    public String t = null;
    public String u = null;
    public int v = 0;
    public String w = null;
    public String x = null;
    public String y = null;
    public String z = null;
    public List A = new ArrayList();
    public String B = null;
    public String[] G = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public boolean I = false;
    public String J = "";
    public int K = 0;
    public boolean L = false;

    public class A implements DialogInterface.OnClickListener {
        public A() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Cursor cursorO3;
            try {
                if (Build.VERSION.SDK_INT < 31) {
                    K5.this.x();
                }
                if (K5.this.P0.getText() != null && !K5.this.P0.getText().toString().isEmpty()) {
                    K5 k5 = K5.this;
                    k5.L0 = k5.P0.getText().toString();
                    K5 k6 = K5.this;
                    k6.J0 = 1;
                    boolean z = Z00.Z;
                    String str = CSS.Value.PERCENTAGE;
                    if (z) {
                        k6.K0 = k6.K0.isEmpty() ? CSS.Value.PERCENTAGE : K5.this.K0;
                        K5 k7 = K5.this;
                        if (!k7.L0.isEmpty()) {
                            str = K5.this.L0;
                        }
                        k7.L0 = str;
                        K5 k8 = K5.this;
                        cursorO3 = k8.F.O3(k8.g, k8.K0, k8.L0, k8.j, -1, -1, k8.J0, 0, "");
                    } else {
                        k6.K0 = k6.K0.isEmpty() ? CSS.Value.PERCENTAGE : K5.this.K0;
                        K5 k9 = K5.this;
                        if (!k9.L0.isEmpty()) {
                            str = K5.this.L0;
                        }
                        k9.L0 = str;
                        K5 k10 = K5.this;
                        cursorO3 = k10.F.M3(k10.g, k10.K0, k10.L0);
                    }
                    if (cursorO3.getCount() == 0) {
                        cursorO3.close();
                        Toast.makeText(K5.this.getActivity(), "No data found.", 1).show();
                        return;
                    }
                    cursorO3.close();
                    new DateFormat();
                    if (Z00.Z) {
                        K5 k11 = K5.this;
                        Z00 z00 = k11.F;
                        ListView listView = k11.a0;
                        StringBuilder sb = new StringBuilder();
                        sb.append(K5.this.P0.getText().toString());
                        sb.append("-");
                        K5 k12 = K5.this;
                        sb.append(k12.F.ic(k12.h));
                        sb.append("-");
                        sb.append(K5.this.j);
                        String string = sb.toString();
                        K5 k13 = K5.this;
                        double dO0 = k13.o0(k13.Z.d);
                        K5 k14 = K5.this;
                        z00.ab(listView, string, dO0, k14.j, k14.K0, k14.L0, k14.F.ic(k14.h));
                    } else {
                        K5 k15 = K5.this;
                        Z00 z01 = k15.F;
                        ListView listView2 = k15.a0;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(K5.this.P0.getText().toString());
                        sb2.append("-");
                        K5 k16 = K5.this;
                        sb2.append(k16.F.ic(k16.h));
                        String string2 = sb2.toString();
                        K5 k17 = K5.this;
                        z01.Xa(listView2, string2, k17.o0(k17.Z.d));
                    }
                    K5 k18 = K5.this;
                    k18.F.X(k18.g, K5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.action_settings8) + "-" + K5.this.P0.getText().toString(), K5.this.P0.getText().toString(), !Z00.Z ? "" : K5.this.j);
                    K5 k19 = K5.this;
                    k19.J0 = 0;
                    k19.m0();
                    FragmentStatePagerSupport_Main.a0 = true;
                    FragmentActivity activity = K5.this.getActivity();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(K5.this.P0.getText().toString());
                    sb3.append("-");
                    K5 k20 = K5.this;
                    sb3.append(k20.F.ic(k20.h));
                    sb3.append(".pdf");
                    Toast.makeText(activity, sb3.toString(), 1).show();
                    return;
                }
                Toast.makeText(K5.this.getActivity(), "Closing date is required.", 1).show();
            } catch (Exception unused) {
                Toast.makeText(K5.this.getActivity(), "SQL Error.", 1);
            }
        }
    }

    public class A0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public A0(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    public class B0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ Dialog b;

        public B0(TextView textView, Dialog dialog) {
            this.a = textView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            if (this.a.getId() == K5.this.M0.getId()) {
                K5.this.h = this.a.getText().toString();
                K5 k5 = K5.this;
                String str = k5.h;
                FragmentStatePagerSupport.L = str;
                k5.g = k5.F.q4(str).i();
                K5 k6 = K5.this;
                FragmentStatePagerSupport.D = k6.g;
                k6.getActivity().setTitle(K5.this.h + "#" + K5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.cash_tran));
            } else if (this.a.getId() == K5.this.O0.getId()) {
                K5.this.j = this.a.getText().toString();
                FragmentStatePagerSupport.G = K5.this.j;
            }
            this.b.dismiss();
        }
    }

    public class C implements DialogInterface.OnClickListener {
        public final /* synthetic */ ImageView a;

        public C(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                K5.this.F.qa(Z00.M + this.a.getTag().toString());
            } catch (Exception unused) {
                Toast.makeText(K5.this.getActivity(), "SQL Error.", 1);
            }
        }
    }

    public class C0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public C0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class D implements DialogInterface.OnClickListener {
        public D() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                int i2 = K5.this.x.equals("") ? 0 : Integer.parseInt(K5.this.x);
                if (i2 > 0) {
                    K5 k5 = K5.this;
                    k5.F.n9(k5.x, k5.getActivity(), 1);
                    return;
                }
                if (i2 == -2) {
                    Bill_edit.R2 = K5.this.h;
                    String strI = new C2160f10(K5.this.F).I(K5.this.n + "");
                    K5 k6 = K5.this;
                    Z00 z00 = k6.F;
                    String strQ8 = z00.Q8(k6.n);
                    K5 k7 = K5.this;
                    z00.r9(strQ8, k7.F.P8(k7.n), strI, K5.this.getActivity());
                    return;
                }
                if (i2 == -3) {
                    Bill_edit.R2 = K5.this.h;
                    String strI2 = new C2160f10(K5.this.F).I(K5.this.n + "");
                    K5 k8 = K5.this;
                    Z00 z01 = k8.F;
                    String strQ9 = z01.Q8(k8.n);
                    K5 k9 = K5.this;
                    String strH8 = k9.F.H8(k9.n);
                    K5 k10 = K5.this;
                    z01.s9(strQ9, strH8, k10.F.P8(k10.n), strI2, K5.this.getActivity());
                    return;
                }
                if (i2 == -6) {
                    Bill_edit.R2 = K5.this.h;
                    String strI3 = new C2160f10(K5.this.F).I(K5.this.n + "");
                    K5 k11 = K5.this;
                    Z00 z02 = k11.F;
                    String strQ10 = z02.Q8(k11.n);
                    K5 k12 = K5.this;
                    String strH9 = k12.F.H8(k12.n);
                    K5 k13 = K5.this;
                    z02.p9(strQ10, strH9, k13.F.P8(k13.n), strI3, K5.this.getActivity());
                    return;
                }
                if (i2 == -4) {
                    K5.this.F.t9(K5.this.n + "", K5.this.getActivity());
                    return;
                }
                K5 k14 = K5.this;
                if (k14.F.O8(k14.n).equals("0")) {
                    K5.this.X(false);
                    return;
                }
                K5 k15 = K5.this;
                k15.t = k15.F.R8(k15.n);
                K5 k16 = K5.this;
                k16.z = k16.h;
                k16.y = k16.F.T8(k16.n);
                K5 k17 = K5.this;
                if (k17.y.equals(k17.h)) {
                    K5 k18 = K5.this;
                    k18.z = k18.F.N8(k18.n);
                }
                K5.this.Y(false);
            } catch (Exception e) {
                Log.d("View_item_error=", e.getMessage());
            }
        }
    }

    public class D0 implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public D0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class E0 implements View.OnClickListener {
        public E0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.C0(view);
        }
    }

    public class F implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public F(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5 k5 = K5.this;
            if (k5.A(k5.Y0.getId())) {
                this.a.dismiss();
                K5.this.m0();
                if (K5.this.A.size() > 0) {
                    K5.this.W0();
                }
            }
        }
    }

    public class F0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public F0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.M(this.a, this.b);
        }
    }

    public class G implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public G(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5 k5 = K5.this;
            if (k5.A(k5.Z0.getId())) {
                this.a.dismiss();
                K5.this.m0();
                if (K5.this.A.size() > 0) {
                    K5.this.W0();
                }
            }
        }
    }

    public class G0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public G0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            K5.this.D0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class H implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public H(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (K5.this.C()) {
                this.a.dismiss();
                K5.this.m0();
            }
        }
    }

    public class I implements View.OnClickListener {
        public I() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.calc_pick_btn(view);
        }
    }

    public class J implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public J(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.z(view, this.a);
        }
    }

    public class J0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ AlertDialog e;

        public J0(EditText editText, AutoCompleteTextView autoCompleteTextView, String str, EditText editText2, AlertDialog alertDialog) {
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
            if (K5.this.F.P5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                K5.this.G1 = this.b.getText().toString();
                K5 k5 = K5.this;
                k5.j0(k5.getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_group), K5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + K5.this.G1, K5.this.getActivity());
                if (!K5.this.D0) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    K5.this.F.v0("update customers set name='" + this.d.getText().toString() + "',gsm='" + this.a.getText().toString() + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + K5.this.g + "'");
                    K5.this.l = this.a.getText().toString();
                    K5 k6 = K5.this;
                    int i = k6.I0;
                    if (i == 1) {
                        k6.F.n0(this.a.getText().toString());
                    } else if (i == 2) {
                        Z00 z00 = k6.F;
                        String string = this.a.getText().toString();
                        K5 k7 = K5.this;
                        z00.Rc(string, k7.F.ud(k7.a0, k7.h, k7.o0(k7.Z.d)));
                    } else if (i == 3) {
                        Z00 z01 = k6.F;
                        String string2 = this.a.getText().toString();
                        K5 k8 = K5.this;
                        Z00 z02 = k8.F;
                        C4064uh c4064uhC0 = k8.c0();
                        K5 k9 = K5.this;
                        z01.Rc(string2, z02.zd(c4064uhC0, k9.h, k9.o0(k9.Z.d)));
                    } else if (i == 4) {
                        Z00 z03 = k6.F;
                        String string3 = this.a.getText().toString();
                        K5 k10 = K5.this;
                        Z00 z04 = k10.F;
                        C4064uh c4064uhC1 = k10.c0();
                        K5 k11 = K5.this;
                        z03.Ed(string3, z04.zd(c4064uhC1, k11.h, k11.o0(k11.Z.d)));
                    } else if (i == 5) {
                        k6.O0(2);
                    } else {
                        k6.F.Rc(this.a.getText().toString(), K5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.sms_header) + K5.this.k);
                    }
                }
                this.e.dismiss();
            }
        }
    }

    public class K implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public K(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (K5.this.D()) {
                this.a.dismiss();
                K5.this.m0();
            }
        }
    }

    public class K0 extends Handler {
        public K0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class L implements View.OnClickListener {
        public L() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.calc_pick_btn(view);
        }
    }

    public class L0 implements Comparator {
        public L0() {
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

        public /* synthetic */ L0(K5 k5, C0661k c0661k) {
            this();
        }
    }

    public class M implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public M(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.z(view, this.a);
        }
    }

    public class M0 implements Comparator {
        public M0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                int iCompareTo = simpleDateFormat.parse(c4064uh2.p()).compareTo(simpleDateFormat.parse(c4064uh.p()));
                return iCompareTo == 0 ? Integer.valueOf(c4064uh2.q()).compareTo(Integer.valueOf(c4064uh.q())) : iCompareTo;
            } catch (ParseException unused) {
                return 0;
            }
        }

        public /* synthetic */ M0(K5 k5, C0661k c0661k) {
            this();
        }
    }

    public class N implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public N(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (K5.this.B()) {
                K5 k5 = K5.this;
                if (k5.I) {
                    k5.u0();
                    K5.this.m0();
                    return;
                }
                this.a.dismiss();
                K5.this.m0();
                if (K5.this.A.size() > 0) {
                    K5.this.W0();
                }
            }
        }
    }

    public class N0 implements Comparator {
        public N0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return Double.valueOf(c4064uh.f().replaceAll(",", "")).compareTo(Double.valueOf(c4064uh2.f().replaceAll(",", "")));
        }

        public /* synthetic */ N0(K5 k5, C0661k c0661k) {
            this();
        }
    }

    public class O implements View.OnClickListener {
        public O() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.calc_pick_btn(view);
        }
    }

    public class O0 implements Comparator {
        public O0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return Double.valueOf(c4064uh2.f().replaceAll(",", "")).compareTo(Double.valueOf(c4064uh.f().replaceAll(",", "")));
        }

        public /* synthetic */ O0(K5 k5, C0661k c0661k) {
            this();
        }
    }

    public class P implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public P(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.z(view, this.a);
        }
    }

    public interface P0 {
        void onButtonClicked(View view);
    }

    public class Q implements AdapterView.OnItemClickListener {
        public Q() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                TextView textView = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.tr_id);
                K5.this.n = Integer.parseInt(textView.getText().toString());
                K5.this.t = textView.getTag() != null ? textView.getTag().toString() : "";
                TextView textView2 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.tr_date);
                K5.this.p = textView2.getText().toString();
                K5.this.x = textView2.getTag() != null ? textView2.getTag().toString() : "";
                TextView textView3 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.tr_amount);
                K5.this.q = textView3.getText().toString();
                K5.this.w = textView3.getTag() != null ? textView3.getTag().toString() : "";
                TextView textView4 = (TextView) view.findViewById(info.aalmoghalis.inventory.R.id.tr_remarks);
                K5.this.u = textView4.getTag() != null ? textView4.getTag().toString() : "";
                K5.this.v = Integer.parseInt(((ImageView) view.findViewById(info.aalmoghalis.inventory.R.id.img)).getTag().toString());
                K5.this.l1();
            } catch (Exception unused) {
            }
        }
    }

    public class Q0 implements Comparator {
        public Q0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return Double.valueOf(c4064uh.n().replaceAll(",", "")).compareTo(Double.valueOf(c4064uh2.n().replaceAll(",", "")));
        }

        public /* synthetic */ Q0(K5 k5, C0661k c0661k) {
            this();
        }
    }

    public class R implements View.OnClickListener {
        public R() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.A0(view);
        }
    }

    public class R0 implements Comparator {
        public R0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return Double.valueOf(c4064uh2.n().replaceAll(",", "")).compareTo(Double.valueOf(c4064uh.n().replaceAll(",", "")));
        }

        public /* synthetic */ R0(K5 k5, C0661k c0661k) {
            this();
        }
    }

    public class S implements DatePickerDialog.OnDateSetListener {
        public S() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + i;
            Locale locale = Locale.ENGLISH;
            try {
                K5.this.T0.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public class T implements DatePickerDialog.OnDateSetListener {
        public T() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                K5.this.M0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                K5 k5 = K5.this;
                k5.K0 = k5.M0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public class U implements DatePickerDialog.OnDateSetListener {
        public U() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                K5.this.N0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                K5 k5 = K5.this;
                k5.L0 = k5.N0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public class V implements DatePickerDialog.OnDateSetListener {
        public V() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                K5.this.P0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public class W implements View.OnClickListener {
        public W() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", K5.this.d0);
                bundle.putInt("month", K5.this.e0);
                bundle.putInt("day", K5.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(K5.this.p1);
                c2137ei.show(K5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(K5.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    public class X implements View.OnClickListener {
        public X() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", K5.this.d0);
                bundle.putInt("month", K5.this.e0);
                bundle.putInt("day", K5.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(K5.this.p1);
                c2137ei.show(K5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Log.d("Date error=", e.getMessage());
            }
        }
    }

    public class Y implements AdapterView.OnItemClickListener {
        public Y() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            K5.this.Q0.setText(adapterView.getItemAtPosition(i).toString());
            K5.this.R0.requestFocus();
            K5.this.G0();
        }
    }

    public class Z implements AdapterView.OnItemClickListener {
        public Z() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            K5.this.R0.setText(adapterView.getItemAtPosition(i).toString());
            K5.this.S0.requestFocus();
            K5.this.G0();
        }
    }

    /* JADX INFO: renamed from: K5$a, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0641a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC0641a(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            K5.this.t(this.a);
            K5 k5 = K5.this;
            k5.E0 = k5.D0;
        }
    }

    /* JADX INFO: renamed from: K5$a0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0642a0 implements View.OnClickListener {
        public ViewOnClickListenerC0642a0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_add_amount) {
                K5.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_fwd_amount) {
                K5.this.w(view);
                return;
            }
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_call) {
                K5.this.F(view);
                return;
            }
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_help) {
                K5.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                K5.this.w0(view);
            } else if (view.getId() == info.aalmoghalis.inventory.R.id.move_left || view.getId() == info.aalmoghalis.inventory.R.id.move_right) {
                K5.this.H.onButtonClicked(view);
            }
        }
    }

    /* JADX INFO: renamed from: K5$b, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0643b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC0643b(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            K5.this.E0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: K5$b0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC0644b0 implements View.OnTouchListener {
        public ViewOnTouchListenerC0644b0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            K5.this.Q0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (K5.this.Q0.getCompoundDrawables()[0] != null ? K5.this.Q0.getCompoundDrawables()[0].getBounds().width() : 0) + K5.this.Q0.getPaddingLeft() + K5.this.Q0.getLeft()) {
                    K5.this.Q0.setText("");
                    K5.this.Q0.requestFocus();
                    K5.this.G0();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: K5$c, reason: case insensitive filesystem */
    public class C0645c implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C0645c(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: K5$d, reason: case insensitive filesystem */
    public class C0647d implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C0647d(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: K5$d0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC0648d0 implements View.OnTouchListener {
        public ViewOnTouchListenerC0648d0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            K5.this.R0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (K5.this.R0.getCompoundDrawables()[0] != null ? K5.this.R0.getCompoundDrawables()[0].getBounds().width() : 0) + K5.this.R0.getPaddingLeft() + K5.this.R0.getLeft()) {
                    K5.this.R0.setText("");
                    K5.this.R0.requestFocus();
                    K5.this.G0();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: K5$e, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0649e implements View.OnClickListener {
        public ViewOnClickListenerC0649e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.C0(view);
        }
    }

    /* JADX INFO: renamed from: K5$f, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0651f implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC0651f(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5 k5 = K5.this;
            k5.F.Md(k5.getActivity());
            K5.this.N(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: K5$g, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0653g implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC0653g(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5 k5 = K5.this;
            k5.F.Md(k5.getActivity());
            K5.this.N(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: K5$g0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0654g0 implements View.OnClickListener {
        public ViewOnClickListenerC0654g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", K5.this.d0);
                bundle.putInt("month", K5.this.e0);
                bundle.putInt("day", K5.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(K5.this.p1);
                c2137ei.show(K5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(K5.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: K5$h0, reason: case insensitive filesystem */
    public class C0656h0 implements Comparator {
        public C0656h0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return String.valueOf(c4064uh2.t()).compareTo(String.valueOf(c4064uh.t()));
        }
    }

    /* JADX INFO: renamed from: K5$i0, reason: case insensitive filesystem */
    public class C0658i0 implements Comparator {
        public C0658i0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return String.valueOf(c4064uh.t()).compareTo(String.valueOf(c4064uh2.t()));
        }
    }

    /* JADX INFO: renamed from: K5$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0659j implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ Handler h;

        public ViewOnClickListenerC0659j(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, AlertDialog alertDialog, EditText editText2, EditText editText3, Handler handler) {
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
            if (K5.this.F.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(K5.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (K5.this.F.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                K5.this.G1 = this.b.getText().toString();
                K5 k5 = K5.this;
                k5.j0(k5.getString(info.aalmoghalis.inventory.R.string.validation_add_group), K5.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + K5.this.G1, K5.this.getActivity());
                if (!K5.this.D0) {
                    return;
                }
            }
            if (z) {
                int iR1 = K5.this.F.r1(this.c.getText().toString());
                if (this.d.equals("0")) {
                    if (K5.this.F.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        FragmentStatePagerSupport_Main.Z(K5.this.getActivity());
                        this.e.dismiss();
                        return;
                    }
                    K5.this.F.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.f.getText().toString() + "','" + this.g.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                    Handler handler = this.h;
                    handler.sendMessage(handler.obtainMessage());
                } else if (this.d != null) {
                    K5.this.F.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.f.getText().toString() + "',address='" + this.g.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + K5.this.g + "' and id>0 ");
                    Handler handler2 = this.h;
                    handler2.sendMessage(handler2.obtainMessage());
                }
                this.e.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: K5$j0, reason: case insensitive filesystem */
    public class C0660j0 implements Comparator {
        public C0660j0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return String.valueOf(c4064uh2.r()).compareTo(String.valueOf(c4064uh.r()));
        }
    }

    /* JADX INFO: renamed from: K5$k0, reason: case insensitive filesystem */
    public class C0662k0 implements Comparator {
        public C0662k0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return String.valueOf(c4064uh.r()).compareTo(String.valueOf(c4064uh2.r()));
        }
    }

    /* JADX INFO: renamed from: K5$l, reason: case insensitive filesystem */
    public class C0663l implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: K5$l$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                K5.this.F0();
                K5.this.x0.setRefreshing(false);
            }
        }

        public C0663l() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            new Handler().post(new a());
        }
    }

    /* JADX INFO: renamed from: K5$l0, reason: case insensitive filesystem */
    public class HandlerC0664l0 extends Handler {
        public HandlerC0664l0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: K5$m, reason: case insensitive filesystem */
    public class C0665m implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ EditText c;

        public C0665m(AutoCompleteTextView autoCompleteTextView, Dialog dialog, EditText editText) {
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
                    K5 k5 = K5.this;
                    k5.F.Md(k5.getActivity());
                }
            }
        }
    }

    /* JADX INFO: renamed from: K5$m0, reason: case insensitive filesystem */
    public class RunnableC0666m0 implements Runnable {
        public final /* synthetic */ int a;

        public RunnableC0666m0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i == 0) {
                K5.this.E();
                K5.this.Z.notifyDataSetChanged();
                K5 k5 = K5.this;
                if (k5.J0 == 1) {
                    k5.k1();
                    return;
                }
                return;
            }
            if (i == 1) {
                K5.this.E();
                K5.this.k1();
            } else if (i == 4) {
                K5.this.S0.selectAll();
            }
        }
    }

    /* JADX INFO: renamed from: K5$n, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0667n implements View.OnClickListener {
        public ViewOnClickListenerC0667n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.H0.dismiss();
        }
    }

    /* JADX INFO: renamed from: K5$n0, reason: case insensitive filesystem */
    public class HandlerC0668n0 extends Handler {
        public HandlerC0668n0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                K5 k5 = K5.this;
                k5.b0(k5.w1);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = K5.this.F;
                StringBuilder sb = new StringBuilder();
                K5 k6 = K5.this;
                sb.append(k6.F.ic(k6.v1));
                sb.append(".pdf");
                z00.ra(sb.toString());
            } else if (message.obj.toString().equals("2")) {
                Z00 z01 = K5.this.F;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(K5.this.F.ic(K5.this.h + "-" + K5.this.j));
                sb2.append(".pdf");
                z01.ra(sb2.toString());
            } else if (message.obj.toString().equals("4")) {
                Z00 z02 = K5.this.F;
                StringBuilder sb3 = new StringBuilder();
                K5 k7 = K5.this;
                sb3.append(k7.F.ic(k7.h));
                sb3.append(".pdf");
                z02.ra(sb3.toString());
            }
            K5.this.V0(false);
        }
    }

    /* JADX INFO: renamed from: K5$o, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0669o implements View.OnClickListener {
        public ViewOnClickListenerC0669o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5.this.R0();
        }
    }

    /* JADX INFO: renamed from: K5$o0, reason: case insensitive filesystem */
    public class RunnableC0670o0 implements Runnable {
        public RunnableC0670o0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            K5 k5 = K5.this;
            k5.v1 = k5.F.ic(k5.h);
            C3357m10 c3357m10 = new C3357m10(K5.this.getActivity(), K5.this.F);
            K5 k6 = K5.this;
            c3357m10.k(k6.v1, k6.h, k6.K0, k6.L0, k6.j);
            Message message = new Message();
            message.obj = "1";
            K5.this.u1.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: K5$p, reason: case insensitive filesystem */
    public class RunnableC0671p implements Runnable {
        public RunnableC0671p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            K5.this.H0.dismiss();
        }
    }

    /* JADX INFO: renamed from: K5$p0, reason: case insensitive filesystem */
    public class RunnableC0672p0 implements Runnable {
        public RunnableC0672p0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            K5.this.l0();
            Message message = new Message();
            message.obj = "0";
            K5.this.u1.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: K5$q, reason: case insensitive filesystem */
    public class C0673q implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C0673q(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) throws Throwable {
            if (K5.this.F.ja("prefPrintSort", true)) {
                K5 k5 = K5.this;
                k5.Y0(k5.A);
                K5.this.Z.notifyDataSetChanged();
                K5.this.c0 = 1;
            }
            try {
                if (i != 0) {
                    if (i == 1) {
                        if (Build.VERSION.SDK_INT < 31) {
                            K5.this.x();
                        }
                        if (K5.this.a0.getCount() > 100) {
                            Toast.makeText(K5.this.getActivity(), "Share PDF as the data is too long!", 1).show();
                            return;
                        }
                        K5 k6 = K5.this;
                        K5.this.F.Wd(k6.F.f1(k6.a0, k6.l0), "cus_details.jpg");
                        K5.this.F.rd("cus_details.jpg");
                        this.a.dismiss();
                        return;
                    }
                    if (i == 2) {
                        K5 k7 = K5.this;
                        k7.I0 = 2;
                        String str = k7.l;
                        if (str == null || str.length() < 3) {
                            K5 k8 = K5.this;
                            k8.i1(k8.g, k8.h, k8.l, k8.i);
                        } else {
                            K5 k9 = K5.this;
                            Z00 z00 = k9.F;
                            z00.Rc(k9.l, z00.ud(k9.a0, k9.h, k9.o0(k9.Z.d)));
                        }
                        this.a.dismiss();
                        return;
                    }
                    if (i == 3) {
                        if (Build.VERSION.SDK_INT < 31) {
                            K5.this.x();
                        }
                        K5 k10 = K5.this;
                        Z00 z01 = k10.F;
                        ListView listView = k10.a0;
                        String strIc = z01.ic(k10.h);
                        K5 k11 = K5.this;
                        double dO0 = k11.o0(k11.Z.d);
                        K5 k12 = K5.this;
                        z01.Oa(listView, strIc, dO0, k12.j, k12.K0, k12.L0);
                        Z00 z02 = K5.this.F;
                        StringBuilder sb = new StringBuilder();
                        K5 k13 = K5.this;
                        sb.append(k13.F.ic(k13.h));
                        sb.append(".xls");
                        z02.pd(sb.toString());
                        this.a.dismiss();
                        return;
                    }
                    return;
                }
                if (Build.VERSION.SDK_INT < 31) {
                    K5.this.x();
                }
                if (!Z00.Z) {
                    K5 k14 = K5.this;
                    Z00 z03 = k14.F;
                    ListView listView2 = k14.a0;
                    String strIc2 = z03.ic(k14.h);
                    K5 k15 = K5.this;
                    z03.Xa(listView2, strIc2, k15.o0(k15.Z.d));
                    Z00 z04 = K5.this.F;
                    StringBuilder sb2 = new StringBuilder();
                    K5 k16 = K5.this;
                    sb2.append(k16.F.ic(k16.h));
                    sb2.append(".pdf");
                    z04.sd(sb2.toString());
                } else if (K5.this.F.ja("pref_print_all_curr", false)) {
                    K5 k17 = K5.this;
                    Z00 z05 = k17.F;
                    String strIc3 = z05.ic(k17.h);
                    K5 k18 = K5.this;
                    z05.nb(strIc3, k18.g, k18.K0, k18.L0, k18.F.ic(k18.h));
                    Z00 z06 = K5.this.F;
                    StringBuilder sb3 = new StringBuilder();
                    K5 k19 = K5.this;
                    sb3.append(k19.F.ic(k19.h));
                    sb3.append(".pdf");
                    z06.sd(sb3.toString());
                } else {
                    K5 k20 = K5.this;
                    Z00 z07 = k20.F;
                    ListView listView3 = k20.a0;
                    String strIc4 = z07.ic(K5.this.h + "-" + K5.this.j);
                    K5 k21 = K5.this;
                    double dO1 = k21.o0(k21.Z.d);
                    K5 k22 = K5.this;
                    z07.ab(listView3, strIc4, dO1, k22.j, k22.K0, k22.L0, k22.F.ic(k22.h));
                    Z00 z08 = K5.this.F;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(K5.this.F.ic(K5.this.h + "-" + K5.this.j));
                    sb4.append(".pdf");
                    z08.sd(sb4.toString());
                }
                this.a.dismiss();
            } catch (Exception e) {
                Log.d("share_err", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: K5$q0, reason: case insensitive filesystem */
    public class RunnableC0674q0 implements Runnable {
        public RunnableC0674q0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            K5 k5 = K5.this;
            Z00 z00 = k5.F;
            ListView listView = k5.a0;
            String strIc = z00.ic(K5.this.h + "-" + K5.this.j);
            K5 k6 = K5.this;
            double dO0 = k6.o0(k6.Z.d);
            K5 k7 = K5.this;
            z00.ab(listView, strIc, dO0, k7.j, k7.K0, k7.L0, k7.F.ic(k7.h));
            K5.this.F.Rd(200);
            Message message = new Message();
            message.obj = "2";
            K5.this.u1.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: K5$r, reason: case insensitive filesystem */
    public class C0675r implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C0675r(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (i == 0) {
                K5 k5 = K5.this;
                k5.I0 = 4;
                String str = k5.l;
                if (str == null || str.length() < 3) {
                    K5 k6 = K5.this;
                    k6.i1(k6.g, k6.h, k6.l, k6.i);
                } else {
                    K5 k7 = K5.this;
                    Z00 z00 = k7.F;
                    String str2 = k7.l;
                    C4064uh c4064uhC0 = k7.c0();
                    K5 k8 = K5.this;
                    z00.Ed(str2, z00.zd(c4064uhC0, k8.h, k8.o0(k8.Z.d)));
                }
            } else if (i == 1) {
                K5 k9 = K5.this;
                k9.I0 = 3;
                String str3 = k9.l;
                if (str3 == null || str3.length() < 3) {
                    K5 k10 = K5.this;
                    k10.i1(k10.g, k10.h, k10.l, k10.i);
                } else {
                    K5 k11 = K5.this;
                    Z00 z01 = k11.F;
                    String str4 = k11.l;
                    C4064uh c4064uhC1 = k11.c0();
                    K5 k12 = K5.this;
                    z01.Rc(str4, z01.zd(c4064uhC1, k12.h, k12.o0(k12.Z.d)));
                }
            } else if (i == 2) {
                K5 k13 = K5.this;
                k13.I0 = 5;
                C4064uh c4064uhP0 = k13.F.P0(k13.h);
                K5 k14 = K5.this;
                Z00 z02 = k14.F;
                z02.td(z02.zd(k14.c0(), K5.this.h, Double.parseDouble(c4064uhP0.v)));
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: K5$s, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0677s implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;

        public ViewOnClickListenerC0677s(ArrayAdapter arrayAdapter) {
            this.a = arrayAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5 k5 = K5.this;
            k5.O(this.a, k5.M0);
        }
    }

    public class s0 implements SearchView.OnQueryTextListener {
        public s0() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                try {
                    if (K5.this.x1.size() > 0) {
                        K5.this.d0(1);
                    }
                } catch (Exception unused) {
                }
            }
            K5.this.z0(str);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            K5 k5 = K5.this;
            if (k5.Z == null) {
                return false;
            }
            k5.d0(2);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            try {
                K5.this.d0(2);
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: K5$t, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0678t implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;

        public ViewOnClickListenerC0678t(ArrayAdapter arrayAdapter) {
            this.a = arrayAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            K5 k5 = K5.this;
            k5.O(this.a, k5.O0);
        }
    }

    public class t0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ CharSequence[] a;

        public t0(CharSequence[] charSequenceArr) {
            this.a = charSequenceArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(K5.this.getActivity());
                if (i == 0) {
                    K5 k5 = K5.this;
                    k5.C1 = k5.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        K5.this.G();
                    }
                } else if (i == 1) {
                    K5 k6 = K5.this;
                    k6.C1 = k6.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        K5.this.e0();
                    }
                } else if (this.a[i].equals("Cancel")) {
                    dialogInterface.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: K5$u, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0679u implements View.OnClickListener {
        public ViewOnClickListenerC0679u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", K5.this.d0);
                bundle.putInt("month", K5.this.e0);
                bundle.putInt("day", K5.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(K5.this.r1);
                c2137ei.show(K5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(K5.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    public class u0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public u0(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(K5.this.getActivity());
                if (this.a[i].equals(K5.this.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    K5 k5 = K5.this;
                    k5.C1 = k5.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        K5.this.G();
                    }
                } else if (this.a[i].equals(K5.this.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    K5 k6 = K5.this;
                    k6.C1 = k6.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        K5.this.e0();
                    }
                } else if (this.a[i].equals(K5.this.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    K5.this.F.qa(Z00.M + K5.this.b1.getTag().toString());
                } else if (this.a[i].equals(K5.this.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    K5.this.b1.setTag(null);
                    K5.this.b1.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    K5.this.b1.getLayoutParams().width = (int) K5.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    K5.this.b1.getLayoutParams().height = (int) K5.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class v0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public v0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            K5.this.s(this.a);
        }
    }

    public class w0 implements ActivityResultCallback {
        public w0() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                K5.this.h1();
            }
        }
    }

    /* JADX INFO: renamed from: K5$x, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0682x implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0682x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                dialogInterface.dismiss();
                K5.this.m0();
            } catch (Exception unused) {
            }
        }
    }

    public class x0 extends Handler {
        public x0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: K5$y, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0683y implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public ViewOnClickListenerC0683y(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                K5 k5 = K5.this;
                k5.J0 = 1;
                if (k5.N0.getText() == null) {
                    K5 k6 = K5.this;
                    k6.L0 = "";
                    k6.K0 = "";
                } else {
                    K5 k7 = K5.this;
                    k7.L0 = k7.N0.getText().toString();
                    K5 k8 = K5.this;
                    k8.K0 = k8.N0.getText().toString();
                    K5 k9 = K5.this;
                    FragmentStatePagerSupport.P = k9.L0;
                    FragmentStatePagerSupport.O = k9.K0;
                    k9.F.v0("update sys_conf set value_='" + K5.this.L0 + "' where id=2");
                    K5 k10 = K5.this;
                    k10.j = k10.O0.getText().toString();
                    FragmentStatePagerSupport.G = K5.this.j;
                }
                this.a.dismiss();
                K5.this.r();
            } catch (Exception unused) {
            }
        }
    }

    public class y0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public y0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            K5.this.F.v0("insert into groups  (name )  values( '" + K5.this.G1 + "'  )");
            K5.this.D0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: K5$z, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0684z implements View.OnClickListener {
        public ViewOnClickListenerC0684z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", K5.this.d0);
                bundle.putInt("month", K5.this.e0);
                bundle.putInt("day", K5.this.f0);
                c2137ei.setArguments(bundle);
                c2137ei.f(K5.this.s1);
                c2137ei.show(K5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(K5.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    public class z0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public z0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            K5.this.D0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public K5() {
        Boolean bool = Boolean.FALSE;
        this.M = bool;
        this.N = bool;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.c0 = 0;
        this.k0 = new int[]{info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
        this.l0 = null;
        this.m0 = new C0661k();
        this.n0 = "";
        this.o0 = "";
        this.p0 = "";
        this.q0 = "";
        this.r0 = "";
        this.s0 = 0;
        this.t0 = "";
        this.u0 = "";
        this.z0 = -1;
        this.C0 = new ViewOnClickListenerC0642a0();
        this.F0 = 0;
        this.G0 = "";
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = CSS.Value.PERCENTAGE;
        this.L0 = CSS.Value.PERCENTAGE;
        this.M0 = null;
        this.N0 = null;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = null;
        this.R0 = null;
        this.S0 = null;
        this.T0 = null;
        this.U0 = null;
        this.V0 = null;
        this.W0 = null;
        this.X0 = null;
        this.Y0 = null;
        this.Z0 = null;
        this.a1 = null;
        this.b1 = null;
        this.c1 = null;
        this.d1 = null;
        this.e1 = null;
        this.f1 = null;
        this.g1 = null;
        this.h1 = null;
        this.i1 = null;
        this.j1 = null;
        this.k1 = null;
        this.l1 = null;
        this.m1 = new ArrayList();
        this.o1 = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.p1 = new S();
        this.q1 = new T();
        this.r1 = new U();
        this.s1 = new V();
        this.t1 = null;
        this.u1 = new HandlerC0668n0();
        this.v1 = "";
        this.w1 = null;
        this.x1 = new ArrayList();
        this.A1 = 3;
        this.B1 = 4;
        this.D1 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: J5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.a.t0((Uri) obj);
            }
        });
        this.E1 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new w0());
        this.G1 = "";
        this.H1 = false;
    }

    private void B0(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.F, getActivity());
            if (strX != null) {
                P0(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        try {
            if (Z00.Z) {
                if (this.m1.size() == 0) {
                    this.m1 = this.F.j3();
                }
                for (int i = 0; i < this.m1.size(); i++) {
                    if (this.z0 >= this.m1.size() - 1) {
                        this.z0 = -1;
                    }
                    int i2 = this.z0 + 1;
                    this.z0 = i2;
                    String str = (String) ((HashMap) this.m1.get(i2)).get("name");
                    if (!str.equals("") && this.F.G3(this.g, str).getCount() > 0 && !str.equals(this.j)) {
                        this.j = str;
                        r();
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        new C3966tX().d(getActivity());
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.CAMERA") == 0) {
            h1();
            return;
        }
        int i = Integer.parseInt(this.F.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.F.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.E1.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(getActivity(), getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean H() {
        boolean zA = AbstractC4371yX.a(this.S0);
        if (!AbstractC4371yX.a(this.V0)) {
            zA = false;
        }
        if (this.h.equals(this.F.B3().j())) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.not_valid), 0).show();
            zA = false;
        }
        if ((this.F.S3() <= 100 || this.F.F5(Z00.R) != 0 || this.F.Y5(Z00.R, Z00.S) != 0 || (this.F.T3().getCount() <= 5 && this.F.S3() <= 200)) && this.F.r2(Z00.R) <= 0) {
            this.X0.setError(null);
            return zA;
        }
        Q();
        this.X0.setError(getActivity().getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    private void H0(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
        imageView.getLayoutParams().width = this.s0;
        imageView.getLayoutParams().height = this.s0;
    }

    private boolean I() {
        boolean zA = AbstractC4371yX.a(this.Q0);
        if (!AbstractC4371yX.a(this.R0)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.S0)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.V0)) {
            zA = false;
        }
        if (this.Q0.getText().toString().equals(this.R0.getText().toString())) {
            this.R0.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.F.u3(this.R0.getText().toString()) == 0 && this.F.u3(this.R0.getText().toString().trim()) == 0) {
            this.R0.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.F.u3(this.Q0.getText().toString()) == 0 && this.F.u3(this.Q0.getText().toString().trim()) == 0) {
            this.Q0.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if ((this.F.S3() <= 100 || this.F.F5(Z00.R) != 0 || this.F.Y5(Z00.R, Z00.S) != 0 || (this.F.T3().getCount() <= 5 && this.F.S3() <= 200)) && this.F.r2(Z00.R) <= 0) {
            this.X0.setError(null);
            return zA;
        }
        Q();
        this.X0.setError(getActivity().getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    private void I0(List list) {
        Collections.sort(this.A, new M0(this, null));
    }

    private void J() {
        if (this.F.u3(this.h) == 0 && this.F.u3(this.h.trim()) == 0) {
            String strTrim = this.h.trim();
            this.h = strTrim;
            if (strTrim.length() >= 1 && this.X0.getText().toString().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_add))) {
                i0(getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.h, getActivity());
            }
        }
        String str = this.h;
        if (!str.equals(str.trim()) && this.F.u3(this.h.trim()) > 0) {
            this.h = this.h.trim();
        }
        this.F.D = false;
        if (this.l1.getTag() == null || this.l1.getTag().toString().equals(this.F.l3("0")) || this.F.Z2(this.l1.getTag().toString(), this.F.cc(this.T0.getText().toString())) != 0) {
            return;
        }
        this.F.u(getActivity(), this.l1.getTag().toString(), this.F.cc(this.T0.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    private void K() {
        if (this.F.u3(this.R0.getText().toString()) == 0 && this.F.u3(this.R0.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.R0;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.R0.getText().toString().length() >= 1 && this.X0.getText().toString().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                k0(getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.R0.getText().toString(), getActivity());
            }
        }
        if (!this.R0.getText().toString().equals(this.R0.getText().toString().trim()) && this.F.u3(this.R0.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView2 = this.R0;
            autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
        }
        if (this.F.u3(this.Q0.getText().toString()) == 0 && this.F.u3(this.Q0.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView3 = this.Q0;
            autoCompleteTextView3.setText(autoCompleteTextView3.getText().toString().trim());
            if (this.Q0.getText().toString().length() >= 1 && this.X0.getText().toString().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                i0(getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.Q0.getText().toString(), getActivity());
            }
        }
        if (!this.Q0.getText().toString().equals(this.Q0.getText().toString().trim()) && this.F.u3(this.Q0.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView4 = this.Q0;
            autoCompleteTextView4.setText(autoCompleteTextView4.getText().toString().trim());
        }
        this.F.D = false;
        if (this.l1.getTag() == null || this.l1.getTag().toString().equals(this.F.l3("0")) || this.F.Z2(this.l1.getTag().toString(), this.F.cc(this.T0.getText().toString())) != 0) {
            return;
        }
        this.F.u(getActivity(), this.l1.getTag().toString(), this.F.cc(this.T0.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    private void K0(List list) {
        Collections.sort(list, Collections.reverseOrder(new C0662k0()));
    }

    private boolean L() {
        boolean zA = AbstractC4371yX.a(this.S0);
        if (!AbstractC4371yX.a(this.V0)) {
            zA = false;
        }
        if ((this.F.S3() <= 100 || this.F.F5(Z00.R) != 0 || this.F.Y5(Z00.R, Z00.S) != 0 || (this.F.T3().getCount() <= 5 && this.F.S3() <= 200)) && this.F.r2(Z00.R) <= 0) {
            this.X0.setError(null);
            return zA;
        }
        Q();
        return false;
    }

    private void L0(List list) {
        Collections.sort(list, Collections.reverseOrder(new C0658i0()));
    }

    private void M0(List list) {
        Collections.sort(this.A, new R0(this, null));
    }

    private void N0() {
        String[] stringArray = getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(stringArray, new t0(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
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

    private void S() {
        int i = Calendar.getInstance().get(14);
        if (this.J0 == 0) {
            getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.g) * i * 1000000, null, this.m0).forceLoad();
        }
        getActivity().getSupportLoaderManager().initLoader(Integer.parseInt(this.g) * i, null, this).forceLoad();
    }

    private void T() {
        int i = Calendar.getInstance().get(14);
        StringBuilder sb = new StringBuilder();
        sb.append("Start...");
        sb.append(Integer.parseInt(this.g) * i * 1000000);
        sb.append(":");
        sb.append(i);
        sb.append(":");
        boolean z = Z00.Z;
        int i2 = this.z0;
        if (!(z & (i2 > 0))) {
            i2 = 1;
        }
        sb.append(i2);
        Log.d("data_loader2", sb.toString());
        LoaderManager supportLoaderManager = getActivity().getSupportLoaderManager();
        int i3 = Integer.parseInt(this.g) * i * 1000000;
        boolean z2 = Z00.Z;
        int i4 = this.z0;
        supportLoaderManager.initLoader(i3 + ((z2 && (i4 > 0)) ? i4 : 1), null, this.m0).forceLoad();
    }

    private void V() {
        String[] stringArray = this.b1.getTag() != null ? getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(stringArray, new u0(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    private void X0(List list) {
        Collections.sort(this.A, new Q0(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(List list) {
        Collections.sort(this.A, new L0(this, null));
    }

    private void a1(List list) {
        Collections.sort(list, Collections.reverseOrder(new C0660j0()));
    }

    private void b1(List list) {
        Collections.sort(list, Collections.reverseOrder(new C0656h0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C4064uh c0() {
        Cursor cursorS7 = this.F.s7(this.h);
        cursorS7.moveToFirst();
        C4064uh c4064uh = null;
        while (!cursorS7.isAfterLast()) {
            c4064uh = new C4064uh(cursorS7.getString(cursorS7.getColumnIndex("_id")), cursorS7.getString(cursorS7.getColumnIndex("date_")), cursorS7.getString(cursorS7.getColumnIndex("amount")), cursorS7.getString(cursorS7.getColumnIndex("remarks")), this.k0[cursorS7.getInt(cursorS7.getColumnIndex("_in"))], String.valueOf(cursorS7.getInt(cursorS7.getColumnIndex("_in"))), cursorS7.getString(cursorS7.getColumnIndex("param1")), cursorS7.getString(cursorS7.getColumnIndex("curr_name")), cursorS7.getString(cursorS7.getColumnIndex("bill_id")), cursorS7.getString(cursorS7.getColumnIndex("org_remarks")));
            cursorS7.moveToNext();
        }
        cursorS7.close();
        return c4064uh;
    }

    private void d1(View view) {
        if (this.c0 == 0) {
            Y0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 1;
        } else {
            I0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(getActivity()));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(getActivity())) {
            this.D1.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(getActivity());
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.B1);
    }

    public static String f0() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public static String g0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
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
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String h0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (r0(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (q0(uri)) {
                        return g0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (s0(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return g0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return g0(context, uri, null, null);
                }
                if (Annotation.FILE.equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean q0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean r0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean s0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        B0(uri, true);
    }

    private void v(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterfaceOnClickListenerC0676r0()).show();
    }

    private void x0(Intent intent) {
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
                R(new File(h0(getActivity(), this.F1)), file2);
            }
            P0(file2.getName());
        } catch (Exception unused) {
        }
    }

    public boolean A(int i) {
        int i2;
        boolean z;
        int i3;
        String message;
        String str;
        String str2;
        if (i == info.aalmoghalis.inventory.R.id.btn_cus_det_add1) {
            i2 = -1;
        } else {
            i2 = i == info.aalmoghalis.inventory.R.id.btn_cus_det_add2 ? 1 : 0;
        }
        J();
        if (!H()) {
            return false;
        }
        if (i2 != 0) {
            try {
                if (this.b1.getTag() == null) {
                    Z00 z00 = this.F;
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param2,curr_id) values((select b.id from customers as b where b.name='");
                    sb.append(this.h);
                    sb.append("'),");
                    sb.append(this.S0.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append(",");
                    sb.append(i2);
                    sb.append(",'");
                    sb.append((Object) this.T0.getText());
                    sb.append("','");
                    sb.append((Object) this.V0.getText());
                    sb.append("',strftime('%Y-%m-%d','now'),'");
                    sb.append(this.F.B8());
                    sb.append("',");
                    if (this.l1.getTag() == null) {
                        str2 = "0";
                    } else {
                        str2 = "(select id from currency where name='" + this.l1.getTag().toString() + "')";
                    }
                    sb.append(str2);
                    sb.append(" )");
                    z00.x0(sb.toString());
                } else {
                    Z00 z01 = this.F;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param1,param2,curr_id) values((select b.id from customers as b where b.name='");
                    sb2.append(this.h);
                    sb2.append("'),");
                    sb2.append(this.S0.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append(",");
                    sb2.append(i2);
                    sb2.append(",'");
                    sb2.append((Object) this.T0.getText());
                    sb2.append("','");
                    sb2.append((Object) this.V0.getText());
                    sb2.append("',strftime('%Y-%m-%d','now'),'");
                    sb2.append(this.b1.getTag().toString());
                    sb2.append("','");
                    sb2.append(this.F.B8());
                    sb2.append("',");
                    if (this.l1.getTag() == null) {
                        str = "0";
                    } else {
                        str = "(select id from currency where name='" + this.l1.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(" )");
                    z01.x0(sb2.toString());
                }
                this.S0.setText((CharSequence) null);
                Calendar calendar = Calendar.getInstance();
                this.T0.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                this.d0 = calendar.get(1);
                this.e0 = calendar.get(2);
                this.f0 = calendar.get(5);
                H0(this.b1);
                this.V0.setText((CharSequence) null);
                this.S0.requestFocus();
                try {
                    FragmentStatePagerSupport_Main.a0 = true;
                    z = true;
                } catch (Exception e) {
                    e = e;
                    z = true;
                    FragmentActivity activity = getActivity();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Error:");
                    if (e.getMessage() == null || e.getMessage().length() <= 20) {
                        i3 = 0;
                        message = e.getMessage();
                    } else {
                        i3 = 0;
                        message = e.getMessage().substring(0, 20);
                    }
                    sb3.append(message);
                    Toast.makeText(activity, sb3.toString(), i3).show();
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
        } else {
            z = false;
        }
        return z;
    }

    public void A0(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.l1.setTag(radioButton.getText().toString());
            Log.d("radio_checked:=", radioButton.getText().toString());
            if (this.l1.getTag() != null) {
                this.j = this.l1.getTag().toString();
            }
        }
    }

    public boolean B() {
        boolean z;
        int i;
        String message;
        String str;
        String str2;
        K();
        if (!I()) {
            return false;
        }
        try {
            if (this.b1.getTag() == null) {
                Z00 z00 = this.F;
                StringBuilder sb = new StringBuilder();
                sb.append("insert into transactions (cus_id,t_cus_id,out,[in],date_,remarks,now_,param2,curr_id) values((select b.id from customers as b where b.name='");
                sb.append(this.Q0.getText().toString());
                sb.append("'),(select b.id from customers as b where b.name='");
                sb.append(this.R0.getText().toString());
                sb.append("'),");
                sb.append(this.S0.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb.append(",");
                sb.append(1);
                sb.append(",'");
                sb.append((Object) this.T0.getText());
                sb.append("','");
                sb.append((Object) this.V0.getText());
                sb.append("',strftime('%Y-%m-%d','now'),'");
                sb.append(this.F.B8());
                sb.append("',");
                if (this.l1.getTag() == null) {
                    str2 = "0";
                } else {
                    str2 = "(select id from currency where name='" + this.l1.getTag().toString() + "')";
                }
                sb.append(str2);
                sb.append(" )");
                z00.x0(sb.toString());
            } else {
                Z00 z01 = this.F;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("insert into transactions (cus_id,t_cus_id,out,[in],date_,remarks,now_,param1,param2,curr_id) values((select b.id from customers as b where b.name='");
                sb2.append(this.Q0.getText().toString());
                sb2.append("'),(select b.id from customers as b where b.name='");
                sb2.append(this.R0.getText().toString());
                sb2.append("'),");
                sb2.append(this.S0.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb2.append(",");
                sb2.append(1);
                sb2.append(",'");
                sb2.append((Object) this.T0.getText());
                sb2.append("','");
                sb2.append((Object) this.V0.getText());
                sb2.append("',strftime('%Y-%m-%d','now'),'");
                sb2.append(this.b1.getTag().toString());
                sb2.append("','");
                sb2.append(this.F.B8());
                sb2.append("',");
                if (this.l1.getTag() == null) {
                    str = "0";
                } else {
                    str = "(select id from currency where name='" + this.l1.getTag().toString() + "')";
                }
                sb2.append(str);
                sb2.append(" )");
                z01.x0(sb2.toString());
            }
            n0(this.Q0.getText().toString());
            this.Q0.setText((CharSequence) null);
            this.R0.setText((CharSequence) null);
            this.S0.setText((CharSequence) null);
            Calendar calendar = Calendar.getInstance();
            this.T0.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
            this.d0 = calendar.get(1);
            this.e0 = calendar.get(2);
            this.f0 = calendar.get(5);
            H0(this.b1);
            this.V0.setText((CharSequence) null);
            z = true;
            try {
                FragmentStatePagerSupport_Main.a0 = true;
                return true;
            } catch (Exception e) {
                e = e;
                FragmentActivity activity = getActivity();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Error:");
                if (e.getMessage() == null || e.getMessage().length() <= 20) {
                    i = 0;
                    message = e.getMessage();
                } else {
                    i = 0;
                    message = e.getMessage().substring(0, 20);
                }
                sb3.append(message);
                Toast.makeText(activity, sb3.toString(), i).show();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public boolean C() {
        int i;
        boolean z;
        int i2;
        String message;
        boolean z2;
        boolean z3;
        if (this.d1.isChecked()) {
            i = -1;
        } else {
            i = this.e1.isChecked() ? 1 : 0;
        }
        J();
        if (!L()) {
            return false;
        }
        try {
            if (!this.X0.getText().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save)) || this.n == 0) {
                z2 = true;
                z3 = false;
            } else {
                String str = "0";
                if (this.b1.getTag() == null) {
                    Z00 z00 = this.F;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update transactions set out='");
                    sb.append(this.S0.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',[in]='");
                    sb.append(i);
                    sb.append("',date_='");
                    sb.append((Object) this.T0.getText());
                    sb.append("',remarks='");
                    sb.append((Object) this.V0.getText());
                    sb.append("',param1='',curr_id=");
                    if (this.l1.getTag() != null) {
                        str = "(select id from currency where name='" + this.l1.getTag().toString() + "')";
                    }
                    sb.append(str);
                    sb.append(" where id='");
                    sb.append(this.n);
                    sb.append("'");
                    z00.x0(sb.toString());
                } else {
                    Z00 z01 = this.F;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("update transactions set out='");
                    sb2.append(this.S0.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',[in]='");
                    sb2.append(i);
                    sb2.append("',date_='");
                    sb2.append((Object) this.T0.getText());
                    sb2.append("',remarks='");
                    sb2.append((Object) this.V0.getText());
                    sb2.append("',param1='");
                    sb2.append(this.b1.getTag().toString());
                    sb2.append("',curr_id=");
                    if (this.l1.getTag() != null) {
                        str = "(select id from currency where name='" + this.l1.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(" where id='");
                    sb2.append(this.n);
                    sb2.append("'");
                    z01.x0(sb2.toString());
                }
                this.S0.setText((CharSequence) null);
                Calendar calendar = Calendar.getInstance();
                this.T0.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                this.d0 = calendar.get(1);
                this.e0 = calendar.get(2);
                this.f0 = calendar.get(5);
                this.V0.setText((CharSequence) null);
                H0(this.b1);
                this.X0.setText(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_add));
                this.n = 0;
                z2 = true;
                z3 = true;
            }
            try {
                FragmentStatePagerSupport_Main.a0 = z2;
                return z3;
            } catch (Exception e) {
                e = e;
                z = z3;
                FragmentActivity activity = getActivity();
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
                Toast.makeText(activity, sb3.toString(), i2).show();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public void C0(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public boolean D() {
        boolean z;
        int i;
        String message;
        boolean z2;
        int i2 = this.v;
        int[] iArr = this.k0;
        if (i2 != iArr[0]) {
            int i3 = iArr[2];
        }
        K();
        if (!I()) {
            return false;
        }
        try {
            if (!this.X0.getText().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save)) || this.n == 0) {
                z2 = true;
                z = false;
            } else {
                String str = "0";
                if (this.b1.getTag() == null) {
                    Z00 z00 = this.F;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update transactions set out='");
                    sb.append(this.S0.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',date_='");
                    sb.append((Object) this.T0.getText());
                    sb.append("',remarks='");
                    sb.append((Object) this.V0.getText());
                    sb.append("',param1='',t_cus_id=(select id from customers where name='");
                    sb.append(this.R0.getText().toString());
                    sb.append("') ,cus_id=(select id from customers where name='");
                    sb.append(this.Q0.getText().toString());
                    sb.append("') ,curr_id=");
                    if (this.l1.getTag() != null) {
                        str = "(select id from currency where name='" + this.l1.getTag().toString() + "')";
                    }
                    sb.append(str);
                    sb.append(" where id='");
                    sb.append(this.n);
                    sb.append("'");
                    z00.x0(sb.toString());
                } else {
                    Z00 z01 = this.F;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("update transactions set out='");
                    sb2.append(this.S0.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',date_='");
                    sb2.append((Object) this.T0.getText());
                    sb2.append("',remarks='");
                    sb2.append((Object) this.V0.getText());
                    sb2.append("',param1='");
                    sb2.append(this.b1.getTag().toString());
                    sb2.append("',t_cus_id=(select id from customers where name='");
                    sb2.append(this.R0.getText().toString());
                    sb2.append("') ,cus_id=(select id from customers where name='");
                    sb2.append(this.Q0.getText().toString());
                    sb2.append("') ,curr_id=");
                    if (this.l1.getTag() != null) {
                        str = "(select id from currency where name='" + this.l1.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(" where id='");
                    sb2.append(this.n);
                    sb2.append("'");
                    z01.x0(sb2.toString());
                }
                this.Q0.setText((CharSequence) null);
                this.S0.setText((CharSequence) null);
                Calendar calendar = Calendar.getInstance();
                this.T0.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                this.d0 = calendar.get(1);
                this.e0 = calendar.get(2);
                this.f0 = calendar.get(5);
                this.V0.setText((CharSequence) null);
                H0(this.b1);
                z2 = true;
                z = true;
            }
            try {
                FragmentStatePagerSupport_Main.a0 = z2;
                return z;
            } catch (Exception e) {
                e = e;
                FragmentActivity activity = getActivity();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Error:");
                if (e.getMessage() == null || e.getMessage().length() <= 20) {
                    i = 0;
                    message = e.getMessage();
                } else {
                    i = 0;
                    message = e.getMessage().substring(0, 20);
                }
                sb3.append(message);
                Toast.makeText(activity, sb3.toString(), i).show();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public void D0() {
        V0(true);
        new Thread(new RunnableC0670o0()).start();
    }

    public void E() {
        I1 = 0.0d;
        try {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                I1 += Double.parseDouble(((C4064uh) this.A.get(size)).n().replaceAll(",", "")) * (Double.parseDouble(((C4064uh) this.A.get(size)).f().replaceAll(",", "")) - 1.0d);
                C4064uh c4064uh = (C4064uh) this.A.get(size);
                c4064uh.w(String.valueOf(I1));
                this.A.set(size, c4064uh);
            }
        } catch (Exception unused) {
        }
    }

    public void E0() {
        V0(true);
        new Thread(new RunnableC0674q0()).start();
    }

    public void F(View view) {
        String str = this.l;
        if (str != null && str.length() >= 3) {
            this.F.n0(this.l);
        } else {
            this.I0 = 1;
            i1(this.g, this.h, this.l, this.i);
        }
    }

    public void G0() {
        C1044Xj.a().c(new RunnableC1171Zj(2, this.F, this.Q0, this.R0, this.V0, getActivity(), this.i1, this.X0, new RunnableC1086Yj()));
    }

    public final void J0(List list) {
        Collections.sort(this.A, new O0(this, null));
    }

    public void M(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        ListView listView = new ListView(getActivity());
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new A0(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(info.aalmoghalis.inventory.R.string.pref_group_curr));
        dialog.show();
    }

    public void N(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        autoCompleteTextView.setText("");
        ListView listView = new ListView(getActivity());
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new C0665m(autoCompleteTextView, dialog, editText));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    public void O(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        ListView listView = new ListView(getActivity());
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new B0(textView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(info.aalmoghalis.inventory.R.string.pref_group_curr));
        dialog.show();
    }

    public void O0(int i) {
        String str = this.k;
        String str2 = this.l;
        if (str2 == null || str2.length() < 3) {
            if (i == 2) {
                this.I0 = 5;
            }
            i1(this.g, this.h, this.l, this.i);
            return;
        }
        String str3 = "";
        if (str.contains("-")) {
            if (i == 1) {
                Z00 z00 = this.F;
                String str4 = this.l;
                StringBuilder sb = new StringBuilder();
                sb.append(getActivity().getString(info.aalmoghalis.inventory.R.string.credit));
                sb.append(":");
                sb.append(str);
                if (Z00.Z) {
                    str3 = "\t" + this.j;
                }
                sb.append(str3);
                z00.Rc(str4, sb.toString());
                return;
            }
            if (Build.VERSION.SDK_INT < 31) {
                x();
            }
            if (!Z00.Z) {
                Z00 z01 = this.F;
                z01.Xa(this.a0, z01.ic(this.h), o0(this.Z.d));
                this.F.Hd(this.l, this.F.ic(this.h) + ".pdf");
                return;
            }
            if (this.F.ja("pref_print_all_curr", false)) {
                Z00 z02 = this.F;
                z02.nb(z02.ic(this.h), this.g, this.K0, this.L0, this.F.ic(this.h));
                this.F.Hd(this.l, this.F.ic(this.h) + ".pdf");
                return;
            }
            Z00 z03 = this.F;
            z03.ab(this.a0, z03.ic(this.h + "-" + this.j), o0(this.Z.d), this.j, this.K0, this.L0, this.F.ic(this.h));
            Z00 z04 = this.F;
            String str5 = this.l;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.F.ic(this.h + "-" + this.j));
            sb2.append(".pdf");
            z04.Hd(str5, sb2.toString());
            return;
        }
        if (i == 1) {
            Z00 z05 = this.F;
            String str6 = this.l;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getActivity().getString(info.aalmoghalis.inventory.R.string.debit));
            sb3.append(":");
            sb3.append(str);
            if (Z00.Z) {
                str3 = "\t" + this.j;
            }
            sb3.append(str3);
            z05.Rc(str6, sb3.toString());
            return;
        }
        if (Build.VERSION.SDK_INT < 31) {
            x();
        }
        if (!Z00.Z) {
            Z00 z06 = this.F;
            z06.Xa(this.a0, z06.ic(this.h), o0(this.Z.d));
            this.F.Hd(this.l, this.F.ic(this.h) + ".pdf");
            return;
        }
        if (this.F.ja("pref_print_all_curr", false)) {
            Z00 z07 = this.F;
            z07.nb(z07.ic(this.h), this.g, this.K0, this.L0, this.F.ic(this.h));
            this.F.Hd(this.l, this.F.ic(this.h) + ".pdf");
            return;
        }
        Z00 z08 = this.F;
        z08.ab(this.a0, z08.ic(this.h + "-" + this.j), o0(this.Z.d), this.j, this.K0, this.L0, this.F.ic(this.h));
        Z00 z09 = this.F;
        String str7 = this.l;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.F.ic(this.h + "-" + this.j));
        sb4.append(".pdf");
        z09.Hd(str7, sb4.toString());
    }

    public void P() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.f_date);
            this.M0 = textView;
            textView.setVisibility(8);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.t_date);
            this.P0 = textView2;
            textView2.setOnClickListener(new ViewOnClickListenerC0684z());
            builder.setMessage(getActivity().getString(info.aalmoghalis.inventory.R.string.close_balance));
            builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new A());
            builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new B());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getWindow().setSoftInputMode(16);
        } catch (Exception e) {
            Log.d("closing_balance_error=", e.getMessage());
        }
    }

    public void P0(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            this.b1.getLayoutParams().width = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width);
            this.b1.getLayoutParams().height = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height);
            this.b1.setImageBitmap(bitmapP0);
            this.b1.setTag(str);
        } catch (Exception unused) {
        }
    }

    public void Q() {
        try {
            if (this.F.ja("black_list", false)) {
                this.F.Lc("black_date", "");
                this.F.F0(getActivity());
            }
            y();
            this.F.qe(getActivity(), getActivity());
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void Q0() {
        FragmentActivity activity;
        int i;
        StringBuilder sb = new StringBuilder();
        int size = this.b0.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.b0.valueAt(size)) {
                C4064uh item = this.Z.getItem(this.b0.keyAt(size));
                if (item.t() == this.k0[0]) {
                    activity = getActivity();
                    i = info.aalmoghalis.inventory.R.string.credit;
                } else {
                    activity = getActivity();
                    i = info.aalmoghalis.inventory.R.string.debit;
                }
                sb.append(activity.getString(i));
                sb.append(" ");
                sb.append(item.n());
                sb.append(" ");
                sb.append(item.r());
                sb.append(" ");
                sb.append(getActivity().getString(info.aalmoghalis.inventory.R.string.day));
                sb.append(" ");
                sb.append(item.p().substring(0, 5));
                sb.append(StringUtilities.LF);
            }
        }
        double d = this.x1.size() > 0 ? Double.parseDouble((String) this.x1.get(0)) : 0.0d;
        if (d >= 0.0d) {
            sb.append(StringUtilities.LF);
            sb.append(getActivity().getString(info.aalmoghalis.inventory.R.string.net_total2_sms));
            sb.append(" ");
            sb.append(this.F.P7(String.valueOf(d)));
        } else {
            sb.append(StringUtilities.LF);
            sb.append(getActivity().getString(info.aalmoghalis.inventory.R.string.net_total1_sms));
            sb.append(" ");
            sb.append(this.F.P7(String.valueOf(d)));
        }
        this.F.td(sb.toString());
    }

    public void R0() {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        String[] stringArray = getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_share_tr);
        TypedArray typedArrayObtainTypedArray = getActivity().getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons_share_tr);
        ListView listView = new ListView(getActivity());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stringArray.length; i++) {
            arrayList.add(new C3874sM(stringArray[i], typedArrayObtainTypedArray.getResourceId(i, -1)));
        }
        typedArrayObtainTypedArray.recycle();
        listView.setAdapter((ListAdapter) new C4062ug(getActivity(), arrayList));
        listView.setOnItemClickListener(new C0675r(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        listView.setDividerHeight(0);
        linearLayout.addView(listView, -1, -1);
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void S0() {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        this.g0 = getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_share);
        this.h0 = getActivity().getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons_share);
        ListView listView = new ListView(getActivity());
        this.i0 = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = this.g0;
            if (i >= strArr.length) {
                this.h0.recycle();
                C4062ug c4062ug = new C4062ug(getActivity(), this.i0);
                this.j0 = c4062ug;
                listView.setAdapter((ListAdapter) c4062ug);
                listView.setOnItemClickListener(new C0673q(dialog));
                linearLayout.setFocusable(true);
                listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                listView.setDividerHeight(0);
                linearLayout.addView(listView, -1, -1);
                dialog.requestWindowFeature(1);
                dialog.setContentView(linearLayout);
                dialog.show();
                return;
            }
            this.i0.add(new C3874sM(strArr[i], this.h0.getResourceId(i, -1)));
            i++;
        }
    }

    public void T0(boolean z) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.n1 = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, this.F.F8(this.h, ""));
        this.V0.setThreshold(1);
        this.V0.setAdapter(this.n1);
        if (z) {
            this.g1.setVisibility(8);
            this.j1.setVisibility(0);
            this.k1.setVisibility(0);
            Z();
            this.T0.setText(simpleDateFormat.format(calendar.getTime()));
            this.T0.setOnClickListener(new W());
            return;
        }
        this.j1.setVisibility(8);
        this.g1.setVisibility(0);
        this.X0.setText(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save));
        this.V0.setText(this.t);
        this.T0.setText(this.p);
        this.S0.setText(this.q);
        int i = this.v;
        int[] iArr = this.k0;
        if (i == iArr[0]) {
            this.d1.setChecked(true);
        } else if (i == iArr[2]) {
            this.e1.setChecked(true);
        }
        if (!this.u.equals("")) {
            this.b1.setImageBitmap(Z00.p0(Z00.M + this.u, 100, 100));
            this.b1.setTag(this.u);
            this.b1.getLayoutParams().width = 100;
            this.b1.getLayoutParams().height = 70;
        }
        this.S0.selectAll();
        this.S0.requestFocus();
        p0(4, 500);
        this.k1.setVisibility(0);
        Z();
        this.T0.setOnClickListener(new X());
    }

    public void U() {
        if (C2160f10.h > 0 && !new C2160f10(this.F).l("-9", HTML.Tag.DEL)) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.b0.size() - 1; size >= 0; size--) {
            if (this.b0.valueAt(size)) {
                C4064uh item = this.Z.getItem(this.b0.keyAt(size));
                String strA = item.a() != null ? item.a() : "";
                this.x = strA;
                int i = strA.equals("") ? 0 : Integer.parseInt(this.x);
                if (i > 0) {
                    Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_edit), 1).show();
                    this.n = 0;
                    return;
                }
                if (i == -2 || i == -3 || i == -4 || i == -6) {
                    Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_edit_doc), 1).show();
                    this.n = 0;
                    return;
                }
                this.Z.remove(item);
                this.F.v0("delete from transactions where id=" + item.q());
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        m0();
    }

    public void U0(boolean z) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.Q0.setThreshold(1);
        this.R0.setThreshold(1);
        this.V0.setThreshold(1);
        G0();
        this.Q0.setOnItemClickListener(new Y());
        this.R0.setOnItemClickListener(new Z());
        this.Q0.setOnTouchListener(new ViewOnTouchListenerC0644b0());
        this.Q0.addTextChangedListener(new C0646c0());
        this.R0.setOnTouchListener(new ViewOnTouchListenerC0648d0());
        this.R0.addTextChangedListener(new C0650e0());
        this.V0.addTextChangedListener(new C0652f0());
        this.T0.setText(simpleDateFormat.format(calendar.getTime()));
        this.k1.setVisibility(0);
        Z();
        this.T0.setOnClickListener(new ViewOnClickListenerC0654g0());
        if (z) {
            return;
        }
        this.Q0.setText(this.z);
        this.R0.setText(this.y);
        this.V0.setText(this.t);
        this.T0.setText(this.p);
        this.S0.setText(this.q);
        if (!this.u.equals("")) {
            this.b1.setImageBitmap(Z00.p0(Z00.M + this.u, 100, 100));
            this.b1.setTag(this.u);
            this.b1.getLayoutParams().width = 100;
            this.b1.getLayoutParams().height = 70;
        }
        this.S0.selectAll();
        this.S0.requestFocus();
        p0(4, 500);
    }

    public void V0(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setView(getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.progress, (ViewGroup) null));
            if (z) {
                android.app.AlertDialog alertDialogCreate = builder.create();
                this.t1 = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.t1;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void W() {
        if (C2160f10.h > 0 && !new C2160f10(this.F).l("-9", "edit")) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        int size = this.b0.size() - 1;
        if (this.b0.valueAt(size)) {
            C4064uh item = this.Z.getItem(this.b0.keyAt(size));
            try {
                this.x = item.a() != null ? item.a() : "";
                this.n = Integer.parseInt(item.q());
                this.p = item.p();
                this.q = item.n();
                this.t = item.h();
                this.u = item.o() != null ? item.o().toString() : "";
                this.v = item.t();
                this.w = item.b();
                if (this.F.O8(this.n).equals("0")) {
                    X(false);
                    return;
                }
                this.t = this.F.R8(this.n);
                this.z = this.h;
                String strT8 = this.F.T8(this.n);
                this.y = strT8;
                if (strT8.equals(this.h)) {
                    this.z = this.F.N8(this.n);
                }
                Y(false);
            } catch (Exception unused) {
            }
        }
    }

    public void W0() {
        if (this.F.ja("prefAutoNotify", true)) {
            TextView textView = (TextView) ((Snackbar.SnackbarLayout) this.H0.getView()).findViewById(info.aalmoghalis.inventory.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(getActivity(), info.aalmoghalis.inventory.R.color.white));
            C4064uh c4064uhC0 = c0();
            StringBuilder sb = new StringBuilder();
            sb.append(c4064uhC0.t() == this.k0[0] ? this.p0 : this.q0);
            sb.append(" ");
            sb.append(c4064uhC0.n());
            sb.append(" ");
            sb.append(c4064uhC0.r());
            this.H0.setText(sb.toString());
            this.H0.setAction(this.u0, new ViewOnClickListenerC0667n());
            textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getActivity(), android.R.drawable.ic_menu_share), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setOnClickListener(new ViewOnClickListenerC0669o());
            ViewCompat.setLayoutDirection(this.H0.getView(), 1);
            this.H0.show();
            new Handler().postDelayed(new RunnableC0671p(), 5000);
        }
    }

    public void X(boolean z) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.F).l("-9", z ? "new" : "edit")) {
                Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        if (!z) {
            try {
                int i = this.x.equals("") ? 0 : Integer.parseInt(this.x);
                if (i > 0) {
                    this.F.n9(this.x, getActivity(), 1);
                    return;
                }
                if (i == -2) {
                    Bill_edit.R2 = this.h;
                    String strI = new C2160f10(this.F).I(this.n + "");
                    Z00 z00 = this.F;
                    z00.r9(z00.Q8(this.n), this.F.P8(this.n), strI, getActivity());
                    return;
                }
                if (i == -3) {
                    Bill_edit.R2 = this.h;
                    String strI2 = new C2160f10(this.F).I(this.n + "");
                    Z00 z01 = this.F;
                    z01.s9(z01.Q8(this.n), this.F.H8(this.n), this.F.P8(this.n), strI2, getActivity());
                    return;
                }
                if (i == -6) {
                    Bill_edit.R2 = this.h;
                    String strI3 = new C2160f10(this.F).I(this.n + "");
                    Z00 z02 = this.F;
                    z02.p9(z02.Q8(this.n), this.F.H8(this.n), this.F.P8(this.n), strI3, getActivity());
                    return;
                }
                if (i == -4) {
                    this.F.t9(this.n + "", getActivity());
                    return;
                }
            } catch (Exception e) {
                Log.d("edit_item_error=", ":" + e.getMessage());
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.customer_det_edit_dialog2, (ViewGroup) null);
        builder.setView(viewInflate);
        EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        this.S0 = editText;
        this.z1 = editText;
        editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
        EditText editText2 = this.S0;
        editText2.addTextChangedListener(new C2018dE(editText2));
        this.S0.requestFocus();
        this.T0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
        this.X0 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
        this.Y0 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add1);
        Button button = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add2);
        this.Z0 = button;
        this.F.fd(this.Y0, button);
        this.a1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
        this.b1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        this.c1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
        this.d1 = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton1);
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
        this.e1 = radioButton;
        this.F.gd(this.d1, radioButton);
        this.c1.check(info.aalmoghalis.inventory.R.id.radiobutton2);
        this.V0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
        this.f1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
        this.g1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3_1);
        this.h1 = linearLayout;
        if (!z) {
            linearLayout.setVisibility(0);
        }
        this.j1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface5);
        this.k1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
        this.l1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        this.S0.requestFocus();
        T0(z);
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setTitle(this.h);
        alertDialogCreate.getWindow().setSoftInputMode(16);
        this.Y0.setOnClickListener(new F(alertDialogCreate));
        this.Z0.setOnClickListener(new G(alertDialogCreate));
        this.X0.setOnClickListener(new H(alertDialogCreate));
        this.a1.setOnClickListener(new I());
        this.b1.setOnClickListener(new J(z));
        alertDialogCreate.show();
    }

    public void Y(boolean z) {
        if (!z) {
            try {
                int i = this.x.equals("") ? 0 : Integer.parseInt(this.x);
                if (i > 0) {
                    this.F.n9(this.x, getActivity(), 1);
                    return;
                }
                if (i == -2) {
                    Bill_edit.R2 = this.h;
                    String strI = new C2160f10(this.F).I(this.n + "");
                    Z00 z00 = this.F;
                    z00.r9(z00.Q8(this.n), this.F.P8(this.n), strI, getActivity());
                    return;
                }
                if (i == -3) {
                    Bill_edit.R2 = this.h;
                    String strI2 = new C2160f10(this.F).I(this.n + "");
                    Z00 z01 = this.F;
                    z01.s9(z01.Q8(this.n), this.F.H8(this.n), this.F.P8(this.n), strI2, getActivity());
                    return;
                }
                if (i == -6) {
                    Bill_edit.R2 = this.h;
                    String strI3 = new C2160f10(this.F).I(this.n + "");
                    Z00 z02 = this.F;
                    z02.p9(z02.Q8(this.n), this.F.H8(this.n), this.F.P8(this.n), strI3, getActivity());
                    return;
                }
                if (i == -4) {
                    this.F.t9(this.n + "", getActivity());
                    return;
                }
            } catch (Exception e) {
                Log.d("edit_move_error=", ":" + e.getMessage());
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.customer_det_move_dialog, (ViewGroup) null);
        builder.setView(viewInflate);
        this.Q0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.from_cus_name);
        this.R0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.to_cus_name);
        EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        this.S0 = editText;
        this.z1 = editText;
        editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
        EditText editText2 = this.S0;
        editText2.addTextChangedListener(new C2018dE(editText2));
        this.S0.requestFocus();
        this.T0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
        this.X0 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
        this.a1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
        this.b1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        this.V0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
        this.f1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
        this.g1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
        this.i1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
        this.k1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
        this.l1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        this.S0.requestFocus();
        U0(z);
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setTitle(getActivity().getString(info.aalmoghalis.inventory.R.string.from_account) + "#" + this.z);
        alertDialogCreate.getWindow().setSoftInputMode(16);
        this.X0.setOnClickListener(new K(alertDialogCreate));
        this.a1.setOnClickListener(new L());
        this.b1.setOnClickListener(new M(z));
        alertDialogCreate.show();
    }

    public void Z() {
        if (Z00.Z) {
            ArrayList arrayListJ3 = this.F.j3();
            this.m1 = arrayListJ3;
            RadioButton[] radioButtonArr = new RadioButton[arrayListJ3.size()];
            this.l1.setTag(null);
            this.l1.removeAllViews();
            for (int i = 0; i < this.m1.size(); i++) {
                RadioButton radioButton = new RadioButton(getActivity());
                radioButtonArr[i] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.m1.get(i)).get("name"));
                radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.m1.get(i)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i].setOnClickListener(new R());
                this.l1.addView(radioButtonArr[i]);
                String str = this.w;
                if (str != null && str.equals(((HashMap) this.m1.get(i)).get("name"))) {
                    this.l1.check(radioButtonArr[i].getId());
                    this.l1.setTag(((HashMap) this.m1.get(i)).get("name"));
                }
                String str2 = this.j;
                if (str2 != null && str2.equals(((HashMap) this.m1.get(i)).get("name"))) {
                    this.l1.check(radioButtonArr[i].getId());
                    this.l1.setTag(((HashMap) this.m1.get(i)).get("name"));
                }
            }
        }
    }

    public final void Z0(List list) {
        Collections.sort(this.A, new N0(this, null));
    }

    public void a0() {
        C0783Nv c0783Nv = this.Z;
        if (c0783Nv == null) {
            C0783Nv c0783Nv2 = new C0783Nv(getActivity(), info.aalmoghalis.inventory.R.layout.customer_det_row3, this.A, null);
            this.Z = c0783Nv2;
            this.a0.setAdapter((ListAdapter) c0783Nv2);
        } else {
            c0783Nv.i.clear();
            this.Z.notifyDataSetChanged();
            I0(this.A);
            this.Z.notifyDataSetChanged();
            this.a0.setAdapter((ListAdapter) this.Z);
        }
    }

    public void amount_add_btn(View view) {
        X(true);
    }

    public void b0(Cursor cursor) {
        C0783Nv c0783Nv = this.Z;
        if (c0783Nv != null) {
            c0783Nv.notifyDataSetChanged();
        }
        try {
            if (this.J0 == 0) {
                T();
            }
            p0(1, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c1(View view) {
        if (this.c0 == 0) {
            X0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 1;
        } else {
            M0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 0;
        }
    }

    public void calc_pick_btn(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", this.z1.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void d0(int i) {
        String str;
        String str2;
        String str3;
        Log.d("footer_update=", this.h + ":" + i + ":" + this.J0);
        Log.d("footer_update=", this.h + ":" + i + ":" + this.J0);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        String str4 = "";
        if (this.J0 == 1) {
            double dO0 = o0(this.Z.d);
            this.k = numberFormat.format(dO0);
            if (dO0 >= 0.0d) {
                this.P.setImageResource(this.k0[2]);
                TextView textView = this.O;
                StringBuilder sb = new StringBuilder();
                sb.append(this.K0);
                sb.append(StringUtilities.LF);
                sb.append(this.r0);
                sb.append(numberFormat.format(dO0));
                sb.append(Z00.Z ? this.j : "");
                textView.setText(sb.toString());
                return;
            }
            this.P.setImageResource(this.k0[0]);
            TextView textView2 = this.O;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.K0);
            sb2.append(StringUtilities.LF);
            sb2.append(this.o0);
            sb2.append(numberFormat.format(dO0));
            sb2.append(Z00.Z ? this.j : "");
            textView2.setText(sb2.toString());
            return;
        }
        if (i != 1) {
            if (i == 2) {
                double dO1 = o0(this.Z.d);
                this.k = numberFormat.format(dO1);
                if (dO1 >= 0.0d) {
                    this.P.setImageResource(this.k0[2]);
                    TextView textView3 = this.O;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.r0);
                    sb3.append(numberFormat.format(dO1));
                    if (Z00.Z) {
                        str4 = " " + this.j;
                    }
                    sb3.append(str4);
                    textView3.setText(sb3.toString());
                    return;
                }
                this.P.setImageResource(this.k0[0]);
                TextView textView4 = this.O;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.o0);
                sb4.append(numberFormat.format(dO1));
                if (Z00.Z) {
                    str4 = " " + this.j;
                }
                sb4.append(str4);
                textView4.setText(sb4.toString());
                return;
            }
            return;
        }
        try {
            if (this.x1.size() <= 0) {
                TextView textView5 = this.O;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.n0);
                if (Z00.Z) {
                    str = " " + this.j;
                } else {
                    str = "";
                }
                sb5.append(str);
                textView5.setText(sb5.toString());
                return;
            }
            this.k = numberFormat.format(Double.parseDouble((String) this.x1.get(0)));
            if (Double.parseDouble((String) this.x1.get(0)) >= 0.0d) {
                this.P.setImageResource(this.k0[2]);
                TextView textView6 = this.O;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.r0);
                sb6.append(numberFormat.format(Double.parseDouble((String) this.x1.get(0))));
                if (Z00.Z) {
                    str3 = " " + this.j;
                } else {
                    str3 = "";
                }
                sb6.append(str3);
                textView6.setText(sb6.toString());
                return;
            }
            this.P.setImageResource(this.k0[0]);
            TextView textView7 = this.O;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.o0);
            sb7.append(numberFormat.format(Double.parseDouble((String) this.x1.get(0))));
            if (Z00.Z) {
                str2 = " " + this.j;
            } else {
                str2 = "";
            }
            sb7.append(str2);
            textView7.setText(sb7.toString());
        } catch (Exception unused) {
            TextView textView8 = this.O;
            StringBuilder sb8 = new StringBuilder();
            sb8.append(this.n0);
            if (Z00.Z) {
                str4 = " " + this.j;
            }
            sb8.append(str4);
            textView8.setText(sb8.toString());
        }
    }

    public void e1(View view) {
        if (this.c0 == 0) {
            Z0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 1;
        } else {
            J0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 0;
        }
    }

    public void f1(View view) {
        if (this.c0 == 0) {
            a1(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 1;
        } else {
            K0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 0;
        }
    }

    public void g1(View view) {
        if (this.c0 == 0) {
            b1(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 1;
        } else {
            L0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 0;
        }
    }

    public void h1() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Uri uriJ2 = this.F.J2(getActivity(), intent);
            this.F1 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.F1.getPath() + "");
            startActivityForResult(intent, this.A1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void help_btn(View view) {
        O0(((Integer) view.getTag()).intValue());
    }

    public boolean i0(String str, String str2, Context context) {
        HandlerC0664l0 handlerC0664l0 = new HandlerC0664l0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new v0(handlerC0664l0));
        builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new G0(handlerC0664l0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.D0;
    }

    public void i1(String str, String str2, String str3, String str4) {
        try {
            FragmentStatePagerSupport_Main.a0 = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_customer2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_call);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_group);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.F.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C0(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new D0(autoCompleteTextView));
            this.y1 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new E0());
            imageView2.setOnClickListener(new F0(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new H0());
            builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new I0());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new J0(editText2, autoCompleteTextView, str, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public boolean j0(String str, String str2, Context context) {
        x0 x0Var = new x0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new y0(x0Var));
        builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new z0(x0Var));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.D0;
    }

    public void j1(String str, String str2, String str3, String str4, String str5, String str6, Handler handler) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
            this.F.bd(getActivity(), autoCompleteTextView2);
            this.F.bd(getActivity(), autoCompleteTextView);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.setText(str4);
            autoCompleteTextView2.setText(str6);
            editText3.setText(str5);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.F.U5());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new C0645c(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.F.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C0647d(autoCompleteTextView2, editText2));
            this.y1 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC0649e());
            imageView2.setOnClickListener(new ViewOnClickListenerC0651f(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new ViewOnClickListenerC0653g(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC0655h());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC0657i());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC0659j(editText, autoCompleteTextView, autoCompleteTextView2, str, alertDialogCreate, editText2, editText3, handler));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean k0(String str, String str2, Context context) {
        K0 k0 = new K0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC0641a(k0));
        builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC0643b(k0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.E0;
    }

    public void k1() {
        a0();
        if (this.J0 == 1) {
            d0(1);
            Y0(this.A);
            this.Z.notifyDataSetChanged();
            this.c0 = 1;
        }
    }

    public void l0() {
        Cursor cursorQ3;
        K5 k5 = this;
        Log.d("get_all_names=", "Called:" + k5.g + ":" + k5.J0 + ":" + k5.K0 + ":" + k5.L0);
        int i = k5.J0;
        String str = CSS.Value.PERCENTAGE;
        if (i == 0) {
            cursorQ3 = k5.F.N3(k5.g, k5.j, CSS.Value.PERCENTAGE);
        } else {
            k5.K0 = k5.K0.isEmpty() ? CSS.Value.PERCENTAGE : k5.K0;
            if (!k5.L0.isEmpty()) {
                str = k5.L0;
            }
            String str2 = str;
            k5.L0 = str2;
            cursorQ3 = k5.F.Q3(k5.g, k5.K0, str2, k5.j, -1, -1, k5.J0, 0, "");
        }
        cursorQ3.getCount();
        I1 = 0.0d;
        k5.A.clear();
        cursorQ3.moveToFirst();
        while (!cursorQ3.isAfterLast()) {
            k5.A.add(new C4064uh(cursorQ3.getString(cursorQ3.getColumnIndex("_id")), cursorQ3.getString(cursorQ3.getColumnIndex("date_")), "" + cursorQ3.getDouble(cursorQ3.getColumnIndex("amount")), cursorQ3.getString(cursorQ3.getColumnIndex("remarks")) != null ? cursorQ3.getString(cursorQ3.getColumnIndex("remarks")) : "", k5.k0[cursorQ3.getInt(cursorQ3.getColumnIndex("_in"))], String.valueOf(cursorQ3.getInt(cursorQ3.getColumnIndex("_in"))), cursorQ3.getString(cursorQ3.getColumnIndex("param1")), cursorQ3.getString(cursorQ3.getColumnIndex("curr_name")), cursorQ3.getString(cursorQ3.getColumnIndex("bill_id")), cursorQ3.getString(cursorQ3.getColumnIndex("org_remarks")), cursorQ3.getString(cursorQ3.getColumnIndex("p_id")), cursorQ3.getString(cursorQ3.getColumnIndex("other_account"))));
            cursorQ3.moveToNext();
            k5 = this;
        }
        cursorQ3.close();
    }

    public void l1() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.customer_det_view, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            TextView textView3 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_time);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_type);
            ((TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks)).setText(this.t);
            textView2.setText(this.p);
            textView.setText(this.q);
            textView3.setText(this.F.S8(this.n));
            if (Z00.Z) {
                ((TableRow) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_curr_view)).setVisibility(0);
                ((TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_curr_name)).setText(this.w);
            }
            imageView2.setImageResource(this.v);
            if (this.u.equals("")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(Z00.p0(Z00.M + this.u, 300, 300));
                imageView.setTag(this.u);
                imageView.getLayoutParams().width = 200;
                imageView.getLayoutParams().height = 200;
            }
            builder.setCancelable(true);
            if (imageView.getTag() != null) {
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.view_image), new C(imageView));
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new D());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new E());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.h);
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("adv_search_error=", ":" + e.getMessage());
        }
    }

    public void m0() {
        V0(true);
        new Thread(new RunnableC0672p0()).start();
    }

    public void n0(String str) {
        C4143vg c4143vgQ4 = this.F.q4(str);
        if (c4143vgQ4.i().equals("")) {
            return;
        }
        this.g = c4143vgQ4.i();
        this.h = c4143vgQ4.j();
        this.l = c4143vgQ4.h();
        this.k = "0";
        this.i = c4143vgQ4.f();
        getActivity().setTitle(this.h);
    }

    public double o0(List list) {
        if (this.J0 == 1) {
            return I1;
        }
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.H0 = Snackbar.make(this.a0, "", -2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            getActivity();
            if (i2 != 0) {
                if (i == 1) {
                    getActivity();
                    if (i2 == -1) {
                        Cursor cursorQuery = getActivity().getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                        this.y1.setText(string);
                        cursorQuery.close();
                    }
                } else if (i == 2) {
                    if (intent != null) {
                        this.z1.setText(this.F.S7(intent.getStringExtra("calc_result")));
                    }
                } else if (i == this.B1 && intent != null) {
                    B0(intent.getData(), false);
                } else if (i == this.A1) {
                    x0(intent);
                }
            }
            C0974Ur c0974Ur = this.F.x;
            if (c0974Ur != null && !c0974Ur.l(i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
            }
        } catch (Exception unused) {
        }
        try {
            super.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.y0 = activity;
        try {
            this.H = (P0) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.A = this.Z.d;
        switch (view.getId()) {
            case info.aalmoghalis.inventory.R.id.img /* 2131296820 */:
                g1(view);
                break;
            case info.aalmoghalis.inventory.R.id.tr_amount /* 2131297456 */:
                c1(view);
                break;
            case info.aalmoghalis.inventory.R.id.tr_bal /* 2131297459 */:
                e1(view);
                break;
            case info.aalmoghalis.inventory.R.id.tr_date /* 2131297468 */:
                d1(view);
                break;
            case info.aalmoghalis.inventory.R.id.tr_remarks /* 2131297488 */:
                f1(view);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.g = getArguments() != null ? getArguments().getString("cus_id") : "";
            this.h = getArguments() != null ? getArguments().getString("cus_name") : "";
            this.l = getArguments() != null ? getArguments().getString("cus_gsm") : "";
            this.i = getArguments() != null ? getArguments().getString("g_name") : "";
            this.j = getArguments() != null ? getArguments().getString("curr_name") : "";
            this.k = getArguments() != null ? getArguments().getString("cus_bal") : "";
            this.C = (getArguments() != null ? Integer.valueOf(getArguments().getInt(CSS.Property.POSITION)) : null).intValue();
            this.D = (getArguments() != null ? Integer.valueOf(getArguments().getInt("size")) : null).intValue();
            this.B = getArguments() != null ? getArguments().getString("searchString") : "";
            this.K = getArguments() != null ? getArguments().getInt("size") : 0;
            Log.d("cus_name_oncreate=", this.h + ":" + this.K + ":" + this.C);
            this.F = new Z00(this.E, getActivity());
            getActivity().setTitle(this.h + "#" + getActivity().getString(info.aalmoghalis.inventory.R.string.cash_tran));
            this.I = this.F.ia("show_move_tr", "0").equals("1");
            this.J = this.F.ia("show_move_tr_name", "");
            this.J0 = getArguments() != null ? getArguments().getInt("adv_search") : 0;
            Bundle arguments = getArguments();
            String string = CSS.Value.PERCENTAGE;
            this.K0 = arguments != null ? getArguments().getString("f_date") : CSS.Value.PERCENTAGE;
            if (getArguments() != null) {
                string = getArguments().getString("t_date");
            }
            this.L0 = string;
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.d0 = calendar.get(1);
            this.e0 = calendar.get(2);
            this.f0 = calendar.get(5);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<C4064uh>> onCreateLoader(int i, Bundle bundle) {
        Log.d("trace_S_Loader_cus=", this.J0 + ":" + this.g + ":" + this.j);
        return new C0882Rh(getActivity(), this.g, this.j, this.F, CSS.Value.PERCENTAGE, this.J0, this.K0, this.L0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(info.aalmoghalis.inventory.R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) menu.findItem(info.aalmoghalis.inventory.R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getActivity().getString(info.aalmoghalis.inventory.R.string.search_hint));
        searchView.setOnQueryTextListener(new s0());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View viewInflate = layoutInflater.inflate(info.aalmoghalis.inventory.R.layout.activity_customer_det3_, viewGroup, false);
            Log.d("onCreateView", f0() + "#" + this.h);
            setHasOptionsMenu(true);
            this.y0 = getActivity();
            this.z0 = -1;
            this.O = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.footer_sum);
            this.P = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_add_amount);
            this.Q = imageView;
            imageView.setVisibility(8);
            this.Q.setOnClickListener(this.C0);
            this.A0 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.move_right);
            this.B0 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.move_left);
            this.A0.setOnClickListener(this.C0);
            this.B0.setOnClickListener(this.C0);
            if (this.K <= 1) {
                this.A0.setVisibility(8);
                this.B0.setVisibility(8);
            }
            this.U = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_date);
            this.V = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_amount);
            this.W = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_remarks);
            this.X = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_bal);
            this.U.setOnClickListener(this);
            this.V.setOnClickListener(this);
            this.W.setOnClickListener(this);
            this.X.setOnClickListener(this);
            this.P.setOnClickListener(this);
            this.U.setTextColor(-1);
            this.V.setTextColor(-1);
            this.W.setTextColor(-1);
            this.X.setTextColor(-1);
            this.l0 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_header);
            this.a0 = (ListView) viewInflate.findViewById(android.R.id.list);
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.activity_main_swipe_refresh_layout);
            this.x0 = swipeRefreshLayout;
            swipeRefreshLayout.setOnRefreshListener(new C0663l());
            TextView textView = (TextView) viewInflate.findViewById(android.R.id.empty);
            this.Y = textView;
            textView.setOnClickListener(this.C0);
            this.n0 = getActivity().getString(info.aalmoghalis.inventory.R.string.footer_cus_null);
            this.o0 = this.F.Q2() + ":-";
            this.r0 = this.F.c5() + ":-";
            this.p0 = this.F.Q2();
            this.q0 = this.F.c5();
            this.t0 = getActivity().getString(info.aalmoghalis.inventory.R.string.share_tr);
            this.u0 = getActivity().getString(info.aalmoghalis.inventory.R.string.hide_tr);
            this.s0 = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
            this.v0 = getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles4);
            this.w0 = getActivity().getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons4);
            this.a0.setChoiceMode(3);
            this.a0.setMultiChoiceModeListener(new C0680v());
            this.a0.setOnItemClickListener(new Q());
            try {
                Log.d("trace_view_V=", getUserVisibleHint() + ":" + this.h + ":" + this.H1 + ":" + isResumed());
                if (getUserVisibleHint()) {
                    S();
                }
            } catch (Exception e) {
                Log.d("details_oncreate", e.getMessage());
            }
            return viewInflate;
        } catch (Exception e2) {
            Log.d("oncreateview_err=", e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Log.d("trace_view_D=", this.h + ":" + getUserVisibleHint() + "::" + this.H1);
        this.H1 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == info.aalmoghalis.inventory.R.id.action1) {
            S0();
            return true;
        }
        if (itemId == info.aalmoghalis.inventory.R.id.adv_search) {
            u();
        } else {
            if (itemId == info.aalmoghalis.inventory.R.id.print) {
                if (Build.VERSION.SDK_INT < 31) {
                    x();
                }
                if (this.F.ja("prefPrintSort", true)) {
                    Y0(this.A);
                    this.Z.notifyDataSetChanged();
                    this.c0 = 1;
                }
                Log.d("cus_name_pdf=", this.h);
                if (Z00.Z) {
                    E0();
                } else {
                    Z00 z00 = this.F;
                    z00.Xa(this.a0, z00.ic(this.h), o0(this.Z.d));
                    this.F.ra(this.F.ic(this.h) + ".pdf");
                }
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action2) {
                O0(1);
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action_print_bills) {
                if (Build.VERSION.SDK_INT < 31) {
                    x();
                }
                D0();
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action3) {
                P();
                return true;
            }
            if (itemId == 16908332) {
                getActivity().finish();
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action_move) {
                v0(true);
                return true;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            v(getActivity().getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_storage));
            return;
        }
        if (i == 113) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            v(getActivity().getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_contacts));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Log.d("onresume=", this.J0 + "###" + this.h + ":" + this.K0);
        try {
            if (Bill_edit.P2) {
                String str = this.h;
                if (str == null || str.equals(Bill_edit.R2)) {
                    S();
                    Bill_edit.P2 = false;
                    Bill_edit.R2 = "";
                } else {
                    S();
                    Bill_edit.P2 = false;
                    Bill_edit.R2 = "";
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.M = Boolean.TRUE;
        if (this.N.booleanValue()) {
            this.M.booleanValue();
        }
    }

    public void p0(int i, int i2) {
        try {
            new Handler().postDelayed(new RunnableC0666m0(i), i2);
        } catch (Exception unused) {
        }
    }

    public void r() {
        Intent intent = new Intent(getActivity(), (Class<?>) FragmentStatePagerSupport.class);
        intent.putExtra("screen_no", "11");
        intent.putExtra("CUS_ID", this.g);
        intent.putExtra("CUS_BAL", "0");
        intent.putExtra("CUS_GSM", "");
        intent.putExtra("CUS_NAME", this.h);
        intent.putExtra("g_id", "0");
        intent.putExtra("g_name", this.i);
        intent.putExtra("title_", "");
        intent.putExtra("CURR_NAME", this.j);
        intent.putExtra("adv_search", 1);
        String strF5 = this.F.f5(0);
        intent.putExtra("f_date", strF5);
        intent.putExtra("t_date", strF5);
        startActivity(intent);
        getActivity().finish();
    }

    public void s(Handler handler) {
        String string = this.Q0.getText().toString();
        String strT5 = this.i;
        if (strT5 == null) {
            strT5 = this.F.T5("0");
        }
        j1("0", string, "", strT5, "", "", handler);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Log.d("trace_view_S=", this.h + ":" + getUserVisibleHint() + ":" + z + ":" + this.H1 + ":" + isResumed());
        if (z && this.h != null && isResumed()) {
            S();
        }
    }

    public void t(Handler handler) {
        String string = this.R0.getText().toString();
        String strT5 = this.i;
        if (strT5 == null) {
            strT5 = this.F.T5("0");
        }
        j1("0", string, "", strT5, "", "", handler);
    }

    public void u() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_report_input4, (ViewGroup) null);
            builder.setView(viewInflate);
            this.M0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.f_date);
            this.N0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.t_date);
            this.O0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tv_curr);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.F.C3());
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.F.s3());
            TextView textView = this.M0;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            TextView textView2 = this.O0;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            this.M0.setText(this.h);
            this.N0.setHint(getActivity().getString(info.aalmoghalis.inventory.R.string.date2));
            this.N0.setText(this.L0);
            this.O0.setText(this.j);
            this.M0.setOnClickListener(new ViewOnClickListenerC0677s(arrayAdapter));
            this.O0.setOnClickListener(new ViewOnClickListenerC0678t(arrayAdapter2));
            this.N0.setOnClickListener(new ViewOnClickListenerC0679u());
            builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_search), new DialogInterfaceOnClickListenerC0681w());
            builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_cancel), new DialogInterfaceOnClickListenerC0682x());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC0683y(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void u0() {
        try {
            this.Q0.requestFocus();
            this.V0.setText((CharSequence) null);
            this.b1.setTag(null);
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.move_inserted), 0).show();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), 1).show();
            Log.d("move_transaction", e.getMessage());
        }
    }

    public void v0(boolean z) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.F).l("-9", z ? "new" : "edit")) {
                Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.customer_det_move_dialog, (ViewGroup) null);
            builder.setView(viewInflate);
            this.Q0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.from_cus_name);
            this.R0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.to_cus_name);
            if (this.I && this.J.equals(this.h)) {
                this.Q0.setText("");
                this.Q0.requestFocus();
            } else {
                this.Q0.setText(this.h);
                this.R0.requestFocus();
            }
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.S0 = editText;
            this.z1 = editText;
            editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
            EditText editText2 = this.S0;
            editText2.addTextChangedListener(new C2018dE(editText2));
            this.T0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.X0 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
            this.a1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
            this.b1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            this.V0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.f1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
            this.g1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.i1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
            this.k1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
            this.l1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
            U0(z);
            builder.setCancelable(true);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            this.X0.setOnClickListener(new N(alertDialogCreate));
            this.a1.setOnClickListener(new O());
            this.b1.setOnClickListener(new P(z));
            alertDialogCreate.getWindow().getAttributes().gravity = 48;
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("move_transaction_error=", ":" + e.getMessage());
        }
    }

    public void w(View view) {
        v0(true);
    }

    public void w0(View view) {
        m0();
    }

    public void x() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void y() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, List list) {
        Log.d("Loader=", "onLoadFinished:" + this.g + ":" + this.h + ":" + isResumed() + ":" + this.M + ":" + getUserVisibleHint());
        StringBuilder sb = new StringBuilder();
        sb.append(FragmentStatePagerSupport_Main.X());
        sb.append(":");
        sb.append(this.g);
        sb.append(":");
        sb.append(this.j);
        Log.d("trace_E_Loader_cus=", sb.toString());
        try {
            this.A = list;
            this.a0.setEmptyView(this.Y);
            C0783Nv c0783Nv = new C0783Nv(getActivity(), info.aalmoghalis.inventory.R.layout.customer_det_row3, this.A, null);
            this.Z = c0783Nv;
            this.a0.setAdapter((ListAdapter) c0783Nv);
            p0(0, 5);
            if (this.I && this.J.equals(this.h)) {
                this.F.Lc("show_move_tr", "0");
                v0(true);
            }
        } catch (Exception unused) {
        }
    }

    public void z(View view, boolean z) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.F).l("-9", z ? "new" : "edit")) {
                Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        if (z) {
            N0();
        } else {
            V();
        }
    }

    public void z0(String str) {
        try {
            this.Z.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: K5$c0, reason: case insensitive filesystem */
    public class C0646c0 implements TextWatcher {
        public C0646c0() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= 0) {
                K5.this.Q0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                K5 k5 = K5.this;
                k5.Q0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(k5.getActivity(), android.R.drawable.ic_notification_clear_all), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: K5$e0, reason: case insensitive filesystem */
    public class C0650e0 implements TextWatcher {
        public C0650e0() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= 0) {
                K5.this.R0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                K5 k5 = K5.this;
                k5.R0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(k5.getActivity(), android.R.drawable.ic_notification_clear_all), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: K5$f0, reason: case insensitive filesystem */
    public class C0652f0 implements TextWatcher {
        public C0652f0() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            K5.this.G0();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: K5$k, reason: case insensitive filesystem */
    public class C0661k implements LoaderManager.LoaderCallbacks {
        public C0661k() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader loader, List list) {
            K5.this.x1 = (ArrayList) list;
            Log.d("trace_E_Loader_footer=", FragmentStatePagerSupport_Main.X() + ":" + K5.this.g + ":" + K5.this.j + ":" + K5.this.x1.size() + ":" + list.size() + "###" + K5.this.J0);
            try {
                K5 k5 = K5.this;
                if (k5.J0 == 0) {
                    k5.d0(1);
                }
            } catch (Exception e) {
                Log.d("footer_err=", e.getMessage());
            }
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            Log.d("trace_S_Loader_footer=", FragmentStatePagerSupport_Main.X() + ":" + K5.this.g + ":" + K5.this.j);
            FragmentActivity activity = K5.this.getActivity();
            K5 k5 = K5.this;
            return new C0550Gn(activity, k5.h, k5.j, k5.F);
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<C4064uh>> loader) {
    }

    /* JADX INFO: renamed from: K5$v, reason: case insensitive filesystem */
    public class C0680v implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: K5$v$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    K5.this.U();
                } catch (Exception unused) {
                    Toast.makeText(K5.this.getActivity(), "SQL Error.", 1);
                }
            }
        }

        public C0680v() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case info.aalmoghalis.inventory.R.id.menu_delete /* 2131297039 */:
                    SparseBooleanArray sparseBooleanArrayB = K5.this.Z.b();
                    K5 k5 = K5.this;
                    k5.b0 = sparseBooleanArrayB;
                    AlertDialog.Builder builder = new AlertDialog.Builder(k5.getActivity());
                    builder.setMessage(K5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.delete_msg));
                    builder.setPositiveButton(K5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
                    builder.setNegativeButton(K5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB2 = K5.this.Z.b();
                    K5 k6 = K5.this;
                    k6.b0 = sparseBooleanArrayB2;
                    k6.W();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_share /* 2131297045 */:
                    SparseBooleanArray sparseBooleanArrayB3 = K5.this.Z.b();
                    K5 k7 = K5.this;
                    k7.b0 = sparseBooleanArrayB3;
                    k7.Q0();
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
            K5.this.a0.setBackgroundColor(Color.parseColor("#FFFFFF"));
            K5.this.Z.i.clear();
            K5.this.Z.e();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = K5.this.a0.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            K5.this.Z.g(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (K5.this.a0.getCheckedItemCount() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        /* JADX INFO: renamed from: K5$v$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }
    }

    public class B implements DialogInterface.OnClickListener {
        public B() {
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

    public class H0 implements DialogInterface.OnClickListener {
        public H0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class I0 implements DialogInterface.OnClickListener {
        public I0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: K5$h, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0655h implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0655h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: K5$i, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0657i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0657i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: K5$r0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0676r0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0676r0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: K5$w, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0681w implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0681w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public K5(int i, int i2, ArrayList arrayList, String str, boolean z) {
        Boolean bool = Boolean.FALSE;
        this.M = bool;
        this.N = bool;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.c0 = 0;
        this.k0 = new int[]{info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
        this.l0 = null;
        this.m0 = new C0661k();
        this.n0 = "";
        this.o0 = "";
        this.p0 = "";
        this.q0 = "";
        this.r0 = "";
        this.s0 = 0;
        this.t0 = "";
        this.u0 = "";
        this.z0 = -1;
        this.C0 = new ViewOnClickListenerC0642a0();
        this.F0 = 0;
        this.G0 = "";
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = CSS.Value.PERCENTAGE;
        this.L0 = CSS.Value.PERCENTAGE;
        this.M0 = null;
        this.N0 = null;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = null;
        this.R0 = null;
        this.S0 = null;
        this.T0 = null;
        this.U0 = null;
        this.V0 = null;
        this.W0 = null;
        this.X0 = null;
        this.Y0 = null;
        this.Z0 = null;
        this.a1 = null;
        this.b1 = null;
        this.c1 = null;
        this.d1 = null;
        this.e1 = null;
        this.f1 = null;
        this.g1 = null;
        this.h1 = null;
        this.i1 = null;
        this.j1 = null;
        this.k1 = null;
        this.l1 = null;
        this.m1 = new ArrayList();
        this.o1 = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.p1 = new S();
        this.q1 = new T();
        this.r1 = new U();
        this.s1 = new V();
        this.t1 = null;
        this.u1 = new HandlerC0668n0();
        this.v1 = "";
        this.w1 = null;
        this.x1 = new ArrayList();
        this.A1 = 3;
        this.B1 = 4;
        this.D1 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: J5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.a.t0((Uri) obj);
            }
        });
        this.E1 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new w0());
        this.G1 = "";
        this.H1 = false;
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", FragmentStatePagerSupport.D);
        bundle.putString("cus_name", FragmentStatePagerSupport.L);
        bundle.putString("cus_bal", "0");
        bundle.putString("cus_gsm", FragmentStatePagerSupport.K);
        bundle.putString("g_name", FragmentStatePagerSupport.F);
        bundle.putString("curr_name", FragmentStatePagerSupport.G);
        bundle.putInt("adv_search", FragmentStatePagerSupport.R);
        bundle.putString("f_date", FragmentStatePagerSupport.O);
        bundle.putString("t_date", FragmentStatePagerSupport.P);
        bundle.putInt(CSS.Property.POSITION, i);
        bundle.putInt("size", i2);
        bundle.putString("searchString", str);
        setArguments(bundle);
    }
}
