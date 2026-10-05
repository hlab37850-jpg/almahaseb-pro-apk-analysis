package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.fonts.cmaps.CMapParserEx;
import com.itextpdf.text.pdf.fonts.cmaps.CMapToUnicode;
import com.itextpdf.text.pdf.fonts.cmaps.CidLocationFromByte;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentFont extends BaseFont {
    private static final int[] stdEnc = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 33, 34, 35, 36, 37, 38, 8217, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 8216, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ShapeTypes.ACTION_BUTTON_BLANK, ShapeTypes.ACTION_BUTTON_HOME, ShapeTypes.ACTION_BUTTON_HELP, 8260, ShapeTypes.ACTION_BUTTON_FORWARD_NEXT, TypedValues.CycleType.TYPE_VISIBILITY, ShapeTypes.ACTION_BUTTON_END, 164, 39, 8220, ShapeTypes.ACTION_BUTTON_SOUND, 8249, 8250, 64257, 64258, 0, 8211, 8224, 8225, ShapeTypes.SQUARE_TABS, 0, ShapeTypes.CORNER_TABS, 8226, 8218, 8222, 8221, ShapeTypes.CHART_PLUS, 8230, 8240, 0, 191, 0, 96, ShapeTypes.MATH_EQUAL, 710, 732, ShapeTypes.FUNNEL, 728, 729, ShapeTypes.ACTION_BUTTON_BEGINNING, 0, 730, ShapeTypes.PLAQUE_TABS, 0, 733, 731, 711, 8212, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 198, 0, ShapeTypes.ACTION_BUTTON_DOCUMENT, 0, 0, 0, 0, TIFFConstants.TIFFTAG_HALFTONEHINTS, 216, TIFFConstants.TIFFTAG_EXTRASAMPLES, ShapeTypes.CHART_STAR, 0, 0, 0, 0, 0, 230, 0, 0, 0, 305, 0, 0, 322, 248, TIFFConstants.TIFFTAG_SAMPLEFORMAT, 223, 0, 0, 0, 0};
    private float ascender;
    private IntHashtable byte2uni;
    private float capHeight;
    protected String cjkEncoding;
    private BaseFont cjkMirror;
    protected int defaultWidth;
    private float descender;
    private IntHashtable diffmap;
    private PdfDictionary font;
    private String fontName;
    private float fontWeight;
    private IntHashtable hMetrics;
    protected boolean isType0;
    private float italicAngle;
    private float llx;
    private float lly;
    private HashMap<Integer, int[]> metrics;
    private PRIndirectReference refFont;
    private IntHashtable uni2byte;
    protected String uniMap;
    private float urx;
    private float ury;

    public DocumentFont(PdfDictionary pdfDictionary) {
        this.metrics = new HashMap<>();
        this.uni2byte = new IntHashtable();
        this.byte2uni = new IntHashtable();
        this.ascender = 800.0f;
        this.capHeight = 700.0f;
        this.descender = -200.0f;
        this.italicAngle = 0.0f;
        this.fontWeight = 0.0f;
        this.llx = -50.0f;
        this.lly = -200.0f;
        this.urx = 100.0f;
        this.ury = 900.0f;
        this.isType0 = false;
        this.defaultWidth = 1000;
        this.refFont = null;
        this.font = pdfDictionary;
        init();
    }

    private String decodeString(PdfString pdfString) {
        return pdfString.isHexWriting() ? PdfEncodings.convertToString(pdfString.getBytes(), "UnicodeBigUnmarked") : pdfString.toUnicodeString();
    }

    private void doType1TT() {
        PdfObject pdfObject = PdfReader.getPdfObject(this.font.get(PdfName.ENCODING));
        if (pdfObject == null) {
            PdfName asName = this.font.getAsName(PdfName.BASEFONT);
            if (BaseFont.BuiltinFonts14.containsKey(this.fontName) && (PdfName.SYMBOL.equals(asName) || PdfName.ZAPFDINGBATS.equals(asName))) {
                fillEncoding(asName);
            } else {
                fillEncoding(null);
            }
            try {
                CMapToUnicode cMapToUnicodeProcessToUnicode = processToUnicode();
                if (cMapToUnicodeProcessToUnicode != null) {
                    for (Map.Entry<Integer, Integer> entry : cMapToUnicodeProcessToUnicode.createReverseMapping().entrySet()) {
                        this.uni2byte.put(entry.getKey().intValue(), entry.getValue().intValue());
                        this.byte2uni.put(entry.getValue().intValue(), entry.getKey().intValue());
                    }
                }
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else if (pdfObject.isName()) {
            fillEncoding((PdfName) pdfObject);
        } else if (pdfObject.isDictionary()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            PdfObject pdfObject2 = PdfReader.getPdfObject(pdfDictionary.get(PdfName.BASEENCODING));
            if (pdfObject2 == null) {
                fillEncoding(null);
            } else {
                fillEncoding((PdfName) pdfObject2);
            }
            fillDiffMap(pdfDictionary, null);
        }
        if (BaseFont.BuiltinFonts14.containsKey(this.fontName)) {
            try {
                BaseFont baseFontCreateFont = BaseFont.createFont(this.fontName, "Cp1252", false);
                int[] orderedKeys = this.uni2byte.toOrderedKeys();
                for (int i = 0; i < orderedKeys.length; i++) {
                    int i2 = this.uni2byte.get(orderedKeys[i]);
                    this.widths[i2] = baseFontCreateFont.getRawWidth(i2, GlyphList.unicodeToName(orderedKeys[i]));
                }
                IntHashtable intHashtable = this.diffmap;
                if (intHashtable != null) {
                    int[] orderedKeys2 = intHashtable.toOrderedKeys();
                    for (int i3 = 0; i3 < orderedKeys2.length; i3++) {
                        int i4 = this.diffmap.get(orderedKeys2[i3]);
                        this.widths[i4] = baseFontCreateFont.getRawWidth(i4, GlyphList.unicodeToName(orderedKeys2[i3]));
                    }
                    this.diffmap = null;
                }
                this.ascender = baseFontCreateFont.getFontDescriptor(1, 1000.0f);
                this.capHeight = baseFontCreateFont.getFontDescriptor(2, 1000.0f);
                this.descender = baseFontCreateFont.getFontDescriptor(3, 1000.0f);
                this.italicAngle = baseFontCreateFont.getFontDescriptor(4, 1000.0f);
                this.fontWeight = baseFontCreateFont.getFontDescriptor(23, 1000.0f);
                this.llx = baseFontCreateFont.getFontDescriptor(5, 1000.0f);
                this.lly = baseFontCreateFont.getFontDescriptor(6, 1000.0f);
                this.urx = baseFontCreateFont.getFontDescriptor(7, 1000.0f);
                this.ury = baseFontCreateFont.getFontDescriptor(8, 1000.0f);
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
        fillWidths();
        fillFontDesc(this.font.getAsDict(PdfName.FONTDESCRIPTOR));
    }

    private void fillDiffMap(PdfDictionary pdfDictionary, CMapToUnicode cMapToUnicode) {
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.DIFFERENCES);
        if (asArray != null) {
            this.diffmap = new IntHashtable();
            int iIntValue = 0;
            for (int i = 0; i < asArray.size(); i++) {
                PdfObject pdfObject = asArray.getPdfObject(i);
                if (pdfObject.isNumber()) {
                    iIntValue = ((PdfNumber) pdfObject).intValue();
                } else {
                    int[] iArrNameToUnicode = GlyphList.nameToUnicode(PdfName.decodeName(((PdfName) pdfObject).toString()));
                    if (iArrNameToUnicode == null || iArrNameToUnicode.length <= 0) {
                        if (cMapToUnicode == null && (cMapToUnicode = processToUnicode()) == null) {
                            cMapToUnicode = new CMapToUnicode();
                        }
                        String strLookup = cMapToUnicode.lookup(new byte[]{(byte) iIntValue}, 0, 1);
                        if (strLookup != null && strLookup.length() == 1) {
                            this.uni2byte.put(strLookup.charAt(0), iIntValue);
                            this.byte2uni.put(iIntValue, strLookup.charAt(0));
                            this.diffmap.put(strLookup.charAt(0), iIntValue);
                        }
                    } else {
                        this.uni2byte.put(iArrNameToUnicode[0], iIntValue);
                        this.byte2uni.put(iIntValue, iArrNameToUnicode[0]);
                        this.diffmap.put(iArrNameToUnicode[0], iIntValue);
                    }
                    iIntValue++;
                }
            }
        }
    }

    private void fillEncoding(PdfName pdfName) {
        String str;
        int i = 0;
        if (pdfName == null && isSymbolic()) {
            while (i < 256) {
                this.uni2byte.put(i, i);
                this.byte2uni.put(i, i);
                i++;
            }
            return;
        }
        if (!PdfName.MAC_ROMAN_ENCODING.equals(pdfName) && !PdfName.WIN_ANSI_ENCODING.equals(pdfName) && !PdfName.SYMBOL.equals(pdfName) && !PdfName.ZAPFDINGBATS.equals(pdfName)) {
            while (i < 256) {
                IntHashtable intHashtable = this.uni2byte;
                int[] iArr = stdEnc;
                intHashtable.put(iArr[i], i);
                this.byte2uni.put(i, iArr[i]);
                i++;
            }
            return;
        }
        byte[] bArr = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr[i2] = (byte) i2;
        }
        if (PdfName.MAC_ROMAN_ENCODING.equals(pdfName)) {
            str = BaseFont.MACROMAN;
        } else if (PdfName.SYMBOL.equals(pdfName)) {
            str = "Symbol";
        } else {
            str = PdfName.ZAPFDINGBATS.equals(pdfName) ? "ZapfDingbats" : "Cp1252";
        }
        char[] charArray = PdfEncodings.convertToString(bArr, str).toCharArray();
        while (i < 256) {
            this.uni2byte.put(charArray[i], i);
            this.byte2uni.put(i, charArray[i]);
            i++;
        }
        this.encoding = str;
    }

    private void fillFontDesc(PdfDictionary pdfDictionary) {
        if (pdfDictionary == null) {
            return;
        }
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.ASCENT);
        if (asNumber != null) {
            this.ascender = asNumber.floatValue();
        }
        PdfNumber asNumber2 = pdfDictionary.getAsNumber(PdfName.CAPHEIGHT);
        if (asNumber2 != null) {
            this.capHeight = asNumber2.floatValue();
        }
        PdfNumber asNumber3 = pdfDictionary.getAsNumber(PdfName.DESCENT);
        if (asNumber3 != null) {
            this.descender = asNumber3.floatValue();
        }
        PdfNumber asNumber4 = pdfDictionary.getAsNumber(PdfName.ITALICANGLE);
        if (asNumber4 != null) {
            this.italicAngle = asNumber4.floatValue();
        }
        PdfNumber asNumber5 = pdfDictionary.getAsNumber(PdfName.FONTWEIGHT);
        if (asNumber5 != null) {
            this.fontWeight = asNumber5.floatValue();
        }
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.FONTBBOX);
        if (asArray != null) {
            this.llx = asArray.getAsNumber(0).floatValue();
            this.lly = asArray.getAsNumber(1).floatValue();
            this.urx = asArray.getAsNumber(2).floatValue();
            float fFloatValue = asArray.getAsNumber(3).floatValue();
            this.ury = fFloatValue;
            float f = this.llx;
            float f2 = this.urx;
            if (f > f2) {
                this.llx = f2;
                this.urx = f;
            }
            float f3 = this.lly;
            if (f3 > fFloatValue) {
                this.lly = fFloatValue;
                this.ury = f3;
            }
        }
        float fMax = Math.max(this.ury, this.ascender);
        float fMin = Math.min(this.lly, this.descender);
        float f4 = fMax * 1000.0f;
        float f5 = fMax - fMin;
        this.ascender = f4 / f5;
        this.descender = (fMin * 1000.0f) / f5;
    }

    private void fillMetrics(byte[] bArr, IntHashtable intHashtable, int i) {
        try {
            PdfContentParser pdfContentParser = new PdfContentParser(new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(bArr))));
            int i2 = 50;
            boolean z = true;
            int i3 = 0;
            while (true) {
                if (!z && i3 <= 0) {
                    return;
                }
                try {
                    PdfObject pRObject = pdfContentParser.readPRObject();
                    if (pRObject == null) {
                        return;
                    }
                    if (pRObject.type() == 200) {
                        if (pRObject.toString().equals("begin")) {
                            i3++;
                            z = false;
                        } else if (pRObject.toString().equals("end")) {
                            i3--;
                        } else if (pRObject.toString().equals("beginbfchar")) {
                            while (true) {
                                PdfObject pRObject2 = pdfContentParser.readPRObject();
                                if (pRObject2.toString().equals("endbfchar")) {
                                    break;
                                }
                                String strDecodeString = decodeString((PdfString) pRObject2);
                                String strDecodeString2 = decodeString((PdfString) pdfContentParser.readPRObject());
                                if (strDecodeString2.length() == 1) {
                                    int iCharAt = strDecodeString.charAt(0);
                                    this.metrics.put(Integer.valueOf(strDecodeString2.charAt(strDecodeString2.length() - 1)), new int[]{iCharAt, intHashtable.containsKey(iCharAt) ? intHashtable.get(iCharAt) : i});
                                }
                            }
                        } else if (pRObject.toString().equals("beginbfrange")) {
                            while (true) {
                                PdfObject pRObject3 = pdfContentParser.readPRObject();
                                if (pRObject3.toString().equals("endbfrange")) {
                                    break;
                                }
                                String strDecodeString3 = decodeString((PdfString) pRObject3);
                                String strDecodeString4 = decodeString((PdfString) pdfContentParser.readPRObject());
                                int iCharAt2 = strDecodeString3.charAt(0);
                                char cCharAt = strDecodeString4.charAt(0);
                                PdfObject pRObject4 = pdfContentParser.readPRObject();
                                if (pRObject4.isString()) {
                                    String strDecodeString5 = decodeString((PdfString) pRObject4);
                                    if (strDecodeString5.length() == 1) {
                                        int iCharAt3 = strDecodeString5.charAt(strDecodeString5.length() - 1);
                                        while (iCharAt2 <= cCharAt) {
                                            this.metrics.put(Integer.valueOf(iCharAt3), new int[]{iCharAt2, intHashtable.containsKey(iCharAt2) ? intHashtable.get(iCharAt2) : i});
                                            iCharAt2++;
                                            iCharAt3++;
                                        }
                                    }
                                } else {
                                    PdfArray pdfArray = (PdfArray) pRObject4;
                                    int i4 = 0;
                                    while (i4 < pdfArray.size()) {
                                        String strDecodeString6 = decodeString(pdfArray.getAsString(i4));
                                        if (strDecodeString6.length() == 1) {
                                            this.metrics.put(Integer.valueOf(strDecodeString6.charAt(strDecodeString6.length() - 1)), new int[]{iCharAt2, intHashtable.containsKey(iCharAt2) ? intHashtable.get(iCharAt2) : i});
                                        }
                                        i4++;
                                        iCharAt2++;
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                    i2--;
                    if (i2 < 0) {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private void fillMetricsIdentity(IntHashtable intHashtable, int i) {
        for (int i2 = 0; i2 < 65536; i2++) {
            this.metrics.put(Integer.valueOf(i2), new int[]{i2, intHashtable.containsKey(i2) ? intHashtable.get(i2) : i});
        }
    }

    private void fillWidths() {
        PdfArray asArray = this.font.getAsArray(PdfName.WIDTHS);
        PdfNumber asNumber = this.font.getAsNumber(PdfName.FIRSTCHAR);
        PdfNumber asNumber2 = this.font.getAsNumber(PdfName.LASTCHAR);
        if (asNumber == null || asNumber2 == null || asArray == null) {
            return;
        }
        int iIntValue = asNumber.intValue();
        int size = asArray.size() + iIntValue;
        int[] iArr = this.widths;
        if (iArr.length < size) {
            int[] iArr2 = new int[size];
            System.arraycopy(iArr, 0, iArr2, 0, iIntValue);
            this.widths = iArr2;
        }
        for (int i = 0; i < asArray.size(); i++) {
            this.widths[iIntValue + i] = asArray.getAsNumber(i).intValue();
        }
    }

    private void init() {
        this.encoding = "";
        this.fontSpecific = false;
        this.fontType = 4;
        PdfName asName = this.font.getAsName(PdfName.BASEFONT);
        this.fontName = asName != null ? PdfName.decodeName(asName.toString()) : "Unspecified Font Name";
        PdfName asName2 = this.font.getAsName(PdfName.SUBTYPE);
        if (PdfName.TYPE1.equals(asName2) || PdfName.TRUETYPE.equals(asName2)) {
            doType1TT();
            return;
        }
        if (PdfName.TYPE3.equals(asName2)) {
            fillEncoding(null);
            fillDiffMap(this.font.getAsDict(PdfName.ENCODING), null);
            fillWidths();
            return;
        }
        PdfName asName3 = this.font.getAsName(PdfName.ENCODING);
        if (asName3 != null) {
            String strDecodeName = PdfName.decodeName(asName3.toString());
            String strGetCompatibleFont = CJKFont.GetCompatibleFont(strDecodeName);
            if (strGetCompatibleFont != null) {
                try {
                    BaseFont baseFontCreateFont = BaseFont.createFont(strGetCompatibleFont, strDecodeName, false);
                    this.cjkMirror = baseFontCreateFont;
                    this.cjkEncoding = strDecodeName;
                    this.uniMap = ((CJKFont) baseFontCreateFont).getUniMap();
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            }
            if (PdfName.TYPE0.equals(asName2)) {
                this.isType0 = true;
                if (strDecodeName.equals(BaseFont.IDENTITY_H) || this.cjkMirror == null) {
                    processType0(this.font);
                    return;
                }
                PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(((PdfArray) PdfReader.getPdfObjectRelease(this.font.get(PdfName.DESCENDANTFONTS))).getPdfObject(0));
                PdfNumber pdfNumber = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.DW));
                if (pdfNumber != null) {
                    this.defaultWidth = pdfNumber.intValue();
                }
                this.hMetrics = readWidths((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.W)));
                fillFontDesc((PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FONTDESCRIPTOR)));
            }
        }
    }

    private CMapToUnicode processToUnicode() {
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(this.font.get(PdfName.TOUNICODE));
        if (!(pdfObjectRelease instanceof PRStream)) {
            return null;
        }
        try {
            CidLocationFromByte cidLocationFromByte = new CidLocationFromByte(PdfReader.getStreamBytes((PRStream) pdfObjectRelease));
            CMapToUnicode cMapToUnicode = new CMapToUnicode();
            CMapParserEx.parseCid("", cMapToUnicode, cidLocationFromByte);
            return cMapToUnicode;
        } catch (Exception unused) {
            return null;
        }
    }

    private void processType0(PdfDictionary pdfDictionary) {
        try {
            PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TOUNICODE));
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.DESCENDANTFONTS))).getPdfObject(0));
            PdfNumber pdfNumber = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.DW));
            int iIntValue = pdfNumber != null ? pdfNumber.intValue() : 1000;
            IntHashtable widths = readWidths((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.W)));
            fillFontDesc((PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.FONTDESCRIPTOR)));
            if (pdfObjectRelease instanceof PRStream) {
                fillMetrics(PdfReader.getStreamBytes((PRStream) pdfObjectRelease), widths, iIntValue);
            } else if (new PdfName(BaseFont.IDENTITY_H).equals(pdfObjectRelease)) {
                fillMetricsIdentity(widths, iIntValue);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private IntHashtable readWidths(PdfArray pdfArray) {
        IntHashtable intHashtable = new IntHashtable();
        if (pdfArray == null) {
            return intHashtable;
        }
        int i = 0;
        while (i < pdfArray.size()) {
            int iIntValue = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i))).intValue();
            int i2 = i + 1;
            PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i2));
            if (pdfObjectRelease.isArray()) {
                PdfArray pdfArray2 = (PdfArray) pdfObjectRelease;
                int i3 = 0;
                while (i3 < pdfArray2.size()) {
                    intHashtable.put(iIntValue, ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray2.getPdfObject(i3))).intValue());
                    i3++;
                    iIntValue++;
                }
            } else {
                int iIntValue2 = ((PdfNumber) pdfObjectRelease).intValue();
                int i4 = i + 2;
                int iIntValue3 = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i4))).intValue();
                while (iIntValue <= iIntValue2) {
                    intHashtable.put(iIntValue, iIntValue3);
                    iIntValue++;
                }
                i2 = i4;
            }
            i = i2 + 1;
        }
        return intHashtable;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean charExists(int i) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.charExists(i);
        }
        return this.isType0 ? this.metrics.containsKey(Integer.valueOf(i)) : super.charExists(i);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(String str) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.convertToBytes(str);
        }
        if (!this.isType0) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            byte[] bArr = new byte[length];
            int i = 0;
            for (int i2 = 0; i2 < charArray.length; i2++) {
                if (this.uni2byte.containsKey(charArray[i2])) {
                    bArr[i] = (byte) this.uni2byte.get(charArray[i2]);
                    i++;
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
        char[] charArray2 = str.toCharArray();
        int length2 = charArray2.length * 2;
        byte[] bArr3 = new byte[length2];
        int i3 = 0;
        for (char c : charArray2) {
            int[] iArr = this.metrics.get(Integer.valueOf(c));
            if (iArr != null) {
                int i4 = iArr[0];
                int i5 = i3 + 1;
                bArr3[i3] = (byte) (i4 / 256);
                i3 += 2;
                bArr3[i5] = (byte) i4;
            }
        }
        if (i3 == length2) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i3];
        System.arraycopy(bArr3, 0, bArr4, 0, i3);
        return bArr4;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.fontName}};
    }

    public IntHashtable getByte2Uni() {
        return this.byte2uni;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getCharBBox(int i) {
        return null;
    }

    public IntHashtable getDiffmap() {
        return this.diffmap;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return getFullFontName();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        float f2;
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.getFontDescriptor(i, f);
        }
        if (i == 12) {
            f2 = this.urx - this.llx;
        } else if (i != 23) {
            switch (i) {
                case 1:
                case 9:
                    f2 = this.ascender;
                    break;
                case 2:
                    f2 = this.capHeight;
                    break;
                case 3:
                case 10:
                    f2 = this.descender;
                    break;
                case 4:
                    return this.italicAngle;
                case 5:
                    f2 = this.llx;
                    break;
                case 6:
                    f2 = this.lly;
                    break;
                case 7:
                    f2 = this.urx;
                    break;
                case 8:
                    f2 = this.ury;
                    break;
                default:
                    return 0.0f;
            }
        } else {
            f2 = this.fontWeight;
        }
        return (f2 * f) / 1000.0f;
    }

    public PdfDictionary getFontDictionary() {
        return this.font;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public double[] getFontMatrix() {
        PdfDictionary pdfDictionary = this.font;
        PdfName pdfName = PdfName.FONTMATRIX;
        return pdfDictionary.getAsArray(pdfName) != null ? this.font.getAsArray(pdfName).asDoubleArray() : BaseFont.DEFAULT_FONT_MATRIX;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.fontName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() {
        return null;
    }

    public PdfIndirectReference getIndirectReference() {
        PRIndirectReference pRIndirectReference = this.refFont;
        if (pRIndirectReference != null) {
            return pRIndirectReference;
        }
        throw new IllegalArgumentException("Font reuse not allowed with direct font objects.");
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

    public IntHashtable getUni2Byte() {
        return this.uni2byte;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(int i) {
        BaseFont baseFont;
        if (!this.isType0) {
            BaseFont baseFont2 = this.cjkMirror;
            return baseFont2 != null ? baseFont2.getWidth(i) : super.getWidth(i);
        }
        if (this.hMetrics != null && (baseFont = this.cjkMirror) != null && !baseFont.isVertical()) {
            int i2 = this.hMetrics.get(this.cjkMirror.getCidCode(i));
            return i2 > 0 ? i2 : this.defaultWidth;
        }
        int[] iArr = this.metrics.get(Integer.valueOf(i));
        if (iArr != null) {
            return iArr[1];
        }
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return false;
    }

    public boolean isSymbolic() {
        PdfNumber asNumber;
        PdfDictionary asDict = this.font.getAsDict(PdfName.FONTDESCRIPTOR);
        return (asDict == null || (asNumber = asDict.getAsNumber(PdfName.FLAGS)) == null || (asNumber.intValue() & 4) == 0) ? false : true;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean isVertical() {
        BaseFont baseFont = this.cjkMirror;
        return baseFont != null ? baseFont.isVertical() : super.isVertical();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) {
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(String str) {
        BaseFont baseFont;
        int iCharAt;
        if (this.isType0) {
            int i = 0;
            if (this.hMetrics != null && (baseFont = this.cjkMirror) != null && !baseFont.isVertical()) {
                if (((CJKFont) this.cjkMirror).isIdentity()) {
                    int width = 0;
                    while (i < str.length()) {
                        width += getWidth(str.charAt(i));
                        i++;
                    }
                    return width;
                }
                int width2 = 0;
                while (i < str.length()) {
                    if (Utilities.isSurrogatePair(str, i)) {
                        iCharAt = Utilities.convertToUtf32(str, i);
                        i++;
                    } else {
                        iCharAt = str.charAt(i);
                    }
                    width2 += getWidth(iCharAt);
                    i++;
                }
                return width2;
            }
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.metrics.get(Integer.valueOf(charArray[i]));
                if (iArr != null) {
                    i2 += iArr[1];
                }
                i++;
            }
            return i2;
        }
        BaseFont baseFont2 = this.cjkMirror;
        if (baseFont2 != null) {
            return baseFont2.getWidth(str);
        }
        return super.getWidth(str);
    }

    public DocumentFont(PRIndirectReference pRIndirectReference) {
        this.metrics = new HashMap<>();
        this.uni2byte = new IntHashtable();
        this.byte2uni = new IntHashtable();
        this.ascender = 800.0f;
        this.capHeight = 700.0f;
        this.descender = -200.0f;
        this.italicAngle = 0.0f;
        this.fontWeight = 0.0f;
        this.llx = -50.0f;
        this.lly = -200.0f;
        this.urx = 100.0f;
        this.ury = 900.0f;
        this.isType0 = false;
        this.defaultWidth = 1000;
        this.refFont = pRIndirectReference;
        this.font = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
        init();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(int i) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.convertToBytes(i);
        }
        if (!this.isType0) {
            return this.uni2byte.containsKey(i) ? new byte[]{(byte) this.uni2byte.get(i)} : new byte[0];
        }
        int[] iArr = this.metrics.get(Integer.valueOf(i));
        if (iArr != null) {
            int i2 = iArr[0];
            return new byte[]{(byte) (i2 / 256), (byte) i2};
        }
        return new byte[0];
    }

    public DocumentFont(PRIndirectReference pRIndirectReference, PdfDictionary pdfDictionary) {
        this.metrics = new HashMap<>();
        this.uni2byte = new IntHashtable();
        this.byte2uni = new IntHashtable();
        this.ascender = 800.0f;
        this.capHeight = 700.0f;
        this.descender = -200.0f;
        this.italicAngle = 0.0f;
        this.fontWeight = 0.0f;
        this.llx = -50.0f;
        this.lly = -200.0f;
        this.urx = 100.0f;
        this.ury = 900.0f;
        this.isType0 = false;
        this.defaultWidth = 1000;
        this.refFont = pRIndirectReference;
        PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
        this.font = pdfDictionary2;
        if (pdfDictionary2.get(PdfName.ENCODING) == null && pdfDictionary != null) {
            Iterator<PdfName> it = pdfDictionary.getKeys().iterator();
            while (it.hasNext()) {
                this.font.put(PdfName.ENCODING, pdfDictionary.get(it.next()));
            }
        }
        init();
    }
}
