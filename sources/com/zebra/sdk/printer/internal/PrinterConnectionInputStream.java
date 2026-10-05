package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterConnectionInputStream extends PrinterConnectionInputStreamBase {
    public PrinterConnectionInputStream(Connection connection, long j, String str) {
        super(connection, j);
        this.terminator = str;
    }

    @Override // com.zebra.sdk.printer.internal.PrinterConnectionInputStreamBase
    public void setTerminatorBasedOnData(int i) {
    }
}
