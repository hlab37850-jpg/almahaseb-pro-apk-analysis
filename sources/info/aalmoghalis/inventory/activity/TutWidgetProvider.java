package info.aalmoghalis.inventory.activity;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TutWidgetProvider extends AppWidgetProvider {
    public SQLiteDatabase b;
    public final String a = "TutWidgetProvider";
    public List c = new ArrayList();
    public int[] d = {R.drawable.up, 1, R.drawable.down};
    public int e = 0;

    public void a(Context context, AppWidgetManager appWidgetManager) {
        try {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.titlist_appwidget_layout);
            new Z00(this.b, context);
            Intent intent = new Intent(context, (Class<?>) Customer_Det_List_edit5.class);
            intent.putExtra("read_imei", "1");
            int i = Build.VERSION.SDK_INT;
            remoteViews.setOnClickPendingIntent(R.id.logo_add, i >= 31 ? PendingIntent.getActivity(context, 0, intent, 167772160) : PendingIntent.getActivity(context, 0, intent, 134217728));
            Intent intent2 = new Intent(context, (Class<?>) Customer_Det_List_edit4.class);
            intent2.putExtra("read_imei", "1");
            remoteViews.setOnClickPendingIntent(R.id.logo_tran, i >= 31 ? PendingIntent.getActivity(context, 0, intent2, 167772160) : PendingIntent.getActivity(context, 0, intent2, 134217728));
            Intent intent3 = new Intent(context, (Class<?>) FragmentStatePagerSupport_Main.class);
            remoteViews.setOnClickPendingIntent(R.id.logo, i >= 31 ? PendingIntent.getActivity(context, 0, intent3, 167772160) : PendingIntent.getActivity(context, 0, intent3, 134217728));
            appWidgetManager.updateAppWidget(new ComponentName(context, (Class<?>) TutWidgetProvider.class), remoteViews);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        try {
            a(context, appWidgetManager);
        } catch (Exception e) {
            Log.e("TutWidgetProvider", "Failed", e);
        }
    }
}
