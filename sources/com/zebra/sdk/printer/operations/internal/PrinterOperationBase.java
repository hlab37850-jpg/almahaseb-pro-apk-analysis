package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.printer.PrinterLanguage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PrinterOperationBase<T> implements PrinterOperation<T> {
    protected Connection connection;
    protected PrinterLanguage printerLanguage;

    public PrinterOperationBase(Connection connection, PrinterLanguage printerLanguage) {
        this.connection = connection;
        this.printerLanguage = printerLanguage;
    }

    public boolean isPrintingChannelInLineMode() {
        return !(this.connection instanceof StatusConnection) && this.printerLanguage == PrinterLanguage.LINE_PRINT;
    }

    public void selectStatusChannelIfOpen() {
        Connection connection = this.connection;
        if (connection instanceof MultichannelConnection) {
            MultichannelConnection multichannelConnection = (MultichannelConnection) connection;
            this.connection = multichannelConnection.getStatusChannel().isConnected() ? multichannelConnection.getStatusChannel() : multichannelConnection.getPrintingChannel();
        }
    }
}
