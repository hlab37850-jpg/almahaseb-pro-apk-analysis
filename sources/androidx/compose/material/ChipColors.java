package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public interface ChipColors {
    @Composable
    State<Color> backgroundColor(boolean z, Composer composer, int i);

    @Composable
    State<Color> contentColor(boolean z, Composer composer, int i);

    @Composable
    State<Color> leadingIconContentColor(boolean z, Composer composer, int i);
}
