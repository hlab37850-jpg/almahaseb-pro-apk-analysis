package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListBeyondBoundsModifierKt {
    @Composable
    public static final Modifier lazyListBeyondBoundsModifier(Modifier modifier, LazyListState lazyListState, int i, boolean z, Orientation orientation, Composer composer, int i2) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(lazyListState, "state");
        AbstractC4492zt.h(orientation, "orientation");
        composer.startReplaceableGroup(1452310458);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1452310458, i2, -1, "androidx.compose.foundation.lazy.lazyListBeyondBoundsModifier (LazyListBeyondBoundsModifier.kt:32)");
        }
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        Object objValueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(objValueOf) | composer.changed(lazyListState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyListBeyondBoundsState(lazyListState, i);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        LazyListBeyondBoundsState lazyListBeyondBoundsState = (LazyListBeyondBoundsState) objRememberedValue;
        LazyLayoutBeyondBoundsInfo beyondBoundsInfo$foundation_release = lazyListState.getBeyondBoundsInfo$foundation_release();
        Object[] objArr = {lazyListBeyondBoundsState, beyondBoundsInfo$foundation_release, Boolean.valueOf(z), layoutDirection, orientation};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged2 = false;
        for (int i3 = 0; i3 < 5; i3++) {
            zChanged2 |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new LazyLayoutBeyondBoundsModifierLocal(lazyListBeyondBoundsState, beyondBoundsInfo$foundation_release, z, layoutDirection, orientation);
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
