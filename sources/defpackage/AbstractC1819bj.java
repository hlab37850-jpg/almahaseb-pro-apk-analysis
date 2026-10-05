package defpackage;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;

/* JADX INFO: renamed from: bj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1819bj {
    public static int a(Density density, long j) {
        return AbstractC1210aB.c(density.mo332toPxR2X_6o(j));
    }

    public static int b(Density density, float f) {
        float fMo333toPx0680j_4 = density.mo333toPx0680j_4(f);
        if (Float.isInfinite(fMo333toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return AbstractC1210aB.c(fMo333toPx0680j_4);
    }

    public static float c(Density density, long j) {
        if (TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(j), TextUnitType.Companion.m5374getSpUIouoOA())) {
            return Dp.m5160constructorimpl(TextUnit.m5341getValueimpl(j) * density.getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px");
    }

    public static float d(Density density, float f) {
        return Dp.m5160constructorimpl(f / density.getDensity());
    }

    public static float e(Density density, int i) {
        return Dp.m5160constructorimpl(i / density.getDensity());
    }

    public static long f(Density density, long j) {
        return j != Size.Companion.m2875getUnspecifiedNHjbRc() ? DpKt.m5182DpSizeYgX7TsA(density.mo329toDpu2uoSUM(Size.m2867getWidthimpl(j)), density.mo329toDpu2uoSUM(Size.m2864getHeightimpl(j))) : DpSize.Companion.m5267getUnspecifiedMYxV2XQ();
    }

    public static float g(Density density, long j) {
        if (TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(j), TextUnitType.Companion.m5374getSpUIouoOA())) {
            return TextUnit.m5341getValueimpl(j) * density.getFontScale() * density.getDensity();
        }
        throw new IllegalStateException("Only Sp can convert to Px");
    }

    public static float h(Density density, float f) {
        return f * density.getDensity();
    }

    public static Rect i(Density density, DpRect dpRect) {
        AbstractC4492zt.h(dpRect, "<this>");
        return new Rect(density.mo333toPx0680j_4(dpRect.m5243getLeftD9Ej5fM()), density.mo333toPx0680j_4(dpRect.m5245getTopD9Ej5fM()), density.mo333toPx0680j_4(dpRect.m5244getRightD9Ej5fM()), density.mo333toPx0680j_4(dpRect.m5242getBottomD9Ej5fM()));
    }

    public static long j(Density density, long j) {
        return j != DpSize.Companion.m5267getUnspecifiedMYxV2XQ() ? SizeKt.Size(density.mo333toPx0680j_4(DpSize.m5258getWidthD9Ej5fM(j)), density.mo333toPx0680j_4(DpSize.m5256getHeightD9Ej5fM(j))) : Size.Companion.m2875getUnspecifiedNHjbRc();
    }

    public static long k(Density density, float f) {
        return TextUnitKt.getSp(f / density.getFontScale());
    }

    public static long l(Density density, float f) {
        return TextUnitKt.getSp(f / (density.getFontScale() * density.getDensity()));
    }

    public static long m(Density density, int i) {
        return TextUnitKt.getSp(i / (density.getFontScale() * density.getDensity()));
    }
}
