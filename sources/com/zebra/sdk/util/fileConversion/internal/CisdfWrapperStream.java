package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.util.internal.PrinterFileMetadata;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class CisdfWrapperStream extends InputStream {
    private ByteArrayInputStream cisdfHeader;
    private InputStream sourceStream;

    public CisdfWrapperStream(InputStream inputStream, PrinterFileMetadata printerFileMetadata) {
        this.sourceStream = inputStream;
        this.cisdfHeader = new ByteArrayInputStream(String.format("! CISDFCRC16\r\n%s\r\n%s\r\n%08X\r\n%s\r\n", printerFileMetadata.getCrc16(), printerFileMetadata.getFileName(), Long.valueOf(printerFileMetadata.getFileSize()), printerFileMetadata.getCheckSum()).getBytes());
    }

    @Override // java.io.InputStream
    public int read() {
        return this.cisdfHeader.available() > 0 ? this.cisdfHeader.read() : this.sourceStream.read();
    }
}
