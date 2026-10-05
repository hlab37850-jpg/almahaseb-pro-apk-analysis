package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.ConnectionInfo;
import com.zebra.sdk.comm.internal.MultichannelTcpConnectionReestablisher;
import com.zebra.sdk.comm.internal.NotMyConnectionDataException;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.util.internal.RegexUtil;
import com.zebra.sdk.util.internal.StringUtilities;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MultichannelTcpConnection extends MultichannelConnection {
    public static final int DEFAULT_MULTICHANNEL_PRINTING_PORT = 9100;
    public static final int DEFAULT_MULTICHANNEL_STATUS_PORT = 9200;

    public MultichannelTcpConnection(ConnectionInfo connectionInfo) throws NotMyConnectionDataException {
        int i;
        int i2;
        String myData = connectionInfo.getMyData();
        List<String> matches = RegexUtil.getMatches("^\\s*((?i)" + getConnectionBuilderPrefix() + ":)?([\\d]{1,3}.[\\d]{1,3}.[\\d]{1,3}.[\\d]{1,3})(:([\\d]{1,5}))?(:([\\d]{1,5}))?\\s*$", myData);
        if (matches.isEmpty()) {
            if (myData.contains("zebra.com/apps/r/nfc?") && myData.contains("mB=")) {
                throw new NotMyConnectionDataException("TCP Connection doesn't understand " + myData);
            }
            matches = RegexUtil.getMatches("^\\s*((?i)" + getConnectionBuilderPrefix() + ":)?([^:]+)(:([\\d]{1,5}))?(:([\\d]{1,5}))?\\s*$", myData);
            if (matches.isEmpty()) {
                throw new NotMyConnectionDataException(getConnectionBuilderPrefix() + " Connection doesn't understand " + myData);
            }
        }
        String str = matches.get(2);
        try {
            i = Integer.parseInt(matches.get(4));
        } catch (Exception unused) {
            i = 9100;
        }
        try {
            i2 = Integer.parseInt(matches.get(6));
        } catch (Exception unused2) {
            i2 = 9200;
        }
        init(str, i, i2, 5000, 500, 5000, 500);
    }

    public String getConnectionBuilderPrefix() {
        return "TCP_MULTI";
    }

    @Override // com.zebra.sdk.comm.MultichannelConnection, com.zebra.sdk.comm.Connection
    public ConnectionReestablisher getConnectionReestablisher(long j) {
        return new MultichannelTcpConnectionReestablisher(this, j);
    }

    @Override // com.zebra.sdk.comm.Connection
    public String getSimpleConnectionName() {
        return ((TcpConnection) this.raw).getSimpleConnectionName();
    }

    public void init(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        this.raw = new TcpConnection(str, i, i3, i4);
        this.settings = new TcpStatusConnection(str, i2, i5, i6);
    }

    @Override // com.zebra.sdk.comm.Connection
    public String toString() {
        return getConnectionBuilderPrefix() + ":" + ((TcpConnection) this.raw).getAddress() + ":" + ((TcpConnection) this.raw).getPortNumber() + ":" + ((TcpStatusConnection) this.settings).getPortNumber();
    }

    public MultichannelTcpConnection(DiscoveredPrinter discoveredPrinter) {
        this(discoveredPrinter, 5000, 500);
    }

    public MultichannelTcpConnection(DiscoveredPrinter discoveredPrinter, int i, int i2) {
        this(discoveredPrinter, i, i2, i, i2);
    }

    public MultichannelTcpConnection(DiscoveredPrinter discoveredPrinter, int i, int i2, int i3, int i4) {
        Map<String, String> discoveryDataMap = discoveredPrinter.getDiscoveryDataMap();
        if (discoveryDataMap == null || discoveryDataMap.isEmpty()) {
            throw new IllegalArgumentException("The DiscoveredPrinter argument does not appear to be a Link-OS printer");
        }
        try {
            init(StringUtilities.getStringValueForKey(discoveryDataMap, "ADDRESS"), StringUtilities.getIntValueForKey(discoveryDataMap, "PORT_NUMBER"), StringUtilities.getIntValueForKey(discoveryDataMap, "JSON_PORT_NUMBER"), i, i2, i3, i4);
        } catch (RuntimeException unused) {
            throw new IllegalArgumentException("The DiscoveredPrinter argument does not appear to be a Link-OS printer");
        }
    }

    public MultichannelTcpConnection(String str, int i, int i2) {
        this(str, i, i2, 5000, 500);
    }

    public MultichannelTcpConnection(String str, int i, int i2, int i3, int i4) {
        this(str, i, i2, i3, i4, i3, i4);
    }

    public MultichannelTcpConnection(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        init(str, i, i2, i3, i4, i5, i6);
    }
}
