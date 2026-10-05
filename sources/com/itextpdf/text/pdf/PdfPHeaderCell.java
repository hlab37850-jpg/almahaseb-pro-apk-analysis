package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPHeaderCell extends PdfPCell {
    public static final int BOTH = 3;
    public static final int COLUMN = 2;
    public static final int NONE = 0;
    public static final int ROW = 1;
    protected String name;
    protected int scope;

    public PdfPHeaderCell() {
        this.scope = 0;
        this.name = null;
        this.role = PdfName.TH;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.itextpdf.text.pdf.PdfPCell, com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    public int getScope() {
        return this.scope;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.itextpdf.text.pdf.PdfPCell, com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    public void setScope(int i) {
        this.scope = i;
    }

    public PdfPHeaderCell(PdfPHeaderCell pdfPHeaderCell) {
        super(pdfPHeaderCell);
        this.scope = 0;
        this.name = null;
        this.role = pdfPHeaderCell.role;
        this.scope = pdfPHeaderCell.scope;
        this.name = pdfPHeaderCell.getName();
    }
}
