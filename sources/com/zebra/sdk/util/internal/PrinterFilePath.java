package com.zebra.sdk.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterFilePath {
    private String drive;
    private String ext;
    private String fileName;

    public PrinterFilePath(String str, String str2, String str3) {
        this.drive = str;
        this.fileName = str2;
        this.ext = str3;
    }

    public String getDrive() {
        return this.drive;
    }

    public String getExtension() {
        return this.ext;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String toString() {
        String str;
        String extension = "";
        if (getDrive() == null || getDrive().equals("")) {
            str = "";
        } else {
            str = getDrive() + ":";
        }
        if (getExtension() != null && !getExtension().equals("")) {
            extension = getExtension();
        }
        return str + getFileName() + extension;
    }
}
