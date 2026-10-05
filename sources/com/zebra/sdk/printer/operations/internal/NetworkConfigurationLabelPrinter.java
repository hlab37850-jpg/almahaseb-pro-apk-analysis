package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.internal.ToolsUtilLinkOsHelper;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkConfigurationLabelPrinter extends PrinterOperationCaresAboutLinkOsVersion<Void> {
    private static final long serialVersionUID = -232786459659968863L;

    public NetworkConfigurationLabelPrinter(Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        super(connection, printerLanguage, linkOsInformation);
    }

    private void isOkToProceed() throws ConnectionException {
        if (isLinkOs2_5_OrHigher()) {
            return;
        }
        Connection connection = this.connection;
        if ((connection instanceof StatusConnection) || !connection.isConnected()) {
            throw new ConnectionException("Cannot print network config label over status channel on this version of firmware");
        }
    }

    private void printNetworkConfigLabel() {
        if (!isLinkOs2_5_OrHigher()) {
            new ToolsUtilLinkOsHelper(this.connection, this.printerLanguage).printNetworkConfigurationLabel();
        } else if (isPrintingChannelInLineMode()) {
            this.connection.write("! U1 setvar \"device.print_out_report\" \"network\"\r\n".getBytes());
        } else {
            new PrinterCommandImpl("{}{\"device.print_out_report\":\"network\"}").sendAndWaitForValidJsonResponse(this.connection);
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() throws ConnectionException {
        selectProperChannel();
        isOkToProceed();
        printNetworkConfigLabel();
        return null;
    }
}
