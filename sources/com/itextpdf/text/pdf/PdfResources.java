package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
class PdfResources extends PdfDictionary {
    public void add(PdfName pdfName, PdfDictionary pdfDictionary) {
        if (pdfDictionary.size() == 0) {
            return;
        }
        PdfDictionary asDict = getAsDict(pdfName);
        if (asDict == null) {
            put(pdfName, pdfDictionary);
        } else {
            asDict.putAll(pdfDictionary);
        }
    }
}
