package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PrinterOperationCaresAboutLinkOsVersion<T> extends PrinterOperationBase<T> {
    protected LinkOsInformation linkOsInformation;

    public PrinterOperationCaresAboutLinkOsVersion(Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        super(connection, printerLanguage);
        this.linkOsInformation = linkOsInformation;
    }

    public boolean isLinkOs2_5_OrHigher() {
        if (this.linkOsInformation.getMajor() == 2) {
            return this.linkOsInformation.getMinor() >= 5;
        }
        return this.linkOsInformation.getMajor() >= 3;
    }

    public void selectProperChannel() {
        if (this.connection instanceof MultichannelConnection) {
            if (isLinkOs2_5_OrHigher()) {
                selectStatusChannelIfOpen();
            } else {
                this.connection = ((MultichannelConnection) this.connection).getPrintingChannel();
            }
        }
    }
}
