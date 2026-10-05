package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.fonts.cmaps.CMapByteCid;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCache;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidUni;
import com.itextpdf.text.pdf.fonts.cmaps.CMapParserEx;
import com.itextpdf.text.pdf.fonts.cmaps.CMapSequence;
import com.itextpdf.text.pdf.fonts.cmaps.CMapToUnicode;
import com.itextpdf.text.pdf.fonts.cmaps.CidLocationFromByte;
import com.itextpdf.text.pdf.fonts.cmaps.IdentityToUnicode;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CMapAwareDocumentFont extends DocumentFont {
    private CMapByteCid byteCid;
    private CMapCidUni cidUni;
    private char[] cidbyte2uni;
    private PdfDictionary fontDic;
    private int spaceWidth;
    private CMapToUnicode toUnicodeCmap;
    private Map<Integer, Integer> uni2cid;

    public CMapAwareDocumentFont(PdfDictionary pdfDictionary) {
        super(pdfDictionary);
        this.fontDic = pdfDictionary;
        initFont();
    }

    private int computeAverageWidth() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.widths;
            if (i >= iArr.length) {
                break;
            }
            int i4 = iArr[i];
            if (i4 != 0) {
                i3 += i4;
                i2++;
            }
            i++;
        }
        if (i2 != 0) {
            return i3 / i2;
        }
        return 0;
    }

    private String decodeSingleCID(byte[] bArr, int i, int i2) {
        CMapToUnicode cMapToUnicode = this.toUnicodeCmap;
        if (cMapToUnicode != null) {
            int i3 = i + i2;
            if (i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(MessageLocalization.getComposedMessage("invalid.index.1", i3));
            }
            String strLookup = cMapToUnicode.lookup(bArr, i, i2);
            if (strLookup != null) {
                return strLookup;
            }
            if (i2 != 1 || this.cidbyte2uni == null) {
                return null;
            }
        }
        if (i2 != 1) {
            throw new Error("Multi-byte glyphs not implemented yet");
        }
        char[] cArr = this.cidbyte2uni;
        return cArr == null ? "" : new String(cArr, bArr[i] & UnsignedBytes.MAX_VALUE, 1);
    }

    private void initFont() {
        processToUnicode();
        try {
            processUni2Byte();
            int width = super.getWidth(32);
            this.spaceWidth = width;
            if (width == 0) {
                this.spaceWidth = computeAverageWidth();
            }
            String str = this.cjkEncoding;
            if (str != null) {
                this.byteCid = CMapCache.getCachedCMapByteCid(str);
                this.cidUni = CMapCache.getCachedCMapCidUni(this.uniMap);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private void processToUnicode() {
        PdfDictionary asDict;
        PdfString asString;
        CMapToUnicode cMapToUnicodeGetMapFromOrdering;
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(this.fontDic.get(PdfName.TOUNICODE));
        if (pdfObjectRelease instanceof PRStream) {
            try {
                CidLocationFromByte cidLocationFromByte = new CidLocationFromByte(PdfReader.getStreamBytes((PRStream) pdfObjectRelease));
                CMapToUnicode cMapToUnicode = new CMapToUnicode();
                this.toUnicodeCmap = cMapToUnicode;
                CMapParserEx.parseCid("", cMapToUnicode, cidLocationFromByte);
                this.uni2cid = this.toUnicodeCmap.createReverseMapping();
                return;
            } catch (IOException unused) {
                this.toUnicodeCmap = null;
                this.uni2cid = null;
                return;
            }
        }
        if (this.isType0) {
            try {
                PdfName asName = this.fontDic.getAsName(PdfName.ENCODING);
                if (asName == null || !PdfName.decodeName(asName.toString()).equals(BaseFont.IDENTITY_H) || (asDict = ((PdfDictionary) PdfReader.getPdfObjectRelease(((PdfArray) PdfReader.getPdfObjectRelease(this.fontDic.get(PdfName.DESCENDANTFONTS))).getPdfObject(0))).getAsDict(PdfName.CIDSYSTEMINFO)) == null || (asString = asDict.getAsString(PdfName.ORDERING)) == null || (cMapToUnicodeGetMapFromOrdering = IdentityToUnicode.GetMapFromOrdering(asString.toUnicodeString())) == null) {
                    return;
                }
                this.toUnicodeCmap = cMapToUnicodeGetMapFromOrdering;
                this.uni2cid = cMapToUnicodeGetMapFromOrdering.createReverseMapping();
            } catch (IOException unused2) {
                this.toUnicodeCmap = null;
                this.uni2cid = null;
            }
        }
    }

    private void processUni2Byte() {
        IntHashtable byte2Uni = getByte2Uni();
        int[] orderedKeys = byte2Uni.toOrderedKeys();
        if (orderedKeys.length == 0) {
            return;
        }
        this.cidbyte2uni = new char[256];
        for (int i : orderedKeys) {
            this.cidbyte2uni[i] = (char) byte2Uni.get(i);
        }
        CMapToUnicode cMapToUnicode = this.toUnicodeCmap;
        if (cMapToUnicode != null) {
            for (Map.Entry<Integer, Integer> entry : cMapToUnicode.createDirectMapping().entrySet()) {
                if (entry.getKey().intValue() < 256) {
                    this.cidbyte2uni[entry.getKey().intValue()] = (char) entry.getValue().intValue();
                }
            }
        }
        IntHashtable diffmap = getDiffmap();
        if (diffmap != null) {
            int[] orderedKeys2 = diffmap.toOrderedKeys();
            for (int i2 = 0; i2 < orderedKeys2.length; i2++) {
                int i3 = diffmap.get(orderedKeys2[i2]);
                if (i3 < 256) {
                    this.cidbyte2uni[i3] = (char) orderedKeys2[i2];
                }
            }
        }
    }

    public String decode(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (this.toUnicodeCmap != null || this.byteCid == null) {
            int i3 = i;
            while (true) {
                int i4 = i + i2;
                if (i3 >= i4) {
                    break;
                }
                String strDecodeSingleCID = decodeSingleCID(bArr, i3, 1);
                if (strDecodeSingleCID == null && i3 < i4 - 1) {
                    strDecodeSingleCID = decodeSingleCID(bArr, i3, 2);
                    i3++;
                }
                if (strDecodeSingleCID != null) {
                    sb.append(strDecodeSingleCID);
                }
                i3++;
            }
        } else {
            String strDecodeSequence = this.byteCid.decodeSequence(new CMapSequence(bArr, i, i2));
            for (int i5 = 0; i5 < strDecodeSequence.length(); i5++) {
                int iLookup = this.cidUni.lookup(strDecodeSequence.charAt(i5));
                if (iLookup > 0) {
                    sb.append(Utilities.convertFromUtf32(iLookup));
                }
            }
        }
        return sb.toString();
    }

    public String encode(byte[] bArr, int i, int i2) {
        return decode(bArr, i, i2);
    }

    @Override // com.itextpdf.text.pdf.DocumentFont, com.itextpdf.text.pdf.BaseFont
    public int getWidth(int i) {
        if (i != 32) {
            return super.getWidth(i);
        }
        int i2 = this.spaceWidth;
        return i2 != 0 ? i2 : this.defaultWidth;
    }

    public CMapAwareDocumentFont(PRIndirectReference pRIndirectReference) {
        super(pRIndirectReference);
        this.fontDic = (PdfDictionary) PdfReader.getPdfObjectRelease(pRIndirectReference);
        initFont();
    }
}
