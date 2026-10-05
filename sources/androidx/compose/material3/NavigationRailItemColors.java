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
public final class NavigationRailItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationRailItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5, j6, j7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationRailItemColors)) {
            return false;
        }
        NavigationRailItemColors navigationRailItemColors = (NavigationRailItemColors) obj;
        return Color.m3033equalsimpl0(this.selectedIconColor, navigationRailItemColors.selectedIconColor) && Color.m3033equalsimpl0(this.unselectedIconColor, navigationRailItemColors.unselectedIconColor) && Color.m3033equalsimpl0(this.selectedTextColor, navigationRailItemColors.selectedTextColor) && Color.m3033equalsimpl0(this.unselectedTextColor, navigationRailItemColors.unselectedTextColor) && Color.m3033equalsimpl0(this.selectedIndicatorColor, navigationRailItemColors.selectedIndicatorColor) && Color.m3033equalsimpl0(this.disabledIconColor, navigationRailItemColors.disabledIconColor) && Color.m3033equalsimpl0(this.disabledTextColor, navigationRailItemColors.disabledTextColor);
    }

    @Composable
    public final long getIndicatorColor(Composer composer, int i) {
        composer.startReplaceableGroup(618271448);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(618271448, i, -1, "androidx.compose.material3.NavigationRailItemColors.<get-indicatorColor> (NavigationRail.kt:382)");
        }
        long j = this.selectedIndicatorColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return j;
    }

    public int hashCode() {
        return (((((((((((Color.m3039hashCodeimpl(this.selectedIconColor) * 31) + Color.m3039hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m3039hashCodeimpl(this.selectedTextColor)) * 31) + Color.m3039hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m3039hashCodeimpl(this.selectedIndicatorColor)) * 31) + Color.m3039hashCodeimpl(this.disabledIconColor)) * 31) + Color.m3039hashCodeimpl(this.disabledTextColor);
    }

    @Composable
    public final State<Color> iconColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(2131995553);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2131995553, i, -1, "androidx.compose.material3.NavigationRailItemColors.iconColor (NavigationRail.kt:348)");
        }
        if (z2) {
            j = z ? this.selectedIconColor : this.unselectedIconColor;
        } else {
            j = this.disabledIconColor;
        }
        State<Color> stateM72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM72animateColorAsStateeuL9pac;
    }

    @Composable
    public final State<Color> textColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-758555563);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-758555563, i, -1, "androidx.compose.material3.NavigationRailItemColors.textColor (NavigationRail.kt:367)");
        }
        if (z2) {
            j = z ? this.selectedTextColor : this.unselectedTextColor;
        } else {
            j = this.disabledTextColor;
        }
        State<Color> stateM72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM72animateColorAsStateeuL9pac;
    }

    private NavigationRailItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.selectedIconColor = j;
        this.selectedTextColor = j2;
        this.selectedIndicatorColor = j3;
        this.unselectedIconColor = j4;
        this.unselectedTextColor = j5;
        this.disabledIconColor = j6;
        this.disabledTextColor = j7;
    }
}
