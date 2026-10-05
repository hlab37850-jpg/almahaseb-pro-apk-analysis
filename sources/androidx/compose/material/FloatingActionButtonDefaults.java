package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: elevation-ixp7dh8, reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m1134elevationixp7dh8(float f, float f2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-654132828);
        float fM5160constructorimpl = (i2 & 1) != 0 ? Dp.m5160constructorimpl(6) : f;
        float fM5160constructorimpl2 = (i2 & 2) != 0 ? Dp.m5160constructorimpl(12) : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-654132828, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:219)");
        }
        float f3 = 8;
        FloatingActionButtonElevation floatingActionButtonElevationM1135elevationxZ9QkE = m1135elevationxZ9QkE(fM5160constructorimpl, fM5160constructorimpl2, Dp.m5160constructorimpl(f3), Dp.m5160constructorimpl(f3), composer, (i & 14) | 3456 | (i & 112) | ((i << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return floatingActionButtonElevationM1135elevationxZ9QkE;
    }

    @Composable
    /* JADX INFO: renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m1135elevationxZ9QkE(float f, float f2, float f3, float f4, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(380403812);
        float fM5160constructorimpl = (i2 & 1) != 0 ? Dp.m5160constructorimpl(6) : f;
        float fM5160constructorimpl2 = (i2 & 2) != 0 ? Dp.m5160constructorimpl(12) : f2;
        float fM5160constructorimpl3 = (i2 & 4) != 0 ? Dp.m5160constructorimpl(8) : f3;
        float fM5160constructorimpl4 = (i2 & 8) != 0 ? Dp.m5160constructorimpl(8) : f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(380403812, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:244)");
        }
        Object[] objArr = {Dp.m5158boximpl(fM5160constructorimpl), Dp.m5158boximpl(fM5160constructorimpl2), Dp.m5158boximpl(fM5160constructorimpl3), Dp.m5158boximpl(fM5160constructorimpl4)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i3 = 0; i3 < 4; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultFloatingActionButtonElevation(fM5160constructorimpl, fM5160constructorimpl2, fM5160constructorimpl3, fM5160constructorimpl4, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultFloatingActionButtonElevation;
    }
}
