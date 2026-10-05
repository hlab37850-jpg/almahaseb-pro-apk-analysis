package com.zebra.sdk.util.internal;

import com.zebra.sdk.comm.snmp.internal.Snmp;
import com.zebra.sdk.printer.discovery.DiscoveryHandler;
import com.zebra.sdk.printer.discovery.NetworkDiscoverer;
import com.zebra.sdk.settings.internal.SettingType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkUtil {
    private static final List<String> cardCmdIdValues = new ArrayList(Arrays.asList("zmotif", "epcl", "epcl1", "epcl3"));

    private static Map<String, String> addDeviceIdArtributesToMap(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split(";")) {
            String[] strArrSplit = str2.split(":");
            if (strArrSplit.length > 1) {
                String str3 = strArrSplit[0];
                String strTrim = strArrSplit[1].trim();
                if (str3.equals("MANUFACTURER")) {
                    map.put("MFG", strTrim);
                }
                if (str3.equals("MFG")) {
                    map.put("MFG", strTrim);
                }
                if (str3.equals("MODEL")) {
                    map.put("MODEL", strTrim);
                }
                if (str3.equals("MDL")) {
                    map.put("MODEL", strTrim);
                }
                if (str3.equals("COMMAND SET")) {
                    map.put("CMD", strTrim);
                }
                if (str3.equals("CMD")) {
                    map.put("CMD", strTrim);
                }
                if (str3.equals("SERIAL NUMBER")) {
                    map.put("SERIAL_NUMBER", strTrim);
                }
                if (str3.equals("SN")) {
                    map.put("SERIAL_NUMBER", strTrim);
                }
            }
        }
        return map;
    }

    public static Map<String, String> getIEEE1284DeviceId(String str) throws Throwable {
        HashMap map = new HashMap();
        try {
            String str2 = new Snmp("public", "public", SettingType.STRING).get(str, "1.3.6.1.4.1.2699.1.2.1.2.1.1.3.1");
            return (str2 == null || str2.isEmpty()) ? map : addDeviceIdArtributesToMap(str2);
        } catch (Exception unused) {
            return map;
        }
    }

    public static boolean isCardPrinter(String str) throws Throwable {
        if (str == null) {
            return false;
        }
        try {
            if (str.isEmpty()) {
                return false;
            }
            Map<String, String> iEEE1284DeviceId = getIEEE1284DeviceId(str);
            if (iEEE1284DeviceId.size() <= 0) {
                return false;
            }
            String str2 = iEEE1284DeviceId.containsKey("CMD") ? iEEE1284DeviceId.get("CMD") : "";
            if (iEEE1284DeviceId.containsKey("MFG")) {
                return iEEE1284DeviceId.get("MFG").toLowerCase(Locale.US).contains("card") || isCardPrinterCmdId(str2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isCardPrinterCmdId(String str) {
        return (str == null || str.isEmpty() || !cardCmdIdValues.contains(str.toLowerCase(Locale.US))) ? false : true;
    }

    public static void startSinglePrinterDiscovery(String str, DiscoveryHandler discoveryHandler) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        NetworkDiscoverer.findPrinters(discoveryHandler, linkedList);
    }
}
