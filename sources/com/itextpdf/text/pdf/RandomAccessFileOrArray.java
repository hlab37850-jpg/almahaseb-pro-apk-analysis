package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.io.IndependentRandomAccessSource;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class RandomAccessFileOrArray implements DataInput {
    private byte back;
    private final RandomAccessSource byteSource;
    private long byteSourcePosition;
    private boolean isBack;

    @Deprecated
    public RandomAccessFileOrArray(String str) {
        this(new RandomAccessSourceFactory().setForceRead(false).setUsePlainRandomAccess(Document.plainRandomAccess).createBestSource(str));
    }

    public void close() {
        this.isBack = false;
        this.byteSource.close();
    }

    public RandomAccessSource createSourceView() {
        return new IndependentRandomAccessSource(this.byteSource);
    }

    public RandomAccessFileOrArray createView() {
        return new RandomAccessFileOrArray(new IndependentRandomAccessSource(this.byteSource));
    }

    @Deprecated
    public RandomAccessSource getByteSource() {
        return this.byteSource;
    }

    public long getFilePointer() {
        return this.byteSourcePosition - (this.isBack ? 1L : 0L);
    }

    public long length() {
        return this.byteSource.length();
    }

    public void pushBack(byte b) {
        this.back = b;
        this.isBack = true;
    }

    @Deprecated
    public void reOpen() {
        seek(0L);
    }

    public int read() {
        if (this.isBack) {
            this.isBack = false;
            return this.back & UnsignedBytes.MAX_VALUE;
        }
        RandomAccessSource randomAccessSource = this.byteSource;
        long j = this.byteSourcePosition;
        this.byteSourcePosition = 1 + j;
        return randomAccessSource.get(j);
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws EOFException {
        int i = read();
        if (i >= 0) {
            return i != 0;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public byte readByte() throws EOFException {
        int i = read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws EOFException {
        int i = read();
        int i2 = read();
        if ((i | i2) >= 0) {
            return (char) ((i << 8) + i2);
        }
        throw new EOFException();
    }

    public final char readCharLE() throws EOFException {
        int i = read();
        int i2 = read();
        if ((i | i2) >= 0) {
            return (char) ((i2 << 8) + i);
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public final double readDoubleLE() {
        return Double.longBitsToDouble(readLongLE());
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public final float readFloatLE() {
        return Float.intBitsToFloat(readIntLE());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws EOFException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public int readInt() throws EOFException {
        int i = read();
        int i2 = read();
        int i3 = read();
        int i4 = read();
        if ((i | i2 | i3 | i4) >= 0) {
            return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
        }
        throw new EOFException();
    }

    public final int readIntLE() throws EOFException {
        int i = read();
        int i2 = read();
        int i3 = read();
        int i4 = read();
        if ((i | i2 | i3 | i4) >= 0) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public String readLine() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = -1;
        while (!z) {
            i = read();
            if (i != -1 && i != 10) {
                if (i != 13) {
                    sb.append((char) i);
                } else {
                    long filePointer = getFilePointer();
                    if (read() != 10) {
                        seek(filePointer);
                    }
                }
            }
            z = true;
        }
        if (i == -1 && sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return (((long) readInt()) << 32) + (((long) readInt()) & 4294967295L);
    }

    public final long readLongLE() throws EOFException {
        return (((long) readIntLE()) << 32) + (((long) readIntLE()) & 4294967295L);
    }

    @Override // java.io.DataInput
    public short readShort() throws EOFException {
        int i = read();
        int i2 = read();
        if ((i | i2) >= 0) {
            return (short) ((i << 8) + i2);
        }
        throw new EOFException();
    }

    public final short readShortLE() throws EOFException {
        int i = read();
        int i2 = read();
        if ((i | i2) >= 0) {
            return (short) ((i2 << 8) + i);
        }
        throw new EOFException();
    }

    public String readString(int i, String str) throws EOFException {
        byte[] bArr = new byte[i];
        readFully(bArr);
        try {
            return new String(bArr, str);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws EOFException {
        int i = read();
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    public final long readUnsignedInt() throws EOFException {
        long j = read();
        long j2 = read();
        long j3 = read();
        long j4 = read();
        if ((j | j2 | j3 | j4) >= 0) {
            return (j << 24) + (j2 << 16) + (j3 << 8) + j4;
        }
        throw new EOFException();
    }

    public final long readUnsignedIntLE() throws EOFException {
        long j = read();
        long j2 = read();
        long j3 = read();
        long j4 = read();
        if ((j | j2 | j3 | j4) >= 0) {
            return (j4 << 24) + (j3 << 16) + (j2 << 8) + j;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws EOFException {
        int i = read();
        int i2 = read();
        if ((i | i2) >= 0) {
            return (i << 8) + i2;
        }
        throw new EOFException();
    }

    public final int readUnsignedShortLE() throws EOFException {
        int i = read();
        int i2 = read();
        if ((i | i2) >= 0) {
            return (i2 << 8) + i;
        }
        throw new EOFException();
    }

    public void seek(long j) {
        this.byteSourcePosition = j;
        this.isBack = false;
    }

    public long skip(long j) {
        if (j <= 0) {
            return 0L;
        }
        int i = 0;
        if (this.isBack) {
            this.isBack = false;
            if (j == 1) {
                return 1L;
            }
            j--;
            i = 1;
        }
        long filePointer = getFilePointer();
        long length = length();
        long j2 = j + filePointer;
        if (j2 <= length) {
            length = j2;
        }
        seek(length);
        return (length - filePointer) + ((long) i);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return (int) skip(i);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws EOFException {
        int i3 = 0;
        do {
            int i4 = read(bArr, i + i3, i2 - i3);
            if (i4 < 0) {
                throw new EOFException();
            }
            i3 += i4;
        } while (i3 < i2);
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (!this.isBack || i2 <= 0) {
            i3 = i;
            i4 = i2;
        } else {
            this.isBack = false;
            bArr[i] = this.back;
            i4 = i2 - 1;
            i3 = i + 1;
            i6 = 1;
        }
        if (i4 > 0 && (i5 = this.byteSource.get(this.byteSourcePosition, bArr, i3, i4)) > 0) {
            i6 += i5;
            this.byteSourcePosition += (long) i5;
        }
        if (i6 == 0) {
            return -1;
        }
        return i6;
    }

    @Deprecated
    public RandomAccessFileOrArray(RandomAccessFileOrArray randomAccessFileOrArray) {
        this(new IndependentRandomAccessSource(randomAccessFileOrArray.byteSource));
    }

    public RandomAccessFileOrArray(RandomAccessSource randomAccessSource) {
        this.isBack = false;
        this.byteSource = randomAccessSource;
    }

    @Deprecated
    public RandomAccessFileOrArray(String str, boolean z, boolean z2) {
        this(new RandomAccessSourceFactory().setForceRead(z).setUsePlainRandomAccess(z2).createBestSource(str));
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Deprecated
    public RandomAccessFileOrArray(URL url) {
        this(new RandomAccessSourceFactory().createSource(url));
    }

    @Deprecated
    public RandomAccessFileOrArray(InputStream inputStream) {
        this(new RandomAccessSourceFactory().createSource(inputStream));
    }

    @Deprecated
    public RandomAccessFileOrArray(byte[] bArr) {
        this(new RandomAccessSourceFactory().createSource(bArr));
    }
}
