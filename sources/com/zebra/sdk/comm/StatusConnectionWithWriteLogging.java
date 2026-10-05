package com.zebra.sdk.comm;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface StatusConnectionWithWriteLogging extends StatusConnection {
    void addWriteLogStream(OutputStream outputStream);
}
