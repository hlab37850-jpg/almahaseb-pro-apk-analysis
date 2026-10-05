package com.itextpdf.text.pdf.fonts.cmaps;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractCMap {
    private String cmapName;
    private String ordering;
    private String registry;
    private int supplement;

    private static int byteArrayToInt(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i = (i << 8) | (b & UnsignedBytes.MAX_VALUE);
        }
        return i;
    }

    public static byte[] decodeStringToByte(PdfString pdfString) {
        byte[] bytes = pdfString.getBytes();
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    private static void intToByteArray(int i, byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr[length] = (byte) i;
            i >>>= 8;
        }
    }

    public abstract void addChar(PdfString pdfString, PdfObject pdfObject);

    public void addRange(PdfString pdfString, PdfString pdfString2, PdfObject pdfObject) {
        byte[] bArrDecodeStringToByte = decodeStringToByte(pdfString);
        byte[] bArrDecodeStringToByte2 = decodeStringToByte(pdfString2);
        if (bArrDecodeStringToByte.length != bArrDecodeStringToByte2.length || bArrDecodeStringToByte.length == 0) {
            throw new IllegalArgumentException("Invalid map.");
        }
        boolean z = pdfObject instanceof PdfString;
        byte[] bArrDecodeStringToByte3 = z ? decodeStringToByte((PdfString) pdfObject) : null;
        int iByteArrayToInt = byteArrayToInt(bArrDecodeStringToByte);
        int iByteArrayToInt2 = byteArrayToInt(bArrDecodeStringToByte2);
        for (int i = iByteArrayToInt; i <= iByteArrayToInt2; i++) {
            intToByteArray(i, bArrDecodeStringToByte);
            PdfString pdfString3 = new PdfString(bArrDecodeStringToByte);
            pdfString3.setHexWriting(true);
            if (pdfObject instanceof PdfArray) {
                addChar(pdfString3, ((PdfArray) pdfObject).getPdfObject(i - iByteArrayToInt));
            } else if (pdfObject instanceof PdfNumber) {
                addChar(pdfString3, new PdfNumber((((PdfNumber) pdfObject).intValue() + i) - iByteArrayToInt));
            } else if (z) {
                PdfString pdfString4 = new PdfString(bArrDecodeStringToByte3);
                pdfString4.setHexWriting(true);
                int length = bArrDecodeStringToByte3.length - 1;
                bArrDecodeStringToByte3[length] = (byte) (bArrDecodeStringToByte3[length] + 1);
                addChar(pdfString3, pdfString4);
            }
        }
    }

    public String decodeStringToUnicode(PdfString pdfString) {
        return pdfString.isHexWriting() ? PdfEncodings.convertToString(pdfString.getBytes(), "UnicodeBigUnmarked") : pdfString.toUnicodeString();
    }

    public String getName() {
        return this.cmapName;
    }

    public String getOrdering() {
        return this.ordering;
    }

    public String getRegistry() {
        return this.registry;
    }

    public int getSupplement() {
        return this.supplement;
    }

    public void setName(String str) {
        this.cmapName = str;
    }

    public void setOrdering(String str) {
        this.ordering = str;
    }

    public void setRegistry(String str) {
        this.registry = str;
    }

    public void setSupplement(int i) {
        this.supplement = i;
    }
}
