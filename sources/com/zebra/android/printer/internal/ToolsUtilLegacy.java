package com.zebra.android.printer.internal;

import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.android.printer.ToolsUtil;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;

/* JADX INFO: loaded from: classes3.dex */
public class ToolsUtilLegacy implements ToolsUtil {
    private ZebraPrinter newTypePrinter;

    public ToolsUtilLegacy(ZebraPrinter zebraPrinter) {
        this.newTypePrinter = zebraPrinter;
    }

    @Override // com.zebra.android.printer.ToolsUtil
    public void calibrate() throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.calibrate();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.ToolsUtil
    public void printConfigurationLabel() throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.printConfigurationLabel();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.ToolsUtil
    public void reset() throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.reset();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.ToolsUtil
    public void restoreDefaults() throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.restoreDefaults();
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.ToolsUtil
    public void sendCommand(String str) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.sendCommand(str);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }
}
