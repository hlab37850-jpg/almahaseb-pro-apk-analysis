package com.zebra.sdk.printer;

/* JADX INFO: loaded from: classes3.dex */
public interface ToolsUtil {
    void calibrate();

    void printConfigurationLabel();

    void reset();

    void restoreDefaults();

    void sendCommand(String str);

    void sendCommand(String str, String str2);
}
