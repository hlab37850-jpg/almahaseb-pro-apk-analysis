package com.zebra.sdk.device;

import com.zebra.sdk.printer.PrinterObjectProperties;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface FileUtil {
    String[] retrieveFileNames();

    String[] retrieveFileNames(String[] strArr);

    List<PrinterObjectProperties> retrieveObjectsProperties();

    void sendFileContents(String str);

    void sendFileContents(String str, ProgressMonitor progressMonitor);
}
