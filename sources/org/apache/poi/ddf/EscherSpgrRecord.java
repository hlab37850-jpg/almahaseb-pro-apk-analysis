package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes2.dex */
public class EscherSpgrRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtSpgr";
    public static final short RECORD_ID = -4087;
    private int field_1_rectX1;
    private int field_2_rectY1;
    private int field_3_rectX2;
    private int field_4_rectY2;

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        this.field_1_rectX1 = LittleEndian.getInt(bArr, i + 8);
        this.field_2_rectY1 = LittleEndian.getInt(bArr, i + 12);
        this.field_3_rectX2 = LittleEndian.getInt(bArr, i + 16);
        this.field_4_rectY2 = LittleEndian.getInt(bArr, i + 20);
        int i2 = header - 16;
        if (i2 == 0) {
            return header + 8;
        }
        throw new RecordFormatException("Expected no remaining bytes but got " + i2);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Spgr";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    public int getRectX1() {
        return this.field_1_rectX1;
    }

    public int getRectX2() {
        return this.field_3_rectX2;
    }

    public int getRectY1() {
        return this.field_2_rectY1;
    }

    public int getRectY2() {
        return this.field_4_rectY2;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, 16);
        LittleEndian.putInt(bArr, i + 8, this.field_1_rectX1);
        LittleEndian.putInt(bArr, i + 12, this.field_2_rectY1);
        LittleEndian.putInt(bArr, i + 16, this.field_3_rectX2);
        LittleEndian.putInt(bArr, i + 20, this.field_4_rectY2);
        escherSerializationListener.afterRecordSerialize(getRecordSize() + i, getRecordId(), i + getRecordSize(), this);
        return 24;
    }

    public void setRectX1(int i) {
        this.field_1_rectX1 = i;
    }

    public void setRectX2(int i) {
        this.field_3_rectX2 = i;
    }

    public void setRectY1(int i) {
        this.field_2_rectY1 = i;
    }

    public void setRectY2(int i) {
        this.field_4_rectY2 = i;
    }

    public String toString() {
        return getClass().getName() + ":\n  RecordId: 0x" + HexDump.toHex(RECORD_ID) + "\n  Options: 0x" + HexDump.toHex(getOptions()) + "\n  RectX: " + this.field_1_rectX1 + "\n  RectY: " + this.field_2_rectY1 + "\n  RectWidth: " + this.field_3_rectX2 + "\n  RectHeight: " + this.field_4_rectY2 + '\n';
    }
}
