package com.zebra.sdk.util.internal;

import com.zebra.sdk.comm.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class StreamHelper {
    public static void copyAndCloseSourceStream(Connection connection, InputStream inputStream) throws IOException {
        copyAndCloseSourceStream(new HasWrite(connection), inputStream);
    }

    private static void copyAndCloseSourceStream(HasWrite hasWrite, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (inputStream.available() > 0) {
            hasWrite.write(bArr, 0, inputStream.read(bArr));
        }
        inputStream.close();
    }

    public static void copyAndCloseSourceStream(OutputStream outputStream, InputStream inputStream) throws IOException {
        copyAndCloseSourceStream(new HasWrite(outputStream), inputStream);
    }
}
