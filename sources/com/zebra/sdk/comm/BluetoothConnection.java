package com.zebra.sdk.comm;

import android.bluetooth.BluetoothAdapter;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.zebra.sdk.comm.internal.BluetoothConnectionReestablisher;
import com.zebra.sdk.comm.internal.BluetoothHelper;
import com.zebra.sdk.comm.internal.BluetoothZebraConnectorImpl;
import com.zebra.sdk.comm.internal.ConnectionInfo;
import com.zebra.sdk.comm.internal.NotMyConnectionDataException;
import com.zebra.sdk.comm.internal.ZebraConnector;
import com.zebra.sdk.util.internal.RegexUtil;
import com.zebra.sdk.util.internal.Sleeper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothConnection extends ConnectionA {
    protected String friendlyName;
    protected String macAddress;

    public BluetoothConnection(ConnectionInfo connectionInfo) throws NotMyConnectionDataException {
        this.friendlyName = "";
        String myData = connectionInfo.getMyData();
        List<String> matches = RegexUtil.getMatches("^\\s*(" + getConnectionBuilderPrefix() + ":)?([a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2})\\s*$", myData);
        if (matches.size() != 3) {
            matches = RegexUtil.getMatches("(.*)mB=(.*?)&(.*)", myData);
            if (matches.isEmpty()) {
                matches = RegexUtil.getMatches("^\\s*(" + getConnectionBuilderPrefix() + ":)?([^:]+)\\s*$", myData);
                if (matches.isEmpty()) {
                    throw new NotMyConnectionDataException("BT Connection doesn't understand " + myData);
                }
            }
        }
        String macAddress = BluetoothHelper.formatMacAddress(matches.get(2));
        this.zebraConnector = new BluetoothZebraConnectorImpl(macAddress, ConnectionChannel.PRINTING_CHANNEL);
        this.macAddress = macAddress;
        this.maxTimeoutForRead = 5000;
        this.timeToWaitForMoreData = 500;
    }

    private void cancelBluetoothDiscovery() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            defaultAdapter.cancelDiscovery();
        }
    }

    private static String getConnectionBuilderPrefix() {
        return "BT";
    }

    private String getFriendlyNameFromDevice() throws ConnectionException {
        try {
            return BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.macAddress).getName();
        } catch (IllegalArgumentException e) {
            throw new ConnectionException("Error reading from connection: " + e.getMessage());
        }
    }

    @Override // com.zebra.sdk.comm.ConnectionA, com.zebra.sdk.comm.Connection
    public void close() {
        if (this.isConnected) {
            Sleeper.sleep(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        }
        this.friendlyName = "";
        super.close();
    }

    @Override // com.zebra.sdk.comm.ConnectionA, com.zebra.sdk.comm.Connection
    public ConnectionReestablisher getConnectionReestablisher(long j) {
        return new BluetoothConnectionReestablisher(this, j);
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public String getMACAddress() {
        return this.macAddress;
    }

    @Override // com.zebra.sdk.comm.Connection
    public String getSimpleConnectionName() {
        return getMACAddress() + ":" + getFriendlyName();
    }

    @Override // com.zebra.sdk.comm.ConnectionA, com.zebra.sdk.comm.Connection
    public void open() throws ConnectionException {
        cancelBluetoothDiscovery();
        super.open();
        this.friendlyName = getFriendlyNameFromDevice();
    }

    @Override // com.zebra.sdk.comm.Connection
    public String toString() {
        return "Bluetooth:" + getMACAddress() + ":" + getFriendlyName();
    }

    public BluetoothConnection(ZebraConnector zebraConnector, String str, int i, int i2) {
        this.friendlyName = "";
        this.zebraConnector = zebraConnector;
        this.macAddress = str;
        this.maxTimeoutForRead = i;
        this.timeToWaitForMoreData = i2;
    }

    public BluetoothConnection(String str) {
        this(str, 5000, 500);
    }

    public BluetoothConnection(String str, int i, int i2) {
        this(new BluetoothZebraConnectorImpl(BluetoothHelper.formatMacAddress(str), ConnectionChannel.PRINTING_CHANNEL), BluetoothHelper.formatMacAddress(str), i, i2);
    }
}
