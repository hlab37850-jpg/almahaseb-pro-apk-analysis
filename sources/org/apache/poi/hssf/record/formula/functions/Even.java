package org.apache.poi.hssf.record.formula.functions;

/* JADX INFO: loaded from: classes4.dex */
public final class Even extends NumericFunction.OneArg {
    private static final long PARITY_MASK = -2;

    private static long calcEven(double d) {
        long j = ((long) d) & PARITY_MASK;
        return ((double) j) == d ? j : j + 2;
    }

    @Override // org.apache.poi.hssf.record.formula.functions.NumericFunction.OneArg
    public double evaluate(double d) {
        if (d == 0.0d) {
            return 0.0d;
        }
        return d > 0.0d ? calcEven(d) : -calcEven(-d);
    }
}
