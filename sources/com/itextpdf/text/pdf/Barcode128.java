package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

/* JADX INFO: loaded from: classes3.dex */
public class Barcode128 extends Barcode {
    private static final byte[][] BARS = {new byte[]{2, 1, 2, 2, 2, 2}, new byte[]{2, 2, 2, 1, 2, 2}, new byte[]{2, 2, 2, 2, 2, 1}, new byte[]{1, 2, 1, 2, 2, 3}, new byte[]{1, 2, 1, 3, 2, 2}, new byte[]{1, 3, 1, 2, 2, 2}, new byte[]{1, 2, 2, 2, 1, 3}, new byte[]{1, 2, 2, 3, 1, 2}, new byte[]{1, 3, 2, 2, 1, 2}, new byte[]{2, 2, 1, 2, 1, 3}, new byte[]{2, 2, 1, 3, 1, 2}, new byte[]{2, 3, 1, 2, 1, 2}, new byte[]{1, 1, 2, 2, 3, 2}, new byte[]{1, 2, 2, 1, 3, 2}, new byte[]{1, 2, 2, 2, 3, 1}, new byte[]{1, 1, 3, 2, 2, 2}, new byte[]{1, 2, 3, 1, 2, 2}, new byte[]{1, 2, 3, 2, 2, 1}, new byte[]{2, 2, 3, 2, 1, 1}, new byte[]{2, 2, 1, 1, 3, 2}, new byte[]{2, 2, 1, 2, 3, 1}, new byte[]{2, 1, 3, 2, 1, 2}, new byte[]{2, 2, 3, 1, 1, 2}, new byte[]{3, 1, 2, 1, 3, 1}, new byte[]{3, 1, 1, 2, 2, 2}, new byte[]{3, 2, 1, 1, 2, 2}, new byte[]{3, 2, 1, 2, 2, 1}, new byte[]{3, 1, 2, 2, 1, 2}, new byte[]{3, 2, 2, 1, 1, 2}, new byte[]{3, 2, 2, 2, 1, 1}, new byte[]{2, 1, 2, 1, 2, 3}, new byte[]{2, 1, 2, 3, 2, 1}, new byte[]{2, 3, 2, 1, 2, 1}, new byte[]{1, 1, 1, 3, 2, 3}, new byte[]{1, 3, 1, 1, 2, 3}, new byte[]{1, 3, 1, 3, 2, 1}, new byte[]{1, 1, 2, 3, 1, 3}, new byte[]{1, 3, 2, 1, 1, 3}, new byte[]{1, 3, 2, 3, 1, 1}, new byte[]{2, 1, 1, 3, 1, 3}, new byte[]{2, 3, 1, 1, 1, 3}, new byte[]{2, 3, 1, 3, 1, 1}, new byte[]{1, 1, 2, 1, 3, 3}, new byte[]{1, 1, 2, 3, 3, 1}, new byte[]{1, 3, 2, 1, 3, 1}, new byte[]{1, 1, 3, 1, 2, 3}, new byte[]{1, 1, 3, 3, 2, 1}, new byte[]{1, 3, 3, 1, 2, 1}, new byte[]{3, 1, 3, 1, 2, 1}, new byte[]{2, 1, 1, 3, 3, 1}, new byte[]{2, 3, 1, 1, 3, 1}, new byte[]{2, 1, 3, 1, 1, 3}, new byte[]{2, 1, 3, 3, 1, 1}, new byte[]{2, 1, 3, 1, 3, 1}, new byte[]{3, 1, 1, 1, 2, 3}, new byte[]{3, 1, 1, 3, 2, 1}, new byte[]{3, 3, 1, 1, 2, 1}, new byte[]{3, 1, 2, 1, 1, 3}, new byte[]{3, 1, 2, 3, 1, 1}, new byte[]{3, 3, 2, 1, 1, 1}, new byte[]{3, 1, 4, 1, 1, 1}, new byte[]{2, 2, 1, 4, 1, 1}, new byte[]{4, 3, 1, 1, 1, 1}, new byte[]{1, 1, 1, 2, 2, 4}, new byte[]{1, 1, 1, 4, 2, 2}, new byte[]{1, 2, 1, 1, 2, 4}, new byte[]{1, 2, 1, 4, 2, 1}, new byte[]{1, 4, 1, 1, 2, 2}, new byte[]{1, 4, 1, 2, 2, 1}, new byte[]{1, 1, 2, 2, 1, 4}, new byte[]{1, 1, 2, 4, 1, 2}, new byte[]{1, 2, 2, 1, 1, 4}, new byte[]{1, 2, 2, 4, 1, 1}, new byte[]{1, 4, 2, 1, 1, 2}, new byte[]{1, 4, 2, 2, 1, 1}, new byte[]{2, 4, 1, 2, 1, 1}, new byte[]{2, 2, 1, 1, 1, 4}, new byte[]{4, 1, 3, 1, 1, 1}, new byte[]{2, 4, 1, 1, 1, 2}, new byte[]{1, 3, 4, 1, 1, 1}, new byte[]{1, 1, 1, 2, 4, 2}, new byte[]{1, 2, 1, 1, 4, 2}, new byte[]{1, 2, 1, 2, 4, 1}, new byte[]{1, 1, 4, 2, 1, 2}, new byte[]{1, 2, 4, 1, 1, 2}, new byte[]{1, 2, 4, 2, 1, 1}, new byte[]{4, 1, 1, 2, 1, 2}, new byte[]{4, 2, 1, 1, 1, 2}, new byte[]{4, 2, 1, 2, 1, 1}, new byte[]{2, 1, 2, 1, 4, 1}, new byte[]{2, 1, 4, 1, 2, 1}, new byte[]{4, 1, 2, 1, 2, 1}, new byte[]{1, 1, 1, 1, 4, 3}, new byte[]{1, 1, 1, 3, 4, 1}, new byte[]{1, 3, 1, 1, 4, 1}, new byte[]{1, 1, 4, 1, 1, 3}, new byte[]{1, 1, 4, 3, 1, 1}, new byte[]{4, 1, 1, 1, 1, 3}, new byte[]{4, 1, 1, 3, 1, 1}, new byte[]{1, 1, 3, 1, 4, 1}, new byte[]{1, 1, 4, 1, 3, 1}, new byte[]{3, 1, 1, 1, 4, 1}, new byte[]{4, 1, 1, 1, 3, 1}, new byte[]{2, 1, 1, 4, 1, 2}, new byte[]{2, 1, 1, 2, 1, 4}, new byte[]{2, 1, 1, 2, 3, 2}};
    private static final byte[] BARS_STOP = {2, 3, 3, 1, 1, 1, 2};
    public static final char CODE_A = 200;
    public static final char CODE_AB_TO_C = 'c';
    public static final char CODE_AC_TO_B = 'd';
    public static final char CODE_BC_TO_A = 'e';
    public static final char CODE_C = 199;
    public static final char DEL = 195;
    public static final char FNC1 = 202;
    public static final char FNC1_INDEX = 'f';
    public static final char FNC2 = 197;
    public static final char FNC3 = 196;
    public static final char FNC4 = 200;
    public static final char SHIFT = 198;
    public static final char STARTA = 203;
    public static final char STARTB = 204;
    public static final char STARTC = 205;
    public static final char START_A = 'g';
    public static final char START_B = 'h';
    public static final char START_C = 'i';
    private static final IntHashtable ais;
    private Barcode128CodeSet codeSet = Barcode128CodeSet.AUTO;

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.Barcode128$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet;

