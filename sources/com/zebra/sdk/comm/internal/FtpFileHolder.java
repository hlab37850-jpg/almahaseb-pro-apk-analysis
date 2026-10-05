package com.zebra.sdk.comm.internal;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class FtpFileHolder {
    public String fileName;
    public InputStream fileStream;
    public String pathOnServer;

    public FtpFileHolder(String str, String str2, InputStream inputStream) {
        this.pathOnServer = str;
        this.fileName = str2;
        this.fileStream = inputStream;
    }
}
