package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LineSeparatorCssApplier implements CssApplier<LineSeparator> {
    public LineSeparator apply(LineSeparator lineSeparator, Tag tag, PageSizeContainable pageSizeContainable) {
        return apply(lineSeparator, tag, (MarginMemory) null, pageSizeContainable, (HtmlPipelineContext) null);
    }

    @Override // com.itextpdf.tool.xml.html.CssApplier
    public LineSeparator apply(LineSeparator lineSeparator, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        float pxInCmMmPcToPt;
        Map<String, String> css = tag.getCSS();
        if (tag.getAttributes().get("size") != null) {
            pxInCmMmPcToPt = CssUtils.getInstance().parsePxInCmMmPcToPt(tag.getAttributes().get("size"));
        } else {
            pxInCmMmPcToPt = css.get("height") != null ? CssUtils.getInstance().parsePxInCmMmPcToPt(css.get("height")) : 1.0f;
        }
        lineSeparator.setLineWidth(pxInCmMmPcToPt);
        BaseColor baseColorDecodeColor = BaseColor.BLACK;
        if (tag.getAttributes().get("color") != null) {
            baseColorDecodeColor = HtmlUtilities.decodeColor(tag.getAttributes().get("color"));
        } else if (css.get("color") != null) {
            baseColorDecodeColor = HtmlUtilities.decodeColor(css.get("color"));
        } else if (css.get(CSS.Property.BACKGROUND_COLOR) != null) {
            baseColorDecodeColor = HtmlUtilities.decodeColor(css.get(CSS.Property.BACKGROUND_COLOR));
        }
        lineSeparator.setLineColor(baseColorDecodeColor);
        String str = css.get("width");
        if (str == null) {
            str = tag.getAttributes().get("width");
        }
        float pxInCmMmPcToPt2 = 100.0f;
        if (str != null) {
            if (str.contains(CSS.Value.PERCENTAGE)) {
                pxInCmMmPcToPt2 = Float.parseFloat(str.replace(CSS.Value.PERCENTAGE, ""));
            } else {
                pxInCmMmPcToPt2 = 100.0f * (CssUtils.getInstance().parsePxInCmMmPcToPt(str) / pageSizeContainable.getPageSize().getWidth());
            }
        }
        lineSeparator.setPercentage(pxInCmMmPcToPt2);
        String str2 = tag.getAttributes().get("align");
        if ("right".equals(str2)) {
            lineSeparator.setAlignment(2);
        } else if ("left".equals(str2)) {
            lineSeparator.setAlignment(0);
        } else if ("center".equals(str2)) {
            lineSeparator.setAlignment(1);
        }
        return lineSeparator;
    }
}
