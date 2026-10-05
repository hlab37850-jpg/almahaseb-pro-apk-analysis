package com.itextpdf.text.pdf;

import androidx.core.view.InputDeviceCompat;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.fonts.otf.GlyphSubstitutionTableReader;
import com.itextpdf.text.pdf.fonts.otf.Language;
import com.itextpdf.text.pdf.languages.ArabicLigaturizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class TrueTypeFontUnicode extends TrueTypeFont implements Comparator<int[]> {
    private static final List<Language> SUPPORTED_LANGUAGES_FOR_OTF = Arrays.asList(Language.BENGALI);
    private static final byte[] rotbits = {UnsignedBytes.MAX_POWER_OF_TWO, 64, 32, 16, 8, 4, 2, 1};
    private Map<String, Glyph> glyphSubstitutionMap;
    private Language supportedLanguage;

    public TrueTypeFontUnicode(String str, String str2, boolean z, byte[] bArr, boolean z2) throws DocumentException {
        String baseName = BaseFont.getBaseName(str);
        String tTCName = TrueTypeFont.getTTCName(baseName);
        if (baseName.length() < str.length()) {
            this.style = str.substring(baseName.length());
        }
        this.encoding = str2;
        this.embedded = z;
        this.fileName = tTCName;
        this.ttcIndex = "";
        if (tTCName.length() < baseName.length()) {
            this.ttcIndex = baseName.substring(tTCName.length() + 1);
        }
        this.fontType = 3;
        if ((!this.fileName.toLowerCase().endsWith(".ttf") && !this.fileName.toLowerCase().endsWith(".otf") && !this.fileName.toLowerCase().endsWith(".ttc")) || ((!str2.equals(BaseFont.IDENTITY_H) && !str2.equals(BaseFont.IDENTITY_V)) || !z)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("1.2.is.not.a.ttf.font.file", this.fileName, this.style));
        }
        process(bArr, z2);
        if (this.os_2.fsType == 2) {
            throw new DocumentException(MessageLocalization.getComposedMessage("1.cannot.be.embedded.due.to.licensing.restrictions", this.fileName + this.style));
        }
        if ((this.cmap31 == null && !this.fontSpecific) || (this.cmap10 == null && this.fontSpecific)) {
            this.directTextToByte = true;
        }
        if (this.fontSpecific) {
            this.fontSpecific = false;
            String str3 = this.encoding;
            this.encoding = "";
            createEncoding();
            this.encoding = str3;
            this.fontSpecific = true;
        }
        this.vertical = str2.endsWith("V");
    }

    private void readGsubTable() {
        if (this.tables.get("GSUB") != null) {
            HashMap map = new HashMap(this.cmap31.size());
            for (Integer num : this.cmap31.keySet()) {
                map.put(Integer.valueOf(this.cmap31.get(num)[0]), Character.valueOf((char) num.intValue()));
            }
            GlyphSubstitutionTableReader glyphSubstitutionTableReader = new GlyphSubstitutionTableReader(this.rf, this.tables.get("GSUB")[0], map, this.glyphWidthsByIndex);
            try {
                glyphSubstitutionTableReader.read();
                Language supportedLanguage = glyphSubstitutionTableReader.getSupportedLanguage();
                this.supportedLanguage = supportedLanguage;
                if (SUPPORTED_LANGUAGES_FOR_OTF.contains(supportedLanguage)) {
                    this.glyphSubstitutionMap = glyphSubstitutionTableReader.getGlyphSubstitutionMap();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String toHex(int i) {
        if (i < 65536) {
            return "<" + toHex4(i) + ">";
        }
        int i2 = i - 65536;
        return "[<" + toHex4((i2 / 1024) + 55296) + toHex4((i2 % 1024) + 56320) + ">]";
    }

    private static String toHex4(int i) {
        String str = "0000" + Integer.toHexString(i);
        return str.substring(str.length() - 4);
    }

    public int GetCharFromGlyphId(int i) {
        if (this.glyphIdToChar == null) {
            int[] iArr = new int[this.maxGlyphId];
            HashMap<Integer, int[]> map = this.cmapExt;
            if (map == null && (map = this.cmap31) == null) {
                map = null;
            }
            if (map != null) {
                for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                    iArr[entry.getValue()[0]] = entry.getKey().intValue();
                }
            }
            this.glyphIdToChar = iArr;
        }
        return this.glyphIdToChar[i];
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean charExists(int i) {
        return getMetricsTT(i) != null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(int i) {
        return null;
    }

    public PdfDictionary getCIDFontType2(PdfIndirectReference pdfIndirectReference, String str, Object[] objArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        if (this.cff) {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.CIDFONTTYPE0);
            pdfDictionary.put(PdfName.BASEFONT, new PdfName(str + this.fontName + "-" + this.encoding));
        } else {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.CIDFONTTYPE2);
            pdfDictionary.put(PdfName.BASEFONT, new PdfName(str + this.fontName));
        }
        pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        if (!this.cff) {
            pdfDictionary.put(PdfName.CIDTOGIDMAP, PdfName.IDENTITY);
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.put(PdfName.REGISTRY, new PdfString("Adobe"));
        pdfDictionary2.put(PdfName.ORDERING, new PdfString("Identity"));
        pdfDictionary2.put(PdfName.SUPPLEMENT, new PdfNumber(0));
        pdfDictionary.put(PdfName.CIDSYSTEMINFO, pdfDictionary2);
        if (!this.vertical) {
            pdfDictionary.put(PdfName.DW, new PdfNumber(1000));
            StringBuffer stringBuffer = new StringBuffer("[");
            int i = -10;
            boolean z = true;
            for (Object obj : objArr) {
                int[] iArr = (int[]) obj;
                if (iArr[1] != 1000) {
                    int i2 = iArr[0];
                    if (i2 == i + 1) {
                        stringBuffer.append(' ');
                        stringBuffer.append(iArr[1]);
                    } else {
                        if (!z) {
                            stringBuffer.append(']');
                        }
                        stringBuffer.append(i2);
                        stringBuffer.append('[');
                        stringBuffer.append(iArr[1]);
                        z = false;
                    }
                    i = i2;
                }
            }
            if (stringBuffer.length() > 1) {
                stringBuffer.append("]]");
                pdfDictionary.put(PdfName.W, new PdfLiteral(stringBuffer.toString()));
            }
        }
        return pdfDictionary;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getCharBBox(int i) {
        int[] metricsTT;
        if (this.bboxes == null || (metricsTT = getMetricsTT(i)) == null) {
            return null;
        }
        return this.bboxes[metricsTT[0]];
    }

    public PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, String str, PdfIndirectReference pdfIndirectReference2) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE0);
        if (this.cff) {
            pdfDictionary.put(PdfName.BASEFONT, new PdfName(str + this.fontName + "-" + this.encoding));
        } else {
            pdfDictionary.put(PdfName.BASEFONT, new PdfName(str + this.fontName));
        }
        pdfDictionary.put(PdfName.ENCODING, new PdfName(this.encoding));
        pdfDictionary.put(PdfName.DESCENDANTFONTS, new PdfArray(pdfIndirectReference));
        if (pdfIndirectReference2 != null) {
            pdfDictionary.put(PdfName.TOUNICODE, pdfIndirectReference2);
        }
        return pdfDictionary;
    }

    @Override // com.itextpdf.text.pdf.TrueTypeFont, com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() {
        return this.cff ? new BaseFont.StreamFont(readCffFont(), "CIDFontType0C", this.compressionLevel) : super.getFullFontStream();
    }

    public Map<String, Glyph> getGlyphSubstitutionMap() {
        return this.glyphSubstitutionMap;
    }

    @Override // com.itextpdf.text.pdf.TrueTypeFont
    public int[] getMetricsTT(int i) {
        Character reverseMapping;
        HashMap<Integer, int[]> map = this.cmapExt;
        if (map != null) {
            return map.get(Integer.valueOf(i));
        }
        boolean z = this.fontSpecific;
        HashMap<Integer, int[]> map2 = z ? this.cmap10 : this.cmap31;
        if (map2 == null) {
            return null;
        }
        if (!z) {
            int[] iArr = map2.get(Integer.valueOf(i));
            return (iArr != null || (reverseMapping = ArabicLigaturizer.getReverseMapping((char) i)) == null) ? iArr : map2.get(Integer.valueOf(reverseMapping.charValue()));
        }
        int i2 = i & InputDeviceCompat.SOURCE_ANY;
        if (i2 == 0 || i2 == 61440) {
            return map2.get(Integer.valueOf(i & 255));
        }
        return null;
    }

    public Language getSupportedLanguage() {
        return this.supportedLanguage;
    }

    public PdfStream getToUnicode(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer("/CIDInit /ProcSet findresource begin\n12 dict begin\nbegincmap\n/CIDSystemInfo\n<< /Registry (TTX+0)\n/Ordering (T42UV)\n/Supplement 0\n>> def\n/CMapName /TTX+0 def\n/CMapType 2 def\n1 begincodespacerange\n<0000><FFFF>\nendcodespacerange\n");
        int iMin = 0;
        for (int i = 0; i < objArr.length; i++) {
            if (iMin == 0) {
                if (i != 0) {
                    stringBuffer.append("endbfrange\n");
                }
                iMin = Math.min(100, objArr.length - i);
                stringBuffer.append(iMin);
                stringBuffer.append(" beginbfrange\n");
            }
            iMin--;
            int[] iArr = (int[]) objArr[i];
            String hex = toHex(iArr[0]);
            stringBuffer.append(hex);
            stringBuffer.append(hex);
            stringBuffer.append(toHex(iArr[2]));
            stringBuffer.append('\n');
        }
        stringBuffer.append("endbfrange\nendcmap\nCMapName currentdict /CMap defineresource pop\nend end\n");
        PdfStream pdfStream = new PdfStream(PdfEncodings.convertToBytes(stringBuffer.toString(), (String) null));
        pdfStream.flateCompress(this.compressionLevel);
        return pdfStream;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(int i) {
        if (this.vertical) {
            return 1000;
        }
        if (!this.fontSpecific) {
            return getRawWidth(i, this.encoding);
        }
        int i2 = 65280 & i;
        if (i2 == 0 || i2 == 61440) {
            return getRawWidth(i & 255, null);
        }
        return 0;
    }

    @Override // com.itextpdf.text.pdf.TrueTypeFont
    public void process(byte[] bArr, boolean z) {
        super.process(bArr, z);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setCharAdvance(int i, int i2) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return false;
        }
        metricsTT[1] = i2;
        return true;
    }

    @Override // com.itextpdf.text.pdf.TrueTypeFont, com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) {
        pdfWriter.getTtfUnicodeWriter().writeFont(this, pdfIndirectReference, objArr, rotbits);
    }

    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr2[0];
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(String str) {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(String str) {
        int rawWidth;
        if (this.vertical) {
            return str.length() * 1000;
        }
        int i = 0;
        if (this.fontSpecific) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            rawWidth = 0;
            while (i < length) {
                char c = charArray[i];
                int i2 = 65280 & c;
                if (i2 == 0 || i2 == 61440) {
                    rawWidth += getRawWidth(c & 255, null);
                }
                i++;
            }
        } else {
            int length2 = str.length();
            rawWidth = 0;
            while (i < length2) {
                if (Utilities.isSurrogatePair(str, i)) {
                    rawWidth += getRawWidth(Utilities.convertToUtf32(str, i), this.encoding);
                    i++;
                } else {
                    rawWidth += getRawWidth(str.charAt(i), this.encoding);
                }
                i++;
            }
        }
        return rawWidth;
    }
}
