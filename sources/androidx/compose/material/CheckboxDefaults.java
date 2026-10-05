package androidx.compose.material;

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
    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final CheckboxColors m1028colorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(469524104);
        long jM1053getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1053getSecondary0d7_KjU() : j;
        long jM3031copywmQWz5c$default = (i2 & 2) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM1055getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU() : j3;
        long jM3031copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jM3031copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m3031copywmQWz5c$default(jM1053getSecondary0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469524104, i, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:226)");
        }
        Object[] objArr = {Color.m3022boximpl(jM1053getSecondary0d7_KjU), Color.m3022boximpl(jM3031copywmQWz5c$default), Color.m3022boximpl(jM1055getSurface0d7_KjU), Color.m3022boximpl(jM3031copywmQWz5c$default2), Color.m3022boximpl(jM3031copywmQWz5c$default3)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i3 = 0; i3 < 5; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultCheckboxColors(jM1055getSurface0d7_KjU, Color.m3031copywmQWz5c$default(jM1055getSurface0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM1053getSecondary0d7_KjU, Color.m3031copywmQWz5c$default(jM1053getSecondary0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM3031copywmQWz5c$default2, Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default2, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM3031copywmQWz5c$default3, jM1053getSecondary0d7_KjU, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, jM3031copywmQWz5c$default3, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultCheckboxColors defaultCheckboxColors = (DefaultCheckboxColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultCheckboxColors;
    }
}
