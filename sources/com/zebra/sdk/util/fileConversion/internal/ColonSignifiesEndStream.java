package com.zebra.sdk.util.fileConversion.internal;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ColonSignifiesEndStream extends InputStream {
    private InputStream sourceStream;

    public ColonSignifiesEndStream(InputStream inputStream) {
        this.sourceStream = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.sourceStream.read();
        if (i == 58) {
            while (i != -1) {
                i = this.sourceStream.read();
            }
        }
        return i;
    }
}
