package com.zebra.sdk.graphics.internal;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
class NaughtyBitOutputStream extends OutputStream {
    private OutputStream os;

    public NaughtyBitOutputStream(OutputStream outputStream) {
        this.os = outputStream;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.os.write(~i);
    }
}
