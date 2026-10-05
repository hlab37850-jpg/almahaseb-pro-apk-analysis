package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.itextpdf.text.Annotation;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_adj2;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit4;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit5;
import info.aalmoghalis.inventory.activity.SettingsActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: tX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3966tX {
    public static ParcelFileDescriptor c;
    public String[] a = {"application/x-sqlite3", "application/vnd.sqlite3", "application/octet-stream", "application/x-trash"};
    public View.OnTouchListener b = new e();

    /* JADX INFO: renamed from: tX$a */
    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ActivityCompat.requestPermissions((Activity) this.a, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 123);
        }
    }

    /* JADX INFO: renamed from: tX$b */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: tX$c */
    public class c extends WebViewClient {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            String str2 = this.a;
            if (str2 != null) {
                webView.loadUrl(str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX INFO: renamed from: tX$d */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: renamed from: tX$e */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setBackgroundColor(ColorUtils.setAlphaComponent(view.getDrawingCacheBackgroundColor(), 30));
            } else if (action == 1 || action == 3) {
                view.setBackgroundColor(ColorUtils.setAlphaComponent(view.getDrawingCacheBackgroundColor(), 0));
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: tX$f */
    public class f implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Z00 b;
        public final /* synthetic */ C4064uh c;

        public f(int i, Z00 z00, C4064uh c4064uh) {
            this.a = i;
            this.b = z00;
            this.c = c4064uh;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i == 1) {
                Z00 z00 = this.b;
                String strO = this.c.o();
                Z00 z01 = this.b;
                C4064uh c4064uh = this.c;
                z00.Rc(strO, z01.Dd(c4064uh, c4064uh.m(), Double.parseDouble(this.c.c()), this.c.q()));
                return;
            }
            if (i == 3) {
                Z00 z02 = this.b;
                String strO2 = this.c.o();
                Z00 z03 = this.b;
                C4064uh c4064uh2 = this.c;
                z02.Ed(strO2, z03.Dd(c4064uh2, c4064uh2.m(), Double.parseDouble(this.c.c()), this.c.q()));
            }
        }
    }

    /* JADX INFO: renamed from: tX$g */
    public class g implements Runnable {
        public final /* synthetic */ Z00 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Handler d;
        public final /* synthetic */ E00 e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Activity g;

        /* JADX INFO: renamed from: tX$g$a */
        public class a implements Runnable {
            public final /* synthetic */ List a;

            public a(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.size() > 0) {
                    g gVar = g.this;
                    E00 e00 = gVar.e;
                    if (e00.i == 0) {
                        e00.i = 1;
                    }
                    if (e00.t) {
                        if (C1839c10.m(gVar.a, ((C4064uh) this.a.get(0)).x)) {
                            g.this.e.s = 3;
                        } else {
                            if (!C1839c10.l(g.this.a, ((C4064uh) this.a.get(0)).x)) {
                                g gVar2 = g.this;
                                E00 e01 = gVar2.e;
                                e01.i++;
                                C3966tX.this.G(gVar2.g, gVar2.a, e01, gVar2.b, gVar2.c, this.a);
                                return;
                            }
                            g.this.e.s = 1;
                        }
                        g gVar3 = g.this;
                        C3966tX c3966tX = C3966tX.this;
                        Activity activity = gVar3.g;
                        Z00 z00 = gVar3.a;
                        E00 e02 = gVar3.e;
                        c3966tX.B(activity, z00, e02, e02.s, (C4064uh) this.a.get(e02.i - 1));
                        return;
                    }
                    int i = gVar.f;
                    if (i == R.id.menu_sms) {
                        e00.s = 1;
                        C3966tX.this.B(gVar.g, gVar.a, e00, 1, (C4064uh) this.a.get(0));
                        return;
                    }
                    if (i == R.id.menu_whats) {
                        e00.s = 3;
                        if (!(gVar.g instanceof Customer_Det_List_edit5) || this.a.size() != 1) {
                            g gVar4 = g.this;
                            C3966tX.this.B(gVar4.g, gVar4.a, gVar4.e, 3, (C4064uh) this.a.get(0));
                            return;
                        }
                        String string = ((Customer_Det_List_edit5) g.this.g).getTitle().toString();
                        ((Customer_Det_List_edit5) g.this.g).j1();
                        if (((C4064uh) this.a.get(0)).o() == null || ((C4064uh) this.a.get(0)).o().length() < 3) {
                            E00 e03 = g.this.e;
                            e03.j = 6;
                            e03.u = true;
                            e03.p = string;
                            e03.r = (C4064uh) this.a.get(0);
                            g gVar5 = g.this;
                            gVar5.e.c(gVar5.g, gVar5.a, ((C4064uh) this.a.get(0)).m(), ((C4064uh) this.a.get(0)).o());
                            return;
                        }
                        g.this.a.F(((C4064uh) this.a.get(0)).o(), g.this.a.Dd((C4064uh) this.a.get(0), ((C4064uh) this.a.get(0)).t, Double.parseDouble(((C4064uh) this.a.get(0)).c()), ((C4064uh) this.a.get(0)).q()), ((C4064uh) this.a.get(0)).x, string + ".jpg", 2);
                    }
                }
            }
        }

        public g(Z00 z00, int i, int i2, Handler handler, E00 e00, int i3, Activity activity) {
            this.a = z00;
            this.b = i;
            this.c = i2;
            this.d = handler;
            this.e = e00;
            this.f = i3;
            this.g = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d.post(new a(this.a.N0(this.b + "", this.c)));
        }
    }

    public static void D(final Activity activity, String str) {
        new AlertDialog.Builder(activity).setTitle(activity.getString(R.string.permission_required)).setMessage(str).setPositiveButton(activity.getString(R.string.setting_title), new DialogInterface.OnClickListener() { // from class: sX
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3966tX.w(activity, dialogInterface, i);
            }
        }).setNegativeButton(activity.getString(R.string.alert_cancel), (DialogInterface.OnClickListener) null).show();
    }

    public static String J(long j) {
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format((Date) new Timestamp(j));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void e(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions((Activity) context, new String[]{"android.permission.WRITE_CONTACTS"}, 114);
    }

    public static boolean h(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 23 || i >= 31 || ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        Activity activity = (Activity) context;
        if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.READ_EXTERNAL_STORAGE")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 123);
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle("Permission necessary");
        builder.setMessage("External storage permission is necessary");
        builder.setPositiveButton(android.R.string.yes, new a(context));
        builder.create().show();
        return false;
    }

    public static boolean j(Context context, Z00 z00, boolean z) {
        if (z && context != null && z00.ja("prefOthers_closed_year", false)) {
            z00.Kd(context, context.getString(R.string.pref_other_closed_year), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        return z00.ja("prefOthers_closed_year", false);
    }

    public static /* synthetic */ void w(Activity activity, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
    }

    public void A(Context context, ListView listView, TextView textView, int i) {
        if (listView == null || textView == null || context == null) {
            return;
        }
        if (i >= 0) {
            textView.setText(context.getString(R.string.empty_list));
            textView.setVisibility(0);
            listView.setEmptyView(textView);
        } else if (i == -1) {
            textView.setText(context.getString(R.string.wait));
            listView.setEmptyView(null);
            textView.setVisibility(0);
        } else if (i == -2) {
            textView.setText("......");
            listView.setEmptyView(null);
            textView.setVisibility(0);
        }
    }

    public void B(Activity activity, Z00 z00, E00 e00, int i, C4064uh c4064uh) {
        e00.j = 0;
        e00.s = i;
        if (c4064uh.o() != null && c4064uh.o().length() >= 3) {
            new Handler(Looper.getMainLooper()).postDelayed(new f(i, z00, c4064uh), 0L);
            return;
        }
        if (i == 1) {
            e00.j = 7;
        } else if (i == 3) {
            e00.j = 6;
        }
        e00.r = c4064uh;
        e00.c(activity, z00, c4064uh.m(), c4064uh.o());
    }

    public String C(Activity activity, Z00 z00) {
        ListView listView;
        HashMap mapB1;
        new HashMap();
        if (activity instanceof Bill_adj2) {
            Bill_adj2 bill_adj2 = (Bill_adj2) activity;
            listView = bill_adj2.P;
            mapB1 = bill_adj2.c1();
        } else {
            if (!(activity instanceof Bill_edit)) {
                return "";
            }
            Bill_edit bill_edit = (Bill_edit) activity;
            listView = bill_edit.Q;
            mapB1 = bill_edit.b1();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtilities.LF);
        for (int i = 0; i < listView.getAdapter().getCount(); i++) {
            C0634Jt c0634Jt = (C0634Jt) listView.getAdapter().getItem(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c0634Jt.e());
            sb2.append(c0634Jt.m.equals("") ? "" : " " + c0634Jt.m);
            sb.append(sb2.toString());
            sb.append(" ( ");
            sb.append(c0634Jt.h());
            sb.append(" ) ");
            sb.append(activity.getString(R.string.value));
            sb.append(" ");
            sb.append(c0634Jt.n());
        }
        if (Double.parseDouble((String) mapB1.get("tr_total_disc")) != 0.0d) {
            sb.append(StringUtilities.LF);
            sb.append(activity.getString(R.string.total_disc));
            sb.append(" ");
            sb.append(z00.P7(String.valueOf(Math.abs(Double.parseDouble((String) mapB1.get("tr_total_disc"))))));
        }
        if (Double.parseDouble((String) mapB1.get("tr_tax")) != 0.0d) {
            sb.append(StringUtilities.LF);
            sb.append(activity.getString(R.string.total_tax));
            sb.append(" ");
            sb.append(z00.P7(String.valueOf(Math.abs(Double.parseDouble((String) mapB1.get("tr_tax"))))));
        }
        if (Double.parseDouble((String) mapB1.get("tr_total_cost")) != 0.0d) {
            sb.append(StringUtilities.LF);
            sb.append(activity.getString(R.string.total_other_cost));
            sb.append(" ");
            sb.append(z00.P7(String.valueOf(Math.abs(Double.parseDouble((String) mapB1.get("tr_total_cost"))))));
        }
        sb.append(StringUtilities.LF);
        sb.append(activity.getString(R.string.total_sum));
        sb.append(" ");
        sb.append(z00.P7(String.valueOf(Math.abs(Double.parseDouble((String) mapB1.get("tr_total"))))));
        if (Double.parseDouble((String) mapB1.get("tr_paid")) != 0.0d) {
            sb.append(StringUtilities.LF);
            sb.append(activity.getString(R.string.paid_amount));
            sb.append(" ");
            sb.append(z00.P7(String.valueOf(Math.abs(Double.parseDouble((String) mapB1.get("tr_paid"))))));
            sb.append(StringUtilities.LF);
            sb.append(activity.getString(R.string.remain_amount));
            sb.append(" ");
            sb.append(z00.P7(String.valueOf(Math.abs(Double.parseDouble((String) mapB1.get("tr_remin"))))));
        }
        return sb.toString();
    }

    public void E(Context context, String str, String str2) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(true);
            if (str.length() > 0) {
                builder.setTitle(str);
            }
            builder.setMessage(str2);
            builder.setPositiveButton(android.R.string.yes, new b());
            builder.create().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void F(Context context, String str) {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
            WebView webView = new WebView(context);
            webView.getSettings().setJavaScriptEnabled(true);
            try {
                webView.loadUrl("file:///android_asset/help.html");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            webView.setWebViewClient(new c(str));
            builder.setView(webView);
            builder.setNegativeButton(context.getString(R.string.confirm_close), new d());
            builder.show();
        } catch (Exception e3) {
            Log.d("help_err=", e3.getMessage() + "");
            e3.printStackTrace();
        }
    }

    public void G(Activity activity, Z00 z00, E00 e00, long j, int i, List list) {
        List listN0;
        if (j == 0 || e00.i <= 0) {
            return;
        }
        if (list == null) {
            listN0 = z00.N0(j + "", i);
        } else {
            listN0 = list;
        }
        if (listN0.size() <= e00.i || listN0.size() == 0 || (e00.s == 3 && e00.i > C2160f10.n)) {
            e00.i = 0;
            e00.s = 0;
            e00.t = false;
            if (activity instanceof Customer_Det_List_edit4) {
                ((Customer_Det_List_edit4) activity).e0(2, i);
                return;
            } else {
                if (activity instanceof Customer_Det_List_edit5) {
                    ((Customer_Det_List_edit5) activity).k0(2, i);
                    return;
                }
                return;
            }
        }
        if (e00.t) {
            if (C1839c10.m(z00, ((C4064uh) listN0.get(e00.i)).x)) {
                e00.s = 3;
            } else {
                if (!C1839c10.l(z00, ((C4064uh) listN0.get(e00.i)).x)) {
                    e00.i++;
                    G(activity, z00, e00, j, i, listN0);
                    return;
                }
                e00.s = 1;
            }
        }
        int i2 = e00.s;
        if (i2 > 0) {
            B(activity, z00, e00, i2, (C4064uh) listN0.get(e00.i));
        }
        e00.i++;
    }

    public void H(Activity activity, Z00 z00, E00 e00, String str, int i) {
        String str2;
        String strH = z00.q4(str).h();
        e00.i = 0;
        e00.s = 0;
        if (i == 0) {
            e00.t = true;
        } else {
            e00.t = false;
        }
        C4064uh c4064uhQ0 = z00.Q0(str, e00.o, e00.m);
        if (C1839c10.m(z00, e00.k) || i == R.id.menu_whats) {
            if (Build.VERSION.SDK_INT < 31) {
                d(activity);
            }
            if (z00.ia("pref_notify_bill_type", "1").equals("1")) {
                String string = ((Bill_edit) activity).getTitle().toString();
                if (activity instanceof Bill_edit) {
                    ((Bill_edit) activity).F1();
                    e00.p = string;
                } else if (activity instanceof Bill_adj2) {
                    Bill_adj2 bill_adj2 = (Bill_adj2) activity;
                    bill_adj2.B1();
                    e00.p = bill_adj2.getTitle().toString();
                }
            } else {
                String string2 = ((Bill_edit) activity).getTitle().toString();
                String[] strArrHa = z00.Ha(e00.m + "", e00.n, "");
                z00.Zd(strArrHa[0], new TextView(activity), string2, strArrHa[1]);
                e00.p = string2;
            }
        }
        int i2 = e00.i;
        if (i2 == 0) {
            e00.i = i2 + 1;
            K(z00, e00, str);
            if (e00.t) {
                e00.j = 0;
            } else if (i == R.id.menu_sms) {
                e00.j = 1;
            } else if (i == R.id.menu_whats) {
                e00.j = 2;
            }
            if (z00.ja("prefOthers_notify_bill_items", false)) {
                String str3 = StringUtilities.LF + activity.getString(R.string.bill_details) + C(activity, z00);
                e00.q = str3;
                str2 = str3;
            } else {
                str2 = "";
            }
            String strCd = c4064uhQ0 != null ? z00.Cd(c4064uhQ0, Double.parseDouble(c4064uhQ0.v), e00.m, e00.n, str2) : "";
            if (C1839c10.k(z00, e00.k) || i != 0) {
                if (strH == null || strH.length() <= 8) {
                    if (strH == null || strH.length() >= 3) {
                        return;
                    }
                    e00.c(activity, z00, str, strH);
                    return;
                }
                z00.F(strH, strCd, e00.k, z00.ic(e00.p) + ".jpg", e00.j);
            }
        }
    }

    public void I(Activity activity, Z00 z00, E00 e00, int i, int i2, int i3) {
        e00.i = 0;
        e00.s = 0;
        if (i3 == 0) {
            e00.t = true;
        } else {
            e00.t = false;
        }
        Executors.newSingleThreadExecutor().execute(new g(z00, i, i2, new Handler(Looper.getMainLooper()), e00, i3, activity));
    }

    public void K(Z00 z00, E00 e00, String str) {
        String strI = z00.q4(str).i();
        e00.k = strI;
        if (C1839c10.l(z00, strI)) {
            e00.j = 1;
        } else if (C1839c10.m(z00, e00.k)) {
            e00.j = 2;
        }
    }

    public void b(Context context) {
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions((Activity) context, new String[]{"android.permission.POST_NOTIFICATIONS"}, 113);
    }

    public void c(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, "android.permission.SEND_SMS") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.SEND_SMS"}, 114);
    }

    public void d(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i < 23 || i >= 31 || ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void f(Activity activity, Z00 z00, E00 e00, String str, int i) {
        if (i > 0) {
            if (i == 0) {
                e00.e = true;
            } else if (i == 1) {
                e00.b = true;
            }
        }
        e00.l = i == -1;
        e00.i = 0;
        y(activity, z00, e00, str);
    }

    public File g(String str, String str2, Z00 z00) {
        Log.d("trace_app_folder=", "old=" + str + ":new=" + str2);
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
            file.mkdir();
        }
        if (file.canWrite() && file.exists()) {
            z00.Lc("prefBackup_path", str2);
            z00.he();
        }
        try {
            SettingsActivity.C(new File(str + "/Pictures/"), new File(z00.ia("prefBackup_path", Z00.L) + "/Pictures/"));
        } catch (Exception e2) {
            Log.d("Copy_err", e2.getMessage() + "");
            e2.printStackTrace();
        }
        return file;
    }

    public boolean i(String str, Z00 z00) {
        File file = new File(str);
        new File(file, "test");
        StringBuilder sb = new StringBuilder();
        sb.append("start:");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        sb.append(":");
        sb.append(str);
        sb.append(":");
        sb.append(file.canWrite());
        sb.append(":");
        sb.append(file.exists());
        Log.d("trace_app_folder=", sb.toString());
        if (i >= 31 && !k(z00)) {
            Log.d("trace_app_folder=", "reCreate:" + i);
            file = g(str, Z00.L5(), z00);
        }
        if (i >= 31) {
            if (file.isDirectory() && file.exists()) {
                if (k(z00)) {
                    return true;
                }
                Log.d("trace_app_folder=", "Exists:" + file.canWrite());
                return file.canWrite() || !g(str, Z00.M5(), z00).canWrite();
            }
            Log.d("trace_app_folder=", "NotExists:" + str);
            File file2 = new File(Z00.L);
            file2.mkdirs();
            file2.mkdir();
            if (file2.canWrite()) {
                z00.Lc("prefBackup_path", file2.getAbsolutePath());
                return false;
            }
            if (!file2.canWrite()) {
                g(Z00.L, Z00.M5(), z00).canWrite();
            }
            return false;
        }
        if (file.isDirectory() && file.canWrite() && file.exists()) {
            Log.d("trace_app_folder=", "Exists&Writable");
            return true;
        }
        Log.d("trace_app_folder=", "Not:Exists&Writable:" + str);
        File file3 = new File(Z00.L);
        file3.mkdirs();
        file3.mkdir();
        Log.d("trace_app_folder=", "Not:Exists&Writable:" + file3.canWrite() + ":" + file3.exists() + ":" + file3.getAbsolutePath());
        if (file3.canWrite()) {
            z00.Lc("prefBackup_path", file3.getAbsolutePath());
        }
        return false;
    }

    public boolean k(Z00 z00) {
        String strIa = z00.ia("prefBackup_path", Z00.L);
        File file = new File(strIa);
        if (file.exists() && file.canWrite() && v(strIa)) {
            return true;
        }
        if (z00.ia("app_path_uri", "").equals("")) {
            return false;
        }
        Uri uri = Uri.parse(z00.ia("app_path_uri", ""));
        if (!strIa.equals(t(uri))) {
            return false;
        }
        Log.d("trace_app_check2=", "path=" + strIa + ":" + t(uri));
        try {
            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(z00.b, uri);
            Log.d("trace_app_check2=", "path=" + documentFileFromTreeUri.canWrite() + ":" + documentFileFromTreeUri.exists());
            return documentFileFromTreeUri.canWrite() && documentFileFromTreeUri.exists();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean l(File file, String str, Z00 z00) {
        return ((file.canWrite() && v(str)) || z00.ia("app_path_uri", "").equals("")) ? false : true;
    }

    public void m(File file, DocumentFile documentFile, Context context) throws IOException {
        if (file.exists()) {
            Log.d("trace_app_copy=", "" + file.getName() + ":" + documentFile.getName());
            FileOutputStream fileOutputStream = new FileOutputStream(context.getContentResolver().openFileDescriptor(documentFile.getUri(), "w").getFileDescriptor());
            FileChannel channel = new FileInputStream(file).getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
        }
    }

    public final void n(File file, File file2) throws IOException {
        if (file.exists()) {
            FileChannel channel = new FileInputStream(file).getChannel();
            FileChannel channel2 = new FileOutputStream(file2).getChannel();
            if (channel2 != null && channel != null) {
                channel2.transferFrom(channel, 0L, channel.size());
            }
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        }
    }

    public File o(Uri uri, String str, Z00 z00) {
        File file;
        Cursor cursorQuery = z00.b.getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (str.equals("")) {
            file = new File(z00.b.getFilesDir() + "/" + string);
        } else {
            File file2 = new File(z00.b.getFilesDir() + "/" + str);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(z00.b.getFilesDir() + "/" + str + "/" + string);
        }
        try {
            InputStream inputStreamOpenInputStream = z00.b.getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i);
            }
            inputStreamOpenInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            Log.e("Exception", e2.getMessage() + "");
        }
        return file;
    }

    public FileOutputStream p(File file, String str, File file2, String str2, Z00 z00) {
        DocumentFile documentFileCreateFile;
        try {
            Log.d("trace_file=", "create_FileOutputStream:" + file.getName() + ":" + file.exists() + ":" + file.canWrite() + ":" + file2.getPath() + ":" + file2.canWrite() + ":" + file.getParentFile().canWrite());
            String strS = s(file.getName());
            if (!file.getParentFile().canWrite() || !new C3966tX().v(file.getParentFile().getPath())) {
                if (!z00.ia("app_path_uri", "").equals("")) {
                    DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(z00.b, Uri.parse(z00.ia("app_path_uri", "")));
                    if (documentFileFromTreeUri.canWrite()) {
                        DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile(file.getName());
                        if (documentFileFindFile == null) {
                            documentFileCreateFile = documentFileFromTreeUri.createFile(strS, file.getName());
                        } else {
                            DocumentsContract.deleteDocument(z00.b.getContentResolver(), documentFileFindFile.getUri());
                            documentFileCreateFile = documentFileFromTreeUri.createFile(strS, file.getName());
                        }
                        try {
                            ParcelFileDescriptor parcelFileDescriptor = c;
                            if (parcelFileDescriptor != null) {
                                parcelFileDescriptor.close();
                            }
                            c = z00.b.getContentResolver().openFileDescriptor(documentFileCreateFile.getUri(), "w");
                            return new FileOutputStream(c.getFileDescriptor());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return new FileOutputStream(file);
                        }
                    }
                }
            }
            return new FileOutputStream(file);
        } catch (Exception e3) {
            e3.printStackTrace();
            Log.d("file=", "random_file:" + file.getName() + ":" + file.exists() + ":" + file.canWrite() + ":" + file2.getPath() + ":" + file2.canWrite());
            StringBuilder sb = new StringBuilder();
            sb.append(r());
            sb.append("");
            Z00.O = sb.toString();
            try {
                return new FileOutputStream(new File(file2, z00.hc(str) + str2));
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    public String q(Uri uri, Z00 z00) {
        if (Annotation.CONTENT.equals(uri.getScheme())) {
            return z00.b.getContentResolver().getType(uri);
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
    }

    public int r() {
        return Calendar.getInstance().get(7);
    }

    public String s(String str) {
        Log.d("trace_file=", "mime_type=:f=" + str);
        return "";
    }

    public String t(Uri uri) {
        String[] strArrSplit = uri.getPath().split(":");
        return Environment.getExternalStorageDirectory().getPath() + "/" + strArrSplit[strArrSplit.length - 1];
    }

    public void u(Context context) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    public boolean v(String str) {
        return str.startsWith(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getPath());
    }

    public String x(Uri uri, boolean z, Z00 z00, Context context) {
        File file;
        try {
            if (uri != null) {
                try {
                    Log.d("trace_img=", "onSelectFromGalleryResult:" + z);
                    File file2 = new File(Z00.M);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    String str = System.currentTimeMillis() + ".jpg";
                    Log.d("trace_app_copy=", "" + str + ":" + file2.canWrite() + ":" + Z00.M + ":" + file2.getName());
                    if (!z00.ia("app_path_uri", "").equals("")) {
                        DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(z00.b, Uri.parse(z00.ia("app_path_uri", "")));
                        if (documentFileFromTreeUri.canWrite()) {
                            if (documentFileFromTreeUri.findFile(file2.getName()) == null) {
                                documentFileFromTreeUri.createDirectory(file2.getName());
                            }
                            DocumentFile documentFileCreateFile = documentFileFromTreeUri.findFile(file2.getName()).createFile("", str);
                            m(o(uri, "tmp", z00), documentFileCreateFile, context);
                            return documentFileCreateFile.getName();
                        }
                    }
                    if (file2.canWrite()) {
                        file = new File(Z00.M, str);
                        file.createNewFile();
                    } else {
                        file = null;
                    }
                    if (file == null) {
                        return null;
                    }
                    if (z) {
                        n(new C3966tX().o(uri, "tmp", z00), file);
                    } else {
                        n(new File(z00.d1(context, uri)), file);
                    }
                    return file.getName();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public void y(Activity activity, Z00 z00, E00 e00, String str) {
        String strH = z00.q4(str).h();
        Log.d("trace_auto_sms=", "sms=" + e00.a + ":sms1=" + e00.b + ":sms2=" + e00.c + ":wa=" + e00.d + ":wa1=" + e00.e + ":wa2=" + e00.f + ":sms_wa=" + e00.g + ":sms_wa_index=" + e00.h + ":cus=" + str + ":" + strH + ":" + e00.l);
        if (!e00.l) {
            if (e00.b || e00.e) {
                C4064uh c4064uhP0 = z00.P0(str);
                e00.k = z00.q4(str).i();
                if (e00.b) {
                    e00.j = 1;
                } else if (e00.e) {
                    e00.j = 2;
                }
                int i = e00.i;
                if (i == 0) {
                    e00.i = i + 1;
                    if (strH != null && strH.length() > 8) {
                        z00.F(strH, z00.Ad(c4064uhP0, str, Double.parseDouble(c4064uhP0.v)), e00.k, e00.p, e00.j);
                        return;
                    } else {
                        if (strH == null || strH.length() >= 3) {
                            return;
                        }
                        e00.c(activity, z00, str, strH);
                        return;
                    }
                }
                if (i != 1) {
                    e00.i = 0;
                    e00.b = false;
                    e00.e = false;
                    return;
                }
                e00.i = i + 1;
                if (!c4064uhP0.m().equals("") && c4064uhP0.o().length() > 8) {
                    z00.F(c4064uhP0.o(), z00.Bd(c4064uhP0, c4064uhP0.m(), Double.parseDouble(c4064uhP0.l())), e00.k, e00.p, e00.j);
                    return;
                }
                if (!c4064uhP0.m().equals("") && c4064uhP0.o().length() < 3) {
                    e00.c(activity, z00, c4064uhP0.m(), c4064uhP0.o());
                    return;
                }
                e00.i = 0;
                e00.b = false;
                e00.e = false;
                return;
            }
            return;
        }
        C4064uh c4064uhP1 = z00.P0(str);
        int i2 = e00.i;
        if (i2 != 0) {
            if (i2 != 1) {
                e00.i = 0;
                e00.l = false;
                return;
            }
            e00.i = i2 + 1;
            K(z00, e00, c4064uhP1.m());
            if (!C1839c10.k(z00, e00.k)) {
                e00.i = 0;
                e00.l = false;
                return;
            } else if (!c4064uhP1.m().equals("") && c4064uhP1.o().length() > 8) {
                z00.F(c4064uhP1.o(), z00.Bd(c4064uhP1, c4064uhP1.m(), Double.parseDouble(c4064uhP1.l())), e00.k, e00.p, e00.j);
                return;
            } else {
                if (c4064uhP1.m().equals("") || c4064uhP1.o().length() >= 3) {
                    return;
                }
                e00.c(activity, z00, c4064uhP1.m(), c4064uhP1.o());
                return;
            }
        }
        e00.i = i2 + 1;
        K(z00, e00, str);
        if (C1839c10.k(z00, e00.k)) {
            if (strH != null && strH.length() > 8) {
                z00.F(strH, z00.Ad(c4064uhP1, str, Double.parseDouble(c4064uhP1.v)), e00.k, e00.p, e00.j);
                return;
            } else {
                if (strH == null || strH.length() >= 3) {
                    return;
                }
                e00.c(activity, z00, str, strH);
                return;
            }
        }
        e00.i++;
        K(z00, e00, c4064uhP1.m());
        if (!C1839c10.k(z00, e00.k)) {
            e00.i = 0;
            e00.l = false;
        } else if (!c4064uhP1.m().equals("") && c4064uhP1.o().length() > 8) {
            z00.F(c4064uhP1.o(), z00.Bd(c4064uhP1, c4064uhP1.m(), Double.parseDouble(c4064uhP1.l())), e00.k, e00.p, e00.j);
        } else {
            if (c4064uhP1.m().equals("") || c4064uhP1.o().length() >= 3) {
                return;
            }
            e00.c(activity, z00, c4064uhP1.m(), c4064uhP1.o());
        }
    }

    public void z(Context context, RecyclerView recyclerView, TextView textView, int i) {
        if (i == 0) {
            textView.setText(context.getString(R.string.empty_list));
            textView.setVisibility(0);
            recyclerView.setVisibility(8);
            return;
        }
        if (i == -1) {
            textView.setText(context.getString(R.string.wait));
            textView.setVisibility(0);
            return;
        }
        if (i == -2) {
            textView.setText("......");
            textView.setVisibility(0);
        } else if (i != -3) {
            textView.setVisibility(8);
            recyclerView.setVisibility(0);
        } else {
            textView.setText(context.getString(R.string.wait));
            textView.setVisibility(0);
            recyclerView.setVisibility(4);
        }
    }
}
