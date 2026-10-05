package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class PagerSemanticsKt {
    @Composable
    public static final LazyLayoutSemanticState rememberPagerSemanticState(PagerState pagerState, boolean z, boolean z2, Composer composer, int i) {
        AbstractC4492zt.h(pagerState, "state");
        composer.startReplaceableGroup(352210115);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(352210115, i, -1, "androidx.compose.foundation.pager.rememberPagerSemanticState (PagerSemantics.kt:25)");
        }
        Boolean boolValueOf = Boolean.valueOf(z);
        Boolean boolValueOf2 = Boolean.valueOf(z2);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(boolValueOf) | composer.changed(pagerState) | composer.changed(boolValueOf2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = LazyLayoutSemanticStateKt.LazyLayoutSemanticState(pagerState, z2);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        LazyLayoutSemanticState lazyLayoutSemanticState = (LazyLayoutSemanticState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyLayoutSemanticState;
    }
}
