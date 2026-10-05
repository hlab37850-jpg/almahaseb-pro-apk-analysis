package com.zebra.sdk.graphics.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CompressedBitmapOutputStreamA extends OutputStream {
    private static final int INTERNAL_ENCODED_BUFFER_SIZE = 1024;
    protected ByteArrayOutputStream internalEncodedBuffer;
    protected OutputStream outputStream;

    public void bufferAndWrite(char c) throws IOException {
        if (this.internalEncodedBuffer.size() < 1024) {
            this.internalEncodedBuffer.write((byte) c);
        }
        if (this.internalEncodedBuffer.size() == 1024) {
            this.outputStream.write(this.internalEncodedBuffer.toByteArray());
            this.internalEncodedBuffer.reset();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.internalEncodedBuffer.size() != 0) {
            this.outputStream.write(this.internalEncodedBuffer.toByteArray());
            this.internalEncodedBuffer.reset();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        throw new IOException("This method is not implemented.");
    }
}
