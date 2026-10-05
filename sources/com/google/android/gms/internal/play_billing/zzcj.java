package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC3700q90;
import defpackage.D80;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcj<V> extends m {
    public static Object zzc(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            Throwable th = ((c) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (!(obj instanceof e)) {
            if (obj == m.zza) {
                return null;
            }
            return obj;
        }
        Throwable th2 = ((e) obj).a;
        if (th2 != null) {
            throw new ExecutionException(th2);
        }
        m.zzb.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "getDoneValue", "Failure.exception is unexpectedly null.");
        throw new ExecutionException(e.c.a);
    }

    public static boolean zzh(Object obj) {
        return !(obj instanceof d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zzr(zzcz zzczVar) {
        Throwable thZze;
        if (zzczVar instanceof g) {
            Object cVar = ((zzcj) zzczVar).valueField;
            if (cVar instanceof c) {
                c cVar2 = (c) cVar;
                if (cVar2.a) {
                    Throwable th = cVar2.b;
                    cVar = th != null ? new c(false, th) : c.d;
                }
            }
            Objects.requireNonNull(cVar);
            return cVar;
        }
        if ((zzczVar instanceof zzdf) && (thZze = ((zzdf) zzczVar).zze()) != null) {
            return new e(thZze);
        }
        boolean zIsCancelled = zzczVar.isCancelled();
        if ((!m.zzc) && zIsCancelled) {
            c cVar3 = c.d;
            Objects.requireNonNull(cVar3);
            return cVar3;
        }
        try {
            Object objZzs = zzs(zzczVar);
            if (!zIsCancelled) {
                return objZzs == null ? m.zza : objZzs;
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(zzczVar)));
        } catch (Error e) {
            e = e;
            return new e(e);
        } catch (CancellationException e2) {
            return !zIsCancelled ? new e(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(zzczVar)), e2)) : new c(false, e2);
        } catch (ExecutionException e3) {
            return zIsCancelled ? new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zzczVar)), e3)) : new e(e3.getCause());
        } catch (Exception e4) {
            e = e4;
            return new e(e);
        }
    }

    private static Object zzs(Future future) {
        Object obj;
        boolean z = false;
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
        return obj;
    }

    private final void zzt(StringBuilder sb) {
        try {
            Object objZzs = zzs(this);
            sb.append("SUCCESS, result=[");
            if (objZzs == null) {
                sb.append("null");
            } else if (objZzs == this) {
                sb.append("this future");
            } else {
                sb.append(objZzs.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzs)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzu(zzcj zzcjVar, boolean z) {
        f fVar = null;
        while (true) {
            zzcjVar.zzo();
            zzcjVar.zzg();
            f fVar2 = fVar;
            f fVarZzk = zzcjVar.zzk(f.d);
            f fVar3 = fVar2;
            while (fVarZzk != null) {
                f fVar4 = fVarZzk.c;
                fVarZzk.c = fVar3;
                fVar3 = fVarZzk;
                fVarZzk = fVar4;
            }
            while (fVar3 != null) {
                Runnable runnable = fVar3.a;
                f fVar5 = fVar3.c;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof d) {
                    d dVar = (d) runnable2;
                    zzcjVar = dVar.a;
                    if (zzcjVar.valueField == dVar && m.zzq(zzcjVar, dVar, zzr(dVar.b))) {
                        fVar = fVar5;
                    }
                } else {
                    Executor executor = fVar3.b;
                    Objects.requireNonNull(executor);
                    zzv(runnable2, executor);
                }
                fVar3 = fVar5;
            }
            return;
        }
    }

    private static void zzv(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            m.zzb.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        c cVar;
        Object obj = this.valueField;
        if (!(obj instanceof d) && !(obj == null)) {
            return false;
        }
        if (m.zzc) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z ? c.c : c.d;
            Objects.requireNonNull(cVar);
        }
        boolean z2 = false;
        zzcj<V> zzcjVar = this;
        while (true) {
            if (m.zzq(zzcjVar, obj, cVar)) {
                zzu(zzcjVar, z);
                if (obj instanceof d) {
                    zzcz zzczVar = ((d) obj).b;
                    if (zzczVar instanceof g) {
                        zzcjVar = (zzcj) zzczVar;
                        obj = zzcjVar.valueField;
                        if ((obj == null) | (obj instanceof d)) {
                            z2 = true;
                        }
                    } else {
                        zzczVar.cancel(z);
                    }
                }
                return true;
            }
            obj = zzcjVar.valueField;
            if (zzh(obj)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return zzl();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.valueField instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.valueField;
        return (obj != null) & zzh(obj);
    }

    public final String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.valueField instanceof c) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzt(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof d) {
                sb.append(", setFuture=[");
                zzcz zzczVar = ((d) obj).b;
                try {
                    if (zzczVar == this) {
                        sb.append("this future");
                    } else {
                        sb.append(zzczVar);
                    }
                } catch (Throwable th) {
                    AbstractC3700q90.a(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append("]");
            } else {
                try {
                    strConcat = zzd();
                    if (strConcat == null || strConcat.isEmpty()) {
                        strConcat = null;
                    }
                } catch (Throwable th2) {
                    AbstractC3700q90.a(th2);
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(th2.getClass()));
                }
                if (strConcat != null) {
                    sb.append(", info=[");
                    sb.append(strConcat);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzt(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcz
    public final void zzb(Runnable runnable, Executor executor) {
        f fVar;
        zzbg.zzc(executor, "Executor was null.");
        if (!isDone() && (fVar = this.listenersField) != f.d) {
            f fVar2 = new f(runnable, executor);
            do {
                fVar2.c = fVar;
                if (zzp(fVar, fVar2)) {
                    return;
                } else {
                    fVar = this.listenersField;
                }
            } while (fVar != f.d);
        }
        zzv(runnable, executor);
    }

    public String zzd() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    public final Throwable zze() {
        if (!(this instanceof g)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof e) {
            return ((e) obj).a;
        }
        return null;
    }

    public void zzg() {
    }

    public final boolean zzi(Throwable th) {
        if (!m.zzq(this, null, new e(th))) {
            return false;
        }
        zzu(this, false);
        return true;
    }

    public final boolean zzj(zzcz zzczVar) {
        e eVar;
        Object obj = this.valueField;
        if (obj == null) {
            if (zzczVar.isDone()) {
                if (!m.zzq(this, null, zzr(zzczVar))) {
                    return false;
                }
                zzu(this, false);
                return true;
            }
            d dVar = new d(this, zzczVar);
            if (m.zzq(this, null, dVar)) {
                try {
                    zzczVar.zzb(dVar, D80.INSTANCE);
                } catch (Throwable th) {
                    try {
                        eVar = new e(th);
                    } catch (Error | Exception unused) {
                        eVar = e.b;
                    }
                    m.zzq(this, dVar, eVar);
                }
                return true;
            }
            obj = this.valueField;
        }
        if (obj instanceof c) {
            zzczVar.cancel(((c) obj).a);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return zzm(j, timeUnit);
    }
}
