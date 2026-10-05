package androidx.core.util;

import androidx.annotation.RequiresApi;
import defpackage.InterfaceC0793Of;
import defpackage.KL;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {
    private final InterfaceC0793Of continuation;

    public ContinuationConsumer(InterfaceC0793Of interfaceC0793Of) {
        super(false);
        this.continuation = interfaceC0793Of;
    }

    @Override // java.util.function.Consumer
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
