package com.itextpdf.text.pdf.languages;

/* JADX INFO: loaded from: classes3.dex */
public class DevanagariLigaturizer extends IndicLigaturizer {
    public static final char DEVA_HALANTA = 2381;
    public static final char DEVA_LETTER_A = 2309;
    public static final char DEVA_LETTER_AU = 2324;
    public static final char DEVA_LETTER_HA = 2361;
    public static final char DEVA_LETTER_KA = 2325;
    public static final char DEVA_MATRA_AA = 2366;
    public static final char DEVA_MATRA_AI = 2376;
    public static final char DEVA_MATRA_E = 2375;
    public static final char DEVA_MATRA_HLR = 2402;
    public static final char DEVA_MATRA_HLRR = 2403;
    public static final char DEVA_MATRA_I = 2367;

    public DevanagariLigaturizer() {
        this.langTable = new char[]{DEVA_MATRA_AA, DEVA_MATRA_I, DEVA_MATRA_E, DEVA_MATRA_AI, DEVA_MATRA_HLR, DEVA_MATRA_HLRR, DEVA_LETTER_A, DEVA_LETTER_AU, DEVA_LETTER_KA, DEVA_LETTER_HA, DEVA_HALANTA};
    }
}
