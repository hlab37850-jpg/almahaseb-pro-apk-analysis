package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0566Hd;
import defpackage.C2137ei;
import defpackage.C2160f10;
import defpackage.C3467nL;
import defpackage.C3549oL;
import defpackage.RC;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class currency_price_exp extends BaseActivity implements View.OnClickListener, RC.d {
    public int I;
    public int J;
    public int K;
    public AutoCompleteTextView Z;
    public SQLiteDatabase c;
    public Z00 d;
    public ExpandableListView k;
    public RC l;
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
    public TextView C = null;
    public ExpandableListView.OnChildClickListener D = new m();
    public int E = -1;
    public ExpandableListView.OnGroupClickListener F = new n();
    public DatePickerDialog.OnDateSetListener G = new p();
    public DatePickerDialog.OnDateSetListener H = new q();
    public int L = 0;
    public String M = CSS.Value.PERCENTAGE;
    public String N = CSS.Value.PERCENTAGE;
    public TextView O = null;
    public TextView P = null;
    public Cursor Q = null;
    public Handler R = new s();
    public int S = 0;
    public ArrayList T = new ArrayList();
    public String U = null;
    public String V = null;
    public DatePickerDialog.OnDateSetListener W = new f();
    public RadioGroup X = null;
    public ArrayList Y = new ArrayList();
    public Dialog a0 = null;

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL.k()).compareTo(String.valueOf(c3549oL2.k()));
        }
    }

    public class b extends WebViewClient {
        public b() {
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

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ List c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ EditText e;

        public d(AutoCompleteTextView autoCompleteTextView, String[] strArr, List list, EditText editText, EditText editText2) {
            this.a = autoCompleteTextView;
            this.b = strArr;
            this.c = list;
            this.d = editText;
            this.e = editText2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setText(this.b[i]);
            if (currency_price_exp.this.d.Y2(this.a.getText().toString()) == 0) {
                String strC7 = currency_price_exp.this.d.C7(this.a.getText().toString());
                if (strC7.equals("0")) {
                    currency_price_exp currency_price_expVar = currency_price_exp.this;
                    currency_price_expVar.O.setText(currency_price_expVar.d.K7(0));
                } else {
                    currency_price_exp.this.O.setText(strC7);
                }
            } else {
                currency_price_exp currency_price_expVar2 = currency_price_exp.this;
                currency_price_expVar2.O.setText(currency_price_expVar2.d.K7(1));
            }
            this.a.dismissDropDown();
            currency_price_exp.this.Y(currency_price_exp.this.M(this.c, this.b[i]), this.d, this.e);
        }
    }

    public class e implements ExpandableListView.OnGroupExpandListener {
        public int a = -1;

        public e() {
        }

        @Override // android.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i) {
            if (i != this.a) {
                currency_price_exp.this.k.collapseGroup(this.a);
            }
            this.a = i;
        }
    }

    public class f implements DatePickerDialog.OnDateSetListener {
        public f() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2 + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
            Locale locale = Locale.ENGLISH;
            try {
                currency_price_exp.this.O.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (AbstractC4371yX.a(currency_price_exp.this.Z)) {
                    C2137ei c2137ei = new C2137ei();
                    Calendar.getInstance();
                    Bundle bundle = new Bundle();
                    bundle.putInt("year", currency_price_exp.this.I);
                    bundle.putInt("month", currency_price_exp.this.J);
                    bundle.putInt("day", currency_price_exp.this.K);
                    c2137ei.setArguments(bundle);
                    c2137ei.f(currency_price_exp.this.W);
                    c2137ei.show(currency_price_exp.this.getSupportFragmentManager(), "Date Picker");
                }
            } catch (Exception unused) {
            }
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ List a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;

        public h(List list, EditText editText, EditText editText2) {
            this.a = list;
            this.b = editText;
            this.c = editText2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            currency_price_exp currency_price_expVar = currency_price_exp.this;
            currency_price_expVar.J(this.a, currency_price_expVar.Z, this.b, this.c);
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class k implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ List c;
        public final /* synthetic */ AlertDialog d;

        public k(EditText editText, EditText editText2, List list, AlertDialog alertDialog) {
            this.a = editText;
            this.b = editText2;
            this.c = list;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA;
            boolean z = false;
            if (this.a.getVisibility() == 0) {
                zA = AbstractC4371yX.a(this.a);
                if (!AbstractC4371yX.e(this.a)) {
                    zA = false;
                }
                if (!AbstractC4371yX.f(this.a)) {
                    zA = false;
                }
            } else {
                zA = true;
            }
            if (this.b.getVisibility() == 0) {
                if (!AbstractC4371yX.a(this.b)) {
                    zA = false;
                }
                if (!AbstractC4371yX.e(this.b)) {
                    zA = false;
                }
                if (!AbstractC4371yX.f(this.b)) {
                    zA = false;
                }
            }
            if (!AbstractC4371yX.a(currency_price_exp.this.Z)) {
                zA = false;
            }
            currency_price_exp currency_price_expVar = currency_price_exp.this;
            if (currency_price_expVar.M(this.c, currency_price_expVar.Z.getText().toString()) != null || currency_price_exp.this.Z.getText().toString().trim().length() <= 0) {
                z = zA;
            } else {
                currency_price_exp.this.Z.setError("Not Found");
            }
            Log.d("ret=", z + "");
            if (z) {
                if (currency_price_exp.this.d.G("insert into currency_price(curr_id,f_date,price,price_sar) values ((select a.id from currency a where a.name='" + currency_price_exp.this.Z.getText().toString() + "'),'" + currency_price_exp.this.O.getText().toString() + "','" + this.a.getText().toString() + "','" + this.b.getText().toString() + "')") == 0) {
                    currency_price_exp currency_price_expVar2 = currency_price_exp.this;
                    Toast.makeText(currency_price_expVar2, currency_price_expVar2.getString(R.string.currency_price_alram2), 1).show();
                } else {
                    currency_price_exp currency_price_expVar3 = currency_price_exp.this;
                    currency_price_expVar3.h0(currency_price_expVar3.d.i3(currency_price_expVar3.Z.getText().toString()));
                    this.d.dismiss();
                }
            }
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ String a;

        public l(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            currency_price_exp.this.d.ne(this.a);
            Message message = new Message();
            message.obj = "1";
            currency_price_exp.this.R.sendMessage(message);
        }
    }

    public class m implements ExpandableListView.OnChildClickListener {
        public m() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            return false;
        }
    }

    public class n implements ExpandableListView.OnGroupClickListener {
        public n() {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            currency_price_exp currency_price_expVar = currency_price_exp.this;
            currency_price_expVar.E = i;
            ((C3549oL) currency_price_exp.this.l.b.get(i)).n(currency_price_exp.this.R(((C3549oL) currency_price_expVar.l.b.get(i)).j()));
            currency_price_exp.this.l.notifyDataSetChanged();
            return false;
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class p implements DatePickerDialog.OnDateSetListener {
        public p() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            currency_price_exp.this.I = i;
            currency_price_exp.this.J = i2;
            currency_price_exp.this.K = i3;
            try {
                String str = currency_price_exp.this.I + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(currency_price_exp.this.J + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(currency_price_exp.this.K));
                Locale locale = Locale.ENGLISH;
                currency_price_exp.this.O.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                currency_price_exp currency_price_expVar = currency_price_exp.this;
                currency_price_expVar.M = currency_price_expVar.O.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    public class q implements DatePickerDialog.OnDateSetListener {
        public q() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            currency_price_exp.this.I = i;
            currency_price_exp.this.J = i2;
            currency_price_exp.this.K = i3;
            try {
                String str = currency_price_exp.this.I + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(currency_price_exp.this.J + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(currency_price_exp.this.K));
                Locale locale = Locale.ENGLISH;
                currency_price_exp.this.P.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                currency_price_exp currency_price_expVar = currency_price_exp.this;
                currency_price_expVar.N = currency_price_expVar.P.getText().toString();
            } catch (Exception unused) {
            }
        }
    }

    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            currency_price_exp.this.O();
            Message message = new Message();
            message.obj = "0";
            currency_price_exp.this.R.sendMessage(message);
        }
    }

    public class s extends Handler {
        public s() {
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
                currency_price_exp currency_price_expVar = currency_price_exp.this;
                currency_price_expVar.L(currency_price_expVar.Q);
                currency_price_exp currency_price_expVar2 = currency_price_exp.this;
                int i = currency_price_expVar2.E;
                if (i != -1 && i < currency_price_expVar2.k.getAdapter().getCount()) {
                    currency_price_exp.this.k.expandGroup(currency_price_exp.this.E);
                } else if (currency_price_exp.this.k.getAdapter().getCount() == 1) {
                    currency_price_exp.this.k.expandGroup(0);
                }
            } else if (message.obj.toString().equals("1")) {
                currency_price_exp currency_price_expVar3 = currency_price_exp.this;
                currency_price_expVar3.L(currency_price_expVar3.d.Ec());
                currency_price_exp currency_price_expVar4 = currency_price_exp.this;
                int i2 = currency_price_expVar4.E;
                if (i2 != -1 && i2 < currency_price_expVar4.k.getAdapter().getCount()) {
                    currency_price_exp.this.k.expandGroup(currency_price_exp.this.E);
                } else if (currency_price_exp.this.k.getAdapter().getCount() == 1) {
                    currency_price_exp.this.k.expandGroup(0);
                }
            }
            currency_price_exp currency_price_expVar5 = currency_price_exp.this;
            currency_price_expVar5.d0(false, currency_price_expVar5);
        }
    }

    public class t implements Comparator {
        public t() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return String.valueOf(c3549oL2.k()).compareTo(String.valueOf(c3549oL.k()));
        }
    }

    public static class u {
        public final String a;
        public final String b;
        public final String c;

        public u(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public String toString() {
            return this.b;
        }
    }

    public static class v implements Comparator {
        public v() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL.l()).compareTo(Double.valueOf(c3549oL2.l()));
        }

        public /* synthetic */ v(e eVar) {
            this();
        }
    }

    public static class w implements Comparator {
        public w() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL2.l()).compareTo(Double.valueOf(c3549oL.l()));
        }

        public /* synthetic */ w(e eVar) {
            this();
        }
    }

    public static class x implements Comparator {
        public x() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL.a().replaceAll(",", "")).compareTo(Double.valueOf(c3549oL2.a().replaceAll(",", "")));
        }

        public /* synthetic */ x(e eVar) {
            this();
        }
    }

    public static class y implements Comparator {
        public y() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3549oL c3549oL, C3549oL c3549oL2) {
            return Double.valueOf(c3549oL2.a().replaceAll(",", "")).compareTo(Double.valueOf(c3549oL.a().replaceAll(",", "")));
        }

        public /* synthetic */ y(e eVar) {
            this();
        }
    }

    private void I(String str) {
        new AlertDialog.Builder(this).setTitle("Permission Request").setMessage(str).setCancelable(false).setPositiveButton(android.R.string.yes, new o()).show();
    }

    private void K() {
        int groupCount = this.l.getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            this.k.collapseGroup(i2);
        }
    }

    private boolean T(int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= i2 && i4 <= i3;
    }

    private boolean U() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && T(21, 22);
    }

    private void Z(List list) {
        Collections.sort(this.n, new x(null));
    }

    private void a0(List list) {
        Collections.sort(this.n, new v(null));
    }

    private void b0(List list) {
        Collections.sort(list, Collections.reverseOrder(new a()));
    }

    private void c0() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void e0(List list) {
        Collections.sort(this.n, new y(null));
    }

    private void f0(List list) {
        Collections.sort(this.n, new w(null));
    }

    private void g0(List list) {
        Collections.sort(list, Collections.reverseOrder(new t()));
    }

    public void J(List list, AutoCompleteTextView autoCompleteTextView, EditText editText, EditText editText2) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        String[] strArrN = N(list);
        builder.setItems(strArrN, new d(autoCompleteTextView, strArrN, list, editText, editText2));
        builder.show();
    }

    public void L(Cursor cursor) {
        cursor.getCount();
        this.n.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            C3549oL c3549oL = new C3549oL(cursor.getString(cursor.getColumnIndex(HTML.Attribute.ID)), cursor.getString(cursor.getColumnIndex("_id")), "", cursor.getString(cursor.getColumnIndex("price")), cursor.getString(cursor.getColumnIndex("f_date")), cursor.getString(cursor.getColumnIndex("t_date")), "", cursor.getString(cursor.getColumnIndex("price_sar")));
            c3549oL.n(R(cursor.getString(cursor.getColumnIndex(HTML.Attribute.ID))));
            this.n.add(c3549oL);
            cursor.moveToNext();
        }
        cursor.close();
        RC rc = new RC(this, this.n, this);
        this.l = rc;
        this.k.setAdapter(rc);
    }

    public final u M(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                String str2 = uVar.b;
                if (str2 != null && str2.equals(str)) {
                    return uVar;
                }
            }
        }
        return null;
    }

    public final String[] N(List list) {
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = ((u) list.get(i2)).b;
        }
        return strArr;
    }

    public void O() {
        this.Q = null;
        this.Q = this.d.Ec();
    }

    public void P() {
        d0(true, this);
        new Thread(new r()).start();
    }

    public List Q() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = this.d.a.rawQuery(info.aalmoghalis.inventory.zatca.d.E(this) ? "SELECT a.id AS id, a.name AS name,a.code_name code_name FROM currency a where (a.curr_type=1 or lower(a.code_name)!='sar') order by a.id" : "SELECT a.id AS id, a.name AS name,a.code_name code_name FROM currency a where a.curr_type=1 order by a.id", null);
        try {
            int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow(HTML.Attribute.ID);
            int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("name");
            int columnIndexOrThrow3 = cursorRawQuery.getColumnIndexOrThrow("code_name");
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(new u(cursorRawQuery.getString(columnIndexOrThrow), cursorRawQuery.getString(columnIndexOrThrow2), cursorRawQuery.getString(columnIndexOrThrow3)));
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public ArrayList R(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorDc = this.d.Dc(str);
        C0566Hd c0566Hd = new C0566Hd();
        cursorDc.moveToFirst();
        while (!cursorDc.isAfterLast()) {
            arrayList.add(new C3467nL(cursorDc.getString(c0566Hd.b(cursorDc, HTML.Attribute.ID)), cursorDc.getString(c0566Hd.b(cursorDc, "_id")), "", cursorDc.getString(c0566Hd.b(cursorDc, "price")), cursorDc.getString(c0566Hd.b(cursorDc, "f_date")), cursorDc.getString(c0566Hd.b(cursorDc, "t_date")), "", cursorDc.getString(c0566Hd.b(cursorDc, "price_sar"))));
            cursorDc.moveToNext();
        }
        c0566Hd.a();
        cursorDc.close();
        return arrayList;
    }

    public void S() {
        TextView textView = (TextView) findViewById(R.id.item_name);
        TextView textView2 = (TextView) findViewById(R.id.item_price);
        TextView textView3 = (TextView) findViewById(R.id.item_curr);
        TextView textView4 = (TextView) findViewById(R.id.start_date);
        TextView textView5 = (TextView) findViewById(R.id.item_price_sar);
        textView.setText(getString(R.string.currency));
        textView2.setText(getString(R.string.price));
        textView3.setText(getString(R.string.f_date_hdr));
        textView4.setText(getString(R.string.t_date_hdr));
        textView5.setText(getString(R.string.curr_price_sar));
    }

    public final /* synthetic */ void V(EditText editText, EditText editText2, AdapterView adapterView, View view, int i2, long j2) {
        u uVar = (u) adapterView.getItemAtPosition(i2);
        this.Z.setText((CharSequence) uVar.b, false);
        Y(uVar, editText, editText2);
    }

    public final /* synthetic */ void W(View view) {
        this.Z.showDropDown();
    }

    public void X() {
        try {
            if (C2160f10.h > 0 && !new C2160f10(this.d).l("20", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_currency_price, (ViewGroup) null);
            builder.setView(viewInflate);
            final EditText editText = (EditText) viewInflate.findViewById(R.id.info_price);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_class);
            this.O = (TextView) viewInflate.findViewById(R.id.f_date);
            this.Z = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            final EditText editText2 = (EditText) viewInflate.findViewById(R.id.info_price_sar);
            editText2.setVisibility(8);
            if (info.aalmoghalis.inventory.zatca.d.E(this)) {
                editText2.setVisibility(0);
            }
            if (this.Z.getText().toString().length() <= 0 || this.d.Y2(this.Z.getText().toString()) != 0) {
                this.O.setText(this.d.K7(1));
            } else {
                this.O.setText(this.d.K7(0));
            }
            this.O.setOnClickListener(new g());
            this.Z.requestFocus();
            List listQ = Q();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listQ);
            this.Z.setThreshold(1);
            this.Z.setAdapter(arrayAdapter);
            this.Z.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: F00
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    this.a.V(editText, editText2, adapterView, view, i2, j2);
                }
            });
            this.Z.setOnClickListener(new View.OnClickListener() { // from class: G00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.W(view);
                }
            });
            imageView.setOnClickListener(new h(listQ, editText, editText2));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new i());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new j());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new k(editText, editText2, listQ, alertDialogCreate));
        } catch (Exception e2) {
            Log.d("add_item2_error=", e2.getMessage());
        }
    }

    public void Y(u uVar, EditText editText, EditText editText2) {
        if (uVar.a.equals("0")) {
            editText.setText("1");
            editText.setVisibility(8);
            editText2.requestFocus();
        } else if (uVar.c.toLowerCase().equals("sar")) {
            editText2.setText("1");
            editText2.setVisibility(8);
            editText.requestFocus();
        } else {
            editText.setText("");
            editText.setVisibility(0);
            editText.requestFocus();
        }
    }

    public void amount_add_btn(View view) {
        X();
    }

    public void d0(boolean z, Context context) {
        Log.d("mProgress=", "....start..." + z);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z) {
                AlertDialog alertDialogCreate = builder.create();
                this.a0 = alertDialogCreate;
                alertDialogCreate.show();
            } else {
                Dialog dialog = this.a0;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("progress_error=", e2.getMessage() + "");
        }
    }

    public void h0(String str) {
        d0(true, this);
        new Thread(new l(str)).start();
    }

    public void help_btn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new b());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new c());
        builder.show();
    }

    @Override // RC.d
    public void k() {
        L(this.d.Ec());
        int i2 = this.E;
        if (i2 != -1 && i2 < this.k.getAdapter().getCount()) {
            this.k.expandGroup(this.E);
        } else if (this.k.getAdapter().getCount() == 1) {
            this.k.expandGroup(0);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        K();
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
        setContentView(R.layout.report_listview_layout_exp3_1);
        c0();
        setTitle(getString(R.string.pref_curr_price));
        this.d = new Z00(this.c, this);
        this.t = (TextView) findViewById(R.id.item_name);
        S();
        this.x = (TextView) findViewById(R.id.item_name);
        this.y = (TextView) findViewById(R.id.item_price);
        this.A = (TextView) findViewById(R.id.item_curr);
        this.B = (TextView) findViewById(R.id.start_date);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.x);
        c0372Bn.a(this, this.y);
        c0372Bn.a(this, this.A);
        c0372Bn.a(this, this.B);
        TextView textView = (TextView) findViewById(R.id.item_price_sar);
        this.z = textView;
        c0372Bn.a(this, textView);
        if (info.aalmoghalis.inventory.zatca.d.E(this)) {
            this.z.setVisibility(0);
        }
        this.k = (ExpandableListView) findViewById(R.id.list_report);
        this.C = (TextView) findViewById(R.id.emptyResults);
        this.k.setGroupIndicator(null);
        this.k.setOnChildClickListener(this.D);
        this.k.setOnGroupClickListener(this.F);
        this.k.setOnGroupExpandListener(new e());
        try {
            P();
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.I = calendar.get(1);
        this.J = calendar.get(2);
        this.K = calendar.get(5);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(U() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.G, this.I, this.J, this.K);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(U() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.H, this.I, this.J, this.K);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.X.setTag(radioButton.getText().toString());
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
        if (this.S == 0) {
            Z(this.n);
            this.l.notifyDataSetChanged();
            this.S = 1;
        } else {
            e0(this.n);
            this.l.notifyDataSetChanged();
            this.S = 0;
        }
    }

    public void sort_name_click(View view) {
        if (this.S == 0) {
            g0(this.n);
            this.l.notifyDataSetChanged();
            this.S = 1;
        } else {
            b0(this.n);
            this.l.notifyDataSetChanged();
            this.S = 0;
        }
    }

    public void sort_tr_days_click(View view) {
        if (this.S == 0) {
            f0(this.n);
            this.l.notifyDataSetChanged();
            this.S = 1;
        } else {
            a0(this.n);
            this.l.notifyDataSetChanged();
            this.S = 0;
        }
    }
}
