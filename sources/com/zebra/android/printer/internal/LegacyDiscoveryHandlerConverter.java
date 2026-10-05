package com.zebra.android.printer.internal;

import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterBluetooth;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterNetwork;
import com.zebra.sdk.printer.discovery.DiscoveryHandler;

/* JADX INFO: loaded from: classes3.dex */
public class LegacyDiscoveryHandlerConverter implements DiscoveryHandler {
    private com.zebra.android.discovery.DiscoveryHandler oldDiscoHandler;

    public LegacyDiscoveryHandlerConverter(com.zebra.android.discovery.DiscoveryHandler discoveryHandler) {
        this.oldDiscoHandler = discoveryHandler;
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
    public void discoveryError(String str) {
        this.oldDiscoHandler.discoveryError(str);
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
    public void discoveryFinished() {
        this.oldDiscoHandler.discoveryFinished();
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
    public void foundPrinter(DiscoveredPrinter discoveredPrinter) {
        com.zebra.android.discovery.DiscoveredPrinter discoveredPrinterNetwork;
        if (discoveredPrinter instanceof DiscoveredPrinterBluetooth) {
            DiscoveredPrinterBluetooth discoveredPrinterBluetooth = (DiscoveredPrinterBluetooth) discoveredPrinter;
            discoveredPrinterNetwork = new com.zebra.android.discovery.DiscoveredPrinterBluetooth(discoveredPrinterBluetooth.address, discoveredPrinterBluetooth.friendlyName);
        } else {
            DiscoveredPrinterNetwork discoveredPrinterNetwork2 = (DiscoveredPrinterNetwork) discoveredPrinter;
            discoveredPrinterNetwork = new com.zebra.android.discovery.DiscoveredPrinterNetwork(discoveredPrinterNetwork2.address, Integer.parseInt(discoveredPrinterNetwork2.getDiscoveryDataMap().get("PORT_NUMBER")));
        }
        this.oldDiscoHandler.foundPrinter(discoveredPrinterNetwork);
    }
}
