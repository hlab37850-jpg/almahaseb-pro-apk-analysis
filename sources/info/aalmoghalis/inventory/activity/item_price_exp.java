package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.material.timepicker.TimeModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C1098Yv;
import defpackage.C2160f10;
import defpackage.C3467nL;
import defpackage.C3549oL;
import defpackage.C3631pL;
import defpackage.C4145vh;
import defpackage.TC;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class item_price_exp extends BaseActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<ArrayList<C3549oL>> {
    public C1098Yv C;
    public SearchView F;
    public int L;
    public int M;
    public int N;
    public SQLiteDatabase c;
    public Z00 d;
    public ExpandableListView k;
    public TC l;
    public double e = 0.0d;
    public int f = 0;
    public AutoCompleteTextView g = null;
    public EditText h = null;
    public EditText i = null;
    public Button j = null;
    public ArrayList n = new ArrayList();
    public LinkedHashMap p = new LinkedHashMap();
    public ImageView q = null;
    public TextView t = null;
    public ImageButton u = null;
    public String[] v = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] w = {R.drawable.up, 1, R.drawable.down};
    public TextView x = null;
    public TextView y = null;
    public TextView z = null;
    public TextView A = null;
    public TextView B = null;
    public ExpandableListView.OnChildClickListener D = new p();
    public ExpandableListView.OnGroupClickListener E = new x();
    public String G = "";
    public String H = "";
    public int I = 0;
    public DatePickerDialog.OnDateSetListener J = new C3067b();
    public DatePickerDialog.OnDateSetListener K = new C3068c();
    public int O = 0;
    public String P = CSS.Value.PERCENTAGE;
    public String Q = CSS.Value.PERCENTAGE;
    public TextView R = null;
    public TextView S = null;
    public boolean T = false;
    public Cursor U = null;
    public Dialog V = null;
    public Handler W = new HandlerC3069d();
    public int X = 0;
    public ArrayList Y = new ArrayList();
    public String Z = null;
    public String a0 = null;
    public RadioGroup b0 = null;
    public ArrayList c0 = new ArrayList();
    public AutoCompleteTextView d0 = null;
    public EditText e0 = null;
    public TextView f0 = null;
    public TextView g0 = null;
    public ImageView h0 = null;

    public class A implements Runnable {
        public final /* synthetic */ String a;

        public A(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            item_price_exp.this.F.onActionViewExpanded();
            item_price_exp.this.F.setQuery(this.a, true);
        }
    }

    public class B implements Runnable {
        public final /* synthetic */ String a;

        public B(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            item_price_exp.this.F.onActionViewExpanded();
            item_price_exp.this.F.setQuery(this.a, true);
        }
    }

    public static class C implements Comparator {
        public C() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL.l()).compareTo(Double.valueOf(c3549oL2.l()));
        }

        public /* synthetic */ C(j jVar) {
            this();
        }
    }

    public static class D implements Comparator {
        public D() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL2.l()).compareTo(Double.valueOf(c3549oL.l()));
        }

        public /* synthetic */ D(j jVar) {
            this();
        }
    }

    public static class E implements Comparator {
        public E() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL.a().replaceAll(",", "")).compareTo(Double.valueOf(c3549oL2.a().replaceAll(",", "")));
        }

        public /* synthetic */ E(j jVar) {
            this();
        }
    }

    public static class F implements Comparator {
        public F() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL2.a().replaceAll(",", "")).compareTo(Double.valueOf(c3549oL.a().replaceAll(",", "")));
        }

        public /* synthetic */ F(j jVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.item_price_exp$a, reason: case insensitive filesystem */
    public class DialogInterfaceOnClickListenerC3066a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3066a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.item_price_exp$b, reason: case insensitive filesystem */
    public class C3067b implements DatePickerDialog.OnDateSetListener {
        public C3067b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            item_price_exp.this.L = i;
            item_price_exp.this.M = i2;
            item_price_exp.this.N = i3;
            try {
                String str = item_price_exp.this.L + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(item_price_exp.this.M + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(item_price_exp.this.N));
                Locale locale = Locale.ENGLISH;
                item_price_exp.this.R.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                item_price_exp item_price_expVar = item_price_exp.this;
                item_price_expVar.P = item_price_expVar.R.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.item_price_exp$c, reason: case insensitive filesystem */
    public class C3068c implements DatePickerDialog.OnDateSetListener {
        public C3068c() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            item_price_exp.this.L = i;
            item_price_exp.this.M = i2;
            item_price_exp.this.N = i3;
            try {
                String str = item_price_exp.this.L + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(item_price_exp.this.M + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(item_price_exp.this.N));
                Locale locale = Locale.ENGLISH;
                item_price_exp.this.S.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                item_price_exp item_price_expVar = item_price_exp.this;
                item_price_expVar.Q = item_price_expVar.S.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.item_price_exp$d, reason: case insensitive filesystem */
    public class HandlerC3069d extends Handler {
        public HandlerC3069d() {
        }

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
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                item_price_exp item_price_expVar = item_price_exp.this;
                item_price_expVar.P(item_price_expVar.U);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = item_price_exp.this.d;
                StringBuilder sb = new StringBuilder();
                item_price_exp item_price_expVar2 = item_price_exp.this;
                sb.append(item_price_expVar2.d.ic(item_price_expVar2.G));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            item_price_exp item_price_expVar3 = item_price_exp.this;
            item_price_expVar3.h0(false, item_price_expVar3);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.item_price_exp$e, reason: case insensitive filesystem */
    public class RunnableC3070e implements Runnable {
        public RunnableC3070e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            item_price_exp.this.Q();
            Message message = new Message();
            message.obj = "0";
            item_price_exp.this.W.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.item_price_exp$f, reason: case insensitive filesystem */
    public class RunnableC3071f implements Runnable {
        public RunnableC3071f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            item_price_exp item_price_expVar = item_price_exp.this;
            Z00 z00 = item_price_expVar.d;
            ExpandableListView expandableListView = item_price_expVar.k;
            item_price_exp item_price_expVar2 = item_price_exp.this;
            z00.Bb(expandableListView, item_price_expVar2.d.ic(item_price_expVar2.G), false);
            Message message = new Message();
            message.obj = "1";
            item_price_exp.this.W.sendMessage(message);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            item_price_exp item_price_expVar = item_price_exp.this;
            Z00 z00 = item_price_expVar.d;
            ExpandableListView expandableListView = item_price_expVar.k;
            item_price_exp item_price_expVar2 = item_price_exp.this;
            z00.Bb(expandableListView, item_price_expVar2.d.ic(item_price_expVar2.G), true);
            Message message = new Message();
            message.obj = "1";
            item_price_exp.this.W.sendMessage(message);
        }
    }

    public class h implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL2.k()).compareTo(String.valueOf(c3549oL.k()));
        }
    }

    public class i implements Comparator {
        public i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL.k()).compareTo(String.valueOf(c3549oL2.k()));
        }
    }

    public class j implements ExpandableListView.OnGroupExpandListener {
        public int a = -1;

        public j() {
        }

        @Override // android.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i) {
            if (i != this.a) {
                item_price_exp.this.k.collapseGroup(this.a);
            }
            this.a = i;
        }
    }

    public class k extends WebViewClient {
        public k() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('5','6','0')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ EditText d;

        public m(AutoCompleteTextView autoCompleteTextView, String[] strArr, TextView textView, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = strArr;
            this.c = textView;
            this.d = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setText(this.b[i]);
            this.a.dismissDropDown();
            this.c.setText(item_price_exp.this.d.X6(this.a.getText().toString()));
            if (item_price_exp.this.d.W6(this.a.getText().toString()) > 1) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            this.d.requestFocus();
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            item_price_exp.this.onRadioButtonClicked(view);
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            item_price_exp item_price_expVar = item_price_exp.this;
            ArrayAdapter arrayAdapter = new ArrayAdapter(item_price_expVar, android.R.layout.simple_spinner_dropdown_item, item_price_expVar.d.a9(item_price_expVar.d0.getText().toString()));
            item_price_exp item_price_expVar2 = item_price_exp.this;
            String string = item_price_expVar2.d0.getText().toString();
            item_price_exp item_price_expVar3 = item_price_exp.this;
            item_price_expVar2.L(arrayAdapter, string, item_price_expVar3.g0, item_price_expVar3.f0);
        }
    }

    public class p implements ExpandableListView.OnChildClickListener {
        public p() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            return false;
        }
    }

    public class q implements AdapterView.OnItemClickListener {
        public q() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            item_price_exp.this.V(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ ArrayList a;

        public r(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            item_price_exp item_price_expVar = item_price_exp.this;
            item_price_expVar.K(this.a, item_price_expVar.d0, item_price_expVar.e0, item_price_expVar.g0);
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class u implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public u(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(item_price_exp.this.e0);
            if (!AbstractC4371yX.e(item_price_exp.this.e0)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(item_price_exp.this.d0)) {
                zA = false;
            }
            if (item_price_exp.this.g0.getText().toString().length() == 0) {
                zA = false;
            }
            item_price_exp item_price_expVar = item_price_exp.this;
            if (item_price_expVar.d.s6(item_price_expVar.d0.getText().toString()).getCount() == 0 && item_price_exp.this.d0.getText().toString().trim().length() > 0) {
                item_price_exp.this.d0.setError("Not Found");
                zA = false;
            }
            if (zA) {
                item_price_exp.this.d.H("delete from item_price where item_id=(select a.id from items a where a.name='" + item_price_exp.this.d0.getText().toString() + "') and curr_id=(select a.id from currency a where a.name='" + item_price_exp.this.b0.getTag().toString() + "') and unit_id=ifnull((select id from units where code='" + item_price_exp.this.g0.getText().toString() + "'),0)", "insert into item_price(item_id,curr_id,unit_id,SLS_U_PRICE) values ((select a.id from items a where a.name='" + item_price_exp.this.d0.getText().toString() + "'),(select a.id from currency a where a.name='" + item_price_exp.this.b0.getTag().toString() + "'),ifnull((select id from units where code='" + item_price_exp.this.g0.getText().toString() + "'),0),'" + item_price_exp.this.e0.getText().toString() + "')");
                item_price_exp.this.d.ja("online_server", false);
                item_price_exp item_price_expVar2 = item_price_exp.this;
                item_price_expVar2.Z = item_price_expVar2.b0.getTag().toString();
                item_price_exp.this.g0();
                this.a.dismiss();
                item_price_exp.this.N();
                item_price_exp item_price_expVar3 = item_price_exp.this;
                item_price_expVar3.d.Kd(item_price_expVar3, item_price_expVar3.getString(R.string.done), 1000);
            }
        }
    }

    public class v implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public v(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class w implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ Dialog d;

        public w(TextView textView, String str, TextView textView2, Dialog dialog) {
            this.a = textView;
            this.b = str;
            this.c = textView2;
            this.d = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            double dZ6 = item_price_exp.this.d.Z6(this.b, this.a.getText().toString());
            double dA6 = item_price_exp.this.d.A6(this.b);
            if (dA6 != 0.0d) {
                TextView textView = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append(item_price_exp.this.getString(R.string.item_cost_avg));
                sb.append(": ");
                sb.append(item_price_exp.this.d.P7(String.valueOf(dA6 * dZ6)));
                sb.append(" ");
                Z00 z00 = item_price_exp.this.d;
                sb.append(z00.g3(z00.l3("0")));
                textView.setText(sb.toString());
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            this.d.dismiss();
            item_price_exp item_price_expVar = item_price_exp.this;
            item_price_expVar.d.Md(item_price_expVar);
        }
    }

    public class x implements ExpandableListView.OnGroupClickListener {
        public x() {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            C3549oL c3549oL = (C3549oL) item_price_exp.this.l.b.get(i);
            ((C3549oL) item_price_exp.this.l.b.get(i)).n(item_price_exp.this.S(c3549oL.j(), c3549oL.c()));
            item_price_exp.this.l.g = 2;
            item_price_exp.this.l.notifyDataSetChanged();
            return false;
        }
    }

    public class y implements SearchView.OnQueryTextListener {
        public y() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            TextUtils.isEmpty(str);
            item_price_exp.this.Y(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            item_price_exp.this.M();
            return false;
        }
    }

    public class z implements Runnable {
        public final /* synthetic */ String a;

        public z(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            item_price_exp.this.F.onActionViewExpanded();
            item_price_exp.this.F.setQuery(this.a, true);
        }
    }

    private void I(String str) {
        new AlertDialog.Builder(this).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new DialogInterfaceOnClickListenerC3066a()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int groupCount = this.l.getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            this.k.collapseGroup(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        getSupportLoaderManager().initLoader(Calendar.getInstance().get(14), null, this).forceLoad();
    }

    private boolean T(int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= i2 && i4 <= i3;
    }

    private boolean U() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && T(21, 22);
    }

    private void c0(List list) {
        Collections.sort(this.n, new E(null));
    }

    private void d0(List list) {
        Collections.sort(this.n, new C(null));
    }

    private void e0(List list) {
        Collections.sort(list, Collections.reverseOrder(new i()));
    }

    private void f0() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    private void i0(List list) {
        Collections.sort(this.n, new F(null));
    }

    private void j0(List list) {
        Collections.sort(this.n, new D(null));
    }

    private void k0(List list) {
        Collections.sort(list, Collections.reverseOrder(new h()));
    }

    public void J() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void K(ArrayList arrayList, AutoCompleteTextView autoCompleteTextView, EditText editText, TextView textView) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        builder.setItems(strArr, new m(autoCompleteTextView, strArr, textView, editText));
        builder.show();
    }

    public void L(ArrayAdapter arrayAdapter, String str, TextView textView, TextView textView2) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setTranscriptMode(1);
        listView.setStackFromBottom(true);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new w(textView, str, textView2, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void O() {
        try {
            ArrayList arrayListJ3 = this.d.j3();
            this.c0 = arrayListJ3;
            String str = this.Z;
            if (str == null) {
                str = "";
            }
            this.Z = str;
            int size = arrayListJ3.size();
            RadioButton[] radioButtonArr = new RadioButton[size];
            this.b0.setTag(null);
            this.b0.removeAllViews();
            this.b0.clearCheck();
            for (int i2 = 0; i2 < this.c0.size(); i2++) {
                RadioButton radioButton = new RadioButton(this);
                radioButtonArr[i2] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.c0.get(i2)).get("name"));
                radioButtonArr[i2].setId(Integer.parseInt((String) ((HashMap) this.c0.get(i2)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i2].setButtonDrawable(android.R.color.transparent);
                radioButtonArr[i2].setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.btn_radio), (Drawable) null);
                radioButtonArr[i2].setOnClickListener(new n());
                this.b0.addView(radioButtonArr[i2]);
                String str2 = this.a0;
                if (str2 != null && str2.equals(((HashMap) this.c0.get(i2)).get("name"))) {
                    this.b0.check(radioButtonArr[i2].getId());
                    this.b0.setTag(((HashMap) this.c0.get(i2)).get("name"));
                    this.Z = (String) ((HashMap) this.c0.get(i2)).get("name");
                }
            }
            if (!this.Z.equals("")) {
                this.b0.setTag(this.Z);
                for (int i3 = 0; i3 < size; i3++) {
                    if (radioButtonArr[i3].getText().toString().equals(this.Z)) {
                        this.b0.check(radioButtonArr[i3].getId());
                    }
                }
                return;
            }
            String str3 = this.a0;
            if (str3 == null || str3.equals("")) {
                this.b0.check(radioButtonArr[this.c0.size() - 1].getId());
                this.b0.setTag(radioButtonArr[this.c0.size() - 1].getText().toString());
                this.Z = radioButtonArr[this.c0.size() - 1].getText().toString();
            }
        } catch (Exception e) {
            Log.d("fill_curr_error=", e.getMessage() + "");
            e.printStackTrace();
        }
    }

    public void P(Cursor cursor) {
        cursor.getCount();
        this.n.clear();
        C0566Hd c0566Hd = new C0566Hd();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String string = cursor.getString(c0566Hd.b(cursor, HTML.Attribute.ID));
            String string2 = cursor.getString(c0566Hd.b(cursor, "_id"));
            StringBuilder sb = new StringBuilder();
            sb.append(this.d.R7("" + cursor.getDouble(c0566Hd.b(cursor, "u_price"))));
            sb.append(cursor.getString(c0566Hd.b(cursor, "curr_name")));
            C3549oL c3549oL = new C3549oL(string, string2, "", sb.toString(), "" + cursor.getDouble(c0566Hd.b(cursor, "u_cost")), cursor.getString(c0566Hd.b(cursor, "date_")), cursor.getString(c0566Hd.b(cursor, "unit_id")));
            c3549oL.j = cursor.getString(c0566Hd.b(cursor, "curr_name2"));
            c3549oL.k = cursor.getString(c0566Hd.b(cursor, "barcode"));
            this.n.add(c3549oL);
            cursor.moveToNext();
        }
        cursor.close();
        Log.d("trace_E_item_price=", FragmentStatePagerSupport_Main.X());
        TC tc = new TC(this, this.n, this.d, 1, this);
        this.l = tc;
        this.k.setAdapter(tc);
    }

    public void Q() {
        Log.d("trace_S_item_price=", FragmentStatePagerSupport_Main.X());
        this.U = null;
        if (!this.T) {
            this.T = true;
            this.d.Vb();
        }
        this.U = this.d.tc();
    }

    public void R() {
        h0(true, this);
        new Thread(new RunnableC3070e()).start();
    }

    public ArrayList S(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Log.d("trace_S_item_price_d=", FragmentStatePagerSupport_Main.X());
        Cursor cursorYc = this.d.yc(str, str2);
        C0566Hd c0566Hd = new C0566Hd();
        cursorYc.moveToFirst();
        Log.d("trace_L_item_price_d=", FragmentStatePagerSupport_Main.X());
        while (!cursorYc.isAfterLast()) {
            arrayList.add(new C3467nL(cursorYc.getString(c0566Hd.b(cursorYc, HTML.Attribute.ID)), cursorYc.getString(c0566Hd.b(cursorYc, "_id")), cursorYc.getString(c0566Hd.b(cursorYc, "curr_name")), "" + cursorYc.getDouble(c0566Hd.b(cursorYc, "u_price")), "" + cursorYc.getDouble(c0566Hd.b(cursorYc, "u_cost")), cursorYc.getString(c0566Hd.b(cursorYc, "date_")), cursorYc.getString(c0566Hd.b(cursorYc, "unit_id"))));
            cursorYc.moveToNext();
        }
        c0566Hd.a();
        cursorYc.close();
        Log.d("trace_E_item_price_d=", FragmentStatePagerSupport_Main.X());
        return arrayList;
    }

    public void V(String str) {
        this.d0.setText(str);
        this.e0.requestFocus();
        this.g0.setText(this.d.V6(this.d0.getText().toString()));
        double dZ6 = this.d.Z6(this.d0.getText().toString(), this.g0.getText().toString());
        double dA6 = this.d.A6(this.d0.getText().toString());
        if (dA6 != 0.0d) {
            TextView textView = this.f0;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.item_cost_avg));
            sb.append(": ");
            sb.append(this.d.P7(String.valueOf(dA6 * dZ6)));
            sb.append(" ");
            Z00 z00 = this.d;
            sb.append(z00.g3(z00.l3("0")));
            textView.setText(sb.toString());
            this.f0.setVisibility(0);
        } else {
            this.f0.setVisibility(8);
        }
        if (this.d.W6(this.d0.getText().toString()) > 1) {
            this.g0.setVisibility(0);
        } else {
            this.g0.setVisibility(8);
        }
    }

    public void W(View view, String... strArr) {
        if (C2160f10.h > 0 && !new C2160f10(this.d).l("16", "new")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_item4, (ViewGroup) null);
            builder.setView(viewInflate);
            this.e0 = (EditText) viewInflate.findViewById(R.id.info_price);
            this.f0 = (TextView) viewInflate.findViewById(R.id.item_cost_avg);
            TextView textView = (TextView) viewInflate.findViewById(R.id.item_unit);
            this.g0 = textView;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.f0.setText("");
            this.f0.setVisibility(8);
            this.d.dd(this, this.e0);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_class);
            this.h0 = (ImageView) viewInflate.findViewById(R.id.tr_item_barcode);
            if (this.d.ja("prefOthers_barcode", false)) {
                this.h0.setVisibility(0);
            }
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            this.d0 = autoCompleteTextView;
            this.d.cd(this, autoCompleteTextView);
            this.b0 = (RadioGroup) viewInflate.findViewById(R.id.radiogroup_curr);
            O();
            this.g0.setOnClickListener(new o());
            if (strArr.length > 0) {
                this.d0.setText(this.d.X4("select name as _id from items where id=" + strArr[0]));
            }
            if (strArr.length > 1) {
                this.g0.setText(this.d.X4("select code as _id from units where id=" + strArr[1]));
                if (this.d.W6(this.d0.getText().toString()) > 1) {
                    this.g0.setVisibility(0);
                }
                double dZ6 = this.d.Z6(this.d0.getText().toString(), this.g0.getText().toString());
                double dA6 = this.d.A6(this.d0.getText().toString());
                if (dA6 != 0.0d) {
                    TextView textView2 = this.f0;
                    StringBuilder sb = new StringBuilder();
                    sb.append(getString(R.string.item_cost_avg));
                    sb.append(": ");
                    sb.append(this.d.P7(String.valueOf(dA6 * dZ6)));
                    sb.append(" ");
                    Z00 z00 = this.d;
                    sb.append(z00.g3(z00.l3("0")));
                    textView2.setText(sb.toString());
                    this.f0.setVisibility(0);
                } else {
                    this.f0.setVisibility(8);
                }
            } else if (this.d0.getText().length() > 0) {
                V(this.d0.getText().toString());
            }
            if (this.d0.getText().length() == 0) {
                this.d0.requestFocus();
            } else {
                this.e0.requestFocus();
            }
            ArrayList arrayListF6 = this.d.F6();
            ArrayList arrayListG6 = this.d.G6();
            C2160f10.c0(this, this.d0, arrayListG6, 1);
            C1098Yv c1098Yv = new C1098Yv(this, R.layout.data_det_row_search, arrayListG6, 4);
            c1098Yv.l.clear();
            c1098Yv.notifyDataSetChanged();
            this.d0.setThreshold(1);
            this.d0.setAdapter(c1098Yv);
            this.d0.setOnItemClickListener(new q());
            imageView.setOnClickListener(new r(arrayListF6));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new s());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new t());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new u(alertDialogCreate));
            alertDialogCreate.getButton(-2).setOnClickListener(new v(alertDialogCreate));
        } catch (Exception e) {
            Log.d("add_item2_error=", e.getMessage());
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, ArrayList arrayList) {
        try {
            Log.d("trace_E_Loader1_mon=", FragmentStatePagerSupport_Main.X());
            this.n = arrayList;
            this.k.setEmptyView(this.B);
            TC tc = new TC(this, this.n, this.d, 1, this);
            this.l = tc;
            this.k.setAdapter(tc);
            Log.d("trace_E_Loader1_mon=", FragmentStatePagerSupport_Main.X());
        } catch (Exception unused) {
        }
    }

    public void Y(String str) {
        this.l.getFilter().filter(str);
    }

    public void Z() {
        h0(true, this);
        new Thread(new RunnableC3071f()).start();
    }

    public void a0() {
        h0(true, this);
        new Thread(new g()).start();
    }

    public void amount_add_btn(View view) {
        W(view, new String[0]);
    }

    public void b0(String str) {
        AutoCompleteTextView autoCompleteTextView;
        if (!str.equals("") && this.d.da(str)) {
            String strI6 = this.d.I6(str);
            Z00.P0 = false;
            if (strI6.equals("")) {
                this.d.j1(str, this, this.C);
            }
            if (!strI6.equals("") || Z00.P0) {
                if (Z00.P0) {
                    strI6 = this.d.I6(str);
                }
                if (this.I == 2 || ((autoCompleteTextView = this.d0) != null && autoCompleteTextView.hasWindowFocus())) {
                    V(strI6);
                } else {
                    int i2 = this.I;
                    if (i2 == 1) {
                        new Handler().postDelayed(new A(strI6), 200L);
                    } else if (i2 == 3) {
                        new Handler().postDelayed(new B(strI6), 200L);
                    }
                }
                this.I = 0;
            }
        }
    }

    public void barcode_click(View view) {
        if (view.getId() == R.id.tr_item_barcode) {
            this.I = 2;
        }
        if (this.d.ia("pref_barcode_type", "1").equals("1")) {
            this.d.Td(this);
            return;
        }
        Toast.makeText(this, getString(R.string.usb_barcode), 0).show();
        if (view.getId() == R.id.tr_item_barcode) {
            this.d0.requestFocus();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.I != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            this.H += ((char) keyEvent.getUnicodeChar());
        }
        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
            String str = this.H;
            this.H = "";
            b0(str);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void h0(boolean z2, Context context) {
        Log.d("mProgress=", "....start..." + z2);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z2) {
                AlertDialog alertDialogCreate = builder.create();
                this.V = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.V;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("progress_error=", e.getMessage() + "");
        }
    }

    public void help_btn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new k());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new l());
        builder.show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        try {
            IntentResult activityResult = IntentIntegrator.parseActivityResult(i2, i3, intent);
            if (activityResult != null) {
                if (activityResult.getContents() == null) {
                    Toast.makeText(this, "Cancelled", 0).show();
                    return;
                }
                String strI6 = this.d.I6(activityResult.getContents());
                Z00.P0 = false;
                if (strI6.equals("")) {
                    this.d.j1(activityResult.getContents(), this, this.C);
                }
                if (!strI6.equals("") || Z00.P0) {
                    if (Z00.P0) {
                        strI6 = this.d.I6(activityResult.getContents());
                    }
                    new Handler().postDelayed(new z(strI6), 200L);
                }
            }
        } catch (Exception e) {
            try {
                e.printStackTrace();
                Log.d("barcode_log_error=", "results=" + e.getMessage());
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent(this, (Class<?>) FragmentStatePagerSupport_Main.class);
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        M();
        int id = view.getId();
        if (id == R.id.item_name) {
            sort_name_click(view);
        } else if (id == R.id.item_price) {
            sort_amount_click(view);
        } else {
            if (id != R.id.start_date) {
                return;
            }
            sort_tr_days_click(view);
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.report_listview_layout_exp3_);
        f0();
        setTitle(getString(R.string.sales_price_view));
        this.d = new Z00(this.c, this);
        this.t = (TextView) findViewById(R.id.footer_sum);
        this.x = (TextView) findViewById(R.id.item_name);
        this.y = (TextView) findViewById(R.id.item_price);
        this.z = (TextView) findViewById(R.id.item_curr);
        this.A = (TextView) findViewById(R.id.start_date);
        TextView textView = this.x;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.x);
        c0372Bn.a(this, this.y);
        c0372Bn.a(this, this.z);
        c0372Bn.a(this, this.A);
        this.d.md(this, this.y);
        this.d.md(this, this.z);
        this.d.md(this, this.A);
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list_report);
        this.k = expandableListView;
        expandableListView.setGroupIndicator(null);
        this.B = (TextView) findViewById(R.id.emptyResults);
        this.k.setOnChildClickListener(this.D);
        this.k.setOnGroupClickListener(this.E);
        this.k.setOnGroupExpandListener(new j());
        if (this.d.ja("prefOthers_barcode", false)) {
            C1098Yv c1098Yv = new C1098Yv(this, R.layout.data_det_row_search, this.d.G6(), 4);
            this.C = c1098Yv;
            c1098Yv.l.clear();
            this.C.notifyDataSetChanged();
        }
        try {
            R();
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.L = calendar.get(1);
        this.M = calendar.get(2);
        this.N = calendar.get(5);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(U() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.J, this.L, this.M, this.N);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(U() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.K, this.L, this.M, this.N);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<ArrayList<C3549oL>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_Loader1_g=", FragmentStatePagerSupport_Main.X());
        return new C3631pL(this, "", "", this.d, 1);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        if (this.d.ja("prefOthers_barcode", false)) {
            menuInflater.inflate(R.menu.menu_main3_barcode, menu);
        } else {
            menuInflater.inflate(R.menu.menu_main3_price, menu);
        }
        this.F = (SearchView) menu.findItem(R.id.search).getActionView();
        this.F.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        this.F.setQueryHint(getString(R.string.search_hint));
        this.F.setOnQueryTextListener(new y());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        finish();
        return true;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<ArrayList<C3549oL>> loader) {
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.print) {
            if (Build.VERSION.SDK_INT < 31) {
                J();
            }
            this.G = getTitle().toString();
            M();
            Z();
            return true;
        }
        if (itemId == R.id.print_price) {
            if (Build.VERSION.SDK_INT < 31) {
                J();
            }
            this.G = getTitle().toString();
            M();
            a0();
            return true;
        }
        if (itemId != R.id.barcode_img) {
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            finish();
            return true;
        }
        if (this.d.ia("pref_barcode_type", "1").equals("1")) {
            this.d.Td(this);
        } else {
            Toast.makeText(this, getString(R.string.usb_barcode), 0).show();
            this.I = 1;
        }
        return true;
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.b0.setTag(radioButton.getText().toString());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 112) {
            if (iArr.length == 1 && iArr[0] == 0) {
                return;
            }
            I(getString(R.string.permissions_not_granted_write_storage));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void sort_amount_click(View view) {
        if (this.X == 0) {
            c0(this.n);
            this.l.notifyDataSetChanged();
            this.X = 1;
        } else {
            i0(this.n);
            this.l.notifyDataSetChanged();
            this.X = 0;
        }
    }

    public void sort_name_click(View view) {
        if (this.X == 0) {
            k0(this.n);
            this.l.notifyDataSetChanged();
            this.X = 1;
        } else {
            e0(this.n);
            this.l.notifyDataSetChanged();
            this.X = 0;
        }
    }

    public void sort_tr_days_click(View view) {
        if (this.X == 0) {
            j0(this.n);
            this.l.notifyDataSetChanged();
            this.X = 1;
        } else {
            d0(this.n);
            this.l.notifyDataSetChanged();
            this.X = 0;
        }
    }
}
