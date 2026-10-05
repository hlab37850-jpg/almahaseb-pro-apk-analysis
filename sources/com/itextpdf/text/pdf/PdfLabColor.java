package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class PdfLabColor implements ICachedColorSpace {
    float[] blackPoint;
    float[] range;
    float[] whitePoint;

    public PdfLabColor() {
        this.whitePoint = new float[]{0.9505f, 1.0f, 1.089f};
        this.blackPoint = null;
        this.range = null;
    }

    private static double fXyz(double d) {
        return d > 0.008856d ? Math.pow(d, 0.3333333333333333d) : (d * 7.787d) + 0.13793103448275862d;
    }

    @Override // com.itextpdf.text.pdf.ICachedColorSpace
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PdfLabColor)) {
            return false;
        }
        PdfLabColor pdfLabColor = (PdfLabColor) obj;
        return Arrays.equals(this.blackPoint, pdfLabColor.blackPoint) && Arrays.equals(this.range, pdfLabColor.range) && Arrays.equals(this.whitePoint, pdfLabColor.whitePoint);
    }

    @Override // com.itextpdf.text.pdf.ICachedColorSpace
    public PdfObject getPdfObject(PdfWriter pdfWriter) {
        PdfArray pdfArray = new PdfArray(PdfName.LAB);
        PdfDictionary pdfDictionary = new PdfDictionary();
        float[] fArr = this.whitePoint;
        if (fArr != null && fArr.length == 3 && fArr[0] >= 1.0E-6f && fArr[2] >= 1.0E-6f) {
            float f = fArr[1];
            if (f >= 0.999999f && f <= 1.000001f) {
                pdfDictionary.put(PdfName.WHITEPOINT, new PdfArray(fArr));
                float[] fArr2 = this.blackPoint;
                if (fArr2 != null) {
                    if (fArr2.length != 3 || fArr2[0] < -1.0E-6f || fArr2[1] < -1.0E-6f || fArr2[2] < -1.0E-6f) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("lab.cs.black.point", new Object[0]));
                    }
                    pdfDictionary.put(PdfName.BLACKPOINT, new PdfArray(fArr2));
                }
                float[] fArr3 = this.range;
                if (fArr3 != null) {
                    if (fArr3.length != 4 || fArr3[0] > fArr3[1] || fArr3[2] > fArr3[3]) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("lab.cs.range", new Object[0]));
                    }
                    pdfDictionary.put(PdfName.RANGE, new PdfArray(fArr3));
                }
                pdfArray.add(pdfDictionary);
                return pdfArray;
            }
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("lab.cs.white.point", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.ICachedColorSpace
    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.whitePoint) * 31;
        float[] fArr = this.blackPoint;
        int iHashCode2 = (iHashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31;
        float[] fArr2 = this.range;
        return iHashCode2 + (fArr2 != null ? Arrays.hashCode(fArr2) : 0);
    }

    public CMYKColor lab2Cmyk(float f, float f2, float f3) {
        double d;
        double d2;
        double[] dArrLab2RgbLinear = lab2RgbLinear(f, f2, f3);
        double d3 = dArrLab2RgbLinear[0];
        double d4 = dArrLab2RgbLinear[1];
        double d5 = dArrLab2RgbLinear[2];
        double d6 = 1.0d;
        double d7 = 0.0d;
        if (d3 == 0.0d && d4 == 0.0d && f3 == 0.0f) {
            d2 = 0.0d;
            d = 0.0d;
        } else {
            double d8 = 1.0d - d3;
            double d9 = 1.0d - d4;
            double d10 = 1.0d - d5;
            double dMin = Math.min(d8, Math.min(d9, d10));
            double d11 = 1.0d - dMin;
            double d12 = (d8 - dMin) / d11;
            d = (d9 - dMin) / d11;
            double d13 = (d10 - dMin) / d11;
            d6 = dMin;
            d7 = d12;
            d2 = d13;
        }
        return new CMYKColor((float) d7, (float) d, (float) d2, (float) d6);
    }

    public BaseColor lab2Rgb(float f, float f2, float f3) {
        double[] dArrLab2RgbLinear = lab2RgbLinear(f, f2, f3);
        return new BaseColor((float) dArrLab2RgbLinear[0], (float) dArrLab2RgbLinear[1], (float) dArrLab2RgbLinear[2]);
    }

    public double[] lab2RgbLinear(float f, float f2, float f3) {
        float f4;
        float f5;
        float[] fArr = this.range;
        if (fArr == null || fArr.length != 4) {
            f4 = f2;
            f5 = f3;
        } else {
            f4 = fArr[0];
            if (f2 >= f4) {
                f4 = f2;
            }
            float f6 = fArr[1];
            if (f4 > f6) {
                f4 = f6;
            }
            float f7 = fArr[2];
            if (f3 >= f7) {
                f7 = f3;
            }
            f5 = fArr[3];
            if (f7 <= f5) {
                f5 = f7;
            }
        }
        double d = ((double) (f + 16.0f)) / 116.0d;
        double d2 = (((double) f4) / 500.0d) + d;
        double d3 = d - (((double) f5) / 200.0d);
        double d4 = d2 > 0.20689655172413793d ? ((double) this.whitePoint[0]) * d2 * d2 * d2 : (d2 - 0.13793103448275862d) * 3.0d * 0.04280618311533888d * ((double) this.whitePoint[0]);
        double d5 = d > 0.20689655172413793d ? ((double) this.whitePoint[1]) * d * d * d : ((double) this.whitePoint[1]) * (d - 0.13793103448275862d) * 3.0d * 0.04280618311533888d;
        double d6 = d3 > 0.20689655172413793d ? ((double) this.whitePoint[2]) * d3 * d3 * d3 : (d3 - 0.13793103448275862d) * 3.0d * 0.04280618311533888d * ((double) this.whitePoint[2]);
        double[] dArr = new double[3];
        dArr[0] = ((3.241d * d4) - (1.5374d * d5)) - (0.4986d * d6);
        dArr[1] = (((-d4) * 0.9692d) + (1.876d * d5)) - (0.0416d * d6);
        dArr[2] = ((d4 * 0.0556d) - (d5 * 0.204d)) + (d6 * 1.057d);
        for (int i = 0; i < 3; i++) {
            double d7 = dArr[i];
            double dPow = d7 <= 0.0031308d ? d7 * 12.92d : (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d;
            dArr[i] = dPow;
            if (dPow < 0.0d) {
                dArr[i] = 0.0d;
            } else if (dPow > 1.0d) {
                dArr[i] = 1.0d;
            }
        }
        return dArr;
    }

    public LabColor rgb2lab(BaseColor baseColor) {
        double red = baseColor.getRed() / 255.0f;
        double green = baseColor.getGreen() / 255.0f;
        double blue = baseColor.getBlue() / 255.0f;
        double dPow = red > 0.04045d ? Math.pow((red + 0.055d) / 1.055d, 2.2d) : red / 12.92d;
        double dPow2 = green > 0.04045d ? Math.pow((green + 0.055d) / 1.055d, 2.2d) : green / 12.92d;
        double dPow3 = blue > 0.04045d ? Math.pow((blue + 0.055d) / 1.055d, 2.2d) : blue / 12.92d;
        double d = (0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3);
        return new LabColor(this, Math.round(((fXyz(d / ((double) this.whitePoint[1])) * 116.0d) - 16.0d) * 1000.0d) / 1000.0f, Math.round(((fXyz((((0.4124d * dPow) + (0.3576d * dPow2)) + (0.1805d * dPow3)) / ((double) this.whitePoint[0])) - fXyz(d / ((double) this.whitePoint[1]))) * 500.0d) * 1000.0d) / 1000.0f, Math.round(((fXyz(d / ((double) this.whitePoint[1])) - fXyz((((dPow * 0.0193d) + (dPow2 * 0.1192d)) + (dPow3 * 0.9505d)) / ((double) this.whitePoint[2]))) * 200.0d) * 1000.0d) / 1000.0f);
    }

    public PdfLabColor(float[] fArr) {
        this.whitePoint = new float[]{0.9505f, 1.0f, 1.089f};
        this.blackPoint = null;
        this.range = null;
        if (fArr != null && fArr.length == 3 && fArr[0] >= 1.0E-6f && fArr[2] >= 1.0E-6f) {
            float f = fArr[1];
            if (f >= 0.999999f && f <= 1.000001f) {
                this.whitePoint = fArr;
                return;
            }
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("lab.cs.white.point", new Object[0]));
    }

    public PdfLabColor(float[] fArr, float[] fArr2) {
        this(fArr);
        this.blackPoint = fArr2;
    }

    public PdfLabColor(float[] fArr, float[] fArr2, float[] fArr3) {
        this(fArr, fArr2);
        this.range = fArr3;
    }
}
