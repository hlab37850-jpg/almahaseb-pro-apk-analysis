package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.Paragraph;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ParagraphCssApplier implements CssApplier<Paragraph> {
    private final CssAppliers appliers;

    public ParagraphCssApplier(CssAppliers cssAppliers) {
        this.appliers = cssAppliers;
    }

    public Paragraph apply(Paragraph paragraph, Tag tag, MarginMemory marginMemory) {
        return apply(paragraph, tag, marginMemory, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    @Override // com.itextpdf.tool.xml.html.CssApplier
    public Paragraph apply(Paragraph paragraph, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        String str;
        CssUtils cssUtils = CssUtils.getInstance();
        float fontSize = FontSizeTranslator.getInstance().getFontSize(tag);
        float valueToPt = 0.0f;
        if (fontSize == -1.0f) {
            fontSize = 0.0f;
        }
        boolean z = false;
        for (Map.Entry<String, String> entry : tag.getCSS().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (CSS.Property.MARGIN_TOP.equalsIgnoreCase(key)) {
                paragraph.setSpacingBefore(paragraph.getSpacingBefore() + cssUtils.calculateMarginTop(value, fontSize, marginMemory));
            } else if (CSS.Property.PADDING_TOP.equalsIgnoreCase(key)) {
                paragraph.setSpacingBefore(paragraph.getSpacingBefore() + cssUtils.parseValueToPt(value, fontSize));
                paragraph.setPaddingTop(cssUtils.parseValueToPt(value, fontSize));
            } else if (CSS.Property.MARGIN_BOTTOM.equalsIgnoreCase(key)) {
                valueToPt = cssUtils.parseValueToPt(value, fontSize);
                paragraph.setSpacingAfter(paragraph.getSpacingAfter() + valueToPt);
                z = true;
            } else if (CSS.Property.PADDING_BOTTOM.equalsIgnoreCase(key)) {
                paragraph.setSpacingAfter(paragraph.getSpacingAfter() + cssUtils.parseValueToPt(value, fontSize));
            } else if (CSS.Property.MARGIN_LEFT.equalsIgnoreCase(key)) {
                paragraph.setIndentationLeft(paragraph.getIndentationLeft() + cssUtils.parseValueToPt(value, fontSize));
            } else if (CSS.Property.MARGIN_RIGHT.equalsIgnoreCase(key)) {
                paragraph.setIndentationRight(paragraph.getIndentationRight() + cssUtils.parseValueToPt(value, fontSize));
            } else if ("padding-left".equalsIgnoreCase(key)) {
                paragraph.setIndentationLeft(paragraph.getIndentationLeft() + cssUtils.parseValueToPt(value, fontSize));
            } else if (CSS.Property.PADDING_RIGHT.equalsIgnoreCase(key)) {
                paragraph.setIndentationRight(paragraph.getIndentationRight() + cssUtils.parseValueToPt(value, fontSize));
            } else if ("text-align".equalsIgnoreCase(key)) {
                paragraph.setAlignment(CSS.getElementAlignment(value));
            } else if (CSS.Property.TEXT_INDENT.equalsIgnoreCase(key)) {
                paragraph.setFirstLineIndent(cssUtils.parseValueToPt(value, fontSize));
            } else if ("line-height".equalsIgnoreCase(key)) {
                if (cssUtils.isNumericValue(value)) {
                    paragraph.setLeading(Float.parseFloat(value) * fontSize);
                } else if (cssUtils.isRelativeValue(value)) {
                    paragraph.setLeading(cssUtils.parseRelativeValue(value, fontSize));
                } else if (cssUtils.isMetricValue(value)) {
                    paragraph.setLeading(cssUtils.parsePxInCmMmPcToPt(value));
                }
            }
        }
        if (tag.getAttributes().containsKey("align") && (str = tag.getAttributes().get("align")) != null) {
            paragraph.setAlignment(CSS.getElementAlignment(str));
        }
        if (z) {
            marginMemory.setLastMarginBottom(Float.valueOf(valueToPt));
        }
        paragraph.setFont(this.appliers.getChunkCssAplier().applyFontStyles(tag));
        return paragraph;
    }
}
