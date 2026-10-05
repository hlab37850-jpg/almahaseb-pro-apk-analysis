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
public final class ChipColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconContentColor;
    private final long disabledTrailingIconContentColor;
    private final long labelColor;
    private final long leadingIconContentColor;
    private final long trailingIconContentColor;

    public /* synthetic */ ChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    @Composable
    public final State<Color> containerColor$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-136683658);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-136683658, i, -1, "androidx.compose.material3.ChipColors.containerColor (Chip.kt:1776)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(z ? this.containerColor : this.disabledContainerColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChipColors)) {
            return false;
        }
        ChipColors chipColors = (ChipColors) obj;
        return Color.m3033equalsimpl0(this.containerColor, chipColors.containerColor) && Color.m3033equalsimpl0(this.labelColor, chipColors.labelColor) && Color.m3033equalsimpl0(this.leadingIconContentColor, chipColors.leadingIconContentColor) && Color.m3033equalsimpl0(this.trailingIconContentColor, chipColors.trailingIconContentColor) && Color.m3033equalsimpl0(this.disabledContainerColor, chipColors.disabledContainerColor) && Color.m3033equalsimpl0(this.disabledLabelColor, chipColors.disabledLabelColor) && Color.m3033equalsimpl0(this.disabledLeadingIconContentColor, chipColors.disabledLeadingIconContentColor) && Color.m3033equalsimpl0(this.disabledTrailingIconContentColor, chipColors.disabledTrailingIconContentColor);
    }

    public int hashCode() {
        return (((((((((((((Color.m3039hashCodeimpl(this.containerColor) * 31) + Color.m3039hashCodeimpl(this.labelColor)) * 31) + Color.m3039hashCodeimpl(this.leadingIconContentColor)) * 31) + Color.m3039hashCodeimpl(this.trailingIconContentColor)) * 31) + Color.m3039hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m3039hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m3039hashCodeimpl(this.disabledLeadingIconContentColor)) * 31) + Color.m3039hashCodeimpl(this.disabledTrailingIconContentColor);
    }

    @Composable
    public final State<Color> labelColor$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(559848681);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(559848681, i, -1, "androidx.compose.material3.ChipColors.labelColor (Chip.kt:1786)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(z ? this.labelColor : this.disabledLabelColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> leadingIconContentColor$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(5136811);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5136811, i, -1, "androidx.compose.material3.ChipColors.leadingIconContentColor (Chip.kt:1796)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(z ? this.leadingIconContentColor : this.disabledLeadingIconContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> trailingIconContentColor$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(96182905);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(96182905, i, -1, "androidx.compose.material3.ChipColors.trailingIconContentColor (Chip.kt:1808)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(z ? this.trailingIconContentColor : this.disabledTrailingIconContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private ChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.containerColor = j;
        this.labelColor = j2;
        this.leadingIconContentColor = j3;
        this.trailingIconContentColor = j4;
        this.disabledContainerColor = j5;
        this.disabledLabelColor = j6;
        this.disabledLeadingIconContentColor = j7;
        this.disabledTrailingIconContentColor = j8;
    }
}
