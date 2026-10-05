package org.apache.poi.ss.usermodel;

import com.itextpdf.text.Jpeg;

/* JADX INFO: loaded from: classes4.dex */
public enum FontCharset {
    ANSI(0),
    DEFAULT(1),
    SYMBOL(2),
    MAC(77),
    SHIFTJIS(128),
    HANGEUL(129),
    JOHAB(ShapeTypes.DOUBLE_WAVE),
    GB2312(ShapeTypes.FLOW_CHART_INPUT_OUTPUT),
    CHINESEBIG5(ShapeTypes.FLOW_CHART_INTERNAL_STORAGE),
    GREEK(ShapeTypes.ACTION_BUTTON_BLANK),
    TURKISH(ShapeTypes.ACTION_BUTTON_HOME),
    VIETNAMESE(ShapeTypes.ACTION_BUTTON_HELP),
    HEBREW(ShapeTypes.MATH_MINUS),
    ARABIC(ShapeTypes.MATH_MULTIPLY),
    BALTIC(ShapeTypes.CHART_STAR),
    RUSSIAN(204),
    THAI(222),
    EASTEUROPE(Jpeg.M_APPE),
    OEM(255);

    private static FontCharset[] _table = new FontCharset[256];
    private int charset;

    static {
        for (FontCharset fontCharset : values()) {
            _table[fontCharset.getValue()] = fontCharset;
        }
    }

    FontCharset(int i) {
        this.charset = i;
    }

    public int getValue() {
        return this.charset;
    }

    public static FontCharset valueOf(int i) {
        return _table[i];
    }
}
