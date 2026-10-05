package defpackage;

import com.google.android.gms.internal.play_billing.o;
import com.google.android.gms.internal.play_billing.zzcz;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: t90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC3942t90 implements Runnable {
    public o a;

    public RunnableC3942t90(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcz zzczVar;
        o oVar = this.a;
        if (oVar == null || (zzczVar = oVar.a) == null) {
            return;
        }
        this.a = null;
        if (zzczVar.isDone()) {
            oVar.zzj(zzczVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = oVar.b;
            oVar.b = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    oVar.zzi(new C4185w90(str, null));
                    throw th;
                }
            }
            oVar.zzi(new C4185w90(str + ": " + zzczVar.toString(), null));
            zzczVar.cancel(true);
        } catch (Throwable th2) {
            zzczVar.cancel(true);
            throw th2;
        }
    }
}
