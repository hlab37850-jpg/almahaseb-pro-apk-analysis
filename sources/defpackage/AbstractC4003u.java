package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4003u extends AtomicInteger implements InterfaceC4071un, PS {
    public final NS a;
    public PS b;
    public volatile boolean c;
    public Throwable d;
    public volatile boolean e;
    public final AtomicLong f = new AtomicLong();
    public final AtomicReference g = new AtomicReference();

    public AbstractC4003u(NS ns) {
        this.a = ns;
    }

    @Override // defpackage.InterfaceC4071un
    public void a(PS ps) {
        if (RS.i(this.b, ps)) {
            this.b = ps;
            this.a.a(this);
            ps.l(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public boolean c(boolean z, boolean z2, NS ns, AtomicReference atomicReference) {
        if (this.e) {
            atomicReference.lazySet(null);
            return true;
        }
        if (!z) {
            return false;
        }
        Throwable th = this.d;
        if (th != null) {
            atomicReference.lazySet(null);
            ns.onError(th);
            return true;
        }
        if (!z2) {
            return false;
        }
        ns.onComplete();
        return true;
    }

    @Override // defpackage.PS
    public void cancel() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.cancel();
        if (getAndIncrement() == 0) {
            this.g.lazySet(null);
        }
    }

    public void e() {
        if (getAndIncrement() != 0) {
            return;
        }
        NS ns = this.a;
        AtomicLong atomicLong = this.f;
        AtomicReference atomicReference = this.g;
        int iAddAndGet = 1;
        do {
            long j = 0;
            while (true) {
                if (j == atomicLong.get()) {
                    break;
                }
                boolean z = this.c;
                Object andSet = atomicReference.getAndSet(null);
                boolean z2 = andSet == null;
                if (c(z, z2, ns, atomicReference)) {
                    return;
                }
                if (z2) {
                    break;
                }
                ns.b(andSet);
                j++;
            }
            if (j == atomicLong.get()) {
                if (c(this.c, atomicReference.get() == null, ns, atomicReference)) {
                    return;
                }
            }
            if (j != 0) {
                L6.c(atomicLong, j);
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // defpackage.PS
    public void l(long j) {
        if (RS.h(j)) {
            L6.a(this.f, j);
            e();
        }
    }

    @Override // defpackage.NS
    public void onComplete() {
        this.c = true;
        e();
    }

    @Override // defpackage.NS
    public void onError(Throwable th) {
        this.d = th;
        this.c = true;
        e();
    }
}
