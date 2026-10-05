package defpackage;

/* JADX INFO: renamed from: qr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3752qr {
    public static final a d = new a(null);
    public static final W8 e;
    public static final W8 f;
    public static final W8 g;
    public static final W8 h;
    public static final W8 i;
    public static final W8 j;
    public final W8 a;
    public final W8 b;
    public final int c;

    /* JADX INFO: renamed from: qr$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    static {
        W8.a aVar = W8.d;
        e = aVar.c(":");
        f = aVar.c(":status");
        g = aVar.c(":method");
        h = aVar.c(":path");
        i = aVar.c(":scheme");
        j = aVar.c(":authority");
    }

    public C3752qr(W8 w8, W8 w9) {
        AbstractC4492zt.h(w8, "name");
        AbstractC4492zt.h(w9, "value");
        this.a = w8;
        this.b = w9;
        this.c = w8.u() + 32 + w9.u();
    }

    public final W8 a() {
        return this.a;
    }

    public final W8 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3752qr)) {
            return false;
        }
        C3752qr c3752qr = (C3752qr) obj;
        return AbstractC4492zt.d(this.a, c3752qr.a) && AbstractC4492zt.d(this.b, c3752qr.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return this.a.y() + ": " + this.b.y();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C3752qr(String str, String str2) {
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(str2, "value");
        W8.a aVar = W8.d;
        this(aVar.c(str), aVar.c(str2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3752qr(W8 w8, String str) {
        this(w8, W8.d.c(str));
        AbstractC4492zt.h(w8, "name");
        AbstractC4492zt.h(str, "value");
    }
}
