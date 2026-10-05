package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class Ac0 implements Runnable {
    public final /* synthetic */ C4381yd0 a;

    public Ac0(C4381yd0 c4381yd0) {
        this.a = c4381yd0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a.b) {
            try {
                C4381yd0 c4381yd0 = this.a;
                if (c4381yd0.c != null) {
                    c4381yd0.c.onCanceled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
