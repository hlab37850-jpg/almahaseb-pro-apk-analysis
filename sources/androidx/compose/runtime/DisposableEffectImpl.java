package androidx.compose.runtime;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class DisposableEffectImpl implements RememberObserver {
    private final InterfaceC3750qp effect;
    private DisposableEffectResult onDispose;

    public DisposableEffectImpl(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "effect");
        this.effect = interfaceC3750qp;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        DisposableEffectResult disposableEffectResult = this.onDispose;
        if (disposableEffectResult != null) {
            disposableEffectResult.dispose();
        }
        this.onDispose = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.onDispose = (DisposableEffectResult) this.effect.invoke(EffectsKt.InternalDisposableEffectScope);
    }
}
