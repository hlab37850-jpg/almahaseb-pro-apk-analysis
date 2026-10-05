package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: gS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2277gS extends AtomicInteger implements InterfaceC4071un, PS {
    public final NS a;
    public final Z5 b = new Z5();
    public final AtomicLong c = new AtomicLong();
    public final AtomicReference d = new AtomicReference();
    public final AtomicBoolean e = new AtomicBoolean();
    public volatile boolean f;

    public C2277gS(NS ns) {
        this.a = ns;
    }

    @Override // defpackage.InterfaceC4071un
    public void a(PS ps) {
        if (this.e.compareAndSet(false, true)) {
            this.a.a(this);
            RS.c(this.d, this.c, ps);
        } else {
            ps.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // defpackage.NS
    public void b(Object obj) {
        AbstractC1745ar.c(this.a, obj, this, this.b);
    }

    @Override // defpackage.PS
    public void cancel() {
        if (this.f) {
            return;
        }
        RS.a(this.d);
    }

    @Override // defpackage.PS
    public void l(long j) {
        if (j > 0) {
            RS.b(this.d, this.c, j);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
    }

    @Override // defpackage.NS
    public void onComplete() {
        this.f = true;
        AbstractC1745ar.a(this.a, this, this.b);
    }

    @Override // defpackage.NS
    public void onError(Throwable th) {
        this.f = true;
        AbstractC1745ar.b(this.a, th, this, this.b);
    }
}
