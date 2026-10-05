package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultCssInheritanceRules implements CssInheritanceRules {
    private static final List<String> GLOBAL = Arrays.asList("width", "height", CSS.Property.MIN_WIDTH, CSS.Property.MAX_WIDTH, CSS.Property.MIN_HEIGHT, CSS.Property.MAX_HEIGHT, CSS.Property.MARGIN, CSS.Property.MARGIN_LEFT, CSS.Property.MARGIN_RIGHT, CSS.Property.MARGIN_TOP, CSS.Property.MARGIN_BOTTOM, CSS.Property.PADDING, "padding-left", CSS.Property.PADDING_RIGHT, CSS.Property.PADDING_TOP, CSS.Property.PADDING_BOTTOM, CSS.Property.BORDER_TOP_WIDTH, CSS.Property.BORDER_TOP_STYLE, CSS.Property.BORDER_TOP_COLOR, CSS.Property.BORDER_BOTTOM_WIDTH, CSS.Property.BORDER_BOTTOM_STYLE, CSS.Property.BORDER_BOTTOM_COLOR, CSS.Property.BORDER_LEFT_WIDTH, CSS.Property.BORDER_LEFT_STYLE, CSS.Property.BORDER_LEFT_COLOR, CSS.Property.BORDER_RIGHT_WIDTH, CSS.Property.BORDER_RIGHT_STYLE, CSS.Property.BORDER_RIGHT_COLOR, CSS.Property.PAGE_BREAK_BEFORE, CSS.Property.PAGE_BREAK_AFTER, "left", "top", "right", "bottom", CSS.Property.POSITION);
    private static final List<String> PARENT_TO_TABLE = Arrays.asList("line-height", "font-size", "font-style", "font-weight", CSS.Property.TEXT_INDENT, "cellpadding", CSS.Property.CELLPADDING_LEFT, CSS.Property.CELLPADDING_TOP, CSS.Property.CELLPADDING_RIGHT, CSS.Property.CELLPADDING_BOTTOM, CSS.Property.DIRECTION);
    private static final List<String> TABLE_IN_ROW = Arrays.asList(CSS.Property.BACKGROUND_COLOR, CSS.Property.DIRECTION);
    private static final List<String> DIV_TO_CONTENT = Arrays.asList(CSS.Property.BACKGROUND, CSS.Property.BACKGROUND_COLOR, "float");
    private static final List<String> TD_TO_CONTENT = Arrays.asList("vertical-align");

    @Override // com.itextpdf.tool.xml.css.CssInheritanceRules
    public boolean inheritCssSelector(Tag tag, String str) {
        if (GLOBAL.contains(str)) {
            return false;
        }
        if ("table".equals(tag.getName())) {
            return !PARENT_TO_TABLE.contains(str);
        }
        if ("table".equals(tag.getParent().getName())) {
            return !TABLE_IN_ROW.contains(str);
        }
        if ("td".equalsIgnoreCase(tag.getParent().getName())) {
            return !TD_TO_CONTENT.contains(str);
        }
        if ("div".equalsIgnoreCase(tag.getParent().getName())) {
            return !DIV_TO_CONTENT.contains(str);
        }
        return true;
    }

    @Override // com.itextpdf.tool.xml.css.CssInheritanceRules
    public boolean inheritCssTag(String str) {
        return true;
    }
}
