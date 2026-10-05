package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC3709qI;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC1003Vu;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridItemProviderKt {
    @Composable
    public static final InterfaceC3588op rememberStaggeredGridItemProviderLambda(LazyStaggeredGridState lazyStaggeredGridState, InterfaceC3750qp interfaceC3750qp, Composer composer, int i) {
        AbstractC4492zt.h(lazyStaggeredGridState, "state");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        composer.startReplaceableGroup(690901732);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(690901732, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProviderLambda (LazyStaggeredGridItemProvider.kt:37)");
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composer, (i >> 3) & 14);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(lazyStaggeredGridState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProviderLambda$1$itemProviderState$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProviderLambda$1$intervalContentState$1(stateRememberUpdatedState)), lazyStaggeredGridState));
            objRememberedValue = new AbstractC3709qI(stateDerivedStateOf) { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProviderLambda$1$1
                @Override // defpackage.InterfaceC1003Vu
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InterfaceC1003Vu interfaceC1003Vu = (InterfaceC1003Vu) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return interfaceC1003Vu;
    }
}
