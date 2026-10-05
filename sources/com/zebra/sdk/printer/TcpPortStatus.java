package com.zebra.sdk.printer;

/* JADX INFO: loaded from: classes3.dex */
public class TcpPortStatus {
    private String portName;
    private String printerPort;
    private String remoteIpAddress;
    private String remotePort;
    private String status;

    public TcpPortStatus(String str, String str2, String str3, String str4, String str5) {
        this.printerPort = str;
        this.portName = str2;
        this.remoteIpAddress = str3;
        this.remotePort = str4;
        this.status = str5;
    }

    public String getPortName() {
        return this.portName;
    }

    public String getPrinterPort() {
        return this.printerPort;
    }

    public String getRemoteIpAddress() {
        return this.remoteIpAddress;
    }

    public String getRemotePort() {
        return this.remotePort;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return this.printerPort + "(" + this.portName + ") " + this.remoteIpAddress + ":" + this.remotePort + " " + this.status;
    }
}
