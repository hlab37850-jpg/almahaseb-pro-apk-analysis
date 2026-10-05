package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.PrinterFileMetadata;
import com.zebra.sdk.util.internal.ZCRC16;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class MPF_UnwrapperStream extends StreamDecoratorBase {
    private String boundary;
    private InputStream sourceStream;
    private StringBuffer readAheadBuffer = new StringBuffer();
    private boolean readingDataBody = false;
    private String fileName = "UNKNOWN.GRF";
    private long unwrappedFileSize = 0;
    private char crc16 = 0;
    private char sum = 0;

    public MPF_UnwrapperStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("input stream is null");
        }
        this.sourceStream = inputStream;
    }

    private void extractBoundary() throws IOException {
        Matcher matcher;
        do {
            int i = this.sourceStream.read();
            if (i == -1) {
                return;
            }
            this.readAheadBuffer.append((char) i);
            matcher = Pattern.compile("^[\\s]*--([^\\s|^-]+)\\r\\n").matcher(this.readAheadBuffer.toString());
        } while (!matcher.find());
        this.boundary = String.format("\r\n--%s--\r\n", matcher.group(1));
        StringBuffer stringBuffer = this.readAheadBuffer;
        stringBuffer.delete(0, stringBuffer.length());
    }

    private void extractFileNameFromHeader() throws IOException {
        do {
            int i = this.sourceStream.read();
            if (i == -1) {
                return;
            } else {
                this.readAheadBuffer.append((char) i);
            }
        } while (!this.readAheadBuffer.toString().endsWith("\r\n\r\n"));
        Matcher matcher = Pattern.compile("\\s+filename\\s*=\\s*\"([^\"]+)").matcher(this.readAheadBuffer.toString());
        if (matcher.find()) {
            this.fileName = matcher.group(1);
        }
    }

    private PrinterFileType getFileType() {
        PrinterFileType printerFileType = PrinterFileType.UNSUPPORTED;
        try {
            return PrinterFileType.getUnwrappedType(FileUtilities.parseDriveAndExtension(this.fileName).getExtension());
        } catch (ZebraIllegalArgumentException unused) {
            return PrinterFileType.UNSUPPORTED;
        }
    }

    private int getNextCharacter() throws IOException {
        if (this.readAheadBuffer.length() == 0 || this.readAheadBuffer.toString().equals(this.boundary)) {
            return -1;
        }
        char cCharAt = this.readAheadBuffer.charAt(0);
        this.readAheadBuffer.deleteCharAt(0);
        int i = this.sourceStream.read();
        if (i == -1) {
            throw new IOException("Malformed Multipart Form Data");
        }
        this.readAheadBuffer.append((char) i);
        if (this.readAheadBuffer.toString().equals(this.boundary)) {
            StringBuffer stringBuffer = this.readAheadBuffer;
            stringBuffer.delete(0, stringBuffer.length());
        }
        return cCharAt;
    }

    private void preloadReadAheadBuffer() {
        if (this.boundary != null) {
            StringBuffer stringBuffer = this.readAheadBuffer;
            stringBuffer.delete(0, stringBuffer.length());
            while (this.readAheadBuffer.length() != this.boundary.length()) {
                this.readAheadBuffer.append((char) this.sourceStream.read());
            }
        }
    }

    @Override // com.zebra.sdk.util.fileConversion.internal.MetadataProvider
    public PrinterFileMetadata getPrinterFileMetadata() {
        PrinterFileMetadata printerFileMetadata = new PrinterFileMetadata(this.unwrappedFileSize, String.format("%04X", Integer.valueOf(this.crc16)), String.format("%04X", Integer.valueOf((this.sum ^ 65535) + 1)), this.fileName);
        printerFileMetadata.setPrinterFileType(getFileType());
        printerFileMetadata.setPrinterWrappingType(PrinterWrappingType.MPF);
        return printerFileMetadata;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.readingDataBody) {
            extractBoundary();
            extractFileNameFromHeader();
            preloadReadAheadBuffer();
            this.readingDataBody = true;
        }
        int nextCharacter = getNextCharacter();
        if (nextCharacter != -1) {
            this.unwrappedFileSize++;
            this.sum = (char) (this.sum + nextCharacter);
            this.crc16 = ZCRC16.addCrc16Byte_cpcl(this.crc16, nextCharacter);
        }
        return nextCharacter;
    }
}
