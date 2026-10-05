package org.apache.poi.hssf.record.formula;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class IntPtg extends ScalarConstantPtg {
    private static final int MAX_VALUE = 65535;
    private static final int MIN_VALUE = 0;
    public static final int SIZE = 3;
    public static final byte sid = 30;
    private final int field_1_value;

    public IntPtg(LittleEndianInput littleEndianInput) {
        this(littleEndianInput.readUShort());
    }

    public static boolean isInRange(int i) {
        return i >= 0 && i <= 65535;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public int getSize() {
        return 3;
    }

    public int getValue() {
        return this.field_1_value;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public String toFormulaString() {
        return String.valueOf(getValue());
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 30);
        littleEndianOutput.writeShort(getValue());
    }

    public IntPtg(int i) {
        if (isInRange(i)) {
            this.field_1_value = i;
            return;
        }
        throw new IllegalArgumentException("value is out of range: " + i);
    }
}
