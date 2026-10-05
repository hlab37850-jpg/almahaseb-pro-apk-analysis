package org.apache.poi.ddf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes2.dex */
public class EscherBlipWMFRecord extends EscherBlipRecord {
    private static final int HEADER_SIZE = 8;
    public static final String RECORD_DESCRIPTION = "msofbtBlip";
    private byte field_10_compressionFlag;
    private byte field_11_filter;
    private byte[] field_12_data;
    private byte[] field_1_secondaryUID;
    private int field_2_cacheOfSize;
    private int field_3_boundaryTop;
    private int field_4_boundaryLeft;
    private int field_5_boundaryWidth;
    private int field_6_boundaryHeight;
    private int field_7_width;
    private int field_8_height;
    private int field_9_cacheOfSavedSize;

    public static byte[] compress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        for (byte b : bArr) {
            try {
                deflaterOutputStream.write(b);
            } catch (IOException e) {
                throw new RecordFormatException(e.toString());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decompress(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i + 50, bArr2, 0, i2);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr2));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i3 = inflaterInputStream.read();
                if (i3 == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(i3);
            } catch (IOException e) {
                throw new RecordFormatException(e.toString());
            }
        }
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        byte[] bArr2 = new byte[16];
        this.field_1_secondaryUID = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, 16);
        this.field_2_cacheOfSize = LittleEndian.getInt(bArr, i + 24);
        this.field_3_boundaryTop = LittleEndian.getInt(bArr, i + 28);
        this.field_4_boundaryLeft = LittleEndian.getInt(bArr, i + 32);
        this.field_5_boundaryWidth = LittleEndian.getInt(bArr, i + 36);
        this.field_6_boundaryHeight = LittleEndian.getInt(bArr, i + 40);
        this.field_7_width = LittleEndian.getInt(bArr, i + 44);
        this.field_8_height = LittleEndian.getInt(bArr, i + 48);
        this.field_9_cacheOfSavedSize = LittleEndian.getInt(bArr, i + 52);
        this.field_10_compressionFlag = bArr[i + 56];
        this.field_11_filter = bArr[i + 57];
        int i2 = header - 50;
        byte[] bArr3 = new byte[i2];
        this.field_12_data = bArr3;
        System.arraycopy(bArr, i + 58, bArr3, 0, i2);
        return header + 8;
    }

    public int getBoundaryHeight() {
        return this.field_6_boundaryHeight;
    }

    public int getBoundaryLeft() {
        return this.field_4_boundaryLeft;
    }

    public int getBoundaryTop() {
        return this.field_3_boundaryTop;
    }

    public int getBoundaryWidth() {
        return this.field_5_boundaryWidth;
    }

    public int getCacheOfSavedSize() {
        return this.field_9_cacheOfSavedSize;
    }

    public int getCacheOfSize() {
        return this.field_2_cacheOfSize;
    }

    public byte getCompressionFlag() {
        return this.field_10_compressionFlag;
    }

    public byte[] getData() {
        return this.field_12_data;
    }

    public byte getFilter() {
        return this.field_11_filter;
    }

    public int getHeight() {
        return this.field_8_height;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Blip";
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.field_12_data.length + 58;
    }

    public byte[] getSecondaryUID() {
        return this.field_1_secondaryUID;
    }

    public int getWidth() {
        return this.field_7_width;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, this.field_12_data.length + 36);
        System.arraycopy(this.field_1_secondaryUID, 0, bArr, i + 8, 16);
        LittleEndian.putInt(bArr, i + 24, this.field_2_cacheOfSize);
        LittleEndian.putInt(bArr, i + 28, this.field_3_boundaryTop);
        LittleEndian.putInt(bArr, i + 32, this.field_4_boundaryLeft);
        LittleEndian.putInt(bArr, i + 36, this.field_5_boundaryWidth);
        LittleEndian.putInt(bArr, i + 40, this.field_6_boundaryHeight);
        LittleEndian.putInt(bArr, i + 44, this.field_7_width);
        LittleEndian.putInt(bArr, i + 48, this.field_8_height);
        LittleEndian.putInt(bArr, i + 52, this.field_9_cacheOfSavedSize);
        bArr[i + 56] = this.field_10_compressionFlag;
        int i2 = i + 58;
        bArr[i + 57] = this.field_11_filter;
        byte[] bArr2 = this.field_12_data;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        int length = i2 + this.field_12_data.length;
        int i3 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i3, this);
        return i3;
    }

    public void setBoundaryHeight(int i) {
        this.field_6_boundaryHeight = i;
    }

    public void setBoundaryLeft(int i) {
        this.field_4_boundaryLeft = i;
    }

    public void setBoundaryTop(int i) {
        this.field_3_boundaryTop = i;
    }

    public void setBoundaryWidth(int i) {
        this.field_5_boundaryWidth = i;
    }

    public void setCacheOfSavedSize(int i) {
        this.field_9_cacheOfSavedSize = i;
    }

    public void setCacheOfSize(int i) {
        this.field_2_cacheOfSize = i;
    }

    public void setCompressionFlag(byte b) {
        this.field_10_compressionFlag = b;
    }

    public void setData(byte[] bArr) {
        this.field_12_data = bArr;
    }

    public void setFilter(byte b) {
        this.field_11_filter = b;
    }

    public void setHeight(int i) {
        this.field_8_height = i;
    }

    public void setSecondaryUID(byte[] bArr) {
        this.field_1_secondaryUID = bArr;
    }

    public void setWidth(int i) {
        this.field_7_width = i;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord
    public String toString() {
        String string;
        String property = System.getProperty("line.separator");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HexDump.dump(this.field_12_data, 0L, byteArrayOutputStream, 0);
            string = byteArrayOutputStream.toString();
        } catch (Exception e) {
            string = e.toString();
        }
        return getClass().getName() + ":" + property + "  RecordId: 0x" + HexDump.toHex(getRecordId()) + property + "  Options: 0x" + HexDump.toHex(getOptions()) + property + "  Secondary UID: " + HexDump.toHex(this.field_1_secondaryUID) + property + "  CacheOfSize: " + this.field_2_cacheOfSize + property + "  BoundaryTop: " + this.field_3_boundaryTop + property + "  BoundaryLeft: " + this.field_4_boundaryLeft + property + "  BoundaryWidth: " + this.field_5_boundaryWidth + property + "  BoundaryHeight: " + this.field_6_boundaryHeight + property + "  X: " + this.field_7_width + property + "  Y: " + this.field_8_height + property + "  CacheOfSavedSize: " + this.field_9_cacheOfSavedSize + property + "  CompressionFlag: " + ((int) this.field_10_compressionFlag) + property + "  Filter: " + ((int) this.field_11_filter) + property + "  Data:" + property + string;
    }
}
