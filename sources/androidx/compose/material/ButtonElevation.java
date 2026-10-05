package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface ButtonElevation {
    @Composable
    State<Dp> elevation(boolean z, InteractionSource interactionSource, Composer composer, int i);
}
