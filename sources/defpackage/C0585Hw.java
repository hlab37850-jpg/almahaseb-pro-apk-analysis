package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: Hw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0585Hw {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;
    public final int a;
    public final boolean b;
    public final int c;
    public /* synthetic */ AtomicReferenceArray d;
    public static final a e = new a(null);
    public static final YS h = new YS("REMOVE_FROZEN");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(C0585Hw.class, Object.class, "_next");
    public static final /* synthetic */ AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(C0585Hw.class, "_state");

    /* JADX INFO: renamed from: Hw$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, 1073741823L) | ((long) i);
        }

        public final long c(long j, int i) {
            return d(j, 1152921503533105152L) | (((long) i) << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: Hw$b */
    public static final class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public C0585Hw(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Object obj) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return e.a(j);
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.b && this.d.get(i2 & i3) != null) {
                int i4 = this.a;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (g.compareAndSet(this, j, e.c(j, (i2 + 1) & 1073741823))) {
                this.d.set(i2 & i3, obj);
                C0585Hw c0585HwE = this;
                while ((c0585HwE._state & 1152921504606846976L) != 0 && (c0585HwE = c0585HwE.i().e(i2, obj)) != null) {
                }
                return 0;
            }
        }
    }

    public final C0585Hw b(long j) {
        C0585Hw c0585Hw = new C0585Hw(this.a * 2, this.b);
        int i = (int) (1073741823 & j);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.c;
            if ((i & i3) == (i2 & i3)) {
                c0585Hw._state = e.d(j, 1152921504606846976L);
                return c0585Hw;
            }
            Object bVar = this.d.get(i3 & i);
            if (bVar == null) {
                bVar = new b(i);
            }
            c0585Hw.d.set(c0585Hw.c & i, bVar);
            i++;
        }
    }

    public final C0585Hw c(long j) {
        while (true) {
            C0585Hw c0585Hw = (C0585Hw) this._next;
            if (c0585Hw != null) {
                return c0585Hw;
            }
            AbstractC2403i0.a(f, this, null, b(j));
        }
    }

    public final boolean d() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!g.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final C0585Hw e(int i, Object obj) {
        Object obj2 = this.d.get(this.c & i);
        if (!(obj2 instanceof b) || ((b) obj2).a != i) {
            return null;
        }
        this.d.set(i & this.c, obj);
        return this;
    }

    public final int f() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j)));
    }

    public final boolean g() {
        long j = this._state;
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!g.compareAndSet(this, j, j2));
        return j2;
    }

    public final C0585Hw i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return h;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.d.get(i3 & i);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i4 = (i + 1) & 1073741823;
                if (g.compareAndSet(this, j, e.b(j, i4))) {
                    this.d.set(this.c & i, null);
                    return obj;
                }
                if (this.b) {
                    C0585Hw c0585HwK = this;
                    do {
                        c0585HwK = c0585HwK.k(i, i4);
                    } while (c0585HwK != null);
                    return obj;
                }
            }
        }
    }

    public final C0585Hw k(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            i3 = (int) (1073741823 & j);
            if ((1152921504606846976L & j) != 0) {
                return i();
            }
        } while (!g.compareAndSet(this, j, e.b(j, i2)));
        this.d.set(i3 & this.c, null);
        return null;
    }
}
