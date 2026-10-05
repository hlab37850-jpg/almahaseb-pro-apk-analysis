package defpackage;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzq;

/* JADX INFO: loaded from: classes2.dex */
public final class Gh0 implements Handler.Callback {
    public final /* synthetic */ Nh0 a;

    public /* synthetic */ Gh0(Nh0 nh0, zzq zzqVar) {
        this.a = nh0;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.a.a) {
                try {
                    zzo zzoVar = (zzo) message.obj;
                    ServiceConnectionC3984th0 serviceConnectionC3984th0 = (ServiceConnectionC3984th0) this.a.a.get(zzoVar);
                    if (serviceConnectionC3984th0 != null && serviceConnectionC3984th0.i()) {
                        if (serviceConnectionC3984th0.j()) {
                            serviceConnectionC3984th0.g("GmsClientSupervisor");
                        }
                        this.a.a.remove(zzoVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.a.a) {
            try {
                zzo zzoVar2 = (zzo) message.obj;
                ServiceConnectionC3984th0 serviceConnectionC3984th1 = (ServiceConnectionC3984th0) this.a.a.get(zzoVar2);
                if (serviceConnectionC3984th1 != null && serviceConnectionC3984th1.a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(zzoVar2), new Exception());
                    ComponentName componentNameB = serviceConnectionC3984th1.b();
                    if (componentNameB == null) {
                        componentNameB = zzoVar2.zza();
                    }
                    if (componentNameB == null) {
                        String strZzc = zzoVar2.zzc();
                        Preconditions.checkNotNull(strZzc);
                        componentNameB = new ComponentName(strZzc, "unknown");
                    }
                    serviceConnectionC3984th1.onServiceDisconnected(componentNameB);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}
