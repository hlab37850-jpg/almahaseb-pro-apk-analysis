package com.itextpdf.tool.xml.html;

import com.itextpdf.text.pdf.PdfOutline;

/* JADX INFO: loaded from: classes3.dex */
public class HeaderNode {
    private int level;
    private PdfOutline outline;
    private HeaderNode parent;

    public HeaderNode(int i, PdfOutline pdfOutline, HeaderNode headerNode) {
        this.level = i;
        this.outline = pdfOutline;
        this.parent = headerNode;
    }

    public int level() {
        return this.level;
    }

    public PdfOutline outline() {
        return this.outline;
    }

    public HeaderNode parent() {
        return this.parent;
    }
}
