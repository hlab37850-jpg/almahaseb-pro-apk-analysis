package androidx.compose.material3;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public interface ThresholdConfig {
    float computeThreshold(Density density, float f, float f2);
}
