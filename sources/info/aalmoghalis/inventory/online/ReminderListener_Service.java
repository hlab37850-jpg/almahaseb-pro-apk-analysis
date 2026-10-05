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
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import defpackage.AbstractC0605Iq;
import defpackage.V50;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.old.Reminders;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class ReminderListener_Service extends JobService {
    public SQLiteDatabase a;
    public Z00 b;
    public Context c;
    public b d;
    public String e = "";

    public class a extends b {
        public final /* synthetic */ JobParameters b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JobParameters jobParameters) {
            super(ReminderListener_Service.this, null);
            this.b = jobParameters;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            ReminderListener_Service.this.jobFinished(this.b, true);
        }
    }

    public class b extends AsyncTask {
        public b() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            Log.d(NotificationCompat.CATEGORY_REMINDER, "doInBackground");
            if (ReminderListener_Service.this.b.ja("prefOthers_reminders", false)) {
                return null;
            }
            if (ReminderListener_Service.this.b.ia("reminder_data_changed", "0").equals("0")) {
                ReminderListener_Service reminderListener_Service = ReminderListener_Service.this;
                reminderListener_Service.b.Qc(reminderListener_Service.c);
                return null;
            }
            ArrayList arrayListN4 = ReminderListener_Service.this.b.N4();
            if (arrayListN4.size() == 0) {
                return null;
            }
            ReminderListener_Service.this.b.Lc("reminder_data_changed", "0");
            ReminderListener_Service reminderListener_Service2 = ReminderListener_Service.this;
            reminderListener_Service2.b.Qc(reminderListener_Service2.c);
            ReminderListener_Service.this.a(arrayListN4);
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Log.d(NotificationCompat.CATEGORY_REMINDER, "onPreExecute");
            ReminderListener_Service reminderListener_Service = ReminderListener_Service.this;
            ReminderListener_Service reminderListener_Service2 = ReminderListener_Service.this;
            reminderListener_Service.b = new Z00(reminderListener_Service2.a, reminderListener_Service2.getApplicationContext());
            ReminderListener_Service reminderListener_Service3 = ReminderListener_Service.this;
            reminderListener_Service3.c = reminderListener_Service3.getApplicationContext();
            ReminderListener_Service reminderListener_Service4 = ReminderListener_Service.this;
            ReminderListener_Service reminderListener_Service5 = ReminderListener_Service.this;
            reminderListener_Service4.b = new Z00(reminderListener_Service5.a, reminderListener_Service5.c);
        }

        public /* synthetic */ b(ReminderListener_Service reminderListener_Service, a aVar) {
            this();
        }
    }

    public void a(ArrayList arrayList) {
        CharSequence charSequence;
        String str;
        try {
            Log.d(NotificationCompat.CATEGORY_REMINDER, "show_notification");
            Intent intent = new Intent(this.c, (Class<?>) Reminders.class);
            if (arrayList.size() == 1) {
                intent.putExtra("cus_name", ((String) arrayList.get(0)).toString());
            }
            int i = Build.VERSION.SDK_INT;
            PendingIntent activity = i >= 31 ? PendingIntent.getActivity(this.c, 0, intent, 33554432) : PendingIntent.getActivity(this.c, 0, intent, 134217728);
            NotificationManager notificationManager = (NotificationManager) this.c.getSystemService("notification");
            if (i >= 26) {
                V50.a();
                NotificationChannel notificationChannelA = AbstractC0605Iq.a("my_channel_id_01", "My Notifications", 3);
                if (arrayList.size() == 1) {
                    str = (String) arrayList.get(0);
                } else {
                    str = arrayList.size() + " " + this.c.getString(R.string.reminders_cnt);
                }
                notificationChannelA.setDescription(str);
                notificationChannelA.enableLights(true);
                notificationChannelA.setLightColor(SupportMenu.CATEGORY_MASK);
                notificationChannelA.setVibrationPattern(new long[]{0, 1000, 500, 1000});
                notificationChannelA.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannelA);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.c, "my_channel_id_01");
            NotificationCompat.Builder smallIcon = builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle(this.c.getString(R.string.reminders_cnt)).setSmallIcon(R.mipmap.ic_launcher);
            if (arrayList.size() == 1) {
                charSequence = (CharSequence) arrayList.get(0);
            } else {
                charSequence = arrayList.size() + " " + this.c.getString(R.string.reminders_cnt);
            }
            smallIcon.setContentText(charSequence);
            builder.setContentIntent(activity);
            builder.setAutoCancel(true);
            notificationManager.notify(R.mipmap.ic_launcher, builder.build());
        } catch (Exception e) {
            Log.d("job_remind_err", e.getMessage() + "");
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
