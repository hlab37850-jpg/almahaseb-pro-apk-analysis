package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.settings.internal.JsonHelper;
import com.zebra.sdk.settings.internal.JsonValidator;

/* JADX INFO: loaded from: classes3.dex */
public class SendJsonOperation extends PrinterOperationBase<String> {
    private static final long serialVersionUID = -898265088329695L;
    String jsonDataToSend;

    public SendJsonOperation(Connection connection, PrinterLanguage printerLanguage, String str) {
        super(connection, printerLanguage);
        this.jsonDataToSend = str;
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public String execute() throws ConnectionException {
        if (!JsonHelper.isValidJson(this.jsonDataToSend)) {
            throw new ConnectionException("Invalid JSON request.");
        }
        selectStatusChannelIfOpen();
        if (isPrintingChannelInLineMode()) {
            throw new ConnectionException("Cannot send JSON over raw port when printer is in line print mode.");
        }
        return new String(this.connection.sendAndWaitForValidResponse(this.jsonDataToSend.getBytes(), this.connection.getMaxTimeoutForRead(), this.connection.getTimeToWaitForMoreData(), new JsonValidator()));
    }
}
