package org.apache.poi.util;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes4.dex */
public final class LittleEndianByteArrayInputStream implements LittleEndianInput {
    private final byte[] _buf;
    private final int _endIndex;
    private int _readIndex;

    public LittleEndianByteArrayInputStream(byte[] bArr, int i, int i2) {
        this._buf = bArr;
        this._readIndex = i;
        this._endIndex = i + i2;
    }

    private void checkPosition(int i) {
        if (i > this._endIndex - this._readIndex) {
            throw new RuntimeException("Buffer overrun");
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int available() {
        return this._endIndex - this._readIndex;
    }

    public int getReadIndex() {
        return this._readIndex;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkPosition(1);
        byte[] bArr = this._buf;
        int i = this._readIndex;
        this._readIndex = i + 1;
        return bArr[i];
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        checkPosition(i2);
        System.arraycopy(this._buf, this._readIndex, bArr, i, i2);
        this._readIndex += i2;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkPosition(4);
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        int i4 = bArr[i + 2] & UnsignedBytes.MAX_VALUE;
        int i5 = bArr[i + 3] & UnsignedBytes.MAX_VALUE;
        this._readIndex = i + 4;
        return (i5 << 24) + (i4 << 16) + (i3 << 8) + i2;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkPosition(8);
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

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        checkPosition(1);
        byte[] bArr = this._buf;
        int i = this._readIndex;
        this._readIndex = i + 1;
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkPosition(2);
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        this._readIndex = i + 2;
        return (i3 << 8) + i2;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    public LittleEndianByteArrayInputStream(byte[] bArr, int i) {
        this(bArr, i, bArr.length - i);
    }

    public LittleEndianByteArrayInputStream(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }
}
