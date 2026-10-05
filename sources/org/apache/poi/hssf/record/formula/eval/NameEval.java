package org.apache.poi.hssf.record.formula.eval;

/* JADX INFO: loaded from: classes4.dex */
public final class NameEval implements ValueEval {
    private final String _functionName;

    public NameEval(String str) {
        this._functionName = str;
    }

    public String getFunctionName() {
        return this._functionName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(NameEval.class.getName());
        stringBuffer.append(" [");
        stringBuffer.append(this._functionName);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
