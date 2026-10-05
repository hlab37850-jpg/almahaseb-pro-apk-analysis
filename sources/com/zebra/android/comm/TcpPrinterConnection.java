package com.zebra.android.comm;

import com.zebra.sdk.comm.TcpConnection;

/* JADX INFO: loaded from: classes3.dex */
public class TcpPrinterConnection extends ZebraPrinterConnectionA {
    public static final int DEFAULT_CPCL_TCP_PORT = 6101;
    public static final int DEFAULT_ZPL_TCP_PORT = 9100;

    public TcpPrinterConnection(String str, int i) {
        super(new TcpConnection(str, i));
    }

    public String getAddress() {
        return ((TcpConnection) this.myDelegator).getAddress();
    }

    public String getPortNumber() {
        return ((TcpConnection) this.myDelegator).getPortNumber();
    }

    @Override // com.zebra.android.comm.ZebraPrinterConnection
    public String toString() {
        return "TCP:" + getAddress() + ":" + getPortNumber();
    }

    public TcpPrinterConnection(String str, int i, int i2, int i3) {
        super(new TcpConnection(str, i, i2, i3));
    }
}
