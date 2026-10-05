package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.pdf.codec.TIFFFaxDecoder;
import com.itextpdf.text.pdf.codec.TIFFFaxDecompressor;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class FilterHandlers {
    private static final Map<PdfName, FilterHandler> defaults;

    public interface FilterHandler {
        byte[] decode(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary);
    }

    public static class Filter_ASCII85DECODE implements FilterHandler {
        private Filter_ASCII85DECODE() {
        }

        @Override // com.itextpdf.text.pdf.FilterHandlers.FilterHandler
        public byte[] decode(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) {
            return PdfReader.ASCII85Decode(bArr);
        }
    }

    public static class Filter_ASCIIHEXDECODE implements FilterHandler {
        private Filter_ASCIIHEXDECODE() {
        }

        @Override // com.itextpdf.text.pdf.FilterHandlers.FilterHandler
        public byte[] decode(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) {
            return PdfReader.ASCIIHexDecode(bArr);
        }
    }

    public static class Filter_CCITTFAXDECODE implements FilterHandler {
        private Filter_CCITTFAXDECODE() {
        }

        @Override // com.itextpdf.text.pdf.FilterHandlers.FilterHandler
        public byte[] decode(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws UnsupportedPdfException {
            boolean zBooleanValue;
            int iIntValue;
            boolean z;
            PdfNumber pdfNumber = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.WIDTH));
            PdfNumber pdfNumber2 = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.HEIGHT));
            if (pdfNumber == null || pdfNumber2 == null) {
                throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("filter.ccittfaxdecode.is.only.supported.for.images", new Object[0]));
            }
            int iIntValue2 = pdfNumber.intValue();
            int iIntValue3 = pdfNumber2.intValue();
            PdfDictionary pdfDictionary2 = pdfObject instanceof PdfDictionary ? (PdfDictionary) pdfObject : null;
            if (pdfDictionary2 != null) {
                PdfNumber asNumber = pdfDictionary2.getAsNumber(PdfName.K);
                iIntValue = asNumber != null ? asNumber.intValue() : 0;
                PdfBoolean asBoolean = pdfDictionary2.getAsBoolean(PdfName.BLACKIS1);
                boolean zBooleanValue2 = asBoolean != null ? asBoolean.booleanValue() : false;
                PdfBoolean asBoolean2 = pdfDictionary2.getAsBoolean(PdfName.ENCODEDBYTEALIGN);
                if (asBoolean2 != null) {
                    zBooleanValue = asBoolean2.booleanValue();
                    z = zBooleanValue2;
                } else {
                    z = zBooleanValue2;
                    zBooleanValue = false;
                }
            } else {
                zBooleanValue = false;
                iIntValue = 0;
                z = false;
            }
            int i = ((iIntValue2 + 7) / 8) * iIntValue3;
            byte[] bArr2 = new byte[i];
            TIFFFaxDecompressor tIFFFaxDecompressor = new TIFFFaxDecompressor();
            if (iIntValue == 0 || iIntValue > 0) {
                int i2 = (zBooleanValue ? 4 : 0) | (iIntValue > 0 ? 1 : 0);
                tIFFFaxDecompressor.SetOptions(1, 3, i2, 0);
                tIFFFaxDecompressor.decodeRaw(bArr2, bArr, iIntValue2, iIntValue3);
                int i3 = tIFFFaxDecompressor.fails;
                if (i3 > 0) {
                    byte[] bArr3 = new byte[i];
                    tIFFFaxDecompressor.SetOptions(1, 2, i2, 0);
                    tIFFFaxDecompressor.decodeRaw(bArr3, bArr, iIntValue2, iIntValue3);
                    if (tIFFFaxDecompressor.fails < i3) {
                        bArr2 = bArr3;
                    }
                }
            } else {
                new TIFFFaxDecoder(1L, iIntValue2, iIntValue3).decodeT6(bArr2, bArr, 0, iIntValue3, 0L);
            }
            if (!z) {
                int length = bArr2.length;
                for (int i4 = 0; i4 < length; i4++) {
                    bArr2[i4] = (byte) (bArr2[i4] ^ UnsignedBytes.MAX_VALUE);
                }
            }
            return bArr2;
        }
    }

    public static class Filter_DoNothing implements FilterHandler {
        private Filter_DoNothing() {
        }

        @Override // com.itextpdf.text.pdf.FilterHandlers.FilterHandler
        public byte[] decode(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) {
            return bArr;
        }
    }

    public static class Filter_FLATEDECODE implements FilterHandler {
        private Filter_FLATEDECODE() {
        }

        @Override // com.itextpdf.text.pdf.FilterHandlers.FilterHandler
        public byte[] decode(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) {
            return PdfReader.decodePredictor(PdfReader.FlateDecode(bArr), pdfObject);
        }
    }

    public static class Filter_LZWDECODE implements FilterHandler {
        private Filter_LZWDECODE() {
        }

        @Override // com.itextpdf.text.pdf.FilterHandlers.FilterHandler
        public byte[] decode(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) {
            return PdfReader.decodePredictor(PdfReader.LZWDecode(bArr), pdfObject);
        }
    }

    public static class Filter_RUNLENGTHDECODE implements FilterHandler {
        private Filter_RUNLENGTHDECODE() {
        }

        @Override // com.itextpdf.text.pdf.FilterHandlers.FilterHandler
        public byte[] decode(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) {
            byte b;
            int i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (i2 < bArr.length && (b = bArr[i2]) != -128) {
                if (b < 0 || b > 127) {
                    i = i2 + 1;
                    for (int i3 = 0; i3 < 1 - b; i3++) {
                        byteArrayOutputStream.write(bArr[i]);
                    }
                } else {
                    int i4 = b + 1;
                    byteArrayOutputStream.write(bArr, i2, i4);
                    i = i2 + i4;
                }
                i2 = i + 1;
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(PdfName.FLATEDECODE, new Filter_FLATEDECODE());
        map.put(PdfName.FL, new Filter_FLATEDECODE());
        map.put(PdfName.ASCIIHEXDECODE, new Filter_ASCIIHEXDECODE());
        map.put(PdfName.AHX, new Filter_ASCIIHEXDECODE());
        map.put(PdfName.ASCII85DECODE, new Filter_ASCII85DECODE());
        map.put(PdfName.A85, new Filter_ASCII85DECODE());
        map.put(PdfName.LZWDECODE, new Filter_LZWDECODE());
        map.put(PdfName.CCITTFAXDECODE, new Filter_CCITTFAXDECODE());
        map.put(PdfName.CRYPT, new Filter_DoNothing());
        map.put(PdfName.RUNLENGTHDECODE, new Filter_RUNLENGTHDECODE());
        defaults = Collections.unmodifiableMap(map);
    }

    public static Map<PdfName, FilterHandler> getDefaultFilterHandlers() {
        return defaults;
    }
}
