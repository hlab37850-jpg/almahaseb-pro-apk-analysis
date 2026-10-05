package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfReader;

/* JADX INFO: loaded from: classes3.dex */
public class ImageRenderInfo {
    private final PdfDictionary colorSpaceDictionary;
    private final GraphicsState gs;
    private PdfImageObject imageObject;
    private final InlineImageInfo inlineImageInfo;
    private final PdfIndirectReference ref;

    private ImageRenderInfo(GraphicsState graphicsState, PdfIndirectReference pdfIndirectReference, PdfDictionary pdfDictionary) {
        this.imageObject = null;
        this.gs = graphicsState;
        this.ref = pdfIndirectReference;
        this.inlineImageInfo = null;
        this.colorSpaceDictionary = pdfDictionary;
    }

    public static ImageRenderInfo createForEmbeddedImage(GraphicsState graphicsState, InlineImageInfo inlineImageInfo, PdfDictionary pdfDictionary) {
        return new ImageRenderInfo(graphicsState, inlineImageInfo, pdfDictionary);
    }

    public static ImageRenderInfo createForXObject(GraphicsState graphicsState, PdfIndirectReference pdfIndirectReference, PdfDictionary pdfDictionary) {
        return new ImageRenderInfo(graphicsState, pdfIndirectReference, pdfDictionary);
    }

    private void prepareImageObject() {
        if (this.imageObject != null) {
            return;
        }
        PdfIndirectReference pdfIndirectReference = this.ref;
        if (pdfIndirectReference != null) {
            this.imageObject = new PdfImageObject((PRStream) PdfReader.getPdfObject(pdfIndirectReference), this.colorSpaceDictionary);
            return;
        }
        InlineImageInfo inlineImageInfo = this.inlineImageInfo;
        if (inlineImageInfo != null) {
            this.imageObject = new PdfImageObject(inlineImageInfo.getImageDictionary(), this.inlineImageInfo.getSamples(), this.colorSpaceDictionary);
        }
    }

    public float getArea() {
        return this.gs.ctm.getDeterminant();
    }

    public BaseColor getCurrentFillColor() {
        return this.gs.fillColor;
    }

    public PdfImageObject getImage() {
        prepareImageObject();
        return this.imageObject;
    }

    public Matrix getImageCTM() {
        return this.gs.ctm;
    }

    public PdfIndirectReference getRef() {
        return this.ref;
    }

    public Vector getStartPoint() {
        return new Vector(0.0f, 0.0f, 1.0f).cross(this.gs.ctm);
    }

    private ImageRenderInfo(GraphicsState graphicsState, InlineImageInfo inlineImageInfo, PdfDictionary pdfDictionary) {
        this.imageObject = null;
        this.gs = graphicsState;
        this.ref = null;
        this.inlineImageInfo = inlineImageInfo;
        this.colorSpaceDictionary = pdfDictionary;
    }
}
