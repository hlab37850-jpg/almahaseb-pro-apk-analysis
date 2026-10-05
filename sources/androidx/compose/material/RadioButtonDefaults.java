package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m1193colorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1370708026);
        long jM1053getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1053getSecondary0d7_KjU() : j;
        long jM3031copywmQWz5c$default = (i2 & 2) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM3031copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1370708026, i, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:162)");
        }
        Color colorM3022boximpl = Color.m3022boximpl(jM1053getSecondary0d7_KjU);
        Color colorM3022boximpl2 = Color.m3022boximpl(jM3031copywmQWz5c$default);
        Color colorM3022boximpl3 = Color.m3022boximpl(jM3031copywmQWz5c$default2);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(colorM3022boximpl) | composer.changed(colorM3022boximpl2) | composer.changed(colorM3022boximpl3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultRadioButtonColors(jM1053getSecondary0d7_KjU, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultRadioButtonColors;
    }
}
