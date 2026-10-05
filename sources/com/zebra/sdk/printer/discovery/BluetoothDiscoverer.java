package com.zebra.sdk.printer.discovery;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.zebra.sdk.comm.internal.BluetoothHelper;
import com.zebra.sdk.comm.internal.BtServiceDiscoverer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothDiscoverer {
    BtRadioMonitor btMonitor;
    BtReceiver btReceiver;
    private DeviceFilter deviceFilter;
    private Context mContext;
    private DiscoveryHandler mDiscoveryHandler;

    public class BtRadioMonitor extends BroadcastReceiver {
        private BtRadioMonitor() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction()) && intent.getExtras().getInt("android.bluetooth.adapter.extra.STATE") == 10) {
                BluetoothDiscoverer.this.mDiscoveryHandler.discoveryFinished();
                BluetoothDiscoverer.this.unregisterTopLevelReceivers(context);
            }
        }
    }

    public class BtReceiver extends BroadcastReceiver {
        private static final int BLUETOOTH_PRINTER_CLASS = 1664;
        private Map<String, BluetoothDevice> foundDevices;

        private BtReceiver() {
            this.foundDevices = new HashMap();
        }

        private boolean isPrinterClass(BluetoothDevice bluetoothDevice) {
            BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
            return bluetoothClass != null && bluetoothClass.getDeviceClass() == BLUETOOTH_PRINTER_CLASS;
        }

        private void processFoundPrinter(Intent intent) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (this.foundDevices.keySet().contains(bluetoothDevice.getAddress()) || BluetoothDiscoverer.this.deviceFilter == null || !BluetoothDiscoverer.this.deviceFilter.shouldAddPrinter(bluetoothDevice) || !isPrinterClass(bluetoothDevice)) {
                return;
            }
            BluetoothDiscoverer.this.mDiscoveryHandler.foundPrinter(new DiscoveredPrinterBluetooth(bluetoothDevice.getAddress(), bluetoothDevice.getName()));
            this.foundDevices.put(bluetoothDevice.getAddress(), bluetoothDevice);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                processFoundPrinter(intent);
            } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                BluetoothDiscoverer.this.mDiscoveryHandler.discoveryFinished();
                BluetoothDiscoverer.this.unregisterTopLevelReceivers(context);
            }
        }
    }

    private BluetoothDiscoverer(Context context, DiscoveryHandler discoveryHandler, DeviceFilter deviceFilter) {
        this.mContext = context;
        this.deviceFilter = deviceFilter;
        this.mDiscoveryHandler = discoveryHandler;
    }

    private void doBluetoothDisco() {
        this.btReceiver = new BtReceiver();
        this.btMonitor = new BtRadioMonitor();
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
        IntentFilter intentFilter2 = new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        IntentFilter intentFilter3 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mContext.registerReceiver(this.btReceiver, intentFilter);
        this.mContext.registerReceiver(this.btReceiver, intentFilter2);
        this.mContext.registerReceiver(this.btMonitor, intentFilter3);
        BluetoothAdapter.getDefaultAdapter().startDiscovery();
    }

    public static void findPrinters(Context context, DiscoveryHandler discoveryHandler) {
        findPrinters(context, discoveryHandler, new DeviceFilter() { // from class: com.zebra.sdk.printer.discovery.BluetoothDiscoverer.1
            @Override // com.zebra.sdk.printer.discovery.DeviceFilter
            public boolean shouldAddPrinter(BluetoothDevice bluetoothDevice) {
                return true;
            }
        });
    }

    public static void findServices(Context context, String str, ServiceDiscoveryHandler serviceDiscoveryHandler) {
        new BtServiceDiscoverer(BluetoothHelper.formatMacAddress(str), serviceDiscoveryHandler).doDiscovery(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterTopLevelReceivers(Context context) {
        BtReceiver btReceiver = this.btReceiver;
        if (btReceiver != null) {
            context.unregisterReceiver(btReceiver);
        }
        BtRadioMonitor btRadioMonitor = this.btMonitor;
        if (btRadioMonitor != null) {
            context.unregisterReceiver(btRadioMonitor);
        }
    }

    public static void findPrinters(Context context, DiscoveryHandler discoveryHandler, DeviceFilter deviceFilter) {
        String str;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            str = "No bluetooth radio found";
        } else {
            if (defaultAdapter.isEnabled()) {
                if (defaultAdapter.isDiscovering()) {
                    defaultAdapter.cancelDiscovery();
                }
                new BluetoothDiscoverer(context.getApplicationContext(), discoveryHandler, deviceFilter).doBluetoothDisco();
                return;
            }
            str = "Bluetooth radio is currently disabled";
        }
        discoveryHandler.discoveryError(str);
    }
}
