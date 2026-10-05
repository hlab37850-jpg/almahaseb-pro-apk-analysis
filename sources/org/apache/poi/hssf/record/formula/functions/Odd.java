package org.apache.poi.hssf.record.formula.functions;

/* JADX INFO: loaded from: classes4.dex */
public final class Odd extends NumericFunction.OneArg {
    private static final long PARITY_MASK = -2;

    private static long calcOdd(double d) {
        double d2 = d + 1.0d;
        long j = ((long) d2) & PARITY_MASK;
        return ((double) j) == d2 ? j - 1 : j + 1;
    }

    @Override // org.apache.poi.hssf.record.formula.functions.NumericFunction.OneArg
    public double evaluate(double d) {
        if (d == 0.0d) {
            return 1.0d;
        }
        return d > 0.0d ? calcOdd(d) : -calcOdd(-d);
    }
}
