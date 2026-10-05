package info.aalmoghalis.inventory.online;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.old.Reminders;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ReminderListener extends BroadcastReceiver {
    public SQLiteDatabase a;
    public Z00 b;
    public Context c;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        CharSequence charSequence;
        Log.d("reminder=", "onReceive");
        Z00 z00 = new Z00(this.a, context);
        this.b = z00;
        this.c = context;
        try {
            if (z00.ja("prefOthers_reminders", false)) {
                return;
            }
            if (this.b.ia("reminder_data_changed", "0").equals("0")) {
                this.b.Qc(this.c);
                return;
            }
            ArrayList arrayListN4 = this.b.N4();
            int size = arrayListN4.size();
            if (size == 0) {
                return;
            }
            this.b.Lc("reminder_data_changed", "0");
            this.b.Qc(this.c);
            Intent intent2 = new Intent(this.c, (Class<?>) Reminders.class);
            if (size == 1) {
                intent2.putExtra("cus_name", (String) arrayListN4.get(0));
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.c);
            PendingIntent activity = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(this.c, 0, intent2, 33554432) : PendingIntent.getActivity(this.c, 0, intent2, 134217728);
            NotificationCompat.Builder smallIcon = builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle(this.c.getString(R.string.reminders_cnt)).setSmallIcon(R.mipmap.ic_launcher);
            if (size == 1) {
                charSequence = (CharSequence) arrayListN4.get(0);
            } else {
                charSequence = size + " " + this.c.getString(R.string.reminders_cnt);
            }
            smallIcon.setContentText(charSequence);
            builder.setContentIntent(activity);
            NotificationManager notificationManager = (NotificationManager) this.c.getSystemService("notification");
            builder.setAutoCancel(true);
            notificationManager.notify(R.mipmap.ic_launcher, builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
