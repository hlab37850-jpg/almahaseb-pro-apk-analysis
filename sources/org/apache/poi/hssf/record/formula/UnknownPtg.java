package org.apache.poi.hssf.record.formula;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public class UnknownPtg extends Ptg {
    private final int _sid;
    private short size = 1;

    public UnknownPtg(int i) {
        this._sid = i;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public int getSize() {
        return this.size;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public boolean isBaseToken() {
        return true;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public String toFormulaString() {
        return "UNKNOWN";
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this._sid);
    }
}
