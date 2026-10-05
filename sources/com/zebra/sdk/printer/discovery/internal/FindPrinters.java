package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveryException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public class FindPrinters extends BroadcastA {
    private final String ESI_REGISTERED_MULTICAST_GROUP_ADDRESS;
    final String LOCAL_BROADCAST_ADDRESS;

    public FindPrinters() {
        super(6000);
        this.ESI_REGISTERED_MULTICAST_GROUP_ADDRESS = "224.0.1.55";
        this.LOCAL_BROADCAST_ADDRESS = "255.255.255.255";
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public boolean doDiscovery() {
        try {
            this.broadcastIpAddresses = InetAddress.getAllByName("255.255.255.255");
            if (!super.doDiscovery()) {
                return false;
            }
            this.broadcastIpAddresses = InetAddress.getAllByName("224.0.1.55");
            return super.doDiscovery();
        } catch (UnknownHostException unused) {
            this.discoveryHandler.discoveryError("Unknown host address");
            return false;
        }
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public void setSocketOptions(ZebraDiscoSocket zebraDiscoSocket) throws DiscoveryException {
        try {
            zebraDiscoSocket.setTimeToLive(3);
        } catch (IOException e) {
            throw new DiscoveryException(e.getMessage());
        }
    }
}
