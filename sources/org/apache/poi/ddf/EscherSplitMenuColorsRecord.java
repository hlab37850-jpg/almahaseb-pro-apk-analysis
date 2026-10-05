package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes2.dex */
public class EscherSplitMenuColorsRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtSplitMenuColors";
    public static final short RECORD_ID = -3810;
    private int field_1_color1;
    private int field_2_color2;
    private int field_3_color3;
    private int field_4_color4;

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        this.field_1_color1 = LittleEndian.getInt(bArr, i + 8);
        this.field_2_color2 = LittleEndian.getInt(bArr, i + 12);
        this.field_3_color3 = LittleEndian.getInt(bArr, i + 16);
        this.field_4_color4 = LittleEndian.getInt(bArr, i + 20);
        int i2 = header - 16;
        if (i2 == 0) {
            return header + 8;
        }
        throw new RecordFormatException("Expecting no remaining data but got " + i2 + " byte(s).");
    }

    public int getColor1() {
        return this.field_1_color1;
    }

    public int getColor2() {
        return this.field_2_color2;
    }

    public int getColor3() {
        return this.field_3_color3;
    }

    public int getColor4() {
        return this.field_4_color4;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "SplitMenuColors";
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
        LittleEndian.putInt(bArr, i + 8, this.field_1_color1);
        LittleEndian.putInt(bArr, i + 12, this.field_2_color2);
        LittleEndian.putInt(bArr, i + 16, this.field_3_color3);
        LittleEndian.putInt(bArr, i + 20, this.field_4_color4);
        int i2 = i + 24;
        escherSerializationListener.afterRecordSerialize(i2, getRecordId(), i2 - i, this);
        return getRecordSize();
    }

    public void setColor1(int i) {
        this.field_1_color1 = i;
    }

    public void setColor2(int i) {
        this.field_2_color2 = i;
    }

    public void setColor3(int i) {
        this.field_3_color3 = i;
    }

    public void setColor4(int i) {
        this.field_4_color4 = i;
    }

    public String toString() {
        return getClass().getName() + ":\n  RecordId: 0x" + HexDump.toHex(RECORD_ID) + "\n  Options: 0x" + HexDump.toHex(getOptions()) + "\n  Color1: 0x" + HexDump.toHex(this.field_1_color1) + "\n  Color2: 0x" + HexDump.toHex(this.field_2_color2) + "\n  Color3: 0x" + HexDump.toHex(this.field_3_color3) + "\n  Color4: 0x" + HexDump.toHex(this.field_4_color4) + "\n";
    }
}
