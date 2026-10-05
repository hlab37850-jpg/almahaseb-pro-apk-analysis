package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.device.MagCardReader;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class MagCardReaderImpl implements MagCardReader {
    protected Connection printerConnection;

    public MagCardReaderImpl(ZebraPrinter zebraPrinter) {
        this.printerConnection = zebraPrinter.getConnection();
    }

    @Override // com.zebra.sdk.device.MagCardReader
    public String[] read(int i) {
        String[] strArr = {"", "", ""};
        if (i <= 0) {
            i = 1000;
        }
        PrinterCommandImpl printerCommandImpl = new PrinterCommandImpl("! U1 MCR " + ((i * 8) / 1000) + " T1 T2 T3" + StringUtilities.CRLF);
        Connection connection = this.printerConnection;
        String str = new String(printerCommandImpl.sendAndWaitForResponse(connection, i, connection.getTimeToWaitForMoreData()));
        int iIndexOf = str.indexOf("T1:");
        int iIndexOf2 = iIndexOf != -1 ? str.indexOf(StringUtilities.CRLF, iIndexOf) : -1;
        if (iIndexOf != -1 && iIndexOf2 != -1) {
            strArr[0] = str.substring(iIndexOf + 3, iIndexOf2);
        }
        int iIndexOf3 = str.indexOf("T2:");
        int iIndexOf4 = iIndexOf3 != -1 ? str.indexOf(StringUtilities.CRLF, iIndexOf3) : -1;
        if (iIndexOf3 != -1 && iIndexOf4 != -1) {
            strArr[1] = str.substring(iIndexOf3 + 3, iIndexOf4);
        }
        int iIndexOf5 = str.indexOf("T3:");
        int iIndexOf6 = iIndexOf5 != -1 ? str.indexOf(StringUtilities.CRLF, iIndexOf5) : -1;
        if (iIndexOf5 != -1 && iIndexOf6 != -1) {
            strArr[2] = str.substring(iIndexOf5 + 3, iIndexOf6);
        }
        return strArr;
    }
}
