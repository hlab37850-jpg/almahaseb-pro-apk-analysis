package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentOutputStream extends OutputStream {
    private final int _limit;
    private final OutputStream _stream;
    private int _written = 0;

    public DocumentOutputStream(OutputStream outputStream, int i) {
        this._stream = outputStream;
        this._limit = i;
    }

    private void limitCheck(int i) throws IOException {
        int i2 = this._written;
        if (i2 + i > this._limit) {
            throw new IOException("tried to write too much data");
        }
        this._written = i2 + i;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this._stream.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        limitCheck(1);
        this._stream.write(i);
    }

    public void writeFiller(int i, byte b) throws IOException {
        int i2 = this._written;
        if (i > i2) {
            byte[] bArr = new byte[i - i2];
            Arrays.fill(bArr, b);
            this._stream.write(bArr);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        limitCheck(i2);
        this._stream.write(bArr, i, i2);
    }
}
