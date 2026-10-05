package com.zebra.android.discovery;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DiscoveredPrinter {
    public final String address;

    public DiscoveredPrinter(String str) {
        this.address = str;
    }

    public String toString() {
        return this.address;
    }
}
