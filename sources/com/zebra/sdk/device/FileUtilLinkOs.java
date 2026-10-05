package com.zebra.sdk.device;

import com.zebra.sdk.printer.StorageInfo;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface FileUtilLinkOs {
    void deleteFile(String str);

    void getObjectFromPrinter(OutputStream outputStream, String str);

    byte[] getObjectFromPrinter(String str);

    void getObjectFromPrinterViaFtp(OutputStream outputStream, String str, String str2);

    byte[] getObjectFromPrinterViaFtp(String str, String str2);

    byte[] getPrinterDownloadableObjectFromPrinter(String str);

    List<StorageInfo> getStorageInfo();

    void storeFileOnPrinter(String str);

    void storeFileOnPrinter(String str, String str2);

    void storeFileOnPrinter(byte[] bArr, String str);
}
