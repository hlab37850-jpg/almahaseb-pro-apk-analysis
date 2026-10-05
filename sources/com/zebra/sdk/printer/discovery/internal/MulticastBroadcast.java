package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveryException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public class MulticastBroadcast extends BroadcastA {
    private final String ESI_REGISTERED_MULTICAST_GROUP_ADDRESS;
    private int hops;

    public MulticastBroadcast(int i) {
        this(i, 6000);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public void setSocketOptions(ZebraDiscoSocket zebraDiscoSocket) throws DiscoveryException {
        try {
            zebraDiscoSocket.joinGroup("224.0.1.55");
            zebraDiscoSocket.setTimeToLive(this.hops);
        } catch (IOException e) {
            throw new DiscoveryException(e.getMessage());
        }
    }

    public MulticastBroadcast(int i, int i2) throws DiscoveryException {
        super(i2);
        this.ESI_REGISTERED_MULTICAST_GROUP_ADDRESS = "224.0.1.55";
        this.hops = 0;
        if (i < 0) {
            throw new DiscoveryException(i + " is an invalid multicast hop argument");
        }
        this.hops = i;
        try {
            this.broadcastIpAddresses = InetAddress.getAllByName("224.0.1.55");
        } catch (UnknownHostException e) {
            throw new DiscoveryException(e.getMessage());
        }
    }
}
