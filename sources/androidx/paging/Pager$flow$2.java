package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.Pager$flow$2", f = "Pager.kt", l = {}, m = "invokeSuspend")
public final class Pager$flow$2 extends XS implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3588op $pagingSourceFactory;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pager$flow$2(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        super(1, interfaceC0793Of);
        this.$pagingSourceFactory = interfaceC3588op;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
        return new Pager$flow$2(this.$pagingSourceFactory, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
        return ((Pager$flow$2) create(interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0378Bt.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LL.b(obj);
        return this.$pagingSourceFactory.invoke();
    }
}
