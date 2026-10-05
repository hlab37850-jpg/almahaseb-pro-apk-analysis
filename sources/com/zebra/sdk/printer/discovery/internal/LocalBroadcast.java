package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveryException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public class LocalBroadcast extends BroadcastA {
    private final String LOCAL_BROADCAST_ADDRESS;

    public LocalBroadcast() {
        this(6000);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public void setSocketOptions(ZebraDiscoSocket zebraDiscoSocket) {
    }

    public LocalBroadcast(int i) throws DiscoveryException {
        super(i);
        this.LOCAL_BROADCAST_ADDRESS = "255.255.255.255";
        try {
            this.broadcastIpAddresses = InetAddress.getAllByName("255.255.255.255");
        } catch (UnknownHostException e) {
            throw new DiscoveryException(e.getMessage());
        }
    }
}
