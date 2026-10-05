package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;

/* JADX INFO: loaded from: classes3.dex */
public class PdfShading {
    protected boolean antiAlias = false;
    protected float[] bBox;
    protected ColorDetails colorDetails;
    private BaseColor cspace;
    protected PdfDictionary shading;
    protected PdfName shadingName;
    protected PdfIndirectReference shadingReference;
    protected int shadingType;
    protected PdfWriter writer;

    public PdfShading(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    public static void checkCompatibleColors(BaseColor baseColor, BaseColor baseColor2) {
        int type = ExtendedColor.getType(baseColor);
        if (type != ExtendedColor.getType(baseColor2)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("both.colors.must.be.of.the.same.type", new Object[0]));
        }
        if (type == 3 && ((SpotColor) baseColor).getPdfSpotColor() != ((SpotColor) baseColor2).getPdfSpotColor()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.spot.color.must.be.the.same.only.the.tint.can.vary", new Object[0]));
        }
        if (type == 4 || type == 5) {
            throwColorSpaceError();
        }
    }

    public static float[] getColorArray(BaseColor baseColor) {
        int type = ExtendedColor.getType(baseColor);
        if (type == 0) {
            return new float[]{baseColor.getRed() / 255.0f, baseColor.getGreen() / 255.0f, baseColor.getBlue() / 255.0f};
        }
        if (type == 1) {
            return new float[]{((GrayColor) baseColor).getGray()};
        }
        if (type == 2) {
            CMYKColor cMYKColor = (CMYKColor) baseColor;
            return new float[]{cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack()};
        }
        if (type == 3) {
            return new float[]{((SpotColor) baseColor).getTint()};
        }
        if (type == 6) {
            return ((DeviceNColor) baseColor).getTints();
        }
        throwColorSpaceError();
        return null;
    }

    public static PdfShading simpleAxial(PdfWriter pdfWriter, float f, float f2, float f3, float f4, BaseColor baseColor, BaseColor baseColor2, boolean z, boolean z2) {
        checkCompatibleColors(baseColor, baseColor2);
        return type2(pdfWriter, baseColor, new float[]{f, f2, f3, f4}, null, PdfFunction.type2(pdfWriter, new float[]{0.0f, 1.0f}, null, getColorArray(baseColor), getColorArray(baseColor2), 1.0f), new boolean[]{z, z2});
    }

    public static PdfShading simpleRadial(PdfWriter pdfWriter, float f, float f2, float f3, float f4, float f5, float f6, BaseColor baseColor, BaseColor baseColor2, boolean z, boolean z2) {
        checkCompatibleColors(baseColor, baseColor2);
        return type3(pdfWriter, baseColor, new float[]{f, f2, f3, f4, f5, f6}, null, PdfFunction.type2(pdfWriter, new float[]{0.0f, 1.0f}, null, getColorArray(baseColor), getColorArray(baseColor2), 1.0f), new boolean[]{z, z2});
    }

    public static void throwColorSpaceError() {
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.tiling.or.shading.pattern.cannot.be.used.as.a.color.space.in.a.shading.pattern", new Object[0]));
    }

    public static PdfShading type1(PdfWriter pdfWriter, BaseColor baseColor, float[] fArr, float[] fArr2, PdfFunction pdfFunction) {
        PdfShading pdfShading = new PdfShading(pdfWriter);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfShading.shading = pdfDictionary;
        pdfShading.shadingType = 1;
        pdfDictionary.put(PdfName.SHADINGTYPE, new PdfNumber(1));
        pdfShading.setColorSpace(baseColor);
        if (fArr != null) {
            pdfShading.shading.put(PdfName.DOMAIN, new PdfArray(fArr));
        }
        if (fArr2 != null) {
            pdfShading.shading.put(PdfName.MATRIX, new PdfArray(fArr2));
        }
        pdfShading.shading.put(PdfName.FUNCTION, pdfFunction.getReference());
        return pdfShading;
    }

