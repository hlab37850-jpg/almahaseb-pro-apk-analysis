package com.zebra.sdk.graphics.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.ViewCompat;
import com.zebra.sdk.util.internal.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraImageAndroid implements ZebraImageInternal {
    private Bitmap bitmap;

    public ZebraImageAndroid(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bitmap arg cannot be null");
        }
        this.bitmap = bitmap;
    }

    private void removePixelPaddingFromRaster(int i, int i2, ByteArrayOutputStream byteArrayOutputStream, Bitmap bitmap, int i3) {
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                bitmap.setPixel(i5, i4, ((byte) ((byteArray[(i4 * i3) + (i5 / 8)] & (1 << (7 - (i5 % 8)))) == 0 ? 0 : 1)) == 0 ? ViewCompat.MEASURED_STATE_MASK : -1);
            }
        }
    }

    @Override // com.zebra.sdk.graphics.internal.ZebraImageInternal
    public byte[] getDitheredB64EncodedPng() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeDitheredPng(byteArrayOutputStream);
        return Base64.encodeBytes(byteArrayOutputStream.toByteArray(), 8).getBytes();
    }

    @Override // com.zebra.sdk.graphics.ZebraImageI
    public int getHeight() {
        return this.bitmap.getHeight();
    }

    @Override // com.zebra.sdk.graphics.internal.ZebraImageInternal
    public int[] getRow(int i) {
        if (i >= this.bitmap.getHeight()) {
            return null;
        }
        int width = this.bitmap.getWidth();
        int[] iArr = new int[width];
        this.bitmap.getPixels(iArr, 0, width, 0, i, width, 1);
        return iArr;
    }

    @Override // com.zebra.sdk.graphics.ZebraImageI
    public int getWidth() {
        return this.bitmap.getWidth();
    }

    @Override // com.zebra.sdk.graphics.internal.ZebraImageInternal
    public boolean scaleImage(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        this.bitmap = Bitmap.createScaledBitmap(this.bitmap, i, i2, true);
        return true;
    }

    @Override // com.zebra.sdk.graphics.internal.ZebraImageInternal
    public void writeDitheredPng(OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DitheredImageProvider.getDitheredImage(this, byteArrayOutputStream);
        int width = (getWidth() / 8) + (getWidth() % 8 == 0 ? 0 : 1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        removePixelPaddingFromRaster(getWidth(), getHeight(), byteArrayOutputStream, bitmapCreateBitmap, width);
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
    }

    public ZebraImageAndroid(InputStream inputStream) throws IOException {
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
        this.bitmap = bitmapDecodeStream;
        if (bitmapDecodeStream == null) {
            throw new IOException("unknown image type");
        }
    }

    public ZebraImageAndroid(String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("image path arg cannot be null");
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        this.bitmap = bitmapDecodeFile;
        if (bitmapDecodeFile == null) {
            throw new IOException("unknown image type");
        }
    }
}
