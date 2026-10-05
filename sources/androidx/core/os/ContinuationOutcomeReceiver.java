package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import defpackage.InterfaceC0793Of;
import defpackage.KL;
import defpackage.LL;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(31)
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    private final InterfaceC0793Of continuation;

    public ContinuationOutcomeReceiver(InterfaceC0793Of interfaceC0793Of) {
        super(false);
        this.continuation = interfaceC0793Of;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(E e) {
        if (compareAndSet(false, true)) {
            InterfaceC0793Of interfaceC0793Of = this.continuation;
            KL.a aVar = KL.a;
            interfaceC0793Of.resumeWith(KL.a(LL.a(e)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(KL.a(r));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
