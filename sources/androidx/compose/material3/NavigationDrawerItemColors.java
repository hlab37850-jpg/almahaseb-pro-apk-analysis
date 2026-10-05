package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface NavigationDrawerItemColors {
    @Composable
    State<Color> badgeColor(boolean z, Composer composer, int i);

    @Composable
    State<Color> containerColor(boolean z, Composer composer, int i);

    @Composable
    State<Color> iconColor(boolean z, Composer composer, int i);

    @Composable
    State<Color> textColor(boolean z, Composer composer, int i);
}
