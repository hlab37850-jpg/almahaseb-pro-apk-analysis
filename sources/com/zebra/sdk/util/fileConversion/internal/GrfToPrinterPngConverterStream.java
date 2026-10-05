package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.graphics.internal.GrfToPngConverterAndroid;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class GrfToPrinterPngConverterStream extends InputStream {
    private InputStream grfStream;
    private ByteArrayInputStream pngStream;
    int headerCount = 0;
    int[] zebraHeader = {0, 0, 0, 0};
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    public GrfToPrinterPngConverterStream(InputStream inputStream) {
        this.grfStream = inputStream;
    }

    private byte[] grfToPng(InputStream inputStream, int i, int i2) {
        Class cls;
        try {
            try {
                cls = Class.forName("com.zebra.sdk.graphics.internal.GrfToPngConverterDesktop");
            } catch (Exception unused) {
                return null;
            }
        } catch (ClassNotFoundException unused2) {
            cls = GrfToPngConverterAndroid.class;
        }
        Class<?> cls2 = Integer.TYPE;
        return (byte[]) cls.getMethod("grfToPng", InputStream.class, cls2, cls2).invoke(null, inputStream, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void main(String[] strArr) {
        new ByteArrayInputStream(null).read();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.headerCount;
        if (i < 4) {
            int i2 = this.grfStream.read();
            int[] iArr = this.zebraHeader;
            int i3 = this.headerCount;
            this.headerCount = i3 + 1;
            iArr[i3] = i2;
            return i2;
        }
        if (i == 4) {
            int[] iArr2 = this.zebraHeader;
            int i4 = (iArr2[0] << 8) + iArr2[1];
            int i5 = (iArr2[2] << 8) + iArr2[3];
            this.headerCount = i + 1;
            this.pngStream = new ByteArrayInputStream(grfToPng(this.grfStream, i4, i5));
        }
        return this.pngStream.read();
    }
}
