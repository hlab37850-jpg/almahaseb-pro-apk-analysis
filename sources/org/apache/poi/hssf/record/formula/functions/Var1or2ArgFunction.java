package org.apache.poi.hssf.record.formula.functions;

import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.record.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes4.dex */
abstract class Var1or2ArgFunction implements Function1Arg, Function2Arg {
    @Override // org.apache.poi.hssf.record.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length != 1) {
            return length != 2 ? ErrorEval.VALUE_INVALID : evaluate(i, i2, valueEvalArr[0], valueEvalArr[1]);
        }
        return evaluate(i, i2, valueEvalArr[0]);
    }
}
