package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.printer.PrinterReconnectionHandler;
import com.zebra.sdk.printer.ZebraPrinterFactory;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothConnectionReestablisher extends ConnectionReestablisherBase implements ConnectionReestablisher {
    public BluetoothConnectionReestablisher(Connection connection, long j) {
        super(connection, j);
    }

    @Override // com.zebra.sdk.comm.ConnectionReestablisher
    public void reestablishConnection(PrinterReconnectionHandler printerReconnectionHandler) {
        BluetoothConnection bluetoothConnection = (BluetoothConnection) this.zebraPrinterConnection;
        BluetoothConnection bluetoothConnection2 = new BluetoothConnection(bluetoothConnection.getMACAddress(), bluetoothConnection.getMaxTimeoutForRead(), bluetoothConnection.getTimeToWaitForMoreData());
        printerReconnectionHandler.printerOnline(ZebraPrinterFactory.createLinkOsPrinter(ZebraPrinterFactory.getInstance(bluetoothConnection2)), waitForPrinterToComeOnlineViaSgdAndGetFwVer(bluetoothConnection2));
    }
}
