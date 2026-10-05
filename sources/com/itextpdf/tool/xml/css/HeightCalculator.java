package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;

/* JADX INFO: loaded from: classes3.dex */
public class HeightCalculator {
    private final CssUtils utils = CssUtils.getInstance();

    public Float getHeight(Tag tag, float f) {
        String str = tag.getCSS().get("height");
        if (str == null) {
            str = tag.getAttributes().get("height");
        }
        Float height = null;
        if (str == null) {
            return null;
        }
        if (this.utils.isNumericValue(str) || this.utils.isMetricValue(str)) {
            return Float.valueOf(this.utils.parsePxInCmMmPcToPt(str));
        }
        if (!this.utils.isRelativeValue(str)) {
            return null;
        }
        while (height == null && tag.getParent() != null) {
            tag = tag.getParent();
            height = getHeight(tag, f);
        }
        return height == null ? Float.valueOf(this.utils.parseRelativeValue(str, f)) : Float.valueOf(this.utils.parseRelativeValue(str, height.floatValue()));
    }
}
