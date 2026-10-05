package com.itextpdf.text.pdf;

import com.itextpdf.text.Rectangle;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PdfAppearance extends PdfTemplate {
    public static final HashMap<String, PdfName> stdFieldFontNames;

    static {
        HashMap<String, PdfName> map = new HashMap<>();
        stdFieldFontNames = map;
        map.put("Courier-BoldOblique", new PdfName("CoBO"));
        map.put("Courier-Bold", new PdfName("CoBo"));
        map.put("Courier-Oblique", new PdfName("CoOb"));
        map.put("Courier", new PdfName("Cour"));
        map.put("Helvetica-BoldOblique", new PdfName("HeBO"));
        map.put("Helvetica-Bold", new PdfName("HeBo"));
        map.put("Helvetica-Oblique", new PdfName("HeOb"));
        map.put("Helvetica", PdfName.HELV);
        map.put("Symbol", new PdfName("Symb"));
        map.put("Times-BoldItalic", new PdfName("TiBI"));
        map.put("Times-Bold", new PdfName("TiBo"));
        map.put("Times-Italic", new PdfName("TiIt"));
        map.put("Times-Roman", new PdfName("TiRo"));
        map.put("ZapfDingbats", PdfName.ZADB);
        map.put("HYSMyeongJo-Medium", new PdfName("HySm"));
        map.put("HYGoThic-Medium", new PdfName("HyGo"));
        map.put("HeiseiKakuGo-W5", new PdfName("KaGo"));
        map.put("HeiseiMin-W3", new PdfName("KaMi"));
        map.put("MHei-Medium", new PdfName("MHei"));
        map.put("MSung-Light", new PdfName("MSun"));
        map.put("STSong-Light", new PdfName("STSo"));
        map.put("MSungStd-Light", new PdfName("MSun"));
        map.put("STSongStd-Light", new PdfName("STSo"));
        map.put("HYSMyeongJoStd-Medium", new PdfName("HySm"));
        map.put("KozMinPro-Regular", new PdfName("KaMi"));
    }

    public PdfAppearance() {
        this.separator = 32;
    }

    public static PdfAppearance createAppearance(PdfWriter pdfWriter, float f, float f2) {
        return createAppearance(pdfWriter, f, f2, null);
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate, com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        PdfAppearance pdfAppearance = new PdfAppearance();
        pdfAppearance.writer = this.writer;
        pdfAppearance.pdf = this.pdf;
        pdfAppearance.thisReference = this.thisReference;
        pdfAppearance.pageResources = this.pageResources;
        pdfAppearance.bBox = new Rectangle(this.bBox);
        pdfAppearance.group = this.group;
        pdfAppearance.layer = this.layer;
        PdfArray pdfArray = this.matrix;
        if (pdfArray != null) {
            pdfAppearance.matrix = new PdfArray(pdfArray);
        }
        pdfAppearance.separator = this.separator;
        return pdfAppearance;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setFontAndSize(BaseFont baseFont, float f) {
        checkWriter();
        this.state.size = f;
        if (baseFont.getFontType() == 4) {
            this.state.fontDetails = new FontDetails(null, ((DocumentFont) baseFont).getIndirectReference(), baseFont);
        } else {
            this.state.fontDetails = this.writer.addSimple(baseFont);
        }
        PdfName pdfName = stdFieldFontNames.get(baseFont.getPostscriptFontName());
        if (pdfName == null) {
            if (baseFont.isSubset() && baseFont.getFontType() == 3) {
                pdfName = this.state.fontDetails.getFontName();
            } else {
                pdfName = new PdfName(baseFont.getPostscriptFontName());
                this.state.fontDetails.setSubset(false);
            }
        }
        getPageResources().addFont(pdfName, this.state.fontDetails.getIndirectReference());
        this.content.append(pdfName.getBytes()).append(' ').append(f).append(" Tf").append_i(this.separator);
    }

    public static PdfAppearance createAppearance(PdfWriter pdfWriter, float f, float f2, PdfName pdfName) {
        PdfAppearance pdfAppearance = new PdfAppearance(pdfWriter);
        pdfAppearance.setWidth(f);
        pdfAppearance.setHeight(f2);
        pdfWriter.addDirectTemplateSimple(pdfAppearance, pdfName);
        return pdfAppearance;
    }

    public PdfAppearance(PdfIndirectReference pdfIndirectReference) {
        this.thisReference = pdfIndirectReference;
    }

    public PdfAppearance(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.separator = 32;
    }
}
