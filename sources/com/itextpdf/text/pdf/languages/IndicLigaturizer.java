package com.itextpdf.text.pdf.languages;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IndicLigaturizer implements LanguageProcessor {
    public static final int HALANTA = 10;
    public static final int LETTER_A = 6;
    public static final int LETTER_AU = 7;
    public static final int LETTER_HA = 9;
    public static final int LETTER_KA = 8;
    public static final int MATRA_AA = 0;
    public static final int MATRA_AI = 3;
    public static final int MATRA_E = 2;
    public static final int MATRA_HLR = 4;
    public static final int MATRA_HLRR = 5;
    public static final int MATRA_I = 1;
    protected char[] langTable;

    private static void swap(StringBuilder sb, int i, int i2) {
        char cCharAt = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(i2));
        sb.setCharAt(i2, cCharAt);
    }

    public boolean IsSwaraLetter(char c) {
        char[] cArr = this.langTable;
        return c >= cArr[6] && c <= cArr[7];
    }

    public boolean IsSwaraMatra(char c) {
        char[] cArr = this.langTable;
        return (c >= cArr[0] && c <= cArr[3]) || c == cArr[4] || c == cArr[5];
    }

    public boolean IsVyanjana(char c) {
        char[] cArr = this.langTable;
        return c >= cArr[8] && c <= cArr[9];
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public boolean isRTL() {
        return false;
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public String process(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (IsVyanjana(cCharAt) || IsSwaraLetter(cCharAt)) {
                sb.append(cCharAt);
            } else if (IsSwaraMatra(cCharAt)) {
                int length = sb.length() - 1;
                if (length >= 0) {
                    if (sb.charAt(length) == this.langTable[10]) {
                        sb.deleteCharAt(length);
                    }
                    sb.append(cCharAt);
                    int length2 = sb.length() - 2;
                    if (cCharAt == this.langTable[1] && length2 >= 0) {
                        swap(sb, length2, sb.length() - 1);
                    }
                } else {
                    sb.append(cCharAt);
                }
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}
