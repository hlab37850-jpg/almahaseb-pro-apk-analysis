package com.zebra.sdk.printer;

import com.zebra.sdk.graphics.ZebraImageI;

/* JADX INFO: loaded from: classes3.dex */
public interface GraphicsUtil {
    void printImage(ZebraImageI zebraImageI, int i, int i2, int i3, int i4, boolean z);

    void printImage(String str, int i, int i2);

    void printImage(String str, int i, int i2, int i3, int i4, boolean z);

    void storeImage(String str, ZebraImageI zebraImageI, int i, int i2);

    void storeImage(String str, String str2, int i, int i2);
}
