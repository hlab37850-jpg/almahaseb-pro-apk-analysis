package com.zebra.sdk.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public class PacketParsingUtil {
    public static int byte2int(byte b) {
        return b < 0 ? b + 256 : b;
    }

    public static String parseAddress(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer("");
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                return stringBuffer.toString();
            }
            stringBuffer.append(Integer.toString(byte2int(bArr[i3])));
            i3++;
            if (i3 != i4) {
                stringBuffer.append(".");
            }
        }
    }

    public static boolean parseBoolean(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (bArr[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public static String parseGeneralByte(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i3 = i; i3 < i + i2; i3++) {
            String upperCase = Integer.toHexString(byte2int(bArr[i3])).toUpperCase();
            if (upperCase.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(upperCase);
        }
        return stringBuffer.toString();
    }

    public static String parseGeneralString(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2 && bArr[i4] != 0; i4++) {
            i3++;
        }
        return new String(bArr, i, i3);
    }

    public static int parseInteger(byte[] bArr, int i, int i2) {
        int i3 = (i2 - 1) * 8;
        int i4 = 0;
        for (int i5 = i; i5 < i + i2; i5++) {
            i4 |= (bArr[i5] & 255) << i3;
            i3 -= 8;
        }
        return i4;
    }
}
