package com.zebra.sdk.printer.discovery;

import com.zebra.sdk.printer.discovery.internal.DiscoveredPrinterNetworkFactory;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveryHandlerLinkOsOnly implements DiscoveryHandler {
    DiscoveryHandler myDiscoveryHandler;

    public DiscoveryHandlerLinkOsOnly(DiscoveryHandler discoveryHandler) {
        this.myDiscoveryHandler = discoveryHandler;
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
    public void discoveryError(String str) {
        this.myDiscoveryHandler.discoveryError(str);
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
    public void discoveryFinished() {
        this.myDiscoveryHandler.discoveryFinished();
    }

    @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
    public void foundPrinter(DiscoveredPrinter discoveredPrinter) {
        if (DiscoveredPrinterNetworkFactory.isLinkOsPrinter(discoveredPrinter)) {
            this.myDiscoveryHandler.foundPrinter(discoveredPrinter);
        }
    }
}
