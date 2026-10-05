package com.itextpdf.text.io;

import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
class MappedChannelRandomAccessSource implements RandomAccessSource {
    private final FileChannel channel;
    private final long length;
    private final long offset;
    private ByteBufferRandomAccessSource source;

    public MappedChannelRandomAccessSource(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException(j + " is negative");
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(j2 + " is zero or negative");
        }
        this.channel = fileChannel;
        this.offset = j;
        this.length = j2;
        this.source = null;
    }

    private static boolean exceptionIsMapFailureException(IOException iOException) {
        return iOException.getMessage() != null && iOException.getMessage().indexOf("Map failed") >= 0;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() {
        ByteBufferRandomAccessSource byteBufferRandomAccessSource = this.source;
        if (byteBufferRandomAccessSource == null) {
            return;
        }
        byteBufferRandomAccessSource.close();
        this.source = null;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) throws IOException {
        ByteBufferRandomAccessSource byteBufferRandomAccessSource = this.source;
        if (byteBufferRandomAccessSource != null) {
            return byteBufferRandomAccessSource.get(j);
        }
        throw new IOException("RandomAccessSource not opened");
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.length;
    }

    public void open() throws IOException {
        if (this.source != null) {
            return;
        }
        if (!this.channel.isOpen()) {
            throw new IllegalStateException("Channel is closed");
        }
        try {
            this.source = new ByteBufferRandomAccessSource(this.channel.map(FileChannel.MapMode.READ_ONLY, this.offset, this.length));
        } catch (IOException e) {
            if (!exceptionIsMapFailureException(e)) {
                throw e;
            }
            throw new MapFailedException(e);
        }
    }

    public String toString() {
        return getClass().getName() + " (" + this.offset + ", " + this.length + ")";
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) throws IOException {
        ByteBufferRandomAccessSource byteBufferRandomAccessSource = this.source;
        if (byteBufferRandomAccessSource != null) {
            return byteBufferRandomAccessSource.get(j, bArr, i, i2);
        }
        throw new IOException("RandomAccessSource not opened");
    }
}
