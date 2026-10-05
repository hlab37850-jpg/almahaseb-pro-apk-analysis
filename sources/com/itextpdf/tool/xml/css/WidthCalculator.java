package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WidthCalculator {
    private final CssUtils utils = CssUtils.getInstance();

    public float getWidth(Tag tag, List<String> list, float f) {
        return getWidth(tag, list, f, -1.0f);
    }

    public float getWidth(Tag tag, List<String> list, float f, float f2) {
        String str = tag.getCSS().get("width");
        if (str == null) {
            str = tag.getAttributes().get("width");
        }
        if (str != null) {
            if (this.utils.isNumericValue(str) || this.utils.isMetricValue(str)) {
                return this.utils.parsePxInCmMmPcToPt(str);
            }
            if (this.utils.isRelativeValue(str)) {
                float width = 0.0f;
                while (width == 0.0f && tag.getParent() != null) {
                    tag = tag.getParent();
                    width = getWidth(tag, list, f, f2);
                }
                return width == 0.0f ? this.utils.parseRelativeValue(str, f) : this.utils.parseRelativeValue(str, width);
            }
        } else if (list.contains(tag.getName())) {
            return Float.compare(f2, -1.0f) == 0 ? f : f2;
        }
        return 0.0f;
    }
}
