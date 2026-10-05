package com.itextpdf.text.pdf.fonts.otf;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public enum Language {
    BENGALI("beng", "bng2");

    private final List<String> codes;

    Language(String... strArr) {
        this.codes = Arrays.asList(strArr);
    }

    public boolean isSupported(String str) {
        return this.codes.contains(str);
    }
}
