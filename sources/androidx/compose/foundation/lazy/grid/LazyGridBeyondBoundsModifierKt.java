package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridBeyondBoundsModifierKt {
    @Composable
    public static final Modifier lazyGridBeyondBoundsModifier(Modifier modifier, LazyGridState lazyGridState, boolean z, Orientation orientation, Composer composer, int i) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(lazyGridState, "state");
        AbstractC4492zt.h(orientation, "orientation");
        composer.startReplaceableGroup(-438653865);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-438653865, i, -1, "androidx.compose.foundation.lazy.grid.lazyGridBeyondBoundsModifier (LazyGridBeyondBoundsModifier.kt:32)");
        }
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(lazyGridState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyGridBeyondBoundsState(lazyGridState);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridBeyondBoundsState lazyGridBeyondBoundsState = (LazyGridBeyondBoundsState) objRememberedValue;
        Object[] objArr = {lazyGridState, lazyGridBeyondBoundsState, Boolean.valueOf(z), layoutDirection, orientation};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged2 = false;
        for (int i2 = 0; i2 < 5; i2++) {
            zChanged2 |= composer.changed(objArr[i2]);
        }
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new LazyLayoutBeyondBoundsModifierLocal(lazyGridBeyondBoundsState, lazyGridState.getBeyondBoundsInfo$foundation_release(), z, layoutDirection, orientation);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier modifierThen = modifier.then((Modifier) objRememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierThen;
    }
}
