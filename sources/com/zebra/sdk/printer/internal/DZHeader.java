package com.zebra.sdk.printer.internal;

import com.zebra.sdk.util.internal.Extension;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DZHeader {
    private static final byte blank = 0;

    private DZHeader() {
    }

    private static byte getFlags(boolean z, boolean z2, String str) {
        byte b = z ? (byte) 64 : (byte) 0;
        if (z2) {
            b = (byte) (b | 32);
        }
        return str.length() > 8 ? (byte) (b | 8) : b;
    }

    public static byte[] getHeader(byte[] bArr, String str, boolean z, boolean z2) {
        return getHeaderHelper(getLength(bArr), str, z, z2);
    }

    private static byte[] getHeaderHelper(byte[] bArr, String str, boolean z, boolean z2) {
        String fileName = FileUtilities.parseDriveAndExtension(str).getFileName();
        String strStringPadToPlaces = StringUtilities.stringPadToPlaces(fileName.length() > 8 ? 17 : 9, (char) 0, fileName, true);
        byte flags = getFlags(z, z2, fileName);
        byte type = getType(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(strStringPadToPlaces.getBytes());
            byteArrayOutputStream.write(flags);
            byteArrayOutputStream.write(type);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(bArr);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] getLength(int i) {
        return StringUtilities.byteArrayPadToPlaces(4, BigInteger.valueOf(i).toByteArray());
    }

    private static byte getType(String str) {
        return (byte) Extension.getTypeValue(str.contains(".") ? str.substring(str.lastIndexOf(46) + 1) : "");
    }

    private static byte[] getLength(byte[] bArr) {
        return getLength(bArr.length);
    }
}
