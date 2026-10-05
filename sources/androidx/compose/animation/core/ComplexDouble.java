package androidx.compose.animation.core;

import defpackage.AbstractC3162je;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ComplexDouble {
    private double _imaginary;
    private double _real;

    public ComplexDouble(double d, double d2) {
        this._real = d;
        this._imaginary = d2;
    }

    private final double component1() {
        return this._real;
    }

    private final double component2() {
        return this._imaginary;
    }

    public static /* synthetic */ ComplexDouble copy$default(ComplexDouble complexDouble, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = complexDouble._real;
        }
        if ((i & 2) != 0) {
            d2 = complexDouble._imaginary;
        }
        return complexDouble.copy(d, d2);
    }

    public final ComplexDouble copy(double d, double d2) {
        return new ComplexDouble(d, d2);
    }

    public final ComplexDouble div(double d) {
        this._real /= d;
        this._imaginary /= d;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplexDouble)) {
            return false;
        }
        ComplexDouble complexDouble = (ComplexDouble) obj;
        return Double.compare(this._real, complexDouble._real) == 0 && Double.compare(this._imaginary, complexDouble._imaginary) == 0;
    }

    public final double getImaginary() {
        return this._imaginary;
    }

    public final double getReal() {
        return this._real;
    }

    public int hashCode() {
        return (AbstractC3162je.a(this._real) * 31) + AbstractC3162je.a(this._imaginary);
    }

    public final ComplexDouble minus(double d) {
        this._real += -d;
        return this;
    }

    public final ComplexDouble plus(double d) {
        this._real += d;
        return this;
    }

    public final ComplexDouble times(double d) {
        this._real *= d;
        this._imaginary *= d;
        return this;
    }

    public String toString() {
        return "ComplexDouble(_real=" + this._real + ", _imaginary=" + this._imaginary + ')';
    }

    public final ComplexDouble unaryMinus() {
        double d = -1;
        this._real *= d;
        this._imaginary *= d;
        return this;
    }

    public final ComplexDouble minus(ComplexDouble complexDouble) {
        AbstractC4492zt.h(complexDouble, "other");
        double d = -1;
        complexDouble._real *= d;
        complexDouble._imaginary *= d;
        this._real += complexDouble.getReal();
        this._imaginary += complexDouble.getImaginary();
        return this;
    }

    public final ComplexDouble plus(ComplexDouble complexDouble) {
        AbstractC4492zt.h(complexDouble, "other");
        this._real += complexDouble.getReal();
        this._imaginary += complexDouble.getImaginary();
        return this;
    }

    public final ComplexDouble times(ComplexDouble complexDouble) {
        AbstractC4492zt.h(complexDouble, "other");
        this._real = (getReal() * complexDouble.getReal()) - (getImaginary() * complexDouble.getImaginary());
        this._imaginary = (getReal() * complexDouble.getImaginary()) + (complexDouble.getReal() * getImaginary());
        return this;
    }
}
