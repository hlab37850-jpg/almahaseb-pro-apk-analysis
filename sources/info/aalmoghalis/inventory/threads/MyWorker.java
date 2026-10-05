package info.aalmoghalis.inventory.threads;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import defpackage.AbstractC0605Iq;
import defpackage.AbstractC2242g10;
import defpackage.C0631Jq;
import defpackage.C2160f10;
import defpackage.C3966tX;
import defpackage.V50;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class MyWorker extends Worker {
    public SQLiteDatabase a;
    public Z00 b;
    public Context c;
    public String d;
    public boolean e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyWorker myWorker = MyWorker.this;
            new C0631Jq(myWorker.c, myWorker.b).c();
        }
    }

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.d = "";
        this.e = true;
    }

    public void a() {
        Log.d("job_ser_w", "doInBackground:" + Z00.t0 + ":" + this.b.ia("auto_drive_date_save", "") + ":" + FragmentStatePagerSupport_Main.b0);
        try {
            if (this.b.ja("prefAutoBackup", true)) {
                if (!this.b.ia("db_data_changed2", "0").equals("0") && new C2160f10(this.c, this.b).i()) {
                    Calendar calendar = Calendar.getInstance();
                    Locale locale = Locale.ENGLISH;
                    this.d = new SimpleDateFormat("dd-MM-yyyy", locale).format(calendar.getTime());
                    this.b.he();
                    if (new C2160f10(this.c, this.b).h(Z00.L, this.d + ".db")) {
                        this.d = new SimpleDateFormat("yyyy-MM-dd", locale).format(calendar.getTime());
                        this.e = false;
                    }
                    if (!FragmentStatePagerSupport_Main.b0.equals("2") || this.e) {
                        AbstractC2242g10.d(this.c, Z00.L, "inv.db", this.d + ".db", "info.aalmoghalis.inventory");
                        this.b.Lc("db_data_changed", "0");
                        this.b.Lc("last_backup_time", System.currentTimeMillis() + "");
                        this.b.Lc("bk_drive_flag", "0");
                        this.b.Lc("auto_filename", this.d + ".db");
                        this.b.Lc("auto_drive_date_request", this.d);
                        String strIa = this.b.ia("bk_drive_flag", "0");
                        FragmentStatePagerSupport_Main.b0 = strIa;
                        if (strIa.equals("0") && this.b.ja("prefAutoBackup", true)) {
                            Log.d("drive=", "start:");
                            new Handler(Looper.getMainLooper()).post(new a());
                            this.b.Lc("bk_drive_flag", FragmentStatePagerSupport_Main.b0);
                        } else {
                            Log.d("drive=", "Not_start:");
                        }
                        if (this.e) {
                            b(this.d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.b.Pc(this.c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(String str) {
        try {
            Log.d("job_ser_w", "onPostExecute:" + str);
            Intent intent = new Intent(this.c, (Class<?>) FragmentStatePagerSupport_Main.class);
            intent.putExtra("auto_back", "1");
            intent.putExtra("bk_filename", str + ".db");
            int i = Build.VERSION.SDK_INT;
            PendingIntent activity = i >= 31 ? PendingIntent.getActivity(this.c, 0, intent, 33554432) : PendingIntent.getActivity(this.c, 0, intent, 1140850688);
            NotificationManager notificationManager = (NotificationManager) this.c.getSystemService("notification");
            if (i >= 26) {
                V50.a();
                NotificationChannel notificationChannelA = AbstractC0605Iq.a("my_channel_id_01", "My Notifications", 3);
                notificationChannelA.setDescription(this.c.getString(R.string.auto_backup_notify));
                notificationChannelA.enableLights(true);
                notificationChannelA.setLightColor(SupportMenu.CATEGORY_MASK);
                notificationChannelA.setVibrationPattern(new long[]{0, 1000, 500, 1000});
                notificationChannelA.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannelA);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.c, "my_channel_id_01");
            builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle(this.c.getString(R.string.auto_backup_notify)).setSmallIcon(R.mipmap.ic_launcher).setContentText(this.b.ia("prefBackup_path", Z00.L) + "/" + str + ".db");
            builder.setContentIntent(activity);
            new C3966tX().b(this.c);
            notificationManager.notify(R.mipmap.ic_launcher, builder.build());
        } catch (Exception e) {
            Log.d("job_ser_err", e.getMessage() + "");
            e.printStackTrace();
        }
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        this.c = getApplicationContext();
        Z00 z00 = new Z00(this.a, this.c);
        this.b = z00;
        z00.Lc("notify_backup", "0");
        Log.d("job_ser", "Service running..before..:" + this.b.ia("db_data_changed", "0") + ":" + this.b.ia("notify_backup", "0"));
        a();
        return ListenableWorker.Result.success();
    }
}
