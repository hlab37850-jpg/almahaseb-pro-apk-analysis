package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.app.TimePickerDialog;
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
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.CombinedLoadStates;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import info.aalmoghalis.inventory.old.CusLimit_edit;
import info.aalmoghalis.inventory.old.Reminders;
import info.aalmoghalis.inventory.printBT.MainActivity;
import info.aalmoghalis.inventory.printBT.MainActivity2;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class F5 extends Fragment implements View.OnClickListener, C4330y1.c, DE {
    public static double c2;
    public String A0;
    public DatePickerDialog.OnDateSetListener A1;
    public String B0;
    public DatePickerDialog.OnDateSetListener B1;
    public int C;
    public int C0;
    public DatePickerDialog.OnDateSetListener C1;
    public int D;
    public String D0;
    public ActionMode D1;
    public SQLiteDatabase E;
    public String E0;
    public T0 E1;
    public Z00 F;
    public String[] F0;
    public Dialog F1;
    public E00 G;
    public TypedArray G0;
    public Handler G1;
    public SwipeRefreshLayout H0;
    public String H1;
    public Activity I0;
    public Cursor I1;
    public int J0;
    public ArrayList J1;
    public String K0;
    public int K1;
    public Boolean L;
    public View.OnClickListener L0;
    public SearchView L1;
    public Boolean M;
    public boolean M0;
    public boolean M1;
    public TextView N;
    public boolean N0;
    public final Handler N1;
    public TextView O;
    public int O0;
    public EditText O1;
    public TextView P;
    public String P0;
    public EditText P1;
    public TextView Q;
    public Snackbar Q0;
    public int Q1;
    public LinearLayout R;
    public int R0;
    public int R1;
    public LinearLayout S;
    public int S0;
    public String S1;
    public View T;
    public String T0;
    public ActivityResultLauncher T1;
    public ImageView U;
    public String U0;
    public ActivityResultLauncher U1;
    public ImageView V;
    public TextView V0;
    public Uri V1;
    public ImageView W;
    public TextView W0;
    public String W1;
    public ImageView X;
    public TextView X0;
    public TextView X1;
    public ImageView Y;
    public AutoCompleteTextView Y0;
    public TextView Y1;
    public TextView Z;
    public AutoCompleteTextView Z0;
    public DatePickerDialog.OnDateSetListener Z1;
    public TextView a0;
    public EditText a1;
    public TimePickerDialog.OnTimeSetListener a2;
    public TextView b0;
    public TextView b1;
    public boolean b2;
    public TextView c0;
    public TextView c1;
    public TextView d0;
    public AutoCompleteTextView d1;
    public C4330y1 e0;
    public AutoCompleteTextView e1;
    public RecyclerView f0;
    public Button f1;
    public SparseBooleanArray g0;
    public Button g1;
    public int h0;
    public Button h1;
    public int i0;
    public ImageView i1;
    public int j0;
    public ImageView j1;
    public int k0;
    public ImageView k1;
    public int l0;
    public RadioGroup l1;
    public int m0;
    public RadioButton m1;
    public String[] n0;
    public RadioButton n1;
    public TypedArray o0;
    public LinearLayout o1;
    public List p0;
    public LinearLayout p1;
    public C4062ug q0;
    public LinearLayout q1;
    public int[] r0;
    public LinearLayout r1;
    public LinearLayout s0;
    public LinearLayout s1;
    public C0990Vh t0;
    public LinearLayout t1;
    public int u0;
    public RadioGroup u1;
    public int v0;
    public ArrayList v1;
    public String w0;
    public ArrayList w1;
    public String x0;
    public ArrayAdapter x1;
    public String y0;
    public String[] y1;
    public String z0;
    public DatePickerDialog.OnDateSetListener z1;
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
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public boolean I = false;
    public String J = "";
    public boolean K = false;

    public class A implements DialogInterface.OnClickListener {
        public A() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                F5.this.S0 = 0;
                dialogInterface.dismiss();
                F5.this.V0();
            } catch (Exception unused) {
            }
        }
    }

    public class A0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ String[] a;

        public A0(String[] strArr) {
            this.a = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(F5.this.getActivity());
                if (this.a[i].equals(F5.this.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0])) {
                    F5 f5 = F5.this;
                    f5.S1 = f5.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        F5.this.o0();
                    }
                } else if (this.a[i].equals(F5.this.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1])) {
                    F5 f6 = F5.this;
                    f6.S1 = f6.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        F5.this.N0();
                    }
                } else if (this.a[i].equals(F5.this.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[0])) {
                    F5.this.F.qa(Z00.M + F5.this.k1.getTag().toString());
                } else if (this.a[i].equals(F5.this.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image)[1])) {
                    F5.this.k1.setTag(null);
                    F5.this.k1.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
                    F5.this.k1.getLayoutParams().width = (int) F5.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                    F5.this.k1.getLayoutParams().height = (int) F5.this.getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
                }
            } catch (Exception unused) {
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
            try {
                F5 f5 = F5.this;
                f5.S0 = 1;
                if (f5.V0.getText() == null) {
                    F5.this.T0 = "";
                } else {
                    F5 f6 = F5.this;
                    f6.T0 = f6.V0.getText().toString();
                }
                if (F5.this.W0.getText() == null) {
                    F5.this.U0 = "";
                } else {
                    F5 f7 = F5.this;
                    f7.U0 = f7.W0.getText().toString();
                }
                this.a.dismiss();
                F5.this.V0();
            } catch (Exception unused) {
            }
        }
    }

    public class B0 implements ActivityResultCallback {
        public B0() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(Boolean bool) {
            if (bool.booleanValue()) {
                F5.this.r2();
            }
        }
    }

    public class C implements View.OnClickListener {
        public C() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", F5.this.i0);
                bundle.putInt("month", F5.this.j0);
                bundle.putInt("day", F5.this.k0);
                c2137ei.setArguments(bundle);
                c2137ei.f(F5.this.B1);
                c2137ei.show(F5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    public class C0 extends Handler {
        public C0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class D implements DialogInterface.OnClickListener {
        public D() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (Build.VERSION.SDK_INT < 31) {
                    F5.this.d0();
                }
                if (F5.this.W0.getText() != null && !F5.this.W0.getText().toString().isEmpty()) {
                    F5 f5 = F5.this;
                    f5.U0 = f5.W0.getText().toString();
                    F5 f6 = F5.this;
                    f6.S0 = 1;
                    boolean zIsEmpty = f6.T0.isEmpty();
                    String str = CSS.Value.PERCENTAGE;
                    f6.T0 = zIsEmpty ? CSS.Value.PERCENTAGE : F5.this.T0;
                    F5 f7 = F5.this;
                    if (!f7.U0.isEmpty()) {
                        str = F5.this.U0;
                    }
                    f7.U0 = str;
                    F5.this.A0(5);
                    new DateFormat();
                    return;
                }
                Toast.makeText(F5.this.getActivity(), "Closing date is required.", 1).show();
            } catch (Exception unused) {
                Toast.makeText(F5.this.getActivity(), "SQL Error.", 1);
            }
        }
    }

    public class D0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public D0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            F5.this.F.v0("insert into groups  (name )  values( '" + F5.this.W1 + "'  )");
            F5.this.M0 = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class E0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public E0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            F5.this.M0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class F implements DialogInterface.OnClickListener {
        public final /* synthetic */ ImageView a;

        public F(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                F5.this.F.qa(Z00.M + this.a.getTag().toString());
            } catch (Exception unused) {
                Toast.makeText(F5.this.getActivity(), "SQL Error.", 1);
            }
        }
    }

    public class F0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public F0(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    public class G implements DialogInterface.OnClickListener {
        public G() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                int i2 = C2160f10.h;
                if (i2 > 0 && i2 != new C2160f10(F5.this.F).K(String.valueOf(F5.this.n))) {
                    Toast.makeText(F5.this.getActivity(), F5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.priv_other_user), 0).show();
                    return;
                }
                int i3 = F5.this.x.equals("") ? 0 : Integer.parseInt(F5.this.x);
                Log.d("bill_id=", i3 + "");
                if (i3 > 0) {
                    F5 f5 = F5.this;
                    f5.F.n9(f5.x, f5.getActivity(), 1);
                    return;
                }
                if (i3 == -2) {
                    Bill_edit.R2 = F5.this.h;
                    String strI = new C2160f10(F5.this.F).I(F5.this.n + "");
                    F5 f6 = F5.this;
                    Z00 z00 = f6.F;
                    String strQ8 = z00.Q8(f6.n);
                    F5 f7 = F5.this;
                    z00.r9(strQ8, f7.F.P8(f7.n), strI, F5.this.getActivity());
                    return;
                }
                if (i3 == -3) {
                    Bill_edit.R2 = F5.this.h;
                    String strI2 = new C2160f10(F5.this.F).I(F5.this.n + "");
                    F5 f8 = F5.this;
                    Z00 z01 = f8.F;
                    String strQ9 = z01.Q8(f8.n);
                    F5 f9 = F5.this;
                    String strH8 = f9.F.H8(f9.n);
                    F5 f10 = F5.this;
                    z01.s9(strQ9, strH8, f10.F.P8(f10.n), strI2, F5.this.getActivity());
                    return;
                }
                if (i3 == -6) {
                    Bill_edit.R2 = F5.this.h;
                    String strI3 = new C2160f10(F5.this.F).I(F5.this.n + "");
                    F5 f11 = F5.this;
                    Z00 z02 = f11.F;
                    String strQ10 = z02.Q8(f11.n);
                    F5 f12 = F5.this;
                    String strH9 = f12.F.H8(f12.n);
                    F5 f13 = F5.this;
                    z02.p9(strQ10, strH9, f13.F.P8(f13.n), strI3, F5.this.getActivity());
                    return;
                }
                if (i3 == -4) {
                    F5.this.F.t9(F5.this.n + "", F5.this.getActivity());
                    return;
                }
                F5 f14 = F5.this;
                if (f14.F.O8(f14.n).equals("0")) {
                    F5.this.F0(false);
                    return;
                }
                F5 f15 = F5.this;
                f15.t = f15.F.R8(f15.n);
                F5 f16 = F5.this;
                f16.z = f16.h;
                f16.y = f16.F.T8(f16.n);
                F5 f17 = F5.this;
                if (f17.y.equals(f17.h)) {
                    F5 f18 = F5.this;
                    f18.z = f18.F.N8(f18.n);
                }
                F5.this.G0(false);
            } catch (Exception e) {
                Log.d("View_item_error=", e.getMessage());
            }
        }
    }

    public class G0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public G0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class H0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public H0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            F5.this.Y(this.a);
        }
    }

    public class I implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public I(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5 f5 = F5.this;
            if (f5.h0(f5.g1.getId())) {
                this.a.dismiss();
                F5.this.V0();
                F5.this.o2();
            }
        }
    }

    public class I0 implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public I0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class J implements Observer {
        public J() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List list) {
            F5 f5 = F5.this;
            f5.J1 = (ArrayList) list;
            f5.M0(1);
        }
    }

    public class J0 implements View.OnClickListener {
        public J0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.O1(view);
        }
    }

    public class K implements View.OnClickListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                F5.this.H0.setRefreshing(true);
                F5.this.X1();
                F5.this.H0.setRefreshing(false);
            }
        }

        public K() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new Handler().post(new a());
        }
    }

    public class K0 implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public K0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.u0(this.a, this.b);
        }
    }

    public class L implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public L(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5 f5 = F5.this;
            if (f5.h0(f5.h1.getId())) {
                this.a.dismiss();
                F5.this.V0();
                F5.this.o2();
            }
        }
    }

    public class M implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public M(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (F5.this.j0()) {
                this.a.dismiss();
                F5.this.V0();
            }
        }
    }

    public class N implements View.OnClickListener {
        public N() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.calc_pick_btn(view);
        }
    }

    public class N0 implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ AlertDialog e;

        public N0(EditText editText, AutoCompleteTextView autoCompleteTextView, String str, EditText editText2, AlertDialog alertDialog) {
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
            if (F5.this.F.P5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                F5.this.W1 = this.b.getText().toString();
                F5 f5 = F5.this;
                f5.S0(f5.getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_group), F5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + F5.this.W1, F5.this.getActivity());
                if (!F5.this.M0) {
                    return;
                }
            }
            if (zA) {
                if (this.c != null) {
                    F5.this.F.v0("update customers set name='" + this.d.getText().toString() + "',gsm='" + this.a.getText().toString() + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + F5.this.g + "'");
                    F5.this.l = this.a.getText().toString();
                    F5 f6 = F5.this;
                    int i = f6.R0;
                    if (i == 1) {
                        f6.F.n0(this.a.getText().toString());
                    } else if (i == 2) {
                        Z00 z00 = f6.F;
                        String string = this.a.getText().toString();
                        F5 f7 = F5.this;
                        z00.Rc(string, f7.F.vd(f7.f0, f7.h, f7.X0(f7.e0.c())));
                    } else if (i == 3) {
                        Z00 z01 = f6.F;
                        String string2 = this.a.getText().toString();
                        F5 f8 = F5.this;
                        Z00 z02 = f8.F;
                        C4064uh c4064uhK0 = f8.K0();
                        F5 f9 = F5.this;
                        z01.Rc(string2, z02.zd(c4064uhK0, f9.h, f9.X0(f9.e0.c())));
                    } else if (i == 4) {
                        Z00 z03 = f6.F;
                        String string3 = this.a.getText().toString();
                        F5 f10 = F5.this;
                        Z00 z04 = f10.F;
                        C4064uh c4064uhK1 = f10.K0();
                        F5 f11 = F5.this;
                        z03.Ed(string3, z04.zd(c4064uhK1, f11.h, f11.X0(f11.e0.c())));
                    } else if (i == 5) {
                        f6.c2(2);
                    } else if (i == 6) {
                        f6.F.Ed(this.a.getText().toString(), F5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.sms_header) + F5.this.k);
                    } else if (i == 7) {
                        Z00 z05 = f6.F;
                        String string4 = this.a.getText().toString();
                        StringBuilder sb = new StringBuilder();
                        sb.append(F5.this.F.ic(F5.this.h + "-" + F5.this.getString(info.aalmoghalis.inventory.R.string.approval)));
                        sb.append(".pdf");
                        z05.Hd(string4, sb.toString());
                    } else {
                        f6.F.Rc(this.a.getText().toString(), F5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.sms_header) + F5.this.k);
                    }
                }
                this.e.dismiss();
            }
        }
    }

    public class O implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public O(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.f0(view, this.a);
        }
    }

    public class O0 implements View.OnClickListener {
        public O0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2056di c2056di = new C2056di();
            Bundle bundle = new Bundle();
            bundle.putInt("year", F5.this.i0);
            bundle.putInt("month", F5.this.j0);
            bundle.putInt("day", F5.this.k0);
            c2056di.setArguments(bundle);
            c2056di.f(F5.this.Z1);
            c2056di.show(F5.this.getActivity().getSupportFragmentManager(), "datePicker");
        }
    }

    public class P implements View.OnClickListener {
        public P() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.s2();
        }
    }

    public class P0 implements View.OnClickListener {
        public P0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IU iu = new IU();
            Bundle bundle = new Bundle();
            bundle.putInt("hour", F5.this.l0);
            bundle.putInt("minute", F5.this.m0);
            iu.setArguments(bundle);
            iu.f(F5.this.a2);
            iu.show(F5.this.getActivity().getSupportFragmentManager(), "datePicker");
        }
    }

    public class Q implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public Q(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (F5.this.k0()) {
                this.a.dismiss();
                F5.this.V0();
            }
        }
    }

    public class Q0 implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public Q0(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class R implements View.OnClickListener {
        public R() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.calc_pick_btn(view);
        }
    }

    public class S implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public S(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.f0(view, this.a);
        }
    }

    public class S0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public S0(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            F5.this.M0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class T implements View.OnClickListener {
        public T() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.s2();
        }
    }

    public class T0 implements ActionMode.Callback {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    F5.this.C0();
                } catch (Exception unused) {
                    Toast.makeText(F5.this.getActivity(), "SQL Error.", 1);
                }
            }
        }

        public T0() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case info.aalmoghalis.inventory.R.id.menu_delete /* 2131297039 */:
                    SparseBooleanArray sparseBooleanArrayE = F5.this.e0.e();
                    F5 f5 = F5.this;
                    f5.g0 = sparseBooleanArrayE;
                    AlertDialog.Builder builder = new AlertDialog.Builder(f5.getActivity());
                    builder.setMessage(F5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.delete_msg));
                    builder.setPositiveButton(F5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new a());
                    builder.setNegativeButton(F5.this.getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayE2 = F5.this.e0.e();
                    F5 f6 = F5.this;
                    f6.g0 = sparseBooleanArrayE2;
                    f6.E0();
                    actionMode.finish();
                    break;
                case info.aalmoghalis.inventory.R.id.menu_share /* 2131297045 */:
                    SparseBooleanArray sparseBooleanArrayE3 = F5.this.e0.e();
                    F5 f7 = F5.this;
                    f7.g0 = sparseBooleanArrayE3;
                    f7.e2();
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
            F5.this.f0.setBackgroundColor(Color.parseColor("#FFFFFF"));
            F5.this.e0.g.clear();
            F5.this.e0.j();
            F5.this.D1 = null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (F5.this.e0.d() != 1) {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(info.aalmoghalis.inventory.R.id.menu_edit).setVisible(true);
            }
            return false;
        }

        public /* synthetic */ T0(F5 f5, C0491o c0491o) {
            this();
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }
    }

    public class U implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public U(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (F5.this.i0()) {
                F5 f5 = F5.this;
                if (f5.I) {
                    f5.E1();
                    F5.this.V0();
                } else {
                    this.a.dismiss();
                    F5.this.V0();
                    F5.this.o2();
                }
            }
        }
    }

    public class U0 implements Comparator {
        public U0() {
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

        public /* synthetic */ U0(F5 f5, C0491o c0491o) {
            this();
        }
    }

    public class V implements SwipeRefreshLayout.OnRefreshListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                F5.this.X1();
                F5.this.H0.setRefreshing(false);
            }
        }

        public V() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            new Handler().post(new a());
        }
    }

    public class V0 implements Comparator {
        public V0() {
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

        public /* synthetic */ V0(F5 f5, C0491o c0491o) {
            this();
        }
    }

    public class W implements View.OnClickListener {
        public W() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.calc_pick_btn(view);
        }
    }

    public class X implements View.OnClickListener {
        public final /* synthetic */ boolean a;

        public X(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.f0(view, this.a);
        }
    }

    public class Y implements View.OnClickListener {
        public Y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.L1(view);
        }
    }

    public class Z implements DatePickerDialog.OnDateSetListener {
        public Z() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + i;
            Locale locale = Locale.ENGLISH;
            try {
                F5.this.b1.setText(new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(str).getTime())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: F5$a0, reason: case insensitive filesystem */
    public class C0464a0 implements DatePickerDialog.OnDateSetListener {
        public C0464a0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                F5.this.V0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                F5 f5 = F5.this;
                f5.T0 = f5.V0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: F5$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0465b implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ AlertDialog c;

        public ViewOnClickListenerC0465b(AutoCompleteTextView autoCompleteTextView, EditText editText, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = editText;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (F5.this.F.u3(this.a.getText().toString()) == 0) {
                Toast.makeText(F5.this.getActivity(), info.aalmoghalis.inventory.R.string.cus_not_found, 1).show();
                zA = false;
            }
            if (zA) {
                F5.this.F.v0("insert into reminders  (cus_id,date_,time_,remarks )  values( (select id from customers where name='" + this.a.getText().toString() + "'),'" + F5.this.X1.getText().toString() + "','" + F5.this.Y1.getText().toString() + "','" + this.b.getText().toString() + "'  )");
                this.c.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: F5$b0, reason: case insensitive filesystem */
    public class C0466b0 implements DatePickerDialog.OnDateSetListener {
        public C0466b0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                F5.this.W0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                F5 f5 = F5.this;
                f5.U0 = f5.W0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: F5$c, reason: case insensitive filesystem */
    public class C0467c implements DatePickerDialog.OnDateSetListener {
        public C0467c() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            F5.this.i0 = i;
            F5.this.j0 = i2;
            F5.this.k0 = i3;
            String str = F5.this.i0 + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(F5.this.j0 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(F5.this.k0));
            Locale locale = Locale.ENGLISH;
            try {
                F5.this.X1.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: F5$c0, reason: case insensitive filesystem */
    public class C0468c0 implements DatePickerDialog.OnDateSetListener {
        public C0468c0() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                F5.this.X0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: F5$d, reason: case insensitive filesystem */
    public class C0469d implements TimePickerDialog.OnTimeSetListener {
        public C0469d() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            F5.this.l0 = i;
            F5.this.m0 = i2;
            TextView textView = F5.this.Y1;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.ENGLISH;
            sb.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(F5.this.l0)));
            sb.append(":");
            sb.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(F5.this.m0)));
            textView.setText(sb.toString());
        }
    }

    /* JADX INFO: renamed from: F5$d0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0470d0 implements View.OnClickListener {
        public ViewOnClickListenerC0470d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", F5.this.i0);
                bundle.putInt("month", F5.this.j0);
                bundle.putInt("day", F5.this.k0);
                c2137ei.setArguments(bundle);
                c2137ei.f(F5.this.z1);
                c2137ei.show(F5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(F5.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: F5$e, reason: case insensitive filesystem */
    public class HandlerC0471e extends Handler {
        public HandlerC0471e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: F5$e0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0472e0 implements View.OnClickListener {
        public ViewOnClickListenerC0472e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", F5.this.i0);
                bundle.putInt("month", F5.this.j0);
                bundle.putInt("day", F5.this.k0);
                c2137ei.setArguments(bundle);
                c2137ei.f(F5.this.z1);
                c2137ei.show(F5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Log.d("Date error=", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: F5$f, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0473f implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC0473f(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            F5.this.Z(this.a);
            F5 f5 = F5.this;
            f5.N0 = f5.M0;
        }
    }

    /* JADX INFO: renamed from: F5$f0, reason: case insensitive filesystem */
    public class C0474f0 implements AdapterView.OnItemClickListener {
        public C0474f0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            F5.this.Y0.setText(adapterView.getItemAtPosition(i).toString());
            F5.this.Y1();
            F5.this.Z0.requestFocus();
        }
    }

    /* JADX INFO: renamed from: F5$g, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0475g implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public DialogInterfaceOnClickListenerC0475g(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            F5.this.N0 = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    /* JADX INFO: renamed from: F5$g0, reason: case insensitive filesystem */
    public class C0476g0 implements AdapterView.OnItemClickListener {
        public C0476g0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            F5.this.Z0.setText(adapterView.getItemAtPosition(i).toString());
            F5.this.Y1();
            F5.this.a1.requestFocus();
        }
    }

    /* JADX INFO: renamed from: F5$h, reason: case insensitive filesystem */
    public class C0477h implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C0477h(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: F5$h0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC0478h0 implements View.OnTouchListener {
        public ViewOnTouchListenerC0478h0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            F5.this.Y0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (F5.this.Y0.getCompoundDrawables()[0] != null ? F5.this.Y0.getCompoundDrawables()[0].getBounds().width() : 0) + F5.this.Y0.getPaddingLeft() + F5.this.Y0.getLeft()) {
                    F5.this.Y0.setText("");
                    F5.this.Y0.requestFocus();
                    F5.this.Y1();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: F5$i, reason: case insensitive filesystem */
    public class C0479i implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public C0479i(AutoCompleteTextView autoCompleteTextView, EditText editText) {
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

    /* JADX INFO: renamed from: F5$j, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0481j implements View.OnClickListener {
        public ViewOnClickListenerC0481j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.O1(view);
        }
    }

    /* JADX INFO: renamed from: F5$j0, reason: case insensitive filesystem */
    public class ViewOnTouchListenerC0482j0 implements View.OnTouchListener {
        public ViewOnTouchListenerC0482j0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            F5.this.Z0.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (F5.this.Z0.getCompoundDrawables()[0] != null ? F5.this.Z0.getCompoundDrawables()[0].getBounds().width() : 0) + F5.this.Z0.getPaddingLeft() + F5.this.Z0.getLeft()) {
                    F5.this.Z0.setText("");
                    F5.this.Z0.requestFocus();
                    F5.this.Y1();
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: F5$k, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0483k implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC0483k(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5 f5 = F5.this;
            f5.F.Md(f5.getActivity());
            F5.this.v0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: F5$l, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0485l implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public ViewOnClickListenerC0485l(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5 f5 = F5.this;
            f5.F.Md(f5.getActivity());
            F5.this.v0(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: F5$m0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0488m0 implements View.OnClickListener {
        public ViewOnClickListenerC0488m0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", F5.this.i0);
                bundle.putInt("month", F5.this.j0);
                bundle.putInt("day", F5.this.k0);
                c2137ei.setArguments(bundle);
                c2137ei.f(F5.this.z1);
                c2137ei.show(F5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(F5.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: F5$n0, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0490n0 implements View.OnClickListener {
        public ViewOnClickListenerC0490n0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_add_amount) {
                F5.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_fwd_amount) {
                F5.this.c0(view);
                return;
            }
            if (view.getId() == info.aalmoghalis.inventory.R.id.img_call) {
                F5.this.n0(view);
            } else if (view.getId() == info.aalmoghalis.inventory.R.id.img_help) {
                F5.this.help_btn(view);
            } else if (view.getId() == 16908292) {
                F5.this.H1(view);
            }
        }
    }

    /* JADX INFO: renamed from: F5$o, reason: case insensitive filesystem */
    public class C0491o implements Observer {
        public C0491o() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            F5.this.e0.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(List list) {
            new C2160f10(list).e(2);
            F5.this.e0.l(list);
            F5.this.getActivity().runOnUiThread(new Runnable() { // from class: C5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            F5.this.e0.getFilter().filter(F5.this.L1.getQuery());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            F5.this.e0.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(List list) {
            if (Build.VERSION.SDK_INT <= 29) {
                new C2160f10(list).e(2);
            }
            F5.this.e0.l(list);
            SearchView searchView = F5.this.L1;
            if (searchView == null || searchView.getQuery().length() <= 0) {
                F5.this.getActivity().runOnUiThread(new Runnable() { // from class: E5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.i();
                    }
                });
            } else {
                F5.this.getActivity().runOnUiThread(new Runnable() { // from class: D5
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
            FragmentActivity activity = F5.this.getActivity();
            F5 f5 = F5.this;
            c3966tX.z(activity, f5.f0, f5.d0, list == null ? 0 : list.size());
            F5 f6 = F5.this;
            if (f6.e0 != null) {
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: B5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j(list);
                    }
                });
                executorServiceNewSingleThreadExecutor.shutdown();
            } else {
                f6.N1(list);
                if (Build.VERSION.SDK_INT <= 29) {
                    ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
                    executorServiceNewSingleThreadExecutor2.submit(new Runnable() { // from class: A5
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

    /* JADX INFO: renamed from: F5$o0, reason: case insensitive filesystem */
    public class RunnableC0492o0 implements Runnable {
        public final /* synthetic */ int a;

        public RunnableC0492o0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i == 0) {
                F5.this.m0();
                F5 f5 = F5.this;
                if (f5.S0 == 1) {
                    f5.v2();
                    return;
                }
                return;
            }
            if (i == 1) {
                F5.this.l0();
                F5.this.v2();
            } else if (i == 4) {
                F5.this.a1.selectAll();
            }
        }
    }

    /* JADX INFO: renamed from: F5$p, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0493p implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ Handler h;

        public ViewOnClickListenerC0493p(EditText editText, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, String str, AlertDialog alertDialog, EditText editText2, EditText editText3, Handler handler) {
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
            if (F5.this.F.p1(this.c.getText().toString()).getCount() == 0) {
                this.c.setError(F5.this.getString(info.aalmoghalis.inventory.R.string.not_exists));
            } else {
                z = zA;
            }
            if (F5.this.F.Q5(this.b.getText().toString()).getCount() == 0 && !this.b.getText().toString().equals("")) {
                F5.this.W1 = this.b.getText().toString();
                F5 f5 = F5.this;
                f5.S0(f5.getString(info.aalmoghalis.inventory.R.string.validation_add_group), F5.this.getString(info.aalmoghalis.inventory.R.string.validation_add_group) + "#" + F5.this.W1, F5.this.getActivity());
                if (!F5.this.M0) {
                    return;
                }
            }
            if (z) {
                int iR1 = F5.this.F.r1(this.c.getText().toString());
                if (this.d.equals("0")) {
                    if (F5.this.F.Q4(this.a.getText().toString().trim()).getCount() > 0) {
                        FragmentStatePagerSupport_Main.Z(F5.this.getActivity());
                        this.e.dismiss();
                        return;
                    }
                    F5.this.F.v0("insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.getText().toString().trim() + "','" + this.f.getText().toString() + "','" + this.g.getText().toString() + "','" + iR1 + "',(select b.id from groups b where b.name='" + this.b.getText().toString() + "') ) ");
                    Handler handler = this.h;
                    handler.sendMessage(handler.obtainMessage());
                } else if (this.d != null) {
                    F5.this.F.v0("update customers set name='" + this.a.getText().toString().trim() + "',gsm='" + this.f.getText().toString() + "',address='" + this.g.getText().toString() + "',acc_p_id='" + iR1 + "',g_id=(select b.id from groups b where b.name='" + this.b.getText().toString() + "') where id='" + F5.this.g + "' and id>0 ");
                    Handler handler2 = this.h;
                    handler2.sendMessage(handler2.obtainMessage());
                }
                this.e.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: F5$p0, reason: case insensitive filesystem */
    public class HandlerC0494p0 extends Handler {
        public HandlerC0494p0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            F5.this.n2(false);
            if (message.obj.toString().equals("0")) {
                F5 f5 = F5.this;
                f5.J0(f5.I1);
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = F5.this.F;
                StringBuilder sb = new StringBuilder();
                F5 f6 = F5.this;
                sb.append(f6.F.ic(f6.H1));
                sb.append(".pdf");
                z00.ra(sb.toString());
                return;
            }
            if (message.obj.toString().equals("2")) {
                Z00 z01 = F5.this.F;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(F5.this.F.ic(F5.this.h + "-" + F5.this.j));
                sb2.append(".pdf");
                z01.ra(sb2.toString());
                return;
            }
            if (message.obj.toString().equals("4")) {
                Z00 z02 = F5.this.F;
                StringBuilder sb3 = new StringBuilder();
                F5 f7 = F5.this;
                sb3.append(f7.F.ic(f7.h));
                sb3.append(".pdf");
                z02.ra(sb3.toString());
                return;
            }
            if (message.obj.toString().equals("3")) {
                F5.this.e0.notifyDataSetChanged();
                F5 f8 = F5.this;
                Z00 z03 = f8.F;
                FragmentActivity activity = f8.getActivity();
                F5 f9 = F5.this;
                z03.lc(activity, f9.Z, f9.a0, f9.b0, f9.c0);
                F5 f10 = F5.this;
                int i = f10.K1;
                if (i == 1) {
                    Z00 z04 = f10.F;
                    FragmentActivity activity2 = f10.getActivity();
                    F5 f11 = F5.this;
                    z04.ld(activity2, f11.Z, f11.h0);
                } else if (i == 2) {
                    Z00 z05 = f10.F;
                    FragmentActivity activity3 = f10.getActivity();
                    F5 f12 = F5.this;
                    z05.ld(activity3, f12.a0, f12.h0);
                }
                F5 f13 = F5.this;
                if (f13.K1 == 3) {
                    Z00 z06 = f13.F;
                    FragmentActivity activity4 = f13.getActivity();
                    F5 f14 = F5.this;
                    z06.ld(activity4, f14.b0, f14.h0);
                }
                F5 f15 = F5.this;
                if (f15.K1 == 4) {
                    Z00 z07 = f15.F;
                    FragmentActivity activity5 = f15.getActivity();
                    F5 f16 = F5.this;
                    z07.ld(activity5, f16.c0, f16.h0);
                }
                F5.this.A0(-2);
            }
        }
    }

    /* JADX INFO: renamed from: F5$q, reason: case insensitive filesystem */
    public class C0495q implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ EditText c;

        public C0495q(AutoCompleteTextView autoCompleteTextView, Dialog dialog, EditText editText) {
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
                    F5 f5 = F5.this;
                    f5.F.Md(f5.getActivity());
                }
            }
        }
    }

    /* JADX INFO: renamed from: F5$q0, reason: case insensitive filesystem */
    public class RunnableC0496q0 implements Runnable {
        public RunnableC0496q0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            F5 f5 = F5.this;
            f5.H1 = f5.F.ic(f5.h);
            C3357m10 c3357m10 = new C3357m10(F5.this.getActivity(), F5.this.F);
            F5 f6 = F5.this;
            c3357m10.k(f6.H1, f6.h, f6.T0, f6.U0, f6.j);
            Message message = new Message();
            message.obj = "1";
            F5.this.G1.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: F5$r, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0497r implements View.OnClickListener {
        public ViewOnClickListenerC0497r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.Q0.dismiss();
        }
    }

    /* JADX INFO: renamed from: F5$r0, reason: case insensitive filesystem */
    public class RunnableC0498r0 implements Runnable {
        public RunnableC0498r0() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            F5 f5 = F5.this;
            f5.H1 = f5.F.ic(f5.h);
            F5 f6 = F5.this;
            f6.F.vb(f6.H1, f6.g, f6.T0, f6.U0, f6.j);
            Message message = new Message();
            message.obj = "1";
            F5.this.G1.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: F5$s, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0499s implements View.OnClickListener {
        public ViewOnClickListenerC0499s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F5.this.i2();
        }
    }

    /* JADX INFO: renamed from: F5$s0, reason: case insensitive filesystem */
    public class RunnableC0500s0 implements Runnable {
        public RunnableC0500s0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            F5 f5 = F5.this;
            Z00 z00 = f5.F;
            String strIc = z00.ic(f5.h);
            F5 f6 = F5.this;
            z00.nb(strIc, f6.g, f6.T0, f6.U0, f6.F.ic(f6.h));
            F5.this.F.Rd(200);
            Message message = new Message();
            message.obj = "4";
            F5.this.G1.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: F5$t, reason: case insensitive filesystem */
    public class RunnableC0501t implements Runnable {
        public RunnableC0501t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            F5.this.Q0.dismiss();
        }
    }

    /* JADX INFO: renamed from: F5$t0, reason: case insensitive filesystem */
    public class RunnableC0502t0 implements Runnable {
        public RunnableC0502t0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3357m10 c3357m10 = new C3357m10(F5.this.getActivity(), F5.this.F);
            F5 f5 = F5.this;
            RecyclerView recyclerView = f5.f0;
            String strIc = f5.F.ic(F5.this.h + "-" + F5.this.j);
            F5 f6 = F5.this;
            double dX0 = f6.X0(f6.e0.c());
            F5 f7 = F5.this;
            c3357m10.g(recyclerView, strIc, dX0, f7.j, f7.T0, f7.U0, f7.F.ic(f7.h));
            F5.this.F.Rd(200);
            Message message = new Message();
            message.obj = "2";
            F5.this.G1.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: F5$u, reason: case insensitive filesystem */
    public class C0503u implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C0503u(Dialog dialog) {
            this.a = dialog;
        }

        public final /* synthetic */ Integer c() {
            F5 f5 = F5.this;
            f5.p2(f5.A);
            F5.this.h0 = 1;
            return 1;
        }

        public final /* synthetic */ void d(int i, Dialog dialog, Integer num) {
            F5.this.n2(false);
            F5.this.e0.notifyDataSetChanged();
            F5.this.k2(i, dialog);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, final int i, long j) {
            if (Build.VERSION.SDK_INT < 31) {
                F5.this.d0();
            }
            if (!F5.this.F.ja("prefPrintSort", true)) {
                F5.this.k2(i, this.a);
                return;
            }
            F5.this.n2(true);
            AbstractC3132jE abstractC3132jEE = AbstractC3132jE.d(new Callable() { // from class: G5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.c();
                }
            }).m(IN.c()).e(AbstractC1197a4.e());
            final Dialog dialog = this.a;
            abstractC3132jEE.i(new InterfaceC2295gf() { // from class: H5
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.d(i, dialog, (Integer) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: F5$u0, reason: case insensitive filesystem */
    public class RunnableC0504u0 implements Runnable {
        public final /* synthetic */ View a;

        public RunnableC0504u0(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            F5 f5 = F5.this;
            f5.A = f5.e0.c();
            F5 f6 = F5.this;
            if (f6.h0 == 0) {
                f6.h0 = 1;
            } else {
                f6.h0 = 0;
            }
            switch (this.a.getId()) {
                case info.aalmoghalis.inventory.R.id.img /* 2131296820 */:
                    F5.this.K1 = 4;
                    break;
                case info.aalmoghalis.inventory.R.id.tr_amount /* 2131297456 */:
                    F5.this.K1 = 2;
                    break;
                case info.aalmoghalis.inventory.R.id.tr_bal /* 2131297459 */:
                    F5.this.K1 = 5;
                    break;
                case info.aalmoghalis.inventory.R.id.tr_date /* 2131297468 */:
                    F5.this.K1 = 1;
                    break;
                case info.aalmoghalis.inventory.R.id.tr_remarks /* 2131297488 */:
                    F5.this.K1 = 3;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            F5.this.G1.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: F5$v, reason: case insensitive filesystem */
    public class C0505v implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public C0505v(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (i <= 1) {
                C3966tX c3966tX = new C3966tX();
                FragmentActivity activity = F5.this.getActivity();
                F5 f5 = F5.this;
                c3966tX.f(activity, f5.F, f5.G, f5.h, i);
            } else if (i == 2) {
                F5 f6 = F5.this;
                f6.R0 = 5;
                C4064uh c4064uhP0 = f6.F.P0(f6.h);
                F5 f7 = F5.this;
                Z00 z00 = f7.F;
                z00.td(z00.zd(f7.K0(), F5.this.h, Double.parseDouble(c4064uhP0.v)));
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: F5$w, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0507w implements View.OnClickListener {
        public ViewOnClickListenerC0507w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", F5.this.i0);
                bundle.putInt("month", F5.this.j0);
                bundle.putInt("day", F5.this.k0);
                c2137ei.setArguments(bundle);
                c2137ei.f(F5.this.A1);
                c2137ei.show(F5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    public class w0 extends Handler {
        public w0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: renamed from: F5$x, reason: case insensitive filesystem */
    public class ViewOnClickListenerC0508x implements View.OnClickListener {
        public ViewOnClickListenerC0508x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", F5.this.i0);
                bundle.putInt("month", F5.this.j0);
                bundle.putInt("day", F5.this.k0);
                c2137ei.setArguments(bundle);
                c2137ei.f(F5.this.B1);
                c2137ei.show(F5.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(F5.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    public class x0 implements SearchView.OnQueryTextListener {

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                F5.this.K1(this.a);
            }
        }

        public x0() {
        }

        public final /* synthetic */ void b() {
            F5.this.M0(2);
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                try {
                    F5.this.M1 = true;
                    F5 f5 = F5.this;
                    if (f5.v0 == 1) {
                        f5.v0 = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                F5.this.M1 = false;
                F5.this.v0 = 1;
            }
            F5.this.N1.removeCallbacksAndMessages(null);
            F5.this.N1.postDelayed(new a(str), new C2160f10().V(str));
            TextUtils.isEmpty(str);
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            try {
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: I5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
                executorServiceNewSingleThreadExecutor.shutdown();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: F5$y, reason: case insensitive filesystem */
    public class C0509y implements Observer {
        public C0509y() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                C3966tX c3966tX = new C3966tX();
                FragmentActivity activity = F5.this.getActivity();
                F5 f5 = F5.this;
                c3966tX.z(activity, f5.f0, f5.d0, -1);
                return;
            }
            C3966tX c3966tX2 = new C3966tX();
            FragmentActivity activity2 = F5.this.getActivity();
            F5 f6 = F5.this;
            c3966tX2.z(activity2, f6.f0, f6.d0, 1);
        }
    }

    public class y0 implements MenuItemCompat.OnActionExpandListener {
        public y0() {
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            F5.this.v0 = 0;
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return true;
        }
    }

    public class z0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ CharSequence[] a;

        public z0(CharSequence[] charSequenceArr) {
            this.a = charSequenceArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                boolean zH = C3966tX.h(F5.this.getActivity());
                if (i == 0) {
                    F5 f5 = F5.this;
                    f5.S1 = f5.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[0];
                    if (zH) {
                        F5.this.o0();
                    }
                } else if (i == 1) {
                    F5 f6 = F5.this;
                    f6.S1 = f6.getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image)[1];
                    if (zH) {
                        F5.this.N0();
                    }
                } else if (this.a[i].equals("Cancel")) {
                    dialogInterface.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    public F5() {
        Boolean bool = Boolean.FALSE;
        this.L = bool;
        this.M = bool;
        this.N = null;
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
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.h0 = 0;
        this.r0 = new int[]{info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
        this.s0 = null;
        this.u0 = 0;
        this.v0 = 0;
        this.w0 = "";
        this.x0 = "";
        this.y0 = "";
        this.z0 = "";
        this.A0 = "";
        this.B0 = "";
        this.C0 = 0;
        this.D0 = "";
        this.E0 = "";
        this.J0 = -1;
        this.K0 = "";
        this.L0 = new ViewOnClickListenerC0490n0();
        this.O0 = 0;
        this.P0 = "";
        this.R0 = 0;
        this.S0 = 0;
        this.T0 = CSS.Value.PERCENTAGE;
        this.U0 = CSS.Value.PERCENTAGE;
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
        this.m1 = null;
        this.n1 = null;
        this.o1 = null;
        this.p1 = null;
        this.q1 = null;
        this.r1 = null;
        this.s1 = null;
        this.t1 = null;
        this.u1 = null;
        this.v1 = new ArrayList();
        this.w1 = new ArrayList();
        this.y1 = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.z1 = new Z();
        this.A1 = new C0464a0();
        this.B1 = new C0466b0();
        this.C1 = new C0468c0();
        this.F1 = null;
        this.G1 = new HandlerC0494p0();
        this.H1 = "";
        this.I1 = null;
        this.J1 = new ArrayList();
        this.K1 = 0;
        this.M1 = true;
        this.N1 = new Handler(Looper.getMainLooper());
        this.Q1 = 3;
        this.R1 = 4;
        this.T1 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: u5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.a.n1((Uri) obj);
            }
        });
        this.U1 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new B0());
        this.W1 = "";
        this.Z1 = new C0467c();
        this.a2 = new C0469d();
        this.b2 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i) {
        String str;
        this.u0 = i;
        boolean zIsEmpty = this.T0.isEmpty();
        String str2 = CSS.Value.PERCENTAGE;
        this.T0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.T0;
        if (!this.U0.isEmpty()) {
            str2 = this.U0;
        }
        this.U0 = str2;
        Log.d("trace_data_loader=", this.g + ":" + this.j + ":" + this.h);
        Calendar.getInstance().get(14);
        SearchView searchView = this.L1;
        this.w0 = (searchView == null || searchView.getQuery() == null) ? "" : this.L1.getQuery().toString();
        if (!d1() || (!d1() && i == -1)) {
            this.t0.h(getActivity(), this.h, this.j, this.F, this.v0, this.w0);
        }
        Log.d("trace_S_Loader_cus=", this.g + ":" + this.j + ":" + this.h + ":" + this.T0 + ":" + this.U0 + ":" + this.S0);
        c2 = 0.0d;
        if (e1() && this.S0 == 0) {
            new C3966tX().z(getActivity(), this.f0, this.d0, -2);
        } else if (e1() || this.S0 == 1 || this.u0 > 0 || i == -2) {
            new C3966tX().z(getActivity(), this.f0, this.d0, -1);
        }
        C4330y1 c4330y1 = this.e0;
        if (c4330y1 == null || this.S0 == 1 || i == -1) {
            C2160f10.l = 100;
        }
        if (c4330y1 == null || this.S0 == 1 || i == -2) {
            C4330y1 c4330y2 = new C4330y1(getActivity(), this.A, this, this);
            this.e0 = c4330y2;
            this.f0.setAdapter(c4330y2.withLoadStateFooter(new C4249x1(new View.OnClickListener() { // from class: x5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.h1(view);
                }
            })));
            this.e0.addLoadStateListener(new InterfaceC3750qp() { // from class: y5
                @Override // defpackage.InterfaceC3750qp
                public final Object invoke(Object obj) {
                    return this.a.l1((CombinedLoadStates) obj);
                }
            });
        }
        if (i == -1 || ((str = this.w0) != null && str.length() > 0)) {
            this.e0.d = this.w0;
        }
        this.t0.f(getActivity(), this.g, this.j, this.F, CSS.Value.PERCENTAGE, (i > 0 || i == -2 || d1()) ? 1 : this.S0, this.T0, this.U0, i, this.v0, this.w0, this.K1, this.h0);
        this.t0.i.k(new InterfaceC2295gf() { // from class: z5
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.m1((PagingData) obj);
            }
        });
    }

    private void D0() {
        String[] stringArray = this.k1.getTag() != null ? getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.edit_image) : getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(stringArray, new A0(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    private void J1(Intent intent) {
        try {
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Z00.M, System.currentTimeMillis() + ".jpg");
            file2.createNewFile();
            if (Build.VERSION.SDK_INT >= 24) {
                z0(new File(Z00.A0), file2);
            } else {
                z0(new File(Q0(getActivity(), this.V1)), file2);
            }
            d2(file2.getName());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C4064uh K0() {
        Cursor cursorS7 = this.F.s7(this.h);
        cursorS7.moveToFirst();
        C4064uh c4064uh = null;
        while (!cursorS7.isAfterLast()) {
            c4064uh = new C4064uh(cursorS7.getString(cursorS7.getColumnIndex("_id")), cursorS7.getString(cursorS7.getColumnIndex("date_")), cursorS7.getString(cursorS7.getColumnIndex("amount")), cursorS7.getString(cursorS7.getColumnIndex("remarks")), this.r0[cursorS7.getInt(cursorS7.getColumnIndex("_in"))], String.valueOf(cursorS7.getInt(cursorS7.getColumnIndex("_in"))), cursorS7.getString(cursorS7.getColumnIndex("param1")), cursorS7.getString(cursorS7.getColumnIndex("curr_name")), cursorS7.getString(cursorS7.getColumnIndex("bill_id")), cursorS7.getString(cursorS7.getColumnIndex("org_remarks")));
            cursorS7.moveToNext();
        }
        cursorS7.close();
        return c4064uh;
    }

    private void M1(Uri uri, boolean z) {
        try {
            String strX = new C3966tX().x(uri, z, this.F, getActivity());
            if (strX != null) {
                d2(strX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        Log.d("trace_file=", "galleryIntent:" + ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(getActivity()));
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(getActivity())) {
            this.T1.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            return;
        }
        new C3966tX().d(getActivity());
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        Log.d("trace_file=", "createChooser");
        startActivityForResult(Intent.createChooser(intent, "Select File"), this.R1);
    }

    public static String O0() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public static String P0(Context context, Uri uri, String str, String[] strArr) throws Throwable {
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

    public static String Q0(Context context, Uri uri) {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (b1(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (a1(uri)) {
                        return P0(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (c1(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (HTML.Tag.VIDEO.equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = HTML.Tag.AUDIO.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return P0(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (Annotation.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    return P0(context, uri, null, null);
                }
                if (Annotation.FILE.equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1() {
        try {
            if (Z00.Z) {
                if (this.v1.size() == 0) {
                    this.v1 = this.F.j3();
                }
                for (int i = 0; i < this.v1.size(); i++) {
                    if (this.J0 >= this.v1.size() - 1) {
                        this.J0 = -1;
                    }
                    int i2 = this.J0 + 1;
                    this.J0 = i2;
                    String str = (String) ((HashMap) this.v1.get(i2)).get("name");
                    if (!str.equals("") && this.F.G3(this.g, str).getCount() > 0 && !str.equals(this.j)) {
                        this.j = str;
                        V0();
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void Z1(ImageView imageView) {
        imageView.setTag(null);
        imageView.setImageResource(info.aalmoghalis.inventory.R.drawable.camera);
        imageView.getLayoutParams().width = this.C0;
        imageView.getLayoutParams().height = this.C0;
    }

    public static boolean a1(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private void a2(List list) {
        Collections.sort(this.A, new V0(this, null));
    }

    private void b0(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterfaceOnClickListenerC0506v0()).show();
    }

    public static boolean b1(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private void b2() {
        String[] stringArray = getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.select_image);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(stringArray, new z0(stringArray));
        AlertDialog alertDialogCreate = builder.create();
        ListView listView = alertDialogCreate.getListView();
        listView.setDivider(new ColorDrawable(-7829368));
        listView.setDividerHeight(1);
        alertDialogCreate.show();
    }

    public static boolean c1(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(View view) {
        this.e0.retry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1() {
        this.e0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1() {
        this.f0.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1() {
        this.f0.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FW l1(CombinedLoadStates combinedLoadStates) {
        int i;
        Log.d("trace_2loadStates:=", this.u0 + ":" + this.S0 + ":" + this.v0 + ":" + combinedLoadStates.getPrepend().toString() + ":" + combinedLoadStates.toString());
        if (combinedLoadStates.getPrepend().getEndOfPaginationReached()) {
            int size = this.e0.c().size();
            Log.d("trace_2loadStates:=", "END:" + size);
            new C3966tX().z(getActivity(), this.f0, this.d0, size);
            N1(null);
            if (d1() || (i = this.u0) == -1 || i == -2) {
                if (d1() && this.u0 != -2) {
                    M0(2);
                }
                if (this.u0 == -1) {
                    new Handler().postDelayed(new Runnable() { // from class: c5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.i1();
                        }
                    }, 0L);
                } else {
                    new Handler().postDelayed(new Runnable() { // from class: d5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.j1();
                        }
                    }, 0L);
                }
                if (d1() && this.u0 < 0) {
                    this.F.Kd(getActivity(), new C2160f10(getActivity(), this.F).P(this.T0, this.U0), 500);
                }
            }
            int i2 = this.u0;
            if (i2 == 1) {
                T1();
            } else if (i2 == 2) {
                R1();
            } else if (i2 == 3) {
                g2();
            } else if (i2 == 4) {
                f2();
            } else if (i2 == 5) {
                x0();
            } else if (i2 == 6) {
                h2();
            }
            if (this.u0 == 0 && this.f0.computeVerticalScrollOffset() == 0) {
                new Handler().postDelayed(new Runnable() { // from class: e5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.k1();
                    }
                }, 0L);
            }
            this.u0 = 0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(PagingData pagingData) {
        Log.d("trace_2Observer=", "onChanged");
        this.e0.submitData(getLifecycle(), pagingData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        new C3966tX().d(requireActivity());
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.CAMERA") == 0) {
            r2();
            return;
        }
        int i = Integer.parseInt(this.F.ia("ask_camera", "0"));
        if (i < 5) {
            i++;
            this.F.Lc("ask_camera", i + "");
        }
        if (i <= 2) {
            this.U1.launch("android.permission.CAMERA");
        } else {
            C3966tX.D(requireActivity(), getString(info.aalmoghalis.inventory.R.string.permission_camera));
        }
    }

    private boolean p0() {
        boolean zA = AbstractC4371yX.a(this.a1);
        if (!AbstractC4371yX.a(this.d1)) {
            zA = false;
        }
        if (this.h.equals(this.F.B3().j())) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.not_valid), 0).show();
            zA = false;
        }
        if (!this.F.Q()) {
            this.f1.setError(null);
            return zA;
        }
        y0();
        this.f1.setError(getActivity().getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(List list) {
        Collections.sort(this.A, new U0(this, null));
    }

    private boolean q0() {
        boolean zA = AbstractC4371yX.a(this.Y0);
        if (!AbstractC4371yX.a(this.Z0)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.a1)) {
            zA = false;
        }
        if (!AbstractC4371yX.a(this.d1)) {
            zA = false;
        }
        if (this.Y0.getText().toString().equals(this.Z0.getText().toString())) {
            this.Z0.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.F.u3(this.Z0.getText().toString()) == 0 && this.F.u3(this.Z0.getText().toString().trim()) == 0) {
            this.Z0.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (this.F.u3(this.Y0.getText().toString()) == 0 && this.F.u3(this.Y0.getText().toString().trim()) == 0) {
            this.Y0.setError(getString(info.aalmoghalis.inventory.R.string.not_valid));
            zA = false;
        }
        if (!this.F.Q()) {
            this.f1.setError(null);
            return zA;
        }
        y0();
        this.f1.setError(getActivity().getString(info.aalmoghalis.inventory.R.string.liciense_msg));
        return false;
    }

    private void r0() {
        if (this.F.u3(this.h) == 0 && this.F.u3(this.h.trim()) == 0) {
            String strTrim = this.h.trim();
            this.h = strTrim;
            if (strTrim.length() >= 1 && this.f1.getText().toString().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_add))) {
                R0(getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.h, getActivity());
            }
        }
        String str = this.h;
        if (!str.equals(str.trim()) && this.F.u3(this.h.trim()) > 0) {
            this.h = this.h.trim();
        }
        this.F.D = false;
        if (this.u1.getTag() == null || this.u1.getTag().toString().equals(this.F.l3("0")) || this.F.Z2(this.u1.getTag().toString(), this.F.cc(this.b1.getText().toString())) != 0) {
            return;
        }
        this.F.u(getActivity(), this.u1.getTag().toString(), this.F.cc(this.b1.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    private void s0() {
        if (this.F.u3(this.Z0.getText().toString()) == 0 && this.F.u3(this.Z0.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView = this.Z0;
            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().trim());
            if (this.Z0.getText().toString().length() >= 1 && this.f1.getText().toString().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                T0(getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.Z0.getText().toString(), getActivity());
            }
        }
        if (!this.Z0.getText().toString().equals(this.Z0.getText().toString().trim()) && this.F.u3(this.Z0.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView2 = this.Z0;
            autoCompleteTextView2.setText(autoCompleteTextView2.getText().toString().trim());
        }
        if (this.F.u3(this.Y0.getText().toString()) == 0 && this.F.u3(this.Y0.getText().toString().trim()) == 0) {
            AutoCompleteTextView autoCompleteTextView3 = this.Y0;
            autoCompleteTextView3.setText(autoCompleteTextView3.getText().toString().trim());
            if (this.Y0.getText().toString().length() >= 1 && this.f1.getText().toString().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save))) {
                R0(getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus), getActivity().getString(info.aalmoghalis.inventory.R.string.validation_add_cus) + this.Y0.getText().toString(), getActivity());
            }
        }
        if (!this.Y0.getText().toString().equals(this.Y0.getText().toString().trim()) && this.F.u3(this.Y0.getText().toString().trim()) > 0) {
            AutoCompleteTextView autoCompleteTextView4 = this.Y0;
            autoCompleteTextView4.setText(autoCompleteTextView4.getText().toString().trim());
        }
        this.F.D = false;
        if (this.u1.getTag() == null || this.u1.getTag().toString().equals(this.F.l3("0")) || this.F.Z2(this.u1.getTag().toString(), this.F.cc(this.b1.getText().toString())) != 0) {
            return;
        }
        this.F.u(getActivity(), this.u1.getTag().toString(), this.F.cc(this.b1.getText().toString()), getString(info.aalmoghalis.inventory.R.string.add_curr_price));
    }

    private boolean t0() {
        boolean zA = AbstractC4371yX.a(this.a1);
        if (!AbstractC4371yX.a(this.d1)) {
            zA = false;
        }
        if (this.F.Q()) {
            y0();
            return false;
        }
        this.f1.setError(null);
        return zA;
    }

    private void z0(File file, File file2) throws IOException {
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

    public final /* synthetic */ Integer A1() {
        if (this.F.ja("pref_print_all_curr", false)) {
            Z00 z00 = this.F;
            z00.nb(z00.ic(this.h), this.g, this.T0, this.U0, this.F.ic(this.h));
        } else {
            new C3357m10(getActivity(), this.F).g(this.f0, this.F.ic(this.h + "-" + this.j), X0(this.e0.c()), this.j, this.T0, this.U0, this.F.ic(this.h));
        }
        return 1;
    }

    public final void B0() {
        int i = Calendar.getInstance().get(14);
        StringBuilder sb = new StringBuilder();
        sb.append("Start...");
        sb.append(Integer.parseInt(this.g) * i * 1000000);
        sb.append(":");
        sb.append(i);
        sb.append(":");
        boolean z = Z00.Z;
        int i2 = this.J0;
        sb.append((z && (i2 > 0)) ? i2 : 1);
        Log.d("data_loader2", sb.toString());
    }

    public final /* synthetic */ void B1(Integer num) {
        n2(false);
        if (this.F.ja("pref_print_all_curr", false)) {
            this.F.sd(this.F.ic(this.h) + ".pdf");
            return;
        }
        Z00 z00 = this.F;
        StringBuilder sb = new StringBuilder();
        sb.append(this.F.ic(this.h + "-" + this.j));
        sb.append(".pdf");
        z00.sd(sb.toString());
    }

    public void C0() {
        if (C2160f10.h > 0 && !new C2160f10(this.F).l("-9", HTML.Tag.DEL)) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.g0.size() - 1; size >= 0; size--) {
            if (this.g0.valueAt(size)) {
                C4064uh c4064uh = (C4064uh) this.e0.c().get(this.g0.keyAt(size));
                int i = C2160f10.h;
                if (i <= 0 || i == new C2160f10(this.F).K(c4064uh.q())) {
                    String strA = c4064uh.a() != null ? c4064uh.a() : "";
                    this.x = strA;
                    int i2 = strA.equals("") ? 0 : Integer.parseInt(this.x);
                    if (i2 > 0) {
                        Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_edit), 1).show();
                        this.n = 0;
                        return;
                    }
                    if (i2 == -2 || i2 == -3 || i2 == -4 || i2 == -6) {
                        Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_edit_doc), 1).show();
                        this.n = 0;
                        return;
                    }
                    this.e0.i(c4064uh);
                    this.F.v0("delete from transactions where id=" + c4064uh.q());
                } else {
                    Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.priv_other_user), 0).show();
                }
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        V0();
    }

    public final /* synthetic */ Integer C1() {
        p2(this.e0.c());
        this.h0 = 1;
        return 1;
    }

    public final /* synthetic */ void D1(Integer num) {
        this.e0.notifyDataSetChanged();
        c2(2);
    }

    public void E0() {
        if (C2160f10.h > 0 && !new C2160f10(this.F).l("-9", "edit")) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return;
        }
        int size = this.g0.size() - 1;
        if (this.g0.valueAt(size)) {
            C4064uh c4064uh = (C4064uh) this.e0.c().get(this.g0.keyAt(size));
            try {
                int i = C2160f10.h;
                if (i > 0 && i != new C2160f10(this.F).K(c4064uh.q())) {
                    Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.priv_other_user), 0).show();
                    return;
                }
                this.x = c4064uh.a() != null ? c4064uh.a() : "";
                this.n = Integer.parseInt(c4064uh.q());
                this.p = c4064uh.p();
                this.q = c4064uh.n();
                this.t = c4064uh.h();
                this.u = c4064uh.o() != null ? c4064uh.o().toString() : "";
                this.v = c4064uh.t();
                this.w = c4064uh.b();
                if (this.F.O8(this.n).equals("0")) {
                    F0(false);
                    return;
                }
                this.t = this.F.R8(this.n);
                this.z = this.h;
                String strT8 = this.F.T8(this.n);
                this.y = strT8;
                if (strT8.equals(this.h)) {
                    this.z = this.F.N8(this.n);
                }
                G0(false);
            } catch (Exception unused) {
            }
        }
    }

    public void E1() {
        try {
            this.Y0.requestFocus();
            this.d1.setText((CharSequence) null);
            this.k1.setTag(null);
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.move_inserted), 0).show();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), 1).show();
            Log.d("move_transaction", e.getMessage());
        }
    }

    public void F0(boolean z) {
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
        this.a1 = editText;
        this.P1 = editText;
        editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
        EditText editText2 = this.a1;
        editText2.addTextChangedListener(new C2018dE(editText2));
        this.a1.requestFocus();
        this.b1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
        this.f1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
        this.g1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add1);
        Button button = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_add2);
        this.h1 = button;
        this.F.fd(this.g1, button);
        this.i1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
        this.k1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        this.l1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup1);
        this.m1 = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton1);
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiobutton2);
        this.n1 = radioButton;
        this.F.gd(this.m1, radioButton);
        this.l1.check(info.aalmoghalis.inventory.R.id.radiobutton2);
        this.d1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
        this.o1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
        this.p1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3_1);
        this.q1 = linearLayout;
        if (!z) {
            linearLayout.setVisibility(0);
        }
        this.s1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface5);
        this.t1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
        this.u1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        this.a1.requestFocus();
        l2(z);
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setTitle(this.h);
        alertDialogCreate.getWindow().setSoftInputMode(16);
        this.g1.setOnClickListener(new I(alertDialogCreate));
        this.h1.setOnClickListener(new L(alertDialogCreate));
        this.f1.setOnClickListener(new M(alertDialogCreate));
        this.i1.setOnClickListener(new N());
        this.k1.setOnClickListener(new O(z));
        alertDialogCreate.show();
    }

    public void F1(boolean z) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.F).l("-9", z ? "new" : "edit")) {
                Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.customer_det_move_dialog2, (ViewGroup) null);
            builder.setView(viewInflate);
            this.Y0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.from_cus_name);
            this.Z0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.to_cus_name);
            if (this.I && this.J.equals(this.h)) {
                this.Y0.setText("");
                this.Y0.requestFocus();
            } else {
                this.Y0.setText(this.h);
                this.Z0.requestFocus();
            }
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
            this.a1 = editText;
            this.P1 = editText;
            editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
            EditText editText2 = this.a1;
            editText2.addTextChangedListener(new C2018dE(editText2));
            this.b1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
            this.f1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
            this.i1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
            this.k1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
            ImageView imageView = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_swap);
            this.j1 = imageView;
            imageView.setOnClickListener(new T());
            this.d1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
            this.o1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
            this.p1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
            this.r1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
            this.t1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
            this.u1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
            m2(z);
            builder.setCancelable(true);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            this.f1.setOnClickListener(new U(alertDialogCreate));
            this.i1.setOnClickListener(new W());
            this.k1.setOnClickListener(new X(z));
            alertDialogCreate.getWindow().getAttributes().gravity = 48;
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("move_transaction_error=", ":" + e.getMessage());
        }
    }

    public void G0(boolean z) {
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
                Log.d("edit_move_error=", ":" + e.getMessage());
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.customer_det_move_dialog2, (ViewGroup) null);
        builder.setView(viewInflate);
        this.Y0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.from_cus_name);
        this.Z0 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.to_cus_name);
        EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_amount);
        this.a1 = editText;
        this.P1 = editText;
        editText.setFilters(new InputFilter[]{new C3580oi(Z00.b0)});
        EditText editText2 = this.a1;
        editText2.addTextChangedListener(new C2018dE(editText2));
        this.a1.requestFocus();
        this.b1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_date);
        this.f1 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_cus_det_edit);
        this.i1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_calc);
        this.j1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_swap);
        this.k1 = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.btn_attach);
        this.j1.setOnClickListener(new P());
        this.d1 = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_tr_remarks);
        this.o1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface2);
        this.p1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface3);
        this.r1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface4);
        this.t1 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_interface_curr);
        this.u1 = (RadioGroup) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.radiogroup_curr);
        this.a1.requestFocus();
        m2(z);
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setSoftInputMode(16);
        this.f1.setOnClickListener(new Q(alertDialogCreate));
        this.i1.setOnClickListener(new R());
        this.k1.setOnClickListener(new S(z));
        alertDialogCreate.show();
    }

    public void G1() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.dialog_customer_7, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.cus_name);
            this.X1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.date_);
            this.Y1 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.time_);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.remarks);
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, 1);
            Locale locale = Locale.ENGLISH;
            this.X1.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(calendar.getTime()));
            this.i0 = calendar.get(1);
            this.j0 = calendar.get(2);
            this.k0 = calendar.get(5);
            this.l0 = calendar.get(11);
            this.m0 = calendar.get(12);
            this.Y1.setText(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(this.l0)) + ":" + String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(this.m0)));
            this.F.Zc(getActivity(), autoCompleteTextView);
            this.F.ad(getActivity(), editText);
            this.X1.setOnClickListener(new O0());
            this.Y1.setOnClickListener(new P0());
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.F.w4());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setText(this.h);
            autoCompleteTextView.setOnItemClickListener(new Q0(autoCompleteTextView));
            editText.requestFocus();
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new R0());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC0463a());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.add_reminder));
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC0465b(autoCompleteTextView, editText, alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item2_error=", e.getMessage() + "");
            e.printStackTrace();
        }
    }

    public void H0() {
        if (Z00.Z) {
            ArrayList arrayListJ3 = this.F.j3();
            this.v1 = arrayListJ3;
            RadioButton[] radioButtonArr = new RadioButton[arrayListJ3.size()];
            this.u1.setTag(null);
            this.u1.removeAllViews();
            for (int i = 0; i < this.v1.size(); i++) {
                RadioButton radioButton = new RadioButton(getActivity());
                radioButtonArr[i] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.v1.get(i)).get("name"));
                radioButtonArr[i].setId(Integer.parseInt((String) ((HashMap) this.v1.get(i)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i].setOnClickListener(new Y());
                this.u1.addView(radioButtonArr[i]);
                String str = this.w;
                if (str != null && str.equals(((HashMap) this.v1.get(i)).get("name"))) {
                    this.u1.check(radioButtonArr[i].getId());
                    this.u1.setTag(((HashMap) this.v1.get(i)).get("name"));
                }
                String str2 = this.j;
                if (str2 != null && str2.equals(((HashMap) this.v1.get(i)).get("name"))) {
                    this.u1.check(radioButtonArr[i].getId());
                    this.u1.setTag(((HashMap) this.v1.get(i)).get("name"));
                }
            }
        }
    }

    public void H1(View view) {
        this.S0 = 0;
        V0();
    }

    public void I0() {
        C4330y1 c4330y1 = this.e0;
        if (c4330y1 == null) {
            C4330y1 c4330y2 = new C4330y1(getActivity(), this.A, this, this);
            this.e0 = c4330y2;
            this.f0.setAdapter(c4330y2);
        } else {
            c4330y1.g.clear();
            this.e0.notifyDataSetChanged();
            a2(this.A);
            this.e0.notifyDataSetChanged();
            this.f0.setAdapter(this.e0);
        }
        this.d0.setText(getString(info.aalmoghalis.inventory.R.string.no_results));
    }

    public void I1() {
        if (this.F.L4(this.h).c().equals("")) {
            G1();
            return;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) Reminders.class);
        intent.putExtra("cus_name", this.h + "");
        startActivity(intent);
    }

    public void J0(Cursor cursor) {
        C4330y1 c4330y1 = this.e0;
        if (c4330y1 != null) {
            c4330y1.notifyDataSetChanged();
        }
        try {
            if (this.S0 == 0) {
                B0();
            }
            Z0(1, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void K1(String str) {
        try {
            Log.d("trace_2QueryText2=", "start:" + str);
            if (this.e0 != null) {
                A0(-1);
            }
        } catch (Exception unused) {
        }
    }

    public void L0() {
        try {
            C1044Xj.a().c(new RunnableC1171Zj(13, this.F, this.N, this.g, "", this.j, 1, new RunnableC1086Yj()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void L1(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.u1.setTag(radioButton.getText().toString());
            Log.d("radio_checked:=", radioButton.getText().toString());
            if (this.u1.getTag() != null) {
                this.j = this.u1.getTag().toString();
            }
        }
    }

    public void M0(int i) {
        String str;
        String str2;
        String str3;
        Log.d("footer_update=", this.h + ":" + i + ":" + this.S0);
        Log.d("trace_footer_update=", this.J1.size() + ":" + i + ":" + this.S0);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        this.U.setVisibility(0);
        String str4 = "";
        if (i == 1) {
            try {
                this.S.setVisibility(8);
                if (this.J1.size() > 0) {
                    this.k = numberFormat.format(Double.parseDouble((String) this.J1.get(0)));
                    if (Double.parseDouble((String) this.J1.get(0)) >= 0.0d) {
                        this.U.setImageResource(this.r0[2]);
                        TextView textView = this.N;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.B0);
                        sb.append(numberFormat.format(Math.abs(Double.parseDouble((String) this.J1.get(0)))));
                        if (Z00.Z) {
                            str3 = " " + this.j;
                        } else {
                            str3 = "";
                        }
                        sb.append(str3);
                        textView.setText(sb.toString());
                    } else {
                        this.U.setImageResource(this.r0[0]);
                        TextView textView2 = this.N;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.y0);
                        sb2.append(numberFormat.format(Math.abs(Double.parseDouble((String) this.J1.get(0)))));
                        if (Z00.Z) {
                            str2 = " " + this.j;
                        } else {
                            str2 = "";
                        }
                        sb2.append(str2);
                        textView2.setText(sb2.toString());
                    }
                    if (!this.F.ja("prefOthers_footer2_total", false) || Double.parseDouble((String) this.J1.get(1)) == 0.0d || Double.parseDouble((String) this.J1.get(2)) == 0.0d) {
                        this.R.setVisibility(8);
                        this.T.setVisibility(8);
                    } else {
                        this.R.setVisibility(0);
                        this.T.setVisibility(0);
                        this.O.setText(this.B0 + numberFormat.format(Double.parseDouble((String) this.J1.get(1))));
                        this.P.setText(this.y0 + numberFormat.format(Double.parseDouble((String) this.J1.get(2))));
                    }
                } else {
                    TextView textView3 = this.N;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.x0);
                    if (Z00.Z) {
                        str = " " + this.j;
                    } else {
                        str = "";
                    }
                    sb3.append(str);
                    textView3.setText(sb3.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
                TextView textView4 = this.N;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.x0);
                if (Z00.Z) {
                    str4 = " " + this.j;
                }
                sb4.append(str4);
                textView4.setText(sb4.toString());
            }
        } else if (i == 2 || this.S0 == 1) {
            double[] dArrY0 = Y0(this.e0.c());
            this.k = numberFormat.format(dArrY0[0]);
            if (dArrY0[0] >= 0.0d) {
                this.U.setImageResource(this.r0[2]);
                TextView textView5 = this.N;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.B0);
                sb5.append(numberFormat.format(Math.abs(dArrY0[0])));
                if (Z00.Z) {
                    str4 = " " + this.j;
                }
                sb5.append(str4);
                textView5.setText(sb5.toString());
            } else {
                this.U.setImageResource(this.r0[0]);
                TextView textView6 = this.N;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.y0);
                sb6.append(numberFormat.format(Math.abs(dArrY0[0])));
                if (Z00.Z) {
                    str4 = " " + this.j;
                }
                sb6.append(str4);
                textView6.setText(sb6.toString());
            }
            if (!this.F.ja("prefOthers_footer2_total", false) || ((dArrY0[1] == 0.0d || dArrY0[2] == 0.0d) && dArrY0[3] == 0.0d && dArrY0[4] == 0.0d)) {
                this.R.setVisibility(8);
                this.T.setVisibility(8);
            } else {
                this.R.setVisibility(0);
                this.T.setVisibility(0);
                this.O.setText(this.B0 + numberFormat.format(dArrY0[1]));
                this.P.setText(this.y0 + numberFormat.format(dArrY0[2]));
                if (dArrY0[3] == 0.0d && dArrY0[4] == 0.0d) {
                    this.S.setVisibility(8);
                } else {
                    this.S.setVisibility(0);
                    if (dArrY0[3] != 0.0d) {
                        this.Q.setText(this.K0 + this.B0 + numberFormat.format(dArrY0[3]));
                    } else if (dArrY0[4] != 0.0d) {
                        this.Q.setText(this.K0 + this.y0 + numberFormat.format(dArrY0[4]));
                    }
                }
            }
        }
        L0();
    }

    public void N1(List list) {
        Log.d("Loader=", "onLoadFinished:" + this.g + ":" + this.h + ":" + isResumed() + ":" + this.L + ":" + getUserVisibleHint());
        StringBuilder sb = new StringBuilder();
        sb.append(FragmentStatePagerSupport_Main.X());
        sb.append(":");
        sb.append(this.g);
        sb.append(":");
        sb.append(this.j);
        Log.d("trace_E_Loader_cus=", sb.toString());
        try {
            this.E1 = new T0(this, null);
            if (this.I && this.J.equals(this.h)) {
                this.F.Lc("show_move_tr", "0");
                F1(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O1(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    public void P1() {
        n2(true);
        new Thread(new RunnableC0496q0()).start();
    }

    public void Q1() {
        n2(true);
        new Thread(new RunnableC0498r0()).start();
    }

    public boolean R0(String str, String str2, Context context) {
        w0 w0Var = new w0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new H0(w0Var));
        builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new S0(w0Var));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.M0;
    }

    public void R1() {
        if (this.F.ja("prefPrintSort", true)) {
            AbstractC3132jE.d(new Callable() { // from class: v5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.o1();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: w5
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.p1((Integer) obj);
                }
            });
        } else {
            S1();
        }
    }

    public boolean S0(String str, String str2, Context context) {
        C0 c0 = new C0();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new D0(c0));
        builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new E0(c0));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.M0;
    }

    public void S1() {
        String str;
        try {
            SearchView searchView = this.L1;
            if (searchView != null) {
                searchView.getQuery().length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.F.ja("pref_print_all_curr", false) && Z00.Z) {
            n2(true);
            AbstractC3132jE.d(new Callable() { // from class: j5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.q1();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: k5
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.r1((Integer) obj);
                }
            });
            return;
        }
        Z00 z00 = this.F;
        StringBuilder sb = new StringBuilder();
        sb.append(this.h);
        if (Z00.Z) {
            str = "-" + this.j;
        } else {
            str = "";
        }
        sb.append(str);
        final String strIc = z00.ic(sb.toString());
        n2(true);
        AbstractC3132jE.d(new Callable() { // from class: l5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.s1(strIc);
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: n5
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.t1(strIc, (Integer) obj);
            }
        });
    }

    public boolean T0(String str, String str2, Context context) {
        HandlerC0471e handlerC0471e = new HandlerC0471e();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new DialogInterfaceOnClickListenerC0473f(handlerC0471e));
        builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new DialogInterfaceOnClickListenerC0475g(handlerC0471e));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.N0;
    }

    public void T1() {
        Log.d("trace_2_onChanged=", "start3:print_pdf_action");
        if (this.F.ja("prefPrintSort", true)) {
            AbstractC3132jE.d(new Callable() { // from class: b5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.u1();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: m5
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.v1((Integer) obj);
                }
            });
        } else {
            V1();
        }
    }

    public void U0() {
        Log.d("trace_on_load_finish=", "get_all_names:" + this.g + ":" + this.h + ":" + this.S0);
        A0(0);
    }

    public void U1() {
        n2(true);
        new Thread(new RunnableC0500s0()).start();
    }

    public void V0() {
        U0();
    }

    public void V1() {
        boolean z;
        try {
            SearchView searchView = this.L1;
            z = searchView != null && searchView.getQuery().length() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.F.ja("pref_print_all_curr", false) || z) {
            W1();
        } else {
            U1();
        }
    }

    public void W0(String str) {
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

    public void W1() {
        n2(true);
        new Thread(new RunnableC0502t0()).start();
    }

    public double X0(List list) {
        if (this.S0 == 1) {
            double d = c2;
            this.S0 = 0;
            return d;
        }
        double d2 = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            d2 += Double.parseDouble(((C4064uh) list.get(size)).n().replaceAll(",", "")) * ((double) (((C4064uh) list.get(size)).t() == this.r0[0] ? -1 : ((C4064uh) list.get(size)).t() == this.r0[2] ? 1 : 0));
        }
        return d2;
    }

    public void Y(Handler handler) {
        String string = this.Y0.getText().toString();
        String strT5 = this.i;
        if (strT5 == null) {
            strT5 = this.F.T5("0");
        }
        u2("0", string, "", strT5, "", "", handler);
    }

    public double[] Y0(List list) {
        int i;
        double[] dArr = new double[5];
        dArr[0] = 0.0d;
        char c = 1;
        dArr[1] = 0.0d;
        char c3 = 2;
        dArr[2] = 0.0d;
        char c4 = 3;
        dArr[3] = 0.0d;
        dArr[4] = 0.0d;
        Log.d("sum_filter2=", this.S0 + ":" + c2);
        if (this.S0 == 1) {
            this.S0 = 0;
            if (!this.F.ja("prefOthers_footer2_total", false)) {
                if (list.size() > 0) {
                    c2 = Double.parseDouble(((C4064uh) list.get(list.size() - 1)).f().replace(",", ""));
                }
                dArr[0] = c2;
                return dArr;
            }
        }
        int size = list.size() - 1;
        while (size >= 0) {
            if (((C4064uh) list.get(size)).t() == this.r0[0]) {
                if (((C4064uh) list.get(size)).a.equals("0")) {
                    dArr[4] = Double.parseDouble(((C4064uh) list.get(size)).n().replaceAll(",", ""));
                } else {
                    dArr[c3] = dArr[c3] + Double.parseDouble(((C4064uh) list.get(size)).n().replaceAll(",", ""));
                }
                i = -1;
            } else if (((C4064uh) list.get(size)).t() == this.r0[c3]) {
                if (((C4064uh) list.get(size)).a.equals("0")) {
                    dArr[c4] = Double.parseDouble(((C4064uh) list.get(size)).n().replaceAll(",", ""));
                } else {
                    dArr[c] = dArr[c] + Double.parseDouble(((C4064uh) list.get(size)).n().replaceAll(",", ""));
                }
                i = 1;
            } else {
                i = 0;
            }
            dArr[0] = dArr[0] + (Double.parseDouble(((C4064uh) list.get(size)).n().replaceAll(",", "")) * ((double) i));
            size--;
            c = 1;
            c3 = 2;
            c4 = 3;
        }
        Log.d("sum_filter2=", this.S0 + ":" + dArr[0]);
        return dArr;
    }

    public void Y1() {
        C1044Xj.a().c(new RunnableC1171Zj(2, this.F, this.Y0, this.Z0, this.d1, getActivity(), this.r1, this.f1, new RunnableC1086Yj()));
    }

    public void Z(Handler handler) {
        String string = this.Z0.getText().toString();
        String strT5 = this.i;
        if (strT5 == null) {
            strT5 = this.F.T5("0");
        }
        u2("0", string, "", strT5, "", "", handler);
    }

    public void Z0(int i, int i2) {
        try {
            new Handler().postDelayed(new RunnableC0492o0(i), i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.C4330y1.c
    public void a(int i) {
        if (this.D1 == null) {
            this.D1 = getActivity().startActionMode(this.E1);
        }
        this.e0.m(i);
        this.D1.invalidate();
        int iD = this.e0.d();
        if (iD <= 0) {
            this.D1.finish();
            return;
        }
        this.D1.setTitle(iD + " Selected");
    }

    public void a0() {
        try {
            this.S0 = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.V0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.f_date);
            this.W0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.t_date);
            this.V0.setOnClickListener(new ViewOnClickListenerC0507w());
            this.W0.setOnClickListener(new ViewOnClickListenerC0508x());
            builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_search), new DialogInterfaceOnClickListenerC0510z());
            builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_cancel), new A());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new B(alertDialogCreate));
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public void amount_add_btn(View view) {
        F0(true);
    }

    @Override // defpackage.DE
    public void c(int i, C4064uh c4064uh) {
        try {
            this.n = Integer.parseInt(c4064uh.a.toString());
            this.p = c4064uh.b;
            this.x = c4064uh.a();
            this.q = this.F.P7(c4064uh.c.replace(",", ""));
            this.w = c4064uh.b();
            this.t = c4064uh.r();
            this.u = c4064uh.o() != null ? c4064uh.o() : "";
            this.v = c4064uh.t();
            Log.d("view_item_acc:=", "Click:" + this.u);
            w2();
        } catch (Exception unused) {
        }
    }

    public void c0(View view) {
        F1(true);
    }

    public void c2(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = this.k;
        String str6 = this.l;
        if ((str6 == null || str6.length() < 3) && (i != 4 || this.F.ja("approval_wa", true))) {
            if (i == 2) {
                this.R0 = 5;
            } else if (i == 3) {
                this.R0 = 6;
            } else if (i == 4) {
                this.R0 = 7;
            }
            t2(this.g, this.h, this.l, this.i);
            return;
        }
        String string = getActivity().getString(info.aalmoghalis.inventory.R.string.pref_default_display_name);
        String strIa = this.F.ia("prefSMS_header", string);
        String strIa2 = this.F.ia("prefSMS_footer", string);
        String strIa3 = this.F.ia("prefSMS_credit", string);
        String strIa4 = this.F.ia("prefSMS_debit", string);
        if (strIa3.equals(string)) {
            strIa3 = getActivity().getString(info.aalmoghalis.inventory.R.string.credit);
        }
        if (strIa4.equals(string)) {
            strIa4 = getActivity().getString(info.aalmoghalis.inventory.R.string.debit);
        }
        String str7 = "";
        if (!str5.contains("-")) {
            if (i == 1) {
                Z00 z00 = this.F;
                String str8 = this.l;
                StringBuilder sb = new StringBuilder();
                if (strIa.length() != 0) {
                    strIa4 = strIa + ":\n" + strIa4;
                }
                sb.append(strIa4);
                sb.append(":");
                sb.append(str5);
                if (Z00.Z) {
                    str2 = "\t" + this.j;
                } else {
                    str2 = "";
                }
                sb.append(str2);
                if (strIa2.length() != 0) {
                    str7 = StringUtilities.LF + strIa2;
                }
                sb.append(str7);
                z00.Rc(str8, sb.toString());
                return;
            }
            if (i == 3) {
                Z00 z01 = this.F;
                String str9 = this.l;
                StringBuilder sb2 = new StringBuilder();
                if (strIa.length() != 0) {
                    strIa4 = strIa + ":\n" + strIa4;
                }
                sb2.append(strIa4);
                sb2.append(":");
                sb2.append(str5);
                if (Z00.Z) {
                    str = "\t" + this.j;
                } else {
                    str = "";
                }
                sb2.append(str);
                if (strIa2.length() != 0) {
                    str7 = StringUtilities.LF + strIa2;
                }
                sb2.append(str7);
                z01.Ed(str9, sb2.toString());
                return;
            }
            if (i == 4) {
                if (Build.VERSION.SDK_INT < 31) {
                    d0();
                }
                Z00 z02 = this.F;
                z02.ob(this.h, z02.ic(this.h + "-" + getString(info.aalmoghalis.inventory.R.string.approval)), this.U0);
                if (!this.F.ja("approval_wa", true)) {
                    Z00 z03 = this.F;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.F.ic(this.h + "-" + getString(info.aalmoghalis.inventory.R.string.approval)));
                    sb3.append(".pdf");
                    z03.ra(sb3.toString());
                    return;
                }
                Z00 z04 = this.F;
                String str10 = this.l;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.F.ic(this.h + "-" + getString(info.aalmoghalis.inventory.R.string.approval)));
                sb4.append(".pdf");
                z04.Hd(str10, sb4.toString());
                return;
            }
            if (Build.VERSION.SDK_INT < 31) {
                d0();
            }
            if (!Z00.Z) {
                new C3357m10(getActivity(), this.F).f(this.f0, this.F.ic(this.h), X0(this.e0.c()));
                this.F.Hd(this.l, this.F.ic(this.h) + ".pdf");
                return;
            }
            if (this.F.ja("prefPrintSort", true)) {
                p2(this.A);
                this.e0.notifyDataSetChanged();
                this.h0 = 1;
            }
            new C3357m10(getActivity(), this.F).g(this.f0, this.F.ic(this.h + "-" + this.j), X0(this.e0.c()), this.j, this.T0, this.U0, this.F.ic(this.h));
            Z00 z05 = this.F;
            String str11 = this.l;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.F.ic(this.h + "-" + this.j));
            sb5.append(".pdf");
            z05.Hd(str11, sb5.toString());
            return;
        }
        if (i == 1) {
            Z00 z06 = this.F;
            String str12 = this.l;
            StringBuilder sb6 = new StringBuilder();
            if (strIa.length() != 0) {
                strIa3 = strIa + ":\n" + strIa3;
            }
            sb6.append(strIa3);
            sb6.append(":");
            sb6.append(str5);
            if (Z00.Z) {
                str4 = "\t" + this.j;
            } else {
                str4 = "";
            }
            sb6.append(str4);
            if (strIa2.length() != 0) {
                str7 = StringUtilities.LF + strIa2;
            }
            sb6.append(str7);
            z06.Rc(str12, sb6.toString());
            return;
        }
        if (i == 3) {
            Z00 z07 = this.F;
            String str13 = this.l;
            StringBuilder sb7 = new StringBuilder();
            if (strIa.length() != 0) {
                strIa3 = strIa + ":\n" + strIa3;
            }
            sb7.append(strIa3);
            sb7.append(":");
            sb7.append(str5);
            if (Z00.Z) {
                str3 = "\t" + this.j;
            } else {
                str3 = "";
            }
            sb7.append(str3);
            if (strIa2.length() != 0) {
                str7 = StringUtilities.LF + strIa2;
            }
            sb7.append(str7);
            z07.Ed(str13, sb7.toString());
            return;
        }
        if (i == 4) {
            if (Build.VERSION.SDK_INT < 31) {
                d0();
            }
            Z00 z08 = this.F;
            z08.ob(this.h, z08.ic(this.h + "-" + getString(info.aalmoghalis.inventory.R.string.approval)), this.U0);
            if (!this.F.ja("approval_wa", true)) {
                Z00 z09 = this.F;
                StringBuilder sb8 = new StringBuilder();
                sb8.append(this.F.ic(this.h + "-" + getString(info.aalmoghalis.inventory.R.string.approval)));
                sb8.append(".pdf");
                z09.ra(sb8.toString());
                return;
            }
            Z00 z010 = this.F;
            String str14 = this.l;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(this.F.ic(this.h + "-" + getString(info.aalmoghalis.inventory.R.string.approval)));
            sb9.append(".pdf");
            z010.Hd(str14, sb9.toString());
            return;
        }
        if (Build.VERSION.SDK_INT < 31) {
            d0();
        }
        if (!Z00.Z) {
            new C3357m10(getActivity(), this.F).f(this.f0, this.F.ic(this.h), X0(this.e0.c()));
            this.F.Hd(this.l, this.F.ic(this.h) + ".pdf");
            return;
        }
        if (this.F.ja("prefPrintSort", true)) {
            p2(this.A);
            this.e0.notifyDataSetChanged();
            this.h0 = 1;
        }
        if (this.F.ja("pref_print_all_curr", false)) {
            Z00 z011 = this.F;
            z011.nb(z011.ic(this.h), this.g, this.T0, this.U0, this.F.ic(this.h));
            this.F.Hd(this.l, this.F.ic(this.h) + ".pdf");
            return;
        }
        new C3357m10(getActivity(), this.F).g(this.f0, this.F.ic(this.h + "-" + this.j), X0(this.e0.c()), this.j, this.T0, this.U0, this.F.ic(this.h));
        Z00 z012 = this.F;
        String str15 = this.l;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(this.F.ic(this.h + "-" + this.j));
        sb10.append(".pdf");
        z012.Hd(str15, sb10.toString());
    }

    public void calc_pick_btn(View view) {
        Intent intent = new Intent(view.getContext(), (Class<?>) Calculator.class);
        intent.putExtra("tr_amount", this.P1.getText().toString());
        startActivityForResult(intent, 2);
    }

    public void d0() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public boolean d1() {
        this.T0 = this.T0.isEmpty() ? CSS.Value.PERCENTAGE : this.T0;
        this.U0 = this.U0.isEmpty() ? CSS.Value.PERCENTAGE : this.U0;
        return (this.T0.equals(CSS.Value.PERCENTAGE) && this.U0.equals(CSS.Value.PERCENTAGE)) ? false : true;
    }

    public void d2(String str) {
        try {
            Bitmap bitmapP0 = Z00.p0(Z00.M + str, 300, 300);
            this.k1.getLayoutParams().width = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width);
            this.k1.getLayoutParams().height = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height);
            this.k1.setImageBitmap(bitmapP0);
            this.k1.setTag(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void e0() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_CONTACTS"}, 113);
    }

    public boolean e1() {
        SearchView searchView = this.L1;
        return searchView == null || searchView.getQuery() == null || this.L1.getQuery().length() != 0;
    }

    public void e2() {
        FragmentActivity activity;
        int i;
        StringBuilder sb = new StringBuilder();
        for (int size = this.g0.size() - 1; size >= 0; size--) {
            if (this.g0.valueAt(size)) {
                C4064uh c4064uh = (C4064uh) this.e0.c().get(this.g0.keyAt(size));
                if (c4064uh.t() == this.r0[0]) {
                    activity = getActivity();
                    i = info.aalmoghalis.inventory.R.string.credit;
                } else {
                    activity = getActivity();
                    i = info.aalmoghalis.inventory.R.string.debit;
                }
                sb.append(activity.getString(i));
                sb.append(" ");
                sb.append(c4064uh.n());
                sb.append(" ");
                sb.append(c4064uh.r());
                sb.append(" ");
                sb.append(getActivity().getString(info.aalmoghalis.inventory.R.string.day));
                sb.append(" ");
                sb.append(c4064uh.p().substring(0, 5));
                sb.append(StringUtilities.LF);
            }
        }
        double d = this.J1.size() > 0 ? Double.parseDouble((String) this.J1.get(0)) : 0.0d;
        if (d == 0.0d && getArguments() != null && getArguments().getInt("adv_search") == 1) {
            d = Double.parseDouble(this.k.replace(",", ""));
        }
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

    public void f0(View view, boolean z) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.F).l("-9", z ? "new" : "edit")) {
                Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                return;
            }
        }
        if (z) {
            b2();
        } else {
            D0();
        }
    }

    public final /* synthetic */ String f1() {
        new C3357m10(getActivity(), this.F).g(this.f0, this.X0.getText().toString() + "-" + this.F.ic(this.h) + "-" + this.j, X0(this.e0.c()), this.j, this.T0, this.U0, this.F.ic(this.h));
        return this.F.X(this.g, getActivity().getString(info.aalmoghalis.inventory.R.string.action_settings8) + "-" + this.W0.getText().toString(), this.W0.getText().toString(), !Z00.Z ? "" : this.j);
    }

    public void f2() {
        n2(true);
        AbstractC3132jE.d(new Callable() { // from class: o5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.w1();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: p5
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.x1((Integer) obj);
            }
        });
    }

    public void g0() {
        new C3966tX().f(getActivity(), this.F, this.G, this.h, -1);
    }

    public final /* synthetic */ void g1(String str) {
        n2(false);
        if (str == null || !str.equals("1")) {
            FragmentActivity activity = getActivity();
            StringBuilder sb = new StringBuilder();
            sb.append("Error:");
            if (str != null && str.length() > 20) {
                str = str.substring(0, 20);
            }
            sb.append(str);
            Toast.makeText(activity, sb.toString(), 0).show();
            return;
        }
        this.S0 = 0;
        U0();
        FragmentStatePagerSupport_Main.a0 = true;
        Toast.makeText(getActivity(), this.W0.getText().toString() + "-" + this.F.ic(this.h) + ".pdf", 1).show();
    }

    public void g2() {
        if (Z00.Z) {
            n2(true);
            AbstractC3132jE.d(new Callable() { // from class: h5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.A1();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: i5
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.B1((Integer) obj);
                }
            });
        } else {
            n2(true);
            AbstractC3132jE.d(new Callable() { // from class: f5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.y1();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: g5
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.z1((Integer) obj);
                }
            });
        }
    }

    public boolean h0(int i) {
        int i2;
        boolean z;
        int i3;
        String message;
        String str;
        String str2;
        int iB = MO.b(getActivity());
        C2160f10.h = iB;
        if (iB > 0 && !new C2160f10(this.F).l("-9", "new")) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        if (i == info.aalmoghalis.inventory.R.id.btn_cus_det_add1) {
            i2 = -1;
        } else {
            i2 = i == info.aalmoghalis.inventory.R.id.btn_cus_det_add2 ? 1 : 0;
        }
        r0();
        if (!p0() || i2 == 0) {
            return false;
        }
        try {
            if (this.k1.getTag() == null) {
                Z00 z00 = this.F;
                StringBuilder sb = new StringBuilder();
                sb.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param2,curr_id,user_id) values((select b.id from customers as b where b.name='");
                sb.append(this.h);
                sb.append("'),");
                sb.append(this.a1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb.append(",");
                sb.append(i2);
                sb.append(",'");
                sb.append((Object) this.b1.getText());
                sb.append("','");
                sb.append((Object) this.d1.getText());
                sb.append("',strftime('%Y-%m-%d','now'),'");
                sb.append(this.F.B8());
                sb.append("',");
                if (this.u1.getTag() == null) {
                    str2 = "0";
                } else {
                    str2 = "(select id from currency where name='" + this.u1.getTag().toString() + "')";
                }
                sb.append(str2);
                sb.append(",");
                int i4 = C2160f10.h;
                sb.append(i4 == -1 ? "null" : Integer.valueOf(i4));
                sb.append(")");
                z00.x0(sb.toString());
            } else {
                Z00 z01 = this.F;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param1,param2,curr_id,user_id) values((select b.id from customers as b where b.name='");
                sb2.append(this.h);
                sb2.append("'),");
                sb2.append(this.a1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb2.append(",");
                sb2.append(i2);
                sb2.append(",'");
                sb2.append((Object) this.b1.getText());
                sb2.append("','");
                sb2.append((Object) this.d1.getText());
                sb2.append("',strftime('%Y-%m-%d','now'),'");
                sb2.append(this.k1.getTag().toString());
                sb2.append("','");
                sb2.append(this.F.B8());
                sb2.append("',");
                if (this.u1.getTag() == null) {
                    str = "0";
                } else {
                    str = "(select id from currency where name='" + this.u1.getTag().toString() + "')";
                }
                sb2.append(str);
                sb2.append(",");
                int i5 = C2160f10.h;
                sb2.append(i5 == -1 ? "null" : Integer.valueOf(i5));
                sb2.append(")");
                z01.x0(sb2.toString());
            }
            this.a1.setText((CharSequence) null);
            Calendar calendar = Calendar.getInstance();
            this.b1.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
            this.i0 = calendar.get(1);
            this.j0 = calendar.get(2);
            this.k0 = calendar.get(5);
            Z1(this.k1);
            this.d1.setText((CharSequence) null);
            this.a1.requestFocus();
            try {
                FragmentStatePagerSupport_Main.a0 = true;
                return true;
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
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public void h2() {
        Log.d("trace_2_onChanged=", "start3:print_pdf_action");
        if (this.F.ja("prefPrintSort", true)) {
            AbstractC3132jE.d(new Callable() { // from class: s5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.C1();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: t5
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.D1((Integer) obj);
                }
            });
        } else {
            c2(2);
        }
    }

    public void help_btn(View view) {
        if (((Integer) view.getTag()).intValue() != 2) {
            c2(((Integer) view.getTag()).intValue());
        } else if (d1()) {
            h2();
        } else {
            A0(6);
        }
    }

    public boolean i0() {
        boolean z;
        int i;
        String message;
        int iB = MO.b(getActivity());
        C2160f10.h = iB;
        if (iB > 0 && !new C2160f10(this.F).l("-9", "new")) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        s0();
        if (!q0()) {
            return false;
        }
        try {
            String str = "0";
            if (this.k1.getTag() == null) {
                Z00 z00 = this.F;
                StringBuilder sb = new StringBuilder();
                sb.append("insert into transactions (cus_id,t_cus_id,out,[in],date_,remarks,now_,param2,curr_id,user_id) values((select b.id from customers as b where b.name='");
                sb.append(this.Y0.getText().toString());
                sb.append("'),(select b.id from customers as b where b.name='");
                sb.append(this.Z0.getText().toString());
                sb.append("'),");
                sb.append(this.a1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb.append(",");
                sb.append(1);
                sb.append(",'");
                sb.append((Object) this.b1.getText());
                sb.append("','");
                sb.append((Object) this.d1.getText());
                sb.append("',strftime('%Y-%m-%d','now'),'");
                sb.append(this.F.B8());
                sb.append("',");
                if (this.u1.getTag() != null) {
                    str = "(select id from currency where name='" + this.u1.getTag().toString() + "')";
                }
                sb.append(str);
                sb.append(",");
                int i2 = C2160f10.h;
                sb.append(i2 == -1 ? "null" : Integer.valueOf(i2));
                sb.append(")");
                z00.x0(sb.toString());
            } else {
                Z00 z01 = this.F;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("insert into transactions (cus_id,t_cus_id,out,[in],date_,remarks,now_,param1,param2,curr_id,user_id) values((select b.id from customers as b where b.name='");
                sb2.append(this.Y0.getText().toString());
                sb2.append("'),(select b.id from customers as b where b.name='");
                sb2.append(this.Z0.getText().toString());
                sb2.append("'),");
                sb2.append(this.a1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                sb2.append(",");
                sb2.append(1);
                sb2.append(",'");
                sb2.append((Object) this.b1.getText());
                sb2.append("','");
                sb2.append((Object) this.d1.getText());
                sb2.append("',strftime('%Y-%m-%d','now'),'");
                sb2.append(this.k1.getTag().toString());
                sb2.append("','");
                sb2.append(this.F.B8());
                sb2.append("',");
                if (this.u1.getTag() != null) {
                    str = "(select id from currency where name='" + this.u1.getTag().toString() + "')";
                }
                sb2.append(str);
                sb2.append(",");
                int i3 = C2160f10.h;
                sb2.append(i3 == -1 ? "null" : Integer.valueOf(i3));
                sb2.append(" )");
                z01.x0(sb2.toString());
            }
            W0(this.Y0.getText().toString());
            this.Y0.setText((CharSequence) null);
            this.Z0.setText((CharSequence) null);
            this.a1.setText((CharSequence) null);
            Calendar calendar = Calendar.getInstance();
            this.b1.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
            this.i0 = calendar.get(1);
            this.j0 = calendar.get(2);
            this.k0 = calendar.get(5);
            Z1(this.k1);
            this.d1.setText((CharSequence) null);
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

    public void i2() {
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
        listView.setOnItemClickListener(new C0505v(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        listView.setDividerHeight(0);
        linearLayout.addView(listView, -1, -1);
        dialog.requestWindowFeature(1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public boolean j0() {
        int i;
        boolean z;
        int i2;
        String message;
        boolean z2;
        boolean z3;
        if (C2160f10.h > 0 && !new C2160f10(this.F).l("-9", "edit")) {
            Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
            return false;
        }
        if (this.m1.isChecked()) {
            i = -1;
        } else {
            i = this.n1.isChecked() ? 1 : 0;
        }
        r0();
        if (!t0()) {
            return false;
        }
        try {
            if (!this.f1.getText().toString().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save)) || this.n == 0) {
                z2 = true;
                z3 = false;
            } else {
                String str = "0";
                if (this.k1.getTag() == null) {
                    Z00 z00 = this.F;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update transactions set out='");
                    sb.append(this.a1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',[in]='");
                    sb.append(i);
                    sb.append("',date_='");
                    sb.append((Object) this.b1.getText());
                    sb.append("',remarks='");
                    sb.append((Object) this.d1.getText());
                    sb.append("',param1='',curr_id=");
                    if (this.u1.getTag() != null) {
                        str = "(select id from currency where name='" + this.u1.getTag().toString() + "')";
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
                    sb2.append(this.a1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',[in]='");
                    sb2.append(i);
                    sb2.append("',date_='");
                    sb2.append((Object) this.b1.getText());
                    sb2.append("',remarks='");
                    sb2.append((Object) this.d1.getText());
                    sb2.append("',param1='");
                    sb2.append(this.k1.getTag().toString());
                    sb2.append("',curr_id=");
                    if (this.u1.getTag() != null) {
                        str = "(select id from currency where name='" + this.u1.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(" where id='");
                    sb2.append(this.n);
                    sb2.append("'");
                    z01.x0(sb2.toString());
                }
                this.a1.setText((CharSequence) null);
                Calendar calendar = Calendar.getInstance();
                this.b1.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                this.i0 = calendar.get(1);
                this.j0 = calendar.get(2);
                this.k0 = calendar.get(5);
                this.d1.setText((CharSequence) null);
                Z1(this.k1);
                this.f1.setText(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_add));
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

    public void j2() {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        this.n0 = getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles_share);
        this.o0 = getActivity().getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons_share);
        ListView listView = new ListView(getActivity());
        this.p0 = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = this.n0;
            if (i >= strArr.length) {
                this.o0.recycle();
                C4062ug c4062ug = new C4062ug(getActivity(), this.p0);
                this.q0 = c4062ug;
                listView.setAdapter((ListAdapter) c4062ug);
                listView.setOnItemClickListener(new C0503u(dialog));
                linearLayout.setFocusable(true);
                listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                listView.setDividerHeight(0);
                linearLayout.addView(listView, -1, -1);
                dialog.requestWindowFeature(1);
                dialog.setContentView(linearLayout);
                dialog.show();
                return;
            }
            this.p0.add(new C3874sM(strArr[i], this.o0.getResourceId(i, -1)));
            i++;
        }
    }

    public boolean k0() {
        boolean z;
        int i;
        String message;
        boolean z2;
        int i2 = this.v;
        int[] iArr = this.r0;
        if (i2 != iArr[0]) {
            int i3 = iArr[2];
        }
        s0();
        if (!q0()) {
            return false;
        }
        try {
            if (!this.f1.getText().toString().equals(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save)) || this.n == 0) {
                z2 = true;
                z = false;
            } else {
                String str = "0";
                if (this.k1.getTag() == null) {
                    Z00 z00 = this.F;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update transactions set out='");
                    sb.append(this.a1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb.append("',date_='");
                    sb.append((Object) this.b1.getText());
                    sb.append("',remarks='");
                    sb.append((Object) this.d1.getText());
                    sb.append("',param1='',t_cus_id=(select id from customers where name='");
                    sb.append(this.Z0.getText().toString());
                    sb.append("') ,cus_id=(select id from customers where name='");
                    sb.append(this.Y0.getText().toString());
                    sb.append("') ,curr_id=");
                    if (this.u1.getTag() != null) {
                        str = "(select id from currency where name='" + this.u1.getTag().toString() + "')";
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
                    sb2.append(this.a1.getText().toString().replaceAll(",", "").replaceAll("-", ""));
                    sb2.append("',date_='");
                    sb2.append((Object) this.b1.getText());
                    sb2.append("',remarks='");
                    sb2.append((Object) this.d1.getText());
                    sb2.append("',param1='");
                    sb2.append(this.k1.getTag().toString());
                    sb2.append("',t_cus_id=(select id from customers where name='");
                    sb2.append(this.Z0.getText().toString());
                    sb2.append("') ,cus_id=(select id from customers where name='");
                    sb2.append(this.Y0.getText().toString());
                    sb2.append("') ,curr_id=");
                    if (this.u1.getTag() != null) {
                        str = "(select id from currency where name='" + this.u1.getTag().toString() + "')";
                    }
                    sb2.append(str);
                    sb2.append(" where id='");
                    sb2.append(this.n);
                    sb2.append("'");
                    z01.x0(sb2.toString());
                }
                this.Y0.setText((CharSequence) null);
                this.a1.setText((CharSequence) null);
                Calendar calendar = Calendar.getInstance();
                this.b1.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.getTime()));
                this.i0 = calendar.get(1);
                this.j0 = calendar.get(2);
                this.k0 = calendar.get(5);
                this.d1.setText((CharSequence) null);
                Z1(this.k1);
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

    public void k2(int i, Dialog dialog) {
        try {
            if (i == 0) {
                dialog.dismiss();
                if (d1()) {
                    g2();
                    return;
                } else {
                    A0(3);
                    return;
                }
            }
            if (i == 1) {
                if (Build.VERSION.SDK_INT < 31) {
                    d0();
                }
                if (this.e0.c().size() > 100) {
                    Toast.makeText(getActivity(), "Share PDF as the data is too long!", 1).show();
                    return;
                }
                this.F.Wd(this.F.g1(this.f0, this.s0), "cus_details.jpg");
                this.F.rd("cus_details.jpg");
                dialog.dismiss();
                return;
            }
            if (i == 2) {
                this.R0 = 2;
                String str = this.l;
                if (str == null || str.length() < 3) {
                    t2(this.g, this.h, this.l, this.i);
                } else {
                    Z00 z00 = this.F;
                    z00.Rc(this.l, z00.vd(this.f0, this.h, X0(this.e0.c())));
                }
                dialog.dismiss();
                return;
            }
            if (i == 3) {
                if (Build.VERSION.SDK_INT < 31) {
                    d0();
                }
                dialog.dismiss();
                if (d1()) {
                    f2();
                } else {
                    A0(4);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("share_err", e.getMessage() + "");
        }
    }

    public void l0() {
        c2 = 0.0d;
        try {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                c2 += Double.parseDouble(((C4064uh) this.A.get(size)).n().replaceAll(",", "")) * (Double.parseDouble(((C4064uh) this.A.get(size)).f().replaceAll(",", "")) - 1.0d);
                Log.d("net_bal=", this.h + ":" + c2 + ":" + ((C4064uh) this.A.get(size)).n() + ":" + ((C4064uh) this.A.get(size)).f());
                C4064uh c4064uh = (C4064uh) this.A.get(size);
                c4064uh.w(String.valueOf(c2));
                this.A.set(size, c4064uh);
            }
        } catch (Exception unused) {
        }
    }

    public void l2(boolean z) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.x1 = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, this.F.F8(this.h, ""));
        this.d1.setThreshold(1);
        this.d1.setAdapter(this.x1);
        if (z) {
            this.p1.setVisibility(8);
            this.s1.setVisibility(0);
            this.t1.setVisibility(0);
            H0();
            this.b1.setText(simpleDateFormat.format(calendar.getTime()));
            this.b1.setOnClickListener(new ViewOnClickListenerC0470d0());
            return;
        }
        this.s1.setVisibility(8);
        this.p1.setVisibility(0);
        this.f1.setText(getActivity().getString(info.aalmoghalis.inventory.R.string.btn_save));
        this.d1.setText(this.t);
        this.b1.setText(this.p);
        this.a1.setText(this.q);
        int i = this.v;
        int[] iArr = this.r0;
        if (i == iArr[0]) {
            this.m1.setChecked(true);
        } else if (i == iArr[2]) {
            this.n1.setChecked(true);
        }
        if (!this.u.equals("")) {
            this.k1.setImageBitmap(Z00.p0(Z00.M + this.u, 100, 100));
            this.k1.setTag(this.u);
            this.k1.getLayoutParams().width = 100;
            this.k1.getLayoutParams().height = 70;
        }
        this.a1.selectAll();
        this.a1.requestFocus();
        Z0(4, 500);
        this.t1.setVisibility(0);
        H0();
        this.b1.setOnClickListener(new ViewOnClickListenerC0472e0());
    }

    public void m2(boolean z) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.Y0.setThreshold(1);
        this.Z0.setThreshold(1);
        this.d1.setThreshold(1);
        Y1();
        this.Y0.setOnItemClickListener(new C0474f0());
        this.Z0.setOnItemClickListener(new C0476g0());
        this.Y0.setOnTouchListener(new ViewOnTouchListenerC0478h0());
        this.Y0.addTextChangedListener(new C0480i0());
        this.Z0.setOnTouchListener(new ViewOnTouchListenerC0482j0());
        this.Z0.addTextChangedListener(new C0484k0());
        this.d1.addTextChangedListener(new C0486l0());
        this.b1.setText(simpleDateFormat.format(calendar.getTime()));
        this.t1.setVisibility(0);
        H0();
        this.b1.setOnClickListener(new ViewOnClickListenerC0488m0());
        if (z) {
            return;
        }
        this.Y0.setText(this.z);
        this.Z0.setText(this.y);
        this.d1.setText(this.t);
        this.b1.setText(this.p);
        this.a1.setText(this.q);
        if (!this.u.equals("")) {
            this.k1.setImageBitmap(Z00.p0(Z00.M + this.u, 100, 100));
            this.k1.setTag(this.u);
            this.k1.getLayoutParams().width = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width);
            this.k1.getLayoutParams().height = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height);
        }
        this.a1.selectAll();
        this.a1.requestFocus();
        Z0(4, 500);
    }

    public void n0(View view) {
        String str = this.l;
        if (str != null && str.length() >= 3) {
            this.F.n0(this.l);
        } else {
            this.R0 = 1;
            t2(this.g, this.h, this.l, this.i);
        }
    }

    public final /* synthetic */ void n1(Uri uri) {
        if (uri == null) {
            Log.d("trace_PhotoPicker", "No media selected");
            return;
        }
        Log.d("trace_PhotoPicker", "Selected URI: " + uri);
        M1(uri, true);
    }

    public void n2(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setView(getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.progress, (ViewGroup) null));
            if (z) {
                android.app.AlertDialog alertDialogCreate = builder.create();
                this.F1 = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.F1;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ Integer o1() {
        p2(this.A);
        this.h0 = 1;
        return 1;
    }

    public void o2() {
        C4064uh c4064uhP0 = this.F.P0(this.h);
        if (C1839c10.k(this.F, this.g) || C1839c10.k(this.F, c4064uhP0.m())) {
            try {
                g0();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.F.ja("prefAutoNotify", true)) {
            TextView textView = (TextView) ((Snackbar.SnackbarLayout) this.Q0.getView()).findViewById(info.aalmoghalis.inventory.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(getActivity(), info.aalmoghalis.inventory.R.color.white));
            C4064uh c4064uhK0 = K0();
            StringBuilder sb = new StringBuilder();
            sb.append(c4064uhK0.t() == this.r0[0] ? this.z0 : this.A0);
            sb.append(" ");
            sb.append(c4064uhK0.n());
            sb.append(" ");
            sb.append(c4064uhK0.r());
            this.Q0.setText(sb.toString());
            this.Q0.setAction(this.E0, new ViewOnClickListenerC0497r());
            textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getActivity(), android.R.drawable.ic_menu_share), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setOnClickListener(new ViewOnClickListenerC0499s());
            ViewCompat.setLayoutDirection(this.Q0.getView(), 1);
            this.Q0.show();
            new Handler().postDelayed(new RunnableC0501t(), 5000);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.Q0 = Snackbar.make(getActivity().findViewById(android.R.id.content), "", -2);
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
                        this.O1.setText(string);
                        cursorQuery.close();
                    }
                } else if (i == 2) {
                    if (intent != null) {
                        this.P1.setText(this.F.S7(intent.getStringExtra("calc_result")));
                    }
                } else if (i == this.R1 && intent != null) {
                    M1(intent.getData(), false);
                } else if (i == this.Q1) {
                    J1(intent);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q2(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bill_edit.P2 = false;
            this.g = getArguments() != null ? getArguments().getString("cus_id") : "";
            String string = getArguments() != null ? getArguments().getString("cus_name") : "";
            this.h = string;
            Log.d("cus_name_oncreate=", string);
            this.l = getArguments() != null ? getArguments().getString("cus_gsm") : "";
            this.i = getArguments() != null ? getArguments().getString("g_name") : "";
            this.j = getArguments() != null ? getArguments().getString("curr_name") : "";
            this.k = getArguments() != null ? getArguments().getString("cus_bal") : "";
            this.C = (getArguments() != null ? Integer.valueOf(getArguments().getInt(CSS.Property.POSITION)) : null).intValue();
            this.D = (getArguments() != null ? Integer.valueOf(getArguments().getInt("size")) : null).intValue();
            this.B = getArguments() != null ? getArguments().getString("searchString") : "";
            this.F = new Z00(this.E, getActivity());
            C0990Vh c0990Vh = (C0990Vh) ViewModelProviders.of(this).get(C0990Vh.class);
            this.t0 = c0990Vh;
            c0990Vh.b.observe(this, new C0491o());
            this.t0.c.observe(this, new C0509y());
            this.t0.j.observe(this, new J());
            this.I = this.F.ia("show_move_tr", "0").equals("1");
            this.J = this.F.ia("show_move_tr_name", "");
            this.S0 = getArguments() != null ? getArguments().getInt("adv_search") : 0;
            Bundle arguments = getArguments();
            String string2 = CSS.Value.PERCENTAGE;
            this.T0 = arguments != null ? getArguments().getString("f_date") : CSS.Value.PERCENTAGE;
            if (getArguments() != null) {
                string2 = getArguments().getString("t_date");
            }
            this.U0 = string2;
            this.A = getArguments() != null ? (List) getArguments().getSerializable("cus_det") : null;
            Calendar calendar = Calendar.getInstance();
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            this.i0 = calendar.get(1);
            this.j0 = calendar.get(2);
            this.k0 = calendar.get(5);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(info.aalmoghalis.inventory.R.menu.menu_main2_2, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View viewInflate = layoutInflater.inflate(info.aalmoghalis.inventory.R.layout.activity_customer_det3_rv, viewGroup, false);
            Log.d("onCreateView", O0() + "#" + this.h);
            setHasOptionsMenu(true);
            this.I0 = getActivity();
            this.J0 = -1;
            this.N = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.footer_sum);
            this.O = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.footer_sum2);
            this.P = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.footer_sum3);
            this.R = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.linear_footer_bal3_);
            this.S = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.linear_footer_bal4_);
            this.Q = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.footer_old_bal);
            this.T = viewInflate.findViewById(info.aalmoghalis.inventory.R.id.primerdivisor2_);
            this.G = new E00(getActivity());
            this.N.setOnClickListener(new K());
            this.U = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img);
            this.V = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_add_amount);
            this.W = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_fwd_amount);
            this.X = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_call);
            this.Y = (ImageView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.img_help);
            if (this.F.ja("prefOthers_whats_bus", false)) {
                this.Y.setImageDrawable(ContextCompat.getDrawable(getActivity(), info.aalmoghalis.inventory.R.drawable.whatsapp_bus));
                this.Y.setTag(2);
            } else {
                this.Y.setImageDrawable(ContextCompat.getDrawable(getActivity(), info.aalmoghalis.inventory.R.drawable.whatsapp2));
                this.Y.setTag(2);
            }
            this.V.setOnClickListener(this.L0);
            this.W.setOnClickListener(this.L0);
            this.X.setOnClickListener(this.L0);
            this.Y.setOnClickListener(this.L0);
            this.Z = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_date);
            this.a0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_amount);
            this.b0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_remarks);
            this.c0 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tr_bal);
            this.F.ld(getActivity(), this.Z, this.h0);
            TextView textView = this.Z;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            TextView textView2 = this.c0;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            TextView textView3 = this.a0;
            textView3.setPaintFlags(textView3.getPaintFlags() | 8);
            TextView textView4 = this.b0;
            textView4.setPaintFlags(textView4.getPaintFlags() | 8);
            C0372Bn c0372Bn = C0372Bn.f;
            c0372Bn.a(getActivity(), this.Z);
            c0372Bn.a(getActivity(), this.a0);
            c0372Bn.a(getActivity(), this.b0);
            c0372Bn.a(getActivity(), this.c0);
            this.Z.setOnClickListener(this);
            this.a0.setOnClickListener(this);
            this.b0.setOnClickListener(this);
            this.c0.setOnClickListener(this);
            this.U.setOnClickListener(this);
            this.Z.setTextColor(-1);
            this.a0.setTextColor(-1);
            this.b0.setTextColor(-1);
            this.c0.setTextColor(-1);
            this.s0 = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.edit_cus_header);
            this.f0 = (RecyclerView) viewInflate.findViewById(android.R.id.list);
            this.f0.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.activity_main_swipe_refresh_layout);
            this.H0 = swipeRefreshLayout;
            swipeRefreshLayout.setOnRefreshListener(new V());
            TextView textView5 = (TextView) viewInflate.findViewById(android.R.id.empty);
            this.d0 = textView5;
            textView5.setText(getString(info.aalmoghalis.inventory.R.string.wait));
            this.d0.setOnClickListener(this.L0);
            this.x0 = getActivity().getString(info.aalmoghalis.inventory.R.string.footer_cus_null);
            this.y0 = this.F.Q2() + ":- ";
            this.B0 = this.F.c5() + ":-";
            this.z0 = this.F.Q2();
            this.A0 = this.F.c5();
            this.K0 = getActivity().getString(info.aalmoghalis.inventory.R.string.old_balance) + ":";
            this.D0 = getActivity().getString(info.aalmoghalis.inventory.R.string.share_tr);
            this.E0 = getActivity().getString(info.aalmoghalis.inventory.R.string.hide_tr);
            this.C0 = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_w_h);
            this.F0 = getActivity().getResources().getStringArray(info.aalmoghalis.inventory.R.array.titles4);
            this.G0 = getActivity().getResources().obtainTypedArray(info.aalmoghalis.inventory.R.array.icons4);
            try {
                Log.d("trace_view_V=", getUserVisibleHint() + ":" + this.h + ":" + this.b2 + ":" + isResumed() + ":" + this.S0);
                if (getUserVisibleHint()) {
                    A0(0);
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
        Log.d("trace_view_D=", this.h + ":" + getUserVisibleHint() + "::" + this.b2);
        this.b2 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == info.aalmoghalis.inventory.R.id.action1) {
            j2();
            return true;
        }
        if (itemId == info.aalmoghalis.inventory.R.id.action5) {
            a0();
            return true;
        }
        if (itemId == info.aalmoghalis.inventory.R.id.action_thermal) {
            Intent intent = new Intent(getActivity(), this.F.ja("prefThermalBluetooth", true) ? MainActivity.class : MainActivity2.class);
            intent.putExtra("cus_id", this.g);
            intent.putExtra("f_date", this.T0);
            intent.putExtra("t_date", this.U0);
            intent.putExtra("curr_name", this.j);
            startActivity(intent);
        } else {
            if (itemId == info.aalmoghalis.inventory.R.id.action4) {
                if (Build.VERSION.SDK_INT < 31) {
                    d0();
                }
                if (d1()) {
                    T1();
                } else {
                    A0(1);
                }
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.excel) {
                if (Build.VERSION.SDK_INT < 31) {
                    d0();
                }
                if (d1()) {
                    R1();
                } else {
                    A0(2);
                }
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action2) {
                c2(1);
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action_approval) {
                c2(4);
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action_print_bills) {
                d0();
                P1();
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action_print_docs) {
                d0();
                Q1();
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action2_) {
                c2(3);
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action3) {
                w0();
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action_notification) {
                I1();
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.cus_limit) {
                if (C2160f10.h > 0 && !new C2160f10(this.F).l("31", "view")) {
                    Toast.makeText(getActivity(), getActivity().getString(info.aalmoghalis.inventory.R.string.no_priv), 0).show();
                    return true;
                }
                Intent intent2 = new Intent(getActivity(), (Class<?>) CusLimit_edit.class);
                intent2.putExtra("cus_name", this.h + "");
                startActivity(intent2);
                return true;
            }
            if (itemId == 16908332) {
                getActivity().finish();
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action_move) {
                F1(true);
                return true;
            }
            if (itemId == info.aalmoghalis.inventory.R.id.action_print_bills_thermal) {
                Intent intent3 = new Intent(getActivity(), this.F.ja("prefThermalBluetooth", true) ? MainActivity.class : MainActivity2.class);
                List listO2 = this.F.o2(this.h, this.T0, this.U0, this.j);
                Z00.j0.clear();
                for (int i = 0; i < listO2.size(); i++) {
                    Z00.j0.add(new String[]{((C4145vh) listO2.get(i)).v(), ((C4145vh) listO2.get(i)).n()});
                }
                startActivity(intent3);
                return true;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StringBuilder sb = new StringBuilder();
        sb.append("onPause:");
        sb.append(this.e0 == null ? "null" : "notNull");
        sb.append(":");
        sb.append(this.h);
        Log.d("trace_on_load_finish=", sb.toString());
        if (this.M.booleanValue()) {
            this.M = Boolean.FALSE;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        try {
            if (!this.F.ja("approval_wa", true)) {
                menu.findItem(info.aalmoghalis.inventory.R.id.action_approval).setTitle(getString(info.aalmoghalis.inventory.R.string.approval_title));
            }
        } catch (Exception unused) {
        }
        MenuItem menuItemFindItem = menu.findItem(info.aalmoghalis.inventory.R.id.search);
        this.L1 = (SearchView) MenuItemCompat.getActionView(menuItemFindItem);
        this.L1.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        this.L1.setQueryHint(getActivity().getString(info.aalmoghalis.inventory.R.string.search_hint));
        this.L1.setOnQueryTextListener(null);
        this.L1.setOnQueryTextListener(new x0());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new y0());
        super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            b0(getActivity().getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_storage));
            return;
        }
        if (i == 113) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            b0(getActivity().getString(info.aalmoghalis.inventory.R.string.permissions_not_granted_write_contacts));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.S0);
            sb.append("###");
            sb.append(this.h);
            sb.append(":");
            sb.append(this.T0);
            sb.append(":");
            sb.append(Bill_edit.P2);
            sb.append(":");
            sb.append(Bill_edit.R2);
            sb.append(":");
            sb.append(this.e0 == null ? "Null" : "NotNull");
            Log.d("onresume=", sb.toString());
            if (Bill_edit.P2) {
                String str = this.h;
                if (str == null || str.equals(Bill_edit.R2)) {
                    Bill_edit.P2 = false;
                    Bill_edit.R2 = "";
                    A0(0);
                } else {
                    Bill_edit.P2 = false;
                    Bill_edit.R2 = "";
                    A0(0);
                }
            } else if (this.e0 != null && getUserVisibleHint() && this.G.i > 0) {
                new C3966tX().y(getActivity(), this.F, this.G, this.h);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.L = Boolean.TRUE;
        if (this.M.booleanValue()) {
            this.L.booleanValue();
        }
    }

    public final /* synthetic */ void p1(Integer num) {
        this.e0.notifyDataSetChanged();
        S1();
    }

    public final /* synthetic */ Integer q1() throws Throwable {
        Z00 z00 = this.F;
        z00.Ta(z00.ic(this.h), this.g, this.T0, this.U0, this.F.ic(this.h));
        return 1;
    }

    public void q2(View view) {
        n2(true);
        new C3966tX().z(getActivity(), this.f0, this.d0, -1);
        new Thread(new RunnableC0504u0(view)).start();
    }

    public final /* synthetic */ void r1(Integer num) {
        n2(false);
        this.F.pa(this.F.ic(this.h) + ".xls");
    }

    public void r2() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            Log.d("camera_file=", HTML.Attribute.START);
            Uri uriJ2 = this.F.J2(getActivity(), intent);
            this.V1 = uriJ2;
            intent.putExtra(HTML.Tag.OUTPUT, uriJ2);
            Log.d("camera_file=", this.V1.getPath() + "");
            startActivityForResult(intent, this.Q1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final /* synthetic */ Integer s1(String str) throws Throwable {
        new C3357m10(getActivity(), this.F).d(this.f0, str, X0(this.e0.c()), Z00.Z ? this.j : "", this.T0, this.U0);
        return 1;
    }

    public void s2() {
        try {
            String string = this.Y0.getText().toString();
            this.Y0.setText(this.Z0.getText());
            this.Z0.setText(string);
            Y1();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Log.d("trace_view_S=", this.h + ":" + getUserVisibleHint() + ":" + z + ":" + this.b2 + ":" + isResumed());
        if (z && this.h != null && isResumed()) {
            A0(0);
        }
    }

    public final /* synthetic */ void t1(String str, Integer num) {
        n2(false);
        this.F.pa(str + ".xls");
    }

    public void t2(String str, String str2, String str3, String str4) {
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
            autoCompleteTextView.setOnItemClickListener(new G0(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new I0(autoCompleteTextView));
            this.O1 = editText2;
            editText2.requestFocus();
            imageView.setOnClickListener(new J0());
            imageView2.setOnClickListener(new K0(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new L0());
            builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new M0());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new N0(editText2, autoCompleteTextView, str, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void u0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        ListView listView = new ListView(getActivity());
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new F0(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(info.aalmoghalis.inventory.R.string.pref_group_curr));
        dialog.show();
    }

    public final /* synthetic */ Integer u1() {
        p2(this.e0.c());
        this.h0 = 1;
        return 1;
    }

    public void u2(String str, String str2, String str3, String str4, String str5, String str6, Handler handler) {
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
            autoCompleteTextView.setOnItemClickListener(new C0477h(autoCompleteTextView, editText3));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, this.F.x3());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter2);
            autoCompleteTextView2.setOnItemClickListener(new C0479i(autoCompleteTextView2, editText2));
            this.O1 = editText2;
            if (!str.equals("0")) {
                editText2.requestFocus();
            } else if (autoCompleteTextView2.getText().toString().length() == 0) {
                autoCompleteTextView2.requestFocus();
            } else {
                editText.requestFocus();
            }
            imageView.setOnClickListener(new ViewOnClickListenerC0481j());
            imageView2.setOnClickListener(new ViewOnClickListenerC0483k(arrayAdapter, autoCompleteTextView, editText3));
            imageView3.setOnClickListener(new ViewOnClickListenerC0485l(arrayAdapter2, autoCompleteTextView2, editText2));
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new DialogInterfaceOnClickListenerC0487m());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new DialogInterfaceOnClickListenerC0489n());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new ViewOnClickListenerC0493p(editText, autoCompleteTextView, autoCompleteTextView2, str, alertDialogCreate, editText2, editText3, handler));
        } catch (Exception e) {
            Log.d("edit_cus_error=", e.getMessage());
            e.printStackTrace();
        }
    }

    public void v0(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        Dialog dialog = new Dialog(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        autoCompleteTextView.setText("");
        ListView listView = new ListView(getActivity());
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new C0495q(autoCompleteTextView, dialog, editText));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(autoCompleteTextView.getHint().toString());
        dialog.show();
    }

    public final /* synthetic */ void v1(Integer num) {
        this.e0.notifyDataSetChanged();
        V1();
    }

    public void v2() {
        I0();
        if (this.S0 == 1) {
            M0(1);
            p2(this.A);
            this.e0.notifyDataSetChanged();
            this.h0 = 1;
        }
    }

    public void w0() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.f_date);
            this.V0 = textView;
            textView.setVisibility(8);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.t_date);
            this.W0 = textView2;
            textView2.setOnClickListener(new C());
            builder.setMessage(getActivity().getString(info.aalmoghalis.inventory.R.string.close_balance));
            builder.setPositiveButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_yes), new D());
            builder.setNegativeButton(getActivity().getString(info.aalmoghalis.inventory.R.string.confirm_no), new E());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getWindow().setSoftInputMode(4);
        } catch (Exception e) {
            Log.d("closing_balance_error=", e.getMessage());
        }
    }

    public final /* synthetic */ Integer w1() throws Throwable {
        String str;
        if (this.F.ja("pref_print_all_curr", false) && Z00.Z) {
            Z00 z00 = this.F;
            z00.Ta(z00.ic(this.h), this.g, this.T0, this.U0, this.F.ic(this.h));
        } else {
            Z00 z01 = this.F;
            StringBuilder sb = new StringBuilder();
            sb.append(this.h);
            if (Z00.Z) {
                str = "-" + this.j;
            } else {
                str = "";
            }
            sb.append(str);
            new C3357m10(getActivity(), this.F).d(this.f0, z01.ic(sb.toString()), X0(this.e0.c()), Z00.Z ? this.j : "", this.T0, this.U0);
        }
        return 1;
    }

    public void w2() {
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
                imageView.getLayoutParams().width = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_width);
                imageView.getLayoutParams().height = (int) getActivity().getResources().getDimension(info.aalmoghalis.inventory.R.dimen.attach_height);
            }
            builder.setCancelable(true);
            if (imageView.getTag() != null) {
                builder.setNeutralButton(getString(info.aalmoghalis.inventory.R.string.view_image), new F(imageView));
            }
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.edit_transaction), new G());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_OK), new H());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.h);
            alertDialogCreate.show();
        } catch (Exception e) {
            Log.d("adv_search_error=", ":" + e.getMessage());
        }
    }

    public void x0() {
        n2(true);
        AbstractC3132jE.d(new Callable() { // from class: q5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.f1();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: r5
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.g1((String) obj);
            }
        });
    }

    public final /* synthetic */ void x1(Integer num) {
        String str;
        n2(false);
        if (this.F.ja("pref_print_all_curr", false) && Z00.Z) {
            this.F.pd(this.F.ic(this.h) + ".xls");
            return;
        }
        Z00 z00 = this.F;
        StringBuilder sb = new StringBuilder();
        sb.append(this.h);
        if (Z00.Z) {
            str = "-" + this.j;
        } else {
            str = "";
        }
        sb.append(str);
        String strIc = z00.ic(sb.toString());
        this.F.pd(strIc + ".xls");
    }

    public void y0() {
        try {
            if (this.F.ja("black_list", false)) {
                this.F.Lc("black_date", "");
                this.F.Lc("black_date_done", "");
                this.F.F0(getActivity());
            }
            e0();
            this.F.qe(getActivity(), getActivity());
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
    }

    public final /* synthetic */ Integer y1() {
        new C3357m10(getActivity(), this.F).f(this.f0, this.F.ic(this.h), X0(this.e0.c()));
        return 1;
    }

    public final /* synthetic */ void z1(Integer num) {
        n2(false);
        this.F.sd(this.F.ic(this.h) + ".pdf");
    }

    /* JADX INFO: renamed from: F5$i0, reason: case insensitive filesystem */
    public class C0480i0 implements TextWatcher {
        public C0480i0() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= 0) {
                F5.this.Y0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                F5 f5 = F5.this;
                f5.Y0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(f5.getActivity(), android.R.drawable.ic_notification_clear_all), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: F5$k0, reason: case insensitive filesystem */
    public class C0484k0 implements TextWatcher {
        public C0484k0() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= 0) {
                F5.this.Z0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                F5 f5 = F5.this;
                f5.Z0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(f5.getActivity(), android.R.drawable.ic_notification_clear_all), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: F5$l0, reason: case insensitive filesystem */
    public class C0486l0 implements TextWatcher {
        public C0486l0() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            F5.this.Y1();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public void m0() {
    }

    public class E implements DialogInterface.OnClickListener {
        public E() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class H implements DialogInterface.OnClickListener {
        public H() {
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

    public class M0 implements DialogInterface.OnClickListener {
        public M0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class R0 implements DialogInterface.OnClickListener {
        public R0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: F5$a, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0463a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0463a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: F5$m, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0487m implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0487m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: F5$n, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0489n implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0489n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: F5$v0, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0506v0 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0506v0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: F5$z, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC0510z implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0510z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    @Override // defpackage.DE
    public void e(int i, C4145vh c4145vh) {
    }

    public F5(C4143vg c4143vg, int i, int i2, ArrayList arrayList, String str, boolean z) {
        Boolean bool = Boolean.FALSE;
        this.L = bool;
        this.M = bool;
        this.N = null;
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
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.h0 = 0;
        this.r0 = new int[]{info.aalmoghalis.inventory.R.drawable.up, 1, info.aalmoghalis.inventory.R.drawable.down};
        this.s0 = null;
        this.u0 = 0;
        this.v0 = 0;
        this.w0 = "";
        this.x0 = "";
        this.y0 = "";
        this.z0 = "";
        this.A0 = "";
        this.B0 = "";
        this.C0 = 0;
        this.D0 = "";
        this.E0 = "";
        this.J0 = -1;
        this.K0 = "";
        this.L0 = new ViewOnClickListenerC0490n0();
        this.O0 = 0;
        this.P0 = "";
        this.R0 = 0;
        this.S0 = 0;
        this.T0 = CSS.Value.PERCENTAGE;
        this.U0 = CSS.Value.PERCENTAGE;
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
        this.m1 = null;
        this.n1 = null;
        this.o1 = null;
        this.p1 = null;
        this.q1 = null;
        this.r1 = null;
        this.s1 = null;
        this.t1 = null;
        this.u1 = null;
        this.v1 = new ArrayList();
        this.w1 = new ArrayList();
        this.y1 = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.z1 = new Z();
        this.A1 = new C0464a0();
        this.B1 = new C0466b0();
        this.C1 = new C0468c0();
        this.F1 = null;
        this.G1 = new HandlerC0494p0();
        this.H1 = "";
        this.I1 = null;
        this.J1 = new ArrayList();
        this.K1 = 0;
        this.M1 = true;
        this.N1 = new Handler(Looper.getMainLooper());
        this.Q1 = 3;
        this.R1 = 4;
        this.T1 = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: u5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.a.n1((Uri) obj);
            }
        });
        this.U1 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new B0());
        this.W1 = "";
        this.Z1 = new C0467c();
        this.a2 = new C0469d();
        this.b2 = false;
        Bundle bundle = new Bundle();
        bundle.putString("cus_id", c4143vg.i());
        bundle.putString("cus_name", c4143vg.j());
        bundle.putString("cus_bal", c4143vg.a());
        bundle.putString("cus_gsm", c4143vg.h());
        bundle.putString("g_name", c4143vg.f());
        bundle.putString("curr_name", c4143vg.b());
        bundle.putInt("adv_search", FragmentStatePagerSupport.R);
        bundle.putString("f_date", FragmentStatePagerSupport.O);
        bundle.putString("t_date", FragmentStatePagerSupport.P);
        bundle.putInt(CSS.Property.POSITION, i);
        bundle.putInt("size", i2);
        bundle.putString("searchString", str);
        bundle.putBoolean("show_move_tr", z);
        bundle.putSerializable("cus_det", arrayList);
        setArguments(bundle);
    }
}
