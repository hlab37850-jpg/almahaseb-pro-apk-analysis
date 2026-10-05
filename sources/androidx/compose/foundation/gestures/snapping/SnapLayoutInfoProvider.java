package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.unit.Density;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface SnapLayoutInfoProvider {
    float calculateApproachOffset(Density density, float f);

    float calculateSnapStepSize(Density density);

    float calculateSnappingOffset(Density density, float f);
}
