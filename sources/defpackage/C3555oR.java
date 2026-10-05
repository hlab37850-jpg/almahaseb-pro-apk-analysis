package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: oR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3555oR extends AtomicReferenceArray implements InterfaceC4202wQ {
    public static final Integer f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final int a;
    public final AtomicLong b;
    public long c;
    public final AtomicLong d;
    public final int e;

    public C3555oR(int i) {
        super(AbstractC1216aH.a(i));
        this.a = length() - 1;
        this.b = new AtomicLong();
        this.d = new AtomicLong();
        this.e = Math.min(i / 4, f.intValue());
    }

    public int a(long j) {
        return this.a & ((int) j);
    }

    public int b(long j, int i) {
        return ((int) j) & i;
    }

    @Override // defpackage.InterfaceC4283xQ
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public Object e(int i) {
        return get(i);
    }

    public void f(long j) {
        this.d.lazySet(j);
    }

    public void h(int i, Object obj) {
        lazySet(i, obj);
    }

    public void i(long j) {
        this.b.lazySet(j);
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean isEmpty() {
        return this.b.get() == this.d.get();
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.a;
        long j = this.b.get();
        int iB = b(j, i);
        if (j >= this.c) {
            long j2 = ((long) this.e) + j;
            if (e(b(j2, i)) == null) {
                this.c = j2;
            } else if (e(iB) != null) {
                return false;
            }
        }
        h(iB, obj);
        i(j + 1);
        return true;
    }

    @Override // defpackage.InterfaceC4202wQ, defpackage.InterfaceC4283xQ
    public Object poll() {
        long j = this.d.get();
        int iA = a(j);
        Object objE = e(iA);
        if (objE == null) {
            return null;
        }
        f(j + 1);
        h(iA, null);
        return objE;
    }
}
