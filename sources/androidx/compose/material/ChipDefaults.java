package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = Dp.m5160constructorimpl(32);
    private static final float OutlinedBorderSize = Dp.m5160constructorimpl(1);
    private static final float LeadingIconSize = Dp.m5160constructorimpl(20);
    private static final float SelectedIconSize = Dp.m5160constructorimpl(18);

    private ChipDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1034chipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM3077compositeOverOWjLjI;
        long jM3077compositeOverOWjLjI2;
        long jM3031copywmQWz5c$default;
        long jM3031copywmQWz5c$default2;
        composer.startReplaceableGroup(1838505436);
        if ((i2 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM3077compositeOverOWjLjI = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(materialTheme.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            jM3077compositeOverOWjLjI = j;
        }
        long jM3031copywmQWz5c$default3 = (i2 & 2) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM3031copywmQWz5c$default4 = (i2 & 4) != 0 ? Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if ((i2 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            jM3077compositeOverOWjLjI2 = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(materialTheme2.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            jM3077compositeOverOWjLjI2 = j4;
        }
        if ((i2 & 16) != 0) {
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default3, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default = j5;
        }
        if ((i2 & 32) != 0) {
            jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default2 = j6;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, i, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:384)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(jM3077compositeOverOWjLjI, jM3031copywmQWz5c$default3, jM3031copywmQWz5c$default4, jM3077compositeOverOWjLjI2, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultChipColors;
    }

    @Composable
    /* JADX INFO: renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1035filterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        long jM3077compositeOverOWjLjI;
        long jM3077compositeOverOWjLjI2;
        long jM3031copywmQWz5c$default;
        long jM3031copywmQWz5c$default2;
        composer.startReplaceableGroup(830140629);
        if ((i2 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM3077compositeOverOWjLjI = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(materialTheme.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            jM3077compositeOverOWjLjI = j;
        }
        long jM3031copywmQWz5c$default3 = (i2 & 2) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM3031copywmQWz5c$default4 = (i2 & 4) != 0 ? Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if ((i2 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            jM3077compositeOverOWjLjI2 = ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(materialTheme2.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.getColors(composer, 6).m1055getSurface0d7_KjU());
        } else {
            jM3077compositeOverOWjLjI2 = j4;
        }
        if ((i2 & 16) != 0) {
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default3, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default = j5;
        }
        if ((i2 & 32) != 0) {
            jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default2 = j6;
        }
        long jM3077compositeOverOWjLjI3 = (i2 & 64) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), jM3077compositeOverOWjLjI) : j7;
        long jM3077compositeOverOWjLjI4 = (i2 & 128) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM3031copywmQWz5c$default3) : j8;
        long jM3077compositeOverOWjLjI5 = (i2 & 256) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM3031copywmQWz5c$default4) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, i, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:454)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(jM3077compositeOverOWjLjI, jM3031copywmQWz5c$default3, jM3031copywmQWz5c$default4, jM3077compositeOverOWjLjI2, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, jM3077compositeOverOWjLjI3, jM3077compositeOverOWjLjI4, jM3077compositeOverOWjLjI5, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1036getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1037getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    @Composable
    public final BorderStroke getOutlinedBorder(Composer composer, int i) {
        composer.startReplaceableGroup(-1650225597);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, i, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:542)");
        }
        BorderStroke borderStrokeM194BorderStrokecXLIe8U = BorderStrokeKt.m194BorderStrokecXLIe8U(OutlinedBorderSize, Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStrokeM194BorderStrokecXLIe8U;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1038getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* JADX INFO: renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1039getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }

    @Composable
    /* JADX INFO: renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1040outlinedChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM3031copywmQWz5c$default;
        long jM3031copywmQWz5c$default2;
        composer.startReplaceableGroup(-1763922662);
        long jM1055getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU() : j;
        long jM3031copywmQWz5c$default3 = (i2 & 2) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM3031copywmQWz5c$default4 = (i2 & 4) != 0 ? Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j7 = (i2 & 8) != 0 ? jM1055getSurface0d7_KjU : j4;
        if ((i2 & 16) != 0) {
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default3, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default = j5;
        }
        if ((i2 & 32) != 0) {
            jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default2 = j6;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, i, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:420)");
        }
        ChipColors chipColorsM1034chipColors5tl4gsc = m1034chipColors5tl4gsc(jM1055getSurface0d7_KjU, jM3031copywmQWz5c$default3, jM3031copywmQWz5c$default4, j7, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipColorsM1034chipColors5tl4gsc;
    }

    @Composable
    /* JADX INFO: renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1041outlinedFilterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        long jM3031copywmQWz5c$default;
        long jM3031copywmQWz5c$default2;
        composer.startReplaceableGroup(346878099);
        long jM1055getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1055getSurface0d7_KjU() : j;
        long jM3031copywmQWz5c$default3 = (i2 & 2) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM3031copywmQWz5c$default4 = (i2 & 4) != 0 ? Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j10 = (i2 & 8) != 0 ? jM1055getSurface0d7_KjU : j4;
        if ((i2 & 16) != 0) {
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default3, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default = j5;
        }
        if ((i2 & 32) != 0) {
            jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default2 = j6;
        }
        long jM3077compositeOverOWjLjI = (i2 & 64) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM1055getSurface0d7_KjU) : j7;
        long jM3077compositeOverOWjLjI2 = (i2 & 128) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM3031copywmQWz5c$default3) : j8;
        long jM3077compositeOverOWjLjI3 = (i2 & 256) != 0 ? ColorKt.m3077compositeOverOWjLjI(Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM3031copywmQWz5c$default4) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, i, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:505)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(jM1055getSurface0d7_KjU, jM3031copywmQWz5c$default3, jM3031copywmQWz5c$default4, j10, jM3031copywmQWz5c$default, jM3031copywmQWz5c$default2, jM3077compositeOverOWjLjI, jM3077compositeOverOWjLjI2, jM3077compositeOverOWjLjI3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }
}
