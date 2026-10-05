package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.settings.SettingsException;
import com.zebra.sdk.settings.internal.ZebraSettingsListFromConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsGrabberOperation extends PrinterOperationBase<Map<String, Setting>> {
    private static final long serialVersionUID = 561030993363812422L;

    public SettingsGrabberOperation(Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
    }

    private void isOkToProceed() throws ConnectionException {
        if (isPrintingChannelInLineMode()) {
            throw new ConnectionException("Cannot retrieve settings from printer over printing channel when in line mode");
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Map<String, Setting> execute() throws ConnectionException {
        selectStatusChannelIfOpen();
        isOkToProceed();
        try {
            Map<String, Setting> allSettings = new ZebraSettingsListFromConnection(this.connection).getAllSettings();
            if (allSettings == null || allSettings.isEmpty()) {
                throw new SettingsException("Error Retrieving Settings or No Printer Connection");
            }
            return allSettings;
        } catch (SettingsException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }
}
