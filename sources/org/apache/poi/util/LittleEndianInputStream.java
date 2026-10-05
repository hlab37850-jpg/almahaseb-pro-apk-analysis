package org.apache.poi.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class LittleEndianInputStream extends FilterInputStream implements LittleEndianInput {
    public LittleEndianInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private static void checkEOF(int i) {
        if (i < 0) {
            throw new RuntimeException("Unexpected end-of-file");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        try {
            return super.available();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        try {
            int i = ((FilterInputStream) this).in.read();
            int i2 = ((FilterInputStream) this).in.read();
            int i3 = ((FilterInputStream) this).in.read();
            int i4 = ((FilterInputStream) this).in.read();
            checkEOF(i | i2 | i3 | i4);
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        try {
            int i = ((FilterInputStream) this).in.read();
            int i2 = ((FilterInputStream) this).in.read();
            int i3 = ((FilterInputStream) this).in.read();
            int i4 = ((FilterInputStream) this).in.read();
            int i5 = ((FilterInputStream) this).in.read();
            int i6 = ((FilterInputStream) this).in.read();
            int i7 = ((FilterInputStream) this).in.read();
            int i8 = ((FilterInputStream) this).in.read();
            checkEOF(i | i2 | i3 | i4 | i5 | i6 | i7 | i8);
            return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + ((long) (i3 << 16)) + ((long) (i2 << 8)) + ((long) i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        try {
            int i = ((FilterInputStream) this).in.read();
            checkEOF(i);
            return i;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        try {
            int i = ((FilterInputStream) this).in.read();
            int i2 = ((FilterInputStream) this).in.read();
            checkEOF(i | i2);
            return (i2 << 8) + i;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            try {
                int i4 = ((FilterInputStream) this).in.read();
                checkEOF(i4);
                bArr[i] = (byte) i4;
                i++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
