package defpackage;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: Lj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0720Lj implements InterfaceC0745Mj {
    public final Future a;

    public C0720Lj(Future future) {
        this.a = future;
    }

    @Override // defpackage.InterfaceC0745Mj
    public void dispose() {
        this.a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.a + ']';
    }
}
