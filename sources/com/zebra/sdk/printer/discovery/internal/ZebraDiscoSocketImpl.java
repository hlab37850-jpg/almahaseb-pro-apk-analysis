package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveryException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraDiscoSocketImpl implements ZebraDiscoSocket {
    private MulticastSocket mySocket;

    public ZebraDiscoSocketImpl() throws DiscoveryException {
        try {
            this.mySocket = new MulticastSocket();
        } catch (IOException e) {
            throw new DiscoveryException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.printer.discovery.internal.ZebraDiscoSocket
    public void close() {
        this.mySocket.close();
    }

    @Override // com.zebra.sdk.printer.discovery.internal.ZebraDiscoSocket
    public void joinGroup(String str) throws IOException {
        this.mySocket.joinGroup(InetAddress.getByName(str));
    }

    @Override // com.zebra.sdk.printer.discovery.internal.ZebraDiscoSocket
    public void receive(DatagramPacket datagramPacket) throws IOException {
        this.mySocket.receive(datagramPacket);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.ZebraDiscoSocket
    public void send(DatagramPacket datagramPacket) throws IOException {
        this.mySocket.send(datagramPacket);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.ZebraDiscoSocket
    public void setInterface(InetAddress inetAddress) throws SocketException {
        this.mySocket.setInterface(inetAddress);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.ZebraDiscoSocket
    public void setSoTimeout(int i) throws SocketException {
        this.mySocket.setSoTimeout(i);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.ZebraDiscoSocket
    public void setTimeToLive(int i) throws IOException {
        this.mySocket.setTimeToLive(i);
    }
}
