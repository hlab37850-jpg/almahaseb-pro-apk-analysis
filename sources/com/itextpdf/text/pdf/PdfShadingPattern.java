package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

/* JADX INFO: loaded from: classes3.dex */
public class PdfShadingPattern extends PdfDictionary {
    protected float[] matrix = {1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    protected PdfName patternName;
    protected PdfIndirectReference patternReference;
    protected PdfShading shading;
    protected PdfWriter writer;

    public PdfShadingPattern(PdfShading pdfShading) {
        this.writer = pdfShading.getWriter();
        put(PdfName.PATTERNTYPE, new PdfNumber(2));
        this.shading = pdfShading;
    }

    public void addToBody() {
        put(PdfName.SHADING, getShadingReference());
        put(PdfName.MATRIX, new PdfArray(this.matrix));
        this.writer.addToBody(this, getPatternReference());
    }

    public ColorDetails getColorDetails() {
        return this.shading.getColorDetails();
    }

    public float[] getMatrix() {
        return this.matrix;
    }

    public PdfName getPatternName() {
        return this.patternName;
    }

    public PdfIndirectReference getPatternReference() {
        if (this.patternReference == null) {
            this.patternReference = this.writer.getPdfIndirectReference();
        }
        return this.patternReference;
    }

    public PdfShading getShading() {
        return this.shading;
    }

    public PdfName getShadingName() {
        return this.shading.getShadingName();
    }

    public PdfIndirectReference getShadingReference() {
        return this.shading.getShadingReference();
    }

    public void setMatrix(float[] fArr) {
        if (fArr.length != 6) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("the.matrix.size.must.be.6", new Object[0]));
        }
        this.matrix = fArr;
    }

    public void setName(int i) {
        this.patternName = new PdfName("P" + i);
    }
}
