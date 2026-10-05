package defpackage;

import com.google.zxing.pdf417.decoder.ec.ModulusGF;

/* JADX INFO: renamed from: eC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2097eC {
    public final ModulusGF a;
    public final int[] b;

    public C2097eC(ModulusGF modulusGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = modulusGF;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public C2097eC a(C2097eC c2097eC) {
        if (!this.a.equals(c2097eC.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return c2097eC;
        }
        if (c2097eC.e()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = c2097eC.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.a.add(iArr2[i - length], iArr[i]);
        }
        return new C2097eC(this.a, iArr3);
    }

    public int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i == 1) {
            int iAdd = 0;
            for (int i2 : this.b) {
                iAdd = this.a.add(iAdd, i2);
            }
            return iAdd;
        }
        int[] iArr = this.b;
        int iAdd2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            ModulusGF modulusGF = this.a;
            iAdd2 = modulusGF.add(modulusGF.multiply(i, iAdd2), this.b[i3]);
        }
        return iAdd2;
    }

    public int c(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    public int d() {
        return this.b.length - 1;
    }

    public boolean e() {
        return this.b[0] == 0;
    }

    public C2097eC f(int i) {
        if (i == 0) {
            return this.a.getZero();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.multiply(this.b[i2], i);
        }
        return new C2097eC(this.a, iArr);
    }

    public C2097eC g(C2097eC c2097eC) {
        if (!this.a.equals(c2097eC.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || c2097eC.e()) {
            return this.a.getZero();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = c2097eC.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                ModulusGF modulusGF = this.a;
                iArr3[i4] = modulusGF.add(iArr3[i4], modulusGF.multiply(i2, iArr2[i3]));
            }
        }
        return new C2097eC(this.a, iArr3);
    }

    public C2097eC h(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.a.getZero();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.multiply(this.b[i3], i2);
        }
        return new C2097eC(this.a, iArr);
    }

    public C2097eC i() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.a.subtract(0, this.b[i]);
        }
        return new C2097eC(this.a, iArr);
    }

    public C2097eC j(C2097eC c2097eC) {
        if (this.a.equals(c2097eC.a)) {
            return c2097eC.e() ? this : a(c2097eC.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    sb.append(iC);
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
