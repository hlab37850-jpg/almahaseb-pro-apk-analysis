package com.zebra.sdk.printer;

import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.util.internal.StringUtilities;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LinkOsInformation {
    private int major = -1;
    private int minor = -1;

    public LinkOsInformation(int i, int i2) {
        init(i, i2);
    }

    private void init(int i, int i2) {
        this.major = i;
        this.minor = i2;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public LinkOsInformation(DiscoveredPrinter discoveredPrinter) {
        try {
            Map<String, String> discoveryDataMap = discoveredPrinter.getDiscoveryDataMap();
            if (discoveryDataMap.containsKey("LINK_OS_MAJOR_VER") && discoveryDataMap.containsKey("LINK_OS_MINOR_VER")) {
                init(StringUtilities.getIntValueForKey(discoveryDataMap, "LINK_OS_MAJOR_VER"), StringUtilities.getIntValueForKey(discoveryDataMap, "LINK_OS_MINOR_VER"));
            } else {
                init(-1, -1);
            }
        } catch (RuntimeException unused) {
            throw new IllegalArgumentException("The DiscoveredPrinter argument does not appear to be a Link-OS printer");
        }
    }

    public LinkOsInformation(String str) {
        if (str != null && !str.isEmpty()) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length == 2) {
                try {
                    init(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
                    return;
                } catch (Exception unused) {
                }
            }
        }
        init(1, 0);
    }
}
