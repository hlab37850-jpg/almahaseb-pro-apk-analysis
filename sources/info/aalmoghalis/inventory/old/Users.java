package info.aalmoghalis.inventory.old;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.format.DateFormat;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import defpackage.AbstractC4371yX;
import defpackage.C2054dh;
import defpackage.C2118eX;
import defpackage.C2160f10;
import defpackage.C3112j2;
import defpackage.C3172jj;
import defpackage.C3254kj;
import defpackage.C4145vh;
import defpackage.FE;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Users extends BaseActivity implements FE {
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public C3112j2 I;
    public TextView L;
    public TextView M;
    public ArrayAdapter N;
    public ArrayAdapter O;
    public EditText P;
    public SQLiteDatabase d;
    public Z00 e;
    public C2118eX z;
    public String c = Users.class.getSimpleName();
    public String f = null;
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
    public RecyclerView x = null;
    public LinearLayout y = null;
    public ArrayList A = new ArrayList();
    public ImageButton B = null;
    public Toolbar C = null;
    public DatePickerDialog.OnDateSetListener J = new j();
    public TimePickerDialog.OnTimeSetListener K = new k();

    public class a implements View.OnClickListener {
        public final /* synthetic */ C3254kj a;

        public a(C3254kj c3254kj) {
            this.a = c3254kj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Users users = Users.this;
            users.H(users.N, this.a.c, 1);
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
        public final /* synthetic */ C3254kj a;
        public final /* synthetic */ AlertDialog b;

        public d(C3254kj c3254kj, AlertDialog alertDialog) {
            this.a = c3254kj;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a.g);
            if (!AbstractC4371yX.a(this.a.g)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.a.h)) {
                zA = false;
            }
            if (!AbstractC4371yX.c(this.a.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.c(this.a.c)) {
                zA = false;
            }
            if (zA) {
                Z00 z00 = Users.this.e;
                StringBuilder sb = new StringBuilder();
                sb.append("insert into users  (name,user_name,pwd,br_id,cash_id,is_active )  values( '");
                sb.append(this.a.g.getText().toString());
                sb.append("','");
                sb.append(this.a.g.getText().toString());
                sb.append("','");
                sb.append(new C2160f10().f(this.a.h.getText().toString()));
                sb.append("',ifnull((select id from branches where name='");
                sb.append(this.a.b.getText().toString());
                sb.append("'),0),ifnull((select id from customers where name='");
                sb.append(this.a.c.getText().toString());
                sb.append("'),-3),");
                sb.append(this.a.f.isChecked() ? "1" : 0);
                sb.append("  )");
                String strK = z00.K(sb.toString());
                if (strK != null && strK.equals("1")) {
                    Users.this.J();
                    this.b.dismiss();
                    return;
                }
                Users users = Users.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strK != null && strK.length() > 20) {
                    strK = strK.substring(0, 20);
                }
                sb2.append(strK);
                Toast.makeText(users, sb2.toString(), 0).show();
            }
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ C3254kj a;

        public e(C3254kj c3254kj) {
            this.a = c3254kj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Users users = Users.this;
            users.e.T(users, users.O, this.a.b);
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ C3254kj a;

        public f(C3254kj c3254kj) {
            this.a = c3254kj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Users users = Users.this;
            users.e.T(users, users.N, this.a.c);
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
        public final /* synthetic */ C3254kj a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AlertDialog c;

        public i(C3254kj c3254kj, String str, AlertDialog alertDialog) {
            this.a = c3254kj;
            this.b = str;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a.g);
            if (!AbstractC4371yX.a(this.a.g)) {
                zA = false;
            }
            if (this.a.f.isChecked() && !AbstractC4371yX.a(this.a.h)) {
                zA = false;
            }
            if (!AbstractC4371yX.c(this.a.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.c(this.a.c)) {
                zA = false;
            }
            if (zA) {
                Z00 z00 = Users.this.e;
                StringBuilder sb = new StringBuilder();
                sb.append("update users  set cash_id = (select id from customers where name='");
                sb.append(this.a.c.getText().toString());
                sb.append("'),br_id=(select id from branches where name='");
                sb.append(this.a.b.getText().toString());
                sb.append("'),pwd='");
                sb.append(new C2160f10().f(this.a.h.getText().toString()));
                sb.append("',name='");
                sb.append(this.a.g.getText().toString());
                sb.append("',user_name='");
                sb.append(this.a.g.getText().toString());
                sb.append("',is_active='");
                sb.append(this.a.f.isChecked() ? "1" : "0");
                sb.append("'  where id='");
                sb.append(this.b);
                sb.append("'");
                String strK = z00.K(sb.toString());
                if (strK != null && strK.equals("1")) {
                    Users.this.J();
                    this.c.dismiss();
                    return;
                }
                Users users = Users.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strK != null && strK.length() > 20) {
                    strK = strK.substring(0, 20);
                }
                sb2.append(strK);
                Toast.makeText(users, sb2.toString(), 0).show();
            }
        }
    }

    public class j implements DatePickerDialog.OnDateSetListener {
        public j() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Users.this.D = i;
            Users.this.E = i2;
            Users.this.F = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Users.this.D)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Users.this.E + 1)) + "-" + Users.this.F;
                Locale locale = Locale.ENGLISH;
                Users.this.L.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class k implements TimePickerDialog.OnTimeSetListener {
        public k() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Users.this.G = i;
            Users.this.H = i2;
            TextView textView = Users.this.M;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.ENGLISH;
            sb.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Users.this.G)));
            sb.append(":");
            sb.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Users.this.H)));
            textView.setText(sb.toString());
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public final /* synthetic */ C4145vh a;

        public l(C4145vh c4145vh) {
            this.a = c4145vh;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                String strK = Users.this.e.K("delete from users where id=" + this.a.v());
                if (strK == null || !strK.equals("1")) {
                    Users users = Users.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error:");
                    if (strK != null && strK.length() > 20) {
                        strK = strK.substring(0, 20);
                    }
                    sb.append(strK);
                    Toast.makeText(users, sb.toString(), 0).show();
                }
                Users.this.J();
            } catch (Exception unused) {
                Toast.makeText(Users.this.getApplicationContext(), "SQL Error.", 1);
            }
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

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class p implements View.OnClickListener {
        public final /* synthetic */ C3172jj a;
        public final /* synthetic */ int b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ AlertDialog d;

        public p(C3172jj c3172jj, int i, TextView textView, AlertDialog alertDialog) {
            this.a = c3172jj;
            this.b = i;
            this.c = textView;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (AbstractC4371yX.a(this.a.b)) {
                int i = this.b;
                if (i == 1) {
                    str = "insert into customers (name,gsm,address,acc_p_id,g_id) values('" + this.a.b.getText().toString().trim() + "','','','121',0 ) ";
                } else if (i == 2) {
                    str = "insert into branches (name) values('" + this.a.b.getText().toString().trim() + "' ) ";
                } else {
                    str = "";
                }
                String strK = Users.this.e.K(str);
                if (strK != null && strK.equals("1")) {
                    Users.this.O();
                    this.c.setText(this.a.b.getText().toString().trim());
                    this.d.dismiss();
                    return;
                }
                Users users = Users.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Error:");
                if (strK != null && strK.length() > 20) {
                    strK = strK.substring(0, 20);
                }
                sb.append(strK);
                Toast.makeText(users, sb.toString(), 0).show();
            }
        }
    }

    public class q implements AdapterView.OnItemClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ int b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ Dialog d;

        public q(ArrayAdapter arrayAdapter, int i, TextView textView, Dialog dialog) {
            this.a = arrayAdapter;
            this.b = i;
            this.c = textView;
            this.d = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (i == this.a.getCount() - 1) {
                Users.this.M(this.b, this.c);
            } else {
                this.c.setText(adapterView.getItemAtPosition(i).toString());
                this.c.setTag(adapterView.getItemAtPosition(i).toString());
            }
            this.d.dismiss();
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ C3254kj a;

        public r(C3254kj c3254kj) {
            this.a = c3254kj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Users users = Users.this;
            users.H(users.O, this.a.b, 2);
        }
    }

    private boolean K(int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= i2 && i4 <= i3;
    }

    private boolean L() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && K(21, 22);
    }

    private void P() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void H(ArrayAdapter arrayAdapter, TextView textView, int i2) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new q(arrayAdapter, i2, textView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public void I() {
        this.z = new C2118eX(this, this.A, this.e, this);
        this.x.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.x.setAdapter(this.z);
    }

    public void J() {
        Cursor cursorM = new C2160f10(this.e).M();
        cursorM.getCount();
        this.g = 0.0d;
        this.A.clear();
        cursorM.moveToFirst();
        while (!cursorM.isAfterLast()) {
            this.A.add(new C4145vh(cursorM.getString(cursorM.getColumnIndex("_id")), cursorM.getString(cursorM.getColumnIndex("name")), cursorM.getString(cursorM.getColumnIndex("user_name")), cursorM.getString(cursorM.getColumnIndex("branch_name")), cursorM.getString(cursorM.getColumnIndex("cash_name")), cursorM.getString(cursorM.getColumnIndex("is_active"))));
            cursorM.moveToNext();
        }
        cursorM.close();
        I();
    }

    public void M(int i2, TextView textView) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C3172jj c3172jjC = C3172jj.c(getLayoutInflater());
            builder.setView(c3172jjC.getRoot());
            this.e.Zc(this, c3172jjC.b);
            c3172jjC.b.requestFocus();
            if (i2 == 1) {
                c3172jjC.b.setHint(getString(R.string.cash_name));
            } else if (i2 == 2) {
                c3172jjC.b.setHint(getString(R.string.branch));
            }
            builder.setPositiveButton(getString(R.string.resourceID_OK), new n());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new o());
            AlertDialog alertDialogCreate = builder.create();
            if (i2 == 1) {
                alertDialogCreate.setTitle(getString(R.string.add_cash));
            } else if (i2 == 2) {
                alertDialogCreate.setTitle(getString(R.string.add_branch));
            }
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new p(c3172jjC, i2, textView, alertDialogCreate));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void N() {
        try {
            if (new C2160f10(this.e).u() == 0) {
                Toast.makeText(this, getString(R.string.activate_admin), 0).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C3254kj c3254kjC = C3254kj.c(getLayoutInflater());
            builder.setView(c3254kjC.getRoot());
            this.e.ad(this, c3254kjC.g);
            this.e.ad(this, c3254kjC.g);
            this.e.ad(this, c3254kjC.h);
            c3254kjC.f.setChecked(true);
            c3254kjC.g.requestFocus();
            O();
            TextView textView = c3254kjC.b;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            TextView textView2 = c3254kjC.c;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            c3254kjC.b.setOnClickListener(new r(c3254kjC));
            c3254kjC.c.setOnClickListener(new a(c3254kjC));
            if (this.N.getCount() > 1) {
                c3254kjC.c.setText((CharSequence) this.N.getItem(0));
            }
            if (this.O.getCount() > 1) {
                c3254kjC.b.setText((CharSequence) this.O.getItem(0));
            }
            builder.setPositiveButton(getString(R.string.resourceID_OK), new b());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new c());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.add_user));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new d(c3254kjC, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public final void O() {
        this.N = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.E3("-1"));
        this.O = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.B2("-1"));
    }

    public void Q(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C3254kj c3254kjC = C3254kj.c(getLayoutInflater());
            builder.setView(c3254kjC.getRoot());
            c3254kjC.g.setText(str);
            c3254kjC.g.setText(str2);
            c3254kjC.b.setText(str3);
            c3254kjC.c.setText(str4);
            c3254kjC.f.setChecked(str5.equals("1"));
            this.e.ad(this, c3254kjC.g);
            this.e.ad(this, c3254kjC.g);
            this.e.ad(this, c3254kjC.h);
            c3254kjC.h.requestFocus();
            O();
            TextView textView = c3254kjC.b;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            TextView textView2 = c3254kjC.c;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            c3254kjC.b.setOnClickListener(new e(c3254kjC));
            c3254kjC.c.setOnClickListener(new f(c3254kjC));
            builder.setPositiveButton(getString(R.string.resourceID_OK), new g());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new h());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.edit_user));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new i(c3254kjC, str6, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void amount_add_btn(View view) {
        N();
    }

    @Override // defpackage.FE
    public void j(int i2, C4145vh c4145vh) {
        if (i2 == 1) {
            Q(c4145vh.a(), c4145vh.n(), c4145vh.o(), c4145vh.p(), c4145vh.q(), c4145vh.v());
            return;
        }
        if (i2 == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.delete_msg));
            builder.setPositiveButton(getString(R.string.confirm_yes), new l(c4145vh));
            builder.setNegativeButton(getString(R.string.confirm_no), new m());
            builder.create().show();
        }
    }

    public void no_result_btn(View view) {
        J();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != 0 && i2 == 1 && i3 == -1) {
            try {
                Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                this.P.setText(string);
                cursorQuery.close();
            } catch (Exception e2) {
                Toast.makeText(this, e2.getMessage(), 1).show();
            }
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3112j2 c3112j2C = C3112j2.c(getLayoutInflater());
        this.I = c3112j2C;
        setContentView(c3112j2C.getRoot());
        P();
        try {
            this.x = this.I.b;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        Z00 z00 = new Z00(this.d, this);
        this.e = z00;
        z00.w0("PRAGMA foreign_keys = ON");
        J();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 3) {
            return new DatePickerDialog(L() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.J, this.D, this.E, this.F);
        }
        if (i2 != 4) {
            return null;
        }
        ContextThemeWrapper contextThemeWrapper = L() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this;
        return new TimePickerDialog(contextThemeWrapper, this.K, this.G, this.H, DateFormat.is24HourFormat(contextThemeWrapper));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main7, menu);
        menu.findItem(R.id.menu_all).setVisible(false);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_add) {
            N();
            return true;
        }
        if (itemId != R.id.menu_all) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f = null;
        J();
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        J();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    @Override // defpackage.FE
    public void g(int i2, C2054dh c2054dh) {
    }
}
