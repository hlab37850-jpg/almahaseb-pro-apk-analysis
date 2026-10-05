package com.zebra.sdk.device;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import com.zebra.sdk.printer.AlertProvider;
import com.zebra.sdk.printer.FontConverterZpl;
import com.zebra.sdk.printer.FontUtil;
import com.zebra.sdk.printer.GraphicsUtil;
import com.zebra.sdk.printer.PrinterAlert;
import com.zebra.sdk.printer.PrinterObjectProperties;
import com.zebra.sdk.printer.StorageInfo;
import com.zebra.sdk.printer.internal.GraphicsConversionUtilZpl;
import com.zebra.sdk.printer.internal.PrinterFilePropertiesZpl;
import com.zebra.sdk.printer.internal.ProfileHelper;
import com.zebra.sdk.settings.AlertCondition;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.settings.SettingsException;
import com.zebra.sdk.settings.internal.ZebraSettingsListFromProfile;
import com.zebra.sdk.settings.internal.ZebraSettingsListI;
import com.zebra.sdk.util.internal.FileReader;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.FileWrapper;
import com.zebra.sdk.util.internal.PrinterFilePath;
import com.zebra.sdk.util.internal.ReflectionUtil;
import com.zebra.sdk.util.internal.ZipUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class Profile implements Device, FileUtil, FontUtil, AlertProvider, FileUtilLinkOs, GraphicsUtil {
    private final String pathToProfile;
    private ZebraSettingsListI profileBasedSettingsList;

    public Profile(String str) {
        this.profileBasedSettingsList = null;
        this.pathToProfile = str;
        this.profileBasedSettingsList = new ZebraSettingsListFromProfile(str);
    }

    private boolean isMatchingAlert(PrinterAlert printerAlert, PrinterAlert printerAlert2) {
        boolean z = printerAlert2.getCondition() == printerAlert.getCondition() && printerAlert2.getDestination() == printerAlert.getDestination();
        return z && !(z && printerAlert2.getCondition() == AlertCondition.SGD_SET && !printerAlert.getSgdName().equals(printerAlert2.getSgdName()));
    }

    private boolean shouldArchive(String str) {
        return (!this.profileBasedSettingsList.isSettingArchivable(str) || this.profileBasedSettingsList.isSettingWriteOnly(str) || this.profileBasedSettingsList.isSettingReadOnly(str)) ? false : true;
    }

    private boolean shouldClone(String str) {
        return (!this.profileBasedSettingsList.isSettingClonable(str) || this.profileBasedSettingsList.isSettingWriteOnly(str) || this.profileBasedSettingsList.isSettingReadOnly(str)) ? false : true;
    }

    public void addFirmware(String str) throws IOException {
        new ZipUtil(this.pathToProfile).addEntry(ProfileHelper.FIRMWARE_FILE_NAME, new File(str), new File(str).getName().getBytes());
    }

    public void addSupplement(byte[] bArr) throws IOException {
        new ZipUtil(this.pathToProfile).addEntry(ProfileHelper.PROFILE_SUPPLEMENT_NAME, bArr);
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public void configureAlert(PrinterAlert printerAlert) throws ConnectionException {
        try {
            List<PrinterAlert> alertsFromJson = ProfileHelper.getAlertsFromJson(this.pathToProfile);
            for (int i = 0; i < alertsFromJson.size(); i++) {
                if (isMatchingAlert(alertsFromJson.get(i), printerAlert)) {
                    alertsFromJson.remove(i);
                    break;
                }
            }
            if (printerAlert.isOnSet() || printerAlert.isOnClear()) {
                alertsFromJson.add(printerAlert);
            }
            ProfileHelper.commitAlertsToProfile(this.pathToProfile, alertsFromJson);
        } catch (Exception e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public void configureAlerts(List<PrinterAlert> list) throws ConnectionException {
        Iterator<PrinterAlert> it = list.iterator();
        while (it.hasNext()) {
            configureAlert(it.next());
        }
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void deleteFile(String str) throws ConnectionException {
        try {
            ProfileHelper.deleteFileFromProfile(this.pathToProfile, str);
        } catch (Exception e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.printer.FontUtil
    public void downloadTteFont(InputStream inputStream, String str) throws ConnectionException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FontConverterZpl.saveAsTtePrinterFont(inputStream, byteArrayOutputStream, str);
        try {
            new ZipUtil(this.pathToProfile).addEntry(str, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.printer.FontUtil
    public void downloadTtfFont(InputStream inputStream, String str) throws ConnectionException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FontConverterZpl.saveAsTtfPrinterFont(inputStream, byteArrayOutputStream, str);
        try {
            new ZipUtil(this.pathToProfile).addEntry(str, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Map<String, String> getAllSettingValues() {
        return this.profileBasedSettingsList.getAllSettingValues();
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Map<String, Setting> getAllSettings() {
        return this.profileBasedSettingsList.getAllSettings();
    }

    public Map<String, String> getArchivableSettingValues() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : getAvailableSettings()) {
            try {
                if (shouldArchive(str)) {
                    linkedHashMap.put(str, this.profileBasedSettingsList.getValue(str));
                }
            } catch (ConnectionException | ZebraIllegalArgumentException | SettingsException unused) {
            }
        }
        return linkedHashMap;
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Set<String> getAvailableSettings() {
        return getAllSettingValues().keySet();
    }

    public Map<String, String> getClonableSettingValues() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : getAvailableSettings()) {
            try {
                if (shouldClone(str)) {
                    linkedHashMap.put(str, this.profileBasedSettingsList.getValue(str));
                }
            } catch (ConnectionException | ZebraIllegalArgumentException | SettingsException unused) {
            }
        }
        return linkedHashMap;
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public List<PrinterAlert> getConfiguredAlerts() throws ZebraIllegalArgumentException {
        try {
            return ProfileHelper.getAlertsFromJson(this.pathToProfile);
        } catch (Exception e) {
            throw new ZebraIllegalArgumentException(e.getMessage());
        }
    }

    public String getFirmwareFilename() throws IOException {
        String entryExtraContent = new ZipUtil(this.pathToProfile).getEntryExtraContent(ProfileHelper.FIRMWARE_FILE_NAME);
        return entryExtraContent.isEmpty() ? new ZipUtil(this.pathToProfile).getEntryContents(ProfileHelper.FIRMWARE_FILE_USER_SPECIFIED_NAME) : entryExtraContent;
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void getObjectFromPrinter(OutputStream outputStream, String str) throws ZebraIllegalArgumentException {
        try {
            try {
                try {
                    byte[] bArrExtractEntry = new ZipUtil(this.pathToProfile).extractEntry(str);
                    if (FileWrapper.isHzoExtension(str.substring(str.lastIndexOf(46) + 1))) {
                        FileWrapper.unwrapHZOResult(outputStream, str, new String(bArrExtractEntry));
                    } else {
                        outputStream.write(FileWrapper.stripOffCISDFWrapper(bArrExtractEntry));
                    }
                } catch (FileNotFoundException e) {
                    throw new ZebraIllegalArgumentException(e.getLocalizedMessage());
                }
            } catch (IOException e2) {
                throw new ZebraIllegalArgumentException(e2.getLocalizedMessage());
            }
        } catch (IOException e3) {
            throw new ZebraIllegalArgumentException(e3.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void getObjectFromPrinterViaFtp(OutputStream outputStream, String str, String str2) throws ZebraIllegalArgumentException {
        throw new ZebraIllegalArgumentException("Cannot access a profile over FTP");
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getPrinterDownloadableObjectFromPrinter(String str) throws ZebraIllegalArgumentException {
        try {
            return new ZipUtil(this.pathToProfile).extractEntry(str);
        } catch (FileNotFoundException e) {
            throw new ZebraIllegalArgumentException(e.getLocalizedMessage());
        } catch (IOException e2) {
            throw new ZebraIllegalArgumentException(e2.getLocalizedMessage());
        }
    }

    public Setting getSetting(String str) {
        return this.profileBasedSettingsList.getSetting(str);
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public String getSettingRange(String str) throws SettingsException {
        try {
            return this.profileBasedSettingsList.getSettingRange(str);
        } catch (Exception e) {
            throw new SettingsException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public String getSettingType(String str) throws SettingsException {
        try {
            return this.profileBasedSettingsList.getSettingType(str);
        } catch (Exception e) {
            throw new SettingsException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public String getSettingValue(String str) throws SettingsException {
        Map<String, String> allSettingValues = getAllSettingValues();
        if (allSettingValues.containsKey(str)) {
            return allSettingValues.get(str);
        }
        throw new SettingsException();
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Map<String, String> getSettingsValues(List<String> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> allSettingValues = getAllSettingValues();
        for (String str : list) {
            if (allSettingValues.containsKey(str)) {
                linkedHashMap.put(str, allSettingValues.get(str));
            }
        }
        return linkedHashMap;
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public List<StorageInfo> getStorageInfo() throws ConnectionException {
        throw new ConnectionException("Storage info is not available for a profile");
    }

    public String getSupplement() {
        return new ZipUtil(this.pathToProfile).getEntryContents(ProfileHelper.PROFILE_SUPPLEMENT_NAME);
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public boolean isSettingReadOnly(String str) throws SettingsException {
        try {
            return this.profileBasedSettingsList.isSettingReadOnly(str);
        } catch (Exception e) {
            throw new SettingsException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public boolean isSettingValid(String str, String str2) throws SettingsException {
        try {
            return this.profileBasedSettingsList.isSettingValid(str, str2);
        } catch (Exception e) {
            throw new SettingsException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public boolean isSettingWriteOnly(String str) throws SettingsException {
        try {
            return this.profileBasedSettingsList.isSettingWriteOnly(str);
        } catch (Exception e) {
            throw new SettingsException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(ZebraImageI zebraImageI, int i, int i2, int i3, int i4, boolean z) throws ConnectionException {
        throw new ConnectionException("Printing an image is not applicable to a profile.");
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Map<String, String> processSettingsViaMap(Map<String, String> map) {
        return this.profileBasedSettingsList.processSettingsViaMap(map);
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public void removeAlert(PrinterAlert printerAlert) throws ConnectionException {
        if (printerAlert instanceof PrinterAlert) {
            configureAlert(new PrinterAlert(printerAlert.getCondition(), printerAlert.getDestination(), false, false, "", 0, false));
        }
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public void removeAllAlerts() throws ConnectionException {
        try {
            ProfileHelper.commitAlertsToProfile(this.pathToProfile, new ArrayList());
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    public void removeFirmware() throws IOException {
        new ZipUtil(this.pathToProfile).removeEntry(ProfileHelper.FIRMWARE_FILE_USER_SPECIFIED_NAME);
        new ZipUtil(this.pathToProfile).removeEntry(ProfileHelper.FIRMWARE_FILE_NAME);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames() {
        List<String> entryNames = new ZipUtil(this.pathToProfile).getEntryNames();
        ArrayList arrayList = new ArrayList();
        for (String str : entryNames) {
            if (!ProfileHelper.isSpecialProfileFile(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public List<PrinterObjectProperties> retrieveObjectsProperties() throws ZebraIllegalArgumentException {
        long length;
        String[] strArrRetrieveFileNames = retrieveFileNames();
        ArrayList arrayList = new ArrayList();
        for (String str : strArrRetrieveFileNames) {
            PrinterFilePath driveAndExtension = FileUtilities.parseDriveAndExtension(str);
            String drive = driveAndExtension.getDrive();
            if (drive.length() > 0 && !drive.endsWith(":")) {
                drive = drive + ":";
            }
            String str2 = drive;
            String extension = driveAndExtension.getExtension();
            if (extension.startsWith(".")) {
                extension = extension.substring(1);
            }
            String str3 = extension;
            try {
                length = new ZipUtil(this.pathToProfile).getEntryContents(str).length();
            } catch (FileNotFoundException | IOException unused) {
                length = 0;
            }
            arrayList.add(new PrinterFilePropertiesZpl(str2, driveAndExtension.getFileName(), str3, length));
        }
        return arrayList;
    }

    public void sendContents(String str, byte[] bArr) throws ConnectionException {
        try {
            new ZipUtil(this.pathToProfile).addEntry(str, bArr);
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.device.FileUtil
    public void sendFileContents(String str) {
        throw new IllegalStateException("sendFileContents is not valid for profiles");
    }

    public void setAllSettings(Map<String, Setting> map) {
        this.profileBasedSettingsList.setAllSettings(map);
    }

    public void setSetting(String str, Setting setting) {
        this.profileBasedSettingsList.setSetting(str, setting);
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public void setSettings(Map<String, String> map) {
        this.profileBasedSettingsList.setSettings(map);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(String str) throws ConnectionException {
        storeFileOnPrinter(str, FileUtilities.GetFileNameOnPrinter(str));
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, ZebraImageI zebraImageI, int i, int i2) throws Throwable {
        GraphicsConversionUtilZpl graphicsConversionUtilZpl = new GraphicsConversionUtilZpl();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            graphicsConversionUtilZpl.sendImageToStream(str, (ZebraImageInternal) zebraImageI, i, i2, byteArrayOutputStream);
            new ZipUtil(this.pathToProfile).addEntry(str, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    public void addFirmware(String str, byte[] bArr) throws IOException {
        new ZipUtil(this.pathToProfile).addEntry(ProfileHelper.FIRMWARE_FILE_NAME, bArr, str.getBytes());
    }

    @Override // com.zebra.sdk.printer.FontUtil
    public void downloadTteFont(String str, String str2) throws ConnectionException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FontConverterZpl.saveAsTtePrinterFont(str, byteArrayOutputStream, str2);
        try {
            new ZipUtil(this.pathToProfile).addEntry(str2, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.printer.FontUtil
    public void downloadTtfFont(String str, String str2) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FontConverterZpl.saveAsTtfPrinterFont(str, byteArrayOutputStream, str2);
        try {
            new ZipUtil(this.pathToProfile).addEntry(str2, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getObjectFromPrinter(String str) throws ZebraIllegalArgumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        getObjectFromPrinter(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getObjectFromPrinterViaFtp(String str, String str2) throws ZebraIllegalArgumentException {
        throw new ZebraIllegalArgumentException("Cannot access a profile over FTP");
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(String str, int i, int i2) throws ConnectionException {
        throw new ConnectionException("Printing an image is not applicable to a profile.");
    }

    @Override // com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : retrieveFileNames()) {
                for (String str2 : strArr) {
                    if (str.toLowerCase().endsWith("." + str2.toLowerCase())) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public void sendFileContents(String str, ProgressMonitor progressMonitor) {
        throw new IllegalStateException("sendFileContents is not valid for profiles");
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public void setSetting(String str, String str2) {
        this.profileBasedSettingsList.setSetting(str, str2);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(String str, String str2) throws ConnectionException {
        storeFileOnPrinter(FileReader.toByteArray(str), str2);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, String str2, int i, int i2) throws Throwable {
        storeImage(str, ReflectionUtil.invokeZebraImageFactory_getImage(str2), i, i2);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(String str, int i, int i2, int i3, int i4, boolean z) throws ConnectionException {
        throw new ConnectionException("Printing an image is not applicable to a profile.");
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(byte[] bArr, String str) throws ConnectionException {
        try {
            new ZipUtil(this.pathToProfile).addEntry(str, FileWrapper.wrapFileWithCisdfHeader(bArr, str));
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }
}
