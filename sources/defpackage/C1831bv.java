package defpackage;

/* JADX INFO: renamed from: bv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1831bv implements Comparable {
    public static final a e = new a(null);
    public static final C1831bv f = C1988cv.a();
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    /* JADX INFO: renamed from: bv$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public C1831bv(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = b(i, i2, i3);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1831bv c1831bv) {
        AbstractC4492zt.h(c1831bv, "other");
        return this.d - c1831bv.d;
    }

    public final int b(int i, int i2, int i3) {
        if (i >= 0 && i < 256 && i2 >= 0 && i2 < 256 && i3 >= 0 && i3 < 256) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        C1831bv c1831bv = obj instanceof C1831bv ? (C1831bv) obj : null;
        return c1831bv != null && this.d == c1831bv.d;
    }

    public int hashCode() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('.');
        sb.append(this.b);
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
