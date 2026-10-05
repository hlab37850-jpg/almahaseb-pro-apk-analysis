package org.apache.poi.util;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class LittleEndian implements LittleEndianConsts {

    public static final class BufferUnderrunException extends IOException {
        public BufferUnderrunException() {
            super("buffer underrun");
        }
    }

    private LittleEndian() {
    }

    public static byte[] getByteArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static double getDouble(byte[] bArr, int i) {
        return Double.longBitsToDouble(getLong(bArr, i));
    }

    public static int getInt(byte[] bArr, int i) {
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        int i3 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 24) + ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16) + (i3 << 8) + i2;
    }

    public static long getLong(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = i + 7; i2 >= i; i2--) {
            j = (j << 8) | ((long) (bArr[i2] & UnsignedBytes.MAX_VALUE));
        }
        return j;
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i] & UnsignedBytes.MAX_VALUE));
    }

    public static long getUInt(byte[] bArr, int i) {
        return getInt(bArr, i);
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i] & UnsignedBytes.MAX_VALUE);
    }

    public static int getUnsignedByte(byte[] bArr, int i) {
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }

    public static void putByte(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
    }

    public static void putDouble(byte[] bArr, int i, double d) {
        putLong(bArr, i, Double.doubleToLongBits(d));
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 & 255);
        bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
        bArr[i + 2] = (byte) ((i2 >>> 16) & 255);
        bArr[i + 3] = (byte) ((i2 >>> 24) & 255);
    }

    public static void putLong(byte[] bArr, int i, long j) {
        int i2 = i + 8;
        while (i < i2) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
            i++;
        }
    }

    public static void putShort(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s & 255);
        bArr[i + 1] = (byte) ((s >>> 8) & 255);
    }

    public static void putUShort(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 & 255);
        bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
    }

    public static int readInt(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();
        int i4 = inputStream.read();
        if ((i | i2 | i3 | i4) >= 0) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        }
        throw new BufferUnderrunException();
    }

    public static long readLong(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i3 = inputStream.read();
        int i4 = inputStream.read();
        int i5 = inputStream.read();
        int i6 = inputStream.read();
        int i7 = inputStream.read();
        int i8 = inputStream.read();
        if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) >= 0) {
            return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + ((long) (i3 << 16)) + ((long) (i2 << 8)) + ((long) i);
        }
        throw new BufferUnderrunException();
    }

    public static short readShort(InputStream inputStream) {
        return (short) readUShort(inputStream);
    }

    public static int readUShort(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        if ((i | i2) >= 0) {
            return (i2 << 8) + i;
        }
        throw new BufferUnderrunException();
    }

    public static int ubyteToInt(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    public static long getUInt(byte[] bArr) {
        return getUInt(bArr, 0);
    }

    public static short getShort(byte[] bArr) {
        return getShort(bArr, 0);
    }

    public static int getUShort(byte[] bArr) {
        return getUShort(bArr, 0);
    }

    public static void putShort(byte[] bArr, short s) {
        putShort(bArr, 0, s);
    }

    public static int getInt(byte[] bArr) {
        return getInt(bArr, 0);
    }

    public static void putInt(byte[] bArr, int i) {
        putInt(bArr, 0, i);
    }
}
