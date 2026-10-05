package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2179fC;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class PausableMonotonicFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private final MonotonicFrameClock frameClock;
    private final Latch latch;

    /* JADX INFO: renamed from: androidx.compose.runtime.PausableMonotonicFrameClock$withFrameNanos$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.PausableMonotonicFrameClock", f = "PausableMonotonicFrameClock.kt", l = {62, 63}, m = "withFrameNanos")
    public static final class AnonymousClass1<R> extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PausableMonotonicFrameClock.this.withFrameNanos(null, this);
        }
    }

    public PausableMonotonicFrameClock(MonotonicFrameClock monotonicFrameClock) {
        AbstractC4492zt.h(monotonicFrameClock, "frameClock");
        this.frameClock = monotonicFrameClock;
        this.latch = new Latch();
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

    public final boolean isPaused() {
        return !this.latch.isOpen();
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, cVar);
    }

    public final void pause() {
        this.latch.closeLatch();
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        return MonotonicFrameClock.DefaultImpls.plus(this, interfaceC0988Vf);
    }

    public final void resume() {
        this.latch.openLatch();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        PausableMonotonicFrameClock pausableMonotonicFrameClock;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        Object objWithFrameNanos = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                interfaceC3750qp = (InterfaceC3750qp) anonymousClass1.L$1;
                pausableMonotonicFrameClock = (PausableMonotonicFrameClock) anonymousClass1.L$0;
                LL.b(objWithFrameNanos);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(objWithFrameNanos);
            }
        }
        LL.b(objWithFrameNanos);
        Latch latch = this.latch;
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = interfaceC3750qp;
        anonymousClass1.label = 1;
        if (latch.await(anonymousClass1) == objD) {
            return objD;
        }
        pausableMonotonicFrameClock = this;
        MonotonicFrameClock monotonicFrameClock = pausableMonotonicFrameClock.frameClock;
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        objWithFrameNanos = monotonicFrameClock.withFrameNanos(interfaceC3750qp, anonymousClass1);
        return objWithFrameNanos == objD ? objD : objWithFrameNanos;
    }
}
