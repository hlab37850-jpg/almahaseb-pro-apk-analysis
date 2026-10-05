package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = Dp.m5160constructorimpl(10);
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 225;

    /* JADX INFO: renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m1313getRippleEndRadiuscSwnlzA(Density density, boolean z, long j) {
        AbstractC4492zt.h(density, "$this$getRippleEndRadius");
        float fM2796getDistanceimpl = Offset.m2796getDistanceimpl(OffsetKt.Offset(Size.m2867getWidthimpl(j), Size.m2864getHeightimpl(j))) / 2.0f;
        return z ? fM2796getDistanceimpl + density.mo333toPx0680j_4(BoundedRippleExtraRadius) : fM2796getDistanceimpl;
    }

    /* JADX INFO: renamed from: getRippleStartRadius-uvyYCjk, reason: not valid java name */
    public static final float m1314getRippleStartRadiusuvyYCjk(long j) {
        return Math.max(Size.m2867getWidthimpl(j), Size.m2864getHeightimpl(j)) * 0.3f;
    }
}
