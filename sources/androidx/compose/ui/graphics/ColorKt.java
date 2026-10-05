package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.C3150jW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ColorKt {
    @Stable
    public static final long Color(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        AbstractC4492zt.h(colorSpace, "colorSpace");
        float minValue = colorSpace.getMinValue(0);
        if (f <= colorSpace.getMaxValue(0) && minValue <= f) {
            float minValue2 = colorSpace.getMinValue(1);
            if (f2 <= colorSpace.getMaxValue(1) && minValue2 <= f2) {
                float minValue3 = colorSpace.getMinValue(2);
                if (f3 <= colorSpace.getMaxValue(2) && minValue3 <= f3 && 0.0f <= f4 && f4 <= 1.0f) {
                    if (colorSpace.isSrgb()) {
                        return Color.m3028constructorimpl(C3150jW.b(C3150jW.b(C3150jW.b((((((int) ((f * 255.0f) + 0.5f)) << 16) | (((int) ((f4 * 255.0f) + 0.5f)) << 24)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((f3 * 255.0f) + 0.5f))) & 4294967295L) << 32));
                    }
                    if (colorSpace.getComponentCount() != 3) {
                        throw new IllegalArgumentException("Color only works with ColorSpaces with 3 components");
                    }
                    int id$ui_graphics_release = colorSpace.getId$ui_graphics_release();
                    if (id$ui_graphics_release == -1) {
                        throw new IllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
                    }
                    short sM3135constructorimpl = Float16.m3135constructorimpl(f);
                    return Color.m3028constructorimpl(C3150jW.b(C3150jW.b(C3150jW.b(C3150jW.b(C3150jW.b(C3150jW.b(C3150jW.b(Float16.m3135constructorimpl(f2)) & 65535) << 32) | C3150jW.b(C3150jW.b(C3150jW.b(sM3135constructorimpl) & 65535) << 48)) | C3150jW.b(C3150jW.b(C3150jW.b(Float16.m3135constructorimpl(f3)) & 65535) << 16)) | C3150jW.b(C3150jW.b(C3150jW.b((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f)) & 1023) << 6)) | C3150jW.b(C3150jW.b(id$ui_graphics_release) & 63)));
                }
            }
        }
        throw new IllegalArgumentException(("red = " + f + ", green = " + f2 + ", blue = " + f3 + ", alpha = " + f4 + " outside the range for " + colorSpace).toString());
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    @Stable
    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m3077compositeOverOWjLjI(long j, long j2) {
        long jM3029convertvNxB06k = Color.m3029convertvNxB06k(j, Color.m3036getColorSpaceimpl(j2));
        float fM3034getAlphaimpl = Color.m3034getAlphaimpl(j2);
        float fM3034getAlphaimpl2 = Color.m3034getAlphaimpl(jM3029convertvNxB06k);
        float f = 1.0f - fM3034getAlphaimpl2;
        float f2 = (fM3034getAlphaimpl * f) + fM3034getAlphaimpl2;
        return Color(f2 == 0.0f ? 0.0f : ((Color.m3038getRedimpl(jM3029convertvNxB06k) * fM3034getAlphaimpl2) + ((Color.m3038getRedimpl(j2) * fM3034getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m3037getGreenimpl(jM3029convertvNxB06k) * fM3034getAlphaimpl2) + ((Color.m3037getGreenimpl(j2) * fM3034getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m3035getBlueimpl(jM3029convertvNxB06k) * fM3034getAlphaimpl2) + ((Color.m3035getBlueimpl(j2) * fM3034getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m3036getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m3078getComponents8_81llA(long j) {
        return new float[]{Color.m3038getRedimpl(j), Color.m3037getGreenimpl(j), Color.m3035getBlueimpl(j), Color.m3034getAlphaimpl(j)};
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m3079isSpecified8_81llA(long j) {
        return j != Color.Companion.m3068getUnspecified0d7_KjU();
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m3080isSpecified8_81llA$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m3081isUnspecified8_81llA(long j) {
        return j == Color.Companion.m3068getUnspecified0d7_KjU();
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m3082isUnspecified8_81llA$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m3083lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM3029convertvNxB06k = Color.m3029convertvNxB06k(j, oklab);
        long jM3029convertvNxB06k2 = Color.m3029convertvNxB06k(j2, oklab);
        float fM3034getAlphaimpl = Color.m3034getAlphaimpl(jM3029convertvNxB06k);
        float fM3038getRedimpl = Color.m3038getRedimpl(jM3029convertvNxB06k);
        float fM3037getGreenimpl = Color.m3037getGreenimpl(jM3029convertvNxB06k);
        float fM3035getBlueimpl = Color.m3035getBlueimpl(jM3029convertvNxB06k);
        float fM3034getAlphaimpl2 = Color.m3034getAlphaimpl(jM3029convertvNxB06k2);
        float fM3038getRedimpl2 = Color.m3038getRedimpl(jM3029convertvNxB06k2);
        float fM3037getGreenimpl2 = Color.m3037getGreenimpl(jM3029convertvNxB06k2);
        float fM3035getBlueimpl2 = Color.m3035getBlueimpl(jM3029convertvNxB06k2);
        return Color.m3029convertvNxB06k(Color(MathHelpersKt.lerp(fM3038getRedimpl, fM3038getRedimpl2, f), MathHelpersKt.lerp(fM3037getGreenimpl, fM3037getGreenimpl2, f), MathHelpersKt.lerp(fM3035getBlueimpl, fM3035getBlueimpl2, f), MathHelpersKt.lerp(fM3034getAlphaimpl, fM3034getAlphaimpl2, f), oklab), Color.m3036getColorSpaceimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m3084luminance8_81llA(long j) {
        ColorSpace colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(j);
        if (!ColorModel.m3410equalsimpl0(colorSpaceM3036getColorSpaceimpl.m3419getModelxdoWZVw(), ColorModel.Companion.m3417getRgbxdoWZVw())) {
            throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m3413toStringimpl(colorSpaceM3036getColorSpaceimpl.m3419getModelxdoWZVw()))).toString());
        }
        AbstractC4492zt.f(colorSpaceM3036getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) colorSpaceM3036getColorSpaceimpl).getEotfFunc$ui_graphics_release();
        return saturate((float) ((eotfFunc$ui_graphics_release.invoke(Color.m3038getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m3037getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m3035getBlueimpl(j)) * 0.0722d)));
    }

    private static final float saturate(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m3085takeOrElseDxMtmZc(long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        return j != Color.Companion.m3068getUnspecified0d7_KjU() ? j : ((Color) interfaceC3588op.invoke()).m3042unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m3086toArgb8_81llA(long j) {
        return (int) C3150jW.b(Color.m3029convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    @Stable
    public static final long Color(int i) {
        return Color.m3028constructorimpl(C3150jW.b(C3150jW.b(i) << 32));
    }

    @Stable
    public static final long Color(long j) {
        return Color.m3028constructorimpl(C3150jW.b(C3150jW.b(C3150jW.b(j) & 4294967295L) << 32));
    }

    @Stable
    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }
}
