package org.apache.poi.hssf.record.formula;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
abstract class Ref2DPtgBase extends RefPtgBase {
    private static final int SIZE = 5;

    public Ref2DPtgBase(int i, int i2, boolean z, boolean z2) {
        setRow(i);
        setColumn(i2);
        setRowRelative(z);
        setColRelative(z2);
    }

    public abstract byte getSid();

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public final int getSize() {
        return 5;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public final String toFormulaString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [");
        stringBuffer.append(formatReferenceAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getSid() + getPtgClass());
        writeCoordinates(littleEndianOutput);
    }

    public Ref2DPtgBase(LittleEndianInput littleEndianInput) {
        readCoordinates(littleEndianInput);
    }

    public Ref2DPtgBase(CellReference cellReference) {
        super(cellReference);
    }
}
