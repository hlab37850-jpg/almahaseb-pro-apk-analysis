package com.zebra.sdk.weblink;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public enum WeblinkConfigurationState {
    ConnectToPrinter,
    GetSettings,
    ConfigureWeblink,
    RestartPrinter,
    ReconnectToPrinter,
    VerifyWeblinkConnection;

    public static int getIndex(WeblinkConfigurationState weblinkConfigurationState) {
        return Arrays.asList(values()).indexOf(weblinkConfigurationState);
    }
}
