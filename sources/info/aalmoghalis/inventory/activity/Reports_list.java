package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.timepicker.TimeModel;
import defpackage.C3874sM;
import defpackage.C4062ug;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Reports_list extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public ArrayAdapter L;
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public int l;
    public int n;
    public int p;
    public String[] q;
    public TypedArray t;
    public CharSequence u;
    public CharSequence v;
    public ListView w;
    public List x;
    public C4062ug y;
    public int k = 0;
    public ListView z = null;
    public Toolbar A = null;
    public TextView B = null;
    public TextView C = null;
    public List K = new ArrayList();
    public ImageButton M = null;
    public int N = 0;
    public String[] O = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] P = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String Q = "";
    public DatePickerDialog.OnDateSetListener R = new a();
    public DatePickerDialog.OnDateSetListener S = new b();

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Reports_list.this.l = i;
            Reports_list.this.n = i2;
            Reports_list.this.p = i3;
            try {
                String str = Reports_list.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Reports_list.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Reports_list.this.p));
                Locale locale = Locale.ENGLISH;
                Reports_list.this.B.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Reports_list.this.K();
            } catch (Exception unused) {
            }
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Reports_list.this.l = i;
            Reports_list.this.n = i2;
            Reports_list.this.p = i3;
            try {
                String str = Reports_list.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Reports_list.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Reports_list.this.p));
                Locale locale = Locale.ENGLISH;
                Reports_list.this.C.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Reports_list.this.K();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public c(TextView textView, ImageView imageView) {
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
                Reports_list.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Reports_list.this.j = 0;
                Reports_list.this.K();
            } catch (Exception unused) {
                Toast.makeText(Reports_list.this.getApplicationContext(), Reports_list.this.getString(R.string.sql_error), 1);
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

    public class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public e(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Reports_list.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Reports_list.this.j = 0;
                    Reports_list.this.K();
                }
            } catch (Exception unused) {
                Toast.makeText(Reports_list.this.getApplicationContext(), Reports_list.this.getString(R.string.sql_error), 1);
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

    public class g implements AdapterView.OnItemClickListener {
        public g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Reports_list.this.O(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i) {
        if (i == 0) {
            startActivity(new Intent(this, (Class<?>) Report8_item_movement.class));
            return;
        }
        if (i == 1) {
            startActivity(new Intent(this, (Class<?>) Report2_supp_balance.class));
            return;
        }
        if (i == 2) {
            Intent intent = new Intent(this, (Class<?>) Report4_purchases.class);
            intent.putExtra("TR_TYPE", "2");
            startActivity(intent);
        } else if (i == 3) {
            Intent intent2 = new Intent(this, (Class<?>) Report4_purchases.class);
            intent2.putExtra("TR_TYPE", "1");
            startActivity(intent2);
        } else if (i == 4) {
            startActivity(new Intent(this, (Class<?>) Report9_expenses_balance_daily.class));
        } else {
            if (i != 5) {
                return;
            }
            Intent intent3 = new Intent(this, (Class<?>) Report6_expenses.class);
            intent3.putExtra("TR_TYPE", "3");
            startActivity(intent3);
        }
    }

    public void J(Cursor cursor) {
        int count = cursor.getCount();
        this.K.clear();
        Log.d("Cursor_cnt=", String.valueOf(count));
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.D.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f1"))));
            this.E.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f2"))));
            this.F.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))));
            this.G.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f4"))));
            this.H.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f5"))));
            this.I.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f6"))));
            this.J.setText(this.i.P7(cursor.getString(cursor.getColumnIndex("f7"))));
            cursor.moveToNext();
        }
        cursor.close();
    }

    public void K() {
        CharSequence title = getTitle();
        this.u = title;
        this.v = title;
        this.q = getResources().getStringArray(R.array.titles2);
        this.t = getResources().obtainTypedArray(R.array.icons2);
        this.w = (ListView) findViewById(R.id.list_items);
        this.x = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = this.q;
            if (i >= strArr.length) {
                this.t.recycle();
                C4062ug c4062ug = new C4062ug(getApplicationContext(), this.x);
                this.y = c4062ug;
                this.w.setAdapter((ListAdapter) c4062ug);
                this.w.setOnItemClickListener(new g());
                return;
            }
            this.x.add(new C3874sM(strArr[i], this.t.getResourceId(i, -1)));
            i++;
        }
    }

    public void L() {
        Cursor cursorM2 = this.i.M2();
        this.O = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i = 0;
            do {
                this.O[i] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i++;
            } while (cursorM2.moveToNext());
        }
        cursorM2.close();
    }

    public void M(String str, String str2) {
    }

    public void N(boolean z) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.Q = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new e(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new f());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        M(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new c(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new d());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.Q.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.Q + "'");
            }
            this.Q = "";
            K();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview3);
        setTitle(getResources().getStringArray(R.array.titles)[4]);
        this.i = new Z00(this.h, this);
        L();
        this.L = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.O);
        N(true);
        K();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(this, this.R, this.l, this.n, this.p);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.S, this.l, this.n, this.p);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        J(this.i.L2());
        N(true);
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
