package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: classes4.dex */
public final class LabelRecord extends Record implements CellValueRecordInterface {
    public static final short sid = 516;
    private int field_1_row;
    private short field_2_column;
    private short field_3_xf_index;
    private short field_4_string_len;
    private byte field_5_unicode_flag;
    private String field_6_value;

    public LabelRecord() {
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        LabelRecord labelRecord = new LabelRecord();
        labelRecord.field_1_row = this.field_1_row;
        labelRecord.field_2_column = this.field_2_column;
        labelRecord.field_3_xf_index = this.field_3_xf_index;
        labelRecord.field_4_string_len = this.field_4_string_len;
        labelRecord.field_5_unicode_flag = this.field_5_unicode_flag;
        labelRecord.field_6_value = this.field_6_value;
        return labelRecord;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this.field_2_column;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 516;
    }

    public short getStringLength() {
        return this.field_4_string_len;
    }

    public String getValue() {
        return this.field_6_value;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this.field_3_xf_index;
    }

    public boolean isUnCompressedUnicode() {
        return this.field_5_unicode_flag == 1;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setColumn(short s) {
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setRow(int i) {
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setXFIndex(short s) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[LABEL]\n");
        stringBuffer.append("    .row       = ");
        stringBuffer.append(HexDump.shortToHex(getRow()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .column    = ");
        stringBuffer.append(HexDump.shortToHex(getColumn()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .xfindex   = ");
        stringBuffer.append(HexDump.shortToHex(getXFIndex()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .string_len= ");
        stringBuffer.append(HexDump.shortToHex(this.field_4_string_len));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .unicode_flag= ");
        stringBuffer.append(HexDump.byteToHex(this.field_5_unicode_flag));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .value       = ");
        stringBuffer.append(getValue());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/LABEL]\n");
        return stringBuffer.toString();
    }

    public LabelRecord(RecordInputStream recordInputStream) {
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_column = recordInputStream.readShort();
        this.field_3_xf_index = recordInputStream.readShort();
        this.field_4_string_len = recordInputStream.readShort();
        this.field_5_unicode_flag = recordInputStream.readByte();
        if (this.field_4_string_len <= 0) {
            this.field_6_value = "";
        } else if (isUnCompressedUnicode()) {
            this.field_6_value = recordInputStream.readUnicodeLEString(this.field_4_string_len);
        } else {
            this.field_6_value = recordInputStream.readCompressedUnicode(this.field_4_string_len);
        }
    }
}
