package com.zebra.sdk.printer.discovery;

/* JADX INFO: loaded from: classes3.dex */
public interface DiscoveryHandler {
    void discoveryError(String str);

    void discoveryFinished();

    void foundPrinter(DiscoveredPrinter discoveredPrinter);
}
