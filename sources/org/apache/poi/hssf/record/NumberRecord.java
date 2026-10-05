package org.apache.poi.hssf.record;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class NumberRecord extends CellRecord {
    public static final short sid = 515;
    private double field_4_value;

    public NumberRecord() {
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public void appendValueText(StringBuilder sb) {
        sb.append("  .value= ");
        sb.append(NumberToTextConverter.toText(this.field_4_value));
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        NumberRecord numberRecord = new NumberRecord();
        copyBaseFields(numberRecord);
        numberRecord.field_4_value = this.field_4_value;
        return numberRecord;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public String getRecordName() {
        return "NUMBER";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 515;
    }

    public double getValue() {
        return this.field_4_value;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public void serializeValue(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeDouble(getValue());
    }

    public void setValue(double d) {
        this.field_4_value = d;
    }

    public NumberRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this.field_4_value = recordInputStream.readDouble();
    }
}
