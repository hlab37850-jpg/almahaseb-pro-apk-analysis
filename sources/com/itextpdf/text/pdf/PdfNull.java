package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
public class PdfNull extends PdfObject {
    private static final String CONTENT = "null";
    public static final PdfNull PDFNULL = new PdfNull();

    public PdfNull() {
        super(8, CONTENT);
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        return CONTENT;
    }
}
