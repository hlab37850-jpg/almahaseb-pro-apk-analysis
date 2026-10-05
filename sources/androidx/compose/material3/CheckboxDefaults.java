package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: colors-5tl4gsc, reason: not valid java name */
    public final CheckboxColors m1374colors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-89536160);
        long jFromToken = (i2 & 1) != 0 ? ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), CheckboxTokens.INSTANCE.getSelectedContainerColor()) : j;
        long jFromToken2 = (i2 & 2) != 0 ? ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), CheckboxTokens.INSTANCE.getUnselectedOutlineColor()) : j2;
        long jFromToken3 = (i2 & 4) != 0 ? ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), CheckboxTokens.INSTANCE.getSelectedIconColor()) : j3;
        long jM3031copywmQWz5c$default = (i2 & 8) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jM3031copywmQWz5c$default2 = (i2 & 16) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), CheckboxTokens.INSTANCE.getUnselectedDisabledOutlineColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long j7 = (i2 & 32) != 0 ? jM3031copywmQWz5c$default : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-89536160, i, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:197)");
        }
        CheckboxColors checkboxColors = new CheckboxColors(jFromToken3, Color.m3031copywmQWz5c$default(jFromToken3, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jFromToken, Color.m3031copywmQWz5c$default(jFromToken, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM3031copywmQWz5c$default, Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default2, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), j7, jFromToken, jFromToken2, jM3031copywmQWz5c$default, j7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return checkboxColors;
    }
}
