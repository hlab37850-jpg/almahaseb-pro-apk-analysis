package info.aalmoghalis.inventory.old;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import defpackage.C0372Bn;
import defpackage.C0870Qv;
import defpackage.C4143vg;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class itemType_edit extends BaseActivity {
    public SparseBooleanArray A;
    public SQLiteDatabase d;
    public Z00 e;
    public C0870Qv y;
    public String c = itemType_edit.class.getSimpleName();
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

    public class a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.old.itemType_edit$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0320a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0320a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    itemType_edit.this.w();
                } catch (Exception unused) {
                    Toast.makeText(itemType_edit.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayC = itemType_edit.this.y.c();
                    itemType_edit itemtype_edit = itemType_edit.this;
                    itemtype_edit.A = sparseBooleanArrayC;
                    AlertDialog.Builder builder = new AlertDialog.Builder(itemtype_edit);
                    builder.setMessage(itemType_edit.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(itemType_edit.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0320a());
                    builder.setNegativeButton(itemType_edit.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC2 = itemType_edit.this.y.c();
                    itemType_edit itemtype_edit2 = itemType_edit.this;
                    itemtype_edit2.A = sparseBooleanArrayC2;
                    itemtype_edit2.x();
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
            itemType_edit.this.w.setBackgroundColor(Color.parseColor("#FFFFFF"));
            itemType_edit.this.y.i.clear();
            itemType_edit.this.y.e();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = itemType_edit.this.w.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            itemType_edit.this.y.g(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (itemType_edit.this.w.getCheckedItemCount() != 1) {
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

    public class c implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AlertDialog c;

        public c(AutoCompleteTextView autoCompleteTextView, String str, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = str;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a)) {
                itemType_edit.this.e.v0("update item_type  set name = '" + this.a.getText().toString() + "'  where name='" + this.b + "'");
                FragmentStatePagerSupport_Main.a0 = true;
                itemType_edit.this.z();
            }
            this.c.dismiss();
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public d(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class e implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public e(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
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
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AlertDialog b;

        public h(AutoCompleteTextView autoCompleteTextView, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a)) {
                itemType_edit.this.e.v0("insert into item_type  (name )  values( '" + this.a.getText().toString() + "'  )");
                FragmentStatePagerSupport_Main.a0 = true;
                itemType_edit.this.z();
                this.b.dismiss();
            }
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public i(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class j implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public j(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void B() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void A() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_call);
            editText.setVisibility(8);
            editText2.setVisibility(8);
            imageView.setVisibility(8);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            this.e.Zc(this, autoCompleteTextView);
            new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.T6());
            autoCompleteTextView.setOnItemClickListener(new d(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new e(autoCompleteTextView));
            autoCompleteTextView.requestFocus();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new f());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new g());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.add_group));
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new h(autoCompleteTextView, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void C(String str) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_call);
            editText.setVisibility(8);
            editText2.setVisibility(8);
            imageView.setVisibility(8);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.T6());
            autoCompleteTextView.setText(str);
            autoCompleteTextView.setOnItemClickListener(new i(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new j(autoCompleteTextView));
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.selectAll();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new k());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new b());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.change_class));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new c(autoCompleteTextView, str, alertDialogCreate));
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
        setContentView(R.layout.group_list);
        B();
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        TextView textView = (TextView) findViewById(R.id.g_name);
        TextView textView2 = (TextView) findViewById(R.id.g_cnt);
        textView.setText(getString(R.string.name));
        textView2.setText(getString(R.string.items_count));
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, textView);
        c0372Bn.a(this, textView2);
        this.w = (ListView) findViewById(R.id.list_data);
        this.w.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.w.setChoiceMode(2);
        this.e = new Z00(this.d, this);
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
                this.y.remove(this.y.getItem(this.A.keyAt(size)));
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        z();
    }

    public void x() {
        int size = this.A.size() - 1;
        if (this.A.valueAt(size)) {
            C(this.y.getItem(this.A.keyAt(size)).j());
        }
    }

    public void y() {
        C0870Qv c0870Qv = new C0870Qv(this, R.layout.group_item, this.z);
        this.y = c0870Qv;
        c0870Qv.i.clear();
        this.y.notifyDataSetChanged();
        this.w.setAdapter((ListAdapter) this.y);
    }

    public void z() {
        Cursor cursorR6 = this.e.R6();
        cursorR6.getCount();
        this.f = 0.0d;
        this.z.clear();
        cursorR6.moveToFirst();
        while (!cursorR6.isAfterLast()) {
            this.z.add(new C4143vg(cursorR6.getString(cursorR6.getColumnIndex("_id")), cursorR6.getString(cursorR6.getColumnIndex("name")), cursorR6.getString(cursorR6.getColumnIndex("cnt")), 0.0d, 0, 0));
            cursorR6.moveToNext();
        }
        cursorR6.close();
        y();
    }
}
