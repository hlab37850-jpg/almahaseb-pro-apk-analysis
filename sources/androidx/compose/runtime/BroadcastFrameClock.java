package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2179fC;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.KL;
import defpackage.LL;
import defpackage.OJ;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private List<FrameAwaiter<?>> awaiters;
    private Throwable failureCause;
    private final Object lock;
    private final InterfaceC3588op onNewAwaiters;
    private List<FrameAwaiter<?>> spareList;

    public static final class FrameAwaiter<R> {
        private final InterfaceC0793Of continuation;
        private final InterfaceC3750qp onFrame;

        public FrameAwaiter(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            AbstractC4492zt.h(interfaceC3750qp, "onFrame");
            AbstractC4492zt.h(interfaceC0793Of, "continuation");
            this.onFrame = interfaceC3750qp;
            this.continuation = interfaceC0793Of;
        }

        public final InterfaceC0793Of getContinuation() {
            return this.continuation;
        }

        public final InterfaceC3750qp getOnFrame() {
            return this.onFrame;
        }

        public final void resume(long j) {
            Object objA;
            InterfaceC0793Of interfaceC0793Of = this.continuation;
            try {
                KL.a aVar = KL.a;
                objA = KL.a(this.onFrame.invoke(Long.valueOf(j)));
            } catch (Throwable th) {
                KL.a aVar2 = KL.a;
                objA = KL.a(LL.a(th));
            }
            interfaceC0793Of.resumeWith(objA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastFrameClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void cancel$default(BroadcastFrameClock broadcastFrameClock, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = new CancellationException("clock cancelled");
        }
        broadcastFrameClock.cancel(cancellationException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(Throwable th) {
        synchronized (this.lock) {
            try {
                if (this.failureCause != null) {
                    return;
                }
                this.failureCause = th;
                List<FrameAwaiter<?>> list = this.awaiters;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    InterfaceC0793Of continuation = list.get(i).getContinuation();
                    KL.a aVar = KL.a;
                    continuation.resumeWith(KL.a(LL.a(th)));
                }
                this.awaiters.clear();
                FW fw = FW.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void cancel(CancellationException cancellationException) {
        AbstractC4492zt.h(cancellationException, "cancellationException");
        fail(cancellationException);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf
    public <R> R fold(R r, InterfaceC0526Fp interfaceC0526Fp) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r, interfaceC0526Fp);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    public <E extends InterfaceC0988Vf.b> E get(InterfaceC0988Vf.c cVar) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, cVar);
    }

    public final boolean getHasAwaiters() {
        boolean z;
        synchronized (this.lock) {
            z = !this.awaiters.isEmpty();
        }
        return z;
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

    public final void sendFrame(long j) {
        synchronized (this.lock) {
            try {
                List<FrameAwaiter<?>> list = this.awaiters;
                this.awaiters = this.spareList;
                this.spareList = list;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).resume(j);
                }
                list.clear();
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        FrameAwaiter frameAwaiter;
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        OJ oj = new OJ();
        synchronized (this.lock) {
            Throwable th = this.failureCause;
            if (th != null) {
                KL.a aVar = KL.a;
                c4374ya.resumeWith(KL.a(LL.a(th)));
            } else {
                oj.a = new FrameAwaiter(interfaceC3750qp, c4374ya);
                boolean zIsEmpty = this.awaiters.isEmpty();
                List list = this.awaiters;
                Object obj = oj.a;
                if (obj == null) {
                    AbstractC4492zt.x("awaiter");
                    frameAwaiter = null;
                } else {
                    frameAwaiter = (FrameAwaiter) obj;
                }
                list.add(frameAwaiter);
                c4374ya.e(new BroadcastFrameClock$withFrameNanos$2$1(this, oj));
                if (zIsEmpty && this.onNewAwaiters != null) {
                    try {
                        this.onNewAwaiters.invoke();
                    } catch (Throwable th2) {
                        fail(th2);
                    }
                }
            }
        }
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    public BroadcastFrameClock(InterfaceC3588op interfaceC3588op) {
        this.onNewAwaiters = interfaceC3588op;
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
    }

    public /* synthetic */ BroadcastFrameClock(InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? null : interfaceC3588op);
    }
}
