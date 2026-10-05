package com.itextpdf.text.io;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes3.dex */
class ArrayRandomAccessSource implements RandomAccessSource {
    private byte[] array;

    public ArrayRandomAccessSource(byte[] bArr) {
        bArr.getClass();
        this.array = bArr;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() {
        this.array = null;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) {
        byte[] bArr = this.array;
        if (j >= bArr.length) {
            return -1;
        }
        return bArr[(int) j] & UnsignedBytes.MAX_VALUE;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.array.length;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.array;
        if (bArr2 == null) {
            throw new IllegalStateException("Already closed");
        }
        if (j >= bArr2.length) {
            return -1;
        }
        if (((long) i2) + j > bArr2.length) {
            i2 = (int) (((long) bArr2.length) - j);
        }
        System.arraycopy(bArr2, (int) j, bArr, i, i2);
        return i2;
    }
}
