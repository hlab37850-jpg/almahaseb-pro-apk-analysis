package org.apache.poi.poifs.storage;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes4.dex */
public final class DataInputBlock {
    private final byte[] _buf;
    private int _maxIndex;
    private int _readIndex;

    public DataInputBlock(byte[] bArr, int i) {
        this._buf = bArr;
        this._readIndex = i;
        this._maxIndex = bArr.length;
    }

    private void readSpanning(DataInputBlock dataInputBlock, int i, byte[] bArr) {
        System.arraycopy(dataInputBlock._buf, dataInputBlock._readIndex, bArr, 0, i);
        int length = bArr.length - i;
        System.arraycopy(this._buf, 0, bArr, i, length);
        this._readIndex = length;
    }

    public int available() {
        return this._maxIndex - this._readIndex;
    }

    public void readFully(byte[] bArr, int i, int i2) {
        System.arraycopy(this._buf, this._readIndex, bArr, i, i2);
        this._readIndex += i2;
    }

    public int readIntLE() {
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        int i4 = bArr[i + 2] & UnsignedBytes.MAX_VALUE;
        int i5 = bArr[i + 3] & UnsignedBytes.MAX_VALUE;
        this._readIndex = i + 4;
        return (i5 << 24) + (i4 << 16) + (i3 << 8) + i2;
    }

    public long readLongLE() {
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        int i4 = bArr[i + 2] & UnsignedBytes.MAX_VALUE;
        int i5 = bArr[i + 3] & UnsignedBytes.MAX_VALUE;
        int i6 = bArr[i + 4] & UnsignedBytes.MAX_VALUE;
        int i7 = bArr[i + 5] & UnsignedBytes.MAX_VALUE;
        int i8 = bArr[i + 6] & UnsignedBytes.MAX_VALUE;
        int i9 = bArr[i + 7] & UnsignedBytes.MAX_VALUE;
        this._readIndex = i + 8;
        return (((long) i9) << 56) + (((long) i8) << 48) + (((long) i7) << 40) + (((long) i6) << 32) + (((long) i5) << 24) + ((long) (i4 << 16)) + ((long) (i3 << 8)) + ((long) i2);
    }

    public int readUByte() {
        byte[] bArr = this._buf;
        int i = this._readIndex;
        this._readIndex = i + 1;
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }

    public int readUShortLE() {
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        this._readIndex = i + 2;
        return (i3 << 8) + i2;
    }

    public int readUShortLE(DataInputBlock dataInputBlock) {
        byte[] bArr = dataInputBlock._buf;
        int i = bArr[bArr.length - 1] & UnsignedBytes.MAX_VALUE;
        byte[] bArr2 = this._buf;
        int i2 = this._readIndex;
        this._readIndex = i2 + 1;
        return ((bArr2[i2] & UnsignedBytes.MAX_VALUE) << 8) + i;
    }

    public int readIntLE(DataInputBlock dataInputBlock, int i) {
        byte[] bArr = new byte[4];
        readSpanning(dataInputBlock, i, bArr);
        int i2 = bArr[0] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[1] & UnsignedBytes.MAX_VALUE;
        return ((bArr[3] & UnsignedBytes.MAX_VALUE) << 24) + ((bArr[2] & UnsignedBytes.MAX_VALUE) << 16) + (i3 << 8) + i2;
    }

    public long readLongLE(DataInputBlock dataInputBlock, int i) {
        byte[] bArr = new byte[8];
        readSpanning(dataInputBlock, i, bArr);
        int i2 = bArr[0] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[1] & UnsignedBytes.MAX_VALUE;
        int i4 = bArr[2] & UnsignedBytes.MAX_VALUE;
        int i5 = bArr[3] & UnsignedBytes.MAX_VALUE;
        int i6 = bArr[4] & UnsignedBytes.MAX_VALUE;
        int i7 = bArr[5] & UnsignedBytes.MAX_VALUE;
        return (((long) (bArr[7] & UnsignedBytes.MAX_VALUE)) << 56) + (((long) (bArr[6] & UnsignedBytes.MAX_VALUE)) << 48) + (((long) i7) << 40) + (((long) i6) << 32) + (((long) i5) << 24) + ((long) (i4 << 16)) + ((long) (i3 << 8)) + ((long) i2);
    }
}
