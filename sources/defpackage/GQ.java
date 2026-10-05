package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class GQ extends BQ {
    public final IQ a;
    public final InterfaceC0777Np b;
    public final Object c;

    public final class a implements FQ {
        public final FQ a;

        public a(FQ fq) {
            this.a = fq;
        }

        @Override // defpackage.FQ
        public void a(InterfaceC0624Jj interfaceC0624Jj) {
            this.a.a(interfaceC0624Jj);
        }

        @Override // defpackage.FQ
        public void onError(Throwable th) {
            Object objApply;
            GQ gq = GQ.this;
            InterfaceC0777Np interfaceC0777Np = gq.b;
            if (interfaceC0777Np != null) {
                try {
                    objApply = interfaceC0777Np.apply(th);
                } catch (Throwable th2) {
                    AbstractC0722Ll.b(th2);
                    this.a.onError(new C0441Ee(th, th2));
                    return;
                }
            } else {
                objApply = gq.c;
            }
            if (objApply != null) {
                this.a.onSuccess(objApply);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
            nullPointerException.initCause(th);
            this.a.onError(nullPointerException);
        }

        @Override // defpackage.FQ
        public void onSuccess(Object obj) {
            this.a.onSuccess(obj);
        }
    }

    public GQ(IQ iq, InterfaceC0777Np interfaceC0777Np, Object obj) {
        this.a = iq;
        this.b = interfaceC0777Np;
        this.c = obj;
    }

    @Override // defpackage.BQ
    public void f(FQ fq) {
        this.a.a(new a(fq));
    }
}
