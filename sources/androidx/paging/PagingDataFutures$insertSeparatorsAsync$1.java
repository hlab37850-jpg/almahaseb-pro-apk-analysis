package androidx.paging;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC1173Zl;
import defpackage.AbstractC1183Zv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.PagingDataFutures$insertSeparatorsAsync$1", f = "ListenableFuturePagingData.kt", l = {101}, m = "invokeSuspend")
public final class PagingDataFutures$insertSeparatorsAsync$1 extends XS implements InterfaceC0552Gp {
    final /* synthetic */ Executor $executor;
    final /* synthetic */ AsyncFunction<AdjacentItems<T>, R> $generator;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: renamed from: androidx.paging.PagingDataFutures$insertSeparatorsAsync$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PagingDataFutures$insertSeparatorsAsync$1$1", f = "ListenableFuturePagingData.kt", l = {102}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ T $after;
        final /* synthetic */ T $before;
        final /* synthetic */ AsyncFunction<AdjacentItems<T>, R> $generator;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AsyncFunction<AdjacentItems<T>, R> asyncFunction, T t, T t2, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$generator = asyncFunction;
            this.$before = t;
            this.$after = t2;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$generator, this.$before, this.$after, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ListenableFuture listenableFutureApply = this.$generator.apply((AdjacentItems<T>) new AdjacentItems(this.$before, this.$after));
                AbstractC4492zt.g(listenableFutureApply, "generator.apply(AdjacentItems(before, after))");
                this.label = 1;
                obj = AbstractC1183Zv.b(listenableFutureApply, this);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingDataFutures$insertSeparatorsAsync$1(Executor executor, AsyncFunction<AdjacentItems<T>, R> asyncFunction, InterfaceC0793Of interfaceC0793Of) {
        super(3, interfaceC0793Of);
        this.$executor = executor;
        this.$generator = asyncFunction;
    }

    @Override // defpackage.InterfaceC0552Gp
    public final Object invoke(T t, T t2, InterfaceC0793Of interfaceC0793Of) {
        PagingDataFutures$insertSeparatorsAsync$1 pagingDataFutures$insertSeparatorsAsync$1 = new PagingDataFutures$insertSeparatorsAsync$1(this.$executor, this.$generator, interfaceC0793Of);
        pagingDataFutures$insertSeparatorsAsync$1.L$0 = t;
        pagingDataFutures$insertSeparatorsAsync$1.L$1 = t2;
        return pagingDataFutures$insertSeparatorsAsync$1.invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            Object obj2 = this.L$0;
            Object obj3 = this.L$1;
            AbstractC1040Xf abstractC1040XfA = AbstractC1173Zl.a(this.$executor);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$generator, obj2, obj3, null);
            this.L$0 = null;
            this.label = 1;
            obj = M8.g(abstractC1040XfA, anonymousClass1, this);
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
