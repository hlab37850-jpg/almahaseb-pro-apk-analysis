package com.zebra.sdk.graphics.internal;

import com.zebra.sdk.util.internal.ReflectionUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DitheringStream extends InputStream {
    private int headerIndex;
    private int[] headerInfo;
    private ZebraImageInternal image;
    private ByteArrayInputStream tempDitheredImageBuffer;

    public DitheringStream(ZebraImageInternal zebraImageInternal) {
        this.headerIndex = 0;
        this.image = zebraImageInternal;
        processImage();
    }

    private void processImage() {
        this.headerInfo = Ditherer.getZebraSpecificPngHeader(this.image.getWidth(), this.image.getHeight());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DitheredImageProvider.getDitheredImage(this.image, new NaughtyBitOutputStream(byteArrayOutputStream));
        this.tempDitheredImageBuffer = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // java.io.InputStream
    public int read() {
        int i = this.headerIndex;
        int[] iArr = this.headerInfo;
        if (i >= iArr.length) {
            return this.tempDitheredImageBuffer.read();
        }
        this.headerIndex = i + 1;
        return iArr[i];
    }

    public DitheringStream(InputStream inputStream) {
        this((ZebraImageInternal) ReflectionUtil.invokeZebraImageFactory_getImage(inputStream));
    }
}
