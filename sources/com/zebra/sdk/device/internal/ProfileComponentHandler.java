package com.zebra.sdk.device.internal;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface ProfileComponentHandler {
    void alertsHandler(InputStream inputStream);

    void fileHandler(String str, InputStream inputStream);

    void firmwareDisplayNameHandler(InputStream inputStream);

    void firmwareHandler(InputStream inputStream);

    void settingsHandler(InputStream inputStream);

    void supplementHandler(InputStream inputStream);
}
