package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;

/* JADX INFO: loaded from: classes.dex */
public final class Latch$await$2$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC4293xa $co;
    final /* synthetic */ Latch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Latch$await$2$2(Latch latch, InterfaceC4293xa interfaceC4293xa) {
        super(1);
        this.this$0 = latch;
        this.$co = interfaceC4293xa;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return FW.a;
    }

    public final void invoke(Throwable th) {
        Object obj = this.this$0.lock;
        Latch latch = this.this$0;
        InterfaceC4293xa interfaceC4293xa = this.$co;
        synchronized (obj) {
            latch.awaiters.remove(interfaceC4293xa);
            FW fw = FW.a;
        }
    }
}
