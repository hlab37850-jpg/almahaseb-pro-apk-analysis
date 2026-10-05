package defpackage;

/* JADX INFO: renamed from: oE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3542oE extends AbstractC2157f0 {
    public final CH b;

    /* JADX INFO: renamed from: oE$a */
    public static final class a implements InterfaceC3866sE, InterfaceC0624Jj {
        public final InterfaceC3866sE a;
        public final CH b;
        public InterfaceC0624Jj c;

        public a(InterfaceC3866sE interfaceC3866sE, CH ch) {
            this.a = interfaceC3866sE;
            this.b = ch;
        }

        @Override // defpackage.InterfaceC3866sE
        public void a(InterfaceC0624Jj interfaceC0624Jj) {
            if (EnumC0771Nj.i(this.c, interfaceC0624Jj)) {
                this.c = interfaceC0624Jj;
                this.a.a(this);
            }
        }

        @Override // defpackage.InterfaceC3866sE
        public void b(Object obj) {
            this.a.b(obj);
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            this.c.dispose();
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // defpackage.InterfaceC3866sE
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // defpackage.InterfaceC3866sE
        public void onError(Throwable th) {
            try {
                if (this.b.test(th)) {
                    this.a.onComplete();
                } else {
                    this.a.onError(th);
                }
            } catch (Throwable th2) {
                AbstractC0722Ll.b(th2);
                this.a.onError(new C0441Ee(th, th2));
            }
        }
    }

    public C3542oE(InterfaceC3705qE interfaceC3705qE, CH ch) {
        super(interfaceC3705qE);
        this.b = ch;
    }

    @Override // defpackage.AbstractC3132jE
    public void l(InterfaceC3866sE interfaceC3866sE) {
        this.a.a(new a(interfaceC3866sE, this.b));
    }
}
