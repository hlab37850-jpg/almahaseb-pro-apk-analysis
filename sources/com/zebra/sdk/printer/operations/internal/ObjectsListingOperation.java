package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.printer.DriveType;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterObjectProperties;
import com.zebra.sdk.printer.StorageInfo;
import com.zebra.sdk.printer.internal.FileUtilZpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectsListingOperation extends PrinterOperationCaresAboutLinkOsVersion<List<PrinterObjectProperties>> {
    private static final long serialVersionUID = 8426279194940766859L;
    private final Set<DriveType> driveTypes;

    public ObjectsListingOperation(Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        this(connection, printerLanguage, linkOsInformation, new HashSet());
    }

    private void isOkToProceed() throws ConnectionException {
        if (isLinkOs2_5_OrHigher()) {
            return;
        }
        if (this.connection instanceof StatusConnection) {
            throw new ConnectionException("Cannot retrieve object listing over the status channel on this version of firmware");
        }
        if (this.printerLanguage == PrinterLanguage.LINE_PRINT) {
            throw new ConnectionException("Cannot retrieve object listing when in line print mode on this version of firmware");
        }
    }

    private List<PrinterObjectProperties> retrieveObjectListing() throws ConnectionException {
        try {
            List<StorageInfo> arrayList = new ArrayList<>();
            Set<DriveType> set = this.driveTypes;
            if (set != null && set.size() > 0) {
                arrayList = new StorageInfoGrabber(this.connection, this.printerLanguage, this.linkOsInformation).execute();
            }
            if (!shouldRetrieveViaFileListing() && !isLinkOs2_5_OrHigher()) {
                return new FileUtilZpl(this.connection).retrieveObjectsProperties(arrayList, this.driveTypes);
            }
            return new FileUtilZpl(this.connection).retrieveObjectsPropertiesWithCrc32(arrayList, this.driveTypes, this.printerLanguage);
        } catch (Exception e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    private boolean shouldRetrieveViaFileListing() {
        return isLinkOs2_5_OrHigher() && (this.printerLanguage != PrinterLanguage.LINE_PRINT || (this.connection instanceof StatusConnection));
    }

    public ObjectsListingOperation(Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation, Set<DriveType> set) {
        super(connection, printerLanguage, linkOsInformation);
        this.driveTypes = set;
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public List<PrinterObjectProperties> execute() throws ConnectionException {
        selectProperChannel();
        isOkToProceed();
        return retrieveObjectListing();
    }
}
