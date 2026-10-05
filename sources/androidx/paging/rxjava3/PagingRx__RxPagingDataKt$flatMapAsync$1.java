package androidx.paging.rxjava3;

import defpackage.AM;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.IQ;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.rxjava3.PagingRx__RxPagingDataKt$flatMapAsync$1", f = "RxPagingData.kt", l = {51}, m = "invokeSuspend")
public final class PagingRx__RxPagingDataKt$flatMapAsync$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC3750qp $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingRx__RxPagingDataKt$flatMapAsync$1(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$transform = interfaceC3750qp;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        PagingRx__RxPagingDataKt$flatMapAsync$1 pagingRx__RxPagingDataKt$flatMapAsync$1 = new PagingRx__RxPagingDataKt$flatMapAsync$1(this.$transform, interfaceC0793Of);
        pagingRx__RxPagingDataKt$flatMapAsync$1.L$0 = obj;
        return pagingRx__RxPagingDataKt$flatMapAsync$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(T t, InterfaceC0793Of interfaceC0793Of) {
        return ((PagingRx__RxPagingDataKt$flatMapAsync$1) create(t, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            IQ iq = (IQ) this.$transform.invoke(this.L$0);
            this.label = 1;
            obj = AM.a(iq, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        AbstractC4492zt.g(obj, "transform(it).await()");
        return obj;
    }
}
