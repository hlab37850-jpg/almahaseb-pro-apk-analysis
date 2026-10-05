package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Nh0 extends GmsClientSupervisor {
    public final HashMap a = new HashMap();
    public final Context b;
    public volatile Handler c;
    public final Gh0 d;
    public final ConnectionTracker e;
    public final long f;
    public final long g;
    public volatile Executor h;

    public Nh0(Context context, Looper looper, Executor executor) {
        Gh0 gh0 = new Gh0(this, null);
        this.d = gh0;
        this.b = context.getApplicationContext();
        this.c = new zzi(looper, gh0);
        this.e = ConnectionTracker.getInstance();
        this.f = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.g = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.h = executor;
    }

    public final void f(Executor executor) {
        synchronized (this.a) {
            this.h = executor;
        }
    }

    public final void g(Looper looper) {
        synchronized (this.a) {
            this.c = new zzi(looper, this.d);
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zza(zzo zzoVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.a) {
            try {
                ServiceConnectionC3984th0 serviceConnectionC3984th0 = (ServiceConnectionC3984th0) this.a.get(zzoVar);
                if (serviceConnectionC3984th0 == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + zzoVar.toString());
                }
                if (!serviceConnectionC3984th0.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzoVar.toString());
                }
                serviceConnectionC3984th0.f(serviceConnection, str);
                if (serviceConnectionC3984th0.i()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, zzoVar), this.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzc(zzo zzoVar, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zJ;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.a) {
            try {
                ServiceConnectionC3984th0 serviceConnectionC3984th0 = (ServiceConnectionC3984th0) this.a.get(zzoVar);
                if (executor == null) {
                    executor = this.h;
                }
                if (serviceConnectionC3984th0 == null) {
                    serviceConnectionC3984th0 = new ServiceConnectionC3984th0(this, zzoVar);
                    serviceConnectionC3984th0.d(serviceConnection, serviceConnection, str);
                    serviceConnectionC3984th0.e(str, executor);
                    this.a.put(zzoVar, serviceConnectionC3984th0);
                } else {
                    this.c.removeMessages(0, zzoVar);
                    if (serviceConnectionC3984th0.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzoVar.toString());
                    }
                    serviceConnectionC3984th0.d(serviceConnection, serviceConnection, str);
                    int iA = serviceConnectionC3984th0.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(serviceConnectionC3984th0.b(), serviceConnectionC3984th0.c());
                    } else if (iA == 2) {
                        serviceConnectionC3984th0.e(str, executor);
                    }
                }
                zJ = serviceConnectionC3984th0.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zJ;
    }
}
