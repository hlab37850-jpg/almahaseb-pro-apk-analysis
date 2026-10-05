package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterialApi
public interface SelectableChipColors {
    @Composable
    State<Color> backgroundColor(boolean z, boolean z2, Composer composer, int i);

    @Composable
    State<Color> contentColor(boolean z, boolean z2, Composer composer, int i);

    @Composable
    State<Color> leadingIconColor(boolean z, boolean z2, Composer composer, int i);
}
