package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterial3Api
public final class SelectableChipBorder {
    public static final int $stable = 0;
    private final long borderColor;
    private final float borderWidth;
    private final long disabledBorderColor;
    private final long disabledSelectedBorderColor;
    private final long selectedBorderColor;
    private final float selectedBorderWidth;

    public /* synthetic */ SelectableChipBorder(long j, long j2, long j3, long j4, float f, float f2, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, f, f2);
    }

    @Composable
    public final State<BorderStroke> borderStroke$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(670222826);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(670222826, i, -1, "androidx.compose.material3.SelectableChipBorder.borderStroke (Chip.kt:1993)");
        }
        if (z) {
            j = z2 ? this.selectedBorderColor : this.borderColor;
        } else {
            j = z2 ? this.disabledSelectedBorderColor : this.disabledBorderColor;
        }
        State<BorderStroke> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m194BorderStrokecXLIe8U(z2 ? this.selectedBorderWidth : this.borderWidth, j), composer, 0);
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
        if (obj == null || !(obj instanceof SelectableChipBorder)) {
            return false;
        }
        SelectableChipBorder selectableChipBorder = (SelectableChipBorder) obj;
        return Color.m3033equalsimpl0(this.borderColor, selectableChipBorder.borderColor) && Color.m3033equalsimpl0(this.selectedBorderColor, selectableChipBorder.selectedBorderColor) && Color.m3033equalsimpl0(this.disabledBorderColor, selectableChipBorder.disabledBorderColor) && Color.m3033equalsimpl0(this.disabledSelectedBorderColor, selectableChipBorder.disabledSelectedBorderColor) && Dp.m5165equalsimpl0(this.borderWidth, selectableChipBorder.borderWidth) && Dp.m5165equalsimpl0(this.selectedBorderWidth, selectableChipBorder.selectedBorderWidth);
    }

    public int hashCode() {
        return (((((((((Color.m3039hashCodeimpl(this.borderColor) * 31) + Color.m3039hashCodeimpl(this.selectedBorderColor)) * 31) + Color.m3039hashCodeimpl(this.disabledBorderColor)) * 31) + Color.m3039hashCodeimpl(this.disabledSelectedBorderColor)) * 31) + Dp.m5166hashCodeimpl(this.borderWidth)) * 31) + Dp.m5166hashCodeimpl(this.selectedBorderWidth);
    }

    private SelectableChipBorder(long j, long j2, long j3, long j4, float f, float f2) {
        this.borderColor = j;
        this.selectedBorderColor = j2;
        this.disabledBorderColor = j3;
        this.disabledSelectedBorderColor = j4;
        this.borderWidth = f;
        this.selectedBorderWidth = f2;
    }
}
