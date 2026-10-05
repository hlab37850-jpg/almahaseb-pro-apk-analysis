package com.zebra.sdk.util.internal;

import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.internal.DZHeader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class FileWrapper {
    public static final String CPCL_CRC16_FILE_HEADER_FOR_FLASH = "! CISDFCRC16";
    public static final String CPCL_CRC16_FILE_HEADER_FOR_RAM = "! CISDFRCRC16";
    public static final int SIZE_OF_DZ_HEADER = 16;
    public static final int SIZE_OF_LINKOS_DZ_HEADER = 24;
    private static final Set<String> validExtensionsToGetHzo = new HashSet(Arrays.asList("FNT", "ZPL", "GRF", "DAT", "STO", "PNG"));

    private FileWrapper() {
    }

    private static boolean alreadyContainsHeader(byte[] bArr) {
        String strTrim = new String(bArr).trim();
        return strTrim.startsWith(CPCL_CRC16_FILE_HEADER_FOR_FLASH) || strTrim.startsWith(CPCL_CRC16_FILE_HEADER_FOR_RAM);
    }

    private static String convertTo16dot3(String str) {
        try {
            PrinterFilePath driveAndExtension = FileUtilities.parseDriveAndExtension(str);
            int length = 16;
            if (driveAndExtension.getFileName().length() <= 16) {
                length = driveAndExtension.getFileName().length();
            }
            return new PrinterFilePath(driveAndExtension.getDrive(), driveAndExtension.getFileName().substring(0, length), driveAndExtension.getExtension()).toString();
        } catch (ZebraIllegalArgumentException unused) {
            return "";
        }
    }

    public static String createCisdfHeader(PrinterFileDescriptor printerFileDescriptor) {
        return getHeaderString(printerFileDescriptor.getName()) + StringUtilities.CRLF + printerFileDescriptor.getCrc16() + StringUtilities.CRLF + convertTo16dot3(printerFileDescriptor.getName()) + StringUtilities.CRLF + StringUtilities.stringPadToPlaces(8, "0", Long.toHexString(printerFileDescriptor.getFileSize()), false).toUpperCase() + StringUtilities.CRLF + printerFileDescriptor.getCheckSum() + StringUtilities.CRLF;
    }

    public static byte[] decodeHZOData(String str) {
        boolean z = str.indexOf("Z64:") >= 0;
        int iIndexOf = str.indexOf("64:") + 3;
        int iLastIndexOf = str.lastIndexOf(":");
        if (iIndexOf < 0 || iLastIndexOf <= iIndexOf) {
            return null;
        }
        return Base64.decode(str.substring(iIndexOf, iLastIndexOf), z);
    }

    private static int findStartOfNextLine(String str, int i) {
        boolean z = false;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (z && cCharAt != '\r' && cCharAt != '\n') {
                return i;
            }
            if (cCharAt == '\r' || cCharAt == '\n') {
                z = true;
            }
            i++;
        }
        return 0;
    }

    public static byte[] getCisdfTrailer() {
        return "\r\n\r\n".getBytes();
    }

    public static String getFileName(File file) {
        String strSubstring;
        String name = file.getName();
        String str = "";
        if (name.contains(".")) {
            strSubstring = name.substring(name.lastIndexOf(46) + 1);
            if (strSubstring.length() > 3) {
                strSubstring = strSubstring.substring(0, 3);
            }
            name = name.substring(0, name.lastIndexOf(46));
        } else {
            strSubstring = "";
        }
        if (name.length() > 8) {
            name = name.substring(0, 8);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name.toUpperCase());
        if (!strSubstring.equals("")) {
            str = "." + strSubstring.toUpperCase();
        }
        sb.append(str);
        return sb.toString();
    }

    private static String getHeaderString(String str) {
        try {
            String drive = FileUtilities.parseDriveAndExtension(str).getDrive();
            return (drive == null || !drive.toUpperCase().startsWith("R")) ? CPCL_CRC16_FILE_HEADER_FOR_FLASH : CPCL_CRC16_FILE_HEADER_FOR_RAM;
        } catch (ZebraIllegalArgumentException unused) {
            return CPCL_CRC16_FILE_HEADER_FOR_FLASH;
        }
    }

    public static boolean isHzoExtension(String str) {
        return validExtensionsToGetHzo.contains(str);
    }

    public static void stripDzHeaderFromObjectData(OutputStream outputStream, String str, byte[] bArr) throws ZebraIllegalArgumentException {
        int i = bArr[8] != 0 ? 24 : 16;
        if (str.substring(str.lastIndexOf(46) + 1).equalsIgnoreCase("ZPL")) {
            ZPLUtilities.replaceInternalCharactersWithReadableCharacters(outputStream, new ByteArrayInputStream(bArr, i, bArr.length - i));
            return;
        }
        try {
            outputStream.write(bArr, i, bArr.length - i);
        } catch (IOException e) {
            throw new ZebraIllegalArgumentException(e.getMessage());
        }
    }

    public static byte[] stripOffCISDFWrapper(byte[] bArr) {
        String str = new String(bArr);
        if (!str.startsWith(CPCL_CRC16_FILE_HEADER_FOR_FLASH) && !str.startsWith(CPCL_CRC16_FILE_HEADER_FOR_RAM)) {
            return bArr;
        }
        int iFindStartOfNextLine = 0;
        for (int i = 0; i < 5; i++) {
            iFindStartOfNextLine = findStartOfNextLine(str, iFindStartOfNextLine);
        }
        return str.substring(iFindStartOfNextLine).trim().getBytes();
    }

    public static void unwrapHZOResult(OutputStream outputStream, String str, String str2) throws ZebraIllegalArgumentException {
        byte[] bArrDecodeHZOData = decodeHZOData(str2);
        if (bArrDecodeHZOData != null && bArrDecodeHZOData.length > 16) {
            stripDzHeaderFromObjectData(outputStream, str, bArrDecodeHZOData);
            return;
        }
        throw new ZebraIllegalArgumentException("Malformed response from printer for " + str);
    }

    public static String wrapFile(File file, String str, boolean z, boolean z2) {
        return wrapFile(FileReader.toByteArray(file.getAbsolutePath()), str, z, z2);
    }

    public static byte[] wrapFileWithCisdfHeader(byte[] bArr, String str) {
        if (alreadyContainsHeader(bArr)) {
            return bArr;
        }
        String str2 = getHeaderString(str) + StringUtilities.CRLF + ZCRC16.getCRC16ForCisdfHeader(bArr).toUpperCase() + StringUtilities.CRLF + convertTo16dot3(str) + StringUtilities.CRLF + StringUtilities.stringPadToPlaces(8, "0", Long.toHexString(bArr.length), false).toUpperCase() + StringUtilities.CRLF + ZCRC16.getWChecksum(bArr).toUpperCase() + StringUtilities.CRLF;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(str2.getBytes());
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(getCisdfTrailer());
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] stripDzHeaderFromObjectData(String str, byte[] bArr) {
        int i = bArr[8] != 0 ? 24 : 16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArr, i, bArr.length - i);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return str.substring(str.lastIndexOf(46) + 1).equalsIgnoreCase("ZPL") ? ZPLUtilities.replaceInternalCharactersWithReadableCharacters(byteArray) : byteArray;
    }

    public static String wrapFile(byte[] bArr, String str, boolean z, boolean z2) throws ZebraIllegalArgumentException {
        PrinterFilePath driveAndExtension = FileUtilities.parseDriveAndExtension(str);
        String strSubstring = str.substring(str.lastIndexOf(46));
        byte[] header = DZHeader.getHeader(bArr, str, z, z2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(header);
            byteArrayOutputStream.write(bArr);
        } catch (IOException unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String strEncodeBytes = Base64.encodeBytes(byteArray, 8);
        String cRC16ForZpl = ZCRC16.getCRC16ForZpl(strEncodeBytes);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ZPLUtilities.ZPL_INTERNAL_COMMAND_PREFIX);
        stringBuffer.append("DZ");
        stringBuffer.append(driveAndExtension.getDrive());
        stringBuffer.append(":");
        stringBuffer.append(driveAndExtension.getFileName());
        stringBuffer.append(strSubstring);
        String str2 = ZPLUtilities.ZPL_INTERNAL_DELIMITER;
        stringBuffer.append(str2);
        stringBuffer.append(byteArray.length);
        stringBuffer.append(str2);
        stringBuffer.append(":B64:");
        stringBuffer.append(strEncodeBytes);
        stringBuffer.append(":");
        stringBuffer.append(cRC16ForZpl);
        return stringBuffer.toString();
    }
}
