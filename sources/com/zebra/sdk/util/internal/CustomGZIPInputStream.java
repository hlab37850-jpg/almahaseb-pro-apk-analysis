package com.zebra.sdk.util.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class CustomGZIPInputStream extends InflaterInputStream {
    public static final int GZIP_MAGIC = 35615;
    private boolean closed;
    protected CRC32 crc;
    protected boolean eos;

    public CustomGZIPInputStream(InputStream inputStream) {
        this(inputStream, 512);
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream Closed");
        }
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        super.close();
        this.eos = true;
        this.closed = true;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        ensureOpen();
        if (this.eos) {
            return -1;
        }
        int i3 = super.read(bArr, i, i2);
        if (i3 == -1) {
            this.eos = true;
        } else {
            this.crc.update(bArr, i, i3);
        }
        return i3;
    }

    public CustomGZIPInputStream(InputStream inputStream, int i) {
        super(inputStream);
        CRC32 crc32 = new CRC32();
        this.crc = crc32;
        this.closed = false;
        crc32.reset();
    }
}
