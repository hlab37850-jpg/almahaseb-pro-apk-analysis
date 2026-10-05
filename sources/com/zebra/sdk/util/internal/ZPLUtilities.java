package com.zebra.sdk.util.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.DriveType;
import com.zebra.sdk.printer.StorageInfo;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.hssf.record.formula.Ref3DPtg;
import org.apache.poi.hssf.record.formula.RefErrorPtg;
import org.apache.poi.hssf.record.formula.RefNPtg;

/* JADX INFO: loaded from: classes3.dex */
public class ZPLUtilities {
    public static final String FILE_DRIVE_INFO_SETTING_NAME = "file.drive_info";
    public static final String FILE_DRIVE_LISTING_SETTING_NAME = "file.drive_listing";
    public static final int ZPL_INTERNAL_COMMAND_PREFIX_CHAR = 16;
    public static final int ZPL_INTERNAL_DELIMITER_CHAR = 31;
    public static final int ZPL_INTERNAL_FORMAT_PREFIX_CHAR = 30;
    public static final String ZPL_INTERNAL_FORMAT_PREFIX = new String(new byte[]{30});
    public static final String ZPL_INTERNAL_COMMAND_PREFIX = new String(new byte[]{16});
    public static final String ZPL_INTERNAL_DELIMITER = new String(new byte[]{31});
    public static final String PRINTER_INFO = "\u0010HI";
    public static final String PRINTER_STATUS = "\u0010HS";
    public static final String PRINTER_CONFIG_LABEL = "\u0010WC";
    public static final String PRINTER_DIRECTORY_LABEL = new String(new byte[]{30, 88, 65, 30, 87, 68, RefErrorPtg.sid, Ref3DPtg.sid, RefErrorPtg.sid, 46, RefErrorPtg.sid, 30, 88, 90});
    public static final String PRINTER_NETWORK_CONFIG_LABEL = "\u0010WL";
    public static final String PRINTER_CALIBRATE = "\u0010JC";
    public static final String PRINTER_RESET = "\u0010JR";
    public static final String PRINTER_RESET_NETWORK = "\u0010WR";
    public static final String PRINTER_RESTORE_DEFAULTS = "\u001eXA\u001eJUF\u001eXZ";
    public static final String PRINTER_GET_SUPER_HOST_STATUS = "\u001eXA\u001eHZA\u001eXZ";
    public static final String PRINTER_GET_STORAGE_INFO_COMMAND = new String(new byte[]{30, 88, 65, 30, 72, 87, RefErrorPtg.sid, Ref3DPtg.sid, 88, 88, 88, 88, 46, 81, 81, 81, 30, 88, 90});

    public static class FileObjectDetails {
        public String access;
        public long free;
        public long size;
        public String storage;
    }

