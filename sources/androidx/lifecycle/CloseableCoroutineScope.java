package androidx.lifecycle;

import defpackage.AbstractC3511nu;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class CloseableCoroutineScope implements Closeable, InterfaceC2052dg {
    private final InterfaceC0988Vf coroutineContext;

    public CloseableCoroutineScope(InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        this.coroutineContext = interfaceC0988Vf;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC3511nu.e(getCoroutineContext(), null, 1, null);
    }

    @Override // defpackage.InterfaceC2052dg
    public InterfaceC0988Vf getCoroutineContext() {
        return this.coroutineContext;
    }
}
