package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
public interface HyphenationEvent {
    String getHyphenSymbol();

    String getHyphenatedWordPost();

    String getHyphenatedWordPre(String str, BaseFont baseFont, float f, float f2);
}
