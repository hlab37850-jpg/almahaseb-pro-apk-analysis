package com.zebra.sdk.comm.internal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import com.zebra.sdk.comm.ConnectionChannel;
import com.zebra.sdk.printer.discovery.ServiceDiscoveryHandler;

/* JADX INFO: loaded from: classes3.dex */
public class BtServiceDiscoverer extends BroadcastReceiver {
    private BluetoothDevice device;
    private ServiceDiscoveryHandler serviceDiscoveryHandler;

    public BtServiceDiscoverer(String str, ServiceDiscoveryHandler serviceDiscoveryHandler) {
        this.serviceDiscoveryHandler = serviceDiscoveryHandler;
        this.device = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str);
    }

    private void processFoundServices(Intent intent) {
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
        if (parcelableArrayExtra != null) {
            for (Parcelable parcelable : parcelableArrayExtra) {
                ConnectionChannel connectionChannelServiceUUIDToChannel = serviceUUIDToChannel(parcelable);
                if (connectionChannelServiceUUIDToChannel != null) {
                    this.serviceDiscoveryHandler.foundService(connectionChannelServiceUUIDToChannel);
                }
            }
        }
        this.serviceDiscoveryHandler.discoveryFinished();
    }

    private ConnectionChannel serviceUUIDToChannel(Parcelable parcelable) {
        if (parcelable.toString().toUpperCase().equals(BluetoothUuids.STATUS_CHANNEL_ID)) {
            return ConnectionChannel.STATUS_CHANNEL;
        }
        if (parcelable.toString().toUpperCase().equals(BluetoothUuids.PRINTING_CHANNEL_ID)) {
            return ConnectionChannel.PRINTING_CHANNEL;
        }
        return null;
    }

    public void doDiscovery(Context context) {
        context.registerReceiver(this, new IntentFilter("android.bluetooth.device.action.UUID"));
        this.device.fetchUuidsWithSdp();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.device.action.UUID".equals(intent.getAction()) && ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(this.device.getAddress())) {
            context.unregisterReceiver(this);
            processFoundServices(intent);
        }
    }
}
