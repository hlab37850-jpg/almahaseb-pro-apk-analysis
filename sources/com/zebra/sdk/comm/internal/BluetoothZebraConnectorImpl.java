package com.zebra.sdk.comm.internal;

import android.bluetooth.BluetoothAdapter;
import com.zebra.sdk.comm.ConnectionChannel;
import com.zebra.sdk.comm.ConnectionException;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothZebraConnectorImpl implements ZebraConnector {
    private String channelId;
    private String macAddress;

    public BluetoothZebraConnectorImpl(String str, ConnectionChannel connectionChannel) {
        this.channelId = BluetoothUuids.PRINTING_CHANNEL_ID;
        this.macAddress = str;
        if (connectionChannel == ConnectionChannel.STATUS_CHANNEL) {
            this.channelId = BluetoothUuids.STATUS_CHANNEL_ID;
        }
    }

    @Override // com.zebra.sdk.comm.internal.ZebraConnector
    public ZebraSocket open() throws ConnectionException {
        try {
            ZebraBluetoothSocket zebraBluetoothSocket = new ZebraBluetoothSocket(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.macAddress).createRfcommSocketToServiceRecord(UUID.fromString(this.channelId)));
            zebraBluetoothSocket.connect();
            return zebraBluetoothSocket;
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
