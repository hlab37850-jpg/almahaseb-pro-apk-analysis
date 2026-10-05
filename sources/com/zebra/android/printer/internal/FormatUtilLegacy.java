package com.zebra.android.printer.internal;

import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.android.printer.FieldDescriptionData;
import com.zebra.android.printer.FormatUtil;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FormatUtilLegacy implements FormatUtil {
    private ZebraPrinter newTypePrinter;

    public FormatUtilLegacy(ZebraPrinter zebraPrinter) {
        this.newTypePrinter = zebraPrinter;
    }

    @Override // com.zebra.android.printer.FormatUtil
    public FieldDescriptionData[] getVariableFields(String str) {
        com.zebra.sdk.printer.FieldDescriptionData[] variableFields = this.newTypePrinter.getVariableFields(str);
        ArrayList arrayList = new ArrayList();
        for (com.zebra.sdk.printer.FieldDescriptionData fieldDescriptionData : variableFields) {
            arrayList.add(new FieldDescriptionData(fieldDescriptionData.fieldNumber, fieldDescriptionData.fieldName));
        }
        return (FieldDescriptionData[]) arrayList.toArray(new FieldDescriptionData[0]);
    }

    @Override // com.zebra.android.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.printStoredFormat(str, map);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getMessage());
        }
    }

    @Override // com.zebra.android.printer.FormatUtil
    public byte[] retrieveFormatFromPrinter(String str) throws ZebraPrinterConnectionException {
        try {
            return this.newTypePrinter.retrieveFormatFromPrinter(str);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getMessage());
        }
    }

    @Override // com.zebra.android.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map, String str2) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.printStoredFormat(str, map, str2);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getMessage());
        }
    }

    @Override // com.zebra.android.printer.FormatUtil
    public void printStoredFormat(String str, String[] strArr) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.printStoredFormat(str, strArr);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getMessage());
        }
    }

    @Override // com.zebra.android.printer.FormatUtil
    public void printStoredFormat(String str, String[] strArr, String str2) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.printStoredFormat(str, strArr, str2);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getMessage());
        }
    }
}
