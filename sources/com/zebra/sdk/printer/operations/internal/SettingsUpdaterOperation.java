package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.settings.SettingsException;
import com.zebra.sdk.settings.internal.ZebraSettingsListFromConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsUpdaterOperation extends PrinterOperationBase<Void> {
    private static final long serialVersionUID = 561030993363812422L;
    private Map<String, String> settingsToSet;

    public SettingsUpdaterOperation(Connection connection, Map<String, String> map, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
        this.settingsToSet = map;
    }

    private void isOkToProceed() throws ConnectionException {
        if (isPrintingChannelInLineMode()) {
            throw new ConnectionException("Cannot update settings over printing channel when in line mode");
        }
    }

    public Map<String, String> process() throws ConnectionException {
        selectStatusChannelIfOpen();
        isOkToProceed();
        try {
            return new ZebraSettingsListFromConnection(this.connection).processSettingsViaMap(this.settingsToSet);
        } catch (SettingsException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() throws ConnectionException {
        selectStatusChannelIfOpen();
        isOkToProceed();
        try {
            new ZebraSettingsListFromConnection(this.connection).setSettings(this.settingsToSet);
            return null;
        } catch (SettingsException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }
}
