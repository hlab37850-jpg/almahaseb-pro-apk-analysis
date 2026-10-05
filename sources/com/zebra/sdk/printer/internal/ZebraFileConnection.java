package com.zebra.sdk.printer.internal;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraFileConnection {
    void close();

    int fileSize();

    InputStream openInputStream();
}
