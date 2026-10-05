package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.internal.ToolsUtilZpl;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigurationLabelPrinter extends PrinterOperationCaresAboutLinkOsVersion<Void> {
    private static final long serialVersionUID = -232786459659968863L;

    public ConfigurationLabelPrinter(Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        super(connection, printerLanguage, linkOsInformation);
    }

    private void isOkToProceed() throws ConnectionException {
        if (isLinkOs2_5_OrHigher()) {
            return;
        }
        Connection connection = this.connection;
        if ((connection instanceof StatusConnection) || !connection.isConnected()) {
            throw new ConnectionException("Cannot print config label over status channel on this version of firmware");
        }
    }

    private void printConfigLabel() {
        if (!isLinkOs2_5_OrHigher()) {
            new ToolsUtilZpl(this.connection).printConfigurationLabel();
        } else if (isPrintingChannelInLineMode()) {
            this.connection.write("! U1 setvar \"device.print_out_report\" \"settings\"\r\n".getBytes());
        } else {
            new PrinterCommandImpl("{}{\"device.print_out_report\":\"settings\"}").sendAndWaitForValidJsonResponse(this.connection);
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() throws ConnectionException {
        selectProperChannel();
        isOkToProceed();
        printConfigLabel();
        return null;
    }
}
