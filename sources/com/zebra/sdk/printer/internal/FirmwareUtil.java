package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.util.internal.RegexUtil;
import com.zebra.sdk.util.internal.SGDUtilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FirmwareUtil {
    public static String extractFirmwareVersion(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            do {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
                i++;
            } while (i < 5);
            List<String> matches = RegexUtil.getMatches("^\\s*! PROGRAM\\s*(.*?)\\s*~D[C|I]", stringBuffer.toString());
            return matches.size() == 2 ? matches.get(1) : "";
        } catch (IOException unused) {
            return "";
        }
    }

    public static boolean firmwareVersionsDontMatch(InputStream inputStream, Connection connection) {
        return firmwareVersionsDontMatch(inputStream, getFWVersionFromPrinterConnection(connection).trim().toLowerCase());
    }

    public static boolean firmwareVersionsMatch(String str, String str2) {
        String lowerCase = str.trim().toLowerCase();
        String lowerCase2 = str2.trim().toLowerCase();
        return lowerCase2.equals(lowerCase) || matchIgnoringZ(lowerCase, lowerCase2);
    }

    public static String getFWVersionFromPrinterConnection(Connection connection) {
        return SGD.GET(SGDUtilities.APPL_NAME, connection);
    }

    private static boolean matchIgnoringZ(String str, String str2) {
        return str2.replaceAll("z", "").equals(str.replaceAll("z", ""));
    }

    public static boolean firmwareVersionsDontMatch(InputStream inputStream, String str) {
        return !firmwareVersionsMatch(extractFirmwareVersion(inputStream).trim(), str);
    }
}