    public class InternalCharacterFilteringOutputStream extends FilterOutputStream {
        public InternalCharacterFilteringOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (i == 16) {
                i = 126;
            } else if (i == 31) {
                i = 44;
            } else if (i == 30) {
                i = 94;
            }
            super.write(i);
        }
    }

    private static String createFileNameRegex(Matcher matcher) {
        String strGroup = matcher.group(1);
        return (strGroup != null ? strGroup.replaceAll("\\*:", "([A-Za-z]{1}:)?") : "([A-Za-z]{1}:)?") + matcher.group(3).replaceAll("\\*", "[A-Za-z0-9\\-_]*") + "\\." + matcher.group(4).replaceAll("\\*", "[A-Za-z0-9\\-_]*");
    }

    public static String decorateWithCommandPrefix(String str) {
        if (str == null) {
            return null;
        }
        if (str.indexOf("~") != -1) {
            return str.replace('~', (char) 16);
        }
        return ZPL_INTERNAL_COMMAND_PREFIX + str;
    }

    public static String decorateWithFormatPrefix(String str) {
        if (str == null) {
            return null;
        }
        if (str.indexOf("^") != -1) {
            return str.replace('^', (char) 30);
        }
        return ZPL_INTERNAL_FORMAT_PREFIX + str;
    }

    public static String[] filterFileList(String[] strArr, String str) {
        if (str == null || str.equals("")) {
            str = "*:*.*";
        }
        Matcher matcher = Pattern.compile("(([A-Za-z\\*]{1}):)?([A-Za-z0-9\\-_\\*]+)\\.([A-Za-z0-9\\-_\\*]+)").matcher(str);
        if (!matcher.matches()) {
            return new String[0];
        }
        Pattern patternCompile = Pattern.compile(createFileNameRegex(matcher));
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (patternCompile.matcher(str2).matches()) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String getDYPrefix(char c, String str, char c2, String str2, int i, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(ZPL_INTERNAL_COMMAND_PREFIX);
        sb.append("DY");
        sb.append(c);
        sb.append(':');
        sb.append(str);
        String str4 = ZPL_INTERNAL_DELIMITER;
        sb.append(str4);
        sb.append(c2);
        sb.append(str4);
        sb.append(str2);
        sb.append(str4);
        sb.append(String.valueOf(i));
        sb.append(str4);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static int getDpmm(String str) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length >= 3) {
            try {
                return Integer.parseInt(strArrSplit[2]);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static String getHZO(String str) throws ZebraIllegalArgumentException {
        PrinterFilePath driveAndExtension = FileUtilities.parseDriveAndExtension(str);
        String strSubstring = str.substring(str.lastIndexOf(46));
        StringBuilder sb = new StringBuilder();
        String str2 = ZPL_INTERNAL_FORMAT_PREFIX;
        sb.append(str2);
        sb.append("XA");
        sb.append(str2);
        sb.append("HZO");
        sb.append(ZPL_INTERNAL_DELIMITER);
        sb.append(driveAndExtension.getDrive());
        sb.append(':');
        sb.append(driveAndExtension.getFileName());
        sb.append(strSubstring);
        sb.append(str2);
        sb.append("XZ");
        return sb.toString();
    }

    public static boolean isValidZplFirmware(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("[Vv][\\w-]+\\.[\\w-]+\\.[\\w-]+").matcher(str).matches();
    }

    public static List<StorageInfo> parseFileDriveInfoJson(String str) {
        DriveType driveType;
        ArrayList arrayList = new ArrayList();
        ObjectMapper jacksonObjectMapperFactory = JacksonObjectMapperFactory.getInstance();
        for (Map.Entry entry : ((Map) ((Map) jacksonObjectMapperFactory.readValue(str, jacksonObjectMapperFactory.getTypeFactory().constructMapType(LinkedHashMap.class, jacksonObjectMapperFactory.getTypeFactory().constructType(String.class), jacksonObjectMapperFactory.getTypeFactory().constructMapType(LinkedHashMap.class, String.class, FileObjectDetails.class)))).get(FILE_DRIVE_INFO_SETTING_NAME)).entrySet()) {
            StorageInfo storageInfo = new StorageInfo();
            storageInfo.driveLetter = ((String) entry.getKey()).charAt(0);
            storageInfo.bytesFree = ((FileObjectDetails) entry.getValue()).free;
            storageInfo.driveType = DriveType.UNKNOWN;
            storageInfo.isPersistent = true;
            String str2 = ((FileObjectDetails) entry.getValue()).storage;
            if (str2.equalsIgnoreCase("RAM")) {
                storageInfo.driveType = DriveType.RAM;
                storageInfo.isPersistent = false;
            } else {
                if (str2.equalsIgnoreCase("READ ONLY")) {
                    driveType = DriveType.READ_ONLY;
                } else if (str2.equalsIgnoreCase("ONBOARD FLASH")) {
                    driveType = DriveType.FLASH;
                }
                storageInfo.driveType = driveType;
                storageInfo.isPersistent = true;
            }
            arrayList.add(storageInfo);
        }
        return arrayList;
    }

    public static List<StorageInfo> parseHWCommand(String str) {
        DriveType driveType;
        ArrayList arrayList = new ArrayList();
        Pattern patternCompile = Pattern.compile("(\\d+).+([A-Z]): ([\\w\\s]+)");
        for (String str2 : str.split(StringUtilities.LF)) {
            Matcher matcher = patternCompile.matcher(str2.trim());
            if (matcher.find() && matcher.groupCount() == 3) {
                StorageInfo storageInfo = new StorageInfo();
                storageInfo.bytesFree = Long.parseLong(matcher.group(1));
                storageInfo.driveLetter = matcher.group(2).charAt(0);
                String strGroup = matcher.group(3);
                storageInfo.driveType = DriveType.UNKNOWN;
                storageInfo.isPersistent = true;
                if (strGroup.equalsIgnoreCase("RAM")) {
                    storageInfo.driveType = DriveType.RAM;
                    storageInfo.isPersistent = false;
                } else {
                    if (strGroup.equalsIgnoreCase("OPTION MEMORY") || strGroup.equalsIgnoreCase("MEMORY CARD")) {
                        driveType = DriveType.MASS_STORAGE;
                    } else if (strGroup.equalsIgnoreCase("ONBOARD FLASH")) {
                        driveType = DriveType.FLASH;
                    }
                    storageInfo.driveType = driveType;
                    storageInfo.isPersistent = true;
                }
                arrayList.add(storageInfo);
            }
        }
        return arrayList;
    }

    public static String replaceAllWithInternalCharacters(String str) {
        if (str == null) {
            return null;
        }
        return replaceAllWithInternalDelimeter(str).replace("^", ZPL_INTERNAL_FORMAT_PREFIX).replace("~", ZPL_INTERNAL_COMMAND_PREFIX);
    }

    public static String replaceAllWithInternalDelimeter(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(",", ZPL_INTERNAL_DELIMITER);
    }

    public static String replaceInternalCharactersWithReadableCharacters(String str) {
        return str.replaceAll(ZPL_INTERNAL_COMMAND_PREFIX, "~").replaceAll(ZPL_INTERNAL_FORMAT_PREFIX, "^").replaceAll(ZPL_INTERNAL_DELIMITER, ",");
    }

    public static void replaceInternalCharactersWithReadableCharacters(OutputStream outputStream, InputStream inputStream) {
        InternalCharacterFilteringOutputStream internalCharacterFilteringOutputStream = new ZPLUtilities().new InternalCharacterFilteringOutputStream(outputStream);
        byte[] bArr = new byte[16384];
        while (true) {
            try {
                try {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            internalCharacterFilteringOutputStream.close();
                            return;
                        }
                        internalCharacterFilteringOutputStream.write(bArr, 0, i);
                    } catch (IOException e) {
                        throw new ZebraIllegalArgumentException(e.getLocalizedMessage());
                    }
                } catch (Throwable th) {
                    internalCharacterFilteringOutputStream.close();
                    throw th;
                }
            } catch (IOException e2) {
                throw new ZebraIllegalArgumentException(e2.getLocalizedMessage());
            }
        }
    }

    public static byte[] replaceInternalCharactersWithReadableCharacters(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            if (b == 16) {
                bArr[i] = 126;
            } else if (b == 31) {
                bArr[i] = RefNPtg.sid;
            } else if (b == 30) {
                bArr[i] = 94;
            }
        }
        return bArr;
    }
}
