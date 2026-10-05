package com.zebra.sdk.util.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
class HasWrite {
    Object localWriter;

    public HasWrite(Object obj) {
        this.localWriter = obj;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        Object obj = this.localWriter;
        if (obj instanceof Connection) {
            try {
                ((Connection) obj).write(bArr, i, i2);
            } catch (ConnectionException e) {
                throw new IOException(e.getLocalizedMessage());
            }
        } else {
            if (!(obj instanceof OutputStream)) {
                throw new RuntimeException("OutputStream is null");
            }
            ((OutputStream) obj).write(bArr, i, i2);
        }
    }
}
