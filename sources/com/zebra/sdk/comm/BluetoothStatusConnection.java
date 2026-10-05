package com.zebra.sdk.comm;

import android.bluetooth.BluetoothAdapter;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.zebra.sdk.comm.internal.BluetoothHelper;
import com.zebra.sdk.comm.internal.BluetoothZebraConnectorImpl;
import com.zebra.sdk.comm.internal.ConnectionInfo;
import com.zebra.sdk.comm.internal.NotMyConnectionDataException;
import com.zebra.sdk.comm.internal.ZebraConnector;
import com.zebra.sdk.util.internal.RegexUtil;
import com.zebra.sdk.util.internal.Sleeper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothStatusConnection extends ConnectionStatusA {
    protected static final String CONNECTION_STRING_ID = getConnectionBuilderPrefix() + ":";
    protected String friendlyName;
    protected String macAddress;

    public BluetoothStatusConnection(ConnectionInfo connectionInfo) throws NotMyConnectionDataException {
        this.friendlyName = "";
        String myData = connectionInfo.getMyData();
        List<String> matches = RegexUtil.getMatches("^\\s*(" + getConnectionBuilderPrefix() + ":)?([a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2})\\s*$", myData);
        if (matches.size() != 3) {
            matches = RegexUtil.getMatches("^\\s*(" + getConnectionBuilderPrefix() + ":)?([^:]+)\\s*$", myData);
            if (matches.size() != 3) {
                throw new NotMyConnectionDataException("BT Connection doesn't understand " + myData);
            }
            if (matches.get(1) != null) {
                matches.get(1).length();
            }
        }
        String macAddress = BluetoothHelper.formatMacAddress(matches.get(2));
        this.zebraConnector = new BluetoothZebraConnectorImpl(macAddress, ConnectionChannel.STATUS_CHANNEL);
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
        return "BT_STATUS";
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
        return "Bluetooth_STATUS:" + getMACAddress() + ":" + getFriendlyName();
    }

    public BluetoothStatusConnection(ZebraConnector zebraConnector, String str, int i, int i2) {
        this.friendlyName = "";
        this.zebraConnector = zebraConnector;
        this.macAddress = str;
        this.maxTimeoutForRead = i;
        this.timeToWaitForMoreData = i2;
    }

    public BluetoothStatusConnection(String str) {
        this(str, 5000, 500);
    }

    public BluetoothStatusConnection(String str, int i, int i2) {
        this(new BluetoothZebraConnectorImpl(BluetoothHelper.formatMacAddress(str), ConnectionChannel.STATUS_CHANNEL), BluetoothHelper.formatMacAddress(str), i, i2);
    }
}
