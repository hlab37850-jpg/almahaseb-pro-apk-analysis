package com.zebra.sdk.printer;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface ProfileUtil {
    void createBackup(String str);

    void createProfile(OutputStream outputStream);

    void createProfile(String str);

    void loadBackup(String str);

    void loadBackup(String str, boolean z);

    void loadProfile(String str);

    void loadProfile(String str, FileDeletionOption fileDeletionOption, boolean z);
}
