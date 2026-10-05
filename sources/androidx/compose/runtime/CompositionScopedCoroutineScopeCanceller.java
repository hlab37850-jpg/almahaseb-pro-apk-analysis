package androidx.compose.runtime;

import defpackage.AbstractC2133eg;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC2052dg;

/* JADX INFO: loaded from: classes.dex */
public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {
    private final InterfaceC2052dg coroutineScope;

    public CompositionScopedCoroutineScopeCanceller(InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
        this.coroutineScope = interfaceC2052dg;
    }

    public final InterfaceC2052dg getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        AbstractC2133eg.c(this.coroutineScope, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        AbstractC2133eg.c(this.coroutineScope, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
