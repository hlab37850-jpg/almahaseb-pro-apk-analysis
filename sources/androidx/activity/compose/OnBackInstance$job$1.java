package androidx.activity.compose;

import androidx.activity.OnBackPressedCallback;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.KJ;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.activity.compose.OnBackInstance$job$1", f = "PredictiveBackHandler.kt", l = {121}, m = "invokeSuspend")
public final class OnBackInstance$job$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ OnBackPressedCallback $callback;
    final /* synthetic */ InterfaceC0526Fp $onBack;
    Object L$0;
    int label;
    final /* synthetic */ OnBackInstance this$0;

    /* JADX INFO: renamed from: androidx.activity.compose.OnBackInstance$job$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.activity.compose.OnBackInstance$job$1$1", f = "PredictiveBackHandler.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ KJ $completed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(KJ kj, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$completed = kj;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC0995Vm interfaceC0995Vm, Throwable th, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$completed, interfaceC0793Of).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            this.$completed.a = true;
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnBackInstance$job$1(OnBackPressedCallback onBackPressedCallback, InterfaceC0526Fp interfaceC0526Fp, OnBackInstance onBackInstance, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$callback = onBackPressedCallback;
        this.$onBack = interfaceC0526Fp;
        this.this$0 = onBackInstance;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new OnBackInstance$job$1(this.$callback, this.$onBack, this.this$0, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((OnBackInstance$job$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        KJ kj;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            if (this.$callback.isEnabled()) {
                KJ kj2 = new KJ();
                InterfaceC0526Fp interfaceC0526Fp = this.$onBack;
                InterfaceC0939Tm interfaceC0939TmZ = AbstractC1047Xm.z(AbstractC1047Xm.i(this.this$0.getChannel()), new AnonymousClass1(kj2, null));
                this.L$0 = kj2;
                this.label = 1;
                if (interfaceC0526Fp.mo13invoke(interfaceC0939TmZ, this) == objD) {
                    return objD;
                }
                kj = kj2;
            }
            return FW.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kj = (KJ) this.L$0;
        LL.b(obj);
        if (!kj.a) {
            throw new IllegalStateException("You must collect the progress flow");
        }
        return FW.a;
    }
}
