package com.zebra.sdk.graphics.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class CompressedBitmapOutputStreamCpcl extends CompressedBitmapOutputStreamA {
    public CompressedBitmapOutputStreamCpcl(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.internalEncodedBuffer = new ByteArrayOutputStream();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        for (byte b : bArr) {
            bufferAndWrite((char) (~b));
        }
    }
}
