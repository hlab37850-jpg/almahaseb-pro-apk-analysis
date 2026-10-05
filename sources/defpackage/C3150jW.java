package defpackage;

/* JADX INFO: renamed from: jW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3150jW implements Comparable {
    public static final a b = new a(null);
    public final long a;

    /* JADX INFO: renamed from: jW$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ C3150jW(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C3150jW a(long j) {
        return new C3150jW(j);
    }

    public static boolean c(long j, Object obj) {
        return (obj instanceof C3150jW) && j == ((C3150jW) obj).g();
    }

    public static final boolean d(long j, long j2) {
        return j == j2;
    }

    public static int e(long j) {
        return AbstractC0723Lm.a(j);
    }

    public static String f(long j) {
        return LW.c(j, 10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return LW.a(g(), ((C3150jW) obj).g());
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ long g() {
        return this.a;
    }

    public int hashCode() {
        return e(this.a);
    }

    public String toString() {
        return f(this.a);
    }

    public static long b(long j) {
        return j;
    }
}
