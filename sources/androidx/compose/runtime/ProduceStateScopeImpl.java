package androidx.compose.runtime;

import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.C4374ya;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
final class ProduceStateScopeImpl<T> implements ProduceStateScope<T>, MutableState<T> {
    private final /* synthetic */ MutableState<T> $$delegate_0;
    private final InterfaceC0988Vf coroutineContext;

    /* JADX INFO: renamed from: androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.ProduceStateScopeImpl", f = "ProduceState.kt", l = {224}, m = "awaitDispose")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProduceStateScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ProduceStateScopeImpl<T> produceStateScopeImpl, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = produceStateScopeImpl;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitDispose(null, this);
        }
    }

    public ProduceStateScopeImpl(MutableState<T> mutableState, InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(mutableState, "state");
        AbstractC4492zt.h(interfaceC0988Vf, "coroutineContext");
        this.coroutineContext = interfaceC0988Vf;
        this.$$delegate_0 = mutableState;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.runtime.ProduceStateScope
    public Object awaitDispose(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) throws Throwable {
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
                anonymousClass1.L$0 = interfaceC3588op;
                anonymousClass1.label = 1;
                C4374ya c4374ya = new C4374ya(AbstractC0352At.c(anonymousClass1), 1);
                c4374ya.A();
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
            throw new C1182Zu();
        } catch (Throwable th) {
            interfaceC3588op.invoke();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.MutableState
    public T component1() {
        return this.$$delegate_0.component1();
    }

    @Override // androidx.compose.runtime.MutableState
    public InterfaceC3750qp component2() {
        return this.$$delegate_0.component2();
    }

    @Override // androidx.compose.runtime.ProduceStateScope, defpackage.InterfaceC2052dg
    public InterfaceC0988Vf getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.runtime.MutableState, androidx.compose.runtime.State
    public T getValue() {
        return this.$$delegate_0.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public void setValue(T t) {
        this.$$delegate_0.setValue(t);
    }
}
