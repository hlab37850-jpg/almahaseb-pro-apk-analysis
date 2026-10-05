package defpackage;

import java.util.Arrays;

/* JADX INFO: renamed from: lO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3306lO {
    public static final a h = new a(null);
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public C3306lO f;
    public C3306lO g;

    /* JADX INFO: renamed from: lO$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public C3306lO() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final void a() {
        int i;
        C3306lO c3306lO = this.g;
        if (c3306lO == this) {
            throw new IllegalStateException("cannot compact");
        }
        AbstractC4492zt.e(c3306lO);
        if (c3306lO.e) {
            int i2 = this.c - this.b;
            C3306lO c3306lO2 = this.g;
            AbstractC4492zt.e(c3306lO2);
            int i3 = 8192 - c3306lO2.c;
            C3306lO c3306lO3 = this.g;
            AbstractC4492zt.e(c3306lO3);
            if (c3306lO3.d) {
                i = 0;
            } else {
                C3306lO c3306lO4 = this.g;
                AbstractC4492zt.e(c3306lO4);
                i = c3306lO4.b;
            }
            if (i2 > i3 + i) {
                return;
            }
            C3306lO c3306lO5 = this.g;
            AbstractC4492zt.e(c3306lO5);
            g(c3306lO5, i2);
            b();
            C3388mO.b(this);
        }
    }

    public final C3306lO b() {
        C3306lO c3306lO = this.f;
        if (c3306lO == this) {
            c3306lO = null;
        }
        C3306lO c3306lO2 = this.g;
        AbstractC4492zt.e(c3306lO2);
        c3306lO2.f = this.f;
        C3306lO c3306lO3 = this.f;
        AbstractC4492zt.e(c3306lO3);
        c3306lO3.g = this.g;
        this.f = null;
        this.g = null;
        return c3306lO;
    }

    public final C3306lO c(C3306lO c3306lO) {
        AbstractC4492zt.h(c3306lO, "segment");
        c3306lO.g = this;
        c3306lO.f = this.f;
        C3306lO c3306lO2 = this.f;
        AbstractC4492zt.e(c3306lO2);
        c3306lO2.g = c3306lO;
        this.f = c3306lO;
        return c3306lO;
    }

    public final C3306lO d() {
        this.d = true;
        return new C3306lO(this.a, this.b, this.c, true, false);
    }

    public final C3306lO e(int i) {
        C3306lO c3306lOC;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i >= 1024) {
            c3306lOC = d();
        } else {
            c3306lOC = C3388mO.c();
            byte[] bArr = this.a;
            byte[] bArr2 = c3306lOC.a;
            int i2 = this.b;
            Q5.j(bArr, bArr2, 0, i2, i2 + i, 2, null);
        }
        c3306lOC.c = c3306lOC.b + i;
        this.b += i;
        C3306lO c3306lO = this.g;
        AbstractC4492zt.e(c3306lO);
        c3306lO.c(c3306lOC);
        return c3306lOC;
    }

    public final C3306lO f() {
        byte[] bArr = this.a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        AbstractC4492zt.g(bArrCopyOf, "copyOf(this, size)");
        return new C3306lO(bArrCopyOf, this.b, this.c, false, true);
    }

    public final void g(C3306lO c3306lO, int i) {
        AbstractC4492zt.h(c3306lO, "sink");
        if (!c3306lO.e) {
            throw new IllegalStateException("only owner can write");
        }
        int i2 = c3306lO.c;
        if (i2 + i > 8192) {
            if (c3306lO.d) {
                throw new IllegalArgumentException();
            }
            int i3 = c3306lO.b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = c3306lO.a;
            Q5.j(bArr, bArr, 0, i3, i2, 2, null);
            c3306lO.c -= c3306lO.b;
            c3306lO.b = 0;
        }
        byte[] bArr2 = this.a;
        byte[] bArr3 = c3306lO.a;
        int i4 = c3306lO.c;
        int i5 = this.b;
        Q5.d(bArr2, bArr3, i4, i5, i5 + i);
        c3306lO.c += i;
        this.b += i;
    }

    public C3306lO(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        AbstractC4492zt.h(bArr, "data");
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }
}
