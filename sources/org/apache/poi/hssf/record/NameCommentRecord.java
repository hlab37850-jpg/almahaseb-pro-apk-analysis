package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class NameCommentRecord extends StandardRecord {
    public static final short sid = 2196;
    private final short field_1_record_type;
    private final short field_2_frt_cell_ref_flag;
    private final long field_3_reserved;
    private String field_6_name_text;
    private String field_7_comment_text;

    public NameCommentRecord(String str, String str2) {
        this.field_1_record_type = (short) 0;
        this.field_2_frt_cell_ref_flag = (short) 0;
        this.field_3_reserved = 0L;
        this.field_6_name_text = str;
        this.field_7_comment_text = str2;
    }

    public String getCommentText() {
        return this.field_7_comment_text;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.field_6_name_text.length() + 18 + this.field_7_comment_text.length();
    }

    public String getNameText() {
        return this.field_6_name_text;
    }

    public short getRecordType() {
        return this.field_1_record_type;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int length = this.field_6_name_text.length();
        int length2 = this.field_7_comment_text.length();
        littleEndianOutput.writeShort(this.field_1_record_type);
        littleEndianOutput.writeShort(this.field_2_frt_cell_ref_flag);
        littleEndianOutput.writeLong(this.field_3_reserved);
        littleEndianOutput.writeShort(length);
        littleEndianOutput.writeShort(length2);
        littleEndianOutput.writeByte(0);
        littleEndianOutput.write(this.field_6_name_text.getBytes());
        littleEndianOutput.writeByte(0);
        littleEndianOutput.write(this.field_7_comment_text.getBytes());
    }

    public void setCommentText(String str) {
        this.field_7_comment_text = str;
    }

    public void setNameText(String str) {
        this.field_6_name_text = str;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[NAMECMT]\n");
        stringBuffer.append("    .record type            = ");
        stringBuffer.append(HexDump.shortToHex(this.field_1_record_type));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .frt cell ref flag      = ");
        stringBuffer.append(HexDump.byteToHex(this.field_2_frt_cell_ref_flag));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .reserved               = ");
        stringBuffer.append(this.field_3_reserved);
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .name length            = ");
        stringBuffer.append(this.field_6_name_text.length());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .comment length         = ");
        stringBuffer.append(this.field_7_comment_text.length());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .name                   = ");
        stringBuffer.append(this.field_6_name_text);
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .comment                = ");
        stringBuffer.append(this.field_7_comment_text);
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/NAMECMT]\n");
        return stringBuffer.toString();
    }

    public NameCommentRecord(RecordInputStream recordInputStream) {
        this.field_1_record_type = recordInputStream.readShort();
        this.field_2_frt_cell_ref_flag = recordInputStream.readShort();
        this.field_3_reserved = recordInputStream.readLong();
        short s = recordInputStream.readShort();
        short s2 = recordInputStream.readShort();
        recordInputStream.readByte();
        this.field_6_name_text = StringUtil.readCompressedUnicode(recordInputStream, s);
        recordInputStream.readByte();
        this.field_7_comment_text = StringUtil.readCompressedUnicode(recordInputStream, s2);
    }
}
