package com.zebra.sdk.comm.internal;

import android.hardware.usb.UsbDevice;
import androidx.work.WorkRequest;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.comm.UsbConnection;
import com.zebra.sdk.comm.UsbPermissionRequestor;
import com.zebra.sdk.printer.PrinterReconnectionHandler;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterUsb;
import com.zebra.sdk.printer.discovery.DiscoveryHandler;
import com.zebra.sdk.printer.discovery.UsbDiscoverer;
import com.zebra.sdk.util.internal.Sleeper;

/* JADX INFO: loaded from: classes3.dex */
public class UsbConnectionReestablisher extends ConnectionReestablisherBase implements ConnectionReestablisher {
    private UsbDevice device;

    public UsbConnectionReestablisher(Connection connection, long j) {
        super(connection, j);
        this.device = null;
    }

    @Override // com.zebra.sdk.comm.ConnectionReestablisher
    public void reestablishConnection(PrinterReconnectionHandler printerReconnectionHandler) {
        this.device = null;
        this.startTime = System.currentTimeMillis();
        UsbConnection usbConnection = (UsbConnection) this.zebraPrinterConnection;
        UsbPermissionRequestor requestor = usbConnection.getRequestor();
        while (true) {
            UsbDiscoverer.findPrinters(usbConnection.getManager(), new DiscoveryHandler() { // from class: com.zebra.sdk.comm.internal.UsbConnectionReestablisher.1
                @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
                public void discoveryError(String str) {
                }

                @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
                public void discoveryFinished() {
                }

                @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
                public void foundPrinter(DiscoveredPrinter discoveredPrinter) {
                    if (discoveredPrinter instanceof DiscoveredPrinterUsb) {
                        UsbConnectionReestablisher.this.device = ((DiscoveredPrinterUsb) discoveredPrinter).device;
                    }
                }
            });
            if (this.device != null) {
                break;
            }
            Sleeper.sleep(WorkRequest.MIN_BACKOFF_MILLIS);
            timeoutCheck();
        }
        if (!usbConnection.getManager().hasPermission(this.device) && requestor != null) {
            requestor.requestUsbPermission(this.device);
        }
        while (!usbConnection.getManager().hasPermission(this.device)) {
            Sleeper.sleep(2000L);
            timeoutCheck();
        }
        UsbConnection usbConnection2 = new UsbConnection(usbConnection.getManager(), this.device);
        printerReconnectionHandler.printerOnline(ZebraPrinterFactory.createLinkOsPrinter(ZebraPrinterFactory.getInstance(usbConnection2)), waitForPrinterToComeOnlineViaSgdAndGetFwVer(usbConnection2));
    }
}
