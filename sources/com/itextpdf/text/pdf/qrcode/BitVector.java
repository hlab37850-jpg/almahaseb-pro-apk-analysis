package com.itextpdf.text.pdf.qrcode;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes3.dex */
public final class BitVector {
    private static final int DEFAULT_SIZE_IN_BYTES = 32;
    private int sizeInBits = 0;
    private byte[] array = new byte[32];

    private void appendByte(int i) {
        int i2 = this.sizeInBits >> 3;
        byte[] bArr = this.array;
        if (i2 == bArr.length) {
            byte[] bArr2 = new byte[bArr.length << 1];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.array = bArr2;
        }
        byte[] bArr3 = this.array;
        int i3 = this.sizeInBits;
        bArr3[i3 >> 3] = (byte) i;
        this.sizeInBits = i3 + 8;
    }

    public void appendBit(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Bad bit");
        }
        int i2 = this.sizeInBits & 7;
        if (i2 == 0) {
            appendByte(0);
            this.sizeInBits -= 8;
        }
        byte[] bArr = this.array;
        int i3 = this.sizeInBits;
        int i4 = i3 >> 3;
        bArr[i4] = (byte) ((i << (7 - i2)) | bArr[i4]);
        this.sizeInBits = i3 + 1;
    }

    public void appendBitVector(BitVector bitVector) {
        int size = bitVector.size();
        for (int i = 0; i < size; i++) {
            appendBit(bitVector.at(i));
        }
    }

    public void appendBits(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        while (i2 > 0) {
            if ((this.sizeInBits & 7) != 0 || i2 < 8) {
                appendBit((i >> (i2 - 1)) & 1);
                i2--;
            } else {
                appendByte((i >> (i2 - 8)) & 255);
                i2 -= 8;
            }
        }
    }

    public int at(int i) {
        if (i >= 0 && i < this.sizeInBits) {
            return ((this.array[i >> 3] & UnsignedBytes.MAX_VALUE) >> (7 - (i & 7))) & 1;
        }
        throw new IllegalArgumentException("Bad index: " + i);
    }

    public byte[] getArray() {
        return this.array;
    }

    public int size() {
        return this.sizeInBits;
    }

    public int sizeInBytes() {
        return (this.sizeInBits + 7) >> 3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.sizeInBits);
        for (int i = 0; i < this.sizeInBits; i++) {
            if (at(i) == 0) {
                stringBuffer.append('0');
            } else {
                if (at(i) != 1) {
                    throw new IllegalArgumentException("Byte isn't 0 or 1");
                }
                stringBuffer.append('1');
            }
        }
        return stringBuffer.toString();
    }

    public void xor(BitVector bitVector) {
        if (this.sizeInBits != bitVector.size()) {
            throw new IllegalArgumentException("BitVector sizes don't match");
        }
        int i = (this.sizeInBits + 7) >> 3;
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr = this.array;
            bArr[i2] = (byte) (bArr[i2] ^ bitVector.array[i2]);
        }
    }
}
