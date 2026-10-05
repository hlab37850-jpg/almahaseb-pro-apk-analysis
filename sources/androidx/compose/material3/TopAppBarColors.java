package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class TopAppBarColors {
    public static final int $stable = 0;
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long titleContentColor;

    public /* synthetic */ TopAppBarColors(long j, long j2, long j3, long j4, long j5, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5);
    }

    @Composable
    /* JADX INFO: renamed from: containerColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m2054containerColorXeAY9LY$material3_release(float f, Composer composer, int i) {
        composer.startReplaceableGroup(-1456204135);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1456204135, i, -1, "androidx.compose.material3.TopAppBarColors.containerColor (AppBar.kt:936)");
        }
        long jM3083lerpjxsXWHM = ColorKt.m3083lerpjxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(f));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM3083lerpjxsXWHM;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) obj;
        return Color.m3033equalsimpl0(this.containerColor, topAppBarColors.containerColor) && Color.m3033equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && Color.m3033equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && Color.m3033equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && Color.m3033equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor);
    }

    /* JADX INFO: renamed from: getActionIconContentColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m2055getActionIconContentColor0d7_KjU$material3_release() {
        return this.actionIconContentColor;
    }

    /* JADX INFO: renamed from: getNavigationIconContentColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m2056getNavigationIconContentColor0d7_KjU$material3_release() {
        return this.navigationIconContentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m2057getTitleContentColor0d7_KjU$material3_release() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return (((((((Color.m3039hashCodeimpl(this.containerColor) * 31) + Color.m3039hashCodeimpl(this.scrolledContainerColor)) * 31) + Color.m3039hashCodeimpl(this.navigationIconContentColor)) * 31) + Color.m3039hashCodeimpl(this.titleContentColor)) * 31) + Color.m3039hashCodeimpl(this.actionIconContentColor);
    }

    private TopAppBarColors(long j, long j2, long j3, long j4, long j5) {
        this.containerColor = j;
        this.scrolledContainerColor = j2;
        this.navigationIconContentColor = j3;
        this.titleContentColor = j4;
        this.actionIconContentColor = j5;
    }
}
