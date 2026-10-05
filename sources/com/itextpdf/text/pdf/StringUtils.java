package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;

/* JADX INFO: loaded from: classes3.dex */
public class StringUtils {
    private static final byte[] r = DocWriter.getISOBytes("\\r");
    private static final byte[] n = DocWriter.getISOBytes("\\n");
    private static final byte[] t = DocWriter.getISOBytes("\\t");
    private static final byte[] b = DocWriter.getISOBytes("\\b");
    private static final byte[] f = DocWriter.getISOBytes("\\f");

    private StringUtils() {
    }

    public static byte[] convertCharsToBytes(char[] cArr) {
        byte[] bArr = new byte[cArr.length * 2];
        for (int i = 0; i < cArr.length; i++) {
            int i2 = i * 2;
            char c = cArr[i];
            bArr[i2] = (byte) (c / 256);
            bArr[i2 + 1] = (byte) (c % 256);
        }
        return bArr;
    }

    public static byte[] escapeString(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer();
        escapeString(bArr, byteBuffer);
        return byteBuffer.toByteArray();
    }

    public static void escapeString(byte[] bArr, ByteBuffer byteBuffer) {
        byteBuffer.append_i(40);
        for (int i : bArr) {
            if (i == 12) {
                byteBuffer.append(f);
            } else if (i == 13) {
                byteBuffer.append(r);
            } else if (i != 40 && i != 41 && i != 92) {
                switch (i) {
                    case 8:
                        byteBuffer.append(b);
                        break;
                    case 9:
                        byteBuffer.append(t);
                        break;
                    case 10:
                        byteBuffer.append(n);
                        break;
                    default:
                        byteBuffer.append_i(i);
                        break;
                }
            } else {
                byteBuffer.append_i(92).append_i(i);
            }
        }
        byteBuffer.append_i(41);
    }
}
