package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
public class Report2_supp_balance extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public int l;
    public int n;
    public int p;
    public C0922Sv w;
    public ArrayAdapter y;
    public int k = 0;
    public ListView q = null;
    public Toolbar t = null;
    public TextView u = null;
    public TextView v = null;
    public List x = new ArrayList();
    public ImageButton z = null;
    public int A = 0;
    public String[] B = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] C = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String D = "";
    public DatePickerDialog.OnDateSetListener E = new a();
    public DatePickerDialog.OnDateSetListener F = new b();

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report2_supp_balance.this.l = i;
            Report2_supp_balance.this.n = i2;
            Report2_supp_balance.this.p = i3;
            try {
                String str = Report2_supp_balance.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report2_supp_balance.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report2_supp_balance.this.p));
                Locale locale = Locale.ENGLISH;
                Report2_supp_balance.this.u.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report2_supp_balance.this.J();
            } catch (Exception unused) {
            }
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report2_supp_balance.this.l = i;
            Report2_supp_balance.this.n = i2;
            Report2_supp_balance.this.p = i3;
            try {
                String str = Report2_supp_balance.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report2_supp_balance.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report2_supp_balance.this.p));
                Locale locale = Locale.ENGLISH;
                Report2_supp_balance.this.v.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report2_supp_balance.this.J();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String string = ((TextView) view.findViewById(R.id.f1)).getText().toString();
            Intent intent = new Intent(view.getContext(), (Class<?>) supp_balance_det.class);
            intent.putExtra("supp_name", string);
            Report2_supp_balance.this.startActivity(intent);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report2_supp_balance.this.showDialog(0);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report2_supp_balance.this.showDialog(4);
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public f(TextView textView, ImageView imageView) {
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
                Report2_supp_balance.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Report2_supp_balance.this.j = 0;
                Report2_supp_balance.this.J();
            } catch (Exception unused) {
                Toast.makeText(Report2_supp_balance.this.getApplicationContext(), Report2_supp_balance.this.getString(R.string.sql_error), 1);
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

    public class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public h(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Report2_supp_balance.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Report2_supp_balance.this.j = 0;
                    Report2_supp_balance.this.J();
                }
            } catch (Exception unused) {
                Toast.makeText(Report2_supp_balance.this.getApplicationContext(), Report2_supp_balance.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void I(Cursor cursor) {
        cursor.getCount();
        this.x.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.x.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f1")), this.i.P7(cursor.getString(cursor.getColumnIndex("f2"))) + " " + getString(R.string.gm), this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))) + " " + getString(R.string.gm), cursor.getString(cursor.getColumnIndex("f4")), this.i.P7(cursor.getString(cursor.getColumnIndex("f5"))), this.i.P7(cursor.getString(cursor.getColumnIndex("f6"))) + " " + getString(R.string.gm), cursor.getString(cursor.getColumnIndex("f7")), cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row3, this.x, 3);
        this.w = c0922Sv;
        c0922Sv.l.clear();
        this.w.notifyDataSetChanged();
        this.q.setAdapter((ListAdapter) this.w);
    }

    public void J() {
        boolean zIsEmpty = this.u.getText().toString().isEmpty();
        String string = CSS.Value.PERCENTAGE;
        String string2 = zIsEmpty ? CSS.Value.PERCENTAGE : this.u.getText().toString();
        if (!this.v.getText().toString().isEmpty()) {
            string = this.v.getText().toString();
        }
        I(this.i.u8(string2, string));
    }

    public void K() {
        Cursor cursorM2 = this.i.M2();
        this.B = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i2 = 0;
            do {
                this.B[i2] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i2++;
            } while (cursorM2.moveToNext());
        }
        cursorM2.close();
    }

    public void L(String str, String str2) {
    }

    public void M() {
        this.u = (TextView) findViewById(R.id.f_date);
        this.v = (TextView) findViewById(R.id.t_date);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.l = calendar.get(1);
        this.n = calendar.get(2);
        this.p = calendar.get(5);
        this.u.setOnClickListener(new d());
        this.v.setOnClickListener(new e());
    }

    public void N() {
        TextView textView = (TextView) findViewById(R.id.f1);
        TextView textView2 = (TextView) findViewById(R.id.f2);
        TextView textView3 = (TextView) findViewById(R.id.f3);
        TextView textView4 = (TextView) findViewById(R.id.f4);
        TextView textView5 = (TextView) findViewById(R.id.f5);
        TextView textView6 = (TextView) findViewById(R.id.f6);
        TextView textView7 = (TextView) findViewById(R.id.f7);
        TextView textView8 = (TextView) findViewById(R.id.f8);
        ImageView imageView = (ImageView) findViewById(R.id.more);
        textView4.setVisibility(8);
        textView8.setVisibility(8);
        imageView.setVisibility(4);
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
        textView.setText(getString(R.string.name));
        textView2.setText(getString(R.string.w_21));
        textView3.setText(getString(R.string.w_18));
        textView4.setText((CharSequence) null);
        textView5.setText(getString(R.string.tr_price_dii));
        textView6.setText(getString(R.string.w_24));
        textView7.setText((CharSequence) null);
        textView8.setText((CharSequence) null);
    }

    public void O(boolean z) {
    }

    public void btn_add(View view) {
        super.x(4, this.i.V8(5));
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.D = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new h(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new i());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        L(((TextView) linearLayout.findViewById(R.id.f1)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new f(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new g());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.D.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.D + "'");
            }
            this.D = "";
            J();
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
        setContentView(R.layout.data_listview_with_inp9);
        setTitle(getResources().getStringArray(R.array.titles2)[1]);
        this.q = (ListView) findViewById(R.id.list_items);
        this.q.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        N();
        M();
        this.q.setOnItemClickListener(new c());
        K();
        this.y = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.B);
        O(true);
        J();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.E, this.l, this.n, this.p);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.F, this.l, this.n, this.p);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        I(this.i.L2());
        O(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.add) {
            return super.onOptionsItemSelected(menuItem);
        }
        super.x(4, this.i.V8(5));
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
