package com.zebra.sdk.printer.discovery;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.zebra.sdk.comm.internal.ZebraUrlParser;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UrlPrinterDiscoverer {
    private static final String INTERFACE_NOT_PRESENT = "000000000000";

    private UrlPrinterDiscoverer() {
    }

    public static void findPrinters(String str, DiscoveryHandler discoveryHandler) throws DiscoveryException {
        findPrinters(str, discoveryHandler, null);
    }

    private static String formatBluetoothAddress(String str) {
        if (str.length() != 12) {
            return str;
        }
        return str.substring(0, 2) + ":" + str.substring(2, 4) + ":" + str.substring(4, 6) + ":" + str.substring(6, 8) + ":" + str.substring(8, 10) + ":" + str.substring(10);
    }

    private static String getAddress(Map<String, String> map, String str) {
        if (map.containsKey(str)) {
            String str2 = map.get(str);
            if (!str2.equals(INTERFACE_NOT_PRESENT)) {
                return str2.toUpperCase();
            }
        }
        return null;
    }

    private static DiscoveredPrinter reflectivelyInstatiateDiscoveredPrinterBluetoothLe(String str, String str2, Context context) {
        try {
            Constructor<?> declaredConstructor = Class.forName("com.zebra.sdk.btleComm.DiscoveredPrinterBluetoothLe").getDeclaredConstructor(String.class, String.class, Context.class);
            declaredConstructor.setAccessible(true);
            return (DiscoveredPrinter) declaredConstructor.newInstance(str, str2, context);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void findPrinters(String str, final DiscoveryHandler discoveryHandler, Context context) throws DiscoveryException {
        BluetoothAdapter defaultAdapter;
        if (!str.contains("zebra.com/apps/r/nfc?")) {
            throw new DiscoveryException("Unsupported URL format");
        }
        Map<String, String> variables = new ZebraUrlParser().getVariables(str);
        String address = getAddress(variables, "mB");
        String address2 = getAddress(variables, "mBL");
        String address3 = getAddress(variables, "mW");
        String address4 = getAddress(variables, "mE");
        if (address != null) {
            BluetoothAdapter defaultAdapter2 = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter2 != null && BluetoothAdapter.checkBluetoothAddress(formatBluetoothAddress(address))) {
                BluetoothDevice remoteDevice = defaultAdapter2.getRemoteDevice(formatBluetoothAddress(address));
                discoveryHandler.foundPrinter(new DiscoveredPrinterBluetooth(remoteDevice.getAddress(), remoteDevice.getName()));
            }
        } else if (address2 != null && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null && BluetoothAdapter.checkBluetoothAddress(formatBluetoothAddress(address2))) {
            BluetoothDevice remoteDevice2 = defaultAdapter.getRemoteDevice(formatBluetoothAddress(address2));
            DiscoveredPrinter discoveredPrinterReflectivelyInstatiateDiscoveredPrinterBluetoothLe = reflectivelyInstatiateDiscoveredPrinterBluetoothLe(remoteDevice2.getAddress(), remoteDevice2.getName(), context);
            if (discoveredPrinterReflectivelyInstatiateDiscoveredPrinterBluetoothLe != null) {
                discoveryHandler.foundPrinter(discoveredPrinterReflectivelyInstatiateDiscoveredPrinterBluetoothLe);
            }
        }
        final ArrayList arrayList = new ArrayList();
        if (address3 != null) {
            arrayList.add(address3);
        }
        if (address4 != null) {
            arrayList.add(address4);
        }
        if (arrayList.size() > 0) {
            NetworkDiscoverer.findPrinters(new DiscoveryHandler() { // from class: com.zebra.sdk.printer.discovery.UrlPrinterDiscoverer.1
                @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
                public void discoveryError(String str2) {
                    discoveryHandler.discoveryError(str2);
                }

                @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
                public void discoveryFinished() {
                    discoveryHandler.discoveryFinished();
                }

                @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
                public void foundPrinter(DiscoveredPrinter discoveredPrinter) {
                    if (arrayList.contains(discoveredPrinter.getDiscoveryDataMap().get("HARDWARE_ADDRESS").replaceAll(":", "").toUpperCase())) {
                        discoveryHandler.foundPrinter(discoveredPrinter);
                    }
                }
            });
        } else {
            discoveryHandler.discoveryFinished();
        }
    }
}
