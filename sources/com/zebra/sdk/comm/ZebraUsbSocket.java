package com.zebra.sdk.comm;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.zebra.sdk.comm.internal.ZebraSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
class ZebraUsbSocket implements ZebraSocket {
    private UsbDeviceConnection connection;
    private UsbDevice device;
    private UsbEndpoint inEndpoint;
    private InputStream inputStream;
    private UsbEndpoint outEndpoint;
    private OutputStream outputStream;
    private UsbInterface usbInterface;
    private UsbManager usbManager;

    public ZebraUsbSocket(UsbManager usbManager, UsbDevice usbDevice) {
        this.device = usbDevice;
        this.usbManager = usbManager;
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void close() {
        this.connection.close();
        this.connection.releaseInterface(this.usbInterface);
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void connect() throws IOException {
        this.usbInterface = this.device.getInterface(0);
        for (int i = 0; i < this.usbInterface.getEndpointCount(); i++) {
            UsbEndpoint endpoint = this.usbInterface.getEndpoint(i);
            if (endpoint.getDirection() == 0 && endpoint.getType() == 2) {
                this.outEndpoint = endpoint;
            } else if (endpoint.getDirection() == 128 && endpoint.getType() == 2) {
                this.inEndpoint = endpoint;
            }
        }
        UsbDeviceConnection usbDeviceConnectionOpenDevice = this.usbManager.openDevice(this.device);
        this.connection = usbDeviceConnectionOpenDevice;
        if (!usbDeviceConnectionOpenDevice.claimInterface(this.usbInterface, true)) {
            throw new IOException("Failed to claim USB interface");
        }
        this.outputStream = new UsbOutputStream(this.connection, this.outEndpoint);
        this.inputStream = new UsbInputStream(this.connection, this.inEndpoint);
    }

    public String getDeviceIdString() throws ConnectionException {
        byte[] bArr = new byte[256];
        int iControlTransfer = this.connection.controlTransfer(ShapeTypes.ACTION_BUTTON_BLANK, 0, 0, 0, bArr, 256, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
        if (iControlTransfer > 0) {
            return new String(bArr, 2, iControlTransfer - 2);
        }
        throw new ConnectionException("Unable to retrieve Device ID");
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void setReadTimeout(int i) {
        ((UsbInputStream) this.inputStream).setReadTimeout(i);
    }
}
