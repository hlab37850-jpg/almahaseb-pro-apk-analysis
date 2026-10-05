package defpackage;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: cF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1861cF {
    public static void a(Object obj, long j) {
        LockSupport.parkNanos(obj, Math.min(j, 2147483647999999999L));
    }
}
