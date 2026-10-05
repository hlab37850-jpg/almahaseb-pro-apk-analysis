package com.zebra.sdk.printer.discovery;

import com.zebra.sdk.comm.Connection;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DiscoveredPrinter implements Serializable {
    private static final long serialVersionUID = 5598511030343358383L;
    public final String address;
    protected Map<String, String> discoSettings = new HashMap();

    public DiscoveredPrinter(String str) {
        this.address = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DiscoveredPrinter) {
            return ((DiscoveredPrinter) obj).address.equals(this.address);
        }
        return false;
    }

    public abstract Connection getConnection();

    public Map<String, String> getDiscoveryDataMap() {
        return this.discoSettings;
    }

    public int hashCode() {
        return ("DiscoveredPrinter" + this.address).hashCode();
    }

    public String toString() {
        return this.address;
    }
}
