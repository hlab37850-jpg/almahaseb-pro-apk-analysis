package org.apache.poi.hssf.record.formula.functions;

import org.apache.poi.hssf.record.formula.eval.AreaEval;
import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.record.formula.eval.NumberEval;
import org.apache.poi.hssf.record.formula.eval.RefEval;
import org.apache.poi.hssf.record.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes4.dex */
public final class Column implements Function0Arg, Function1Arg {
    @Override // org.apache.poi.hssf.record.formula.functions.Function0Arg
    public ValueEval evaluate(int i, int i2) {
        return new NumberEval(i2 + 1);
    }

    @Override // org.apache.poi.hssf.record.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        int column;
        if (valueEval instanceof AreaEval) {
            column = ((AreaEval) valueEval).getFirstColumn();
        } else {
            if (!(valueEval instanceof RefEval)) {
                return ErrorEval.VALUE_INVALID;
            }
            column = ((RefEval) valueEval).getColumn();
        }
        return new NumberEval(column + 1);
    }

    @Override // org.apache.poi.hssf.record.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length == 0) {
            return new NumberEval(i2 + 1);
        }
        if (length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(i, i2, valueEvalArr[0]);
    }
}
