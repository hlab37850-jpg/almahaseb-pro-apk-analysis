package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.settings.internal.JsonValidator;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterCommandImpl implements PrinterCommand {
    private String command;

    public PrinterCommandImpl(String str) {
        this.command = str;
    }

    @Override // com.zebra.sdk.comm.internal.PrinterCommand
    public void sendAndWaitForResponse(OutputStream outputStream, Connection connection) {
        connection.sendAndWaitForValidResponse(outputStream, new ByteArrayInputStream(this.command.getBytes()), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), null);
    }

    public byte[] sendAndWaitForValidJsonResponse(Connection connection) {
        return connection.sendAndWaitForValidResponse(this.command.getBytes(), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), new JsonValidator());
    }

    @Override // com.zebra.sdk.comm.internal.PrinterCommand
    public void sendAndWaitForResponse(OutputStream outputStream, Connection connection, int i, int i2, String str) {
        connection.sendAndWaitForResponse(outputStream, new ByteArrayInputStream(this.command.getBytes()), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), str);
    }

    @Override // com.zebra.sdk.comm.internal.PrinterCommand
    public byte[] sendAndWaitForResponse(Connection connection) {
        return sendAndWaitForResponse(connection, connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData());
    }

    @Override // com.zebra.sdk.comm.internal.PrinterCommand
    public byte[] sendAndWaitForResponse(Connection connection, int i, int i2) {
        return sendAndWaitForResponse(connection, i, i2, null);
    }

    @Override // com.zebra.sdk.comm.internal.PrinterCommand
    public byte[] sendAndWaitForResponse(Connection connection, int i, int i2, String str) {
        return connection.sendAndWaitForResponse(this.command.getBytes(), i, i2, str);
    }
}
