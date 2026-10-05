package com.zebra.sdk.comm.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraNetworkSocket implements ZebraSocket {
    private InetSocketAddress inetSocketAddress;
    private final int MAX_TIMEOUT = 15000;
    private Socket socket = new Socket();

    public ZebraNetworkSocket(String str, int i) {
        this.inetSocketAddress = new InetSocketAddress(InetAddress.getByName(str), i);
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void close() throws IOException {
        this.socket.close();
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void connect() throws IOException {
        if (this.socket.isConnected()) {
            this.socket.close();
        }
        this.socket.connect(this.inetSocketAddress, 15000);
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public InputStream getInputStream() {
        return this.socket.getInputStream();
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public OutputStream getOutputStream() {
        return this.socket.getOutputStream();
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void setReadTimeout(int i) throws SocketException {
        this.socket.setSoTimeout(i);
    }
}
