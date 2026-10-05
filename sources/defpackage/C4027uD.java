package defpackage;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: uD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4027uD extends AN {
    public static final IM b = new IM("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));
    public final ThreadFactory a;

    public C4027uD() {
        this(b);
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        return new C4108vD(this.a);
    }

    public C4027uD(ThreadFactory threadFactory) {
        this.a = threadFactory;
    }
}
