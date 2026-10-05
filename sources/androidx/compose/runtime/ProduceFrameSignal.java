package androidx.compose.runtime;

import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.KL;

/* JADX INFO: loaded from: classes.dex */
final class ProduceFrameSignal {
    private Object pendingFrameContinuation;

    public final Object awaitFrameRequest(Object obj, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya;
        synchronized (obj) {
            if (this.pendingFrameContinuation == RecomposerKt.ProduceAnotherFrame) {
                this.pendingFrameContinuation = RecomposerKt.FramePending;
                return FW.a;
            }
            FW fw = FW.a;
            C4374ya c4374ya2 = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
            c4374ya2.A();
            synchronized (obj) {
                try {
                    if (this.pendingFrameContinuation == RecomposerKt.ProduceAnotherFrame) {
                        this.pendingFrameContinuation = RecomposerKt.FramePending;
                        c4374ya = c4374ya2;
                    } else {
                        this.pendingFrameContinuation = c4374ya2;
                        c4374ya = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (c4374ya != null) {
                KL.a aVar = KL.a;
                c4374ya.resumeWith(KL.a(FW.a));
            }
            Object objX = c4374ya2.x();
            if (objX == AbstractC0378Bt.d()) {
                AbstractC3416mi.c(interfaceC0793Of);
            }
            return objX == AbstractC0378Bt.d() ? objX : FW.a;
        }
    }

    public final InterfaceC0793Of requestFrameLocked() {
        Object obj = this.pendingFrameContinuation;
        if (obj instanceof InterfaceC0793Of) {
            this.pendingFrameContinuation = RecomposerKt.FramePending;
            return (InterfaceC0793Of) obj;
        }
        if (!(AbstractC4492zt.d(obj, RecomposerKt.ProduceAnotherFrame) ? true : AbstractC4492zt.d(obj, RecomposerKt.FramePending))) {
            if (obj != null) {
                throw new IllegalStateException(("invalid pendingFrameContinuation " + obj).toString());
            }
            this.pendingFrameContinuation = RecomposerKt.ProduceAnotherFrame;
        }
        return null;
    }

    public final void takeFrameRequestLocked() {
        if (this.pendingFrameContinuation != RecomposerKt.FramePending) {
            throw new IllegalStateException("frame not pending");
        }
        this.pendingFrameContinuation = null;
    }
}
