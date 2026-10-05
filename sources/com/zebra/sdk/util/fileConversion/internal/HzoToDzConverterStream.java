package com.zebra.sdk.util.fileConversion.internal;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class HzoToDzConverterStream extends InputStream {
    private InputStream sourceStream;
    String fakeDyHeader = "";
    int readCounter = 0;
    private boolean preambleSkipped = false;

    public HzoToDzConverterStream(InputStream inputStream) throws IOException {
        this.sourceStream = inputStream;
        if (inputStream == null) {
            throw new IOException("input stream is null");
        }
    }

    private void skipPreamble() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i = this.sourceStream.read();
        if (-1 == i) {
            throw new IOException("File not found");
        }
        while (i != -1) {
            stringBuffer.append(String.format("%c", Integer.valueOf(i)));
            if (stringBuffer.toString().endsWith("<![CDATA[")) {
                break;
            } else {
                i = this.sourceStream.read();
            }
        }
        this.preambleSkipped = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.preambleSkipped) {
            skipPreamble();
        }
        int i = this.sourceStream.read();
        if (i == 93) {
            while (-1 != i) {
                i = this.sourceStream.read();
            }
        }
        return i;
    }
}
