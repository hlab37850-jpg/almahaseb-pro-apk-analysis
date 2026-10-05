package com.itextpdf.text.io;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class StreamUtil {
    private StreamUtil() {
    }

    public static void CopyBytes(RandomAccessSource randomAccessSource, long j, long j2, OutputStream outputStream) throws IOException {
        if (j2 <= 0) {
            return;
        }
        byte[] bArr = new byte[8192];
        while (j2 > 0) {
            long j3 = randomAccessSource.get(j, bArr, 0, (int) Math.min(8192, j2));
            if (j3 <= 0) {
                throw new EOFException();
            }
            outputStream.write(bArr, 0, (int) j3);
            j += j3;
            j2 -= j3;
        }
    }

    public static InputStream getResourceStream(String str) {
        return getResourceStream(str, null);
    }

    public static byte[] inputStreamToArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i < 1) {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static InputStream getResourceStream(String str, ClassLoader classLoader) {
        InputStream resourceAsStream;
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        if (classLoader != null) {
            resourceAsStream = classLoader.getResourceAsStream(str);
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
        } else {
            resourceAsStream = null;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                resourceAsStream = contextClassLoader.getResourceAsStream(str);
            }
        } catch (Throwable unused) {
        }
        if (resourceAsStream == null) {
            resourceAsStream = StreamUtil.class.getResourceAsStream("/" + str);
        }
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
