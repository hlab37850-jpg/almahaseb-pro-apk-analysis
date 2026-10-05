package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveryException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public class LegacyDiscoveryUnicast extends BroadcastA {
    public LegacyDiscoveryUnicast(String str) {
        this(str, 6000);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public DatagramPacket createDiscoveryRequestPacket() {
        byte[] bArr = BroadcastA.DISCOVERY_REQUEST_PACKET;
        return new DatagramPacket(bArr, bArr.length);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public void setSocketOptions(ZebraDiscoSocket zebraDiscoSocket) {
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public boolean shouldExitOnceAPrinterIsFound() {
        return true;
    }

    public LegacyDiscoveryUnicast(String str, int i) throws DiscoveryException {
        super(i);
        try {
            this.broadcastIpAddresses = InetAddress.getAllByName(str);
        } catch (UnknownHostException e) {
            throw new DiscoveryException(e.getMessage());
        }
    }
}
