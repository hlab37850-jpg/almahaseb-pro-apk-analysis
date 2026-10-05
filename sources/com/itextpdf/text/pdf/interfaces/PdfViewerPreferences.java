package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfViewerPreferences {
    void addViewerPreference(PdfName pdfName, PdfObject pdfObject);

    void setViewerPreferences(int i);
}
