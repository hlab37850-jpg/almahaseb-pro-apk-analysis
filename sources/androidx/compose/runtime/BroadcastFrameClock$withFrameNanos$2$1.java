package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BroadcastFrameClock$withFrameNanos$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ OJ $awaiter;
    final /* synthetic */ BroadcastFrameClock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastFrameClock$withFrameNanos$2$1(BroadcastFrameClock broadcastFrameClock, OJ oj) {
        super(1);
        this.this$0 = broadcastFrameClock;
        this.$awaiter = oj;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return FW.a;
    }

    public final void invoke(Throwable th) {
        BroadcastFrameClock.FrameAwaiter frameAwaiter;
        Object obj = this.this$0.lock;
        BroadcastFrameClock broadcastFrameClock = this.this$0;
        OJ oj = this.$awaiter;
        synchronized (obj) {
            try {
                List list = broadcastFrameClock.awaiters;
                Object obj2 = oj.a;
                if (obj2 == null) {
                    AbstractC4492zt.x("awaiter");
                    frameAwaiter = null;
                } else {
                    frameAwaiter = (BroadcastFrameClock.FrameAwaiter) obj2;
                }
                list.remove(frameAwaiter);
                FW fw = FW.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
