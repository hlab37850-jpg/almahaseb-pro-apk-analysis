package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.FormatUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FormatUtilA implements FormatUtil {
    protected Connection printerConnection;

    public FormatUtilA(Connection connection) {
        this.printerConnection = connection;
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, String[] strArr) {
        try {
            printStoredFormat(str, strArr, System.getProperty("file.encoding"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, String[] strArr, String str2) {
        HashMap map = new HashMap();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != null) {
                map.put(Integer.valueOf(i + 2), strArr[i]);
            }
        }
        printStoredFormat(str, map, str2);
    }
}
