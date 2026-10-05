package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ExternalBlankSignatureContainer implements ExternalSignatureContainer {
    private PdfDictionary sigDic;

    public ExternalBlankSignatureContainer(PdfDictionary pdfDictionary) {
        this.sigDic = pdfDictionary;
    }

    @Override // com.itextpdf.text.pdf.security.ExternalSignatureContainer
    public void modifySigningDictionary(PdfDictionary pdfDictionary) {
        pdfDictionary.putAll(this.sigDic);
    }

    @Override // com.itextpdf.text.pdf.security.ExternalSignatureContainer
    public byte[] sign(InputStream inputStream) {
        return new byte[0];
    }

    public ExternalBlankSignatureContainer(PdfName pdfName, PdfName pdfName2) {
        PdfDictionary pdfDictionary = new PdfDictionary();
        this.sigDic = pdfDictionary;
        pdfDictionary.put(PdfName.FILTER, pdfName);
        this.sigDic.put(PdfName.SUBFILTER, pdfName2);
    }
}
