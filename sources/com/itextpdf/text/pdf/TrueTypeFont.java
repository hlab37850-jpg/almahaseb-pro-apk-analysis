package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.tool.xml.html.HTML;
import java.io.EOFException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class TrueTypeFont extends BaseFont {
    static final String[] codePages = {"1252 Latin 1", "1250 Latin 2: Eastern Europe", "1251 Cyrillic", "1253 Greek", "1254 Turkish", "1255 Hebrew", "1256 Arabic", "1257 Windows Baltic", "1258 Vietnamese", null, null, null, null, null, null, null, "874 Thai", "932 JIS/Japan", "936 Chinese: Simplified chars--PRC and Singapore", "949 Korean Wansung", "950 Chinese: Traditional chars--Taiwan and Hong Kong", "1361 Korean Johab", null, null, null, null, null, null, null, "Macintosh Character Set (US Roman)", "OEM Character Set", "Symbol Character Set", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "869 IBM Greek", "866 MS-DOS Russian", "865 MS-DOS Nordic", "864 Arabic", "863 MS-DOS Canadian French", "862 Hebrew", "861 MS-DOS Icelandic", "860 MS-DOS Portuguese", "857 IBM Turkish", "855 IBM Cyrillic; primarily Russian", "852 Latin 2", "775 MS-DOS Baltic", "737 Greek; former 437 G", "708 Arabic; ASMO 708", "850 WE/Latin 1", "437 US"};
    protected String[][] allNameEntries;
    protected int[][] bboxes;
    protected boolean cff;
    protected int cffLength;
    protected int cffOffset;
    protected HashMap<Integer, int[]> cmap10;
    protected HashMap<Integer, int[]> cmap31;
    protected HashMap<Integer, int[]> cmapExt;
    protected int directoryOffset;
    protected String[][] familyName;
    protected String fileName;
    protected String fontName;
    protected String[][] fullName;
    protected int[] glyphIdToChar;
    protected int[] glyphWidthsByIndex;
    protected FontHeader head;
    protected HorizontalHeader hhea;
    protected boolean isFixedPitch;
    protected double italicAngle;
    protected boolean justNames;
    protected IntHashtable kerning;
    protected int maxGlyphId;
    protected WindowsMetrics os_2;
    protected RandomAccessFileOrArray rf;
    protected String style;
    protected String[][] subFamily;
    protected HashMap<String, int[]> tables;
    protected String ttcIndex;
    protected int underlinePosition;
    protected int underlineThickness;

    public static class FontHeader {
        int flags;
        int macStyle;
        int unitsPerEm;
        short xMax;
        short xMin;
        short yMax;
        short yMin;
    }

    public static class HorizontalHeader {
        short Ascender;
        short Descender;
        short LineGap;
        int advanceWidthMax;
        short caretSlopeRise;
        short caretSlopeRun;
        short minLeftSideBearing;
        short minRightSideBearing;
        int numberOfHMetrics;
        short xMaxExtent;
    }

    public static class WindowsMetrics {
        int fsSelection;
        short fsType;
        int sCapHeight;
        short sFamilyClass;
        short sTypoAscender;
        short sTypoDescender;
        short sTypoLineGap;
        int ulCodePageRange1;
        int ulCodePageRange2;
        int usFirstCharIndex;
        int usLastCharIndex;
        int usWeightClass;
        int usWidthClass;
        int usWinAscent;
        int usWinDescent;
        short xAvgCharWidth;
        short yStrikeoutPosition;
        short yStrikeoutSize;
        short ySubscriptXOffset;
        short ySubscriptXSize;
        short ySubscriptYOffset;
        short ySubscriptYSize;
        short ySuperscriptXOffset;
        short ySuperscriptXSize;
        short ySuperscriptYOffset;
        short ySuperscriptYSize;
        byte[] panose = new byte[10];
        byte[] achVendID = new byte[4];
    }

    public TrueTypeFont() {
        this.justNames = false;
        this.cff = false;
        this.style = "";
        this.head = new FontHeader();
        this.hhea = new HorizontalHeader();
        this.os_2 = new WindowsMetrics();
        this.kerning = new IntHashtable();
        this.isFixedPitch = false;
    }

    public static int[] compactRanges(ArrayList<int[]> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            int[] iArr = arrayList.get(i);
            for (int i2 = 0; i2 < iArr.length; i2 += 2) {
                int i3 = i2 + 1;
                arrayList2.add(new int[]{Math.max(0, Math.min(iArr[i2], iArr[i3])), Math.min(65535, Math.max(iArr[i2], iArr[i3]))});
            }
        }
        int i4 = 0;
        while (i4 < arrayList2.size() - 1) {
            int i5 = i4 + 1;
            int i6 = i5;
            while (i6 < arrayList2.size()) {
                int[] iArr2 = (int[]) arrayList2.get(i4);
                int[] iArr3 = (int[]) arrayList2.get(i6);
                int i7 = iArr2[0];
                int i8 = iArr3[0];
                if ((i7 >= i8 && i7 <= iArr3[1]) || (iArr2[1] >= i8 && i7 <= iArr3[1])) {
                    iArr2[0] = Math.min(i7, i8);
                    iArr2[1] = Math.max(iArr2[1], iArr3[1]);
                    arrayList2.remove(i6);
                    i6--;
                }
                i6++;
            }
            i4 = i5;
        }
        int[] iArr4 = new int[arrayList2.size() * 2];
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            int[] iArr5 = (int[]) arrayList2.get(i9);
            int i10 = i9 * 2;
            iArr4[i10] = iArr5[0];
            iArr4[i10 + 1] = iArr5[1];
        }
        return iArr4;
    }

    public static String getTTCName(String str) {
        int iIndexOf = str.toLowerCase().indexOf(".ttc,");
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf + 4);
    }

    private void readBbox() throws DocumentException {
        int[] iArr;
        int i = 0;
        int[] iArr2 = this.tables.get(HTML.Tag.HEAD);
        if (iArr2 == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", HTML.Tag.HEAD, this.fileName + this.style));
        }
        this.rf.seek(iArr2[0] + 51);
        boolean z = this.rf.readUnsignedShort() == 0;
        int[] iArr3 = this.tables.get("loca");
        if (iArr3 == null) {
            return;
        }
        this.rf.seek(iArr3[0]);
        if (z) {
            int i2 = iArr3[1] / 2;
            iArr = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = this.rf.readUnsignedShort() * 2;
            }
        } else {
            int i4 = iArr3[1] / 4;
            iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                iArr[i5] = this.rf.readInt();
            }
        }
        int[] iArr4 = this.tables.get("glyf");
        if (iArr4 == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "glyf", this.fileName + this.style));
        }
        int i6 = iArr4[0];
        this.bboxes = new int[iArr.length - 1][];
        while (i < iArr.length - 1) {
            int i7 = iArr[i];
            int i8 = i + 1;
            if (i7 != iArr[i8]) {
                this.rf.seek(i7 + i6 + 2);
                this.bboxes[i] = new int[]{(this.rf.readShort() * 1000) / this.head.unitsPerEm, (this.rf.readShort() * 1000) / this.head.unitsPerEm, (this.rf.readShort() * 1000) / this.head.unitsPerEm, (this.rf.readShort() * 1000) / this.head.unitsPerEm};
            }
            i = i8;
        }
    }

    public void addRangeUni(HashMap<Integer, int[]> map, boolean z, boolean z2) {
        HashMap<Integer, int[]> map2;
        if (z2) {
            return;
        }
        ArrayList<int[]> arrayList = this.subsetRanges;
        if (arrayList != null || this.directoryOffset > 0) {
            int[] iArrCompactRanges = (arrayList != null || this.directoryOffset <= 0) ? compactRanges(arrayList) : new int[]{0, 65535};
            boolean z3 = this.fontSpecific;
            if ((z3 || (map2 = this.cmap31) == null) && ((!z3 || (map2 = this.cmap10) == null) && (map2 = this.cmap31) == null)) {
                map2 = this.cmap10;
            }
            for (Map.Entry<Integer, int[]> entry : map2.entrySet()) {
                int[] value = entry.getValue();
                Integer numValueOf = Integer.valueOf(value[0]);
                if (!map.containsKey(numValueOf)) {
                    int iIntValue = entry.getKey().intValue();
                    for (int i = 0; i < iArrCompactRanges.length; i += 2) {
                        if (iIntValue >= iArrCompactRanges[i] && iIntValue <= iArrCompactRanges[i + 1]) {
                            map.put(numValueOf, z ? new int[]{value[0], value[1], iIntValue} : null);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void checkCff() {
        int[] iArr = this.tables.get("CFF ");
        if (iArr != null) {
            this.cff = true;
            this.cffOffset = iArr[0];
            this.cffLength = iArr[1];
        }
    }

    public void fillTables() throws DocumentException, EOFException {
        int[] iArr = this.tables.get(HTML.Tag.HEAD);
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", HTML.Tag.HEAD, this.fileName + this.style));
        }
        this.rf.seek(iArr[0] + 16);
        this.head.flags = this.rf.readUnsignedShort();
        this.head.unitsPerEm = this.rf.readUnsignedShort();
        this.rf.skipBytes(16);
        this.head.xMin = this.rf.readShort();
        this.head.yMin = this.rf.readShort();
        this.head.xMax = this.rf.readShort();
        this.head.yMax = this.rf.readShort();
        this.head.macStyle = this.rf.readUnsignedShort();
        int[] iArr2 = this.tables.get("hhea");
        if (iArr2 == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "hhea", this.fileName + this.style));
        }
        this.rf.seek(iArr2[0] + 4);
        this.hhea.Ascender = this.rf.readShort();
        this.hhea.Descender = this.rf.readShort();
        this.hhea.LineGap = this.rf.readShort();
        this.hhea.advanceWidthMax = this.rf.readUnsignedShort();
        this.hhea.minLeftSideBearing = this.rf.readShort();
        this.hhea.minRightSideBearing = this.rf.readShort();
        this.hhea.xMaxExtent = this.rf.readShort();
        this.hhea.caretSlopeRise = this.rf.readShort();
        this.hhea.caretSlopeRun = this.rf.readShort();
        this.rf.skipBytes(12);
        this.hhea.numberOfHMetrics = this.rf.readUnsignedShort();
        int[] iArr3 = this.tables.get("OS/2");
        if (iArr3 != null) {
            this.rf.seek(iArr3[0]);
            int unsignedShort = this.rf.readUnsignedShort();
            this.os_2.xAvgCharWidth = this.rf.readShort();
            this.os_2.usWeightClass = this.rf.readUnsignedShort();
            this.os_2.usWidthClass = this.rf.readUnsignedShort();
            this.os_2.fsType = this.rf.readShort();
            this.os_2.ySubscriptXSize = this.rf.readShort();
            this.os_2.ySubscriptYSize = this.rf.readShort();
            this.os_2.ySubscriptXOffset = this.rf.readShort();
            this.os_2.ySubscriptYOffset = this.rf.readShort();
            this.os_2.ySuperscriptXSize = this.rf.readShort();
            this.os_2.ySuperscriptYSize = this.rf.readShort();
            this.os_2.ySuperscriptXOffset = this.rf.readShort();
            this.os_2.ySuperscriptYOffset = this.rf.readShort();
            this.os_2.yStrikeoutSize = this.rf.readShort();
            this.os_2.yStrikeoutPosition = this.rf.readShort();
            this.os_2.sFamilyClass = this.rf.readShort();
            this.rf.readFully(this.os_2.panose);
            this.rf.skipBytes(16);
            this.rf.readFully(this.os_2.achVendID);
            this.os_2.fsSelection = this.rf.readUnsignedShort();
            this.os_2.usFirstCharIndex = this.rf.readUnsignedShort();
            this.os_2.usLastCharIndex = this.rf.readUnsignedShort();
            this.os_2.sTypoAscender = this.rf.readShort();
            this.os_2.sTypoDescender = this.rf.readShort();
            WindowsMetrics windowsMetrics = this.os_2;
            short s = windowsMetrics.sTypoDescender;
            if (s > 0) {
                windowsMetrics.sTypoDescender = (short) (-s);
            }
            windowsMetrics.sTypoLineGap = this.rf.readShort();
            this.os_2.usWinAscent = this.rf.readUnsignedShort();
            this.os_2.usWinDescent = this.rf.readUnsignedShort();
            WindowsMetrics windowsMetrics2 = this.os_2;
            windowsMetrics2.ulCodePageRange1 = 0;
            windowsMetrics2.ulCodePageRange2 = 0;
            if (unsignedShort > 0) {
                windowsMetrics2.ulCodePageRange1 = this.rf.readInt();
                this.os_2.ulCodePageRange2 = this.rf.readInt();
            }
            if (unsignedShort > 1) {
                this.rf.skipBytes(2);
                this.os_2.sCapHeight = this.rf.readShort();
            } else {
                this.os_2.sCapHeight = (int) (((double) this.head.unitsPerEm) * 0.7d);
            }
        } else if (this.tables.get("hhea") != null && this.tables.get(HTML.Tag.HEAD) != null) {
            int i = this.head.macStyle;
            if (i == 0) {
                WindowsMetrics windowsMetrics3 = this.os_2;
                windowsMetrics3.usWeightClass = TypedValues.TransitionType.TYPE_DURATION;
                windowsMetrics3.usWidthClass = 5;
            } else if (i == 5) {
                WindowsMetrics windowsMetrics4 = this.os_2;
                windowsMetrics4.usWeightClass = 400;
                windowsMetrics4.usWidthClass = 3;
            } else if (i == 6) {
                WindowsMetrics windowsMetrics5 = this.os_2;
                windowsMetrics5.usWeightClass = 400;
                windowsMetrics5.usWidthClass = 7;
            } else {
                WindowsMetrics windowsMetrics6 = this.os_2;
                windowsMetrics6.usWeightClass = 400;
                windowsMetrics6.usWidthClass = 5;
            }
            WindowsMetrics windowsMetrics7 = this.os_2;
            windowsMetrics7.fsType = (short) 0;
            windowsMetrics7.ySubscriptYSize = (short) 0;
            windowsMetrics7.ySubscriptYOffset = (short) 0;
            windowsMetrics7.ySuperscriptYSize = (short) 0;
            windowsMetrics7.ySuperscriptYOffset = (short) 0;
            windowsMetrics7.yStrikeoutSize = (short) 0;
            windowsMetrics7.yStrikeoutPosition = (short) 0;
            HorizontalHeader horizontalHeader = this.hhea;
            short s2 = horizontalHeader.Ascender;
            windowsMetrics7.sTypoAscender = (short) (((double) s2) - (((double) s2) * 0.21d));
            windowsMetrics7.sTypoDescender = (short) (-(((double) Math.abs((int) horizontalHeader.Descender)) - (((double) Math.abs((int) this.hhea.Descender)) * 0.07d)));
            WindowsMetrics windowsMetrics8 = this.os_2;
            HorizontalHeader horizontalHeader2 = this.hhea;
            windowsMetrics8.sTypoLineGap = (short) (horizontalHeader2.LineGap * 2);
            windowsMetrics8.usWinAscent = horizontalHeader2.Ascender;
            windowsMetrics8.usWinDescent = horizontalHeader2.Descender;
            windowsMetrics8.ulCodePageRange1 = 0;
            windowsMetrics8.ulCodePageRange2 = 0;
            windowsMetrics8.sCapHeight = (int) (((double) this.head.unitsPerEm) * 0.7d);
        }
        int[] iArr4 = this.tables.get("post");
        if (iArr4 == null) {
            HorizontalHeader horizontalHeader3 = this.hhea;
            this.italicAngle = ((-Math.atan2(horizontalHeader3.caretSlopeRun, horizontalHeader3.caretSlopeRise)) * 180.0d) / 3.141592653589793d;
        } else {
            this.rf.seek(iArr4[0] + 4);
            this.italicAngle = ((double) this.rf.readShort()) + (((double) this.rf.readUnsignedShort()) / 16384.0d);
            this.underlinePosition = this.rf.readShort();
            this.underlineThickness = this.rf.readShort();
            this.isFixedPitch = this.rf.readInt() != 0;
        }
        int[] iArr5 = this.tables.get("maxp");
        if (iArr5 == null) {
            this.maxGlyphId = 65536;
        } else {
            this.rf.seek(iArr5[0] + 4);
            this.maxGlyphId = this.rf.readUnsignedShort();
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return this.allNameEntries;
    }

    public String[][] getAllNames() throws DocumentException, EOFException {
        int[] iArr = this.tables.get("name");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "name", this.fileName + this.style));
        }
        this.rf.seek(iArr[0] + 2);
        int unsignedShort = this.rf.readUnsignedShort();
        int unsignedShort2 = this.rf.readUnsignedShort();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < unsignedShort; i++) {
            int unsignedShort3 = this.rf.readUnsignedShort();
            int unsignedShort4 = this.rf.readUnsignedShort();
            int unsignedShort5 = this.rf.readUnsignedShort();
            int unsignedShort6 = this.rf.readUnsignedShort();
            int unsignedShort7 = this.rf.readUnsignedShort();
            int unsignedShort8 = this.rf.readUnsignedShort();
            int filePointer = (int) this.rf.getFilePointer();
            this.rf.seek(iArr[0] + unsignedShort2 + unsignedShort8);
            arrayList.add(new String[]{String.valueOf(unsignedShort6), String.valueOf(unsignedShort3), String.valueOf(unsignedShort4), String.valueOf(unsignedShort5), (unsignedShort3 == 0 || unsignedShort3 == 3 || (unsignedShort3 == 2 && unsignedShort4 == 1)) ? readUnicodeString(unsignedShort7) : readStandardString(unsignedShort7)});
            this.rf.seek(filePointer);
        }
        String[][] strArr = new String[arrayList.size()][];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            strArr[i2] = (String[]) arrayList.get(i2);
        }
        return strArr;
    }

    public String getBaseFont() throws DocumentException, EOFException {
        int[] iArr = this.tables.get("name");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "name", this.fileName + this.style));
        }
        this.rf.seek(iArr[0] + 2);
        int unsignedShort = this.rf.readUnsignedShort();
        int unsignedShort2 = this.rf.readUnsignedShort();
        for (int i = 0; i < unsignedShort; i++) {
            int unsignedShort3 = this.rf.readUnsignedShort();
            this.rf.readUnsignedShort();
            this.rf.readUnsignedShort();
            int unsignedShort4 = this.rf.readUnsignedShort();
            int unsignedShort5 = this.rf.readUnsignedShort();
            int unsignedShort6 = this.rf.readUnsignedShort();
            if (unsignedShort4 == 6) {
                this.rf.seek(iArr[0] + unsignedShort2 + unsignedShort6);
                return (unsignedShort3 == 0 || unsignedShort3 == 3) ? readUnicodeString(unsignedShort5) : readStandardString(unsignedShort5);
            }
        }
        return new File(this.fileName).getName().replace(' ', '-');
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[] getCodePagesSupported() {
        String str;
        WindowsMetrics windowsMetrics = this.os_2;
        long j = (((long) windowsMetrics.ulCodePageRange2) << 32) + (((long) windowsMetrics.ulCodePageRange1) & 4294967295L);
        long j2 = 1;
        int i = 0;
        for (int i2 = 0; i2 < 64; i2++) {
            if ((j & j2) != 0 && codePages[i2] != null) {
                i++;
            }
            j2 <<= 1;
        }
        String[] strArr = new String[i];
        long j3 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < 64; i4++) {
            if ((j & j3) != 0 && (str = codePages[i4]) != null) {
                strArr[i3] = str;
                i3++;
            }
            j3 <<= 1;
        }
        return strArr;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return this.familyName;
    }

    public PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, String str, int i, int i2, byte[] bArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        if (this.cff) {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE1);
            pdfDictionary.put(PdfName.BASEFONT, new PdfName(this.fontName + this.style));
        } else {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.TRUETYPE);
            pdfDictionary.put(PdfName.BASEFONT, new PdfName(str + this.fontName + this.style));
        }
        if (!this.fontSpecific) {
            for (int i3 = i; i3 <= i2; i3++) {
                if (!this.differences[i3].equals(BaseFont.notdef)) {
                    i = i3;
                    break;
                }
            }
            if (this.encoding.equals("Cp1252") || this.encoding.equals(BaseFont.MACROMAN)) {
                pdfDictionary.put(PdfName.ENCODING, this.encoding.equals("Cp1252") ? PdfName.WIN_ANSI_ENCODING : PdfName.MAC_ROMAN_ENCODING);
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.ENCODING);
                PdfArray pdfArray = new PdfArray();
                boolean z = true;
                for (int i4 = i; i4 <= i2; i4++) {
                    if (bArr[i4] != 0) {
                        if (z) {
                            pdfArray.add(new PdfNumber(i4));
                            z = false;
                        }
                        pdfArray.add(new PdfName(this.differences[i4]));
                    } else {
                        z = true;
                    }
                }
                pdfDictionary2.put(PdfName.DIFFERENCES, pdfArray);
                pdfDictionary.put(PdfName.ENCODING, pdfDictionary2);
            }
        }
        pdfDictionary.put(PdfName.FIRSTCHAR, new PdfNumber(i));
        pdfDictionary.put(PdfName.LASTCHAR, new PdfNumber(i2));
        PdfArray pdfArray2 = new PdfArray();
        while (i <= i2) {
            if (bArr[i] == 0) {
                pdfArray2.add(new PdfNumber(0));
            } else {
                pdfArray2.add(new PdfNumber(this.widths[i]));
            }
            i++;
        }
        pdfDictionary.put(PdfName.WIDTHS, pdfArray2);
        if (pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    public PdfDictionary getFontDescriptor(PdfIndirectReference pdfIndirectReference, String str, PdfIndirectReference pdfIndirectReference2) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfNumber((this.os_2.sTypoAscender * 1000) / this.head.unitsPerEm));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfNumber((this.os_2.sCapHeight * 1000) / this.head.unitsPerEm));
        pdfDictionary.put(PdfName.DESCENT, new PdfNumber((this.os_2.sTypoDescender * 1000) / this.head.unitsPerEm));
        PdfName pdfName = PdfName.FONTBBOX;
        FontHeader fontHeader = this.head;
        int i = fontHeader.xMin * 1000;
        int i2 = fontHeader.unitsPerEm;
        pdfDictionary.put(pdfName, new PdfRectangle(i / i2, (fontHeader.yMin * 1000) / i2, (fontHeader.xMax * 1000) / i2, (fontHeader.yMax * 1000) / i2));
        if (pdfIndirectReference2 != null) {
            pdfDictionary.put(PdfName.CIDSET, pdfIndirectReference2);
        }
        if (!this.cff) {
            pdfDictionary.put(PdfName.FONTNAME, new PdfName(str + this.fontName + this.style));
        } else if (this.encoding.startsWith("Identity-")) {
            pdfDictionary.put(PdfName.FONTNAME, new PdfName(str + this.fontName + "-" + this.encoding));
        } else {
            pdfDictionary.put(PdfName.FONTNAME, new PdfName(str + this.fontName + this.style));
        }
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfNumber(this.italicAngle));
        pdfDictionary.put(PdfName.STEMV, new PdfNumber(80));
        if (pdfIndirectReference != null) {
            if (this.cff) {
                pdfDictionary.put(PdfName.FONTFILE3, pdfIndirectReference);
            } else {
                pdfDictionary.put(PdfName.FONTFILE2, pdfIndirectReference);
            }
        }
        int i3 = (this.isFixedPitch ? 1 : 0) | (this.fontSpecific ? 4 : 32);
        int i4 = this.head.macStyle;
        if ((i4 & 2) != 0) {
            i3 |= 64;
        }
        if ((i4 & 1) != 0) {
            i3 |= 262144;
        }
        pdfDictionary.put(PdfName.FLAGS, new PdfNumber(i3));
        return pdfDictionary;
    }

    public byte[] getFullFont() throws Throwable {
        RandomAccessFileOrArray randomAccessFileOrArray;
        Throwable th;
        try {
            randomAccessFileOrArray = new RandomAccessFileOrArray(this.rf);
            try {
                randomAccessFileOrArray.reOpen();
                byte[] bArr = new byte[(int) randomAccessFileOrArray.length()];
                randomAccessFileOrArray.readFully(bArr);
                try {
                    randomAccessFileOrArray.close();
                } catch (Exception unused) {
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFileOrArray != null) {
                    try {
                        randomAccessFileOrArray.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            randomAccessFileOrArray = null;
            th = th3;
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return this.fullName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() throws Throwable {
        if (this.cff) {
            return new BaseFont.StreamFont(readCffFont(), "Type1C", this.compressionLevel);
        }
        byte[] fullFont = getFullFont();
        return new BaseFont.StreamFont(fullFont, new int[]{fullFont.length}, this.compressionLevel);
    }

    public int getGlyphWidth(int i) {
        int[] iArr = this.glyphWidthsByIndex;
        if (i >= iArr.length) {
            i = iArr.length - 1;
        }
        return iArr[i];
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getKerning(int i, int i2) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return 0;
        }
        int i3 = metricsTT[0];
        int[] metricsTT2 = getMetricsTT(i2);
        if (metricsTT2 == null) {
            return 0;
        }
        return this.kerning.get((i3 << 16) + metricsTT2[0]);
    }

    public int[] getMetricsTT(int i) {
        HashMap<Integer, int[]> map;
        HashMap<Integer, int[]> map2;
        HashMap<Integer, int[]> map3 = this.cmapExt;
        if (map3 != null) {
            return map3.get(Integer.valueOf(i));
        }
        boolean z = this.fontSpecific;
        if (!z && (map2 = this.cmap31) != null) {
            return map2.get(Integer.valueOf(i));
        }
        if (z && (map = this.cmap10) != null) {
            return map.get(Integer.valueOf(i));
        }
        HashMap<Integer, int[]> map4 = this.cmap31;
        if (map4 != null) {
            return map4.get(Integer.valueOf(i));
        }
        HashMap<Integer, int[]> map5 = this.cmap10;
        if (map5 != null) {
            return map5.get(Integer.valueOf(i));
        }
        return null;
    }

    public String[][] getNames(int i) throws DocumentException, EOFException {
        int[] iArr = this.tables.get("name");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "name", this.fileName + this.style));
        }
        this.rf.seek(iArr[0] + 2);
        int unsignedShort = this.rf.readUnsignedShort();
        int unsignedShort2 = this.rf.readUnsignedShort();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < unsignedShort) {
            int unsignedShort3 = this.rf.readUnsignedShort();
            int unsignedShort4 = this.rf.readUnsignedShort();
            int unsignedShort5 = this.rf.readUnsignedShort();
            int unsignedShort6 = this.rf.readUnsignedShort();
            int unsignedShort7 = this.rf.readUnsignedShort();
            int unsignedShort8 = this.rf.readUnsignedShort();
            if (unsignedShort6 == i) {
                int filePointer = (int) this.rf.getFilePointer();
                this.rf.seek(iArr[0] + unsignedShort2 + unsignedShort8);
                arrayList.add(new String[]{String.valueOf(unsignedShort3), String.valueOf(unsignedShort4), String.valueOf(unsignedShort5), (unsignedShort3 == 0 || unsignedShort3 == 3 || (unsignedShort3 == 2 && unsignedShort4 == 1)) ? readUnicodeString(unsignedShort7) : readStandardString(unsignedShort7)});
                this.rf.seek(filePointer);
            }
            i2++;
            iArr = iArr;
        }
        String[][] strArr = new String[arrayList.size()][];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            strArr[i3] = (String[]) arrayList.get(i3);
        }
        return strArr;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getPostscriptFontName() {
        return this.fontName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getRawCharBBox(int i, String str) {
        HashMap<Integer, int[]> map;
        int[] iArr;
        int[][] iArr2;
        if (str == null || (map = this.cmap31) == null) {
            map = this.cmap10;
        }
        if (map == null || (iArr = map.get(Integer.valueOf(i))) == null || (iArr2 = this.bboxes) == null) {
            return null;
        }
        return iArr2[iArr[0]];
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getRawWidth(int i, String str) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return 0;
        }
        return metricsTT[1];
    }

    public synchronized byte[] getSubSet(HashSet hashSet, boolean z) {
        return new TrueTypeFontSubSet(this.fileName, new RandomAccessFileOrArray(this.rf), hashSet, this.directoryOffset, true, !z).process();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getSubfamily() {
        String[][] strArr = this.subFamily;
        return (strArr == null || strArr.length <= 0) ? super.getSubfamily() : strArr[0][3];
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return this.kerning.size() > 0;
    }

    public void process(byte[] bArr, boolean z) {
        this.tables = new HashMap<>();
        if (bArr == null) {
            this.rf = new RandomAccessFileOrArray(this.fileName, z, Document.plainRandomAccess);
        } else {
            this.rf = new RandomAccessFileOrArray(bArr);
        }
        try {
            if (this.ttcIndex.length() > 0) {
                int i = Integer.parseInt(this.ttcIndex);
                if (i < 0) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("the.font.index.for.1.must.be.positive", this.fileName));
                }
                if (!readStandardString(4).equals("ttcf")) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.valid.ttc.file", this.fileName));
                }
                this.rf.skipBytes(4);
                int i2 = this.rf.readInt();
                if (i >= i2) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("the.font.index.for.1.must.be.between.0.and.2.it.was.3", this.fileName, String.valueOf(i2 - 1), String.valueOf(i)));
                }
                this.rf.skipBytes(i * 4);
                this.directoryOffset = this.rf.readInt();
            }
            this.rf.seek(this.directoryOffset);
            int i3 = this.rf.readInt();
            if (i3 != 65536 && i3 != 1330926671) {
                throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.valid.ttf.or.otf.file", this.fileName));
            }
            int unsignedShort = this.rf.readUnsignedShort();
            this.rf.skipBytes(6);
            for (int i4 = 0; i4 < unsignedShort; i4++) {
                String standardString = readStandardString(4);
                this.rf.skipBytes(4);
                this.tables.put(standardString, new int[]{this.rf.readInt(), this.rf.readInt()});
            }
            checkCff();
            this.fontName = getBaseFont();
            this.fullName = getNames(4);
            String[][] names = getNames(16);
            if (names.length > 0) {
                this.familyName = names;
            } else {
                this.familyName = getNames(1);
            }
            String[][] names2 = getNames(17);
            if (names.length > 0) {
                this.subFamily = names2;
            } else {
                this.subFamily = getNames(2);
            }
            this.allNameEntries = getAllNames();
            if (!this.justNames) {
                fillTables();
                readGlyphWidths();
                readCMaps();
                readKerning();
                readBbox();
            }
            if (this.embedded) {
                return;
            }
            this.rf.close();
            this.rf = null;
        } catch (Throwable th) {
            if (!this.embedded) {
                this.rf.close();
                this.rf = null;
            }
            throw th;
        }
    }

    public void readCMaps() throws DocumentException, EOFException {
        int[] iArr = this.tables.get("cmap");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "cmap", this.fileName + this.style));
        }
        this.rf.seek(iArr[0]);
        this.rf.skipBytes(2);
        int unsignedShort = this.rf.readUnsignedShort();
        this.fontSpecific = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < unsignedShort; i5++) {
            int unsignedShort2 = this.rf.readUnsignedShort();
            int unsignedShort3 = this.rf.readUnsignedShort();
            int i6 = this.rf.readInt();
            if (unsignedShort2 == 3 && unsignedShort3 == 0) {
                this.fontSpecific = true;
                i3 = i6;
            } else if (unsignedShort2 == 3 && unsignedShort3 == 1) {
                i2 = i6;
            } else if (unsignedShort2 == 3 && unsignedShort3 == 10) {
                i4 = i6;
            }
            if (unsignedShort2 == 1 && unsignedShort3 == 0) {
                i = i6;
            }
        }
        if (i > 0) {
            this.rf.seek(iArr[0] + i);
            int unsignedShort4 = this.rf.readUnsignedShort();
            if (unsignedShort4 == 0) {
                this.cmap10 = readFormat0();
            } else if (unsignedShort4 == 4) {
                this.cmap10 = readFormat4();
            } else if (unsignedShort4 == 6) {
                this.cmap10 = readFormat6();
            }
        }
        if (i2 > 0) {
            this.rf.seek(iArr[0] + i2);
            if (this.rf.readUnsignedShort() == 4) {
                this.cmap31 = readFormat4();
            }
        }
        if (i3 > 0) {
            this.rf.seek(iArr[0] + i3);
            if (this.rf.readUnsignedShort() == 4) {
                this.cmap10 = readFormat4();
            }
        }
        if (i4 > 0) {
            this.rf.seek(iArr[0] + i4);
            int unsignedShort5 = this.rf.readUnsignedShort();
            if (unsignedShort5 == 0) {
                this.cmapExt = readFormat0();
                return;
            }
            if (unsignedShort5 == 4) {
                this.cmapExt = readFormat4();
            } else if (unsignedShort5 == 6) {
                this.cmapExt = readFormat6();
            } else {
                if (unsignedShort5 != 12) {
                    return;
                }
                this.cmapExt = readFormat12();
            }
        }
    }

    public byte[] readCffFont() {
        RandomAccessFileOrArray randomAccessFileOrArray = new RandomAccessFileOrArray(this.rf);
        byte[] bArr = new byte[this.cffLength];
        try {
            randomAccessFileOrArray.reOpen();
            randomAccessFileOrArray.seek(this.cffOffset);
            randomAccessFileOrArray.readFully(bArr);
            return bArr;
        } finally {
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
        }
    }

    public HashMap<Integer, int[]> readFormat0() throws EOFException {
        HashMap<Integer, int[]> map = new HashMap<>();
        this.rf.skipBytes(4);
        for (int i = 0; i < 256; i++) {
            int unsignedByte = this.rf.readUnsignedByte();
            map.put(Integer.valueOf(i), new int[]{unsignedByte, getGlyphWidth(unsignedByte)});
        }
        return map;
    }

    public HashMap<Integer, int[]> readFormat12() throws EOFException {
        HashMap<Integer, int[]> map = new HashMap<>();
        this.rf.skipBytes(2);
        this.rf.readInt();
        this.rf.skipBytes(4);
        int i = this.rf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.rf.readInt();
            int i4 = this.rf.readInt();
            for (int i5 = this.rf.readInt(); i5 <= i3; i5++) {
                map.put(Integer.valueOf(i5), new int[]{i4, getGlyphWidth(i4)});
                i4++;
            }
        }
        return map;
    }

    public HashMap<Integer, int[]> readFormat4() throws EOFException {
        int i;
        HashMap<Integer, int[]> map = new HashMap<>();
        int unsignedShort = this.rf.readUnsignedShort();
        this.rf.skipBytes(2);
        int unsignedShort2 = this.rf.readUnsignedShort() / 2;
        this.rf.skipBytes(6);
        int[] iArr = new int[unsignedShort2];
        for (int i2 = 0; i2 < unsignedShort2; i2++) {
            iArr[i2] = this.rf.readUnsignedShort();
        }
        this.rf.skipBytes(2);
        int[] iArr2 = new int[unsignedShort2];
        for (int i3 = 0; i3 < unsignedShort2; i3++) {
            iArr2[i3] = this.rf.readUnsignedShort();
        }
        int[] iArr3 = new int[unsignedShort2];
        for (int i4 = 0; i4 < unsignedShort2; i4++) {
            iArr3[i4] = this.rf.readUnsignedShort();
        }
        int[] iArr4 = new int[unsignedShort2];
        for (int i5 = 0; i5 < unsignedShort2; i5++) {
            iArr4[i5] = this.rf.readUnsignedShort();
        }
        int i6 = ((unsignedShort / 2) - 8) - (unsignedShort2 * 4);
        int[] iArr5 = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            iArr5[i7] = this.rf.readUnsignedShort();
        }
        for (int i8 = 0; i8 < unsignedShort2; i8++) {
            for (int i9 = iArr2[i8]; i9 <= iArr[i8] && i9 != 65535; i9++) {
                int i10 = iArr4[i8];
                if (i10 == 0) {
                    i = iArr3[i8] + i9;
                } else {
                    int i11 = ((((i10 / 2) + i8) - unsignedShort2) + i9) - iArr2[i8];
                    if (i11 < i6) {
                        i = iArr5[i11] + iArr3[i8];
                    }
                }
                int i12 = 65535 & i;
                map.put(Integer.valueOf((this.fontSpecific && (65280 & i9) == 61440) ? i9 & 255 : i9), new int[]{i12, getGlyphWidth(i12)});
            }
        }
        return map;
    }

    public HashMap<Integer, int[]> readFormat6() throws EOFException {
        HashMap<Integer, int[]> map = new HashMap<>();
        this.rf.skipBytes(4);
        int unsignedShort = this.rf.readUnsignedShort();
        int unsignedShort2 = this.rf.readUnsignedShort();
        for (int i = 0; i < unsignedShort2; i++) {
            int unsignedShort3 = this.rf.readUnsignedShort();
            map.put(Integer.valueOf(i + unsignedShort), new int[]{unsignedShort3, getGlyphWidth(unsignedShort3)});
        }
        return map;
    }

    public void readGlyphWidths() throws DocumentException {
        int[] iArr = this.tables.get("hmtx");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "hmtx", this.fileName + this.style));
        }
        this.rf.seek(iArr[0]);
        this.glyphWidthsByIndex = new int[this.hhea.numberOfHMetrics];
        for (int i = 0; i < this.hhea.numberOfHMetrics; i++) {
            this.glyphWidthsByIndex[i] = (this.rf.readUnsignedShort() * 1000) / this.head.unitsPerEm;
            int i2 = (this.rf.readShort() * 1000) / this.head.unitsPerEm;
        }
    }

    public void readKerning() throws EOFException {
        int[] iArr = this.tables.get("kern");
        if (iArr == null) {
            return;
        }
        this.rf.seek(iArr[0] + 2);
        int unsignedShort = this.rf.readUnsignedShort();
        int i = iArr[0] + 4;
        int unsignedShort2 = 0;
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            i += unsignedShort2;
            this.rf.seek(i);
            this.rf.skipBytes(2);
            unsignedShort2 = this.rf.readUnsignedShort();
            if ((this.rf.readUnsignedShort() & 65527) == 1) {
                int unsignedShort3 = this.rf.readUnsignedShort();
                this.rf.skipBytes(6);
                for (int i3 = 0; i3 < unsignedShort3; i3++) {
                    this.kerning.put(this.rf.readInt(), (this.rf.readShort() * 1000) / this.head.unitsPerEm);
                }
            }
        }
    }

    public String readStandardString(int i) {
        return this.rf.readString(i, "Cp1252");
    }

    public String readUnicodeString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i / 2;
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(this.rf.readChar());
        }
        return stringBuffer.toString();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return false;
        }
        int i4 = metricsTT[0];
        int[] metricsTT2 = getMetricsTT(i2);
        if (metricsTT2 == null) {
            return false;
        }
        this.kerning.put((i4 << 16) + metricsTT2[0], i3);
        return true;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
        this.fontName = str;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) {
        int i;
        int i2;
        PdfIndirectReference indirectReference;
        int[] metricsTT;
        int iIntValue = ((Integer) objArr[0]).intValue();
        int iIntValue2 = ((Integer) objArr[1]).intValue();
        byte[] bArr = (byte[]) objArr[2];
        boolean z = ((Boolean) objArr[3]).booleanValue() && this.subset;
        if (z) {
            i = iIntValue;
            i2 = iIntValue2;
        } else {
            int length = bArr.length - 1;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = 1;
            }
            i2 = length;
            i = 0;
        }
        String strCreateSubsetPrefix = "";
        if (!this.embedded) {
            indirectReference = null;
        } else if (this.cff) {
            indirectReference = pdfWriter.addToBody(new BaseFont.StreamFont(readCffFont(), "Type1C", this.compressionLevel)).getIndirectReference();
        } else {
            strCreateSubsetPrefix = z ? BaseFont.createSubsetPrefix() : "";
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i4 = i; i4 <= i2; i4++) {
                if (bArr[i4] != 0) {
                    if (this.specialMap != null) {
                        int[] iArrNameToUnicode = GlyphList.nameToUnicode(this.differences[i4]);
                        metricsTT = iArrNameToUnicode != null ? getMetricsTT(iArrNameToUnicode[0]) : null;
                    } else {
                        metricsTT = this.fontSpecific ? getMetricsTT(i4) : getMetricsTT(this.unicodeDifferences[i4]);
                    }
                    if (metricsTT != null) {
                        hashSet.add(Integer.valueOf(metricsTT[0]));
                    }
                }
            }
            addRangeUni(hashSet, z);
            byte[] fullFont = (!z && this.directoryOffset == 0 && this.subsetRanges == null) ? getFullFont() : getSubSet(new HashSet(hashSet), z);
            indirectReference = pdfWriter.addToBody(new BaseFont.StreamFont(fullFont, new int[]{fullFont.length}, this.compressionLevel)).getIndirectReference();
        }
        String str = strCreateSubsetPrefix;
        PdfDictionary fontDescriptor = getFontDescriptor(indirectReference, str, null);
        if (fontDescriptor != null) {
            indirectReference = pdfWriter.addToBody(fontDescriptor).getIndirectReference();
        }
        pdfWriter.addToBody(getFontBaseType(indirectReference, str, i, i2, bArr), pdfIndirectReference);
    }

    public TrueTypeFont(String str, String str2, boolean z, byte[] bArr, boolean z2, boolean z3) throws DocumentException {
        this.justNames = false;
        this.cff = false;
        this.style = "";
        this.head = new FontHeader();
        this.hhea = new HorizontalHeader();
        this.os_2 = new WindowsMetrics();
        this.kerning = new IntHashtable();
        this.isFixedPitch = false;
        this.justNames = z2;
        String baseName = BaseFont.getBaseName(str);
        String tTCName = getTTCName(baseName);
        if (baseName.length() < str.length()) {
            this.style = str.substring(baseName.length());
        }
        this.encoding = str2;
        this.embedded = z;
        this.fileName = tTCName;
        this.fontType = 1;
        this.ttcIndex = "";
        if (tTCName.length() < baseName.length()) {
            this.ttcIndex = baseName.substring(tTCName.length() + 1);
        }
        if (!this.fileName.toLowerCase().endsWith(".ttf") && !this.fileName.toLowerCase().endsWith(".otf") && !this.fileName.toLowerCase().endsWith(".ttc")) {
            throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.ttf.otf.or.ttc.font.file", this.fileName + this.style));
        }
        process(bArr, z3);
        if (!z2 && this.embedded && this.os_2.fsType == 2) {
            throw new DocumentException(MessageLocalization.getComposedMessage("1.cannot.be.embedded.due.to.licensing.restrictions", this.fileName + this.style));
        }
        if (!this.encoding.startsWith("#")) {
            PdfEncodings.convertToBytes(" ", str2);
        }
        createEncoding();
    }

    public void addRangeUni(HashSet<Integer> hashSet, boolean z) {
        HashMap<Integer, int[]> map;
        if (z) {
            return;
        }
        ArrayList<int[]> arrayList = this.subsetRanges;
        if (arrayList != null || this.directoryOffset > 0) {
            int[] iArrCompactRanges = (arrayList != null || this.directoryOffset <= 0) ? compactRanges(arrayList) : new int[]{0, 65535};
            boolean z2 = this.fontSpecific;
            if ((z2 || (map = this.cmap31) == null) && ((!z2 || (map = this.cmap10) == null) && (map = this.cmap31) == null)) {
                map = this.cmap10;
            }
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                Integer numValueOf = Integer.valueOf(entry.getValue()[0]);
                if (!hashSet.contains(numValueOf)) {
                    int iIntValue = entry.getKey().intValue();
                    for (int i = 0; i < iArrCompactRanges.length; i += 2) {
                        if (iIntValue >= iArrCompactRanges[i] && iIntValue <= iArrCompactRanges[i + 1]) {
                            hashSet.add(numValueOf);
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        float f2;
        int i2;
        switch (i) {
            case 1:
                return (this.os_2.sTypoAscender * f) / this.head.unitsPerEm;
            case 2:
                return (this.os_2.sCapHeight * f) / this.head.unitsPerEm;
            case 3:
                return (this.os_2.sTypoDescender * f) / this.head.unitsPerEm;
            case 4:
                return (float) this.italicAngle;
            case 5:
                FontHeader fontHeader = this.head;
                f2 = f * fontHeader.xMin;
                i2 = fontHeader.unitsPerEm;
                break;
            case 6:
                FontHeader fontHeader2 = this.head;
                f2 = f * fontHeader2.yMin;
                i2 = fontHeader2.unitsPerEm;
                break;
            case 7:
                FontHeader fontHeader3 = this.head;
                f2 = f * fontHeader3.xMax;
                i2 = fontHeader3.unitsPerEm;
                break;
            case 8:
                FontHeader fontHeader4 = this.head;
                f2 = f * fontHeader4.yMax;
                i2 = fontHeader4.unitsPerEm;
                break;
            case 9:
                f2 = f * this.hhea.Ascender;
                i2 = this.head.unitsPerEm;
                break;
            case 10:
                f2 = f * this.hhea.Descender;
                i2 = this.head.unitsPerEm;
                break;
            case 11:
                f2 = f * this.hhea.LineGap;
                i2 = this.head.unitsPerEm;
                break;
            case 12:
                f2 = f * this.hhea.advanceWidthMax;
                i2 = this.head.unitsPerEm;
                break;
            case 13:
                return ((this.underlinePosition - (this.underlineThickness / 2)) * f) / this.head.unitsPerEm;
            case 14:
                return (this.underlineThickness * f) / this.head.unitsPerEm;
            case 15:
                return (this.os_2.yStrikeoutPosition * f) / this.head.unitsPerEm;
            case 16:
                return (this.os_2.yStrikeoutSize * f) / this.head.unitsPerEm;
            case 17:
                return (this.os_2.ySubscriptYSize * f) / this.head.unitsPerEm;
            case 18:
                return ((-this.os_2.ySubscriptYOffset) * f) / this.head.unitsPerEm;
            case 19:
                return (this.os_2.ySuperscriptYSize * f) / this.head.unitsPerEm;
            case 20:
                return (this.os_2.ySuperscriptYOffset * f) / this.head.unitsPerEm;
            case 21:
                return this.os_2.usWeightClass;
            case 22:
                return this.os_2.usWidthClass;
            default:
                return 0.0f;
        }
        return f2 / i2;
    }
}
