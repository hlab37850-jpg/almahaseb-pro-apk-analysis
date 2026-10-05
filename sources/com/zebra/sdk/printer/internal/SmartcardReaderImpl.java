package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.device.SmartcardReader;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class SmartcardReaderImpl implements SmartcardReader {
    protected Connection printerConnection;

    public SmartcardReaderImpl(ZebraPrinter zebraPrinter) {
        this.printerConnection = zebraPrinter.getConnection();
    }

    @Override // com.zebra.sdk.device.SmartcardReader
    public void close() {
        this.printerConnection.write("! U1 S-CARD CT_CLOSE\r\n".getBytes());
    }

    @Override // com.zebra.sdk.device.SmartcardReader
    public byte[] doCommand(String str) {
        return new PrinterCommandImpl("! U1 S-CARD CT_DATA " + str.length() + " " + str + StringUtilities.CRLF).sendAndWaitForResponse(this.printerConnection);
    }

    @Override // com.zebra.sdk.device.SmartcardReader
    public byte[] getATR() {
        return new PrinterCommandImpl("! U1 S-CARD CT_ATR\r\n").sendAndWaitForResponse(this.printerConnection);
    }
}
