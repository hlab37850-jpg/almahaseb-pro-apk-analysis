package defpackage;

/* JADX INFO: renamed from: wM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4198wM extends PJ {
    public C4198wM(Runnable runnable) {
        super(runnable);
    }

    @Override // defpackage.PJ
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
