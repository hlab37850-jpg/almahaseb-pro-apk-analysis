package com.zebra.android.discovery;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveredPrinterNetwork extends DiscoveredPrinter {
    public String dnsName;
    public final int port;

    public DiscoveredPrinterNetwork(String str, int i) {
        super(str);
        this.port = i;
        this.dnsName = str;
    }
}
