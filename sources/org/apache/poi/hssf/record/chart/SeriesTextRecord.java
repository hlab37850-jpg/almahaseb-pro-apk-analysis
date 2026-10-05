package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class SeriesTextRecord extends StandardRecord {
    private static final int MAX_LEN = 255;
    public static final short sid = 4109;
    private int field_1_id;
    private String field_4_text;
    private boolean is16bit;

    public SeriesTextRecord() {
        this.field_4_text = "";
        this.is16bit = false;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SeriesTextRecord seriesTextRecord = new SeriesTextRecord();
        seriesTextRecord.field_1_id = this.field_1_id;
        seriesTextRecord.is16bit = this.is16bit;
        seriesTextRecord.field_4_text = this.field_4_text;
        return seriesTextRecord;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.field_4_text.length() * (this.is16bit ? 2 : 1)) + 4;
    }

    public int getId() {
        return this.field_1_id;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public String getText() {
        return this.field_4_text;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_id);
        littleEndianOutput.writeByte(this.field_4_text.length());
        if (this.is16bit) {
            littleEndianOutput.writeByte(1);
            StringUtil.putUnicodeLE(this.field_4_text, littleEndianOutput);
        } else {
            littleEndianOutput.writeByte(0);
            StringUtil.putCompressedUnicode(this.field_4_text, littleEndianOutput);
        }
    }

    public void setId(int i) {
        this.field_1_id = i;
    }

    public void setText(String str) {
        if (str.length() <= 255) {
            this.field_4_text = str;
            this.is16bit = StringUtil.hasMultibyte(str);
            return;
        }
        throw new IllegalArgumentException("Text is too long (" + str.length() + ">255)");
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SERIESTEXT]\n");
        stringBuffer.append("  .id     =");
        stringBuffer.append(HexDump.shortToHex(getId()));
        stringBuffer.append('\n');
        stringBuffer.append("  .textLen=");
        stringBuffer.append(this.field_4_text.length());
        stringBuffer.append('\n');
        stringBuffer.append("  .is16bit=");
        stringBuffer.append(this.is16bit);
        stringBuffer.append('\n');
        stringBuffer.append("  .text   =");
        stringBuffer.append(" (");
        stringBuffer.append(getText());
        stringBuffer.append(" )");
        stringBuffer.append('\n');
        stringBuffer.append("[/SERIESTEXT]\n");
        return stringBuffer.toString();
    }

    public SeriesTextRecord(RecordInputStream recordInputStream) {
        this.field_1_id = recordInputStream.readUShort();
        int uByte = recordInputStream.readUByte();
        boolean z = (recordInputStream.readUByte() & 1) != 0;
        this.is16bit = z;
        if (z) {
            this.field_4_text = recordInputStream.readUnicodeLEString(uByte);
        } else {
            this.field_4_text = recordInputStream.readCompressedUnicode(uByte);
        }
    }
}
