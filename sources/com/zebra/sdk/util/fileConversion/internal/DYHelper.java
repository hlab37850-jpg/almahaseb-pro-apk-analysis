package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.graphics.internal.Ditherer;

/* JADX INFO: loaded from: classes3.dex */
public class DYHelper {
    public static int[] calculateZebraHeader(int i, int i2) {
        return Ditherer.getZebraSpecificPngHeader(i * 8, i2 / i);
    }

    private static int getIntFromBytes(int i, int i2, int i3, int i4) {
        return ((i & 255) << 24) | ((i2 & 255) << 16) | ((i3 & 255) << 8) | (i4 & 255);
    }

    private static boolean isPcPng(int[] iArr) {
        return iArr.length >= 24 && iArr[0] == 137 && iArr[1] == 80 && iArr[2] == 78 && iArr[3] == 71;
    }

    public static int[] calculateZebraHeader(int[] iArr) {
        if (isPcPng(iArr)) {
            return Ditherer.getZebraSpecificPngHeader(getIntFromBytes(iArr[16], iArr[17], iArr[18], iArr[19]), getIntFromBytes(iArr[20], iArr[21], iArr[22], iArr[23]));
        }
        return null;
    }

    public static int[] calculateZebraHeader(int[] iArr, int i, int i2) {
        int[] iArrCalculateZebraHeader = calculateZebraHeader(iArr);
        return iArrCalculateZebraHeader == null ? calculateZebraHeader(i, i2) : iArrCalculateZebraHeader;
    }
}
