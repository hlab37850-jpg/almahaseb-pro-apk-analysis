package com.zebra.sdk.util.internal;

import com.zebra.sdk.util.fileConversion.internal.PrinterFileType;
import com.zebra.sdk.util.fileConversion.internal.PrinterWrappingType;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterFileMetadata implements Serializable {
    private static final long serialVersionUID = 8624518581207798813L;
    private String checkSum;
    private String crc16;
    protected String fileName;
    private long fileSize;
    private PrinterWrappingType printerWrappingType = PrinterWrappingType.UNSUPPORTED;
    private PrinterFileType printerFileType = PrinterFileType.UNSUPPORTED;

    public PrinterFileMetadata(long j, String str, String str2) {
        init(j, str, str2, null);
    }

    private void init(long j, String str, String str2, String str3) {
        if (j <= 0 || isInvalid16BitHex(str) || isInvalid16BitHex(str2)) {
            throw new IllegalArgumentException("Could not instantiate a valid file metadata");
        }
        this.fileSize = j;
        this.crc16 = str;
        this.checkSum = str2;
        this.fileName = str3;
    }

    private boolean isInvalid16BitHex(String str) {
        try {
            Integer.parseInt(str, 16);
            return str.length() != 4;
        } catch (Exception unused) {
            return true;
        }
    }

    public String getCheckSum() {
        return this.checkSum;
    }

    public String getCrc16() {
        return this.crc16;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public PrinterFileType getPrinterFileType() {
        return this.printerFileType;
    }

    public PrinterWrappingType getPrinterWrappingType() {
        return this.printerWrappingType;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setPrinterFileType(PrinterFileType printerFileType) {
        this.printerFileType = printerFileType;
    }

    public void setPrinterWrappingType(PrinterWrappingType printerWrappingType) {
        this.printerWrappingType = printerWrappingType;
    }

    public PrinterFileMetadata(long j, String str, String str2, String str3) {
        init(j, str, str2, str3);
    }

    public PrinterFileMetadata(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        long j = 0;
        char cAddCrc16Byte_cpcl = 0;
        char c = 0;
        while (i != -1) {
            c = (char) (c + i);
            cAddCrc16Byte_cpcl = ZCRC16.addCrc16Byte_cpcl(cAddCrc16Byte_cpcl, i);
            j++;
            i = inputStream.read();
        }
        init(j, String.format("%04X", Integer.valueOf(cAddCrc16Byte_cpcl)), String.format("%04X", Integer.valueOf((65535 ^ c) + 1)), null);
    }
}
