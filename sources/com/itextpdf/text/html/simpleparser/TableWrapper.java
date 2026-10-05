package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class TableWrapper implements Element {
    private float[] colWidths;
    private final List<List<PdfPCell>> rows;
    private final Map<String, String> styles;

    public TableWrapper(Map<String, String> map) {
        HashMap map2 = new HashMap();
        this.styles = map2;
        this.rows = new ArrayList();
        map2.putAll(map);
    }

    public void addRow(List<PdfPCell> list) {
        if (list != null) {
            Collections.reverse(list);
            this.rows.add(list);
        }
    }

    public PdfPTable createTable() {
        if (this.rows.isEmpty()) {
            return new PdfPTable(1);
        }
        Iterator<PdfPCell> it = this.rows.get(0).iterator();
        int colspan = 0;
        while (it.hasNext()) {
            colspan += it.next().getColspan();
        }
        PdfPTable pdfPTable = new PdfPTable(colspan);
        String str = this.styles.get("width");
        if (str == null) {
            pdfPTable.setWidthPercentage(100.0f);
        } else if (str.endsWith(CSS.Value.PERCENTAGE)) {
            pdfPTable.setWidthPercentage(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else {
            pdfPTable.setTotalWidth(Float.parseFloat(str));
            pdfPTable.setLockedWidth(true);
        }
        String str2 = this.styles.get("align");
        pdfPTable.setHorizontalAlignment(str2 != null ? HtmlUtilities.alignmentValue(str2) : 0);
        try {
            float[] fArr = this.colWidths;
            if (fArr != null) {
                pdfPTable.setWidths(fArr);
            }
        } catch (Exception unused) {
        }
        Iterator<List<PdfPCell>> it2 = this.rows.iterator();
        while (it2.hasNext()) {
            Iterator<PdfPCell> it3 = it2.next().iterator();
            while (it3.hasNext()) {
                pdfPTable.addCell(it3.next());
            }
        }
        return pdfPTable;
    }

    @Override // com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        return null;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        return false;
    }

    public void setColWidths(float[] fArr) {
        this.colWidths = fArr;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 0;
    }
}
