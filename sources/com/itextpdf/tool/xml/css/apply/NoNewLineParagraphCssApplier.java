package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class NoNewLineParagraphCssApplier implements CssApplier<NoNewLineParagraph> {
    private final CssUtils utils = CssUtils.getInstance();

    public NoNewLineParagraph apply(NoNewLineParagraph noNewLineParagraph, Tag tag, MarginMemory marginMemory) {
        return apply(noNewLineParagraph, tag, marginMemory, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    @Override // com.itextpdf.tool.xml.html.CssApplier
    public NoNewLineParagraph apply(NoNewLineParagraph noNewLineParagraph, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        float fontSize = FontSizeTranslator.getInstance().getFontSize(tag);
        Map<String, String> css = tag.getCSS();
        float valueToPt = 0.0f;
        boolean z = false;
        for (Map.Entry<String, String> entry : css.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (CSS.Property.MARGIN_TOP.equalsIgnoreCase(key)) {
                noNewLineParagraph.setSpacingBefore(noNewLineParagraph.getSpacingBefore() + this.utils.calculateMarginTop(value, fontSize, marginMemory));
            } else if (CSS.Property.PADDING_TOP.equalsIgnoreCase(key)) {
                noNewLineParagraph.setSpacingBefore(noNewLineParagraph.getSpacingBefore() + this.utils.parseValueToPt(value, fontSize));
            } else if (CSS.Property.MARGIN_BOTTOM.equalsIgnoreCase(key)) {
                valueToPt = this.utils.parseValueToPt(value, fontSize);
                noNewLineParagraph.setSpacingAfter(noNewLineParagraph.getSpacingAfter() + valueToPt);
                z = true;
            } else if (CSS.Property.PADDING_BOTTOM.equalsIgnoreCase(key)) {
                noNewLineParagraph.setSpacingAfter(noNewLineParagraph.getSpacingAfter() + this.utils.parseValueToPt(value, fontSize));
            } else if (CSS.Property.MARGIN_LEFT.equalsIgnoreCase(key)) {
                noNewLineParagraph.setIndentationLeft(noNewLineParagraph.getIndentationLeft() + this.utils.parseValueToPt(value, fontSize));
            } else if (CSS.Property.MARGIN_RIGHT.equalsIgnoreCase(key)) {
                noNewLineParagraph.setIndentationRight(noNewLineParagraph.getIndentationRight() + this.utils.parseValueToPt(value, fontSize));
            } else if ("padding-left".equalsIgnoreCase(key)) {
                noNewLineParagraph.setIndentationLeft(noNewLineParagraph.getIndentationLeft() + this.utils.parseValueToPt(value, fontSize));
            } else if (CSS.Property.PADDING_RIGHT.equalsIgnoreCase(key)) {
                noNewLineParagraph.setIndentationRight(noNewLineParagraph.getIndentationRight() + this.utils.parseValueToPt(value, fontSize));
            } else if ("text-align".equalsIgnoreCase(key)) {
                noNewLineParagraph.setAlignment(CSS.getElementAlignment(value));
            } else if (CSS.Property.TEXT_INDENT.equalsIgnoreCase(key)) {
                noNewLineParagraph.setFirstLineIndent(this.utils.parseValueToPt(value, fontSize));
            }
        }
        if (tag.getParent() != null) {
            String name = tag.getParent().getName();
            if (css.get(CSS.Property.MARGIN_TOP) == null && marginMemory.getRootTags().contains(name)) {
                noNewLineParagraph.setSpacingBefore(noNewLineParagraph.getSpacingBefore() + this.utils.calculateMarginTop(fontSize + CSS.Value.PT, 0.0f, marginMemory));
            }
            if (css.get(CSS.Property.MARGIN_BOTTOM) == null && marginMemory.getRootTags().contains(name)) {
                noNewLineParagraph.setSpacingAfter(noNewLineParagraph.getSpacingAfter() + fontSize);
                css.put(CSS.Property.MARGIN_BOTTOM, fontSize + CSS.Value.PT);
                z = true;
            } else {
                fontSize = valueToPt;
            }
            if (noNewLineParagraph.getAlignment() == -1) {
                noNewLineParagraph.setAlignment(0);
            }
            valueToPt = fontSize;
        }
        if (z) {
            marginMemory.setLastMarginBottom(Float.valueOf(valueToPt));
        }
        return noNewLineParagraph;
    }
}
