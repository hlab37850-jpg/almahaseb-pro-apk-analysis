package com.itextpdf.text.pdf.qrcode;

/* JADX INFO: loaded from: classes3.dex */
final class GF256Poly {
    private final int[] coefficients;
    private final GF256 field;

    public GF256Poly(GF256 gf256, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = gf256;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.coefficients = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.coefficients = gf256.getZero().coefficients;
            return;
        }
        int[] iArr2 = new int[length - i];
        this.coefficients = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public GF256Poly addOrSubtract(GF256Poly gF256Poly) {
        if (!this.field.equals(gF256Poly.field)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        }
        if (isZero()) {
            return gF256Poly;
        }
        if (gF256Poly.isZero()) {
            return this;
        }
        int[] iArr = this.coefficients;
        int[] iArr2 = gF256Poly.coefficients;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = GF256.addOrSubtract(iArr2[i - length], iArr[i]);
        }
        return new GF256Poly(this.field, iArr3);
    }

    public GF256Poly[] divide(GF256Poly gF256Poly) {
        if (!this.field.equals(gF256Poly.field)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        }
        if (gF256Poly.isZero()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GF256Poly zero = this.field.getZero();
        int iInverse = this.field.inverse(gF256Poly.getCoefficient(gF256Poly.getDegree()));
        GF256Poly gF256PolyAddOrSubtract = this;
        while (gF256PolyAddOrSubtract.getDegree() >= gF256Poly.getDegree() && !gF256PolyAddOrSubtract.isZero()) {
            int degree = gF256PolyAddOrSubtract.getDegree() - gF256Poly.getDegree();
            int iMultiply = this.field.multiply(gF256PolyAddOrSubtract.getCoefficient(gF256PolyAddOrSubtract.getDegree()), iInverse);
            GF256Poly gF256PolyMultiplyByMonomial = gF256Poly.multiplyByMonomial(degree, iMultiply);
            zero = zero.addOrSubtract(this.field.buildMonomial(degree, iMultiply));
            gF256PolyAddOrSubtract = gF256PolyAddOrSubtract.addOrSubtract(gF256PolyMultiplyByMonomial);
        }
        return new GF256Poly[]{zero, gF256PolyAddOrSubtract};
    }

    public int evaluateAt(int i) {
        if (i == 0) {
            return getCoefficient(0);
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        if (i == 1) {
            int iAddOrSubtract = 0;
            for (int i2 = 0; i2 < length; i2++) {
                iAddOrSubtract = GF256.addOrSubtract(iAddOrSubtract, this.coefficients[i2]);
            }
            return iAddOrSubtract;
        }
        int iAddOrSubtract2 = iArr[0];
        for (int i3 = 1; i3 < length; i3++) {
            iAddOrSubtract2 = GF256.addOrSubtract(this.field.multiply(i, iAddOrSubtract2), this.coefficients[i3]);
        }
        return iAddOrSubtract2;
    }

    public int getCoefficient(int i) {
        int[] iArr = this.coefficients;
        return iArr[(iArr.length - 1) - i];
    }

    public int[] getCoefficients() {
        return this.coefficients;
    }

    public int getDegree() {
        return this.coefficients.length - 1;
    }

    public boolean isZero() {
        return this.coefficients[0] == 0;
    }

    public GF256Poly multiply(GF256Poly gF256Poly) {
        if (!this.field.equals(gF256Poly.field)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        }
        if (isZero() || gF256Poly.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = gF256Poly.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = GF256.addOrSubtract(iArr3[i4], this.field.multiply(i2, iArr2[i3]));
            }
        }
        return new GF256Poly(this.field, iArr3);
    }

    public GF256Poly multiplyByMonomial(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.field.getZero();
        }
        int length = this.coefficients.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
        }
        return new GF256Poly(this.field, iArr);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    stringBuffer.append(" - ");
                    coefficient = -coefficient;
                } else if (stringBuffer.length() > 0) {
                    stringBuffer.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    int iLog = this.field.log(coefficient);
                    if (iLog == 0) {
                        stringBuffer.append('1');
                    } else if (iLog == 1) {
                        stringBuffer.append('a');
                    } else {
                        stringBuffer.append("a^");
                        stringBuffer.append(iLog);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        stringBuffer.append('x');
                    } else {
                        stringBuffer.append("x^");
                        stringBuffer.append(degree);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    public GF256Poly multiply(int i) {
        if (i == 0) {
            return this.field.getZero();
        }
        if (i == 1) {
            return this;
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.field.multiply(this.coefficients[i2], i);
        }
        return new GF256Poly(this.field, iArr);
    }
}
