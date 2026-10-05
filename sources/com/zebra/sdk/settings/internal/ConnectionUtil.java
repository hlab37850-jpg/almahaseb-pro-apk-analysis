package com.zebra.sdk.settings.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.MultichannelConnection;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectionUtil {
    public static Connection selectConnection(Connection connection) {
        if (!(connection instanceof MultichannelConnection)) {
            return connection;
        }
        MultichannelConnection multichannelConnection = (MultichannelConnection) connection;
        return multichannelConnection.getStatusChannel().isConnected() ? multichannelConnection.getStatusChannel() : multichannelConnection.getPrintingChannel();
    }
}
