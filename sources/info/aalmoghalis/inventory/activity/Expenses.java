package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
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
public class Expenses extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public ArrayAdapter A;
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public int n;
    public int p;
    public int q;
    public C0922Sv x;
    public SparseBooleanArray z;
    public int k = 0;
    public int l = 0;
    public ListView t = null;
    public Toolbar u = null;
    public TextView v = null;
    public TextView w = null;
    public List y = new ArrayList();
    public ImageButton B = null;
    public int C = 0;
    public String[] D = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public final Context F = this;
    public String G = "";
    public DatePickerDialog.OnDateSetListener H = new a();
    public DatePickerDialog.OnDateSetListener I = new b();

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Expenses.this.n = i;
            Expenses.this.p = i2;
            Expenses.this.q = i3;
            try {
                String str = Expenses.this.n + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Expenses.this.p + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Expenses.this.q));
                Locale locale = Locale.ENGLISH;
                Expenses.this.v.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Expenses.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Expenses.this.n = i;
            Expenses.this.p = i2;
            Expenses.this.q = i3;
            try {
                String str = Expenses.this.n + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Expenses.this.p + 1)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Expenses.this.q));
                Locale locale = Locale.ENGLISH;
                Expenses.this.w.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
                Expenses.this.L();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Expenses.this.N(((TextView) view.findViewById(R.id.id)).getText().toString(), ((TextView) view.findViewById(R.id.f5)).getText().toString());
        }
    }

    public class d implements AbsListView.MultiChoiceModeListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Expenses.this.I();
                } catch (Exception unused) {
                    Toast.makeText(Expenses.this.getApplicationContext(), "SQL Error.", 1);
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

        public d() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Expenses.this.z = Expenses.this.x.c();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Expenses.this);
                    builder.setMessage(Expenses.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Expenses.this.getString(R.string.confirm_yes), new a());
                    builder.setNegativeButton(Expenses.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC = Expenses.this.x.c();
                    Expenses expenses = Expenses.this;
                    expenses.z = sparseBooleanArrayC;
                    expenses.J();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Expenses.this.t.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Expenses.this.x.l.clear();
            Expenses.this.x.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Expenses.this.t.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Expenses.this.x.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Expenses.this.t.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Expenses.this.showDialog(0);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Expenses.this.showDialog(4);
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public g(TextView textView, ImageView imageView) {
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
                Expenses.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Expenses.this.j = 0;
                Expenses.this.L();
            } catch (Exception unused) {
                Toast.makeText(Expenses.this.getApplicationContext(), Expenses.this.getString(R.string.sql_error), 1);
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

    public class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public i(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Expenses.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Expenses.this.j = 0;
                    Expenses.this.L();
                }
            } catch (Exception unused) {
                Toast.makeText(Expenses.this.getApplicationContext(), Expenses.this.getString(R.string.sql_error), 1);
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

    public void I() {
        for (int size = this.z.size() - 1; size >= 0; size--) {
            if (this.z.valueAt(size)) {
                C4145vh item = this.x.getItem(this.z.keyAt(size));
                this.x.remove(item);
                this.i.v0("delete from transactions where id='" + item.v() + "'");
            }
        }
        L();
        Q(true);
    }

    public void J() {
        int size = this.z.size() - 1;
        if (this.z.valueAt(size)) {
            C4145vh item = this.x.getItem(this.z.keyAt(size));
            Q(false);
            this.j = Integer.parseInt(item.v().toString());
            N(item.v().toString(), item.q().toString());
        }
    }

    public void K(Cursor cursor) {
        cursor.getCount();
        this.y.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.y.add(new C4145vh(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("f1")), cursor.getString(cursor.getColumnIndex("f2")), this.i.P7(cursor.getString(cursor.getColumnIndex("f7"))), cursor.getString(cursor.getColumnIndex("f4")), cursor.getString(cursor.getColumnIndex("f3")), cursor.getString(cursor.getColumnIndex("f6")), cursor.getString(cursor.getColumnIndex("f5")), cursor.getString(cursor.getColumnIndex("f8"))));
            cursor.moveToNext();
        }
        cursor.close();
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row2, this.y, 3);
        this.x = c0922Sv;
        c0922Sv.l.clear();
        this.x.notifyDataSetChanged();
        this.t.setAdapter((ListAdapter) this.x);
    }

    public void L() {
        boolean zIsEmpty = this.v.getText().toString().isEmpty();
        String string = CSS.Value.PERCENTAGE;
        String string2 = zIsEmpty ? CSS.Value.PERCENTAGE : this.v.getText().toString();
        if (!this.w.getText().toString().isEmpty()) {
            string = this.w.getText().toString();
        }
        K(this.i.J5(string2, string));
    }

    public void M() {
        Cursor cursorM2 = this.i.M2();
        this.D = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i2 = 0;
            do {
                this.D[i2] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i2++;
            } while (cursorM2.moveToNext());
        }
        cursorM2.close();
    }

    public void N(String str, String str2) {
    }

    public void O() {
        this.v = (TextView) findViewById(R.id.f_date);
        this.w = (TextView) findViewById(R.id.t_date);
        Calendar calendar = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.n = calendar.get(1);
        this.p = calendar.get(2);
        this.q = calendar.get(5);
        this.v.setOnClickListener(new e());
        this.w.setOnClickListener(new f());
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
        int i2 = this.k;
        super.x(i2 - 1, this.i.V8(i2));
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new i(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new j());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        N(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString());
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new g(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new h());
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
            L();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.data_listview_with_inp5);
        setTitle(getResources().getStringArray(R.array.titles)[2]);
        this.t = (ListView) findViewById(R.id.list_items);
        this.t.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.i = new Z00(this.h, this);
        this.t.setOnItemClickListener(new c());
        P();
        O();
        try {
            if (getIntent().getStringExtra("TR_TYPE") != null) {
                this.k = Integer.parseInt(getIntent().getStringExtra("TR_TYPE"));
            }
        } catch (Exception unused) {
        }
        M();
        this.A = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.D);
        Q(true);
        this.t.setChoiceMode(3);
        this.t.setMultiChoiceModeListener(new d());
        L();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.H, this.n, this.p, this.q);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.I, this.n, this.p, this.q);
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

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.add) {
            return super.onOptionsItemSelected(menuItem);
        }
        Log.d("Add icon=", "Yes:" + this.k);
        int i2 = this.k;
        super.x(i2 + (-1), this.i.V8(i2));
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
