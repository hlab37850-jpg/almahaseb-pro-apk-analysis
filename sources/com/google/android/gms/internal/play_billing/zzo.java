package com.google.android.gms.internal.play_billing;

import androidx.annotation.Nullable;
import com.itextpdf.text.pdf.PdfBoolean;
import defpackage.AbstractC3209k90;
import defpackage.C3493nf0;
import defpackage.Hd0;
import defpackage.Jc0;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class zzo implements zzcz {
    static final AbstractC3209k90 zzb;
    public static final /* synthetic */ int zzf = 0;
    private static final Object zzh;

    @Nullable
    volatile Object zzc;

    @Nullable
    volatile Hd0 zzd;

    @Nullable
    volatile z zze;
    static final boolean zza = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", PdfBoolean.FALSE));
    private static final Logger zzg = Logger.getLogger(zzo.class.getName());

    static {
        AbstractC3209k90 yVar;
        try {
            yVar = new C3493nf0(AtomicReferenceFieldUpdater.newUpdater(z.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(z.class, z.class, "b"), AtomicReferenceFieldUpdater.newUpdater(zzo.class, z.class, "zze"), AtomicReferenceFieldUpdater.newUpdater(zzo.class, Hd0.class, "zzd"), AtomicReferenceFieldUpdater.newUpdater(zzo.class, Object.class, "zzc"));
            th = null;
        } catch (Throwable th) {
            th = th;
            yVar = new y();
        }
        Throwable th2 = th;
        zzb = yVar;
        if (th2 != null) {
            zzg.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        zzh = new Object();
    }

    public static void zzc(zzo zzoVar) {
        z zVar;
        AbstractC3209k90 abstractC3209k90;
        Hd0 hd0;
        Hd0 hd1;
        Hd0 hd2;
        do {
            zVar = zzoVar.zze;
            abstractC3209k90 = zzb;
        } while (!abstractC3209k90.e(zzoVar, zVar, z.c));
        while (true) {
            hd0 = null;
            if (zVar == null) {
                break;
            }
            Thread thread = zVar.a;
            if (thread != null) {
                zVar.a = null;
                LockSupport.unpark(thread);
            }
            zVar = zVar.b;
        }
        do {
            hd1 = zzoVar.zzd;
        } while (!abstractC3209k90.c(zzoVar, hd1, Hd0.d));
        while (true) {
            hd2 = hd0;
            hd0 = hd1;
            if (hd0 == null) {
                break;
            }
            hd1 = hd0.c;
            hd0.c = hd2;
        }
        while (hd2 != null) {
            Runnable runnable = hd2.a;
            Hd0 hd3 = hd2.c;
            zzf(runnable, hd2.b);
            hd2 = hd3;
        }
    }

    private final void zze(StringBuilder sb) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e2) {
                sb.append("FAILURE, cause=[");
                sb.append(e2.getCause());
                sb.append("]");
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(obj == this ? "this future" : String.valueOf(obj));
        sb.append("]");
    }

    private static void zzf(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            zzg.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    private final void zzg(z zVar) {
        zVar.a = null;
        while (true) {
            z zVar2 = this.zze;
            if (zVar2 != z.c) {
                z zVar3 = null;
                while (zVar2 != null) {
                    z zVar4 = zVar2.b;
                    if (zVar2.a != null) {
                        zVar3 = zVar2;
                    } else if (zVar3 != null) {
                        zVar3.b = zVar4;
                        if (zVar3.a == null) {
                        }
                    } else if (!zzb.e(this, zVar2, zVar4)) {
                    }
                    zVar2 = zVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzh(Object obj) throws ExecutionException {
        if (obj instanceof p) {
            Throwable th = ((p) obj).a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof Jc0) {
            throw new ExecutionException(((Jc0) obj).a);
        }
        if (obj == zzh) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        p pVar;
        Object obj = this.zzc;
        if (obj == null) {
            if (zza) {
                pVar = new p(z, new CancellationException("Future.cancel() was called."));
            } else {
                pVar = z ? p.b : p.c;
            }
            if (zzb.d(this, obj, pVar)) {
                zzc(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.zzc;
        if (obj2 != null) {
            return zzh(obj2);
        }
        z zVar = this.zze;
        z zVar2 = z.c;
        if (zVar != zVar2) {
            z zVar3 = new z();
            do {
                AbstractC3209k90 abstractC3209k90 = zzb;
                abstractC3209k90.a(zVar3, zVar);
                if (abstractC3209k90.e(this, zVar, zVar3)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzg(zVar3);
                            throw new InterruptedException();
                        }
                        obj = this.zzc;
                    } while (!(obj != null));
                    return zzh(obj);
                }
                zVar = this.zze;
            } while (zVar != zVar2);
        }
        return zzh(this.zzc);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzc instanceof p;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzc != null;
    }

    public final String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.zzc instanceof p) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zze(sb);
        } else {
            try {
                strConcat = zza();
            } catch (RuntimeException e) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e.getClass()));
            }
            if (strConcat != null && !strConcat.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strConcat);
                sb.append("]");
            } else if (isDone()) {
                zze(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzcz
    public final void zzb(Runnable runnable, Executor executor) {
        executor.getClass();
        Hd0 hd0 = this.zzd;
        Hd0 hd1 = Hd0.d;
        if (hd0 != hd1) {
            Hd0 hd2 = new Hd0(runnable, executor);
            do {
                hd2.c = hd0;
                if (zzb.c(this, hd0, hd2)) {
                    return;
                } else {
                    hd0 = this.zzd;
                }
            } while (hd0 != hd1);
        }
        zzf(runnable, executor);
    }

    public boolean zzd(@Nullable Object obj) {
        if (obj == null) {
            obj = zzh;
        }
        if (!zzb.d(this, null, obj)) {
            return false;
        }
        zzc(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.zzc;
            if (obj != null) {
                return zzh(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                z zVar = this.zze;
                z zVar2 = z.c;
                if (zVar != zVar2) {
                    z zVar3 = new z();
                    while (true) {
                        AbstractC3209k90 abstractC3209k90 = zzb;
                        abstractC3209k90.a(zVar3, zVar);
                        if (abstractC3209k90.e(this, zVar, zVar3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.zzc;
                                    if (obj2 != null) {
                                        return zzh(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    zzg(zVar3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzg(zVar3);
                            break;
                        }
                        zVar = this.zze;
                        if (zVar == zVar2) {
                        }
                    }
                }
                return zzh(this.zzc);
            }
            while (nanos > 0) {
                Object obj3 = this.zzc;
                if (obj3 != null) {
                    return zzh(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = jNanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            String strConcat = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j2 = -nanos;
                long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(jConvert);
                boolean z = jConvert == 0 || nanos2 > 1000;
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                    if (z) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(" ");
                }
                if (z) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(strConcat + " for " + string);
        }
        throw new InterruptedException();
    }
}
