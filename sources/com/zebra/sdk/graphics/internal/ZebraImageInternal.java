package com.zebra.sdk.graphics.internal;

import com.zebra.sdk.graphics.ZebraImageI;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraImageInternal extends ZebraImageI {
    byte[] getDitheredB64EncodedPng();

    int[] getRow(int i);

    boolean scaleImage(int i, int i2);

    void writeDitheredPng(OutputStream outputStream);
}
