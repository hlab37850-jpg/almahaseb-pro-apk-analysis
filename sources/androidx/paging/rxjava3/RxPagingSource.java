package androidx.paging.rxjava3;

import androidx.paging.PagingSource;
import defpackage.AM;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC4492zt;
import defpackage.BQ;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RxPagingSource<Key, Value> extends PagingSource<Key, Value> {

    /* JADX INFO: renamed from: androidx.paging.rxjava3.RxPagingSource$load$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.rxjava3.RxPagingSource", f = "RxPagingSource.kt", l = {37}, m = "load")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RxPagingSource<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RxPagingSource<Key, Value> rxPagingSource, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = rxPagingSource;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.load(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.PagingSource
    public final Object load(PagingSource.LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, interfaceC0793Of);
        }
        Object objA = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(objA);
            BQ bqLoadSingle = loadSingle(loadParams);
            anonymousClass1.label = 1;
            objA = AM.a(bqLoadSingle, anonymousClass1);
            if (objA == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(objA);
        }
        AbstractC4492zt.g(objA, "loadSingle(params).await()");
        return objA;
    }

    public abstract BQ loadSingle(PagingSource.LoadParams<Key> loadParams);
}
