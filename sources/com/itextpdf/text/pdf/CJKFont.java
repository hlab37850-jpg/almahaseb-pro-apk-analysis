package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCache;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidByte;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidUni;
import com.itextpdf.text.pdf.fonts.cmaps.CMapUniCid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
class CJKFont extends BaseFont {
    private static final int BRACKET = 1;
    static final String CJK_ENCODING = "UnicodeBigUnmarked";
    private static final int FIRST = 0;
    public static final String RESOURCE_PATH_CMAP = "com/itextpdf/text/pdf/fonts/cmaps/";
    private static final int SERIAL = 2;
    private static final int V1Y = 880;
    private String CMap;
    private CMapCidByte cidByte;
    private boolean cidDirect;
    private CMapCidUni cidUni;
    private HashMap<String, Object> fontDesc;
    private String fontName;
    private IntHashtable hMetrics;
    private String style;
    private CMapUniCid uniCid;
    private String uniMap;
    private IntHashtable vMetrics;
    static Properties cjkFonts = new Properties();
    static Properties cjkEncodings = new Properties();
    private static final HashMap<String, HashMap<String, Object>> allFonts = new HashMap<>();
    private static boolean propertiesLoaded = false;
    private static final HashMap<String, Set<String>> registryNames = new HashMap<>();

