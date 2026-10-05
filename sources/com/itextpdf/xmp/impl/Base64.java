package com.itextpdf.xmp.impl;

import com.itextpdf.text.DocWriter;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.record.formula.AreaErrPtg;

/* JADX INFO: loaded from: classes3.dex */
public class Base64 {
    private static final byte EQUAL = -3;
    private static final byte INVALID = -1;
    private static final byte WHITESPACE = -2;
    private static byte[] base64 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, com.itextpdf.text.pdf.ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, AreaErrPtg.sid, DocWriter.FORWARD};
    private static byte[] ascii = new byte[255];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            ascii[i2] = -1;
        }
        while (true) {
            byte[] bArr = base64;
            if (i >= bArr.length) {
                byte[] bArr2 = ascii;
                bArr2[9] = WHITESPACE;
                bArr2[10] = WHITESPACE;
                bArr2[13] = WHITESPACE;
                bArr2[32] = WHITESPACE;
                bArr2[61] = EQUAL;
                return;
            }
            ascii[bArr[i]] = (byte) i;
            i++;
        }
    }

    public static final byte[] decode(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            byte b2 = ascii[b];
            if (b2 >= 0) {
                bArr[i2] = b2;
                i2++;
            } else if (b2 == -1) {
                throw new IllegalArgumentException("Invalid base 64 string");
            }
        }
        while (i2 > 0 && bArr[i2 - 1] == -3) {
            i2--;
        }
        int i3 = (i2 * 3) / 4;
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        while (i < i3 - 2) {
            int i5 = i4 + 1;
            bArr2[i] = (byte) (((bArr[i4] << 2) & 255) | ((bArr[i5] >>> 4) & 3));
            int i6 = i4 + 2;
            bArr2[i + 1] = (byte) (((bArr[i5] << 4) & 255) | ((bArr[i6] >>> 2) & 15));
            bArr2[i + 2] = (byte) (((bArr[i6] << 6) & 255) | (bArr[i4 + 3] & 63));
            i4 += 4;
            i += 3;
        }
        if (i < i3) {
            bArr2[i] = (byte) (((bArr[i4] << 2) & 255) | ((bArr[i4 + 1] >>> 4) & 3));
        }
        int i7 = i + 1;
        if (i7 < i3) {
            bArr2[i7] = (byte) (((bArr[i4 + 2] >>> 2) & 15) | ((bArr[i4 + 1] << 4) & 255));
        }
        return bArr2;
    }

    public static final byte[] encode(byte[] bArr) {
        return encode(bArr, 0);
    }

    public static final byte[] encode(byte[] bArr, int i) {
        int i2 = (i / 4) * 4;
        int i3 = 0;
        if (i2 < 0) {
            i2 = 0;
        }
        int length = ((bArr.length + 2) / 3) * 4;
        if (i2 > 0) {
            length += (length - 1) / i2;
        }
        byte[] bArr2 = new byte[length];
        int i4 = 0;
        int i5 = 0;
        while (i3 + 3 <= bArr.length) {
            int i6 = i3 + 2;
            int i7 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            i3 += 3;
            int i8 = i7 | (bArr[i6] & 255);
            byte[] bArr3 = base64;
            bArr2[i4] = bArr3[(i8 & 16515072) >> 18];
            bArr2[i4 + 1] = bArr3[(i8 & 258048) >> 12];
            bArr2[i4 + 2] = bArr3[(i8 & 4032) >> 6];
            int i9 = i4 + 4;
            bArr2[i4 + 3] = bArr3[i8 & 63];
            i5 += 4;
            if (i9 >= length || i2 <= 0 || i5 % i2 != 0) {
                i4 = i9;
            } else {
                i4 += 5;
                bArr2[i9] = 10;
            }
        }
        if (bArr.length - i3 == 2) {
            int i10 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            byte[] bArr4 = base64;
            bArr2[i4] = bArr4[(i10 & 16515072) >> 18];
            bArr2[i4 + 1] = bArr4[(i10 & 258048) >> 12];
            bArr2[i4 + 2] = bArr4[(i10 & 4032) >> 6];
            bArr2[i4 + 3] = 61;
        } else if (bArr.length - i3 == 1) {
            int i11 = (bArr[i3] & 255) << 16;
            byte[] bArr5 = base64;
            bArr2[i4] = bArr5[(i11 & 16515072) >> 18];
            bArr2[i4 + 1] = bArr5[(i11 & 258048) >> 12];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
        }
        return bArr2;
    }

    public static final String decode(String str) {
        return new String(decode(str.getBytes()));
    }

    public static final String encode(String str) {
        return new String(encode(str.getBytes()));
    }
}
