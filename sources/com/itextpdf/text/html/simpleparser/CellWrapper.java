package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TextElementArray;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.tool.xml.css.CSS;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class CellWrapper implements TextElementArray {
    private final PdfPCell cell;
    private boolean percentage;
    private float width;

    public CellWrapper(String str, ChainedProperties chainedProperties) {
        this.cell = createPdfPCell(str, chainedProperties);
        String property = chainedProperties.getProperty("width");
        if (property != null) {
            String strTrim = property.trim();
            if (strTrim.endsWith(CSS.Value.PERCENTAGE)) {
                this.percentage = true;
                strTrim = strTrim.substring(0, strTrim.length() - 1);
            }
            this.width = Float.parseFloat(strTrim);
        }
    }

    @Override // com.itextpdf.text.TextElementArray
    public boolean add(Element element) {
        this.cell.addElement(element);
        return true;
    }

    public PdfPCell createPdfPCell(String str, ChainedProperties chainedProperties) {
        PdfPCell pdfPCell = new PdfPCell((Phrase) null);
        String property = chainedProperties.getProperty("colspan");
        if (property != null) {
            pdfPCell.setColspan(Integer.parseInt(property));
        }
        String property2 = chainedProperties.getProperty("rowspan");
        if (property2 != null) {
            pdfPCell.setRowspan(Integer.parseInt(property2));
        }
        if (str.equals("th")) {
            pdfPCell.setHorizontalAlignment(1);
        }
        String property3 = chainedProperties.getProperty("align");
        if (property3 != null) {
            pdfPCell.setHorizontalAlignment(HtmlUtilities.alignmentValue(property3));
        }
        String property4 = chainedProperties.getProperty("valign");
        pdfPCell.setVerticalAlignment(5);
        if (property4 != null) {
            pdfPCell.setVerticalAlignment(HtmlUtilities.alignmentValue(property4));
        }
        String property5 = chainedProperties.getProperty("border");
        pdfPCell.setBorderWidth(property5 != null ? Float.parseFloat(property5) : 0.0f);
        String property6 = chainedProperties.getProperty("cellpadding");
        if (property6 != null) {
            pdfPCell.setPadding(Float.parseFloat(property6));
        }
        pdfPCell.setUseDescender(true);
        pdfPCell.setBackgroundColor(HtmlUtilities.decodeColor(chainedProperties.getProperty(HtmlTags.BGCOLOR)));
        return pdfPCell;
    }

    public PdfPCell getCell() {
        return this.cell;
    }

    @Override // com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        return null;
    }

    public float getWidth() {
        return this.width;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return false;
    }

    public boolean isPercentage() {
        return this.percentage;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 0;
    }
}
