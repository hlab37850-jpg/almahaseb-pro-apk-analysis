package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;

/* JADX INFO: loaded from: classes3.dex */
public class TableBorderEvent implements PdfPTableEvent {
    private final TableStyleValues styleValues;

    public TableBorderEvent(TableStyleValues tableStyleValues) {
        this.styleValues = tableStyleValues;
    }

    public TableStyleValues getTableStyleValues() {
        return this.styleValues;
    }

    @Override // com.itextpdf.text.pdf.PdfPTableEvent
    public void tableLayout(PdfPTable pdfPTable, float[][] fArr, float[] fArr2, int i, int i2, PdfContentByte[] pdfContentByteArr) {
        float borderWidthLeft = this.styleValues.getBorderWidthLeft();
        float borderWidthRight = this.styleValues.getBorderWidthRight();
        float borderWidthTop = this.styleValues.getBorderWidthTop();
        float borderWidthBottom = this.styleValues.getBorderWidthBottom();
        float[] fArr3 = fArr[0];
        float f = fArr3[0] - (borderWidthLeft / 2.0f);
        float f2 = fArr3[fArr3.length - 1] + (borderWidthRight / 2.0f);
        float f3 = fArr2[0] + (borderWidthTop / 2.0f);
        float verBorderSpacing = fArr2[fArr2.length - 1] - ((borderWidthBottom / 2.0f) + this.styleValues.getVerBorderSpacing());
        PdfContentByte pdfContentByte = pdfContentByteArr[1];
        BaseColor background = this.styleValues.getBackground();
        if (background != null) {
            pdfContentByte.setColorFill(background);
            pdfContentByte.rectangle(f, f3, f2 - f, verBorderSpacing - f3);
            pdfContentByte.fill();
        }
        PdfContentByte pdfContentByte2 = pdfContentByteArr[2];
        if (borderWidthLeft != 0.0f) {
            BaseColor borderColorLeft = this.styleValues.getBorderColorLeft();
            if (borderColorLeft == null) {
                borderColorLeft = BaseColor.BLACK;
            }
            pdfContentByte2.setLineWidth(borderWidthLeft);
            pdfContentByte2.setColorStroke(borderColorLeft);
            pdfContentByte2.moveTo(f, f3);
            pdfContentByte2.lineTo(f, verBorderSpacing);
            pdfContentByte2.stroke();
        }
        if (borderWidthBottom != 0.0f) {
            BaseColor borderColorBottom = this.styleValues.getBorderColorBottom();
            if (borderColorBottom == null) {
                borderColorBottom = BaseColor.BLACK;
            }
            pdfContentByte2.setLineWidth(borderWidthBottom);
            pdfContentByte2.setColorStroke(borderColorBottom);
            pdfContentByte2.moveTo(f, verBorderSpacing);
            pdfContentByte2.lineTo(f2, verBorderSpacing);
            pdfContentByte2.stroke();
        }
        if (borderWidthRight != 0.0f) {
            BaseColor borderColorRight = this.styleValues.getBorderColorRight();
            if (borderColorRight == null) {
                borderColorRight = BaseColor.BLACK;
            }
            pdfContentByte2.setLineWidth(borderWidthRight);
            pdfContentByte2.setColorStroke(borderColorRight);
            pdfContentByte2.moveTo(f2, verBorderSpacing);
            pdfContentByte2.lineTo(f2, f3);
            pdfContentByte2.stroke();
        }
        if (borderWidthTop != 0.0f) {
            BaseColor borderColorTop = this.styleValues.getBorderColorTop();
            if (borderColorTop == null) {
                borderColorTop = BaseColor.BLACK;
            }
            pdfContentByte2.setLineWidth(borderWidthTop);
            pdfContentByte2.setColorStroke(borderColorTop);
            pdfContentByte2.moveTo(f2, f3);
            pdfContentByte2.lineTo(f, f3);
            pdfContentByte2.stroke();
        }
        pdfContentByte2.resetRGBColorStroke();
    }
}
