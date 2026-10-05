package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ChunkCssApplier implements CssApplier<Chunk> {
    public static final List<String> BOLD = Arrays.asList("bold", "bolder", "600", "700", "800", "900");
    protected FontProvider fontProvider;
    protected final CssUtils utils;

    public ChunkCssApplier() {
        this(null);
    }

    public Font applyFontStyles(Tag tag) {
        String strTrimAndRemoveQuoutes;
        int i;
        int i2;
        String[] strArr;
        String str;
        float fontSize = FontSizeTranslator.getInstance().getFontSize(tag);
        if (fontSize == -1.0f) {
            fontSize = 12.0f;
        }
        int i3 = -1;
        BaseColor baseColorDecodeColor = null;
        String str2 = null;
        for (Map.Entry<String, String> entry : tag.getCSS().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("font-weight".equalsIgnoreCase(key)) {
                if (isBoldValue(value)) {
                    i3 = i3 == 2 ? 3 : 1;
                } else if (i3 == 3) {
                    i3 = 2;
                } else if (i3 == 1) {
                    i3 = 0;
                }
            } else if ("font-style".equalsIgnoreCase(key)) {
                if (value.equalsIgnoreCase("italic")) {
                    if (i3 != 1) {
                        i3 = 2;
                    }
                }
            } else if ("font-family".equalsIgnoreCase(key)) {
                str2 = value;
            } else if ("color".equalsIgnoreCase(key)) {
                baseColorDecodeColor = HtmlUtilities.decodeColor(value);
            }
        }
        if (str2 != null) {
            String str3 = ",";
            if (str2.contains(",")) {
                String[] strArrSplit = str2.split(",");
                int length = strArrSplit.length;
                int i4 = 0;
                Font font = null;
                while (i4 < length) {
                    String strTrimAndRemoveQuoutes2 = this.utils.trimAndRemoveQuoutes(strArrSplit[i4]);
                    if (this.fontProvider.isRegistered(strTrimAndRemoveQuoutes2)) {
                        i = i4;
                        i2 = length;
                        strArr = strArrSplit;
                        str = str3;
                        Font font2 = this.fontProvider.getFont(strTrimAndRemoveQuoutes2, "Cp1252", true, fontSize, i3, baseColorDecodeColor);
                        if (font2 != null && (i3 == 0 || i3 == -1 || (font2.getStyle() & i3) == 0)) {
                            return font2;
                        }
                        if (font == null) {
                            font = font2;
                        }
                    } else {
                        i = i4;
                        i2 = length;
                        strArr = strArrSplit;
                        str = str3;
                    }
                    i4 = i + 1;
                    strArrSplit = strArr;
                    str3 = str;
                    length = i2;
                }
                String[] strArr2 = strArrSplit;
                String str4 = str3;
                if (font != null) {
                    return font;
                }
                strTrimAndRemoveQuoutes = strArr2.length > 0 ? this.utils.trimAndRemoveQuoutes(str2.split(str4)[0]) : null;
            } else {
                strTrimAndRemoveQuoutes = this.utils.trimAndRemoveQuoutes(str2);
            }
        } else {
            strTrimAndRemoveQuoutes = str2;
        }
        return this.fontProvider.getFont(strTrimAndRemoveQuoutes, "Cp1252", true, fontSize, i3, baseColorDecodeColor);
    }

    public void copyChunkStyles(Chunk chunk, Chunk chunk2) {
        chunk2.setFont(chunk.getFont());
        chunk2.setAttributes(chunk.getAttributes());
        chunk2.setCharacterSpacing(chunk.getCharacterSpacing());
        chunk2.setHorizontalScaling(chunk.getHorizontalScaling());
        chunk2.setHorizontalScaling(chunk.getHorizontalScaling());
    }

    public FontProvider getFontProvider() {
        return this.fontProvider;
    }

    public float getWidestWord(Chunk chunk) {
        float widthPoint = 0.0f;
        for (String str : chunk.getContent().split("\\s")) {
            Chunk chunk2 = new Chunk(str);
            copyChunkStyles(chunk, chunk2);
            if (chunk2.getWidthPoint() > widthPoint) {
                widthPoint = chunk2.getWidthPoint();
            }
        }
        return widthPoint;
    }

    public boolean isBoldValue(String str) {
        String strTrim = str.trim();
        return "bold".contains(strTrim) || (strTrim.length() == 3 && strTrim.endsWith("00") && strTrim.charAt(0) >= '6' && strTrim.charAt(0) <= '9');
    }

    public void setFontProvider(FontProvider fontProvider) {
        this.fontProvider = fontProvider;
    }

    public ChunkCssApplier(FontProvider fontProvider) {
        this.utils = CssUtils.getInstance();
        if (fontProvider != null) {
            this.fontProvider = fontProvider;
        } else {
            this.fontProvider = new FontFactoryImp();
        }
    }

    public Chunk apply(Chunk chunk, Tag tag) {
        return apply(chunk, tag, (MarginMemory) null, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    /* JADX WARN: Code duplicated, block: B:71:0x01dc  */
    @Override // com.itextpdf.tool.xml.html.CssApplier
    public Chunk apply(Chunk chunk, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        Float fValueOf;
        Font fontApplyFontStyles = applyFontStyles(tag);
        float size = fontApplyFontStyles.getSize();
        Map<String, String> css = tag.getCSS();
        for (Map.Entry<String, String> entry : css.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            float pxInCmMmPcToPt = 0.0f;
            if ("font-style".equalsIgnoreCase(key)) {
                if (value.equalsIgnoreCase("oblique")) {
                    chunk.setSkew(0.0f, 12.0f);
                }
            } else if (CSS.Property.LETTER_SPACING.equalsIgnoreCase(key)) {
                String str = css.get(CSS.Property.LETTER_SPACING);
                if (this.utils.isRelativeValue(value)) {
                    pxInCmMmPcToPt = this.utils.parseRelativeValue(str, fontApplyFontStyles.getSize());
                } else if (this.utils.isMetricValue(value)) {
                    pxInCmMmPcToPt = this.utils.parsePxInCmMmPcToPt(str);
                }
                chunk.setCharacterSpacing(pxInCmMmPcToPt);
            } else if (css.get(CSS.Property.XFA_FONT_HORIZONTAL_SCALE) != null) {
                chunk.setHorizontalScaling(Float.parseFloat(css.get(CSS.Property.XFA_FONT_HORIZONTAL_SCALE).replace(CSS.Value.PERCENTAGE, "")) / 100.0f);
            }
        }
        if (css.get("vertical-align") != null) {
            String str2 = css.get("vertical-align");
            if (!str2.equalsIgnoreCase(CSS.Value.SUPER) && !str2.equalsIgnoreCase("top") && !str2.equalsIgnoreCase(CSS.Value.TEXT_TOP)) {
                if (!str2.equalsIgnoreCase("sub") && !str2.equalsIgnoreCase("bottom") && !str2.equalsIgnoreCase(CSS.Value.TEXT_BOTTOM)) {
                    chunk.setTextRise(this.utils.parsePxInCmMmPcToPt(str2));
                } else {
                    chunk.setTextRise((-size) / 2.0f);
                }
            } else {
                chunk.setTextRise((float) (((double) (size / 2.0f)) + 0.5d));
            }
        }
        String str3 = css.get(CSS.Property.XFA_FONT_VERTICAL_SCALE);
        if (str3 != null && str3.contains(CSS.Value.PERCENTAGE)) {
            size *= Float.parseFloat(str3.replace(CSS.Value.PERCENTAGE, "")) / 100.0f;
            chunk.setHorizontalScaling(100.0f / Float.parseFloat(str3.replace(CSS.Value.PERCENTAGE, "")));
        }
        float f = size;
        if (css.get("text-decoration") != null) {
            for (String str4 : css.get("text-decoration").split("\\s+")) {
                if ("underline".equalsIgnoreCase(str4)) {
                    chunk.setUnderline(null, 0.75f, 0.0f, 0.0f, -0.125f, 0);
                }
                if ("line-through".equalsIgnoreCase(str4)) {
                    chunk.setUnderline(null, 0.75f, 0.0f, 0.0f, 0.25f, 0);
                }
            }
        }
        if (css.get(CSS.Property.BACKGROUND_COLOR) != null) {
            chunk.setBackground(HtmlUtilities.decodeColor(css.get(CSS.Property.BACKGROUND_COLOR)));
        }
        fontApplyFontStyles.setSize(f);
        chunk.setFont(fontApplyFontStyles);
        if (css.get("line-height") != null) {
            String str5 = css.get("line-height");
            if (this.utils.isNumericValue(str5)) {
                fValueOf = Float.valueOf(Float.parseFloat(str5) * chunk.getFont().getSize());
            } else if (this.utils.isRelativeValue(str5)) {
                fValueOf = Float.valueOf(this.utils.parseRelativeValue(str5, chunk.getFont().getSize()));
            } else if (this.utils.isMetricValue(str5)) {
                fValueOf = Float.valueOf(this.utils.parsePxInCmMmPcToPt(str5));
            } else {
                fValueOf = null;
            }
        } else {
            fValueOf = null;
        }
        if (fValueOf != null) {
            chunk.setLineHeight(fValueOf.floatValue());
        }
        return chunk;
    }
}
