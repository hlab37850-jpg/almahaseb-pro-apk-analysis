package com.zebra.android.printer.internal;

import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.android.printer.FileUtil;
import com.zebra.android.printer.ZebraIllegalArgumentException;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtilLegacy implements FileUtil {
    private ZebraPrinter newTypePrinter;

    public FileUtilLegacy(ZebraPrinter zebraPrinter) {
        this.newTypePrinter = zebraPrinter;
    }

    @Override // com.zebra.android.printer.FileUtil
    public String[] retrieveFileNames() throws ZebraPrinterConnectionException, ZebraIllegalArgumentException {
        try {
            return this.newTypePrinter.retrieveFileNames();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getMessage());
        } catch (com.zebra.sdk.device.ZebraIllegalArgumentException e2) {
            throw new ZebraIllegalArgumentException(e2.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.FileUtil
    public void sendFileContents(String str) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.sendFileContents(str);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getMessage());
        }
    }

    @Override // com.zebra.android.printer.FileUtil
    public String[] retrieveFileNames(String[] strArr) throws ZebraPrinterConnectionException, ZebraIllegalArgumentException {
        try {
            return this.newTypePrinter.retrieveFileNames(strArr);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getMessage());
        } catch (com.zebra.sdk.device.ZebraIllegalArgumentException e2) {
            throw new ZebraIllegalArgumentException(e2.getLocalizedMessage());
        }
    }
}
