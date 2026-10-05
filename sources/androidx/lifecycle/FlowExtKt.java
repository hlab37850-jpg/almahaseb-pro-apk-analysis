package androidx.lifecycle;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC2103eI;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4038uO;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowExtKt {

    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {91}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ InterfaceC0939Tm $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {92}, m = "invokeSuspend")
        public static final class C01421 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC2103eI $$this$callbackFlow;
            final /* synthetic */ InterfaceC0939Tm $this_flowWithLifecycle;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01421(InterfaceC0939Tm interfaceC0939Tm, InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$this_flowWithLifecycle = interfaceC0939Tm;
                this.$$this$callbackFlow = interfaceC2103eI;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C01421(this.$this_flowWithLifecycle, this.$$this$callbackFlow, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C01421) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    InterfaceC0939Tm interfaceC0939Tm = this.$this_flowWithLifecycle;
                    final InterfaceC2103eI interfaceC2103eI = this.$$this$callbackFlow;
                    InterfaceC0995Vm interfaceC0995Vm = new InterfaceC0995Vm() { // from class: androidx.lifecycle.FlowExtKt.flowWithLifecycle.1.1.1
                        @Override // defpackage.InterfaceC0995Vm
                        public final Object emit(T t, InterfaceC0793Of interfaceC0793Of) {
                            Object objSend = interfaceC2103eI.send(t, interfaceC0793Of);
                            return objSend == AbstractC0378Bt.d() ? objSend : FW.a;
                        }
                    };
                    this.label = 1;
                    if (interfaceC0939Tm.collect(interfaceC0995Vm, this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, InterfaceC0939Tm interfaceC0939Tm, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$this_flowWithLifecycle = interfaceC0939Tm;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2103eI, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC2103eI interfaceC2103eI;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2103eI interfaceC2103eI2 = (InterfaceC2103eI) this.L$0;
                Lifecycle lifecycle = this.$lifecycle;
                Lifecycle.State state = this.$minActiveState;
                C01421 c01421 = new C01421(this.$this_flowWithLifecycle, interfaceC2103eI2, null);
                this.L$0 = interfaceC2103eI2;
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, c01421, this) == objD) {
                    return objD;
                }
                interfaceC2103eI = interfaceC2103eI2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC2103eI = (InterfaceC2103eI) this.L$0;
                LL.b(obj);
            }
            InterfaceC4038uO.a.a(interfaceC2103eI, null, 1, null);
            return FW.a;
        }
    }

    public static final <T> InterfaceC0939Tm flowWithLifecycle(InterfaceC0939Tm interfaceC0939Tm, Lifecycle lifecycle, Lifecycle.State state) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(lifecycle, "lifecycle");
        AbstractC4492zt.h(state, "minActiveState");
        return AbstractC1047Xm.e(new AnonymousClass1(lifecycle, state, interfaceC0939Tm, null));
    }

    public static /* synthetic */ InterfaceC0939Tm flowWithLifecycle$default(InterfaceC0939Tm interfaceC0939Tm, Lifecycle lifecycle, Lifecycle.State state, int i, Object obj) {
        if ((i & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(interfaceC0939Tm, lifecycle, state);
    }
}
