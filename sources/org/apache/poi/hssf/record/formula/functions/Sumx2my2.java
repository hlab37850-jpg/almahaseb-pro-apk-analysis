package org.apache.poi.hssf.record.formula.functions;

/* JADX INFO: loaded from: classes4.dex */
public final class Sumx2my2 extends XYNumericFunction {
    private static final XYNumericFunction.Accumulator XSquaredMinusYSquaredAccumulator = new XYNumericFunction.Accumulator() { // from class: org.apache.poi.hssf.record.formula.functions.Sumx2my2.1
        @Override // org.apache.poi.hssf.record.formula.functions.XYNumericFunction.Accumulator
        public double accumulate(double d, double d2) {
            return (d * d) - (d2 * d2);
        }
    };

    @Override // org.apache.poi.hssf.record.formula.functions.XYNumericFunction
    public XYNumericFunction.Accumulator createAccumulator() {
        return XSquaredMinusYSquaredAccumulator;
    }
}
