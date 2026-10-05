package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: rn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3828rn extends N {

    /* JADX INFO: renamed from: rn$a */
    public static final class a extends AtomicLong implements InterfaceC4071un, PS {
        public final NS a;
        public PS b;
        public boolean c;

        public a(NS ns) {
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

        @Override // defpackage.NS
        public void b(Object obj) {
            if (this.c) {
                return;
            }
            if (get() != 0) {
                this.a.b(obj);
                L6.c(this, 1L);
            } else {
                this.b.cancel();
                onError(new VB("could not emit value due to lack of requests"));
            }
        }

        @Override // defpackage.PS
        public void cancel() {
            this.b.cancel();
        }

        @Override // defpackage.PS
        public void l(long j) {
            if (RS.h(j)) {
                L6.a(this, j);
            }
        }

        @Override // defpackage.NS
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.a.onComplete();
        }

        @Override // defpackage.NS
        public void onError(Throwable th) {
            if (this.c) {
                FM.m(th);
            } else {
                this.c = true;
                this.a.onError(th);
            }
        }
    }

    public C3828rn(AbstractC3258kn abstractC3258kn) {
        super(abstractC3258kn);
    }

    @Override // defpackage.AbstractC3258kn
    public void n(NS ns) {
        this.b.m(new a(ns));
    }
}
