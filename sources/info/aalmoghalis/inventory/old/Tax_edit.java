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
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
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
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Tax_edit extends BaseActivity {
    public SparseBooleanArray A;
    public SQLiteDatabase d;
    public Z00 e;
    public C0922Sv y;
    public String c = Tax_edit.class.getSimpleName();
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

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.old.Tax_edit$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0317a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0317a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Tax_edit.this.w();
                } catch (Exception unused) {
                    Toast.makeText(Tax_edit.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayC = Tax_edit.this.y.c();
                    Tax_edit tax_edit = Tax_edit.this;
                    tax_edit.A = sparseBooleanArrayC;
                    AlertDialog.Builder builder = new AlertDialog.Builder(tax_edit);
                    builder.setMessage(Tax_edit.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Tax_edit.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0317a());
                    builder.setNegativeButton(Tax_edit.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC2 = Tax_edit.this.y.c();
                    Tax_edit tax_edit2 = Tax_edit.this;
                    tax_edit2.A = sparseBooleanArrayC2;
                    tax_edit2.x();
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
            Tax_edit.this.w.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Tax_edit.this.y.l.clear();
            Tax_edit.this.y.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Tax_edit.this.w.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Tax_edit.this.y.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Tax_edit.this.w.getCheckedItemCount() != 1) {
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
            Tax_edit.this.e.Mc("prefOthers_purchases_tax", true);
            Tax_edit.this.e.Mc("prefOthers_sales_tax", true);
            dialogInterface.dismiss();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tax_edit.this.e.Mc("prefOthers_purchases_tax", false);
            Tax_edit.this.e.Mc("prefOthers_sales_tax", false);
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
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ SwitchCompat c;
        public final /* synthetic */ SwitchCompat d;
        public final /* synthetic */ AlertDialog e;

        public f(EditText editText, EditText editText2, SwitchCompat switchCompat, SwitchCompat switchCompat2, AlertDialog alertDialog) {
            this.a = editText;
            this.b = editText2;
            this.c = switchCompat;
            this.d = switchCompat2;
            this.e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (zA) {
                this.c.isChecked();
                String str = !this.d.isChecked() ? "0" : "1";
                Tax_edit.this.e.v0("insert into tax  (name,per,is_default,is_active )  values( '" + this.a.getText().toString() + "','" + this.b.getText().toString() + "','" + str + "','1'  )");
                FragmentStatePagerSupport_Main.a0 = true;
                Tax_edit.this.z();
                this.e.dismiss();
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
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ SwitchCompat c;
        public final /* synthetic */ SwitchCompat d;
        public final /* synthetic */ String e;
        public final /* synthetic */ AlertDialog f;

        public i(EditText editText, EditText editText2, SwitchCompat switchCompat, SwitchCompat switchCompat2, String str, AlertDialog alertDialog) {
            this.a = editText;
            this.b = editText2;
            this.c = switchCompat;
            this.d = switchCompat2;
            this.e = str;
            this.f = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (zA) {
                String str = !this.c.isChecked() ? "0" : "1";
                String str2 = this.d.isChecked() ? "1" : "0";
                Tax_edit.this.e.v0("update tax  set name= '" + this.a.getText().toString() + "' ,per= '" + this.b.getText().toString() + "' ,is_active= '" + str + "' ,is_default= '" + str2 + "'  where id='" + this.e + "' and id<> -1 ");
                FragmentStatePagerSupport_Main.a0 = true;
                Tax_edit.this.z();
            }
            this.f.dismiss();
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
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_tax, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.tax_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.tax_per);
            SwitchCompat switchCompat = (SwitchCompat) viewInflate.findViewById(R.id.is_active);
            SwitchCompat switchCompat2 = (SwitchCompat) viewInflate.findViewById(R.id.is_default);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            editText.requestFocus();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new d());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new e());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.add_tax));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new f(editText, editText2, switchCompat, switchCompat2, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void C(String str, String str2, String str3, String str4, String str5) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_tax, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.tax_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.tax_per);
            SwitchCompat switchCompat = (SwitchCompat) viewInflate.findViewById(R.id.is_active);
            SwitchCompat switchCompat2 = (SwitchCompat) viewInflate.findViewById(R.id.is_default);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            editText.setText(str2);
            editText2.setText(str3);
            if (str4.equals("1")) {
                switchCompat.setChecked(true);
            } else {
                switchCompat.setChecked(false);
            }
            if (str5.equals("1")) {
                switchCompat2.setChecked(true);
            } else {
                switchCompat2.setChecked(false);
            }
            editText.requestFocus();
            editText2.selectAll();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new g());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new h());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.change_tax));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new i(editText, editText2, switchCompat, switchCompat2, str, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void D() {
        try {
            if (this.e.ja("prefOthers_purchases_tax", false) && this.e.ja("prefOthers_sales_tax", false)) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
                builder.setMessage(getString(R.string.tax_confirm));
                builder.setCancelable(true).setPositiveButton(getString(R.string.confirm_yes), new c()).setNegativeButton(getString(R.string.confirm_no), new b());
                builder.create().show();
            }
        } catch (Exception e2) {
            Log.d("adv_search_error=", ":" + e2.getMessage());
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
        setContentView(R.layout.curr_list);
        B();
        try {
            TextView textView = (TextView) findViewById(R.id.g_name);
            TextView textView2 = (TextView) findViewById(R.id.fils_name);
            TextView textView3 = (TextView) findViewById(R.id.code_name);
            TextView textView4 = (TextView) findViewById(R.id.g_cnt);
            textView.setText(getString(R.string.tax_name));
            textView2.setText(getString(R.string.percentage));
            textView3.setText(getString(R.string.enable2));
            textView4.setText(getString(R.string.default_));
            C0372Bn c0372Bn = C0372Bn.f;
            c0372Bn.a(this, textView);
            c0372Bn.a(this, textView4);
            c0372Bn.a(this, textView2);
            c0372Bn.a(this, textView3);
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
        this.e = new Z00(this.d, this);
        z();
        D();
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
                C4145vh item = this.y.getItem(this.A.keyAt(size));
                this.y.remove(item);
                this.e.v0("delete from tax where id=" + item.v() + " and id<> -1 and per not in (select t_val from bills) ");
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        z();
    }

    public void x() {
        int size = this.A.size() - 1;
        if (this.A.valueAt(size)) {
            C4145vh item = this.y.getItem(this.A.keyAt(size));
            C(item.v(), item.a(), item.n(), item.q(), item.r());
        }
    }

    public void y() {
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.group_item_, this.z, 4, false, 1);
        this.y = c0922Sv;
        c0922Sv.l.clear();
        this.y.notifyDataSetChanged();
        this.w.setAdapter((ListAdapter) this.y);
    }

    public void z() {
        Cursor cursorA8 = this.e.A8();
        cursorA8.getCount();
        this.f = 0.0d;
        this.z.clear();
        cursorA8.moveToFirst();
        while (!cursorA8.isAfterLast()) {
            this.z.add(new C4145vh(cursorA8.getString(cursorA8.getColumnIndex("_id")), cursorA8.getString(cursorA8.getColumnIndex("tax_name")), cursorA8.getString(cursorA8.getColumnIndex("tax_per")), cursorA8.getString(cursorA8.getColumnIndex("is_active2")), cursorA8.getString(cursorA8.getColumnIndex("is_default2")), cursorA8.getString(cursorA8.getColumnIndex("is_active")), cursorA8.getString(cursorA8.getColumnIndex("is_default")), "", ""));
            cursorA8.moveToNext();
        }
        cursorA8.close();
        y();
    }
}
