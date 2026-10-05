package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.BluetoothHelper;
import com.zebra.sdk.comm.internal.BluetoothInsecureZebraConnectorImpl;
import com.zebra.sdk.comm.internal.ConnectionInfo;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothStatusConnectionInsecure extends BluetoothStatusConnection {
    public BluetoothStatusConnectionInsecure(ConnectionInfo connectionInfo) {
        super(connectionInfo);
    }

    public BluetoothStatusConnectionInsecure(String str) {
        this(str, 5000, 500);
    }

    public BluetoothStatusConnectionInsecure(String str, int i, int i2) {
        super(new BluetoothInsecureZebraConnectorImpl(BluetoothHelper.formatMacAddress(str), ConnectionChannel.STATUS_CHANNEL), BluetoothHelper.formatMacAddress(str), i, i2);
    }
}
