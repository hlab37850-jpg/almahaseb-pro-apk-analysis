package com.zebra.sdk.printer.discovery;

import com.zebra.sdk.printer.discovery.internal.DirectedBroadcast;
import com.zebra.sdk.printer.discovery.internal.FindPrinters;
import com.zebra.sdk.printer.discovery.internal.LocalBroadcast;
import com.zebra.sdk.printer.discovery.internal.MulticastBroadcast;
import com.zebra.sdk.printer.discovery.internal.PrinterNameSearch;
import com.zebra.sdk.printer.discovery.internal.SubnetSearch;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkDiscoverer {
    private NetworkDiscoverer() {
    }

    public static void directedBroadcast(DiscoveryHandler discoveryHandler, String str) throws DiscoveryException {
        new DirectedBroadcast(str).doBroadcast(discoveryHandler);
    }

    public static void findPrinters(DiscoveryHandler discoveryHandler) {
        new FindPrinters().doBroadcast(discoveryHandler);
    }

    public static void localBroadcast(DiscoveryHandler discoveryHandler) throws DiscoveryException {
        new LocalBroadcast().doBroadcast(discoveryHandler);
    }

    public static void multicast(DiscoveryHandler discoveryHandler, int i) throws DiscoveryException {
        new MulticastBroadcast(i).doBroadcast(discoveryHandler);
    }

    public static void subnetSearch(DiscoveryHandler discoveryHandler, String str) {
        new SubnetSearch(str).doBroadcast(discoveryHandler);
    }

    public static void directedBroadcast(DiscoveryHandler discoveryHandler, String str, int i) throws DiscoveryException {
        new DirectedBroadcast(str, i).doBroadcast(discoveryHandler);
    }

    public static void findPrinters(DiscoveryHandler discoveryHandler, List<String> list) throws DiscoveryException {
        new PrinterNameSearch(discoveryHandler, list).doBroadcast(discoveryHandler);
    }

    public static void localBroadcast(DiscoveryHandler discoveryHandler, int i) throws DiscoveryException {
        new LocalBroadcast(i).doBroadcast(discoveryHandler);
    }

    public static void multicast(DiscoveryHandler discoveryHandler, int i, int i2) throws DiscoveryException {
        new MulticastBroadcast(i, i2).doBroadcast(discoveryHandler);
    }

    public static void subnetSearch(DiscoveryHandler discoveryHandler, String str, int i) throws DiscoveryException {
        new SubnetSearch(str, i).doBroadcast(discoveryHandler);
    }

    public static void findPrinters(DiscoveryHandler discoveryHandler, List<String> list, int i) throws DiscoveryException {
        new PrinterNameSearch(discoveryHandler, list, i).doBroadcast(discoveryHandler);
    }
}
