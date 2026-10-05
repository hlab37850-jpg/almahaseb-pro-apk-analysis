package com.zebra.sdk.graphics.internal;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class GrfToPngConverterAndroid {
    private static boolean getBit(byte b, int i) {
        return (b & ((byte) (1 << (7 - i)))) != 0;
    }

    private static Bitmap getImage(InputStream inputStream, int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        byte b = (byte) inputStream.read();
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                boolean bit = getBit(b, i3);
                i3++;
                if (i3 > 7) {
                    b = (byte) inputStream.read();
                    i3 = 0;
                }
                bitmapCreateBitmap.setPixel(i5, i4, bit ? ViewCompat.MEASURED_STATE_MASK : -1);
            }
        }
        return bitmapCreateBitmap;
    }

    public static byte[] grfToPng(InputStream inputStream, int i, int i2) {
        return imageToByteArray(getImage(inputStream, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static byte[] imageToByteArray(Bitmap bitmap) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArray = null;
        byte[] byteArray = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                    }
                    return byteArray;
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th;
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused2) {
        }
        return byteArray;
    }
}
