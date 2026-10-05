package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;

/* JADX INFO: loaded from: classes3.dex */
public class PdfSignatureBuildProperties extends PdfDictionary {
    private PdfSignatureAppDictionary getPdfSignatureAppProperty() {
        PdfName pdfName = PdfName.APP;
        PdfSignatureAppDictionary pdfSignatureAppDictionary = (PdfSignatureAppDictionary) getAsDict(pdfName);
        if (pdfSignatureAppDictionary != null) {
            return pdfSignatureAppDictionary;
        }
        PdfSignatureAppDictionary pdfSignatureAppDictionary2 = new PdfSignatureAppDictionary();
        put(pdfName, pdfSignatureAppDictionary2);
        return pdfSignatureAppDictionary2;
    }

    public void setSignatureCreator(String str) {
        getPdfSignatureAppProperty().setSignatureCreator(str);
    }
}
