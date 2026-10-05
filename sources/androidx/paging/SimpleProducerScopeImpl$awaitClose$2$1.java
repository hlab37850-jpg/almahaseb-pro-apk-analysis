package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;

/* JADX INFO: loaded from: classes2.dex */
public final class SimpleProducerScopeImpl$awaitClose$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC4293xa $cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleProducerScopeImpl$awaitClose$2$1(InterfaceC4293xa interfaceC4293xa) {
        super(1);
        this.$cont = interfaceC4293xa;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return FW.a;
    }

    public final void invoke(Throwable th) {
        InterfaceC4293xa interfaceC4293xa = this.$cont;
        KL.a aVar = KL.a;
        interfaceC4293xa.resumeWith(KL.a(FW.a));
    }
}
