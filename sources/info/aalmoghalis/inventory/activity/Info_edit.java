package info.aalmoghalis.inventory.activity;

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
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import defpackage.AbstractC4371yX;
import defpackage.C0896Rv;
import defpackage.C4143vg;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Info_edit extends BaseActivity {
    public SparseBooleanArray A;
    public SQLiteDatabase d;
    public Z00 e;
    public C0896Rv y;
    public String c = Info_edit.class.getSimpleName();
    public double f = 0.0d;
    public int g = 0;
    public int h = 0;
    public AutoCompleteTextView i = null;
    public EditText j = null;
    public EditText k = null;
    public TextView l = null;
    public ImageView n = null;
    public TextView p = null;
    public TextView q = null;
    public TextView t = null;
    public TextView u = null;
    public Button v = null;
    public ListView w = null;
    public LinearLayout x = null;
    public ArrayList z = new ArrayList();
    public ImageButton B = null;
    public String[] C = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] D = {R.drawable.up, 1, R.drawable.down};
    public Toolbar E = null;
    public int F = -1;
    public String G = "";
    public String H = "";
    public String I = "";
    public String J = "";

    public class a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0296a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0296a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Info_edit.this.w();
                } catch (Exception unused) {
                    Toast.makeText(Info_edit.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayB = Info_edit.this.y.b();
                    Info_edit info_edit = Info_edit.this;
                    info_edit.A = sparseBooleanArrayB;
                    AlertDialog.Builder builder = new AlertDialog.Builder(info_edit);
                    builder.setMessage(Info_edit.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Info_edit.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0296a());
                    builder.setNegativeButton(Info_edit.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB2 = Info_edit.this.y.b();
                    Info_edit info_edit2 = Info_edit.this;
                    info_edit2.A = sparseBooleanArrayB2;
                    info_edit2.x();
                    actionMode.finish();
                    break;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar3, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Info_edit.this.w.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Info_edit.this.y.h.clear();
            Info_edit.this.y.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Info_edit.this.w.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Info_edit.this.y.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Info_edit.this.w.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
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
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AlertDialog b;

        public d(AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a)) {
                Info_edit.this.e.v0("insert into " + Info_edit.this.H + "  (name )  values( '" + this.a.getText().toString().trim() + "'  )");
                Info_edit.this.z();
                this.b.dismiss();
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
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AlertDialog c;

        public g(AutoCompleteTextView autoCompleteTextView, String str, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = str;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a)) {
                Info_edit.this.e.v0("update " + Info_edit.this.H + "  set name = '" + this.a.getText().toString().trim() + "'  where name='" + this.b + "'");
                Info_edit.this.z();
                this.c.dismiss();
            }
        }
    }

    private void B() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void C() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void A() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_info, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.info_name);
            autoCompleteTextView.setHint(this.G);
            autoCompleteTextView.requestFocus();
            C();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new b());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new c());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.I);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new d(autoCompleteTextView, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void D(String str) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_info, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.info_name);
            autoCompleteTextView.setHint(this.G);
            autoCompleteTextView.setText(str);
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.selectAll();
            C();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new e());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new f());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.J);
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new g(autoCompleteTextView, str, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void amount_add_btn(View view) {
        A();
    }

    public void no_result_btn(View view) {
        z();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.info_list);
        B();
        try {
            TextView textView = (TextView) findViewById(R.id.info_name);
            if (getIntent().getIntExtra("action_type", -1) != -1) {
                this.F = getIntent().getIntExtra("action_type", -1);
                setTitle(getIntent().getStringExtra("action_text"));
                int i = this.F;
                if (i == 0) {
                    this.G = getString(R.string.item_type);
                    this.H = "item_type";
                    this.I = getString(R.string.add_item_type);
                    this.J = getString(R.string.change_item_type);
                } else if (i == 5) {
                    this.G = getString(R.string.currency);
                    this.H = "currency";
                    this.I = getString(R.string.add_currency);
                    this.J = getString(R.string.change_currency);
                } else if (i == 6) {
                    this.G = getString(R.string.group);
                    this.H = "groups";
                    this.I = getString(R.string.validation_add_group);
                    this.J = getString(R.string.validation_add_group);
                }
            }
            textView.setText(this.G);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        this.w = (ListView) findViewById(R.id.list_data);
        this.w.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.w.setChoiceMode(2);
        Z00 z00 = new Z00(this.d, this);
        this.e = z00;
        z00.w0("PRAGMA foreign_keys = ON");
        z();
        this.w.setChoiceMode(3);
        this.w.setMultiChoiceModeListener(new a());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        z();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void w() {
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (this.A.valueAt(size)) {
                C4143vg item = this.y.getItem(this.A.keyAt(size));
                this.y.remove(item);
                this.e.v0("delete from " + this.H + " where id=" + item.i() + " and id<>0  ");
            }
        }
        z();
    }

    public void x() {
        int size = this.A.size() - 1;
        if (this.A.valueAt(size)) {
            D(this.y.getItem(this.A.keyAt(size)).j());
        }
    }

    public void y() {
        C0896Rv c0896Rv = new C0896Rv(this, R.layout.info_item, this.z);
        this.y = c0896Rv;
        c0896Rv.h.clear();
        this.y.notifyDataSetChanged();
        this.w.setAdapter((ListAdapter) this.y);
    }

    public void z() {
        Cursor cursorZ5 = this.e.Z5(this.H);
        Log.d("recCount=", this.H + ":" + cursorZ5.getCount());
        this.f = 0.0d;
        this.z.clear();
        cursorZ5.moveToFirst();
        while (!cursorZ5.isAfterLast()) {
            this.z.add(new C4143vg(cursorZ5.getString(cursorZ5.getColumnIndex("_id")), cursorZ5.getString(cursorZ5.getColumnIndex("name")), "", 0.0d, 0, 0));
            cursorZ5.moveToNext();
        }
        cursorZ5.close();
        y();
    }
}
