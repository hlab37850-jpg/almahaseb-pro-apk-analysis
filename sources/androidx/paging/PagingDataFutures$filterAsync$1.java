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
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.PagingDataFutures$filterAsync$1", f = "ListenableFuturePagingData.kt", l = {76}, m = "invokeSuspend")
public final class PagingDataFutures$filterAsync$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ Executor $executor;
    final /* synthetic */ AsyncFunction<T, Boolean> $predicate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.paging.PagingDataFutures$filterAsync$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PagingDataFutures$filterAsync$1$1", f = "ListenableFuturePagingData.kt", l = {77}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ T $it;
        final /* synthetic */ AsyncFunction<T, Boolean> $predicate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AsyncFunction<T, Boolean> asyncFunction, T t, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$predicate = asyncFunction;
            this.$it = t;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$predicate, this.$it, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ListenableFuture<Boolean> listenableFutureApply = this.$predicate.apply(this.$it);
                AbstractC4492zt.g(listenableFutureApply, "predicate.apply(it)");
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
    public PagingDataFutures$filterAsync$1(Executor executor, AsyncFunction<T, Boolean> asyncFunction, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$executor = executor;
        this.$predicate = asyncFunction;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        PagingDataFutures$filterAsync$1 pagingDataFutures$filterAsync$1 = new PagingDataFutures$filterAsync$1(this.$executor, this.$predicate, interfaceC0793Of);
        pagingDataFutures$filterAsync$1.L$0 = obj;
        return pagingDataFutures$filterAsync$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(T t, InterfaceC0793Of interfaceC0793Of) {
        return ((PagingDataFutures$filterAsync$1) create(t, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            Object obj2 = this.L$0;
            AbstractC1040Xf abstractC1040XfA = AbstractC1173Zl.a(this.$executor);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$predicate, obj2, null);
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
        AbstractC4492zt.g(obj, "predicate: AsyncFunction…e.apply(it).await()\n    }");
        return obj;
    }
}
