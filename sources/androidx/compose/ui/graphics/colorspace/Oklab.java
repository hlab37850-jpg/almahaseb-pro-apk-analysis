package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class Oklab extends ColorSpace {
    public static final Companion Companion = new Companion(null);
    private static final float[] InverseM1;
    private static final float[] InverseM2;
    private static final float[] M1;
    private static final float[] M2;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    static {
        float[] transform$ui_graphics_release = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
        Illuminant illuminant = Illuminant.INSTANCE;
        float[] fArrMul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release, illuminant.getD50().toXyz$ui_graphics_release(), illuminant.getD65().toXyz$ui_graphics_release()));
        M1 = fArrMul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(fArrMul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oklab(String str, int i) {
        super(str, ColorModel.Companion.m3416getLabxdoWZVw(), i, null);
        AbstractC4492zt.h(str, "name");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] fArr) {
        AbstractC4492zt.h(fArr, "v");
        ColorSpaceKt.mul3x3Float3(M1, fArr);
        double d = 0.33333334f;
        fArr[0] = Math.signum(fArr[0]) * ((float) Math.pow(Math.abs(fArr[0]), d));
        fArr[1] = Math.signum(fArr[1]) * ((float) Math.pow(Math.abs(fArr[1]), d));
        fArr[2] = Math.signum(fArr[2]) * ((float) Math.pow(Math.abs(fArr[2]), d));
        ColorSpaceKt.mul3x3Float3(M2, fArr);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i) {
        return i == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return i == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float fK = AbstractC3871sJ.k(f, 0.0f, 1.0f);
        float fK2 = AbstractC3871sJ.k(f2, -0.5f, 0.5f);
        float fK3 = AbstractC3871sJ.k(f3, -0.5f, 0.5f);
        float[] fArr = InverseM2;
        float fMul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, fK, fK2, fK3);
        float fMul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, fK, fK2, fK3);
        float fMul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, fK, fK2, fK3);
        float f4 = fMul3x3Float3_0 * fMul3x3Float3_0 * fMul3x3Float3_0;
        float f5 = fMul3x3Float3_1 * fMul3x3Float3_1 * fMul3x3Float3_1;
        float f6 = fMul3x3Float3_2 * fMul3x3Float3_2 * fMul3x3Float3_2;
        float[] fArr2 = InverseM1;
        float fMul3x3Float3_3 = ColorSpaceKt.mul3x3Float3_0(fArr2, f4, f5, f6);
        float fMul3x3Float3_4 = ColorSpaceKt.mul3x3Float3_1(fArr2, f4, f5, f6);
        return (((long) Float.floatToIntBits(fMul3x3Float3_3)) << 32) | (((long) Float.floatToIntBits(fMul3x3Float3_4)) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] fArr) {
        AbstractC4492zt.h(fArr, "v");
        fArr[0] = AbstractC3871sJ.k(fArr[0], 0.0f, 1.0f);
        fArr[1] = AbstractC3871sJ.k(fArr[1], -0.5f, 0.5f);
        fArr[2] = AbstractC3871sJ.k(fArr[2], -0.5f, 0.5f);
        ColorSpaceKt.mul3x3Float3(InverseM2, fArr);
        float f = fArr[0];
        fArr[0] = f * f * f;
        float f2 = fArr[1];
        fArr[1] = f2 * f2 * f2;
        float f3 = fArr[2];
        fArr[2] = f3 * f3 * f3;
        ColorSpaceKt.mul3x3Float3(InverseM1, fArr);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        float fK = AbstractC3871sJ.k(f, 0.0f, 1.0f);
        float fK2 = AbstractC3871sJ.k(f2, -0.5f, 0.5f);
        float fK3 = AbstractC3871sJ.k(f3, -0.5f, 0.5f);
        float[] fArr = InverseM2;
        float fMul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, fK, fK2, fK3);
        float fMul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, fK, fK2, fK3);
        float fMul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, fK, fK2, fK3);
        float f4 = fMul3x3Float3_2 * fMul3x3Float3_2 * fMul3x3Float3_2;
        return ColorSpaceKt.mul3x3Float3_2(InverseM1, fMul3x3Float3_0 * fMul3x3Float3_0 * fMul3x3Float3_0, fMul3x3Float3_1 * fMul3x3Float3_1 * fMul3x3Float3_1, f4);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo3420xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        AbstractC4492zt.h(colorSpace, "colorSpace");
        float[] fArr = M1;
        float fMul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, f, f2, f3);
        float fMul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, f, f2, f3);
        float fMul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, f, f2, f3);
        double d = 0.33333334f;
        float fSignum = Math.signum(fMul3x3Float3_0) * ((float) Math.pow(Math.abs(fMul3x3Float3_0), d));
        float fSignum2 = Math.signum(fMul3x3Float3_1) * ((float) Math.pow(Math.abs(fMul3x3Float3_1), d));
        float fSignum3 = Math.signum(fMul3x3Float3_2) * ((float) Math.pow(Math.abs(fMul3x3Float3_2), d));
        float[] fArr2 = M2;
        return ColorKt.Color(ColorSpaceKt.mul3x3Float3_0(fArr2, fSignum, fSignum2, fSignum3), ColorSpaceKt.mul3x3Float3_1(fArr2, fSignum, fSignum2, fSignum3), ColorSpaceKt.mul3x3Float3_2(fArr2, fSignum, fSignum2, fSignum3), f4, colorSpace);
    }
}
