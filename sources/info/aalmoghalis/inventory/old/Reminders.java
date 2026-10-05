package info.aalmoghalis.inventory.old;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.format.DateFormat;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import defpackage.C4145vh;
import defpackage.FE;
import defpackage.XJ;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Reminders extends BaseActivity implements FE {
    public XJ A;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public TextView L;
    public TextView M;
    public EditText N;
    public SQLiteDatabase d;
    public Z00 e;
    public String f;
    public String c = Reminders.class.getSimpleName();
    public String g = null;
    public double h = 0.0d;
    public int i = 0;
    public int j = 0;
    public AutoCompleteTextView k = null;
    public EditText l = null;
    public EditText n = null;
    public TextView p = null;
    public ImageView q = null;
    public TextView t = null;
    public TextView u = null;
    public TextView v = null;
    public TextView w = null;
    public Button x = null;
    public RecyclerView y = null;
    public LinearLayout z = null;
    public ArrayList B = new ArrayList();
    public ImageButton C = null;
    public Toolbar D = null;
    public DatePickerDialog.OnDateSetListener J = new k();
    public TimePickerDialog.OnTimeSetListener K = new l();

    public class a implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ AlertDialog c;

        public a(AutoCompleteTextView autoCompleteTextView, EditText editText, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = editText;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (Reminders.this.e.u3(this.a.getText().toString()) == 0) {
                Toast.makeText(Reminders.this, R.string.cus_not_found, 1).show();
                zA = false;
            }
            if (zA) {
                Reminders.this.e.v0("insert into reminders  (cus_id,date_,time_,remarks )  values( (select id from customers where name='" + this.a.getText().toString() + "'),'" + Reminders.this.L.getText().toString() + "','" + Reminders.this.M.getText().toString() + "','" + this.b.getText().toString() + "'  )");
                Reminders.this.I(1);
                Reminders.this.e.Lc("reminder_data_changed", "1");
                Reminders reminders = Reminders.this;
                reminders.e.Qc(reminders);
                this.c.dismiss();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Reminders.this.showDialog(3);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Reminders.this.showDialog(4);
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
        public final /* synthetic */ EditText b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlertDialog d;

        public g(AutoCompleteTextView autoCompleteTextView, EditText editText, String str, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = editText;
            this.c = str;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (Reminders.this.e.u3(this.a.getText().toString()) == 0) {
                Toast.makeText(Reminders.this, R.string.cus_not_found, 1).show();
                zA = false;
            }
            if (zA) {
                Reminders.this.e.v0("update reminders  set cus_id = (select id from customers where name='" + this.a.getText().toString() + "'),date_='" + Reminders.this.L.getText().toString() + "',time_='" + Reminders.this.M.getText().toString() + "',remarks='" + this.b.getText().toString() + "',flag=0   where id='" + this.c + "'");
                Reminders.this.e.Lc("reminder_data_changed", "1");
                Reminders reminders = Reminders.this;
                reminders.e.Qc(reminders);
                Reminders.this.I(1);
            }
            this.d.dismiss();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ AlertDialog f;

        public j(EditText editText, String str, int i, String str2, String str3, AlertDialog alertDialog) {
            this.a = editText;
            this.b = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a)) {
                if (this.b != null) {
                    Reminders.this.e.v0("update customers set gsm='" + this.a.getText().toString() + "' where id='" + this.b + "'");
                    Reminders.this.f = this.a.getText().toString();
                    int i = this.c;
                    if (i == 4) {
                        Reminders.this.e.Rc(this.a.getText().toString(), Reminders.this.e.yd(this.d, this.e, this.c));
                    } else if (i == 3) {
                        Reminders.this.e.Ed(this.a.getText().toString(), Reminders.this.e.yd(this.d, this.e, this.c));
                    } else if (i == 5) {
                        Reminders.this.e.n0(this.a.getText().toString());
                    }
                    Reminders.this.I(0);
                }
                this.f.dismiss();
            }
        }
    }

    public class k implements DatePickerDialog.OnDateSetListener {
        public k() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Reminders.this.E = i;
            Reminders.this.F = i2;
            Reminders.this.G = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Reminders.this.E)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Reminders.this.F + 1)) + "-" + Reminders.this.G;
                Locale locale = Locale.ENGLISH;
                Reminders.this.L.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class l implements TimePickerDialog.OnTimeSetListener {
        public l() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Reminders.this.H = i;
            Reminders.this.I = i2;
            TextView textView = Reminders.this.M;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.ENGLISH;
            sb.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Reminders.this.H)));
            sb.append(":");
            sb.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Reminders.this.I)));
            textView.setText(sb.toString());
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public final /* synthetic */ C2054dh a;

        public m(C2054dh c2054dh) {
            this.a = c2054dh;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Reminders.this.e.v0("delete from reminders where id=" + this.a.b);
                Reminders.this.I(1);
            } catch (Exception unused) {
                Toast.makeText(Reminders.this.getApplicationContext(), "SQL Error.", 1);
            }
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
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Reminders.this.showDialog(3);
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Reminders.this.showDialog(4);
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

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private boolean J(int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= i2 && i4 <= i3;
    }

    private boolean K() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && J(21, 22);
    }

    private void N() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void H() {
        this.A = new XJ(this, this.B, this.e, this);
        this.y.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.y.setAdapter(this.A);
    }

    public void I(int i2) {
        String str = this.g;
        Cursor cursorZ7 = str != null ? this.e.Z7(i2, str) : this.e.Y7(i2);
        cursorZ7.getCount();
        this.h = 0.0d;
        this.B.clear();
        cursorZ7.moveToFirst();
        while (!cursorZ7.isAfterLast()) {
            this.B.add(new C2054dh(cursorZ7.getString(cursorZ7.getColumnIndex("_id")), cursorZ7.getString(cursorZ7.getColumnIndex("name")), cursorZ7.getString(cursorZ7.getColumnIndex("gsm")), cursorZ7.getString(cursorZ7.getColumnIndex("remarks")), cursorZ7.getInt(cursorZ7.getColumnIndex("flag")), cursorZ7.getString(cursorZ7.getColumnIndex("date_")), this.e.nc(cursorZ7.getString(cursorZ7.getColumnIndex("time_")))));
            cursorZ7.moveToNext();
        }
        cursorZ7.close();
        H();
    }

    public void L() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer_7, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_name);
            this.L = (TextView) viewInflate.findViewById(R.id.date_);
            this.M = (TextView) viewInflate.findViewById(R.id.time_);
            EditText editText = (EditText) viewInflate.findViewById(R.id.remarks);
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, 1);
            Locale locale = Locale.ENGLISH;
            this.L.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(calendar.getTime()));
            this.E = calendar.get(1);
            this.F = calendar.get(2);
            this.G = calendar.get(5);
            this.H = calendar.get(11);
            this.I = calendar.get(12);
            this.M.setText(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(this.H)) + ":" + String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(this.I)));
            this.e.Zc(this, autoCompleteTextView);
            this.e.ad(this, editText);
            this.L.setOnClickListener(new o());
            this.M.setOnClickListener(new p());
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.w4());
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setOnItemClickListener(new q(autoCompleteTextView));
            String str = this.g;
            if (str != null) {
                autoCompleteTextView.setText(str);
                editText.requestFocus();
            } else {
                autoCompleteTextView.requestFocus();
            }
            builder.setPositiveButton(getString(R.string.resourceID_OK), new r());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new s());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.add_reminder));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new a(autoCompleteTextView, editText, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void M(String str, String str2) {
        try {
            Locale locale = Locale.ENGLISH;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
            new SimpleDateFormat("yyyy-MM-dd", locale);
            Date date = simpleDateFormat.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            this.G = calendar.get(5);
            this.F = calendar.get(2);
            this.E = calendar.get(1);
            String[] strArrSplit = str2.split(":");
            if (strArrSplit.length > 0) {
                this.H = Integer.parseInt(strArrSplit[0]);
                this.I = Integer.parseInt(strArrSplit[1]);
            }
        } catch (Exception unused) {
        }
    }

    public void O(String str, String str2, String str3, String str4, int i2) {
        try {
            FragmentStatePagerSupport_Main.a0 = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.cus_name);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_class);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            editText.setText(str2);
            editText2.setText(str3);
            this.N = editText2;
            editText2.requestFocus();
            autoCompleteTextView.setVisibility(8);
            imageView.setVisibility(8);
            builder.setPositiveButton(getString(R.string.resourceID_OK), new h());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new i());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new j(editText2, str, i2, str2, str4, alertDialogCreate));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void P(String str, String str2, String str3, String str4, String str5) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_customer_7, (ViewGroup) null);
            builder.setView(viewInflate);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_name);
            this.L = (TextView) viewInflate.findViewById(R.id.date_);
            this.M = (TextView) viewInflate.findViewById(R.id.time_);
            EditText editText = (EditText) viewInflate.findViewById(R.id.remarks);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.e.w4());
            autoCompleteTextView.setText(str);
            this.L.setText(str2);
            this.M.setText(str3);
            editText.setText(str4);
            this.e.Zc(this, autoCompleteTextView);
            this.e.ad(this, editText);
            M(str2, str3);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(arrayAdapter);
            this.L.setOnClickListener(new b());
            this.M.setOnClickListener(new c());
            autoCompleteTextView.setOnItemClickListener(new d(autoCompleteTextView));
            editText.requestFocus();
            builder.setPositiveButton(getString(R.string.resourceID_OK), new e());
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new f());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(R.string.change_reminder));
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new g(autoCompleteTextView, editText, str5, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void amount_add_btn(View view) {
        L();
    }

    @Override // defpackage.FE
    public void g(int i2, C2054dh c2054dh) {
        if (i2 == 1) {
            P(c2054dh.c, c2054dh.g, c2054dh.h, c2054dh.e, c2054dh.b);
            return;
        }
        if (i2 == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.delete_msg));
            builder.setPositiveButton(getString(R.string.confirm_yes), new m(c2054dh));
            builder.setNegativeButton(getString(R.string.confirm_no), new n());
            builder.create().show();
            return;
        }
        if (i2 == 3) {
            this.e.v0("update reminders set flag=2 where id=" + c2054dh.b);
            if (c2054dh.d.length() < 3) {
                O(this.e.q4(c2054dh.c).i(), c2054dh.c, c2054dh.d, c2054dh.e, i2);
                return;
            }
            Z00 z00 = this.e;
            z00.Ed(c2054dh.d, z00.yd(c2054dh.c, c2054dh.e, i2));
            I(0);
            return;
        }
        if (i2 == 4) {
            this.e.v0("update reminders set flag=2 where id=" + c2054dh.b);
            if (c2054dh.d.length() < 3) {
                O(this.e.q4(c2054dh.c).i(), c2054dh.c, c2054dh.d, c2054dh.e, i2);
                return;
            }
            Z00 z01 = this.e;
            z01.Rc(c2054dh.d, z01.yd(c2054dh.c, c2054dh.e, i2));
            I(0);
            return;
        }
        if (i2 == 5) {
            this.e.v0("update reminders set flag=2 where id=" + c2054dh.b);
            if (c2054dh.d.length() < 3) {
                O(this.e.q4(c2054dh.c).i(), c2054dh.c, c2054dh.d, c2054dh.e, i2);
            } else {
                this.e.n0(c2054dh.d);
                I(0);
            }
        }
    }

    public void no_result_btn(View view) {
        I(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != 0 && i2 == 1 && i3 == -1) {
            try {
                Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                this.N.setText(string);
                cursorQuery.close();
            } catch (Exception e2) {
                Toast.makeText(this, e2.getMessage(), 1).show();
            }
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_reminders);
        N();
        try {
            this.y = (RecyclerView) findViewById(R.id.idRVCourse);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception unused) {
        }
        this.e = new Z00(this.d, this);
        try {
            if (getIntent().getStringExtra("cus_name") != null) {
                this.g = getIntent().getStringExtra("cus_name");
                I(1);
                this.e.v0("update reminders set flag=1 where flag=0 and  datetime(strftime('%Y-%m-%d %H:%M',date_||' '||time_))<= datetime( strftime('%Y-%m-%d %H:%M',datetime('now','localtime') )) and cus_id=(select id from customers where name='" + this.g + "') ");
            } else {
                I(0);
                this.e.v0("update reminders set flag=1 where flag=0 and  datetime(strftime('%Y-%m-%d %H:%M',date_||' '||time_))<= datetime( strftime('%Y-%m-%d %H:%M',datetime('now','localtime') ))");
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 3) {
            return new DatePickerDialog(K() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.J, this.E, this.F, this.G);
        }
        if (i2 != 4) {
            return null;
        }
        ContextThemeWrapper contextThemeWrapper = K() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this;
        return new TimePickerDialog(contextThemeWrapper, this.K, this.H, this.I, DateFormat.is24HourFormat(contextThemeWrapper));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main7, menu);
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
            L();
            return true;
        }
        if (itemId != R.id.menu_all) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.g = null;
        I(1);
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        I(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }

    @Override // defpackage.FE
    public void j(int i2, C4145vh c4145vh) {
    }
}
