package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
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
public class Report6_expenses extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, info.aalmoghalis.inventory.activity.a.b {
    public C0922Sv C;
    public ArrayAdapter E;
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public int l;
    public int n;
    public int p;
    public int k = 0;
    public TextView q = null;
    public AutoCompleteTextView t = null;
    public TextView u = null;
    public Spinner v = null;
    public TextView w = null;
    public TextView x = null;
    public int y = 0;
    public ImageView z = null;
    public ListView A = null;
    public Toolbar B = null;
    public List D = new ArrayList();
    public ImageButton F = null;
    public int G = 0;
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] I = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String J = "";
    public DatePickerDialog.OnDateSetListener K = new b();
    public DatePickerDialog.OnDateSetListener L = new c();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report6_expenses.this.l = i;
            Report6_expenses.this.n = i2;
            Report6_expenses.this.p = i3;
            try {
                String str = Report6_expenses.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report6_expenses.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report6_expenses.this.p));
                Locale locale = Locale.ENGLISH;
                Report6_expenses.this.w.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report6_expenses.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements DatePickerDialog.OnDateSetListener {
        public c() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report6_expenses.this.l = i;
            Report6_expenses.this.n = i2;
            Report6_expenses.this.p = i3;
            try {
                String str = Report6_expenses.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report6_expenses.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report6_expenses.this.p));
                Locale locale = Locale.ENGLISH;
                Report6_expenses.this.x.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report6_expenses.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report6_expenses.this.showDialog(0);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report6_expenses.this.showDialog(4);
        }
    }

    public class f implements AdapterView.OnItemClickListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Report6_expenses.this.t.setText(adapterView.getItemAtPosition(i).toString());
            Report6_expenses.this.L();
        }
    }

    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Report6_expenses.this.t.showDropDown();
            return false;
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report6_expenses.this.J();
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public i(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Report6_expenses.this.t.setText(adapterView.getItemAtPosition(i).toString());
            Report6_expenses.this.t.setError(null);
            this.a.dismiss();
            Report6_expenses.this.t.dismissDropDown();
            Report6_expenses.this.L();
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public j(TextView textView, ImageView imageView) {
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
                Report6_expenses.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Report6_expenses.this.j = 0;
                Report6_expenses.this.L();
            } catch (Exception unused) {
                Toast.makeText(Report6_expenses.this.getApplicationContext(), Report6_expenses.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public l(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Report6_expenses.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Report6_expenses.this.j = 0;
                    Report6_expenses.this.L();
                }
            } catch (Exception unused) {
                Toast.makeText(Report6_expenses.this.getApplicationContext(), Report6_expenses.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public void J() {
        Dialog dialog = new Dialog(this.g);
        LinearLayout linearLayout = new LinearLayout(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.H);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new i(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(this.q.getText());
        dialog.show();
    }

    public void K(Cursor cursor) {
        cursor.getCount();
        this.D.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.D.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f1")), cursor.getString(cursor.getColumnIndex("f2")), this.i.P7(cursor.getString(cursor.getColumnIndex("f7"))), cursor.getString(cursor.getColumnIndex("f4")), cursor.getString(cursor.getColumnIndex("f3")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f5")), cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row2, this.D, 3);
        this.C = c0922Sv;
        c0922Sv.l.clear();
        this.C.notifyDataSetChanged();
        this.A.setAdapter((ListAdapter) this.C);
    }

    public void L() {
        boolean zIsEmpty = this.w.getText().toString().isEmpty();
        String string = CSS.Value.PERCENTAGE;
        String string2 = zIsEmpty ? CSS.Value.PERCENTAGE : this.w.getText().toString();
        String string3 = this.x.getText().toString().isEmpty() ? CSS.Value.PERCENTAGE : this.x.getText().toString();
        if (!this.t.getText().toString().isEmpty()) {
            string = this.t.getText().toString();
        }
        K(this.i.K5(this.v.getSelectedItemPosition() + 1, string2, string3, string));
    }

    public void M() {
        Cursor cursorY8 = this.i.y8(this.v.getSelectedItemPosition() + 1);
        this.H = new String[cursorY8.getCount()];
        if (cursorY8.moveToFirst()) {
            int i2 = 0;
            do {
                this.H[i2] = cursorY8.getString(cursorY8.getColumnIndex("_id"));
                i2++;
            } while (cursorY8.moveToNext());
        }
        cursorY8.close();
        this.E = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.H);
        this.t.setThreshold(1);
        this.t.setAdapter(this.E);
    }

    public void N(String str, String str2) {
    }

    public void O() {
        this.t = (AutoCompleteTextView) findViewById(R.id.tr_name);
        this.q = (TextView) findViewById(R.id.tr_name_hdr);
        this.v = (Spinner) findViewById(R.id.pay_type);
        this.v.setAdapter((SpinnerAdapter) new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.i.V7()));
        this.v.setOnItemSelectedListener(this);
        this.w = (TextView) findViewById(R.id.f_date);
        this.x = (TextView) findViewById(R.id.t_date);
        this.z = (ImageView) findViewById(R.id.tr_name_add);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.l = calendar.get(1);
        this.n = calendar.get(2);
        this.p = calendar.get(5);
        this.w.setOnClickListener(new d());
        this.x.setOnClickListener(new e());
        this.t.setOnItemClickListener(new f());
        this.t.setOnTouchListener(new g());
        this.E = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.H);
        this.t.setThreshold(1);
        this.t.setAdapter(this.E);
        this.z.setOnClickListener(new h());
    }

    public void P() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        TextView textView5 = (TextView) findViewById(R.id.f5);
        TextView textView6 = (TextView) findViewById(R.id.f6);
        TextView textView7 = (TextView) findViewById(R.id.f7);
        TextView textView8 = (TextView) findViewById(R.id.f8);
        textView4.setVisibility(8);
        textView8.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.weight = 40.0f;
        textView.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams2.weight = 40.0f;
        textView2.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
        layoutParams3.weight = 40.0f;
        textView3.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) textView5.getLayoutParams();
        layoutParams4.weight = 40.0f;
        textView5.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) textView6.getLayoutParams();
        layoutParams5.weight = 40.0f;
        textView6.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) textView6.getLayoutParams();
        layoutParams6.weight = 40.0f;
        textView7.setLayoutParams(layoutParams6);
        textView.setText(getString(R.string.date));
        textView2.setText(getString(R.string.name));
        textView5.setText(getString(R.string.pay_type_hdr));
        textView7.setText((CharSequence) null);
        textView6.setText(R.string.tr_pay_cat_hdr);
        textView3.setText(getString(R.string.tr_amount));
    }

    public void Q(boolean z) {
    }

    public void btn_add(View view) {
        int i2 = this.y;
        super.x(i2 - 1, this.i.V8(i2));
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.J = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new l(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new a());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        N(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString());
    }

    public void btn_show(View view) {
        L();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new j(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new k());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.J.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.J + "'");
            }
            this.J = "";
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
        setContentView(R.layout.data_listview_with_inp2);
        this.A = (ListView) findViewById(R.id.list_items);
        this.A.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.A.setChoiceMode(2);
        this.i = new Z00(this.h, this);
        P();
        O();
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                int i2 = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.y = i2;
                if (i2 == 2) {
                    setTitle(getString(R.string.report4));
                } else if (i2 == 1) {
                    setTitle(getString(R.string.report5));
                } else if (i2 == 3) {
                    setTitle(getResources().getStringArray(R.array.titles2)[5]);
                }
            }
        } catch (Exception unused) {
        }
        M();
        this.E = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.H);
        Q(true);
        L();
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.K, this.l, this.n, this.p);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.L, this.l, this.n, this.p);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        K(this.i.L2());
        Q(true);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i2, long j2) {
        adapterView.getItemAtPosition(i2).toString();
        int i3 = i2 + 1;
        Log.d("position=", String.valueOf(i2));
        this.t.setText((CharSequence) null);
        if (i3 == 1) {
            this.q.setText(getString(R.string.supp));
            M();
            L();
        } else if (i3 == 2) {
            this.q.setText(getString(R.string.payee));
            M();
            L();
        } else {
            this.q.setText(getString(R.string.payer));
            M();
            L();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.add) {
            return super.onOptionsItemSelected(menuItem);
        }
        int i2 = this.y;
        super.x(i2 - 1, this.i.V8(i2));
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
