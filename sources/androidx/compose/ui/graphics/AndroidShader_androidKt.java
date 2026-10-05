package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidShader_androidKt {
    /* JADX INFO: renamed from: ActualImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m2940ActualImageShaderF49vj9s(ImageBitmap imageBitmap, int i, int i2) {
        AbstractC4492zt.h(imageBitmap, "image");
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), AndroidTileMode_androidKt.m2945toAndroidTileMode0vamqd0(i), AndroidTileMode_androidKt.m2945toAndroidTileMode0vamqd0(i2));
    }

    /* JADX INFO: renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m2941ActualLinearGradientShaderVjE6UOU(long j, long j2, List<Color> list, List<Float> list2, int i) {
        AbstractC4492zt.h(list, "colors");
        validateColorStops(list, list2);
        int iCountTransparentColors = countTransparentColors(list);
        return new android.graphics.LinearGradient(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2), makeTransparentColors(list, iCountTransparentColors), makeTransparentStops(list2, list, iCountTransparentColors), AndroidTileMode_androidKt.m2945toAndroidTileMode0vamqd0(i));
    }

    /* JADX INFO: renamed from: ActualRadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m2942ActualRadialGradientShader8uybcMk(long j, float f, List<Color> list, List<Float> list2, int i) {
        AbstractC4492zt.h(list, "colors");
        validateColorStops(list, list2);
        int iCountTransparentColors = countTransparentColors(list);
        return new android.graphics.RadialGradient(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), f, makeTransparentColors(list, iCountTransparentColors), makeTransparentStops(list2, list, iCountTransparentColors), AndroidTileMode_androidKt.m2945toAndroidTileMode0vamqd0(i));
    }

    /* JADX INFO: renamed from: ActualSweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m2943ActualSweepGradientShader9KIMszo(long j, List<Color> list, List<Float> list2) {
        AbstractC4492zt.h(list, "colors");
        validateColorStops(list, list2);
        int iCountTransparentColors = countTransparentColors(list);
        return new android.graphics.SweepGradient(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), makeTransparentColors(list, iCountTransparentColors), makeTransparentStops(list2, list, iCountTransparentColors));
    }

    @VisibleForTesting
    public static final int countTransparentColors(List<Color> list) {
        AbstractC4492zt.h(list, "colors");
        int i = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            return 0;
        }
        int iO = AbstractC1886cc.o(list);
        for (int i2 = 1; i2 < iO; i2++) {
            if (Color.m3034getAlphaimpl(list.get(i2).m3042unboximpl()) == 0.0f) {
                i++;
            }
        }
        return i;
    }

    @VisibleForTesting
    public static final int[] makeTransparentColors(List<Color> list, int i) {
        int i2;
        AbstractC4492zt.h(list, "colors");
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            int size = list.size();
            int[] iArr = new int[size];
            while (i3 < size) {
                iArr[i3] = ColorKt.m3086toArgb8_81llA(list.get(i3).m3042unboximpl());
                i3++;
            }
            return iArr;
        }
        int[] iArr2 = new int[list.size() + i];
        int iO = AbstractC1886cc.o(list);
        int size2 = list.size();
        int i4 = 0;
        while (i3 < size2) {
            long jM3042unboximpl = list.get(i3).m3042unboximpl();
            if (Color.m3034getAlphaimpl(jM3042unboximpl) == 0.0f) {
                if (i3 == 0) {
                    i2 = i4 + 1;
                    iArr2[i4] = ColorKt.m3086toArgb8_81llA(Color.m3031copywmQWz5c$default(list.get(1).m3042unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else if (i3 == iO) {
                    i2 = i4 + 1;
                    iArr2[i4] = ColorKt.m3086toArgb8_81llA(Color.m3031copywmQWz5c$default(list.get(i3 - 1).m3042unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else {
                    int i5 = i4 + 1;
                    iArr2[i4] = ColorKt.m3086toArgb8_81llA(Color.m3031copywmQWz5c$default(list.get(i3 - 1).m3042unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                    i4 += 2;
                    iArr2[i5] = ColorKt.m3086toArgb8_81llA(Color.m3031copywmQWz5c$default(list.get(i3 + 1).m3042unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                }
                i4 = i2;
            } else {
                iArr2[i4] = ColorKt.m3086toArgb8_81llA(jM3042unboximpl);
                i4++;
            }
            i3++;
        }
        return iArr2;
    }

    @VisibleForTesting
    public static final float[] makeTransparentStops(List<Float> list, List<Color> list2, int i) {
        AbstractC4492zt.h(list2, "colors");
        if (i == 0) {
            if (list != null) {
                return AbstractC3240kc.A0(list);
            }
            return null;
        }
        float[] fArr = new float[list2.size() + i];
        fArr[0] = list != null ? list.get(0).floatValue() : 0.0f;
        int iO = AbstractC1886cc.o(list2);
        int i2 = 1;
        for (int i3 = 1; i3 < iO; i3++) {
            long jM3042unboximpl = list2.get(i3).m3042unboximpl();
            float fFloatValue = list != null ? list.get(i3).floatValue() : i3 / AbstractC1886cc.o(list2);
            int i4 = i2 + 1;
            fArr[i2] = fFloatValue;
            if (Color.m3034getAlphaimpl(jM3042unboximpl) == 0.0f) {
                i2 += 2;
                fArr[i4] = fFloatValue;
            } else {
                i2 = i4;
            }
        }
        fArr[i2] = list != null ? list.get(AbstractC1886cc.o(list2)).floatValue() : 1.0f;
        return fArr;
    }

    private static final void validateColorStops(List<Color> list, List<Float> list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
