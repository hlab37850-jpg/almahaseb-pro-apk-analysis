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
import android.widget.CompoundButton;
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
import androidx.appcompat.widget.SwitchCompat;
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
public class Report4_purchases extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public C0922Sv D;
    public ArrayAdapter F;
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
    public SwitchCompat v = null;
    public TextView w = null;
    public TextView x = null;
    public AppCompatCheckBox y = null;
    public int z = 0;
    public ImageView A = null;
    public ListView B = null;
    public Toolbar C = null;
    public List E = new ArrayList();
    public ImageButton G = null;
    public int H = 0;
    public String[] I = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] J = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String K = "";
    public DatePickerDialog.OnDateSetListener L = new d();
    public DatePickerDialog.OnDateSetListener M = new e();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public b(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Report4_purchases.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Report4_purchases.this.j = 0;
                    Report4_purchases.this.O();
                }
            } catch (Exception unused) {
                Toast.makeText(Report4_purchases.this.getApplicationContext(), Report4_purchases.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class d implements DatePickerDialog.OnDateSetListener {
        public d() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report4_purchases.this.l = i;
            Report4_purchases.this.n = i2;
            Report4_purchases.this.p = i3;
            try {
                String str = Report4_purchases.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report4_purchases.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report4_purchases.this.p));
                Locale locale = Locale.ENGLISH;
                Report4_purchases.this.w.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report4_purchases.this.y.setChecked(false);
                Report4_purchases.this.O();
            } catch (Exception unused) {
            }
        }
    }

    public class e implements DatePickerDialog.OnDateSetListener {
        public e() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report4_purchases.this.l = i;
            Report4_purchases.this.n = i2;
            Report4_purchases.this.p = i3;
            try {
                String str = Report4_purchases.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report4_purchases.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report4_purchases.this.p));
                Locale locale = Locale.ENGLISH;
                Report4_purchases.this.x.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report4_purchases.this.y.setChecked(false);
                Report4_purchases.this.O();
            } catch (Exception unused) {
            }
        }
    }

    public class f implements CompoundButton.OnCheckedChangeListener {
        public f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                Report4_purchases.this.O();
            } else {
                Report4_purchases report4_purchases = Report4_purchases.this;
                report4_purchases.N(report4_purchases.i.y6(report4_purchases.z, 0, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE));
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report4_purchases.this.showDialog(0);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report4_purchases.this.showDialog(4);
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Report4_purchases.this.t.setText(adapterView.getItemAtPosition(i).toString());
            Report4_purchases.this.y.setChecked(false);
            Report4_purchases.this.O();
        }
    }

    public class j implements View.OnTouchListener {
        public j() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Report4_purchases.this.t.showDropDown();
            return false;
        }
    }

    public class k implements CompoundButton.OnCheckedChangeListener {
        public k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Report4_purchases.this.y.setChecked(false);
            if (!((Report4_purchases.this.z == 2) & z)) {
                if (!((!z) & (Report4_purchases.this.z == 1))) {
                    Report4_purchases.this.q.setText(Report4_purchases.this.getString(R.string.cus));
                    Report4_purchases.this.P();
                    Report4_purchases.this.t.setText((CharSequence) null);
                    Report4_purchases.this.O();
                    return;
                }
            }
            Report4_purchases.this.q.setText(Report4_purchases.this.getString(R.string.supp));
            Report4_purchases.this.P();
            Report4_purchases.this.O();
            Report4_purchases.this.t.setText((CharSequence) null);
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report4_purchases.this.M();
        }
    }

    public class m implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public m(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Report4_purchases.this.t.setText(adapterView.getItemAtPosition(i).toString());
            Report4_purchases.this.y.setChecked(false);
            Report4_purchases.this.t.setError(null);
            this.a.dismiss();
            Report4_purchases.this.t.dismissDropDown();
            Report4_purchases.this.O();
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public n(TextView textView, ImageView imageView) {
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
                Report4_purchases.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Report4_purchases.this.j = 0;
                Report4_purchases.this.O();
            } catch (Exception unused) {
                Toast.makeText(Report4_purchases.this.getApplicationContext(), Report4_purchases.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public void M() {
        Dialog dialog = new Dialog(this.g);
        LinearLayout linearLayout = new LinearLayout(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.I);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new m(dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(this.q.getText());
        dialog.show();
    }

    public void N(Cursor cursor) {
        String str;
        cursor.getCount();
        this.E.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            List list = this.E;
            String string = cursor.getString(cursor.getColumnIndex("_id"));
            if (cursor.getString(cursor.getColumnIndex("f1")).equals(cursor.getString(cursor.getColumnIndex("f2")))) {
                str = cursor.getString(cursor.getColumnIndex("f1")) + " " + cursor.getString(cursor.getColumnIndex("f5"));
            } else {
                str = cursor.getString(cursor.getColumnIndex("f1")) + " " + cursor.getString(cursor.getColumnIndex("f5")) + " - " + cursor.getString(cursor.getColumnIndex("f2"));
            }
            String str2 = str;
            list.add(new C4145vh(string, str2, this.i.P7(cursor.getString(cursor.getColumnIndex("f6"))), this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))), cursor.getString(cursor.getColumnIndex("f4")), "", "", this.i.P7(cursor.getString(cursor.getColumnIndex("f7"))) + " " + getString(R.string.gm), cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row2, this.E, 3);
        this.D = c0922Sv;
        c0922Sv.l.clear();
        this.D.notifyDataSetChanged();
        this.B.setAdapter((ListAdapter) this.D);
    }

    public void O() {
        N(this.i.y6(this.z, this.v.isChecked() ? 1 : 2, this.w.getText().toString().isEmpty() ? CSS.Value.PERCENTAGE : this.w.getText().toString(), this.x.getText().toString().isEmpty() ? CSS.Value.PERCENTAGE : this.x.getText().toString(), this.t.getText().toString().isEmpty() ? CSS.Value.PERCENTAGE : this.t.getText().toString()));
    }

    public void P() {
        if (this.v.isChecked()) {
            this.u.setText(getString(R.string.item_status_new));
        } else {
            this.u.setText(getString(R.string.item_status_old));
        }
        Cursor cursorX8 = this.i.x8(this.v.isChecked(), this.z);
        this.I = new String[cursorX8.getCount()];
        if (cursorX8.moveToFirst()) {
            int i2 = 0;
            do {
                this.I[i2] = cursorX8.getString(cursorX8.getColumnIndex("_id"));
                i2++;
            } while (cursorX8.moveToNext());
        }
        cursorX8.close();
        this.F = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.I);
        this.t.setThreshold(1);
        this.t.setAdapter(this.F);
    }

    public void Q(String str, String str2) {
    }

    public void R() {
        this.t = (AutoCompleteTextView) findViewById(R.id.tr_name);
        this.q = (TextView) findViewById(R.id.tr_name_hdr);
        this.v = (SwitchCompat) findViewById(R.id.switch_compat);
        this.u = (TextView) findViewById(R.id.item_status_hdr);
        this.w = (TextView) findViewById(R.id.f_date);
        this.x = (TextView) findViewById(R.id.t_date);
        this.A = (ImageView) findViewById(R.id.tr_name_add);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.l = calendar.get(1);
        this.n = calendar.get(2);
        this.p = calendar.get(5);
        this.w.setOnClickListener(new g());
        this.x.setOnClickListener(new h());
        this.t.setOnItemClickListener(new i());
        this.t.setOnTouchListener(new j());
        this.v.setOnCheckedChangeListener(new k());
        this.F = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.I);
        this.t.setThreshold(1);
        this.t.setAdapter(this.F);
        this.A.setOnClickListener(new l());
    }

    public void S() {
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
        textView.setText(getString(R.string.item));
        textView2.setText(getString(R.string.tr_amount));
        textView3.setText(getString(R.string.qty));
        textView4.setText((CharSequence) null);
        textView5.setText((CharSequence) null);
        textView6.setText((CharSequence) null);
        textView7.setText(getString(R.string.weight));
    }

    public void T(boolean z) {
    }

    public void btn_add(View view) {
        int i2 = this.z;
        super.x(i2 - 1, this.i.V8(i2));
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.K = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new b(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new c());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        Q(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString());
    }

    public void btn_show(View view) {
        O();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new n(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new a());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.K.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.K + "'");
            }
            this.K = "";
            O();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00ec  */
    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_with_inp);
        this.B = (ListView) findViewById(R.id.list_items);
        this.B.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.B.setChoiceMode(2);
        this.i = new Z00(this.h, this);
        S();
        R();
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                int i2 = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
                this.z = i2;
                if (i2 == 2) {
                    setTitle(getResources().getStringArray(R.array.titles2)[2]);
                } else if (i2 == 1) {
                    setTitle(getResources().getStringArray(R.array.titles2)[3]);
                }
            }
        } catch (Exception unused) {
        }
        P();
        this.F = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.I);
        T(true);
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) findViewById(R.id.ch_show_all);
        this.y = appCompatCheckBox;
        appCompatCheckBox.setOnCheckedChangeListener(new f());
        if (this.y.isChecked()) {
            N(this.i.y6(this.z, 0, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE, CSS.Value.PERCENTAGE));
        } else {
            O();
        }
        if (!this.v.isChecked() || !(this.z == 2)) {
            if ((this.z == 1) && (this.v.isChecked() ^ true)) {
                this.q.setText(getString(R.string.supp));
                P();
            } else {
                this.q.setText(getString(R.string.cus));
                P();
            }
        } else {
            this.q.setText(getString(R.string.supp));
            P();
        }
        getWindow().setSoftInputMode(2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.L, this.l, this.n, this.p);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.M, this.l, this.n, this.p);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        N(this.i.L2());
        T(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.add) {
            return super.onOptionsItemSelected(menuItem);
        }
        int i2 = this.z;
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
