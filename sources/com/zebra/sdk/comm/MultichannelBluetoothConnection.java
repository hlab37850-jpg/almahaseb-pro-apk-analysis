package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.BluetoothHelper;
import com.zebra.sdk.comm.internal.ConnectionInfo;
import com.zebra.sdk.comm.internal.NotMyConnectionDataException;
import com.zebra.sdk.util.internal.RegexUtil;
import com.zebra.sdk.util.internal.Sleeper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MultichannelBluetoothConnection extends MultichannelConnection {
    private static final int STATUS_CHANNEL_OPEN_DELAY = 2000;

    public MultichannelBluetoothConnection(ConnectionInfo connectionInfo) throws NotMyConnectionDataException {
        String myData = connectionInfo.getMyData();
        List<String> matches = RegexUtil.getMatches("^\\s*(" + getConnectionBuilderPrefix() + ":)?([a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2}:[a-fA-F0-9]{2})\\s*$", myData);
        if (matches.size() != 3) {
            matches = RegexUtil.getMatches("(.*)mB=(.*?)&(.*)", myData);
            if (matches.isEmpty()) {
                matches = RegexUtil.getMatches("^\\s*(" + getConnectionBuilderPrefix() + ":)?([^:]+)\\s*$", myData);
                if (matches.isEmpty()) {
                    throw new NotMyConnectionDataException("Bluetooth Connection doesn't understand " + myData);
                }
            }
        }
        init(BluetoothHelper.formatMacAddress(matches.get(2)), 5000, 500, 5000, 500);
    }

    private void init(String str, int i, int i2, int i3, int i4) {
        this.raw = new BluetoothConnection(str, i, i2);
        this.settings = new BluetoothStatusConnection(str, i3, i4);
    }

    @Override // com.zebra.sdk.comm.MultichannelConnection, com.zebra.sdk.comm.Connection
    public void close() {
        this.settings.close();
        this.raw.close();
    }

    public String getConnectionBuilderPrefix() {
        return "BT_MULTI";
    }

    @Override // com.zebra.sdk.comm.Connection
    public String getSimpleConnectionName() {
        return ((BluetoothConnection) this.raw).getSimpleConnectionName();
    }

    @Override // com.zebra.sdk.comm.MultichannelConnection, com.zebra.sdk.comm.Connection
    public void open() throws ConnectionException {
        boolean z;
        boolean z2 = true;
        try {
            openPrintingChannel();
            z = true;
        } catch (ConnectionException unused) {
            z = false;
        }
        Sleeper.sleep(2000L);
        try {
            openStatusChannel();
        } catch (ConnectionException unused2) {
            z2 = z;
        }
        if (!z2) {
            throw new ConnectionException("Could not open connection");
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public String toString() {
        return "Bluetooth_MULTI:" + ((BluetoothConnection) this.raw).getMACAddress() + ":" + ((BluetoothConnection) this.raw).getFriendlyName();
    }

    public MultichannelBluetoothConnection(String str) {
        this(str, 5000, 500);
    }

    public MultichannelBluetoothConnection(String str, int i, int i2) {
        this(str, i, i2, i, i2);
    }

    public MultichannelBluetoothConnection(String str, int i, int i2, int i3, int i4) {
        init(str, i, i2, i3, i4);
    }
}
