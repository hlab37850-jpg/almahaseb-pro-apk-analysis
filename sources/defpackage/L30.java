package defpackage;

import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public final class L30 implements Runnable {
    public final Runnable a;

    public L30(Runnable runnable, int i) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.a.run();
    }
}
