package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.internal.MultipartFormReceiverStream;
import com.zebra.sdk.printer.internal.PrinterConnectionInputStream;
import com.zebra.sdk.util.internal.FileWrapper;
import com.zebra.sdk.util.internal.MultipartFileRequester;
import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectGrabberOperation extends PrinterOperationCaresAboutLinkOsVersion<InputStream> {
    private static final long serialVersionUID = -7856575708124729815L;
    protected long MAX_INTER_CHARACTER_DELAY_TIME;
    private String fullObjectPath;

    public ObjectGrabberOperation(String str, Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        super(connection, printerLanguage, linkOsInformation);
        this.MAX_INTER_CHARACTER_DELAY_TIME = 15000L;
        if (str == null || 2 >= str.length()) {
            throw new IllegalArgumentException("File name not provided");
        }
        if (str.charAt(1) != ':') {
            throw new IllegalArgumentException("Drive letter not specified");
        }
        this.fullObjectPath = str;
    }

    private void isOkToProceed() throws ConnectionException {
        if (!isLinkOs2_5_OrHigher()) {
            Connection connection = this.connection;
            if ((connection instanceof StatusConnection) || !connection.isConnected()) {
                throw new ConnectionException("Cannot retrieve objects over status channel on this version of firmware");
            }
        }
        if (isPrintingChannelInLineMode()) {
            throw new ConnectionException("Cannot retrieve objects from printer over printing channel when in line mode");
        }
    }

    private InputStream retrieveStreamToObject() throws ConnectionException {
        if (shouldRequestMultipartForm()) {
            MultipartFileRequester.send(this.connection, this.fullObjectPath);
            return new MultipartFormReceiverStream(this.connection, this.MAX_INTER_CHARACTER_DELAY_TIME);
        }
        String str = this.fullObjectPath;
        if (!FileWrapper.isHzoExtension(str.substring(str.lastIndexOf(46) + 1))) {
            return null;
        }
        try {
            this.connection.write(ZPLUtilities.getHZO(this.fullObjectPath).getBytes());
            return new PrinterConnectionInputStream(this.connection, this.MAX_INTER_CHARACTER_DELAY_TIME, "</ZEBRA-ELTRON-PERSONALITY>\r\n");
        } catch (ZebraIllegalArgumentException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    private boolean shouldRequestMultipartForm() {
        return isLinkOs2_5_OrHigher() && (this.printerLanguage != PrinterLanguage.LINE_PRINT || (this.connection instanceof StatusConnection));
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public InputStream execute() throws ConnectionException {
        selectProperChannel();
        isOkToProceed();
        return retrieveStreamToObject();
    }
}
