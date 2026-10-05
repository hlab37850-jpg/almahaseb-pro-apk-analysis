package com.zebra.sdk.settings.internal;

import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.comm.ConnectionWithWriteLogging;
import com.zebra.sdk.comm.LogStreamException;
import com.zebra.sdk.comm.ResponseValidator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterlessConnection implements ConnectionWithWriteLogging {
    ByteArrayOutputStream baos;
    private byte[] dataToReturnOnEveryRead;
    private OutputStream myWriteLogStream;

    public PrinterlessConnection() {
        this.baos = new ByteArrayOutputStream();
        this.dataToReturnOnEveryRead = null;
    }

    private void writeToLogStream(byte[] bArr, int i, int i2) throws LogStreamException {
        OutputStream outputStream = this.myWriteLogStream;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new LogStreamException("Error writing to log: " + e.getLocalizedMessage());
            }
        }
    }

    @Override // com.zebra.sdk.comm.ConnectionWithWriteLogging
    public void addWriteLogStream(OutputStream outputStream) {
        this.myWriteLogStream = outputStream;
    }

    @Override // com.zebra.sdk.comm.Connection
    public int bytesAvailable() {
        byte[] bArr = this.dataToReturnOnEveryRead;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    @Override // com.zebra.sdk.comm.Connection
    public void close() {
    }

    @Override // com.zebra.sdk.comm.Connection
    public ConnectionReestablisher getConnectionReestablisher(long j) {
        return null;
    }

    @Override // com.zebra.sdk.comm.Connection
    public int getMaxTimeoutForRead() {
        return 10;
    }

    @Override // com.zebra.sdk.comm.Connection
    public String getSimpleConnectionName() {
        return null;
    }

    public String getStuffWrittenOnConnection() {
        return this.baos.toString();
    }

    @Override // com.zebra.sdk.comm.Connection
    public int getTimeToWaitForMoreData() {
        return 10;
    }

    @Override // com.zebra.sdk.comm.Connection
    public boolean isConnected() {
        return true;
    }

    @Override // com.zebra.sdk.comm.Connection
    public void open() {
    }

    @Override // com.zebra.sdk.comm.Connection
    public void read(OutputStream outputStream) {
    }

    @Override // com.zebra.sdk.comm.Connection
    public int readChar() {
        return -1;
    }

    @Override // com.zebra.sdk.comm.Connection
    public void sendAndWaitForResponse(OutputStream outputStream, InputStream inputStream, int i, int i2, String str) {
        write(inputStream);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void sendAndWaitForValidResponse(OutputStream outputStream, InputStream inputStream, int i, int i2, ResponseValidator responseValidator) {
    }

    @Override // com.zebra.sdk.comm.Connection
    public void setMaxTimeoutForRead(int i) {
    }

    @Override // com.zebra.sdk.comm.Connection
    public void setTimeToWaitForMoreData(int i) {
    }

    @Override // com.zebra.sdk.comm.Connection
    public void waitForData(int i) {
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(InputStream inputStream) {
    }

    public PrinterlessConnection(byte[] bArr) {
        this.baos = new ByteArrayOutputStream();
        this.dataToReturnOnEveryRead = bArr;
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] read() {
        byte[] bArr = this.dataToReturnOnEveryRead;
        if (bArr == null) {
            return null;
        }
        this.dataToReturnOnEveryRead = null;
        return bArr;
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] sendAndWaitForResponse(byte[] bArr, int i, int i2, String str) throws LogStreamException {
        write(bArr, 0, bArr.length);
        return read();
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] sendAndWaitForValidResponse(byte[] bArr, int i, int i2, ResponseValidator responseValidator) throws LogStreamException {
        write(bArr, 0, bArr.length);
        return read();
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(byte[] bArr) throws LogStreamException {
        write(bArr, 0, bArr.length);
        writeToLogStream(bArr, 0, bArr.length);
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(byte[] bArr, int i, int i2) throws LogStreamException {
        this.baos.write(bArr, i, i2);
        writeToLogStream(bArr, i, i2);
    }
}
