package com.zebra.sdk.comm;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class UsbOutputStream extends OutputStream {
    private UsbDeviceConnection connection;
    private UsbEndpoint outEndpoint;

    public UsbOutputStream(UsbDeviceConnection usbDeviceConnection, UsbEndpoint usbEndpoint) {
        this.connection = usbDeviceConnection;
        this.outEndpoint = usbEndpoint;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.connection.bulkTransfer(this.outEndpoint, new byte[]{(byte) i}, 1, 500);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.connection.bulkTransfer(this.outEndpoint, bArr, bArr.length, 500);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        write(Arrays.copyOfRange(bArr, i, i2 + i));
    }
}
