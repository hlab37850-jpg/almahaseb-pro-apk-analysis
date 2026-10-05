package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface Indication {
    @Composable
    IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer composer, int i);
}
