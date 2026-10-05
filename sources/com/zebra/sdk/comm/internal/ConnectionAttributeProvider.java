package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.Connection;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectionAttributeProvider {
    static Map<Connection, ConnectionAttributes> connectionAttributes = new WeakHashMap();

    public ConnectionAttributes getAttributes(Connection connection) {
        if (connectionAttributes.get(connection) == null) {
            connectionAttributes.put(connection, new ConnectionAttributes());
        }
        return connectionAttributes.get(connection);
    }
}
