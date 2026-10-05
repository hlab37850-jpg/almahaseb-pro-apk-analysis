package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPattern extends PdfStream {
    public PdfPattern(PdfPatternPainter pdfPatternPainter) {
        this(pdfPatternPainter, -1);
    }

    public PdfPattern(PdfPatternPainter pdfPatternPainter, int i) {
        PdfNumber pdfNumber = new PdfNumber(1);
        PdfArray matrix = pdfPatternPainter.getMatrix();
        if (matrix != null) {
            put(PdfName.MATRIX, matrix);
        }
        put(PdfName.TYPE, PdfName.PATTERN);
        put(PdfName.BBOX, new PdfRectangle(pdfPatternPainter.getBoundingBox()));
        put(PdfName.RESOURCES, pdfPatternPainter.getResources());
        put(PdfName.TILINGTYPE, pdfNumber);
        put(PdfName.PATTERNTYPE, pdfNumber);
        if (pdfPatternPainter.isStencil()) {
            put(PdfName.PAINTTYPE, new PdfNumber(2));
        } else {
            put(PdfName.PAINTTYPE, pdfNumber);
        }
        put(PdfName.XSTEP, new PdfNumber(pdfPatternPainter.getXStep()));
        put(PdfName.YSTEP, new PdfNumber(pdfPatternPainter.getYStep()));
        byte[] pdf = pdfPatternPainter.toPdf(null);
        this.bytes = pdf;
        put(PdfName.LENGTH, new PdfNumber(pdf.length));
        try {
            flateCompress(i);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
