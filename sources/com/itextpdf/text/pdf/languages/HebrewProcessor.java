package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.BidiLine;

/* JADX INFO: loaded from: classes3.dex */
public class HebrewProcessor implements LanguageProcessor {
    protected int runDirection;

    public HebrewProcessor() {
        this.runDirection = 3;
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public boolean isRTL() {
        return true;
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public String process(String str) {
        return BidiLine.processLTR(str, this.runDirection, 0);
    }

    public HebrewProcessor(int i) {
        this.runDirection = i;
    }
}
