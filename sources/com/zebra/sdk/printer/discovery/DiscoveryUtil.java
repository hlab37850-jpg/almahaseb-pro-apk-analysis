package com.zebra.sdk.printer.discovery;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.discovery.internal.DiscoveredPrinterNetworkFactory;
import com.zebra.sdk.util.internal.Base64;
import com.zebra.sdk.util.internal.SGDUtilities;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveryUtil {
    private DiscoveryUtil() {
    }

    public static Map<String, String> getDiscoveryDataMap(Connection connection) {
        return parseDiscoveryPacket(SGD.GET(SGDUtilities.DISCOVERY_NAME, connection));
    }

    public static Map<String, String> parseDiscoveryPacket(String str) throws DiscoveryPacketDecodeException {
        if (str == null) {
            throw new DiscoveryPacketDecodeException("Unable to parse the supplied discovery packet due to an invalid discovery packet length");
        }
        if (str.contains(":")) {
            str = str.substring(0, str.indexOf(58));
        }
        return DiscoveredPrinterNetworkFactory.getDiscoveredPrinterNetwork(Base64.decode(str)).getDiscoveryDataMap();
    }
}
