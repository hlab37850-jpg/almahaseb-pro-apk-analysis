package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class SliderColors {
    public static final int $stable = 0;
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ SliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SliderColors)) {
            return false;
        }
        SliderColors sliderColors = (SliderColors) obj;
        return Color.m3033equalsimpl0(this.thumbColor, sliderColors.thumbColor) && Color.m3033equalsimpl0(this.activeTrackColor, sliderColors.activeTrackColor) && Color.m3033equalsimpl0(this.activeTickColor, sliderColors.activeTickColor) && Color.m3033equalsimpl0(this.inactiveTrackColor, sliderColors.inactiveTrackColor) && Color.m3033equalsimpl0(this.inactiveTickColor, sliderColors.inactiveTickColor) && Color.m3033equalsimpl0(this.disabledThumbColor, sliderColors.disabledThumbColor) && Color.m3033equalsimpl0(this.disabledActiveTrackColor, sliderColors.disabledActiveTrackColor) && Color.m3033equalsimpl0(this.disabledActiveTickColor, sliderColors.disabledActiveTickColor) && Color.m3033equalsimpl0(this.disabledInactiveTrackColor, sliderColors.disabledInactiveTrackColor) && Color.m3033equalsimpl0(this.disabledInactiveTickColor, sliderColors.disabledInactiveTickColor);
    }

    public int hashCode() {
        return (((((((((((((((((Color.m3039hashCodeimpl(this.thumbColor) * 31) + Color.m3039hashCodeimpl(this.activeTrackColor)) * 31) + Color.m3039hashCodeimpl(this.activeTickColor)) * 31) + Color.m3039hashCodeimpl(this.inactiveTrackColor)) * 31) + Color.m3039hashCodeimpl(this.inactiveTickColor)) * 31) + Color.m3039hashCodeimpl(this.disabledThumbColor)) * 31) + Color.m3039hashCodeimpl(this.disabledActiveTrackColor)) * 31) + Color.m3039hashCodeimpl(this.disabledActiveTickColor)) * 31) + Color.m3039hashCodeimpl(this.disabledInactiveTrackColor)) * 31) + Color.m3039hashCodeimpl(this.disabledInactiveTickColor);
    }

    @Composable
    public final State<Color> thumbColor$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-1917959445);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1917959445, i, -1, "androidx.compose.material3.SliderColors.thumbColor (Slider.kt:1352)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(z ? this.thumbColor : this.disabledThumbColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> tickColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(337026738);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(337026738, i, -1, "androidx.compose.material3.SliderColors.tickColor (Slider.kt:1368)");
        }
        if (z) {
            j = z2 ? this.activeTickColor : this.inactiveTickColor;
        } else {
            j = z2 ? this.disabledActiveTickColor : this.disabledInactiveTickColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> trackColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(760609284);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(760609284, i, -1, "androidx.compose.material3.SliderColors.trackColor (Slider.kt:1357)");
        }
        if (z) {
            j = z2 ? this.activeTrackColor : this.inactiveTrackColor;
        } else {
            j = z2 ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private SliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.thumbColor = j;
        this.activeTrackColor = j2;
        this.activeTickColor = j3;
        this.inactiveTrackColor = j4;
        this.inactiveTickColor = j5;
        this.disabledThumbColor = j6;
        this.disabledActiveTrackColor = j7;
        this.disabledActiveTickColor = j8;
        this.disabledInactiveTrackColor = j9;
        this.disabledInactiveTickColor = j10;
    }
}
