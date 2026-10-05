package com.zebra.sdk.util.internal;

import com.zebra.sdk.comm.Connection;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class MultipartFileRequester {
    private Connection connection;
    private String fullFilePath;

    public MultipartFileRequester(Connection connection, String str) {
        this.connection = connection;
        this.fullFilePath = str;
    }

    private String generateBoundary() {
        String strReplaceAll = UUID.randomUUID().toString().replaceAll("\\-|\\{|\\}", "Z");
        return (strReplaceAll + strReplaceAll).substring(0, 65);
    }

    private void send() {
        String str = this.fullFilePath;
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("No file name specified");
        }
        sendToPrinter();
    }

    private void sendToPrinter() {
        String strGenerateBoundary = generateBoundary();
        this.connection.write(String.format("{}--%s\r\nContent-Disposition: filename=\"%s\"; action=\"retrieve\"\r\nContent-Type: application/octet-stream\r\nContent-Transfer-Encoding: binary\r\n\r\n\r\n--%s--\r\n\r\n", strGenerateBoundary, this.fullFilePath, strGenerateBoundary).getBytes());
    }

    public static void send(Connection connection, String str) {
        new MultipartFileRequester(connection, str).send();
    }
}
