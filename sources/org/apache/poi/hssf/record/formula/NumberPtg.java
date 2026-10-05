package org.apache.poi.hssf.record.formula;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class NumberPtg extends ScalarConstantPtg {
    public static final int SIZE = 9;
    public static final byte sid = 31;
    private final double field_1_value;

    public NumberPtg(LittleEndianInput littleEndianInput) {
        this(littleEndianInput.readDouble());
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public int getSize() {
        return 9;
    }

    public double getValue() {
        return this.field_1_value;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public String toFormulaString() {
        return NumberToTextConverter.toText(this.field_1_value);
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 31);
        littleEndianOutput.writeDouble(getValue());
    }

    public NumberPtg(String str) {
        this(Double.parseDouble(str));
    }

    public NumberPtg(double d) {
        this.field_1_value = d;
    }
}
