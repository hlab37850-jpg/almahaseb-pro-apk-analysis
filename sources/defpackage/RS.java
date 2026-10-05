package defpackage;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public enum RS implements PS {
    CANCELLED;

    public static boolean a(AtomicReference atomicReference) {
        PS ps;
        PS ps2 = (PS) atomicReference.get();
        RS rs = CANCELLED;
        if (ps2 == rs || (ps = (PS) atomicReference.getAndSet(rs)) == rs) {
            return false;
        }
        if (ps == null) {
            return true;
        }
        ps.cancel();
        return true;
    }

    public static void b(AtomicReference atomicReference, AtomicLong atomicLong, long j) {
        PS ps = (PS) atomicReference.get();
        if (ps != null) {
            ps.l(j);
            return;
        }
        if (h(j)) {
            L6.a(atomicLong, j);
            PS ps2 = (PS) atomicReference.get();
            if (ps2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    ps2.l(andSet);
                }
            }
        }
    }

    public static boolean c(AtomicReference atomicReference, AtomicLong atomicLong, PS ps) {
        if (!f(atomicReference, ps)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        ps.l(andSet);
        return true;
    }

    public static void e() {
        FM.m(new C4447zI("Subscription already set!"));
    }

    public static boolean f(AtomicReference atomicReference, PS ps) {
        Objects.requireNonNull(ps, "s is null");
        if (FC.a(atomicReference, null, ps)) {
            return true;
        }
        ps.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        e();
        return false;
    }

    public static boolean h(long j) {
        if (j > 0) {
            return true;
        }
        FM.m(new IllegalArgumentException("n > 0 required but it was " + j));
        return false;
    }

    public static boolean i(PS ps, PS ps2) {
        if (ps2 == null) {
            FM.m(new NullPointerException("next is null"));
            return false;
        }
        if (ps == null) {
            return true;
        }
        ps2.cancel();
        e();
        return false;
    }

    @Override // defpackage.PS
    public void cancel() {
    }

    @Override // defpackage.PS
    public void l(long j) {
    }
}
