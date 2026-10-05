package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
public class PdfRendition extends PdfDictionary {
    public PdfRendition(String str, PdfFileSpecification pdfFileSpecification, String str2) {
        put(PdfName.S, new PdfName("MR"));
        put(PdfName.N, new PdfString("Rendition for " + str));
        put(PdfName.C, new PdfMediaClipData(str, pdfFileSpecification, str2));
    }
}
