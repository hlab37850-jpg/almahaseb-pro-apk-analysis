package com.zebra.sdk.printer.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraFileConnectionImpl implements ZebraFileConnection {
    private File decoratedFileConnection;

    public ZebraFileConnectionImpl(String str) {
        this.decoratedFileConnection = null;
        this.decoratedFileConnection = new File(str);
    }

    @Override // com.zebra.sdk.printer.internal.ZebraFileConnection
    public void close() {
    }

    @Override // com.zebra.sdk.printer.internal.ZebraFileConnection
    public int fileSize() {
        return (int) this.decoratedFileConnection.length();
    }

    @Override // com.zebra.sdk.printer.internal.ZebraFileConnection
    public InputStream openInputStream() throws IOException {
        try {
            return new FileInputStream(this.decoratedFileConnection);
        } catch (FileNotFoundException e) {
            throw new IOException(e.getMessage());
        }
    }
}
