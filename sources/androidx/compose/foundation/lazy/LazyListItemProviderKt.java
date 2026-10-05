package androidx.compose.foundation.lazy;

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
public final class LazyListItemProviderKt {
    @Composable
    public static final InterfaceC3588op rememberLazyListItemProviderLambda(LazyListState lazyListState, InterfaceC3750qp interfaceC3750qp, Composer composer, int i) {
        AbstractC4492zt.h(lazyListState, "state");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        composer.startReplaceableGroup(-343736148);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-343736148, i, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProviderLambda (LazyListItemProvider.kt:40)");
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC3750qp, composer, (i >> 3) & 14);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(lazyListState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            LazyItemScopeImpl lazyItemScopeImpl = new LazyItemScopeImpl();
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$itemProviderState$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$intervalContentState$1(stateRememberUpdatedState)), lazyListState, lazyItemScopeImpl));
            objRememberedValue = new AbstractC3709qI(stateDerivedStateOf) { // from class: androidx.compose.foundation.lazy.LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$1
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
