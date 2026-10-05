package org.apache.poi.hssf.record.formula.functions;

import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.record.formula.eval.EvaluationException;
import org.apache.poi.hssf.record.formula.eval.NumberEval;
import org.apache.poi.hssf.record.formula.eval.RefEval;
import org.apache.poi.hssf.record.formula.eval.ValueEval;
import org.apache.poi.ss.formula.TwoDEval;

/* JADX INFO: loaded from: classes4.dex */
public abstract class XYNumericFunction extends Fixed2ArgFunction {

    public interface Accumulator {
        double accumulate(double d, double d2);
    }

    public static final class AreaValueArray extends ValueArray {
        private final TwoDEval _ae;
        private final int _width;

        public AreaValueArray(TwoDEval twoDEval) {
            super(twoDEval.getWidth() * twoDEval.getHeight());
            this._ae = twoDEval;
            this._width = twoDEval.getWidth();
        }

        @Override // org.apache.poi.hssf.record.formula.functions.XYNumericFunction.ValueArray
        public ValueEval getItemInternal(int i) {
            int i2 = this._width;
            return this._ae.getValue(i / i2, i % i2);
        }
    }

    public static final class RefValueArray extends ValueArray {
        private final RefEval _ref;

        public RefValueArray(RefEval refEval) {
            super(1);
            this._ref = refEval;
        }

        @Override // org.apache.poi.hssf.record.formula.functions.XYNumericFunction.ValueArray
        public ValueEval getItemInternal(int i) {
            return this._ref.getInnerValueEval();
        }
    }

    public static final class SingleCellValueArray extends ValueArray {
        private final ValueEval _value;

        public SingleCellValueArray(ValueEval valueEval) {
            super(1);
            this._value = valueEval;
        }

        @Override // org.apache.poi.hssf.record.formula.functions.XYNumericFunction.ValueArray
        public ValueEval getItemInternal(int i) {
            return this._value;
        }
    }

    public static abstract class ValueArray implements LookupUtils.ValueVector {
        private final int _size;

        public ValueArray(int i) {
            this._size = i;
        }

        @Override // org.apache.poi.hssf.record.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i) {
            if (i >= 0 && i <= this._size) {
                return getItemInternal(i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Specified index ");
            sb.append(i);
            sb.append(" is outside range (0..");
            sb.append(this._size - 1);
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }

        public abstract ValueEval getItemInternal(int i);

        @Override // org.apache.poi.hssf.record.formula.functions.LookupUtils.ValueVector
        public final int getSize() {
            return this._size;
        }
    }

    private static LookupUtils.ValueVector createValueVector(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval instanceof TwoDEval) {
            return new AreaValueArray((TwoDEval) valueEval);
        }
        return valueEval instanceof RefEval ? new RefValueArray((RefEval) valueEval) : new SingleCellValueArray(valueEval);
    }

    private double evaluateInternal(LookupUtils.ValueVector valueVector, LookupUtils.ValueVector valueVector2, int i) throws EvaluationException {
        Accumulator accumulatorCreateAccumulator = createAccumulator();
        ErrorEval errorEval = null;
        ErrorEval errorEval2 = null;
        double dAccumulate = 0.0d;
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            ValueEval item = valueVector.getItem(i2);
            ValueEval item2 = valueVector2.getItem(i2);
            if ((item instanceof ErrorEval) && errorEval == null) {
                errorEval = (ErrorEval) item;
            } else if ((item2 instanceof ErrorEval) && errorEval2 == null) {
                errorEval2 = (ErrorEval) item2;
            } else if ((item instanceof NumberEval) && (item2 instanceof NumberEval)) {
                dAccumulate += accumulatorCreateAccumulator.accumulate(((NumberEval) item).getNumberValue(), ((NumberEval) item2).getNumberValue());
                z = true;
            }
        }
        if (errorEval != null) {
            throw new EvaluationException(errorEval);
        }
        if (errorEval2 != null) {
            throw new EvaluationException(errorEval2);
        }
        if (z) {
            return dAccumulate;
        }
        throw new EvaluationException(ErrorEval.DIV_ZERO);
    }

    public abstract Accumulator createAccumulator();

    @Override // org.apache.poi.hssf.record.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            LookupUtils.ValueVector valueVectorCreateValueVector = createValueVector(valueEval);
            LookupUtils.ValueVector valueVectorCreateValueVector2 = createValueVector(valueEval2);
            int size = valueVectorCreateValueVector.getSize();
            if (size != 0 && valueVectorCreateValueVector2.getSize() == size) {
                double dEvaluateInternal = evaluateInternal(valueVectorCreateValueVector, valueVectorCreateValueVector2, size);
                return (Double.isNaN(dEvaluateInternal) || Double.isInfinite(dEvaluateInternal)) ? ErrorEval.NUM_ERROR : new NumberEval(dEvaluateInternal);
            }
            return ErrorEval.NA;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
