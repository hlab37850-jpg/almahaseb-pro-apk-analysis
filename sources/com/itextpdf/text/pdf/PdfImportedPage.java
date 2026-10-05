package com.itextpdf.text.pdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

/* JADX INFO: loaded from: classes3.dex */
public class PdfImportedPage extends PdfTemplate {
    int pageNumber;
    PdfReaderInstance readerInstance;
    int rotation;
    protected boolean toCopy = true;

    public PdfImportedPage(PdfReaderInstance pdfReaderInstance, PdfWriter pdfWriter, int i) {
        this.readerInstance = pdfReaderInstance;
        this.pageNumber = i;
        this.writer = pdfWriter;
        this.rotation = pdfReaderInstance.getReader().getPageRotation(i);
        Rectangle pageSize = pdfReaderInstance.getReader().getPageSize(i);
        this.bBox = pageSize;
        setMatrix(1.0f, 0.0f, 0.0f, 1.0f, -pageSize.getLeft(), -this.bBox.getBottom());
        this.type = 2;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) {
        throwError();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6) {
        throwError();
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate, com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        throwError();
        return null;
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate
    public PdfStream getFormXObject(int i) {
        return this.readerInstance.getFormXObject(this.pageNumber, i);
    }

    public PdfImportedPage getFromReader() {
        return this;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public PdfReaderInstance getPdfReaderInstance() {
        return this.readerInstance;
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate
    public PdfObject getResources() {
        return this.readerInstance.getResources(this.pageNumber);
    }

    public int getRotation() {
        return this.rotation;
    }

    public boolean isToCopy() {
        return this.toCopy;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        throwError();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        throwError();
    }

    public void setCopied() {
        this.toCopy = false;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setFontAndSize(BaseFont baseFont, float f) {
        throwError();
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate
    public void setGroup(PdfTransparencyGroup pdfTransparencyGroup) {
        throwError();
    }

    public void throwError() {
        throw new RuntimeException(MessageLocalization.getComposedMessage("content.can.not.be.added.to.a.pdfimportedpage", new Object[0]));
    }
}
