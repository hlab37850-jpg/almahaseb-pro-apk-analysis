package info.aalmoghalis.inventory.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import defpackage.ZS;

/* JADX INFO: loaded from: classes3.dex */
public class SyncService extends Service {
    public static ZS a;
    public static final Object b = new Object();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return a.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d("fire_chk=", "start:SyncService");
        synchronized (b) {
            try {
                if (a == null) {
                    a = new ZS(getApplicationContext(), true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
