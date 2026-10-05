package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;

/* JADX INFO: loaded from: classes3.dex */
public class CellSpacingEvent implements PdfPCellEvent {
    private final TableStyleValues styleValues;

    public CellSpacingEvent(TableStyleValues tableStyleValues) {
        this.styleValues = tableStyleValues;
    }

    @Override // com.itextpdf.text.pdf.PdfPCellEvent
    public void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr) {
        float left = rectangle.getLeft() + (this.styleValues.getBorderWidthLeft() / 2.0f) + this.styleValues.getHorBorderSpacing();
        float right = rectangle.getRight() - (this.styleValues.isLastInRow() ? (this.styleValues.getBorderWidthRight() / 2.0f) + this.styleValues.getHorBorderSpacing() : this.styleValues.getBorderWidthRight() / 2.0f);
        float top = rectangle.getTop() - ((this.styleValues.getBorderWidthTop() / 2.0f) + this.styleValues.getVerBorderSpacing());
        float bottom = rectangle.getBottom() + (this.styleValues.getBorderWidthBottom() / 2.0f);
        PdfContentByte pdfContentByte = pdfContentByteArr[2];
        BaseColor background = this.styleValues.getBackground();
        if (background != null) {
            pdfContentByte.setColorStroke(background);
            pdfContentByte.setColorFill(background);
            pdfContentByte.rectangle(left, top, right - left, bottom - top);
            pdfContentByte.fill();
        }
        BaseColor borderColorLeft = this.styleValues.getBorderColorLeft();
        float borderWidthLeft = this.styleValues.getBorderWidthLeft();
        if (borderColorLeft != null && borderWidthLeft != 0.0f) {
            pdfContentByte.setLineWidth(borderWidthLeft);
            pdfContentByte.setColorStroke(borderColorLeft);
            pdfContentByte.moveTo(left, top);
            pdfContentByte.lineTo(left, bottom);
            pdfContentByte.stroke();
        }
        BaseColor borderColorBottom = this.styleValues.getBorderColorBottom();
        float borderWidthBottom = this.styleValues.getBorderWidthBottom();
        if (borderColorBottom != null && borderWidthBottom != 0.0f) {
            pdfContentByte.setLineWidth(borderWidthBottom);
            pdfContentByte.setColorStroke(borderColorBottom);
            pdfContentByte.moveTo(left, bottom);
            pdfContentByte.lineTo(right, bottom);
            pdfContentByte.stroke();
        }
        BaseColor borderColorRight = this.styleValues.getBorderColorRight();
        float borderWidthRight = this.styleValues.getBorderWidthRight();
        if (borderColorRight != null && borderWidthRight != 0.0f) {
            pdfContentByte.setLineWidth(borderWidthRight);
            pdfContentByte.setColorStroke(borderColorRight);
            pdfContentByte.moveTo(right, bottom);
            pdfContentByte.lineTo(right, top);
            pdfContentByte.stroke();
        }
        BaseColor borderColorTop = this.styleValues.getBorderColorTop();
        float borderWidthTop = this.styleValues.getBorderWidthTop();
        if (borderColorTop != null && borderWidthTop != 0.0f) {
            pdfContentByte.setLineWidth(borderWidthTop);
            pdfContentByte.setColorStroke(borderColorTop);
            pdfContentByte.moveTo(right, top);
            pdfContentByte.lineTo(left, top);
            pdfContentByte.stroke();
        }
        pdfContentByte.resetRGBColorStroke();
    }
}
