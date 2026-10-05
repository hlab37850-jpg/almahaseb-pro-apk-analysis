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
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0922Sv;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class CurrList_edit extends BaseActivity {
    public SparseBooleanArray A;
    public SQLiteDatabase d;
    public Z00 e;
    public C0922Sv y;
    public String c = CurrList_edit.class.getSimpleName();
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

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.old.CurrList_edit$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0314a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0314a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    CurrList_edit.this.w();
                } catch (Exception unused) {
                    Toast.makeText(CurrList_edit.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayC = CurrList_edit.this.y.c();
                    CurrList_edit currList_edit = CurrList_edit.this;
                    currList_edit.A = sparseBooleanArrayC;
                    AlertDialog.Builder builder = new AlertDialog.Builder(currList_edit);
                    builder.setMessage(CurrList_edit.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(CurrList_edit.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0314a());
                    builder.setNegativeButton(CurrList_edit.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC2 = CurrList_edit.this.y.c();
                    CurrList_edit currList_edit2 = CurrList_edit.this;
                    currList_edit2.A = sparseBooleanArrayC2;
                    currList_edit2.x();
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
            CurrList_edit.this.w.setBackgroundColor(Color.parseColor("#FFFFFF"));
            CurrList_edit.this.y.l.clear();
            CurrList_edit.this.y.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = CurrList_edit.this.w.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            CurrList_edit.this.y.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (CurrList_edit.this.w.getCheckedItemCount() != 1) {
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
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ AlertDialog d;

        public d(AutoCompleteTextView autoCompleteTextView, EditText editText, EditText editText2, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = editText;
            this.c = editText2;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (AbstractC4371yX.a(this.c) ? zA : false) {
                CurrList_edit.this.e.v0("insert into currency  (name,fils_name,code_name )  values( '" + this.c.getText().toString() + "','" + this.b.getText().toString() + "','" + this.a.getText().toString() + "'  )");
                FragmentStatePagerSupport_Main.a0 = true;
                CurrList_edit.this.z();
                this.d.dismiss();
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
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;

        public g(EditText editText, EditText editText2, AutoCompleteTextView autoCompleteTextView, String str, AlertDialog alertDialog) {
            this.a = editText;
            this.b = editText2;
            this.c = autoCompleteTextView;
            this.d = str;
            this.e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (AbstractC4371yX.a(this.c) ? zA : false) {
                CurrList_edit.this.e.v0("update currency  set name = '" + this.a.getText().toString() + "' , fils_name = '" + this.b.getText().toString() + "' , code_name = '" + this.c.getText().toString() + "'  where name='" + this.d + "'");
                FragmentStatePagerSupport_Main.a0 = true;
                CurrList_edit.this.z();
            }
            this.e.dismiss();
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
            if (C2160f10.h > 0 && !new C2160f10(this.e).l("19", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_currency, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.cus_phone);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            this.e.Zc(this, autoCompleteTextView);
            editText.requestFocus();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new b());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new c());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.add_curr));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new d(autoCompleteTextView, editText2, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void C(String str, String str2, String str3) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_currency, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.cus_phone);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            this.e.Zc(this, autoCompleteTextView);
            new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.s3());
            editText.setText(str);
            editText2.setText(str2);
            autoCompleteTextView.setText(str3);
            editText2.requestFocus();
            editText2.selectAll();
            autoCompleteTextView.selectAll();
            editText.selectAll();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new e());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new f());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.change_curr));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new g(editText, editText2, autoCompleteTextView, str, alertDialogCreate));
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
        setContentView(R.layout.curr_list);
        B();
        try {
            TextView textView = (TextView) findViewById(R.id.g_name);
            TextView textView2 = (TextView) findViewById(R.id.g_cnt);
            TextView textView3 = (TextView) findViewById(R.id.fils_name);
            textView.setText(getString(R.string.tr_curr_name));
            C0372Bn c0372Bn = C0372Bn.f;
            c0372Bn.a(this, textView);
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
        if (!Z00.Z) {
            Toast.makeText(this, getString(R.string.curr_option), 1).show();
        }
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
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("19", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (this.A.valueAt(size)) {
                C4145vh item = this.y.getItem(this.A.keyAt(size));
                this.y.remove(item);
                this.e.v0("delete from currency where id=" + item.v() + " and id<>0 and id not in (select curr_id from transactions) ");
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        z();
    }

    public void x() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("19", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.A.size() - 1;
        if (this.A.valueAt(size)) {
            C4145vh item = this.y.getItem(this.A.keyAt(size));
            C(item.a(), item.n(), item.o());
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
        Cursor cursorW2 = this.e.W2();
        cursorW2.getCount();
        this.f = 0.0d;
        this.z.clear();
        cursorW2.moveToFirst();
        while (!cursorW2.isAfterLast()) {
            this.z.add(new C4145vh(cursorW2.getString(cursorW2.getColumnIndex("_id")), cursorW2.getString(cursorW2.getColumnIndex("name")), cursorW2.getString(cursorW2.getColumnIndex("fils_name")), cursorW2.getString(cursorW2.getColumnIndex("code_name")), cursorW2.getString(cursorW2.getColumnIndex("cnt")), "", "", "", ""));
            cursorW2.moveToNext();
        }
        cursorW2.close();
        y();
    }
}
