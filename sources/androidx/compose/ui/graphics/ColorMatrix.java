package androidx.compose.ui.graphics;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.Q5;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ColorMatrix {
    private final float[] values;

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m3087boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m3088constructorimpl(float[] fArr) {
        AbstractC4492zt.h(fArr, "values");
        return fArr;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m3089constructorimpl$default(float[] fArr, int i, AbstractC0419Di abstractC0419Di) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m3088constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m3090convertRgbToYuvimpl(float[] fArr) {
        m3097resetimpl(fArr);
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* JADX INFO: renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m3091convertYuvToRgbimpl(float[] fArr) {
        m3097resetimpl(fArr);
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* JADX INFO: renamed from: dot-Me4OoYI, reason: not valid java name */
    private static final float m3092dotMe4OoYI(float[] fArr, float[] fArr2, int i, float[] fArr3, int i2) {
        int i3 = i * 5;
        return (fArr2[i3] * fArr3[i2]) + (fArr2[i3 + 1] * fArr3[5 + i2]) + (fArr2[i3 + 2] * fArr3[10 + i2]) + (fArr2[i3 + 3] * fArr3[15 + i2]);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3093equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && AbstractC4492zt.d(fArr, ((ColorMatrix) obj).m3108unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3094equalsimpl0(float[] fArr, float[] fArr2) {
        return AbstractC4492zt.d(fArr, fArr2);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m3095getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 5) + i2];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3096hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m3097resetimpl(float[] fArr) {
        Q5.s(fArr, 0.0f, 0, 0, 6, null);
        fArr[0] = 1.0f;
        fArr[12] = 1.0f;
        fArr[6] = 1.0f;
        fArr[18] = 1.0f;
    }

    /* JADX INFO: renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m3098rotateInternalimpl(float[] fArr, float f, InterfaceC0526Fp interfaceC0526Fp) {
        m3097resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        interfaceC0526Fp.mo13invoke(Float.valueOf((float) Math.cos(d)), Float.valueOf((float) Math.sin(d)));
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m3099setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 5) + i2] = f;
    }

    /* JADX INFO: renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m3100setjHGOpc(float[] fArr, float[] fArr2) {
        AbstractC4492zt.h(fArr2, "src");
        Q5.k(fArr2, fArr, 0, 0, 0, 14, null);
    }

    /* JADX INFO: renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m3101setToRotateBlueimpl(float[] fArr, float f) {
        m3097resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[6] = fCos;
        fArr[0] = fCos;
        fArr[1] = fSin;
        fArr[5] = -fSin;
    }

    /* JADX INFO: renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m3102setToRotateGreenimpl(float[] fArr, float f) {
        m3097resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[12] = fCos;
        fArr[0] = fCos;
        fArr[2] = -fSin;
        fArr[10] = fSin;
    }

    /* JADX INFO: renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m3103setToRotateRedimpl(float[] fArr, float f) {
        m3097resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[12] = fCos;
        fArr[6] = fCos;
        fArr[7] = fSin;
        fArr[11] = -fSin;
    }

    /* JADX INFO: renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m3104setToSaturationimpl(float[] fArr, float f) {
        m3097resetimpl(fArr);
        float f2 = 1 - f;
        float f3 = 0.213f * f2;
        float f4 = 0.715f * f2;
        float f5 = f2 * 0.072f;
        fArr[0] = f3 + f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[5] = f3;
        fArr[6] = f4 + f;
        fArr[7] = f5;
        fArr[10] = f3;
        fArr[11] = f4;
        fArr[12] = f5 + f;
    }

    /* JADX INFO: renamed from: setToScale-impl, reason: not valid java name */
    public static final void m3105setToScaleimpl(float[] fArr, float f, float f2, float f3, float f4) {
        m3097resetimpl(fArr);
        fArr[0] = f;
        fArr[6] = f2;
        fArr[12] = f3;
        fArr[18] = f4;
    }

    /* JADX INFO: renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m3106timesAssignjHGOpc(float[] fArr, float[] fArr2) {
        AbstractC4492zt.h(fArr2, "colorMatrix");
        float fM3092dotMe4OoYI = m3092dotMe4OoYI(fArr, fArr, 0, fArr2, 0);
        float fM3092dotMe4OoYI2 = m3092dotMe4OoYI(fArr, fArr, 0, fArr2, 1);
        float fM3092dotMe4OoYI3 = m3092dotMe4OoYI(fArr, fArr, 0, fArr2, 2);
        float fM3092dotMe4OoYI4 = m3092dotMe4OoYI(fArr, fArr, 0, fArr2, 3);
        float f = (fArr[0] * fArr2[4]) + (fArr[1] * fArr2[9]) + (fArr[2] * fArr2[14]) + (fArr[3] * fArr2[19]) + fArr[4];
        float fM3092dotMe4OoYI5 = m3092dotMe4OoYI(fArr, fArr, 1, fArr2, 0);
        float fM3092dotMe4OoYI6 = m3092dotMe4OoYI(fArr, fArr, 1, fArr2, 1);
        float fM3092dotMe4OoYI7 = m3092dotMe4OoYI(fArr, fArr, 1, fArr2, 2);
        float fM3092dotMe4OoYI8 = m3092dotMe4OoYI(fArr, fArr, 1, fArr2, 3);
        float f2 = (fArr[5] * fArr2[4]) + (fArr[6] * fArr2[9]) + (fArr[7] * fArr2[14]) + (fArr[8] * fArr2[19]) + fArr[9];
        float fM3092dotMe4OoYI9 = m3092dotMe4OoYI(fArr, fArr, 2, fArr2, 0);
        float fM3092dotMe4OoYI10 = m3092dotMe4OoYI(fArr, fArr, 2, fArr2, 1);
        float fM3092dotMe4OoYI11 = m3092dotMe4OoYI(fArr, fArr, 2, fArr2, 2);
        float fM3092dotMe4OoYI12 = m3092dotMe4OoYI(fArr, fArr, 2, fArr2, 3);
        float f3 = (fArr[10] * fArr2[4]) + (fArr[11] * fArr2[9]) + (fArr[12] * fArr2[14]) + (fArr[13] * fArr2[19]) + fArr[14];
        float fM3092dotMe4OoYI13 = m3092dotMe4OoYI(fArr, fArr, 3, fArr2, 0);
        float fM3092dotMe4OoYI14 = m3092dotMe4OoYI(fArr, fArr, 3, fArr2, 1);
        float fM3092dotMe4OoYI15 = m3092dotMe4OoYI(fArr, fArr, 3, fArr2, 2);
        float fM3092dotMe4OoYI16 = m3092dotMe4OoYI(fArr, fArr, 3, fArr2, 3);
        float f4 = (fArr[15] * fArr2[4]) + (fArr[16] * fArr2[9]) + (fArr[17] * fArr2[14]) + (fArr[18] * fArr2[19]) + fArr[19];
        fArr[0] = fM3092dotMe4OoYI;
        fArr[1] = fM3092dotMe4OoYI2;
        fArr[2] = fM3092dotMe4OoYI3;
        fArr[3] = fM3092dotMe4OoYI4;
        fArr[4] = f;
        fArr[5] = fM3092dotMe4OoYI5;
        fArr[6] = fM3092dotMe4OoYI6;
        fArr[7] = fM3092dotMe4OoYI7;
        fArr[8] = fM3092dotMe4OoYI8;
        fArr[9] = f2;
        fArr[10] = fM3092dotMe4OoYI9;
        fArr[11] = fM3092dotMe4OoYI10;
        fArr[12] = fM3092dotMe4OoYI11;
        fArr[13] = fM3092dotMe4OoYI12;
        fArr[14] = f3;
        fArr[15] = fM3092dotMe4OoYI13;
        fArr[16] = fM3092dotMe4OoYI14;
        fArr[17] = fM3092dotMe4OoYI15;
        fArr[18] = fM3092dotMe4OoYI16;
        fArr[19] = f4;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3107toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object obj) {
        return m3093equalsimpl(this.values, obj);
    }

    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m3096hashCodeimpl(this.values);
    }

    public String toString() {
        return m3107toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m3108unboximpl() {
        return this.values;
    }
}
