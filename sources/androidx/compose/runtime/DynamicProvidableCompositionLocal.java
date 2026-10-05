package androidx.compose.runtime;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DynamicProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    private final SnapshotMutationPolicy<T> policy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicProvidableCompositionLocal(SnapshotMutationPolicy<T> snapshotMutationPolicy, InterfaceC3588op interfaceC3588op) {
        super(interfaceC3588op);
        AbstractC4492zt.h(snapshotMutationPolicy, "policy");
        AbstractC4492zt.h(interfaceC3588op, "defaultFactory");
        this.policy = snapshotMutationPolicy;
    }

    @Override // androidx.compose.runtime.CompositionLocal
    @Composable
    public State<T> provided$runtime_release(T t, Composer composer, int i) {
        composer.startReplaceableGroup(-84026900);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-84026900, i, -1, "androidx.compose.runtime.DynamicProvidableCompositionLocal.provided (CompositionLocal.kt:125)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateOf(t, this.policy);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        mutableState.setValue(t);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
