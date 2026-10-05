package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class Lab extends ColorSpace {
    private static final float A = 0.008856452f;
    private static final float B = 7.787037f;
    private static final float C = 0.13793103f;
    public static final Companion Companion = new Companion(null);
    private static final float D = 0.20689656f;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lab(String str, int i) {
        super(str, ColorModel.Companion.m3416getLabxdoWZVw(), i, null);
        AbstractC4492zt.h(str, "name");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] fArr) {
        AbstractC4492zt.h(fArr, "v");
        float f = fArr[0];
        Illuminant illuminant = Illuminant.INSTANCE;
        float f2 = f / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f3 = fArr[1] / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f4 = fArr[2] / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fPow = f2 > A ? (float) Math.pow(f2, 0.33333334f) : (f2 * B) + C;
        float fPow2 = f3 > A ? (float) Math.pow(f3, 0.33333334f) : (f3 * B) + C;
        float fPow3 = f4 > A ? (float) Math.pow(f4, 0.33333334f) : C + (f4 * B);
        fArr[0] = AbstractC3871sJ.k((116.0f * fPow2) - 16.0f, 0.0f, 100.0f);
        fArr[1] = AbstractC3871sJ.k((fPow - fPow2) * 500.0f, -128.0f, 128.0f);
        fArr[2] = AbstractC3871sJ.k((fPow2 - fPow3) * 200.0f, -128.0f, 128.0f);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i) {
        return i == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return i == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float fK = (AbstractC3871sJ.k(f, 0.0f, 100.0f) + 16.0f) / 116.0f;
        float fK2 = (AbstractC3871sJ.k(f, -128.0f, 128.0f) * 0.002f) + fK;
        float f4 = fK2 > D ? fK2 * fK2 * fK2 : (fK2 - C) * 0.12841855f;
        float f5 = fK > D ? fK * fK * fK : (fK - C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        return (((long) Float.floatToIntBits(f4 * illuminant.getD50Xyz$ui_graphics_release()[0])) << 32) | (((long) Float.floatToIntBits(f5 * illuminant.getD50Xyz$ui_graphics_release()[1])) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] fArr) {
        AbstractC4492zt.h(fArr, "v");
        fArr[0] = AbstractC3871sJ.k(fArr[0], 0.0f, 100.0f);
        fArr[1] = AbstractC3871sJ.k(fArr[1], -128.0f, 128.0f);
        float fK = AbstractC3871sJ.k(fArr[2], -128.0f, 128.0f);
        fArr[2] = fK;
        float f = (fArr[0] + 16.0f) / 116.0f;
        float f2 = (fArr[1] * 0.002f) + f;
        float f3 = f - (fK * 0.005f);
        float f4 = f2 > D ? f2 * f2 * f2 : (f2 - C) * 0.12841855f;
        float f5 = f > D ? f * f * f : (f - C) * 0.12841855f;
        float f6 = f3 > D ? f3 * f3 * f3 : (f3 - C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        fArr[0] = f4 * illuminant.getD50Xyz$ui_graphics_release()[0];
        fArr[1] = f5 * illuminant.getD50Xyz$ui_graphics_release()[1];
        fArr[2] = f6 * illuminant.getD50Xyz$ui_graphics_release()[2];
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        float fK = ((AbstractC3871sJ.k(f, 0.0f, 100.0f) + 16.0f) / 116.0f) - (AbstractC3871sJ.k(f3, -128.0f, 128.0f) * 0.005f);
        return (fK > D ? fK * fK * fK : 0.12841855f * (fK - C)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo3420xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        AbstractC4492zt.h(colorSpace, "colorSpace");
        Illuminant illuminant = Illuminant.INSTANCE;
        float f5 = f / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f6 = f2 / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f7 = f3 / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fPow = f5 > A ? (float) Math.pow(f5, 0.33333334f) : (f5 * B) + C;
        float fPow2 = f6 > A ? (float) Math.pow(f6, 0.33333334f) : (f6 * B) + C;
        return ColorKt.Color(AbstractC3871sJ.k((116.0f * fPow2) - 16.0f, 0.0f, 100.0f), AbstractC3871sJ.k((fPow - fPow2) * 500.0f, -128.0f, 128.0f), AbstractC3871sJ.k((fPow2 - (f7 > A ? (float) Math.pow(f7, 0.33333334f) : (f7 * B) + C)) * 200.0f, -128.0f, 128.0f), f4, colorSpace);
    }
}
