package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class BlockingInputStream extends InputStream {
    protected InputStream is;

    public BlockingInputStream(InputStream inputStream) {
        this.is = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.is.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.is.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.is.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.is.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.is.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.is.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.is.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        int i = 0;
        int i2 = 4611;
        while (i < bArr.length && (i2 = this.is.read()) != -1) {
            bArr[i] = (byte) i2;
            i++;
        }
        if (i == 0 && i2 == -1) {
            return -1;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.is.read(bArr, i, i2);
    }
}
