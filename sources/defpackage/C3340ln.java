package defpackage;

/* JADX INFO: renamed from: ln, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3340ln extends AbstractC3258kn {
    public final InterfaceC3705qE b;

    public C3340ln(InterfaceC3705qE interfaceC3705qE) {
        this.b = interfaceC3705qE;
    }

    @Override // defpackage.AbstractC3258kn
    public void n(NS ns) {
        this.b.a(new a(ns));
    }

    /* JADX INFO: renamed from: ln$a */
    public static final class a implements InterfaceC3866sE, PS {
        public final NS a;
        public InterfaceC0624Jj b;

        public a(NS ns) {
            this.a = ns;
        }

        @Override // defpackage.InterfaceC3866sE
        public void a(InterfaceC0624Jj interfaceC0624Jj) {
            this.b = interfaceC0624Jj;
            this.a.a(this);
        }

        @Override // defpackage.InterfaceC3866sE
        public void b(Object obj) {
            this.a.b(obj);
        }

        @Override // defpackage.PS
        public void cancel() {
            this.b.dispose();
        }

        @Override // defpackage.InterfaceC3866sE
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // defpackage.InterfaceC3866sE
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // defpackage.PS
        public void l(long j) {
        }
    }
}
