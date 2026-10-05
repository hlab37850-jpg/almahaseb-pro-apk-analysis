package org.apache.poi.ddf;

import java.io.ByteArrayOutputStream;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes2.dex */
public class EscherBitmapBlip extends EscherBlipRecord {
    private static final int HEADER_SIZE = 8;
    public static final short RECORD_ID_DIB = -4065;
    public static final short RECORD_ID_JPEG = -4067;
    public static final short RECORD_ID_PNG = -4066;
    private byte[] field_1_UID;
    private byte field_2_marker = -1;

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        byte[] bArr2 = new byte[16];
        this.field_1_UID = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, 16);
        this.field_2_marker = bArr[i + 24];
        byte[] bArr3 = new byte[header - 17];
        this.field_pictureData = bArr3;
        System.arraycopy(bArr, i + 25, bArr3, 0, bArr3.length);
        return header + 8;
    }

    public byte getMarker() {
        return this.field_2_marker;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.field_pictureData.length + 25;
    }

    public byte[] getUID() {
        return this.field_1_UID;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, getRecordSize() - 8);
        System.arraycopy(this.field_1_UID, 0, bArr, i + 8, 16);
        bArr[i + 24] = this.field_2_marker;
        byte[] bArr2 = this.field_pictureData;
        System.arraycopy(bArr2, 0, bArr, i + 25, bArr2.length);
        escherSerializationListener.afterRecordSerialize(i + getRecordSize(), getRecordId(), getRecordSize(), this);
        return this.field_pictureData.length + 25;
    }

    public void setMarker(byte b) {
        this.field_2_marker = b;
    }

    public void setUID(byte[] bArr) {
        this.field_1_UID = bArr;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord
    public String toString() {
        String string;
        String property = System.getProperty("line.separator");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HexDump.dump(this.field_pictureData, 0L, byteArrayOutputStream, 0);
            string = byteArrayOutputStream.toString();
        } catch (Exception e) {
            string = e.toString();
        }
        return getClass().getName() + ":" + property + "  RecordId: 0x" + HexDump.toHex(getRecordId()) + property + "  Options: 0x" + HexDump.toHex(getOptions()) + property + "  UID: 0x" + HexDump.toHex(this.field_1_UID) + property + "  Marker: 0x" + HexDump.toHex(this.field_2_marker) + property + "  Extra Data:" + property + string;
    }
}
