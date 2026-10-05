package com.zebra.sdk.comm;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface Connection {
    int bytesAvailable();

    void close();

    ConnectionReestablisher getConnectionReestablisher(long j);

    int getMaxTimeoutForRead();

    String getSimpleConnectionName();

    int getTimeToWaitForMoreData();

    boolean isConnected();

    void open();

    void read(OutputStream outputStream);

    byte[] read();

    int readChar();

    void sendAndWaitForResponse(OutputStream outputStream, InputStream inputStream, int i, int i2, String str);

    byte[] sendAndWaitForResponse(byte[] bArr, int i, int i2, String str);

    void sendAndWaitForValidResponse(OutputStream outputStream, InputStream inputStream, int i, int i2, ResponseValidator responseValidator);

    byte[] sendAndWaitForValidResponse(byte[] bArr, int i, int i2, ResponseValidator responseValidator);

    void setMaxTimeoutForRead(int i);

    void setTimeToWaitForMoreData(int i);

    String toString();

    void waitForData(int i);

    void write(InputStream inputStream);

    void write(byte[] bArr);

    void write(byte[] bArr, int i, int i2);
}
