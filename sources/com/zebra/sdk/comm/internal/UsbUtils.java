package com.zebra.sdk.comm.internal;

import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UsbUtils {
    public static void addDeviceIdArtributesToMap(Map<String, String> map, String str) {
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
    }

    public static void addSymbolicNameAttributesToMap(String str, Map<String, String> map) {
        map.put("SERIAL_NUMBER", getSerialNumberFromSymbolicName(str));
        map.put("ADDRESS", str);
    }

    public static String decodeZmotifSerialNumber(String str) {
        String strConcat;
        try {
            int i = Integer.parseInt(str);
            String strConcat2 = "";
            String strConcat3 = "";
            for (int i2 = 31; i2 >= 25; i2--) {
                strConcat3 = strConcat3.concat(Integer.toBinaryString((i >> i2) & 1));
            }
            switch (Integer.parseInt(strConcat3, 2)) {
                case 1:
                    strConcat = "06A";
                    break;
                case 2:
                    strConcat = "06C";
                    break;
                case 3:
                    strConcat = "06J";
                    break;
                case 4:
                    strConcat = "10A";
                    break;
                case 5:
                    strConcat = "10C";
                    break;
                case 6:
                    strConcat = "10J";
                    break;
                case 7:
                    strConcat = "12A";
                    break;
                case 8:
                    strConcat = "12C";
                    break;
                case 9:
                    strConcat = "12J";
                    break;
                case 10:
                    strConcat = "Z9J";
                    break;
                case 11:
                    strConcat = "C1J";
                    break;
                case 12:
                    strConcat = "C3J";
                    break;
                default:
                    return str;
            }
            String strConcat4 = "";
            for (int i3 = 24; i3 >= 19; i3--) {
                strConcat4 = strConcat4.concat(Integer.toBinaryString((i >> i3) & 1));
            }
            int i4 = Integer.parseInt(strConcat4, 2);
            if (i4 < 10) {
                strConcat = strConcat.concat("0");
            }
            String strConcat5 = strConcat.concat(Integer.toString(i4));
            String strConcat6 = "";
            for (int i5 = 18; i5 >= 13; i5--) {
                strConcat6 = strConcat6.concat(Integer.toBinaryString((i >> i5) & 1));
            }
            int i6 = Integer.parseInt(strConcat6, 2);
            if (i6 < 10) {
                strConcat5 = strConcat5.concat("0");
            }
            String strConcat7 = strConcat5.concat(Integer.toString(i6));
            for (int i7 = 12; i7 >= 0; i7--) {
                strConcat2 = strConcat2.concat(Integer.toBinaryString((i >> i7) & 1));
            }
            int i8 = Integer.parseInt(strConcat2, 2);
            String strConcat8 = strConcat7.concat("0");
            String string = Integer.toString(i8);
            for (int length = string.length(); length < 4; length++) {
                strConcat8 = strConcat8.concat("0");
            }
            return strConcat8.concat(string);
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    private static String getSerialNumberFromSymbolicName(String str) {
        int iIndexOf = str.indexOf("#", 8);
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf("#", i);
        return (iIndexOf <= -1 || iIndexOf2 <= 0) ? "" : str.substring(i, iIndexOf2);
    }

    public static boolean isCardPrinter(Map<String, String> map) {
        return map.containsKey("MFG") && (map.get("MFG").toLowerCase(Locale.US).contains("card") || (map.containsKey("CMD") ? map.get("CMD") : "").trim().equalsIgnoreCase("zmotif"));
    }

    public static boolean isZMotifPrinter(Map<String, String> map) {
        return map.containsKey("MFG") && (map.get("MFG").trim().equalsIgnoreCase("zebra digital card printer") || (map.containsKey("CMD") ? map.get("CMD") : "").trim().equalsIgnoreCase("zmotif"));
    }
}
