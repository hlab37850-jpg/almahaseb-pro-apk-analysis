package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class CachedPageEventFlow$job$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ CachedPageEventFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedPageEventFlow$job$2$1(CachedPageEventFlow<T> cachedPageEventFlow) {
        super(1);
        this.this$0 = cachedPageEventFlow;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return FW.a;
    }

    public final void invoke(Throwable th) {
        ((CachedPageEventFlow) this.this$0).mutableSharedSrc.f(null);
    }
}
