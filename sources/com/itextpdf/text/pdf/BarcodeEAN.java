package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeEAN extends Barcode {
    private static final int EVEN = 1;
    private static final int ODD = 0;
    private static final int TOTALBARS_EAN13 = 59;
    private static final int TOTALBARS_EAN8 = 43;
    private static final int TOTALBARS_SUPP2 = 13;
    private static final int TOTALBARS_SUPP5 = 31;
    private static final int TOTALBARS_UPCE = 33;
    private static final int[] GUARD_EMPTY = new int[0];
    private static final int[] GUARD_UPCA = {0, 2, 4, 6, 28, 30, 52, 54, 56, 58};
    private static final int[] GUARD_EAN13 = {0, 2, 28, 30, 56, 58};
    private static final int[] GUARD_EAN8 = {0, 2, 20, 22, 40, 42};
    private static final int[] GUARD_UPCE = {0, 2, 28, 30, 32};
    private static final float[] TEXTPOS_EAN13 = {6.5f, 13.5f, 20.5f, 27.5f, 34.5f, 41.5f, 53.5f, 60.5f, 67.5f, 74.5f, 81.5f, 88.5f};
    private static final float[] TEXTPOS_EAN8 = {6.5f, 13.5f, 20.5f, 27.5f, 39.5f, 46.5f, 53.5f, 60.5f};
    private static final byte[][] BARS = {new byte[]{3, 2, 1, 1}, new byte[]{2, 2, 2, 1}, new byte[]{2, 1, 2, 2}, new byte[]{1, 4, 1, 1}, new byte[]{1, 1, 3, 2}, new byte[]{1, 2, 3, 1}, new byte[]{1, 1, 1, 4}, new byte[]{1, 3, 1, 2}, new byte[]{1, 2, 1, 3}, new byte[]{3, 1, 1, 2}};
    private static final byte[][] PARITY13 = {new byte[]{0, 0, 0, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1, 1}, new byte[]{0, 0, 1, 1, 0, 1}, new byte[]{0, 0, 1, 1, 1, 0}, new byte[]{0, 1, 0, 0, 1, 1}, new byte[]{0, 1, 1, 0, 0, 1}, new byte[]{0, 1, 1, 1, 0, 0}, new byte[]{0, 1, 0, 1, 0, 1}, new byte[]{0, 1, 0, 1, 1, 0}, new byte[]{0, 1, 1, 0, 1, 0}};
    private static final byte[][] PARITY2 = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{1, 0}, new byte[]{1, 1}};
    private static final byte[][] PARITY5 = {new byte[]{1, 1, 0, 0, 0}, new byte[]{1, 0, 1, 0, 0}, new byte[]{1, 0, 0, 1, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{0, 1, 0, 1, 0}, new byte[]{0, 1, 0, 0, 1}, new byte[]{0, 0, 1, 0, 1}};
    private static final byte[][] PARITYE = {new byte[]{1, 1, 1, 0, 0, 0}, new byte[]{1, 1, 0, 1, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0}, new byte[]{1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0}, new byte[]{1, 0, 0, 1, 1, 0}, new byte[]{1, 0, 0, 0, 1, 1}, new byte[]{1, 0, 1, 0, 1, 0}, new byte[]{1, 0, 1, 0, 0, 1}, new byte[]{1, 0, 0, 1, 0, 1}};

    public BarcodeEAN() {
        try {
            this.x = 0.8f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = 8.0f;
            this.barHeight = 8.0f * 3.0f;
            this.guardBars = true;
            this.codeType = 1;
            this.code = "";
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static int calculateEANParity(String str) {
        int i = 3;
        int iCharAt = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            iCharAt += (str.charAt(length) - '0') * i;
            i ^= 2;
        }
        return (10 - (iCharAt % 10)) % 10;
    }

    public static String convertUPCAtoUPCE(String str) {
        if (str.length() == 12 && (str.startsWith("0") || str.startsWith("1"))) {
            if (str.substring(3, 6).equals("000") || str.substring(3, 6).equals("100") || str.substring(3, 6).equals("200")) {
                if (str.substring(6, 8).equals("00")) {
                    return str.substring(0, 1) + str.substring(1, 3) + str.substring(8, 11) + str.substring(3, 4) + str.substring(11);
                }
            } else if (str.substring(4, 6).equals("00")) {
                if (str.substring(6, 9).equals("000")) {
                    return str.substring(0, 1) + str.substring(1, 4) + str.substring(9, 11) + "3" + str.substring(11);
                }
            } else if (str.substring(5, 6).equals("0")) {
                if (str.substring(6, 10).equals("0000")) {
                    return str.substring(0, 1) + str.substring(1, 5) + str.substring(10, 11) + "4" + str.substring(11);
                }
            } else if (str.charAt(10) >= '5' && str.substring(6, 10).equals("0000")) {
                return str.substring(0, 1) + str.substring(1, 6) + str.substring(10, 11) + str.substring(11);
            }
        }
        return null;
    }

    public static byte[] getBarsEAN13(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[59];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        byte[] bArr2 = PARITY13[iArr[0]];
        int i2 = 0;
        int i3 = 3;
        while (i2 < bArr2.length) {
            int i4 = i2 + 1;
            byte[] bArr3 = BARS[iArr[i4]];
            if (bArr2[i2] == 0) {
                bArr[i3] = bArr3[0];
                bArr[i3 + 1] = bArr3[1];
                int i5 = i3 + 3;
                bArr[i3 + 2] = bArr3[2];
                i3 += 4;
                bArr[i5] = bArr3[3];
            } else {
                bArr[i3] = bArr3[3];
                bArr[i3 + 1] = bArr3[2];
                int i6 = i3 + 3;
                bArr[i3 + 2] = bArr3[1];
                i3 += 4;
                bArr[i6] = bArr3[0];
            }
            i2 = i4;
        }
        bArr[i3] = 1;
        bArr[i3 + 1] = 1;
        bArr[i3 + 2] = 1;
        int i7 = i3 + 4;
        bArr[i3 + 3] = 1;
        int i8 = i3 + 5;
        bArr[i7] = 1;
        for (int i9 = 7; i9 < 13; i9++) {
            byte[] bArr4 = BARS[iArr[i9]];
            bArr[i8] = bArr4[0];
            bArr[i8 + 1] = bArr4[1];
            int i10 = i8 + 3;
            bArr[i8 + 2] = bArr4[2];
            i8 += 4;
            bArr[i10] = bArr4[3];
        }
        bArr[i8] = 1;
        bArr[i8 + 1] = 1;
        bArr[i8 + 2] = 1;
        return bArr;
    }

    public static byte[] getBarsEAN8(String str) {
        int i;
        int length = str.length();
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = str.charAt(i2) - '0';
        }
        byte[] bArr = new byte[43];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        int i3 = 0;
        int i4 = 3;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            byte[] bArr2 = BARS[iArr[i3]];
            bArr[i4] = bArr2[0];
            bArr[i4 + 1] = bArr2[1];
            int i5 = i4 + 3;
            bArr[i4 + 2] = bArr2[2];
            i4 += 4;
            bArr[i5] = bArr2[3];
            i3++;
        }
        bArr[i4] = 1;
        bArr[i4 + 1] = 1;
        bArr[i4 + 2] = 1;
        int i6 = i4 + 4;
        bArr[i4 + 3] = 1;
        int i7 = i4 + 5;
        bArr[i6] = 1;
        for (i = 4; i < 8; i++) {
            byte[] bArr3 = BARS[iArr[i]];
            bArr[i7] = bArr3[0];
            bArr[i7 + 1] = bArr3[1];
            int i8 = i7 + 3;
            bArr[i7 + 2] = bArr3[2];
            i7 += 4;
            bArr[i8] = bArr3[3];
        }
        bArr[i7] = 1;
        bArr[i7 + 1] = 1;
        bArr[i7 + 2] = 1;
        return bArr;
    }

    public static byte[] getBarsSupplemental2(String str) {
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[13];
        int i2 = ((iArr[0] * 10) + iArr[1]) % 4;
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = PARITY2[i2];
        int i3 = 3;
        for (int i4 = 0; i4 < bArr2.length; i4++) {
            if (i4 == 1) {
                int i5 = i3 + 1;
                bArr[i3] = 1;
                i3 += 2;
                bArr[i5] = 1;
            }
            byte[] bArr3 = BARS[iArr[i4]];
            if (bArr2[i4] == 0) {
                bArr[i3] = bArr3[0];
                bArr[i3 + 1] = bArr3[1];
                int i6 = i3 + 3;
                bArr[i3 + 2] = bArr3[2];
                i3 += 4;
                bArr[i6] = bArr3[3];
            } else {
                bArr[i3] = bArr3[3];
                bArr[i3 + 1] = bArr3[2];
                int i7 = i3 + 3;
                bArr[i3 + 2] = bArr3[1];
                i3 += 4;
                bArr[i7] = bArr3[0];
            }
        }
        return bArr;
    }

    public static byte[] getBarsSupplemental5(String str) {
        int[] iArr = new int[5];
        for (int i = 0; i < 5; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[31];
        int i2 = ((((iArr[0] + iArr[2]) + iArr[4]) * 3) + ((iArr[1] + iArr[3]) * 9)) % 10;
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = PARITY5[i2];
        int i3 = 3;
        for (int i4 = 0; i4 < bArr2.length; i4++) {
            if (i4 != 0) {
                int i5 = i3 + 1;
                bArr[i3] = 1;
                i3 += 2;
                bArr[i5] = 1;
            }
            byte[] bArr3 = BARS[iArr[i4]];
            if (bArr2[i4] == 0) {
                bArr[i3] = bArr3[0];
                bArr[i3 + 1] = bArr3[1];
                int i6 = i3 + 3;
                bArr[i3 + 2] = bArr3[2];
                i3 += 4;
                bArr[i6] = bArr3[3];
            } else {
                bArr[i3] = bArr3[3];
                bArr[i3 + 1] = bArr3[2];
                int i7 = i3 + 3;
                bArr[i3 + 2] = bArr3[1];
                i3 += 4;
                bArr[i7] = bArr3[0];
            }
        }
        return bArr;
    }

    public static byte[] getBarsUPCE(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[33];
        byte b = iArr[0] != 0 ? (byte) 1 : (byte) 0;
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        int i2 = length - 1;
        byte[] bArr2 = PARITYE[iArr[i2]];
        int i3 = 3;
        for (int i4 = 1; i4 < i2; i4++) {
            byte[] bArr3 = BARS[iArr[i4]];
            if (bArr2[i4 - 1] == b) {
                bArr[i3] = bArr3[0];
                bArr[i3 + 1] = bArr3[1];
                int i5 = i3 + 3;
                bArr[i3 + 2] = bArr3[2];
                i3 += 4;
                bArr[i5] = bArr3[3];
            } else {
                bArr[i3] = bArr3[3];
                bArr[i3 + 1] = bArr3[2];
                int i6 = i3 + 3;
                bArr[i3 + 2] = bArr3[1];
                i3 += 4;
                bArr[i6] = bArr3[0];
            }
        }
        bArr[i3] = 1;
        bArr[i3 + 1] = 1;
        bArr[i3 + 2] = 1;
        bArr[i3 + 3] = 1;
        bArr[i3 + 4] = 1;
        bArr[i3 + 5] = 1;
        return bArr;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        float widthPoint;
        float f2;
        float f3;
        float widthPoint2;
        float widthPoint3;
        float fontDescriptor = this.barHeight;
        BaseFont baseFont = this.font;
        if (baseFont != null) {
            float f4 = this.baseline;
            fontDescriptor = f4 <= 0.0f ? fontDescriptor + (-f4) + this.size : fontDescriptor + (f4 - baseFont.getFontDescriptor(3, this.size));
        }
        switch (this.codeType) {
            case 1:
                f = this.x * 95.0f;
                BaseFont baseFont2 = this.font;
                if (baseFont2 != null) {
                    widthPoint = baseFont2.getWidthPoint(this.code.charAt(0), this.size);
                    f += widthPoint;
                }
                return new Rectangle(f, fontDescriptor);
            case 2:
                f2 = this.x;
                f3 = 67.0f;
                f = f2 * f3;
                return new Rectangle(f, fontDescriptor);
            case 3:
                f = this.x * 95.0f;
                BaseFont baseFont3 = this.font;
                if (baseFont3 != null) {
                    widthPoint2 = baseFont3.getWidthPoint(this.code.charAt(0), this.size);
                    widthPoint3 = this.font.getWidthPoint(this.code.charAt(11), this.size);
                    widthPoint = widthPoint2 + widthPoint3;
                    f += widthPoint;
                }
                return new Rectangle(f, fontDescriptor);
            case 4:
                f = this.x * 51.0f;
                BaseFont baseFont4 = this.font;
                if (baseFont4 != null) {
                    widthPoint2 = baseFont4.getWidthPoint(this.code.charAt(0), this.size);
                    widthPoint3 = this.font.getWidthPoint(this.code.charAt(7), this.size);
                    widthPoint = widthPoint2 + widthPoint3;
                    f += widthPoint;
                }
                return new Rectangle(f, fontDescriptor);
            case 5:
                f2 = this.x;
                f3 = 20.0f;
                f = f2 * f3;
                return new Rectangle(f, fontDescriptor);
            case 6:
                f2 = this.x;
                f3 = 47.0f;
                f = f2 * f3;
                return new Rectangle(f, fontDescriptor);
            default:
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.type", new Object[0]));
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x0057  */
    /* JADX WARN: Code duplicated, block: B:25:0x005e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    /* JADX WARN: Code duplicated, block: B:27:0x0081  */
    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0098  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:48:0x00da  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:57:0x0106  */
    /* JADX WARN: Code duplicated, block: B:60:0x010f A[LOOP:1: B:58:0x0107->B:60:0x010f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x0135  */
    /* JADX WARN: Code duplicated, block: B:64:0x0148 A[LOOP:2: B:62:0x0145->B:64:0x0148, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0184  */
    /* JADX WARN: Code duplicated, block: B:69:0x0198 A[LOOP:3: B:67:0x0194->B:69:0x0198, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d6 A[LOOP:4: B:72:0x01d4->B:73:0x01d6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:77:0x020e A[LOOP:5: B:75:0x020a->B:77:0x020e, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x0067, please report this as an issue */
    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        float f;
        float f2;
        BaseFont baseFont;
        float widthPoint;
        int[] iArr;
        byte[] barsEAN13;
        float f3;
        float f4;
        int i;
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f5;
        float f6;
        Rectangle barcodeSize = getBarcodeSize();
        BaseFont baseFont2 = this.font;
        if (baseFont2 != null) {
            float f7 = this.baseline;
            if (f7 <= 0.0f) {
                f = this.barHeight - f7;
            } else {
                f = -baseFont2.getFontDescriptor(3, this.size);
                f2 = this.baseline + f;
            }
            int i7 = this.codeType;
            widthPoint = ((i7 != 1 || i7 == 3 || i7 == 4) && (baseFont = this.font) != null) ? baseFont.getWidthPoint(this.code.charAt(0), this.size) + 0.0f : 0.0f;
            iArr = GUARD_EMPTY;
            switch (this.codeType) {
                case 1:
                    barsEAN13 = getBarsEAN13(this.code);
                    iArr = GUARD_EAN13;
                    break;
                case 2:
                    barsEAN13 = getBarsEAN8(this.code);
                    iArr = GUARD_EAN8;
                    break;
                case 3:
                    barsEAN13 = getBarsEAN13("0" + this.code);
                    iArr = GUARD_UPCA;
                    break;
                case 4:
                    barsEAN13 = getBarsUPCE(this.code);
                    iArr = GUARD_UPCE;
                    break;
                case 5:
                    barsEAN13 = getBarsSupplemental2(this.code);
                    break;
                case 6:
                    barsEAN13 = getBarsSupplemental5(this.code);
                    break;
                default:
                    barsEAN13 = null;
                    break;
            }
            if (this.font != null) {
                f6 = this.baseline;
                if (f6 > 0.0f || !this.guardBars) {
                    f3 = 0.0f;
                } else {
                    f3 = f6 / 2.0f;
                }
            } else {
                f3 = 0.0f;
            }
            if (baseColor != null) {
                pdfContentByte.setColorFill(baseColor);
            }
            f4 = widthPoint;
            i = 0;
            z = true;
            while (i < barsEAN13.length) {
                f5 = barsEAN13[i] * this.x;
                if (!z) {
                    if (Arrays.binarySearch(iArr, i) >= 0) {
                        pdfContentByte.rectangle(f4, f2 - f3, f5 - this.inkSpreading, this.barHeight + f3);
                    } else {
                        pdfContentByte.rectangle(f4, f2, f5 - this.inkSpreading, this.barHeight);
                    }
                }
                z = !z;
                f4 += f5;
                i++;
                iArr = iArr;
            }
            pdfContentByte.fill();
            if (this.font != null) {
                if (baseColor2 != null) {
                    pdfContentByte.setColorFill(baseColor2);
                }
                pdfContentByte.beginText();
                pdfContentByte.setFontAndSize(this.font, this.size);
                switch (this.codeType) {
                    case 1:
                        pdfContentByte.setTextMatrix(0.0f, f);
                        pdfContentByte.showText(this.code.substring(0, 1));
                        i2 = 1;
                        while (i2 < 13) {
                            int i8 = i2 + 1;
                            String strSubstring = this.code.substring(i2, i8);
                            pdfContentByte.setTextMatrix(((TEXTPOS_EAN13[i2 - 1] * this.x) + widthPoint) - (this.font.getWidthPoint(strSubstring, this.size) / 2.0f), f);
                            pdfContentByte.showText(strSubstring);
                            i2 = i8;
                        }
                        break;
                    case 2:
                        i3 = 0;
                        while (i3 < 8) {
                            int i9 = i3 + 1;
                            String strSubstring2 = this.code.substring(i3, i9);
                            pdfContentByte.setTextMatrix((TEXTPOS_EAN8[i3] * this.x) - (this.font.getWidthPoint(strSubstring2, this.size) / 2.0f), f);
                            pdfContentByte.showText(strSubstring2);
                            i3 = i9;
                        }
                        break;
                    case 3:
                        pdfContentByte.setTextMatrix(0.0f, f);
                        pdfContentByte.showText(this.code.substring(0, 1));
                        i4 = 1;
                        while (i4 < 11) {
                            int i10 = i4 + 1;
                            String strSubstring3 = this.code.substring(i4, i10);
                            pdfContentByte.setTextMatrix(((TEXTPOS_EAN13[i4] * this.x) + widthPoint) - (this.font.getWidthPoint(strSubstring3, this.size) / 2.0f), f);
                            pdfContentByte.showText(strSubstring3);
                            i4 = i10;
                        }
                        pdfContentByte.setTextMatrix(widthPoint + (this.x * 95.0f), f);
                        pdfContentByte.showText(this.code.substring(11, 12));
                        break;
                    case 4:
                        pdfContentByte.setTextMatrix(0.0f, f);
                        pdfContentByte.showText(this.code.substring(0, 1));
                        i5 = 1;
                        while (i5 < 7) {
                            int i11 = i5 + 1;
                            String strSubstring4 = this.code.substring(i5, i11);
                            pdfContentByte.setTextMatrix(((TEXTPOS_EAN13[i5 - 1] * this.x) + widthPoint) - (this.font.getWidthPoint(strSubstring4, this.size) / 2.0f), f);
                            pdfContentByte.showText(strSubstring4);
                            i5 = i11;
                        }
                        pdfContentByte.setTextMatrix(widthPoint + (this.x * 51.0f), f);
                        pdfContentByte.showText(this.code.substring(7, 8));
                        break;
                    case 5:
                    case 6:
                        i6 = 0;
                        while (i6 < this.code.length()) {
                            int i12 = i6 + 1;
                            String strSubstring5 = this.code.substring(i6, i12);
                            pdfContentByte.setTextMatrix((((i6 * 9) + 7.5f) * this.x) - (this.font.getWidthPoint(strSubstring5, this.size) / 2.0f), f);
                            pdfContentByte.showText(strSubstring5);
                            i6 = i12;
                        }
                        break;
                }
                pdfContentByte.endText();
            }
            return barcodeSize;
        }
        f = 0.0f;
        f2 = 0.0f;
        int i13 = this.codeType;
        if (i13 != 1) {
        }
        iArr = GUARD_EMPTY;
        switch (this.codeType) {
            case 1:
                barsEAN13 = getBarsEAN13(this.code);
                iArr = GUARD_EAN13;
                break;
            case 2:
                barsEAN13 = getBarsEAN8(this.code);
                iArr = GUARD_EAN8;
                break;
            case 3:
                barsEAN13 = getBarsEAN13("0" + this.code);
                iArr = GUARD_UPCA;
                break;
            case 4:
                barsEAN13 = getBarsUPCE(this.code);
                iArr = GUARD_UPCE;
                break;
            case 5:
                barsEAN13 = getBarsSupplemental2(this.code);
                break;
            case 6:
                barsEAN13 = getBarsSupplemental5(this.code);
                break;
            default:
                barsEAN13 = null;
                break;
        }
        if (this.font != null) {
            f6 = this.baseline;
            if (f6 > 0.0f) {
                f3 = 0.0f;
            } else {
                f3 = 0.0f;
            }
        } else {
            f3 = 0.0f;
        }
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        f4 = widthPoint;
        i = 0;
        z = true;
        while (i < barsEAN13.length) {
            f5 = barsEAN13[i] * this.x;
            if (!z) {
                if (Arrays.binarySearch(iArr, i) >= 0) {
                    pdfContentByte.rectangle(f4, f2 - f3, f5 - this.inkSpreading, this.barHeight + f3);
                } else {
                    pdfContentByte.rectangle(f4, f2, f5 - this.inkSpreading, this.barHeight);
                }
            }
            z = !z;
            f4 += f5;
            i++;
            iArr = iArr;
        }
        pdfContentByte.fill();
        if (this.font != null) {
            if (baseColor2 != null) {
                pdfContentByte.setColorFill(baseColor2);
            }
            pdfContentByte.beginText();
            pdfContentByte.setFontAndSize(this.font, this.size);
            switch (this.codeType) {
                case 1:
                    pdfContentByte.setTextMatrix(0.0f, f);
                    pdfContentByte.showText(this.code.substring(0, 1));
                    i2 = 1;
                    while (i2 < 13) {
                        int i14 = i2 + 1;
                        String strSubstring6 = this.code.substring(i2, i14);
                        pdfContentByte.setTextMatrix(((TEXTPOS_EAN13[i2 - 1] * this.x) + widthPoint) - (this.font.getWidthPoint(strSubstring6, this.size) / 2.0f), f);
                        pdfContentByte.showText(strSubstring6);
                        i2 = i14;
                    }
                    break;
                case 2:
                    i3 = 0;
                    while (i3 < 8) {
                        int i15 = i3 + 1;
                        String strSubstring7 = this.code.substring(i3, i15);
                        pdfContentByte.setTextMatrix((TEXTPOS_EAN8[i3] * this.x) - (this.font.getWidthPoint(strSubstring7, this.size) / 2.0f), f);
                        pdfContentByte.showText(strSubstring7);
                        i3 = i15;
                    }
                    break;
                case 3:
                    pdfContentByte.setTextMatrix(0.0f, f);
                    pdfContentByte.showText(this.code.substring(0, 1));
                    i4 = 1;
                    while (i4 < 11) {
                        int i16 = i4 + 1;
                        String strSubstring8 = this.code.substring(i4, i16);
                        pdfContentByte.setTextMatrix(((TEXTPOS_EAN13[i4] * this.x) + widthPoint) - (this.font.getWidthPoint(strSubstring8, this.size) / 2.0f), f);
                        pdfContentByte.showText(strSubstring8);
                        i4 = i16;
                    }
                    pdfContentByte.setTextMatrix(widthPoint + (this.x * 95.0f), f);
                    pdfContentByte.showText(this.code.substring(11, 12));
                    break;
                case 4:
                    pdfContentByte.setTextMatrix(0.0f, f);
                    pdfContentByte.showText(this.code.substring(0, 1));
                    i5 = 1;
                    while (i5 < 7) {
                        int i17 = i5 + 1;
                        String strSubstring9 = this.code.substring(i5, i17);
                        pdfContentByte.setTextMatrix(((TEXTPOS_EAN13[i5 - 1] * this.x) + widthPoint) - (this.font.getWidthPoint(strSubstring9, this.size) / 2.0f), f);
                        pdfContentByte.showText(strSubstring9);
                        i5 = i17;
                    }
                    pdfContentByte.setTextMatrix(widthPoint + (this.x * 51.0f), f);
                    pdfContentByte.showText(this.code.substring(7, 8));
                    break;
                case 5:
                case 6:
                    i6 = 0;
                    while (i6 < this.code.length()) {
                        int i18 = i6 + 1;
                        String strSubstring10 = this.code.substring(i6, i18);
                        pdfContentByte.setTextMatrix((((i6 * 9) + 7.5f) * this.x) - (this.font.getWidthPoint(strSubstring10, this.size) / 2.0f), f);
                        pdfContentByte.showText(strSubstring10);
                        i6 = i18;
                    }
                    break;
            }
            pdfContentByte.endText();
        }
        return barcodeSize;
    }
}
