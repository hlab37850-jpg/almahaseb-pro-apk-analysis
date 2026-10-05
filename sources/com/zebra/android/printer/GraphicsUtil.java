package com.zebra.android.printer;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public interface GraphicsUtil {
    void printImage(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z);

    void printImage(String str, int i, int i2);

    void printImage(String str, int i, int i2, int i3, int i4, boolean z);

    void storeImage(String str, Bitmap bitmap, int i, int i2);
}
