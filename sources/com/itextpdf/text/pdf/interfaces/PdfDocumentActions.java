package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfName;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfDocumentActions {
    void setAdditionalAction(PdfName pdfName, PdfAction pdfAction);

    void setOpenAction(PdfAction pdfAction);

    void setOpenAction(String str);
}
