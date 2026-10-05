package com.zebra.sdk.printer;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface FontUtil {
    void downloadTteFont(InputStream inputStream, String str);

    void downloadTteFont(String str, String str2);

    void downloadTtfFont(InputStream inputStream, String str);

    void downloadTtfFont(String str, String str2);
}
