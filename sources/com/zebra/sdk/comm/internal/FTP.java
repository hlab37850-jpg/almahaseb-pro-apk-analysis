package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.ConnectionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/* JADX INFO: loaded from: classes3.dex */
public class FTP {
    private static final String DEFAULT_PASSWORD = "1234";
    private static final String DEFAULT_USER = "user";
    FTPClient client;
    String password;
    String server;
    String user;

    public FTP(String str, String str2, String str3) {
        this.server = str;
        this.user = str2 == null ? DEFAULT_USER : str2;
        this.password = str3 == null ? DEFAULT_PASSWORD : str3;
        this.client = new FTPClient();
    }

    private void deleteFile(FTPFile fTPFile, FTPClient fTPClient) {
        if (fTPFile.isDirectory()) {
            fTPClient.changeWorkingDirectory(fTPFile.getName());
            for (FTPFile fTPFile2 : fTPClient.listFiles()) {
                deleteFile(fTPFile2, fTPClient);
            }
            fTPClient.changeWorkingDirectory("..");
            fTPClient.removeDirectory(fTPFile.getName());
        }
        fTPClient.deleteFile(fTPFile.getName());
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0038 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void deleteAllFilesAndSubDirectories(java.util.List<java.lang.String> r7) throws com.zebra.sdk.comm.ConnectionException {
        /*
            r6 = this;
            java.lang.String r0 = "/"
            org.apache.commons.net.ftp.FTPClient r1 = r6.client     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.lang.String r2 = r6.server     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r1.connect(r2)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            org.apache.commons.net.ftp.FTPClient r1 = r6.client     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.lang.String r2 = r6.user     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.lang.String r3 = r6.password     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r1.login(r2, r3)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
        L16:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            if (r1 == 0) goto L5d
            java.lang.Object r1 = r7.next()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            boolean r2 = r1.endsWith(r0)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            if (r2 != 0) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r2.<init>()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r2.append(r1)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r2.append(r0)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            goto L3c
        L38:
            r7 = move-exception
            goto L81
        L3a:
            r7 = move-exception
            goto L77
        L3c:
            org.apache.commons.net.ftp.FTPClient r2 = r6.client     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r2.changeWorkingDirectory(r1)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            org.apache.commons.net.ftp.FTPClient r1 = r6.client     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            org.apache.commons.net.ftp.FTPFile[] r1 = r1.listFiles()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            int r2 = r1.length     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r3 = 0
        L49:
            if (r3 >= r2) goto L55
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            org.apache.commons.net.ftp.FTPClient r5 = r6.client     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r6.deleteFile(r4, r5)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            int r3 = r3 + 1
            goto L49
        L55:
            org.apache.commons.net.ftp.FTPClient r1 = r6.client     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.lang.String r2 = ".."
            r1.changeWorkingDirectory(r2)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            goto L16
        L5d:
            org.apache.commons.net.ftp.FTPClient r7 = r6.client
            boolean r7 = r7.isConnected()
            if (r7 == 0) goto L76
            org.apache.commons.net.ftp.FTPClient r7 = r6.client     // Catch: java.io.IOException -> L6b
            r7.disconnect()     // Catch: java.io.IOException -> L6b
            goto L76
        L6b:
            r7 = move-exception
            com.zebra.sdk.comm.ConnectionException r0 = new com.zebra.sdk.comm.ConnectionException
            java.lang.String r7 = r7.getLocalizedMessage()
            r0.<init>(r7)
            throw r0
        L76:
            return
        L77:
            com.zebra.sdk.comm.ConnectionException r0 = new com.zebra.sdk.comm.ConnectionException     // Catch: java.lang.Throwable -> L38
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch: java.lang.Throwable -> L38
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L38
            throw r0     // Catch: java.lang.Throwable -> L38
        L81:
            org.apache.commons.net.ftp.FTPClient r0 = r6.client
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L9a
            org.apache.commons.net.ftp.FTPClient r0 = r6.client     // Catch: java.io.IOException -> L8f
            r0.disconnect()     // Catch: java.io.IOException -> L8f
            goto L9a
        L8f:
            r7 = move-exception
            com.zebra.sdk.comm.ConnectionException r0 = new com.zebra.sdk.comm.ConnectionException
            java.lang.String r7 = r7.getLocalizedMessage()
            r0.<init>(r7)
            throw r0
        L9a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zebra.sdk.comm.internal.FTP.deleteAllFilesAndSubDirectories(java.util.List):void");
    }

    public void getFile(OutputStream outputStream, String str) throws ConnectionException {
        try {
            try {
                this.client.connect(this.server);
                this.client.login(this.user, this.password);
                this.client.setFileType(2);
                if (!FTPReply.isPositiveCompletion(this.client.getReplyCode())) {
                    this.client.disconnect();
                    throw new ConnectionException("Could not connect to printer over FTP, make sure FTP is enabled");
                }
                this.client.retrieveFile(str, outputStream);
                if (this.client.isConnected()) {
                    try {
                        this.client.disconnect();
                    } catch (IOException e) {
                        throw new ConnectionException(e.getLocalizedMessage());
                    }
                }
            } catch (Throwable th) {
                if (this.client.isConnected()) {
                    try {
                        this.client.disconnect();
                    } catch (IOException e2) {
                        throw new ConnectionException(e2.getLocalizedMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new ConnectionException(e3.getLocalizedMessage());
        }
    }

    public void putFile(String str, String str2, InputStream inputStream) throws ConnectionException {
        putFiles(Arrays.asList(new FtpFileHolder(str, str2, inputStream)));
    }

    public void putFiles(List<FtpFileHolder> list) throws ConnectionException {
        try {
            try {
                this.client.connect(this.server);
                this.client.login(this.user, this.password);
                this.client.setFileType(2);
                for (FtpFileHolder ftpFileHolder : list) {
                    if (!ftpFileHolder.pathOnServer.endsWith("/")) {
                        ftpFileHolder.pathOnServer += "/";
                    }
                    this.client.makeDirectory(ftpFileHolder.pathOnServer);
                    String strReplaceAll = ftpFileHolder.fileName.replaceAll(":", "_");
                    this.client.storeFile(ftpFileHolder.pathOnServer + strReplaceAll, ftpFileHolder.fileStream);
                }
                if (this.client.isConnected()) {
                    try {
                        this.client.disconnect();
                    } catch (IOException e) {
                        throw new ConnectionException(e.getLocalizedMessage());
                    }
                }
            } catch (IOException e2) {
                throw new ConnectionException(e2.getLocalizedMessage());
            }
        } catch (Throwable th) {
            if (this.client.isConnected()) {
                try {
                    this.client.disconnect();
                } catch (IOException e3) {
                    throw new ConnectionException(e3.getLocalizedMessage());
                }
            }
            throw th;
        }
    }

    public void putFile(String str, String str2, byte[] bArr) throws ConnectionException {
        putFile(str, str2, new ByteArrayInputStream(bArr));
    }
}
