package androidx.paging.rxjava3;

import defpackage.AM;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC3574of;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.rxjava3.PagingRx__RxPagingDataKt$insertSeparatorsAsync$1", f = "RxPagingData.kt", l = {77}, m = "invokeSuspend")
public final class PagingRx__RxPagingDataKt$insertSeparatorsAsync$1 extends XS implements InterfaceC0552Gp {
    final /* synthetic */ InterfaceC0526Fp $generator;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingRx__RxPagingDataKt$insertSeparatorsAsync$1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        super(3, interfaceC0793Of);
        this.$generator = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC0552Gp
    public final Object invoke(T t, T t2, InterfaceC0793Of interfaceC0793Of) {
        PagingRx__RxPagingDataKt$insertSeparatorsAsync$1 pagingRx__RxPagingDataKt$insertSeparatorsAsync$1 = new PagingRx__RxPagingDataKt$insertSeparatorsAsync$1(this.$generator, interfaceC0793Of);
        pagingRx__RxPagingDataKt$insertSeparatorsAsync$1.L$0 = t;
        pagingRx__RxPagingDataKt$insertSeparatorsAsync$1.L$1 = t2;
        return pagingRx__RxPagingDataKt$insertSeparatorsAsync$1.invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            AbstractC3574of.a(this.$generator.mo13invoke(this.L$0, this.L$1));
            this.L$0 = null;
            this.label = 1;
            obj = AM.b(null, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        return obj;
    }
}
