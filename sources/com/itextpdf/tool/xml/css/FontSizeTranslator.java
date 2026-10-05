package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;

/* JADX INFO: loaded from: classes3.dex */
public class FontSizeTranslator {
    public static final float DEFAULT_FONT_SIZE = 12.0f;
    private static FontSizeTranslator myself;
    private static CssUtils utils = CssUtils.getInstance();

    public static synchronized FontSizeTranslator getInstance() {
        try {
            if (myself == null) {
                myself = new FontSizeTranslator();
            }
        } catch (Throwable th) {
            throw th;
        }
        return myself;
    }

    public float getFontSize(Tag tag) {
        String str = tag.getCSS().get("font-size");
        if (str != null) {
            return Float.parseFloat(str.replace(CSS.Value.PT, ""));
        }
        return -1.0f;
    }

    public float translateFontSize(Tag tag) {
        if (tag.getCSS().get("font-size") == null) {
            return -1.0f;
        }
        String str = tag.getCSS().get("font-size");
        if (!str.equalsIgnoreCase(CSS.Value.XX_SMALL)) {
            if (!str.equalsIgnoreCase(CSS.Value.X_SMALL)) {
                if (!str.equalsIgnoreCase("small")) {
                    if (!str.equalsIgnoreCase(CSS.Value.MEDIUM)) {
                        if (!str.equalsIgnoreCase(CSS.Value.LARGE)) {
                            if (!str.equalsIgnoreCase(CSS.Value.X_LARGE)) {
                                if (!str.equalsIgnoreCase(CSS.Value.XX_LARGE)) {
                                    if (str.equalsIgnoreCase(CSS.Value.SMALLER)) {
                                        if (tag.getParent() != null) {
                                            float fontSize = getFontSize(tag.getParent());
                                            if (fontSize != -1.0f) {
                                                if (fontSize <= 6.75f) {
                                                    return fontSize - 1.0f;
                                                }
                                                if (fontSize != 7.5f) {
                                                    if (fontSize != 9.75f) {
                                                        if (fontSize != 12.0f) {
                                                            if (fontSize != 13.5f) {
                                                                if (fontSize != 18.0f) {
                                                                    if (fontSize != 24.0f) {
                                                                        if (fontSize < 24.0f) {
                                                                            return fontSize * 0.85f;
                                                                        }
                                                                        if (fontSize >= 24.0f) {
                                                                            return (fontSize * 2.0f) / 3.0f;
                                                                        }
                                                                        return -1.0f;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (!str.equalsIgnoreCase(CSS.Value.LARGER)) {
                                            if (utils.isMetricValue(str) || utils.isNumericValue(str)) {
                                                return utils.parsePxInCmMmPcToPt(str);
                                            }
                                            if (!utils.isRelativeValue(str)) {
                                                return -1.0f;
                                            }
                                            float fontSize2 = tag.getParent() != null ? getFontSize(tag.getParent()) : -1.0f;
                                            return utils.parseRelativeValue(str, fontSize2 != -1.0f ? fontSize2 : 12.0f);
                                        }
                                        if (tag.getParent() != null) {
                                            float fontSize3 = getFontSize(tag.getParent());
                                            if (fontSize3 != -1.0f) {
                                                if (fontSize3 != 6.75f) {
                                                    if (fontSize3 != 7.5f) {
                                                        if (fontSize3 != 9.75f) {
                                                            if (fontSize3 != 12.0f) {
                                                                if (fontSize3 != 13.5f) {
                                                                    if (fontSize3 != 18.0f) {
                                                                        return fontSize3 * 1.5f;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                return 24.0f;
                            }
                            return 18.0f;
                        }
                        return 13.5f;
                    }
                    return 12.0f;
                }
                return 9.75f;
            }
            return 7.5f;
        }
        return 6.75f;
    }
}
