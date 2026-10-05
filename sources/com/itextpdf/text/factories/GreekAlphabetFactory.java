package com.itextpdf.text.factories;

import com.itextpdf.text.SpecialSymbol;

/* JADX INFO: loaded from: classes3.dex */
public class GreekAlphabetFactory {
    public static final String getLowerCaseString(int i) {
        return getString(i);
    }

    public static final String getString(int i) {
        return getString(i, true);
    }

    public static final String getUpperCaseString(int i) {
        return getString(i).toUpperCase();
    }

    public static final String getString(int i, boolean z) {
        int i2 = 1;
        if (i < 1) {
            return "";
        }
        int i3 = i - 1;
        int i4 = 24;
        int i5 = 0;
        while (true) {
            int i6 = i4 + i5;
            if (i3 < i6) {
                break;
            }
            i2++;
            i4 *= 24;
            i5 = i6;
        }
        int i7 = i3 - i5;
        char[] cArr = new char[i2];
        while (i2 > 0) {
            i2--;
            char c = (char) (i7 % 24);
            cArr[i2] = c;
            if (c > 16) {
                cArr[i2] = (char) (c + 1);
            }
            char c2 = (char) (cArr[i2] + (z ? (char) 945 : (char) 913));
            cArr[i2] = c2;
            cArr[i2] = SpecialSymbol.getCorrespondingSymbol(c2);
            i7 /= 24;
        }
        return String.valueOf(cArr);
    }
}
