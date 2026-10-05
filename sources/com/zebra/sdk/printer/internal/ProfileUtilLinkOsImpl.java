package com.zebra.sdk.printer.internal;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.device.Profile;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.FileDeletionOption;
import com.zebra.sdk.printer.FirmwareUpdateHandler;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterAlert;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.ProfileUtil;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.printer.discovery.DiscoveryException;
import com.zebra.sdk.settings.SettingsException;
import com.zebra.sdk.settings.internal.ConnectionUtil;
import com.zebra.sdk.settings.internal.JsonValidator;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.FileWrapper;
import com.zebra.sdk.util.internal.MultipartFileSender;
import com.zebra.sdk.util.internal.PrinterFileDescriptor;
import com.zebra.sdk.util.internal.PrinterFileMetadata;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.ZipUtil;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class ProfileUtilLinkOsImpl implements ProfileUtil {
    protected String drivePrefix = "*:";
    protected final ZebraPrinterLinkOsImpl linkOsPrinter;

    /* JADX INFO: renamed from: com.zebra.sdk.printer.internal.ProfileUtilLinkOsImpl$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$zebra$sdk$printer$FileDeletionOption;

        static {
            int[] iArr = new int[FileDeletionOption.values().length];
            $SwitchMap$com$zebra$sdk$printer$FileDeletionOption = iArr;
            try {
                iArr[FileDeletionOption.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$FileDeletionOption[FileDeletionOption.CLONEABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zebra$sdk$printer$FileDeletionOption[FileDeletionOption.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ProfileUtilLinkOsImpl(ZebraPrinterLinkOsImpl zebraPrinterLinkOsImpl) {
        this.linkOsPrinter = zebraPrinterLinkOsImpl;
    }

    private boolean containsCisdWrapper(String str) {
        String strTrim = str.trim();
        return strTrim.startsWith(FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_FLASH) || strTrim.startsWith(FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_RAM);
    }

    private void createOutputZipFile(OutputStream outputStream, byte[] bArr) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        boolean z = false;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(outputStream));
            try {
                zipOutputStream2.putNextEntry(new ZipEntry(ProfileHelper.SETTINGS_JSON_NAME));
                zipOutputStream2.write(bArr);
                zipOutputStream2.closeEntry();
                Connection connection = this.linkOsPrinter.getConnection();
                if (this.linkOsPrinter.getPrinterControlLanguage() == PrinterLanguage.LINE_PRINT && !(connection instanceof StatusConnection) && !(connection instanceof MultichannelConnection)) {
                    z = true;
                }
                if (z) {
                    enableZplMode(this.linkOsPrinter);
                }
                try {
                    String strCreateJson = ProfileHelper.createJson(this.linkOsPrinter.getConfiguredAlerts());
                    zipOutputStream2.putNextEntry(new ZipEntry(ProfileHelper.ALERTS_JSON_NAME));
                    zipOutputStream2.write(strCreateJson.getBytes());
                    zipOutputStream2.closeEntry();
                    saveFilesToProfile(zipOutputStream2, this.linkOsPrinter);
                    if (z) {
                        try {
                            reEnableLinePrintMode(this.linkOsPrinter);
                        } catch (ConnectionException unused) {
                        }
                    }
                    zipOutputStream2.close();
                } catch (SettingsException e) {
                    throw new IOException(e);
                }
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                if (z) {
                    try {
                        reEnableLinePrintMode(this.linkOsPrinter);
                    } catch (ConnectionException unused2) {
                    }
                }
                if (zipOutputStream == null) {
                    throw th;
                }
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void deleteAllCloneableFiles() {
        for (String str : new HashSet(Arrays.asList("ZPL", "GRF", "DAT", "BAS", "STO", "PNG", "LBL", "PCX", "BMP", "IMG", "WML", "HTM"))) {
            try {
                this.linkOsPrinter.deleteFile(this.drivePrefix + "*." + str);
            } catch (ConnectionException unused) {
            }
        }
    }

    private void deleteAllFiles() {
        try {
            this.linkOsPrinter.deleteFile(this.drivePrefix + "*.*");
        } catch (ConnectionException unused) {
        }
    }

    private void deleteFilesBeforeLoadingProfile(FileDeletionOption fileDeletionOption) {
        int i = AnonymousClass2.$SwitchMap$com$zebra$sdk$printer$FileDeletionOption[fileDeletionOption.ordinal()];
        if (i == 1) {
            deleteAllFiles();
        } else {
            if (i != 2) {
                return;
            }
            deleteAllCloneableFiles();
        }
    }

    private void enableZplMode(ZebraPrinterLinkOsImpl zebraPrinterLinkOsImpl) {
        SGD.SET(SGDUtilities.DEVICE_LANGUAGES, "zpl", zebraPrinterLinkOsImpl.getConnection());
    }

    private byte[] getAllConfig() {
        return ConnectionUtil.selectConnection(this.linkOsPrinter.getConnection()).sendAndWaitForValidResponse("{}{\"allconfig\":null}".getBytes(), Constants.CP_MAC_ROMAN, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, new JsonValidator());
    }

    private PrinterFileDescriptor getFileDescriptors(byte[] bArr, String str) throws IOException {
        if (containsCisdWrapper(new String(bArr))) {
            bArr = FileWrapper.stripOffCISDFWrapper(bArr);
        } else if (FileWrapper.isHzoExtension(FilenameUtils.getExtension(str))) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                FileWrapper.unwrapHZOResult(byteArrayOutputStream, str, new String(bArr));
                bArr = byteArrayOutputStream.toByteArray();
            } catch (ZebraIllegalArgumentException e) {
                throw new IOException(e);
            }
        }
        return new PrinterFileDescriptor(new ByteArrayInputStream(bArr), str, new PrinterFileMetadata(bArr.length, "0000", "0000"));
    }

    private boolean isCloneable(String str) {
        if (str.toUpperCase().startsWith("Z:")) {
            return false;
        }
        return isValidExtension(str);
    }

    private boolean isLinkOs2_5_OrHigher(LinkOsInformation linkOsInformation) {
        if (linkOsInformation.getMajor() == 2) {
            return linkOsInformation.getMinor() >= 5;
        }
        return linkOsInformation.getMajor() >= 3;
    }

    private boolean isValidExtension(String str) {
        return !new HashSet(Arrays.asList("PAC", "NRD", "BAZ", "BAE", "TTF", "TTE", "TXT", "CSV")).contains(str.substring(str.lastIndexOf(46) + 1));
    }

    private void loadAlertsFromProfile(String str) {
        List<PrinterAlert> alertsFromJson = ProfileHelper.getAlertsFromJson(str);
        try {
            this.linkOsPrinter.removeAllAlerts();
            this.linkOsPrinter.configureAlerts(alertsFromJson);
        } catch (ConnectionException unused) {
        }
    }

    private void loadCloneOrArchiveImage(String str, RestoreType restoreType, boolean z) throws IOException, ConnectionException {
        loadFirmwareFromProfile(str, z);
        restoreSettings(str, restoreType);
        loadAlertsFromProfile(str);
        loadFilesFromProfile(str);
        loadSupplementFromProfile(str);
    }

    private void loadFilesFromProfile(String str) throws IOException {
        ZipUtil zipUtil = new ZipUtil(str);
        List<String> entryNames = zipUtil.getEntryNames();
        ArrayList arrayList = new ArrayList();
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(this.linkOsPrinter.getConnection());
        for (String str2 : entryNames) {
            if (!ProfileHelper.isSpecialProfileFile(str2)) {
                byte[] bArrExtractEntry = zipUtil.extractEntry(str2);
                if (shouldSendMultipartForm(connectionSelectConnection, this.linkOsPrinter)) {
                    arrayList.add(getFileDescriptors(bArrExtractEntry, str2));
                } else {
                    connectionSelectConnection.write(bArrExtractEntry);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        MultipartFileSender.send(connectionSelectConnection, arrayList);
    }

    private void loadFirmwareFromProfile(String str, boolean z) {
        ZipUtil zipUtil = new ZipUtil(str);
        if (zipUtil.containsEntry(ProfileHelper.FIRMWARE_FILE_NAME)) {
            File fileCreateTempFile = null;
            try {
                try {
                    try {
                        fileCreateTempFile = File.createTempFile("sdkTmpFwFile", "txt");
                        zipUtil.extractEntry(fileCreateTempFile.getAbsolutePath(), ProfileHelper.FIRMWARE_FILE_NAME);
                        this.linkOsPrinter.updateFirmware(fileCreateTempFile.getAbsolutePath(), new FirmwareUpdateHandlerVerboseDecorator(z, this.linkOsPrinter.getConnection().toString(), str, new FirmwareUpdateHandler() { // from class: com.zebra.sdk.printer.internal.ProfileUtilLinkOsImpl.1
                            @Override // com.zebra.sdk.printer.FirmwareUpdateHandlerBase
                            public void firmwareDownloadComplete() {
                            }

                            @Override // com.zebra.sdk.printer.PrinterReconnectionHandler
                            public void printerOnline(ZebraPrinterLinkOs zebraPrinterLinkOs, String str2) {
                                Connection connection = zebraPrinterLinkOs.getConnection();
                                try {
                                    connection.open();
                                    ProfileUtilLinkOsImpl.this.linkOsPrinter.setConnection(connection);
                                } catch (ConnectionException unused) {
                                }
                            }

                            @Override // com.zebra.sdk.printer.FirmwareUpdateHandlerBase
                            public void progressUpdate(int i, int i2) {
                            }
                        }));
                        fileCreateTempFile.delete();
                    } catch (ZebraPrinterLanguageUnknownException e) {
                        throw new ConnectionException(e.getMessage());
                    } catch (TimeoutException e2) {
                        throw new ConnectionException(e2.getMessage());
                    }
                } catch (ZebraIllegalArgumentException e3) {
                    throw new ConnectionException(e3.getMessage());
                } catch (DiscoveryException e4) {
                    throw new ConnectionException(e4.getMessage());
                }
            } catch (Throwable th) {
                if (fileCreateTempFile != null) {
                    fileCreateTempFile.delete();
                }
                throw th;
            }
        }
    }

    private void loadSupplementFromProfile(String str) throws IOException {
        byte[] bArrExtractEntry = new ZipUtil(str).extractEntry(ProfileHelper.PROFILE_SUPPLEMENT_NAME);
        if (bArrExtractEntry.length > 0) {
            this.linkOsPrinter.getConnection().write(bArrExtractEntry);
        }
    }

    private void reEnableLinePrintMode(ZebraPrinterLinkOsImpl zebraPrinterLinkOsImpl) {
        SGD.SET(SGDUtilities.DEVICE_LANGUAGES, "line_print", zebraPrinterLinkOsImpl.getConnection());
    }

    private void restoreSettings(String str, RestoreType restoreType) throws IOException, ConnectionException {
        new LinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Profile profile = new Profile(str);
        try {
            Map<String, String> archivableSettingValues = restoreType == RestoreType.ARCHIVE ? profile.getArchivableSettingValues() : profile.getClonableSettingValues();
            ProfileHelper.handleSpecialCases(archivableSettingValues, restoreType);
            try {
                int i = 0;
                for (String str2 : archivableSettingValues.keySet()) {
                    linkedHashMap.put(str2, archivableSettingValues.get(str2));
                    if (i >= 100) {
                        this.linkOsPrinter.setSettings(linkedHashMap);
                        linkedHashMap = new LinkedHashMap();
                        i = 0;
                    }
                    i++;
                }
                this.linkOsPrinter.setSettings(linkedHashMap);
            } catch (SettingsException e) {
                throw new ConnectionException(e.getLocalizedMessage());
            }
        } catch (SettingsException e2) {
            throw new IOException(e2.getLocalizedMessage());
        }
    }

    private void saveFilesToProfile(ZipOutputStream zipOutputStream, ZebraPrinterLinkOs zebraPrinterLinkOs) throws IOException {
        String[] strArrRetrieveFileNames = zebraPrinterLinkOs.retrieveFileNames();
        for (int i = 0; i < strArrRetrieveFileNames.length; i++) {
            if (isCloneable(strArrRetrieveFileNames[i])) {
                try {
                    byte[] printerDownloadableObjectFromPrinter = zebraPrinterLinkOs.getPrinterDownloadableObjectFromPrinter(strArrRetrieveFileNames[i]);
                    if (printerDownloadableObjectFromPrinter.length > 0) {
                        zipOutputStream.putNextEntry(new ZipEntry(strArrRetrieveFileNames[i]));
                        zipOutputStream.write(printerDownloadableObjectFromPrinter);
                        zipOutputStream.closeEntry();
                    }
                } catch (ZebraIllegalArgumentException unused) {
                }
            }
        }
    }

    private boolean shouldSendMultipartForm(Connection connection, ZebraPrinterLinkOs zebraPrinterLinkOs) {
        return isLinkOs2_5_OrHigher(zebraPrinterLinkOs.getLinkOsInformation()) && (zebraPrinterLinkOs.getPrinterControlLanguage() != PrinterLanguage.LINE_PRINT || (connection instanceof StatusConnection));
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void createBackup(String str) throws Throwable {
        createProfile(str);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void createProfile(OutputStream outputStream) throws Throwable {
        createOutputZipFile(outputStream, getAllConfig());
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void loadBackup(String str) throws IOException, ConnectionException {
        loadBackup(str, false);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void loadProfile(String str) throws IOException, ConnectionException {
        loadProfile(str, FileDeletionOption.NONE, false);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void createProfile(String str) throws Throwable {
        FileOutputStream fileOutputStream = new FileOutputStream(FileUtilities.changeExtension(str, "zprofile"));
        createOutputZipFile(fileOutputStream, getAllConfig());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void loadBackup(String str, boolean z) throws IOException, ConnectionException {
        deleteFilesBeforeLoadingProfile(FileDeletionOption.ALL);
        loadCloneOrArchiveImage(str, RestoreType.ARCHIVE, z);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void loadProfile(String str, FileDeletionOption fileDeletionOption, boolean z) throws IOException, ConnectionException {
        deleteFilesBeforeLoadingProfile(fileDeletionOption);
        loadCloneOrArchiveImage(str, RestoreType.CLONE, z);
    }
}
