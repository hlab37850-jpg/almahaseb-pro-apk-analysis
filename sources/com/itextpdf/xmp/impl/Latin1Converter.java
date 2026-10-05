package com.itextpdf.xmp.impl;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public class Latin1Converter {
    private static final int STATE_START = 0;
    private static final int STATE_UTF8CHAR = 11;

    private Latin1Converter() {
    }

    public static ByteBuffer convert(ByteBuffer byteBuffer) {
        if (!XmpWriter.UTF8.equals(byteBuffer.getEncoding())) {
            return byteBuffer;
        }
        byte[] bArr = new byte[8];
        ByteBuffer byteBuffer2 = new ByteBuffer((byteBuffer.length() * 4) / 3);
        int i = 0;
        char c = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < byteBuffer.length()) {
            int iCharAt = byteBuffer.charAt(i);
            if (c == 11) {
                if (i2 <= 0 || (iCharAt & 192) != 128) {
                    byteBuffer2.append(convertToUTF8(bArr[0]));
                    i -= i3;
                } else {
                    int i4 = i3 + 1;
                    bArr[i3] = (byte) iCharAt;
                    i2--;
                    if (i2 == 0) {
                        byteBuffer2.append(bArr, 0, i4);
                    } else {
                        i3 = i4;
                    }
                }
                c = 0;
                i3 = 0;
            } else if (iCharAt < 127) {
                byteBuffer2.append((byte) iCharAt);
            } else if (iCharAt >= 192) {
                i2 = -1;
                for (int i5 = iCharAt; i2 < 8 && (i5 & 128) == 128; i5 <<= 1) {
                    i2++;
                }
                bArr[i3] = (byte) iCharAt;
                i3++;
                c = 11;
            } else {
                byteBuffer2.append(convertToUTF8((byte) iCharAt));
            }
            i++;
        }
        if (c == 11) {
            for (int i6 = 0; i6 < i3; i6++) {
                byteBuffer2.append(convertToUTF8(bArr[i6]));
            }
        }
        return byteBuffer2;
    }

    private static byte[] convertToUTF8(byte b) {
        int i = b & UnsignedBytes.MAX_VALUE;
        if (i >= 128) {
            try {
                return (i == 129 || i == 141 || i == 143 || i == 144 || i == 157) ? new byte[]{32} : new String(new byte[]{b}, "cp1252").getBytes(XmpWriter.UTF8);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new byte[]{b};
    }
}
