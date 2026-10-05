package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodePostnet extends Barcode {
    private static final byte[][] BARS = {new byte[]{1, 1, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{0, 0, 1, 0, 1}, new byte[]{0, 0, 1, 1, 0}, new byte[]{0, 1, 0, 0, 1}, new byte[]{0, 1, 0, 1, 0}, new byte[]{0, 1, 1, 0, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{1, 0, 0, 1, 0}, new byte[]{1, 0, 1, 0, 0}};

    public BarcodePostnet() {
        this.n = 3.2727273f;
        this.x = 1.4399999f;
        this.barHeight = 9.0f;
        this.size = 3.6000001f;
        this.codeType = 7;
    }

    public static byte[] getBarsPostnet(String str) {
        int iCharAt = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            iCharAt += str.charAt(length) - '0';
        }
        String str2 = str + ((char) (((10 - (iCharAt % 10)) % 10) + 48));
        int length2 = str2.length() * 5;
        byte[] bArr = new byte[length2 + 2];
        bArr[0] = 1;
        bArr[length2 + 1] = 1;
        for (int i = 0; i < str2.length(); i++) {
            System.arraycopy(BARS[str2.charAt(i) - '0'], 0, bArr, (i * 5) + 1, 5);
        }
        return bArr;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        return new Rectangle(((((this.code.length() + 1) * 5) + 1) * this.n) + this.x, this.barHeight);
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        byte[] barsPostnet = getBarsPostnet(this.code);
        byte b = 1;
        if (this.codeType == 8) {
            barsPostnet[0] = 0;
            barsPostnet[barsPostnet.length - 1] = 0;
            b = 0;
        }
        float f = 0.0f;
        for (byte b2 : barsPostnet) {
            pdfContentByte.rectangle(f, 0.0f, this.x - this.inkSpreading, b2 == b ? this.barHeight : this.size);
            f += this.n;
        }
        pdfContentByte.fill();
        return getBarcodeSize();
    }
}
