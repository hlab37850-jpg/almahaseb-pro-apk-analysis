package androidx.lifecycle;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0348Ap;
import defpackage.InterfaceC0803Op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 implements Observer, InterfaceC0803Op {
    private final /* synthetic */ InterfaceC3750qp function;

    public CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        this.function = interfaceC3750qp;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof InterfaceC0803Op)) {
            return AbstractC4492zt.d(getFunctionDelegate(), ((InterfaceC0803Op) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // defpackage.InterfaceC0803Op
    public final InterfaceC0348Ap getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
