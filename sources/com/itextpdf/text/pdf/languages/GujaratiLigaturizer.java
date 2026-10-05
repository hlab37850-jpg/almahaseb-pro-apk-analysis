package com.itextpdf.text.pdf.languages;

/* JADX INFO: loaded from: classes3.dex */
public class GujaratiLigaturizer extends IndicLigaturizer {
    public static final char GUJR_HALANTA = 2765;
    public static final char GUJR_LETTER_A = 2693;
    public static final char GUJR_LETTER_AU = 2708;
    public static final char GUJR_LETTER_HA = 2745;
    public static final char GUJR_LETTER_KA = 2709;
    public static final char GUJR_MATRA_AA = 2750;
    public static final char GUJR_MATRA_AI = 2760;
    public static final char GUJR_MATRA_E = 2759;
    public static final char GUJR_MATRA_HLR = 2786;
    public static final char GUJR_MATRA_HLRR = 2787;
    public static final char GUJR_MATRA_I = 2751;

    public GujaratiLigaturizer() {
        this.langTable = new char[]{GUJR_MATRA_AA, GUJR_MATRA_I, GUJR_MATRA_E, GUJR_MATRA_AI, GUJR_MATRA_HLR, GUJR_MATRA_HLRR, GUJR_LETTER_A, GUJR_LETTER_AU, GUJR_LETTER_KA, GUJR_LETTER_HA, GUJR_HALANTA};
    }
}
