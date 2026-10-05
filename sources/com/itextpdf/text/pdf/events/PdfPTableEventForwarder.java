package com.itextpdf.text.pdf.events;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfPTableEventAfterSplit;
import com.itextpdf.text.pdf.PdfPTableEventSplit;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPTableEventForwarder implements PdfPTableEventAfterSplit {
    protected ArrayList<PdfPTableEvent> events = new ArrayList<>();

    public void addTableEvent(PdfPTableEvent pdfPTableEvent) {
        this.events.add(pdfPTableEvent);
    }

    @Override // com.itextpdf.text.pdf.PdfPTableEventAfterSplit
    public void afterSplitTable(PdfPTable pdfPTable, PdfPRow pdfPRow, int i) {
        for (PdfPTableEvent pdfPTableEvent : this.events) {
            if (pdfPTableEvent instanceof PdfPTableEventAfterSplit) {
                ((PdfPTableEventAfterSplit) pdfPTableEvent).afterSplitTable(pdfPTable, pdfPRow, i);
            }
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPTableEventSplit
    public void splitTable(PdfPTable pdfPTable) {
        for (PdfPTableEvent pdfPTableEvent : this.events) {
            if (pdfPTableEvent instanceof PdfPTableEventSplit) {
                ((PdfPTableEventSplit) pdfPTableEvent).splitTable(pdfPTable);
            }
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPTableEvent
    public void tableLayout(PdfPTable pdfPTable, float[][] fArr, float[] fArr2, int i, int i2, PdfContentByte[] pdfContentByteArr) {
        Iterator<PdfPTableEvent> it = this.events.iterator();
        while (it.hasNext()) {
            it.next().tableLayout(pdfPTable, fArr, fArr2, i, i2, pdfContentByteArr);
        }
    }
}
