package androidx.paging.rxjava3;

import androidx.paging.ExperimentalPagingApi;
import androidx.paging.LoadType;
import androidx.paging.PagingState;
import androidx.paging.RemoteMediator;
import defpackage.AM;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC4492zt;
import defpackage.BQ;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalPagingApi
public abstract class RxRemoteMediator<Key, Value> extends RemoteMediator<Key, Value> {

    /* JADX INFO: renamed from: androidx.paging.rxjava3.RxRemoteMediator$initialize$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.rxjava3.RxRemoteMediator", f = "RxRemoteMediator.kt", l = {96}, m = "initialize")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RxRemoteMediator<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RxRemoteMediator<Key, Value> rxRemoteMediator, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = rxRemoteMediator;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.initialize(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.rxjava3.RxRemoteMediator$load$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.rxjava3.RxRemoteMediator", f = "RxRemoteMediator.kt", l = {92}, m = "load")
    public static final class C17331 extends AbstractC0819Pf {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RxRemoteMediator<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17331(RxRemoteMediator<Key, Value> rxRemoteMediator, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = rxRemoteMediator;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.load(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.RemoteMediator
    public final Object initialize(InterfaceC0793Of interfaceC0793Of) throws Throwable {
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
            BQ bqInitializeSingle = initializeSingle();
            anonymousClass1.label = 1;
            objA = AM.a(bqInitializeSingle, anonymousClass1);
            if (objA == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(objA);
        }
        AbstractC4492zt.g(objA, "initializeSingle().await()");
        return objA;
    }

    public BQ initializeSingle() {
        BQ bqC = BQ.c(RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH);
        AbstractC4492zt.g(bqC, "just(LAUNCH_INITIAL_REFRESH)");
        return bqC;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.RemoteMediator
    public final Object load(LoadType loadType, PagingState<Key, Value> pagingState, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C17331 c17331;
        if (interfaceC0793Of instanceof C17331) {
            c17331 = (C17331) interfaceC0793Of;
            int i = c17331.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17331.label = i - Integer.MIN_VALUE;
            } else {
                c17331 = new C17331(this, interfaceC0793Of);
            }
        } else {
            c17331 = new C17331(this, interfaceC0793Of);
        }
        Object objA = c17331.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c17331.label;
        if (i2 == 0) {
            LL.b(objA);
            BQ bqLoadSingle = loadSingle(loadType, pagingState);
            c17331.label = 1;
            objA = AM.a(bqLoadSingle, c17331);
            if (objA == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(objA);
        }
        AbstractC4492zt.g(objA, "loadSingle(loadType, state).await()");
        return objA;
    }

    public abstract BQ loadSingle(LoadType loadType, PagingState<Key, Value> pagingState);
}
