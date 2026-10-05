package com.itextpdf.text.factories;

import com.itextpdf.text.pdf.Barcode128;

/* JADX INFO: loaded from: classes3.dex */
public class RomanNumberFactory {
    private static final RomanDigit[] roman = {new RomanDigit('m', 1000, false), new RomanDigit(Barcode128.CODE_AC_TO_B, 500, false), new RomanDigit(Barcode128.CODE_AB_TO_C, 100, true), new RomanDigit('l', 50, false), new RomanDigit('x', 10, true), new RomanDigit('v', 5, false), new RomanDigit(Barcode128.START_C, 1, true)};

    public static class RomanDigit {
        public char digit;
        public boolean pre;
        public int value;

        public RomanDigit(char c, int i, boolean z) {
            this.digit = c;
            this.value = i;
            this.pre = z;
        }
    }

    public static final String getLowerCaseString(int i) {
        return getString(i);
    }

    public static final String getString(int i) {
        RomanDigit[] romanDigitArr;
        RomanDigit romanDigit;
        StringBuffer stringBuffer = new StringBuffer();
        if (i < 0) {
            stringBuffer.append('-');
            i = -i;
        }
        if (i > 3000) {
            stringBuffer.append('|');
            int i2 = i / 1000;
            stringBuffer.append(getString(i2));
            stringBuffer.append('|');
            i -= i2 * 1000;
        }
        int i3 = 0;
        while (true) {
            RomanDigit romanDigit2 = roman[i3];
            while (i >= romanDigit2.value) {
                stringBuffer.append(romanDigit2.digit);
                i -= romanDigit2.value;
            }
            if (i <= 0) {
                return stringBuffer.toString();
            }
            int i4 = i3;
            do {
                romanDigitArr = roman;
                i4++;
                romanDigit = romanDigitArr[i4];
            } while (!romanDigit.pre);
            if (romanDigit.value + i >= romanDigit2.value) {
                stringBuffer.append(romanDigit.digit);
                stringBuffer.append(romanDigit2.digit);
                i -= romanDigit2.value - romanDigitArr[i4].value;
            }
            i3++;
        }
    }

    public static final String getUpperCaseString(int i) {
        return getString(i).toUpperCase();
    }

    public static final String getString(int i, boolean z) {
        if (z) {
            return getLowerCaseString(i);
        }
        return getUpperCaseString(i);
    }
}
