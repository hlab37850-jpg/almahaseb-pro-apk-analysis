package defpackage;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: ta, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3969ta extends AbstractC4050ua {
    public final Future a;

    public C3969ta(Future future) {
        this.a = future;
    }

    @Override // defpackage.AbstractC4131va
    public void a(Throwable th) {
        if (th != null) {
            this.a.cancel(false);
        }
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return FW.a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }
}
