package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.printer.internal.FirmwareUtil;
import com.zebra.sdk.util.internal.FileWrapper;
import com.zebra.sdk.util.internal.PrinterFileMetadata;
import com.zebra.sdk.util.internal.ZCRC16;
import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class MetadataExtractorPassthruStream extends StreamDecoratorBase {
    private char crc16;
    private InputStream sourceStream;
    private char sum;
    private long numberOfBytes = 0;
    ByteArrayOutputStream headerBuffer = new ByteArrayOutputStream();

    public MetadataExtractorPassthruStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("Input stream is null");
        }
        this.sourceStream = inputStream;
        this.crc16 = (char) 0;
        this.sum = (char) 0;
    }

    private void checkForHeader(int i) {
        if (this.headerBuffer.size() < 200) {
            if (Character.isWhitespace(i) && this.headerBuffer.size() == 0) {
                return;
            }
            this.headerBuffer.write(i);
        }
    }

    private String extractFWVersionFromDCHeader(String str) {
        return FirmwareUtil.extractFirmwareVersion(new ByteArrayInputStream(str.getBytes()));
    }

    private PrinterWrappingType getTypeToUnwrap(String str) {
        PrinterWrappingType printerWrappingType = PrinterWrappingType.UNSUPPORTED;
        String strTrim = str.toUpperCase().replace(ZPLUtilities.ZPL_INTERNAL_COMMAND_PREFIX, "~").trim();
        if (strTrim.startsWith("~DG")) {
            return PrinterWrappingType.DG;
        }
        if (strTrim.startsWith("~DY")) {
            return PrinterWrappingType.DY;
        }
        if (strTrim.startsWith("~DZ")) {
            return PrinterWrappingType.DZ;
        }
        if (strTrim.startsWith(FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_FLASH) || strTrim.startsWith(FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_RAM)) {
            return PrinterWrappingType.CISDF;
        }
        if (strTrim.contains("~DC")) {
            return PrinterWrappingType.DC;
        }
        if (strTrim.contains("<ZEBRA-OBJECT>")) {
            return PrinterWrappingType.HZO;
        }
        return (strTrim.startsWith("--") && strTrim.contains("CONTENT-DISPOSITION:")) ? PrinterWrappingType.MPF : printerWrappingType;
    }

    @Override // com.zebra.sdk.util.fileConversion.internal.MetadataProvider
    public PrinterFileMetadata getPrinterFileMetadata() {
        PrinterFileMetadata printerFileMetadata = new PrinterFileMetadata(this.numberOfBytes, String.format("%04X", Integer.valueOf(this.crc16)), String.format("%04X", Integer.valueOf((this.sum ^ 65535) + 1)));
        String string = this.headerBuffer.toString();
        printerFileMetadata.setPrinterWrappingType(getTypeToUnwrap(string));
        if (printerFileMetadata.getPrinterWrappingType() == PrinterWrappingType.DC) {
            printerFileMetadata.setFileName(extractFWVersionFromDCHeader(string));
            printerFileMetadata.setPrinterFileType(PrinterFileType.FIRMWARE);
        }
        return printerFileMetadata;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.sourceStream.read();
        if (i > -1) {
            checkForHeader(i);
            this.numberOfBytes++;
            this.sum = (char) (this.sum + i);
            this.crc16 = ZCRC16.addCrc16Byte_cpcl(this.crc16, i);
        }
        return i;
    }
}
