package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import defpackage.AbstractC0738Mc;
import defpackage.AbstractC0955Uc;
import defpackage.AbstractC1888cd;
import defpackage.AbstractC4056ud;
import defpackage.AbstractC4137vd;
import defpackage.AbstractC4218wd;
import defpackage.AbstractC4299xd;
import defpackage.AbstractC4380yd;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.function.DoubleUnaryOperator;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE = new ColorSpaceVerificationHelper();

    private ColorSpaceVerificationHelper() {
    }

    @DoNotInline
    @RequiresApi(26)
    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace colorSpaceA;
        ColorSpace.Rgb.TransferParameters transferParametersA;
        ColorSpace.Rgb rgbA;
        AbstractC4492zt.h(colorSpace, "<this>");
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getSrgb())) {
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.SRGB);
            AbstractC4492zt.g(colorSpace2, "get(android.graphics.ColorSpace.Named.SRGB)");
            return colorSpace2;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getAces())) {
            ColorSpace colorSpace3 = ColorSpace.get(ColorSpace.Named.ACES);
            AbstractC4492zt.g(colorSpace3, "get(android.graphics.ColorSpace.Named.ACES)");
            return colorSpace3;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getAcescg())) {
            ColorSpace colorSpace4 = ColorSpace.get(ColorSpace.Named.ACESCG);
            AbstractC4492zt.g(colorSpace4, "get(android.graphics.ColorSpace.Named.ACESCG)");
            return colorSpace4;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getAdobeRgb())) {
            ColorSpace colorSpace5 = ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
            AbstractC4492zt.g(colorSpace5, "get(android.graphics.ColorSpace.Named.ADOBE_RGB)");
            return colorSpace5;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getBt2020())) {
            ColorSpace colorSpace6 = ColorSpace.get(ColorSpace.Named.BT2020);
            AbstractC4492zt.g(colorSpace6, "get(android.graphics.ColorSpace.Named.BT2020)");
            return colorSpace6;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getBt709())) {
            ColorSpace colorSpace7 = ColorSpace.get(ColorSpace.Named.BT709);
            AbstractC4492zt.g(colorSpace7, "get(android.graphics.ColorSpace.Named.BT709)");
            return colorSpace7;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getCieLab())) {
            ColorSpace colorSpace8 = ColorSpace.get(ColorSpace.Named.CIE_LAB);
            AbstractC4492zt.g(colorSpace8, "get(android.graphics.ColorSpace.Named.CIE_LAB)");
            return colorSpace8;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getCieXyz())) {
            ColorSpace colorSpace9 = ColorSpace.get(ColorSpace.Named.CIE_XYZ);
            AbstractC4492zt.g(colorSpace9, "get(android.graphics.ColorSpace.Named.CIE_XYZ)");
            return colorSpace9;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getDciP3())) {
            ColorSpace colorSpace10 = ColorSpace.get(ColorSpace.Named.DCI_P3);
            AbstractC4492zt.g(colorSpace10, "get(android.graphics.ColorSpace.Named.DCI_P3)");
            return colorSpace10;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getDisplayP3())) {
            ColorSpace colorSpace11 = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
            AbstractC4492zt.g(colorSpace11, "get(android.graphics.ColorSpace.Named.DISPLAY_P3)");
            return colorSpace11;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getExtendedSrgb())) {
            ColorSpace colorSpace12 = ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
            AbstractC4492zt.g(colorSpace12, "get(android.graphics.Col…pace.Named.EXTENDED_SRGB)");
            return colorSpace12;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getLinearExtendedSrgb())) {
            ColorSpace colorSpace13 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            AbstractC4492zt.g(colorSpace13, "get(android.graphics.Col…med.LINEAR_EXTENDED_SRGB)");
            return colorSpace13;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getLinearSrgb())) {
            ColorSpace colorSpace14 = ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
            AbstractC4492zt.g(colorSpace14, "get(android.graphics.ColorSpace.Named.LINEAR_SRGB)");
            return colorSpace14;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getNtsc1953())) {
            ColorSpace colorSpace15 = ColorSpace.get(ColorSpace.Named.NTSC_1953);
            AbstractC4492zt.g(colorSpace15, "get(android.graphics.ColorSpace.Named.NTSC_1953)");
            return colorSpace15;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getProPhotoRgb())) {
            ColorSpace colorSpace16 = ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
            AbstractC4492zt.g(colorSpace16, "get(android.graphics.Col…pace.Named.PRO_PHOTO_RGB)");
            return colorSpace16;
        }
        if (AbstractC4492zt.d(colorSpace, colorSpaces.getSmpteC())) {
            ColorSpace colorSpace17 = ColorSpace.get(ColorSpace.Named.SMPTE_C);
            AbstractC4492zt.g(colorSpace17, "get(android.graphics.ColorSpace.Named.SMPTE_C)");
            return colorSpace17;
        }
        if (colorSpace instanceof Rgb) {
            Rgb rgb = (Rgb) colorSpace;
            float[] xyz$ui_graphics_release = rgb.getWhitePoint().toXyz$ui_graphics_release();
            TransferParameters transferParameters = rgb.getTransferParameters();
            if (transferParameters != null) {
                AbstractC4299xd.a();
                transferParametersA = AbstractC4056ud.a(transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
            } else {
                transferParametersA = null;
            }
            if (transferParametersA != null) {
                AbstractC4380yd.a();
                rgbA = AbstractC4137vd.a(colorSpace.getName(), rgb.getPrimaries$ui_graphics_release(), xyz$ui_graphics_release, transferParametersA);
            } else {
                AbstractC4380yd.a();
                String name = colorSpace.getName();
                float[] primaries$ui_graphics_release = rgb.getPrimaries$ui_graphics_release();
                final InterfaceC3750qp oetf = rgb.getOetf();
                DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.a
                    @Override // java.util.function.DoubleUnaryOperator
                    public final double applyAsDouble(double d) {
                        return ColorSpaceVerificationHelper.androidColorSpace$lambda$0(oetf, d);
                    }
                };
                final InterfaceC3750qp eotf = rgb.getEotf();
                rgbA = AbstractC4218wd.a(name, primaries$ui_graphics_release, xyz$ui_graphics_release, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.b
                    @Override // java.util.function.DoubleUnaryOperator
                    public final double applyAsDouble(double d) {
                        return ColorSpaceVerificationHelper.androidColorSpace$lambda$1(eotf, d);
                    }
                }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0));
            }
            colorSpaceA = AbstractC0955Uc.a(rgbA);
        } else {
            colorSpaceA = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        AbstractC4492zt.g(colorSpaceA, "{\n                if (th…          }\n            }");
        return colorSpaceA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$0(InterfaceC3750qp interfaceC3750qp, double d) {
        AbstractC4492zt.h(interfaceC3750qp, "$tmp0");
        return ((Number) interfaceC3750qp.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$1(InterfaceC3750qp interfaceC3750qp, double d) {
        AbstractC4492zt.h(interfaceC3750qp, "$tmp0");
        return ((Number) interfaceC3750qp.invoke(Double.valueOf(d))).doubleValue();
    }

    @DoNotInline
    @RequiresApi(26)
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(final ColorSpace colorSpace) {
        AbstractC4492zt.h(colorSpace, "<this>");
        int id = colorSpace.getId();
        if (id == ColorSpace.Named.SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        if (id == ColorSpace.Named.ACES.ordinal()) {
            return ColorSpaces.INSTANCE.getAces();
        }
        if (id == ColorSpace.Named.ACESCG.ordinal()) {
            return ColorSpaces.INSTANCE.getAcescg();
        }
        if (id == ColorSpace.Named.ADOBE_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }
        if (id == ColorSpace.Named.BT2020.ordinal()) {
            return ColorSpaces.INSTANCE.getBt2020();
        }
        if (id == ColorSpace.Named.BT709.ordinal()) {
            return ColorSpaces.INSTANCE.getBt709();
        }
        if (id == ColorSpace.Named.CIE_LAB.ordinal()) {
            return ColorSpaces.INSTANCE.getCieLab();
        }
        if (id == ColorSpace.Named.CIE_XYZ.ordinal()) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }
        if (id == ColorSpace.Named.DCI_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDciP3();
        }
        if (id == ColorSpace.Named.DISPLAY_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }
        if (id == ColorSpace.Named.EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }
        if (id == ColorSpace.Named.NTSC_1953.ordinal()) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }
        if (id == ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }
        if (id == ColorSpace.Named.SMPTE_C.ordinal()) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }
        if (!AbstractC1888cd.a(colorSpace)) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        ColorSpace.Rgb.TransferParameters transferParameters = AbstractC0738Mc.a(colorSpace).getTransferParameters();
        WhitePoint whitePoint = AbstractC0738Mc.a(colorSpace).getWhitePoint().length == 3 ? new WhitePoint(AbstractC0738Mc.a(colorSpace).getWhitePoint()[0], AbstractC0738Mc.a(colorSpace).getWhitePoint()[1], AbstractC0738Mc.a(colorSpace).getWhitePoint()[2]) : new WhitePoint(AbstractC0738Mc.a(colorSpace).getWhitePoint()[0], AbstractC0738Mc.a(colorSpace).getWhitePoint()[1]);
        TransferParameters transferParameters2 = transferParameters != null ? new TransferParameters(transferParameters.g, transferParameters.a, transferParameters.b, transferParameters.c, transferParameters.d, transferParameters.e, transferParameters.f) : null;
        String name = AbstractC0738Mc.a(colorSpace).getName();
        AbstractC4492zt.g(name, "this.name");
        float[] primaries = AbstractC0738Mc.a(colorSpace).getPrimaries();
        AbstractC4492zt.g(primaries, "this.primaries");
        return new Rgb(name, primaries, whitePoint, AbstractC0738Mc.a(colorSpace).getTransform(), new DoubleFunction() { // from class: androidx.compose.ui.graphics.c
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d) {
                return ColorSpaceVerificationHelper.composeColorSpace$lambda$2(colorSpace, d);
            }
        }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.d
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d) {
                return ColorSpaceVerificationHelper.composeColorSpace$lambda$3(colorSpace, d);
            }
        }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0), transferParameters2, AbstractC0738Mc.a(colorSpace).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$2(ColorSpace colorSpace, double d) {
        AbstractC4492zt.h(colorSpace, "$this_composeColorSpace");
        return AbstractC0738Mc.a(colorSpace).getOetf().applyAsDouble(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$3(ColorSpace colorSpace, double d) {
        AbstractC4492zt.h(colorSpace, "$this_composeColorSpace");
        return AbstractC0738Mc.a(colorSpace).getEotf().applyAsDouble(d);
    }
}
