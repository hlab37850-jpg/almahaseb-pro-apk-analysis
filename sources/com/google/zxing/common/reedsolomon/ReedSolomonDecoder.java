package com.google.zxing.common.reedsolomon;

import defpackage.C2392hq;

/* JADX INFO: loaded from: classes3.dex */
public final class ReedSolomonDecoder {
    private final GenericGF field;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.field = genericGF;
    }

    private int[] findErrorLocations(C2392hq c2392hq) throws ReedSolomonException {
        int iF = c2392hq.f();
        if (iF == 1) {
            return new int[]{c2392hq.d(1)};
        }
        int[] iArr = new int[iF];
        int i = 0;
        for (int i2 = 1; i2 < this.field.getSize() && i < iF; i2++) {
            if (c2392hq.c(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i == iF) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] findErrorMagnitudes(C2392hq c2392hq, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iInverse = this.field.inverse(iArr[i]);
            int iMultiply = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iMultiply2 = this.field.multiply(iArr[i2], iInverse);
                    iMultiply = this.field.multiply(iMultiply, (iMultiply2 & 1) == 0 ? iMultiply2 | 1 : iMultiply2 & (-2));
                }
            }
            iArr2[i] = this.field.multiply(c2392hq.c(iInverse), this.field.inverse(iMultiply));
            if (this.field.getGeneratorBase() != 0) {
                iArr2[i] = this.field.multiply(iArr2[i], iInverse);
            }
        }
        return iArr2;
    }

    private C2392hq[] runEuclideanAlgorithm(C2392hq c2392hq, C2392hq c2392hq2, int i) throws ReedSolomonException {
        if (c2392hq.f() < c2392hq2.f()) {
            c2392hq2 = c2392hq;
            c2392hq = c2392hq2;
        }
        C2392hq zero = this.field.getZero();
        C2392hq one = this.field.getOne();
        do {
            C2392hq c2392hq3 = c2392hq2;
            c2392hq2 = c2392hq;
            c2392hq = c2392hq3;
            C2392hq c2392hq4 = one;
            C2392hq c2392hq5 = zero;
            zero = c2392hq4;
            if (c2392hq.f() < i / 2) {
                int iD = zero.d(0);
                if (iD == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iInverse = this.field.inverse(iD);
                return new C2392hq[]{zero.h(iInverse), c2392hq.h(iInverse)};
            }
            if (c2392hq.g()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            C2392hq zero2 = this.field.getZero();
            int iInverse2 = this.field.inverse(c2392hq.d(c2392hq.f()));
            while (c2392hq2.f() >= c2392hq.f() && !c2392hq2.g()) {
                int iF = c2392hq2.f() - c2392hq.f();
                int iMultiply = this.field.multiply(c2392hq2.d(c2392hq2.f()), iInverse2);
                zero2 = zero2.a(this.field.buildMonomial(iF, iMultiply));
                c2392hq2 = c2392hq2.a(c2392hq.j(iF, iMultiply));
            }
            one = zero2.i(zero).a(c2392hq5);
        } while (c2392hq2.f() < c2392hq.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void decode(int[] iArr, int i) throws ReedSolomonException {
        C2392hq c2392hq = new C2392hq(this.field, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            GenericGF genericGF = this.field;
            int iC = c2392hq.c(genericGF.exp(genericGF.getGeneratorBase() + i2));
            iArr2[(i - 1) - i2] = iC;
            if (iC != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        C2392hq[] c2392hqArrRunEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new C2392hq(this.field, iArr2), i);
        C2392hq c2392hq2 = c2392hqArrRunEuclideanAlgorithm[0];
        C2392hq c2392hq3 = c2392hqArrRunEuclideanAlgorithm[1];
        int[] iArrFindErrorLocations = findErrorLocations(c2392hq2);
        int[] iArrFindErrorMagnitudes = findErrorMagnitudes(c2392hq3, iArrFindErrorLocations);
        for (int i3 = 0; i3 < iArrFindErrorLocations.length; i3++) {
            int length = (iArr.length - 1) - this.field.log(iArrFindErrorLocations[i3]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = GenericGF.addOrSubtract(iArr[length], iArrFindErrorMagnitudes[i3]);
        }
    }
}
