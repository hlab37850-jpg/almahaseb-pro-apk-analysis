package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterObjectProperties;
import com.zebra.sdk.printer.internal.PrinterFilePropertiesCisdf;
import com.zebra.sdk.util.internal.CisdfFileSender;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.MultipartFileSender;
import com.zebra.sdk.util.internal.PrinterFileDescriptor;
import com.zebra.sdk.util.internal.PrinterFilePath;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FileStorer extends PrinterOperationCaresAboutLinkOsVersion<List<PrinterObjectProperties>> {
    private static final long serialVersionUID = -7215787839779520344L;
    private List<PrinterFileDescriptor> fileDescriptors;

    public FileStorer(List<PrinterFileDescriptor> list, Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        super(connection, printerLanguage, linkOsInformation);
        this.fileDescriptors = list;
    }

    private List<PrinterObjectProperties> createPrinterFilePropertiesFromFileDescriptors() {
        ArrayList arrayList = new ArrayList();
        for (PrinterFileDescriptor printerFileDescriptor : this.fileDescriptors) {
            try {
                PrinterFilePath driveAndExtension = FileUtilities.parseDriveAndExtension(printerFileDescriptor.getName());
                arrayList.add(new PrinterFilePropertiesCisdf(driveAndExtension.getDrive().substring(0, 1) + ":", driveAndExtension.getFileName(), driveAndExtension.getExtension().substring(1), printerFileDescriptor.getFileSize()));
            } catch (ZebraIllegalArgumentException unused) {
            }
        }
        return arrayList;
    }

    private void isOkToProceed() throws ConnectionException {
        if (isLinkOs2_5_OrHigher()) {
            return;
        }
        Connection connection = this.connection;
        if ((connection instanceof StatusConnection) || !connection.isConnected()) {
            throw new ConnectionException("Cannot store objects over status channel on this version of firmware");
        }
    }

    private boolean shouldSendMultipartForm() {
        return isLinkOs2_5_OrHigher() && (this.printerLanguage != PrinterLanguage.LINE_PRINT || (this.connection instanceof StatusConnection));
    }

    private List<PrinterObjectProperties> storeFile() throws ConnectionException {
        new ArrayList();
        if (shouldSendMultipartForm()) {
            return MultipartFileSender.send(this.connection, this.fileDescriptors);
        }
        CisdfFileSender.send(this.connection, this.fileDescriptors);
        return createPrinterFilePropertiesFromFileDescriptors();
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public List<PrinterObjectProperties> execute() throws ConnectionException {
        selectProperChannel();
        isOkToProceed();
        return storeFile();
    }
}
