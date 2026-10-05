package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes2.dex */
public final class EscherBSERecord extends EscherRecord {
    public static final byte BT_DIB = 7;
    public static final byte BT_EMF = 2;
    public static final byte BT_ERROR = 0;
    public static final byte BT_JPEG = 5;
    public static final byte BT_PICT = 4;
    public static final byte BT_PNG = 6;
    public static final byte BT_UNKNOWN = 1;
    public static final byte BT_WMF = 3;
    public static final String RECORD_DESCRIPTION = "MsofbtBSE";
    public static final short RECORD_ID = -4089;
    private byte[] _remainingData;
    private byte field_10_unused2;
    private byte field_11_unused3;
    private EscherBlipRecord field_12_blipRecord;
    private byte field_1_blipTypeWin32;
    private byte field_2_blipTypeMacOS;
    private byte[] field_3_uid;
    private short field_4_tag;
    private int field_5_size;
    private int field_6_ref;
    private int field_7_offset;
    private byte field_8_usage;
    private byte field_9_name;

    public static String getBlipType(byte b) {
        switch (b) {
            case 0:
                return " ERROR";
            case 1:
                return " UNKNOWN";
            case 2:
                return " EMF";
            case 3:
                return " WMF";
            case 4:
                return " PICT";
            case 5:
                return " JPEG";
            case 6:
                return " PNG";
            case 7:
                return " DIB";
            default:
                return b < 32 ? " NotKnown" : " Client";
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int iFillFields;
        int header = readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_blipTypeWin32 = bArr[i2];
        this.field_2_blipTypeMacOS = bArr[i + 9];
        byte[] bArr2 = new byte[16];
        this.field_3_uid = bArr2;
        System.arraycopy(bArr, i + 10, bArr2, 0, 16);
        this.field_4_tag = LittleEndian.getShort(bArr, i + 26);
        this.field_5_size = LittleEndian.getInt(bArr, i + 28);
        this.field_6_ref = LittleEndian.getInt(bArr, i + 32);
        this.field_7_offset = LittleEndian.getInt(bArr, i + 36);
        this.field_8_usage = bArr[i + 40];
        this.field_9_name = bArr[i + 41];
        this.field_10_unused2 = bArr[i + 42];
        this.field_11_unused3 = bArr[i + 43];
        int i3 = header - 36;
        if (i3 > 0) {
            int i4 = i + 44;
            EscherBlipRecord escherBlipRecord = (EscherBlipRecord) escherRecordFactory.createRecord(bArr, i4);
            this.field_12_blipRecord = escherBlipRecord;
            iFillFields = escherBlipRecord.fillFields(bArr, i4, escherRecordFactory);
        } else {
            iFillFields = 0;
        }
        int i5 = i2 + iFillFields + 36;
        int i6 = i3 - iFillFields;
        byte[] bArr3 = new byte[i6];
        this._remainingData = bArr3;
        System.arraycopy(bArr, i5, bArr3, 0, i6);
        int i7 = i6 + 44;
        EscherBlipRecord escherBlipRecord2 = this.field_12_blipRecord;
        return i7 + (escherBlipRecord2 != null ? escherBlipRecord2.getRecordSize() : 0);
    }

    public EscherBlipRecord getBlipRecord() {
        return this.field_12_blipRecord;
    }

    public byte getBlipTypeMacOS() {
        return this.field_2_blipTypeMacOS;
    }

    public byte getBlipTypeWin32() {
        return this.field_1_blipTypeWin32;
    }

    public byte getName() {
        return this.field_9_name;
    }

    public int getOffset() {
        return this.field_7_offset;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "BSE";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        EscherBlipRecord escherBlipRecord = this.field_12_blipRecord;
        int recordSize = escherBlipRecord != null ? escherBlipRecord.getRecordSize() : 0;
        byte[] bArr = this._remainingData;
        return recordSize + 44 + (bArr != null ? bArr.length : 0);
    }

    public int getRef() {
        return this.field_6_ref;
    }

    public byte[] getRemainingData() {
        return this._remainingData;
    }

    public int getSize() {
        return this.field_5_size;
    }

    public short getTag() {
        return this.field_4_tag;
    }

    public byte[] getUid() {
        return this.field_3_uid;
    }

    public byte getUnused2() {
        return this.field_10_unused2;
    }

    public byte getUnused3() {
        return this.field_11_unused3;
    }

    public byte getUsage() {
        return this.field_8_usage;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        if (this._remainingData == null) {
            this._remainingData = new byte[0];
        }
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        if (this._remainingData == null) {
            this._remainingData = new byte[0];
        }
        EscherBlipRecord escherBlipRecord = this.field_12_blipRecord;
        LittleEndian.putInt(bArr, i + 4, this._remainingData.length + 36 + (escherBlipRecord == null ? 0 : escherBlipRecord.getRecordSize()));
        bArr[i + 8] = this.field_1_blipTypeWin32;
        bArr[i + 9] = this.field_2_blipTypeMacOS;
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[i + 10 + i2] = this.field_3_uid[i2];
        }
        LittleEndian.putShort(bArr, i + 26, this.field_4_tag);
        LittleEndian.putInt(bArr, i + 28, this.field_5_size);
        LittleEndian.putInt(bArr, i + 32, this.field_6_ref);
        LittleEndian.putInt(bArr, i + 36, this.field_7_offset);
        bArr[i + 40] = this.field_8_usage;
        bArr[i + 41] = this.field_9_name;
        bArr[i + 42] = this.field_10_unused2;
        bArr[i + 43] = this.field_11_unused3;
        EscherBlipRecord escherBlipRecord2 = this.field_12_blipRecord;
        int iSerialize = escherBlipRecord2 != null ? escherBlipRecord2.serialize(i + 44, bArr, new NullEscherSerializationListener()) : 0;
        if (this._remainingData == null) {
            this._remainingData = new byte[0];
        }
        byte[] bArr2 = this._remainingData;
        System.arraycopy(bArr2, 0, bArr, i + 44 + iSerialize, bArr2.length);
        int length = i + 44 + this._remainingData.length + iSerialize;
        int i3 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i3, this);
        return i3;
    }

    public void setBlipRecord(EscherBlipRecord escherBlipRecord) {
        this.field_12_blipRecord = escherBlipRecord;
    }

    public void setBlipTypeMacOS(byte b) {
        this.field_2_blipTypeMacOS = b;
    }

    public void setBlipTypeWin32(byte b) {
        this.field_1_blipTypeWin32 = b;
    }

    public void setName(byte b) {
        this.field_9_name = b;
    }

    public void setOffset(int i) {
        this.field_7_offset = i;
    }

    public void setRef(int i) {
        this.field_6_ref = i;
    }

    public void setRemainingData(byte[] bArr) {
        this._remainingData = bArr;
    }

    public void setSize(int i) {
        this.field_5_size = i;
    }

    public void setTag(short s) {
        this.field_4_tag = s;
    }

    public void setUid(byte[] bArr) {
        this.field_3_uid = bArr;
    }

    public void setUnused2(byte b) {
        this.field_10_unused2 = b;
    }

    public void setUnused3(byte b) {
        this.field_11_unused3 = b;
    }

    public void setUsage(byte b) {
        this.field_8_usage = b;
    }

    public String toString() {
        byte[] bArr = this._remainingData;
        String hex = bArr == null ? null : HexDump.toHex(bArr, 32);
        StringBuilder sb = new StringBuilder();
        sb.append(EscherBSERecord.class.getName());
        sb.append(":");
        sb.append('\n');
        sb.append("  RecordId: 0x");
        sb.append(HexDump.toHex(RECORD_ID));
        sb.append('\n');
        sb.append("  Options: 0x");
        sb.append(HexDump.toHex(getOptions()));
        sb.append('\n');
        sb.append("  BlipTypeWin32: ");
        sb.append((int) this.field_1_blipTypeWin32);
        sb.append('\n');
        sb.append("  BlipTypeMacOS: ");
        sb.append((int) this.field_2_blipTypeMacOS);
        sb.append('\n');
        sb.append("  SUID: ");
        byte[] bArr2 = this.field_3_uid;
        sb.append(bArr2 == null ? "" : HexDump.toHex(bArr2));
        sb.append('\n');
        sb.append("  Tag: ");
        sb.append((int) this.field_4_tag);
        sb.append('\n');
        sb.append("  Size: ");
        sb.append(this.field_5_size);
        sb.append('\n');
        sb.append("  Ref: ");
        sb.append(this.field_6_ref);
        sb.append('\n');
        sb.append("  Offset: ");
        sb.append(this.field_7_offset);
        sb.append('\n');
        sb.append("  Usage: ");
        sb.append((int) this.field_8_usage);
        sb.append('\n');
        sb.append("  Name: ");
        sb.append((int) this.field_9_name);
        sb.append('\n');
        sb.append("  Unused2: ");
        sb.append((int) this.field_10_unused2);
        sb.append('\n');
        sb.append("  Unused3: ");
        sb.append((int) this.field_11_unused3);
        sb.append('\n');
        sb.append("  blipRecord: ");
        sb.append(this.field_12_blipRecord);
        sb.append('\n');
        sb.append("  Extra Data:");
        sb.append('\n');
        sb.append(hex);
        return sb.toString();
    }
}
