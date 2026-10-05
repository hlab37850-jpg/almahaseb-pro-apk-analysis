package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: pR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3637pR implements InterfaceC4202wQ {
    public static final int i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object j = new Object();
    public int b;
    public long c;
    public final int d;
    public AtomicReferenceArray e;
    public final int f;
    public AtomicReferenceArray g;
    public final AtomicLong a = new AtomicLong();
    public final AtomicLong h = new AtomicLong();

    public C3637pR(int i2) {
        int iA = AbstractC1216aH.a(Math.max(8, i2));
        int i3 = iA - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iA + 1);
        this.e = atomicReferenceArray;
        this.d = i3;
        a(iA);
        this.g = atomicReferenceArray;
        this.f = i3;
        this.c = iA - 2;
        p(0L);
    }

    public static int d(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    public static Object h(AtomicReferenceArray atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private void m(long j2) {
        this.h.lazySet(j2);
    }

    public static void n(AtomicReferenceArray atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void p(long j2) {
        this.a.lazySet(j2);
    }

    public final void a(int i2) {
        this.b = Math.min(i2 / 4, i);
    }

    @Override // defpackage.InterfaceC4283xQ
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long e() {
        return this.h.get();
    }

    public final long f() {
        return this.a.get();
    }

    public final long g() {
        return this.h.get();
    }

    public final AtomicReferenceArray i(AtomicReferenceArray atomicReferenceArray, int i2) {
        int iB = b(i2);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) h(atomicReferenceArray, iB);
        n(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean isEmpty() {
        return j() == g();
    }

    public final long j() {
        return this.a.get();
    }

    public final Object k(AtomicReferenceArray atomicReferenceArray, long j2, int i2) {
        this.g = atomicReferenceArray;
        int iD = d(j2, i2);
        Object objH = h(atomicReferenceArray, iD);
        if (objH != null) {
            n(atomicReferenceArray, iD, null);
            m(j2 + 1);
        }
        return objH;
    }

    public final void l(AtomicReferenceArray atomicReferenceArray, long j2, int i2, Object obj, long j3) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.c = (j3 + j2) - 1;
        n(atomicReferenceArray2, i2, obj);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i2, j);
        p(j2 + 1);
    }

    public final void o(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        n(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.e;
        long jF = f();
        int i2 = this.d;
        int iD = d(jF, i2);
        if (jF < this.c) {
            return q(atomicReferenceArray, obj, jF, iD);
        }
        long j2 = ((long) this.b) + jF;
        if (h(atomicReferenceArray, d(j2, i2)) == null) {
            this.c = j2 - 1;
            return q(atomicReferenceArray, obj, jF, iD);
        }
        if (h(atomicReferenceArray, d(1 + jF, i2)) == null) {
            return q(atomicReferenceArray, obj, jF, iD);
        }
        l(atomicReferenceArray, jF, iD, obj, i2);
        return true;
    }

    @Override // defpackage.InterfaceC4202wQ, defpackage.InterfaceC4283xQ
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.g;
        long jE = e();
        int i2 = this.f;
        int iD = d(jE, i2);
        Object objH = h(atomicReferenceArray, iD);
        boolean z = objH == j;
        if (objH == null || z) {
            if (z) {
                return k(i(atomicReferenceArray, i2 + 1), jE, i2);
            }
            return null;
        }
        n(atomicReferenceArray, iD, null);
        m(jE + 1);
        return objH;
    }

    public final boolean q(AtomicReferenceArray atomicReferenceArray, Object obj, long j2, int i2) {
        n(atomicReferenceArray, i2, obj);
        p(j2 + 1);
        return true;
    }

    public static int b(int i2) {
        return i2;
    }
}
