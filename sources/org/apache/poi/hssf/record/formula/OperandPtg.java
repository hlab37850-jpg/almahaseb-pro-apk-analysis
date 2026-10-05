package org.apache.poi.hssf.record.formula;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OperandPtg extends Ptg implements Cloneable {
    public final OperandPtg copy() {
        try {
            return (OperandPtg) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public final boolean isBaseToken() {
        return false;
    }
}
