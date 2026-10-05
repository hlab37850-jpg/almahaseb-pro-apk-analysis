package androidx.compose.runtime.snapshots;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class NestedReadonlySnapshot$readObserver$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $it;
    final /* synthetic */ InterfaceC3750qp $readObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedReadonlySnapshot$readObserver$1$1$1(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        super(1);
        this.$readObserver = interfaceC3750qp;
        this.$it = interfaceC3750qp2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m2679invoke(obj);
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2679invoke(Object obj) {
        AbstractC4492zt.h(obj, "state");
        this.$readObserver.invoke(obj);
        this.$it.invoke(obj);
    }
}
