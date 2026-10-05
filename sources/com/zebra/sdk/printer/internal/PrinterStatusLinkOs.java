package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterStatus;
import com.zebra.sdk.settings.internal.JsonValidator;
import com.zebra.sdk.settings.internal.PrinterlessConnection;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterStatusLinkOs extends PrinterStatusZpl {
    public PrinterStatusLinkOs(Connection connection) {
        super(connection);
    }

    public static PrinterStatus create(String str) {
        return new PrinterStatusLinkOs(new PrinterlessConnection(String.format("{\"device.host_status\":\"%s\"}", str).getBytes()));
    }

    private byte[] parseJsonStatusResponse(String str) throws ConnectionException {
        try {
            return StringUtilities.convertKeyValueJsonToMap(str).get(SGDUtilities.HOST_STATUS).replaceAll("\\\\r\\\\n", StringUtilities.LF).getBytes();
        } catch (IOException unused) {
            throw new ConnectionException("Malformed status response - unable to determine printer status");
        }
    }

    @Override // com.zebra.sdk.printer.internal.PrinterStatusZpl
    public int findStartOfHsResponse(byte[] bArr) {
        return 0;
    }

    @Override // com.zebra.sdk.printer.internal.PrinterStatusZpl
    public byte getLineSeparatorChar() {
        return (byte) 10;
    }

    @Override // com.zebra.sdk.printer.internal.PrinterStatusZpl
    public byte[] getStatusInfoFromPrinter() throws ConnectionException {
        byte[] bArrSendAndWaitForValidResponse = this.printerConnection.sendAndWaitForValidResponse("{}{\"device.host_status\":null}".getBytes(), this.printerConnection.getMaxTimeoutForRead(), this.printerConnection.getTimeToWaitForMoreData(), new JsonValidator());
        if (bArrSendAndWaitForValidResponse.length > 0) {
            return parseJsonStatusResponse(new String(bArrSendAndWaitForValidResponse));
        }
        throw new ConnectionException("Malformed status response - unable to determine printer status");
    }
}
