package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class DisposableEffectScope {
    public static final int $stable = 0;

    public final DisposableEffectResult onDispose(final InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "onDisposeEffect");
        return new DisposableEffectResult() { // from class: androidx.compose.runtime.DisposableEffectScope.onDispose.1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                interfaceC3588op.invoke();
            }
        };
    }
}
