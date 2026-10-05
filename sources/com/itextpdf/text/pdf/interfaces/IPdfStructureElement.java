package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IPdfStructureElement {
    PdfObject getAttribute(PdfName pdfName);

    void setAttribute(PdfName pdfName, PdfObject pdfObject);
}
