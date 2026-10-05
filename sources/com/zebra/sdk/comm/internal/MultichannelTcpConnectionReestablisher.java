package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.MultichannelTcpConnection;
import com.zebra.sdk.comm.TcpConnection;
import com.zebra.sdk.comm.TcpStatusConnection;

/* JADX INFO: loaded from: classes3.dex */
public class MultichannelTcpConnectionReestablisher extends TcpConnectionReestablisher implements ConnectionReestablisher {
    public MultichannelTcpConnectionReestablisher(MultichannelConnection multichannelConnection, long j) {
        super(multichannelConnection, j);
    }

    @Override // com.zebra.sdk.comm.internal.TcpConnectionReestablisher
    public Connection getNewConnection(String str) {
        MultichannelConnection multichannelConnection = (MultichannelConnection) this.zebraPrinterConnection;
        return new MultichannelTcpConnection(str, Integer.parseInt(((TcpConnection) multichannelConnection.getPrintingChannel()).getPortNumber()), Integer.parseInt(((TcpStatusConnection) multichannelConnection.getStatusChannel()).getPortNumber()));
    }
}
