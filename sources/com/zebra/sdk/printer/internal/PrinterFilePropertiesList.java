package com.zebra.sdk.printer.internal;

import com.zebra.sdk.printer.PrinterObjectProperties;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterFilePropertiesList {
    List<PrinterObjectProperties> fileRecords = new ArrayList();

    public void add(PrinterObjectProperties printerObjectProperties) {
        this.fileRecords.add(printerObjectProperties);
    }

    public void addAll(Collection<? extends PrinterObjectProperties> collection) {
        this.fileRecords.addAll(collection);
    }

    public PrinterFilePropertiesList filterByExtension(String[] strArr) {
        PrinterFilePropertiesList printerFilePropertiesList = new PrinterFilePropertiesList();
        for (int i = 0; i < this.fileRecords.size(); i++) {
            PrinterObjectProperties printerObjectProperties = this.fileRecords.get(i);
            for (String str : strArr) {
                if (printerObjectProperties.getExtension().toUpperCase().equals(str.toUpperCase())) {
                    printerFilePropertiesList.add(printerObjectProperties);
                    break;
                }
            }
        }
        return printerFilePropertiesList;
    }

    public PrinterObjectProperties get(int i) {
        return this.fileRecords.get(i);
    }

    public String[] getFileNamesFromProperties() {
        String[] strArr = new String[this.fileRecords.size()];
        for (int i = 0; i < this.fileRecords.size(); i++) {
            strArr[i] = this.fileRecords.get(i).getFullName();
        }
        return strArr;
    }

    public List<PrinterObjectProperties> getObjectsProperties() {
        return this.fileRecords;
    }

    public int size() {
        return this.fileRecords.size();
    }
}
