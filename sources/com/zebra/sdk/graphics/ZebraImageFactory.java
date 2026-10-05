package com.zebra.sdk.graphics;

import android.graphics.Bitmap;
import com.zebra.sdk.graphics.internal.ZebraImageAndroid;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraImageFactory {
    private ZebraImageFactory() {
    }

    public static ZebraImageI getImage(Bitmap bitmap) {
        return new ZebraImageAndroid(bitmap);
    }

    public static ZebraImageI getImage(InputStream inputStream) {
        return new ZebraImageAndroid(inputStream);
    }

    public static ZebraImageI getImage(String str) {
        return new ZebraImageAndroid(str);
    }
}
