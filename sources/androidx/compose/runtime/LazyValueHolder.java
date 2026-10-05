package androidx.compose.runtime;

import defpackage.AbstractC3756qv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3430mv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyValueHolder<T> implements State<T> {
    private final InterfaceC3430mv current$delegate;

    public LazyValueHolder(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "valueProducer");
        this.current$delegate = AbstractC3756qv.a(interfaceC3588op);
    }

    private final T getCurrent() {
        return (T) this.current$delegate.getValue();
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        return getCurrent();
    }
}
