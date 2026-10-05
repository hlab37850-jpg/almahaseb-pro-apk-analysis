package com.zebra.sdk.comm;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MultichannelConnection implements ConnectionWithWriteLogging {
    protected ConnectionWithWriteLogging raw;
    protected StatusConnectionWithWriteLogging settings;

    private void throwIfOnlyStatusOpen() throws ConnectionException {
        if (!this.raw.isConnected() && this.settings.isConnected()) {
            throw new ConnectionException("Operation cannot be performed with only the status channel open");
        }
    }

    @Override // com.zebra.sdk.comm.ConnectionWithWriteLogging
    public void addWriteLogStream(OutputStream outputStream) {
        this.raw.addWriteLogStream(outputStream);
        this.settings.addWriteLogStream(outputStream);
    }

    @Override // com.zebra.sdk.comm.Connection
    public int bytesAvailable() {
        return this.raw.bytesAvailable();
    }

    @Override // com.zebra.sdk.comm.Connection
    public void close() {
        this.raw.close();
        this.settings.close();
    }

    public void closePrintingChannel() {
        this.raw.close();
    }

    public void closeStatusChannel() {
        this.settings.close();
    }

    @Override // com.zebra.sdk.comm.Connection
    public ConnectionReestablisher getConnectionReestablisher(long j) {
        return this.raw.getConnectionReestablisher(j);
    }

    @Override // com.zebra.sdk.comm.Connection
    public int getMaxTimeoutForRead() {
        return this.raw.getMaxTimeoutForRead();
    }

    public Connection getPrintingChannel() {
        return this.raw;
    }

    public StatusConnection getStatusChannel() {
        return this.settings;
    }

    @Override // com.zebra.sdk.comm.Connection
    public int getTimeToWaitForMoreData() {
        return this.raw.getTimeToWaitForMoreData();
    }

    @Override // com.zebra.sdk.comm.Connection
    public boolean isConnected() {
        return this.raw.isConnected() || this.settings.isConnected();
    }

    @Override // com.zebra.sdk.comm.Connection
    public void open() throws ConnectionException {
        boolean z;
        boolean z2 = true;
        try {
            openPrintingChannel();
            z = true;
        } catch (ConnectionException unused) {
            z = false;
        }
        try {
            openStatusChannel();
        } catch (ConnectionException unused2) {
            z2 = z;
        }
        if (!z2) {
            throw new ConnectionException("Could not open connection");
        }
    }

    public void openPrintingChannel() {
        this.raw.open();
    }

    public void openStatusChannel() {
        this.settings.open();
    }

    @Override // com.zebra.sdk.comm.Connection
    public void read(OutputStream outputStream) {
        this.raw.read(outputStream);
    }

    @Override // com.zebra.sdk.comm.Connection
    public int readChar() {
        return this.raw.readChar();
    }

    @Override // com.zebra.sdk.comm.Connection
    public void sendAndWaitForResponse(OutputStream outputStream, InputStream inputStream, int i, int i2, String str) throws ConnectionException {
        throwIfOnlyStatusOpen();
        this.raw.sendAndWaitForResponse(outputStream, inputStream, i, i2, str);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void sendAndWaitForValidResponse(OutputStream outputStream, InputStream inputStream, int i, int i2, ResponseValidator responseValidator) throws ConnectionException {
        throwIfOnlyStatusOpen();
        this.raw.sendAndWaitForValidResponse(outputStream, inputStream, i, i2, responseValidator);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void setMaxTimeoutForRead(int i) {
        this.raw.setMaxTimeoutForRead(i);
        this.settings.setMaxTimeoutForRead(i);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void setTimeToWaitForMoreData(int i) {
        this.raw.setTimeToWaitForMoreData(i);
        this.settings.setTimeToWaitForMoreData(i);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void waitForData(int i) {
        this.raw.waitForData(i);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(InputStream inputStream) throws ConnectionException {
        throwIfOnlyStatusOpen();
        this.raw.write(inputStream);
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] read() {
        return this.raw.read();
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] sendAndWaitForResponse(byte[] bArr, int i, int i2, String str) throws ConnectionException {
        throwIfOnlyStatusOpen();
        return this.raw.sendAndWaitForResponse(bArr, i, i2, str);
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] sendAndWaitForValidResponse(byte[] bArr, int i, int i2, ResponseValidator responseValidator) throws ConnectionException {
        throwIfOnlyStatusOpen();
        return this.raw.sendAndWaitForValidResponse(bArr, i, i2, responseValidator);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(byte[] bArr) throws ConnectionException {
        throwIfOnlyStatusOpen();
        this.raw.write(bArr);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(byte[] bArr, int i, int i2) throws ConnectionException {
        throwIfOnlyStatusOpen();
        this.raw.write(bArr, i, i2);
    }
}
