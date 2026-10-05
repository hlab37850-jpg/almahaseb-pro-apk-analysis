package com.zebra.sdk.printer.internal;

import com.google.android.material.timepicker.TimeModel;
import com.zebra.sdk.printer.FirmwareUpdateHandler;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes3.dex */
public class FirmwareUpdateHandlerVerboseDecorator implements FirmwareUpdateHandler {
    private String connectionIdentifierString;
    private String firmwareFileIdentifierString;
    private boolean isVerbose;
    private int lastPercentComplete = -1;
    private FirmwareUpdateHandler myDecoratedFimwareUpdateHander;

    public FirmwareUpdateHandlerVerboseDecorator(boolean z, String str, String str2, FirmwareUpdateHandler firmwareUpdateHandler) {
        this.myDecoratedFimwareUpdateHander = firmwareUpdateHandler;
        this.isVerbose = z;
        this.connectionIdentifierString = str;
        this.firmwareFileIdentifierString = str2;
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdateHandlerBase
    public void firmwareDownloadComplete() {
        if (this.isVerbose) {
            PrintStream printStream = System.out;
            printStream.format("%s accepted firmware file %s%n", this.connectionIdentifierString, this.firmwareFileIdentifierString);
            printStream.format("Flashing firmware to printer...%n", new Object[0]);
        }
        this.myDecoratedFimwareUpdateHander.firmwareDownloadComplete();
    }

    @Override // com.zebra.sdk.printer.PrinterReconnectionHandler
    public void printerOnline(ZebraPrinterLinkOs zebraPrinterLinkOs, String str) {
        if (this.isVerbose) {
            System.out.format("%s is back online with address %s and firmware version %s%n", this.connectionIdentifierString, zebraPrinterLinkOs == null ? "unknown" : zebraPrinterLinkOs.getConnection().getSimpleConnectionName(), str);
        }
        this.myDecoratedFimwareUpdateHander.printerOnline(zebraPrinterLinkOs, str);
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdateHandlerBase
    public void progressUpdate(int i, int i2) {
        if (this.isVerbose) {
            if (this.lastPercentComplete == -1) {
                System.out.format("FW download progress : [%20s]", " ");
            }
            int i3 = (int) ((((double) i) / ((double) i2)) * 100.0d);
            if (i3 == 100) {
                PrintStream printStream = System.out;
                printStream.format("%s", StringUtilities.repeat("\b", 12));
                printStream.format("%s", "100");
                printStream.format("%s]%n", StringUtilities.repeat("*", 8));
            } else if (this.lastPercentComplete != i3) {
                this.lastPercentComplete = i3;
                int i4 = i3 / 5;
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
                if (this.lastPercentComplete % 5 == 0) {
                    PrintStream printStream2 = System.out;
                    printStream2.format("%s", StringUtilities.repeat("\b", 21));
                    if (i4 < 10) {
                        printStream2.format("%-9s", StringUtilities.repeat("*", i4));
                        printStream2.format("%-11s]", str);
                    } else {
                        printStream2.format("%-9s", StringUtilities.repeat("*", 9));
                        printStream2.format("%-2s", str);
                        int i5 = i4 - 11;
                        if (i5 < 0) {
                            i5 = 0;
                        }
                        printStream2.format("%-9s]", StringUtilities.repeat("*", i5));
                    }
                } else {
                    PrintStream printStream3 = System.out;
                    printStream3.format("%s", StringUtilities.repeat("\b", 12));
                    printStream3.format("%-2s", str);
                    if (i4 < 11) {
                        printStream3.format("%-9s]", " ");
                    } else {
                        int i6 = i4 - 11;
                        if (i6 < 0) {
                            i6 = 0;
                        }
                        printStream3.format("%-9s]", StringUtilities.repeat("*", i6));
                    }
                }
            }
        }
        this.myDecoratedFimwareUpdateHander.progressUpdate(i, i2);
    }
}
