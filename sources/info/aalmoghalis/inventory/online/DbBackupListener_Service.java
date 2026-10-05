package info.aalmoghalis.inventory.online;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
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
@RequiresApi(api = 21)
public class DbBackupListener_Service extends JobService {
    public SQLiteDatabase a;
    public Z00 b;
    public Context c;
    public b d;
    public String e = "";
    public boolean f = true;

    public class a extends b {
        public final /* synthetic */ JobParameters b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JobParameters jobParameters) {
            super(DbBackupListener_Service.this, null);
            this.b = jobParameters;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            DbBackupListener_Service.this.jobFinished(this.b, true);
        }
    }

    public class b extends AsyncTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DbBackupListener_Service dbBackupListener_Service = DbBackupListener_Service.this;
                new C0631Jq(dbBackupListener_Service.c, dbBackupListener_Service.b).c();
            }
        }

        public b() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            Log.d("job_ser_L", "doInBackground");
            if (!DbBackupListener_Service.this.b.ja("prefAutoBackup", true)) {
                return null;
            }
            if (!DbBackupListener_Service.this.b.ia("db_data_changed2", "0").equals("0")) {
                DbBackupListener_Service dbBackupListener_Service = DbBackupListener_Service.this;
                if (new C2160f10(dbBackupListener_Service.c, dbBackupListener_Service.b).i()) {
                    Calendar calendar = Calendar.getInstance();
                    Locale locale = Locale.ENGLISH;
                    DbBackupListener_Service.this.e = new SimpleDateFormat("dd-MM-yyyy", locale).format(calendar.getTime());
                    DbBackupListener_Service.this.b.he();
                    DbBackupListener_Service dbBackupListener_Service2 = DbBackupListener_Service.this;
                    if (new C2160f10(dbBackupListener_Service2.c, dbBackupListener_Service2.b).h(Z00.L, DbBackupListener_Service.this.e + ".db")) {
                        DbBackupListener_Service.this.e = new SimpleDateFormat("yyyy-MM-dd", locale).format(calendar.getTime());
                        DbBackupListener_Service.this.f = false;
                    }
                    AbstractC2242g10.d(DbBackupListener_Service.this.c, Z00.L, "inv.db", DbBackupListener_Service.this.e + ".db", "info.aalmoghalis.inventory");
                    DbBackupListener_Service.this.b.Lc("db_data_changed", "0");
                    DbBackupListener_Service.this.b.Lc("last_backup_time", System.currentTimeMillis() + "");
                    DbBackupListener_Service.this.b.Lc("bk_drive_flag", "0");
                    DbBackupListener_Service.this.b.Lc("auto_filename", DbBackupListener_Service.this.e + ".db");
                    DbBackupListener_Service dbBackupListener_Service3 = DbBackupListener_Service.this;
                    dbBackupListener_Service3.b.Lc("auto_drive_date_request", dbBackupListener_Service3.e);
                    try {
                        String strIa = DbBackupListener_Service.this.b.ia("bk_drive_flag", "0");
                        FragmentStatePagerSupport_Main.b0 = strIa;
                        if (strIa.equals("0") && DbBackupListener_Service.this.b.ja("prefAutoBackup", true)) {
                            new Handler(Looper.getMainLooper()).post(new a());
                            DbBackupListener_Service.this.b.Lc("bk_drive_flag", FragmentStatePagerSupport_Main.b0);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    DbBackupListener_Service dbBackupListener_Service4 = DbBackupListener_Service.this;
                    if (dbBackupListener_Service4.f) {
                        dbBackupListener_Service4.a(dbBackupListener_Service4.e);
                    }
                    return null;
                }
            }
            DbBackupListener_Service dbBackupListener_Service5 = DbBackupListener_Service.this;
            dbBackupListener_Service5.b.Pc(dbBackupListener_Service5.c);
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Log.d("job_ser_L", "onPreExecute");
            DbBackupListener_Service dbBackupListener_Service = DbBackupListener_Service.this;
            DbBackupListener_Service dbBackupListener_Service2 = DbBackupListener_Service.this;
            dbBackupListener_Service.b = new Z00(dbBackupListener_Service2.a, dbBackupListener_Service2.getApplicationContext());
            DbBackupListener_Service dbBackupListener_Service3 = DbBackupListener_Service.this;
            dbBackupListener_Service3.c = dbBackupListener_Service3.getApplicationContext();
            DbBackupListener_Service dbBackupListener_Service4 = DbBackupListener_Service.this;
            DbBackupListener_Service dbBackupListener_Service5 = DbBackupListener_Service.this;
            dbBackupListener_Service4.b = new Z00(dbBackupListener_Service5.a, dbBackupListener_Service5.c);
        }

        public /* synthetic */ b(DbBackupListener_Service dbBackupListener_Service, a aVar) {
            this();
        }
    }

    public void a(String str) {
        try {
            Log.d("job_ser_L", "onPostExecute");
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

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        a aVar = new a(jobParameters);
        this.d = aVar;
        aVar.execute(new Void[0]);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        b bVar = this.d;
        if (bVar == null) {
            return false;
        }
        bVar.cancel(true);
        return false;
    }
}
