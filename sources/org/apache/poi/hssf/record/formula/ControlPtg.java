package org.apache.poi.hssf.record.formula;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ControlPtg extends Ptg {
    @Override // org.apache.poi.hssf.record.formula.Ptg
    public final byte getDefaultOperandClass() {
        throw new IllegalStateException("Control tokens are not classified");
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public boolean isBaseToken() {
        return true;
    }
}
