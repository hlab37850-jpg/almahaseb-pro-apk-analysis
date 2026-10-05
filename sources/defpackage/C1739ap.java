package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport;
import info.aalmoghalis.inventory.lang.App;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: ap, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ValidFragment"})
public class C1739ap extends Fragment {
    public C0922Sv J;
    public ImageView X;
    public ImageView Y;
    public TextView Z;
    public TextView a0;
    public TextView b0;
    public TextView c0;
    public TextView d0;
    public TextView e0;
    public TextView f0;
    public SQLiteDatabase g;
    public TextView g0;
    public Z00 h;
    public int j0;
    public String k;
    public int k0;
    public int l0;
    public String p;
    public String q;
    public AlertDialog.Builder t0;
    public View u0;
    public Activity x0;
    public double i = 0.0d;
    public int j = 0;
    public String l = "";
    public int n = 0;
    public int t = 0;
    public AutoCompleteTextView u = null;
    public EditText v = null;
    public EditText w = null;
    public TextView x = null;
    public ImageView y = null;
    public ImageView z = null;
    public ImageView A = null;
    public TextView B = null;
    public TextView C = null;
    public TextView D = null;
    public TextView E = null;
    public TextView F = null;
    public Button G = null;
    public ListView H = null;
    public TextView I = null;
    public List K = new ArrayList();
    public ImageButton L = null;
    public String[] M = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] N = {R.drawable.up, 1, R.drawable.down};
    public Toolbar O = null;
    public int P = 0;
    public Dialog Q = null;
    public Handler R = new k();
    public int S = 0;
    public Cursor T = null;
    public String U = "";
    public String V = "";
    public String W = "";
    public DatePickerDialog.OnDateSetListener h0 = new g();
    public DatePickerDialog.OnDateSetListener i0 = new h();
    public int m0 = 0;
    public String n0 = CSS.Value.PERCENTAGE;
    public String o0 = CSS.Value.PERCENTAGE;
    public String p0 = CSS.Value.PERCENTAGE;
    public TextView q0 = null;
    public TextView r0 = null;
    public View.OnClickListener s0 = new q();
    public String v0 = "";
    public ArrayList w0 = new ArrayList();

    /* JADX INFO: renamed from: ap$A */
    public class A implements AdapterView.OnItemClickListener {
        public A() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Log.d("report_type2=", FragmentStatePagerSupport.T + ":" + C1739ap.this.n);
            if (C1739ap.this.n == 3) {
                C4145vh c4145vh = (C4145vh) C1739ap.this.H.getAdapter().getItem(i);
                Log.d("lv_click=", c4145vh.v() + ":" + C1739ap.this.l + ":" + c4145vh.o());
                if (c4145vh.v().equals("0")) {
                    return;
                }
                C1739ap c1739ap = C1739ap.this;
                c1739ap.h.m9(c1739ap.getActivity(), c4145vh.v(), c4145vh.u().replaceAll("-", ""), c4145vh.s(), C1739ap.this.l, c4145vh.o(), c4145vh.n());
                return;
            }
            if (C1739ap.this.n == 2) {
                try {
                    C4145vh c4145vh2 = (C4145vh) adapterView.getItemAtPosition(i);
                    C1739ap c1739ap2 = C1739ap.this;
                    boolean zIsEmpty = c1739ap2.n0.isEmpty();
                    String str = CSS.Value.PERCENTAGE;
                    c1739ap2.n0 = zIsEmpty ? CSS.Value.PERCENTAGE : C1739ap.this.n0;
                    C1739ap c1739ap3 = C1739ap.this;
                    if (!c1739ap3.o0.isEmpty()) {
                        str = C1739ap.this.o0;
                    }
                    c1739ap3.o0 = str;
                    Intent intent = new Intent(view.getContext(), (Class<?>) FragmentStatePagerSupport.class);
                    intent.putExtra("screen_no", "18");
                    FragmentStatePagerSupport.T = 3;
                    intent.putExtra("report_type2", 3);
                    intent.putExtra("item_name", C1739ap.this.k);
                    intent.putExtra("item_name2", c4145vh2.c());
                    intent.putExtra("title_", C1739ap.this.k + "#" + C1739ap.this.p);
                    intent.putExtra("br_name", C1739ap.this.p);
                    intent.putExtra("f_date", C1739ap.this.n0);
                    intent.putExtra("t_date", C1739ap.this.o0);
                    Log.d("lv_click", C1739ap.this.k + ":" + C1739ap.this.p + ":" + C1739ap.this.n0 + ":" + C1739ap.this.o0 + ":" + c4145vh2.a());
                    C1739ap.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: renamed from: ap$B */
    public interface B {
    }

    /* JADX INFO: renamed from: ap$C */
    public class C implements Comparator {
        public int a;

        public C(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 5) {
                return Double.valueOf(c4145vh.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.q().replaceAll(",", "")));
            }
            if (i == 6) {
                return Double.valueOf(c4145vh.r().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.r().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.o().replaceAll(",", ""))) : Double.valueOf(c4145vh.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.p().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: ap$D */
    public class D implements Comparator {
        public int a;

        public D(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 5) {
                return Double.valueOf(c4145vh2.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.q().replaceAll(",", "")));
            }
            if (i == 6) {
                return Double.valueOf(c4145vh2.r().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.r().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", ""))) : Double.valueOf(c4145vh2.p().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.p().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: ap$a, reason: case insensitive filesystem */
    public class ViewOnClickListenerC1740a implements View.OnClickListener {
        public ViewOnClickListenerC1740a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C1739ap.this.N(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ap$b, reason: case insensitive filesystem */
    public class ViewOnClickListenerC1741b implements View.OnClickListener {
        public ViewOnClickListenerC1741b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C1739ap.this.N(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ap$c, reason: case insensitive filesystem */
    public class ViewOnClickListenerC1742c implements View.OnClickListener {
        public ViewOnClickListenerC1742c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C1739ap.this.N(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ap$d, reason: case insensitive filesystem */
    public class ViewOnClickListenerC1743d implements View.OnClickListener {
        public ViewOnClickListenerC1743d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C1739ap.this.N(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ap$e */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C1739ap.this.N(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ap$f */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C1739ap.this.N(view);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ap$g */
    public class g implements DatePickerDialog.OnDateSetListener {
        public g() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                C1739ap.this.q0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                C1739ap c1739ap = C1739ap.this;
                c1739ap.n0 = c1739ap.q0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: ap$h */
    public class h implements DatePickerDialog.OnDateSetListener {
        public h() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                C1739ap.this.r0.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                C1739ap c1739ap = C1739ap.this;
                c1739ap.o0 = c1739ap.r0.getText().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: ap$i */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", C1739ap.this.j0);
                bundle.putInt("month", C1739ap.this.k0);
                bundle.putInt("day", C1739ap.this.l0);
                c2137ei.setArguments(bundle);
                c2137ei.f(C1739ap.this.h0);
                c2137ei.show(C1739ap.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ap$j */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C2137ei c2137ei = new C2137ei();
                Calendar.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("year", C1739ap.this.j0);
                bundle.putInt("month", C1739ap.this.k0);
                bundle.putInt("day", C1739ap.this.l0);
                c2137ei.setArguments(bundle);
                c2137ei.f(C1739ap.this.i0);
                c2137ei.show(C1739ap.this.getActivity().getSupportFragmentManager(), "Date Picker");
            } catch (Exception e) {
                Toast.makeText(C1739ap.this.getActivity(), e.getMessage(), 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: ap$k */
    public class k extends Handler {
        public k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                C1739ap c1739ap = C1739ap.this;
                c1739ap.r(c1739ap.T);
                C3966tX c3966tX = new C3966tX();
                FragmentActivity activity = C1739ap.this.getActivity();
                C1739ap c1739ap2 = C1739ap.this;
                c3966tX.A(activity, c1739ap2.H, c1739ap2.I, 1);
                return;
            }
            if (message.obj.toString().equals("1")) {
                Z00 z00 = C1739ap.this.h;
                StringBuilder sb = new StringBuilder();
                C1739ap c1739ap3 = C1739ap.this;
                sb.append(c1739ap3.h.ic(c1739ap3.v0));
                sb.append(".pdf");
                z00.ra(sb.toString());
                C1739ap.this.G(false);
                return;
            }
            if (message.obj.toString().equals("3")) {
                C1739ap.this.J.notifyDataSetChanged();
                C1739ap c1739ap4 = C1739ap.this;
                Z00 z01 = c1739ap4.h;
                FragmentActivity activity2 = c1739ap4.getActivity();
                C1739ap c1739ap5 = C1739ap.this;
                z01.lc(activity2, c1739ap5.Z, c1739ap5.a0, c1739ap5.b0, c1739ap5.c0, c1739ap5.d0, c1739ap5.e0);
                C1739ap c1739ap6 = C1739ap.this;
                int i = c1739ap6.S;
                if (i == 1) {
                    Z00 z02 = c1739ap6.h;
                    FragmentActivity activity3 = c1739ap6.getActivity();
                    C1739ap c1739ap7 = C1739ap.this;
                    z02.ld(activity3, c1739ap7.Z, c1739ap7.t);
                } else if (i == 2) {
                    Z00 z03 = c1739ap6.h;
                    FragmentActivity activity4 = c1739ap6.getActivity();
                    C1739ap c1739ap8 = C1739ap.this;
                    z03.ld(activity4, c1739ap8.a0, c1739ap8.t);
                } else if (i == 3) {
                    Z00 z04 = c1739ap6.h;
                    FragmentActivity activity5 = c1739ap6.getActivity();
                    C1739ap c1739ap9 = C1739ap.this;
                    z04.ld(activity5, c1739ap9.b0, c1739ap9.t);
                } else if (i == 4) {
                    Z00 z05 = c1739ap6.h;
                    FragmentActivity activity6 = c1739ap6.getActivity();
                    C1739ap c1739ap10 = C1739ap.this;
                    z05.ld(activity6, c1739ap10.c0, c1739ap10.t);
                } else if (i == 5) {
                    Z00 z06 = c1739ap6.h;
                    FragmentActivity activity7 = c1739ap6.getActivity();
                    C1739ap c1739ap11 = C1739ap.this;
                    z06.ld(activity7, c1739ap11.d0, c1739ap11.t);
                } else if (i == 6) {
                    Z00 z07 = c1739ap6.h;
                    FragmentActivity activity8 = c1739ap6.getActivity();
                    C1739ap c1739ap12 = C1739ap.this;
                    z07.ld(activity8, c1739ap12.e0, c1739ap12.t);
                }
                C1739ap.this.G(false);
            }
        }
    }

    /* JADX INFO: renamed from: ap$m */
    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                C1739ap c1739ap = C1739ap.this;
                c1739ap.m0 = 0;
                c1739ap.u();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ap$n */
    public class n implements View.OnClickListener {
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public n(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                C1739ap c1739ap = C1739ap.this;
                c1739ap.m0 = 1;
                if (c1739ap.q0.getText() == null) {
                    C1739ap.this.n0 = "";
                } else {
                    C1739ap c1739ap2 = C1739ap.this;
                    c1739ap2.n0 = c1739ap2.q0.getText().toString();
                }
                if (C1739ap.this.r0.getText() == null) {
                    C1739ap.this.o0 = "";
                } else {
                    C1739ap c1739ap3 = C1739ap.this;
                    c1739ap3.o0 = c1739ap3.r0.getText().toString();
                }
                C1739ap.this.u();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    /* JADX INFO: renamed from: ap$o */
    public class o extends WebViewClient {
        public o() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('5','6','8')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX INFO: renamed from: ap$p */
    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: ap$q */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.img_add_amount) {
                C1739ap.this.amount_add_btn(view);
                return;
            }
            if (view.getId() == R.id.img_help) {
                C1739ap.this.help_btn(view);
                return;
            }
            if (view.getId() == 16908292) {
                C1739ap.this.A(view);
            } else if (view.getId() == R.id.move_left || view.getId() == R.id.move_right) {
                C1739ap.n(C1739ap.this);
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: ap$r */
    public class r implements SearchView.OnQueryTextListener {
        public r() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                C1739ap.this.s(1);
            }
            C1739ap.this.B(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            C1739ap.this.s(0);
            return false;
        }
    }

    /* JADX INFO: renamed from: ap$t */
    public class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1739ap.this.t();
            Message message = new Message();
            message.obj = "0";
            C1739ap.this.R.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: ap$u */
    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1739ap.this.n == 2) {
                C1739ap c1739ap = C1739ap.this;
                Z00 z00 = c1739ap.h;
                ListView listView = c1739ap.H;
                String strIc = z00.ic(c1739ap.v0);
                C1739ap c1739ap2 = C1739ap.this;
                z00.Kb(listView, strIc, false, c1739ap2.n0, c1739ap2.o0, c1739ap2.getString(R.string.cus));
            } else {
                C1739ap c1739ap3 = C1739ap.this;
                Z00 z01 = c1739ap3.h;
                ListView listView2 = c1739ap3.H;
                String strIc2 = z01.ic(c1739ap3.v0);
                C1739ap c1739ap4 = C1739ap.this;
                z01.Jb(listView2, strIc2, true, c1739ap4.n0, c1739ap4.o0, c1739ap4.getString(R.string.cus));
            }
            Message message = new Message();
            message.obj = "1";
            C1739ap.this.R.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: ap$v */
    public class v implements Comparator {
        public v() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh2.n().compareTo(String.valueOf(c4145vh.n()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v()) : iCompareTo;
        }
    }

    /* JADX INFO: renamed from: ap$w */
    public class w implements Comparator {
        public w() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh.n().compareTo(String.valueOf(c4145vh2.n()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh.v()) - Integer.parseInt(c4145vh2.v()) : iCompareTo;
        }
    }

    /* JADX INFO: renamed from: ap$x */
    public class x implements Runnable {
        public final /* synthetic */ View a;

        public x(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getId()) {
                case R.id.f1 /* 2131296723 */:
                    C1739ap.this.M(this.a, 1);
                    C1739ap.this.S = 1;
                    break;
                case R.id.f2 /* 2131296725 */:
                    C1739ap.this.L(this.a);
                    C1739ap.this.S = 2;
                    break;
                case R.id.f3 /* 2131296726 */:
                    C1739ap.this.K(this.a, 3);
                    C1739ap.this.S = 3;
                    break;
                case R.id.f4 /* 2131296727 */:
                    C1739ap.this.K(this.a, 4);
                    C1739ap.this.S = 4;
                    break;
                case R.id.f5 /* 2131296728 */:
                    C1739ap.this.K(this.a, 5);
                    C1739ap.this.S = 5;
                    break;
                case R.id.f6 /* 2131296729 */:
                    C1739ap.this.K(this.a, 6);
                    C1739ap.this.S = 6;
                    break;
            }
            Message message = new Message();
            message.obj = "3";
            C1739ap.this.R.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: ap$y */
    public class y implements Comparator {
        public final /* synthetic */ int a;

        public y(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh2.a()).compareTo(String.valueOf(c4145vh.a())) : String.valueOf(c4145vh2.n()).compareTo(String.valueOf(c4145vh.n()));
        }
    }

    /* JADX INFO: renamed from: ap$z */
    public class z implements Comparator {
        public final /* synthetic */ int a;

        public z(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            return this.a == 1 ? String.valueOf(c4145vh.a()).compareTo(String.valueOf(c4145vh2.a())) : String.valueOf(c4145vh.n()).compareTo(String.valueOf(c4145vh2.n()));
        }
    }

    public C1739ap() {
    }

    private void D(List list) {
        Collections.sort(list, Collections.reverseOrder(new w()));
    }

    private void E(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new z(i2)));
    }

    private void F(List list, int i2) {
        Collections.sort(list, new D(i2));
    }

    private void H(List list, int i2) {
        Collections.sort(list, new C(i2));
    }

    private void I(List list) {
        Collections.sort(list, Collections.reverseOrder(new v()));
    }

    private void J(List list, int i2) {
        Collections.sort(list, Collections.reverseOrder(new y(i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(View view) {
        if (this.t == 0) {
            I(this.K);
            this.t = 1;
        } else {
            D(this.K);
            this.t = 0;
        }
    }

    public static /* synthetic */ B n(C1739ap c1739ap) {
        c1739ap.getClass();
        return null;
    }

    private void p(String str) {
        new AlertDialog.Builder(getActivity()).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new s()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer y() {
        this.h.Vb();
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(Integer num) {
        u();
    }

    public void A(View view) {
        this.m0 = 0;
        t();
    }

    public void B(String str) {
        try {
            this.J.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    public void C() {
        G(true);
        new Thread(new u()).start();
    }

    public void G(boolean z2) {
        try {
            Dialog dialog = this.Q;
            if (dialog == null) {
                return;
            }
            if (z2) {
                dialog.cancel();
                this.Q.hide();
                this.Q.dismiss();
                this.Q.show();
            } else {
                dialog.cancel();
                this.Q.hide();
                this.Q.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void K(View view, int i2) {
        if (this.t == 0) {
            H(this.K, i2);
            this.t = 1;
        } else {
            F(this.K, i2);
            this.t = 0;
        }
    }

    public void M(View view, int i2) {
        if (this.t == 0) {
            J(this.K, i2);
            this.t = 1;
        } else {
            E(this.K, i2);
            this.t = 0;
        }
    }

    public void N(View view) {
        G(true);
        new Thread(new x(view)).start();
    }

    public void amount_add_btn(View view) {
        Bill_edit.P2 = true;
        this.h.z(getActivity(), this.h.D2(this.p), this.p);
    }

    public void help_btn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        WebView webView = new WebView(getActivity());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new o());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new p());
        builder.show();
    }

    public void o() {
        try {
            this.m0 = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.q0 = (TextView) viewInflate.findViewById(R.id.f_date);
            this.r0 = (TextView) viewInflate.findViewById(R.id.t_date);
            this.q0.setOnClickListener(new i());
            this.r0.setOnClickListener(new j());
            builder.setPositiveButton(getActivity().getString(R.string.btn_search), new l());
            builder.setNegativeButton(getActivity().getString(R.string.btn_cancel), new m());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new n(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.x0 = activity;
        try {
            AbstractC3574of.a(activity);
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.h = new Z00(this.g, getActivity());
            this.k = getArguments() != null ? getArguments().getString("item_name") : "";
            if (FragmentStatePagerSupport.T == 3) {
                this.l = getArguments() != null ? getArguments().getString("item_name2") : "";
            } else {
                this.l = "";
            }
            this.p = getArguments() != null ? getArguments().getString("br_name") : "";
            this.n0 = getArguments() != null ? getArguments().getString("f_date") : "";
            this.o0 = getArguments() != null ? getArguments().getString("t_date") : "";
            this.p0 = getArguments() != null ? getArguments().getString("item_type") : "";
            this.P = getArguments() != null ? getArguments().getInt("size") : 0;
            this.q = getArguments() != null ? getArguments().getString("unit_name") : "";
            this.n = getArguments() != null ? getArguments().getInt("report_type2") : 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        menuInflater.inflate(R.menu.menu_main3_group_general, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new r());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.data_listview_rep1_3, viewGroup, false);
        this.h = new Z00(this.g, getActivity());
        setHasOptionsMenu(true);
        x(viewInflate);
        if (this.H == null) {
            this.H = (ListView) viewInflate.findViewById(R.id.list_items);
            TextView textView = (TextView) viewInflate.findViewById(android.R.id.empty);
            this.I = textView;
            textView.setText(getString(R.string.wait));
            this.H.setEmptyView(this.I);
        }
        this.H.setOnItemClickListener(new A());
        w();
        this.x = (TextView) viewInflate.findViewById(R.id.footer_sum);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_add_amount);
        this.z = imageView;
        imageView.setOnClickListener(this.s0);
        this.X = (ImageView) viewInflate.findViewById(R.id.move_right);
        this.Y = (ImageView) viewInflate.findViewById(R.id.move_left);
        this.X.setOnClickListener(this.s0);
        this.Y.setOnClickListener(this.s0);
        if (this.P <= 1) {
            this.X.setVisibility(8);
            this.Y.setVisibility(8);
        }
        this.U = getActivity().getString(R.string.footer_cus_null);
        this.V = getActivity().getString(R.string.tot_radio1);
        this.W = getActivity().getString(R.string.tot_radio2);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.j0 = calendar.get(1);
        this.k0 = calendar.get(2);
        this.l0 = calendar.get(5);
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getActivity());
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        if (getUserVisibleHint()) {
            u();
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str;
        int itemId = menuItem.getItemId();
        if (itemId != R.id.print) {
            if (itemId == R.id.adv_search) {
                o();
                return true;
            }
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            getActivity().finish();
            return true;
        }
        q();
        try {
            if (this.h.ja("prefPrintSort", true)) {
                I(this.K);
                this.J.notifyDataSetChanged();
                this.t = 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getActivity().getTitle().toString());
            String str2 = this.p0;
            if (str2 == null || str2.equals(CSS.Value.PERCENTAGE)) {
                str = "";
            } else {
                str = "-" + this.p0;
            }
            sb.append(str);
            this.v0 = sb.toString();
            C();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            p(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        int i2 = this.n;
        if (i2 == 2) {
            Bill_edit.Q2 = true;
        }
        FragmentStatePagerSupport.T = i2;
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            Bill_edit.Q2 = true;
            new C3966tX().A(getActivity(), this.H, this.I, -1);
            AbstractC3132jE.d(new Callable() { // from class: Yo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.y();
                }
            }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: Zo
                @Override // defpackage.InterfaceC2295gf
                public final void accept(Object obj) {
                    this.a.z((Integer) obj);
                }
            });
        }
    }

    public void q() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void r(Cursor cursor) {
        String str;
        if (isAdded()) {
            C0922Sv c0922Sv = new C0922Sv(getActivity(), R.layout.data_det_row_rep3_1, this.K, 4, this.n);
            this.J = c0922Sv;
            c0922Sv.l.clear();
            this.J.notifyDataSetChanged();
            this.H.setAdapter((ListAdapter) this.J);
            if (this.n == 3) {
                D(this.K);
            } else {
                this.Z.performClick();
            }
            this.J.notifyDataSetChanged();
            this.t = 0;
        }
        if (getActivity() != null) {
            try {
                TextView textView = this.x;
                StringBuilder sb = new StringBuilder();
                String str2 = this.p0;
                String str3 = "";
                if (str2 == null || str2.equals(CSS.Value.PERCENTAGE)) {
                    str = "";
                } else {
                    str = this.p0 + " ";
                }
                sb.append(str);
                sb.append(this.h.P7(String.valueOf(this.i)));
                sb.append(this.q);
                if (this.n == 3) {
                    str3 = "-" + this.l;
                }
                sb.append(str3);
                textView.setText(sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.I.setText(getString(R.string.no_results));
        }
        if (this.n == 2) {
            ((App) getActivity().getApplication()).c(this.K);
        }
    }

    public void s(int i2) {
        String str = "";
        try {
            if (i2 == 1) {
                TextView textView = this.x;
                StringBuilder sb = new StringBuilder();
                sb.append(this.h.P7(String.valueOf(this.i)));
                sb.append(this.q);
                if (this.n == 3) {
                    str = "-" + this.l;
                }
                sb.append(str);
                textView.setText(sb.toString());
                return;
            }
            TextView textView2 = this.x;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.h.P7(String.valueOf(v(this.J.e))));
            sb2.append(this.q);
            if (this.n == 3) {
                str = "-" + this.l;
            }
            sb2.append(str);
            textView2.setText(sb2.toString());
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && this.k != null && isResumed()) {
            u();
        }
    }

    public void t() {
        Cursor cursorP6;
        try {
            this.T = null;
            if (this.m0 == 0) {
                cursorP6 = this.h.P6(this.p, this.k, this.n0, this.o0, this.l, this.p0);
            } else {
                boolean zIsEmpty = this.n0.isEmpty();
                String str = CSS.Value.PERCENTAGE;
                this.n0 = zIsEmpty ? CSS.Value.PERCENTAGE : this.n0;
                this.o0 = this.o0.isEmpty() ? CSS.Value.PERCENTAGE : this.o0;
                String str2 = this.p0;
                if (str2 != null && !str2.isEmpty()) {
                    str = this.p0;
                }
                String str3 = str;
                this.p0 = str3;
                cursorP6 = this.h.P6(this.p, this.k, this.n0, this.o0, this.l, str3);
            }
            Log.d("report_type2=", this.n + "");
            this.i = 0.0d;
            this.K.clear();
            cursorP6.moveToFirst();
            while (!cursorP6.isAfterLast()) {
                this.i += Double.parseDouble(cursorP6.getString(cursorP6.getColumnIndex("f5")));
                if (this.n == 3) {
                    this.K.add(new C4145vh(cursorP6.getString(cursorP6.getColumnIndex("_id")), cursorP6.getString(cursorP6.getColumnIndex("f7")), cursorP6.getString(cursorP6.getColumnIndex("f1")), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f2"))), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f3"))), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f4"))), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f5"))), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f6"))), cursorP6.getString(cursorP6.getColumnIndex("f7")), cursorP6.getString(cursorP6.getColumnIndex("f8")), cursorP6.getString(cursorP6.getColumnIndex("f11")), cursorP6.getString(cursorP6.getColumnIndex("f10")), ""));
                } else {
                    this.K.add(new C4145vh(cursorP6.getString(cursorP6.getColumnIndex("_id")), cursorP6.getString(cursorP6.getColumnIndex("f1")), cursorP6.getString(cursorP6.getColumnIndex("f11")), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f2"))), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f3"))), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f4"))), this.h.P7(cursorP6.getString(cursorP6.getColumnIndex("f5"))), cursorP6.getString(cursorP6.getColumnIndex("f6")), cursorP6.getString(cursorP6.getColumnIndex("f7")), cursorP6.getString(cursorP6.getColumnIndex("f8")), cursorP6.getString(cursorP6.getColumnIndex("f11")), cursorP6.getString(cursorP6.getColumnIndex("f10")), ""));
                }
                cursorP6.moveToNext();
            }
            cursorP6.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void u() {
        new C3966tX().A(getActivity(), this.H, this.I, -1);
        new Thread(new t()).start();
    }

    public double v(List list) {
        Log.d("net_bal:", list.size() + "");
        double d = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d += Double.parseDouble(((C4145vh) list.get(i2)).r().replaceAll(",", ""));
        }
        return d;
    }

    public void w() {
        if (this.Q != null) {
            return;
        }
        try {
            this.t0 = new AlertDialog.Builder(getActivity());
            View viewInflate = getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null);
            this.u0 = viewInflate;
            this.t0.setView(viewInflate);
            this.Q = this.t0.create();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void x(View view) {
        if (view != null) {
            this.Z = (TextView) view.findViewById(R.id.f1);
            this.a0 = (TextView) view.findViewById(R.id.f2);
            this.b0 = (TextView) view.findViewById(R.id.f3);
            this.c0 = (TextView) view.findViewById(R.id.f4);
            this.d0 = (TextView) view.findViewById(R.id.f5);
            this.e0 = (TextView) view.findViewById(R.id.f6);
            this.f0 = (TextView) view.findViewById(R.id.f7);
            this.g0 = (TextView) view.findViewById(R.id.f8);
        } else {
            this.Z = (TextView) view.findViewById(R.id.f1);
            this.a0 = (TextView) view.findViewById(R.id.f2);
            this.b0 = (TextView) view.findViewById(R.id.f3);
            this.c0 = (TextView) view.findViewById(R.id.f4);
            this.d0 = (TextView) view.findViewById(R.id.f5);
            this.e0 = (TextView) view.findViewById(R.id.f6);
            this.f0 = (TextView) view.findViewById(R.id.f7);
            this.g0 = (TextView) view.findViewById(R.id.f8);
        }
        this.f0.setVisibility(8);
        this.g0.setVisibility(8);
        this.Z.setText(getString(R.string.bill_no3));
        this.a0.setText(getString(R.string.date2));
        this.b0.setText(getString(R.string.qty));
        this.c0.setText(getString(R.string.sales_price));
        this.d0.setText(getString(R.string.purchase_price2));
        this.e0.setText(getString(R.string.revenue));
        if (this.n == 2) {
            this.Z.setText(getString(R.string.item));
            this.a0.setText(getString(R.string.base_unit2));
            this.b0.setText(getString(R.string.qty));
            this.c0.setText(getString(R.string.sales_price));
            this.d0.setText(getString(R.string.purchase_price2));
            this.e0.setText(getString(R.string.revenue));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a0.getLayoutParams();
            this.a0.setLayoutParams((LinearLayout.LayoutParams) this.Z.getLayoutParams());
            this.Z.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b0.getLayoutParams();
            this.b0.setLayoutParams((LinearLayout.LayoutParams) this.a0.getLayoutParams());
            this.a0.setLayoutParams(layoutParams2);
        }
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(getActivity(), this.Z);
        c0372Bn.a(getActivity(), this.a0);
        c0372Bn.a(getActivity(), this.b0);
        c0372Bn.a(getActivity(), this.c0);
        c0372Bn.a(getActivity(), this.d0);
        c0372Bn.a(getActivity(), this.e0);
        TextView textView = this.Z;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        TextView textView2 = this.a0;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        TextView textView3 = this.b0;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        TextView textView4 = this.c0;
        textView4.setPaintFlags(textView4.getPaintFlags() | 8);
        TextView textView5 = this.d0;
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        this.e0.setPaintFlags(8 | this.d0.getPaintFlags());
        this.h.ld(getActivity(), this.a0, this.t);
        this.a0.setOnClickListener(new ViewOnClickListenerC1740a());
        this.Z.setOnClickListener(new ViewOnClickListenerC1741b());
        this.b0.setOnClickListener(new ViewOnClickListenerC1742c());
        this.c0.setOnClickListener(new ViewOnClickListenerC1743d());
        this.d0.setOnClickListener(new e());
        this.e0.setOnClickListener(new f());
    }

    /* JADX INFO: renamed from: ap$l */
    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: ap$s */
    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public C1739ap(C4145vh c4145vh, int i2, int i3, String str) {
        String strB;
        String strB2;
        Bundle bundle = new Bundle();
        Log.d("frag_click=", c4145vh.a() + ":" + c4145vh.n() + ":" + FragmentStatePagerSupport.T);
        int i4 = FragmentStatePagerSupport.T;
        if (i4 == 2) {
            bundle.putString("item_name", c4145vh.n());
            if (c4145vh.b() == null || c4145vh.b().equals(".")) {
                strB2 = "";
            } else {
                strB2 = c4145vh.b();
            }
            bundle.putString("unit_name", strB2);
            bundle.putString("br_name", c4145vh.a());
            bundle.putString("f_date", FragmentStatePagerSupport.O);
            bundle.putString("t_date", FragmentStatePagerSupport.P);
            bundle.putString("item_type", FragmentStatePagerSupport.Q);
            bundle.putInt(CSS.Property.POSITION, i2);
            bundle.putInt("size", i3);
            bundle.putString("searchString", str);
            bundle.putInt("report_type2", FragmentStatePagerSupport.T);
        } else if (i4 == 3) {
            bundle.putString("item_name", c4145vh.t());
            bundle.putString("item_name2", c4145vh.a());
            if (c4145vh.b() == null || c4145vh.b().equals(".")) {
                strB = "";
            } else {
                strB = c4145vh.b();
            }
            bundle.putString("unit_name", strB);
            bundle.putString("br_name", c4145vh.s());
            bundle.putString("f_date", FragmentStatePagerSupport.O);
            bundle.putString("t_date", FragmentStatePagerSupport.P);
            bundle.putString("item_type", FragmentStatePagerSupport.Q);
            bundle.putInt(CSS.Property.POSITION, i2);
            bundle.putInt("size", i3);
            bundle.putString("searchString", str);
            bundle.putInt("report_type2", FragmentStatePagerSupport.T);
        }
        setArguments(bundle);
    }
}
