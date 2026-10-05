package info.aalmoghalis.inventory.old;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
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
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4371yX;
import defpackage.C0922Sv;
import defpackage.C1098Yv;
import defpackage.C2160f10;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CusLimit_edit extends BaseActivity {
    public SparseBooleanArray B;
    public SQLiteDatabase d;
    public Z00 e;
    public String f;
    public C0922Sv z;
    public String c = CusLimit_edit.class.getSimpleName();
    public double g = 0.0d;
    public int h = 0;
    public int i = 0;
    public AutoCompleteTextView j = null;
    public EditText k = null;
    public EditText l = null;
    public TextView n = null;
    public ImageView p = null;
    public TextView q = null;
    public TextView t = null;
    public TextView u = null;
    public TextView v = null;
    public Button w = null;
    public ListView x = null;
    public LinearLayout y = null;
    public ArrayList A = new ArrayList();
    public ImageButton C = null;
    public String[] D = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public int[] E = {R.drawable.up, 1, R.drawable.down};
    public Toolbar F = null;
    public int G = -1;
    public String H = "";
    public String I = "";
    public String J = "";
    public String K = "";
    public String L = null;
    public String M = null;
    public RadioGroup N = null;
    public ArrayList O = new ArrayList();
    public AutoCompleteTextView P = null;
    public ImageView Q = null;

    public class a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.old.CusLimit_edit$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0315a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0315a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    CusLimit_edit.this.y();
                } catch (Exception unused) {
                    Toast.makeText(CusLimit_edit.this.getApplicationContext(), "SQL Error.", 1);
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
                    SparseBooleanArray sparseBooleanArrayC = CusLimit_edit.this.z.c();
                    CusLimit_edit cusLimit_edit = CusLimit_edit.this;
                    cusLimit_edit.B = sparseBooleanArrayC;
                    AlertDialog.Builder builder = new AlertDialog.Builder(cusLimit_edit);
                    builder.setMessage(CusLimit_edit.this.getString(R.string.delete_msg));
                    builder.setPositiveButton(CusLimit_edit.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0315a());
                    builder.setNegativeButton(CusLimit_edit.this.getString(R.string.confirm_no), new b());
                    builder.create().show();
                    actionMode.finish();
                    break;
                case R.id.menu_edit /* 2131297040 */:
                    SparseBooleanArray sparseBooleanArrayC2 = CusLimit_edit.this.z.c();
                    CusLimit_edit cusLimit_edit2 = CusLimit_edit.this;
                    cusLimit_edit2.B = sparseBooleanArrayC2;
                    cusLimit_edit2.z();
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
            CusLimit_edit.this.x.setBackgroundColor(Color.parseColor("#FFFFFF"));
            CusLimit_edit.this.z.l.clear();
            CusLimit_edit.this.z.h();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = CusLimit_edit.this.x.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            CusLimit_edit.this.z.l(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (CusLimit_edit.this.x.getCheckedItemCount() != 1) {
                menu.findItem(R.id.menu_edit).setVisible(false);
            } else {
                menu.findItem(R.id.menu_delete).setVisible(true);
                menu.findItem(R.id.menu_edit).setVisible(true);
            }
            return false;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ android.app.AlertDialog a;

        public b(android.app.AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ EditText c;

        public c(AutoCompleteTextView autoCompleteTextView, String[] strArr, EditText editText) {
            this.a = autoCompleteTextView;
            this.b = strArr;
            this.c = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setText(this.b[i]);
            this.a.dismissDropDown();
            this.c.requestFocus();
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
        public final /* synthetic */ String d;
        public final /* synthetic */ AlertDialog e;

        public f(AutoCompleteTextView autoCompleteTextView, EditText editText, EditText editText2, String str, AlertDialog alertDialog) {
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
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            if (CusLimit_edit.this.N.getTag() != null ? zA : false) {
                CusLimit_edit.this.e.v0("update " + CusLimit_edit.this.I + "  set cus_id =(select id from customers where name= '" + this.a.getText().toString().trim() + "') ,curr_id=(select id from currency where name='" + CusLimit_edit.this.N.getTag().toString() + "') ,cr=abs(" + this.b.getText().toString() + ") ,db=abs(" + this.c.getText().toString() + ")  where id='" + this.d + "'");
                CusLimit_edit.this.C();
                this.e.dismiss();
            }
        }
    }

    public class g implements SearchView.OnQueryTextListener {
        public g() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Log.d("search=", "onQueryTextChange");
            TextUtils.isEmpty(str);
            CusLimit_edit.this.D(str);
            TextUtils.isEmpty(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CusLimit_edit.this.onRadioButtonClicked(view);
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            CusLimit_edit.this.P.setText(((C4145vh) adapterView.getItemAtPosition(i)).a());
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ EditText b;

        public j(ArrayList arrayList, EditText editText) {
            this.a = arrayList;
            this.b = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CusLimit_edit cusLimit_edit = CusLimit_edit.this;
            cusLimit_edit.x(this.a, cusLimit_edit.P, this.b);
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class m implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ android.app.AlertDialog c;

        public m(EditText editText, EditText editText2, android.app.AlertDialog alertDialog) {
            this.a = editText;
            this.b = editText2;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            boolean z = false;
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(CusLimit_edit.this.P)) {
                zA = false;
            }
            if (CusLimit_edit.this.N.getTag() == null) {
                zA = false;
            }
            CusLimit_edit cusLimit_edit = CusLimit_edit.this;
            if (cusLimit_edit.e.u3(cusLimit_edit.P.getText().toString()) != 0 || CusLimit_edit.this.P.getText().toString().trim().length() <= 0) {
                z = zA;
            } else {
                CusLimit_edit.this.P.setError("Not Found");
            }
            if (z) {
                CusLimit_edit.this.e.H("delete from cus_limit where cus_id=(select a.id from customers a where a.name='" + CusLimit_edit.this.P.getText().toString() + "') and curr_id=(select a.id from currency a where a.name='" + CusLimit_edit.this.N.getTag().toString() + "')", "insert into cus_limit(cus_id,curr_id,cr,db) values ((select a.id from customers a where a.name='" + CusLimit_edit.this.P.getText().toString() + "'),(select a.id from currency a where a.name='" + CusLimit_edit.this.N.getTag().toString() + "'),abs(" + this.a.getText().toString() + "),abs(" + this.b.getText().toString() + "))");
                CusLimit_edit.this.F();
                this.c.dismiss();
                CusLimit_edit.this.C();
                CusLimit_edit cusLimit_edit2 = CusLimit_edit.this;
                cusLimit_edit2.e.Kd(cusLimit_edit2, cusLimit_edit2.getString(R.string.done), 1000);
            }
        }
    }

    private void E() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void A() {
        try {
            ArrayList arrayListJ3 = this.e.j3();
            this.O = arrayListJ3;
            String str = this.L;
            if (str == null) {
                str = "";
            }
            this.L = str;
            int size = arrayListJ3.size();
            RadioButton[] radioButtonArr = new RadioButton[size];
            this.N.setTag(null);
            this.N.removeAllViews();
            this.N.clearCheck();
            for (int i2 = 0; i2 < this.O.size(); i2++) {
                RadioButton radioButton = new RadioButton(this);
                radioButtonArr[i2] = radioButton;
                radioButton.setText((CharSequence) ((HashMap) this.O.get(i2)).get("name"));
                radioButtonArr[i2].setId(Integer.parseInt((String) ((HashMap) this.O.get(i2)).get(HTML.Attribute.ID)) + 100);
                radioButtonArr[i2].setButtonDrawable(android.R.color.transparent);
                radioButtonArr[i2].setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this, android.R.drawable.btn_radio), (Drawable) null);
                radioButtonArr[i2].setOnClickListener(new h());
                this.N.addView(radioButtonArr[i2]);
                String str2 = this.M;
                if (str2 != null && str2.equals(((HashMap) this.O.get(i2)).get("name"))) {
                    this.N.check(radioButtonArr[i2].getId());
                    this.N.setTag(((HashMap) this.O.get(i2)).get("name"));
                    this.L = (String) ((HashMap) this.O.get(i2)).get("name");
                }
            }
            if (!this.L.equals("")) {
                this.N.setTag(this.L);
                for (int i3 = 0; i3 < size; i3++) {
                    if (radioButtonArr[i3].getText().toString().equals(this.L)) {
                        this.N.check(radioButtonArr[i3].getId());
                    }
                }
                return;
            }
            String str3 = this.M;
            if (str3 == null || str3.equals("")) {
                this.N.check(radioButtonArr[this.O.size() - 1].getId());
                this.N.setTag(radioButtonArr[this.O.size() - 1].getText().toString());
                this.L = radioButtonArr[this.O.size() - 1].getText().toString();
            }
        } catch (Exception e2) {
            Log.d("fill_curr_error=", e2.getMessage());
            e2.printStackTrace();
        }
    }

    public void B() {
        C0922Sv c0922Sv = new C0922Sv(this, R.layout.data_det_row_rep1_, this.A, 4);
        this.z = c0922Sv;
        c0922Sv.l.clear();
        this.z.notifyDataSetChanged();
        this.x.setAdapter((ListAdapter) this.z);
    }

    public void C() {
        CusLimit_edit cusLimit_edit = this;
        String str = cusLimit_edit.f;
        Cursor cursorV4 = str != null ? cusLimit_edit.e.v4(cusLimit_edit.I, str) : cusLimit_edit.e.u4(cusLimit_edit.I);
        Log.d("recCount=", cusLimit_edit.I + ":" + cursorV4.getCount());
        cusLimit_edit.g = 0.0d;
        cusLimit_edit.A.clear();
        cursorV4.moveToFirst();
        while (!cursorV4.isAfterLast()) {
            cusLimit_edit.A.add(new C4145vh(cursorV4.getString(cursorV4.getColumnIndex("_id")), cursorV4.getString(cursorV4.getColumnIndex("name")), cursorV4.getString(cursorV4.getColumnIndex("curr")), cusLimit_edit.e.P7(String.valueOf(cursorV4.getDouble(cursorV4.getColumnIndex("cr")))), cusLimit_edit.e.P7(String.valueOf(cursorV4.getDouble(cursorV4.getColumnIndex("db")))), "", "", "", "", "", "", "", ""));
            cursorV4.moveToNext();
            cusLimit_edit = this;
        }
        cursorV4.close();
        B();
    }

    public void D(String str) {
        C0922Sv c0922Sv = this.z;
        if (c0922Sv != null) {
            c0922Sv.getFilter().filter(str);
        }
    }

    public void G(String str, String str2, String str3, String str4, String str5) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_item4_, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            EditText editText = (EditText) viewInflate.findViewById(R.id.et_cr);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.et_db);
            this.N = (RadioGroup) viewInflate.findViewById(R.id.radiogroup_curr);
            this.M = str3;
            A();
            autoCompleteTextView.setHint(getString(R.string.account));
            this.e.Zc(this, autoCompleteTextView);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            autoCompleteTextView.setText(str2);
            editText.setText(str4);
            editText2.setText(str5);
            editText.requestFocus();
            editText.selectAll();
            editText2.selectAll();
            F();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new d());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new e());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.change_limit));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new f(autoCompleteTextView, editText, editText2, str, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void amount_add_btn(View view) {
        new_item_price(view);
    }

    public void new_item_price(View view) {
        try {
            if (C2160f10.h > 0 && !new C2160f10(this.e).l("31", "new")) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
                return;
            }
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(view.getContext());
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_item4_, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.et_cr);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.et_db);
            this.e.ad(this, editText);
            this.e.ad(this, editText2);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            this.P = autoCompleteTextView;
            String str = this.f;
            if (str != null) {
                autoCompleteTextView.setText(str);
            }
            this.e.cd(this, this.P);
            this.N = (RadioGroup) viewInflate.findViewById(R.id.radiogroup_curr);
            A();
            if (this.f != null) {
                editText.requestFocus();
            } else {
                this.P.requestFocus();
            }
            ArrayList arrayListX4 = this.e.x4();
            C1098Yv c1098Yv = new C1098Yv(this, R.layout.data_det_row_search, this.e.y4(), 4);
            c1098Yv.l.clear();
            c1098Yv.notifyDataSetChanged();
            this.P.setThreshold(1);
            this.P.setAdapter(c1098Yv);
            this.P.setOnItemClickListener(new i());
            imageView.setOnClickListener(new j(arrayListX4, editText));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new k());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new l());
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new m(editText, editText2, alertDialogCreate));
            alertDialogCreate.getButton(-2).setOnClickListener(new b(alertDialogCreate));
        } catch (Exception e2) {
            Log.d("add_item2_error=", e2.getMessage());
        }
    }

    public void no_result_btn(View view) {
        C();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.info_list3);
        E();
        try {
            TextView textView = (TextView) findViewById(R.id.f1);
            TextView textView2 = (TextView) findViewById(R.id.f2);
            TextView textView3 = (TextView) findViewById(R.id.f3);
            TextView textView4 = (TextView) findViewById(R.id.f4);
            ((ImageView) findViewById(R.id.import_excel)).setVisibility(8);
            setTitle(getString(R.string.cus_limit));
            this.I = "cus_limit";
            textView.setText(getString(R.string.account));
            textView2.setText(getString(R.string.currency));
            textView3.setText(getString(R.string.max_limit_cr));
            textView4.setText(getString(R.string.max_limit_db));
            this.G = 2;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        this.x = (ListView) findViewById(R.id.list_data);
        this.x.setEmptyView((TextView) findViewById(R.id.emptyResults));
        this.x.setChoiceMode(2);
        this.e = new Z00(this.d, this);
        try {
            if (getIntent().getStringExtra("cus_name") != null) {
                this.f = getIntent().getStringExtra("cus_name");
            } else {
                this.f = null;
            }
        } catch (Exception unused2) {
        }
        C();
        this.x.setChoiceMode(3);
        this.x.setMultiChoiceModeListener(new a());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu != null) {
            menu.clear();
        }
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new g());
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

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.N.setTag(radioButton.getText().toString());
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        C();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void x(ArrayList arrayList, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        builder.setItems(strArr, new c(autoCompleteTextView, strArr, editText));
        builder.show();
    }

    public void y() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("31", HTML.Tag.DEL)) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        for (int size = this.B.size() - 1; size >= 0; size--) {
            if (this.B.valueAt(size)) {
                C4145vh item = this.z.getItem(this.B.keyAt(size));
                this.z.remove(item);
                this.e.v0("delete from " + this.I + " where id=" + item.v() + "  ");
            }
        }
        C();
    }

    public void z() {
        if (C2160f10.h > 0 && !new C2160f10(this.e).l("31", "edit")) {
            Toast.makeText(this, getString(R.string.no_priv), 0).show();
            return;
        }
        int size = this.B.size() - 1;
        if (this.B.valueAt(size)) {
            C4145vh item = this.z.getItem(this.B.keyAt(size));
            G(item.v(), item.a(), item.n(), item.o().replaceAll(",", ""), item.p().replaceAll(",", ""));
        }
    }
}
