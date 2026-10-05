package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.Image;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImageCssApplier implements CssApplier<Image> {
    public Image apply(Image image, Tag tag) {
        return apply(image, tag, (MarginMemory) null, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    @Override // com.itextpdf.tool.xml.html.CssApplier
    public Image apply(Image image, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        Map<String, String> css = tag.getCSS();
        String str = css.get("width");
        if (str == null) {
            str = tag.getAttributes().get("width");
        }
        String str2 = css.get("height");
        if (str2 == null) {
            str2 = tag.getAttributes().get("height");
        }
        if (str == null) {
            image.setScaleToFitLineWhenOverflow(true);
        } else {
            image.setScaleToFitLineWhenOverflow(false);
        }
        image.setScaleToFitHeight(false);
        CssUtils cssUtils = CssUtils.getInstance();
        float pxInCmMmPcToPt = cssUtils.parsePxInCmMmPcToPt(str);
        float pxInCmMmPcToPt2 = cssUtils.parsePxInCmMmPcToPt(str2);
        if (pxInCmMmPcToPt > 0.0f && pxInCmMmPcToPt2 > 0.0f) {
            image.scaleAbsolute(pxInCmMmPcToPt, pxInCmMmPcToPt2);
        } else if (pxInCmMmPcToPt > 0.0f) {
            image.scaleAbsolute(pxInCmMmPcToPt, (image.getHeight() * pxInCmMmPcToPt) / image.getWidth());
        } else if (pxInCmMmPcToPt2 > 0.0f) {
            image.scaleAbsolute((image.getWidth() * pxInCmMmPcToPt2) / image.getHeight(), pxInCmMmPcToPt2);
        }
        String str3 = css.get(CSS.Property.BORDER_TOP_COLOR);
        if (str3 != null) {
            image.setBorderColorTop(HtmlUtilities.decodeColor(str3));
        }
        String str4 = css.get(CSS.Property.BORDER_TOP_WIDTH);
        if (str4 != null) {
            image.setBorderWidthTop(cssUtils.parseValueToPt(str4, 1.0f));
        }
        String str5 = css.get(CSS.Property.BORDER_RIGHT_COLOR);
        if (str5 != null) {
            image.setBorderColorRight(HtmlUtilities.decodeColor(str5));
        }
        String str6 = css.get(CSS.Property.BORDER_RIGHT_WIDTH);
        if (str6 != null) {
            image.setBorderWidthRight(cssUtils.parseValueToPt(str6, 1.0f));
        }
        String str7 = css.get(CSS.Property.BORDER_BOTTOM_COLOR);
        if (str7 != null) {
            image.setBorderColorBottom(HtmlUtilities.decodeColor(str7));
        }
        String str8 = css.get(CSS.Property.BORDER_BOTTOM_WIDTH);
        if (str8 != null) {
            image.setBorderWidthBottom(cssUtils.parseValueToPt(str8, 1.0f));
        }
        String str9 = css.get(CSS.Property.BORDER_LEFT_COLOR);
        if (str9 != null) {
            image.setBorderColorLeft(HtmlUtilities.decodeColor(str9));
        }
        String str10 = css.get(CSS.Property.BORDER_LEFT_WIDTH);
        if (str10 != null) {
            image.setBorderWidthLeft(cssUtils.parseValueToPt(str10, 1.0f));
        }
        String str11 = css.get("before");
        if (str11 != null) {
            image.setSpacingBefore(Float.parseFloat(str11));
        }
        String str12 = css.get("after");
        if (str12 != null) {
            image.setSpacingAfter(Float.parseFloat(str12));
        }
        image.setWidthPercentage(0.0f);
        return image;
    }
}
