package androidx.compose.runtime;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class StaticProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticProvidableCompositionLocal(InterfaceC3588op interfaceC3588op) {
        super(interfaceC3588op);
        AbstractC4492zt.h(interfaceC3588op, "defaultFactory");
    }

    @Override // androidx.compose.runtime.CompositionLocal
    @Composable
    public State<T> provided$runtime_release(T t, Composer composer, int i) {
        composer.startReplaceableGroup(-1121811719);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1121811719, i, -1, "androidx.compose.runtime.StaticProvidableCompositionLocal.provided (CompositionLocal.kt:139)");
        }
        StaticValueHolder staticValueHolder = new StaticValueHolder(t);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return staticValueHolder;
    }
}