        static {
            int[] iArr = new int[Barcode128CodeSet.values().length];
            $SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet = iArr;
            try {
                iArr[Barcode128CodeSet.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet[Barcode128CodeSet.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet[Barcode128CodeSet.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Barcode128CodeSet {
        A,
        B,
        C,
        AUTO;

        public char getStartSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet[ordinal()];
            if (i != 1) {
                return i != 3 ? Barcode128.START_B : Barcode128.START_C;
            }
            return Barcode128.START_A;
        }
    }

    static {
        IntHashtable intHashtable = new IntHashtable();
        ais = intHashtable;
        intHashtable.put(0, 20);
        intHashtable.put(1, 16);
        intHashtable.put(2, 16);
        intHashtable.put(10, -1);
        intHashtable.put(11, 9);
        intHashtable.put(12, 8);
        intHashtable.put(13, 8);
        intHashtable.put(15, 8);
        intHashtable.put(17, 8);
        intHashtable.put(20, 4);
        intHashtable.put(21, -1);
        intHashtable.put(22, -1);
        intHashtable.put(23, -1);
        intHashtable.put(240, -1);
        intHashtable.put(241, -1);
        intHashtable.put(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, -1);
        intHashtable.put(251, -1);
        intHashtable.put(252, -1);
        intHashtable.put(30, -1);
        for (int i = 3100; i < 3700; i++) {
            ais.put(i, 10);
        }
        ais.put(37, -1);
        for (int i2 = 3900; i2 < 3940; i2++) {
            ais.put(i2, -1);
        }
        IntHashtable intHashtable2 = ais;
        intHashtable2.put(400, -1);
        intHashtable2.put(401, -1);
        intHashtable2.put(TypedValues.CycleType.TYPE_VISIBILITY, 20);
        intHashtable2.put(403, -1);
        for (int i3 = 410; i3 < 416; i3++) {
            ais.put(i3, 16);
        }
        IntHashtable intHashtable3 = ais;
        intHashtable3.put(TypedValues.CycleType.TYPE_EASING, -1);
        intHashtable3.put(TypedValues.CycleType.TYPE_WAVE_SHAPE, -1);
        intHashtable3.put(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 6);
        intHashtable3.put(TypedValues.CycleType.TYPE_WAVE_PERIOD, -1);
        intHashtable3.put(TypedValues.CycleType.TYPE_WAVE_OFFSET, 6);
        intHashtable3.put(TypedValues.CycleType.TYPE_WAVE_PHASE, 6);
        intHashtable3.put(426, 6);
        intHashtable3.put(7001, 17);
        intHashtable3.put(7002, -1);
        for (int i4 = 7030; i4 < 7040; i4++) {
            ais.put(i4, -1);
        }
        IntHashtable intHashtable4 = ais;
        intHashtable4.put(8001, 18);
        intHashtable4.put(8002, -1);
        intHashtable4.put(8003, -1);
        intHashtable4.put(8004, -1);
        intHashtable4.put(8005, 10);
        intHashtable4.put(8006, 22);
        intHashtable4.put(8007, -1);
        intHashtable4.put(8008, -1);
        intHashtable4.put(8018, 22);
        intHashtable4.put(8020, -1);
        intHashtable4.put(8100, 10);
        intHashtable4.put(8101, 14);
        intHashtable4.put(8102, 6);
        for (int i5 = 90; i5 < 100; i5++) {
            ais.put(i5, -1);
        }
    }

    public Barcode128() {
        try {
            this.x = 0.8f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = 8.0f;
            this.barHeight = 8.0f * 3.0f;
            this.textAlignment = 1;
            this.codeType = 9;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static byte[] getBarsCode128Raw(String str) {
        int iIndexOf = str.indexOf(65535);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        int iCharAt = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            iCharAt += str.charAt(i) * i;
        }
        String str2 = str + ((char) (iCharAt % 103));
        byte[] bArr = new byte[((str2.length() + 1) * 6) + 7];
        int i2 = 0;
        while (i2 < str2.length()) {
            System.arraycopy(BARS[str2.charAt(i2)], 0, bArr, i2 * 6, 6);
            i2++;
        }
        System.arraycopy(BARS_STOP, 0, bArr, i2 * 6, 7);
        return bArr;
    }

    public static String getHumanReadableUCCEAN(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String strValueOf = String.valueOf(FNC1);
        while (true) {
            try {
                if (str.startsWith(strValueOf)) {
                    str = str.substring(1);
                } else {
                    int i = 2;
                    int i2 = 0;
                    while (true) {
                        if (i >= 5 || str.length() < i) {
                            i = 0;
                            break;
                        }
                        i2 = ais.get(Integer.parseInt(str.substring(0, i)));
                        if (i2 != 0) {
                            break;
                        }
                        i++;
                    }
                    if (i == 0) {
                        break;
                    }
                    stringBuffer.append('(');
                    stringBuffer.append(str.substring(0, i));
                    stringBuffer.append(')');
                    str = str.substring(i);
                    if (i2 > 0) {
                        int i3 = i2 - i;
                        if (str.length() <= i3) {
                            break;
                        }
                        stringBuffer.append(removeFNC1(str.substring(0, i3)));
                        str = str.substring(i3);
                    } else {
                        int iIndexOf = str.indexOf(202);
                        if (iIndexOf < 0) {
                            break;
                        }
                        stringBuffer.append(str.substring(0, iIndexOf));
                        str = str.substring(iIndexOf + 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
        stringBuffer.append(removeFNC1(str));
        return stringBuffer.toString();
    }

    public static String getPackedRawDigits(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder("");
        int i3 = i;
        while (i2 > 0) {
            if (str.charAt(i3) == 202) {
                sb.append(FNC1_INDEX);
                i3++;
            } else {
                i2 -= 2;
                int i4 = i3 + 1;
                int iCharAt = str.charAt(i3) - '0';
                i3 += 2;
                sb.append((char) ((iCharAt * 10) + (str.charAt(i4) - '0')));
            }
        }
        return ((char) (i3 - i)) + sb.toString();
    }

    public static String getRawText(String str, boolean z, Barcode128CodeSet barcode128CodeSet) {
        int iCharAt;
        String str2;
        char c;
        int i;
        int length = str.length();
        if (length == 0) {
            String str3 = "" + barcode128CodeSet.getStartSymbol();
            if (!z) {
                return str3;
            }
            return str3 + FNC1_INDEX;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt > 127 && cCharAt != 202) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("there.are.illegal.characters.for.barcode.128.in.1", str));
            }
        }
        char cCharAt2 = str.charAt(0);
        Barcode128CodeSet barcode128CodeSet2 = Barcode128CodeSet.AUTO;
        if ((barcode128CodeSet == barcode128CodeSet2 || barcode128CodeSet == Barcode128CodeSet.C) && isNextDigits(str, 0, 2)) {
            String str4 = "" + START_C;
            if (z) {
                str4 = str4 + FNC1_INDEX;
            }
            String packedRawDigits = getPackedRawDigits(str, 0, 2);
            iCharAt = packedRawDigits.charAt(0);
            str2 = str4 + packedRawDigits.substring(1);
            c = START_C;
        } else {
            if (cCharAt2 < ' ') {
                String str5 = "" + START_A;
                if (z) {
                    str5 = str5 + FNC1_INDEX;
                }
                str2 = str5 + ((char) (cCharAt2 + '@'));
                c = START_A;
            } else {
                String str6 = "" + START_B;
                if (z) {
                    str6 = str6 + FNC1_INDEX;
                }
                str2 = cCharAt2 == 202 ? str6 + FNC1_INDEX : str6 + ((char) (cCharAt2 - ' '));
                c = START_B;
            }
            iCharAt = 1;
        }
        if (barcode128CodeSet != barcode128CodeSet2 && c != barcode128CodeSet.getStartSymbol()) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("there.are.illegal.characters.for.barcode.128.in.1", str));
        }
        while (iCharAt < length) {
            switch (c) {
                case 'g':
                    if (barcode128CodeSet == Barcode128CodeSet.AUTO && isNextDigits(str, iCharAt, 4)) {
                        String str7 = str2 + CODE_AB_TO_C;
                        String packedRawDigits2 = getPackedRawDigits(str, iCharAt, 4);
                        iCharAt += packedRawDigits2.charAt(0);
                        str2 = str7 + packedRawDigits2.substring(1);
                        c = START_C;
                    } else {
                        int i3 = iCharAt + 1;
                        char cCharAt3 = str.charAt(iCharAt);
                        if (cCharAt3 == 202) {
                            str2 = str2 + FNC1_INDEX;
                        } else if (cCharAt3 > '_') {
                            str2 = (str2 + CODE_AC_TO_B) + ((char) (cCharAt3 - ' '));
                            iCharAt = i3;
                            c = START_B;
                            break;
                        } else if (cCharAt3 < ' ') {
                            str2 = str2 + ((char) (cCharAt3 + '@'));
                        } else {
                            str2 = str2 + ((char) (cCharAt3 - ' '));
                        }
                        iCharAt = i3;
                    }
                    break;
                case 'h':
                    if (barcode128CodeSet == Barcode128CodeSet.AUTO && isNextDigits(str, iCharAt, 4)) {
                        String str8 = str2 + CODE_AB_TO_C;
                        String packedRawDigits3 = getPackedRawDigits(str, iCharAt, 4);
                        iCharAt += packedRawDigits3.charAt(0);
                        str2 = str8 + packedRawDigits3.substring(1);
                        c = START_C;
                    } else {
                        i = iCharAt + 1;
                        char cCharAt4 = str.charAt(iCharAt);
                        if (cCharAt4 == 202) {
                            str2 = str2 + FNC1_INDEX;
                        } else if (cCharAt4 < ' ') {
                            str2 = (str2 + CODE_BC_TO_A) + ((char) (cCharAt4 + '@'));
                            iCharAt = i;
                            c = START_A;
                        } else {
                            str2 = str2 + ((char) (cCharAt4 - ' '));
                        }
                        iCharAt = i;
                    }
                    break;
                case 'i':
                    if (!isNextDigits(str, iCharAt, 2)) {
                        i = iCharAt + 1;
                        char cCharAt5 = str.charAt(iCharAt);
                        if (cCharAt5 == 202) {
                            str2 = str2 + FNC1_INDEX;
                            iCharAt = i;
                        } else if (cCharAt5 < ' ') {
                            str2 = (str2 + CODE_BC_TO_A) + ((char) (cCharAt5 + '@'));
                            iCharAt = i;
                            c = START_A;
                        } else {
                            str2 = (str2 + CODE_AC_TO_B) + ((char) (cCharAt5 - ' '));
                            iCharAt = i;
                            c = START_B;
                        }
                        break;
                    } else {
                        String packedRawDigits4 = getPackedRawDigits(str, iCharAt, 2);
                        iCharAt += packedRawDigits4.charAt(0);
                        str2 = str2 + packedRawDigits4.substring(1);
                        break;
                    }
                default:
                    break;
            }
            if (barcode128CodeSet != Barcode128CodeSet.AUTO && c != barcode128CodeSet.getStartSymbol()) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("there.are.illegal.characters.for.barcode.128.in.1", str));
            }
        }
        return str2;
    }

    public static boolean isNextDigits(String str, int i, int i2) {
        int length = str.length();
        while (i < length && i2 > 0) {
            if (str.charAt(i) != 202) {
                int iMin = Math.min(2, i2);
                if (i + iMin <= length) {
                    while (true) {
                        int i3 = iMin - 1;
                        if (iMin <= 0) {
                            break;
                        }
                        int i4 = i + 1;
                        char cCharAt = str.charAt(i);
                        if (cCharAt < '0' || cCharAt > '9') {
                            return false;
                        }
                        i2--;
                        i = i4;
                        iMin = i3;
                    }
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return i2 == 0;
    }

    public static String removeFNC1(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= ' ' && cCharAt <= '~') {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        String rawText;
        String humanReadableUCCEAN;
        BaseFont baseFont = this.font;
        float widthPoint = 0.0f;
        if (baseFont != null) {
            float f2 = this.baseline;
            float fontDescriptor = f2 > 0.0f ? f2 - baseFont.getFontDescriptor(3, this.size) : (-f2) + this.size;
            int i = this.codeType;
            if (i == 11) {
                int iIndexOf = this.code.indexOf(65535);
                humanReadableUCCEAN = iIndexOf < 0 ? "" : this.code.substring(iIndexOf + 1);
            } else {
                humanReadableUCCEAN = i == 10 ? getHumanReadableUCCEAN(this.code) : removeFNC1(this.code);
            }
            BaseFont baseFont2 = this.font;
            String str = this.altText;
            if (str != null) {
                humanReadableUCCEAN = str;
            }
            float f3 = fontDescriptor;
            widthPoint = baseFont2.getWidthPoint(humanReadableUCCEAN, this.size);
            f = f3;
        } else {
            f = 0.0f;
        }
        int i2 = this.codeType;
        if (i2 == 11) {
            int iIndexOf2 = this.code.indexOf(65535);
            rawText = iIndexOf2 >= 0 ? this.code.substring(0, iIndexOf2) : this.code;
        } else {
            rawText = getRawText(this.code, i2 == 10, this.codeSet);
        }
        float length = (rawText.length() + 2) * 11;
        float f4 = this.x;
        return new Rectangle(Math.max((length * f4) + (f4 * 2.0f), widthPoint), this.barHeight + f);
    }

    public Barcode128CodeSet getCodeSet() {
        return this.codeSet;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0096  */
    /* JADX WARN: Code duplicated, block: B:47:0x009c  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00af  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce A[SYNTHETIC] */
    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        String humanReadableUCCEAN;
        float widthPoint;
        String rawText;
        float f;
        float f2;
        BaseFont baseFont;
        float f3;
        byte[] barsCode128Raw;
        float f4;
        float f5;
        int i = this.codeType;
        boolean z = true;
        if (i == 11) {
            int iIndexOf = this.code.indexOf(65535);
            humanReadableUCCEAN = iIndexOf < 0 ? "" : this.code.substring(iIndexOf + 1);
        } else {
            humanReadableUCCEAN = i == 10 ? getHumanReadableUCCEAN(this.code) : removeFNC1(this.code);
        }
        BaseFont baseFont2 = this.font;
        float f6 = 0.0f;
        if (baseFont2 != null) {
            String str = this.altText;
            if (str != null) {
                humanReadableUCCEAN = str;
            }
            widthPoint = baseFont2.getWidthPoint(humanReadableUCCEAN, this.size);
        } else {
            widthPoint = 0.0f;
        }
        int i2 = this.codeType;
        if (i2 == 11) {
            int iIndexOf2 = this.code.indexOf(65535);
            rawText = iIndexOf2 >= 0 ? this.code.substring(0, iIndexOf2) : this.code;
        } else {
            rawText = getRawText(this.code, i2 == 10, this.codeSet);
        }
        float length = (rawText.length() + 2) * 11;
        float f7 = this.x;
        float f8 = (length * f7) + (f7 * 2.0f);
        int i3 = this.textAlignment;
        if (i3 != 0) {
            if (i3 != 2) {
                if (widthPoint > f8) {
                    f2 = (widthPoint - f8) / 2.0f;
                    f = 0.0f;
                } else {
                    f = (f8 - widthPoint) / 2.0f;
                }
            } else if (widthPoint > f8) {
                f2 = widthPoint - f8;
                f = 0.0f;
            } else {
                f = f8 - widthPoint;
            }
            baseFont = this.font;
            if (baseFont != null) {
                f5 = this.baseline;
                if (f5 <= 0.0f) {
                    f3 = this.barHeight - f5;
                } else {
                    float f9 = -baseFont.getFontDescriptor(3, this.size);
                    f6 = this.baseline + f9;
                    f3 = f9;
                }
            } else {
                f3 = 0.0f;
            }
            barsCode128Raw = getBarsCode128Raw(rawText);
            if (baseColor != null) {
                pdfContentByte.setColorFill(baseColor);
            }
            for (byte b : barsCode128Raw) {
                f4 = b * this.x;
                if (z) {
                    pdfContentByte.rectangle(f2, f6, f4 - this.inkSpreading, this.barHeight);
                }
                z = !z;
                f2 += f4;
            }
            pdfContentByte.fill();
            if (this.font != null) {
                if (baseColor2 != null) {
                    pdfContentByte.setColorFill(baseColor2);
                }
                pdfContentByte.beginText();
                pdfContentByte.setFontAndSize(this.font, this.size);
                pdfContentByte.setTextMatrix(f, f3);
                pdfContentByte.showText(humanReadableUCCEAN);
                pdfContentByte.endText();
            }
            return getBarcodeSize();
        }
        f = 0.0f;
        f2 = 0.0f;
        baseFont = this.font;
        if (baseFont != null) {
            f5 = this.baseline;
            if (f5 <= 0.0f) {
                f3 = this.barHeight - f5;
            } else {
                float f10 = -baseFont.getFontDescriptor(3, this.size);
                f6 = this.baseline + f10;
                f3 = f10;
            }
        } else {
            f3 = 0.0f;
        }
        barsCode128Raw = getBarsCode128Raw(rawText);
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        while (i < barsCode128Raw.length) {
            f4 = b * this.x;
            if (z) {
                pdfContentByte.rectangle(f2, f6, f4 - this.inkSpreading, this.barHeight);
            }
            z = !z;
            f2 += f4;
        }
        pdfContentByte.fill();
        if (this.font != null) {
            if (baseColor2 != null) {
                pdfContentByte.setColorFill(baseColor2);
            }
            pdfContentByte.beginText();
            pdfContentByte.setFontAndSize(this.font, this.size);
            pdfContentByte.setTextMatrix(f, f3);
            pdfContentByte.showText(humanReadableUCCEAN);
            pdfContentByte.endText();
        }
        return getBarcodeSize();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public void setCode(String str) {
        if (getCodeType() != 10 || !str.startsWith("(")) {
            super.setCode(str);
            return;
        }
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i >= 0) {
            int iIndexOf = str.indexOf(41, i);
            if (iIndexOf < 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("badly.formed.ucc.string.1", str));
            }
            String strSubstring = str.substring(i + 1, iIndexOf);
            if (strSubstring.length() < 2) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("ai.too.short.1", strSubstring));
            }
            int i2 = Integer.parseInt(strSubstring);
            int i3 = ais.get(i2);
            if (i3 == 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("ai.not.found.1", strSubstring));
            }
            String strValueOf = String.valueOf(i2);
            if (strValueOf.length() == 1) {
                strValueOf = "0" + strValueOf;
            }
            int iIndexOf2 = str.indexOf(40, iIndexOf);
            int length = iIndexOf2 < 0 ? str.length() : iIndexOf2;
            sb.append(strValueOf);
            sb.append(str.substring(iIndexOf + 1, length));
            if (i3 < 0) {
                if (iIndexOf2 >= 0) {
                    sb.append(FNC1);
                }
            } else if (((length - iIndexOf) - 1) + strValueOf.length() != i3) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.ai.length.1", strValueOf));
            }
            i = iIndexOf2;
        }
        super.setCode(sb.toString());
    }

    public void setCodeSet(Barcode128CodeSet barcode128CodeSet) {
        this.codeSet = barcode128CodeSet;
    }

    public static String getRawText(String str, boolean z) {
        return getRawText(str, z, Barcode128CodeSet.AUTO);
    }
}
