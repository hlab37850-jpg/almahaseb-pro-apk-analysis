package defpackage;

import java.util.Objects;

/* JADX INFO: renamed from: on, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3586on extends N {
    public final InterfaceC0777Np c;

    /* JADX INFO: renamed from: on$a */
    public static final class a extends AbstractC3614p7 {
        public final InterfaceC0777Np f;

        public a(InterfaceC0792Oe interfaceC0792Oe, InterfaceC0777Np interfaceC0777Np) {
            super(interfaceC0792Oe);
            this.f = interfaceC0777Np;
        }

        @Override // defpackage.NS
        public void b(Object obj) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.b(null);
                return;
            }
            try {
                Object objApply = this.f.apply(obj);
                Objects.requireNonNull(objApply, "The mapper function returned a null value.");
                this.a.b(objApply);
            } catch (Throwable th) {
                f(th);
            }
        }

        @Override // defpackage.InterfaceC4283xQ
        public Object poll() {
            Object objPoll = this.c.poll();
            if (objPoll == null) {
                return null;
            }
            Object objApply = this.f.apply(objPoll);
            Objects.requireNonNull(objApply, "The mapper function returned a null value.");
            return objApply;
        }
    }

    /* JADX INFO: renamed from: on$b */
    public static final class b extends AbstractC3695q7 {
        public final InterfaceC0777Np f;

        public b(NS ns, InterfaceC0777Np interfaceC0777Np) {
            super(ns);
            this.f = interfaceC0777Np;
        }

        @Override // defpackage.NS
        public void b(Object obj) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.b(null);
                return;
            }
            try {
                Object objApply = this.f.apply(obj);
                Objects.requireNonNull(objApply, "The mapper function returned a null value.");
                this.a.b(objApply);
            } catch (Throwable th) {
                f(th);
            }
        }

        @Override // defpackage.InterfaceC4283xQ
        public Object poll() {
            Object objPoll = this.c.poll();
            if (objPoll == null) {
                return null;
            }
            Object objApply = this.f.apply(objPoll);
            Objects.requireNonNull(objApply, "The mapper function returned a null value.");
            return objApply;
        }
    }

    public C3586on(AbstractC3258kn abstractC3258kn, InterfaceC0777Np interfaceC0777Np) {
        super(abstractC3258kn);
        this.c = interfaceC0777Np;
    }

    @Override // defpackage.AbstractC3258kn
    public void n(NS ns) {
        if (ns instanceof InterfaceC0792Oe) {
            this.b.m(new a((InterfaceC0792Oe) ns, this.c));
        } else {
            this.b.m(new b(ns, this.c));
        }
    }
}
