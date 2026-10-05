package info.aalmoghalis.inventory.old;

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
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import com.itextpdf.tool.xml.css.CSS;
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
public class Unit_item_edit extends BaseActivity {
    public SparseBooleanArray A;
    public ArrayAdapter I;
    public boolean L;
    public SQLiteDatabase d;
    public Z00 e;
    public C0922Sv y;
    public String c = Unit_item_edit.class.getSimpleName();
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
    public String F = "";
    public Handler G = new r();
    public String H = CSS.Value.PERCENTAGE;
    public ArrayList J = new ArrayList();
    public ArrayList K = new ArrayList();
    public String M = "";

    public class a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.old.Unit_item_edit$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0319a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0319a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Unit_item_edit.this.A();
                } catch (Exception unused) {
                    Toast.makeText(Unit_item_edit.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayC = Unit_item_edit.this.y.c();
                    Unit_item_edit unit_item_edit = Unit_item_edit.this;
                    unit_item_edit.A = sparseBooleanArrayC;
                    AlertDialog.Builder builder = new AlertDialog.Builder(unit_item_edit);
                    builder.setMessage(Unit_item_edit.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(Unit_item_edit.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0319a());
                    builder.setNegativeButton(Unit_item_edit.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC2 = Unit_item_edit.this.y.c();
                    Unit_item_edit unit_item_edit2 = Unit_item_edit.this;
                    unit_item_edit2.A = sparseBooleanArrayC2;
                    unit_item_edit2.B();
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
            Unit_item_edit.this.w.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Unit_item_edit.this.y.l.clear();
            Unit_item_edit.this.y.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Unit_item_edit.this.w.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Unit_item_edit.this.y.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Unit_item_edit.this.w.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ TextView c;

        public b(AutoCompleteTextView autoCompleteTextView, EditText editText, TextView textView) {
            this.a = autoCompleteTextView;
            this.b = editText;
            this.c = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Unit_item_edit unit_item_edit = Unit_item_edit.this;
            unit_item_edit.z(unit_item_edit.J, this.a, this.b, this.c);
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ AlertDialog e;

        public e(AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, EditText editText, TextView textView, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = autoCompleteTextView2;
            this.c = editText;
            this.d = textView;
            this.e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            boolean z = this.d.getText().toString().equals(this.b.getText().toString()) ? false : zA;
            if (Unit_item_edit.this.e.Z8(this.b.getText().toString()).getCount() == 0 && this.b.getText().toString().trim().length() > 0) {
                Unit_item_edit.this.M = this.b.getText().toString();
                Unit_item_edit unit_item_edit = Unit_item_edit.this;
                unit_item_edit.D(unit_item_edit.getString(R.string.add_unit), Unit_item_edit.this.getString(R.string.add_unit) + "#" + Unit_item_edit.this.M, this.e.getContext());
                if (!Unit_item_edit.this.L) {
                    return;
                }
            }
            if (z) {
                Unit_item_edit.this.e.v0("insert into unit_item  (item_id,unit_id,u_val )  values( (select id from items where name='" + this.a.getText().toString() + "'),(select id from units where name='" + this.b.getText().toString() + "'),'" + this.c.getText().toString() + "'  )");
                FragmentStatePagerSupport_Main.a0 = true;
                Unit_item_edit.this.E();
                this.e.dismiss();
            }
        }
    }

    public class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            throw new RuntimeException();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public g(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Unit_item_edit.this.e.v0("insert into units  (name,code )  values( '" + Unit_item_edit.this.M.trim() + "' ,'" + Unit_item_edit.this.M.trim() + "'  )");
            Unit_item_edit.this.L = true;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ Handler a;

        public h(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Unit_item_edit.this.L = false;
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage());
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ TextView d;

        public i(AutoCompleteTextView autoCompleteTextView, String[] strArr, TextView textView, TextView textView2) {
            this.a = autoCompleteTextView;
            this.b = strArr;
            this.c = textView;
            this.d = textView2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setText(this.b[i]);
            this.a.dismissDropDown();
            this.c.requestFocus();
            if (this.a.getId() == R.id.item_name) {
                this.d.setText(Unit_item_edit.this.e.V6(this.a.getText().toString()));
                Unit_item_edit unit_item_edit = Unit_item_edit.this;
                unit_item_edit.J = unit_item_edit.e.e9(this.a.getText() != null ? this.a.getText().toString() : "");
                Unit_item_edit unit_item_edit2 = Unit_item_edit.this;
                Unit_item_edit unit_item_edit3 = Unit_item_edit.this;
                unit_item_edit2.I = new ArrayAdapter(unit_item_edit3, android.R.layout.simple_spinner_dropdown_item, unit_item_edit3.J);
            }
        }
    }

    public class j implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AutoCompleteTextView b;

        public j(AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2) {
            this.a = autoCompleteTextView;
            this.b = autoCompleteTextView2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.requestFocus();
            Unit_item_edit unit_item_edit = Unit_item_edit.this;
            unit_item_edit.J = unit_item_edit.e.e9(this.a.getText() != null ? this.a.getText().toString() : "");
            Unit_item_edit unit_item_edit2 = Unit_item_edit.this;
            Unit_item_edit unit_item_edit3 = Unit_item_edit.this;
            unit_item_edit2.I = new ArrayAdapter(unit_item_edit3, android.R.layout.simple_spinner_dropdown_item, unit_item_edit3.J);
        }
    }

    public class k implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;

        public k(AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.requestFocus();
        }
    }

    public class l implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ TextView c;

        public l(AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, TextView textView) {
            this.a = autoCompleteTextView;
            this.b = autoCompleteTextView2;
            this.c = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Unit_item_edit unit_item_edit = Unit_item_edit.this;
            unit_item_edit.z(unit_item_edit.K, this.a, this.b, this.c);
        }
    }

    public class m implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ TextView c;

        public m(AutoCompleteTextView autoCompleteTextView, EditText editText, TextView textView) {
            this.a = autoCompleteTextView;
            this.b = editText;
            this.c = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Unit_item_edit unit_item_edit = Unit_item_edit.this;
            unit_item_edit.z(unit_item_edit.J, this.a, this.b, this.c);
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class p implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;

        public p(AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, EditText editText, String str, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = autoCompleteTextView2;
            this.c = editText;
            this.d = str;
            this.e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            if (zA) {
                String strY0 = Unit_item_edit.this.e.y0("update unit_item  set unit_id = (select id from units where name='" + this.b.getText().toString() + "') , u_val = '" + this.c.getText().toString() + "'  where id='" + this.d + "' and not exists(select * from items where id=unit_item.item_id and unit_id=unit_item.unit_id) ");
                if (strY0 != null && strY0.equals("1")) {
                    FragmentStatePagerSupport_Main.a0 = true;
                    Unit_item_edit.this.E();
                    this.e.dismiss();
                    return;
                }
                Unit_item_edit unit_item_edit = Unit_item_edit.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Error:");
                if (strY0 != null && strY0.length() > 20) {
                    strY0 = strY0.substring(0, 20);
                }
                sb.append(strY0);
                Toast.makeText(unit_item_edit, sb.toString(), 0).show();
            }
        }
    }

    public class q implements SearchView.OnQueryTextListener {
        public q() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            TextUtils.isEmpty(str);
            Unit_item_edit.this.G(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class r extends Handler {
        public r() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Unit_item_edit.this.C();
                return;
            }
            if (!message.obj.toString().equals("1")) {
                if (message.obj.toString().equals("2")) {
                    Unit_item_edit.this.y.notifyDataSetChanged();
                }
            } else {
                Z00 z00 = Unit_item_edit.this.e;
                StringBuilder sb = new StringBuilder();
                Unit_item_edit unit_item_edit = Unit_item_edit.this;
                sb.append(unit_item_edit.e.ic(unit_item_edit.F));
                sb.append(".pdf");
                z00.ra(sb.toString());
            }
        }
    }

    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Unit_item_edit unit_item_edit = Unit_item_edit.this;
            Z00 z00 = unit_item_edit.e;
            z00.Mb(unit_item_edit.w, z00.ic(unit_item_edit.F));
            Message message = new Message();
            message.obj = "1";
            Unit_item_edit.this.G.sendMessage(message);
        }
    }

    public class t implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ AutoCompleteTextView c;

        public t(AutoCompleteTextView autoCompleteTextView, TextView textView, AutoCompleteTextView autoCompleteTextView2) {
            this.a = autoCompleteTextView;
            this.b = textView;
            this.c = autoCompleteTextView2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.setText(Unit_item_edit.this.e.V6(this.a.getText().toString()));
            this.c.requestFocus();
            Unit_item_edit unit_item_edit = Unit_item_edit.this;
            unit_item_edit.J = unit_item_edit.e.e9(this.a.getText() != null ? this.a.getText().toString() : "");
            Unit_item_edit unit_item_edit2 = Unit_item_edit.this;
            Unit_item_edit unit_item_edit3 = Unit_item_edit.this;
            unit_item_edit2.I = new ArrayAdapter(unit_item_edit3, android.R.layout.simple_spinner_dropdown_item, unit_item_edit3.J);
        }
    }

    public class u implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ AutoCompleteTextView c;
        public final /* synthetic */ EditText d;

        public u(AutoCompleteTextView autoCompleteTextView, TextView textView, AutoCompleteTextView autoCompleteTextView2, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = textView;
            this.c = autoCompleteTextView2;
            this.d = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.b.setText(Unit_item_edit.this.e.V6(this.c.getText().toString()));
            this.d.requestFocus();
        }
    }

    public class v implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ TextView c;

        public v(AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, TextView textView) {
            this.a = autoCompleteTextView;
            this.b = autoCompleteTextView2;
            this.c = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Unit_item_edit unit_item_edit = Unit_item_edit.this;
            unit_item_edit.z(unit_item_edit.K, this.a, this.b, this.c);
        }
    }

    private void I() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void A() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("27", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (this.A.valueAt(size)) {
                C4145vh item = this.y.getItem(this.A.keyAt(size));
                this.y.remove(item);
                this.e.v0("delete from unit_item where id=" + item.v() + " and not exists (select * from bill_transactions where  item_id=unit_item.item_id and unit_id=unit_item.unit_id) ");
            }
        }
        FragmentStatePagerSupport_Main.a0 = true;
        E();
    }

    public void B() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("27", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.A.size() - 1;
        if (this.A.valueAt(size)) {
            C4145vh item = this.y.getItem(this.A.keyAt(size));
            J(item.v(), item.a(), item.n(), item.o());
        }
    }

    public void C() {
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.unit_item_, this.z, 4, false, 1);
        this.y = c0922Sv;
        c0922Sv.l.clear();
        this.y.notifyDataSetChanged();
        this.w.setAdapter((ListAdapter) this.y);
    }

    public boolean D(String str, String str2, Context context) {
        f fVar = new f();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(getString(R.string.confirm_yes), new g(fVar));
        builder.setNegativeButton(getString(R.string.confirm_no), new h(fVar));
        builder.show();
        try {
            Looper.loop();
        } catch (RuntimeException unused) {
        }
        return this.L;
    }

    public void E() {
        Cursor cursorY6 = this.e.Y6(this.H);
        cursorY6.getCount();
        this.f = 0.0d;
        this.z.clear();
        cursorY6.moveToFirst();
        while (!cursorY6.isAfterLast()) {
            this.z.add(new C4145vh(cursorY6.getString(cursorY6.getColumnIndex("_id")), cursorY6.getString(cursorY6.getColumnIndex("item_name")), cursorY6.getString(cursorY6.getColumnIndex("unit_name")), this.e.S7(String.valueOf(cursorY6.getDouble(cursorY6.getColumnIndex("u_val")))), cursorY6.getString(cursorY6.getColumnIndex("base_unit")), "", "", "", ""));
            cursorY6.moveToNext();
        }
        cursorY6.close();
        C();
    }

    public void F() {
        try {
            if (C2160f10.h > 0 && !new C2160f10(this.e).l("27", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_unit_item, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.item_name);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.unit_name);
            EditText editText = (EditText) viewInflate.findViewById(R.id.unit_val);
            TextView textView = (TextView) viewInflate.findViewById(R.id.base_unit);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_class_unit);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_class_item);
            this.e.Zc(this, autoCompleteTextView);
            this.e.Zc(this, autoCompleteTextView2);
            if (this.H.equals(CSS.Value.PERCENTAGE)) {
                autoCompleteTextView.requestFocus();
            } else {
                autoCompleteTextView.setText(this.H);
                textView.setText(this.e.V6(autoCompleteTextView.getText().toString()));
                autoCompleteTextView2.requestFocus();
            }
            this.K = this.e.F6();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.K);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new t(autoCompleteTextView, textView, autoCompleteTextView2));
            this.J = this.e.e9(autoCompleteTextView.getText() != null ? autoCompleteTextView.getText().toString() : "");
            this.I = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.J);
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(this.I);
            autoCompleteTextView2.setOnItemClickListener(new u(autoCompleteTextView2, textView, autoCompleteTextView, editText));
            imageView2.setOnClickListener(new v(autoCompleteTextView, autoCompleteTextView2, textView));
            imageView.setOnClickListener(new b(autoCompleteTextView2, editText, textView));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new c());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new d());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.add_unit_item2));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new e(autoCompleteTextView, autoCompleteTextView2, editText, textView, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void G(String str) {
        this.y.getFilter().filter(str);
    }

    public void H() {
        new Thread(new s()).start();
    }

    public void J(String str, String str2, String str3, String str4) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_unit_item, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.item_name);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.unit_name);
            EditText editText = (EditText) viewInflate.findViewById(R.id.unit_val);
            TextView textView = (TextView) viewInflate.findViewById(R.id.base_unit);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_class_unit);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_class_item);
            this.e.Zc(this, autoCompleteTextView);
            this.e.Zc(this, autoCompleteTextView2);
            this.K = this.e.F6();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.K);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new j(autoCompleteTextView, autoCompleteTextView2));
            this.J = this.e.e9(autoCompleteTextView.getText() != null ? autoCompleteTextView.getText().toString() : "");
            this.I = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.J);
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(this.I);
            autoCompleteTextView2.setOnItemClickListener(new k(autoCompleteTextView2, editText));
            imageView2.setOnClickListener(new l(autoCompleteTextView, autoCompleteTextView2, textView));
            imageView.setOnClickListener(new m(autoCompleteTextView2, editText, textView));
            autoCompleteTextView.setText(str2);
            textView.setText(this.e.V6(autoCompleteTextView.getText().toString()));
            autoCompleteTextView2.setText(str3);
            editText.setText(str4);
            this.J = this.e.e9(autoCompleteTextView.getText() != null ? autoCompleteTextView.getText().toString() : "");
            this.I = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.J);
            autoCompleteTextView.setVisibility(8);
            imageView2.setVisibility(8);
            editText.requestFocus();
            editText.selectAll();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new n());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new o());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.change_unit_item2) + str2);
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new p(autoCompleteTextView, autoCompleteTextView2, editText, str, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void amount_add_btn(View view) {
        F();
    }

    public void no_result_btn(View view) {
        E();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.unit_item_list);
        I();
        try {
            TextView textView = (TextView) findViewById(R.id.item_name);
            TextView textView2 = (TextView) findViewById(R.id.unit_name);
            TextView textView3 = (TextView) findViewById(R.id.unit_val);
            TextView textView4 = (TextView) findViewById(R.id.base_unit);
            C0372Bn c0372Bn = C0372Bn.f;
            c0372Bn.a(this, textView);
            c0372Bn.a(this, textView2);
            c0372Bn.a(this, textView3);
            c0372Bn.a(this, textView4);
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
        try {
            if (getIntent().getStringExtra("item_name") != null) {
                this.H = getIntent().getStringExtra("item_name");
            }
        } catch (Exception unused2) {
        }
        E();
        this.w.setChoiceMode(3);
        this.w.setMultiChoiceModeListener(new a());
        try {
            if (this.H.equals(CSS.Value.PERCENTAGE) || getIntent().getStringExtra("action_type") == null || !getIntent().getStringExtra("action_type").equals("1")) {
                return;
            }
            F();
        } catch (Exception unused3) {
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new q());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.print) {
            this.F = getTitle().toString();
            H();
            return true;
        }
        if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        E();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void z(ArrayList arrayList, AutoCompleteTextView autoCompleteTextView, TextView textView, TextView textView2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        builder.setItems(strArr, new i(autoCompleteTextView, strArr, textView, textView2));
        builder.show();
    }
}
