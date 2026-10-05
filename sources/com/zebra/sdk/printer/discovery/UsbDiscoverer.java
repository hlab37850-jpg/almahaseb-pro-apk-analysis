package com.zebra.sdk.printer.discovery;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;

/* JADX INFO: loaded from: classes3.dex */
public class UsbDiscoverer {
    private static final int ZEBRA_USB_VID = 2655;

    public static void findPrinters(Context context, DiscoveryHandler discoveryHandler) {
        findPrinters((UsbManager) context.getSystemService("usb"), discoveryHandler);
    }

    public static boolean isZebraUsbDevice(UsbDevice usbDevice) {
        return usbDevice != null && usbDevice.getVendorId() == ZEBRA_USB_VID;
    }

    public static void findPrinters(UsbManager usbManager, DiscoveryHandler discoveryHandler) {
        if (usbManager != null) {
            for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
                if (isZebraUsbDevice(usbDevice)) {
                    discoveryHandler.foundPrinter(new DiscoveredPrinterUsb(usbDevice.getDeviceName(), usbManager, usbDevice));
                }
            }
        }
        discoveryHandler.discoveryFinished();
    }
}
