package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.BluetoothHelper;
import com.zebra.sdk.comm.internal.BluetoothInsecureZebraConnectorImpl;
import com.zebra.sdk.comm.internal.ConnectionInfo;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothConnectionInsecure extends BluetoothConnection {
    public BluetoothConnectionInsecure(ConnectionInfo connectionInfo) {
        super(connectionInfo);
    }

    public BluetoothConnectionInsecure(String str) {
        this(str, 5000, 500);
    }

    public BluetoothConnectionInsecure(String str, int i, int i2) {
        super(new BluetoothInsecureZebraConnectorImpl(BluetoothHelper.formatMacAddress(str), ConnectionChannel.PRINTING_CHANNEL), BluetoothHelper.formatMacAddress(str), i, i2);
    }
}
