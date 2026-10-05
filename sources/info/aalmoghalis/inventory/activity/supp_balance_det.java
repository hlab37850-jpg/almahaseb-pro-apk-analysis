package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
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
import defpackage.C0922Sv;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class supp_balance_det extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public SQLiteDatabase h;
    public Z00 i;
    public String j;
    public int k;
    public int n;
    public int p;
    public int q;
    public C0922Sv v;
    public ArrayAdapter x;
    public double l = 0.0d;
    public ListView t = null;
    public Toolbar u = null;
    public List w = new ArrayList();
    public ImageButton y = null;
    public int z = 0;
    public String[] A = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] B = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String C = "";
    public DatePickerDialog.OnDateSetListener D = new e();
    public DatePickerDialog.OnDateSetListener E = new f();

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
                supp_balance_det.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                supp_balance_det.this.k = 0;
                supp_balance_det.this.H();
            } catch (Exception unused) {
                Toast.makeText(supp_balance_det.this.getApplicationContext(), supp_balance_det.this.getString(R.string.sql_error), 1);
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

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public c(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    supp_balance_det.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    supp_balance_det.this.k = 0;
                    supp_balance_det.this.H();
                }
            } catch (Exception unused) {
                Toast.makeText(supp_balance_det.this.getApplicationContext(), supp_balance_det.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class e implements DatePickerDialog.OnDateSetListener {
        public e() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            supp_balance_det.this.n = i;
            supp_balance_det.this.p = i2;
            supp_balance_det.this.q = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(supp_balance_det.this.q)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(supp_balance_det.this.p + 1)) + "-" + supp_balance_det.this.n;
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
                new SimpleDateFormat("dd-MM-yyyy", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public class f implements DatePickerDialog.OnDateSetListener {
        public f() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            supp_balance_det.this.n = i;
            supp_balance_det.this.p = i2;
            supp_balance_det.this.q = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(supp_balance_det.this.q)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(supp_balance_det.this.p + 1)) + "-" + supp_balance_det.this.n;
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
                new SimpleDateFormat("dd-MM-yyyy", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public void G(Cursor cursor) {
        Log.d("Cursor_CNT=", String.valueOf(cursor.getCount()));
        this.w.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.w.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f1")), this.i.P7(cursor.getString(cursor.getColumnIndex("f2"))) + " " + getString(R.string.gm), this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))) + " " + getString(R.string.gm), cursor.getString(cursor.getColumnIndex("f4")), this.i.P7(cursor.getString(cursor.getColumnIndex("f5"))), this.i.P7(cursor.getString(cursor.getColumnIndex("f6"))) + " " + getString(R.string.gm), cursor.getString(cursor.getColumnIndex("f7")), cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row2, this.w, 3);
        this.v = c0922Sv;
        c0922Sv.l.clear();
        this.v.notifyDataSetChanged();
        this.t.setAdapter((ListAdapter) this.v);
    }

    public void H() {
        G(this.i.t8(this.j));
    }

    public void I() {
        Cursor cursorM2 = this.i.M2();
        this.A = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i = 0;
            do {
                this.A[i] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i++;
            } while (cursorM2.moveToNext());
        }
        cursorM2.close();
    }

    public void J(String str, String str2) {
    }

    public void K() {
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
        textView2.setText(getString(R.string.w_21));
        textView3.setText(getString(R.string.w_18));
        textView4.setText((CharSequence) null);
        textView5.setText(getString(R.string.tr_price_dii));
        textView6.setText(getString(R.string.w_24));
        textView7.setText((CharSequence) null);
        textView8.setText((CharSequence) null);
    }

    public void L(boolean z) {
    }

    public void btn_add(View view) {
        J(this.j, String.valueOf(this.l).replace(",", ""));
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.C = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new c(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new d());
        builder.create().show();
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

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.C.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.C + "'");
            }
            this.C = "";
            H();
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
        setContentView(R.layout.data_listview2);
        this.t = (ListView) findViewById(R.id.list_items);
        this.t.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        K();
        try {
            if (getIntent().getStringExtra("supp_name") != null) {
                this.j = getIntent().getStringExtra("supp_name");
                setTitle(getString(R.string.bal_det) + this.j);
            }
        } catch (Exception unused) {
        }
        I();
        this.x = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.A);
        L(true);
        H();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(this, this.D, this.n, this.p, this.q);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.E, this.n, this.p, this.q);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        G(this.i.L2());
        L(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.add) {
            return true;
        }
        J(this.j, String.valueOf(this.l).replace(",", ""));
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
