package info.aalmoghalis.inventory.threads;

import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import defpackage.AbstractC2242g10;
import defpackage.C0631Jq;
import defpackage.C1044Xj;
import defpackage.C2160f10;
import defpackage.C3966tX;
import defpackage.RunnableC1171Zj;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class HelloService_Job extends JobService {
    public Context a;
    public SQLiteDatabase b;
    public Z00 c;
    public b f;
    public int[] d = {R.drawable.up, 1, R.drawable.down};
    public int e = 0;
    public String g = "";
    public boolean h = true;

    public class a extends b {
        public final /* synthetic */ JobParameters b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JobParameters jobParameters) {
            super(HelloService_Job.this, null);
            this.b = jobParameters;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r4) {
            super.onPostExecute(r4);
            Log.d("job_ser_he", "onPostExecute:" + HelloService_Job.this.c.ja("hello_serv", false));
            HelloService_Job.this.c.Mc("hello_serv", true);
            HelloService_Job.this.jobFinished(this.b, true);
        }
    }

    public class b extends AsyncTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new C0631Jq(HelloService_Job.this.a, HelloService_Job.this.c).c();
            }
        }

        public b() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            Log.d("job_ser_he", "doInBackground:" + HelloService_Job.this.c.ja("hello_serv", false) + ":" + HelloService_Job.this.c.ia("auto_drive_date_save", ""));
            try {
                if (HelloService_Job.this.c.ja("hello_serv", true)) {
                    return null;
                }
                Log.d("trace_job_start=", "start:" + HelloService_Job.this.c.ia("db_cus_changed", "1"));
                if (new C3966tX().i(HelloService_Job.this.c.ia("prefBackup_path", Z00.L), HelloService_Job.this.c)) {
                    HelloService_Job.this.c.he();
                } else {
                    HelloService_Job.this.c.Lc("prefBackup_path", Z00.L);
                    HelloService_Job.this.c.he();
                }
                HelloService_Job helloService_Job = HelloService_Job.this;
                C1044Xj.a().c(new RunnableC1171Zj(7, helloService_Job.c, helloService_Job.a));
                HelloService_Job helloService_Job2 = HelloService_Job.this;
                C1044Xj.a().c(new RunnableC1171Zj(8, helloService_Job2.c, helloService_Job2.a));
                HelloService_Job helloService_Job3 = HelloService_Job.this;
                C1044Xj.a().c(new RunnableC1171Zj(10, helloService_Job3.c, helloService_Job3.a, HelloService_Job.this.c.ia("token", ""), HelloService_Job.this.c.ia("payload", "0")));
                HelloService_Job helloService_Job4 = HelloService_Job.this;
                C1044Xj.a().c(new RunnableC1171Zj(21, helloService_Job4.c, helloService_Job4.a));
                if (!HelloService_Job.this.c.ja("prefAutoBackup", true)) {
                    HelloService_Job helloService_Job5 = HelloService_Job.this;
                    C1044Xj.a().c(new RunnableC1171Zj(6, helloService_Job5.c, helloService_Job5.a));
                    return null;
                }
                if (HelloService_Job.this.c.ia("db_data_changed", "0").equals("0")) {
                    HelloService_Job helloService_Job6 = HelloService_Job.this;
                    C1044Xj.a().c(new RunnableC1171Zj(6, helloService_Job6.c, helloService_Job6.a));
                    return null;
                }
                Calendar calendar = Calendar.getInstance();
                Locale locale = Locale.ENGLISH;
                HelloService_Job.this.g = new SimpleDateFormat("dd-MM-yyyy", locale).format(calendar.getTime());
                if (!HelloService_Job.this.c.ea()) {
                    HelloService_Job helloService_Job7 = HelloService_Job.this;
                    C1044Xj.a().c(new RunnableC1171Zj(6, helloService_Job7.c, helloService_Job7.a));
                    return null;
                }
                HelloService_Job.this.c.he();
                if (new C2160f10(HelloService_Job.this.a, HelloService_Job.this.c).h(Z00.L, HelloService_Job.this.g + ".db")) {
                    HelloService_Job.this.g = new SimpleDateFormat("yyyy-MM-dd", locale).format(calendar.getTime());
                    HelloService_Job.this.h = false;
                }
                AbstractC2242g10.d(HelloService_Job.this.a, Z00.L, "inv.db", HelloService_Job.this.g + ".db", "info.aalmoghalis.inventory");
                HelloService_Job helloService_Job8 = HelloService_Job.this;
                C1044Xj.a().c(new RunnableC1171Zj(6, helloService_Job8.c, helloService_Job8.a));
                HelloService_Job.this.c.Lc("db_data_changed", "0");
                HelloService_Job.this.c.Lc("bk_drive_flag", "0");
                HelloService_Job.this.c.Lc("auto_filename", HelloService_Job.this.g + ".db");
                HelloService_Job helloService_Job9 = HelloService_Job.this;
                helloService_Job9.c.Lc("auto_drive_date_request", helloService_Job9.g);
                HelloService_Job.this.c.Lc("last_backup_time", System.currentTimeMillis() + "");
                String strIa = HelloService_Job.this.c.ia("bk_drive_flag", "0");
                FragmentStatePagerSupport_Main.b0 = strIa;
                if (strIa.equals("0") && HelloService_Job.this.c.ja("prefAutoBackup", true)) {
                    new Handler(Looper.getMainLooper()).post(new a());
                    HelloService_Job.this.c.Lc("bk_drive_flag", FragmentStatePagerSupport_Main.b0);
                }
                HelloService_Job.this.c.Mc("hello_serv", true);
                return null;
            } catch (Exception unused) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Log.d("job_ser_he", "onPreExecute");
            HelloService_Job helloService_Job = HelloService_Job.this;
            helloService_Job.a = helloService_Job.getApplicationContext();
            HelloService_Job helloService_Job2 = HelloService_Job.this;
            HelloService_Job helloService_Job3 = HelloService_Job.this;
            helloService_Job2.c = new Z00(helloService_Job3.b, helloService_Job3.a);
        }

        public /* synthetic */ b(HelloService_Job helloService_Job, a aVar) {
            this();
        }
    }

    public static void c(Context context) {
        ((JobScheduler) context.getSystemService("jobscheduler")).cancel(13);
    }

    @Override // android.app.Service
    public void onCreate() {
        this.a = getApplicationContext();
        this.c = new Z00(this.b, this.a);
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.c.ja("hello_serv", false)) {
            c(this.a);
        }
        a aVar = new a(jobParameters);
        this.f = aVar;
        aVar.execute(new Void[0]);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d("job_ser_he", "onStopJob:" + this.c.ja("hello_serv", false));
        b bVar = this.f;
        if (bVar != null) {
            bVar.cancel(true);
        }
        return false;
    }
}
