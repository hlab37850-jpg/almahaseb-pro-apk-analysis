package androidx.paging;

import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3552oO;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4038uO;
import defpackage.LL;

/* JADX INFO: loaded from: classes2.dex */
public final class SimpleProducerScopeImpl<T> implements SimpleProducerScope<T>, InterfaceC2052dg, InterfaceC4038uO {
    private final /* synthetic */ InterfaceC2052dg $$delegate_0;
    private final InterfaceC4038uO channel;

    /* JADX INFO: renamed from: androidx.paging.SimpleProducerScopeImpl$awaitClose$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.SimpleProducerScopeImpl", f = "SimpleChannelFlow.kt", l = {100}, m = "awaitClose")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SimpleProducerScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SimpleProducerScopeImpl<T> simpleProducerScopeImpl, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = simpleProducerScopeImpl;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitClose(null, this);
        }
    }

    public SimpleProducerScopeImpl(InterfaceC2052dg interfaceC2052dg, InterfaceC4038uO interfaceC4038uO) {
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        AbstractC4492zt.h(interfaceC4038uO, "channel");
        this.channel = interfaceC4038uO;
        this.$$delegate_0 = interfaceC2052dg;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.SimpleProducerScope
    public Object awaitClose(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) throws Throwable {
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
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                LL.b(obj);
                InterfaceC0988Vf.b bVar = getCoroutineContext().get(InterfaceC1830bu.s);
                if (bVar == null) {
                    throw new IllegalStateException("Internal error, context should have a job.");
                }
                InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) bVar;
                anonymousClass1.L$0 = interfaceC3588op;
                anonymousClass1.L$1 = interfaceC1830bu;
                anonymousClass1.label = 1;
                C4374ya c4374ya = new C4374ya(AbstractC0352At.c(anonymousClass1), 1);
                c4374ya.A();
                interfaceC1830bu.C(new SimpleProducerScopeImpl$awaitClose$2$1(c4374ya));
                Object objX = c4374ya.x();
                if (objX == AbstractC0378Bt.d()) {
                    AbstractC3416mi.c(anonymousClass1);
                }
                if (objX == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC3588op = (InterfaceC3588op) anonymousClass1.L$0;
                LL.b(obj);
            }
            interfaceC3588op.invoke();
            return FW.a;
        } catch (Throwable th) {
            interfaceC3588op.invoke();
            throw th;
        }
    }

    @Override // androidx.paging.SimpleProducerScope, defpackage.InterfaceC4038uO
    public boolean close(Throwable th) {
        return this.channel.close(th);
    }

    @Override // androidx.paging.SimpleProducerScope
    public InterfaceC4038uO getChannel() {
        return this.channel;
    }

    @Override // androidx.paging.SimpleProducerScope, defpackage.InterfaceC2052dg
    public InterfaceC0988Vf getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.paging.SimpleProducerScope, defpackage.InterfaceC4038uO
    public InterfaceC3552oO getOnSend() {
        return this.channel.getOnSend();
    }

    @Override // androidx.paging.SimpleProducerScope, defpackage.InterfaceC4038uO
    public void invokeOnClose(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "handler");
        this.channel.invokeOnClose(interfaceC3750qp);
    }

    @Override // androidx.paging.SimpleProducerScope, defpackage.InterfaceC4038uO
    public boolean isClosedForSend() {
        return this.channel.isClosedForSend();
    }

    @Override // androidx.paging.SimpleProducerScope, defpackage.InterfaceC4038uO
    public boolean offer(T t) {
        return this.channel.offer(t);
    }

    @Override // androidx.paging.SimpleProducerScope, defpackage.InterfaceC4038uO
    public Object send(T t, InterfaceC0793Of interfaceC0793Of) {
        return this.channel.send(t, interfaceC0793Of);
    }

    @Override // androidx.paging.SimpleProducerScope, defpackage.InterfaceC4038uO
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo0trySendJP2dKIU(T t) {
        return this.channel.mo0trySendJP2dKIU(t);
    }
}
