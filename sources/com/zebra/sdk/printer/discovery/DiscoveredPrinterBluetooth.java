package com.zebra.sdk.printer.discovery;

import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveredPrinterBluetooth extends DiscoveredPrinter {
    private static final long serialVersionUID = 5508338175147482836L;
    public final String friendlyName;

    public DiscoveredPrinterBluetooth(String str, String str2) {
        super(str);
        this.friendlyName = str2;
        this.discoSettings.put("MAC_ADDRESS", this.address);
        this.discoSettings.put("FRIENDLY_NAME", str2);
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveredPrinter
    public Connection getConnection() {
        return new BluetoothConnection(this.address);
    }
}
