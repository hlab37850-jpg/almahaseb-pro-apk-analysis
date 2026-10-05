package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.PrinterObjectProperties;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtilCpcl extends FileUtilA {
    public FileUtilCpcl(Connection connection) {
        super(connection);
    }

    @Override // com.zebra.sdk.printer.internal.FileUtilA, com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames() {
        return retrieveFilePropertiesFromPrinter().getFileNamesFromProperties();
    }

    @Override // com.zebra.sdk.device.FileUtil
    public List<PrinterObjectProperties> retrieveObjectsProperties() {
        return retrieveFilePropertiesFromPrinter().getObjectsProperties();
    }

    @Override // com.zebra.sdk.printer.internal.FileUtilA, com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames(String[] strArr) {
        return retrieveFilePropertiesFromPrinter().filterByExtension(strArr).getFileNamesFromProperties();
    }
}
