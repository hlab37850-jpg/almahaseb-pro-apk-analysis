package com.zebra.sdk.printer.internal;

import com.zebra.sdk.printer.PrinterObjectProperties;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterFilePropertiesZpl extends PrinterObjectProperties {
    public PrinterFilePropertiesZpl(String str, String str2, String str3, long j) {
        this.drivePrefix = str;
        this.fileName = str2;
        this.extension = str3;
        this.fileSize = j;
    }

    public PrinterFilePropertiesZpl(String str, String str2, String str3, long j, long j2) {
        this.drivePrefix = str;
        this.fileName = str2;
        this.extension = str3;
        this.fileSize = j;
        this.CRC32 = j2;
    }
}
