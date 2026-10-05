package defpackage;

import androidx.core.view.InputDeviceCompat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class X8 {
    public final X8 a;
    public final AtomicReference b;
    public final int c;
    public final boolean d;
    public int e;
    public int f;
    public int g;
    public int[] h;
    public XC[] i;
    public a[] j;
    public int k;
    public int l;
    public transient boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    public static final class a {
        public final XC a;
        public final a b;
        public final int c;

        public a(XC xc, a aVar) {
            this.a = xc;
            this.b = aVar;
            this.c = aVar != null ? 1 + aVar.c : 1;
        }

        public XC a(int i, int i2, int i3) {
            if (this.a.hashCode() == i && this.a.b(i2, i3)) {
                return this.a;
            }
            for (a aVar = this.b; aVar != null; aVar = aVar.b) {
                XC xc = aVar.a;
                if (xc.hashCode() == i && xc.b(i2, i3)) {
                    return xc;
                }
            }
            return null;
        }

        public XC b(int i, int[] iArr, int i2) {
            if (this.a.hashCode() == i && this.a.c(iArr, i2)) {
                return this.a;
            }
            for (a aVar = this.b; aVar != null; aVar = aVar.b) {
                XC xc = aVar.a;
                if (xc.hashCode() == i && xc.c(iArr, i2)) {
                    return xc;
                }
            }
            return null;
        }

        public int c() {
            return this.c;
        }
    }

    public X8(int i, boolean z, int i2) {
        this.a = null;
        this.c = i2;
        this.d = z;
        int i3 = 16;
        if (i < 16) {
            i = 16;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this.b = new AtomicReference(o(i));
    }

    public static XC f(int i, String str, int[] iArr, int i2) {
        if (i2 < 4) {
            if (i2 == 1) {
                return new UC(str, i, iArr[0]);
            }
            if (i2 == 2) {
                return new VC(str, i, iArr[0], iArr[1]);
            }
            if (i2 == 3) {
                return new WC(str, i, iArr[0], iArr[1], iArr[2]);
            }
        }
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = iArr[i3];
        }
        return new YC(str, i, iArr2, i2);
    }

    public static X8 g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return h((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }

    public static X8 h(int i) {
        return new X8(64, true, i);
    }

    public static XC n() {
        return UC.e();
    }

    public final void a(int i, XC xc) {
        int iJ;
        if (this.n) {
            x();
        }
        if (this.m) {
            t();
        }
        this.e++;
        int i2 = this.g & i;
        if (this.i[i2] == null) {
            this.h[i2] = i << 8;
            if (this.o) {
                y();
            }
            this.i[i2] = xc;
        } else {
            if (this.p) {
                w();
            }
            this.k++;
            int i3 = this.h[i2];
            int i4 = i3 & 255;
            if (i4 == 0) {
                iJ = this.l;
                if (iJ <= 254) {
                    this.l = iJ + 1;
                    if (iJ >= this.j.length) {
                        i();
                    }
                } else {
                    iJ = j();
                }
                this.h[i2] = (i3 & InputDeviceCompat.SOURCE_ANY) | (iJ + 1);
            } else {
                iJ = i4 - 1;
            }
            a aVar = new a(xc, this.j[iJ]);
            this.j[iJ] = aVar;
            int iMax = Math.max(aVar.c(), this.f);
            this.f = iMax;
            if (iMax > 255) {
                v(255);
            }
        }
        int length = this.h.length;
        int i5 = this.e;
        if (i5 > (length >> 1)) {
            int i6 = length >> 2;
            if (i5 > length - i6) {
                this.m = true;
            } else if (this.k >= i6) {
                this.m = true;
            }
        }
    }

    public XC b(String str, int[] iArr, int i) {
        int iE;
        if (this.d) {
            str = C4077ut.a.a(str);
        }
        if (i < 3) {
            iE = i == 1 ? c(iArr[0]) : d(iArr[0], iArr[1]);
        } else {
            iE = e(iArr, i);
        }
        XC xcF = f(iE, str, iArr, i);
        a(iE, xcF);
        return xcF;
    }

    public int c(int i) {
        int i2 = i ^ this.c;
        int i3 = i2 + (i2 >>> 15);
        return i3 ^ (i3 >>> 9);
    }

    public int d(int i, int i2) {
        int i3 = ((i ^ (i >>> 15)) + (i2 * 33)) ^ this.c;
        return i3 + (i3 >>> 7);
    }

    public int e(int[] iArr, int i) {
        if (i < 3) {
            throw new IllegalArgumentException();
        }
        int i2 = iArr[0] ^ this.c;
        int i3 = (((i2 + (i2 >>> 9)) * 33) + iArr[1]) * 65599;
        int i4 = (i3 + (i3 >>> 15)) ^ iArr[2];
        int i5 = i4 + (i4 >>> 17);
        for (int i6 = 3; i6 < i; i6++) {
            int i7 = (i5 * 31) ^ iArr[i6];
            int i8 = i7 + (i7 >>> 3);
            i5 = i8 ^ (i8 << 7);
        }
        int i9 = i5 + (i5 >>> 15);
        return (i9 << 9) ^ i9;
    }

    public final void i() {
        a[] aVarArr = this.j;
        int length = aVarArr.length;
        a[] aVarArr2 = new a[length + length];
        this.j = aVarArr2;
        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
    }

    public final int j() {
        a[] aVarArr = this.j;
        int i = this.l;
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            int iC = aVarArr[i4].c();
            if (iC < i2) {
                if (iC == 1) {
                    return i4;
                }
                i3 = i4;
                i2 = iC;
            }
        }
        return i3;
    }

    public XC k(int i) {
        int iC = c(i);
        int i2 = this.g & iC;
        int i3 = this.h[i2];
        if ((((i3 >> 8) ^ iC) << 8) == 0) {
            XC xc = this.i[i2];
            if (xc == null) {
                return null;
            }
            if (xc.a(i)) {
                return xc;
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = i3 & 255;
        if (i4 > 0) {
            a aVar = this.j[i4 - 1];
            if (aVar != null) {
                return aVar.a(iC, i, 0);
            }
        }
        return null;
    }

    public XC l(int i, int i2) {
        int iC = i2 == 0 ? c(i) : d(i, i2);
        int i3 = this.g & iC;
        int i4 = this.h[i3];
        if ((((i4 >> 8) ^ iC) << 8) == 0) {
            XC xc = this.i[i3];
            if (xc == null) {
                return null;
            }
            if (xc.b(i, i2)) {
                return xc;
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = i4 & 255;
        if (i5 > 0) {
            a aVar = this.j[i5 - 1];
            if (aVar != null) {
                return aVar.a(iC, i, i2);
            }
        }
        return null;
    }

    public XC m(int[] iArr, int i) {
        if (i < 3) {
            return l(iArr[0], i >= 2 ? iArr[1] : 0);
        }
        int iE = e(iArr, i);
        int i2 = this.g & iE;
        int i3 = this.h[i2];
        if ((((i3 >> 8) ^ iE) << 8) == 0) {
            XC xc = this.i[i2];
            if (xc == null || xc.c(iArr, i)) {
                return xc;
            }
        } else if (i3 == 0) {
            return null;
        }
        int i4 = i3 & 255;
        if (i4 > 0) {
            a aVar = this.j[i4 - 1];
            if (aVar != null) {
                return aVar.b(iE, iArr, i);
            }
        }
        return null;
    }

    public final b o(int i) {
        return new b(0, i - 1, new int[i], new XC[i], null, 0, 0, 0);
    }

    public X8 p(boolean z, boolean z2) {
        return new X8(this, z2, this.c, (b) this.b.get());
    }

    public boolean q() {
        return !this.n;
    }

    public final void r(b bVar) {
        int i = bVar.a;
        b bVar2 = (b) this.b.get();
        if (i <= bVar2.a) {
            return;
        }
        if (i > 6000 || bVar.h > 63) {
            bVar = o(64);
        }
        FC.a(this.b, bVar2, bVar);
    }

    public final void s() {
        this.e = 0;
        this.f = 0;
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, (Object) null);
        Arrays.fill(this.j, (Object) null);
        this.k = 0;
        this.l = 0;
    }

    public final void t() {
        int iJ;
        this.m = false;
        this.o = false;
        int length = this.h.length;
        int i = length + length;
        if (i > 65536) {
            s();
            return;
        }
        this.h = new int[i];
        this.g = i - 1;
        XC[] xcArr = this.i;
        this.i = new XC[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            XC xc = xcArr[i3];
            if (xc != null) {
                i2++;
                int iHashCode = xc.hashCode();
                int i4 = this.g & iHashCode;
                this.i[i4] = xc;
                this.h[i4] = iHashCode << 8;
            }
        }
        int i5 = this.l;
        if (i5 == 0) {
            this.f = 0;
            return;
        }
        this.k = 0;
        this.l = 0;
        this.p = false;
        a[] aVarArr = this.j;
        this.j = new a[aVarArr.length];
        int iMax = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            for (a aVar = aVarArr[i6]; aVar != null; aVar = aVar.b) {
                i2++;
                XC xc2 = aVar.a;
                int iHashCode2 = xc2.hashCode();
                int i7 = this.g & iHashCode2;
                int[] iArr = this.h;
                int i8 = iArr[i7];
                XC[] xcArr2 = this.i;
                if (xcArr2[i7] == null) {
                    iArr[i7] = iHashCode2 << 8;
                    xcArr2[i7] = xc2;
                } else {
                    this.k++;
                    int i9 = i8 & 255;
                    if (i9 == 0) {
                        iJ = this.l;
                        if (iJ <= 254) {
                            this.l = iJ + 1;
                            if (iJ >= this.j.length) {
                                i();
                            }
                        } else {
                            iJ = j();
                        }
                        this.h[i7] = (i8 & InputDeviceCompat.SOURCE_ANY) | (iJ + 1);
                    } else {
                        iJ = i9 - 1;
                    }
                    a aVar2 = new a(xc2, this.j[iJ]);
                    this.j[iJ] = aVar2;
                    iMax = Math.max(iMax, aVar2.c());
                }
            }
        }
        this.f = iMax;
        if (i2 == this.e) {
            return;
        }
        throw new RuntimeException("Internal error: count after rehash " + i2 + "; should be " + this.e);
    }

    public void u() {
        if (this.a == null || !q()) {
            return;
        }
        this.a.r(new b(this));
        this.n = true;
        this.o = true;
        this.p = true;
    }

    public void v(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.e + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }

    public final void w() {
        a[] aVarArr = this.j;
        if (aVarArr == null) {
            this.j = new a[32];
        } else {
            int length = aVarArr.length;
            a[] aVarArr2 = new a[length];
            this.j = aVarArr2;
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
        }
        this.p = false;
    }

    public final void x() {
        int[] iArr = this.h;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        this.h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.n = false;
    }

    public final void y() {
        XC[] xcArr = this.i;
        int length = xcArr.length;
        XC[] xcArr2 = new XC[length];
        this.i = xcArr2;
        System.arraycopy(xcArr, 0, xcArr2, 0, length);
        this.o = false;
    }

    public X8(X8 x8, boolean z, int i, b bVar) {
        this.a = x8;
        this.c = i;
        this.d = z;
        this.b = null;
        this.e = bVar.a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = bVar.d;
        this.j = bVar.e;
        this.k = bVar.f;
        this.l = bVar.g;
        this.f = bVar.h;
        this.m = false;
        this.n = true;
        this.o = true;
        this.p = true;
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int[] c;
        public final XC[] d;
        public final a[] e;
        public final int f;
        public final int g;
        public final int h;

        public b(int i, int i2, int[] iArr, XC[] xcArr, a[] aVarArr, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = iArr;
            this.d = xcArr;
            this.e = aVarArr;
            this.f = i3;
            this.g = i4;
            this.h = i5;
        }

        public b(X8 x8) {
            this.a = x8.e;
            this.b = x8.g;
            this.c = x8.h;
            this.d = x8.i;
            this.e = x8.j;
            this.f = x8.k;
            this.g = x8.l;
            this.h = x8.f;
        }
    }
}
