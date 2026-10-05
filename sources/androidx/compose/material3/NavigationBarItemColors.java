package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class NavigationBarItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5, j6, j7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationBarItemColors)) {
            return false;
        }
        NavigationBarItemColors navigationBarItemColors = (NavigationBarItemColors) obj;
        return Color.m3033equalsimpl0(this.selectedIconColor, navigationBarItemColors.selectedIconColor) && Color.m3033equalsimpl0(this.unselectedIconColor, navigationBarItemColors.unselectedIconColor) && Color.m3033equalsimpl0(this.selectedTextColor, navigationBarItemColors.selectedTextColor) && Color.m3033equalsimpl0(this.unselectedTextColor, navigationBarItemColors.unselectedTextColor) && Color.m3033equalsimpl0(this.selectedIndicatorColor, navigationBarItemColors.selectedIndicatorColor) && Color.m3033equalsimpl0(this.disabledIconColor, navigationBarItemColors.disabledIconColor) && Color.m3033equalsimpl0(this.disabledTextColor, navigationBarItemColors.disabledTextColor);
    }

    /* JADX INFO: renamed from: getIndicatorColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1656getIndicatorColor0d7_KjU$material3_release() {
        return this.selectedIndicatorColor;
    }

    public int hashCode() {
        return (((((((((((Color.m3039hashCodeimpl(this.selectedIconColor) * 31) + Color.m3039hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m3039hashCodeimpl(this.selectedTextColor)) * 31) + Color.m3039hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m3039hashCodeimpl(this.selectedIndicatorColor)) * 31) + Color.m3039hashCodeimpl(this.disabledIconColor)) * 31) + Color.m3039hashCodeimpl(this.disabledTextColor);
    }

    @Composable
    public final State<Color> iconColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-1012982249);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1012982249, i, -1, "androidx.compose.material3.NavigationBarItemColors.iconColor (NavigationBar.kt:350)");
        }
        if (z2) {
            j = z ? this.selectedIconColor : this.unselectedIconColor;
        } else {
            j = this.disabledIconColor;
        }
        State<Color> stateM72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM72animateColorAsStateeuL9pac;
    }

    @Composable
    public final State<Color> textColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-1833866293);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1833866293, i, -1, "androidx.compose.material3.NavigationBarItemColors.textColor (NavigationBar.kt:369)");
        }
        if (z2) {
            j = z ? this.selectedTextColor : this.unselectedTextColor;
        } else {
            j = this.disabledTextColor;
        }
        State<Color> stateM72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM72animateColorAsStateeuL9pac;
    }

    private NavigationBarItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.selectedIconColor = j;
        this.selectedTextColor = j2;
        this.selectedIndicatorColor = j3;
        this.unselectedIconColor = j4;
        this.unselectedTextColor = j5;
        this.disabledIconColor = j6;
        this.disabledTextColor = j7;
    }
}
