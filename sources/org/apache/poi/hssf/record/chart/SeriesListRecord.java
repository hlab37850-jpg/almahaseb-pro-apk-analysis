package org.apache.poi.hssf.record.chart;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class SeriesListRecord extends StandardRecord {
    public static final short sid = 4118;
    private short[] field_1_seriesNumbers;

    public SeriesListRecord(short[] sArr) {
        this.field_1_seriesNumbers = sArr;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new SeriesListRecord((short[]) this.field_1_seriesNumbers.clone());
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.field_1_seriesNumbers.length * 2) + 2;
    }

    public short[] getSeriesNumbers() {
        return this.field_1_seriesNumbers;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int length = this.field_1_seriesNumbers.length;
        littleEndianOutput.writeShort(length);
        for (int i = 0; i < length; i++) {
            littleEndianOutput.writeShort(this.field_1_seriesNumbers[i]);
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SERIESLIST]\n");
        stringBuffer.append("    .seriesNumbers= ");
        stringBuffer.append(" (");
        stringBuffer.append(getSeriesNumbers());
        stringBuffer.append(" )");
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/SERIESLIST]\n");
        return stringBuffer.toString();
    }

    public SeriesListRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        short[] sArr = new short[uShort];
        for (int i = 0; i < uShort; i++) {
            sArr[i] = recordInputStream.readShort();
        }
        this.field_1_seriesNumbers = sArr;
    }
}
