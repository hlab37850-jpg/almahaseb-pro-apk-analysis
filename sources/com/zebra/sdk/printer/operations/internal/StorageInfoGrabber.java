package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.StorageInfo;
import com.zebra.sdk.printer.internal.FileUtilZpl;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class StorageInfoGrabber extends PrinterOperationCaresAboutLinkOsVersion<List<StorageInfo>> {
    public StorageInfoGrabber(Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        super(connection, printerLanguage, linkOsInformation);
    }

    private List<StorageInfo> getStorageInfo() {
        FileUtilZpl fileUtilZpl = new FileUtilZpl(this.connection);
        if (isLinkOs2_5_OrHigher()) {
            return isPrintingChannelInLineMode() ? fileUtilZpl.getStorageInfoViaSgd() : fileUtilZpl.getStorageInfoViaJsonChannel();
        }
        return fileUtilZpl.getStorageInfo();
    }

    private void isOkToProceed() throws ConnectionException {
        if (isLinkOs2_5_OrHigher()) {
            return;
        }
        Connection connection = this.connection;
        if (connection instanceof StatusConnection) {
            throw new ConnectionException("Cannot retrieve storage info over the status channel on this version of firmware");
        }
        if (this.printerLanguage == PrinterLanguage.LINE_PRINT) {
            throw new ConnectionException("Cannot retrieve storage info when in line print mode on this version of firmware");
        }
        if (!connection.isConnected()) {
            throw new ConnectionException("Cannot retrieve storage info when there is no valid connection");
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperationCaresAboutLinkOsVersion
    public void selectProperChannel() {
        if (isLinkOs2_5_OrHigher()) {
            selectStatusChannelIfOpen();
            return;
        }
        Connection connection = this.connection;
        if (connection instanceof MultichannelConnection) {
            this.connection = ((MultichannelConnection) connection).getPrintingChannel();
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public List<StorageInfo> execute() throws ConnectionException {
        selectProperChannel();
        isOkToProceed();
        return getStorageInfo();
    }
}
