package com.zebra.sdk.graphics.internal;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DitheredImageProvider {
    private static int convertByteToGrayscale(int i) {
        int i2 = (((((16711680 & i) >>> 16) * 30) + (((65280 & i) >>> 8) * 59)) + ((i & 255) * 11)) / 100;
        if (i2 > 255) {
            return 255;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public static void getDitheredImage(int i, int i2, ZebraImageInternal zebraImageInternal, OutputStream outputStream) throws IOException {
        byte b = 0;
        int[] row = zebraImageInternal.getRow(0);
        int[] row2 = zebraImageInternal.getRow(1);
        int i3 = i % 8;
        int i4 = (i / 8) + (i3 == 0 ? 0 : 1);
        int i5 = 8 - i3;
        if (i5 == 8) {
            i5 = 0;
        }
        byte[] bArr = new byte[i4];
        for (int i6 = 0; i6 < i; i6++) {
            row[i6] = convertByteToGrayscale(row[i6]);
        }
        int i7 = 0;
        byte b2 = 0;
        while (i7 < i2) {
            for (int i8 = 0; i8 < i4; i8++) {
                bArr[i8] = b;
            }
            int i9 = 0;
            int i10 = 0;
            while (i9 < i) {
                if (i9 % 8 == 0) {
                    b2 = UnsignedBytes.MAX_POWER_OF_TWO;
                }
                int i11 = row[i9];
                int i12 = i9 / 8;
                byte b3 = i11 >= 128 ? (byte) -1 : (byte) 0;
                bArr[i12] = (byte) (bArr[i12] | (b2 & b3));
                int i13 = i11 - (b3 & UnsignedBytes.MAX_VALUE);
                int i14 = i - 1;
                if (i9 < i14) {
                    int i15 = i9 + 1;
                    row[i15] = row[i15] + ((i13 * 7) / 16);
                }
                if (i9 > 0 && i7 < i2 - 1) {
                    int i16 = i9 - 1;
                    row2[i16] = row2[i16] + ((i13 * 3) / 16);
                }
                int i17 = i2 - 1;
                if (i7 < i17) {
                    if (i9 == 0) {
                        row2[i9] = convertByteToGrayscale(row2[i9]);
                    }
                    row2[i9] = row2[i9] + ((i13 * 5) / 16);
                }
                if (i7 < i17 && i9 < i14) {
                    int i18 = i9 + 1;
                    int iConvertByteToGrayscale = convertByteToGrayscale(row2[i18]);
                    row2[i18] = iConvertByteToGrayscale;
                    row2[i18] = iConvertByteToGrayscale + (i13 / 16);
                }
                b2 = (byte) ((b2 & UnsignedBytes.MAX_VALUE) >>> 1);
                i9++;
                i10 = i12;
            }
            bArr[i10] = (byte) (bArr[i10] | (255 >>> (8 - i5)));
            outputStream.write(bArr);
            int[] row3 = zebraImageInternal.getRow(i7 + 2);
            i7++;
            row = row2;
            row2 = row3;
            b = 0;
        }
    }

    public static void getDitheredImage(ZebraImageInternal zebraImageInternal, OutputStream outputStream) {
        getDitheredImage(zebraImageInternal.getWidth(), zebraImageInternal.getHeight(), zebraImageInternal, outputStream);
    }
}
