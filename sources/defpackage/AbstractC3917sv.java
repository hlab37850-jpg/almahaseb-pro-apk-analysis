package defpackage;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;

/* JADX INFO: renamed from: sv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3917sv {
    public static float a(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        if (TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(j), TextUnitType.Companion.m5374getSpUIouoOA())) {
            return Dp.m5160constructorimpl(TextUnit.m5341getValueimpl(j) * lazyLayoutMeasureScope.getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px");
    }

    public static float b(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f) {
        return Dp.m5160constructorimpl(f / lazyLayoutMeasureScope.getDensity());
    }

    public static float c(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i) {
        return Dp.m5160constructorimpl(i / lazyLayoutMeasureScope.getDensity());
    }

    public static long d(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        return j != Size.Companion.m2875getUnspecifiedNHjbRc() ? DpKt.m5182DpSizeYgX7TsA(lazyLayoutMeasureScope.mo329toDpu2uoSUM(Size.m2867getWidthimpl(j)), lazyLayoutMeasureScope.mo329toDpu2uoSUM(Size.m2864getHeightimpl(j))) : DpSize.Companion.m5267getUnspecifiedMYxV2XQ();
    }

    public static long e(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        return j != DpSize.Companion.m5267getUnspecifiedMYxV2XQ() ? SizeKt.Size(lazyLayoutMeasureScope.mo333toPx0680j_4(DpSize.m5258getWidthD9Ej5fM(j)), lazyLayoutMeasureScope.mo333toPx0680j_4(DpSize.m5256getHeightD9Ej5fM(j))) : Size.Companion.m2875getUnspecifiedNHjbRc();
    }

    public static long f(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f) {
        return TextUnitKt.getSp(f / lazyLayoutMeasureScope.getFontScale());
    }

    public static long g(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f) {
        return TextUnitKt.getSp(f / (lazyLayoutMeasureScope.getFontScale() * lazyLayoutMeasureScope.getDensity()));
    }

    public static long h(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i) {
        return TextUnitKt.getSp(i / (lazyLayoutMeasureScope.getFontScale() * lazyLayoutMeasureScope.getDensity()));
    }
}
