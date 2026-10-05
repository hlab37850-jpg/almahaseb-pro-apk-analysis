package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface CheckboxColors {
    @Composable
    State<Color> borderColor(boolean z, ToggleableState toggleableState, Composer composer, int i);

    @Composable
    State<Color> boxColor(boolean z, ToggleableState toggleableState, Composer composer, int i);

    @Composable
    State<Color> checkmarkColor(ToggleableState toggleableState, Composer composer, int i);
}
