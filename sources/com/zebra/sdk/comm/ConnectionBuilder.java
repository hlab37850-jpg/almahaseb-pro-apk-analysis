package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.ConnectionBuilderInternal;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectionBuilder {
    private ConnectionBuilder() {
    }

    public static void addConnectionType(Class<? extends Connection> cls) {
        ConnectionBuilderInternal.addConnectionType(cls);
    }

    public static Connection build(String str) {
        return ConnectionBuilderInternal.build(str);
    }

    private static void initializeClasses() {
        addConnectionType(MultichannelTcpConnection.class);
        addConnectionType(TcpConnection.class);
        addConnectionType(TcpStatusConnection.class);
        addConnectionType(MultichannelBluetoothConnection.class);
        addConnectionType(BluetoothConnectionInsecure.class);
        addConnectionType(BluetoothConnection.class);
        addConnectionType(BluetoothStatusConnectionInsecure.class);
        addConnectionType(BluetoothStatusConnection.class);
    }
}
