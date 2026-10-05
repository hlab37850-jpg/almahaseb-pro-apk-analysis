package androidx.compose.animation.core;

import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.HV;

/* JADX INFO: loaded from: classes.dex */
public final class ComplexDoubleKt {
    public static final C2020dG complexQuadraticFormula(double d, double d2, double d3) {
        double d4 = (d2 * d2) - ((4.0d * d) * d3);
        double d5 = 1.0d / (d * 2.0d);
        double d6 = -d2;
        ComplexDouble complexDoubleComplexSqrt = complexSqrt(d4);
        complexDoubleComplexSqrt._real += d6;
        complexDoubleComplexSqrt._real *= d5;
        complexDoubleComplexSqrt._imaginary *= d5;
        ComplexDouble complexDoubleComplexSqrt2 = complexSqrt(d4);
        double d7 = -1;
        complexDoubleComplexSqrt2._real *= d7;
        complexDoubleComplexSqrt2._imaginary *= d7;
        complexDoubleComplexSqrt2._real += d6;
        complexDoubleComplexSqrt2._real *= d5;
        complexDoubleComplexSqrt2._imaginary *= d5;
        return HV.a(complexDoubleComplexSqrt, complexDoubleComplexSqrt2);
    }

    public static final ComplexDouble complexSqrt(double d) {
        return d < 0.0d ? new ComplexDouble(0.0d, Math.sqrt(Math.abs(d))) : new ComplexDouble(Math.sqrt(d), 0.0d);
    }

    public static final ComplexDouble minus(double d, ComplexDouble complexDouble) {
        AbstractC4492zt.h(complexDouble, "other");
        double d2 = -1;
        complexDouble._real *= d2;
        complexDouble._imaginary *= d2;
        complexDouble._real += d;
        return complexDouble;
    }

    public static final ComplexDouble plus(double d, ComplexDouble complexDouble) {
        AbstractC4492zt.h(complexDouble, "other");
        complexDouble._real += d;
        return complexDouble;
    }

    public static final ComplexDouble times(double d, ComplexDouble complexDouble) {
        AbstractC4492zt.h(complexDouble, "other");
        complexDouble._real *= d;
        complexDouble._imaginary *= d;
        return complexDouble;
    }
}
