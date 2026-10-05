package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class NoteStructureSubRecord extends SubRecord {
    private static final int ENCODED_SIZE = 22;
    public static final short sid = 13;
    private byte[] reserved;

    public NoteStructureSubRecord() {
        this.reserved = new byte[22];
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public Object clone() {
        NoteStructureSubRecord noteStructureSubRecord = new NoteStructureSubRecord();
        byte[] bArr = this.reserved;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        noteStructureSubRecord.reserved = bArr2;
        return noteStructureSubRecord;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        return this.reserved.length;
    }

    public short getSid() {
        return (short) 13;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(13);
        littleEndianOutput.writeShort(this.reserved.length);
        littleEndianOutput.write(this.reserved);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ftNts ]");
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("  size     = ");
        stringBuffer.append(getDataSize());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("  reserved = ");
        stringBuffer.append(HexDump.toHex(this.reserved));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/ftNts ]");
        stringBuffer.append(StringUtilities.LF);
        return stringBuffer.toString();
    }

    public NoteStructureSubRecord(LittleEndianInput littleEndianInput, int i) {
        if (i == 22) {
            byte[] bArr = new byte[i];
            littleEndianInput.readFully(bArr);
            this.reserved = bArr;
        } else {
            throw new RecordFormatException("Unexpected size (" + i + ")");
        }
    }
}
