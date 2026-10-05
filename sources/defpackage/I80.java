package defpackage;

import com.google.android.gms.internal.play_billing.zzbc;
import com.google.android.gms.internal.play_billing.zzbe;
import com.google.android.gms.internal.play_billing.zzbj;
import com.google.android.gms.internal.play_billing.zzcs;
import com.google.android.gms.internal.play_billing.zzdf;
import com.google.android.gms.internal.play_billing.zzdg;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public final class I80 implements Runnable {
    public final Future a;
    public final zzcs b;

    public I80(Future future, zzcs zzcsVar) {
        this.a = future;
        this.b = zzcsVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable thZza;
        boolean z = false;
        Future future = this.a;
        if ((future instanceof zzdf) && (thZza = zzdg.zza((zzdf) future)) != null) {
            this.b.zza(thZza);
            return;
        }
        try {
            if (!future.isDone()) {
                throw new IllegalStateException(zzbj.zza("Future was expected to be done: %s", future));
            }
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.b.zzb(obj);
        } catch (ExecutionException e) {
            this.b.zza(e.getCause());
        } catch (Throwable th2) {
            this.b.zza(th2);
        }
    }

    public final String toString() {
        zzbc zzbcVarZza = zzbe.zza(this);
        zzbcVarZza.zza(this.b);
        return zzbcVarZza.toString();
    }
}
