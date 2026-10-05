package com.itextpdf.tool.xml;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.pdf.BaseFont;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class XMLWorkerFontProvider extends FontFactoryImp {
    public static final String DONTLOOKFORFONTS = "￼";
    protected HashMap<String, String> fontSubstitutionMap;
    protected boolean useUnicode;

    public XMLWorkerFontProvider() {
        this(null, null);
    }

    private Font getUnicodeFont(String str, String str2, float f, int i) {
        String str3;
        String str4;
        try {
            Font font = super.getFont(str, this.useUnicode ? BaseFont.IDENTITY_H : str2, true, f, i, null);
            if ((font != null ? font.getBaseFont() : null) != null || (str4 = this.fontSubstitutionMap.get(str)) == null || str4.length() <= 0) {
                return font;
            }
            return super.getFont(str4, this.useUnicode ? BaseFont.IDENTITY_H : str2, true, f, i, null);
        } catch (UnsupportedCharsetException unused) {
            Font font2 = super.getFont(str, str2, true, f, i, null);
            return ((font2 != null ? font2.getBaseFont() : null) != null || (str3 = this.fontSubstitutionMap.get(str)) == null || str3.length() <= 0) ? font2 : super.getFont(str3, str2, true, f, i, null);
        }
    }

    public void addFontSubstitute(String str, String str2) {
        this.fontSubstitutionMap.put(str, str2);
    }

    @Override // com.itextpdf.text.FontFactoryImp, com.itextpdf.text.FontProvider
    public Font getFont(String str, String str2, boolean z, float f, int i, BaseColor baseColor) {
        Font font = getFont(str, str2, f, i);
        font.setColor(baseColor);
        return font;
    }

    public void setUseUnicode(boolean z) {
        this.useUnicode = z;
    }

    public XMLWorkerFontProvider(String str) {
        this(str, null);
    }

    public XMLWorkerFontProvider(String str, HashMap<String, String> map) {
        this.fontSubstitutionMap = new HashMap<>();
        this.useUnicode = true;
        if (str != null && str.length() != 0) {
            if (!str.equals("￼")) {
                super.registerDirectory(str, true);
            }
        } else {
            super.registerDirectories();
        }
        if (map != null) {
            this.fontSubstitutionMap = map;
        }
    }

    @Override // com.itextpdf.text.FontFactoryImp
    public Font getFont(String str, String str2, float f, int i) {
        if (str == null) {
            return new Font(Font.FontFamily.UNDEFINED, f, i);
        }
        return getUnicodeFont(str, str2, f, i);
    }
}
