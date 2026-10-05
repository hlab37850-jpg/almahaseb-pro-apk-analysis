package com.google.android.gms.internal.play_billing;

import com.itextpdf.text.pdf.PdfBoolean;
import defpackage.Y80;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends zzdf implements zzcz {
    static final Object zza = new Object();
    static final Y80 zzb = new Y80(zzcj.class);
    static final boolean zzc;
    private static final h zzd;
    volatile f listenersField;
    volatile Object valueField;
    volatile l waitersField;

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        h jVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", PdfBoolean.FALSE));
        } catch (SecurityException unused) {
            z = false;
        }
        zzc = z;
        String property = System.getProperty("java.runtime.name", "");
        zzco zzcoVar = null;
        if (property == null || property.contains("Android")) {
            try {
                jVar = new k(zzcoVar);
            } catch (Error | Exception e) {
                try {
                    th = e;
                    th2 = null;
                    jVar = new i(zzcoVar);
                } catch (Error | Exception e2) {
                    th = e;
                    th2 = e2;
                    jVar = new j(zzcoVar);
                }
            }
        } else {
            try {
                jVar = new i(zzcoVar);
            } catch (NoClassDefFoundError unused2) {
                jVar = new j(zzcoVar);
            }
        }
        th2 = null;
        th = null;
        zzd = jVar;
        if (th2 != null) {
            Y80 y80 = zzb;
            Logger loggerA = y80.a();
            Level level = Level.SEVERE;
            loggerA.logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            y80.a().logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th2);
        }
    }

    public static boolean zzq(m mVar, Object obj, Object obj2) {
        return zzd.f(mVar, obj, obj2);
    }

    public final void a(l lVar) {
        lVar.a = null;
        while (true) {
            l lVar2 = this.waitersField;
            if (lVar2 != l.c) {
                l lVar3 = null;
                while (lVar2 != null) {
                    l lVar4 = lVar2.b;
                    if (lVar2.a != null) {
                        lVar3 = lVar2;
                    } else if (lVar3 != null) {
                        lVar3.b = lVar4;
                        if (lVar3.a == null) {
                        }
                    } else if (!zzd.g(this, lVar2, lVar4)) {
                    }
                    lVar2 = lVar4;
                }
                return;
            }
            return;
        }
    }

    public final f zzk(f fVar) {
        return zzd.a(this, fVar);
    }

    public final Object zzl() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.valueField;
        if ((obj2 != null) && zzcj.zzh(obj2)) {
            return zzcj.zzc(obj2);
        }
        l lVar = this.waitersField;
        if (lVar != l.c) {
            l lVar2 = new l();
            do {
                h hVar = zzd;
                hVar.c(lVar2, lVar);
                if (hVar.g(this, lVar, lVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            a(lVar2);
                            throw new InterruptedException();
                        }
                        obj = this.valueField;
                    } while (!((obj != null) & zzcj.zzh(obj)));
                    return zzcj.zzc(obj);
                }
                lVar = this.waitersField;
            } while (lVar != l.c);
        }
        Object obj3 = this.valueField;
        Objects.requireNonNull(obj3);
        return zzcj.zzc(obj3);
    }

    public final Object zzm(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.valueField;
        boolean z = true;
        if ((obj != null) && zzcj.zzh(obj)) {
            return zzcj.zzc(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            l lVar = this.waitersField;
            if (lVar != l.c) {
                l lVar2 = new l();
                while (true) {
                    h hVar = zzd;
                    hVar.c(lVar2, lVar);
                    if (hVar.g(this, lVar, lVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                a(lVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.valueField;
                            if ((obj2 != null) && zzcj.zzh(obj2)) {
                                return zzcj.zzc(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        a(lVar2);
                        break;
                    }
                    lVar = this.waitersField;
                    if (lVar == l.c) {
                    }
                }
            }
            Object obj3 = this.valueField;
            Objects.requireNonNull(obj3);
            return zzcj.zzc(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.valueField;
            if ((obj4 != null) && zzcj.zzh(obj4)) {
                return zzcj.zzc(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
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
            if (jConvert != 0 && nanos2 <= 1000) {
                z = false;
            }
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

    public final void zzo() {
        for (l lVarB = zzd.b(this, l.c); lVarB != null; lVarB = lVarB.b) {
            Thread thread = lVarB.a;
            if (thread != null) {
                lVarB.a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    public final boolean zzp(f fVar, f fVar2) {
        return zzd.e(this, fVar, fVar2);
    }
}
