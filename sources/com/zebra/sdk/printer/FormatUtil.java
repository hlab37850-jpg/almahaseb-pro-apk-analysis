package com.zebra.sdk.printer;

import java.io.OutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface FormatUtil {
    FieldDescriptionData[] getVariableFields(String str);

    void printStoredFormat(String str, Map<Integer, String> map);

    void printStoredFormat(String str, Map<Integer, String> map, String str2);

    void printStoredFormat(String str, String[] strArr);

    void printStoredFormat(String str, String[] strArr, String str2);

    void retrieveFormatFromPrinter(OutputStream outputStream, String str);

    byte[] retrieveFormatFromPrinter(String str);
}
