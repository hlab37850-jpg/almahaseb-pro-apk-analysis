package androidx.compose.runtime;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1043Xi;
import defpackage.AbstractC2179fC;
import defpackage.C0368Bj;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
final class SdkStubsFallbackFrameClock implements MonotonicFrameClock {
    private static final long DefaultFrameDelay = 16;
    public static final SdkStubsFallbackFrameClock INSTANCE = new SdkStubsFallbackFrameClock();

    /* JADX INFO: renamed from: androidx.compose.runtime.SdkStubsFallbackFrameClock$withFrameNanos$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.SdkStubsFallbackFrameClock$withFrameNanos$2", f = "ActualAndroid.android.kt", l = {52}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3750qp $onFrame;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$onFrame = interfaceC3750qp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.$onFrame, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                this.label = 1;
                if (AbstractC1043Xi.a(16L, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return this.$onFrame.invoke(E8.d(System.nanoTime()));
        }
    }

    private SdkStubsFallbackFrameClock() {
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf
    public <R> R fold(R r, InterfaceC0526Fp interfaceC0526Fp) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r, interfaceC0526Fp);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    public <E extends InterfaceC0988Vf.b> E get(InterfaceC0988Vf.c cVar) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, cVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf.b
    public /* synthetic */ InterfaceC0988Vf.c getKey() {
        return AbstractC2179fC.a(this);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, cVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        return MonotonicFrameClock.DefaultImpls.plus(this, interfaceC0988Vf);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return M8.g(C0368Bj.c(), new AnonymousClass2(interfaceC3750qp, null), interfaceC0793Of);
    }
}