    public static PdfShading type2(PdfWriter pdfWriter, BaseColor baseColor, float[] fArr, float[] fArr2, PdfFunction pdfFunction, boolean[] zArr) {
        boolean z;
        PdfShading pdfShading = new PdfShading(pdfWriter);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfShading.shading = pdfDictionary;
        pdfShading.shadingType = 2;
        pdfDictionary.put(PdfName.SHADINGTYPE, new PdfNumber(2));
        pdfShading.setColorSpace(baseColor);
        pdfShading.shading.put(PdfName.COORDS, new PdfArray(fArr));
        if (fArr2 != null) {
            pdfShading.shading.put(PdfName.DOMAIN, new PdfArray(fArr2));
        }
        pdfShading.shading.put(PdfName.FUNCTION, pdfFunction.getReference());
        if (zArr != null && ((z = zArr[0]) || zArr[1])) {
            PdfArray pdfArray = new PdfArray(z ? PdfBoolean.PDFTRUE : PdfBoolean.PDFFALSE);
            pdfArray.add(zArr[1] ? PdfBoolean.PDFTRUE : PdfBoolean.PDFFALSE);
            pdfShading.shading.put(PdfName.EXTEND, pdfArray);
        }
        return pdfShading;
    }

    public static PdfShading type3(PdfWriter pdfWriter, BaseColor baseColor, float[] fArr, float[] fArr2, PdfFunction pdfFunction, boolean[] zArr) {
        PdfShading pdfShadingType2 = type2(pdfWriter, baseColor, fArr, fArr2, pdfFunction, zArr);
        pdfShadingType2.shadingType = 3;
        pdfShadingType2.shading.put(PdfName.SHADINGTYPE, new PdfNumber(3));
        return pdfShadingType2;
    }

    public void addToBody() {
        float[] fArr = this.bBox;
        if (fArr != null) {
            this.shading.put(PdfName.BBOX, new PdfArray(fArr));
        }
        if (this.antiAlias) {
            this.shading.put(PdfName.ANTIALIAS, PdfBoolean.PDFTRUE);
        }
        this.writer.addToBody(this.shading, getShadingReference());
    }

    public float[] getBBox() {
        return this.bBox;
    }

    public ColorDetails getColorDetails() {
        return this.colorDetails;
    }

    public BaseColor getColorSpace() {
        return this.cspace;
    }

    public PdfName getShadingName() {
        return this.shadingName;
    }

    public PdfIndirectReference getShadingReference() {
        if (this.shadingReference == null) {
            this.shadingReference = this.writer.getPdfIndirectReference();
        }
        return this.shadingReference;
    }

    public PdfWriter getWriter() {
        return this.writer;
    }

    public boolean isAntiAlias() {
        return this.antiAlias;
    }

    public void setAntiAlias(boolean z) {
        this.antiAlias = z;
    }

    public void setBBox(float[] fArr) {
        if (fArr.length != 4) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bbox.must.be.a.4.element.array", new Object[0]));
        }
        this.bBox = fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setColorSpace(BaseColor baseColor) {
        PdfObject indirectReference;
        this.cspace = baseColor;
        switch (ExtendedColor.getType(baseColor)) {
            case 1:
                indirectReference = PdfName.DEVICEGRAY;
                break;
            case 2:
                indirectReference = PdfName.DEVICECMYK;
                break;
            case 3:
                ColorDetails colorDetailsAddSimple = this.writer.addSimple(((SpotColor) baseColor).getPdfSpotColor());
                this.colorDetails = colorDetailsAddSimple;
                indirectReference = colorDetailsAddSimple.getIndirectReference();
                break;
            case 4:
            case 5:
                throwColorSpaceError();
                indirectReference = PdfName.DEVICERGB;
                break;
            case 6:
                ColorDetails colorDetailsAddSimple2 = this.writer.addSimple(((DeviceNColor) baseColor).getPdfDeviceNColor());
                this.colorDetails = colorDetailsAddSimple2;
                indirectReference = colorDetailsAddSimple2.getIndirectReference();
                break;
            default:
                indirectReference = PdfName.DEVICERGB;
                break;
        }
        this.shading.put(PdfName.COLORSPACE, indirectReference);
    }

    public void setName(int i) {
        this.shadingName = new PdfName("Sh" + i);
    }

    public static PdfShading simpleAxial(PdfWriter pdfWriter, float f, float f2, float f3, float f4, BaseColor baseColor, BaseColor baseColor2) {
        return simpleAxial(pdfWriter, f, f2, f3, f4, baseColor, baseColor2, true, true);
    }

    public static PdfShading simpleRadial(PdfWriter pdfWriter, float f, float f2, float f3, float f4, float f5, float f6, BaseColor baseColor, BaseColor baseColor2) {
        return simpleRadial(pdfWriter, f, f2, f3, f4, f5, f6, baseColor, baseColor2, true, true);
    }
}
