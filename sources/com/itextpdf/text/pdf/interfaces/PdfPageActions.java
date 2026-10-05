package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfTransition;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfPageActions {
    void setDuration(int i);

    void setPageAction(PdfName pdfName, PdfAction pdfAction);

    void setTransition(PdfTransition pdfTransition);
}
