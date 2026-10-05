package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.pdf.fonts.FontsResourceAnchor;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
class Type1Font extends BaseFont {
    private static final int[] PFB_TYPES = {1, 2, 1};
    private static FontsResourceAnchor resourceAnchor;
    private String CharacterSet;
    private String EncodingScheme;
    private String FamilyName;
    private String FontName;
    private String FullName;
    private int StdHW;
    private boolean builtinFont;
    private String fileName;
    protected byte[] pfb;
    private String Weight = "";
    private float ItalicAngle = 0.0f;
    private boolean IsFixedPitch = false;
    private int llx = -50;
    private int lly = -200;
    private int urx = 1000;
    private int ury = TypedValues.Custom.TYPE_INT;
    private int UnderlinePosition = -100;
    private int UnderlineThickness = 50;
    private int CapHeight = TypedValues.TransitionType.TYPE_DURATION;
    private int XHeight = 480;
    private int Ascender = 800;
    private int Descender = -200;
    private int StdVW = 80;
    private HashMap<Object, Object[]> CharMetrics = new HashMap<>();
    private HashMap<String, Object[]> KernPairs = new HashMap<>();

    public Type1Font(String str, String str2, boolean z, byte[] bArr, byte[] bArr2, boolean z2) throws Throwable {
        this.EncodingScheme = "FontSpecific";
        this.builtinFont = false;
        if (z && bArr != null && bArr2 == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("two.byte.arrays.are.needed.if.the.type1.font.is.embedded", new Object[0]));
        }
        if (z && bArr != null) {
            this.pfb = bArr2;
        }
        this.encoding = str2;
        this.embedded = z;
        this.fileName = str;
        this.fontType = 0;
        RandomAccessFileOrArray randomAccessFileOrArray = null;
        RandomAccessFileOrArray randomAccessFileOrArray2 = null;
        InputStream inputStream = null;
        RandomAccessFileOrArray randomAccessFileOrArray3 = null;
        try {
            if (BaseFont.BuiltinFonts14.containsKey(str)) {
                this.embedded = false;
                this.builtinFont = true;
                byte[] bArr3 = new byte[1024];
                try {
                    if (resourceAnchor == null) {
                        resourceAnchor = new FontsResourceAnchor();
                    }
                    InputStream resourceStream = StreamUtil.getResourceStream(BaseFont.RESOURCE_PATH + str + ".afm", resourceAnchor.getClass().getClassLoader());
                    try {
                        if (resourceStream == null) {
                            String composedMessage = MessageLocalization.getComposedMessage("1.not.found.as.resource", str);
                            System.err.println(composedMessage);
                            throw new DocumentException(composedMessage);
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int i = resourceStream.read(bArr3);
                            if (i < 0) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr3, 0, i);
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            resourceStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            RandomAccessFileOrArray randomAccessFileOrArray4 = new RandomAccessFileOrArray(byteArray);
                            try {
                                process(randomAccessFileOrArray4);
                                randomAccessFileOrArray4.close();
                            } catch (Throwable th) {
                                th = th;
                                randomAccessFileOrArray2 = randomAccessFileOrArray4;
                                if (randomAccessFileOrArray2 != null) {
                                    try {
                                        randomAccessFileOrArray2.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = resourceStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } else if (str.toLowerCase().endsWith(".afm")) {
                try {
                    randomAccessFileOrArray = bArr == null ? new RandomAccessFileOrArray(str, z2, Document.plainRandomAccess) : new RandomAccessFileOrArray(bArr);
                    process(randomAccessFileOrArray);
                    randomAccessFileOrArray.close();
                } catch (Throwable th5) {
                    if (randomAccessFileOrArray != null) {
                        try {
                            randomAccessFileOrArray.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th5;
                }
            } else {
                if (!str.toLowerCase().endsWith(".pfm")) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.an.afm.or.pfm.font.file", str));
                }
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    randomAccessFileOrArray3 = bArr == null ? new RandomAccessFileOrArray(str, z2, Document.plainRandomAccess) : new RandomAccessFileOrArray(bArr);
                    Pfm2afm.convert(randomAccessFileOrArray3, byteArrayOutputStream2);
                    randomAccessFileOrArray3.close();
                    RandomAccessFileOrArray randomAccessFileOrArray5 = new RandomAccessFileOrArray(byteArrayOutputStream2.toByteArray());
                    try {
                        process(randomAccessFileOrArray5);
                        randomAccessFileOrArray5.close();
                    } catch (Throwable th6) {
                        randomAccessFileOrArray3 = randomAccessFileOrArray5;
                        th = th6;
                        if (randomAccessFileOrArray3 == null) {
                            throw th;
                        }
                        try {
                            randomAccessFileOrArray3.close();
                            throw th;
                        } catch (Exception unused5) {
                            throw th;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        } catch (Exception unused6) {
        }
        String strTrim = this.EncodingScheme.trim();
        this.EncodingScheme = strTrim;
        if (strTrim.equals("AdobeStandardEncoding") || this.EncodingScheme.equals("StandardEncoding")) {
            this.fontSpecific = false;
        }
        if (!this.encoding.startsWith("#")) {
            PdfEncodings.convertToBytes(" ", str2);
        }
        createEncoding();
    }

    private PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, int i, int i2, byte[] bArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE1);
        pdfDictionary.put(PdfName.BASEFONT, new PdfName(this.FontName));
        boolean z = this.encoding.equals("Cp1252") || this.encoding.equals(BaseFont.MACROMAN);
        if (!this.fontSpecific || this.specialMap != null) {
            for (int i3 = i; i3 <= i2; i3++) {
                if (!this.differences[i3].equals(BaseFont.notdef)) {
                    i = i3;
                    break;
                }
            }
            if (z) {
                pdfDictionary.put(PdfName.ENCODING, this.encoding.equals("Cp1252") ? PdfName.WIN_ANSI_ENCODING : PdfName.MAC_ROMAN_ENCODING);
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.ENCODING);
                PdfArray pdfArray = new PdfArray();
                boolean z2 = true;
                for (int i4 = i; i4 <= i2; i4++) {
                    if (bArr[i4] != 0) {
                        if (z2) {
                            pdfArray.add(new PdfNumber(i4));
                            z2 = false;
                        }
                        pdfArray.add(new PdfName(this.differences[i4]));
                    } else {
                        z2 = true;
                    }
                }
                pdfDictionary2.put(PdfName.DIFFERENCES, pdfArray);
                pdfDictionary.put(PdfName.ENCODING, pdfDictionary2);
            }
        }
        if (this.specialMap != null || this.forceWidthsOutput || !this.builtinFont || (!this.fontSpecific && !z)) {
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
        }
        if (!this.builtinFont && pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    private PdfDictionary getFontDescriptor(PdfIndirectReference pdfIndirectReference) {
        if (this.builtinFont) {
            return null;
        }
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfNumber(this.Ascender));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfNumber(this.CapHeight));
        pdfDictionary.put(PdfName.DESCENT, new PdfNumber(this.Descender));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfRectangle(this.llx, this.lly, this.urx, this.ury));
        pdfDictionary.put(PdfName.FONTNAME, new PdfName(this.FontName));
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfNumber(this.ItalicAngle));
        pdfDictionary.put(PdfName.STEMV, new PdfNumber(this.StdVW));
        if (pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTFILE, pdfIndirectReference);
        }
        int i = (this.IsFixedPitch ? 1 : 0) | (this.fontSpecific ? 4 : 32);
        if (this.ItalicAngle < 0.0f) {
            i |= 64;
        }
        if (this.FontName.indexOf("Caps") >= 0 || this.FontName.endsWith("SC")) {
            i |= 131072;
        }
        if (this.Weight.equals("Bold")) {
            i |= 262144;
        }
        pdfDictionary.put(PdfName.FLAGS, new PdfNumber(i));
        return pdfDictionary;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.FullName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return new String[][]{new String[]{"", "", "", this.FamilyName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.FullName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() {
        RandomAccessFileOrArray randomAccessFileOrArray = null;
        if (!this.builtinFont) {
            try {
                if (this.embedded) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        String str = this.fileName;
                        sb.append(str.substring(0, str.length() - 3));
                        sb.append("pfb");
                        String string = sb.toString();
                        byte[] bArr = this.pfb;
                        RandomAccessFileOrArray randomAccessFileOrArray2 = bArr == null ? new RandomAccessFileOrArray(string, true, Document.plainRandomAccess) : new RandomAccessFileOrArray(bArr);
                        byte[] bArr2 = new byte[((int) randomAccessFileOrArray2.length()) - 18];
                        int[] iArr = new int[3];
                        int i = 0;
                        for (int i2 = 0; i2 < 3; i2++) {
                            if (randomAccessFileOrArray2.read() != 128) {
                                throw new DocumentException(MessageLocalization.getComposedMessage("start.marker.missing.in.1", string));
                            }
                            if (randomAccessFileOrArray2.read() != PFB_TYPES[i2]) {
                                throw new DocumentException(MessageLocalization.getComposedMessage("incorrect.segment.type.in.1", string));
                            }
                            int i3 = randomAccessFileOrArray2.read() + (randomAccessFileOrArray2.read() << 8) + (randomAccessFileOrArray2.read() << 16) + (randomAccessFileOrArray2.read() << 24);
                            iArr[i2] = i3;
                            while (i3 != 0) {
                                int i4 = randomAccessFileOrArray2.read(bArr2, i, i3);
                                if (i4 < 0) {
                                    throw new DocumentException(MessageLocalization.getComposedMessage("premature.end.in.1", string));
                                }
                                i += i4;
                                i3 -= i4;
                            }
                        }
                        BaseFont.StreamFont streamFont = new BaseFont.StreamFont(bArr2, iArr, this.compressionLevel);
                        try {
                            randomAccessFileOrArray2.close();
                        } catch (Exception unused) {
                        }
                        return streamFont;
                    } catch (Exception e) {
                        throw new DocumentException(e);
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        randomAccessFileOrArray.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getKerning(int i, int i2) {
        String strUnicodeToName;
        Object[] objArr;
        String strUnicodeToName2 = GlyphList.unicodeToName(i);
        if (strUnicodeToName2 == null || (strUnicodeToName = GlyphList.unicodeToName(i2)) == null || (objArr = this.KernPairs.get(strUnicodeToName2)) == null) {
            return 0;
        }
        for (int i3 = 0; i3 < objArr.length; i3 += 2) {
            if (strUnicodeToName.equals(objArr[i3])) {
                return ((Integer) objArr[i3 + 1]).intValue();
            }
        }
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getPostscriptFontName() {
        return this.FontName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getRawCharBBox(int i, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = this.CharMetrics.get(Integer.valueOf(i));
        } else {
            if (str.equals(BaseFont.notdef)) {
                return null;
            }
            objArr = this.CharMetrics.get(str);
        }
        if (objArr != null) {
            return (int[]) objArr[3];
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getRawWidth(int i, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = this.CharMetrics.get(Integer.valueOf(i));
        } else {
            if (str.equals(BaseFont.notdef)) {
                return 0;
            }
            objArr = this.CharMetrics.get(str);
        }
        if (objArr != null) {
            return ((Integer) objArr[1]).intValue();
        }
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return !this.KernPairs.isEmpty();
    }

    public void process(RandomAccessFileOrArray randomAccessFileOrArray) throws DocumentException {
        boolean z;
        Object[] objArr;
        while (true) {
            String line = randomAccessFileOrArray.readLine();
            if (line == null) {
                z = false;
                break;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ,\n\r\t\f");
            if (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.equals("FontName")) {
                    this.FontName = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (strNextToken.equals("FullName")) {
                    this.FullName = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (strNextToken.equals("FamilyName")) {
                    this.FamilyName = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (strNextToken.equals("Weight")) {
                    this.Weight = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (strNextToken.equals("ItalicAngle")) {
                    this.ItalicAngle = Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("IsFixedPitch")) {
                    this.IsFixedPitch = stringTokenizer.nextToken().equals(PdfBoolean.TRUE);
                } else if (strNextToken.equals("CharacterSet")) {
                    this.CharacterSet = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (strNextToken.equals("FontBBox")) {
                    this.llx = (int) Float.parseFloat(stringTokenizer.nextToken());
                    this.lly = (int) Float.parseFloat(stringTokenizer.nextToken());
                    this.urx = (int) Float.parseFloat(stringTokenizer.nextToken());
                    this.ury = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("UnderlinePosition")) {
                    this.UnderlinePosition = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("UnderlineThickness")) {
                    this.UnderlineThickness = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("EncodingScheme")) {
                    this.EncodingScheme = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (strNextToken.equals("CapHeight")) {
                    this.CapHeight = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("XHeight")) {
                    this.XHeight = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("Ascender")) {
                    this.Ascender = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("Descender")) {
                    this.Descender = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("StdHW")) {
                    this.StdHW = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("StdVW")) {
                    this.StdVW = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (strNextToken.equals("StartCharMetrics")) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            throw new DocumentException(MessageLocalization.getComposedMessage("missing.startcharmetrics.in.1", this.fileName));
        }
        while (true) {
            String line2 = randomAccessFileOrArray.readLine();
            if (line2 == null) {
                break;
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(line2);
            if (stringTokenizer2.hasMoreTokens()) {
                if (stringTokenizer2.nextToken().equals("EndCharMetrics")) {
                    z = false;
                    break;
                }
                Integer numValueOf = -1;
                Integer numValueOf2 = Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                StringTokenizer stringTokenizer3 = new StringTokenizer(line2, ";");
                String strNextToken2 = "";
                int[] iArr = null;
                while (stringTokenizer3.hasMoreTokens()) {
                    StringTokenizer stringTokenizer4 = new StringTokenizer(stringTokenizer3.nextToken());
                    if (stringTokenizer4.hasMoreTokens()) {
                        String strNextToken3 = stringTokenizer4.nextToken();
                        if (strNextToken3.equals("C")) {
                            numValueOf = Integer.valueOf(stringTokenizer4.nextToken());
                        } else if (strNextToken3.equals("WX")) {
                            numValueOf2 = Integer.valueOf((int) Float.parseFloat(stringTokenizer4.nextToken()));
                        } else if (strNextToken3.equals("N")) {
                            strNextToken2 = stringTokenizer4.nextToken();
                        } else if (strNextToken3.equals("B")) {
                            iArr = new int[]{Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken())};
                        }
                    }
                }
                Object[] objArr2 = {numValueOf, numValueOf2, strNextToken2, iArr};
                if (numValueOf.intValue() >= 0) {
                    this.CharMetrics.put(numValueOf, objArr2);
                }
                this.CharMetrics.put(strNextToken2, objArr2);
            }
        }
        if (z) {
            throw new DocumentException(MessageLocalization.getComposedMessage("missing.endcharmetrics.in.1", this.fileName));
        }
        if (!this.CharMetrics.containsKey("nonbreakingspace") && (objArr = this.CharMetrics.get("space")) != null) {
            this.CharMetrics.put("nonbreakingspace", objArr);
        }
        while (true) {
            String line3 = randomAccessFileOrArray.readLine();
            if (line3 == null) {
                break;
            }
            StringTokenizer stringTokenizer5 = new StringTokenizer(line3);
            if (stringTokenizer5.hasMoreTokens()) {
                String strNextToken4 = stringTokenizer5.nextToken();
                if (strNextToken4.equals("EndFontMetrics")) {
                    return;
                }
                if (strNextToken4.equals("StartKernPairs")) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            throw new DocumentException(MessageLocalization.getComposedMessage("missing.endfontmetrics.in.1", this.fileName));
        }
        while (true) {
            String line4 = randomAccessFileOrArray.readLine();
            if (line4 == null) {
                break;
            }
            StringTokenizer stringTokenizer6 = new StringTokenizer(line4);
            if (stringTokenizer6.hasMoreTokens()) {
                String strNextToken5 = stringTokenizer6.nextToken();
                if (strNextToken5.equals("KPX")) {
                    String strNextToken6 = stringTokenizer6.nextToken();
                    String strNextToken7 = stringTokenizer6.nextToken();
                    Integer numValueOf3 = Integer.valueOf((int) Float.parseFloat(stringTokenizer6.nextToken()));
                    Object[] objArr3 = this.KernPairs.get(strNextToken6);
                    if (objArr3 == null) {
                        this.KernPairs.put(strNextToken6, new Object[]{strNextToken7, numValueOf3});
                    } else {
                        int length = objArr3.length;
                        Object[] objArr4 = new Object[length + 2];
                        System.arraycopy(objArr3, 0, objArr4, 0, length);
                        objArr4[length] = strNextToken7;
                        objArr4[length + 1] = numValueOf3;
                        this.KernPairs.put(strNextToken6, objArr4);
                    }
                } else if (strNextToken5.equals("EndKernPairs")) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            throw new DocumentException(MessageLocalization.getComposedMessage("missing.endkernpairs.in.1", this.fileName));
        }
        randomAccessFileOrArray.close();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setFontDescriptor(int i, float f) {
        if (i != 1) {
            if (i != 3) {
                if (i != 9) {
                    if (i != 10) {
                        return;
                    }
                }
            }
            this.Descender = (int) f;
            return;
        }
        this.Ascender = (int) f;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        String strUnicodeToName;
        String strUnicodeToName2 = GlyphList.unicodeToName(i);
        if (strUnicodeToName2 == null || (strUnicodeToName = GlyphList.unicodeToName(i2)) == null) {
            return false;
        }
        Object[] objArr = this.KernPairs.get(strUnicodeToName2);
        if (objArr == null) {
            this.KernPairs.put(strUnicodeToName2, new Object[]{strUnicodeToName, Integer.valueOf(i3)});
            return true;
        }
        for (int i4 = 0; i4 < objArr.length; i4 += 2) {
            if (strUnicodeToName.equals(objArr[i4])) {
                objArr[i4 + 1] = Integer.valueOf(i3);
                return true;
            }
        }
        int length = objArr.length;
        Object[] objArr2 = new Object[2 + length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[length] = strUnicodeToName;
        objArr2[length + 1] = Integer.valueOf(i3);
        this.KernPairs.put(strUnicodeToName2, objArr2);
        return true;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
        this.FontName = str;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) {
        int i = 0;
        int iIntValue = ((Integer) objArr[0]).intValue();
        int iIntValue2 = ((Integer) objArr[1]).intValue();
        byte[] bArr = (byte[]) objArr[2];
        if (((Boolean) objArr[3]).booleanValue() && this.subset && this.embedded) {
            i = iIntValue;
        } else {
            iIntValue2 = bArr.length - 1;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = 1;
            }
        }
        PdfStream fullFontStream = getFullFontStream();
        PdfIndirectReference indirectReference = fullFontStream != null ? pdfWriter.addToBody(fullFontStream).getIndirectReference() : null;
        PdfDictionary fontDescriptor = getFontDescriptor(indirectReference);
        if (fontDescriptor != null) {
            indirectReference = pdfWriter.addToBody(fontDescriptor).getIndirectReference();
        }
        pdfWriter.addToBody(getFontBaseType(indirectReference, i, iIntValue2, bArr), pdfIndirectReference);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        int i2;
        switch (i) {
            case 1:
            case 9:
                i2 = this.Ascender;
                break;
            case 2:
                i2 = this.CapHeight;
                break;
            case 3:
            case 10:
                i2 = this.Descender;
                break;
            case 4:
                return this.ItalicAngle;
            case 5:
                i2 = this.llx;
                break;
            case 6:
                i2 = this.lly;
                break;
            case 7:
                i2 = this.urx;
                break;
            case 8:
                i2 = this.ury;
                break;
            case 11:
            default:
                return 0.0f;
            case 12:
                i2 = this.urx - this.llx;
                break;
            case 13:
                i2 = this.UnderlinePosition;
                break;
            case 14:
                i2 = this.UnderlineThickness;
                break;
        }
        return (i2 * f) / 1000.0f;
    }
}
