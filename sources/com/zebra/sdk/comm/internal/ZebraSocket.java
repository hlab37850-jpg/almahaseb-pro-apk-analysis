package com.zebra.sdk.comm.internal;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraSocket {
    void close();

    void connect();

    InputStream getInputStream();

    OutputStream getOutputStream();

    void setReadTimeout(int i);
}
