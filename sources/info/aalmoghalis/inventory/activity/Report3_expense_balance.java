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
public class Report3_expense_balance extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public int l;
    public int n;
    public int p;
    public C0922Sv u;
    public ArrayAdapter w;
    public int k = 0;
    public ListView q = null;
    public Toolbar t = null;
    public List v = new ArrayList();
    public ImageButton x = null;
    public int y = 0;
    public String[] z = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] A = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String B = "";
    public DatePickerDialog.OnDateSetListener C = new e();
    public DatePickerDialog.OnDateSetListener D = new f();

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
                Report3_expense_balance.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Report3_expense_balance.this.j = 0;
                Report3_expense_balance.this.H();
            } catch (Exception unused) {
                Toast.makeText(Report3_expense_balance.this.getApplicationContext(), Report3_expense_balance.this.getString(R.string.sql_error), 1);
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
                    Report3_expense_balance.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Report3_expense_balance.this.j = 0;
                    Report3_expense_balance.this.H();
                }
            } catch (Exception unused) {
                Toast.makeText(Report3_expense_balance.this.getApplicationContext(), Report3_expense_balance.this.getString(R.string.sql_error), 1);
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
            Report3_expense_balance.this.l = i;
            Report3_expense_balance.this.n = i2;
            Report3_expense_balance.this.p = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report3_expense_balance.this.p)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report3_expense_balance.this.n + 1)) + "-" + Report3_expense_balance.this.l;
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
            Report3_expense_balance.this.l = i;
            Report3_expense_balance.this.n = i2;
            Report3_expense_balance.this.p = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report3_expense_balance.this.p)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report3_expense_balance.this.n + 1)) + "-" + Report3_expense_balance.this.l;
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
                new SimpleDateFormat("dd-MM-yyyy", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public void G(Cursor cursor) {
        cursor.getCount();
        this.v.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.v.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f1")), cursor.getString(cursor.getColumnIndex("f2")), cursor.getString(cursor.getColumnIndex("f3")), cursor.getString(cursor.getColumnIndex("f4")), cursor.getString(cursor.getColumnIndex("f5"))));
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row, this.v, 2);
        this.u = c0922Sv;
        c0922Sv.l.clear();
        this.u.notifyDataSetChanged();
        this.q.setAdapter((ListAdapter) this.u);
    }

    public void H() {
        G(this.i.I5());
    }

    public void I() {
        Cursor cursorM2 = this.i.M2();
        this.z = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i = 0;
            do {
                this.z[i] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i++;
            } while (cursorM2.moveToNext());
        }
        cursorM2.close();
    }

    public void J(String str, String str2) {
    }

    public void K(boolean z) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.B = textView.getText().toString();
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
        J(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString());
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
            if (!this.B.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.B + "'");
            }
            this.B = "";
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
        setContentView(R.layout.data_listview);
        setTitle(getString(R.string.report3));
        ListView listView = (ListView) findViewById(R.id.list_items);
        this.q = listView;
        listView.setChoiceMode(2);
        this.i = new Z00(this.h, this);
        I();
        this.w = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.z);
        K(true);
        H();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(this, this.C, this.l, this.n, this.p);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.D, this.l, this.n, this.p);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        G(this.i.L2());
        K(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.add) {
            return true;
        }
        super.x(2, this.i.V8(3));
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
