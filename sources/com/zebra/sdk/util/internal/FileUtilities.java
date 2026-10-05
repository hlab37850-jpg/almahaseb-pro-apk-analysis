package com.zebra.sdk.util.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.device.ProgressMonitor;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtilities {
    public static String GetFileNameOnPrinter(String str) throws ZebraIllegalArgumentException {
        if (str == null) {
            throw new ZebraIllegalArgumentException("Invalid file path");
        }
        String name = new File(str).getName();
        if (name.equals("")) {
            throw new ZebraIllegalArgumentException("Invalid file path");
        }
        return "E:" + StringUtilities.convertTo8dot3(name).toUpperCase();
    }

    public static String changeExtension(String str, String str2) {
        if (!str2.contains(".")) {
            str2 = "." + str2;
        }
        if (str.trim().endsWith(str2)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return str + str2;
        }
        return str.substring(0, iLastIndexOf) + str2;
    }

    public static PrinterFilePath parseDriveAndExtension(String str) throws ZebraIllegalArgumentException {
        Pattern patternCompile = Pattern.compile("^(([A-Za-z]+):)?([^.:]+)(\\.[^.]{0,3})?$");
        if (str == null || str.length() <= 0) {
            throw new ZebraIllegalArgumentException("Incorrect file name : ");
        }
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.matches()) {
            return new PrinterFilePath(matcher.group(2), truncateAndReplaceSpaces(matcher.group(3)), matcher.group(4));
        }
        throw new ZebraIllegalArgumentException("Incorrect file name : " + str);
    }

    public static void sendFileContentsInChunks(Connection connection, ProgressMonitor progressMonitor, InputStream inputStream, int i) throws ConnectionException {
        if (!connection.isConnected()) {
            throw new ConnectionException("Connection is not open.");
        }
        int i2 = i;
        while (i2 > 0) {
            try {
                byte[] bArr = new byte[4096 > i2 ? i2 : 4096];
                int i3 = inputStream.read(bArr);
                connection.write(bArr, 0, i3);
                i2 -= i3;
                progressMonitor.updateProgress(i - i2, i);
            } catch (IOException e) {
                throw new ConnectionException(e.getMessage());
            }
        }
    }

    private static String truncateAndReplaceSpaces(String str) {
        return StringUtilities.convertTo16dot3(str).replace(" ", "_");
    }

    public static void sendFileContentsInChunks(Connection connection, InputStream inputStream) throws ConnectionException {
        if (!connection.isConnected()) {
            throw new ConnectionException("Connection is not open.");
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    return;
                } else {
                    connection.write(bArr, 0, i);
                }
            }
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
