package info.aalmoghalis.inventory.old;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
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
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C2037dX;
import defpackage.C2160f10;
import defpackage.C3112j2;
import defpackage.C4145vh;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class UserPriv extends BaseActivity {
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public C3112j2 I;
    public TextView L;
    public TextView M;
    public EditText N;
    public SQLiteDatabase d;
    public Z00 e;
    public C2037dX z;
    public String c = UserPriv.class.getSimpleName();
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
    public DatePickerDialog.OnDateSetListener J = new a();
    public TimePickerDialog.OnTimeSetListener K = new b();

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            UserPriv.this.D = i;
            UserPriv.this.E = i2;
            UserPriv.this.F = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(UserPriv.this.D)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(UserPriv.this.E + 1)) + "-" + UserPriv.this.F;
                Locale locale = Locale.ENGLISH;
                UserPriv.this.L.setText(new SimpleDateFormat("yyyy-MM-dd", locale).format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd", locale).parse(str).getTime())));
            } catch (Exception unused) {
            }
        }
    }

    public class b implements TimePickerDialog.OnTimeSetListener {
        public b() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            UserPriv.this.G = i;
            UserPriv.this.H = i2;
            TextView textView = UserPriv.this.M;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.ENGLISH;
            sb.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(UserPriv.this.G)));
            sb.append(":");
            sb.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(UserPriv.this.H)));
            textView.setText(sb.toString());
        }
    }

    private boolean J(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean K() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && J(21, 22);
    }

    private void L() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public ArrayList G() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorN = new C2160f10(this.e).N(this.h + "");
        cursorN.getCount();
        this.g = 0.0d;
        cursorN.moveToFirst();
        while (!cursorN.isAfterLast()) {
            arrayList.add(new C4145vh(cursorN.getString(cursorN.getColumnIndex("_id")), cursorN.getString(cursorN.getColumnIndex("screen_name")), cursorN.getString(cursorN.getColumnIndex("new")), cursorN.getString(cursorN.getColumnIndex("edit")), cursorN.getString(cursorN.getColumnIndex("view")), cursorN.getString(cursorN.getColumnIndex(HTML.Tag.DEL))));
            cursorN.moveToNext();
        }
        cursorN.close();
        return arrayList;
    }

    public void H() {
        this.z = new C2037dX(this, this.A, this.e);
        this.x.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.x.setAdapter(this.z);
    }

    public void I() {
        this.A.clear();
        this.A = G();
        H();
    }

    public void amount_add_btn(View view) {
    }

    public void no_result_btn(View view) {
        I();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != 0 && i == 1 && i2 == -1) {
            try {
                Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, null, null, null);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                this.N.setText(string);
                cursorQuery.close();
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), 1).show();
            }
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3112j2 c3112j2C = C3112j2.c(getLayoutInflater());
        this.I = c3112j2C;
        setContentView(c3112j2C.getRoot());
        L();
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
        this.e = new Z00(this.d, this);
        if (getIntent().getStringExtra("TR_ID") != null) {
            this.h = Integer.parseInt(getIntent().getStringExtra("TR_ID"));
        }
        if (getIntent().getStringExtra("TR_NAME") != null) {
            setTitle(getString(R.string.privs) + " : " + getIntent().getStringExtra("TR_NAME"));
        }
        I();
        if (this.h == 0) {
            Toast.makeText(this, getString(R.string.update_admin), 0).show();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 3) {
            return new DatePickerDialog(K() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this, this.J, this.D, this.E, this.F);
        }
        if (i != 4) {
            return null;
        }
        ContextThemeWrapper contextThemeWrapper = K() ? new ContextThemeWrapper(this, android.R.style.Theme.Holo.Light.Dialog) : this;
        return new TimePickerDialog(contextThemeWrapper, this.K, this.G, this.H, DateFormat.is24HourFormat(contextThemeWrapper));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main7, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_all);
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_add);
        menuItemFindItem.setVisible(false);
        menuItemFindItem2.setVisible(false);
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
            return true;
        }
        if (itemId != R.id.menu_all) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f = null;
        I();
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        I();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void phone_pick_btn(View view) {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1);
    }
}
