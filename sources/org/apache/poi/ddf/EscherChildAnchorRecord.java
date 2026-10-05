package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes2.dex */
public class EscherChildAnchorRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtChildAnchor";
    public static final short RECORD_ID = -4081;
    private int field_1_dx1;
    private int field_2_dy1;
    private int field_3_dx2;
    private int field_4_dy2;

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        readHeader(bArr, i);
        this.field_1_dx1 = LittleEndian.getInt(bArr, i + 8);
        this.field_2_dy1 = LittleEndian.getInt(bArr, i + 12);
        this.field_3_dx2 = LittleEndian.getInt(bArr, i + 16);
        this.field_4_dy2 = LittleEndian.getInt(bArr, i + 20);
        return 24;
    }

    public int getDx1() {
        return this.field_1_dx1;
    }

    public int getDx2() {
        return this.field_3_dx2;
    }

    public int getDy1() {
        return this.field_2_dy1;
    }

    public int getDy2() {
        return this.field_4_dy2;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "ChildAnchor";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, getRecordSize() - 8);
        LittleEndian.putInt(bArr, i + 8, this.field_1_dx1);
        LittleEndian.putInt(bArr, i + 12, this.field_2_dy1);
        LittleEndian.putInt(bArr, i + 16, this.field_3_dx2);
        LittleEndian.putInt(bArr, i + 20, this.field_4_dy2);
        int i2 = i + 24;
        int i3 = i2 - i;
        escherSerializationListener.afterRecordSerialize(i2, getRecordId(), i3, this);
        return i3;
    }

    public void setDx1(int i) {
        this.field_1_dx1 = i;
    }

    public void setDx2(int i) {
        this.field_3_dx2 = i;
    }

    public void setDy1(int i) {
        this.field_2_dy1 = i;
    }

    public void setDy2(int i) {
        this.field_4_dy2 = i;
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        return getClass().getName() + ":" + property + "  RecordId: 0x" + HexDump.toHex(RECORD_ID) + property + "  Options: 0x" + HexDump.toHex(getOptions()) + property + "  X1: " + this.field_1_dx1 + property + "  Y1: " + this.field_2_dy1 + property + "  X2: " + this.field_3_dx2 + property + "  Y2: " + this.field_4_dy2 + property;
    }
}
