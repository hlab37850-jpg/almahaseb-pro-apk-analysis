package org.apache.poi.hssf.record.formula.functions;

import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.record.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Fixed1ArgFunction implements Function1Arg {
    @Override // org.apache.poi.hssf.record.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        return valueEvalArr.length != 1 ? ErrorEval.VALUE_INVALID : evaluate(i, i2, valueEvalArr[0]);
    }
}
