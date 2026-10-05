package com.zebra.sdk.comm;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
class UsbInputStream extends InputStream {
    private UsbDeviceConnection connection;
    private UsbEndpoint inEndpoint;
    private int readTimeout = 500;
    private Queue<Byte> fifo = new LinkedList();

    public UsbInputStream(UsbDeviceConnection usbDeviceConnection, UsbEndpoint usbEndpoint) {
        this.connection = usbDeviceConnection;
        this.inEndpoint = usbEndpoint;
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.fifo.size() > 0) {
            return this.fifo.size();
        }
        byte[] bArr = new byte[4096];
        int i = read(bArr);
        for (int i2 = 0; i2 < i; i2++) {
            this.fifo.add(Byte.valueOf(bArr[i2]));
        }
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        available();
        if (this.fifo.size() > 0) {
            return this.fifo.remove().byteValue() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int i = (int) j;
        int iBulkTransfer = this.connection.bulkTransfer(this.inEndpoint, new byte[i], i, 500);
        if (iBulkTransfer < 0) {
            return 0L;
        }
        return iBulkTransfer;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (this.fifo.size() > 0) {
            if (this.fifo.size() < i2) {
                i2 = this.fifo.size();
            }
            while (i3 < i2) {
                bArr[i + i3] = this.fifo.remove().byteValue();
                i3++;
            }
            return i2;
        }
        byte[] bArr2 = new byte[i2];
        int iBulkTransfer = this.connection.bulkTransfer(this.inEndpoint, bArr2, i2, this.readTimeout);
        if (iBulkTransfer == -1) {
            return -1;
        }
        while (i3 < iBulkTransfer) {
            bArr[i + i3] = bArr2[i3];
            i3++;
        }
        return iBulkTransfer;
    }
}
