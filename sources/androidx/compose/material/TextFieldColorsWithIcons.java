package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC2115eU;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterialApi
public interface TextFieldColorsWithIcons extends TextFieldColors {

    public static final class DefaultImpls {
        @Composable
        @Deprecated
        public static State<Color> leadingIconColor(TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
            AbstractC4492zt.h(interactionSource, "interactionSource");
            return AbstractC2115eU.a(textFieldColorsWithIcons, z, z2, interactionSource, composer, i);
        }

        @Composable
        @Deprecated
        public static State<Color> trailingIconColor(TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i) {
            AbstractC4492zt.h(interactionSource, "interactionSource");
            return AbstractC2115eU.b(textFieldColorsWithIcons, z, z2, interactionSource, composer, i);
        }
    }

    @Composable
    State<Color> leadingIconColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i);

    @Composable
    State<Color> trailingIconColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i);
}