    public CJKFont(String str, String str2, boolean z) throws DocumentException {
        this.style = "";
        this.cidDirect = false;
        loadProperties();
        this.fontType = 2;
        String baseName = BaseFont.getBaseName(str);
        if (!isCJKFont(baseName, str2)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("font.1.with.2.encoding.is.not.a.cjk.font", str, str2));
        }
        if (baseName.length() < str.length()) {
            this.style = str.substring(baseName.length());
            str = baseName;
        }
        this.fontName = str;
        this.encoding = CJK_ENCODING;
        this.vertical = str2.endsWith("V");
        this.CMap = str2;
        if (str2.equals(BaseFont.IDENTITY_H) || str2.equals(BaseFont.IDENTITY_V)) {
            this.cidDirect = true;
        }
        loadCMaps();
    }

    public static String GetCompatibleFont(String str) {
        loadProperties();
        for (Map.Entry<String, Set<String>> entry : registryNames.entrySet()) {
            if (entry.getValue().contains(str)) {
                String key = entry.getKey();
                for (Map.Entry<String, HashMap<String, Object>> entry2 : allFonts.entrySet()) {
                    if (key.equals(entry2.getValue().get("Registry"))) {
                        return entry2.getKey();
                    }
                }
            }
        }
        return null;
    }

    public static String convertToHCIDMetrics(int[] iArr, IntHashtable intHashtable) {
        if (iArr.length == 0) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < iArr.length) {
            i2 = iArr[i];
            i3 = intHashtable.get(i2);
            if (i3 != 0) {
                i++;
                break;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(i2);
        char c = 0;
        while (i < iArr.length) {
            int i4 = iArr[i];
            int i5 = intHashtable.get(i4);
            if (i5 != 0) {
                if (c == 0) {
                    int i6 = i2 + 1;
                    if (i4 == i6 && i5 == i3) {
                        c = 2;
                    } else if (i4 == i6) {
                        sb.append('[');
                        sb.append(i3);
                        c = 1;
                    } else {
                        sb.append('[');
                        sb.append(i3);
                        sb.append(']');
                        sb.append(i4);
                    }
                } else if (c == 1) {
                    int i7 = i2 + 1;
                    if (i4 == i7 && i5 == i3) {
                        sb.append(']');
                        sb.append(i2);
                        c = 2;
                    } else if (i4 == i7) {
                        sb.append(' ');
                        sb.append(i3);
                    } else {
                        sb.append(' ');
                        sb.append(i3);
                        sb.append(']');
                        sb.append(i4);
                        c = 0;
                    }
                } else if (c == 2 && (i4 != i2 + 1 || i5 != i3)) {
                    sb.append(' ');
                    sb.append(i2);
                    sb.append(' ');
                    sb.append(i3);
                    sb.append(' ');
                    sb.append(i4);
                    c = 0;
                }
                i2 = i4;
                i3 = i5;
            }
            i++;
        }
        if (c == 0) {
            sb.append('[');
            sb.append(i3);
            sb.append("]]");
        } else if (c == 1) {
            sb.append(' ');
            sb.append(i3);
            sb.append("]]");
        } else if (c == 2) {
            sb.append(' ');
            sb.append(i2);
            sb.append(' ');
            sb.append(i3);
            sb.append(']');
        }
        return sb.toString();
    }

    public static String convertToVCIDMetrics(int[] iArr, IntHashtable intHashtable, IntHashtable intHashtable2) {
        if (iArr.length == 0) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < iArr.length) {
            i4 = iArr[i];
            i2 = intHashtable.get(i4);
            if (i2 != 0) {
                i++;
                break;
            }
            i3 = intHashtable2.get(i4);
            i++;
        }
        if (i2 == 0) {
            return null;
        }
        if (i3 == 0) {
            i3 = 1000;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(i4);
        char c = 0;
        while (i < iArr.length) {
            int i5 = iArr[i];
            int i6 = intHashtable.get(i5);
            if (i6 != 0) {
                int i7 = intHashtable2.get(i4);
                int i8 = i7 == 0 ? 1000 : i7;
                if (c != 0) {
                    if (c == 2 && (i5 != i4 + 1 || i6 != i2 || i8 != i3)) {
                        sb.append(' ');
                        sb.append(i4);
                        sb.append(' ');
                        sb.append(-i2);
                        sb.append(' ');
                        sb.append(i3 / 2);
                        sb.append(' ');
                        sb.append(V1Y);
                        sb.append(' ');
                        sb.append(i5);
                        c = 0;
                    }
                } else if (i5 == i4 + 1 && i6 == i2 && i8 == i3) {
                    c = 2;
                } else {
                    sb.append(' ');
                    sb.append(i4);
                    sb.append(' ');
                    sb.append(-i2);
                    sb.append(' ');
                    sb.append(i3 / 2);
                    sb.append(' ');
                    sb.append(V1Y);
                    sb.append(' ');
                    sb.append(i5);
                }
                i3 = i8;
                i4 = i5;
                i2 = i6;
            }
            i++;
        }
        sb.append(' ');
        sb.append(i4);
        sb.append(' ');
        sb.append(-i2);
        sb.append(' ');
        sb.append(i3 / 2);
        sb.append(' ');
        sb.append(V1Y);
        sb.append(" ]");
        return sb.toString();
    }

    public static IntHashtable createMetric(String str) {
        IntHashtable intHashtable = new IntHashtable();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            intHashtable.put(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }
        return intHashtable;
    }

    private float getBBox(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer((String) this.fontDesc.get("FontBBox"), " []\r\n\t\f");
        String strNextToken = stringTokenizer.nextToken();
        for (int i2 = 0; i2 < i; i2++) {
            strNextToken = stringTokenizer.nextToken();
        }
        return Integer.parseInt(strNextToken);
    }

    private PdfDictionary getCIDFont(PdfIndirectReference pdfIndirectReference, IntHashtable intHashtable) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.CIDFONTTYPE0);
        pdfDictionary.put(PdfName.BASEFONT, new PdfName(this.fontName + this.style));
        pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        int[] orderedKeys = intHashtable.toOrderedKeys();
        String strConvertToHCIDMetrics = convertToHCIDMetrics(orderedKeys, this.hMetrics);
        if (strConvertToHCIDMetrics != null) {
            pdfDictionary.put(PdfName.W, new PdfLiteral(strConvertToHCIDMetrics));
        }
        if (this.vertical) {
            String strConvertToVCIDMetrics = convertToVCIDMetrics(orderedKeys, this.vMetrics, this.hMetrics);
            if (strConvertToVCIDMetrics != null) {
                pdfDictionary.put(PdfName.W2, new PdfLiteral(strConvertToVCIDMetrics));
            }
        } else {
            pdfDictionary.put(PdfName.DW, new PdfNumber(1000));
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        if (this.cidDirect) {
            pdfDictionary2.put(PdfName.REGISTRY, new PdfString(this.cidUni.getRegistry(), null));
            pdfDictionary2.put(PdfName.ORDERING, new PdfString(this.cidUni.getOrdering(), null));
            pdfDictionary2.put(PdfName.SUPPLEMENT, new PdfNumber(this.cidUni.getSupplement()));
        } else {
            pdfDictionary2.put(PdfName.REGISTRY, new PdfString(this.cidByte.getRegistry(), null));
            pdfDictionary2.put(PdfName.ORDERING, new PdfString(this.cidByte.getOrdering(), null));
            pdfDictionary2.put(PdfName.SUPPLEMENT, new PdfNumber(this.cidByte.getSupplement()));
        }
        pdfDictionary.put(PdfName.CIDSYSTEMINFO, pdfDictionary2);
        return pdfDictionary;
    }

    private float getDescNumber(String str) {
        return Integer.parseInt((String) this.fontDesc.get(str));
    }

    private PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE0);
        String str = this.fontName;
        if (this.style.length() > 0) {
            str = str + "-" + this.style.substring(1);
        }
        pdfDictionary.put(PdfName.BASEFONT, new PdfName(str + "-" + this.CMap));
        pdfDictionary.put(PdfName.ENCODING, new PdfName(this.CMap));
        pdfDictionary.put(PdfName.DESCENDANTFONTS, new PdfArray(pdfIndirectReference));
        return pdfDictionary;
    }

    private PdfDictionary getFontDescriptor() {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfLiteral((String) this.fontDesc.get("Ascent")));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfLiteral((String) this.fontDesc.get("CapHeight")));
        pdfDictionary.put(PdfName.DESCENT, new PdfLiteral((String) this.fontDesc.get("Descent")));
        pdfDictionary.put(PdfName.FLAGS, new PdfLiteral((String) this.fontDesc.get("Flags")));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfLiteral((String) this.fontDesc.get("FontBBox")));
        pdfDictionary.put(PdfName.FONTNAME, new PdfName(this.fontName + this.style));
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfLiteral((String) this.fontDesc.get("ItalicAngle")));
        pdfDictionary.put(PdfName.STEMV, new PdfLiteral((String) this.fontDesc.get("StemV")));
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.put(PdfName.PANOSE, new PdfString((String) this.fontDesc.get("Panose"), null));
        pdfDictionary.put(PdfName.STYLE, pdfDictionary2);
        return pdfDictionary;
    }

    public static boolean isCJKFont(String str, String str2) {
        loadProperties();
        HashMap<String, Set<String>> map = registryNames;
        if (!map.containsKey("fonts") || !map.get("fonts").contains(str)) {
            return false;
        }
        if (str2.equals(BaseFont.IDENTITY_H) || str2.equals(BaseFont.IDENTITY_V)) {
            return true;
        }
        Set<String> set = map.get((String) allFonts.get(str).get("Registry"));
        return set != null && set.contains(str2);
    }

    private void loadCMaps() throws DocumentException {
        try {
            HashMap<String, Object> map = allFonts.get(this.fontName);
            this.fontDesc = map;
            this.hMetrics = (IntHashtable) map.get("W");
            this.vMetrics = (IntHashtable) this.fontDesc.get("W2");
            String str = (String) this.fontDesc.get("Registry");
            this.uniMap = "";
            for (String str2 : registryNames.get(str + "_Uni")) {
                this.uniMap = str2;
                if ((str2.endsWith("V") && this.vertical) || (!str2.endsWith("V") && !this.vertical)) {
                    break;
                    break;
                }
            }
            if (this.cidDirect) {
                this.cidUni = CMapCache.getCachedCMapCidUni(this.uniMap);
            } else {
                this.uniCid = CMapCache.getCachedCMapUniCid(this.uniMap);
                this.cidByte = CMapCache.getCachedCMapCidByte(this.CMap);
            }
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    }

    private static void loadProperties() {
        if (propertiesLoaded) {
            return;
        }
        synchronized (allFonts) {
            if (propertiesLoaded) {
                return;
            }
            try {
                loadRegistry();
                for (String str : registryNames.get("fonts")) {
                    allFonts.put(str, readFontProperties(str));
                }
            } catch (Exception unused) {
            }
            propertiesLoaded = true;
        }
    }

    private static void loadRegistry() throws IOException {
        InputStream resourceStream = StreamUtil.getResourceStream("com/itextpdf/text/pdf/fonts/cmaps/cjk_registry.properties");
        Properties properties = new Properties();
        properties.load(resourceStream);
        resourceStream.close();
        for (String str : properties.keySet()) {
            String[] strArrSplit = properties.getProperty(str).split(" ");
            HashSet hashSet = new HashSet();
            for (String str2 : strArrSplit) {
                if (str2.length() > 0) {
                    hashSet.add(str2);
                }
            }
            registryNames.put(str, hashSet);
        }
    }

    private static HashMap<String, Object> readFontProperties(String str) throws IOException {
        InputStream resourceStream = StreamUtil.getResourceStream(RESOURCE_PATH_CMAP + (str + ".properties"));
        Properties properties = new Properties();
        properties.load(resourceStream);
        resourceStream.close();
        IntHashtable intHashtableCreateMetric = createMetric(properties.getProperty("W"));
        properties.remove("W");
        IntHashtable intHashtableCreateMetric2 = createMetric(properties.getProperty("W2"));
        properties.remove("W2");
        HashMap<String, Object> map = new HashMap<>();
        Enumeration enumerationKeys = properties.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str2 = (String) enumerationKeys.nextElement();
            map.put(str2, properties.getProperty(str2));
        }
        map.put("W", intHashtableCreateMetric);
        map.put("W2", intHashtableCreateMetric2);
        return map;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean charExists(int i) {
        return this.cidDirect || this.cidByte.lookup(this.uniCid.lookup(i)).length > 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(String str) {
        int iCharAt;
        if (this.cidDirect) {
            return super.convertToBytes(str);
        }
        try {
            int i = 0;
            if (str.length() == 1) {
                return convertToBytes(str.charAt(0));
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (i < str.length()) {
                if (Utilities.isSurrogatePair(str, i)) {
                    iCharAt = Utilities.convertToUtf32(str, i);
                    i++;
                } else {
                    iCharAt = str.charAt(i);
                }
                byteArrayOutputStream.write(convertToBytes(iCharAt));
                i++;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.fontName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getCharBBox(int i) {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getCidCode(int i) {
        return this.cidDirect ? i : this.uniCid.lookup(i);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return getFullFontName();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.fontName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getKerning(int i, int i2) {
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getPostscriptFontName() {
        return this.fontName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getRawCharBBox(int i, String str) {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getRawWidth(int i, String str) {
        return 0;
    }

    public String getUniMap() {
        return this.uniMap;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getUnicodeEquivalent(int i) {
        if (!this.cidDirect) {
            return i;
        }
        if (i == 32767) {
            return 10;
        }
        return this.cidUni.lookup(i);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(int i) {
        if (!this.cidDirect) {
            i = this.uniCid.lookup(i);
        }
        int i2 = this.vertical ? this.vMetrics.get(i) : this.hMetrics.get(i);
        if (i2 > 0) {
            return i2;
        }
        return 1000;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return false;
    }

    public boolean isIdentity() {
        return this.cidDirect;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setCharAdvance(int i, int i2) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
        this.fontName = str;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) {
        IntHashtable intHashtable = (IntHashtable) objArr[0];
        PdfDictionary fontDescriptor = getFontDescriptor();
        PdfIndirectReference indirectReference = fontDescriptor != null ? pdfWriter.addToBody(fontDescriptor).getIndirectReference() : null;
        PdfDictionary cIDFont = getCIDFont(indirectReference, intHashtable);
        if (cIDFont != null) {
            indirectReference = pdfWriter.addToBody(cIDFont).getIndirectReference();
        }
        pdfWriter.addToBody(getFontBaseType(indirectReference), pdfIndirectReference);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(String str) {
        int width;
        int iCharAt;
        int i = 0;
        if (this.cidDirect) {
            width = 0;
            while (i < str.length()) {
                width += getWidth(str.charAt(i));
                i++;
            }
        } else {
            width = 0;
            while (i < str.length()) {
                if (Utilities.isSurrogatePair(str, i)) {
                    iCharAt = Utilities.convertToUtf32(str, i);
                    i++;
                } else {
                    iCharAt = str.charAt(i);
                }
                width += getWidth(iCharAt);
                i++;
            }
        }
        return width;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(int i) {
        if (this.cidDirect) {
            return super.convertToBytes(i);
        }
        return this.cidByte.lookup(this.uniCid.lookup(i));
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        float bBox;
        switch (i) {
            case 1:
            case 9:
                return (getDescNumber("Ascent") * f) / 1000.0f;
            case 2:
                return (getDescNumber("CapHeight") * f) / 1000.0f;
            case 3:
            case 10:
                return (getDescNumber("Descent") * f) / 1000.0f;
            case 4:
                return getDescNumber("ItalicAngle");
            case 5:
                bBox = getBBox(0);
                break;
            case 6:
                bBox = getBBox(1);
                break;
            case 7:
                bBox = getBBox(2);
                break;
            case 8:
                bBox = getBBox(3);
                break;
            case 11:
            default:
                return 0.0f;
            case 12:
                bBox = getBBox(2) - getBBox(0);
                break;
        }
        return (f * bBox) / 1000.0f;
    }
}
