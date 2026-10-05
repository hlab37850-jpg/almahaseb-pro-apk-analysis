package com.zebra.sdk.printer.discovery.internal;

import java.net.DatagramPacket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraDiscoSocket {
    void close();

    void joinGroup(String str);

    void receive(DatagramPacket datagramPacket);

    void send(DatagramPacket datagramPacket);

    void setInterface(InetAddress inetAddress);

    void setSoTimeout(int i);

    void setTimeToLive(int i);
}
