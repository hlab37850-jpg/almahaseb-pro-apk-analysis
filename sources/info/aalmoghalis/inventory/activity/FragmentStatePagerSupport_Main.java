package info.aalmoghalis.inventory.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.backup.BackupManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.messaging.FirebaseMessaging;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC1794bT;
import defpackage.AbstractC2242g10;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC4158vt;
import defpackage.C0372Bn;
import defpackage.C0917Sq;
import defpackage.C0943Tq;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C3874sM;
import defpackage.C3900sg;
import defpackage.C3966tX;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.JC;
import defpackage.M00;
import defpackage.MO;
import defpackage.Q00;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.fcm.Firestore_Receiver;
import info.aalmoghalis.inventory.lang.BaseActivity;
import info.aalmoghalis.inventory.online.DeviceBootReceiver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentStatePagerSupport_Main extends BaseActivity implements info.aalmoghalis.inventory.activity.c.g, info.aalmoghalis.inventory.activity.b.d, LoaderManager.LoaderCallbacks<ArrayList<C0917Sq>>, info.aalmoghalis.inventory.activity.d.o {
    public static Q00 S = null;
    public static M00 T = null;
    public static boolean U = false;
    public static int V;
    public static int W;
    public static int X;
    public static final String[] Y = {"android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.GET_ACCOUNTS", "android.permission.POST_NOTIFICATIONS"};
    public static final String[] Z = {"android.permission.WRITE_CONTACTS"};
    public static boolean a0 = false;
    public static String b0 = "0";
    public static boolean c0 = false;
    public String[] B;
    public TypedArray C;
    public CharSequence D;
    public CharSequence E;
    public DrawerLayout F;
    public ListView G;
    public ActionBarDrawerToggle H;
    public List I;
    public C3900sg J;
    public LinearLayout L;
    public Firestore_Receiver O;
    public Bundle Q;
    public JC c;
    public ViewPager d;
    public SQLiteDatabase e;
    public Z00 f;
    public TextView v;
    public LinearLayout w;
    public TextView x;
    public List g = new ArrayList();
    public List h = new ArrayList();
    public ArrayList i = new ArrayList();
    public ArrayList j = new ArrayList();
    public int[] k = {R.drawable.up, 1, R.drawable.down};
    public AutoCompleteTextView l = null;
    public EditText n = null;
    public EditText p = null;
    public TextView q = null;
    public TextView t = null;
    public Button u = null;
    public LinearLayout y = null;
    public ImageButton z = null;
    public Toolbar A = null;
    public int K = 0;
    public Dialog M = null;
    public Handler N = new u();
    public ViewPager.OnPageChangeListener P = new j();
    public int R = 0;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            FragmentStatePagerSupport_Main.this.f.Mc("prefOthers_purchases_tax", true);
            FragmentStatePagerSupport_Main.this.f.Mc("prefOthers_sales_tax", true);
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            FragmentStatePagerSupport_Main.this.f.Mc("prefOthers_purchases_tax", false);
            FragmentStatePagerSupport_Main.this.f.Mc("prefOthers_sales_tax", false);
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
            FragmentStatePagerSupport_Main.this.l0(false);
            FragmentStatePagerSupport_Main.this.f.Mc("prefOthers_closed_year", false);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ boolean a;

        public e(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStatePagerSupport_Main.this.f.bc(this.a);
            FragmentStatePagerSupport_Main.this.f.Rd(200);
            Message message = new Message();
            message.obj = "1";
            FragmentStatePagerSupport_Main.this.N.sendMessage(message);
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class g extends ActionBarDrawerToggle {
        public g(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
            super(activity, drawerLayout, toolbar, i, i2);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view) {
            FragmentStatePagerSupport_Main.this.getSupportActionBar().setTitle(FragmentStatePagerSupport_Main.this.E);
            FragmentStatePagerSupport_Main.this.invalidateOptionsMenu();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view) {
            FragmentStatePagerSupport_Main.this.getSupportActionBar().setTitle(FragmentStatePagerSupport_Main.this.D);
            FragmentStatePagerSupport_Main.this.invalidateOptionsMenu();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(FragmentStatePagerSupport_Main.this, (Class<?>) Google_drive_list.class);
            intent.putExtra("bk_flag", "1");
            intent.putExtra("auto_filename", "");
            FragmentStatePagerSupport_Main.this.startActivityForResult(intent, 1);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStatePagerSupport_Main.this.d.setCurrentItem(FragmentStatePagerSupport_Main.W);
            int i = FragmentStatePagerSupport_Main.this.K;
        }
    }

    public class j implements ViewPager.OnPageChangeListener {
        public Boolean a = Boolean.TRUE;
        public int b = 0;

        public j() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            FragmentStatePagerSupport_Main.this.h0(i);
            Log.d("Page.CreateView=", i + "");
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FragmentStatePagerSupport_Main.this.N();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String string = FragmentStatePagerSupport_Main.this.getResources().getString(R.string.file_extension_xml);
            String string2 = FragmentStatePagerSupport_Main.this.getResources().getString(R.string.tag_fragment_FileSave);
            Z00.Y = "0";
            info.aalmoghalis.inventory.activity.b.i(string, R.string.alert_ok, R.string.alert_cancel, R.string.alert_file_save_as, R.string.hint_filename_unadorned, android.R.drawable.ic_menu_save).show(FragmentStatePagerSupport_Main.this.getFragmentManager(), string2);
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;

        public m(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            FragmentStatePagerSupport_Main.this.f.qd(this.a + "-inv.db");
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(FragmentStatePagerSupport_Main.this, (Class<?>) Google_drive_list.class);
            intent.putExtra("bk_flag", "0");
            intent.putExtra("auto_filename", "");
            FragmentStatePagerSupport_Main.this.startActivityForResult(intent, 1);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStatePagerSupport_Main.this.J();
            FragmentStatePagerSupport_Main.this.t0();
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(FragmentStatePagerSupport_Main.this, (Class<?>) Google_drive_list.class);
            intent.putExtra("bk_flag", "1");
            intent.putExtra("auto_filename", "");
            FragmentStatePagerSupport_Main.this.startActivityForResult(intent, 1);
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStatePagerSupport_Main.this.finish();
            FragmentStatePagerSupport_Main.this.startActivity(new Intent(FragmentStatePagerSupport_Main.this, (Class<?>) FragmentStatePagerSupport_Main.class));
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
            FragmentStatePagerSupport_Main.this.M();
        }
    }

    public class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Z00 z00 = FragmentStatePagerSupport_Main.this.f;
            FragmentStatePagerSupport_Main fragmentStatePagerSupport_Main = FragmentStatePagerSupport_Main.this;
            z00.I0(fragmentStatePagerSupport_Main, fragmentStatePagerSupport_Main.N);
        }
    }

    public class u extends Handler {
        public u() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("mProgress=f=", message.obj + "");
            if (message.obj.toString().equals("20")) {
                FragmentStatePagerSupport_Main fragmentStatePagerSupport_Main = FragmentStatePagerSupport_Main.this;
                fragmentStatePagerSupport_Main.Q(fragmentStatePagerSupport_Main, fragmentStatePagerSupport_Main.f);
            } else if (message.obj.toString().equals("1")) {
                FragmentStatePagerSupport_Main.this.K();
            }
            FragmentStatePagerSupport_Main.this.s0(false);
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Z00 b;

        public v(Context context, Z00 z00) {
            this.a = context;
            this.b = z00;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            FragmentStatePagerSupport_Main.L(this.a);
            Z00 z00 = this.b;
            Context context = this.a;
            z00.Xd(context, context.getString(R.string.app_name), 0);
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String string = FragmentStatePagerSupport_Main.this.getResources().getString(R.string.file_extension_xml);
            String string2 = FragmentStatePagerSupport_Main.this.getResources().getString(R.string.tag_fragment_FileSave);
            Z00.Y = "0";
            info.aalmoghalis.inventory.activity.b.i(string, R.string.alert_ok, R.string.alert_cancel, R.string.alert_file_save_as, R.string.hint_filename_unadorned, android.R.drawable.ic_menu_save).show(FragmentStatePagerSupport_Main.this.getFragmentManager(), string2);
        }
    }

    public class x implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;

        public x(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            FragmentStatePagerSupport_Main.this.f.qd(this.a);
        }
    }

    public class y implements AdapterView.OnItemClickListener {
        public y() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            FragmentStatePagerSupport_Main.this.u0(i);
        }
    }

    public static void L(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : Z) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            Arrays.fill(new int[Y.length], 0);
        } else {
            ActivityCompat.requestPermissions((Activity) context, (String[]) arrayList.toArray(new String[arrayList.size()]), 1);
        }
    }

    private void S() {
        int i2 = Calendar.getInstance().get(14);
        V = i2;
        try {
            getSupportLoaderManager().destroyLoader(V);
        } catch (Exception unused) {
        }
        getSupportLoaderManager().initLoader(i2, null, this).forceLoad();
    }

    public static String X() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public static void Z(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (!inputMethodManager.isActive() || activity.getCurrentFocus() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static /* synthetic */ void d0(Integer num) {
    }

    private void n0() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_PHONE_STATE")) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        }
    }

    private void q0() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void G() {
        if (this.A == null) {
            return;
        }
        for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
            View childAt = this.A.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (textView.getText().equals(this.A.getTitle())) {
                    C0372Bn.e.a(this, textView);
                    return;
                }
            }
        }
    }

    public void H() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_CONTACTS"}, 113);
    }

    public void I() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void J() {
        try {
            this.f.ia("first_run", "0").equals("1");
            if (Build.VERSION.SDK_INT < 23) {
                W();
            }
            y0();
            x0();
            w0();
            r0();
            try {
                o0();
            } catch (Exception unused) {
            }
            g0();
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("bk_jobs1", e2.getMessage());
        }
    }

    public void K() {
        ArrayList arrayList = new ArrayList();
        for (String str : Y) {
            if (ContextCompat.checkSelfPermission(this, str) != 0) {
                if (!str.equals("android.permission.READ_PHONE_STATE")) {
                    arrayList.add(str);
                } else if (Build.VERSION.SDK_INT < 29) {
                    arrayList.add(str);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 1);
            return;
        }
        String[] strArr = Y;
        int[] iArr = new int[strArr.length];
        Arrays.fill(iArr, 0);
        onRequestPermissionsResult(1, strArr, iArr);
    }

    public void M() {
        try {
            String strIa = this.f.ia("prefBackup_path", Z00.L);
            Log.d("trace_app_check=", "path=" + strIa);
            new File(strIa);
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse(strIa));
            intent.addFlags(1);
            intent.addFlags(2);
            intent.addFlags(64);
            startActivityForResult(intent, 3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void N() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (!this.f.ia("app_path_uri", "").equals("")) {
            Uri.parse(this.f.ia("app_path_uri", ""));
        }
        builder.setMessage(getString(R.string.choose_backup_path));
        builder.setCancelable(true).setPositiveButton(getString(R.string.confirm_yes), new s()).setNegativeButton(getString(R.string.confirm_no), new r());
        builder.create().show();
    }

    public void O() {
        try {
            if (AbstractC4158vt.a(this) && AbstractC4158vt.b(this.f)) {
                this.f.Lc("online_share_type", "1");
                if (!AbstractC1794bT.e()) {
                    AbstractC1794bT.c(this);
                    AbstractC1794bT.a();
                }
                m0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void P() {
        int i2 = Build.VERSION.SDK_INT;
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/x-sqlite3", "application/vnd.sqlite3", "application/octet-stream", "application/x-trash"});
        if (i2 >= 26) {
            intent.addFlags(193);
            Uri uri = Uri.parse("content://com.android.externalstorage.documents/document/primary:" + Z00.L.replaceAll("/storage/emulated/0/", "").replaceAll("/", "%2F"));
            Log.d("init_uri=", uri.getPath() + ":" + Environment.DIRECTORY_DOCUMENTS);
            intent.putExtra("android.provider.extra.INITIAL_URI", uri);
        }
        startActivityForResult(intent, 2);
    }

    public void Q(Context context, Z00 z00) {
        String strX4;
        try {
            strX4 = z00.X4("select name as _id from contacts where type_=0");
        } catch (Exception e2) {
            e2.printStackTrace();
            strX4 = "";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.contact_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        if (strX4.length() > 0) {
            textView.setText(strX4);
        } else {
            textView.setText(R.string.contact_msg);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        builder.setView(viewInflate);
        builder.setTitle(context.getString(R.string.contact_hdr) + "(Ver." + z00.P1(context) + ")");
        builder.setNegativeButton(context.getString(R.string.whatsapp), new v(context, z00));
        builder.create().show();
        O();
    }

    public final File R(Uri uri, String str) {
        File file;
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (str.equals("")) {
            file = new File(getFilesDir() + "/" + string);
        } else {
            File file2 = new File(getFilesDir() + "/" + str);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(getFilesDir() + "/" + str + "/" + string);
        }
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStreamOpenInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
            inputStreamOpenInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            Log.e("Exception", e2.getMessage() + "");
            e2.printStackTrace();
        }
        return file;
    }

    public void T() {
        if (C2160f10.h != -1) {
            new C2160f10().Z(this);
            k0();
        } else {
            Process.killProcess(Process.myPid());
            System.exit(0);
            getParent().finish();
        }
    }

    public void U() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.drive_confirm));
        builder.setCancelable(true).setPositiveButton(getString(R.string.confirm_yes), new h()).setNegativeButton(getString(R.string.confirm_no), new f());
        builder.create().show();
    }

    public void V() {
        s0(true);
        new Thread(new t()).start();
    }

    public void W() {
        if (this.f.ia("first_run", "0").equals("0")) {
            this.f.Lc("first_run", "1");
            Intent intent = new Intent(this, (Class<?>) Info_edit3.class);
            intent.putExtra("action_type", 1);
            intent.putExtra("action_text", getString(R.string.items));
            startActivity(intent);
        }
    }

    public final String Y(Uri uri) {
        try {
            Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
            int columnIndex = cursorQuery.getColumnIndex("_display_name");
            cursorQuery.getColumnIndex("_size");
            cursorQuery.moveToFirst();
            return cursorQuery.getString(columnIndex);
        } catch (Exception unused) {
            return new File(uri.getPath()).getName();
        }
    }

    public final /* synthetic */ File a0(Uri uri) {
        return R(uri, "tmp");
    }

    public final /* synthetic */ void b0(File file) {
        s0(false);
        l(file.getParent(), file.getName());
    }

    public final /* synthetic */ Integer c0() {
        this.f.m0();
        if (!this.f.ia("online_share_type", "0").equals("0") && S == null && !AbstractC1794bT.e()) {
            AbstractC1794bT.c(this);
            AbstractC1794bT.a();
        }
        return 1;
    }

    public final /* synthetic */ Integer e0() {
        this.f.oe();
        p0();
        return 1;
    }

    @Override // info.aalmoghalis.inventory.activity.b.d
    public void f(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 31) {
            I();
        }
        String strC8 = Z00.C8();
        File file = new File(str + "/" + str2 + ".db");
        if (!file.exists() || file.canWrite() || file.getParentFile() == null || !file.getParentFile().canWrite() || !new C3966tX().v(file.getParentFile().getPath())) {
            AbstractC2242g10.d(this, str, "inv.db", str2 + ".db", "info.aalmoghalis.inventory");
            return;
        }
        AbstractC2242g10.d(this, str, "inv.db", (str2 + "-" + strC8) + ".db", "info.aalmoghalis.inventory");
        Toast.makeText(this, R.string.already_exists, 1).show();
    }

    public final /* synthetic */ void f0(Integer num) {
        s0(false);
        K();
        if (new C3966tX().i(this.f.ia("prefBackup_path", Z00.L), this.f)) {
            this.f.he();
        }
        j0();
    }

    public void g0() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") == 0 || Build.VERSION.SDK_INT >= 29) {
            return;
        }
        Z00.R = "PERMISSION_DEN";
        n0();
    }

    @Override // info.aalmoghalis.inventory.activity.b.d
    public boolean h(String str, String str2) {
        String strC;
        boolean z = true;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            Toast.makeText(this, R.string.alert_supply_filename, 1).show();
            z = false;
        }
        if (z && ((strC = info.aalmoghalis.inventory.activity.b.c(str2)) == null || strC.length() == 0)) {
            z = false;
        }
        if (z && !info.aalmoghalis.inventory.activity.b.b(str2)) {
            z = false;
        }
        if (z && info.aalmoghalis.inventory.activity.b.a(str, str2)) {
            return false;
        }
        return z;
    }

    public void h0(int i2) {
        W = i2;
        Log.d("trace_S_open_page=", X());
        this.d.setCurrentItem(W);
        new Handler().post(new i());
    }

    public void help_btn(View view) {
        this.f.Ld(this);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, ArrayList arrayList) {
        Log.d("trace_E_Loader_groups=", "###" + this.f.ia("db_cus_changed", "-1"));
        this.i = arrayList;
        X = arrayList.size();
        Bundle bundle = new Bundle();
        this.Q = bundle;
        bundle.putSerializable("dataGroups", this.i);
        try {
            this.c = new JC(getSupportFragmentManager(), this.i, 4, (Context) this);
            this.K = 4;
            ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
            this.d = viewPager;
            viewPager.setAdapter(this.c);
            this.d.addOnPageChangeListener(this.P);
            this.d.setOffscreenPageLimit(1);
            if (W == 0 && this.i.size() > 0) {
                h0(0);
            }
            if (!this.f.ia("first_run", "0").equals("1") || new C3966tX().k(this.f)) {
                return;
            }
            runOnUiThread(new k());
        } catch (Exception unused) {
        }
    }

    public void j0() {
        try {
            k0();
            try {
                if (getIntent().getBooleanExtra("open_activation", false)) {
                    this.f.r(this, getIntent().getStringExtra("email"), getIntent().getStringExtra("aid"));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused) {
        }
        try {
            if (this.f.ia("upgrad_db_date", "").equals("")) {
                v0(true);
            }
            this.f.K0();
        } catch (Exception unused2) {
        }
        try {
            S();
        } catch (Exception unused3) {
        }
        try {
            new Handler().postDelayed(new o(), 10L);
        } catch (Exception unused4) {
        }
    }

    public void k0() {
        try {
            Z00.U = this.f.ja("prefLogin", false);
            String strIa = this.f.ia("prefPassword", "");
            Z00.W = strIa;
            if (strIa.length() == 0) {
                this.f.Mc("prefLogin", false);
                Z00.U = false;
            }
            int iV = new C2160f10(this.f).v();
            if (iV <= 0) {
                MO.a(this);
            }
            if (iV > 0 && (C2160f10.h == -1 || C2160f10.k.isEmpty())) {
                startActivity(new Intent(this, (Class<?>) LoginPwdActivity.class));
                finish();
            } else if (Z00.U && Z00.V.equals("0")) {
                startActivity(new Intent(this, (Class<?>) LoginActivity.class));
                finish();
            }
        } catch (Exception unused) {
        }
    }

    @Override // info.aalmoghalis.inventory.activity.c.g
    public void l(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f.Lc("upgrad_db_date", "");
        this.f.Y();
        if (AbstractC2242g10.f(this, "inv.db", str, str2, "info.aalmoghalis.inventory") == 0) {
            this.f.Lc("fix1_run", "0");
            new Handler().postDelayed(new q(), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        }
    }

    public void l0(boolean z) {
        s0(true);
        new Thread(new e(z)).start();
    }

    @Override // info.aalmoghalis.inventory.activity.c.g
    public boolean m(String str, String str2) {
        if (str2 != null) {
            return new File(str, str2).exists();
        }
        Toast.makeText(this, R.string.alert_choose_filename, 1).show();
        return false;
    }

    public void m0() {
        try {
            if (this.O == null) {
                Firestore_Receiver firestore_Receiver = new Firestore_Receiver();
                this.O = firestore_Receiver;
                if (Build.VERSION.SDK_INT >= 33) {
                    registerReceiver(firestore_Receiver, new IntentFilter("info.aalmoghalis.inventory.ALERT_FROM_SERVICE"), 2);
                } else {
                    registerReceiver(firestore_Receiver, new IntentFilter("info.aalmoghalis.inventory.ALERT_FROM_SERVICE"));
                }
                Log.d(Q00.H, "Receiver registered");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void o0() {
        try {
            String str = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime());
            if (this.f.ia("backup_date", "").equals(str)) {
                return;
            }
            new BackupManager(this).dataChanged();
            this.f.Lc("backup_date", str);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 2 && i3 == -1) {
            if (intent != null) {
                final Uri data = intent.getData();
                File file = new File(data.getPath());
                String strQ = new C3966tX().q(data, this.f);
                String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(data.toString());
                if (!file.getName().endsWith(".db") && !Y(data).endsWith(".db") && ((!fileExtensionFromUrl.equals("") && !fileExtensionFromUrl.equals("db") && !fileExtensionFromUrl.startsWith("db%20")) || !C2160f10.p(new C3966tX().a, strQ))) {
                    Z00 z00 = this.f;
                    z00.Kd(z00.b, getString(R.string.error), 1000);
                    return;
                } else if (Y(data).equals(file.getName())) {
                    File fileR = R(data, "tmp");
                    l(fileR.getParent(), fileR.getName());
                } else {
                    s0(true);
                    AbstractC3132jE.d(new Callable() { // from class: ep
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.a.a0(data);
                        }
                    }).m(IN.c()).g().e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: fp
                        @Override // defpackage.InterfaceC2295gf
                        public final void accept(Object obj) {
                            this.a.b0((File) obj);
                        }
                    });
                }
            }
        } else if (i2 == 3 && i3 == -1 && intent != null) {
            Uri data2 = intent.getData();
            this.f.Lc("app_path_uri", data2.toString());
            int flags = 3 & intent.getFlags();
            getContentResolver().takePersistableUriPermission(data2, 1);
            getContentResolver().takePersistableUriPermission(data2, 2);
            getContentResolver().takePersistableUriPermission(data2, flags);
            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.f.b, data2);
            if (documentFileFromTreeUri.canWrite() && documentFileFromTreeUri.isDirectory()) {
                this.f.Lc("prefBackup_path", new C3966tX().t(data2));
                this.f.he();
            }
            Log.d("trace_app_main=", "path=" + new C3966tX().t(data2) + ":" + data2.toString() + ":" + documentFileFromTreeUri.listFiles().length);
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Log.d("Oncreate:", "onBackPressed=" + this.F.isDrawerOpen(this.L));
        if (this.F.isDrawerOpen(this.L)) {
            this.F.closeDrawer(this.L);
        } else if (C2160f10.h != -1) {
            new C2160f10().Z(this);
            k0();
        } else {
            Process.killProcess(Process.myPid());
            super.onBackPressed();
        }
    }

    @Override // info.aalmoghalis.inventory.activity.d.o
    public void onButtonClicked(View view) {
        int currentItem = this.d.getCurrentItem();
        switch (view.getId()) {
            case R.id.move_left /* 2131297061 */:
                if (currentItem != 0) {
                    this.d.setCurrentItem(currentItem - 1);
                }
                break;
            case R.id.move_right /* 2131297062 */:
                if (this.i.size() > currentItem) {
                    this.d.setCurrentItem(currentItem + 1);
                }
                break;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.H.onConfigurationChanged(configuration);
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i2;
        try {
            super.onCreate(bundle);
            setContentView(R.layout.activity_main_tmp2);
            BaseActivity.b = true;
            Log.d("trace_S_oncreate=", X());
            Log.d("trace_start_action_bar=", X());
            q0();
            a0 = false;
            info.aalmoghalis.inventory.activity.d.A0 = -1;
            try {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
                Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(viewConfiguration, false);
                }
            } catch (Exception unused) {
            }
            this.f = new Z00(this.e, this);
            Log.d("Oncreate:", "Main_Create");
            Log.d("trace_start_oncreate=", X());
            this.f.Mc("prefOthers_currency", true);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
            this.A = toolbar;
            setSupportActionBar(toolbar);
            G();
            try {
                this.c = new JC(getSupportFragmentManager(), this.i, 4, (Context) this);
                this.K = 4;
                ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
                this.d = viewPager;
                viewPager.setAdapter(this.c);
                this.d.addOnPageChangeListener(this.P);
                this.d.setOffscreenPageLimit(1);
                if (W == 0 && this.i.size() > 0) {
                    h0(0);
                }
                while (true) {
                    String[] strArr = this.B;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    this.I.add(new C3874sM(strArr[i2], this.C.getResourceId(i2, -1)));
                    i2++;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            CharSequence title = getTitle();
            this.D = title;
            this.E = title;
            if (C2160f10.h <= 0) {
                this.B = getResources().getStringArray(R.array.titles);
                this.C = getResources().obtainTypedArray(R.array.icons);
            } else {
                this.B = getResources().getStringArray(R.array.titles_user);
                this.C = getResources().obtainTypedArray(R.array.icons_user);
            }
            this.F = (DrawerLayout) findViewById(R.id.drawer_layout);
            this.G = (ListView) findViewById(R.id.slider_list);
            this.L = (LinearLayout) findViewById(R.id.slider_list_linear);
            TextView textView = (TextView) findViewById(R.id.logo_title);
            this.v = textView;
            C0372Bn.e.a(this, textView);
            this.x = (TextView) findViewById(R.id.logo_user);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_logo_user);
            this.w = linearLayout;
            if (C2160f10.h >= 0) {
                linearLayout.setVisibility(0);
                this.x.setText("(" + C2160f10.h + ") " + C2160f10.k);
            } else {
                linearLayout.setVisibility(8);
            }
            this.I = new ArrayList();
            i2 = 0;
            this.C.recycle();
            C3900sg c3900sg = new C3900sg(getApplicationContext(), this.I);
            this.J = c3900sg;
            this.G.setAdapter((ListAdapter) c3900sg);
            this.G.setOnItemClickListener(new y());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            g gVar = new g(this, this.F, this.A, R.string.app_name, R.string.app_name);
            this.H = gVar;
            this.F.setDrawerListener(gVar);
            if (bundle == null) {
                u0(-1);
            }
            try {
                this.f.Mc("hello_serv", false);
                Log.d("trace_E_oncreate=", X());
                if (!Z00.c0) {
                    Z00.c0 = true;
                    FirebaseMessaging.getInstance().subscribeToTopic("inv_app");
                }
                if (this.f.ia("prefSMS_credit", "").equals(getString(R.string.debit))) {
                    this.f.Lc("prefSMS_credit", getString(R.string.credit));
                }
            } catch (Exception unused2) {
            }
            try {
                v0(true);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            Log.d("main_oncreate=", e4.getMessage());
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<ArrayList<C0917Sq>> onCreateLoader(int i2, Bundle bundle) {
        Log.d("trace_S_Loader_groups=", "###" + this.f.ia("db_cus_changed", "-1"));
        return new C0943Tq(this, this.f, 1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            getSupportLoaderManager().destroyLoader(V);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super.onKeyDown(i2, keyEvent);
        }
        Log.d("onKeyDown", "=" + this.F.isDrawerOpen(this.L));
        if (!this.F.isDrawerOpen(this.L)) {
            this.F.openDrawer(this.L);
            return true;
        }
        if (!this.F.isDrawerOpen(this.L)) {
            return true;
        }
        this.F.closeDrawer(this.L);
        return true;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<ArrayList<C0917Sq>> loader) {
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.H.onOptionsItemSelected(menuItem)) {
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        super.onPause();
        try {
            Dialog dialog = this.M;
            if (dialog != null && U && dialog.isShowing()) {
                Log.d("trace_dialog=", "onPause");
                this.M.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.H.syncState();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        Log.d("Oncreate:", "onPostResume");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 1) {
            return;
        }
        for (int length = strArr.length - 1; length >= 0; length--) {
            if (iArr[length] == 0 || !strArr[length].equals(Y[0])) {
                if (iArr[length] == 0 && strArr[length].equals(Y[0])) {
                    this.f.Tb();
                } else {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 23 && i3 < 31 && iArr[length] == 0 && strArr[length].equals(Y[2]) && new C3966tX().i(this.f.ia("prefBackup_path", Z00.L), this.f)) {
                        this.f.he();
                    }
                }
            } else if (Build.VERSION.SDK_INT < 29) {
                Z00.R = "PERMISSION_DEN";
            } else {
                this.f.Tb();
            }
            if (length == 0) {
                W();
            }
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Main_onRestart:");
            ViewPager viewPager = this.d;
            sb.append(viewPager != null ? Integer.valueOf(viewPager.getCurrentItem()) : ":");
            sb.append(a0);
            sb.append(":");
            sb.append(c0);
            sb.append(":");
            sb.append(this.f.ja("hello_serv", false));
            sb.append(":dailog_running=");
            sb.append(U);
            Log.d("Oncreate:", sb.toString());
            this.f.z0("update trigger_flags set is_active=1");
            if (this.f.S()) {
                new C1839c10(this, this.f).A();
            } else if (this.f.X4("select count(*) as _id from sqlite_master where type='table' and name='table_action'").equals("1")) {
                this.f.mc();
            }
            if (!a0) {
                this.f.Mc("hello_serv", false);
                ViewPager viewPager2 = this.d;
                if (viewPager2 == null || viewPager2.getCurrentItem() == 0) {
                    S();
                    return;
                }
                return;
            }
            Log.d("Oncreate:", "Main_onRestart&Refresh");
            a0 = false;
            if (c0) {
                c0 = false;
                this.f.Mc("hello_serv", false);
                recreate();
            } else {
                setSupportActionBar(this.A);
                this.f = new Z00(this.e, this);
                try {
                    S();
                } catch (Exception unused) {
                }
                try {
                    this.f.Mc("hello_serv", false);
                } catch (Exception unused2) {
                }
            }
        } catch (Exception unused3) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        super.onResume();
        Log.d("Oncreate:", "onResume");
        try {
            Dialog dialog = this.M;
            if (dialog == null || !U || dialog.isShowing()) {
                return;
            }
            Log.d("trace_dialog=", "onResume");
            this.M.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Log.d("Oncreate:", "Main_onStop");
    }

    public final void p0() {
        this.f.Pc(this);
        if (this.f.ia("alarm_device_boot", "0").equals("1")) {
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(this, (Class<?>) DeviceBootReceiver.class), 1, 1);
        this.f.Lc("alarm_device_boot", "1");
    }

    public void r0() {
        try {
            if (getIntent().getStringExtra("bk_filename") == null) {
                return;
            }
            String stringExtra = getIntent().getStringExtra("bk_filename");
            if (Build.VERSION.SDK_INT < 31) {
                I();
            }
            this.f.he();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(stringExtra);
            builder.setMessage(getString(R.string.backup_folder) + StringUtilities.LF + Z00.L);
            builder.setCancelable(true).setPositiveButton(getString(R.string.share), new x(stringExtra)).setNegativeButton(getString(R.string.btn_save), new w());
            builder.create().show();
        } catch (Exception unused) {
        }
    }

    public void s0(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        U = z;
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
            if (z) {
                AlertDialog alertDialogCreate = builder.create();
                this.M = alertDialogCreate;
                alertDialogCreate.setCancelable(false);
                this.M.show();
            } else {
                Dialog dialog = this.M;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
    }

    public void t0() {
        if (!this.f.S()) {
            if (this.f.X4("select count(*) as _id from sqlite_master where type='table' and name='table_action'").equals("1")) {
                this.f.mc();
            }
        } else {
            this.f.v0("update trigger_flags set is_active=1");
            this.f.Lc("online_share_type", "1");
            C1839c10.o(this.f);
            if (AbstractC4158vt.a(this)) {
                AbstractC3132jE.d(new Callable() { // from class: ip
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.a.c0();
                    }
                }).m(IN.c()).g().e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: jp
                    @Override // defpackage.InterfaceC2295gf
                    public final void accept(Object obj) {
                        FragmentStatePagerSupport_Main.d0((Integer) obj);
                    }
                });
            }
        }
    }

    public final void u0(int i2) {
        switch (i2) {
            case -1:
                this.F.closeDrawer(this.L);
                break;
            case 0:
                if (Build.VERSION.SDK_INT < 31) {
                    I();
                }
                if (C2160f10.h > 0 && !new C2160f10(this.f).l("-4", "view")) {
                    Toast.makeText(this, getString(R.string.no_priv), 0).show();
                    this.F.closeDrawer(this.L);
                } else {
                    String strC8 = Z00.C8();
                    AbstractC2242g10.c(this, "inv.db", strC8 + "-inv.db", "info.aalmoghalis.inventory");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(strC8 + "-inv.db");
                    builder.setMessage(getString(R.string.backup_folder) + "\n\n" + Z00.L + "\n\n" + getString(R.string.backup_info));
                    builder.setCancelable(true).setPositiveButton(getString(R.string.share), new m(strC8)).setNegativeButton(getString(R.string.btn_save), new l());
                    builder.create().show();
                    this.F.closeDrawer(this.L);
                }
                break;
            case 1:
                if (Build.VERSION.SDK_INT < 31) {
                    I();
                }
                AbstractC2242g10.c(this, "inv.db", Z00.C8() + "-inv.db", "info.aalmoghalis.inventory");
                if ((C2160f10.h > 0 && !new C2160f10(this.f).l("-5", "view")) || this.f.S()) {
                    Toast.makeText(this, getString(R.string.no_priv), 0).show();
                    this.F.closeDrawer(this.L);
                } else {
                    P();
                    this.F.closeDrawer(this.L);
                }
                break;
            case 2:
                if (C2160f10.h > 0) {
                    V();
                    this.F.closeDrawer(this.L);
                    break;
                } else {
                    H();
                    if (Build.VERSION.SDK_INT < 31) {
                        I();
                    }
                    try {
                        if (this.f.ia("auto_drive_date_save", "").equals(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime())) && this.f.ia("db_data_changed", "0").equals("0")) {
                            Intent intent = new Intent(this, (Class<?>) Google_drive_list.class);
                            intent.putExtra("bk_flag", "0");
                            intent.putExtra("auto_filename", "");
                            startActivityForResult(intent, 1);
                            this.F.closeDrawer(this.L);
                        } else {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                            builder2.setMessage(getString(R.string.drive_confirm));
                            builder2.setCancelable(true).setPositiveButton(getString(R.string.confirm_yes), new p()).setNegativeButton(getString(R.string.confirm_no), new n());
                            builder2.create().show();
                            this.F.closeDrawer(this.L);
                        }
                        break;
                    } catch (Exception unused) {
                    }
                }
                break;
            case 3:
                if (C2160f10.h > 0) {
                    this.f.Ld(this);
                    this.F.closeDrawer(this.L);
                } else {
                    startActivity(new Intent(this, (Class<?>) Account_Tree_Main.class));
                }
                break;
            case 4:
                if (C2160f10.h > 0) {
                    T();
                    this.F.closeDrawer(this.L);
                } else {
                    if (Build.VERSION.SDK_INT < 31) {
                        I();
                    }
                    startActivityForResult(new Intent(this, (Class<?>) SettingsActivity.class), 1);
                    this.F.closeDrawer(this.L);
                }
                break;
            case 5:
                V();
                this.F.closeDrawer(this.L);
                break;
            case 6:
                this.f.Ld(this);
                this.F.closeDrawer(this.L);
                break;
            case 7:
                T();
                this.F.closeDrawer(this.L);
                break;
        }
    }

    public void v0(boolean z) {
        s0(true);
        AbstractC3132jE.d(new Callable() { // from class: gp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.e0();
            }
        }).m(IN.c()).e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: hp
            @Override // defpackage.InterfaceC2295gf
            public final void accept(Object obj) {
                this.a.f0((Integer) obj);
            }
        });
    }

    public void w0() {
        try {
            if (this.f.ja("prefOthers_closed_year", false)) {
                Log.d("check_yr_data:", "" + this.f.ja("prefOthers_closed_year", false) + ":" + this.f.N2());
                if (this.f.N2() == 0) {
                    this.f.Mc("prefOthers_closed_year", false);
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(R.string.current_year_data));
                builder.setCancelable(true).setPositiveButton(getString(R.string.confirm_yes), new d()).setNegativeButton(getString(R.string.confirm_no), new c());
                builder.create().show();
            }
        } catch (Exception unused) {
        }
    }

    public void x0() {
        try {
            Calendar calendar = Calendar.getInstance();
            Locale locale = Locale.ENGLISH;
            new SimpleDateFormat("dd-MM-yyyy", locale).format(calendar.getTime());
            String str = new SimpleDateFormat("dd-MM-yyyy", locale).format(calendar.getTime());
            Log.d("job_ser_he", "is_past_job:Main");
            if (!this.f.ia("PREF_ACCOUNT_NAME", "0").equals("0") && !this.f.ea()) {
                return;
            }
            if (this.f.ia("first_run", "0").equals("0") || this.f.ia("drive_check_date", "").equals(str) || this.f.S3() < 20) {
                return;
            }
            this.f.Lc("drive_check_date", str);
            if (!this.f.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
                U();
                return;
            }
            Log.d("view_drive=", HTML.Attribute.START);
            Intent intent = new Intent(this, (Class<?>) Google_drive_list.class);
            intent.putExtra("change_email_flag", "1");
            startActivity(intent);
        } catch (Exception e2) {
            Log.d("view_drive_err=", e2.getMessage() + "");
            e2.printStackTrace();
        }
    }

    public void y0() {
        try {
            if (this.f.ia("hint_tax_check", "0").equals("1")) {
                return;
            }
            if (this.f.S3() == 0) {
                this.f.Lc("hint_tax_check", "1");
                return;
            }
            this.f.Lc("hint_tax_check", "1");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.tax_confirm));
            builder.setCancelable(true).setPositiveButton(getString(R.string.confirm_yes), new b()).setNegativeButton(getString(R.string.confirm_no), new a());
            builder.create().show();
        } catch (Exception e2) {
            Log.d("adv_search_error=", ":" + e2.getMessage());
        }
    }
}
