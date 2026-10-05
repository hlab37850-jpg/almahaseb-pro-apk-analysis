package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

/* JADX INFO: loaded from: classes3.dex */
public class Barcode39 extends Barcode {
    private static final byte[][] BARS = {new byte[]{0, 0, 0, 1, 1, 0, 1, 0, 0}, new byte[]{1, 0, 0, 1, 0, 0, 0, 0, 1}, new byte[]{0, 0, 1, 1, 0, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 0, 1, 1, 0, 0, 0, 0}, new byte[]{0, 0, 1, 1, 1, 0, 0, 0, 0}, new byte[]{0, 0, 0, 1, 0, 0, 1, 0, 1}, new byte[]{1, 0, 0, 1, 0, 0, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0, 0, 1, 0, 0}, new byte[]{1, 0, 0, 0, 0, 1, 0, 0, 1}, new byte[]{0, 0, 1, 0, 0, 1, 0, 0, 1}, new byte[]{1, 0, 1, 0, 0, 1, 0, 0, 0}, new byte[]{0, 0, 0, 0, 1, 1, 0, 0, 1}, new byte[]{1, 0, 0, 0, 1, 1, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1, 1, 0, 0, 0}, new byte[]{0, 0, 0, 0, 0, 1, 1, 0, 1}, new byte[]{1, 0, 0, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 0, 0, 1, 1, 1, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 1, 1}, new byte[]{0, 0, 1, 0, 0, 0, 0, 1, 1}, new byte[]{1, 0, 1, 0, 0, 0, 0, 1, 0}, new byte[]{0, 0, 0, 0, 1, 0, 0, 1, 1}, new byte[]{1, 0, 0, 0, 1, 0, 0, 1, 0}, new byte[]{0, 0, 1, 0, 1, 0, 0, 1, 0}, new byte[]{0, 0, 0, 0, 0, 0, 1, 1, 1}, new byte[]{1, 0, 0, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 0, 1, 0, 1, 1, 0}, new byte[]{1, 1, 0, 0, 0, 0, 0, 0, 1}, new byte[]{0, 1, 1, 0, 0, 0, 0, 0, 1}, new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, new byte[]{0, 1, 0, 0, 1, 0, 0, 0, 1}, new byte[]{1, 1, 0, 0, 1, 0, 0, 0, 0}, new byte[]{0, 1, 1, 0, 1, 0, 0, 0, 0}, new byte[]{0, 1, 0, 0, 0, 0, 1, 0, 1}, new byte[]{1, 1, 0, 0, 0, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0, 0, 1, 0, 0}, new byte[]{0, 1, 0, 1, 0, 1, 0, 0, 0}, new byte[]{0, 1, 0, 1, 0, 0, 0, 1, 0}, new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0}, new byte[]{0, 0, 0, 1, 0, 1, 0, 1, 0}, new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 0}};
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%*";
    private static final String EXTENDED = "%U$A$B$C$D$E$F$G$H$I$J$K$L$M$N$O$P$Q$R$S$T$U$V$W$X$Y$Z%A%B%C%D%E  /A/B/C/D/E/F/G/H/I/J/K/L - ./O 0 1 2 3 4 5 6 7 8 9/Z%F%G%H%I%J%V A B C D E F G H I J K L M N O P Q R S T U V W X Y Z%K%L%M%N%O%W+A+B+C+D+E+F+G+H+I+J+K+L+M+N+O+P+Q+R+S+T+U+V+W+X+Y+Z%P%Q%R%S%T";

    public Barcode39() {
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
            this.startStopText = true;
            this.extended = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static byte[] getBarsCode39(String str) {
        String str2 = "*" + str + "*";
        byte[] bArr = new byte[(str2.length() * 10) - 1];
        for (int i = 0; i < str2.length(); i++) {
            int iIndexOf = CHARS.indexOf(str2.charAt(i));
            if (iIndexOf < 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.character.1.is.illegal.in.code.39", str2.charAt(i)));
            }
            System.arraycopy(BARS[iIndexOf], 0, bArr, i * 10, 9);
        }
        return bArr;
    }

    public static char getChecksum(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int iIndexOf = CHARS.indexOf(str.charAt(i2));
            if (iIndexOf < 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.character.1.is.illegal.in.code.39", str.charAt(i2)));
            }
            i += iIndexOf;
        }
        return CHARS.charAt(i % 43);
    }

    public static String getCode39Ex(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 127) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.character.1.is.illegal.in.code.39.extended", cCharAt));
            }
            int i2 = cCharAt * 2;
            char cCharAt2 = EXTENDED.charAt(i2);
            char cCharAt3 = EXTENDED.charAt(i2 + 1);
            if (cCharAt2 != ' ') {
                sb.append(cCharAt2);
            }
            sb.append(cCharAt3);
        }
        return sb.toString();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        String code39Ex = this.code;
        if (this.extended) {
            code39Ex = getCode39Ex(code39Ex);
        }
        BaseFont baseFont = this.font;
        float widthPoint = 0.0f;
        if (baseFont != null) {
            float f2 = this.baseline;
            float fontDescriptor = f2 > 0.0f ? f2 - baseFont.getFontDescriptor(3, this.size) : (-f2) + this.size;
            String str = this.code;
            if (this.generateChecksum && this.checksumText) {
                str = str + getChecksum(code39Ex);
            }
            if (this.startStopText) {
                str = "*" + str + "*";
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
        int length = code39Ex.length();
        int i = length + 2;
        if (this.generateChecksum) {
            i = length + 3;
        }
        float f4 = this.x;
        return new Rectangle(Math.max((i * ((6.0f * f4) + (3.0f * f4 * this.n))) + ((i - 1) * f4), widthPoint), this.barHeight + f);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ea A[SYNTHETIC] */
    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        float widthPoint;
        float f;
        float f2;
        BaseFont baseFont;
        float f3;
        byte[] barsCode39;
        int i;
        float f4;
        float f5;
        String str = this.code;
        String code39Ex = this.extended ? getCode39Ex(str) : str;
        float f6 = 0.0f;
        if (this.font != null) {
            if (this.generateChecksum && this.checksumText) {
                str = str + getChecksum(code39Ex);
            }
            if (this.startStopText) {
                str = "*" + str + "*";
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
        if (this.generateChecksum) {
            code39Ex = code39Ex + getChecksum(code39Ex);
        }
        int length = code39Ex.length();
        float f7 = this.x;
        boolean z = true;
        float f8 = ((length + 2) * ((6.0f * f7) + (3.0f * f7 * this.n))) + ((length + 1) * f7);
        int i2 = this.textAlignment;
        if (i2 != 0) {
            if (i2 != 2) {
                if (widthPoint > f8) {
                    f = (widthPoint - f8) / 2.0f;
                } else {
                    f2 = (f8 - widthPoint) / 2.0f;
                    f = 0.0f;
                }
            } else if (widthPoint > f8) {
                f = widthPoint - f8;
            } else {
                f2 = f8 - widthPoint;
                f = 0.0f;
            }
            baseFont = this.font;
            if (baseFont != null) {
                f5 = this.baseline;
                if (f5 <= 0.0f) {
                    f3 = this.barHeight - f5;
                } else {
                    float f9 = -baseFont.getFontDescriptor(3, this.size);
                    f3 = f9;
                    f6 = this.baseline + f9;
                }
            } else {
                f3 = 0.0f;
            }
            barsCode39 = getBarsCode39(code39Ex);
            if (baseColor != null) {
                pdfContentByte.setColorFill(baseColor);
            }
            for (byte b : barsCode39) {
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
                float f10 = -baseFont.getFontDescriptor(3, this.size);
                f3 = f10;
                f6 = this.baseline + f10;
            }
        } else {
            f3 = 0.0f;
        }
        barsCode39 = getBarsCode39(code39Ex);
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        while (i < barsCode39.length) {
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
