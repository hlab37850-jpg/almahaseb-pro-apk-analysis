package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.internal.ConnectionBuilderInternal;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterConnectionOutputStream extends OutputStream {
    private Connection printerConnection;

    public PrinterConnectionOutputStream(Connection connection) {
        this.printerConnection = connection;
    }

    public void closePrinterConnection() {
        this.printerConnection.close();
    }

    public void openPrinterConnection() {
        this.printerConnection.open();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        throw new IOException("This method is not implemented.");
    }

    public PrinterConnectionOutputStream(String str) {
        this.printerConnection = ConnectionBuilderInternal.build(str);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.printerConnection.write(bArr);
        } catch (ConnectionException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.printerConnection.write(bArr, i, i2);
        } catch (ConnectionException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }
}
