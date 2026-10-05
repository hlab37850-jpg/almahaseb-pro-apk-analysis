package defpackage;

/* JADX INFO: renamed from: Ts, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0945Ts implements Iterable, InterfaceC0756Mu {
    public static final a d = new a(null);
    public final int a;
    public final int b;
    public final int c;

    /* JADX INFO: renamed from: Ts$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C0945Ts a(int i, int i2, int i3) {
            return new C0945Ts(i, i2, i3);
        }

        public a() {
        }
    }

    public C0945Ts(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = i;
        this.b = AbstractC3546oI.b(i, i2, i3);
        this.c = i3;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC0919Ss iterator() {
        return new C0975Us(this.a, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0945Ts) {
            if (!isEmpty() || !((C0945Ts) obj).isEmpty()) {
                C0945Ts c0945Ts = (C0945Ts) obj;
                if (this.a != c0945Ts.a || this.b != c0945Ts.b || this.c != c0945Ts.c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        if (this.c > 0) {
            if (this.a <= this.b) {
                return false;
            }
        } else if (this.a >= this.b) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }
}
