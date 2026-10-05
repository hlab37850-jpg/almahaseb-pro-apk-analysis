package com.itextpdf.text.pdf.draw;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfContentByte;

/* JADX INFO: loaded from: classes3.dex */
public class LineSeparator extends VerticalPositionMark {
    protected int alignment;
    protected BaseColor lineColor;
    protected float lineWidth;
    protected float percentage;

    public LineSeparator(float f, float f2, BaseColor baseColor, int i, float f3) {
        this.lineWidth = f;
        this.percentage = f2;
        this.lineColor = baseColor;
        this.alignment = i;
        this.offset = f3;
    }

    @Override // com.itextpdf.text.pdf.draw.VerticalPositionMark, com.itextpdf.text.pdf.draw.DrawInterface
    public void draw(PdfContentByte pdfContentByte, float f, float f2, float f3, float f4, float f5) {
        pdfContentByte.saveState();
        drawLine(pdfContentByte, f, f3, f5);
        pdfContentByte.restoreState();
    }

    public void drawLine(PdfContentByte pdfContentByte, float f, float f2, float f3) {
        float f4 = 0.0f;
        float percentage = getPercentage() < 0.0f ? -getPercentage() : ((f2 - f) * getPercentage()) / 100.0f;
        int alignment = getAlignment();
        if (alignment != 0) {
            f4 = alignment != 2 ? ((f2 - f) - percentage) / 2.0f : (f2 - f) - percentage;
        }
        pdfContentByte.setLineWidth(getLineWidth());
        if (getLineColor() != null) {
            pdfContentByte.setColorStroke(getLineColor());
        }
        pdfContentByte.moveTo(f4 + f, this.offset + f3);
        pdfContentByte.lineTo(f4 + percentage + f, f3 + this.offset);
        pdfContentByte.stroke();
    }

    public int getAlignment() {
        return this.alignment;
    }

    public BaseColor getLineColor() {
        return this.lineColor;
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public void setLineColor(BaseColor baseColor) {
        this.lineColor = baseColor;
    }

    public void setLineWidth(float f) {
        this.lineWidth = f;
    }

    public void setPercentage(float f) {
        this.percentage = f;
    }

    public LineSeparator(Font font) {
        this.lineWidth = 1.0f;
        this.percentage = 100.0f;
        this.alignment = 6;
        this.lineWidth = font.getSize() * 0.06666667f;
        this.offset = font.getSize() * (-0.33333334f);
        this.percentage = 100.0f;
        this.lineColor = font.getColor();
    }

    public LineSeparator() {
        this.lineWidth = 1.0f;
        this.percentage = 100.0f;
        this.alignment = 6;
    }
}
