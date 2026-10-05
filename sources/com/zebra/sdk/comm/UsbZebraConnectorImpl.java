package com.zebra.sdk.comm;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.zebra.sdk.comm.internal.ZebraConnector;
import com.zebra.sdk.comm.internal.ZebraSocket;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class UsbZebraConnectorImpl implements ZebraConnector {
    private UsbDevice device;
    private UsbManager manager;

    public UsbZebraConnectorImpl(UsbManager usbManager, UsbDevice usbDevice) {
        this.manager = usbManager;
        this.device = usbDevice;
    }

    @Override // com.zebra.sdk.comm.internal.ZebraConnector
    public ZebraSocket open() throws ConnectionException {
        ZebraUsbSocket zebraUsbSocket = new ZebraUsbSocket(this.manager, this.device);
        try {
            zebraUsbSocket.connect();
            return zebraUsbSocket;
        } catch (IOException unused) {
            throw new ConnectionException("Cannot open USB Connection");
        }
    }
}
