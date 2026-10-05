package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes3.dex */
public class TextMarginFinder implements RenderListener {
    private Rectangle2D.Float textRectangle = null;

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
    }

    public float getHeight() {
        return this.textRectangle.height;
    }

    public float getLlx() {
        return this.textRectangle.x;
    }

    public float getLly() {
        return this.textRectangle.y;
    }

    public float getUrx() {
        Rectangle2D.Float r0 = this.textRectangle;
        return r0.x + r0.width;
    }

    public float getUry() {
        Rectangle2D.Float r0 = this.textRectangle;
        return r0.y + r0.height;
    }

    public float getWidth() {
        return this.textRectangle.width;
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        Rectangle2D.Float r0 = this.textRectangle;
        if (r0 == null) {
            this.textRectangle = textRenderInfo.getDescentLine().getBoundingRectange();
        } else {
            r0.add(textRenderInfo.getDescentLine().getBoundingRectange());
        }
        this.textRectangle.add(textRenderInfo.getAscentLine().getBoundingRectange());
    }
}
