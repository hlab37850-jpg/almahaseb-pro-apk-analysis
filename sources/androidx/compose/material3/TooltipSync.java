package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.Stable;
import defpackage.AD;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1043Xi;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
final class TooltipSync {
    public static final TooltipSync INSTANCE = new TooltipSync();
    private static final MutatorMutex mutatorMutex = new MutatorMutex();
    private static TooltipState mutexOwner;

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipSync$dismissCurrentTooltip$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.TooltipSync$dismissCurrentTooltip$2", f = "Tooltip.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC3750qp {
        int label;

        public AnonymousClass2(InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipSync$show$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.TooltipSync$show$2", f = "Tooltip.kt", l = {623}, m = "invokeSuspend")
    public static final class C16062 extends XS implements InterfaceC3750qp {
        final /* synthetic */ TooltipState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16062(TooltipState tooltipState, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.$state = tooltipState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new C16062(this.$state, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((C16062) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ((PlainTooltipState) this.$state).setVisible$material3_release(true);
                this.label = 1;
                if (AbstractC1043Xi.a(TooltipKt.TooltipDuration, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipSync$show$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ TooltipState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(TooltipState tooltipState) {
            super(0);
            this.$state = tooltipState;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m2052invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2052invoke() {
            ((PlainTooltipState) this.$state).setVisible$material3_release(false);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipSync$show$4, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.TooltipSync$show$4", f = "Tooltip.kt", l = {771, 642}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends XS implements InterfaceC3750qp {
        final /* synthetic */ boolean $persistent;
        final /* synthetic */ TooltipState $state;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(boolean z, TooltipState tooltipState, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.$persistent = z;
            this.$state = tooltipState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass4(this.$persistent, this.$state, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass4) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            } else {
                LL.b(obj);
                if (this.$persistent) {
                    TooltipState tooltipState = this.$state;
                    this.L$0 = tooltipState;
                    this.label = 1;
                    C4374ya c4374ya = new C4374ya(AbstractC0352At.c(this), 1);
                    c4374ya.A();
                    ((RichTooltipState) tooltipState).setVisible$material3_release(true);
                    Object objX = c4374ya.x();
                    if (objX == AbstractC0378Bt.d()) {
                        AbstractC3416mi.c(this);
                    }
                    if (objX == objD) {
                        return objD;
                    }
                } else {
                    ((RichTooltipState) this.$state).setVisible$material3_release(true);
                    this.label = 2;
                    if (AbstractC1043Xi.a(TooltipKt.TooltipDuration, this) == objD) {
                        return objD;
                    }
                }
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipSync$show$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ TooltipState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(TooltipState tooltipState) {
            super(0);
            this.$state = tooltipState;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m2053invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2053invoke() {
            ((RichTooltipState) this.$state).setVisible$material3_release(false);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipSync$show$6, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.TooltipSync$show$6", f = "Tooltip.kt", l = {655}, m = "invokeSuspend")
    public static final class AnonymousClass6 extends XS implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3588op $cleanUp;
        final /* synthetic */ InterfaceC3750qp $runBlock;
        final /* synthetic */ TooltipState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(TooltipState tooltipState, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.$state = tooltipState;
            this.$runBlock = interfaceC3750qp;
            this.$cleanUp = interfaceC3588op;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass6(this.$state, this.$runBlock, this.$cleanUp, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass6) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                if (i == 0) {
                    LL.b(obj);
                    TooltipSync.INSTANCE.setMutexOwner(this.$state);
                    InterfaceC3750qp interfaceC3750qp = this.$runBlock;
                    this.label = 1;
                    if (interfaceC3750qp.invoke(this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                TooltipSync.INSTANCE.setMutexOwner(null);
                this.$cleanUp.invoke();
                return FW.a;
            } catch (Throwable th) {
                TooltipSync.INSTANCE.setMutexOwner(null);
                this.$cleanUp.invoke();
                throw th;
            }
        }
    }

    private TooltipSync() {
    }

    public final Object dismissCurrentTooltip(TooltipState tooltipState, InterfaceC0793Of interfaceC0793Of) {
        if (!AbstractC4492zt.d(tooltipState, mutexOwner)) {
            return FW.a;
        }
        Object objMutate = mutatorMutex.mutate(MutatePriority.UserInput, new AnonymousClass2(null), interfaceC0793Of);
        return objMutate == AbstractC0378Bt.d() ? objMutate : FW.a;
    }

    public final MutatorMutex getMutatorMutex() {
        return mutatorMutex;
    }

    public final TooltipState getMutexOwner() {
        return mutexOwner;
    }

    public final void setMutexOwner(TooltipState tooltipState) {
        mutexOwner = tooltipState;
    }

    public final Object show(TooltipState tooltipState, boolean z, InterfaceC0793Of interfaceC0793Of) {
        InterfaceC3588op anonymousClass5;
        InterfaceC3750qp c16062;
        if (tooltipState instanceof PlainTooltipState) {
            c16062 = new C16062(tooltipState, null);
            anonymousClass5 = new AnonymousClass3(tooltipState);
        } else {
            if (!(tooltipState instanceof RichTooltipState)) {
                throw new AD();
            }
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(z, tooltipState, null);
            anonymousClass5 = new AnonymousClass5(tooltipState);
            c16062 = anonymousClass4;
        }
        Object objMutate = mutatorMutex.mutate(MutatePriority.Default, new AnonymousClass6(tooltipState, c16062, anonymousClass5, null), interfaceC0793Of);
        return objMutate == AbstractC0378Bt.d() ? objMutate : FW.a;
    }
}
