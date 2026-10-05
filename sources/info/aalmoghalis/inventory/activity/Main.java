package info.aalmoghalis.inventory.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.google.android.material.timepicker.TimeModel;
import defpackage.AbstractC2242g10;
import defpackage.AbstractC4032uI;
import defpackage.C3874sM;
import defpackage.C4062ug;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Main extends Menu_AppCompatActivity implements AdapterView.OnItemClickListener, info.aalmoghalis.inventory.activity.a.b, info.aalmoghalis.inventory.activity.c.g {
    public ArrayAdapter A;
    public String[] F;
    public TypedArray G;
    public String[] H;
    public TypedArray I;
    public List J;
    public C4062ug K;
    public String[] L;
    public TypedArray M;
    public List N;
    public C4062ug O;
    public CharSequence P;
    public CharSequence Q;
    public DrawerLayout R;
    public ListView S;
    public ActionBarDrawerToggle T;
    public List U;
    public C4062ug V;
    public SQLiteDatabase h;
    public Z00 i;
    public int j;
    public int l;
    public int n;
    public int p;
    public int k = 0;
    public ListView q = null;
    public Toolbar t = null;
    public TextView u = null;
    public TextView v = null;
    public TextView w = null;
    public TextView x = null;
    public TextView y = null;
    public List z = new ArrayList();
    public ImageButton B = null;
    public int C = 0;
    public String[] D = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] E = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public final Context W = this;
    public String X = "";
    public DatePickerDialog.OnDateSetListener Y = new e();
    public DatePickerDialog.OnDateSetListener Z = new f();

    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;

        public a(TextView textView, ImageView imageView) {
            this.a = textView;
            this.b = imageView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ImageView imageView;
            try {
                if (this.a == null || (imageView = this.b) == null) {
                    return;
                }
                String str = Integer.parseInt(imageView.getTag().toString()) == 17301515 ? "1" : "0";
                Main.this.i.v0("update categ set fav=" + str + " where name = '" + ((Object) this.a.getText()) + "'");
                Main.this.j = 0;
            } catch (Exception unused) {
                Toast.makeText(Main.this.getApplicationContext(), Main.this.getString(R.string.sql_error), 1);
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

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView a;

        public c(TextView textView) {
            this.a = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (this.a != null) {
                    Main.this.i.v0("delete from transactions where id='" + ((Object) this.a.getText()) + "'");
                    Main.this.j = 0;
                }
            } catch (Exception unused) {
                Toast.makeText(Main.this.getApplicationContext(), Main.this.getString(R.string.sql_error), 1);
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class e implements DatePickerDialog.OnDateSetListener {
        public e() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Main.this.l = i;
            Main.this.n = i2;
            Main.this.p = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Main.this.p)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Main.this.n + 1)) + "-" + Main.this.l;
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
                new SimpleDateFormat("dd-MM-yyyy", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public class f implements DatePickerDialog.OnDateSetListener {
        public f() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Main.this.l = i;
            Main.this.n = i2;
            Main.this.p = i3;
            try {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Main.this.p)) + "-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Main.this.n + 1)) + "-" + Main.this.l;
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
                new SimpleDateFormat("dd-MM-yyyy", locale);
                simpleDateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Main.this.O();
        }
    }

    public class h extends ActionBarDrawerToggle {
        public h(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
            super(activity, drawerLayout, toolbar, i, i2);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view) {
            Main.this.getSupportActionBar().setTitle(Main.this.Q);
            Main.this.invalidateOptionsMenu();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view) {
            Main.this.getSupportActionBar().setTitle(Main.this.P);
            Main.this.invalidateOptionsMenu();
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            TextView textView = (TextView) view.findViewById(R.id.title);
            if (i == 0 || i == 1 || i == 3) {
                Intent intent = new Intent(Main.this, (Class<?>) Action_list.class);
                intent.putExtra("action_id", i);
                intent.putExtra("action_text", textView.getText());
                Main.this.startActivity(intent);
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class l extends WebViewClient {
        public l() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:DisplayItem_details2('1','2','3','4')");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class n implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public n(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (i == 0 || i == 1) {
                Intent intent = new Intent(Main.this.W, (Class<?>) Bill_edit.class);
                int i2 = i + 1;
                intent.putExtra("TR_TYPE", String.valueOf(i2));
                intent.putExtra("title", Main.this.i.V8(i2));
                Main.this.startActivity(intent);
            } else if (i != 2 && i != 3 && i != 4 && i == 5) {
                Intent intent2 = new Intent(Main.this.W, (Class<?>) Bill_edit.class);
                intent2.putExtra("TR_TYPE", String.valueOf(1));
                intent2.putExtra("broken_type_id", "1");
                intent2.putExtra("item_status_id", "1");
                Main.this.startActivity(intent2);
            }
            this.a.dismiss();
        }
    }

    public class o implements AdapterView.OnItemClickListener {
        public o() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Main.this.U(i);
        }
    }

    private void Q() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_PHONE_STATE")) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        }
    }

    private void T() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/help.html");
        webView.setWebViewClient(new l());
        builder.setView(webView);
        builder.setNegativeButton(getString(R.string.confirm_close), new m());
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i2) {
        switch (i2) {
            case -1:
                this.R.closeDrawer(this.S);
                break;
            case 0:
                Intent intent = new Intent(this, (Class<?>) Bills2.class);
                intent.putExtra("TR_TYPE", "1");
                startActivity(intent);
                finish();
                this.R.closeDrawer(this.S);
                break;
            case 1:
                Intent intent2 = new Intent(this, (Class<?>) Bills2.class);
                intent2.putExtra("TR_TYPE", "2");
                startActivity(intent2);
                finish();
                this.R.closeDrawer(this.S);
                break;
            case 2:
                Intent intent3 = new Intent(this, (Class<?>) Expenses.class);
                intent3.putExtra("TR_TYPE", "3");
                startActivity(intent3);
                finish();
                this.R.closeDrawer(this.S);
                break;
            case 3:
                Intent intent4 = new Intent(this, (Class<?>) Bills2.class);
                intent4.putExtra("TR_TYPE", "1");
                intent4.putExtra("broken_type_id", "1");
                intent4.putExtra("item_status_id", "1");
                startActivity(intent4);
                finish();
                this.R.closeDrawer(this.S);
                break;
            case 4:
                startActivity(new Intent(this, (Class<?>) Reports_list.class));
                finish();
                this.R.closeDrawer(this.S);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 31) {
                    J();
                }
                new DateFormat();
                String string = DateFormat.format("yyyyMMddkkmmss", new Date()).toString();
                AbstractC2242g10.c(this, "inv.db", string + "-inv.db", "info.aalmoghalis.inventory");
                this.i.qd(string + "-inv.db");
                this.R.closeDrawer(this.S);
                break;
            case 6:
                if (Build.VERSION.SDK_INT < 31) {
                    J();
                }
                info.aalmoghalis.inventory.activity.c cVarM = info.aalmoghalis.inventory.activity.c.m(info.aalmoghalis.inventory.activity.c.i.FileSelector, R.string.resourceID_OK, R.string.resourceID_Cancel, R.string.resourceID_Title, android.R.drawable.ic_menu_set_as, android.R.drawable.ic_menu_directions, android.R.drawable.ic_menu_save);
                ArrayList arrayList = new ArrayList();
                arrayList.add(".db");
                cVarM.n(info.aalmoghalis.inventory.activity.c.b(arrayList));
                cVarM.show(getSupportFragmentManager(), "Test");
                this.R.closeDrawer(this.S);
                break;
            case 7:
                startActivity(new Intent(this, (Class<?>) Google_drive_list.class));
                this.R.closeDrawer(this.S);
                break;
            case 8:
                startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
                this.R.closeDrawer(this.S);
                break;
            case 9:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.contact_layout, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.text);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setText(R.string.contact_msg);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                builder.setView(viewInflate);
                builder.setTitle(getString(R.string.contact_hdr));
                builder.setCancelable(false).setPositiveButton("OK", new k());
                builder.create().show();
                this.R.closeDrawer(this.S);
                break;
            case 10:
                T();
                this.R.closeDrawer(this.S);
                break;
            case 11:
                Process.killProcess(Process.myPid());
                System.exit(0);
                getParent().finish();
                this.R.closeDrawer(this.S);
                break;
        }
    }

    public void J() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void K() {
        String strSubstring = ((TelephonyManager) getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getDeviceId().substring(0, 14);
        Z00.R = strSubstring;
        Z00.S = AbstractC4032uI.b(strSubstring);
    }

    public void L(Cursor cursor) {
    }

    public void M() {
        Cursor cursorM2 = this.i.M2();
        this.D = new String[cursorM2.getCount()];
        if (cursorM2.moveToFirst()) {
            int i2 = 0;
            do {
                this.D[i2] = cursorM2.getString(cursorM2.getColumnIndex("_id"));
                i2++;
            } while (cursorM2.moveToNext());
        }
        cursorM2.close();
    }

    public void N(String str, String str2, String str3) {
        Intent intent;
        int iU8 = this.i.U8(str3);
        if (iU8 == 1 || iU8 == 2) {
            intent = new Intent(this, (Class<?>) Bill_edit.class);
        } else {
            intent = iU8 == 3 ? new Intent(this, (Class<?>) Bill_move.class) : null;
        }
        intent.putExtra("TR_ID", str);
        intent.putExtra("tran_status", str2);
        startActivity(intent);
    }

    public void O() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") == 0) {
            K();
        } else if (Build.VERSION.SDK_INT < 29) {
            Q();
        } else {
            this.i.Tb();
        }
    }

    public void P() {
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            Z00.U = defaultSharedPreferences.getBoolean("prefLogin", false);
            Z00.W = defaultSharedPreferences.getString("prefPassword", "");
            if (Z00.U && Z00.V.equals("0")) {
                startActivity(new Intent(this, (Class<?>) LoginActivity.class));
                finish();
            }
        } catch (Exception unused) {
        }
    }

    public void R() {
        new BackupManager(this).dataChanged();
    }

    public void S(boolean z) {
    }

    public void add_btn(View view) {
        super.w();
    }

    public void btn_cus_add(View view) {
    }

    public void btn_cus_edit(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.page_name);
        info.aalmoghalis.inventory.activity.a aVarA = info.aalmoghalis.inventory.activity.a.a(textView.getText().toString());
        this.X = textView.getText().toString();
        aVarA.show(getFragmentManager(), "Category");
    }

    public void btn_cus_save(View view) {
    }

    public void btn_item_remove(View view) {
        TextView textView = (TextView) ((LinearLayout) ((View) view.getParent()).getParent()).findViewById(R.id.id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_msg) + "#" + ((Object) textView.getText()) + "?");
        builder.setPositiveButton(getString(R.string.confirm_yes), new c(textView));
        builder.setNegativeButton(getString(R.string.confirm_no), new d());
        builder.create().show();
    }

    public void btn_more(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        N(((TextView) linearLayout.findViewById(R.id.id)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f5)).getText().toString(), ((TextView) linearLayout.findViewById(R.id.f1)).getText().toString());
    }

    public void btn_report_4(View view) {
        startActivity(new Intent(this, (Class<?>) Report9_expenses_balance_daily.class));
    }

    public void btn_report_5(View view) {
        startActivity(new Intent(this, (Class<?>) Report2_supp_balance.class));
    }

    public void btn_update_status(View view) {
        LinearLayout linearLayout = (LinearLayout) ((View) view.getParent()).getParent();
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.page_enable);
        TextView textView = (TextView) linearLayout.findViewById(R.id.page_name);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Integer.parseInt(imageView.getTag().toString()) == 17301515) {
            builder.setMessage(getString(R.string.enable) + "#" + ((Object) textView.getText()) + "?");
        } else {
            builder.setMessage(getString(R.string.disable) + "#" + ((Object) textView.getText()) + "?");
        }
        builder.setPositiveButton(getString(R.string.confirm_yes), new a(textView, imageView));
        builder.setNegativeButton(getString(R.string.confirm_no), new b());
        builder.create().show();
    }

    public void help_btn(View view) {
        T();
    }

    public void hideSoftKeyboard(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void items_add(View view) {
    }

    @Override // info.aalmoghalis.inventory.activity.c.g
    public void l(String str, String str2) {
        if (str == null || str2 == null || AbstractC2242g10.f(this, "inv.db", str, str2, "info.aalmoghalis.inventory") != 0) {
            return;
        }
        new Handler().postDelayed(new j(), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    @Override // info.aalmoghalis.inventory.activity.c.g
    public boolean m(String str, String str2) {
        try {
            return new File(str, str2).exists();
        } catch (Exception unused) {
        }
    }

    @Override // info.aalmoghalis.inventory.activity.a.b
    public void n(DialogFragment dialogFragment) {
        try {
            if (!this.X.equals("")) {
                EditText editText = (EditText) dialogFragment.getDialog().findViewById(R.id.field1);
                this.i.v0("update categ set name='" + editText.getText().toString() + "' where name='" + this.X + "'");
            }
            this.X = "";
        } catch (Exception e2) {
            Log.d("cat_update_error=", e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.R.isDrawerOpen(this.S)) {
            this.R.closeDrawer(this.S);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.T.onConfigurationChanged(configuration);
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i2;
        int i3;
        super.onCreate(bundle);
        setContentView(R.layout.activity_main_tmp);
        setTitle(getString(R.string.app_name));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        this.t = toolbar;
        setSupportActionBar(toolbar);
        this.i = new Z00(this.h, this);
        try {
            P();
            R();
            while (true) {
                String[] strArr = this.F;
                if (i3 >= strArr.length) {
                    break;
                }
                this.U.add(new C3874sM(strArr[i3], this.G.getResourceId(i3, -1)));
                i3++;
            }
            while (true) {
                String[] strArr2 = this.L;
                if (i2 >= strArr2.length) {
                    break;
                }
                this.N.add(new C3874sM(strArr2[i2], this.M.getResourceId(i2, -1)));
                i2++;
            }
        } catch (Exception unused) {
        }
        AsyncTask.execute(new g());
        M();
        this.A = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.D);
        S(true);
        CharSequence title = getTitle();
        this.P = title;
        this.Q = title;
        this.F = getResources().getStringArray(R.array.titles);
        this.G = getResources().obtainTypedArray(R.array.icons);
        this.R = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.S = (ListView) findViewById(R.id.slider_list);
        this.U = new ArrayList();
        i2 = 0;
        i3 = 0;
        this.G.recycle();
        C4062ug c4062ug = new C4062ug(getApplicationContext(), this.U);
        this.V = c4062ug;
        this.S.setAdapter((ListAdapter) c4062ug);
        this.S.setOnItemClickListener(new o());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        h hVar = new h(this, this.R, this.t, R.string.app_name, R.string.app_name);
        this.T = hVar;
        this.R.setDrawerListener(hVar);
        if (bundle == null) {
            U(-1);
        }
        GridView gridView = (GridView) findViewById(R.id.gridview);
        this.L = getResources().getStringArray(R.array.titles4);
        this.M = getResources().obtainTypedArray(R.array.icons4);
        this.N = new ArrayList();
        this.M.recycle();
        C4062ug c4062ug2 = new C4062ug(getApplicationContext(), this.N);
        this.O = c4062ug2;
        gridView.setAdapter((ListAdapter) c4062ug2);
        gridView.setOnItemClickListener(new i());
        SharedPreferences sharedPreferences = getSharedPreferences("first_run", 1);
        if (!sharedPreferences.getString("first_run", "0").equals("1")) {
            sharedPreferences.edit().putString("first_run", "1").commit();
            T();
        }
        getWindow().setSoftInputMode(3);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 == 0) {
            return new DatePickerDialog(this, this.Y, this.l, this.n, this.p);
        }
        if (i2 != 4) {
            return null;
        }
        return new DatePickerDialog(this, this.Z, this.l, this.n, this.p);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        L(this.i.L2());
        S(true);
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            if (i2 != 4) {
                return super.onKeyDown(i2, keyEvent);
            }
            onBackPressed();
            return true;
        }
        if (!this.R.isDrawerOpen(this.S)) {
            this.R.openDrawer(this.S);
        } else if (this.R.isDrawerOpen(this.S)) {
            this.R.closeDrawer(this.S);
        }
        return true;
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.T.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.T.syncState();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.R.isDrawerOpen(this.S);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 0) {
            if (iArr.length == 1 && iArr[0] == 0) {
                K();
                return;
            }
            return;
        }
        if (i2 == 112 && iArr.length == 1) {
            int i3 = iArr[0];
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // info.aalmoghalis.inventory.activity.Menu_AppCompatActivity
    public void w() {
        Dialog dialog = new Dialog(this.W);
        LinearLayout linearLayout = new LinearLayout(this);
        this.H = getResources().getStringArray(R.array.titles3);
        this.I = getResources().obtainTypedArray(R.array.icons3);
        ListView listView = new ListView(this);
        this.J = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = this.H;
            if (i2 >= strArr.length) {
                this.I.recycle();
                C4062ug c4062ug = new C4062ug(getApplicationContext(), this.J);
                this.K = c4062ug;
                listView.setAdapter((ListAdapter) c4062ug);
                listView.setOnItemClickListener(new n(dialog));
                linearLayout.setFocusable(true);
                listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                listView.setDividerHeight(0);
                linearLayout.addView(listView, -1, -1);
                dialog.requestWindowFeature(1);
                dialog.setContentView(linearLayout);
                dialog.show();
                return;
            }
            this.J.add(new C3874sM(strArr[i2], this.I.getResourceId(i2, -1)));
            i2++;
        }
    }
}
