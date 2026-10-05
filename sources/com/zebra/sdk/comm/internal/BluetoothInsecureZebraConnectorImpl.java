package com.zebra.sdk.comm.internal;

import android.bluetooth.BluetoothAdapter;
import com.zebra.sdk.comm.ConnectionChannel;
import com.zebra.sdk.comm.ConnectionException;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothInsecureZebraConnectorImpl implements ZebraConnector {
    private String channelId;
    private String macAddress;

    public BluetoothInsecureZebraConnectorImpl(String str, ConnectionChannel connectionChannel) {
        this.channelId = BluetoothUuids.PRINTING_CHANNEL_ID;
        this.macAddress = str;
        if (connectionChannel == ConnectionChannel.STATUS_CHANNEL) {
            this.channelId = BluetoothUuids.STATUS_CHANNEL_ID;
        }
    }

    private ZebraSocket tryPublicApiWay() throws ConnectionException {
        try {
            ZebraBluetoothSocket zebraBluetoothSocket = new ZebraBluetoothSocket(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.macAddress).createInsecureRfcommSocketToServiceRecord(UUID.fromString(this.channelId)));
            zebraBluetoothSocket.connect();
            return zebraBluetoothSocket;
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.comm.internal.ZebraConnector
    public ZebraSocket open() {
        return tryPublicApiWay();
    }
}
