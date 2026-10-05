package com.zebra.sdk.graphics.internal;

import com.zebra.sdk.util.internal.ReflectionUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class Ditherer {
    public static int getPixelWidthFromWidth(int i) {
        return ((i + 7) / 8) * 8;
    }

    public static int[] getZebraSpecificPngHeader(int i, int i2) {
        int pixelWidthFromWidth = getPixelWidthFromWidth(i);
        return new int[]{(pixelWidthFromWidth >> 8) & 255, pixelWidthFromWidth & 255, (i2 >> 8) & 255, i2 & 255};
    }

    public static void writeDitheredContents(InputStream inputStream, OutputStream outputStream) throws IOException {
        ZebraImageInternal zebraImageInternal = (ZebraImageInternal) ReflectionUtil.invokeZebraImageFactory_getImage(inputStream);
        for (int i : getZebraSpecificPngHeader(zebraImageInternal.getWidth(), zebraImageInternal.getHeight())) {
            outputStream.write(i);
        }
        DitheredImageProvider.getDitheredImage(zebraImageInternal, new NaughtyBitOutputStream(outputStream));
    }
}
