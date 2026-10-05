package info.aalmoghalis.inventory.online;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import defpackage.Z00;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceBootReceiver extends BroadcastReceiver {
    public SQLiteDatabase a;
    public Z00 b;
    public Context c;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Z00 z00 = new Z00(this.a, context);
            this.b = z00;
            this.c = context;
            try {
                z00.Pc(context);
            } catch (Exception unused) {
            }
        }
    }
}
