package com.zebra.sdk.printer.discovery;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.MultichannelTcpConnection;
import com.zebra.sdk.comm.TcpConnection;
import defpackage.C3344lr;
import defpackage.C3907sl;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveredPrinterNetwork extends DiscoveredPrinter {
    private static final long serialVersionUID = -8672214006905822089L;

    public DiscoveredPrinterNetwork(String str, int i) {
        super(str);
        this.discoSettings.put("ADDRESS", str);
        this.discoSettings.put("PORT_NUMBER", String.valueOf(i));
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveredPrinter
    public boolean equals(Object obj) {
        if (!(obj instanceof DiscoveredPrinterNetwork)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        DiscoveredPrinterNetwork discoveredPrinterNetwork = (DiscoveredPrinterNetwork) obj;
        String str = this.discoSettings.get("SERIAL_NUMBER");
        String str2 = "UNKNOWN";
        if (str == null || str.isEmpty()) {
            str = "UNKNOWN";
        }
        String str3 = discoveredPrinterNetwork.getDiscoveryDataMap().get("SERIAL_NUMBER");
        if (str3 != null && !str3.isEmpty()) {
            str2 = str3;
        }
        return new C3907sl().g(str.trim(), str2.trim()).g(this.address, discoveredPrinterNetwork.address).v();
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveredPrinter
    public Connection getConnection() {
        String str = this.discoSettings.get("ADDRESS");
        String str2 = this.discoSettings.get("PORT_NUMBER");
        String str3 = this.discoSettings.get("JSON_PORT_NUMBER");
        return (str3 == null || str3.length() == 0 || Integer.parseInt(str3) == 0) ? new TcpConnection(str, Integer.parseInt(str2)) : new MultichannelTcpConnection(str, Integer.parseInt(str2), Integer.parseInt(str3));
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveredPrinter
    public int hashCode() {
        String str = this.discoSettings.get("SERIAL_NUMBER");
        if (str == null || str.isEmpty()) {
            str = "UNKNOWN";
        }
        return new C3344lr(47, 3).g(this.address).g(str.trim()).t();
    }

    public DiscoveredPrinterNetwork(Map<String, String> map) {
        super(map.get("ADDRESS"));
        this.discoSettings = map;
    }
}
