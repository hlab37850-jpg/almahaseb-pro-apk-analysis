package androidx.paging;

import defpackage.C0916Sp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class Pager$flow$1 extends C0916Sp implements InterfaceC3750qp {
    public Pager$flow$1(Object obj) {
        super(1, obj, SuspendingPagingSourceFactory.class, "create", "create(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
        return ((SuspendingPagingSourceFactory) this.receiver).create(interfaceC0793Of);
    }
}
