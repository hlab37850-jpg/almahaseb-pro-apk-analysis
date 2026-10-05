package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class MMSRecord extends StandardRecord {
    public static final short sid = 193;
    private byte field_1_addMenuCount;
    private byte field_2_delMenuCount;

    public MMSRecord() {
    }

    public byte getAddMenuCount() {
        return this.field_1_addMenuCount;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public byte getDelMenuCount() {
        return this.field_2_delMenuCount;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 193;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getAddMenuCount());
        littleEndianOutput.writeByte(getDelMenuCount());
    }

    public void setAddMenuCount(byte b) {
        this.field_1_addMenuCount = b;
    }

    public void setDelMenuCount(byte b) {
        this.field_2_delMenuCount = b;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[MMS]\n");
        stringBuffer.append("    .addMenu        = ");
        stringBuffer.append(Integer.toHexString(getAddMenuCount()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .delMenu        = ");
        stringBuffer.append(Integer.toHexString(getDelMenuCount()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/MMS]\n");
        return stringBuffer.toString();
    }

    public MMSRecord(RecordInputStream recordInputStream) {
        if (recordInputStream.remaining() == 0) {
            return;
        }
        this.field_1_addMenuCount = recordInputStream.readByte();
        this.field_2_delMenuCount = recordInputStream.readByte();
    }
}
