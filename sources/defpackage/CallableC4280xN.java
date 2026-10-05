package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: xN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC4280xN extends J implements Callable {
    public CallableC4280xN(Runnable runnable, boolean z) {
        super(runnable, z);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.c = Thread.currentThread();
        try {
            try {
                this.a.run();
                return null;
            } finally {
                lazySet(J.d);
                this.c = null;
            }
        } catch (Throwable th) {
            FM.m(th);
            throw th;
        }
    }

    @Override // defpackage.J, java.util.concurrent.atomic.AtomicReference
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
