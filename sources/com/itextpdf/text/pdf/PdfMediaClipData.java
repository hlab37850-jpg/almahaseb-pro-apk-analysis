package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
public class PdfMediaClipData extends PdfDictionary {
    public PdfMediaClipData(String str, PdfFileSpecification pdfFileSpecification, String str2) {
        put(PdfName.TYPE, new PdfName("MediaClip"));
        put(PdfName.S, new PdfName("MCD"));
        put(PdfName.N, new PdfString("Media clip for " + str));
        put(new PdfName("CT"), new PdfString(str2));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(new PdfName("TF"), new PdfString("TEMPACCESS"));
        put(new PdfName("P"), pdfDictionary);
        put(PdfName.D, pdfFileSpecification.getReference());
    }
}
