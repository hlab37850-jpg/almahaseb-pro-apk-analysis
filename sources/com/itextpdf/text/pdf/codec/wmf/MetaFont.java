package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public class MetaFont extends MetaObject {
    static final int BOLDTHRESHOLD = 600;
    static final int DEFAULT_PITCH = 0;
    static final int ETO_CLIPPED = 4;
    static final int ETO_OPAQUE = 2;
    static final int FF_DECORATIVE = 5;
    static final int FF_DONTCARE = 0;
    static final int FF_MODERN = 3;
    static final int FF_ROMAN = 1;
    static final int FF_SCRIPT = 4;
    static final int FF_SWISS = 2;
    static final int FIXED_PITCH = 1;
    static final int MARKER_BOLD = 1;
    static final int MARKER_COURIER = 0;
    static final int MARKER_HELVETICA = 4;
    static final int MARKER_ITALIC = 2;
    static final int MARKER_SYMBOL = 12;
    static final int MARKER_TIMES = 8;
    static final int VARIABLE_PITCH = 2;
    static final String[] fontNames = {"Courier", "Courier-Bold", "Courier-Oblique", "Courier-BoldOblique", "Helvetica", "Helvetica-Bold", "Helvetica-Oblique", "Helvetica-BoldOblique", "Times-Roman", "Times-Bold", "Times-Italic", "Times-BoldItalic", "Symbol", "ZapfDingbats"};
    static final int nameSize = 32;
    float angle;
    int bold;
    int charset;
    String faceName = "arial";
    BaseFont font = null;
    int height;
    int italic;
    int pitchAndFamily;
    boolean strikeout;
    boolean underline;

    public MetaFont() {
        this.type = 3;
    }

    public float getAngle() {
        return this.angle;
    }

    public BaseFont getFont() {
        String str;
        BaseFont baseFont = this.font;
        if (baseFont != null) {
            return baseFont;
        }
        BaseFont baseFont2 = FontFactory.getFont(this.faceName, "Cp1252", true, 10.0f, (this.italic != 0 ? 2 : 0) | (this.bold != 0 ? 1 : 0)).getBaseFont();
        this.font = baseFont2;
        if (baseFont2 != null) {
            return baseFont2;
        }
        if (this.faceName.indexOf("courier") != -1 || this.faceName.indexOf("terminal") != -1 || this.faceName.indexOf("fixedsys") != -1) {
            str = fontNames[this.italic + this.bold];
        } else if (this.faceName.indexOf("ms sans serif") != -1 || this.faceName.indexOf("arial") != -1 || this.faceName.indexOf("system") != -1) {
            str = fontNames[this.italic + 4 + this.bold];
        } else if (this.faceName.indexOf("arial black") != -1) {
            str = fontNames[this.italic + 5];
        } else if (this.faceName.indexOf("times") != -1 || this.faceName.indexOf("ms serif") != -1 || this.faceName.indexOf("roman") != -1) {
            str = fontNames[this.italic + 8 + this.bold];
        } else if (this.faceName.indexOf("symbol") != -1) {
            str = fontNames[12];
        } else {
            int i = this.pitchAndFamily;
            int i2 = i & 3;
            int i3 = (i >> 4) & 7;
            if (i3 == 1) {
                str = fontNames[this.italic + 8 + this.bold];
            } else if (i3 == 2) {
                str = fontNames[this.italic + 4 + this.bold];
            } else if (i3 != 3) {
                str = (i3 == 4 || i3 == 5 || i2 != 1) ? fontNames[this.italic + 4 + this.bold] : fontNames[this.italic + this.bold];
            } else {
                str = fontNames[this.italic + this.bold];
            }
        }
        try {
            BaseFont baseFontCreateFont = BaseFont.createFont(str, "Cp1252", false);
            this.font = baseFontCreateFont;
            return baseFontCreateFont;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public float getFontSize(MetaState metaState) {
        return Math.abs(metaState.transformY(this.height) - metaState.transformY(0)) * Document.wmfFontCorrection;
    }

    public void init(InputMeta inputMeta) {
        this.height = Math.abs(inputMeta.readShort());
        inputMeta.skip(2);
        this.angle = (float) ((((double) inputMeta.readShort()) / 1800.0d) * 3.141592653589793d);
        inputMeta.skip(2);
        this.bold = inputMeta.readShort() >= 600 ? 1 : 0;
        this.italic = inputMeta.readByte() == 0 ? 0 : 2;
        this.underline = inputMeta.readByte() != 0;
        this.strikeout = inputMeta.readByte() != 0;
        this.charset = inputMeta.readByte();
        inputMeta.skip(3);
        this.pitchAndFamily = inputMeta.readByte();
        byte[] bArr = new byte[32];
        int i = 0;
        while (i < 32) {
            int i2 = inputMeta.readByte();
            if (i2 == 0) {
                break;
            }
            bArr[i] = (byte) i2;
            i++;
        }
        try {
            this.faceName = new String(bArr, 0, i, "Cp1252");
        } catch (UnsupportedEncodingException unused) {
            this.faceName = new String(bArr, 0, i);
        }
        this.faceName = this.faceName.toLowerCase();
    }

    public boolean isStrikeout() {
        return this.strikeout;
    }

    public boolean isUnderline() {
        return this.underline;
    }
}
