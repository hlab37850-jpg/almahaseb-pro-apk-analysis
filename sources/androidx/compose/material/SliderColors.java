package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface SliderColors {
    @Composable
    State<Color> thumbColor(boolean z, Composer composer, int i);

    @Composable
    State<Color> tickColor(boolean z, boolean z2, Composer composer, int i);

    @Composable
    State<Color> trackColor(boolean z, boolean z2, Composer composer, int i);
}
