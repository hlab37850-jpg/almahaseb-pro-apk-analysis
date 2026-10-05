package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPTableHeader extends PdfPTableBody {
    protected PdfName role = PdfName.THEAD;

    @Override // com.itextpdf.text.pdf.PdfPTableBody, com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    @Override // com.itextpdf.text.pdf.PdfPTableBody, com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }
}
