package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ICC_Profile {
    private static HashMap<String, Integer> cstags;
    protected byte[] data;
    protected int numComponents;

    static {
        HashMap<String, Integer> map = new HashMap<>();
        cstags = map;
        map.put("XYZ ", 3);
        cstags.put("Lab ", 3);
        cstags.put("Luv ", 3);
        cstags.put("YCbr", 3);
        cstags.put("Yxy ", 3);
        cstags.put("RGB ", 3);
        cstags.put("GRAY", 1);
        cstags.put("HSV ", 3);
        cstags.put("HLS ", 3);
        cstags.put("CMYK", 4);
        cstags.put("CMY ", 3);
        cstags.put("2CLR", 2);
        cstags.put("3CLR", 3);
        cstags.put("4CLR", 4);
        cstags.put("5CLR", 5);
        cstags.put("6CLR", 6);
        cstags.put("7CLR", 7);
        cstags.put("8CLR", 8);
        cstags.put("9CLR", 9);
        cstags.put("ACLR", 10);
        cstags.put("BCLR", 11);
        cstags.put("CCLR", 12);
        cstags.put("DCLR", 13);
        cstags.put("ECLR", 14);
        cstags.put("FCLR", 15);
    }

    public static ICC_Profile GetInstance(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                ICC_Profile iCC_Profile = getInstance(fileInputStream2);
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return iCC_Profile;
            } catch (Exception e) {
                e = e;
                throw new ExceptionConverter(e);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static ICC_Profile getInstance(byte[] bArr, int i) {
        int iIntValue = 0;
        if (bArr.length < 128 || bArr[36] != 97 || bArr[37] != 99 || bArr[38] != 115 || bArr[39] != 112) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.icc.profile", new Object[0]));
        }
        try {
            ICC_Profile iCC_Profile = new ICC_Profile();
            iCC_Profile.data = bArr;
            Integer num = cstags.get(new String(bArr, 16, 4, "US-ASCII"));
            if (num != null) {
                iIntValue = num.intValue();
            }
            iCC_Profile.numComponents = iIntValue;
            if (iIntValue == i) {
                return iCC_Profile;
            }
            throw new IllegalArgumentException("ICC profile contains " + iIntValue + " component(s), the image data contains " + i + " component(s)");
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public byte[] getData() {
        return this.data;
    }

    public int getNumComponents() {
        return this.numComponents;
    }

    public static ICC_Profile getInstance(byte[] bArr) {
        try {
            Integer num = cstags.get(new String(bArr, 16, 4, "US-ASCII"));
            return getInstance(bArr, num == null ? 0 : num.intValue());
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static ICC_Profile getInstance(InputStream inputStream) {
        int i = 128;
        try {
            byte[] bArr = new byte[128];
            int i2 = 128;
            int i3 = 0;
            while (i2 > 0) {
                int i4 = inputStream.read(bArr, i3, i2);
                if (i4 < 0) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.icc.profile", new Object[0]));
                }
                i2 -= i4;
                i3 += i4;
            }
            if (bArr[36] == 97 && bArr[37] == 99 && bArr[38] == 115 && bArr[39] == 112) {
                int i5 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, 0, bArr2, 0, 128);
                int i6 = i5 - 128;
                while (i6 > 0) {
                    int i7 = inputStream.read(bArr2, i, i6);
                    if (i7 < 0) {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.icc.profile", new Object[0]));
                    }
                    i6 -= i7;
                    i += i7;
                }
                return getInstance(bArr2);
            }
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.icc.profile", new Object[0]));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
