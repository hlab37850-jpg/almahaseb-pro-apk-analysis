package com.zebra.sdk.printer.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.DriveType;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterObjectProperties;
import com.zebra.sdk.printer.StorageInfo;
import com.zebra.sdk.settings.internal.JsonHelper;
import com.zebra.sdk.util.internal.JacksonObjectMapperFactory;
import com.zebra.sdk.util.internal.StringUtilities;
import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtilZpl extends FileUtilA {
    private static final String ONBOARD_FLASH = "ONBOARD FLASH";
    private static final String RAM = "RAM";
    private static final String READ_ONLY = "READ ONLY";

    public static class FileObjectWithCrc32Data {
        public String access;
        public long crc32;
        public String date;
        public String flags;
        public long size;
    }

    public FileUtilZpl(Connection connection) {
        super(connection);
    }

    private PrinterFilePropertiesList extractFilePropertiesFromHZLResponse(String str) throws ZebraIllegalArgumentException {
        int i;
        PrinterFilePropertiesList printerFilePropertiesList = new PrinterFilePropertiesList();
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.trim().getBytes())).getElementsByTagName("OBJECT");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                Node nodeItem = elementsByTagName.item(i2);
                if (nodeItem.getNodeType() == 1) {
                    NamedNodeMap attributes = nodeItem.getAttributes();
                    String nodeValue = nodeItem.getFirstChild().getNodeValue();
                    try {
                        i = Integer.parseInt(attributes.getNamedItem("SIZE").getNodeValue());
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    printerFilePropertiesList.add(new PrinterFilePropertiesZpl(attributes.getNamedItem("MEMORY-LOCATION").getNodeValue(), nodeValue, attributes.getNamedItem("TYPE").getNodeValue(), i));
                }
            }
            return printerFilePropertiesList;
        } catch (IOException e) {
            throw new ZebraIllegalArgumentException(e.getMessage());
        } catch (ParserConfigurationException e2) {
            throw new ZebraIllegalArgumentException(e2.getMessage());
        } catch (SAXException e3) {
            throw new ZebraIllegalArgumentException(e3.getMessage());
        }
    }

    private PrinterFilePropertiesList extractFilePropertiesFromJsonFileDriveListingResponse(String str) {
        PrinterFilePropertiesList printerFilePropertiesList = new PrinterFilePropertiesList();
        ObjectMapper jacksonObjectMapperFactory = JacksonObjectMapperFactory.getInstance();
        try {
            for (Map.Entry entry : ((Map) ((Map) jacksonObjectMapperFactory.readValue(str, jacksonObjectMapperFactory.getTypeFactory().constructMapType(LinkedHashMap.class, jacksonObjectMapperFactory.getTypeFactory().constructType(String.class), jacksonObjectMapperFactory.getTypeFactory().constructMapType(LinkedHashMap.class, jacksonObjectMapperFactory.getTypeFactory().constructType(String.class), jacksonObjectMapperFactory.getTypeFactory().constructMapType(LinkedHashMap.class, String.class, FileObjectWithCrc32Data.class))))).get(ZPLUtilities.FILE_DRIVE_LISTING_SETTING_NAME)).entrySet()) {
                String str2 = (String) entry.getKey();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    long j = ((FileObjectWithCrc32Data) entry2.getValue()).size;
                    long j2 = ((FileObjectWithCrc32Data) entry2.getValue()).crc32;
                    printerFilePropertiesList.add(new PrinterFilePropertiesZpl(str2 + ":", FilenameUtils.removeExtension((String) entry2.getKey()), FilenameUtils.getExtension((String) entry2.getKey()), j, j2));
                }
            }
        } catch (IOException e) {
            new ConnectionException(e.getLocalizedMessage());
        }
        return printerFilePropertiesList;
    }

    private PrinterFilePropertiesList getObjectsListForDriveTypes(List<StorageInfo> list, Set<DriveType> set, PrinterLanguage printerLanguage) {
        PrinterFilePropertiesList printerFilePropertiesList = new PrinterFilePropertiesList();
        for (StorageInfo storageInfo : list) {
            if (set.contains(storageInfo.driveType)) {
                printerFilePropertiesList.addAll(getObjectsListFromDrive(String.valueOf(storageInfo.driveLetter), printerLanguage).getObjectsProperties());
            }
        }
        return printerFilePropertiesList;
    }

    private PrinterFilePropertiesList getObjectsListFromAllDrives(PrinterLanguage printerLanguage) {
        return getObjectsListFromDrive("", printerLanguage);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0034  */
    /* JADX WARN: Instruction removed from duplicated block: B:7:0x0034, please report this as an issue */
    private PrinterFilePropertiesList getObjectsListFromDrive(String str, PrinterLanguage printerLanguage) {
        PrinterCommandImpl printerCommandImpl;
        PrinterLanguage printerLanguage2 = PrinterLanguage.LINE_PRINT;
        if (printerLanguage == printerLanguage2) {
            Connection connection = this.printerConnection;
            if (connection instanceof StatusConnection) {
                printerCommandImpl = new PrinterCommandImpl("{}{\"file.drive_listing\":\"" + str + "\"}");
            } else {
                connection.write(("! U1 setvar \"file.drive_listing\" \"" + str + "\"" + StringUtilities.CRLF).getBytes());
                printerCommandImpl = new PrinterCommandImpl("! U1 getvar \"file.drive_listing\"\r\n");
            }
        } else {
            printerCommandImpl = new PrinterCommandImpl("{}{\"file.drive_listing\":\"" + str + "\"}");
        }
        String str2 = new String(printerCommandImpl.sendAndWaitForValidJsonResponse(this.printerConnection));
        if (printerLanguage == printerLanguage2 && !(this.printerConnection instanceof StatusConnection)) {
            str2 = "{\"file.drive_listing\":" + str2.replaceAll("^\"|\"$", "") + "}";
        }
        return extractFilePropertiesFromJsonFileDriveListingResponse(str2);
    }

    @Override // com.zebra.sdk.printer.internal.FileUtilA
    public PrinterFilePropertiesList extractFilePropertiesFromDirResult(String str) {
        if (str.trim().startsWith("<?xml version='1.0'?>\r\n<ZEBRA-ELTRON-PERSONALITY>")) {
            return extractFilePropertiesFromHZLResponse(str);
        }
        return JsonHelper.isValidJson(str.getBytes()) ? extractFilePropertiesFromJsonFileDriveListingResponse(str) : super.extractFilePropertiesFromDirResult(str);
    }

    public List<StorageInfo> getStorageInfo() {
        PrinterCommandImpl printerCommandImpl = new PrinterCommandImpl(ZPLUtilities.PRINTER_GET_STORAGE_INFO_COMMAND);
        Connection connection = this.printerConnection;
        return ZPLUtilities.parseHWCommand(new String(printerCommandImpl.sendAndWaitForResponse(connection, connection.getMaxTimeoutForRead(), this.printerConnection.getTimeToWaitForMoreData())));
    }

    public List<StorageInfo> getStorageInfoViaJsonChannel() throws ConnectionException {
        try {
            return ZPLUtilities.parseFileDriveInfoJson(new String(new PrinterCommandImpl("{}{\"file.drive_info\":null}").sendAndWaitForValidJsonResponse(this.printerConnection)));
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    public List<StorageInfo> getStorageInfoViaSgd() throws ConnectionException {
        try {
            return ZPLUtilities.parseFileDriveInfoJson(String.format("{ \"file.drive_info\" : %s }", new String(new PrinterCommandImpl("! U1 getvar \"file.drive_info\"\r\n").sendAndWaitForValidJsonResponse(this.printerConnection)).replaceAll("^\"|\"$", "")));
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.printer.internal.FileUtilA, com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames() {
        return retrieveFilePropertiesFromPrinter().getFileNamesFromProperties();
    }

    @Override // com.zebra.sdk.device.FileUtil
    public List<PrinterObjectProperties> retrieveObjectsProperties() {
        return retrieveFilePropertiesFromPrinter().getObjectsProperties();
    }

    public List<PrinterObjectProperties> retrieveObjectsPropertiesWithCrc32(List<StorageInfo> list, Set<DriveType> set, PrinterLanguage printerLanguage) {
        return ((set == null || set.isEmpty()) ? getObjectsListFromAllDrives(printerLanguage) : getObjectsListForDriveTypes(list, set, printerLanguage)).getObjectsProperties();
    }

    @Override // com.zebra.sdk.printer.internal.FileUtilA, com.zebra.sdk.device.FileUtil
    public String[] retrieveFileNames(String[] strArr) {
        return retrieveFilePropertiesFromPrinter().filterByExtension(strArr).getFileNamesFromProperties();
    }

    public List<PrinterObjectProperties> retrieveObjectsProperties(List<StorageInfo> list, Set<DriveType> set) {
        PrinterFilePropertiesList printerFilePropertiesListRetrieveFilePropertiesFromPrinter = retrieveFilePropertiesFromPrinter();
        if (set != null && !set.isEmpty()) {
            HashMap map = new HashMap();
            for (StorageInfo storageInfo : list) {
                map.put(String.valueOf(storageInfo.driveLetter), storageInfo.driveType);
            }
            Iterator<PrinterObjectProperties> it = printerFilePropertiesListRetrieveFilePropertiesFromPrinter.getObjectsProperties().iterator();
            while (it.hasNext()) {
                String strReplaceAll = it.next().getDrivePrefix().replaceAll(":", "");
                DriveType driveType = strReplaceAll.equalsIgnoreCase("Z") ? DriveType.READ_ONLY : (DriveType) map.get(strReplaceAll);
                if (driveType == null) {
                    driveType = DriveType.UNKNOWN;
                }
                if (!set.contains(driveType)) {
                    it.remove();
                }
            }
        }
        return printerFilePropertiesListRetrieveFilePropertiesFromPrinter.getObjectsProperties();
    }
}
