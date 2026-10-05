package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class MaxLeadingAndSize {
    private float largestFont;
    private float largestLeading;
    private final CssUtils utils = CssUtils.getInstance();
    private final FontSizeTranslator fontSizeTranslator = FontSizeTranslator.getInstance();

    private float getLargestLeadingFromChildren(List<Tag> list) {
        float fFloatValue = 0.0f;
        for (Tag tag : list) {
            Float fCalculateLeading = calculateLeading(tag);
            if (fCalculateLeading.floatValue() > fFloatValue) {
                fFloatValue = fCalculateLeading.floatValue();
            }
            getLargestLeadingFromChildren(tag.getChildren());
        }
        return fFloatValue;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d  */
    public Float calculateLeading(Tag tag) {
        float pxInCmMmPcToPt;
        Map<String, String> css = tag.getCSS();
        float fontSize = this.fontSizeTranslator.getFontSize(tag);
        if (css.get("line-height") != null) {
            String str = css.get("line-height");
            if (this.utils.isNumericValue(str)) {
                pxInCmMmPcToPt = Float.parseFloat(str) * fontSize;
            } else if (this.utils.isRelativeValue(str)) {
                pxInCmMmPcToPt = this.utils.parseRelativeValue(str, fontSize);
            } else {
                pxInCmMmPcToPt = this.utils.isMetricValue(str) ? this.utils.parsePxInCmMmPcToPt(str) : 0.0f;
            }
            if (pxInCmMmPcToPt == 0.0f) {
                pxInCmMmPcToPt = fontSize * 1.5f;
            }
        } else {
            pxInCmMmPcToPt = fontSize * 1.5f;
        }
        return Float.valueOf(pxInCmMmPcToPt);
    }

    public float getLargestFont() {
        return this.largestFont;
    }

    public float getLargestFontFromChildren(List<Tag> list) {
        Iterator<Tag> it = list.iterator();
        float f = 12.0f;
        while (it.hasNext()) {
            float fontSize = this.fontSizeTranslator.getFontSize(it.next());
            if (fontSize > f) {
                f = fontSize;
            }
        }
        return f;
    }

    public float getLargestLeading() {
        return this.largestLeading;
    }

    public void setLeading(Tag tag) {
        this.largestLeading = calculateLeading(tag).floatValue();
    }

    public void setVariablesBasedOnChildren(Tag tag) {
        float fontSize = this.fontSizeTranslator.getFontSize(tag);
        float largestFontFromChildren = getLargestFontFromChildren(tag.getChildren());
        if (fontSize <= largestFontFromChildren) {
            fontSize = largestFontFromChildren;
        }
        this.largestFont = fontSize;
        float fFloatValue = calculateLeading(tag).floatValue();
        float largestLeadingFromChildren = getLargestLeadingFromChildren(tag.getChildren());
        if (fFloatValue <= largestLeadingFromChildren) {
            fFloatValue = largestLeadingFromChildren;
        }
        this.largestLeading = fFloatValue;
    }
}
