package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3310lS;
import defpackage.AbstractC4492zt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Matrix {
    public static final Companion Companion = new Companion(null);
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Matrix m3235boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m3236constructorimpl(float[] fArr) {
        AbstractC4492zt.h(fArr, "values");
        return fArr;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m3237constructorimpl$default(float[] fArr, int i, AbstractC0419Di abstractC0419Di) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m3236constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3238equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && AbstractC4492zt.d(fArr, ((Matrix) obj).m3258unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3239equalsimpl0(float[] fArr, float[] fArr2) {
        return AbstractC4492zt.d(fArr, fArr2);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m3240getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 4) + i2];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3241hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* JADX INFO: renamed from: invert-impl, reason: not valid java name */
    public static final void m3242invertimpl(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        float f10 = fArr[9];
        float f11 = fArr[10];
        float f12 = fArr[11];
        float f13 = fArr[12];
        float f14 = fArr[13];
        float f15 = fArr[14];
        float f16 = fArr[15];
        float f17 = (f * f6) - (f2 * f5);
        float f18 = (f * f7) - (f3 * f5);
        float f19 = (f * f8) - (f4 * f5);
        float f20 = (f2 * f7) - (f3 * f6);
        float f21 = (f2 * f8) - (f4 * f6);
        float f22 = (f3 * f8) - (f4 * f7);
        float f23 = (f9 * f14) - (f10 * f13);
        float f24 = (f9 * f15) - (f11 * f13);
        float f25 = (f9 * f16) - (f12 * f13);
        float f26 = (f10 * f15) - (f11 * f14);
        float f27 = (f10 * f16) - (f12 * f14);
        float f28 = (f11 * f16) - (f12 * f15);
        float f29 = (((((f17 * f28) - (f18 * f27)) + (f19 * f26)) + (f20 * f25)) - (f21 * f24)) + (f22 * f23);
        if (f29 == 0.0f) {
            return;
        }
        float f30 = 1.0f / f29;
        fArr[0] = (((f6 * f28) - (f7 * f27)) + (f8 * f26)) * f30;
        fArr[1] = ((((-f2) * f28) + (f3 * f27)) - (f4 * f26)) * f30;
        fArr[2] = (((f14 * f22) - (f15 * f21)) + (f16 * f20)) * f30;
        fArr[3] = ((((-f10) * f22) + (f11 * f21)) - (f12 * f20)) * f30;
        float f31 = -f5;
        fArr[4] = (((f31 * f28) + (f7 * f25)) - (f8 * f24)) * f30;
        fArr[5] = (((f28 * f) - (f3 * f25)) + (f4 * f24)) * f30;
        float f32 = -f13;
        fArr[6] = (((f32 * f22) + (f15 * f19)) - (f16 * f18)) * f30;
        fArr[7] = (((f22 * f9) - (f11 * f19)) + (f12 * f18)) * f30;
        fArr[8] = (((f5 * f27) - (f6 * f25)) + (f8 * f23)) * f30;
        fArr[9] = ((((-f) * f27) + (f25 * f2)) - (f4 * f23)) * f30;
        fArr[10] = (((f13 * f21) - (f14 * f19)) + (f16 * f17)) * f30;
        fArr[11] = ((((-f9) * f21) + (f19 * f10)) - (f12 * f17)) * f30;
        fArr[12] = (((f31 * f26) + (f6 * f24)) - (f7 * f23)) * f30;
        fArr[13] = (((f * f26) - (f2 * f24)) + (f3 * f23)) * f30;
        fArr[14] = (((f32 * f20) + (f14 * f18)) - (f15 * f17)) * f30;
        fArr[15] = (((f9 * f20) - (f10 * f18)) + (f11 * f17)) * f30;
    }

    /* JADX INFO: renamed from: map-MK-Hz9U, reason: not valid java name */
    public static final long m3243mapMKHz9U(float[] fArr, long j) {
        float fM2798getXimpl = Offset.m2798getXimpl(j);
        float fM2799getYimpl = Offset.m2799getYimpl(j);
        float f = 1 / (((fArr[3] * fM2798getXimpl) + (fArr[7] * fM2799getYimpl)) + fArr[15]);
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            f = 0.0f;
        }
        return OffsetKt.Offset(((fArr[0] * fM2798getXimpl) + (fArr[4] * fM2799getYimpl) + fArr[12]) * f, f * ((fArr[1] * fM2798getXimpl) + (fArr[5] * fM2799getYimpl) + fArr[13]));
    }

    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final Rect m3244mapimpl(float[] fArr, Rect rect) {
        AbstractC4492zt.h(rect, "rect");
        long jM3243mapMKHz9U = m3243mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long jM3243mapMKHz9U2 = m3243mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long jM3243mapMKHz9U3 = m3243mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long jM3243mapMKHz9U4 = m3243mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        return new Rect(Math.min(Math.min(Offset.m2798getXimpl(jM3243mapMKHz9U), Offset.m2798getXimpl(jM3243mapMKHz9U2)), Math.min(Offset.m2798getXimpl(jM3243mapMKHz9U3), Offset.m2798getXimpl(jM3243mapMKHz9U4))), Math.min(Math.min(Offset.m2799getYimpl(jM3243mapMKHz9U), Offset.m2799getYimpl(jM3243mapMKHz9U2)), Math.min(Offset.m2799getYimpl(jM3243mapMKHz9U3), Offset.m2799getYimpl(jM3243mapMKHz9U4))), Math.max(Math.max(Offset.m2798getXimpl(jM3243mapMKHz9U), Offset.m2798getXimpl(jM3243mapMKHz9U2)), Math.max(Offset.m2798getXimpl(jM3243mapMKHz9U3), Offset.m2798getXimpl(jM3243mapMKHz9U4))), Math.max(Math.max(Offset.m2799getYimpl(jM3243mapMKHz9U), Offset.m2799getYimpl(jM3243mapMKHz9U2)), Math.max(Offset.m2799getYimpl(jM3243mapMKHz9U3), Offset.m2799getYimpl(jM3243mapMKHz9U4))));
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m3246resetimpl(float[] fArr) {
        int i = 0;
        while (i < 4) {
            int i2 = 0;
            while (i2 < 4) {
                fArr[(i2 * 4) + i] = i == i2 ? 1.0f : 0.0f;
                i2++;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: rotateX-impl, reason: not valid java name */
    public static final void m3247rotateXimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[5];
        float f5 = fArr[6];
        float f6 = fArr[9];
        float f7 = fArr[10];
        float f8 = fArr[13];
        float f9 = fArr[14];
        fArr[1] = (f2 * fCos) - (f3 * fSin);
        fArr[2] = (f2 * fSin) + (f3 * fCos);
        fArr[5] = (f4 * fCos) - (f5 * fSin);
        fArr[6] = (f4 * fSin) + (f5 * fCos);
        fArr[9] = (f6 * fCos) - (f7 * fSin);
        fArr[10] = (f6 * fSin) + (f7 * fCos);
        fArr[13] = (f8 * fCos) - (f9 * fSin);
        fArr[14] = (f8 * fSin) + (f9 * fCos);
    }

    /* JADX INFO: renamed from: rotateY-impl, reason: not valid java name */
    public static final void m3248rotateYimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f2 = fArr[0];
        float f3 = fArr[2];
        float f4 = fArr[4];
        float f5 = fArr[6];
        float f6 = fArr[8];
        float f7 = fArr[10];
        float f8 = fArr[12];
        float f9 = fArr[14];
        fArr[0] = (f2 * fCos) + (f3 * fSin);
        fArr[2] = ((-f2) * fSin) + (f3 * fCos);
        fArr[4] = (f4 * fCos) + (f5 * fSin);
        fArr[6] = ((-f4) * fSin) + (f5 * fCos);
        fArr[8] = (f6 * fCos) + (f7 * fSin);
        fArr[10] = ((-f6) * fSin) + (f7 * fCos);
        fArr[12] = (f8 * fCos) + (f9 * fSin);
        fArr[14] = ((-f8) * fSin) + (f9 * fCos);
    }

    /* JADX INFO: renamed from: rotateZ-impl, reason: not valid java name */
    public static final void m3249rotateZimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f2 = fArr[0];
        float f3 = fArr[4];
        float f4 = (fCos * f2) + (fSin * f3);
        float f5 = -fSin;
        float f6 = fArr[1];
        float f7 = fArr[5];
        float f8 = (fCos * f6) + (fSin * f7);
        float f9 = fArr[2];
        float f10 = fArr[6];
        float f11 = (fCos * f9) + (fSin * f10);
        float f12 = fArr[3];
        float f13 = fArr[7];
        fArr[0] = f4;
        fArr[1] = f8;
        fArr[2] = f11;
        fArr[3] = (fCos * f12) + (fSin * f13);
        fArr[4] = (f2 * f5) + (f3 * fCos);
        fArr[5] = (f6 * f5) + (f7 * fCos);
        fArr[6] = (f9 * f5) + (f10 * fCos);
        fArr[7] = (f5 * f12) + (fCos * f13);
    }

    /* JADX INFO: renamed from: scale-impl, reason: not valid java name */
    public static final void m3250scaleimpl(float[] fArr, float f, float f2, float f3) {
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
        fArr[3] = fArr[3] * f;
        fArr[4] = fArr[4] * f2;
        fArr[5] = fArr[5] * f2;
        fArr[6] = fArr[6] * f2;
        fArr[7] = fArr[7] * f2;
        fArr[8] = fArr[8] * f3;
        fArr[9] = fArr[9] * f3;
        fArr[10] = fArr[10] * f3;
        fArr[11] = fArr[11] * f3;
    }

    /* JADX INFO: renamed from: scale-impl$default, reason: not valid java name */
    public static /* synthetic */ void m3251scaleimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        m3250scaleimpl(fArr, f, f2, f3);
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m3252setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 4) + i2] = f;
    }

    /* JADX INFO: renamed from: setFrom-58bKbWc, reason: not valid java name */
    public static final void m3253setFrom58bKbWc(float[] fArr, float[] fArr2) {
        AbstractC4492zt.h(fArr2, "matrix");
        for (int i = 0; i < 16; i++) {
            fArr[i] = fArr2[i];
        }
    }

    /* JADX INFO: renamed from: timesAssign-58bKbWc, reason: not valid java name */
    public static final void m3254timesAssign58bKbWc(float[] fArr, float[] fArr2) {
        AbstractC4492zt.h(fArr2, "m");
        float fM3260dotp89u6pk = MatrixKt.m3260dotp89u6pk(fArr, 0, fArr2, 0);
        float fM3260dotp89u6pk2 = MatrixKt.m3260dotp89u6pk(fArr, 0, fArr2, 1);
        float fM3260dotp89u6pk3 = MatrixKt.m3260dotp89u6pk(fArr, 0, fArr2, 2);
        float fM3260dotp89u6pk4 = MatrixKt.m3260dotp89u6pk(fArr, 0, fArr2, 3);
        float fM3260dotp89u6pk5 = MatrixKt.m3260dotp89u6pk(fArr, 1, fArr2, 0);
        float fM3260dotp89u6pk6 = MatrixKt.m3260dotp89u6pk(fArr, 1, fArr2, 1);
        float fM3260dotp89u6pk7 = MatrixKt.m3260dotp89u6pk(fArr, 1, fArr2, 2);
        float fM3260dotp89u6pk8 = MatrixKt.m3260dotp89u6pk(fArr, 1, fArr2, 3);
        float fM3260dotp89u6pk9 = MatrixKt.m3260dotp89u6pk(fArr, 2, fArr2, 0);
        float fM3260dotp89u6pk10 = MatrixKt.m3260dotp89u6pk(fArr, 2, fArr2, 1);
        float fM3260dotp89u6pk11 = MatrixKt.m3260dotp89u6pk(fArr, 2, fArr2, 2);
        float fM3260dotp89u6pk12 = MatrixKt.m3260dotp89u6pk(fArr, 2, fArr2, 3);
        float fM3260dotp89u6pk13 = MatrixKt.m3260dotp89u6pk(fArr, 3, fArr2, 0);
        float fM3260dotp89u6pk14 = MatrixKt.m3260dotp89u6pk(fArr, 3, fArr2, 1);
        float fM3260dotp89u6pk15 = MatrixKt.m3260dotp89u6pk(fArr, 3, fArr2, 2);
        float fM3260dotp89u6pk16 = MatrixKt.m3260dotp89u6pk(fArr, 3, fArr2, 3);
        fArr[0] = fM3260dotp89u6pk;
        fArr[1] = fM3260dotp89u6pk2;
        fArr[2] = fM3260dotp89u6pk3;
        fArr[3] = fM3260dotp89u6pk4;
        fArr[4] = fM3260dotp89u6pk5;
        fArr[5] = fM3260dotp89u6pk6;
        fArr[6] = fM3260dotp89u6pk7;
        fArr[7] = fM3260dotp89u6pk8;
        fArr[8] = fM3260dotp89u6pk9;
        fArr[9] = fM3260dotp89u6pk10;
        fArr[10] = fM3260dotp89u6pk11;
        fArr[11] = fM3260dotp89u6pk12;
        fArr[12] = fM3260dotp89u6pk13;
        fArr[13] = fM3260dotp89u6pk14;
        fArr[14] = fM3260dotp89u6pk15;
        fArr[15] = fM3260dotp89u6pk16;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3255toStringimpl(float[] fArr) {
        return AbstractC3310lS.f("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    /* JADX INFO: renamed from: translate-impl, reason: not valid java name */
    public static final void m3256translateimpl(float[] fArr, float f, float f2, float f3) {
        float f4 = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
        float f5 = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
        float f6 = (fArr[2] * f) + (fArr[6] * f2) + (fArr[10] * f3) + fArr[14];
        float f7 = (fArr[3] * f) + (fArr[7] * f2) + (fArr[11] * f3) + fArr[15];
        fArr[12] = f4;
        fArr[13] = f5;
        fArr[14] = f6;
        fArr[15] = f7;
    }

    /* JADX INFO: renamed from: translate-impl$default, reason: not valid java name */
    public static /* synthetic */ void m3257translateimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        m3256translateimpl(fArr, f, f2, f3);
    }

    public boolean equals(Object obj) {
        return m3238equalsimpl(this.values, obj);
    }

    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m3241hashCodeimpl(this.values);
    }

    public String toString() {
        return m3255toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m3258unboximpl() {
        return this.values;
    }

    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final void m3245mapimpl(float[] fArr, MutableRect mutableRect) {
        AbstractC4492zt.h(mutableRect, "rect");
        long jM3243mapMKHz9U = m3243mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getTop()));
        long jM3243mapMKHz9U2 = m3243mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getBottom()));
        long jM3243mapMKHz9U3 = m3243mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getTop()));
        long jM3243mapMKHz9U4 = m3243mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getBottom()));
        mutableRect.setLeft(Math.min(Math.min(Offset.m2798getXimpl(jM3243mapMKHz9U), Offset.m2798getXimpl(jM3243mapMKHz9U2)), Math.min(Offset.m2798getXimpl(jM3243mapMKHz9U3), Offset.m2798getXimpl(jM3243mapMKHz9U4))));
        mutableRect.setTop(Math.min(Math.min(Offset.m2799getYimpl(jM3243mapMKHz9U), Offset.m2799getYimpl(jM3243mapMKHz9U2)), Math.min(Offset.m2799getYimpl(jM3243mapMKHz9U3), Offset.m2799getYimpl(jM3243mapMKHz9U4))));
        mutableRect.setRight(Math.max(Math.max(Offset.m2798getXimpl(jM3243mapMKHz9U), Offset.m2798getXimpl(jM3243mapMKHz9U2)), Math.max(Offset.m2798getXimpl(jM3243mapMKHz9U3), Offset.m2798getXimpl(jM3243mapMKHz9U4))));
        mutableRect.setBottom(Math.max(Math.max(Offset.m2799getYimpl(jM3243mapMKHz9U), Offset.m2799getYimpl(jM3243mapMKHz9U2)), Math.max(Offset.m2799getYimpl(jM3243mapMKHz9U3), Offset.m2799getYimpl(jM3243mapMKHz9U4))));
    }
}
