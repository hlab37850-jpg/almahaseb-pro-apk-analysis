package androidx.compose.foundation.gestures.snapping;

import androidx.compose.ui.unit.Density;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SnapPositionInLayoutKt {
    public static final float calculateDistanceToDesiredSnapPosition(Density density, int i, int i2, int i3, int i4, int i5, int i6, SnapPositionInLayout snapPositionInLayout) {
        AbstractC4492zt.h(density, "<this>");
        AbstractC4492zt.h(snapPositionInLayout, "snapPositionInLayout");
        return i5 - snapPositionInLayout.position(density, (i - i2) - i3, i4, i6);
    }
}
