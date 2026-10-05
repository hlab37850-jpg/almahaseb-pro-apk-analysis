package info.aalmoghalis.inventory.old;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
import androidx.autofill.HintConstants;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C0896Rv;
import defpackage.C2160f10;
import defpackage.C3966tX;
import defpackage.C4143vg;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class BranchList_edit extends BaseActivity {
    public SparseBooleanArray A;
    public boolean K;
    public SQLiteDatabase d;
    public Z00 e;
    public C0896Rv y;
    public String c = BranchList_edit.class.getSimpleName();
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
    public String L = "";

    public class a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.old.BranchList_edit$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0313a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0313a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    BranchList_edit.this.z();
                } catch (Exception unused) {
                    Toast.makeText(BranchList_edit.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayB = BranchList_edit.this.y.b();
                    BranchList_edit branchList_edit = BranchList_edit.this;
                    branchList_edit.A = sparseBooleanArrayB;
                    AlertDialog.Builder builder = new AlertDialog.Builder(branchList_edit);
                    builder.setMessage(BranchList_edit.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(BranchList_edit.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0313a());
                    builder.setNegativeButton(BranchList_edit.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB2 = BranchList_edit.this.y.b();
                    BranchList_edit branchList_edit2 = BranchList_edit.this;
                    branchList_edit2.A = sparseBooleanArrayB2;
                    branchList_edit2.A();
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
            BranchList_edit.this.w.setBackgroundColor(Color.parseColor("#FFFFFF"));
            BranchList_edit.this.y.h.clear();
            BranchList_edit.this.y.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = BranchList_edit.this.w.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            BranchList_edit.this.y.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (BranchList_edit.this.w.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public b(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            BranchList_edit.this.e.v0("insert into item_type  (name )  values( '" + BranchList_edit.this.L.trim() + "'  )");
            BranchList_edit.this.K = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public c(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            BranchList_edit.this.K = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
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
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ AlertDialog d;

        public f(AutoCompleteTextView autoCompleteTextView, EditText editText, EditText editText2, AlertDialog alertDialog) {
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
                if (BranchList_edit.this.H.equals("suppliers")) {
                    BranchList_edit.this.e.v0("insert into customers (name,gsm,address,cus_type_id )  values( '" + this.a.getText().toString().trim() + "','" + this.b.getText().toString() + "','" + this.c.getText().toString() + "',1  )");
                } else {
                    BranchList_edit.this.e.v0("insert into " + BranchList_edit.this.H + "  (name,gsm,address )  values( '" + this.a.getText().toString().trim() + "','" + this.b.getText().toString() + "','" + this.c.getText().toString() + "'  )");
                }
                BranchList_edit.this.D();
                this.d.dismiss();
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
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;

        public i(AutoCompleteTextView autoCompleteTextView, EditText editText, EditText editText2, String str, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = editText;
            this.c = editText2;
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
                BranchList_edit.this.e.v0("update " + BranchList_edit.this.H + "  set name = '" + this.a.getText().toString().trim() + "' ,gsm='" + this.b.getText().toString() + "' ,address='" + this.c.getText().toString() + "'  where name='" + this.d + "'");
                BranchList_edit.this.D();
                this.e.dismiss();
            }
        }
    }

    public class j implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public j(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class k implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public k(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class l implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public l(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BranchList_edit.this.y(this.a, this.b);
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class o implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ android.app.AlertDialog d;
        public final /* synthetic */ String e;

        public o(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, android.app.AlertDialog alertDialog, String str) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = editText2;
            this.d = alertDialog;
            this.e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            boolean z = AbstractC4371yX.a(this.c) ? zA : false;
            if (z && BranchList_edit.this.e.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                BranchList_edit.this.L = this.b.getText().toString();
                BranchList_edit branchList_edit = BranchList_edit.this;
                branchList_edit.C(branchList_edit.getString(R.string.validation_add_item_type), BranchList_edit.this.getString(R.string.validation_add_item_type) + "#" + BranchList_edit.this.L, this.d.getContext());
                if (!BranchList_edit.this.K) {
                    return;
                }
            }
            if (z) {
                BranchList_edit branchList_edit2 = BranchList_edit.this;
                if (C3966tX.j(branchList_edit2, branchList_edit2.e, true)) {
                    return;
                }
                BranchList_edit.this.e.v0("update items  set name='" + this.a.getText().toString().trim() + "',item_type_id=(select b.id from item_type b where b.name='" + this.b.getText().toString() + "'),o_qty='" + this.c.getText().toString().replaceAll(",", "").replaceAll("-", "") + "' where name='" + this.e + "'");
                BranchList_edit.this.D();
                this.d.dismiss();
            }
        }
    }

    public class p implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public p(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    public class q implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public q(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class r implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public r(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class s implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public s(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BranchList_edit.this.y(this.a, this.b);
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class v implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ android.app.AlertDialog d;

        public v(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, android.app.AlertDialog alertDialog) {
            this.a = editText;
            this.b = autoCompleteTextView;
            this.c = editText2;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            boolean z = AbstractC4371yX.a(this.c) ? zA : false;
            if (z && BranchList_edit.this.e.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                BranchList_edit.this.L = this.b.getText().toString();
                BranchList_edit branchList_edit = BranchList_edit.this;
                branchList_edit.C(branchList_edit.getString(R.string.validation_add_item_type), BranchList_edit.this.getString(R.string.validation_add_item_type) + "#" + BranchList_edit.this.L, this.d.getContext());
                if (!BranchList_edit.this.K) {
                    return;
                }
            }
            if (z) {
                BranchList_edit.this.e.v0("insert into items (name,item_type_id,o_qty) values('" + this.a.getText().toString().trim() + "',(select b.id from item_type b where b.name='" + this.b.getText().toString() + "'),'" + this.c.getText().toString().replaceAll(",", "").replaceAll("-", "") + "' )");
                BranchList_edit.this.D();
                this.d.dismiss();
            }
        }
    }

    public class w extends Handler {
        public w() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    private void G() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void H() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void A() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("8", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.A.size() - 1;
        if (this.A.valueAt(size)) {
            C4143vg item = this.y.getItem(this.A.keyAt(size));
            if (this.F == 1) {
                J(item.j(), item.f(), item.b());
            } else {
                I(item.j(), item.f(), item.b());
            }
        }
    }

    public void B() {
        C0896Rv c0896Rv = new C0896Rv(this, R.layout.info_item2, this.z);
        this.y = c0896Rv;
        c0896Rv.h.clear();
        this.y.notifyDataSetChanged();
        this.w.setAdapter((ListAdapter) this.y);
    }

    public boolean C(String str, String str2, Context context) {
        w wVar = new w();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(R.string.confirm_yes), new b(wVar));
        builder.setNegativeButton(getString(R.string.confirm_no), new c(wVar));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.K;
    }

    public void D() {
        Cursor cursorB6 = this.F == 1 ? this.e.b6(this.H) : this.e.a6(this.H);
        Log.d("recCount=", this.H + ":" + cursorB6.getCount());
        this.f = 0.0d;
        this.z.clear();
        cursorB6.moveToFirst();
        while (!cursorB6.isAfterLast()) {
            this.z.add(new C4143vg(cursorB6.getString(cursorB6.getColumnIndex("_id")), cursorB6.getString(cursorB6.getColumnIndex("name")), "", 0.0d, 0, 0, cursorB6.getString(cursorB6.getColumnIndex(HTML.Tag.ADDRESS)), cursorB6.getString(cursorB6.getColumnIndex(HintConstants.AUTOFILL_HINT_PHONE))));
            cursorB6.moveToNext();
        }
        cursorB6.close();
        B();
    }

    public void E() {
        try {
            if (C2160f10.h > 0 && !new C2160f10(this.e).l("8", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_info2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.info_name);
            EditText editText = (EditText) viewInflate.findViewById(R.id.info_phone);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.info_address);
            autoCompleteTextView.setHint(this.G);
            this.e.Zc(this, autoCompleteTextView);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            autoCompleteTextView.requestFocus();
            H();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new d());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new e());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.I);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new f(autoCompleteTextView, editText, editText2, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void F() {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_item3, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.info_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.info_qty);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            editText.requestFocus();
            H();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.T6());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new q(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new r(autoCompleteTextView));
            imageView.setOnClickListener(new s(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new t());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new u());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new v(editText, autoCompleteTextView, editText2, alertDialogCreate));
        } catch (Exception e2) {
            Log.d("add_item2_error=", e2.getMessage());
        }
    }

    public void I(String str, String str2, String str3) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_info2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.info_name);
            EditText editText = (EditText) viewInflate.findViewById(R.id.info_phone);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.info_address);
            autoCompleteTextView.setHint(this.G);
            this.e.Zc(this, autoCompleteTextView);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            autoCompleteTextView.setText(str);
            editText.setText(str2);
            editText2.setText(str3);
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.selectAll();
            H();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new g());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new h());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.J);
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new i(autoCompleteTextView, editText, editText2, str, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void J(String str, String str2, String str3) {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_item3, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.info_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.info_qty);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            editText.setText(str);
            editText2.setText(str2);
            autoCompleteTextView.setText(str3);
            editText.requestFocus();
            editText.selectAll();
            H();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.T6());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new j(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new k(autoCompleteTextView));
            imageView.setOnClickListener(new l(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new m());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new n());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new o(editText, autoCompleteTextView, editText2, alertDialogCreate, str));
        } catch (Exception e2) {
            Log.d("update_item2_error=", e2.getMessage());
        }
    }

    public void amount_add_btn(View view) {
        if (this.F == 1) {
            F();
        } else {
            E();
        }
    }

    public void no_result_btn(View view) {
        D();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.info_list2);
        G();
        try {
            TextView textView = (TextView) findViewById(R.id.info_name);
            TextView textView2 = (TextView) findViewById(R.id.info_phone);
            TextView textView3 = (TextView) findViewById(R.id.info_address);
            if (getIntent().getIntExtra("action_type", -1) != 2) {
                this.F = getIntent().getIntExtra("action_type", 2);
                setTitle(getString(R.string.branches));
                int i2 = this.F;
                if (i2 == 2) {
                    this.G = getString(R.string.branch_name);
                    this.H = "branches";
                    this.I = getString(R.string.add_branch);
                    this.J = getString(R.string.change_branch);
                    FragmentStatePagerSupport_Main.a0 = true;
                    C0372Bn c0372Bn = C0372Bn.f;
                    c0372Bn.a(this, textView);
                    c0372Bn.a(this, textView2);
                    c0372Bn.a(this, textView3);
                } else if (i2 == 3) {
                    this.G = getString(R.string.supp);
                    this.H = "suppliers";
                    this.I = getString(R.string.add_suuplier);
                    this.J = getString(R.string.change_supplier);
                } else if (i2 == 4) {
                    this.G = getString(R.string.cus);
                    this.H = "customers";
                    this.I = getString(R.string.add_customer);
                    this.J = getString(R.string.change_customer);
                } else if (i2 == 1) {
                    this.G = getString(R.string.item);
                    this.H = "items";
                    this.I = getString(R.string.add_item);
                    this.J = getString(R.string.change_item);
                    textView2.setText(getString(R.string.item_type));
                    textView3.setText(getString(R.string.o_qty));
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
        D();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void y(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new p(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(R.string.pref_item_type));
        dialog.show();
    }

    public void z() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("8", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (this.A.valueAt(size)) {
                C4143vg item = this.y.getItem(this.A.keyAt(size));
                this.y.remove(item);
                this.e.v0("delete from branches where id=" + item.i() + " and id<>0 and not exists (select * from bills a where a.br_id=branches.id )  and not exists (select * from bills b where b.to_br_id=branches.id ) ");
            }
        }
        D();
    }
}
