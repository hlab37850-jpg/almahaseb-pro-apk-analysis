package androidx.compose.ui.platform;

import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2179fC;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0854Qf;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AndroidUiFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private final Choreographer choreographer;
    private final AndroidUiDispatcher dispatcher;

    public AndroidUiFrameClock(Choreographer choreographer, AndroidUiDispatcher androidUiDispatcher) {
        AbstractC4492zt.h(choreographer, "choreographer");
        this.choreographer = choreographer;
        this.dispatcher = androidUiDispatcher;
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf
    public <R> R fold(R r, InterfaceC0526Fp interfaceC0526Fp) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r, interfaceC0526Fp);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    public <E extends InterfaceC0988Vf.b> E get(InterfaceC0988Vf.c cVar) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, cVar);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
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
        AndroidUiDispatcher androidUiDispatcher = this.dispatcher;
        if (androidUiDispatcher == null) {
            InterfaceC0988Vf.b bVar = interfaceC0793Of.getContext().get(InterfaceC0854Qf.o);
            androidUiDispatcher = bVar instanceof AndroidUiDispatcher ? (AndroidUiDispatcher) bVar : null;
        }
        final C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                Object objA;
                InterfaceC4293xa interfaceC4293xa = c4374ya;
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
        if (androidUiDispatcher == null || !AbstractC4492zt.d(androidUiDispatcher.getChoreographer(), getChoreographer())) {
            getChoreographer().postFrameCallback(frameCallback);
            c4374ya.e(new AndroidUiFrameClock$withFrameNanos$2$2(this, frameCallback));
        } else {
            androidUiDispatcher.postFrameCallback$ui_release(frameCallback);
            c4374ya.e(new AndroidUiFrameClock$withFrameNanos$2$1(androidUiDispatcher, frameCallback));
        }
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AndroidUiFrameClock(Choreographer choreographer) {
        this(choreographer, null);
        AbstractC4492zt.h(choreographer, "choreographer");
    }
}
