package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.CMapAwareDocumentFont;
import com.itextpdf.text.pdf.PdfName;

/* JADX INFO: loaded from: classes3.dex */
public class GraphicsState {
    float characterSpacing;
    PdfName colorSpaceFill;
    PdfName colorSpaceStroke;
    Matrix ctm;
    BaseColor fillColor;
    CMapAwareDocumentFont font;
    float fontSize;
    float horizontalScaling;
    boolean knockout;
    float leading;
    private int lineCapStyle;
    private LineDashPattern lineDashPattern;
    private int lineJoinStyle;
    private float lineWidth;
    private float miterLimit;
    int renderMode;
    float rise;
    BaseColor strokeColor;
    float wordSpacing;

    public GraphicsState() {
        BaseColor baseColor = BaseColor.BLACK;
        this.fillColor = baseColor;
        this.strokeColor = baseColor;
        this.ctm = new Matrix();
        this.characterSpacing = 0.0f;
        this.wordSpacing = 0.0f;
        this.horizontalScaling = 1.0f;
        this.leading = 0.0f;
        this.font = null;
        this.fontSize = 0.0f;
        this.renderMode = 0;
        this.rise = 0.0f;
        this.knockout = true;
        this.colorSpaceFill = null;
        this.colorSpaceStroke = null;
        this.fillColor = null;
        this.strokeColor = null;
        this.lineWidth = 1.0f;
        this.lineCapStyle = 0;
        this.lineJoinStyle = 0;
        this.miterLimit = 10.0f;
    }

    public float getCharacterSpacing() {
        return this.characterSpacing;
    }

    public PdfName getColorSpaceFill() {
        return this.colorSpaceFill;
    }

    public PdfName getColorSpaceStroke() {
        return this.colorSpaceStroke;
    }

    public Matrix getCtm() {
        return this.ctm;
    }

    public BaseColor getFillColor() {
        return this.fillColor;
    }

    public CMapAwareDocumentFont getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public float getHorizontalScaling() {
        return this.horizontalScaling;
    }

    public float getLeading() {
        return this.leading;
    }

    public int getLineCapStyle() {
        return this.lineCapStyle;
    }

    public LineDashPattern getLineDashPattern() {
        return this.lineDashPattern;
    }

    public int getLineJoinStyle() {
        return this.lineJoinStyle;
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public float getMiterLimit() {
        return this.miterLimit;
    }

    public int getRenderMode() {
        return this.renderMode;
    }

    public float getRise() {
        return this.rise;
    }

    public BaseColor getStrokeColor() {
        return this.strokeColor;
    }

    public float getWordSpacing() {
        return this.wordSpacing;
    }

    public boolean isKnockout() {
        return this.knockout;
    }

    public void setLineCapStyle(int i) {
        this.lineCapStyle = i;
    }

    public void setLineDashPattern(LineDashPattern lineDashPattern) {
        this.lineDashPattern = new LineDashPattern(lineDashPattern.getDashArray(), lineDashPattern.getDashPhase());
    }

    public void setLineJoinStyle(int i) {
        this.lineJoinStyle = i;
    }

    public void setLineWidth(float f) {
        this.lineWidth = f;
    }

    public void setMiterLimit(float f) {
        this.miterLimit = f;
    }

    public GraphicsState(GraphicsState graphicsState) {
        BaseColor baseColor = BaseColor.BLACK;
        this.fillColor = baseColor;
        this.strokeColor = baseColor;
        this.ctm = graphicsState.ctm;
        this.characterSpacing = graphicsState.characterSpacing;
        this.wordSpacing = graphicsState.wordSpacing;
        this.horizontalScaling = graphicsState.horizontalScaling;
        this.leading = graphicsState.leading;
        this.font = graphicsState.font;
        this.fontSize = graphicsState.fontSize;
        this.renderMode = graphicsState.renderMode;
        this.rise = graphicsState.rise;
        this.knockout = graphicsState.knockout;
        this.colorSpaceFill = graphicsState.colorSpaceFill;
        this.colorSpaceStroke = graphicsState.colorSpaceStroke;
        this.fillColor = graphicsState.fillColor;
        this.strokeColor = graphicsState.strokeColor;
        this.lineWidth = graphicsState.lineWidth;
        this.lineCapStyle = graphicsState.lineCapStyle;
        this.lineJoinStyle = graphicsState.lineJoinStyle;
        this.miterLimit = graphicsState.miterLimit;
        LineDashPattern lineDashPattern = graphicsState.lineDashPattern;
        if (lineDashPattern != null) {
            this.lineDashPattern = new LineDashPattern(lineDashPattern.getDashArray(), graphicsState.lineDashPattern.getDashPhase());
        }
    }
}
