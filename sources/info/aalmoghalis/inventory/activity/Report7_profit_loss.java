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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Report7_profit_loss extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public TextView A;
    public TextView B;
    public TextView C;
    public ArrayAdapter E;
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public int l;
    public int n;
    public int p;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;
    public int k = 0;
    public ListView q = null;
    public Toolbar t = null;
    public TextView u = null;
    public TextView v = null;
    public List D = new ArrayList();
    public ImageButton F = null;
    public int G = 0;
    public String[] H = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] I = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String J = "";
    public DatePickerDialog.OnDateSetListener K = new a();
    public DatePickerDialog.OnDateSetListener L = new b();

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report7_profit_loss.this.l = i;
            Report7_profit_loss.this.n = i2;
            Report7_profit_loss.this.p = i3;
            try {
                String str = Report7_profit_loss.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report7_profit_loss.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report7_profit_loss.this.p));
                Locale locale = Locale.ENGLISH;
                Report7_profit_loss.this.u.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report7_profit_loss.this.J();
            } catch (Exception unused) {
            }
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report7_profit_loss.this.l = i;
            Report7_profit_loss.this.n = i2;
            Report7_profit_loss.this.p = i3;
            try {
                String str = Report7_profit_loss.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report7_profit_loss.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report7_profit_loss.this.p));
                Locale locale = Locale.ENGLISH;
                Report7_profit_loss.this.v.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report7_profit_loss.this.J();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report7_profit_loss.this.showDialog(0);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report7_profit_loss.this.showDialog(4);
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
                Report7_profit_loss.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Report7_profit_loss.this.j = 0;
                Report7_profit_loss.this.J();
            } catch (Exception unused) {
                Toast.makeText(Report7_profit_loss.this.getApplicationContext(), Report7_profit_loss.this.getString(R.string.sql_error), 1);
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

    public class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public g(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Report7_profit_loss.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Report7_profit_loss.this.j = 0;
                    Report7_profit_loss.this.J();
                }
            } catch (Exception unused) {
                Toast.makeText(Report7_profit_loss.this.getApplicationContext(), Report7_profit_loss.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void I(Cursor cursor) {
        int count = cursor.getCount();
        this.D.clear();
        Log.d("Cursor_cnt=", String.valueOf(count));
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.w.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f1"))));
            this.x.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f2"))));
            this.y.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))));
            this.z.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f4"))));
            this.A.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f5"))));
            this.B.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f6"))));
            this.C.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f7"))));
            cursor.moveToNext();
        }
        cursor.close();
    }

    public void J() {
        boolean zIsEmpty = this.u.getText().toString().isEmpty();
        String string = CSS.Value.PERCENTAGE;
        String string2 = zIsEmpty ? CSS.Value.PERCENTAGE : this.u.getText().toString();
        if (!this.v.getText().toString().isEmpty()) {
            string = this.v.getText().toString();
        }
        I(this.i.W7(string2, string));
    }

    public void K() {
        Cursor cursorM2 = this.i.M2();
        this.H = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i = 0;
            do {
                this.H[i] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i++;
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
        this.u.setOnClickListener(new c());
        this.v.setOnClickListener(new d());
    }

    public void N() {
        this.w = (TextView) findViewById(R.id.f1);
        this.x = (TextView) findViewById(R.id.f2);
        this.y = (TextView) findViewById(R.id.f3);
        this.z = (TextView) findViewById(R.id.f4);
        this.A = (TextView) findViewById(R.id.f5);
        this.B = (TextView) findViewById(R.id.f6);
        this.C = (TextView) findViewById(R.id.f7);
    }

    public void O(boolean z) {
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new g(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new h());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        L(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString());
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

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.J.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.J + "'");
            }
            this.J = "";
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
        setContentView(R.layout.data_listview_with_inp6);
        setTitle(getString(R.string.report7));
        this.i = new Z00(this.h, this);
        N();
        M();
        K();
        this.E = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.H);
        O(true);
        J();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(this, this.K, this.l, this.n, this.p);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.L, this.l, this.n, this.p);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        I(this.i.L2());
        O(true);
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
