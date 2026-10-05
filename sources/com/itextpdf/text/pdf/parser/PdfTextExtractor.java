package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfTextExtractor {
    private PdfTextExtractor() {
    }

    public static String getTextFromPage(PdfReader pdfReader, int i, TextExtractionStrategy textExtractionStrategy, Map<String, ContentOperator> map) {
        return ((TextExtractionStrategy) new PdfReaderContentParser(pdfReader).processContent(i, textExtractionStrategy, map)).getResultantText();
    }

    public static String getTextFromPage(PdfReader pdfReader, int i, TextExtractionStrategy textExtractionStrategy) {
        return getTextFromPage(pdfReader, i, textExtractionStrategy, new HashMap());
    }

    public static String getTextFromPage(PdfReader pdfReader, int i) {
        return getTextFromPage(pdfReader, i, new LocationTextExtractionStrategy());
    }
}
