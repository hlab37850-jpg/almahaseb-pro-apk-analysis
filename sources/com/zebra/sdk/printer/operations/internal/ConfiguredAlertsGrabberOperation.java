package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.PrinterAlert;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.settings.internal.AlertsUtilLinkOs;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ConfiguredAlertsGrabberOperation extends PrinterOperationBase<List<PrinterAlert>> {
    private static final long serialVersionUID = 561030993363812422L;

    public ConfiguredAlertsGrabberOperation(Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
    }

    private void isOkToProceed() throws ConnectionException {
        if (isPrintingChannelInLineMode()) {
            throw new ConnectionException("Cannot retrieve settings from printer over printing channel when in line mode");
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public List<PrinterAlert> execute() throws ConnectionException {
        selectStatusChannelIfOpen();
        isOkToProceed();
        try {
            return new AlertsUtilLinkOs(this.connection).getAlerts();
        } catch (ZebraIllegalArgumentException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }
}
