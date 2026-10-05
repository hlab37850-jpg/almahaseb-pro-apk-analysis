package com.zebra.sdk.printer;

/* JADX INFO: loaded from: classes3.dex */
public interface FirmwareUpdaterLinkOs {
    void updateFirmware(String str, long j, FirmwareUpdateHandler firmwareUpdateHandler);

    void updateFirmware(String str, FirmwareUpdateHandler firmwareUpdateHandler);

    void updateFirmwareUnconditionally(String str, long j, FirmwareUpdateHandler firmwareUpdateHandler);

    void updateFirmwareUnconditionally(String str, FirmwareUpdateHandler firmwareUpdateHandler);
}
