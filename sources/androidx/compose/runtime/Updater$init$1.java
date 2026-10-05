package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class Updater$init$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC3750qp $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Updater$init$1(InterfaceC3750qp interfaceC3750qp) {
        super(2);
        this.$block = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke(obj, (FW) obj2);
        return FW.a;
    }

    public final void invoke(T t, FW fw) {
        AbstractC4492zt.h(fw, "it");
        this.$block.invoke(t);
    }
}
