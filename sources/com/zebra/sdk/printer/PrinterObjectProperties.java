package com.zebra.sdk.printer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PrinterObjectProperties {
    protected long CRC32;
    protected String drivePrefix;
    protected String extension;
    protected String fileName;
    protected long fileSize;

    public long getCRC32() {
        return this.CRC32;
    }

    public String getDrivePrefix() {
        return this.drivePrefix;
    }

    public String getExtension() {
        return this.extension;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFullName() {
        return this.drivePrefix + this.fileName + "." + this.extension;
    }

    public void setCRC32(long j) {
        this.CRC32 = j;
    }

    public void setDrivePrefix(String str) {
        this.drivePrefix = str;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }
}
