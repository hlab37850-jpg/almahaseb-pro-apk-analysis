package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.Connection;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface PrinterCommand {
    void sendAndWaitForResponse(OutputStream outputStream, Connection connection);

    void sendAndWaitForResponse(OutputStream outputStream, Connection connection, int i, int i2, String str);

    byte[] sendAndWaitForResponse(Connection connection);

    byte[] sendAndWaitForResponse(Connection connection, int i, int i2);

    byte[] sendAndWaitForResponse(Connection connection, int i, int i2, String str);
}
