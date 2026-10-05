package info.aalmoghalis.inventory.threads;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import defpackage.AbstractC2242g10;
import defpackage.C0631Jq;
import defpackage.C1044Xj;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class HelloService extends Service {
    public Looper a;
    public a b;
    public Context c;
    public SQLiteDatabase d;
    public Z00 e;
    public String f = "";
    public int[] g = {R.drawable.up, 1, R.drawable.down};

    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Z00.Z = true;
                HelloService helloService = HelloService.this;
                if (helloService.b(helloService.e.ia("prefBackup_path", Z00.L))) {
                    HelloService.this.e.he();
                } else {
                    HelloService.this.e.Lc("prefBackup_path", Z00.L);
                    HelloService.this.e.he();
                    File file = new File(Z00.L);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                }
                HelloService helloService2 = HelloService.this;
                C1044Xj.a().c(new RunnableC1171Zj(6, helloService2.e, helloService2.c));
                HelloService helloService3 = HelloService.this;
                C1044Xj.a().c(new RunnableC1171Zj(7, helloService3.e, helloService3.c));
                HelloService helloService4 = HelloService.this;
                C1044Xj.a().c(new RunnableC1171Zj(8, helloService4.e, helloService4.c));
                HelloService helloService5 = HelloService.this;
                C1044Xj.a().c(new RunnableC1171Zj(9, helloService5.e, helloService5.c));
                HelloService helloService6 = HelloService.this;
                C1044Xj.a().c(new RunnableC1171Zj(10, helloService6.e, helloService6.c, HelloService.this.e.ia("token", ""), HelloService.this.e.ia("payload", "0")));
                HelloService helloService7 = HelloService.this;
                C1044Xj.a().c(new RunnableC1171Zj(21, helloService7.e, helloService7.c));
                if (!HelloService.this.e.ja("prefAutoBackup", true) || HelloService.this.e.ia("db_data_changed", "0").equals("0")) {
                    return;
                }
                String str = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                if (!HelloService.this.e.ea()) {
                    return;
                }
                HelloService.this.e.he();
                AbstractC2242g10.d(HelloService.this.c, Z00.L, "inv.db", str + ".db", "info.aalmoghalis.inventory");
                HelloService.this.e.Lc("db_data_changed", "0");
                HelloService.this.e.Lc("bk_drive_flag", "0");
                HelloService.this.e.Lc("auto_filename", str + ".db");
                HelloService.this.e.Lc("auto_drive_date_request", str);
                HelloService.this.e.Lc("last_backup_time", System.currentTimeMillis() + "");
                String strIa = HelloService.this.e.ia("bk_drive_flag", "0");
                FragmentStatePagerSupport_Main.b0 = strIa;
                if (strIa.equals("0") && HelloService.this.e.ja("prefAutoBackup", true)) {
                    new C0631Jq(HelloService.this.c, HelloService.this.e).c();
                    HelloService.this.e.Lc("bk_drive_flag", FragmentStatePagerSupport_Main.b0);
                }
                HelloService.this.e.Mc("hello_serv", true);
            } catch (Exception e) {
                Log.d("service_err", e.getMessage() + "");
                Thread.currentThread().interrupt();
            }
            HelloService.this.stopSelf(message.arg1);
        }
    }

    public boolean b(String str) {
        Log.d("trace_S_app_folder=", FragmentStatePagerSupport_Main.X());
        File file = new File(str);
        new File(file, "test");
        if (file.isDirectory() && file.canWrite() && file.exists()) {
            Log.d("trace_E_app_folder=", FragmentStatePagerSupport_Main.X());
            return true;
        }
        Toast.makeText(this, getString(R.string.app_path) + "#" + str, 1).show();
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.c = getApplicationContext();
        this.e = new Z00(this.d, this.c);
        HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
        handlerThread.start();
        this.a = handlerThread.getLooper();
        this.b = new a(this.a);
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.c == null || this.e == null) {
            this.c = getApplicationContext();
            this.e = new Z00(this.d, this.c);
        }
        Message messageObtainMessage = this.b.obtainMessage();
        messageObtainMessage.arg1 = i2;
        this.b.sendMessage(messageObtainMessage);
        return 1;
    }
}
