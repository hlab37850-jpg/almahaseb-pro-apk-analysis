package com.zebra.sdk.comm;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.zebra.sdk.comm.internal.ConnectionI;
import com.zebra.sdk.comm.internal.UsbConnectionReestablisher;
import com.zebra.sdk.comm.internal.UsbUtils;
import com.zebra.sdk.util.internal.ReflectionUtil;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UsbConnection extends ConnectionA implements ConnectionI {
    private static final int MAX_CARD_USB_WRITE_SIZE = 16384;
    public static final /* synthetic */ int a = 0;
    private Map<String, String> connectionAttributes;
    private UsbDevice device;
    private UsbManager manager;
    private UsbPermissionRequestor requestor;
    private String serialNumber;

    public UsbConnection(UsbManager usbManager, UsbDevice usbDevice) {
        this(usbManager, usbDevice, 5000, 500);
    }

    private String getSerialNumberFromDevice() {
        String strStripQuotes = "";
        if (!UsbUtils.isCardPrinter(this.connectionAttributes)) {
            try {
                open();
                write("! U1 getvar \"device.unique_id\"\r\n".getBytes());
                String str = new String(read());
                if (!str.isEmpty()) {
                    strStripQuotes = StringUtilities.stripQuotes(str);
                }
            } catch (ConnectionException unused) {
            } catch (Throwable th) {
                try {
                    close();
                } catch (ConnectionException unused2) {
                }
                throw th;
            }
            try {
                close();
            } catch (ConnectionException unused3) {
            }
        }
        return strStripQuotes;
    }

    private Map<String, String> loadDeviceIdMap(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        UsbUtils.addSymbolicNameAttributesToMap(str, linkedHashMap);
        linkedHashMap.put("pid", Integer.toString(this.device.getProductId()));
        linkedHashMap.put("vid", Integer.toString(this.device.getVendorId()));
        try {
            open();
            UsbUtils.addDeviceIdArtributesToMap(linkedHashMap, ((ZebraUsbSocket) this.commLink).getDeviceIdString());
            if (UsbUtils.isZMotifPrinter(linkedHashMap)) {
                linkedHashMap.put("SERIAL_NUMBER", UsbUtils.decodeZmotifSerialNumber((String) linkedHashMap.get("SERIAL_NUMBER")));
            }
            return linkedHashMap;
        } finally {
            close();
        }
    }

    private void loadDeviceMap() {
        this.connectionAttributes = loadDeviceIdMap(getDeviceName());
        loadSerialNumber();
    }

    private void loadSerialNumber() {
        String str = this.connectionAttributes.get("SERIAL_NUMBER");
        this.serialNumber = str;
        if (str == null || str.isEmpty()) {
            String serialNumberFromDevice = getSerialNumberFromDevice();
            this.serialNumber = serialNumberFromDevice;
            if (serialNumberFromDevice.isEmpty()) {
                this.serialNumber = this.connectionAttributes.get("MODEL");
            }
            this.connectionAttributes.put("SERIAL_NUMBER", this.serialNumber);
        }
    }

    public Map<String, String> getConnectionAttributes() {
        return this.connectionAttributes;
    }

    @Override // com.zebra.sdk.comm.ConnectionA, com.zebra.sdk.comm.Connection
    public ConnectionReestablisher getConnectionReestablisher(long j) {
        return UsbUtils.isCardPrinter(this.connectionAttributes) ? ReflectionUtil.loadUsbCardConnectionReestablisher(this, j) : new UsbConnectionReestablisher(this, j);
    }

    public String getDeviceName() {
        return this.device.getDeviceName();
    }

    public UsbManager getManager() {
        return this.manager;
    }

    @Override // com.zebra.sdk.comm.ConnectionA, com.zebra.sdk.comm.internal.ConnectionI
    public String getManufacturer() {
        Map<String, String> map = this.connectionAttributes;
        return (map == null || map.size() <= 0) ? "" : this.connectionAttributes.get("MFG");
    }

    public UsbPermissionRequestor getRequestor() {
        return this.requestor;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    @Override // com.zebra.sdk.comm.Connection
    public String getSimpleConnectionName() {
        return getDeviceName();
    }

    @Override // com.zebra.sdk.comm.ConnectionA, com.zebra.sdk.comm.internal.ConnectionI
    public byte[] read(int i) throws ConnectionException {
        if (i <= 1) {
            return super.read(i);
        }
        byte[] bArr = new byte[i];
        try {
            ((ZebraUsbSocket) this.commLink).getInputStream().read(bArr);
            return bArr;
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage(), e);
        }
    }

    public void setRequestor(UsbPermissionRequestor usbPermissionRequestor) {
        this.requestor = usbPermissionRequestor;
    }

    @Override // com.zebra.sdk.comm.Connection
    public String toString() {
        return "USB:" + getDeviceName();
    }

    @Override // com.zebra.sdk.comm.ConnectionA, com.zebra.sdk.comm.Connection
    public void write(byte[] bArr, int i, int i2) {
        if (UsbUtils.isCardPrinter(this.connectionAttributes)) {
            setMaxDataToWrite(16384);
        }
        super.write(bArr, i, i2);
    }

    public UsbConnection(UsbManager usbManager, UsbDevice usbDevice, int i, int i2) {
        this.requestor = null;
        this.serialNumber = "";
        this.manager = usbManager;
        this.device = usbDevice;
        this.zebraConnector = new UsbZebraConnectorImpl(usbManager, usbDevice);
        this.maxTimeoutForRead = i;
        this.timeToWaitForMoreData = i2;
        try {
            loadDeviceMap();
        } catch (ConnectionException unused) {
        }
    }
}
