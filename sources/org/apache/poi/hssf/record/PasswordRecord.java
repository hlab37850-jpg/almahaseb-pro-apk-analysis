package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class PasswordRecord extends StandardRecord {
    public static final short sid = 19;
    private int field_1_password;

    public PasswordRecord(int i) {
        this.field_1_password = i;
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
        return new PasswordRecord(this.field_1_password);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public int getPassword() {
        return this.field_1_password;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 19;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_password);
    }

    public void setPassword(int i) {
        this.field_1_password = i;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[PASSWORD]\n");
        stringBuffer.append("    .password = ");
        stringBuffer.append(HexDump.shortToHex(this.field_1_password));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/PASSWORD]\n");
        return stringBuffer.toString();
    }

    public PasswordRecord(RecordInputStream recordInputStream) {
        this.field_1_password = recordInputStream.readShort();
    }
}
