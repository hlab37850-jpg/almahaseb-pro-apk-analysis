package androidx.compose.foundation.pager;

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
public final class PagerBeyondBoundsModifierKt {
    @Composable
    public static final Modifier pagerBeyondBoundsModifier(Modifier modifier, PagerState pagerState, int i, boolean z, Orientation orientation, Composer composer, int i2) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(pagerState, "state");
        AbstractC4492zt.h(orientation, "orientation");
        composer.startReplaceableGroup(633480912);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(633480912, i2, -1, "androidx.compose.foundation.pager.pagerBeyondBoundsModifier (PagerBeyondBoundsModifier.kt:33)");
        }
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        Object[] objArr = {pagerState, Integer.valueOf(i), Boolean.valueOf(z), layoutDirection, orientation};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i3 = 0; i3 < 5; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyLayoutBeyondBoundsModifierLocal(new PagerBeyondBoundsState(pagerState, i), pagerState.getBeyondBoundsInfo$foundation_release(), z, layoutDirection, orientation);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierThen = modifier.then((Modifier) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierThen;
    }
}
