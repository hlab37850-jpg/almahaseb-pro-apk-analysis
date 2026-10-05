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
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Adj2 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public static int W;
    public ArrayAdapter A;
    public int H;
    public int I;
    public int J;
    public ProgressDialog Q;
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public String k;
    public int l;
    public C0922Sv x;
    public SparseBooleanArray z;
    public double n = 0.0d;
    public TextView p = null;
    public AutoCompleteTextView q = null;
    public int t = 0;
    public ImageView u = null;
    public ListView v = null;
    public Toolbar w = null;
    public List y = new ArrayList();
    public ImageButton B = null;
    public ImageView C = null;
    public int D = 0;
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] F = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView G = null;
    public int K = 0;
    public String L = CSS.Value.PERCENTAGE;
    public String M = CSS.Value.PERCENTAGE;
    public TextView N = null;
    public TextView O = null;
    public String P = "";
    public Handler R = new e();
    public String S = "";
    public Cursor T = null;
    public DatePickerDialog.OnDateSetListener U = new i();
    public DatePickerDialog.OnDateSetListener V = new j();

    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public a(TextView textView, ImageView imageView) {
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
                Adj2.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Adj2.this.l = 0;
                Adj2.this.P();
            } catch (Exception unused) {
                Toast.makeText(Adj2.this.getApplicationContext(), Adj2.this.getString(R.string.sql_error), 1);
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

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            TextView textView = (TextView) view.findViewById(R.id.id);
            TextView textView2 = (TextView) view.findViewById(R.id.f8);
            TextView textView3 = (TextView) view.findViewById(R.id.f2);
            Adj2.W = Adj2.this.v.getFirstVisiblePosition();
            Adj2.this.S(textView.getText().toString(), textView2.getText().toString(), textView3.getText().toString());
        }
    }

    public class d implements AbsListView.MultiChoiceModeListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Adj2.this.K();
                } catch (Exception unused) {
                    Toast.makeText(Adj2.this.getApplicationContext(), "SQL Error.", 1);
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

        public d() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Adj2.this.z = Adj2.this.x.c();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Adj2.this);
                    builder.setMessage(Adj2.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Adj2.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Adj2.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC = Adj2.this.x.c();
                    Adj2 adj2 = Adj2.this;
                    adj2.z = sparseBooleanArrayC;
                    adj2.L();
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
            Adj2.this.v.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Adj2.this.x.l.clear();
            Adj2.this.x.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Adj2.this.v.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Adj2.this.x.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Adj2.this.v.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Adj2 adj2 = Adj2.this;
                adj2.M(adj2.T);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Adj2.this.i;
                StringBuilder sb = new StringBuilder();
                Adj2 adj3 = Adj2.this;
                sb.append(adj3.i.ic(adj3.S));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            Adj2.this.Y(false);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adj2.this.O();
            Message message = new Message();
            message.obj = "0";
            Adj2.this.R.sendMessage(message);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Adj2 adj2 = Adj2.this;
            Z00 z00 = adj2.i;
            ListView listView = adj2.v;
            String strIc = z00.ic(adj2.S);
            Adj2 adj3 = Adj2.this;
            z00.Eb(listView, strIc, adj3.L, adj3.M, adj3.t);
            Message message = new Message();
            message.obj = "1";
            Adj2.this.R.sendMessage(message);
        }
    }

    public class h implements SearchView.OnQueryTextListener {
        public h() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                Adj2.this.N(1);
            }
            Adj2.this.V(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Adj2.this.N(0);
            return false;
        }
    }

    public class i implements DatePickerDialog.OnDateSetListener {
        public i() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Adj2.this.H = i;
            Adj2.this.I = i2;
            Adj2.this.J = i3;
            try {
                String str = Adj2.this.H + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Adj2.this.I + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Adj2.this.J));
                Locale locale = Locale.ENGLISH;
                Adj2.this.N.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class j implements DatePickerDialog.OnDateSetListener {
        public j() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Adj2.this.H = i;
            Adj2.this.I = i2;
            Adj2.this.J = i3;
            try {
                String str = Adj2.this.H + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Adj2.this.I + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Adj2.this.J));
                Locale locale = Locale.ENGLISH;
                Adj2.this.O.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Adj2.this.showDialog(0);
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Adj2.this.showDialog(4);
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Adj2 adj2 = Adj2.this;
                adj2.K = 0;
                adj2.P();
            } catch (Exception unused) {
            }
        }
    }

    public class o implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public o(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Adj2 adj2 = Adj2.this;
                adj2.K = 1;
                if (adj2.N.getText() == null) {
                    Adj2.this.L = "";
                } else {
                    Adj2 adj3 = Adj2.this;
                    adj3.L = adj3.N.getText().toString();
                }
                if (Adj2.this.O.getText() == null) {
                    Adj2.this.M = "";
                } else {
                    Adj2 adj4 = Adj2.this;
                    adj4.M = adj4.O.getText().toString();
                }
                Adj2.this.P();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public void H() {
        try {
            this.K = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.N = (TextView) viewInflate.findViewById(R.id.f_date);
            this.O = (TextView) viewInflate.findViewById(R.id.t_date);
            this.N.setOnClickListener(new k());
            this.O.setOnClickListener(new l());
            builder.setPositiveButton(getString(R.string.btn_search), new m());
            builder.setNegativeButton(getString(R.string.btn_cancel), new n());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new o(alertDialogCreate));
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
        try {
            if (W <= 0) {
                W = 0;
                return;
            }
            if (this.v.getFirstVisiblePosition() > W || this.v.getLastVisiblePosition() < W) {
                this.v.setSelection(W);
            }
            W = 0;
        } catch (Exception e2) {
            W = 0;
            e2.printStackTrace();
        }
    }

    public void K() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", HTML.Tag.DEL)) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        for (int size = this.z.size() - 1; size >= 0; size--) {
            if (this.z.valueAt(size)) {
                C4145vh item = this.x.getItem(this.z.keyAt(size));
                this.x.remove(item);
                this.i.H("delete from bill_transactions where bill_id='" + item.v() + "' and exists(select * from bills a where a.id=bill_transactions.bill_id and a.date_='" + item.n() + "' and tr_type=" + this.t + ")", "delete from bills where id ='" + item.v() + "' and date_='" + item.n() + "'");
            }
        }
        P();
        X(true);
    }

    public void L() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "edit")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        int size = this.z.size() - 1;
        if (this.z.valueAt(size)) {
            C4145vh item = this.x.getItem(this.z.keyAt(size));
            S(item.v(), item.t(), item.n());
        }
    }

    public void M(Cursor cursor) {
        Log.d("Cursor_cnt=", String.valueOf(cursor.getCount()));
        double d2 = 0.0d;
        this.n = 0.0d;
        this.y.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            double d3 = Double.parseDouble(cursor.getString(cursor.getColumnIndex("f5")));
            if (d3 == d2) {
                d3 = 1.0d;
            }
            this.n += Double.parseDouble(cursor.getString(cursor.getColumnIndex("f4"))) * d3;
            this.y.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f9")), cursor.getString(cursor.getColumnIndex("f1")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), this.i.P7(cursor.getString(cursor.getColumnIndex("f4"))) + " " + cursor.getString(cursor.getColumnIndex("f10")), cursor.getString(cursor.getColumnIndex("f4")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), cursor.getString(cursor.getColumnIndex("f8")), cursor.getString(cursor.getColumnIndex("f5"))));
            if (cursor.getColumnIndex("user_name") > 0) {
                List list = this.y;
                ((C4145vh) list.get(list.size() - 1)).i = cursor.getString(cursor.getColumnIndex("user_name"));
            }
            cursor.moveToNext();
            d2 = 0.0d;
        }
        cursor.close();
        C0922Sv c0922Sv = this.x;
        if (c0922Sv == null) {
            C0922Sv c0922Sv2 = new C0922Sv(this, R.layout.data_det_row_rep5_, this.y, 4);
            this.x = c0922Sv2;
            c0922Sv2.l.clear();
            this.x.notifyDataSetChanged();
            this.v.setAdapter((ListAdapter) this.x);
        } else {
            c0922Sv.notifyDataSetChanged();
        }
        this.G.setText(this.i.P7(String.valueOf(this.n)));
        J();
    }

    public void N(int i2) {
        try {
            if (i2 == 1) {
                this.G.setText(this.i.P7(String.valueOf(this.n)));
            } else {
                this.G.setText(this.i.P7(String.valueOf(Q(this.x.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void O() {
        if (this.K == 0) {
            this.T = this.i.o6(this.t, 1, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE);
            return;
        }
        this.L = this.L.isEmpty() ? CSS.Value.PERCENTAGE : this.L;
        String str = this.M.isEmpty() ? CSS.Value.PERCENTAGE : this.M;
        this.M = str;
        this.T = this.i.o6(this.t, 2, this.L, str, CSS.Value.PERCENTAGE);
    }

    public void P() {
        new Thread(new f()).start();
    }

    public double Q(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            double d3 = Double.parseDouble(((C4145vh) list.get(i2)).b().replaceAll(",", ""));
            if (d3 == 0.0d) {
                d3 = 1.0d;
            }
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).r().replaceAll(",", "")) * d3;
        }
        return d2;
    }

    public void R() {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        Intent intent = new Intent(this, (Class<?>) Bill_adj2.class);
        intent.putExtra("TR_TYPE", String.valueOf(this.t));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public void S(String str, String str2, String str3) {
        Log.d("edit_inputs=", str + ":" + str2 + ":" + this.t + ":" + str3);
        Intent intent = new Intent(this, (Class<?>) Bill_adj2.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_DATE", str3);
        intent.putExtra("TR_TYPE", String.valueOf(this.t));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public void T() {
        Intent intent = new Intent(this.g, (Class<?>) Bill_inv_check.class);
        intent.putExtra("TR_ID", this.i.w7());
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.i.x7());
        startActivity(intent);
    }

    public void U() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        TextView textView5 = (TextView) findViewById(R.id.f5);
        textView.setText(getString(R.string.no_));
        textView2.setText(getString(R.string.date));
        int i2 = this.t;
        if (i2 == 21 || i2 == 11) {
            textView3.setText(getString(R.string.branch_name));
            textView4.setText(getString(R.string.name));
            textView5.setText(getString(R.string.tr_amount));
        }
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
        c0372Bn.a(this, textView4);
        c0372Bn.a(this, textView5);
    }

    public void V(String str) {
        try {
            C0922Sv c0922Sv = this.x;
            if (c0922Sv != null) {
                c0922Sv.getFilter().filter(str);
            }
        } catch (Exception unused) {
        }
    }

    public void W() {
        Y(true);
        new Thread(new g()).start();
    }

    public void X(boolean z) {
    }

    public void Y(boolean z) {
        if (z) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.Q = progressDialog;
            progressDialog.setMessage(getString(R.string.google_drive_list));
            this.Q.show();
            return;
        }
        ProgressDialog progressDialog2 = this.Q;
        if (progressDialog2 != null) {
            progressDialog2.hide();
        }
    }

    public final void Z() {
        P();
    }

    public void add_btn(View view) {
        R();
    }

    public void btn_add(View view) {
        if (C2160f10.h > 0) {
            if (!new C2160f10(this.i).l(this.t == 21 ? "-2" : "-3", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
        }
        Intent intent = new Intent(this, (Class<?>) Bill_adj2.class);
        intent.putExtra("TR_ID", this.l);
        intent.putExtra("TR_TYPE", String.valueOf(this.t));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.P = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new a(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new b());
        builder.create().show();
    }

    public void help_btn(View view) {
        if (this.i.g6() == 0) {
            Toast.makeText(this, getString(R.string.no_inv_bills2), 0).show();
        } else {
            T();
        }
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.P.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.P + "'");
            }
            this.P = "";
            P();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isTaskRoot()) {
            y();
        } else {
            finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_inv3);
        this.v = (ListView) findViewById(R.id.list_items);
        this.v.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        this.G = (TextView) findViewById(R.id.footer_sum);
        ImageView imageView = (ImageView) findViewById(R.id.img_help);
        this.C = imageView;
        imageView.setVisibility(4);
        this.v.setOnItemClickListener(new c());
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.t = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getResources().getStringArray(R.array.titles_main)[this.t == 21 ? (char) 7 : '\b']);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        U();
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.H = calendar.get(1);
        this.I = calendar.get(2);
        this.J = calendar.get(5);
        this.A = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.E);
        X(true);
        this.v.setChoiceMode(3);
        this.v.setMultiChoiceModeListener(new d());
        Z();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.U, this.H, this.I, this.J);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.V, this.H, this.I, this.J);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_move, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new h());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        M(this.i.L2());
        X(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Log.d("onkey=", i2 + ":4");
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
        I();
        this.S = getTitle().toString();
        W();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
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
