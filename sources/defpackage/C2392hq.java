package defpackage;

import com.google.zxing.common.reedsolomon.GenericGF;

/* JADX INFO: renamed from: hq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2392hq {
    public final GenericGF a;
    public final int[] b;

    public C2392hq(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = genericGF;
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

    public C2392hq a(C2392hq c2392hq) {
        if (!this.a.equals(c2392hq.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return c2392hq;
        }
        if (c2392hq.g()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = c2392hq.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = GenericGF.addOrSubtract(iArr2[i - length], iArr[i]);
        }
        return new C2392hq(this.a, iArr3);
    }

    public C2392hq[] b(C2392hq c2392hq) {
        if (!this.a.equals(c2392hq.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c2392hq.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        C2392hq zero = this.a.getZero();
        int iInverse = this.a.inverse(c2392hq.d(c2392hq.f()));
        C2392hq c2392hqA = this;
        while (c2392hqA.f() >= c2392hq.f() && !c2392hqA.g()) {
            int iF = c2392hqA.f() - c2392hq.f();
            int iMultiply = this.a.multiply(c2392hqA.d(c2392hqA.f()), iInverse);
            C2392hq c2392hqJ = c2392hq.j(iF, iMultiply);
            zero = zero.a(this.a.buildMonomial(iF, iMultiply));
            c2392hqA = c2392hqA.a(c2392hqJ);
        }
        return new C2392hq[]{zero, c2392hqA};
    }

    public int c(int i) {
        if (i == 0) {
            return d(0);
        }
        if (i == 1) {
            int iAddOrSubtract = 0;
            for (int i2 : this.b) {
                iAddOrSubtract = GenericGF.addOrSubtract(iAddOrSubtract, i2);
            }
            return iAddOrSubtract;
        }
        int[] iArr = this.b;
        int iAddOrSubtract2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iAddOrSubtract2 = GenericGF.addOrSubtract(this.a.multiply(i, iAddOrSubtract2), this.b[i3]);
        }
        return iAddOrSubtract2;
    }

    public int d(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    public int[] e() {
        return this.b;
    }

    public int f() {
        return this.b.length - 1;
    }

    public boolean g() {
        return this.b[0] == 0;
    }

    public C2392hq h(int i) {
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
        return new C2392hq(this.a, iArr);
    }

    public C2392hq i(C2392hq c2392hq) {
        if (!this.a.equals(c2392hq.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || c2392hq.g()) {
            return this.a.getZero();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = c2392hq.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = GenericGF.addOrSubtract(iArr3[i4], this.a.multiply(i2, iArr2[i3]));
            }
        }
        return new C2392hq(this.a, iArr3);
    }

    public C2392hq j(int i, int i2) {
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
        return new C2392hq(this.a, iArr);
    }

    public String toString() {
        if (g()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int iF = f(); iF >= 0; iF--) {
            int iD = d(iF);
            if (iD != 0) {
                if (iD < 0) {
                    if (iF == f()) {
                        sb.append("-");
                    } else {
                        sb.append(" - ");
                    }
                    iD = -iD;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iF == 0 || iD != 1) {
                    int iLog = this.a.log(iD);
                    if (iLog == 0) {
                        sb.append('1');
                    } else if (iLog == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iLog);
                    }
                }
                if (iF != 0) {
                    if (iF == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iF);
                    }
                }
            }
        }
        return sb.toString();
    }
}
