package com.zebra.sdk.util.internal;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterFileDescriptor {
    private PrinterFileMetadata metaData;
    private String name;
    private InputStream sourceStream;

    public PrinterFileDescriptor(InputStream inputStream, String str, PrinterFileMetadata printerFileMetadata) {
        if (str == null || 2 >= str.length()) {
            throw new IllegalArgumentException("File name not provided");
        }
        if (str.charAt(1) != ':') {
            throw new IllegalArgumentException("Drive letter not specified");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("Source stream is null");
        }
        this.name = str;
        this.sourceStream = inputStream;
        this.metaData = printerFileMetadata;
    }

    public String getCheckSum() {
        return this.metaData.getCheckSum();
    }

    public String getCrc16() {
        return this.metaData.getCrc16();
    }

    public long getFileSize() {
        return this.metaData.getFileSize();
    }

    public String getName() {
        return this.name;
    }

    public InputStream getSourceStream() {
        return this.sourceStream;
    }
}
