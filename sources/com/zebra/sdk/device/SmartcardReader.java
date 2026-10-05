package com.zebra.sdk.device;

/* JADX INFO: loaded from: classes3.dex */
public interface SmartcardReader {
    void close();

    byte[] doCommand(String str);

    byte[] getATR();
}
