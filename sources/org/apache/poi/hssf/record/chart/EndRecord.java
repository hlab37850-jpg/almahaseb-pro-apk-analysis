package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class EndRecord extends StandardRecord {
    public static final short sid = 4148;

    public EndRecord() {
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new EndRecord();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 0;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[END]\n");
        stringBuffer.append("[/END]\n");
        return stringBuffer.toString();
    }

    public EndRecord(RecordInputStream recordInputStream) {
    }
}
