package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidPdfException;
import com.zebra.sdk.util.internal.StringUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseFont {
    public static final int ASCENT = 1;
    public static final int AWT_ASCENT = 9;
    public static final int AWT_DESCENT = 10;
    public static final int AWT_LEADING = 11;
    public static final int AWT_MAXADVANCE = 12;
    public static final int BBOXLLX = 5;
    public static final int BBOXLLY = 6;
    public static final int BBOXURX = 7;
    public static final int BBOXURY = 8;
    protected static final HashMap<String, PdfName> BuiltinFonts14;
    public static final boolean CACHED = true;
    public static final int CAPHEIGHT = 2;
    public static final char CID_NEWLINE = 32767;
    public static final String COURIER = "Courier";
    public static final String COURIER_BOLD = "Courier-Bold";
    public static final String COURIER_BOLDOBLIQUE = "Courier-BoldOblique";
    public static final String COURIER_OBLIQUE = "Courier-Oblique";
    public static final String CP1250 = "Cp1250";
    public static final String CP1252 = "Cp1252";
    public static final String CP1257 = "Cp1257";
    public static final int DESCENT = 3;
    public static final boolean EMBEDDED = true;
    public static final int FONT_TYPE_CJK = 2;
    public static final int FONT_TYPE_DOCUMENT = 4;
    public static final int FONT_TYPE_T1 = 0;
    public static final int FONT_TYPE_T3 = 5;
    public static final int FONT_TYPE_TT = 1;
    public static final int FONT_TYPE_TTUNI = 3;
    public static final int FONT_WEIGHT = 23;
    public static final String HELVETICA = "Helvetica";
    public static final String HELVETICA_BOLD = "Helvetica-Bold";
    public static final String HELVETICA_BOLDOBLIQUE = "Helvetica-BoldOblique";
    public static final String HELVETICA_OBLIQUE = "Helvetica-Oblique";
    public static final String IDENTITY_H = "Identity-H";
    public static final String IDENTITY_V = "Identity-V";
    public static final int ITALICANGLE = 4;
    public static final String MACROMAN = "MacRoman";
    public static final boolean NOT_CACHED = false;
    public static final boolean NOT_EMBEDDED = false;
    public static final char PARAGRAPH_SEPARATOR = 8233;
    public static final String RESOURCE_PATH = "com/itextpdf/text/pdf/fonts/";
    public static final int STRIKETHROUGH_POSITION = 15;
    public static final int STRIKETHROUGH_THICKNESS = 16;
    public static final int SUBSCRIPT_OFFSET = 18;
    public static final int SUBSCRIPT_SIZE = 17;
    public static final int SUPERSCRIPT_OFFSET = 20;
    public static final int SUPERSCRIPT_SIZE = 19;
    public static final String SYMBOL = "Symbol";
    public static final String TIMES_BOLD = "Times-Bold";
    public static final String TIMES_BOLDITALIC = "Times-BoldItalic";
    public static final String TIMES_ITALIC = "Times-Italic";
    public static final String TIMES_ROMAN = "Times-Roman";
    public static final int UNDERLINE_POSITION = 13;
    public static final int UNDERLINE_THICKNESS = 14;
    public static final int WEIGHT_CLASS = 21;
    public static final int WIDTH_CLASS = 22;
    public static final String WINANSI = "Cp1252";
    public static final String ZAPFDINGBATS = "ZapfDingbats";
    public static final String notdef = ".notdef";
    protected boolean embedded;
    protected String encoding;
    int fontType;
    protected IntHashtable specialMap;
    protected ArrayList<int[]> subsetRanges;
    public static final int[] CHAR_RANGE_LATIN = {0, 383, 8192, 8303, 8352, 8399, 64256, 64262};
    public static final int[] CHAR_RANGE_ARABIC = {0, ShapeTypes.VERTICAL_SCROLL, BOFRecord.VERSION, 1663, 8352, 8399, 64336, 64511, 65136, 65279};
    public static final int[] CHAR_RANGE_HEBREW = {0, ShapeTypes.VERTICAL_SCROLL, 1424, 1535, 8352, 8399, 64285, 64335};
    public static final int[] CHAR_RANGE_CYRILLIC = {0, ShapeTypes.VERTICAL_SCROLL, 1024, 1327, 8192, 8303, 8352, 8399};
    public static final double[] DEFAULT_FONT_MATRIX = {0.001d, 0.0d, 0.0d, 0.001d, 0.0d, 0.0d};
    protected static ConcurrentHashMap<String, BaseFont> fontCache = new ConcurrentHashMap<>();
    protected int[] widths = new int[256];
    protected String[] differences = new String[256];
    protected char[] unicodeDifferences = new char[256];
    protected int[][] charBBoxes = new int[256][];
    protected int compressionLevel = -1;
    protected boolean fontSpecific = true;
    protected boolean forceWidthsOutput = false;
    protected boolean directTextToByte = false;
    protected boolean subset = true;
    protected boolean fastWinansi = false;
    protected boolean vertical = false;

    static {
        HashMap<String, PdfName> map = new HashMap<>();
        BuiltinFonts14 = map;
        map.put("Courier", PdfName.COURIER);
        map.put("Courier-Bold", PdfName.COURIER_BOLD);
        map.put("Courier-BoldOblique", PdfName.COURIER_BOLDOBLIQUE);
        map.put("Courier-Oblique", PdfName.COURIER_OBLIQUE);
        map.put("Helvetica", PdfName.HELVETICA);
        map.put("Helvetica-Bold", PdfName.HELVETICA_BOLD);
        map.put("Helvetica-BoldOblique", PdfName.HELVETICA_BOLDOBLIQUE);
        map.put("Helvetica-Oblique", PdfName.HELVETICA_OBLIQUE);
        map.put("Symbol", PdfName.SYMBOL);
        map.put("Times-Roman", PdfName.TIMES_ROMAN);
        map.put("Times-Bold", PdfName.TIMES_BOLD);
        map.put("Times-BoldItalic", PdfName.TIMES_BOLDITALIC);
        map.put("Times-Italic", PdfName.TIMES_ITALIC);
        map.put("ZapfDingbats", PdfName.ZAPFDINGBATS);
    }

    private static void addFont(PRIndirectReference pRIndirectReference, IntHashtable intHashtable, ArrayList<Object[]> arrayList) {
        PdfObject pdfObject = PdfReader.getPdfObject(pRIndirectReference);
        if (pdfObject == null || !pdfObject.isDictionary()) {
            return;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        PdfName asName = pdfDictionary.getAsName(PdfName.SUBTYPE);
        if (PdfName.TYPE1.equals(asName) || PdfName.TRUETYPE.equals(asName) || PdfName.TYPE0.equals(asName)) {
            arrayList.add(new Object[]{PdfName.decodeName(pdfDictionary.getAsName(PdfName.BASEFONT).toString()), pRIndirectReference});
            intHashtable.put(pRIndirectReference.getNumber(), 1);
        }
    }

    public static BaseFont createFont() {
        return createFont("Helvetica", "Cp1252", false);
    }

    public static String createSubsetPrefix() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 6; i++) {
            sb.append((char) ((Math.random() * 26.0d) + 65.0d));
        }
        return ((Object) sb) + "+";
    }

    public static String[] enumerateTTCNames(String str) {
        return new EnumerateTTC(str).getNames();
    }

    public static Object[] getAllFontNames(String str, String str2, byte[] bArr) {
        String baseName = getBaseName(str);
        BaseFont trueTypeFont = (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) ? new TrueTypeFont(str, "Cp1252", false, bArr, true, false) : createFont(str, str2, false, false, bArr, null);
        return new Object[]{trueTypeFont.getPostscriptFontName(), trueTypeFont.getFamilyFontName(), trueTypeFont.getFullFontName()};
    }

    public static String[][] getAllNameEntries(String str, String str2, byte[] bArr) {
        String baseName = getBaseName(str);
        return ((baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) ? new TrueTypeFont(str, "Cp1252", false, bArr, true, false) : createFont(str, str2, false, false, bArr, null)).getAllNameEntries();
    }

    public static String getBaseName(String str) {
        if (str.endsWith(",Bold")) {
            return str.substring(0, str.length() - 5);
        }
        if (str.endsWith(",Italic")) {
            return str.substring(0, str.length() - 7);
        }
        return str.endsWith(",BoldItalic") ? str.substring(0, str.length() - 11) : str;
    }

    public static ArrayList<Object[]> getDocumentFonts(PdfReader pdfReader) {
        IntHashtable intHashtable = new IntHashtable();
        ArrayList<Object[]> arrayList = new ArrayList<>();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            recourseFonts(pdfReader.getPageN(i), intHashtable, arrayList, 1, new HashSet());
        }
        return arrayList;
    }

    public static String[][] getFullFontName(String str, String str2, byte[] bArr) {
        String baseName = getBaseName(str);
        return ((baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) ? new TrueTypeFont(str, "Cp1252", false, bArr, true, false) : createFont(str, str2, false, false, bArr, null)).getFullFontName();
    }

    public static String normalizeEncoding(String str) {
        if (str.equals("winansi") || str.equals("")) {
            return "Cp1252";
        }
        return str.equals("macroman") ? MACROMAN : str;
    }

    private static void recourseFonts(PdfDictionary pdfDictionary, IntHashtable intHashtable, ArrayList<Object[]> arrayList, int i, HashSet<PdfDictionary> hashSet) {
        PdfDictionary asDict;
        int i2 = i + 1;
        if (i2 > 50 || pdfDictionary == null || (asDict = pdfDictionary.getAsDict(PdfName.RESOURCES)) == null) {
            return;
        }
        PdfDictionary asDict2 = asDict.getAsDict(PdfName.FONT);
        if (asDict2 != null) {
            Iterator<PdfName> it = asDict2.getKeys().iterator();
            while (it.hasNext()) {
                PdfObject pdfObject = asDict2.get(it.next());
                if (pdfObject != null && pdfObject.isIndirect()) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                    if (!intHashtable.containsKey(pRIndirectReference.getNumber())) {
                        addFont(pRIndirectReference, intHashtable, arrayList);
                    }
                }
            }
        }
        PdfDictionary asDict3 = asDict.getAsDict(PdfName.XOBJECT);
        if (asDict3 != null) {
            if (!hashSet.add(asDict3)) {
                throw new ExceptionConverter(new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.resources.tree", new Object[0])));
            }
            Iterator<PdfName> it2 = asDict3.getKeys().iterator();
            while (it2.hasNext()) {
                PdfObject directObject = asDict3.getDirectObject(it2.next());
                if (directObject instanceof PdfDictionary) {
                    recourseFonts((PdfDictionary) directObject, intHashtable, arrayList, i2, hashSet);
                }
            }
            hashSet.remove(asDict3);
        }
    }

    public void addSubsetRange(int[] iArr) {
        if (this.subsetRanges == null) {
            this.subsetRanges = new ArrayList<>();
        }
        this.subsetRanges.add(iArr);
    }

    public boolean charExists(int i) {
        return convertToBytes(i).length > 0;
    }

    public byte[] convertToBytes(String str) {
        if (this.directTextToByte) {
            return PdfEncodings.convertToBytes(str, (String) null);
        }
        if (this.specialMap == null) {
            return PdfEncodings.convertToBytes(str, this.encoding);
        }
        byte[] bArr = new byte[str.length()];
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (this.specialMap.containsKey(cCharAt)) {
                bArr[i] = (byte) this.specialMap.get(cCharAt);
                i++;
            }
        }
        if (i >= length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    public void correctArabicAdvance() {
        for (char c = 1611; c <= 1624; c = (char) (c + 1)) {
            setCharAdvance(c, 0);
        }
        setCharAdvance(1648, 0);
        for (char c2 = 1750; c2 <= 1756; c2 = (char) (c2 + 1)) {
            setCharAdvance(c2, 0);
        }
        for (char c3 = 1759; c3 <= 1764; c3 = (char) (c3 + 1)) {
            setCharAdvance(c3, 0);
        }
        for (char c4 = 1767; c4 <= 1768; c4 = (char) (c4 + 1)) {
            setCharAdvance(c4, 0);
        }
        for (char c5 = 1770; c5 <= 1773; c5 = (char) (c5 + 1)) {
            setCharAdvance(c5, 0);
        }
    }

    public void createEncoding() {
        int i = 0;
        if (!this.encoding.startsWith("#")) {
            if (this.fontSpecific) {
                while (i < 256) {
                    this.widths[i] = getRawWidth(i, null);
                    this.charBBoxes[i] = getRawCharBBox(i, null);
                    i++;
                }
                return;
            }
            for (int i2 = 0; i2 < 256; i2++) {
                String strConvertToString = PdfEncodings.convertToString(new byte[]{(byte) i2}, this.encoding);
                char cCharAt = strConvertToString.length() > 0 ? strConvertToString.charAt(0) : '?';
                String strUnicodeToName = GlyphList.unicodeToName(cCharAt);
                if (strUnicodeToName == null) {
                    strUnicodeToName = notdef;
                }
                this.differences[i2] = strUnicodeToName;
                this.unicodeDifferences[i2] = cCharAt;
                this.widths[i2] = getRawWidth(cCharAt, strUnicodeToName);
                this.charBBoxes[i2] = getRawCharBBox(cCharAt, strUnicodeToName);
            }
            return;
        }
        this.specialMap = new IntHashtable();
        StringTokenizer stringTokenizer = new StringTokenizer(this.encoding.substring(1), " ,\t\n\r\f");
        if (stringTokenizer.nextToken().equals("full")) {
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                String strNextToken2 = stringTokenizer.nextToken();
                char c = (char) Integer.parseInt(stringTokenizer.nextToken(), 16);
                int iCharAt = (strNextToken.startsWith("'") ? strNextToken.charAt(1) : Integer.parseInt(strNextToken)) % 256;
                this.specialMap.put(c, iCharAt);
                this.differences[iCharAt] = strNextToken2;
                this.unicodeDifferences[iCharAt] = c;
                this.widths[iCharAt] = getRawWidth(c, strNextToken2);
                this.charBBoxes[iCharAt] = getRawCharBBox(c, strNextToken2);
            }
        } else {
            int i3 = stringTokenizer.hasMoreTokens() ? Integer.parseInt(stringTokenizer.nextToken()) : 0;
            while (stringTokenizer.hasMoreTokens() && i3 < 256) {
                int i4 = Integer.parseInt(stringTokenizer.nextToken(), 16) % 65536;
                String strUnicodeToName2 = GlyphList.unicodeToName(i4);
                if (strUnicodeToName2 != null) {
                    this.specialMap.put(i4, i3);
                    this.differences[i3] = strUnicodeToName2;
                    this.unicodeDifferences[i3] = (char) i4;
                    this.widths[i3] = getRawWidth(i4, strUnicodeToName2);
                    this.charBBoxes[i3] = getRawCharBBox(i4, strUnicodeToName2);
                    i3++;
                }
            }
        }
        while (i < 256) {
            String[] strArr = this.differences;
            if (strArr[i] == null) {
                strArr[i] = notdef;
            }
            i++;
        }
    }

    public abstract String[][] getAllNameEntries();

    public int getAscent(String str) {
        int i;
        int i2 = 0;
        for (char c : str.toCharArray()) {
            int[] charBBox = getCharBBox(c);
            if (charBBox != null && (i = charBBox[3]) > i2) {
                i2 = i;
            }
        }
        return i2;
    }

    public float getAscentPoint(String str, float f) {
        return getAscent(str) * 0.001f * f;
    }

    public int[] getCharBBox(int i) {
        byte[] bArrConvertToBytes = convertToBytes(i);
        if (bArrConvertToBytes.length == 0) {
            return null;
        }
        return this.charBBoxes[bArrConvertToBytes[0] & UnsignedBytes.MAX_VALUE];
    }

    public int getCidCode(int i) {
        return i;
    }

    public String[] getCodePagesSupported() {
        return new String[0];
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public int getDescent(String str) {
        int i;
        int i2 = 0;
        for (char c : str.toCharArray()) {
            int[] charBBox = getCharBBox(c);
            if (charBBox != null && (i = charBBox[1]) < i2) {
                i2 = i;
            }
        }
        return i2;
    }

    public float getDescentPoint(String str, float f) {
        return getDescent(str) * 0.001f * f;
    }

    public String[] getDifferences() {
        return this.differences;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public abstract String[][] getFamilyFontName();

    public abstract float getFontDescriptor(int i, float f);

    public double[] getFontMatrix() {
        return DEFAULT_FONT_MATRIX;
    }

    public int getFontType() {
        return this.fontType;
    }

    public abstract String[][] getFullFontName();

    public abstract PdfStream getFullFontStream();

    public abstract int getKerning(int i, int i2);

    public abstract String getPostscriptFontName();

    public abstract int[] getRawCharBBox(int i, String str);

    public abstract int getRawWidth(int i, String str);

    public String getSubfamily() {
        return "";
    }

    public char getUnicodeDifferences(int i) {
        return this.unicodeDifferences[i];
    }

    public int getUnicodeEquivalent(int i) {
        return i;
    }

    public int getWidth(int i) {
        if (this.fastWinansi) {
            return (i < 128 || (i >= 160 && i <= 255)) ? this.widths[i] : this.widths[PdfEncodings.winansi.get(i)];
        }
        int i2 = 0;
        for (byte b : convertToBytes(i)) {
            i2 += this.widths[b & UnsignedBytes.MAX_VALUE];
        }
        return i2;
    }

    public float getWidthPoint(String str, float f) {
        return getWidth(str) * 0.001f * f;
    }

    public float getWidthPointKerned(String str, float f) {
        float width = getWidth(str) * 0.001f * f;
        if (!hasKernPairs()) {
            return width;
        }
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        int i = 0;
        int kerning = 0;
        while (i < length) {
            char c = charArray[i];
            i++;
            kerning += getKerning(c, charArray[i]);
        }
        return width + (kerning * 0.001f * f);
    }

    public int[] getWidths() {
        return this.widths;
    }

    public abstract boolean hasKernPairs();

    public boolean isDirectTextToByte() {
        return this.directTextToByte;
    }

    public boolean isEmbedded() {
        return this.embedded;
    }

    public boolean isFontSpecific() {
        return this.fontSpecific;
    }

    public boolean isForceWidthsOutput() {
        return this.forceWidthsOutput;
    }

    public boolean isSubset() {
        return this.subset;
    }

    public boolean isVertical() {
        return this.vertical;
    }

    public boolean setCharAdvance(int i, int i2) {
        byte[] bArrConvertToBytes = convertToBytes(i);
        if (bArrConvertToBytes.length == 0) {
            return false;
        }
        this.widths[bArrConvertToBytes[0] & UnsignedBytes.MAX_VALUE] = i2;
        return true;
    }

    public void setCompressionLevel(int i) {
        if (i < 0 || i > 9) {
            this.compressionLevel = -1;
        } else {
            this.compressionLevel = i;
        }
    }

    public void setDirectTextToByte(boolean z) {
        this.directTextToByte = z;
    }

    public void setFontDescriptor(int i, float f) {
    }

    public void setForceWidthsOutput(boolean z) {
        this.forceWidthsOutput = z;
    }

    public abstract boolean setKerning(int i, int i2, int i3);

    public abstract void setPostscriptFontName(String str);

    public void setSubset(boolean z) {
        this.subset = z;
    }

    public abstract void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr);

    public static BaseFont createFont(String str, String str2, boolean z) {
        return createFont(str, str2, z, true, null, null, false);
    }

    public static String[] enumerateTTCNames(byte[] bArr) {
        return new EnumerateTTC(bArr).getNames();
    }

    public char[] getUnicodeDifferences() {
        return this.unicodeDifferences;
    }

    public float getWidthPoint(int i, float f) {
        return getWidth(i) * 0.001f * f;
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2) {
        return createFont(str, str2, z, true, null, null, z2);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2) {
        return createFont(str, str2, z, z2, bArr, bArr2, false);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, boolean z3) {
        return createFont(str, str2, z, z2, bArr, bArr2, z3, false);
    }

    public static ArrayList<Object[]> getDocumentFonts(PdfReader pdfReader, int i) {
        IntHashtable intHashtable = new IntHashtable();
        ArrayList<Object[]> arrayList = new ArrayList<>();
        recourseFonts(pdfReader.getPageN(i), intHashtable, arrayList, 1, new HashSet());
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0107  */
    /* JADX WARN: Code duplicated, block: B:56:0x0111 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x0112  */
    public static BaseFont createFont(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, boolean z3, boolean z4) throws DocumentException {
        boolean z5;
        BaseFont type1Font;
        BaseFont trueTypeFontUnicode;
        BaseFont baseFont;
        BaseFont baseFont2;
        String baseName = getBaseName(str);
        String strNormalizeEncoding = normalizeEncoding(str2);
        boolean zContainsKey = BuiltinFonts14.containsKey(str);
        boolean zIsCJKFont = zContainsKey ? false : CJKFont.isCJKFont(baseName, strNormalizeEncoding);
        if (zContainsKey || zIsCJKFont) {
            z5 = false;
        } else {
            z5 = (strNormalizeEncoding.equals(IDENTITY_H) || strNormalizeEncoding.equals(IDENTITY_V)) ? true : z;
        }
        String str3 = str + StringUtilities.LF + strNormalizeEncoding + StringUtilities.LF + z5;
        if (z2 && (baseFont2 = fontCache.get(str3)) != null) {
            return baseFont2;
        }
        if (!zContainsKey && !str.toLowerCase().endsWith(".afm") && !str.toLowerCase().endsWith(".pfm")) {
            if (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) {
                if (!strNormalizeEncoding.equals(IDENTITY_H) && !strNormalizeEncoding.equals(IDENTITY_V)) {
                    type1Font = new TrueTypeFont(str, strNormalizeEncoding, z5, bArr, false, z4);
                    type1Font.fastWinansi = strNormalizeEncoding.equals("Cp1252");
                } else {
                    trueTypeFontUnicode = new TrueTypeFontUnicode(str, strNormalizeEncoding, z5, bArr, z4);
                }
            } else {
                if (!zIsCJKFont) {
                    if (z3) {
                        return null;
                    }
                    throw new DocumentException(MessageLocalization.getComposedMessage("font.1.with.2.is.not.recognized", str, strNormalizeEncoding));
                }
                trueTypeFontUnicode = new CJKFont(str, strNormalizeEncoding, z5);
            }
            if (z2) {
                baseFont = fontCache.get(str3);
                if (baseFont != null) {
                    return baseFont;
                }
                fontCache.putIfAbsent(str3, trueTypeFontUnicode);
            }
            return trueTypeFontUnicode;
        }
        type1Font = new Type1Font(str, strNormalizeEncoding, z5, bArr, bArr2, z4);
        type1Font.fastWinansi = strNormalizeEncoding.equals("Cp1252");
        trueTypeFontUnicode = type1Font;
        if (z2) {
            baseFont = fontCache.get(str3);
            if (baseFont != null) {
                return baseFont;
            }
            fontCache.putIfAbsent(str3, trueTypeFontUnicode);
        }
        return trueTypeFontUnicode;
    }

    public static class StreamFont extends PdfStream {
        public StreamFont(byte[] bArr, int[] iArr, int i) throws DocumentException {
            try {
                this.bytes = bArr;
                put(PdfName.LENGTH, new PdfNumber(bArr.length));
                int i2 = 0;
                while (i2 < iArr.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Length");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    put(new PdfName(sb.toString()), new PdfNumber(iArr[i2]));
                    i2 = i3;
                }
                flateCompress(i);
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }

        public StreamFont(byte[] bArr, String str, int i) throws DocumentException {
            try {
                this.bytes = bArr;
                put(PdfName.LENGTH, new PdfNumber(bArr.length));
                if (str != null) {
                    put(PdfName.SUBTYPE, new PdfName(str));
                }
                flateCompress(i);
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }
    }

    public int getWidth(String str) {
        int i;
        int i2 = 0;
        if (this.fastWinansi) {
            int length = str.length();
            int i3 = 0;
            while (i2 < length) {
                char cCharAt = str.charAt(i2);
                if (cCharAt >= 128 && (cCharAt < 160 || cCharAt > 255)) {
                    i = this.widths[PdfEncodings.winansi.get(cCharAt)];
                } else {
                    i = this.widths[cCharAt];
                }
                i3 += i;
                i2++;
            }
            return i3;
        }
        byte[] bArrConvertToBytes = convertToBytes(str);
        int i4 = 0;
        while (i2 < bArrConvertToBytes.length) {
            i4 += this.widths[bArrConvertToBytes[i2] & UnsignedBytes.MAX_VALUE];
            i2++;
        }
        return i4;
    }

    public byte[] convertToBytes(int i) {
        if (this.directTextToByte) {
            return PdfEncodings.convertToBytes((char) i, (String) null);
        }
        IntHashtable intHashtable = this.specialMap;
        if (intHashtable != null) {
            if (intHashtable.containsKey(i)) {
                return new byte[]{(byte) this.specialMap.get(i)};
            }
            return new byte[0];
        }
        return PdfEncodings.convertToBytes((char) i, this.encoding);
    }

    public static BaseFont createFont(PRIndirectReference pRIndirectReference) {
        return new DocumentFont(pRIndirectReference);
    }
}
