package org.apache.poi.hssf.record;

import com.itextpdf.text.pdf.PdfBoolean;
import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSharingRecord extends StandardRecord {
    public static final short sid = 91;
    private short field_1_readonly;
    private short field_2_password;
    private byte field_3_username_unicode_options;
    private String field_3_username_value;

    public FileSharingRecord() {
    }

    public static short hashPassword(String str) {
        byte[] bytes = str.getBytes();
        int length = 0;
        if (bytes.length > 0) {
            int length2 = bytes.length;
            while (true) {
                int i = length2 - 1;
                if (length2 <= 0) {
                    break;
                }
                length = bytes[i] ^ (((length >> 14) & 1) | ((length << 1) & 32767));
                length2 = i;
            }
            length = (bytes.length ^ (((length >> 14) & 1) | ((length << 1) & 32767))) ^ 52811;
        }
        return (short) length;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        FileSharingRecord fileSharingRecord = new FileSharingRecord();
        fileSharingRecord.setReadOnly(this.field_1_readonly);
        fileSharingRecord.setPassword(this.field_2_password);
        fileSharingRecord.setUsername(this.field_3_username_value);
        return fileSharingRecord;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int length = this.field_3_username_value.length();
        if (length < 1) {
            return 6;
        }
        return length + 7;
    }

    public short getPassword() {
        return this.field_2_password;
    }

    public short getReadOnly() {
        return this.field_1_readonly;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 91;
    }

    public String getUsername() {
        return this.field_3_username_value;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getReadOnly());
        littleEndianOutput.writeShort(getPassword());
        littleEndianOutput.writeShort(this.field_3_username_value.length());
        if (this.field_3_username_value.length() > 0) {
            littleEndianOutput.writeByte(this.field_3_username_unicode_options);
            StringUtil.putCompressedUnicode(getUsername(), littleEndianOutput);
        }
    }

    public void setPassword(short s) {
        this.field_2_password = s;
    }

    public void setReadOnly(short s) {
        this.field_1_readonly = s;
    }

    public void setUsername(String str) {
        this.field_3_username_value = str;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[FILESHARING]\n");
        stringBuffer.append("    .readonly       = ");
        stringBuffer.append(getReadOnly() == 1 ? PdfBoolean.TRUE : PdfBoolean.FALSE);
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .password       = ");
        stringBuffer.append(Integer.toHexString(getPassword()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .username       = ");
        stringBuffer.append(getUsername());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/FILESHARING]\n");
        return stringBuffer.toString();
    }

    public FileSharingRecord(RecordInputStream recordInputStream) {
        this.field_1_readonly = recordInputStream.readShort();
        this.field_2_password = recordInputStream.readShort();
        short s = recordInputStream.readShort();
        if (s <= 0) {
            this.field_3_username_value = "";
        } else {
            this.field_3_username_unicode_options = recordInputStream.readByte();
            this.field_3_username_value = recordInputStream.readCompressedUnicode(s);
        }
    }
}
