package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: qn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3748qn extends N implements InterfaceC2295gf {
    public final InterfaceC2295gf c;

    /* JADX INFO: renamed from: qn$a */
    public static final class a extends AtomicLong implements InterfaceC4071un, PS {
        public final NS a;
        public final InterfaceC2295gf b;
        public PS c;
        public boolean d;

        public a(NS ns, InterfaceC2295gf interfaceC2295gf) {
            this.a = ns;
            this.b = interfaceC2295gf;
        }

        @Override // defpackage.InterfaceC4071un
        public void a(PS ps) {
            if (RS.i(this.c, ps)) {
                this.c = ps;
                this.a.a(this);
                ps.l(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        @Override // defpackage.NS
        public void b(Object obj) {
            if (this.d) {
                return;
            }
            if (get() != 0) {
                this.a.b(obj);
                L6.c(this, 1L);
                return;
            }
            try {
                this.b.accept(obj);
            } catch (Throwable th) {
                AbstractC0722Ll.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // defpackage.PS
        public void cancel() {
            this.c.cancel();
        }

        @Override // defpackage.PS
        public void l(long j) {
            if (RS.h(j)) {
                L6.a(this, j);
            }
        }

        @Override // defpackage.NS
        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.onComplete();
        }

        @Override // defpackage.NS
        public void onError(Throwable th) {
            if (this.d) {
                FM.m(th);
            } else {
                this.d = true;
                this.a.onError(th);
            }
        }
    }

    public C3748qn(AbstractC3258kn abstractC3258kn) {
        super(abstractC3258kn);
        this.c = this;
    }

    @Override // defpackage.AbstractC3258kn
    public void n(NS ns) {
        this.b.m(new a(ns, this.c));
    }

    @Override // defpackage.InterfaceC2295gf
    public void accept(Object obj) {
    }
}
