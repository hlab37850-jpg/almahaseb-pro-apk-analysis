package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
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
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.timepicker.TimeModel;
import defpackage.AbstractC2242g10;
import defpackage.C0757Mv;
import defpackage.XF;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Cat_Det_List_edit extends BaseActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b {
    public SQLiteDatabase c;
    public Z00 d;
    public int e;
    public int g;
    public int h;
    public int i;
    public C0757Mv l;
    public SparseBooleanArray p;
    public ArrayAdapter q;
    public int f = 0;
    public ListView j = null;
    public Toolbar k = null;
    public List n = new ArrayList();
    public ImageButton t = null;
    public int u = 0;
    public String[] v = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] w = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String x = "";
    public DatePickerDialog.OnDateSetListener y = new b();
    public DatePickerDialog.OnDateSetListener z = new c();

    public class a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Cat_Det_List_edit$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0293a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0293a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Cat_Det_List_edit.this.D();
                } catch (Exception unused) {
                    Toast.makeText(Cat_Det_List_edit.this.getApplicationContext(), "SQL Error.", 1);
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

        public a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_delete /* 2131297039 */:
                    Cat_Det_List_edit.this.p = Cat_Det_List_edit.this.l.b();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Cat_Det_List_edit.this);
                    builder.setMessage(Cat_Det_List_edit.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Cat_Det_List_edit.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0293a());
                    builder.setNegativeButton(Cat_Det_List_edit.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB = Cat_Det_List_edit.this.l.b();
                    Cat_Det_List_edit cat_Det_List_edit = Cat_Det_List_edit.this;
                    cat_Det_List_edit.p = sparseBooleanArrayB;
                    cat_Det_List_edit.E();
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
            Cat_Det_List_edit.this.j.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Cat_Det_List_edit.this.l.i.clear();
            Cat_Det_List_edit.this.l.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Cat_Det_List_edit.this.j.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Cat_Det_List_edit.this.l.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Cat_Det_List_edit.this.j.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Cat_Det_List_edit.this.g = i;
            Cat_Det_List_edit.this.h = i2;
            Cat_Det_List_edit.this.i = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Cat_Det_List_edit.this.i)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Cat_Det_List_edit.this.h + 1)) + "-" + Cat_Det_List_edit.this.g;
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
                new SimpleDateFormat("dd-MM-yyyy", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public class c implements DatePickerDialog.OnDateSetListener {
        public c() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Cat_Det_List_edit.this.g = i;
            Cat_Det_List_edit.this.h = i2;
            Cat_Det_List_edit.this.i = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Cat_Det_List_edit.this.i)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Cat_Det_List_edit.this.h + 1)) + "-" + Cat_Det_List_edit.this.g;
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
                new SimpleDateFormat("dd-MM-yyyy", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public d(TextView textView, ImageView imageView) {
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
                Cat_Det_List_edit.this.d.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Cat_Det_List_edit.this.e = 0;
                Cat_Det_List_edit.this.G();
            } catch (Exception unused) {
                Toast.makeText(Cat_Det_List_edit.this.getApplicationContext(), Cat_Det_List_edit.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public f(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Cat_Det_List_edit.this.d.v0("delete from feeds  where page in (select b.name from categ a,pages b where a.id=b.cat_id and a.name='" + ((Object) this.a.getText()) + "')");
                    Cat_Det_List_edit.this.d.v0("delete from pages  where cat_id in (select id from categ where name='" + ((Object) this.a.getText()) + "')");
                    Cat_Det_List_edit.this.d.v0("delete from categ  where name='" + ((Object) this.a.getText()) + "'");
                    Cat_Det_List_edit.this.e = 0;
                    Cat_Det_List_edit.this.G();
                }
            } catch (Exception unused) {
                Toast.makeText(Cat_Det_List_edit.this.getApplicationContext(), Cat_Det_List_edit.this.getString(R.string.sql_error), 1);
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

    public class h implements SearchView.OnQueryTextListener {
        public h() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Cat_Det_List_edit.this.I(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public void D() {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            if (this.p.valueAt(size)) {
                XF item = this.l.getItem(this.p.keyAt(size));
                this.l.remove(item);
                this.d.v0("delete from pages where name='" + item.c() + "'");
            }
        }
        G();
        J(true);
    }

    public void E() {
        int size = this.p.size() - 1;
        if (this.p.valueAt(size)) {
            XF item = this.l.getItem(this.p.keyAt(size));
            J(false);
            this.e = Integer.parseInt(item.c().toString());
        }
    }

    public void F(Cursor cursor) {
        cursor.getCount();
        this.n.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            this.n.add(new XF(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("name")), "", "", cursor.getString(cursor.getColumnIndex("enable")), ""));
            cursor.moveToNext();
        }
        cursor.close();
        C0757Mv c0757Mv = new C0757Mv(this, R.layout.cat_det_row3, this.n);
        this.l = c0757Mv;
        c0757Mv.i.clear();
        this.l.notifyDataSetChanged();
        this.j.setAdapter((ListAdapter) this.l);
    }

    public void G() {
        F(this.d.L2());
    }

    public void H() {
        Cursor cursorM2 = this.d.M2();
        this.v = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i = 0;
            do {
                this.v[i] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i++;
            } while (cursorM2.moveToNext());
        }
        cursorM2.close();
    }

    public void I(String str) {
        this.l.getFilter().filter(str);
    }

    public void J(boolean z) {
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.x = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new f(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new g());
        builder.create().show();
    }

    public void btn_cus_save(View view) {
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
        builder.setPositiveButton(getString(R.string.confirm_yes), new d(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new e());
        builder.create().show();
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.x.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.d.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.x + "'");
            }
            this.x = "";
            G();
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.feed_activity2);
        setTitle(getString(R.string.categ_mng));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.k = toolbar;
        setSupportActionBar(toolbar);
        this.j = (ListView) findViewById(R.id.list_cus_det_edit);
        this.j.setChoiceMode(2);
        this.d = new Z00(this.c, this);
        new DateFormat();
        AbstractC2242g10.c(this, "golden.db", DateFormat.format("yyyyMMddkkmmss", new Date()).toString() + "-golden.db", "info.aalmoghalis.inventory");
        H();
        this.q = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.v);
        J(true);
        this.j.setChoiceMode(3);
        this.j.setMultiChoiceModeListener(new a());
        G();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 0) {
            return new DatePickerDialog(this, this.y, this.g, this.h, this.i);
        }
        if (i != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.z, this.g, this.h, this.i);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new h());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        F(this.d.L2());
        J(true);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
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
