package org.apache.poi.hssf.record.formula.eval;

import org.apache.poi.hssf.record.formula.functions.Fixed2ArgFunction;
import org.apache.poi.hssf.record.formula.functions.Function;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TwoOperandNumericOperation extends Fixed2ArgFunction {
    public static final Function AddEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation.1
        @Override // org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d2) {
            return d + d2;
        }
    };
    public static final Function DivideEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation.2
        @Override // org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d2) throws EvaluationException {
            if (d2 != 0.0d) {
                return d / d2;
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function MultiplyEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation.3
        @Override // org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d2) {
            return d * d2;
        }
    };
    public static final Function PowerEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation.4
        @Override // org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d2) {
            return Math.pow(d, d2);
        }
    };
    public static final Function SubtractEval = new SubtractEvalClass();

    public static final class SubtractEvalClass extends TwoOperandNumericOperation {
        @Override // org.apache.poi.hssf.record.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d2) {
            return d - d2;
        }
    }

    public abstract double evaluate(double d, double d2);

    @Override // org.apache.poi.hssf.record.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double dEvaluate = evaluate(singleOperandEvaluate(valueEval, i, i2), singleOperandEvaluate(valueEval2, i, i2));
            if (dEvaluate != 0.0d || (this instanceof SubtractEvalClass)) {
                return (Double.isNaN(dEvaluate) || Double.isInfinite(dEvaluate)) ? ErrorEval.NUM_ERROR : new NumberEval(dEvaluate);
            }
            return NumberEval.ZERO;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public final double singleOperandEvaluate(ValueEval valueEval, int i, int i2) {
        return OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
    }
}
