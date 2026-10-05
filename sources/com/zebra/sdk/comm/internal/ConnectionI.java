package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.Connection;

/* JADX INFO: loaded from: classes3.dex */
public interface ConnectionI extends Connection {
    String getManufacturer();

    int getMaxDataToWrite();

    byte[] read(int i);

    byte[] read(int i, boolean z);

    void setMaxDataToWrite(int i);

    void setReadTimeout(int i);
}
