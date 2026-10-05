package androidx.compose.material;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public interface ThresholdConfig {
    float computeThreshold(Density density, float f, float f2);
}
