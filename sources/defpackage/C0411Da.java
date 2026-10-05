package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: Da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0411Da extends C2129ee {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(C0411Da.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    public C0411Da(InterfaceC0793Of interfaceC0793Of, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + interfaceC0793Of + " was cancelled normally");
        }
        super(th, z);
        this._resumed = 0;
    }

    public final boolean c() {
        return c.compareAndSet(this, 0, 1);
    }
}
