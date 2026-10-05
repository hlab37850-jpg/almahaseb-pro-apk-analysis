package com.zebra.sdk.graphics.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.zebra.sdk.graphics.ZebraImageFactory;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PngToGrfConverterAndroid {
    public static byte[] pngToGrf(InputStream inputStream) {
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DitheredImageProvider.getDitheredImage((ZebraImageInternal) ZebraImageFactory.getImage(bitmapDecodeStream), new NaughtyBitOutputStream(byteArrayOutputStream));
        return byteArrayOutputStream.toByteArray();
    }
}
