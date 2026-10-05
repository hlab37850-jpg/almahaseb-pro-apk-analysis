package org.apache.poi.hssf.record.formula.functions;

import org.apache.poi.hssf.record.formula.eval.ValueEval;
import org.apache.poi.ss.formula.eval.NotImplementedException;

/* JADX INFO: loaded from: classes4.dex */
public final class NotImplementedFunction implements Function {
    private final String _functionName;

    public NotImplementedFunction() {
        this._functionName = NotImplementedFunction.class.getName();
    }

    @Override // org.apache.poi.hssf.record.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        throw new NotImplementedException(this._functionName);
    }

    public String getFunctionName() {
        return this._functionName;
    }

    public NotImplementedFunction(String str) {
        this._functionName = str;
    }
}
