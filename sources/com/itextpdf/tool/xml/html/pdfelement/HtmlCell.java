package com.itextpdf.tool.xml.html.pdfelement;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.tool.xml.html.table.TableStyleValues;

/* JADX INFO: loaded from: classes3.dex */
public class HtmlCell extends PdfPCell {
    private float fixedWidth;
    private TableStyleValues values;

    public HtmlCell() {
        this.values = new TableStyleValues();
        this.fixedWidth = 0.0f;
        setPaddingLeft(0.0f);
        setPaddingRight(0.0f);
        setPaddingTop(0.0f);
        setPaddingBottom(0.0f);
        setUseAscender(true);
        setUseDescender(true);
    }

    public TableStyleValues getCellValues() {
        return this.values;
    }

    public float getFixedWidth() {
        return this.fixedWidth;
    }

    public void setCellValues(TableStyleValues tableStyleValues) {
        this.values = tableStyleValues;
    }

    public void setFixedWidth(float f) {
        this.fixedWidth = f;
    }

    public HtmlCell(PdfPCell pdfPCell, boolean z) {
        this(pdfPCell);
        this.values.setLastInRow(z);
    }

    public HtmlCell(PdfPCell pdfPCell) {
        super(pdfPCell);
        this.values = new TableStyleValues();
    }
}
