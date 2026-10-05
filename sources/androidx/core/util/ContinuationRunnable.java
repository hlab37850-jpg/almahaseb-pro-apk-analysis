package androidx.core.util;

import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.KL;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final InterfaceC0793Of continuation;

    public ContinuationRunnable(InterfaceC0793Of interfaceC0793Of) {
        super(false);
        this.continuation = interfaceC0793Of;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            InterfaceC0793Of interfaceC0793Of = this.continuation;
            KL.a aVar = KL.a;
            interfaceC0793Of.resumeWith(KL.a(FW.a));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
