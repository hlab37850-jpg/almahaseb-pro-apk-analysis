package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveredPrinterNetwork;
import com.zebra.sdk.printer.discovery.DiscoveryException;
import com.zebra.sdk.printer.discovery.DiscoveryHandler;
import com.zebra.sdk.printer.discovery.DiscoveryPacketDecodeException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.record.formula.Ref3DPtg;
import org.apache.poi.hssf.record.formula.RefNPtg;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BroadcastA {
    protected static final int DEFAULT_LATE_ARRIVAL_DELAY = 6000;
    public static final int MAX_DATAGRAM_SIZE = 600;
    protected InetAddress[] broadcastIpAddresses;
    protected DiscoveryHandler discoveryHandler;
    private int waitForResponsesTimeout;
    private static byte[] ADVANCED_DISCOVERY_REQUEST_PACKET = {46, RefNPtg.sid, Ref3DPtg.sid, 1, 0, 0, 0, 1, -92, -19, 0, 0, 0};
    public static byte[] DISCOVERY_REQUEST_PACKET = {46, RefNPtg.sid, Ref3DPtg.sid, 1, 0, 0};
    private final int DISCOVERY_PORT = 4201;
    private Map<String, String> discoveredPrinters = new HashMap();

    public BroadcastA(int i) {
        this.waitForResponsesTimeout = i;
    }

    private ZebraDiscoSocket createDiscoverySocket() {
        ZebraDiscoSocket zebraDiscoSocketCreateDiscoSocket = createDiscoSocket();
        setSocketOptions(zebraDiscoSocketCreateDiscoSocket);
        zebraDiscoSocketCreateDiscoSocket.setSoTimeout(this.waitForResponsesTimeout);
        return zebraDiscoSocketCreateDiscoSocket;
    }

    private void getDiscoveryResponses(ZebraDiscoSocket zebraDiscoSocket, DatagramPacket datagramPacket) throws DiscoveryPacketDecodeException {
        do {
            try {
                zebraDiscoSocket.receive(datagramPacket);
                DiscoveredPrinterNetwork discoveredPrinterNetwork = DiscoveredPrinterNetworkFactory.getDiscoveredPrinterNetwork(datagramPacket.getData());
                if (!this.discoveredPrinters.containsKey(discoveredPrinterNetwork.address) && !discoveredPrinterNetwork.address.equals("0.0.0.0")) {
                    this.discoveryHandler.foundPrinter(discoveredPrinterNetwork);
                    this.discoveredPrinters.put(discoveredPrinterNetwork.address, discoveredPrinterNetwork.getDiscoveryDataMap().get("DNS_NAME"));
                }
            } catch (IOException unused) {
                return;
            }
        } while (!shouldExitOnceAPrinterIsFound());
    }

    private void sendDiscoveryRequest(ZebraDiscoSocket zebraDiscoSocket, DatagramPacket datagramPacket) {
        for (int i = 0; i < this.broadcastIpAddresses.length; i++) {
            datagramPacket.setSocketAddress(new InetSocketAddress(this.broadcastIpAddresses[i], 4201));
            zebraDiscoSocket.send(datagramPacket);
        }
    }

    private void startDiscoveryInBackground() {
        new Thread(new Runnable() { // from class: com.zebra.sdk.printer.discovery.internal.BroadcastA.1
            @Override // java.lang.Runnable
            public void run() {
                if (BroadcastA.this.doDiscovery()) {
                    BroadcastA.this.discoveryHandler.discoveryFinished();
                }
            }
        }).start();
    }

    public ZebraDiscoSocket createDiscoSocket() {
        return new ZebraDiscoSocketImpl();
    }

    public DatagramPacket createDiscoveryRequestPacket() {
        byte[] bArr = ADVANCED_DISCOVERY_REQUEST_PACKET;
        return new DatagramPacket(bArr, bArr.length);
    }

    public void doBroadcast(DiscoveryHandler discoveryHandler) throws DiscoveryException {
        if (discoveryHandler == null) {
            throw new DiscoveryException("A DiscoveryHandler must be supplied");
        }
        this.discoveryHandler = discoveryHandler;
        startDiscoveryInBackground();
    }

    public boolean doDiscovery() {
        try {
            ZebraDiscoSocket zebraDiscoSocketCreateDiscoverySocket = createDiscoverySocket();
            DatagramPacket datagramPacketCreateDiscoveryRequestPacket = createDiscoveryRequestPacket();
            DatagramPacket datagramPacket = new DatagramPacket(new byte[600], 600);
            sendDiscoveryRequest(zebraDiscoSocketCreateDiscoverySocket, datagramPacketCreateDiscoveryRequestPacket);
            getDiscoveryResponses(zebraDiscoSocketCreateDiscoverySocket, datagramPacket);
            zebraDiscoSocketCreateDiscoverySocket.close();
            return true;
        } catch (DiscoveryException | DiscoveryPacketDecodeException | IOException e) {
            this.discoveryHandler.discoveryError(e.getMessage());
            return false;
        }
    }

    public abstract void setSocketOptions(ZebraDiscoSocket zebraDiscoSocket);

    public boolean shouldExitOnceAPrinterIsFound() {
        return false;
    }
}
