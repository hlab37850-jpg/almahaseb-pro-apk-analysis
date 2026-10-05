package androidx.compose.runtime;

import android.view.Choreographer;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2179fC;
import defpackage.AbstractC3416mi;
import defpackage.C0368Bj;
import defpackage.C4374ya;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;
import defpackage.M8;

/* JADX INFO: loaded from: classes.dex */
final class DefaultChoreographerFrameClock implements MonotonicFrameClock {
    public static final DefaultChoreographerFrameClock INSTANCE = new DefaultChoreographerFrameClock();
    private static final Choreographer choreographer = (Choreographer) M8.e(C0368Bj.c().G(), new DefaultChoreographerFrameClock$choreographer$1(null));

    private DefaultChoreographerFrameClock() {
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
    public <R> Object withFrameNanos(final InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        final C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: androidx.compose.runtime.DefaultChoreographerFrameClock$withFrameNanos$2$callback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                Object objA;
                InterfaceC4293xa interfaceC4293xa = c4374ya;
                DefaultChoreographerFrameClock defaultChoreographerFrameClock = DefaultChoreographerFrameClock.INSTANCE;
                InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
                try {
                    KL.a aVar = KL.a;
                    objA = KL.a(interfaceC3750qp2.invoke(Long.valueOf(j)));
                } catch (Throwable th) {
                    KL.a aVar2 = KL.a;
                    objA = KL.a(LL.a(th));
                }
                interfaceC4293xa.resumeWith(objA);
            }
        };
        choreographer.postFrameCallback(frameCallback);
        c4374ya.e(new DefaultChoreographerFrameClock$withFrameNanos$2$1(frameCallback));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }
}
