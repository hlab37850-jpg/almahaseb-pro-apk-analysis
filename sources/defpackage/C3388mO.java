package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: mO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3388mO {
    public static final C3388mO a = new C3388mO();
    public static final int b = 65536;
    public static final C3306lO c = new C3306lO(new byte[0], 0, 0, false, false);
    public static final int d;
    public static final AtomicReference[] e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        d = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        e = atomicReferenceArr;
    }

    public static final void b(C3306lO c3306lO) {
        AbstractC4492zt.h(c3306lO, "segment");
        if (c3306lO.f != null || c3306lO.g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (c3306lO.d) {
            return;
        }
        AtomicReference atomicReferenceA = a.a();
        C3306lO c3306lO2 = c;
        C3306lO c3306lO3 = (C3306lO) atomicReferenceA.getAndSet(c3306lO2);
        if (c3306lO3 == c3306lO2) {
            return;
        }
        int i = c3306lO3 != null ? c3306lO3.c : 0;
        if (i >= b) {
            atomicReferenceA.set(c3306lO3);
            return;
        }
        c3306lO.f = c3306lO3;
        c3306lO.b = 0;
        c3306lO.c = i + 8192;
        atomicReferenceA.set(c3306lO);
    }

    public static final C3306lO c() {
        AtomicReference atomicReferenceA = a.a();
        C3306lO c3306lO = c;
        C3306lO c3306lO2 = (C3306lO) atomicReferenceA.getAndSet(c3306lO);
        if (c3306lO2 == c3306lO) {
            return new C3306lO();
        }
        if (c3306lO2 == null) {
            atomicReferenceA.set(null);
            return new C3306lO();
        }
        atomicReferenceA.set(c3306lO2.f);
        c3306lO2.f = null;
        c3306lO2.c = 0;
        return c3306lO2;
    }

    public final AtomicReference a() {
        return e[(int) (Thread.currentThread().getId() & (((long) d) - 1))];
    }
}
