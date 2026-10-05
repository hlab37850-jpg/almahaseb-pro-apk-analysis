package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.FileWrapper;
import com.zebra.sdk.util.internal.PrinterFileMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class CisdfUnwrapperStream extends StreamDecoratorBase {
    private long bytesLeftToRead;
    private PrinterFileMetadata printerFileMetadata;
    private PushbackInputStream sourceStream;

    public CisdfUnwrapperStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("Missing CISDF Header : input stream is null");
        }
        this.sourceStream = new PushbackInputStream(inputStream);
        skipToHeaderInfo();
        String strGrabNextCisdfLine = grabNextCisdfLine();
        String strGrabNextCisdfLine2 = grabNextCisdfLine();
        long j = Integer.parseInt(grabNextCisdfLine(), 16);
        PrinterFileMetadata printerFileMetadata = new PrinterFileMetadata(j, strGrabNextCisdfLine, grabNextCisdfLine(), strGrabNextCisdfLine2);
        this.printerFileMetadata = printerFileMetadata;
        printerFileMetadata.setPrinterFileType(getFileType(strGrabNextCisdfLine2));
        this.printerFileMetadata.setPrinterWrappingType(PrinterWrappingType.CISDF);
        this.bytesLeftToRead = j;
    }

    private PrinterFileType getFileType(String str) {
        PrinterFileType printerFileType = PrinterFileType.UNSUPPORTED;
        try {
            return PrinterFileType.getUnwrappedType(FileUtilities.parseDriveAndExtension(str).getExtension());
        } catch (ZebraIllegalArgumentException unused) {
            return PrinterFileType.UNSUPPORTED;
        }
    }

    private String grabNextCisdfLine() throws IOException {
        int i;
        StringBuilder sb = new StringBuilder();
        do {
            i = this.sourceStream.read();
            if (i == -1) {
                break;
            }
        } while (Character.isWhitespace(i));
        while (i != -1 && !isEndOfLineCharacter(i)) {
            sb.append((char) i);
            i = this.sourceStream.read();
        }
        int i2 = this.sourceStream.read();
        if (!isEndOfLineCharacter(i2)) {
            this.sourceStream.unread(i2);
        }
        if (sb.length() != 0) {
            return sb.toString().trim();
        }
        throw new IOException("Invalid CISDF Header");
    }

    private boolean isEndOfLineCharacter(int i) {
        return i == 10 || i == 13;
    }

    private void skipToHeaderInfo() throws IOException {
        String strGrabNextCisdfLine;
        do {
            strGrabNextCisdfLine = grabNextCisdfLine();
        } while (strGrabNextCisdfLine.isEmpty());
        if (strGrabNextCisdfLine.startsWith(FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_FLASH) || strGrabNextCisdfLine.startsWith(FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_RAM)) {
            return;
        }
        throw new IOException("Invalid CISDF Header : \"" + strGrabNextCisdfLine + "\" does not start with \"" + FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_FLASH + "\" or \"" + FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_RAM + "\".");
    }

    @Override // com.zebra.sdk.util.fileConversion.internal.MetadataProvider
    public PrinterFileMetadata getPrinterFileMetadata() {
        return this.printerFileMetadata;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesLeftToRead <= 0) {
            return -1;
        }
        int i = this.sourceStream.read();
        if (i < 0) {
            throw new IOException("Expected more data");
        }
        this.bytesLeftToRead--;
        return i;
    }
}
