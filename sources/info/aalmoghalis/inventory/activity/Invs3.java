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
public class Invs3 extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public static int V;
    public ArrayAdapter A;
    public int G;
    public int H;
    public int I;
    public ProgressDialog P;
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
    public int C = 0;
    public String[] D = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public TextView F = null;
    public int J = 0;
    public String K = CSS.Value.PERCENTAGE;
    public String L = CSS.Value.PERCENTAGE;
    public TextView M = null;
    public TextView N = null;
    public String O = "";
    public Handler Q = new e();
    public String R = "";
    public Cursor S = null;
    public DatePickerDialog.OnDateSetListener T = new i();
    public DatePickerDialog.OnDateSetListener U = new j();

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
                Invs3.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Invs3.this.l = 0;
                Invs3.this.O();
            } catch (Exception unused) {
                Toast.makeText(Invs3.this.getApplicationContext(), Invs3.this.getString(R.string.sql_error), 1);
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
            Invs3.V = Invs3.this.v.getFirstVisiblePosition();
            Invs3.this.R(textView.getText().toString(), textView2.getText().toString());
        }
    }

    public class d implements AbsListView.MultiChoiceModeListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Invs3.this.J();
                } catch (Exception unused) {
                    Toast.makeText(Invs3.this.getApplicationContext(), "SQL Error.", 1);
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
                    Invs3.this.z = Invs3.this.x.c();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Invs3.this);
                    builder.setMessage(Invs3.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Invs3.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Invs3.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC = Invs3.this.x.c();
                    Invs3 invs3 = Invs3.this;
                    invs3.z = sparseBooleanArrayC;
                    invs3.K();
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
            Invs3.this.v.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Invs3.this.x.l.clear();
            Invs3.this.x.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Invs3.this.v.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Invs3.this.x.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Invs3.this.v.getCheckedItemCount() != 1) {
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
                Invs3 invs3 = Invs3.this;
                invs3.L(invs3.S);
            } else if (message.obj.toString().equals("1")) {
                Z00 z00 = Invs3.this.i;
                StringBuilder sb = new StringBuilder();
                Invs3 invs4 = Invs3.this;
                sb.append(invs4.i.ic(invs4.R));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
            Invs3.this.X(false);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Invs3.this.N();
            Message message = new Message();
            message.obj = "0";
            Invs3.this.Q.sendMessage(message);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Invs3 invs3 = Invs3.this;
            Z00 z00 = invs3.i;
            ListView listView = invs3.v;
            String strIc = z00.ic(invs3.R);
            Invs3 invs4 = Invs3.this;
            z00.Eb(listView, strIc, invs4.K, invs4.L, invs4.t);
            Message message = new Message();
            message.obj = "1";
            Invs3.this.Q.sendMessage(message);
        }
    }

    public class h implements SearchView.OnQueryTextListener {
        public h() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                Invs3.this.M(1);
            }
            Invs3.this.U(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Invs3.this.M(0);
            return false;
        }
    }

    public class i implements DatePickerDialog.OnDateSetListener {
        public i() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Invs3.this.G = i;
            Invs3.this.H = i2;
            Invs3.this.I = i3;
            try {
                String str = Invs3.this.G + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Invs3.this.H + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Invs3.this.I));
                Locale locale = Locale.ENGLISH;
                Invs3.this.M.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class j implements DatePickerDialog.OnDateSetListener {
        public j() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Invs3.this.G = i;
            Invs3.this.H = i2;
            Invs3.this.I = i3;
            try {
                String str = Invs3.this.G + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Invs3.this.H + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Invs3.this.I));
                Locale locale = Locale.ENGLISH;
                Invs3.this.N.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    private void Y() {
        O();
    }

    public void H() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void I() {
        try {
            if (V <= 0) {
                V = 0;
                return;
            }
            if (this.v.getFirstVisiblePosition() > V || this.v.getLastVisiblePosition() < V) {
                this.v.setSelection(V);
            }
            V = 0;
        } catch (Exception e2) {
            V = 0;
            e2.printStackTrace();
        }
    }

    public void J() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.z.size() - 1; size >= 0; size--) {
            if (this.z.valueAt(size)) {
                C4145vh item = this.x.getItem(this.z.keyAt(size));
                this.x.remove(item);
                this.i.H("delete from bill_transactions2 where bill_id='" + item.v() + "'", "delete from bills2 where id ='" + item.v() + "'");
            }
        }
        O();
        W(true);
    }

    public void K() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.z.size() - 1;
        if (this.z.valueAt(size)) {
            C4145vh item = this.x.getItem(this.z.keyAt(size));
            R(item.v(), item.t());
        }
    }

    public void L(Cursor cursor) {
        Log.d("Cursor_cnt=", String.valueOf(cursor.getCount()));
        this.n = 0.0d;
        this.y.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.n += Double.parseDouble(cursor.getString(cursor.getColumnIndex("f3")));
            this.y.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f9")), cursor.getString(cursor.getColumnIndex("f1")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), this.i.P7(cursor.getString(cursor.getColumnIndex("f2"))), cursor.getString(cursor.getColumnIndex("f4")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), cursor.getString(cursor.getColumnIndex("f8")), ""));
            cursor.moveToNext();
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
        this.F.setText(this.i.P7(String.valueOf(this.n)));
        I();
    }

    public void M(int i2) {
        try {
            if (i2 == 1) {
                this.F.setText(this.i.P7(String.valueOf(this.n)));
            } else {
                this.F.setText(this.i.P7(String.valueOf(P(this.x.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void N() {
        int i2 = this.J;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            Z00 z00 = this.i;
            int i3 = this.t;
            if (!this.j.equals("0")) {
                str = this.k;
            }
            this.S = z00.n6(i3, 1, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, str);
            return;
        }
        this.K = this.K.isEmpty() ? CSS.Value.PERCENTAGE : this.K;
        String str2 = this.L.isEmpty() ? CSS.Value.PERCENTAGE : this.L;
        this.L = str2;
        Z00 z01 = this.i;
        int i4 = this.t;
        String str3 = this.K;
        if (!this.j.equals("0")) {
            str = this.k;
        }
        this.S = z01.n6(i4, 0, str3, str2, str);
    }

    public void O() {
        new Thread(new f()).start();
    }

    public double P(List list) {
        Log.d("net_bal:", list.size() + "");
        double d2 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d2 += Double.parseDouble(((C4145vh) list.get(i2)).q().replaceAll(",", ""));
        }
        return d2;
    }

    public void Q() {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "new")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) Bill_inv.class);
        intent.putExtra("TR_TYPE", String.valueOf(this.t));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public void R(String str, String str2) {
        Log.d("edit_inputs=", str + ":" + str2 + ":" + this.t);
        Intent intent = new Intent(this, (Class<?>) Bill_inv.class);
        intent.putExtra("TR_ID", str);
        intent.putExtra("TR_TYPE", String.valueOf(this.t));
        intent.putExtra("tran_status", String.valueOf(str2));
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.k);
        startActivity(intent);
    }

    public void S() {
        Intent intent = new Intent(this.g, (Class<?>) Bill_inv_check.class);
        intent.putExtra("TR_ID", this.i.w7());
        intent.putExtra("g_id", this.j);
        intent.putExtra("g_name", this.i.x7());
        startActivity(intent);
    }

    public void T() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        TextView textView5 = (TextView) findViewById(R.id.f5);
        textView.setText(getString(R.string.no_));
        textView2.setText(getString(R.string.date));
        if (this.t == 7) {
            textView3.setText(getString(R.string.branch_name));
            textView4.setText(getString(R.string.statement));
            textView5.setText(getString(R.string.qty));
        }
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        c0372Bn.a(this, textView3);
        c0372Bn.a(this, textView4);
        c0372Bn.a(this, textView5);
    }

    public void U(String str) {
        try {
            C0922Sv c0922Sv = this.x;
            if (c0922Sv != null) {
                c0922Sv.getFilter().filter(str);
            }
        } catch (Exception unused) {
        }
    }

    public void V() {
        X(true);
        new Thread(new g()).start();
    }

    public void W(boolean z) {
    }

    public void X(boolean z) {
        if (z) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.P = progressDialog;
            progressDialog.setMessage(getString(R.string.google_drive_list));
            this.P.show();
            return;
        }
        ProgressDialog progressDialog2 = this.P;
        if (progressDialog2 != null) {
            progressDialog2.hide();
        }
    }

    public void add_btn(View view) {
        Q();
    }

    public void btn_add(View view) {
        if (C2160f10.h > 0 && !new C2160f10(this.i).l("28", "new")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) Bill_inv.class);
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
        this.O = textView.getText().toString();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new a(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new b());
        builder.create().show();
    }

    public void help_btn(View view) {
        if (this.i.g6() == 0) {
            Toast.makeText(this, getString(R.string.no_inv_bills2), 0).show();
        } else {
            S();
        }
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.O.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.O + "'");
            }
            this.O = "";
            O();
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
        this.F = (TextView) findViewById(R.id.footer_sum);
        this.v.setOnItemClickListener(new c());
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.t = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.j = getIntent().getStringExtra("g_id");
                this.k = getIntent().getStringExtra("g_name");
                setTitle(getResources().getStringArray(R.array.titles_main)[this.t - 3]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        T();
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.G = calendar.get(1);
        this.H = calendar.get(2);
        this.I = calendar.get(5);
        this.A = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.D);
        W(true);
        this.v.setChoiceMode(3);
        this.v.setMultiChoiceModeListener(new d());
        Y();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.T, this.G, this.H, this.I);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.U, this.G, this.H, this.I);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3_group_inv, menu);
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
        L(this.i.L2());
        W(true);
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
        if (menuItem.getItemId() == R.id.inv_compare) {
            S();
            return true;
        }
        if (menuItem.getItemId() != R.id.print) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (Build.VERSION.SDK_INT < 31) {
            H();
        }
        this.R = getTitle().toString();
        V();
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
