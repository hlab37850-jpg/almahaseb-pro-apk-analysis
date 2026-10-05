package info.aalmoghalis.inventory.activity;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.autofill.HintConstants;
import androidx.core.view.MenuItemCompat;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0896Rv;
import defpackage.C3966tX;
import defpackage.C4143vg;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Info_edit2 extends BaseActivity {
    public SparseBooleanArray A;
    public boolean K;
    public SQLiteDatabase d;
    public Z00 e;
    public C0896Rv y;
    public String c = Info_edit2.class.getSimpleName();
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

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Info_edit2$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0297a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0297a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Info_edit2.this.z();
                } catch (Exception unused) {
                    Toast.makeText(Info_edit2.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayB = Info_edit2.this.y.b();
                    Info_edit2 info_edit2 = Info_edit2.this;
                    info_edit2.A = sparseBooleanArrayB;
                    AlertDialog.Builder builder = new AlertDialog.Builder(info_edit2);
                    builder.setMessage(Info_edit2.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Info_edit2.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0297a());
                    builder.setNegativeButton(Info_edit2.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayB2 = Info_edit2.this.y.b();
                    Info_edit2 info_edit3 = Info_edit2.this;
                    info_edit3.A = sparseBooleanArrayB2;
                    info_edit3.A();
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
            Info_edit2.this.w.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Info_edit2.this.y.h.clear();
            Info_edit2.this.y.d();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Info_edit2.this.w.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Info_edit2.this.y.f(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Info_edit2.this.w.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ android.app.AlertDialog d;

        public b(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, android.app.AlertDialog alertDialog) {
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
            if (z && Info_edit2.this.e.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Info_edit2.this.L = this.b.getText().toString();
                Info_edit2 info_edit2 = Info_edit2.this;
                info_edit2.C(info_edit2.getString(R.string.validation_add_item_type), Info_edit2.this.getString(R.string.validation_add_item_type) + "#" + Info_edit2.this.L, this.d.getContext());
                if (!Info_edit2.this.K) {
                    return;
                }
            }
            if (z) {
                Info_edit2.this.e.v0("insert into items (name,item_type_id,o_qty) values('" + this.a.getText().toString().trim() + "',(select b.id from item_type b where b.name='" + this.b.getText().toString() + "'),'" + this.c.getText().toString().replaceAll(",", "").replaceAll("-", "") + "' )");
                Info_edit2.this.D();
                this.d.dismiss();
            }
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public d(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Info_edit2.this.e.v0("insert into item_type  (name )  values( '" + Info_edit2.this.L.trim() + "'  )");
            Info_edit2.this.K = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public e(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Info_edit2.this.K = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
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
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ AlertDialog d;

        public h(AutoCompleteTextView autoCompleteTextView, EditText editText, EditText editText2, AlertDialog alertDialog) {
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
                if (Info_edit2.this.H.equals("suppliers")) {
                    Info_edit2.this.e.v0("insert into customers (name,gsm,address,cus_type_id )  values( '" + this.a.getText().toString().trim() + "','" + this.b.getText().toString() + "','" + this.c.getText().toString() + "',1  )");
                } else {
                    Info_edit2.this.e.v0("insert into " + Info_edit2.this.H + "  (name,gsm,address )  values( '" + this.a.getText().toString().trim() + "','" + this.b.getText().toString() + "','" + this.c.getText().toString() + "'  )");
                }
                Info_edit2.this.D();
                this.d.dismiss();
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

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class k implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;

        public k(AutoCompleteTextView autoCompleteTextView, EditText editText, EditText editText2, String str, AlertDialog alertDialog) {
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
                Info_edit2.this.e.v0("update " + Info_edit2.this.H + "  set name = '" + this.a.getText().toString().trim() + "' ,gsm='" + this.b.getText().toString() + "' ,address='" + this.c.getText().toString() + "'  where name='" + this.d + "'");
                Info_edit2.this.D();
                this.e.dismiss();
            }
        }
    }

    public class l implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public l(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class m implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public m(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public n(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit2.this.y(this.a, this.b);
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class q implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ android.app.AlertDialog d;
        public final /* synthetic */ String e;

        public q(EditText editText, AutoCompleteTextView autoCompleteTextView, EditText editText2, android.app.AlertDialog alertDialog, String str) {
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
            if (z && Info_edit2.this.e.P5(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Info_edit2.this.L = this.b.getText().toString();
                Info_edit2 info_edit2 = Info_edit2.this;
                info_edit2.C(info_edit2.getString(R.string.validation_add_item_type), Info_edit2.this.getString(R.string.validation_add_item_type) + "#" + Info_edit2.this.L, this.d.getContext());
                if (!Info_edit2.this.K) {
                    return;
                }
            }
            if (z) {
                Info_edit2 info_edit3 = Info_edit2.this;
                if (C3966tX.j(info_edit3, info_edit3.e, true)) {
                    return;
                }
                Info_edit2.this.e.v0("update items  set name='" + this.a.getText().toString().trim() + "',item_type_id=(select b.id from item_type b where b.name='" + this.b.getText().toString() + "'),o_qty='" + this.c.getText().toString().replaceAll(",", "").replaceAll("-", "") + "' where name='" + this.e + "'");
                Info_edit2.this.D();
                this.d.dismiss();
            }
        }
    }

    public class r implements SearchView.OnQueryTextListener {
        public r() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            Info_edit2.this.G(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class s implements MenuItemCompat.OnActionExpandListener {
        public s() {
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            Log.d("search=", "onMenuItemActionCollapse");
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            Log.d("search=", "onMenuItemActionExpand");
            return true;
        }
    }

    public class t implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ Dialog b;

        public t(AutoCompleteTextView autoCompleteTextView, Dialog dialog) {
            this.a = autoCompleteTextView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.dismiss();
        }
    }

    public class u implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public u(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class v implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public v(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class w implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ AutoCompleteTextView b;

        public w(ArrayAdapter arrayAdapter, AutoCompleteTextView autoCompleteTextView) {
            this.a = arrayAdapter;
            this.b = autoCompleteTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Info_edit2.this.y(this.a, this.b);
        }
    }

    public class x implements DialogInterface.OnClickListener {
        public x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class y implements DialogInterface.OnClickListener {
        public y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private void H() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void I() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void A() {
        int size = this.A.size() - 1;
        if (this.A.valueAt(size)) {
            C4143vg item = this.y.getItem(this.A.keyAt(size));
            if (this.F == 1) {
                K(item.j(), item.f(), item.b());
            } else {
                J(item.j(), item.f(), item.b());
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
        c cVar = new c();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(R.string.confirm_yes), new d(cVar));
        builder.setNegativeButton(getString(R.string.confirm_no), new e(cVar));
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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_info2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.info_name);
            EditText editText = (EditText) viewInflate.findViewById(R.id.info_phone);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.info_address);
            autoCompleteTextView.setHint(this.G);
            autoCompleteTextView.requestFocus();
            I();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new f());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new g());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.I);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new h(autoCompleteTextView, editText, editText2, alertDialogCreate));
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
            I();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.T6());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new u(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new v(autoCompleteTextView));
            imageView.setOnClickListener(new w(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new x());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new y());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new b(editText, autoCompleteTextView, editText2, alertDialogCreate));
        } catch (Exception e2) {
            Log.d("add_item2_error=", e2.getMessage());
        }
    }

    public void G(String str) {
        C0896Rv c0896Rv = this.y;
        if (c0896Rv != null) {
            c0896Rv.getFilter().filter(str);
        }
    }

    public void J(String str, String str2, String str3) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_info2, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.info_name);
            EditText editText = (EditText) viewInflate.findViewById(R.id.info_phone);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.info_address);
            autoCompleteTextView.setHint(this.G);
            autoCompleteTextView.setText(str);
            editText.setText(str2);
            editText2.setText(str3);
            this.e.Zc(this, autoCompleteTextView);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.selectAll();
            I();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new i());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new j());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(this.J);
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new k(autoCompleteTextView, editText, editText2, str, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void K(String str, String str2, String str3) {
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
            I();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.T6());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new l(autoCompleteTextView));
            autoCompleteTextView.setOnTouchListener(new m(autoCompleteTextView));
            imageView.setOnClickListener(new n(arrayAdapter, autoCompleteTextView));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new o());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new p());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new q(editText, autoCompleteTextView, editText2, alertDialogCreate, str));
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
        H();
        try {
            TextView textView = (TextView) findViewById(R.id.info_name);
            TextView textView2 = (TextView) findViewById(R.id.info_phone);
            TextView textView3 = (TextView) findViewById(R.id.info_address);
            if (getIntent().getIntExtra("action_type", -1) != -1) {
                this.F = getIntent().getIntExtra("action_type", -1);
                setTitle(getIntent().getStringExtra("action_text"));
                int i2 = this.F;
                if (i2 == 2) {
                    this.G = getString(R.string.branch_name);
                    this.H = "branches";
                    this.I = getString(R.string.add_branch);
                    this.J = getString(R.string.change_branch);
                    FragmentStatePagerSupport_Main.a0 = true;
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

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu != null) {
            menu.clear();
        }
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItemFindItem.getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new r());
        MenuItemCompat.setOnActionExpandListener(menuItemFindItem, new s());
        return true;
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
        listView.setOnItemClickListener(new t(autoCompleteTextView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.setTitle(getString(R.string.pref_item_type));
        dialog.show();
    }

    public void z() {
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (this.A.valueAt(size)) {
                C4143vg item = this.y.getItem(this.A.keyAt(size));
                this.y.remove(item);
                Z00 z00 = this.e;
                StringBuilder sb = new StringBuilder();
                sb.append("delete from ");
                sb.append(this.H.equals("suppliers") ? "customers" : this.H);
                sb.append(" where id=");
                sb.append(item.i());
                sb.append(" and id<>0  ");
                z00.v0(sb.toString());
            }
        }
        D();
    }
}
