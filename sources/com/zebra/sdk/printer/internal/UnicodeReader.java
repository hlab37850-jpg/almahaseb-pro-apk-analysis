package com.zebra.sdk.printer.internal;

import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes3.dex */
public class UnicodeReader extends Reader {
    private static final int BOM_SIZE = 4;
    String defaultEnc;
    PushbackInputStream internalIn;
    InputStreamReader internalIn2 = null;

    public UnicodeReader(InputStream inputStream, String str) {
        this.internalIn = new PushbackInputStream(inputStream, 4);
        this.defaultEnc = str;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        init();
        this.internalIn2.close();
    }

    public String getDefaultEncoding() {
        return this.defaultEnc;
    }

    public String getEncoding() {
        InputStreamReader inputStreamReader = this.internalIn2;
        if (inputStreamReader == null) {
            return null;
        }
        return inputStreamReader.getEncoding();
    }

    public void init() throws IOException {
        String str;
        int i;
        if (this.internalIn2 != null) {
            return;
        }
        byte[] bArr = new byte[4];
        int i2 = this.internalIn.read(bArr, 0, 4);
        byte b = bArr[0];
        if (b == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) {
            i = i2 - 4;
            str = "UTF-32BE";
        } else if (b == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0) {
            i = i2 - 4;
            str = "UTF-32LE";
        } else if (b == -17 && bArr[1] == -69 && bArr[2] == -65) {
            i = i2 - 3;
            str = XmpWriter.UTF8;
        } else if (b == -2 && bArr[1] == -1) {
            i = i2 - 2;
            str = XmpWriter.UTF16BE;
        } else if (b == -1 && bArr[1] == -2) {
            i = i2 - 2;
            str = XmpWriter.UTF16LE;
        } else {
            str = this.defaultEnc;
            i = i2;
        }
        if (i > 0) {
            this.internalIn.unread(bArr, i2 - i, i);
        }
        PushbackInputStream pushbackInputStream = this.internalIn;
        this.internalIn2 = str == null ? new InputStreamReader(pushbackInputStream) : new InputStreamReader(pushbackInputStream, str);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        init();
        return this.internalIn2.read(cArr, i, i2);
    }
}
