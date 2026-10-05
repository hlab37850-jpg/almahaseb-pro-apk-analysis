package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterStatus;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.settings.internal.JsonValidator;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraPrinterZpl extends ZebraPrinterA {
    PrinterLanguage language;

    public ZebraPrinterZpl(Connection connection) {
        super(connection);
        this.language = null;
        this.fileUtil = new FileUtilZpl(connection);
        this.formatUtil = new FormatUtilZpl(connection);
        this.graphicsUtil = new GraphicsUtilZpl(connection);
        this.toolsUtil = new ToolsUtilZpl(connection);
    }

    private PrinterLanguage getLanguageViaJson(Connection connection) throws ZebraPrinterLanguageUnknownException {
        try {
            return PrinterLanguage.getLanguage(StringUtilities.convertKeyValueJsonToMap(connection.sendAndWaitForValidResponse("{}{\"device.languages\":null}".getBytes(), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), new JsonValidator())).get(SGDUtilities.DEVICE_LANGUAGES));
        } catch (IOException unused) {
            throw new ZebraPrinterLanguageUnknownException("Zebra printer language could not be determined for " + connection.toString());
        }
    }

    private PrinterLanguage getLanguageViaSgd(Connection connection) {
        return PrinterLanguage.getLanguage(SGD.GET(SGDUtilities.DEVICE_LANGUAGES, connection));
    }

    private PrinterLanguage obtainLanguage(Connection connection) {
        PrinterLanguage printerLanguage = this.language;
        return printerLanguage == null ? queryPrinterLanguage(connection) : printerLanguage;
    }

    private PrinterLanguage queryPrinterLanguage(Connection connection) {
        if (connection instanceof MultichannelConnection) {
            MultichannelConnection multichannelConnection = (MultichannelConnection) connection;
            if (multichannelConnection.getStatusChannel().isConnected()) {
                return getLanguageViaJson(multichannelConnection.getStatusChannel());
            }
        } else if (connection instanceof StatusConnection) {
            return getLanguageViaJson(connection);
        }
        return getLanguageViaSgd(connection);
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public PrinterStatus getCurrentStatus() {
        return new PrinterStatusZpl(this.connection);
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public PrinterLanguage getPrinterControlLanguage() {
        try {
            this.language = obtainLanguage(this.connection);
        } catch (Exception unused) {
            this.language = PrinterLanguage.ZPL;
        }
        return this.language;
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public void setConnection(Connection connection) {
        this.connection = connection;
        this.fileUtil = new FileUtilZpl(connection);
        this.formatUtil = new FormatUtilZpl(this.connection);
        this.graphicsUtil = new GraphicsUtilZpl(this.connection);
        this.toolsUtil = new ToolsUtilZpl(this.connection);
    }
}
