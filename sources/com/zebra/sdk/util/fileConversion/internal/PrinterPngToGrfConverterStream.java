package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.graphics.internal.PngToGrfConverterAndroid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterPngToGrfConverterStream extends InputStream {
    private ByteArrayInputStream grfStream;
    private InputStream pngStream;
    int headerCount = 0;
    int[] zebraHeader = {0, 0, 0, 0};

    public PrinterPngToGrfConverterStream(InputStream inputStream) {
        this.pngStream = inputStream;
    }

    private byte[] pngToGrf(InputStream inputStream) {
        Class cls;
        try {
            try {
                cls = Class.forName("com.zebra.sdk.graphics.internal.PngToGrfConverterDesktop");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException unused) {
            cls = PngToGrfConverterAndroid.class;
        }
        return (byte[]) cls.getMethod("pngToGrf", InputStream.class).invoke(null, inputStream);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.headerCount;
        if (i >= 4) {
            if (i == 4) {
                this.headerCount = i + 1;
                this.grfStream = new ByteArrayInputStream(pngToGrf(this.pngStream));
            }
            return this.grfStream.read();
        }
        int i2 = this.pngStream.read();
        int[] iArr = this.zebraHeader;
        int i3 = this.headerCount;
        this.headerCount = i3 + 1;
        iArr[i3] = i2;
        return i2;
    }
}
