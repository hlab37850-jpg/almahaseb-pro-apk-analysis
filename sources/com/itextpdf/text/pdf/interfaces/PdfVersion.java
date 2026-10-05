package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfName;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfVersion {
    void addDeveloperExtension(PdfDeveloperExtension pdfDeveloperExtension);

    void setAtLeastPdfVersion(char c);

    void setPdfVersion(char c);

    void setPdfVersion(PdfName pdfName);
}
