package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPSXObject extends PdfTemplate {
    public PdfPSXObject() {
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate, com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        PdfPSXObject pdfPSXObject = new PdfPSXObject();
        pdfPSXObject.writer = this.writer;
        pdfPSXObject.pdf = this.pdf;
        pdfPSXObject.thisReference = this.thisReference;
        pdfPSXObject.pageResources = this.pageResources;
        pdfPSXObject.separator = this.separator;
        return pdfPSXObject;
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate
    public PdfStream getFormXObject(int i) {
        PdfStream pdfStream = new PdfStream(this.content.toByteArray());
        pdfStream.put(PdfName.TYPE, PdfName.XOBJECT);
        pdfStream.put(PdfName.SUBTYPE, PdfName.PS);
        pdfStream.flateCompress(i);
        return pdfStream;
    }

    public PdfPSXObject(PdfWriter pdfWriter) {
        super(pdfWriter);
    }
}
