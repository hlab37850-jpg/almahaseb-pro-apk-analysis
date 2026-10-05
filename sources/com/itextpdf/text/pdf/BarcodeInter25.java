package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeInter25 extends Barcode {
    private static final byte[][] BARS = {new byte[]{0, 0, 1, 1, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{0, 1, 0, 0, 1}, new byte[]{1, 1, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1}, new byte[]{1, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{1, 0, 0, 1, 0}, new byte[]{0, 1, 0, 1, 0}};

    public BarcodeInter25() {
        try {
            this.x = 0.8f;
            this.n = 2.0f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = 8.0f;
            this.barHeight = 8.0f * 3.0f;
            this.textAlignment = 1;
            this.generateChecksum = false;
            this.checksumText = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static byte[] getBarsInter25(String str) {
        String strKeepNumbers = keepNumbers(str);
        if ((strKeepNumbers.length() & 1) != 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.text.length.must.be.even", new Object[0]));
        }
        byte[] bArr = new byte[(strKeepNumbers.length() * 5) + 7];
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        int length = strKeepNumbers.length() / 2;
        int i = 4;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            int iCharAt = strKeepNumbers.charAt(i3) - '0';
            int iCharAt2 = strKeepNumbers.charAt(i3 + 1) - '0';
            byte[][] bArr2 = BARS;
            byte[] bArr3 = bArr2[iCharAt];
            byte[] bArr4 = bArr2[iCharAt2];
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i + 1;
                bArr[i] = bArr3[i4];
                i += 2;
                bArr[i5] = bArr4[i4];
            }
        }
        bArr[i] = 1;
        bArr[i + 1] = 0;
        bArr[i + 2] = 0;
        return bArr;
    }

    public static char getChecksum(String str) {
        int i = 3;
        int iCharAt = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            iCharAt += (str.charAt(length) - '0') * i;
            i ^= 2;
        }
        return (char) (((10 - (iCharAt % 10)) % 10) + 48);
    }

    public static String keepNumbers(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        BaseFont baseFont = this.font;
        float widthPoint = 0.0f;
        if (baseFont != null) {
            float f2 = this.baseline;
            float fontDescriptor = f2 > 0.0f ? f2 - baseFont.getFontDescriptor(3, this.size) : (-f2) + this.size;
            String str = this.code;
            if (this.generateChecksum && this.checksumText) {
                str = str + getChecksum(str);
            }
            BaseFont baseFont2 = this.font;
            String str2 = this.altText;
            if (str2 != null) {
                str = str2;
            }
            float f3 = fontDescriptor;
            widthPoint = baseFont2.getWidthPoint(str, this.size);
            f = f3;
        } else {
            f = 0.0f;
        }
        int length = keepNumbers(this.code).length();
        if (this.generateChecksum) {
            length++;
        }
        float f4 = this.x;
        float f5 = this.n;
        return new Rectangle(Math.max((length * ((3.0f * f4) + (2.0f * f4 * f5))) + ((f5 + 6.0f) * f4), widthPoint), this.barHeight + f);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0091  */
    /* JADX WARN: Code duplicated, block: B:37:0x0095  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00da  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cb A[SYNTHETIC] */
    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        float widthPoint;
        float f;
        float f2;
        BaseFont baseFont;
        float f3;
        byte[] barsInter25;
        boolean z;
        int i;
        float f4;
        float f5;
        String str = this.code;
        float f6 = 0.0f;
        if (this.font != null) {
            if (this.generateChecksum && this.checksumText) {
                str = str + getChecksum(str);
            }
            BaseFont baseFont2 = this.font;
            String str2 = this.altText;
            if (str2 != null) {
                str = str2;
            }
            widthPoint = baseFont2.getWidthPoint(str, this.size);
        } else {
            widthPoint = 0.0f;
        }
        String strKeepNumbers = keepNumbers(this.code);
        if (this.generateChecksum) {
            strKeepNumbers = strKeepNumbers + getChecksum(strKeepNumbers);
        }
        float length = strKeepNumbers.length();
        float f7 = this.x;
        float f8 = this.n;
        float f9 = (length * ((3.0f * f7) + (f7 * 2.0f * f8))) + ((f8 + 6.0f) * f7);
        int i2 = this.textAlignment;
        if (i2 != 0) {
            if (i2 != 2) {
                if (widthPoint > f9) {
                    f = (widthPoint - f9) / 2.0f;
                } else {
                    f2 = (f9 - widthPoint) / 2.0f;
                    f = 0.0f;
                }
            } else if (widthPoint > f9) {
                f = widthPoint - f9;
            } else {
                f2 = f9 - widthPoint;
                f = 0.0f;
            }
            baseFont = this.font;
            if (baseFont != null) {
                f5 = this.baseline;
                if (f5 <= 0.0f) {
                    f3 = this.barHeight - f5;
                } else {
                    float f10 = -baseFont.getFontDescriptor(3, this.size);
                    f3 = f10;
                    f6 = this.baseline + f10;
                }
            } else {
                f3 = 0.0f;
            }
            barsInter25 = getBarsInter25(strKeepNumbers);
            if (baseColor != null) {
                pdfContentByte.setColorFill(baseColor);
            }
            z = true;
            for (byte b : barsInter25) {
                if (b == 0) {
                    f4 = this.x;
                } else {
                    f4 = this.x * this.n;
                }
                if (z) {
                    pdfContentByte.rectangle(f, f6, f4 - this.inkSpreading, this.barHeight);
                }
                z = !z;
                f += f4;
            }
            pdfContentByte.fill();
            if (this.font != null) {
                if (baseColor2 != null) {
                    pdfContentByte.setColorFill(baseColor2);
                }
                pdfContentByte.beginText();
                pdfContentByte.setFontAndSize(this.font, this.size);
                pdfContentByte.setTextMatrix(f2, f3);
                pdfContentByte.showText(str);
                pdfContentByte.endText();
            }
            return getBarcodeSize();
        }
        f = 0.0f;
        f2 = 0.0f;
        baseFont = this.font;
        if (baseFont != null) {
            f5 = this.baseline;
            if (f5 <= 0.0f) {
                f3 = this.barHeight - f5;
            } else {
                float f11 = -baseFont.getFontDescriptor(3, this.size);
                f3 = f11;
                f6 = this.baseline + f11;
            }
        } else {
            f3 = 0.0f;
        }
        barsInter25 = getBarsInter25(strKeepNumbers);
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        z = true;
        while (i < barsInter25.length) {
            if (b == 0) {
                f4 = this.x;
            } else {
                f4 = this.x * this.n;
            }
            if (z) {
                pdfContentByte.rectangle(f, f6, f4 - this.inkSpreading, this.barHeight);
            }
            z = !z;
            f += f4;
        }
        pdfContentByte.fill();
        if (this.font != null) {
            if (baseColor2 != null) {
                pdfContentByte.setColorFill(baseColor2);
            }
            pdfContentByte.beginText();
            pdfContentByte.setFontAndSize(this.font, this.size);
            pdfContentByte.setTextMatrix(f2, f3);
            pdfContentByte.showText(str);
            pdfContentByte.endText();
        }
        return getBarcodeSize();
    }
}
