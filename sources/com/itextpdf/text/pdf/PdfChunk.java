package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.SplitCharacter;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PdfChunk {
    private static final float ITALIC_ANGLE = 0.21256f;
    private static final String TABSTOP = "TABSTOP";
    public static final float UNDERLINE_OFFSET = -0.33333334f;
    public static final float UNDERLINE_THICKNESS = 0.06666667f;
    private static final HashSet<String> keysAttributes;
    private static final HashSet<String> keysNoStroke;
    private static final char[] singleSpace = {' '};
    protected IAccessibleElement accessibleElement;
    protected HashMap<String, Object> attributes;
    protected BaseFont baseFont;
    protected boolean changeLeading;
    protected String encoding;
    protected PdfFont font;
    protected Image image;
    protected float imageScalePercentage;
    protected float leading;
    protected boolean newlineSplit;
    protected HashMap<String, Object> noStroke;
    protected float offsetX;
    protected float offsetY;
    protected SplitCharacter splitCharacter;
    protected String value;

    static {
        HashSet<String> hashSet = new HashSet<>();
        keysAttributes = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        keysNoStroke = hashSet2;
        hashSet.add(Chunk.ACTION);
        hashSet.add(Chunk.UNDERLINE);
        hashSet.add(Chunk.REMOTEGOTO);
        hashSet.add(Chunk.LOCALGOTO);
        hashSet.add(Chunk.LOCALDESTINATION);
        hashSet.add(Chunk.GENERICTAG);
        hashSet.add(Chunk.NEWPAGE);
        hashSet.add(Chunk.IMAGE);
        hashSet.add(Chunk.BACKGROUND);
        hashSet.add(Chunk.PDFANNOTATION);
        hashSet.add(Chunk.SKEW);
        hashSet.add(Chunk.HSCALE);
        hashSet.add(Chunk.SEPARATOR);
        hashSet.add(Chunk.TAB);
        hashSet.add(Chunk.TABSETTINGS);
        hashSet.add(Chunk.CHAR_SPACING);
        hashSet.add(Chunk.WORD_SPACING);
        hashSet.add(Chunk.LINEHEIGHT);
        hashSet2.add(Chunk.SUBSUPSCRIPT);
        hashSet2.add(Chunk.SPLITCHARACTER);
        hashSet2.add(Chunk.HYPHENATION);
        hashSet2.add(Chunk.TEXTRENDERMODE);
    }

    public PdfChunk(String str, PdfChunk pdfChunk) {
        this.value = "";
        this.encoding = "Cp1252";
        this.attributes = new HashMap<>();
        this.noStroke = new HashMap<>();
        this.imageScalePercentage = 1.0f;
        this.changeLeading = false;
        this.leading = 0.0f;
        this.accessibleElement = null;
        this.value = str;
        this.font = pdfChunk.font;
        HashMap<String, Object> map = pdfChunk.attributes;
        this.attributes = map;
        this.noStroke = pdfChunk.noStroke;
        this.baseFont = pdfChunk.baseFont;
        this.changeLeading = pdfChunk.changeLeading;
        this.leading = pdfChunk.leading;
        Object[] objArr = (Object[]) map.get(Chunk.IMAGE);
        if (objArr == null) {
            this.image = null;
        } else {
            this.image = (Image) objArr[0];
            this.offsetX = ((Float) objArr[1]).floatValue();
            this.offsetY = ((Float) objArr[2]).floatValue();
            this.changeLeading = ((Boolean) objArr[3]).booleanValue();
        }
        this.encoding = this.font.getFont().getEncoding();
        SplitCharacter splitCharacter = (SplitCharacter) this.noStroke.get(Chunk.SPLITCHARACTER);
        this.splitCharacter = splitCharacter;
        if (splitCharacter == null) {
            this.splitCharacter = DefaultSplitCharacter.DEFAULT;
        }
        this.accessibleElement = pdfChunk.accessibleElement;
    }

    public static TabStop getTabStop(PdfChunk pdfChunk, float f) {
        Object[] objArr = (Object[]) pdfChunk.attributes.get(Chunk.TAB);
        if (objArr == null) {
            return null;
        }
        Float f2 = (Float) objArr[0];
        return Float.isNaN(f2.floatValue()) ? TabSettings.getTabStopNewInstance(f, (TabSettings) pdfChunk.attributes.get(Chunk.TABSETTINGS)) : TabStop.newInstance(f, f2.floatValue());
    }

    public static boolean noPrint(int i) {
        return (i >= 8203 && i <= 8207) || (i >= 8234 && i <= 8238) || i == 173;
    }

    @Deprecated
    public void adjustLeft(float f) {
        Object[] objArr = (Object[]) this.attributes.get(Chunk.TAB);
        if (objArr != null) {
            this.attributes.put(Chunk.TAB, new Object[]{objArr[0], objArr[1], objArr[2], new Float(f)});
        }
    }

    public boolean changeLeading() {
        return this.changeLeading;
    }

    public BaseColor color() {
        return (BaseColor) this.noStroke.get(Chunk.COLOR);
    }

    public PdfFont font() {
        return this.font;
    }

    public Object getAttribute(String str) {
        return this.attributes.containsKey(str) ? this.attributes.get(str) : this.noStroke.get(str);
    }

    public float getCharWidth(int i) {
        if (noPrint(i)) {
            return 0.0f;
        }
        if (isAttribute(Chunk.CHAR_SPACING)) {
            return this.font.width(i) + (((Float) getAttribute(Chunk.CHAR_SPACING)).floatValue() * this.font.getHorizontalScaling());
        }
        return isImage() ? getImageWidth() : this.font.width(i);
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Image getImage() {
        return this.image;
    }

    public float getImageHeight() {
        return this.image.getScaledHeight() * this.imageScalePercentage;
    }

    public float getImageOffsetX() {
        return this.offsetX;
    }

    public float getImageOffsetY() {
        return this.offsetY;
    }

    public float getImageScalePercentage() {
        return this.imageScalePercentage;
    }

    public float getImageWidth() {
        return this.image.getScaledWidth() * this.imageScalePercentage;
    }

    public float getLeading() {
        return this.leading;
    }

    public float getTextRise() {
        Float f = (Float) getAttribute(Chunk.SUBSUPSCRIPT);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public int getUnicodeEquivalent(int i) {
        return this.baseFont.getUnicodeEquivalent(i);
    }

    public float getWidthCorrected(float f, float f2) {
        Image image = this.image;
        if (image != null) {
            return image.getScaledWidth() + f;
        }
        int i = 0;
        int iIndexOf = -1;
        while (true) {
            iIndexOf = this.value.indexOf(32, iIndexOf + 1);
            if (iIndexOf < 0) {
                return this.font.width(this.value) + (this.value.length() * f) + (i * f2);
            }
            i++;
        }
    }

    public int getWord(String str, int i) {
        int length = str.length();
        while (i < length && Character.isLetter(str.charAt(i))) {
            i++;
        }
        return i;
    }

    public float height() {
        return isImage() ? getImageHeight() : this.font.size();
    }

    public boolean isAttribute(String str) {
        if (this.attributes.containsKey(str)) {
            return true;
        }
        return this.noStroke.containsKey(str);
    }

    public boolean isExtSplitCharacter(int i, int i2, int i3, char[] cArr, PdfChunk[] pdfChunkArr) {
        return this.splitCharacter.isSplitCharacter(i, i2, i3, cArr, pdfChunkArr);
    }

    public boolean isHorizontalSeparator() {
        if (isAttribute(Chunk.SEPARATOR)) {
            return !((Boolean) ((Object[]) getAttribute(Chunk.SEPARATOR))[1]).booleanValue();
        }
        return false;
    }

    public boolean isImage() {
        return this.image != null;
    }

    public boolean isNewlineSplit() {
        return this.newlineSplit;
    }

    public boolean isSeparator() {
        return isAttribute(Chunk.SEPARATOR);
    }

    public boolean isSpecialEncoding() {
        return this.encoding.equals("UnicodeBigUnmarked") || this.encoding.equals(BaseFont.IDENTITY_H);
    }

    public boolean isStroked() {
        return !this.attributes.isEmpty();
    }

    public boolean isTab() {
        return isAttribute(Chunk.TAB);
    }

    public int length() {
        return this.value.length();
    }

    public int lengthUtf32() {
        if (!BaseFont.IDENTITY_H.equals(this.encoding)) {
            return this.value.length();
        }
        int length = this.value.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (Utilities.isSurrogateHigh(this.value.charAt(i))) {
                i++;
            }
            i2++;
            i++;
        }
        return i2;
    }

    public void setImageOffsetX(float f) {
        this.offsetX = f;
    }

    public void setImageOffsetY(float f) {
        this.offsetY = f;
    }

    public void setImageScalePercentage(float f) {
        this.imageScalePercentage = f;
    }

    public void setTabStop(TabStop tabStop) {
        this.attributes.put(TABSTOP, tabStop);
    }

    public void setValue(String str) {
        this.value = str;
    }

    public PdfChunk split(float f) {
        int i;
        float f2;
        int i2;
        int i3;
        int i4;
        int word;
        float f3;
        int i5;
        int i6 = 0;
        this.newlineSplit = false;
        Image image = this.image;
        if (image != null) {
            if (image.getScaledWidth() <= f) {
                return null;
            }
            PdfChunk pdfChunk = new PdfChunk("￼", this);
            this.value = "";
            this.attributes = new HashMap<>();
            this.image = null;
            this.font = PdfFont.getDefaultFont();
            return pdfChunk;
        }
        HyphenationEvent hyphenationEvent = (HyphenationEvent) this.noStroke.get(Chunk.HYPHENATION);
        int length = this.value.length();
        char[] charArray = this.value.toCharArray();
        BaseFont font = this.font.getFont();
        float f4 = 0.0f;
        int i7 = -1;
        char c = '\n';
        if (font.getFontType() != 2 || font.getUnicodeEquivalent(32) == 32) {
            float f5 = 0.0f;
            i = 0;
            int i8 = -1;
            while (true) {
                if (i >= length) {
                    f2 = f5;
                    i2 = i8;
                    break;
                }
                char c2 = charArray[i];
                if (c2 == '\r' || c2 == '\n') {
                    this.newlineSplit = true;
                    String strSubstring = this.value.substring(((c2 == '\r' && (i3 = i + 1) < length && charArray[i3] == '\n') ? 2 : 1) + i);
                    String strSubstring2 = this.value.substring(0, i);
                    this.value = strSubstring2;
                    if (strSubstring2.length() < 1) {
                        this.value = " ";
                    }
                    return new PdfChunk(strSubstring, this);
                }
                boolean zIsSurrogatePair = Utilities.isSurrogatePair(charArray, i);
                float charWidth = f4 + (zIsSurrogatePair ? getCharWidth(Utilities.convertToUtf32(charArray[i], charArray[i + 1])) : getCharWidth(c2));
                if (c2 == ' ') {
                    i4 = i + 1;
                    f5 = charWidth;
                } else {
                    i4 = i7;
                }
                if (zIsSurrogatePair) {
                    i++;
                }
                int i9 = i;
                if (charWidth > f) {
                    f2 = f5;
                    i2 = i8;
                    i7 = i4;
                    i = i9;
                    break;
                }
                if (this.splitCharacter.isSplitCharacter(0, i9, length, charArray, null)) {
                    i8 = i9 + 1;
                }
                i = i9 + 1;
                f4 = charWidth;
                i7 = i4;
            }
        } else {
            f2 = 0.0f;
            i = 0;
            i2 = -1;
            while (i < length) {
                char c3 = charArray[i];
                char unicodeEquivalent = (char) font.getUnicodeEquivalent(c3);
                if (unicodeEquivalent == c) {
                    this.newlineSplit = true;
                    String strSubstring3 = this.value.substring(i + 1);
                    String strSubstring4 = this.value.substring(i6, i);
                    this.value = strSubstring4;
                    if (strSubstring4.length() < 1) {
                        this.value = "\u0001";
                    }
                    return new PdfChunk(strSubstring3, this);
                }
                float charWidth2 = getCharWidth(c3) + f4;
                if (unicodeEquivalent == ' ') {
                    f3 = charWidth2;
                    i5 = i + 1;
                } else {
                    f3 = f2;
                    i5 = i7;
                }
                if (charWidth2 > f) {
                    f2 = f3;
                    i7 = i5;
                    break;
                }
                SplitCharacter splitCharacter = this.splitCharacter;
                PdfChunk[] pdfChunkArr = new PdfChunk[1];
                pdfChunkArr[i6] = this;
                int i10 = i;
                if (splitCharacter.isSplitCharacter(0, i, length, charArray, pdfChunkArr)) {
                    i2 = i10 + 1;
                }
                i = i10 + 1;
                f4 = charWidth2;
                f2 = f3;
                i7 = i5;
                i6 = 0;
                c = '\n';
            }
        }
        if (i == length) {
            return null;
        }
        if (i2 < 0) {
            String str = this.value;
            this.value = "";
            return new PdfChunk(str, this);
        }
        if (i7 > i2 && this.splitCharacter.isSplitCharacter(0, 0, 1, singleSpace, null)) {
            i2 = i7;
        }
        if (hyphenationEvent != null && i7 >= 0 && i7 < i && (word = getWord(this.value, i7)) > i7) {
            String hyphenatedWordPre = hyphenationEvent.getHyphenatedWordPre(this.value.substring(i7, word), this.font.getFont(), this.font.size(), f - f2);
            String hyphenatedWordPost = hyphenationEvent.getHyphenatedWordPost();
            if (hyphenatedWordPre.length() > 0) {
                String str2 = hyphenatedWordPost + this.value.substring(word);
                this.value = trim(this.value.substring(0, i7) + hyphenatedWordPre);
                return new PdfChunk(str2, this);
            }
        }
        String strSubstring5 = this.value.substring(i2);
        this.value = trim(this.value.substring(0, i2));
        return new PdfChunk(strSubstring5, this);
    }

    public String toString() {
        return this.value;
    }

    public String trim(String str) {
        BaseFont font = this.font.getFont();
        if (font.getFontType() != 2 || font.getUnicodeEquivalent(32) == 32) {
            while (true) {
                if (!str.endsWith(" ") && !str.endsWith("\t")) {
                    break;
                }
                str = str.substring(0, str.length() - 1);
            }
        } else {
            while (str.endsWith("\u0001")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public float trimFirstSpace() {
        BaseFont font = this.font.getFont();
        if (font.getFontType() != 2 || font.getUnicodeEquivalent(32) == 32) {
            if (this.value.length() <= 1 || !this.value.startsWith(" ")) {
                return 0.0f;
            }
            this.value = this.value.substring(1);
            return this.font.width(32);
        }
        if (this.value.length() <= 1 || !this.value.startsWith("\u0001")) {
            return 0.0f;
        }
        this.value = this.value.substring(1);
        return this.font.width(1);
    }

    public float trimLastSpace() {
        BaseFont font = this.font.getFont();
        if (font.getFontType() != 2 || font.getUnicodeEquivalent(32) == 32) {
            if (this.value.length() <= 1 || !this.value.endsWith(" ")) {
                return 0.0f;
            }
            String str = this.value;
            this.value = str.substring(0, str.length() - 1);
            return this.font.width(32);
        }
        if (this.value.length() <= 1 || !this.value.endsWith("\u0001")) {
            return 0.0f;
        }
        String str2 = this.value;
        this.value = str2.substring(0, str2.length() - 1);
        return this.font.width(1);
    }

    public PdfChunk truncate(float f) {
        Image image = this.image;
        if (image != null) {
            if (image.getScaledWidth() <= f) {
                return null;
            }
            if (this.image.isScaleToFitLineWhenOverflow()) {
                setImageScalePercentage(f / this.image.getWidth());
                return null;
            }
            PdfChunk pdfChunk = new PdfChunk("", this);
            this.value = "";
            this.attributes.remove(Chunk.IMAGE);
            this.image = null;
            this.font = PdfFont.getDefaultFont();
            return pdfChunk;
        }
        int i = 1;
        if (f < this.font.width()) {
            String strSubstring = this.value.substring(1);
            this.value = this.value.substring(0, 1);
            return new PdfChunk(strSubstring, this);
        }
        int length = this.value.length();
        float charWidth = 0.0f;
        int i2 = 0;
        boolean zIsSurrogatePair = false;
        while (i2 < length) {
            zIsSurrogatePair = Utilities.isSurrogatePair(this.value, i2);
            charWidth += zIsSurrogatePair ? getCharWidth(Utilities.convertToUtf32(this.value, i2)) : getCharWidth(this.value.charAt(i2));
            if (charWidth > f) {
                break;
            }
            if (zIsSurrogatePair) {
                i2++;
            }
            i2++;
        }
        if (i2 == length) {
            return null;
        }
        if (i2 != 0) {
            i = i2;
        } else if (zIsSurrogatePair) {
            i = 2;
        }
        String strSubstring2 = this.value.substring(i);
        this.value = this.value.substring(0, i);
        return new PdfChunk(strSubstring2, this);
    }

    public float width() {
        return width(this.value);
    }

    public float width(String str) {
        if (isAttribute(Chunk.SEPARATOR)) {
            return 0.0f;
        }
        if (isImage()) {
            return getImageWidth();
        }
        float fWidth = this.font.width(str);
        if (isAttribute(Chunk.CHAR_SPACING)) {
            fWidth += str.length() * ((Float) getAttribute(Chunk.CHAR_SPACING)).floatValue();
        }
        if (!isAttribute(Chunk.WORD_SPACING)) {
            return fWidth;
        }
        int i = 0;
        int iIndexOf = -1;
        while (true) {
            iIndexOf = str.indexOf(32, iIndexOf + 1);
            if (iIndexOf < 0) {
                return fWidth + (i * ((Float) getAttribute(Chunk.WORD_SPACING)).floatValue());
            }
            i++;
        }
    }

    public TabStop getTabStop() {
        return (TabStop) this.attributes.get(TABSTOP);
    }

    public PdfChunk(Chunk chunk, PdfAction pdfAction) {
        this.value = "";
        this.encoding = "Cp1252";
        this.attributes = new HashMap<>();
        this.noStroke = new HashMap<>();
        this.imageScalePercentage = 1.0f;
        this.changeLeading = false;
        this.leading = 0.0f;
        this.accessibleElement = null;
        this.value = chunk.getContent();
        Font font = chunk.getFont();
        float size = font.getSize();
        size = size == -1.0f ? 12.0f : size;
        this.baseFont = font.getBaseFont();
        int style = font.getStyle();
        style = style == -1 ? 0 : style;
        if (this.baseFont == null) {
            this.baseFont = font.getCalculatedBaseFont(false);
        } else {
            if ((style & 1) != 0) {
                this.attributes.put(Chunk.TEXTRENDERMODE, new Object[]{2, new Float(size / 30.0f), null});
            }
            if ((style & 2) != 0) {
                this.attributes.put(Chunk.SKEW, new float[]{0.0f, ITALIC_ANGLE});
            }
        }
        this.font = new PdfFont(this.baseFont, size);
        HashMap<String, Object> attributes = chunk.getAttributes();
        if (attributes != null) {
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                String key = entry.getKey();
                if (keysAttributes.contains(key)) {
                    this.attributes.put(key, entry.getValue());
                } else if (keysNoStroke.contains(key)) {
                    this.noStroke.put(key, entry.getValue());
                }
            }
            if ("".equals(attributes.get(Chunk.GENERICTAG))) {
                this.attributes.put(Chunk.GENERICTAG, chunk.getContent());
            }
        }
        if (font.isUnderlined()) {
            this.attributes.put(Chunk.UNDERLINE, Utilities.addToArray((Object[][]) this.attributes.get(Chunk.UNDERLINE), new Object[]{null, new float[]{0.0f, 0.06666667f, 0.0f, -0.33333334f, 0.0f}}));
        }
        if (font.isStrikethru()) {
            this.attributes.put(Chunk.UNDERLINE, Utilities.addToArray((Object[][]) this.attributes.get(Chunk.UNDERLINE), new Object[]{null, new float[]{0.0f, 0.06666667f, 0.0f, 0.33333334f, 0.0f}}));
        }
        if (pdfAction != null) {
            this.attributes.put(Chunk.ACTION, pdfAction);
        }
        this.noStroke.put(Chunk.COLOR, font.getColor());
        this.noStroke.put(Chunk.ENCODING, this.font.getFont().getEncoding());
        Float f = (Float) this.attributes.get(Chunk.LINEHEIGHT);
        if (f != null) {
            this.changeLeading = true;
            this.leading = f.floatValue();
        }
        Object[] objArr = (Object[]) this.attributes.get(Chunk.IMAGE);
        if (objArr != null) {
            this.attributes.remove(Chunk.HSCALE);
            this.image = (Image) objArr[0];
            this.offsetX = ((Float) objArr[1]).floatValue();
            this.offsetY = ((Float) objArr[2]).floatValue();
            this.changeLeading = ((Boolean) objArr[3]).booleanValue();
        } else {
            this.image = null;
        }
        Float f2 = (Float) this.attributes.get(Chunk.HSCALE);
        if (f2 != null) {
            this.font.setHorizontalScaling(f2.floatValue());
        }
        this.encoding = this.font.getFont().getEncoding();
        SplitCharacter splitCharacter = (SplitCharacter) this.noStroke.get(Chunk.SPLITCHARACTER);
        this.splitCharacter = splitCharacter;
        if (splitCharacter == null) {
            this.splitCharacter = DefaultSplitCharacter.DEFAULT;
        }
        this.accessibleElement = chunk;
    }

    public PdfChunk(Chunk chunk, PdfAction pdfAction, TabSettings tabSettings) {
        this(chunk, pdfAction);
        if (tabSettings == null || this.attributes.get(Chunk.TABSETTINGS) != null) {
            return;
        }
        this.attributes.put(Chunk.TABSETTINGS, tabSettings);
    }
}
