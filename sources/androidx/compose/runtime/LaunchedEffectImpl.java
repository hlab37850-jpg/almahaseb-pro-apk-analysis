package androidx.compose.runtime;

import defpackage.AbstractC2133eg;
import defpackage.AbstractC3511nu;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.O8;

/* JADX INFO: loaded from: classes.dex */
public final class LaunchedEffectImpl implements RememberObserver {
    private InterfaceC1830bu job;
    private final InterfaceC2052dg scope;
    private final InterfaceC0526Fp task;

    public LaunchedEffectImpl(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0988Vf, "parentCoroutineContext");
        AbstractC4492zt.h(interfaceC0526Fp, "task");
        this.task = interfaceC0526Fp;
        this.scope = AbstractC2133eg.a(interfaceC0988Vf);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        InterfaceC1830bu interfaceC1830bu = this.job;
        if (interfaceC1830bu != null) {
            interfaceC1830bu.cancel(new LeftCompositionCancellationException());
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        InterfaceC1830bu interfaceC1830bu = this.job;
        if (interfaceC1830bu != null) {
            interfaceC1830bu.cancel(new LeftCompositionCancellationException());
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        InterfaceC1830bu interfaceC1830bu = this.job;
        if (interfaceC1830bu != null) {
            AbstractC3511nu.f(interfaceC1830bu, "Old job was still running!", null, 2, null);
        }
        this.job = O8.d(this.scope, null, null, this.task, 3, null);
    }
}
