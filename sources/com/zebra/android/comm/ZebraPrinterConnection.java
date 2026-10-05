package com.zebra.android.comm;

import com.zebra.sdk.comm.Connection;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraPrinterConnection {
    int bytesAvailable();

    void close();

    Connection getConvertedNewStyleConnection();

    int getMaxTimeoutForRead();

    int getTimeToWaitForMoreData();

    boolean isConnected();

    void open();

    byte[] read();

    String toString();

    void waitForData(int i);

    void write(byte[] bArr);

    void write(byte[] bArr, int i, int i2);
}
