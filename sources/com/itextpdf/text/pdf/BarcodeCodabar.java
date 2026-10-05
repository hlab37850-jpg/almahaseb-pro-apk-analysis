package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeCodabar extends Barcode {
    private static final byte[][] BARS = {new byte[]{0, 0, 0, 0, 0, 1, 1}, new byte[]{0, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 1, 0, 0, 1}, new byte[]{1, 1, 0, 0, 0, 0, 0}, new byte[]{0, 0, 1, 0, 0, 1, 0}, new byte[]{1, 0, 0, 0, 0, 1, 0}, new byte[]{0, 1, 0, 0, 0, 0, 1}, new byte[]{0, 1, 0, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0, 0, 0}, new byte[]{1, 0, 0, 1, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0, 0, 0}, new byte[]{1, 0, 0, 0, 1, 0, 1}, new byte[]{1, 0, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 0, 1, 0, 0}, new byte[]{0, 0, 1, 0, 1, 0, 1}, new byte[]{0, 0, 1, 1, 0, 1, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1}, new byte[]{0, 0, 0, 1, 0, 1, 1}, new byte[]{0, 0, 0, 1, 1, 1, 0}};
    private static final String CHARS = "0123456789-$:/.+ABCD";
    private static final int START_STOP_IDX = 16;

    public BarcodeCodabar() {
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
            this.startStopText = false;
            this.codeType = 12;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static String calculateChecksum(String str) {
        if (str.length() < 2) {
            return str;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        int iIndexOf = 0;
        for (int i = 0; i < length; i++) {
            iIndexOf += CHARS.indexOf(upperCase.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        int i2 = length - 1;
        sb.append(str.substring(0, i2));
        sb.append(CHARS.charAt((((iIndexOf + 15) / 16) * 16) - iIndexOf));
        sb.append(str.substring(i2));
        return sb.toString();
    }

    public static byte[] getBarsCodabar(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        if (length < 2) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("codabar.must.have.at.least.a.start.and.stop.character", new Object[0]));
        }
        if (CHARS.indexOf(upperCase.charAt(0)) >= 16) {
            int i = length - 1;
            if (CHARS.indexOf(upperCase.charAt(i)) >= 16) {
                byte[] bArr = new byte[(upperCase.length() * 8) - 1];
                for (int i2 = 0; i2 < length; i2++) {
                    int iIndexOf = CHARS.indexOf(upperCase.charAt(i2));
                    if (iIndexOf >= 16 && i2 > 0 && i2 < i) {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("in.codabar.start.stop.characters.are.only.allowed.at.the.extremes", new Object[0]));
                    }
                    if (iIndexOf < 0) {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.character.1.is.illegal.in.codabar", upperCase.charAt(i2)));
                    }
                    System.arraycopy(BARS[iIndexOf], 0, bArr, i2 * 8, 7);
                }
                return bArr;
            }
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("codabar.must.have.one.of.abcd.as.start.stop.character", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        String strSubstring = this.code;
        if (this.generateChecksum && this.checksumText) {
            strSubstring = calculateChecksum(strSubstring);
        }
        if (!this.startStopText) {
            strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
        }
        BaseFont baseFont = this.font;
        float widthPoint = 0.0f;
        if (baseFont != null) {
            float f2 = this.baseline;
            float fontDescriptor = f2 > 0.0f ? f2 - baseFont.getFontDescriptor(3, this.size) : (-f2) + this.size;
            BaseFont baseFont2 = this.font;
            String str = this.altText;
            if (str != null) {
                strSubstring = str;
            }
            float f3 = fontDescriptor;
            widthPoint = baseFont2.getWidthPoint(strSubstring, this.size);
            f = f3;
        } else {
            f = 0.0f;
        }
        String strCalculateChecksum = this.code;
        if (this.generateChecksum) {
            strCalculateChecksum = calculateChecksum(strCalculateChecksum);
        }
        byte[] barsCodabar = getBarsCodabar(strCalculateChecksum);
        int i = 0;
        for (byte b : barsCodabar) {
            i += b;
        }
        return new Rectangle(Math.max(this.x * ((barsCodabar.length - i) + (i * this.n)), widthPoint), this.barHeight + f);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:46:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x0097  */
    /* JADX WARN: Code duplicated, block: B:51:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b5 A[SYNTHETIC] */
    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        float widthPoint;
        float f;
        float f2;
        BaseFont baseFont;
        float f3;
        float f4;
        float f5;
        String strSubstring = this.code;
        if (this.generateChecksum && this.checksumText) {
            strSubstring = calculateChecksum(strSubstring);
        }
        boolean z = true;
        if (!this.startStopText) {
            strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
        }
        BaseFont baseFont2 = this.font;
        float f6 = 0.0f;
        if (baseFont2 != null) {
            String str = this.altText;
            if (str != null) {
                strSubstring = str;
            }
            widthPoint = baseFont2.getWidthPoint(strSubstring, this.size);
        } else {
            widthPoint = 0.0f;
        }
        byte[] barsCodabar = getBarsCodabar(this.generateChecksum ? calculateChecksum(this.code) : this.code);
        int i = 0;
        for (byte b : barsCodabar) {
            i += b;
        }
        float length = this.x * ((barsCodabar.length - i) + (i * this.n));
        int i2 = this.textAlignment;
        if (i2 != 0) {
            if (i2 != 2) {
                if (widthPoint > length) {
                    f = (widthPoint - length) / 2.0f;
                } else {
                    f2 = (length - widthPoint) / 2.0f;
                    f = 0.0f;
                }
            } else if (widthPoint > length) {
                f = widthPoint - length;
            } else {
                f2 = length - widthPoint;
                f = 0.0f;
            }
            baseFont = this.font;
            if (baseFont != null) {
                f5 = this.baseline;
                if (f5 <= 0.0f) {
                    f3 = this.barHeight - f5;
                } else {
                    float f7 = -baseFont.getFontDescriptor(3, this.size);
                    f3 = f7;
                    f6 = this.baseline + f7;
                }
            } else {
                f3 = 0.0f;
            }
            if (baseColor != null) {
                pdfContentByte.setColorFill(baseColor);
            }
            for (byte b2 : barsCodabar) {
                if (b2 == 0) {
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
                pdfContentByte.showText(strSubstring);
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
                float f8 = -baseFont.getFontDescriptor(3, this.size);
                f3 = f8;
                f6 = this.baseline + f8;
            }
        } else {
            f3 = 0.0f;
        }
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        while (i < barsCodabar.length) {
            if (b2 == 0) {
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
            pdfContentByte.showText(strSubstring);
            pdfContentByte.endText();
        }
        return getBarcodeSize();
    }
}
