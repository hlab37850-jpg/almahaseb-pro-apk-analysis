package com.zebra.sdk.printer;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.internal.ConnectionBuilderInternal;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import com.zebra.sdk.printer.internal.GraphicsConversionUtilCpcl;
import com.zebra.sdk.printer.internal.GraphicsConversionUtilZpl;
import com.zebra.sdk.printer.operations.internal.HostStatusOperation;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.settings.internal.ConnectionUtil;
import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterUtil {
    private PrinterUtil() {
    }

    public static void convertGraphic(String str, ZebraImageI zebraImageI, int i, int i2, OutputStream outputStream) throws ZebraIllegalArgumentException {
        if (str == null || zebraImageI == null || outputStream == null) {
            throw new ZebraIllegalArgumentException("Parameter cannot be null");
        }
        (getPrinterLanguageFromFileExtension(str) == PrinterLanguage.CPCL ? new GraphicsConversionUtilCpcl() : new GraphicsConversionUtilZpl()).sendImageToStream(str, (ZebraImageInternal) zebraImageI, i, i2, outputStream);
    }

    public static void createBackup(String str, String str2) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.createBackup(str2);
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void createProfile(String str, String str2) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.createProfile(str2);
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void deleteFile(String str, String str2) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.deleteFile(str2);
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static String[] deleteFileReportDeleted(String str, String str2) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        ArrayList arrayList = new ArrayList();
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                arrayList.addAll(Arrays.asList(linkOsPrinter.retrieveFileNames()));
                linkOsPrinter.deleteFile(str2);
                for (String str3 : linkOsPrinter.retrieveFileNames()) {
                    arrayList.remove(str3);
                }
                linkOsPrinter.getConnection().close();
                return (String[]) arrayList.toArray(new String[0]);
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static PrinterStatus getCurrentStatus(Connection connection, PrinterLanguage printerLanguage) {
        return new HostStatusOperation(connection, printerLanguage).execute();
    }

    private static ZebraPrinterLinkOs getLinkOsPrinter(String str) throws ConnectionException, NotALinkOsPrinterException {
        Connection connectionBuild = ConnectionBuilderInternal.build(str);
        connectionBuild.open();
        ZebraPrinterLinkOs zebraPrinterLinkOsCreateLinkOsPrinter = ZebraPrinterFactory.createLinkOsPrinter(ZebraPrinterFactory.getInstance(connectionBuild));
        if (zebraPrinterLinkOsCreateLinkOsPrinter != null) {
            return zebraPrinterLinkOsCreateLinkOsPrinter;
        }
        connectionBuild.close();
        throw new NotALinkOsPrinterException();
    }

    public static void getObjectFromPrinter(OutputStream outputStream, String str, String str2) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.getObjectFromPrinter(outputStream, str2);
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void getObjectFromPrinterViaFtp(OutputStream outputStream, String str, String str2, String str3) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.getObjectFromPrinterViaFtp(outputStream, str2, str3);
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static List<String> getOdometerStatus(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        ArrayList arrayList = new ArrayList();
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                Connection connection = linkOsPrinter.getConnection();
                arrayList.add("Total Print Length: " + SGD.GET("odometer.total_print_length", connection));
                arrayList.add("Head Clean Count: " + SGD.GET("odometer.headclean", connection));
                arrayList.add("Label Dot Length: " + SGD.GET("odometer.label_dot_length", connection));
                arrayList.add("Head New: " + SGD.GET("odometer.headnew", connection));
                arrayList.add("Latch Open Count: " + SGD.GET("odometer.latch_open_count", connection));
                arrayList.add("User Resettable Counter: " + SGD.GET("odometer.media_marker_count", connection));
                arrayList.add("User Resettable Counter 1: " + SGD.GET("odometer.media_marker_count1", connection));
                arrayList.add("User Resettable Counter 2: " + SGD.GET("odometer.media_marker_count2", connection));
                arrayList.add("User Label Resettable Counter: " + SGD.GET("odometer.user_label_count", connection));
                arrayList.add("User Label Resettable Counter 1: " + SGD.GET("odometer.user_label_count1", connection));
                arrayList.add("User Label Resettable Counter 2: " + SGD.GET("odometer.user_label_count2", connection));
                linkOsPrinter.getConnection().close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static List<TcpPortStatus> getPortStatus(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                List<TcpPortStatus> portStatus = linkOsPrinter.getPortStatus();
                linkOsPrinter.getConnection().close();
                return portStatus;
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    private static PrinterLanguage getPrinterLanguageFromFileExtension(String str) throws ZebraIllegalArgumentException {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            String upperCase = str.substring(iLastIndexOf + 1).trim().toUpperCase();
            if (upperCase.equals("GRF") || upperCase.equals("PNG")) {
                return PrinterLanguage.ZPL;
            }
            if (upperCase.equals("PCX")) {
                return PrinterLanguage.CPCL;
            }
        }
        throw new ZebraIllegalArgumentException("Unsupported file type for graphics conversion");
    }

    public static List<String> getPrinterStatus(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        ArrayList arrayList = new ArrayList();
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                PrinterStatus currentStatus = linkOsPrinter.getCurrentStatus();
                String[] statusMessage = new PrinterStatusMessages(currentStatus).getStatusMessage();
                if (currentStatus.isReadyToPrint) {
                    arrayList.add("Ready To Print");
                } else {
                    for (String str2 : statusMessage) {
                        arrayList.add(str2);
                    }
                }
                arrayList.add("Partial format is in progress: " + Boolean.toString(currentStatus.isPartialFormatInProgress));
                arrayList.add("Labels remaining in queue: " + currentStatus.numberOfFormatsInReceiveBuffer);
                arrayList.add("Printing " + currentStatus.labelsRemainingInBatch + " labels remaining in current batch");
                linkOsPrinter.getConnection().close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static Map<String, Setting> getSettingsFromPrinter(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                Map<String, Setting> allSettings = linkOsPrinter.getAllSettings();
                linkOsPrinter.getConnection().close();
                return allSettings;
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static String[] listFiles(String str, String str2) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                String[] strArrFilterFileList = ZPLUtilities.filterFileList(linkOsPrinter.retrieveFileNames(), str2);
                linkOsPrinter.getConnection().close();
                return strArrFilterFileList;
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void loadBackup(String str, String str2) throws Throwable {
        loadBackup(str, str2, false);
    }

    public static void loadProfile(String str, String str2, FileDeletionOption fileDeletionOption) throws Throwable {
        loadProfile(str, str2, fileDeletionOption, false);
    }

    public static void printConfigLabel(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.printConfigurationLabel();
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void printDirectoryLabel(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.printDirectoryLabel();
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void printNetworkConfigLabel(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.printNetworkConfigurationLabel();
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static String quickStatus(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                PrinterStatus currentStatus = linkOsPrinter.getCurrentStatus();
                String str2 = currentStatus.isReadyToPrint ? "Ready To Print" : new PrinterStatusMessages(currentStatus).getStatusMessage()[0];
                linkOsPrinter.getConnection().close();
                return str2;
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void resetNetwork(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.resetNetwork();
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void resetPrinter(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.reset();
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void restoreNetworkDefaults(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.restoreNetworkDefaults();
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void restorePrinterDefaults(String str) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.restoreDefaults();
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void sendContents(String str, InputStream inputStream) throws Throwable {
        sendContents(str, inputStream, "UTF8");
    }

    public static void sendJSON(String str, InputStream inputStream, String str2) throws Throwable {
        Connection connectionBuild;
        try {
            connectionBuild = ConnectionBuilderInternal.build(str);
            try {
                connectionBuild.open();
                connectionBuild = ConnectionUtil.selectConnection(connectionBuild);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                connectionBuild.write(bArr);
                connectionBuild.close();
            } catch (Throwable th) {
                th = th;
                if (connectionBuild != null) {
                    connectionBuild.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            connectionBuild = null;
        }
    }

    public static void setClock(String str, String str2) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.setClock(str2);
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void storeFile(String str, String str2, String str3) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                if (str3 != null) {
                    linkOsPrinter.storeFileOnPrinter(str2, str3);
                } else {
                    linkOsPrinter.storeFileOnPrinter(str2);
                }
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void updateFirmware(String str, String str2, long j) throws ConnectionException {
        Connection connectionBuild = ConnectionBuilderInternal.build(str);
        try {
            connectionBuild.open();
            ZebraPrinterLinkOs zebraPrinterLinkOsCreateLinkOsPrinter = ZebraPrinterFactory.createLinkOsPrinter(ZebraPrinterFactory.getInstance(connectionBuild));
            if (zebraPrinterLinkOsCreateLinkOsPrinter != null) {
                zebraPrinterLinkOsCreateLinkOsPrinter.updateFirmware(str2, j, new FirmwareUpdateHandler() { // from class: com.zebra.sdk.printer.PrinterUtil.1
                    @Override // com.zebra.sdk.printer.FirmwareUpdateHandlerBase
                    public void firmwareDownloadComplete() {
                    }

                    @Override // com.zebra.sdk.printer.PrinterReconnectionHandler
                    public void printerOnline(ZebraPrinterLinkOs zebraPrinterLinkOs, String str3) {
                    }

                    @Override // com.zebra.sdk.printer.FirmwareUpdateHandlerBase
                    public void progressUpdate(int i, int i2) {
                    }
                });
            }
        } finally {
            connectionBuild.close();
        }
    }

    public static void convertGraphic(String str, ZebraImageI zebraImageI, OutputStream outputStream) throws ZebraIllegalArgumentException {
        convertGraphic(str, zebraImageI, 0, 0, outputStream);
    }

    public static byte[] getObjectFromPrinter(String str, String str2) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                byte[] objectFromPrinter = linkOsPrinter.getObjectFromPrinter(str2);
                linkOsPrinter.getConnection().close();
                return objectFromPrinter;
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static byte[] getObjectFromPrinterViaFtp(String str, String str2, String str3) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                byte[] objectFromPrinterViaFtp = linkOsPrinter.getObjectFromPrinterViaFtp(str2, str3);
                linkOsPrinter.getConnection().close();
                return objectFromPrinterViaFtp;
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void loadBackup(String str, String str2, boolean z) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.loadBackup(str2, z);
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void loadProfile(String str, String str2, FileDeletionOption fileDeletionOption, boolean z) throws Throwable {
        ZebraPrinterLinkOs linkOsPrinter;
        try {
            linkOsPrinter = getLinkOsPrinter(str);
            try {
                linkOsPrinter.loadProfile(str2, fileDeletionOption, z);
                linkOsPrinter.getConnection().close();
            } catch (Throwable th) {
                th = th;
                if (linkOsPrinter != null) {
                    linkOsPrinter.getConnection().close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            linkOsPrinter = null;
        }
    }

    public static void sendContents(String str, InputStream inputStream, String str2) throws Throwable {
        Connection connectionBuild;
        try {
            connectionBuild = ConnectionBuilderInternal.build(str);
            try {
                connectionBuild.open();
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                connectionBuild.write(bArr);
                connectionBuild.close();
            } catch (Throwable th) {
                th = th;
                if (connectionBuild != null) {
                    connectionBuild.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            connectionBuild = null;
        }
    }

    public static void sendContents(String str, String str2) throws Throwable {
        sendContents(str, str2, "UTF8");
    }

    public static void sendContents(String str, String str2, String str3) throws Throwable {
        sendContents(str, new ByteArrayInputStream(str2.getBytes(str3)));
    }
}
