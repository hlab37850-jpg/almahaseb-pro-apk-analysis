package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.ZebraConnector;
import com.zebra.sdk.comm.internal.ZebraNetworkSocket;
import com.zebra.sdk.comm.internal.ZebraSocket;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class TcpZebraConnectorImpl implements ZebraConnector {
    private String address;
    private int port;

    public TcpZebraConnectorImpl(String str, int i) {
        this.address = str;
        this.port = i;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }

    @Override // com.zebra.sdk.comm.internal.ZebraConnector
    public ZebraSocket open() throws ConnectionException {
        try {
            ZebraNetworkSocket zebraNetworkSocket = new ZebraNetworkSocket(this.address, this.port);
            zebraNetworkSocket.connect();
            return zebraNetworkSocket;
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
