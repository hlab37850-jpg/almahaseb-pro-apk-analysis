package com.zebra.sdk.settings;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsException extends Exception {
    private static final long serialVersionUID = 2362926827642134292L;

    public SettingsException() {
        this("Setting not found");
    }

    public SettingsException(String str) {
        super(str);
    }

    public SettingsException(String str, Throwable th) {
        super(str, th);
    }

    public SettingsException(Throwable th) {
        super(th);
    }
}
