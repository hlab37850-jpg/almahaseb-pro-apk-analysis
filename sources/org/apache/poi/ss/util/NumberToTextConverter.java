package org.apache.poi.ss.util;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: loaded from: classes4.dex */
public final class NumberToTextConverter {
    private static final long EXCEL_NAN_BITS = -276939487313920L;
    private static final int MAX_TEXT_LEN = 20;

    private NumberToTextConverter() {
    }

    private static void appendExp(StringBuilder sb, int i) {
        if (i >= 10) {
            sb.append(i);
        } else {
            sb.append('0');
            sb.append((char) (i + 48));
        }
    }

    private static void convertToText(StringBuilder sb, NormalisedDecimal normalisedDecimal) {
        String significantDecimalDigits;
        NormalisedDecimal normalisedDecimalRoundUnits = normalisedDecimal.roundUnits();
        int decimalExponent = normalisedDecimalRoundUnits.getDecimalExponent();
        if (Math.abs(decimalExponent) > 98) {
            significantDecimalDigits = normalisedDecimalRoundUnits.getSignificantDecimalDigitsLastDigitRounded();
            if (significantDecimalDigits.length() == 16) {
                decimalExponent++;
            }
        } else {
            significantDecimalDigits = normalisedDecimalRoundUnits.getSignificantDecimalDigits();
        }
        int iCountSignifantDigits = countSignifantDigits(significantDecimalDigits);
        if (decimalExponent < 0) {
            formatLessThanOne(sb, significantDecimalDigits, decimalExponent, iCountSignifantDigits);
        } else {
            formatGreaterThanOne(sb, significantDecimalDigits, decimalExponent, iCountSignifantDigits);
        }
    }

    private static int countSignifantDigits(String str) {
        int length = str.length() - 1;
        while (str.charAt(length) == '0') {
            length--;
            if (length < 0) {
                throw new RuntimeException("No non-zero digits found");
            }
        }
        return length + 1;
    }

    private static void formatGreaterThanOne(StringBuilder sb, String str, int i, int i2) {
        if (i > 19) {
            sb.append(str.charAt(0));
            if (i2 > 1) {
                sb.append('.');
                sb.append(str.subSequence(1, i2));
            }
            sb.append("E+");
            appendExp(sb, i);
            return;
        }
        int i3 = (i2 - i) - 1;
        if (i3 > 0) {
            int i4 = i + 1;
            sb.append(str.subSequence(0, i4));
            sb.append('.');
            sb.append(str.subSequence(i4, i2));
            return;
        }
        sb.append(str.subSequence(0, i2));
        for (int i5 = -i3; i5 > 0; i5--) {
            sb.append('0');
        }
    }

    private static void formatLessThanOne(StringBuilder sb, String str, int i, int i2) {
        int i3 = -i;
        if (!needsScientificNotation(i3 + 1 + i2)) {
            sb.append("0.");
            for (int i4 = i3 - 1; i4 > 0; i4--) {
                sb.append('0');
            }
            sb.append(str.subSequence(0, i2));
            return;
        }
        sb.append(str.charAt(0));
        if (i2 > 1) {
            sb.append('.');
            sb.append(str.subSequence(1, i2));
        }
        sb.append("E-");
        appendExp(sb, i3);
    }

    private static boolean needsScientificNotation(int i) {
        return i > 20;
    }

    public static String rawDoubleBitsToText(long j) {
        boolean z = false;
        boolean z2 = j < 0;
        if (z2) {
            j &= LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j == 0) {
            return z2 ? "-0" : "0";
        }
        ExpandedDouble expandedDouble = new ExpandedDouble(j);
        if (expandedDouble.getBinaryExponent() < -1022) {
            return z2 ? "-0" : "0";
        }
        if (expandedDouble.getBinaryExponent() != 1024) {
            z = z2;
        } else if (j == EXCEL_NAN_BITS) {
            return "3.484840871308E+308";
        }
        NormalisedDecimal normalisedDecimalNormaliseBaseTen = expandedDouble.normaliseBaseTen();
        StringBuilder sb = new StringBuilder(21);
        if (z) {
            sb.append('-');
        }
        convertToText(sb, normalisedDecimalNormaliseBaseTen);
        return sb.toString();
    }

    public static String toText(double d) {
        return rawDoubleBitsToText(Double.doubleToLongBits(d));
    }
}
