package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C0922Sv;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Bills2_Report extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0922Sv A;
    public SparseBooleanArray C;
    public ArrayAdapter D;
    public ProgressDialog N;
    public int R;
    public int S;
    public int T;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public int n = 0;
    public double p = 0.0d;
    public TextView q = null;
    public AutoCompleteTextView t = null;
    public TextView u = null;
    public SwitchCompat v = null;
    public int w = 0;
    public ImageView x = null;
    public ListView y = null;
    public Toolbar z = null;
    public List B = new ArrayList();
    public ImageButton E = null;
    public AppCompatCheckBox F = null;
    public int G = 0;
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] I = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView J = null;
    public int K = 0;
    public String L = "";
    public int M = 0;
    public Handler O = new g();
    public String P = "";
    public Cursor Q = null;
    public int U = 0;
    public String V = CSS.Value.PERCENTAGE;
    public String W = CSS.Value.PERCENTAGE;
    public TextView X = null;
    public TextView Y = null;
    public DatePickerDialog.OnDateSetListener Z = new r();
    public DatePickerDialog.OnDateSetListener a0 = new s();

    public class a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Bills2_Report$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0292a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0292a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Bills2_Report.this.J();
                } catch (Exception unused) {
                    Toast.makeText(Bills2_Report.this.getApplicationContext(), "SQL Error.", 1);
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

        public a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Bills2_Report.this.C = Bills2_Report.this.A.c();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Bills2_Report.this);
                    builder.setMessage(Bills2_Report.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Bills2_Report.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0292a());
                    builder.setNegativeButton(Bills2_Report.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC = Bills2_Report.this.A.c();
                    Bills2_Report bills2_Report = Bills2_Report.this;
                    bills2_Report.C = sparseBooleanArrayC;
                    bills2_Report.K();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Bills2_Report.this.y.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Bills2_Report.this.A.l.clear();
            Bills2_Report.this.A.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Bills2_Report.this.y.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Bills2_Report.this.A.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Bills2_Report.this.y.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(false);
                menu.findItem(R.id.menu_edit).setVisible(false);
            }
            return false;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills2_Report.this.b0(view);
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh2.n().compareTo(String.valueOf(c4145vh.n()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v()) : iCompareTo;
        }
    }

    public class d implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo = c4145vh.n().compareTo(String.valueOf(c4145vh2.n()));
            return iCompareTo == 0 ? Integer.parseInt(c4145vh.v()) - Integer.parseInt(c4145vh2.v()) : iCompareTo;
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public e(TextView textView, ImageView imageView) {
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
                Bills2_Report.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Bills2_Report.this.l = 0;
                Bills2_Report.this.P();
            } catch (Exception unused) {
                Toast.makeText(Bills2_Report.this.getApplicationContext(), Bills2_Report.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g extends Handler {
        public g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Bills2_Report bills2_Report = Bills2_Report.this;
                bills2_Report.L(bills2_Report.Q);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Bills2_Report.this.i;
                StringBuilder sb = new StringBuilder();
                Bills2_Report bills2_Report2 = Bills2_Report.this;
                sb.append(bills2_Report2.i.ic(bills2_Report2.P));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            Bills2_Report.this.Z(false);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bills2_Report.this.N();
            Message message = new Message();
            message.obj = "0";
            Bills2_Report.this.O.sendMessage(message);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bills2_Report bills2_Report = Bills2_Report.this;
            Z00 z00 = bills2_Report.i;
            z00.sb(bills2_Report.y, z00.ic(bills2_Report.P), Bills2_Report.this.S());
            Message message = new Message();
            message.obj = "1";
            Bills2_Report.this.O.sendMessage(message);
        }
    }

    public class j extends WebViewClient {
        public j() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details('2','8','7')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bills2_Report.this.showDialog(0);
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bills2_Report.this.showDialog(4);
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Bills2_Report bills2_Report = Bills2_Report.this;
                bills2_Report.U = 0;
                bills2_Report.P();
            } catch (Exception unused) {
            }
        }
    }

    public class p implements View.OnClickListener {
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public p(androidx.appcompat.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Bills2_Report bills2_Report = Bills2_Report.this;
                bills2_Report.U = 1;
                if (bills2_Report.X.getText() == null) {
                    Bills2_Report.this.V = "";
                } else {
                    Bills2_Report bills2_Report2 = Bills2_Report.this;
                    bills2_Report2.V = bills2_Report2.X.getText().toString();
                }
                if (Bills2_Report.this.Y.getText() == null) {
                    Bills2_Report.this.W = "";
                } else {
                    Bills2_Report bills2_Report3 = Bills2_Report.this;
                    bills2_Report3.W = bills2_Report3.Y.getText().toString();
                }
                Bills2_Report.this.P();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class q implements SearchView.OnQueryTextListener {
        public q() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Bills2_Report.this.M(1);
            }
            Bills2_Report.this.U(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Bills2_Report.this.M(0);
            return false;
        }
    }

    public class r implements DatePickerDialog.OnDateSetListener {
        public r() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bills2_Report.this.R = i;
            Bills2_Report.this.S = i2;
            Bills2_Report.this.T = i3;
            try {
                String str = Bills2_Report.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills2_Report.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills2_Report.this.T));
                Locale locale = Locale.ENGLISH;
                Bills2_Report.this.X.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class s implements DatePickerDialog.OnDateSetListener {
        public s() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Bills2_Report.this.R = i;
            Bills2_Report.this.S = i2;
            Bills2_Report.this.T = i3;
            try {
                String str = Bills2_Report.this.R + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills2_Report.this.S + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Bills2_Report.this.T));
                Locale locale = Locale.ENGLISH;
                Bills2_Report.this.Y.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    private void W(List list) {
        Collections.sort(list, Collections.reverseOrder(new d()));
    }

    private void a0(List list) {
        Collections.sort(list, Collections.reverseOrder(new c()));
    }

    private void c0() {
        P();
        int i2 = this.w;
        if (i2 == 2) {
            this.q.setText(getString(R.string.supp));
            O();
        } else if (i2 == 1) {
            this.q.setText(getString(R.string.cus));
            O();
        }
    }

    public void H() {
        try {
            this.U = 0;
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.X = (TextView) viewInflate.findViewById(R.id.f_date);
            this.Y = (TextView) viewInflate.findViewById(R.id.t_date);
            this.X.setOnClickListener(new l());
            this.Y.setOnClickListener(new m());
            builder.setPositiveButton(getString(R.string.btn_search), new n());
            builder.setNegativeButton(getString(R.string.btn_cancel), new o());
            androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new p(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void I() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void J() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.w == 1 ? "-6" : "-7", HTML.Tag.DEL)) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        for (int size = this.C.size() - 1; size >= 0; size--) {
            if (this.C.valueAt(size)) {
                this.A.remove(this.A.getItem(this.C.keyAt(size)));
            }
        }
        c0();
        X(true);
    }

    public void K() {
        int size = this.C.size() - 1;
        if (this.C.valueAt(size)) {
            this.A.getItem(this.C.keyAt(size));
        }
    }

    public void L(Cursor cursor) {
        T();
        Log.d("Cursor_cnt=", String.valueOf(cursor.getCount()));
        this.p = 0.0d;
        this.B.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.p += Double.parseDouble(cursor.getString(cursor.getColumnIndex("f4")));
            this.B.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f1")), cursor.getString(cursor.getColumnIndex("f2")) + " - " + cursor.getString(cursor.getColumnIndex("f7")) + cursor.getString(cursor.getColumnIndex("f8")), this.i.P7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("f3")))), this.i.P7(String.valueOf(cursor.getDouble(cursor.getColumnIndex("f4")))), cursor.getString(cursor.getColumnIndex("f5")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep4, this.B, 4, S(), 1);
        this.A = c0922Sv;
        c0922Sv.l.clear();
        this.A.notifyDataSetChanged();
        this.y.setAdapter((ListAdapter) this.A);
        this.J.setText(this.i.P7(String.valueOf(this.p)));
    }

    public void M(int i2) {
        try {
            if (i2 == 1) {
                this.J.setText(this.i.P7(String.valueOf(this.p)));
            } else {
                this.J.setText(this.i.P7(String.valueOf(Q(this.A.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void N() {
        int i2 = this.U;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            this.Q = this.i.k2(this.w, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
            return;
        }
        this.V = this.V.isEmpty() ? CSS.Value.PERCENTAGE : this.V;
        if (!this.W.isEmpty()) {
            str = this.W;
        }
        this.W = str;
        this.Q = this.i.k2(this.w, this.V, str);
    }

    public void O() {
        if (this.v.isChecked()) {
            this.u.setText(getString(R.string.bill_cash));
        } else {
            this.u.setText(getString(R.string.bill_post));
        }
        Cursor cursorX8 = this.i.x8(this.v.isChecked(), this.w);
        this.H = new String[cursorX8.getCount()];
        if (cursorX8.moveToFirst()) {
            int i2 = 0;
            do {
                this.H[i2] = cursorX8.getString(cursorX8.getColumnIndex("_id"));
                i2++;
            } while (cursorX8.moveToNext());
        }
        cursorX8.close();
        this.D = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.H);
        this.t.setThreshold(1);
        this.t.setAdapter(this.D);
    }

    public void P() {
        Z(true);
        new Thread(new h()).start();
    }

    public double Q(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).p().replaceAll(",", ""));
        }
        return d2;
    }

    public void R(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2);
        Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.w));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
        finish();
    }

    public boolean S() {
        int i2 = this.w;
        if (i2 != 2) {
            return i2 == 1 && this.K <= 1;
        }
        return true;
    }

    public void T() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        textView.setText(getString(R.string.branch));
        textView2.setText(getString(R.string.item));
        textView3.setText(getString(R.string.qty));
        textView4.setText(getString(R.string.price));
        textView2.setOnClickListener(new b());
        if (S()) {
            textView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams.weight = 60.0f;
            textView2.setLayoutParams(layoutParams);
        }
    }

    public void U(String str) {
        this.A.getFilter().filter(str);
    }

    public void V() {
        Z(true);
        new Thread(new i()).start();
    }

    public void X(boolean z) {
    }

    public void Y() {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new j());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new k());
        builder.show();
    }

    public void Z(boolean z) {
        if (!z) {
            this.N.hide();
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.N = progressDialog;
        progressDialog.setMessage(getString(R.string.google_drive_list));
        this.N.show();
    }

    public void add_btn(View view) {
        this.i.z(this, this.j, this.k);
    }

    public void amount_add_btn(View view) {
        add_btn(view);
    }

    public final void b0(View view) {
        if (this.M == 0) {
            a0(this.B);
            this.A.notifyDataSetChanged();
            this.M = 1;
        } else {
            W(this.B);
            this.A.notifyDataSetChanged();
            this.M = 0;
        }
    }

    public void btn_add(View view) {
        Bill_edit.P2 = true;
        this.i.z(this, this.j, this.k);
        finish();
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.L = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        R(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f8)).getText().toString());
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(R.id.page_name);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(R.string.disable) + "#" + ((Object) textView.getText()) + "?");
        }
        builder.setPositiveButton(getString(R.string.confirm_yes), new e(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new f());
        builder.create().show();
    }

    public void help_btn(View view) {
        Y();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.L.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.L + "'");
            }
            this.L = "";
            P();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        this.U = 0;
        P();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_bill3);
        setTitle(getIntent().getStringExtra("title_"));
        this.y = (ListView) findViewById(R.id.list_items);
        this.y.setEmptyView((TextView) findViewById(R.id.emptyResults));
        Z00 z00 = new Z00(this.h, this);
        this.i = z00;
        this.K = z00.F2();
        this.J = (TextView) findViewById(R.id.footer_sum);
        try {
            T();
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.w = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getIntent().getStringExtra("title_"));
            }
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.R = calendar.get(1);
        this.S = calendar.get(2);
        this.T = calendar.get(5);
        X(true);
        this.y.setMultiChoiceModeListener(new a());
        P();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.Z, this.R, this.S, this.T);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.a0, this.R, this.S, this.T);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new q());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        L(this.i.L2());
        X(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.adv_search) {
            H();
            return true;
        }
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            I();
        }
        this.P = getTitle().toString();
        V();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Bill_edit.P2) {
            Bill_edit.P2 = false;
            recreate();
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
}
