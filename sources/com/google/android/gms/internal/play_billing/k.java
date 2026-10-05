package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends h {
    public static final Unsafe a;
    public static final long b;
    public static final long c;
    public static final long d;
    public static final long e;
    public static final long f;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.android.gms.internal.play_billing.zzcn
                @Override // java.security.PrivilegedExceptionAction
                public final Object run() throws IllegalAccessException {
                    Unsafe unsafe2 = k.a;
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
        try {
            c = unsafe.objectFieldOffset(m.class.getDeclaredField("waitersField"));
            b = unsafe.objectFieldOffset(m.class.getDeclaredField("listenersField"));
            d = unsafe.objectFieldOffset(m.class.getDeclaredField("valueField"));
            e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
            f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
            a = unsafe;
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        }
    }

    public /* synthetic */ k(zzco zzcoVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final f a(m mVar, f fVar) {
        f fVar2;
        do {
            fVar2 = mVar.listenersField;
            if (fVar == fVar2) {
                break;
            }
        } while (!e(mVar, fVar2, fVar));
        return fVar2;
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final l b(m mVar, l lVar) {
        l lVar2;
        do {
            lVar2 = mVar.waitersField;
            if (lVar == lVar2) {
                break;
            }
        } while (!g(mVar, lVar2, lVar));
        return lVar2;
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final void c(l lVar, l lVar2) {
        a.putObject(lVar, f, lVar2);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final void d(l lVar, Thread thread) {
        a.putObject(lVar, e, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean e(m mVar, f fVar, f fVar2) {
        return zzcm.zza(a, mVar, b, fVar, fVar2);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean f(m mVar, Object obj, Object obj2) {
        return zzcm.zza(a, mVar, d, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean g(m mVar, l lVar, l lVar2) {
        return zzcm.zza(a, mVar, c, lVar, lVar2);
    }
}
