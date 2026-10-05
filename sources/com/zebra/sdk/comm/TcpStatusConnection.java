package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.ConnectionInfo;

/* JADX INFO: loaded from: classes3.dex */
public class TcpStatusConnection extends TcpConnection implements StatusConnectionWithWriteLogging {
    public static final int DEFAULT_STATUS_TCP_PORT = 9200;

    public TcpStatusConnection(ConnectionInfo connectionInfo) {
        super(connectionInfo);
    }

    @Override // com.zebra.sdk.comm.TcpConnection
    public String getConnectionBuilderPrefix() {
        return "TCP_STATUS";
    }

    @Override // com.zebra.sdk.comm.TcpConnection
    public int getDefaultPort() {
        return 9200;
    }

    @Override // com.zebra.sdk.comm.TcpConnection, com.zebra.sdk.comm.Connection
    public String getSimpleConnectionName() {
        return getAddress();
    }

    @Override // com.zebra.sdk.comm.TcpConnection, com.zebra.sdk.comm.Connection
    public String toString() {
        return getConnectionBuilderPrefix() + ":" + getAddress() + ":" + getPortNumber();
    }

    public TcpStatusConnection(String str) {
        this(str, 9200, 5000, 500);
    }

    public TcpStatusConnection(String str, int i) {
        this(str, i, 5000, 500);
    }

    public TcpStatusConnection(String str, int i, int i2, int i3) {
        super(str, i, i2, i3);
    }
}
