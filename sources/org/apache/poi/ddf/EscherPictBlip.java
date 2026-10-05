package org.apache.poi.ddf;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: classes2.dex */
public final class EscherPictBlip extends EscherBlipRecord {
    private static final int HEADER_SIZE = 8;
    public static final short RECORD_ID_EMF = -4070;
    public static final short RECORD_ID_PICT = -4068;
    public static final short RECORD_ID_WMF = -4069;
    private static final POILogger log = POILogFactory.getLogger(EscherPictBlip.class);
    private byte[] field_1_UID;
    private int field_2_cb;
    private int field_3_rcBounds_x1;
    private int field_3_rcBounds_x2;
    private int field_3_rcBounds_y1;
    private int field_3_rcBounds_y2;
    private int field_4_ptSize_h;
    private int field_4_ptSize_w;
    private int field_5_cbSave;
    private byte field_6_fCompression;
    private byte field_7_fFilter;
    private byte[] raw_pictureData;

    private static byte[] inflatePictureData(byte[] bArr) {
        try {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[4096];
            while (true) {
                int i = inflaterInputStream.read(bArr2);
                if (i <= 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (IOException e) {
            log.log(POILogger.INFO, (Object) "Possibly corrupt compression or non-compressed data", (Throwable) e);
            return bArr;
        }
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        byte[] bArr2 = new byte[16];
        this.field_1_UID = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, 16);
        this.field_2_cb = LittleEndian.getInt(bArr, i + 24);
        this.field_3_rcBounds_x1 = LittleEndian.getInt(bArr, i + 28);
        this.field_3_rcBounds_y1 = LittleEndian.getInt(bArr, i + 32);
        this.field_3_rcBounds_x2 = LittleEndian.getInt(bArr, i + 36);
        this.field_3_rcBounds_y2 = LittleEndian.getInt(bArr, i + 40);
        this.field_4_ptSize_w = LittleEndian.getInt(bArr, i + 44);
        this.field_4_ptSize_h = LittleEndian.getInt(bArr, i + 48);
        int i2 = LittleEndian.getInt(bArr, i + 52);
        this.field_5_cbSave = i2;
        this.field_6_fCompression = bArr[i + 56];
        this.field_7_fFilter = bArr[i + 57];
        byte[] bArr3 = new byte[i2];
        this.raw_pictureData = bArr3;
        System.arraycopy(bArr, i + 58, bArr3, 0, i2);
        if (this.field_6_fCompression == 0) {
            this.field_pictureData = inflatePictureData(this.raw_pictureData);
        } else {
            this.field_pictureData = this.raw_pictureData;
        }
        return header + 8;
    }

    public Rectangle getBounds() {
        int i = this.field_3_rcBounds_x1;
        int i2 = this.field_3_rcBounds_y1;
        return new Rectangle(i, i2, this.field_3_rcBounds_x2 - i, this.field_3_rcBounds_y2 - i2);
    }

    public int getCompressedSize() {
        return this.field_5_cbSave;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.raw_pictureData.length + 58;
    }

    public Dimension getSizeEMU() {
        return new Dimension(this.field_4_ptSize_w, this.field_4_ptSize_h);
    }

    public byte[] getUID() {
        return this.field_1_UID;
    }

    public int getUncompressedSize() {
        return this.field_2_cb;
    }

    public boolean isCompressed() {
        return this.field_6_fCompression == 0;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, getRecordSize() - 8);
        System.arraycopy(this.field_1_UID, 0, bArr, i + 8, 16);
        LittleEndian.putInt(bArr, i + 24, this.field_2_cb);
        LittleEndian.putInt(bArr, i + 28, this.field_3_rcBounds_x1);
        LittleEndian.putInt(bArr, i + 32, this.field_3_rcBounds_y1);
        LittleEndian.putInt(bArr, i + 36, this.field_3_rcBounds_x2);
        LittleEndian.putInt(bArr, i + 40, this.field_3_rcBounds_y2);
        LittleEndian.putInt(bArr, i + 44, this.field_4_ptSize_w);
        LittleEndian.putInt(bArr, i + 48, this.field_4_ptSize_h);
        LittleEndian.putInt(bArr, i + 52, this.field_5_cbSave);
        bArr[i + 56] = this.field_6_fCompression;
        bArr[i + 57] = this.field_7_fFilter;
        byte[] bArr2 = this.raw_pictureData;
        System.arraycopy(bArr2, 0, bArr, i + 58, bArr2.length);
        escherSerializationListener.afterRecordSerialize(i + getRecordSize(), getRecordId(), getRecordSize(), this);
        return this.raw_pictureData.length + 25;
    }

    public void setBounds(Rectangle rectangle) {
        this.field_3_rcBounds_x1 = rectangle.x;
        this.field_3_rcBounds_y1 = rectangle.y;
        this.field_3_rcBounds_x2 = rectangle.x + rectangle.width;
        this.field_3_rcBounds_y2 = rectangle.y + rectangle.height;
    }

    public void setCompressed(boolean z) {
        this.field_6_fCompression = z ? (byte) 0 : (byte) -2;
    }

    public void setCompressedSize(int i) {
        this.field_5_cbSave = i;
    }

    public void setSizeEMU(Dimension dimension) {
        this.field_4_ptSize_w = dimension.width;
        this.field_4_ptSize_h = dimension.height;
    }

    public void setUID(byte[] bArr) {
        this.field_1_UID = bArr;
    }

    public void setUncompressedSize(int i) {
        this.field_2_cb = i;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord
    public String toString() {
        return EscherPictBlip.class.getName() + ":\n  RecordId: 0x" + HexDump.toHex(getRecordId()) + "\n  Options: 0x" + HexDump.toHex(getOptions()) + "\n  UID: 0x" + HexDump.toHex(this.field_1_UID) + "\n  Uncompressed Size: " + HexDump.toHex(this.field_2_cb) + "\n  Bounds: " + getBounds() + "\n  Size in EMU: " + getSizeEMU() + "\n  Compressed Size: " + HexDump.toHex(this.field_5_cbSave) + "\n  Compression: " + HexDump.toHex(this.field_6_fCompression) + "\n  Filter: " + HexDump.toHex(this.field_7_fFilter) + "\n  Extra Data:\n" + HexDump.toHex(this.field_pictureData, 32);
    }
}
