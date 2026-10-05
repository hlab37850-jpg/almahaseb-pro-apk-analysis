package androidx.core.util;

import defpackage.InterfaceC0793Of;
import defpackage.KL;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final InterfaceC0793Of continuation;

    public AndroidXContinuationConsumer(InterfaceC0793Of interfaceC0793Of) {
        super(false);
        this.continuation = interfaceC0793Of;
    }

    @Override // androidx.core.util.Consumer
    public void accept(T t) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(KL.a(t));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
