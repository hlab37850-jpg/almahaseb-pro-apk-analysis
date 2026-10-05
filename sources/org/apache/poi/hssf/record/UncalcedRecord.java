package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class UncalcedRecord extends StandardRecord {
    public static final short sid = 94;

    public UncalcedRecord() {
    }

    public static int getStaticRecordSize() {
        return 6;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 94;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[UNCALCED]\n");
        stringBuffer.append("[/UNCALCED]\n");
        return stringBuffer.toString();
    }

    public UncalcedRecord(RecordInputStream recordInputStream) {
        recordInputStream.readShort();
    }
}
