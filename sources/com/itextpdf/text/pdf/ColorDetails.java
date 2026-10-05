package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
class ColorDetails {
    ICachedColorSpace colorSpace;
    PdfName colorSpaceName;
    PdfIndirectReference indirectReference;

    public ColorDetails(PdfName pdfName, PdfIndirectReference pdfIndirectReference, ICachedColorSpace iCachedColorSpace) {
        this.colorSpaceName = pdfName;
        this.indirectReference = pdfIndirectReference;
        this.colorSpace = iCachedColorSpace;
    }

    public PdfName getColorSpaceName() {
        return this.colorSpaceName;
    }

    public PdfIndirectReference getIndirectReference() {
        return this.indirectReference;
    }

    public PdfObject getPdfObject(PdfWriter pdfWriter) {
        return this.colorSpace.getPdfObject(pdfWriter);
    }
}
