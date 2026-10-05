package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class Z5 extends AtomicReference {
    public Throwable a() {
        return AbstractC0696Kl.e(this);
    }

    public boolean b(Throwable th) {
        return AbstractC0696Kl.a(this, th);
    }

    public boolean c(Throwable th) {
        if (b(th)) {
            return true;
        }
        FM.m(th);
        return false;
    }

    public void e(NS ns) {
        Throwable thA = a();
        if (thA == null) {
            ns.onComplete();
        } else if (thA != AbstractC0696Kl.a) {
            ns.onError(thA);
        }
    }
}
