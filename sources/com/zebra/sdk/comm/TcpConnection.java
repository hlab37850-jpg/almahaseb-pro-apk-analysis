package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.ConnectionI;
import com.zebra.sdk.comm.internal.ConnectionInfo;
import com.zebra.sdk.comm.internal.NotMyConnectionDataException;
import com.zebra.sdk.comm.internal.TcpConnectionReestablisher;
import com.zebra.sdk.comm.internal.ZebraConnector;
import com.zebra.sdk.util.internal.ReflectionUtil;
import com.zebra.sdk.util.internal.RegexUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TcpConnection extends ConnectionA implements IpAddressable, ConnectionI {
    public static final int DEFAULT_CPCL_TCP_PORT = 6101;
    public static final int DEFAULT_ZPL_TCP_PORT = 9100;
    public boolean isCardPrinter;
    public String serialNumber;

    public TcpConnection(ConnectionInfo connectionInfo) throws NotMyConnectionDataException {
        this.isCardPrinter = false;
        this.serialNumber = "";
        String myData = connectionInfo.getMyData();
        List<String> matches = RegexUtil.getMatches("^\\s*((?i)" + getConnectionBuilderPrefix() + ":)?([\\d]{1,3}.[\\d]{1,3}.[\\d]{1,3}.[\\d]{1,3})(:([\\d]{1,5}))?\\s*$", myData);
        if (matches.isEmpty()) {
            if (myData.contains("zebra.com/apps/r/nfc?") && myData.contains("mB=")) {
                throw new NotMyConnectionDataException("TCP Connection doesn't understand " + myData);
            }
            matches = RegexUtil.getMatches("^\\s*((?i)" + getConnectionBuilderPrefix() + ":)?([^:]+)(:([\\d]{1,5}))?\\s*$", myData);
            if (matches.isEmpty()) {
                throw new NotMyConnectionDataException(getConnectionBuilderPrefix() + " Connection doesn't understand " + myData);
            }
        }
        String str = matches.get(2);
        int defaultPort = getDefaultPort();
        try {
            defaultPort = Integer.parseInt(matches.get(4));
        } catch (Exception unused) {
        }
        this.zebraConnector = new TcpZebraConnectorImpl(str, defaultPort);
        this.maxTimeoutForRead = 5000;
        this.timeToWaitForMoreData = 500;
    }

    @Override // com.zebra.sdk.comm.IpAddressable
    public String getAddress() {
        return ((TcpZebraConnectorImpl) this.zebraConnector).getAddress();
    }

    public String getConnectionBuilderPrefix() {
        return "TCP";
    }

    @Override // com.zebra.sdk.comm.ConnectionA, com.zebra.sdk.comm.Connection
    public ConnectionReestablisher getConnectionReestablisher(long j) {
        return this.isCardPrinter ? ReflectionUtil.loadTcpCardConnectionReestablisher(this, j) : new TcpConnectionReestablisher(this, j);
    }

    public int getDefaultPort() {
        return 9100;
    }

    @Override // com.zebra.sdk.comm.IpAddressable
    public String getPortNumber() {
        return String.valueOf(((TcpZebraConnectorImpl) this.zebraConnector).getPort());
    }

    @Override // com.zebra.sdk.comm.Connection
    public String getSimpleConnectionName() {
        return getAddress();
    }

    @Override // com.zebra.sdk.comm.Connection
    public String toString() {
        return "TCP:" + getAddress() + ":" + getPortNumber();
    }

    private TcpConnection(ZebraConnector zebraConnector, int i, int i2) {
        this.isCardPrinter = false;
        this.serialNumber = "";
        this.zebraConnector = zebraConnector;
        this.maxTimeoutForRead = i;
        this.timeToWaitForMoreData = i2;
    }

    public TcpConnection(String str, int i) {
        this(str, i, 5000, 500);
    }

    public TcpConnection(String str, int i, int i2, int i3) {
        this(new TcpZebraConnectorImpl(str, i), i2, i3);
    }
}
