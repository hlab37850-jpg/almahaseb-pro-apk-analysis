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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
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
public class Report8_item_movement extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
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
    public RadioGroup B = null;
    public String C = "";
    public String D = "";
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] F = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String G = "";
    public DatePickerDialog.OnDateSetListener H = new a();
    public DatePickerDialog.OnDateSetListener I = new b();

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report8_item_movement.this.l = i;
            Report8_item_movement.this.n = i2;
            Report8_item_movement.this.p = i3;
            try {
                String str = Report8_item_movement.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report8_item_movement.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report8_item_movement.this.p));
                Locale locale = Locale.ENGLISH;
                Report8_item_movement.this.u.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report8_item_movement.this.J();
            } catch (Exception unused) {
            }
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Report8_item_movement.this.l = i;
            Report8_item_movement.this.n = i2;
            Report8_item_movement.this.p = i3;
            try {
                String str = Report8_item_movement.this.l + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report8_item_movement.this.n + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Report8_item_movement.this.p));
                Locale locale = Locale.ENGLISH;
                Report8_item_movement.this.v.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Report8_item_movement.this.J();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements RadioGroup.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            Report8_item_movement.this.J();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report8_item_movement.this.showDialog(0);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Report8_item_movement.this.showDialog(4);
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
                Report8_item_movement.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Report8_item_movement.this.j = 0;
                Report8_item_movement.this.J();
            } catch (Exception unused) {
                Toast.makeText(Report8_item_movement.this.getApplicationContext(), Report8_item_movement.this.getString(R.string.sql_error), 1);
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
                    Report8_item_movement.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Report8_item_movement.this.j = 0;
                    Report8_item_movement.this.J();
                }
            } catch (Exception unused) {
                Toast.makeText(Report8_item_movement.this.getApplicationContext(), Report8_item_movement.this.getString(R.string.sql_error), 1);
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
        String str;
        cursor.getCount();
        this.x.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            List list = this.x;
            String string = cursor.getString(cursor.getColumnIndex("_id"));
            if (cursor.getString(cursor.getColumnIndex("f1")).equals(cursor.getString(cursor.getColumnIndex("f2")))) {
                str = cursor.getString(cursor.getColumnIndex("f1")) + " " + cursor.getString(cursor.getColumnIndex("f5"));
            } else {
                str = cursor.getString(cursor.getColumnIndex("f1")) + " " + cursor.getString(cursor.getColumnIndex("f5")) + " - " + cursor.getString(cursor.getColumnIndex("f2"));
            }
            String str2 = str;
            list.add(new C4145vh(string, str2, this.i.P7(cursor.getString(cursor.getColumnIndex("f3"))) + O(), this.i.P7(cursor.getString(cursor.getColumnIndex("f6"))) + O(), cursor.getString(cursor.getColumnIndex("f4")), "", this.i.P7(cursor.getString(cursor.getColumnIndex("f7"))) + O(), "", cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row2, this.x, 3);
        this.w = c0922Sv;
        c0922Sv.l.clear();
        this.w.notifyDataSetChanged();
        this.q.setAdapter((ListAdapter) this.w);
    }

    public void J() {
        boolean zIsEmpty = this.u.getText().toString().isEmpty();
        String str = CSS.Value.PERCENTAGE;
        String string = zIsEmpty ? CSS.Value.PERCENTAGE : this.u.getText().toString();
        String string2 = this.v.getText().toString().isEmpty() ? CSS.Value.PERCENTAGE : this.v.getText().toString();
        String str2 = this.B.getCheckedRadioButtonId() == R.id.r1 ? "1" : "2";
        if (!this.D.equals("")) {
            str = this.D;
        }
        I(this.i.H6(str2, string, string2, str));
    }

    public void K() {
        Cursor cursorM2 = this.i.M2();
        this.E = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i2 = 0;
            do {
                this.E[i2] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
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
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup_rep_type);
        this.B = radioGroup;
        radioGroup.setOnCheckedChangeListener(new c());
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
        textView2.setText(getString(R.string.bal_in));
        textView4.setText((CharSequence) null);
        textView5.setText((CharSequence) null);
        textView7.setText((CharSequence) null);
        textView3.setText(getString(R.string.bal_net));
        textView6.setText(R.string.bal_out);
        textView8.setText((CharSequence) null);
    }

    public String O() {
        if (!(this.B.getCheckedRadioButtonId() == R.id.r1 ? "1" : "2").equals("2")) {
            return "";
        }
        return " " + getString(R.string.gm);
    }

    public void P(boolean z) {
    }

    public void btn_add(View view) {
        super.w();
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.G = textView.getText().toString();
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new f(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new g());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.G.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.G + "'");
            }
            this.G = "";
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
        setContentView(R.layout.data_listview_with_inp8);
        setTitle(getResources().getStringArray(R.array.titles2)[0]);
        this.q = (ListView) findViewById(R.id.list_items);
        this.q.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.q.setChoiceMode(2);
        this.i = new Z00(this.h, this);
        N();
        M();
        try {
            if (getIntent().getStringExtra("item_name") != null) {
                String stringExtra = getIntent().getStringExtra("item_name");
                this.C = stringExtra;
                setTitle(stringExtra);
            }
        } catch (Exception unused) {
        }
        try {
            if (getIntent().getStringExtra("item_id") != null) {
                this.D = getIntent().getStringExtra("item_id");
            }
        } catch (Exception unused2) {
        }
        K();
        this.y = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.E);
        P(true);
        J();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.H, this.l, this.n, this.p);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.I, this.l, this.n, this.p);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        I(this.i.L2());
        P(true);
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
