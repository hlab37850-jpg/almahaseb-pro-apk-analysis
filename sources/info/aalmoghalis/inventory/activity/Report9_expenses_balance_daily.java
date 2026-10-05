package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import defpackage.C0922Sv;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Report9_expenses_balance_daily extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public int A;
    public int B;
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public C0922Sv q;
    public int z;
    public double k = 0.0d;
    public ListView l = null;
    public Toolbar n = null;
    public TextView p = null;
    public List t = new ArrayList();
    public ImageButton u = null;
    public int v = 0;
    public String[] w = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] x = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String y = "";
    public int C = 0;
    public String D = CSS.Value.PERCENTAGE;
    public String E = CSS.Value.PERCENTAGE;
    public TextView F = null;
    public TextView G = null;
    public DatePickerDialog.OnDateSetListener H = new f();
    public DatePickerDialog.OnDateSetListener I = new g();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report9_expenses_balance_daily.this.showDialog(4);
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Report9_expenses_balance_daily report9_expenses_balance_daily = Report9_expenses_balance_daily.this;
                report9_expenses_balance_daily.C = 0;
                report9_expenses_balance_daily.K();
            } catch (Exception unused) {
            }
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public d(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Report9_expenses_balance_daily report9_expenses_balance_daily = Report9_expenses_balance_daily.this;
                report9_expenses_balance_daily.C = 1;
                if (report9_expenses_balance_daily.F.getText() == null) {
                    Report9_expenses_balance_daily.this.D = "";
                } else {
                    Report9_expenses_balance_daily report9_expenses_balance_daily2 = Report9_expenses_balance_daily.this;
                    report9_expenses_balance_daily2.D = report9_expenses_balance_daily2.F.getText().toString();
                }
                if (Report9_expenses_balance_daily.this.G.getText() == null) {
                    Report9_expenses_balance_daily.this.E = "";
                } else {
                    Report9_expenses_balance_daily report9_expenses_balance_daily3 = Report9_expenses_balance_daily.this;
                    report9_expenses_balance_daily3.E = report9_expenses_balance_daily3.G.getText().toString();
                }
                Report9_expenses_balance_daily.this.K();
            } catch (Exception unused) {
            }
            this.a.dismiss();
        }
    }

    public class e implements SearchView.OnQueryTextListener {
        public e() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            if (TextUtils.isEmpty(str)) {
                Report9_expenses_balance_daily.this.J(1);
            }
            Report9_expenses_balance_daily.this.P(str);
            if (!TextUtils.isEmpty(str)) {
                Report9_expenses_balance_daily.this.J(0);
            }
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            Report9_expenses_balance_daily.this.J(0);
            return false;
        }
    }

    public class f implements DatePickerDialog.OnDateSetListener {
        public f() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report9_expenses_balance_daily.this.z = i;
            Report9_expenses_balance_daily.this.A = i2;
            Report9_expenses_balance_daily.this.B = i3;
            try {
                String str = Report9_expenses_balance_daily.this.z + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report9_expenses_balance_daily.this.A + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report9_expenses_balance_daily.this.B));
                Locale locale = Locale.ENGLISH;
                Report9_expenses_balance_daily.this.F.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report9_expenses_balance_daily.this.K();
            } catch (Exception unused) {
            }
        }
    }

    public class g implements DatePickerDialog.OnDateSetListener {
        public g() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report9_expenses_balance_daily.this.z = i;
            Report9_expenses_balance_daily.this.A = i2;
            Report9_expenses_balance_daily.this.B = i3;
            try {
                String str = Report9_expenses_balance_daily.this.z + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report9_expenses_balance_daily.this.A + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report9_expenses_balance_daily.this.B));
                Locale locale = Locale.ENGLISH;
                Report9_expenses_balance_daily.this.G.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report9_expenses_balance_daily.this.K();
            } catch (Exception unused) {
            }
        }
    }

    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String string = ((TextView) view.findViewById(R.id.f1)).getText().toString();
            Intent intent = new Intent(view.getContext(), (Class<?>) Report9_expenses_balance_daily_det.class);
            intent.putExtra("date_", string);
            Report9_expenses_balance_daily.this.startActivity(intent);
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public i(TextView textView, ImageView imageView) {
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
                Report9_expenses_balance_daily.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Report9_expenses_balance_daily.this.j = 0;
                Report9_expenses_balance_daily.this.K();
            } catch (Exception unused) {
                Toast.makeText(Report9_expenses_balance_daily.this.getApplicationContext(), Report9_expenses_balance_daily.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public k(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Report9_expenses_balance_daily.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Report9_expenses_balance_daily.this.j = 0;
                    Report9_expenses_balance_daily.this.K();
                }
            } catch (Exception unused) {
                Toast.makeText(Report9_expenses_balance_daily.this.getApplicationContext(), Report9_expenses_balance_daily.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report9_expenses_balance_daily.this.showDialog(0);
        }
    }

    public void G() {
        try {
            this.C = 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.content_report_input3, (ViewGroup) null);
            builder.setView(viewInflate);
            this.F = (TextView) viewInflate.findViewById(R.id.f_date);
            this.G = (TextView) viewInflate.findViewById(R.id.t_date);
            this.F.setOnClickListener(new m());
            this.G.setOnClickListener(new a());
            builder.setPositiveButton(getString(R.string.btn_search), new b());
            builder.setNegativeButton(getString(R.string.btn_cancel), new c());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new d(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("adv_search_error=", e2.getMessage());
        }
    }

    public void H() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void I(Cursor cursor) {
        cursor.getCount();
        this.t.clear();
        this.k = 0.0d;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.k += Double.parseDouble(cursor.getString(cursor.getColumnIndex("f2"))) - Double.parseDouble(cursor.getString(cursor.getColumnIndex("f3")));
            this.t.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f1")), this.i.P7(cursor.getString(cursor.getColumnIndex("f2"))), this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))), this.i.P7(String.valueOf(this.k)), cursor.getString(cursor.getColumnIndex("f5")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f7")), cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        this.p.setText(this.i.P7(String.valueOf(this.k)));
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep4, this.t, 4);
        this.q = c0922Sv;
        c0922Sv.l.clear();
        this.q.notifyDataSetChanged();
        this.l.setAdapter((ListAdapter) this.q);
    }

    public void J(int i2) {
        try {
            if (i2 == 1) {
                this.p.setText(this.i.P7(String.valueOf(this.k)));
            } else {
                this.p.setText(this.i.P7(String.valueOf(L(this.q.e))));
            }
        } catch (Exception unused) {
        }
    }

    public void K() {
        int i2 = this.C;
        String str = CSS.Value.PERCENTAGE;
        if (i2 == 0) {
            I(this.i.G5(CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE));
            return;
        }
        this.D = this.D.isEmpty() ? CSS.Value.PERCENTAGE : this.D;
        if (!this.E.isEmpty()) {
            str = this.E;
        }
        this.E = str;
        I(this.i.G5(this.D, str));
    }

    public double L(List list) {
        double d2 = 0.0d;
        for (int size = list.size() - 1; size >= 0; size--) {
            d2 += Double.parseDouble(((C4145vh) list.get(size)).n().replaceAll(",", "")) - Double.parseDouble(((C4145vh) list.get(size)).o().replaceAll(",", ""));
        }
        return d2;
    }

    public void M(String str, String str2) {
    }

    public void N() {
        this.p = (TextView) findViewById(R.id.balance);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.z = calendar.get(1);
        this.A = calendar.get(2);
        this.B = calendar.get(5);
    }

    public void O() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        textView.setText(getString(R.string.date));
        textView2.setText(getString(R.string.debit));
        textView3.setText(getString(R.string.credit));
        textView4.setText(getString(R.string.net_tot));
    }

    public void P(String str) {
        this.q.getFilter().filter(str);
    }

    public void Q(boolean z) {
    }

    public void btn_add(View view) {
        startActivity(new Intent(view.getContext(), (Class<?>) Customer_Det_List_edit.class));
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.y = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new k(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new l());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        M(((TextView) linearLayout.findViewById(R.id.f1)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f3)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new i(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new j());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.y.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.y + "'");
            }
            this.y = "";
            K();
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
        setContentView(R.layout.data_listview_with_inp12);
        setTitle(getResources().getStringArray(R.array.action_3)[4]);
        this.l = (ListView) findViewById(R.id.list_items);
        this.l.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        O();
        N();
        this.l.setOnItemClickListener(new h());
        Q(true);
        K();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.H, this.z, this.A, this.B);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.I, this.z, this.A, this.B);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu != null) {
            menu.clear();
        }
        getMenuInflater().inflate(R.menu.menu_main3_group, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new e());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        I(this.i.L2());
        Q(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.print) {
            if (itemId == R.id.adv_search) {
                G();
                return true;
            }
            if (itemId != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            finish();
            return true;
        }
        H();
        String str = getResources().getStringArray(R.array.titles4)[4];
        Z00 z00 = this.i;
        z00.jb(this.l, z00.ic(getTitle().toString()), L(this.q.e), getString(R.string.date));
        this.i.ra(this.i.ic(getTitle().toString()) + ".pdf");
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
