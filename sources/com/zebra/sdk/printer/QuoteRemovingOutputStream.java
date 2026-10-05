package com.zebra.sdk.printer;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
class QuoteRemovingOutputStream extends FilterOutputStream {
    public QuoteRemovingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if ("\"".getBytes()[0] != i) {
            super.write(i);
        }
    }
}
