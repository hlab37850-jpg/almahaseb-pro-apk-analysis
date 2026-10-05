package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveryException;
import com.zebra.sdk.printer.discovery.DiscoveryHandler;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterNameSearch extends BroadcastA {
    public PrinterNameSearch(DiscoveryHandler discoveryHandler, List<String> list) {
        this(discoveryHandler, list, 6000);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public void setSocketOptions(ZebraDiscoSocket zebraDiscoSocket) {
    }

    public PrinterNameSearch(DiscoveryHandler discoveryHandler, List<String> list, int i) throws DiscoveryException {
        super(i);
        if (discoveryHandler == null) {
            throw new DiscoveryException("A DiscoveryHandler must be supplied");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                arrayList.add(InetAddress.getByName(str));
            } catch (UnknownHostException unused) {
                discoveryHandler.discoveryError("An invalid printer name/ip address was provided: " + str);
            }
        }
        this.broadcastIpAddresses = (InetAddress[]) arrayList.toArray(new InetAddress[0]);
    }
}
