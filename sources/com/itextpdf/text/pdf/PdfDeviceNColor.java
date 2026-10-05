package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class PdfDeviceNColor implements ICachedColorSpace, IPdfSpecialColorSpace {
    ColorDetails[] colorantsDetails;
    PdfSpotColor[] spotColors;

    public PdfDeviceNColor(PdfSpotColor[] pdfSpotColorArr) {
        this.spotColors = pdfSpotColorArr;
    }

    @Override // com.itextpdf.text.pdf.ICachedColorSpace
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PdfDeviceNColor) && Arrays.equals(this.spotColors, ((PdfDeviceNColor) obj).spotColors);
    }

    @Override // com.itextpdf.text.pdf.IPdfSpecialColorSpace
    public ColorDetails[] getColorantDetails(PdfWriter pdfWriter) {
        if (this.colorantsDetails == null) {
            PdfSpotColor[] pdfSpotColorArr = this.spotColors;
            this.colorantsDetails = new ColorDetails[pdfSpotColorArr.length];
            int i = 0;
            for (PdfSpotColor pdfSpotColor : pdfSpotColorArr) {
                this.colorantsDetails[i] = pdfWriter.addSimple(pdfSpotColor);
                i++;
            }
        }
        return this.colorantsDetails;
    }

    public int getNumberOfColorants() {
        return this.spotColors.length;
    }

    @Override // com.itextpdf.text.pdf.ICachedColorSpace
    public PdfObject getPdfObject(PdfWriter pdfWriter) {
        float fMin;
        char c;
        float f;
        float f2;
        float f3;
        float f4 = 1.0f;
        float f5 = 0.0f;
        PdfArray pdfArray = new PdfArray(PdfName.DEVICEN);
        PdfArray pdfArray2 = new PdfArray();
        int i = 2;
        float[] fArr = new float[this.spotColors.length * 2];
        PdfDictionary pdfDictionary = new PdfDictionary();
        int length = this.spotColors.length;
        int i2 = 1;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 4, length);
        String str = "";
        String str2 = "";
        int i3 = 0;
        while (i3 < length) {
            PdfSpotColor pdfSpotColor = this.spotColors[i3];
            int i4 = i3 * 2;
            fArr[i4] = f5;
            fArr[i4 + 1] = f4;
            pdfArray2.add(pdfSpotColor.getName());
            if (pdfDictionary.get(pdfSpotColor.getName()) != null) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("devicen.component.names.shall.be.different", new Object[0]));
            }
            if (this.colorantsDetails != null) {
                pdfDictionary.put(pdfSpotColor.getName(), this.colorantsDetails[i3].getIndirectReference());
            } else {
                pdfDictionary.put(pdfSpotColor.getName(), pdfSpotColor.getPdfObject(pdfWriter));
            }
            BaseColor alternativeCS = pdfSpotColor.getAlternativeCS();
            if (alternativeCS instanceof ExtendedColor) {
                int i5 = ((ExtendedColor) alternativeCS).type;
                if (i5 == 1) {
                    fArr2[0][i3] = 0.0f;
                    fArr2[1][i3] = 0.0f;
                    fArr2[i][i3] = 0.0f;
                    fArr2[3][i3] = 1.0f - ((GrayColor) alternativeCS).getGray();
                } else if (i5 == i) {
                    CMYKColor cMYKColor = (CMYKColor) alternativeCS;
                    fArr2[0][i3] = cMYKColor.getCyan();
                    fArr2[1][i3] = cMYKColor.getMagenta();
                    fArr2[i][i3] = cMYKColor.getYellow();
                    fArr2[3][i3] = cMYKColor.getBlack();
                } else {
                    if (i5 != 7) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("only.rgb.gray.and.cmyk.are.supported.as.alternative.color.spaces", new Object[0]));
                    }
                    CMYKColor cmyk = ((LabColor) alternativeCS).toCmyk();
                    fArr2[0][i3] = cmyk.getCyan();
                    fArr2[1][i3] = cmyk.getMagenta();
                    fArr2[i][i3] = cmyk.getYellow();
                    fArr2[3][i3] = cmyk.getBlack();
                }
            } else {
                float red = alternativeCS.getRed();
                float green = alternativeCS.getGreen();
                float blue = alternativeCS.getBlue();
                if (red == 0.0f && green == 0.0f && blue == 0.0f) {
                    f2 = 0.0f;
                    f = 0.0f;
                    fMin = 1.0f;
                    f3 = 0.0f;
                    c = 0;
                } else {
                    float f6 = 1.0f - (red / 255.0f);
                    float f7 = 1.0f - (green / 255.0f);
                    float f8 = 1.0f - (blue / 255.0f);
                    fMin = Math.min(f6, Math.min(f7, f8));
                    float f9 = 1.0f - fMin;
                    float f10 = (f6 - fMin) / f9;
                    c = 0;
                    f = (f8 - fMin) / f9;
                    f2 = (f7 - fMin) / f9;
                    f3 = f10;
                }
                fArr2[c][i3] = f3;
                fArr2[1][i3] = f2;
                fArr2[2][i3] = f;
                fArr2[3][i3] = fMin;
            }
            str2 = str2 + "pop ";
            i3++;
            f4 = 1.0f;
            f5 = 0.0f;
            i = 2;
        }
        pdfArray.add(pdfArray2);
        String str3 = String.format(Locale.US, "1.000000 %d 1 roll ", Integer.valueOf(length + 1));
        pdfArray.add(PdfName.DEVICECMYK);
        String str4 = str3 + str3 + str3 + str3;
        int i6 = 4 + length;
        int i7 = i6;
        while (i7 > length) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            Locale locale = Locale.US;
            Object[] objArr = new Object[i2];
            objArr[0] = Integer.valueOf(i7);
            sb.append(String.format(locale, "%d -1 roll ", objArr));
            String string = sb.toString();
            for (int i8 = length; i8 > 0; i8--) {
                string = string + String.format(Locale.US, "%d index %f mul 1.000000 cvr exch sub mul ", Integer.valueOf(i8), Float.valueOf(fArr2[i6 - i7][length - i8]));
            }
            str = string + String.format(Locale.US, "1.000000 cvr exch sub %d 1 roll ", Integer.valueOf(i7));
            i7--;
            i2 = 1;
        }
        pdfArray.add(PdfFunction.type4(pdfWriter, fArr, new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, "{ " + str4 + str + str2 + "}").getReference());
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.put(PdfName.SUBTYPE, PdfName.NCHANNEL);
        pdfDictionary2.put(PdfName.COLORANTS, pdfDictionary);
        pdfArray.add(pdfDictionary2);
        return pdfArray;
    }

    public PdfSpotColor[] getSpotColors() {
        return this.spotColors;
    }

    @Override // com.itextpdf.text.pdf.ICachedColorSpace
    public int hashCode() {
        return Arrays.hashCode(this.spotColors);
    }
}
