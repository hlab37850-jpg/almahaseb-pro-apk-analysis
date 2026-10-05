package org.apache.poi.hssf.record.formula.eval;

import org.apache.poi.hssf.record.formula.NameXPtg;

/* JADX INFO: loaded from: classes4.dex */
public final class NameXEval implements ValueEval {
    private final NameXPtg _ptg;

    public NameXEval(NameXPtg nameXPtg) {
        this._ptg = nameXPtg;
    }

    public NameXPtg getPtg() {
        return this._ptg;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(NameXEval.class.getName());
        stringBuffer.append(" [");
        stringBuffer.append(this._ptg.getSheetRefIndex());
        stringBuffer.append(", ");
        stringBuffer.append(this._ptg.getNameIndex());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
