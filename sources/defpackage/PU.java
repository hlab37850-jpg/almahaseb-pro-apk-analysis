package defpackage;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public final class PU implements Runnable {
    public final ListenableFuture a;
    public final InterfaceC4293xa b;

    public PU(ListenableFuture listenableFuture, InterfaceC4293xa interfaceC4293xa) {
        this.a = listenableFuture;
        this.b = interfaceC4293xa;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.isCancelled()) {
            InterfaceC4293xa.a.a(this.b, null, 1, null);
            return;
        }
        try {
            InterfaceC4293xa interfaceC4293xa = this.b;
            KL.a aVar = KL.a;
            interfaceC4293xa.resumeWith(KL.a(Uninterruptibles.getUninterruptibly(this.a)));
        } catch (ExecutionException e) {
            InterfaceC4293xa interfaceC4293xa2 = this.b;
            KL.a aVar2 = KL.a;
            interfaceC4293xa2.resumeWith(KL.a(LL.a(AbstractC1183Zv.c(e))));
        }
    }
}
