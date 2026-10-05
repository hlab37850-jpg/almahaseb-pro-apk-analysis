package com.zebra.sdk.printer.discovery;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.UsbConnection;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveredPrinterUsb extends DiscoveredPrinter {
    private static final long serialVersionUID = -4404949667078422761L;
    public UsbDevice device;
    public UsbManager manager;

    public DiscoveredPrinterUsb(String str, UsbManager usbManager, UsbDevice usbDevice) {
        super(str);
        this.device = usbDevice;
        this.manager = usbManager;
        this.discoSettings.put("ADDRESS", str);
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveredPrinter
    public Connection getConnection() {
        return new UsbConnection(this.manager, this.device);
    }
}
