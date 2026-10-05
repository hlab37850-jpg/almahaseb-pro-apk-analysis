package info.aalmoghalis.inventory.online;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC2242g10;
import defpackage.C0631Jq;
import defpackage.C2160f10;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class DbBackupListener extends BroadcastReceiver {
    public SQLiteDatabase a;
    public Z00 b;
    public Context c;
    public String d = "";
    public boolean e = true;

    public void a(String str) {
        try {
            Intent intent = new Intent(this.c, (Class<?>) FragmentStatePagerSupport_Main.class);
            intent.putExtra("auto_back", "1");
            intent.putExtra("bk_filename", str + ".db");
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.c);
            PendingIntent activity = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(this.c, 0, intent, 33554432) : PendingIntent.getActivity(this.c, 0, intent, 1140850688);
            builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle(this.c.getString(R.string.auto_backup_notify)).setSmallIcon(R.mipmap.ic_launcher).setContentText(this.b.ia("prefBackup_path", Z00.L) + "/" + str + ".db");
            builder.setContentIntent(activity);
            ((NotificationManager) this.c.getSystemService("notification")).notify(R.mipmap.ic_launcher, builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Z00 z00 = new Z00(this.a, context);
        this.b = z00;
        this.c = context;
        try {
            if (z00.ja("prefAutoBackup", true)) {
                if (this.b.ia("db_data_changed2", "0").equals("0")) {
                    this.b.Pc(this.c);
                    return;
                }
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
                    this.b.Lc("bk_drive_flag", "0");
                    this.b.Lc("last_backup_time", System.currentTimeMillis() + "");
                    this.b.Lc("auto_filename", this.d + ".db");
                    this.b.Lc("auto_drive_date_request", this.d);
                    try {
                        String strIa = this.b.ia("bk_drive_flag", "0");
                        FragmentStatePagerSupport_Main.b0 = strIa;
                        if (strIa.equals("0") && this.b.ja("prefAutoBackup", true)) {
                            new C0631Jq(this.c, this.b).c();
                            this.b.Lc("bk_drive_flag", FragmentStatePagerSupport_Main.b0);
                        }
                    } catch (Exception unused) {
                    }
                    if (this.e) {
                        a(this.d);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
