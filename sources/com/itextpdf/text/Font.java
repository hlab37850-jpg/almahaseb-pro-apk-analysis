package com.itextpdf.text;

import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.BaseFont;

/* JADX INFO: loaded from: classes3.dex */
public class Font implements Comparable<Font> {
    public static final int BOLD = 1;
    public static final int BOLDITALIC = 3;
    public static final int DEFAULTSIZE = 12;
    public static final int ITALIC = 2;
    public static final int NORMAL = 0;
    public static final int STRIKETHRU = 8;
    public static final int UNDEFINED = -1;
    public static final int UNDERLINE = 4;
    private BaseFont baseFont;
    private BaseColor color;
    private FontFamily family;
    private float size;
    private int style;

    /* JADX INFO: renamed from: com.itextpdf.text.Font$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$Font$FontFamily;

        static {
            int[] iArr = new int[FontFamily.values().length];
            $SwitchMap$com$itextpdf$text$Font$FontFamily = iArr;
            try {
                iArr[FontFamily.COURIER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$Font$FontFamily[FontFamily.HELVETICA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$Font$FontFamily[FontFamily.TIMES_ROMAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$itextpdf$text$Font$FontFamily[FontFamily.SYMBOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$itextpdf$text$Font$FontFamily[FontFamily.ZAPFDINGBATS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum FontFamily {
        COURIER,
        HELVETICA,
        TIMES_ROMAN,
        SYMBOL,
        ZAPFDINGBATS,
        UNDEFINED
    }

    public enum FontStyle {
        NORMAL(HtmlTags.NORMAL),
        BOLD("bold"),
        ITALIC("italic"),
        OBLIQUE("oblique"),
        UNDERLINE("underline"),
        LINETHROUGH("line-through");

        private String code;

        FontStyle(String str) {
            this.code = str;
        }

        public String getValue() {
            return this.code;
        }
    }

    public Font(Font font) {
        this.family = FontFamily.UNDEFINED;
        this.size = -1.0f;
        this.style = -1;
        this.color = null;
        this.baseFont = null;
        this.family = font.family;
        this.size = font.size;
        this.style = font.style;
        this.color = font.color;
        this.baseFont = font.baseFont;
    }

    public static int getStyleValue(String str) {
        str.indexOf(FontStyle.NORMAL.getValue());
        int i = str.indexOf(FontStyle.BOLD.getValue()) != -1 ? 1 : 0;
        if (str.indexOf(FontStyle.ITALIC.getValue()) != -1) {
            i |= 2;
        }
        if (str.indexOf(FontStyle.OBLIQUE.getValue()) != -1) {
            i |= 2;
        }
        if (str.indexOf(FontStyle.UNDERLINE.getValue()) != -1) {
            i |= 4;
        }
        return str.indexOf(FontStyle.LINETHROUGH.getValue()) != -1 ? i | 8 : i;
    }

    public Font difference(Font font) {
        if (font == null) {
            return this;
        }
        float f = font.size;
        if (f == -1.0f) {
            f = this.size;
        }
        int i = this.style;
        int style = font.getStyle();
        int i2 = -1;
        if (i != -1 || style != -1) {
            if (i == -1) {
                i = 0;
            }
            if (style == -1) {
                style = 0;
            }
            i2 = i | style;
        }
        BaseColor baseColor = font.color;
        if (baseColor == null) {
            baseColor = this.color;
        }
        BaseFont baseFont = font.baseFont;
        if (baseFont != null) {
            return new Font(baseFont, f, i2, baseColor);
        }
        if (font.getFamily() != FontFamily.UNDEFINED) {
            return new Font(font.family, f, i2, baseColor);
        }
        BaseFont baseFont2 = this.baseFont;
        if (baseFont2 != null) {
            return i2 == i ? new Font(baseFont2, f, i2, baseColor) : FontFactory.getFont(getFamilyname(), f, i2, baseColor);
        }
        return new Font(this.family, f, i2, baseColor);
    }

    public BaseFont getBaseFont() {
        return this.baseFont;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003d A[PHI: r0
      0x003d: PHI (r0v6 java.lang.String) = (r0v4 java.lang.String), (r0v7 java.lang.String) binds: [B:28:0x0044, B:24:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0040 A[PHI: r0
      0x0040: PHI (r0v5 java.lang.String) = (r0v4 java.lang.String), (r0v7 java.lang.String) binds: [B:28:0x0044, B:24:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    public BaseFont getCalculatedBaseFont(boolean z) {
        String str;
        String str2;
        BaseFont baseFont = this.baseFont;
        if (baseFont != null) {
            return baseFont;
        }
        int i = this.style;
        if (i == -1) {
            i = 0;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$itextpdf$text$Font$FontFamily[this.family.ordinal()];
        String str3 = "Cp1252";
        if (i2 == 1) {
            int i3 = i & 3;
            if (i3 == 1) {
                str = "Courier-Bold";
            } else if (i3 != 2) {
                str = i3 != 3 ? "Courier" : "Courier-BoldOblique";
            } else {
                str = "Courier-Oblique";
            }
        } else if (i2 == 3) {
            int i4 = i & 3;
            if (i4 == 1) {
                str = "Times-Bold";
            } else if (i4 != 2) {
                str = i4 != 3 ? "Times-Roman" : "Times-BoldItalic";
            } else {
                str = "Times-Italic";
            }
        } else if (i2 == 4) {
            str2 = "Symbol";
            if (z) {
                str = str2;
                str3 = str;
            } else {
                str = str2;
            }
        } else if (i2 != 5) {
            int i5 = i & 3;
            if (i5 == 1) {
                str = "Helvetica-Bold";
            } else if (i5 != 2) {
                str = i5 != 3 ? "Helvetica" : "Helvetica-BoldOblique";
            } else {
                str = "Helvetica-Oblique";
            }
        } else {
            str2 = "ZapfDingbats";
            if (z) {
                str = str2;
                str3 = str;
            } else {
                str = str2;
            }
        }
        try {
            return BaseFont.createFont(str, str3, false);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public float getCalculatedLeading(float f) {
        return f * getCalculatedSize();
    }

    public float getCalculatedSize() {
        float f = this.size;
        if (f == -1.0f) {
            return 12.0f;
        }
        return f;
    }

    public int getCalculatedStyle() {
        FontFamily fontFamily;
        int i = this.style;
        if (i == -1) {
            i = 0;
        }
        return (this.baseFont != null || (fontFamily = this.family) == FontFamily.SYMBOL || fontFamily == FontFamily.ZAPFDINGBATS) ? i : i & (-4);
    }

    public BaseColor getColor() {
        return this.color;
    }

    public FontFamily getFamily() {
        return this.family;
    }

    public String getFamilyname() {
        int i = AnonymousClass1.$SwitchMap$com$itextpdf$text$Font$FontFamily[getFamily().ordinal()];
        if (i == 1) {
            return "Courier";
        }
        if (i == 2) {
            return "Helvetica";
        }
        if (i == 3) {
            return "Times-Roman";
        }
        if (i == 4) {
            return "Symbol";
        }
        if (i == 5) {
            return "ZapfDingbats";
        }
        BaseFont baseFont = this.baseFont;
        String str = "unknown";
        if (baseFont != null) {
            for (String[] strArr : baseFont.getFamilyFontName()) {
                if ("0".equals(strArr[2])) {
                    return strArr[3];
                }
                if ("1033".equals(strArr[2])) {
                    str = strArr[3];
                }
                if ("".equals(strArr[2])) {
                    str = strArr[3];
                }
            }
        }
        return str;
    }

    public float getSize() {
        return this.size;
    }

    public int getStyle() {
        return this.style;
    }

    public boolean isBold() {
        int i = this.style;
        return i != -1 && (i & 1) == 1;
    }

    public boolean isItalic() {
        int i = this.style;
        return i != -1 && (i & 2) == 2;
    }

    public boolean isStandardFont() {
        return this.family == FontFamily.UNDEFINED && this.size == -1.0f && this.style == -1 && this.color == null && this.baseFont == null;
    }

    public boolean isStrikethru() {
        int i = this.style;
        return i != -1 && (i & 8) == 8;
    }

    public boolean isUnderlined() {
        int i = this.style;
        return i != -1 && (i & 4) == 4;
    }

    public void setColor(BaseColor baseColor) {
        this.color = baseColor;
    }

    public void setFamily(String str) {
        this.family = getFamily(str);
    }

    public void setSize(float f) {
        this.size = f;
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public static FontFamily getFamily(String str) {
        if (str.equalsIgnoreCase("Courier")) {
            return FontFamily.COURIER;
        }
        if (str.equalsIgnoreCase("Helvetica")) {
            return FontFamily.HELVETICA;
        }
        if (str.equalsIgnoreCase("Times-Roman")) {
            return FontFamily.TIMES_ROMAN;
        }
        if (str.equalsIgnoreCase("Symbol")) {
            return FontFamily.SYMBOL;
        }
        return str.equalsIgnoreCase("ZapfDingbats") ? FontFamily.ZAPFDINGBATS : FontFamily.UNDEFINED;
    }

    @Override // java.lang.Comparable
    public int compareTo(Font font) {
        if (font == null) {
            return -1;
        }
        try {
            BaseFont baseFont = this.baseFont;
            if (baseFont != null && !baseFont.equals(font.getBaseFont())) {
                return -2;
            }
            if (this.family != font.getFamily()) {
                return 1;
            }
            if (this.size != font.getSize()) {
                return 2;
            }
            if (this.style != font.getStyle()) {
                return 3;
            }
            BaseColor baseColor = this.color;
            if (baseColor == null) {
                return font.color == null ? 0 : 4;
            }
            return (font.color != null && baseColor.equals(font.getColor())) ? 0 : 4;
        } catch (ClassCastException unused) {
            return -3;
        }
    }

    public void setColor(int i, int i2, int i3) {
        this.color = new BaseColor(i, i2, i3);
    }

    public void setStyle(String str) {
        if (this.style == -1) {
            this.style = 0;
        }
        this.style = getStyleValue(str) | this.style;
    }

    public Font(FontFamily fontFamily, float f, int i, BaseColor baseColor) {
        FontFamily fontFamily2 = FontFamily.COURIER;
        this.baseFont = null;
        this.family = fontFamily;
        this.size = f;
        this.style = i;
        this.color = baseColor;
    }

    public Font(BaseFont baseFont, float f, int i, BaseColor baseColor) {
        this.family = FontFamily.UNDEFINED;
        this.baseFont = baseFont;
        this.size = f;
        this.style = i;
        this.color = baseColor;
    }

    public Font(BaseFont baseFont, float f, int i) {
        this(baseFont, f, i, (BaseColor) null);
    }

    public Font(BaseFont baseFont, float f) {
        this(baseFont, f, -1, (BaseColor) null);
    }

    public Font(BaseFont baseFont) {
        this(baseFont, -1.0f, -1, (BaseColor) null);
    }

    public Font(FontFamily fontFamily, float f, int i) {
        this(fontFamily, f, i, (BaseColor) null);
    }

    public Font(FontFamily fontFamily, float f) {
        this(fontFamily, f, -1, (BaseColor) null);
    }

    public Font(FontFamily fontFamily) {
        this(fontFamily, -1.0f, -1, (BaseColor) null);
    }

    public Font() {
        this(FontFamily.UNDEFINED, -1.0f, -1, (BaseColor) null);
    }
}
