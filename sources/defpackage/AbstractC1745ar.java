package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: ar, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1745ar {
    public static void a(NS ns, AtomicInteger atomicInteger, Z5 z5) {
        if (atomicInteger.getAndIncrement() == 0) {
            z5.e(ns);
        }
    }

    public static void b(NS ns, Throwable th, AtomicInteger atomicInteger, Z5 z5) {
        if (z5.c(th) && atomicInteger.getAndIncrement() == 0) {
            z5.e(ns);
        }
    }

    public static boolean c(NS ns, Object obj, AtomicInteger atomicInteger, Z5 z5) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            ns.b(obj);
            if (atomicInteger.decrementAndGet() == 0) {
                return true;
            }
            z5.e(ns);
        }
        return false;
    }
}
