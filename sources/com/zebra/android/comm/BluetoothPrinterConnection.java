package com.zebra.android.comm;

import com.zebra.sdk.comm.BluetoothConnection;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothPrinterConnection extends ZebraPrinterConnectionA {
    public BluetoothPrinterConnection(String str) {
        super(new BluetoothConnection(str));
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnectionA, com.zebra.android.comm.ZebraPrinterConnection
    public void close() throws ZebraPrinterConnectionException {
        super.close();
    }

    public String getFriendlyName() {
        return ((BluetoothConnection) this.myDelegator).getFriendlyName();
    }

    public String getMACAddress() {
        return ((BluetoothConnection) this.myDelegator).getMACAddress();
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnectionA, com.zebra.android.comm.ZebraPrinterConnection
    public void open() throws ZebraPrinterConnectionException {
        super.open();
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public String toString() {
        return "Bluetooth:" + getMACAddress() + ":" + getFriendlyName();
    }

    public BluetoothPrinterConnection(String str, int i, int i2) {
        super(new BluetoothConnection(str, i, i2));
    }
}
