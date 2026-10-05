package defpackage;

import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;

/* JADX INFO: renamed from: Yi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC1085Yi implements Runnable {
    public final /* synthetic */ DelayMetCommandHandler a;

    public /* synthetic */ RunnableC1085Yi(DelayMetCommandHandler delayMetCommandHandler) {
        this.a = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.stopWork();
    }
}
