package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterNetwork;
import com.zebra.sdk.printer.discovery.DiscoveryPacketDecodeException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveredPrinterNetworkFactory {
    private static final int ADVANCED_DISCOVERY_VERSION = 4;
    private static final int DISCOVERY_VERSION_OFFSET = 3;
    private static final int LEGACY_DISCOVERY_VERSION = 3;

    private DiscoveredPrinterNetworkFactory() {
    }

    public static DiscoveredPrinterNetwork getDiscoveredPrinterNetwork(byte[] bArr) throws DiscoveryPacketDecodeException {
        if (bArr == null || bArr.length <= 3) {
            throw new DiscoveryPacketDecodeException("Unable to parse the supplied discovery packet due to an invalid discovery packet length");
        }
        int discoveryVersionNumber = getDiscoveryVersionNumber(bArr);
        if (discoveryVersionNumber == 3) {
            return new DiscoveryPacketDecoderLegacy(bArr).getDiscoveredPrinterNetwork();
        }
        if (discoveryVersionNumber == 4) {
            return new DiscoveryPacketDecoderAdvanced(bArr).getDiscoveredPrinterNetworkAdvanced();
        }
        throw new DiscoveryPacketDecodeException("Unable to parse the supplied discovery packet due to an invalid discovery packet version");
    }

    private static int getDiscoveryVersionNumber(byte[] bArr) {
        byte b = bArr[3];
        return b < 0 ? b + 256 : b;
    }

    public static boolean isLinkOsPrinter(DiscoveredPrinter discoveredPrinter) {
        Map<String, String> discoveryDataMap = discoveredPrinter.getDiscoveryDataMap();
        if (discoveryDataMap == null || !discoveryDataMap.containsKey("LINK_OS_MAJOR_VER")) {
            return false;
        }
        try {
            return Integer.parseInt(discoveryDataMap.get("LINK_OS_MAJOR_VER")) != 0;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
