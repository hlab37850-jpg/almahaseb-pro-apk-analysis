package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.device.FileUtilLinkOs;
import com.zebra.sdk.device.ProgressMonitor;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.printer.FieldDescriptionData;
import com.zebra.sdk.printer.FileDeletionOption;
import com.zebra.sdk.printer.FirmwareUpdateHandler;
import com.zebra.sdk.printer.FirmwareUpdaterLinkOs;
import com.zebra.sdk.printer.FormatUtilLinkOs;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterAlert;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterObjectProperties;
import com.zebra.sdk.printer.PrinterStatus;
import com.zebra.sdk.printer.ProfileUtil;
import com.zebra.sdk.printer.StorageInfo;
import com.zebra.sdk.printer.TcpPortStatus;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.printer.operations.internal.ConfigurationLabelPrinter;
import com.zebra.sdk.printer.operations.internal.FileStorer;
import com.zebra.sdk.printer.operations.internal.HostStatusOperation;
import com.zebra.sdk.printer.operations.internal.ImageStorer;
import com.zebra.sdk.printer.operations.internal.NetworkConfigurationLabelPrinter;
import com.zebra.sdk.printer.operations.internal.NetworkDefaulter;
import com.zebra.sdk.printer.operations.internal.NetworkResetter;
import com.zebra.sdk.printer.operations.internal.ObjectGrabberOperation;
import com.zebra.sdk.printer.operations.internal.ObjectsListingOperation;
import com.zebra.sdk.printer.operations.internal.PrinterCalibrator;
import com.zebra.sdk.printer.operations.internal.PrinterDefaulter;
import com.zebra.sdk.printer.operations.internal.PrinterResetter;
import com.zebra.sdk.printer.operations.internal.SettingsUpdaterOperation;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.settings.SettingsException;
import com.zebra.sdk.settings.internal.AlertsUtilLinkOs;
import com.zebra.sdk.settings.internal.ZebraSettingsListFromConnection;
import com.zebra.sdk.util.fileConversion.internal.DZ_UnwrapperStream;
import com.zebra.sdk.util.fileConversion.internal.HzoToDzConverterStream;
import com.zebra.sdk.util.fileConversion.internal.MPF_UnwrapperStream;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.PrinterFileDescriptor;
import com.zebra.sdk.util.internal.PrinterFileMetadata;
import com.zebra.sdk.util.internal.ReflectionUtil;
import com.zebra.sdk.util.internal.ZPLUtilities;
import com.zebra.sdk.util.internal.ZipUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraPrinterLinkOsImpl implements ZebraPrinterLinkOs {
    private ZebraPrinter genericPrinter;
    private String getCommunityName;
    private PrinterLanguage language;
    private LinkOsInformation linkOsInformation;
    public ZebraSettingsListFromConnection settings = null;
    protected ProfileUtil profile = null;
    protected AlertsUtilLinkOs alerts = null;
    protected FileUtilLinkOs fileUtil = null;
    protected FormatUtilLinkOs formatUtil = null;
    protected ToolsUtilLinkOsHelper toolsUtilHelper = null;
    protected FirmwareUpdaterLinkOs fwDownloader = null;

    public ZebraPrinterLinkOsImpl(Connection connection, LinkOsInformation linkOsInformation, PrinterLanguage printerLanguage) {
        this.linkOsInformation = linkOsInformation;
        this.language = printerLanguage;
        init(new ZebraPrinterZpl(connection));
    }

    private void downloadFont(InputStream inputStream, String str) throws ConnectionException {
        FileStorer fileStorer;
        try {
            ArrayList arrayList = new ArrayList();
            if (inputStream instanceof FileInputStream) {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                arrayList.add(new PrinterFileDescriptor(inputStream, str, new PrinterFileMetadata(channel.size(), "0000", "0000")));
                new FileStorer(arrayList, getConnection(), getPrinterControlLanguage(), this.linkOsInformation).execute();
                channel.close();
                return;
            }
            if (inputStream.markSupported()) {
                inputStream.mark(Integer.MAX_VALUE);
                PrinterFileMetadata printerFileMetadata = new PrinterFileMetadata(inputStream);
                inputStream.reset();
                arrayList.add(new PrinterFileDescriptor(inputStream, str, printerFileMetadata));
                fileStorer = new FileStorer(arrayList, getConnection(), getPrinterControlLanguage(), this.linkOsInformation);
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (inputStream.available() > 0) {
                    byteArrayOutputStream.write(inputStream.read());
                }
                arrayList.add(new PrinterFileDescriptor(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), str, new PrinterFileMetadata(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))));
                fileStorer = new FileStorer(arrayList, getConnection(), getPrinterControlLanguage(), this.linkOsInformation);
            }
            fileStorer.execute();
        } catch (FileNotFoundException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        } catch (IOException e2) {
            throw new ConnectionException(e2.getLocalizedMessage());
        }
    }

    private boolean hasSupplementalData(String str) {
        return new ZipUtil(str).extractEntry(ProfileHelper.PROFILE_SUPPLEMENT_NAME).length > 0;
    }

    private void init(ZebraPrinter zebraPrinter) {
        this.genericPrinter = zebraPrinter;
        this.alerts = new AlertsUtilLinkOs(this);
        this.profile = new ProfileUtilLinkOsImpl(this);
        this.fileUtil = new FileUtilLinkOsImpl(this);
        this.formatUtil = new FormatUtilLinkOsImpl(this);
        this.toolsUtilHelper = new ToolsUtilLinkOsHelper(zebraPrinter.getConnection(), this.language);
        this.fwDownloader = getFirmwareDownloader(this);
        this.settings = new ZebraSettingsListFromConnection(zebraPrinter.getConnection());
        this.getCommunityName = "public";
    }

    private boolean isOnlySettingsChannelOpen(MultichannelConnection multichannelConnection) {
        return multichannelConnection.getStatusChannel().isConnected() && !multichannelConnection.getPrintingChannel().isConnected();
    }

    private void throwExceptionInLinePrintMode() throws ConnectionException {
        if (getPrinterControlLanguage() == PrinterLanguage.LINE_PRINT) {
            throw new ConnectionException("Operation cannot be performed with a printer set to line print mode");
        }
    }

    private void throwExceptionInLinePrintModeRawOnly() throws ConnectionException {
        Connection connection = getConnection();
        if (getPrinterControlLanguage() == PrinterLanguage.LINE_PRINT) {
            if (!(connection instanceof MultichannelConnection)) {
                if (!(connection instanceof StatusConnection)) {
                    throw new ConnectionException("Operation cannot be performed on raw channel with a printer set to line print mode");
                }
            } else {
                MultichannelConnection multichannelConnection = (MultichannelConnection) connection;
                if (multichannelConnection.getPrintingChannel().isConnected() && !multichannelConnection.getStatusChannel().isConnected()) {
                    throw new ConnectionException("Operation cannot be performed on raw channel with a printer set to line print mode");
                }
            }
        }
    }

    private void throwExceptionStatusOnly() throws ConnectionException {
        Connection connection = getConnection();
        if (connection instanceof MultichannelConnection) {
            if (isOnlySettingsChannelOpen((MultichannelConnection) connection)) {
                throw new ConnectionException("Operation cannot be performed with only the status channel open");
            }
        } else if (connection instanceof StatusConnection) {
            throw new ConnectionException("Operation cannot be performed over the status channel");
        }
    }

    private void throwExceptionSupplementalDataStatusOnly(String str) throws ConnectionException {
        if (hasSupplementalData(str)) {
            Connection connection = getConnection();
            if (connection instanceof MultichannelConnection) {
                if (isOnlySettingsChannelOpen((MultichannelConnection) connection)) {
                    throw new ConnectionException("Supplemental data cannot be sent with only the status channel open");
                }
            } else if (connection instanceof StatusConnection) {
                throw new ConnectionException("Supplemental data cannot be sent over the status channel");
            }
        }
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void calibrate() {
        new PrinterCalibrator(getConnection(), getPrinterControlLanguage()).execute();
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public void configureAlert(PrinterAlert printerAlert) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        configureAlerts(Arrays.asList(printerAlert));
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public void configureAlerts(List<PrinterAlert> list) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        this.alerts.setAlerts(list);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void createBackup(String str) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        this.profile.createBackup(str);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void createProfile(OutputStream outputStream) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        this.profile.createProfile(outputStream);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void deleteFile(String str) {
        this.fileUtil.deleteFile(str);
    }

    @Override // com.zebra.sdk.printer.FontUtil
    public void downloadTteFont(InputStream inputStream, String str) throws ConnectionException {
        downloadFont(inputStream, FileUtilities.changeExtension(str, ".TTE"));
    }

    @Override // com.zebra.sdk.printer.FontUtil
    public void downloadTtfFont(InputStream inputStream, String str) throws ConnectionException {
        downloadFont(inputStream, FileUtilities.changeExtension(str, ".TTF"));
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Map<String, String> getAllSettingValues() throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            return this.settings.getAllSettingValues();
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Map<String, Setting> getAllSettings() throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            return this.settings.getAllSettings();
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Set<String> getAvailableSettings() throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            return this.settings.getAllSettingIds();
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public List<PrinterAlert> getConfiguredAlerts() throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        return this.alerts.getAlerts();
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public Connection getConnection() {
        return this.genericPrinter.getConnection();
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public PrinterStatus getCurrentStatus() {
        return new HostStatusOperation(getConnection(), getPrinterControlLanguage()).execute();
    }

    public FirmwareUpdaterLinkOs getFirmwareDownloader(ZebraPrinterLinkOs zebraPrinterLinkOs) {
        return new FirmwareUpdaterLinkOsBase(zebraPrinterLinkOs);
    }

    @Override // com.zebra.sdk.printer.ZebraPrinterLinkOs
    public String getGetCommunityName() {
        return this.getCommunityName;
    }

    @Override // com.zebra.sdk.printer.ZebraPrinterLinkOs
    public LinkOsInformation getLinkOsInformation() {
        return this.linkOsInformation;
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void getObjectFromPrinter(OutputStream outputStream, String str) {
        this.fileUtil.getObjectFromPrinter(outputStream, str);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void getObjectFromPrinterViaFtp(OutputStream outputStream, String str, String str2) {
        this.fileUtil.getObjectFromPrinterViaFtp(outputStream, str, str2);
    }

    @Override // com.zebra.sdk.printer.ZebraPrinterLinkOs
    public List<TcpPortStatus> getPortStatus() {
        return PortStatus.getPortStatus(this.genericPrinter.getConnection(), getGetCommunityName());
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public PrinterLanguage getPrinterControlLanguage() {
        return this.language;
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getPrinterDownloadableObjectFromPrinter(String str) {
        return this.fileUtil.getPrinterDownloadableObjectFromPrinter(str);
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public String getSettingRange(String str) throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            return this.settings.getSettingRange(str);
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public String getSettingType(String str) throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            return this.settings.getSettingType(str);
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public String getSettingValue(String str) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        return this.settings.getValue(str);
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Map<String, String> getSettingsValues(List<String> list) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        return this.settings.getValues(list);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public List<StorageInfo> getStorageInfo() {
        return this.fileUtil.getStorageInfo();
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public FieldDescriptionData[] getVariableFields(String str) {
        return this.genericPrinter.getVariableFields(str);
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public boolean isSettingReadOnly(String str) throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            return this.settings.isSettingReadOnly(str);
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public boolean isSettingValid(String str, String str2) throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            return this.settings.isSettingValid(str, str2);
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public boolean isSettingWriteOnly(String str) throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            return this.settings.isSettingWriteOnly(str);
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void loadBackup(String str) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        throwExceptionSupplementalDataStatusOnly(str);
        this.profile.loadBackup(str);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void loadProfile(String str) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        throwExceptionSupplementalDataStatusOnly(str);
        this.profile.loadProfile(str);
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void printConfigurationLabel() throws ConnectionException {
        new ConfigurationLabelPrinter(getConnection(), getPrinterControlLanguage(), this.linkOsInformation).execute();
    }

    @Override // com.zebra.sdk.printer.ToolsUtilLinkOs
    public void printDirectoryLabel() throws ConnectionException {
        throwExceptionInLinePrintMode();
        this.toolsUtilHelper.printDirectoryLabel();
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(ZebraImageI zebraImageI, int i, int i2, int i3, int i4, boolean z) throws ConnectionException {
        throwExceptionInLinePrintMode();
        throwExceptionStatusOnly();
        this.genericPrinter.printImage(zebraImageI, i, i2, i3, i4, z);
    }

    @Override // com.zebra.sdk.printer.ToolsUtilLinkOs
    public void printNetworkConfigurationLabel() throws ConnectionException {
        new NetworkConfigurationLabelPrinter(getConnection(), getPrinterControlLanguage(), this.linkOsInformation).execute();
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map) throws ConnectionException {
        throwExceptionInLinePrintMode();
        this.genericPrinter.printStoredFormat(str, map);
    }

    @Override // com.zebra.sdk.printer.FormatUtilLinkOs
    public void printStoredFormatWithVarGraphics(String str, Map<Integer, String> map) throws ConnectionException {
        throwExceptionInLinePrintMode();
        throwExceptionStatusOnly();
        this.formatUtil.printStoredFormatWithVarGraphics(str, map);
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public Map<String, String> processSettingsViaMap(Map<String, String> map) {
        return new SettingsUpdaterOperation(getConnection(), map, getPrinterControlLanguage()).process();
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public void removeAlert(PrinterAlert printerAlert) throws ConnectionException {
        if (printerAlert instanceof PrinterAlert) {
            configureAlert(new PrinterAlert(printerAlert.getCondition(), printerAlert.getDestination(), false, false, "", 0, false));
        }
    }

    @Override // com.zebra.sdk.printer.AlertProvider
    public void removeAllAlerts() throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        this.alerts.removeAllAlerts();
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void reset() {
        new PrinterResetter(getConnection(), getPrinterControlLanguage()).execute();
    }

    @Override // com.zebra.sdk.printer.ToolsUtilLinkOs
    public void resetNetwork() {
        new NetworkResetter(getConnection(), getPrinterControlLanguage()).execute();
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void restoreDefaults() {
        new PrinterDefaulter(getConnection(), getPrinterControlLanguage()).execute();
    }

    @Override // com.zebra.sdk.printer.ToolsUtilLinkOs
    public void restoreNetworkDefaults() {
        new NetworkDefaulter(getConnection(), getPrinterControlLanguage()).execute();
    }

    @Override // com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames() {
        return this.genericPrinter.retrieveFileNames();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // com.zebra.sdk.printer.FormatUtil
    public void retrieveFormatFromPrinter(OutputStream outputStream, String str) throws Throwable {
        ?? r8;
        HzoToDzConverterStream hzoToDzConverterStream;
        InputStream dZ_UnwrapperStream = null;
        try {
            try {
                InputStream inputStreamExecute = new ObjectGrabberOperation(str, getConnection(), getPrinterControlLanguage(), getLinkOsInformation()).execute();
                try {
                    if (inputStreamExecute instanceof MultipartFormReceiverStream) {
                        hzoToDzConverterStream = null;
                        dZ_UnwrapperStream = new MPF_UnwrapperStream(inputStreamExecute);
                    } else {
                        hzoToDzConverterStream = new HzoToDzConverterStream(inputStreamExecute);
                        try {
                            dZ_UnwrapperStream = new DZ_UnwrapperStream(hzoToDzConverterStream);
                        } catch (ZebraIllegalArgumentException e) {
                            e = e;
                            throw new ConnectionException(e.getLocalizedMessage());
                        } catch (IOException e2) {
                            e = e2;
                            throw new ConnectionException(e.getLocalizedMessage());
                        } catch (Throwable th) {
                            th = th;
                            InputStream inputStream = dZ_UnwrapperStream;
                            dZ_UnwrapperStream = inputStreamExecute;
                            r8 = inputStream;
                            IOUtils.closeQuietly(dZ_UnwrapperStream);
                            IOUtils.closeQuietly(hzoToDzConverterStream);
                            IOUtils.closeQuietly((InputStream) r8);
                            throw th;
                        }
                    }
                    outputStream.write(ZPLUtilities.replaceAllWithInternalCharacters("^XA").getBytes());
                    while (true) {
                        int i = dZ_UnwrapperStream.read();
                        if (i == -1) {
                            outputStream.write(ZPLUtilities.replaceAllWithInternalCharacters("^XZ").getBytes());
                            IOUtils.closeQuietly(inputStreamExecute);
                            IOUtils.closeQuietly(hzoToDzConverterStream);
                            IOUtils.closeQuietly(dZ_UnwrapperStream);
                            return;
                        }
                        outputStream.write(i);
                    }
                } catch (ZebraIllegalArgumentException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                    hzoToDzConverterStream = null;
                    dZ_UnwrapperStream = inputStreamExecute;
                    r8 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                r8 = str;
            }
        } catch (ZebraIllegalArgumentException e5) {
            e = e5;
        } catch (IOException e6) {
            e = e6;
        } catch (Throwable th4) {
            th = th4;
            r8 = 0;
            hzoToDzConverterStream = null;
        }
    }

    @Override // com.zebra.sdk.device.FileUtil
    public List<PrinterObjectProperties> retrieveObjectsProperties() {
        return new ObjectsListingOperation(getConnection(), getPrinterControlLanguage(), this.linkOsInformation).execute();
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void sendCommand(String str) {
        this.genericPrinter.sendCommand(str);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public void sendFileContents(String str) {
        this.genericPrinter.sendFileContents(str);
    }

    @Override // com.zebra.sdk.printer.ToolsUtilLinkOs
    public void setClock(String str) {
        this.toolsUtilHelper.setClock(str);
    }

    @Override // com.zebra.sdk.printer.ZebraPrinter
    public void setConnection(Connection connection) {
        this.genericPrinter.setConnection(connection);
        this.settings.setConnection(connection);
    }

    @Override // com.zebra.sdk.printer.ZebraPrinterLinkOs
    public void setGetCommunityName(String str) {
        this.getCommunityName = str;
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public void setSetting(String str, String str2) throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            this.settings.setSetting(str, str2);
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.settings.SettingsProvider
    public void setSettings(Map<String, String> map) throws SettingsException {
        try {
            throwExceptionInLinePrintModeRawOnly();
            this.settings.setSettings(map);
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(String str) {
        this.fileUtil.storeFileOnPrinter(str);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, ZebraImageI zebraImageI, int i, int i2) throws ZebraIllegalArgumentException, ConnectionException {
        new ImageStorer(getConnection(), getPrinterControlLanguage(), getLinkOsInformation()).execute(str, zebraImageI, i, i2);
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdaterLinkOs
    public void updateFirmware(String str, long j, FirmwareUpdateHandler firmwareUpdateHandler) {
        this.fwDownloader.updateFirmware(str, j, firmwareUpdateHandler);
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdaterLinkOs
    public void updateFirmwareUnconditionally(String str, long j, FirmwareUpdateHandler firmwareUpdateHandler) {
        this.fwDownloader.updateFirmwareUnconditionally(str, j, firmwareUpdateHandler);
    }

    public ZebraPrinterLinkOsImpl(ZebraPrinter zebraPrinter, LinkOsInformation linkOsInformation, PrinterLanguage printerLanguage) {
        this.linkOsInformation = linkOsInformation;
        this.language = printerLanguage;
        init(zebraPrinter);
    }

    private void downloadFont(String str, String str2) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    downloadFont(fileInputStream2, str2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    throw new ConnectionException(e.getLocalizedMessage());
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void createProfile(String str) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        this.profile.createProfile(str);
    }

    @Override // com.zebra.sdk.printer.FontUtil
    public void downloadTteFont(String str, String str2) throws Throwable {
        downloadFont(str, FileUtilities.changeExtension(str2, ".TTE"));
    }

    @Override // com.zebra.sdk.printer.FontUtil
    public void downloadTtfFont(String str, String str2) throws Throwable {
        downloadFont(str, FileUtilities.changeExtension(str2, ".TTF"));
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getObjectFromPrinter(String str) {
        return this.fileUtil.getObjectFromPrinter(str);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public byte[] getObjectFromPrinterViaFtp(String str, String str2) {
        return this.fileUtil.getObjectFromPrinterViaFtp(str, str2);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void loadBackup(String str, boolean z) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        throwExceptionSupplementalDataStatusOnly(str);
        this.profile.loadBackup(str, z);
    }

    @Override // com.zebra.sdk.printer.ProfileUtil
    public void loadProfile(String str, FileDeletionOption fileDeletionOption, boolean z) throws ConnectionException {
        throwExceptionInLinePrintModeRawOnly();
        throwExceptionSupplementalDataStatusOnly(str);
        this.profile.loadProfile(str, fileDeletionOption, z);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(String str, int i, int i2) throws ConnectionException {
        throwExceptionInLinePrintMode();
        throwExceptionStatusOnly();
        this.genericPrinter.printImage(str, i, i2);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map, String str2) throws ConnectionException {
        throwExceptionInLinePrintMode();
        this.genericPrinter.printStoredFormat(str, map, str2);
    }

    @Override // com.zebra.sdk.printer.FormatUtilLinkOs
    public void printStoredFormatWithVarGraphics(String str, Map<Integer, String> map, String str2) throws ConnectionException {
        throwExceptionInLinePrintMode();
        throwExceptionStatusOnly();
        this.formatUtil.printStoredFormatWithVarGraphics(str, map, str2);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames(String[] strArr) {
        return this.genericPrinter.retrieveFileNames(strArr);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public byte[] retrieveFormatFromPrinter(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        retrieveFormatFromPrinter(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.zebra.sdk.printer.ToolsUtil
    public void sendCommand(String str, String str2) {
        this.genericPrinter.sendCommand(str, str2);
    }

    @Override // com.zebra.sdk.device.FileUtil
    public void sendFileContents(String str, ProgressMonitor progressMonitor) {
        this.genericPrinter.sendFileContents(str, progressMonitor);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(String str, String str2) {
        this.fileUtil.storeFileOnPrinter(str, str2);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, String str2, int i, int i2) throws ZebraIllegalArgumentException, ConnectionException {
        new ImageStorer(getConnection(), getPrinterControlLanguage(), getLinkOsInformation()).execute(str, ReflectionUtil.invokeZebraImageFactory_getImage(str2), i, i2);
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdaterLinkOs
    public void updateFirmware(String str, FirmwareUpdateHandler firmwareUpdateHandler) {
        this.fwDownloader.updateFirmware(str, firmwareUpdateHandler);
    }

    @Override // com.zebra.sdk.printer.FirmwareUpdaterLinkOs
    public void updateFirmwareUnconditionally(String str, FirmwareUpdateHandler firmwareUpdateHandler) {
        this.fwDownloader.updateFirmwareUnconditionally(str, firmwareUpdateHandler);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(String str, int i, int i2, int i3, int i4, boolean z) throws ConnectionException {
        throwExceptionInLinePrintMode();
        throwExceptionStatusOnly();
        this.genericPrinter.printImage(str, i, i2, i3, i4, z);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, String[] strArr) throws ConnectionException {
        throwExceptionInLinePrintMode();
        this.genericPrinter.printStoredFormat(str, strArr);
    }

    @Override // com.zebra.sdk.printer.FormatUtilLinkOs
    public void printStoredFormatWithVarGraphics(String str, Map<Integer, ZebraImageI> map, Map<Integer, String> map2) throws ConnectionException {
        throwExceptionInLinePrintMode();
        throwExceptionStatusOnly();
        this.formatUtil.printStoredFormatWithVarGraphics(str, map, map2);
    }

    @Override // com.zebra.sdk.device.FileUtilLinkOs
    public void storeFileOnPrinter(byte[] bArr, String str) {
        this.fileUtil.storeFileOnPrinter(bArr, str);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, String[] strArr, String str2) throws ConnectionException {
        throwExceptionInLinePrintMode();
        this.genericPrinter.printStoredFormat(str, strArr, str2);
    }

    @Override // com.zebra.sdk.printer.FormatUtilLinkOs
    public void printStoredFormatWithVarGraphics(String str, Map<Integer, ZebraImageI> map, Map<Integer, String> map2, String str2) throws ConnectionException {
        throwExceptionInLinePrintMode();
        throwExceptionStatusOnly();
        this.formatUtil.printStoredFormatWithVarGraphics(str, map, map2, str2);
    }
}
