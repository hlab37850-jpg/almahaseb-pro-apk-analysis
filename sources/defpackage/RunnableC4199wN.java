package defpackage;

/* JADX INFO: renamed from: wN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4199wN extends J implements Runnable {
    public RunnableC4199wN(Runnable runnable, boolean z) {
        super(runnable, z);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c = Thread.currentThread();
        try {
            this.a.run();
            this.c = null;
        } catch (Throwable th) {
            dispose();
            this.c = null;
            FM.m(th);
            throw th;
        }
    }

    @Override // defpackage.J, java.util.concurrent.atomic.AtomicReference
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
