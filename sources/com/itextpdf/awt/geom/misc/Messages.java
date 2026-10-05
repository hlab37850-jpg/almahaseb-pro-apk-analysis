package com.itextpdf.awt.geom.misc;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes3.dex */
public class Messages {
    private static ResourceBundle bundle;

    /* JADX WARN: Code duplicated, block: B:21:0x004c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0064 A[SYNTHETIC] */
    public static String format(String str, Object[] objArr) {
        byte bDigit;
        int i;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 20));
        int length = objArr.length;
        String[] strArr = new String[length];
        int length2 = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                strArr[i2] = "<null>";
            } else {
                strArr[i2] = obj.toString();
            }
        }
        while (true) {
            int iIndexOf = str.indexOf(123, length2);
            if (iIndexOf < 0) {
                break;
            }
            if (iIndexOf != 0) {
                int i3 = iIndexOf - 1;
                if (str.charAt(i3) == '\\') {
                    if (iIndexOf != 1) {
                        sb.append(str.substring(length2, i3));
                    }
                    sb.append('{');
                    i = iIndexOf + 1;
                } else if (iIndexOf > str.length() - 3) {
                    sb.append(str.substring(length2, str.length()));
                    length2 = str.length();
                } else {
                    int i4 = iIndexOf + 1;
                    bDigit = (byte) Character.digit(str.charAt(i4), 10);
                    if (bDigit >= 0 || str.charAt(iIndexOf + 2) != '}') {
                        sb.append(str.substring(length2, i4));
                        length2 = i4;
                    } else {
                        sb.append(str.substring(length2, iIndexOf));
                        if (bDigit >= length) {
                            sb.append("<missing argument>");
                        } else {
                            sb.append(strArr[bDigit]);
                        }
                        i = iIndexOf + 3;
                    }
                }
                length2 = i;
            } else if (iIndexOf > str.length() - 3) {
                sb.append(str.substring(length2, str.length()));
                length2 = str.length();
            } else {
                int i5 = iIndexOf + 1;
                bDigit = (byte) Character.digit(str.charAt(i5), 10);
                if (bDigit >= 0) {
                }
                sb.append(str.substring(length2, i5));
                length2 = i5;
            }
        }
        if (length2 < str.length()) {
            sb.append(str.substring(length2, str.length()));
        }
        return sb.toString();
    }

    public static String getString(String str) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return "Missing message: " + str;
        }
    }

    public static String getString(String str, Object obj) {
        return getString(str, new Object[]{obj});
    }

    public static String getString(String str, int i) {
        return getString(str, new Object[]{Integer.toString(i)});
    }

    public static String getString(String str, char c) {
        return getString(str, new Object[]{String.valueOf(c)});
    }

    public static String getString(String str, Object obj, Object obj2) {
        return getString(str, new Object[]{obj, obj2});
    }

    public static String getString(String str, Object[] objArr) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        return format(str, objArr);
    }
}
