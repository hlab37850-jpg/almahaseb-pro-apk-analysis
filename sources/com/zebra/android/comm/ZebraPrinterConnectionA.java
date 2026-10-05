package com.zebra.android.comm;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionA;
import com.zebra.sdk.comm.ConnectionException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZebraPrinterConnectionA implements ZebraPrinterConnection {
    Connection myDelegator;

    public ZebraPrinterConnectionA(ConnectionA connectionA) {
        this.myDelegator = connectionA;
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public int bytesAvailable() throws ZebraPrinterConnectionException {
        try {
            return this.myDelegator.bytesAvailable();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public void close() throws ZebraPrinterConnectionException {
        try {
            this.myDelegator.close();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public Connection getConvertedNewStyleConnection() {
        return this.myDelegator;
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public int getMaxTimeoutForRead() {
        return this.myDelegator.getMaxTimeoutForRead();
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public int getTimeToWaitForMoreData() {
        return this.myDelegator.getTimeToWaitForMoreData();
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public boolean isConnected() {
        return this.myDelegator.isConnected();
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public void open() throws ZebraPrinterConnectionException {
        try {
            this.myDelegator.open();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public byte[] read() throws ZebraPrinterConnectionException {
        try {
            return this.myDelegator.read();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public void waitForData(int i) throws ZebraPrinterConnectionException {
        try {
            this.myDelegator.waitForData(i);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public void write(byte[] bArr) throws ZebraPrinterConnectionException {
        try {
            this.myDelegator.write(bArr);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public void write(byte[] bArr, int i, int i2) throws ZebraPrinterConnectionException {
        try {
            this.myDelegator.write(bArr, i, i2);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }
}
