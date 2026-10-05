package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.fonts.otf.Language;
import com.itextpdf.text.pdf.languages.BanglaGlyphRepositioner;
import com.itextpdf.text.pdf.languages.GlyphRepositioner;
import com.itextpdf.text.pdf.languages.IndicCompositeCharacterComparator;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
class FontDetails {
    BaseFont baseFont;
    CJKFont cjkFont;
    IntHashtable cjkTag;
    PdfName fontName;
    int fontType;
    PdfIndirectReference indirectReference;
    HashMap<Integer, int[]> longTag;
    byte[] shortTag;
    protected boolean subset = true;
    boolean symbolic;
    TrueTypeFontUnicode ttu;

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.FontDetails$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$fonts$otf$Language;

        static {
            int[] iArr = new int[Language.values().length];
            $SwitchMap$com$itextpdf$text$pdf$fonts$otf$Language = iArr;
            try {
                iArr[Language.BENGALI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public FontDetails(PdfName pdfName, PdfIndirectReference pdfIndirectReference, BaseFont baseFont) {
        this.fontName = pdfName;
        this.indirectReference = pdfIndirectReference;
        this.baseFont = baseFont;
        int fontType = baseFont.getFontType();
        this.fontType = fontType;
        if (fontType == 0 || fontType == 1) {
            this.shortTag = new byte[256];
            return;
        }
        if (fontType == 2) {
            this.cjkTag = new IntHashtable();
            this.cjkFont = (CJKFont) baseFont;
        } else {
            if (fontType != 3) {
                return;
            }
            this.longTag = new HashMap<>();
            this.ttu = (TrueTypeFontUnicode) baseFont;
            this.symbolic = baseFont.isFontSpecific();
        }
    }

    private boolean canApplyGlyphSubstitution() {
        return this.fontType == 3 && this.ttu.getGlyphSubstitutionMap() != null;
    }

    private byte[] convertToBytesAfterGlyphSubstitution(String str) {
        if (!canApplyGlyphSubstitution()) {
            throw new IllegalArgumentException("Make sure the font type if TTF Unicode and a valid GlyphSubstitutionTable exists!");
        }
        Map<String, Glyph> glyphSubstitutionMap = this.ttu.getGlyphSubstitutionMap();
        TreeSet treeSet = new TreeSet(new IndicCompositeCharacterComparator());
        treeSet.addAll(glyphSubstitutionMap.keySet());
        String[] strArr = new ArrayBasedStringTokenizer((String[]) treeSet.toArray(new String[0])).tokenize(str);
        ArrayList arrayList = new ArrayList(50);
        for (String str2 : strArr) {
            Glyph glyph = glyphSubstitutionMap.get(str2);
            if (glyph != null) {
                arrayList.add(glyph);
            } else {
                for (char c : str2.toCharArray()) {
                    int[] metricsTT = this.ttu.getMetricsTT(c);
                    arrayList.add(new Glyph(metricsTT[0], metricsTT[1], String.valueOf(c)));
                }
            }
        }
        GlyphRepositioner glyphRepositioner = getGlyphRepositioner();
        if (glyphRepositioner != null) {
            glyphRepositioner.repositionGlyphs(arrayList);
        }
        char[] cArr = new char[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Glyph glyph2 = arrayList.get(i);
            int i2 = glyph2.code;
            cArr[i] = (char) i2;
            Integer numValueOf = Integer.valueOf(i2);
            if (!this.longTag.containsKey(numValueOf)) {
                this.longTag.put(numValueOf, new int[]{glyph2.code, glyph2.width, glyph2.chars.charAt(0)});
            }
        }
        return new String(cArr).getBytes("UnicodeBigUnmarked");
    }

    private GlyphRepositioner getGlyphRepositioner() {
        Language supportedLanguage = this.ttu.getSupportedLanguage();
        if (supportedLanguage != null) {
            if (AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$fonts$otf$Language[supportedLanguage.ordinal()] != 1) {
                return null;
            }
            return new BanglaGlyphRepositioner(Collections.unmodifiableMap(this.ttu.cmap31), this.ttu.getGlyphSubstitutionMap());
        }
        throw new IllegalArgumentException("The supported language field cannot be null in " + this.ttu.getClass().getName());
    }

    public byte[] convertToBytes(String str) {
        int iCharAt;
        int i;
        int iCharAt2;
        int i2 = this.fontType;
        if (i2 == 0 || i2 == 1) {
            byte[] bArrConvertToBytes = this.baseFont.convertToBytes(str);
            for (byte b : bArrConvertToBytes) {
                this.shortTag[b & UnsignedBytes.MAX_VALUE] = 1;
            }
            return bArrConvertToBytes;
        }
        if (i2 == 2) {
            int length = str.length();
            if (this.cjkFont.isIdentity()) {
                for (int i3 = 0; i3 < length; i3++) {
                    this.cjkTag.put(str.charAt(i3), 0);
                }
            } else {
                int i4 = 0;
                while (i4 < length) {
                    if (Utilities.isSurrogatePair(str, i4)) {
                        iCharAt = Utilities.convertToUtf32(str, i4);
                        i4++;
                    } else {
                        iCharAt = str.charAt(i4);
                    }
                    this.cjkTag.put(this.cjkFont.getCidCode(iCharAt), 0);
                    i4++;
                }
            }
            return this.cjkFont.convertToBytes(str);
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return this.baseFont.convertToBytes(str);
            }
            if (i2 != 5) {
                return null;
            }
            return this.baseFont.convertToBytes(str);
        }
        try {
            int length2 = str.length();
            char[] cArr = new char[length2];
            if (this.symbolic) {
                byte[] bArrConvertToBytes2 = PdfEncodings.convertToBytes(str, "symboltt");
                int length3 = bArrConvertToBytes2.length;
                i = 0;
                for (int i5 = 0; i5 < length3; i5++) {
                    int[] metricsTT = this.ttu.getMetricsTT(bArrConvertToBytes2[i5] & UnsignedBytes.MAX_VALUE);
                    if (metricsTT != null) {
                        this.longTag.put(Integer.valueOf(metricsTT[0]), new int[]{metricsTT[0], metricsTT[1], this.ttu.getUnicodeDifferences(bArrConvertToBytes2[i5] & UnsignedBytes.MAX_VALUE)});
                        cArr[i] = (char) metricsTT[0];
                        i++;
                    }
                }
            } else {
                if (canApplyGlyphSubstitution()) {
                    return convertToBytesAfterGlyphSubstitution(str);
                }
                int i6 = 0;
                i = 0;
                while (i6 < length2) {
                    if (Utilities.isSurrogatePair(str, i6)) {
                        iCharAt2 = Utilities.convertToUtf32(str, i6);
                        i6++;
                    } else {
                        iCharAt2 = str.charAt(i6);
                    }
                    int[] metricsTT2 = this.ttu.getMetricsTT(iCharAt2);
                    if (metricsTT2 != null) {
                        int i7 = metricsTT2[0];
                        Integer numValueOf = Integer.valueOf(i7);
                        if (!this.longTag.containsKey(numValueOf)) {
                            this.longTag.put(numValueOf, new int[]{i7, metricsTT2[1], iCharAt2});
                        }
                        cArr[i] = (char) i7;
                        i++;
                    }
                    i6++;
                }
            }
            return StringUtils.convertCharsToBytes(Utilities.copyOfRange(cArr, 0, i));
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public Object[] convertToBytesGid(String str) {
        if (this.fontType != 3) {
            throw new IllegalArgumentException("GID require TT Unicode");
        }
        try {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (char c : str.toCharArray()) {
                int glyphWidth = this.ttu.getGlyphWidth(c);
                i += glyphWidth;
                int iGetCharFromGlyphId = this.ttu.GetCharFromGlyphId(c);
                if (iGetCharFromGlyphId != 0) {
                    sb.append(Utilities.convertFromUtf32(iGetCharFromGlyphId));
                }
                Integer numValueOf = Integer.valueOf(c);
                if (!this.longTag.containsKey(numValueOf)) {
                    this.longTag.put(numValueOf, new int[]{c, glyphWidth, iGetCharFromGlyphId});
                }
            }
            return new Object[]{str.getBytes("UnicodeBigUnmarked"), sb.toString(), Integer.valueOf(i)};
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public BaseFont getBaseFont() {
        return this.baseFont;
    }

    public PdfName getFontName() {
        return this.fontName;
    }

    public PdfIndirectReference getIndirectReference() {
        return this.indirectReference;
    }

    public boolean isSubset() {
        return this.subset;
    }

    public void setSubset(boolean z) {
        this.subset = z;
    }

    public void writeFont(PdfWriter pdfWriter) {
        try {
            int i = this.fontType;
            if (i != 0 && i != 1) {
                if (i == 2) {
                    this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{this.cjkTag});
                    return;
                } else if (i == 3) {
                    this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{this.longTag, Boolean.valueOf(this.subset)});
                    return;
                } else {
                    if (i != 5) {
                        return;
                    }
                    this.baseFont.writeFont(pdfWriter, this.indirectReference, null);
                    return;
                }
            }
            int i2 = 0;
            while (i2 < 256 && this.shortTag[i2] == 0) {
                i2++;
            }
            int i3 = 255;
            int i4 = 255;
            while (i4 >= i2 && this.shortTag[i4] == 0) {
                i4--;
            }
            if (i2 > 255) {
                i2 = 255;
            } else {
                i3 = i4;
            }
            this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.shortTag, Boolean.valueOf(this.subset)});
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
