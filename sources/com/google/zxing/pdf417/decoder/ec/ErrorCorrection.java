package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;
import defpackage.C2097eC;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    private int[] findErrorLocations(C2097eC c2097eC) throws ChecksumException {
        int iD = c2097eC.d();
        int[] iArr = new int[iD];
        int i = 0;
        for (int i2 = 1; i2 < this.field.getSize() && i < iD; i2++) {
            if (c2097eC.b(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i == iD) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(C2097eC c2097eC, C2097eC c2097eC2, int[] iArr) {
        int iD = c2097eC2.d();
        int[] iArr2 = new int[iD];
        for (int i = 1; i <= iD; i++) {
            iArr2[iD - i] = this.field.multiply(i, c2097eC2.c(i));
        }
        C2097eC c2097eC3 = new C2097eC(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iInverse = this.field.inverse(iArr[i2]);
            iArr3[i2] = this.field.multiply(this.field.subtract(0, c2097eC.b(iInverse)), this.field.inverse(c2097eC3.b(iInverse)));
        }
        return iArr3;
    }

    private C2097eC[] runEuclideanAlgorithm(C2097eC c2097eC, C2097eC c2097eC2, int i) throws ChecksumException {
        if (c2097eC.d() < c2097eC2.d()) {
            c2097eC2 = c2097eC;
            c2097eC = c2097eC2;
        }
        C2097eC zero = this.field.getZero();
        C2097eC one = this.field.getOne();
        while (true) {
            C2097eC c2097eC3 = c2097eC2;
            c2097eC2 = c2097eC;
            c2097eC = c2097eC3;
            C2097eC c2097eC4 = one;
            C2097eC c2097eC5 = zero;
            zero = c2097eC4;
            if (c2097eC.d() < i / 2) {
                int iC = zero.c(0);
                if (iC == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int iInverse = this.field.inverse(iC);
                return new C2097eC[]{zero.f(iInverse), c2097eC.f(iInverse)};
            }
            if (c2097eC.e()) {
                throw ChecksumException.getChecksumInstance();
            }
            C2097eC zero2 = this.field.getZero();
            int iInverse2 = this.field.inverse(c2097eC.c(c2097eC.d()));
            while (c2097eC2.d() >= c2097eC.d() && !c2097eC2.e()) {
                int iD = c2097eC2.d() - c2097eC.d();
                int iMultiply = this.field.multiply(c2097eC2.c(c2097eC2.d()), iInverse2);
                zero2 = zero2.a(this.field.buildMonomial(iD, iMultiply));
                c2097eC2 = c2097eC2.j(c2097eC.h(iD, iMultiply));
            }
            one = zero2.g(zero).j(c2097eC5).i();
        }
    }

    public int decode(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        C2097eC c2097eC = new C2097eC(this.field, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iB = c2097eC.b(this.field.exp(i2));
            iArr3[i - i2] = iB;
            if (iB != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        C2097eC one = this.field.getOne();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iExp = this.field.exp((iArr.length - 1) - i3);
                ModulusGF modulusGF = this.field;
                one = one.g(new C2097eC(modulusGF, new int[]{modulusGF.subtract(0, iExp), 1}));
            }
        }
        C2097eC[] c2097eCArrRunEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new C2097eC(this.field, iArr3), i);
        C2097eC c2097eC2 = c2097eCArrRunEuclideanAlgorithm[0];
        C2097eC c2097eC3 = c2097eCArrRunEuclideanAlgorithm[1];
        int[] iArrFindErrorLocations = findErrorLocations(c2097eC2);
        int[] iArrFindErrorMagnitudes = findErrorMagnitudes(c2097eC3, c2097eC2, iArrFindErrorLocations);
        for (int i4 = 0; i4 < iArrFindErrorLocations.length; i4++) {
            int length = (iArr.length - 1) - this.field.log(iArrFindErrorLocations[i4]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.field.subtract(iArr[length], iArrFindErrorMagnitudes[i4]);
        }
        return iArrFindErrorLocations.length;
    }
}
