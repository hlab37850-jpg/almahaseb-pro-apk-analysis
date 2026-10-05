package com.zebra.sdk.printer.internal;

import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import com.zebra.sdk.printer.GraphicsUtil;
import com.zebra.sdk.util.internal.ReflectionUtil;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GraphicsUtilA implements GraphicsUtil {
    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(String str, int i, int i2) {
        printImage(str, i, i2, -1, -1, false);
    }

    public ZebraImageInternal scaleImage(int i, int i2, ZebraImageInternal zebraImageInternal) {
        zebraImageInternal.scaleImage(i, i2);
        return zebraImageInternal;
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, String str2, int i, int i2) {
        storeImage(str, ReflectionUtil.invokeZebraImageFactory_getImage(str2), i, i2);
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(String str, int i, int i2, int i3, int i4, boolean z) {
        printImage(ReflectionUtil.invokeZebraImageFactory_getImage(str), i, i2, i3, i4, z);
    }
}
