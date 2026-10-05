package info.aalmoghalis.inventory.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.C2169f6;

/* JADX INFO: loaded from: classes3.dex */
public class AuthenticatorService extends Service {
    public C2169f6 a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        this.a = new C2169f6(getApplicationContext());
    }
}
