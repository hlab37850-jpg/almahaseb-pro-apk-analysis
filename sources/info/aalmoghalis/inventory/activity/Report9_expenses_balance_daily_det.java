package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import defpackage.C0922Sv;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Report9_expenses_balance_daily_det extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public ArrayAdapter A;
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public int l;
    public int n;
    public int p;
    public C0922Sv y;
    public double k = 0.0d;
    public String q = "";
    public ListView t = null;
    public Toolbar u = null;
    public TextView v = null;
    public TextView w = null;
    public TextView x = null;
    public List z = new ArrayList();
    public ImageButton B = null;
    public int C = 0;
    public String[] D = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String F = "";
    public DatePickerDialog.OnDateSetListener G = new b();
    public DatePickerDialog.OnDateSetListener H = new c();

    public class a implements SearchView.OnQueryTextListener {
        public a() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (TextUtils.isEmpty(str)) {
                Report9_expenses_balance_daily_det.this.K(1);
            }
            Log.d("text_change_1=", str + ":" + Report9_expenses_balance_daily_det.this.y.e.size());
            Report9_expenses_balance_daily_det.this.Q(str);
            Log.d("text_change_2=", str + ":" + Report9_expenses_balance_daily_det.this.y.e.size());
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Report9_expenses_balance_daily_det.this.K(0);
            return false;
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report9_expenses_balance_daily_det.this.l = i;
            Report9_expenses_balance_daily_det.this.n = i2;
            Report9_expenses_balance_daily_det.this.p = i3;
            try {
                String str = Report9_expenses_balance_daily_det.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report9_expenses_balance_daily_det.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report9_expenses_balance_daily_det.this.p));
                Locale locale = Locale.ENGLISH;
                Report9_expenses_balance_daily_det.this.v.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report9_expenses_balance_daily_det.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements DatePickerDialog.OnDateSetListener {
        public c() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report9_expenses_balance_daily_det.this.l = i;
            Report9_expenses_balance_daily_det.this.n = i2;
            Report9_expenses_balance_daily_det.this.p = i3;
            try {
                String str = Report9_expenses_balance_daily_det.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report9_expenses_balance_daily_det.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report9_expenses_balance_daily_det.this.p));
                Locale locale = Locale.ENGLISH;
                Report9_expenses_balance_daily_det.this.w.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report9_expenses_balance_daily_det.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public d(TextView textView, ImageView imageView) {
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
                Report9_expenses_balance_daily_det.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Report9_expenses_balance_daily_det.this.j = 0;
                Report9_expenses_balance_daily_det.this.L();
            } catch (Exception unused) {
                Toast.makeText(Report9_expenses_balance_daily_det.this.getApplicationContext(), Report9_expenses_balance_daily_det.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public f(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Report9_expenses_balance_daily_det.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Report9_expenses_balance_daily_det.this.j = 0;
                    Report9_expenses_balance_daily_det.this.L();
                }
            } catch (Exception unused) {
                Toast.makeText(Report9_expenses_balance_daily_det.this.getApplicationContext(), Report9_expenses_balance_daily_det.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void I() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void J(Cursor cursor) {
        cursor.getCount();
        this.z.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.k += Double.parseDouble(cursor.getString(cursor.getColumnIndex("f2"))) - Double.parseDouble(cursor.getString(cursor.getColumnIndex("f3")));
            this.z.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f1")), this.i.P7(cursor.getString(cursor.getColumnIndex("f2"))), this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))), this.i.P7(String.valueOf(this.k)), cursor.getString(cursor.getColumnIndex("f5")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        this.x.setText(this.i.P7(String.valueOf(this.k)));
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep4, this.z, 4);
        this.y = c0922Sv;
        c0922Sv.l.clear();
        this.y.notifyDataSetChanged();
        this.t.setAdapter((ListAdapter) this.y);
    }

    public void K(int i) {
        try {
            if (i == 1) {
                this.x.setText(this.i.P7(String.valueOf(this.k)));
            } else {
                this.x.setText(this.i.P7(String.valueOf(N(this.y.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void L() {
        J(this.i.H5(this.q));
    }

    public void M() {
        Cursor cursorM2 = this.i.M2();
        this.D = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i = 0;
            do {
                this.D[i] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i++;
            } while (cursorM2.moveToNext());
        }
        cursorM2.close();
    }

    public double N(List list) {
        double d2 = 0.0d;
        for (int size = list.size() - 1; size >= 0; size += -1) {
            d2 += Double.parseDouble(((C4145vh) list.get(size)).n().replaceAll(",", "")) - Double.parseDouble(((C4145vh) list.get(size)).o().replaceAll(",", ""));
            Log.d("net_bal=", ((C4145vh) list.get(size)).a() + ":" + list.size());
        }
        return d2;
    }

    public void O(String str, String str2) {
    }

    public void P() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        textView.setText(getString(R.string.name));
        textView2.setText(getString(R.string.debit));
        textView3.setText(getString(R.string.credit));
        textView4.setText(getString(R.string.net_tot));
    }

    public void Q(String str) {
        try {
            this.y.getFilter().filter(str);
        } catch (Exception unused) {
        }
    }

    public void R(boolean z) {
    }

    public void btn_add(View view) {
        super.x(2, this.i.V8(3));
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.F = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new f(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new g());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        O(((TextView) linearLayout.findViewById(R.id.f1)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f3)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new d(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new e());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.F.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.F + "'");
            }
            this.F = "";
            L();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_rep4);
        setTitle(getResources().getStringArray(R.array.titles2)[4]);
        this.t = (ListView) findViewById(R.id.list_items);
        this.t.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        P();
        this.x = (TextView) findViewById(R.id.balance);
        try {
            if (getIntent().getStringExtra("date_") != null) {
                this.q = getIntent().getStringExtra("date_");
                setTitle(getIntent().getStringExtra("date_"));
            }
        } catch (Exception unused) {
        }
        M();
        this.A = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.D);
        R(true);
        L();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(this, this.G, this.l, this.n, this.p);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.H, this.l, this.n, this.p);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new a());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        J(this.i.L2());
        R(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.print) {
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            finish();
            return true;
        }
        if (Build.VERSION.SDK_INT < 31) {
            I();
        }
        try {
            Z00 z00 = this.i;
            z00.jb(this.t, z00.ic(getTitle().toString()), N(this.y.e), getString(R.string.name));
            this.i.ra(this.i.ic(getTitle().toString()) + ".pdf");
        } catch (Exception unused) {
        }
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
