package com.zebra.android.discovery;

import com.zebra.android.printer.internal.LegacyDiscoveryHandlerConverter;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkDiscoverer {
    private NetworkDiscoverer() {
    }

    public static void directedBroadcast(DiscoveryHandler discoveryHandler, String str) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.directedBroadcast(new LegacyDiscoveryHandlerConverter(discoveryHandler), str);
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }

    public static void findPrinters(DiscoveryHandler discoveryHandler) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.findPrinters(new LegacyDiscoveryHandlerConverter(discoveryHandler));
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }

    public static void localBroadcast(DiscoveryHandler discoveryHandler) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.localBroadcast(new LegacyDiscoveryHandlerConverter(discoveryHandler));
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }

    public static void multicast(DiscoveryHandler discoveryHandler, int i) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.multicast(new LegacyDiscoveryHandlerConverter(discoveryHandler), i);
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }

    public static void subnetSearch(DiscoveryHandler discoveryHandler, String str) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.subnetSearch(new LegacyDiscoveryHandlerConverter(discoveryHandler), str);
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }

    public static void directedBroadcast(DiscoveryHandler discoveryHandler, String str, int i) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.directedBroadcast(new LegacyDiscoveryHandlerConverter(discoveryHandler), str, i);
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }

    public static void localBroadcast(DiscoveryHandler discoveryHandler, int i) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.localBroadcast(new LegacyDiscoveryHandlerConverter(discoveryHandler), i);
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }

    public static void multicast(DiscoveryHandler discoveryHandler, int i, int i2) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.multicast(new LegacyDiscoveryHandlerConverter(discoveryHandler), i, i2);
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }

    public static void subnetSearch(DiscoveryHandler discoveryHandler, String str, int i) throws DiscoveryException {
        try {
            com.zebra.sdk.printer.discovery.NetworkDiscoverer.subnetSearch(new LegacyDiscoveryHandlerConverter(discoveryHandler), str, i);
        } catch (com.zebra.sdk.printer.discovery.DiscoveryException e) {
            throw new DiscoveryException(e.getLocalizedMessage());
        }
    }
}
